import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class adsg
  implements DialogInterface.OnClickListener
{
  adsg(adsd paramadsd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_Bdfq.cancel();
      this.a.b = true;
      adsd.a(this.a);
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsg
 * JD-Core Version:    0.7.0.1
 */