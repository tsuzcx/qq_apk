package com.tencent.mm.plugin.sns.ui.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.i.e;
import com.tencent.mm.plugin.sns.ad.i.m;
import com.tencent.mm.plugin.sns.ad.widget.countdown.PromotionBarLayout;
import com.tencent.mm.plugin.sns.ad.widget.living.LivingDescBarLayout;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.c;
import com.tencent.mm.plugin.sns.storage.ADXml.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.av.b;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  k EBv;
  public TextView EUL;
  public TextView EUM;
  public View EUN;
  public Button EUO;
  public Button EUP;
  public View EUQ;
  public ImageView EUR;
  public MaskImageView EUS;
  public SnsCardAdTagListView EUT;
  public View EUU;
  public View EUV;
  public View EUW;
  public View EUX;
  private PromotionBarLayout EUY;
  private int EUZ;
  private av EVa;
  private ax EVb;
  private LivingDescBarLayout EVc;
  private ViewGroup EVd;
  private com.tencent.mm.plugin.sns.ad.widget.living.c EVe;
  private boolean EVf = false;
  private Context context;
  private com.tencent.mm.ui.widget.b.a pqr;
  
  public b(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ui.d.c paramc, k paramk)
  {
    this.timeLineObject = paramTimeLineObject;
    this.DsC = paramSnsInfo;
    this.Dyw = paramc;
    this.EBv = paramk;
  }
  
  private void aa(SnsInfo paramSnsInfo)
  {
    int j = 0;
    AppMethodBeat.i(100011);
    if ((paramSnsInfo == null) || (!paramSnsInfo.isCardAd()))
    {
      AppMethodBeat.o(100011);
      return;
    }
    int k = this.context.getResources().getColor(2131100053);
    int m = this.context.getResources().getColor(2131099660);
    if ((this.EUO == null) || (this.EUP == null))
    {
      AppMethodBeat.o(100011);
      return;
    }
    this.EUO.setOnClickListener(this.Dyw.Fbb);
    this.EUP.setOnClickListener(this.Dyw.Fbc);
    int n;
    int i;
    if (paramSnsInfo.getAdXml().hasVoteInfo())
    {
      n = y.kN(paramSnsInfo.getAdXml().adVoteInfo.DWX, paramSnsInfo.getUxinfo());
      if ((n > 0) && (n <= 2)) {
        if (n == 1)
        {
          this.EUP.setTextColor(m);
          this.EUP.setText(paramSnsInfo.getAdXml().adVoteInfo.YS(1));
          this.EUO.setTextColor(k);
          this.EUO.setText(paramSnsInfo.getAdXml().adVoteInfo.YR(0));
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.EUO.setTextColor(k);
        this.EUP.setTextColor(k);
        this.EUO.setText(paramSnsInfo.getAdXml().getCardSelectLeftTitle());
        this.EUP.setText(paramSnsInfo.getAdXml().getCardSelectRightTitle());
      }
      AppMethodBeat.o(100011);
      return;
      i = j;
      if (n == 2)
      {
        this.EUO.setTextColor(m);
        this.EUO.setText(paramSnsInfo.getAdXml().adVoteInfo.YS(0));
        this.EUP.setTextColor(k);
        this.EUP.setText(paramSnsInfo.getAdXml().adVoteInfo.YR(1));
        i = j;
        continue;
        i = 1;
      }
    }
  }
  
  public final void n(View paramView1, View paramView2)
  {
    i = 1;
    AppMethodBeat.i(100009);
    this.context = paramView1.getContext();
    this.EVa = new av(this.context, paramView1, 1, this.EBv, new av.b()
    {
      public final void fgP()
      {
        AppMethodBeat.i(100005);
        b.this.Dyw.a(b.this, null);
        AppMethodBeat.o(100005);
      }
    });
    this.EVb = new ax(this.context, paramView1, this.Dyw);
    this.contentView = paramView1;
    this.EAV = paramView2;
    this.EUV = paramView1.findViewById(2131304552);
    if ((this.EUV instanceof RoundedCornerFrameLayout)) {
      ((RoundedCornerFrameLayout)this.EUV).setRadius(com.tencent.mm.cb.a.fromDPToPix(this.context, 4));
    }
    this.EUW = paramView1.findViewById(2131305732);
    this.EUN = paramView1.findViewById(2131298058);
    this.EUN.setVisibility(8);
    this.EUQ = paramView1.findViewById(2131298237);
    this.EUR = ((ImageView)paramView1.findViewById(2131310365));
    this.EUQ.setVisibility(8);
    if (ao.isDarkMode())
    {
      ((ImageView)paramView1.findViewById(2131310367)).setImageResource(2131689527);
      this.EUR.setImageResource(2131230909);
    }
    this.EUS = ((MaskImageView)paramView1.findViewById(2131308082));
    this.EUO = ((Button)paramView1.findViewById(2131298059));
    this.EUP = ((Button)paramView1.findViewById(2131298060));
    this.EUX = paramView1.findViewById(2131296378);
    this.EUR.setTag("");
    if (this.EUR.getVisibility() == 0) {
      this.EUR.setVisibility(4);
    }
    paramView2 = this.DsC.getAdInfo();
    if ((paramView2 != null) && (paramView2.isWeapp()) && (!this.DsC.isTurnCardAd()))
    {
      this.EUQ.setVisibility(0);
      com.tencent.mm.plugin.sns.ad.e.d.f(paramView2.actionExtWeApp.appUserName, this.EUR);
    }
    this.EUM = ((TextView)paramView1.findViewById(2131299501));
    this.EUM.setClickable(false);
    this.EUM.setLongClickable(false);
    paramView2 = (WindowManager)this.context.getSystemService("window");
    this.EUZ = (Math.min(paramView2.getDefaultDisplay().getWidth(), paramView2.getDefaultDisplay().getHeight()) - com.tencent.mm.cb.a.aG(this.context, 2131166954) - com.tencent.mm.cb.a.aG(this.context, 2131165277) - this.context.getResources().getDimensionPixelSize(2131165534) - this.context.getResources().getDimensionPixelSize(2131165534));
    paramView2 = (LinearLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.topMargin = this.context.getResources().getDimensionPixelOffset(2131165518);
    paramView2.bottomMargin = 0;
    paramView2.width = this.EUZ;
    paramView2.height = -2;
    paramView1.setLayoutParams(paramView2);
    paramView1.setBackground(this.context.getResources().getDrawable(2131234951));
    this.EUL = ((TextView)paramView1.findViewById(2131299500));
    this.EUL.setClickable(false);
    this.EUL.setLongClickable(false);
    if (!Util.isNullOrNil(this.DsC.getAdXml().adCardTitle))
    {
      paramView2 = com.tencent.mm.ce.g.gxZ().a(this.EUL.getContext(), this.DsC.getAdXml().adCardTitle, this.EUL.getTextSize());
      this.EUL.setText(paramView2);
      this.EUL.setVisibility(0);
      if (!Util.isNullOrNil(this.DsC.getAdXml().adCardDesc)) {
        break label1527;
      }
      paramView2 = this.timeLineObject.ContentDesc;
      label639:
      if (Util.isNullOrNil(paramView2)) {
        break label1541;
      }
      paramView2 = com.tencent.mm.ce.g.gxZ().a(this.EUM.getContext(), paramView2, this.EUM.getTextSize());
      this.EUM.setText(paramView2);
      this.EUM.setVisibility(0);
      label684:
      this.pqr = new com.tencent.mm.ui.widget.b.a(this.context);
      this.pqr.c(paramView1, this.Dyw.FaJ, this.Dyw.Far);
      if ((!this.DsC.getAdXml().hasSelectInfo()) && (!this.DsC.getAdXml().hasVoteInfo())) {
        break label1579;
      }
      if (!this.DsC.getAdXml().isNewStyleVote()) {
        break label1553;
      }
      this.EVb.a(this.DsC, this);
      this.EUN.setVisibility(8);
      this.EVb.fgQ();
      if (this.EUL != null) {
        this.EUL.setVisibility(8);
      }
      if (this.EUM != null) {
        this.EUM.setVisibility(8);
      }
      label820:
      this.EUK = new at();
      this.EUK.Ewu = paramView1.findViewById(2131308084);
      this.EUK.Ewr = this.EUK.Ewu;
      this.EUK.Ewu.setOnClickListener(this.Dyw.FaQ);
      this.EUK.Ews = ((VideoSightView)this.EUK.Ewu.findViewById(2131302526));
      this.EUK.Ews.setMute(true);
      this.EUK.EeS = ((ImageView)this.EUK.Ewu.findViewById(2131308392));
      this.EUK.Ewv = ((MMPinProgressBtn)this.EUK.Ewu.findViewById(2131306281));
      this.EUK.Eww = ((TextView)this.EUK.Ewu.findViewById(2131300128));
      this.EUK.EeT = ((TextView)this.EUK.Ewu.findViewById(2131300154));
      this.EUU = paramView1.findViewById(2131307977);
      this.EUT = ((SnsCardAdTagListView)this.contentView.findViewById(2131298029));
      this.EUT.setActivityContext((Activity)this.context);
    }
    for (;;)
    {
      try
      {
        paramView2 = this.DsC.getSnsId();
        if (com.tencent.mm.plugin.sns.ui.widget.b.kS(this.EUT.getOriginSnsId(), paramView2)) {
          continue;
        }
        this.EUT.removeAllViews();
        if (this.DsC.getAdXml().adCardTagInfo.DWm.size() > 0)
        {
          this.EUT.setVisibility(0);
          this.EUT.setTagSpace(com.tencent.mm.cb.a.fromDPToPix(this.context, 8));
          this.EUT.ho(this.DsC.getAdXml().adCardTagInfo.DWm);
        }
        this.EUT.setOriginSnsId(paramView2);
      }
      catch (Exception paramView2)
      {
        label1527:
        Log.e("MicroMsg.CardAdDetailItemView", paramView2.toString());
        label1541:
        label1553:
        label1579:
        continue;
        localh = paramView2.getAdXml().adPromotionInfo;
        if (localh == null) {
          continue;
        }
        if (e.ap(localh.startTime, localh.endTime)) {
          continue;
        }
        continue;
        if (this.EUY == null) {
          continue;
        }
        this.EUY.setVisibility(8);
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
      }
      if (!Util.isNullOrNil(this.DsC.getAdXml().adCard3dHeadTitle))
      {
        this.EUU.setVisibility(0);
        this.EUU.findViewById(2131307978).setVisibility(0);
        ((TextView)this.EUU.findViewById(2131307978)).setText(this.DsC.getAdXml().adCard3dHeadTitle);
      }
      if (!Util.isNullOrNil(this.DsC.getAdXml().adCard3dHeadUrl)) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(this.DsC.getAdXml().adCard3dHeadUrl, false, new f.a()
        {
          public final void aNH(String paramAnonymousString)
          {
            AppMethodBeat.i(100008);
            if (!Util.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString, null);
              if (paramAnonymousString != null)
              {
                b.this.EUU.setVisibility(0);
                ImageView localImageView = (ImageView)b.this.EUU.findViewById(2131307976);
                localImageView.setImageBitmap(paramAnonymousString);
                localImageView.setVisibility(0);
              }
            }
            AppMethodBeat.o(100008);
          }
          
          public final void eWN() {}
          
          public final void eWO() {}
        });
      }
      this.pqr.c(paramView1, this.Dyw.FaJ, this.Dyw.Far);
      this.EUS.setVisibility(8);
      this.EUS.setScaleType(QImageView.a.QEL);
      this.EUK.Ewr.setVisibility(8);
      this.EUK.Ews.Dnz = true;
      this.EUK.Ews.setScaleType(QImageView.a.QEL);
      this.EUY = ((PromotionBarLayout)paramView1.findViewById(2131296503));
      paramView2 = this.DsC;
      if (paramView2 == null) {
        continue;
      }
      try
      {
        if (paramView2.getAdXml() != null) {
          continue;
        }
      }
      catch (Throwable paramView2)
      {
        com.tencent.mm.plugin.sns.ad.a.h localh;
        continue;
      }
      if (i == 0) {
        continue;
      }
      paramView2 = paramView2.getAdXml().adPromotionInfo;
      if (this.EUY != null)
      {
        this.EUY.setVisibility(0);
        this.EUY.setPromotionalPrice(paramView2.Dse);
        this.EUY.setRightTitle(paramView2.Dsf);
        m.f(this.EUY, com.tencent.mm.plugin.sns.ad.i.d.jV(paramView2.Dsc, paramView2.lco));
        this.EUY.b(new com.tencent.mm.plugin.sns.ad.widget.countdown.b(paramView2.startTime, paramView2.endTime));
      }
      paramView1.setOnClickListener(this.Dyw.Fbd);
      this.EVd = ((ViewGroup)paramView1.findViewById(2131296502));
      this.EVc = ((LivingDescBarLayout)paramView1.findViewById(2131296499));
      this.EVe = new com.tencent.mm.plugin.sns.ad.widget.living.c(this.EVd, this.EVc, this.EVa);
      AppMethodBeat.o(100009);
      return;
      this.EUL.setVisibility(8);
      break;
      paramView2 = this.DsC.getAdXml().adCardDesc;
      break label639;
      this.EUM.setVisibility(8);
      break label684;
      this.EUN.setVisibility(0);
      this.EVb.fgR();
      aa(this.DsC);
      break label820;
      this.EUN.setVisibility(8);
      this.EVb.fgR();
      break label820;
      if (this.DsC.getAdXml().adCardTagInfo.DWm.size() > 0) {
        this.EUT.setVisibility(0);
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(203888);
    try
    {
      Log.i("MicroMsg.CardAdDetailItemView", "onPause, hasPlayedVideo=" + this.EVf);
      if ((this.EVf) && (this.EUK != null) && (this.EUK.Ews != null))
      {
        this.EUK.Ews.pause();
        if ((this.EBv != null) && (this.DsC != null)) {
          this.EBv.IU(this.DsC.field_snsId);
        }
      }
      AppMethodBeat.o(203888);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.CardAdDetailItemView", "onPause, exp=" + localThrowable.toString());
      AppMethodBeat.o(203888);
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(100010);
    this.DsC = f.aQl(this.DsC.getSnsId());
    Log.i("MicroMsg.CardAdDetailItemView", "refreshView");
    Object localObject3;
    Object localObject1;
    label147:
    Object localObject2;
    int i;
    int j;
    if ((this.DsC.getAdXml().hasSelectInfo()) || (this.DsC.getAdXml().hasVoteInfo()))
    {
      if (this.DsC.getAdXml().isNewStyleVote()) {
        this.EVb.a(this.DsC, this);
      }
    }
    else
    {
      this.EUK.EeT.setVisibility(8);
      this.EVf = false;
      localObject3 = aj.faL();
      if ((this.timeLineObject.ContentObj == null) || (this.timeLineObject.ContentObj.LoV.size() <= 0)) {
        break label603;
      }
      localObject1 = (cnb)this.timeLineObject.ContentObj.LoV.get(0);
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.sns.ad.e.b.a((cnb)localObject1);
        com.tencent.mm.plugin.sns.ad.e.b.a((cnb)localObject2, false);
      }
      ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
      if (localObject2 == null) {
        break label1813;
      }
      i = this.EUZ - this.context.getResources().getDimensionPixelSize(2131165586) - this.context.getResources().getDimensionPixelSize(2131165586);
      j = (int)(i * ((cnb)localObject2).MsB.Mtp / ((cnb)localObject2).MsB.Mto);
      if (this.timeLineObject.ContentObj.LoU != 1) {
        break label609;
      }
      localObject1 = this.EUS.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = i;
      ((ViewGroup.LayoutParams)localObject1).height = j;
      this.EUS.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      aj.faL().b((cnb)localObject2, this.EUS, -1, this.context.hashCode(), bp.Oqs);
      this.EUS.setVisibility(0);
      this.EUS.setTag(this);
      this.contentView.setTag(this);
      this.EUO.setTag(this);
      this.EUP.setTag(this);
      this.EUS.setOnClickListener(this.Dyw.Erh);
      this.pqr.c(this.EUS, this.Dyw.FaJ, this.Dyw.Far);
      label398:
      if (!this.DsC.getAdXml().hasActionBtn()) {
        break label1755;
      }
      if (this.EUL != null) {
        this.EUL.setVisibility(8);
      }
      if (this.EUM != null) {
        this.EUM.setVisibility(8);
      }
      this.EUX.setVisibility(0);
      this.EVa.V(this.DsC);
      label462:
      localObject1 = this.DsC;
      if (localObject1 == null) {
        break label1820;
      }
    }
    for (;;)
    {
      try
      {
        if (((SnsInfo)localObject1).getAdXml() == null) {
          break label1820;
        }
        if (((SnsInfo)localObject1).getAdXml().adLiveInfo == null)
        {
          break label1820;
          if (i == 0) {
            continue;
          }
          localObject2 = ((SnsInfo)localObject1).getTimeLine();
          if ((localObject2 != null) && (this.EVe != null))
          {
            localObject3 = ((SnsInfo)localObject1).getAdXml().adLiveInfo;
            i = com.tencent.mm.plugin.sns.ad.widget.living.b.fu(((TimeLineObject)localObject2).Id, ((com.tencent.mm.plugin.sns.ad.a.g)localObject3).liveType);
            this.EVe.a(((TimeLineObject)localObject2).Id, (com.tencent.mm.plugin.sns.ad.a.g)localObject3);
            this.EVe.setLiveStatus(i);
            com.tencent.mm.plugin.sns.ad.widget.living.b.a(((TimeLineObject)localObject2).Id, this.EVe);
            com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.eXI().b(1, (SnsInfo)localObject1);
          }
          AppMethodBeat.o(100010);
          return;
          aa(this.DsC);
          break;
          label603:
          localObject1 = null;
          break label147;
          label609:
          if ((this.timeLineObject.ContentObj.LoU == 5) || (this.timeLineObject.ContentObj.LoU == 15))
          {
            this.EUK.Ewr.setVisibility(0);
            this.pqr.c(this.EUK.Ewu, this.Dyw.FaJ, this.Dyw.Far);
            localObject1 = this.EUK.Ewr.getLayoutParams();
            ((ViewGroup.LayoutParams)localObject1).width = i;
            ((ViewGroup.LayoutParams)localObject1).height = j;
            this.EUK.Ewr.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.EUK.Ews.im(i, j);
            this.EUK.Ews.setOnCompletionListener(new b.e()
            {
              public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
              {
                AppMethodBeat.i(100006);
                if ((paramAnonymousInt != -1) && (b.this.EBv != null)) {
                  b.this.EBv.I(b.this.DsC.field_snsId, false);
                }
                AppMethodBeat.o(100006);
              }
            });
            this.EUK.Ews.setOnDecodeDurationListener(new b.f()
            {
              public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
              {
                AppMethodBeat.i(100007);
                Log.d("MicroMsg.CardAdDetailItemView", "onDecodeProgress:".concat(String.valueOf(paramAnonymousLong)));
                if ((b.this.EBv != null) && (b.this.DsC != null))
                {
                  b.this.EBv.IT(b.this.DsC.field_snsId);
                  b.this.EBv.ao(b.this.DsC.field_snsId, 1000L * paramAnonymousLong);
                  if (!b.this.EBv.IQ(b.this.DsC.field_snsId))
                  {
                    int i = (int)paramAnonymousb.eVC();
                    Log.i("MicroMsg.CardAdDetailItemView", "updatePlayStartTime, duration=".concat(String.valueOf(i)));
                    b.this.EBv.c(b.this.DsC.field_snsId, Util.currentTicks(), false);
                    b.this.EBv.e(b.this.DsC.field_snsId, i, false);
                    b.this.EBv.an(b.this.DsC.field_snsId, b.this.DsC.field_snsId);
                  }
                }
                AppMethodBeat.o(100007);
              }
            });
            long l = System.nanoTime();
            boolean bool = com.tencent.mm.plugin.sns.model.g.u((cnb)localObject2);
            Log.i("MicroMsg.CardAdDetailItemView", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
            localObject1 = this.EUK;
            this.EUK.dHp = this.DsC.getLocalid();
            if (!bool)
            {
              if (((com.tencent.mm.plugin.sns.model.g)localObject3).x((cnb)localObject2))
              {
                ((at)localObject1).EeS.setVisibility(8);
                ((at)localObject1).Ewv.setVisibility(0);
                ((at)localObject1).Ewv.gYN();
                this.EUK.Ewr.setVisibility(0);
                ((at)localObject1).Ews.setTagObject(localObject1);
                ((at)localObject1).Ewu.setTag(this);
                this.contentView.setTag(this);
                this.EUO.setTag(this);
                this.EUP.setTag(this);
                ((com.tencent.mm.plugin.sns.model.g)localObject3).a(this.DsC, (cnb)localObject2, ((at)localObject1).Ews, this.context.hashCode(), 0, bp.Oqs, true, true);
                ((at)localObject1).Ews.start();
                this.EVf = true;
                if (this.EBv == null) {
                  break label398;
                }
                localObject1 = ar.ki(aj.getAccSnsPath(), ((cnb)localObject2).Id);
                localObject3 = com.tencent.mm.plugin.sns.data.r.j((cnb)localObject2);
                localObject1 = (String)localObject1 + (String)localObject3;
                if (!s.YS((String)localObject1)) {
                  continue;
                }
                this.EBv.f(this.DsC.field_snsId, (int)((cnb)localObject2).MsT, true);
                if (com.tencent.mm.plugin.sns.ad.e.b.KB())
                {
                  bool = com.tencent.mm.modelvideo.r.isH265Video((String)localObject1);
                  Log.i("MicroMsg.CardAdDetailItemView", "AdH265Helper, fileExists, isH265File=" + bool + ", path=" + (String)localObject1);
                }
                if (aj.faL().b(this.DsC, null) != 5) {
                  continue;
                }
                bool = true;
                this.EBv.d(this.DsC.field_snsId, bool, false);
                break label398;
              }
              if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(this.DsC, null) == 5)
              {
                ((com.tencent.mm.plugin.sns.model.g)localObject3).B((cnb)localObject2);
                ((at)localObject1).EeS.setVisibility(8);
                ((at)localObject1).Ewv.setVisibility(0);
                ((at)localObject1).Ewv.gYN();
                continue;
              }
              if (((com.tencent.mm.plugin.sns.model.g)localObject3).y((cnb)localObject2))
              {
                ((at)localObject1).Ewv.setVisibility(8);
                ((at)localObject1).EeS.setImageResource(2131691482);
                ((at)localObject1).EeS.setVisibility(0);
                continue;
              }
              ((com.tencent.mm.plugin.sns.model.g)localObject3).z((cnb)localObject2);
              ((at)localObject1).EeS.setVisibility(0);
              ((at)localObject1).Ewv.setVisibility(8);
              ((at)localObject1).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691480));
              ((at)localObject1).EeS.setContentDescription(this.context.getResources().getString(2131763945));
              if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(this.DsC, null) != 4) {
                continue;
              }
              ((at)localObject1).EeT.setVisibility(0);
              continue;
            }
            if (((com.tencent.mm.plugin.sns.model.g)localObject3).v((cnb)localObject2))
            {
              ((at)localObject1).EeS.setVisibility(0);
              ((at)localObject1).Ewv.setVisibility(8);
              ((at)localObject1).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691480));
              ((at)localObject1).EeS.setContentDescription(this.context.getResources().getString(2131763945));
              if (((at)localObject1).Ews.Dnr.eVz())
              {
                Log.d("MicroMsg.CardAdDetailItemView", "play video error " + ((cnb)localObject2).Id + " " + ((cnb)localObject2).Url + " " + ((cnb)localObject2).Msz);
                ((com.tencent.mm.plugin.sns.model.g)localObject3).z((cnb)localObject2);
                ((at)localObject1).EeS.setVisibility(0);
                ((at)localObject1).Ewv.setVisibility(8);
                ((at)localObject1).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691480));
                ((at)localObject1).EeS.setContentDescription(this.context.getResources().getString(2131763945));
              }
            }
            else
            {
              if (((com.tencent.mm.plugin.sns.model.g)localObject3).w((cnb)localObject2))
              {
                ((at)localObject1).EeS.setVisibility(8);
                ((at)localObject1).Ewv.setVisibility(8);
                continue;
              }
              if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(this.DsC, null) <= 5)
              {
                ((at)localObject1).EeS.setVisibility(8);
                ((at)localObject1).Ewv.setVisibility(8);
                continue;
              }
              ((com.tencent.mm.plugin.sns.model.g)localObject3).z((cnb)localObject2);
              ((at)localObject1).EeS.setVisibility(0);
              ((at)localObject1).Ewv.setVisibility(8);
              ((at)localObject1).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691480));
              ((at)localObject1).EeS.setContentDescription(this.context.getResources().getString(2131763945));
              continue;
            }
            continue;
            this.EBv.f(this.DsC.field_snsId, (int)((cnb)localObject2).MsT, false);
            continue;
            bool = false;
            continue;
          }
          ((com.tencent.mm.plugin.sns.model.g)localObject3).a(this.EUK.Ews, this.context.hashCode(), 0);
          this.EUK.Eww.setVisibility(8);
          this.EUK.Ews.setOnSightCompletionAction(null);
          this.EUK.Ews.setOnCompletionListener(null);
          this.EUK.Ews.setOnDecodeDurationListener(null);
          break label398;
          label1755:
          this.EUX.setVisibility(8);
          break label462;
        }
        i = 1;
        continue;
        if (this.EVd != null) {
          this.EVd.setVisibility(8);
        }
        if (this.EVc != null) {
          this.EVc.setVisibility(8);
        }
        AppMethodBeat.o(100010);
        return;
      }
      catch (Throwable localThrowable) {}
      label1813:
      AppMethodBeat.o(100010);
      return;
      label1820:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.b
 * JD-Core Version:    0.7.0.1
 */