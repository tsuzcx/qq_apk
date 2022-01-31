import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class aeme
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aeme(aemd paramaemd) {}
  
  public void onGlobalLayout()
  {
    if (this.a.T)
    {
      this.a.T = false;
      aemd.a(this.a).sendEmptyMessageDelayed(23, 100L);
      if (QLog.isColorLevel()) {
        QLog.d(this.a.a, 2, " doOnCreate_initUI onGlobalLayout");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeme
 * JD-Core Version:    0.7.0.1
 */