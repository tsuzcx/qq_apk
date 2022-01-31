import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.LeftPopupMenuDialog;

public class akgl
  implements View.OnClickListener
{
  public akgl(LeftPopupMenuDialog paramLeftPopupMenuDialog) {}
  
  public void onClick(View paramView)
  {
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akgl
 * JD-Core Version:    0.7.0.1
 */