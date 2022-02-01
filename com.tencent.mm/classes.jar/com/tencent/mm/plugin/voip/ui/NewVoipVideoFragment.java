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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.voip.b.i;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.video.NewMovableVideoView;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.t;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class NewVoipVideoFragment
  extends VoipBaseFragment
{
  private long lrz;
  private Timer mTimer;
  private int nSM;
  private boolean nSO;
  private Runnable oOz;
  private TextView sKW;
  private Bitmap vkz;
  private VoIPRenderSurfaceView zpH;
  private VoIPRenderSurfaceView zpI;
  private ImageView zpJ;
  private View zpK;
  private ImageView zpL;
  private TextView zpM;
  private TextView zpN;
  private TextView zpO;
  private TextView zpP;
  private View zpQ;
  private TextView zpR;
  private TextView zpS;
  private TextView zpT;
  private RelativeLayout zpU;
  private Button zpV;
  private VoipSmallIconButton zpW;
  private VoipSmallIconButton zpX;
  private VoipSmallIconButton zpY;
  private VoipBigIconButton zpZ;
  public int zqA;
  private int zqB;
  private int zqC;
  private av zqD;
  private boolean zqE;
  private PowerManager.WakeLock zqF;
  private boolean zqG;
  private boolean zqH;
  private View.OnClickListener zqI;
  private View.OnClickListener zqJ;
  private View.OnClickListener zqK;
  private View.OnClickListener zqL;
  private View.OnClickListener zqM;
  private View.OnClickListener zqN;
  private View.OnClickListener zqO;
  private View.OnClickListener zqP;
  private View.OnClickListener zqQ;
  private View.OnClickListener zqR;
  private View.OnClickListener zqS;
  private View.OnClickListener zqT;
  private Runnable zqU;
  private VoipBigIconButton zqa;
  private VoipBigIconButton zqb;
  private VoipBigIconButton zqc;
  private VoipBigIconButton zqd;
  private VoipBigIconButton zqe;
  private TextView zqf;
  private TextView zqg;
  private TextView zqh;
  private TextView zqi;
  private TextView zqj;
  private TextView zqk;
  private e zql;
  private Button zqm;
  private Button zqn;
  private boolean zqo;
  private int zqp;
  private int zqq;
  private int zqr;
  private int zqs;
  private int zqt;
  private boolean zqu;
  private boolean zqv;
  private boolean zqw;
  public long zqx;
  private a zqy;
  public int zqz;
  
  public NewVoipVideoFragment()
  {
    AppMethodBeat.i(192106);
    this.zql = null;
    this.zqm = null;
    this.zqn = null;
    this.zqo = false;
    this.zqt = 0;
    this.zqu = false;
    this.nSO = false;
    this.zqv = false;
    this.zqx = 0L;
    this.vkz = null;
    this.zqz = 0;
    this.zqA = 0;
    this.zqB = 0;
    this.lrz = 0L;
    this.zqC = 0;
    this.zqD = null;
    this.zqE = false;
    this.zqG = false;
    this.zqH = false;
    this.zqI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192080);
        ad.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
        if ((NewVoipVideoFragment.this.zrd != null) && (NewVoipVideoFragment.this.zrd.get() != null) && (((c)NewVoipVideoFragment.this.zrd.get()).dSa()))
        {
          NewVoipVideoFragment.a(NewVoipVideoFragment.this).setEnabled(false);
          NewVoipVideoFragment.b(NewVoipVideoFragment.this).setEnabled(false);
          NewVoipVideoFragment.this.hT(2131764857, -1);
        }
        AppMethodBeat.o(192080);
      }
    };
    this.zqJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192092);
        if ((NewVoipVideoFragment.this.zrd != null) && (NewVoipVideoFragment.this.zrd.get() != null)) {
          ((c)NewVoipVideoFragment.this.zrd.get()).dSs();
        }
        AppMethodBeat.o(192092);
      }
    };
    this.zqK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192093);
        if ((NewVoipVideoFragment.this.zrd != null) && (NewVoipVideoFragment.this.zrd.get() != null)) {
          ((c)NewVoipVideoFragment.this.zrd.get()).dSs();
        }
        AppMethodBeat.o(192093);
      }
    };
    this.zqL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192096);
        ad.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
        if ((ay.isWifi(NewVoipVideoFragment.this.getActivity())) || (s.dTX()))
        {
          NewVoipVideoFragment.c(NewVoipVideoFragment.this);
          AppMethodBeat.o(192096);
          return;
        }
        com.tencent.mm.ui.base.h.a(NewVoipVideoFragment.this.getActivity(), 2131764898, 2131764899, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(192094);
            s.dTW();
            NewVoipVideoFragment.c(NewVoipVideoFragment.this);
            AppMethodBeat.o(192094);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(192095);
            NewVoipVideoFragment.d(NewVoipVideoFragment.this);
            AppMethodBeat.o(192095);
          }
        });
        AppMethodBeat.o(192096);
      }
    };
    this.zqM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192099);
        ad.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
        if ((ay.isWifi(NewVoipVideoFragment.this.getActivity())) || ((s.dTX()) && (!ay.is2G(NewVoipVideoFragment.this.getActivity()))))
        {
          NewVoipVideoFragment.e(NewVoipVideoFragment.this);
          AppMethodBeat.o(192099);
          return;
        }
        com.tencent.mm.ui.base.h.a(NewVoipVideoFragment.this.getActivity(), 2131764898, 2131764899, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(192097);
            if (!ay.is2G(NewVoipVideoFragment.this.getActivity())) {
              s.dTW();
            }
            NewVoipVideoFragment.e(NewVoipVideoFragment.this);
            AppMethodBeat.o(192097);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(192098);
            NewVoipVideoFragment.d(NewVoipVideoFragment.this);
            AppMethodBeat.o(192098);
          }
        });
        AppMethodBeat.o(192099);
      }
    };
    this.zqN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192100);
        ad.i("MicroMsg.Voip.VoipVideoFragment", "click reject video invite button");
        NewVoipVideoFragment.d(NewVoipVideoFragment.this);
        AppMethodBeat.o(192100);
      }
    };
    this.zqO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192101);
        ad.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
        if ((NewVoipVideoFragment.this.zrd != null) && (NewVoipVideoFragment.this.zrd.get() != null) && (((c)NewVoipVideoFragment.this.zrd.get()).dSh()))
        {
          NewVoipVideoFragment.a(NewVoipVideoFragment.this).setEnabled(false);
          NewVoipVideoFragment.f(NewVoipVideoFragment.this).setEnabled(false);
          NewVoipVideoFragment.g(NewVoipVideoFragment.this).setVisibility(0);
          NewVoipVideoFragment.g(NewVoipVideoFragment.this).setText(2131764813);
        }
        AppMethodBeat.o(192101);
      }
    };
    this.zqP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192102);
        if (System.currentTimeMillis() - NewVoipVideoFragment.h(NewVoipVideoFragment.this) <= 1000L)
        {
          AppMethodBeat.o(192102);
          return;
        }
        NewVoipVideoFragment.a(NewVoipVideoFragment.this, System.currentTimeMillis());
        com.tencent.mm.plugin.report.service.h.vKh.f(11618, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
        if (NewVoipVideoFragment.this.zrw != null) {
          NewVoipVideoFragment.this.zrw.ao(false, true);
        }
        if ((NewVoipVideoFragment.this.zrd != null) && (NewVoipVideoFragment.this.zrd.get() != null)) {
          ((c)NewVoipVideoFragment.this.zrd.get()).rv(true);
        }
        AppMethodBeat.o(192102);
      }
    };
    this.zqQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192103);
        com.tencent.mm.plugin.report.service.h.vKh.f(11619, new Object[] { Integer.valueOf(2) });
        if ((NewVoipVideoFragment.this.zrd != null) && (NewVoipVideoFragment.this.zrd.get() != null)) {
          ((c)NewVoipVideoFragment.this.zrd.get()).dSF();
        }
        AppMethodBeat.o(192103);
      }
    };
    this.zqR = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192081);
        paramAnonymousView = NewVoipVideoFragment.this;
        if (!NewVoipVideoFragment.i(NewVoipVideoFragment.this)) {}
        for (boolean bool = true;; bool = false)
        {
          NewVoipVideoFragment.a(paramAnonymousView, bool);
          if (!NewVoipVideoFragment.i(NewVoipVideoFragment.this)) {
            NewVoipVideoFragment.j(NewVoipVideoFragment.this).setVisibility(8);
          }
          Toast.makeText(NewVoipVideoFragment.this.getActivity(), String.format("mIsShowFaceRect:%b", new Object[] { Boolean.valueOf(NewVoipVideoFragment.i(NewVoipVideoFragment.this)) }), 0).show();
          AppMethodBeat.o(192081);
          return;
        }
      }
    };
    this.zqS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192082);
        boolean bool2 = bt.a((Boolean)paramAnonymousView.getTag(), false);
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
          if ((NewVoipVideoFragment.this.zrd != null) && (NewVoipVideoFragment.this.zrd.get() != null)) {
            ((c)NewVoipVideoFragment.this.zrd.get()).dSG();
          }
          AppMethodBeat.o(192082);
          return;
          bool1 = false;
          break;
          label115:
          Toast.makeText(NewVoipVideoFragment.this.getActivity(), "start face detect", 0).show();
        }
      }
    };
    this.zqT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192085);
        ad.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
        NewVoipVideoFragment.o(NewVoipVideoFragment.this).setEnabled(false);
        NewVoipVideoFragment.p(NewVoipVideoFragment.this);
        NewVoipVideoFragment.o(NewVoipVideoFragment.this).setEnabled(true);
        if ((NewVoipVideoFragment.this.zrd != null) && (NewVoipVideoFragment.this.zrd.get() != null)) {
          ((c)NewVoipVideoFragment.this.zrd.get()).dSm();
        }
        AppMethodBeat.o(192085);
      }
    };
    this.zqU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192086);
        ad.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
        NewVoipVideoFragment.q(NewVoipVideoFragment.this);
        if ((NewVoipVideoFragment.this.getActivity() == null) || (NewVoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(192086);
          return;
        }
        if (NewVoipVideoFragment.r(NewVoipVideoFragment.this) > 0)
        {
          AppMethodBeat.o(192086);
          return;
        }
        NewVoipVideoFragment.o(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.s(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.t(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.a(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.b(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.d(NewVoipVideoFragment.this, false);
        AppMethodBeat.o(192086);
      }
    };
    this.oOz = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192087);
        if ((NewVoipVideoFragment.this.getActivity() == null) || (NewVoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(192087);
          return;
        }
        NewVoipVideoFragment.g(NewVoipVideoFragment.this).setVisibility(8);
        AppMethodBeat.o(192087);
      }
    };
    AppMethodBeat.o(192106);
  }
  
  private void Qx(int paramInt)
  {
    AppMethodBeat.i(192123);
    this.zrx.dWc();
    this.zpZ.setEnabled(false);
    this.zqd.setEnabled(false);
    this.zqc.setEnabled(false);
    this.zqb.setEnabled(false);
    this.zqa.setEnabled(false);
    this.zpY.setEnabled(false);
    this.zqe.setEnabled(false);
    this.zpX.setEnabled(false);
    this.zpW.setEnabled(false);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.zrw != null) {
        this.zrw.ao(true, false);
      }
      AppMethodBeat.o(192123);
      return;
      this.zpS.setVisibility(0);
      this.zpS.setText(2131764897);
    }
  }
  
  private void aKf()
  {
    AppMethodBeat.i(192124);
    if ((this.mTimer == null) || (this.nSO))
    {
      AppMethodBeat.o(192124);
      return;
    }
    if (-1L == this.zre) {
      this.zre = bt.aGK();
    }
    this.zqx = this.zre;
    this.nSO = true;
    TimerTask local9 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(192089);
        NewVoipVideoFragment.this.iDu.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(192088);
            String str = NewVoipVideoFragment.mz(bt.lZ(NewVoipVideoFragment.this.zre));
            NewVoipVideoFragment.t(NewVoipVideoFragment.this).setText(str);
            NewVoipVideoFragment.u(NewVoipVideoFragment.this);
            AppMethodBeat.o(192088);
          }
        });
        AppMethodBeat.o(192089);
      }
    };
    this.mTimer.schedule(local9, 1000L, 1000L);
    this.zqD = new av("VoipVideoFragment_cpuStatThread", new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(192090);
        if (NewVoipVideoFragment.v(NewVoipVideoFragment.this))
        {
          NewVoipVideoFragment.w(NewVoipVideoFragment.this);
          AppMethodBeat.o(192090);
          return true;
        }
        AppMethodBeat.o(192090);
        return false;
      }
    }, true);
    this.zqE = true;
    this.zqD.av(1000L, 1000L);
    AppMethodBeat.o(192124);
  }
  
  private void dVP()
  {
    AppMethodBeat.i(192109);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
    this.zqt += 1;
    this.iDu.postDelayed(this.zqU, 10000L);
    AppMethodBeat.o(192109);
  }
  
  private void dVS()
  {
    AppMethodBeat.i(192119);
    this.zpH.setVisibility(0);
    if (this.zrt != null) {
      dWb();
    }
    this.zpK.setVisibility(0);
    this.zpM.setVisibility(0);
    if ((af.aHH(this.flk)) && (!bt.ai(this.zpN.getText()))) {
      this.zpN.setVisibility(0);
    }
    for (;;)
    {
      this.zpO.setText(2131764876);
      this.zpQ.setVisibility(0);
      this.zpL.setVisibility(0);
      this.zrx.a(this.zpP, zrr);
      this.zqe.setVisibility(8);
      this.zqd.setVisibility(8);
      this.zpZ.setVisibility(8);
      this.zqc.setVisibility(8);
      this.zqb.setVisibility(0);
      this.zpY.setVisibility(0);
      this.zqa.setVisibility(0);
      this.zpX.setVisibility(8);
      if (this.zqw) {
        this.zpW.setVisibility(0);
      }
      this.zpT.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.dRQ().zhw != null)
      {
        this.zpT.setVisibility(0);
        this.zpT.setText(com.tencent.mm.plugin.voip.c.dRQ().zhw);
      }
      if (ae.fFw.fAY == 1)
      {
        this.zpJ.setVisibility(0);
        this.zpH.setVisibility(4);
      }
      AppMethodBeat.o(192119);
      return;
      this.zpN.setVisibility(8);
    }
  }
  
  private void dVT()
  {
    AppMethodBeat.i(192120);
    this.zpQ.setVisibility(0);
    this.zpH.setVisibility(0);
    this.zpO.setText(2131764874);
    if ((af.aHH(this.flk)) && (!bt.ai(this.zpN.getText()))) {
      this.zpN.setVisibility(0);
    }
    for (;;)
    {
      this.zrs.setVisibility(8);
      this.zpS.setVisibility(8);
      this.zpT.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.dRQ().zhw != null)
      {
        this.zpT.setVisibility(0);
        this.zpT.setText(com.tencent.mm.plugin.voip.c.dRQ().zhw);
      }
      this.zrx.a(this.zpP, zrr);
      this.zqe.setVisibility(8);
      this.zqd.setVisibility(8);
      this.zpZ.setVisibility(0);
      this.zqc.setVisibility(8);
      this.zqb.setVisibility(8);
      this.zpY.setVisibility(8);
      this.zqa.setVisibility(8);
      this.zpX.setVisibility(0);
      this.zpW.setVisibility(8);
      AppMethodBeat.o(192120);
      return;
      this.zpN.setVisibility(8);
    }
  }
  
  private void dVU()
  {
    boolean bool2 = true;
    AppMethodBeat.i(192121);
    if (this.zrt != null) {
      this.zrt.setVisibility(8);
    }
    if (this.zpI == null)
    {
      AppMethodBeat.o(192121);
      return;
    }
    if (this.zpI.getVisibility() == 0)
    {
      AppMethodBeat.o(192121);
      return;
    }
    label85:
    Point localPoint;
    if (this.zgY) {
      if (!this.zqu)
      {
        bool1 = true;
        this.zqu = bool1;
        if (this.zqu) {
          break label425;
        }
        bool1 = true;
        localPoint = rK(bool1);
        this.zpI.hW(localPoint.x, localPoint.y);
        if (ab.hWp)
        {
          this.zqf.setVisibility(0);
          this.zqg.setVisibility(0);
          this.zqh.setVisibility(0);
          this.zqi.setVisibility(0);
          this.zqj.setVisibility(0);
          this.zqk.setVisibility(0);
        }
        this.zpK.setVisibility(8);
        this.zpH.setVisibility(0);
        this.zpI.setVisibility(0);
        this.zpR.setVisibility(0);
        this.zpV.setVisibility(0);
        this.zqe.setVisibility(0);
        this.zqd.setVisibility(0);
        this.zpZ.setVisibility(8);
        this.zqc.setVisibility(0);
        this.zqb.setVisibility(8);
        this.zpY.setVisibility(8);
        this.zqa.setVisibility(8);
        this.zpX.setVisibility(8);
        this.zpW.setVisibility(8);
        ((c)this.zrd.get()).ru(this.zqu);
        ad.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", new Object[] { Integer.valueOf(this.zqz) });
        if (this.zqu) {
          break label452;
        }
      }
    }
    label425:
    label452:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPoint = rK(bool1);
      ((NewMovableVideoView)this.zpI).hU(localPoint.x, localPoint.y);
      aKf();
      if (aj.eFE().getBoolean("voipfaceDebug", false))
      {
        this.zqm.setVisibility(0);
        this.zqn.setVisibility(0);
      }
      dVP();
      if (this.zru == 4102) {
        hT(2131764783, 10000);
      }
      AppMethodBeat.o(192121);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label85;
      if (!this.zqu) {}
      for (bool1 = true;; bool1 = false)
      {
        this.zqu = bool1;
        break;
      }
    }
  }
  
  private void dVV()
  {
    AppMethodBeat.i(192122);
    this.zpO.setText(2131764949);
    this.zrx.a(this.zpP, zrr);
    AppMethodBeat.o(192122);
  }
  
  private void dVW()
  {
    AppMethodBeat.i(192125);
    View.OnClickListener local11 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(192091);
        com.tencent.mm.plugin.report.service.h.vKh.f(11079, new Object[] { Integer.valueOf(4) });
        if ((!NewVoipVideoFragment.k(NewVoipVideoFragment.this)) && (NewVoipVideoFragment.this.zrd.get() != null)) {
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
          if (ab.hWp)
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
          AppMethodBeat.o(192091);
          return;
          i = 0;
          break;
        }
      }
    };
    this.vHU.setOnClickListener(local11);
    AppMethodBeat.o(192125);
  }
  
  private void rI(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(192111);
    if (!this.zqH)
    {
      if (!paramBoolean) {
        break label115;
      }
      ((c)this.zrd.get()).a(this.zpI, 1);
      ((c)this.zrd.get()).a(this.zpH, 0);
    }
    for (;;)
    {
      c localc = (c)this.zrd.get();
      paramBoolean = bool;
      if (260 != this.mStatus)
      {
        paramBoolean = bool;
        if (6 != this.mStatus) {
          paramBoolean = true;
        }
      }
      localc.al(true, paramBoolean);
      this.zqH = true;
      AppMethodBeat.o(192111);
      return;
      label115:
      ((c)this.zrd.get()).a(this.zpI, 0);
      ((c)this.zrd.get()).a(this.zpH, 1);
    }
  }
  
  private Point rK(boolean paramBoolean)
  {
    AppMethodBeat.i(192127);
    int i = (int)(getActivity().getWindowManager().getDefaultDisplay().getHeight() / 5.0D);
    float f = i;
    com.tencent.mm.plugin.voip.c.dRQ();
    Point localPoint = new Point((int)(f * u.rF(paramBoolean)), i);
    AppMethodBeat.o(192127);
    return localPoint;
  }
  
  public final void Qv(int paramInt)
  {
    this.zqz = paramInt;
  }
  
  public final void Qw(int paramInt)
  {
    this.zqA = paramInt;
  }
  
  protected final void atj(String paramString)
  {
    AppMethodBeat.i(192114);
    if (this.zpT != null)
    {
      this.zpT.setVisibility(0);
      this.zpT.setText(paramString);
    }
    AppMethodBeat.o(192114);
  }
  
  public final void dVN()
  {
    this.nSM += 1;
  }
  
  public final void dVO()
  {
    this.zqq += 1;
  }
  
  protected final void dVQ()
  {
    AppMethodBeat.i(192117);
    if (this.sKW != null)
    {
      this.sKW.clearAnimation();
      this.sKW.setVisibility(8);
    }
    AppMethodBeat.o(192117);
  }
  
  public final void dVR()
  {
    AppMethodBeat.i(192118);
    VoIPRenderSurfaceView localVoIPRenderSurfaceView = this.zpH;
    ad.i("RenderView", "new size from resource Helper w %s * h  %s", new Object[] { Integer.valueOf(com.tencent.mm.cd.a.hV(localVoIPRenderSurfaceView.getContext())), Integer.valueOf(com.tencent.mm.cd.a.hW(localVoIPRenderSurfaceView.getContext())) });
    int i = com.tencent.mm.cd.a.hV(localVoIPRenderSurfaceView.getContext());
    int j = com.tencent.mm.cd.a.hW(localVoIPRenderSurfaceView.getContext());
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
      if (this.zpI != null)
      {
        localObject = (NewMovableVideoView)this.zpI;
        ad.i("MicroMsg.MovableVideoView", "refrsh view %s, %s", new Object[] { Integer.valueOf(((NewMovableVideoView)localObject).mWidth), Integer.valueOf(((NewMovableVideoView)localObject).zuV) });
        ((NewMovableVideoView)localObject).mScreenWidth = 0;
        ((NewMovableVideoView)localObject).hU(((NewMovableVideoView)localObject).mWidth, ((NewMovableVideoView)localObject).zuV);
      }
      AppMethodBeat.o(192118);
      return;
      f = j / i;
      break;
      label199:
      localObject = new RelativeLayout.LayoutParams(j * 9 / 16, j);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
    }
  }
  
  public final void hS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192110);
    super.hS(paramInt1, paramInt2);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + i.QI(paramInt2));
    if (this.vHU == null)
    {
      ad.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
      AppMethodBeat.o(192110);
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
        if ((ae.fFw.fAY == 1) && (paramInt1 != 0)) {
          this.zpJ.setVisibility(8);
        }
        AppMethodBeat.o(192110);
        return;
        this.zqG = true;
        rI(true);
        dVT();
        paramInt1 = 1;
        continue;
        this.zqG = true;
        rI(true);
        dVS();
        paramInt1 = 0;
        continue;
        dVW();
        if (this.zqG)
        {
          ((c)this.zrd.get()).dSo();
          com.tencent.mm.plugin.voip.b.f.rQ(false);
          this.zqG = false;
        }
        for (;;)
        {
          dVU();
          paramInt1 = 1;
          break;
          rI(false);
        }
        Qx(paramInt1);
        paramInt1 = 1;
      }
      dVV();
    }
  }
  
  protected final void hT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192115);
    if (this.zpS == null)
    {
      AppMethodBeat.o(192115);
      return;
    }
    this.zpS.setText(paramInt1);
    this.zpS.setVisibility(0);
    this.zpS.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.zpS.setBackgroundResource(2131234591);
    this.zpS.setCompoundDrawables(null, null, null, null);
    this.zpS.setCompoundDrawablePadding(0);
    this.iDu.removeCallbacks(this.oOz);
    if (-1 != paramInt2) {
      this.iDu.postDelayed(this.oOz, paramInt2);
    }
    AppMethodBeat.o(192115);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(192107);
    this.vHU = ((RelativeLayout)paramLayoutInflater.inflate(2131495882, paramViewGroup, false));
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)this.vHU.findViewById(2131304205)).setPadding(0, 0, 0, BackwardSupportUtil.b.g(getActivity(), 40.0F));
    }
    this.zrs = ((ImageView)this.vHU.findViewById(2131306556));
    this.zrt = ((ImageView)this.vHU.findViewById(2131306592));
    this.zpU = ((RelativeLayout)this.vHU.findViewById(2131301467));
    this.zpH = ((VoIPRenderSurfaceView)this.vHU.findViewById(2131297220));
    this.zpH.hX(mScreenWidth, mScreenHeight);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "steve: onCreateView!");
    this.zqe = ((VoipBigIconButton)this.vHU.findViewById(2131306588));
    this.zqe.setOnClickListener(this.zqT);
    this.zqd = ((VoipBigIconButton)this.vHU.findViewById(2131306604));
    this.zqd.setOnClickListener(this.zqJ);
    this.zpZ = ((VoipBigIconButton)this.vHU.findViewById(2131306557));
    this.zpZ.setOnClickListener(this.zqO);
    this.zqc = ((VoipBigIconButton)this.vHU.findViewById(2131306574));
    this.zqc.setOnClickListener(this.zqI);
    this.zqb = ((VoipBigIconButton)this.vHU.findViewById(2131306553));
    this.zqb.setOnClickListener(this.zqM);
    this.zpY = ((VoipSmallIconButton)this.vHU.findViewById(2131306554));
    this.zpY.setOnClickListener(this.zqL);
    this.zqa = ((VoipBigIconButton)this.vHU.findViewById(2131306585));
    this.zqa.setOnClickListener(this.zqN);
    this.zpX = ((VoipSmallIconButton)this.vHU.findViewById(2131306589));
    this.zpX.setOnClickListener(this.zqK);
    if (com.tencent.mm.plugin.voip.b.k.Bo("VOIPBlockIgnoreButton") == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.zqw = bool;
      this.zpW = ((VoipSmallIconButton)this.vHU.findViewById(2131306575));
      this.zpW.setOnClickListener(this.zqQ);
      if (!this.zqw) {
        this.zpW.setVisibility(8);
      }
      this.zpR = ((TextView)this.vHU.findViewById(2131306605));
      this.zpK = this.vHU.findViewById(2131306598);
      this.zpL = ((ImageView)this.vHU.findViewById(2131306597));
      a.b.a(this.zpL, this.flk, 0.0588235F, true);
      this.zpM = ((TextView)this.vHU.findViewById(2131306599));
      this.zpN = ((TextView)this.vHU.findViewById(2131306601));
      this.zpO = ((TextView)this.vHU.findViewById(2131306594));
      this.zpP = ((TextView)this.vHU.findViewById(2131306596));
      this.zpQ = this.vHU.findViewById(2131306595);
      t(this.zpP);
      this.zpS = ((TextView)this.vHU.findViewById(2131306593));
      this.zpT = ((TextView)this.vHU.findViewById(2131306603));
      this.zpV = ((Button)this.vHU.findViewById(2131297592));
      this.sKW = ((TextView)this.vHU.findViewById(2131306581));
      this.zpJ = ((ImageView)this.vHU.findViewById(2131300320));
      paramLayoutInflater = com.tencent.mm.ak.c.a(this.flk, false, -1, null);
      this.zpJ.setImageBitmap(com.tencent.mm.sdk.platformtools.f.l(paramLayoutInflater, 10));
      if (ab.hWp)
      {
        this.zqf = ((TextView)this.vHU.findViewById(2131306558));
        this.zqg = ((TextView)this.vHU.findViewById(2131306586));
        this.zqh = ((TextView)this.vHU.findViewById(2131306583));
        this.zqi = ((TextView)this.vHU.findViewById(2131306587));
        this.zqj = ((TextView)this.vHU.findViewById(2131306584));
        this.zqk = ((TextView)this.vHU.findViewById(2131299493));
      }
      this.zqm = ((Button)this.vHU.findViewById(2131306572));
      this.zqn = ((Button)this.vHU.findViewById(2131306573));
      this.zqm.setVisibility(8);
      this.zqn.setVisibility(8);
      this.zqm.setOnClickListener(this.zqR);
      this.zqn.setOnClickListener(this.zqS);
      this.zql = new e(getActivity());
      this.vHU.addView(this.zql);
      this.zql.setVisibility(8);
      this.zpV.setOnClickListener(this.zqP);
      int i = t.jA(getActivity());
      ad.d("MicroMsg.Voip.VoipVideoFragment", "statusHeight: ".concat(String.valueOf(i)));
      as(this.zpV, i);
      as(this.vHU.findViewById(2131306591), i);
      as(this.zpK, i);
      this.zqq = 0;
      this.zqp = 0;
      this.nSM = 0;
      this.zqr = 0;
      this.zqs = 0;
      this.zqB = 0;
      this.zqC = 0;
      paramLayoutInflater = (WindowManager)getActivity().getSystemService("window");
      i = paramLayoutInflater.getDefaultDisplay().getHeight() / 5;
      int j = paramLayoutInflater.getDefaultDisplay().getWidth() * i / paramLayoutInflater.getDefaultDisplay().getHeight();
      this.zpI = new NewMovableVideoView(aj.getContext());
      ((NewMovableVideoView)this.zpI).hU(j, i);
      this.zpI.setVisibility(4);
      this.zpH.setVisibility(0);
      ad.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
      this.vHU.addView(this.zpI);
      this.zpI.setOnClickListener(new View.OnClickListener()
      {
        long zqW = 0L;
        
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(192083);
          ad.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
          this.zqW = bt.GC();
          paramAnonymousView = NewVoipVideoFragment.this;
          if (!NewVoipVideoFragment.k(NewVoipVideoFragment.this))
          {
            bool = true;
            NewVoipVideoFragment.b(paramAnonymousView, bool);
            ((c)NewVoipVideoFragment.this.zrd.get()).dSo();
            com.tencent.mm.plugin.voip.b.f.rQ(true);
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
              NewVoipVideoFragment.l(NewVoipVideoFragment.this).hW(paramAnonymousView.x, paramAnonymousView.y);
            }
            com.tencent.mm.plugin.report.service.h.vKh.f(11079, new Object[] { Integer.valueOf(3) });
            AppMethodBeat.o(192083);
            return;
            bool = false;
            break;
          }
        }
      });
      paramLayoutInflater = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.flk);
      this.zpM.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getActivity(), v.b(paramLayoutInflater, this.flk), this.zpM.getTextSize()));
      paramLayoutInflater = com.tencent.mm.openim.room.a.a.G(paramLayoutInflater);
      if (!bt.isNullOrNil(paramLayoutInflater)) {
        this.zpN.setText(paramLayoutInflater);
      }
      if (this.zgY) {
        this.iDu.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(192084);
            NewVoipVideoFragment.m(NewVoipVideoFragment.this).setText(2131764874);
            NewVoipVideoFragment.this.zrx.a(NewVoipVideoFragment.n(NewVoipVideoFragment.this), VoipBaseFragment.zrr);
            AppMethodBeat.o(192084);
          }
        }, 2000L);
      }
      this.mTimer = new Timer("VoIP_video_talking_count");
      ad.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", new Object[] { Integer.valueOf(this.zqA) });
      this.zqv = true;
      ((c)this.zrd.get()).dSp();
      hS(0, this.mStatus);
      this.zqF = ((PowerManager)aj.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipVideoFragment");
      this.zqF.acquire();
      ad.i("MicroMsg.Voip.VoipVideoFragment", "acquire wakelock");
      paramLayoutInflater = this.vHU;
      AppMethodBeat.o(192107);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(192108);
    this.nSO = false;
    ad.i("MicroMsg.Voip.VoipVideoFragment", "onDestory");
    super.onDestroy();
    if ((this.zqF != null) && (this.zqF.isHeld()))
    {
      ad.i("MicroMsg.Voip.VoipVideoFragment", "release waklock");
      this.zqF.release();
    }
    AppMethodBeat.o(192108);
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(192113);
    super.onDestroyView();
    if (this.zpH != null)
    {
      this.zpH.setVisibility(8);
      this.zpH = null;
    }
    AppMethodBeat.o(192113);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(192126);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "onDetach");
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    if (this.zqD != null) {
      this.zqD.stopTimer();
    }
    this.zqE = false;
    super.onDetach();
    AppMethodBeat.o(192126);
  }
  
  protected final void rJ(boolean paramBoolean)
  {
    AppMethodBeat.i(192116);
    if (this.sKW != null)
    {
      if (!paramBoolean) {
        break label49;
      }
      this.sKW.setText(2131764892);
    }
    for (;;)
    {
      this.sKW.clearAnimation();
      this.sKW.setVisibility(0);
      AppMethodBeat.o(192116);
      return;
      label49:
      this.sKW.setText(2131764891);
    }
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt) {}
  
  public final void uninit()
  {
    AppMethodBeat.i(192112);
    ad.m("MicroMsg.Voip.VoipVideoFragment", "unit should not be allow in foreground", new Object[0]);
    if ((this.zpH != null) && (this.zrd.get() != null)) {
      this.zpH.release();
    }
    if (this.zrd.get() != null)
    {
      ((c)this.zrd.get()).a(this.zpH);
      ((c)this.zrd.get()).a(this.zpI);
    }
    if (this.zpI != null)
    {
      this.zpI.release();
      this.zpI.setVisibility(4);
      this.zpI = null;
    }
    if (this.zqy != null)
    {
      this.zqy.cancel();
      this.zqy = null;
    }
    super.uninit();
    AppMethodBeat.o(192112);
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
      AppMethodBeat.i(192105);
      ad.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
      final Bitmap localBitmap = NewVoipVideoFragment.D(this.zqV);
      this.zqV.iDu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(192104);
          if (NewVoipVideoFragment.a.this.zqV.zrs != null) {
            NewVoipVideoFragment.a.this.zqV.zrs.setBackgroundDrawable(new BitmapDrawable(localBitmap));
          }
          NewVoipVideoFragment.E(NewVoipVideoFragment.a.this.zqV);
          AppMethodBeat.o(192104);
        }
      });
      AppMethodBeat.o(192105);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment
 * JD-Core Version:    0.7.0.1
 */