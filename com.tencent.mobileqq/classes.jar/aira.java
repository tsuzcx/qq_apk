import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectConfig;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectConfig.GrayTipsConfig;
import java.util.Comparator;

public class aira
  implements Comparator
{
  public aira(TroopEnterEffectConfig paramTroopEnterEffectConfig) {}
  
  public int a(TroopEnterEffectConfig.GrayTipsConfig paramGrayTipsConfig1, TroopEnterEffectConfig.GrayTipsConfig paramGrayTipsConfig2)
  {
    return paramGrayTipsConfig2.b - paramGrayTipsConfig1.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aira
 * JD-Core Version:    0.7.0.1
 */