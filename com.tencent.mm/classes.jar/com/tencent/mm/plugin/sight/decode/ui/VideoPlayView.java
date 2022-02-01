package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.d.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.b;
import com.tencent.mm.pluginsdk.ui.tools.h.c;
import com.tencent.mm.pluginsdk.ui.tools.h.d;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;

public class VideoPlayView
  extends RelativeLayout
  implements d.a, h
{
  private int duration;
  private boolean fOX;
  private aq gKO;
  private View gYh;
  public View hcH;
  private String hgD;
  private ProgressBar jtq;
  public h oNV;
  private int ziY;
  private int ziZ;
  private boolean zja;
  private a zjb;
  private ViewGroup zjc;
  public a zjd;
  private double zje;
  public TextView zjf;
  public String zjg;
  public ImageView zjh;
  public boolean zji;
  private int zjj;
  private int zjk;
  private boolean zjl;
  private boolean zjm;
  private long zjn;
  private Animation zjo;
  private Animation zjp;
  private Runnable zjq;
  public int zjr;
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116172);
    this.ziY = 320;
    this.ziZ = 240;
    this.zja = true;
    this.oNV = null;
    this.zje = 0.0D;
    this.zjg = "";
    this.gKO = new aq();
    this.zji = true;
    this.duration = 0;
    this.zjj = 0;
    this.zjk = 0;
    this.zjl = false;
    this.zjm = false;
    this.zjn = 0L;
    this.zjo = new AlphaAnimation(1.0F, 0.0F);
    this.zjp = new AlphaAnimation(0.0F, 1.0F);
    this.zjq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116165);
        VideoPlayView.this.dTP();
        AppMethodBeat.o(116165);
      }
    };
    this.zjr = 0;
    this.fOX = false;
    init();
    AppMethodBeat.o(116172);
  }
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(116173);
    this.ziY = 320;
    this.ziZ = 240;
    this.zja = true;
    this.oNV = null;
    this.zje = 0.0D;
    this.zjg = "";
    this.gKO = new aq();
    this.zji = true;
    this.duration = 0;
    this.zjj = 0;
    this.zjk = 0;
    this.zjl = false;
    this.zjm = false;
    this.zjn = 0L;
    this.zjo = new AlphaAnimation(1.0F, 0.0F);
    this.zjp = new AlphaAnimation(0.0F, 1.0F);
    this.zjq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116165);
        VideoPlayView.this.dTP();
        AppMethodBeat.o(116165);
      }
    };
    this.zjr = 0;
    this.fOX = false;
    init();
    AppMethodBeat.o(116173);
  }
  
  private void Qc(int paramInt)
  {
    AppMethodBeat.i(116185);
    if (paramInt >= 0) {}
    for (double d = paramInt;; d = this.oNV.getLastProgresstime())
    {
      this.zje = d;
      ae.i("MicroMsg.VideoPlayView", "pause play " + this.zje + " lastTime: " + paramInt + " last " + this.oNV.getLastProgresstime());
      this.oNV.pause();
      this.gKO.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(116169);
          if (VideoPlayView.c(VideoPlayView.this) != null) {
            VideoPlayView.c(VideoPlayView.this).setIsPlay(false);
          }
          AppMethodBeat.o(116169);
        }
      });
      if (this.zjb != null) {
        this.zjb.dTQ();
      }
      AppMethodBeat.o(116185);
      return;
    }
  }
  
  private void dTO()
  {
    AppMethodBeat.i(116178);
    ((View)this.zjd).setVisibility(0);
    this.gYh.setVisibility(0);
    if (this.zji) {
      this.zjh.setVisibility(0);
    }
    int i;
    if (this.zjr == 2) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        this.hcH.setVisibility(0);
      }
      this.gKO.removeCallbacks(this.zjq);
      this.gKO.postDelayed(this.zjq, 3000L);
      AppMethodBeat.o(116178);
      return;
      if (bu.isNullOrNil(this.zjg)) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(116174);
    this.zjo.setDuration(200L);
    this.zjp.setDuration(200L);
    View.inflate(getContext(), 2131495832, this);
    this.gYh = findViewById(2131303282);
    this.zjh = ((ImageView)findViewById(2131302238));
    this.zjh.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.jtq = ((ProgressBar)findViewById(2131303535));
    this.zjc = ((ViewGroup)findViewById(2131306317));
    this.oNV = t.hK(getContext());
    this.oNV.setLoop(false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.zjc.addView((View)this.oNV, 0, localLayoutParams);
    this.zjf = ((TextView)findViewById(2131304777));
    this.hcH = this.zjf;
    this.oNV.setVideoCallback(new h.a()
    {
      public final int eU(final int paramAnonymousInt1, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(116161);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116156);
            ae.i("MicroMsg.VideoPlayView", "play time " + paramAnonymousInt1 + " video time " + paramAnonymousInt2);
            if (paramAnonymousInt2 > 0)
            {
              VideoPlayView.b(VideoPlayView.this, paramAnonymousInt2);
              if ((VideoPlayView.c(VideoPlayView.this) != null) && (VideoPlayView.h(VideoPlayView.this))) {
                VideoPlayView.i(VideoPlayView.this);
              }
              VideoPlayView.f(VideoPlayView.this).Qd(paramAnonymousInt2);
            }
            if (VideoPlayView.c(VideoPlayView.this) != null)
            {
              if (VideoPlayView.c(VideoPlayView.this).getVideoTotalTime() != paramAnonymousInt2) {
                VideoPlayView.c(VideoPlayView.this).setVideoTotalTime(paramAnonymousInt2);
              }
              VideoPlayView.c(VideoPlayView.this).seek(paramAnonymousInt1);
              VideoPlayView.c(VideoPlayView.this).setIsPlay(true);
            }
            if (VideoPlayView.j(VideoPlayView.this).getVisibility() == 0) {
              VideoPlayView.j(VideoPlayView.this).setVisibility(8);
            }
            VideoPlayView.a(VideoPlayView.this, paramAnonymousInt1);
            AppMethodBeat.o(116156);
          }
        });
        AppMethodBeat.o(116161);
        return 0;
      }
      
      public final void eb(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(116162);
        VideoPlayView.c(VideoPlayView.this, paramAnonymousInt1);
        VideoPlayView.d(VideoPlayView.this, paramAnonymousInt2);
        if (VideoPlayView.k(VideoPlayView.this)) {
          VideoPlayView.l(VideoPlayView.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116157);
              VideoPlayView.e(VideoPlayView.this, VideoPlayView.this.zjr);
              AppMethodBeat.o(116157);
            }
          });
        }
        AppMethodBeat.o(116162);
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(116160);
        ae.d("MicroMsg.VideoPlayView", "on completion " + bu.fpN().toString());
        if (!VideoPlayView.b(VideoPlayView.this))
        {
          VideoPlayView.a(VideoPlayView.this, 0.0D);
          VideoPlayView.this.p(0.0D);
          VideoPlayView.c(VideoPlayView.this).setIsPlay(false);
          VideoPlayView.a(VideoPlayView.this, 0);
          VideoPlayView.d(VideoPlayView.this);
          if (System.currentTimeMillis() - VideoPlayView.e(VideoPlayView.this) < 2000L)
          {
            ae.i("MicroMsg.VideoPlayView", "Too short onCompletion");
            AppMethodBeat.o(116160);
            return;
          }
          VideoPlayView.a(VideoPlayView.this, System.currentTimeMillis());
          if (VideoPlayView.f(VideoPlayView.this) != null)
          {
            VideoPlayView.f(VideoPlayView.this).dTR();
            AppMethodBeat.o(116160);
          }
        }
        else
        {
          VideoPlayView.c(VideoPlayView.this).setIsPlay(false);
          VideoPlayView.a(VideoPlayView.this, (int)VideoPlayView.g(VideoPlayView.this));
          VideoPlayView.d(VideoPlayView.this);
          if (VideoPlayView.f(VideoPlayView.this) != null) {
            VideoPlayView.f(VideoPlayView.this).dTS();
          }
        }
        AppMethodBeat.o(116160);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(116159);
        ae.e("MicroMsg.VideoPlayView", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        VideoPlayView.a(VideoPlayView.this).stop();
        AppMethodBeat.o(116159);
      }
      
      public final void ta()
      {
        AppMethodBeat.i(116158);
        ae.d("MicroMsg.VideoPlayView", f.abq() + " onPrepared");
        VideoPlayView.a(VideoPlayView.this, true);
        AppMethodBeat.o(116158);
      }
    });
    if ((this.oNV instanceof VideoSightView)) {
      ((VideoSightView)this.oNV).setEnableConfigChanged(false);
    }
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(116163);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/decode/ui/VideoPlayView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (paramAnonymousMotionEvent.getAction() == 1) {
          VideoPlayView.m(VideoPlayView.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/decode/ui/VideoPlayView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(116163);
          return true;
          paramAnonymousMotionEvent.getAction();
        }
      }
    });
    dTP();
    ((View)this.oNV).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116164);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        if ((VideoPlayView.this.getContext() instanceof MMActivity))
        {
          ((MMActivity)VideoPlayView.this.getContext()).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
          if ((VideoPlayView.a(VideoPlayView.this) instanceof VideoSightView)) {
            ((VideoSightView)VideoPlayView.a(VideoPlayView.this)).setDrawableWidth(localDisplayMetrics.widthPixels);
          }
        }
        ((View)VideoPlayView.a(VideoPlayView.this)).requestLayout();
        ((View)VideoPlayView.a(VideoPlayView.this)).postInvalidate();
        AppMethodBeat.o(116164);
      }
    });
    AppMethodBeat.o(116174);
  }
  
  private void rj(boolean paramBoolean)
  {
    AppMethodBeat.i(116184);
    this.oNV.p(this.zje);
    this.oNV.start();
    ae.i("MicroMsg.VideoPlayView", "startplay get duration " + this.duration + " lastPlayProgressTime: " + this.zje);
    if (this.zjb != null) {
      this.zjb.rk(paramBoolean);
    }
    AppMethodBeat.o(116184);
  }
  
  public final boolean B(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(116187);
    paramBoolean = this.oNV.B(paramContext, paramBoolean);
    AppMethodBeat.o(116187);
    return paramBoolean;
  }
  
  public final void aAo() {}
  
  public final void aAp() {}
  
  public final void aAq() {}
  
  public final void aAr() {}
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(116199);
    p(paramDouble);
    AppMethodBeat.o(116199);
  }
  
  public final void dTN()
  {
    AppMethodBeat.i(116177);
    this.jtq.setVisibility(0);
    AppMethodBeat.o(116177);
  }
  
  public final void dTP()
  {
    AppMethodBeat.i(116179);
    if (this.zjd != null) {
      ((View)this.zjd).setVisibility(4);
    }
    this.gYh.setVisibility(8);
    this.zjh.setVisibility(8);
    this.hcH.setVisibility(8);
    AppMethodBeat.o(116179);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(116193);
    int i = this.oNV.getCurrentPosition();
    AppMethodBeat.o(116193);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116194);
    if (this.duration == 0)
    {
      i = this.oNV.getDuration();
      AppMethodBeat.o(116194);
      return i;
    }
    int i = this.duration;
    AppMethodBeat.o(116194);
    return i;
  }
  
  public double getLastProgresstime()
  {
    AppMethodBeat.i(116191);
    double d = Math.max(this.zje, this.oNV.getLastProgresstime());
    AppMethodBeat.o(116191);
    return d;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return 0L;
  }
  
  public String getVideoPath()
  {
    return this.hgD;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(116186);
    boolean bool = this.oNV.isPlaying();
    AppMethodBeat.o(116186);
    return bool;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(116189);
    this.oNV.onDetach();
    AppMethodBeat.o(116189);
  }
  
  public final void p(double paramDouble)
  {
    AppMethodBeat.i(116196);
    this.oNV.p(paramDouble);
    this.zjd.seek((int)paramDouble);
    AppMethodBeat.o(116196);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(116183);
    Qc(-1);
    AppMethodBeat.o(116183);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setIsDownloading(boolean paramBoolean)
  {
    AppMethodBeat.i(116176);
    this.zjl = paramBoolean;
    Object localObject;
    if ((this.oNV != null) && ((this.oNV instanceof VideoSightView)))
    {
      localObject = (VideoSightView)this.oNV;
      if (((VideoSightView)localObject).getController() != null)
      {
        localObject = ((VideoSightView)localObject).getController();
        if (paramBoolean) {
          break label66;
        }
      }
    }
    label66:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((com.tencent.mm.plugin.sight.decode.a.b)localObject).zhU = paramBoolean;
      AppMethodBeat.o(116176);
      return;
    }
  }
  
  public void setLeftButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116180);
    this.gYh.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116180);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(116190);
    this.oNV.setLoop(paramBoolean);
    AppMethodBeat.o(116190);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.fOX = paramBoolean;
  }
  
  public void setOnInfoCallback(h.b paramb) {}
  
  public void setOnSeekCompleteCallback(h.c paramc) {}
  
  public void setOnSurfaceCallback(h.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(h.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(116197);
    this.oNV.setPlayProgressCallback(paramBoolean);
    AppMethodBeat.o(116197);
  }
  
  public void setRightButtonOnCliclListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116181);
    this.zjh.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116181);
  }
  
  public void setThumb(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116195);
    this.oNV.setThumb(paramBitmap);
    AppMethodBeat.o(116195);
  }
  
  public void setVideoCallback(h.a parama)
  {
    AppMethodBeat.i(116192);
    this.oNV.setVideoCallback(parama);
    AppMethodBeat.o(116192);
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(116171);
    this.hgD = paramString;
    ae.i("MicroMsg.VideoPlayView", "videoPath  %s", new Object[] { this.hgD });
    this.oNV.setVideoPath(this.hgD);
    AppMethodBeat.o(116171);
  }
  
  public void setVideoPlayViewEvent(a parama)
  {
    this.zjb = parama;
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(116175);
    if (this.zjd.getVideoTotalTime() != paramInt) {
      this.zjd.setVideoTotalTime(paramInt);
    }
    AppMethodBeat.o(116175);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(116182);
    rj(true);
    AppMethodBeat.o(116182);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(116188);
    this.oNV.stop();
    AppMethodBeat.o(116188);
  }
  
  public final void update(int paramInt)
  {
    AppMethodBeat.i(116198);
    this.zjm = true;
    Object localObject;
    if ((this.zjk == 0) || (this.zjj == 0))
    {
      localObject = getResources().getDisplayMetrics();
      this.zjk = ((DisplayMetrics)localObject).heightPixels;
      this.zjj = ((DisplayMetrics)localObject).widthPixels;
      if (this.zjk < this.zjj)
      {
        this.zjk = ((DisplayMetrics)localObject).widthPixels;
        this.zjj = ((DisplayMetrics)localObject).heightPixels;
      }
      ae.i("MicroMsg.VideoPlayView", "getScreen screen_height:" + this.zjk + " screen_width:" + this.zjj);
    }
    ViewGroup.LayoutParams localLayoutParams = this.zjc.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1;
    if (this.zjd == null)
    {
      localObject = null;
      localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
      if (paramInt != 1) {
        break label410;
      }
      localLayoutParams1.width = this.zjj;
      localLayoutParams1.height = ((int)(this.zjj * 1.0D * this.ziZ / this.ziY));
      if (this.zjd != null) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.b.h(getContext(), 0.0F);
      }
    }
    for (;;)
    {
      if (this.zjd != null)
      {
        this.zjd.dTK();
        ((View)this.zjd).setLayoutParams((ViewGroup.LayoutParams)localObject);
        if ((this.zjd instanceof AdVideoPlayerLoadingBar)) {
          this.gKO.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116170);
              if (!VideoPlayView.a(VideoPlayView.this).isPlaying()) {
                ((AdVideoPlayerLoadingBar)VideoPlayView.c(VideoPlayView.this)).bpi();
              }
              AppMethodBeat.o(116170);
            }
          }, 500L);
        }
      }
      ae.i("MicroMsg.VideoPlayView", "orientation " + paramInt + " " + localLayoutParams1.width + " " + localLayoutParams1.height);
      ((View)this.oNV).setLayoutParams(localLayoutParams1);
      if ((this.oNV instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
        ((com.tencent.mm.plugin.sight.decode.a.a)this.oNV).hy(localLayoutParams1.width, localLayoutParams1.height);
      }
      localLayoutParams.height = localLayoutParams1.height;
      localLayoutParams.width = localLayoutParams1.width;
      this.zjc.setLayoutParams(localLayoutParams);
      ((View)this.oNV).requestLayout();
      AppMethodBeat.o(116198);
      return;
      localObject = (RelativeLayout.LayoutParams)((View)this.zjd).getLayoutParams();
      break;
      label410:
      localLayoutParams1.height = this.zjj;
      localLayoutParams1.width = ((int)(this.zjj * 1.0D * this.ziY / this.ziZ));
      if (this.zjd != null) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.b.h(getContext(), 0.0F);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Qd(int paramInt);
    
    public abstract void dTQ();
    
    public abstract void dTR();
    
    public abstract void dTS();
    
    public abstract void rk(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView
 * JD-Core Version:    0.7.0.1
 */