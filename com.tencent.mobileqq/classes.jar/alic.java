import android.app.Activity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.ControlPolicyUtil;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.MyAppApi.InstallParams;
import mqq.os.MqqHandler;

public class alic
  implements Runnable
{
  public alic(MyAppApi paramMyAppApi, Activity paramActivity, String paramString) {}
  
  public void run()
  {
    LogUtility.c("MyAppApi", "---isAutoInstall:" + ControlPolicyUtil.c() + " url:" + ControlPolicyUtil.a() + " interval:" + ControlPolicyUtil.a());
    if ((APNUtil.b(this.jdField_a_of_type_AndroidAppActivity)) && (APNUtil.c(this.jdField_a_of_type_AndroidAppActivity)))
    {
      boolean bool1 = ControlPolicyUtil.b();
      boolean bool2 = ControlPolicyUtil.j();
      String str = SharedPreUtils.k(this.jdField_a_of_type_AndroidAppActivity, "wifiAutoPreDown");
      if ((!this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.b()) && (bool1) && (bool2) && ("true".equals(str)))
      {
        ThreadManager.getUIHandler().post(new alid(this));
        LogUtility.c("MyAppApi", "---startDownloadYYB---");
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a = new MyAppApi.InstallParams(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi);
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.b = false;
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_AndroidOsBundle = null;
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_Int = -1;
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alic
 * JD-Core Version:    0.7.0.1
 */