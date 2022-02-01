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
import android.widget.Toast;
import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.f.d;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.voip.b.j;
import com.tencent.mm.plugin.voip.b.l;
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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.t;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class VoipVideoFragment
  extends VoipBaseFragment
{
  public int AAu;
  public int AAv;
  private ImageView AIA;
  private TextView AIB;
  private TextView AIC;
  private TextView AID;
  private TextView AIE;
  private View AIF;
  private TextView AIG;
  private TextView AIH;
  private TextView AII;
  private RelativeLayout AIJ;
  private Button AIK;
  private VoipSmallIconButton AIL;
  private VoipSmallIconButton AIM;
  private VoipSmallIconButton AIN;
  private VoipBigIconButton AIO;
  private VoipBigIconButton AIP;
  private VoipBigIconButton AIQ;
  private VoipBigIconButton AIR;
  private VoipBigIconButton AIS;
  private VoipBigIconButton AIT;
  private TextView AIU;
  private TextView AIV;
  private TextView AIW;
  private TextView AIX;
  private TextView AIY;
  private TextView AIZ;
  private ImageView AIy;
  private View AIz;
  private View.OnClickListener AJA;
  private View.OnClickListener AJB;
  private View.OnClickListener AJC;
  private View.OnClickListener AJD;
  private View.OnClickListener AJE;
  private View.OnClickListener AJF;
  private View.OnClickListener AJG;
  private Runnable AJH;
  private e AJa;
  private Button AJb;
  private Button AJc;
  private boolean AJd;
  private int AJe;
  private int AJf;
  private int AJg;
  private int AJh;
  private int AJi;
  private boolean AJj;
  private boolean AJk;
  public long AJl;
  public int AJn;
  public int AJo;
  private int AJp;
  private int AJq;
  private au AJr;
  private boolean AJs;
  private View.OnClickListener AJv;
  private View.OnClickListener AJw;
  private View.OnClickListener AJx;
  private View.OnClickListener AJy;
  private View.OnClickListener AJz;
  private OpenGlView AKS;
  private OpenGlView AKT;
  private OpenGlRender AKU;
  private OpenGlRender AKV;
  private VoIPVideoView AKW;
  private a AKX;
  private d AKY;
  int AKZ;
  private PowerManager.WakeLock gqI;
  private long lTu;
  private Timer mTimer;
  private CaptureView otK;
  private boolean otN;
  private int owh;
  private boolean owj;
  private Runnable prT;
  private SurfaceTexture surfaceTexture;
  private TextView tSC;
  int[] uYj;
  Bitmap uYz;
  private Bitmap wtb;
  
  public VoipVideoFragment()
  {
    AppMethodBeat.i(115420);
    this.AJa = null;
    this.AJb = null;
    this.AJc = null;
    this.AJd = false;
    this.AJi = 0;
    this.AJj = false;
    this.owj = false;
    this.otN = false;
    this.AJl = 0L;
    this.wtb = null;
    this.AJn = 0;
    this.AJo = 0;
    this.AJp = 0;
    this.lTu = 0L;
    this.AJq = 0;
    this.AJr = null;
    this.AJs = false;
    this.AAu = 0;
    this.AAv = 0;
    this.surfaceTexture = null;
    this.AJv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115394);
        ac.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
        if ((VoipVideoFragment.this.AJQ != null) && (VoipVideoFragment.this.AJQ.get() != null) && (((c)VoipVideoFragment.this.AJQ.get()).ehm()))
        {
          VoipVideoFragment.a(VoipVideoFragment.this).setEnabled(false);
          VoipVideoFragment.b(VoipVideoFragment.this).setEnabled(false);
          VoipVideoFragment.this.ii(2131764857, -1);
        }
        AppMethodBeat.o(115394);
      }
    };
    this.AJw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115406);
        if ((VoipVideoFragment.this.AJQ != null) && (VoipVideoFragment.this.AJQ.get() != null)) {
          ((c)VoipVideoFragment.this.AJQ.get()).ehE();
        }
        AppMethodBeat.o(115406);
      }
    };
    this.AJx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115407);
        if ((VoipVideoFragment.this.AJQ != null) && (VoipVideoFragment.this.AJQ.get() != null)) {
          ((c)VoipVideoFragment.this.AJQ.get()).ehE();
        }
        AppMethodBeat.o(115407);
      }
    };
    this.AJy = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115410);
        ac.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
        if ((ax.isWifi(VoipVideoFragment.this.getActivity())) || (s.ejj()))
        {
          VoipVideoFragment.c(VoipVideoFragment.this);
          AppMethodBeat.o(115410);
          return;
        }
        com.tencent.mm.ui.base.h.a(VoipVideoFragment.this.getActivity(), 2131764898, 2131764899, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(115408);
            s.eji();
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
        AppMethodBeat.o(115410);
      }
    };
    this.AJz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115413);
        ac.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
        if ((ax.isWifi(VoipVideoFragment.this.getActivity())) || ((s.ejj()) && (!ax.is2G(VoipVideoFragment.this.getActivity()))))
        {
          VoipVideoFragment.e(VoipVideoFragment.this);
          AppMethodBeat.o(115413);
          return;
        }
        com.tencent.mm.ui.base.h.a(VoipVideoFragment.this.getActivity(), 2131764898, 2131764899, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(115411);
            if (!ax.is2G(VoipVideoFragment.this.getActivity())) {
              s.eji();
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
        AppMethodBeat.o(115413);
      }
    };
    this.AJA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115414);
        ac.i("MicroMsg.Voip.VoipVideoFragment", "click reject video invite button");
        VoipVideoFragment.d(VoipVideoFragment.this);
        AppMethodBeat.o(115414);
      }
    };
    this.AJB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115415);
        ac.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
        if ((VoipVideoFragment.this.AJQ != null) && (VoipVideoFragment.this.AJQ.get() != null) && (((c)VoipVideoFragment.this.AJQ.get()).eht()))
        {
          VoipVideoFragment.a(VoipVideoFragment.this).setEnabled(false);
          VoipVideoFragment.f(VoipVideoFragment.this).setEnabled(false);
          VoipVideoFragment.g(VoipVideoFragment.this).setVisibility(0);
          VoipVideoFragment.g(VoipVideoFragment.this).setText(2131764813);
        }
        AppMethodBeat.o(115415);
      }
    };
    this.AJC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115416);
        if (System.currentTimeMillis() - VoipVideoFragment.h(VoipVideoFragment.this) <= 1000L)
        {
          AppMethodBeat.o(115416);
          return;
        }
        VoipVideoFragment.a(VoipVideoFragment.this, System.currentTimeMillis());
        com.tencent.mm.plugin.report.service.h.wUl.f(11618, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
        if ((VoipVideoFragment.this.AJQ != null) && (VoipVideoFragment.this.AJQ.get() != null)) {
          ((c)VoipVideoFragment.this.AJQ.get()).sw(true);
        }
        if (VoipVideoFragment.this.AKh != null)
        {
          VoipVideoFragment.this.elk();
          VoipVideoFragment.this.AKh.as(false, true);
        }
        AppMethodBeat.o(115416);
      }
    };
    this.AJD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115417);
        com.tencent.mm.plugin.report.service.h.wUl.f(11619, new Object[] { Integer.valueOf(2) });
        if ((VoipVideoFragment.this.AJQ != null) && (VoipVideoFragment.this.AJQ.get() != null)) {
          ((c)VoipVideoFragment.this.AJQ.get()).ehR();
        }
        AppMethodBeat.o(115417);
      }
    };
    this.AJE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115395);
        paramAnonymousView = VoipVideoFragment.this;
        if (!VoipVideoFragment.i(VoipVideoFragment.this)) {}
        for (boolean bool = true;; bool = false)
        {
          VoipVideoFragment.a(paramAnonymousView, bool);
          if (!VoipVideoFragment.i(VoipVideoFragment.this)) {
            VoipVideoFragment.j(VoipVideoFragment.this).setVisibility(8);
          }
          Toast.makeText(VoipVideoFragment.this.getActivity(), String.format("mIsShowFaceRect:%b", new Object[] { Boolean.valueOf(VoipVideoFragment.i(VoipVideoFragment.this)) }), 0).show();
          AppMethodBeat.o(115395);
          return;
        }
      }
    };
    this.AJF = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115396);
        boolean bool2 = bs.a((Boolean)paramAnonymousView.getTag(), false);
        boolean bool1;
        if (!bool2)
        {
          bool1 = true;
          paramAnonymousView.setTag(Boolean.valueOf(bool1));
          if (!bool2) {
            break label115;
          }
          VoipVideoFragment.j(VoipVideoFragment.this).setVisibility(8);
          Toast.makeText(VoipVideoFragment.this.getActivity(), "stop face detect", 0).show();
        }
        for (;;)
        {
          if ((VoipVideoFragment.this.AJQ != null) && (VoipVideoFragment.this.AJQ.get() != null)) {
            ((c)VoipVideoFragment.this.AJQ.get()).ehS();
          }
          AppMethodBeat.o(115396);
          return;
          bool1 = false;
          break;
          label115:
          Toast.makeText(VoipVideoFragment.this.getActivity(), "start face detect", 0).show();
        }
      }
    };
    this.AJG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208479);
        ac.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
        VoipVideoFragment.o(VoipVideoFragment.this).setEnabled(false);
        VoipVideoFragment.p(VoipVideoFragment.this);
        VoipVideoFragment.o(VoipVideoFragment.this).setEnabled(true);
        if ((VoipVideoFragment.this.AJQ != null) && (VoipVideoFragment.this.AJQ.get() != null)) {
          ((c)VoipVideoFragment.this.AJQ.get()).ehy();
        }
        AppMethodBeat.o(208479);
      }
    };
    this.AJH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115403);
        ac.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
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
    this.prT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208480);
        if ((VoipVideoFragment.this.getActivity() == null) || (VoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(208480);
          return;
        }
        VoipVideoFragment.g(VoipVideoFragment.this).setVisibility(8);
        AppMethodBeat.o(208480);
      }
    };
    this.uYj = null;
    this.AKZ = 0;
    this.uYz = null;
    AppMethodBeat.o(115420);
  }
  
  private void SG(int paramInt)
  {
    AppMethodBeat.i(115448);
    this.AKi.elo();
    this.AIO.setEnabled(false);
    this.AIS.setEnabled(false);
    this.AIR.setEnabled(false);
    this.AIQ.setEnabled(false);
    this.AIP.setEnabled(false);
    this.AIN.setEnabled(false);
    this.AIT.setEnabled(false);
    this.AIM.setEnabled(false);
    this.AIL.setEnabled(false);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.AKh != null) {
        this.AKh.as(true, false);
      }
      AppMethodBeat.o(115448);
      return;
      this.AIH.setVisibility(0);
      this.AIH.setText(2131764897);
    }
  }
  
  private void aQW()
  {
    AppMethodBeat.i(115449);
    if ((this.mTimer == null) || (this.owj))
    {
      AppMethodBeat.o(115449);
      return;
    }
    if (-1L == this.AJR) {
      this.AJR = bs.aNx();
    }
    this.AJl = this.AJR;
    this.owj = true;
    TimerTask local11 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(208482);
        VoipVideoFragment.this.jdu.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(208481);
            String str = VoipVideoFragment.qn(bs.pN(VoipVideoFragment.this.AJR));
            VoipVideoFragment.t(VoipVideoFragment.this).setText(str);
            VoipVideoFragment.u(VoipVideoFragment.this);
            AppMethodBeat.o(208481);
          }
        });
        AppMethodBeat.o(208482);
      }
    };
    this.mTimer.schedule(local11, 1000L, 1000L);
    this.AJr = new au("VoipVideoFragment_cpuStatThread", new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(208483);
        if (VoipVideoFragment.v(VoipVideoFragment.this))
        {
          VoipVideoFragment.w(VoipVideoFragment.this);
          AppMethodBeat.o(208483);
          return true;
        }
        AppMethodBeat.o(208483);
        return false;
      }
    }, true);
    this.AJs = true;
    this.AJr.au(1000L, 1000L);
    AppMethodBeat.o(115449);
  }
  
  private void b(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115451);
    if ((this.wRY == null) || (paramCaptureView == null))
    {
      AppMethodBeat.o(115451);
      return;
    }
    if ((paramCaptureView.getParent() != null) && ((paramCaptureView.getParent() instanceof ViewGroup))) {
      ((ViewGroup)this.otK.getParent()).removeView(this.otK);
    }
    this.wRY.removeView(this.otK);
    this.otK = null;
    if (paramCaptureView.getParent() != null) {
      ((ViewGroup)paramCaptureView.getParent()).removeAllViews();
    }
    this.otK = paramCaptureView;
    this.wRY.addView(paramCaptureView, new RelativeLayout.LayoutParams(1, 1));
    this.otK.setVisibility(0);
    this.otK.setAlpha(0.0F);
    ac.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView added");
    AppMethodBeat.o(115451);
  }
  
  private void elb()
  {
    AppMethodBeat.i(115427);
    ac.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
    this.AJi += 1;
    this.jdu.postDelayed(this.AJH, 10000L);
    AppMethodBeat.o(115427);
  }
  
  private void ele()
  {
    AppMethodBeat.i(115438);
    this.AKS.setVisibility(0);
    if (this.AKe != null) {
      eln();
    }
    this.AIz.setVisibility(0);
    this.AIB.setVisibility(0);
    if ((com.tencent.mm.storage.ai.aNc(this.foE)) && (!bs.aj(this.AIC.getText()))) {
      this.AIC.setVisibility(0);
    }
    for (;;)
    {
      this.AID.setText(2131764876);
      this.AIF.setVisibility(0);
      this.AIA.setVisibility(0);
      this.AKi.a(this.AIE, AKc);
      this.AIT.setVisibility(8);
      this.AIS.setVisibility(8);
      this.AIO.setVisibility(8);
      this.AIR.setVisibility(8);
      this.AIQ.setVisibility(0);
      this.AIN.setVisibility(0);
      this.AIP.setVisibility(0);
      this.AIM.setVisibility(8);
      if (this.AJk) {
        this.AIL.setVisibility(0);
      }
      this.AII.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.ehb().AAf != null)
      {
        this.AII.setVisibility(0);
        this.AII.setText(com.tencent.mm.plugin.voip.c.ehb().AAf);
      }
      if (ae.fJd.fEF == 1)
      {
        this.AIy.setVisibility(0);
        this.AKS.setVisibility(4);
      }
      AppMethodBeat.o(115438);
      return;
      this.AIC.setVisibility(8);
    }
  }
  
  private void elf()
  {
    AppMethodBeat.i(115439);
    this.AIF.setVisibility(0);
    this.AKS.setVisibility(0);
    this.AID.setText(2131764874);
    if ((com.tencent.mm.storage.ai.aNc(this.foE)) && (!bs.aj(this.AIC.getText()))) {
      this.AIC.setVisibility(0);
    }
    for (;;)
    {
      this.AKd.setVisibility(8);
      this.AIH.setVisibility(8);
      this.AII.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.ehb().AAf != null)
      {
        this.AII.setVisibility(0);
        this.AII.setText(com.tencent.mm.plugin.voip.c.ehb().AAf);
      }
      this.AKi.a(this.AIE, AKc);
      this.AIT.setVisibility(8);
      this.AIS.setVisibility(8);
      this.AIO.setVisibility(0);
      this.AIR.setVisibility(8);
      this.AIQ.setVisibility(8);
      this.AIN.setVisibility(8);
      this.AIP.setVisibility(8);
      this.AIM.setVisibility(0);
      this.AIL.setVisibility(8);
      AppMethodBeat.o(115439);
      return;
      this.AIC.setVisibility(8);
    }
  }
  
  private void elg()
  {
    boolean bool2 = true;
    AppMethodBeat.i(115440);
    if (this.AKe != null) {
      this.AKe.setVisibility(8);
    }
    if (!this.AKT.AOP)
    {
      AppMethodBeat.o(115440);
      return;
    }
    this.AKT.sW(false);
    label79:
    Point localPoint;
    if (this.AzH) {
      if (!this.AJj)
      {
        bool1 = true;
        this.AJj = bool1;
        if (this.AJj) {
          break label408;
        }
        bool1 = true;
        localPoint = sL(bool1);
        this.AKT.il(localPoint.x, localPoint.y);
        if (ab.iwt)
        {
          this.AIU.setVisibility(0);
          this.AIV.setVisibility(0);
          this.AIW.setVisibility(0);
          this.AIX.setVisibility(0);
          this.AIY.setVisibility(0);
          this.AIZ.setVisibility(0);
        }
        this.AIz.setVisibility(8);
        this.AKS.setVisibility(0);
        this.AKT.setVisibility(0);
        this.AIG.setVisibility(0);
        this.AIK.setVisibility(0);
        this.AIT.setVisibility(0);
        this.AIS.setVisibility(0);
        this.AIO.setVisibility(8);
        this.AIR.setVisibility(0);
        this.AIQ.setVisibility(8);
        this.AIN.setVisibility(8);
        this.AIP.setVisibility(8);
        this.AIM.setVisibility(8);
        this.AIL.setVisibility(8);
        setHWDecMode(this.AJn);
        ac.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", new Object[] { Integer.valueOf(this.AJn) });
        if (this.AJj) {
          break label444;
        }
      }
    }
    label408:
    label444:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPoint = sL(bool1);
      ((MovableVideoView)this.AKT).ij(localPoint.x, localPoint.y);
      aQW();
      if (com.tencent.mm.sdk.platformtools.ai.eUY().getBoolean("voipfaceDebug", false))
      {
        this.AJb.setVisibility(0);
        this.AJc.setVisibility(0);
      }
      elb();
      if (this.AKf == 4102) {
        ii(2131764783, 10000);
      }
      AppMethodBeat.o(115440);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label79;
      if (!this.AJj) {}
      for (bool1 = true;; bool1 = false)
      {
        this.AJj = bool1;
        this.AKW.setVisibility(8);
        break;
      }
    }
  }
  
  private void elh()
  {
    AppMethodBeat.i(115447);
    this.AID.setText(2131764949);
    this.AKi.a(this.AIE, AKc);
    AppMethodBeat.o(115447);
  }
  
  private void eli()
  {
    AppMethodBeat.i(115450);
    View.OnClickListener local14 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(208484);
        com.tencent.mm.plugin.report.service.h.wUl.f(11079, new Object[] { Integer.valueOf(4) });
        if ((!VoipVideoFragment.l(VoipVideoFragment.this)) && (VoipVideoFragment.this.AJQ.get() != null)) {
          VoipVideoFragment.o(VoipVideoFragment.this).getVisibility();
        }
        int i;
        if (VoipVideoFragment.o(VoipVideoFragment.this).getVisibility() == 0)
        {
          i = 4;
          if (i != 0) {
            break label250;
          }
        }
        label250:
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
          if (ab.iwt)
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
          AppMethodBeat.o(208484);
          return;
          i = 0;
          break;
        }
      }
    };
    this.wRY.setOnClickListener(local14);
    AppMethodBeat.o(115450);
  }
  
  private Point sL(boolean paramBoolean)
  {
    AppMethodBeat.i(115454);
    int i = (int)(getActivity().getWindowManager().getDefaultDisplay().getHeight() / 5.0D);
    float f = i;
    com.tencent.mm.plugin.voip.c.ehb();
    Point localPoint = new Point((int)(f * u.sG(paramBoolean)), i);
    AppMethodBeat.o(115454);
    return localPoint;
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    AppMethodBeat.i(115426);
    if ((paramSurfaceTexture == null) || (paramd == null))
    {
      ac.e("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture error, videoTexture:%s, videoTexture:%s", new Object[] { paramSurfaceTexture, paramd });
      AppMethodBeat.o(115426);
      return;
    }
    this.surfaceTexture = paramSurfaceTexture;
    this.AKY = paramd;
    if ((!this.otN) || (this.AKV == null) || (this.AKU == null))
    {
      ac.i("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture failed , texId:%d,mInitDone:%b", new Object[] { Integer.valueOf(paramd.gRW), Boolean.valueOf(this.otN) });
      AppMethodBeat.o(115426);
      return;
    }
    this.AKV.a(this.surfaceTexture, paramd);
    this.AKU.a(this.surfaceTexture, paramd);
    ac.i("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture OK , videoTexture:%d", new Object[] { Integer.valueOf(paramd.gRW) });
    AppMethodBeat.o(115426);
  }
  
  public final void a(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115429);
    this.otK = paramCaptureView;
    b(this.otK);
    AppMethodBeat.o(115429);
  }
  
  protected final void ayA(String paramString)
  {
    AppMethodBeat.i(115433);
    if (this.AII != null)
    {
      this.AII.setVisibility(0);
      this.AII.setText(paramString);
    }
    AppMethodBeat.o(115433);
  }
  
  public final void b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(208485);
    if (!this.otN)
    {
      AppMethodBeat.o(208485);
      return;
    }
    if (OpenGlRender.AOo == 1)
    {
      if (this.AKZ < paramInt1 * paramInt2) {
        this.uYj = null;
      }
      if (this.uYj == null)
      {
        this.AKZ = (paramInt1 * paramInt2);
        this.uYj = new int[this.AKZ];
      }
      if ((com.tencent.mm.plugin.voip.c.ehb().a(paramArrayOfByte, (int)paramLong, paramInt3 & 0x1F, paramInt1, paramInt2, this.uYj, true) < 0) || (this.uYj == null))
      {
        AppMethodBeat.o(208485);
        return;
      }
      if (this.AJj) {
        this.AKU.a(this.uYj, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      }
    }
    for (;;)
    {
      this.AJf += 1;
      this.AJe += 1;
      paramArrayOfByte = this.AJa;
      paramArrayOfByte.ANn = paramInt1;
      paramArrayOfByte.ANo = paramInt2;
      paramArrayOfByte = this.AJa;
      paramInt1 = this.wRY.getWidth();
      paramInt2 = this.wRY.getHeight();
      paramArrayOfByte.ANm = paramInt1;
      paramArrayOfByte.qU = paramInt2;
      AppMethodBeat.o(208485);
      return;
      this.AKV.a(this.uYj, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      continue;
      if (OpenGlRender.AOo == 2) {
        if (this.AJj) {
          this.AKU.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
        } else {
          this.AKV.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
        }
      }
    }
  }
  
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115443);
    if (!this.otN)
    {
      AppMethodBeat.o(115443);
      return;
    }
    this.owh += 1;
    if (OpenGlRender.AOo == 1)
    {
      if (this.AJj)
      {
        this.AKV.h(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90);
        AppMethodBeat.o(115443);
        return;
      }
      this.AKU.h(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90);
      AppMethodBeat.o(115443);
      return;
    }
    if (this.AJj)
    {
      this.AKV.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
      AppMethodBeat.o(115443);
      return;
    }
    this.AKU.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
    AppMethodBeat.o(115443);
  }
  
  public final void ekW()
  {
    AppMethodBeat.i(115452);
    if (this.otK != null)
    {
      this.wRY.removeView(this.otK);
      this.wRY.addView(this.otK, new RelativeLayout.LayoutParams(1, 1));
      this.otK.setVisibility(0);
      this.otK.setAlpha(0.0F);
      ac.i("MicroMsg.Voip.VoipVideoFragment", "resetCaptureView");
    }
    AppMethodBeat.o(115452);
  }
  
  protected final void elc()
  {
    AppMethodBeat.i(115436);
    if (this.tSC != null)
    {
      this.tSC.clearAnimation();
      this.tSC.setVisibility(8);
    }
    AppMethodBeat.o(115436);
  }
  
  public final void eld()
  {
    AppMethodBeat.i(115437);
    OpenGlView localOpenGlView = this.AKS;
    ac.i(OpenGlView.TAG, "new size from resoureHelper w %s * h  %s", new Object[] { Integer.valueOf(com.tencent.mm.cc.a.ig(localOpenGlView.getContext())), Integer.valueOf(com.tencent.mm.cc.a.ih(localOpenGlView.getContext())) });
    int i = com.tencent.mm.cc.a.ig(localOpenGlView.getContext());
    int j = com.tencent.mm.cc.a.ih(localOpenGlView.getContext());
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
      if (this.AKT != null)
      {
        localObject = (MovableVideoView)this.AKT;
        ac.i("MicroMsg.MovableVideoView", "refrsh view %s, %s", new Object[] { Integer.valueOf(((MovableVideoView)localObject).mWidth), Integer.valueOf(((MovableVideoView)localObject).ANN) });
        ((MovableVideoView)localObject).mScreenWidth = 0;
        ((MovableVideoView)localObject).ij(((MovableVideoView)localObject).mWidth, ((MovableVideoView)localObject).ANN);
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
  
  public final void elk()
  {
    AppMethodBeat.i(115444);
    if (!this.otN)
    {
      AppMethodBeat.o(115444);
      return;
    }
    this.AKV.emB();
    this.AKU.emB();
    AppMethodBeat.o(115444);
  }
  
  public final OpenGlRender ell()
  {
    if (this.AJj) {
      return this.AKU;
    }
    return this.AKV;
  }
  
  public final void elq()
  {
    AppMethodBeat.i(115425);
    if ((this.AKV != null) && (this.AKU != null))
    {
      if (!this.AJj) {
        break label119;
      }
      this.AKU.Ta(0);
      if ((this.AJn & 0x1) == 0) {
        break label108;
      }
      this.AKV.Ta(1);
    }
    for (;;)
    {
      ac.i("MicroMsg.Voip.VoipVideoFragment", "changeSurfaceRender, bigViewMode: %d, smallViewMode: %d,mIsSmallViewShowSelf:%b, after changeSurfaceRender", new Object[] { Integer.valueOf(this.AKV.AOw), Integer.valueOf(this.AKU.AOw), Boolean.valueOf(this.AJj) });
      AppMethodBeat.o(115425);
      return;
      label108:
      this.AKV.Ta(0);
      continue;
      label119:
      this.AKV.Ta(0);
      if ((this.AJn & 0x1) != 0) {
        this.AKU.Ta(1);
      } else {
        this.AKU.Ta(0);
      }
    }
  }
  
  public final void ie(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115446);
    ac.i("MicroMsg.Voip.VoipVideoFragment", "adjustHWViewAspectRatio, mInitDone:%b, HWDecsize:%dx%d,  lastHWDecsize:%dx%d", new Object[] { Boolean.valueOf(this.otN), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.AAu), Integer.valueOf(this.AAv) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(115446);
      return;
    }
    if ((this.AAu != paramInt1) || (this.AAv != paramInt2))
    {
      this.AAu = paramInt1;
      this.AAv = paramInt2;
    }
    if (this.otN)
    {
      this.AKV.ie(paramInt1, paramInt2);
      this.AKU.ie(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115446);
  }
  
  public final void ih(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115428);
    super.ih(paramInt1, paramInt2);
    ac.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + j.SR(paramInt2));
    if (this.wRY == null)
    {
      ac.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
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
        if ((ae.fJd.fEF == 1) && (paramInt1 != 0)) {
          this.AIy.setVisibility(8);
        }
        AppMethodBeat.o(115428);
        return;
        elf();
        paramInt1 = 1;
        continue;
        paramInt1 = 0;
        ele();
        continue;
        eli();
        elg();
        paramInt1 = 1;
        continue;
        SG(paramInt1);
        paramInt1 = 1;
      }
      elh();
    }
  }
  
  protected final void ii(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115434);
    if (this.AIH == null)
    {
      AppMethodBeat.o(115434);
      return;
    }
    this.AIH.setText(paramInt1);
    this.AIH.setVisibility(0);
    this.AIH.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.AIH.setBackgroundResource(2131234591);
    this.AIH.setCompoundDrawables(null, null, null, null);
    this.AIH.setCompoundDrawablePadding(0);
    this.jdu.removeCallbacks(this.prT);
    if (-1 != paramInt2) {
      this.jdu.postDelayed(this.prT, paramInt2);
    }
    AppMethodBeat.o(115434);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(115421);
    this.wRY = ((RelativeLayout)paramLayoutInflater.inflate(2131495883, paramViewGroup, false));
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)this.wRY.findViewById(2131304205)).setPadding(0, 0, 0, BackwardSupportUtil.b.g(getActivity(), 40.0F));
    }
    this.AKd = ((ImageView)this.wRY.findViewById(2131306556));
    this.AKe = ((ImageView)this.wRY.findViewById(2131306592));
    this.AIJ = ((RelativeLayout)this.wRY.findViewById(2131301467));
    this.AKS = ((OpenGlView)this.wRY.findViewById(2131297220));
    this.AKS.ik(mScreenWidth, mScreenHeight);
    ac.i("MicroMsg.Voip.VoipVideoFragment", "steve: onCreateView!");
    this.AIT = ((VoipBigIconButton)this.wRY.findViewById(2131306588));
    this.AIT.setOnClickListener(this.AJG);
    this.AIS = ((VoipBigIconButton)this.wRY.findViewById(2131306604));
    this.AIS.setOnClickListener(this.AJw);
    this.AIO = ((VoipBigIconButton)this.wRY.findViewById(2131306557));
    this.AIO.setOnClickListener(this.AJB);
    this.AIR = ((VoipBigIconButton)this.wRY.findViewById(2131306574));
    this.AIR.setOnClickListener(this.AJv);
    this.AIQ = ((VoipBigIconButton)this.wRY.findViewById(2131306553));
    this.AIQ.setOnClickListener(this.AJz);
    this.AIN = ((VoipSmallIconButton)this.wRY.findViewById(2131306554));
    this.AIN.setOnClickListener(this.AJy);
    this.AIP = ((VoipBigIconButton)this.wRY.findViewById(2131306585));
    this.AIP.setOnClickListener(this.AJA);
    this.AIM = ((VoipSmallIconButton)this.wRY.findViewById(2131306589));
    this.AIM.setOnClickListener(this.AJx);
    if (l.Fs("VOIPBlockIgnoreButton") == 0)
    {
      bool = true;
      this.AJk = bool;
      this.AIL = ((VoipSmallIconButton)this.wRY.findViewById(2131306575));
      this.AIL.setOnClickListener(this.AJD);
      if (!this.AJk) {
        this.AIL.setVisibility(8);
      }
      this.AIG = ((TextView)this.wRY.findViewById(2131306605));
      this.AIz = this.wRY.findViewById(2131306598);
      this.AIA = ((ImageView)this.wRY.findViewById(2131306597));
      a.b.a(this.AIA, this.foE, 0.0588235F, true);
      this.AIB = ((TextView)this.wRY.findViewById(2131306599));
      this.AIC = ((TextView)this.wRY.findViewById(2131306601));
      this.AID = ((TextView)this.wRY.findViewById(2131306594));
      this.AIE = ((TextView)this.wRY.findViewById(2131306596));
      this.AIF = this.wRY.findViewById(2131306595);
      t(this.AIE);
      this.AIH = ((TextView)this.wRY.findViewById(2131306593));
      this.AII = ((TextView)this.wRY.findViewById(2131306603));
      this.AIK = ((Button)this.wRY.findViewById(2131297592));
      this.tSC = ((TextView)this.wRY.findViewById(2131306581));
      this.AIy = ((ImageView)this.wRY.findViewById(2131300320));
      paramLayoutInflater = com.tencent.mm.aj.c.a(this.foE, false, -1, null);
      this.AIy.setImageBitmap(f.l(paramLayoutInflater, 10));
      if (ab.iwt)
      {
        this.AIU = ((TextView)this.wRY.findViewById(2131306558));
        this.AIV = ((TextView)this.wRY.findViewById(2131306586));
        this.AIW = ((TextView)this.wRY.findViewById(2131306583));
        this.AIX = ((TextView)this.wRY.findViewById(2131306587));
        this.AIY = ((TextView)this.wRY.findViewById(2131306584));
        this.AIZ = ((TextView)this.wRY.findViewById(2131299493));
      }
      this.AJb = ((Button)this.wRY.findViewById(2131306572));
      this.AJc = ((Button)this.wRY.findViewById(2131306573));
      this.AJb.setVisibility(8);
      this.AJc.setVisibility(8);
      this.AJb.setOnClickListener(this.AJE);
      this.AJc.setOnClickListener(this.AJF);
      this.AJa = new e(getActivity());
      this.wRY.addView(this.AJa);
      this.AJa.setVisibility(8);
      this.AIK.setOnClickListener(this.AJC);
      b(this.otK);
      int i = t.jL(getActivity());
      ac.d("MicroMsg.Voip.VoipVideoFragment", "statusHeight: ".concat(String.valueOf(i)));
      au(this.AIK, i);
      au(this.wRY.findViewById(2131306591), i);
      au(this.AIz, i);
      this.AJf = 0;
      this.AJe = 0;
      this.owh = 0;
      this.AJg = 0;
      this.AJh = 0;
      this.AJp = 0;
      this.AJq = 0;
      paramLayoutInflater = (WindowManager)getActivity().getSystemService("window");
      i = paramLayoutInflater.getDefaultDisplay().getHeight() / 5;
      int j = paramLayoutInflater.getDefaultDisplay().getWidth() * i / paramLayoutInflater.getDefaultDisplay().getHeight();
      this.AKT = new MovableVideoView(getActivity().getApplicationContext());
      ((MovableVideoView)this.AKT).ij(j, i);
      this.AKT.setVisibility(0);
      this.AKT.sW(true);
      this.AKU = new OpenGlRender(this.AKT, OpenGlRender.RenderRemote);
      this.AKT.setRenderer(this.AKU);
      this.AKT.setRenderMode(0);
      this.AKU.AOE = new OpenGlRender.b()
      {
        public final void elr() {}
        
        public final void yR(long paramAnonymousLong)
        {
          AppMethodBeat.i(208472);
          if ((VoipVideoFragment.this.AJQ != null) && (VoipVideoFragment.this.AJQ.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.AJQ.get()).Z(paramAnonymousLong, 2);
          }
          AppMethodBeat.o(208472);
        }
        
        public final void yS(long paramAnonymousLong)
        {
          AppMethodBeat.i(208473);
          if ((VoipVideoFragment.this.AJQ != null) && (VoipVideoFragment.this.AJQ.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.AJQ.get()).Z(paramAnonymousLong, 0);
          }
          AppMethodBeat.o(208473);
        }
        
        public final void yT(long paramAnonymousLong)
        {
          AppMethodBeat.i(208474);
          if ((VoipVideoFragment.this.AJQ != null) && (VoipVideoFragment.this.AJQ.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.AJQ.get()).Z(paramAnonymousLong, 1);
          }
          AppMethodBeat.o(208474);
        }
      };
      this.AKV = new OpenGlRender(this.AKS, OpenGlRender.RenderLocal);
      this.AKS.setRenderer(this.AKV);
      this.AKS.setRenderMode(0);
      this.AKS.setVisibility(0);
      this.AKV.AOE = new OpenGlRender.b()
      {
        public final void elr()
        {
          AppMethodBeat.i(208475);
          if ((VoipVideoFragment.this.AJQ != null) && (VoipVideoFragment.this.AJQ.get() != null)) {
            ((c)VoipVideoFragment.this.AJQ.get()).Z(0L, 3);
          }
          AppMethodBeat.o(208475);
        }
        
        public final void yR(long paramAnonymousLong)
        {
          AppMethodBeat.i(208476);
          if ((VoipVideoFragment.this.AJQ != null) && (VoipVideoFragment.this.AJQ.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.AJQ.get()).Z(paramAnonymousLong, 2);
          }
          AppMethodBeat.o(208476);
        }
        
        public final void yS(long paramAnonymousLong)
        {
          AppMethodBeat.i(208477);
          if ((VoipVideoFragment.this.AJQ != null) && (VoipVideoFragment.this.AJQ.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.AJQ.get()).Z(paramAnonymousLong, 0);
          }
          AppMethodBeat.o(208477);
        }
        
        public final void yT(long paramAnonymousLong)
        {
          AppMethodBeat.i(208478);
          if ((VoipVideoFragment.this.AJQ != null) && (VoipVideoFragment.this.AJQ.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.AJQ.get()).Z(paramAnonymousLong, 1);
          }
          AppMethodBeat.o(208478);
        }
      };
      ac.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
      this.wRY.addView(this.AKT);
      this.AKT.setOnClickListener(new View.OnClickListener()
      {
        long AJJ = 0L;
        
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(115399);
          ac.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
          if ((VoipVideoFragment.k(VoipVideoFragment.this).AOP) || (VoipVideoFragment.k(VoipVideoFragment.this).getVisibility() != 0))
          {
            ac.i("MicroMsg.Voip.VoipVideoFragment", "current view is not show ");
            AppMethodBeat.o(115399);
            return;
          }
          if (bs.aO(this.AJJ) < 400L)
          {
            ac.i("MicroMsg.Voip.VoipVideoFragment", "click mGlSmallVideoView too fast and not allow to response it,times%s", new Object[] { Long.valueOf(bs.aO(this.AJJ)) });
            AppMethodBeat.o(115399);
            return;
          }
          this.AJJ = bs.Gn();
          paramAnonymousView = VoipVideoFragment.this;
          if (!VoipVideoFragment.l(VoipVideoFragment.this))
          {
            bool = true;
            VoipVideoFragment.b(paramAnonymousView, bool);
            VoipVideoFragment.this.elq();
            paramAnonymousView = VoipVideoFragment.this;
            if (VoipVideoFragment.l(VoipVideoFragment.this)) {
              break label204;
            }
          }
          label204:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView = VoipVideoFragment.c(paramAnonymousView, bool);
            VoipVideoFragment.k(VoipVideoFragment.this).il(paramAnonymousView.x, paramAnonymousView.y);
            com.tencent.mm.plugin.report.service.h.wUl.f(11079, new Object[] { Integer.valueOf(3) });
            AppMethodBeat.o(115399);
            return;
            bool = false;
            break;
          }
        }
      });
      paramLayoutInflater = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.foE);
      this.AIB.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getActivity(), v.b(paramLayoutInflater, this.foE), this.AIB.getTextSize()));
      paramLayoutInflater = com.tencent.mm.openim.room.a.a.H(paramLayoutInflater);
      if (!bs.isNullOrNil(paramLayoutInflater)) {
        this.AIC.setText(paramLayoutInflater);
      }
      if (this.AzH) {
        this.jdu.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(115400);
            VoipVideoFragment.m(VoipVideoFragment.this).setText(2131764874);
            VoipVideoFragment.this.AKi.a(VoipVideoFragment.n(VoipVideoFragment.this), VoipBaseFragment.AKc);
            AppMethodBeat.o(115400);
          }
        }, 2000L);
      }
      this.AKW = ((VoIPVideoView)this.wRY.findViewById(2131306590));
      this.mTimer = new Timer("VoIP_video_talking_count");
      ac.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", new Object[] { Integer.valueOf(this.AJo) });
      this.AKV.setVoipBeauty(this.AJo);
      this.AKU.setVoipBeauty(this.AJo);
      if ((this.AJQ != null) && (this.AJQ.get() != null))
      {
        paramLayoutInflater = (c)this.AJQ.get();
        if ((260 == this.mStatus) || (6 == this.mStatus)) {
          break label1613;
        }
      }
    }
    label1613:
    for (boolean bool = true;; bool = false)
    {
      paramLayoutInflater.ap(true, bool);
      this.AKV.AOC = true;
      this.AKU.AOC = true;
      this.otN = true;
      ie(this.AAu, this.AAv);
      ih(0, this.mStatus);
      this.gqI = ((PowerManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipVideoFragment");
      this.gqI.acquire();
      ac.i("MicroMsg.Voip.VoipVideoFragment", "acquire wakelock");
      paramLayoutInflater = this.wRY;
      AppMethodBeat.o(115421);
      return paramLayoutInflater;
      bool = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115422);
    this.owj = false;
    ac.i("MicroMsg.Voip.VoipVideoFragment", "onDestory");
    super.onDestroy();
    if ((this.gqI != null) && (this.gqI.isHeld()))
    {
      ac.i("MicroMsg.Voip.VoipVideoFragment", "release waklock");
      this.gqI.release();
    }
    AppMethodBeat.o(115422);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(115453);
    ac.i("MicroMsg.Voip.VoipVideoFragment", "onDetach");
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    if (this.AJr != null) {
      this.AJr.stopTimer();
    }
    this.AJs = false;
    super.onDetach();
    AppMethodBeat.o(115453);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(115432);
    this.AKV.onStarted();
    this.AKU.onStarted();
    super.onStart();
    AppMethodBeat.o(115432);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(115431);
    ac.i("MicroMsg.Voip.VoipVideoFragment", "onStop");
    this.AKV.emA();
    this.AKU.emA();
    super.onStop();
    AppMethodBeat.o(115431);
  }
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115424);
    this.AKV.releaseSurfaceTexture();
    this.AKU.releaseSurfaceTexture();
    AppMethodBeat.o(115424);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115423);
    if (this.AJj)
    {
      this.AKS.ANw.requestRender();
      AppMethodBeat.o(115423);
      return;
    }
    this.AKT.ANw.requestRender();
    AppMethodBeat.o(115423);
  }
  
  protected final void sK(boolean paramBoolean)
  {
    AppMethodBeat.i(115435);
    if (this.tSC != null)
    {
      if (!paramBoolean) {
        break label49;
      }
      this.tSC.setText(2131764892);
    }
    for (;;)
    {
      this.tSC.clearAnimation();
      this.tSC.setVisibility(0);
      AppMethodBeat.o(115435);
      return;
      label49:
      this.tSC.setText(2131764891);
    }
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115442);
    this.AJn = paramInt;
    if ((this.AKT == null) || (this.AKT.AOP))
    {
      AppMethodBeat.o(115442);
      return;
    }
    ac.i("MicroMsg.Voip.VoipVideoFragment", "setHWDecMode, hwdec: %d, mIsSmallViewShowSelf:%b, before changeSurfaceRender", new Object[] { Integer.valueOf(this.AJn), Boolean.valueOf(this.AJj) });
    elq();
    AppMethodBeat.o(115442);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt) {}
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115445);
    ac.i("MicroMsg.Voip.VoipVideoFragment", "setVoipBeauty isON:%d, mInitDone:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.otN) });
    this.AJo = paramInt;
    if (!this.otN)
    {
      AppMethodBeat.o(115445);
      return;
    }
    this.AKV.setVoipBeauty(this.AJo);
    this.AKU.setVoipBeauty(this.AJo);
    AppMethodBeat.o(115445);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115430);
    ac.m("MicroMsg.Voip.VoipVideoFragment", "unit should not be allow in foreground", new Object[0]);
    if (this.AKT != null) {
      this.AKT.setVisibility(4);
    }
    if (this.otK != null)
    {
      this.wRY.removeView(this.otK);
      this.otK = null;
      ac.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView removed");
    }
    if (this.AKX != null)
    {
      this.AKX.cancel();
      this.AKX = null;
    }
    super.uninit();
    AppMethodBeat.o(115430);
  }
  
  public final class a
    extends b
  {
    public final String getKey()
    {
      return "VoipVideoFragment_blurBitmap";
    }
    
    public final void run()
    {
      AppMethodBeat.i(115419);
      ac.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
      final Bitmap localBitmap = VoipVideoFragment.D(this.ALa);
      this.ALa.jdu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115418);
          if (VoipVideoFragment.a.this.ALa.AKd != null) {
            VoipVideoFragment.a.this.ALa.AKd.setBackgroundDrawable(new BitmapDrawable(localBitmap));
          }
          VoipVideoFragment.E(VoipVideoFragment.a.this.ALa);
          AppMethodBeat.o(115418);
        }
      });
      AppMethodBeat.o(115419);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment
 * JD-Core Version:    0.7.0.1
 */