import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class aaow
  implements DialogInterface.OnClickListener
{
  public aaow(aaqe paramaaqe, aaqf paramaaqf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Aaqe != null) {
      this.jdField_a_of_type_Aaqe.a();
    }
    mqz.e(true, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    mqz.b(this.jdField_a_of_type_Aaqf.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaow
 * JD-Core Version:    0.7.0.1
 */