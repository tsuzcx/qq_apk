import com.tencent.mobileqq.nearby.NearbyIconDecoder;
import com.tencent.mobileqq.nearby.ipc.NearbyProcObserver;
import java.util.List;

public class aema
  extends NearbyProcObserver
{
  public aema(NearbyIconDecoder paramNearbyIconDecoder) {}
  
  public void a(List paramList1, List paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null) || (paramList1.size() == 0) || (paramList1.size() != paramList2.size())) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList1.size())
      {
        this.a.a((String)paramList1.get(i), (String)paramList2.get(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aema
 * JD-Core Version:    0.7.0.1
 */