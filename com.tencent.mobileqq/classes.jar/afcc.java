import android.view.View;
import android.widget.ListView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import mqq.os.MqqHandler;

public class afcc
  implements Runnable
{
  public afcc(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void run()
  {
    if ((ShortVideoCommentsView.a(this.a) != null) && (ShortVideoCommentsView.a(this.a).getChildCount() > 0))
    {
      if (ShortVideoCommentsView.a(this.a).getChildAt(0).getTop() != 0)
      {
        ShortVideoCommentsView.a(this.a).setSelection(0);
        ThreadManager.getUIHandler().postDelayed(this, 10L);
      }
    }
    else {
      return;
    }
    ThreadManager.getUIHandler().removeCallbacks(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afcc
 * JD-Core Version:    0.7.0.1
 */