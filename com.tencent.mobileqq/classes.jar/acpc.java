import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.GdtReporter;

class acpc
  implements acri
{
  acpc(acow paramacow) {}
  
  public void reportImpression(View paramView)
  {
    paramView = paramView.getTag(2131380927);
    if ((paramView != null) && ((paramView instanceof GdtAd)))
    {
      paramView = (GdtAd)paramView;
      GdtReporter.doCgiReport(new acnt().a(paramView.getUrlForImpression()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpc
 * JD-Core Version:    0.7.0.1
 */