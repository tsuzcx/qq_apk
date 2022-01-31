import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.Callback;
import java.util.List;

class ajhk
  extends TroopAioKeywordTipManager.Callback
{
  ajhk(ajhj paramajhj, List paramList, TroopAioKeywordTipManager paramTroopAioKeywordTipManager) {}
  
  public void a(MessageRecord paramMessageRecord, TroopAioKeywordTipInfo paramTroopAioKeywordTipInfo)
  {
    if (!this.jdField_a_of_type_Ajhj.a.a) {}
    do
    {
      return;
      if ((paramMessageRecord != null) && (paramTroopAioKeywordTipInfo != null)) {
        break;
      }
    } while ((this.jdField_a_of_type_JavaUtilList.size() <= 0) || (TroopAioKeywordTipBar.a(this.jdField_a_of_type_Ajhj.a)));
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager.a(this.jdField_a_of_type_JavaUtilList, null, 2, new ajhl(this));
    return;
    TroopAioKeywordTipBar.a(this.jdField_a_of_type_Ajhj.a, paramMessageRecord, paramTroopAioKeywordTipInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhk
 * JD-Core Version:    0.7.0.1
 */