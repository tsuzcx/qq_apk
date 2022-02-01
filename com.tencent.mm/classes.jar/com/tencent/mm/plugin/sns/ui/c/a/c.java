package com.tencent.mm.plugin.sns.ui.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
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
import com.tencent.mm.plugin.sight.decode.model.SightPlayController;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.d;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.e;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.d.n;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b;
import com.tencent.mm.plugin.sns.ad.timeline.helper.g;
import com.tencent.mm.plugin.sns.ad.widget.countdown.PromotionBarLayout;
import com.tencent.mm.plugin.sns.ad.widget.living.FinderLivingAnimWrapper;
import com.tencent.mm.plugin.sns.ad.widget.living.LivingDescBarLayout;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.c;
import com.tencent.mm.plugin.sns.storage.ADXml.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ai;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.ba;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.smiley.u;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.List;

public final class c
  extends b
{
  private Handler PRJ;
  private c.b PYj;
  public boolean QbW;
  private ViewGroup Qcn;
  private ViewStub Qco;
  FinderLivingAnimWrapper Qcp;
  public ViewGroup Qcq;
  public TextView RJa;
  public TextView RJb;
  public View RJc;
  public Button RJd;
  public Button RJe;
  public View RJf;
  public ImageView RJg;
  public MaskImageView RJh;
  public SnsCardAdTagListView RJi;
  public View RJj;
  public View RJk;
  public View RJl;
  public View RJm;
  private PromotionBarLayout RJn;
  private int RJo;
  private ay RJp;
  private ba RJq;
  private LivingDescBarLayout RJr;
  private com.tencent.mm.plugin.sns.ad.widget.living.c RJs;
  public LivingDescBarLayout RJt;
  private g RJu;
  public SnsTimelineVideoView RJv;
  boolean RJw;
  com.tencent.mm.plugin.sns.ad.g.l RoZ;
  Context context;
  public String hES;
  private com.tencent.mm.ui.widget.b.a vEV;
  
  public c(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ui.listener.c paramc, com.tencent.mm.plugin.sns.ad.g.l paraml)
  {
    AppMethodBeat.i(308845);
    this.PRJ = new Handler(Looper.getMainLooper());
    this.PYj = new c.b()
    {
      public final void hbt()
      {
        AppMethodBeat.i(308836);
        c.this.PZr.a(c.this);
        AppMethodBeat.o(308836);
      }
      
      public final ViewGroup hbu()
      {
        return null;
      }
    };
    this.RJw = false;
    this.timeLineObject = paramTimeLineObject;
    this.PNI = paramSnsInfo;
    this.PZr = paramc;
    this.RoZ = paraml;
    this.hES = paramSnsInfo.getLocalid();
    AppMethodBeat.o(308845);
  }
  
  private void ad(SnsInfo paramSnsInfo)
  {
    int j = 0;
    AppMethodBeat.i(100011);
    if ((paramSnsInfo == null) || (!paramSnsInfo.isCardAd()))
    {
      AppMethodBeat.o(100011);
      return;
    }
    int k = this.context.getResources().getColor(b.c.blue_text_color);
    int m = this.context.getResources().getColor(b.c.BW_0_Alpha_0_2);
    if ((this.RJd == null) || (this.RJe == null))
    {
      AppMethodBeat.o(100011);
      return;
    }
    this.RJd.setOnClickListener(this.PZr.RQE);
    this.RJe.setOnClickListener(this.PZr.RQF);
    int n;
    int i;
    if (paramSnsInfo.getAdXml().hasVoteInfo())
    {
      n = ai.mS(paramSnsInfo.getAdXml().adVoteInfo.QIe, paramSnsInfo.getUxinfo());
      if ((n > 0) && (n <= 2)) {
        if (n == 1)
        {
          this.RJe.setTextColor(m);
          this.RJe.setText(paramSnsInfo.getAdXml().adVoteInfo.alb(1));
          this.RJd.setTextColor(k);
          this.RJd.setText(paramSnsInfo.getAdXml().adVoteInfo.ala(0));
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.RJd.setTextColor(k);
        this.RJe.setTextColor(k);
        this.RJd.setText(paramSnsInfo.getAdXml().getCardSelectLeftTitle());
        this.RJe.setText(paramSnsInfo.getAdXml().getCardSelectRightTitle());
      }
      AppMethodBeat.o(100011);
      return;
      i = j;
      if (n == 2)
      {
        this.RJd.setTextColor(m);
        this.RJd.setText(paramSnsInfo.getAdXml().adVoteInfo.alb(0));
        this.RJe.setTextColor(k);
        this.RJe.setText(paramSnsInfo.getAdXml().adVoteInfo.ala(1));
        i = j;
        continue;
        i = 1;
      }
    }
  }
  
  public final boolean hqS()
  {
    return (this.timeLineObject.ContentObj.Zpq == 5) || (this.timeLineObject.ContentObj.Zpq == 15);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(308934);
    try
    {
      Log.i("MicroMsg.CardAdDetailItemView", "onPause, hasPlayedVideo=" + this.RJw + ", useOnlineVideo=" + this.QbW);
      if ((this.RJw) && (this.Qcj != null) && (this.Qcj.RjM != null))
      {
        if (!this.QbW) {
          break label121;
        }
        if (this.RJv != null) {
          this.RJv.bck();
        }
      }
      for (;;)
      {
        if ((this.RoZ != null) && (this.PNI != null)) {
          this.RoZ.uu(this.PNI.field_snsId);
        }
        AppMethodBeat.o(308934);
        return;
        label121:
        this.Qcj.RjM.pause();
      }
      return;
    }
    finally
    {
      Log.e("MicroMsg.CardAdDetailItemView", "onPause, exp=" + localObject.toString());
      AppMethodBeat.o(308934);
    }
  }
  
  /* Error */
  public final void refreshView()
  {
    // Byte code:
    //   0: ldc_w 313
    //   3: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_0
    //   8: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   11: invokevirtual 316	com/tencent/mm/plugin/sns/storage/SnsInfo:getSnsId	()Ljava/lang/String;
    //   14: invokestatic 322	com/tencent/mm/plugin/sns/storage/l:aZK	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   17: putfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   20: ldc 245
    //   22: ldc_w 323
    //   25: invokestatic 271	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 326	com/tencent/mm/plugin/sns/ui/c/a/c:contentView	Landroid/view/View;
    //   32: getstatic 331	com/tencent/mm/plugin/sns/b$f:ad_card_container	I
    //   35: invokevirtual 337	android/view/View:findViewById	(I)Landroid/view/View;
    //   38: astore 6
    //   40: aload 6
    //   42: instanceof 339
    //   45: ifeq +16 -> 61
    //   48: aload 6
    //   50: checkcast 339	com/tencent/mm/plugin/sns/ui/widget/ad/AdRoundedCornerFrameLayout
    //   53: aload_0
    //   54: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   57: iconst_2
    //   58: invokevirtual 343	com/tencent/mm/plugin/sns/ui/widget/ad/AdRoundedCornerFrameLayout:l	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V
    //   61: aload_0
    //   62: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   65: invokevirtual 186	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   68: invokevirtual 346	com/tencent/mm/plugin/sns/storage/ADXml:hasSelectInfo	()Z
    //   71: ifne +16 -> 87
    //   74: aload_0
    //   75: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   78: invokevirtual 186	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   81: invokevirtual 191	com/tencent/mm/plugin/sns/storage/ADXml:hasVoteInfo	()Z
    //   84: ifeq +35 -> 119
    //   87: aload_0
    //   88: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   91: invokevirtual 186	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   94: invokevirtual 349	com/tencent/mm/plugin/sns/storage/ADXml:isNewStyleVote	()Z
    //   97: ifeq +846 -> 943
    //   100: aload_0
    //   101: getfield 351	com/tencent/mm/plugin/sns/ui/c/a/c:RJq	Lcom/tencent/mm/plugin/sns/ui/ba;
    //   104: ifnull +15 -> 119
    //   107: aload_0
    //   108: getfield 351	com/tencent/mm/plugin/sns/ui/c/a/c:RJq	Lcom/tencent/mm/plugin/sns/ui/ba;
    //   111: aload_0
    //   112: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   115: aload_0
    //   116: invokevirtual 357	com/tencent/mm/plugin/sns/ui/ba:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Ljava/lang/Object;)V
    //   119: aload_0
    //   120: getfield 275	com/tencent/mm/plugin/sns/ui/c/a/c:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   123: getfield 360	com/tencent/mm/plugin/sns/ui/aw:QRC	Landroid/widget/TextView;
    //   126: bipush 8
    //   128: invokevirtual 365	android/widget/TextView:setVisibility	(I)V
    //   131: aload_0
    //   132: iconst_0
    //   133: putfield 108	com/tencent/mm/plugin/sns/ui/c/a/c:RJw	Z
    //   136: invokestatic 371	com/tencent/mm/plugin/sns/model/al:hgy	()Lcom/tencent/mm/plugin/sns/model/g;
    //   139: astore 8
    //   141: aconst_null
    //   142: astore 6
    //   144: aload_0
    //   145: getfield 112	com/tencent/mm/plugin/sns/ui/c/a/c:timeLineObject	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   148: getfield 236	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   151: ifnull +803 -> 954
    //   154: aload_0
    //   155: getfield 112	com/tencent/mm/plugin/sns/ui/c/a/c:timeLineObject	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   158: getfield 236	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   161: getfield 375	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
    //   164: invokevirtual 381	java/util/LinkedList:size	()I
    //   167: ifle +787 -> 954
    //   170: aload_0
    //   171: getfield 112	com/tencent/mm/plugin/sns/ui/c/a/c:timeLineObject	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   174: getfield 236	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   177: getfield 375	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
    //   180: iconst_0
    //   181: invokevirtual 385	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   184: checkcast 387	com/tencent/mm/protocal/protobuf/dmz
    //   187: astore 7
    //   189: aload 7
    //   191: astore 6
    //   193: aload_0
    //   194: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   197: ldc_w 389
    //   200: invokevirtual 393	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   203: checkcast 395	android/view/WindowManager
    //   206: invokeinterface 399 1 0
    //   211: invokevirtual 404	android/view/Display:getWidth	()I
    //   214: pop
    //   215: aload 6
    //   217: ifnull +2782 -> 2999
    //   220: aload_0
    //   221: getfield 406	com/tencent/mm/plugin/sns/ui/c/a/c:RJo	I
    //   224: aload_0
    //   225: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   228: invokevirtual 149	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   231: getstatic 411	com/tencent/mm/plugin/sns/b$d:SmallPadding	I
    //   234: invokevirtual 414	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   237: isub
    //   238: aload_0
    //   239: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   242: invokevirtual 149	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   245: getstatic 411	com/tencent/mm/plugin/sns/b$d:SmallPadding	I
    //   248: invokevirtual 414	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   251: isub
    //   252: istore_1
    //   253: iload_1
    //   254: i2f
    //   255: aload 6
    //   257: getfield 418	com/tencent/mm/protocal/protobuf/dmz:aaTn	Lcom/tencent/mm/protocal/protobuf/dnb;
    //   260: getfield 424	com/tencent/mm/protocal/protobuf/dnb:aaUc	F
    //   263: fmul
    //   264: aload 6
    //   266: getfield 418	com/tencent/mm/protocal/protobuf/dmz:aaTn	Lcom/tencent/mm/protocal/protobuf/dnb;
    //   269: getfield 427	com/tencent/mm/protocal/protobuf/dnb:aaUb	F
    //   272: fdiv
    //   273: f2i
    //   274: istore_2
    //   275: aload_0
    //   276: getfield 112	com/tencent/mm/plugin/sns/ui/c/a/c:timeLineObject	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   279: getfield 236	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   282: getfield 241	com/tencent/mm/protocal/protobuf/agh:Zpq	I
    //   285: iconst_1
    //   286: if_icmpne +696 -> 982
    //   289: aload_0
    //   290: getfield 429	com/tencent/mm/plugin/sns/ui/c/a/c:RJh	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
    //   293: invokevirtual 435	com/tencent/mm/plugin/sns/ui/MaskImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   296: astore 7
    //   298: aload 7
    //   300: iload_1
    //   301: putfield 440	android/view/ViewGroup$LayoutParams:width	I
    //   304: aload 7
    //   306: iload_2
    //   307: putfield 443	android/view/ViewGroup$LayoutParams:height	I
    //   310: aload_0
    //   311: getfield 429	com/tencent/mm/plugin/sns/ui/c/a/c:RJh	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
    //   314: aload 7
    //   316: invokevirtual 447	com/tencent/mm/plugin/sns/ui/MaskImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   319: invokestatic 371	com/tencent/mm/plugin/sns/model/al:hgy	()Lcom/tencent/mm/plugin/sns/model/g;
    //   322: aload 6
    //   324: aload_0
    //   325: getfield 429	com/tencent/mm/plugin/sns/ui/c/a/c:RJh	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
    //   328: iconst_m1
    //   329: aload_0
    //   330: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   333: invokevirtual 452	java/lang/Object:hashCode	()I
    //   336: getstatic 458	com/tencent/mm/storage/br:adkc	Lcom/tencent/mm/storage/br;
    //   339: invokevirtual 464	com/tencent/mm/plugin/sns/model/g:b	(Lcom/tencent/mm/protocal/protobuf/dmz;Landroid/view/View;IILcom/tencent/mm/storage/br;)Z
    //   342: pop
    //   343: aload_0
    //   344: getfield 429	com/tencent/mm/plugin/sns/ui/c/a/c:RJh	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
    //   347: iconst_0
    //   348: invokevirtual 465	com/tencent/mm/plugin/sns/ui/MaskImageView:setVisibility	(I)V
    //   351: aload_0
    //   352: getfield 429	com/tencent/mm/plugin/sns/ui/c/a/c:RJh	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
    //   355: aload_0
    //   356: invokevirtual 469	com/tencent/mm/plugin/sns/ui/MaskImageView:setTag	(Ljava/lang/Object;)V
    //   359: aload_0
    //   360: getfield 326	com/tencent/mm/plugin/sns/ui/c/a/c:contentView	Landroid/view/View;
    //   363: aload_0
    //   364: invokevirtual 470	android/view/View:setTag	(Ljava/lang/Object;)V
    //   367: aload_0
    //   368: getfield 165	com/tencent/mm/plugin/sns/ui/c/a/c:RJd	Landroid/widget/Button;
    //   371: aload_0
    //   372: invokevirtual 471	android/widget/Button:setTag	(Ljava/lang/Object;)V
    //   375: aload_0
    //   376: getfield 167	com/tencent/mm/plugin/sns/ui/c/a/c:RJe	Landroid/widget/Button;
    //   379: aload_0
    //   380: invokevirtual 471	android/widget/Button:setTag	(Ljava/lang/Object;)V
    //   383: aload_0
    //   384: getfield 429	com/tencent/mm/plugin/sns/ui/c/a/c:RJh	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
    //   387: aload_0
    //   388: getfield 120	com/tencent/mm/plugin/sns/ui/c/a/c:PZr	Lcom/tencent/mm/plugin/sns/ui/listener/c;
    //   391: getfield 474	com/tencent/mm/plugin/sns/ui/listener/c:Rea	Landroid/view/View$OnClickListener;
    //   394: invokevirtual 475	com/tencent/mm/plugin/sns/ui/MaskImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   397: aload_0
    //   398: getfield 477	com/tencent/mm/plugin/sns/ui/c/a/c:vEV	Lcom/tencent/mm/ui/widget/b/a;
    //   401: aload_0
    //   402: getfield 429	com/tencent/mm/plugin/sns/ui/c/a/c:RJh	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
    //   405: aload_0
    //   406: getfield 120	com/tencent/mm/plugin/sns/ui/c/a/c:PZr	Lcom/tencent/mm/plugin/sns/ui/listener/c;
    //   409: getfield 481	com/tencent/mm/plugin/sns/ui/listener/c:RQm	Lcom/tencent/mm/plugin/sns/ui/listener/d;
    //   412: aload_0
    //   413: getfield 120	com/tencent/mm/plugin/sns/ui/c/a/c:PZr	Lcom/tencent/mm/plugin/sns/ui/listener/c;
    //   416: getfield 485	com/tencent/mm/plugin/sns/ui/listener/c:RPU	Lcom/tencent/mm/plugin/sns/ui/listener/b;
    //   419: invokevirtual 491	com/tencent/mm/ui/widget/b/a:c	(Landroid/view/View;Landroid/view/View$OnCreateContextMenuListener;Lcom/tencent/mm/ui/base/u$i;)V
    //   422: aload_0
    //   423: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   426: invokevirtual 186	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   429: invokevirtual 494	com/tencent/mm/plugin/sns/storage/ADXml:hasActionBtn	()Z
    //   432: ifeq +2084 -> 2516
    //   435: aload_0
    //   436: getfield 496	com/tencent/mm/plugin/sns/ui/c/a/c:RJa	Landroid/widget/TextView;
    //   439: ifnull +12 -> 451
    //   442: aload_0
    //   443: getfield 496	com/tencent/mm/plugin/sns/ui/c/a/c:RJa	Landroid/widget/TextView;
    //   446: bipush 8
    //   448: invokevirtual 365	android/widget/TextView:setVisibility	(I)V
    //   451: aload_0
    //   452: getfield 498	com/tencent/mm/plugin/sns/ui/c/a/c:RJb	Landroid/widget/TextView;
    //   455: ifnull +12 -> 467
    //   458: aload_0
    //   459: getfield 498	com/tencent/mm/plugin/sns/ui/c/a/c:RJb	Landroid/widget/TextView;
    //   462: bipush 8
    //   464: invokevirtual 365	android/widget/TextView:setVisibility	(I)V
    //   467: aload_0
    //   468: getfield 500	com/tencent/mm/plugin/sns/ui/c/a/c:RJm	Landroid/view/View;
    //   471: iconst_0
    //   472: invokevirtual 501	android/view/View:setVisibility	(I)V
    //   475: aload_0
    //   476: getfield 503	com/tencent/mm/plugin/sns/ui/c/a/c:RJp	Lcom/tencent/mm/plugin/sns/ui/ay;
    //   479: ifnonnull +31 -> 510
    //   482: aload_0
    //   483: new 505	com/tencent/mm/plugin/sns/ui/ay
    //   486: dup
    //   487: aload_0
    //   488: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   491: aload_0
    //   492: getfield 326	com/tencent/mm/plugin/sns/ui/c/a/c:contentView	Landroid/view/View;
    //   495: iconst_1
    //   496: aload_0
    //   497: getfield 122	com/tencent/mm/plugin/sns/ui/c/a/c:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   500: aload_0
    //   501: getfield 106	com/tencent/mm/plugin/sns/ui/c/a/c:PYj	Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c$b;
    //   504: invokespecial 508	com/tencent/mm/plugin/sns/ui/ay:<init>	(Landroid/content/Context;Landroid/view/View;ILcom/tencent/mm/plugin/sns/ad/g/l;Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c$b;)V
    //   507: putfield 503	com/tencent/mm/plugin/sns/ui/c/a/c:RJp	Lcom/tencent/mm/plugin/sns/ui/ay;
    //   510: aload_0
    //   511: getfield 503	com/tencent/mm/plugin/sns/ui/c/a/c:RJp	Lcom/tencent/mm/plugin/sns/ui/ay;
    //   514: aload_0
    //   515: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   518: invokevirtual 511	com/tencent/mm/plugin/sns/ui/ay:Y	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V
    //   521: aload_0
    //   522: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   525: astore 6
    //   527: aload 6
    //   529: ifnull +2500 -> 3029
    //   532: aload 6
    //   534: invokevirtual 186	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   537: ifnull +2492 -> 3029
    //   540: aload 6
    //   542: invokevirtual 186	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   545: getfield 515	com/tencent/mm/plugin/sns/storage/ADXml:adLiveInfo	Lcom/tencent/mm/plugin/sns/ad/adxml/i;
    //   548: ifnonnull +1980 -> 2528
    //   551: goto +2478 -> 3029
    //   554: iload_1
    //   555: ifeq +2228 -> 2783
    //   558: aload 6
    //   560: invokevirtual 519	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   563: astore 7
    //   565: aload_0
    //   566: getfield 521	com/tencent/mm/plugin/sns/ui/c/a/c:Qcn	Landroid/view/ViewGroup;
    //   569: ifnonnull +35 -> 604
    //   572: aload_0
    //   573: getfield 326	com/tencent/mm/plugin/sns/ui/c/a/c:contentView	Landroid/view/View;
    //   576: getstatic 524	com/tencent/mm/plugin/sns/b$f:ad_live_status_layout_stub	I
    //   579: invokevirtual 337	android/view/View:findViewById	(I)Landroid/view/View;
    //   582: checkcast 526	android/view/ViewStub
    //   585: astore 8
    //   587: aload 8
    //   589: ifnull +15 -> 604
    //   592: aload_0
    //   593: aload 8
    //   595: invokestatic 531	com/tencent/mm/plugin/sns/ad/j/l:c	(Landroid/view/ViewStub;)Landroid/view/View;
    //   598: checkcast 533	android/view/ViewGroup
    //   601: putfield 521	com/tencent/mm/plugin/sns/ui/c/a/c:Qcn	Landroid/view/ViewGroup;
    //   604: aload_0
    //   605: getfield 535	com/tencent/mm/plugin/sns/ui/c/a/c:RJr	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   608: ifnonnull +35 -> 643
    //   611: aload_0
    //   612: getfield 326	com/tencent/mm/plugin/sns/ui/c/a/c:contentView	Landroid/view/View;
    //   615: getstatic 538	com/tencent/mm/plugin/sns/b$f:ad_live_desc_layout_stub	I
    //   618: invokevirtual 337	android/view/View:findViewById	(I)Landroid/view/View;
    //   621: checkcast 526	android/view/ViewStub
    //   624: astore 8
    //   626: aload 8
    //   628: ifnull +15 -> 643
    //   631: aload_0
    //   632: aload 8
    //   634: invokestatic 531	com/tencent/mm/plugin/sns/ad/j/l:c	(Landroid/view/ViewStub;)Landroid/view/View;
    //   637: checkcast 540	com/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout
    //   640: putfield 535	com/tencent/mm/plugin/sns/ui/c/a/c:RJr	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   643: aload_0
    //   644: getfield 521	com/tencent/mm/plugin/sns/ui/c/a/c:Qcn	Landroid/view/ViewGroup;
    //   647: ifnull +10 -> 657
    //   650: aload_0
    //   651: getfield 535	com/tencent/mm/plugin/sns/ui/c/a/c:RJr	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   654: ifnonnull +1879 -> 2533
    //   657: ldc 245
    //   659: ldc_w 542
    //   662: invokestatic 311	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   665: aload_0
    //   666: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   669: astore 6
    //   671: aload 6
    //   673: ifnull +2361 -> 3034
    //   676: aload 6
    //   678: invokevirtual 186	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   681: ifnonnull +2153 -> 2834
    //   684: goto +2350 -> 3034
    //   687: iload_1
    //   688: ifeq +2192 -> 2880
    //   691: aload 6
    //   693: invokevirtual 186	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   696: getfield 546	com/tencent/mm/plugin/sns/storage/ADXml:adPromotionInfo	Lcom/tencent/mm/plugin/sns/ad/adxml/j;
    //   699: astore 6
    //   701: aload_0
    //   702: getfield 548	com/tencent/mm/plugin/sns/ui/c/a/c:RJn	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   705: ifnonnull +35 -> 740
    //   708: aload_0
    //   709: getfield 326	com/tencent/mm/plugin/sns/ui/c/a/c:contentView	Landroid/view/View;
    //   712: getstatic 551	com/tencent/mm/plugin/sns/b$f:ad_promotion_bar_stub	I
    //   715: invokevirtual 337	android/view/View:findViewById	(I)Landroid/view/View;
    //   718: checkcast 526	android/view/ViewStub
    //   721: astore 7
    //   723: aload 7
    //   725: ifnull +15 -> 740
    //   728: aload_0
    //   729: aload 7
    //   731: invokestatic 531	com/tencent/mm/plugin/sns/ad/j/l:c	(Landroid/view/ViewStub;)Landroid/view/View;
    //   734: checkcast 553	com/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout
    //   737: putfield 548	com/tencent/mm/plugin/sns/ui/c/a/c:RJn	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   740: aload_0
    //   741: getfield 548	com/tencent/mm/plugin/sns/ui/c/a/c:RJn	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   744: ifnull +79 -> 823
    //   747: aload_0
    //   748: getfield 548	com/tencent/mm/plugin/sns/ui/c/a/c:RJn	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   751: iconst_0
    //   752: invokevirtual 554	com/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout:setVisibility	(I)V
    //   755: aload_0
    //   756: getfield 548	com/tencent/mm/plugin/sns/ui/c/a/c:RJn	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   759: aload 6
    //   761: getfield 559	com/tencent/mm/plugin/sns/ad/adxml/j:PMU	Ljava/lang/String;
    //   764: invokevirtual 562	com/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout:setPromotionalPrice	(Ljava/lang/String;)V
    //   767: aload_0
    //   768: getfield 548	com/tencent/mm/plugin/sns/ui/c/a/c:RJn	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   771: aload 6
    //   773: getfield 565	com/tencent/mm/plugin/sns/ad/adxml/j:PMV	Ljava/lang/String;
    //   776: invokevirtual 568	com/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout:setRightTitle	(Ljava/lang/String;)V
    //   779: aload_0
    //   780: getfield 548	com/tencent/mm/plugin/sns/ui/c/a/c:RJn	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   783: aload 6
    //   785: getfield 571	com/tencent/mm/plugin/sns/ad/adxml/j:PMS	Ljava/lang/String;
    //   788: aload 6
    //   790: getfield 574	com/tencent/mm/plugin/sns/ad/adxml/j:qWk	Ljava/lang/String;
    //   793: invokestatic 580	com/tencent/mm/plugin/sns/ad/j/e:lP	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   796: invokestatic 583	com/tencent/mm/plugin/sns/ad/j/l:i	(Landroid/view/View;Ljava/lang/String;)V
    //   799: aload_0
    //   800: getfield 548	com/tencent/mm/plugin/sns/ui/c/a/c:RJn	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   803: new 585	com/tencent/mm/plugin/sns/ad/widget/countdown/b
    //   806: dup
    //   807: aload 6
    //   809: getfield 588	com/tencent/mm/plugin/sns/ad/adxml/j:startTime	J
    //   812: aload 6
    //   814: getfield 591	com/tencent/mm/plugin/sns/ad/adxml/j:endTime	J
    //   817: invokespecial 594	com/tencent/mm/plugin/sns/ad/widget/countdown/b:<init>	(JJ)V
    //   820: invokevirtual 597	com/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout:b	(Lcom/tencent/mm/plugin/sns/ad/widget/countdown/d;)V
    //   823: aload_0
    //   824: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   827: astore 6
    //   829: aload 6
    //   831: ifnull +2073 -> 2904
    //   834: aload 6
    //   836: invokevirtual 186	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   839: ifnull +2065 -> 2904
    //   842: aload 6
    //   844: invokevirtual 186	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   847: getfield 601	com/tencent/mm/plugin/sns/storage/ADXml:adRollInfo	Lcom/tencent/mm/plugin/sns/ad/adxml/k;
    //   850: ifnull +2054 -> 2904
    //   853: iconst_1
    //   854: istore_1
    //   855: iload_1
    //   856: ifeq +2150 -> 3006
    //   859: aload 6
    //   861: invokevirtual 186	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   864: getfield 601	com/tencent/mm/plugin/sns/storage/ADXml:adRollInfo	Lcom/tencent/mm/plugin/sns/ad/adxml/k;
    //   867: astore 6
    //   869: aload_0
    //   870: getfield 603	com/tencent/mm/plugin/sns/ui/c/a/c:RJt	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   873: ifnonnull +43 -> 916
    //   876: aload_0
    //   877: getfield 326	com/tencent/mm/plugin/sns/ui/c/a/c:contentView	Landroid/view/View;
    //   880: getstatic 606	com/tencent/mm/plugin/sns/b$f:ad_roll_layout_stub	I
    //   883: invokevirtual 337	android/view/View:findViewById	(I)Landroid/view/View;
    //   886: checkcast 526	android/view/ViewStub
    //   889: astore 7
    //   891: aload 7
    //   893: ifnull +23 -> 916
    //   896: aload_0
    //   897: aload 7
    //   899: invokestatic 531	com/tencent/mm/plugin/sns/ad/j/l:c	(Landroid/view/ViewStub;)Landroid/view/View;
    //   902: checkcast 540	com/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout
    //   905: putfield 603	com/tencent/mm/plugin/sns/ui/c/a/c:RJt	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   908: ldc 245
    //   910: ldc_w 608
    //   913: invokestatic 271	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   916: aload_0
    //   917: getfield 603	com/tencent/mm/plugin/sns/ui/c/a/c:RJt	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   920: ifnull +8 -> 928
    //   923: aload 6
    //   925: ifnonnull +1984 -> 2909
    //   928: ldc 245
    //   930: ldc_w 610
    //   933: invokestatic 311	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   936: ldc_w 313
    //   939: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   942: return
    //   943: aload_0
    //   944: aload_0
    //   945: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   948: invokespecial 612	com/tencent/mm/plugin/sns/ui/c/a/c:ad	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V
    //   951: goto -832 -> 119
    //   954: aconst_null
    //   955: astore 6
    //   957: goto -764 -> 193
    //   960: astore 7
    //   962: ldc 245
    //   964: ldc_w 614
    //   967: iconst_1
    //   968: anewarray 449	java/lang/Object
    //   971: dup
    //   972: iconst_0
    //   973: aload 7
    //   975: aastore
    //   976: invokestatic 617	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   979: goto -786 -> 193
    //   982: aload_0
    //   983: getfield 112	com/tencent/mm/plugin/sns/ui/c/a/c:timeLineObject	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   986: getfield 236	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   989: getfield 241	com/tencent/mm/protocal/protobuf/agh:Zpq	I
    //   992: iconst_5
    //   993: if_icmpeq +18 -> 1011
    //   996: aload_0
    //   997: getfield 112	com/tencent/mm/plugin/sns/ui/c/a/c:timeLineObject	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1000: getfield 236	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   1003: getfield 241	com/tencent/mm/protocal/protobuf/agh:Zpq	I
    //   1006: bipush 15
    //   1008: if_icmpne +1439 -> 2447
    //   1011: aload_0
    //   1012: getfield 275	com/tencent/mm/plugin/sns/ui/c/a/c:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   1015: getfield 620	com/tencent/mm/plugin/sns/ui/aw:RjL	Landroid/view/View;
    //   1018: iconst_0
    //   1019: invokevirtual 501	android/view/View:setVisibility	(I)V
    //   1022: aload_0
    //   1023: getfield 477	com/tencent/mm/plugin/sns/ui/c/a/c:vEV	Lcom/tencent/mm/ui/widget/b/a;
    //   1026: aload_0
    //   1027: getfield 275	com/tencent/mm/plugin/sns/ui/c/a/c:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   1030: getfield 623	com/tencent/mm/plugin/sns/ui/aw:RjO	Landroid/view/View;
    //   1033: aload_0
    //   1034: getfield 120	com/tencent/mm/plugin/sns/ui/c/a/c:PZr	Lcom/tencent/mm/plugin/sns/ui/listener/c;
    //   1037: getfield 481	com/tencent/mm/plugin/sns/ui/listener/c:RQm	Lcom/tencent/mm/plugin/sns/ui/listener/d;
    //   1040: aload_0
    //   1041: getfield 120	com/tencent/mm/plugin/sns/ui/c/a/c:PZr	Lcom/tencent/mm/plugin/sns/ui/listener/c;
    //   1044: getfield 485	com/tencent/mm/plugin/sns/ui/listener/c:RPU	Lcom/tencent/mm/plugin/sns/ui/listener/b;
    //   1047: invokevirtual 491	com/tencent/mm/ui/widget/b/a:c	(Landroid/view/View;Landroid/view/View$OnCreateContextMenuListener;Lcom/tencent/mm/ui/base/u$i;)V
    //   1050: aload_0
    //   1051: getfield 275	com/tencent/mm/plugin/sns/ui/c/a/c:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   1054: getfield 620	com/tencent/mm/plugin/sns/ui/aw:RjL	Landroid/view/View;
    //   1057: invokevirtual 624	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1060: astore 7
    //   1062: aload 7
    //   1064: iload_1
    //   1065: putfield 440	android/view/ViewGroup$LayoutParams:width	I
    //   1068: aload 7
    //   1070: iload_2
    //   1071: putfield 443	android/view/ViewGroup$LayoutParams:height	I
    //   1074: aload_0
    //   1075: getfield 275	com/tencent/mm/plugin/sns/ui/c/a/c:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   1078: getfield 620	com/tencent/mm/plugin/sns/ui/aw:RjL	Landroid/view/View;
    //   1081: aload 7
    //   1083: invokevirtual 625	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1086: aload_0
    //   1087: getfield 275	com/tencent/mm/plugin/sns/ui/c/a/c:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   1090: getfield 281	com/tencent/mm/plugin/sns/ui/aw:RjM	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   1093: iload_1
    //   1094: iload_2
    //   1095: invokevirtual 629	com/tencent/mm/pluginsdk/ui/tools/VideoSightView:ld	(II)V
    //   1098: aload_0
    //   1099: getfield 275	com/tencent/mm/plugin/sns/ui/c/a/c:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   1102: getfield 281	com/tencent/mm/plugin/sns/ui/aw:RjM	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   1105: new 6	com/tencent/mm/plugin/sns/ui/c/a/c$1
    //   1108: dup
    //   1109: aload_0
    //   1110: invokespecial 630	com/tencent/mm/plugin/sns/ui/c/a/c$1:<init>	(Lcom/tencent/mm/plugin/sns/ui/c/a/c;)V
    //   1113: invokevirtual 634	com/tencent/mm/pluginsdk/ui/tools/VideoSightView:setOnCompletionListener	(Lcom/tencent/mm/plugin/sight/decode/model/SightPlayController$d;)V
    //   1116: aload_0
    //   1117: getfield 275	com/tencent/mm/plugin/sns/ui/c/a/c:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   1120: getfield 281	com/tencent/mm/plugin/sns/ui/aw:RjM	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   1123: new 8	com/tencent/mm/plugin/sns/ui/c/a/c$2
    //   1126: dup
    //   1127: aload_0
    //   1128: invokespecial 635	com/tencent/mm/plugin/sns/ui/c/a/c$2:<init>	(Lcom/tencent/mm/plugin/sns/ui/c/a/c;)V
    //   1131: invokevirtual 639	com/tencent/mm/pluginsdk/ui/tools/VideoSightView:setOnDecodeDurationListener	(Lcom/tencent/mm/plugin/sight/decode/model/SightPlayController$e;)V
    //   1134: aload_0
    //   1135: getfield 263	com/tencent/mm/plugin/sns/ui/c/a/c:QbW	Z
    //   1138: ifeq +646 -> 1784
    //   1141: aload_0
    //   1142: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1145: aload 6
    //   1147: invokestatic 644	com/tencent/mm/plugin/sns/ad/d/e:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/protocal/protobuf/dmz;)V
    //   1150: invokestatic 650	java/lang/System:nanoTime	()J
    //   1153: lstore_3
    //   1154: aload 6
    //   1156: invokestatic 654	com/tencent/mm/plugin/sns/model/g:u	(Lcom/tencent/mm/protocal/protobuf/dmz;)Z
    //   1159: istore 5
    //   1161: ldc 245
    //   1163: ldc_w 656
    //   1166: iconst_2
    //   1167: anewarray 449	java/lang/Object
    //   1170: dup
    //   1171: iconst_0
    //   1172: iload 5
    //   1174: invokestatic 662	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1177: aastore
    //   1178: dup
    //   1179: iconst_1
    //   1180: invokestatic 650	java/lang/System:nanoTime	()J
    //   1183: lload_3
    //   1184: lsub
    //   1185: invokestatic 667	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1188: aastore
    //   1189: invokestatic 669	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1192: aload_0
    //   1193: getfield 275	com/tencent/mm/plugin/sns/ui/c/a/c:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   1196: astore 7
    //   1198: aload_0
    //   1199: getfield 275	com/tencent/mm/plugin/sns/ui/c/a/c:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   1202: aload_0
    //   1203: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1206: invokevirtual 128	com/tencent/mm/plugin/sns/storage/SnsInfo:getLocalid	()Ljava/lang/String;
    //   1209: putfield 670	com/tencent/mm/plugin/sns/ui/aw:hES	Ljava/lang/String;
    //   1212: iload 5
    //   1214: ifne +764 -> 1978
    //   1217: aload 8
    //   1219: aload 6
    //   1221: invokevirtual 673	com/tencent/mm/plugin/sns/model/g:x	(Lcom/tencent/mm/protocal/protobuf/dmz;)Z
    //   1224: ifeq +569 -> 1793
    //   1227: aload 7
    //   1229: getfield 676	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1232: bipush 8
    //   1234: invokevirtual 679	android/widget/ImageView:setVisibility	(I)V
    //   1237: aload 7
    //   1239: getfield 683	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1242: iconst_0
    //   1243: invokevirtual 686	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   1246: aload 7
    //   1248: getfield 683	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1251: invokevirtual 689	com/tencent/mm/ui/widget/MMPinProgressBtn:jEN	()V
    //   1254: aload_0
    //   1255: getfield 275	com/tencent/mm/plugin/sns/ui/c/a/c:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   1258: getfield 620	com/tencent/mm/plugin/sns/ui/aw:RjL	Landroid/view/View;
    //   1261: iconst_0
    //   1262: invokevirtual 501	android/view/View:setVisibility	(I)V
    //   1265: aload 7
    //   1267: getfield 281	com/tencent/mm/plugin/sns/ui/aw:RjM	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   1270: aload 7
    //   1272: invokevirtual 692	com/tencent/mm/pluginsdk/ui/tools/VideoSightView:setTagObject	(Ljava/lang/Object;)V
    //   1275: aload 7
    //   1277: getfield 623	com/tencent/mm/plugin/sns/ui/aw:RjO	Landroid/view/View;
    //   1280: aload_0
    //   1281: invokevirtual 470	android/view/View:setTag	(Ljava/lang/Object;)V
    //   1284: aload_0
    //   1285: getfield 326	com/tencent/mm/plugin/sns/ui/c/a/c:contentView	Landroid/view/View;
    //   1288: aload_0
    //   1289: invokevirtual 470	android/view/View:setTag	(Ljava/lang/Object;)V
    //   1292: aload_0
    //   1293: getfield 165	com/tencent/mm/plugin/sns/ui/c/a/c:RJd	Landroid/widget/Button;
    //   1296: aload_0
    //   1297: invokevirtual 471	android/widget/Button:setTag	(Ljava/lang/Object;)V
    //   1300: aload_0
    //   1301: getfield 167	com/tencent/mm/plugin/sns/ui/c/a/c:RJe	Landroid/widget/Button;
    //   1304: aload_0
    //   1305: invokevirtual 471	android/widget/Button:setTag	(Ljava/lang/Object;)V
    //   1308: aload_0
    //   1309: getfield 263	com/tencent/mm/plugin/sns/ui/c/a/c:QbW	Z
    //   1312: ifeq +1008 -> 2320
    //   1315: aload 8
    //   1317: aload_0
    //   1318: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1321: aload 6
    //   1323: aload 7
    //   1325: getfield 281	com/tencent/mm/plugin/sns/ui/aw:RjM	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   1328: iconst_m1
    //   1329: aload_0
    //   1330: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   1333: invokevirtual 452	java/lang/Object:hashCode	()I
    //   1336: iconst_0
    //   1337: getstatic 458	com/tencent/mm/storage/br:adkc	Lcom/tencent/mm/storage/br;
    //   1340: iconst_1
    //   1341: iconst_1
    //   1342: iconst_0
    //   1343: invokevirtual 695	com/tencent/mm/plugin/sns/model/g:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/protocal/protobuf/dmz;Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;IIILcom/tencent/mm/storage/br;ZZZ)Z
    //   1346: pop
    //   1347: aload_0
    //   1348: getfield 122	com/tencent/mm/plugin/sns/ui/c/a/c:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   1351: ifnull +156 -> 1507
    //   1354: invokestatic 698	com/tencent/mm/plugin/sns/model/al:getAccSnsPath	()Ljava/lang/String;
    //   1357: aload 6
    //   1359: getfield 701	com/tencent/mm/protocal/protobuf/dmz:Id	Ljava/lang/String;
    //   1362: invokestatic 706	com/tencent/mm/plugin/sns/model/as:mg	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1365: astore 8
    //   1367: aload 6
    //   1369: invokestatic 711	com/tencent/mm/plugin/sns/data/t:i	(Lcom/tencent/mm/protocal/protobuf/dmz;)Ljava/lang/String;
    //   1372: astore 9
    //   1374: new 247	java/lang/StringBuilder
    //   1377: dup
    //   1378: invokespecial 712	java/lang/StringBuilder:<init>	()V
    //   1381: aload 8
    //   1383: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1386: aload 9
    //   1388: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: invokevirtual 266	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1394: astore 8
    //   1396: aload 8
    //   1398: invokestatic 718	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   1401: ifeq +952 -> 2353
    //   1404: aload_0
    //   1405: getfield 122	com/tencent/mm/plugin/sns/ui/c/a/c:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   1408: aload_0
    //   1409: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1412: getfield 292	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1415: aload 6
    //   1417: getfield 721	com/tencent/mm/protocal/protobuf/dmz:aaTF	F
    //   1420: f2i
    //   1421: iconst_1
    //   1422: invokevirtual 725	com/tencent/mm/plugin/sns/ad/g/l:g	(JIZ)V
    //   1425: invokestatic 728	com/tencent/mm/plugin/sns/ad/d/e:anH	()Z
    //   1428: ifeq +44 -> 1472
    //   1431: aload 8
    //   1433: invokestatic 733	com/tencent/mm/modelvideo/y:isH265Video	(Ljava/lang/String;)Z
    //   1436: istore 5
    //   1438: ldc 245
    //   1440: new 247	java/lang/StringBuilder
    //   1443: dup
    //   1444: ldc_w 735
    //   1447: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1450: iload 5
    //   1452: invokevirtual 256	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1455: ldc_w 737
    //   1458: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1461: aload 8
    //   1463: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: invokevirtual 266	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1469: invokestatic 271	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1472: invokestatic 371	com/tencent/mm/plugin/sns/model/al:hgy	()Lcom/tencent/mm/plugin/sns/model/g;
    //   1475: aload_0
    //   1476: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1479: aconst_null
    //   1480: invokevirtual 740	com/tencent/mm/plugin/sns/model/g:b	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;[I)I
    //   1483: iconst_5
    //   1484: if_icmpne +893 -> 2377
    //   1487: iconst_1
    //   1488: istore 5
    //   1490: aload_0
    //   1491: getfield 122	com/tencent/mm/plugin/sns/ui/c/a/c:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   1494: aload_0
    //   1495: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1498: getfield 292	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1501: iload 5
    //   1503: iconst_0
    //   1504: invokevirtual 743	com/tencent/mm/plugin/sns/ad/g/l:e	(JZZ)V
    //   1507: aload_0
    //   1508: getfield 263	com/tencent/mm/plugin/sns/ui/c/a/c:QbW	Z
    //   1511: ifeq +919 -> 2430
    //   1514: aload_0
    //   1515: getfield 745	com/tencent/mm/plugin/sns/ui/c/a/c:Qcq	Landroid/view/ViewGroup;
    //   1518: iload_1
    //   1519: iload_2
    //   1520: invokestatic 749	com/tencent/mm/plugin/sns/ad/j/l:z	(Landroid/view/View;II)V
    //   1523: aload_0
    //   1524: getfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1527: ifnonnull +856 -> 2383
    //   1530: aload_0
    //   1531: getfield 745	com/tencent/mm/plugin/sns/ui/c/a/c:Qcq	Landroid/view/ViewGroup;
    //   1534: invokestatic 753	com/tencent/mm/plugin/sns/ad/j/l:W	(Landroid/view/ViewGroup;)V
    //   1537: aload_0
    //   1538: new 285	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView
    //   1541: dup
    //   1542: aload_0
    //   1543: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   1546: iconst_0
    //   1547: invokespecial 756	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:<init>	(Landroid/content/Context;B)V
    //   1550: putfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1553: aload_0
    //   1554: getfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1557: invokevirtual 759	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:hmy	()V
    //   1560: aload_0
    //   1561: getfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1564: getstatic 765	com/tencent/mm/pluginsdk/ui/i$e:XYN	Lcom/tencent/mm/pluginsdk/ui/i$e;
    //   1567: invokevirtual 769	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:setVideoScaleType	(Lcom/tencent/mm/pluginsdk/ui/i$e;)V
    //   1570: aload_0
    //   1571: getfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1574: getstatic 775	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   1577: invokevirtual 779	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:setThumbViewScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1580: aload_0
    //   1581: getfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1584: iconst_m1
    //   1585: iconst_m1
    //   1586: invokestatic 749	com/tencent/mm/plugin/sns/ad/j/l:z	(Landroid/view/View;II)V
    //   1589: aload_0
    //   1590: getfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1593: iconst_1
    //   1594: invokestatic 783	com/tencent/mm/plugin/sns/ad/j/l:C	(Landroid/view/View;Z)V
    //   1597: aload_0
    //   1598: getfield 745	com/tencent/mm/plugin/sns/ui/c/a/c:Qcq	Landroid/view/ViewGroup;
    //   1601: aload_0
    //   1602: getfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1605: iconst_0
    //   1606: invokestatic 786	com/tencent/mm/plugin/sns/ad/j/l:b	(Landroid/view/ViewGroup;Landroid/view/View;I)Z
    //   1609: pop
    //   1610: aload_0
    //   1611: getfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1614: new 10	com/tencent/mm/plugin/sns/ui/c/a/c$3
    //   1617: dup
    //   1618: aload_0
    //   1619: invokespecial 787	com/tencent/mm/plugin/sns/ui/c/a/c$3:<init>	(Lcom/tencent/mm/plugin/sns/ui/c/a/c;)V
    //   1622: invokevirtual 791	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:setUICallback	(Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView$b;)V
    //   1625: aload_0
    //   1626: getfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1629: new 793	com/tencent/mm/plugin/sns/ad/timeline/video/online/a
    //   1632: dup
    //   1633: aload_0
    //   1634: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1637: aload_0
    //   1638: getfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1641: aload_0
    //   1642: getfield 122	com/tencent/mm/plugin/sns/ui/c/a/c:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   1645: iconst_3
    //   1646: invokespecial 796	com/tencent/mm/plugin/sns/ad/timeline/video/online/a:<init>	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/ui/OnlineVideoView;Lcom/tencent/mm/plugin/sns/ad/g/l;I)V
    //   1649: invokevirtual 800	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:setVideoCallback	(Lcom/tencent/mm/plugin/sns/ui/OnlineVideoView$b;)V
    //   1652: ldc 245
    //   1654: new 247	java/lang/StringBuilder
    //   1657: dup
    //   1658: ldc_w 802
    //   1661: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1664: aload_0
    //   1665: getfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1668: invokevirtual 452	java/lang/Object:hashCode	()I
    //   1671: invokevirtual 805	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1674: ldc_w 807
    //   1677: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: aload_0
    //   1681: getfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1684: invokevirtual 811	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:getInnerVideoView	()Landroid/view/View;
    //   1687: invokevirtual 814	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1690: invokevirtual 266	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1693: invokestatic 271	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1696: aload_0
    //   1697: getfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1700: iconst_1
    //   1701: invokevirtual 818	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:setMute	(Z)V
    //   1704: aload_0
    //   1705: getfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1708: aload 6
    //   1710: aload_0
    //   1711: getfield 130	com/tencent/mm/plugin/sns/ui/c/a/c:hES	Ljava/lang/String;
    //   1714: aload_0
    //   1715: getfield 112	com/tencent/mm/plugin/sns/ui/c/a/c:timeLineObject	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1718: getfield 821	com/tencent/mm/protocal/protobuf/TimeLineObject:CreateTime	I
    //   1721: invokevirtual 824	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:a	(Lcom/tencent/mm/protocal/protobuf/dmz;Ljava/lang/String;I)V
    //   1724: aload_0
    //   1725: getfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1728: invokevirtual 827	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:abandonAudioFocus	()V
    //   1731: aload_0
    //   1732: getfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   1735: invokevirtual 830	com/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView:grj	()V
    //   1738: aload_0
    //   1739: getfield 101	com/tencent/mm/plugin/sns/ui/c/a/c:PRJ	Landroid/os/Handler;
    //   1742: aconst_null
    //   1743: invokevirtual 833	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   1746: aload_0
    //   1747: getfield 101	com/tencent/mm/plugin/sns/ui/c/a/c:PRJ	Landroid/os/Handler;
    //   1750: new 12	com/tencent/mm/plugin/sns/ui/c/a/c$4
    //   1753: dup
    //   1754: aload_0
    //   1755: invokespecial 834	com/tencent/mm/plugin/sns/ui/c/a/c$4:<init>	(Lcom/tencent/mm/plugin/sns/ui/c/a/c;)V
    //   1758: ldc2_w 835
    //   1761: invokevirtual 840	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   1764: pop
    //   1765: aload_0
    //   1766: getfield 275	com/tencent/mm/plugin/sns/ui/c/a/c:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   1769: getfield 683	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1772: iconst_0
    //   1773: invokestatic 783	com/tencent/mm/plugin/sns/ad/j/l:C	(Landroid/view/View;Z)V
    //   1776: aload_0
    //   1777: iconst_1
    //   1778: putfield 108	com/tencent/mm/plugin/sns/ui/c/a/c:RJw	Z
    //   1781: goto -1359 -> 422
    //   1784: aload 6
    //   1786: iconst_0
    //   1787: invokestatic 843	com/tencent/mm/plugin/sns/ad/d/e:a	(Lcom/tencent/mm/protocal/protobuf/dmz;Z)V
    //   1790: goto -640 -> 1150
    //   1793: aload 8
    //   1795: aload_0
    //   1796: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1799: aconst_null
    //   1800: invokevirtual 740	com/tencent/mm/plugin/sns/model/g:b	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;[I)I
    //   1803: iconst_5
    //   1804: if_icmpne +40 -> 1844
    //   1807: aload 8
    //   1809: aload 6
    //   1811: invokevirtual 847	com/tencent/mm/plugin/sns/model/g:B	(Lcom/tencent/mm/protocal/protobuf/dmz;)V
    //   1814: aload 7
    //   1816: getfield 676	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1819: bipush 8
    //   1821: invokevirtual 679	android/widget/ImageView:setVisibility	(I)V
    //   1824: aload 7
    //   1826: getfield 683	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1829: iconst_0
    //   1830: invokevirtual 686	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   1833: aload 7
    //   1835: getfield 683	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1838: invokevirtual 689	com/tencent/mm/ui/widget/MMPinProgressBtn:jEN	()V
    //   1841: goto -587 -> 1254
    //   1844: aload 8
    //   1846: aload 6
    //   1848: invokevirtual 850	com/tencent/mm/plugin/sns/model/g:y	(Lcom/tencent/mm/protocal/protobuf/dmz;)Z
    //   1851: ifeq +36 -> 1887
    //   1854: aload 7
    //   1856: getfield 683	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1859: bipush 8
    //   1861: invokevirtual 686	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   1864: aload 7
    //   1866: getfield 676	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1869: getstatic 855	com/tencent/mm/plugin/sns/b$i:shortvideo_play_icon_err	I
    //   1872: invokevirtual 858	android/widget/ImageView:setImageResource	(I)V
    //   1875: aload 7
    //   1877: getfield 676	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1880: iconst_0
    //   1881: invokevirtual 679	android/widget/ImageView:setVisibility	(I)V
    //   1884: goto -630 -> 1254
    //   1887: aload 8
    //   1889: aload 6
    //   1891: invokevirtual 860	com/tencent/mm/plugin/sns/model/g:z	(Lcom/tencent/mm/protocal/protobuf/dmz;)V
    //   1894: aload 7
    //   1896: getfield 676	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1899: iconst_0
    //   1900: invokevirtual 679	android/widget/ImageView:setVisibility	(I)V
    //   1903: aload 7
    //   1905: getfield 683	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   1908: bipush 8
    //   1910: invokevirtual 686	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   1913: aload 7
    //   1915: getfield 676	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1918: aload_0
    //   1919: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   1922: getstatic 863	com/tencent/mm/plugin/sns/b$i:shortvideo_play_btn	I
    //   1925: invokestatic 869	com/tencent/mm/cd/a:m	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   1928: invokevirtual 873	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1931: aload 7
    //   1933: getfield 676	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1936: aload_0
    //   1937: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   1940: invokevirtual 149	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1943: getstatic 878	com/tencent/mm/plugin/sns/b$j:play_sight_desc	I
    //   1946: invokevirtual 881	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1949: invokevirtual 884	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   1952: aload 8
    //   1954: aload_0
    //   1955: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1958: aconst_null
    //   1959: invokevirtual 740	com/tencent/mm/plugin/sns/model/g:b	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;[I)I
    //   1962: iconst_4
    //   1963: if_icmpne -709 -> 1254
    //   1966: aload 7
    //   1968: getfield 360	com/tencent/mm/plugin/sns/ui/aw:QRC	Landroid/widget/TextView;
    //   1971: iconst_0
    //   1972: invokevirtual 365	android/widget/TextView:setVisibility	(I)V
    //   1975: goto -721 -> 1254
    //   1978: aload 8
    //   1980: aload 6
    //   1982: invokevirtual 887	com/tencent/mm/plugin/sns/model/g:v	(Lcom/tencent/mm/protocal/protobuf/dmz;)Z
    //   1985: ifeq +197 -> 2182
    //   1988: aload 7
    //   1990: getfield 676	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   1993: iconst_0
    //   1994: invokevirtual 679	android/widget/ImageView:setVisibility	(I)V
    //   1997: aload 7
    //   1999: getfield 683	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   2002: bipush 8
    //   2004: invokevirtual 686	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   2007: aload 7
    //   2009: getfield 676	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   2012: aload_0
    //   2013: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   2016: getstatic 863	com/tencent/mm/plugin/sns/b$i:shortvideo_play_btn	I
    //   2019: invokestatic 869	com/tencent/mm/cd/a:m	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   2022: invokevirtual 873	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2025: aload 7
    //   2027: getfield 676	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   2030: aload_0
    //   2031: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   2034: invokevirtual 149	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2037: getstatic 878	com/tencent/mm/plugin/sns/b$j:play_sight_desc	I
    //   2040: invokevirtual 881	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2043: invokevirtual 884	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   2046: aload 7
    //   2048: getfield 281	com/tencent/mm/plugin/sns/ui/aw:RjM	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   2051: getfield 893	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView:PGy	Lcom/tencent/mm/plugin/sight/decode/model/SightPlayController;
    //   2054: invokevirtual 898	com/tencent/mm/plugin/sight/decode/model/SightPlayController:gYv	()Z
    //   2057: ifeq -803 -> 1254
    //   2060: ldc 245
    //   2062: new 247	java/lang/StringBuilder
    //   2065: dup
    //   2066: ldc_w 900
    //   2069: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2072: aload 6
    //   2074: getfield 701	com/tencent/mm/protocal/protobuf/dmz:Id	Ljava/lang/String;
    //   2077: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2080: ldc_w 902
    //   2083: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2086: aload 6
    //   2088: getfield 905	com/tencent/mm/protocal/protobuf/dmz:Url	Ljava/lang/String;
    //   2091: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2094: ldc_w 902
    //   2097: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2100: aload 6
    //   2102: getfield 908	com/tencent/mm/protocal/protobuf/dmz:aaTl	Ljava/lang/String;
    //   2105: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2108: invokevirtual 266	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2111: invokestatic 911	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2114: aload 8
    //   2116: aload 6
    //   2118: invokevirtual 860	com/tencent/mm/plugin/sns/model/g:z	(Lcom/tencent/mm/protocal/protobuf/dmz;)V
    //   2121: aload 7
    //   2123: getfield 676	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   2126: iconst_0
    //   2127: invokevirtual 679	android/widget/ImageView:setVisibility	(I)V
    //   2130: aload 7
    //   2132: getfield 683	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   2135: bipush 8
    //   2137: invokevirtual 686	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   2140: aload 7
    //   2142: getfield 676	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   2145: aload_0
    //   2146: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   2149: getstatic 863	com/tencent/mm/plugin/sns/b$i:shortvideo_play_btn	I
    //   2152: invokestatic 869	com/tencent/mm/cd/a:m	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   2155: invokevirtual 873	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2158: aload 7
    //   2160: getfield 676	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   2163: aload_0
    //   2164: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   2167: invokevirtual 149	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2170: getstatic 878	com/tencent/mm/plugin/sns/b$j:play_sight_desc	I
    //   2173: invokevirtual 881	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2176: invokevirtual 884	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   2179: goto -925 -> 1254
    //   2182: aload 8
    //   2184: aload 6
    //   2186: invokevirtual 914	com/tencent/mm/plugin/sns/model/g:w	(Lcom/tencent/mm/protocal/protobuf/dmz;)Z
    //   2189: ifeq +26 -> 2215
    //   2192: aload 7
    //   2194: getfield 676	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   2197: bipush 8
    //   2199: invokevirtual 679	android/widget/ImageView:setVisibility	(I)V
    //   2202: aload 7
    //   2204: getfield 683	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   2207: bipush 8
    //   2209: invokevirtual 686	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   2212: goto -166 -> 2046
    //   2215: aload 8
    //   2217: aload_0
    //   2218: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   2221: aconst_null
    //   2222: invokevirtual 740	com/tencent/mm/plugin/sns/model/g:b	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;[I)I
    //   2225: iconst_5
    //   2226: if_icmpgt +26 -> 2252
    //   2229: aload 7
    //   2231: getfield 676	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   2234: bipush 8
    //   2236: invokevirtual 679	android/widget/ImageView:setVisibility	(I)V
    //   2239: aload 7
    //   2241: getfield 683	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   2244: bipush 8
    //   2246: invokevirtual 686	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   2249: goto -203 -> 2046
    //   2252: aload 8
    //   2254: aload 6
    //   2256: invokevirtual 860	com/tencent/mm/plugin/sns/model/g:z	(Lcom/tencent/mm/protocal/protobuf/dmz;)V
    //   2259: aload 7
    //   2261: getfield 676	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   2264: iconst_0
    //   2265: invokevirtual 679	android/widget/ImageView:setVisibility	(I)V
    //   2268: aload 7
    //   2270: getfield 683	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
    //   2273: bipush 8
    //   2275: invokevirtual 686	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
    //   2278: aload 7
    //   2280: getfield 676	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   2283: aload_0
    //   2284: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   2287: getstatic 863	com/tencent/mm/plugin/sns/b$i:shortvideo_play_btn	I
    //   2290: invokestatic 869	com/tencent/mm/cd/a:m	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   2293: invokevirtual 873	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2296: aload 7
    //   2298: getfield 676	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
    //   2301: aload_0
    //   2302: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   2305: invokevirtual 149	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2308: getstatic 878	com/tencent/mm/plugin/sns/b$j:play_sight_desc	I
    //   2311: invokevirtual 881	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2314: invokevirtual 884	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   2317: goto -271 -> 2046
    //   2320: aload 8
    //   2322: aload_0
    //   2323: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   2326: aload 6
    //   2328: aload 7
    //   2330: getfield 281	com/tencent/mm/plugin/sns/ui/aw:RjM	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   2333: aload_0
    //   2334: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   2337: invokevirtual 452	java/lang/Object:hashCode	()I
    //   2340: iconst_0
    //   2341: getstatic 458	com/tencent/mm/storage/br:adkc	Lcom/tencent/mm/storage/br;
    //   2344: iconst_1
    //   2345: iconst_1
    //   2346: invokevirtual 917	com/tencent/mm/plugin/sns/model/g:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/protocal/protobuf/dmz;Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;IILcom/tencent/mm/storage/br;ZZ)Z
    //   2349: pop
    //   2350: goto -1003 -> 1347
    //   2353: aload_0
    //   2354: getfield 122	com/tencent/mm/plugin/sns/ui/c/a/c:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   2357: aload_0
    //   2358: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/c:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   2361: getfield 292	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   2364: aload 6
    //   2366: getfield 721	com/tencent/mm/protocal/protobuf/dmz:aaTF	F
    //   2369: f2i
    //   2370: iconst_0
    //   2371: invokevirtual 725	com/tencent/mm/plugin/sns/ad/g/l:g	(JIZ)V
    //   2374: goto -902 -> 1472
    //   2377: iconst_0
    //   2378: istore 5
    //   2380: goto -890 -> 1490
    //   2383: ldc 245
    //   2385: new 247	java/lang/StringBuilder
    //   2388: dup
    //   2389: ldc_w 919
    //   2392: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2395: aload_0
    //   2396: getfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   2399: invokevirtual 452	java/lang/Object:hashCode	()I
    //   2402: invokevirtual 805	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2405: ldc_w 921
    //   2408: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2411: aload_0
    //   2412: getfield 283	com/tencent/mm/plugin/sns/ui/c/a/c:RJv	Lcom/tencent/mm/plugin/sns/ui/video/SnsTimelineVideoView;
    //   2415: getfield 926	com/tencent/mm/plugin/sns/ui/OnlineVideoView:Aqa	Z
    //   2418: invokevirtual 256	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2421: invokevirtual 266	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2424: invokestatic 271	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2427: goto -731 -> 1696
    //   2430: aload 7
    //   2432: getfield 281	com/tencent/mm/plugin/sns/ui/aw:RjM	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   2435: invokevirtual 929	com/tencent/mm/pluginsdk/ui/tools/VideoSightView:start	()Z
    //   2438: pop
    //   2439: aload_0
    //   2440: iconst_1
    //   2441: putfield 108	com/tencent/mm/plugin/sns/ui/c/a/c:RJw	Z
    //   2444: goto -2022 -> 422
    //   2447: aload 8
    //   2449: aload_0
    //   2450: getfield 275	com/tencent/mm/plugin/sns/ui/c/a/c:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   2453: getfield 281	com/tencent/mm/plugin/sns/ui/aw:RjM	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   2456: aload_0
    //   2457: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   2460: invokevirtual 452	java/lang/Object:hashCode	()I
    //   2463: iconst_0
    //   2464: invokevirtual 932	com/tencent/mm/plugin/sns/model/g:a	(Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;II)Z
    //   2467: pop
    //   2468: aload_0
    //   2469: getfield 275	com/tencent/mm/plugin/sns/ui/c/a/c:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   2472: getfield 935	com/tencent/mm/plugin/sns/ui/aw:RjQ	Landroid/widget/TextView;
    //   2475: bipush 8
    //   2477: invokevirtual 365	android/widget/TextView:setVisibility	(I)V
    //   2480: aload_0
    //   2481: getfield 275	com/tencent/mm/plugin/sns/ui/c/a/c:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   2484: getfield 281	com/tencent/mm/plugin/sns/ui/aw:RjM	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   2487: aconst_null
    //   2488: invokevirtual 939	com/tencent/mm/pluginsdk/ui/tools/VideoSightView:setOnSightCompletionAction	(Lcom/tencent/mm/plugin/sight/decode/model/SightPlayController$f;)V
    //   2491: aload_0
    //   2492: getfield 275	com/tencent/mm/plugin/sns/ui/c/a/c:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   2495: getfield 281	com/tencent/mm/plugin/sns/ui/aw:RjM	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   2498: aconst_null
    //   2499: invokevirtual 634	com/tencent/mm/pluginsdk/ui/tools/VideoSightView:setOnCompletionListener	(Lcom/tencent/mm/plugin/sight/decode/model/SightPlayController$d;)V
    //   2502: aload_0
    //   2503: getfield 275	com/tencent/mm/plugin/sns/ui/c/a/c:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
    //   2506: getfield 281	com/tencent/mm/plugin/sns/ui/aw:RjM	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
    //   2509: aconst_null
    //   2510: invokevirtual 639	com/tencent/mm/pluginsdk/ui/tools/VideoSightView:setOnDecodeDurationListener	(Lcom/tencent/mm/plugin/sight/decode/model/SightPlayController$e;)V
    //   2513: goto -2091 -> 422
    //   2516: aload_0
    //   2517: getfield 500	com/tencent/mm/plugin/sns/ui/c/a/c:RJm	Landroid/view/View;
    //   2520: bipush 8
    //   2522: invokevirtual 501	android/view/View:setVisibility	(I)V
    //   2525: goto -2004 -> 521
    //   2528: iconst_1
    //   2529: istore_1
    //   2530: goto -1976 -> 554
    //   2533: aload_0
    //   2534: getfield 941	com/tencent/mm/plugin/sns/ui/c/a/c:RJs	Lcom/tencent/mm/plugin/sns/ad/widget/living/c;
    //   2537: ifnonnull +26 -> 2563
    //   2540: aload_0
    //   2541: new 943	com/tencent/mm/plugin/sns/ad/widget/living/c
    //   2544: dup
    //   2545: aload_0
    //   2546: getfield 521	com/tencent/mm/plugin/sns/ui/c/a/c:Qcn	Landroid/view/ViewGroup;
    //   2549: aload_0
    //   2550: getfield 535	com/tencent/mm/plugin/sns/ui/c/a/c:RJr	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   2553: aload_0
    //   2554: getfield 503	com/tencent/mm/plugin/sns/ui/c/a/c:RJp	Lcom/tencent/mm/plugin/sns/ui/ay;
    //   2557: invokespecial 946	com/tencent/mm/plugin/sns/ad/widget/living/c:<init>	(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;Lcom/tencent/mm/plugin/sns/ui/ay;)V
    //   2560: putfield 941	com/tencent/mm/plugin/sns/ui/c/a/c:RJs	Lcom/tencent/mm/plugin/sns/ad/widget/living/c;
    //   2563: aload 7
    //   2565: ifnull +146 -> 2711
    //   2568: aload_0
    //   2569: getfield 941	com/tencent/mm/plugin/sns/ui/c/a/c:RJs	Lcom/tencent/mm/plugin/sns/ad/widget/living/c;
    //   2572: ifnull +139 -> 2711
    //   2575: aload 6
    //   2577: invokevirtual 186	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   2580: getfield 515	com/tencent/mm/plugin/sns/storage/ADXml:adLiveInfo	Lcom/tencent/mm/plugin/sns/ad/adxml/i;
    //   2583: astore 8
    //   2585: aload 7
    //   2587: getfield 947	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   2590: aload 8
    //   2592: getfield 952	com/tencent/mm/plugin/sns/ad/adxml/i:liveType	I
    //   2595: invokestatic 958	com/tencent/mm/plugin/sns/ad/widget/living/b:gQ	(Ljava/lang/String;I)I
    //   2598: istore_1
    //   2599: aload_0
    //   2600: getfield 941	com/tencent/mm/plugin/sns/ui/c/a/c:RJs	Lcom/tencent/mm/plugin/sns/ad/widget/living/c;
    //   2603: aload 7
    //   2605: getfield 947	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   2608: aload 8
    //   2610: invokevirtual 961	com/tencent/mm/plugin/sns/ad/widget/living/c:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/sns/ad/adxml/i;)V
    //   2613: aload_0
    //   2614: getfield 941	com/tencent/mm/plugin/sns/ui/c/a/c:RJs	Lcom/tencent/mm/plugin/sns/ad/widget/living/c;
    //   2617: iload_1
    //   2618: invokevirtual 964	com/tencent/mm/plugin/sns/ad/widget/living/c:setLiveStatus	(I)V
    //   2621: aload 7
    //   2623: getfield 947	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   2626: aload_0
    //   2627: getfield 941	com/tencent/mm/plugin/sns/ui/c/a/c:RJs	Lcom/tencent/mm/plugin/sns/ad/widget/living/c;
    //   2630: invokestatic 967	com/tencent/mm/plugin/sns/ad/widget/living/b:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/sns/ad/widget/living/b$a;)V
    //   2633: invokestatic 973	com/tencent/mm/plugin/sns/ad/timeline/dynamic/a:hbB	()Lcom/tencent/mm/plugin/sns/ad/timeline/dynamic/a;
    //   2636: iconst_1
    //   2637: aload 6
    //   2639: invokevirtual 976	com/tencent/mm/plugin/sns/ad/timeline/dynamic/a:d	(ILcom/tencent/mm/plugin/sns/storage/SnsInfo;)V
    //   2642: iload_1
    //   2643: invokestatic 980	com/tencent/mm/plugin/sns/ad/widget/living/c:ajZ	(I)Z
    //   2646: istore 5
    //   2648: aload 7
    //   2650: getfield 947	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   2653: astore 6
    //   2655: aload 8
    //   2657: iload 5
    //   2659: invokestatic 985	com/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper:a	(Lcom/tencent/mm/plugin/sns/ad/adxml/i;Z)Z
    //   2662: ifeq +102 -> 2764
    //   2665: aload_0
    //   2666: getfield 987	com/tencent/mm/plugin/sns/ui/c/a/c:Qcp	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   2669: ifnonnull +17 -> 2686
    //   2672: aload_0
    //   2673: aload_0
    //   2674: getfield 989	com/tencent/mm/plugin/sns/ui/c/a/c:Qco	Landroid/view/ViewStub;
    //   2677: invokevirtual 992	android/view/ViewStub:inflate	()Landroid/view/View;
    //   2680: checkcast 982	com/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper
    //   2683: putfield 987	com/tencent/mm/plugin/sns/ui/c/a/c:Qcp	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   2686: aload_0
    //   2687: getfield 987	com/tencent/mm/plugin/sns/ui/c/a/c:Qcp	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   2690: ifnull +21 -> 2711
    //   2693: new 18	com/tencent/mm/plugin/sns/ui/c/a/c$7
    //   2696: dup
    //   2697: aload_0
    //   2698: aload 8
    //   2700: aload 6
    //   2702: invokespecial 995	com/tencent/mm/plugin/sns/ui/c/a/c$7:<init>	(Lcom/tencent/mm/plugin/sns/ui/c/a/c;Lcom/tencent/mm/plugin/sns/ad/adxml/i;Ljava/lang/String;)V
    //   2705: ldc2_w 996
    //   2708: invokestatic 1003	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThreadDelayed	(Ljava/lang/Runnable;J)V
    //   2711: aload_0
    //   2712: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   2715: invokestatic 1009	com/tencent/mm/plugin/sns/data/m:jP	(Landroid/content/Context;)Z
    //   2718: ifeq -2053 -> 665
    //   2721: aload_0
    //   2722: getfield 535	com/tencent/mm/plugin/sns/ui/c/a/c:RJr	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   2725: bipush 8
    //   2727: invokevirtual 1010	com/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout:setVisibility	(I)V
    //   2730: goto -2065 -> 665
    //   2733: astore 6
    //   2735: ldc 245
    //   2737: new 247	java/lang/StringBuilder
    //   2740: dup
    //   2741: ldc_w 1012
    //   2744: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2747: aload 6
    //   2749: invokestatic 1018	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2752: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2755: invokevirtual 266	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2758: invokestatic 311	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2761: goto -2096 -> 665
    //   2764: aload_0
    //   2765: getfield 987	com/tencent/mm/plugin/sns/ui/c/a/c:Qcp	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   2768: ifnull -57 -> 2711
    //   2771: aload_0
    //   2772: getfield 987	com/tencent/mm/plugin/sns/ui/c/a/c:Qcp	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   2775: bipush 8
    //   2777: invokevirtual 1019	com/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper:setVisibility	(I)V
    //   2780: goto -69 -> 2711
    //   2783: aload_0
    //   2784: getfield 521	com/tencent/mm/plugin/sns/ui/c/a/c:Qcn	Landroid/view/ViewGroup;
    //   2787: ifnull +12 -> 2799
    //   2790: aload_0
    //   2791: getfield 521	com/tencent/mm/plugin/sns/ui/c/a/c:Qcn	Landroid/view/ViewGroup;
    //   2794: bipush 8
    //   2796: invokevirtual 1020	android/view/ViewGroup:setVisibility	(I)V
    //   2799: aload_0
    //   2800: getfield 535	com/tencent/mm/plugin/sns/ui/c/a/c:RJr	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   2803: ifnull +12 -> 2815
    //   2806: aload_0
    //   2807: getfield 535	com/tencent/mm/plugin/sns/ui/c/a/c:RJr	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   2810: bipush 8
    //   2812: invokevirtual 1010	com/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout:setVisibility	(I)V
    //   2815: aload_0
    //   2816: getfield 987	com/tencent/mm/plugin/sns/ui/c/a/c:Qcp	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   2819: ifnull -2154 -> 665
    //   2822: aload_0
    //   2823: getfield 987	com/tencent/mm/plugin/sns/ui/c/a/c:Qcp	Lcom/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper;
    //   2826: bipush 8
    //   2828: invokevirtual 1019	com/tencent/mm/plugin/sns/ad/widget/living/FinderLivingAnimWrapper:setVisibility	(I)V
    //   2831: goto -2166 -> 665
    //   2834: aload 6
    //   2836: invokevirtual 186	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   2839: getfield 546	com/tencent/mm/plugin/sns/storage/ADXml:adPromotionInfo	Lcom/tencent/mm/plugin/sns/ad/adxml/j;
    //   2842: astore 7
    //   2844: aload 7
    //   2846: ifnull +193 -> 3039
    //   2849: aload 7
    //   2851: getfield 588	com/tencent/mm/plugin/sns/ad/adxml/j:startTime	J
    //   2854: aload 7
    //   2856: getfield 591	com/tencent/mm/plugin/sns/ad/adxml/j:endTime	J
    //   2859: invokestatic 1026	com/tencent/mm/plugin/sns/ad/j/f:bk	(JJ)Z
    //   2862: ifeq +177 -> 3039
    //   2865: aload_0
    //   2866: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   2869: invokestatic 1009	com/tencent/mm/plugin/sns/data/m:jP	(Landroid/content/Context;)Z
    //   2872: ifne +167 -> 3039
    //   2875: iconst_1
    //   2876: istore_1
    //   2877: goto -2190 -> 687
    //   2880: aload_0
    //   2881: getfield 548	com/tencent/mm/plugin/sns/ui/c/a/c:RJn	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   2884: ifnull -2061 -> 823
    //   2887: aload_0
    //   2888: getfield 548	com/tencent/mm/plugin/sns/ui/c/a/c:RJn	Lcom/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout;
    //   2891: bipush 8
    //   2893: invokevirtual 554	com/tencent/mm/plugin/sns/ad/widget/countdown/PromotionBarLayout:setVisibility	(I)V
    //   2896: goto -2073 -> 823
    //   2899: astore 6
    //   2901: goto -2078 -> 823
    //   2904: iconst_0
    //   2905: istore_1
    //   2906: goto -2051 -> 855
    //   2909: aload_0
    //   2910: getfield 1028	com/tencent/mm/plugin/sns/ui/c/a/c:RJu	Lcom/tencent/mm/plugin/sns/ad/timeline/helper/g;
    //   2913: ifnonnull +18 -> 2931
    //   2916: aload_0
    //   2917: new 1030	com/tencent/mm/plugin/sns/ad/timeline/helper/g
    //   2920: dup
    //   2921: aload_0
    //   2922: getfield 603	com/tencent/mm/plugin/sns/ui/c/a/c:RJt	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   2925: invokespecial 1033	com/tencent/mm/plugin/sns/ad/timeline/helper/g:<init>	(Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;)V
    //   2928: putfield 1028	com/tencent/mm/plugin/sns/ui/c/a/c:RJu	Lcom/tencent/mm/plugin/sns/ad/timeline/helper/g;
    //   2931: aload_0
    //   2932: getfield 1028	com/tencent/mm/plugin/sns/ui/c/a/c:RJu	Lcom/tencent/mm/plugin/sns/ad/timeline/helper/g;
    //   2935: aload 6
    //   2937: putfield 1036	com/tencent/mm/plugin/sns/ad/timeline/helper/g:Qaw	Lcom/tencent/mm/plugin/sns/ad/adxml/k;
    //   2940: aload_0
    //   2941: getfield 1028	com/tencent/mm/plugin/sns/ui/c/a/c:RJu	Lcom/tencent/mm/plugin/sns/ad/timeline/helper/g;
    //   2944: invokevirtual 1039	com/tencent/mm/plugin/sns/ad/timeline/helper/g:hbU	()V
    //   2947: aload_0
    //   2948: getfield 1028	com/tencent/mm/plugin/sns/ui/c/a/c:RJu	Lcom/tencent/mm/plugin/sns/ad/timeline/helper/g;
    //   2951: invokevirtual 1042	com/tencent/mm/plugin/sns/ad/timeline/helper/g:hbR	()V
    //   2954: aload_0
    //   2955: getfield 1028	com/tencent/mm/plugin/sns/ui/c/a/c:RJu	Lcom/tencent/mm/plugin/sns/ad/timeline/helper/g;
    //   2958: invokevirtual 1045	com/tencent/mm/plugin/sns/ad/timeline/helper/g:hbS	()V
    //   2961: aload_0
    //   2962: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/c:context	Landroid/content/Context;
    //   2965: invokestatic 1009	com/tencent/mm/plugin/sns/data/m:jP	(Landroid/content/Context;)Z
    //   2968: ifeq +12 -> 2980
    //   2971: aload_0
    //   2972: getfield 603	com/tencent/mm/plugin/sns/ui/c/a/c:RJt	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   2975: bipush 8
    //   2977: invokevirtual 1010	com/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout:setVisibility	(I)V
    //   2980: ldc_w 313
    //   2983: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2986: return
    //   2987: astore 6
    //   2989: ldc 245
    //   2991: aload 6
    //   2993: invokevirtual 308	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2996: invokestatic 311	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2999: ldc_w 313
    //   3002: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3005: return
    //   3006: aload_0
    //   3007: getfield 603	com/tencent/mm/plugin/sns/ui/c/a/c:RJt	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   3010: ifnull +12 -> 3022
    //   3013: aload_0
    //   3014: getfield 603	com/tencent/mm/plugin/sns/ui/c/a/c:RJt	Lcom/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout;
    //   3017: bipush 8
    //   3019: invokevirtual 1010	com/tencent/mm/plugin/sns/ad/widget/living/LivingDescBarLayout:setVisibility	(I)V
    //   3022: ldc_w 313
    //   3025: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3028: return
    //   3029: iconst_0
    //   3030: istore_1
    //   3031: goto -2477 -> 554
    //   3034: iconst_0
    //   3035: istore_1
    //   3036: goto -2349 -> 687
    //   3039: iconst_0
    //   3040: istore_1
    //   3041: goto -2354 -> 687
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3044	0	this	c
    //   252	2789	1	i	int
    //   274	1246	2	j	int
    //   1153	31	3	l	long
    //   1159	1499	5	bool	boolean
    //   38	2663	6	localObject1	Object
    //   2733	102	6	localThrowable	Throwable
    //   2899	37	6	localObject2	Object
    //   2987	5	6	localObject3	Object
    //   187	711	7	localObject4	Object
    //   960	14	7	localObject5	Object
    //   1060	1795	7	localObject6	Object
    //   139	2560	8	localObject7	Object
    //   1372	15	9	str	String
    // Exception table:
    //   from	to	target	type
    //   144	189	960	finally
    //   532	551	2733	finally
    //   558	587	2733	finally
    //   592	604	2733	finally
    //   604	626	2733	finally
    //   631	643	2733	finally
    //   643	657	2733	finally
    //   657	665	2733	finally
    //   2533	2563	2733	finally
    //   2568	2686	2733	finally
    //   2686	2711	2733	finally
    //   2711	2730	2733	finally
    //   2764	2780	2733	finally
    //   2783	2799	2733	finally
    //   2799	2815	2733	finally
    //   2815	2831	2733	finally
    //   676	684	2899	finally
    //   691	723	2899	finally
    //   728	740	2899	finally
    //   740	823	2899	finally
    //   2834	2844	2899	finally
    //   2849	2875	2899	finally
    //   2880	2896	2899	finally
    //   834	853	2987	finally
    //   859	891	2987	finally
    //   896	916	2987	finally
    //   916	923	2987	finally
    //   928	936	2987	finally
    //   2909	2931	2987	finally
    //   2931	2980	2987	finally
    //   2980	2986	2987	finally
    //   3006	3022	2987	finally
  }
  
  public final void t(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100009);
    this.contentView = paramView1;
    this.context = paramView1.getContext();
    this.RoA = paramView2;
    this.RJk = this.contentView.findViewById(b.f.media_container);
    if ((this.RJk instanceof RoundedCornerFrameLayout)) {
      ((RoundedCornerFrameLayout)this.RJk).setRadius(com.tencent.mm.cd.a.fromDPToPix(this.context, 4));
    }
    this.RJl = this.contentView.findViewById(b.f.other_container);
    this.RJc = this.contentView.findViewById(b.f.card_btn_container);
    this.RJc.setVisibility(8);
    this.RJf = this.contentView.findViewById(b.f.card_weapp_tag);
    this.RJg = ((ImageView)this.contentView.findViewById(b.f.weapp_auth_icon_iv));
    this.RJf.setVisibility(8);
    this.RJh = ((MaskImageView)this.contentView.findViewById(b.f.sns_card_ad_image));
    this.RJd = ((Button)this.contentView.findViewById(b.f.card_btn_left));
    this.RJe = ((Button)this.contentView.findViewById(b.f.card_btn_right));
    this.RJm = this.contentView.findViewById(b.f.action_btn_container);
    this.Qcq = ((ViewGroup)this.contentView.findViewById(b.f.sns_card_ad_online_video_container));
    this.RJg.setTag("");
    if (this.RJg.getVisibility() == 0) {
      this.RJg.setVisibility(4);
    }
    paramView2 = (TextView)this.contentView.findViewById(b.f.weapp_tag_name);
    Object localObject = this.PNI.getAdInfo();
    if ((localObject != null) && (((ADInfo)localObject).isWeapp()) && (!this.PNI.isTurnCardAd()))
    {
      this.RJf.setVisibility(0);
      paramView2.setText(b.j.sns_ad_card_weapp_tag);
      com.tencent.mm.plugin.sns.ad.d.i.a(((ADInfo)localObject).actionExtWeApp.appUserName, this.RJg, (ADInfo)localObject);
      if (this.RJf.getVisibility() == 0)
      {
        paramView2 = (ImageView)this.contentView.findViewById(b.f.weapp_icon_iv);
        if (!com.tencent.mm.ui.aw.isDarkMode()) {
          break label1683;
        }
        if (!n.a(this.PNI.getAdXml(), this.PNI.getAdInfo())) {
          break label1673;
        }
        paramView2.setImageResource(b.i.album_ad_finder_link_dark_icon);
      }
      label389:
      this.RJb = ((TextView)this.contentView.findViewById(b.f.desc_collapse_pic_style_tv));
      this.RJb.setClickable(false);
      this.RJb.setLongClickable(false);
      this.QbW = com.tencent.mm.plugin.sns.ad.timeline.helper.b.b(this.timeLineObject, this.PNI.getAdXml());
      localObject = new StringBuilder("card ad detail useOnlineVideo=").append(this.QbW).append(", snsId=");
      if (this.timeLineObject != null) {
        break label1723;
      }
      paramView2 = "";
      label476:
      Log.i("MicroMsg.CardAdDetailItemView", paramView2);
      paramView2 = (WindowManager)this.context.getSystemService("window");
      this.RJo = (Math.min(paramView2.getDefaultDisplay().getWidth(), paramView2.getDefaultDisplay().getHeight()) - this.context.getResources().getDimensionPixelSize(b.d.sns_avatar_size) - this.context.getResources().getDimensionPixelSize(b.d.Edge_0_5_A) - this.context.getResources().getDimensionPixelSize(b.d.NormalPadding) - this.context.getResources().getDimensionPixelSize(b.d.NormalPadding));
      if (com.tencent.mm.ui.aw.jkS()) {
        this.RJo = bd.bs(MMApplicationContext.getContext(), b.d.sns_timeline_item_large_screen_width);
      }
      paramView2 = (ViewGroup.MarginLayoutParams)this.contentView.getLayoutParams();
      paramView2.topMargin = this.context.getResources().getDimensionPixelOffset(b.d.MiddlePadding);
      paramView2.bottomMargin = 0;
      paramView2.width = this.RJo;
      paramView2.height = -2;
      this.contentView.setLayoutParams(paramView2);
      this.contentView.setBackground(this.context.getResources().getDrawable(b.e.sns_ad_pic_style_bg));
      this.RJa = ((TextView)this.contentView.findViewById(b.f.desc_collapse_pic_style_title_tv));
      this.RJa.setClickable(false);
      this.RJa.setLongClickable(false);
      if (Util.isNullOrNil(this.PNI.getAdXml().adCardTitle)) {
        break label1734;
      }
      paramView2 = u.iVt().a(this.RJa.getContext(), this.PNI.getAdXml().adCardTitle, this.RJa.getTextSize());
      this.RJa.setText(paramView2);
      this.RJa.setVisibility(0);
      label775:
      if (!Util.isNullOrNil(this.PNI.getAdXml().adCardDesc)) {
        break label1746;
      }
      paramView2 = this.timeLineObject.ContentDesc;
      label799:
      if (Util.isNullOrNil(paramView2)) {
        break label1760;
      }
      paramView2 = u.iVt().a(this.RJb.getContext(), paramView2, this.RJb.getTextSize());
      this.RJb.setText(paramView2);
      this.RJb.setVisibility(0);
      label844:
      this.vEV = new com.tencent.mm.ui.widget.b.a(this.context);
      this.vEV.c(this.contentView, this.PZr.RQm, this.PZr.RPU);
      if ((!this.PNI.getAdXml().hasSelectInfo()) && (!this.PNI.getAdXml().hasVoteInfo())) {
        break label1805;
      }
      if (!this.PNI.getAdXml().isNewStyleVote()) {
        break label1772;
      }
      if (this.RJq == null)
      {
        paramView2 = (ViewStub)this.contentView.findViewById(b.f.sns_ad_card_vote_layout_stub);
        if ((paramView2 != null) && (com.tencent.mm.plugin.sns.ad.j.l.c(paramView2) != null)) {
          this.RJq = new ba(this.context, this.contentView, this.PZr);
        }
      }
      if (this.RJq != null)
      {
        this.RJq.a(this.PNI, this);
        this.RJq.hnn();
      }
      this.RJc.setVisibility(8);
      if (this.RJa != null) {
        this.RJa.setVisibility(8);
      }
      if (this.RJb != null) {
        this.RJb.setVisibility(8);
      }
      label1045:
      this.Qcj = new com.tencent.mm.plugin.sns.ui.aw();
      this.Qcj.RjO = this.contentView.findViewById(b.f.sns_card_ad_sight);
      this.Qcj.RjL = this.Qcj.RjO;
      this.Qcj.RjO.setOnClickListener(this.PZr.RQt);
      this.Qcj.RjM = ((VideoSightView)this.Qcj.RjO.findViewById(b.f.image));
      this.Qcj.RjM.setMute(true);
      this.Qcj.PQu = ((ImageView)this.Qcj.RjO.findViewById(b.f.status_btn));
      this.Qcj.RjP = ((MMPinProgressBtn)this.Qcj.RjO.findViewById(b.f.progress));
      this.Qcj.RjQ = ((TextView)this.Qcj.RjO.findViewById(b.f.endtv));
      this.Qcj.QRC = ((TextView)this.Qcj.RjO.findViewById(b.f.errorTv));
      this.RJj = this.contentView.findViewById(b.f.sns_ad_card_header_container);
      this.RJi = ((SnsCardAdTagListView)this.contentView.findViewById(b.f.card_ad_tag_list));
      this.RJi.setActivityContext((Activity)this.context);
    }
    for (;;)
    {
      try
      {
        paramView2 = this.PNI.getSnsId();
        localObject = this.RJi.getOriginSnsId();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(paramView2))) {
          continue;
        }
        Log.d("SnsCardAdTagUtils", "should refresh adTag");
        i = 0;
        if (i != 0) {
          continue;
        }
        this.RJi.removeAllViews();
        if (this.PNI.getAdXml().adCardTagInfo.QHu.size() > 0)
        {
          this.RJi.setVisibility(0);
          this.RJi.setTagSpace(com.tencent.mm.cd.a.fromDPToPix(this.context, 8));
          this.RJi.lc(this.PNI.getAdXml().adCardTagInfo.QHu);
        }
        this.RJi.setOriginSnsId(paramView2);
      }
      catch (Exception paramView2)
      {
        int i;
        label1673:
        label1683:
        label1723:
        label1734:
        label1746:
        label1760:
        label1772:
        Log.e("MicroMsg.CardAdDetailItemView", paramView2.toString());
        label1805:
        continue;
      }
      if (m.jP(this.context)) {
        this.RJi.setVisibility(8);
      }
      if (!Util.isNullOrNil(this.PNI.getAdXml().adCard3dHeadTitle))
      {
        this.RJj.setVisibility(0);
        this.RJj.findViewById(b.f.sns_ad_card_header_title).setVisibility(0);
        ((TextView)this.RJj.findViewById(b.f.sns_ad_card_header_title)).setText(this.PNI.getAdXml().adCard3dHeadTitle);
      }
      if (!Util.isNullOrNil(this.PNI.getAdXml().adCard3dHeadUrl)) {
        k.a(this.PNI.getAdXml().adCard3dHeadUrl, false, new g.a()
        {
          public final void aWn(String paramAnonymousString)
          {
            AppMethodBeat.i(308849);
            if (!Util.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString, null);
              if (paramAnonymousString != null)
              {
                c.this.RJj.setVisibility(0);
                ImageView localImageView = (ImageView)c.this.RJj.findViewById(b.f.sns_ad_card_header_avatar);
                localImageView.setImageBitmap(paramAnonymousString);
                localImageView.setVisibility(0);
              }
            }
            AppMethodBeat.o(308849);
          }
          
          public final void gZM() {}
          
          public final void gZN() {}
        });
      }
      this.vEV.c(this.contentView, this.PZr.RQm, this.PZr.RPU);
      this.RJh.setVisibility(8);
      this.RJh.setScaleType(QImageView.a.afVc);
      this.Qcj.RjL.setVisibility(8);
      this.Qcj.RjM.PGE = true;
      this.Qcj.RjM.setScaleType(QImageView.a.afVc);
      this.contentView.setOnClickListener(this.PZr.RQG);
      this.Qco = ((ViewStub)paramView1.findViewById(b.f.ad_live_anim_layout_stub));
      AppMethodBeat.o(100009);
      return;
      if (!n.a(this.PNI.getAdXml(), (ADInfo)localObject)) {
        break;
      }
      this.RJf.setVisibility(0);
      paramView2.setText(b.j.finder_app_name);
      break;
      paramView2.setImageResource(b.i.album_ad_link_tag_weapp_dark);
      break label389;
      if (n.a(this.PNI.getAdXml(), this.PNI.getAdInfo()))
      {
        paramView2.setImageResource(b.i.album_ad_finder_link_icon);
        break label389;
      }
      paramView2.setImageResource(b.i.album_ad_link_tag_weapp);
      break label389;
      paramView2 = this.timeLineObject.Id;
      break label476;
      this.RJa.setVisibility(8);
      break label775;
      paramView2 = this.PNI.getAdXml().adCardDesc;
      break label799;
      this.RJb.setVisibility(8);
      break label844;
      this.RJc.setVisibility(0);
      if (this.RJq != null) {
        this.RJq.hno();
      }
      ad(this.PNI);
      break label1045;
      this.RJc.setVisibility(8);
      if (this.RJq == null) {
        break label1045;
      }
      this.RJq.hno();
      break label1045;
      Log.d("SnsCardAdTagUtils", "should not refresh adTag, show origin adTag");
      i = 1;
      continue;
      if (this.PNI.getAdXml().adCardTagInfo.QHu.size() > 0) {
        this.RJi.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.c
 * JD-Core Version:    0.7.0.1
 */