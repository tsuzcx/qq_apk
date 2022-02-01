import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class adzw
  implements DialogInterface.OnClickListener
{
  adzw(aebz paramaebz, aeca paramaeca) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Aebz != null) {
      this.jdField_a_of_type_Aebz.a();
    }
    mru.e(true, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    mru.b(this.jdField_a_of_type_Aeca.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzw
 * JD-Core Version:    0.7.0.1
 */