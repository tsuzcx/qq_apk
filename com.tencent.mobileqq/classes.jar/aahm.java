import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aahm
  implements View.OnClickListener
{
  aahm(aahk paramaahk) {}
  
  public void onClick(View paramView)
  {
    if (!aagi.b())
    {
      CertifiedAccountMeta.StFeed localStFeed = aahk.a(this.a);
      if (localStFeed != null)
      {
        this.a.d(localStFeed);
        if (this.a.a() != null) {
          this.a.a().c(localStFeed);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahm
 * JD-Core Version:    0.7.0.1
 */