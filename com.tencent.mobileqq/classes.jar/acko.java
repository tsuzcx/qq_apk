import com.tencent.gdtad.api.GdtAd;

public abstract interface acko
{
  public abstract void onAdClicked(GdtAd paramGdtAd);
  
  public abstract void onAdClosed(GdtAd paramGdtAd);
  
  public abstract void onAdFailedToLoad(GdtAd paramGdtAd, ackn paramackn);
  
  public abstract void onAdImpression(GdtAd paramGdtAd);
  
  public abstract void onAdLoaded(GdtAd paramGdtAd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acko
 * JD-Core Version:    0.7.0.1
 */