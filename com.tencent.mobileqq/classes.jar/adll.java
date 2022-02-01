import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.CompoundButton;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import mqq.util.WeakReference;

public class adll
  implements DialogInterface.OnDismissListener
{
  WeakReference<GeneralSettingActivity> a;
  WeakReference<CompoundButton> b;
  
  public adll(GeneralSettingActivity paramGeneralSettingActivity, CompoundButton paramCompoundButton)
  {
    this.a = new WeakReference(paramGeneralSettingActivity);
    this.b = new WeakReference(paramCompoundButton);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    CompoundButton localCompoundButton = null;
    if (this.a == null)
    {
      paramDialogInterface = null;
      if (this.b != null) {
        break label47;
      }
    }
    for (;;)
    {
      if ((paramDialogInterface != null) && (localCompoundButton != null)) {
        paramDialogInterface.a(localCompoundButton, false);
      }
      return;
      paramDialogInterface = (GeneralSettingActivity)this.a.get();
      break;
      label47:
      localCompoundButton = (CompoundButton)this.b.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adll
 * JD-Core Version:    0.7.0.1
 */