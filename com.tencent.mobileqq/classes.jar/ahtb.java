import com.tencent.mobileqq.statistics.storage.StorageItem;
import java.util.Comparator;

public class ahtb
  implements Comparator
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (StorageItem)paramObject1;
    paramObject2 = (StorageItem)paramObject2;
    if (paramObject1.a > paramObject2.a) {
      return -1;
    }
    if (paramObject1.a < paramObject2.a) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahtb
 * JD-Core Version:    0.7.0.1
 */