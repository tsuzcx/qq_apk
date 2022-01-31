import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.AutoFocusMoveCallback;
import android.hardware.Camera.ErrorCallback;
import android.hardware.Camera.OnZoomChangeListener;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.camera.CameraManager.CameraOpenErrorCallback;
import com.tencent.mobileqq.camera.CameraManagerImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class abwf
  extends Handler
{
  private String jdField_a_of_type_JavaLangString = "Q.camera.CameraManagerImpl.CameraHandler";
  
  public abwf(CameraManagerImpl paramCameraManagerImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @TargetApi(16)
  private void a(Camera paramCamera, Object paramObject)
  {
    paramCamera.setAutoFocusMoveCallback((Camera.AutoFocusMoveCallback)paramObject);
  }
  
  @TargetApi(14)
  private void a(Object paramObject)
  {
    try
    {
      CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).setPreviewTexture((SurfaceTexture)paramObject);
      return;
    }
    catch (IOException paramObject)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Could not set preview texture", paramObject);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 1: 
          throw new RuntimeException("Invalid CameraProxy message=" + paramMessage.what);
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        localRuntimeException.printStackTrace();
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, localRuntimeException, new Object[0]);
        if ((paramMessage.what != 2) && (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) != null))
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera != null, but RuntimeException");
          try
          {
            CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).release();
            CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl, null);
            if (paramMessage.obj != null)
            {
              QLog.w(this.jdField_a_of_type_JavaLangString, 1, "相机已经打开，运行时异常 " + paramMessage.what);
              if ((paramMessage.obj instanceof CameraManager.CameraOpenErrorCallback))
              {
                ((CameraManager.CameraOpenErrorCallback)paramMessage.obj).b(paramMessage.arg1);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA " + paramMessage.arg1);
                }
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl, Camera.open(paramMessage.arg1));
                if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) != null)
                {
                  CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl, true);
                  if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null)
                  {
                    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl, CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).getParameters());
                    if (QLog.isColorLevel()) {
                      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA, parameter = " + CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl));
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA, open result mCamera = " + CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl));
                  }
                }
                else
                {
                  if (paramMessage.obj == null) {
                    continue;
                  }
                  ((CameraManager.CameraOpenErrorCallback)paramMessage.obj).b(paramMessage.arg1);
                  continue;
                }
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] RELEASE");
                }
                if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) != null) {
                  CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).release();
                }
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl, null);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] RECONNECT");
                }
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl, null);
                try
                {
                  if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) {
                    continue;
                  }
                  CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).reconnect();
                  return;
                }
                catch (IOException localIOException1)
                {
                  CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl, localIOException1);
                  return;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] UNLOCK");
                }
                if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) {
                  continue;
                }
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).unlock();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] LOCK");
                }
                if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) {
                  continue;
                }
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).lock();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_TEXTURE_ASYNC");
                }
                a(paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_DISPLAY");
                }
                try
                {
                  if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) {
                    continue;
                  }
                  CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).setPreviewDisplay((SurfaceHolder)paramMessage.obj);
                  return;
                }
                catch (IOException localIOException2)
                {
                  throw new RuntimeException(localIOException2);
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] START_PREVIEW_ASYNC");
                }
                if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) {
                  continue;
                }
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).startPreview();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] STOP_PREVIEW");
                }
                try
                {
                  if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) {
                    continue;
                  }
                  CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).stopPreview();
                  return;
                }
                catch (Exception localException1)
                {
                  localException1.printStackTrace();
                  return;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_ONE_SHOT_PREVIEW_CALlBACK");
                }
                if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) {
                  continue;
                }
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).setOneShotPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_CALLBACK, obj = " + paramMessage.obj);
                }
                if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) {
                  continue;
                }
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).setPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_CALLBACK_WITH_BUFFER, obj = " + paramMessage.obj);
                }
                if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) {
                  continue;
                }
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).setPreviewCallbackWithBuffer((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] ADD_CALLBACK_BUFFER");
                }
                if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) {
                  continue;
                }
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).addCallbackBuffer((byte[])paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] AUTO_FOCUS");
                }
                if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) {
                  continue;
                }
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).autoFocus((Camera.AutoFocusCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] CANCEL_AUTO_FOCUS");
                }
                if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) {
                  continue;
                }
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).cancelAutoFocus();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_AUTO_FOCUS_MOVE_CALLBACK");
                }
                if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) {
                  continue;
                }
                a(CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl), paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_DISPLAY_ORIENTATION");
                }
                if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) {
                  continue;
                }
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).setDisplayOrientation(paramMessage.arg1);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_ZOOM_CHANGE_LISTENER");
                }
                if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) {
                  continue;
                }
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).setZoomChangeListener((Camera.OnZoomChangeListener)paramMessage.obj);
                return;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_FACE_DETECTION_LISTENER");
                return;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] START_FACE_DETECTION");
                return;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] STOP_FACE_DETECTION");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_ERROR_CALLBACK");
                }
                if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) {
                  continue;
                }
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).setErrorCallback((Camera.ErrorCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PARAMETERS");
                }
                if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) {
                  continue;
                }
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl, true);
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).unflatten((String)paramMessage.obj);
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).setParameters(CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl));
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] GET_PARAMETERS");
                }
                if ((CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) || (!CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl))) {
                  continue;
                }
                CameraManagerImpl.b(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl, CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).getParameters());
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl, false);
                return;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] ENABLE_SHUTTER_SOUND");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] REFRESH_PARAMETERS");
                }
                CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl, true);
                return;
              }
            }
          }
          catch (Exception localException2)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Fail to release the camera.");
            continue;
            if (!(paramMessage.obj instanceof abwd)) {
              continue;
            }
            ((abwd)paramMessage.obj).onAutoFocus(false, CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl));
            return;
          }
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "相机参数设置错误, 请尝试重启机器 " + paramMessage.what);
          throw localException1;
        }
        if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) == null) {
          if (paramMessage.what == 1)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera == null Since Camera is disabled");
            if ((paramMessage.obj != null) && ((paramMessage.obj instanceof CameraManager.CameraOpenErrorCallback))) {
              ((CameraManager.CameraOpenErrorCallback)paramMessage.obj).a(paramMessage.arg1);
            }
          }
          else
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera == null, Cannot handle message, 相机运行异常，请尝试重启机器");
            throw localException1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwf
 * JD-Core Version:    0.7.0.1
 */