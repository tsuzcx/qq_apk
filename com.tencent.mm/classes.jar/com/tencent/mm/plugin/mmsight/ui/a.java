package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import com.tencent.mm.api.b;
import com.tencent.mm.api.f;
import com.tencent.mm.api.n;
import com.tencent.mm.api.q;
import com.tencent.mm.api.q.a.a;
import com.tencent.mm.api.q.b;
import com.tencent.mm.api.q.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.a.a.b;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.p;

public final class a
{
  MMActivity bER;
  String bIW;
  p dnV;
  VideoTransPara mgW;
  VideoPlayerTextureView mlw;
  VideoSeekBarEditorView mlx;
  RecyclerThumbSeekBar mpd;
  boolean mpe = false;
  int mpf = -1;
  int mpg = -1;
  int mph = -1;
  am mpi;
  ViewGroup mpj;
  q mpk;
  b mpl;
  com.tencent.mm.plugin.mmsight.api.a mpm;
  public a.a mpn;
  boolean mpo = false;
  public boolean mpp = false;
  private boolean mpq = false;
  private boolean mpr = false;
  public String mps = null;
  public int mpt = -1;
  a.b mpu;
  public boolean mpv = false;
  public int scene;
  String videoPath;
  
  public final void a(MMActivity paramMMActivity, int paramInt, String paramString, VideoSeekBarEditorView paramVideoSeekBarEditorView, VideoPlayerTextureView paramVideoPlayerTextureView, ViewGroup paramViewGroup, VideoTransPara paramVideoTransPara, boolean paramBoolean)
  {
    this.mgW = paramVideoTransPara;
    if (this.mgW != null) {
      if (this.mgW.duration > 0) {}
    }
    for (this.mgW.duration = 10000;; this.mgW.duration = 10000)
    {
      this.scene = paramInt;
      this.videoPath = paramString;
      this.mlx = paramVideoSeekBarEditorView;
      this.mlw = paramVideoPlayerTextureView;
      this.mpj = paramViewGroup;
      this.bER = paramMMActivity;
      this.mpq = paramBoolean;
      this.mpu = new a.b(paramInt);
      this.mpd = paramVideoSeekBarEditorView.mqW;
      this.mpd.setVideoTransPara(this.mgW);
      this.mpk = q.buU.rJ();
      paramMMActivity = this.mpk;
      paramString = new q.a.a();
      paramString.buW = false;
      paramString.buY = true;
      paramString.buV = q.c.bva;
      paramString.buZ = new Rect(this.mlw.getLeft(), this.mlw.getTop(), this.mlw.getRight(), this.mlw.getBottom());
      paramMMActivity.a(paramString.sh());
      this.mpl = this.mpk.ax(this.mpj.getContext());
      this.mpl.setActionBarCallback(new f()
      {
        public final void onFinish()
        {
          y.i("MicroMsg.MMSightVideoEditor", "photoEditor onFinish");
          a.this.mpk.a(new a.1.1(this));
        }
        
        public final void rX()
        {
          y.i("MicroMsg.MMSightVideoEditor", "photoEditor onExit");
          a.this.release();
          if (a.this.mpn != null) {
            ai.d(new a.1.2(this));
          }
        }
      });
      paramMMActivity = new ViewGroup.MarginLayoutParams(-1, -1);
      if (aq.gw(this.bER)) {
        paramMMActivity.height = (d.biC().y - Math.max(aq.gv(this.bER), aq.gD(this.bER)));
      }
      this.mpj.addView(this.mpl, paramMMActivity);
      this.mpl.setSelectedFeatureListener(new a.5(this));
      this.mlx.setCancelButtonClickListener(new a.6(this));
      this.mlx.setFinishButtonClickListener(new a.7(this));
      if (this.mpq) {
        this.mpl.post(new a.8(this));
      }
      return;
      y.e("MicroMsg.MMSightVideoEditor", "video trans para is null!!!");
      this.mgW = new VideoTransPara();
    }
  }
  
  final void bkc()
  {
    this.mlw.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
    this.mlx.animate().alpha(0.0F).setDuration(100L).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        a.this.mlx.setVisibility(8);
        a.this.mlx.setAlpha(1.0F);
      }
    });
    this.mpl.setFooterVisible(true);
    this.mpl.setActionBarVisible(true);
    this.mpl.setAutoShowFooterAndBar(true);
    this.mpl.animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
    this.mpr = false;
  }
  
  public final void k(boolean paramBoolean, String paramString)
  {
    for (int i = 2;; i = 1) {
      try
      {
        this.mpu.edT = paramBoolean;
        if (this.mpk == null)
        {
          y.e("MicroMsg.MMSightVideoEditor", "[report] null == photoEditor");
          return;
        }
        Object localObject = this.mpk.rH();
        this.mpu.mlk = ((n)localObject).rZ();
        this.mpu.mll = ((n)localObject).rY();
        this.mpu.mln = ((n)localObject).sb();
        this.mpu.dkZ = ((n)localObject).sc();
        this.mpu.mlo = ((n)localObject).sf();
        this.mpu.textColor = ((n)localObject).getTextColor();
        localObject = this.mpu;
        h localh = h.nFQ;
        int j = ((a.b)localObject).scene;
        if (((a.b)localObject).edT)
        {
          localh.f(14362, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(((a.b)localObject).mlk), Integer.valueOf(((a.b)localObject).mll), Integer.valueOf(((a.b)localObject).mln), Boolean.valueOf(((a.b)localObject).mlm), Integer.valueOf(((a.b)localObject).dkZ), Integer.valueOf(((a.b)localObject).mli), Integer.valueOf(((a.b)localObject).mlj), Integer.valueOf(((a.b)localObject).mlo), Integer.valueOf(0), Integer.valueOf(((a.b)localObject).textColor), paramString, Long.valueOf(bk.UX()) });
          y.i("MicroMsg.VideoEditReporter", "[report-VideoEditDetailData] %s", new Object[] { ((a.b)localObject).toString() });
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
    }
  }
  
  public final boolean qc()
  {
    if (this.mpr)
    {
      bkc();
      return true;
    }
    if (this.mpk != null) {
      return this.mpk.rG();
    }
    return false;
  }
  
  public final void release()
  {
    try
    {
      if (this.mpi != null)
      {
        this.mpi.stopTimer();
        this.mpi = null;
      }
      if (this.mpd != null) {
        this.mpd.release();
      }
      if (this.mpk != null) {
        this.mpk.onDestroy();
      }
      if (this.mpj != null) {
        this.mpj.removeView(this.mpl);
      }
      if (this.mlx != null) {
        this.mlx.bkl();
      }
      this.mpe = false;
      j.mji.ET();
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.MMSightVideoEditor", localException, "release error: %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.a
 * JD-Core Version:    0.7.0.1
 */