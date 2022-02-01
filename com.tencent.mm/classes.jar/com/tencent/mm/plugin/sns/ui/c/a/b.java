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
import com.tencent.mm.plugin.sns.ad.e.j;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.a.b;
import com.tencent.mm.plugin.sns.storage.b.d;
import com.tencent.mm.plugin.sns.storage.b.l;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.as.b;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  public TextView AKK;
  public TextView AKL;
  public View AKM;
  public Button AKN;
  public Button AKO;
  public View AKP;
  public ImageView AKQ;
  public MaskImageView AKR;
  public SnsCardAdTagListView AKS;
  public View AKT;
  public View AKU;
  public View AKV;
  public View AKW;
  private int AKX;
  private as AKY;
  private au AKZ;
  private boolean ALa = false;
  j Asq;
  private Context context;
  private com.tencent.mm.ui.widget.b.a ofu;
  
  public b(TimeLineObject paramTimeLineObject, p paramp, com.tencent.mm.plugin.sns.ui.d.c paramc, j paramj)
  {
    this.timeLineObject = paramTimeLineObject;
    this.znm = paramp;
    this.zrv = paramc;
    this.Asq = paramj;
  }
  
  private void T(p paramp)
  {
    int j = 0;
    AppMethodBeat.i(100011);
    if ((paramp == null) || (!paramp.dZA()))
    {
      AppMethodBeat.o(100011);
      return;
    }
    int k = this.context.getResources().getColor(2131100027);
    int m = this.context.getResources().getColor(2131099658);
    if ((this.AKN == null) || (this.AKO == null))
    {
      AppMethodBeat.o(100011);
      return;
    }
    this.AKN.setOnClickListener(this.zrv.AQw);
    this.AKO.setOnClickListener(this.zrv.AQx);
    int n;
    int i;
    if (paramp.dVj().dZG())
    {
      n = x.jZ(paramp.dVj().zOe.zOZ, paramp.ecx());
      if ((n > 0) && (n <= 2)) {
        if (n == 1)
        {
          this.AKO.setTextColor(m);
          this.AKO.setText(paramp.dVj().zOe.QU(1));
          this.AKN.setTextColor(k);
          this.AKN.setText(paramp.dVj().zOe.QT(0));
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.AKN.setTextColor(k);
        this.AKO.setTextColor(k);
        this.AKN.setText(paramp.dVj().dZw());
        this.AKO.setText(paramp.dVj().dZx());
      }
      AppMethodBeat.o(100011);
      return;
      i = j;
      if (n == 2)
      {
        this.AKN.setTextColor(m);
        this.AKN.setText(paramp.dVj().zOe.QU(0));
        this.AKO.setTextColor(k);
        this.AKO.setText(paramp.dVj().zOe.QT(1));
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
    this.AKY = new as(this.context, paramView1, 1, this.Asq, new as.b()
    {
      public final void eey()
      {
        AppMethodBeat.i(100005);
        b.this.zrv.a(b.this);
        AppMethodBeat.o(100005);
      }
    });
    this.AKZ = new au(this.context, paramView1, this.zrv);
    this.contentView = paramView1;
    this.ArR = paramView2;
    this.AKU = paramView1.findViewById(2131302206);
    if ((this.AKU instanceof RoundedCornerFrameLayout)) {
      ((RoundedCornerFrameLayout)this.AKU).setRadius(com.tencent.mm.cb.a.fromDPToPix(this.context, 4));
    }
    this.AKV = paramView1.findViewById(2131303102);
    this.AKM = paramView1.findViewById(2131297744);
    this.AKM.setVisibility(8);
    this.AKP = paramView1.findViewById(2131297919);
    this.AKQ = ((ImageView)paramView1.findViewById(2131308526));
    this.AKP.setVisibility(8);
    if (al.isDarkMode())
    {
      ((ImageView)paramView1.findViewById(2131306896)).setImageResource(2131689524);
      this.AKQ.setImageResource(2131235014);
    }
    this.AKR = ((MaskImageView)paramView1.findViewById(2131304943));
    this.AKN = ((Button)paramView1.findViewById(2131297745));
    this.AKO = ((Button)paramView1.findViewById(2131297746));
    this.AKW = paramView1.findViewById(2131296355);
    this.AKQ.setTag("");
    if (this.AKQ.getVisibility() == 0) {
      this.AKQ.setVisibility(4);
    }
    paramView2 = this.znm.dVi();
    if ((paramView2 != null) && (paramView2.dZr()) && (!this.znm.ecB()))
    {
      this.AKP.setVisibility(0);
      com.tencent.mm.plugin.sns.ad.c.c.e(paramView2.zMn.duJ, this.AKQ);
    }
    this.AKL = ((TextView)paramView1.findViewById(2131299000));
    this.AKL.setClickable(false);
    this.AKL.setLongClickable(false);
    paramView2 = (WindowManager)this.context.getSystemService("window");
    this.AKX = (Math.min(paramView2.getDefaultDisplay().getWidth(), paramView2.getDefaultDisplay().getHeight()) - com.tencent.mm.cb.a.ax(this.context, 2131166827) - com.tencent.mm.cb.a.ax(this.context, 2131165274) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165516));
    paramView2 = (LinearLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.topMargin = this.context.getResources().getDimensionPixelOffset(2131165500);
    paramView2.bottomMargin = 0;
    paramView2.width = this.AKX;
    paramView2.height = -2;
    paramView1.setLayoutParams(paramView2);
    paramView1.setBackground(this.context.getResources().getDrawable(2131234094));
    this.AKK = ((TextView)paramView1.findViewById(2131298999));
    this.AKK.setClickable(false);
    this.AKK.setLongClickable(false);
    if (!bu.isNullOrNil(this.znm.dVj().zNE))
    {
      paramView2 = com.tencent.mm.ce.g.fqZ();
      this.AKK.getContext();
      paramView2 = paramView2.b(this.znm.dVj().zNE, this.AKK.getTextSize());
      this.AKK.setText(paramView2);
      this.AKK.setVisibility(0);
      if (!bu.isNullOrNil(this.znm.dVj().zNF)) {
        break label1355;
      }
      paramView2 = this.timeLineObject.HUD;
      label637:
      if (bu.isNullOrNil(paramView2)) {
        break label1369;
      }
      com.tencent.mm.ce.g localg = com.tencent.mm.ce.g.fqZ();
      this.AKL.getContext();
      paramView2 = localg.b(paramView2, this.AKL.getTextSize());
      this.AKL.setText(paramView2);
      this.AKL.setVisibility(0);
      label685:
      this.ofu = new com.tencent.mm.ui.widget.b.a(this.context);
      this.ofu.c(paramView1, this.zrv.AQe, this.zrv.APL);
      if ((!this.znm.dVj().dZE()) && (!this.znm.dVj().dZG())) {
        break label1407;
      }
      if (!this.znm.dVj().dZF()) {
        break label1381;
      }
      this.AKZ.a(this.znm, this);
      this.AKM.setVisibility(8);
      this.AKZ.eez();
      if (this.AKK != null) {
        this.AKK.setVisibility(8);
      }
      if (this.AKL != null) {
        this.AKL.setVisibility(8);
      }
      label821:
      this.AKJ = new aq();
      this.AKJ.AnJ = paramView1.findViewById(2131304944);
      this.AKJ.AnG = this.AKJ.AnJ;
      this.AKJ.AnJ.setOnClickListener(this.zrv.AQl);
      this.AKJ.AnH = ((VideoSightView)this.AKJ.AnJ.findViewById(2131300914));
      this.AKJ.AnH.setMute(true);
      this.AKJ.zWJ = ((ImageView)this.AKJ.AnJ.findViewById(2131305196));
      this.AKJ.AnK = ((MMPinProgressBtn)this.AKJ.AnJ.findViewById(2131303515));
      this.AKJ.AnL = ((TextView)this.AKJ.AnJ.findViewById(2131299492));
      this.AKJ.zWK = ((TextView)this.AKJ.AnJ.findViewById(2131299517));
      this.AKT = paramView1.findViewById(2131304890);
      this.AKS = ((SnsCardAdTagListView)this.contentView.findViewById(2131297725));
      this.AKS.setActivityContext((Activity)this.context);
    }
    for (;;)
    {
      try
      {
        paramView2 = this.znm.getSnsId();
        if (com.tencent.mm.plugin.sns.ui.widget.b.ke(this.AKS.getOriginSnsId(), paramView2)) {
          continue;
        }
        this.AKS.removeAllViews();
        if (this.znm.dVj().zNI.zOy.size() > 0)
        {
          this.AKS.setVisibility(0);
          this.AKS.setTagSpace(com.tencent.mm.cb.a.fromDPToPix(this.context, 8));
          this.AKS.gr(this.znm.dVj().zNI.zOy);
        }
        this.AKS.setOriginSnsId(paramView2);
      }
      catch (Exception paramView2)
      {
        label1355:
        label1369:
        label1381:
        label1407:
        ae.e("MicroMsg.CardAdDetailItemView", paramView2.toString());
        continue;
      }
      if (!bu.isNullOrNil(this.znm.dVj().zNG))
      {
        this.AKT.setVisibility(0);
        this.AKT.findViewById(2131304891).setVisibility(0);
        ((TextView)this.AKT.findViewById(2131304891)).setText(this.znm.dVj().zNG);
      }
      if (!bu.isNullOrNil(this.znm.dVj().zNH)) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(this.znm.dVj().zNH, false, new f.a()
        {
          public final void ayY(String paramAnonymousString)
          {
            AppMethodBeat.i(100008);
            if (!bu.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = com.tencent.mm.sdk.platformtools.h.decodeFile(paramAnonymousString, null);
              if (paramAnonymousString != null)
              {
                b.this.AKT.setVisibility(0);
                ImageView localImageView = (ImageView)b.this.AKT.findViewById(2131304889);
                localImageView.setImageBitmap(paramAnonymousString);
                localImageView.setVisibility(0);
              }
            }
            AppMethodBeat.o(100008);
          }
          
          public final void dVu() {}
          
          public final void dVv() {}
        });
      }
      this.ofu.c(paramView1, this.zrv.AQe, this.zrv.APL);
      this.AKR.setVisibility(8);
      this.AKR.setScaleType(QImageView.a.Lpz);
      this.AKJ.AnG.setVisibility(8);
      this.AKJ.AnH.ziI = true;
      this.AKJ.AnH.setScaleType(QImageView.a.Lpz);
      paramView1.setOnClickListener(this.zrv.AQy);
      AppMethodBeat.o(100009);
      return;
      this.AKK.setVisibility(8);
      break;
      paramView2 = this.znm.dVj().zNF;
      break label637;
      this.AKL.setVisibility(8);
      break label685;
      this.AKM.setVisibility(0);
      this.AKZ.eeA();
      T(this.znm);
      break label821;
      this.AKM.setVisibility(8);
      this.AKZ.eeA();
      break label821;
      if (this.znm.dVj().zNI.zOy.size() > 0) {
        this.AKS.setVisibility(0);
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(220072);
    try
    {
      ae.i("MicroMsg.CardAdDetailItemView", "onPause, hasPlayedVideo=" + this.ALa);
      if ((this.ALa) && (this.AKJ != null) && (this.AKJ.AnH != null))
      {
        this.AKJ.AnH.pause();
        if ((this.Asq != null) && (this.znm != null)) {
          this.Asq.zP(this.znm.field_snsId);
        }
      }
      AppMethodBeat.o(220072);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.CardAdDetailItemView", "onPause, exp=" + localThrowable.toString());
      AppMethodBeat.o(220072);
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(100010);
    this.znm = com.tencent.mm.plugin.sns.storage.h.aBq(this.znm.getSnsId());
    ae.i("MicroMsg.CardAdDetailItemView", "refreshView");
    Object localObject2;
    Object localObject1;
    label147:
    int i;
    int j;
    if ((this.znm.dVj().dZE()) || (this.znm.dVj().dZG()))
    {
      if (this.znm.dVj().dZF()) {
        this.AKZ.a(this.znm, this);
      }
    }
    else
    {
      this.AKJ.zWK.setVisibility(8);
      this.ALa = false;
      localObject2 = ah.dXB();
      if ((this.timeLineObject.HUG == null) || (this.timeLineObject.HUG.Gtx.size() <= 0)) {
        break label458;
      }
      localObject1 = (bzh)this.timeLineObject.HUG.Gtx.get(0);
      ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
      if (localObject1 == null) {
        break label1555;
      }
      i = this.AKX - this.context.getResources().getDimensionPixelSize(2131165568) - this.context.getResources().getDimensionPixelSize(2131165568);
      j = (int)(i * ((bzh)localObject1).Hmm.Hnb / ((bzh)localObject1).Hmm.Hna);
      if (this.timeLineObject.HUG.Gtw != 1) {
        break label464;
      }
      localObject2 = this.AKR.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = i;
      ((ViewGroup.LayoutParams)localObject2).height = j;
      this.AKR.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ah.dXB().b((bzh)localObject1, this.AKR, -1, this.context.hashCode(), bk.JgB);
      this.AKR.setVisibility(0);
      this.AKR.setTag(this);
      this.contentView.setTag(this);
      this.AKN.setTag(this);
      this.AKO.setTag(this);
      this.AKR.setOnClickListener(this.zrv.AiC);
      this.ofu.c(this.AKR, this.zrv.AQe, this.zrv.APL);
    }
    label1451:
    label1453:
    label1471:
    for (;;)
    {
      if (!this.znm.dVj().dZu()) {
        break label1546;
      }
      if (this.AKK != null) {
        this.AKK.setVisibility(8);
      }
      if (this.AKL != null) {
        this.AKL.setVisibility(8);
      }
      this.AKW.setVisibility(0);
      this.AKY.P(this.znm);
      AppMethodBeat.o(100010);
      return;
      T(this.znm);
      break;
      label458:
      localObject1 = null;
      break label147;
      label464:
      if ((this.timeLineObject.HUG.Gtw == 5) || (this.timeLineObject.HUG.Gtw == 15))
      {
        this.AKJ.AnG.setVisibility(0);
        this.ofu.c(this.AKJ.AnJ, this.zrv.AQe, this.zrv.APL);
        Object localObject3 = this.AKJ.AnG.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = i;
        ((ViewGroup.LayoutParams)localObject3).height = j;
        this.AKJ.AnG.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.AKJ.AnH.hy(i, j);
        this.AKJ.AnH.setOnCompletionListener(new b.e()
        {
          public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
          {
            AppMethodBeat.i(100006);
            if ((paramAnonymousInt != -1) && (b.this.Asq != null)) {
              b.this.Asq.C(b.this.znm.field_snsId, false);
            }
            AppMethodBeat.o(100006);
          }
        });
        this.AKJ.AnH.setOnDecodeDurationListener(new b.f()
        {
          public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
          {
            AppMethodBeat.i(100007);
            ae.d("MicroMsg.CardAdDetailItemView", "onDecodeProgress:".concat(String.valueOf(paramAnonymousLong)));
            if ((b.this.Asq != null) && (b.this.znm != null))
            {
              b.this.Asq.zO(b.this.znm.field_snsId);
              b.this.Asq.aj(b.this.znm.field_snsId, 1000L * paramAnonymousLong);
              if (!b.this.Asq.zL(b.this.znm.field_snsId))
              {
                int i = (int)paramAnonymousb.dTD();
                ae.i("MicroMsg.CardAdDetailItemView", "updatePlayStartTime, duration=".concat(String.valueOf(i)));
                b.this.Asq.d(b.this.znm.field_snsId, bu.HQ(), false);
                b.this.Asq.e(b.this.znm.field_snsId, i, false);
                b.this.Asq.ai(b.this.znm.field_snsId, b.this.znm.field_snsId);
              }
            }
            AppMethodBeat.o(100007);
          }
        });
        long l = System.nanoTime();
        boolean bool = com.tencent.mm.plugin.sns.model.g.t((bzh)localObject1);
        ae.i("MicroMsg.CardAdDetailItemView", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
        localObject3 = this.AKJ;
        this.AKJ.dqc = this.znm.eco();
        if (!bool) {
          if (((com.tencent.mm.plugin.sns.model.g)localObject2).w((bzh)localObject1))
          {
            ((aq)localObject3).zWJ.setVisibility(8);
            ((aq)localObject3).AnK.setVisibility(0);
            ((aq)localObject3).AnK.fPL();
            label721:
            this.AKJ.AnG.setVisibility(0);
            ((aq)localObject3).AnH.setTagObject(localObject3);
            ((aq)localObject3).AnJ.setTag(this);
            this.contentView.setTag(this);
            this.AKN.setTag(this);
            this.AKO.setTag(this);
            ((com.tencent.mm.plugin.sns.model.g)localObject2).a(this.znm, (bzh)localObject1, ((aq)localObject3).AnH, this.context.hashCode(), 0, bk.JgB, true, true);
            ((aq)localObject3).AnH.start();
            this.ALa = true;
            if (this.Asq == null) {
              continue;
            }
            localObject2 = ap.jv(ah.getAccSnsPath(), ((bzh)localObject1).Id);
            localObject1 = r.i((bzh)localObject1);
            if (!o.fB((String)localObject2 + (String)localObject1)) {
              break label1453;
            }
            this.Asq.D(this.znm.field_snsId, true);
            label887:
            if (ah.dXB().b(this.znm, null) != 5) {
              break label1471;
            }
          }
        }
        for (bool = true;; bool = false)
        {
          this.Asq.c(this.znm.field_snsId, bool, false);
          break;
          if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.znm, null) == 5)
          {
            ((com.tencent.mm.plugin.sns.model.g)localObject2).A((bzh)localObject1);
            ((aq)localObject3).zWJ.setVisibility(8);
            ((aq)localObject3).AnK.setVisibility(0);
            ((aq)localObject3).AnK.fPL();
            break label721;
          }
          if (((com.tencent.mm.plugin.sns.model.g)localObject2).x((bzh)localObject1))
          {
            ((aq)localObject3).AnK.setVisibility(8);
            ((aq)localObject3).zWJ.setImageResource(2131691612);
            ((aq)localObject3).zWJ.setVisibility(0);
            break label721;
          }
          ((com.tencent.mm.plugin.sns.model.g)localObject2).y((bzh)localObject1);
          ((aq)localObject3).zWJ.setVisibility(0);
          ((aq)localObject3).AnK.setVisibility(8);
          ((aq)localObject3).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691166));
          ((aq)localObject3).zWJ.setContentDescription(this.context.getResources().getString(2131761939));
          if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.znm, null) != 4) {
            break label721;
          }
          ((aq)localObject3).zWK.setVisibility(0);
          break label721;
          if (((com.tencent.mm.plugin.sns.model.g)localObject2).u((bzh)localObject1))
          {
            ((aq)localObject3).zWJ.setVisibility(0);
            ((aq)localObject3).AnK.setVisibility(8);
            ((aq)localObject3).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691166));
            ((aq)localObject3).zWJ.setContentDescription(this.context.getResources().getString(2131761939));
          }
          for (;;)
          {
            if (!((aq)localObject3).AnH.ziA.dTA()) {
              break label1451;
            }
            ae.d("MicroMsg.CardAdDetailItemView", "play video error " + ((bzh)localObject1).Id + " " + ((bzh)localObject1).Url + " " + ((bzh)localObject1).Hmj);
            ((com.tencent.mm.plugin.sns.model.g)localObject2).y((bzh)localObject1);
            ((aq)localObject3).zWJ.setVisibility(0);
            ((aq)localObject3).AnK.setVisibility(8);
            ((aq)localObject3).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691166));
            ((aq)localObject3).zWJ.setContentDescription(this.context.getResources().getString(2131761939));
            break;
            if (((com.tencent.mm.plugin.sns.model.g)localObject2).v((bzh)localObject1))
            {
              ((aq)localObject3).zWJ.setVisibility(8);
              ((aq)localObject3).AnK.setVisibility(8);
            }
            else if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.znm, null) <= 5)
            {
              ((aq)localObject3).zWJ.setVisibility(8);
              ((aq)localObject3).AnK.setVisibility(8);
            }
            else
            {
              ((com.tencent.mm.plugin.sns.model.g)localObject2).y((bzh)localObject1);
              ((aq)localObject3).zWJ.setVisibility(0);
              ((aq)localObject3).AnK.setVisibility(8);
              ((aq)localObject3).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691166));
              ((aq)localObject3).zWJ.setContentDescription(this.context.getResources().getString(2131761939));
            }
          }
          break label721;
          this.Asq.D(this.znm.field_snsId, false);
          break label887;
        }
      }
      else
      {
        ((com.tencent.mm.plugin.sns.model.g)localObject2).a(this.AKJ.AnH, this.context.hashCode(), 0);
        this.AKJ.AnL.setVisibility(8);
        this.AKJ.AnH.setOnSightCompletionAction(null);
        this.AKJ.AnH.setOnCompletionListener(null);
        this.AKJ.AnH.setOnDecodeDurationListener(null);
      }
    }
    label1546:
    this.AKW.setVisibility(8);
    label1555:
    AppMethodBeat.o(100010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.b
 * JD-Core Version:    0.7.0.1
 */