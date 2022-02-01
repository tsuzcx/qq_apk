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
import com.tencent.mm.plugin.ar.a.e;
import com.tencent.mm.plugin.ar.a.f;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.pluginsdk.ui.tools.i.b;
import com.tencent.mm.pluginsdk.ui.tools.i.c;
import com.tencent.mm.pluginsdk.ui.tools.i.d;
import com.tencent.mm.pluginsdk.ui.tools.i.e;
import com.tencent.mm.pluginsdk.ui.tools.w;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class VideoPlayView
  extends RelativeLayout
  implements d.a, i
{
  private int PGT;
  private int PGU;
  private boolean PGV;
  private a PGW;
  private ViewGroup PGX;
  public a PGY;
  private double PGZ;
  public TextView PHa;
  public String PHb;
  public ImageView PHc;
  public boolean PHd;
  private int PHe;
  private int PHf;
  private boolean PHg;
  private boolean PHh;
  private long PHi;
  private Animation PHj;
  private Animation PHk;
  private Runnable PHl;
  public int PHm;
  private int duration;
  private String fullPath;
  private boolean lAj;
  private MMHandler mRi;
  public View maskView;
  private View niB;
  private ProgressBar qgC;
  public i wCd;
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116172);
    this.PGT = 320;
    this.PGU = 240;
    this.PGV = true;
    this.wCd = null;
    this.PGZ = 0.0D;
    this.PHb = "";
    this.mRi = new MMHandler();
    this.PHd = true;
    this.duration = 0;
    this.PHe = 0;
    this.PHf = 0;
    this.PHg = false;
    this.PHh = false;
    this.PHi = 0L;
    this.PHj = new AlphaAnimation(1.0F, 0.0F);
    this.PHk = new AlphaAnimation(0.0F, 1.0F);
    this.PHl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116165);
        VideoPlayView.this.gYL();
        AppMethodBeat.o(116165);
      }
    };
    this.PHm = 0;
    this.lAj = false;
    init();
    AppMethodBeat.o(116172);
  }
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(116173);
    this.PGT = 320;
    this.PGU = 240;
    this.PGV = true;
    this.wCd = null;
    this.PGZ = 0.0D;
    this.PHb = "";
    this.mRi = new MMHandler();
    this.PHd = true;
    this.duration = 0;
    this.PHe = 0;
    this.PHf = 0;
    this.PHg = false;
    this.PHh = false;
    this.PHi = 0L;
    this.PHj = new AlphaAnimation(1.0F, 0.0F);
    this.PHk = new AlphaAnimation(0.0F, 1.0F);
    this.PHl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116165);
        VideoPlayView.this.gYL();
        AppMethodBeat.o(116165);
      }
    };
    this.PHm = 0;
    this.lAj = false;
    init();
    AppMethodBeat.o(116173);
  }
  
  private void Dh(boolean paramBoolean)
  {
    AppMethodBeat.i(116184);
    this.wCd.H(this.PGZ);
    this.wCd.start();
    Log.i("MicroMsg.VideoPlayView", "startplay get duration " + this.duration + " lastPlayProgressTime: " + this.PGZ);
    if (this.PGW != null) {
      this.PGW.Di(paramBoolean);
    }
    AppMethodBeat.o(116184);
  }
  
  private void ajo(int paramInt)
  {
    AppMethodBeat.i(116185);
    if (paramInt >= 0) {}
    for (double d = paramInt;; d = this.wCd.getLastProgresstime())
    {
      this.PGZ = d;
      Log.i("MicroMsg.VideoPlayView", "pause play " + this.PGZ + " lastTime: " + paramInt + " last " + this.wCd.getLastProgresstime());
      this.wCd.pause();
      this.mRi.post(new Runnable()
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
      if (this.PGW != null) {
        this.PGW.gYM();
      }
      AppMethodBeat.o(116185);
      return;
    }
  }
  
  private void gYK()
  {
    AppMethodBeat.i(116178);
    ((View)this.PGY).setVisibility(0);
    this.niB.setVisibility(0);
    if (this.PHd) {
      this.PHc.setVisibility(0);
    }
    int i;
    if (this.PHm == 2) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        this.maskView.setVisibility(0);
      }
      this.mRi.removeCallbacks(this.PHl);
      this.mRi.postDelayed(this.PHl, 3000L);
      AppMethodBeat.o(116178);
      return;
      if (Util.isNullOrNil(this.PHb)) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(116174);
    this.PHj.setDuration(200L);
    this.PHk.setDuration(200L);
    View.inflate(getContext(), a.f.video_play_view, this);
    this.niB = findViewById(a.e.play_close_btn);
    this.PHc = ((ImageView)findViewById(a.e.menu_btn));
    this.PHc.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.qgC = ((ProgressBar)findViewById(a.e.progressbar));
    this.PGX = ((ViewGroup)findViewById(a.e.video_container));
    this.wCd = w.lG(getContext());
    this.wCd.setLoop(false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.PGX.addView((View)this.wCd, 0, localLayoutParams);
    this.PHa = ((TextView)findViewById(a.e.show_ad_sight));
    this.maskView = this.PHa;
    this.wCd.setVideoCallback(new i.a()
    {
      public final void Qz()
      {
        AppMethodBeat.i(116158);
        Log.d("MicroMsg.VideoPlayView", f.aPW() + " onPrepared");
        VideoPlayView.a(VideoPlayView.this, true);
        AppMethodBeat.o(116158);
      }
      
      public final void fG(int paramAnonymousInt1, int paramAnonymousInt2)
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
              VideoPlayView.e(VideoPlayView.this, VideoPlayView.this.PHm);
              AppMethodBeat.o(116157);
            }
          });
        }
        AppMethodBeat.o(116162);
      }
      
      public final int gw(final int paramAnonymousInt1, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(116161);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116156);
            Log.i("MicroMsg.VideoPlayView", "play time " + paramAnonymousInt1 + " video time " + paramAnonymousInt2);
            if (paramAnonymousInt2 > 0)
            {
              VideoPlayView.b(VideoPlayView.this, paramAnonymousInt2);
              if ((VideoPlayView.c(VideoPlayView.this) != null) && (VideoPlayView.h(VideoPlayView.this))) {
                VideoPlayView.i(VideoPlayView.this);
              }
              VideoPlayView.f(VideoPlayView.this).ajp(paramAnonymousInt2);
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
      
      public final void onCompletion()
      {
        AppMethodBeat.i(116160);
        Log.d("MicroMsg.VideoPlayView", "on completion " + Util.getStack().toString());
        if (!VideoPlayView.b(VideoPlayView.this))
        {
          VideoPlayView.a(VideoPlayView.this, 0.0D);
          VideoPlayView.this.H(0.0D);
          VideoPlayView.c(VideoPlayView.this).setIsPlay(false);
          VideoPlayView.a(VideoPlayView.this, 0);
          VideoPlayView.d(VideoPlayView.this);
          if (System.currentTimeMillis() - VideoPlayView.e(VideoPlayView.this) < 2000L)
          {
            Log.i("MicroMsg.VideoPlayView", "Too short onCompletion");
            AppMethodBeat.o(116160);
            return;
          }
          VideoPlayView.a(VideoPlayView.this, System.currentTimeMillis());
          if (VideoPlayView.f(VideoPlayView.this) != null)
          {
            VideoPlayView.f(VideoPlayView.this).gYN();
            AppMethodBeat.o(116160);
          }
        }
        else
        {
          VideoPlayView.c(VideoPlayView.this).setIsPlay(false);
          VideoPlayView.a(VideoPlayView.this, (int)VideoPlayView.g(VideoPlayView.this));
          VideoPlayView.d(VideoPlayView.this);
          if (VideoPlayView.f(VideoPlayView.this) != null) {
            VideoPlayView.f(VideoPlayView.this).gYO();
          }
        }
        AppMethodBeat.o(116160);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(116159);
        Log.e("MicroMsg.VideoPlayView", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        VideoPlayView.a(VideoPlayView.this).stop();
        AppMethodBeat.o(116159);
      }
    });
    if ((this.wCd instanceof VideoSightView)) {
      ((VideoSightView)this.wCd).setEnableConfigChanged(false);
    }
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(116163);
        if (paramAnonymousMotionEvent.getAction() == 1) {
          VideoPlayView.m(VideoPlayView.this);
        }
        for (;;)
        {
          AppMethodBeat.o(116163);
          return true;
          paramAnonymousMotionEvent.getAction();
        }
      }
    });
    gYL();
    ((View)this.wCd).post(new Runnable()
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
  
  public final void H(double paramDouble)
  {
    AppMethodBeat.i(116196);
    this.wCd.H(paramDouble);
    this.PGY.seek((int)paramDouble);
    AppMethodBeat.o(116196);
  }
  
  public final boolean P(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(116187);
    paramBoolean = this.wCd.P(paramContext, paramBoolean);
    AppMethodBeat.o(116187);
    return paramBoolean;
  }
  
  public final void bAi() {}
  
  public final void bAj() {}
  
  public final void bAk() {}
  
  public final void bAl() {}
  
  public final void c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(116199);
    H(paramDouble);
    AppMethodBeat.o(116199);
  }
  
  public final void gYJ()
  {
    AppMethodBeat.i(116177);
    this.qgC.setVisibility(0);
    AppMethodBeat.o(116177);
  }
  
  public final void gYL()
  {
    AppMethodBeat.i(116179);
    if (this.PGY != null) {
      ((View)this.PGY).setVisibility(4);
    }
    this.niB.setVisibility(8);
    this.PHc.setVisibility(8);
    this.maskView.setVisibility(8);
    AppMethodBeat.o(116179);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(116193);
    int i = this.wCd.getCurrentPosition();
    AppMethodBeat.o(116193);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116194);
    if (this.duration == 0)
    {
      i = this.wCd.getDuration();
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
    double d = Math.max(this.PGZ, this.wCd.getLastProgresstime());
    AppMethodBeat.o(116191);
    return d;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return 0L;
  }
  
  public String getVideoPath()
  {
    return this.fullPath;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(116186);
    boolean bool = this.wCd.isPlaying();
    AppMethodBeat.o(116186);
    return bool;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(116189);
    this.wCd.onDetach();
    AppMethodBeat.o(116189);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(116183);
    ajo(-1);
    AppMethodBeat.o(116183);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setIsDownloading(boolean paramBoolean)
  {
    AppMethodBeat.i(116176);
    this.PHg = paramBoolean;
    Object localObject;
    if ((this.wCd != null) && ((this.wCd instanceof VideoSightView)))
    {
      localObject = (VideoSightView)this.wCd;
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
      ((SightPlayController)localObject).PFS = paramBoolean;
      AppMethodBeat.o(116176);
      return;
    }
  }
  
  public void setLeftButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116180);
    this.niB.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116180);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(116190);
    this.wCd.setLoop(paramBoolean);
    AppMethodBeat.o(116190);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.lAj = paramBoolean;
  }
  
  public void setOnInfoCallback(i.b paramb) {}
  
  public void setOnSeekCompleteCallback(i.c paramc) {}
  
  public void setOnSurfaceCallback(i.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(i.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(116197);
    this.wCd.setPlayProgressCallback(paramBoolean);
    AppMethodBeat.o(116197);
  }
  
  public void setRightButtonOnCliclListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116181);
    this.PHc.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116181);
  }
  
  public void setThumb(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116195);
    this.wCd.setThumb(paramBitmap);
    AppMethodBeat.o(116195);
  }
  
  public void setVideoCallback(i.a parama)
  {
    AppMethodBeat.i(116192);
    this.wCd.setVideoCallback(parama);
    AppMethodBeat.o(116192);
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(116171);
    this.fullPath = paramString;
    Log.i("MicroMsg.VideoPlayView", "videoPath  %s", new Object[] { this.fullPath });
    this.wCd.setVideoPath(this.fullPath);
    AppMethodBeat.o(116171);
  }
  
  public void setVideoPlayViewEvent(a parama)
  {
    this.PGW = parama;
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(116175);
    if (this.PGY.getVideoTotalTime() != paramInt) {
      this.PGY.setVideoTotalTime(paramInt);
    }
    AppMethodBeat.o(116175);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(116182);
    Dh(true);
    AppMethodBeat.o(116182);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(116188);
    this.wCd.stop();
    AppMethodBeat.o(116188);
  }
  
  public final void update(int paramInt)
  {
    AppMethodBeat.i(116198);
    this.PHh = true;
    Object localObject;
    if ((this.PHf == 0) || (this.PHe == 0))
    {
      localObject = getResources().getDisplayMetrics();
      this.PHf = ((DisplayMetrics)localObject).heightPixels;
      this.PHe = ((DisplayMetrics)localObject).widthPixels;
      if (this.PHf < this.PHe)
      {
        this.PHf = ((DisplayMetrics)localObject).widthPixels;
        this.PHe = ((DisplayMetrics)localObject).heightPixels;
      }
      Log.i("MicroMsg.VideoPlayView", "getScreen screen_height:" + this.PHf + " screen_width:" + this.PHe);
    }
    ViewGroup.LayoutParams localLayoutParams = this.PGX.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1;
    if (this.PGY == null)
    {
      localObject = null;
      localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
      if (paramInt != 1) {
        break label410;
      }
      localLayoutParams1.width = this.PHe;
      localLayoutParams1.height = ((int)(this.PHe * 1.0D * this.PGU / this.PGT));
      if (this.PGY != null) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 0.0F);
      }
    }
    for (;;)
    {
      if (this.PGY != null)
      {
        this.PGY.gYF();
        ((View)this.PGY).setLayoutParams((ViewGroup.LayoutParams)localObject);
        if ((this.PGY instanceof AdVideoPlayerLoadingBar)) {
          this.mRi.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116170);
              if (!VideoPlayView.a(VideoPlayView.this).isPlaying()) {
                ((AdVideoPlayerLoadingBar)VideoPlayView.c(VideoPlayView.this)).cxb();
              }
              AppMethodBeat.o(116170);
            }
          }, 500L);
        }
      }
      Log.i("MicroMsg.VideoPlayView", "orientation " + paramInt + " " + localLayoutParams1.width + " " + localLayoutParams1.height);
      ((View)this.wCd).setLayoutParams(localLayoutParams1);
      if ((this.wCd instanceof com.tencent.mm.plugin.sight.decode.model.a)) {
        ((com.tencent.mm.plugin.sight.decode.model.a)this.wCd).ld(localLayoutParams1.width, localLayoutParams1.height);
      }
      localLayoutParams.height = localLayoutParams1.height;
      localLayoutParams.width = localLayoutParams1.width;
      this.PGX.setLayoutParams(localLayoutParams);
      ((View)this.wCd).requestLayout();
      AppMethodBeat.o(116198);
      return;
      localObject = (RelativeLayout.LayoutParams)((View)this.PGY).getLayoutParams();
      break;
      label410:
      localLayoutParams1.height = this.PHe;
      localLayoutParams1.width = ((int)(this.PHe * 1.0D * this.PGT / this.PGU));
      if (this.PGY != null) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 0.0F);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Di(boolean paramBoolean);
    
    public abstract void ajp(int paramInt);
    
    public abstract void gYM();
    
    public abstract void gYN();
    
    public abstract void gYO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView
 * JD-Core Version:    0.7.0.1
 */