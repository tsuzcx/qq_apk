import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

public class akrj
  implements View.OnClickListener
{
  public akrj(FlowCameraActivity2 paramFlowCameraActivity2, File paramFile) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.i();
    if (((!QLog.isColorLevel()) || (!FileUtils.deleteFile(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()))) || (akrw.a == 1)) {
      akrx.b("", "0X8005F5B", "0");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      akrx.b("", "0X8005F5B", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrj
 * JD-Core Version:    0.7.0.1
 */