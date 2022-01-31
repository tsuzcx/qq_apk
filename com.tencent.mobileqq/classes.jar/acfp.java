import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.activity.TranslucentTRansferFragment;

public class acfp
  implements DialogInterface.OnClickListener
{
  public acfp(TranslucentTRansferFragment paramTranslucentTRansferFragment, bbgg parambbgg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bbgg.dismiss();
    paramDialogInterface = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTranslucentTRansferFragment.getActivity(), RegisterPhoneNumActivity.class);
    paramDialogInterface.putExtra("invite_code", this.jdField_a_of_type_ComTencentMobileqqActivityTranslucentTRansferFragment.getActivity().getIntent().getStringExtra("invite_code"));
    this.jdField_a_of_type_ComTencentMobileqqActivityTranslucentTRansferFragment.startActivity(paramDialogInterface);
    axqw.b(null, "dc00898", "", "", "0X800970C", "0X800970C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acfp
 * JD-Core Version:    0.7.0.1
 */