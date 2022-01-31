import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.widget.QQToast;

public class ahdc
  implements DialogInterface.OnClickListener
{
  public ahdc(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bdin.g(this.a.getApplicationContext())) {
      QQToast.a(this.a, 2131695131, 1).a();
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdc
 * JD-Core Version:    0.7.0.1
 */