import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.AuthorityLoginView;

public class alas
  implements DialogInterface.OnClickListener
{
  public alas(AuthorityLoginView paramAuthorityLoginView, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      ThreadManager.executeOnSubThread(new alat(this));
    }
    while ((paramInt != 0) || (this.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView.a == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView.a.dismiss();
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alas
 * JD-Core Version:    0.7.0.1
 */