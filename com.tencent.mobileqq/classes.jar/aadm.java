import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aadm
  implements View.OnClickListener
{
  aadm(aadj paramaadj) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a() != null)
    {
      CertifiedAccountMeta.StFeed localStFeed = this.a.a().a();
      if (localStFeed == null) {
        break label41;
      }
      this.a.d(localStFeed);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label41:
      QQToast.a(aadj.a(this.a), 1, anni.a(2131713344), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadm
 * JD-Core Version:    0.7.0.1
 */