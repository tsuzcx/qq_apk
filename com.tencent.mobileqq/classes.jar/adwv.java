import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class adwv
  implements DialogInterface.OnClickListener
{
  adwv(adws paramadws) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_Bdjz.cancel();
      this.a.b = true;
      adws.a(this.a);
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwv
 * JD-Core Version:    0.7.0.1
 */