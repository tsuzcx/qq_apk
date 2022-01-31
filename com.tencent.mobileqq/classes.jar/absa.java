import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.bubble.BubbleDiyHandler;
import com.tencent.mobileqq.bubble.VipBubbleDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class absa
  implements Runnable
{
  public absa(BubbleDiyFetcher paramBubbleDiyFetcher, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "now query mUnCacheDiyId: " + TextUtils.join(",", this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet));
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty())
      {
        ((BubbleDiyHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(70)).a(new ArrayList(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet), null);
        this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.clear();
      }
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.b.isEmpty()) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.b();
    }
    Object localObject;
    if (!this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.c.isEmpty())
    {
      localIterator = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.c.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.c((String)localObject);
        }
      }
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (VipBubbleDrawable)localIterator.next();
      if ((localObject == null) || (((VipBubbleDrawable)localObject).getCallback() == null)) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject);
      }
    }
    BubbleDiyFetcher.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     absa
 * JD-Core Version:    0.7.0.1
 */