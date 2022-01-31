import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.RegisterActivity;

public class abyf
  implements DialogInterface.OnClickListener
{
  public abyf(RegisterActivity paramRegisterActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abyf
 * JD-Core Version:    0.7.0.1
 */