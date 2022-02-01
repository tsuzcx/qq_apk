import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class adhc
  implements DialogInterface.OnClickListener
{
  public adhc(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AddRequestActivity.a(this.a).dismiss();
    AddRequestActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhc
 * JD-Core Version:    0.7.0.1
 */