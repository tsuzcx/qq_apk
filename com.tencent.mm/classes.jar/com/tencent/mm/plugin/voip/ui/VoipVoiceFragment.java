package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class VoipVoiceFragment
  extends VoipBaseFragment
{
  private int GUk;
  private boolean HdH;
  private View.OnClickListener HdZ;
  private Button Hdb;
  private WeImageView Hdc;
  private TextView Hdr;
  private View.OnClickListener Hea;
  private View HfE;
  private ImageView HfF;
  private TextView HfG;
  private TextView HfH;
  private TextView HfI;
  private TextView HfJ;
  private TextView HfK;
  private View HfL;
  private RelativeLayout HfM;
  private MMCheckBox HfN;
  private TextView HfO;
  private RelativeLayout HfP;
  private MMCheckBox HfQ;
  private TextView HfR;
  private TextView HfS;
  private TextView HfT;
  private VoipBigIconButton HfU;
  private VoipBigIconButton HfV;
  private VoipBigIconButton HfW;
  private VoipBigIconButton HfX;
  private VoipSmallIconButton HfY;
  private ImageView HfZ;
  private boolean Hga;
  private boolean Hgb;
  private View.OnClickListener Hgc;
  private View.OnClickListener Hgd;
  private View.OnClickListener Hge;
  private View.OnClickListener Hgf;
  private View.OnClickListener Hgg;
  private View.OnClickListener Hgh;
  private Runnable Hgi;
  private boolean mIsMute;
  private Timer mTimer;
  private boolean qvo;
  private Runnable rtb;
  private TextView yzB;
  
  public VoipVoiceFragment()
  {
    AppMethodBeat.i(115474);
    this.GUk = 1;
    this.mIsMute = false;
    this.qvo = false;
    this.HdH = false;
    this.Hga = false;
    this.Hgb = false;
    this.HdZ = new VoipVoiceFragment.6(this);
    this.Hea = new VoipVoiceFragment.7(this);
    this.Hgc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115468);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        boolean bool = VoipVoiceFragment.b(VoipVoiceFragment.this).isChecked();
        Log.i("MicroMsg.VoipVoiceFragment", "onSpeakerClick, status: %b", new Object[] { Boolean.valueOf(bool) });
        VoipVoiceFragment.b(VoipVoiceFragment.this).setEnabled(false);
        if ((VoipVoiceFragment.this.Hen != null) && (VoipVoiceFragment.this.Hen.get() != null)) {
          ((c)VoipVoiceFragment.this.Hen.get()).wU(bool);
        }
        paramAnonymousView = VoipVoiceFragment.this;
        if (bool) {}
        for (int i = 1;; i = 2)
        {
          VoipVoiceFragment.a(paramAnonymousView, i);
          VoipVoiceFragment.b(VoipVoiceFragment.this).setEnabled(true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115468);
          return;
        }
      }
    };
    this.Hgd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115469);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        boolean bool = VoipVoiceFragment.c(VoipVoiceFragment.this).isChecked();
        Log.i("MicroMsg.VoipVoiceFragment", "onMicClick, status: %b", new Object[] { Boolean.valueOf(bool) });
        VoipVoiceFragment.c(VoipVoiceFragment.this).setEnabled(false);
        if ((VoipVoiceFragment.this.Hen != null) && (VoipVoiceFragment.this.Hen.get() != null)) {
          ((c)VoipVoiceFragment.this.Hen.get()).rv(bool);
        }
        VoipVoiceFragment.a(VoipVoiceFragment.this, bool);
        VoipVoiceFragment.c(VoipVoiceFragment.this).setEnabled(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115469);
      }
    };
    this.Hge = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115470);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.VoipVoiceFragment", "click accept voice invite button");
        h.CyF.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHU()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHV()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fGu()), Integer.valueOf(2) });
        if ((VoipVoiceFragment.this.Hen != null) && (VoipVoiceFragment.this.Hen.get() != null) && (((c)VoipVoiceFragment.this.Hen.get()).fFz()))
        {
          VoipVoiceFragment.d(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.e(VoipVoiceFragment.this).setText(2131767390);
          VoipVoiceFragment.this.HeH.a(VoipVoiceFragment.f(VoipVoiceFragment.this), VoipBaseFragment.HeB);
          VoipVoiceFragment.g(VoipVoiceFragment.this).setVisibility(0);
          VoipVoiceFragment.h(VoipVoiceFragment.this).setVisibility(8);
          VoipVoiceFragment.d(VoipVoiceFragment.this).setVisibility(8);
          VoipVoiceFragment.i(VoipVoiceFragment.this).setVisibility(8);
          VoipVoiceFragment.j(VoipVoiceFragment.this).setVisibility(0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115470);
      }
    };
    this.Hgf = new VoipVoiceFragment.11(this);
    this.Hgg = new VoipVoiceFragment.12(this);
    this.Hgh = new VoipVoiceFragment.13(this);
    this.rtb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235812);
        if ((VoipVoiceFragment.this.getActivity() == null) || (VoipVoiceFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(235812);
          return;
        }
        VoipVoiceFragment.l(VoipVoiceFragment.this).setVisibility(8);
        AppMethodBeat.o(235812);
      }
    };
    this.Hgi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235813);
        if ((VoipVoiceFragment.this.getActivity() == null) || (VoipVoiceFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(235813);
          return;
        }
        if (VoipVoiceFragment.this.ncd.findViewById(2131305270) != null) {
          VoipVoiceFragment.this.ncd.findViewById(2131305270).setOnClickListener(null);
        }
        VoipVoiceFragment.m(VoipVoiceFragment.this);
        VoipVoiceFragment.n(VoipVoiceFragment.this).setVisibility(8);
        VoipVoiceFragment.o(VoipVoiceFragment.this).setVisibility(8);
        AppMethodBeat.o(235813);
      }
    };
    AppMethodBeat.o(115474);
  }
  
  private void adC(int paramInt)
  {
    AppMethodBeat.i(115480);
    this.HfE.setVisibility(0);
    this.HfI.setVisibility(8);
    this.HfJ.setText(2131767313);
    this.HeH.a(this.HfK, HeB);
    this.HfL.setVisibility(0);
    if (this.HfH != null)
    {
      if ((!as.bjp(this.goe)) || (Util.isNullOrNil(this.HfH.getText()))) {
        break label278;
      }
      this.HfH.setVisibility(0);
    }
    for (;;)
    {
      this.HfU.setVisibility(8);
      this.HfV.setVisibility(8);
      this.HfW.setVisibility(8);
      this.HfX.setVisibility(0);
      this.HfY.setVisibility(8);
      this.HfP.setVisibility(0);
      this.HfQ.setEnabled(false);
      this.HfQ.setBackgroundResource(2131235562);
      this.HfR.setTextColor(1728053247);
      fJJ();
      this.HfQ.setChecked(this.mIsMute);
      this.HfM.setVisibility(0);
      if ((paramInt != 4097) && (2 == this.GUk)) {
        jE(2131767227, 10000);
      }
      fJz();
      this.HfT.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.fFg().GUy != null)
      {
        this.HfT.setVisibility(0);
        this.HfT.setText(com.tencent.mm.plugin.voip.c.fFg().GUy);
      }
      if (HeF == 2) {
        this.Hga = true;
      }
      AppMethodBeat.o(115480);
      return;
      label278:
      this.HfH.setVisibility(8);
    }
  }
  
  private void bpu()
  {
    AppMethodBeat.i(115491);
    if ((this.mTimer == null) || (this.qvo))
    {
      AppMethodBeat.o(115491);
      return;
    }
    if (-1L == this.Heo) {
      this.Heo = Util.nowSecond();
    }
    this.qvo = true;
    TimerTask local5 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(235815);
        VoipVoiceFragment.this.kAn.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(235814);
            String str = VoipVoiceFragment.AF(Util.secondsToNow(VoipVoiceFragment.this.Heo));
            VoipVoiceFragment.h(VoipVoiceFragment.this).setText(str);
            VoipVoiceFragment.p(VoipVoiceFragment.this);
            AppMethodBeat.o(235814);
          }
        });
        AppMethodBeat.o(235815);
      }
    };
    this.mTimer.schedule(local5, 50L, 1000L);
    AppMethodBeat.o(115491);
  }
  
  private void fJE()
  {
    AppMethodBeat.i(115481);
    this.HfJ.setText(2131767390);
    this.HeH.a(this.HfK, HeB);
    this.HfU.setVisibility(8);
    this.HfV.setVisibility(8);
    this.HfW.setVisibility(0);
    this.HfX.setVisibility(8);
    this.HfY.setVisibility(8);
    AppMethodBeat.o(115481);
  }
  
  private void fJF()
  {
    AppMethodBeat.i(115482);
    this.HeH.fJB();
    this.HfW.setEnabled(false);
    this.HfX.setEnabled(false);
    this.HfU.setEnabled(false);
    this.HfV.setEnabled(false);
    this.HfY.setEnabled(false);
    AppMethodBeat.o(115482);
  }
  
  private void fJG()
  {
    AppMethodBeat.i(115483);
    this.HfE.setVisibility(0);
    this.HfL.setVisibility(0);
    this.HfJ.setText(2131767314);
    this.HeH.a(this.HfK, HeB);
    if (this.HfH != null)
    {
      if ((!as.bjp(this.goe)) || (Util.isNullOrNil(this.HfH.getText()))) {
        break label211;
      }
      this.HfH.setVisibility(0);
    }
    for (;;)
    {
      fJJ();
      this.HfU.setVisibility(0);
      this.HfV.setVisibility(0);
      this.HfW.setVisibility(8);
      this.HfX.setVisibility(8);
      if (this.HdH) {
        this.HfY.setVisibility(0);
      }
      if (HeF == 256)
      {
        this.Hga = true;
        jE(2131767228, 10000);
      }
      fJz();
      this.HfT.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.fFg().GUy != null)
      {
        this.HfT.setVisibility(0);
        this.HfT.setText(com.tencent.mm.plugin.voip.c.fFg().GUy);
      }
      AppMethodBeat.o(115483);
      return;
      label211:
      this.HfH.setVisibility(8);
    }
  }
  
  private void fJH()
  {
    AppMethodBeat.i(115484);
    this.HfE.setVisibility(0);
    this.HfL.setVisibility(0);
    this.HfJ.setText(2131767390);
    this.HeH.a(this.HfK, HeB);
    this.HfU.setVisibility(8);
    this.HfV.setVisibility(8);
    this.HfW.setVisibility(0);
    this.HfX.setVisibility(8);
    this.HfY.setVisibility(8);
    jE(2131767227, 10000);
    fJz();
    AppMethodBeat.o(115484);
  }
  
  private void fJI()
  {
    AppMethodBeat.i(115485);
    this.HfX.setVisibility(8);
    this.HfU.setVisibility(8);
    this.HfV.setVisibility(8);
    this.HfY.setVisibility(8);
    this.HfL.setVisibility(8);
    this.HeH.fJB();
    this.HfW.setVisibility(0);
    this.HfI.setVisibility(0);
    this.HfP.setVisibility(0);
    this.HfM.setVisibility(0);
    this.HfE.setVisibility(0);
    this.Hdb.setVisibility(0);
    this.HfQ.setEnabled(true);
    this.HfQ.setBackgroundResource(2131235551);
    this.HfR.setTextColor(-1);
    fJJ();
    this.HfQ.setChecked(this.mIsMute);
    if (!this.Hga) {
      jE(2131767220, 10000);
    }
    for (;;)
    {
      if (ac.jPp) {
        this.Hdr.setVisibility(0);
      }
      fJz();
      bpu();
      this.HfT.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.fFg().GUy != null)
      {
        this.HfT.setVisibility(0);
        this.HfT.setText(com.tencent.mm.plugin.voip.c.fFg().GUy);
      }
      AppMethodBeat.o(115485);
      return;
      if (2 == this.GUk) {
        jE(2131767222, 10000);
      } else if (3 == this.GUk) {
        jE(2131767221, 10000);
      }
    }
  }
  
  private void fJJ()
  {
    AppMethodBeat.i(115493);
    if ((this.HfN == null) || (this.HfO == null))
    {
      Log.e("MicroMsg.VoipVoiceFragment", "speaker is null");
      AppMethodBeat.o(115493);
      return;
    }
    if ((4 == this.GUk) || (3 == this.GUk))
    {
      this.HfN.setEnabled(false);
      this.HfO.setTextColor(1728053247);
      this.HfN.setBackgroundResource(2131235548);
      Log.i("MicroMsg.VoipVoiceFragment", "updateSpeakerStatus, disable mCbVoiceSpeakerSwitcher");
      AppMethodBeat.o(115493);
      return;
    }
    if (this.GUk == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.HfN.setBackgroundResource(2131235552);
      this.HfN.setEnabled(true);
      this.HfO.setTextColor(-1);
      this.HfN.setChecked(bool);
      Log.i("MicroMsg.VoipVoiceFragment", "updateSpeakerStatus, set mCbVoiceSpeakerSwitcher isChecked:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(115493);
      return;
    }
  }
  
  private void fJs()
  {
    AppMethodBeat.i(115479);
    this.HfE.setVisibility(0);
    this.HfI.setVisibility(8);
    this.HfJ.setText(2131767343);
    this.HeH.a(this.HfK, HeB);
    this.HfL.setVisibility(0);
    this.HfU.setVisibility(8);
    this.HfV.setVisibility(8);
    this.HfW.setVisibility(8);
    this.HfX.setVisibility(0);
    this.HfY.setVisibility(8);
    this.HfP.setVisibility(0);
    this.HfQ.setEnabled(false);
    this.HfQ.setBackgroundResource(2131235562);
    this.HfR.setTextColor(1728053247);
    this.HfT.setVisibility(8);
    if (com.tencent.mm.plugin.voip.c.fFg().GUy != null)
    {
      this.HfT.setVisibility(0);
      this.HfT.setText(com.tencent.mm.plugin.voip.c.fFg().GUy);
    }
    fJJ();
    this.HfQ.setChecked(this.mIsMute);
    this.HfM.setVisibility(0);
    if (2 == this.GUk) {
      jE(2131767227, 10000);
    }
    fJz();
    AppMethodBeat.o(115479);
  }
  
  protected final void aUB(String paramString)
  {
    AppMethodBeat.i(115486);
    if (this.HfT != null)
    {
      this.HfT.setVisibility(0);
      this.HfT.setText(paramString);
    }
    AppMethodBeat.o(115486);
  }
  
  public final void adB(int paramInt)
  {
    AppMethodBeat.i(235817);
    if (this.yzB != null)
    {
      this.Hgb = true;
      if (this.ncd.findViewById(2131305270) != null) {
        this.ncd.findViewById(2131305270).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(235811);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (VoipVoiceFragment.this.ncd.findViewById(2131305270) != null) {
              ((c)VoipVoiceFragment.this.Hen.get()).fFL();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(235811);
          }
        });
      }
      this.HfZ.setVisibility(0);
      this.yzB.setVisibility(0);
      this.yzB.setText(2131767230);
      this.kAn.removeCallbacks(this.Hgi);
      this.kAn.postDelayed(this.Hgi, paramInt * 1000);
    }
    AppMethodBeat.o(235817);
  }
  
  protected final void fJq()
  {
    AppMethodBeat.i(115489);
    if (this.yzB != null)
    {
      this.yzB.clearAnimation();
      this.yzB.setVisibility(8);
    }
    AppMethodBeat.o(115489);
  }
  
  public final void jD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115477);
    super.jD(paramInt1, paramInt2);
    Log.i("MicroMsg.VoipVoiceFragment", "newState: " + k.adM(paramInt2) + ", action: " + k.adM(paramInt1) + ", lastStatus: " + k.adM(HeF) + ", isSwitchFromVideo: " + this.Hga);
    if (this.ncd == null)
    {
      Log.i("MicroMsg.VoipVoiceFragment", "fragment no create, return first, onCreateView will call it again");
      AppMethodBeat.o(115477);
      return;
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(115477);
      return;
      fJs();
      AppMethodBeat.o(115477);
      return;
      adC(paramInt1);
      AppMethodBeat.o(115477);
      return;
      fJE();
      AppMethodBeat.o(115477);
      return;
      fJI();
      AppMethodBeat.o(115477);
      return;
      fJF();
      AppMethodBeat.o(115477);
      return;
      fJG();
      AppMethodBeat.o(115477);
      return;
      fJH();
    }
  }
  
  protected final void jE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115487);
    if (this.HfS == null)
    {
      AppMethodBeat.o(115487);
      return;
    }
    this.HfS.setText(paramInt1);
    this.HfS.setVisibility(0);
    this.HfS.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.HfS.setBackgroundResource(2131235553);
    this.HfS.setCompoundDrawables(null, null, null, null);
    this.HfS.setCompoundDrawablePadding(0);
    this.kAn.removeCallbacks(this.rtb);
    if (-1 != paramInt2) {
      this.kAn.postDelayed(this.rtb, paramInt2);
    }
    AppMethodBeat.o(115487);
  }
  
  public final void m(Point paramPoint) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(115476);
    paramBundle = new DisplayMetrics();
    ((WindowManager)paramLayoutInflater.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(paramBundle);
    Log.i("MicroMsg.VoipVoiceFragment", "dpi: " + paramBundle.heightPixels / paramBundle.density);
    boolean bool;
    if (paramBundle.heightPixels / paramBundle.density <= 540.0F)
    {
      this.ncd = ((RelativeLayout)paramLayoutInflater.inflate(2131496865, paramViewGroup, false));
      this.HeC = ((ImageView)this.ncd.findViewById(2131310016));
      this.HfE = this.ncd.findViewById(2131310067);
      this.HfF = ((ImageView)this.ncd.findViewById(2131310081));
      a.b.a(this.HfF, this.goe, 0.0375F, true);
      this.HfG = ((TextView)this.ncd.findViewById(2131310082));
      this.HfG.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getActivity(), aa.getDisplayName(this.goe), this.HfG.getTextSize()));
      this.HfH = ((TextView)this.ncd.findViewById(2131310084));
      this.HfI = ((TextView)this.ncd.findViewById(2131310089));
      this.HfJ = ((TextView)this.ncd.findViewById(2131310071));
      this.HfK = ((TextView)this.ncd.findViewById(2131310073));
      this.HfL = this.ncd.findViewById(2131310072);
      this.HfS = ((TextView)this.ncd.findViewById(2131310068));
      this.HfT = ((TextView)this.ncd.findViewById(2131310085));
      this.yzB = ((TextView)this.ncd.findViewById(2131310041));
      this.HfZ = ((ImageView)this.ncd.findViewById(2131303214));
      this.HfZ.setImageDrawable(ar.m(MMApplicationContext.getContext(), 2131690481, -1));
      z(this.HfK);
      if (ac.jPp) {
        this.Hdr = ((TextView)this.ncd.findViewById(2131300129));
      }
      this.HfP = ((RelativeLayout)this.ncd.findViewById(2131310075));
      this.HfQ = ((MMCheckBox)this.ncd.findViewById(2131310074));
      this.HfQ.setChecked(this.mIsMute);
      this.HfR = ((TextView)this.ncd.findViewById(2131310076));
      this.HfR.setText(2131767325);
      this.HfM = ((RelativeLayout)this.ncd.findViewById(2131310087));
      this.HfN = ((MMCheckBox)this.ncd.findViewById(2131310086));
      this.HfO = ((TextView)this.ncd.findViewById(2131310088));
      this.HfO.setText(2131767360);
      fJJ();
      this.HfU = ((VoipBigIconButton)this.ncd.findViewById(2131310066));
      this.HfU.setOnClickListener(this.Hge);
      this.HfV = ((VoipBigIconButton)this.ncd.findViewById(2131310080));
      this.HfV.setOnClickListener(this.Hgf);
      this.HfW = ((VoipBigIconButton)this.ncd.findViewById(2131310070));
      this.HfW.setOnClickListener(this.Hgg);
      this.HfX = ((VoipBigIconButton)this.ncd.findViewById(2131310069));
      this.HfX.setOnClickListener(this.Hgh);
      if (m.Se("VOIPBlockIgnoreButton") != 0) {
        break label1060;
      }
      bool = true;
      label668:
      this.HdH = bool;
      this.HfY = ((VoipSmallIconButton)this.ncd.findViewById(2131310036));
      this.HfY.setOnClickListener(this.Hea);
      if (!this.HdH) {
        this.HfY.setVisibility(8);
      }
      this.HfN.setOnClickListener(this.Hgc);
      this.HfQ.setOnClickListener(this.Hgd);
      this.Hdb = ((Button)this.ncd.findViewById(2131297839));
      this.Hdb.setOnClickListener(this.HdZ);
      this.Hdc = ((WeImageView)this.ncd.findViewById(2131297851));
      if ((ao.gJN()) && (this.Hdc != null))
      {
        aw.kA(getActivity());
        if (aw.a(aw.gWy(), getActivity().getTaskId()) != -1) {
          break label1066;
        }
        this.Hdc.setVisibility(8);
      }
    }
    for (;;)
    {
      this.Hdc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(115463);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (aw.a(aw.gWy(), VoipVoiceFragment.this.getActivity().getTaskId()) == 2)
          {
            aw.a(aw.gWy(), VoipVoiceFragment.this.getActivity().getTaskId(), 0);
            VoipVoiceFragment.a(VoipVoiceFragment.this).setBackgroundResource(2131690910);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115463);
            return;
            aw.a(aw.gWy(), VoipVoiceFragment.this.getActivity().getTaskId(), 2);
            VoipVoiceFragment.a(VoipVoiceFragment.this).setBackgroundResource(2131690831);
          }
        }
      });
      int i = com.tencent.mm.ui.base.u.ay(getActivity());
      Log.d("MicroMsg.VoipVoiceFragment", "statusHeight: ".concat(String.valueOf(i)));
      aA(this.Hdb, i);
      aA(this.Hdc, i);
      if ((this.GUf) && (2 == this.GUk)) {
        jE(2131767227, 10000);
      }
      paramLayoutInflater = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.goe));
      if ((!Util.isNullOrNil(paramLayoutInflater)) && (this.HfH != null)) {
        this.HfH.setText(paramLayoutInflater);
      }
      this.mTimer = new Timer();
      jD(this.HeE, this.mStatus);
      paramLayoutInflater = this.ncd;
      AppMethodBeat.o(115476);
      return paramLayoutInflater;
      this.ncd = ((RelativeLayout)paramLayoutInflater.inflate(2131496864, paramViewGroup, false));
      if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
        break;
      }
      ((RelativeLayout)this.ncd.findViewById(2131307124)).setPadding(0, 0, 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(getActivity(), 40.0F));
      break;
      label1060:
      bool = false;
      break label668;
      label1066:
      this.Hdc.setVisibility(0);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115475);
    this.qvo = false;
    super.onDestroy();
    AppMethodBeat.o(115475);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(115490);
    Log.printInfoStack("MicroMsg.VoipVoiceFragment", "setMute:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    if ((this.HfQ != null) && (this.HfR != null)) {
      this.HfQ.setChecked(paramBoolean);
    }
    AppMethodBeat.o(115490);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(115492);
    if (paramInt != -1)
    {
      this.GUk = paramInt;
      fJJ();
    }
    AppMethodBeat.o(115492);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115478);
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    super.uninit();
    AppMethodBeat.o(115478);
  }
  
  protected final void xk(boolean paramBoolean)
  {
    AppMethodBeat.i(115488);
    if (this.Hgb)
    {
      AppMethodBeat.o(115488);
      return;
    }
    if (this.yzB != null)
    {
      if (!paramBoolean) {
        break label63;
      }
      this.yzB.setText(2131767331);
    }
    for (;;)
    {
      this.yzB.clearAnimation();
      this.yzB.setVisibility(0);
      AppMethodBeat.o(115488);
      return;
      label63:
      this.yzB.setText(2131767330);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment
 * JD-Core Version:    0.7.0.1
 */