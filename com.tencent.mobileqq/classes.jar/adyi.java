import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotPicManager;
import mqq.app.MobileQQ;

public class adyi
  implements Runnable
{
  public adyi(HotPicManager paramHotPicManager, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager.a.getApplication().getSharedPreferences("sp_hotpic_" + this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager.a.c(), 0).edit().putInt("hot_pic_last_click", this.jdField_a_of_type_Int).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyi
 * JD-Core Version:    0.7.0.1
 */