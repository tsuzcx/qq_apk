package com.tencent.mm.plugin.sns.ui.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b;
import com.tencent.mm.plugin.sns.ad.widget.countdown.PromotionBarLayout;
import com.tencent.mm.plugin.sns.ad.widget.living.FinderLivingAnimWrapper;
import com.tencent.mm.plugin.sns.ad.widget.living.LivingDescBarLayout;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.c;
import com.tencent.mm.plugin.sns.storage.ADXml.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.az;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.List;

public final class c
  extends b
{
  private c.b JHi;
  private ViewGroup JKI;
  private ViewStub JKJ;
  FinderLivingAnimWrapper JKK;
  public ViewGroup JKL;
  private Handler JMp;
  com.tencent.mm.plugin.sns.ad.f.l KPn;
  public TextView LiY;
  public TextView LiZ;
  public View Lja;
  public Button Ljb;
  public Button Ljc;
  public View Ljd;
  public ImageView Lje;
  public MaskImageView Ljf;
  public SnsCardAdTagListView Ljg;
  public View Ljh;
  public View Lji;
  public View Ljj;
  public View Ljk;
  private PromotionBarLayout Ljl;
  private int Ljm;
  private ax Ljn;
  private az Ljo;
  private LivingDescBarLayout Ljp;
  private com.tencent.mm.plugin.sns.ad.widget.living.c Ljq;
  public SnsTimelineVideoView Ljr;
  public boolean Ljs;
  boolean Ljt;
  Context context;
  public String fAg;
  private com.tencent.mm.ui.widget.b.a szq;
  
  public c(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ui.d.c paramc, com.tencent.mm.plugin.sns.ad.f.l paraml)
  {
    AppMethodBeat.i(269101);
    this.JMp = new Handler(Looper.getMainLooper());
    this.JHi = new c.b()
    {
      public final void fLc()
      {
        AppMethodBeat.i(233285);
        c.this.JIp.a(c.this, null);
        AppMethodBeat.o(233285);
      }
      
      public final ViewGroup fLd()
      {
        return null;
      }
    };
    this.Ljt = false;
    this.timeLineObject = paramTimeLineObject;
    this.Jzk = paramSnsInfo;
    this.JIp = paramc;
    this.KPn = paraml;
    this.fAg = paramSnsInfo.getLocalid();
    AppMethodBeat.o(269101);
  }
  
  private void ab(SnsInfo paramSnsInfo)
  {
    int j = 0;
    AppMethodBeat.i(100011);
    if ((paramSnsInfo == null) || (!paramSnsInfo.isCardAd()))
    {
      AppMethodBeat.o(100011);
      return;
    }
    int k = this.context.getResources().getColor(i.c.blue_text_color);
    int m = this.context.getResources().getColor(i.c.BW_0_Alpha_0_2);
    if ((this.Ljb == null) || (this.Ljc == null))
    {
      AppMethodBeat.o(100011);
      return;
    }
    this.Ljb.setOnClickListener(this.JIp.Lpz);
    this.Ljc.setOnClickListener(this.JIp.LpA);
    int n;
    int i;
    if (paramSnsInfo.getAdXml().hasVoteInfo())
    {
      n = y.lj(paramSnsInfo.getAdXml().adVoteInfo.Kkg, paramSnsInfo.getUxinfo());
      if ((n > 0) && (n <= 2)) {
        if (n == 1)
        {
          this.Ljc.setTextColor(m);
          this.Ljc.setText(paramSnsInfo.getAdXml().adVoteInfo.agj(1));
          this.Ljb.setTextColor(k);
          this.Ljb.setText(paramSnsInfo.getAdXml().adVoteInfo.agi(0));
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.Ljb.setTextColor(k);
        this.Ljc.setTextColor(k);
        this.Ljb.setText(paramSnsInfo.getAdXml().getCardSelectLeftTitle());
        this.Ljc.setText(paramSnsInfo.getAdXml().getCardSelectRightTitle());
      }
      AppMethodBeat.o(100011);
      return;
      i = j;
      if (n == 2)
      {
        this.Ljb.setTextColor(m);
        this.Ljb.setText(paramSnsInfo.getAdXml().adVoteInfo.agj(0));
        this.Ljc.setTextColor(k);
        this.Ljc.setText(paramSnsInfo.getAdXml().adVoteInfo.agi(1));
        i = j;
        continue;
        i = 1;
      }
    }
  }
  
  public final boolean fYu()
  {
    return (this.timeLineObject.ContentObj.Sqq == 5) || (this.timeLineObject.ContentObj.Sqq == 15);
  }
  
  public final void n(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100009);
    this.contentView = paramView1;
    this.context = paramView1.getContext();
    this.KON = paramView2;
    this.Lji = this.contentView.findViewById(i.f.media_container);
    if ((this.Lji instanceof RoundedCornerFrameLayout)) {
      ((RoundedCornerFrameLayout)this.Lji).setRadius(com.tencent.mm.ci.a.fromDPToPix(this.context, 4));
    }
    this.Ljj = this.contentView.findViewById(i.f.other_container);
    this.Lja = this.contentView.findViewById(i.f.card_btn_container);
    this.Lja.setVisibility(8);
    this.Ljd = this.contentView.findViewById(i.f.card_weapp_tag);
    this.Lje = ((ImageView)this.contentView.findViewById(i.f.weapp_auth_icon_iv));
    this.Ljd.setVisibility(8);
    this.Ljf = ((MaskImageView)this.contentView.findViewById(i.f.sns_card_ad_image));
    this.Ljb = ((Button)this.contentView.findViewById(i.f.card_btn_left));
    this.Ljc = ((Button)this.contentView.findViewById(i.f.card_btn_right));
    this.Ljk = this.contentView.findViewById(i.f.action_btn_container);
    this.JKL = ((ViewGroup)this.contentView.findViewById(i.f.sns_card_ad_online_video_container));
    this.Lje.setTag("");
    if (this.Lje.getVisibility() == 0) {
      this.Lje.setVisibility(4);
    }
    paramView2 = (TextView)this.contentView.findViewById(i.f.weapp_tag_name);
    Object localObject = this.Jzk.getAdInfo();
    if ((localObject != null) && (((ADInfo)localObject).isWeapp()) && (!this.Jzk.isTurnCardAd()))
    {
      this.Ljd.setVisibility(0);
      paramView2.setText(i.j.sns_ad_card_weapp_tag);
      com.tencent.mm.plugin.sns.ad.d.g.f(((ADInfo)localObject).actionExtWeApp.appUserName, this.Lje);
      if (this.Ljd.getVisibility() == 0)
      {
        paramView2 = (ImageView)this.contentView.findViewById(i.f.weapp_icon_iv);
        if (!ar.isDarkMode()) {
          break label1612;
        }
        if (!com.tencent.mm.plugin.sns.ad.d.l.a(this.Jzk.getAdXml(), this.Jzk.getAdInfo())) {
          break label1592;
        }
        paramView2.setImageResource(i.i.album_ad_finder_link_dark_icon);
      }
      label382:
      this.LiZ = ((TextView)this.contentView.findViewById(i.f.desc_collapse_pic_style_tv));
      this.LiZ.setClickable(false);
      this.LiZ.setLongClickable(false);
      this.Ljs = com.tencent.mm.plugin.sns.ad.timeline.b.b.b(this.timeLineObject, this.Jzk.getAdXml());
      localObject = new StringBuilder("card ad detail useOnlineVideo=").append(this.Ljs).append(", snsId=");
      if (this.timeLineObject != null) {
        break label1662;
      }
      paramView2 = "";
      label468:
      Log.i("MicroMsg.CardAdDetailItemView", paramView2);
      paramView2 = (WindowManager)this.context.getSystemService("window");
      this.Ljm = (Math.min(paramView2.getDefaultDisplay().getWidth(), paramView2.getDefaultDisplay().getHeight()) - com.tencent.mm.ci.a.aY(this.context, i.d.sns_avatar_size) - com.tencent.mm.ci.a.aY(this.context, i.d.Edge_0_5_A) - this.context.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.context.getResources().getDimensionPixelSize(i.d.NormalPadding));
      paramView2 = (ViewGroup.MarginLayoutParams)this.contentView.getLayoutParams();
      paramView2.topMargin = this.context.getResources().getDimensionPixelOffset(i.d.MiddlePadding);
      paramView2.bottomMargin = 0;
      paramView2.width = this.Ljm;
      paramView2.height = -2;
      this.contentView.setLayoutParams(paramView2);
      this.contentView.setBackground(this.context.getResources().getDrawable(i.e.sns_ad_pic_style_bg));
      this.LiY = ((TextView)this.contentView.findViewById(i.f.desc_collapse_pic_style_title_tv));
      this.LiY.setClickable(false);
      this.LiY.setLongClickable(false);
      if (Util.isNullOrNil(this.Jzk.getAdXml().adCardTitle)) {
        break label1673;
      }
      paramView2 = com.tencent.mm.cl.h.htZ().a(this.LiY.getContext(), this.Jzk.getAdXml().adCardTitle, this.LiY.getTextSize());
      this.LiY.setText(paramView2);
      this.LiY.setVisibility(0);
      label742:
      if (!Util.isNullOrNil(this.Jzk.getAdXml().adCardDesc)) {
        break label1685;
      }
      paramView2 = this.timeLineObject.ContentDesc;
      label766:
      if (Util.isNullOrNil(paramView2)) {
        break label1699;
      }
      paramView2 = com.tencent.mm.cl.h.htZ().a(this.LiZ.getContext(), paramView2, this.LiZ.getTextSize());
      this.LiZ.setText(paramView2);
      this.LiZ.setVisibility(0);
      label811:
      this.szq = new com.tencent.mm.ui.widget.b.a(this.context);
      this.szq.c(this.contentView, this.JIp.Lph, this.JIp.LoP);
      if ((!this.Jzk.getAdXml().hasSelectInfo()) && (!this.Jzk.getAdXml().hasVoteInfo())) {
        break label1744;
      }
      if (!this.Jzk.getAdXml().isNewStyleVote()) {
        break label1711;
      }
      if (this.Ljo == null)
      {
        paramView2 = (ViewStub)this.contentView.findViewById(i.f.sns_ad_card_vote_layout_stub);
        if ((paramView2 != null) && (com.tencent.mm.plugin.sns.ad.i.l.c(paramView2) != null)) {
          this.Ljo = new az(this.context, this.contentView, this.JIp);
        }
      }
      if (this.Ljo != null)
      {
        this.Ljo.a(this.Jzk, this);
        this.Ljo.fUW();
      }
      this.Lja.setVisibility(8);
      if (this.LiY != null) {
        this.LiY.setVisibility(8);
      }
      if (this.LiZ != null) {
        this.LiZ.setVisibility(8);
      }
      label1012:
      this.JKG = new av();
      this.JKG.KKm = this.contentView.findViewById(i.f.sns_card_ad_sight);
      this.JKG.KKj = this.JKG.KKm;
      this.JKG.KKm.setOnClickListener(this.JIp.Lpo);
      this.JKG.KKk = ((VideoSightView)this.JKG.KKm.findViewById(i.f.image));
      this.JKG.KKk.setMute(true);
      this.JKG.JAL = ((ImageView)this.JKG.KKm.findViewById(i.f.status_btn));
      this.JKG.KKn = ((MMPinProgressBtn)this.JKG.KKm.findViewById(i.f.progress));
      this.JKG.KKo = ((TextView)this.JKG.KKm.findViewById(i.f.endtv));
      this.JKG.Ktc = ((TextView)this.JKG.KKm.findViewById(i.f.errorTv));
      this.Ljh = this.contentView.findViewById(i.f.sns_ad_card_header_container);
      this.Ljg = ((SnsCardAdTagListView)this.contentView.findViewById(i.f.card_ad_tag_list));
      this.Ljg.setActivityContext((Activity)this.context);
    }
    for (;;)
    {
      try
      {
        paramView2 = this.Jzk.getSnsId();
        if (com.tencent.mm.plugin.sns.ui.widget.b.lo(this.Ljg.getOriginSnsId(), paramView2)) {
          continue;
        }
        this.Ljg.removeAllViews();
        if (this.Jzk.getAdXml().adCardTagInfo.Kjx.size() > 0)
        {
          this.Ljg.setVisibility(0);
          this.Ljg.setTagSpace(com.tencent.mm.ci.a.fromDPToPix(this.context, 8));
          this.Ljg.hX(this.Jzk.getAdXml().adCardTagInfo.Kjx);
        }
        this.Ljg.setOriginSnsId(paramView2);
      }
      catch (Exception paramView2)
      {
        label1592:
        label1612:
        label1662:
        Log.e("MicroMsg.CardAdDetailItemView", paramView2.toString());
        label1673:
        label1685:
        label1699:
        label1711:
        label1744:
        continue;
      }
      if (!Util.isNullOrNil(this.Jzk.getAdXml().adCard3dHeadTitle))
      {
        this.Ljh.setVisibility(0);
        this.Ljh.findViewById(i.f.sns_ad_card_header_title).setVisibility(0);
        ((TextView)this.Ljh.findViewById(i.f.sns_ad_card_header_title)).setText(this.Jzk.getAdXml().adCard3dHeadTitle);
      }
      if (!Util.isNullOrNil(this.Jzk.getAdXml().adCard3dHeadUrl)) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(this.Jzk.getAdXml().adCard3dHeadUrl, false, new f.a()
        {
          public final void aYs(String paramAnonymousString)
          {
            AppMethodBeat.i(270735);
            if (!Util.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString, null);
              if (paramAnonymousString != null)
              {
                c.this.Ljh.setVisibility(0);
                ImageView localImageView = (ImageView)c.this.Ljh.findViewById(i.f.sns_ad_card_header_avatar);
                localImageView.setImageBitmap(paramAnonymousString);
                localImageView.setVisibility(0);
              }
            }
            AppMethodBeat.o(270735);
          }
          
          public final void fJU() {}
          
          public final void fJV() {}
        });
      }
      this.szq.c(this.contentView, this.JIp.Lph, this.JIp.LoP);
      this.Ljf.setVisibility(8);
      this.Ljf.setScaleType(QImageView.a.Ydm);
      this.JKG.KKj.setVisibility(8);
      this.JKG.KKk.Jte = true;
      this.JKG.KKk.setScaleType(QImageView.a.Ydm);
      this.contentView.setOnClickListener(this.JIp.LpB);
      this.JKJ = ((ViewStub)paramView1.findViewById(i.f.ad_live_anim_layout_stub));
      AppMethodBeat.o(100009);
      return;
      if (!com.tencent.mm.plugin.sns.ad.d.l.a(this.Jzk.getAdXml(), (ADInfo)localObject)) {
        break;
      }
      this.Ljd.setVisibility(0);
      paramView2.setText(i.j.finder_app_name);
      break;
      paramView2.setImageResource(i.i.album_ad_link_tag_weapp_dark);
      this.Lje.setImageResource(i.e.ad_weapp_auth_dark_icon);
      break label382;
      if (com.tencent.mm.plugin.sns.ad.d.l.a(this.Jzk.getAdXml(), this.Jzk.getAdInfo()))
      {
        paramView2.setImageResource(i.i.album_ad_finder_link_icon);
        break label382;
      }
      paramView2.setImageResource(i.i.album_ad_link_tag_weapp);
      this.Lje.setImageResource(i.e.ad_weapp_auth_icon);
      break label382;
      paramView2 = this.timeLineObject.Id;
      break label468;
      this.LiY.setVisibility(8);
      break label742;
      paramView2 = this.Jzk.getAdXml().adCardDesc;
      break label766;
      this.LiZ.setVisibility(8);
      break label811;
      this.Lja.setVisibility(0);
      if (this.Ljo != null) {
        this.Ljo.fUX();
      }
      ab(this.Jzk);
      break label1012;
      this.Lja.setVisibility(8);
      if (this.Ljo == null) {
        break label1012;
      }
      this.Ljo.fUX();
      break label1012;
      if (this.Jzk.getAdXml().adCardTagInfo.Kjx.size() > 0) {
        this.Ljg.setVisibility(0);
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(269102);
    try
    {
      Log.i("MicroMsg.CardAdDetailItemView", "onPause, hasPlayedVideo=" + this.Ljt + ", useOnlineVideo=" + this.Ljs);
      if ((this.Ljt) && (this.JKG != null) && (this.JKG.KKk != null))
      {
        if (!this.Ljs) {
          break label125;
        }
        if (this.Ljr != null) {
          this.Ljr.dmi();
        }
      }
      for (;;)
      {
        if ((this.KPn != null) && (this.Jzk != null)) {
          this.KPn.Qn(this.Jzk.field_snsId);
        }
        AppMethodBeat.o(269102);
        return;
        label125:
        this.JKG.KKk.pause();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.CardAdDetailItemView", "onPause, exp=" + localThrowable.toString());
      AppMethodBeat.o(269102);
    }
  }
  
  /* Error */
  public final void refreshView()
  {
    // Byte code:
    //   0: ldc_w 838
    //   3: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_0
    //   8: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   11: invokevirtual 697	com/tencent/mm/plugin/sns/storage/SnsInfo:getSnsId	()Ljava/lang/String;
    //   14: invokestatic 844	com/tencent/mm/plugin/sns/storage/f:bbk	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   17: putfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   20: ldc_w 439
    //   23: ldc_w 845
    //   26: invokestatic 447	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   33: invokevirtual 183	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   36: invokevirtual 591	com/tencent/mm/plugin/sns/storage/ADXml:hasSelectInfo	()Z
    //   39: ifne +16 -> 55
    //   42: aload_0
    //   43: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   46: invokevirtual 183	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   49: invokevirtual 188	com/tencent/mm/plugin/sns/storage/ADXml:hasVoteInfo	()Z
    //   52: ifeq +35 -> 87
    //   55: aload_0
    //   56: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   59: invokevirtual 183	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   62: invokevirtual 594	com/tencent/mm/plugin/sns/storage/ADXml:isNewStyleVote	()Z
    //   65: ifeq +727 -> 792
    //   68: aload_0
    //   69: getfield 596	com/tencent/mm/plugin/sns/ui/c/a/c:Ljo	Lcom/tencent/mm/plugin/sns/ui/az;
    //   72: ifnull +15 -> 87
    //   75: aload_0
    //   76: getfield 596	com/tencent/mm/plugin/sns/ui/c/a/c:Ljo	Lcom/tencent/mm/plugin/sns/ui/az;
    //   79: aload_0
    //   80: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   83: aload_0
    //   84: invokevirtual 614	com/tencent/mm/plugin/sns/ui/az:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Ljava/lang/Object;)V
    //   87: aload_0
    //   88: getfield 624	com/tencent/mm/plugin/sns/ui/c/a/c:JKG	Lcom/tencent/mm/plugin/sns/ui/av;
    //   91: getfield 676	com/tencent/mm/plugin/sns/ui/av:Ktc	Landroid/widget/TextView;
    //   94: bipush 8
    //   96: invokevirtual 563	android/widget/TextView:setVisibility	(I)V
    //   99: aload_0
    //   100: iconst_0
    //   101: putfield 105	com/tencent/mm/plugin/sns/ui/c/a/c:Ljt	Z
    //   104: invokestatic 851	com/tencent/mm/plugin/sns/model/aj:fOF	()Lcom/tencent/mm/plugin/sns/model/g;
    //   107: astore 7
    //   109: aload_0
    //   110: getfield 109	com/tencent/mm/plugin/sns/ui/c/a/c:timeLineObject	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   113: getfield 233	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adw;
    //   116: ifnull +687 -> 803
    //   119: aload_0
    //   120: getfield 109	com/tencent/mm/plugin/sns/ui/c/a/c:timeLineObject	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   123: getfield 233	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adw;
    //   126: getfield 855	com/tencent/mm/protocal/protobuf/adw:Sqr	Ljava/util/LinkedList;
    //   129: invokevirtual 858	java/util/LinkedList:size	()I
    //   132: ifle +671 -> 803
    //   135: aload_0
    //   136: getfield 109	com/tencent/mm/plugin/sns/ui/c/a/c:timeLineObject	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   139: getfield 233	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adw;
    //   142: getfield 855	com/tencent/mm/protocal/protobuf/adw:Sqr	Ljava/util/LinkedList;
    //   145: iconst_0
    //   146: invokevirtual 862	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   149: checkcast 864	com/tencent/mm/protocal/protobuf/cvt
    //   152: astore 6
    //   154: aload_0
    //   155: getfield 140	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   158: ldc_w 449
    //   161: invokevirtual 453	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   164: checkcast 455	android/view/WindowManager
    //   167: invokeinterface 459 1 0
    //   172: invokevirtual 464	android/view/Display:getWidth	()I
    //   175: pop
    //   176: aload 6
    //   178: ifnull +2531 -> 2709
    //   181: aload_0
    //   182: getfield 492	com/tencent/mm/plugin/sns/ui/c/a/c:Ljm	I
    //   185: aload_0
    //   186: getfield 140	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   189: invokevirtual 146	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   192: getstatic 867	com/tencent/mm/plugin/sns/i$d:SmallPadding	I
    //   195: invokevirtual 490	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   198: isub
    //   199: aload_0
    //   200: getfield 140	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   203: invokevirtual 146	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   206: getstatic 867	com/tencent/mm/plugin/sns/i$d:SmallPadding	I
    //   209: invokevirtual 490	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   212: isub
    //   213: istore_1
    //   214: iload_1
    //   215: i2f
    //   216: aload 6
    //   218: getfield 871	com/tencent/mm/protocal/protobuf/cvt:TDH	Lcom/tencent/mm/protocal/protobuf/cvv;
    //   221: getfield 877	com/tencent/mm/protocal/protobuf/cvv:TEv	F
    //   224: fmul
    //   225: aload 6
    //   227: getfield 871	com/tencent/mm/protocal/protobuf/cvt:TDH	Lcom/tencent/mm/protocal/protobuf/cvv;
    //   230: getfield 880	com/tencent/mm/protocal/protobuf/cvv:TEu	F
    //   233: fdiv
    //   234: f2i
    //   235: istore_2
    //   236: aload_0
    //   237: getfield 109	com/tencent/mm/plugin/sns/ui/c/a/c:timeLineObject	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   240: getfield 233	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adw;
    //   243: getfield 238	com/tencent/mm/protocal/protobuf/adw:Sqq	I
    //   246: iconst_1
    //   247: if_icmpne +562 -> 809
    //   250: aload_0
    //   251: getfield 310	com/tencent/mm/plugin/sns/ui/c/a/c:Ljf	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
    //   254: invokevirtual 881	com/tencent/mm/plugin/sns/ui/MaskImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   257: astore 7
    //   259: aload 7
    //   261: iload_1
    //   262: putfield 884	android/view/ViewGroup$LayoutParams:width	I
    //   265: aload 7
    //   267: iload_2
    //   268: putfield 885	android/view/ViewGroup$LayoutParams:height	I
    //   271: aload_0
    //   272: getfield 310	com/tencent/mm/plugin/sns/ui/c/a/c:Ljf	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
    //   275: aload 7
    //   277: invokevirtual 886	com/tencent/mm/plugin/sns/ui/MaskImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   280: invokestatic 851	com/tencent/mm/plugin/sns/model/aj:fOF	()Lcom/tencent/mm/plugin/sns/model/g;
    //   283: aload 6
    //   285: aload_0
    //   286: getfield 310	com/tencent/mm/plugin/sns/ui/c/a/c:Ljf	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
    //   289: iconst_m1
    //   290: aload_0
    //   291: getfield 140	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   294: invokevirtual 891	java/lang/Object:hashCode	()I
    //   297: getstatic 897	com/tencent/mm/storage/bp:VGo	Lcom/tencent/mm/storage/bp;
    //   300: invokevirtual 902	com/tencent/mm/plugin/sns/model/g:b	(Lcom/tencent/mm/protocal/protobuf/cvt;Landroid/view/View;IILcom/tencent/mm/storage/bp;)Z
    //   303: pop
    //   304: aload_0
    //   305: getfield 310	com/tencent/mm/plugin/sns/ui/c/a/c:Ljf	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
    //   308: iconst_0
    //   309: invokevirtual 751	com/tencent/mm/plugin/sns/ui/MaskImageView:setVisibility	(I)V
    //   312: aload_0
    //   313: getfield 310	com/tencent/mm/plugin/sns/ui/c/a/c:Ljf	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
    //   316: aload_0
    //   317: invokevirtual 903	com/tencent/mm/plugin/sns/ui/MaskImageView:setTag	(Ljava/lang/Object;)V
    //   320: aload_0
    //   321: getfield 246	com/tencent/mm/plugin/sns/ui/c/a/c:contentView	Landroid/view/View;
    //   324: aload_0
    //   325: invokevirtual 904	android/view/View:setTag	(Ljava/lang/Object;)V
    //   328: aload_0
    //   329: getfield 162	com/tencent/mm/plugin/sns/ui/c/a/c:Ljb	Landroid/widget/Button;
    //   332: aload_0
    //   333: invokevirtual 905	android/widget/Button:setTag	(Ljava/lang/Object;)V
    //   336: aload_0
    //   337: getfield 164	com/tencent/mm/plugin/sns/ui/c/a/c:Ljc	Landroid/widget/Button;
    //   340: aload_0
    //   341: invokevirtual 905	android/widget/Button:setTag	(Ljava/lang/Object;)V
    //   344: aload_0
    //   345: getfield 310	com/tencent/mm/plugin/sns/ui/c/a/c:Ljf	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
    //   348: aload_0
    //   349: getfield 117	com/tencent/mm/plugin/sns/ui/c/a/c:JIp	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   352: getfield 908	com/tencent/mm/plugin/sns/ui/d/c:KEA	Landroid/view/View$OnClickListener;
    //   355: invokevirtual 909	com/tencent/mm/plugin/sns/ui/MaskImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   358: aload_0
    //   359: getfield 576	com/tencent/mm/plugin/sns/ui/c/a/c:szq	Lcom/tencent/mm/ui/widget/b/a;
    //   362: aload_0
    //   363: getfield 310	com/tencent/mm/plugin/sns/ui/c/a/c:Ljf	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
    //   366: aload_0
    //   367: getfield 117	com/tencent/mm/plugin/sns/ui/c/a/c:JIp	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   370: getfield 580	com/tencent/mm/plugin/sns/ui/d/c:Lph	Lcom/tencent/mm/plugin/sns/ui/d/d;
    //   373: aload_0
    //   374: getfield 117	com/tencent/mm/plugin/sns/ui/c/a/c:JIp	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   377: getfield 584	com/tencent/mm/plugin/sns/ui/d/c:LoP	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   380: invokevirtual 588	com/tencent/mm/ui/widget/b/a:c	(Landroid/view/View;Landroid/view/View$OnCreateContextMenuListener;Lcom/tencent/mm/ui/base/q$g;)V
    //   383: aload_0
    //   384: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   387: invokevirtual 183	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   390: invokevirtual 912	com/tencent/mm/plugin/sns/storage/ADXml:hasActionBtn	()Z
    //   393: ifeq +1955 -> 2348
    //   396: aload_0
    //   397: getfield 538	com/tencent/mm/plugin/sns/ui/c/a/c:LiY	Landroid/widget/TextView;
    //   400: ifnull +12 -> 412
    //   403: aload_0
    //   404: getfield 538	com/tencent/mm/plugin/sns/ui/c/a/c:LiY	Landroid/widget/TextView;
    //   407: bipush 8
    //   409: invokevirtual 563	android/widget/TextView:setVisibility	(I)V
    //   412: aload_0
    //   413: getfield 406	com/tencent/mm/plugin/sns/ui/c/a/c:LiZ	Landroid/widget/TextView;
    //   416: ifnull +12 -> 428
    //   419: aload_0
    //   420: getfield 406	com/tencent/mm/plugin/sns/ui/c/a/c:LiZ	Landroid/widget/TextView;
    //   423: bipush 8
    //   425: invokevirtual 563	android/widget/TextView:setVisibility	(I)V
    //   428: aload_0
    //   429: getfield 321	com/tencent/mm/plugin/sns/ui/c/a/c:Ljk	Landroid/view/View;
    //   432: iconst_0
    //   433: invokevirtual 291	android/view/View:setVisibility	(I)V
    //   436: aload_0
    //   437: getfield 914	com/tencent/mm/plugin/sns/ui/c/a/c:Ljn	Lcom/tencent/mm/plugin/sns/ui/ax;
    //   440: ifnonnull +31 -> 471
    //   443: aload_0
    //   444: new 916	com/tencent/mm/plugin/sns/ui/ax
    //   447: dup
    //   448: aload_0
    //   449: getfield 140	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   452: aload_0
    //   453: getfield 246	com/tencent/mm/plugin/sns/ui/c/a/c:contentView	Landroid/view/View;
    //   456: iconst_1
    //   457: aload_0
    //   458: getfield 119	com/tencent/mm/plugin/sns/ui/c/a/c:KPn	Lcom/tencent/mm/plugin/sns/ad/f/l;
    //   461: aload_0
    //   462: getfield 103	com/tencent/mm/plugin/sns/ui/c/a/c:JHi	Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c$b;
    //   465: invokespecial 919	com/tencent/mm/plugin/sns/ui/ax:<init>	(Landroid/content/Context;Landroid/view/View;ILcom/tencent/mm/plugin/sns/ad/f/l;Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c$b;)V
    //   468: putfield 914	com/tencent/mm/plugin/sns/ui/c/a/c:Ljn	Lcom/tencent/mm/plugin/sns/ui/ax;
    //   471: aload_0
    //   472: getfield 914	com/tencent/mm/plugin/sns/ui/c/a/c:Ljn	Lcom/tencent/mm/plugin/sns/ui/ax;
    //   475: aload_0
    //   476: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   479: invokevirtual 922	com/tencent/mm/plugin/sns/ui/ax:W	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V
    //   482: aload_0
    //   483: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   486: astore 6
    //   488: aload 6
    //   490: ifnull +2226 -> 2716
    //   493: aload 6
    //   495: invokevirtual 183	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   498: ifnull +2218 -> 2716
    //   501: aload 6
    //   503: invokevirtual 183	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   506: getfield 926	com/tencent/mm/plugin/sns/storage/ADXml:adLiveInfo	Lcom/tencent/mm/plugin/sns/ad/adxml/g;
    //   509: ifnonnull +1851 -> 2360
    //   512: goto +2204 -> 2716
    //   515: iload_1
    //   516: ifeq +2081 -> 2597
    //   519: aload 6
    //   521: invokevirtual 930	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   524: astore 7
    //   526: aload_0
    //   527: getfield 932	com/tencent/mm/plugin/sns/ui/c/a/c:JKI	Landroid/view/ViewGroup;
    //   530: ifnonnull +35 -> 565
    //   533: aload_0
    //   534: getfield 246	com/tencent/mm/plugin/sns/ui/c/a/c:contentView	Landroid/view/View;
    //   537: getstatic 935	com/tencent/mm/plugin/sns/i$f:ad_live_status_layout_stub	I
    //   540: invokevirtual 264	android/view/View:findViewById	(I)Landroid/view/View;
    //   543: checkcast 601	android/view/ViewStub
    //   546: astore 8
    //   548: aload 8
    //   550: ifnull +15 -> 565
    //   553: aload_0
    //   554: aload 8
    //   556: invokestatic 606	com/tencent/mm/plugin/sns/ad/i/l:c	(Landroid/view/ViewStub;)Landroid/view/View;
    //   559: checkcast 326	android/view/ViewGroup
    //   562: putfield 932	com/tencent/mm/plugin/sns/ui/c/a/c:JKI	Landroid/view/ViewGroup;
    //   565: aload_0
    //   566: getfield 937	com/tencent/mm/plugin/sns/ui/c/a/c:Ljp	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   569: ifnonnull +35 -> 604
    //   572: aload_0
    //   573: getfield 246	com/tencent/mm/plugin/sns/ui/c/a/c:contentView	Landroid/view/View;
    //   576: getstatic 940	com/tencent/mm/plugin/sns/i$f:ad_live_desc_layout_stub	I
    //   579: invokevirtual 264	android/view/View:findViewById	(I)Landroid/view/View;
    //   582: checkcast 601	android/view/ViewStub
    //   585: astore 8
    //   587: aload 8
    //   589: ifnull +15 -> 604
    //   592: aload_0
    //   593: aload 8
    //   595: invokestatic 606	com/tencent/mm/plugin/sns/ad/i/l:c	(Landroid/view/ViewStub;)Landroid/view/View;
    //   598: checkcast 942	com/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout
    //   601: putfield 937	com/tencent/mm/plugin/sns/ui/c/a/c:Ljp	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   604: aload_0
    //   605: getfield 932	com/tencent/mm/plugin/sns/ui/c/a/c:JKI	Landroid/view/ViewGroup;
    //   608: ifnull +10 -> 618
    //   611: aload_0
    //   612: getfield 937	com/tencent/mm/plugin/sns/ui/c/a/c:Ljp	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   615: ifnonnull +1750 -> 2365
    //   618: ldc_w 439
    //   621: ldc_w 944
    //   624: invokestatic 805	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   627: aload_0
    //   628: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   631: astore 6
    //   633: aload 6
    //   635: ifnull +2086 -> 2721
    //   638: aload 6
    //   640: invokevirtual 183	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   643: ifnonnull +2005 -> 2648
    //   646: goto +2075 -> 2721
    //   649: iload_1
    //   650: ifeq +2034 -> 2684
    //   653: aload 6
    //   655: invokevirtual 183	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   658: getfield 948	com/tencent/mm/plugin/sns/storage/ADXml:adPromotionInfo	Lcom/tencent/mm/plugin/sns/ad/adxml/h;
    //   661: astore 6
    //   663: aload_0
    //   664: getfield 950	com/tencent/mm/plugin/sns/ui/c/a/c:Ljl	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   667: ifnonnull +35 -> 702
    //   670: aload_0
    //   671: getfield 246	com/tencent/mm/plugin/sns/ui/c/a/c:contentView	Landroid/view/View;
    //   674: getstatic 953	com/tencent/mm/plugin/sns/i$f:ad_promotion_bar_stub	I
    //   677: invokevirtual 264	android/view/View:findViewById	(I)Landroid/view/View;
    //   680: checkcast 601	android/view/ViewStub
    //   683: astore 7
    //   685: aload 7
    //   687: ifnull +15 -> 702
    //   690: aload_0
    //   691: aload 7
    //   693: invokestatic 606	com/tencent/mm/plugin/sns/ad/i/l:c	(Landroid/view/ViewStub;)Landroid/view/View;
    //   696: checkcast 955	com/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout
    //   699: putfield 950	com/tencent/mm/plugin/sns/ui/c/a/c:Ljl	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   702: aload_0
    //   703: getfield 950	com/tencent/mm/plugin/sns/ui/c/a/c:Ljl	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   706: ifnull +79 -> 785
    //   709: aload_0
    //   710: getfield 950	com/tencent/mm/plugin/sns/ui/c/a/c:Ljl	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   713: iconst_0
    //   714: invokevirtual 956	com/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout:setVisibility	(I)V
    //   717: aload_0
    //   718: getfield 950	com/tencent/mm/plugin/sns/ui/c/a/c:Ljl	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   721: aload 6
    //   723: getfield 961	com/tencent/mm/plugin/sns/ad/adxml/h:JyA	Ljava/lang/String;
    //   726: invokevirtual 964	com/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout:setPromotionalPrice	(Ljava/lang/String;)V
    //   729: aload_0
    //   730: getfield 950	com/tencent/mm/plugin/sns/ui/c/a/c:Ljl	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   733: aload 6
    //   735: getfield 967	com/tencent/mm/plugin/sns/ad/adxml/h:JyB	Ljava/lang/String;
    //   738: invokevirtual 970	com/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout:setRightTitle	(Ljava/lang/String;)V
    //   741: aload_0
    //   742: getfield 950	com/tencent/mm/plugin/sns/ui/c/a/c:Ljl	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   745: aload 6
    //   747: getfield 973	com/tencent/mm/plugin/sns/ad/adxml/h:Jyy	Ljava/lang/String;
    //   750: aload 6
    //   752: getfield 976	com/tencent/mm/plugin/sns/ad/adxml/h:nWx	Ljava/lang/String;
    //   755: invokestatic 982	com/tencent/mm/plugin/sns/ad/i/e:kp	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   758: invokestatic 985	com/tencent/mm/plugin/sns/ad/i/l:i	(Landroid/view/View;Ljava/lang/String;)V
    //   761: aload_0
    //   762: getfield 950	com/tencent/mm/plugin/sns/ui/c/a/c:Ljl	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   765: new 987	com/tencent/mm/plugin/sns/ad/widget/countdown/b
    //   768: dup
    //   769: aload 6
    //   771: getfield 990	com/tencent/mm/plugin/sns/ad/adxml/h:startTime	J
    //   774: aload 6
    //   776: getfield 993	com/tencent/mm/plugin/sns/ad/adxml/h:endTime	J
    //   779: invokespecial 996	com/tencent/mm/plugin/sns/ad/widget/countdown/b:<init>	(JJ)V
    //   782: invokevirtual 999	com/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout:b	(Lcom/tencent/mm/plugin/sns/ad/widget/countdown/d;)V
    //   785: ldc_w 838
    //   788: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   791: return
    //   792: aload_0
    //   793: aload_0
    //   794: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   797: invokespecial 801	com/tencent/mm/plugin/sns/ui/c/a/c:ab	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V
    //   800: goto -713 -> 87
    //   803: aconst_null
    //   804: astore 6
    //   806: goto -652 -> 154
    //   809: aload_0
    //   810: getfield 109	com/tencent/mm/plugin/sns/ui/c/a/c:timeLineObject	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   813: getfield 233	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adw;
    //   816: getfield 238	com/tencent/mm/protocal/protobuf/adw:Sqq	I
    //   819: iconst_5
    //   820: if_icmpeq +18 -> 838
    //   823: aload_0
    //   824: getfield 109	com/tencent/mm/plugin/sns/ui/c/a/c:timeLineObject	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   827: getfield 233	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adw;
    //   830: getfield 238	com/tencent/mm/protocal/protobuf/adw:Sqq	I
    //   833: bipush 15
    //   835: if_icmpne +1444 -> 2279
    //   838: aload_0
    //   839: getfield 624	com/tencent/mm/plugin/sns/ui/c/a/c:JKG	Lcom/tencent/mm/plugin/sns/ui/av;
    //   842: getfield 633	com/tencent/mm/plugin/sns/ui/av:KKj	Landroid/view/View;
    //   845: iconst_0
    //   846: invokevirtual 291	android/view/View:setVisibility	(I)V
    //   849: aload_0
    //   850: getfield 576	com/tencent/mm/plugin/sns/ui/c/a/c:szq	Lcom/tencent/mm/ui/widget/b/a;
    //   853: aload_0
    //   854: getfield 624	com/tencent/mm/plugin/sns/ui/c/a/c:JKG	Lcom/tencent/mm/plugin/sns/ui/av;
    //   857: getfield 630	com/tencent/mm/plugin/sns/ui/av:KKm	Landroid/view/View;
    //   860: aload_0
    //   861: getfield 117	com/tencent/mm/plugin/sns/ui/c/a/c:JIp	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   864: getfield 580	com/tencent/mm/plugin/sns/ui/d/c:Lph	Lcom/tencent/mm/plugin/sns/ui/d/d;
    //   867: aload_0
    //   868: getfield 117	com/tencent/mm/plugin/sns/ui/c/a/c:JIp	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   871: getfield 584	com/tencent/mm/plugin/sns/ui/d/c:LoP	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   874: invokevirtual 588	com/tencent/mm/ui/widget/b/a:c	(Landroid/view/View;Landroid/view/View$OnCreateContextMenuListener;Lcom/tencent/mm/ui/base/q$g;)V
    //   877: aload_0
    //   878: getfield 624	com/tencent/mm/plugin/sns/ui/c/a/c:JKG	Lcom/tencent/mm/plugin/sns/ui/av;
    //   881: getfield 633	com/tencent/mm/plugin/sns/ui/av:KKj	Landroid/view/View;
    //   884: invokevirtual 496	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   887: astore 8
    //   889: aload 8
    //   891: iload_1
    //   892: putfield 884	android/view/ViewGroup$LayoutParams:width	I
    //   895: aload 8
    //   897: iload_2
    //   898: putfield 885	android/view/ViewGroup$LayoutParams:height	I
    //   901: aload_0
    //   902: getfield 624	com/tencent/mm/plugin/sns/ui/c/a/c:JKG	Lcom/tencent/mm/plugin/sns/ui/av;
    //   905: getfield 633	com/tencent/mm/plugin/sns/ui/av:KKj	Landroid/view/View;
    //   908: aload 8
    //   910: invokevirtual 520	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   913: aload_0
    //   914: getfield 624	com/tencent/mm/plugin/sns/ui/c/a/c:JKG	Lcom/tencent/mm/plugin/sns/ui/av;
    //   917: getfield 646	com/tencent/mm/plugin/sns/ui/av:KKk	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   920: iload_1
    //   921: iload_2
    //   922: invokevirtual 1003	com/tencent/mm/pluginsdk/ui/tools/VideoSightView:ju	(II)V
    //   925: aload_0
    //   926: getfield 624	com/tencent/mm/plugin/sns/ui/c/a/c:JKG	Lcom/tencent/mm/plugin/sns/ui/av;
    //   929: getfield 646	com/tencent/mm/plugin/sns/ui/av:KKk	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   932: new 6	com/tencent/mm/plugin/sns/ui/c/a/c$1
    //   935: dup
    //   936: aload_0
    //   937: invokespecial 1004	com/tencent/mm/plugin/sns/ui/c/a/c$1:<init>	(Lcom/tencent/mm/plugin/sns/ui/c/a/c;)V
    //   940: invokevirtual 1008	com/tencent/mm/pluginsdk/ui/tools/VideoSightView:setOnCompletionListener	(Lcom/tencent/mm/plugin/sight/decode/a/b$e;)V
    //   943: aload_0
    //   944: getfield 624	com/tencent/mm/plugin/sns/ui/c/a/c:JKG	Lcom/tencent/mm/plugin/sns/ui/av;
    //   947: getfield 646	com/tencent/mm/plugin/sns/ui/av:KKk	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   950: new 8	com/tencent/mm/plugin/sns/ui/c/a/c$2
    //   953: dup
    //   954: aload_0
    //   955: invokespecial 1009	com/tencent/mm/plugin/sns/ui/c/a/c$2:<init>	(Lcom/tencent/mm/plugin/sns/ui/c/a/c;)V
    //   958: invokevirtual 1013	com/tencent/mm/pluginsdk/ui/tools/VideoSightView:setOnDecodeDurationListener	(Lcom/tencent/mm/plugin/sight/decode/a/b$f;)V
    //   961: aload_0
    //   962: getfield 421	com/tencent/mm/plugin/sns/ui/c/a/c:Ljs	Z
    //   965: ifeq +649 -> 1614
    //   968: aload_0
    //   969: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   972: aload 6
    //   974: invokestatic 1018	com/tencent/mm/plugin/sns/ad/d/d:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/protocal/protobuf/cvt;)V
    //   977: invokestatic 1024	java/lang/System:nanoTime	()J
    //   980: lstore_3
    //   981: aload 6
    //   983: invokestatic 1028	com/tencent/mm/plugin/sns/model/g:u	(Lcom/tencent/mm/protocal/protobuf/cvt;)Z
    //   986: istore 5
    //   988: ldc_w 439
    //   991: ldc_w 1030
    //   994: iconst_2
    //   995: anewarray 888	java/lang/Object
    //   998: dup
    //   999: iconst_0
    //   1000: iload 5
    //   1002: invokestatic 1036	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1005: aastore
    //   1006: dup
    //   1007: iconst_1
    //   1008: invokestatic 1024	java/lang/System:nanoTime	()J
    //   1011: lload_3
    //   1012: lsub
    //   1013: invokestatic 1041	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1016: aastore
    //   1017: invokestatic 1044	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1020: aload_0
    //   1021: getfield 624	com/tencent/mm/plugin/sns/ui/c/a/c:JKG	Lcom/tencent/mm/plugin/sns/ui/av;
    //   1024: astore 8
    //   1026: aload_0
    //   1027: getfield 624	com/tencent/mm/plugin/sns/ui/c/a/c:JKG	Lcom/tencent/mm/plugin/sns/ui/av;
    //   1030: aload_0
    //   1031: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1034: invokevirtual 125	com/tencent/mm/plugin/sns/storage/SnsInfo:getLocalid	()Ljava/lang/String;
    //   1037: putfield 1045	com/tencent/mm/plugin/sns/ui/av:fAg	Ljava/lang/String;
    //   1040: iload 5
    //   1042: ifne +766 -> 1808
    //   1045: aload 7
    //   1047: aload 6
    //   1049: invokevirtual 1048	com/tencent/mm/plugin/sns/model/g:x	(Lcom/tencent/mm/protocal/protobuf/cvt;)Z
    //   1052: ifeq +571 -> 1623
    //   1055: aload 8
    //   1057: getfield 655	com/tencent/mm/plugin/sns/ui/av:JAL	Landroid/widget/ImageView;
    //   1060: bipush 8
    //   1062: invokevirtual 339	android/widget/ImageView:setVisibility	(I)V
    //   1065: aload 8
    //   1067: getfield 664	com/tencent/mm/plugin/sns/ui/av:KKn	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1070: iconst_0
    //   1071: invokevirtual 1049	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   1074: aload 8
    //   1076: getfield 664	com/tencent/mm/plugin/sns/ui/av:KKn	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1079: invokevirtual 1052	com/tencent/mm/ui/widget/MMPinProgressBtn:hZF	()V
    //   1082: aload_0
    //   1083: getfield 624	com/tencent/mm/plugin/sns/ui/c/a/c:JKG	Lcom/tencent/mm/plugin/sns/ui/av;
    //   1086: getfield 633	com/tencent/mm/plugin/sns/ui/av:KKj	Landroid/view/View;
    //   1089: iconst_0
    //   1090: invokevirtual 291	android/view/View:setVisibility	(I)V
    //   1093: aload 8
    //   1095: getfield 646	com/tencent/mm/plugin/sns/ui/av:KKk	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   1098: aload 8
    //   1100: invokevirtual 1055	com/tencent/mm/pluginsdk/ui/tools/VideoSightView:setTagObject	(Ljava/lang/Object;)V
    //   1103: aload 8
    //   1105: getfield 630	com/tencent/mm/plugin/sns/ui/av:KKm	Landroid/view/View;
    //   1108: aload_0
    //   1109: invokevirtual 904	android/view/View:setTag	(Ljava/lang/Object;)V
    //   1112: aload_0
    //   1113: getfield 246	com/tencent/mm/plugin/sns/ui/c/a/c:contentView	Landroid/view/View;
    //   1116: aload_0
    //   1117: invokevirtual 904	android/view/View:setTag	(Ljava/lang/Object;)V
    //   1120: aload_0
    //   1121: getfield 162	com/tencent/mm/plugin/sns/ui/c/a/c:Ljb	Landroid/widget/Button;
    //   1124: aload_0
    //   1125: invokevirtual 905	android/widget/Button:setTag	(Ljava/lang/Object;)V
    //   1128: aload_0
    //   1129: getfield 164	com/tencent/mm/plugin/sns/ui/c/a/c:Ljc	Landroid/widget/Button;
    //   1132: aload_0
    //   1133: invokevirtual 905	android/widget/Button:setTag	(Ljava/lang/Object;)V
    //   1136: aload_0
    //   1137: getfield 421	com/tencent/mm/plugin/sns/ui/c/a/c:Ljs	Z
    //   1140: ifeq +1011 -> 2151
    //   1143: aload 7
    //   1145: aload_0
    //   1146: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1149: aload 6
    //   1151: aload 8
    //   1153: getfield 646	com/tencent/mm/plugin/sns/ui/av:KKk	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   1156: iconst_m1
    //   1157: aload_0
    //   1158: getfield 140	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   1161: invokevirtual 891	java/lang/Object:hashCode	()I
    //   1164: iconst_0
    //   1165: getstatic 897	com/tencent/mm/storage/bp:VGo	Lcom/tencent/mm/storage/bp;
    //   1168: iconst_1
    //   1169: iconst_1
    //   1170: iconst_0
    //   1171: invokevirtual 1058	com/tencent/mm/plugin/sns/model/g:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/protocal/protobuf/cvt;Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;IIILcom/tencent/mm/storage/bp;ZZZ)Z
    //   1174: pop
    //   1175: aload_0
    //   1176: getfield 119	com/tencent/mm/plugin/sns/ui/c/a/c:KPn	Lcom/tencent/mm/plugin/sns/ad/f/l;
    //   1179: ifnull +157 -> 1336
    //   1182: invokestatic 1061	com/tencent/mm/plugin/sns/model/aj:getAccSnsPath	()Ljava/lang/String;
    //   1185: aload 6
    //   1187: getfield 1062	com/tencent/mm/protocal/protobuf/cvt:Id	Ljava/lang/String;
    //   1190: invokestatic 1067	com/tencent/mm/plugin/sns/model/aq:kD	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1193: astore 7
    //   1195: aload 6
    //   1197: invokestatic 1072	com/tencent/mm/plugin/sns/data/t:i	(Lcom/tencent/mm/protocal/protobuf/cvt;)Ljava/lang/String;
    //   1200: astore 9
    //   1202: new 423	java/lang/StringBuilder
    //   1205: dup
    //   1206: invokespecial 1073	java/lang/StringBuilder:<init>	()V
    //   1209: aload 7
    //   1211: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: aload 9
    //   1216: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1222: astore 7
    //   1224: aload 7
    //   1226: invokestatic 1078	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   1229: ifeq +955 -> 2184
    //   1232: aload_0
    //   1233: getfield 119	com/tencent/mm/plugin/sns/ui/c/a/c:KPn	Lcom/tencent/mm/plugin/sns/ad/f/l;
    //   1236: aload_0
    //   1237: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1240: getfield 824	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1243: aload 6
    //   1245: getfield 1081	com/tencent/mm/protocal/protobuf/cvt:TDZ	F
    //   1248: f2i
    //   1249: iconst_1
    //   1250: invokevirtual 1084	com/tencent/mm/plugin/sns/ad/f/l:f	(JIZ)V
    //   1253: invokestatic 1087	com/tencent/mm/plugin/sns/ad/d/d:No	()Z
    //   1256: ifeq +45 -> 1301
    //   1259: aload 7
    //   1261: invokestatic 1092	com/tencent/mm/modelvideo/v:isH265Video	(Ljava/lang/String;)Z
    //   1264: istore 5
    //   1266: ldc_w 439
    //   1269: new 423	java/lang/StringBuilder
    //   1272: dup
    //   1273: ldc_w 1094
    //   1276: invokespecial 428	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1279: iload 5
    //   1281: invokevirtual 432	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1284: ldc_w 1096
    //   1287: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: aload 7
    //   1292: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1298: invokestatic 447	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1301: invokestatic 851	com/tencent/mm/plugin/sns/model/aj:fOF	()Lcom/tencent/mm/plugin/sns/model/g;
    //   1304: aload_0
    //   1305: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1308: aconst_null
    //   1309: invokevirtual 1099	com/tencent/mm/plugin/sns/model/g:b	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;[I)I
    //   1312: iconst_5
    //   1313: if_icmpne +895 -> 2208
    //   1316: iconst_1
    //   1317: istore 5
    //   1319: aload_0
    //   1320: getfield 119	com/tencent/mm/plugin/sns/ui/c/a/c:KPn	Lcom/tencent/mm/plugin/sns/ad/f/l;
    //   1323: aload_0
    //   1324: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1327: getfield 824	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1330: iload 5
    //   1332: iconst_0
    //   1333: invokevirtual 1103	com/tencent/mm/plugin/sns/ad/f/l:d	(JZZ)V
    //   1336: aload_0
    //   1337: getfield 421	com/tencent/mm/plugin/sns/ui/c/a/c:Ljs	Z
    //   1340: ifeq +922 -> 2262
    //   1343: aload_0
    //   1344: getfield 328	com/tencent/mm/plugin/sns/ui/c/a/c:JKL	Landroid/view/ViewGroup;
    //   1347: iload_1
    //   1348: iload_2
    //   1349: invokestatic 1107	com/tencent/mm/plugin/sns/ad/i/l:v	(Landroid/view/View;II)V
    //   1352: aload_0
    //   1353: getfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1356: ifnonnull +858 -> 2214
    //   1359: aload_0
    //   1360: getfield 328	com/tencent/mm/plugin/sns/ui/c/a/c:JKL	Landroid/view/ViewGroup;
    //   1363: invokestatic 1111	com/tencent/mm/plugin/sns/ad/i/l:M	(Landroid/view/ViewGroup;)V
    //   1366: aload_0
    //   1367: new 817	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView
    //   1370: dup
    //   1371: aload_0
    //   1372: getfield 140	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   1375: iconst_0
    //   1376: invokespecial 1114	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:<init>	(Landroid/content/Context;B)V
    //   1379: putfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1382: aload_0
    //   1383: getfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1386: invokevirtual 1117	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:fUe	()V
    //   1389: aload_0
    //   1390: getfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1393: getstatic 1123	com/tencent/mm/pluginsdk/ui/i$e:RcH	Lcom/tencent/mm/pluginsdk/ui/i$e;
    //   1396: invokevirtual 1127	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:setVideoScaleType	(Lcom/tencent/mm/pluginsdk/ui/i$e;)V
    //   1399: aload_0
    //   1400: getfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1403: getstatic 1133	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   1406: invokevirtual 1137	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:setThumbViewScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1409: aload_0
    //   1410: getfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1413: iconst_m1
    //   1414: iconst_m1
    //   1415: invokestatic 1107	com/tencent/mm/plugin/sns/ad/i/l:v	(Landroid/view/View;II)V
    //   1418: aload_0
    //   1419: getfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1422: iconst_1
    //   1423: invokestatic 1141	com/tencent/mm/plugin/sns/ad/i/l:w	(Landroid/view/View;Z)V
    //   1426: aload_0
    //   1427: getfield 328	com/tencent/mm/plugin/sns/ui/c/a/c:JKL	Landroid/view/ViewGroup;
    //   1430: aload_0
    //   1431: getfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1434: iconst_0
    //   1435: invokestatic 1144	com/tencent/mm/plugin/sns/ad/i/l:b	(Landroid/view/ViewGroup;Landroid/view/View;I)Z
    //   1438: pop
    //   1439: aload_0
    //   1440: getfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1443: new 10	com/tencent/mm/plugin/sns/ui/c/a/c$3
    //   1446: dup
    //   1447: aload_0
    //   1448: invokespecial 1145	com/tencent/mm/plugin/sns/ui/c/a/c$3:<init>	(Lcom/tencent/mm/plugin/sns/ui/c/a/c;)V
    //   1451: invokevirtual 1149	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:setUICallback	(Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView$b;)V
    //   1454: aload_0
    //   1455: getfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1458: new 1151	com/tencent/mm/plugin/sns/ad/timeline/video/online/a
    //   1461: dup
    //   1462: aload_0
    //   1463: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1466: aload_0
    //   1467: getfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1470: aload_0
    //   1471: getfield 119	com/tencent/mm/plugin/sns/ui/c/a/c:KPn	Lcom/tencent/mm/plugin/sns/ad/f/l;
    //   1474: iconst_3
    //   1475: invokespecial 1154	com/tencent/mm/plugin/sns/ad/timeline/video/online/a:<init>	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/ui/OnlineVideoView;Lcom/tencent/mm/plugin/sns/ad/f/l;I)V
    //   1478: invokevirtual 1158	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:setVideoCallback	(Lcom/tencent/mm/plugin/sns/ui/OnlineVideoView$b;)V
    //   1481: ldc_w 439
    //   1484: new 423	java/lang/StringBuilder
    //   1487: dup
    //   1488: ldc_w 1160
    //   1491: invokespecial 428	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1494: aload_0
    //   1495: getfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1498: invokevirtual 891	java/lang/Object:hashCode	()I
    //   1501: invokevirtual 1163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1504: ldc_w 1165
    //   1507: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1510: aload_0
    //   1511: getfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1514: invokevirtual 1169	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:getInnerVideoView	()Landroid/view/View;
    //   1517: invokevirtual 1172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1520: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1523: invokestatic 447	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1526: aload_0
    //   1527: getfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1530: iconst_1
    //   1531: invokevirtual 1173	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:setMute	(Z)V
    //   1534: aload_0
    //   1535: getfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1538: aload 6
    //   1540: aload_0
    //   1541: getfield 127	com/tencent/mm/plugin/sns/ui/c/a/c:fAg	Ljava/lang/String;
    //   1544: aload_0
    //   1545: getfield 109	com/tencent/mm/plugin/sns/ui/c/a/c:timeLineObject	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1548: getfield 1176	com/tencent/mm/protocal/protobuf/TimeLineObject:CreateTime	I
    //   1551: invokevirtual 1179	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:a	(Lcom/tencent/mm/protocal/protobuf/cvt;Ljava/lang/String;I)V
    //   1554: aload_0
    //   1555: getfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1558: invokevirtual 1182	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:abandonAudioFocus	()V
    //   1561: aload_0
    //   1562: getfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1565: invokevirtual 1185	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:fhw	()V
    //   1568: aload_0
    //   1569: getfield 98	com/tencent/mm/plugin/sns/ui/c/a/c:JMp	Landroid/os/Handler;
    //   1572: aconst_null
    //   1573: invokevirtual 1188	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   1576: aload_0
    //   1577: getfield 98	com/tencent/mm/plugin/sns/ui/c/a/c:JMp	Landroid/os/Handler;
    //   1580: new 12	com/tencent/mm/plugin/sns/ui/c/a/c$4
    //   1583: dup
    //   1584: aload_0
    //   1585: invokespecial 1189	com/tencent/mm/plugin/sns/ui/c/a/c$4:<init>	(Lcom/tencent/mm/plugin/sns/ui/c/a/c;)V
    //   1588: ldc2_w 1190
    //   1591: invokevirtual 1195	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   1594: pop
    //   1595: aload_0
    //   1596: getfield 624	com/tencent/mm/plugin/sns/ui/c/a/c:JKG	Lcom/tencent/mm/plugin/sns/ui/av;
    //   1599: getfield 664	com/tencent/mm/plugin/sns/ui/av:KKn	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1602: iconst_0
    //   1603: invokestatic 1141	com/tencent/mm/plugin/sns/ad/i/l:w	(Landroid/view/View;Z)V
    //   1606: aload_0
    //   1607: iconst_1
    //   1608: putfield 105	com/tencent/mm/plugin/sns/ui/c/a/c:Ljt	Z
    //   1611: goto -1228 -> 383
    //   1614: aload 6
    //   1616: iconst_0
    //   1617: invokestatic 1198	com/tencent/mm/plugin/sns/ad/d/d:a	(Lcom/tencent/mm/protocal/protobuf/cvt;Z)V
    //   1620: goto -643 -> 977
    //   1623: aload 7
    //   1625: aload_0
    //   1626: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1629: aconst_null
    //   1630: invokevirtual 1099	com/tencent/mm/plugin/sns/model/g:b	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;[I)I
    //   1633: iconst_5
    //   1634: if_icmpne +40 -> 1674
    //   1637: aload 7
    //   1639: aload 6
    //   1641: invokevirtual 1202	com/tencent/mm/plugin/sns/model/g:B	(Lcom/tencent/mm/protocal/protobuf/cvt;)V
    //   1644: aload 8
    //   1646: getfield 655	com/tencent/mm/plugin/sns/ui/av:JAL	Landroid/widget/ImageView;
    //   1649: bipush 8
    //   1651: invokevirtual 339	android/widget/ImageView:setVisibility	(I)V
    //   1654: aload 8
    //   1656: getfield 664	com/tencent/mm/plugin/sns/ui/av:KKn	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1659: iconst_0
    //   1660: invokevirtual 1049	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   1663: aload 8
    //   1665: getfield 664	com/tencent/mm/plugin/sns/ui/av:KKn	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1668: invokevirtual 1052	com/tencent/mm/ui/widget/MMPinProgressBtn:hZF	()V
    //   1671: goto -589 -> 1082
    //   1674: aload 7
    //   1676: aload 6
    //   1678: invokevirtual 1205	com/tencent/mm/plugin/sns/model/g:y	(Lcom/tencent/mm/protocal/protobuf/cvt;)Z
    //   1681: ifeq +36 -> 1717
    //   1684: aload 8
    //   1686: getfield 664	com/tencent/mm/plugin/sns/ui/av:KKn	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1689: bipush 8
    //   1691: invokevirtual 1049	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   1694: aload 8
    //   1696: getfield 655	com/tencent/mm/plugin/sns/ui/av:JAL	Landroid/widget/ImageView;
    //   1699: getstatic 1208	com/tencent/mm/plugin/sns/i$i:shortvideo_play_icon_err	I
    //   1702: invokevirtual 401	android/widget/ImageView:setImageResource	(I)V
    //   1705: aload 8
    //   1707: getfield 655	com/tencent/mm/plugin/sns/ui/av:JAL	Landroid/widget/ImageView;
    //   1710: iconst_0
    //   1711: invokevirtual 339	android/widget/ImageView:setVisibility	(I)V
    //   1714: goto -632 -> 1082
    //   1717: aload 7
    //   1719: aload 6
    //   1721: invokevirtual 1211	com/tencent/mm/plugin/sns/model/g:z	(Lcom/tencent/mm/protocal/protobuf/cvt;)V
    //   1724: aload 8
    //   1726: getfield 655	com/tencent/mm/plugin/sns/ui/av:JAL	Landroid/widget/ImageView;
    //   1729: iconst_0
    //   1730: invokevirtual 339	android/widget/ImageView:setVisibility	(I)V
    //   1733: aload 8
    //   1735: getfield 664	com/tencent/mm/plugin/sns/ui/av:KKn	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1738: bipush 8
    //   1740: invokevirtual 1049	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   1743: aload 8
    //   1745: getfield 655	com/tencent/mm/plugin/sns/ui/av:JAL	Landroid/widget/ImageView;
    //   1748: aload_0
    //   1749: getfield 140	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   1752: getstatic 1214	com/tencent/mm/plugin/sns/i$i:shortvideo_play_btn	I
    //   1755: invokestatic 1218	com/tencent/mm/ci/a:m	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   1758: invokevirtual 1221	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1761: aload 8
    //   1763: getfield 655	com/tencent/mm/plugin/sns/ui/av:JAL	Landroid/widget/ImageView;
    //   1766: aload_0
    //   1767: getfield 140	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   1770: invokevirtual 146	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1773: getstatic 1224	com/tencent/mm/plugin/sns/i$j:play_sight_desc	I
    //   1776: invokevirtual 1227	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1779: invokevirtual 1230	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   1782: aload 7
    //   1784: aload_0
    //   1785: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1788: aconst_null
    //   1789: invokevirtual 1099	com/tencent/mm/plugin/sns/model/g:b	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;[I)I
    //   1792: iconst_4
    //   1793: if_icmpne -711 -> 1082
    //   1796: aload 8
    //   1798: getfield 676	com/tencent/mm/plugin/sns/ui/av:Ktc	Landroid/widget/TextView;
    //   1801: iconst_0
    //   1802: invokevirtual 563	android/widget/TextView:setVisibility	(I)V
    //   1805: goto -723 -> 1082
    //   1808: aload 7
    //   1810: aload 6
    //   1812: invokevirtual 1232	com/tencent/mm/plugin/sns/model/g:v	(Lcom/tencent/mm/protocal/protobuf/cvt;)Z
    //   1815: ifeq +198 -> 2013
    //   1818: aload 8
    //   1820: getfield 655	com/tencent/mm/plugin/sns/ui/av:JAL	Landroid/widget/ImageView;
    //   1823: iconst_0
    //   1824: invokevirtual 339	android/widget/ImageView:setVisibility	(I)V
    //   1827: aload 8
    //   1829: getfield 664	com/tencent/mm/plugin/sns/ui/av:KKn	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1832: bipush 8
    //   1834: invokevirtual 1049	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   1837: aload 8
    //   1839: getfield 655	com/tencent/mm/plugin/sns/ui/av:JAL	Landroid/widget/ImageView;
    //   1842: aload_0
    //   1843: getfield 140	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   1846: getstatic 1214	com/tencent/mm/plugin/sns/i$i:shortvideo_play_btn	I
    //   1849: invokestatic 1218	com/tencent/mm/ci/a:m	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   1852: invokevirtual 1221	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1855: aload 8
    //   1857: getfield 655	com/tencent/mm/plugin/sns/ui/av:JAL	Landroid/widget/ImageView;
    //   1860: aload_0
    //   1861: getfield 140	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   1864: invokevirtual 146	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1867: getstatic 1224	com/tencent/mm/plugin/sns/i$j:play_sight_desc	I
    //   1870: invokevirtual 1227	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1873: invokevirtual 1230	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   1876: aload 8
    //   1878: getfield 646	com/tencent/mm/plugin/sns/ui/av:KKk	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   1881: getfield 1236	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView:JsW	Lcom/tencent/mm/plugin/sight/decode/a/b;
    //   1884: invokevirtual 1241	com/tencent/mm/plugin/sight/decode/a/b:fIC	()Z
    //   1887: ifeq -805 -> 1082
    //   1890: ldc_w 439
    //   1893: new 423	java/lang/StringBuilder
    //   1896: dup
    //   1897: ldc_w 1243
    //   1900: invokespecial 428	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1903: aload 6
    //   1905: getfield 1062	com/tencent/mm/protocal/protobuf/cvt:Id	Ljava/lang/String;
    //   1908: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1911: ldc_w 1245
    //   1914: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1917: aload 6
    //   1919: getfield 1248	com/tencent/mm/protocal/protobuf/cvt:Url	Ljava/lang/String;
    //   1922: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1925: ldc_w 1245
    //   1928: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1931: aload 6
    //   1933: getfield 1251	com/tencent/mm/protocal/protobuf/cvt:TDF	Ljava/lang/String;
    //   1936: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1939: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1942: invokestatic 1253	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1945: aload 7
    //   1947: aload 6
    //   1949: invokevirtual 1211	com/tencent/mm/plugin/sns/model/g:z	(Lcom/tencent/mm/protocal/protobuf/cvt;)V
    //   1952: aload 8
    //   1954: getfield 655	com/tencent/mm/plugin/sns/ui/av:JAL	Landroid/widget/ImageView;
    //   1957: iconst_0
    //   1958: invokevirtual 339	android/widget/ImageView:setVisibility	(I)V
    //   1961: aload 8
    //   1963: getfield 664	com/tencent/mm/plugin/sns/ui/av:KKn	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1966: bipush 8
    //   1968: invokevirtual 1049	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   1971: aload 8
    //   1973: getfield 655	com/tencent/mm/plugin/sns/ui/av:JAL	Landroid/widget/ImageView;
    //   1976: aload_0
    //   1977: getfield 140	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   1980: getstatic 1214	com/tencent/mm/plugin/sns/i$i:shortvideo_play_btn	I
    //   1983: invokestatic 1218	com/tencent/mm/ci/a:m	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   1986: invokevirtual 1221	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1989: aload 8
    //   1991: getfield 655	com/tencent/mm/plugin/sns/ui/av:JAL	Landroid/widget/ImageView;
    //   1994: aload_0
    //   1995: getfield 140	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   1998: invokevirtual 146	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2001: getstatic 1224	com/tencent/mm/plugin/sns/i$j:play_sight_desc	I
    //   2004: invokevirtual 1227	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2007: invokevirtual 1230	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   2010: goto -928 -> 1082
    //   2013: aload 7
    //   2015: aload 6
    //   2017: invokevirtual 1255	com/tencent/mm/plugin/sns/model/g:w	(Lcom/tencent/mm/protocal/protobuf/cvt;)Z
    //   2020: ifeq +26 -> 2046
    //   2023: aload 8
    //   2025: getfield 655	com/tencent/mm/plugin/sns/ui/av:JAL	Landroid/widget/ImageView;
    //   2028: bipush 8
    //   2030: invokevirtual 339	android/widget/ImageView:setVisibility	(I)V
    //   2033: aload 8
    //   2035: getfield 664	com/tencent/mm/plugin/sns/ui/av:KKn	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   2038: bipush 8
    //   2040: invokevirtual 1049	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   2043: goto -167 -> 1876
    //   2046: aload 7
    //   2048: aload_0
    //   2049: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   2052: aconst_null
    //   2053: invokevirtual 1099	com/tencent/mm/plugin/sns/model/g:b	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;[I)I
    //   2056: iconst_5
    //   2057: if_icmpgt +26 -> 2083
    //   2060: aload 8
    //   2062: getfield 655	com/tencent/mm/plugin/sns/ui/av:JAL	Landroid/widget/ImageView;
    //   2065: bipush 8
    //   2067: invokevirtual 339	android/widget/ImageView:setVisibility	(I)V
    //   2070: aload 8
    //   2072: getfield 664	com/tencent/mm/plugin/sns/ui/av:KKn	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   2075: bipush 8
    //   2077: invokevirtual 1049	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   2080: goto -204 -> 1876
    //   2083: aload 7
    //   2085: aload 6
    //   2087: invokevirtual 1211	com/tencent/mm/plugin/sns/model/g:z	(Lcom/tencent/mm/protocal/protobuf/cvt;)V
    //   2090: aload 8
    //   2092: getfield 655	com/tencent/mm/plugin/sns/ui/av:JAL	Landroid/widget/ImageView;
    //   2095: iconst_0
    //   2096: invokevirtual 339	android/widget/ImageView:setVisibility	(I)V
    //   2099: aload 8
    //   2101: getfield 664	com/tencent/mm/plugin/sns/ui/av:KKn	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   2104: bipush 8
    //   2106: invokevirtual 1049	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   2109: aload 8
    //   2111: getfield 655	com/tencent/mm/plugin/sns/ui/av:JAL	Landroid/widget/ImageView;
    //   2114: aload_0
    //   2115: getfield 140	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   2118: getstatic 1214	com/tencent/mm/plugin/sns/i$i:shortvideo_play_btn	I
    //   2121: invokestatic 1218	com/tencent/mm/ci/a:m	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   2124: invokevirtual 1221	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2127: aload 8
    //   2129: getfield 655	com/tencent/mm/plugin/sns/ui/av:JAL	Landroid/widget/ImageView;
    //   2132: aload_0
    //   2133: getfield 140	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   2136: invokevirtual 146	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2139: getstatic 1224	com/tencent/mm/plugin/sns/i$j:play_sight_desc	I
    //   2142: invokevirtual 1227	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2145: invokevirtual 1230	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   2148: goto -272 -> 1876
    //   2151: aload 7
    //   2153: aload_0
    //   2154: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   2157: aload 6
    //   2159: aload 8
    //   2161: getfield 646	com/tencent/mm/plugin/sns/ui/av:KKk	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   2164: aload_0
    //   2165: getfield 140	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   2168: invokevirtual 891	java/lang/Object:hashCode	()I
    //   2171: iconst_0
    //   2172: getstatic 897	com/tencent/mm/storage/bp:VGo	Lcom/tencent/mm/storage/bp;
    //   2175: iconst_1
    //   2176: iconst_1
    //   2177: invokevirtual 1258	com/tencent/mm/plugin/sns/model/g:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/protocal/protobuf/cvt;Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;IILcom/tencent/mm/storage/bp;ZZ)Z
    //   2180: pop
    //   2181: goto -1006 -> 1175
    //   2184: aload_0
    //   2185: getfield 119	com/tencent/mm/plugin/sns/ui/c/a/c:KPn	Lcom/tencent/mm/plugin/sns/ad/f/l;
    //   2188: aload_0
    //   2189: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/c:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   2192: getfield 824	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   2195: aload 6
    //   2197: getfield 1081	com/tencent/mm/protocal/protobuf/cvt:TDZ	F
    //   2200: f2i
    //   2201: iconst_0
    //   2202: invokevirtual 1084	com/tencent/mm/plugin/sns/ad/f/l:f	(JIZ)V
    //   2205: goto -904 -> 1301
    //   2208: iconst_0
    //   2209: istore 5
    //   2211: goto -892 -> 1319
    //   2214: ldc_w 439
    //   2217: new 423	java/lang/StringBuilder
    //   2220: dup
    //   2221: ldc_w 1260
    //   2224: invokespecial 428	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2227: aload_0
    //   2228: getfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   2231: invokevirtual 891	java/lang/Object:hashCode	()I
    //   2234: invokevirtual 1163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2237: ldc_w 1262
    //   2240: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2243: aload_0
    //   2244: getfield 815	com/tencent/mm/plugin/sns/ui/c/a/c:Ljr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   2247: getfield 1267	com/tencent/mm/plugin/sns/ui/OnlineVideoView:wTx	Z
    //   2250: invokevirtual 432	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2253: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2256: invokestatic 447	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2259: goto -733 -> 1526
    //   2262: aload 8
    //   2264: getfield 646	com/tencent/mm/plugin/sns/ui/av:KKk	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   2267: invokevirtual 1270	com/tencent/mm/pluginsdk/ui/tools/VideoSightView:start	()Z
    //   2270: pop
    //   2271: aload_0
    //   2272: iconst_1
    //   2273: putfield 105	com/tencent/mm/plugin/sns/ui/c/a/c:Ljt	Z
    //   2276: goto -1893 -> 383
    //   2279: aload 7
    //   2281: aload_0
    //   2282: getfield 624	com/tencent/mm/plugin/sns/ui/c/a/c:JKG	Lcom/tencent/mm/plugin/sns/ui/av;
    //   2285: getfield 646	com/tencent/mm/plugin/sns/ui/av:KKk	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   2288: aload_0
    //   2289: getfield 140	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   2292: invokevirtual 891	java/lang/Object:hashCode	()I
    //   2295: iconst_0
    //   2296: invokevirtual 1273	com/tencent/mm/plugin/sns/model/g:a	(Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;II)Z
    //   2299: pop
    //   2300: aload_0
    //   2301: getfield 624	com/tencent/mm/plugin/sns/ui/c/a/c:JKG	Lcom/tencent/mm/plugin/sns/ui/av;
    //   2304: getfield 670	com/tencent/mm/plugin/sns/ui/av:KKo	Landroid/widget/TextView;
    //   2307: bipush 8
    //   2309: invokevirtual 563	android/widget/TextView:setVisibility	(I)V
    //   2312: aload_0
    //   2313: getfield 624	com/tencent/mm/plugin/sns/ui/c/a/c:JKG	Lcom/tencent/mm/plugin/sns/ui/av;
    //   2316: getfield 646	com/tencent/mm/plugin/sns/ui/av:KKk	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   2319: aconst_null
    //   2320: invokevirtual 1277	com/tencent/mm/pluginsdk/ui/tools/VideoSightView:setOnSightCompletionAction	(Lcom/tencent/mm/plugin/sight/decode/a/b$g;)V
    //   2323: aload_0
    //   2324: getfield 624	com/tencent/mm/plugin/sns/ui/c/a/c:JKG	Lcom/tencent/mm/plugin/sns/ui/av;
    //   2327: getfield 646	com/tencent/mm/plugin/sns/ui/av:KKk	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   2330: aconst_null
    //   2331: invokevirtual 1008	com/tencent/mm/pluginsdk/ui/tools/VideoSightView:setOnCompletionListener	(Lcom/tencent/mm/plugin/sight/decode/a/b$e;)V
    //   2334: aload_0
    //   2335: getfield 624	com/tencent/mm/plugin/sns/ui/c/a/c:JKG	Lcom/tencent/mm/plugin/sns/ui/av;
    //   2338: getfield 646	com/tencent/mm/plugin/sns/ui/av:KKk	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   2341: aconst_null
    //   2342: invokevirtual 1013	com/tencent/mm/pluginsdk/ui/tools/VideoSightView:setOnDecodeDurationListener	(Lcom/tencent/mm/plugin/sight/decode/a/b$f;)V
    //   2345: goto -1962 -> 383
    //   2348: aload_0
    //   2349: getfield 321	com/tencent/mm/plugin/sns/ui/c/a/c:Ljk	Landroid/view/View;
    //   2352: bipush 8
    //   2354: invokevirtual 291	android/view/View:setVisibility	(I)V
    //   2357: goto -1875 -> 482
    //   2360: iconst_1
    //   2361: istore_1
    //   2362: goto -1847 -> 515
    //   2365: aload_0
    //   2366: getfield 1279	com/tencent/mm/plugin/sns/ui/c/a/c:Ljq	Lcom/tencent/mm/plugin/sns/ad/widget/living/c;
    //   2369: ifnonnull +26 -> 2395
    //   2372: aload_0
    //   2373: new 1281	com/tencent/mm/plugin/sns/ad/widget/living/c
    //   2376: dup
    //   2377: aload_0
    //   2378: getfield 932	com/tencent/mm/plugin/sns/ui/c/a/c:JKI	Landroid/view/ViewGroup;
    //   2381: aload_0
    //   2382: getfield 937	com/tencent/mm/plugin/sns/ui/c/a/c:Ljp	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   2385: aload_0
    //   2386: getfield 914	com/tencent/mm/plugin/sns/ui/c/a/c:Ljn	Lcom/tencent/mm/plugin/sns/ui/ax;
    //   2389: invokespecial 1284	com/tencent/mm/plugin/sns/ad/widget/living/c:<init>	(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;Lcom/tencent/mm/plugin/sns/ui/ax;)V
    //   2392: putfield 1279	com/tencent/mm/plugin/sns/ui/c/a/c:Ljq	Lcom/tencent/mm/plugin/sns/ad/widget/living/c;
    //   2395: aload 7
    //   2397: ifnull -1770 -> 627
    //   2400: aload_0
    //   2401: getfield 1279	com/tencent/mm/plugin/sns/ui/c/a/c:Ljq	Lcom/tencent/mm/plugin/sns/ad/widget/living/c;
    //   2404: ifnull -1777 -> 627
    //   2407: aload 6
    //   2409: invokevirtual 183	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   2412: getfield 926	com/tencent/mm/plugin/sns/storage/ADXml:adLiveInfo	Lcom/tencent/mm/plugin/sns/ad/adxml/g;
    //   2415: astore 8
    //   2417: aload 7
    //   2419: getfield 796	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   2422: aload 8
    //   2424: getfield 1289	com/tencent/mm/plugin/sns/ad/adxml/g:liveType	I
    //   2427: invokestatic 1295	com/tencent/mm/plugin/sns/ad/widget/living/b:fX	(Ljava/lang/String;I)I
    //   2430: istore_1
    //   2431: aload_0
    //   2432: getfield 1279	com/tencent/mm/plugin/sns/ui/c/a/c:Ljq	Lcom/tencent/mm/plugin/sns/ad/widget/living/c;
    //   2435: aload 7
    //   2437: getfield 796	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   2440: aload 8
    //   2442: invokevirtual 1298	com/tencent/mm/plugin/sns/ad/widget/living/c:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/sns/ad/adxml/g;)V
    //   2445: aload_0
    //   2446: getfield 1279	com/tencent/mm/plugin/sns/ui/c/a/c:Ljq	Lcom/tencent/mm/plugin/sns/ad/widget/living/c;
    //   2449: iload_1
    //   2450: invokevirtual 1301	com/tencent/mm/plugin/sns/ad/widget/living/c:setLiveStatus	(I)V
    //   2453: aload 7
    //   2455: getfield 796	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   2458: aload_0
    //   2459: getfield 1279	com/tencent/mm/plugin/sns/ui/c/a/c:Ljq	Lcom/tencent/mm/plugin/sns/ad/widget/living/c;
    //   2462: invokestatic 1304	com/tencent/mm/plugin/sns/ad/widget/living/b:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/sns/ad/widget/living/b$a;)V
    //   2465: invokestatic 1310	com/tencent/mm/plugin/sns/ad/timeline/dynamic/a:fLk	()Lcom/tencent/mm/plugin/sns/ad/timeline/dynamic/a;
    //   2468: iconst_1
    //   2469: aload 6
    //   2471: invokevirtual 1313	com/tencent/mm/plugin/sns/ad/timeline/dynamic/a:b	(ILcom/tencent/mm/plugin/sns/storage/SnsInfo;)V
    //   2474: iload_1
    //   2475: invokestatic 1317	com/tencent/mm/plugin/sns/ad/widget/living/c:afn	(I)Z
    //   2478: istore 5
    //   2480: aload 7
    //   2482: getfield 796	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   2485: astore 6
    //   2487: aload 8
    //   2489: iload 5
    //   2491: invokestatic 1322	com/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper:a	(Lcom/tencent/mm/plugin/sns/ad/adxml/g;Z)Z
    //   2494: ifeq +84 -> 2578
    //   2497: aload_0
    //   2498: getfield 1324	com/tencent/mm/plugin/sns/ui/c/a/c:JKK	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   2501: ifnonnull +17 -> 2518
    //   2504: aload_0
    //   2505: aload_0
    //   2506: getfield 775	com/tencent/mm/plugin/sns/ui/c/a/c:JKJ	Landroid/view/ViewStub;
    //   2509: invokevirtual 1327	android/view/ViewStub:inflate	()Landroid/view/View;
    //   2512: checkcast 1319	com/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper
    //   2515: putfield 1324	com/tencent/mm/plugin/sns/ui/c/a/c:JKK	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   2518: aload_0
    //   2519: getfield 1324	com/tencent/mm/plugin/sns/ui/c/a/c:JKK	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   2522: ifnull -1895 -> 627
    //   2525: new 18	com/tencent/mm/plugin/sns/ui/c/a/c$7
    //   2528: dup
    //   2529: aload_0
    //   2530: aload 8
    //   2532: aload 6
    //   2534: invokespecial 1330	com/tencent/mm/plugin/sns/ui/c/a/c$7:<init>	(Lcom/tencent/mm/plugin/sns/ui/c/a/c;Lcom/tencent/mm/plugin/sns/ad/adxml/g;Ljava/lang/String;)V
    //   2537: ldc2_w 1331
    //   2540: invokestatic 1338	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThreadDelayed	(Ljava/lang/Runnable;J)V
    //   2543: goto -1916 -> 627
    //   2546: astore 6
    //   2548: ldc_w 439
    //   2551: new 423	java/lang/StringBuilder
    //   2554: dup
    //   2555: ldc_w 1340
    //   2558: invokespecial 428	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2561: aload 6
    //   2563: invokestatic 1346	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2566: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2569: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2572: invokestatic 805	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2575: goto -1948 -> 627
    //   2578: aload_0
    //   2579: getfield 1324	com/tencent/mm/plugin/sns/ui/c/a/c:JKK	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   2582: ifnull -1955 -> 627
    //   2585: aload_0
    //   2586: getfield 1324	com/tencent/mm/plugin/sns/ui/c/a/c:JKK	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   2589: bipush 8
    //   2591: invokevirtual 1347	com/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper:setVisibility	(I)V
    //   2594: goto -1967 -> 627
    //   2597: aload_0
    //   2598: getfield 932	com/tencent/mm/plugin/sns/ui/c/a/c:JKI	Landroid/view/ViewGroup;
    //   2601: ifnull +12 -> 2613
    //   2604: aload_0
    //   2605: getfield 932	com/tencent/mm/plugin/sns/ui/c/a/c:JKI	Landroid/view/ViewGroup;
    //   2608: bipush 8
    //   2610: invokevirtual 1348	android/view/ViewGroup:setVisibility	(I)V
    //   2613: aload_0
    //   2614: getfield 937	com/tencent/mm/plugin/sns/ui/c/a/c:Ljp	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   2617: ifnull +12 -> 2629
    //   2620: aload_0
    //   2621: getfield 937	com/tencent/mm/plugin/sns/ui/c/a/c:Ljp	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   2624: bipush 8
    //   2626: invokevirtual 1349	com/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout:setVisibility	(I)V
    //   2629: aload_0
    //   2630: getfield 1324	com/tencent/mm/plugin/sns/ui/c/a/c:JKK	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   2633: ifnull -2006 -> 627
    //   2636: aload_0
    //   2637: getfield 1324	com/tencent/mm/plugin/sns/ui/c/a/c:JKK	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   2640: bipush 8
    //   2642: invokevirtual 1347	com/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper:setVisibility	(I)V
    //   2645: goto -2018 -> 627
    //   2648: aload 6
    //   2650: invokevirtual 183	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   2653: getfield 948	com/tencent/mm/plugin/sns/storage/ADXml:adPromotionInfo	Lcom/tencent/mm/plugin/sns/ad/adxml/h;
    //   2656: astore 7
    //   2658: aload 7
    //   2660: ifnull +66 -> 2726
    //   2663: aload 7
    //   2665: getfield 990	com/tencent/mm/plugin/sns/ad/adxml/h:startTime	J
    //   2668: aload 7
    //   2670: getfield 993	com/tencent/mm/plugin/sns/ad/adxml/h:endTime	J
    //   2673: invokestatic 1355	com/tencent/mm/plugin/sns/ad/i/f:aA	(JJ)Z
    //   2676: ifeq +50 -> 2726
    //   2679: iconst_1
    //   2680: istore_1
    //   2681: goto -2032 -> 649
    //   2684: aload_0
    //   2685: getfield 950	com/tencent/mm/plugin/sns/ui/c/a/c:Ljl	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   2688: ifnull +12 -> 2700
    //   2691: aload_0
    //   2692: getfield 950	com/tencent/mm/plugin/sns/ui/c/a/c:Ljl	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   2695: bipush 8
    //   2697: invokevirtual 956	com/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout:setVisibility	(I)V
    //   2700: ldc_w 838
    //   2703: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2706: return
    //   2707: astore 6
    //   2709: ldc_w 838
    //   2712: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2715: return
    //   2716: iconst_0
    //   2717: istore_1
    //   2718: goto -2203 -> 515
    //   2721: iconst_0
    //   2722: istore_1
    //   2723: goto -2074 -> 649
    //   2726: iconst_0
    //   2727: istore_1
    //   2728: goto -2079 -> 649
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2731	0	this	c
    //   213	2515	1	i	int
    //   235	1114	2	j	int
    //   980	32	3	l	long
    //   986	1504	5	bool	boolean
    //   152	2381	6	localObject1	Object
    //   2546	103	6	localThrowable1	Throwable
    //   2707	1	6	localThrowable2	Throwable
    //   107	2562	7	localObject2	Object
    //   546	1985	8	localObject3	Object
    //   1200	15	9	str	String
    // Exception table:
    //   from	to	target	type
    //   493	512	2546	java/lang/Throwable
    //   519	548	2546	java/lang/Throwable
    //   553	565	2546	java/lang/Throwable
    //   565	587	2546	java/lang/Throwable
    //   592	604	2546	java/lang/Throwable
    //   604	618	2546	java/lang/Throwable
    //   618	627	2546	java/lang/Throwable
    //   2365	2395	2546	java/lang/Throwable
    //   2400	2518	2546	java/lang/Throwable
    //   2518	2543	2546	java/lang/Throwable
    //   2578	2594	2546	java/lang/Throwable
    //   2597	2613	2546	java/lang/Throwable
    //   2613	2629	2546	java/lang/Throwable
    //   2629	2645	2546	java/lang/Throwable
    //   638	646	2707	java/lang/Throwable
    //   653	685	2707	java/lang/Throwable
    //   690	702	2707	java/lang/Throwable
    //   702	785	2707	java/lang/Throwable
    //   785	791	2707	java/lang/Throwable
    //   2648	2658	2707	java/lang/Throwable
    //   2663	2679	2707	java/lang/Throwable
    //   2684	2700	2707	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.c
 * JD-Core Version:    0.7.0.1
 */