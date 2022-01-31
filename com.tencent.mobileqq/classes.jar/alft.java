import com.tencent.mobileqq.worldcup.TouchSliceView;
import java.util.Deque;

public class alft
  implements Runnable
{
  public alft(TouchSliceView paramTouchSliceView) {}
  
  public void run()
  {
    TouchSliceView.a(this.a).clear();
    this.a.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alft
 * JD-Core Version:    0.7.0.1
 */