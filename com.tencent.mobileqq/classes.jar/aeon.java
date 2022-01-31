import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class aeon
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  
  aeon(aeom paramaeom) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 200L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_Aeom.jdField_a_of_type_Aeob.a();
    paramView = new Intent(aeom.a(this.jdField_a_of_type_Aeom), QQBrowserActivity.class);
    paramView.putExtra("hide_left_button", false);
    paramView.putExtra("show_right_close_button", false);
    paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
    String str = bant.a(aeom.a(this.jdField_a_of_type_Aeom), "call", "mvip.gongneng.anroid.individuation.web");
    VasWebviewUtil.openQQBrowserWithoutAD(aeom.a(this.jdField_a_of_type_Aeom), str, 524288L, paramView, false, -1);
    bajr.a(this.jdField_a_of_type_Aeom.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "QQVIPFUNCALL", "0X8004D8C", "0X8004D8C", 4, 0, new String[0]);
    paramView = this.jdField_a_of_type_Aeom.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    paramView.putInt("funcall_tip_" + this.jdField_a_of_type_Aeom.jdField_a_of_type_JavaLangString, 4);
    paramView.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeon
 * JD-Core Version:    0.7.0.1
 */