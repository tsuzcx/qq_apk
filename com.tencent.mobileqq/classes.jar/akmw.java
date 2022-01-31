import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

class akmw
  implements Comparator<auko>
{
  akmw(akmv paramakmv) {}
  
  public int a(auko paramauko1, auko paramauko2)
  {
    int j = -1;
    paramauko1 = (RecentUser)paramauko1;
    paramauko2 = (RecentUser)paramauko2;
    long l1 = Math.max(paramauko1.lastmsgtime, paramauko1.lastmsgdrafttime);
    long l2 = Math.max(paramauko2.lastmsgtime, paramauko2.lastmsgdrafttime);
    int i;
    if (l1 < l2)
    {
      i = 1;
      if (paramauko1.getType() != paramauko2.getType()) {
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
      } while (paramauko1.getType() == 0);
      if (paramauko2.getType() == 0) {
        return 1;
      }
      i = j;
    } while (paramauko1.getType() - paramauko2.getType() > 0);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akmw
 * JD-Core Version:    0.7.0.1
 */