import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;

class abti
  implements DialogInterface.OnClickListener
{
  abti(abth paramabth, axau paramaxau) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramInt == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_Axau.c)))
    {
      paramDialogInterface = new Intent(this.jdField_a_of_type_Abth.a, SubLoginActivity.class);
      paramDialogInterface.putExtra("subuin", this.jdField_a_of_type_Axau.c);
      paramDialogInterface.putExtra("fromWhere", this.jdField_a_of_type_Abth.a.b);
      this.jdField_a_of_type_Abth.a.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abti
 * JD-Core Version:    0.7.0.1
 */