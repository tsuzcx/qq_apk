import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.gdtad.views.form.framework.GdtFormTableView;
import com.tencent.gdtad.views.form.framework.GdtFormTableView.1.1;

public class aaub
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public aaub(GdtFormTableView paramGdtFormTableView) {}
  
  public void onGlobalLayout()
  {
    this.a.a(-1);
    this.a.post(new GdtFormTableView.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaub
 * JD-Core Version:    0.7.0.1
 */