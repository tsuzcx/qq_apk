import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.forward.ForwardFileBaseOption;

public class adks
  implements DialogInterface.OnDismissListener
{
  public adks(ForwardFileBaseOption paramForwardFileBaseOption) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (ForwardFileBaseOption.a(this.a))
    {
      ForwardFileBaseOption.a(this.a, false);
      this.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adks
 * JD-Core Version:    0.7.0.1
 */