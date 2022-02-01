import com.tencent.mobileqq.data.CommonlyUsedTroop;
import java.util.Comparator;

public class alzf
  implements Comparator<CommonlyUsedTroop>
{
  protected alzf(alzc paramalzc) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzf
 * JD-Core Version:    0.7.0.1
 */