import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.TroopMemberInfo;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class accm
  implements Runnable
{
  public accm(MessageForQQWalletTips paramMessageForQQWalletTips, WeakReference paramWeakReference, List paramList, String paramString) {}
  
  public void run()
  {
    Object localObject1 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (TroopManager)((QQAppInterface)localObject1).getManager(51);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject3 = (String)localIterator.next();
      localObject3 = ((TroopManager)localObject2).b(this.jdField_a_of_type_JavaLangString, (String)localObject3);
      if (localObject3 != null) {
        localLinkedList.add(localObject3);
      }
    }
    if (localLinkedList.size() >= this.jdField_a_of_type_JavaUtilList.size())
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.updateMsg((QQAppInterface)localObject1);
      return;
    }
    localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    label135:
    label229:
    label232:
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (localLinkedList == null) {
          break label229;
        }
        localIterator = localLinkedList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject3 = (TroopMemberInfo)localIterator.next();
        } while ((localObject3 == null) || (!QWalletTools.c(((TroopMemberInfo)localObject3).memberuin, (String)localObject2)));
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label232;
        }
        ThreadManager.executeOnNetWorkThread(new accn(this, (String)localObject2));
        break label135;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     accm
 * JD-Core Version:    0.7.0.1
 */