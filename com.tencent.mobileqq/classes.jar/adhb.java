import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class adhb
  implements DialogInterface.OnClickListener
{
  public adhb(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (AddRequestActivity.c(this.a, AddRequestActivity.e(this.a)))
    {
      AddRequestActivity.b(this.a, 2131718527, 1000L, false);
      AddRequestActivity.a(this.a, AddRequestActivity.e(this.a));
    }
    AddRequestActivity.a(this.a).dismiss();
    AddRequestActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhb
 * JD-Core Version:    0.7.0.1
 */