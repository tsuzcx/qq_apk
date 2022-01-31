import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class afvf
  implements DialogInterface.OnKeyListener
{
  afvf(afup paramafup) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      afup.a(this.a, afup.a(this.a), Long.valueOf(afup.a(this.a)).longValue());
      afup.a(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvf
 * JD-Core Version:    0.7.0.1
 */