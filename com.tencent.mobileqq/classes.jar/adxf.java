import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class adxf
  implements awzc<List<EmoticonPackage>>
{
  public adxf(EmosmActivity paramEmosmActivity) {}
  
  public void a(List<EmoticonPackage> paramList)
  {
    if (paramList == null) {
      return;
    }
    int j = paramList.size();
    int i = 0;
    label14:
    if (i < j) {
      if (((EmoticonPackage)paramList.get(i)).jobType != 3) {}
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1;
      Object localObject2;
      if (1 == this.a.b)
      {
        if (i == -1)
        {
          paramList = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (paramList.hasNext()) {
            localArrayList.add(((EmoticonPackage)paramList.next()).epId);
          }
          i += 1;
          break label14;
        }
        localObject1 = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (EmoticonPackage)paramList.next();
          if (((EmoticonPackage)localObject2).jobType == 3) {
            ((ArrayList)localObject1).add(((EmoticonPackage)localObject2).epId);
          }
        }
        if (i >= this.a.jdField_a_of_type_JavaUtilArrayList.size())
        {
          paramList = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (paramList.hasNext()) {
            localArrayList.add(((EmoticonPackage)paramList.next()).epId);
          }
          localArrayList.addAll((Collection)localObject1);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Awyr.a(localArrayList, 0);
        paramList = (antu)this.a.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
        if (paramList == null) {
          break;
        }
        paramList.a(localArrayList, true, 0);
        return;
        int k = this.a.jdField_a_of_type_JavaUtilArrayList.size();
        j = 0;
        while (j < k)
        {
          paramList = (EmoticonPackage)this.a.jdField_a_of_type_JavaUtilArrayList.get(j);
          if (j == i) {
            localArrayList.addAll((Collection)localObject1);
          }
          localArrayList.add(paramList.epId);
          j += 1;
        }
        continue;
        if (2 == this.a.b)
        {
          k = paramList.size();
          j = 0;
          while (j < k)
          {
            localObject1 = (EmoticonPackage)paramList.get(j);
            if (j == i)
            {
              localObject2 = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject2).hasNext()) {
                localArrayList.add(((EmoticonPackage)((Iterator)localObject2).next()).epId);
              }
            }
            if (((EmoticonPackage)localObject1).jobType != 3) {
              localArrayList.add(((EmoticonPackage)localObject1).epId);
            }
            j += 1;
          }
        }
      }
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxf
 * JD-Core Version:    0.7.0.1
 */