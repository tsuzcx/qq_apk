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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.model.w;
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

public class VoipVideoFragment
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
  private OpenGlRender CBA;
  private OpenGlRender CBB;
  private VoIPVideoView CBC;
  private a CBD;
  private d CBE;
  int CBF;
  private OpenGlView CBy;
  private OpenGlView CBz;
  public int CqV;
  public int CqW;
  private TextView CzA;
  private TextView CzB;
  private e CzD;
  private Button CzE;
  private Button CzF;
  private boolean CzG;
  private int CzH;
  private int CzI;
  private int CzJ;
  private int CzK;
  private int CzN;
  private boolean CzO;
  private boolean CzP;
  public long CzQ;
  public int CzS;
  public int CzT;
  private int CzU;
  private int CzV;
  private aw CzW;
  private boolean CzX;
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
  private CaptureView pdJ;
  private boolean pdM;
  private int pgg;
  private boolean pgi;
  private Runnable qce;
  private SurfaceTexture surfaceTexture;
  private TextView vhc;
  Bitmap wsX;
  int[] wwH;
  private Bitmap xQW;
  
  public VoipVideoFragment()
  {
    AppMethodBeat.i(115420);
    this.CzD = null;
    this.CzE = null;
    this.CzF = null;
    this.CzG = false;
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
    this.CqV = 0;
    this.CqW = 0;
    this.surfaceTexture = null;
    this.CAa = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115394);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
        if ((VoipVideoFragment.this.CAv != null) && (VoipVideoFragment.this.CAv.get() != null) && (((c)VoipVideoFragment.this.CAv.get()).eyD()))
        {
          VoipVideoFragment.a(VoipVideoFragment.this).setEnabled(false);
          VoipVideoFragment.b(VoipVideoFragment.this).setEnabled(false);
          VoipVideoFragment.this.iz(2131764857, -1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115394);
      }
    };
    this.CAb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115406);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((VoipVideoFragment.this.CAv != null) && (VoipVideoFragment.this.CAv.get() != null)) {
          ((c)VoipVideoFragment.this.CAv.get()).eyW();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115406);
      }
    };
    this.CAc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115407);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((VoipVideoFragment.this.CAv != null) && (VoipVideoFragment.this.CAv.get() != null)) {
          ((c)VoipVideoFragment.this.CAv.get()).eyW();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115407);
      }
    };
    this.CAd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115410);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
        if ((az.isWifi(VoipVideoFragment.this.getActivity())) || (s.eAB())) {
          VoipVideoFragment.c(VoipVideoFragment.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115410);
          return;
          com.tencent.mm.ui.base.h.a(VoipVideoFragment.this.getActivity(), 2131764898, 2131764899, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(115408);
              s.eAA();
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
    this.CAe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115413);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
        if ((az.isWifi(VoipVideoFragment.this.getActivity())) || ((s.eAB()) && (!az.is2G(VoipVideoFragment.this.getActivity())))) {
          VoipVideoFragment.e(VoipVideoFragment.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115413);
          return;
          com.tencent.mm.ui.base.h.a(VoipVideoFragment.this.getActivity(), 2131764898, 2131764899, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(115411);
              if (!az.is2G(VoipVideoFragment.this.getActivity())) {
                s.eAA();
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
    this.CAf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115414);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "click reject video invite button");
        VoipVideoFragment.d(VoipVideoFragment.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115414);
      }
    };
    this.CAg = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115415);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
        if ((VoipVideoFragment.this.CAv != null) && (VoipVideoFragment.this.CAv.get() != null) && (((c)VoipVideoFragment.this.CAv.get()).eyK()))
        {
          VoipVideoFragment.a(VoipVideoFragment.this).setEnabled(false);
          VoipVideoFragment.f(VoipVideoFragment.this).setEnabled(false);
          VoipVideoFragment.g(VoipVideoFragment.this).setVisibility(0);
          VoipVideoFragment.g(VoipVideoFragment.this).setText(2131764813);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115415);
      }
    };
    this.CAh = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115416);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (System.currentTimeMillis() - VoipVideoFragment.h(VoipVideoFragment.this) <= 1000L)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115416);
          return;
        }
        VoipVideoFragment.a(VoipVideoFragment.this, System.currentTimeMillis());
        com.tencent.mm.plugin.report.service.g.yxI.f(11618, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
        if ((VoipVideoFragment.this.CAv != null) && (VoipVideoFragment.this.CAv.get() != null)) {
          ((c)VoipVideoFragment.this.CAv.get()).tm(true);
        }
        if (VoipVideoFragment.this.CAN != null)
        {
          VoipVideoFragment.this.eCC();
          VoipVideoFragment.this.CAN.aw(false, true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115416);
      }
    };
    this.CAi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115417);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.report.service.g.yxI.f(11619, new Object[] { Integer.valueOf(2) });
        if ((VoipVideoFragment.this.CAv != null) && (VoipVideoFragment.this.CAv.get() != null)) {
          ((c)VoipVideoFragment.this.CAv.get()).ezj();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115417);
      }
    };
    this.CAj = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115395);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
    this.CAk = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115396);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        boolean bool2 = bu.a((Boolean)paramAnonymousView.getTag(), false);
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
          if ((VoipVideoFragment.this.CAv != null) && (VoipVideoFragment.this.CAv.get() != null)) {
            ((c)VoipVideoFragment.this.CAv.get()).ezk();
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
    this.CAl = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210200);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
        VoipVideoFragment.o(VoipVideoFragment.this).setEnabled(false);
        VoipVideoFragment.p(VoipVideoFragment.this);
        VoipVideoFragment.o(VoipVideoFragment.this).setEnabled(true);
        if ((VoipVideoFragment.this.CAv != null) && (VoipVideoFragment.this.CAv.get() != null)) {
          ((c)VoipVideoFragment.this.CAv.get()).eyP();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210200);
      }
    };
    this.CAm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115403);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
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
    this.qce = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210201);
        if ((VoipVideoFragment.this.getActivity() == null) || (VoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(210201);
          return;
        }
        VoipVideoFragment.g(VoipVideoFragment.this).setVisibility(8);
        AppMethodBeat.o(210201);
      }
    };
    this.wwH = null;
    this.CBF = 0;
    this.wsX = null;
    AppMethodBeat.o(115420);
  }
  
  private void Vf(int paramInt)
  {
    AppMethodBeat.i(115448);
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
      AppMethodBeat.o(115448);
      return;
      this.Czj.setVisibility(0);
      this.Czj.setText(2131764897);
    }
  }
  
  private void aUH()
  {
    AppMethodBeat.i(115449);
    if ((this.mTimer == null) || (this.pgi))
    {
      AppMethodBeat.o(115449);
      return;
    }
    if (-1L == this.CAw) {
      this.CAw = bu.aRi();
    }
    this.CzQ = this.CAw;
    this.pgi = true;
    TimerTask local11 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(210203);
        VoipVideoFragment.this.jzz.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(210202);
            String str = VoipVideoFragment.sz(bu.rZ(VoipVideoFragment.this.CAw));
            VoipVideoFragment.t(VoipVideoFragment.this).setText(str);
            VoipVideoFragment.u(VoipVideoFragment.this);
            AppMethodBeat.o(210202);
          }
        });
        AppMethodBeat.o(210203);
      }
    };
    this.mTimer.schedule(local11, 1000L, 1000L);
    this.CzW = new aw("VoipVideoFragment_cpuStatThread", new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(210204);
        if (VoipVideoFragment.v(VoipVideoFragment.this))
        {
          VoipVideoFragment.w(VoipVideoFragment.this);
          AppMethodBeat.o(210204);
          return true;
        }
        AppMethodBeat.o(210204);
        return false;
      }
    }, true);
    this.CzX = true;
    this.CzW.ay(1000L, 1000L);
    AppMethodBeat.o(115449);
  }
  
  private void b(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115451);
    if ((this.lUu == null) || (paramCaptureView == null))
    {
      AppMethodBeat.o(115451);
      return;
    }
    if ((paramCaptureView.getParent() != null) && ((paramCaptureView.getParent() instanceof ViewGroup))) {
      ((ViewGroup)this.pdJ.getParent()).removeView(this.pdJ);
    }
    this.lUu.removeView(this.pdJ);
    this.pdJ = null;
    if (paramCaptureView.getParent() != null) {
      ((ViewGroup)paramCaptureView.getParent()).removeAllViews();
    }
    this.pdJ = paramCaptureView;
    this.lUu.addView(paramCaptureView, new RelativeLayout.LayoutParams(1, 1));
    this.pdJ.setVisibility(0);
    this.pdJ.setAlpha(0.0F);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView added");
    AppMethodBeat.o(115451);
  }
  
  private void eCA()
  {
    AppMethodBeat.i(115450);
    View.OnClickListener local14 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(210205);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.report.service.g.yxI.f(11079, new Object[] { Integer.valueOf(4) });
        if ((!VoipVideoFragment.l(VoipVideoFragment.this)) && (VoipVideoFragment.this.CAv.get() != null)) {
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
          if (ac.iSu)
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
          AppMethodBeat.o(210205);
          return;
          i = 0;
          break;
        }
      }
    };
    this.lUu.setOnClickListener(local14);
    AppMethodBeat.o(115450);
  }
  
  private void eCt()
  {
    AppMethodBeat.i(115427);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
    this.CzN += 1;
    this.jzz.postDelayed(this.CAm, 10000L);
    AppMethodBeat.o(115427);
  }
  
  private void eCw()
  {
    AppMethodBeat.i(115438);
    this.CBy.setVisibility(0);
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
        this.CBy.setVisibility(4);
      }
      AppMethodBeat.o(115438);
      return;
      this.Cze.setVisibility(8);
    }
  }
  
  private void eCx()
  {
    AppMethodBeat.i(115439);
    this.Czh.setVisibility(0);
    this.CBy.setVisibility(0);
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
      AppMethodBeat.o(115439);
      return;
      this.Cze.setVisibility(8);
    }
  }
  
  private void eCy()
  {
    boolean bool2 = true;
    AppMethodBeat.i(115440);
    if (this.CAK != null) {
      this.CAK.setVisibility(8);
    }
    if (!this.CBz.CFO)
    {
      AppMethodBeat.o(115440);
      return;
    }
    this.CBz.tN(false);
    label79:
    Point localPoint;
    if (this.Cqi) {
      if (!this.CzO)
      {
        bool1 = true;
        this.CzO = bool1;
        if (this.CzO) {
          break label408;
        }
        bool1 = true;
        localPoint = tB(bool1);
        this.CBz.iC(localPoint.x, localPoint.y);
        if (ac.iSu)
        {
          this.Czw.setVisibility(0);
          this.Czx.setVisibility(0);
          this.Czy.setVisibility(0);
          this.Czz.setVisibility(0);
          this.CzA.setVisibility(0);
          this.CzB.setVisibility(0);
        }
        this.Czb.setVisibility(8);
        this.CBy.setVisibility(0);
        this.CBz.setVisibility(0);
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
        setHWDecMode(this.CzS);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", new Object[] { Integer.valueOf(this.CzS) });
        if (this.CzO) {
          break label444;
        }
      }
    }
    label408:
    label444:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPoint = tB(bool1);
      ((MovableVideoView)this.CBz).iA(localPoint.x, localPoint.y);
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
      AppMethodBeat.o(115440);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label79;
      if (!this.CzO) {}
      for (bool1 = true;; bool1 = false)
      {
        this.CzO = bool1;
        this.CBC.setVisibility(8);
        break;
      }
    }
  }
  
  private void eCz()
  {
    AppMethodBeat.i(115447);
    this.Czf.setText(2131764949);
    this.CAO.a(this.Czg, CAI);
    AppMethodBeat.o(115447);
  }
  
  private Point tB(boolean paramBoolean)
  {
    AppMethodBeat.i(115454);
    int i = (int)(getActivity().getWindowManager().getDefaultDisplay().getHeight() / 5.0D);
    float f = i;
    com.tencent.mm.plugin.voip.c.eys();
    Point localPoint = new Point((int)(f * u.tw(paramBoolean)), i);
    AppMethodBeat.o(115454);
    return localPoint;
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    AppMethodBeat.i(115426);
    if ((paramSurfaceTexture == null) || (paramd == null))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture error, videoTexture:%s, videoTexture:%s", new Object[] { paramSurfaceTexture, paramd });
      AppMethodBeat.o(115426);
      return;
    }
    this.surfaceTexture = paramSurfaceTexture;
    this.CBE = paramd;
    if ((!this.pdM) || (this.CBB == null) || (this.CBA == null))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture failed , texId:%d,mInitDone:%b", new Object[] { Integer.valueOf(paramd.hnc), Boolean.valueOf(this.pdM) });
      AppMethodBeat.o(115426);
      return;
    }
    this.CBB.a(this.surfaceTexture, paramd);
    this.CBA.a(this.surfaceTexture, paramd);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture OK , videoTexture:%d", new Object[] { Integer.valueOf(paramd.hnc) });
    AppMethodBeat.o(115426);
  }
  
  public final void a(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115429);
    this.pdJ = paramCaptureView;
    b(this.pdJ);
    AppMethodBeat.o(115429);
  }
  
  protected final void aFb(String paramString)
  {
    AppMethodBeat.i(115433);
    if (this.Czk != null)
    {
      this.Czk.setVisibility(0);
      this.Czk.setText(paramString);
    }
    AppMethodBeat.o(115433);
  }
  
  public final void b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(210206);
    if (!this.pdM)
    {
      AppMethodBeat.o(210206);
      return;
    }
    if (OpenGlRender.CFf == 1)
    {
      if (this.CBF < paramInt1 * paramInt2) {
        this.wwH = null;
      }
      if (this.wwH == null)
      {
        this.CBF = (paramInt1 * paramInt2);
        this.wwH = new int[this.CBF];
      }
      if ((com.tencent.mm.plugin.voip.c.eys().a(paramArrayOfByte, (int)paramLong, paramInt3 & 0x1F, paramInt1, paramInt2, this.wwH, true) < 0) || (this.wwH == null))
      {
        AppMethodBeat.o(210206);
        return;
      }
      if (this.CzO) {
        this.CBA.a(this.wwH, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      }
    }
    for (;;)
    {
      this.CzI += 1;
      this.CzH += 1;
      paramArrayOfByte = this.CzD;
      paramArrayOfByte.CEe = paramInt1;
      paramArrayOfByte.CEf = paramInt2;
      paramArrayOfByte = this.CzD;
      paramInt1 = this.lUu.getWidth();
      paramInt2 = this.lUu.getHeight();
      paramArrayOfByte.CEd = paramInt1;
      paramArrayOfByte.sP = paramInt2;
      AppMethodBeat.o(210206);
      return;
      this.CBB.a(this.wwH, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      continue;
      if (OpenGlRender.CFf == 2) {
        if (this.CzO) {
          this.CBA.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
        } else {
          this.CBB.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
        }
      }
    }
  }
  
  public final void eCC()
  {
    AppMethodBeat.i(115444);
    if (!this.pdM)
    {
      AppMethodBeat.o(115444);
      return;
    }
    this.CBB.eEf();
    this.CBA.eEf();
    AppMethodBeat.o(115444);
  }
  
  public final OpenGlRender eCD()
  {
    if (this.CzO) {
      return this.CBA;
    }
    return this.CBB;
  }
  
  public final void eCI()
  {
    AppMethodBeat.i(115425);
    if ((this.CBB != null) && (this.CBA != null))
    {
      if (!this.CzO) {
        break label119;
      }
      this.CBA.VA(0);
      if ((this.CzS & 0x1) == 0) {
        break label108;
      }
      this.CBB.VA(1);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "changeSurfaceRender, bigViewMode: %d, smallViewMode: %d,mIsSmallViewShowSelf:%b, after changeSurfaceRender", new Object[] { Integer.valueOf(this.CBB.CFu), Integer.valueOf(this.CBA.CFu), Boolean.valueOf(this.CzO) });
      AppMethodBeat.o(115425);
      return;
      label108:
      this.CBB.VA(0);
      continue;
      label119:
      this.CBB.VA(0);
      if ((this.CzS & 0x1) != 0) {
        this.CBA.VA(1);
      } else {
        this.CBA.VA(0);
      }
    }
  }
  
  public final void eCp()
  {
    AppMethodBeat.i(115452);
    if (this.pdJ != null)
    {
      this.lUu.removeView(this.pdJ);
      this.lUu.addView(this.pdJ, new RelativeLayout.LayoutParams(1, 1));
      this.pdJ.setVisibility(0);
      this.pdJ.setAlpha(0.0F);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "resetCaptureView");
    }
    AppMethodBeat.o(115452);
  }
  
  protected final void eCu()
  {
    AppMethodBeat.i(115436);
    if (this.vhc != null)
    {
      this.vhc.clearAnimation();
      this.vhc.setVisibility(8);
    }
    AppMethodBeat.o(115436);
  }
  
  public final void eCv()
  {
    AppMethodBeat.i(115437);
    OpenGlView localOpenGlView = this.CBy;
    com.tencent.mm.sdk.platformtools.ae.i(OpenGlView.TAG, "new size from resoureHelper w %s * h  %s", new Object[] { Integer.valueOf(com.tencent.mm.cb.a.iu(localOpenGlView.getContext())), Integer.valueOf(com.tencent.mm.cb.a.iv(localOpenGlView.getContext())) });
    int i = com.tencent.mm.cb.a.iu(localOpenGlView.getContext());
    int j = com.tencent.mm.cb.a.iv(localOpenGlView.getContext());
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
      if (this.CBz != null)
      {
        localObject = (MovableVideoView)this.CBz;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MovableVideoView", "refrsh view %s, %s", new Object[] { Integer.valueOf(((MovableVideoView)localObject).mWidth), Integer.valueOf(((MovableVideoView)localObject).CEE) });
        ((MovableVideoView)localObject).mScreenWidth = 0;
        ((MovableVideoView)localObject).iA(((MovableVideoView)localObject).mWidth, ((MovableVideoView)localObject).CEE);
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
  
  public final void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115443);
    if (!this.pdM)
    {
      AppMethodBeat.o(115443);
      return;
    }
    this.pgg += 1;
    if (OpenGlRender.CFf == 1)
    {
      if (this.CzO)
      {
        this.CBB.i(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90);
        AppMethodBeat.o(115443);
        return;
      }
      this.CBA.i(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90);
      AppMethodBeat.o(115443);
      return;
    }
    if (this.CzO)
    {
      this.CBB.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
      AppMethodBeat.o(115443);
      return;
    }
    this.CBA.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
    AppMethodBeat.o(115443);
  }
  
  public final void iv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115446);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "adjustHWViewAspectRatio, mInitDone:%b, HWDecsize:%dx%d,  lastHWDecsize:%dx%d", new Object[] { Boolean.valueOf(this.pdM), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.CqV), Integer.valueOf(this.CqW) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(115446);
      return;
    }
    if ((this.CqV != paramInt1) || (this.CqW != paramInt2))
    {
      this.CqV = paramInt1;
      this.CqW = paramInt2;
    }
    if (this.pdM)
    {
      this.CBB.iv(paramInt1, paramInt2);
      this.CBA.iv(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115446);
  }
  
  public final void iy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115428);
    super.iy(paramInt1, paramInt2);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + com.tencent.mm.plugin.voip.b.l.Vr(paramInt2));
    if (this.lUu == null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
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
        if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gak == 1) && (paramInt1 != 0)) {
          this.Cza.setVisibility(8);
        }
        AppMethodBeat.o(115428);
        return;
        eCx();
        paramInt1 = 1;
        continue;
        paramInt1 = 0;
        eCw();
        continue;
        eCA();
        eCy();
        paramInt1 = 1;
        continue;
        Vf(paramInt1);
        paramInt1 = 1;
      }
      eCz();
    }
  }
  
  protected final void iz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115434);
    if (this.Czj == null)
    {
      AppMethodBeat.o(115434);
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
    AppMethodBeat.o(115434);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(115421);
    this.lUu = ((RelativeLayout)paramLayoutInflater.inflate(2131495883, paramViewGroup, false));
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)this.lUu.findViewById(2131304205)).setPadding(0, 0, 0, BackwardSupportUtil.b.h(getActivity(), 40.0F));
    }
    this.CAJ = ((ImageView)this.lUu.findViewById(2131306556));
    this.CAK = ((ImageView)this.lUu.findViewById(2131306592));
    this.Czl = ((RelativeLayout)this.lUu.findViewById(2131301467));
    this.CBy = ((OpenGlView)this.lUu.findViewById(2131297220));
    this.CBy.iB(mScreenWidth, mScreenHeight);
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
    if (n.Jh("VOIPBlockIgnoreButton") == 0)
    {
      bool = true;
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
      b(this.pdJ);
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
      this.CBz = new MovableVideoView(getActivity().getApplicationContext());
      ((MovableVideoView)this.CBz).iA(j, i);
      this.CBz.setVisibility(0);
      this.CBz.tN(true);
      this.CBA = new OpenGlRender(this.CBz, OpenGlRender.RenderRemote);
      this.CBz.setRenderer(this.CBA);
      this.CBz.setRenderMode(0);
      this.CBA.CFC = new OpenGlRender.b()
      {
        public final void BW(long paramAnonymousLong)
        {
          AppMethodBeat.i(210193);
          if ((VoipVideoFragment.this.CAv != null) && (VoipVideoFragment.this.CAv.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.CAv.get()).ae(paramAnonymousLong, 2);
          }
          AppMethodBeat.o(210193);
        }
        
        public final void BX(long paramAnonymousLong)
        {
          AppMethodBeat.i(210194);
          if ((VoipVideoFragment.this.CAv != null) && (VoipVideoFragment.this.CAv.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.CAv.get()).ae(paramAnonymousLong, 0);
          }
          AppMethodBeat.o(210194);
        }
        
        public final void BY(long paramAnonymousLong)
        {
          AppMethodBeat.i(210195);
          if ((VoipVideoFragment.this.CAv != null) && (VoipVideoFragment.this.CAv.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.CAv.get()).ae(paramAnonymousLong, 1);
          }
          AppMethodBeat.o(210195);
        }
        
        public final void eCJ() {}
      };
      this.CBB = new OpenGlRender(this.CBy, OpenGlRender.RenderLocal);
      this.CBy.setRenderer(this.CBB);
      this.CBy.setRenderMode(0);
      this.CBy.setVisibility(0);
      this.CBB.CFC = new OpenGlRender.b()
      {
        public final void BW(long paramAnonymousLong)
        {
          AppMethodBeat.i(210197);
          if ((VoipVideoFragment.this.CAv != null) && (VoipVideoFragment.this.CAv.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.CAv.get()).ae(paramAnonymousLong, 2);
          }
          AppMethodBeat.o(210197);
        }
        
        public final void BX(long paramAnonymousLong)
        {
          AppMethodBeat.i(210198);
          if ((VoipVideoFragment.this.CAv != null) && (VoipVideoFragment.this.CAv.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.CAv.get()).ae(paramAnonymousLong, 0);
          }
          AppMethodBeat.o(210198);
        }
        
        public final void BY(long paramAnonymousLong)
        {
          AppMethodBeat.i(210199);
          if ((VoipVideoFragment.this.CAv != null) && (VoipVideoFragment.this.CAv.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.CAv.get()).ae(paramAnonymousLong, 1);
          }
          AppMethodBeat.o(210199);
        }
        
        public final void eCJ()
        {
          AppMethodBeat.i(210196);
          if ((VoipVideoFragment.this.CAv != null) && (VoipVideoFragment.this.CAv.get() != null)) {
            ((c)VoipVideoFragment.this.CAv.get()).ae(0L, 3);
          }
          AppMethodBeat.o(210196);
        }
      };
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
      this.lUu.addView(this.CBz);
      this.CBz.setOnClickListener(new View.OnClickListener()
      {
        long CAo = 0L;
        
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(115399);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
          if ((VoipVideoFragment.k(VoipVideoFragment.this).CFO) || (VoipVideoFragment.k(VoipVideoFragment.this).getVisibility() != 0))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "current view is not show ");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115399);
            return;
          }
          if (bu.aO(this.CAo) < 400L)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "click mGlSmallVideoView too fast and not allow to response it,times%s", new Object[] { Long.valueOf(bu.aO(this.CAo)) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115399);
            return;
          }
          this.CAo = bu.HQ();
          paramAnonymousView = VoipVideoFragment.this;
          if (!VoipVideoFragment.l(VoipVideoFragment.this))
          {
            bool = true;
            VoipVideoFragment.b(paramAnonymousView, bool);
            VoipVideoFragment.this.eCI();
            paramAnonymousView = VoipVideoFragment.this;
            if (VoipVideoFragment.l(VoipVideoFragment.this)) {
              break label269;
            }
          }
          label269:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView = VoipVideoFragment.c(paramAnonymousView, bool);
            VoipVideoFragment.k(VoipVideoFragment.this).iC(paramAnonymousView.x, paramAnonymousView.y);
            com.tencent.mm.plugin.report.service.g.yxI.f(11079, new Object[] { Integer.valueOf(3) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115399);
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
            AppMethodBeat.i(115400);
            VoipVideoFragment.m(VoipVideoFragment.this).setText(2131764874);
            VoipVideoFragment.this.CAO.a(VoipVideoFragment.n(VoipVideoFragment.this), VoipBaseFragment.CAI);
            AppMethodBeat.o(115400);
          }
        }, 2000L);
      }
      this.CBC = ((VoIPVideoView)this.lUu.findViewById(2131306590));
      this.mTimer = new Timer("VoIP_video_talking_count");
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", new Object[] { Integer.valueOf(this.CzT) });
      this.CBB.setVoipBeauty(this.CzT);
      this.CBA.setVoipBeauty(this.CzT);
      if ((this.CAv != null) && (this.CAv.get() != null))
      {
        paramLayoutInflater = (c)this.CAv.get();
        if ((260 == this.mStatus) || (6 == this.mStatus)) {
          break label1613;
        }
      }
    }
    label1613:
    for (boolean bool = true;; bool = false)
    {
      paramLayoutInflater.at(true, bool);
      this.CBB.CFA = true;
      this.CBA.CFA = true;
      this.pdM = true;
      iv(this.CqV, this.CqW);
      iy(0, this.mStatus);
      this.gNb = ((PowerManager)ak.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipVideoFragment");
      this.gNb.acquire();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "acquire wakelock");
      paramLayoutInflater = this.lUu;
      AppMethodBeat.o(115421);
      return paramLayoutInflater;
      bool = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115422);
    this.pgi = false;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "onDestory");
    super.onDestroy();
    if ((this.gNb != null) && (this.gNb.isHeld()))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "release waklock");
      this.gNb.release();
    }
    AppMethodBeat.o(115422);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(115453);
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
    AppMethodBeat.o(115453);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(115432);
    this.CBB.onStarted();
    this.CBA.onStarted();
    super.onStart();
    AppMethodBeat.o(115432);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(115431);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "onStop");
    this.CBB.eEe();
    this.CBA.eEe();
    super.onStop();
    AppMethodBeat.o(115431);
  }
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115424);
    this.CBB.releaseSurfaceTexture();
    this.CBA.releaseSurfaceTexture();
    AppMethodBeat.o(115424);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115423);
    if (this.CzO)
    {
      this.CBy.CEn.requestRender();
      AppMethodBeat.o(115423);
      return;
    }
    this.CBz.CEn.requestRender();
    AppMethodBeat.o(115423);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115442);
    this.CzS = paramInt;
    if ((this.CBz == null) || (this.CBz.CFO))
    {
      AppMethodBeat.o(115442);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "setHWDecMode, hwdec: %d, mIsSmallViewShowSelf:%b, before changeSurfaceRender", new Object[] { Integer.valueOf(this.CzS), Boolean.valueOf(this.CzO) });
    eCI();
    AppMethodBeat.o(115442);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt) {}
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115445);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "setVoipBeauty isON:%d, mInitDone:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.pdM) });
    this.CzT = paramInt;
    if (!this.pdM)
    {
      AppMethodBeat.o(115445);
      return;
    }
    this.CBB.setVoipBeauty(this.CzT);
    this.CBA.setVoipBeauty(this.CzT);
    AppMethodBeat.o(115445);
  }
  
  protected final void tA(boolean paramBoolean)
  {
    AppMethodBeat.i(115435);
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
      AppMethodBeat.o(115435);
      return;
      label49:
      this.vhc.setText(2131764891);
    }
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115430);
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.Voip.VoipVideoFragment", "unit should not be allow in foreground", new Object[0]);
    if (this.CBz != null) {
      this.CBz.setVisibility(4);
    }
    if (this.pdJ != null)
    {
      this.lUu.removeView(this.pdJ);
      this.pdJ = null;
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView removed");
    }
    if (this.CBD != null)
    {
      this.CBD.cancel();
      this.CBD = null;
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
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
      final Bitmap localBitmap = VoipVideoFragment.D(this.CBG);
      this.CBG.jzz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115418);
          if (VoipVideoFragment.a.this.CBG.CAJ != null) {
            VoipVideoFragment.a.this.CBG.CAJ.setBackgroundDrawable(new BitmapDrawable(localBitmap));
          }
          VoipVideoFragment.E(VoipVideoFragment.a.this.CBG);
          AppMethodBeat.o(115418);
        }
      });
      AppMethodBeat.o(115419);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment
 * JD-Core Version:    0.7.0.1
 */