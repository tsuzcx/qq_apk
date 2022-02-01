import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.widget.immersive.ImmersiveUtils;

class aicb
  implements DialogInterface.OnDismissListener
{
  aicb(aibr paramaibr) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (aibr.a(this.a) != null)) {
      this.a.r();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicb
 * JD-Core Version:    0.7.0.1
 */