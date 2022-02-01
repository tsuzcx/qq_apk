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

public class afyc
{
  private static int a(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd50.ExtSnsFrdData paramExtSnsFrdData)
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
          bool2 = avst.a(paramExtSnsFrdData.bytes_music_switch.get().toByteArray());
        }
        if (paramExtSnsFrdData.bytes_ksing_switch.has()) {
          bool1 = avlp.a(paramExtSnsFrdData.bytes_ksing_switch.get().toByteArray());
        }
        bool4 = bool2;
        bool3 = bool1;
        if (paramExtSnsFrdData.bytes_lbs_share.has())
        {
          bool4 = awbi.a(paramQQAppInterface, paramExtSnsFrdData.bytes_lbs_share);
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
        awbh.a(paramQQAppInterface, 0, paramString, bool4);
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
            axaj.a(paramQQAppInterface, paramanmw, paramFriends, paramString, paramExtSnsFrdData.bytes_mutualmark_alienation.get().toByteArray(), false);
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
  
  public static void a(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (paramafyd.jdField_b_of_type_Afyg != null) {}
    switch (paramafyd.jdField_b_of_type_Afyg.jdField_a_of_type_Int)
    {
    default: 
      if (awzy.b(paramafyd.jdField_b_of_type_Afyg.jdField_a_of_type_Int)) {
        awzr.a(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
      }
      return;
    }
    axaj.a(paramQQAppInterface, paramanmw, paramFriends, paramafyd.jdField_b_of_type_JavaLangString, paramafyd.jdField_b_of_type_Afyg.jdField_a_of_type_ArrayOfByte, true);
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
      anmw localanmw = (anmw)paramQQAppInterface.getManager(51);
      Object localObject2 = localanmw.a(str);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = str;
      }
      localObject2 = localanmw.e(str);
      i = a(paramQQAppInterface, localanmw, (Friends)localObject2, (ExtensionInfo)localObject1, str, paramExtSnsFrdData);
      if ((localObject1 != null) && ((i & 0x1) != 0)) {
        localanmw.a((ExtensionInfo)localObject1);
      }
      if ((localObject2 != null) && ((i & 0x2) != 0))
      {
        localanmw.a((Friends)localObject2);
        paramQQAppInterface.a(1).notifyUI(3, true, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ExtSnsFrdDataHandlerHelper", 1, "handleGet0x5e0ExtSnsFrdData uin:" + str + " changeType:" + i);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, aofx paramaofx)
  {
    if ((paramQQAppInterface == null) || (paramRelationalChainChange == null) || (paramaofx == null)) {}
    afyd localafyd;
    do
    {
      return;
      localafyd = afyd.a(paramRelationalChainChange, paramaofx.a);
    } while ((!TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), localafyd.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localafyd.jdField_b_of_type_JavaLangString)));
    anmw localanmw = (anmw)paramQQAppInterface.getManager(51);
    Friends localFriends = localanmw.e(localafyd.jdField_b_of_type_JavaLangString);
    ExtensionInfo localExtensionInfo = localanmw.a(localafyd.jdField_b_of_type_JavaLangString);
    paramRelationalChainChange = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramRelationalChainChange = new ExtensionInfo();
      paramRelationalChainChange.uin = localafyd.jdField_b_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtSnsFrdDataHandlerHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 msginfo:" + paramaofx + "changePushInfo:" + localafyd);
    }
    switch (localafyd.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(paramQQAppInterface, localanmw, localFriends, paramRelationalChainChange, localafyd, paramaofx);
      return;
    case 2: 
      b(paramQQAppInterface, localanmw, localFriends, paramRelationalChainChange, localafyd, paramaofx);
      return;
    case 3: 
      c(paramQQAppInterface, localanmw, localFriends, paramRelationalChainChange, localafyd, paramaofx);
      return;
    case 10001: 
      d(paramQQAppInterface, localanmw, localFriends, paramRelationalChainChange, localafyd, paramaofx);
      return;
    case 10002: 
      e(paramQQAppInterface, localanmw, localFriends, paramRelationalChainChange, localafyd, paramaofx);
      return;
    case 10003: 
      f(paramQQAppInterface, localanmw, localFriends, paramRelationalChainChange, localafyd, paramaofx);
      return;
    case 10004: 
      g(paramQQAppInterface, localanmw, localFriends, paramRelationalChainChange, localafyd, paramaofx);
      return;
    case 10005: 
      h(paramQQAppInterface, localanmw, localFriends, paramRelationalChainChange, localafyd, paramaofx);
      return;
    case 11000: 
      i(paramQQAppInterface, localanmw, localFriends, paramRelationalChainChange, localafyd, paramaofx);
      return;
    case 11001: 
      j(paramQQAppInterface, localanmw, localFriends, paramRelationalChainChange, localafyd, paramaofx);
      return;
    case 11002: 
      k(paramQQAppInterface, localanmw, localFriends, paramRelationalChainChange, localafyd, paramaofx);
      return;
    }
    l(paramQQAppInterface, localanmw, localFriends, paramRelationalChainChange, localafyd, paramaofx);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, byte[] paramArrayOfByte)
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
        j = a(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramString, paramArrayOfByte);
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
  
  public static void b(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (paramafyd.jdField_a_of_type_Afyg != null)
    {
      int i = paramafyd.jdField_a_of_type_Afyg.jdField_a_of_type_Int;
      if (awzy.b(paramafyd.jdField_a_of_type_Afyg.jdField_a_of_type_Int)) {
        awzr.b(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
      }
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (paramafyd.jdField_b_of_type_Afyg != null) {}
    switch (paramafyd.jdField_b_of_type_Afyg.jdField_a_of_type_Int)
    {
    default: 
      if (awzy.b(paramafyd.jdField_b_of_type_Afyg.jdField_a_of_type_Int)) {
        awzr.c(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
      }
      return;
    }
    axaj.a(paramQQAppInterface, paramanmw, paramFriends, paramafyd.jdField_b_of_type_JavaLangString, paramafyd.jdField_b_of_type_Afyg.jdField_a_of_type_ArrayOfByte, true);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (paramafyd.jdField_b_of_type_Afyg != null)
    {
      int i = paramafyd.jdField_b_of_type_Afyg.jdField_a_of_type_Int;
      if (awzy.b(paramafyd.jdField_b_of_type_Afyg.jdField_a_of_type_Int)) {
        awzr.d(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
      }
    }
  }
  
  public static void e(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (paramafyd.jdField_b_of_type_Afyg != null)
    {
      int i = paramafyd.jdField_b_of_type_Afyg.jdField_a_of_type_Int;
      if (awzy.b(paramafyd.jdField_b_of_type_Afyg.jdField_a_of_type_Int)) {
        awzr.e(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
      }
    }
  }
  
  public static void f(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (paramafyd.jdField_b_of_type_Afyg != null)
    {
      int i = paramafyd.jdField_b_of_type_Afyg.jdField_a_of_type_Int;
      if (awzy.b(paramafyd.jdField_b_of_type_Afyg.jdField_a_of_type_Int)) {
        awzr.f(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
      }
    }
  }
  
  public static void g(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (paramafyd.jdField_b_of_type_Afyg != null)
    {
      int i = paramafyd.jdField_b_of_type_Afyg.jdField_a_of_type_Int;
      if (awzy.b(paramafyd.jdField_b_of_type_Afyg.jdField_a_of_type_Int)) {
        awzr.g(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
      }
    }
  }
  
  public static void h(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (paramafyd.jdField_b_of_type_Afyg != null)
    {
      int i = paramafyd.jdField_b_of_type_Afyg.jdField_a_of_type_Int;
      if (awzy.b(paramafyd.jdField_b_of_type_Afyg.jdField_a_of_type_Int)) {
        awzr.h(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
      }
    }
  }
  
  public static void i(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if ((paramafyd.jdField_b_of_type_Afyg != null) || (paramafyd.jdField_a_of_type_JavaUtilArrayList != null)) {
      awzr.i(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
    }
  }
  
  public static void j(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if ((paramafyd.jdField_b_of_type_Afyg != null) || (paramafyd.jdField_a_of_type_JavaUtilArrayList != null)) {
      awzr.j(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
    }
  }
  
  public static void k(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if ((paramafyd.jdField_b_of_type_Afyg != null) || (paramafyd.jdField_a_of_type_JavaUtilArrayList != null)) {
      awzr.k(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
    }
  }
  
  public static void l(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (paramafyd.jdField_b_of_type_Afyg != null) {
      awzr.l(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyc
 * JD-Core Version:    0.7.0.1
 */