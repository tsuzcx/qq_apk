import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler.KeywordTipInfoObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.Callback;
import java.util.List;

public class ajht
  extends TroopHandler.KeywordTipInfoObserver
{
  public ajht(TroopAioKeywordTipManager paramTroopAioKeywordTipManager, MessageRecord paramMessageRecord, TroopAioKeywordTipManager.Callback paramCallback) {}
  
  protected void a(boolean paramBoolean, List paramList)
  {
    if (paramBoolean)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        TroopAioKeywordTipManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, (TroopAioKeywordTipInfo)paramList.get(0), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager$Callback);
        synchronized (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager.b)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager.b.put(((TroopAioKeywordTipInfo)paramList.get(0)).ruleId, paramList.get(0));
          ThreadManager.post(new ajhu(this, paramList), 2, null, true);
          return;
        }
      }
      TroopAioKeywordTipManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager$Callback);
      return;
    }
    TroopAioKeywordTipManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager$Callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajht
 * JD-Core Version:    0.7.0.1
 */