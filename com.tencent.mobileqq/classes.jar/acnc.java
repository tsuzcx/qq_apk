import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;

public class acnc
  implements Runnable
{
  public acnc(EmoticonMainPanel paramEmoticonMainPanel, EmoticonHandler paramEmoticonHandler, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppEmoticonHandler.c();
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("lastRequestTime", System.currentTimeMillis()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acnc
 * JD-Core Version:    0.7.0.1
 */