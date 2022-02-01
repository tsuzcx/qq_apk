import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.qphone.base.util.QLog;

public class akho
  implements DialogInterface.OnClickListener
{
  public akho(BindVerifyActivity paramBindVerifyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindVerifyActivity", 2, "new user guild confirm unbind");
    }
    BindVerifyActivity.a(this.a);
    this.a.a(2131718527, 1000L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akho
 * JD-Core Version:    0.7.0.1
 */