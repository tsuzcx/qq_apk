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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public class VideoPlayView
  extends RelativeLayout
  implements d.a, h
{
  private int duration;
  private boolean fqj;
  private ap gAC;
  private String gjt;
  private ProgressBar ixl;
  public View lRB;
  public h nAZ;
  private View qWw;
  private int wsO;
  private int wsP;
  private boolean wsQ;
  private a wsR;
  private ViewGroup wsS;
  public a wsT;
  private double wsU;
  public TextView wsV;
  public String wsW;
  public ImageView wsX;
  public boolean wsY;
  private int wsZ;
  private int wta;
  private boolean wtb;
  private boolean wtc;
  private long wtd;
  private Animation wte;
  private Animation wtf;
  private Runnable wtg;
  public int wth;
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116172);
    this.wsO = 320;
    this.wsP = 240;
    this.wsQ = true;
    this.nAZ = null;
    this.wsU = 0.0D;
    this.wsW = "";
    this.gAC = new ap();
    this.wsY = true;
    this.duration = 0;
    this.wsZ = 0;
    this.wta = 0;
    this.wtb = false;
    this.wtc = false;
    this.wtd = 0L;
    this.wte = new AlphaAnimation(1.0F, 0.0F);
    this.wtf = new AlphaAnimation(0.0F, 1.0F);
    this.wtg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116165);
        VideoPlayView.this.dqH();
        AppMethodBeat.o(116165);
      }
    };
    this.wth = 0;
    this.fqj = false;
    init();
    AppMethodBeat.o(116172);
  }
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(116173);
    this.wsO = 320;
    this.wsP = 240;
    this.wsQ = true;
    this.nAZ = null;
    this.wsU = 0.0D;
    this.wsW = "";
    this.gAC = new ap();
    this.wsY = true;
    this.duration = 0;
    this.wsZ = 0;
    this.wta = 0;
    this.wtb = false;
    this.wtc = false;
    this.wtd = 0L;
    this.wte = new AlphaAnimation(1.0F, 0.0F);
    this.wtf = new AlphaAnimation(0.0F, 1.0F);
    this.wtg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116165);
        VideoPlayView.this.dqH();
        AppMethodBeat.o(116165);
      }
    };
    this.wth = 0;
    this.fqj = false;
    init();
    AppMethodBeat.o(116173);
  }
  
  private void LS(int paramInt)
  {
    AppMethodBeat.i(116185);
    if (paramInt >= 0) {}
    for (double d = paramInt;; d = this.nAZ.getLastProgresstime())
    {
      this.wsU = d;
      ad.i("MicroMsg.VideoPlayView", "pause play " + this.wsU + " lastTime: " + paramInt + " last " + this.nAZ.getLastProgresstime());
      this.nAZ.pause();
      this.gAC.post(new Runnable()
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
      if (this.wsR != null) {
        this.wsR.dqI();
      }
      AppMethodBeat.o(116185);
      return;
    }
  }
  
  private void dqG()
  {
    AppMethodBeat.i(116178);
    ((View)this.wsT).setVisibility(0);
    this.qWw.setVisibility(0);
    if (this.wsY) {
      this.wsX.setVisibility(0);
    }
    int i;
    if (this.wth == 2) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        this.lRB.setVisibility(0);
      }
      this.gAC.removeCallbacks(this.wtg);
      this.gAC.postDelayed(this.wtg, 3000L);
      AppMethodBeat.o(116178);
      return;
      if (bt.isNullOrNil(this.wsW)) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(116174);
    this.wte.setDuration(200L);
    this.wtf.setDuration(200L);
    View.inflate(getContext(), 2131495832, this);
    this.qWw = findViewById(2131303282);
    this.wsX = ((ImageView)findViewById(2131302238));
    this.wsX.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.ixl = ((ProgressBar)findViewById(2131303535));
    this.wsS = ((ViewGroup)findViewById(2131306317));
    this.nAZ = t.ho(getContext());
    this.nAZ.setLoop(false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.wsS.addView((View)this.nAZ, 0, localLayoutParams);
    this.wsV = ((TextView)findViewById(2131304777));
    this.lRB = this.wsV;
    this.nAZ.setVideoCallback(new h.a()
    {
      public final void dY(int paramAnonymousInt1, int paramAnonymousInt2)
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
              VideoPlayView.e(VideoPlayView.this, VideoPlayView.this.wth);
              AppMethodBeat.o(116157);
            }
          });
        }
        AppMethodBeat.o(116162);
      }
      
      public final int eM(final int paramAnonymousInt1, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(116161);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116156);
            ad.i("MicroMsg.VideoPlayView", "play time " + paramAnonymousInt1 + " video time " + paramAnonymousInt2);
            if (paramAnonymousInt2 > 0)
            {
              VideoPlayView.b(VideoPlayView.this, paramAnonymousInt2);
              if ((VideoPlayView.c(VideoPlayView.this) != null) && (VideoPlayView.h(VideoPlayView.this))) {
                VideoPlayView.i(VideoPlayView.this);
              }
              VideoPlayView.f(VideoPlayView.this).LT(paramAnonymousInt2);
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
        ad.d("MicroMsg.VideoPlayView", "on completion " + bt.eGN().toString());
        if (!VideoPlayView.b(VideoPlayView.this))
        {
          VideoPlayView.a(VideoPlayView.this, 0.0D);
          VideoPlayView.this.q(0.0D);
          VideoPlayView.c(VideoPlayView.this).setIsPlay(false);
          VideoPlayView.a(VideoPlayView.this, 0);
          VideoPlayView.d(VideoPlayView.this);
          if (System.currentTimeMillis() - VideoPlayView.e(VideoPlayView.this) < 2000L)
          {
            ad.i("MicroMsg.VideoPlayView", "Too short onCompletion");
            AppMethodBeat.o(116160);
            return;
          }
          VideoPlayView.a(VideoPlayView.this, System.currentTimeMillis());
          if (VideoPlayView.f(VideoPlayView.this) != null)
          {
            VideoPlayView.f(VideoPlayView.this).dqJ();
            AppMethodBeat.o(116160);
          }
        }
        else
        {
          VideoPlayView.c(VideoPlayView.this).setIsPlay(false);
          VideoPlayView.a(VideoPlayView.this, (int)VideoPlayView.g(VideoPlayView.this));
          VideoPlayView.d(VideoPlayView.this);
          if (VideoPlayView.f(VideoPlayView.this) != null) {
            VideoPlayView.f(VideoPlayView.this).dqK();
          }
        }
        AppMethodBeat.o(116160);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(116159);
        ad.e("MicroMsg.VideoPlayView", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        VideoPlayView.a(VideoPlayView.this).stop();
        AppMethodBeat.o(116159);
      }
      
      public final void rq()
      {
        AppMethodBeat.i(116158);
        ad.d("MicroMsg.VideoPlayView", f.XI() + " onPrepared");
        VideoPlayView.a(VideoPlayView.this, true);
        AppMethodBeat.o(116158);
      }
    });
    if ((this.nAZ instanceof VideoSightView)) {
      ((VideoSightView)this.nAZ).setEnableConfigChanged(false);
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
    dqH();
    ((View)this.nAZ).post(new Runnable()
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
  
  private void pB(boolean paramBoolean)
  {
    AppMethodBeat.i(116184);
    this.nAZ.q(this.wsU);
    this.nAZ.start();
    ad.i("MicroMsg.VideoPlayView", "startplay get duration " + this.duration + " lastPlayProgressTime: " + this.wsU);
    if (this.wsR != null) {
      this.wsR.pC(paramBoolean);
    }
    AppMethodBeat.o(116184);
  }
  
  public final void aqt() {}
  
  public final void aqu() {}
  
  public final void aqv() {}
  
  public final void aqw() {}
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(116199);
    q(paramDouble);
    AppMethodBeat.o(116199);
  }
  
  public final void dqF()
  {
    AppMethodBeat.i(116177);
    this.ixl.setVisibility(0);
    AppMethodBeat.o(116177);
  }
  
  public final void dqH()
  {
    AppMethodBeat.i(116179);
    if (this.wsT != null) {
      ((View)this.wsT).setVisibility(4);
    }
    this.qWw.setVisibility(8);
    this.wsX.setVisibility(8);
    this.lRB.setVisibility(8);
    AppMethodBeat.o(116179);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(116193);
    int i = this.nAZ.getCurrentPosition();
    AppMethodBeat.o(116193);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116194);
    if (this.duration == 0)
    {
      i = this.nAZ.getDuration();
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
    double d = Math.max(this.wsU, this.nAZ.getLastProgresstime());
    AppMethodBeat.o(116191);
    return d;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return 0L;
  }
  
  public String getVideoPath()
  {
    return this.gjt;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(116186);
    boolean bool = this.nAZ.isPlaying();
    AppMethodBeat.o(116186);
    return bool;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(116189);
    this.nAZ.onDetach();
    AppMethodBeat.o(116189);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(116183);
    LS(-1);
    AppMethodBeat.o(116183);
  }
  
  public final void q(double paramDouble)
  {
    AppMethodBeat.i(116196);
    this.nAZ.q(paramDouble);
    this.wsT.seek((int)paramDouble);
    AppMethodBeat.o(116196);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setIsDownloading(boolean paramBoolean)
  {
    AppMethodBeat.i(116176);
    this.wtb = paramBoolean;
    Object localObject;
    if ((this.nAZ != null) && ((this.nAZ instanceof VideoSightView)))
    {
      localObject = (VideoSightView)this.nAZ;
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
      ((com.tencent.mm.plugin.sight.decode.a.b)localObject).wrK = paramBoolean;
      AppMethodBeat.o(116176);
      return;
    }
  }
  
  public void setLeftButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116180);
    this.qWw.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116180);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(116190);
    this.nAZ.setLoop(paramBoolean);
    AppMethodBeat.o(116190);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.fqj = paramBoolean;
  }
  
  public void setOnInfoCallback(h.b paramb) {}
  
  public void setOnSeekCompleteCallback(h.c paramc) {}
  
  public void setOnSurfaceCallback(h.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(h.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(116197);
    this.nAZ.setPlayProgressCallback(paramBoolean);
    AppMethodBeat.o(116197);
  }
  
  public void setRightButtonOnCliclListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116181);
    this.wsX.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116181);
  }
  
  public void setThumb(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116195);
    this.nAZ.setThumb(paramBitmap);
    AppMethodBeat.o(116195);
  }
  
  public void setVideoCallback(h.a parama)
  {
    AppMethodBeat.i(116192);
    this.nAZ.setVideoCallback(parama);
    AppMethodBeat.o(116192);
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(116171);
    this.gjt = paramString;
    ad.i("MicroMsg.VideoPlayView", "videoPath  %s", new Object[] { this.gjt });
    this.nAZ.setVideoPath(this.gjt);
    AppMethodBeat.o(116171);
  }
  
  public void setVideoPlayViewEvent(a parama)
  {
    this.wsR = parama;
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(116175);
    if (this.wsT.getVideoTotalTime() != paramInt) {
      this.wsT.setVideoTotalTime(paramInt);
    }
    AppMethodBeat.o(116175);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(116182);
    pB(true);
    AppMethodBeat.o(116182);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(116188);
    this.nAZ.stop();
    AppMethodBeat.o(116188);
  }
  
  public final void update(int paramInt)
  {
    AppMethodBeat.i(116198);
    this.wtc = true;
    Object localObject;
    if ((this.wta == 0) || (this.wsZ == 0))
    {
      localObject = getResources().getDisplayMetrics();
      this.wta = ((DisplayMetrics)localObject).heightPixels;
      this.wsZ = ((DisplayMetrics)localObject).widthPixels;
      if (this.wta < this.wsZ)
      {
        this.wta = ((DisplayMetrics)localObject).widthPixels;
        this.wsZ = ((DisplayMetrics)localObject).heightPixels;
      }
      ad.i("MicroMsg.VideoPlayView", "getScreen screen_height:" + this.wta + " screen_width:" + this.wsZ);
    }
    ViewGroup.LayoutParams localLayoutParams = this.wsS.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1;
    if (this.wsT == null)
    {
      localObject = null;
      localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
      if (paramInt != 1) {
        break label410;
      }
      localLayoutParams1.width = this.wsZ;
      localLayoutParams1.height = ((int)(this.wsZ * 1.0D * this.wsP / this.wsO));
      if (this.wsT != null) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.b.g(getContext(), 0.0F);
      }
    }
    for (;;)
    {
      if (this.wsT != null)
      {
        this.wsT.dqB();
        ((View)this.wsT).setLayoutParams((ViewGroup.LayoutParams)localObject);
        if ((this.wsT instanceof AdVideoPlayerLoadingBar)) {
          this.gAC.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116170);
              if (!VideoPlayView.a(VideoPlayView.this).isPlaying()) {
                ((AdVideoPlayerLoadingBar)VideoPlayView.c(VideoPlayView.this)).bdT();
              }
              AppMethodBeat.o(116170);
            }
          }, 500L);
        }
      }
      ad.i("MicroMsg.VideoPlayView", "orientation " + paramInt + " " + localLayoutParams1.width + " " + localLayoutParams1.height);
      ((View)this.nAZ).setLayoutParams(localLayoutParams1);
      if ((this.nAZ instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
        ((com.tencent.mm.plugin.sight.decode.a.a)this.nAZ).gW(localLayoutParams1.width, localLayoutParams1.height);
      }
      localLayoutParams.height = localLayoutParams1.height;
      localLayoutParams.width = localLayoutParams1.width;
      this.wsS.setLayoutParams(localLayoutParams);
      ((View)this.nAZ).requestLayout();
      AppMethodBeat.o(116198);
      return;
      localObject = (RelativeLayout.LayoutParams)((View)this.wsT).getLayoutParams();
      break;
      label410:
      localLayoutParams1.height = this.wsZ;
      localLayoutParams1.width = ((int)(this.wsZ * 1.0D * this.wsO / this.wsP));
      if (this.wsT != null) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.b.g(getContext(), 0.0F);
      }
    }
  }
  
  public final boolean y(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(116187);
    paramBoolean = this.nAZ.y(paramContext, paramBoolean);
    AppMethodBeat.o(116187);
    return paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void LT(int paramInt);
    
    public abstract void dqI();
    
    public abstract void dqJ();
    
    public abstract void dqK();
    
    public abstract void pC(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView
 * JD-Core Version:    0.7.0.1
 */