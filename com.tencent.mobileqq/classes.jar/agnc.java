import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder.3.1;
import com.tencent.qphone.base.util.QLog;

public final class agnc
  implements bhhk
{
  public agnc(Handler paramHandler) {}
  
  public void onProgressChanged(bhhi parambhhi, int paramInt1, int paramInt2) {}
  
  public void onProgressCompleted(bhhi parambhhi)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScribbleItemBuilder", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + parambhhi);
    }
    this.a.postDelayed(new ScribbleItemBuilder.3.1(this, parambhhi), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnc
 * JD-Core Version:    0.7.0.1
 */