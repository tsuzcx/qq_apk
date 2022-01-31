import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class ackf
  implements DialogInterface.OnClickListener
{
  public ackf(acln paramacln, aclo paramaclo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Acln != null) {
      this.jdField_a_of_type_Acln.a();
    }
    mtq.e(true, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    mtq.b(this.jdField_a_of_type_Aclo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackf
 * JD-Core Version:    0.7.0.1
 */