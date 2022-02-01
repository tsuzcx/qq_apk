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
import com.tencent.mm.model.w;
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
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.t;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class NewVoipVideoFragment
  extends VoipBaseFragment
{
  private View.OnClickListener CAa;
  private View.OnClickListener CAb;
  private View.OnClickListener CAc;
  private View.OnClickListener CAd;
  private View.OnClickListener CAe;
  private View.OnClickListener CAf;
  private View.OnClickListener CAg;
  private View.OnClickListener CAh;
  private View.OnClickListener CAi;
  private View.OnClickListener CAj;
  private View.OnClickListener CAk;
  private View.OnClickListener CAl;
  private Runnable CAm;
  private VoIPRenderSurfaceView CyY;
  private VoIPRenderSurfaceView CyZ;
  private TextView CzA;
  private TextView CzB;
  private TextView CzC;
  private e CzD;
  private Button CzE;
  private Button CzF;
  private boolean CzG;
  private int CzH;
  private int CzI;
  private int CzJ;
  private int CzK;
  private boolean CzL;
  private boolean CzM;
  private int CzN;
  private boolean CzO;
  private boolean CzP;
  public long CzQ;
  private a CzR;
  public int CzS;
  public int CzT;
  private int CzU;
  private int CzV;
  private aw CzW;
  private boolean CzX;
  private boolean CzY;
  private boolean CzZ;
  private ImageView Cza;
  private View Czb;
  private ImageView Czc;
  private TextView Czd;
  private TextView Cze;
  private TextView Czf;
  private TextView Czg;
  private View Czh;
  private TextView Czi;
  private TextView Czj;
  private TextView Czk;
  private RelativeLayout Czl;
  private Button Czm;
  private VoipSmallIconButton Czn;
  private VoipSmallIconButton Czo;
  private VoipSmallIconButton Czp;
  private VoipBigIconButton Czq;
  private VoipBigIconButton Czr;
  private VoipBigIconButton Czs;
  private VoipBigIconButton Czt;
  private VoipBigIconButton Czu;
  private VoipBigIconButton Czv;
  private TextView Czw;
  private TextView Czx;
  private TextView Czy;
  private TextView Czz;
  private PowerManager.WakeLock gNb;
  private Timer mTimer;
  private long myg;
  private boolean pdM;
  private int pgg;
  private boolean pgi;
  private Runnable qce;
  private TextView vhc;
  private Bitmap xQW;
  
  public NewVoipVideoFragment()
  {
    AppMethodBeat.i(210149);
    this.CzD = null;
    this.CzE = null;
    this.CzF = null;
    this.CzG = false;
    com.tencent.mm.plugin.voip.b.h localh = com.tencent.mm.plugin.voip.b.h.CCW;
    this.CzL = com.tencent.mm.plugin.voip.b.h.eDp();
    localh = com.tencent.mm.plugin.voip.b.h.CCW;
    this.CzM = com.tencent.mm.plugin.voip.b.h.eDo();
    this.CzN = 0;
    this.CzO = false;
    this.pgi = false;
    this.pdM = false;
    this.CzQ = 0L;
    this.xQW = null;
    this.CzS = 0;
    this.CzT = 0;
    this.CzU = 0;
    this.myg = 0L;
    this.CzV = 0;
    this.CzW = null;
    this.CzX = false;
    this.CzY = false;
    this.CzZ = false;
    this.CAa = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210123);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
        if ((NewVoipVideoFragment.this.CAv != null) && (NewVoipVideoFragment.this.CAv.get() != null) && (((c)NewVoipVideoFragment.this.CAv.get()).eyD()))
        {
          NewVoipVideoFragment.a(NewVoipVideoFragment.this).setEnabled(false);
          NewVoipVideoFragment.b(NewVoipVideoFragment.this).setEnabled(false);
          NewVoipVideoFragment.this.iz(2131764857, -1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210123);
      }
    };
    this.CAb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210135);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((NewVoipVideoFragment.this.CAv != null) && (NewVoipVideoFragment.this.CAv.get() != null)) {
          ((c)NewVoipVideoFragment.this.CAv.get()).eyW();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210135);
      }
    };
    this.CAc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210136);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((NewVoipVideoFragment.this.CAv != null) && (NewVoipVideoFragment.this.CAv.get() != null)) {
          ((c)NewVoipVideoFragment.this.CAv.get()).eyW();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210136);
      }
    };
    this.CAd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210139);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
        if ((az.isWifi(NewVoipVideoFragment.this.getActivity())) || (s.eAB())) {
          NewVoipVideoFragment.c(NewVoipVideoFragment.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(210139);
          return;
          com.tencent.mm.ui.base.h.a(NewVoipVideoFragment.this.getActivity(), 2131764898, 2131764899, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(210137);
              s.eAA();
              NewVoipVideoFragment.c(NewVoipVideoFragment.this);
              AppMethodBeat.o(210137);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(210138);
              NewVoipVideoFragment.d(NewVoipVideoFragment.this);
              AppMethodBeat.o(210138);
            }
          });
        }
      }
    };
    this.CAe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210142);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
        if ((az.isWifi(NewVoipVideoFragment.this.getActivity())) || ((s.eAB()) && (!az.is2G(NewVoipVideoFragment.this.getActivity())))) {
          NewVoipVideoFragment.e(NewVoipVideoFragment.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(210142);
          return;
          com.tencent.mm.ui.base.h.a(NewVoipVideoFragment.this.getActivity(), 2131764898, 2131764899, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(210140);
              if (!az.is2G(NewVoipVideoFragment.this.getActivity())) {
                s.eAA();
              }
              NewVoipVideoFragment.e(NewVoipVideoFragment.this);
              AppMethodBeat.o(210140);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(210141);
              NewVoipVideoFragment.d(NewVoipVideoFragment.this);
              AppMethodBeat.o(210141);
            }
          });
        }
      }
    };
    this.CAf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210143);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "click reject video invite button");
        NewVoipVideoFragment.d(NewVoipVideoFragment.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210143);
      }
    };
    this.CAg = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210144);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
        if ((NewVoipVideoFragment.this.CAv != null) && (NewVoipVideoFragment.this.CAv.get() != null) && (((c)NewVoipVideoFragment.this.CAv.get()).eyK()))
        {
          NewVoipVideoFragment.a(NewVoipVideoFragment.this).setEnabled(false);
          NewVoipVideoFragment.f(NewVoipVideoFragment.this).setEnabled(false);
          NewVoipVideoFragment.g(NewVoipVideoFragment.this).setVisibility(0);
          NewVoipVideoFragment.g(NewVoipVideoFragment.this).setText(2131764813);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210144);
      }
    };
    this.CAh = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210145);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (System.currentTimeMillis() - NewVoipVideoFragment.h(NewVoipVideoFragment.this) <= 1000L)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(210145);
          return;
        }
        NewVoipVideoFragment.a(NewVoipVideoFragment.this, System.currentTimeMillis());
        com.tencent.mm.plugin.report.service.g.yxI.f(11618, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
        if (NewVoipVideoFragment.this.CAN != null) {
          NewVoipVideoFragment.this.CAN.aw(false, true);
        }
        if ((NewVoipVideoFragment.this.CAv != null) && (NewVoipVideoFragment.this.CAv.get() != null)) {
          ((c)NewVoipVideoFragment.this.CAv.get()).tm(true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210145);
      }
    };
    this.CAi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210146);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.report.service.g.yxI.f(11619, new Object[] { Integer.valueOf(2) });
        if ((NewVoipVideoFragment.this.CAv != null) && (NewVoipVideoFragment.this.CAv.get() != null)) {
          ((c)NewVoipVideoFragment.this.CAv.get()).ezj();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210146);
      }
    };
    this.CAj = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210124);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
          AppMethodBeat.o(210124);
          return;
        }
      }
    };
    this.CAk = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210125);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        boolean bool2 = bu.a((Boolean)paramAnonymousView.getTag(), false);
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
          if ((NewVoipVideoFragment.this.CAv != null) && (NewVoipVideoFragment.this.CAv.get() != null)) {
            ((c)NewVoipVideoFragment.this.CAv.get()).ezk();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(210125);
          return;
          bool1 = false;
          break;
          label159:
          Toast.makeText(NewVoipVideoFragment.this.getActivity(), "start face detect", 0).show();
        }
      }
    };
    this.CAl = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210128);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
        NewVoipVideoFragment.o(NewVoipVideoFragment.this).setEnabled(false);
        NewVoipVideoFragment.p(NewVoipVideoFragment.this);
        NewVoipVideoFragment.o(NewVoipVideoFragment.this).setEnabled(true);
        if ((NewVoipVideoFragment.this.CAv != null) && (NewVoipVideoFragment.this.CAv.get() != null)) {
          ((c)NewVoipVideoFragment.this.CAv.get()).eyP();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210128);
      }
    };
    this.CAm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210129);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
        NewVoipVideoFragment.q(NewVoipVideoFragment.this);
        if ((NewVoipVideoFragment.this.getActivity() == null) || (NewVoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(210129);
          return;
        }
        if (NewVoipVideoFragment.r(NewVoipVideoFragment.this) > 0)
        {
          AppMethodBeat.o(210129);
          return;
        }
        NewVoipVideoFragment.o(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.s(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.t(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.a(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.b(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.d(NewVoipVideoFragment.this, false);
        AppMethodBeat.o(210129);
      }
    };
    this.qce = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210130);
        if ((NewVoipVideoFragment.this.getActivity() == null) || (NewVoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(210130);
          return;
        }
        NewVoipVideoFragment.g(NewVoipVideoFragment.this).setVisibility(8);
        AppMethodBeat.o(210130);
      }
    };
    AppMethodBeat.o(210149);
  }
  
  private void Vf(int paramInt)
  {
    AppMethodBeat.i(210166);
    this.CAO.eCG();
    this.Czq.setEnabled(false);
    this.Czu.setEnabled(false);
    this.Czt.setEnabled(false);
    this.Czs.setEnabled(false);
    this.Czr.setEnabled(false);
    this.Czp.setEnabled(false);
    this.Czv.setEnabled(false);
    this.Czo.setEnabled(false);
    this.Czn.setEnabled(false);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.CAN != null) {
        this.CAN.aw(true, false);
      }
      AppMethodBeat.o(210166);
      return;
      this.Czj.setVisibility(0);
      this.Czj.setText(2131764897);
    }
  }
  
  private void aUH()
  {
    AppMethodBeat.i(210167);
    if ((this.mTimer == null) || (this.pgi))
    {
      AppMethodBeat.o(210167);
      return;
    }
    if (-1L == this.CAw) {
      this.CAw = bu.aRi();
    }
    this.CzQ = this.CAw;
    this.pgi = true;
    TimerTask local9 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(210132);
        NewVoipVideoFragment.this.jzz.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(210131);
            String str = NewVoipVideoFragment.sz(bu.rZ(NewVoipVideoFragment.this.CAw));
            NewVoipVideoFragment.t(NewVoipVideoFragment.this).setText(str);
            NewVoipVideoFragment.u(NewVoipVideoFragment.this);
            AppMethodBeat.o(210131);
          }
        });
        AppMethodBeat.o(210132);
      }
    };
    this.mTimer.schedule(local9, 1000L, 1000L);
    this.CzW = new aw("VoipVideoFragment_cpuStatThread", new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(210133);
        if (NewVoipVideoFragment.v(NewVoipVideoFragment.this))
        {
          NewVoipVideoFragment.w(NewVoipVideoFragment.this);
          AppMethodBeat.o(210133);
          return true;
        }
        AppMethodBeat.o(210133);
        return false;
      }
    }, true);
    this.CzX = true;
    this.CzW.ay(1000L, 1000L);
    AppMethodBeat.o(210167);
  }
  
  private void eCA()
  {
    AppMethodBeat.i(210168);
    View.OnClickListener local11 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(210134);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.report.service.g.yxI.f(11079, new Object[] { Integer.valueOf(4) });
        if ((!NewVoipVideoFragment.k(NewVoipVideoFragment.this)) && (NewVoipVideoFragment.this.CAv.get() != null)) {
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
          if (ac.iSu)
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
          AppMethodBeat.o(210134);
          return;
          i = 0;
          break;
        }
      }
    };
    this.lUu.setOnClickListener(local11);
    AppMethodBeat.o(210168);
  }
  
  private void eCt()
  {
    AppMethodBeat.i(210152);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
    this.CzN += 1;
    this.jzz.postDelayed(this.CAm, 10000L);
    AppMethodBeat.o(210152);
  }
  
  private void eCw()
  {
    AppMethodBeat.i(210162);
    this.CyY.setVisibility(0);
    if (this.CAK != null) {
      eCF();
    }
    this.Czb.setVisibility(0);
    this.Czd.setVisibility(0);
    if ((an.aUq(this.fIQ)) && (!bu.ah(this.Cze.getText()))) {
      this.Cze.setVisibility(0);
    }
    for (;;)
    {
      this.Czf.setText(2131764876);
      this.Czh.setVisibility(0);
      this.Czc.setVisibility(0);
      this.CAO.a(this.Czg, CAI);
      this.Czv.setVisibility(8);
      this.Czu.setVisibility(8);
      this.Czq.setVisibility(8);
      this.Czt.setVisibility(8);
      this.Czs.setVisibility(0);
      this.Czp.setVisibility(0);
      this.Czr.setVisibility(0);
      this.Czo.setVisibility(8);
      if (this.CzP) {
        this.Czn.setVisibility(0);
      }
      this.Czk.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.eys().CqG != null)
      {
        this.Czk.setVisibility(0);
        this.Czk.setText(com.tencent.mm.plugin.voip.c.eys().CqG);
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geM.gak == 1)
      {
        this.Cza.setVisibility(0);
        this.CyY.setVisibility(4);
      }
      AppMethodBeat.o(210162);
      return;
      this.Cze.setVisibility(8);
    }
  }
  
  private void eCx()
  {
    AppMethodBeat.i(210163);
    this.Czh.setVisibility(0);
    this.CyY.setVisibility(0);
    this.Czf.setText(2131764874);
    if ((an.aUq(this.fIQ)) && (!bu.ah(this.Cze.getText()))) {
      this.Cze.setVisibility(0);
    }
    for (;;)
    {
      this.CAJ.setVisibility(8);
      this.Czj.setVisibility(8);
      this.Czk.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.eys().CqG != null)
      {
        this.Czk.setVisibility(0);
        this.Czk.setText(com.tencent.mm.plugin.voip.c.eys().CqG);
      }
      this.CAO.a(this.Czg, CAI);
      this.Czv.setVisibility(8);
      this.Czu.setVisibility(8);
      this.Czq.setVisibility(0);
      this.Czt.setVisibility(8);
      this.Czs.setVisibility(8);
      this.Czp.setVisibility(8);
      this.Czr.setVisibility(8);
      this.Czo.setVisibility(0);
      this.Czn.setVisibility(8);
      AppMethodBeat.o(210163);
      return;
      this.Cze.setVisibility(8);
    }
  }
  
  private void eCy()
  {
    boolean bool2 = true;
    AppMethodBeat.i(210164);
    if (this.CAK != null) {
      this.CAK.setVisibility(8);
    }
    if (this.CyZ == null)
    {
      AppMethodBeat.o(210164);
      return;
    }
    if (this.CyZ.getVisibility() == 0)
    {
      AppMethodBeat.o(210164);
      return;
    }
    label85:
    Point localPoint;
    if (this.Cqi) {
      if (!this.CzO)
      {
        bool1 = true;
        this.CzO = bool1;
        if (this.CzO) {
          break label433;
        }
        bool1 = true;
        localPoint = tB(bool1);
        this.CyZ.iC(localPoint.x, localPoint.y);
        if (ac.iSu)
        {
          this.Czw.setVisibility(0);
          this.Czx.setVisibility(0);
          this.Czy.setVisibility(0);
          this.Czz.setVisibility(0);
          this.CzA.setVisibility(0);
          this.CzB.setVisibility(0);
          this.CzC.setVisibility(0);
        }
        this.Czb.setVisibility(8);
        this.CyY.setVisibility(0);
        this.CyZ.setVisibility(0);
        this.Czi.setVisibility(0);
        this.Czm.setVisibility(0);
        this.Czv.setVisibility(0);
        this.Czu.setVisibility(0);
        this.Czq.setVisibility(8);
        this.Czt.setVisibility(0);
        this.Czs.setVisibility(8);
        this.Czp.setVisibility(8);
        this.Czr.setVisibility(8);
        this.Czo.setVisibility(8);
        this.Czn.setVisibility(8);
        ((c)this.CAv.get()).tl(this.CzO);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", new Object[] { Integer.valueOf(this.CzS) });
        if (this.CzO) {
          break label460;
        }
      }
    }
    label433:
    label460:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPoint = tB(bool1);
      ((NewMovableVideoView)this.CyZ).iA(localPoint.x, localPoint.y);
      aUH();
      if (ak.fox().getBoolean("voipfaceDebug", false))
      {
        this.CzE.setVisibility(0);
        this.CzF.setVisibility(0);
      }
      eCt();
      if (this.CAL == 4102) {
        iz(2131764783, 10000);
      }
      AppMethodBeat.o(210164);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label85;
      if (!this.CzO) {}
      for (bool1 = true;; bool1 = false)
      {
        this.CzO = bool1;
        break;
      }
    }
  }
  
  private void eCz()
  {
    AppMethodBeat.i(210165);
    this.Czf.setText(2131764949);
    this.CAO.a(this.Czg, CAI);
    AppMethodBeat.o(210165);
  }
  
  private Point tB(boolean paramBoolean)
  {
    AppMethodBeat.i(210170);
    int i = (int)(getActivity().getWindowManager().getDefaultDisplay().getHeight() / 5.0D);
    float f = i;
    com.tencent.mm.plugin.voip.c.eys();
    Point localPoint = new Point((int)(f * u.tw(paramBoolean)), i);
    AppMethodBeat.o(210170);
    return localPoint;
  }
  
  private void tz(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(210154);
    if (!this.CzZ)
    {
      if (!paramBoolean) {
        break label115;
      }
      ((c)this.CAv.get()).a(this.CyZ, 1);
      ((c)this.CAv.get()).a(this.CyY, 0);
    }
    for (;;)
    {
      c localc = (c)this.CAv.get();
      paramBoolean = bool;
      if (260 != this.mStatus)
      {
        paramBoolean = bool;
        if (6 != this.mStatus) {
          paramBoolean = true;
        }
      }
      localc.at(true, paramBoolean);
      this.CzZ = true;
      AppMethodBeat.o(210154);
      return;
      label115:
      ((c)this.CAv.get()).a(this.CyZ, 0);
      ((c)this.CAv.get()).a(this.CyY, 1);
    }
  }
  
  public final void Vc(int paramInt)
  {
    this.CzI += 1;
    if (paramInt > 0) {
      this.CzH += 1;
    }
  }
  
  public final void Vd(int paramInt)
  {
    this.CzS = paramInt;
  }
  
  public final void Ve(int paramInt)
  {
    this.CzT = paramInt;
  }
  
  protected final void aFb(String paramString)
  {
    AppMethodBeat.i(210157);
    if (this.Czk != null)
    {
      this.Czk.setVisibility(0);
      this.Czk.setText(paramString);
    }
    AppMethodBeat.o(210157);
  }
  
  public final void eCr()
  {
    this.pgg += 1;
  }
  
  protected final void eCu()
  {
    AppMethodBeat.i(210160);
    if (this.vhc != null)
    {
      this.vhc.clearAnimation();
      this.vhc.setVisibility(8);
    }
    AppMethodBeat.o(210160);
  }
  
  public final void eCv()
  {
    AppMethodBeat.i(210161);
    VoIPRenderSurfaceView localVoIPRenderSurfaceView = this.CyY;
    com.tencent.mm.sdk.platformtools.ae.i("RenderView", "new size from resource Helper w %s * h  %s", new Object[] { Integer.valueOf(com.tencent.mm.cb.a.iu(localVoIPRenderSurfaceView.getContext())), Integer.valueOf(com.tencent.mm.cb.a.iv(localVoIPRenderSurfaceView.getContext())) });
    int i = com.tencent.mm.cb.a.iu(localVoIPRenderSurfaceView.getContext());
    int j = com.tencent.mm.cb.a.iv(localVoIPRenderSurfaceView.getContext());
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
      if (this.CyZ != null)
      {
        localObject = (NewMovableVideoView)this.CyZ;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MovableVideoView", "refrsh view %s, %s", new Object[] { Integer.valueOf(((NewMovableVideoView)localObject).mWidth), Integer.valueOf(((NewMovableVideoView)localObject).CEE) });
        ((NewMovableVideoView)localObject).mScreenWidth = 0;
        ((NewMovableVideoView)localObject).iA(((NewMovableVideoView)localObject).mWidth, ((NewMovableVideoView)localObject).CEE);
      }
      AppMethodBeat.o(210161);
      return;
      f = j / i;
      break;
      label199:
      localObject = new RelativeLayout.LayoutParams(j * 9 / 16, j);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
    }
  }
  
  public final void iy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210153);
    super.iy(paramInt1, paramInt2);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + com.tencent.mm.plugin.voip.b.l.Vr(paramInt2));
    if (this.lUu == null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
      AppMethodBeat.o(210153);
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
        if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gak == 1) && (paramInt1 != 0)) {
          this.Cza.setVisibility(8);
        }
        AppMethodBeat.o(210153);
        return;
        this.CzY = true;
        tz(true);
        eCx();
        paramInt1 = 1;
        continue;
        this.CzY = true;
        tz(true);
        eCw();
        paramInt1 = 0;
        continue;
        eCA();
        if (this.CzY)
        {
          ((c)this.CAv.get()).eyR();
          i.tI(false);
          this.CzY = false;
        }
        for (;;)
        {
          eCy();
          paramInt1 = 1;
          break;
          tz(false);
        }
        Vf(paramInt1);
        paramInt1 = 1;
      }
      eCz();
    }
  }
  
  protected final void iz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210158);
    if (this.Czj == null)
    {
      AppMethodBeat.o(210158);
      return;
    }
    this.Czj.setText(paramInt1);
    this.Czj.setVisibility(0);
    this.Czj.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.Czj.setBackgroundResource(2131234591);
    this.Czj.setCompoundDrawables(null, null, null, null);
    this.Czj.setCompoundDrawablePadding(0);
    this.jzz.removeCallbacks(this.qce);
    if (-1 != paramInt2) {
      this.jzz.postDelayed(this.qce, paramInt2);
    }
    AppMethodBeat.o(210158);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(210150);
    this.lUu = ((RelativeLayout)paramLayoutInflater.inflate(2131495882, paramViewGroup, false));
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)this.lUu.findViewById(2131304205)).setPadding(0, 0, 0, BackwardSupportUtil.b.h(getActivity(), 40.0F));
    }
    this.CAJ = ((ImageView)this.lUu.findViewById(2131306556));
    this.CAK = ((ImageView)this.lUu.findViewById(2131306592));
    this.Czl = ((RelativeLayout)this.lUu.findViewById(2131301467));
    this.CyY = ((VoIPRenderSurfaceView)this.lUu.findViewById(2131297220));
    this.CyY.iD(mScreenWidth, mScreenHeight);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "steve: onCreateView!");
    this.Czv = ((VoipBigIconButton)this.lUu.findViewById(2131306588));
    this.Czv.setOnClickListener(this.CAl);
    this.Czu = ((VoipBigIconButton)this.lUu.findViewById(2131306604));
    this.Czu.setOnClickListener(this.CAb);
    this.Czq = ((VoipBigIconButton)this.lUu.findViewById(2131306557));
    this.Czq.setOnClickListener(this.CAg);
    this.Czt = ((VoipBigIconButton)this.lUu.findViewById(2131306574));
    this.Czt.setOnClickListener(this.CAa);
    this.Czs = ((VoipBigIconButton)this.lUu.findViewById(2131306553));
    this.Czs.setOnClickListener(this.CAe);
    this.Czp = ((VoipSmallIconButton)this.lUu.findViewById(2131306554));
    this.Czp.setOnClickListener(this.CAd);
    this.Czr = ((VoipBigIconButton)this.lUu.findViewById(2131306585));
    this.Czr.setOnClickListener(this.CAf);
    this.Czo = ((VoipSmallIconButton)this.lUu.findViewById(2131306589));
    this.Czo.setOnClickListener(this.CAc);
    if (n.Jh("VOIPBlockIgnoreButton") == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.CzP = bool;
      this.Czn = ((VoipSmallIconButton)this.lUu.findViewById(2131306575));
      this.Czn.setOnClickListener(this.CAi);
      if (!this.CzP) {
        this.Czn.setVisibility(8);
      }
      this.Czi = ((TextView)this.lUu.findViewById(2131306605));
      this.Czb = this.lUu.findViewById(2131306598);
      this.Czc = ((ImageView)this.lUu.findViewById(2131306597));
      a.b.a(this.Czc, this.fIQ, 0.0588235F, true);
      this.Czd = ((TextView)this.lUu.findViewById(2131306599));
      this.Cze = ((TextView)this.lUu.findViewById(2131306601));
      this.Czf = ((TextView)this.lUu.findViewById(2131306594));
      this.Czg = ((TextView)this.lUu.findViewById(2131306596));
      this.Czh = this.lUu.findViewById(2131306595);
      r(this.Czg);
      this.Czj = ((TextView)this.lUu.findViewById(2131306593));
      this.Czk = ((TextView)this.lUu.findViewById(2131306603));
      this.Czm = ((Button)this.lUu.findViewById(2131297592));
      this.vhc = ((TextView)this.lUu.findViewById(2131306581));
      this.Cza = ((ImageView)this.lUu.findViewById(2131300320));
      paramLayoutInflater = com.tencent.mm.aj.c.a(this.fIQ, false, -1, null);
      this.Cza.setImageBitmap(com.tencent.mm.sdk.platformtools.h.l(paramLayoutInflater, 10));
      if (ac.iSu)
      {
        this.Czw = ((TextView)this.lUu.findViewById(2131306558));
        this.Czx = ((TextView)this.lUu.findViewById(2131306586));
        this.Czy = ((TextView)this.lUu.findViewById(2131306583));
        this.Czz = ((TextView)this.lUu.findViewById(2131306587));
        this.CzA = ((TextView)this.lUu.findViewById(2131306584));
        this.CzB = ((TextView)this.lUu.findViewById(2131299493));
        this.CzC = ((TextView)this.lUu.findViewById(2131306029));
      }
      this.CzE = ((Button)this.lUu.findViewById(2131306572));
      this.CzF = ((Button)this.lUu.findViewById(2131306573));
      this.CzE.setVisibility(8);
      this.CzF.setVisibility(8);
      this.CzE.setOnClickListener(this.CAj);
      this.CzF.setOnClickListener(this.CAk);
      this.CzD = new e(getActivity());
      this.lUu.addView(this.CzD);
      this.CzD.setVisibility(8);
      this.Czm.setOnClickListener(this.CAh);
      int i = t.kd(getActivity());
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipVideoFragment", "statusHeight: ".concat(String.valueOf(i)));
      av(this.Czm, i);
      av(this.lUu.findViewById(2131306591), i);
      av(this.Czb, i);
      this.CzI = 0;
      this.CzH = 0;
      this.pgg = 0;
      this.CzJ = 0;
      this.CzK = 0;
      this.CzU = 0;
      this.CzV = 0;
      paramLayoutInflater = (WindowManager)getActivity().getSystemService("window");
      i = paramLayoutInflater.getDefaultDisplay().getHeight() / 5;
      int j = paramLayoutInflater.getDefaultDisplay().getWidth() * i / paramLayoutInflater.getDefaultDisplay().getHeight();
      this.CyZ = new NewMovableVideoView(ak.getContext());
      ((NewMovableVideoView)this.CyZ).iA(j, i);
      this.CyZ.setVisibility(4);
      this.CyY.setVisibility(0);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
      this.lUu.addView(this.CyZ);
      this.CyZ.setOnClickListener(new View.OnClickListener()
      {
        long CAo = 0L;
        
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(210126);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
          this.CAo = bu.HQ();
          paramAnonymousView = NewVoipVideoFragment.this;
          if (!NewVoipVideoFragment.k(NewVoipVideoFragment.this))
          {
            bool = true;
            NewVoipVideoFragment.b(paramAnonymousView, bool);
            ((c)NewVoipVideoFragment.this.CAv.get()).eyR();
            i.tI(true);
            paramAnonymousView = NewVoipVideoFragment.this;
            if (NewVoipVideoFragment.k(NewVoipVideoFragment.this)) {
              break label187;
            }
          }
          label187:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView = NewVoipVideoFragment.c(paramAnonymousView, bool);
            if (NewVoipVideoFragment.l(NewVoipVideoFragment.this) != null) {
              NewVoipVideoFragment.l(NewVoipVideoFragment.this).iC(paramAnonymousView.x, paramAnonymousView.y);
            }
            com.tencent.mm.plugin.report.service.g.yxI.f(11079, new Object[] { Integer.valueOf(3) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(210126);
            return;
            bool = false;
            break;
          }
        }
      });
      paramLayoutInflater = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.fIQ);
      this.Czd.setText(k.b(getActivity(), w.b(paramLayoutInflater, this.fIQ), this.Czd.getTextSize()));
      paramLayoutInflater = com.tencent.mm.openim.room.a.a.O(paramLayoutInflater);
      if (!bu.isNullOrNil(paramLayoutInflater)) {
        this.Cze.setText(paramLayoutInflater);
      }
      if (this.Cqi) {
        this.jzz.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(210127);
            NewVoipVideoFragment.m(NewVoipVideoFragment.this).setText(2131764874);
            NewVoipVideoFragment.this.CAO.a(NewVoipVideoFragment.n(NewVoipVideoFragment.this), VoipBaseFragment.CAI);
            AppMethodBeat.o(210127);
          }
        }, 2000L);
      }
      this.mTimer = new Timer("VoIP_video_talking_count");
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", new Object[] { Integer.valueOf(this.CzT) });
      this.pdM = true;
      ((c)this.CAv.get()).eyS();
      iy(0, this.mStatus);
      this.gNb = ((PowerManager)ak.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipVideoFragment");
      this.gNb.acquire();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "acquire wakelock");
      paramLayoutInflater = this.lUu;
      AppMethodBeat.o(210150);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(210151);
    this.pgi = false;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "onDestory");
    super.onDestroy();
    if ((this.gNb != null) && (this.gNb.isHeld()))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "release waklock");
      this.gNb.release();
    }
    AppMethodBeat.o(210151);
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(210156);
    super.onDestroyView();
    if (this.CyY != null)
    {
      this.CyY.setVisibility(8);
      this.CyY = null;
    }
    AppMethodBeat.o(210156);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(210169);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "onDetach");
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    if (this.CzW != null) {
      this.CzW.stopTimer();
    }
    this.CzX = false;
    super.onDetach();
    AppMethodBeat.o(210169);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt) {}
  
  protected final void tA(boolean paramBoolean)
  {
    AppMethodBeat.i(210159);
    if (this.vhc != null)
    {
      if (!paramBoolean) {
        break label49;
      }
      this.vhc.setText(2131764892);
    }
    for (;;)
    {
      this.vhc.clearAnimation();
      this.vhc.setVisibility(0);
      AppMethodBeat.o(210159);
      return;
      label49:
      this.vhc.setText(2131764891);
    }
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(210155);
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.Voip.VoipVideoFragment", "unit should not be allow in foreground", new Object[0]);
    if ((this.CyY != null) && (this.CAv.get() != null)) {
      this.CyY.release();
    }
    if (this.CAv.get() != null)
    {
      ((c)this.CAv.get()).a(this.CyY);
      ((c)this.CAv.get()).a(this.CyZ);
    }
    if (this.CyZ != null)
    {
      this.CyZ.release();
      this.CyZ.setVisibility(4);
      this.CyZ = null;
    }
    if (this.CzR != null)
    {
      this.CzR.cancel();
      this.CzR = null;
    }
    super.uninit();
    AppMethodBeat.o(210155);
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
      AppMethodBeat.i(210148);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
      final Bitmap localBitmap = NewVoipVideoFragment.E(this.CAn);
      this.CAn.jzz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(210147);
          if (NewVoipVideoFragment.a.this.CAn.CAJ != null) {
            NewVoipVideoFragment.a.this.CAn.CAJ.setBackgroundDrawable(new BitmapDrawable(localBitmap));
          }
          NewVoipVideoFragment.F(NewVoipVideoFragment.a.this.CAn);
          AppMethodBeat.o(210147);
        }
      });
      AppMethodBeat.o(210148);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment
 * JD-Core Version:    0.7.0.1
 */