import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.qwallet.QWalletPrivacyFragment;
import cooperation.qwallet.plugin.QWalletPrivacyUtils;

public class akrj
  implements DialogInterface.OnClickListener
{
  public akrj(QWalletPrivacyFragment paramQWalletPrivacyFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QWalletPrivacyUtils.setHasClickAgree(this.a.getActivity().app);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrj
 * JD-Core Version:    0.7.0.1
 */