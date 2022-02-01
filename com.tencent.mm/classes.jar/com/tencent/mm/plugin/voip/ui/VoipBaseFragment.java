package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.e.a.c;
import com.tencent.mm.plugin.voip.f.k;
import com.tencent.mm.plugin.voip.f.m;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.widget.VoIPControlIconLayout;
import com.tencent.mm.plugin.voip.widget.VoIPFuncIconLayout;
import com.tencent.mm.plugin.voip.widget.VoipSmallIconButton;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ag;
import com.tencent.mm.ui.ag.a;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bh;
import java.lang.ref.WeakReference;
import kotlin.g.b.s;

public abstract class VoipBaseFragment
  extends Fragment
  implements com.tencent.mm.plugin.voip.e.a
{
  public static final int[] UKa = { -1, b.g.voip_one_dot, b.g.voip_two_dot, b.g.voip_three_dot };
  static int UKe = -1;
  protected static int mScreenHeight;
  protected static int mScreenWidth;
  protected TextView JQB;
  protected ImageView Ltg;
  protected boolean LvT = false;
  private Runnable Lwv = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(292387);
      if ((VoipBaseFragment.this.getActivity() == null) || (VoipBaseFragment.this.getActivity().isFinishing()))
      {
        AppMethodBeat.o(292387);
        return;
      }
      if (VoipBaseFragment.this.thl.findViewById(b.d.net_tip_layout) != null) {
        VoipBaseFragment.this.thl.findViewById(b.d.net_tip_layout).setOnClickListener(null);
      }
      VoipBaseFragment.this.LvT = false;
      VoipBaseFragment.this.JQB.setVisibility(8);
      VoipBaseFragment.this.Ltg.setVisibility(8);
      AppMethodBeat.o(292387);
    }
  };
  protected WeakReference<c> UJb;
  protected long UJc = -1L;
  protected ImageView UKb;
  protected ImageView UKc;
  protected int UKd = 4096;
  protected View UKf;
  protected View UKg;
  protected d UKh;
  private VoipBaseFragment.a UKi;
  private b UKj;
  private com.tencent.mm.ui.blur.f UKk;
  protected f UKl = new f();
  protected FrameLayout UKm;
  protected i UKn = new i(this);
  protected FrameLayout UKo;
  protected g UKp = new g(this);
  protected FrameLayout UKq;
  protected boolean Uxb;
  protected String luk;
  protected int mStatus = -1;
  protected MMHandler qse;
  protected RelativeLayout thl;
  
  protected static void bb(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin += paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  protected static String iY(long paramLong)
  {
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  protected abstract void GA(boolean paramBoolean);
  
  public void VV(int paramInt) {}
  
  public void VX(int paramInt) {}
  
  public void VY(int paramInt) {}
  
  public void a(a.c paramc, Bundle paramBundle)
  {
    switch (5.UIW[paramc.ordinal()])
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.UKn != null) {
                this.UKn.aqU(-1);
              }
              ag.a(getActivity().getTaskId(), new ag.a()
              {
                public final void fnV()
                {
                  AppMethodBeat.i(292384);
                  if (VoipBaseFragment.this.UKn != null) {
                    VoipBaseFragment.this.UKn.aqU(2);
                  }
                  AppMethodBeat.o(292384);
                }
                
                public final void fnW()
                {
                  AppMethodBeat.i(292388);
                  if (VoipBaseFragment.this.UKn != null) {
                    VoipBaseFragment.this.UKn.aqU(0);
                  }
                  AppMethodBeat.o(292388);
                }
              });
              return;
              com.tencent.mm.plugin.report.service.h.OAn.b(11618, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
            } while ((this.UJb == null) || (this.UJb.get() == null));
            ((c)this.UJb.get()).Gn(true);
            return;
          } while ((this.UJb == null) || (this.UJb.get() == null) || (paramBundle == null));
          bool = paramBundle.getBoolean("mute", false);
          ((c)this.UJb.get()).yN(bool);
          return;
        } while ((this.UJb == null) || (this.UJb.get() == null) || (paramBundle == null));
        boolean bool = paramBundle.getBoolean("speaker", false);
        ((c)this.UJb.get()).Gl(bool);
        return;
      } while ((this.UJb == null) || (this.UJb.get() == null));
      ((c)this.UJb.get()).hWi();
      return;
    } while ((this.UJb == null) || (this.UJb.get() == null) || (!((c)this.UJb.get()).hVH()));
    mE(b.g.voip_finish_call, -1);
  }
  
  public final void a(d paramd)
  {
    this.UKh = paramd;
  }
  
  protected abstract void aDJ(String paramString);
  
  final void abU(int paramInt)
  {
    if (this.JQB != null)
    {
      this.LvT = true;
      if (this.thl.findViewById(b.d.net_tip_layout) != null) {
        this.thl.findViewById(b.d.net_tip_layout).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(292396);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipBaseFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (VoipBaseFragment.this.thl.findViewById(b.d.net_tip_layout) != null) {
              ((c)VoipBaseFragment.this.UJb.get()).VW(2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipBaseFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(292396);
          }
        });
      }
      this.Ltg.setVisibility(0);
      this.JQB.setVisibility(0);
      this.JQB.setText(b.g.voip_auduo_auto_switch_to_mobile_net);
      this.qse.removeCallbacks(this.Lwv);
      this.qse.postDelayed(this.Lwv, paramInt * 1000);
    }
  }
  
  public void aqW(int paramInt) {}
  
  final void aqX(int paramInt)
  {
    SubCoreVoip.hVp();
    if (u.hYH())
    {
      this.Ltg.setVisibility(8);
      this.JQB.setVisibility(0);
      if (this.thl.findViewById(b.d.net_tip_layout) != null) {
        this.thl.findViewById(b.d.net_tip_layout).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(292382);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipBaseFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (VoipBaseFragment.this.thl.findViewById(b.d.net_tip_layout) != null) {
              ((c)VoipBaseFragment.this.UJb.get()).VW(1);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipBaseFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(292382);
          }
        });
      }
      this.JQB.setText(b.g.voip_audio_network_data_cost_max);
      this.qse.removeCallbacks(this.Lwv);
      this.qse.postDelayed(this.Lwv, paramInt * 1000);
    }
  }
  
  public void fwq() {}
  
  final void fws()
  {
    if (this.UKn != null)
    {
      i locali = this.UKn;
      com.tencent.mm.plugin.ringtone.c localc = com.tencent.mm.plugin.ringtone.c.OBr;
      com.tencent.mm.plugin.ringtone.c.gOe().j((q)locali.UJy);
    }
  }
  
  protected int getLayoutId()
  {
    return 0;
  }
  
  public void iU(int paramInt1, int paramInt2)
  {
    Log.printInfoStack("MicroMsg.VoipBaseFragment", "newState: " + k.arg(paramInt2) + ", action: " + k.arg(paramInt1) + ", lastStatus: " + k.arg(UKe), new Object[0]);
    if ((UKe != this.mStatus) && (paramInt2 != this.mStatus)) {
      UKe = this.mStatus;
    }
    this.UKd = paramInt1;
    this.mStatus = paramInt2;
  }
  
  protected final void iaK()
  {
    bh.mN(getActivity());
    if ((aw.jkS()) || (aj.aAy(getActivity().getTaskId()))) {
      if (aw.aAj(getActivity().getTaskId()))
      {
        i = 2;
        if (this.UKn != null) {
          this.UKn.aqU(i);
        }
      }
    }
    while (this.UKn == null) {
      for (;;)
      {
        return;
        int i = 0;
      }
    }
    this.UKn.iaJ();
  }
  
  @Deprecated
  public void iaL() {}
  
  protected final void iaM()
  {
    if ((this.luk == null) || (this.UKb.getVisibility() == 0)) {
      return;
    }
    this.UKb.setVisibility(0);
    this.UKi = new VoipBaseFragment.a(this);
    com.tencent.threadpool.h.ahAA.bm(this.UKi);
  }
  
  protected final void iaN()
  {
    this.UKc.setVisibility(0);
    this.UKj = new b();
    com.tencent.threadpool.h.ahAA.bm(this.UKj);
  }
  
  protected final String iaO()
  {
    long l = Util.secondsToNow(this.UJc);
    return String.format(MMApplicationContext.getString(b.g.voip_time_desc), new Object[] { Long.valueOf(l / 60L), Long.valueOf(l % 60L) });
  }
  
  protected boolean iah()
  {
    return false;
  }
  
  protected abstract void iaj();
  
  protected abstract void mE(int paramInt1, int paramInt2);
  
  public abstract void n(Point paramPoint);
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (Build.VERSION.SDK_INT < 23)
    {
      if (mScreenWidth == 0)
      {
        paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
        mScreenWidth = paramActivity.getWidth();
        mScreenHeight = paramActivity.getHeight();
      }
      return;
    }
    paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getRealMetrics(localDisplayMetrics);
    mScreenWidth = localDisplayMetrics.widthPixels;
    mScreenHeight = localDisplayMetrics.heightPixels;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    this.luk = paramBundle.getString("key_username");
    this.Uxb = paramBundle.getBoolean("key_isoutcall");
    if (-1 == this.mStatus) {
      this.mStatus = paramBundle.getInt("key_status");
    }
    this.qse = new MMHandler();
    this.UKk = new com.tencent.mm.ui.blur.f(getContext());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Object localObject2 = null;
    this.thl = ((RelativeLayout)paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false));
    this.UKf = this.thl.findViewById(b.d.top_bar_shader);
    this.UKg = this.thl.findViewById(b.d.bottom_bar_shader);
    this.UKm = ((FrameLayout)this.thl.findViewById(b.d.avatar_content_layout));
    if (this.UKm != null)
    {
      this.UKm.removeAllViews();
      if (this.UKl != null) {
        this.UKl.a(getContext(), this.UKm, this.luk, iah());
      }
    }
    this.UKo = ((FrameLayout)this.thl.findViewById(b.d.top_control_layout));
    if (this.UKo != null)
    {
      this.UKo.removeAllViews();
      if (this.UKn != null) {
        this.UKn.a(getContext(), this.UKo, this.luk, this.Uxb);
      }
    }
    iaK();
    this.UKq = ((FrameLayout)this.thl.findViewById(b.d.bottom_control_layout));
    g localg;
    Object localObject3;
    label343:
    h localh;
    Context localContext;
    if (this.UKq != null)
    {
      this.UKq.removeAllViews();
      if (this.UKp != null)
      {
        localg = this.UKp;
        localObject1 = getContext();
        localObject3 = this.UKq;
        boolean bool = iah();
        s.u(localObject1, "context");
        s.u(localObject3, "rootView");
        if (!bool) {
          break label868;
        }
        localObject1 = LayoutInflater.from((Context)localObject1).inflate(b.e.layout_voip_bottom_ui_video, (ViewGroup)localObject3);
        localg.UJD = ((View)localObject1);
        localObject3 = localg.UJD;
        if (localObject3 != null)
        {
          if (m.RW("VOIPBlockIgnoreButton") != 0) {
            break label889;
          }
          localg.UJz = ((VoipSmallIconButton)((View)localObject3).findViewById(b.d.voip_ignore_voice_invite));
          localObject1 = localg.UJz;
          if (localObject1 != null) {
            ((VoipSmallIconButton)localObject1).setOnClickListener(localg.UIQ);
          }
          localg.UJA = ((VoIPFuncIconLayout)((View)localObject3).findViewById(b.d.voip_video_switch_to_voice));
          localObject1 = localg.UJA;
          if (localObject1 != null) {
            ((VoIPFuncIconLayout)localObject1).setOnClickListener(localg.UJK);
          }
          localg.UJG = ((FrameLayout)((View)localObject3).findViewById(b.d.voip_main_control_layout));
          localObject1 = localg.UJG;
          if (localObject1 != null)
          {
            localh = localg.UJF;
            if (localh != null)
            {
              localContext = ((View)localObject3).getContext();
              s.s(localContext, "it.context");
              s.u(localContext, "context");
              s.u(localObject1, "rootView");
              if (!bool) {
                break label911;
              }
              localObject1 = LayoutInflater.from(localContext).inflate(b.e.layout_voip_main_func_btn_video, (ViewGroup)localObject1);
              label475:
              localh.UJU = ((View)localObject1);
              localObject1 = localh.UJU;
              if (localObject1 != null) {
                break label932;
              }
              localObject1 = null;
              label497:
              localh.UJP = ((VoIPFuncIconLayout)localObject1);
              localObject1 = localh.UJP;
              if (localObject1 != null) {
                ((VoIPFuncIconLayout)localObject1).setOnClickListener((View.OnClickListener)localh);
              }
              localObject1 = localh.UJU;
              if (localObject1 != null) {
                break label948;
              }
              localObject1 = null;
              label541:
              localh.UJQ = ((VoIPFuncIconLayout)localObject1);
              localObject1 = localh.UJQ;
              if (localObject1 != null) {
                ((VoIPFuncIconLayout)localObject1).setOnClickListener((View.OnClickListener)localh);
              }
              localObject1 = localh.UJU;
              if (localObject1 != null) {
                break label964;
              }
              localObject1 = null;
              label585:
              localh.UJR = ((VoIPFuncIconLayout)localObject1);
              localObject1 = localh.UJR;
              if (localObject1 != null) {
                ((VoIPFuncIconLayout)localObject1).setOnClickListener((View.OnClickListener)localh);
              }
              localObject1 = localh.UJU;
              if (localObject1 != null) {
                break label980;
              }
              localObject1 = null;
              label629:
              localh.UJS = ((VoIPFuncIconLayout)localObject1);
              localObject1 = localh.UJS;
              if (localObject1 != null) {
                ((VoIPFuncIconLayout)localObject1).setOnClickListener((View.OnClickListener)localh);
              }
              localObject1 = localh.UJU;
              if (localObject1 != null) {
                break label996;
              }
            }
          }
        }
      }
    }
    label868:
    label996:
    for (Object localObject1 = localObject2;; localObject1 = (VoIPFuncIconLayout)((View)localObject1).findViewById(b.d.voip_accept_use_voice))
    {
      localh.UJT = ((VoIPFuncIconLayout)localObject1);
      localObject1 = localh.UJT;
      if (localObject1 != null) {
        ((VoIPFuncIconLayout)localObject1).setOnClickListener((View.OnClickListener)localh);
      }
      localg.UJH = ((VoIPControlIconLayout)((View)localObject3).findViewById(b.d.voip_speaker_switcher_container));
      localObject1 = localg.UJH;
      if (localObject1 != null) {
        ((VoIPControlIconLayout)localObject1).setOnClickListener(localg.UJN);
      }
      localg.UJI = ((VoIPControlIconLayout)((View)localObject3).findViewById(b.d.voip_mic_switcher_container));
      localObject1 = localg.UJI;
      if (localObject1 != null) {
        ((VoIPControlIconLayout)localObject1).setOnClickListener(localg.UJM);
      }
      localg.UJC = ((VoIPFuncIconLayout)((View)localObject3).findViewById(b.d.voip_switch_voice));
      localObject1 = localg.UJC;
      if (localObject1 != null) {
        ((VoIPFuncIconLayout)localObject1).setOnClickListener(localg.UJL);
      }
      localg.UJB = ((VoIPFuncIconLayout)((View)localObject3).findViewById(b.d.voip_switch_camera));
      localObject1 = localg.UJB;
      if (localObject1 != null) {
        ((VoIPFuncIconLayout)localObject1).setOnClickListener(localg.UJJ);
      }
      localg.iaH();
      return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      localObject1 = LayoutInflater.from((Context)localObject1).inflate(b.e.layout_voip_bottom_ui, (ViewGroup)localObject3);
      break;
      label889:
      localObject1 = localg.UJz;
      if (localObject1 == null) {
        break label343;
      }
      ((VoipSmallIconButton)localObject1).setVisibility(8);
      break label343;
      localObject1 = LayoutInflater.from(localContext).inflate(b.e.layout_voip_main_func_btn, (ViewGroup)localObject1);
      break label475;
      localObject1 = (VoIPFuncIconLayout)((View)localObject1).findViewById(b.d.voip_cancel);
      break label497;
      localObject1 = (VoIPFuncIconLayout)((View)localObject1).findViewById(b.d.voip_reject);
      break label541;
      localObject1 = (VoIPFuncIconLayout)((View)localObject1).findViewById(b.d.voip_hangup);
      break label585;
      localObject1 = (VoIPFuncIconLayout)((View)localObject1).findViewById(b.d.voip_accept);
      break label629;
    }
  }
  
  public void onDestroy()
  {
    this.UKk.destroy();
    super.onDestroy();
  }
  
  public void onDetach()
  {
    if (this.qse != null) {
      this.qse.removeCallbacksAndMessages(null);
    }
    this.UKh = null;
    super.onDetach();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  @Deprecated
  public void setHWDecMode(int paramInt) {}
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setVoicePlayDevice(int paramInt);
  
  public final void setVoipUIListener(c paramc)
  {
    this.UJb = new WeakReference(paramc);
  }
  
  public void uninit()
  {
    Log.d("MicroMsg.VoipBaseFragment", "uninit");
    if (this.UKi != null)
    {
      this.UKi.cancel();
      this.UKi = null;
    }
    if (this.UKj != null)
    {
      this.UKj.cancel();
      this.UKj = null;
    }
    this.UKp = null;
    this.UKn = null;
    if (this.UKl != null)
    {
      Object localObject = this.UKl;
      ((f)localObject).UJu.hVz();
      localObject = ((f)localObject).UJu;
      Log.d("MicroMsg.DynamicTextWrap", "uninit");
      ((c)localObject).hVz();
      ((c)localObject).eln = null;
      this.UKl = null;
    }
  }
  
  public final void wU(long paramLong)
  {
    this.UJc = paramLong;
  }
  
  public final class b
    extends com.tencent.threadpool.i.b
  {
    public b() {}
    
    public final String getKey()
    {
      return "VoipBaseFragment_blurtransparentbitmap";
    }
    
    public final void run()
    {
      AppMethodBeat.i(115369);
      Log.i("MicroMsg.VoipBaseFragment", "try create blur bitmap,timestamp: " + System.currentTimeMillis());
      final Bitmap localBitmap = BitmapUtil.getBitmapNative(b.c.voip_video_called_blur_background);
      Log.i("MicroMsg.VoipBaseFragment", "blur transparent ok, timestamp: " + System.currentTimeMillis());
      VoipBaseFragment.this.qse.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115368);
          if (VoipBaseFragment.this.UKc != null)
          {
            VoipBaseFragment.this.UKc.setBackgroundDrawable(new BitmapDrawable(localBitmap));
            VoipBaseFragment.this.UKc.getBackground().setAlpha(230);
            VoipBaseFragment.this.UKc.getBackground().setFilterBitmap(true);
          }
          VoipBaseFragment.b(VoipBaseFragment.this);
          AppMethodBeat.o(115368);
        }
      });
      AppMethodBeat.o(115369);
    }
  }
  
  public static final class c
  {
    int[] UKv;
    private int Uvy;
    int Uvz;
    MTimerHandler eln;
    TextView sQ;
    
    public c()
    {
      AppMethodBeat.i(115371);
      this.eln = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(115370);
          int i = VoipBaseFragment.c.this.UKv[(VoipBaseFragment.c.this.Uvz % VoipBaseFragment.c.this.UKv.length)];
          if (VoipBaseFragment.c.this.sQ != null)
          {
            if (-1 != i) {
              break label78;
            }
            VoipBaseFragment.c.this.sQ.setText(null);
          }
          for (;;)
          {
            VoipBaseFragment.c localc = VoipBaseFragment.c.this;
            localc.Uvz += 1;
            AppMethodBeat.o(115370);
            return true;
            label78:
            VoipBaseFragment.c.this.sQ.setText(i);
          }
        }
      }, true);
      AppMethodBeat.o(115371);
    }
    
    public final void a(TextView paramTextView, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(115372);
      if ((paramArrayOfInt == null) || (paramTextView == null))
      {
        Log.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
        AppMethodBeat.o(115372);
        return;
      }
      hVz();
      this.Uvz = 0;
      this.UKv = paramArrayOfInt;
      this.sQ = paramTextView;
      this.Uvy = 500;
      if (this.eln != null) {
        this.eln.startTimer(this.Uvy);
      }
      Log.printDebugStack("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(paramTextView)), new Object[0]);
      AppMethodBeat.o(115372);
    }
    
    public final void hVz()
    {
      AppMethodBeat.i(115373);
      if (this.eln != null) {
        this.eln.stopTimer();
      }
      Log.printDebugStack("MicroMsg.DynamicTextWrap", "stop textview: " + this.sQ, new Object[0]);
      this.sQ = null;
      AppMethodBeat.o(115373);
    }
  }
  
  public static abstract interface d
  {
    public abstract void aq(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment
 * JD-Core Version:    0.7.0.1
 */