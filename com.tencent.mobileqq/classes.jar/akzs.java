import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class akzs
  implements DialogInterface.OnKeyListener
{
  akzs(akzr paramakzr, akzz paramakzz) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.jdField_a_of_type_Akzr.a(this.jdField_a_of_type_Akzz);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzs
 * JD-Core Version:    0.7.0.1
 */