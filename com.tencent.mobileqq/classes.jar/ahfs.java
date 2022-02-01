import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder.3.1;
import com.tencent.qphone.base.util.QLog;

public final class ahfs
  implements bisc
{
  public ahfs(Handler paramHandler) {}
  
  public void onProgressChanged(bisa parambisa, int paramInt1, int paramInt2) {}
  
  public void onProgressCompleted(bisa parambisa)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScribbleItemBuilder", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + parambisa);
    }
    this.a.postDelayed(new ScribbleItemBuilder.3.1(this, parambisa), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfs
 * JD-Core Version:    0.7.0.1
 */