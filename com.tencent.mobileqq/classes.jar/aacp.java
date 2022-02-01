import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.network.GetSubscribeFeedListRequest;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeAdFeedItemView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class aacp
  extends aacm
  implements aalt, zwr
{
  private int jdField_a_of_type_Int = ImmersiveUtils.a(4.0F);
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private aacv jdField_a_of_type_Aacv;
  private FolderRecommendTabFragment.FolderRecommendHeadItemView jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = ImmersiveUtils.a(16.0F);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = ImmersiveUtils.a(13.0F);
  private boolean jdField_c_of_type_Boolean = true;
  private int d = ImmersiveUtils.a(3.0F);
  private int e;
  private int f = -1;
  private int g;
  private int h;
  private int i;
  private int j = -1;
  
  public aacp(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  @NotNull
  private FrameLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new TextView(paramViewGroup.getContext());
    FrameLayout localFrameLayout = getCommonHeaderFooterWrapper(paramViewGroup);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    paramViewGroup.setLayoutParams(localLayoutParams);
    paramViewGroup.setTextSize(1, 16.0F);
    paramViewGroup.setMaxLines(1);
    paramViewGroup.setTextColor(Color.parseColor("#222222"));
    paramViewGroup.getPaint().setFakeBoldText(true);
    localLayoutParams.leftMargin = ImmersiveUtils.a(16.0F);
    localLayoutParams.rightMargin = ImmersiveUtils.a(16.0F);
    paramViewGroup.setText(anni.a(2131700313));
    return localFrameLayout;
  }
  
  private boolean a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return paramStFeed.live.liveUin.get() != 0L;
  }
  
  private void d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    aaxb.b(paramStFeed.poster.id.get(), "auth_follow", "press", 0, 0, new String[0]);
    aajj.b(getContext(), paramStFeed.poster.id.get(), new aacr(this, paramStFeed));
  }
  
  public CertifiedAccountMeta.StFeed a()
  {
    if ((getDataList() == null) || (getDataList().size() == 0)) {
      return null;
    }
    int k = this.e + 1;
    while (k < getDataList().size())
    {
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)getDataList().get(k);
      if ((localStFeed != null) && (aaae.a(localStFeed.type.get())))
      {
        this.e = k;
        return localStFeed;
      }
      k += 1;
    }
    return null;
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext())
    {
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)localIterator.next();
      try
      {
        localArrayList.add(new String(localStFeed.toByteArray(), "ISO8859_1"));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    return localArrayList;
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, aaiv paramaaiv, aaiu paramaaiu)
  {
    if (paramStFeed == null) {
      return;
    }
    aaiq.a(getContext(), paramStFeed, paramaaiv, paramaaiu);
  }
  
  public void a(aacv paramaacv)
  {
    this.jdField_a_of_type_Aacv = paramaacv;
  }
  
  public void a(aadb paramaadb, String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    tzo.a(localQQAppInterface, BaseApplicationImpl.getContext(), paramString, new aact(this, paramaadb, localQQAppInterface), false, 0, true);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, ArrayList<String> paramArrayList)
  {
    bleu.a(new blej(paramContext, "subscription", paramString1, paramString2, false, paramArrayList, ""));
  }
  
  public void a(FolderRecommendTabFragment.FolderRecommendHeadItemView paramFolderRecommendHeadItemView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView = paramFolderRecommendHeadItemView;
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    a(paramList, paramStCommonExt, paramBoolean, null);
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean, String paramString)
  {
    this.e = -1;
    b();
    getLoadInfo().a(paramBoolean);
    getLoadInfo().a(paramStCommonExt);
    getLoadInfo().c(paramString);
    setDatas((ArrayList)paramList);
    notifyLoadingComplete(true);
  }
  
  public void b(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    a(paramStFeed);
  }
  
  public void b(aadb paramaadb, String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!tzo.a(localQQAppInterface, paramString)) {
      return;
    }
    tzo.a(localQQAppInterface, BaseApplicationImpl.getContext(), paramString, false, new aacu(this, paramaadb), true);
  }
  
  public void b(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    b(paramList, paramStCommonExt, paramBoolean, null);
  }
  
  public void b(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean, String paramString)
  {
    getLoadInfo().a(paramBoolean);
    getLoadInfo().a(paramStCommonExt);
    getLoadInfo().c(paramString);
    if ((paramList != null) && (paramList.size() > 0)) {
      addAll(paramList);
    }
    notifyLoadingComplete(true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void c(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if ((getDataList() == null) || (getDataList().size() == 0) || (this.e > getDataList().size())) {
      return;
    }
    int k = this.e;
    while (k >= 0)
    {
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)getDataList().get(k);
      if ((localStFeed != null) && (aaae.a(localStFeed.type.get())) && (localStFeed.id.get().equals(paramStFeed.id.get())))
      {
        this.e = k;
        return;
      }
      k -= 1;
    }
    this.e = -1;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public int getItemCount()
  {
    int k;
    if (!this.mHasInitialized) {
      k = 4;
    }
    int m;
    do
    {
      do
      {
        return k;
        m = this.mDataList.size();
        k = m;
      } while (m <= 0);
      k = m;
    } while (!this.jdField_a_of_type_Boolean);
    return m + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRecyclerView = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    int k = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
    if ((this.jdField_a_of_type_Boolean) && ((k == 0) || (k == 1)))
    {
      paramRect.bottom = this.jdField_c_of_type_Int;
      return;
    }
    paramRect.bottom = this.jdField_b_of_type_Int;
  }
  
  public int getItemViewType(int paramInt)
  {
    int k = paramInt;
    if (this.jdField_a_of_type_Boolean) {
      k = paramInt - 1;
    }
    if (k == -1) {
      return 100000;
    }
    if (a((CertifiedAccountMeta.StFeed)getDataList().get(k))) {
      return 100003;
    }
    if ((!bkfj.a(k, getDataList())) && (((CertifiedAccountMeta.StFeed)getDataList().get(k)).type.get() == 4)) {
      return 1;
    }
    return 100002;
  }
  
  public int getSpanCount(int paramInt)
  {
    if (getItemViewType(paramInt) == 100000) {
      return 1;
    }
    return 2;
  }
  
  public String getUniqueKey()
  {
    return "RELATIVE_ADAPTER_UNIQUE_KEY";
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void handleShareDataChange(String paramString, zxs paramzxs)
  {
    super.handleShareDataChange(paramString, paramzxs);
    if ((paramString.equals("share_key_subscribe_feeds_update")) && (paramzxs.jdField_a_of_type_JavaLangObject != null))
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)paramzxs.jdField_a_of_type_JavaLangObject);
      if (paramzxs.jdField_a_of_type_Boolean) {
        onRefreshData();
      }
    }
  }
  
  public void loadData(zxz paramzxz)
  {
    GetSubscribeFeedListRequest localGetSubscribeFeedListRequest;
    if ((this.f != -1) && ((paramzxz.c()) || (paramzxz.d()))) {
      localGetSubscribeFeedListRequest = new GetSubscribeFeedListRequest(this.f, getLoadInfo().b(), getLoadInfo().c(), null);
    }
    for (;;)
    {
      if (localGetSubscribeFeedListRequest == null)
      {
        return;
        if ((this.f != -1) && (paramzxz.e())) {
          localGetSubscribeFeedListRequest = new GetSubscribeFeedListRequest(this.f, getLoadInfo().b(), getLoadInfo().c(), getLoadInfo().d());
        }
      }
      else
      {
        VSNetworkHelper.a().a(localGetSubscribeFeedListRequest, new aacq(this, paramzxz));
        return;
      }
      localGetSubscribeFeedListRequest = null;
    }
  }
  
  public void notifyLoadingComplete(boolean paramBoolean)
  {
    if ((getBlockContainer() != null) && (getBlockMerger() != null))
    {
      getLoadInfo().a(4);
      getBlockContainer().setRefreshing(false);
      if (!isLastPeerBlock()) {
        break label53;
      }
      getBlockMerger().a(paramBoolean, getLoadInfo().a());
    }
    label53:
    while ((getBlockMerger() == null) || (getDataList() == null) || (getDataList().size() != 0)) {
      return;
    }
    getBlockMerger().a(paramBoolean, false);
  }
  
  @SuppressLint({"WrongConstant"})
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int k = paramInt;
    if (this.jdField_a_of_type_Boolean) {
      k = paramInt - 1;
    }
    if (bkfj.a(k, getDataList())) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, k, getItemId(k));
      return;
      CertifiedAccountMeta.StFeed localStFeed;
      if ((paramViewHolder instanceof aadb))
      {
        localStFeed = (CertifiedAccountMeta.StFeed)this.mDataList.get(k);
        ((aadb)paramViewHolder).a(localStFeed);
        ((aadb)paramViewHolder).a((aadb)paramViewHolder, localStFeed);
      }
      else
      {
        localStFeed = (CertifiedAccountMeta.StFeed)getDataList().get(k);
        ((aacw)paramViewHolder).a(localStFeed, getExtraTypeInfo());
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 100000) {
      return new aacw(this, a(paramViewGroup));
    }
    if (paramInt == 1) {
      return new aacw(this, new RelativeAdFeedItemView(paramViewGroup.getContext(), this));
    }
    if (paramInt == 100003) {
      return new aadb(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559643, paramViewGroup, false));
    }
    return new aacw(this, new RelativeFeedItemView(paramViewGroup.getContext()));
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    getParentRecyclerView().addOnScrollListener(new aacs(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacp
 * JD-Core Version:    0.7.0.1
 */