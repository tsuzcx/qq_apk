import android.view.View;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;

public class alfh
  implements Runnable
{
  public alfh(ARWorldCupGameLogicManager paramARWorldCupGameLogicManager, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      if (ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager) != null)
      {
        ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager).setOnTouchListener(new alfi(this));
        ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager).setVisibility(0);
      }
    }
    while (ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager) == null) {
      return;
    }
    ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager).setOnTouchListener(null);
    ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alfh
 * JD-Core Version:    0.7.0.1
 */