import android.app.Activity;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.ControlPolicyUtil;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.MyAppApi.InstallParams;

public class alpx
  implements Runnable
{
  public alpx(MyAppApi paramMyAppApi, boolean paramBoolean, Activity paramActivity, String paramString) {}
  
  public void run()
  {
    LogUtility.c("MyAppApi", "---isAutoInstall:" + ControlPolicyUtil.c() + " url:" + ControlPolicyUtil.a() + " interval:" + ControlPolicyUtil.a());
    boolean bool = ControlPolicyUtil.b();
    if ((!this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.b()) && (bool))
    {
      LogUtility.c("MyAppApi", "---startDownloadYYB---");
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a = new MyAppApi.InstallParams(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi);
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.b = false;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_AndroidOsBundle = null;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_Int = -1;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alpx
 * JD-Core Version:    0.7.0.1
 */