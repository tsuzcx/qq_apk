import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerEntryItemView;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerFeedItemView;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aaat
  extends RecyclerView.Adapter<aaau>
{
  protected CertifiedAccountMeta.StEntry a;
  private aaas jdField_a_of_type_Aaas;
  protected List<aabw> a;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  protected int a()
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry != null) {
      return 1;
    }
    return 0;
  }
  
  public aaau a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = paramViewGroup.getContext();
    paramViewGroup = new RecyclerView.LayoutParams(bggq.a((Context)localObject, 144.0F), bggq.a((Context)localObject, 213.0F));
    if (paramInt == 3)
    {
      localObject = new RecommendBannerEntryItemView((Context)localObject);
      ((RecommendBannerEntryItemView)localObject).setLayoutParams(paramViewGroup);
      ((RecommendBannerEntryItemView)localObject).setIsCloseShadow(this.jdField_a_of_type_Boolean);
      ((RecommendBannerEntryItemView)localObject).setInNightMode(this.b);
      return new aaau(this, (View)localObject);
    }
    if (paramInt == 1)
    {
      localObject = new RecommendBannerItemView((Context)localObject);
      ((RecommendBannerItemView)localObject).setLayoutParams(paramViewGroup);
      ((RecommendBannerItemView)localObject).setIsCloseShadow(this.jdField_a_of_type_Boolean);
      ((RecommendBannerItemView)localObject).setInNightMode(this.b);
      ((RecommendBannerItemView)localObject).setInNewFolderPage(this.c);
      return new aaau(this, (View)localObject);
    }
    if (paramInt == 2)
    {
      localObject = new RecommendBannerFeedItemView((Context)localObject);
      ((RecommendBannerFeedItemView)localObject).setLayoutParams(paramViewGroup);
      ((RecommendBannerFeedItemView)localObject).setIsCloseShadow(this.jdField_a_of_type_Boolean);
      ((RecommendBannerFeedItemView)localObject).setInNightMode(this.b);
      return new aaau(this, (View)localObject);
    }
    return null;
  }
  
  public List<aabw> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<aabw> paramList)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry = paramStEntry;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(aaas paramaaas)
  {
    this.jdField_a_of_type_Aaas = paramaaas;
  }
  
  public void a(aaau paramaaau)
  {
    super.onViewAttachedToWindow(paramaaau);
    int i = paramaaau.getAdapterPosition() - a();
    if ((!bkfj.a(i, a())) && (a().get(i) != null)) {
      aaxb.a(((aabw)a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.id.get(), "auth_page", "recom_exp", 0, 0, new String[] { "", "", String.valueOf(i), ((aabw)a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.nick.get() });
    }
  }
  
  public void a(aaau paramaaau, int paramInt)
  {
    if (paramaaau == null) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramaaau, paramInt, getItemId(paramInt));
      return;
      if ((paramaaau.itemView instanceof RecommendBannerEntryItemView))
      {
        ((RecommendBannerEntryItemView)paramaaau.itemView).setEntry(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry);
      }
      else
      {
        int i = paramInt - a();
        if ((paramaaau.itemView instanceof RecommendBannerItemView))
        {
          RecommendBannerItemView localRecommendBannerItemView = (RecommendBannerItemView)paramaaau.itemView;
          localRecommendBannerItemView.setData(((aabw)a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser, i);
          localRecommendBannerItemView.setRecommendBannerFolwListener(this.jdField_a_of_type_Aaas);
        }
        else if ((paramaaau.itemView instanceof RecommendBannerFeedItemView))
        {
          ((RecommendBannerFeedItemView)paramaaau.itemView).setData(((aabw)a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, i);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public int getItemCount()
  {
    if (a() == null) {
      return a();
    }
    return a().size() + a();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry != null)) {
      return 3;
    }
    return ((aabw)a().get(paramInt - a())).jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaat
 * JD-Core Version:    0.7.0.1
 */