package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.e.a.c;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.video.NewMovableVideoView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bb;
import java.lang.ref.WeakReference;

public class NewVoipVideoFragment
  extends VoipBaseFragment
{
  private Bitmap NKD;
  private boolean UIA;
  private boolean UIB;
  private String UIC;
  private int UIE;
  private boolean UIF;
  public long UIG;
  private NewVoipVideoFragment.a UIH;
  public int UII;
  public int UIJ;
  private int UIK;
  private int UIL;
  private MTimerHandler UIM;
  private boolean UIN;
  private boolean UIO;
  private boolean UIP;
  private View.OnClickListener UIQ;
  private View.OnClickListener UIR;
  private View.OnClickListener UIS;
  private final MTimerHandler.CallBack UIT;
  private Runnable UIU;
  private VoIPRenderSurfaceView UIa;
  private VoIPRenderSurfaceView UIb;
  private RelativeLayout UIc;
  private ImageView UId;
  private TextView UIe;
  private TextView UIf;
  private TextView UIg;
  private TextView UIh;
  private TextView UIi;
  private TextView UIj;
  private TextView UIk;
  private TextView UIl;
  private TextView UIm;
  private TextView UIn;
  private TextView UIo;
  private TextView UIp;
  private com.tencent.mm.plugin.voip.video.d UIq;
  private Button UIr;
  private Button UIs;
  private boolean UIt;
  private int UIu;
  private int UIv;
  private int UIw;
  private int UIx;
  private boolean UIy;
  private boolean UIz;
  private MTimerHandler eln;
  private PowerManager.WakeLock mUJ;
  private long tQb;
  private boolean wUO;
  private int wXx;
  private boolean wXz;
  private Runnable ykR;
  
  public NewVoipVideoFragment()
  {
    AppMethodBeat.i(292428);
    this.UIq = null;
    this.UIr = null;
    this.UIs = null;
    this.UIt = false;
    com.tencent.mm.plugin.voip.f.h localh = com.tencent.mm.plugin.voip.f.h.ULL;
    this.UIy = com.tencent.mm.plugin.voip.f.h.ibC();
    localh = com.tencent.mm.plugin.voip.f.h.ULL;
    this.UIz = com.tencent.mm.plugin.voip.f.h.ibC();
    localh = com.tencent.mm.plugin.voip.f.h.ULL;
    this.UIA = com.tencent.mm.plugin.voip.f.h.ibB();
    localh = com.tencent.mm.plugin.voip.f.h.ULL;
    this.UIB = com.tencent.mm.plugin.voip.f.h.ibA();
    this.UIC = com.tencent.mm.media.util.d.bqp();
    this.UIE = 0;
    this.UIF = false;
    this.wXz = false;
    this.eln = null;
    this.wUO = false;
    this.UIG = 0L;
    this.NKD = null;
    this.UII = 0;
    this.UIJ = 0;
    this.UIK = 0;
    this.tQb = 0L;
    this.UIL = 0;
    this.UIM = null;
    this.UIN = false;
    this.UIO = false;
    this.UIP = false;
    this.UIQ = new NewVoipVideoFragment.1(this);
    this.UIR = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(292407);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = NewVoipVideoFragment.this;
        if (!NewVoipVideoFragment.a(NewVoipVideoFragment.this)) {}
        for (boolean bool = true;; bool = false)
        {
          NewVoipVideoFragment.a(paramAnonymousView, bool);
          if (!NewVoipVideoFragment.a(NewVoipVideoFragment.this)) {
            NewVoipVideoFragment.b(NewVoipVideoFragment.this).setVisibility(8);
          }
          Toast.makeText(NewVoipVideoFragment.this.getActivity(), String.format("mIsShowFaceRect:%b", new Object[] { Boolean.valueOf(NewVoipVideoFragment.a(NewVoipVideoFragment.this)) }), 0).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(292407);
          return;
        }
      }
    };
    this.UIS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(292418);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        boolean bool2 = Util.nullAs((Boolean)paramAnonymousView.getTag(), false);
        boolean bool1;
        if (!bool2)
        {
          bool1 = true;
          paramAnonymousView.setTag(Boolean.valueOf(bool1));
          if (!bool2) {
            break label159;
          }
          NewVoipVideoFragment.b(NewVoipVideoFragment.this).setVisibility(8);
          Toast.makeText(NewVoipVideoFragment.this.getActivity(), "stop face detect", 0).show();
        }
        for (;;)
        {
          if ((NewVoipVideoFragment.this.UJb != null) && (NewVoipVideoFragment.this.UJb.get() != null)) {
            ((c)NewVoipVideoFragment.this.UJb.get()).hWj();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(292418);
          return;
          bool1 = false;
          break;
          label159:
          Toast.makeText(NewVoipVideoFragment.this.getActivity(), "start face detect", 0).show();
        }
      }
    };
    this.UIT = new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(292391);
        String str = NewVoipVideoFragment.iY(Util.secondsToNow(NewVoipVideoFragment.this.UJc));
        NewVoipVideoFragment.c(NewVoipVideoFragment.this).setText(str);
        NewVoipVideoFragment.c(NewVoipVideoFragment.this).setContentDescription(NewVoipVideoFragment.this.iaO());
        NewVoipVideoFragment.d(NewVoipVideoFragment.this);
        AppMethodBeat.o(292391);
        return true;
      }
    };
    this.UIU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(292371);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
        NewVoipVideoFragment.g(NewVoipVideoFragment.this);
        if ((NewVoipVideoFragment.this.getActivity() == null) || (NewVoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(292371);
          return;
        }
        if (NewVoipVideoFragment.h(NewVoipVideoFragment.this) > 0)
        {
          AppMethodBeat.o(292371);
          return;
        }
        NewVoipVideoFragment.c(NewVoipVideoFragment.this).setVisibility(8);
        if (NewVoipVideoFragment.this.UKn != null) {
          NewVoipVideoFragment.this.UKn.iaF();
        }
        if (NewVoipVideoFragment.this.UKp != null) {
          NewVoipVideoFragment.this.UKp.iaF();
        }
        NewVoipVideoFragment.d(NewVoipVideoFragment.this, false);
        NewVoipVideoFragment.i(NewVoipVideoFragment.this).setContentDescription(NewVoipVideoFragment.this.getString(b.g.voip_video_show_buttons));
        AppMethodBeat.o(292371);
      }
    };
    this.ykR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(292377);
        if ((NewVoipVideoFragment.this.getActivity() == null) || (NewVoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(292377);
          return;
        }
        NewVoipVideoFragment.j(NewVoipVideoFragment.this).setVisibility(8);
        AppMethodBeat.o(292377);
      }
    };
    AppMethodBeat.o(292428);
  }
  
  private void GB(boolean paramBoolean)
  {
    AppMethodBeat.i(292484);
    if (this.UKl != null) {
      this.UKl.iau();
    }
    if (this.UKp != null)
    {
      if (paramBoolean)
      {
        this.UKp.GG(true);
        AppMethodBeat.o(292484);
        return;
      }
      this.UKp.GF(true);
    }
    AppMethodBeat.o(292484);
  }
  
  private Point GC(boolean paramBoolean)
  {
    AppMethodBeat.i(292522);
    int i = (int)(aw.bf(getActivity()).y / 5.0D);
    float f = i;
    SubCoreVoip.hVp();
    Point localPoint = new Point((int)(f * u.Gv(paramBoolean)), i);
    AppMethodBeat.o(292522);
    return localPoint;
  }
  
  private void Gz(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(292442);
    if (!this.UIP)
    {
      this.UIc.addView(this.UIa);
      if (!paramBoolean) {
        break label126;
      }
      ((c)this.UJb.get()).a(this.UIb, 1);
      ((c)this.UJb.get()).a(this.UIa, 0);
    }
    for (;;)
    {
      c localc = (c)this.UJb.get();
      paramBoolean = bool;
      if (260 != this.mStatus)
      {
        paramBoolean = bool;
        if (6 != this.mStatus) {
          paramBoolean = true;
        }
      }
      localc.bn(true, paramBoolean);
      this.UIP = true;
      AppMethodBeat.o(292442);
      return;
      label126:
      ((c)this.UJb.get()).a(this.UIb, 0);
      ((c)this.UJb.get()).a(this.UIa, 1);
    }
  }
  
  private void aqQ(int paramInt)
  {
    AppMethodBeat.i(292498);
    if (this.UKp != null) {
      this.UKp.iaB();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.UKh != null) {
        this.UKh.aq(true, false);
      }
      AppMethodBeat.o(292498);
      return;
      this.UIf.setVisibility(0);
      this.UIf.setText(b.g.voip_no_resp);
    }
  }
  
  private void bYv()
  {
    AppMethodBeat.i(292507);
    if ((this.eln == null) || (this.wXz))
    {
      AppMethodBeat.o(292507);
      return;
    }
    if (-1L == this.UJc) {
      this.UJc = Util.nowSecond();
    }
    this.UIG = this.UJc;
    this.wXz = true;
    this.eln.startTimer(1000L, 1000L);
    this.UIM = new MTimerHandler("VoipVideoFragment_cpuStatThread", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(292374);
        if (NewVoipVideoFragment.k(NewVoipVideoFragment.this))
        {
          NewVoipVideoFragment.l(NewVoipVideoFragment.this);
          AppMethodBeat.o(292374);
          return true;
        }
        AppMethodBeat.o(292374);
        return false;
      }
    }, true);
    this.UIN = true;
    this.UIM.startTimer(1000L);
    AppMethodBeat.o(292507);
  }
  
  private void iai()
  {
    AppMethodBeat.i(292436);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
    this.UIE += 1;
    this.qse.postDelayed(this.UIU, 10000L);
    AppMethodBeat.o(292436);
  }
  
  private void iak()
  {
    AppMethodBeat.i(292450);
    this.UIa.setVisibility(0);
    this.UIc.setImportantForAccessibility(4);
    if (this.UKc != null) {
      iaN();
    }
    if (this.UKl != null) {
      this.UKl.GD(true);
    }
    if (this.UKp != null) {
      this.UKp.GD(true);
    }
    this.UIg.setVisibility(8);
    if (SubCoreVoip.hVp().Uxv != null)
    {
      this.UIg.setVisibility(0);
      this.UIg.setText(SubCoreVoip.hVp().Uxv);
    }
    if (af.lXY.lST == 1)
    {
      this.UId.setVisibility(0);
      this.UIa.setVisibility(4);
    }
    AppMethodBeat.o(292450);
  }
  
  private void ial()
  {
    AppMethodBeat.i(292458);
    if (this.UKl != null) {
      this.UKl.iav();
    }
    this.UIa.setVisibility(0);
    this.UIc.setImportantForAccessibility(4);
    this.UKb.setVisibility(8);
    this.UIf.setVisibility(8);
    this.UIg.setVisibility(8);
    if (SubCoreVoip.hVp().Uxv != null)
    {
      this.UIg.setVisibility(0);
      this.UIg.setText(SubCoreVoip.hVp().Uxv);
    }
    if (this.UKp != null) {
      this.UKp.GE(true);
    }
    AppMethodBeat.o(292458);
  }
  
  private void iam()
  {
    boolean bool2 = true;
    AppMethodBeat.i(292473);
    if (this.UKc != null) {
      this.UKc.setVisibility(8);
    }
    if (this.UKn != null) {
      this.UKn.iam();
    }
    if (this.UIb == null)
    {
      AppMethodBeat.o(292473);
      return;
    }
    if (this.UIb.getVisibility() == 0)
    {
      AppMethodBeat.o(292473);
      return;
    }
    label99:
    Point localPoint;
    if (this.Uxb) {
      if (!this.UIF)
      {
        bool1 = true;
        this.UIF = bool1;
        if (this.UIF) {
          break label436;
        }
        bool1 = true;
        localPoint = GC(bool1);
        this.UIb.mI(localPoint.x, localPoint.y);
        if (z.bTO())
        {
          this.UIh.setVisibility(0);
          this.UIi.setVisibility(0);
          this.UIj.setVisibility(0);
          this.UIk.setVisibility(0);
          this.UIl.setVisibility(0);
          this.UIm.setVisibility(0);
          this.UIn.setVisibility(0);
          this.UIo.setVisibility(0);
          this.UIp.setVisibility(0);
        }
        this.UIa.setVisibility(0);
        this.UIb.setVisibility(0);
        this.UIc.setImportantForAccessibility(1);
        this.UIb.setContentDescription(getString(b.g.voip_change_small_view_tip));
        this.UIc.setContentDescription(getString(b.g.voip_video_hide_buttons));
        this.UIe.setVisibility(0);
        if (this.UKm != null)
        {
          this.UKm.removeAllViews();
          iaK();
        }
        if (this.UKp != null) {
          this.UKp.iaA();
        }
        ((c)this.UJb.get()).Gm(this.UIF);
        Log.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", new Object[] { Integer.valueOf(this.UII) });
        if (this.UIF) {
          break label463;
        }
      }
    }
    label436:
    label463:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPoint = GC(bool1);
      ((NewMovableVideoView)this.UIb).mG(localPoint.x, localPoint.y);
      bYv();
      if (MMApplicationContext.getDefaultPreference().getBoolean("voipfaceDebug", false))
      {
        this.UIr.setVisibility(0);
        this.UIs.setVisibility(0);
      }
      iai();
      if (this.UKd == 4102) {
        mE(b.g.voip_accept_invite_normal, 10000);
      }
      AppMethodBeat.o(292473);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label99;
      if (!this.UIF) {}
      for (bool1 = true;; bool1 = false)
      {
        this.UIF = bool1;
        break;
      }
    }
  }
  
  private void ian()
  {
    AppMethodBeat.i(292515);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(292410);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        com.tencent.mm.plugin.report.service.h.OAn.b(11079, new Object[] { Integer.valueOf(4) });
        int j;
        int i;
        if (NewVoipVideoFragment.this.UKp != null)
        {
          j = NewVoipVideoFragment.this.UKp.iaI();
          if (j != 0) {
            break label370;
          }
          i = 0;
          if (i != 0) {
            break label376;
          }
          if (NewVoipVideoFragment.this.UKn != null) {
            NewVoipVideoFragment.this.UKn.iaG();
          }
          if (NewVoipVideoFragment.this.UKp != null) {
            NewVoipVideoFragment.this.UKp.iaG();
          }
          NewVoipVideoFragment.i(NewVoipVideoFragment.this).setImportantForAccessibility(1);
          NewVoipVideoFragment.i(NewVoipVideoFragment.this).setContentDescription(NewVoipVideoFragment.this.getString(b.g.voip_video_hide_buttons));
          NewVoipVideoFragment.this.iaK();
          label166:
          if (NewVoipVideoFragment.this.UKf != null) {
            NewVoipVideoFragment.this.UKf.setVisibility(i);
          }
          if (NewVoipVideoFragment.this.UKg != null) {
            NewVoipVideoFragment.this.UKg.setVisibility(i);
          }
          NewVoipVideoFragment.c(NewVoipVideoFragment.this).setVisibility(i);
          if (NewVoipVideoFragment.this.UKp != null) {
            NewVoipVideoFragment.this.UKp.aqS(i);
          }
          paramAnonymousView = NewVoipVideoFragment.this;
          if (i != 0) {
            break label430;
          }
        }
        label430:
        for (boolean bool = true;; bool = false)
        {
          NewVoipVideoFragment.d(paramAnonymousView, bool);
          if (z.bTO())
          {
            NewVoipVideoFragment.m(NewVoipVideoFragment.this).setVisibility(i);
            NewVoipVideoFragment.n(NewVoipVideoFragment.this).setVisibility(i);
            NewVoipVideoFragment.o(NewVoipVideoFragment.this).setVisibility(i);
            NewVoipVideoFragment.p(NewVoipVideoFragment.this).setVisibility(i);
            NewVoipVideoFragment.q(NewVoipVideoFragment.this).setVisibility(i);
            NewVoipVideoFragment.r(NewVoipVideoFragment.this).setVisibility(i);
            NewVoipVideoFragment.s(NewVoipVideoFragment.this).setVisibility(i);
          }
          if (j == 0) {
            NewVoipVideoFragment.t(NewVoipVideoFragment.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(292410);
          return;
          label370:
          i = 8;
          break;
          label376:
          if (NewVoipVideoFragment.this.UKn != null) {
            NewVoipVideoFragment.this.UKn.iaF();
          }
          NewVoipVideoFragment.i(NewVoipVideoFragment.this).setImportantForAccessibility(1);
          NewVoipVideoFragment.i(NewVoipVideoFragment.this).setContentDescription(NewVoipVideoFragment.this.getString(b.g.voip_video_show_buttons));
          break label166;
        }
      }
    };
    this.thl.setOnClickListener(local2);
    AppMethodBeat.o(292515);
  }
  
  private void iap()
  {
    AppMethodBeat.i(292535);
    com.tencent.mm.plugin.report.service.h.OAn.a(11526, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(3) });
    if ((this.UJb != null) && (this.UJb.get() != null) && (((c)this.UJb.get()).hVI()))
    {
      if (this.UKp != null) {
        this.UKp.iaD();
      }
      if (this.UKl != null) {
        this.UKl.iau();
      }
    }
    AppMethodBeat.o(292535);
  }
  
  private void iaq()
  {
    AppMethodBeat.i(292547);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite");
    com.tencent.mm.plugin.report.service.h.OAn.a(11526, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(1) });
    if ((this.UJb != null) && (this.UJb.get() != null) && (((c)this.UJb.get()).hVK()) && (this.UKp != null)) {
      this.UKp.iaD();
    }
    AppMethodBeat.o(292547);
  }
  
  protected final void GA(boolean paramBoolean)
  {
    AppMethodBeat.i(292882);
    if (this.JQB != null)
    {
      if (!paramBoolean) {
        break label59;
      }
      this.JQB.setText(b.g.voip_net_status_self_warning_hint);
    }
    for (;;)
    {
      this.JQB.clearAnimation();
      this.JQB.setVisibility(0);
      this.JQB.sendAccessibilityEvent(128);
      AppMethodBeat.o(292882);
      return;
      label59:
      this.JQB.setText(b.g.voip_net_status_other_warning_hint);
    }
  }
  
  public final void VV(int paramInt)
  {
    this.UIv += 1;
    if (paramInt > 0) {
      this.UIu += 1;
    }
  }
  
  public final void VX(int paramInt)
  {
    this.UII = paramInt;
  }
  
  public final void VY(int paramInt)
  {
    this.UIJ = paramInt;
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(292904);
    super.a(paramc, paramBundle);
    switch (7.UIW[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(292904);
      return;
      iao();
      AppMethodBeat.o(292904);
      return;
      if ((NetStatusUtil.isWifi(getActivity())) || (com.tencent.mm.plugin.voip.model.s.hXN()))
      {
        Log.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite use voice");
        iap();
        AppMethodBeat.o(292904);
        return;
      }
      com.tencent.mm.ui.base.k.a(getActivity(), b.g.voip_not_wifi_warnning_message, b.g.voip_not_wifi_warnning_title, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(292408);
          com.tencent.mm.plugin.voip.model.s.hXM();
          NewVoipVideoFragment.u(NewVoipVideoFragment.this);
          AppMethodBeat.o(292408);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(292404);
          NewVoipVideoFragment.this.iao();
          AppMethodBeat.o(292404);
        }
      });
      AppMethodBeat.o(292904);
      return;
      Log.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
      if ((NetStatusUtil.isWifi(getActivity())) || ((com.tencent.mm.plugin.voip.model.s.hXN()) && (!NetStatusUtil.is2G(getActivity()))))
      {
        iaq();
        AppMethodBeat.o(292904);
        return;
      }
      com.tencent.mm.ui.base.k.a(getActivity(), b.g.voip_not_wifi_warnning_message, b.g.voip_not_wifi_warnning_title, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(292401);
          if (!NetStatusUtil.is2G(NewVoipVideoFragment.this.getActivity())) {
            com.tencent.mm.plugin.voip.model.s.hXM();
          }
          NewVoipVideoFragment.v(NewVoipVideoFragment.this);
          AppMethodBeat.o(292401);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(292403);
          NewVoipVideoFragment.this.iao();
          AppMethodBeat.o(292403);
        }
      });
      AppMethodBeat.o(292904);
      return;
      if ((this.UJb != null) && (this.UJb.get() != null))
      {
        ((c)this.UJb.get()).hVZ();
        AppMethodBeat.o(292904);
        return;
        Log.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
        if ((this.UJb != null) && (this.UJb.get() != null) && (((c)this.UJb.get()).hVN()) && (this.UJb != null) && (this.UJb.get() != null) && (this.UKp != null))
        {
          mE(b.g.voip_cancel_call, -1);
          this.UKp.iaC();
          AppMethodBeat.o(292904);
          return;
          Log.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
          iai();
          if ((this.UJb != null) && (this.UJb.get() != null)) {
            ((c)this.UJb.get()).aL(null);
          }
        }
      }
    }
  }
  
  protected final void aDJ(String paramString)
  {
    AppMethodBeat.i(292874);
    if (this.UIg != null)
    {
      this.UIg.setVisibility(0);
      this.UIg.setText(paramString);
      this.UIf.sendAccessibilityEvent(128);
    }
    AppMethodBeat.o(292874);
  }
  
  public final void fwq()
  {
    this.wXx += 1;
  }
  
  protected final int getLayoutId()
  {
    return b.e.voip_video_fragment;
  }
  
  public final void iU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(292858);
    super.iU(paramInt1, paramInt2);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + com.tencent.mm.plugin.voip.f.k.arg(paramInt2));
    if (this.thl == null)
    {
      Log.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
      AppMethodBeat.o(292858);
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
        if ((af.lXY.lST == 1) && (paramInt1 != 0)) {
          this.UId.setVisibility(8);
        }
        AppMethodBeat.o(292858);
        return;
        this.UIO = true;
        Gz(true);
        ial();
        paramInt1 = 1;
        continue;
        this.UIO = true;
        Gz(true);
        iak();
        paramInt1 = 0;
        continue;
        ian();
        if (this.UIO)
        {
          ((c)this.UJb.get()).hVV();
          com.tencent.mm.plugin.voip.f.i.GO(false);
          this.UIO = false;
        }
        for (;;)
        {
          iam();
          paramInt1 = 1;
          break;
          Gz(false);
        }
        aqQ(paramInt1);
        paramInt1 = 1;
        continue;
        GB(true);
        paramInt1 = 1;
      }
      GB(false);
    }
  }
  
  protected final boolean iah()
  {
    return true;
  }
  
  protected final void iaj()
  {
    AppMethodBeat.i(292886);
    if (this.JQB != null)
    {
      this.JQB.clearAnimation();
      this.JQB.setVisibility(8);
    }
    AppMethodBeat.o(292886);
  }
  
  protected final void iao()
  {
    AppMethodBeat.i(292901);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "reject video invite");
    com.tencent.mm.plugin.report.service.h.OAn.a(11526, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(4) });
    if ((this.UJb != null) && (this.UJb.get() != null) && (((c)this.UJb.get()).hVJ()))
    {
      mE(b.g.voip_reject_call, -1);
      if (this.UKp != null) {
        this.UKp.iaE();
      }
    }
    AppMethodBeat.o(292901);
  }
  
  protected final void mE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(292878);
    if (this.UIf == null)
    {
      AppMethodBeat.o(292878);
      return;
    }
    this.UIf.setText(paramInt1);
    this.UIf.setVisibility(0);
    this.UIf.sendAccessibilityEvent(128);
    this.UIf.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.UIf.setBackgroundResource(b.c.voip_toast_bg);
    this.UIf.setCompoundDrawables(null, null, null, null);
    this.UIf.setCompoundDrawablePadding(0);
    this.qse.removeCallbacks(this.ykR);
    if (-1 != paramInt2) {
      this.qse.postDelayed(this.ykR, paramInt2);
    }
    AppMethodBeat.o(292878);
  }
  
  public final void n(Point paramPoint)
  {
    AppMethodBeat.i(292895);
    VoIPRenderSurfaceView localVoIPRenderSurfaceView = this.UIa;
    kotlin.g.b.s.u(paramPoint, "screenSize");
    Log.i(localVoIPRenderSurfaceView.TAG, "new size from resource Helper w %s * h  %s", new Object[] { Integer.valueOf(com.tencent.mm.cd.a.ms(localVoIPRenderSurfaceView.getContext())), Integer.valueOf(com.tencent.mm.cd.a.mt(localVoIPRenderSurfaceView.getContext())) });
    int i = paramPoint.x;
    i = paramPoint.y;
    if (aw.jkQ())
    {
      paramPoint = new RelativeLayout.LayoutParams(i * 9 / 16, i);
      paramPoint.addRule(13);
    }
    for (;;)
    {
      localVoIPRenderSurfaceView.setLayoutParams((ViewGroup.LayoutParams)paramPoint);
      localVoIPRenderSurfaceView.requestLayout();
      if (this.UIb != null)
      {
        paramPoint = (NewMovableVideoView)this.UIb;
        Log.i("MicroMsg.MovableVideoView", "refrsh view %s, %s", new Object[] { Integer.valueOf(paramPoint.mWidth), Integer.valueOf(paramPoint.UMD) });
        paramPoint.mScreenWidth = 0;
        paramPoint.mG(paramPoint.mWidth, paramPoint.UMD);
      }
      AppMethodBeat.o(292895);
      return;
      paramPoint = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(292843);
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.UKb = ((ImageView)this.thl.findViewById(b.d.voip_blur_avatar));
    this.UKc = ((ImageView)this.thl.findViewById(b.d.voip_transparent_blur));
    this.UIa = new VoIPRenderSurfaceView(paramViewGroup.getContext());
    this.UIa.mJ(mScreenWidth, mScreenHeight);
    this.UIc = ((RelativeLayout)this.thl.findViewById(b.d.big_video_container));
    int i = mScreenHeight;
    paramViewGroup = this.UIc;
    int j;
    if ((aw.jkQ()) || (aw.ato()))
    {
      paramLayoutInflater = new RelativeLayout.LayoutParams(i * 9 / 16, -1);
      paramLayoutInflater.addRule(14);
      paramViewGroup.setLayoutParams(paramLayoutInflater);
      this.UIc.setImportantForAccessibility(4);
      Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: onCreateView!");
      this.UIe = ((TextView)this.thl.findViewById(b.d.voip_video_time));
      this.UIf = ((TextView)this.thl.findViewById(b.d.voip_video_call_hint));
      this.UIg = ((TextView)this.thl.findViewById(b.d.voip_video_risk_call_hint));
      this.JQB = ((TextView)this.thl.findViewById(b.d.voip_net_status_hint));
      this.Ltg = ((ImageView)this.thl.findViewById(b.d.link_arrow));
      this.Ltg.setImageDrawable(bb.m(MMApplicationContext.getContext(), b.f.icons_filled_arrow, -1));
      this.UId = ((ImageView)this.thl.findViewById(b.d.full_avatart));
      paramLayoutInflater = com.tencent.mm.modelavatar.d.a(this.luk, false, -1, null);
      this.UId.setImageBitmap(BitmapUtil.fastblur(paramLayoutInflater, 10));
      if (z.bTO())
      {
        this.UIh = ((TextView)this.thl.findViewById(b.d.voip_cap_fps));
        this.UIi = ((TextView)this.thl.findViewById(b.d.voip_send_fps));
        this.UIj = ((TextView)this.thl.findViewById(b.d.voip_recv_fps));
        this.UIk = ((TextView)this.thl.findViewById(b.d.voip_send_kbps));
        this.UIl = ((TextView)this.thl.findViewById(b.d.voip_recv_kbps));
        this.UIm = ((TextView)this.thl.findViewById(b.d.engineInfo));
        this.UIn = ((TextView)this.thl.findViewById(b.d.gpu_crop_info));
        this.UIo = ((TextView)this.thl.findViewById(b.d.camera_info));
        this.UIp = ((TextView)this.thl.findViewById(b.d.gpu_infomation));
      }
      this.UIr = ((Button)this.thl.findViewById(b.d.voip_face_debug));
      this.UIs = ((Button)this.thl.findViewById(b.d.voip_face_debug_switch));
      this.UIr.setVisibility(8);
      this.UIs.setVisibility(8);
      this.UIr.setOnClickListener(this.UIR);
      this.UIs.setOnClickListener(this.UIS);
      this.UIq = new com.tencent.mm.plugin.voip.video.d(getActivity());
      this.thl.addView(this.UIq);
      this.UIq.setVisibility(8);
      i = aa.be(getActivity());
      Log.d("MicroMsg.Voip.VoipVideoFragment", "statusHeight: ".concat(String.valueOf(i)));
      bb(this.thl.findViewById(b.d.voip_time_tv_container), i);
      if (this.UKn != null) {
        this.UKn.aqV(i);
      }
      this.UIv = 0;
      this.UIu = 0;
      this.wXx = 0;
      this.UIw = 0;
      this.UIx = 0;
      this.UIK = 0;
      this.UIL = 0;
      int k = aw.bf(getContext()).y;
      i = aw.bf(getContext()).x;
      j = k / 5;
      if (k == 0) {
        break label1024;
      }
      i = i * j / k;
    }
    label1024:
    for (;;)
    {
      this.UIb = new NewMovableVideoView(MMApplicationContext.getContext());
      this.UIb.setContentDescription("切换画面，按钮，点按两次即可激活");
      ((NewMovableVideoView)this.UIb).mG(i, j);
      this.UIb.setVisibility(4);
      this.UIa.setVisibility(0);
      Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
      this.thl.addView(this.UIb);
      this.UIb.setOnClickListener(new View.OnClickListener()
      {
        long UIX = 0L;
        
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(292393);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
          this.UIX = Util.currentTicks();
          paramAnonymousView = NewVoipVideoFragment.this;
          if (!NewVoipVideoFragment.e(NewVoipVideoFragment.this))
          {
            bool = true;
            NewVoipVideoFragment.b(paramAnonymousView, bool);
            ((c)NewVoipVideoFragment.this.UJb.get()).hVV();
            com.tencent.mm.plugin.voip.f.i.GO(true);
            paramAnonymousView = NewVoipVideoFragment.this;
            if (NewVoipVideoFragment.e(NewVoipVideoFragment.this)) {
              break label187;
            }
          }
          label187:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView = NewVoipVideoFragment.c(paramAnonymousView, bool);
            if (NewVoipVideoFragment.f(NewVoipVideoFragment.this) != null) {
              NewVoipVideoFragment.f(NewVoipVideoFragment.this).mI(paramAnonymousView.x, paramAnonymousView.y);
            }
            com.tencent.mm.plugin.report.service.h.OAn.b(11079, new Object[] { Integer.valueOf(3) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(292393);
            return;
            bool = false;
            break;
          }
        }
      });
      if (this.Uxb) {
        this.qse.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(292372);
            if (NewVoipVideoFragment.this.UKl != null) {
              NewVoipVideoFragment.this.UKl.iav();
            }
            AppMethodBeat.o(292372);
          }
        }, 2000L);
      }
      this.eln = new MTimerHandler(Looper.getMainLooper(), this.UIT, true);
      Log.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", new Object[] { Integer.valueOf(this.UIJ) });
      this.wUO = true;
      if ((this.UJb != null) && (this.UJb.get() != null)) {
        ((c)this.UJb.get()).hVW();
      }
      iU(0, this.mStatus);
      this.mUJ = ((PowerManager)MMApplicationContext.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipVideoFragment");
      paramLayoutInflater = this.mUJ;
      com.tencent.mm.hellhoundlib.a.a.b(paramLayoutInflater, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      paramLayoutInflater.acquire();
      com.tencent.mm.hellhoundlib.a.a.c(paramLayoutInflater, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      Log.i("MicroMsg.Voip.VoipVideoFragment", "acquire wakelock");
      paramLayoutInflater = this.thl;
      AppMethodBeat.o(292843);
      return paramLayoutInflater;
      paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -1);
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(292851);
    this.wXz = false;
    Log.i("MicroMsg.Voip.VoipVideoFragment", "onDestory");
    super.onDestroy();
    if ((this.mUJ != null) && (this.mUJ.isHeld()))
    {
      Log.i("MicroMsg.Voip.VoipVideoFragment", "release waklock");
      PowerManager.WakeLock localWakeLock = this.mUJ;
      com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment", "onDestroy", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      localWakeLock.release();
      com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment", "onDestroy", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
    }
    AppMethodBeat.o(292851);
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(292866);
    super.onDestroyView();
    if (this.UIa != null)
    {
      this.UIa.setVisibility(8);
      this.UIa = null;
    }
    AppMethodBeat.o(292866);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(292897);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "onDetach");
    if (this.eln != null)
    {
      this.eln.stopTimer();
      this.eln = null;
    }
    if (this.UIM != null) {
      this.UIM.stopTimer();
    }
    this.UIN = false;
    super.onDetach();
    AppMethodBeat.o(292897);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt) {}
  
  public final void uninit()
  {
    AppMethodBeat.i(292863);
    Log.printInfoStack("MicroMsg.Voip.VoipVideoFragment", "unit should not be allow in foreground", new Object[0]);
    if ((this.UIa != null) && (this.UJb != null) && (this.UJb.get() != null)) {
      this.UIa.release();
    }
    if ((this.UJb != null) && (this.UJb.get() != null))
    {
      ((c)this.UJb.get()).a(this.UIa);
      ((c)this.UJb.get()).a(this.UIb);
    }
    if (this.UIb != null)
    {
      this.UIb.release();
      this.UIb.setVisibility(4);
      this.UIb = null;
    }
    if (this.UIH != null)
    {
      this.UIH.cancel();
      this.UIH = null;
    }
    super.uninit();
    AppMethodBeat.o(292863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment
 * JD-Core Version:    0.7.0.1
 */