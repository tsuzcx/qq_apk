import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class alkv
  implements View.OnClickListener
{
  public alkv(ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (ActionSheet.a(this.a) != null) {
      ActionSheet.a(this.a).onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     alkv
 * JD-Core Version:    0.7.0.1
 */