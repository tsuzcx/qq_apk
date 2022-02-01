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

public class aaey
  extends RecyclerView.Adapter<aaez>
{
  protected CertifiedAccountMeta.StEntry a;
  private aaex jdField_a_of_type_Aaex;
  protected List<aagb> a;
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
  
  public aaez a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = paramViewGroup.getContext();
    paramViewGroup = new RecyclerView.LayoutParams(bhgr.a((Context)localObject, 144.0F), bhgr.a((Context)localObject, 213.0F));
    if (paramInt == 3)
    {
      localObject = new RecommendBannerEntryItemView((Context)localObject);
      ((RecommendBannerEntryItemView)localObject).setLayoutParams(paramViewGroup);
      ((RecommendBannerEntryItemView)localObject).setIsCloseShadow(this.jdField_a_of_type_Boolean);
      ((RecommendBannerEntryItemView)localObject).setInNightMode(this.b);
      return new aaez(this, (View)localObject);
    }
    if (paramInt == 1)
    {
      localObject = new RecommendBannerItemView((Context)localObject);
      ((RecommendBannerItemView)localObject).setLayoutParams(paramViewGroup);
      ((RecommendBannerItemView)localObject).setIsCloseShadow(this.jdField_a_of_type_Boolean);
      ((RecommendBannerItemView)localObject).setInNightMode(this.b);
      ((RecommendBannerItemView)localObject).setInNewFolderPage(this.c);
      return new aaez(this, (View)localObject);
    }
    if (paramInt == 2)
    {
      localObject = new RecommendBannerFeedItemView((Context)localObject);
      ((RecommendBannerFeedItemView)localObject).setLayoutParams(paramViewGroup);
      ((RecommendBannerFeedItemView)localObject).setIsCloseShadow(this.jdField_a_of_type_Boolean);
      ((RecommendBannerFeedItemView)localObject).setInNightMode(this.b);
      return new aaez(this, (View)localObject);
    }
    return null;
  }
  
  public List<aagb> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<aagb> paramList)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry = paramStEntry;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(aaex paramaaex)
  {
    this.jdField_a_of_type_Aaex = paramaaex;
  }
  
  public void a(aaez paramaaez)
  {
    super.onViewAttachedToWindow(paramaaez);
    int i = paramaaez.getAdapterPosition() - a();
    if ((!blgn.a(i, a())) && (a().get(i) != null)) {
      abbe.a(((aagb)a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.id.get(), "auth_page", "recom_exp", 0, 0, new String[] { "", "", String.valueOf(i), ((aagb)a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.nick.get() });
    }
  }
  
  public void a(aaez paramaaez, int paramInt)
  {
    if (paramaaez == null) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramaaez, paramInt, getItemId(paramInt));
      return;
      if ((paramaaez.itemView instanceof RecommendBannerEntryItemView))
      {
        ((RecommendBannerEntryItemView)paramaaez.itemView).setEntry(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry);
      }
      else
      {
        int i = paramInt - a();
        if ((paramaaez.itemView instanceof RecommendBannerItemView))
        {
          RecommendBannerItemView localRecommendBannerItemView = (RecommendBannerItemView)paramaaez.itemView;
          localRecommendBannerItemView.setData(((aagb)a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser, i);
          localRecommendBannerItemView.setRecommendBannerFolwListener(this.jdField_a_of_type_Aaex);
        }
        else if ((paramaaez.itemView instanceof RecommendBannerFeedItemView))
        {
          ((RecommendBannerFeedItemView)paramaaez.itemView).setData(((aagb)a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, i);
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
    return ((aagb)a().get(paramInt - a())).jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaey
 * JD-Core Version:    0.7.0.1
 */