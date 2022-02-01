import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;

public class akoc
  implements DialogInterface.OnClickListener
{
  public akoc(BindVerifyActivity paramBindVerifyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.setResult(0);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akoc
 * JD-Core Version:    0.7.0.1
 */