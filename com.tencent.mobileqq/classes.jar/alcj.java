import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.LeftPopupMenuDialog;

public class alcj
  implements View.OnClickListener
{
  public alcj(LeftPopupMenuDialog paramLeftPopupMenuDialog) {}
  
  public void onClick(View paramView)
  {
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alcj
 * JD-Core Version:    0.7.0.1
 */