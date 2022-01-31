import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import com.tencent.wordsegment.ContextItem;
import com.tencent.wordsegment.SemanticItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

class abes
  implements Runnable
{
  abes(aber paramaber, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aber.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      ArkAppCenter.b("ArkApp.ArkRecommendLogic", String.format("analyseInstantText server analyse, this is null, return", new Object[0]));
    }
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (ContextItem)localIterator.next();
          ArkAppCenter.b("ArkApp.ArkRecommendLogic", String.format("analyseInstantText server analyse, context:%s", new Object[] { ArkRecommendLogic.a((ContextItem)localObject) }));
          if (localObject != null)
          {
            ArrayList localArrayList = new ArrayList();
            RecommendCommonMessage.ArkContextInfo localArkContextInfo = new RecommendCommonMessage.ArkContextInfo();
            localArkContextInfo.context = ((ContextItem)localObject).contextName;
            localObject = ((ContextItem)localObject).semantic.iterator();
            while (((Iterator)localObject).hasNext())
            {
              SemanticItem localSemanticItem = (SemanticItem)((Iterator)localObject).next();
              localArkContextInfo.semantic.put(localSemanticItem.key, localSemanticItem.value);
            }
            localArrayList.add(localArkContextInfo);
            ArkRecommendLogic.a(this.jdField_a_of_type_Aber.jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic, localArrayList, null, this.jdField_a_of_type_Aber.b, 2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abes
 * JD-Core Version:    0.7.0.1
 */