import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraPreviewObservable;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.ParamCache;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.WaitDoneBundle;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class aicg
  extends Handler
  implements Camera.AutoFocusCallback
{
  public aicg(CameraProxy paramCameraProxy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @TargetApi(14)
  private void a(Rect paramRect1, Rect paramRect2, Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_REQUEST_FOCUS");
    }
    Camera.Parameters localParameters = CameraControl.a().a();
    if ((Build.VERSION.SDK_INT >= 14) && (paramRect1 != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[handleMessage] focus area = " + paramRect1);
      }
      localParameters.setFocusMode("auto");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new Camera.Area(paramRect1, 1000));
      localParameters.setFocusAreas(localArrayList);
      if ((localParameters.getMaxNumMeteringAreas() > 0) && (paramRect2 != null))
      {
        paramRect1 = new ArrayList(1);
        paramRect1.add(new Camera.Area(new Rect(paramRect2), 1000));
        localParameters.setMeteringAreas(paramRect1);
      }
      CameraControl.a().jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
    }
    paramRect1 = paramAutoFocusCallback;
    if (paramAutoFocusCallback == null) {
      paramRect1 = new aich(this);
    }
    CameraControl.a().a(paramRect1);
  }
  
  public String a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[@] getDefaultFocusMode: Build.MANUFACTURER=" + Build.MANUFACTURER + "VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.VERSION.SDK_INT >= 14)) {}
    return "continuous-picture";
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      try
      {
        throw new RuntimeException("Unimplemented CameraProxy message=" + paramMessage.what);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[Camera2Handler.handleMessage]", localException);
        }
        return;
        i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage]OPEN_CAMERA_OLD");
        }
        i = CameraControl.a().a(i);
        if (i == 5)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(1, new Object[] { Boolean.valueOf(true) });
          return;
        }
        if (i != 0)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(1, new Object[] { "open camera failed:errcode=" + CameraControl.a(i) });
          return;
        }
        if (!CameraControl.a().a(90))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(1, new Object[] { "open camera failed, orientation error." });
          return;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(1, new Object[] { Boolean.valueOf(true) });
        this.a.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage]CHANGED");
        }
        int k = Integer.parseInt(paramMessage.obj.toString());
        i = paramMessage.arg1;
        j = paramMessage.arg2;
        this.a.jdField_a_of_type_Boolean = false;
        CameraProxy.a(this.a, false);
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[@] surfaceChanged start, format = " + k + ",width = " + i + ",height = " + j);
        }
        if ((this.a.jdField_b_of_type_Int <= 0) || (i <= this.a.jdField_b_of_type_Int)) {
          break label3738;
        }
        i = this.a.jdField_b_of_type_Int;
        if ((this.a.jdField_c_of_type_Int <= 0) || (j <= this.a.jdField_c_of_type_Int)) {
          break label3735;
        }
        j = this.a.jdField_c_of_type_Int;
        localObject6 = CameraControl.a();
        if (Build.VERSION.SDK_INT <= 10) {
          CameraControl.a().b();
        }
        if (this.a.jdField_a_of_type_Int == 1)
        {
          localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache;
          if (((CameraProxy.ParamCache)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            continue;
          }
          if (!CameraControl.a().d()) {
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview format failed" });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 3)
          {
            if (FlowCameraConstant.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache;
              continue;
            }
            if (FlowCameraConstant.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache;
              continue;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 2)
          {
            if (FlowCameraConstant.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.e;
              continue;
            }
            if (FlowCameraConstant.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.d;
              continue;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview format failed[Camera Kind error:RATIO_SCREEN]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 4)
          {
            if (FlowCameraConstant.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.g;
              continue;
            }
            if (FlowCameraConstant.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.f;
              continue;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 5)
          {
            localObject1 = this.a.h;
            continue;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview format failed[Preview Selector Error]" });
          return;
        }
        localObject5 = null;
        if ((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 3) || (this.a.jdField_a_of_type_Int == 4))
        {
          localObject5 = ((CameraControl)localObject6).b(CodecParam.j, CodecParam.k, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
          localObject4 = localObject5[0];
          localObject5 = localObject5[1];
          if (localObject4 == null) {
            break label3729;
          }
          bool1 = CameraControl.a().a((CameraControl.CustomSize)localObject4);
          break label3741;
          if (!bool1) {
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview size failed" + (String)localObject4 });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 2)
          {
            localObject4 = ((CameraControl)localObject6).a(CodecParam.j, CodecParam.k, i, j);
            bool1 = bool4;
            if (localObject4 == null) {
              break label3749;
            }
            bool1 = CameraControl.a().a((CameraControl.CustomSize)localObject4);
            break label3749;
          }
          if (this.a.jdField_a_of_type_Int != 5) {
            break label3765;
          }
          if ((Build.MANUFACTURER.equals("Xiaomi")) && (Build.MODEL.equals("MI 3")))
          {
            localObject4 = new CameraControl.CustomSize();
            ((CameraControl.CustomSize)localObject4).jdField_a_of_type_Int = 640;
            ((CameraControl.CustomSize)localObject4).jdField_b_of_type_Int = 480;
            bool1 = bool5;
            if (localObject4 == null) {
              break label3757;
            }
            bool1 = CameraControl.a().a((CameraControl.CustomSize)localObject4);
            break label3757;
          }
          localObject4 = ((CameraControl)localObject6).a(480);
          continue;
        }
        if (!CameraControl.a().b(CodecParam.g))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview fps failed" });
          return;
        }
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5) && (localObject5 != null) && (!((CameraControl)localObject6).b((CameraControl.CustomSize)localObject5))) {}
        ((CameraProxy.ParamCache)localObject1).jdField_a_of_type_Int = CameraControl.a().a();
        ((CameraProxy.ParamCache)localObject1).jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = CameraControl.a().a();
        localObject4 = CameraControl.a().b();
        if (localObject4 != null)
        {
          ((CameraProxy.ParamCache)localObject1).jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = ((CameraControl.CustomSize)localObject4);
          ((CameraProxy.ParamCache)localObject1).jdField_a_of_type_Boolean = true;
        }
        localObject4 = CameraControl.a().a();
        ((CameraProxy.ParamCache)localObject1).jdField_b_of_type_Int = localObject4[0];
        ((CameraProxy.ParamCache)localObject1).jdField_c_of_type_Int = localObject4[1];
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 3) && (this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5))
        {
          ((CameraProxy.ParamCache)localObject1).jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = CameraControl.a().b();
          ((CameraProxy.ParamCache)localObject1).jdField_a_of_type_Boolean = true;
        }
        if (this.a.jdField_a_of_type_Int == 4) {
          ((CameraProxy.ParamCache)localObject1).jdField_a_of_type_Boolean = false;
        }
        ((CameraProxy.ParamCache)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
        Object localObject1 = a();
        if ((!CameraControl.a().a((String)localObject1)) && (!CameraControl.a().a("auto")) && (!CameraControl.a().a(this))) {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(9, new Object[] { "无法开启自动对焦功能" });
        }
        if (!CameraControl.a().a(90))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set display orientation failed" });
          return;
          if (!CameraControl.a().a((CameraProxy.ParamCache)localObject1))
          {
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set Camera Params failed" });
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("CameraProxy", 2, "[handleMessage]Set camera param by cache params");
          continue;
        }
      }
      finally
      {
        CameraProxy.WaitDoneBundle.a(paramMessage);
      }
      Object localObject3 = CameraControl.a().a();
      int i = CameraControl.a().a();
      Object localObject4 = CameraControl.a().a();
      this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { localObject4, Integer.valueOf(i), localObject3 });
      continue;
      localObject3 = (Object[])paramMessage.obj;
      Object localObject6 = (CameraControl.CustomSize)localObject3[0];
      CameraControl.CustomSize localCustomSize = (CameraControl.CustomSize)localObject3[1];
      i = ((Integer)localObject3[2]).intValue();
      int j = ((Integer)localObject3[3]).intValue();
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[handleMessage]SET_PARAMS, , wantedSize = " + localObject6 + " , viewSize = " + localCustomSize + " , selectMode = " + i);
      }
      this.a.jdField_a_of_type_Boolean = false;
      CameraProxy.a(this.a, false);
      Object localObject5 = CameraControl.a();
      String str = CameraControl.a().jdField_a_of_type_Int + "#" + localObject6 + "#" + localCustomSize + "#" + i;
      localObject4 = (CameraProxy.ParamCache)this.a.jdField_a_of_type_JavaUtilMap.get(str);
      localObject3 = localObject4;
      if (localObject4 == null)
      {
        localObject3 = new CameraProxy.ParamCache();
        this.a.jdField_a_of_type_JavaUtilMap.put(str, localObject3);
      }
      if (!((CameraProxy.ParamCache)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        if (!CameraControl.a().d())
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview format failed" });
          CameraProxy.WaitDoneBundle.a(paramMessage);
          return;
        }
        localObject6 = ((CameraControl)localObject5).a(((CameraControl.CustomSize)localObject6).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject6).jdField_b_of_type_Int, localCustomSize.jdField_a_of_type_Int, localCustomSize.jdField_b_of_type_Int);
        localObject4 = localObject6[0];
        localObject6 = localObject6[1];
        bool1 = bool2;
        if (localObject4 != null) {
          bool1 = CameraControl.a().a((CameraControl.CustomSize)localObject4);
        }
        if (!bool1)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview size failed" + "" });
          CameraProxy.WaitDoneBundle.a(paramMessage);
          return;
        }
        if (((localObject6 == null) || (((CameraControl)localObject5).b((CameraControl.CustomSize)localObject6))) || (!CameraControl.a().b(j)))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview fps failed" });
          CameraProxy.WaitDoneBundle.a(paramMessage);
          return;
        }
        ((CameraProxy.ParamCache)localObject3).jdField_a_of_type_Int = CameraControl.a().a();
        ((CameraProxy.ParamCache)localObject3).jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = CameraControl.a().a();
        localObject4 = CameraControl.a().b();
        if (localObject4 != null)
        {
          ((CameraProxy.ParamCache)localObject3).jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = ((CameraControl.CustomSize)localObject4);
          ((CameraProxy.ParamCache)localObject3).jdField_a_of_type_Boolean = true;
        }
        localObject4 = CameraControl.a().a();
        ((CameraProxy.ParamCache)localObject3).jdField_b_of_type_Int = localObject4[0];
        ((CameraProxy.ParamCache)localObject3).jdField_c_of_type_Int = localObject4[1];
        ((CameraProxy.ParamCache)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
      }
      for (;;)
      {
        localObject3 = a();
        if ((!CameraControl.a().a((String)localObject3)) && (!CameraControl.a().a("auto")) && (!CameraControl.a().a(this))) {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(9, new Object[] { "无法开启自动对焦功能" });
        }
        if (CameraControl.a().a(90)) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set display orientation failed" });
        CameraProxy.WaitDoneBundle.a(paramMessage);
        return;
        if (!CameraControl.a().a((CameraProxy.ParamCache)localObject3))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set Camera Params failed" });
          CameraProxy.WaitDoneBundle.a(paramMessage);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage]Set camera param by cache params");
        }
      }
      localObject3 = CameraControl.a().a();
      i = CameraControl.a().a();
      localObject4 = CameraControl.a().a();
      this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { localObject4, Integer.valueOf(i), localObject3 });
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_DEFAULT");
      }
      localObject3 = a();
      if ((!CameraControl.a().a((String)localObject3)) && (!CameraControl.a().a("auto")) && (!CameraControl.a().a(this)))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(9, new Object[] { "无法开启自动对焦功能" });
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_AUTO");
        }
        if (!CameraControl.a().a("auto"))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(9, new Object[] { "无法开启自动对焦功能" });
          continue;
          localObject3 = (aicj)paramMessage.obj;
          a(((aicj)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((aicj)localObject3).b, ((aicj)localObject3).jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback);
          continue;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_SURFACE");
          }
          localObject3 = (SurfaceTexture)paramMessage.obj;
          if (!CameraControl.a().a((SurfaceTexture)localObject3))
          {
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview texture failed" });
            continue;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_SURFACE_HOLDER");
            }
            localObject3 = (SurfaceHolder)paramMessage.obj;
            if (!CameraControl.a().a((SurfaceHolder)localObject3))
            {
              this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set surface holder failed" });
              continue;
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_CALLBACK");
              }
              localObject3 = (Camera.PreviewCallback)paramMessage.obj;
              bool1 = bool3;
              if (paramMessage.arg1 > 0) {
                bool1 = true;
              }
              if (!CameraControl.a().a((Camera.PreviewCallback)localObject3, bool1))
              {
                this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview callback failed" });
                continue;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_START");
                }
                if (!CameraControl.a().a())
                {
                  this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(3, new Object[] { "start preview failed" });
                }
                else
                {
                  localObject3 = CameraControl.a();
                  if (((CameraControl)localObject3).jdField_a_of_type_Int == 1)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_START " + ((CameraControl)localObject3).jdField_a_of_type_Int);
                    }
                    if ((((CameraControl)localObject3).c()) && (CameraProxy.a(this.a) != null))
                    {
                      ((CameraControl)localObject3).a(CameraProxy.a(this.a));
                      ((CameraControl)localObject3).c();
                      continue;
                      if (QLog.isColorLevel()) {
                        QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH" + paramMessage.arg1);
                      }
                      localObject3 = CameraControl.a();
                      if ((((CameraControl)localObject3).c()) && (CameraProxy.a(this.a) != null)) {
                        if (paramMessage.arg1 == 1)
                        {
                          if (QLog.isColorLevel()) {
                            QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH " + ((CameraControl)localObject3).jdField_a_of_type_Int);
                          }
                          if (((CameraControl)localObject3).jdField_a_of_type_Int == 1)
                          {
                            ((CameraControl)localObject3).a(CameraProxy.a(this.a));
                            ((CameraControl)localObject3).c();
                          }
                        }
                        else if (paramMessage.arg1 == 2)
                        {
                          ((CameraControl)localObject3).d();
                          continue;
                          if (QLog.isColorLevel()) {
                            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_STOP");
                          }
                          if (!CameraControl.a().b())
                          {
                            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(4, new Object[] { "stop preview failed" });
                          }
                          else
                          {
                            localObject3 = CameraControl.a();
                            if ((((CameraControl)localObject3).c()) && (CameraProxy.a(this.a) != null))
                            {
                              ((CameraControl)localObject3).d();
                              continue;
                              if (QLog.isColorLevel()) {
                                QLog.i("CameraProxy", 2, "[handleMessage]RELEASE");
                              }
                              CameraControl.a().b();
                              this.a.jdField_a_of_type_Boolean = true;
                              try
                              {
                                Thread.sleep(50L);
                                label3191:
                                this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(11, new Object[] { "camera destory" });
                                continue;
                                if (QLog.isColorLevel()) {
                                  QLog.i("CameraProxy", 2, "[handleMessage]NIGHT_MODE_ON_OFF" + paramMessage.arg1);
                                }
                                if (paramMessage.arg1 == 1)
                                {
                                  CameraProxy.a(this.a);
                                  continue;
                                }
                                if (paramMessage.arg1 != 2) {
                                  continue;
                                }
                                CameraProxy.b(this.a);
                                continue;
                                if (QLog.isColorLevel()) {
                                  QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_ON_OFF");
                                }
                                if (paramMessage.arg1 == 1)
                                {
                                  if (CameraControl.a().a(true)) {
                                    continue;
                                  }
                                  this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(6, new Object[] { "turn on flash light failed" });
                                  continue;
                                }
                                if ((paramMessage.arg1 != 2) || (CameraControl.a().a(false))) {
                                  continue;
                                }
                                this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(6, new Object[] { "turn off flash light failed" });
                                continue;
                                if (QLog.isColorLevel()) {
                                  QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_SWITCH");
                                }
                                if (paramMessage.arg1 == 0)
                                {
                                  if (CameraControl.a().e()) {
                                    continue;
                                  }
                                  this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(6, new Object[] { "switch flash light failed" });
                                  continue;
                                }
                                if (paramMessage.arg1 == 1)
                                {
                                  if (CameraControl.a().b(true)) {
                                    continue;
                                  }
                                  this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(6, new Object[] { "turn on flash light failed" });
                                  continue;
                                }
                                if ((paramMessage.arg1 != 2) || (CameraControl.a().b(false))) {
                                  continue;
                                }
                                this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(6, new Object[] { "turn off flash light failed" });
                                continue;
                                if (QLog.isColorLevel()) {
                                  QLog.i("CameraProxy", 2, "[handleMessage]PICTURE_TAKE");
                                }
                                NewFlowCameraReporter.a("received");
                                localObject3 = (aick)paramMessage.obj;
                                localObject4 = CameraControl.a();
                                if (!((CameraControl)localObject4).jdField_a_of_type_Boolean)
                                {
                                  if (QLog.isColorLevel()) {
                                    QLog.i("CameraProxy", 2, "[takePicture]Camera is not previewing...");
                                  }
                                  CameraProxy.WaitDoneBundle.a(paramMessage);
                                  return;
                                }
                                if (((aick)localObject3).jdField_a_of_type_JavaIoFile == null)
                                {
                                  this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "take picture error" });
                                  CameraProxy.WaitDoneBundle.a(paramMessage);
                                  return;
                                }
                                ((CameraControl)localObject4).a(((aick)localObject3).jdField_a_of_type_JavaIoFile, ((aick)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((aick)localObject3).jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback, ((aick)localObject3).jdField_a_of_type_Int, ((aick)localObject3).jdField_a_of_type_Boolean, ((aick)localObject3).jdField_b_of_type_Int);
                                continue;
                                i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
                                CameraControl.a().c(i);
                                continue;
                                localObject3 = (String)((Object[])(Object[])paramMessage.obj)[0];
                                CameraControl.a().b((String)localObject3);
                              }
                              catch (InterruptedException localInterruptedException)
                              {
                                break label3191;
                              }
                              label3729:
                              bool1 = false;
                              break label3741;
                              label3735:
                              continue;
                              label3738:
                              continue;
                              label3741:
                              localObject4 = "";
                              continue;
                              label3749:
                              localObject4 = "";
                              continue;
                              label3757:
                              localObject4 = "";
                              continue;
                              label3765:
                              localObject4 = " :[Preview Selector Error]";
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[onAutoFocus]success " + paramBoolean);
    }
    paramCamera = a();
    CameraControl.a().a(paramCamera);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aicg
 * JD-Core Version:    0.7.0.1
 */