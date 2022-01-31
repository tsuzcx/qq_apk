import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class agpq
  implements DialogInterface.OnKeyListener
{
  agpq(agpl paramagpl) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.a.a.dismiss();
      agpl.a(this.a, agpl.a(this.a), true, Long.valueOf(agpl.b(this.a)).longValue(), true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agpq
 * JD-Core Version:    0.7.0.1
 */