import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.CloneInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.MsgNotify;

@TargetApi(11)
public class ahle
{
  public static final HashMap<String, Long> a;
  public static final HashSet<String> a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaUtilHashSet)
    {
      jdField_a_of_type_Boolean = false;
      jdField_a_of_type_JavaUtilHashSet.clear();
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloneFriendPushHelper", 2, "initSet, uin=" + paramQQAppInterface.c() + ", hasInit=" + jdField_a_of_type_Boolean);
    }
    synchronized (jdField_a_of_type_JavaUtilHashSet)
    {
      if (jdField_a_of_type_Boolean) {
        return;
      }
      jdField_a_of_type_JavaUtilHashSet.clear();
      paramQQAppInterface = paramQQAppInterface.getPreferences().getStringSet("cloneFriendPush_" + paramQQAppInterface.c(), null);
      if (paramQQAppInterface != null) {
        jdField_a_of_type_JavaUtilHashSet.addAll(paramQQAppInterface);
      }
      jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloneFriendPushHelper", 2, "removeUin, uin=" + paramString);
    }
    synchronized (jdField_a_of_type_JavaUtilHashSet)
    {
      if (!jdField_a_of_type_Boolean) {
        a(paramQQAppInterface);
      }
      if (jdField_a_of_type_JavaUtilHashSet.contains(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CloneFriendPushHelper", 2, "addUin, contains, need remove");
        }
        jdField_a_of_type_JavaUtilHashSet.remove(paramString);
        paramQQAppInterface.getPreferences().edit().putStringSet("cloneFriendPush_" + paramQQAppInterface.c(), jdField_a_of_type_JavaUtilHashSet).commit();
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SubMsgType0x87.MsgBody paramMsgBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloneFriendPushHelper", 2, "onLinePush onReceivePush, app=" + paramQQAppInterface + ", msgBody=" + paramMsgBody);
    }
    List localList = paramMsgBody.rpt_msg_msg_notify.get();
    Object localObject1;
    String str2;
    String str1;
    String str3;
    int j;
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      if (i < localList.size())
      {
        paramMsgBody = (SubMsgType0x87.MsgNotify)localList.get(i);
        if ((paramMsgBody != null) && (paramMsgBody.uint32_reqsubtype.get() == 2) && (paramMsgBody.msg_clone_info.has()))
        {
          paramMsgBody = (SubMsgType0x87.CloneInfo)paramMsgBody.msg_clone_info.get();
          if (paramMsgBody != null)
          {
            localObject1 = String.valueOf(paramMsgBody.uint64_uin.get());
            str2 = paramMsgBody.bytes_remark.get().toStringUtf8();
            if (paramMsgBody.uint32_show_in_aio.get() != 1) {
              break label292;
            }
          }
        }
        label292:
        for (boolean bool = true;; bool = false)
        {
          str1 = String.valueOf(paramMsgBody.uint64_to_uin.get());
          str3 = paramMsgBody.bytes_to_nick.get().toStringUtf8();
          j = paramMsgBody.uint32_src_gender.get();
          if (QLog.isColorLevel()) {
            QLog.d("CloneFriendPushHelper", 2, "cloneInfo, uinC=" + (String)localObject1 + ", nickC=" + str2 + ", showInAio=" + bool + ", uinB=" + str1 + ", nickB=" + str3 + ", gender=" + j);
          }
          if (bool) {
            break label298;
          }
          i += 1;
          break;
        }
        label298:
        paramMsgBody = str1 + (String)localObject1 + paramQQAppInterface.c();
        if (jdField_a_of_type_JavaUtilHashMap.get(paramMsgBody) != null) {
          break label381;
        }
      }
    }
    label381:
    for (long l1 = 0L;; l1 = ((Long)jdField_a_of_type_JavaUtilHashMap.get(paramMsgBody)).longValue())
    {
      long l2 = System.currentTimeMillis();
      jdField_a_of_type_JavaUtilHashMap.put(paramMsgBody, Long.valueOf(l2));
      if (Math.abs(l2 - l1) >= 60000L) {
        break;
      }
      QLog.d("CloneFriendPushHelper", 1, "onReceivePush, gap < 60s");
      return;
    }
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    Object localObject2 = alud.a(2131702342);
    String str4 = String.format("%s(%s)", new Object[] { str2, localObject1 });
    String str5 = alud.a(2131702340);
    if (j == 1) {}
    for (paramMsgBody = alud.a(2131702334);; paramMsgBody = alud.a(2131702337))
    {
      String str7 = String.format(str5, new Object[] { paramMsgBody });
      String str6 = String.format("%s(%s)", new Object[] { str3, str1 });
      paramMsgBody = alud.a(2131702338);
      str5 = alud.a(2131702335);
      aspy localaspy = new aspy(str1, str1, (String)localObject2 + str4 + str7 + str6 + "的好友列表中。\n不想和他们是好友关系，可选择" + paramMsgBody + "。\n不想再被其他好友克隆，可选择" + str5 + "。", 0, -5040, 2686977, ayzl.a());
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 44);
      localBundle.putString("key_action_DATA", (String)localObject1);
      j = ((String)localObject2).length();
      localaspy.a(j, str4.length() + j, localBundle);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("key_action", 44);
      ((Bundle)localObject2).putString("key_action_DATA", str1);
      int k = str4.length();
      j = str7.length() + (j + k);
      localaspy.a(j, str6.length() + j, (Bundle)localObject2);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("key_action", 45);
      ((Bundle)localObject2).putString("key_action_DATA", (String)localObject1);
      ((Bundle)localObject2).putString("key_a_action_DATA", String.format(alud.a(2131702341), new Object[] { str4, str6 }));
      j = j + str6.length() + "的好友列表中。\n不想和他们是好友关系，可选择".length();
      localaspy.a(j, paramMsgBody.length() + j, (Bundle)localObject2);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_action", 1);
      ((Bundle)localObject1).putString("key_action_DATA", "https://ti.qq.com/friendship_auth/index.html?_wv=3#clone_setting");
      j = j + paramMsgBody.length() + "。\n不想再被其他好友克隆，可选择".length();
      localaspy.a(j, str5.length() + j, (Bundle)localObject1);
      localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, localaspy);
      aspz.a(paramQQAppInterface, localMessageForUniteGrayTip);
      paramMsgBody = new MessageForText();
      paramMsgBody.istroop = 0;
      paramMsgBody.frienduin = str1;
      paramMsgBody.senderuin = str1;
      paramMsgBody.isread = true;
      paramMsgBody.msg = String.format(alud.a(2131702339), new Object[] { str2, str3, str1 });
      paramMsgBody.time = ayzl.a();
      paramQQAppInterface.a().a(paramMsgBody, paramQQAppInterface.c());
      paramMsgBody = new MessageForUniteGrayTip();
      paramMsgBody.initGrayTipMsg(paramQQAppInterface, new aspy(str1, str1, alud.a(2131702336), 0, -5020, 2686977, ayzl.a()));
      aspz.a(paramQQAppInterface, paramMsgBody);
      paramQQAppInterface.reportClickEvent("CliOper", "", "", "0X8008071", "0X8008071", 0, 0, "", "", "", "");
      b(paramQQAppInterface, str1);
      break;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    synchronized (jdField_a_of_type_JavaUtilHashSet)
    {
      if (!jdField_a_of_type_Boolean) {
        a(paramQQAppInterface);
      }
      boolean bool = jdField_a_of_type_JavaUtilHashSet.contains(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("CloneFriendPushHelper", 2, "hasUin, uin=" + paramString + ", has=" + bool);
      }
      return bool;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloneFriendPushHelper", 2, "addUin, uin=" + paramString);
    }
    synchronized (jdField_a_of_type_JavaUtilHashSet)
    {
      if (!jdField_a_of_type_Boolean) {
        a(paramQQAppInterface);
      }
      if (!jdField_a_of_type_JavaUtilHashSet.contains(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CloneFriendPushHelper", 2, "addUin, not contains, need add");
        }
        jdField_a_of_type_JavaUtilHashSet.add(paramString);
        paramQQAppInterface.getPreferences().edit().putStringSet("cloneFriendPush_" + paramQQAppInterface.c(), jdField_a_of_type_JavaUtilHashSet).commit();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahle
 * JD-Core Version:    0.7.0.1
 */