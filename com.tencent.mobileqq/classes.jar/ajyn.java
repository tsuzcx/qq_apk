import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

class ajyn
  implements Comparator<atmo>
{
  ajyn(ajym paramajym) {}
  
  public int a(atmo paramatmo1, atmo paramatmo2)
  {
    int j = -1;
    paramatmo1 = (RecentUser)paramatmo1;
    paramatmo2 = (RecentUser)paramatmo2;
    long l1 = Math.max(paramatmo1.lastmsgtime, paramatmo1.lastmsgdrafttime);
    long l2 = Math.max(paramatmo2.lastmsgtime, paramatmo2.lastmsgdrafttime);
    int i;
    if (l1 < l2)
    {
      i = 1;
      if (paramatmo1.getType() != paramatmo2.getType()) {
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
      } while (paramatmo1.getType() == 0);
      if (paramatmo2.getType() == 0) {
        return 1;
      }
      i = j;
    } while (paramatmo1.getType() - paramatmo2.getType() > 0);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajyn
 * JD-Core Version:    0.7.0.1
 */