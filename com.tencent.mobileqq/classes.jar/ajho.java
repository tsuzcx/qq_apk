import MWIFI.SCGet3rdCloudCheck;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ajho
  implements View.OnClickListener
{
  ajho(ajgb paramajgb, SCGet3rdCloudCheck paramSCGet3rdCloudCheck) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateWiFiSecurityBanner, onClick");
    }
    bezm.a(ajgb.a(this.jdField_a_of_type_Ajgb), this.jdField_a_of_type_MWIFISCGet3rdCloudCheck);
    ajgb.a(this.jdField_a_of_type_Ajgb).removeMessages(202);
    ajgb.a(this.jdField_a_of_type_Ajgb).obtainMessage(202).sendToTarget();
    azqs.a(ajgb.a(this.jdField_a_of_type_Ajgb).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 6, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajho
 * JD-Core Version:    0.7.0.1
 */