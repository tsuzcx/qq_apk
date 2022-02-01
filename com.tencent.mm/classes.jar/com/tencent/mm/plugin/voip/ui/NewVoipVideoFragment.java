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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.model.aa;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.video.NewMovableVideoView;
import com.tencent.mm.plugin.voip.video.d;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
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
import kotlin.g.b.p;

public class NewVoipVideoFragment
  extends VoipBaseFragment
{
  private Bitmap BQT;
  private boolean GxH;
  private VoIPRenderSurfaceView HcN;
  private VoIPRenderSurfaceView HcO;
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
  private boolean HdC;
  private boolean HdD;
  private boolean HdE;
  private int HdF;
  private boolean HdG;
  private boolean HdH;
  public long HdI;
  private a HdJ;
  public int HdK;
  public int HdL;
  private int HdM;
  private int HdN;
  private MTimerHandler HdO;
  private boolean HdP;
  private boolean HdQ;
  private boolean HdR;
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
  private TextView Hds;
  private TextView Hdt;
  private d Hdu;
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
  private PowerManager.WakeLock hCN;
  private Timer mTimer;
  private long nJh;
  private boolean qsM;
  private int qvm;
  private boolean qvo;
  private Runnable rtb;
  private TextView yzB;
  
  public NewVoipVideoFragment()
  {
    AppMethodBeat.i(235731);
    this.Hdu = null;
    this.Hdv = null;
    this.Hdw = null;
    this.Hdx = false;
    com.tencent.mm.plugin.voip.b.g localg = com.tencent.mm.plugin.voip.b.g.HgZ;
    this.HdC = com.tencent.mm.plugin.voip.b.g.fKj();
    localg = com.tencent.mm.plugin.voip.b.g.HgZ;
    this.GxH = com.tencent.mm.plugin.voip.b.g.fKi();
    localg = com.tencent.mm.plugin.voip.b.g.HgZ;
    this.HdD = com.tencent.mm.plugin.voip.b.g.fKh();
    localg = com.tencent.mm.plugin.voip.b.g.HgZ;
    this.HdE = com.tencent.mm.plugin.voip.b.g.fKf();
    this.HdF = 0;
    this.HdG = false;
    this.qvo = false;
    this.qsM = false;
    this.HdI = 0L;
    this.BQT = null;
    this.HdK = 0;
    this.HdL = 0;
    this.HdM = 0;
    this.nJh = 0L;
    this.HdN = 0;
    this.HdO = null;
    this.HdP = false;
    this.HdQ = false;
    this.HdR = false;
    this.HdS = new NewVoipVideoFragment.1(this);
    this.HdT = new NewVoipVideoFragment.12(this);
    this.HdU = new NewVoipVideoFragment.14(this);
    this.HdV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(235721);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
        if ((NetStatusUtil.isWifi(NewVoipVideoFragment.this.getActivity())) || (s.fHs())) {
          NewVoipVideoFragment.c(NewVoipVideoFragment.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(235721);
          return;
          com.tencent.mm.ui.base.h.a(NewVoipVideoFragment.this.getActivity(), 2131767337, 2131767338, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(235719);
              s.fHr();
              NewVoipVideoFragment.c(NewVoipVideoFragment.this);
              AppMethodBeat.o(235719);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(235720);
              NewVoipVideoFragment.d(NewVoipVideoFragment.this);
              AppMethodBeat.o(235720);
            }
          });
        }
      }
    };
    this.HdW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(235724);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
        if ((NetStatusUtil.isWifi(NewVoipVideoFragment.this.getActivity())) || ((s.fHs()) && (!NetStatusUtil.is2G(NewVoipVideoFragment.this.getActivity())))) {
          NewVoipVideoFragment.e(NewVoipVideoFragment.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(235724);
          return;
          com.tencent.mm.ui.base.h.a(NewVoipVideoFragment.this.getActivity(), 2131767337, 2131767338, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(235722);
              if (!NetStatusUtil.is2G(NewVoipVideoFragment.this.getActivity())) {
                s.fHr();
              }
              NewVoipVideoFragment.e(NewVoipVideoFragment.this);
              AppMethodBeat.o(235722);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(235723);
              NewVoipVideoFragment.d(NewVoipVideoFragment.this);
              AppMethodBeat.o(235723);
            }
          });
        }
      }
    };
    this.HdX = new NewVoipVideoFragment.17(this);
    this.HdY = new NewVoipVideoFragment.18(this);
    this.HdZ = new NewVoipVideoFragment.19(this);
    this.Hea = new NewVoipVideoFragment.20(this);
    this.Heb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(235705);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = NewVoipVideoFragment.this;
        if (!NewVoipVideoFragment.i(NewVoipVideoFragment.this)) {}
        for (boolean bool = true;; bool = false)
        {
          NewVoipVideoFragment.a(paramAnonymousView, bool);
          if (!NewVoipVideoFragment.i(NewVoipVideoFragment.this)) {
            NewVoipVideoFragment.j(NewVoipVideoFragment.this).setVisibility(8);
          }
          Toast.makeText(NewVoipVideoFragment.this.getActivity(), String.format("mIsShowFaceRect:%b", new Object[] { Boolean.valueOf(NewVoipVideoFragment.i(NewVoipVideoFragment.this)) }), 0).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(235705);
          return;
        }
      }
    };
    this.Hec = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(235706);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        boolean bool2 = Util.nullAs((Boolean)paramAnonymousView.getTag(), false);
        boolean bool1;
        if (!bool2)
        {
          bool1 = true;
          paramAnonymousView.setTag(Boolean.valueOf(bool1));
          if (!bool2) {
            break label159;
          }
          NewVoipVideoFragment.j(NewVoipVideoFragment.this).setVisibility(8);
          Toast.makeText(NewVoipVideoFragment.this.getActivity(), "stop face detect", 0).show();
        }
        for (;;)
        {
          if ((NewVoipVideoFragment.this.Hen != null) && (NewVoipVideoFragment.this.Hen.get() != null)) {
            ((c)NewVoipVideoFragment.this.Hen.get()).fFZ();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(235706);
          return;
          bool1 = false;
          break;
          label159:
          Toast.makeText(NewVoipVideoFragment.this.getActivity(), "start face detect", 0).show();
        }
      }
    };
    this.Hed = new NewVoipVideoFragment.7(this);
    this.Hee = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235711);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
        NewVoipVideoFragment.r(NewVoipVideoFragment.this);
        if ((NewVoipVideoFragment.this.getActivity() == null) || (NewVoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(235711);
          return;
        }
        if (NewVoipVideoFragment.s(NewVoipVideoFragment.this) > 0)
        {
          AppMethodBeat.o(235711);
          return;
        }
        NewVoipVideoFragment.p(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.t(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.u(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.a(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.b(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.k(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.d(NewVoipVideoFragment.this, false);
        AppMethodBeat.o(235711);
      }
    };
    this.rtb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235712);
        if ((NewVoipVideoFragment.this.getActivity() == null) || (NewVoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(235712);
          return;
        }
        NewVoipVideoFragment.g(NewVoipVideoFragment.this).setVisibility(8);
        AppMethodBeat.o(235712);
      }
    };
    AppMethodBeat.o(235731);
  }
  
  private void adA(int paramInt)
  {
    AppMethodBeat.i(235749);
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
      AppMethodBeat.o(235749);
      return;
      this.HcY.setVisibility(0);
      this.HcY.setText(2131767336);
    }
  }
  
  private void bpu()
  {
    AppMethodBeat.i(235750);
    if ((this.mTimer == null) || (this.qvo))
    {
      AppMethodBeat.o(235750);
      return;
    }
    if (-1L == this.Heo) {
      this.Heo = Util.nowSecond();
    }
    this.HdI = this.Heo;
    this.qvo = true;
    TimerTask local10 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(235714);
        NewVoipVideoFragment.this.kAn.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(235713);
            String str = NewVoipVideoFragment.AF(Util.secondsToNow(NewVoipVideoFragment.this.Heo));
            NewVoipVideoFragment.u(NewVoipVideoFragment.this).setText(str);
            NewVoipVideoFragment.v(NewVoipVideoFragment.this);
            AppMethodBeat.o(235713);
          }
        });
        AppMethodBeat.o(235714);
      }
    };
    this.mTimer.schedule(local10, 1000L, 1000L);
    this.HdO = new MTimerHandler("VoipVideoFragment_cpuStatThread", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(235715);
        if (NewVoipVideoFragment.w(NewVoipVideoFragment.this))
        {
          NewVoipVideoFragment.x(NewVoipVideoFragment.this);
          AppMethodBeat.o(235715);
          return true;
        }
        AppMethodBeat.o(235715);
        return false;
      }
    }, true);
    this.HdP = true;
    this.HdO.startTimer(1000L);
    AppMethodBeat.o(235750);
  }
  
  private void fJo()
  {
    AppMethodBeat.i(235733);
    if (this.Hdc == null)
    {
      AppMethodBeat.o(235733);
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
          AppMethodBeat.i(235707);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (aw.a(aw.gWy(), NewVoipVideoFragment.this.getActivity().getTaskId()) == 2)
          {
            aw.a(aw.gWy(), NewVoipVideoFragment.this.getActivity().getTaskId(), 0);
            NewVoipVideoFragment.k(NewVoipVideoFragment.this).setBackgroundResource(2131690910);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(235707);
            return;
            aw.a(aw.gWy(), NewVoipVideoFragment.this.getActivity().getTaskId(), 2);
            NewVoipVideoFragment.k(NewVoipVideoFragment.this).setBackgroundResource(2131690831);
          }
        }
      });
      AppMethodBeat.o(235733);
      return;
      this.Hdc.setVisibility(0);
    }
  }
  
  private void fJp()
  {
    AppMethodBeat.i(235735);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
    this.HdF += 1;
    this.kAn.postDelayed(this.Hee, 10000L);
    AppMethodBeat.o(235735);
  }
  
  private void fJr()
  {
    AppMethodBeat.i(235745);
    this.HcN.setVisibility(0);
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
        this.HcN.setVisibility(4);
      }
      AppMethodBeat.o(235745);
      return;
      this.HcT.setVisibility(8);
    }
  }
  
  private void fJs()
  {
    AppMethodBeat.i(235746);
    this.HcW.setVisibility(0);
    this.HcN.setVisibility(0);
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
      AppMethodBeat.o(235746);
      return;
      this.HcT.setVisibility(8);
    }
  }
  
  private void fJt()
  {
    boolean bool2 = true;
    AppMethodBeat.i(235747);
    if (this.HeD != null) {
      this.HeD.setVisibility(8);
    }
    if (this.HcO == null)
    {
      AppMethodBeat.o(235747);
      return;
    }
    if (this.HcO.getVisibility() == 0)
    {
      AppMethodBeat.o(235747);
      return;
    }
    label85:
    Point localPoint;
    if (this.GUf) {
      if (!this.HdG)
      {
        bool1 = true;
        this.HdG = bool1;
        if (this.HdG) {
          break label451;
        }
        bool1 = true;
        localPoint = xl(bool1);
        this.HcO.jH(localPoint.x, localPoint.y);
        if (ac.jPp)
        {
          this.Hdm.setVisibility(0);
          this.Hdn.setVisibility(0);
          this.Hdo.setVisibility(0);
          this.Hdp.setVisibility(0);
          this.Hdq.setVisibility(0);
          this.Hdr.setVisibility(0);
          this.Hds.setVisibility(0);
          this.Hdt.setVisibility(0);
        }
        this.HcQ.setVisibility(8);
        this.HcN.setVisibility(0);
        this.HcO.setVisibility(0);
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
        ((c)this.Hen.get()).wV(this.HdG);
        Log.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", new Object[] { Integer.valueOf(this.HdK) });
        if (this.HdG) {
          break label478;
        }
      }
    }
    label451:
    label478:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPoint = xl(bool1);
      ((NewMovableVideoView)this.HcO).jF(localPoint.x, localPoint.y);
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
      AppMethodBeat.o(235747);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label85;
      if (!this.HdG) {}
      for (bool1 = true;; bool1 = false)
      {
        this.HdG = bool1;
        break;
      }
    }
  }
  
  private void fJu()
  {
    AppMethodBeat.i(235748);
    this.HcU.setText(2131767390);
    this.HeH.a(this.HcV, HeB);
    AppMethodBeat.o(235748);
  }
  
  private void fJv()
  {
    AppMethodBeat.i(235751);
    View.OnClickListener local13 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(235717);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.report.service.h.CyF.a(11079, new Object[] { Integer.valueOf(4) });
        if ((!NewVoipVideoFragment.l(NewVoipVideoFragment.this)) && (NewVoipVideoFragment.this.Hen.get() != null)) {
          NewVoipVideoFragment.p(NewVoipVideoFragment.this).getVisibility();
        }
        int i;
        if (NewVoipVideoFragment.p(NewVoipVideoFragment.this).getVisibility() == 0)
        {
          i = 4;
          if (i != 0) {
            break label318;
          }
        }
        label318:
        for (int j = 0;; j = 8)
        {
          NewVoipVideoFragment.p(NewVoipVideoFragment.this).setVisibility(j);
          NewVoipVideoFragment.t(NewVoipVideoFragment.this).setVisibility(j);
          if (ao.gJN()) {
            NewVoipVideoFragment.y(NewVoipVideoFragment.this);
          }
          NewVoipVideoFragment.u(NewVoipVideoFragment.this).setVisibility(j);
          NewVoipVideoFragment.b(NewVoipVideoFragment.this).setVisibility(j);
          NewVoipVideoFragment.a(NewVoipVideoFragment.this).setVisibility(j);
          paramAnonymousView = NewVoipVideoFragment.this;
          if (j == 0) {
            bool = true;
          }
          NewVoipVideoFragment.d(paramAnonymousView, bool);
          if (ac.jPp)
          {
            NewVoipVideoFragment.z(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.A(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.B(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.C(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.D(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.E(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.F(NewVoipVideoFragment.this).setVisibility(j);
          }
          if (i == 0) {
            NewVoipVideoFragment.q(NewVoipVideoFragment.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(235717);
          return;
          i = 0;
          break;
        }
      }
    };
    this.ncd.setOnClickListener(local13);
    AppMethodBeat.o(235751);
  }
  
  private void xj(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(235737);
    if (!this.HdR)
    {
      if (!paramBoolean) {
        break label115;
      }
      ((c)this.Hen.get()).a(this.HcO, 1);
      ((c)this.Hen.get()).a(this.HcN, 0);
    }
    for (;;)
    {
      c localc = (c)this.Hen.get();
      paramBoolean = bool;
      if (260 != this.mStatus)
      {
        paramBoolean = bool;
        if (6 != this.mStatus) {
          paramBoolean = true;
        }
      }
      localc.aE(true, paramBoolean);
      this.HdR = true;
      AppMethodBeat.o(235737);
      return;
      label115:
      ((c)this.Hen.get()).a(this.HcO, 0);
      ((c)this.Hen.get()).a(this.HcN, 1);
    }
  }
  
  private Point xl(boolean paramBoolean)
  {
    AppMethodBeat.i(235753);
    int i = (int)(getActivity().getWindowManager().getDefaultDisplay().getHeight() / 5.0D);
    float f = i;
    com.tencent.mm.plugin.voip.c.fFg();
    Point localPoint = new Point((int)(f * com.tencent.mm.plugin.voip.model.u.xg(paramBoolean)), i);
    AppMethodBeat.o(235753);
    return localPoint;
  }
  
  protected final void aUB(String paramString)
  {
    AppMethodBeat.i(235740);
    if (this.HcZ != null)
    {
      this.HcZ.setVisibility(0);
      this.HcZ.setText(paramString);
    }
    AppMethodBeat.o(235740);
  }
  
  public final void adx(int paramInt)
  {
    this.Hdz += 1;
    if (paramInt > 0) {
      this.Hdy += 1;
    }
  }
  
  public final void ady(int paramInt)
  {
    this.HdK = paramInt;
  }
  
  public final void adz(int paramInt)
  {
    this.HdL = paramInt;
  }
  
  public final void fJm()
  {
    this.qvm += 1;
  }
  
  protected final void fJq()
  {
    AppMethodBeat.i(235743);
    if (this.yzB != null)
    {
      this.yzB.clearAnimation();
      this.yzB.setVisibility(8);
    }
    AppMethodBeat.o(235743);
  }
  
  public final void jD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235736);
    super.jD(paramInt1, paramInt2);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + k.adM(paramInt2));
    if (this.ncd == null)
    {
      Log.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
      AppMethodBeat.o(235736);
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
        AppMethodBeat.o(235736);
        return;
        this.HdQ = true;
        xj(true);
        fJs();
        paramInt1 = 1;
        continue;
        this.HdQ = true;
        xj(true);
        fJr();
        paramInt1 = 0;
        continue;
        fJv();
        if (this.HdQ)
        {
          ((c)this.Hen.get()).fFH();
          com.tencent.mm.plugin.voip.b.h.xs(false);
          this.HdQ = false;
        }
        for (;;)
        {
          fJt();
          paramInt1 = 1;
          break;
          xj(false);
        }
        adA(paramInt1);
        paramInt1 = 1;
      }
      fJu();
    }
  }
  
  protected final void jE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235741);
    if (this.HcY == null)
    {
      AppMethodBeat.o(235741);
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
    AppMethodBeat.o(235741);
  }
  
  public final void m(Point paramPoint)
  {
    AppMethodBeat.i(235744);
    VoIPRenderSurfaceView localVoIPRenderSurfaceView = this.HcN;
    p.h(paramPoint, "screenSize");
    Log.i("RenderView", "new size from resource Helper w %s * h  %s", new Object[] { Integer.valueOf(com.tencent.mm.cb.a.jn(localVoIPRenderSurfaceView.getContext())), Integer.valueOf(com.tencent.mm.cb.a.jo(localVoIPRenderSurfaceView.getContext())) });
    int i = paramPoint.x;
    i = paramPoint.y;
    if (ao.gJI())
    {
      paramPoint = new RelativeLayout.LayoutParams(i * 9 / 16, i);
      paramPoint.addRule(13);
    }
    for (;;)
    {
      localVoIPRenderSurfaceView.setLayoutParams((ViewGroup.LayoutParams)paramPoint);
      localVoIPRenderSurfaceView.requestLayout();
      if (this.HcO != null)
      {
        paramPoint = (NewMovableVideoView)this.HcO;
        Log.i("MicroMsg.MovableVideoView", "refrsh view %s, %s", new Object[] { Integer.valueOf(paramPoint.mWidth), Integer.valueOf(paramPoint.HhR) });
        paramPoint.mScreenWidth = 0;
        paramPoint.jF(paramPoint.mWidth, paramPoint.HhR);
      }
      AppMethodBeat.o(235744);
      return;
      paramPoint = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(235732);
    this.ncd = ((RelativeLayout)paramLayoutInflater.inflate(2131496862, paramViewGroup, false));
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)this.ncd.findViewById(2131307122)).setPadding(0, 0, 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(getActivity(), 40.0F));
    }
    this.HeC = ((ImageView)this.ncd.findViewById(2131310016));
    this.HeD = ((ImageView)this.ncd.findViewById(2131310052));
    this.Hda = ((RelativeLayout)this.ncd.findViewById(2131303653));
    this.HcN = ((VoIPRenderSurfaceView)this.ncd.findViewById(2131297375));
    this.HcN.jI(mScreenWidth, mScreenHeight);
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
    if (m.Se("VOIPBlockIgnoreButton") == 0) {}
    for (boolean bool = true;; bool = false)
    {
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
        this.Hds = ((TextView)this.ncd.findViewById(2131302160));
        this.Hdt = ((TextView)this.ncd.findViewById(2131297953));
      }
      this.Hdv = ((Button)this.ncd.findViewById(2131310032));
      this.Hdw = ((Button)this.ncd.findViewById(2131310033));
      this.Hdv.setVisibility(8);
      this.Hdw.setVisibility(8);
      this.Hdv.setOnClickListener(this.Heb);
      this.Hdw.setOnClickListener(this.Hec);
      this.Hdu = new d(getActivity());
      this.ncd.addView(this.Hdu);
      this.Hdu.setVisibility(8);
      this.Hdb.setOnClickListener(this.HdZ);
      if (ao.gJN()) {
        fJo();
      }
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
      this.HcO = new NewMovableVideoView(MMApplicationContext.getContext());
      ((NewMovableVideoView)this.HcO).jF(j, i);
      this.HcO.setVisibility(4);
      this.HcN.setVisibility(0);
      Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
      this.ncd.addView(this.HcO);
      this.HcO.setOnClickListener(new View.OnClickListener()
      {
        long Heg = 0L;
        
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(235708);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
          this.Heg = Util.currentTicks();
          paramAnonymousView = NewVoipVideoFragment.this;
          if (!NewVoipVideoFragment.l(NewVoipVideoFragment.this))
          {
            bool = true;
            NewVoipVideoFragment.b(paramAnonymousView, bool);
            ((c)NewVoipVideoFragment.this.Hen.get()).fFH();
            com.tencent.mm.plugin.voip.b.h.xs(true);
            paramAnonymousView = NewVoipVideoFragment.this;
            if (NewVoipVideoFragment.l(NewVoipVideoFragment.this)) {
              break label187;
            }
          }
          label187:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView = NewVoipVideoFragment.c(paramAnonymousView, bool);
            if (NewVoipVideoFragment.m(NewVoipVideoFragment.this) != null) {
              NewVoipVideoFragment.m(NewVoipVideoFragment.this).jH(paramAnonymousView.x, paramAnonymousView.y);
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(11079, new Object[] { Integer.valueOf(3) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(235708);
            return;
            bool = false;
            break;
          }
        }
      });
      paramLayoutInflater = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.goe);
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
            AppMethodBeat.i(235709);
            NewVoipVideoFragment.n(NewVoipVideoFragment.this).setText(2131767313);
            NewVoipVideoFragment.this.HeH.a(NewVoipVideoFragment.o(NewVoipVideoFragment.this), VoipBaseFragment.HeB);
            AppMethodBeat.o(235709);
          }
        }, 2000L);
      }
      this.mTimer = new Timer("VoIP_video_talking_count");
      Log.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", new Object[] { Integer.valueOf(this.HdL) });
      this.qsM = true;
      if ((this.Hen != null) && (this.Hen.get() != null)) {
        ((c)this.Hen.get()).fFI();
      }
      jD(0, this.mStatus);
      this.hCN = ((PowerManager)MMApplicationContext.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipVideoFragment");
      this.hCN.acquire();
      Log.i("MicroMsg.Voip.VoipVideoFragment", "acquire wakelock");
      paramLayoutInflater = this.ncd;
      AppMethodBeat.o(235732);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(235734);
    this.qvo = false;
    Log.i("MicroMsg.Voip.VoipVideoFragment", "onDestory");
    super.onDestroy();
    if ((this.hCN != null) && (this.hCN.isHeld()))
    {
      Log.i("MicroMsg.Voip.VoipVideoFragment", "release waklock");
      this.hCN.release();
    }
    AppMethodBeat.o(235734);
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(235739);
    super.onDestroyView();
    if (this.HcN != null)
    {
      this.HcN.setVisibility(8);
      this.HcN = null;
    }
    AppMethodBeat.o(235739);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(235752);
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
    AppMethodBeat.o(235752);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt) {}
  
  public final void uninit()
  {
    AppMethodBeat.i(235738);
    Log.printInfoStack("MicroMsg.Voip.VoipVideoFragment", "unit should not be allow in foreground", new Object[0]);
    if ((this.HcN != null) && (this.Hen != null) && (this.Hen.get() != null)) {
      this.HcN.release();
    }
    if ((this.Hen != null) && (this.Hen.get() != null))
    {
      ((c)this.Hen.get()).a(this.HcN);
      ((c)this.Hen.get()).a(this.HcO);
    }
    if (this.HcO != null)
    {
      this.HcO.release();
      this.HcO.setVisibility(4);
      this.HcO = null;
    }
    if (this.HdJ != null)
    {
      this.HdJ.cancel();
      this.HdJ = null;
    }
    super.uninit();
    AppMethodBeat.o(235738);
  }
  
  protected final void xk(boolean paramBoolean)
  {
    AppMethodBeat.i(235742);
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
      AppMethodBeat.o(235742);
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
      return "MicroMsg.Voip.VoipVideoFragment#ShowBlurBackgroundRunnable";
    }
    
    public final void run()
    {
      AppMethodBeat.i(235730);
      Log.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
      final Bitmap localBitmap = NewVoipVideoFragment.G(this.Hef);
      this.Hef.kAn.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(235729);
          if (NewVoipVideoFragment.a.this.Hef.HeC != null) {
            NewVoipVideoFragment.a.this.Hef.HeC.setBackgroundDrawable(new BitmapDrawable(localBitmap));
          }
          NewVoipVideoFragment.H(NewVoipVideoFragment.a.this.Hef);
          AppMethodBeat.o(235729);
        }
      });
      AppMethodBeat.o(235730);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment
 * JD-Core Version:    0.7.0.1
 */