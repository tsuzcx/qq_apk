import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.widget.immersive.ImmersiveUtils;

class agdq
  implements DialogInterface.OnDismissListener
{
  agdq(agdi paramagdi) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (agdi.a(this.a) != null)) {
      this.a.q();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdq
 * JD-Core Version:    0.7.0.1
 */