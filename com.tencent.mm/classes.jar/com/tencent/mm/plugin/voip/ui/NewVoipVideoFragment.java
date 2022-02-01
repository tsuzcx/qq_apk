package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
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
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.mm.plugin.voip.c.g;
import com.tencent.mm.plugin.voip.c.k;
import com.tencent.mm.plugin.voip.c.m;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.video.NewMovableVideoView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
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
import kotlin.g.b.p;

public class NewVoipVideoFragment
  extends VoipBaseFragment
{
  private WeImageView FzS;
  private Bitmap HNJ;
  private VoIPRenderSurfaceView NTD;
  private VoIPRenderSurfaceView NTE;
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
  private NewVoipVideoFragment.a NUB;
  public int NUC;
  public int NUD;
  private int NUE;
  private int NUF;
  private MTimerHandler NUG;
  private boolean NUH;
  private boolean NUI;
  private boolean NUJ;
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
  private final MTimerHandler.CallBack NUW;
  private View.OnClickListener NUX;
  private Runnable NUY;
  private VoipBigIconButton NUa;
  private TextView NUb;
  private TextView NUc;
  private TextView NUd;
  private TextView NUe;
  private TextView NUf;
  private TextView NUg;
  private TextView NUh;
  private TextView NUi;
  private TextView NUj;
  private com.tencent.mm.plugin.voip.video.d NUk;
  private Button NUl;
  private Button NUm;
  private boolean NUn;
  private int NUo;
  private int NUp;
  private int NUq;
  private int NUr;
  private boolean NUs;
  private boolean NUt;
  private boolean NUu;
  private boolean NUv;
  private String NUw;
  private int NUx;
  private boolean NUy;
  private boolean NUz;
  private MTimerHandler cts;
  private PowerManager.WakeLock kqO;
  private long qLu;
  private boolean tRy;
  private int tUh;
  private boolean tUj;
  private Runnable uYG;
  
  public NewVoipVideoFragment()
  {
    AppMethodBeat.i(237645);
    this.NUk = null;
    this.NUl = null;
    this.NUm = null;
    this.NUn = false;
    g localg = g.NXO;
    this.NUs = g.gCI();
    localg = g.NXO;
    this.NUt = g.gCH();
    localg = g.NXO;
    this.NUu = g.gCG();
    localg = g.NXO;
    this.NUv = g.gCE();
    this.NUw = com.tencent.mm.media.k.d.aVH();
    this.NUx = 0;
    this.NUy = false;
    this.tUj = false;
    this.cts = null;
    this.tRy = false;
    this.NUA = 0L;
    this.HNJ = null;
    this.NUC = 0;
    this.NUD = 0;
    this.NUE = 0;
    this.qLu = 0L;
    this.NUF = 0;
    this.NUG = null;
    this.NUH = false;
    this.NUI = false;
    this.NUJ = false;
    this.NUK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(239383);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
        if ((NewVoipVideoFragment.this.NVe != null) && (NewVoipVideoFragment.this.NVe.get() != null) && (((c)NewVoipVideoFragment.this.NVe.get()).gxG()))
        {
          NewVoipVideoFragment.a(NewVoipVideoFragment.this).setEnabled(false);
          NewVoipVideoFragment.b(NewVoipVideoFragment.this).setEnabled(false);
          NewVoipVideoFragment.this.kS(b.g.voip_finish_call, -1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(239383);
      }
    };
    this.NUL = new NewVoipVideoFragment.12(this);
    this.NUN = new NewVoipVideoFragment.14(this);
    this.NUO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(241658);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
        if ((NetStatusUtil.isWifi(NewVoipVideoFragment.this.getActivity())) || (s.gzG())) {
          NewVoipVideoFragment.c(NewVoipVideoFragment.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(241658);
          return;
          com.tencent.mm.ui.base.h.a(NewVoipVideoFragment.this.getActivity(), b.g.voip_not_wifi_warnning_message, b.g.voip_not_wifi_warnning_title, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(238195);
              s.gzF();
              NewVoipVideoFragment.c(NewVoipVideoFragment.this);
              AppMethodBeat.o(238195);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(245653);
              NewVoipVideoFragment.d(NewVoipVideoFragment.this);
              AppMethodBeat.o(245653);
            }
          });
        }
      }
    };
    this.NUP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(234713);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
        if ((NetStatusUtil.isWifi(NewVoipVideoFragment.this.getActivity())) || ((s.gzG()) && (!NetStatusUtil.is2G(NewVoipVideoFragment.this.getActivity())))) {
          NewVoipVideoFragment.e(NewVoipVideoFragment.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(234713);
          return;
          com.tencent.mm.ui.base.h.a(NewVoipVideoFragment.this.getActivity(), b.g.voip_not_wifi_warnning_message, b.g.voip_not_wifi_warnning_title, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(235197);
              if (!NetStatusUtil.is2G(NewVoipVideoFragment.this.getActivity())) {
                s.gzF();
              }
              NewVoipVideoFragment.e(NewVoipVideoFragment.this);
              AppMethodBeat.o(235197);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(242182);
              NewVoipVideoFragment.d(NewVoipVideoFragment.this);
              AppMethodBeat.o(242182);
            }
          });
        }
      }
    };
    this.NUQ = new NewVoipVideoFragment.17(this);
    this.NUR = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(233884);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
        if ((NewVoipVideoFragment.this.NVe != null) && (NewVoipVideoFragment.this.NVe.get() != null) && (((c)NewVoipVideoFragment.this.NVe.get()).gxM()))
        {
          NewVoipVideoFragment.a(NewVoipVideoFragment.this).setEnabled(false);
          NewVoipVideoFragment.f(NewVoipVideoFragment.this).setEnabled(false);
          NewVoipVideoFragment.g(NewVoipVideoFragment.this).setVisibility(0);
          NewVoipVideoFragment.g(NewVoipVideoFragment.this).setText(b.g.voip_cancel_call);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(233884);
      }
    };
    this.NUS = new NewVoipVideoFragment.19(this);
    this.NUT = new NewVoipVideoFragment.20(this);
    this.NUU = new NewVoipVideoFragment.2(this);
    this.NUV = new NewVoipVideoFragment.3(this);
    this.NUW = new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(239988);
        String str = NewVoipVideoFragment.GN(Util.secondsToNow(NewVoipVideoFragment.this.NVf));
        NewVoipVideoFragment.k(NewVoipVideoFragment.this).setText(str);
        NewVoipVideoFragment.l(NewVoipVideoFragment.this);
        AppMethodBeat.o(239988);
        return true;
      }
    };
    this.NUX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(233767);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
        NewVoipVideoFragment.r(NewVoipVideoFragment.this).setEnabled(false);
        NewVoipVideoFragment.s(NewVoipVideoFragment.this);
        NewVoipVideoFragment.r(NewVoipVideoFragment.this).setEnabled(true);
        if ((NewVoipVideoFragment.this.NVe != null) && (NewVoipVideoFragment.this.NVe.get() != null)) {
          ((c)NewVoipVideoFragment.this.NVe.get()).gxR();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(233767);
      }
    };
    this.NUY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238980);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
        NewVoipVideoFragment.t(NewVoipVideoFragment.this);
        if ((NewVoipVideoFragment.this.getActivity() == null) || (NewVoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(238980);
          return;
        }
        if (NewVoipVideoFragment.u(NewVoipVideoFragment.this) > 0)
        {
          AppMethodBeat.o(238980);
          return;
        }
        NewVoipVideoFragment.r(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.v(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.m(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.k(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.a(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.b(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.m(NewVoipVideoFragment.this).setVisibility(8);
        NewVoipVideoFragment.d(NewVoipVideoFragment.this, false);
        AppMethodBeat.o(238980);
      }
    };
    this.uYG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(242913);
        if ((NewVoipVideoFragment.this.getActivity() == null) || (NewVoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(242913);
          return;
        }
        NewVoipVideoFragment.g(NewVoipVideoFragment.this).setVisibility(8);
        AppMethodBeat.o(242913);
      }
    };
    AppMethodBeat.o(237645);
  }
  
  private void Bb(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(237651);
    if (!this.NUJ)
    {
      if (!paramBoolean) {
        break label115;
      }
      ((c)this.NVe.get()).a(this.NTE, 1);
      ((c)this.NVe.get()).a(this.NTD, 0);
    }
    for (;;)
    {
      c localc = (c)this.NVe.get();
      paramBoolean = bool;
      if (260 != this.mStatus)
      {
        paramBoolean = bool;
        if (6 != this.mStatus) {
          paramBoolean = true;
        }
      }
      localc.aQ(true, paramBoolean);
      this.NUJ = true;
      AppMethodBeat.o(237651);
      return;
      label115:
      ((c)this.NVe.get()).a(this.NTE, 0);
      ((c)this.NVe.get()).a(this.NTD, 1);
    }
  }
  
  private Point Bd(boolean paramBoolean)
  {
    AppMethodBeat.i(237678);
    int i = (int)(getActivity().getWindowManager().getDefaultDisplay().getHeight() / 5.0D);
    float f = i;
    com.tencent.mm.plugin.voip.c.gxs();
    Point localPoint = new Point((int)(f * u.AY(paramBoolean)), i);
    AppMethodBeat.o(237678);
    return localPoint;
  }
  
  private void all(int paramInt)
  {
    AppMethodBeat.i(237647);
    if (this.FzS == null)
    {
      AppMethodBeat.o(237647);
      return;
    }
    az.kK(getActivity());
    if (ar.hIH()) {
      this.FzS.setVisibility(paramInt);
    }
    for (;;)
    {
      this.FzS.setOnClickListener(new NewVoipVideoFragment.5(this));
      AppMethodBeat.o(237647);
      return;
      this.FzS.setVisibility(8);
    }
  }
  
  private void alm(int paramInt)
  {
    AppMethodBeat.i(237672);
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
      AppMethodBeat.o(237672);
      return;
      this.NTO.setVisibility(0);
      this.NTO.setText(b.g.voip_no_resp);
    }
  }
  
  private void bzG()
  {
    AppMethodBeat.i(237674);
    if ((this.cts == null) || (this.tUj))
    {
      AppMethodBeat.o(237674);
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
        AppMethodBeat.i(242176);
        if (NewVoipVideoFragment.w(NewVoipVideoFragment.this))
        {
          NewVoipVideoFragment.x(NewVoipVideoFragment.this);
          AppMethodBeat.o(242176);
          return true;
        }
        AppMethodBeat.o(242176);
        return false;
      }
    }, true);
    this.NUH = true;
    this.NUG.startTimer(1000L);
    AppMethodBeat.o(237674);
  }
  
  private void gBL()
  {
    AppMethodBeat.i(237649);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
    this.NUx += 1;
    this.ntw.postDelayed(this.NUY, 10000L);
    AppMethodBeat.o(237649);
  }
  
  private void gBN()
  {
    AppMethodBeat.i(237665);
    this.NTD.setVisibility(0);
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
        this.NTD.setVisibility(4);
      }
      AppMethodBeat.o(237665);
      return;
      this.NTJ.setVisibility(8);
    }
  }
  
  private void gBO()
  {
    AppMethodBeat.i(237667);
    this.NTM.setVisibility(0);
    this.NTD.setVisibility(0);
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
      AppMethodBeat.o(237667);
      return;
      this.NTJ.setVisibility(8);
    }
  }
  
  private void gBP()
  {
    boolean bool2 = true;
    AppMethodBeat.i(237668);
    if (this.NVu != null) {
      this.NVu.setVisibility(8);
    }
    if (this.NTE == null)
    {
      AppMethodBeat.o(237668);
      return;
    }
    if (this.NTE.getVisibility() == 0)
    {
      AppMethodBeat.o(237668);
      return;
    }
    label85:
    Point localPoint;
    if (this.NKr) {
      if (!this.NUy)
      {
        bool1 = true;
        this.NUy = bool1;
        if (this.NUy) {
          break label460;
        }
        bool1 = true;
        localPoint = Bd(bool1);
        this.NTE.kW(localPoint.x, localPoint.y);
        if (ac.mGz)
        {
          this.NUb.setVisibility(0);
          this.NUc.setVisibility(0);
          this.NUd.setVisibility(0);
          this.NUe.setVisibility(0);
          this.NUf.setVisibility(0);
          this.NUg.setVisibility(0);
          this.NUh.setVisibility(0);
          this.NUi.setVisibility(0);
          this.NUj.setVisibility(0);
        }
        this.NTG.setVisibility(8);
        this.NTD.setVisibility(0);
        this.NTE.setVisibility(0);
        this.NTN.setVisibility(0);
        this.NTR.setVisibility(0);
        if (ar.hIO()) {
          all(0);
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
        ((c)this.NVe.get()).AN(this.NUy);
        Log.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", new Object[] { Integer.valueOf(this.NUC) });
        if (this.NUy) {
          break label487;
        }
      }
    }
    label460:
    label487:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPoint = Bd(bool1);
      ((NewMovableVideoView)this.NTE).kU(localPoint.x, localPoint.y);
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
      AppMethodBeat.o(237668);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label85;
      if (!this.NUy) {}
      for (bool1 = true;; bool1 = false)
      {
        this.NUy = bool1;
        break;
      }
    }
  }
  
  private void gBQ()
  {
    AppMethodBeat.i(237670);
    this.NTK.setText(b.g.voip_waitting);
    this.NVy.a(this.NTL, NVs);
    AppMethodBeat.o(237670);
  }
  
  private void gBR()
  {
    AppMethodBeat.i(237675);
    View.OnClickListener local13 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(241364);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.plugin.report.service.h.IzE.a(11079, new Object[] { Integer.valueOf(4) });
        if ((!NewVoipVideoFragment.n(NewVoipVideoFragment.this)) && (NewVoipVideoFragment.this.NVe.get() != null)) {
          NewVoipVideoFragment.r(NewVoipVideoFragment.this).getVisibility();
        }
        int i;
        if (NewVoipVideoFragment.r(NewVoipVideoFragment.this).getVisibility() == 0)
        {
          i = 4;
          if (i != 0) {
            break label319;
          }
        }
        label319:
        for (int j = 0;; j = 8)
        {
          NewVoipVideoFragment.r(NewVoipVideoFragment.this).setVisibility(j);
          NewVoipVideoFragment.v(NewVoipVideoFragment.this).setVisibility(j);
          if (ar.hIO()) {
            NewVoipVideoFragment.a(NewVoipVideoFragment.this, j);
          }
          NewVoipVideoFragment.k(NewVoipVideoFragment.this).setVisibility(j);
          NewVoipVideoFragment.b(NewVoipVideoFragment.this).setVisibility(j);
          NewVoipVideoFragment.a(NewVoipVideoFragment.this).setVisibility(j);
          paramAnonymousView = NewVoipVideoFragment.this;
          if (j == 0) {
            bool = true;
          }
          NewVoipVideoFragment.d(paramAnonymousView, bool);
          if (ac.mGz)
          {
            NewVoipVideoFragment.y(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.z(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.A(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.B(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.C(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.D(NewVoipVideoFragment.this).setVisibility(j);
            NewVoipVideoFragment.E(NewVoipVideoFragment.this).setVisibility(j);
          }
          if (i == 0) {
            NewVoipVideoFragment.s(NewVoipVideoFragment.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(241364);
          return;
          i = 0;
          break;
        }
      }
    };
    this.qcr.setOnClickListener(local13);
    AppMethodBeat.o(237675);
  }
  
  protected final void Bc(boolean paramBoolean)
  {
    AppMethodBeat.i(237660);
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
      AppMethodBeat.o(237660);
      return;
      label49:
      this.DZt.setText(b.g.voip_net_status_other_warning_hint);
    }
  }
  
  public final void ali(int paramInt)
  {
    this.NUp += 1;
    if (paramInt > 0) {
      this.NUo += 1;
    }
  }
  
  public final void alj(int paramInt)
  {
    this.NUC = paramInt;
  }
  
  public final void alk(int paramInt)
  {
    this.NUD = paramInt;
  }
  
  protected final void bgj(String paramString)
  {
    AppMethodBeat.i(237656);
    if (this.NTP != null)
    {
      this.NTP.setVisibility(0);
      this.NTP.setText(paramString);
    }
    AppMethodBeat.o(237656);
  }
  
  public final void gBJ()
  {
    this.tUh += 1;
  }
  
  protected final void gBM()
  {
    AppMethodBeat.i(237662);
    if (this.DZt != null)
    {
      this.DZt.clearAnimation();
      this.DZt.setVisibility(8);
    }
    AppMethodBeat.o(237662);
  }
  
  public final void kR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237650);
    super.kR(paramInt1, paramInt2);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + k.alz(paramInt2));
    if (this.qcr == null)
    {
      Log.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
      AppMethodBeat.o(237650);
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
        AppMethodBeat.o(237650);
        return;
        this.NUI = true;
        Bb(true);
        gBO();
        paramInt1 = 1;
        continue;
        this.NUI = true;
        Bb(true);
        gBN();
        paramInt1 = 0;
        continue;
        gBR();
        if (this.NUI)
        {
          ((c)this.NVe.get()).gxT();
          com.tencent.mm.plugin.voip.c.h.Bk(false);
          this.NUI = false;
        }
        for (;;)
        {
          gBP();
          paramInt1 = 1;
          break;
          Bb(false);
        }
        alm(paramInt1);
        paramInt1 = 1;
      }
      gBQ();
    }
  }
  
  protected final void kS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237658);
    if (this.NTO == null)
    {
      AppMethodBeat.o(237658);
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
    AppMethodBeat.o(237658);
  }
  
  public final void l(Point paramPoint)
  {
    AppMethodBeat.i(237664);
    VoIPRenderSurfaceView localVoIPRenderSurfaceView = this.NTD;
    p.k(paramPoint, "screenSize");
    Log.i("RenderView", "new size from resource Helper w %s * h  %s", new Object[] { Integer.valueOf(com.tencent.mm.ci.a.kr(localVoIPRenderSurfaceView.getContext())), Integer.valueOf(com.tencent.mm.ci.a.ks(localVoIPRenderSurfaceView.getContext())) });
    int i = paramPoint.x;
    i = paramPoint.y;
    if (ar.hIF())
    {
      paramPoint = new RelativeLayout.LayoutParams(i * 9 / 16, i);
      paramPoint.addRule(13);
    }
    for (;;)
    {
      localVoIPRenderSurfaceView.setLayoutParams((ViewGroup.LayoutParams)paramPoint);
      localVoIPRenderSurfaceView.requestLayout();
      if (this.NTE != null)
      {
        paramPoint = (NewMovableVideoView)this.NTE;
        Log.i("MicroMsg.MovableVideoView", "refrsh view %s, %s", new Object[] { Integer.valueOf(paramPoint.mWidth), Integer.valueOf(paramPoint.NYG) });
        paramPoint.mScreenWidth = 0;
        paramPoint.kU(paramPoint.mWidth, paramPoint.NYG);
      }
      AppMethodBeat.o(237664);
      return;
      paramPoint = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(237646);
    this.qcr = ((RelativeLayout)paramLayoutInflater.inflate(b.e.voip_video_fragment, paramViewGroup, false));
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)this.qcr.findViewById(b.d.rl_video_controllers)).setPadding(0, 0, 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(getActivity(), 40.0F));
    }
    this.NVt = ((ImageView)this.qcr.findViewById(b.d.voip_blur_avatar));
    this.NVu = ((ImageView)this.qcr.findViewById(b.d.voip_transparent_blur));
    this.NTQ = ((RelativeLayout)this.qcr.findViewById(b.d.ll_voip_mask));
    this.NTD = ((VoIPRenderSurfaceView)this.qcr.findViewById(b.d.big_video));
    this.NTD.kX(mScreenWidth, mScreenHeight);
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
    if (m.ZG("VOIPBlockIgnoreButton") == 0) {}
    for (boolean bool = true;; bool = false)
    {
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
        this.NUh = ((TextView)this.qcr.findViewById(b.d.gpu_crop_info));
        this.NUi = ((TextView)this.qcr.findViewById(b.d.camera_info));
        this.NUj = ((TextView)this.qcr.findViewById(b.d.gpu_infomation));
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
        all(0);
      }
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
      this.NTE = new NewMovableVideoView(MMApplicationContext.getContext());
      ((NewMovableVideoView)this.NTE).kU(j, i);
      this.NTE.setVisibility(4);
      this.NTD.setVisibility(0);
      Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
      this.qcr.addView(this.NTE);
      this.NTE.setOnClickListener(new View.OnClickListener()
      {
        long NVa = 0L;
        
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(235634);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
          this.NVa = Util.currentTicks();
          paramAnonymousView = NewVoipVideoFragment.this;
          if (!NewVoipVideoFragment.n(NewVoipVideoFragment.this))
          {
            bool = true;
            NewVoipVideoFragment.b(paramAnonymousView, bool);
            ((c)NewVoipVideoFragment.this.NVe.get()).gxT();
            com.tencent.mm.plugin.voip.c.h.Bk(true);
            paramAnonymousView = NewVoipVideoFragment.this;
            if (NewVoipVideoFragment.n(NewVoipVideoFragment.this)) {
              break label187;
            }
          }
          label187:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView = NewVoipVideoFragment.c(paramAnonymousView, bool);
            if (NewVoipVideoFragment.o(NewVoipVideoFragment.this) != null) {
              NewVoipVideoFragment.o(NewVoipVideoFragment.this).kW(paramAnonymousView.x, paramAnonymousView.y);
            }
            com.tencent.mm.plugin.report.service.h.IzE.a(11079, new Object[] { Integer.valueOf(3) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(235634);
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
            AppMethodBeat.i(240829);
            NewVoipVideoFragment.p(NewVoipVideoFragment.this).setText(b.g.voip_invite_waiting_tip);
            NewVoipVideoFragment.this.NVy.a(NewVoipVideoFragment.q(NewVoipVideoFragment.this), VoipBaseFragment.NVs);
            AppMethodBeat.o(240829);
          }
        }, 2000L);
      }
      this.cts = new MTimerHandler(Looper.getMainLooper(), this.NUW, true);
      Log.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", new Object[] { Integer.valueOf(this.NUD) });
      this.tRy = true;
      if ((this.NVe != null) && (this.NVe.get() != null)) {
        ((c)this.NVe.get()).gxU();
      }
      kR(0, this.mStatus);
      this.kqO = ((PowerManager)MMApplicationContext.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipVideoFragment");
      paramLayoutInflater = this.kqO;
      com.tencent.mm.hellhoundlib.a.a.b(paramLayoutInflater, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      paramLayoutInflater.acquire();
      com.tencent.mm.hellhoundlib.a.a.c(paramLayoutInflater, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      Log.i("MicroMsg.Voip.VoipVideoFragment", "acquire wakelock");
      paramLayoutInflater = this.qcr;
      AppMethodBeat.o(237646);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(237648);
    this.tUj = false;
    Log.i("MicroMsg.Voip.VoipVideoFragment", "onDestory");
    super.onDestroy();
    if ((this.kqO != null) && (this.kqO.isHeld()))
    {
      Log.i("MicroMsg.Voip.VoipVideoFragment", "release waklock");
      PowerManager.WakeLock localWakeLock = this.kqO;
      com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment", "onDestroy", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      localWakeLock.release();
      com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment", "onDestroy", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
    }
    AppMethodBeat.o(237648);
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(237654);
    super.onDestroyView();
    if (this.NTD != null)
    {
      this.NTD.setVisibility(8);
      this.NTD = null;
    }
    AppMethodBeat.o(237654);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(237676);
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
    AppMethodBeat.o(237676);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt) {}
  
  public final void uninit()
  {
    AppMethodBeat.i(237653);
    Log.printInfoStack("MicroMsg.Voip.VoipVideoFragment", "unit should not be allow in foreground", new Object[0]);
    if ((this.NTD != null) && (this.NVe != null) && (this.NVe.get() != null)) {
      this.NTD.release();
    }
    if ((this.NVe != null) && (this.NVe.get() != null))
    {
      ((c)this.NVe.get()).a(this.NTD);
      ((c)this.NVe.get()).a(this.NTE);
    }
    if (this.NTE != null)
    {
      this.NTE.release();
      this.NTE.setVisibility(4);
      this.NTE = null;
    }
    if (this.NUB != null)
    {
      this.NUB.cancel();
      this.NUB = null;
    }
    super.uninit();
    AppMethodBeat.o(237653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment
 * JD-Core Version:    0.7.0.1
 */