import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.mobileqq.arcard.ARCardCameraRecordFragment;
import com.tencent.qphone.base.util.QLog;

public class aall
  implements Runnable
{
  public aall(ARCardCameraRecordFragment paramARCardCameraRecordFragment) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqArArengineARCamera == null)
    {
      QLog.i("ARCardCameraRecordFragment", 2, "cancel to open camera. next mCurCameraState = ");
      return;
    }
    int i;
    label255:
    do
    {
      for (;;)
      {
        try
        {
          QLog.i("ARCardCameraRecordFragment", 2, "openCameraAync.");
          i = -3;
          if (ARCardCameraRecordFragment.a(this.a) >= 10) {
            break label255;
          }
          ARCardCameraRecordFragment.b(this.a);
          i = this.a.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.a(this.a.jdField_a_of_type_Int);
          QLog.i("ARCardCameraRecordFragment", 2, "try to open camera. mCurOpenCameraTryTimes = " + ARCardCameraRecordFragment.a(this.a) + ", MAX_OPEN_CAMERA_TRY_TIMES = " + 10);
          if (this.a.jdField_a_of_type_ComTencentMobileqqArArengineARCamera != null)
          {
            if (ARCardCameraRecordFragment.c(this.a) == 1) {
              break;
            }
            QLog.i("ARCardCameraRecordFragment", 2, "cancel to open camera. next mCurCameraState = " + ARCardCameraRecordFragment.c(this.a));
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          QLog.i("ARCardCameraRecordFragment", 1, "InterruptedException = " + localInterruptedException.getMessage());
          ARCardCameraRecordFragment.a(this.a, 0);
          QLog.i("ARCardCameraRecordFragment", 2, "openCameraAync failed. mCurCameraState = " + ARCardCameraRecordFragment.c(this.a));
          return;
        }
        i = -3;
      }
      if (i == 0)
      {
        ARCardCameraRecordFragment.a(this.a, true);
        if (i != 0) {
          break label384;
        }
        ARCardCameraRecordFragment.a(this.a, 2);
        QLog.i("ARCardCameraRecordFragment", 2, "openCameraAync successfully. mCurCameraState = " + ARCardCameraRecordFragment.c(this.a));
        if (!ARCardCameraRecordFragment.a(this.a)) {
          break;
        }
        ARCardCameraRecordFragment.a(this.a);
        return;
      }
      Thread.currentThread();
      Thread.sleep(ARCardCameraRecordFragment.d(this.a));
    } while (ARCardCameraRecordFragment.c(this.a) == 1);
    QLog.i("ARCardCameraRecordFragment", 2, "cancel to open camera. next mCurCameraState = " + ARCardCameraRecordFragment.c(this.a));
    return;
    QLog.i("ARCardCameraRecordFragment", 2, "wait SurfaceCreated to continue to start preview.");
    return;
    label384:
    ARCardCameraRecordFragment.a(this.a, 0);
    QLog.i("ARCardCameraRecordFragment", 2, "openCameraAync failed. retCode = " + i + ", mCurCameraState = " + ARCardCameraRecordFragment.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aall
 * JD-Core Version:    0.7.0.1
 */