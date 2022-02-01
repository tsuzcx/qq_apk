package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.be;
import com.tencent.mm.autogen.a.bg;
import com.tencent.mm.autogen.a.wh;
import com.tencent.mm.autogen.a.wh.a;
import com.tencent.mm.autogen.a.yu;
import com.tencent.mm.autogen.a.zi;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView.b;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.plugin.scanner.n;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.a;
import com.tencent.mm.ui.base.MMViewPager.l;
import com.tencent.mm.ui.base.k;
import java.util.ArrayList;
import java.util.List;

public abstract class SnsBaseGalleryUI
  extends MMActivity
  implements a.a<String, com.tencent.mm.plugin.scanner.word.b>, c.b, SnsInfoFlip.b, z.a
{
  private int AjA = 0;
  private ImageView AjC;
  private ImageView AjD;
  private ImageView AjE;
  private ValueAnimator AjF;
  private IListener<wh> AjG = new IListener(com.tencent.mm.app.f.hfK) {};
  private p AjH = new p.a()
  {
    public final void onNetworkChange(int paramAnonymousInt)
    {
      AppMethodBeat.i(307715);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(308188);
          if ((com.tencent.mm.kernel.h.aZW().bFQ() != 6) && (com.tencent.mm.kernel.h.aZW().bFQ() != 4) && (SnsBaseGalleryUI.j(SnsBaseGalleryUI.this) == 1))
          {
            k.c(SnsBaseGalleryUI.this, SnsBaseGalleryUI.this.getString(b.j.app_network_unavailable), "", true);
            SnsBaseGalleryUI.this.dSe();
          }
          AppMethodBeat.o(308188);
        }
      });
      AppMethodBeat.o(307715);
    }
  };
  private com.tencent.mm.plugin.scanner.word.a Ajy;
  int Ajz = 0;
  private MMViewPager HOP;
  private boolean PhI = true;
  private FlipView.b Rdq = new FlipView.b()
  {
    public final void hlY()
    {
      AppMethodBeat.i(307721);
      SnsBaseGalleryUI.b(SnsBaseGalleryUI.this).reset();
      AppMethodBeat.o(307721);
    }
    
    public final void kJ(List<Integer> paramAnonymousList)
    {
      AppMethodBeat.i(307718);
      if ((paramAnonymousList != null) && (paramAnonymousList.contains(Integer.valueOf(1011)))) {
        SnsBaseGalleryUI.b(SnsBaseGalleryUI.this).aZ(2, SnsBaseGalleryUI.this.hof(), SnsBaseGalleryUI.a(SnsBaseGalleryUI.this));
      }
      AppMethodBeat.o(307718);
    }
  };
  private LinearLayout RnB;
  protected y RnC;
  private LinearLayout RnD;
  z RnE;
  boolean RnF = true;
  private TextView RnG = null;
  public SnsInfoFlip RnH;
  protected Button RnI;
  private com.tencent.mm.plugin.scanner.word.b RnJ = null;
  private int RnK = 0;
  protected MultiCodeMaskView RnL;
  private int RnM = -1;
  private FlipView.c RnN = new FlipView.c()
  {
    public final boolean a(ArrayList<ImageQBarDataBean> paramAnonymousArrayList1, ArrayList<PointF> paramAnonymousArrayList, ArrayList<ImageQBarDataBean> paramAnonymousArrayList2, final SnsInfo paramAnonymousSnsInfo, final String paramAnonymousString)
    {
      AppMethodBeat.i(307710);
      if (SnsBaseGalleryUI.this.RnL != null)
      {
        if (SnsBaseGalleryUI.this.RnH != null) {
          SnsBaseGalleryUI.this.RnL.a(paramAnonymousArrayList1, paramAnonymousArrayList, paramAnonymousArrayList2, SnsBaseGalleryUI.this.RnH.getMeasuredHeight());
        }
        for (;;)
        {
          SnsBaseGalleryUI.this.RnL.setMMultiCodeMaskViewListener(new MultiCodeMaskView.b()
          {
            public final void a(ArrayList<ImageQBarDataBean> paramAnonymous2ArrayList, ImageQBarDataBean paramAnonymous2ImageQBarDataBean, boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(307568);
              if (SnsBaseGalleryUI.this.RnH != null) {
                SnsBaseGalleryUI.this.RnH.a(paramAnonymous2ImageQBarDataBean, paramAnonymousSnsInfo, paramAnonymousString);
              }
              if (paramAnonymous2Boolean) {}
              for (int i = 1;; i = 2)
              {
                j localj = j.OGP;
                j.a(SnsBaseGalleryUI.this.RnH.GYk.longValue(), i, paramAnonymous2ArrayList, paramAnonymous2ImageQBarDataBean, SnsBaseGalleryUI.this.RnH.GYl.longValue(), 1);
                AppMethodBeat.o(307568);
                return;
              }
            }
            
            public final void aF(ArrayList<ImageQBarDataBean> paramAnonymous2ArrayList)
            {
              AppMethodBeat.i(307567);
              j localj = j.OGP;
              j.a(SnsBaseGalleryUI.this.RnH.GYk.longValue(), 3, paramAnonymous2ArrayList, null, SnsBaseGalleryUI.this.RnH.GYl.longValue(), 1);
              AppMethodBeat.o(307567);
            }
          });
          AppMethodBeat.o(307710);
          return true;
          SnsBaseGalleryUI.this.RnL.a(paramAnonymousArrayList1, paramAnonymousArrayList, paramAnonymousArrayList2, SnsBaseGalleryUI.this.RnL.getRootView().getMeasuredHeight());
        }
      }
      AppMethodBeat.o(307710);
      return false;
    }
  };
  private a RnO;
  private long RnP = 0L;
  private com.tencent.mm.plugin.scanner.api.a.a RnQ = null;
  private com.tencent.mm.plugin.scanner.api.a.b RnR = ((com.tencent.mm.plugin.scanner.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.scanner.api.b.class)).gPz();
  private com.tencent.mm.plugin.scanner.api.a.c RnS = new com.tencent.mm.plugin.scanner.api.a.c()
  {
    public final void gPE()
    {
      AppMethodBeat.i(307703);
      SnsBaseGalleryUI.c(SnsBaseGalleryUI.this);
      AppMethodBeat.o(307703);
    }
    
    public final void gPF()
    {
      AppMethodBeat.i(307716);
      Log.i("MicroMsg.SnsBaseGalleryUI", "alvinluo dealWithImageOcr onDialogShow");
      SnsBaseGalleryUI.c(SnsBaseGalleryUI.this);
      SnsBaseGalleryUI localSnsBaseGalleryUI = SnsBaseGalleryUI.this;
      localSnsBaseGalleryUI.RnF = false;
      localSnsBaseGalleryUI.setTitleVisibility(8);
      if (localSnsBaseGalleryUI.RnC != null) {
        localSnsBaseGalleryUI.RnC.setVisibility(8);
      }
      SnsBaseGalleryUI.this.dSg();
      AppMethodBeat.o(307716);
    }
    
    public final void gPG() {}
    
    public final void gPH()
    {
      AppMethodBeat.i(307712);
      SnsBaseGalleryUI.d(SnsBaseGalleryUI.this);
      AppMethodBeat.o(307712);
    }
    
    public final void gPI()
    {
      AppMethodBeat.i(307707);
      SnsBaseGalleryUI.d(SnsBaseGalleryUI.this);
      SnsBaseGalleryUI.this.dSg();
      AppMethodBeat.o(307707);
    }
  };
  private IListener<zi> RnT = new IListener(com.tencent.mm.app.f.hfK) {};
  private IListener<yu> RnU = new IListener(com.tencent.mm.app.f.hfK) {};
  private View.OnLongClickListener onLongClickListener = new View.OnLongClickListener()
  {
    public final boolean onLongClick(View paramAnonymousView)
    {
      AppMethodBeat.i(307700);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsBaseGalleryUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
      if (SnsBaseGalleryUI.this.RnH == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/SnsBaseGalleryUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(307700);
        return false;
      }
      paramAnonymousView = SnsBaseGalleryUI.this.RnH.getCntMedia();
      if ((paramAnonymousView != null) && (paramAnonymousView.vhJ == 2) && (SnsBaseGalleryUI.this.hod()) && (n.gPs()))
      {
        paramAnonymousView = com.tencent.mm.plugin.sns.model.g.D(SnsBaseGalleryUI.this.RnH.getCntMedia());
        SnsBaseGalleryUI.this.dj(paramAnonymousView, true);
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/SnsBaseGalleryUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(307700);
      return false;
    }
  };
  
  private void aV(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    if (paramBoolean2) {
      this.RnH.setNeedOCRImg(true);
    }
    if ((paramBoolean1) || (paramBoolean2))
    {
      SnsInfoFlip localSnsInfoFlip = this.RnH;
      if ((localSnsInfoFlip.Rde == null) || (!localSnsInfoFlip.Rde.cDi().isShowing())) {
        break label68;
      }
    }
    for (;;)
    {
      if (i != 0) {
        this.RnH.cpX();
      }
      aW(paramBoolean1, paramBoolean2);
      return;
      label68:
      i = 0;
    }
  }
  
  private void baE(String paramString)
  {
    if (this.Ajy == null) {
      this.Ajy = new ImageWordScanDetailEngine(this, (byte)0);
    }
    if (!Util.isNullOrNil(paramString))
    {
      Object localObject = com.tencent.mm.plugin.scanner.util.g.PiK;
      localObject = com.tencent.mm.plugin.scanner.util.g.aVg(paramString);
      if ((localObject != null) && (com.tencent.worddetect.a.qd(((Point)localObject).x, ((Point)localObject).y)))
      {
        Log.i("MicroMsg.SnsBaseGalleryUI", "doWordDetectImage image overRatioLimit: %s", new Object[] { localObject });
        boolean bool = ((com.tencent.mm.plugin.scanner.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.scanner.api.c.class)).gPA();
        this.RnK = 1;
        aV(false, bool);
      }
    }
    else
    {
      return;
    }
    this.Ajy.a(paramString, this);
  }
  
  private void dSf()
  {
    this.AjC.setVisibility(0);
    this.AjD.setVisibility(0);
    this.AjE.setVisibility(0);
    this.AjF.setRepeatMode(1);
    this.AjF.setRepeatCount(-1);
    this.AjF.start();
  }
  
  private void hnZ()
  {
    if (this.RnH != null)
    {
      this.RnH.setEnableSingleClickOver(true);
      this.RnH.setShowLongClickMenu(true);
    }
    if (this.HOP != null)
    {
      this.HOP.setEnableGalleryScale(true);
      this.HOP.setSingleMode(false);
    }
  }
  
  private boolean hoa()
  {
    boolean bool = true;
    if (this.AjA == 1)
    {
      bg localbg = new bg();
      localbg.hBl.scene = 1;
      localbg.hBl.hBm = this.Ajz;
      localbg.publish();
    }
    if (this.AjF.isRunning()) {}
    for (;;)
    {
      dSe();
      this.Ajz = 0;
      return bool;
      bool = false;
    }
  }
  
  private boolean hog()
  {
    return hoe() == 3;
  }
  
  private void hoh()
  {
    this.AjC.setVisibility(8);
    this.AjD.setVisibility(8);
    this.AjE.setVisibility(8);
  }
  
  private void setNeedTranslationImg(boolean paramBoolean)
  {
    if (n.gPv())
    {
      this.RnH.setNeedTranslationImg(true);
      return;
    }
    this.RnH.setNeedTranslationImg(paramBoolean);
  }
  
  public final void EE(String paramString) {}
  
  public final void a(a parama)
  {
    this.RnO = parama;
  }
  
  public void a(dmz paramdmz, int paramInt, String paramString)
  {
    this.RnJ = null;
    this.RnK = 0;
    Object localObject;
    if ((paramdmz.vhJ == 2) && (n.gPs()) && (hod()))
    {
      if (paramInt != this.RnM)
      {
        setNeedTranslationImg(false);
        this.RnH.setNeedOCRImg(false);
        this.Ajz = 0;
      }
      this.RnM = paramInt;
      localObject = al.hgB().aZL(paramString);
      if ((localObject != null) && (!((SnsInfo)localObject).isWaitPost())) {
        dj(com.tencent.mm.plugin.sns.model.g.D(paramdmz), false);
      }
    }
    for (;;)
    {
      if (this.RnE != null)
      {
        localObject = this.RnE;
        ((z)localObject).RdU = false;
        ((z)localObject).RdV = false;
      }
      if (this.RnO != null) {
        this.RnO.onGalleryPageChange(paramdmz, paramInt, paramString);
      }
      return;
      setNeedTranslationImg(false);
      this.RnH.setNeedOCRImg(false);
    }
  }
  
  protected void aW(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void aXr() {}
  
  public void addView(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.RnB.addView(paramView, localLayoutParams);
  }
  
  public final void am(boolean paramBoolean, int paramInt)
  {
    this.RnC = new y(this, paramInt, paramBoolean);
    this.RnC.setBackgroundColor(b.c.transparent);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.RnC.getBackground().setAlpha(50);
    this.RnD.addView(this.RnC, localLayoutParams);
    paramInt = getIntent().getIntExtra("sns_source", 0);
    this.RnC.setSnsSource(paramInt);
  }
  
  public final void dSe()
  {
    this.RnH.setEnableSingleClickOver(true);
    this.AjA = 0;
    dSg();
  }
  
  public final void dSg()
  {
    hoh();
    this.AjF.setRepeatMode(1);
    this.AjF.setRepeatCount(0);
    this.AjF.end();
  }
  
  protected final void dj(String paramString, boolean paramBoolean)
  {
    if (!n.gPq()) {
      baE(paramString);
    }
    while (!paramBoolean) {
      return;
    }
    baE(paramString);
  }
  
  public final int getFromScene()
  {
    return getIntent().getIntExtra("key_from_scene", 0);
  }
  
  public int getLayoutId()
  {
    return b.g.sns_gallery_img;
  }
  
  public void hf(String paramString, int paramInt) {}
  
  public void hg(String paramString, int paramInt)
  {
    if ((!this.PhI) || (al.isInValid())) {
      return;
    }
    paramString = al.hgB().aZL(paramString);
    if ((paramString == null) || (paramString.field_snsId == 0L))
    {
      enableOptionMenu(false);
      return;
    }
    enableOptionMenu(true);
  }
  
  public void hma()
  {
    int j = 8;
    boolean bool = false;
    if (!this.PhI) {
      return;
    }
    y localy;
    if (this.RnF)
    {
      i = 8;
      setTitleVisibility(i);
      if (this.RnC != null)
      {
        localy = this.RnC;
        if (!this.RnF) {
          break label76;
        }
      }
    }
    label76:
    for (int i = j;; i = 0)
    {
      localy.setVisibility(i);
      if (!this.RnF) {
        bool = true;
      }
      this.RnF = bool;
      return;
      i = 0;
      break;
    }
  }
  
  protected final boolean hob()
  {
    return (hoc()) || (hoa());
  }
  
  protected final boolean hoc()
  {
    hnZ();
    return (this.RnQ != null) && (this.RnQ.tP(this.RnP));
  }
  
  protected boolean hod()
  {
    return false;
  }
  
  protected int hoe()
  {
    return 3;
  }
  
  protected int hof()
  {
    return 3;
  }
  
  public void mV(String paramString1, String paramString2)
  {
    if (!this.PhI) {
      return;
    }
    setMMTitle(paramString1);
    setMMSubTitle(paramString2);
  }
  
  public void onBackPressed()
  {
    if ((this.RnL != null) && (this.RnL.getVisibility() == 0))
    {
      long l = 0L;
      if (this.RnH != null) {
        l = this.RnH.GYk.longValue();
      }
      this.RnL.P(l, false);
      return;
    }
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.RnQ != null) {
      this.RnQ.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    al.hgw().bE(3, true);
    this.RnB = ((LinearLayout)findViewById(b.f.layout_content));
    this.RnD = ((LinearLayout)findViewById(b.f.content));
    this.RnE = new z(this, this, getFromScene());
    paramBundle = this.RnE;
    Log.i("MicroMsg.GalleryTitleManager", "onAttach");
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(218, paramBundle);
    paramBundle.Ahp.alive();
    paramBundle.Rdt.alive();
    this.RnE.Rdq = new FlipView.b()
    {
      public final void hlY()
      {
        AppMethodBeat.i(308296);
        SnsBaseGalleryUI.b(SnsBaseGalleryUI.this).reset();
        AppMethodBeat.o(308296);
      }
      
      public final void kJ(List<Integer> paramAnonymousList)
      {
        AppMethodBeat.i(308295);
        if ((paramAnonymousList != null) && (paramAnonymousList.contains(Integer.valueOf(1011)))) {
          SnsBaseGalleryUI.b(SnsBaseGalleryUI.this).aZ(2, SnsBaseGalleryUI.this.hof(), SnsBaseGalleryUI.a(SnsBaseGalleryUI.this));
        }
        AppMethodBeat.o(308295);
      }
    };
    this.RnL = ((MultiCodeMaskView)findViewById(b.f.multi_code_mask_view));
    if (hod())
    {
      this.AjC = ((ImageView)findViewById(b.f.scan_translate_line));
      this.AjD = ((ImageView)findViewById(b.f.scan_translate_layer));
      this.AjE = ((ImageView)findViewById(b.f.scan_translate_close_btn));
      paramBundle = (FrameLayout.LayoutParams)this.AjE.getLayoutParams();
      paramBundle.bottomMargin += aw.bk(this);
      this.AjE.setLayoutParams(paramBundle);
      this.AjE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(307699);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsBaseGalleryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          SnsBaseGalleryUI.this.hoc();
          SnsBaseGalleryUI.e(SnsBaseGalleryUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBaseGalleryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(307699);
        }
      });
      this.AjC = ((ImageView)findViewById(b.f.scan_translate_line));
      this.AjF = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.AjF.setDuration(5000L);
      this.AjF.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(307691);
          SnsBaseGalleryUI.g(SnsBaseGalleryUI.this).setAlpha(0.0F);
          AppMethodBeat.o(307691);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(307688);
          SnsBaseGalleryUI.g(SnsBaseGalleryUI.this).setAlpha(0.0F);
          AppMethodBeat.o(307688);
        }
      });
      final int i = getWindowManager().getDefaultDisplay().getHeight();
      this.AjF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(307687);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f <= 0.1F) {
            SnsBaseGalleryUI.g(SnsBaseGalleryUI.this).setAlpha(f * 10.0F);
          }
          for (;;)
          {
            SnsBaseGalleryUI.g(SnsBaseGalleryUI.this).setTranslationY(f * (i - SnsBaseGalleryUI.g(SnsBaseGalleryUI.this).getHeight()));
            AppMethodBeat.o(307687);
            return;
            if (f >= 0.9F) {
              SnsBaseGalleryUI.g(SnsBaseGalleryUI.this).setAlpha((1.0F - f) * 10.0F);
            }
          }
        }
      });
    }
    al.hgw().a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject;
    if (this.RnE != null)
    {
      localObject = this.RnE;
      Log.i("MicroMsg.GalleryTitleManager", "onDetach");
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(218, (com.tencent.mm.am.h)localObject);
      ((z)localObject).Ahp.dead();
      ((z)localObject).Rdt.dead();
    }
    if (this.RnH != null)
    {
      this.RnH.HOP.adUx.removeMessages(1);
      localObject = this.RnH;
      Log.i("MicroMsg.SnsInfoFlip", "sns info flip on detach.");
      if (((SnsInfoFlip)localObject).RrL != null)
      {
        ((SnsInfoFlip)localObject).RrL.hoM();
        ((SnsInfoFlip)localObject).RrL.clear();
      }
      al.hgw().b((c.b)localObject);
      this.RnH.onDestroy();
    }
    if (this.RnL != null) {
      this.RnL.gPk();
    }
    if (hod()) {
      dSe();
    }
    com.tencent.mm.kernel.h.baD().b(this.AjH);
    this.AjG.dead();
    al.hgw().b(this);
  }
  
  public void onPause()
  {
    if (this.RnH != null) {
      this.RnH.onPause();
    }
    if (this.RnE != null)
    {
      z localz = this.RnE;
      if (localz.Rdo != null)
      {
        be localbe = new be();
        localbe.hBh.activity = ((Activity)localz.context);
        localbe.hBh.hBi = localz.Rdo.OGQ;
        localbe.publish();
        localz.Rdo = null;
      }
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.RnC != null) {
      this.RnC.bDL();
    }
    if (hod())
    {
      com.tencent.mm.kernel.h.baD().a(this.AjH);
      this.RnT.alive();
      this.AjG.alive();
      this.RnU.alive();
    }
    if (this.RnH != null)
    {
      this.RnH.setOnMenuShowListener(this.Rdq);
      this.RnH.setOnLongClickListener(this.onLongClickListener);
      this.RnH.setOnMultiCodeListener(this.RnN);
      if (n.gPv()) {
        setNeedTranslationImg(true);
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.RnT.dead();
    this.RnU.dead();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void w(String paramString, boolean paramBoolean)
  {
    if ((n.gPs()) && (hod()) && (paramBoolean) && (!Util.isNullOrNil(paramString)) && (paramString.equals(this.RnH.getSelectedMediaId()))) {
      dj(com.tencent.mm.plugin.sns.model.g.D(this.RnH.getCntMedia()), false);
    }
  }
  
  public final void x(String paramString, boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract void onGalleryPageChange(dmz paramdmz, int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
 * JD-Core Version:    0.7.0.1
 */