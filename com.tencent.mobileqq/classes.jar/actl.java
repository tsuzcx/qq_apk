import com.tencent.mobileqq.activity.aio.doodle.LoadDataJob;
import java.util.Comparator;

public class actl
  implements Comparator
{
  public actl(LoadDataJob paramLoadDataJob) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (actx)paramObject1;
    paramObject2 = (actx)paramObject2;
    return paramObject1.a - paramObject2.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     actl
 * JD-Core Version:    0.7.0.1
 */