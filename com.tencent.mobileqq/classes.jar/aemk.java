import android.os.Handler;
import android.os.Message;
import android.view.View;

class aemk
  extends Handler
{
  aemk(aemj paramaemj) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (this.a.p.isShown()) {
      this.a.p.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aemk
 * JD-Core Version:    0.7.0.1
 */