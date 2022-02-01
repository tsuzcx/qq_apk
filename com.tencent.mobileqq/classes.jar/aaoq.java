import android.os.Handler;
import android.os.Message;
import com.tencent.biz.subscribe.widget.AlphaLoadingView;

public class aaoq
  extends Handler
{
  public aaoq(AlphaLoadingView paramAlphaLoadingView) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (!AlphaLoadingView.a(this.a))
    {
      this.a.invalidate();
      sendEmptyMessageDelayed(1, AlphaLoadingView.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaoq
 * JD-Core Version:    0.7.0.1
 */