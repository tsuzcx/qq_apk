import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

public class alts
  implements View.OnClickListener
{
  public alts(FlowCameraActivity2 paramFlowCameraActivity2, File paramFile) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.l();
    if (((!QLog.isColorLevel()) || (!bhmi.d(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()))) || (aluf.a == 1)) {
      alug.b("", "0X8005F5B", "0");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      alug.b("", "0X8005F5B", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alts
 * JD-Core Version:    0.7.0.1
 */