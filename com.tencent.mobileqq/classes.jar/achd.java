import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;

public class achd
  implements DialogInterface.OnClickListener
{
  public achd(TroopInfoActivity paramTroopInfoActivity, bbgu parambbgu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.finish();
    if ((this.jdField_a_of_type_Bbgu != null) && (this.jdField_a_of_type_Bbgu.isShowing())) {
      this.jdField_a_of_type_Bbgu.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     achd
 * JD-Core Version:    0.7.0.1
 */