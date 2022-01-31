import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;

public class abia
  implements DialogInterface.OnDismissListener
{
  public abia(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!GesturePWDUnlockActivity.a(this.a))
    {
      GesturePWDUnlockActivity.a(this.a, true);
      return;
    }
    this.a.e();
    GesturePWDUtils.setGestureUnlockFailedType(this.a, 1);
    axrn.a(this.a.getBaseContext()).a(this.a.app, this.a.app.getCurrentAccountUin(), "Gesture_pwd", "click_wrong_pwd", 0, 1, "0", null, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abia
 * JD-Core Version:    0.7.0.1
 */