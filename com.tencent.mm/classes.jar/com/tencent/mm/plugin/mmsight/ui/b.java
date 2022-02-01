package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.os.Process;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import com.tencent.mm.api.i;
import com.tencent.mm.api.s;
import com.tencent.mm.api.u;
import com.tencent.mm.api.w;
import com.tencent.mm.api.y;
import com.tencent.mm.api.y.a.a;
import com.tencent.mm.api.y.b;
import com.tencent.mm.api.y.c;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.media.i.d.a;
import com.tencent.mm.media.i.d.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.mmsight.segment.c.a;
import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.plugin.mmsight.segment.m;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.o;

public final class b
{
  private static int fMX;
  private static final Object whP;
  private MMActivity fNT;
  private p fPj;
  String md5;
  public int scene;
  private VideoTransPara vZX;
  public String videoOutputPath = null;
  private String videoPath;
  private VideoPlayerTextureView wdv;
  private VideoSeekBarEditorView wdw;
  private RecyclerThumbSeekBar whE;
  private boolean whF = false;
  private int whG = -1;
  public int whH = -1;
  public int whI = -1;
  private aw whJ;
  private ViewGroup whK;
  private y whL;
  private com.tencent.mm.api.e whM;
  private com.tencent.mm.plugin.mmsight.api.a whN;
  private com.tencent.mm.media.i.d whO;
  public a whQ;
  private boolean whR = false;
  public boolean whS = false;
  private boolean whT = false;
  private boolean whU = false;
  public int whV = -1;
  private com.tencent.mm.plugin.mmsight.a.a.b whW;
  public boolean whX = false;
  public boolean whY = true;
  
  static
  {
    AppMethodBeat.i(94627);
    whP = new Object();
    AppMethodBeat.o(94627);
  }
  
  private void dqU()
  {
    AppMethodBeat.i(94614);
    this.whL = y.cSw.Kf();
    Object localObject = this.whL;
    y.a.a locala = new y.a.a();
    locala.cSy = false;
    locala.cSB = true;
    locala.cSx = y.c.cSD;
    locala.cSC = new Rect(this.wdv.getLeft(), this.wdv.getTop(), this.wdv.getRight(), this.wdv.getBottom());
    ((y)localObject).a(locala.Lv());
    this.whM = this.whL.bh(this.whK.getContext());
    this.whM.setActionBarCallback(new i()
    {
      public final void onExit()
      {
        AppMethodBeat.i(94586);
        ae.i("MicroMsg.MMSightVideoEditor", "photoEditor onExit");
        b.this.release();
        if (b.a(b.this) != null) {
          com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(94584);
              b.a(b.this).dqC();
              AppMethodBeat.o(94584);
            }
          });
        }
        AppMethodBeat.o(94586);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(94585);
        ae.i("MicroMsg.MMSightVideoEditor", "photoEditor onFinish");
        b.h(b.this).a(new s()
        {
          public final void a(final Bitmap paramAnonymous2Bitmap, boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(94583);
            ae.i("MicroMsg.MMSightVideoEditor", "photoEditor onSuccess: %s isNever：%s", new Object[] { paramAnonymous2Bitmap, Boolean.valueOf(paramAnonymous2Boolean) });
            if (paramAnonymous2Boolean)
            {
              if ((paramAnonymous2Bitmap != null) && (!paramAnonymous2Bitmap.isRecycled())) {
                paramAnonymous2Bitmap.recycle();
              }
              if ((b.a(b.this) != null) && (!b.b(b.this)))
              {
                if ((b.c(b.this) > 0) && (b.d(b.this) > 0) && (b.c(b.this) <= b.d(b.this)))
                {
                  com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(94578);
                      b.a(b.this, h.b(b.e(b.this), b.e(b.this).getString(2131761244), false, null));
                      b.f(b.this).pause();
                      b.a(b.this, null);
                      AppMethodBeat.o(94578);
                    }
                  });
                  AppMethodBeat.o(94583);
                  return;
                }
                b.a(b.this, o.aRh(b.g(b.this)));
                com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(94579);
                    b.a(b.this).dqB();
                    AppMethodBeat.o(94579);
                  }
                });
                AppMethodBeat.o(94583);
                return;
              }
              if (b.b(b.this))
              {
                com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(94580);
                    b.a(b.this, h.b(b.e(b.this), b.e(b.this).getString(2131761244), false, null));
                    b.f(b.this).pause();
                    b.a(b.this, null);
                    AppMethodBeat.o(94580);
                  }
                });
                AppMethodBeat.o(94583);
              }
            }
            else if (paramAnonymous2Bitmap != null)
            {
              com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(94581);
                  b.a(b.this, h.b(b.e(b.this), b.e(b.this).getString(2131761244), false, null));
                  b.f(b.this).pause();
                  b.a(b.this, paramAnonymous2Bitmap);
                  AppMethodBeat.o(94581);
                }
              });
            }
            AppMethodBeat.o(94583);
          }
          
          public final void onError(Exception paramAnonymous2Exception)
          {
            AppMethodBeat.i(94582);
            ae.e("MicroMsg.MMSightVideoEditor", "photoEditor onError: %s", new Object[] { paramAnonymous2Exception });
            AppMethodBeat.o(94582);
          }
        });
        AppMethodBeat.o(94585);
      }
    });
    localObject = new ViewGroup.MarginLayoutParams(-1, -1);
    if (com.tencent.mm.ui.ar.jY(this.fNT)) {
      ((ViewGroup.MarginLayoutParams)localObject).height = (com.tencent.mm.plugin.mmsight.d.dpC().y - Math.max(com.tencent.mm.ui.ar.en(this.fNT), com.tencent.mm.ui.ar.jZ(this.fNT)));
    }
    this.whK.addView(this.whM, (ViewGroup.LayoutParams)localObject);
    this.whM.setSelectedFeatureListener(new w()
    {
      public final void a(g paramAnonymousg)
      {
        AppMethodBeat.i(94598);
        ae.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedFeature] features:%s", new Object[] { paramAnonymousg.name() });
        if (paramAnonymousg == g.cSs) {
          b.i(b.this);
        }
        AppMethodBeat.o(94598);
      }
      
      public final void a(g paramAnonymousg, int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(169419);
        ae.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymousg.name(), Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(169419);
      }
      
      public final void bY(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94600);
        if (paramAnonymousBoolean)
        {
          b.e(b.this).showVKB();
          AppMethodBeat.o(94600);
          return;
        }
        b.e(b.this).hideVKB(b.j(b.this));
        AppMethodBeat.o(94600);
      }
    });
    this.wdw.setCancelButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94603);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightVideoEditor$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((!b.k(b.this)) && (b.d(b.this) <= b.l(b.this).duration))
        {
          b.a(b.this, b.b(b.this, -1));
          b.m(b.this).drk();
          b.a(b.this, b.m(b.this).wjy);
          b.n(b.this);
        }
        if (!b.o(b.this)) {
          if (b.a(b.this) != null) {
            com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94601);
                b.a(b.this).dqC();
                AppMethodBeat.o(94601);
              }
            });
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/ui/MMSightVideoEditor$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(94603);
          return;
          b.p(b.this);
          if ((!b.k(b.this)) && (b.q(b.this)) && (b.a(b.this) != null)) {
            com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94602);
                b.a(b.this).dqC();
                AppMethodBeat.o(94602);
              }
            });
          }
        }
      }
    });
    this.wdw.setFinishButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94604);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightVideoEditor$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (!b.o(b.this)) {
          b.r(b.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/ui/MMSightVideoEditor$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(94604);
          return;
          b.p(b.this);
          if ((b.s(b.this) >= 0) && (b.c(b.this) > 0)) {
            b.t(b.this);
          }
        }
      }
    });
    if (this.whT)
    {
      this.wdw.setVisibility(0);
      this.wdw.bringToFront();
      this.wdw.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(94605);
          b.u(b.this).setFooterVisible(false);
          b.u(b.this).setActionBarVisible(false);
          b.u(b.this).setActivated(false);
          b.i(b.this);
          AppMethodBeat.o(94605);
        }
      });
    }
    AppMethodBeat.o(94614);
  }
  
  private void dqV()
  {
    AppMethodBeat.i(94615);
    this.wdv.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
    this.wdw.animate().alpha(0.0F).setDuration(100L).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94588);
        b.m(b.this).setVisibility(8);
        b.m(b.this).setAlpha(1.0F);
        AppMethodBeat.o(94588);
      }
    });
    this.whM.setFooterVisible(true);
    this.whM.setAutoShowFooterAndBar(true);
    this.whM.setActionBarVisible(true);
    this.whM.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
    this.whU = false;
    AppMethodBeat.o(94615);
  }
  
  private void dqW()
  {
    AppMethodBeat.i(94616);
    com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94597);
        if (b.v(b.this) != null) {
          b.v(b.this).dismiss();
        }
        if (b.a(b.this) != null) {
          b.a(b.this).dqB();
        }
        AppMethodBeat.o(94597);
      }
    });
    AppMethodBeat.o(94616);
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt, String paramString, VideoSeekBarEditorView paramVideoSeekBarEditorView, VideoPlayerTextureView paramVideoPlayerTextureView, ViewGroup paramViewGroup, VideoTransPara paramVideoTransPara, boolean paramBoolean)
  {
    AppMethodBeat.i(94613);
    this.vZX = paramVideoTransPara;
    if (this.vZX != null) {
      if (this.vZX.duration > 0) {}
    }
    for (this.vZX.duration = 10000;; this.vZX.duration = 10000)
    {
      this.scene = paramInt;
      this.videoPath = paramString;
      this.wdw = paramVideoSeekBarEditorView;
      this.wdv = paramVideoPlayerTextureView;
      this.whK = paramViewGroup;
      this.fNT = paramMMActivity;
      this.whT = paramBoolean;
      this.whW = new com.tencent.mm.plugin.mmsight.a.a.b(paramInt);
      this.whE = paramVideoSeekBarEditorView.wjy;
      this.whE.setVideoTransPara(this.vZX);
      dqU();
      AppMethodBeat.o(94613);
      return;
      ae.e("MicroMsg.MMSightVideoEditor", "video trans para is null!!!");
      this.vZX = new VideoTransPara();
    }
  }
  
  public final void oE(boolean paramBoolean)
  {
    AppMethodBeat.i(94618);
    x(paramBoolean, "");
    AppMethodBeat.o(94618);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(94620);
    if (!this.whY)
    {
      AppMethodBeat.o(94620);
      return false;
    }
    if (this.whU)
    {
      dqV();
      AppMethodBeat.o(94620);
      return true;
    }
    if (this.whL != null)
    {
      boolean bool = this.whL.Kc();
      AppMethodBeat.o(94620);
      return bool;
    }
    AppMethodBeat.o(94620);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(94617);
    try
    {
      if (this.whJ != null)
      {
        this.whJ.stopTimer();
        this.whJ = null;
      }
      if (this.whE != null) {
        this.whE.release();
      }
      if (this.whL != null) {
        this.whL.onDestroy();
      }
      if (this.whK != null) {
        this.whK.removeView(this.whM);
      }
      if (this.wdw != null) {
        this.wdw.drk();
      }
      this.whF = false;
      k.wcg.ayL();
      AppMethodBeat.o(94617);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.MMSightVideoEditor", localException, "release error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94617);
    }
  }
  
  public final void x(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(94619);
    try
    {
      this.whW.hmD = paramBoolean;
      if (this.whL == null)
      {
        ae.e("MicroMsg.MMSightVideoEditor", "[report] null == photoEditor");
        AppMethodBeat.o(94619);
        return;
      }
      u localu = this.whL.Kd();
      this.whW.wdj = localu.Ll();
      this.whW.wdk = localu.Lk();
      this.whW.wdm = localu.Ln();
      this.whW.fKl = localu.Lo();
      this.whW.wdn = localu.Lq();
      this.whW.textColor = localu.getTextColor();
      com.tencent.mm.plugin.mmsight.a.a.a(this.whW, paramString);
      AppMethodBeat.o(94619);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(94619);
    }
  }
  
  public static abstract interface a
  {
    public abstract void dqB();
    
    public abstract void dqC();
    
    public abstract void onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b
 * JD-Core Version:    0.7.0.1
 */