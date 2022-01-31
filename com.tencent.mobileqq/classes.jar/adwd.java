import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.widget.immersive.ImmersiveUtils;

class adwd
  implements DialogInterface.OnDismissListener
{
  adwd(advv paramadvv) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (advv.a(this.a) != null)) {
      this.a.q();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adwd
 * JD-Core Version:    0.7.0.1
 */