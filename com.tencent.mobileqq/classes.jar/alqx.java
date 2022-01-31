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
import android.os.Message;
import android.view.SurfaceHolder;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class alqx
  extends Handler
{
  private String a;
  
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
      alqu.a(this.jdField_a_of_type_Alqu).setPreviewTexture((SurfaceTexture)paramObject);
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
        if ((paramMessage.what != 2) && (alqu.a(this.jdField_a_of_type_Alqu) != null))
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera != null, but RuntimeException");
          try
          {
            alqu.a(this.jdField_a_of_type_Alqu).release();
            alqu.a(this.jdField_a_of_type_Alqu, null);
            if (paramMessage.obj != null)
            {
              QLog.w(this.jdField_a_of_type_JavaLangString, 1, "相机已经打开，运行时异常 " + paramMessage.what);
              if ((paramMessage.obj instanceof alqp))
              {
                ((alqp)paramMessage.obj).b(paramMessage.arg1);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA " + paramMessage.arg1);
                }
                alqu.a(this.jdField_a_of_type_Alqu, Camera.open(paramMessage.arg1));
                if (alqu.a(this.jdField_a_of_type_Alqu) != null)
                {
                  alqu.a(this.jdField_a_of_type_Alqu, true);
                  if (alqu.a(this.jdField_a_of_type_Alqu) == null)
                  {
                    alqu.a(this.jdField_a_of_type_Alqu, alqu.a(this.jdField_a_of_type_Alqu).getParameters());
                    if (QLog.isColorLevel()) {
                      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA, parameter = " + alqu.a(this.jdField_a_of_type_Alqu));
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA, open result mCamera = " + alqu.a(this.jdField_a_of_type_Alqu));
                  }
                }
                else
                {
                  if (paramMessage.obj == null) {
                    continue;
                  }
                  ((alqp)paramMessage.obj).b(paramMessage.arg1);
                  continue;
                }
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] RELEASE");
                }
                if (alqu.a(this.jdField_a_of_type_Alqu) != null) {
                  alqu.a(this.jdField_a_of_type_Alqu).release();
                }
                alqu.a(this.jdField_a_of_type_Alqu, null);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] RECONNECT");
                }
                alqu.a(this.jdField_a_of_type_Alqu, null);
                try
                {
                  if (alqu.a(this.jdField_a_of_type_Alqu) == null) {
                    continue;
                  }
                  alqu.a(this.jdField_a_of_type_Alqu).reconnect();
                  return;
                }
                catch (IOException localIOException1)
                {
                  alqu.a(this.jdField_a_of_type_Alqu, localIOException1);
                  return;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] UNLOCK");
                }
                if (alqu.a(this.jdField_a_of_type_Alqu) == null) {
                  continue;
                }
                alqu.a(this.jdField_a_of_type_Alqu).unlock();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] LOCK");
                }
                if (alqu.a(this.jdField_a_of_type_Alqu) == null) {
                  continue;
                }
                alqu.a(this.jdField_a_of_type_Alqu).lock();
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
                  if (alqu.a(this.jdField_a_of_type_Alqu) == null) {
                    continue;
                  }
                  alqu.a(this.jdField_a_of_type_Alqu).setPreviewDisplay((SurfaceHolder)paramMessage.obj);
                  return;
                }
                catch (IOException localIOException2)
                {
                  throw new RuntimeException(localIOException2);
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] START_PREVIEW_ASYNC");
                }
                if (alqu.a(this.jdField_a_of_type_Alqu) == null) {
                  continue;
                }
                alqu.a(this.jdField_a_of_type_Alqu).startPreview();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] STOP_PREVIEW");
                }
                try
                {
                  if (alqu.a(this.jdField_a_of_type_Alqu) == null) {
                    continue;
                  }
                  alqu.a(this.jdField_a_of_type_Alqu).stopPreview();
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
                if (alqu.a(this.jdField_a_of_type_Alqu) == null) {
                  continue;
                }
                alqu.a(this.jdField_a_of_type_Alqu).setOneShotPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_CALLBACK, obj = " + paramMessage.obj);
                }
                if (alqu.a(this.jdField_a_of_type_Alqu) == null) {
                  continue;
                }
                alqu.a(this.jdField_a_of_type_Alqu).setPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_CALLBACK_WITH_BUFFER, obj = " + paramMessage.obj);
                }
                if (alqu.a(this.jdField_a_of_type_Alqu) == null) {
                  continue;
                }
                alqu.a(this.jdField_a_of_type_Alqu).setPreviewCallbackWithBuffer((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] ADD_CALLBACK_BUFFER");
                }
                if (alqu.a(this.jdField_a_of_type_Alqu) == null) {
                  continue;
                }
                alqu.a(this.jdField_a_of_type_Alqu).addCallbackBuffer((byte[])paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] AUTO_FOCUS");
                }
                if (alqu.a(this.jdField_a_of_type_Alqu) == null) {
                  continue;
                }
                alqu.a(this.jdField_a_of_type_Alqu).autoFocus((Camera.AutoFocusCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] CANCEL_AUTO_FOCUS");
                }
                if (alqu.a(this.jdField_a_of_type_Alqu) == null) {
                  continue;
                }
                alqu.a(this.jdField_a_of_type_Alqu).cancelAutoFocus();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_AUTO_FOCUS_MOVE_CALLBACK");
                }
                if (alqu.a(this.jdField_a_of_type_Alqu) == null) {
                  continue;
                }
                a(alqu.a(this.jdField_a_of_type_Alqu), paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_DISPLAY_ORIENTATION");
                }
                if (alqu.a(this.jdField_a_of_type_Alqu) == null) {
                  continue;
                }
                alqu.a(this.jdField_a_of_type_Alqu).setDisplayOrientation(paramMessage.arg1);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_ZOOM_CHANGE_LISTENER");
                }
                if (alqu.a(this.jdField_a_of_type_Alqu) == null) {
                  continue;
                }
                alqu.a(this.jdField_a_of_type_Alqu).setZoomChangeListener((Camera.OnZoomChangeListener)paramMessage.obj);
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
                if (alqu.a(this.jdField_a_of_type_Alqu) == null) {
                  continue;
                }
                alqu.a(this.jdField_a_of_type_Alqu).setErrorCallback((Camera.ErrorCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PARAMETERS");
                }
                if (alqu.a(this.jdField_a_of_type_Alqu) == null) {
                  continue;
                }
                alqu.a(this.jdField_a_of_type_Alqu, true);
                alqu.a(this.jdField_a_of_type_Alqu).unflatten((String)paramMessage.obj);
                alqu.a(this.jdField_a_of_type_Alqu).setParameters(alqu.a(this.jdField_a_of_type_Alqu));
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] GET_PARAMETERS");
                }
                if ((alqu.a(this.jdField_a_of_type_Alqu) == null) || (!alqu.a(this.jdField_a_of_type_Alqu))) {
                  continue;
                }
                alqu.b(this.jdField_a_of_type_Alqu, alqu.a(this.jdField_a_of_type_Alqu).getParameters());
                alqu.a(this.jdField_a_of_type_Alqu, false);
                return;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] ENABLE_SHUTTER_SOUND");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] REFRESH_PARAMETERS");
                }
                alqu.a(this.jdField_a_of_type_Alqu, true);
                return;
              }
            }
          }
          catch (Exception localException2)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Fail to release the camera.");
            continue;
            if (!(paramMessage.obj instanceof alqv)) {
              continue;
            }
            ((alqv)paramMessage.obj).onAutoFocus(false, alqu.a(this.jdField_a_of_type_Alqu));
            return;
          }
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "相机参数设置错误, 请尝试重启机器 " + paramMessage.what);
          throw localException1;
        }
        if (alqu.a(this.jdField_a_of_type_Alqu) == null) {
          if (paramMessage.what == 1)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera == null Since Camera is disabled");
            if ((paramMessage.obj != null) && ((paramMessage.obj instanceof alqp))) {
              ((alqp)paramMessage.obj).a(paramMessage.arg1);
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
 * Qualified Name:     alqx
 * JD-Core Version:    0.7.0.1
 */