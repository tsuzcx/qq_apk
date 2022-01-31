import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class abjz
  implements Runnable
{
  public abjz(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("DynamicAvatarRecordActivity", 2, "stopRecord(): Async, mVideoFileDir:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString + ",is to call AVideoCodec.recordSubmit()");
      }
      RecordManager.a().a().recordSubmit();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DynamicAvatarRecordActivity", 2, "stopRecord(): Async, mVideoFileDir:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString + ", call AVideoCodec.recordSubmit() fail, error = " + localUnsatisfiedLinkError.getMessage());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abjz
 * JD-Core Version:    0.7.0.1
 */