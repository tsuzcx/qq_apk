import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class ajyv
  implements DialogInterface.OnKeyListener
{
  ajyv(ajyt paramajyt) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      ajyt.a(this.a, ajyt.a(this.a), Long.valueOf(ajyt.a(this.a)).longValue());
      ajyt.a(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyv
 * JD-Core Version:    0.7.0.1
 */