import MWIFI.SCGet3rdCloudCheck;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ajcz
  implements View.OnClickListener
{
  ajcz(ajbm paramajbm, SCGet3rdCloudCheck paramSCGet3rdCloudCheck) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateWiFiSecurityBanner, onClick");
    }
    bevd.a(ajbm.a(this.jdField_a_of_type_Ajbm), this.jdField_a_of_type_MWIFISCGet3rdCloudCheck);
    ajbm.a(this.jdField_a_of_type_Ajbm).removeMessages(202);
    ajbm.a(this.jdField_a_of_type_Ajbm).obtainMessage(202).sendToTarget();
    azmj.a(ajbm.a(this.jdField_a_of_type_Ajbm).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 6, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcz
 * JD-Core Version:    0.7.0.1
 */