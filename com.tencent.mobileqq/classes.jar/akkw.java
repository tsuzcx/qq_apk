import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.utils.QQCustomDialog;

class akkw
  implements DialogInterface.OnKeyListener
{
  akkw(akkr paramakkr) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.a.a.dismiss();
      akkr.a(this.a, akkr.a(this.a), true, Long.valueOf(akkr.b(this.a)).longValue(), true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkw
 * JD-Core Version:    0.7.0.1
 */