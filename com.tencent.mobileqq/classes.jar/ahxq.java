import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ahxq
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ahxq(ahxp paramahxp) {}
  
  public void onGlobalLayout()
  {
    if (this.a.S)
    {
      this.a.S = false;
      ahxp.a(this.a).sendEmptyMessageDelayed(23, 100L);
      if (QLog.isColorLevel()) {
        QLog.d(this.a.a, 2, " doOnCreate_initUI onGlobalLayout");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxq
 * JD-Core Version:    0.7.0.1
 */