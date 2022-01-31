import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.medalwall.MedalGuideView;

public class adsh
  implements DialogInterface.OnDismissListener
{
  public adsh(MedalGuideView paramMedalGuideView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    MedalGuideView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adsh
 * JD-Core Version:    0.7.0.1
 */