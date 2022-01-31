import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.armap.ConversationARMap;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView.ARMapLoadingLaunchListener;
import com.tencent.mobileqq.armap.wealthgod.WealthGodInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;

public class abck
  implements ARMapSplashView.ARMapLoadingLaunchListener
{
  public abck(ConversationARMap paramConversationARMap) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "onStartARMapLoading");
    }
    Object localObject = (ARMapConfigManager)this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(189);
    ((ARMapConfigManager)localObject).c();
    if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(2004);
    }
    Intent localIntent = new Intent(this.a.jdField_a_of_type_AndroidAppActivity, ARMapLoadingActivity.class);
    localIntent.putExtra("extra_need_completed_response", true);
    localIntent.putExtra("entrance_from", 0);
    this.a.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    this.a.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
    if (this.a.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null) {
      this.a.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setEnableTouch(true);
    }
    if (((ARMapConfigManager)localObject).a() != null) {}
    for (localObject = "" + ((ARMapConfigManager)localObject).a().a;; localObject = "")
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a, "dc01440", "", "", "0X800783D", "0X800783D", 0, 0, "", "", "" + (String)localObject, "");
      return;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "onStartARMapLoadingCompleted");
    }
    if (ConversationARMap.a(this.a) != null) {
      ConversationARMap.a(this.a).setWealthGodOffset(1.0F);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abck
 * JD-Core Version:    0.7.0.1
 */