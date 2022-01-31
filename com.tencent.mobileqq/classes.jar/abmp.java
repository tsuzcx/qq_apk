import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class abmp
  implements Runnable
{
  public abmp(BusinessCardManager paramBusinessCardManager) {}
  
  public void run()
  {
    Object localObject = this.a.a();
    if (localObject != null) {}
    for (int i = ((List)localObject).size();; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard_Manager", 2, "Init cache from DB,count=" + i);
      }
      this.a.a.clear();
      if (i <= 0) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BusinessCard localBusinessCard = (BusinessCard)((Iterator)localObject).next();
        this.a.a.put(localBusinessCard.cardId, localBusinessCard);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abmp
 * JD-Core Version:    0.7.0.1
 */