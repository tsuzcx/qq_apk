import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;

class aezd
  implements DialogInterface.OnClickListener
{
  aezd(aezc paramaezc, bdxt parambdxt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramInt == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bdxt.c)))
    {
      paramDialogInterface = new Intent(this.jdField_a_of_type_Aezc.a, SubLoginActivity.class);
      paramDialogInterface.putExtra("subuin", this.jdField_a_of_type_Bdxt.c);
      paramDialogInterface.putExtra("fromWhere", this.jdField_a_of_type_Aezc.a.b);
      this.jdField_a_of_type_Aezc.a.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aezd
 * JD-Core Version:    0.7.0.1
 */