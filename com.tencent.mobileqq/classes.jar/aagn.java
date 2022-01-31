import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.arcard.ArCardSelectMemberActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class aagn
  implements DialogInterface.OnClickListener
{
  public aagn(ArCardSelectMemberActivity paramArCardSelectMemberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.g(this.a.getApplicationContext())) {
      QQToast.a(this.a, 2131437513, 1).a();
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      ArCardSelectMemberActivity.a(this.a, null);
      return;
      this.a.u();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aagn
 * JD-Core Version:    0.7.0.1
 */