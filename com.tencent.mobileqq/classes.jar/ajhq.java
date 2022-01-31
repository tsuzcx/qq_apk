import android.util.SparseArray;
import com.tencent.mobileqq.app.TroopHandler.KeywordTipInfoObserver;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager;
import java.util.Iterator;
import java.util.List;

class ajhq
  extends TroopHandler.KeywordTipInfoObserver
{
  ajhq(ajhp paramajhp) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhq
 * JD-Core Version:    0.7.0.1
 */