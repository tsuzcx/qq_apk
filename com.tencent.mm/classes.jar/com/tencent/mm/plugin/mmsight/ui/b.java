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
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ac.a.a;
import com.tencent.mm.api.ac.b;
import com.tencent.mm.api.ac.c;
import com.tencent.mm.api.i;
import com.tencent.mm.be.e;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.media.i.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.mmsight.segment.n;
import com.tencent.mm.plugin.sight.base.ABAPrams;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.w.a.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bf;

public final class b
{
  private static final Object LcM;
  private static int lyw;
  private VideoTransPara KVn;
  private VideoPlayerTextureView KZh;
  private VideoSeekBarEditorView KZi;
  private RecyclerThumbSeekBar LcB;
  private boolean LcC = false;
  private int LcD = -1;
  public int LcE = -1;
  public int LcF = -1;
  private MTimerHandler LcG;
  private ViewGroup LcH;
  private ac LcI;
  private com.tencent.mm.api.f LcJ;
  private com.tencent.mm.plugin.mmsight.api.a LcK;
  private c LcL;
  public a LcN;
  private boolean LcO = false;
  public boolean LcP = false;
  private boolean LcQ = false;
  private boolean LcR = false;
  public int LcS = -1;
  private com.tencent.mm.plugin.mmsight.a.a.b LcT;
  public boolean LcU = false;
  public boolean LcV = true;
  private MMActivity lzt;
  String md5;
  private com.tencent.mm.ui.base.w psR;
  public int scene;
  public String videoOutputPath = null;
  private String videoPath;
  
  static
  {
    AppMethodBeat.i(94627);
    LcM = new Object();
    AppMethodBeat.o(94627);
  }
  
  private void gdj()
  {
    AppMethodBeat.i(94614);
    this.LcI = ac.hdY.aAA();
    this.LcI.a(new ac.a.a().dR(false).dQ(true).a(ac.c.hef).t(new Rect(this.KZh.getLeft(), this.KZh.getTop(), this.KZh.getRight(), this.KZh.getBottom())).hee);
    this.LcJ = this.LcI.cn(this.LcH.getContext());
    this.LcJ.setActionBarCallback(new com.tencent.mm.api.k()
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
              b.a(b.this).gcT();
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
        b.h(b.this).a(new com.tencent.mm.api.w()
        {
          public final void b(final Bitmap paramAnonymous2Bitmap, boolean paramAnonymous2Boolean)
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
                      b.a(b.this, com.tencent.mm.ui.base.k.a(b.e(b.this), b.e(b.this).getString(a.h.mmsight_video_edit_processing), false, null));
                      b.f(b.this).pause();
                      b.a(b.this, null);
                      AppMethodBeat.o(94578);
                    }
                  });
                  AppMethodBeat.o(94583);
                  return;
                }
                b.a(b.this, com.tencent.mm.vfs.y.bub(b.g(b.this)));
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(94579);
                    b.a(b.this).gcS();
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
                    b.a(b.this, com.tencent.mm.ui.base.k.a(b.e(b.this), b.e(b.this).getString(a.h.mmsight_video_edit_processing), false, null));
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
                  b.a(b.this, com.tencent.mm.ui.base.k.a(b.e(b.this), b.e(b.this).getString(a.h.mmsight_video_edit_processing), false, null));
                  b.f(b.this).pause();
                  b.a(b.this, paramAnonymous2Bitmap);
                  AppMethodBeat.o(94581);
                }
              });
            }
            AppMethodBeat.o(94583);
          }
          
          public final void f(Exception paramAnonymous2Exception)
          {
            AppMethodBeat.i(94582);
            Log.e("MicroMsg.MMSightVideoEditor", "photoEditor onError: %s", new Object[] { paramAnonymous2Exception });
            AppMethodBeat.o(94582);
          }
        });
        AppMethodBeat.o(94585);
      }
    });
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
    if (bf.bg(this.lzt)) {
      localMarginLayoutParams.height = (com.tencent.mm.plugin.mmsight.d.gbR().y - Math.max(bf.bk(this.lzt), bf.bi(this.lzt)));
    }
    this.LcH.addView(this.LcJ, localMarginLayoutParams);
    this.LcJ.setSelectedFeatureListener(new aa()
    {
      public final void a(i paramAnonymousi)
      {
        AppMethodBeat.i(94598);
        Log.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedFeature] features:%s", new Object[] { paramAnonymousi.name() });
        if (paramAnonymousi == i.hdT) {
          b.i(b.this);
        }
        AppMethodBeat.o(94598);
      }
      
      public final void a(i paramAnonymousi, int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(169419);
        Log.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymousi.name(), Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(169419);
      }
      
      public final void dP(boolean paramAnonymousBoolean)
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
    this.KZi.setCancelButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94603);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mmsight/ui/MMSightVideoEditor$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((!b.k(b.this)) && (b.d(b.this) <= b.l(b.this).duration))
        {
          b.a(b.this, b.b(b.this, -1));
          b.m(b.this).gdz();
          b.a(b.this, b.m(b.this).Leu);
          b.n(b.this);
        }
        if (!b.o(b.this)) {
          if (b.a(b.this) != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94601);
                b.a(b.this).gcT();
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
                b.a(b.this).gcT();
                AppMethodBeat.o(94602);
              }
            });
          }
        }
      }
    });
    this.KZi.setFinishButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94604);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mmsight/ui/MMSightVideoEditor$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
    if (this.LcQ)
    {
      this.KZi.setVisibility(0);
      this.KZi.bringToFront();
      this.KZi.post(new Runnable()
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
  
  private void gdk()
  {
    AppMethodBeat.i(94615);
    this.KZh.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
    this.KZi.animate().alpha(0.0F).setDuration(100L).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94588);
        b.m(b.this).setVisibility(8);
        b.m(b.this).setAlpha(1.0F);
        AppMethodBeat.o(94588);
      }
    });
    this.LcJ.setFooterVisible(true);
    this.LcJ.setAutoShowFooterAndBar(true);
    this.LcJ.setActionBarVisible(true);
    this.LcJ.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
    this.LcR = false;
    AppMethodBeat.o(94615);
  }
  
  private void gdl()
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
          b.a(b.this).gcS();
        }
        AppMethodBeat.o(94597);
      }
    });
    AppMethodBeat.o(94616);
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt, String paramString, VideoSeekBarEditorView paramVideoSeekBarEditorView, VideoPlayerTextureView paramVideoPlayerTextureView, ViewGroup paramViewGroup, VideoTransPara paramVideoTransPara, boolean paramBoolean)
  {
    AppMethodBeat.i(94613);
    this.KVn = paramVideoTransPara;
    if (this.KVn != null) {
      if (this.KVn.duration > 0) {}
    }
    for (this.KVn.duration = 10000;; this.KVn.duration = 10000)
    {
      this.scene = paramInt;
      this.videoPath = paramString;
      this.KZi = paramVideoSeekBarEditorView;
      this.KZh = paramVideoPlayerTextureView;
      this.LcH = paramViewGroup;
      this.lzt = paramMMActivity;
      this.LcQ = paramBoolean;
      this.LcT = new com.tencent.mm.plugin.mmsight.a.a.b(paramInt);
      this.LcB = paramVideoSeekBarEditorView.Leu;
      this.LcB.setVideoTransPara(this.KVn);
      gdj();
      AppMethodBeat.o(94613);
      return;
      Log.e("MicroMsg.MMSightVideoEditor", "video trans para is null!!!");
      this.KVn = new VideoTransPara();
    }
  }
  
  public final void aq(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(94619);
    try
    {
      this.LcT.nzW = paramBoolean;
      if (this.LcI == null)
      {
        Log.e("MicroMsg.MMSightVideoEditor", "[report] null == photoEditor");
        AppMethodBeat.o(94619);
        return;
      }
      com.tencent.mm.api.y localy = this.LcI.aAy();
      this.LcT.KYn = localy.aBy();
      this.LcT.KYo = localy.aBx();
      this.LcT.KYq = localy.aBA();
      this.LcT.lvO = localy.aBB();
      this.LcT.KYr = localy.aBE();
      this.LcT.textColor = localy.getTextColor();
      com.tencent.mm.plugin.mmsight.a.a.a(this.LcT, paramString);
      AppMethodBeat.o(94619);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(94619);
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(94620);
    if (!this.LcV)
    {
      AppMethodBeat.o(94620);
      return false;
    }
    if (this.LcR)
    {
      gdk();
      AppMethodBeat.o(94620);
      return true;
    }
    if (this.LcI != null)
    {
      boolean bool = this.LcI.aAx();
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
      if (this.LcG != null)
      {
        this.LcG.stopTimer();
        this.LcG = null;
      }
      if (this.LcB != null) {
        this.LcB.release();
      }
      if (this.LcI != null) {
        this.LcI.onDestroy();
      }
      if (this.LcH != null) {
        this.LcH.removeView(this.LcJ);
      }
      if (this.KZi != null) {
        this.KZi.gdz();
      }
      this.LcC = false;
      j.KXq.bvG();
      AppMethodBeat.o(94617);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMSightVideoEditor", localException, "release error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94617);
    }
  }
  
  public final void yD(boolean paramBoolean)
  {
    AppMethodBeat.i(94618);
    aq(paramBoolean, "");
    AppMethodBeat.o(94618);
  }
  
  public static abstract interface a
  {
    public abstract void atR();
    
    public abstract void gcS();
    
    public abstract void gcT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b
 * JD-Core Version:    0.7.0.1
 */