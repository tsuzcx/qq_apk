import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.bubble.VipBubbleDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class abky
  implements Runnable
{
  public abky(BubbleDiyFetcher paramBubbleDiyFetcher, Set paramSet) {}
  
  public void run()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.a.iterator();
    while (localIterator.hasNext())
    {
      VipBubbleDrawable localVipBubbleDrawable = (VipBubbleDrawable)localIterator.next();
      if ((localVipBubbleDrawable != null) && (localVipBubbleDrawable.getCallback() != null))
      {
        String str = localVipBubbleDrawable.a;
        if ((this.jdField_a_of_type_JavaUtilSet.contains(str)) && (!localHashSet.contains(localVipBubbleDrawable)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleDiyFetcher", 2, "refresh uinAndDiyId drawables: " + str + ", vipBubbleDrawable:" + localVipBubbleDrawable.toString());
          }
          localHashSet.add(localVipBubbleDrawable);
          localVipBubbleDrawable.invalidateSelf();
          this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.a.remove(localVipBubbleDrawable);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.a.remove(localVipBubbleDrawable);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("BubbleDiyFetcher", 2, "wait for refresh size: " + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.a.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abky
 * JD-Core Version:    0.7.0.1
 */