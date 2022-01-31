import MWIFI.SCGet3rdCloudCheck;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class agzd
  implements View.OnClickListener
{
  agzd(agxq paramagxq, SCGet3rdCloudCheck paramSCGet3rdCloudCheck) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateWiFiSecurityBanner, onClick");
    }
    bbrm.a(agxq.a(this.jdField_a_of_type_Agxq), this.jdField_a_of_type_MWIFISCGet3rdCloudCheck);
    agxq.a(this.jdField_a_of_type_Agxq).removeMessages(202);
    agxq.a(this.jdField_a_of_type_Agxq).obtainMessage(202).sendToTarget();
    awqx.a(agxq.a(this.jdField_a_of_type_Agxq).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 6, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agzd
 * JD-Core Version:    0.7.0.1
 */