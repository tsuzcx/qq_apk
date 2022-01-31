import MWIFI.SCGet3rdCloudCheck;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ahlq
  implements View.OnClickListener
{
  ahlq(ahkd paramahkd, SCGet3rdCloudCheck paramSCGet3rdCloudCheck) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateWiFiSecurityBanner, onClick");
    }
    bcwb.a(ahkd.a(this.jdField_a_of_type_Ahkd), this.jdField_a_of_type_MWIFISCGet3rdCloudCheck);
    ahkd.a(this.jdField_a_of_type_Ahkd).removeMessages(202);
    ahkd.a(this.jdField_a_of_type_Ahkd).obtainMessage(202).sendToTarget();
    axqy.a(ahkd.a(this.jdField_a_of_type_Ahkd).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 6, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahlq
 * JD-Core Version:    0.7.0.1
 */