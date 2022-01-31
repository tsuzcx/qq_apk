import android.widget.TextView;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordButtonView;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy;
import com.tencent.qphone.base.util.QLog;

public class aaff
  implements Runnable
{
  public aaff(ARVideoRecordViewProxy paramARVideoRecordViewProxy, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      ARVideoRecordViewProxy.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy).setShowState(2);
      ARVideoRecordViewProxy.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy);
      ARVideoRecordViewProxy.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy, 0);
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordViewProxy", 2, "switchUIdisplayMode run RECORD_NORMAL_MODE");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Int != 1);
      ARVideoRecordViewProxy.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy).setShowState(3);
      ARVideoRecordViewProxy.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy).setVisibility(0);
      ARVideoRecordViewProxy.b(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy).setVisibility(0);
      ARVideoRecordViewProxy.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy, 1);
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordViewProxy", 2, "switchUIdisplayMode run RECORD_PROGRESS_MODE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaff
 * JD-Core Version:    0.7.0.1
 */