import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class akbt
  implements Comparator<Object>
{
  akbt(akbo paramakbo) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof atyy)) && ((paramObject2 instanceof atyy))) {
      return (int)(((atyy)paramObject2).a - ((atyy)paramObject1).a);
    }
    if (((paramObject1 instanceof atyy)) && ((paramObject2 instanceof PhoneContact))) {
      return (int)(((PhoneContact)paramObject2).lastScanTime - ((atyy)paramObject1).a * 1000L);
    }
    if (((paramObject1 instanceof PhoneContact)) && ((paramObject2 instanceof PhoneContact))) {
      return (int)(((PhoneContact)paramObject2).lastScanTime - ((PhoneContact)paramObject1).lastScanTime);
    }
    if (((paramObject1 instanceof PhoneContact)) && ((paramObject2 instanceof atyy))) {
      return (int)(((atyy)paramObject2).a * 1000L - ((PhoneContact)paramObject1).lastScanTime);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akbt
 * JD-Core Version:    0.7.0.1
 */