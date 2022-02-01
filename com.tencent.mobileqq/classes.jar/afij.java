import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class afij
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  afij(afii paramafii) {}
  
  public void onGlobalLayout()
  {
    if (this.a.b)
    {
      this.a.b = false;
      this.a.uiHandler.sendEmptyMessageDelayed(23, 100L);
      if (QLog.isColorLevel()) {
        QLog.d(this.a.tag, 2, " doOnCreate_initUI onGlobalLayout");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afij
 * JD-Core Version:    0.7.0.1
 */