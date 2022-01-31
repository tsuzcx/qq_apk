import com.tencent.mobileqq.troop.createNewTroop.NewTroopSearchResultDialog;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;

class ajio
  implements Runnable
{
  ajio(ajin paramajin) {}
  
  public void run()
  {
    TroopCreateLogic.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic);
    new NewTroopSearchResultDialog(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajio
 * JD-Core Version:    0.7.0.1
 */