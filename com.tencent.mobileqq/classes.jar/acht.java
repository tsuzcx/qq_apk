import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import java.util.List;

public class acht
  implements Runnable
{
  public acht(FavroamingManager paramFavroamingManager, FavEmoRoamingHandler paramFavEmoRoamingHandler) {}
  
  public void run()
  {
    List localList = ((FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager.a.getManager(148)).a("needDel");
    if (localList.size() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingHandler.a(localList, true);
    }
    while (localList.size() != 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acht
 * JD-Core Version:    0.7.0.1
 */