import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.Callback;
import com.tencent.qphone.base.util.QLog;

class ajcj
  extends TroopAioKeywordTipManager.Callback
{
  ajcj(ajcg paramajcg) {}
  
  public void a(MessageRecord paramMessageRecord, TroopAioKeywordTipInfo paramTroopAioKeywordTipInfo)
  {
    if (!this.a.a.a) {}
    do
    {
      return;
      if ((paramMessageRecord != null) && (paramTroopAioKeywordTipInfo != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopAioKeywordTipBar", 2, "mCheckKeywordRunnable, messageRecord == null || keywordTipInfo == null");
    return;
    TroopAioKeywordTipBar.a(this.a.a, paramMessageRecord, paramTroopAioKeywordTipInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcj
 * JD-Core Version:    0.7.0.1
 */