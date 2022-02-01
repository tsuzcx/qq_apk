import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class adqv
  implements DialogInterface.OnClickListener
{
  adqv(adsx paramadsx, adsy paramadsy) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Adsx != null) {
      this.jdField_a_of_type_Adsx.a();
    }
    mqw.e(true, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    mqw.b(this.jdField_a_of_type_Adsy.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqv
 * JD-Core Version:    0.7.0.1
 */