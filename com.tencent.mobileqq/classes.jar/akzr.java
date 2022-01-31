import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordButtonView;
import com.tencent.qphone.base.util.QLog;

class akzr
  implements View.OnTouchListener
{
  akzr(akzq paramakzq) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return true;
        akzq.a(this.a).setAlpha(0.5F);
        return true;
        akzq.a(this.a).setAlpha(1.0F);
        if (!akzq.a(this.a))
        {
          akzh.a(true);
          akzq.a(this.a, true);
        }
        akzq.a(this.a).setVisibility(8);
        akzq.a(this.a).clearAnimation();
      } while (akzq.a(this.a) == null);
      akzq.a(this.a).g();
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordViewProxy", 2, "onMonitorUserOperation");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akzr
 * JD-Core Version:    0.7.0.1
 */