import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;

public class afwy
  implements DialogInterface.OnClickListener
{
  public afwy(BindNumberActivity paramBindNumberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a("dc00898", "0X8009F15", 0);
    paramDialogInterface.dismiss();
    BindNumberActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afwy
 * JD-Core Version:    0.7.0.1
 */