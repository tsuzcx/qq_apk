import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;

class aann
  implements aaso
{
  aann(aanj paramaanj) {}
  
  public void reportImpression(View paramView)
  {
    paramView = paramView.getTag(2131379969);
    if ((paramView != null) && ((paramView instanceof GdtAd))) {
      aasq.a(((GdtAd)paramView).getUrlForImpression());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aann
 * JD-Core Version:    0.7.0.1
 */