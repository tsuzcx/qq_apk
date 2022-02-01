import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFollowRcmd;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView;

class aagf
  extends RecyclerView.ViewHolder
{
  public aagf(aagd paramaagd, View paramView)
  {
    super(paramView);
  }
  
  public void a(CertifiedAccountMeta.StFollowRcmd paramStFollowRcmd, int paramInt)
  {
    if ((this.itemView instanceof BlankRecommendItemView))
    {
      ((BlankRecommendItemView)this.itemView).setData(paramStFollowRcmd);
      ((BlankRecommendItemView)this.itemView).setExtraTypeInfo(this.a.getExtraTypeInfo());
      ((BlankRecommendItemView)this.itemView).setPos(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aagf
 * JD-Core Version:    0.7.0.1
 */