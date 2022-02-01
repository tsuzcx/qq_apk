import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afcc
  implements View.OnClickListener
{
  public afcc(TroopDisbandActivity paramTroopDisbandActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    TroopDisbandActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afcc
 * JD-Core Version:    0.7.0.1
 */