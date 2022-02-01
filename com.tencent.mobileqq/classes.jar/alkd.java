import android.os.Message;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_8410;

public class alkd
  implements Manager
{
  alkf jdField_a_of_type_Alkf;
  alkj jdField_a_of_type_Alkj = alkj.jdField_a_of_type_Alkj;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private oidb_0x59f.Guidelines_8410 jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410;
  
  public alkd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Alkf = new alkf(paramQQAppInterface);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Alkf);
  }
  
  private <T> void a(List<T> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    int k;
    for (int j = -1;; j = k)
    {
      if (paramList.hasNext())
      {
        Object localObject = paramList.next();
        if (!(localObject instanceof RecentItemMayKnowFriendData))
        {
          k = j;
          if (!(localObject instanceof RecentItemMayKnowFriendVerticalListData)) {}
        }
        else
        {
          paramList.remove();
          k = j;
          if (j < 0) {
            k = i;
          }
        }
        if ((i < 9) || (k >= 0)) {}
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    int i = alka.a().a();
    QLog.d("NewerGuideBannerManager", 1, "[requestConfigData] expId: " + i);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((alkc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NEWER_GUIDE_BANNER_HANDLER)).a();
    }
  }
  
  public <T> void a(List<T> paramList, aldh paramaldh)
  {
    if ((paramList == null) || (paramaldh == null)) {}
    do
    {
      return;
      if (paramaldh.b())
      {
        a(paramList);
        return;
      }
    } while (a(paramList));
    d();
  }
  
  void a(oidb_0x59f.Guidelines_8410 paramGuidelines_8410)
  {
    this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410 = paramGuidelines_8410;
    boolean bool = a(paramGuidelines_8410);
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerManager", 2, "showNewerGuideBannerIfNeed needShow -> " + bool);
    }
    if (!bool)
    {
      b();
      return;
    }
    e();
  }
  
  public <T> boolean a(List<T> paramList)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerManager", 2, "canShowNewerGuideBanner");
    }
    boolean bool1 = bool2;
    int i;
    if (paramList != null)
    {
      bool1 = bool2;
      if (paramList.size() > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < Math.min(10, paramList.size()))
      {
        Object localObject = paramList.get(i);
        if (((localObject instanceof RecentItemMayKnowFriendData)) || ((localObject instanceof RecentItemMayKnowFriendVerticalListData))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  boolean a(oidb_0x59f.Guidelines_8410 paramGuidelines_8410)
  {
    boolean bool = true;
    if ((paramGuidelines_8410 != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      int i = paramGuidelines_8410.uint32_banner_status.get();
      if (i == 0) {
        return false;
      }
      paramGuidelines_8410 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (i == 2) {
        this.jdField_a_of_type_Alkj.a(paramGuidelines_8410);
      }
    }
    for (;;)
    {
      return bool;
      if (this.jdField_a_of_type_Alkj.a(paramGuidelines_8410) > 0L)
      {
        bool = false;
        continue;
        bool = false;
      }
    }
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerManager", 2, "hideNewerGuideBanner");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1134211);
      }
    }
  }
  
  void c()
  {
    if ((this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410 != null) && (this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410.uint32_banner_status.has()) && (this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410.uint32_banner_status.get() == 2)) {
      this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410.uint32_banner_status.set(1);
    }
  }
  
  public void d()
  {
    a(this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410);
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerManager", 2, "showNewerGuideBanner called");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410 != null))
    {
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandlerWithoutDefault(Conversation.class);
      if (localMqqHandler == null) {
        break label67;
      }
      localMessage = Message.obtain();
      localMessage.what = 1134210;
      localMessage.obj = this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410;
      localMqqHandler.sendMessage(localMessage);
    }
    label67:
    while (!QLog.isColorLevel())
    {
      Message localMessage;
      return;
    }
    QLog.d("NewerGuideBannerManager", 2, "showNewerGuideBanner get handler fail null");
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerManager", 2, "onDestroy, instance manager -> " + this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alkf);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    this.jdField_a_of_type_Alkf = null;
    this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410 = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkd
 * JD-Core Version:    0.7.0.1
 */