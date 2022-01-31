import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;

public class ajkh
  implements DialogInterface.OnShowListener
{
  public ajkh(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (EditLocalVideoActivity.a(this.a) != null) {
      EditLocalVideoActivity.a(this.a).setVisibility(8);
    }
    if (EditLocalVideoActivity.a(this.a) != null) {
      EditLocalVideoActivity.a(this.a).setVisibility(8);
    }
    if ((EditLocalVideoActivity.a(this.a) != null) && (EditLocalVideoActivity.a(this.a) != 1)) {
      EditLocalVideoActivity.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkh
 * JD-Core Version:    0.7.0.1
 */