import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.Leba.41.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class adpe
  implements bcoq
{
  public adpe(Leba paramLeba) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.i("Q.lebatab.leba", 1, "StudyModeChange onChange " + paramBoolean);
    if (this.a.a.getLebaHelper() != null) {
      this.a.a.getLebaHelper().c();
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManagerV2.getUIHandlerV2().post(new Leba.41.1(this));
      return;
    }
    this.a.X_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpe
 * JD-Core Version:    0.7.0.1
 */