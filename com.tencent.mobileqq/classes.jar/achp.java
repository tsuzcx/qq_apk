import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager.FavEmotionDataInPanelCallback;
import java.util.List;
import mqq.os.MqqHandler;

public class achp
  implements Runnable
{
  public achp(FavroamingDBManager paramFavroamingDBManager, FavroamingDBManager.FavEmotionDataInPanelCallback paramFavEmotionDataInPanelCallback) {}
  
  public void run()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingDBManager.b();
    ThreadManager.getUIHandler().post(new achq(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     achp
 * JD-Core Version:    0.7.0.1
 */