import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class alth
  implements Comparator<Object>
{
  alth(altc paramaltc) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null)) {
      return 0;
    }
    if (paramObject1 == null) {
      return -1;
    }
    if (paramObject2 == null) {
      return 1;
    }
    if (((paramObject1 instanceof avqe)) && ((paramObject2 instanceof avqe))) {
      return (int)(((avqe)paramObject2).a - ((avqe)paramObject1).a);
    }
    if (((paramObject1 instanceof avqe)) && ((paramObject2 instanceof PhoneContact))) {
      return (int)(((PhoneContact)paramObject2).lastScanTime - ((avqe)paramObject1).a * 1000L);
    }
    if (((paramObject1 instanceof PhoneContact)) && ((paramObject2 instanceof PhoneContact))) {
      return (int)(((PhoneContact)paramObject2).lastScanTime - ((PhoneContact)paramObject1).lastScanTime);
    }
    if (((paramObject1 instanceof PhoneContact)) && ((paramObject2 instanceof avqe))) {
      return (int)(((avqe)paramObject2).a * 1000L - ((PhoneContact)paramObject1).lastScanTime);
    }
    return paramObject1.hashCode() - paramObject2.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alth
 * JD-Core Version:    0.7.0.1
 */