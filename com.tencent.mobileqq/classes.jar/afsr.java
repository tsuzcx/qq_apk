import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;

public class afsr
  implements DialogInterface.OnClickListener
{
  public afsr(TroopInfoActivity paramTroopInfoActivity, bhpc parambhpc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.finish();
    if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing())) {
      this.jdField_a_of_type_Bhpc.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsr
 * JD-Core Version:    0.7.0.1
 */