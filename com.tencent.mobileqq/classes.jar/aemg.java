import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class aemg
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aemg(aemf paramaemf) {}
  
  public void onGlobalLayout()
  {
    if (this.a.T)
    {
      this.a.T = false;
      aemf.a(this.a).sendEmptyMessageDelayed(23, 100L);
      if (QLog.isColorLevel()) {
        QLog.d(this.a.a, 2, " doOnCreate_initUI onGlobalLayout");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aemg
 * JD-Core Version:    0.7.0.1
 */