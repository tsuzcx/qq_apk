import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.interestTag.ShowTagNamePopupWindow;
import com.tencent.mobileqq.nearby.interestTag.ShowTagNamePopupWindow.IShowTagNamePopupWindowCallback;

public class aezo
  implements View.OnClickListener
{
  public aezo(ShowTagNamePopupWindow paramShowTagNamePopupWindow) {}
  
  public void onClick(View paramView)
  {
    if (ShowTagNamePopupWindow.a(this.a) != null) {
      ShowTagNamePopupWindow.a(this.a).a(ShowTagNamePopupWindow.a(this.a));
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aezo
 * JD-Core Version:    0.7.0.1
 */