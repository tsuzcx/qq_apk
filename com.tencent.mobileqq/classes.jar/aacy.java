import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;

public class aacy
  implements DialogInterface.OnDismissListener
{
  public aacy(FollowTextView paramFollowTextView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    FollowTextView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacy
 * JD-Core Version:    0.7.0.1
 */