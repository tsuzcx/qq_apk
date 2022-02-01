import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aadl
  implements View.OnClickListener
{
  aadl(aadj paramaadj) {}
  
  public void onClick(View paramView)
  {
    if (!aacd.a())
    {
      CertifiedAccountMeta.StFeed localStFeed = aadj.a(this.a);
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
 * Qualified Name:     aadl
 * JD-Core Version:    0.7.0.1
 */