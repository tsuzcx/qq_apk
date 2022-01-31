import com.tencent.mobileqq.shortvideo.common.Observable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class aiah
{
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public aiah(Observable paramObservable) {}
  
  public ArrayList a(Object paramObject)
  {
    return (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramObject);
  }
  
  public void a(Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ArrayList localArrayList = (ArrayList)localEntry.getValue();
      int i = 0;
      while (i < localArrayList.size())
      {
        Object localObject = localArrayList.get(i);
        if ((localObject == paramObject) || ((localObject != null) && (localObject.equals(paramObject)))) {
          ((ArrayList)localEntry.getValue()).remove(paramObject);
        } else {
          i += 1;
        }
      }
    }
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramObject1);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramObject1, localArrayList1);
    }
    if (!localArrayList1.contains(paramObject2)) {
      localArrayList1.add(paramObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aiah
 * JD-Core Version:    0.7.0.1
 */