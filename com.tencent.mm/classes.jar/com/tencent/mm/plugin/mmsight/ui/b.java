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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class b
{
  private static int fsu;
  private static final Object uSB;
  private p fua;
  private MMActivity iMV;
  String md5;
  public int scene;
  private y sgl;
  private VideoTransPara uKO;
  private VideoPlayerTextureView uOi;
  private VideoSeekBarEditorView uOj;
  private com.tencent.mm.media.h.d uSA;
  public a uSC;
  private boolean uSD = false;
  public boolean uSE = false;
  private boolean uSF = false;
  private boolean uSG = false;
  public int uSH = -1;
  private com.tencent.mm.plugin.mmsight.a.a.b uSI;
  public boolean uSJ = false;
  public boolean uSK = true;
  private RecyclerThumbSeekBar uSr;
  private boolean uSs = false;
  private int uSt = -1;
  public int uSu = -1;
  public int uSv = -1;
  private au uSw;
  private ViewGroup uSx;
  private com.tencent.mm.api.e uSy;
  private com.tencent.mm.plugin.mmsight.api.a uSz;
  public String videoOutputPath = null;
  private String videoPath;
  
  static
  {
    AppMethodBeat.i(94627);
    uSB = new Object();
    AppMethodBeat.o(94627);
  }
  
  private void deA()
  {
    AppMethodBeat.i(94616);
    com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94597);
        if (b.v(b.this) != null) {
          b.v(b.this).dismiss();
        }
        if (b.a(b.this) != null) {
          b.a(b.this).def();
        }
        AppMethodBeat.o(94597);
      }
    });
    AppMethodBeat.o(94616);
  }
  
  private void dey()
  {
    AppMethodBeat.i(94614);
    this.sgl = y.cGI.Ix();
    Object localObject = this.sgl;
    y.a.a locala = new y.a.a();
    locala.cGK = false;
    locala.cGN = true;
    locala.cGJ = y.c.cGP;
    locala.cGO = new Rect(this.uOi.getLeft(), this.uOi.getTop(), this.uOi.getRight(), this.uOi.getBottom());
    ((y)localObject).a(locala.JO());
    this.uSy = this.sgl.bg(this.uSx.getContext());
    this.uSy.setActionBarCallback(new com.tencent.mm.api.i()
    {
      public final void onExit()
      {
        AppMethodBeat.i(94586);
        ac.i("MicroMsg.MMSightVideoEditor", "photoEditor onExit");
        b.this.release();
        if (b.a(b.this) != null) {
          com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(94584);
              b.a(b.this).deg();
              AppMethodBeat.o(94584);
            }
          });
        }
        AppMethodBeat.o(94586);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(94585);
        ac.i("MicroMsg.MMSightVideoEditor", "photoEditor onFinish");
        b.h(b.this).a(new s()
        {
          public final void a(final Bitmap paramAnonymous2Bitmap, boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(94583);
            ac.i("MicroMsg.MMSightVideoEditor", "photoEditor onSuccess: %s isNever：%s", new Object[] { paramAnonymous2Bitmap, Boolean.valueOf(paramAnonymous2Boolean) });
            if (paramAnonymous2Boolean)
            {
              if ((paramAnonymous2Bitmap != null) && (!paramAnonymous2Bitmap.isRecycled())) {
                paramAnonymous2Bitmap.recycle();
              }
              if ((b.a(b.this) != null) && (!b.b(b.this)))
              {
                if ((b.c(b.this) > 0) && (b.d(b.this) > 0) && (b.c(b.this) <= b.d(b.this)))
                {
                  com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
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
                b.a(b.this, com.tencent.mm.vfs.i.aKe(b.g(b.this)));
                com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(94579);
                    b.a(b.this).def();
                    AppMethodBeat.o(94579);
                  }
                });
                AppMethodBeat.o(94583);
                return;
              }
              if (b.b(b.this))
              {
                com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
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
              com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
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
            ac.e("MicroMsg.MMSightVideoEditor", "photoEditor onError: %s", new Object[] { paramAnonymous2Exception });
            AppMethodBeat.o(94582);
          }
        });
        AppMethodBeat.o(94585);
      }
    });
    localObject = new ViewGroup.MarginLayoutParams(-1, -1);
    if (com.tencent.mm.ui.ap.jF(this.iMV)) {
      ((ViewGroup.MarginLayoutParams)localObject).height = (com.tencent.mm.plugin.mmsight.d.ddi().y - Math.max(com.tencent.mm.ui.ap.ej(this.iMV), com.tencent.mm.ui.ap.jG(this.iMV)));
    }
    this.uSx.addView(this.uSy, (ViewGroup.LayoutParams)localObject);
    this.uSy.setSelectedFeatureListener(new w()
    {
      public final void a(g paramAnonymousg)
      {
        AppMethodBeat.i(94598);
        ac.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedFeature] features:%s", new Object[] { paramAnonymousg.name() });
        if (paramAnonymousg == g.cGE) {
          b.i(b.this);
        }
        AppMethodBeat.o(94598);
      }
      
      public final void a(g paramAnonymousg, int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(169419);
        ac.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymousg.name(), Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(169419);
      }
      
      public final void bW(boolean paramAnonymousBoolean)
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
    this.uOj.setCancelButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94603);
        if ((!b.k(b.this)) && (b.d(b.this) <= b.l(b.this).duration))
        {
          b.a(b.this, b.b(b.this, -1));
          b.m(b.this).deO();
          b.a(b.this, b.m(b.this).uUk);
          b.n(b.this);
        }
        if (!b.o(b.this))
        {
          if (b.a(b.this) != null)
          {
            com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94601);
                b.a(b.this).deg();
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
            com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94602);
                b.a(b.this).deg();
                AppMethodBeat.o(94602);
              }
            });
          }
        }
        AppMethodBeat.o(94603);
      }
    });
    this.uOj.setFinishButtonClickListener(new View.OnClickListener()
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
    if (this.uSF)
    {
      this.uOj.setVisibility(0);
      this.uOj.bringToFront();
      this.uOj.post(new Runnable()
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
  
  private void dez()
  {
    AppMethodBeat.i(94615);
    this.uOi.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
    this.uOj.animate().alpha(0.0F).setDuration(100L).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94588);
        b.m(b.this).setVisibility(8);
        b.m(b.this).setAlpha(1.0F);
        AppMethodBeat.o(94588);
      }
    });
    this.uSy.setFooterVisible(true);
    this.uSy.setAutoShowFooterAndBar(true);
    this.uSy.setActionBarVisible(true);
    this.uSy.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
    this.uSG = false;
    AppMethodBeat.o(94615);
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt, String paramString, VideoSeekBarEditorView paramVideoSeekBarEditorView, VideoPlayerTextureView paramVideoPlayerTextureView, ViewGroup paramViewGroup, VideoTransPara paramVideoTransPara, boolean paramBoolean)
  {
    AppMethodBeat.i(94613);
    this.uKO = paramVideoTransPara;
    if (this.uKO != null) {
      if (this.uKO.duration > 0) {}
    }
    for (this.uKO.duration = 10000;; this.uKO.duration = 10000)
    {
      this.scene = paramInt;
      this.videoPath = paramString;
      this.uOj = paramVideoSeekBarEditorView;
      this.uOi = paramVideoPlayerTextureView;
      this.uSx = paramViewGroup;
      this.iMV = paramMMActivity;
      this.uSF = paramBoolean;
      this.uSI = new com.tencent.mm.plugin.mmsight.a.a.b(paramInt);
      this.uSr = paramVideoSeekBarEditorView.uUk;
      this.uSr.setVideoTransPara(this.uKO);
      dey();
      AppMethodBeat.o(94613);
      return;
      ac.e("MicroMsg.MMSightVideoEditor", "video trans para is null!!!");
      this.uKO = new VideoTransPara();
    }
  }
  
  public final void of(boolean paramBoolean)
  {
    AppMethodBeat.i(94618);
    s(paramBoolean, "");
    AppMethodBeat.o(94618);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(94620);
    if (!this.uSK)
    {
      AppMethodBeat.o(94620);
      return false;
    }
    if (this.uSG)
    {
      dez();
      AppMethodBeat.o(94620);
      return true;
    }
    if (this.sgl != null)
    {
      boolean bool = this.sgl.Iu();
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
      if (this.uSw != null)
      {
        this.uSw.stopTimer();
        this.uSw = null;
      }
      if (this.uSr != null) {
        this.uSr.release();
      }
      if (this.sgl != null) {
        this.sgl.onDestroy();
      }
      if (this.uSx != null) {
        this.uSx.removeView(this.uSy);
      }
      if (this.uOj != null) {
        this.uOj.deO();
      }
      this.uSs = false;
      j.uMV.avJ();
      AppMethodBeat.o(94617);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MMSightVideoEditor", localException, "release error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94617);
    }
  }
  
  public final void s(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(94619);
    try
    {
      this.uSI.gRx = paramBoolean;
      if (this.sgl == null)
      {
        ac.e("MicroMsg.MMSightVideoEditor", "[report] null == photoEditor");
        AppMethodBeat.o(94619);
        return;
      }
      u localu = this.sgl.Iv();
      this.uSI.uNW = localu.JE();
      this.uSI.uNX = localu.JD();
      this.uSI.uNZ = localu.JG();
      this.uSI.fqa = localu.JH();
      this.uSI.uOa = localu.JJ();
      this.uSI.textColor = localu.getTextColor();
      com.tencent.mm.plugin.mmsight.a.a.a(this.uSI, paramString);
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
    public abstract void def();
    
    public abstract void deg();
    
    public abstract void onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b
 * JD-Core Version:    0.7.0.1
 */