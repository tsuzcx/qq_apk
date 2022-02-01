import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.RiskHintDlgFragment;

public class aflc
  implements DialogInterface.OnDismissListener
{
  public aflc(RiskHintDlgFragment paramRiskHintDlgFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.getActivity() != null)
    {
      this.a.getActivity().finish();
      this.a.getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aflc
 * JD-Core Version:    0.7.0.1
 */