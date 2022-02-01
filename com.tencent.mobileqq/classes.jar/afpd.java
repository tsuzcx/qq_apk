import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;

class afpd
  implements DialogInterface.OnClickListener
{
  afpd(afpc paramafpc, bdxd parambdxd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramInt == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bdxd.c)))
    {
      paramDialogInterface = new Intent(this.jdField_a_of_type_Afpc.a, SubLoginActivity.class);
      paramDialogInterface.putExtra("subuin", this.jdField_a_of_type_Bdxd.c);
      paramDialogInterface.putExtra("fromWhere", this.jdField_a_of_type_Afpc.a.b);
      this.jdField_a_of_type_Afpc.a.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpd
 * JD-Core Version:    0.7.0.1
 */