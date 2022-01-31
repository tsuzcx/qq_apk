import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.teamwork.TeamWorkSaveDialog;

public class aimq
  implements View.OnClickListener
{
  public aimq(TeamWorkSaveDialog paramTeamWorkSaveDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkSaveDialog, 0);
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkSaveDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkSaveDialog.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimq
 * JD-Core Version:    0.7.0.1
 */