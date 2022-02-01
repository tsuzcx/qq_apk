import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;

public class aknq
  implements DialogInterface.OnClickListener
{
  public aknq(BindNumberActivity paramBindNumberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    BindNumberActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aknq
 * JD-Core Version:    0.7.0.1
 */