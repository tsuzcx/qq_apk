import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class aiqh
  implements DialogInterface.OnClickListener
{
  public aiqh(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(this.a.getApplicationContext())) {
      QQToast.a(this.a, 2131694512, 1).a();
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqh
 * JD-Core Version:    0.7.0.1
 */