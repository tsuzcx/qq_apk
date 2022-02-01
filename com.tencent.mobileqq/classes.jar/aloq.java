import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;

public class aloq
  implements DialogInterface.OnDismissListener
{
  public aloq(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (EditLocalVideoActivity.a(this.a) != null) {
      EditLocalVideoActivity.a(this.a).setVisibility(0);
    }
    if (EditLocalVideoActivity.a(this.a) != null) {
      EditLocalVideoActivity.a(this.a).setVisibility(0);
    }
    if ((EditLocalVideoActivity.a(this.a) != null) && (EditLocalVideoActivity.a(this.a) != 1)) {
      EditLocalVideoActivity.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aloq
 * JD-Core Version:    0.7.0.1
 */