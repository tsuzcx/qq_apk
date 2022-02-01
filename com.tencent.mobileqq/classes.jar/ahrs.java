import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.widget.immersive.ImmersiveUtils;

class ahrs
  implements DialogInterface.OnDismissListener
{
  ahrs(ahri paramahri) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (ahri.a(this.a) != null)) {
      this.a.r();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrs
 * JD-Core Version:    0.7.0.1
 */