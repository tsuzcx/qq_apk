import com.tencent.mobileqq.app.GlobalSearchObserver;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ahyq
  extends GlobalSearchObserver
{
  public ahyq(FTSMessageSearchEngine paramFTSMessageSearchEngine) {}
  
  public void a(boolean paramBoolean, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    super.a(paramBoolean, paramArrayList1, paramArrayList2);
    paramArrayList2 = (String)paramArrayList2.get(0);
    StringBuilder localStringBuilder = new StringBuilder(64);
    if ((paramBoolean) && (paramArrayList1 != null) && (paramArrayList1.size() >= 1))
    {
      paramArrayList1 = ((ArrayList)paramArrayList1.get(0)).iterator();
      while (paramArrayList1.hasNext())
      {
        Object localObject = (String)paramArrayList1.next();
        if (((String)localObject).charAt(0) < '')
        {
          localObject = SQLiteFTSUtils.b((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            int j = localObject.length;
            int i = 0;
            while (i < j)
            {
              localStringBuilder.append(localObject[i]).append(" ");
              i += 1;
            }
          }
        }
        else
        {
          localStringBuilder.append((String)localObject).append(" ");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("FTSMessageSearchEngine", 2, "svcSeg result = [" + localStringBuilder.toString().trim() + "]");
      }
    }
    FTSMessageSearchEngine.a(this.a).put(paramArrayList2, localStringBuilder);
    paramArrayList1 = FTSMessageSearchEngine.b(this.a).get(paramArrayList2);
    if (paramArrayList1 != null) {
      try
      {
        paramArrayList1.notify();
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahyq
 * JD-Core Version:    0.7.0.1
 */