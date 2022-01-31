import android.view.View;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;

public class afck
  implements Runnable
{
  public afck(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void run()
  {
    ShortVideoCommentsView.c(this.a, false);
    ShortVideoCommentsView.a(this.a);
    ShortVideoCommentsView.a(this.a).setVisibility(8);
    ShortVideoCommentsView.a(this.a, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afck
 * JD-Core Version:    0.7.0.1
 */