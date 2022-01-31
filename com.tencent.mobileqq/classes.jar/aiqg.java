import com.tencent.mobileqq.data.TroopInfo;
import java.util.Comparator;

public class aiqg
  implements Comparator<TroopInfo>
{
  public int a(TroopInfo paramTroopInfo1, TroopInfo paramTroopInfo2)
  {
    if (paramTroopInfo1.lastMsgTime > paramTroopInfo2.lastMsgTime) {
      return -1;
    }
    if (paramTroopInfo1.lastMsgTime < paramTroopInfo2.lastMsgTime) {
      return 1;
    }
    return ajuj.a(paramTroopInfo1.mComparePartInt, paramTroopInfo1.mCompareSpell, paramTroopInfo2.mComparePartInt, paramTroopInfo2.mCompareSpell);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aiqg
 * JD-Core Version:    0.7.0.1
 */