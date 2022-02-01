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
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.video.GLTextureView;
import com.tencent.mm.plugin.voip.video.GLTextureView.i;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlRender.b;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.plugin.voip.widget.VoIPVideoView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class VoipVideoFragment
  extends VoipBaseFragment
{
  private Bitmap BQT;
  public int GUK;
  public int GUL;
  private com.tencent.mm.media.g.d GgP;
  private ImageView HcP;
  private View HcQ;
  private ImageView HcR;
  private TextView HcS;
  private TextView HcT;
  private TextView HcU;
  private TextView HcV;
  private View HcW;
  private TextView HcX;
  private TextView HcY;
  private TextView HcZ;
  private int HdA;
  private int HdB;
  private int HdF;
  private boolean HdG;
  private boolean HdH;
  public long HdI;
  public int HdK;
  public int HdL;
  private int HdM;
  private int HdN;
  private MTimerHandler HdO;
  private boolean HdP;
  private View.OnClickListener HdS;
  private View.OnClickListener HdT;
  private View.OnClickListener HdU;
  private View.OnClickListener HdV;
  private View.OnClickListener HdW;
  private View.OnClickListener HdX;
  private View.OnClickListener HdY;
  private View.OnClickListener HdZ;
  private RelativeLayout Hda;
  private Button Hdb;
  private WeImageView Hdc;
  private VoipSmallIconButton Hdd;
  private VoipSmallIconButton Hde;
  private VoipSmallIconButton Hdf;
  private VoipBigIconButton Hdg;
  private VoipBigIconButton Hdh;
  private VoipBigIconButton Hdi;
  private VoipBigIconButton Hdj;
  private VoipBigIconButton Hdk;
  private VoipBigIconButton Hdl;
  private TextView Hdm;
  private TextView Hdn;
  private TextView Hdo;
  private TextView Hdp;
  private TextView Hdq;
  private TextView Hdr;
  private com.tencent.mm.plugin.voip.video.d Hdu;
  private Button Hdv;
  private Button Hdw;
  private boolean Hdx;
  private int Hdy;
  private int Hdz;
  private View.OnClickListener Hea;
  private View.OnClickListener Heb;
  private View.OnClickListener Hec;
  private View.OnClickListener Hed;
  private Runnable Hee;
  private OpenGlView Hfn;
  private OpenGlView Hfo;
  private OpenGlRender Hfp;
  private OpenGlRender Hfq;
  private VoIPVideoView Hfr;
  private a Hfs;
  public int Hft;
  int Hfu;
  Bitmap Hfv;
  private PowerManager.WakeLock hCN;
  private Timer mTimer;
  private long nJh;
  private CaptureView qsJ;
  private boolean qsM;
  private int qvm;
  private boolean qvo;
  private Runnable rtb;
  private SurfaceTexture surfaceTexture;
  private TextView yzB;
  int[] zLY;
  
  public VoipVideoFragment()
  {
    AppMethodBeat.i(115420);
    this.Hdu = null;
    this.Hdv = null;
    this.Hdw = null;
    this.Hdx = false;
    this.HdF = 0;
    this.HdG = false;
    this.qvo = false;
    this.qsM = false;
    this.HdI = 0L;
    this.BQT = null;
    this.HdK = 0;
    this.HdL = 0;
    this.Hft = 0;
    this.HdM = 0;
    this.nJh = 0L;
    this.HdN = 0;
    this.HdO = null;
    this.HdP = false;
    this.GUK = 0;
    this.GUL = 0;
    this.surfaceTexture = null;
    this.HdS = new VoipVideoFragment.1(this);
    this.HdT = new VoipVideoFragment.12(this);
    this.HdU = new VoipVideoFragment.16(this);
    this.HdV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115410);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
        if ((NetStatusUtil.isWifi(VoipVideoFragment.this.getActivity())) || (s.fHs())) {
          VoipVideoFragment.c(VoipVideoFragment.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115410);
          return;
          com.tencent.mm.ui.base.h.a(VoipVideoFragment.this.getActivity(), 2131767337, 2131767338, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(115408);
              s.fHr();
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
    this.HdW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115413);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
        if ((NetStatusUtil.isWifi(VoipVideoFragment.this.getActivity())) || ((s.fHs()) && (!NetStatusUtil.is2G(VoipVideoFragment.this.getActivity())))) {
          VoipVideoFragment.e(VoipVideoFragment.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115413);
          return;
          com.tencent.mm.ui.base.h.a(VoipVideoFragment.this.getActivity(), 2131767337, 2131767338, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(115411);
              if (!NetStatusUtil.is2G(VoipVideoFragment.this.getActivity())) {
                s.fHr();
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
    this.HdX = new VoipVideoFragment.19(this);
    this.HdY = new VoipVideoFragment.20(this);
    this.HdZ = new VoipVideoFragment.21(this);
    this.Hea = new VoipVideoFragment.22(this);
    this.Heb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115395);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = VoipVideoFragment.this;
        if (!VoipVideoFragment.i(VoipVideoFragment.this)) {}
        for (boolean bool = true;; bool = false)
        {
          VoipVideoFragment.a(paramAnonymousView, bool);
          if (!VoipVideoFragment.i(VoipVideoFragment.this)) {
            VoipVideoFragment.j(VoipVideoFragment.this).setVisibility(8);
          }
          Toast.makeText(VoipVideoFragment.this.getActivity(), String.format("mIsShowFaceRect:%b", new Object[] { Boolean.valueOf(VoipVideoFragment.i(VoipVideoFragment.this)) }), 0).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115395);
          return;
        }
      }
    };
    this.Hec = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115396);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        boolean bool2 = Util.nullAs((Boolean)paramAnonymousView.getTag(), false);
        boolean bool1;
        if (!bool2)
        {
          bool1 = true;
          paramAnonymousView.setTag(Boolean.valueOf(bool1));
          if (!bool2) {
            break label159;
          }
          VoipVideoFragment.j(VoipVideoFragment.this).setVisibility(8);
          Toast.makeText(VoipVideoFragment.this.getActivity(), "stop face detect", 0).show();
        }
        for (;;)
        {
          if ((VoipVideoFragment.this.Hen != null) && (VoipVideoFragment.this.Hen.get() != null)) {
            ((c)VoipVideoFragment.this.Hen.get()).fFZ();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115396);
          return;
          bool1 = false;
          break;
          label159:
          Toast.makeText(VoipVideoFragment.this.getActivity(), "start face detect", 0).show();
        }
      }
    };
    this.Hed = new VoipVideoFragment.9(this);
    this.Hee = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235792);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
        VoipVideoFragment.r(VoipVideoFragment.this);
        if ((VoipVideoFragment.this.getActivity() == null) || (VoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(235792);
          return;
        }
        if (VoipVideoFragment.s(VoipVideoFragment.this) > 0)
        {
          AppMethodBeat.o(235792);
          return;
        }
        VoipVideoFragment.p(VoipVideoFragment.this).setVisibility(8);
        VoipVideoFragment.t(VoipVideoFragment.this).setVisibility(8);
        VoipVideoFragment.u(VoipVideoFragment.this).setVisibility(8);
        VoipVideoFragment.a(VoipVideoFragment.this).setVisibility(8);
        VoipVideoFragment.b(VoipVideoFragment.this).setVisibility(8);
        VoipVideoFragment.k(VoipVideoFragment.this).setVisibility(8);
        VoipVideoFragment.d(VoipVideoFragment.this, false);
        AppMethodBeat.o(235792);
      }
    };
    this.rtb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235793);
        if ((VoipVideoFragment.this.getActivity() == null) || (VoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(235793);
          return;
        }
        VoipVideoFragment.g(VoipVideoFragment.this).setVisibility(8);
        AppMethodBeat.o(235793);
      }
    };
    this.zLY = null;
    this.Hfu = 0;
    this.Hfv = null;
    AppMethodBeat.o(115420);
  }
  
  private void adA(int paramInt)
  {
    AppMethodBeat.i(115448);
    this.HeH.fJB();
    this.Hdg.setEnabled(false);
    this.Hdk.setEnabled(false);
    this.Hdj.setEnabled(false);
    this.Hdi.setEnabled(false);
    this.Hdh.setEnabled(false);
    this.Hdf.setEnabled(false);
    this.Hdl.setEnabled(false);
    this.Hde.setEnabled(false);
    this.Hdd.setEnabled(false);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.HeG != null) {
        this.HeG.aI(true, false);
      }
      AppMethodBeat.o(115448);
      return;
      this.HcY.setVisibility(0);
      this.HcY.setText(2131767336);
    }
  }
  
  private void b(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(235804);
    if ((this.ncd == null) || (paramCaptureView == null))
    {
      AppMethodBeat.o(235804);
      return;
    }
    if ((paramCaptureView.getParent() != null) && ((paramCaptureView.getParent() instanceof ViewGroup))) {
      ((ViewGroup)this.qsJ.getParent()).removeView(this.qsJ);
    }
    this.ncd.removeView(this.qsJ);
    this.qsJ = null;
    if (paramCaptureView.getParent() != null) {
      ((ViewGroup)paramCaptureView.getParent()).removeAllViews();
    }
    this.qsJ = paramCaptureView;
    this.ncd.addView(paramCaptureView, new RelativeLayout.LayoutParams(1, 1));
    this.qsJ.setVisibility(0);
    this.qsJ.setAlpha(0.0F);
    Log.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView added");
    AppMethodBeat.o(235804);
  }
  
  private void bpu()
  {
    AppMethodBeat.i(115449);
    if ((this.mTimer == null) || (this.qvo))
    {
      AppMethodBeat.o(115449);
      return;
    }
    if (-1L == this.Heo) {
      this.Heo = Util.nowSecond();
    }
    this.HdI = this.Heo;
    this.qvo = true;
    TimerTask local13 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(235795);
        VoipVideoFragment.this.kAn.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(235794);
            String str = VoipVideoFragment.AF(Util.secondsToNow(VoipVideoFragment.this.Heo));
            VoipVideoFragment.u(VoipVideoFragment.this).setText(str);
            VoipVideoFragment.v(VoipVideoFragment.this);
            AppMethodBeat.o(235794);
          }
        });
        AppMethodBeat.o(235795);
      }
    };
    this.mTimer.schedule(local13, 1000L, 1000L);
    this.HdO = new MTimerHandler("VoipVideoFragment_cpuStatThread", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(235796);
        if (VoipVideoFragment.w(VoipVideoFragment.this))
        {
          VoipVideoFragment.x(VoipVideoFragment.this);
          AppMethodBeat.o(235796);
          return true;
        }
        AppMethodBeat.o(235796);
        return false;
      }
    }, true);
    this.HdP = true;
    this.HdO.startTimer(1000L);
    AppMethodBeat.o(115449);
  }
  
  private void fJo()
  {
    AppMethodBeat.i(235798);
    if (this.Hdc == null)
    {
      AppMethodBeat.o(235798);
      return;
    }
    aw.kA(getActivity());
    if (aw.a(aw.gWy(), getActivity().getTaskId()) == -1) {
      this.Hdc.setVisibility(8);
    }
    for (;;)
    {
      this.Hdc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(115397);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (aw.a(aw.gWy(), VoipVideoFragment.this.getActivity().getTaskId()) == 2)
          {
            aw.a(aw.gWy(), VoipVideoFragment.this.getActivity().getTaskId(), 0);
            VoipVideoFragment.k(VoipVideoFragment.this).setBackgroundResource(2131690910);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115397);
            return;
            aw.a(aw.gWy(), VoipVideoFragment.this.getActivity().getTaskId(), 2);
            VoipVideoFragment.k(VoipVideoFragment.this).setBackgroundResource(2131690831);
          }
        }
      });
      AppMethodBeat.o(235798);
      return;
      this.Hdc.setVisibility(0);
    }
  }
  
  private void fJp()
  {
    AppMethodBeat.i(115427);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
    this.HdF += 1;
    this.kAn.postDelayed(this.Hee, 10000L);
    AppMethodBeat.o(115427);
  }
  
  private void fJr()
  {
    AppMethodBeat.i(115438);
    this.Hfn.setVisibility(0);
    if (this.HeD != null) {
      fJA();
    }
    this.HcQ.setVisibility(0);
    this.HcS.setVisibility(0);
    if ((as.bjp(this.goe)) && (!Util.isNullOrNil(this.HcT.getText()))) {
      this.HcT.setVisibility(0);
    }
    for (;;)
    {
      this.HcU.setText(2131767315);
      this.HcW.setVisibility(0);
      this.HcR.setVisibility(0);
      this.HeH.a(this.HcV, HeB);
      this.Hdl.setVisibility(8);
      this.Hdk.setVisibility(8);
      this.Hdg.setVisibility(8);
      this.Hdj.setVisibility(8);
      this.Hdi.setVisibility(0);
      this.Hdf.setVisibility(0);
      this.Hdh.setVisibility(0);
      this.Hde.setVisibility(8);
      if (this.HdH) {
        this.Hdd.setVisibility(0);
      }
      this.HcZ.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.fFg().GUy != null)
      {
        this.HcZ.setVisibility(0);
        this.HcZ.setText(com.tencent.mm.plugin.voip.c.fFg().GUy);
      }
      if (ae.gKt.gFB == 1)
      {
        this.HcP.setVisibility(0);
        this.Hfn.setVisibility(4);
      }
      AppMethodBeat.o(115438);
      return;
      this.HcT.setVisibility(8);
    }
  }
  
  private void fJs()
  {
    AppMethodBeat.i(115439);
    this.HcW.setVisibility(0);
    this.Hfn.setVisibility(0);
    this.HcU.setText(2131767313);
    if ((as.bjp(this.goe)) && (!Util.isNullOrNil(this.HcT.getText()))) {
      this.HcT.setVisibility(0);
    }
    for (;;)
    {
      this.HeC.setVisibility(8);
      this.HcY.setVisibility(8);
      this.HcZ.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.fFg().GUy != null)
      {
        this.HcZ.setVisibility(0);
        this.HcZ.setText(com.tencent.mm.plugin.voip.c.fFg().GUy);
      }
      this.HeH.a(this.HcV, HeB);
      this.Hdl.setVisibility(8);
      this.Hdk.setVisibility(8);
      this.Hdg.setVisibility(0);
      this.Hdj.setVisibility(8);
      this.Hdi.setVisibility(8);
      this.Hdf.setVisibility(8);
      this.Hdh.setVisibility(8);
      this.Hde.setVisibility(0);
      this.Hdd.setVisibility(8);
      AppMethodBeat.o(115439);
      return;
      this.HcT.setVisibility(8);
    }
  }
  
  private void fJt()
  {
    boolean bool2 = true;
    AppMethodBeat.i(115440);
    if (this.HeD != null) {
      this.HeD.setVisibility(8);
    }
    if (!this.Hfo.Hjc)
    {
      AppMethodBeat.o(115440);
      return;
    }
    this.Hfo.xv(false);
    label79:
    Point localPoint;
    if (this.GUf) {
      if (!this.HdG)
      {
        bool1 = true;
        this.HdG = bool1;
        if (this.HdG) {
          break label418;
        }
        bool1 = true;
        localPoint = xl(bool1);
        this.Hfo.jH(localPoint.x, localPoint.y);
        if (ac.jPp)
        {
          this.Hdm.setVisibility(0);
          this.Hdn.setVisibility(0);
          this.Hdo.setVisibility(0);
          this.Hdp.setVisibility(0);
          this.Hdq.setVisibility(0);
          this.Hdr.setVisibility(0);
        }
        this.HcQ.setVisibility(8);
        this.Hfn.setVisibility(0);
        this.Hfo.setVisibility(0);
        this.HcX.setVisibility(0);
        this.Hdb.setVisibility(0);
        if (ao.gJN()) {
          fJo();
        }
        this.Hdl.setVisibility(0);
        this.Hdk.setVisibility(0);
        this.Hdg.setVisibility(8);
        this.Hdj.setVisibility(0);
        this.Hdi.setVisibility(8);
        this.Hdf.setVisibility(8);
        this.Hdh.setVisibility(8);
        this.Hde.setVisibility(8);
        this.Hdd.setVisibility(8);
        setHWDecMode(this.HdK);
        Log.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", new Object[] { Integer.valueOf(this.HdK) });
        if (this.HdG) {
          break label454;
        }
      }
    }
    label418:
    label454:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPoint = xl(bool1);
      ((MovableVideoView)this.Hfo).jF(localPoint.x, localPoint.y);
      bpu();
      if (MMApplicationContext.getDefaultPreference().getBoolean("voipfaceDebug", false))
      {
        this.Hdv.setVisibility(0);
        this.Hdw.setVisibility(0);
      }
      fJp();
      if (this.HeE == 4102) {
        jE(2131767220, 10000);
      }
      AppMethodBeat.o(115440);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label79;
      if (!this.HdG) {}
      for (bool1 = true;; bool1 = false)
      {
        this.HdG = bool1;
        this.Hfr.setVisibility(8);
        break;
      }
    }
  }
  
  private void fJu()
  {
    AppMethodBeat.i(115447);
    this.HcU.setText(2131767390);
    this.HeH.a(this.HcV, HeB);
    AppMethodBeat.o(115447);
  }
  
  private void fJv()
  {
    AppMethodBeat.i(115450);
    View.OnClickListener local15 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(235797);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.report.service.h.CyF.a(11079, new Object[] { Integer.valueOf(4) });
        if ((!VoipVideoFragment.m(VoipVideoFragment.this)) && (VoipVideoFragment.this.Hen.get() != null)) {
          VoipVideoFragment.p(VoipVideoFragment.this).getVisibility();
        }
        int i;
        if (VoipVideoFragment.p(VoipVideoFragment.this).getVisibility() == 0)
        {
          i = 4;
          if (i != 0) {
            break label307;
          }
        }
        label307:
        for (int j = 0;; j = 8)
        {
          VoipVideoFragment.p(VoipVideoFragment.this).setVisibility(j);
          VoipVideoFragment.t(VoipVideoFragment.this).setVisibility(j);
          if (ao.gJN()) {
            VoipVideoFragment.y(VoipVideoFragment.this);
          }
          VoipVideoFragment.u(VoipVideoFragment.this).setVisibility(j);
          VoipVideoFragment.b(VoipVideoFragment.this).setVisibility(j);
          VoipVideoFragment.a(VoipVideoFragment.this).setVisibility(j);
          paramAnonymousView = VoipVideoFragment.this;
          if (j == 0) {
            bool = true;
          }
          VoipVideoFragment.d(paramAnonymousView, bool);
          if (ac.jPp)
          {
            VoipVideoFragment.z(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.A(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.B(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.C(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.D(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.E(VoipVideoFragment.this).setVisibility(j);
          }
          if (i == 0) {
            VoipVideoFragment.q(VoipVideoFragment.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(235797);
          return;
          i = 0;
          break;
        }
      }
    };
    this.ncd.setOnClickListener(local15);
    AppMethodBeat.o(115450);
  }
  
  private Point xl(boolean paramBoolean)
  {
    AppMethodBeat.i(115454);
    int i = (int)(getActivity().getWindowManager().getDefaultDisplay().getHeight() / 5.0D);
    float f = i;
    com.tencent.mm.plugin.voip.c.fFg();
    Point localPoint = new Point((int)(f * com.tencent.mm.plugin.voip.model.u.xg(paramBoolean)), i);
    AppMethodBeat.o(115454);
    return localPoint;
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.g.d paramd)
  {
    AppMethodBeat.i(115426);
    if ((paramSurfaceTexture == null) || (paramd == null))
    {
      Log.e("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture error, videoTexture:%s, videoTexture:%s", new Object[] { paramSurfaceTexture, paramd });
      AppMethodBeat.o(115426);
      return;
    }
    this.surfaceTexture = paramSurfaceTexture;
    this.GgP = paramd;
    if ((!this.qsM) || (this.Hfq == null) || (this.Hfp == null))
    {
      Log.i("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture failed , texId:%d,mInitDone:%b", new Object[] { Integer.valueOf(paramd.igv), Boolean.valueOf(this.qsM) });
      AppMethodBeat.o(115426);
      return;
    }
    this.Hfq.a(this.surfaceTexture, paramd);
    this.Hfp.a(this.surfaceTexture, paramd);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture OK , videoTexture:%d", new Object[] { Integer.valueOf(paramd.igv) });
    AppMethodBeat.o(115426);
  }
  
  public final void a(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(235799);
    this.qsJ = paramCaptureView;
    b(this.qsJ);
    AppMethodBeat.o(235799);
  }
  
  protected final void aUB(String paramString)
  {
    AppMethodBeat.i(115433);
    if (this.HcZ != null)
    {
      this.HcZ.setVisibility(0);
      this.HcZ.setText(paramString);
    }
    AppMethodBeat.o(115433);
  }
  
  public final void b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(235802);
    if (!this.qsM)
    {
      AppMethodBeat.o(235802);
      return;
    }
    if (OpenGlRender.His == 1)
    {
      if (this.Hfu < paramInt1 * paramInt2) {
        this.zLY = null;
      }
      if (this.zLY == null)
      {
        this.Hfu = (paramInt1 * paramInt2);
        this.zLY = new int[this.Hfu];
      }
      if ((com.tencent.mm.plugin.voip.c.fFg().a(paramArrayOfByte, (int)paramLong, paramInt3 & 0x1F, paramInt1, paramInt2, this.zLY, true) < 0) || (this.zLY == null))
      {
        AppMethodBeat.o(235802);
        return;
      }
      if (this.HdG) {
        this.Hfp.a(this.zLY, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      }
    }
    for (;;)
    {
      this.Hdz += 1;
      this.Hdy += 1;
      paramArrayOfByte = this.Hdu;
      paramArrayOfByte.Hhz = paramInt1;
      paramArrayOfByte.HhA = paramInt2;
      paramArrayOfByte = this.Hdu;
      paramInt1 = this.ncd.getWidth();
      paramInt2 = this.ncd.getHeight();
      paramArrayOfByte.Hhy = paramInt1;
      paramArrayOfByte.sT = paramInt2;
      AppMethodBeat.o(235802);
      return;
      this.Hfq.a(this.zLY, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      continue;
      if (OpenGlRender.His == 2) {
        if (this.HdG) {
          this.Hfp.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
        } else {
          this.Hfq.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
        }
      }
    }
  }
  
  public final void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115443);
    if (!this.qsM)
    {
      AppMethodBeat.o(115443);
      return;
    }
    this.qvm += 1;
    if (OpenGlRender.His == 1)
    {
      if (this.HdG)
      {
        this.Hfq.i(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90);
        AppMethodBeat.o(115443);
        return;
      }
      this.Hfp.i(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90);
      AppMethodBeat.o(115443);
      return;
    }
    if (this.HdG)
    {
      this.Hfq.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
      AppMethodBeat.o(115443);
      return;
    }
    this.Hfp.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
    AppMethodBeat.o(115443);
  }
  
  public final void fJC()
  {
    AppMethodBeat.i(115425);
    if ((this.Hfq != null) && (this.Hfp != null))
    {
      if (!this.HdG) {
        break label119;
      }
      this.Hfp.setShowMode(0);
      if ((this.HdK & 0x1) == 0) {
        break label108;
      }
      this.Hfq.setShowMode(1);
    }
    for (;;)
    {
      Log.i("MicroMsg.Voip.VoipVideoFragment", "changeSurfaceRender, bigViewMode: %d, smallViewMode: %d,mIsSmallViewShowSelf:%b, after changeSurfaceRender", new Object[] { Integer.valueOf(this.Hfq.HiI), Integer.valueOf(this.Hfp.HiI), Boolean.valueOf(this.HdG) });
      AppMethodBeat.o(115425);
      return;
      label108:
      this.Hfq.setShowMode(0);
      continue;
      label119:
      this.Hfq.setShowMode(0);
      if ((this.HdK & 0x1) != 0) {
        this.Hfp.setShowMode(1);
      } else {
        this.Hfp.setShowMode(0);
      }
    }
  }
  
  public final void fJj()
  {
    AppMethodBeat.i(115452);
    if (this.qsJ != null)
    {
      this.ncd.removeView(this.qsJ);
      this.ncd.addView(this.qsJ, new RelativeLayout.LayoutParams(1, 1));
      this.qsJ.setVisibility(0);
      this.qsJ.setAlpha(0.0F);
      Log.i("MicroMsg.Voip.VoipVideoFragment", "resetCaptureView");
    }
    AppMethodBeat.o(115452);
  }
  
  protected final void fJq()
  {
    AppMethodBeat.i(115436);
    if (this.yzB != null)
    {
      this.yzB.clearAnimation();
      this.yzB.setVisibility(8);
    }
    AppMethodBeat.o(115436);
  }
  
  public final void fJx()
  {
    AppMethodBeat.i(115444);
    if (!this.qsM)
    {
      AppMethodBeat.o(115444);
      return;
    }
    this.Hfq.fKN();
    this.Hfp.fKN();
    AppMethodBeat.o(115444);
  }
  
  public final OpenGlRender fJy()
  {
    if (this.HdG) {
      return this.Hfp;
    }
    return this.Hfq;
  }
  
  public final OpenGlRender getSpatioTemporalFilterData()
  {
    if (this.HdG) {
      return this.Hfp;
    }
    return this.Hfq;
  }
  
  public final void jA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115446);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "adjustHWViewAspectRatio, mInitDone:%b, HWDecsize:%dx%d,  lastHWDecsize:%dx%d", new Object[] { Boolean.valueOf(this.qsM), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.GUK), Integer.valueOf(this.GUL) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(115446);
      return;
    }
    if ((this.GUK != paramInt1) || (this.GUL != paramInt2))
    {
      this.GUK = paramInt1;
      this.GUL = paramInt2;
    }
    if (this.qsM)
    {
      this.Hfq.jA(paramInt1, paramInt2);
      this.Hfp.jA(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115446);
  }
  
  public final void jD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115428);
    super.jD(paramInt1, paramInt2);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + k.adM(paramInt2));
    if (this.ncd == null)
    {
      Log.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
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
        if ((ae.gKt.gFB == 1) && (paramInt1 != 0)) {
          this.HcP.setVisibility(8);
        }
        AppMethodBeat.o(115428);
        return;
        fJs();
        paramInt1 = 1;
        continue;
        paramInt1 = 0;
        fJr();
        continue;
        fJv();
        fJt();
        paramInt1 = 1;
        continue;
        adA(paramInt1);
        paramInt1 = 1;
      }
      fJu();
    }
  }
  
  protected final void jE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115434);
    if (this.HcY == null)
    {
      AppMethodBeat.o(115434);
      return;
    }
    this.HcY.setText(paramInt1);
    this.HcY.setVisibility(0);
    this.HcY.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.HcY.setBackgroundResource(2131235553);
    this.HcY.setCompoundDrawables(null, null, null, null);
    this.HcY.setCompoundDrawablePadding(0);
    this.kAn.removeCallbacks(this.rtb);
    if (-1 != paramInt2) {
      this.kAn.postDelayed(this.rtb, paramInt2);
    }
    AppMethodBeat.o(115434);
  }
  
  public final void m(Point paramPoint)
  {
    AppMethodBeat.i(235800);
    OpenGlView localOpenGlView = this.Hfn;
    Log.i(OpenGlView.TAG, "new size from resoureHelper w %s * h  %s", new Object[] { Integer.valueOf(com.tencent.mm.cb.a.jn(localOpenGlView.getContext())), Integer.valueOf(com.tencent.mm.cb.a.jo(localOpenGlView.getContext())) });
    int j = paramPoint.x;
    int i = paramPoint.y;
    localOpenGlView.Hja = j;
    localOpenGlView.Hjb = i;
    if (ao.gJI())
    {
      j = i * 9 / 16;
      paramPoint = new RelativeLayout.LayoutParams(j, i);
      paramPoint.addRule(13);
      localOpenGlView.Hja = j;
    }
    for (;;)
    {
      localOpenGlView.setLayoutParams(paramPoint);
      localOpenGlView.setLayoutParams(paramPoint);
      if (this.Hfo != null)
      {
        paramPoint = (MovableVideoView)this.Hfo;
        Log.i("MicroMsg.MovableVideoView", "refrsh view %s, %s", new Object[] { Integer.valueOf(paramPoint.mWidth), Integer.valueOf(paramPoint.HhR) });
        paramPoint.mScreenWidth = 0;
        paramPoint.jF(paramPoint.mWidth, paramPoint.HhR);
      }
      AppMethodBeat.o(235800);
      return;
      paramPoint = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(115421);
    this.ncd = ((RelativeLayout)paramLayoutInflater.inflate(2131496863, paramViewGroup, false));
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)this.ncd.findViewById(2131307122)).setPadding(0, 0, 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(getActivity(), 40.0F));
    }
    this.HeC = ((ImageView)this.ncd.findViewById(2131310016));
    this.HeD = ((ImageView)this.ncd.findViewById(2131310052));
    this.Hda = ((RelativeLayout)this.ncd.findViewById(2131303653));
    this.Hfn = ((OpenGlView)this.ncd.findViewById(2131297375));
    this.Hfn.jG(mScreenWidth, mScreenHeight);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: onCreateView!");
    this.Hdl = ((VoipBigIconButton)this.ncd.findViewById(2131310048));
    this.Hdl.setOnClickListener(this.Hed);
    this.Hdk = ((VoipBigIconButton)this.ncd.findViewById(2131310064));
    this.Hdk.setOnClickListener(this.HdT);
    this.Hdg = ((VoipBigIconButton)this.ncd.findViewById(2131310017));
    this.Hdg.setOnClickListener(this.HdY);
    this.Hdj = ((VoipBigIconButton)this.ncd.findViewById(2131310034));
    this.Hdj.setOnClickListener(this.HdS);
    this.Hdi = ((VoipBigIconButton)this.ncd.findViewById(2131310013));
    this.Hdi.setOnClickListener(this.HdW);
    this.Hdf = ((VoipSmallIconButton)this.ncd.findViewById(2131310014));
    this.Hdf.setOnClickListener(this.HdV);
    this.Hdh = ((VoipBigIconButton)this.ncd.findViewById(2131310045));
    this.Hdh.setOnClickListener(this.HdX);
    this.Hde = ((VoipSmallIconButton)this.ncd.findViewById(2131310049));
    this.Hde.setOnClickListener(this.HdU);
    if (m.Se("VOIPBlockIgnoreButton") == 0)
    {
      bool = true;
      this.HdH = bool;
      this.Hdd = ((VoipSmallIconButton)this.ncd.findViewById(2131310035));
      this.Hdd.setOnClickListener(this.Hea);
      if (!this.HdH) {
        this.Hdd.setVisibility(8);
      }
      this.HcX = ((TextView)this.ncd.findViewById(2131310065));
      this.HcQ = this.ncd.findViewById(2131310058);
      this.HcR = ((ImageView)this.ncd.findViewById(2131310057));
      a.b.a(this.HcR, this.goe, 0.0588235F, true);
      this.HcS = ((TextView)this.ncd.findViewById(2131310059));
      this.HcT = ((TextView)this.ncd.findViewById(2131310061));
      this.HcU = ((TextView)this.ncd.findViewById(2131310054));
      this.HcV = ((TextView)this.ncd.findViewById(2131310056));
      this.HcW = this.ncd.findViewById(2131310055);
      z(this.HcV);
      this.HcY = ((TextView)this.ncd.findViewById(2131310053));
      this.HcZ = ((TextView)this.ncd.findViewById(2131310063));
      this.Hdb = ((Button)this.ncd.findViewById(2131297839));
      this.Hdc = ((WeImageView)this.ncd.findViewById(2131297851));
      this.yzB = ((TextView)this.ncd.findViewById(2131310041));
      this.HcP = ((ImageView)this.ncd.findViewById(2131301816));
      paramLayoutInflater = com.tencent.mm.aj.c.a(this.goe, false, -1, null);
      this.HcP.setImageBitmap(BitmapUtil.fastblur(paramLayoutInflater, 10));
      if (ac.jPp)
      {
        this.Hdm = ((TextView)this.ncd.findViewById(2131310018));
        this.Hdn = ((TextView)this.ncd.findViewById(2131310046));
        this.Hdo = ((TextView)this.ncd.findViewById(2131310043));
        this.Hdp = ((TextView)this.ncd.findViewById(2131310047));
        this.Hdq = ((TextView)this.ncd.findViewById(2131310044));
        this.Hdr = ((TextView)this.ncd.findViewById(2131300129));
      }
      this.Hdv = ((Button)this.ncd.findViewById(2131310032));
      this.Hdw = ((Button)this.ncd.findViewById(2131310033));
      this.Hdv.setVisibility(8);
      this.Hdw.setVisibility(8);
      this.Hdv.setOnClickListener(this.Heb);
      this.Hdw.setOnClickListener(this.Hec);
      this.Hdu = new com.tencent.mm.plugin.voip.video.d(getActivity());
      this.ncd.addView(this.Hdu);
      this.Hdu.setVisibility(8);
      this.Hdb.setOnClickListener(this.HdZ);
      if (ao.gJN()) {
        fJo();
      }
      b(this.qsJ);
      int i = com.tencent.mm.ui.base.u.ay(getActivity());
      Log.d("MicroMsg.Voip.VoipVideoFragment", "statusHeight: ".concat(String.valueOf(i)));
      aA(this.Hdb, i);
      aA(this.Hdc, i);
      aA(this.ncd.findViewById(2131310051), i);
      aA(this.HcQ, i);
      this.Hdz = 0;
      this.Hdy = 0;
      this.qvm = 0;
      this.HdA = 0;
      this.HdB = 0;
      this.HdM = 0;
      this.HdN = 0;
      paramLayoutInflater = (WindowManager)getActivity().getSystemService("window");
      i = paramLayoutInflater.getDefaultDisplay().getHeight() / 5;
      int j = paramLayoutInflater.getDefaultDisplay().getWidth() * i / paramLayoutInflater.getDefaultDisplay().getHeight();
      this.Hfo = new MovableVideoView(getActivity().getApplicationContext());
      ((MovableVideoView)this.Hfo).jF(j, i);
      this.Hfo.setVisibility(0);
      this.Hfo.xv(true);
      this.Hfp = new OpenGlRender(this.Hfo, OpenGlRender.RenderRemote);
      this.Hfo.setRenderer(this.Hfp);
      this.Hfo.setRenderMode(0);
      this.Hfp.HiQ = new OpenGlRender.b()
      {
        public final void Lj(long paramAnonymousLong)
        {
          AppMethodBeat.i(235783);
          if ((VoipVideoFragment.this.Hen != null) && (VoipVideoFragment.this.Hen.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.Hen.get()).ah(paramAnonymousLong, 2);
          }
          AppMethodBeat.o(235783);
        }
        
        public final void Lk(long paramAnonymousLong)
        {
          AppMethodBeat.i(235784);
          if ((VoipVideoFragment.this.Hen != null) && (VoipVideoFragment.this.Hen.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.Hen.get()).ah(paramAnonymousLong, 0);
          }
          AppMethodBeat.o(235784);
        }
        
        public final void Ll(long paramAnonymousLong)
        {
          AppMethodBeat.i(235785);
          if ((VoipVideoFragment.this.Hen != null) && (VoipVideoFragment.this.Hen.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.Hen.get()).ah(paramAnonymousLong, 1);
          }
          AppMethodBeat.o(235785);
        }
        
        public final void fJD() {}
      };
      this.Hfq = new OpenGlRender(this.Hfn, OpenGlRender.RenderLocal);
      this.Hfn.setRenderer(this.Hfq);
      this.Hfn.setRenderMode(0);
      this.Hfn.setVisibility(0);
      this.Hfq.HiQ = new OpenGlRender.b()
      {
        public final void Lj(long paramAnonymousLong)
        {
          AppMethodBeat.i(235787);
          if ((VoipVideoFragment.this.Hen != null) && (VoipVideoFragment.this.Hen.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.Hen.get()).ah(paramAnonymousLong, 2);
          }
          AppMethodBeat.o(235787);
        }
        
        public final void Lk(long paramAnonymousLong)
        {
          AppMethodBeat.i(235788);
          if ((VoipVideoFragment.this.Hen != null) && (VoipVideoFragment.this.Hen.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.Hen.get()).ah(paramAnonymousLong, 0);
          }
          AppMethodBeat.o(235788);
        }
        
        public final void Ll(long paramAnonymousLong)
        {
          AppMethodBeat.i(235789);
          if ((VoipVideoFragment.this.Hen != null) && (VoipVideoFragment.this.Hen.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.Hen.get()).ah(paramAnonymousLong, 1);
          }
          AppMethodBeat.o(235789);
        }
        
        public final void fJD()
        {
          AppMethodBeat.i(235786);
          if ((VoipVideoFragment.this.Hen != null) && (VoipVideoFragment.this.Hen.get() != null)) {
            ((c)VoipVideoFragment.this.Hen.get()).ah(0L, 3);
          }
          AppMethodBeat.o(235786);
        }
      };
      Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
      this.ncd.addView(this.Hfo);
      this.Hfo.setOnClickListener(new View.OnClickListener()
      {
        long Heg = 0L;
        
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(235790);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
          if ((VoipVideoFragment.l(VoipVideoFragment.this).Hjc) || (VoipVideoFragment.l(VoipVideoFragment.this).getVisibility() != 0))
          {
            Log.i("MicroMsg.Voip.VoipVideoFragment", "current view is not show ");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(235790);
            return;
          }
          if (Util.ticksToNow(this.Heg) < 400L)
          {
            Log.i("MicroMsg.Voip.VoipVideoFragment", "click mGlSmallVideoView too fast and not allow to response it,times%s", new Object[] { Long.valueOf(Util.ticksToNow(this.Heg)) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(235790);
            return;
          }
          this.Heg = Util.currentTicks();
          paramAnonymousView = VoipVideoFragment.this;
          if (!VoipVideoFragment.m(VoipVideoFragment.this))
          {
            bool = true;
            VoipVideoFragment.b(paramAnonymousView, bool);
            VoipVideoFragment.this.fJC();
            paramAnonymousView = VoipVideoFragment.this;
            if (VoipVideoFragment.m(VoipVideoFragment.this)) {
              break label269;
            }
          }
          label269:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView = VoipVideoFragment.c(paramAnonymousView, bool);
            VoipVideoFragment.l(VoipVideoFragment.this).jH(paramAnonymousView.x, paramAnonymousView.y);
            com.tencent.mm.plugin.report.service.h.CyF.a(11079, new Object[] { Integer.valueOf(3) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(235790);
            return;
            bool = false;
            break;
          }
        }
      });
      paramLayoutInflater = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.goe);
      this.HcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getActivity(), aa.b(paramLayoutInflater, this.goe), this.HcS.getTextSize()));
      paramLayoutInflater = com.tencent.mm.openim.room.a.a.O(paramLayoutInflater);
      if (!Util.isNullOrNil(paramLayoutInflater)) {
        this.HcT.setText(paramLayoutInflater);
      }
      if (this.GUf) {
        this.kAn.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(115401);
            VoipVideoFragment.n(VoipVideoFragment.this).setText(2131767313);
            VoipVideoFragment.this.HeH.a(VoipVideoFragment.o(VoipVideoFragment.this), VoipBaseFragment.HeB);
            AppMethodBeat.o(115401);
          }
        }, 2000L);
      }
      this.Hfr = ((VoIPVideoView)this.ncd.findViewById(2131310050));
      this.mTimer = new Timer("VoIP_video_talking_count");
      Log.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", new Object[] { Integer.valueOf(this.HdL) });
      this.Hfq.setVoipBeauty(this.HdL);
      this.Hfp.setVoipBeauty(this.HdL);
      this.Hfq.setSpatiotemporalDenosing(this.Hft);
      this.Hfp.setSpatiotemporalDenosing(this.Hft);
      if ((this.Hen != null) && (this.Hen.get() != null))
      {
        paramLayoutInflater = (c)this.Hen.get();
        if ((260 == this.mStatus) || (6 == this.mStatus)) {
          break label1671;
        }
      }
    }
    label1671:
    for (boolean bool = true;; bool = false)
    {
      paramLayoutInflater.aE(true, bool);
      this.Hfq.HiO = true;
      this.Hfp.HiO = true;
      this.qsM = true;
      jA(this.GUK, this.GUL);
      jD(0, this.mStatus);
      this.hCN = ((PowerManager)MMApplicationContext.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipVideoFragment");
      this.hCN.acquire();
      Log.i("MicroMsg.Voip.VoipVideoFragment", "acquire wakelock");
      paramLayoutInflater = this.ncd;
      AppMethodBeat.o(115421);
      return paramLayoutInflater;
      bool = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115422);
    this.qvo = false;
    Log.i("MicroMsg.Voip.VoipVideoFragment", "onDestory");
    super.onDestroy();
    if ((this.hCN != null) && (this.hCN.isHeld()))
    {
      Log.i("MicroMsg.Voip.VoipVideoFragment", "release waklock");
      this.hCN.release();
    }
    AppMethodBeat.o(115422);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(115453);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "onDetach");
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    if (this.HdO != null) {
      this.HdO.stopTimer();
    }
    this.HdP = false;
    super.onDetach();
    AppMethodBeat.o(115453);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(115432);
    this.Hfq.onStarted();
    this.Hfp.onStarted();
    super.onStart();
    AppMethodBeat.o(115432);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(115431);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "onStop");
    this.Hfq.fKM();
    this.Hfp.fKM();
    super.onStop();
    AppMethodBeat.o(115431);
  }
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115424);
    this.Hfq.releaseSurfaceTexture();
    this.Hfp.releaseSurfaceTexture();
    AppMethodBeat.o(115424);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115423);
    if (this.HdG)
    {
      this.Hfn.HhI.requestRender();
      AppMethodBeat.o(115423);
      return;
    }
    this.Hfo.HhI.requestRender();
    AppMethodBeat.o(115423);
  }
  
  public final void setDeviceOrientation(int paramInt)
  {
    AppMethodBeat.i(235801);
    super.setDeviceOrientation(paramInt);
    if ((paramInt == 0) || (paramInt == 180))
    {
      this.Hfq.Hir = 0;
      this.Hfp.Hir = 0;
      AppMethodBeat.o(235801);
      return;
    }
    this.Hfq.Hir = (360 - paramInt);
    this.Hfp.Hir = (360 - paramInt);
    AppMethodBeat.o(235801);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115442);
    this.HdK = paramInt;
    if ((this.Hfo == null) || (this.Hfo.Hjc))
    {
      AppMethodBeat.o(115442);
      return;
    }
    Log.i("MicroMsg.Voip.VoipVideoFragment", "setHWDecMode, hwdec: %d, mIsSmallViewShowSelf:%b, before changeSurfaceRender", new Object[] { Integer.valueOf(this.HdK), Boolean.valueOf(this.HdG) });
    fJC();
    AppMethodBeat.o(115442);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setSpatiotemporalDenosing(int paramInt)
  {
    AppMethodBeat.i(235803);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "setSpatiotemporalDenosing isON:%d, mInitDone:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.qsM) });
    this.Hft = paramInt;
    if (!this.qsM)
    {
      AppMethodBeat.o(235803);
      return;
    }
    this.Hfq.setSpatiotemporalDenosing(this.Hft);
    this.Hfp.setSpatiotemporalDenosing(this.Hft);
    AppMethodBeat.o(235803);
  }
  
  public final void setVoicePlayDevice(int paramInt) {}
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115445);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "setVoipBeauty isON:%d, mInitDone:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.qsM) });
    this.HdL = paramInt;
    if (!this.qsM)
    {
      AppMethodBeat.o(115445);
      return;
    }
    this.Hfq.setVoipBeauty(this.HdL);
    this.Hfp.setVoipBeauty(this.HdL);
    AppMethodBeat.o(115445);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115430);
    Log.printInfoStack("MicroMsg.Voip.VoipVideoFragment", "unit should not be allow in foreground", new Object[0]);
    if (this.Hfo != null) {
      this.Hfo.setVisibility(4);
    }
    if (this.qsJ != null)
    {
      this.ncd.removeView(this.qsJ);
      this.qsJ = null;
      Log.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView removed");
    }
    if (this.Hfs != null)
    {
      this.Hfs.cancel();
      this.Hfs = null;
    }
    super.uninit();
    AppMethodBeat.o(115430);
  }
  
  protected final void xk(boolean paramBoolean)
  {
    AppMethodBeat.i(115435);
    if (this.yzB != null)
    {
      if (!paramBoolean) {
        break label49;
      }
      this.yzB.setText(2131767331);
    }
    for (;;)
    {
      this.yzB.clearAnimation();
      this.yzB.setVisibility(0);
      AppMethodBeat.o(115435);
      return;
      label49:
      this.yzB.setText(2131767330);
    }
  }
  
  public final class a
    extends com.tencent.f.i.b
  {
    public final String getKey()
    {
      return "VoipVideoFragment_blurBitmap";
    }
    
    public final void run()
    {
      AppMethodBeat.i(115419);
      Log.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
      final Bitmap localBitmap = VoipVideoFragment.F(this.Hfw);
      this.Hfw.kAn.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115418);
          if (VoipVideoFragment.a.this.Hfw.HeC != null) {
            VoipVideoFragment.a.this.Hfw.HeC.setBackgroundDrawable(new BitmapDrawable(localBitmap));
          }
          VoipVideoFragment.G(VoipVideoFragment.a.this.Hfw);
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