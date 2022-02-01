import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahre
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  
  ahre(ahrd paramahrd) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 200L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Ahrd.jdField_a_of_type_Ahqs.a();
      Object localObject = new Intent(ahrd.a(this.jdField_a_of_type_Ahrd), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("hide_left_button", false);
      ((Intent)localObject).putExtra("show_right_close_button", false);
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      String str = bgev.a(ahrd.a(this.jdField_a_of_type_Ahrd), "call", "mvip.gongneng.anroid.individuation.web");
      VasWebviewUtil.openQQBrowserWithoutAD(ahrd.a(this.jdField_a_of_type_Ahrd), str, 524288L, (Intent)localObject, false, -1);
      VipUtils.a(this.jdField_a_of_type_Ahrd.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "QQVIPFUNCALL", "0X8004D8C", "0X8004D8C", 4, 0, new String[0]);
      localObject = this.jdField_a_of_type_Ahrd.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
      ((SharedPreferences.Editor)localObject).putInt("funcall_tip_" + this.jdField_a_of_type_Ahrd.jdField_a_of_type_JavaLangString, 4);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahre
 * JD-Core Version:    0.7.0.1
 */