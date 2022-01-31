import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.RotateableView;

public class akii
  extends Handler
{
  public akii(RotateableView paramRotateableView) {}
  
  public void handleMessage(Message paramMessage)
  {
    RotateableView.a(this.a, RotateableView.a(this.a) + 8.0F);
    if (RotateableView.a(this.a) >= 360.0F) {
      RotateableView.a(this.a, RotateableView.a(this.a) - 360.0F);
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akii
 * JD-Core Version:    0.7.0.1
 */