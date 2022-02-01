import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajex
  implements View.OnClickListener
{
  public ajex(ShowExternalTroopListActivity paramShowExternalTroopListActivity, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    bhaa.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.jdField_a_of_type_JavaLangString, 0);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.app;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity.jdField_a_of_type_Boolean) {}
    for (String str1 = "0";; str1 = "1")
    {
      bdla.b(localQQAppInterface, "P_CliOper", "Grp_join", "", "person_data", "Clk_user", 0, 0, str2, str1, "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajex
 * JD-Core Version:    0.7.0.1
 */