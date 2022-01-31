import com.tencent.mobileqq.statistics.FDStatsTree;
import com.tencent.mobileqq.statistics.FDStatsTree.ResultObj;
import java.util.Comparator;

public class ahrs
  implements Comparator
{
  public ahrs(FDStatsTree paramFDStatsTree) {}
  
  public int a(FDStatsTree.ResultObj paramResultObj1, FDStatsTree.ResultObj paramResultObj2)
  {
    return paramResultObj2.a - paramResultObj1.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahrs
 * JD-Core Version:    0.7.0.1
 */