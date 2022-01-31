import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;

public class ahsw
  implements DialogInterface.OnDismissListener
{
  public ahsw(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahsw
 * JD-Core Version:    0.7.0.1
 */