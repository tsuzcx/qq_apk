package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
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
import com.tencent.mm.media.g.d;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.voip.b.n;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.GLTextureView;
import com.tencent.mm.plugin.voip.video.GLTextureView.i;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlRender.b;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.plugin.voip.widget.VoIPVideoView;
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
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class VoipVideoFragment
  extends VoipBaseFragment
{
  public int BZu;
  public int BZv;
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
  public int Cio;
  public int Cip;
  private int Ciq;
  private int Cir;
  private av Cis;
  private boolean Cit;
  private View.OnClickListener Ciw;
  private View.OnClickListener Cix;
  private View.OnClickListener Ciy;
  private View.OnClickListener Ciz;
  private OpenGlView CjU;
  private OpenGlView CjV;
  private OpenGlRender CjW;
  private OpenGlRender CjX;
  private VoIPVideoView CjY;
  private a CjZ;
  private d Cka;
  int Ckb;
  private PowerManager.WakeLock gKs;
  private Timer mTimer;
  private long mtj;
  private CaptureView oXg;
  private boolean oXj;
  private int oZC;
  private boolean oZE;
  private Runnable pVz;
  private SurfaceTexture surfaceTexture;
  private TextView uVp;
  Bitmap wdv;
  int[] whe;
  private Bitmap xBb;
  
  public VoipVideoFragment()
  {
    AppMethodBeat.i(115420);
    this.Cib = null;
    this.Cic = null;
    this.Cid = null;
    this.Cie = false;
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
    this.BZu = 0;
    this.BZv = 0;
    this.surfaceTexture = null;
    this.Ciw = new VoipVideoFragment.1(this);
    this.Cix = new VoipVideoFragment.12(this);
    this.Ciy = new VoipVideoFragment.15(this);
    this.Ciz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115410);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
        if ((ay.isWifi(VoipVideoFragment.this.getActivity())) || (s.ewU())) {
          VoipVideoFragment.c(VoipVideoFragment.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115410);
          return;
          h.a(VoipVideoFragment.this.getActivity(), 2131764898, 2131764899, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(115408);
              s.ewT();
              VoipVideoFragment.c(VoipVideoFragment.this);
              AppMethodBeat.o(115408);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(115409);
              VoipVideoFragment.d(VoipVideoFragment.this);
              AppMethodBeat.o(115409);
            }
          });
        }
      }
    };
    this.CiA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115413);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
        if ((ay.isWifi(VoipVideoFragment.this.getActivity())) || ((s.ewU()) && (!ay.is2G(VoipVideoFragment.this.getActivity())))) {
          VoipVideoFragment.e(VoipVideoFragment.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115413);
          return;
          h.a(VoipVideoFragment.this.getActivity(), 2131764898, 2131764899, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(115411);
              if (!ay.is2G(VoipVideoFragment.this.getActivity())) {
                s.ewT();
              }
              VoipVideoFragment.e(VoipVideoFragment.this);
              AppMethodBeat.o(115411);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(115412);
              VoipVideoFragment.d(VoipVideoFragment.this);
              AppMethodBeat.o(115412);
            }
          });
        }
      }
    };
    this.CiB = new VoipVideoFragment.18(this);
    this.CiC = new VoipVideoFragment.19(this);
    this.CiD = new VoipVideoFragment.20(this);
    this.CiE = new VoipVideoFragment.21(this);
    this.CiF = new VoipVideoFragment.2(this);
    this.CiG = new VoipVideoFragment.3(this);
    this.CiH = new VoipVideoFragment.8(this);
    this.CiI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115403);
        ad.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
        VoipVideoFragment.q(VoipVideoFragment.this);
        if ((VoipVideoFragment.this.getActivity() == null) || (VoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(115403);
          return;
        }
        if (VoipVideoFragment.r(VoipVideoFragment.this) > 0)
        {
          AppMethodBeat.o(115403);
          return;
        }
        VoipVideoFragment.o(VoipVideoFragment.this).setVisibility(8);
        VoipVideoFragment.s(VoipVideoFragment.this).setVisibility(8);
        VoipVideoFragment.t(VoipVideoFragment.this).setVisibility(8);
        VoipVideoFragment.a(VoipVideoFragment.this).setVisibility(8);
        VoipVideoFragment.b(VoipVideoFragment.this).setVisibility(8);
        VoipVideoFragment.d(VoipVideoFragment.this, false);
        AppMethodBeat.o(115403);
      }
    };
    this.pVz = new VoipVideoFragment.10(this);
    this.whe = null;
    this.Ckb = 0;
    this.wdv = null;
    AppMethodBeat.o(115420);
  }
  
  private void Uy(int paramInt)
  {
    AppMethodBeat.i(115448);
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
      AppMethodBeat.o(115448);
      return;
      this.ChI.setVisibility(0);
      this.ChI.setText(2131764897);
    }
  }
  
  private void aUi()
  {
    AppMethodBeat.i(115449);
    if ((this.mTimer == null) || (this.oZE))
    {
      AppMethodBeat.o(115449);
      return;
    }
    if (-1L == this.CiS) {
      this.CiS = bt.aQJ();
    }
    this.Cim = this.CiS;
    this.oZE = true;
    TimerTask local11 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(216524);
        VoipVideoFragment.this.jwD.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(216523);
            String str = VoipVideoFragment.sm(bt.rM(VoipVideoFragment.this.CiS));
            VoipVideoFragment.t(VoipVideoFragment.this).setText(str);
            VoipVideoFragment.u(VoipVideoFragment.this);
            AppMethodBeat.o(216523);
          }
        });
        AppMethodBeat.o(216524);
      }
    };
    this.mTimer.schedule(local11, 1000L, 1000L);
    this.Cis = new av("VoipVideoFragment_cpuStatThread", new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(216525);
        if (VoipVideoFragment.v(VoipVideoFragment.this))
        {
          VoipVideoFragment.w(VoipVideoFragment.this);
          AppMethodBeat.o(216525);
          return true;
        }
        AppMethodBeat.o(216525);
        return false;
      }
    }, true);
    this.Cit = true;
    this.Cis.az(1000L, 1000L);
    AppMethodBeat.o(115449);
  }
  
  private void b(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115451);
    if ((this.lPT == null) || (paramCaptureView == null))
    {
      AppMethodBeat.o(115451);
      return;
    }
    if ((paramCaptureView.getParent() != null) && ((paramCaptureView.getParent() instanceof ViewGroup))) {
      ((ViewGroup)this.oXg.getParent()).removeView(this.oXg);
    }
    this.lPT.removeView(this.oXg);
    this.oXg = null;
    if (paramCaptureView.getParent() != null) {
      ((ViewGroup)paramCaptureView.getParent()).removeAllViews();
    }
    this.oXg = paramCaptureView;
    this.lPT.addView(paramCaptureView, new RelativeLayout.LayoutParams(1, 1));
    this.oXg.setVisibility(0);
    this.oXg.setAlpha(0.0F);
    ad.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView added");
    AppMethodBeat.o(115451);
  }
  
  private void eyL()
  {
    AppMethodBeat.i(115427);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
    this.Cij += 1;
    this.jwD.postDelayed(this.CiI, 10000L);
    AppMethodBeat.o(115427);
  }
  
  private void eyO()
  {
    AppMethodBeat.i(115438);
    this.CjU.setVisibility(0);
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
        this.CjU.setVisibility(4);
      }
      AppMethodBeat.o(115438);
      return;
      this.ChD.setVisibility(8);
    }
  }
  
  private void eyP()
  {
    AppMethodBeat.i(115439);
    this.ChG.setVisibility(0);
    this.CjU.setVisibility(0);
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
      AppMethodBeat.o(115439);
      return;
      this.ChD.setVisibility(8);
    }
  }
  
  private void eyQ()
  {
    boolean bool2 = true;
    AppMethodBeat.i(115440);
    if (this.Cjg != null) {
      this.Cjg.setVisibility(8);
    }
    if (!this.CjV.Cok)
    {
      AppMethodBeat.o(115440);
      return;
    }
    this.CjV.tG(false);
    label79:
    Point localPoint;
    if (this.BYH) {
      if (!this.Cik)
      {
        bool1 = true;
        this.Cik = bool1;
        if (this.Cik) {
          break label408;
        }
        bool1 = true;
        localPoint = tu(bool1);
        this.CjV.iy(localPoint.x, localPoint.y);
        if (ac.iPB)
        {
          this.ChV.setVisibility(0);
          this.ChW.setVisibility(0);
          this.ChX.setVisibility(0);
          this.ChY.setVisibility(0);
          this.ChZ.setVisibility(0);
          this.Cia.setVisibility(0);
        }
        this.ChA.setVisibility(8);
        this.CjU.setVisibility(0);
        this.CjV.setVisibility(0);
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
        setHWDecMode(this.Cio);
        ad.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", new Object[] { Integer.valueOf(this.Cio) });
        if (this.Cik) {
          break label444;
        }
      }
    }
    label408:
    label444:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPoint = tu(bool1);
      ((MovableVideoView)this.CjV).iw(localPoint.x, localPoint.y);
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
      AppMethodBeat.o(115440);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label79;
      if (!this.Cik) {}
      for (bool1 = true;; bool1 = false)
      {
        this.Cik = bool1;
        this.CjY.setVisibility(8);
        break;
      }
    }
  }
  
  private void eyR()
  {
    AppMethodBeat.i(115447);
    this.ChE.setText(2131764949);
    this.Cjk.a(this.ChF, Cje);
    AppMethodBeat.o(115447);
  }
  
  private void eyS()
  {
    AppMethodBeat.i(115450);
    View.OnClickListener local14 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(216526);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.plugin.report.service.g.yhR.f(11079, new Object[] { Integer.valueOf(4) });
        if ((!VoipVideoFragment.l(VoipVideoFragment.this)) && (VoipVideoFragment.this.CiR.get() != null)) {
          VoipVideoFragment.o(VoipVideoFragment.this).getVisibility();
        }
        int i;
        if (VoipVideoFragment.o(VoipVideoFragment.this).getVisibility() == 0)
        {
          i = 4;
          if (i != 0) {
            break label294;
          }
        }
        label294:
        for (int j = 0;; j = 8)
        {
          VoipVideoFragment.o(VoipVideoFragment.this).setVisibility(j);
          VoipVideoFragment.s(VoipVideoFragment.this).setVisibility(j);
          VoipVideoFragment.t(VoipVideoFragment.this).setVisibility(j);
          VoipVideoFragment.b(VoipVideoFragment.this).setVisibility(j);
          VoipVideoFragment.a(VoipVideoFragment.this).setVisibility(j);
          paramAnonymousView = VoipVideoFragment.this;
          if (j == 0) {
            bool = true;
          }
          VoipVideoFragment.d(paramAnonymousView, bool);
          if (ac.iPB)
          {
            VoipVideoFragment.x(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.y(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.z(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.A(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.B(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.C(VoipVideoFragment.this).setVisibility(j);
          }
          if (i == 0) {
            VoipVideoFragment.p(VoipVideoFragment.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(216526);
          return;
          i = 0;
          break;
        }
      }
    };
    this.lPT.setOnClickListener(local14);
    AppMethodBeat.o(115450);
  }
  
  private Point tu(boolean paramBoolean)
  {
    AppMethodBeat.i(115454);
    int i = (int)(getActivity().getWindowManager().getDefaultDisplay().getHeight() / 5.0D);
    float f = i;
    com.tencent.mm.plugin.voip.c.euM();
    Point localPoint = new Point((int)(f * u.tp(paramBoolean)), i);
    AppMethodBeat.o(115454);
    return localPoint;
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    AppMethodBeat.i(115426);
    if ((paramSurfaceTexture == null) || (paramd == null))
    {
      ad.e("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture error, videoTexture:%s, videoTexture:%s", new Object[] { paramSurfaceTexture, paramd });
      AppMethodBeat.o(115426);
      return;
    }
    this.surfaceTexture = paramSurfaceTexture;
    this.Cka = paramd;
    if ((!this.oXj) || (this.CjX == null) || (this.CjW == null))
    {
      ad.i("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture failed , texId:%d,mInitDone:%b", new Object[] { Integer.valueOf(paramd.hko), Boolean.valueOf(this.oXj) });
      AppMethodBeat.o(115426);
      return;
    }
    this.CjX.a(this.surfaceTexture, paramd);
    this.CjW.a(this.surfaceTexture, paramd);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture OK , videoTexture:%d", new Object[] { Integer.valueOf(paramd.hko) });
    AppMethodBeat.o(115426);
  }
  
  public final void a(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115429);
    this.oXg = paramCaptureView;
    b(this.oXg);
    AppMethodBeat.o(115429);
  }
  
  protected final void aDI(String paramString)
  {
    AppMethodBeat.i(115433);
    if (this.ChJ != null)
    {
      this.ChJ.setVisibility(0);
      this.ChJ.setText(paramString);
    }
    AppMethodBeat.o(115433);
  }
  
  public final void b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(216527);
    if (!this.oXj)
    {
      AppMethodBeat.o(216527);
      return;
    }
    if (OpenGlRender.CnB == 1)
    {
      if (this.Ckb < paramInt1 * paramInt2) {
        this.whe = null;
      }
      if (this.whe == null)
      {
        this.Ckb = (paramInt1 * paramInt2);
        this.whe = new int[this.Ckb];
      }
      if ((com.tencent.mm.plugin.voip.c.euM().a(paramArrayOfByte, (int)paramLong, paramInt3 & 0x1F, paramInt1, paramInt2, this.whe, true) < 0) || (this.whe == null))
      {
        AppMethodBeat.o(216527);
        return;
      }
      if (this.Cik) {
        this.CjW.a(this.whe, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      }
    }
    for (;;)
    {
      this.Cig += 1;
      this.Cif += 1;
      paramArrayOfByte = this.Cib;
      paramArrayOfByte.CmA = paramInt1;
      paramArrayOfByte.CmB = paramInt2;
      paramArrayOfByte = this.Cib;
      paramInt1 = this.lPT.getWidth();
      paramInt2 = this.lPT.getHeight();
      paramArrayOfByte.Cmz = paramInt1;
      paramArrayOfByte.sP = paramInt2;
      AppMethodBeat.o(216527);
      return;
      this.CjX.a(this.whe, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      continue;
      if (OpenGlRender.CnB == 2) {
        if (this.Cik) {
          this.CjW.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
        } else {
          this.CjX.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
        }
      }
    }
  }
  
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115443);
    if (!this.oXj)
    {
      AppMethodBeat.o(115443);
      return;
    }
    this.oZC += 1;
    if (OpenGlRender.CnB == 1)
    {
      if (this.Cik)
      {
        this.CjX.h(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90);
        AppMethodBeat.o(115443);
        return;
      }
      this.CjW.h(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90);
      AppMethodBeat.o(115443);
      return;
    }
    if (this.Cik)
    {
      this.CjX.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
      AppMethodBeat.o(115443);
      return;
    }
    this.CjW.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
    AppMethodBeat.o(115443);
  }
  
  public final void eyH()
  {
    AppMethodBeat.i(115452);
    if (this.oXg != null)
    {
      this.lPT.removeView(this.oXg);
      this.lPT.addView(this.oXg, new RelativeLayout.LayoutParams(1, 1));
      this.oXg.setVisibility(0);
      this.oXg.setAlpha(0.0F);
      ad.i("MicroMsg.Voip.VoipVideoFragment", "resetCaptureView");
    }
    AppMethodBeat.o(115452);
  }
  
  protected final void eyM()
  {
    AppMethodBeat.i(115436);
    if (this.uVp != null)
    {
      this.uVp.clearAnimation();
      this.uVp.setVisibility(8);
    }
    AppMethodBeat.o(115436);
  }
  
  public final void eyN()
  {
    AppMethodBeat.i(115437);
    OpenGlView localOpenGlView = this.CjU;
    ad.i(OpenGlView.TAG, "new size from resoureHelper w %s * h  %s", new Object[] { Integer.valueOf(com.tencent.mm.cc.a.ip(localOpenGlView.getContext())), Integer.valueOf(com.tencent.mm.cc.a.iq(localOpenGlView.getContext())) });
    int i = com.tencent.mm.cc.a.ip(localOpenGlView.getContext());
    int j = com.tencent.mm.cc.a.iq(localOpenGlView.getContext());
    float f;
    Object localObject;
    if (i > j)
    {
      f = i / j;
      if (f <= 1.333333F) {
        break label196;
      }
      localObject = new RelativeLayout.LayoutParams(-1, -1);
    }
    for (;;)
    {
      localOpenGlView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.CjV != null)
      {
        localObject = (MovableVideoView)this.CjV;
        ad.i("MicroMsg.MovableVideoView", "refrsh view %s, %s", new Object[] { Integer.valueOf(((MovableVideoView)localObject).mWidth), Integer.valueOf(((MovableVideoView)localObject).Cna) });
        ((MovableVideoView)localObject).mScreenWidth = 0;
        ((MovableVideoView)localObject).iw(((MovableVideoView)localObject).mWidth, ((MovableVideoView)localObject).Cna);
      }
      AppMethodBeat.o(115437);
      return;
      f = j / i;
      break;
      label196:
      localObject = new RelativeLayout.LayoutParams(j * 9 / 16, j);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
    }
  }
  
  public final void eyU()
  {
    AppMethodBeat.i(115444);
    if (!this.oXj)
    {
      AppMethodBeat.o(115444);
      return;
    }
    this.CjX.eAx();
    this.CjW.eAx();
    AppMethodBeat.o(115444);
  }
  
  public final OpenGlRender eyV()
  {
    if (this.Cik) {
      return this.CjW;
    }
    return this.CjX;
  }
  
  public final void eza()
  {
    AppMethodBeat.i(115425);
    if ((this.CjX != null) && (this.CjW != null))
    {
      if (!this.Cik) {
        break label119;
      }
      this.CjW.UT(0);
      if ((this.Cio & 0x1) == 0) {
        break label108;
      }
      this.CjX.UT(1);
    }
    for (;;)
    {
      ad.i("MicroMsg.Voip.VoipVideoFragment", "changeSurfaceRender, bigViewMode: %d, smallViewMode: %d,mIsSmallViewShowSelf:%b, after changeSurfaceRender", new Object[] { Integer.valueOf(this.CjX.CnQ), Integer.valueOf(this.CjW.CnQ), Boolean.valueOf(this.Cik) });
      AppMethodBeat.o(115425);
      return;
      label108:
      this.CjX.UT(0);
      continue;
      label119:
      this.CjX.UT(0);
      if ((this.Cio & 0x1) != 0) {
        this.CjW.UT(1);
      } else {
        this.CjW.UT(0);
      }
    }
  }
  
  public final void ir(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115446);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "adjustHWViewAspectRatio, mInitDone:%b, HWDecsize:%dx%d,  lastHWDecsize:%dx%d", new Object[] { Boolean.valueOf(this.oXj), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.BZu), Integer.valueOf(this.BZv) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(115446);
      return;
    }
    if ((this.BZu != paramInt1) || (this.BZv != paramInt2))
    {
      this.BZu = paramInt1;
      this.BZv = paramInt2;
    }
    if (this.oXj)
    {
      this.CjX.ir(paramInt1, paramInt2);
      this.CjW.ir(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115446);
  }
  
  public final void iu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115428);
    super.iu(paramInt1, paramInt2);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + com.tencent.mm.plugin.voip.b.l.UK(paramInt2));
    if (this.lPT == null)
    {
      ad.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
      AppMethodBeat.o(115428);
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
        AppMethodBeat.o(115428);
        return;
        eyP();
        paramInt1 = 1;
        continue;
        paramInt1 = 0;
        eyO();
        continue;
        eyS();
        eyQ();
        paramInt1 = 1;
        continue;
        Uy(paramInt1);
        paramInt1 = 1;
      }
      eyR();
    }
  }
  
  protected final void iv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115434);
    if (this.ChI == null)
    {
      AppMethodBeat.o(115434);
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
    AppMethodBeat.o(115434);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(115421);
    this.lPT = ((RelativeLayout)paramLayoutInflater.inflate(2131495883, paramViewGroup, false));
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)this.lPT.findViewById(2131304205)).setPadding(0, 0, 0, BackwardSupportUtil.b.g(getActivity(), 40.0F));
    }
    this.Cjf = ((ImageView)this.lPT.findViewById(2131306556));
    this.Cjg = ((ImageView)this.lPT.findViewById(2131306592));
    this.ChK = ((RelativeLayout)this.lPT.findViewById(2131301467));
    this.CjU = ((OpenGlView)this.lPT.findViewById(2131297220));
    this.CjU.ix(mScreenWidth, mScreenHeight);
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
    if (n.II("VOIPBlockIgnoreButton") == 0)
    {
      bool = true;
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
      b(this.oXg);
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
      this.CjV = new MovableVideoView(getActivity().getApplicationContext());
      ((MovableVideoView)this.CjV).iw(j, i);
      this.CjV.setVisibility(0);
      this.CjV.tG(true);
      this.CjW = new OpenGlRender(this.CjV, OpenGlRender.RenderRemote);
      this.CjV.setRenderer(this.CjW);
      this.CjV.setRenderMode(0);
      this.CjW.CnY = new OpenGlRender.b()
      {
        public final void BA(long paramAnonymousLong)
        {
          AppMethodBeat.i(216516);
          if ((VoipVideoFragment.this.CiR != null) && (VoipVideoFragment.this.CiR.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.CiR.get()).ae(paramAnonymousLong, 1);
          }
          AppMethodBeat.o(216516);
        }
        
        public final void By(long paramAnonymousLong)
        {
          AppMethodBeat.i(216514);
          if ((VoipVideoFragment.this.CiR != null) && (VoipVideoFragment.this.CiR.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.CiR.get()).ae(paramAnonymousLong, 2);
          }
          AppMethodBeat.o(216514);
        }
        
        public final void Bz(long paramAnonymousLong)
        {
          AppMethodBeat.i(216515);
          if ((VoipVideoFragment.this.CiR != null) && (VoipVideoFragment.this.CiR.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.CiR.get()).ae(paramAnonymousLong, 0);
          }
          AppMethodBeat.o(216515);
        }
        
        public final void ezb() {}
      };
      this.CjX = new OpenGlRender(this.CjU, OpenGlRender.RenderLocal);
      this.CjU.setRenderer(this.CjX);
      this.CjU.setRenderMode(0);
      this.CjU.setVisibility(0);
      this.CjX.CnY = new OpenGlRender.b()
      {
        public final void BA(long paramAnonymousLong)
        {
          AppMethodBeat.i(216520);
          if ((VoipVideoFragment.this.CiR != null) && (VoipVideoFragment.this.CiR.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.CiR.get()).ae(paramAnonymousLong, 1);
          }
          AppMethodBeat.o(216520);
        }
        
        public final void By(long paramAnonymousLong)
        {
          AppMethodBeat.i(216518);
          if ((VoipVideoFragment.this.CiR != null) && (VoipVideoFragment.this.CiR.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.CiR.get()).ae(paramAnonymousLong, 2);
          }
          AppMethodBeat.o(216518);
        }
        
        public final void Bz(long paramAnonymousLong)
        {
          AppMethodBeat.i(216519);
          if ((VoipVideoFragment.this.CiR != null) && (VoipVideoFragment.this.CiR.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.CiR.get()).ae(paramAnonymousLong, 0);
          }
          AppMethodBeat.o(216519);
        }
        
        public final void ezb()
        {
          AppMethodBeat.i(216517);
          if ((VoipVideoFragment.this.CiR != null) && (VoipVideoFragment.this.CiR.get() != null)) {
            ((c)VoipVideoFragment.this.CiR.get()).ae(0L, 3);
          }
          AppMethodBeat.o(216517);
        }
      };
      ad.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
      this.lPT.addView(this.CjV);
      this.CjV.setOnClickListener(new VoipVideoFragment.6(this));
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
            AppMethodBeat.i(115400);
            VoipVideoFragment.m(VoipVideoFragment.this).setText(2131764874);
            VoipVideoFragment.this.Cjk.a(VoipVideoFragment.n(VoipVideoFragment.this), VoipBaseFragment.Cje);
            AppMethodBeat.o(115400);
          }
        }, 2000L);
      }
      this.CjY = ((VoIPVideoView)this.lPT.findViewById(2131306590));
      this.mTimer = new Timer("VoIP_video_talking_count");
      ad.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", new Object[] { Integer.valueOf(this.Cip) });
      this.CjX.setVoipBeauty(this.Cip);
      this.CjW.setVoipBeauty(this.Cip);
      if ((this.CiR != null) && (this.CiR.get() != null))
      {
        paramLayoutInflater = (c)this.CiR.get();
        if ((260 == this.mStatus) || (6 == this.mStatus)) {
          break label1613;
        }
      }
    }
    label1613:
    for (boolean bool = true;; bool = false)
    {
      paramLayoutInflater.au(true, bool);
      this.CjX.CnW = true;
      this.CjW.CnW = true;
      this.oXj = true;
      ir(this.BZu, this.BZv);
      iu(0, this.mStatus);
      this.gKs = ((PowerManager)aj.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipVideoFragment");
      this.gKs.acquire();
      ad.i("MicroMsg.Voip.VoipVideoFragment", "acquire wakelock");
      paramLayoutInflater = this.lPT;
      AppMethodBeat.o(115421);
      return paramLayoutInflater;
      bool = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115422);
    this.oZE = false;
    ad.i("MicroMsg.Voip.VoipVideoFragment", "onDestory");
    super.onDestroy();
    if ((this.gKs != null) && (this.gKs.isHeld()))
    {
      ad.i("MicroMsg.Voip.VoipVideoFragment", "release waklock");
      this.gKs.release();
    }
    AppMethodBeat.o(115422);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(115453);
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
    AppMethodBeat.o(115453);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(115432);
    this.CjX.onStarted();
    this.CjW.onStarted();
    super.onStart();
    AppMethodBeat.o(115432);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(115431);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "onStop");
    this.CjX.eAw();
    this.CjW.eAw();
    super.onStop();
    AppMethodBeat.o(115431);
  }
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115424);
    this.CjX.releaseSurfaceTexture();
    this.CjW.releaseSurfaceTexture();
    AppMethodBeat.o(115424);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115423);
    if (this.Cik)
    {
      this.CjU.CmJ.requestRender();
      AppMethodBeat.o(115423);
      return;
    }
    this.CjV.CmJ.requestRender();
    AppMethodBeat.o(115423);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115442);
    this.Cio = paramInt;
    if ((this.CjV == null) || (this.CjV.Cok))
    {
      AppMethodBeat.o(115442);
      return;
    }
    ad.i("MicroMsg.Voip.VoipVideoFragment", "setHWDecMode, hwdec: %d, mIsSmallViewShowSelf:%b, before changeSurfaceRender", new Object[] { Integer.valueOf(this.Cio), Boolean.valueOf(this.Cik) });
    eza();
    AppMethodBeat.o(115442);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt) {}
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115445);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "setVoipBeauty isON:%d, mInitDone:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.oXj) });
    this.Cip = paramInt;
    if (!this.oXj)
    {
      AppMethodBeat.o(115445);
      return;
    }
    this.CjX.setVoipBeauty(this.Cip);
    this.CjW.setVoipBeauty(this.Cip);
    AppMethodBeat.o(115445);
  }
  
  protected final void tt(boolean paramBoolean)
  {
    AppMethodBeat.i(115435);
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
      AppMethodBeat.o(115435);
      return;
      label49:
      this.uVp.setText(2131764891);
    }
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115430);
    ad.m("MicroMsg.Voip.VoipVideoFragment", "unit should not be allow in foreground", new Object[0]);
    if (this.CjV != null) {
      this.CjV.setVisibility(4);
    }
    if (this.oXg != null)
    {
      this.lPT.removeView(this.oXg);
      this.oXg = null;
      ad.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView removed");
    }
    if (this.CjZ != null)
    {
      this.CjZ.cancel();
      this.CjZ = null;
    }
    super.uninit();
    AppMethodBeat.o(115430);
  }
  
  public final class a
    extends com.tencent.e.i.b
  {
    public final String getKey()
    {
      return "VoipVideoFragment_blurBitmap";
    }
    
    public final void run()
    {
      AppMethodBeat.i(115419);
      ad.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
      final Bitmap localBitmap = VoipVideoFragment.D(this.Ckc);
      this.Ckc.jwD.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115418);
          if (VoipVideoFragment.a.this.Ckc.Cjf != null) {
            VoipVideoFragment.a.this.Ckc.Cjf.setBackgroundDrawable(new BitmapDrawable(localBitmap));
          }
          VoipVideoFragment.E(VoipVideoFragment.a.this.Ckc);
          AppMethodBeat.o(115418);
        }
      });
      AppMethodBeat.o(115419);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment
 * JD-Core Version:    0.7.0.1
 */