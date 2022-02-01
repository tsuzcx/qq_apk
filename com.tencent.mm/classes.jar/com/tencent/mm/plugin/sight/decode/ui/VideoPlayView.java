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
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.pluginsdk.ui.tools.j.b;
import com.tencent.mm.pluginsdk.ui.tools.j.c;
import com.tencent.mm.pluginsdk.ui.tools.j.d;
import com.tencent.mm.pluginsdk.ui.tools.j.e;
import com.tencent.mm.pluginsdk.ui.tools.v;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class VideoPlayView
  extends RelativeLayout
  implements d.a, j
{
  private int DnP;
  private int DnQ;
  private boolean DnR;
  private a DnS;
  private ViewGroup DnT;
  public a DnU;
  private double DnV;
  public TextView DnW;
  public String DnX;
  public ImageView DnY;
  public boolean DnZ;
  private int Doa;
  private int Dob;
  private boolean Doc;
  private boolean Dod;
  private long Doe;
  private Animation Dof;
  private Animation Dog;
  private Runnable Doh;
  public int Doi;
  private int duration;
  private String fullPath;
  private boolean guh;
  private MMHandler hAk;
  private View hRd;
  private ProgressBar krF;
  public View maskView;
  public j qbJ;
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116172);
    this.DnP = 320;
    this.DnQ = 240;
    this.DnR = true;
    this.qbJ = null;
    this.DnV = 0.0D;
    this.DnX = "";
    this.hAk = new MMHandler();
    this.DnZ = true;
    this.duration = 0;
    this.Doa = 0;
    this.Dob = 0;
    this.Doc = false;
    this.Dod = false;
    this.Doe = 0L;
    this.Dof = new AlphaAnimation(1.0F, 0.0F);
    this.Dog = new AlphaAnimation(0.0F, 1.0F);
    this.Doh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116165);
        VideoPlayView.this.eVP();
        AppMethodBeat.o(116165);
      }
    };
    this.Doi = 0;
    this.guh = false;
    init();
    AppMethodBeat.o(116172);
  }
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(116173);
    this.DnP = 320;
    this.DnQ = 240;
    this.DnR = true;
    this.qbJ = null;
    this.DnV = 0.0D;
    this.DnX = "";
    this.hAk = new MMHandler();
    this.DnZ = true;
    this.duration = 0;
    this.Doa = 0;
    this.Dob = 0;
    this.Doc = false;
    this.Dod = false;
    this.Doe = 0L;
    this.Dof = new AlphaAnimation(1.0F, 0.0F);
    this.Dog = new AlphaAnimation(0.0F, 1.0F);
    this.Doh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116165);
        VideoPlayView.this.eVP();
        AppMethodBeat.o(116165);
      }
    };
    this.Doi = 0;
    this.guh = false;
    init();
    AppMethodBeat.o(116173);
  }
  
  private void XG(int paramInt)
  {
    AppMethodBeat.i(116185);
    if (paramInt >= 0) {}
    for (double d = paramInt;; d = this.qbJ.getLastProgresstime())
    {
      this.DnV = d;
      Log.i("MicroMsg.VideoPlayView", "pause play " + this.DnV + " lastTime: " + paramInt + " last " + this.qbJ.getLastProgresstime());
      this.qbJ.pause();
      this.hAk.post(new Runnable()
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
      if (this.DnS != null) {
        this.DnS.eVQ();
      }
      AppMethodBeat.o(116185);
      return;
    }
  }
  
  private void eVO()
  {
    AppMethodBeat.i(116178);
    ((View)this.DnU).setVisibility(0);
    this.hRd.setVisibility(0);
    if (this.DnZ) {
      this.DnY.setVisibility(0);
    }
    int i;
    if (this.Doi == 2) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        this.maskView.setVisibility(0);
      }
      this.hAk.removeCallbacks(this.Doh);
      this.hAk.postDelayed(this.Doh, 3000L);
      AppMethodBeat.o(116178);
      return;
      if (Util.isNullOrNil(this.DnX)) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(116174);
    this.Dof.setDuration(200L);
    this.Dog.setDuration(200L);
    View.inflate(getContext(), 2131496800, this);
    this.hRd = findViewById(2131305955);
    this.DnY = ((ImageView)findViewById(2131304604));
    this.DnY.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.krF = ((ProgressBar)findViewById(2131306302));
    this.DnT = ((ViewGroup)findViewById(2131309736));
    this.qbJ = v.iE(getContext());
    this.qbJ.setLoop(false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.DnT.addView((View)this.qbJ, 0, localLayoutParams);
    this.DnW = ((TextView)findViewById(2131307859));
    this.maskView = this.DnW;
    this.qbJ.setVideoCallback(new j.a()
    {
      public final void eo(int paramAnonymousInt1, int paramAnonymousInt2)
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
              VideoPlayView.e(VideoPlayView.this, VideoPlayView.this.Doi);
              AppMethodBeat.o(116157);
            }
          });
        }
        AppMethodBeat.o(116162);
      }
      
      public final int fh(final int paramAnonymousInt1, final int paramAnonymousInt2)
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
              VideoPlayView.f(VideoPlayView.this).XH(paramAnonymousInt2);
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
            VideoPlayView.f(VideoPlayView.this).eVR();
            AppMethodBeat.o(116160);
          }
        }
        else
        {
          VideoPlayView.c(VideoPlayView.this).setIsPlay(false);
          VideoPlayView.a(VideoPlayView.this, (int)VideoPlayView.g(VideoPlayView.this));
          VideoPlayView.d(VideoPlayView.this);
          if (VideoPlayView.f(VideoPlayView.this) != null) {
            VideoPlayView.f(VideoPlayView.this).eVS();
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
      
      public final void tf()
      {
        AppMethodBeat.i(116158);
        Log.d("MicroMsg.VideoPlayView", f.app() + " onPrepared");
        VideoPlayView.a(VideoPlayView.this, true);
        AppMethodBeat.o(116158);
      }
    });
    if ((this.qbJ instanceof VideoSightView)) {
      ((VideoSightView)this.qbJ).setEnableConfigChanged(false);
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
    eVP();
    ((View)this.qbJ).post(new Runnable()
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
  
  private void uF(boolean paramBoolean)
  {
    AppMethodBeat.i(116184);
    this.qbJ.q(this.DnV);
    this.qbJ.start();
    Log.i("MicroMsg.VideoPlayView", "startplay get duration " + this.duration + " lastPlayProgressTime: " + this.DnV);
    if (this.DnS != null) {
      this.DnS.uG(paramBoolean);
    }
    AppMethodBeat.o(116184);
  }
  
  public final boolean E(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(116187);
    paramBoolean = this.qbJ.E(paramContext, paramBoolean);
    AppMethodBeat.o(116187);
    return paramBoolean;
  }
  
  public final void aTw() {}
  
  public final void aTx() {}
  
  public final void aTy() {}
  
  public final void aTz() {}
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(116199);
    q(paramDouble);
    AppMethodBeat.o(116199);
  }
  
  public final void eVN()
  {
    AppMethodBeat.i(116177);
    this.krF.setVisibility(0);
    AppMethodBeat.o(116177);
  }
  
  public final void eVP()
  {
    AppMethodBeat.i(116179);
    if (this.DnU != null) {
      ((View)this.DnU).setVisibility(4);
    }
    this.hRd.setVisibility(8);
    this.DnY.setVisibility(8);
    this.maskView.setVisibility(8);
    AppMethodBeat.o(116179);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(116193);
    int i = this.qbJ.getCurrentPosition();
    AppMethodBeat.o(116193);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116194);
    if (this.duration == 0)
    {
      i = this.qbJ.getDuration();
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
    double d = Math.max(this.DnV, this.qbJ.getLastProgresstime());
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
    boolean bool = this.qbJ.isPlaying();
    AppMethodBeat.o(116186);
    return bool;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(116189);
    this.qbJ.onDetach();
    AppMethodBeat.o(116189);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(116183);
    XG(-1);
    AppMethodBeat.o(116183);
  }
  
  public final void q(double paramDouble)
  {
    AppMethodBeat.i(116196);
    this.qbJ.q(paramDouble);
    this.DnU.seek((int)paramDouble);
    AppMethodBeat.o(116196);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setIsDownloading(boolean paramBoolean)
  {
    AppMethodBeat.i(116176);
    this.Doc = paramBoolean;
    Object localObject;
    if ((this.qbJ != null) && ((this.qbJ instanceof VideoSightView)))
    {
      localObject = (VideoSightView)this.qbJ;
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
      ((com.tencent.mm.plugin.sight.decode.a.b)localObject).DmL = paramBoolean;
      AppMethodBeat.o(116176);
      return;
    }
  }
  
  public void setLeftButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116180);
    this.hRd.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116180);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(116190);
    this.qbJ.setLoop(paramBoolean);
    AppMethodBeat.o(116190);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.guh = paramBoolean;
  }
  
  public void setOnInfoCallback(j.b paramb) {}
  
  public void setOnSeekCompleteCallback(j.c paramc) {}
  
  public void setOnSurfaceCallback(j.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(j.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(116197);
    this.qbJ.setPlayProgressCallback(paramBoolean);
    AppMethodBeat.o(116197);
  }
  
  public void setRightButtonOnCliclListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116181);
    this.DnY.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116181);
  }
  
  public void setThumb(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116195);
    this.qbJ.setThumb(paramBitmap);
    AppMethodBeat.o(116195);
  }
  
  public void setVideoCallback(j.a parama)
  {
    AppMethodBeat.i(116192);
    this.qbJ.setVideoCallback(parama);
    AppMethodBeat.o(116192);
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(116171);
    this.fullPath = paramString;
    Log.i("MicroMsg.VideoPlayView", "videoPath  %s", new Object[] { this.fullPath });
    this.qbJ.setVideoPath(this.fullPath);
    AppMethodBeat.o(116171);
  }
  
  public void setVideoPlayViewEvent(a parama)
  {
    this.DnS = parama;
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(116175);
    if (this.DnU.getVideoTotalTime() != paramInt) {
      this.DnU.setVideoTotalTime(paramInt);
    }
    AppMethodBeat.o(116175);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(116182);
    uF(true);
    AppMethodBeat.o(116182);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(116188);
    this.qbJ.stop();
    AppMethodBeat.o(116188);
  }
  
  public final void update(int paramInt)
  {
    AppMethodBeat.i(116198);
    this.Dod = true;
    Object localObject;
    if ((this.Dob == 0) || (this.Doa == 0))
    {
      localObject = getResources().getDisplayMetrics();
      this.Dob = ((DisplayMetrics)localObject).heightPixels;
      this.Doa = ((DisplayMetrics)localObject).widthPixels;
      if (this.Dob < this.Doa)
      {
        this.Dob = ((DisplayMetrics)localObject).widthPixels;
        this.Doa = ((DisplayMetrics)localObject).heightPixels;
      }
      Log.i("MicroMsg.VideoPlayView", "getScreen screen_height:" + this.Dob + " screen_width:" + this.Doa);
    }
    ViewGroup.LayoutParams localLayoutParams = this.DnT.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1;
    if (this.DnU == null)
    {
      localObject = null;
      localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
      if (paramInt != 1) {
        break label410;
      }
      localLayoutParams1.width = this.Doa;
      localLayoutParams1.height = ((int)(this.Doa * 1.0D * this.DnQ / this.DnP));
      if (this.DnU != null) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 0.0F);
      }
    }
    for (;;)
    {
      if (this.DnU != null)
      {
        this.DnU.eVJ();
        ((View)this.DnU).setLayoutParams((ViewGroup.LayoutParams)localObject);
        if ((this.DnU instanceof AdVideoPlayerLoadingBar)) {
          this.hAk.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116170);
              if (!VideoPlayView.a(VideoPlayView.this).isPlaying()) {
                ((AdVideoPlayerLoadingBar)VideoPlayView.c(VideoPlayView.this)).bKO();
              }
              AppMethodBeat.o(116170);
            }
          }, 500L);
        }
      }
      Log.i("MicroMsg.VideoPlayView", "orientation " + paramInt + " " + localLayoutParams1.width + " " + localLayoutParams1.height);
      ((View)this.qbJ).setLayoutParams(localLayoutParams1);
      if ((this.qbJ instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
        ((com.tencent.mm.plugin.sight.decode.a.a)this.qbJ).im(localLayoutParams1.width, localLayoutParams1.height);
      }
      localLayoutParams.height = localLayoutParams1.height;
      localLayoutParams.width = localLayoutParams1.width;
      this.DnT.setLayoutParams(localLayoutParams);
      ((View)this.qbJ).requestLayout();
      AppMethodBeat.o(116198);
      return;
      localObject = (RelativeLayout.LayoutParams)((View)this.DnU).getLayoutParams();
      break;
      label410:
      localLayoutParams1.height = this.Doa;
      localLayoutParams1.width = ((int)(this.Doa * 1.0D * this.DnP / this.DnQ));
      if (this.DnU != null) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 0.0F);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void XH(int paramInt);
    
    public abstract void eVQ();
    
    public abstract void eVR();
    
    public abstract void eVS();
    
    public abstract void uG(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView
 * JD-Core Version:    0.7.0.1
 */