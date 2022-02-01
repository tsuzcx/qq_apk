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
import com.tencent.mm.plugin.aq.a.e;
import com.tencent.mm.plugin.aq.a.f;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.pluginsdk.ui.tools.k.b;
import com.tencent.mm.pluginsdk.ui.tools.k.c;
import com.tencent.mm.pluginsdk.ui.tools.k.d;
import com.tencent.mm.pluginsdk.ui.tools.k.e;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class VideoPlayView
  extends RelativeLayout
  implements d.a, k
{
  private double JtA;
  public TextView JtB;
  public String JtC;
  public ImageView JtD;
  public boolean JtE;
  private int JtF;
  private int JtG;
  private boolean JtH;
  private boolean JtI;
  private long JtJ;
  private Animation JtK;
  private Animation JtL;
  private Runnable JtM;
  public int JtN;
  private int Jtu;
  private int Jtv;
  private boolean Jtw;
  private a Jtx;
  private ViewGroup Jty;
  public a Jtz;
  private int duration;
  private String fullPath;
  private boolean iYs;
  private View kFA;
  private MMHandler knk;
  public View maskView;
  private ProgressBar njo;
  public k txH;
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116172);
    this.Jtu = 320;
    this.Jtv = 240;
    this.Jtw = true;
    this.txH = null;
    this.JtA = 0.0D;
    this.JtC = "";
    this.knk = new MMHandler();
    this.JtE = true;
    this.duration = 0;
    this.JtF = 0;
    this.JtG = 0;
    this.JtH = false;
    this.JtI = false;
    this.JtJ = 0L;
    this.JtK = new AlphaAnimation(1.0F, 0.0F);
    this.JtL = new AlphaAnimation(0.0F, 1.0F);
    this.JtM = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116165);
        VideoPlayView.this.fIS();
        AppMethodBeat.o(116165);
      }
    };
    this.JtN = 0;
    this.iYs = false;
    init();
    AppMethodBeat.o(116172);
  }
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(116173);
    this.Jtu = 320;
    this.Jtv = 240;
    this.Jtw = true;
    this.txH = null;
    this.JtA = 0.0D;
    this.JtC = "";
    this.knk = new MMHandler();
    this.JtE = true;
    this.duration = 0;
    this.JtF = 0;
    this.JtG = 0;
    this.JtH = false;
    this.JtI = false;
    this.JtJ = 0L;
    this.JtK = new AlphaAnimation(1.0F, 0.0F);
    this.JtL = new AlphaAnimation(0.0F, 1.0F);
    this.JtM = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116165);
        VideoPlayView.this.fIS();
        AppMethodBeat.o(116165);
      }
    };
    this.JtN = 0;
    this.iYs = false;
    init();
    AppMethodBeat.o(116173);
  }
  
  private void aeF(int paramInt)
  {
    AppMethodBeat.i(116185);
    if (paramInt >= 0) {}
    for (double d = paramInt;; d = this.txH.getLastProgresstime())
    {
      this.JtA = d;
      Log.i("MicroMsg.VideoPlayView", "pause play " + this.JtA + " lastTime: " + paramInt + " last " + this.txH.getLastProgresstime());
      this.txH.pause();
      this.knk.post(new Runnable()
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
      if (this.Jtx != null) {
        this.Jtx.fIT();
      }
      AppMethodBeat.o(116185);
      return;
    }
  }
  
  private void fIR()
  {
    AppMethodBeat.i(116178);
    ((View)this.Jtz).setVisibility(0);
    this.kFA.setVisibility(0);
    if (this.JtE) {
      this.JtD.setVisibility(0);
    }
    int i;
    if (this.JtN == 2) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        this.maskView.setVisibility(0);
      }
      this.knk.removeCallbacks(this.JtM);
      this.knk.postDelayed(this.JtM, 3000L);
      AppMethodBeat.o(116178);
      return;
      if (Util.isNullOrNil(this.JtC)) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(116174);
    this.JtK.setDuration(200L);
    this.JtL.setDuration(200L);
    View.inflate(getContext(), a.f.video_play_view, this);
    this.kFA = findViewById(a.e.play_close_btn);
    this.JtD = ((ImageView)findViewById(a.e.menu_btn));
    this.JtD.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.njo = ((ProgressBar)findViewById(a.e.progressbar));
    this.Jty = ((ViewGroup)findViewById(a.e.video_container));
    this.txH = x.jH(getContext());
    this.txH.setLoop(false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.Jty.addView((View)this.txH, 0, localLayoutParams);
    this.JtB = ((TextView)findViewById(a.e.show_ad_sight));
    this.maskView = this.JtB;
    this.txH.setVideoCallback(new k.a()
    {
      public final void eM(int paramAnonymousInt1, int paramAnonymousInt2)
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
              VideoPlayView.e(VideoPlayView.this, VideoPlayView.this.JtN);
              AppMethodBeat.o(116157);
            }
          });
        }
        AppMethodBeat.o(116162);
      }
      
      public final int fE(final int paramAnonymousInt1, final int paramAnonymousInt2)
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
              VideoPlayView.f(VideoPlayView.this).aeG(paramAnonymousInt2);
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
          VideoPlayView.this.q(0.0D);
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
            VideoPlayView.f(VideoPlayView.this).fIU();
            AppMethodBeat.o(116160);
          }
        }
        else
        {
          VideoPlayView.c(VideoPlayView.this).setIsPlay(false);
          VideoPlayView.a(VideoPlayView.this, (int)VideoPlayView.g(VideoPlayView.this));
          VideoPlayView.d(VideoPlayView.this);
          if (VideoPlayView.f(VideoPlayView.this) != null) {
            VideoPlayView.f(VideoPlayView.this).fIV();
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
      
      public final void qX()
      {
        AppMethodBeat.i(116158);
        Log.d("MicroMsg.VideoPlayView", f.avC() + " onPrepared");
        VideoPlayView.a(VideoPlayView.this, true);
        AppMethodBeat.o(116158);
      }
    });
    if ((this.txH instanceof VideoSightView)) {
      ((VideoSightView)this.txH).setEnableConfigChanged(false);
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
    fIS();
    ((View)this.txH).post(new Runnable()
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
  
  private void yd(boolean paramBoolean)
  {
    AppMethodBeat.i(116184);
    this.txH.q(this.JtA);
    this.txH.start();
    Log.i("MicroMsg.VideoPlayView", "startplay get duration " + this.duration + " lastPlayProgressTime: " + this.JtA);
    if (this.Jtx != null) {
      this.Jtx.ye(paramBoolean);
    }
    AppMethodBeat.o(116184);
  }
  
  public final boolean I(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(116187);
    paramBoolean = this.txH.I(paramContext, paramBoolean);
    AppMethodBeat.o(116187);
    return paramBoolean;
  }
  
  public final void b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(116199);
    q(paramDouble);
    AppMethodBeat.o(116199);
  }
  
  public final void bcu() {}
  
  public final void bcv() {}
  
  public final void bcw() {}
  
  public final void bcx() {}
  
  public final void fIQ()
  {
    AppMethodBeat.i(116177);
    this.njo.setVisibility(0);
    AppMethodBeat.o(116177);
  }
  
  public final void fIS()
  {
    AppMethodBeat.i(116179);
    if (this.Jtz != null) {
      ((View)this.Jtz).setVisibility(4);
    }
    this.kFA.setVisibility(8);
    this.JtD.setVisibility(8);
    this.maskView.setVisibility(8);
    AppMethodBeat.o(116179);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(116193);
    int i = this.txH.getCurrentPosition();
    AppMethodBeat.o(116193);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116194);
    if (this.duration == 0)
    {
      i = this.txH.getDuration();
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
    double d = Math.max(this.JtA, this.txH.getLastProgresstime());
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
    boolean bool = this.txH.isPlaying();
    AppMethodBeat.o(116186);
    return bool;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(116189);
    this.txH.onDetach();
    AppMethodBeat.o(116189);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(116183);
    aeF(-1);
    AppMethodBeat.o(116183);
  }
  
  public final void q(double paramDouble)
  {
    AppMethodBeat.i(116196);
    this.txH.q(paramDouble);
    this.Jtz.seek((int)paramDouble);
    AppMethodBeat.o(116196);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setIsDownloading(boolean paramBoolean)
  {
    AppMethodBeat.i(116176);
    this.JtH = paramBoolean;
    Object localObject;
    if ((this.txH != null) && ((this.txH instanceof VideoSightView)))
    {
      localObject = (VideoSightView)this.txH;
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
      ((com.tencent.mm.plugin.sight.decode.a.b)localObject).Jsq = paramBoolean;
      AppMethodBeat.o(116176);
      return;
    }
  }
  
  public void setLeftButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116180);
    this.kFA.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116180);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(116190);
    this.txH.setLoop(paramBoolean);
    AppMethodBeat.o(116190);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.iYs = paramBoolean;
  }
  
  public void setOnInfoCallback(k.b paramb) {}
  
  public void setOnSeekCompleteCallback(k.c paramc) {}
  
  public void setOnSurfaceCallback(k.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(k.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(116197);
    this.txH.setPlayProgressCallback(paramBoolean);
    AppMethodBeat.o(116197);
  }
  
  public void setRightButtonOnCliclListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116181);
    this.JtD.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116181);
  }
  
  public void setThumb(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116195);
    this.txH.setThumb(paramBitmap);
    AppMethodBeat.o(116195);
  }
  
  public void setVideoCallback(k.a parama)
  {
    AppMethodBeat.i(116192);
    this.txH.setVideoCallback(parama);
    AppMethodBeat.o(116192);
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(116171);
    this.fullPath = paramString;
    Log.i("MicroMsg.VideoPlayView", "videoPath  %s", new Object[] { this.fullPath });
    this.txH.setVideoPath(this.fullPath);
    AppMethodBeat.o(116171);
  }
  
  public void setVideoPlayViewEvent(a parama)
  {
    this.Jtx = parama;
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(116175);
    if (this.Jtz.getVideoTotalTime() != paramInt) {
      this.Jtz.setVideoTotalTime(paramInt);
    }
    AppMethodBeat.o(116175);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(116182);
    yd(true);
    AppMethodBeat.o(116182);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(116188);
    this.txH.stop();
    AppMethodBeat.o(116188);
  }
  
  public final void update(int paramInt)
  {
    AppMethodBeat.i(116198);
    this.JtI = true;
    Object localObject;
    if ((this.JtG == 0) || (this.JtF == 0))
    {
      localObject = getResources().getDisplayMetrics();
      this.JtG = ((DisplayMetrics)localObject).heightPixels;
      this.JtF = ((DisplayMetrics)localObject).widthPixels;
      if (this.JtG < this.JtF)
      {
        this.JtG = ((DisplayMetrics)localObject).widthPixels;
        this.JtF = ((DisplayMetrics)localObject).heightPixels;
      }
      Log.i("MicroMsg.VideoPlayView", "getScreen screen_height:" + this.JtG + " screen_width:" + this.JtF);
    }
    ViewGroup.LayoutParams localLayoutParams = this.Jty.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1;
    if (this.Jtz == null)
    {
      localObject = null;
      localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
      if (paramInt != 1) {
        break label410;
      }
      localLayoutParams1.width = this.JtF;
      localLayoutParams1.height = ((int)(this.JtF * 1.0D * this.Jtv / this.Jtu));
      if (this.Jtz != null) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 0.0F);
      }
    }
    for (;;)
    {
      if (this.Jtz != null)
      {
        this.Jtz.fIM();
        ((View)this.Jtz).setLayoutParams((ViewGroup.LayoutParams)localObject);
        if ((this.Jtz instanceof AdVideoPlayerLoadingBar)) {
          this.knk.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116170);
              if (!VideoPlayView.a(VideoPlayView.this).isPlaying()) {
                ((AdVideoPlayerLoadingBar)VideoPlayView.c(VideoPlayView.this)).bWO();
              }
              AppMethodBeat.o(116170);
            }
          }, 500L);
        }
      }
      Log.i("MicroMsg.VideoPlayView", "orientation " + paramInt + " " + localLayoutParams1.width + " " + localLayoutParams1.height);
      ((View)this.txH).setLayoutParams(localLayoutParams1);
      if ((this.txH instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
        ((com.tencent.mm.plugin.sight.decode.a.a)this.txH).ju(localLayoutParams1.width, localLayoutParams1.height);
      }
      localLayoutParams.height = localLayoutParams1.height;
      localLayoutParams.width = localLayoutParams1.width;
      this.Jty.setLayoutParams(localLayoutParams);
      ((View)this.txH).requestLayout();
      AppMethodBeat.o(116198);
      return;
      localObject = (RelativeLayout.LayoutParams)((View)this.Jtz).getLayoutParams();
      break;
      label410:
      localLayoutParams1.height = this.JtF;
      localLayoutParams1.width = ((int)(this.JtF * 1.0D * this.Jtu / this.Jtv));
      if (this.Jtz != null) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 0.0F);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void aeG(int paramInt);
    
    public abstract void fIT();
    
    public abstract void fIU();
    
    public abstract void fIV();
    
    public abstract void ye(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView
 * JD-Core Version:    0.7.0.1
 */