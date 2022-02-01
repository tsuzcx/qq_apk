import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class aizn
  implements Comparator<Object>
{
  aizn(aizi paramaizi) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    int j = -1;
    int i;
    if ((paramObject1 == null) && (paramObject2 == null)) {
      i = 0;
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while (paramObject1 == null);
        if (paramObject2 == null) {
          return 1;
        }
        if (((paramObject1 instanceof ajbn)) && ((paramObject2 instanceof ajbn))) {
          return (int)(((ajbn)paramObject2).a - ((ajbn)paramObject1).a);
        }
        if (((paramObject1 instanceof ajbn)) && ((paramObject2 instanceof PhoneContact))) {
          return (int)(((PhoneContact)paramObject2).lastScanTime - ((ajbn)paramObject1).a * 1000L);
        }
        if (((paramObject1 instanceof PhoneContact)) && ((paramObject2 instanceof PhoneContact))) {
          return (int)(((PhoneContact)paramObject2).lastScanTime - ((PhoneContact)paramObject1).lastScanTime);
        }
        if (((paramObject1 instanceof PhoneContact)) && ((paramObject2 instanceof ajbn))) {
          return (int)(((ajbn)paramObject2).a * 1000L - ((PhoneContact)paramObject1).lastScanTime);
        }
        i = j;
      } while ((paramObject1 instanceof PhoneContact));
      i = j;
    } while ((paramObject1 instanceof ajbn));
    if (((paramObject2 instanceof PhoneContact)) || ((paramObject2 instanceof ajbn))) {
      return 1;
    }
    return paramObject1.hashCode() - paramObject2.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizn
 * JD-Core Version:    0.7.0.1
 */