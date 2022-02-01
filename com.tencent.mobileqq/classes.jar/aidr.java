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
public class aidr
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
        paramQQAppInterface.getPreferences().edit().putStringSet("cloneFriendPush_" + paramQQAppInterface.getCurrentUin(), jdField_a_of_type_JavaUtilHashSet).commit();
      }
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    MessageForText localMessageForText = new MessageForText();
    localMessageForText.istroop = 0;
    localMessageForText.frienduin = paramString2;
    localMessageForText.senderuin = paramString2;
    localMessageForText.isread = true;
    localMessageForText.msg = String.format(amtj.a(2131701101), new Object[] { paramString1, paramString3, paramString2 });
    localMessageForText.time = bbko.a();
    paramQQAppInterface.getMessageFacade().addMessage(localMessageForText, paramQQAppInterface.getCurrentUin());
  }
  
  static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    b(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramInt);
    a(paramQQAppInterface, paramString2, paramString3, paramString4);
    c(paramQQAppInterface, paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SubMsgType0x87.MsgBody paramMsgBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloneFriendPushHelper", 2, "onLinePush onReceivePush, app=" + paramQQAppInterface + ", msgBody=" + paramMsgBody);
    }
    paramMsgBody = paramMsgBody.rpt_msg_msg_notify.get();
    int i;
    Object localObject1;
    Object localObject2;
    String str1;
    boolean bool;
    label172:
    String str2;
    String str3;
    int j;
    if ((paramMsgBody != null) && (paramMsgBody.size() > 0))
    {
      i = 0;
      if (i < paramMsgBody.size())
      {
        localObject1 = (SubMsgType0x87.MsgNotify)paramMsgBody.get(i);
        if ((localObject1 != null) && (((SubMsgType0x87.MsgNotify)localObject1).uint32_reqsubtype.get() == 2) && (((SubMsgType0x87.MsgNotify)localObject1).msg_clone_info.has()))
        {
          localObject2 = (SubMsgType0x87.CloneInfo)((SubMsgType0x87.MsgNotify)localObject1).msg_clone_info.get();
          if (localObject2 != null)
          {
            localObject1 = String.valueOf(((SubMsgType0x87.CloneInfo)localObject2).uint64_uin.get());
            str1 = ((SubMsgType0x87.CloneInfo)localObject2).bytes_remark.get().toStringUtf8();
            if (((SubMsgType0x87.CloneInfo)localObject2).uint32_show_in_aio.get() != 1) {
              break label303;
            }
            bool = true;
            str2 = String.valueOf(((SubMsgType0x87.CloneInfo)localObject2).uint64_to_uin.get());
            str3 = ((SubMsgType0x87.CloneInfo)localObject2).bytes_to_nick.get().toStringUtf8();
            j = ((SubMsgType0x87.CloneInfo)localObject2).uint32_src_gender.get();
            if (QLog.isColorLevel()) {
              QLog.d("CloneFriendPushHelper", 2, "cloneInfo, uinC=" + (String)localObject1 + ", nickC=" + str1 + ", showInAio=" + bool + ", uinB=" + str2 + ", nickB=" + str3 + ", gender=" + j);
            }
            if (bool) {
              break label309;
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      label303:
      bool = false;
      break label172;
      label309:
      localObject2 = str2 + (String)localObject1 + paramQQAppInterface.getCurrentUin();
      if (jdField_a_of_type_JavaUtilHashMap.get(localObject2) == null) {}
      for (long l1 = 0L;; l1 = ((Long)jdField_a_of_type_JavaUtilHashMap.get(localObject2)).longValue())
      {
        long l2 = System.currentTimeMillis();
        jdField_a_of_type_JavaUtilHashMap.put(localObject2, Long.valueOf(l2));
        if (Math.abs(l2 - l1) >= 60000L) {
          break;
        }
        QLog.d("CloneFriendPushHelper", 1, "onReceivePush, gap < 60s");
        return;
      }
      a(paramQQAppInterface, (String)localObject1, str1, str2, str3, j);
      paramQQAppInterface.reportClickEvent("CliOper", "", "", "0X8008071", "0X8008071", 0, 0, "", "", "", "");
      b(paramQQAppInterface, str2);
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloneFriendPushHelper", 2, "initSet, uin=" + paramQQAppInterface.getCurrentUin() + ", hasInit=" + jdField_a_of_type_Boolean);
    }
    synchronized (jdField_a_of_type_JavaUtilHashSet)
    {
      if (jdField_a_of_type_Boolean) {
        return false;
      }
      jdField_a_of_type_JavaUtilHashSet.clear();
      paramQQAppInterface = paramQQAppInterface.getPreferences().getStringSet("cloneFriendPush_" + paramQQAppInterface.getCurrentUin(), null);
      if (paramQQAppInterface != null) {
        jdField_a_of_type_JavaUtilHashSet.addAll(paramQQAppInterface);
      }
      jdField_a_of_type_Boolean = true;
      return true;
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
        paramQQAppInterface.getPreferences().edit().putStringSet("cloneFriendPush_" + paramQQAppInterface.getCurrentUin(), jdField_a_of_type_JavaUtilHashSet).commit();
      }
      return;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    Object localObject1 = amtj.a(2131701104);
    String str1 = String.format("%s(%s)", new Object[] { paramString2, paramString1 });
    Object localObject2 = amtj.a(2131701102);
    if (paramInt == 1) {}
    for (paramString2 = amtj.a(2131701096);; paramString2 = amtj.a(2131701099))
    {
      String str2 = String.format((String)localObject2, new Object[] { paramString2 });
      String str3 = String.format("%s(%s)", new Object[] { paramString4, paramString3 });
      paramString2 = amtj.a(2131701100);
      paramString4 = amtj.a(2131701097);
      localObject2 = new aucf(paramString3, paramString3, (String)localObject1 + str1 + str2 + str3 + "的好友列表中。\n不想和他们是好友关系，可选择" + paramString2 + "。\n不想再被其他好友克隆，可选择" + paramString4 + "。", 0, -5040, 2686977, bbko.a());
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 44);
      localBundle.putString("key_action_DATA", paramString1);
      paramInt = ((String)localObject1).length();
      ((aucf)localObject2).a(paramInt, str1.length() + paramInt, localBundle);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_action", 44);
      ((Bundle)localObject1).putString("key_action_DATA", paramString3);
      int i = str1.length();
      paramInt = str2.length() + (paramInt + i);
      ((aucf)localObject2).a(paramInt, str3.length() + paramInt, (Bundle)localObject1);
      paramString3 = new Bundle();
      paramString3.putInt("key_action", 45);
      paramString3.putString("key_action_DATA", paramString1);
      paramString3.putString("key_a_action_DATA", String.format(amtj.a(2131701103), new Object[] { str1, str3 }));
      paramInt = paramInt + str3.length() + "的好友列表中。\n不想和他们是好友关系，可选择".length();
      ((aucf)localObject2).a(paramInt, paramString2.length() + paramInt, paramString3);
      paramString1 = new Bundle();
      paramString1.putInt("key_action", 1);
      paramString1.putString("key_action_DATA", "https://ti.qq.com/friendship_auth/index.html?_wv=3#clone_setting");
      paramInt = paramInt + paramString2.length() + "。\n不想再被其他好友克隆，可选择".length();
      ((aucf)localObject2).a(paramInt, paramString4.length() + paramInt, paramString1);
      localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, (aucf)localObject2);
      aucg.a(paramQQAppInterface, localMessageForUniteGrayTip);
      return;
    }
  }
  
  private static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, new aucf(paramString, paramString, amtj.a(2131701098), 0, -5020, 2686977, bbko.a()));
    aucg.a(paramQQAppInterface, localMessageForUniteGrayTip);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidr
 * JD-Core Version:    0.7.0.1
 */