import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class afmj
  implements DialogInterface.OnClickListener
{
  afmj(afmg paramafmg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_Bhpc.cancel();
      this.a.b = true;
      afmg.a(this.a);
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afmj
 * JD-Core Version:    0.7.0.1
 */