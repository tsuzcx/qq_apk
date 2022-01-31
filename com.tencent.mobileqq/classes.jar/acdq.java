import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;

class acdq
  implements DialogInterface.OnClickListener
{
  acdq(acdp paramacdp, ayay paramayay) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramInt == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ayay.c)))
    {
      paramDialogInterface = new Intent(this.jdField_a_of_type_Acdp.a, SubLoginActivity.class);
      paramDialogInterface.putExtra("subuin", this.jdField_a_of_type_Ayay.c);
      paramDialogInterface.putExtra("fromWhere", this.jdField_a_of_type_Acdp.a.b);
      this.jdField_a_of_type_Acdp.a.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acdq
 * JD-Core Version:    0.7.0.1
 */