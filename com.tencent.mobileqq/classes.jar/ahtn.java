import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ahtn
  implements View.OnClickListener
{
  public ahtn(FlowCameraActivity2 paramFlowCameraActivity2, File paramFile) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.m();
    if (((!QLog.isColorLevel()) || (!bbdj.d(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()))) || (ahua.a == 1))
    {
      ahub.b("", "0X8005F5B", "0");
      return;
    }
    ahub.b("", "0X8005F5B", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahtn
 * JD-Core Version:    0.7.0.1
 */