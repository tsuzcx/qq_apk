import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment;

public class aiey
  implements DialogInterface.OnCancelListener
{
  public aiey(MiniMsgTabFragment paramMiniMsgTabFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    MiniMsgTabFragment.a(this.a, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiey
 * JD-Core Version:    0.7.0.1
 */