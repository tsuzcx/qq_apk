import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;

public class adyn
  implements DialogInterface.OnClickListener
{
  public adyn(TroopInfoActivity paramTroopInfoActivity, bdfq parambdfq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.finish();
    if ((this.jdField_a_of_type_Bdfq != null) && (this.jdField_a_of_type_Bdfq.isShowing())) {
      this.jdField_a_of_type_Bdfq.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyn
 * JD-Core Version:    0.7.0.1
 */