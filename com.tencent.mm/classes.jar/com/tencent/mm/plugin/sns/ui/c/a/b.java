package com.tencent.mm.plugin.sns.ui.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
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
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.b.c;
import com.tencent.mm.plugin.sns.storage.b.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.as.b;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  com.tencent.mm.plugin.sns.ad.d.i Abd;
  public Button AtA;
  public View AtB;
  public MaskImageView AtC;
  public SnsCardAdTagListView AtD;
  public View AtE;
  public View AtF;
  public View AtG;
  public View AtH;
  private int AtI;
  private as AtJ;
  private au AtK;
  private boolean AtL = false;
  public TextView Atw;
  public TextView Atx;
  public View Aty;
  public Button Atz;
  private Context context;
  private com.tencent.mm.ui.widget.b.a nZK;
  
  public b(TimeLineObject paramTimeLineObject, p paramp, c paramc, com.tencent.mm.plugin.sns.ad.d.i parami)
  {
    this.timeLineObject = paramTimeLineObject;
    this.yXF = paramp;
    this.zaU = paramc;
    this.Abd = parami;
  }
  
  private void T(p paramp)
  {
    int j = 0;
    AppMethodBeat.i(100011);
    if ((paramp == null) || (!paramp.dVZ()))
    {
      AppMethodBeat.o(100011);
      return;
    }
    int k = this.context.getResources().getColor(2131100027);
    int m = this.context.getResources().getColor(2131099658);
    if ((this.Atz == null) || (this.AtA == null))
    {
      AppMethodBeat.o(100011);
      return;
    }
    this.Atz.setOnClickListener(this.zaU.Aza);
    this.AtA.setOnClickListener(this.zaU.Azb);
    int n;
    int i;
    if (paramp.dRL().dWf())
    {
      n = x.jS(paramp.dRL().zwG.zxA, paramp.dYT());
      if ((n > 0) && (n <= 2)) {
        if (n == 1)
        {
          this.AtA.setTextColor(m);
          this.AtA.setText(paramp.dRL().zwG.Qn(1));
          this.Atz.setTextColor(k);
          this.Atz.setText(paramp.dRL().zwG.Qm(0));
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.Atz.setTextColor(k);
        this.AtA.setTextColor(k);
        this.Atz.setText(paramp.dRL().dVV());
        this.AtA.setText(paramp.dRL().dVW());
      }
      AppMethodBeat.o(100011);
      return;
      i = j;
      if (n == 2)
      {
        this.Atz.setTextColor(m);
        this.Atz.setText(paramp.dRL().zwG.Qn(0));
        this.AtA.setTextColor(k);
        this.AtA.setText(paramp.dRL().zwG.Qm(1));
        i = j;
        continue;
        i = 1;
      }
    }
  }
  
  public final void m(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100009);
    this.context = paramView1.getContext();
    this.AtJ = new as(this.context, paramView1, 1, this.Abd, new as.b()
    {
      public final void eaS()
      {
        AppMethodBeat.i(100005);
        b.this.zaU.a(b.this);
        AppMethodBeat.o(100005);
      }
    });
    this.AtK = new au(this.context, paramView1, this.zaU);
    this.contentView = paramView1;
    this.AaE = paramView2;
    this.AtF = paramView1.findViewById(2131302206);
    if ((this.AtF instanceof RoundedCornerFrameLayout)) {
      ((RoundedCornerFrameLayout)this.AtF).setRadius(com.tencent.mm.cc.a.fromDPToPix(this.context, 4));
    }
    this.AtG = paramView1.findViewById(2131303102);
    this.Aty = paramView1.findViewById(2131297744);
    this.Aty.setVisibility(8);
    this.AtB = paramView1.findViewById(2131297919);
    this.AtB.setVisibility(8);
    if (al.isDarkMode()) {
      ((ImageView)paramView1.findViewById(2131306896)).setImageDrawable(this.context.getResources().getDrawable(2131689524));
    }
    this.AtC = ((MaskImageView)paramView1.findViewById(2131304943));
    this.Atz = ((Button)paramView1.findViewById(2131297745));
    this.AtA = ((Button)paramView1.findViewById(2131297746));
    this.AtH = paramView1.findViewById(2131296355);
    paramView2 = this.yXF.dRK();
    if ((paramView2 != null) && (paramView2.dVQ()) && (!this.yXF.dYX())) {
      this.AtB.setVisibility(0);
    }
    this.Atx = ((TextView)paramView1.findViewById(2131299000));
    this.Atx.setClickable(false);
    this.Atx.setLongClickable(false);
    paramView2 = (WindowManager)this.context.getSystemService("window");
    this.AtI = (Math.min(paramView2.getDefaultDisplay().getWidth(), paramView2.getDefaultDisplay().getHeight()) - com.tencent.mm.cc.a.ax(this.context, 2131166827) - com.tencent.mm.cc.a.ax(this.context, 2131165274) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165516));
    paramView2 = (LinearLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.topMargin = this.context.getResources().getDimensionPixelOffset(2131165500);
    paramView2.bottomMargin = 0;
    paramView2.width = this.AtI;
    paramView2.height = -2;
    paramView1.setLayoutParams(paramView2);
    paramView1.setBackground(this.context.getResources().getDrawable(2131234094));
    this.Atw = ((TextView)paramView1.findViewById(2131298999));
    this.Atw.setClickable(false);
    this.Atw.setLongClickable(false);
    if (!bt.isNullOrNil(this.yXF.dRL().zwj))
    {
      paramView2 = com.tencent.mm.cf.g.fng();
      this.Atw.getContext();
      paramView2 = paramView2.b(this.yXF.dRL().zwj, this.Atw.getTextSize());
      this.Atw.setText(paramView2);
      this.Atw.setVisibility(0);
      if (!bt.isNullOrNil(this.yXF.dRL().zwk)) {
        break label1300;
      }
      paramView2 = this.timeLineObject.HAQ;
      label582:
      if (bt.isNullOrNil(paramView2)) {
        break label1314;
      }
      com.tencent.mm.cf.g localg = com.tencent.mm.cf.g.fng();
      this.Atx.getContext();
      paramView2 = localg.b(paramView2, this.Atx.getTextSize());
      this.Atx.setText(paramView2);
      this.Atx.setVisibility(0);
      label630:
      this.nZK = new com.tencent.mm.ui.widget.b.a(this.context);
      this.nZK.c(paramView1, this.zaU.AyI, this.zaU.Ayq);
      if ((!this.yXF.dRL().dWd()) && (!this.yXF.dRL().dWf())) {
        break label1352;
      }
      if (!this.yXF.dRL().dWe()) {
        break label1326;
      }
      this.AtK.a(this.yXF, this);
      this.Aty.setVisibility(8);
      this.AtK.eaT();
      if (this.Atw != null) {
        this.Atw.setVisibility(8);
      }
      if (this.Atx != null) {
        this.Atx.setVisibility(8);
      }
      label766:
      this.Atv = new aq();
      this.Atv.zWA = paramView1.findViewById(2131304944);
      this.Atv.zWx = this.Atv.zWA;
      this.Atv.zWA.setOnClickListener(this.zaU.AyP);
      this.Atv.zWy = ((VideoSightView)this.Atv.zWA.findViewById(2131300914));
      this.Atv.zWy.setMute(true);
      this.Atv.zFD = ((ImageView)this.Atv.zWA.findViewById(2131305196));
      this.Atv.zWB = ((MMPinProgressBtn)this.Atv.zWA.findViewById(2131303515));
      this.Atv.zWC = ((TextView)this.Atv.zWA.findViewById(2131299492));
      this.Atv.zFE = ((TextView)this.Atv.zWA.findViewById(2131299517));
      this.AtE = paramView1.findViewById(2131304890);
      this.AtD = ((SnsCardAdTagListView)this.contentView.findViewById(2131297725));
      this.AtD.setActivityContext((Activity)this.context);
    }
    for (;;)
    {
      try
      {
        paramView2 = this.yXF.getSnsId();
        if (com.tencent.mm.plugin.sns.ui.widget.b.jX(this.AtD.getOriginSnsId(), paramView2)) {
          continue;
        }
        this.AtD.removeAllViews();
        if (this.yXF.dRL().zwn.zwZ.size() > 0)
        {
          this.AtD.setVisibility(0);
          this.AtD.setTagSpace(com.tencent.mm.cc.a.fromDPToPix(this.context, 8));
          this.AtD.gi(this.yXF.dRL().zwn.zwZ);
        }
        this.AtD.setOriginSnsId(paramView2);
      }
      catch (Exception paramView2)
      {
        label1300:
        label1314:
        label1326:
        label1352:
        ad.e("MicroMsg.CardAdDetailItemView", paramView2.toString());
        continue;
      }
      if (!bt.isNullOrNil(this.yXF.dRL().zwl))
      {
        this.AtE.setVisibility(0);
        this.AtE.findViewById(2131304891).setVisibility(0);
        ((TextView)this.AtE.findViewById(2131304891)).setText(this.yXF.dRL().zwl);
      }
      if (!bt.isNullOrNil(this.yXF.dRL().zwm)) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(this.yXF.dRL().zwm, false, new f.a()
        {
          public final void axG(String paramAnonymousString)
          {
            AppMethodBeat.i(100008);
            if (!bt.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = com.tencent.mm.sdk.platformtools.g.decodeFile(paramAnonymousString, null);
              if (paramAnonymousString != null)
              {
                b.this.AtE.setVisibility(0);
                ImageView localImageView = (ImageView)b.this.AtE.findViewById(2131304889);
                localImageView.setImageBitmap(paramAnonymousString);
                localImageView.setVisibility(0);
              }
            }
            AppMethodBeat.o(100008);
          }
          
          public final void dRW() {}
          
          public final void dRX() {}
        });
      }
      this.nZK.c(paramView1, this.zaU.AyI, this.zaU.Ayq);
      this.AtC.setVisibility(8);
      this.AtC.setScaleType(QImageView.a.KTb);
      this.Atv.zWx.setVisibility(8);
      this.Atv.zWy.ySy = true;
      this.Atv.zWy.setScaleType(QImageView.a.KTb);
      paramView1.setOnClickListener(this.zaU.Azc);
      AppMethodBeat.o(100009);
      return;
      this.Atw.setVisibility(8);
      break;
      paramView2 = this.yXF.dRL().zwk;
      break label582;
      this.Atx.setVisibility(8);
      break label630;
      this.Aty.setVisibility(0);
      this.AtK.eaU();
      T(this.yXF);
      break label766;
      this.Aty.setVisibility(8);
      this.AtK.eaU();
      break label766;
      if (this.yXF.dRL().zwn.zwZ.size() > 0) {
        this.AtD.setVisibility(0);
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(198530);
    try
    {
      ad.i("MicroMsg.CardAdDetailItemView", "onPause, hasPlayedVideo=" + this.AtL);
      if ((this.AtL) && (this.Atv != null) && (this.Atv.zWy != null))
      {
        this.Atv.zWy.pause();
        if ((this.Abd != null) && (this.yXF != null)) {
          this.Abd.zq(this.yXF.field_snsId);
        }
      }
      AppMethodBeat.o(198530);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.CardAdDetailItemView", "onPause, exp=" + localThrowable.toString());
      AppMethodBeat.o(198530);
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(100010);
    this.yXF = com.tencent.mm.plugin.sns.storage.h.azZ(this.yXF.getSnsId());
    ad.i("MicroMsg.CardAdDetailItemView", "refreshView");
    Object localObject2;
    Object localObject1;
    label147:
    int i;
    int j;
    if ((this.yXF.dRL().dWd()) || (this.yXF.dRL().dWf()))
    {
      if (this.yXF.dRL().dWe()) {
        this.AtK.a(this.yXF, this);
      }
    }
    else
    {
      this.Atv.zFE.setVisibility(8);
      this.AtL = false;
      localObject2 = ag.dUb();
      if ((this.timeLineObject.HAT == null) || (this.timeLineObject.HAT.GaQ.size() <= 0)) {
        break label458;
      }
      localObject1 = (byn)this.timeLineObject.HAT.GaQ.get(0);
      ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
      if (localObject1 == null) {
        break label1555;
      }
      i = this.AtI - this.context.getResources().getDimensionPixelSize(2131165568) - this.context.getResources().getDimensionPixelSize(2131165568);
      j = (int)(i * ((byn)localObject1).GSL.GTA / ((byn)localObject1).GSL.GTz);
      if (this.timeLineObject.HAT.GaP != 1) {
        break label464;
      }
      localObject2 = this.AtC.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = i;
      ((ViewGroup.LayoutParams)localObject2).height = j;
      this.AtC.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ag.dUb().b((byn)localObject1, this.AtC, -1, this.context.hashCode(), bj.ILU);
      this.AtC.setVisibility(0);
      this.AtC.setTag(this);
      this.contentView.setTag(this);
      this.Atz.setTag(this);
      this.AtA.setTag(this);
      this.AtC.setOnClickListener(this.zaU.zRv);
      this.nZK.c(this.AtC, this.zaU.AyI, this.zaU.Ayq);
    }
    label1451:
    label1453:
    label1471:
    for (;;)
    {
      if (!this.yXF.dRL().dVT()) {
        break label1546;
      }
      if (this.Atw != null) {
        this.Atw.setVisibility(8);
      }
      if (this.Atx != null) {
        this.Atx.setVisibility(8);
      }
      this.AtH.setVisibility(0);
      this.AtJ.P(this.yXF);
      AppMethodBeat.o(100010);
      return;
      T(this.yXF);
      break;
      label458:
      localObject1 = null;
      break label147;
      label464:
      if ((this.timeLineObject.HAT.GaP == 5) || (this.timeLineObject.HAT.GaP == 15))
      {
        this.Atv.zWx.setVisibility(0);
        this.nZK.c(this.Atv.zWA, this.zaU.AyI, this.zaU.Ayq);
        Object localObject3 = this.Atv.zWx.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = i;
        ((ViewGroup.LayoutParams)localObject3).height = j;
        this.Atv.zWx.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.Atv.zWy.hw(i, j);
        this.Atv.zWy.setOnCompletionListener(new b.e()
        {
          public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
          {
            AppMethodBeat.i(100006);
            if ((paramAnonymousInt != -1) && (b.this.Abd != null)) {
              b.this.Abd.A(b.this.yXF.field_snsId, false);
            }
            AppMethodBeat.o(100006);
          }
        });
        this.Atv.zWy.setOnDecodeDurationListener(new b.f()
        {
          public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
          {
            AppMethodBeat.i(100007);
            ad.d("MicroMsg.CardAdDetailItemView", "onDecodeProgress:".concat(String.valueOf(paramAnonymousLong)));
            if ((b.this.Abd != null) && (b.this.yXF != null))
            {
              b.this.Abd.zp(b.this.yXF.field_snsId);
              b.this.Abd.ak(b.this.yXF.field_snsId, 1000L * paramAnonymousLong);
              if (!b.this.Abd.zm(b.this.yXF.field_snsId))
              {
                int i = (int)paramAnonymousb.dQg();
                ad.i("MicroMsg.CardAdDetailItemView", "updatePlayStartTime, duration=".concat(String.valueOf(i)));
                b.this.Abd.d(b.this.yXF.field_snsId, bt.HI(), false);
                b.this.Abd.e(b.this.yXF.field_snsId, i, false);
                b.this.Abd.aj(b.this.yXF.field_snsId, b.this.yXF.field_snsId);
              }
            }
            AppMethodBeat.o(100007);
          }
        });
        long l = System.nanoTime();
        boolean bool = f.t((byn)localObject1);
        ad.i("MicroMsg.CardAdDetailItemView", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
        localObject3 = this.Atv;
        this.Atv.doX = this.yXF.dYK();
        if (!bool) {
          if (((f)localObject2).w((byn)localObject1))
          {
            ((aq)localObject3).zFD.setVisibility(8);
            ((aq)localObject3).zWB.setVisibility(0);
            ((aq)localObject3).zWB.fLr();
            label721:
            this.Atv.zWx.setVisibility(0);
            ((aq)localObject3).zWy.setTagObject(localObject3);
            ((aq)localObject3).zWA.setTag(this);
            this.contentView.setTag(this);
            this.Atz.setTag(this);
            this.AtA.setTag(this);
            ((f)localObject2).a(this.yXF, (byn)localObject1, ((aq)localObject3).zWy, this.context.hashCode(), 0, bj.ILU, true, true);
            ((aq)localObject3).zWy.start();
            this.AtL = true;
            if (this.Abd == null) {
              continue;
            }
            localObject2 = ao.jo(ag.getAccSnsPath(), ((byn)localObject1).Id);
            localObject1 = q.i((byn)localObject1);
            if (!com.tencent.mm.vfs.i.fv((String)localObject2 + (String)localObject1)) {
              break label1453;
            }
            this.Abd.B(this.yXF.field_snsId, true);
            label887:
            if (ag.dUb().b(this.yXF, null) != 5) {
              break label1471;
            }
          }
        }
        for (bool = true;; bool = false)
        {
          this.Abd.c(this.yXF.field_snsId, bool, false);
          break;
          if (((f)localObject2).b(this.yXF, null) == 5)
          {
            ((f)localObject2).A((byn)localObject1);
            ((aq)localObject3).zFD.setVisibility(8);
            ((aq)localObject3).zWB.setVisibility(0);
            ((aq)localObject3).zWB.fLr();
            break label721;
          }
          if (((f)localObject2).x((byn)localObject1))
          {
            ((aq)localObject3).zWB.setVisibility(8);
            ((aq)localObject3).zFD.setImageResource(2131691612);
            ((aq)localObject3).zFD.setVisibility(0);
            break label721;
          }
          ((f)localObject2).y((byn)localObject1);
          ((aq)localObject3).zFD.setVisibility(0);
          ((aq)localObject3).zWB.setVisibility(8);
          ((aq)localObject3).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
          ((aq)localObject3).zFD.setContentDescription(this.context.getResources().getString(2131761939));
          if (((f)localObject2).b(this.yXF, null) != 4) {
            break label721;
          }
          ((aq)localObject3).zFE.setVisibility(0);
          break label721;
          if (((f)localObject2).u((byn)localObject1))
          {
            ((aq)localObject3).zFD.setVisibility(0);
            ((aq)localObject3).zWB.setVisibility(8);
            ((aq)localObject3).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
            ((aq)localObject3).zFD.setContentDescription(this.context.getResources().getString(2131761939));
          }
          for (;;)
          {
            if (!((aq)localObject3).zWy.ySq.dQd()) {
              break label1451;
            }
            ad.d("MicroMsg.CardAdDetailItemView", "play video error " + ((byn)localObject1).Id + " " + ((byn)localObject1).Url + " " + ((byn)localObject1).GSI);
            ((f)localObject2).y((byn)localObject1);
            ((aq)localObject3).zFD.setVisibility(0);
            ((aq)localObject3).zWB.setVisibility(8);
            ((aq)localObject3).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
            ((aq)localObject3).zFD.setContentDescription(this.context.getResources().getString(2131761939));
            break;
            if (((f)localObject2).v((byn)localObject1))
            {
              ((aq)localObject3).zFD.setVisibility(8);
              ((aq)localObject3).zWB.setVisibility(8);
            }
            else if (((f)localObject2).b(this.yXF, null) <= 5)
            {
              ((aq)localObject3).zFD.setVisibility(8);
              ((aq)localObject3).zWB.setVisibility(8);
            }
            else
            {
              ((f)localObject2).y((byn)localObject1);
              ((aq)localObject3).zFD.setVisibility(0);
              ((aq)localObject3).zWB.setVisibility(8);
              ((aq)localObject3).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
              ((aq)localObject3).zFD.setContentDescription(this.context.getResources().getString(2131761939));
            }
          }
          break label721;
          this.Abd.B(this.yXF.field_snsId, false);
          break label887;
        }
      }
      else
      {
        ((f)localObject2).a(this.Atv.zWy, this.context.hashCode(), 0);
        this.Atv.zWC.setVisibility(8);
        this.Atv.zWy.setOnSightCompletionAction(null);
        this.Atv.zWy.setOnCompletionListener(null);
        this.Atv.zWy.setOnDecodeDurationListener(null);
      }
    }
    label1546:
    this.AtH.setVisibility(8);
    label1555:
    AppMethodBeat.o(100010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.b
 * JD-Core Version:    0.7.0.1
 */