import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class aafe
  implements DialogInterface.OnClickListener
{
  public aafe(aagm paramaagm, aagn paramaagn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Aagm != null) {
      this.jdField_a_of_type_Aagm.a();
    }
    mga.e(true, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    mga.b(this.jdField_a_of_type_Aagn.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aafe
 * JD-Core Version:    0.7.0.1
 */