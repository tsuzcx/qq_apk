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

public class aghw
{
  private static int a(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd50.ExtSnsFrdData paramExtSnsFrdData)
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
          bool2 = awlo.a(paramExtSnsFrdData.bytes_music_switch.get().toByteArray());
        }
        if (paramExtSnsFrdData.bytes_ksing_switch.has()) {
          bool1 = awea.a(paramExtSnsFrdData.bytes_ksing_switch.get().toByteArray());
        }
        if (paramExtSnsFrdData.bytes_lbs_share.has()) {
          bool3 = awua.a(paramQQAppInterface, paramExtSnsFrdData.bytes_lbs_share);
        }
        bool6 = bool2;
        bool5 = bool1;
        bool4 = bool3;
        if (paramExtSnsFrdData.bytes_aio_quick_app.has())
        {
          bool4 = aqpe.a(paramExtSnsFrdData.bytes_aio_quick_app);
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
          awtz.a(paramQQAppInterface, 0, paramString, bool4);
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
            axtc.a(paramQQAppInterface, paramanyw, paramFriends, paramString, paramExtSnsFrdData.bytes_mutualmark_alienation.get().toByteArray(), false);
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
  
  public static void a(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (paramaghx.jdField_b_of_type_Agia != null) {}
    switch (paramaghx.jdField_b_of_type_Agia.jdField_a_of_type_Int)
    {
    default: 
      if (axsr.b(paramaghx.jdField_b_of_type_Agia.jdField_a_of_type_Int)) {
        axsk.a(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
      }
      return;
    }
    axtc.a(paramQQAppInterface, paramanyw, paramFriends, paramaghx.jdField_b_of_type_JavaLangString, paramaghx.jdField_b_of_type_Agia.jdField_a_of_type_ArrayOfByte, true);
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
      anyw localanyw = (anyw)paramQQAppInterface.getManager(51);
      Object localObject2 = localanyw.a(str);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = str;
      }
      localObject2 = localanyw.e(str);
      i = a(paramQQAppInterface, localanyw, (Friends)localObject2, (ExtensionInfo)localObject1, str, paramExtSnsFrdData);
      if ((localObject1 != null) && ((i & 0x1) != 0)) {
        localanyw.a((ExtensionInfo)localObject1);
      }
      if ((localObject2 != null) && ((i & 0x2) != 0))
      {
        localanyw.a((Friends)localObject2);
        paramQQAppInterface.a(1).notifyUI(3, true, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ExtSnsFrdDataHandlerHelper", 1, "handleGet0x5e0ExtSnsFrdData uin:" + str + " changeType:" + i);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, aotc paramaotc)
  {
    if ((paramQQAppInterface == null) || (paramRelationalChainChange == null) || (paramaotc == null)) {}
    aghx localaghx;
    do
    {
      return;
      localaghx = aghx.a(paramRelationalChainChange, paramaotc.a);
    } while ((!TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), localaghx.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localaghx.jdField_b_of_type_JavaLangString)));
    anyw localanyw = (anyw)paramQQAppInterface.getManager(51);
    Friends localFriends = localanyw.e(localaghx.jdField_b_of_type_JavaLangString);
    ExtensionInfo localExtensionInfo = localanyw.a(localaghx.jdField_b_of_type_JavaLangString);
    paramRelationalChainChange = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramRelationalChainChange = new ExtensionInfo();
      paramRelationalChainChange.uin = localaghx.jdField_b_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtSnsFrdDataHandlerHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 msginfo:" + paramaotc + "changePushInfo:" + localaghx);
    }
    switch (localaghx.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(paramQQAppInterface, localanyw, localFriends, paramRelationalChainChange, localaghx, paramaotc);
      return;
    case 2: 
      b(paramQQAppInterface, localanyw, localFriends, paramRelationalChainChange, localaghx, paramaotc);
      return;
    case 3: 
      c(paramQQAppInterface, localanyw, localFriends, paramRelationalChainChange, localaghx, paramaotc);
      return;
    case 10001: 
      d(paramQQAppInterface, localanyw, localFriends, paramRelationalChainChange, localaghx, paramaotc);
      return;
    case 10002: 
      e(paramQQAppInterface, localanyw, localFriends, paramRelationalChainChange, localaghx, paramaotc);
      return;
    case 10003: 
      f(paramQQAppInterface, localanyw, localFriends, paramRelationalChainChange, localaghx, paramaotc);
      return;
    case 10004: 
      g(paramQQAppInterface, localanyw, localFriends, paramRelationalChainChange, localaghx, paramaotc);
      return;
    case 10005: 
      h(paramQQAppInterface, localanyw, localFriends, paramRelationalChainChange, localaghx, paramaotc);
      return;
    case 11000: 
      i(paramQQAppInterface, localanyw, localFriends, paramRelationalChainChange, localaghx, paramaotc);
      return;
    case 11001: 
      j(paramQQAppInterface, localanyw, localFriends, paramRelationalChainChange, localaghx, paramaotc);
      return;
    case 11002: 
      k(paramQQAppInterface, localanyw, localFriends, paramRelationalChainChange, localaghx, paramaotc);
      return;
    }
    l(paramQQAppInterface, localanyw, localFriends, paramRelationalChainChange, localaghx, paramaotc);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, byte[] paramArrayOfByte)
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
        j = a(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramString, paramArrayOfByte);
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
  
  public static void b(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (paramaghx.jdField_a_of_type_Agia != null)
    {
      int i = paramaghx.jdField_a_of_type_Agia.jdField_a_of_type_Int;
      if (axsr.b(paramaghx.jdField_a_of_type_Agia.jdField_a_of_type_Int)) {
        axsk.b(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
      }
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (paramaghx.jdField_b_of_type_Agia != null) {}
    switch (paramaghx.jdField_b_of_type_Agia.jdField_a_of_type_Int)
    {
    default: 
      if (axsr.b(paramaghx.jdField_b_of_type_Agia.jdField_a_of_type_Int)) {
        axsk.c(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
      }
      return;
    }
    axtc.a(paramQQAppInterface, paramanyw, paramFriends, paramaghx.jdField_b_of_type_JavaLangString, paramaghx.jdField_b_of_type_Agia.jdField_a_of_type_ArrayOfByte, true);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (paramaghx.jdField_b_of_type_Agia != null)
    {
      int i = paramaghx.jdField_b_of_type_Agia.jdField_a_of_type_Int;
      if (axsr.b(paramaghx.jdField_b_of_type_Agia.jdField_a_of_type_Int)) {
        axsk.d(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
      }
    }
  }
  
  public static void e(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (paramaghx.jdField_b_of_type_Agia != null)
    {
      int i = paramaghx.jdField_b_of_type_Agia.jdField_a_of_type_Int;
      if (axsr.b(paramaghx.jdField_b_of_type_Agia.jdField_a_of_type_Int)) {
        axsk.e(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
      }
    }
  }
  
  public static void f(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (paramaghx.jdField_b_of_type_Agia != null)
    {
      int i = paramaghx.jdField_b_of_type_Agia.jdField_a_of_type_Int;
      if (axsr.b(paramaghx.jdField_b_of_type_Agia.jdField_a_of_type_Int)) {
        axsk.f(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
      }
    }
  }
  
  public static void g(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (paramaghx.jdField_b_of_type_Agia != null)
    {
      int i = paramaghx.jdField_b_of_type_Agia.jdField_a_of_type_Int;
      if (axsr.b(paramaghx.jdField_b_of_type_Agia.jdField_a_of_type_Int)) {
        axsk.g(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
      }
    }
  }
  
  public static void h(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (paramaghx.jdField_b_of_type_Agia != null)
    {
      int i = paramaghx.jdField_b_of_type_Agia.jdField_a_of_type_Int;
      if (axsr.b(paramaghx.jdField_b_of_type_Agia.jdField_a_of_type_Int)) {
        axsk.h(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
      }
    }
  }
  
  public static void i(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if ((paramaghx.jdField_b_of_type_Agia != null) || (paramaghx.jdField_a_of_type_JavaUtilArrayList != null)) {
      axsk.i(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
    }
  }
  
  public static void j(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if ((paramaghx.jdField_b_of_type_Agia != null) || (paramaghx.jdField_a_of_type_JavaUtilArrayList != null)) {
      axsk.j(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
    }
  }
  
  public static void k(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if ((paramaghx.jdField_b_of_type_Agia != null) || (paramaghx.jdField_a_of_type_JavaUtilArrayList != null)) {
      axsk.k(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
    }
  }
  
  public static void l(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (paramaghx.jdField_b_of_type_Agia != null) {
      axsk.l(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghw
 * JD-Core Version:    0.7.0.1
 */