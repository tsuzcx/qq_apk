import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity.30;

public class aaho
  implements DialogInterface.OnClickListener
{
  public aaho(AddFriendVerifyActivity.30 param30) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.this$0.a.cancel();
      this.a.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaho
 * JD-Core Version:    0.7.0.1
 */