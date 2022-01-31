import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.SlideTabWidget;

public class akip
  extends Handler
{
  public akip(SlideTabWidget paramSlideTabWidget) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      SlideTabWidget.a(this.a, 0.0F);
      SlideTabWidget.a(this.a, (float)(SlideTabWidget.a(this.a) + 0.1D));
      this.a.invalidate();
      sendMessageDelayed(SlideTabWidget.a(this.a).obtainMessage(1), 10L);
      return;
    case 1: 
      if (SlideTabWidget.a(this.a) < 1.0F)
      {
        SlideTabWidget.a(this.a, (float)(SlideTabWidget.a(this.a) + 0.1D));
        if (SlideTabWidget.a(this.a) >= 1.0F) {
          SlideTabWidget.a(this.a, false);
        }
        this.a.invalidate();
        sendMessageDelayed(SlideTabWidget.a(this.a).obtainMessage(1), 10L);
        return;
      }
      sendMessageDelayed(SlideTabWidget.a(this.a).obtainMessage(2), 10L);
      return;
    }
    SlideTabWidget.a(this.a, 1.0F);
    SlideTabWidget.a(this.a, SlideTabWidget.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akip
 * JD-Core Version:    0.7.0.1
 */