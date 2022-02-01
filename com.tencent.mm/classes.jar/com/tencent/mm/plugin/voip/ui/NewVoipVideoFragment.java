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
import android.widget.Toast;
import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.voip.b.j;
import com.tencent.mm.plugin.voip.b.l;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.video.NewMovableVideoView;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
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

public class NewVoipVideoFragment
  extends VoipBaseFragment
{
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
  private VoIPRenderSurfaceView AIw;
  private VoIPRenderSurfaceView AIx;
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
  private a AJm;
  public int AJn;
  public int AJo;
  private int AJp;
  private int AJq;
  private au AJr;
  private boolean AJs;
  private boolean AJt;
  private boolean AJu;
  private View.OnClickListener AJv;
  private View.OnClickListener AJw;
  private View.OnClickListener AJx;
  private View.OnClickListener AJy;
  private View.OnClickListener AJz;
  private PowerManager.WakeLock gqI;
  private long lTu;
  private Timer mTimer;
  private boolean otN;
  private int owh;
  private boolean owj;
  private Runnable prT;
  private TextView tSC;
  private Bitmap wtb;
  
  public NewVoipVideoFragment()
  {
    AppMethodBeat.i(208433);
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
    this.AJt = false;
    this.AJu = false;
    this.AJv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208407);
        ac.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
        if ((NewVoipVideoFragment.this.AJQ != null) && (NewVoipVideoFragment.this.AJQ.get() != null) && (((c)NewVoipVideoFragment.this.AJQ.get()).ehm()))
        {
          NewVoipVideoFragment.a(NewVoipVideoFragment.this).setEnabled(false);
          NewVoipVideoFragment.b(NewVoipVideoFragment.this).setEnabled(false);
          NewVoipVideoFragment.this.ii(2131764857, -1);
        }
        AppMethodBeat.o(208407);
      }
    };
    this.AJw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208419);
        if ((NewVoipVideoFragment.this.AJQ != null) && (NewVoipVideoFragment.this.AJQ.get() != null)) {
          ((c)NewVoipVideoFragment.this.AJQ.get()).ehE();
        }
        AppMethodBeat.o(208419);
      }
    };
    this.AJx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208420);
        if ((NewVoipVideoFragment.this.AJQ != null) && (NewVoipVideoFragment.this.AJQ.get() != null)) {
          ((c)NewVoipVideoFragment.this.AJQ.get()).ehE();
        }
        AppMethodBeat.o(208420);
      }
    };
    this.AJy = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208423);
        ac.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
        if ((ax.isWifi(NewVoipVideoFragment.this.getActivity())) || (s.ejj()))
        {
          NewVoipVideoFragment.c(NewVoipVideoFragment.this);
          AppMethodBeat.o(208423);
          return;
        }
        com.tencent.mm.ui.base.h.a(NewVoipVideoFragment.this.getActivity(), 2131764898, 2131764899, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(208421);
            s.eji();
            NewVoipVideoFragment.c(NewVoipVideoFragment.this);
            AppMethodBeat.o(208421);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(208422);
            NewVoipVideoFragment.d(NewVoipVideoFragment.this);
            AppMethodBeat.o(208422);
          }
        });
        AppMethodBeat.o(208423);
      }
    };
    this.AJz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208426);
        ac.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
        if ((ax.isWifi(NewVoipVideoFragment.this.getActivity())) || ((s.ejj()) && (!ax.is2G(NewVoipVideoFragment.this.getActivity()))))
        {
          NewVoipVideoFragment.e(NewVoipVideoFragment.this);
          AppMethodBeat.o(208426);
          return;
        }
        com.tencent.mm.ui.base.h.a(NewVoipVideoFragment.this.getActivity(), 2131764898, 2131764899, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(208424);
            if (!ax.is2G(NewVoipVideoFragment.this.getActivity())) {
              s.eji();
            }
            NewVoipVideoFragment.e(NewVoipVideoFragment.this);
            AppMethodBeat.o(208424);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(208425);
            NewVoipVideoFragment.d(NewVoipVideoFragment.this);
            AppMethodBeat.o(208425);
          }
        });
        AppMethodBeat.o(208426);
      }
    };
    this.AJA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208427);
        ac.i("MicroMsg.Voip.VoipVideoFragment", "click reject video invite button");
        NewVoipVideoFragment.d(NewVoipVideoFragment.this);
        AppMethodBeat.o(208427);
      }
    };
    this.AJB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208428);
        ac.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
        if ((NewVoipVideoFragment.this.AJQ != null) && (NewVoipVideoFragment.this.AJQ.get() != null) && (((c)NewVoipVideoFragment.this.AJQ.get()).eht()))
        {
          NewVoipVideoFragment.a(NewVoipVideoFragment.this).setEnabled(false);
          NewVoipVideoFragment.f(NewVoipVideoFragment.this).setEnabled(false);
          NewVoipVideoFragment.g(NewVoipVideoFragment.this).setVisibility(0);
          NewVoipVideoFragment.g(NewVoipVideoFragment.this).setText(2131764813);
        }
        AppMethodBeat.o(208428);
      }
    };
    this.AJC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208429);
        if (System.currentTimeMillis() - NewVoipVideoFragment.h(NewVoipVideoFragment.this) <= 1000L)
        {
          AppMethodBeat.o(208429);
          return;
        }
        NewVoipVideoFragment.a(NewVoipVideoFragment.this, System.currentTimeMillis());
        com.tencent.mm.plugin.report.service.h.wUl.f(11618, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
        if (NewVoipVideoFragment.this.AKh != null) {
          NewVoipVideoFragment.this.AKh.as(false, true);
        }
        if ((NewVoipVideoFragment.this.AJQ != null) && (NewVoipVideoFragment.this.AJQ.get() != null)) {
          ((c)NewVoipVideoFragment.this.AJQ.get()).sw(true);
        }
        AppMethodBeat.o(208429);
      }
    };
    this.AJD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208430);
        com.tencent.mm.plugin.report.service.h.wUl.f(11619, new Object[] { Integer.valueOf(2) });
        if ((NewVoipVideoFragment.this.AJQ != null) && (NewVoipVideoFragment.this.AJQ.get() != null)) {
          ((c)NewVoipVideoFragment.this.AJQ.get()).ehR();
        }
        AppMethodBeat.o(208430);
      }
    };
    this.AJE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208408);
        paramAnonymousView = NewVoipVideoFragment.this;
        if (!NewVoipVideoFragment.i(NewVoipVideoFragment.this)) {}
        for (boolean bool = true;; bool = false)
        {
          NewVoipVideoFragment.a(paramAnonymousView, bool);
          if (!NewVoipVideoFragment.i(NewVoipVideoFragment.this)) {
            NewVoipVideoFragment.j(NewVoipVideoFragment.this).setVisibility(8);
          }
          Toast.makeText(NewVoipVideoFragment.this.getActivity(), String.format("mIsShowFaceRect:%b", new Object[] { Boolean.valueOf(NewVoipVideoFragment.i(NewVoipVideoFragment.this)) }), 0).show();
          AppMethodBeat.o(208408);
          return;
        }
      }
    };
    this.AJF = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208409);
        boolean bool2 = bs.a((Boolean)paramAnonymousView.getTag(), false);
        boolean bool1;
        if (!bool2)
        {
          bool1 = true;
          paramAnonymousView.setTag(Boolean.valueOf(bool1));
          if (!bool2) {
            break label115;
          }
          NewVoipVideoFragment.j(NewVoipVideoFragment.this).setVisibility(8);
          Toast.makeText(NewVoipVideoFragment.this.getActivity(), "stop face detect", 0).show();
        }
        for (;;)
        {
          if ((NewVoipVideoFragment.this.AJQ != null) && (NewVoipVideoFragment.this.AJQ.get() != null)) {
            ((c)NewVoipVideoFragment.this.AJQ.get()).ehS();
          }
          AppMethodBeat.o(208409);
          return;
          bool1 = false;
          break;
          label115:
          Toast.makeText(NewVoipVideoFragment.this.getActivity(), "start face detect", 0).show();
        }
      }
    };
    this.AJG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208412);
        ac.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
        NewVoipVideoFragment.o(NewVoipVideoFragment.this).setEnabled(false);
        NewVoipVideoFragment.p(NewVoipVideoFragment.this);
        NewVoipVideoFragment.o(NewVoipVideoFragment.this).setEnabled(true);
        if ((NewVoipVideoFragment.this.AJQ != null) && (NewVoipVideoFragment.this.AJQ.get() != null)) {
          ((c)NewVoipVideoFragment.this.AJQ.get()).ehy();
        }
        AppMethodBeat.o(208412);
      }
    };
    this.AJH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208413);
        ac.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
        NewVoipVideoFragment.q(NewVoipVideoFragment.this);
        if ((NewVoipVideoFragment.this.getActivity() == null) || (NewVoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(208413);
          return;
        }
        if (NewVoipVideoFragment.r(NewVoipVideoFragment.this) > 0)
        {
          AppMethodBeat.o(208413);
          return;
        }
        NewVoipVideoFragment.o(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.s(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.t(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.a(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.b(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.d(NewVoipVideoFragment.this, false);
        AppMethodBeat.o(208413);
      }
    };
    this.prT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208414);
        if ((NewVoipVideoFragment.this.getActivity() == null) || (NewVoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(208414);
          return;
        }
        NewVoipVideoFragment.g(NewVoipVideoFragment.this).setVisibility(8);
        AppMethodBeat.o(208414);
      }
    };
    AppMethodBeat.o(208433);
  }
  
  private void SG(int paramInt)
  {
    AppMethodBeat.i(208450);
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
      AppMethodBeat.o(208450);
      return;
      this.AIH.setVisibility(0);
      this.AIH.setText(2131764897);
    }
  }
  
  private void aQW()
  {
    AppMethodBeat.i(208451);
    if ((this.mTimer == null) || (this.owj))
    {
      AppMethodBeat.o(208451);
      return;
    }
    if (-1L == this.AJR) {
      this.AJR = bs.aNx();
    }
    this.AJl = this.AJR;
    this.owj = true;
    TimerTask local9 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(208416);
        NewVoipVideoFragment.this.jdu.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(208415);
            String str = NewVoipVideoFragment.qn(bs.pN(NewVoipVideoFragment.this.AJR));
            NewVoipVideoFragment.t(NewVoipVideoFragment.this).setText(str);
            NewVoipVideoFragment.u(NewVoipVideoFragment.this);
            AppMethodBeat.o(208415);
          }
        });
        AppMethodBeat.o(208416);
      }
    };
    this.mTimer.schedule(local9, 1000L, 1000L);
    this.AJr = new au("VoipVideoFragment_cpuStatThread", new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(208417);
        if (NewVoipVideoFragment.v(NewVoipVideoFragment.this))
        {
          NewVoipVideoFragment.w(NewVoipVideoFragment.this);
          AppMethodBeat.o(208417);
          return true;
        }
        AppMethodBeat.o(208417);
        return false;
      }
    }, true);
    this.AJs = true;
    this.AJr.au(1000L, 1000L);
    AppMethodBeat.o(208451);
  }
  
  private void elb()
  {
    AppMethodBeat.i(208436);
    ac.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
    this.AJi += 1;
    this.jdu.postDelayed(this.AJH, 10000L);
    AppMethodBeat.o(208436);
  }
  
  private void ele()
  {
    AppMethodBeat.i(208446);
    this.AIw.setVisibility(0);
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
        this.AIw.setVisibility(4);
      }
      AppMethodBeat.o(208446);
      return;
      this.AIC.setVisibility(8);
    }
  }
  
  private void elf()
  {
    AppMethodBeat.i(208447);
    this.AIF.setVisibility(0);
    this.AIw.setVisibility(0);
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
      AppMethodBeat.o(208447);
      return;
      this.AIC.setVisibility(8);
    }
  }
  
  private void elg()
  {
    boolean bool2 = true;
    AppMethodBeat.i(208448);
    if (this.AKe != null) {
      this.AKe.setVisibility(8);
    }
    if (this.AIx == null)
    {
      AppMethodBeat.o(208448);
      return;
    }
    if (this.AIx.getVisibility() == 0)
    {
      AppMethodBeat.o(208448);
      return;
    }
    label85:
    Point localPoint;
    if (this.AzH) {
      if (!this.AJj)
      {
        bool1 = true;
        this.AJj = bool1;
        if (this.AJj) {
          break label425;
        }
        bool1 = true;
        localPoint = sL(bool1);
        this.AIx.il(localPoint.x, localPoint.y);
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
        this.AIw.setVisibility(0);
        this.AIx.setVisibility(0);
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
        ((c)this.AJQ.get()).sv(this.AJj);
        ac.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", new Object[] { Integer.valueOf(this.AJn) });
        if (this.AJj) {
          break label452;
        }
      }
    }
    label425:
    label452:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPoint = sL(bool1);
      ((NewMovableVideoView)this.AIx).ij(localPoint.x, localPoint.y);
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
      AppMethodBeat.o(208448);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label85;
      if (!this.AJj) {}
      for (bool1 = true;; bool1 = false)
      {
        this.AJj = bool1;
        break;
      }
    }
  }
  
  private void elh()
  {
    AppMethodBeat.i(208449);
    this.AID.setText(2131764949);
    this.AKi.a(this.AIE, AKc);
    AppMethodBeat.o(208449);
  }
  
  private void eli()
  {
    AppMethodBeat.i(208452);
    View.OnClickListener local11 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(208418);
        com.tencent.mm.plugin.report.service.h.wUl.f(11079, new Object[] { Integer.valueOf(4) });
        if ((!NewVoipVideoFragment.k(NewVoipVideoFragment.this)) && (NewVoipVideoFragment.this.AJQ.get() != null)) {
          NewVoipVideoFragment.o(NewVoipVideoFragment.this).getVisibility();
        }
        int i;
        if (NewVoipVideoFragment.o(NewVoipVideoFragment.this).getVisibility() == 0)
        {
          i = 4;
          if (i != 0) {
            break label250;
          }
        }
        label250:
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
          if (ab.iwt)
          {
            NewVoipVideoFragment.x(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.y(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.z(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.A(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.B(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.C(NewVoipVideoFragment.this).setVisibility(j);
          }
          if (i == 0) {
            NewVoipVideoFragment.p(NewVoipVideoFragment.this);
          }
          AppMethodBeat.o(208418);
          return;
          i = 0;
          break;
        }
      }
    };
    this.wRY.setOnClickListener(local11);
    AppMethodBeat.o(208452);
  }
  
  private void sJ(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(208438);
    if (!this.AJu)
    {
      if (!paramBoolean) {
        break label115;
      }
      ((c)this.AJQ.get()).a(this.AIx, 1);
      ((c)this.AJQ.get()).a(this.AIw, 0);
    }
    for (;;)
    {
      c localc = (c)this.AJQ.get();
      paramBoolean = bool;
      if (260 != this.mStatus)
      {
        paramBoolean = bool;
        if (6 != this.mStatus) {
          paramBoolean = true;
        }
      }
      localc.ap(true, paramBoolean);
      this.AJu = true;
      AppMethodBeat.o(208438);
      return;
      label115:
      ((c)this.AJQ.get()).a(this.AIx, 0);
      ((c)this.AJQ.get()).a(this.AIw, 1);
    }
  }
  
  private Point sL(boolean paramBoolean)
  {
    AppMethodBeat.i(208454);
    int i = (int)(getActivity().getWindowManager().getDefaultDisplay().getHeight() / 5.0D);
    float f = i;
    com.tencent.mm.plugin.voip.c.ehb();
    Point localPoint = new Point((int)(f * u.sG(paramBoolean)), i);
    AppMethodBeat.o(208454);
    return localPoint;
  }
  
  public final void SE(int paramInt)
  {
    this.AJn = paramInt;
  }
  
  public final void SF(int paramInt)
  {
    this.AJo = paramInt;
  }
  
  protected final void ayA(String paramString)
  {
    AppMethodBeat.i(208441);
    if (this.AII != null)
    {
      this.AII.setVisibility(0);
      this.AII.setText(paramString);
    }
    AppMethodBeat.o(208441);
  }
  
  public final void ekY()
  {
    this.owh += 1;
  }
  
  public final void ekZ()
  {
    this.AJf += 1;
  }
  
  protected final void elc()
  {
    AppMethodBeat.i(208444);
    if (this.tSC != null)
    {
      this.tSC.clearAnimation();
      this.tSC.setVisibility(8);
    }
    AppMethodBeat.o(208444);
  }
  
  public final void eld()
  {
    AppMethodBeat.i(208445);
    VoIPRenderSurfaceView localVoIPRenderSurfaceView = this.AIw;
    ac.i("RenderView", "new size from resource Helper w %s * h  %s", new Object[] { Integer.valueOf(com.tencent.mm.cc.a.ig(localVoIPRenderSurfaceView.getContext())), Integer.valueOf(com.tencent.mm.cc.a.ih(localVoIPRenderSurfaceView.getContext())) });
    int i = com.tencent.mm.cc.a.ig(localVoIPRenderSurfaceView.getContext());
    int j = com.tencent.mm.cc.a.ih(localVoIPRenderSurfaceView.getContext());
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
      if (this.AIx != null)
      {
        localObject = (NewMovableVideoView)this.AIx;
        ac.i("MicroMsg.MovableVideoView", "refrsh view %s, %s", new Object[] { Integer.valueOf(((NewMovableVideoView)localObject).mWidth), Integer.valueOf(((NewMovableVideoView)localObject).ANN) });
        ((NewMovableVideoView)localObject).mScreenWidth = 0;
        ((NewMovableVideoView)localObject).ij(((NewMovableVideoView)localObject).mWidth, ((NewMovableVideoView)localObject).ANN);
      }
      AppMethodBeat.o(208445);
      return;
      f = j / i;
      break;
      label199:
      localObject = new RelativeLayout.LayoutParams(j * 9 / 16, j);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
    }
  }
  
  public final void ih(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208437);
    super.ih(paramInt1, paramInt2);
    ac.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + j.SR(paramInt2));
    if (this.wRY == null)
    {
      ac.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
      AppMethodBeat.o(208437);
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
        AppMethodBeat.o(208437);
        return;
        this.AJt = true;
        sJ(true);
        elf();
        paramInt1 = 1;
        continue;
        this.AJt = true;
        sJ(true);
        ele();
        paramInt1 = 0;
        continue;
        eli();
        if (this.AJt)
        {
          ((c)this.AJQ.get()).ehA();
          com.tencent.mm.plugin.voip.b.g.sR(false);
          this.AJt = false;
        }
        for (;;)
        {
          elg();
          paramInt1 = 1;
          break;
          sJ(false);
        }
        SG(paramInt1);
        paramInt1 = 1;
      }
      elh();
    }
  }
  
  protected final void ii(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208442);
    if (this.AIH == null)
    {
      AppMethodBeat.o(208442);
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
    AppMethodBeat.o(208442);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(208434);
    this.wRY = ((RelativeLayout)paramLayoutInflater.inflate(2131495882, paramViewGroup, false));
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)this.wRY.findViewById(2131304205)).setPadding(0, 0, 0, BackwardSupportUtil.b.g(getActivity(), 40.0F));
    }
    this.AKd = ((ImageView)this.wRY.findViewById(2131306556));
    this.AKe = ((ImageView)this.wRY.findViewById(2131306592));
    this.AIJ = ((RelativeLayout)this.wRY.findViewById(2131301467));
    this.AIw = ((VoIPRenderSurfaceView)this.wRY.findViewById(2131297220));
    this.AIw.im(mScreenWidth, mScreenHeight);
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
    if (l.Fs("VOIPBlockIgnoreButton") == 0) {}
    for (boolean bool = true;; bool = false)
    {
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
      this.AIx = new NewMovableVideoView(com.tencent.mm.sdk.platformtools.ai.getContext());
      ((NewMovableVideoView)this.AIx).ij(j, i);
      this.AIx.setVisibility(4);
      this.AIw.setVisibility(0);
      ac.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
      this.wRY.addView(this.AIx);
      this.AIx.setOnClickListener(new View.OnClickListener()
      {
        long AJJ = 0L;
        
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(208410);
          ac.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
          this.AJJ = bs.Gn();
          paramAnonymousView = NewVoipVideoFragment.this;
          if (!NewVoipVideoFragment.k(NewVoipVideoFragment.this))
          {
            bool = true;
            NewVoipVideoFragment.b(paramAnonymousView, bool);
            ((c)NewVoipVideoFragment.this.AJQ.get()).ehA();
            com.tencent.mm.plugin.voip.b.g.sR(true);
            paramAnonymousView = NewVoipVideoFragment.this;
            if (NewVoipVideoFragment.k(NewVoipVideoFragment.this)) {
              break label146;
            }
          }
          label146:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView = NewVoipVideoFragment.c(paramAnonymousView, bool);
            if (NewVoipVideoFragment.l(NewVoipVideoFragment.this) != null) {
              NewVoipVideoFragment.l(NewVoipVideoFragment.this).il(paramAnonymousView.x, paramAnonymousView.y);
            }
            com.tencent.mm.plugin.report.service.h.wUl.f(11079, new Object[] { Integer.valueOf(3) });
            AppMethodBeat.o(208410);
            return;
            bool = false;
            break;
          }
        }
      });
      paramLayoutInflater = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.foE);
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
            AppMethodBeat.i(208411);
            NewVoipVideoFragment.m(NewVoipVideoFragment.this).setText(2131764874);
            NewVoipVideoFragment.this.AKi.a(NewVoipVideoFragment.n(NewVoipVideoFragment.this), VoipBaseFragment.AKc);
            AppMethodBeat.o(208411);
          }
        }, 2000L);
      }
      this.mTimer = new Timer("VoIP_video_talking_count");
      ac.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", new Object[] { Integer.valueOf(this.AJo) });
      this.otN = true;
      ((c)this.AJQ.get()).ehB();
      ih(0, this.mStatus);
      this.gqI = ((PowerManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipVideoFragment");
      this.gqI.acquire();
      ac.i("MicroMsg.Voip.VoipVideoFragment", "acquire wakelock");
      paramLayoutInflater = this.wRY;
      AppMethodBeat.o(208434);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(208435);
    this.owj = false;
    ac.i("MicroMsg.Voip.VoipVideoFragment", "onDestory");
    super.onDestroy();
    if ((this.gqI != null) && (this.gqI.isHeld()))
    {
      ac.i("MicroMsg.Voip.VoipVideoFragment", "release waklock");
      this.gqI.release();
    }
    AppMethodBeat.o(208435);
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(208440);
    super.onDestroyView();
    if (this.AIw != null)
    {
      this.AIw.setVisibility(8);
      this.AIw = null;
    }
    AppMethodBeat.o(208440);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(208453);
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
    AppMethodBeat.o(208453);
  }
  
  protected final void sK(boolean paramBoolean)
  {
    AppMethodBeat.i(208443);
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
      AppMethodBeat.o(208443);
      return;
      label49:
      this.tSC.setText(2131764891);
    }
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt) {}
  
  public final void uninit()
  {
    AppMethodBeat.i(208439);
    ac.m("MicroMsg.Voip.VoipVideoFragment", "unit should not be allow in foreground", new Object[0]);
    if ((this.AIw != null) && (this.AJQ.get() != null)) {
      this.AIw.release();
    }
    if (this.AJQ.get() != null)
    {
      ((c)this.AJQ.get()).a(this.AIw);
      ((c)this.AJQ.get()).a(this.AIx);
    }
    if (this.AIx != null)
    {
      this.AIx.release();
      this.AIx.setVisibility(4);
      this.AIx = null;
    }
    if (this.AJm != null)
    {
      this.AJm.cancel();
      this.AJm = null;
    }
    super.uninit();
    AppMethodBeat.o(208439);
  }
  
  public final class a
    extends b
  {
    public final String getKey()
    {
      return "MicroMsg.Voip.VoipVideoFragment#ShowBlurBackgroundRunnable";
    }
    
    public final void run()
    {
      AppMethodBeat.i(208432);
      ac.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
      final Bitmap localBitmap = NewVoipVideoFragment.D(this.AJI);
      this.AJI.jdu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(208431);
          if (NewVoipVideoFragment.a.this.AJI.AKd != null) {
            NewVoipVideoFragment.a.this.AJI.AKd.setBackgroundDrawable(new BitmapDrawable(localBitmap));
          }
          NewVoipVideoFragment.E(NewVoipVideoFragment.a.this.AJI);
          AppMethodBeat.o(208431);
        }
      });
      AppMethodBeat.o(208432);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment
 * JD-Core Version:    0.7.0.1
 */