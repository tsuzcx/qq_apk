import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50.ExtSnsFrdData;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;

public class acld
{
  private static int a(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd50.ExtSnsFrdData paramExtSnsFrdData)
  {
    int j = 0;
    boolean bool5 = false;
    boolean bool2 = false;
    boolean bool6 = false;
    boolean bool1 = false;
    boolean bool4 = bool5;
    boolean bool3 = bool6;
    if (paramFriends != null)
    {
      bool4 = bool5;
      bool3 = bool6;
      if (paramFriends.isFriend())
      {
        if (paramExtSnsFrdData.bytes_music_switch.has()) {
          bool2 = aquy.a(paramExtSnsFrdData.bytes_music_switch.get().toByteArray());
        }
        if (paramExtSnsFrdData.bytes_ksing_switch.has()) {
          bool1 = aqpv.a(paramExtSnsFrdData.bytes_ksing_switch.get().toByteArray());
        }
        bool4 = bool2;
        bool3 = bool1;
        if (paramExtSnsFrdData.bytes_lbs_share.has())
        {
          bool4 = ardf.a(paramQQAppInterface, paramExtSnsFrdData.bytes_lbs_share);
          bool3 = bool1;
        }
      }
    }
    for (bool1 = bool4;; bool1 = false)
    {
      if (paramExtensionInfo.isTogetherBusinessOpen(16777216) != bool3)
      {
        paramExtensionInfo.setTogetherBusiness(bool3, 16777216);
        j = 1;
      }
      int i = j;
      if (paramExtensionInfo.isListenTogetherOpen != bool2)
      {
        paramExtensionInfo.isListenTogetherOpen = bool2;
        i = j | 0x1;
      }
      if (paramExtensionInfo.isSharingLocation == 1)
      {
        bool4 = true;
        if (bool4 == bool1) {
          break label542;
        }
        if (!bool1) {
          break label480;
        }
        j = 1;
        label207:
        paramExtensionInfo.isSharingLocation = j;
        if (paramExtensionInfo.isSharingLocation != 1) {
          break label486;
        }
        bool4 = true;
        label224:
        arde.a(paramQQAppInterface, 0, paramString, bool4);
        if (QLog.isColorLevel()) {
          QLog.d("ExtSnsFrdDataHandlerHelper", 2, new Object[] { "handleExtSnsFrdData: invoked. update ei & msg data ", " isSharingLbs: ", Boolean.valueOf(bool1) });
        }
        i |= 0x1;
      }
      label542:
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("handleExtSnsFrdData friendUin:").append(paramString).append(" newIsOpen:").append(bool2).append(" oldIsOpen").append(paramExtensionInfo.isListenTogetherOpen).append(" is_sing_together=").append(bool3).append(" isSharingLocation: ").append(paramExtensionInfo.isSharingLocation).append(" friend:");
          if (paramFriends != null)
          {
            paramExtensionInfo = Boolean.valueOf(paramFriends.isFriend());
            label359:
            QLog.d("ExtSnsFrdDataHandlerHelper", 1, paramExtensionInfo);
          }
        }
        else
        {
          j = i;
          if (paramFriends != null)
          {
            if (!paramExtSnsFrdData.bytes_mutualmark_alienation.has()) {
              break label498;
            }
            asbr.a(paramQQAppInterface, paramajjj, paramFriends, paramString, paramExtSnsFrdData.bytes_mutualmark_alienation.get().toByteArray(), false);
            i |= 0x2;
            j = i;
            if (QLog.isColorLevel())
            {
              QLog.d("ExtSnsFrdDataHandlerHelper", 1, "handleExtSnsFrdData friendUin:" + paramString + " relationIconFlag" + paramFriends.relationIconFlag);
              j = i;
            }
          }
        }
        label480:
        label486:
        label498:
        do
        {
          return j;
          bool4 = false;
          break;
          j = 0;
          break label207;
          bool4 = false;
          break label224;
          paramExtensionInfo = "null";
          break label359;
          j = i;
        } while (!QLog.isColorLevel());
        QLog.e("ExtSnsFrdDataHandlerHelper", 2, "handleExtSnsFrdData ExtSnsFrdData  friendUin:" + paramString + " doesn't has bytes_mutualmark_alienation");
        return i;
      }
      bool2 = bool4;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (paramacle.jdField_b_of_type_Aclh != null) {}
    switch (paramacle.jdField_b_of_type_Aclh.jdField_a_of_type_Int)
    {
    default: 
      if (asbg.b(paramacle.jdField_b_of_type_Aclh.jdField_a_of_type_Int)) {
        asaz.a(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
      }
      return;
    }
    asbr.a(paramQQAppInterface, paramajjj, paramFriends, paramacle.jdField_b_of_type_JavaLangString, paramacle.jdField_b_of_type_Aclh.jdField_a_of_type_ArrayOfByte, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Oidb_0xd50.ExtSnsFrdData paramExtSnsFrdData)
  {
    if (paramExtSnsFrdData == null) {}
    String str;
    int i;
    do
    {
      long l;
      do
      {
        return;
        l = paramExtSnsFrdData.frd_uin.get();
      } while (l <= 0L);
      str = String.valueOf(l);
      ajjj localajjj = (ajjj)paramQQAppInterface.getManager(51);
      Object localObject2 = localajjj.a(str);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = str;
      }
      localObject2 = localajjj.e(str);
      i = a(paramQQAppInterface, localajjj, (Friends)localObject2, (ExtensionInfo)localObject1, str, paramExtSnsFrdData);
      if ((localObject1 != null) && ((i & 0x1) != 0)) {
        localajjj.a((ExtensionInfo)localObject1);
      }
      if ((localObject2 != null) && ((i & 0x2) != 0))
      {
        localajjj.a((Friends)localObject2);
        paramQQAppInterface.a(1).notifyUI(3, true, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ExtSnsFrdDataHandlerHelper", 1, "handleGet0x5e0ExtSnsFrdData uin:" + str + " changeType:" + i);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, akcb paramakcb)
  {
    if ((paramQQAppInterface == null) || (paramRelationalChainChange == null) || (paramakcb == null)) {}
    acle localacle;
    do
    {
      return;
      localacle = acle.a(paramRelationalChainChange, paramakcb.a);
    } while ((!TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), localacle.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localacle.jdField_b_of_type_JavaLangString)));
    ajjj localajjj = (ajjj)paramQQAppInterface.getManager(51);
    Friends localFriends = localajjj.e(localacle.jdField_b_of_type_JavaLangString);
    ExtensionInfo localExtensionInfo = localajjj.a(localacle.jdField_b_of_type_JavaLangString);
    paramRelationalChainChange = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramRelationalChainChange = new ExtensionInfo();
      paramRelationalChainChange.uin = localacle.jdField_b_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtSnsFrdDataHandlerHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 msginfo:" + paramakcb + "changePushInfo:" + localacle);
    }
    switch (localacle.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(paramQQAppInterface, localajjj, localFriends, paramRelationalChainChange, localacle, paramakcb);
      return;
    case 2: 
      b(paramQQAppInterface, localajjj, localFriends, paramRelationalChainChange, localacle, paramakcb);
      return;
    case 3: 
      c(paramQQAppInterface, localajjj, localFriends, paramRelationalChainChange, localacle, paramakcb);
      return;
    case 10001: 
      d(paramQQAppInterface, localajjj, localFriends, paramRelationalChainChange, localacle, paramakcb);
      return;
    case 10002: 
      e(paramQQAppInterface, localajjj, localFriends, paramRelationalChainChange, localacle, paramakcb);
      return;
    case 10003: 
      f(paramQQAppInterface, localajjj, localFriends, paramRelationalChainChange, localacle, paramakcb);
      return;
    case 10004: 
      g(paramQQAppInterface, localajjj, localFriends, paramRelationalChainChange, localacle, paramakcb);
      return;
    case 10005: 
      h(paramQQAppInterface, localajjj, localFriends, paramRelationalChainChange, localacle, paramakcb);
      return;
    case 11000: 
      i(paramQQAppInterface, localajjj, localFriends, paramRelationalChainChange, localacle, paramakcb);
      return;
    case 11001: 
      j(paramQQAppInterface, localajjj, localFriends, paramRelationalChainChange, localacle, paramakcb);
      return;
    case 11002: 
      k(paramQQAppInterface, localajjj, localFriends, paramRelationalChainChange, localacle, paramakcb);
      return;
    }
    l(paramQQAppInterface, localajjj, localFriends, paramRelationalChainChange, localacle, paramakcb);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      Oidb_0xd50.ExtSnsFrdData localExtSnsFrdData = new Oidb_0xd50.ExtSnsFrdData();
      try
      {
        localExtSnsFrdData.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = localExtSnsFrdData;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramArrayOfByte = null;
          localException.printStackTrace();
        }
        j = a(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramString, paramArrayOfByte);
        i = j;
        if (!QLog.isColorLevel()) {
          break label116;
        }
        QLog.d("ExtSnsFrdDataHandlerHelper", 1, "handleGetExtSnsFrdData uin:" + paramString + " changeType:" + j);
        i = j;
      }
      if (paramArrayOfByte == null) {
        return false;
      }
    }
    for (;;)
    {
      int j;
      label116:
      if (i != 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      int i = 0;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (paramacle.jdField_a_of_type_Aclh != null)
    {
      int i = paramacle.jdField_a_of_type_Aclh.jdField_a_of_type_Int;
      if (asbg.b(paramacle.jdField_a_of_type_Aclh.jdField_a_of_type_Int)) {
        asaz.b(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
      }
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (paramacle.jdField_b_of_type_Aclh != null) {}
    switch (paramacle.jdField_b_of_type_Aclh.jdField_a_of_type_Int)
    {
    default: 
      if (asbg.b(paramacle.jdField_b_of_type_Aclh.jdField_a_of_type_Int)) {
        asaz.c(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
      }
      return;
    }
    asbr.a(paramQQAppInterface, paramajjj, paramFriends, paramacle.jdField_b_of_type_JavaLangString, paramacle.jdField_b_of_type_Aclh.jdField_a_of_type_ArrayOfByte, true);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (paramacle.jdField_b_of_type_Aclh != null)
    {
      int i = paramacle.jdField_b_of_type_Aclh.jdField_a_of_type_Int;
      if (asbg.b(paramacle.jdField_b_of_type_Aclh.jdField_a_of_type_Int)) {
        asaz.d(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
      }
    }
  }
  
  public static void e(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (paramacle.jdField_b_of_type_Aclh != null)
    {
      int i = paramacle.jdField_b_of_type_Aclh.jdField_a_of_type_Int;
      if (asbg.b(paramacle.jdField_b_of_type_Aclh.jdField_a_of_type_Int)) {
        asaz.e(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
      }
    }
  }
  
  public static void f(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (paramacle.jdField_b_of_type_Aclh != null)
    {
      int i = paramacle.jdField_b_of_type_Aclh.jdField_a_of_type_Int;
      if (asbg.b(paramacle.jdField_b_of_type_Aclh.jdField_a_of_type_Int)) {
        asaz.f(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
      }
    }
  }
  
  public static void g(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (paramacle.jdField_b_of_type_Aclh != null)
    {
      int i = paramacle.jdField_b_of_type_Aclh.jdField_a_of_type_Int;
      if (asbg.b(paramacle.jdField_b_of_type_Aclh.jdField_a_of_type_Int)) {
        asaz.g(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
      }
    }
  }
  
  public static void h(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (paramacle.jdField_b_of_type_Aclh != null)
    {
      int i = paramacle.jdField_b_of_type_Aclh.jdField_a_of_type_Int;
      if (asbg.b(paramacle.jdField_b_of_type_Aclh.jdField_a_of_type_Int)) {
        asaz.h(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
      }
    }
  }
  
  public static void i(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if ((paramacle.jdField_b_of_type_Aclh != null) || (paramacle.jdField_a_of_type_JavaUtilArrayList != null)) {
      asaz.i(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
    }
  }
  
  public static void j(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if ((paramacle.jdField_b_of_type_Aclh != null) || (paramacle.jdField_a_of_type_JavaUtilArrayList != null)) {
      asaz.j(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
    }
  }
  
  public static void k(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if ((paramacle.jdField_b_of_type_Aclh != null) || (paramacle.jdField_a_of_type_JavaUtilArrayList != null)) {
      asaz.k(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
    }
  }
  
  public static void l(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (paramacle.jdField_b_of_type_Aclh != null) {
      asaz.l(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acld
 * JD-Core Version:    0.7.0.1
 */