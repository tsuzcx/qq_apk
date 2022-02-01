import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;

public class aknu
  implements DialogInterface.OnClickListener
{
  public aknu(BindNumberActivity paramBindNumberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a("dc00898", "0X8009F15", 0);
    paramDialogInterface.dismiss();
    BindNumberActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aknu
 * JD-Core Version:    0.7.0.1
 */