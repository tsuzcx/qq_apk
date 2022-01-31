import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.TranslucentTRansferFragment;

public class acfn
  implements DialogInterface.OnDismissListener
{
  public acfn(TranslucentTRansferFragment paramTranslucentTRansferFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acfn
 * JD-Core Version:    0.7.0.1
 */