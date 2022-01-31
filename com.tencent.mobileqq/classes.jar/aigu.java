import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aigu
  implements Camera.PictureCallback
{
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  
  public aigu(CameraControl paramCameraControl, int paramInt1, File paramFile, Rect paramRect, CameraCover.PictureCallback paramPictureCallback, boolean paramBoolean, int paramInt2) {}
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.i(CameraControl.b, 2, "onJpegTaken");
    }
    NewFlowCameraReporter.a("inner pic taken");
    try
    {
      paramCamera = paramCamera.getParameters().getPictureSize();
      if (paramCamera == null)
      {
        QLog.e(CameraControl.b, 1, "null picSize");
        return;
      }
    }
    catch (Exception paramCamera)
    {
      do
      {
        for (;;)
        {
          paramCamera.printStackTrace();
          paramCamera = null;
        }
        QLog.i(CameraControl.b, 1, "[onPictureTaken] picSize(" + paramCamera.width + "," + paramCamera.height + ") orientation=" + this.jdField_a_of_type_Int);
      } while (paramArrayOfByte == null);
      this.jdField_a_of_type_AndroidOsHandler.post(new aigv(this, paramArrayOfByte, paramCamera));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aigu
 * JD-Core Version:    0.7.0.1
 */