import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.TranslucentTRansferFragment;

public class aebm
  implements DialogInterface.OnDismissListener
{
  public aebm(TranslucentTRansferFragment paramTranslucentTRansferFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebm
 * JD-Core Version:    0.7.0.1
 */