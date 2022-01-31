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

public class aenc
{
  private static int a(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd50.ExtSnsFrdData paramExtSnsFrdData)
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
          bool2 = athl.a(paramExtSnsFrdData.bytes_music_switch.get().toByteArray());
        }
        if (paramExtSnsFrdData.bytes_ksing_switch.has()) {
          bool1 = ataq.a(paramExtSnsFrdData.bytes_ksing_switch.get().toByteArray());
        }
        bool4 = bool2;
        bool3 = bool1;
        if (paramExtSnsFrdData.bytes_lbs_share.has())
        {
          bool4 = atpv.a(paramQQAppInterface, paramExtSnsFrdData.bytes_lbs_share);
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
        atpu.a(paramQQAppInterface, 0, paramString, bool4);
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
            auou.a(paramQQAppInterface, paramaloz, paramFriends, paramString, paramExtSnsFrdData.bytes_mutualmark_alienation.get().toByteArray(), false);
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
  
  public static void a(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (paramaend.jdField_b_of_type_Aeng != null) {}
    switch (paramaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int)
    {
    default: 
      if (auoj.b(paramaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int)) {
        auoc.a(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
      }
      return;
    }
    auou.a(paramQQAppInterface, paramaloz, paramFriends, paramaend.jdField_b_of_type_JavaLangString, paramaend.jdField_b_of_type_Aeng.jdField_a_of_type_ArrayOfByte, true);
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
      aloz localaloz = (aloz)paramQQAppInterface.getManager(51);
      Object localObject2 = localaloz.a(str);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = str;
      }
      localObject2 = localaloz.e(str);
      i = a(paramQQAppInterface, localaloz, (Friends)localObject2, (ExtensionInfo)localObject1, str, paramExtSnsFrdData);
      if ((localObject1 != null) && ((i & 0x1) != 0)) {
        localaloz.a((ExtensionInfo)localObject1);
      }
      if ((localObject2 != null) && ((i & 0x2) != 0))
      {
        localaloz.a((Friends)localObject2);
        paramQQAppInterface.a(1).notifyUI(3, true, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ExtSnsFrdDataHandlerHelper", 1, "handleGet0x5e0ExtSnsFrdData uin:" + str + " changeType:" + i);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, amgu paramamgu)
  {
    if ((paramQQAppInterface == null) || (paramRelationalChainChange == null) || (paramamgu == null)) {}
    aend localaend;
    do
    {
      return;
      localaend = aend.a(paramRelationalChainChange, paramamgu.a);
    } while ((!TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), localaend.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localaend.jdField_b_of_type_JavaLangString)));
    aloz localaloz = (aloz)paramQQAppInterface.getManager(51);
    Friends localFriends = localaloz.e(localaend.jdField_b_of_type_JavaLangString);
    ExtensionInfo localExtensionInfo = localaloz.a(localaend.jdField_b_of_type_JavaLangString);
    paramRelationalChainChange = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramRelationalChainChange = new ExtensionInfo();
      paramRelationalChainChange.uin = localaend.jdField_b_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtSnsFrdDataHandlerHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 msginfo:" + paramamgu + "changePushInfo:" + localaend);
    }
    switch (localaend.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(paramQQAppInterface, localaloz, localFriends, paramRelationalChainChange, localaend, paramamgu);
      return;
    case 2: 
      b(paramQQAppInterface, localaloz, localFriends, paramRelationalChainChange, localaend, paramamgu);
      return;
    case 3: 
      c(paramQQAppInterface, localaloz, localFriends, paramRelationalChainChange, localaend, paramamgu);
      return;
    case 10001: 
      d(paramQQAppInterface, localaloz, localFriends, paramRelationalChainChange, localaend, paramamgu);
      return;
    case 10002: 
      e(paramQQAppInterface, localaloz, localFriends, paramRelationalChainChange, localaend, paramamgu);
      return;
    case 10003: 
      f(paramQQAppInterface, localaloz, localFriends, paramRelationalChainChange, localaend, paramamgu);
      return;
    case 10004: 
      g(paramQQAppInterface, localaloz, localFriends, paramRelationalChainChange, localaend, paramamgu);
      return;
    case 10005: 
      h(paramQQAppInterface, localaloz, localFriends, paramRelationalChainChange, localaend, paramamgu);
      return;
    case 11000: 
      i(paramQQAppInterface, localaloz, localFriends, paramRelationalChainChange, localaend, paramamgu);
      return;
    case 11001: 
      j(paramQQAppInterface, localaloz, localFriends, paramRelationalChainChange, localaend, paramamgu);
      return;
    case 11002: 
      k(paramQQAppInterface, localaloz, localFriends, paramRelationalChainChange, localaend, paramamgu);
      return;
    }
    l(paramQQAppInterface, localaloz, localFriends, paramRelationalChainChange, localaend, paramamgu);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, byte[] paramArrayOfByte)
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
        j = a(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramString, paramArrayOfByte);
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
  
  public static void b(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (paramaend.jdField_a_of_type_Aeng != null)
    {
      int i = paramaend.jdField_a_of_type_Aeng.jdField_a_of_type_Int;
      if (auoj.b(paramaend.jdField_a_of_type_Aeng.jdField_a_of_type_Int)) {
        auoc.b(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
      }
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (paramaend.jdField_b_of_type_Aeng != null) {}
    switch (paramaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int)
    {
    default: 
      if (auoj.b(paramaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int)) {
        auoc.c(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
      }
      return;
    }
    auou.a(paramQQAppInterface, paramaloz, paramFriends, paramaend.jdField_b_of_type_JavaLangString, paramaend.jdField_b_of_type_Aeng.jdField_a_of_type_ArrayOfByte, true);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (paramaend.jdField_b_of_type_Aeng != null)
    {
      int i = paramaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int;
      if (auoj.b(paramaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int)) {
        auoc.d(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
      }
    }
  }
  
  public static void e(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (paramaend.jdField_b_of_type_Aeng != null)
    {
      int i = paramaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int;
      if (auoj.b(paramaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int)) {
        auoc.e(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
      }
    }
  }
  
  public static void f(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (paramaend.jdField_b_of_type_Aeng != null)
    {
      int i = paramaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int;
      if (auoj.b(paramaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int)) {
        auoc.f(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
      }
    }
  }
  
  public static void g(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (paramaend.jdField_b_of_type_Aeng != null)
    {
      int i = paramaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int;
      if (auoj.b(paramaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int)) {
        auoc.g(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
      }
    }
  }
  
  public static void h(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (paramaend.jdField_b_of_type_Aeng != null)
    {
      int i = paramaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int;
      if (auoj.b(paramaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int)) {
        auoc.h(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
      }
    }
  }
  
  public static void i(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if ((paramaend.jdField_b_of_type_Aeng != null) || (paramaend.jdField_a_of_type_JavaUtilArrayList != null)) {
      auoc.i(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
    }
  }
  
  public static void j(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if ((paramaend.jdField_b_of_type_Aeng != null) || (paramaend.jdField_a_of_type_JavaUtilArrayList != null)) {
      auoc.j(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
    }
  }
  
  public static void k(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if ((paramaend.jdField_b_of_type_Aeng != null) || (paramaend.jdField_a_of_type_JavaUtilArrayList != null)) {
      auoc.k(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
    }
  }
  
  public static void l(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (paramaend.jdField_b_of_type_Aeng != null) {
      auoc.l(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aenc
 * JD-Core Version:    0.7.0.1
 */