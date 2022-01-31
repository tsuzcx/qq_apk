import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EditActivity;

public class aazw
  implements View.OnClickListener
{
  public aazw(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    if ((EditActivity.a(this.a) != null) && (EditActivity.a(this.a).isShowing()) && (EditActivity.a(this.a).getWindow() != null)) {
      EditActivity.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aazw
 * JD-Core Version:    0.7.0.1
 */