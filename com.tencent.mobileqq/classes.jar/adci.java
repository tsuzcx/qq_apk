import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ContactBindedActivity;

public class adci
  implements DialogInterface.OnClickListener
{
  public adci(ContactBindedActivity paramContactBindedActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ContactBindedActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adci
 * JD-Core Version:    0.7.0.1
 */