import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.TranslucentTRansferFragment;

public class afrb
  implements DialogInterface.OnDismissListener
{
  public afrb(TranslucentTRansferFragment paramTranslucentTRansferFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrb
 * JD-Core Version:    0.7.0.1
 */