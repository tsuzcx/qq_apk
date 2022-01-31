import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.Callback;
import java.util.List;

class ajch
  extends TroopAioKeywordTipManager.Callback
{
  ajch(ajcg paramajcg, List paramList, TroopAioKeywordTipManager paramTroopAioKeywordTipManager) {}
  
  public void a(MessageRecord paramMessageRecord, TroopAioKeywordTipInfo paramTroopAioKeywordTipInfo)
  {
    if (!this.jdField_a_of_type_Ajcg.a.a) {}
    do
    {
      return;
      if ((paramMessageRecord != null) && (paramTroopAioKeywordTipInfo != null)) {
        break;
      }
    } while ((this.jdField_a_of_type_JavaUtilList.size() <= 0) || (TroopAioKeywordTipBar.a(this.jdField_a_of_type_Ajcg.a)));
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager.a(this.jdField_a_of_type_JavaUtilList, null, 2, new ajci(this));
    return;
    TroopAioKeywordTipBar.a(this.jdField_a_of_type_Ajcg.a, paramMessageRecord, paramTroopAioKeywordTipInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajch
 * JD-Core Version:    0.7.0.1
 */