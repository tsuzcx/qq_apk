import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import java.util.Comparator;

public class aiea
  implements Comparator<ResultRecord>
{
  public int a(ResultRecord paramResultRecord1, ResultRecord paramResultRecord2)
  {
    int j = -1;
    long l1;
    long l2;
    label17:
    int i;
    if (paramResultRecord1 == null)
    {
      l1 = 0L;
      if (paramResultRecord2 != null) {
        break label38;
      }
      l2 = 0L;
      if (l1 != l2) {
        break label47;
      }
      i = 0;
    }
    label38:
    label47:
    do
    {
      do
      {
        return i;
        l1 = paramResultRecord1.a;
        break;
        l2 = paramResultRecord2.a;
        break label17;
        i = j;
      } while (l1 == 0L);
      if (l2 == 0L) {
        return 1;
      }
      i = j;
    } while (l1 < l2);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aiea
 * JD-Core Version:    0.7.0.1
 */