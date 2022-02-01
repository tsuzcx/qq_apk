import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class acqr
  implements DialogInterface.OnClickListener
{
  public acqr(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (AddRequestActivity.c(this.a, AddRequestActivity.e(this.a)))
    {
      AddRequestActivity.b(this.a, 2131718142, 1000L, false);
      AddRequestActivity.a(this.a, AddRequestActivity.e(this.a));
    }
    AddRequestActivity.a(this.a).dismiss();
    AddRequestActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqr
 * JD-Core Version:    0.7.0.1
 */