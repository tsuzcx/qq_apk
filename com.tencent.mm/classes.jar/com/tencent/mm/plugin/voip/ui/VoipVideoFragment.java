package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.e.a.c;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.plugin.voip.widget.VoIPVideoView;
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

public class VoipVideoFragment
  extends VoipBaseFragment
{
  int[] LnE;
  private Bitmap NKD;
  private int UIE;
  private boolean UIF;
  public long UIG;
  public int UII;
  public int UIJ;
  private int UIK;
  private int UIL;
  private MTimerHandler UIM;
  private boolean UIN;
  private View.OnClickListener UIR;
  private View.OnClickListener UIS;
  private Runnable UIU;
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
  private com.tencent.mm.plugin.voip.video.d UIq;
  private Button UIr;
  private Button UIs;
  private boolean UIt;
  private int UIu;
  private int UIv;
  private int UIw;
  private int UIx;
  private OpenGlView UKH;
  private OpenGlView UKI;
  private OpenGlRender UKJ;
  private OpenGlRender UKK;
  private VoIPVideoView UKL;
  private VoipVideoFragment.a UKM;
  public int UKN;
  private final MTimerHandler.CallBack UKO;
  int UKP;
  public int UxE;
  public int UxF;
  private MTimerHandler eln;
  private PowerManager.WakeLock mUJ;
  private SurfaceTexture surfaceTexture;
  private CaptureView wUL;
  private boolean wUO;
  private int wXx;
  private boolean wXz;
  private Runnable ykR;
  
  public VoipVideoFragment()
  {
    AppMethodBeat.i(115420);
    this.UIq = null;
    this.UIr = null;
    this.UIs = null;
    this.UIt = false;
    this.UIE = 0;
    this.UIF = false;
    this.wXz = false;
    this.wUO = false;
    this.UIG = 0L;
    this.NKD = null;
    this.UII = 0;
    this.UIJ = 0;
    this.UKN = 0;
    this.UIK = 0;
    this.UIL = 0;
    this.UIM = null;
    this.UIN = false;
    this.UxE = 0;
    this.UxF = 0;
    this.surfaceTexture = null;
    this.UIR = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115394);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = VoipVideoFragment.this;
        if (!VoipVideoFragment.a(VoipVideoFragment.this)) {}
        for (boolean bool = true;; bool = false)
        {
          VoipVideoFragment.a(paramAnonymousView, bool);
          if (!VoipVideoFragment.a(VoipVideoFragment.this)) {
            VoipVideoFragment.b(VoipVideoFragment.this).setVisibility(8);
          }
          Toast.makeText(VoipVideoFragment.this.getActivity(), String.format("mIsShowFaceRect:%b", new Object[] { Boolean.valueOf(VoipVideoFragment.a(VoipVideoFragment.this)) }), 0).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115394);
          return;
        }
      }
    };
    this.UIS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115406);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        boolean bool2 = Util.nullAs((Boolean)paramAnonymousView.getTag(), false);
        boolean bool1;
        if (!bool2)
        {
          bool1 = true;
          paramAnonymousView.setTag(Boolean.valueOf(bool1));
          if (!bool2) {
            break label159;
          }
          VoipVideoFragment.b(VoipVideoFragment.this).setVisibility(8);
          Toast.makeText(VoipVideoFragment.this.getActivity(), "stop face detect", 0).show();
        }
        for (;;)
        {
          if ((VoipVideoFragment.this.UJb != null) && (VoipVideoFragment.this.UJb.get() != null)) {
            ((c)VoipVideoFragment.this.UJb.get()).hWj();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115406);
          return;
          bool1 = false;
          break;
          label159:
          Toast.makeText(VoipVideoFragment.this.getActivity(), "start face detect", 0).show();
        }
      }
    };
    this.UKO = new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(292440);
        String str = VoipVideoFragment.iY(Util.secondsToNow(VoipVideoFragment.this.UJc));
        VoipVideoFragment.c(VoipVideoFragment.this).setText(str);
        VoipVideoFragment.c(VoipVideoFragment.this).setContentDescription(VoipVideoFragment.this.iaO());
        VoipVideoFragment.d(VoipVideoFragment.this);
        AppMethodBeat.o(292440);
        return true;
      }
    };
    this.UIU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(292415);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
        VoipVideoFragment.g(VoipVideoFragment.this);
        if ((VoipVideoFragment.this.getActivity() == null) || (VoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(292415);
          return;
        }
        if (VoipVideoFragment.h(VoipVideoFragment.this) > 0)
        {
          AppMethodBeat.o(292415);
          return;
        }
        VoipVideoFragment.c(VoipVideoFragment.this).setVisibility(8);
        if (VoipVideoFragment.this.UKn != null) {
          VoipVideoFragment.this.UKn.iaF();
        }
        if (VoipVideoFragment.this.UKp != null) {
          VoipVideoFragment.this.UKp.iaF();
        }
        VoipVideoFragment.d(VoipVideoFragment.this, false);
        AppMethodBeat.o(292415);
      }
    };
    this.ykR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(292414);
        if ((VoipVideoFragment.this.getActivity() == null) || (VoipVideoFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(292414);
          return;
        }
        VoipVideoFragment.i(VoipVideoFragment.this).setVisibility(8);
        AppMethodBeat.o(292414);
      }
    };
    this.LnE = null;
    this.UKP = 0;
    AppMethodBeat.o(115420);
  }
  
  private Point GC(boolean paramBoolean)
  {
    AppMethodBeat.i(115454);
    int i = (int)(getActivity().getWindowManager().getDefaultDisplay().getHeight() / 5.0D);
    float f = i;
    SubCoreVoip.hVp();
    Point localPoint = new Point((int)(f * u.Gv(paramBoolean)), i);
    AppMethodBeat.o(115454);
    return localPoint;
  }
  
  private void aqQ(int paramInt)
  {
    AppMethodBeat.i(115448);
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
      AppMethodBeat.o(115448);
      return;
      this.UIf.setVisibility(0);
      this.UIf.setText(b.g.voip_no_resp);
      this.UIf.sendAccessibilityEvent(128);
    }
  }
  
  private void bYv()
  {
    AppMethodBeat.i(115449);
    if ((this.eln == null) || (this.wXz))
    {
      AppMethodBeat.o(115449);
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
        AppMethodBeat.i(292375);
        if (VoipVideoFragment.j(VoipVideoFragment.this))
        {
          VoipVideoFragment.k(VoipVideoFragment.this);
          AppMethodBeat.o(292375);
          return true;
        }
        AppMethodBeat.o(292375);
        return false;
      }
    }, true);
    this.UIN = true;
    this.UIM.startTimer(1000L);
    AppMethodBeat.o(115449);
  }
  
  private void iai()
  {
    AppMethodBeat.i(115427);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
    this.UIE += 1;
    this.qse.postDelayed(this.UIU, 10000L);
    AppMethodBeat.o(115427);
  }
  
  private void iak()
  {
    AppMethodBeat.i(115438);
    this.UKH.setVisibility(0);
    this.UKH.setImportantForAccessibility(4);
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
      this.UKH.setVisibility(4);
    }
    AppMethodBeat.o(115438);
  }
  
  private void ial()
  {
    AppMethodBeat.i(115439);
    this.UKH.setVisibility(0);
    this.UKH.setImportantForAccessibility(4);
    if (this.UKl != null) {
      this.UKl.iav();
    }
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
    AppMethodBeat.o(115439);
  }
  
  private void iam()
  {
    boolean bool2 = true;
    AppMethodBeat.i(115440);
    if (this.UKn != null) {
      this.UKn.iam();
    }
    if (this.UKc != null) {
      this.UKc.setVisibility(8);
    }
    if (!this.UKI.UNN)
    {
      AppMethodBeat.o(115440);
      return;
    }
    this.UKI.GR(false);
    label93:
    Point localPoint;
    if (this.Uxb) {
      if (!this.UIF)
      {
        bool1 = true;
        this.UIF = bool1;
        if (this.UIF) {
          break label369;
        }
        bool1 = true;
        localPoint = GC(bool1);
        this.UKI.mI(localPoint.x, localPoint.y);
        if (z.bTO())
        {
          this.UIh.setVisibility(0);
          this.UIi.setVisibility(0);
          this.UIj.setVisibility(0);
          this.UIk.setVisibility(0);
          this.UIl.setVisibility(0);
          this.UIm.setVisibility(0);
        }
        if (this.UKm != null)
        {
          this.UKm.removeAllViews();
          iaK();
        }
        this.UKH.setVisibility(0);
        this.UKI.setVisibility(0);
        this.UIe.setVisibility(0);
        this.UKI.setContentDescription("切换画面，按钮，点按两次即可激活");
        if (this.UKp != null) {
          this.UKp.iaA();
        }
        setHWDecMode(this.UII);
        Log.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", new Object[] { Integer.valueOf(this.UII) });
        if (this.UIF) {
          break label405;
        }
      }
    }
    label405:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPoint = GC(bool1);
      ((MovableVideoView)this.UKI).mG(localPoint.x, localPoint.y);
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
      AppMethodBeat.o(115440);
      return;
      bool1 = false;
      break;
      label369:
      bool1 = false;
      break label93;
      if (!this.UIF) {}
      for (bool1 = true;; bool1 = false)
      {
        this.UIF = bool1;
        this.UKL.setVisibility(8);
        break;
      }
    }
  }
  
  private void ian()
  {
    AppMethodBeat.i(115450);
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115396);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        h.OAn.b(11079, new Object[] { Integer.valueOf(4) });
        int j;
        int i;
        if (VoipVideoFragment.this.UKp != null)
        {
          j = VoipVideoFragment.this.UKp.iaI();
          if (j != 0) {
            break label328;
          }
          i = 0;
          if (i != 0) {
            break label334;
          }
          if (VoipVideoFragment.this.UKn != null) {
            VoipVideoFragment.this.UKn.iaG();
          }
          if (VoipVideoFragment.this.UKp != null) {
            VoipVideoFragment.this.UKp.iaG();
          }
          VoipVideoFragment.this.iaK();
          label135:
          VoipVideoFragment.c(VoipVideoFragment.this).setVisibility(i);
          if (VoipVideoFragment.this.UKp != null) {
            VoipVideoFragment.this.UKp.aqS(i);
          }
          if (VoipVideoFragment.this.UKf == null) {
            VoipVideoFragment.this.UKf.setVisibility(i);
          }
          if (VoipVideoFragment.this.UKg != null) {
            VoipVideoFragment.this.UKg.setVisibility(i);
          }
          paramAnonymousView = VoipVideoFragment.this;
          if (i != 0) {
            break label357;
          }
        }
        label328:
        label334:
        label357:
        for (boolean bool = true;; bool = false)
        {
          VoipVideoFragment.d(paramAnonymousView, bool);
          if (z.bTO())
          {
            VoipVideoFragment.l(VoipVideoFragment.this).setVisibility(i);
            VoipVideoFragment.m(VoipVideoFragment.this).setVisibility(i);
            VoipVideoFragment.n(VoipVideoFragment.this).setVisibility(i);
            VoipVideoFragment.o(VoipVideoFragment.this).setVisibility(i);
            VoipVideoFragment.p(VoipVideoFragment.this).setVisibility(i);
            VoipVideoFragment.q(VoipVideoFragment.this).setVisibility(i);
          }
          if (j == 0) {
            VoipVideoFragment.r(VoipVideoFragment.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115396);
          return;
          i = 8;
          break;
          if (VoipVideoFragment.this.UKn == null) {
            break label135;
          }
          VoipVideoFragment.this.UKn.iaF();
          break label135;
        }
      }
    };
    this.thl.setOnClickListener(local3);
    AppMethodBeat.o(115450);
  }
  
  private void iap()
  {
    AppMethodBeat.i(292609);
    h.OAn.a(11526, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(3) });
    if ((this.UJb != null) && (this.UJb.get() != null) && (((c)this.UJb.get()).hVI()) && (this.UKp != null) && (this.UKl != null))
    {
      this.UKp.iaD();
      this.UKl.iau();
    }
    AppMethodBeat.o(292609);
  }
  
  private void iaq()
  {
    AppMethodBeat.i(292624);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite");
    h.OAn.a(11526, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(1) });
    if ((this.UJb != null) && (this.UJb.get() != null) && (((c)this.UJb.get()).hVK()) && (this.UKp != null)) {
      this.UKp.iaD();
    }
    AppMethodBeat.o(292624);
  }
  
  private void iau()
  {
    AppMethodBeat.i(115447);
    if (this.UKl != null) {
      this.UKl.iau();
    }
    AppMethodBeat.o(115447);
  }
  
  protected final void GA(boolean paramBoolean)
  {
    AppMethodBeat.i(115435);
    if (this.JQB != null)
    {
      if (!paramBoolean) {
        break label49;
      }
      this.JQB.setText(b.g.voip_net_status_self_warning_hint);
    }
    for (;;)
    {
      this.JQB.clearAnimation();
      this.JQB.setVisibility(0);
      AppMethodBeat.o(115435);
      return;
      label49:
      this.JQB.setText(b.g.voip_net_status_other_warning_hint);
    }
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(293016);
    switch (8.UIW[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
    }
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(293016);
          return;
          h.OAn.b(11618, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
          if ((this.UJb != null) && (this.UJb.get() != null)) {
            ((c)this.UJb.get()).Gn(true);
          }
          if (this.UKh != null)
          {
            iaL();
            this.UKh.aq(false, true);
          }
          AppMethodBeat.o(293016);
          return;
          iao();
          AppMethodBeat.o(293016);
          return;
          if ((NetStatusUtil.isWifi(getActivity())) || (s.hXN()))
          {
            Log.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite use voice");
            iap();
            AppMethodBeat.o(293016);
            return;
          }
          com.tencent.mm.ui.base.k.a(getActivity(), b.g.voip_not_wifi_warnning_message, b.g.voip_not_wifi_warnning_title, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(292380);
              s.hXM();
              VoipVideoFragment.s(VoipVideoFragment.this);
              AppMethodBeat.o(292380);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(292378);
              VoipVideoFragment.this.iao();
              AppMethodBeat.o(292378);
            }
          });
          AppMethodBeat.o(293016);
          return;
          Log.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
          if ((NetStatusUtil.isWifi(getActivity())) || ((s.hXN()) && (!NetStatusUtil.is2G(getActivity()))))
          {
            iaq();
            AppMethodBeat.o(293016);
            return;
          }
          com.tencent.mm.ui.base.k.a(getActivity(), b.g.voip_not_wifi_warnning_message, b.g.voip_not_wifi_warnning_title, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(292373);
              if (!NetStatusUtil.is2G(VoipVideoFragment.this.getActivity())) {
                s.hXM();
              }
              VoipVideoFragment.t(VoipVideoFragment.this);
              AppMethodBeat.o(292373);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(292369);
              VoipVideoFragment.this.iao();
              AppMethodBeat.o(292369);
            }
          });
          AppMethodBeat.o(293016);
          return;
        } while ((this.UJb == null) || (this.UJb.get() == null));
        ((c)this.UJb.get()).hVZ();
        AppMethodBeat.o(293016);
        return;
        Log.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
      } while ((this.UJb == null) || (this.UJb.get() == null) || (!((c)this.UJb.get()).hVN()) || (this.UJb == null) || (this.UJb.get() == null) || (this.UKp == null));
      mE(b.g.voip_cancel_call, -1);
      this.UKp.iaC();
      AppMethodBeat.o(293016);
      return;
      Log.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
      iai();
    } while ((this.UJb == null) || (this.UJb.get() == null));
    ((c)this.UJb.get()).aL(null);
    AppMethodBeat.o(293016);
  }
  
  protected final void aDJ(String paramString)
  {
    AppMethodBeat.i(115433);
    if (this.UIg != null)
    {
      this.UIg.setVisibility(0);
      this.UIg.setText(paramString);
      this.UIf.sendAccessibilityEvent(128);
    }
    AppMethodBeat.o(115433);
  }
  
  public final void aqW(int paramInt)
  {
    AppMethodBeat.i(292951);
    super.aqW(paramInt);
    if ((paramInt == 0) || (paramInt == 180))
    {
      this.UKK.UNd = 0;
      this.UKJ.UNd = 0;
      AppMethodBeat.o(292951);
      return;
    }
    this.UKK.UNd = (360 - paramInt);
    this.UKJ.UNd = (360 - paramInt);
    AppMethodBeat.o(292951);
  }
  
  protected final int getLayoutId()
  {
    return b.e.voip_video_fragment2;
  }
  
  public final void iU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115428);
    super.iU(paramInt1, paramInt2);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + com.tencent.mm.plugin.voip.f.k.arg(paramInt2));
    if (this.thl == null)
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
        if ((af.lXY.lST == 1) && (paramInt1 != 0)) {
          this.UId.setVisibility(8);
        }
        AppMethodBeat.o(115428);
        return;
        ial();
        paramInt1 = 1;
        continue;
        paramInt1 = 0;
        iak();
        continue;
        ian();
        iam();
        paramInt1 = 1;
        continue;
        aqQ(paramInt1);
        paramInt1 = 1;
      }
      iau();
    }
  }
  
  public final void iaL()
  {
    AppMethodBeat.i(115444);
    if (!this.wUO)
    {
      AppMethodBeat.o(115444);
      return;
    }
    this.UKK.icj();
    this.UKJ.icj();
    AppMethodBeat.o(115444);
  }
  
  public final void iaP()
  {
    AppMethodBeat.i(115425);
    if ((this.UKK != null) && (this.UKJ != null))
    {
      if (!this.UIF) {
        break label119;
      }
      this.UKJ.setShowMode(0);
      if ((this.UII & 0x1) == 0) {
        break label108;
      }
      this.UKK.setShowMode(1);
    }
    for (;;)
    {
      Log.i("MicroMsg.Voip.VoipVideoFragment", "changeSurfaceRender, bigViewMode: %d, smallViewMode: %d,mIsSmallViewShowSelf:%b, after changeSurfaceRender", new Object[] { Integer.valueOf(this.UKK.Erd), Integer.valueOf(this.UKJ.Erd), Boolean.valueOf(this.UIF) });
      AppMethodBeat.o(115425);
      return;
      label108:
      this.UKK.setShowMode(0);
      continue;
      label119:
      this.UKK.setShowMode(0);
      if ((this.UII & 0x1) != 0) {
        this.UKJ.setShowMode(1);
      } else {
        this.UKJ.setShowMode(0);
      }
    }
  }
  
  protected final boolean iah()
  {
    return true;
  }
  
  protected final void iaj()
  {
    AppMethodBeat.i(115436);
    if (this.JQB != null)
    {
      this.JQB.clearAnimation();
      this.JQB.setVisibility(8);
    }
    AppMethodBeat.o(115436);
  }
  
  protected final void iao()
  {
    AppMethodBeat.i(292989);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "reject video invite");
    h.OAn.a(11526, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(4) });
    if ((this.UJb != null) && (this.UJb.get() != null) && (((c)this.UJb.get()).hVJ()) && (this.UKp != null))
    {
      mE(b.g.voip_reject_call, -1);
      this.UKp.iaE();
    }
    AppMethodBeat.o(292989);
  }
  
  protected final void mE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115434);
    if (this.UIf == null)
    {
      AppMethodBeat.o(115434);
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
    AppMethodBeat.o(115434);
  }
  
  public final void n(Point paramPoint)
  {
    AppMethodBeat.i(292943);
    OpenGlView localOpenGlView = this.UKH;
    Log.i(OpenGlView.TAG, "new size from resoureHelper w %s * h  %s", new Object[] { Integer.valueOf(com.tencent.mm.cd.a.ms(localOpenGlView.getContext())), Integer.valueOf(com.tencent.mm.cd.a.mt(localOpenGlView.getContext())) });
    int j = paramPoint.x;
    int i = paramPoint.y;
    localOpenGlView.UNL = j;
    localOpenGlView.UNM = i;
    if (aw.jkQ())
    {
      j = i * 9 / 16;
      paramPoint = new RelativeLayout.LayoutParams(j, i);
      paramPoint.addRule(13);
      localOpenGlView.UNL = j;
    }
    for (;;)
    {
      localOpenGlView.setLayoutParams(paramPoint);
      localOpenGlView.setLayoutParams(paramPoint);
      if (this.UKI != null)
      {
        paramPoint = (MovableVideoView)this.UKI;
        Log.i("MicroMsg.MovableVideoView", "refrsh view %s, %s", new Object[] { Integer.valueOf(paramPoint.mWidth), Integer.valueOf(paramPoint.UMD) });
        paramPoint.mScreenWidth = 0;
        paramPoint.mG(paramPoint.mWidth, paramPoint.UMD);
      }
      AppMethodBeat.o(292943);
      return;
      paramPoint = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(115421);
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.UKb = ((ImageView)this.thl.findViewById(b.d.voip_blur_avatar));
    this.UKc = ((ImageView)this.thl.findViewById(b.d.voip_transparent_blur));
    this.UKH = ((OpenGlView)this.thl.findViewById(b.d.big_video));
    this.UKH.mH(mScreenWidth, mScreenHeight);
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
    if (aw.jlc()) {
      iaK();
    }
    paramLayoutInflater = this.wUL;
    int i;
    int j;
    boolean bool;
    if ((this.thl == null) || (paramLayoutInflater == null))
    {
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
      paramLayoutInflater = (WindowManager)getActivity().getSystemService("window");
      i = paramLayoutInflater.getDefaultDisplay().getHeight() / 5;
      j = paramLayoutInflater.getDefaultDisplay().getWidth() * i / paramLayoutInflater.getDefaultDisplay().getHeight();
      this.UKI = new MovableVideoView(getActivity().getApplicationContext());
      ((MovableVideoView)this.UKI).mG(j, i);
      this.UKI.setVisibility(0);
      this.UKI.GR(true);
      this.UKJ = new OpenGlRender(this.UKI, OpenGlRender.RenderRemote);
      this.UKI.setRenderer(this.UKJ);
      this.UKI.setRenderMode(0);
      this.UKJ.UNB = new VoipVideoFragment.11(this);
      this.UKK = new OpenGlRender(this.UKH, OpenGlRender.RenderLocal);
      this.UKH.setRenderer(this.UKK);
      this.UKH.setRenderMode(0);
      this.UKH.setVisibility(0);
      this.UKK.UNB = new VoipVideoFragment.12(this);
      Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
      this.thl.addView(this.UKI);
      this.UKI.setOnClickListener(new VoipVideoFragment.13(this));
      if (this.Uxb) {
        this.qse.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(292417);
            if (VoipVideoFragment.this.UKl != null) {
              VoipVideoFragment.this.UKl.iav();
            }
            AppMethodBeat.o(292417);
          }
        }, 2000L);
      }
      this.UKL = ((VoIPVideoView)this.thl.findViewById(b.d.voip_talking_video_view));
      this.eln = new MTimerHandler(Looper.myLooper(), this.UKO, true);
      Log.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", new Object[] { Integer.valueOf(this.UIJ) });
      this.UKK.setVoipBeauty(this.UIJ);
      this.UKJ.setVoipBeauty(this.UIJ);
      this.UKK.setSpatiotemporalDenosing(this.UKN);
      this.UKJ.setSpatiotemporalDenosing(this.UKN);
      if ((this.UJb != null) && (this.UJb.get() != null))
      {
        paramLayoutInflater = (c)this.UJb.get();
        if ((260 == this.mStatus) || (6 == this.mStatus)) {
          break label1327;
        }
        bool = true;
        label990:
        paramLayoutInflater.bn(true, bool);
        this.UKK.UNz = true;
        this.UKJ.UNz = true;
      }
      this.wUO = true;
      i = this.UxE;
      j = this.UxF;
      Log.i("MicroMsg.Voip.VoipVideoFragment", "adjustHWViewAspectRatio, mInitDone:%b, HWDecsize:%dx%d,  lastHWDecsize:%dx%d", new Object[] { Boolean.valueOf(this.wUO), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.UxE), Integer.valueOf(this.UxF) });
      if ((i != 0) && (j != 0)) {
        break label1333;
      }
    }
    for (;;)
    {
      iU(0, this.mStatus);
      this.mUJ = ((PowerManager)MMApplicationContext.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipVideoFragment");
      paramLayoutInflater = this.mUJ;
      com.tencent.mm.hellhoundlib.a.a.b(paramLayoutInflater, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      paramLayoutInflater.acquire();
      com.tencent.mm.hellhoundlib.a.a.c(paramLayoutInflater, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      Log.i("MicroMsg.Voip.VoipVideoFragment", "acquire wakelock");
      paramLayoutInflater = this.thl;
      AppMethodBeat.o(115421);
      return paramLayoutInflater;
      if ((paramLayoutInflater.getParent() != null) && ((paramLayoutInflater.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.wUL.getParent()).removeView(this.wUL);
      }
      this.thl.removeView(this.wUL);
      this.wUL = null;
      if (paramLayoutInflater.getParent() != null) {
        ((ViewGroup)paramLayoutInflater.getParent()).removeAllViews();
      }
      this.wUL = paramLayoutInflater;
      this.thl.addView(paramLayoutInflater, new RelativeLayout.LayoutParams(1, 1));
      this.wUL.setVisibility(0);
      this.wUL.setAlpha(0.0F);
      Log.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView added");
      break;
      label1327:
      bool = false;
      break label990;
      label1333:
      if ((this.UxE != i) || (this.UxF != j))
      {
        this.UxE = i;
        this.UxF = j;
      }
      if (this.wUO)
      {
        this.UKK.iS(i, j);
        this.UKJ.iS(i, j);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115422);
    this.wXz = false;
    Log.i("MicroMsg.Voip.VoipVideoFragment", "onDestory");
    super.onDestroy();
    if ((this.mUJ != null) && (this.mUJ.isHeld()))
    {
      Log.i("MicroMsg.Voip.VoipVideoFragment", "release waklock");
      PowerManager.WakeLock localWakeLock = this.mUJ;
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
    AppMethodBeat.o(115453);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(115432);
    this.UKK.Qu();
    this.UKJ.Qu();
    super.onStart();
    AppMethodBeat.o(115432);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(115431);
    Log.i("MicroMsg.Voip.VoipVideoFragment", "onStop");
    this.UKK.ici();
    this.UKJ.ici();
    super.onStop();
    AppMethodBeat.o(115431);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115442);
    this.UII = paramInt;
    if ((this.UKI == null) || (this.UKI.UNN))
    {
      AppMethodBeat.o(115442);
      return;
    }
    Log.i("MicroMsg.Voip.VoipVideoFragment", "setHWDecMode, hwdec: %d, mIsSmallViewShowSelf:%b, before changeSurfaceRender", new Object[] { Integer.valueOf(this.UII), Boolean.valueOf(this.UIF) });
    iaP();
    AppMethodBeat.o(115442);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt) {}
  
  public final void uninit()
  {
    AppMethodBeat.i(115430);
    Log.printInfoStack("MicroMsg.Voip.VoipVideoFragment", "unit should not be allow in foreground", new Object[0]);
    if (this.UKI != null) {
      this.UKI.setVisibility(4);
    }
    if (this.wUL != null)
    {
      this.thl.removeView(this.wUL);
      this.wUL = null;
      Log.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView removed");
    }
    if (this.UKM != null)
    {
      this.UKM.cancel();
      this.UKM = null;
    }
    super.uninit();
    AppMethodBeat.o(115430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment
 * JD-Core Version:    0.7.0.1
 */