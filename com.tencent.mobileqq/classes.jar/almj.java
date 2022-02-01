import android.content.Context;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.activity.recent.msgbox.RecentItemTempMsgBoxData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class almj
{
  private static Map<Integer, Integer> a;
  public static boolean a;
  private static Map<Integer, Integer> b;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    b = new HashMap();
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1000), Integer.valueOf(2131698943));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1004), Integer.valueOf(2131698943));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1006), Integer.valueOf(2131698945));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1023), Integer.valueOf(2131698946));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1022), Integer.valueOf(2131698950));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(10010), Integer.valueOf(2131698938));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1024), Integer.valueOf(2131698939));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1005), Integer.valueOf(2131698951));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(10009), Integer.valueOf(2131698942));
    b.put(Integer.valueOf(1000), Integer.valueOf(0));
    b.put(Integer.valueOf(1004), Integer.valueOf(1));
    b.put(Integer.valueOf(1006), Integer.valueOf(130));
    b.put(Integer.valueOf(1023), Integer.valueOf(133));
    b.put(Integer.valueOf(1022), Integer.valueOf(134));
    b.put(Integer.valueOf(10010), Integer.valueOf(167));
  }
  
  private static int a(int paramInt, acmw paramacmw)
  {
    int i = paramacmw.d(AppConstants.TEMP_MSG_BOX_UIN, 10011);
    if (i > 0) {
      paramInt = i;
    }
    return paramInt;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    acmw localacmw = paramQQAppInterface.getConversationFacade();
    almg localalmg;
    List localList;
    int i;
    if (localacmw.b(AppConstants.TEMP_MSG_BOX_UIN, 10011))
    {
      localalmg = (almg)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX);
      localList = localalmg.a(paramQQAppInterface);
      if (localList.isEmpty())
      {
        QLog.e("TempMsgBoxUtil", 1, "onGetUnreadMsgNum: msgBoxRecentUsers.isEmpty()");
        return 0;
      }
      Object localObject = (RecentUser)localList.get(0);
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)localIterator.next();
        if (Math.max(localRecentUser.lastmsgtime, localRecentUser.lastmsgdrafttime) <= Math.max(((RecentUser)localObject).lastmsgtime, ((RecentUser)localObject).lastmsgdrafttime)) {
          break label222;
        }
        localObject = localRecentUser;
      }
      if (TextUtils.equals(((RecentUser)localObject).uin, AppConstants.FILTER_MSG_UIN))
      {
        i = 0;
        label152:
        j = i;
        if (i != 0) {}
      }
    }
    for (int j = a(i, localacmw);; j = 0)
    {
      QLog.d("TempMsgBoxUtil", 2, "getTempMsgBoxUnread() called with: msgBoxUnread = [" + j + "]");
      return j;
      if (localalmg.a())
      {
        i = 0;
        break label152;
      }
      i = RecentItemTempMsgBoxData.a(paramQQAppInterface, localList, localacmw);
      break label152;
      label222:
      break;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    Object localObject = allz.a().a(paramRecentUser.type, paramRecentUser.uin);
    if (localObject != null) {
      localObject = ((alma)localObject).c;
    }
    String str;
    do
    {
      do
      {
        return localObject;
        if (paramRecentUser.getType() == 1024) {
          return RecentItemPublicAccountChatMsgData.a(paramQQAppInterface, (aoan)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER), paramRecentUser.uin).name;
        }
        if (paramRecentUser.getType() == 1000)
        {
          localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
          if (localObject == null) {
            break label205;
          }
          localObject = ((TroopManager)localObject).b(paramRecentUser.troopUin);
          return ContactUtils.getTroopNickName(paramQQAppInterface, paramRecentUser.uin, (String)localObject, paramRecentUser.troopUin, true, null);
        }
        if (paramRecentUser.getType() != 1004) {
          break;
        }
        str = ContactUtils.getDiscussionMemberShowName(paramQQAppInterface, paramRecentUser.troopUin, paramRecentUser.uin);
        localObject = str;
      } while (str == null);
      localObject = str;
    } while (!str.equals(paramRecentUser.uin));
    return ContactUtils.getBuddyName(paramQQAppInterface, paramRecentUser.uin, true);
    if (paramRecentUser.getType() == 10007) {
      return avdu.a(paramRecentUser.uin, paramQQAppInterface);
    }
    if (paramRecentUser.getType() == 1006) {
      return b(paramQQAppInterface, paramRecentUser);
    }
    return ContactUtils.getBuddyName(paramQQAppInterface, paramRecentUser.uin, true);
    label205:
    return "";
  }
  
  public static Map<Integer, Integer> a()
  {
    return jdField_a_of_type_JavaUtilMap;
  }
  
  public static void a(int paramInt, String paramString, MsgSummary paramMsgSummary)
  {
    if ((paramInt == 10011) && (!TextUtils.isEmpty(paramString))) {
      paramMsgSummary.strPrefix = paramString;
    }
  }
  
  public static void a(Context paramContext, Object paramObject)
  {
    if (((paramObject instanceof RecentItemTempMsgBoxData)) && (!jdField_a_of_type_Boolean))
    {
      jdField_a_of_type_Boolean = true;
      bdla.b(((BaseActivity)paramContext).app, "dc00898", "", "", "0X800B1BE", "0X800B1BE", 0, 0, "", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Iterator localIterator = ((almg)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(paramQQAppInterface).iterator();
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      if (localRecentUser.getType() == 10012)
      {
        b(paramQQAppInterface);
      }
      else
      {
        alik.b(paramQQAppInterface, localRecentUser.uin, localRecentUser.type);
        paramQQAppInterface.getMessageFacade().setReaded(localRecentUser.uin, localRecentUser.type);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary, String paramString, int paramInt)
  {
    if (!((almg)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).b()) {
      return false;
    }
    paramString = paramQQAppInterface.getMessageFacade().getMsgList(paramString, paramInt);
    if ((paramString == null) || (paramString.size() <= 0)) {
      return false;
    }
    try
    {
      Object localObject = (MessageRecord)paramString.get(paramString.size() - 1);
      if (localObject != null)
      {
        paramString = ((MessageRecord)localObject).getExtInfoFromExtStr("temp_conv_biz_name");
        localObject = ((MessageRecord)localObject).getExtInfoFromExtStr("temp_conv_biz_content");
        if ((!paramString.equals("")) && (!((String)localObject).equals("")))
        {
          paramMsgSummary.prefixOfContent = String.format(paramQQAppInterface.getApplication().getString(2131719310), new Object[] { localObject, paramString });
          return true;
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("TempMsgBoxUtil", 1, "getMessageSourceFromMessageRecord: failed. ", paramQQAppInterface);
    }
    return false;
  }
  
  private static String b(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    String str = ContactUtils.getUinByPhoneNum(paramQQAppInterface, paramRecentUser.uin);
    Object localObject = (awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (localObject != null) {}
    for (localObject = ((awyz)localObject).c(paramRecentUser.uin);; localObject = null)
    {
      if (localObject != null) {
        return ((PhoneContact)localObject).name;
      }
      if (str != null) {
        return ContactUtils.getBuddyName(paramQQAppInterface, str, true);
      }
      return paramRecentUser.uin;
    }
  }
  
  public static Map<Integer, Integer> b()
  {
    return b;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    Iterator localIterator = allv.a(paramQQAppInterface).iterator();
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      alik.b(paramQQAppInterface, localRecentUser.uin, localRecentUser.type);
      paramQQAppInterface.getMessageFacade().setReaded(localRecentUser.uin, localRecentUser.type);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     almj
 * JD-Core Version:    0.7.0.1
 */