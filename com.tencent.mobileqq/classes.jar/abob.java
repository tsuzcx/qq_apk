import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.armap.map.ARMapPOIStarDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;

public class abob
  implements View.OnClickListener
{
  public abob(ARMapPOIStarDialog paramARMapPOIStarDialog, long paramLong) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc01440", "", "", "0X8007AB2", "0X8007AB2", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapPOIStarDialog.jdField_a_of_type_Long, "" + this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapPOIStarDialog.b, "" + this.jdField_a_of_type_Long, "");
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapPOIStarDialog.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapPOIStarDialog.jdField_a_of_type_JavaLangString))
    {
      String str = new String(Base64.encode(this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapPOIStarDialog.jdField_a_of_type_JavaLangString.getBytes(), 0));
      str = URLUtil.a(this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapPOIStarDialog.d, "stid", str);
      if (QLog.isColorLevel()) {
        QLog.d("ARMapPOIStarDialog", 2, "jumpURL=" + str + "--- busiName=" + this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapPOIStarDialog.jdField_a_of_type_JavaLangString);
      }
      paramView.putExtra("url", str);
      this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapPOIStarDialog.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapPOIStarDialog.a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapPOIStarDialog.jdField_a_of_type_AndroidContentContext, "数据异常，请稍候再试", 1).b(this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapPOIStarDialog.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abob
 * JD-Core Version:    0.7.0.1
 */