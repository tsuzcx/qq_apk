package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.voip.b.i;
import com.tencent.mm.plugin.voip.b.n;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.video.NewMovableVideoView;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.t;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class NewVoipVideoFragment
  extends VoipBaseFragment
{
  private View ChA;
  private ImageView ChB;
  private TextView ChC;
  private TextView ChD;
  private TextView ChE;
  private TextView ChF;
  private View ChG;
  private TextView ChH;
  private TextView ChI;
  private TextView ChJ;
  private RelativeLayout ChK;
  private Button ChL;
  private VoipSmallIconButton ChM;
  private VoipSmallIconButton ChN;
  private VoipSmallIconButton ChO;
  private VoipBigIconButton ChP;
  private VoipBigIconButton ChQ;
  private VoipBigIconButton ChR;
  private VoipBigIconButton ChS;
  private VoipBigIconButton ChT;
  private VoipBigIconButton ChU;
  private TextView ChV;
  private TextView ChW;
  private TextView ChX;
  private TextView ChY;
  private TextView ChZ;
  private VoIPRenderSurfaceView Chx;
  private VoIPRenderSurfaceView Chy;
  private ImageView Chz;
  private View.OnClickListener CiA;
  private View.OnClickListener CiB;
  private View.OnClickListener CiC;
  private View.OnClickListener CiD;
  private View.OnClickListener CiE;
  private View.OnClickListener CiF;
  private View.OnClickListener CiG;
  private View.OnClickListener CiH;
  private Runnable CiI;
  private TextView Cia;
  private e Cib;
  private Button Cic;
  private Button Cid;
  private boolean Cie;
  private int Cif;
  private int Cig;
  private int Cih;
  private int Cii;
  private int Cij;
  private boolean Cik;
  private boolean Cil;
  public long Cim;
  private a Cin;
  public int Cio;
  public int Cip;
  private int Ciq;
  private int Cir;
  private av Cis;
  private boolean Cit;
  private boolean Ciu;
  private boolean Civ;
  private View.OnClickListener Ciw;
  private View.OnClickListener Cix;
  private View.OnClickListener Ciy;
  private View.OnClickListener Ciz;
  private boolean Cli;
  private TextView OdK;
  private boolean OdL;
  private PowerManager.WakeLock gKs;
  private Timer mTimer;
  private long mtj;
  private boolean oXj;
  private int oZC;
  private boolean oZE;
  private Runnable pVz;
  private TextView uVp;
  private Bitmap xBb;
  
  public NewVoipVideoFragment()
  {
    AppMethodBeat.i(216470);
    this.Cib = null;
    this.Cic = null;
    this.Cid = null;
    this.Cie = false;
    com.tencent.mm.plugin.voip.b.h localh = com.tencent.mm.plugin.voip.b.h.Cls;
    this.Cli = com.tencent.mm.plugin.voip.b.h.ezH();
    localh = com.tencent.mm.plugin.voip.b.h.Cls;
    this.OdL = com.tencent.mm.plugin.voip.b.h.ezG();
    this.Cij = 0;
    this.Cik = false;
    this.oZE = false;
    this.oXj = false;
    this.Cim = 0L;
    this.xBb = null;
    this.Cio = 0;
    this.Cip = 0;
    this.Ciq = 0;
    this.mtj = 0L;
    this.Cir = 0;
    this.Cis = null;
    this.Cit = false;
    this.Ciu = false;
    this.Civ = false;
    this.Ciw = new NewVoipVideoFragment.1(this);
    this.Cix = new NewVoipVideoFragment.12(this);
    this.Ciy = new NewVoipVideoFragment.13(this);
    this.Ciz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216460);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
        if ((ay.isWifi(NewVoipVideoFragment.this.getActivity())) || (s.ewU())) {
          NewVoipVideoFragment.c(NewVoipVideoFragment.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(216460);
          return;
          com.tencent.mm.ui.base.h.a(NewVoipVideoFragment.this.getActivity(), 2131764898, 2131764899, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(216458);
              s.ewT();
              NewVoipVideoFragment.c(NewVoipVideoFragment.this);
              AppMethodBeat.o(216458);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(216459);
              NewVoipVideoFragment.d(NewVoipVideoFragment.this);
              AppMethodBeat.o(216459);
            }
          });
        }
      }
    };
    this.CiA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216463);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
        if ((ay.isWifi(NewVoipVideoFragment.this.getActivity())) || ((s.ewU()) && (!ay.is2G(NewVoipVideoFragment.this.getActivity())))) {
          NewVoipVideoFragment.e(NewVoipVideoFragment.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(216463);
          return;
          com.tencent.mm.ui.base.h.a(NewVoipVideoFragment.this.getActivity(), 2131764898, 2131764899, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(216461);
              if (!ay.is2G(NewVoipVideoFragment.this.getActivity())) {
                s.ewT();
              }
              NewVoipVideoFragment.e(NewVoipVideoFragment.this);
              AppMethodBeat.o(216461);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(216462);
              NewVoipVideoFragment.d(NewVoipVideoFragment.this);
              AppMethodBeat.o(216462);
            }
          });
        }
      }
    };
    this.CiB = new NewVoipVideoFragment.16(this);
    this.CiC = new NewVoipVideoFragment.17(this);
    this.CiD = new NewVoipVideoFragment.18(this);
    this.CiE = new NewVoipVideoFragment.19(this);
    this.CiF = new NewVoipVideoFragment.2(this);
    this.CiG = new NewVoipVideoFragment.3(this);
    this.CiH = new NewVoipVideoFragment.6(this);
    this.CiI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216450);
        ad.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
        NewVoipVideoFragment.q(NewVoipVideoFragment.this);
        if ((NewVoipVideoFragment.this.getActivity() == null) || (NewVoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(216450);
          return;
        }
        if (NewVoipVideoFragment.r(NewVoipVideoFragment.this) > 0)
        {
          AppMethodBeat.o(216450);
          return;
        }
        NewVoipVideoFragment.o(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.s(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.t(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.a(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.b(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.d(NewVoipVideoFragment.this, false);
        AppMethodBeat.o(216450);
      }
    };
    this.pVz = new NewVoipVideoFragment.8(this);
    AppMethodBeat.o(216470);
  }
  
  private void Uy(int paramInt)
  {
    AppMethodBeat.i(216487);
    this.Cjk.eyY();
    this.ChP.setEnabled(false);
    this.ChT.setEnabled(false);
    this.ChS.setEnabled(false);
    this.ChR.setEnabled(false);
    this.ChQ.setEnabled(false);
    this.ChO.setEnabled(false);
    this.ChU.setEnabled(false);
    this.ChN.setEnabled(false);
    this.ChM.setEnabled(false);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.Cjj != null) {
        this.Cjj.ax(true, false);
      }
      AppMethodBeat.o(216487);
      return;
      this.ChI.setVisibility(0);
      this.ChI.setText(2131764897);
    }
  }
  
  private void aUi()
  {
    AppMethodBeat.i(216488);
    if ((this.mTimer == null) || (this.oZE))
    {
      AppMethodBeat.o(216488);
      return;
    }
    if (-1L == this.CiS) {
      this.CiS = bt.aQJ();
    }
    this.Cim = this.CiS;
    this.oZE = true;
    TimerTask local9 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(216453);
        NewVoipVideoFragment.this.jwD.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(216452);
            String str = NewVoipVideoFragment.sm(bt.rM(NewVoipVideoFragment.this.CiS));
            NewVoipVideoFragment.t(NewVoipVideoFragment.this).setText(str);
            NewVoipVideoFragment.u(NewVoipVideoFragment.this);
            AppMethodBeat.o(216452);
          }
        });
        AppMethodBeat.o(216453);
      }
    };
    this.mTimer.schedule(local9, 1000L, 1000L);
    this.Cis = new av("VoipVideoFragment_cpuStatThread", new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(216454);
        if (NewVoipVideoFragment.v(NewVoipVideoFragment.this))
        {
          NewVoipVideoFragment.w(NewVoipVideoFragment.this);
          AppMethodBeat.o(216454);
          return true;
        }
        AppMethodBeat.o(216454);
        return false;
      }
    }, true);
    this.Cit = true;
    this.Cis.az(1000L, 1000L);
    AppMethodBeat.o(216488);
  }
  
  private void eyL()
  {
    AppMethodBeat.i(216473);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
    this.Cij += 1;
    this.jwD.postDelayed(this.CiI, 10000L);
    AppMethodBeat.o(216473);
  }
  
  private void eyO()
  {
    AppMethodBeat.i(216483);
    this.Chx.setVisibility(0);
    if (this.Cjg != null) {
      eyX();
    }
    this.ChA.setVisibility(0);
    this.ChC.setVisibility(0);
    if ((am.aSQ(this.fGM)) && (!bt.ai(this.ChD.getText()))) {
      this.ChD.setVisibility(0);
    }
    for (;;)
    {
      this.ChE.setText(2131764876);
      this.ChG.setVisibility(0);
      this.ChB.setVisibility(0);
      this.Cjk.a(this.ChF, Cje);
      this.ChU.setVisibility(8);
      this.ChT.setVisibility(8);
      this.ChP.setVisibility(8);
      this.ChS.setVisibility(8);
      this.ChR.setVisibility(0);
      this.ChO.setVisibility(0);
      this.ChQ.setVisibility(0);
      this.ChN.setVisibility(8);
      if (this.Cil) {
        this.ChM.setVisibility(0);
      }
      this.ChJ.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.euM().BZf != null)
      {
        this.ChJ.setVisibility(0);
        this.ChJ.setText(com.tencent.mm.plugin.voip.c.euM().BZf);
      }
      if (ae.gcE.fYe == 1)
      {
        this.Chz.setVisibility(0);
        this.Chx.setVisibility(4);
      }
      AppMethodBeat.o(216483);
      return;
      this.ChD.setVisibility(8);
    }
  }
  
  private void eyP()
  {
    AppMethodBeat.i(216484);
    this.ChG.setVisibility(0);
    this.Chx.setVisibility(0);
    this.ChE.setText(2131764874);
    if ((am.aSQ(this.fGM)) && (!bt.ai(this.ChD.getText()))) {
      this.ChD.setVisibility(0);
    }
    for (;;)
    {
      this.Cjf.setVisibility(8);
      this.ChI.setVisibility(8);
      this.ChJ.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.euM().BZf != null)
      {
        this.ChJ.setVisibility(0);
        this.ChJ.setText(com.tencent.mm.plugin.voip.c.euM().BZf);
      }
      this.Cjk.a(this.ChF, Cje);
      this.ChU.setVisibility(8);
      this.ChT.setVisibility(8);
      this.ChP.setVisibility(0);
      this.ChS.setVisibility(8);
      this.ChR.setVisibility(8);
      this.ChO.setVisibility(8);
      this.ChQ.setVisibility(8);
      this.ChN.setVisibility(0);
      this.ChM.setVisibility(8);
      AppMethodBeat.o(216484);
      return;
      this.ChD.setVisibility(8);
    }
  }
  
  private void eyQ()
  {
    boolean bool2 = true;
    AppMethodBeat.i(216485);
    if (this.Cjg != null) {
      this.Cjg.setVisibility(8);
    }
    if (this.Chy == null)
    {
      AppMethodBeat.o(216485);
      return;
    }
    if (this.Chy.getVisibility() == 0)
    {
      AppMethodBeat.o(216485);
      return;
    }
    label85:
    Point localPoint;
    if (this.BYH) {
      if (!this.Cik)
      {
        bool1 = true;
        this.Cik = bool1;
        if (this.Cik) {
          break label433;
        }
        bool1 = true;
        localPoint = tu(bool1);
        this.Chy.iy(localPoint.x, localPoint.y);
        if (ac.iPB)
        {
          this.ChV.setVisibility(0);
          this.ChW.setVisibility(0);
          this.ChX.setVisibility(0);
          this.ChY.setVisibility(0);
          this.ChZ.setVisibility(0);
          this.Cia.setVisibility(0);
          this.OdK.setVisibility(0);
        }
        this.ChA.setVisibility(8);
        this.Chx.setVisibility(0);
        this.Chy.setVisibility(0);
        this.ChH.setVisibility(0);
        this.ChL.setVisibility(0);
        this.ChU.setVisibility(0);
        this.ChT.setVisibility(0);
        this.ChP.setVisibility(8);
        this.ChS.setVisibility(0);
        this.ChR.setVisibility(8);
        this.ChO.setVisibility(8);
        this.ChQ.setVisibility(8);
        this.ChN.setVisibility(8);
        this.ChM.setVisibility(8);
        ((c)this.CiR.get()).te(this.Cik);
        ad.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", new Object[] { Integer.valueOf(this.Cio) });
        if (this.Cik) {
          break label460;
        }
      }
    }
    label433:
    label460:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPoint = tu(bool1);
      ((NewMovableVideoView)this.Chy).iw(localPoint.x, localPoint.y);
      aUi();
      if (aj.fkD().getBoolean("voipfaceDebug", false))
      {
        this.Cic.setVisibility(0);
        this.Cid.setVisibility(0);
      }
      eyL();
      if (this.Cjh == 4102) {
        iv(2131764783, 10000);
      }
      AppMethodBeat.o(216485);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label85;
      if (!this.Cik) {}
      for (bool1 = true;; bool1 = false)
      {
        this.Cik = bool1;
        break;
      }
    }
  }
  
  private void eyR()
  {
    AppMethodBeat.i(216486);
    this.ChE.setText(2131764949);
    this.Cjk.a(this.ChF, Cje);
    AppMethodBeat.o(216486);
  }
  
  private void eyS()
  {
    AppMethodBeat.i(216489);
    View.OnClickListener local11 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(216455);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.plugin.report.service.g.yhR.f(11079, new Object[] { Integer.valueOf(4) });
        if ((!NewVoipVideoFragment.k(NewVoipVideoFragment.this)) && (NewVoipVideoFragment.this.CiR.get() != null)) {
          NewVoipVideoFragment.o(NewVoipVideoFragment.this).getVisibility();
        }
        int i;
        if (NewVoipVideoFragment.o(NewVoipVideoFragment.this).getVisibility() == 0)
        {
          i = 4;
          if (i != 0) {
            break label305;
          }
        }
        label305:
        for (int j = 0;; j = 8)
        {
          NewVoipVideoFragment.o(NewVoipVideoFragment.this).setVisibility(j);
          NewVoipVideoFragment.s(NewVoipVideoFragment.this).setVisibility(j);
          NewVoipVideoFragment.t(NewVoipVideoFragment.this).setVisibility(j);
          NewVoipVideoFragment.b(NewVoipVideoFragment.this).setVisibility(j);
          NewVoipVideoFragment.a(NewVoipVideoFragment.this).setVisibility(j);
          paramAnonymousView = NewVoipVideoFragment.this;
          if (j == 0) {
            bool = true;
          }
          NewVoipVideoFragment.d(paramAnonymousView, bool);
          if (ac.iPB)
          {
            NewVoipVideoFragment.x(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.y(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.z(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.A(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.B(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.C(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.D(NewVoipVideoFragment.this).setVisibility(j);
          }
          if (i == 0) {
            NewVoipVideoFragment.p(NewVoipVideoFragment.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(216455);
          return;
          i = 0;
          break;
        }
      }
    };
    this.lPT.setOnClickListener(local11);
    AppMethodBeat.o(216489);
  }
  
  private void ts(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(216475);
    if (!this.Civ)
    {
      if (!paramBoolean) {
        break label115;
      }
      ((c)this.CiR.get()).a(this.Chy, 1);
      ((c)this.CiR.get()).a(this.Chx, 0);
    }
    for (;;)
    {
      c localc = (c)this.CiR.get();
      paramBoolean = bool;
      if (260 != this.mStatus)
      {
        paramBoolean = bool;
        if (6 != this.mStatus) {
          paramBoolean = true;
        }
      }
      localc.au(true, paramBoolean);
      this.Civ = true;
      AppMethodBeat.o(216475);
      return;
      label115:
      ((c)this.CiR.get()).a(this.Chy, 0);
      ((c)this.CiR.get()).a(this.Chx, 1);
    }
  }
  
  private Point tu(boolean paramBoolean)
  {
    AppMethodBeat.i(216491);
    int i = (int)(getActivity().getWindowManager().getDefaultDisplay().getHeight() / 5.0D);
    float f = i;
    com.tencent.mm.plugin.voip.c.euM();
    Point localPoint = new Point((int)(f * u.tp(paramBoolean)), i);
    AppMethodBeat.o(216491);
    return localPoint;
  }
  
  public final void Uv(int paramInt)
  {
    this.Cig += 1;
    if (paramInt > 0) {
      this.Cif += 1;
    }
  }
  
  public final void Uw(int paramInt)
  {
    this.Cio = paramInt;
  }
  
  public final void Ux(int paramInt)
  {
    this.Cip = paramInt;
  }
  
  protected final void aDI(String paramString)
  {
    AppMethodBeat.i(216478);
    if (this.ChJ != null)
    {
      this.ChJ.setVisibility(0);
      this.ChJ.setText(paramString);
    }
    AppMethodBeat.o(216478);
  }
  
  public final void eyJ()
  {
    this.oZC += 1;
  }
  
  protected final void eyM()
  {
    AppMethodBeat.i(216481);
    if (this.uVp != null)
    {
      this.uVp.clearAnimation();
      this.uVp.setVisibility(8);
    }
    AppMethodBeat.o(216481);
  }
  
  public final void eyN()
  {
    AppMethodBeat.i(216482);
    VoIPRenderSurfaceView localVoIPRenderSurfaceView = this.Chx;
    ad.i("RenderView", "new size from resource Helper w %s * h  %s", new Object[] { Integer.valueOf(com.tencent.mm.cc.a.ip(localVoIPRenderSurfaceView.getContext())), Integer.valueOf(com.tencent.mm.cc.a.iq(localVoIPRenderSurfaceView.getContext())) });
    int i = com.tencent.mm.cc.a.ip(localVoIPRenderSurfaceView.getContext());
    int j = com.tencent.mm.cc.a.iq(localVoIPRenderSurfaceView.getContext());
    float f;
    Object localObject;
    if (i > j)
    {
      f = i / j;
      if (f <= 1.333333F) {
        break label199;
      }
      localObject = new RelativeLayout.LayoutParams(-1, -1);
    }
    for (;;)
    {
      localVoIPRenderSurfaceView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.Chy != null)
      {
        localObject = (NewMovableVideoView)this.Chy;
        ad.i("MicroMsg.MovableVideoView", "refrsh view %s, %s", new Object[] { Integer.valueOf(((NewMovableVideoView)localObject).mWidth), Integer.valueOf(((NewMovableVideoView)localObject).Cna) });
        ((NewMovableVideoView)localObject).mScreenWidth = 0;
        ((NewMovableVideoView)localObject).iw(((NewMovableVideoView)localObject).mWidth, ((NewMovableVideoView)localObject).Cna);
      }
      AppMethodBeat.o(216482);
      return;
      f = j / i;
      break;
      label199:
      localObject = new RelativeLayout.LayoutParams(j * 9 / 16, j);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
    }
  }
  
  public final void iu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216474);
    super.iu(paramInt1, paramInt2);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + com.tencent.mm.plugin.voip.b.l.UK(paramInt2));
    if (this.lPT == null)
    {
      ad.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
      AppMethodBeat.o(216474);
      return;
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      paramInt1 = 1;
      for (;;)
      {
        if ((ae.gcE.fYe == 1) && (paramInt1 != 0)) {
          this.Chz.setVisibility(8);
        }
        AppMethodBeat.o(216474);
        return;
        this.Ciu = true;
        ts(true);
        eyP();
        paramInt1 = 1;
        continue;
        this.Ciu = true;
        ts(true);
        eyO();
        paramInt1 = 0;
        continue;
        eyS();
        if (this.Ciu)
        {
          ((c)this.CiR.get()).evk();
          i.tB(false);
          this.Ciu = false;
        }
        for (;;)
        {
          eyQ();
          paramInt1 = 1;
          break;
          ts(false);
        }
        Uy(paramInt1);
        paramInt1 = 1;
      }
      eyR();
    }
  }
  
  protected final void iv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216479);
    if (this.ChI == null)
    {
      AppMethodBeat.o(216479);
      return;
    }
    this.ChI.setText(paramInt1);
    this.ChI.setVisibility(0);
    this.ChI.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.ChI.setBackgroundResource(2131234591);
    this.ChI.setCompoundDrawables(null, null, null, null);
    this.ChI.setCompoundDrawablePadding(0);
    this.jwD.removeCallbacks(this.pVz);
    if (-1 != paramInt2) {
      this.jwD.postDelayed(this.pVz, paramInt2);
    }
    AppMethodBeat.o(216479);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(216471);
    this.lPT = ((RelativeLayout)paramLayoutInflater.inflate(2131495882, paramViewGroup, false));
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)this.lPT.findViewById(2131304205)).setPadding(0, 0, 0, BackwardSupportUtil.b.g(getActivity(), 40.0F));
    }
    this.Cjf = ((ImageView)this.lPT.findViewById(2131306556));
    this.Cjg = ((ImageView)this.lPT.findViewById(2131306592));
    this.ChK = ((RelativeLayout)this.lPT.findViewById(2131301467));
    this.Chx = ((VoIPRenderSurfaceView)this.lPT.findViewById(2131297220));
    this.Chx.iz(mScreenWidth, mScreenHeight);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "steve: onCreateView!");
    this.ChU = ((VoipBigIconButton)this.lPT.findViewById(2131306588));
    this.ChU.setOnClickListener(this.CiH);
    this.ChT = ((VoipBigIconButton)this.lPT.findViewById(2131306604));
    this.ChT.setOnClickListener(this.Cix);
    this.ChP = ((VoipBigIconButton)this.lPT.findViewById(2131306557));
    this.ChP.setOnClickListener(this.CiC);
    this.ChS = ((VoipBigIconButton)this.lPT.findViewById(2131306574));
    this.ChS.setOnClickListener(this.Ciw);
    this.ChR = ((VoipBigIconButton)this.lPT.findViewById(2131306553));
    this.ChR.setOnClickListener(this.CiA);
    this.ChO = ((VoipSmallIconButton)this.lPT.findViewById(2131306554));
    this.ChO.setOnClickListener(this.Ciz);
    this.ChQ = ((VoipBigIconButton)this.lPT.findViewById(2131306585));
    this.ChQ.setOnClickListener(this.CiB);
    this.ChN = ((VoipSmallIconButton)this.lPT.findViewById(2131306589));
    this.ChN.setOnClickListener(this.Ciy);
    if (n.II("VOIPBlockIgnoreButton") == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.Cil = bool;
      this.ChM = ((VoipSmallIconButton)this.lPT.findViewById(2131306575));
      this.ChM.setOnClickListener(this.CiE);
      if (!this.Cil) {
        this.ChM.setVisibility(8);
      }
      this.ChH = ((TextView)this.lPT.findViewById(2131306605));
      this.ChA = this.lPT.findViewById(2131306598);
      this.ChB = ((ImageView)this.lPT.findViewById(2131306597));
      a.b.a(this.ChB, this.fGM, 0.0588235F, true);
      this.ChC = ((TextView)this.lPT.findViewById(2131306599));
      this.ChD = ((TextView)this.lPT.findViewById(2131306601));
      this.ChE = ((TextView)this.lPT.findViewById(2131306594));
      this.ChF = ((TextView)this.lPT.findViewById(2131306596));
      this.ChG = this.lPT.findViewById(2131306595);
      t(this.ChF);
      this.ChI = ((TextView)this.lPT.findViewById(2131306593));
      this.ChJ = ((TextView)this.lPT.findViewById(2131306603));
      this.ChL = ((Button)this.lPT.findViewById(2131297592));
      this.uVp = ((TextView)this.lPT.findViewById(2131306581));
      this.Chz = ((ImageView)this.lPT.findViewById(2131300320));
      paramLayoutInflater = com.tencent.mm.ak.c.a(this.fGM, false, -1, null);
      this.Chz.setImageBitmap(com.tencent.mm.sdk.platformtools.g.l(paramLayoutInflater, 10));
      if (ac.iPB)
      {
        this.ChV = ((TextView)this.lPT.findViewById(2131306558));
        this.ChW = ((TextView)this.lPT.findViewById(2131306586));
        this.ChX = ((TextView)this.lPT.findViewById(2131306583));
        this.ChY = ((TextView)this.lPT.findViewById(2131306587));
        this.ChZ = ((TextView)this.lPT.findViewById(2131306584));
        this.Cia = ((TextView)this.lPT.findViewById(2131299493));
        this.OdK = ((TextView)this.lPT.findViewById(2131306029));
      }
      this.Cic = ((Button)this.lPT.findViewById(2131306572));
      this.Cid = ((Button)this.lPT.findViewById(2131306573));
      this.Cic.setVisibility(8);
      this.Cid.setVisibility(8);
      this.Cic.setOnClickListener(this.CiF);
      this.Cid.setOnClickListener(this.CiG);
      this.Cib = new e(getActivity());
      this.lPT.addView(this.Cib);
      this.Cib.setVisibility(8);
      this.ChL.setOnClickListener(this.CiD);
      int i = t.jW(getActivity());
      ad.d("MicroMsg.Voip.VoipVideoFragment", "statusHeight: ".concat(String.valueOf(i)));
      av(this.ChL, i);
      av(this.lPT.findViewById(2131306591), i);
      av(this.ChA, i);
      this.Cig = 0;
      this.Cif = 0;
      this.oZC = 0;
      this.Cih = 0;
      this.Cii = 0;
      this.Ciq = 0;
      this.Cir = 0;
      paramLayoutInflater = (WindowManager)getActivity().getSystemService("window");
      i = paramLayoutInflater.getDefaultDisplay().getHeight() / 5;
      int j = paramLayoutInflater.getDefaultDisplay().getWidth() * i / paramLayoutInflater.getDefaultDisplay().getHeight();
      this.Chy = new NewMovableVideoView(aj.getContext());
      ((NewMovableVideoView)this.Chy).iw(j, i);
      this.Chy.setVisibility(4);
      this.Chx.setVisibility(0);
      ad.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
      this.lPT.addView(this.Chy);
      this.Chy.setOnClickListener(new NewVoipVideoFragment.4(this));
      paramLayoutInflater = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.fGM);
      this.ChC.setText(k.b(getActivity(), v.b(paramLayoutInflater, this.fGM), this.ChC.getTextSize()));
      paramLayoutInflater = com.tencent.mm.openim.room.a.a.H(paramLayoutInflater);
      if (!bt.isNullOrNil(paramLayoutInflater)) {
        this.ChD.setText(paramLayoutInflater);
      }
      if (this.BYH) {
        this.jwD.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(216448);
            NewVoipVideoFragment.m(NewVoipVideoFragment.this).setText(2131764874);
            NewVoipVideoFragment.this.Cjk.a(NewVoipVideoFragment.n(NewVoipVideoFragment.this), VoipBaseFragment.Cje);
            AppMethodBeat.o(216448);
          }
        }, 2000L);
      }
      this.mTimer = new Timer("VoIP_video_talking_count");
      ad.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", new Object[] { Integer.valueOf(this.Cip) });
      this.oXj = true;
      ((c)this.CiR.get()).evl();
      iu(0, this.mStatus);
      this.gKs = ((PowerManager)aj.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipVideoFragment");
      this.gKs.acquire();
      ad.i("MicroMsg.Voip.VoipVideoFragment", "acquire wakelock");
      paramLayoutInflater = this.lPT;
      AppMethodBeat.o(216471);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(216472);
    this.oZE = false;
    ad.i("MicroMsg.Voip.VoipVideoFragment", "onDestory");
    super.onDestroy();
    if ((this.gKs != null) && (this.gKs.isHeld()))
    {
      ad.i("MicroMsg.Voip.VoipVideoFragment", "release waklock");
      this.gKs.release();
    }
    AppMethodBeat.o(216472);
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(216477);
    super.onDestroyView();
    if (this.Chx != null)
    {
      this.Chx.setVisibility(8);
      this.Chx = null;
    }
    AppMethodBeat.o(216477);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(216490);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "onDetach");
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    if (this.Cis != null) {
      this.Cis.stopTimer();
    }
    this.Cit = false;
    super.onDetach();
    AppMethodBeat.o(216490);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt) {}
  
  protected final void tt(boolean paramBoolean)
  {
    AppMethodBeat.i(216480);
    if (this.uVp != null)
    {
      if (!paramBoolean) {
        break label49;
      }
      this.uVp.setText(2131764892);
    }
    for (;;)
    {
      this.uVp.clearAnimation();
      this.uVp.setVisibility(0);
      AppMethodBeat.o(216480);
      return;
      label49:
      this.uVp.setText(2131764891);
    }
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(216476);
    ad.m("MicroMsg.Voip.VoipVideoFragment", "unit should not be allow in foreground", new Object[0]);
    if ((this.Chx != null) && (this.CiR.get() != null)) {
      this.Chx.release();
    }
    if (this.CiR.get() != null)
    {
      ((c)this.CiR.get()).a(this.Chx);
      ((c)this.CiR.get()).a(this.Chy);
    }
    if (this.Chy != null)
    {
      this.Chy.release();
      this.Chy.setVisibility(4);
      this.Chy = null;
    }
    if (this.Cin != null)
    {
      this.Cin.cancel();
      this.Cin = null;
    }
    super.uninit();
    AppMethodBeat.o(216476);
  }
  
  public final class a
    extends com.tencent.e.i.b
  {
    public final String getKey()
    {
      return "MicroMsg.Voip.VoipVideoFragment#ShowBlurBackgroundRunnable";
    }
    
    public final void run()
    {
      AppMethodBeat.i(216469);
      ad.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
      final Bitmap localBitmap = NewVoipVideoFragment.E(this.CiJ);
      this.CiJ.jwD.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(216468);
          if (NewVoipVideoFragment.a.this.CiJ.Cjf != null) {
            NewVoipVideoFragment.a.this.CiJ.Cjf.setBackgroundDrawable(new BitmapDrawable(localBitmap));
          }
          NewVoipVideoFragment.F(NewVoipVideoFragment.a.this.CiJ);
          AppMethodBeat.o(216468);
        }
      });
      AppMethodBeat.o(216469);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment
 * JD-Core Version:    0.7.0.1
 */