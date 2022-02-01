import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;

public class alpg
  implements View.OnClickListener
{
  public alpg(FlowCameraActivity2 paramFlowCameraActivity2, File paramFile, Button paramButton) {}
  
  public void onClick(View paramView)
  {
    if (new File(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.b).exists())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.jdField_a_of_type_JavaIoFile)));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.i();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.b);
      alpt.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2, localArrayList);
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.setResult(1001);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.finish();
      if (alps.a != 1) {
        break label127;
      }
      alpt.b("", "0X8005F5C", "0");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label127:
      alpt.b("", "0X8005F5C", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alpg
 * JD-Core Version:    0.7.0.1
 */