import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.TorchInfo;
import java.io.ByteArrayOutputStream;

public class afqu
  implements Runnable
{
  public afqu(OlympicManager paramOlympicManager, TorchInfo paramTorchInfo) {}
  
  public void run()
  {
    synchronized (OlympicManager.b(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager))
    {
      new ByteArrayOutputStream();
      OlympicManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager);
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager.a.getPreferences().getBoolean("olympic_setting_ever_fetch_flag_switch_here", false);
      if ((this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo.transfer_num != 1L) && (!bool)) {}
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afqu
 * JD-Core Version:    0.7.0.1
 */