import MWIFI.SCGet3rdCloudCheck;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class allm
  implements View.OnClickListener
{
  allm(aljw paramaljw, SCGet3rdCloudCheck paramSCGet3rdCloudCheck) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateWiFiSecurityBanner, onClick");
    }
    bjhk.a(aljw.a(this.jdField_a_of_type_Aljw), this.jdField_a_of_type_MWIFISCGet3rdCloudCheck);
    aljw.a(this.jdField_a_of_type_Aljw).removeMessages(202);
    aljw.a(this.jdField_a_of_type_Aljw).obtainMessage(202).sendToTarget();
    bdll.a(aljw.a(this.jdField_a_of_type_Aljw).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 6, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allm
 * JD-Core Version:    0.7.0.1
 */