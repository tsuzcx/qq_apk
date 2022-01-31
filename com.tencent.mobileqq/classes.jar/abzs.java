import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.SearchDialogDismissRunnable;

public class abzs
  implements DialogInterface.OnDismissListener
{
  public abzs(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a.postDelayed(new TroopMemberListActivity.SearchDialogDismissRunnable(this.a), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abzs
 * JD-Core Version:    0.7.0.1
 */