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
import com.tencent.mm.plugin.voip.b.i;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.t;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class VoipVideoFragment
  extends VoipBaseFragment
{
  private long lrz;
  private Timer mTimer;
  private int nSM;
  private boolean nSO;
  private Runnable oOz;
  private TextView sKW;
  private SurfaceTexture surfaceTexture;
  int[] tPJ;
  Bitmap tPZ;
  private Bitmap vkz;
  public int zhL;
  public int zhM;
  private CaptureView zlf;
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
  public int zqz;
  private OpenGlView zsh;
  private OpenGlView zsi;
  private OpenGlRender zsj;
  private OpenGlRender zsk;
  private VoIPVideoView zsl;
  private a zsm;
  private d zsn;
  int zso;
  
  public VoipVideoFragment()
  {
    AppMethodBeat.i(115420);
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
    this.zhL = 0;
    this.zhM = 0;
    this.surfaceTexture = null;
    this.zqI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115394);
        ad.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
        if ((VoipVideoFragment.this.zrd != null) && (VoipVideoFragment.this.zrd.get() != null) && (((c)VoipVideoFragment.this.zrd.get()).dSa()))
        {
          VoipVideoFragment.a(VoipVideoFragment.this).setEnabled(false);
          VoipVideoFragment.b(VoipVideoFragment.this).setEnabled(false);
          VoipVideoFragment.this.hT(2131764857, -1);
        }
        AppMethodBeat.o(115394);
      }
    };
    this.zqJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115406);
        if ((VoipVideoFragment.this.zrd != null) && (VoipVideoFragment.this.zrd.get() != null)) {
          ((c)VoipVideoFragment.this.zrd.get()).dSs();
        }
        AppMethodBeat.o(115406);
      }
    };
    this.zqK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115407);
        if ((VoipVideoFragment.this.zrd != null) && (VoipVideoFragment.this.zrd.get() != null)) {
          ((c)VoipVideoFragment.this.zrd.get()).dSs();
        }
        AppMethodBeat.o(115407);
      }
    };
    this.zqL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115410);
        ad.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
        if ((ay.isWifi(VoipVideoFragment.this.getActivity())) || (s.dTX()))
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
            s.dTW();
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
    this.zqM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115413);
        ad.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
        if ((ay.isWifi(VoipVideoFragment.this.getActivity())) || ((s.dTX()) && (!ay.is2G(VoipVideoFragment.this.getActivity()))))
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
            if (!ay.is2G(VoipVideoFragment.this.getActivity())) {
              s.dTW();
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
    this.zqN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115414);
        ad.i("MicroMsg.Voip.VoipVideoFragment", "click reject video invite button");
        VoipVideoFragment.d(VoipVideoFragment.this);
        AppMethodBeat.o(115414);
      }
    };
    this.zqO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115415);
        ad.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
        if ((VoipVideoFragment.this.zrd != null) && (VoipVideoFragment.this.zrd.get() != null) && (((c)VoipVideoFragment.this.zrd.get()).dSh()))
        {
          VoipVideoFragment.a(VoipVideoFragment.this).setEnabled(false);
          VoipVideoFragment.f(VoipVideoFragment.this).setEnabled(false);
          VoipVideoFragment.g(VoipVideoFragment.this).setVisibility(0);
          VoipVideoFragment.g(VoipVideoFragment.this).setText(2131764813);
        }
        AppMethodBeat.o(115415);
      }
    };
    this.zqP = new View.OnClickListener()
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
        com.tencent.mm.plugin.report.service.h.vKh.f(11618, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
        if ((VoipVideoFragment.this.zrd != null) && (VoipVideoFragment.this.zrd.get() != null)) {
          ((c)VoipVideoFragment.this.zrd.get()).rv(true);
        }
        if (VoipVideoFragment.this.zrw != null)
        {
          VoipVideoFragment.this.dVY();
          VoipVideoFragment.this.zrw.ao(false, true);
        }
        AppMethodBeat.o(115416);
      }
    };
    this.zqQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115417);
        com.tencent.mm.plugin.report.service.h.vKh.f(11619, new Object[] { Integer.valueOf(2) });
        if ((VoipVideoFragment.this.zrd != null) && (VoipVideoFragment.this.zrd.get() != null)) {
          ((c)VoipVideoFragment.this.zrd.get()).dSF();
        }
        AppMethodBeat.o(115417);
      }
    };
    this.zqR = new View.OnClickListener()
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
    this.zqS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115396);
        boolean bool2 = bt.a((Boolean)paramAnonymousView.getTag(), false);
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
          if ((VoipVideoFragment.this.zrd != null) && (VoipVideoFragment.this.zrd.get() != null)) {
            ((c)VoipVideoFragment.this.zrd.get()).dSG();
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
    this.zqT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192151);
        ad.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
        VoipVideoFragment.o(VoipVideoFragment.this).setEnabled(false);
        VoipVideoFragment.p(VoipVideoFragment.this);
        VoipVideoFragment.o(VoipVideoFragment.this).setEnabled(true);
        if ((VoipVideoFragment.this.zrd != null) && (VoipVideoFragment.this.zrd.get() != null)) {
          ((c)VoipVideoFragment.this.zrd.get()).dSm();
        }
        AppMethodBeat.o(192151);
      }
    };
    this.zqU = new Runnable()
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
    this.oOz = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192152);
        if ((VoipVideoFragment.this.getActivity() == null) || (VoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(192152);
          return;
        }
        VoipVideoFragment.g(VoipVideoFragment.this).setVisibility(8);
        AppMethodBeat.o(192152);
      }
    };
    this.tPJ = null;
    this.zso = 0;
    this.tPZ = null;
    AppMethodBeat.o(115420);
  }
  
  private void Qx(int paramInt)
  {
    AppMethodBeat.i(115448);
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
      AppMethodBeat.o(115448);
      return;
      this.zpS.setVisibility(0);
      this.zpS.setText(2131764897);
    }
  }
  
  private void aKf()
  {
    AppMethodBeat.i(115449);
    if ((this.mTimer == null) || (this.nSO))
    {
      AppMethodBeat.o(115449);
      return;
    }
    if (-1L == this.zre) {
      this.zre = bt.aGK();
    }
    this.zqx = this.zre;
    this.nSO = true;
    TimerTask local11 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(192154);
        VoipVideoFragment.this.iDu.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(192153);
            String str = VoipVideoFragment.mz(bt.lZ(VoipVideoFragment.this.zre));
            VoipVideoFragment.t(VoipVideoFragment.this).setText(str);
            VoipVideoFragment.u(VoipVideoFragment.this);
            AppMethodBeat.o(192153);
          }
        });
        AppMethodBeat.o(192154);
      }
    };
    this.mTimer.schedule(local11, 1000L, 1000L);
    this.zqD = new av("VoipVideoFragment_cpuStatThread", new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(192155);
        if (VoipVideoFragment.v(VoipVideoFragment.this))
        {
          VoipVideoFragment.w(VoipVideoFragment.this);
          AppMethodBeat.o(192155);
          return true;
        }
        AppMethodBeat.o(192155);
        return false;
      }
    }, true);
    this.zqE = true;
    this.zqD.av(1000L, 1000L);
    AppMethodBeat.o(115449);
  }
  
  private void b(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115451);
    if ((this.vHU == null) || (paramCaptureView == null))
    {
      AppMethodBeat.o(115451);
      return;
    }
    if ((paramCaptureView.getParent() != null) && ((paramCaptureView.getParent() instanceof ViewGroup))) {
      ((ViewGroup)this.zlf.getParent()).removeView(this.zlf);
    }
    this.vHU.removeView(this.zlf);
    this.zlf = null;
    if (paramCaptureView.getParent() != null) {
      ((ViewGroup)paramCaptureView.getParent()).removeAllViews();
    }
    this.zlf = paramCaptureView;
    this.vHU.addView(paramCaptureView, new RelativeLayout.LayoutParams(1, 1));
    this.zlf.setVisibility(0);
    this.zlf.setAlpha(0.0F);
    ad.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView added");
    AppMethodBeat.o(115451);
  }
  
  private void dVP()
  {
    AppMethodBeat.i(115427);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
    this.zqt += 1;
    this.iDu.postDelayed(this.zqU, 10000L);
    AppMethodBeat.o(115427);
  }
  
  private void dVS()
  {
    AppMethodBeat.i(115438);
    this.zsh.setVisibility(0);
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
        this.zsh.setVisibility(4);
      }
      AppMethodBeat.o(115438);
      return;
      this.zpN.setVisibility(8);
    }
  }
  
  private void dVT()
  {
    AppMethodBeat.i(115439);
    this.zpQ.setVisibility(0);
    this.zsh.setVisibility(0);
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
      AppMethodBeat.o(115439);
      return;
      this.zpN.setVisibility(8);
    }
  }
  
  private void dVU()
  {
    boolean bool2 = true;
    AppMethodBeat.i(115440);
    if (this.zrt != null) {
      this.zrt.setVisibility(8);
    }
    if (!this.zsi.zvY)
    {
      AppMethodBeat.o(115440);
      return;
    }
    this.zsi.rV(false);
    label79:
    Point localPoint;
    if (this.zgY) {
      if (!this.zqu)
      {
        bool1 = true;
        this.zqu = bool1;
        if (this.zqu) {
          break label408;
        }
        bool1 = true;
        localPoint = rK(bool1);
        this.zsi.hW(localPoint.x, localPoint.y);
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
        this.zsh.setVisibility(0);
        this.zsi.setVisibility(0);
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
        setHWDecMode(this.zqz);
        ad.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", new Object[] { Integer.valueOf(this.zqz) });
        if (this.zqu) {
          break label444;
        }
      }
    }
    label408:
    label444:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPoint = rK(bool1);
      ((MovableVideoView)this.zsi).hU(localPoint.x, localPoint.y);
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
      AppMethodBeat.o(115440);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label79;
      if (!this.zqu) {}
      for (bool1 = true;; bool1 = false)
      {
        this.zqu = bool1;
        this.zsl.setVisibility(8);
        break;
      }
    }
  }
  
  private void dVV()
  {
    AppMethodBeat.i(115447);
    this.zpO.setText(2131764949);
    this.zrx.a(this.zpP, zrr);
    AppMethodBeat.o(115447);
  }
  
  private void dVW()
  {
    AppMethodBeat.i(115450);
    View.OnClickListener local14 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(192156);
        com.tencent.mm.plugin.report.service.h.vKh.f(11079, new Object[] { Integer.valueOf(4) });
        if ((!VoipVideoFragment.k(VoipVideoFragment.this)) && (VoipVideoFragment.this.zrd.get() != null)) {
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
          if (ab.hWp)
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
          AppMethodBeat.o(192156);
          return;
          i = 0;
          break;
        }
      }
    };
    this.vHU.setOnClickListener(local14);
    AppMethodBeat.o(115450);
  }
  
  private Point rK(boolean paramBoolean)
  {
    AppMethodBeat.i(115454);
    int i = (int)(getActivity().getWindowManager().getDefaultDisplay().getHeight() / 5.0D);
    float f = i;
    com.tencent.mm.plugin.voip.c.dRQ();
    Point localPoint = new Point((int)(f * u.rF(paramBoolean)), i);
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
    this.zsn = paramd;
    if ((!this.zqv) || (this.zsk == null) || (this.zsj == null))
    {
      ad.i("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture failed , texId:%d,mInitDone:%b", new Object[] { Integer.valueOf(paramd.gro), Boolean.valueOf(this.zqv) });
      AppMethodBeat.o(115426);
      return;
    }
    this.zsk.a(this.surfaceTexture, paramd);
    this.zsj.a(this.surfaceTexture, paramd);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture OK , videoTexture:%d", new Object[] { Integer.valueOf(paramd.gro) });
    AppMethodBeat.o(115426);
  }
  
  public final void a(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115429);
    this.zlf = paramCaptureView;
    b(this.zlf);
    AppMethodBeat.o(115429);
  }
  
  protected final void atj(String paramString)
  {
    AppMethodBeat.i(115433);
    if (this.zpT != null)
    {
      this.zpT.setVisibility(0);
      this.zpT.setText(paramString);
    }
    AppMethodBeat.o(115433);
  }
  
  public final void b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(192157);
    if (!this.zqv)
    {
      AppMethodBeat.o(192157);
      return;
    }
    if (OpenGlRender.zvx == 1)
    {
      if (this.zso < paramInt1 * paramInt2) {
        this.tPJ = null;
      }
      if (this.tPJ == null)
      {
        this.zso = (paramInt1 * paramInt2);
        this.tPJ = new int[this.zso];
      }
      if ((com.tencent.mm.plugin.voip.c.dRQ().a(paramArrayOfByte, (int)paramLong, paramInt3 & 0x1F, paramInt1, paramInt2, this.tPJ, true) < 0) || (this.tPJ == null))
      {
        AppMethodBeat.o(192157);
        return;
      }
      if (this.zqu) {
        this.zsj.a(this.tPJ, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      }
    }
    for (;;)
    {
      this.zqq += 1;
      this.zqp += 1;
      paramArrayOfByte = this.zql;
      paramArrayOfByte.zuv = paramInt1;
      paramArrayOfByte.zuw = paramInt2;
      paramArrayOfByte = this.zql;
      paramInt1 = this.vHU.getWidth();
      paramInt2 = this.vHU.getHeight();
      paramArrayOfByte.zuu = paramInt1;
      paramArrayOfByte.pU = paramInt2;
      AppMethodBeat.o(192157);
      return;
      this.zsk.a(this.tPJ, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      continue;
      if (OpenGlRender.zvx == 2) {
        if (this.zqu) {
          this.zsj.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
        } else {
          this.zsk.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
        }
      }
    }
  }
  
  public final void dVK()
  {
    AppMethodBeat.i(115452);
    if (this.zlf != null)
    {
      this.vHU.removeView(this.zlf);
      this.vHU.addView(this.zlf, new RelativeLayout.LayoutParams(1, 1));
      this.zlf.setVisibility(0);
      this.zlf.setAlpha(0.0F);
      ad.i("MicroMsg.Voip.VoipVideoFragment", "resetCaptureView");
    }
    AppMethodBeat.o(115452);
  }
  
  protected final void dVQ()
  {
    AppMethodBeat.i(115436);
    if (this.sKW != null)
    {
      this.sKW.clearAnimation();
      this.sKW.setVisibility(8);
    }
    AppMethodBeat.o(115436);
  }
  
  public final void dVR()
  {
    AppMethodBeat.i(115437);
    OpenGlView localOpenGlView = this.zsh;
    ad.i(OpenGlView.TAG, "new size from resoureHelper w %s * h  %s", new Object[] { Integer.valueOf(com.tencent.mm.cd.a.hV(localOpenGlView.getContext())), Integer.valueOf(com.tencent.mm.cd.a.hW(localOpenGlView.getContext())) });
    int i = com.tencent.mm.cd.a.hV(localOpenGlView.getContext());
    int j = com.tencent.mm.cd.a.hW(localOpenGlView.getContext());
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
      if (this.zsi != null)
      {
        localObject = (MovableVideoView)this.zsi;
        ad.i("MicroMsg.MovableVideoView", "refrsh view %s, %s", new Object[] { Integer.valueOf(((MovableVideoView)localObject).mWidth), Integer.valueOf(((MovableVideoView)localObject).zuV) });
        ((MovableVideoView)localObject).mScreenWidth = 0;
        ((MovableVideoView)localObject).hU(((MovableVideoView)localObject).mWidth, ((MovableVideoView)localObject).zuV);
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
  
  public final void dVY()
  {
    AppMethodBeat.i(115444);
    if (!this.zqv)
    {
      AppMethodBeat.o(115444);
      return;
    }
    this.zsk.dXh();
    this.zsj.dXh();
    AppMethodBeat.o(115444);
  }
  
  public final OpenGlRender dVZ()
  {
    if (this.zqu) {
      return this.zsj;
    }
    return this.zsk;
  }
  
  public final void dWe()
  {
    AppMethodBeat.i(115425);
    if ((this.zsk != null) && (this.zsj != null))
    {
      if (!this.zqu) {
        break label119;
      }
      this.zsj.QR(0);
      if ((this.zqz & 0x1) == 0) {
        break label108;
      }
      this.zsk.QR(1);
    }
    for (;;)
    {
      ad.i("MicroMsg.Voip.VoipVideoFragment", "changeSurfaceRender, bigViewMode: %d, smallViewMode: %d,mIsSmallViewShowSelf:%b, after changeSurfaceRender", new Object[] { Integer.valueOf(this.zsk.zvF), Integer.valueOf(this.zsj.zvF), Boolean.valueOf(this.zqu) });
      AppMethodBeat.o(115425);
      return;
      label108:
      this.zsk.QR(0);
      continue;
      label119:
      this.zsk.QR(0);
      if ((this.zqz & 0x1) != 0) {
        this.zsj.QR(1);
      } else {
        this.zsj.QR(0);
      }
    }
  }
  
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115443);
    if (!this.zqv)
    {
      AppMethodBeat.o(115443);
      return;
    }
    this.nSM += 1;
    if (OpenGlRender.zvx == 1)
    {
      if (this.zqu)
      {
        this.zsk.g(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90);
        AppMethodBeat.o(115443);
        return;
      }
      this.zsj.g(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90);
      AppMethodBeat.o(115443);
      return;
    }
    if (this.zqu)
    {
      this.zsk.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
      AppMethodBeat.o(115443);
      return;
    }
    this.zsj.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
    AppMethodBeat.o(115443);
  }
  
  public final void hP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115446);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "adjustHWViewAspectRatio, mInitDone:%b, HWDecsize:%dx%d,  lastHWDecsize:%dx%d", new Object[] { Boolean.valueOf(this.zqv), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.zhL), Integer.valueOf(this.zhM) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(115446);
      return;
    }
    if ((this.zhL != paramInt1) || (this.zhM != paramInt2))
    {
      this.zhL = paramInt1;
      this.zhM = paramInt2;
    }
    if (this.zqv)
    {
      this.zsk.hP(paramInt1, paramInt2);
      this.zsj.hP(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115446);
  }
  
  public final void hS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115428);
    super.hS(paramInt1, paramInt2);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + i.QI(paramInt2));
    if (this.vHU == null)
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
        if ((ae.fFw.fAY == 1) && (paramInt1 != 0)) {
          this.zpJ.setVisibility(8);
        }
        AppMethodBeat.o(115428);
        return;
        dVT();
        paramInt1 = 1;
        continue;
        paramInt1 = 0;
        dVS();
        continue;
        dVW();
        dVU();
        paramInt1 = 1;
        continue;
        Qx(paramInt1);
        paramInt1 = 1;
      }
      dVV();
    }
  }
  
  protected final void hT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115434);
    if (this.zpS == null)
    {
      AppMethodBeat.o(115434);
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
    AppMethodBeat.o(115434);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(115421);
    this.vHU = ((RelativeLayout)paramLayoutInflater.inflate(2131495883, paramViewGroup, false));
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)this.vHU.findViewById(2131304205)).setPadding(0, 0, 0, BackwardSupportUtil.b.g(getActivity(), 40.0F));
    }
    this.zrs = ((ImageView)this.vHU.findViewById(2131306556));
    this.zrt = ((ImageView)this.vHU.findViewById(2131306592));
    this.zpU = ((RelativeLayout)this.vHU.findViewById(2131301467));
    this.zsh = ((OpenGlView)this.vHU.findViewById(2131297220));
    this.zsh.hV(mScreenWidth, mScreenHeight);
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
    if (com.tencent.mm.plugin.voip.b.k.Bo("VOIPBlockIgnoreButton") == 0)
    {
      bool = true;
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
      this.zpJ.setImageBitmap(f.l(paramLayoutInflater, 10));
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
      b(this.zlf);
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
      this.zsi = new MovableVideoView(getActivity().getApplicationContext());
      ((MovableVideoView)this.zsi).hU(j, i);
      this.zsi.setVisibility(0);
      this.zsi.rV(true);
      this.zsj = new OpenGlRender(this.zsi, OpenGlRender.RenderRemote);
      this.zsi.setRenderer(this.zsj);
      this.zsi.setRenderMode(0);
      this.zsj.zvN = new OpenGlRender.b()
      {
        public final void dWf() {}
        
        public final void uo(long paramAnonymousLong)
        {
          AppMethodBeat.i(192144);
          if ((VoipVideoFragment.this.zrd != null) && (VoipVideoFragment.this.zrd.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.zrd.get()).W(paramAnonymousLong, 2);
          }
          AppMethodBeat.o(192144);
        }
        
        public final void up(long paramAnonymousLong)
        {
          AppMethodBeat.i(192145);
          if ((VoipVideoFragment.this.zrd != null) && (VoipVideoFragment.this.zrd.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.zrd.get()).W(paramAnonymousLong, 0);
          }
          AppMethodBeat.o(192145);
        }
        
        public final void uq(long paramAnonymousLong)
        {
          AppMethodBeat.i(192146);
          if ((VoipVideoFragment.this.zrd != null) && (VoipVideoFragment.this.zrd.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.zrd.get()).W(paramAnonymousLong, 1);
          }
          AppMethodBeat.o(192146);
        }
      };
      this.zsk = new OpenGlRender(this.zsh, OpenGlRender.RenderLocal);
      this.zsh.setRenderer(this.zsk);
      this.zsh.setRenderMode(0);
      this.zsh.setVisibility(0);
      this.zsk.zvN = new OpenGlRender.b()
      {
        public final void dWf()
        {
          AppMethodBeat.i(192147);
          if ((VoipVideoFragment.this.zrd != null) && (VoipVideoFragment.this.zrd.get() != null)) {
            ((c)VoipVideoFragment.this.zrd.get()).W(0L, 3);
          }
          AppMethodBeat.o(192147);
        }
        
        public final void uo(long paramAnonymousLong)
        {
          AppMethodBeat.i(192148);
          if ((VoipVideoFragment.this.zrd != null) && (VoipVideoFragment.this.zrd.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.zrd.get()).W(paramAnonymousLong, 2);
          }
          AppMethodBeat.o(192148);
        }
        
        public final void up(long paramAnonymousLong)
        {
          AppMethodBeat.i(192149);
          if ((VoipVideoFragment.this.zrd != null) && (VoipVideoFragment.this.zrd.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.zrd.get()).W(paramAnonymousLong, 0);
          }
          AppMethodBeat.o(192149);
        }
        
        public final void uq(long paramAnonymousLong)
        {
          AppMethodBeat.i(192150);
          if ((VoipVideoFragment.this.zrd != null) && (VoipVideoFragment.this.zrd.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.zrd.get()).W(paramAnonymousLong, 1);
          }
          AppMethodBeat.o(192150);
        }
      };
      ad.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
      this.vHU.addView(this.zsi);
      this.zsi.setOnClickListener(new View.OnClickListener()
      {
        long zqW = 0L;
        
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(115399);
          ad.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
          if (bt.aS(this.zqW) < 400L)
          {
            ad.i("MicroMsg.Voip.VoipVideoFragment", "click mGlSmallVideoView too fast and not allow to response it,times%s", new Object[] { Long.valueOf(bt.aS(this.zqW)) });
            AppMethodBeat.o(115399);
            return;
          }
          this.zqW = bt.GC();
          paramAnonymousView = VoipVideoFragment.this;
          if (!VoipVideoFragment.k(VoipVideoFragment.this))
          {
            bool = true;
            VoipVideoFragment.b(paramAnonymousView, bool);
            VoipVideoFragment.this.dWe();
            paramAnonymousView = VoipVideoFragment.this;
            if (VoipVideoFragment.k(VoipVideoFragment.this)) {
              break label165;
            }
          }
          label165:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView = VoipVideoFragment.c(paramAnonymousView, bool);
            VoipVideoFragment.l(VoipVideoFragment.this).hW(paramAnonymousView.x, paramAnonymousView.y);
            com.tencent.mm.plugin.report.service.h.vKh.f(11079, new Object[] { Integer.valueOf(3) });
            AppMethodBeat.o(115399);
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
            AppMethodBeat.i(115400);
            VoipVideoFragment.m(VoipVideoFragment.this).setText(2131764874);
            VoipVideoFragment.this.zrx.a(VoipVideoFragment.n(VoipVideoFragment.this), VoipBaseFragment.zrr);
            AppMethodBeat.o(115400);
          }
        }, 2000L);
      }
      this.zsl = ((VoIPVideoView)this.vHU.findViewById(2131306590));
      this.mTimer = new Timer("VoIP_video_talking_count");
      ad.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", new Object[] { Integer.valueOf(this.zqA) });
      this.zsk.setVoipBeauty(this.zqA);
      this.zsj.setVoipBeauty(this.zqA);
      if ((this.zrd != null) && (this.zrd.get() != null))
      {
        paramLayoutInflater = (c)this.zrd.get();
        if ((260 == this.mStatus) || (6 == this.mStatus)) {
          break label1605;
        }
      }
    }
    label1605:
    for (boolean bool = true;; bool = false)
    {
      paramLayoutInflater.al(true, bool);
      this.zsk.zvL = true;
      this.zqv = true;
      hP(this.zhL, this.zhM);
      hS(0, this.mStatus);
      this.zqF = ((PowerManager)aj.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipVideoFragment");
      this.zqF.acquire();
      ad.i("MicroMsg.Voip.VoipVideoFragment", "acquire wakelock");
      paramLayoutInflater = this.vHU;
      AppMethodBeat.o(115421);
      return paramLayoutInflater;
      bool = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115422);
    this.nSO = false;
    ad.i("MicroMsg.Voip.VoipVideoFragment", "onDestory");
    super.onDestroy();
    if ((this.zqF != null) && (this.zqF.isHeld()))
    {
      ad.i("MicroMsg.Voip.VoipVideoFragment", "release waklock");
      this.zqF.release();
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
    if (this.zqD != null) {
      this.zqD.stopTimer();
    }
    this.zqE = false;
    super.onDetach();
    AppMethodBeat.o(115453);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(115432);
    this.zsk.onStarted();
    this.zsj.onStarted();
    super.onStart();
    AppMethodBeat.o(115432);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(115431);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "onStop");
    this.zsk.dXg();
    this.zsj.dXg();
    super.onStop();
    AppMethodBeat.o(115431);
  }
  
  protected final void rJ(boolean paramBoolean)
  {
    AppMethodBeat.i(115435);
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
      AppMethodBeat.o(115435);
      return;
      label49:
      this.sKW.setText(2131764891);
    }
  }
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115424);
    this.zsk.releaseSurfaceTexture();
    this.zsj.releaseSurfaceTexture();
    AppMethodBeat.o(115424);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115423);
    if (this.zqu)
    {
      this.zsh.zuE.requestRender();
      AppMethodBeat.o(115423);
      return;
    }
    this.zsi.zuE.requestRender();
    AppMethodBeat.o(115423);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115442);
    this.zqz = paramInt;
    if ((this.zsi == null) || (this.zsi.zvY))
    {
      AppMethodBeat.o(115442);
      return;
    }
    ad.i("MicroMsg.Voip.VoipVideoFragment", "setHWDecMode, hwdec: %d, mIsSmallViewShowSelf:%b, before changeSurfaceRender", new Object[] { Integer.valueOf(this.zqz), Boolean.valueOf(this.zqu) });
    dWe();
    AppMethodBeat.o(115442);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt) {}
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115445);
    ad.i("MicroMsg.Voip.VoipVideoFragment", "setVoipBeauty isON:%d, mInitDone:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.zqv) });
    this.zqA = paramInt;
    if (!this.zqv)
    {
      AppMethodBeat.o(115445);
      return;
    }
    this.zsk.setVoipBeauty(this.zqA);
    this.zsj.setVoipBeauty(this.zqA);
    AppMethodBeat.o(115445);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115430);
    ad.m("MicroMsg.Voip.VoipVideoFragment", "unit should not be allow in foreground", new Object[0]);
    if (this.zsi != null) {
      this.zsi.setVisibility(4);
    }
    if (this.zlf != null)
    {
      this.vHU.removeView(this.zlf);
      this.zlf = null;
      ad.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView removed");
    }
    if (this.zsm != null)
    {
      this.zsm.cancel();
      this.zsm = null;
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
      ad.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
      final Bitmap localBitmap = VoipVideoFragment.D(this.zsp);
      this.zsp.iDu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115418);
          if (VoipVideoFragment.a.this.zsp.zrs != null) {
            VoipVideoFragment.a.this.zsp.zrs.setBackgroundDrawable(new BitmapDrawable(localBitmap));
          }
          VoipVideoFragment.E(VoipVideoFragment.a.this.zsp);
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