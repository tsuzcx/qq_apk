import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.troop.utils.TroopAioNotifyManager;
import java.util.ArrayList;
import java.util.List;

public final class ajny
  implements Runnable
{
  public ajny(QQAppInterface paramQQAppInterface, String paramString, TroopHandler paramTroopHandler) {}
  
  public void run()
  {
    List localList = TroopAioNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    localList = TroopAioNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ArrayList(), localList);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(94, true, new Object[] { this.jdField_a_of_type_JavaLangString, localList });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajny
 * JD-Core Version:    0.7.0.1
 */