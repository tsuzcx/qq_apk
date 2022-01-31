import com.tencent.mobileqq.data.CommonlyUsedTroop;
import java.util.Comparator;

public class ahtf
  implements Comparator<CommonlyUsedTroop>
{
  protected ahtf(ahtc paramahtc) {}
  
  public int a(CommonlyUsedTroop paramCommonlyUsedTroop1, CommonlyUsedTroop paramCommonlyUsedTroop2)
  {
    if (paramCommonlyUsedTroop1.addedTimestamp < paramCommonlyUsedTroop2.addedTimestamp) {
      return 1;
    }
    if (paramCommonlyUsedTroop1.addedTimestamp > paramCommonlyUsedTroop2.addedTimestamp) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahtf
 * JD-Core Version:    0.7.0.1
 */