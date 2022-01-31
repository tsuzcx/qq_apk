import com.tencent.mobileqq.statistics.FDStatsTree;
import com.tencent.mobileqq.statistics.FDStatsTree.ResultObj;
import java.util.Comparator;

public class aifv
  implements Comparator
{
  public aifv(FDStatsTree paramFDStatsTree) {}
  
  public int a(FDStatsTree.ResultObj paramResultObj1, FDStatsTree.ResultObj paramResultObj2)
  {
    return paramResultObj2.a - paramResultObj1.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifv
 * JD-Core Version:    0.7.0.1
 */