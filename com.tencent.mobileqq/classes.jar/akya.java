import android.graphics.PointF;
import com.tencent.mobileqq.worldcup.TouchSliceView;
import java.util.Deque;

public class akya
  implements Runnable
{
  public akya(TouchSliceView paramTouchSliceView) {}
  
  public void run()
  {
    if ((PointF)TouchSliceView.a(this.a).pollFirst() != null)
    {
      this.a.postInvalidate();
      this.a.postDelayed(this.a.a, 50);
    }
    while (!TouchSliceView.a(this.a)) {
      return;
    }
    this.a.postDelayed(this.a.a, 50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akya
 * JD-Core Version:    0.7.0.1
 */