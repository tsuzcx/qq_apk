import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class akrk
  implements DialogInterface.OnKeyListener
{
  akrk(akrf paramakrf) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.a.a.dismiss();
      akrf.a(this.a, akrf.a(this.a), true, Long.valueOf(akrf.b(this.a)).longValue(), true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrk
 * JD-Core Version:    0.7.0.1
 */