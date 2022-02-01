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
import com.tencent.mm.media.h.d.a;
import com.tencent.mm.media.h.d.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.a.j;
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
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class b
{
  private static int foV;
  private static final Object tJS;
  private p fqw;
  private MMActivity imP;
  String md5;
  public int scene;
  private VideoTransPara tCr;
  private VideoPlayerTextureView tFN;
  private VideoSeekBarEditorView tFO;
  private RecyclerThumbSeekBar tJH;
  private boolean tJI = false;
  private int tJJ = -1;
  public int tJK = -1;
  public int tJL = -1;
  private av tJM;
  private ViewGroup tJN;
  private y tJO;
  private com.tencent.mm.api.e tJP;
  private com.tencent.mm.plugin.mmsight.api.a tJQ;
  private com.tencent.mm.media.h.d tJR;
  public a tJT;
  private boolean tJU = false;
  public boolean tJV = false;
  private boolean tJW = false;
  private boolean tJX = false;
  public int tJZ = -1;
  private com.tencent.mm.plugin.mmsight.a.a.b tKa;
  public boolean tKb = false;
  public boolean tKc = true;
  public String videoOutputPath = null;
  private String videoPath;
  
  static
  {
    AppMethodBeat.i(94627);
    tJS = new Object();
    AppMethodBeat.o(94627);
  }
  
  private void cQO()
  {
    AppMethodBeat.i(94614);
    this.tJO = y.cJB.IO();
    Object localObject = this.tJO;
    y.a.a locala = new y.a.a();
    locala.cJD = false;
    locala.cJG = true;
    locala.cJC = y.c.cJI;
    locala.cJH = new Rect(this.tFN.getLeft(), this.tFN.getTop(), this.tFN.getRight(), this.tFN.getBottom());
    ((y)localObject).a(locala.Ke());
    this.tJP = this.tJO.bf(this.tJN.getContext());
    this.tJP.setActionBarCallback(new com.tencent.mm.api.i()
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
              b.a(b.this).cQy();
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
                b.a(b.this, com.tencent.mm.vfs.i.aEN(b.g(b.this)));
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(94579);
                    b.a(b.this).cQx();
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
    if (ap.ju(this.imP)) {
      ((ViewGroup.MarginLayoutParams)localObject).height = (com.tencent.mm.plugin.mmsight.d.cPz().y - Math.max(ap.eb(this.imP), ap.jv(this.imP)));
    }
    this.tJN.addView(this.tJP, (ViewGroup.LayoutParams)localObject);
    this.tJP.setSelectedFeatureListener(new w()
    {
      public final void a(g paramAnonymousg)
      {
        AppMethodBeat.i(94598);
        ad.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedFeature] features:%s", new Object[] { paramAnonymousg.name() });
        if (paramAnonymousg == g.cJx) {
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
      
      public final void bV(boolean paramAnonymousBoolean)
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
    this.tFO.setCancelButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94603);
        if ((!b.k(b.this)) && (b.d(b.this) <= b.l(b.this).duration))
        {
          b.a(b.this, b.b(b.this, -1));
          b.m(b.this).cRe();
          b.a(b.this, b.m(b.this).tLG);
          b.n(b.this);
        }
        if (!b.o(b.this))
        {
          if (b.a(b.this) != null)
          {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94601);
                b.a(b.this).cQy();
                AppMethodBeat.o(94601);
              }
            });
            AppMethodBeat.o(94603);
          }
        }
        else
        {
          b.p(b.this);
          if ((!b.k(b.this)) && (b.q(b.this)) && (b.a(b.this) != null)) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94602);
                b.a(b.this).cQy();
                AppMethodBeat.o(94602);
              }
            });
          }
        }
        AppMethodBeat.o(94603);
      }
    });
    this.tFO.setFinishButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94604);
        if (!b.o(b.this))
        {
          b.r(b.this);
          AppMethodBeat.o(94604);
          return;
        }
        b.p(b.this);
        if ((b.s(b.this) >= 0) && (b.c(b.this) > 0)) {
          b.t(b.this);
        }
        AppMethodBeat.o(94604);
      }
    });
    if (this.tJW)
    {
      this.tFO.setVisibility(0);
      this.tFO.bringToFront();
      this.tFO.post(new Runnable()
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
  
  private void cQP()
  {
    AppMethodBeat.i(94615);
    this.tFN.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
    this.tFO.animate().alpha(0.0F).setDuration(100L).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94588);
        b.m(b.this).setVisibility(8);
        b.m(b.this).setAlpha(1.0F);
        AppMethodBeat.o(94588);
      }
    });
    this.tJP.setFooterVisible(true);
    this.tJP.setAutoShowFooterAndBar(true);
    this.tJP.setActionBarVisible(true);
    this.tJP.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
    this.tJX = false;
    AppMethodBeat.o(94615);
  }
  
  private void cQQ()
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
          b.a(b.this).cQx();
        }
        AppMethodBeat.o(94597);
      }
    });
    AppMethodBeat.o(94616);
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt, String paramString, VideoSeekBarEditorView paramVideoSeekBarEditorView, VideoPlayerTextureView paramVideoPlayerTextureView, ViewGroup paramViewGroup, VideoTransPara paramVideoTransPara, boolean paramBoolean)
  {
    AppMethodBeat.i(94613);
    this.tCr = paramVideoTransPara;
    if (this.tCr != null) {
      if (this.tCr.duration > 0) {}
    }
    for (this.tCr.duration = 10000;; this.tCr.duration = 10000)
    {
      this.scene = paramInt;
      this.videoPath = paramString;
      this.tFO = paramVideoSeekBarEditorView;
      this.tFN = paramVideoPlayerTextureView;
      this.tJN = paramViewGroup;
      this.imP = paramMMActivity;
      this.tJW = paramBoolean;
      this.tKa = new com.tencent.mm.plugin.mmsight.a.a.b(paramInt);
      this.tJH = paramVideoSeekBarEditorView.tLG;
      this.tJH.setVideoTransPara(this.tCr);
      cQO();
      AppMethodBeat.o(94613);
      return;
      ad.e("MicroMsg.MMSightVideoEditor", "video trans para is null!!!");
      this.tCr = new VideoTransPara();
    }
  }
  
  public final void nl(boolean paramBoolean)
  {
    AppMethodBeat.i(94618);
    r(paramBoolean, "");
    AppMethodBeat.o(94618);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(94620);
    if (!this.tKc)
    {
      AppMethodBeat.o(94620);
      return false;
    }
    if (this.tJX)
    {
      cQP();
      AppMethodBeat.o(94620);
      return true;
    }
    if (this.tJO != null)
    {
      boolean bool = this.tJO.IL();
      AppMethodBeat.o(94620);
      return bool;
    }
    AppMethodBeat.o(94620);
    return false;
  }
  
  public final void r(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(94619);
    try
    {
      this.tKa.gqP = paramBoolean;
      if (this.tJO == null)
      {
        ad.e("MicroMsg.MMSightVideoEditor", "[report] null == photoEditor");
        AppMethodBeat.o(94619);
        return;
      }
      u localu = this.tJO.IM();
      this.tKa.tFB = localu.JU();
      this.tKa.tFC = localu.JT();
      this.tKa.tFE = localu.JW();
      this.tKa.fmF = localu.JX();
      this.tKa.tFF = localu.JZ();
      this.tKa.textColor = localu.getTextColor();
      com.tencent.mm.plugin.mmsight.a.a.a(this.tKa, paramString);
      AppMethodBeat.o(94619);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(94619);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(94617);
    try
    {
      if (this.tJM != null)
      {
        this.tJM.stopTimer();
        this.tJM = null;
      }
      if (this.tJH != null) {
        this.tJH.release();
      }
      if (this.tJO != null) {
        this.tJO.onDestroy();
      }
      if (this.tJN != null) {
        this.tJN.removeView(this.tJP);
      }
      if (this.tFO != null) {
        this.tFO.cRe();
      }
      this.tJI = false;
      j.tEA.aoS();
      AppMethodBeat.o(94617);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.MMSightVideoEditor", localException, "release error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94617);
    }
  }
  
  public static abstract interface a
  {
    public abstract void cQx();
    
    public abstract void cQy();
    
    public abstract void onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b
 * JD-Core Version:    0.7.0.1
 */