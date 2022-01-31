import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout;

public class aluz
  implements DialogInterface.OnClickListener
{
  public aluz(SwipePostTableLayout paramSwipePostTableLayout) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (SwipePostTableLayout.a(this.a).isShowing()) {
      SwipePostTableLayout.a(this.a).dismiss();
    }
    aluq.a(this.a.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aluz
 * JD-Core Version:    0.7.0.1
 */