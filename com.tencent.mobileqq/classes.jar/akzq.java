import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordButtonView;
import com.tencent.qphone.base.util.QLog;

class akzq
  implements View.OnTouchListener
{
  akzq(akzp paramakzp) {}
  
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
        akzp.a(this.a).setAlpha(0.5F);
        return true;
        akzp.a(this.a).setAlpha(1.0F);
        if (!akzp.a(this.a))
        {
          akzg.a(true);
          akzp.a(this.a, true);
        }
        akzp.a(this.a).setVisibility(8);
        akzp.a(this.a).clearAnimation();
      } while (akzp.a(this.a) == null);
      akzp.a(this.a).g();
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordViewProxy", 2, "onMonitorUserOperation");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akzq
 * JD-Core Version:    0.7.0.1
 */