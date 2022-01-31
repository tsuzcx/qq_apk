import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;

public class alfo
  implements Runnable
{
  public alfo(ARWorldCupGameLogicManager paramARWorldCupGameLogicManager, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager) == null) || (ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager) == null) || (ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager) == null)) {
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager).setVisibility(8);
      ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager).setVisibility(8);
      ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager).setVisibility(8);
      return;
    case 1: 
      ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager).setText(this.jdField_a_of_type_JavaLangString);
      ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager).setVisibility(8);
      ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager).setVisibility(0);
      ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager).setVisibility(0);
      return;
    }
    ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager).setVisibility(0);
    ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager).setVisibility(8);
    ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alfo
 * JD-Core Version:    0.7.0.1
 */