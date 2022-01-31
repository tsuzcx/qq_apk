import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.olympic.OlympicManager;

public class agil
  implements Runnable
{
  public agil(OlympicManager paramOlympicManager, int paramInt) {}
  
  public void run()
  {
    synchronized (OlympicManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager))
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager.a.getPreferences();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putInt("isTorchbearer", this.jdField_a_of_type_Int).commit();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agil
 * JD-Core Version:    0.7.0.1
 */