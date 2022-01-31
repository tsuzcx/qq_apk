import com.tencent.mobileqq.troop.data.TroopAioKeywordHelper;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager;
import java.util.List;

public class aiop
  implements Runnable
{
  public aiop(TroopAioKeywordTipManager paramTroopAioKeywordTipManager, String paramString1, String paramString2, Integer paramInteger) {}
  
  public void run()
  {
    String str = TroopAioKeywordTipManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_JavaLangInteger);
    synchronized (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager.b)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager.b.contains(str)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager.b.add(str);
      }
      TroopAioKeywordHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager.a, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiop
 * JD-Core Version:    0.7.0.1
 */