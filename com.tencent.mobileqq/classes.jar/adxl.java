import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

class adxl
  implements Runnable
{
  adxl(adxk paramadxk, boolean paramBoolean) {}
  
  public void run()
  {
    String str;
    if (this.jdField_a_of_type_Boolean)
    {
      str = UiApiPlugin.a("0", null, null, this.jdField_a_of_type_Adxk.d);
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, 0, "", "", "", "");
    }
    for (int i = 2131430705;; i = 2131430706)
    {
      QQToast.a(this.jdField_a_of_type_Adxk.jdField_a_of_type_AndroidAppActivity, i, 0).b(this.jdField_a_of_type_Adxk.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131558448));
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_dialog_click", 0, 1, 0, "", "", "", "");
      this.jdField_a_of_type_Adxk.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_Adxk.e, new String[] { str });
      return;
      str = UiApiPlugin.a("-3", null, "createShortcut failed, iconUrl is invalide: " + this.jdField_a_of_type_Adxk.c, this.jdField_a_of_type_Adxk.d);
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -1, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxl
 * JD-Core Version:    0.7.0.1
 */