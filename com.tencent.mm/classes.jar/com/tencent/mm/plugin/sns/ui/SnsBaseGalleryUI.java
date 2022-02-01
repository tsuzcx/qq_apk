package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.g.a.tp.a;
import com.tencent.mm.g.a.vw;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.a;
import com.tencent.mm.ui.base.MMViewPager.l;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;
import java.util.List;

public abstract class SnsBaseGalleryUI
  extends MMActivity
  implements a.a<String, com.tencent.mm.plugin.scanner.word.b>, c.b, SnsInfoFlip.b, w.a
{
  private boolean CSQ = true;
  private LinearLayout EAc;
  v EAd;
  private LinearLayout EAe;
  w EAf;
  boolean EAg = true;
  private TextView EAh = null;
  protected SnsInfoFlip EAi;
  protected Button EAj;
  private int EAk = -1;
  private long EAl = 0L;
  private com.tencent.mm.plugin.scanner.api.a.a EAm = null;
  private com.tencent.mm.plugin.scanner.api.a.b EAn = ((com.tencent.mm.plugin.scanner.api.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.scanner.api.b.class)).eOT();
  private com.tencent.mm.plugin.scanner.api.a.c EAo = new com.tencent.mm.plugin.scanner.api.a.c()
  {
    public final void eOW()
    {
      AppMethodBeat.i(203488);
      SnsBaseGalleryUI.b(SnsBaseGalleryUI.this);
      AppMethodBeat.o(203488);
    }
    
    public final void eOX()
    {
      AppMethodBeat.i(203491);
      SnsBaseGalleryUI.b(SnsBaseGalleryUI.this);
      SnsBaseGalleryUI localSnsBaseGalleryUI = SnsBaseGalleryUI.this;
      localSnsBaseGalleryUI.EAg = false;
      localSnsBaseGalleryUI.setTitleVisibility(8);
      if (localSnsBaseGalleryUI.EAd != null) {
        localSnsBaseGalleryUI.EAd.setVisibility(8);
      }
      SnsBaseGalleryUI.this.cWj();
      AppMethodBeat.o(203491);
    }
    
    public final void eOY()
    {
      AppMethodBeat.i(203490);
      SnsBaseGalleryUI.c(SnsBaseGalleryUI.this);
      AppMethodBeat.o(203490);
    }
    
    public final void eOZ()
    {
      AppMethodBeat.i(203489);
      SnsBaseGalleryUI.c(SnsBaseGalleryUI.this);
      SnsBaseGalleryUI.this.cWj();
      AppMethodBeat.o(203489);
    }
  };
  private IListener<wj> EAp = new IListener() {};
  private IListener<vw> EAq = new IListener() {};
  private FlipView.b Eqw = new FlipView.b()
  {
    public final void ffI()
    {
      AppMethodBeat.i(203482);
      SnsBaseGalleryUI.a(SnsBaseGalleryUI.this).reset();
      AppMethodBeat.o(203482);
    }
    
    public final void ha(List<Integer> paramAnonymousList)
    {
      AppMethodBeat.i(203481);
      if ((paramAnonymousList != null) && (paramAnonymousList.contains(Integer.valueOf(9)))) {
        SnsBaseGalleryUI.a(SnsBaseGalleryUI.this).hY(2, SnsBaseGalleryUI.this.fhE());
      }
      AppMethodBeat.o(203481);
    }
  };
  private com.tencent.mm.plugin.scanner.word.a tgL;
  int tgM = 0;
  private int tgN = 0;
  private ImageView tgP;
  private ImageView tgQ;
  private ImageView tgR;
  private ValueAnimator tgS;
  private IListener<tp> tgT = new IListener() {};
  private p tgU = new p.a()
  {
    public final void onNetworkChange(int paramAnonymousInt)
    {
      AppMethodBeat.i(203487);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203486);
          if ((com.tencent.mm.kernel.g.azz().aYS() != 6) && (com.tencent.mm.kernel.g.azz().aYS() != 4) && (SnsBaseGalleryUI.i(SnsBaseGalleryUI.this) == 1))
          {
            h.c(SnsBaseGalleryUI.this, SnsBaseGalleryUI.this.getString(2131755914), "", true);
            SnsBaseGalleryUI.this.cWh();
          }
          AppMethodBeat.o(203486);
        }
      });
      AppMethodBeat.o(203487);
    }
  };
  private MMViewPager xqs;
  
  private void cWi()
  {
    this.tgP.setVisibility(0);
    this.tgQ.setVisibility(0);
    this.tgR.setVisibility(0);
    this.tgS.setRepeatMode(1);
    this.tgS.setRepeatCount(-1);
    this.tgS.start();
  }
  
  private void fhA()
  {
    if (this.EAi != null)
    {
      this.EAi.setEnableSingleClickOver(true);
      this.EAi.setShowLongClickMenu(true);
    }
    if (this.xqs != null)
    {
      this.xqs.setEnableGalleryScale(true);
      this.xqs.setSingleMode(false);
    }
  }
  
  private boolean fhB()
  {
    fhA();
    return (this.EAm != null) && (this.EAm.It(this.EAl));
  }
  
  private boolean fhF()
  {
    return fhD() == 3;
  }
  
  private void fhG()
  {
    this.tgP.setVisibility(8);
    this.tgQ.setVisibility(8);
    this.tgR.setVisibility(8);
  }
  
  @SuppressLint({"ResourceAsColor"})
  public final void X(boolean paramBoolean, int paramInt)
  {
    this.EAd = new v(this, paramInt, paramBoolean);
    this.EAd.setBackgroundColor(2131101287);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.EAd.getBackground().setAlpha(50);
    this.EAe.addView(this.EAd, localLayoutParams);
    paramInt = getIntent().getIntExtra("sns_source", 0);
    this.EAd.setSnsSource(paramInt);
  }
  
  public void a(cnb paramcnb, int paramInt, String paramString)
  {
    if ((paramcnb.oUv == 2) && (com.tencent.mm.plugin.scanner.i.eOP()) && (fhC()))
    {
      if (paramInt != this.EAk)
      {
        this.EAi.setNeedTranslationImg(false);
        this.EAi.setNeedOCRImg(false);
        this.tgM = 0;
      }
      this.EAk = paramInt;
      if (this.tgL == null) {
        this.tgL = new ImageWordScanDetailEngine(this);
      }
      paramString = aj.faO().aQm(paramString);
      if ((paramString != null) && (!paramString.isWaitPost()))
      {
        paramcnb = com.tencent.mm.plugin.sns.model.g.D(paramcnb);
        if (!Util.isNullOrNil(paramcnb)) {
          this.tgL.a(paramcnb, this);
        }
      }
    }
    for (;;)
    {
      if (this.EAf != null)
      {
        paramcnb = this.EAf;
        paramcnb.Era = false;
        paramcnb.Erb = false;
      }
      return;
      this.EAi.setNeedTranslationImg(false);
      this.EAi.setNeedOCRImg(false);
    }
  }
  
  public final void aOG(String paramString) {}
  
  public void addView(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.EAc.addView(paramView, localLayoutParams);
  }
  
  protected void ap(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void cWh()
  {
    this.EAi.setEnableSingleClickOver(true);
    this.tgN = 0;
    cWj();
  }
  
  public final void cWj()
  {
    fhG();
    this.tgS.setRepeatMode(1);
    this.tgS.setRepeatCount(0);
    this.tgS.end();
  }
  
  public final void ci(String paramString, boolean paramBoolean)
  {
    if ((com.tencent.mm.plugin.scanner.i.eOP()) && (fhC()) && (paramBoolean) && (!Util.isNullOrNil(paramString)) && (paramString.equals(this.EAi.getSelectedMediaId())))
    {
      if (this.tgL == null) {
        this.tgL = new ImageWordScanDetailEngine(this);
      }
      paramString = com.tencent.mm.plugin.sns.model.g.D(this.EAi.getCntMedia());
      if (!Util.isNullOrNil(paramString)) {
        this.tgL.a(paramString, this);
      }
    }
  }
  
  public final void cj(String paramString, boolean paramBoolean) {}
  
  public final void eZJ() {}
  
  public void fH(String paramString, int paramInt) {}
  
  public void fI(String paramString, int paramInt)
  {
    if ((!this.CSQ) || (aj.isInValid())) {
      return;
    }
    paramString = aj.faO().aQm(paramString);
    if ((paramString == null) || (paramString.field_snsId == 0L))
    {
      enableOptionMenu(false);
      return;
    }
    enableOptionMenu(true);
  }
  
  public void ffK()
  {
    int j = 8;
    boolean bool = false;
    if (!this.CSQ) {
      return;
    }
    v localv;
    if (this.EAg)
    {
      i = 8;
      setTitleVisibility(i);
      if (this.EAd != null)
      {
        localv = this.EAd;
        if (!this.EAg) {
          break label76;
        }
      }
    }
    label76:
    for (int i = j;; i = 0)
    {
      localv.setVisibility(i);
      if (!this.EAg) {
        bool = true;
      }
      this.EAg = bool;
      return;
      i = 0;
      break;
    }
  }
  
  protected boolean fhC()
  {
    return false;
  }
  
  protected int fhD()
  {
    return 3;
  }
  
  protected int fhE()
  {
    return 3;
  }
  
  public final int getFromScene()
  {
    return getIntent().getIntExtra("key_from_scene", 0);
  }
  
  public int getLayoutId()
  {
    return 2131496440;
  }
  
  public final void kQ(String paramString1, String paramString2)
  {
    if (!this.CSQ) {
      return;
    }
    setMMTitle(paramString1);
    setMMSubTitle(paramString2);
  }
  
  public void onBackPressed()
  {
    Log.i("MicroMsg.SnsBaseGalleryUI", "onBackPressed");
    if (fhB())
    {
      this.EAl = 0L;
      return;
    }
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.EAm != null) {
      this.EAm.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    aj.faJ().aO(3, true);
    this.EAc = ((LinearLayout)findViewById(2131303086));
    this.EAe = ((LinearLayout)findViewById(2131299180));
    this.EAf = new w(this, this, getFromScene());
    paramBundle = this.EAf;
    Log.i("MicroMsg.GalleryTitleManager", "onAttach");
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(218, paramBundle);
    EventCenter.instance.addListener(paramBundle.teF);
    EventCenter.instance.addListener(paramBundle.Eqy);
    this.EAf.Eqw = new FlipView.b()
    {
      public final void ffI()
      {
        AppMethodBeat.i(203498);
        SnsBaseGalleryUI.a(SnsBaseGalleryUI.this).reset();
        AppMethodBeat.o(203498);
      }
      
      public final void ha(List<Integer> paramAnonymousList)
      {
        AppMethodBeat.i(203497);
        if ((paramAnonymousList != null) && (paramAnonymousList.contains(Integer.valueOf(11)))) {
          SnsBaseGalleryUI.a(SnsBaseGalleryUI.this).hY(2, SnsBaseGalleryUI.this.fhE());
        }
        AppMethodBeat.o(203497);
      }
    };
    if (fhC())
    {
      this.tgP = ((ImageView)findViewById(2131307275));
      this.tgQ = ((ImageView)findViewById(2131307274));
      this.tgR = ((ImageView)findViewById(2131307272));
      paramBundle = (FrameLayout.LayoutParams)this.tgR.getLayoutParams();
      paramBundle.bottomMargin += ao.aD(this);
      this.tgR.setLayoutParams(paramBundle);
      this.tgR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(203492);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsBaseGalleryUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          SnsBaseGalleryUI.d(SnsBaseGalleryUI.this);
          paramAnonymousView = new ay();
          paramAnonymousView.dEa.scene = 1;
          paramAnonymousView.dEa.dEb = SnsBaseGalleryUI.e(SnsBaseGalleryUI.this);
          EventCenter.instance.publish(paramAnonymousView);
          SnsBaseGalleryUI.this.cWh();
          SnsBaseGalleryUI.this.tgM = 0;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBaseGalleryUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203492);
        }
      });
      this.tgP = ((ImageView)findViewById(2131307275));
      this.tgS = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.tgS.setDuration(5000L);
      this.tgS.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(203495);
          SnsBaseGalleryUI.g(SnsBaseGalleryUI.this).setAlpha(0.0F);
          AppMethodBeat.o(203495);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(203494);
          SnsBaseGalleryUI.g(SnsBaseGalleryUI.this).setAlpha(0.0F);
          AppMethodBeat.o(203494);
        }
      });
      final int i = getWindowManager().getDefaultDisplay().getHeight();
      this.tgS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(203496);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f <= 0.1F) {
            SnsBaseGalleryUI.g(SnsBaseGalleryUI.this).setAlpha(f * 10.0F);
          }
          for (;;)
          {
            SnsBaseGalleryUI.g(SnsBaseGalleryUI.this).setTranslationY(f * (i - SnsBaseGalleryUI.g(SnsBaseGalleryUI.this).getHeight()));
            AppMethodBeat.o(203496);
            return;
            if (f >= 0.9F) {
              SnsBaseGalleryUI.g(SnsBaseGalleryUI.this).setAlpha((1.0F - f) * 10.0F);
            }
          }
        }
      });
    }
    aj.faJ().a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject;
    if (this.EAf != null)
    {
      localObject = this.EAf;
      Log.i("MicroMsg.GalleryTitleManager", "onDetach");
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.b(218, (com.tencent.mm.ak.i)localObject);
      EventCenter.instance.removeListener(((w)localObject).teF);
      EventCenter.instance.removeListener(((w)localObject).Eqy);
    }
    if (this.EAi != null)
    {
      this.EAi.xqs.OTV.removeMessages(1);
      localObject = this.EAi;
      Log.i("MicroMsg.SnsInfoFlip", "sns info flip on detach.");
      if (((SnsInfoFlip)localObject).EDX != null)
      {
        ((SnsInfoFlip)localObject).EDX.fij();
        ((SnsInfoFlip)localObject).EDX.clear();
      }
      aj.faJ().b((c.b)localObject);
      this.EAi.onDestroy();
    }
    if (fhC()) {
      cWh();
    }
    com.tencent.mm.kernel.g.aAg().b(this.tgU);
    EventCenter.instance.removeListener(this.tgT);
    aj.faJ().b(this);
  }
  
  public void onPause()
  {
    if (this.EAi != null) {
      this.EAi.onPause();
    }
    if (this.EAf != null)
    {
      w localw = this.EAf;
      if (localw.Eqn != null)
      {
        aw localaw = new aw();
        localaw.dDW.activity = ((Activity)localw.context);
        localaw.dDW.dDX = localw.Eqn;
        EventCenter.instance.publish(localaw);
        localw.Eqn = null;
        localw.dFM = 0;
        localw.dFL = 0;
      }
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.EAd != null) {
      this.EAd.refresh();
    }
    if (fhC())
    {
      com.tencent.mm.kernel.g.aAg().a(this.tgU);
      EventCenter.instance.addListener(this.EAp);
      EventCenter.instance.addListener(this.tgT);
      EventCenter.instance.addListener(this.EAq);
    }
    if (this.EAi != null) {
      this.EAi.setOnMenuShowListener(this.Eqw);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    EventCenter.instance.removeListener(this.EAp);
    EventCenter.instance.removeListener(this.EAq);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
 * JD-Core Version:    0.7.0.1
 */