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
import com.tencent.mm.cg.g;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.b.b;
import com.tencent.mm.plugin.sns.storage.b.j;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.ap.b;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  private Context context;
  private com.tencent.mm.ui.widget.b.a mVN;
  public TextView xOP;
  public TextView xOQ;
  public View xOR;
  public Button xOS;
  public Button xOT;
  public View xOU;
  public MaskImageView xOV;
  public SnsCardAdTagListView xOW;
  public View xOX;
  public View xOY;
  public View xOZ;
  public View xPa;
  private int xPb;
  private ap xPc;
  private ar xPd;
  private boolean xPe = false;
  com.tencent.mm.plugin.sns.a.b.i xwT;
  
  public b(TimeLineObject paramTimeLineObject, p paramp, com.tencent.mm.plugin.sns.ui.d.b paramb, com.tencent.mm.plugin.sns.a.b.i parami)
  {
    this.timeLineObject = paramTimeLineObject;
    this.wwP = paramp;
    this.xta = paramb;
    this.xwT = parami;
  }
  
  private void Q(p paramp)
  {
    int j = 0;
    AppMethodBeat.i(100011);
    if ((paramp == null) || (!paramp.dvm()))
    {
      AppMethodBeat.o(100011);
      return;
    }
    int k = this.context.getResources().getColor(2131100027);
    int m = this.context.getResources().getColor(2131099658);
    if ((this.xOS == null) || (this.xOT == null))
    {
      AppMethodBeat.o(100011);
      return;
    }
    this.xOS.setOnClickListener(this.xta.xUb);
    this.xOT.setOnClickListener(this.xta.xUc);
    int n;
    int i;
    if (paramp.dxs().dvq())
    {
      n = x.jh(paramp.dxs().wTR.wUF, paramp.dyg());
      if ((n > 0) && (n <= 2)) {
        if (n == 1)
        {
          this.xOT.setTextColor(m);
          this.xOT.setText(paramp.dxs().wTR.MD(1));
          this.xOS.setTextColor(k);
          this.xOS.setText(paramp.dxs().wTR.MC(0));
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.xOS.setTextColor(k);
        this.xOT.setTextColor(k);
        this.xOS.setText(paramp.dxs().dvi());
        this.xOT.setText(paramp.dxs().dvj());
      }
      AppMethodBeat.o(100011);
      return;
      i = j;
      if (n == 2)
      {
        this.xOS.setTextColor(m);
        this.xOS.setText(paramp.dxs().wTR.MD(0));
        this.xOT.setTextColor(k);
        this.xOT.setText(paramp.dxs().wTR.MC(1));
        i = j;
        continue;
        i = 1;
      }
    }
  }
  
  public final void k(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100009);
    this.context = paramView1.getContext();
    this.xPc = new ap(this.context, paramView1, 1, this.xwT, new ap.b()
    {
      public final void dAh()
      {
        AppMethodBeat.i(100005);
        b.this.xta.a(b.this);
        AppMethodBeat.o(100005);
      }
    });
    this.xPd = new ar(this.context, paramView1, this.xta);
    this.contentView = paramView1;
    this.xwu = paramView2;
    this.xOY = paramView1.findViewById(2131302206);
    if ((this.xOY instanceof RoundedCornerFrameLayout)) {
      ((RoundedCornerFrameLayout)this.xOY).setRadius(com.tencent.mm.cd.a.fromDPToPix(this.context, 4));
    }
    this.xOZ = paramView1.findViewById(2131303102);
    this.xOR = paramView1.findViewById(2131297744);
    this.xOR.setVisibility(8);
    this.xOU = paramView1.findViewById(2131297919);
    this.xOU.setVisibility(8);
    if (ai.Eq()) {
      ((ImageView)paramView1.findViewById(2131306896)).setImageDrawable(this.context.getResources().getDrawable(2131689524));
    }
    this.xOV = ((MaskImageView)paramView1.findViewById(2131304943));
    this.xOS = ((Button)paramView1.findViewById(2131297745));
    this.xOT = ((Button)paramView1.findViewById(2131297746));
    this.xPa = paramView1.findViewById(2131296355);
    paramView2 = this.wwP.dxu();
    if ((paramView2 != null) && (paramView2.dvd()) && (!this.wwP.dyk())) {
      this.xOU.setVisibility(0);
    }
    this.xOQ = ((TextView)paramView1.findViewById(2131299000));
    this.xOQ.setClickable(false);
    this.xOQ.setLongClickable(false);
    paramView2 = (WindowManager)this.context.getSystemService("window");
    this.xPb = (Math.min(paramView2.getDefaultDisplay().getWidth(), paramView2.getDefaultDisplay().getHeight()) - com.tencent.mm.cd.a.ao(this.context, 2131166827) - com.tencent.mm.cd.a.ao(this.context, 2131165274) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165516));
    paramView2 = (LinearLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.topMargin = this.context.getResources().getDimensionPixelOffset(2131165500);
    paramView2.bottomMargin = 0;
    paramView2.width = this.xPb;
    paramView2.height = -2;
    paramView1.setLayoutParams(paramView2);
    paramView1.setBackground(this.context.getResources().getDrawable(2131234094));
    this.xOP = ((TextView)paramView1.findViewById(2131298999));
    this.xOP.setClickable(false);
    this.xOP.setLongClickable(false);
    if (!bt.isNullOrNil(this.wwP.dxs().wTx))
    {
      paramView2 = g.eIa();
      this.xOP.getContext();
      paramView2 = paramView2.b(this.wwP.dxs().wTx, this.xOP.getTextSize());
      this.xOP.setText(paramView2);
      this.xOP.setVisibility(0);
      if (!bt.isNullOrNil(this.wwP.dxs().wTy)) {
        break label1299;
      }
      paramView2 = this.timeLineObject.Etj;
      label582:
      if (bt.isNullOrNil(paramView2)) {
        break label1313;
      }
      g localg = g.eIa();
      this.xOQ.getContext();
      paramView2 = localg.b(paramView2, this.xOQ.getTextSize());
      this.xOQ.setText(paramView2);
      this.xOQ.setVisibility(0);
      label630:
      this.mVN = new com.tencent.mm.ui.widget.b.a(this.context);
      this.mVN.c(paramView1, this.xta.xTL, this.xta.xTt);
      if ((!this.wwP.dxs().dvo()) && (!this.wwP.dxs().dvq())) {
        break label1351;
      }
      if (!this.wwP.dxs().dvp()) {
        break label1325;
      }
      this.xPd.a(this.wwP, this);
      this.xOR.setVisibility(8);
      this.xPd.dAi();
      if (this.xOP != null) {
        this.xOP.setVisibility(8);
      }
      if (this.xOQ != null) {
        this.xOQ.setVisibility(8);
      }
      label766:
      this.xOO = new com.tencent.mm.plugin.sns.ui.an();
      this.xOO.xsp = paramView1.findViewById(2131304944);
      this.xOO.xsm = this.xOO.xsp;
      this.xOO.xsp.setOnClickListener(this.xta.xTQ);
      this.xOO.xsn = ((VideoSightView)this.xOO.xsp.findViewById(2131300914));
      this.xOO.xsn.setMute(true);
      this.xOO.xbT = ((ImageView)this.xOO.xsp.findViewById(2131305196));
      this.xOO.xsq = ((MMPinProgressBtn)this.xOO.xsp.findViewById(2131303515));
      this.xOO.xsr = ((TextView)this.xOO.xsp.findViewById(2131299492));
      this.xOO.xbU = ((TextView)this.xOO.xsp.findViewById(2131299517));
      this.xOX = paramView1.findViewById(2131304890);
      this.xOW = ((SnsCardAdTagListView)this.contentView.findViewById(2131297725));
      this.xOW.setActivityContext((Activity)this.context);
    }
    for (;;)
    {
      try
      {
        paramView2 = this.wwP.getSnsId();
        if (com.tencent.mm.plugin.sns.ui.widget.b.jm(this.xOW.getOriginSnsId(), paramView2)) {
          continue;
        }
        this.xOW.removeAllViews();
        if (this.wwP.dxs().wTB.wUe.size() > 0)
        {
          this.xOW.setVisibility(0);
          this.xOW.setTagSpace(com.tencent.mm.cd.a.fromDPToPix(this.context, 8));
          this.xOW.fP(this.wwP.dxs().wTB.wUe);
        }
        this.xOW.setOriginSnsId(paramView2);
      }
      catch (Exception paramView2)
      {
        label1299:
        label1313:
        label1325:
        label1351:
        ad.e("MicroMsg.CardAdDetailItemView", paramView2.toString());
        continue;
      }
      if (!bt.isNullOrNil(this.wwP.dxs().wTz))
      {
        this.xOX.setVisibility(0);
        this.xOX.findViewById(2131304891).setVisibility(0);
        ((TextView)this.xOX.findViewById(2131304891)).setText(this.wwP.dxs().wTz);
      }
      if (!bt.isNullOrNil(this.wwP.dxs().wTA)) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(this.wwP.dxs().wTA, new f.a()
        {
          public final void apm(String paramAnonymousString)
          {
            AppMethodBeat.i(100008);
            if (!bt.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = com.tencent.mm.sdk.platformtools.f.decodeFile(paramAnonymousString, null);
              if (paramAnonymousString != null)
              {
                b.this.xOX.setVisibility(0);
                ImageView localImageView = (ImageView)b.this.xOX.findViewById(2131304889);
                localImageView.setImageBitmap(paramAnonymousString);
                localImageView.setVisibility(0);
              }
            }
            AppMethodBeat.o(100008);
          }
          
          public final void dsA() {}
          
          public final void duP() {}
        });
      }
      this.mVN.c(paramView1, this.xta.xTL, this.xta.xTt);
      this.xOV.setVisibility(8);
      this.xOV.setScaleType(QImageView.a.HBy);
      this.xOO.xsm.setVisibility(8);
      this.xOO.xsn.wsy = true;
      this.xOO.xsn.setScaleType(QImageView.a.HBy);
      paramView1.setOnClickListener(this.xta.xUd);
      AppMethodBeat.o(100009);
      return;
      this.xOP.setVisibility(8);
      break;
      paramView2 = this.wwP.dxs().wTy;
      break label582;
      this.xOQ.setVisibility(8);
      break label630;
      this.xOR.setVisibility(0);
      this.xPd.dAj();
      Q(this.wwP);
      break label766;
      this.xOR.setVisibility(8);
      this.xPd.dAj();
      break label766;
      if (this.wwP.dxs().wTB.wUe.size() > 0) {
        this.xOW.setVisibility(0);
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(187779);
    try
    {
      ad.i("MicroMsg.CardAdDetailItemView", "onPause, hasPlayedVideo=" + this.xPe);
      if ((this.xPe) && (this.xOO != null) && (this.xOO.xsn != null))
      {
        this.xOO.xsn.pause();
        if ((this.xwT != null) && (this.wwP != null)) {
          this.xwT.sn(this.wwP.field_snsId);
        }
      }
      AppMethodBeat.o(187779);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.CardAdDetailItemView", "onPause, exp=" + localThrowable.toString());
      AppMethodBeat.o(187779);
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(100010);
    this.wwP = com.tencent.mm.plugin.sns.storage.h.apJ(this.wwP.getSnsId());
    ad.i("MicroMsg.CardAdDetailItemView", "refreshView");
    Object localObject2;
    Object localObject1;
    label147:
    int i;
    int j;
    if ((this.wwP.dxs().dvo()) || (this.wwP.dxs().dvq()))
    {
      if (this.wwP.dxs().dvp()) {
        this.xPd.a(this.wwP, this);
      }
    }
    else
    {
      this.xOO.xbU.setVisibility(8);
      this.xPe = false;
      localObject2 = af.dtr();
      if ((this.timeLineObject.Etm == null) || (this.timeLineObject.Etm.DaC.size() <= 0)) {
        break label458;
      }
      localObject1 = (bpi)this.timeLineObject.Etm.DaC.get(0);
      ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
      if (localObject1 == null) {
        break label1555;
      }
      i = this.xPb - this.context.getResources().getDimensionPixelSize(2131165568) - this.context.getResources().getDimensionPixelSize(2131165568);
      j = (int)(i * ((bpi)localObject1).DMT.DNI / ((bpi)localObject1).DMT.DNH);
      if (this.timeLineObject.Etm.DaB != 1) {
        break label464;
      }
      localObject2 = this.xOV.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = i;
      ((ViewGroup.LayoutParams)localObject2).height = j;
      this.xOV.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      af.dtr().b((bpi)localObject1, this.xOV, -1, this.context.hashCode(), bc.FzE);
      this.xOV.setVisibility(0);
      this.xOV.setTag(this);
      this.contentView.setTag(this);
      this.xOS.setTag(this);
      this.xOT.setTag(this);
      this.xOV.setOnClickListener(this.xta.xno);
      this.mVN.c(this.xOV, this.xta.xTL, this.xta.xTt);
    }
    label1451:
    label1453:
    label1471:
    for (;;)
    {
      if (!this.wwP.dxs().dvg()) {
        break label1546;
      }
      if (this.xOP != null) {
        this.xOP.setVisibility(8);
      }
      if (this.xOQ != null) {
        this.xOQ.setVisibility(8);
      }
      this.xPa.setVisibility(0);
      this.xPc.M(this.wwP);
      AppMethodBeat.o(100010);
      return;
      Q(this.wwP);
      break;
      label458:
      localObject1 = null;
      break label147;
      label464:
      if ((this.timeLineObject.Etm.DaB == 5) || (this.timeLineObject.Etm.DaB == 15))
      {
        this.xOO.xsm.setVisibility(0);
        this.mVN.c(this.xOO.xsp, this.xta.xTL, this.xta.xTt);
        Object localObject3 = this.xOO.xsm.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = i;
        ((ViewGroup.LayoutParams)localObject3).height = j;
        this.xOO.xsm.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.xOO.xsn.gW(i, j);
        this.xOO.xsn.setOnCompletionListener(new b.e()
        {
          public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
          {
            AppMethodBeat.i(100006);
            if ((paramAnonymousInt != -1) && (b.this.xwT != null)) {
              b.this.xwT.A(b.this.wwP.field_snsId, false);
            }
            AppMethodBeat.o(100006);
          }
        });
        this.xOO.xsn.setOnDecodeDurationListener(new b.f()
        {
          public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
          {
            AppMethodBeat.i(100007);
            ad.d("MicroMsg.CardAdDetailItemView", "onDecodeProgress:".concat(String.valueOf(paramAnonymousLong)));
            if ((b.this.xwT != null) && (b.this.wwP != null))
            {
              b.this.xwT.sm(b.this.wwP.field_snsId);
              b.this.xwT.ak(b.this.wwP.field_snsId, 1000L * paramAnonymousLong);
              if (!b.this.xwT.sj(b.this.wwP.field_snsId))
              {
                int i = (int)paramAnonymousb.dqu();
                ad.i("MicroMsg.CardAdDetailItemView", "updatePlayStartTime, duration=".concat(String.valueOf(i)));
                b.this.xwT.d(b.this.wwP.field_snsId, bt.GC(), false);
                b.this.xwT.e(b.this.wwP.field_snsId, i, false);
                b.this.xwT.aj(b.this.wwP.field_snsId, b.this.wwP.field_snsId);
              }
            }
            AppMethodBeat.o(100007);
          }
        });
        long l = System.nanoTime();
        boolean bool = com.tencent.mm.plugin.sns.model.f.t((bpi)localObject1);
        ad.i("MicroMsg.CardAdDetailItemView", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
        localObject3 = this.xOO;
        this.xOO.dgg = this.wwP.dxX();
        if (!bool) {
          if (((com.tencent.mm.plugin.sns.model.f)localObject2).w((bpi)localObject1))
          {
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.setVisibility(0);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.feJ();
            label721:
            this.xOO.xsm.setVisibility(0);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsn.setTagObject(localObject3);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsp.setTag(this);
            this.contentView.setTag(this);
            this.xOS.setTag(this);
            this.xOT.setTag(this);
            ((com.tencent.mm.plugin.sns.model.f)localObject2).a(this.wwP, (bpi)localObject1, ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsn, this.context.hashCode(), 0, bc.FzE, true, true);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsn.start();
            this.xPe = true;
            if (this.xwT == null) {
              continue;
            }
            localObject2 = com.tencent.mm.plugin.sns.model.an.iF(af.getAccSnsPath(), ((bpi)localObject1).Id);
            localObject1 = q.i((bpi)localObject1);
            if (!com.tencent.mm.vfs.i.eK((String)localObject2 + (String)localObject1)) {
              break label1453;
            }
            this.xwT.B(this.wwP.field_snsId, true);
            label887:
            if (af.dtr().b(this.wwP, null) != 5) {
              break label1471;
            }
          }
        }
        for (bool = true;; bool = false)
        {
          this.xwT.e(this.wwP.field_snsId, bool, false);
          break;
          if (((com.tencent.mm.plugin.sns.model.f)localObject2).b(this.wwP, null) == 5)
          {
            ((com.tencent.mm.plugin.sns.model.f)localObject2).A((bpi)localObject1);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.setVisibility(0);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.feJ();
            break label721;
          }
          if (((com.tencent.mm.plugin.sns.model.f)localObject2).x((bpi)localObject1))
          {
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setImageResource(2131234034);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setVisibility(0);
            break label721;
          }
          ((com.tencent.mm.plugin.sns.model.f)localObject2).y((bpi)localObject1);
          ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setVisibility(0);
          ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691166));
          ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setContentDescription(this.context.getResources().getString(2131761939));
          if (((com.tencent.mm.plugin.sns.model.f)localObject2).b(this.wwP, null) != 4) {
            break label721;
          }
          ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbU.setVisibility(0);
          break label721;
          if (((com.tencent.mm.plugin.sns.model.f)localObject2).u((bpi)localObject1))
          {
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setVisibility(0);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691166));
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setContentDescription(this.context.getResources().getString(2131761939));
          }
          for (;;)
          {
            if (!((com.tencent.mm.plugin.sns.ui.an)localObject3).xsn.wsq.dqr()) {
              break label1451;
            }
            ad.d("MicroMsg.CardAdDetailItemView", "play video error " + ((bpi)localObject1).Id + " " + ((bpi)localObject1).Url + " " + ((bpi)localObject1).DMQ);
            ((com.tencent.mm.plugin.sns.model.f)localObject2).y((bpi)localObject1);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setVisibility(0);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691166));
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setContentDescription(this.context.getResources().getString(2131761939));
            break;
            if (((com.tencent.mm.plugin.sns.model.f)localObject2).v((bpi)localObject1))
            {
              ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.setVisibility(8);
            }
            else if (((com.tencent.mm.plugin.sns.model.f)localObject2).b(this.wwP, null) <= 5)
            {
              ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.setVisibility(8);
            }
            else
            {
              ((com.tencent.mm.plugin.sns.model.f)localObject2).y((bpi)localObject1);
              ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setVisibility(0);
              ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691166));
              ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setContentDescription(this.context.getResources().getString(2131761939));
            }
          }
          break label721;
          this.xwT.B(this.wwP.field_snsId, false);
          break label887;
        }
      }
      else
      {
        ((com.tencent.mm.plugin.sns.model.f)localObject2).a(this.xOO.xsn, this.context.hashCode(), 0);
        this.xOO.xsr.setVisibility(8);
        this.xOO.xsn.setOnSightCompletionAction(null);
        this.xOO.xsn.setOnCompletionListener(null);
        this.xOO.xsn.setOnDecodeDurationListener(null);
      }
    }
    label1546:
    this.xPa.setVisibility(8);
    label1555:
    AppMethodBeat.o(100010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.b
 * JD-Core Version:    0.7.0.1
 */