import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;

class adzo
  implements DialogInterface.OnClickListener
{
  adzo(adzn paramadzn, bade parambade) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramInt == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bade.c)))
    {
      paramDialogInterface = new Intent(this.jdField_a_of_type_Adzn.a, SubLoginActivity.class);
      paramDialogInterface.putExtra("subuin", this.jdField_a_of_type_Bade.c);
      paramDialogInterface.putExtra("fromWhere", this.jdField_a_of_type_Adzn.a.b);
      this.jdField_a_of_type_Adzn.a.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzo
 * JD-Core Version:    0.7.0.1
 */