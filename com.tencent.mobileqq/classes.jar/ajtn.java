import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.maxvideo.mediadevice.AVCodec.AVCodecCallback;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.1;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.2;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.3;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.4;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.5;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.6;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;

public class ajtn
  extends ajtq
{
  public final Runnable a;
  public boolean a;
  public boolean b = false;
  public boolean c = false;
  public boolean d = false;
  boolean e = true;
  public boolean f = true;
  
  public ajtn()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new RMVideoInitState.2(this);
  }
  
  public void a()
  {
    this.d = false;
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (localRMVideoStateMgr != null)
    {
      if (localRMVideoStateMgr.jdField_a_of_type_Azjv != null) {
        localRMVideoStateMgr.jdField_a_of_type_Azjv.a(localRMVideoStateMgr);
      }
      if (localRMVideoStateMgr.jdField_a_of_type_Ajty != null) {
        localRMVideoStateMgr.jdField_a_of_type_Ajty.n();
      }
      if (!localRMVideoStateMgr.d) {
        this.c = false;
      }
      if (!this.c) {
        d();
      }
    }
    else
    {
      return;
    }
    localRMVideoStateMgr.m();
    c();
  }
  
  public void a(AVCodec.AVCodecCallback paramAVCodecCallback, MessageStruct paramMessageStruct)
  {
    paramAVCodecCallback = RMVideoStateMgr.a();
    switch (paramMessageStruct.mId)
    {
    default: 
      return;
    }
    paramAVCodecCallback.jdField_a_of_type_JavaLangString = ((String)paramMessageStruct.mObj0);
    this.jdField_a_of_type_Boolean = true;
    paramAVCodecCallback.jdField_a_of_type_Ajtk = null;
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] onAVCodecEvent[RMFileEventNotify] path=" + paramAVCodecCallback.jdField_a_of_type_JavaLangString + ",files : " + Arrays.toString(new File(paramAVCodecCallback.jdField_a_of_type_JavaLangString).list()));
    }
    paramAVCodecCallback.jdField_a_of_type_AndroidOsHandler.post(new RMVideoInitState.4(this));
    e();
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if ((paramObject instanceof azhu)) {
      switch (paramInt)
      {
      }
    }
    Object localObject;
    for (;;)
    {
      super.a(paramObject, paramInt, paramVarArgs);
      return;
      if (paramVarArgs != null) {
        if ((paramVarArgs[0] instanceof Boolean))
        {
          this.b = true;
          e();
          if (QLog.isColorLevel()) {
            QLog.d("RMVideoInitState", 2, "[@] EVENT_CREATE_CAMERA[success] obj= " + paramVarArgs[0]);
          }
          localObject = BaseApplicationImpl.sApplication.getQQProcessName();
          if ((localObject != null) && (((String)localObject).endsWith(":story"))) {
            wxj.b("take_video", "camera_initial", 0, 0, new String[0]);
          }
          ThreadManager.post(new RMVideoInitState.5(this), 8, null, true);
        }
        else if ((paramVarArgs[0] instanceof String))
        {
          if (!this.d)
          {
            this.d = true;
            RMVideoStateMgr.a().a(2002, alud.a(2131713859), false);
          }
          if (QLog.isColorLevel()) {
            QLog.d("RMVideoInitState", 2, "[@] EVENT_CREATE_CAMERA, error = " + paramVarArgs[0]);
          }
          if (1 == ajpy.a) {
            bjwi.a(azfx.a + "", "qzone_video_record", "2", null);
          }
          localObject = BaseApplicationImpl.sApplication.getQQProcessName();
          if ((localObject != null) && (((String)localObject).endsWith(":story")))
          {
            wxj.b("take_video", "camera_initial", 0, -1, new String[0]);
            continue;
            if ((paramVarArgs != null) && ((paramVarArgs[0] instanceof String)))
            {
              if (!this.d)
              {
                this.d = true;
                RMVideoStateMgr.a().a(2003, alud.a(2131713854), false);
              }
              if (QLog.isColorLevel()) {
                QLog.d("RMVideoInitState", 2, "[@] EVENT_SET_CAMERA_PARAM error, error = " + paramVarArgs[0]);
              }
              if (1 == ajpy.a)
              {
                bjwi.a(azfx.a + "", "qzone_video_record", "3", null);
                continue;
                if (!this.d)
                {
                  this.d = true;
                  RMVideoStateMgr.a().a(2002, alud.a(2131713852), false);
                }
                if (QLog.isColorLevel()) {
                  QLog.d("RMVideoInitState", 2, "[@] EVENT_CAMERA_DISABLED error");
                }
                if (1 == ajpy.a)
                {
                  bjwi.a(azfx.a + "", "qzone_video_record", "4", null);
                  continue;
                  if ((paramObject instanceof AudioCapture))
                  {
                    localObject = RMVideoStateMgr.a();
                    switch (paramInt)
                    {
                    case 4: 
                    default: 
                      break;
                    case 3: 
                      if ((paramVarArgs != null) && ((paramVarArgs[0] instanceof Boolean)) && (((Boolean)paramVarArgs[0]).booleanValue()))
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("RMVideoInitState", 2, "[@] EVENT_INIT [OK]");
                        }
                      }
                      else
                      {
                        if (QLog.isColorLevel())
                        {
                          QLog.d("RMVideoInitState", 2, "[@] EVENT_INIT [error]麦克风初始化参数失败...");
                          QLog.d("RMVideoInitState", 2, "[@] EVENT_INIT [error]mAudioSampleRate=" + azib.q + " mAudioChannel=" + azib.o + " mAudioFormat=" + azib.p);
                        }
                        ((RMVideoStateMgr)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
                        ((RMVideoStateMgr)localObject).e = false;
                        ((RMVideoStateMgr)localObject).c(false);
                        if (((RMVideoStateMgr)localObject).jdField_a_of_type_AndroidOsHandler != null) {
                          ((RMVideoStateMgr)localObject).jdField_a_of_type_AndroidOsHandler.post(new RMVideoInitState.6(this));
                        }
                        while (1 == ajpy.a)
                        {
                          bjwi.a(azfx.a + "", "qzone_video_record", "5", null);
                          break;
                          if (QLog.isColorLevel()) {
                            QLog.d("RMVideoInitState", 2, "[@] EVENT_INIT [Error]麦克风参数初始化失败 ,rmStateMgr.mHandler = null");
                          }
                        }
                      }
                      break;
                    case 5: 
                      if (QLog.isColorLevel()) {
                        QLog.d("RMVideoInitState", 2, "[@] EVENT_OPEN_MIC [error]麦克风打开失败...");
                      }
                      ((RMVideoStateMgr)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
                      ((RMVideoStateMgr)localObject).e = false;
                      if (RMVideoStateMgr.c)
                      {
                        ((RMVideoStateMgr)localObject).c(true);
                        e();
                      }
                      for (;;)
                      {
                        if (!((RMVideoStateMgr)localObject).h)
                        {
                          RMVideoStateMgr.a().b(0, alud.a(2131713855), false);
                          ((RMVideoStateMgr)localObject).h = true;
                        }
                        if (1 != ajpy.a) {
                          break;
                        }
                        bjwi.a(azfx.a + "", "qzone_video_record", "6", null);
                        break;
                        ((RMVideoStateMgr)localObject).c(false);
                      }
                    case 6: 
                      if ((paramVarArgs == null) || (!(paramVarArgs[0] instanceof Boolean)) || (!((Boolean)paramVarArgs[0]).booleanValue())) {
                        break label928;
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("RMVideoInitState", 2, "[@] EVENT_START_MIC [OK]");
                      }
                      ((RMVideoStateMgr)localObject).c(true);
                      e();
                      ((RMVideoStateMgr)localObject).e = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label928:
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] EVENT_START_MIC [error]麦克风启动录制失败...");
    }
    ((RMVideoStateMgr)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
    ((RMVideoStateMgr)localObject).e = false;
    if (RMVideoStateMgr.c)
    {
      ((RMVideoStateMgr)localObject).c(true);
      e();
    }
    for (;;)
    {
      if (!((RMVideoStateMgr)localObject).h)
      {
        RMVideoStateMgr.a().b(0, alud.a(2131713850), false);
        ((RMVideoStateMgr)localObject).h = true;
      }
      if (1 != ajpy.a) {
        break;
      }
      bjwi.a(azfx.a + "", "qzone_video_record", "7", null);
      break;
      ((RMVideoStateMgr)localObject).c(false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    RMVideoStateMgr.a().a("RMVideoInitState");
    return false;
  }
  
  public void b()
  {
    if (b()) {
      RMVideoStateMgr.a().a(3);
    }
  }
  
  boolean b()
  {
    return (RMVideoStateMgr.a().d) && (this.jdField_a_of_type_Boolean) && (this.b);
  }
  
  void c()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] retake called");
    }
    if (localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
      localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.a();
    }
    for (;;)
    {
      try
      {
        localRMVideoStateMgr.k();
        if (!this.e) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoInitState", 2, "[@] retake call AVCodec.get().retake()");
        }
        AVCodec.get().retake();
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
        continue;
      }
      if (localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.reset();
      }
      azig.a().a().a(0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoInitState", 2, "[@] retake call AVCodec.get().init()");
      }
      AVCodec.get().init();
      this.e = true;
    }
  }
  
  void d()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] delayInit called");
    }
    localRMVideoStateMgr.jdField_a_of_type_AndroidOsHandler.postDelayed(new RMVideoInitState.1(this), 50L);
  }
  
  void e()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (b())
    {
      localRMVideoStateMgr.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      localRMVideoStateMgr.jdField_a_of_type_AndroidOsHandler.post(new RMVideoInitState.3(this));
    }
  }
  
  public void f()
  {
    RMVideoStateMgr.a().n();
    this.c = false;
  }
  
  public void g()
  {
    RMVideoStateMgr.a().n();
    this.c = false;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtn
 * JD-Core Version:    0.7.0.1
 */