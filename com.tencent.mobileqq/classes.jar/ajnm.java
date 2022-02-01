import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class ajnm
  implements DialogInterface.OnKeyListener
{
  ajnm(ajnk paramajnk) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      ajnk.a(this.a, ajnk.a(this.a), Long.valueOf(ajnk.a(this.a)).longValue());
      ajnk.a(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnm
 * JD-Core Version:    0.7.0.1
 */