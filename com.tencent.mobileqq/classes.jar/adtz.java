import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;

public class adtz
  implements DialogInterface.OnClickListener
{
  public adtz(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AddRequestActivity.a(this.a).dismiss();
    AddRequestActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtz
 * JD-Core Version:    0.7.0.1
 */