import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.comic.VipComicJumpActivity;

public class altj
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public altj(VipComicJumpActivity paramVipComicJumpActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("pluginsdk_pluginLocation");
    paramContext = paramIntent.getStringExtra("pluginsdk_launchReceiver");
    String str = paramIntent.getAction();
    if (((!TextUtils.isEmpty(str)) && ("com.tencent.mobileqq.PreLoadComicProcess".equals(str))) || ((paramContext != null) && (paramContext.equals("com.qqcomic.app.VipPreloadComicProcess")))) {
      if (!this.jdField_a_of_type_CooperationComicVipComicJumpActivity.b)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "do handle launch activity in receiver.");
        }
        this.jdField_a_of_type_CooperationComicVipComicJumpActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1000);
        this.jdField_a_of_type_CooperationComicVipComicJumpActivity.b = true;
        this.jdField_a_of_type_CooperationComicVipComicJumpActivity.c = false;
        this.jdField_a_of_type_CooperationComicVipComicJumpActivity.c(this.jdField_a_of_type_CooperationComicVipComicJumpActivity.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam);
      }
    }
    while ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("comic_plugin.apk")))
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("QQComicDebug", 2, "skip handle launch activity in receiver.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipComicJumpActivity", 2, "LaunchCompletedObserver.onReceive: " + this.jdField_a_of_type_JavaLangString);
    }
    this.b = paramIntent.getStringExtra("pluginsdk_extraInfo");
    if ((this.b != null) && ("success".equals(this.b))) {
      this.jdField_a_of_type_CooperationComicVipComicJumpActivity.a(this.jdField_a_of_type_CooperationComicVipComicJumpActivity.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_CooperationComicVipComicJumpActivity.finish();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQComicDebug", 2, "launch activity finish, leave jump activity.");
      return;
      this.jdField_a_of_type_CooperationComicVipComicJumpActivity.a(this.jdField_a_of_type_CooperationComicVipComicJumpActivity.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam, -2);
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "LaunchCompletedObserver.onReceive mExtraInfo: " + this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     altj
 * JD-Core Version:    0.7.0.1
 */