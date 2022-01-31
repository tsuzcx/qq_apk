import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;

public class agix
  implements DialogInterface.OnClickListener
{
  public agix(BindNumberActivity paramBindNumberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agix
 * JD-Core Version:    0.7.0.1
 */