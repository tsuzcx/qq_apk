import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class agwm
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  
  agwm(agwl paramagwl) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 200L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_Agwl.jdField_a_of_type_Agwa.a();
    paramView = new Intent(agwl.a(this.jdField_a_of_type_Agwl), QQBrowserActivity.class);
    paramView.putExtra("hide_left_button", false);
    paramView.putExtra("show_right_close_button", false);
    paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
    String str = bdox.a(agwl.a(this.jdField_a_of_type_Agwl), "call", "mvip.gongneng.anroid.individuation.web");
    VasWebviewUtil.openQQBrowserWithoutAD(agwl.a(this.jdField_a_of_type_Agwl), str, 524288L, paramView, false, -1);
    VipUtils.a(this.jdField_a_of_type_Agwl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "QQVIPFUNCALL", "0X8004D8C", "0X8004D8C", 4, 0, new String[0]);
    paramView = this.jdField_a_of_type_Agwl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    paramView.putInt("funcall_tip_" + this.jdField_a_of_type_Agwl.jdField_a_of_type_JavaLangString, 4);
    paramView.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwm
 * JD-Core Version:    0.7.0.1
 */