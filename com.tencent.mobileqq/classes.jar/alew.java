import MWIFI.SCGet3rdCloudCheck;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class alew
  implements View.OnClickListener
{
  alew(aldh paramaldh, SCGet3rdCloudCheck paramSCGet3rdCloudCheck) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateWiFiSecurityBanner, onClick");
    }
    bixr.a(aldh.a(this.jdField_a_of_type_Aldh), this.jdField_a_of_type_MWIFISCGet3rdCloudCheck);
    aldh.a(this.jdField_a_of_type_Aldh).removeMessages(202);
    aldh.a(this.jdField_a_of_type_Aldh).obtainMessage(202).sendToTarget();
    bdla.a(aldh.a(this.jdField_a_of_type_Aldh).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 6, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alew
 * JD-Core Version:    0.7.0.1
 */