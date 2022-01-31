import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.ARRenderModel.CameraRendererable;
import com.tencent.qphone.base.util.QLog;

public class aahb
  implements Runnable
{
  public aahb(CameraRendererable paramCameraRendererable) {}
  
  public void run()
  {
    if (CameraRendererable.a(this.a) != null) {}
    try
    {
      CameraRendererable.a(this.a).f();
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d(CameraRendererable.a(), 2, "requestRender", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aahb
 * JD-Core Version:    0.7.0.1
 */