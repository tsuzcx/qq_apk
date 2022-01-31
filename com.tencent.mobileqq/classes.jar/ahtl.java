import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ahtl
  implements View.OnClickListener
{
  public ahtl(FlowCameraActivity2 paramFlowCameraActivity2, File paramFile) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.m();
    if (((!QLog.isColorLevel()) || (!bbdx.d(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()))) || (ahty.a == 1))
    {
      ahtz.b("", "0X8005F5B", "0");
      return;
    }
    ahtz.b("", "0X8005F5B", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahtl
 * JD-Core Version:    0.7.0.1
 */