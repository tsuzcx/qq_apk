import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.addfriendverifi.AddFriendBlockedInfo;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerifyBlockedListFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class ajic
  implements Manager
{
  public static int a;
  private anuw jdField_a_of_type_Anuw = new ajid(this);
  private anyu jdField_a_of_type_Anyu = new ajie(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  public List<AddFriendBlockedInfo> a;
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  private boolean f;
  
  public ajic(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.f = a(BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("e_add_friend_setting", 101));
    e("add_friend_blocked_expand_entrance");
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Anuw);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
  }
  
  public static ajic a(QQAppInterface paramQQAppInterface)
  {
    return (ajic)paramQQAppInterface.getManager(332);
  }
  
  public static void a(Activity paramActivity)
  {
    NewFriendVerifyBlockedListFragment.a(paramActivity);
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "innerReportAddFriend() isSuccess:" + paramBoolean);
    }
    if ((!paramBoolean) && (a(paramBundle.getInt("friend_setting"))))
    {
      String str = paramBundle.getString("uin");
      int i = paramBundle.getInt("source_id");
      int j = paramBundle.getInt("sub_source_id");
      paramBundle = paramBundle.getString("troop_uin");
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendVerification.manager", 2, "innerReportAddFriend  friendUin = " + str + " troopUin = " + paramBundle);
      }
      a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), str, i, j, paramBundle);
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4);
  }
  
  private boolean a(String paramString, Object paramObject)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("add_friend_blocked_cfg_sp", 0).edit();
    if (("add_friend_blocked_show_entrance".equals(paramString)) || ("add_friend_blocked_show_red_point".equals(paramString)) || ("add_friend_blocked_expand_entrance".equals(paramString))) {
      localEditor.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
    }
    for (;;)
    {
      return localEditor.commit();
      if ("add_friend_blocked_recent_uin".equals(paramString)) {
        localEditor.putString(paramString, (String)paramObject);
      } else if ("add_friend_blocked_friend_setting".equals(paramString)) {
        localEditor.putInt(paramString, ((Integer)paramObject).intValue());
      }
    }
  }
  
  private void d(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void e(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("add_friend_blocked_cfg_sp", 4);
    if ("add_friend_blocked_expand_entrance".equals(paramString)) {
      this.c = localSharedPreferences.getBoolean(paramString, true);
    }
    do
    {
      return;
      if ("add_friend_blocked_show_entrance".equals(paramString))
      {
        this.d = localSharedPreferences.getBoolean(paramString, false);
        return;
      }
      if ("add_friend_blocked_show_red_point".equals(paramString))
      {
        this.e = localSharedPreferences.getBoolean(paramString, false);
        return;
      }
      if ("add_friend_blocked_recent_uin".equals(paramString))
      {
        this.jdField_a_of_type_JavaLangString = localSharedPreferences.getString(paramString, "");
        return;
      }
    } while (!"add_friend_blocked_friend_setting".equals(paramString));
    this.f = a(localSharedPreferences.getInt(paramString, 101));
  }
  
  public int a()
  {
    int j = 0;
    int i;
    if ((this.d) && (this.c)) {
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendVerification.manager", 2, "getEntranceType, type=" + i + ", entrance=" + this.d + ", isEntranceExpand=" + this.c);
      }
      return i;
      i = j;
      if (this.d)
      {
        i = j;
        if (!this.c) {
          i = 3;
        }
      }
    }
  }
  
  public ajib a()
  {
    return (ajib)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(158);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "leaveNewFriend()");
    }
    this.e = false;
    this.c = false;
    a("add_friend_blocked_expand_entrance", Boolean.valueOf(false));
    if (jdField_a_of_type_Int > 0) {
      bdll.b(null, "dc00898", "", "", "0X800A3A3", "0X800A3A3", 0, jdField_a_of_type_Int, 0, "", "", "", "");
    }
    jdField_a_of_type_Int = 0;
  }
  
  public void a(String paramString)
  {
    if (this.f)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendVerification.manager", 2, "start -> getAddFriendBlockedList()");
      }
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      a().a(paramString, 500, "");
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "start --> reportAddFriendBlocked() friendUin :" + paramString1 + " friendSetting=" + paramInt1 + " troopUin = " + paramString2);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("friend_setting", paramInt1);
    localBundle.putString("uin", paramString1);
    localBundle.putInt("source_id", paramInt2);
    localBundle.putInt("sub_source_id", paramInt3);
    localBundle.putString("troop_uin", paramString2);
    a(false, localBundle);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, " onReportAddFriendBlocked()-->  success=  " + paramBoolean);
    }
    this.b = paramBoolean;
    a().notifyUI(2, paramBoolean, null);
  }
  
  public void a(boolean paramBoolean, List<AddFriendBlockedInfo> paramList, String paramString)
  {
    int i;
    if (paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append(" onGetAddFriendBlockedList()--> blockedInfos =  ");
        if (paramList == null) {
          break label191;
        }
        i = paramList.size();
        QLog.d("NewFriendVerification.manager", 2, i);
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendVerification.manager", 2, " onGetAddFriendBlockedList()--> isRead =  " + ((AddFriendBlockedInfo)paramList.get(0)).jdField_a_of_type_Boolean);
        }
        if (((AddFriendBlockedInfo)paramList.get(0)).jdField_a_of_type_Boolean) {
          break label197;
        }
      }
    }
    label191:
    label197:
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      a("add_friend_blocked_expand_entrance", Boolean.valueOf(this.c));
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      a().notifyUI(4, paramBoolean, new Object[] { paramList, paramString });
      return;
      i = 0;
      break;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      c(paramBoolean2);
      d(paramString);
    }
    a().notifyUI(5, paramBoolean1, new Object[] { Boolean.valueOf(paramBoolean2), paramString });
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    c(paramBoolean2);
    d(paramBoolean3);
    d(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, " onGetAddFriendBlockedRedPoint() --> isShowAddFriendBlockedEntrance =  " + paramBoolean2 + " isShowRedPoint =" + paramBoolean3 + " blockedUin =" + paramString);
    }
    a().notifyUI(3, paramBoolean1, new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), paramString });
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "isShowRedPoint, isShowRedPoint:" + this.e);
    }
    return this.e;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((AddFriendBlockedInfo)localIterator.next()).jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public void b(String paramString)
  {
    if (this.f)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendVerification.manager", 2, "start -> getAddFriendBlockedRedPoint() ");
      }
      a().b(paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, " onClearAddFriendBlockedList()-->  success=  " + paramBoolean);
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    a().notifyUI(1, paramBoolean, null);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, " start-> clearAddFriendBlockedList() uin = " + paramString);
    }
    a().a(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anuw);
      this.jdField_a_of_type_Anuw = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
      this.jdField_a_of_type_Anyu = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajic
 * JD-Core Version:    0.7.0.1
 */