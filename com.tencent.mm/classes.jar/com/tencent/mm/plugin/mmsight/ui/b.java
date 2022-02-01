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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class b
{
  private static int fKU;
  private static final Object vVL;
  private MMActivity fLP;
  private p fNb;
  String md5;
  public int scene;
  private VideoTransPara vNU;
  private VideoPlayerTextureView vRr;
  private VideoSeekBarEditorView vRs;
  private RecyclerThumbSeekBar vVA;
  private boolean vVB = false;
  private int vVC = -1;
  public int vVD = -1;
  public int vVE = -1;
  private av vVF;
  private ViewGroup vVG;
  private y vVH;
  private com.tencent.mm.api.e vVI;
  private com.tencent.mm.plugin.mmsight.api.a vVJ;
  private com.tencent.mm.media.i.d vVK;
  public a vVM;
  private boolean vVN = false;
  public boolean vVO = false;
  private boolean vVP = false;
  private boolean vVQ = false;
  public int vVR = -1;
  private com.tencent.mm.plugin.mmsight.a.a.b vVS;
  public boolean vVT = false;
  public boolean vVU = true;
  public String videoOutputPath = null;
  private String videoPath;
  
  static
  {
    AppMethodBeat.i(94627);
    vVL = new Object();
    AppMethodBeat.o(94627);
  }
  
  private void dnW()
  {
    AppMethodBeat.i(94614);
    this.vVH = y.cRM.JX();
    Object localObject = this.vVH;
    y.a.a locala = new y.a.a();
    locala.cRO = false;
    locala.cRR = true;
    locala.cRN = y.c.cRT;
    locala.cRS = new Rect(this.vRr.getLeft(), this.vRr.getTop(), this.vRr.getRight(), this.vRr.getBottom());
    ((y)localObject).a(locala.Ln());
    this.vVI = this.vVH.bg(this.vVG.getContext());
    this.vVI.setActionBarCallback(new com.tencent.mm.api.i()
    {
      public final void onExit()
      {
        AppMethodBeat.i(94586);
        ad.i("MicroMsg.MMSightVideoEditor", "photoEditor onExit");
        b.this.release();
        if (b.a(b.this) != null) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(94584);
              b.a(b.this).dnE();
              AppMethodBeat.o(94584);
            }
          });
        }
        AppMethodBeat.o(94586);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(94585);
        ad.i("MicroMsg.MMSightVideoEditor", "photoEditor onFinish");
        b.h(b.this).a(new s()
        {
          public final void a(final Bitmap paramAnonymous2Bitmap, boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(94583);
            ad.i("MicroMsg.MMSightVideoEditor", "photoEditor onSuccess: %s isNever：%s", new Object[] { paramAnonymous2Bitmap, Boolean.valueOf(paramAnonymous2Boolean) });
            if (paramAnonymous2Boolean)
            {
              if ((paramAnonymous2Bitmap != null) && (!paramAnonymous2Bitmap.isRecycled())) {
                paramAnonymous2Bitmap.recycle();
              }
              if ((b.a(b.this) != null) && (!b.b(b.this)))
              {
                if ((b.c(b.this) > 0) && (b.d(b.this) > 0) && (b.c(b.this) <= b.d(b.this)))
                {
                  aq.f(new Runnable()
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
                b.a(b.this, com.tencent.mm.vfs.i.aPK(b.g(b.this)));
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(94579);
                    b.a(b.this).dnD();
                    AppMethodBeat.o(94579);
                  }
                });
                AppMethodBeat.o(94583);
                return;
              }
              if (b.b(b.this))
              {
                aq.f(new Runnable()
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
              aq.f(new Runnable()
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
            ad.e("MicroMsg.MMSightVideoEditor", "photoEditor onError: %s", new Object[] { paramAnonymous2Exception });
            AppMethodBeat.o(94582);
          }
        });
        AppMethodBeat.o(94585);
      }
    });
    localObject = new ViewGroup.MarginLayoutParams(-1, -1);
    if (ar.jR(this.fLP)) {
      ((ViewGroup.MarginLayoutParams)localObject).height = (com.tencent.mm.plugin.mmsight.d.dmE().y - Math.max(ar.ej(this.fLP), ar.jS(this.fLP)));
    }
    this.vVG.addView(this.vVI, (ViewGroup.LayoutParams)localObject);
    this.vVI.setSelectedFeatureListener(new w()
    {
      public final void a(g paramAnonymousg)
      {
        AppMethodBeat.i(94598);
        ad.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedFeature] features:%s", new Object[] { paramAnonymousg.name() });
        if (paramAnonymousg == g.cRI) {
          b.i(b.this);
        }
        AppMethodBeat.o(94598);
      }
      
      public final void a(g paramAnonymousg, int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(169419);
        ad.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymousg.name(), Integer.valueOf(paramAnonymousInt) });
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
    this.vRs.setCancelButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94603);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightVideoEditor$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((!b.k(b.this)) && (b.d(b.this) <= b.l(b.this).duration))
        {
          b.a(b.this, b.b(b.this, -1));
          b.m(b.this).dom();
          b.a(b.this, b.m(b.this).vXu);
          b.n(b.this);
        }
        if (!b.o(b.this)) {
          if (b.a(b.this) != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94601);
                b.a(b.this).dnE();
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
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94602);
                b.a(b.this).dnE();
                AppMethodBeat.o(94602);
              }
            });
          }
        }
      }
    });
    this.vRs.setFinishButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94604);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightVideoEditor$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    if (this.vVP)
    {
      this.vRs.setVisibility(0);
      this.vRs.bringToFront();
      this.vRs.post(new Runnable()
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
  
  private void dnX()
  {
    AppMethodBeat.i(94615);
    this.vRr.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
    this.vRs.animate().alpha(0.0F).setDuration(100L).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94588);
        b.m(b.this).setVisibility(8);
        b.m(b.this).setAlpha(1.0F);
        AppMethodBeat.o(94588);
      }
    });
    this.vVI.setFooterVisible(true);
    this.vVI.setAutoShowFooterAndBar(true);
    this.vVI.setActionBarVisible(true);
    this.vVI.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
    this.vVQ = false;
    AppMethodBeat.o(94615);
  }
  
  private void dnY()
  {
    AppMethodBeat.i(94616);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94597);
        if (b.v(b.this) != null) {
          b.v(b.this).dismiss();
        }
        if (b.a(b.this) != null) {
          b.a(b.this).dnD();
        }
        AppMethodBeat.o(94597);
      }
    });
    AppMethodBeat.o(94616);
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt, String paramString, VideoSeekBarEditorView paramVideoSeekBarEditorView, VideoPlayerTextureView paramVideoPlayerTextureView, ViewGroup paramViewGroup, VideoTransPara paramVideoTransPara, boolean paramBoolean)
  {
    AppMethodBeat.i(94613);
    this.vNU = paramVideoTransPara;
    if (this.vNU != null) {
      if (this.vNU.duration > 0) {}
    }
    for (this.vNU.duration = 10000;; this.vNU.duration = 10000)
    {
      this.scene = paramInt;
      this.videoPath = paramString;
      this.vRs = paramVideoSeekBarEditorView;
      this.vRr = paramVideoPlayerTextureView;
      this.vVG = paramViewGroup;
      this.fLP = paramMMActivity;
      this.vVP = paramBoolean;
      this.vVS = new com.tencent.mm.plugin.mmsight.a.a.b(paramInt);
      this.vVA = paramVideoSeekBarEditorView.vXu;
      this.vVA.setVideoTransPara(this.vNU);
      dnW();
      AppMethodBeat.o(94613);
      return;
      ad.e("MicroMsg.MMSightVideoEditor", "video trans para is null!!!");
      this.vNU = new VideoTransPara();
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(94620);
    if (!this.vVU)
    {
      AppMethodBeat.o(94620);
      return false;
    }
    if (this.vVQ)
    {
      dnX();
      AppMethodBeat.o(94620);
      return true;
    }
    if (this.vVH != null)
    {
      boolean bool = this.vVH.JU();
      AppMethodBeat.o(94620);
      return bool;
    }
    AppMethodBeat.o(94620);
    return false;
  }
  
  public final void oz(boolean paramBoolean)
  {
    AppMethodBeat.i(94618);
    w(paramBoolean, "");
    AppMethodBeat.o(94618);
  }
  
  public final void release()
  {
    AppMethodBeat.i(94617);
    try
    {
      if (this.vVF != null)
      {
        this.vVF.stopTimer();
        this.vVF = null;
      }
      if (this.vVA != null) {
        this.vVA.release();
      }
      if (this.vVH != null) {
        this.vVH.onDestroy();
      }
      if (this.vVG != null) {
        this.vVG.removeView(this.vVI);
      }
      if (this.vRs != null) {
        this.vRs.dom();
      }
      this.vVB = false;
      k.vQc.ayw();
      AppMethodBeat.o(94617);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.MMSightVideoEditor", localException, "release error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94617);
    }
  }
  
  public final void w(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(94619);
    try
    {
      this.vVS.hjP = paramBoolean;
      if (this.vVH == null)
      {
        ad.e("MicroMsg.MMSightVideoEditor", "[report] null == photoEditor");
        AppMethodBeat.o(94619);
        return;
      }
      u localu = this.vVH.JV();
      this.vVS.vRf = localu.Ld();
      this.vVS.vRg = localu.Lc();
      this.vVS.vRi = localu.Lf();
      this.vVS.fIh = localu.Lg();
      this.vVS.vRj = localu.Li();
      this.vVS.textColor = localu.getTextColor();
      com.tencent.mm.plugin.mmsight.a.a.a(this.vVS, paramString);
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
    public abstract void dnD();
    
    public abstract void dnE();
    
    public abstract void onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b
 * JD-Core Version:    0.7.0.1
 */