import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.DialogActivity;

public class acpg
  implements DialogInterface.OnClickListener
{
  public acpg(DialogActivity paramDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    badt.a(this.a.app, this.a);
    this.a.finish();
    azmj.b(this.a.app, "dc00898", "", "", "0X800906A", "0X800906A", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpg
 * JD-Core Version:    0.7.0.1
 */