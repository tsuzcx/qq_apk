import android.os.Handler;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.1;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.2;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.3;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

public class ajtp
  extends ajtq
{
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  
  private void d()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [startRecordVideo]Lock.CAPTURE_LOCK=" + azie.jdField_a_of_type_Boolean);
    }
    if (!azie.jdField_a_of_type_Boolean) {}
    synchronized (azie.jdField_a_of_type_JavaLangObject)
    {
      azie.jdField_a_of_type_Boolean = true;
      azie.jdField_a_of_type_JavaLangObject.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] [startRecordVideo]Lock.CAPTURE_LOCK=" + azie.jdField_a_of_type_Boolean);
      }
      AVCodec.get().startCapture();
      localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.startCapture();
      if (localRMVideoStateMgr.b(2)) {
        localRMVideoStateMgr.f();
      }
      if ((localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) && (localRMVideoStateMgr.i())) {
        localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.h();
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    }
  }
  
  public void a()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    localRMVideoStateMgr.jdField_a_of_type_Ajty.o();
    localRMVideoStateMgr.k();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [RMFileEventNotify]stopWatching");
    }
    this.jdField_a_of_type_Boolean = false;
    d();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] initState end");
    }
  }
  
  public void a(azgc paramazgc, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramazgc = RMVideoStateMgr.a();
    if (paramazgc.jdField_b_of_type_Boolean) {}
    for (paramazgc.jdField_a_of_type_Double = (System.currentTimeMillis() - paramazgc.jdField_a_of_type_Long);; paramazgc.jdField_a_of_type_Double = paramInt1)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = paramBoolean;
        if ((paramazgc.h()) && (!paramazgc.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.e) && (!paramazgc.h)) {
          paramazgc.jdField_a_of_type_AndroidOsHandler.post(new RMVideoRecordState.2(this));
        }
        if (QLog.isColorLevel()) {
          QLog.d("RMRecordState", 2, "[@] timeExpire: mIsRecordOver=" + this.jdField_a_of_type_Boolean + " mStateMgr.mTotalTime=" + paramazgc.jdField_a_of_type_Double);
        }
        paramazgc.jdField_a_of_type_Ajty.a((int)(paramazgc.jdField_a_of_type_Double + azig.a().a().a()), this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Boolean) {
          paramazgc.jdField_a_of_type_AndroidOsHandler.post(new RMVideoRecordState.3(this));
        }
      }
      return;
    }
  }
  
  public void b()
  {
    c();
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    localRMVideoStateMgr.a(2);
    localRMVideoStateMgr.j();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [RMFileEventNotify]startWatching");
    }
  }
  
  public void c()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [stopRecordVideo]Lock.CAPTURE_LOCK = " + azie.jdField_a_of_type_Boolean);
    }
    if (azie.jdField_a_of_type_Boolean)
    {
      azie.jdField_a_of_type_Boolean = false;
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_Long = (l1 - this.jdField_a_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] [stopRecordVideo] current=" + l1 + " timestamp=" + this.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_Boolean) {
        localRMVideoStateMgr.jdField_a_of_type_Double = azib.c;
      }
      localRMVideoStateMgr.jdField_a_of_type_Ajty.t();
      localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.stopCapture();
      if (localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
        localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.i();
      }
      if (localRMVideoStateMgr.b(3))
      {
        if (localRMVideoStateMgr.jdField_a_of_type_Azjv != null) {
          localRMVideoStateMgr.jdField_b_of_type_JavaLangString = localRMVideoStateMgr.jdField_a_of_type_Azjv.a(localRMVideoStateMgr);
        }
        localRMVideoStateMgr.g();
      }
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new RMVideoRecordState.1(this, localRMVideoStateMgr));
      AVCodec.get().stopCapture();
      long l2 = localRMVideoStateMgr.jdField_a_of_type_Ajty.d();
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] [stopRecordVideo] timeLimit=" + l2 + " timestamp=" + this.jdField_a_of_type_Long);
      }
      l1 = l2;
      if (l2 == -1L) {
        l1 = this.jdField_a_of_type_Long;
      }
      if ((l1 < 500L) && (!this.jdField_a_of_type_Boolean))
      {
        localRMVideoStateMgr.jdField_a_of_type_Ajty.g(true);
        localRMVideoStateMgr.a(true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] stopRecordVideo end Lock.CAPTURE_LOCK = " + azie.jdField_a_of_type_Boolean);
      }
    }
  }
  
  public void f()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtp
 * JD-Core Version:    0.7.0.1
 */