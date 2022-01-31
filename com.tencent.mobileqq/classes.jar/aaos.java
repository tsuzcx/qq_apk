import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class aaos
  implements DialogInterface.OnClickListener
{
  public aaos(aaqa paramaaqa, aaqb paramaaqb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Aaqa != null) {
      this.jdField_a_of_type_Aaqa.a();
    }
    mqw.e(true, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    mqw.b(this.jdField_a_of_type_Aaqb.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaos
 * JD-Core Version:    0.7.0.1
 */