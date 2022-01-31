import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class akbs
  implements Comparator<Object>
{
  akbs(akbn paramakbn) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof atza)) && ((paramObject2 instanceof atza))) {
      return (int)(((atza)paramObject2).a - ((atza)paramObject1).a);
    }
    if (((paramObject1 instanceof atza)) && ((paramObject2 instanceof PhoneContact))) {
      return (int)(((PhoneContact)paramObject2).lastScanTime - ((atza)paramObject1).a * 1000L);
    }
    if (((paramObject1 instanceof PhoneContact)) && ((paramObject2 instanceof PhoneContact))) {
      return (int)(((PhoneContact)paramObject2).lastScanTime - ((PhoneContact)paramObject1).lastScanTime);
    }
    if (((paramObject1 instanceof PhoneContact)) && ((paramObject2 instanceof atza))) {
      return (int)(((atza)paramObject2).a * 1000L - ((PhoneContact)paramObject1).lastScanTime);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akbs
 * JD-Core Version:    0.7.0.1
 */