import com.tencent.mobileqq.worldcup.TouchSliceView;
import java.util.Deque;

public class akyb
  implements Runnable
{
  public akyb(TouchSliceView paramTouchSliceView) {}
  
  public void run()
  {
    TouchSliceView.a(this.a).clear();
    this.a.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akyb
 * JD-Core Version:    0.7.0.1
 */