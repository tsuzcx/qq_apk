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
import com.tencent.mm.api.ab;
import com.tencent.mm.api.ab.a.a;
import com.tencent.mm.api.ab.b;
import com.tencent.mm.api.ab.c;
import com.tencent.mm.api.x;
import com.tencent.mm.api.z;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.media.i.d.a;
import com.tencent.mm.media.i.d.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.mmsight.segment.c.a;
import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.plugin.mmsight.segment.n;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.plugin.w.a.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.s;

public final class b
{
  private static final Object Fhl;
  private static int iWt;
  private VideoTransPara EZB;
  private VideoPlayerTextureView Fdy;
  private VideoSeekBarEditorView Fdz;
  private RecyclerThumbSeekBar Fha;
  private boolean Fhb = false;
  private int Fhc = -1;
  public int Fhd = -1;
  public int Fhe = -1;
  private MTimerHandler Fhf;
  private ViewGroup Fhg;
  private ab Fhh;
  private com.tencent.mm.api.e Fhi;
  private com.tencent.mm.plugin.mmsight.api.a Fhj;
  private com.tencent.mm.media.i.d Fhk;
  public a Fhm;
  private boolean Fhn = false;
  public boolean Fho = false;
  private boolean Fhp = false;
  private boolean Fhq = false;
  public int Fhr = -1;
  private com.tencent.mm.plugin.mmsight.a.a.b Fhs;
  public boolean Fht = false;
  public boolean Fhu = true;
  private MMActivity iXq;
  private s iYE;
  String md5;
  public int scene;
  public String videoOutputPath = null;
  private String videoPath;
  
  static
  {
    AppMethodBeat.i(94627);
    Fhl = new Object();
    AppMethodBeat.o(94627);
  }
  
  private void eUx()
  {
    AppMethodBeat.i(94614);
    this.Fhh = ab.fax.YG();
    Object localObject = this.Fhh;
    ab.a.a locala = new ab.a.a();
    locala.faz = false;
    locala.faD = true;
    locala.fay = ab.c.faF;
    locala.faE = new Rect(this.Fdy.getLeft(), this.Fdy.getTop(), this.Fdy.getRight(), this.Fdy.getBottom());
    ((ab)localObject).a(locala.aae());
    this.Fhi = this.Fhh.bA(this.Fhg.getContext());
    this.Fhi.setActionBarCallback(new com.tencent.mm.api.j()
    {
      public final void onExit()
      {
        AppMethodBeat.i(94586);
        Log.i("MicroMsg.MMSightVideoEditor", "photoEditor onExit");
        b.this.release();
        if (b.a(b.this) != null) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(94584);
              b.a(b.this).eUb();
              AppMethodBeat.o(94584);
            }
          });
        }
        AppMethodBeat.o(94586);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(94585);
        Log.i("MicroMsg.MMSightVideoEditor", "photoEditor onFinish");
        b.h(b.this).a(new com.tencent.mm.api.u()
        {
          public final void a(final Bitmap paramAnonymous2Bitmap, boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(94583);
            Log.i("MicroMsg.MMSightVideoEditor", "photoEditor onSuccess: %s isNever：%s", new Object[] { paramAnonymous2Bitmap, Boolean.valueOf(paramAnonymous2Boolean) });
            if (paramAnonymous2Boolean)
            {
              if ((paramAnonymous2Bitmap != null) && (!paramAnonymous2Bitmap.isRecycled())) {
                paramAnonymous2Bitmap.recycle();
              }
              if ((b.a(b.this) != null) && (!b.b(b.this)))
              {
                if ((b.c(b.this) > 0) && (b.d(b.this) > 0) && (b.c(b.this) <= b.d(b.this)))
                {
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(94578);
                      b.a(b.this, com.tencent.mm.ui.base.h.a(b.e(b.this), b.e(b.this).getString(a.h.mmsight_video_edit_processing), false, null));
                      b.f(b.this).pause();
                      b.a(b.this, null);
                      AppMethodBeat.o(94578);
                    }
                  });
                  AppMethodBeat.o(94583);
                  return;
                }
                b.a(b.this, com.tencent.mm.vfs.u.buc(b.g(b.this)));
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(94579);
                    b.a(b.this).eUa();
                    AppMethodBeat.o(94579);
                  }
                });
                AppMethodBeat.o(94583);
                return;
              }
              if (b.b(b.this))
              {
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(94580);
                    b.a(b.this, com.tencent.mm.ui.base.h.a(b.e(b.this), b.e(b.this).getString(a.h.mmsight_video_edit_processing), false, null));
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
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(94581);
                  b.a(b.this, com.tencent.mm.ui.base.h.a(b.e(b.this), b.e(b.this).getString(a.h.mmsight_video_edit_processing), false, null));
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
            Log.e("MicroMsg.MMSightVideoEditor", "photoEditor onError: %s", new Object[] { paramAnonymous2Exception });
            AppMethodBeat.o(94582);
          }
        });
        AppMethodBeat.o(94585);
      }
    });
    localObject = new ViewGroup.MarginLayoutParams(-1, -1);
    if (ax.av(this.iXq)) {
      ((ViewGroup.MarginLayoutParams)localObject).height = (com.tencent.mm.plugin.mmsight.d.eSY().y - Math.max(ax.aB(this.iXq), ax.az(this.iXq)));
    }
    this.Fhg.addView(this.Fhi, (ViewGroup.LayoutParams)localObject);
    this.Fhi.setSelectedFeatureListener(new z()
    {
      public final void a(com.tencent.mm.api.h paramAnonymoush)
      {
        AppMethodBeat.i(94598);
        Log.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedFeature] features:%s", new Object[] { paramAnonymoush.name() });
        if (paramAnonymoush == com.tencent.mm.api.h.fas) {
          b.i(b.this);
        }
        AppMethodBeat.o(94598);
      }
      
      public final void a(com.tencent.mm.api.h paramAnonymoush, int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(169419);
        Log.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymoush.name(), Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(169419);
      }
      
      public final void dd(boolean paramAnonymousBoolean)
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
    this.Fdz.setCancelButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94603);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mmsight/ui/MMSightVideoEditor$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((!b.k(b.this)) && (b.d(b.this) <= b.l(b.this).duration))
        {
          b.a(b.this, b.b(b.this, -1));
          b.m(b.this).eUN();
          b.a(b.this, b.m(b.this).FiW);
          b.n(b.this);
        }
        if (!b.o(b.this)) {
          if (b.a(b.this) != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94601);
                b.a(b.this).eUb();
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
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94602);
                b.a(b.this).eUb();
                AppMethodBeat.o(94602);
              }
            });
          }
        }
      }
    });
    this.Fdz.setFinishButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94604);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mmsight/ui/MMSightVideoEditor$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
    if (this.Fhp)
    {
      this.Fdz.setVisibility(0);
      this.Fdz.bringToFront();
      this.Fdz.post(new Runnable()
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
  
  private void eUy()
  {
    AppMethodBeat.i(94615);
    this.Fdy.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
    this.Fdz.animate().alpha(0.0F).setDuration(100L).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94588);
        b.m(b.this).setVisibility(8);
        b.m(b.this).setAlpha(1.0F);
        AppMethodBeat.o(94588);
      }
    });
    this.Fhi.setFooterVisible(true);
    this.Fhi.setAutoShowFooterAndBar(true);
    this.Fhi.setActionBarVisible(true);
    this.Fhi.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
    this.Fhq = false;
    AppMethodBeat.o(94615);
  }
  
  private void eUz()
  {
    AppMethodBeat.i(94616);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94597);
        if (b.v(b.this) != null) {
          b.v(b.this).dismiss();
        }
        if (b.a(b.this) != null) {
          b.a(b.this).eUa();
        }
        AppMethodBeat.o(94597);
      }
    });
    AppMethodBeat.o(94616);
  }
  
  public final void D(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(94619);
    try
    {
      this.Fhs.kUn = paramBoolean;
      if (this.Fhh == null)
      {
        Log.e("MicroMsg.MMSightVideoEditor", "[report] null == photoEditor");
        AppMethodBeat.o(94619);
        return;
      }
      x localx = this.Fhh.YE();
      this.Fhs.FcE = localx.ZT();
      this.Fhs.FcF = localx.ZS();
      this.Fhs.FcH = localx.ZV();
      this.Fhs.iTI = localx.ZW();
      this.Fhs.FcI = localx.ZY();
      this.Fhs.textColor = localx.getTextColor();
      com.tencent.mm.plugin.mmsight.a.a.a(this.Fhs, paramString);
      AppMethodBeat.o(94619);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(94619);
    }
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt, String paramString, VideoSeekBarEditorView paramVideoSeekBarEditorView, VideoPlayerTextureView paramVideoPlayerTextureView, ViewGroup paramViewGroup, VideoTransPara paramVideoTransPara, boolean paramBoolean)
  {
    AppMethodBeat.i(94613);
    this.EZB = paramVideoTransPara;
    if (this.EZB != null) {
      if (this.EZB.duration > 0) {}
    }
    for (this.EZB.duration = 10000;; this.EZB.duration = 10000)
    {
      this.scene = paramInt;
      this.videoPath = paramString;
      this.Fdz = paramVideoSeekBarEditorView;
      this.Fdy = paramVideoPlayerTextureView;
      this.Fhg = paramViewGroup;
      this.iXq = paramMMActivity;
      this.Fhp = paramBoolean;
      this.Fhs = new com.tencent.mm.plugin.mmsight.a.a.b(paramInt);
      this.Fha = paramVideoSeekBarEditorView.FiW;
      this.Fha.setVideoTransPara(this.EZB);
      eUx();
      AppMethodBeat.o(94613);
      return;
      Log.e("MicroMsg.MMSightVideoEditor", "video trans para is null!!!");
      this.EZB = new VideoTransPara();
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(94620);
    if (!this.Fhu)
    {
      AppMethodBeat.o(94620);
      return false;
    }
    if (this.Fhq)
    {
      eUy();
      AppMethodBeat.o(94620);
      return true;
    }
    if (this.Fhh != null)
    {
      boolean bool = this.Fhh.YD();
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
      if (this.Fhf != null)
      {
        this.Fhf.stopTimer();
        this.Fhf = null;
      }
      if (this.Fha != null) {
        this.Fha.release();
      }
      if (this.Fhh != null) {
        this.Fhh.onDestroy();
      }
      if (this.Fhg != null) {
        this.Fhg.removeView(this.Fhi);
      }
      if (this.Fdz != null) {
        this.Fdz.eUN();
      }
      this.Fhb = false;
      com.tencent.mm.plugin.mmsight.model.a.j.FbH.baL();
      AppMethodBeat.o(94617);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMSightVideoEditor", localException, "release error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94617);
    }
  }
  
  public final void uq(boolean paramBoolean)
  {
    AppMethodBeat.i(94618);
    D(paramBoolean, "");
    AppMethodBeat.o(94618);
  }
  
  public static abstract interface a
  {
    public abstract void eUa();
    
    public abstract void eUb();
    
    public abstract void onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b
 * JD-Core Version:    0.7.0.1
 */