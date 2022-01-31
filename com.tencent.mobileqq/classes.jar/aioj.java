import android.util.SparseArray;
import com.tencent.mobileqq.app.TroopHandler.KeywordTipInfoObserver;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager;
import java.util.Iterator;
import java.util.List;

class aioj
  extends TroopHandler.KeywordTipInfoObserver
{
  aioj(aioi paramaioi) {}
  
  protected void a(boolean paramBoolean, List paramList)
  {
    SparseArray localSparseArray;
    if (paramBoolean)
    {
      localSparseArray = this.a.a.b;
      if (paramList != null) {
        try
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            TroopAioKeywordTipInfo localTroopAioKeywordTipInfo = (TroopAioKeywordTipInfo)paramList.next();
            this.a.a.b.put(localTroopAioKeywordTipInfo.ruleId, localTroopAioKeywordTipInfo);
          }
        }
        finally {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aioj
 * JD-Core Version:    0.7.0.1
 */