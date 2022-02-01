import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.biz.subscribe.widget.SubscribeFollowInfoView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeVideoHeadItemView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import common.config.service.QzoneConfig;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.List;
import java.util.Stack;

public class aahk
  extends aagi
  implements aamn
{
  public static final int a;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private blsb jdField_a_of_type_Blsb;
  private VideoPlayerView jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
  private SubscribeFollowInfoView jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView;
  private RelativeVideoHeadItemView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private Stack<CertifiedAccountMeta.StFeed> jdField_a_of_type_JavaUtilStack;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = ImmersiveUtils.a();
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = this.jdField_b_of_type_Int * 9 / 16;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  static
  {
    jdField_a_of_type_Int = ImmersiveUtils.b() * 2 / 3;
  }
  
  public aahk(Bundle paramBundle)
  {
    super(paramBundle);
    if (Integer.parseInt(QzoneConfig.getInstance().getConfig("qqsubscribe", "ShowFloatEntrance", "1")) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private float a()
  {
    return this.e / this.d;
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    if (this.e < this.d) {
      return false;
    }
    int[] arrayOfInt;
    if ((getParentRecyclerView() != null) && ((getParentRecyclerView().getLayoutManager() instanceof StaggeredGridLayoutManager)))
    {
      arrayOfInt = new int[getParentRecyclerView().getLayoutManager().getColumnCountForAccessibility(null, null)];
      ((StaggeredGridLayoutManager)getParentRecyclerView().getLayoutManager()).findFirstCompletelyVisibleItemPositions(arrayOfInt);
    }
    for (int m = arrayOfInt[0];; m = 0)
    {
      int n = paramMotionEvent.getAction();
      int i1 = paramMotionEvent.getActionIndex();
      switch (n)
      {
      case 1: 
      default: 
        return false;
      case 0: 
        this.j = ((int)(paramMotionEvent.getX() + 0.5F));
        this.i = ((int)(paramMotionEvent.getY() + 0.5F));
        this.k = MotionEventCompat.findPointerIndex(paramMotionEvent, i1);
        return false;
      }
      i1 = (int)(paramMotionEvent.getX() + 0.5F);
      n = (int)(paramMotionEvent.getY() + 0.5F);
      i1 -= this.j;
      n = (int)((n - this.i) * 0.6F);
      if ((Math.abs(i1) > this.h) && (Math.abs(i1) >= Math.abs(n))) {
        break;
      }
      float f1 = paramMotionEvent.getY() - this.i;
      if ((f1 < 0.0F) && (this.g > this.jdField_c_of_type_Int)) {
        return true;
      }
      if ((f1 <= 0.0F) || (this.g >= this.f) || (m != 0)) {
        break;
      }
      return true;
    }
  }
  
  private CertifiedAccountMeta.StFeed b()
  {
    if ((this.jdField_a_of_type_JavaUtilStack == null) || (this.jdField_a_of_type_JavaUtilStack.empty())) {}
    do
    {
      return null;
      this.jdField_a_of_type_JavaUtilStack.pop();
    } while (this.jdField_a_of_type_JavaUtilStack.empty());
    return (CertifiedAccountMeta.StFeed)this.jdField_a_of_type_JavaUtilStack.pop();
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView = ((VideoPlayerView)paramView.findViewById(2131381249));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370182);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369783);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setWifiAutoPlay(true);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setNeedWifiTips(true);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setHostFragment((SubscribeVideoDetailFragment)getParentFragment());
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.a(false);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.c(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_Blsb = new blsb(getActivity(), new aahr(this, null));
    this.h = ViewConfiguration.get(getActivity()).getScaledTouchSlop();
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setVideoViewCover(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.url.get());
      if ((!this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.video.fileId.get().equals("")) || (!this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.video.playUrl.get().equals(""))) {
        e(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      }
    }
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setExtraTypeInfo(getExtraTypeInfo());
  }
  
  private void e(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (bhsr.a(paramStFeed.video.fileId.get())) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "video fileId is empty");
    }
    do
    {
      return;
      if (bhsr.a(paramStFeed.video.playUrl.get()))
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "video playUrl is empty");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView == null);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setVideoViewCover(paramStFeed.cover.url.get());
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setVideoFeeds(paramStFeed);
  }
  
  private void f(CertifiedAccountMeta.StFeed paramStFeed)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilStack == null) {
      this.jdField_a_of_type_JavaUtilStack = new Stack();
    }
    this.jdField_a_of_type_JavaUtilStack.push(paramStFeed);
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null)
    {
      paramStFeed = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
      if (this.jdField_a_of_type_JavaUtilStack.size() <= 1) {
        break label58;
      }
    }
    for (;;)
    {
      paramStFeed.a(bool);
      return;
      label58:
      bool = false;
    }
  }
  
  private void n()
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new aahl(this));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setPreviewVideoClickListener(new aahm(this));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setNextVideoClickListener(new aahn(this));
    if (a() != null) {
      a().a(new aaho(this));
    }
    getParentRecyclerView().addOnItemTouchListener(new aahp(this));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setOnTouchListener(new aahq(this));
  }
  
  private void o()
  {
    p();
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.a(new int[] { this.jdField_b_of_type_Int, this.f });
      if (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.l())
      {
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.getLayoutParams().height = this.f;
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.requestLayout();
      }
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) {
      return;
    }
    this.d = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.video.width.get();
    this.e = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.video.height.get();
    QLog.i(jdField_a_of_type_JavaLangString, 1, "resetVideoHW width:" + this.d + ", height:" + this.e);
    if (this.d <= 0)
    {
      this.d = 1920;
      this.e = 1080;
    }
    int n = (int)(this.jdField_b_of_type_Int * a());
    int m = n;
    if (n > jdField_a_of_type_Int) {
      m = jdField_a_of_type_Int;
    }
    this.f = m;
    this.g = this.f;
  }
  
  public aagu a()
  {
    return (aagu)getBlockMerger().a("RELATIVE_ADAPTER_UNIQUE_KEY");
  }
  
  protected View a()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, aabp paramaabp)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView = new RelativeVideoHeadItemView(getActivity());
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setAlpha(0.0F);
    }
  }
  
  protected void a(long paramLong, String paramString)
  {
    super.a(paramLong, paramString);
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.k();
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean)
  {
    paramStGetFeedDetailRsp = (CertifiedAccountMeta.StFeed)paramStGetFeedDetailRsp.feed.get();
    if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) && (paramStGetFeedDetailRsp != null) && (aaej.a(paramStGetFeedDetailRsp.type.get())))
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView.setData(paramStGetFeedDetailRsp);
      }
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setData(paramStGetFeedDetailRsp);
      }
      if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (Build.VERSION.SDK_INT > 20) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_b_of_type_Boolean) {
        break label143;
      }
      e(paramStGetFeedDetailRsp);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      return;
      label143:
      QLog.i(jdField_a_of_type_JavaLangString, 1, "has init played");
    }
  }
  
  protected void a(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    paramView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, localLayoutParams);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public View b()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView;
  }
  
  public void b()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onTransAnimateInit disableLoading!");
    e();
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setAlpha(0.0F);
    }
  }
  
  protected void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    super.b(paramStFeed);
    if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.l())) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setVisibility(8);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setAlpha(1.0F);
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView == null) || (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.c());
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setAlpha(1.0F);
    }
  }
  
  public void d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if ((paramStFeed == null) || (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramStFeed == null);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        abbe.a(paramStFeed.poster.id.get(), "auth_" + aapa.a(getExtraTypeInfo()), "clk_recom", 0, 0, new String[] { "", "", paramStFeed.id.get(), paramStFeed.title.get() });
        if (aaej.a(paramStFeed.type.get())) {
          break;
        }
        aaej.a(getActivity(), paramStFeed);
      } while (getActivity() == null);
      getActivity().finish();
      return;
      if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.k();
      }
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
      f(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      o();
      this.jdField_b_of_type_Boolean = false;
      e(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a(paramStFeed);
      setShareData("share_key_subscribe_feeds_update", new aabn(paramStFeed, true));
    } while (getParentRecyclerView() == null);
    getParentRecyclerView().scrollToPosition(0);
  }
  
  public void handleShareDataChange(String paramString, aabn paramaabn)
  {
    if (("share_key_continue_feeds".equals(paramString)) && (paramaabn != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setContinueFeeds((List)paramaabn.a);
    }
  }
  
  public void loadData(aabu paramaabu) {}
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.k())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.onBindViewHolder(paramViewHolder, paramInt);
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView.setData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_JavaUtilStack != null) {
      this.jdField_a_of_type_JavaUtilStack.clear();
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.b();
    }
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    super.onInitBlock(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    if ((!bdgb.b()) && (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(new ColorDrawable(-16777216));
    }
    if (this.jdField_a_of_type_JavaUtilStack == null)
    {
      this.jdField_a_of_type_JavaUtilStack = new Stack();
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
        this.jdField_a_of_type_JavaUtilStack.push(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      }
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView = ((SubscribeFollowInfoView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370126));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setHostActivity(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setExtraTypeInfo(getExtraTypeInfo());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369135));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369359));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369420));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369203));
    if (getActivity() != null)
    {
      LiuHaiUtils.a(getActivity());
      LiuHaiUtils.enableNotch(getActivity());
    }
    if ((Build.VERSION.SDK_INT <= 20) || (!this.jdField_a_of_type_Boolean)) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    b(this.jdField_a_of_type_AndroidViewViewGroup);
    o();
    n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahk
 * JD-Core Version:    0.7.0.1
 */