import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

public class akku
  implements Comparator<auko>
{
  private boolean a;
  
  public akku(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public int a(auko paramauko1, auko paramauko2)
  {
    paramauko1 = (RecentUser)paramauko1;
    paramauko2 = (RecentUser)paramauko2;
    long l3 = Math.max(paramauko1.lastmsgtime, paramauko1.lastmsgdrafttime);
    long l2 = Math.max(paramauko2.lastmsgtime, paramauko2.lastmsgdrafttime);
    long l1;
    if (this.a) {
      if ((paramauko1.showUpTime > 0L) && (l3 == 0L))
      {
        l1 = Math.max(paramauko1.opTime, paramauko1.showUpTime);
        if ((paramauko2.showUpTime <= 0L) || (l2 != 0L)) {
          break label194;
        }
        l3 = Math.max(paramauko2.opTime, paramauko2.showUpTime);
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
        if (paramauko1.showUpTime > 0L) {
          l2 = l1 | 0x1000;
        }
        l3 = l2;
        if (paramauko2.showUpTime <= 0L) {
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
        l1 = paramauko1.opTime;
        break;
        label194:
        if (l2 != 0L) {
          break label310;
        }
        l3 = paramauko2.opTime;
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
      for (l1 = paramauko1.opTime;; l1 = l3)
      {
        if (l2 == 0L)
        {
          l3 = paramauko2.opTime;
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
 * Qualified Name:     akku
 * JD-Core Version:    0.7.0.1
 */