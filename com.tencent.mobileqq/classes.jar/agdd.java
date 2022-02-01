import com.tencent.mobileqq.activity.aio.doodle.LoadDataJob;
import java.util.Comparator;

public class agdd
  implements Comparator
{
  public agdd(LoadDataJob paramLoadDataJob) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (agdp)paramObject1;
    paramObject2 = (agdp)paramObject2;
    return paramObject1.a - paramObject2.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdd
 * JD-Core Version:    0.7.0.1
 */