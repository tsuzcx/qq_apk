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
import com.tencent.mm.api.j;
import com.tencent.mm.api.u;
import com.tencent.mm.api.x;
import com.tencent.mm.api.z;
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
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.vfs.s;

public final class b
{
  private static int gsi;
  private static final Object zCp;
  private MMActivity gte;
  private q gut;
  String md5;
  public int scene;
  public String videoOutputPath = null;
  private String videoPath;
  private RecyclerThumbSeekBar zCe;
  private boolean zCf = false;
  private int zCg = -1;
  public int zCh = -1;
  public int zCi = -1;
  private MTimerHandler zCj;
  private ViewGroup zCk;
  private ab zCl;
  private com.tencent.mm.api.e zCm;
  private com.tencent.mm.plugin.mmsight.api.a zCn;
  private com.tencent.mm.media.i.d zCo;
  public a zCq;
  private boolean zCr = false;
  public boolean zCs = false;
  private boolean zCt = false;
  private boolean zCu = false;
  public int zCv = -1;
  private com.tencent.mm.plugin.mmsight.a.a.b zCw;
  public boolean zCx = false;
  public boolean zCy = true;
  private VideoTransPara zua;
  private VideoPlayerTextureView zyd;
  private VideoSeekBarEditorView zye;
  
  static
  {
    AppMethodBeat.i(94627);
    zCp = new Object();
    AppMethodBeat.o(94627);
  }
  
  private void ekO()
  {
    AppMethodBeat.i(94614);
    this.zCl = ab.diQ.Uo();
    Object localObject = this.zCl;
    ab.a.a locala = new ab.a.a();
    locala.diS = false;
    locala.diW = true;
    locala.diR = ab.c.diY;
    locala.diX = new Rect(this.zyd.getLeft(), this.zyd.getTop(), this.zyd.getRight(), this.zyd.getBottom());
    ((ab)localObject).a(locala.VJ());
    this.zCm = this.zCl.bB(this.zCk.getContext());
    this.zCm.setActionBarCallback(new j()
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
              b.a(b.this).ekt();
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
        b.h(b.this).a(new u()
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
                      b.a(b.this, com.tencent.mm.ui.base.h.a(b.e(b.this), b.e(b.this).getString(2131763070), false, null));
                      b.f(b.this).pause();
                      b.a(b.this, null);
                      AppMethodBeat.o(94578);
                    }
                  });
                  AppMethodBeat.o(94583);
                  return;
                }
                b.a(b.this, s.bhK(b.g(b.this)));
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(94579);
                    b.a(b.this).eks();
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
                    b.a(b.this, com.tencent.mm.ui.base.h.a(b.e(b.this), b.e(b.this).getString(2131763070), false, null));
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
                  b.a(b.this, com.tencent.mm.ui.base.h.a(b.e(b.this), b.e(b.this).getString(2131763070), false, null));
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
    if (au.aA(this.gte)) {
      ((ViewGroup.MarginLayoutParams)localObject).height = (com.tencent.mm.plugin.mmsight.d.ejr().y - Math.max(au.aD(this.gte), au.aB(this.gte)));
    }
    this.zCk.addView(this.zCm, (ViewGroup.LayoutParams)localObject);
    this.zCm.setSelectedFeatureListener(new z()
    {
      public final void a(com.tencent.mm.api.h paramAnonymoush)
      {
        AppMethodBeat.i(94598);
        Log.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedFeature] features:%s", new Object[] { paramAnonymoush.name() });
        if (paramAnonymoush == com.tencent.mm.api.h.diM) {
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
      
      public final void cH(boolean paramAnonymousBoolean)
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
    this.zye.setCancelButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94603);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightVideoEditor$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((!b.k(b.this)) && (b.d(b.this) <= b.l(b.this).duration))
        {
          b.a(b.this, b.b(b.this, -1));
          b.m(b.this).ele();
          b.a(b.this, b.m(b.this).zDX);
          b.n(b.this);
        }
        if (!b.o(b.this)) {
          if (b.a(b.this) != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94601);
                b.a(b.this).ekt();
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
                b.a(b.this).ekt();
                AppMethodBeat.o(94602);
              }
            });
          }
        }
      }
    });
    this.zye.setFinishButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94604);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightVideoEditor$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    if (this.zCt)
    {
      this.zye.setVisibility(0);
      this.zye.bringToFront();
      this.zye.post(new Runnable()
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
  
  private void ekP()
  {
    AppMethodBeat.i(94615);
    this.zyd.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
    this.zye.animate().alpha(0.0F).setDuration(100L).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94588);
        b.m(b.this).setVisibility(8);
        b.m(b.this).setAlpha(1.0F);
        AppMethodBeat.o(94588);
      }
    });
    this.zCm.setFooterVisible(true);
    this.zCm.setAutoShowFooterAndBar(true);
    this.zCm.setActionBarVisible(true);
    this.zCm.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
    this.zCu = false;
    AppMethodBeat.o(94615);
  }
  
  private void ekQ()
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
          b.a(b.this).eks();
        }
        AppMethodBeat.o(94597);
      }
    });
    AppMethodBeat.o(94616);
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt, String paramString, VideoSeekBarEditorView paramVideoSeekBarEditorView, VideoPlayerTextureView paramVideoPlayerTextureView, ViewGroup paramViewGroup, VideoTransPara paramVideoTransPara, boolean paramBoolean)
  {
    AppMethodBeat.i(94613);
    this.zua = paramVideoTransPara;
    if (this.zua != null) {
      if (this.zua.duration > 0) {}
    }
    for (this.zua.duration = 10000;; this.zua.duration = 10000)
    {
      this.scene = paramInt;
      this.videoPath = paramString;
      this.zye = paramVideoSeekBarEditorView;
      this.zyd = paramVideoPlayerTextureView;
      this.zCk = paramViewGroup;
      this.gte = paramMMActivity;
      this.zCt = paramBoolean;
      this.zCw = new com.tencent.mm.plugin.mmsight.a.a.b(paramInt);
      this.zCe = paramVideoSeekBarEditorView.zDX;
      this.zCe.setVideoTransPara(this.zua);
      ekO();
      AppMethodBeat.o(94613);
      return;
      Log.e("MicroMsg.MMSightVideoEditor", "video trans para is null!!!");
      this.zua = new VideoTransPara();
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(94620);
    if (!this.zCy)
    {
      AppMethodBeat.o(94620);
      return false;
    }
    if (this.zCu)
    {
      ekP();
      AppMethodBeat.o(94620);
      return true;
    }
    if (this.zCl != null)
    {
      boolean bool = this.zCl.Ul();
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
      if (this.zCj != null)
      {
        this.zCj.stopTimer();
        this.zCj = null;
      }
      if (this.zCe != null) {
        this.zCe.release();
      }
      if (this.zCl != null) {
        this.zCl.onDestroy();
      }
      if (this.zCk != null) {
        this.zCk.removeView(this.zCm);
      }
      if (this.zye != null) {
        this.zye.ele();
      }
      this.zCf = false;
      k.zwi.aRR();
      AppMethodBeat.o(94617);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMSightVideoEditor", localException, "release error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94617);
    }
  }
  
  public final void rm(boolean paramBoolean)
  {
    AppMethodBeat.i(94618);
    y(paramBoolean, "");
    AppMethodBeat.o(94618);
  }
  
  public final void y(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(94619);
    try
    {
      this.zCw.ifz = paramBoolean;
      if (this.zCl == null)
      {
        Log.e("MicroMsg.MMSightVideoEditor", "[report] null == photoEditor");
        AppMethodBeat.o(94619);
        return;
      }
      x localx = this.zCl.Um();
      this.zCw.zxk = localx.Vy();
      this.zCw.zxl = localx.Vx();
      this.zCw.zxn = localx.VA();
      this.zCw.gpA = localx.VB();
      this.zCw.zxo = localx.VD();
      this.zCw.textColor = localx.getTextColor();
      com.tencent.mm.plugin.mmsight.a.a.a(this.zCw, paramString);
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
    public abstract void eks();
    
    public abstract void ekt();
    
    public abstract void onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b
 * JD-Core Version:    0.7.0.1
 */