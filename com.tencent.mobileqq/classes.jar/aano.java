import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.arcard.ArCardSelectMemberActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class aano
  implements DialogInterface.OnClickListener
{
  public aano(ArCardSelectMemberActivity paramArCardSelectMemberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.g(this.a.getApplicationContext())) {
      QQToast.a(this.a, 2131437530, 1).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aano
 * JD-Core Version:    0.7.0.1
 */