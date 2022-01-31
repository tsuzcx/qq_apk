import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import java.io.File;
import java.util.ArrayList;

public class ahto
  implements View.OnClickListener
{
  public ahto(FlowCameraActivity2 paramFlowCameraActivity2, File paramFile, Button paramButton) {}
  
  public void onClick(View paramView)
  {
    if (new File(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.b).exists())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.jdField_a_of_type_JavaIoFile)));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.m();
      paramView = new ArrayList();
      paramView.add(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.b);
      ahub.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2, paramView);
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.setResult(1001);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.finish();
      if (ahua.a == 1) {
        ahub.b("", "0X8005F5C", "0");
      }
    }
    else
    {
      return;
    }
    ahub.b("", "0X8005F5C", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahto
 * JD-Core Version:    0.7.0.1
 */