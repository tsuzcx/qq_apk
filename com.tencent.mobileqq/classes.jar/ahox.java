import com.tencent.mobileqq.richmedia.mediacodec.widget.HWVideoPlayView;
import com.tencent.qphone.base.util.QLog;

public class ahox
  implements Runnable
{
  public ahox(HWVideoPlayView paramHWVideoPlayView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DIDI", 1, "reStartPlaySolveDanceBlackScreen mHaveSurfaceChangedPlayStart=" + this.a.c);
    }
    try
    {
      if (!this.a.c)
      {
        this.a.b();
        if (HWVideoPlayView.a(this.a)) {
          this.a.c();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("DIDI", 1, "reStartPlaySolveDanceBlackScreen mHaveSurfaceChangedPlayStart=" + this.a.c, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahox
 * JD-Core Version:    0.7.0.1
 */