import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50.ExtSnsFrdData;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;

public class afas
{
  private static int a(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd50.ExtSnsFrdData paramExtSnsFrdData)
  {
    int j = 0;
    boolean bool7 = false;
    boolean bool2 = false;
    boolean bool8 = false;
    boolean bool1 = false;
    boolean bool9 = false;
    boolean bool3 = false;
    boolean bool6 = bool7;
    boolean bool5 = bool8;
    boolean bool4 = bool9;
    if (paramFriends != null)
    {
      bool6 = bool7;
      bool5 = bool8;
      bool4 = bool9;
      if (paramFriends.isFriend())
      {
        if (paramExtSnsFrdData.bytes_music_switch.has()) {
          bool2 = auyq.a(paramExtSnsFrdData.bytes_music_switch.get().toByteArray());
        }
        if (paramExtSnsFrdData.bytes_ksing_switch.has()) {
          bool1 = aura.a(paramExtSnsFrdData.bytes_ksing_switch.get().toByteArray());
        }
        if (paramExtSnsFrdData.bytes_lbs_share.has()) {
          bool3 = avhg.a(paramQQAppInterface, paramExtSnsFrdData.bytes_lbs_share);
        }
        bool6 = bool2;
        bool5 = bool1;
        bool4 = bool3;
        if (paramExtSnsFrdData.bytes_aio_quick_app.has())
        {
          bool4 = apin.a(paramExtSnsFrdData.bytes_aio_quick_app);
          bool5 = bool1;
          bool1 = bool4;
        }
      }
    }
    for (;;)
    {
      if (paramExtensionInfo.isTogetherBusinessOpen(16777216) != bool5)
      {
        paramExtensionInfo.setTogetherBusiness(bool5, 16777216);
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
        j = i;
        if (bool4 != bool3)
        {
          if (!bool3) {
            break label556;
          }
          j = 1;
          label250:
          paramExtensionInfo.isSharingLocation = j;
          if (paramExtensionInfo.isSharingLocation != 1) {
            break label562;
          }
          bool4 = true;
          label267:
          avhf.a(paramQQAppInterface, 0, paramString, bool4);
          if (QLog.isColorLevel()) {
            QLog.d("ExtSnsFrdDataHandlerHelper", 2, new Object[] { "handleExtSnsFrdData: invoked. update ei & msg data ", " isSharingLbs: ", Boolean.valueOf(bool3) });
          }
          j = i | 0x1;
        }
        if (paramExtensionInfo.isAioShortcutBarOpen == bool1) {
          break label618;
        }
        paramExtensionInfo.isAioShortcutBarOpen = bool1;
      }
      label435:
      label574:
      label618:
      for (i = j | 0x1;; i = j)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("handleExtSnsFrdData friendUin:").append(paramString).append(" newIsOpen:").append(bool2).append(" oldIsOpen").append(paramExtensionInfo.isListenTogetherOpen).append(" is_sing_together=").append(bool5).append(" isSharingLocation: ").append(paramExtensionInfo.isSharingLocation).append(" isAioShortcutBarOpen: ").append(paramExtensionInfo.isAioShortcutBarOpen).append(" friend:");
          if (paramFriends != null)
          {
            paramExtensionInfo = Boolean.valueOf(paramFriends.isFriend());
            QLog.d("ExtSnsFrdDataHandlerHelper", 1, paramExtensionInfo);
          }
        }
        else
        {
          j = i;
          if (paramFriends != null)
          {
            if (!paramExtSnsFrdData.bytes_mutualmark_alienation.has()) {
              break label574;
            }
            awgj.a(paramQQAppInterface, paramamsw, paramFriends, paramString, paramExtSnsFrdData.bytes_mutualmark_alienation.get().toByteArray(), false);
            i |= 0x2;
            j = i;
            if (QLog.isColorLevel())
            {
              QLog.d("ExtSnsFrdDataHandlerHelper", 1, "handleExtSnsFrdData friendUin:" + paramString + " relationIconFlag" + paramFriends.relationIconFlag);
              j = i;
            }
          }
        }
        do
        {
          return j;
          bool4 = false;
          break;
          j = 0;
          break label250;
          bool4 = false;
          break label267;
          paramExtensionInfo = "null";
          break label435;
          j = i;
        } while (!QLog.isColorLevel());
        QLog.e("ExtSnsFrdDataHandlerHelper", 2, "handleExtSnsFrdData ExtSnsFrdData  friendUin:" + paramString + " doesn't has bytes_mutualmark_alienation");
        return i;
      }
      label556:
      label562:
      bool2 = bool6;
      bool1 = false;
      bool3 = bool4;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (paramafat.jdField_b_of_type_Afaw != null) {}
    switch (paramafat.jdField_b_of_type_Afaw.jdField_a_of_type_Int)
    {
    default: 
      if (awfy.b(paramafat.jdField_b_of_type_Afaw.jdField_a_of_type_Int)) {
        awfr.a(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
      }
      return;
    }
    awgj.a(paramQQAppInterface, paramamsw, paramFriends, paramafat.jdField_b_of_type_JavaLangString, paramafat.jdField_b_of_type_Afaw.jdField_a_of_type_ArrayOfByte, true);
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
      amsw localamsw = (amsw)paramQQAppInterface.getManager(51);
      Object localObject2 = localamsw.a(str);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = str;
      }
      localObject2 = localamsw.e(str);
      i = a(paramQQAppInterface, localamsw, (Friends)localObject2, (ExtensionInfo)localObject1, str, paramExtSnsFrdData);
      if ((localObject1 != null) && ((i & 0x1) != 0)) {
        localamsw.a((ExtensionInfo)localObject1);
      }
      if ((localObject2 != null) && ((i & 0x2) != 0))
      {
        localamsw.a((Friends)localObject2);
        paramQQAppInterface.getBusinessHandler(1).notifyUI(3, true, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ExtSnsFrdDataHandlerHelper", 1, "handleGet0x5e0ExtSnsFrdData uin:" + str + " changeType:" + i);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, anlx paramanlx)
  {
    if ((paramQQAppInterface == null) || (paramRelationalChainChange == null) || (paramanlx == null)) {}
    afat localafat;
    do
    {
      return;
      localafat = afat.a(paramRelationalChainChange, paramanlx.a);
    } while ((!TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), localafat.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localafat.jdField_b_of_type_JavaLangString)));
    amsw localamsw = (amsw)paramQQAppInterface.getManager(51);
    Friends localFriends = localamsw.e(localafat.jdField_b_of_type_JavaLangString);
    ExtensionInfo localExtensionInfo = localamsw.a(localafat.jdField_b_of_type_JavaLangString);
    paramRelationalChainChange = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramRelationalChainChange = new ExtensionInfo();
      paramRelationalChainChange.uin = localafat.jdField_b_of_type_JavaLangString;
    }
    QLog.d("ExtSnsFrdDataHandlerHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 msginfo:" + paramanlx + "changePushInfo:" + localafat);
    switch (localafat.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(paramQQAppInterface, localamsw, localFriends, paramRelationalChainChange, localafat, paramanlx);
      return;
    case 2: 
      b(paramQQAppInterface, localamsw, localFriends, paramRelationalChainChange, localafat, paramanlx);
      return;
    case 3: 
      c(paramQQAppInterface, localamsw, localFriends, paramRelationalChainChange, localafat, paramanlx);
      return;
    case 10001: 
      d(paramQQAppInterface, localamsw, localFriends, paramRelationalChainChange, localafat, paramanlx);
      return;
    case 10002: 
      e(paramQQAppInterface, localamsw, localFriends, paramRelationalChainChange, localafat, paramanlx);
      return;
    case 10003: 
      f(paramQQAppInterface, localamsw, localFriends, paramRelationalChainChange, localafat, paramanlx);
      return;
    case 10004: 
      g(paramQQAppInterface, localamsw, localFriends, paramRelationalChainChange, localafat, paramanlx);
      return;
    case 10005: 
      h(paramQQAppInterface, localamsw, localFriends, paramRelationalChainChange, localafat, paramanlx);
      return;
    case 11000: 
      i(paramQQAppInterface, localamsw, localFriends, paramRelationalChainChange, localafat, paramanlx);
      return;
    case 11001: 
      j(paramQQAppInterface, localamsw, localFriends, paramRelationalChainChange, localafat, paramanlx);
      return;
    case 11002: 
      k(paramQQAppInterface, localamsw, localFriends, paramRelationalChainChange, localafat, paramanlx);
      return;
    }
    l(paramQQAppInterface, localamsw, localFriends, paramRelationalChainChange, localafat, paramanlx);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, byte[] paramArrayOfByte)
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
        j = a(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramString, paramArrayOfByte);
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
  
  public static void b(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (paramafat.jdField_a_of_type_Afaw != null)
    {
      int i = paramafat.jdField_a_of_type_Afaw.jdField_a_of_type_Int;
      if (awfy.b(paramafat.jdField_a_of_type_Afaw.jdField_a_of_type_Int)) {
        awfr.b(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
      }
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (paramafat.jdField_b_of_type_Afaw != null) {}
    switch (paramafat.jdField_b_of_type_Afaw.jdField_a_of_type_Int)
    {
    default: 
      if (awfy.b(paramafat.jdField_b_of_type_Afaw.jdField_a_of_type_Int)) {
        awfr.c(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
      }
      return;
    }
    awgj.a(paramQQAppInterface, paramamsw, paramFriends, paramafat.jdField_b_of_type_JavaLangString, paramafat.jdField_b_of_type_Afaw.jdField_a_of_type_ArrayOfByte, true);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (paramafat.jdField_b_of_type_Afaw != null)
    {
      int i = paramafat.jdField_b_of_type_Afaw.jdField_a_of_type_Int;
      if (awfy.b(paramafat.jdField_b_of_type_Afaw.jdField_a_of_type_Int)) {
        awfr.d(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
      }
    }
  }
  
  public static void e(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (paramafat.jdField_b_of_type_Afaw != null)
    {
      int i = paramafat.jdField_b_of_type_Afaw.jdField_a_of_type_Int;
      if (awfy.b(paramafat.jdField_b_of_type_Afaw.jdField_a_of_type_Int)) {
        awfr.e(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
      }
    }
  }
  
  public static void f(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (paramafat.jdField_b_of_type_Afaw != null)
    {
      int i = paramafat.jdField_b_of_type_Afaw.jdField_a_of_type_Int;
      if (awfy.b(paramafat.jdField_b_of_type_Afaw.jdField_a_of_type_Int)) {
        awfr.f(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
      }
    }
  }
  
  public static void g(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (paramafat.jdField_b_of_type_Afaw != null)
    {
      int i = paramafat.jdField_b_of_type_Afaw.jdField_a_of_type_Int;
      if (awfy.b(paramafat.jdField_b_of_type_Afaw.jdField_a_of_type_Int)) {
        awfr.g(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
      }
    }
  }
  
  public static void h(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (paramafat.jdField_b_of_type_Afaw != null)
    {
      int i = paramafat.jdField_b_of_type_Afaw.jdField_a_of_type_Int;
      if (awfy.b(paramafat.jdField_b_of_type_Afaw.jdField_a_of_type_Int)) {
        awfr.h(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
      }
    }
  }
  
  public static void i(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if ((paramafat.jdField_b_of_type_Afaw != null) || (paramafat.jdField_a_of_type_JavaUtilArrayList != null)) {
      awfr.i(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
    }
  }
  
  public static void j(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if ((paramafat.jdField_b_of_type_Afaw != null) || (paramafat.jdField_a_of_type_JavaUtilArrayList != null)) {
      awfr.j(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
    }
  }
  
  public static void k(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if ((paramafat.jdField_b_of_type_Afaw != null) || (paramafat.jdField_a_of_type_JavaUtilArrayList != null)) {
      awfr.k(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
    }
  }
  
  public static void l(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (paramafat.jdField_b_of_type_Afaw != null) {
      awfr.l(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afas
 * JD-Core Version:    0.7.0.1
 */