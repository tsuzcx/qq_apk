import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewPresenter;
import com.tencent.qphone.base.util.QLog;

public class aaey
  implements Runnable
{
  public aaey(ARVideoRecordUIControllerImpl paramARVideoRecordUIControllerImpl, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("onRecordUpdate progress=%s", new Object[] { Integer.valueOf(1) }));
    if (ARVideoRecordUIControllerImpl.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordUIControllerImpl)) {
      ARVideoRecordUIControllerImpl.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordUIControllerImpl).a(this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaey
 * JD-Core Version:    0.7.0.1
 */