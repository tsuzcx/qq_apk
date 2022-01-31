import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ajpk
  implements View.OnClickListener
{
  public ajpk(FlowCameraActivity2 paramFlowCameraActivity2, File paramFile) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.l();
    if (((!QLog.isColorLevel()) || (!bdhb.d(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()))) || (ajpx.a == 1))
    {
      ajpy.b("", "0X8005F5B", "0");
      return;
    }
    ajpy.b("", "0X8005F5B", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpk
 * JD-Core Version:    0.7.0.1
 */