import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.qphone.base.util.QLog;

public class abjx
  implements CameraExceptionHandler.Callback
{
  public abjx(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity) {}
  
  public void a(RuntimeException paramRuntimeException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 2, "[onDispatchThreadException]", paramRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abjx
 * JD-Core Version:    0.7.0.1
 */