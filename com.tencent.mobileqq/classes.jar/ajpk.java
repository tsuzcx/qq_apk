import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class ajpk
  implements DialogInterface.OnKeyListener
{
  ajpk(ajpi paramajpi) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      ajpi.a(this.a, ajpi.a(this.a), Long.valueOf(ajpi.a(this.a)).longValue());
      ajpi.a(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpk
 * JD-Core Version:    0.7.0.1
 */