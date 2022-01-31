import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.util.Pair;

public class adzv
  implements DialogInterface.OnClickListener
{
  public adzv(SubAccountUgActivity paramSubAccountUgActivity, bacu parambacu, Pair paramPair) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bacu.a((String)this.jdField_a_of_type_ComTencentUtilPair.first, ((Integer)this.jdField_a_of_type_ComTencentUtilPair.second).intValue(), true);
    if (!bacu.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.app))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.setTitle("");
      bact.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzv
 * JD-Core Version:    0.7.0.1
 */