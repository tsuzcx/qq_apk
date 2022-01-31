import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment;

public class aggv
  implements DialogInterface.OnCancelListener
{
  public aggv(MiniMsgTabFragment paramMiniMsgTabFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    MiniMsgTabFragment.a(this.a, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aggv
 * JD-Core Version:    0.7.0.1
 */