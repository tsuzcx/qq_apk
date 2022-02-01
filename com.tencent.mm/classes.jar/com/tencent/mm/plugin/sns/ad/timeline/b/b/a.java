package com.tencent.mm.plugin.sns.ad.timeline.b.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.ad.d.n;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.ad.timeline.helper.b;
import com.tencent.mm.plugin.sns.ad.widget.adsocial.AdAttitudePlayView;
import com.tencent.mm.plugin.sns.ad.widget.adsocial.AdSocialAttitudeView;
import com.tencent.mm.plugin.sns.ad.widget.living.FinderLivingAnimWrapper;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView.b;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdBreakFrameVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdCardVideoEndView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.smiley.u;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

public final class a
{
  private static boolean QbT = false;
  protected SnsInfo PJQ;
  protected b QbM;
  protected ADXml.g QbN;
  protected l QbO;
  protected TimeLineObject QbP;
  public com.tencent.mm.plugin.sns.ui.item.a.a.a.c QbQ;
  private com.tencent.mm.plugin.sns.ad.widget.living.c QbR;
  public c QbS;
  protected Context mContext;
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(311229);
    if (paramb != null) {}
    try
    {
      if (paramb.Qcs != null)
      {
        paramb.Qcv = ((ViewStub)paramb.Qcs.findViewById(b.f.sns_ad_attitude_play_stub));
        paramb.Qct = ((ViewStub)paramb.Qcs.findViewById(b.f.show_ad_attitude));
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(311229);
    }
  }
  
  public static void ajL(int paramInt)
  {
    AppMethodBeat.i(311266);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yIq, 0);
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        QbT = bool;
        Log.i("FullCardAdWrapper", "updateFullCardExptCfg, expt=" + i + ", snene=" + paramInt);
        if (paramInt == 1) {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1697, 21);
        }
        AppMethodBeat.o(311266);
        return;
      }
      return;
    }
    finally
    {
      Log.e("FullCardAdWrapper", "updateAbTestCfg, exp=" + localObject.toString());
      AppMethodBeat.o(311266);
    }
  }
  
  public static boolean e(ADXml paramADXml)
  {
    AppMethodBeat.i(311257);
    if ((paramADXml != null) && (paramADXml.isLongPressGestureAd()))
    {
      Log.i("FullCardAdWrapper", "fullcard useOnlineVideoView false, longPressAd disable");
      AppMethodBeat.o(311257);
      return false;
    }
    if ((paramADXml != null) && (paramADXml.isAdBreakFrameVideo()))
    {
      Log.i("FullCardAdWrapper", "fullcard useOnlineVideoView false, isAdBreakFrameVideo disable");
      AppMethodBeat.o(311257);
      return false;
    }
    if (com.tencent.mm.plugin.sns.ad.d.PKV == 1)
    {
      Log.i("FullCardAdWrapper", "fullcard useOnlineVideoView false, force offline");
      AppMethodBeat.o(311257);
      return false;
    }
    if (com.tencent.mm.plugin.sns.ad.d.PKV == 2)
    {
      Log.i("FullCardAdWrapper", "fullcard useOnlineVideoView true, force online");
      AppMethodBeat.o(311257);
      return true;
    }
    if (!hbZ())
    {
      Log.i("FullCardAdWrapper", "fullcard useOnlineVideoView false, expt disable");
      AppMethodBeat.o(311257);
      return false;
    }
    if (!b.b(paramADXml))
    {
      Log.i("FullCardAdWrapper", "fullcard useOnlineVideoView false, adXml StreamingMode disable");
      AppMethodBeat.o(311257);
      return false;
    }
    Log.i("FullCardAdWrapper", "fullcard useOnlineVideoView true");
    AppMethodBeat.o(311257);
    return true;
  }
  
  public static boolean hbZ()
  {
    AppMethodBeat.i(311249);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yIp, 0);
      Log.i("FullCardAdWrapper", "isExptUseOnlineVideoView, expt=".concat(String.valueOf(i)));
      return i > 0;
    }
    finally
    {
      AppMethodBeat.o(311249);
    }
    return true;
  }
  
  public static void hca()
  {
    AppMethodBeat.i(311275);
    ajL(1);
    AppMethodBeat.o(311275);
  }
  
  public static b jj(View paramView)
  {
    AppMethodBeat.i(311224);
    b localb = new b();
    localb.GBf = paramView.findViewById(b.f.top_layer);
    localb.QbY = paramView.findViewById(b.f.bottom_layer);
    localb.Qca = ((TextView)paramView.findViewById(b.f.top_layer_title));
    localb.Qcb = ((TextView)paramView.findViewById(b.f.top_layer_desc));
    localb.Qcc = ((TextView)paramView.findViewById(b.f.bottom_layer_title));
    localb.Qcd = ((TextView)paramView.findViewById(b.f.bottom_layer_desc));
    float f1 = m.akn(b.d.sns_ad_fullcard_title_font_size);
    float f2 = m.akn(b.d.sns_ad_fullcard_desc_font_size);
    localb.Qca.setTextSize(0, f1);
    localb.Qcb.setTextSize(0, f2);
    localb.Qcc.setTextSize(0, f1);
    localb.Qcd.setTextSize(0, f2);
    localb.Qce = paramView.findViewById(b.f.bottom_mini_program);
    localb.Qcf = ((ImageView)paramView.findViewById(b.f.mini_program_icon));
    localb.Qcg = ((TextView)paramView.findViewById(b.f.mini_program_txt));
    localb.QbZ = ((MaskImageView)paramView.findViewById(b.f.full_card_img));
    localb.QbZ.setScaleType(QImageView.a.afVc);
    localb.Qcj = new aw();
    localb.Qcj.RjO = paramView.findViewById(b.f.full_card_video);
    localb.Qcj.RjL = localb.Qcj.RjO;
    localb.Qcj.RjM = ((VideoSightView)localb.Qcj.RjO.findViewById(b.f.image));
    localb.Qcj.RjN = ((SnsAdTimelineVideoView)localb.Qcj.RjO.findViewById(b.f.offline_video));
    localb.Qcj.RjN.setMute(true);
    localb.Qcj.PQu = ((ImageView)paramView.findViewById(b.f.full_card_status_icon));
    localb.Qcj.RjP = ((MMPinProgressBtn)localb.Qcj.RjO.findViewById(b.f.progress));
    localb.Qcj.RjQ = ((TextView)localb.Qcj.RjO.findViewById(b.f.endtv));
    localb.Qcj.QRC = ((TextView)localb.Qcj.RjO.findViewById(b.f.errorTv));
    localb.Qch = ((ImageView)paramView.findViewById(b.f.front_cover));
    localb.Qci = ((ImageView)paramView.findViewById(b.f.end_cover));
    localb.Qcm = ((ViewStub)paramView.findViewById(b.f.ad_live_status_layout_stub));
    localb.Qco = ((ViewStub)paramView.findViewById(b.f.ad_live_anim_layout_stub));
    localb.Qcq = ((ViewGroup)paramView.findViewById(b.f.full_card_online_video_container));
    AppMethodBeat.o(311224);
    return localb;
  }
  
  private static void n(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(311238);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams != null) && ((localLayoutParams.width != paramInt1) || (localLayoutParams.height != paramInt2)))
    {
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      paramView.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(311238);
  }
  
  public final void Dh(boolean paramBoolean)
  {
    AppMethodBeat.i(311390);
    if ((this.PJQ != null) && (this.PJQ.isBreakFrameAd()) && (this.QbQ != null))
    {
      this.QbQ.Dh(paramBoolean);
      AppMethodBeat.o(311390);
      return;
    }
    Log.i("FullCardAdWrapper", "startPlay, onlineVideo=".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      if (this.QbM.Qcr != null)
      {
        if ((this.QbM.Qcr.isPlaying()) || (this.QbM.Qcr.aFF()))
        {
          Log.i("FullCardAdWrapper", "onlineVideo, resumePlay, hash=" + hashCode());
          this.QbM.Qcr.bcl();
          AppMethodBeat.o(311390);
          return;
        }
        Log.i("FullCardAdWrapper", "onlineVideo, onResume, hash=" + hashCode());
        this.QbM.Qcr.onResume();
        AppMethodBeat.o(311390);
      }
    }
    else
    {
      this.QbM.Qcj.RjN.setShouldPlayWhenPrepared(true);
      this.QbM.Qcj.RjN.start();
    }
    AppMethodBeat.o(311390);
  }
  
  public final void Dt(boolean paramBoolean)
  {
    AppMethodBeat.i(311372);
    Du(paramBoolean);
    AppMethodBeat.o(311372);
  }
  
  public final void Du(boolean paramBoolean)
  {
    AppMethodBeat.i(311380);
    if ((this.PJQ != null) && (this.PJQ.isBreakFrameAd()) && (this.QbQ != null))
    {
      this.QbQ.Du(paramBoolean);
      AppMethodBeat.o(311380);
      return;
    }
    Log.i("FullCardAdWrapper", "pausePlay, onlineVideo=".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      if ((this.QbM.Qcr != null) && (this.QbM.Qcr.isPlaying()))
      {
        this.QbM.Qcr.bck();
        AppMethodBeat.o(311380);
      }
    }
    else
    {
      this.QbM.Qcj.RjN.setShouldPlayWhenPrepared(false);
      this.QbM.Qcj.RjN.pause();
    }
    AppMethodBeat.o(311380);
  }
  
  public final void Dv(boolean paramBoolean)
  {
    AppMethodBeat.i(311384);
    if ((this.PJQ != null) && (this.PJQ.isBreakFrameAd()) && (this.QbQ != null))
    {
      this.QbQ.Dv(paramBoolean);
      AppMethodBeat.o(311384);
      return;
    }
    Log.i("FullCardAdWrapper", "restartPlay, onlineVideo=".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      if (this.QbM.Qcr != null)
      {
        this.QbM.Qcr.bJ(0, true);
        AppMethodBeat.o(311384);
      }
    }
    else {
      this.QbM.Qcj.RjN.bEH();
    }
    AppMethodBeat.o(311384);
  }
  
  public final void a(b paramb, ADXml.g paramg, SnsInfo paramSnsInfo, TimeLineObject paramTimeLineObject, Context paramContext, l paraml)
  {
    this.QbM = paramb;
    this.QbN = paramg;
    this.PJQ = paramSnsInfo;
    this.mContext = paramContext;
    this.QbO = paraml;
    this.QbP = paramTimeLineObject;
  }
  
  /* Error */
  public final void a(com.tencent.mm.protocal.protobuf.dmz paramdmz, com.tencent.mm.plugin.sns.model.g paramg, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 519
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 430	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   10: getfield 523	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   13: lstore 7
    //   15: aload_0
    //   16: getfield 517	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbP	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   19: getfield 529	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   22: getfield 534	com/tencent/mm/protocal/protobuf/agh:Zpq	I
    //   25: iconst_1
    //   26: if_icmpne +370 -> 396
    //   29: aload_0
    //   30: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   33: getfield 299	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:QbZ	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
    //   36: iconst_0
    //   37: invokevirtual 537	com/tencent/mm/plugin/sns/ui/MaskImageView:setVisibility	(I)V
    //   40: aload_0
    //   41: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   44: getfield 316	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   47: getfield 325	com/tencent/mm/plugin/sns/ui/aw:RjL	Landroid/view/View;
    //   50: iconst_4
    //   51: invokevirtual 538	android/view/View:setVisibility	(I)V
    //   54: aload_0
    //   55: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   58: getfield 299	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:QbZ	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
    //   61: astore 11
    //   63: aload_0
    //   64: getfield 513	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:mContext	Landroid/content/Context;
    //   67: invokevirtual 466	java/lang/Object:hashCode	()I
    //   70: istore_3
    //   71: invokestatic 544	com/tencent/mm/storage/br:jbh	()Lcom/tencent/mm/storage/br;
    //   74: astore 12
    //   76: aload 12
    //   78: aload_0
    //   79: getfield 517	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbP	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   82: getfield 547	com/tencent/mm/protocal/protobuf/TimeLineObject:CreateTime	I
    //   85: putfield 550	com/tencent/mm/storage/br:time	I
    //   88: aload_2
    //   89: aload_1
    //   90: aload 11
    //   92: iconst_m1
    //   93: iload_3
    //   94: aload 12
    //   96: invokevirtual 555	com/tencent/mm/plugin/sns/model/g:b	(Lcom/tencent/mm/protocal/protobuf/dmz;Landroid/view/View;IILcom/tencent/mm/storage/br;)Z
    //   99: pop
    //   100: aload_0
    //   101: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   104: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcx	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$a;
    //   107: iconst_0
    //   108: putfield 562	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$a:QbV	Z
    //   111: aload_0
    //   112: getfield 430	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   115: astore_2
    //   116: aload_2
    //   117: ifnull +2200 -> 2317
    //   120: aload_2
    //   121: invokevirtual 566	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   124: ifnull +2193 -> 2317
    //   127: aload_2
    //   128: invokevirtual 566	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   131: getfield 570	com/tencent/mm/plugin/sns/storage/ADXml:adLiveInfo	Lcom/tencent/mm/plugin/sns/ad/adxml/i;
    //   134: ifnonnull +2065 -> 2199
    //   137: goto +2180 -> 2317
    //   140: iload_3
    //   141: ifeq +2125 -> 2266
    //   144: aload_2
    //   145: invokevirtual 574	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   148: astore 11
    //   150: aload_0
    //   151: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   154: getfield 577	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcn	Landroid/view/ViewGroup;
    //   157: ifnonnull +23 -> 180
    //   160: aload_0
    //   161: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   164: aload_0
    //   165: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   168: getfield 392	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcm	Landroid/view/ViewStub;
    //   171: invokevirtual 581	android/view/ViewStub:inflate	()Landroid/view/View;
    //   174: checkcast 403	android/view/ViewGroup
    //   177: putfield 577	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcn	Landroid/view/ViewGroup;
    //   180: aload_0
    //   181: getfield 583	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbR	Lcom/tencent/mm/plugin/sns/ad/widget/living/c;
    //   184: ifnonnull +23 -> 207
    //   187: aload_0
    //   188: new 585	com/tencent/mm/plugin/sns/ad/widget/living/c
    //   191: dup
    //   192: aload_0
    //   193: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   196: getfield 577	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcn	Landroid/view/ViewGroup;
    //   199: aconst_null
    //   200: aconst_null
    //   201: invokespecial 588	com/tencent/mm/plugin/sns/ad/widget/living/c:<init>	(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;Lcom/tencent/mm/plugin/sns/ui/ay;)V
    //   204: putfield 583	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbR	Lcom/tencent/mm/plugin/sns/ad/widget/living/c;
    //   207: aload 11
    //   209: ifnull +2017 -> 2226
    //   212: aload_0
    //   213: getfield 583	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbR	Lcom/tencent/mm/plugin/sns/ad/widget/living/c;
    //   216: ifnull +2010 -> 2226
    //   219: aload_2
    //   220: invokevirtual 566	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   223: getfield 570	com/tencent/mm/plugin/sns/storage/ADXml:adLiveInfo	Lcom/tencent/mm/plugin/sns/ad/adxml/i;
    //   226: astore_1
    //   227: aload 11
    //   229: getfield 592	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   232: aload_1
    //   233: getfield 597	com/tencent/mm/plugin/sns/ad/adxml/i:liveType	I
    //   236: invokestatic 603	com/tencent/mm/plugin/sns/ad/widget/living/b:gQ	(Ljava/lang/String;I)I
    //   239: istore_3
    //   240: aload_0
    //   241: getfield 583	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbR	Lcom/tencent/mm/plugin/sns/ad/widget/living/c;
    //   244: aload 11
    //   246: getfield 592	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   249: aload_1
    //   250: invokevirtual 606	com/tencent/mm/plugin/sns/ad/widget/living/c:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/sns/ad/adxml/i;)V
    //   253: aload_0
    //   254: getfield 583	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbR	Lcom/tencent/mm/plugin/sns/ad/widget/living/c;
    //   257: iload_3
    //   258: invokevirtual 609	com/tencent/mm/plugin/sns/ad/widget/living/c:setLiveStatus	(I)V
    //   261: aload 11
    //   263: getfield 592	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   266: aload_0
    //   267: getfield 583	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbR	Lcom/tencent/mm/plugin/sns/ad/widget/living/c;
    //   270: invokestatic 612	com/tencent/mm/plugin/sns/ad/widget/living/b:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/sns/ad/widget/living/b$a;)V
    //   273: invokestatic 618	com/tencent/mm/plugin/sns/ad/timeline/dynamic/a:hbB	()Lcom/tencent/mm/plugin/sns/ad/timeline/dynamic/a;
    //   276: iconst_0
    //   277: aload_2
    //   278: invokevirtual 622	com/tencent/mm/plugin/sns/ad/timeline/dynamic/a:d	(ILcom/tencent/mm/plugin/sns/storage/SnsInfo;)V
    //   281: iload_3
    //   282: invokestatic 626	com/tencent/mm/plugin/sns/ad/widget/living/c:ajZ	(I)Z
    //   285: istore 4
    //   287: aload 11
    //   289: getfield 592	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   292: astore_2
    //   293: aload_1
    //   294: iload 4
    //   296: invokestatic 631	com/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper:a	(Lcom/tencent/mm/plugin/sns/ad/adxml/i;Z)Z
    //   299: ifeq +1905 -> 2204
    //   302: aload_0
    //   303: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   306: getfield 635	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcp	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   309: ifnonnull +23 -> 332
    //   312: aload_0
    //   313: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   316: aload_0
    //   317: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   320: getfield 398	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qco	Landroid/view/ViewStub;
    //   323: invokevirtual 581	android/view/ViewStub:inflate	()Landroid/view/View;
    //   326: checkcast 628	com/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper
    //   329: putfield 635	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcp	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   332: aload_0
    //   333: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   336: getfield 635	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcp	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   339: ifnull +1887 -> 2226
    //   342: aload_0
    //   343: getfield 513	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:mContext	Landroid/content/Context;
    //   346: bipush 60
    //   348: invokestatic 641	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   351: istore_3
    //   352: aload_0
    //   353: getfield 513	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:mContext	Landroid/content/Context;
    //   356: bipush 35
    //   358: invokestatic 641	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   361: istore 5
    //   363: aload_0
    //   364: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   367: getfield 635	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcp	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   370: aload_1
    //   371: aload_2
    //   372: iload_3
    //   373: iload 5
    //   375: invokevirtual 644	com/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper:a	(Lcom/tencent/mm/plugin/sns/ad/adxml/i;Ljava/lang/String;II)V
    //   378: aload_0
    //   379: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   382: getfield 635	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcp	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   385: iconst_0
    //   386: invokevirtual 645	com/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper:setVisibility	(I)V
    //   389: ldc_w 519
    //   392: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   395: return
    //   396: aload_0
    //   397: getfield 517	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbP	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   400: getfield 529	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   403: getfield 534	com/tencent/mm/protocal/protobuf/agh:Zpq	I
    //   406: bipush 15
    //   408: if_icmpeq +17 -> 425
    //   411: aload_0
    //   412: getfield 517	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbP	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   415: getfield 529	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   418: getfield 534	com/tencent/mm/protocal/protobuf/agh:Zpq	I
    //   421: iconst_5
    //   422: if_icmpne -311 -> 111
    //   425: aload_0
    //   426: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   429: getfield 316	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   432: getfield 343	com/tencent/mm/plugin/sns/ui/aw:RjN	Lcom/tencent/mm/plugin/sns/ui/widget/SnsAdTimelineVideoView;
    //   435: iconst_0
    //   436: invokevirtual 646	com/tencent/mm/plugin/sns/ui/widget/SnsAdTimelineVideoView:setVisibility	(I)V
    //   439: aload_0
    //   440: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   443: getfield 316	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   446: getfield 334	com/tencent/mm/plugin/sns/ui/aw:RjM	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   449: bipush 8
    //   451: invokevirtual 647	com/tencent/mm/pluginsdk/ui/tools/VideoSightView:setVisibility	(I)V
    //   454: aload_0
    //   455: getfield 511	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbN	Lcom/tencent/mm/plugin/sns/storage/ADXml$g;
    //   458: ifnull +37 -> 495
    //   461: aload_0
    //   462: getfield 511	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbN	Lcom/tencent/mm/plugin/sns/storage/ADXml$g;
    //   465: getfield 652	com/tencent/mm/plugin/sns/storage/ADXml$g:QHI	Ljava/lang/String;
    //   468: aload_0
    //   469: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   472: getfield 380	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qch	Landroid/widget/ImageView;
    //   475: invokestatic 657	com/tencent/mm/plugin/sns/ad/timeline/helper/f:n	(Ljava/lang/String;Landroid/widget/ImageView;)V
    //   478: aload_0
    //   479: getfield 511	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbN	Lcom/tencent/mm/plugin/sns/storage/ADXml$g;
    //   482: getfield 660	com/tencent/mm/plugin/sns/storage/ADXml$g:QHK	Ljava/lang/String;
    //   485: aload_0
    //   486: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   489: getfield 386	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qci	Landroid/widget/ImageView;
    //   492: invokestatic 657	com/tencent/mm/plugin/sns/ad/timeline/helper/f:n	(Ljava/lang/String;Landroid/widget/ImageView;)V
    //   495: aload_0
    //   496: getfield 430	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   499: aload_1
    //   500: invokestatic 665	com/tencent/mm/plugin/sns/ad/d/e:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/protocal/protobuf/dmz;)V
    //   503: invokestatic 671	java/lang/System:nanoTime	()J
    //   506: lstore 9
    //   508: aload_1
    //   509: invokestatic 675	com/tencent/mm/plugin/sns/model/g:u	(Lcom/tencent/mm/protocal/protobuf/dmz;)Z
    //   512: istore 6
    //   514: invokestatic 671	java/lang/System:nanoTime	()J
    //   517: lload 9
    //   519: lsub
    //   520: lstore 9
    //   522: ldc 108
    //   524: ldc_w 677
    //   527: iconst_2
    //   528: anewarray 4	java/lang/Object
    //   531: dup
    //   532: iconst_0
    //   533: iload 6
    //   535: invokestatic 682	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   538: aastore
    //   539: dup
    //   540: iconst_1
    //   541: lload 9
    //   543: invokestatic 687	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   546: aastore
    //   547: invokestatic 690	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   550: aload_0
    //   551: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   554: getfield 316	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   557: astore 11
    //   559: iload 6
    //   561: ifne +860 -> 1421
    //   564: aload_2
    //   565: aload_1
    //   566: invokevirtual 693	com/tencent/mm/plugin/sns/model/g:x	(Lcom/tencent/mm/protocal/protobuf/dmz;)Z
    //   569: ifeq +678 -> 1247
    //   572: aload 11
    //   574: getfield 353	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   577: bipush 8
    //   579: invokevirtual 694	android/widget/ImageView:setVisibility	(I)V
    //   582: aload 11
    //   584: getfield 362	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   587: iconst_0
    //   588: invokevirtual 695	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   591: aload 11
    //   593: getfield 362	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   596: invokevirtual 698	com/tencent/mm/ui/widget/MMPinProgressBtn:jEN	()V
    //   599: aload_0
    //   600: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   603: getfield 299	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:QbZ	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
    //   606: iconst_4
    //   607: invokevirtual 537	com/tencent/mm/plugin/sns/ui/MaskImageView:setVisibility	(I)V
    //   610: aload 11
    //   612: getfield 343	com/tencent/mm/plugin/sns/ui/aw:RjN	Lcom/tencent/mm/plugin/sns/ui/widget/SnsAdTimelineVideoView;
    //   615: aload 11
    //   617: invokevirtual 702	com/tencent/mm/plugin/sns/ui/widget/SnsAdTimelineVideoView:setTag	(Ljava/lang/Object;)V
    //   620: aload_0
    //   621: getfield 511	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbN	Lcom/tencent/mm/plugin/sns/storage/ADXml$g;
    //   624: iconst_0
    //   625: aload_0
    //   626: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   629: getfield 380	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qch	Landroid/widget/ImageView;
    //   632: aload_0
    //   633: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   636: getfield 386	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qci	Landroid/widget/ImageView;
    //   639: invokestatic 705	com/tencent/mm/plugin/sns/ad/timeline/helper/f:a	(Lcom/tencent/mm/plugin/sns/storage/ADXml$g;ILandroid/widget/ImageView;Landroid/widget/ImageView;)V
    //   642: invokestatic 710	com/tencent/mm/plugin/sns/model/al:getAccSnsPath	()Ljava/lang/String;
    //   645: aload_1
    //   646: getfield 713	com/tencent/mm/protocal/protobuf/dmz:Id	Ljava/lang/String;
    //   649: invokestatic 719	com/tencent/mm/plugin/sns/model/as:mg	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   652: astore 12
    //   654: aload_1
    //   655: invokestatic 724	com/tencent/mm/plugin/sns/data/t:i	(Lcom/tencent/mm/protocal/protobuf/dmz;)Ljava/lang/String;
    //   658: astore 13
    //   660: new 110	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 725	java/lang/StringBuilder:<init>	()V
    //   667: aload 12
    //   669: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: aload 13
    //   674: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: astore 12
    //   682: aload_1
    //   683: getfield 729	com/tencent/mm/protocal/protobuf/dmz:aaTF	F
    //   686: f2i
    //   687: istore_3
    //   688: ldc 108
    //   690: ldc_w 731
    //   693: lload 9
    //   695: invokestatic 734	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   698: invokevirtual 204	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   701: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   704: aload 12
    //   706: invokestatic 740	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   709: ifeq +1199 -> 1908
    //   712: aload_0
    //   713: getfield 515	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbO	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   716: lload 7
    //   718: iload_3
    //   719: iconst_1
    //   720: invokevirtual 746	com/tencent/mm/plugin/sns/ad/g/l:g	(JIZ)V
    //   723: invokestatic 749	com/tencent/mm/plugin/sns/ad/d/e:anH	()Z
    //   726: ifeq +44 -> 770
    //   729: aload 12
    //   731: invokestatic 754	com/tencent/mm/modelvideo/y:isH265Video	(Ljava/lang/String;)Z
    //   734: istore 6
    //   736: ldc 108
    //   738: new 110	java/lang/StringBuilder
    //   741: dup
    //   742: ldc_w 756
    //   745: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   748: iload 6
    //   750: invokevirtual 759	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   753: ldc_w 761
    //   756: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: aload 12
    //   761: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   770: invokestatic 765	com/tencent/mm/plugin/sns/model/al:hgy	()Lcom/tencent/mm/plugin/sns/model/g;
    //   773: aload_0
    //   774: getfield 430	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   777: aconst_null
    //   778: invokevirtual 768	com/tencent/mm/plugin/sns/model/g:b	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;[I)I
    //   781: iconst_5
    //   782: if_icmpne +1140 -> 1922
    //   785: iconst_1
    //   786: istore 6
    //   788: aload_0
    //   789: getfield 515	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbO	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   792: lload 7
    //   794: iload 6
    //   796: iconst_0
    //   797: invokevirtual 771	com/tencent/mm/plugin/sns/ad/g/l:e	(JZZ)V
    //   800: iload 4
    //   802: ifeq +1260 -> 2062
    //   805: iconst_0
    //   806: istore_3
    //   807: aload_0
    //   808: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   811: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   814: ifnonnull +1114 -> 1928
    //   817: iconst_1
    //   818: istore_3
    //   819: ldc 108
    //   821: ldc_w 773
    //   824: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   827: iload_3
    //   828: ifeq +259 -> 1087
    //   831: invokestatic 776	java/lang/System:currentTimeMillis	()J
    //   834: lstore 7
    //   836: aload_0
    //   837: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   840: getfield 407	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcq	Landroid/view/ViewGroup;
    //   843: invokestatic 782	com/tencent/mm/plugin/sns/ad/j/l:W	(Landroid/view/ViewGroup;)V
    //   846: aload_0
    //   847: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   850: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   853: ifnull +32 -> 885
    //   856: ldc 108
    //   858: ldc_w 784
    //   861: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   864: aload_0
    //   865: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   868: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   871: invokevirtual 787	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:hmt	()V
    //   874: aload_0
    //   875: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   878: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   881: aconst_null
    //   882: invokevirtual 791	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:setVideoCallback	(Lcom/tencent/mm/plugin/sns/ui/OnlineVideoView$b;)V
    //   885: aload_0
    //   886: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   889: new 454	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView
    //   892: dup
    //   893: aload_0
    //   894: getfield 513	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:mContext	Landroid/content/Context;
    //   897: iconst_0
    //   898: invokespecial 794	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:<init>	(Landroid/content/Context;B)V
    //   901: putfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   904: aload_0
    //   905: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   908: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   911: invokevirtual 797	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:hmy	()V
    //   914: aload_0
    //   915: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   918: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   921: getstatic 803	com/tencent/mm/pluginsdk/ui/i$e:XYN	Lcom/tencent/mm/pluginsdk/ui/i$e;
    //   924: invokevirtual 807	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:setVideoScaleType	(Lcom/tencent/mm/pluginsdk/ui/i$e;)V
    //   927: aload_0
    //   928: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   931: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   934: getstatic 813	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   937: invokevirtual 817	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:setThumbViewScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   940: aload_0
    //   941: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   944: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   947: iconst_1
    //   948: putfield 822	com/tencent/mm/plugin/sns/ui/OnlineVideoView:Rhm	Z
    //   951: aload_0
    //   952: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   955: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   958: invokevirtual 825	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:grj	()V
    //   961: aload_0
    //   962: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   965: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   968: iconst_m1
    //   969: iconst_m1
    //   970: invokestatic 828	com/tencent/mm/plugin/sns/ad/j/l:z	(Landroid/view/View;II)V
    //   973: aload_0
    //   974: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   977: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   980: iconst_1
    //   981: invokestatic 832	com/tencent/mm/plugin/sns/ad/j/l:C	(Landroid/view/View;Z)V
    //   984: aload_0
    //   985: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   988: getfield 407	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcq	Landroid/view/ViewGroup;
    //   991: aload_0
    //   992: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   995: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   998: iconst_m1
    //   999: invokestatic 835	com/tencent/mm/plugin/sns/ad/j/l:b	(Landroid/view/ViewGroup;Landroid/view/View;I)Z
    //   1002: pop
    //   1003: invokestatic 776	java/lang/System:currentTimeMillis	()J
    //   1006: lstore 9
    //   1008: new 110	java/lang/StringBuilder
    //   1011: dup
    //   1012: ldc_w 837
    //   1015: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1018: astore_2
    //   1019: aload_0
    //   1020: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1023: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1026: invokevirtual 840	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:getInnerVideoView	()Landroid/view/View;
    //   1029: astore 12
    //   1031: aload 12
    //   1033: instanceof 842
    //   1036: ifeq +995 -> 2031
    //   1039: iconst_1
    //   1040: istore_3
    //   1041: ldc 108
    //   1043: aload_2
    //   1044: iload_3
    //   1045: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1048: ldc_w 844
    //   1051: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: aload_0
    //   1055: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1058: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1061: invokevirtual 466	java/lang/Object:hashCode	()I
    //   1064: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1067: ldc_w 846
    //   1070: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: lload 9
    //   1075: lload 7
    //   1077: lsub
    //   1078: invokevirtual 849	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1081: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1084: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1087: aload_0
    //   1088: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1091: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1094: iconst_1
    //   1095: invokevirtual 850	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:setMute	(Z)V
    //   1098: aload_0
    //   1099: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1102: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1105: iconst_0
    //   1106: invokevirtual 853	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:setThumbViewVisibility	(I)V
    //   1109: ldc 108
    //   1111: new 110	java/lang/StringBuilder
    //   1114: dup
    //   1115: ldc_w 855
    //   1118: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1121: aload_0
    //   1122: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1125: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1128: invokevirtual 466	java/lang/Object:hashCode	()I
    //   1131: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1134: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1137: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1140: aload_0
    //   1141: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1144: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1147: aload_1
    //   1148: aload_0
    //   1149: getfield 430	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1152: invokevirtual 858	com/tencent/mm/plugin/sns/storage/SnsInfo:getLocalid	()Ljava/lang/String;
    //   1155: aload_0
    //   1156: getfield 430	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1159: invokevirtual 574	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1162: getfield 547	com/tencent/mm/protocal/protobuf/TimeLineObject:CreateTime	I
    //   1165: invokevirtual 861	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:a	(Lcom/tencent/mm/protocal/protobuf/dmz;Ljava/lang/String;I)V
    //   1168: aload_0
    //   1169: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1172: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1175: aload_0
    //   1176: getfield 517	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbP	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1179: getfield 592	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   1182: putfield 864	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:Rcp	Ljava/lang/String;
    //   1185: aload_0
    //   1186: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1189: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1192: invokevirtual 867	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:abandonAudioFocus	()V
    //   1195: aload_0
    //   1196: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1199: getfield 316	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   1202: getfield 325	com/tencent/mm/plugin/sns/ui/aw:RjL	Landroid/view/View;
    //   1205: bipush 8
    //   1207: invokevirtual 538	android/view/View:setVisibility	(I)V
    //   1210: aload_0
    //   1211: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1214: getfield 407	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcq	Landroid/view/ViewGroup;
    //   1217: iconst_0
    //   1218: invokevirtual 868	android/view/ViewGroup:setVisibility	(I)V
    //   1221: iload 4
    //   1223: ifeq +957 -> 2180
    //   1226: aload_0
    //   1227: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1230: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1233: new 6	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$1
    //   1236: dup
    //   1237: aload_0
    //   1238: invokespecial 871	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$1:<init>	(Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a;)V
    //   1241: invokevirtual 791	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:setVideoCallback	(Lcom/tencent/mm/plugin/sns/ui/OnlineVideoView$b;)V
    //   1244: goto -1133 -> 111
    //   1247: aload_2
    //   1248: aload_0
    //   1249: getfield 430	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1252: aconst_null
    //   1253: invokevirtual 768	com/tencent/mm/plugin/sns/model/g:b	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;[I)I
    //   1256: iconst_5
    //   1257: if_icmpne +38 -> 1295
    //   1260: aload_2
    //   1261: aload_1
    //   1262: invokevirtual 875	com/tencent/mm/plugin/sns/model/g:B	(Lcom/tencent/mm/protocal/protobuf/dmz;)V
    //   1265: aload 11
    //   1267: getfield 353	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1270: bipush 8
    //   1272: invokevirtual 694	android/widget/ImageView:setVisibility	(I)V
    //   1275: aload 11
    //   1277: getfield 362	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1280: iconst_0
    //   1281: invokevirtual 695	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   1284: aload 11
    //   1286: getfield 362	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1289: invokevirtual 698	com/tencent/mm/ui/widget/MMPinProgressBtn:jEN	()V
    //   1292: goto -693 -> 599
    //   1295: aload_2
    //   1296: aload_1
    //   1297: invokevirtual 878	com/tencent/mm/plugin/sns/model/g:y	(Lcom/tencent/mm/protocal/protobuf/dmz;)Z
    //   1300: ifeq +36 -> 1336
    //   1303: aload 11
    //   1305: getfield 362	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1308: bipush 8
    //   1310: invokevirtual 695	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   1313: aload 11
    //   1315: getfield 353	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1318: getstatic 883	com/tencent/mm/plugin/sns/b$i:shortvideo_play_icon_err	I
    //   1321: invokevirtual 886	android/widget/ImageView:setImageResource	(I)V
    //   1324: aload 11
    //   1326: getfield 353	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1329: iconst_0
    //   1330: invokevirtual 694	android/widget/ImageView:setVisibility	(I)V
    //   1333: goto -734 -> 599
    //   1336: aload_2
    //   1337: aload_1
    //   1338: invokevirtual 888	com/tencent/mm/plugin/sns/model/g:z	(Lcom/tencent/mm/protocal/protobuf/dmz;)V
    //   1341: aload 11
    //   1343: getfield 353	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1346: iconst_0
    //   1347: invokevirtual 694	android/widget/ImageView:setVisibility	(I)V
    //   1350: aload 11
    //   1352: getfield 362	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1355: bipush 8
    //   1357: invokevirtual 695	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   1360: aload 11
    //   1362: getfield 353	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1365: aload_0
    //   1366: getfield 513	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:mContext	Landroid/content/Context;
    //   1369: getstatic 891	com/tencent/mm/plugin/sns/b$i:shortvideo_play_btn	I
    //   1372: invokestatic 895	com/tencent/mm/cd/a:m	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   1375: invokevirtual 899	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1378: aload 11
    //   1380: getfield 353	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1383: aload_0
    //   1384: getfield 513	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:mContext	Landroid/content/Context;
    //   1387: getstatic 904	com/tencent/mm/plugin/sns/b$j:play_sight_desc	I
    //   1390: invokevirtual 909	android/content/Context:getString	(I)Ljava/lang/String;
    //   1393: invokevirtual 913	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   1396: aload_2
    //   1397: aload_0
    //   1398: getfield 430	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1401: aconst_null
    //   1402: invokevirtual 768	com/tencent/mm/plugin/sns/model/g:b	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;[I)I
    //   1405: iconst_4
    //   1406: if_icmpne -807 -> 599
    //   1409: aload 11
    //   1411: getfield 374	com/tencent/mm/plugin/sns/ui/aw:QRC	Landroid/widget/TextView;
    //   1414: iconst_0
    //   1415: invokevirtual 914	android/widget/TextView:setVisibility	(I)V
    //   1418: goto -819 -> 599
    //   1421: aload_2
    //   1422: aload_1
    //   1423: invokevirtual 917	com/tencent/mm/plugin/sns/model/g:v	(Lcom/tencent/mm/protocal/protobuf/dmz;)Z
    //   1426: ifeq +244 -> 1670
    //   1429: aload 11
    //   1431: getfield 353	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1434: iconst_0
    //   1435: invokevirtual 694	android/widget/ImageView:setVisibility	(I)V
    //   1438: aload 11
    //   1440: getfield 362	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1443: bipush 8
    //   1445: invokevirtual 695	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   1448: aload 11
    //   1450: getfield 353	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1453: aload_0
    //   1454: getfield 513	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:mContext	Landroid/content/Context;
    //   1457: getstatic 891	com/tencent/mm/plugin/sns/b$i:shortvideo_play_btn	I
    //   1460: invokestatic 895	com/tencent/mm/cd/a:m	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   1463: invokevirtual 899	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1466: aload 11
    //   1468: getfield 353	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1471: aload_0
    //   1472: getfield 513	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:mContext	Landroid/content/Context;
    //   1475: getstatic 904	com/tencent/mm/plugin/sns/b$j:play_sight_desc	I
    //   1478: invokevirtual 909	android/content/Context:getString	(I)Ljava/lang/String;
    //   1481: invokevirtual 913	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   1484: iconst_0
    //   1485: istore 6
    //   1487: iload 4
    //   1489: ifeq +406 -> 1895
    //   1492: aload_0
    //   1493: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1496: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1499: ifnull +15 -> 1514
    //   1502: aload_0
    //   1503: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1506: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1509: getfield 920	com/tencent/mm/plugin/sns/ui/OnlineVideoView:Aqa	Z
    //   1512: istore 6
    //   1514: iload 6
    //   1516: ifeq -917 -> 599
    //   1519: ldc 108
    //   1521: new 110	java/lang/StringBuilder
    //   1524: dup
    //   1525: ldc_w 922
    //   1528: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1531: aload_1
    //   1532: getfield 713	com/tencent/mm/protocal/protobuf/dmz:Id	Ljava/lang/String;
    //   1535: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1538: ldc_w 924
    //   1541: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1544: aload_1
    //   1545: getfield 927	com/tencent/mm/protocal/protobuf/dmz:Url	Ljava/lang/String;
    //   1548: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1551: ldc_w 924
    //   1554: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1557: aload_1
    //   1558: getfield 930	com/tencent/mm/protocal/protobuf/dmz:aaTl	Ljava/lang/String;
    //   1561: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1564: ldc_w 924
    //   1567: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1570: iload_3
    //   1571: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1574: ldc_w 932
    //   1577: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: iload 4
    //   1582: invokevirtual 759	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1585: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1588: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1591: aload_2
    //   1592: aload_1
    //   1593: invokevirtual 888	com/tencent/mm/plugin/sns/model/g:z	(Lcom/tencent/mm/protocal/protobuf/dmz;)V
    //   1596: aload 11
    //   1598: getfield 353	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1601: iconst_0
    //   1602: invokevirtual 694	android/widget/ImageView:setVisibility	(I)V
    //   1605: aload 11
    //   1607: getfield 362	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1610: bipush 8
    //   1612: invokevirtual 695	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   1615: aload 11
    //   1617: getfield 353	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1620: aload_0
    //   1621: getfield 513	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:mContext	Landroid/content/Context;
    //   1624: getstatic 891	com/tencent/mm/plugin/sns/b$i:shortvideo_play_btn	I
    //   1627: invokestatic 895	com/tencent/mm/cd/a:m	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   1630: invokevirtual 899	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1633: aload 11
    //   1635: getfield 353	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1638: aload_0
    //   1639: getfield 513	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:mContext	Landroid/content/Context;
    //   1642: getstatic 904	com/tencent/mm/plugin/sns/b$j:play_sight_desc	I
    //   1645: invokevirtual 909	android/content/Context:getString	(I)Ljava/lang/String;
    //   1648: invokevirtual 913	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   1651: iload 4
    //   1653: ifne -1054 -> 599
    //   1656: getstatic 139	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1659: sipush 1697
    //   1662: bipush 18
    //   1664: invokevirtual 143	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   1667: goto -1068 -> 599
    //   1670: aload_2
    //   1671: aload_1
    //   1672: invokevirtual 935	com/tencent/mm/plugin/sns/model/g:w	(Lcom/tencent/mm/protocal/protobuf/dmz;)Z
    //   1675: ifeq +26 -> 1701
    //   1678: aload 11
    //   1680: getfield 353	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1683: bipush 8
    //   1685: invokevirtual 694	android/widget/ImageView:setVisibility	(I)V
    //   1688: aload 11
    //   1690: getfield 362	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1693: bipush 8
    //   1695: invokevirtual 695	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   1698: goto -214 -> 1484
    //   1701: aload_2
    //   1702: aload_0
    //   1703: getfield 430	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1706: aconst_null
    //   1707: invokevirtual 768	com/tencent/mm/plugin/sns/model/g:b	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;[I)I
    //   1710: iconst_5
    //   1711: if_icmpgt +121 -> 1832
    //   1714: aload_0
    //   1715: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1718: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcx	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$a;
    //   1721: getfield 938	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$a:source	I
    //   1724: iconst_1
    //   1725: if_icmpeq +17 -> 1742
    //   1728: aload_0
    //   1729: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1732: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcx	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$a;
    //   1735: getfield 938	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$a:source	I
    //   1738: iconst_2
    //   1739: if_icmpne +36 -> 1775
    //   1742: aload_0
    //   1743: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1746: getfield 316	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   1749: getfield 353	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1752: bipush 8
    //   1754: invokevirtual 694	android/widget/ImageView:setVisibility	(I)V
    //   1757: aload_0
    //   1758: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1761: getfield 316	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   1764: getfield 362	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1767: bipush 8
    //   1769: invokevirtual 695	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   1772: goto -288 -> 1484
    //   1775: aload_0
    //   1776: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1779: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcx	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$a;
    //   1782: getfield 562	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$a:QbV	Z
    //   1785: ifne -301 -> 1484
    //   1788: aload_0
    //   1789: getfield 48	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbS	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$c;
    //   1792: ifnull -308 -> 1484
    //   1795: aload_0
    //   1796: getfield 430	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1799: ifnull +13 -> 1812
    //   1802: aload_0
    //   1803: getfield 430	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1806: invokevirtual 435	com/tencent/mm/plugin/sns/storage/SnsInfo:isBreakFrameAd	()Z
    //   1809: ifne -325 -> 1484
    //   1812: ldc 108
    //   1814: ldc_w 940
    //   1817: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1820: aload_0
    //   1821: getfield 48	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbS	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$c;
    //   1824: invokeinterface 943 1 0
    //   1829: goto -345 -> 1484
    //   1832: aload_2
    //   1833: aload_1
    //   1834: invokevirtual 888	com/tencent/mm/plugin/sns/model/g:z	(Lcom/tencent/mm/protocal/protobuf/dmz;)V
    //   1837: aload 11
    //   1839: getfield 353	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1842: iconst_0
    //   1843: invokevirtual 694	android/widget/ImageView:setVisibility	(I)V
    //   1846: aload 11
    //   1848: getfield 362	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1851: bipush 8
    //   1853: invokevirtual 695	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   1856: aload 11
    //   1858: getfield 353	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1861: aload_0
    //   1862: getfield 513	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:mContext	Landroid/content/Context;
    //   1865: getstatic 891	com/tencent/mm/plugin/sns/b$i:shortvideo_play_btn	I
    //   1868: invokestatic 895	com/tencent/mm/cd/a:m	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   1871: invokevirtual 899	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1874: aload 11
    //   1876: getfield 353	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1879: aload_0
    //   1880: getfield 513	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:mContext	Landroid/content/Context;
    //   1883: getstatic 904	com/tencent/mm/plugin/sns/b$j:play_sight_desc	I
    //   1886: invokevirtual 909	android/content/Context:getString	(I)Ljava/lang/String;
    //   1889: invokevirtual 913	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   1892: goto -408 -> 1484
    //   1895: aload 11
    //   1897: getfield 343	com/tencent/mm/plugin/sns/ui/aw:RjN	Lcom/tencent/mm/plugin/sns/ui/widget/SnsAdTimelineVideoView;
    //   1900: invokevirtual 946	com/tencent/mm/plugin/sns/ui/widget/SnsAdTimelineVideoView:isError	()Z
    //   1903: istore 6
    //   1905: goto -391 -> 1514
    //   1908: aload_0
    //   1909: getfield 515	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbO	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   1912: lload 7
    //   1914: iload_3
    //   1915: iconst_0
    //   1916: invokevirtual 746	com/tencent/mm/plugin/sns/ad/g/l:g	(JIZ)V
    //   1919: goto -1149 -> 770
    //   1922: iconst_0
    //   1923: istore 6
    //   1925: goto -1137 -> 788
    //   1928: aload_0
    //   1929: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1932: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1935: getfield 949	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:RUB	Z
    //   1938: ifeq +27 -> 1965
    //   1941: iconst_1
    //   1942: istore_3
    //   1943: ldc 108
    //   1945: ldc_w 951
    //   1948: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1951: getstatic 139	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1954: sipush 1697
    //   1957: bipush 20
    //   1959: invokevirtual 143	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   1962: goto -1135 -> 827
    //   1965: aload_0
    //   1966: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   1969: getfield 452	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcr	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1972: getfield 920	com/tencent/mm/plugin/sns/ui/OnlineVideoView:Aqa	Z
    //   1975: ifeq -1148 -> 827
    //   1978: iconst_1
    //   1979: istore_3
    //   1980: ldc 108
    //   1982: ldc_w 953
    //   1985: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1988: getstatic 139	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1991: sipush 1697
    //   1994: bipush 19
    //   1996: invokevirtual 143	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   1999: goto -1172 -> 827
    //   2002: astore_2
    //   2003: ldc 108
    //   2005: new 110	java/lang/StringBuilder
    //   2008: dup
    //   2009: ldc_w 955
    //   2012: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2015: aload_2
    //   2016: invokevirtual 148	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2019: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2022: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2025: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2028: goto -1143 -> 885
    //   2031: aload 12
    //   2033: instanceof 957
    //   2036: ifeq +8 -> 2044
    //   2039: iconst_2
    //   2040: istore_3
    //   2041: goto -1000 -> 1041
    //   2044: aload 12
    //   2046: instanceof 959
    //   2049: ifeq +8 -> 2057
    //   2052: iconst_3
    //   2053: istore_3
    //   2054: goto -1013 -> 1041
    //   2057: iconst_0
    //   2058: istore_3
    //   2059: goto -1018 -> 1041
    //   2062: aload_0
    //   2063: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   2066: getfield 316	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   2069: getfield 325	com/tencent/mm/plugin/sns/ui/aw:RjL	Landroid/view/View;
    //   2072: iconst_0
    //   2073: invokevirtual 538	android/view/View:setVisibility	(I)V
    //   2076: aload_0
    //   2077: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   2080: getfield 407	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcq	Landroid/view/ViewGroup;
    //   2083: bipush 8
    //   2085: invokevirtual 868	android/view/ViewGroup:setVisibility	(I)V
    //   2088: aload_0
    //   2089: getfield 430	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   2092: astore 12
    //   2094: aload 11
    //   2096: getfield 343	com/tencent/mm/plugin/sns/ui/aw:RjN	Lcom/tencent/mm/plugin/sns/ui/widget/SnsAdTimelineVideoView;
    //   2099: astore 13
    //   2101: invokestatic 544	com/tencent/mm/storage/br:jbh	()Lcom/tencent/mm/storage/br;
    //   2104: astore 14
    //   2106: aload 14
    //   2108: aload_0
    //   2109: getfield 517	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbP	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   2112: getfield 547	com/tencent/mm/protocal/protobuf/TimeLineObject:CreateTime	I
    //   2115: putfield 550	com/tencent/mm/storage/br:time	I
    //   2118: aload 12
    //   2120: ifnull +38 -> 2158
    //   2123: aload 12
    //   2125: invokevirtual 435	com/tencent/mm/plugin/sns/storage/SnsInfo:isBreakFrameAd	()Z
    //   2128: ifeq +30 -> 2158
    //   2131: aload_0
    //   2132: getfield 437	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbQ	Lcom/tencent/mm/plugin/sns/ui/item/a/a/a/c;
    //   2135: ifnull +23 -> 2158
    //   2138: aload_0
    //   2139: getfield 437	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbQ	Lcom/tencent/mm/plugin/sns/ui/item/a/a/a/c;
    //   2142: aload 12
    //   2144: aload_2
    //   2145: aload_1
    //   2146: aload 13
    //   2148: aload 14
    //   2150: invokeinterface 962 6 0
    //   2155: goto -934 -> 1221
    //   2158: aload_2
    //   2159: aload 12
    //   2161: aload_1
    //   2162: aload 13
    //   2164: aload_0
    //   2165: getfield 513	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:mContext	Landroid/content/Context;
    //   2168: invokevirtual 466	java/lang/Object:hashCode	()I
    //   2171: aload 14
    //   2173: invokevirtual 965	com/tencent/mm/plugin/sns/model/g:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/protocal/protobuf/dmz;Lcom/tencent/mm/plugin/sns/ui/widget/SnsAdTimelineVideoView;ILcom/tencent/mm/storage/br;)Z
    //   2176: pop
    //   2177: goto -956 -> 1221
    //   2180: aload 11
    //   2182: getfield 343	com/tencent/mm/plugin/sns/ui/aw:RjN	Lcom/tencent/mm/plugin/sns/ui/widget/SnsAdTimelineVideoView;
    //   2185: new 8	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$2
    //   2188: dup
    //   2189: aload_0
    //   2190: invokespecial 966	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$2:<init>	(Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a;)V
    //   2193: invokevirtual 969	com/tencent/mm/plugin/sns/ui/widget/SnsAdTimelineVideoView:setVideoCallback	(Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView$a;)V
    //   2196: goto -2085 -> 111
    //   2199: iconst_1
    //   2200: istore_3
    //   2201: goto -2061 -> 140
    //   2204: aload_0
    //   2205: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   2208: getfield 635	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcp	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   2211: ifnull +15 -> 2226
    //   2214: aload_0
    //   2215: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   2218: getfield 635	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcp	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   2221: bipush 8
    //   2223: invokevirtual 645	com/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper:setVisibility	(I)V
    //   2226: ldc_w 519
    //   2229: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2232: return
    //   2233: astore_1
    //   2234: ldc 108
    //   2236: new 110	java/lang/StringBuilder
    //   2239: dup
    //   2240: ldc_w 971
    //   2243: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2246: aload_1
    //   2247: invokestatic 977	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2250: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2253: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2256: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2259: ldc_w 519
    //   2262: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2265: return
    //   2266: aload_0
    //   2267: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   2270: getfield 577	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcn	Landroid/view/ViewGroup;
    //   2273: ifnull +15 -> 2288
    //   2276: aload_0
    //   2277: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   2280: getfield 577	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcn	Landroid/view/ViewGroup;
    //   2283: bipush 8
    //   2285: invokevirtual 868	android/view/ViewGroup:setVisibility	(I)V
    //   2288: aload_0
    //   2289: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   2292: getfield 635	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcp	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   2295: ifnull +15 -> 2310
    //   2298: aload_0
    //   2299: getfield 448	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:QbM	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
    //   2302: getfield 635	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Qcp	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   2305: bipush 8
    //   2307: invokevirtual 645	com/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper:setVisibility	(I)V
    //   2310: ldc_w 519
    //   2313: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2316: return
    //   2317: iconst_0
    //   2318: istore_3
    //   2319: goto -2179 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2322	0	this	a
    //   0	2322	1	paramdmz	com.tencent.mm.protocal.protobuf.dmz
    //   0	2322	2	paramg	com.tencent.mm.plugin.sns.model.g
    //   0	2322	3	paramInt	int
    //   0	2322	4	paramBoolean	boolean
    //   361	13	5	i	int
    //   512	1412	6	bool	boolean
    //   13	1900	7	l1	long
    //   506	568	9	l2	long
    //   61	2120	11	localObject1	Object
    //   74	2086	12	localObject2	Object
    //   658	1505	13	localObject3	Object
    //   2104	68	14	localbr	com.tencent.mm.storage.br
    // Exception table:
    //   from	to	target	type
    //   856	885	2002	finally
    //   120	137	2233	finally
    //   144	180	2233	finally
    //   180	207	2233	finally
    //   212	332	2233	finally
    //   332	395	2233	finally
    //   2204	2226	2233	finally
    //   2226	2232	2233	finally
    //   2266	2288	2233	finally
    //   2288	2310	2233	finally
  }
  
  public final ViewGroup.LayoutParams ajK(int paramInt)
  {
    AppMethodBeat.i(311318);
    this.QbM.GBf.setVisibility(8);
    this.QbM.Qca.setVisibility(8);
    this.QbM.Qcb.setVisibility(8);
    this.QbM.QbY.setVisibility(8);
    this.QbM.Qcc.setVisibility(8);
    this.QbM.Qcd.setVisibility(8);
    this.QbM.Qce.setVisibility(8);
    Object localObject1;
    if ((this.QbN != null) && (this.QbN.QHM != null) && (this.QbM.Qck == null))
    {
      localObject1 = (ViewStub)this.QbM.Cxb.findViewById(b.f.sns_end_cover_view_stub);
      if (localObject1 != null) {
        this.QbM.Qck = ((SnsAdCardVideoEndView)((ViewStub)localObject1).inflate());
      }
    }
    StringBuilder localStringBuilder;
    Object localObject2;
    label240:
    int i;
    if (this.QbN != null) {
      if (this.QbN.QHE == 0)
      {
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = paramInt;
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).width * 0.75F));
        localStringBuilder = new StringBuilder("fillItemStyle, hash=").append(this.QbM.hashCode()).append(", snsId=");
        if (this.PJQ != null) {
          break label888;
        }
        localObject2 = "";
        Log.i("FullCardAdWrapper", (String)localObject2);
        if (localObject1 == null) {
          break label903;
        }
        n(this.QbM.Cxb, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        ((RoundedCornerFrameLayout)this.QbM.Cxb).setRadius(com.tencent.mm.cd.a.fromDPToPix(this.mContext, 8));
        n(this.QbM.QbZ, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        n(this.QbM.Qcj.RjN, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        n(this.QbM.Qcq, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        n(this.QbM.Qch, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        n(this.QbM.Qci, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        if (this.QbM.Qck != null) {
          n(this.QbM.Qck, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        }
        if (this.QbN.QHG != 0) {
          break label960;
        }
        paramInt = Color.argb((int)(this.QbN.QHF * 2.55F), 0, 0, 0);
        i = Color.argb(0, 0, 0, 0);
        localObject2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt, i });
        ((GradientDrawable)localObject2).setGradientType(0);
        this.QbM.GBf.setBackground((Drawable)localObject2);
        if ((!Util.isNullOrNil(this.QbN.title)) || (!Util.isNullOrNil(this.QbN.description))) {
          this.QbM.GBf.setVisibility(0);
        }
        if (!Util.isNullOrNil(this.QbN.title))
        {
          this.QbM.Qca.setVisibility(0);
          this.QbM.Qca.setText(u.iVt().a(this.QbM.Qca.getContext(), this.QbN.title, this.QbM.Qca.getTextSize()));
        }
        if (!Util.isNullOrNil(this.QbN.description))
        {
          this.QbM.Qcb.setVisibility(0);
          this.QbM.Qcb.setText(u.iVt().a(this.QbM.Qcb.getContext(), this.QbN.description, this.QbM.Qcb.getTextSize()));
        }
        label671:
        if (!this.PJQ.getAdInfo().isWeapp())
        {
          localObject2 = localObject1;
          if (!n.a(this.PJQ.getAdXml(), this.PJQ.getAdInfo())) {}
        }
        else
        {
          paramInt = Color.argb((int)(this.QbN.QHF * 2.55F), 0, 0, 0);
          i = Color.argb(0, 0, 0, 0);
          localObject2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt, i });
          ((GradientDrawable)localObject2).setGradientType(0);
          this.QbM.QbY.setBackground((Drawable)localObject2);
          this.QbM.QbY.setVisibility(0);
          this.QbM.Qce.setVisibility(0);
          if (!this.PJQ.getAdInfo().isWeapp()) {
            break label1260;
          }
          this.QbM.Qcg.setText(b.j.sns_ad_card_weapp_tag);
          this.QbM.Qcf.setImageResource(b.e.mini_program_icon_white);
          localObject2 = localObject1;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(311318);
      return localObject2;
      if (this.QbN.QHE == 1)
      {
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = paramInt;
        ((ViewGroup.LayoutParams)localObject1).height = ((ViewGroup.LayoutParams)localObject1).width;
        break;
        label888:
        localObject2 = t.uA(this.PJQ.field_snsId);
        break label240;
        label903:
        localStringBuilder = new StringBuilder("mediaLayout==null, snsId=");
        if (this.PJQ == null) {}
        for (localObject2 = "";; localObject2 = Long.valueOf(this.PJQ.field_snsId))
        {
          Log.e("FullCardAdWrapper", localObject2);
          break;
        }
        label960:
        if (this.QbN.QHG != 1) {
          break label671;
        }
        paramInt = Color.argb((int)(this.QbN.QHF * 2.55F), 0, 0, 0);
        i = Color.argb(0, 0, 0, 0);
        localObject2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt, i });
        ((GradientDrawable)localObject2).setGradientType(0);
        this.QbM.QbY.setBackground((Drawable)localObject2);
        if ((!Util.isNullOrNil(this.QbN.title)) || (!Util.isNullOrNil(this.QbN.description)))
        {
          this.QbM.QbY.setVisibility(0);
          localObject2 = (RelativeLayout.LayoutParams)this.QbM.Qce.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cd.a.fromDPToPix(this.QbM.Cxb.getContext(), 4);
          this.QbM.Qce.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        if (!Util.isNullOrNil(this.QbN.title))
        {
          this.QbM.Qcc.setVisibility(0);
          this.QbM.Qcc.setText(u.iVt().a(this.QbM.Qcc.getContext(), this.QbN.title, this.QbM.Qcc.getTextSize()));
        }
        if (Util.isNullOrNil(this.QbN.description)) {
          break label671;
        }
        this.QbM.Qcd.setVisibility(0);
        this.QbM.Qcd.setText(u.iVt().a(this.QbM.Qcd.getContext(), this.QbN.description, this.QbM.Qcd.getTextSize()));
        break label671;
        label1260:
        this.QbM.Qcg.setText(b.j.finder_app_name);
        this.QbM.Qcf.setImageResource(b.e.ad_fullcard_finder_icon_white);
        localObject2 = localObject1;
        continue;
      }
      localObject1 = null;
      break;
      localObject2 = null;
    }
  }
  
  public static final class a
  {
    public boolean QbV = false;
    public boolean QbW;
    public com.tencent.mm.plugin.sns.ui.item.a.a.d QbX;
    public volatile boolean mtE;
    public int source;
  }
  
  public static final class b
  {
    public View Cxb;
    public View GBf;
    public View QbY;
    public MaskImageView QbZ;
    public TextView Qca;
    public TextView Qcb;
    public TextView Qcc;
    public TextView Qcd;
    public View Qce;
    public ImageView Qcf;
    public TextView Qcg;
    public ImageView Qch;
    public ImageView Qci;
    public aw Qcj;
    public SnsAdCardVideoEndView Qck;
    public SnsAdBreakFrameVideoView Qcl;
    public ViewStub Qcm;
    public ViewGroup Qcn;
    public ViewStub Qco;
    public FinderLivingAnimWrapper Qcp;
    public ViewGroup Qcq;
    public SnsTimelineVideoView Qcr;
    public View Qcs;
    public ViewStub Qct;
    public AdSocialAttitudeView Qcu;
    public ViewStub Qcv;
    public AdAttitudePlayView Qcw;
    public a.a Qcx;
    
    public b()
    {
      AppMethodBeat.i(311187);
      this.Qcx = new a.a();
      AppMethodBeat.o(311187);
    }
  }
  
  public static abstract interface c
  {
    public abstract void Dw(boolean paramBoolean);
    
    public abstract void bC(int paramInt, boolean paramBoolean);
    
    public abstract void bD(int paramInt, boolean paramBoolean);
    
    public abstract void hcb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.b.a
 * JD-Core Version:    0.7.0.1
 */