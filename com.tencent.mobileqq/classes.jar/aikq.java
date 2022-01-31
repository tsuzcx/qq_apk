import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class aikq
  implements DialogInterface.OnKeyListener
{
  aikq(aikl paramaikl) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.a.a.dismiss();
      aikl.a(this.a, aikl.a(this.a), true, Long.valueOf(aikl.b(this.a)).longValue(), true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikq
 * JD-Core Version:    0.7.0.1
 */