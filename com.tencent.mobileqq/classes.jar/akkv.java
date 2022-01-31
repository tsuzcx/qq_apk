import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

public class akkv
  implements Comparator<aukm>
{
  private boolean a;
  
  public akkv(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public int a(aukm paramaukm1, aukm paramaukm2)
  {
    paramaukm1 = (RecentUser)paramaukm1;
    paramaukm2 = (RecentUser)paramaukm2;
    long l3 = Math.max(paramaukm1.lastmsgtime, paramaukm1.lastmsgdrafttime);
    long l2 = Math.max(paramaukm2.lastmsgtime, paramaukm2.lastmsgdrafttime);
    long l1;
    if (this.a) {
      if ((paramaukm1.showUpTime > 0L) && (l3 == 0L))
      {
        l1 = Math.max(paramaukm1.opTime, paramaukm1.showUpTime);
        if ((paramaukm2.showUpTime <= 0L) || (l2 != 0L)) {
          break label194;
        }
        l3 = Math.max(paramaukm2.opTime, paramaukm2.showUpTime);
        l2 = l1;
        l1 = l3;
      }
    }
    for (;;)
    {
      if (l2 > l1)
      {
        l1 = 3L;
        label117:
        l3 = l1;
        if (!this.a) {
          break label280;
        }
        l2 = l1;
        if (paramaukm1.showUpTime > 0L) {
          l2 = l1 | 0x1000;
        }
        l3 = l2;
        if (paramaukm2.showUpTime <= 0L) {
          break label280;
        }
        l1 = 0x2 | 0x1000;
        label167:
        if (l2 >= l1) {
          break label269;
        }
        return 1;
        l1 = l3;
        if (l3 != 0L) {
          break;
        }
        l1 = paramaukm1.opTime;
        break;
        label194:
        if (l2 != 0L) {
          break label310;
        }
        l3 = paramaukm2.opTime;
        l2 = l1;
        l1 = l3;
        continue;
        if (l3 != 0L) {
          break label304;
        }
      }
      label269:
      label280:
      label304:
      for (l1 = paramaukm1.opTime;; l1 = l3)
      {
        if (l2 == 0L)
        {
          l3 = paramaukm2.opTime;
          l2 = l1;
          l1 = l3;
          break;
          if (l2 < l1)
          {
            l1 = 1L;
            break label117;
          }
          l1 = 2L;
          break label117;
          if (l2 == l1) {
            return 0;
          }
          return -1;
          l2 = l3;
          l1 = 2L;
          break label167;
        }
        l3 = l1;
        l1 = l2;
        l2 = l3;
        break;
      }
      label310:
      l3 = l1;
      l1 = l2;
      l2 = l3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akkv
 * JD-Core Version:    0.7.0.1
 */