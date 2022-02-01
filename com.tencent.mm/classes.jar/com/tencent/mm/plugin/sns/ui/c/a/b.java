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
import com.tencent.mm.cf.g;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.b.c;
import com.tencent.mm.plugin.sns.storage.b.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.ap.b;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  private Context context;
  private com.tencent.mm.ui.widget.b.a nym;
  com.tencent.mm.plugin.sns.ad.d.i yJJ;
  public TextView zbF;
  public TextView zbG;
  public View zbH;
  public Button zbI;
  public Button zbJ;
  public View zbK;
  public MaskImageView zbL;
  public SnsCardAdTagListView zbM;
  public View zbN;
  public View zbO;
  public View zbP;
  public View zbQ;
  private int zbR;
  private ap zbS;
  private ar zbT;
  private boolean zbU = false;
  
  public b(TimeLineObject paramTimeLineObject, p paramp, com.tencent.mm.plugin.sns.ui.d.b paramb, com.tencent.mm.plugin.sns.ad.d.i parami)
  {
    this.timeLineObject = paramTimeLineObject;
    this.xIq = paramp;
    this.xLF = paramb;
    this.yJJ = parami;
  }
  
  private void R(p paramp)
  {
    int j = 0;
    AppMethodBeat.i(100011);
    if ((paramp == null) || (!paramp.dJL()))
    {
      AppMethodBeat.o(100011);
      return;
    }
    int k = this.context.getResources().getColor(2131100027);
    int m = this.context.getResources().getColor(2131099658);
    if ((this.zbI == null) || (this.zbJ == null))
    {
      AppMethodBeat.o(100011);
      return;
    }
    this.zbI.setOnClickListener(this.xLF.zgX);
    this.zbJ.setOnClickListener(this.xLF.zgY);
    int n;
    int i;
    if (paramp.dFR().dJP())
    {
      n = x.jF(paramp.dFR().ygC.yht, paramp.dMD());
      if ((n > 0) && (n <= 2)) {
        if (n == 1)
        {
          this.zbJ.setTextColor(m);
          this.zbJ.setText(paramp.dFR().ygC.OF(1));
          this.zbI.setTextColor(k);
          this.zbI.setText(paramp.dFR().ygC.OE(0));
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.zbI.setTextColor(k);
        this.zbJ.setTextColor(k);
        this.zbI.setText(paramp.dFR().dJH());
        this.zbJ.setText(paramp.dFR().dJI());
      }
      AppMethodBeat.o(100011);
      return;
      i = j;
      if (n == 2)
      {
        this.zbI.setTextColor(m);
        this.zbI.setText(paramp.dFR().ygC.OF(0));
        this.zbJ.setTextColor(k);
        this.zbJ.setText(paramp.dFR().ygC.OE(1));
        i = j;
        continue;
        i = 1;
      }
    }
  }
  
  public final void l(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100009);
    this.context = paramView1.getContext();
    this.zbS = new ap(this.context, paramView1, 1, this.yJJ, new ap.b()
    {
      public final void dOE()
      {
        AppMethodBeat.i(100005);
        b.this.xLF.a(b.this);
        AppMethodBeat.o(100005);
      }
    });
    this.zbT = new ar(this.context, paramView1, this.xLF);
    this.contentView = paramView1;
    this.yJk = paramView2;
    this.zbO = paramView1.findViewById(2131302206);
    if ((this.zbO instanceof RoundedCornerFrameLayout)) {
      ((RoundedCornerFrameLayout)this.zbO).setRadius(com.tencent.mm.cc.a.fromDPToPix(this.context, 4));
    }
    this.zbP = paramView1.findViewById(2131303102);
    this.zbH = paramView1.findViewById(2131297744);
    this.zbH.setVisibility(8);
    this.zbK = paramView1.findViewById(2131297919);
    this.zbK.setVisibility(8);
    if (aj.DT()) {
      ((ImageView)paramView1.findViewById(2131306896)).setImageDrawable(this.context.getResources().getDrawable(2131689524));
    }
    this.zbL = ((MaskImageView)paramView1.findViewById(2131304943));
    this.zbI = ((Button)paramView1.findViewById(2131297745));
    this.zbJ = ((Button)paramView1.findViewById(2131297746));
    this.zbQ = paramView1.findViewById(2131296355);
    paramView2 = this.xIq.dFQ();
    if ((paramView2 != null) && (paramView2.dJC()) && (!this.xIq.dMH())) {
      this.zbK.setVisibility(0);
    }
    this.zbG = ((TextView)paramView1.findViewById(2131299000));
    this.zbG.setClickable(false);
    this.zbG.setLongClickable(false);
    paramView2 = (WindowManager)this.context.getSystemService("window");
    this.zbR = (Math.min(paramView2.getDefaultDisplay().getWidth(), paramView2.getDefaultDisplay().getHeight()) - com.tencent.mm.cc.a.au(this.context, 2131166827) - com.tencent.mm.cc.a.au(this.context, 2131165274) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165516));
    paramView2 = (LinearLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.topMargin = this.context.getResources().getDimensionPixelOffset(2131165500);
    paramView2.bottomMargin = 0;
    paramView2.width = this.zbR;
    paramView2.height = -2;
    paramView1.setLayoutParams(paramView2);
    paramView1.setBackground(this.context.getResources().getDrawable(2131234094));
    this.zbF = ((TextView)paramView1.findViewById(2131298999));
    this.zbF.setClickable(false);
    this.zbF.setLongClickable(false);
    if (!bs.isNullOrNil(this.xIq.dFR().ygh))
    {
      paramView2 = g.eXw();
      this.zbF.getContext();
      paramView2 = paramView2.b(this.xIq.dFR().ygh, this.zbF.getTextSize());
      this.zbF.setText(paramView2);
      this.zbF.setVisibility(0);
      if (!bs.isNullOrNil(this.xIq.dFR().ygi)) {
        break label1300;
      }
      paramView2 = this.timeLineObject.FQl;
      label582:
      if (bs.isNullOrNil(paramView2)) {
        break label1314;
      }
      g localg = g.eXw();
      this.zbG.getContext();
      paramView2 = localg.b(paramView2, this.zbG.getTextSize());
      this.zbG.setText(paramView2);
      this.zbG.setVisibility(0);
      label630:
      this.nym = new com.tencent.mm.ui.widget.b.a(this.context);
      this.nym.c(paramView1, this.xLF.zgH, this.xLF.zgp);
      if ((!this.xIq.dFR().dJN()) && (!this.xIq.dFR().dJP())) {
        break label1352;
      }
      if (!this.xIq.dFR().dJO()) {
        break label1326;
      }
      this.zbT.a(this.xIq, this);
      this.zbH.setVisibility(8);
      this.zbT.dOF();
      if (this.zbF != null) {
        this.zbF.setVisibility(8);
      }
      if (this.zbG != null) {
        this.zbG.setVisibility(8);
      }
      label766:
      this.zbE = new com.tencent.mm.plugin.sns.ui.an();
      this.zbE.yFf = paramView1.findViewById(2131304944);
      this.zbE.yFc = this.zbE.yFf;
      this.zbE.yFf.setOnClickListener(this.xLF.zgM);
      this.zbE.yFd = ((VideoSightView)this.zbE.yFf.findViewById(2131300914));
      this.zbE.yFd.setMute(true);
      this.zbE.yoI = ((ImageView)this.zbE.yFf.findViewById(2131305196));
      this.zbE.yFg = ((MMPinProgressBtn)this.zbE.yFf.findViewById(2131303515));
      this.zbE.yFh = ((TextView)this.zbE.yFf.findViewById(2131299492));
      this.zbE.yoJ = ((TextView)this.zbE.yFf.findViewById(2131299517));
      this.zbN = paramView1.findViewById(2131304890);
      this.zbM = ((SnsCardAdTagListView)this.contentView.findViewById(2131297725));
      this.zbM.setActivityContext((Activity)this.context);
    }
    for (;;)
    {
      try
      {
        paramView2 = this.xIq.getSnsId();
        if (com.tencent.mm.plugin.sns.ui.widget.b.jK(this.zbM.getOriginSnsId(), paramView2)) {
          continue;
        }
        this.zbM.removeAllViews();
        if (this.xIq.dFR().ygl.ygS.size() > 0)
        {
          this.zbM.setVisibility(0);
          this.zbM.setTagSpace(com.tencent.mm.cc.a.fromDPToPix(this.context, 8));
          this.zbM.fX(this.xIq.dFR().ygl.ygS);
        }
        this.zbM.setOriginSnsId(paramView2);
      }
      catch (Exception paramView2)
      {
        label1300:
        label1314:
        label1326:
        label1352:
        ac.e("MicroMsg.CardAdDetailItemView", paramView2.toString());
        continue;
      }
      if (!bs.isNullOrNil(this.xIq.dFR().ygj))
      {
        this.zbN.setVisibility(0);
        this.zbN.findViewById(2131304891).setVisibility(0);
        ((TextView)this.zbN.findViewById(2131304891)).setText(this.xIq.dFR().ygj);
      }
      if (!bs.isNullOrNil(this.xIq.dFR().ygk)) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(this.xIq.dFR().ygk, false, new f.a()
        {
          public final void asD(String paramAnonymousString)
          {
            AppMethodBeat.i(100008);
            if (!bs.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = com.tencent.mm.sdk.platformtools.f.decodeFile(paramAnonymousString, null);
              if (paramAnonymousString != null)
              {
                b.this.zbN.setVisibility(0);
                ImageView localImageView = (ImageView)b.this.zbN.findViewById(2131304889);
                localImageView.setImageBitmap(paramAnonymousString);
                localImageView.setVisibility(0);
              }
            }
            AppMethodBeat.o(100008);
          }
          
          public final void dFC() {}
          
          public final void dFD() {}
        });
      }
      this.nym.c(paramView1, this.xLF.zgH, this.xLF.zgp);
      this.zbL.setVisibility(8);
      this.zbL.setScaleType(QImageView.a.JbU);
      this.zbE.yFc.setVisibility(8);
      this.zbE.yFd.xDO = true;
      this.zbE.yFd.setScaleType(QImageView.a.JbU);
      paramView1.setOnClickListener(this.xLF.zgZ);
      AppMethodBeat.o(100009);
      return;
      this.zbF.setVisibility(8);
      break;
      paramView2 = this.xIq.dFR().ygi;
      break label582;
      this.zbG.setVisibility(8);
      break label630;
      this.zbH.setVisibility(0);
      this.zbT.dOG();
      R(this.xIq);
      break label766;
      this.zbH.setVisibility(8);
      this.zbT.dOG();
      break label766;
      if (this.xIq.dFR().ygl.ygS.size() > 0) {
        this.zbM.setVisibility(0);
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(200648);
    try
    {
      ac.i("MicroMsg.CardAdDetailItemView", "onPause, hasPlayedVideo=" + this.zbU);
      if ((this.zbU) && (this.zbE != null) && (this.zbE.yFd != null))
      {
        this.zbE.yFd.pause();
        if ((this.yJJ != null) && (this.xIq != null)) {
          this.yJJ.wQ(this.xIq.field_snsId);
        }
      }
      AppMethodBeat.o(200648);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.CardAdDetailItemView", "onPause, exp=" + localThrowable.toString());
      AppMethodBeat.o(200648);
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(100010);
    this.xIq = com.tencent.mm.plugin.sns.storage.h.auS(this.xIq.getSnsId());
    ac.i("MicroMsg.CardAdDetailItemView", "refreshView");
    Object localObject2;
    Object localObject1;
    label147:
    int i;
    int j;
    if ((this.xIq.dFR().dJN()) || (this.xIq.dFR().dJP()))
    {
      if (this.xIq.dFR().dJO()) {
        this.zbT.a(this.xIq, this);
      }
    }
    else
    {
      this.zbE.yoJ.setVisibility(8);
      this.zbU = false;
      localObject2 = af.dHO();
      if ((this.timeLineObject.FQo == null) || (this.timeLineObject.FQo.Etz.size() <= 0)) {
        break label458;
      }
      localObject1 = (btz)this.timeLineObject.FQo.Etz.get(0);
      ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
      if (localObject1 == null) {
        break label1555;
      }
      i = this.zbR - this.context.getResources().getDimensionPixelSize(2131165568) - this.context.getResources().getDimensionPixelSize(2131165568);
      j = (int)(i * ((btz)localObject1).Fjk.FjZ / ((btz)localObject1).Fjk.FjY);
      if (this.timeLineObject.FQo.Ety != 1) {
        break label464;
      }
      localObject2 = this.zbL.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = i;
      ((ViewGroup.LayoutParams)localObject2).height = j;
      this.zbL.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      af.dHO().b((btz)localObject1, this.zbL, -1, this.context.hashCode(), bf.GYG);
      this.zbL.setVisibility(0);
      this.zbL.setTag(this);
      this.contentView.setTag(this);
      this.zbI.setTag(this);
      this.zbJ.setTag(this);
      this.zbL.setOnClickListener(this.xLF.yAf);
      this.nym.c(this.zbL, this.xLF.zgH, this.xLF.zgp);
    }
    label1451:
    label1453:
    label1471:
    for (;;)
    {
      if (!this.xIq.dFR().dJF()) {
        break label1546;
      }
      if (this.zbF != null) {
        this.zbF.setVisibility(8);
      }
      if (this.zbG != null) {
        this.zbG.setVisibility(8);
      }
      this.zbQ.setVisibility(0);
      this.zbS.N(this.xIq);
      AppMethodBeat.o(100010);
      return;
      R(this.xIq);
      break;
      label458:
      localObject1 = null;
      break label147;
      label464:
      if ((this.timeLineObject.FQo.Ety == 5) || (this.timeLineObject.FQo.Ety == 15))
      {
        this.zbE.yFc.setVisibility(0);
        this.nym.c(this.zbE.yFf, this.xLF.zgH, this.xLF.zgp);
        Object localObject3 = this.zbE.yFc.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = i;
        ((ViewGroup.LayoutParams)localObject3).height = j;
        this.zbE.yFc.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.zbE.yFd.hf(i, j);
        this.zbE.yFd.setOnCompletionListener(new b.e()
        {
          public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
          {
            AppMethodBeat.i(100006);
            if ((paramAnonymousInt != -1) && (b.this.yJJ != null)) {
              b.this.yJJ.A(b.this.xIq.field_snsId, false);
            }
            AppMethodBeat.o(100006);
          }
        });
        this.zbE.yFd.setOnDecodeDurationListener(new b.f()
        {
          public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
          {
            AppMethodBeat.i(100007);
            ac.d("MicroMsg.CardAdDetailItemView", "onDecodeProgress:".concat(String.valueOf(paramAnonymousLong)));
            if ((b.this.yJJ != null) && (b.this.xIq != null))
            {
              b.this.yJJ.wP(b.this.xIq.field_snsId);
              b.this.yJJ.ah(b.this.xIq.field_snsId, 1000L * paramAnonymousLong);
              if (!b.this.yJJ.wM(b.this.xIq.field_snsId))
              {
                int i = (int)paramAnonymousb.dED();
                ac.i("MicroMsg.CardAdDetailItemView", "updatePlayStartTime, duration=".concat(String.valueOf(i)));
                b.this.yJJ.d(b.this.xIq.field_snsId, bs.Gn(), false);
                b.this.yJJ.e(b.this.xIq.field_snsId, i, false);
                b.this.yJJ.ag(b.this.xIq.field_snsId, b.this.xIq.field_snsId);
              }
            }
            AppMethodBeat.o(100007);
          }
        });
        long l = System.nanoTime();
        boolean bool = com.tencent.mm.plugin.sns.model.f.t((btz)localObject1);
        ac.i("MicroMsg.CardAdDetailItemView", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
        localObject3 = this.zbE;
        this.zbE.ddB = this.xIq.dMu();
        if (!bool) {
          if (((com.tencent.mm.plugin.sns.model.f)localObject2).w((btz)localObject1))
          {
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.setVisibility(0);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.fuE();
            label721:
            this.zbE.yFc.setVisibility(0);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFd.setTagObject(localObject3);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFf.setTag(this);
            this.contentView.setTag(this);
            this.zbI.setTag(this);
            this.zbJ.setTag(this);
            ((com.tencent.mm.plugin.sns.model.f)localObject2).a(this.xIq, (btz)localObject1, ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFd, this.context.hashCode(), 0, bf.GYG, true, true);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFd.start();
            this.zbU = true;
            if (this.yJJ == null) {
              continue;
            }
            localObject2 = com.tencent.mm.plugin.sns.model.an.jc(af.getAccSnsPath(), ((btz)localObject1).Id);
            localObject1 = q.i((btz)localObject1);
            if (!com.tencent.mm.vfs.i.eA((String)localObject2 + (String)localObject1)) {
              break label1453;
            }
            this.yJJ.B(this.xIq.field_snsId, true);
            label887:
            if (af.dHO().b(this.xIq, null) != 5) {
              break label1471;
            }
          }
        }
        for (bool = true;; bool = false)
        {
          this.yJJ.c(this.xIq.field_snsId, bool, false);
          break;
          if (((com.tencent.mm.plugin.sns.model.f)localObject2).b(this.xIq, null) == 5)
          {
            ((com.tencent.mm.plugin.sns.model.f)localObject2).A((btz)localObject1);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.setVisibility(0);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.fuE();
            break label721;
          }
          if (((com.tencent.mm.plugin.sns.model.f)localObject2).x((btz)localObject1))
          {
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setImageResource(2131234034);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setVisibility(0);
            break label721;
          }
          ((com.tencent.mm.plugin.sns.model.f)localObject2).y((btz)localObject1);
          ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setVisibility(0);
          ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
          ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setContentDescription(this.context.getResources().getString(2131761939));
          if (((com.tencent.mm.plugin.sns.model.f)localObject2).b(this.xIq, null) != 4) {
            break label721;
          }
          ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoJ.setVisibility(0);
          break label721;
          if (((com.tencent.mm.plugin.sns.model.f)localObject2).u((btz)localObject1))
          {
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setVisibility(0);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setContentDescription(this.context.getResources().getString(2131761939));
          }
          for (;;)
          {
            if (!((com.tencent.mm.plugin.sns.ui.an)localObject3).yFd.xDG.dEA()) {
              break label1451;
            }
            ac.d("MicroMsg.CardAdDetailItemView", "play video error " + ((btz)localObject1).Id + " " + ((btz)localObject1).Url + " " + ((btz)localObject1).Fjh);
            ((com.tencent.mm.plugin.sns.model.f)localObject2).y((btz)localObject1);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setVisibility(0);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
            ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setContentDescription(this.context.getResources().getString(2131761939));
            break;
            if (((com.tencent.mm.plugin.sns.model.f)localObject2).v((btz)localObject1))
            {
              ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.setVisibility(8);
            }
            else if (((com.tencent.mm.plugin.sns.model.f)localObject2).b(this.xIq, null) <= 5)
            {
              ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.setVisibility(8);
            }
            else
            {
              ((com.tencent.mm.plugin.sns.model.f)localObject2).y((btz)localObject1);
              ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setVisibility(0);
              ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
              ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setContentDescription(this.context.getResources().getString(2131761939));
            }
          }
          break label721;
          this.yJJ.B(this.xIq.field_snsId, false);
          break label887;
        }
      }
      else
      {
        ((com.tencent.mm.plugin.sns.model.f)localObject2).a(this.zbE.yFd, this.context.hashCode(), 0);
        this.zbE.yFh.setVisibility(8);
        this.zbE.yFd.setOnSightCompletionAction(null);
        this.zbE.yFd.setOnCompletionListener(null);
        this.zbE.yFd.setOnDecodeDurationListener(null);
      }
    }
    label1546:
    this.zbQ.setVisibility(8);
    label1555:
    AppMethodBeat.o(100010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.b
 * JD-Core Version:    0.7.0.1
 */