import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.utils.JumpAction;

public class ajom
  implements DialogInterface.OnDismissListener
{
  public ajom(JumpAction paramJumpAction) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.a.a instanceof LoginActivity)) {
      ((LoginActivity)this.a.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ajom
 * JD-Core Version:    0.7.0.1
 */