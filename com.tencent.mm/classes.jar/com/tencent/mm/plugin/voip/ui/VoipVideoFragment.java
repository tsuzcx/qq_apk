package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
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
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.c.k;
import com.tencent.mm.plugin.voip.c.m;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.video.GLTextureView;
import com.tencent.mm.plugin.voip.video.GLTextureView.i;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlRender.b;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.plugin.voip.widget.VoIPVideoView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
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
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.az;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;

public class VoipVideoFragment
  extends VoipBaseFragment
{
  int[] Frr;
  private WeImageView FzS;
  private Bitmap HNJ;
  private com.tencent.mm.media.g.d MRb;
  public int NKW;
  public int NKX;
  private ImageView NTF;
  private View NTG;
  private ImageView NTH;
  private TextView NTI;
  private TextView NTJ;
  private TextView NTK;
  private TextView NTL;
  private View NTM;
  private TextView NTN;
  private TextView NTO;
  private TextView NTP;
  private RelativeLayout NTQ;
  private Button NTR;
  private VoipSmallIconButton NTS;
  private VoipSmallIconButton NTT;
  private VoipSmallIconButton NTU;
  private VoipBigIconButton NTV;
  private VoipBigIconButton NTW;
  private VoipBigIconButton NTX;
  private VoipBigIconButton NTY;
  private VoipBigIconButton NTZ;
  public long NUA;
  public int NUC;
  public int NUD;
  private int NUE;
  private int NUF;
  private MTimerHandler NUG;
  private boolean NUH;
  private View.OnClickListener NUK;
  private View.OnClickListener NUL;
  private View.OnClickListener NUN;
  private View.OnClickListener NUO;
  private View.OnClickListener NUP;
  private View.OnClickListener NUQ;
  private View.OnClickListener NUR;
  private View.OnClickListener NUS;
  private View.OnClickListener NUT;
  private View.OnClickListener NUU;
  private View.OnClickListener NUV;
  private View.OnClickListener NUX;
  private Runnable NUY;
  private VoipBigIconButton NUa;
  private TextView NUb;
  private TextView NUc;
  private TextView NUd;
  private TextView NUe;
  private TextView NUf;
  private TextView NUg;
  private com.tencent.mm.plugin.voip.video.d NUk;
  private Button NUl;
  private Button NUm;
  private boolean NUn;
  private int NUo;
  private int NUp;
  private int NUq;
  private int NUr;
  private int NUx;
  private boolean NUy;
  private boolean NUz;
  private OpenGlView NWe;
  private OpenGlView NWf;
  private OpenGlRender NWg;
  private OpenGlRender NWh;
  private VoIPVideoView NWi;
  private VoipVideoFragment.a NWj;
  public int NWk;
  private final MTimerHandler.CallBack NWl;
  int NWm;
  Bitmap NWn;
  private MTimerHandler cts;
  private PowerManager.WakeLock kqO;
  private long qLu;
  private SurfaceTexture surfaceTexture;
  private CaptureView tRv;
  private boolean tRy;
  private int tUh;
  private boolean tUj;
  private Runnable uYG;
  
  public VoipVideoFragment()
  {
    AppMethodBeat.i(115420);
    this.NUk = null;
    this.NUl = null;
    this.NUm = null;
    this.NUn = false;
    this.NUx = 0;
    this.NUy = false;
    this.tUj = false;
    this.tRy = false;
    this.NUA = 0L;
    this.HNJ = null;
    this.NUC = 0;
    this.NUD = 0;
    this.NWk = 0;
    this.NUE = 0;
    this.qLu = 0L;
    this.NUF = 0;
    this.NUG = null;
    this.NUH = false;
    this.NKW = 0;
    this.NKX = 0;
    this.surfaceTexture = null;
    this.NUK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115394);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
        if ((VoipVideoFragment.this.NVe != null) && (VoipVideoFragment.this.NVe.get() != null) && (((c)VoipVideoFragment.this.NVe.get()).gxG()))
        {
          VoipVideoFragment.a(VoipVideoFragment.this).setEnabled(false);
          VoipVideoFragment.b(VoipVideoFragment.this).setEnabled(false);
          VoipVideoFragment.this.kS(b.g.voip_finish_call, -1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115394);
      }
    };
    this.NUL = new VoipVideoFragment.12(this);
    this.NUN = new VoipVideoFragment.16(this);
    this.NUO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115410);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
        if ((NetStatusUtil.isWifi(VoipVideoFragment.this.getActivity())) || (s.gzG())) {
          VoipVideoFragment.c(VoipVideoFragment.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115410);
          return;
          com.tencent.mm.ui.base.h.a(VoipVideoFragment.this.getActivity(), b.g.voip_not_wifi_warnning_message, b.g.voip_not_wifi_warnning_title, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(115408);
              s.gzF();
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
    this.NUP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115413);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
        if ((NetStatusUtil.isWifi(VoipVideoFragment.this.getActivity())) || ((s.gzG()) && (!NetStatusUtil.is2G(VoipVideoFragment.this.getActivity())))) {
          VoipVideoFragment.e(VoipVideoFragment.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115413);
          return;
          com.tencent.mm.ui.base.h.a(VoipVideoFragment.this.getActivity(), b.g.voip_not_wifi_warnning_message, b.g.voip_not_wifi_warnning_title, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(115411);
              if (!NetStatusUtil.is2G(VoipVideoFragment.this.getActivity())) {
                s.gzF();
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
    this.NUQ = new VoipVideoFragment.19(this);
    this.NUR = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115415);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
        if ((VoipVideoFragment.this.NVe != null) && (VoipVideoFragment.this.NVe.get() != null) && (((c)VoipVideoFragment.this.NVe.get()).gxM()))
        {
          VoipVideoFragment.a(VoipVideoFragment.this).setEnabled(false);
          VoipVideoFragment.f(VoipVideoFragment.this).setEnabled(false);
          VoipVideoFragment.g(VoipVideoFragment.this).setVisibility(0);
          VoipVideoFragment.g(VoipVideoFragment.this).setText(b.g.voip_cancel_call);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115415);
      }
    };
    this.NUS = new VoipVideoFragment.21(this);
    this.NUT = new VoipVideoFragment.22(this);
    this.NUU = new VoipVideoFragment.2(this);
    this.NUV = new VoipVideoFragment.3(this);
    this.NWl = new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(238129);
        String str = VoipVideoFragment.GN(Util.secondsToNow(VoipVideoFragment.this.NVf));
        VoipVideoFragment.k(VoipVideoFragment.this).setText(str);
        VoipVideoFragment.l(VoipVideoFragment.this);
        AppMethodBeat.o(238129);
        return true;
      }
    };
    this.NUX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(241317);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
        VoipVideoFragment.r(VoipVideoFragment.this).setEnabled(false);
        VoipVideoFragment.s(VoipVideoFragment.this);
        VoipVideoFragment.r(VoipVideoFragment.this).setEnabled(true);
        if ((VoipVideoFragment.this.NVe != null) && (VoipVideoFragment.this.NVe.get() != null)) {
          ((c)VoipVideoFragment.this.NVe.get()).gxR();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(241317);
      }
    };
    this.NUY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235444);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
        VoipVideoFragment.t(VoipVideoFragment.this);
        if ((VoipVideoFragment.this.getActivity() == null) || (VoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(235444);
          return;
        }
        if (VoipVideoFragment.u(VoipVideoFragment.this) > 0)
        {
          AppMethodBeat.o(235444);
          return;
        }
        VoipVideoFragment.r(VoipVideoFragment.this).setVisibility(8);
        VoipVideoFragment.v(VoipVideoFragment.this).setVisibility(8);
        VoipVideoFragment.k(VoipVideoFragment.this).setVisibility(8);
        VoipVideoFragment.a(VoipVideoFragment.this).setVisibility(8);
        VoipVideoFragment.b(VoipVideoFragment.this).setVisibility(8);
        VoipVideoFragment.m(VoipVideoFragment.this).setVisibility(8);
        VoipVideoFragment.d(VoipVideoFragment.this, false);
        AppMethodBeat.o(235444);
      }
    };
    this.uYG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(234469);
        if ((VoipVideoFragment.this.getActivity() == null) || (VoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(234469);
          return;
        }
        VoipVideoFragment.g(VoipVideoFragment.this).setVisibility(8);
        AppMethodBeat.o(234469);
      }
    };
    this.Frr = null;
    this.NWm = 0;
    this.NWn = null;
    AppMethodBeat.o(115420);
  }
  
  private Point Bd(boolean paramBoolean)
  {
    AppMethodBeat.i(115454);
    int i = (int)(getActivity().getWindowManager().getDefaultDisplay().getHeight() / 5.0D);
    float f = i;
    com.tencent.mm.plugin.voip.c.gxs();
    Point localPoint = new Point((int)(f * u.AY(paramBoolean)), i);
    AppMethodBeat.o(115454);
    return localPoint;
  }
  
  private void alm(int paramInt)
  {
    AppMethodBeat.i(115448);
    this.NVy.gBX();
    this.NTV.setEnabled(false);
    this.NTZ.setEnabled(false);
    this.NTY.setEnabled(false);
    this.NTX.setEnabled(false);
    this.NTW.setEnabled(false);
    this.NTU.setEnabled(false);
    this.NUa.setEnabled(false);
    this.NTT.setEnabled(false);
    this.NTS.setEnabled(false);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.NVx != null) {
        this.NVx.aU(true, false);
      }
      AppMethodBeat.o(115448);
      return;
      this.NTO.setVisibility(0);
      this.NTO.setText(b.g.voip_no_resp);
    }
  }
  
  private void b(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(240527);
    if ((this.qcr == null) || (paramCaptureView == null))
    {
      AppMethodBeat.o(240527);
      return;
    }
    if ((paramCaptureView.getParent() != null) && ((paramCaptureView.getParent() instanceof ViewGroup))) {
      ((ViewGroup)this.tRv.getParent()).removeView(this.tRv);
    }
    this.qcr.removeView(this.tRv);
    this.tRv = null;
    if (paramCaptureView.getParent() != null) {
      ((ViewGroup)paramCaptureView.getParent()).removeAllViews();
    }
    this.tRv = paramCaptureView;
    this.qcr.addView(paramCaptureView, new RelativeLayout.LayoutParams(1, 1));
    this.tRv.setVisibility(0);
    this.tRv.setAlpha(0.0F);
    Log.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView added");
    AppMethodBeat.o(240527);
  }
  
  private void bzG()
  {
    AppMethodBeat.i(115449);
    if ((this.cts == null) || (this.tUj))
    {
      AppMethodBeat.o(115449);
      return;
    }
    if (-1L == this.NVf) {
      this.NVf = Util.nowSecond();
    }
    this.NUA = this.NVf;
    this.tUj = true;
    this.cts.startTimer(1000L, 1000L);
    this.NUG = new MTimerHandler("VoipVideoFragment_cpuStatThread", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(236254);
        if (VoipVideoFragment.w(VoipVideoFragment.this))
        {
          VoipVideoFragment.x(VoipVideoFragment.this);
          AppMethodBeat.o(236254);
          return true;
        }
        AppMethodBeat.o(236254);
        return false;
      }
    }, true);
    this.NUH = true;
    this.NUG.startTimer(1000L);
    AppMethodBeat.o(115449);
  }
  
  private void gBL()
  {
    AppMethodBeat.i(115427);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
    this.NUx += 1;
    this.ntw.postDelayed(this.NUY, 10000L);
    AppMethodBeat.o(115427);
  }
  
  private void gBN()
  {
    AppMethodBeat.i(115438);
    this.NWe.setVisibility(0);
    if (this.NVu != null) {
      gBW();
    }
    this.NTG.setVisibility(0);
    this.NTI.setVisibility(0);
    if ((as.bvK(this.iSn)) && (!Util.isNullOrNil(this.NTJ.getText()))) {
      this.NTJ.setVisibility(0);
    }
    for (;;)
    {
      this.NTK.setText(b.g.voip_invited_video_tip);
      this.NTM.setVisibility(0);
      this.NTH.setVisibility(0);
      this.NVy.a(this.NTL, NVs);
      this.NUa.setVisibility(8);
      this.NTZ.setVisibility(8);
      this.NTV.setVisibility(8);
      this.NTY.setVisibility(8);
      this.NTX.setVisibility(0);
      this.NTU.setVisibility(0);
      this.NTW.setVisibility(0);
      this.NTT.setVisibility(8);
      if (this.NUz) {
        this.NTS.setVisibility(0);
      }
      this.NTP.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.gxs().NKK != null)
      {
        this.NTP.setVisibility(0);
        this.NTP.setText(com.tencent.mm.plugin.voip.c.gxs().NKK);
      }
      if (af.juH.jpL == 1)
      {
        this.NTF.setVisibility(0);
        this.NWe.setVisibility(4);
      }
      AppMethodBeat.o(115438);
      return;
      this.NTJ.setVisibility(8);
    }
  }
  
  private void gBO()
  {
    AppMethodBeat.i(115439);
    this.NTM.setVisibility(0);
    this.NWe.setVisibility(0);
    this.NTK.setText(b.g.voip_invite_waiting_tip);
    if ((as.bvK(this.iSn)) && (!Util.isNullOrNil(this.NTJ.getText()))) {
      this.NTJ.setVisibility(0);
    }
    for (;;)
    {
      this.NVt.setVisibility(8);
      this.NTO.setVisibility(8);
      this.NTP.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.gxs().NKK != null)
      {
        this.NTP.setVisibility(0);
        this.NTP.setText(com.tencent.mm.plugin.voip.c.gxs().NKK);
      }
      this.NVy.a(this.NTL, NVs);
      this.NUa.setVisibility(8);
      this.NTZ.setVisibility(8);
      this.NTV.setVisibility(0);
      this.NTY.setVisibility(8);
      this.NTX.setVisibility(8);
      this.NTU.setVisibility(8);
      this.NTW.setVisibility(8);
      this.NTT.setVisibility(0);
      this.NTS.setVisibility(8);
      AppMethodBeat.o(115439);
      return;
      this.NTJ.setVisibility(8);
    }
  }
  
  private void gBP()
  {
    boolean bool2 = true;
    AppMethodBeat.i(115440);
    if (this.NVu != null) {
      this.NVu.setVisibility(8);
    }
    if (!this.NWf.NZQ)
    {
      AppMethodBeat.o(115440);
      return;
    }
    this.NWf.Bn(false);
    label79:
    Point localPoint;
    if (this.NKr) {
      if (!this.NUy)
      {
        bool1 = true;
        this.NUy = bool1;
        if (this.NUy) {
          break label418;
        }
        bool1 = true;
        localPoint = Bd(bool1);
        this.NWf.kW(localPoint.x, localPoint.y);
        if (ac.mGz)
        {
          this.NUb.setVisibility(0);
          this.NUc.setVisibility(0);
          this.NUd.setVisibility(0);
          this.NUe.setVisibility(0);
          this.NUf.setVisibility(0);
          this.NUg.setVisibility(0);
        }
        this.NTG.setVisibility(8);
        this.NWe.setVisibility(0);
        this.NWf.setVisibility(0);
        this.NTN.setVisibility(0);
        this.NTR.setVisibility(0);
        if (ar.hIO()) {
          gBY();
        }
        this.NUa.setVisibility(0);
        this.NTZ.setVisibility(0);
        this.NTV.setVisibility(8);
        this.NTY.setVisibility(0);
        this.NTX.setVisibility(8);
        this.NTU.setVisibility(8);
        this.NTW.setVisibility(8);
        this.NTT.setVisibility(8);
        this.NTS.setVisibility(8);
        setHWDecMode(this.NUC);
        Log.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", new Object[] { Integer.valueOf(this.NUC) });
        if (this.NUy) {
          break label454;
        }
      }
    }
    label418:
    label454:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPoint = Bd(bool1);
      ((MovableVideoView)this.NWf).kU(localPoint.x, localPoint.y);
      bzG();
      if (MMApplicationContext.getDefaultPreference().getBoolean("voipfaceDebug", false))
      {
        this.NUl.setVisibility(0);
        this.NUm.setVisibility(0);
      }
      gBL();
      if (this.NVv == 4102) {
        kS(b.g.voip_accept_invite_normal, 10000);
      }
      AppMethodBeat.o(115440);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label79;
      if (!this.NUy) {}
      for (bool1 = true;; bool1 = false)
      {
        this.NUy = bool1;
        this.NWi.setVisibility(8);
        break;
      }
    }
  }
  
  private void gBQ()
  {
    AppMethodBeat.i(115447);
    this.NTK.setText(b.g.voip_waitting);
    this.NVy.a(this.NTL, NVs);
    AppMethodBeat.o(115447);
  }
  
  private void gBR()
  {
    AppMethodBeat.i(115450);
    View.OnClickListener local15 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(236185);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.plugin.report.service.h.IzE.a(11079, new Object[] { Integer.valueOf(4) });
        if ((!VoipVideoFragment.o(VoipVideoFragment.this)) && (VoipVideoFragment.this.NVe.get() != null)) {
          VoipVideoFragment.r(VoipVideoFragment.this).getVisibility();
        }
        int i;
        if (VoipVideoFragment.r(VoipVideoFragment.this).getVisibility() == 0)
        {
          i = 4;
          if (i != 0) {
            break label307;
          }
        }
        label307:
        for (int j = 0;; j = 8)
        {
          VoipVideoFragment.r(VoipVideoFragment.this).setVisibility(j);
          VoipVideoFragment.v(VoipVideoFragment.this).setVisibility(j);
          if (ar.hIO()) {
            VoipVideoFragment.y(VoipVideoFragment.this);
          }
          VoipVideoFragment.k(VoipVideoFragment.this).setVisibility(j);
          VoipVideoFragment.b(VoipVideoFragment.this).setVisibility(j);
          VoipVideoFragment.a(VoipVideoFragment.this).setVisibility(j);
          paramAnonymousView = VoipVideoFragment.this;
          if (j == 0) {
            bool = true;
          }
          VoipVideoFragment.d(paramAnonymousView, bool);
          if (ac.mGz)
          {
            VoipVideoFragment.z(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.A(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.B(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.C(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.D(VoipVideoFragment.this).setVisibility(j);
            VoipVideoFragment.E(VoipVideoFragment.this).setVisibility(j);
          }
          if (i == 0) {
            VoipVideoFragment.s(VoipVideoFragment.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(236185);
          return;
          i = 0;
          break;
        }
      }
    };
    this.qcr.setOnClickListener(local15);
    AppMethodBeat.o(115450);
  }
  
  private void gBY()
  {
    AppMethodBeat.i(240456);
    if (this.FzS == null)
    {
      AppMethodBeat.o(240456);
      return;
    }
    az.kK(getActivity());
    if (ar.hIH()) {
      this.FzS.setVisibility(0);
    }
    for (;;)
    {
      this.FzS.setOnClickListener(new VoipVideoFragment.5(this));
      AppMethodBeat.o(240456);
      return;
      this.FzS.setVisibility(8);
    }
  }
  
  protected final void Bc(boolean paramBoolean)
  {
    AppMethodBeat.i(115435);
    if (this.DZt != null)
    {
      if (!paramBoolean) {
        break label49;
      }
      this.DZt.setText(b.g.voip_net_status_self_warning_hint);
    }
    for (;;)
    {
      this.DZt.clearAnimation();
      this.DZt.setVisibility(0);
      AppMethodBeat.o(115435);
      return;
      label49:
      this.DZt.setText(b.g.voip_net_status_other_warning_hint);
    }
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
    this.MRb = paramd;
    if ((!this.tRy) || (this.NWh == null) || (this.NWg == null))
    {
      Log.i("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture failed , texId:%d,mInitDone:%b", new Object[] { Integer.valueOf(paramd.kVj), Boolean.valueOf(this.tRy) });
      AppMethodBeat.o(115426);
      return;
    }
    this.NWh.a(this.surfaceTexture, paramd);
    this.NWg.a(this.surfaceTexture, paramd);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture OK , videoTexture:%d", new Object[] { Integer.valueOf(paramd.kVj) });
    AppMethodBeat.o(115426);
  }
  
  public final void a(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(240469);
    this.tRv = paramCaptureView;
    b(this.tRv);
    AppMethodBeat.o(240469);
  }
  
  public final void aln(int paramInt)
  {
    AppMethodBeat.i(240495);
    super.aln(paramInt);
    if ((paramInt == 0) || (paramInt == 180))
    {
      this.NWh.NZg = 0;
      this.NWg.NZg = 0;
      AppMethodBeat.o(240495);
      return;
    }
    this.NWh.NZg = (360 - paramInt);
    this.NWg.NZg = (360 - paramInt);
    AppMethodBeat.o(240495);
  }
  
  public final void b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(240499);
    if (!this.tRy)
    {
      AppMethodBeat.o(240499);
      return;
    }
    if (OpenGlRender.NZh == 1)
    {
      if (this.NWm < paramInt1 * paramInt2) {
        this.Frr = null;
      }
      if (this.Frr == null)
      {
        this.NWm = (paramInt1 * paramInt2);
        this.Frr = new int[this.NWm];
      }
      if ((com.tencent.mm.plugin.voip.c.gxs().a(paramArrayOfByte, (int)paramLong, paramInt3 & 0x1F, paramInt1, paramInt2, this.Frr, true) < 0) || (this.Frr == null))
      {
        AppMethodBeat.o(240499);
        return;
      }
      if (this.NUy) {
        this.NWg.a(this.Frr, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      }
    }
    for (;;)
    {
      this.NUp += 1;
      this.NUo += 1;
      paramArrayOfByte = this.NUk;
      paramArrayOfByte.NYo = paramInt1;
      paramArrayOfByte.NYp = paramInt2;
      paramArrayOfByte = this.NUk;
      paramInt1 = this.qcr.getWidth();
      paramInt2 = this.qcr.getHeight();
      paramArrayOfByte.NYn = paramInt1;
      paramArrayOfByte.bZ = paramInt2;
      AppMethodBeat.o(240499);
      return;
      this.NWh.a(this.Frr, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      continue;
      if (OpenGlRender.NZh == 2) {
        if (this.NUy) {
          this.NWg.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
        } else {
          this.NWh.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
        }
      }
    }
  }
  
  protected final void bgj(String paramString)
  {
    AppMethodBeat.i(115433);
    if (this.NTP != null)
    {
      this.NTP.setVisibility(0);
      this.NTP.setText(paramString);
    }
    AppMethodBeat.o(115433);
  }
  
  public final void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115443);
    if (!this.tRy)
    {
      AppMethodBeat.o(115443);
      return;
    }
    this.tUh += 1;
    if (OpenGlRender.NZh == 1)
    {
      if (this.NUy)
      {
        this.NWh.i(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90);
        AppMethodBeat.o(115443);
        return;
      }
      this.NWg.i(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90);
      AppMethodBeat.o(115443);
      return;
    }
    if (this.NUy)
    {
      this.NWh.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
      AppMethodBeat.o(115443);
      return;
    }
    this.NWg.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
    AppMethodBeat.o(115443);
  }
  
  public final void gBG()
  {
    AppMethodBeat.i(115452);
    if (this.tRv != null)
    {
      this.qcr.removeView(this.tRv);
      this.qcr.addView(this.tRv, new RelativeLayout.LayoutParams(1, 1));
      this.tRv.setVisibility(0);
      this.tRv.setAlpha(0.0F);
      Log.i("MicroMsg.Voip.VoipVideoFragment", "resetCaptureView");
    }
    AppMethodBeat.o(115452);
  }
  
  protected final void gBM()
  {
    AppMethodBeat.i(115436);
    if (this.DZt != null)
    {
      this.DZt.clearAnimation();
      this.DZt.setVisibility(8);
    }
    AppMethodBeat.o(115436);
  }
  
  public final void gBT()
  {
    AppMethodBeat.i(115444);
    if (!this.tRy)
    {
      AppMethodBeat.o(115444);
      return;
    }
    this.NWh.gDn();
    this.NWg.gDn();
    AppMethodBeat.o(115444);
  }
  
  public final OpenGlRender gBU()
  {
    if (this.NUy) {
      return this.NWg;
    }
    return this.NWh;
  }
  
  public final void gBZ()
  {
    AppMethodBeat.i(115425);
    if ((this.NWh != null) && (this.NWg != null))
    {
      if (!this.NUy) {
        break label119;
      }
      this.NWg.setShowMode(0);
      if ((this.NUC & 0x1) == 0) {
        break label108;
      }
      this.NWh.setShowMode(1);
    }
    for (;;)
    {
      Log.i("MicroMsg.Voip.VoipVideoFragment", "changeSurfaceRender, bigViewMode: %d, smallViewMode: %d,mIsSmallViewShowSelf:%b, after changeSurfaceRender", new Object[] { Integer.valueOf(this.NWh.zow), Integer.valueOf(this.NWg.zow), Boolean.valueOf(this.NUy) });
      AppMethodBeat.o(115425);
      return;
      label108:
      this.NWh.setShowMode(0);
      continue;
      label119:
      this.NWh.setShowMode(0);
      if ((this.NUC & 0x1) != 0) {
        this.NWg.setShowMode(1);
      } else {
        this.NWg.setShowMode(0);
      }
    }
  }
  
  public final OpenGlRender getSpatioTemporalFilterData()
  {
    if (this.NUy) {
      return this.NWg;
    }
    return this.NWh;
  }
  
  public final void kN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115446);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "adjustHWViewAspectRatio, mInitDone:%b, HWDecsize:%dx%d,  lastHWDecsize:%dx%d", new Object[] { Boolean.valueOf(this.tRy), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.NKW), Integer.valueOf(this.NKX) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(115446);
      return;
    }
    if ((this.NKW != paramInt1) || (this.NKX != paramInt2))
    {
      this.NKW = paramInt1;
      this.NKX = paramInt2;
    }
    if (this.tRy)
    {
      this.NWh.kN(paramInt1, paramInt2);
      this.NWg.kN(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115446);
  }
  
  public final void kR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115428);
    super.kR(paramInt1, paramInt2);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + k.alz(paramInt2));
    if (this.qcr == null)
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
        if ((af.juH.jpL == 1) && (paramInt1 != 0)) {
          this.NTF.setVisibility(8);
        }
        AppMethodBeat.o(115428);
        return;
        gBO();
        paramInt1 = 1;
        continue;
        paramInt1 = 0;
        gBN();
        continue;
        gBR();
        gBP();
        paramInt1 = 1;
        continue;
        alm(paramInt1);
        paramInt1 = 1;
      }
      gBQ();
    }
  }
  
  protected final void kS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115434);
    if (this.NTO == null)
    {
      AppMethodBeat.o(115434);
      return;
    }
    this.NTO.setText(paramInt1);
    this.NTO.setVisibility(0);
    this.NTO.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.NTO.setBackgroundResource(b.c.voip_toast_bg);
    this.NTO.setCompoundDrawables(null, null, null, null);
    this.NTO.setCompoundDrawablePadding(0);
    this.ntw.removeCallbacks(this.uYG);
    if (-1 != paramInt2) {
      this.ntw.postDelayed(this.uYG, paramInt2);
    }
    AppMethodBeat.o(115434);
  }
  
  public final void l(Point paramPoint)
  {
    AppMethodBeat.i(240482);
    OpenGlView localOpenGlView = this.NWe;
    Log.i(OpenGlView.TAG, "new size from resoureHelper w %s * h  %s", new Object[] { Integer.valueOf(com.tencent.mm.ci.a.kr(localOpenGlView.getContext())), Integer.valueOf(com.tencent.mm.ci.a.ks(localOpenGlView.getContext())) });
    int j = paramPoint.x;
    int i = paramPoint.y;
    localOpenGlView.NZO = j;
    localOpenGlView.NZP = i;
    if (ar.hIF())
    {
      j = i * 9 / 16;
      paramPoint = new RelativeLayout.LayoutParams(j, i);
      paramPoint.addRule(13);
      localOpenGlView.NZO = j;
    }
    for (;;)
    {
      localOpenGlView.setLayoutParams(paramPoint);
      localOpenGlView.setLayoutParams(paramPoint);
      if (this.NWf != null)
      {
        paramPoint = (MovableVideoView)this.NWf;
        Log.i("MicroMsg.MovableVideoView", "refrsh view %s, %s", new Object[] { Integer.valueOf(paramPoint.mWidth), Integer.valueOf(paramPoint.NYG) });
        paramPoint.mScreenWidth = 0;
        paramPoint.kU(paramPoint.mWidth, paramPoint.NYG);
      }
      AppMethodBeat.o(240482);
      return;
      paramPoint = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(115421);
    this.qcr = ((RelativeLayout)paramLayoutInflater.inflate(b.e.voip_video_fragment2, paramViewGroup, false));
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)this.qcr.findViewById(b.d.rl_video_controllers)).setPadding(0, 0, 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(getActivity(), 40.0F));
    }
    this.NVt = ((ImageView)this.qcr.findViewById(b.d.voip_blur_avatar));
    this.NVu = ((ImageView)this.qcr.findViewById(b.d.voip_transparent_blur));
    this.NTQ = ((RelativeLayout)this.qcr.findViewById(b.d.ll_voip_mask));
    this.NWe = ((OpenGlView)this.qcr.findViewById(b.d.big_video));
    this.NWe.kV(mScreenWidth, mScreenHeight);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: onCreateView!");
    this.NUa = ((VoipBigIconButton)this.qcr.findViewById(b.d.voip_switch_camera));
    this.NUa.setOnClickListener(this.NUX);
    this.NTZ = ((VoipBigIconButton)this.qcr.findViewById(b.d.voip_video_switch_to_voice));
    this.NTZ.setOnClickListener(this.NUL);
    this.NTV = ((VoipBigIconButton)this.qcr.findViewById(b.d.voip_cancel_video_invite));
    this.NTV.setOnClickListener(this.NUR);
    this.NTY = ((VoipBigIconButton)this.qcr.findViewById(b.d.voip_hangup_video_talking));
    this.NTY.setOnClickListener(this.NUK);
    this.NTX = ((VoipBigIconButton)this.qcr.findViewById(b.d.voip_accept_video_invite));
    this.NTX.setOnClickListener(this.NUP);
    this.NTU = ((VoipSmallIconButton)this.qcr.findViewById(b.d.voip_accept_video_invite_use_voice));
    this.NTU.setOnClickListener(this.NUO);
    this.NTW = ((VoipBigIconButton)this.qcr.findViewById(b.d.voip_reject_video_invite));
    this.NTW.setOnClickListener(this.NUQ);
    this.NTT = ((VoipSmallIconButton)this.qcr.findViewById(b.d.voip_switchto_audio_invite));
    this.NTT.setOnClickListener(this.NUN);
    if (m.ZG("VOIPBlockIgnoreButton") == 0)
    {
      bool = true;
      this.NUz = bool;
      this.NTS = ((VoipSmallIconButton)this.qcr.findViewById(b.d.voip_ignore_video_invite));
      this.NTS.setOnClickListener(this.NUT);
      if (!this.NUz) {
        this.NTS.setVisibility(8);
      }
      this.NTN = ((TextView)this.qcr.findViewById(b.d.voip_video_time));
      this.NTG = this.qcr.findViewById(b.d.voip_video_remote_talker_container);
      this.NTH = ((ImageView)this.qcr.findViewById(b.d.voip_video_remote_talker_avatar));
      a.b.a(this.NTH, this.iSn, 0.0588235F, true);
      this.NTI = ((TextView)this.qcr.findViewById(b.d.voip_video_remote_talker_name));
      this.NTJ = ((TextView)this.qcr.findViewById(b.d.voip_video_remote_talker_name_sub_detail));
      this.NTK = ((TextView)this.qcr.findViewById(b.d.voip_video_calling_status));
      this.NTL = ((TextView)this.qcr.findViewById(b.d.voip_video_calling_status_dot));
      this.NTM = this.qcr.findViewById(b.d.voip_video_calling_status_ctn);
      o(this.NTL, b.g.voip_three_dot);
      this.NTO = ((TextView)this.qcr.findViewById(b.d.voip_video_call_hint));
      this.NTP = ((TextView)this.qcr.findViewById(b.d.voip_video_risk_call_hint));
      this.NTR = ((Button)this.qcr.findViewById(b.d.btn_minimize_voip));
      this.FzS = ((WeImageView)this.qcr.findViewById(b.d.btn_split));
      this.DZt = ((TextView)this.qcr.findViewById(b.d.voip_net_status_hint));
      this.FwW = ((ImageView)this.qcr.findViewById(b.d.link_arrow));
      this.FwW.setImageDrawable(au.o(MMApplicationContext.getContext(), b.f.icons_filled_arrow, -1));
      this.NTF = ((ImageView)this.qcr.findViewById(b.d.full_avatart));
      paramLayoutInflater = com.tencent.mm.am.d.a(this.iSn, false, -1, null);
      this.NTF.setImageBitmap(BitmapUtil.fastblur(paramLayoutInflater, 10));
      if (ac.mGz)
      {
        this.NUb = ((TextView)this.qcr.findViewById(b.d.voip_cap_fps));
        this.NUc = ((TextView)this.qcr.findViewById(b.d.voip_send_fps));
        this.NUd = ((TextView)this.qcr.findViewById(b.d.voip_recv_fps));
        this.NUe = ((TextView)this.qcr.findViewById(b.d.voip_send_kbps));
        this.NUf = ((TextView)this.qcr.findViewById(b.d.voip_recv_kbps));
        this.NUg = ((TextView)this.qcr.findViewById(b.d.engineInfo));
      }
      this.NUl = ((Button)this.qcr.findViewById(b.d.voip_face_debug));
      this.NUm = ((Button)this.qcr.findViewById(b.d.voip_face_debug_switch));
      this.NUl.setVisibility(8);
      this.NUm.setVisibility(8);
      this.NUl.setOnClickListener(this.NUU);
      this.NUm.setOnClickListener(this.NUV);
      this.NUk = new com.tencent.mm.plugin.voip.video.d(getActivity());
      this.qcr.addView(this.NUk);
      this.NUk.setVisibility(8);
      this.NTR.setOnClickListener(this.NUS);
      if (ar.hIO()) {
        gBY();
      }
      b(this.tRv);
      int i = w.at(getActivity());
      Log.d("MicroMsg.Voip.VoipVideoFragment", "statusHeight: ".concat(String.valueOf(i)));
      aF(this.NTR, i);
      aF(this.FzS, i);
      aF(this.qcr.findViewById(b.d.voip_time_tv_container), i);
      aF(this.NTG, i);
      this.NUp = 0;
      this.NUo = 0;
      this.tUh = 0;
      this.NUq = 0;
      this.NUr = 0;
      this.NUE = 0;
      this.NUF = 0;
      paramLayoutInflater = (WindowManager)getActivity().getSystemService("window");
      i = paramLayoutInflater.getDefaultDisplay().getHeight() / 5;
      int j = paramLayoutInflater.getDefaultDisplay().getWidth() * i / paramLayoutInflater.getDefaultDisplay().getHeight();
      this.NWf = new MovableVideoView(getActivity().getApplicationContext());
      ((MovableVideoView)this.NWf).kU(j, i);
      this.NWf.setVisibility(0);
      this.NWf.Bn(true);
      this.NWg = new OpenGlRender(this.NWf, OpenGlRender.RenderRemote);
      this.NWf.setRenderer(this.NWg);
      this.NWf.setRenderMode(0);
      this.NWg.NZE = new OpenGlRender.b()
      {
        public final void SH(long paramAnonymousLong)
        {
          AppMethodBeat.i(235935);
          if ((VoipVideoFragment.this.NVe != null) && (VoipVideoFragment.this.NVe.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.NVe.get()).aq(paramAnonymousLong, 2);
          }
          AppMethodBeat.o(235935);
        }
        
        public final void SI(long paramAnonymousLong)
        {
          AppMethodBeat.i(235938);
          if ((VoipVideoFragment.this.NVe != null) && (VoipVideoFragment.this.NVe.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.NVe.get()).aq(paramAnonymousLong, 0);
          }
          AppMethodBeat.o(235938);
        }
        
        public final void SJ(long paramAnonymousLong)
        {
          AppMethodBeat.i(235940);
          if ((VoipVideoFragment.this.NVe != null) && (VoipVideoFragment.this.NVe.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.NVe.get()).aq(paramAnonymousLong, 1);
          }
          AppMethodBeat.o(235940);
        }
        
        public final void gCa() {}
      };
      this.NWh = new OpenGlRender(this.NWe, OpenGlRender.RenderLocal);
      this.NWe.setRenderer(this.NWh);
      this.NWe.setRenderMode(0);
      this.NWe.setVisibility(0);
      this.NWh.NZE = new OpenGlRender.b()
      {
        public final void SH(long paramAnonymousLong)
        {
          AppMethodBeat.i(236236);
          if ((VoipVideoFragment.this.NVe != null) && (VoipVideoFragment.this.NVe.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.NVe.get()).aq(paramAnonymousLong, 2);
          }
          AppMethodBeat.o(236236);
        }
        
        public final void SI(long paramAnonymousLong)
        {
          AppMethodBeat.i(236238);
          if ((VoipVideoFragment.this.NVe != null) && (VoipVideoFragment.this.NVe.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.NVe.get()).aq(paramAnonymousLong, 0);
          }
          AppMethodBeat.o(236238);
        }
        
        public final void SJ(long paramAnonymousLong)
        {
          AppMethodBeat.i(236239);
          if ((VoipVideoFragment.this.NVe != null) && (VoipVideoFragment.this.NVe.get() != null) && (paramAnonymousLong > 0L)) {
            ((c)VoipVideoFragment.this.NVe.get()).aq(paramAnonymousLong, 1);
          }
          AppMethodBeat.o(236239);
        }
        
        public final void gCa()
        {
          AppMethodBeat.i(236234);
          if ((VoipVideoFragment.this.NVe != null) && (VoipVideoFragment.this.NVe.get() != null)) {
            ((c)VoipVideoFragment.this.NVe.get()).aq(0L, 3);
          }
          AppMethodBeat.o(236234);
        }
      };
      Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
      this.qcr.addView(this.NWf);
      this.NWf.setOnClickListener(new View.OnClickListener()
      {
        long NVa = 0L;
        
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(240826);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
          if ((VoipVideoFragment.n(VoipVideoFragment.this).NZQ) || (VoipVideoFragment.n(VoipVideoFragment.this).getVisibility() != 0))
          {
            Log.i("MicroMsg.Voip.VoipVideoFragment", "current view is not show ");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240826);
            return;
          }
          if (Util.ticksToNow(this.NVa) < 400L)
          {
            Log.i("MicroMsg.Voip.VoipVideoFragment", "click mGlSmallVideoView too fast and not allow to response it,times%s", new Object[] { Long.valueOf(Util.ticksToNow(this.NVa)) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240826);
            return;
          }
          this.NVa = Util.currentTicks();
          paramAnonymousView = VoipVideoFragment.this;
          if (!VoipVideoFragment.o(VoipVideoFragment.this))
          {
            bool = true;
            VoipVideoFragment.b(paramAnonymousView, bool);
            VoipVideoFragment.this.gBZ();
            paramAnonymousView = VoipVideoFragment.this;
            if (VoipVideoFragment.o(VoipVideoFragment.this)) {
              break label269;
            }
          }
          label269:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView = VoipVideoFragment.c(paramAnonymousView, bool);
            VoipVideoFragment.n(VoipVideoFragment.this).kW(paramAnonymousView.x, paramAnonymousView.y);
            com.tencent.mm.plugin.report.service.h.IzE.a(11079, new Object[] { Integer.valueOf(3) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240826);
            return;
            bool = false;
            break;
          }
        }
      });
      paramLayoutInflater = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.iSn);
      this.NTI.setText(l.b(getActivity(), aa.b(paramLayoutInflater, this.iSn), this.NTI.getTextSize()));
      paramLayoutInflater = com.tencent.mm.openim.room.a.a.V(paramLayoutInflater);
      if (!Util.isNullOrNil(paramLayoutInflater)) {
        this.NTJ.setText(paramLayoutInflater);
      }
      if (this.NKr) {
        this.ntw.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(115403);
            VoipVideoFragment.p(VoipVideoFragment.this).setText(b.g.voip_invite_waiting_tip);
            VoipVideoFragment.this.NVy.a(VoipVideoFragment.q(VoipVideoFragment.this), VoipBaseFragment.NVs);
            AppMethodBeat.o(115403);
          }
        }, 2000L);
      }
      this.NWi = ((VoIPVideoView)this.qcr.findViewById(b.d.voip_talking_video_view));
      this.cts = new MTimerHandler(Looper.myLooper(), this.NWl, true);
      Log.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", new Object[] { Integer.valueOf(this.NUD) });
      this.NWh.setVoipBeauty(this.NUD);
      this.NWg.setVoipBeauty(this.NUD);
      this.NWh.setSpatiotemporalDenosing(this.NWk);
      this.NWg.setSpatiotemporalDenosing(this.NWk);
      if ((this.NVe != null) && (this.NVe.get() != null))
      {
        paramLayoutInflater = (c)this.NVe.get();
        if ((260 == this.mStatus) || (6 == this.mStatus)) {
          break label1759;
        }
      }
    }
    label1759:
    for (boolean bool = true;; bool = false)
    {
      paramLayoutInflater.aQ(true, bool);
      this.NWh.NZC = true;
      this.NWg.NZC = true;
      this.tRy = true;
      kN(this.NKW, this.NKX);
      kR(0, this.mStatus);
      this.kqO = ((PowerManager)MMApplicationContext.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipVideoFragment");
      paramLayoutInflater = this.kqO;
      com.tencent.mm.hellhoundlib.a.a.b(paramLayoutInflater, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      paramLayoutInflater.acquire();
      com.tencent.mm.hellhoundlib.a.a.c(paramLayoutInflater, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      Log.i("MicroMsg.Voip.VoipVideoFragment", "acquire wakelock");
      paramLayoutInflater = this.qcr;
      AppMethodBeat.o(115421);
      return paramLayoutInflater;
      bool = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115422);
    this.tUj = false;
    Log.i("MicroMsg.Voip.VoipVideoFragment", "onDestory");
    super.onDestroy();
    if ((this.kqO != null) && (this.kqO.isHeld()))
    {
      Log.i("MicroMsg.Voip.VoipVideoFragment", "release waklock");
      PowerManager.WakeLock localWakeLock = this.kqO;
      com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment", "onDestroy", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      localWakeLock.release();
      com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment", "onDestroy", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
    }
    AppMethodBeat.o(115422);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(115453);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "onDetach");
    if (this.cts != null)
    {
      this.cts.stopTimer();
      this.cts = null;
    }
    if (this.NUG != null) {
      this.NUG.stopTimer();
    }
    this.NUH = false;
    super.onDetach();
    AppMethodBeat.o(115453);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(115432);
    this.NWh.qS();
    this.NWg.qS();
    super.onStart();
    AppMethodBeat.o(115432);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(115431);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "onStop");
    this.NWh.gDm();
    this.NWg.gDm();
    super.onStop();
    AppMethodBeat.o(115431);
  }
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115424);
    this.NWh.releaseSurfaceTexture();
    this.NWg.releaseSurfaceTexture();
    AppMethodBeat.o(115424);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115423);
    if (this.NUy)
    {
      this.NWe.NYx.requestRender();
      AppMethodBeat.o(115423);
      return;
    }
    this.NWf.NYx.requestRender();
    AppMethodBeat.o(115423);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115442);
    this.NUC = paramInt;
    if ((this.NWf == null) || (this.NWf.NZQ))
    {
      AppMethodBeat.o(115442);
      return;
    }
    Log.i("MicroMsg.Voip.VoipVideoFragment", "setHWDecMode, hwdec: %d, mIsSmallViewShowSelf:%b, before changeSurfaceRender", new Object[] { Integer.valueOf(this.NUC), Boolean.valueOf(this.NUy) });
    gBZ();
    AppMethodBeat.o(115442);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setSpatiotemporalDenosing(int paramInt)
  {
    AppMethodBeat.i(240509);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "setSpatiotemporalDenosing isON:%d, mInitDone:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.tRy) });
    this.NWk = paramInt;
    if (!this.tRy)
    {
      AppMethodBeat.o(240509);
      return;
    }
    this.NWh.setSpatiotemporalDenosing(this.NWk);
    this.NWg.setSpatiotemporalDenosing(this.NWk);
    AppMethodBeat.o(240509);
  }
  
  public final void setVoicePlayDevice(int paramInt) {}
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115445);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "setVoipBeauty isON:%d, mInitDone:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.tRy) });
    this.NUD = paramInt;
    if (!this.tRy)
    {
      AppMethodBeat.o(115445);
      return;
    }
    this.NWh.setVoipBeauty(this.NUD);
    this.NWg.setVoipBeauty(this.NUD);
    AppMethodBeat.o(115445);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115430);
    Log.printInfoStack("MicroMsg.Voip.VoipVideoFragment", "unit should not be allow in foreground", new Object[0]);
    if (this.NWf != null) {
      this.NWf.setVisibility(4);
    }
    if (this.tRv != null)
    {
      this.qcr.removeView(this.tRv);
      this.tRv = null;
      Log.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView removed");
    }
    if (this.NWj != null)
    {
      this.NWj.cancel();
      this.NWj = null;
    }
    super.uninit();
    AppMethodBeat.o(115430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment
 * JD-Core Version:    0.7.0.1
 */