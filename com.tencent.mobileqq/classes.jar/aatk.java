import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.qphone.base.util.QLog;

public class aatk
  implements acko
{
  public aatk(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void onAdClicked(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdClicked");
  }
  
  public void onAdClosed(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdClosed");
  }
  
  public void onAdFailedToLoad(GdtAd paramGdtAd, ackn paramackn)
  {
    QLog.e("TroopGiftPanel", 1, "onAdFailedToLoad: " + paramackn.a());
  }
  
  public void onAdImpression(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdImpression");
  }
  
  public void onAdLoaded(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdLoaded");
    TroopGiftPanel.a(this.a, paramGdtAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aatk
 * JD-Core Version:    0.7.0.1
 */