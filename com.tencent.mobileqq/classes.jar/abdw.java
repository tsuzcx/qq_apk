import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleDiyEntity;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class abdw
  implements Runnable
{
  public abdw(BubbleDiyFetcher paramBubbleDiyFetcher, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(BubbleDiyEntity.class, true, null, null, null, null, null, " 20 ");
    if ((localList != null) && (localList.size() > 0))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        BubbleDiyEntity localBubbleDiyEntity = (BubbleDiyEntity)localIterator.next();
        if (!TextUtils.isEmpty(localBubbleDiyEntity.uinAndDiyId))
        {
          this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.a.put(localBubbleDiyEntity.uinAndDiyId, localBubbleDiyEntity.diyText);
          this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.b.put(localBubbleDiyEntity.uinAndDiyId, localBubbleDiyEntity.convertToPasterMap());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "initCacheFromDB, size: " + localList.size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abdw
 * JD-Core Version:    0.7.0.1
 */