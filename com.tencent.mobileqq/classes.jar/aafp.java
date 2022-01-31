import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.arengine.ARReport;
import com.tencent.qphone.base.util.QLog;

public class aafp
  implements Runnable
{
  public aafp(AREngine paramAREngine) {}
  
  public void run()
  {
    if ((AREngine.a(this.a) != 1) || (this.a.a == null))
    {
      QLog.i("AREngine_AREngine", 2, "cancel to open camera. next mCurCameraState = " + AREngine.a(this.a));
      return;
    }
    int i;
    label174:
    label308:
    label370:
    do
    {
      for (;;)
      {
        try
        {
          QLog.i("AREngine_AREngine", 2, "openCameraAync.");
          i = -3;
          if (AREngine.b(this.a) >= 10) {
            break;
          }
          AREngine.c(this.a);
          long l = System.currentTimeMillis();
          if (AREngine.b(this.a) == 1)
          {
            i = this.a.a.a(0);
            ARReport.a().a(System.currentTimeMillis() - l, i);
            QLog.i("AREngine_AREngine", 2, "try to open camera. mCurOpenCameraTryTimes = " + AREngine.b(this.a) + ", MAX_OPEN_CAMERA_TRY_TIMES = " + 10);
            if (this.a.a == null) {
              break label509;
            }
            if (AREngine.a(this.a) == 1) {
              break label515;
            }
            QLog.i("AREngine_AREngine", 2, "cancel to open camera. next mCurCameraState = " + AREngine.a(this.a));
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          QLog.i("AREngine_AREngine", 1, "InterruptedException = " + localInterruptedException.getMessage());
          AREngine.a(this.a, 0);
          QLog.i("AREngine_AREngine", 2, "openCameraAync failed. mCurCameraState = " + AREngine.a(this.a));
          return;
        }
        i = this.a.a.d();
      }
      if (i != 0) {
        break label437;
      }
      AREngine.a(this.a, 2);
      QLog.i("AREngine_AREngine", 2, "openCameraAync successfully. mCurCameraState = " + AREngine.a(this.a));
      if (!AREngine.a(this.a)) {
        break;
      }
      AREngine.a(this.a);
      return;
      Thread.currentThread();
      Thread.sleep(AREngine.d(this.a));
    } while (AREngine.a(this.a) == 1);
    QLog.i("AREngine_AREngine", 2, "cancel to open camera. next mCurCameraState = " + AREngine.a(this.a));
    return;
    QLog.i("AREngine_AREngine", 2, "wait SurfaceCreated to continue to start preview.");
    return;
    label437:
    AREngine.a(this.a, 0);
    QLog.i("AREngine_AREngine", 2, "openCameraAync failed. retCode = " + i + ", mCurCameraState = " + AREngine.a(this.a));
    if (i == -1)
    {
      AREngine.a(this.a, 1);
      return;
    }
    for (;;)
    {
      AREngine.a(this.a, 2);
      return;
      label509:
      i = -3;
      break label174;
      label515:
      if (i != 0) {
        break label370;
      }
      break label308;
      if (i != -2) {
        if (i != -3) {
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aafp
 * JD-Core Version:    0.7.0.1
 */