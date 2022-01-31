import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class agdu
  implements DialogInterface.OnKeyListener
{
  agdu(agdp paramagdp) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.a.a.dismiss();
      agdp.a(this.a, agdp.a(this.a), true, Long.valueOf(agdp.b(this.a)).longValue(), true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agdu
 * JD-Core Version:    0.7.0.1
 */