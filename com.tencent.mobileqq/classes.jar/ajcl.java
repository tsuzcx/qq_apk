import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ajcl
  implements Runnable
{
  public ajcl(TroopAioKeywordTipManager paramTroopAioKeywordTipManager, List paramList) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      TroopAioKeywordTipManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager, (MessageRecord)localObject2);
    }
    localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (MessageRecord)((Iterator)localObject2).next();
      localObject3 = TroopAioKeywordTipManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager, (MessageRecord)localObject3);
      if (localObject3 == null) {
        break label133;
      }
      if (localObject1 != null) {
        break label130;
      }
      localObject1 = new ArrayList();
      label97:
      ((List)localObject1).addAll((Collection)localObject3);
    }
    label130:
    label133:
    for (;;)
    {
      break;
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        TroopAioKeywordTipManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager, (List)localObject1);
      }
      return;
      break label97;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcl
 * JD-Core Version:    0.7.0.1
 */