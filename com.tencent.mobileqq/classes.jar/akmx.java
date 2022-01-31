import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

class akmx
  implements Comparator<aukm>
{
  akmx(akmw paramakmw) {}
  
  public int a(aukm paramaukm1, aukm paramaukm2)
  {
    int j = -1;
    paramaukm1 = (RecentUser)paramaukm1;
    paramaukm2 = (RecentUser)paramaukm2;
    long l1 = Math.max(paramaukm1.lastmsgtime, paramaukm1.lastmsgdrafttime);
    long l2 = Math.max(paramaukm2.lastmsgtime, paramaukm2.lastmsgdrafttime);
    int i;
    if (l1 < l2)
    {
      i = 1;
      if (paramaukm1.getType() != paramaukm2.getType()) {
        break label80;
      }
    }
    label80:
    do
    {
      do
      {
        return i;
        if (l1 == l2)
        {
          i = 0;
          break;
        }
        i = -1;
        break;
        i = j;
      } while (paramaukm1.getType() == 0);
      if (paramaukm2.getType() == 0) {
        return 1;
      }
      i = j;
    } while (paramaukm1.getType() - paramaukm2.getType() > 0);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akmx
 * JD-Core Version:    0.7.0.1
 */