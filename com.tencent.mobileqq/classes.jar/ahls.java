import MWIFI.SCGet3rdCloudCheck;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ahls
  implements View.OnClickListener
{
  ahls(ahkf paramahkf, SCGet3rdCloudCheck paramSCGet3rdCloudCheck) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateWiFiSecurityBanner, onClick");
    }
    bcvm.a(ahkf.a(this.jdField_a_of_type_Ahkf), this.jdField_a_of_type_MWIFISCGet3rdCloudCheck);
    ahkf.a(this.jdField_a_of_type_Ahkf).removeMessages(202);
    ahkf.a(this.jdField_a_of_type_Ahkf).obtainMessage(202).sendToTarget();
    axqw.a(ahkf.a(this.jdField_a_of_type_Ahkf).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 6, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahls
 * JD-Core Version:    0.7.0.1
 */