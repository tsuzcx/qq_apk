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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;

public class VideoPlayView
  extends RelativeLayout
  implements d.a, h
{
  private int duration;
  private boolean ftN;
  private View gBO;
  public View gGk;
  private String gKe;
  private ao gox;
  private ProgressBar iXo;
  public h odZ;
  private int xEe;
  private int xEf;
  private boolean xEg;
  private a xEh;
  private ViewGroup xEi;
  public a xEj;
  private double xEk;
  public TextView xEl;
  public String xEm;
  public ImageView xEn;
  public boolean xEo;
  private int xEp;
  private int xEq;
  private boolean xEr;
  private boolean xEs;
  private long xEt;
  private Animation xEu;
  private Animation xEv;
  private Runnable xEw;
  public int xEx;
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116172);
    this.xEe = 320;
    this.xEf = 240;
    this.xEg = true;
    this.odZ = null;
    this.xEk = 0.0D;
    this.xEm = "";
    this.gox = new ao();
    this.xEo = true;
    this.duration = 0;
    this.xEp = 0;
    this.xEq = 0;
    this.xEr = false;
    this.xEs = false;
    this.xEt = 0L;
    this.xEu = new AlphaAnimation(1.0F, 0.0F);
    this.xEv = new AlphaAnimation(0.0F, 1.0F);
    this.xEw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116165);
        VideoPlayView.this.dEQ();
        AppMethodBeat.o(116165);
      }
    };
    this.xEx = 0;
    this.ftN = false;
    init();
    AppMethodBeat.o(116172);
  }
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(116173);
    this.xEe = 320;
    this.xEf = 240;
    this.xEg = true;
    this.odZ = null;
    this.xEk = 0.0D;
    this.xEm = "";
    this.gox = new ao();
    this.xEo = true;
    this.duration = 0;
    this.xEp = 0;
    this.xEq = 0;
    this.xEr = false;
    this.xEs = false;
    this.xEt = 0L;
    this.xEu = new AlphaAnimation(1.0F, 0.0F);
    this.xEv = new AlphaAnimation(0.0F, 1.0F);
    this.xEw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116165);
        VideoPlayView.this.dEQ();
        AppMethodBeat.o(116165);
      }
    };
    this.xEx = 0;
    this.ftN = false;
    init();
    AppMethodBeat.o(116173);
  }
  
  private void NS(int paramInt)
  {
    AppMethodBeat.i(116185);
    if (paramInt >= 0) {}
    for (double d = paramInt;; d = this.odZ.getLastProgresstime())
    {
      this.xEk = d;
      ac.i("MicroMsg.VideoPlayView", "pause play " + this.xEk + " lastTime: " + paramInt + " last " + this.odZ.getLastProgresstime());
      this.odZ.pause();
      this.gox.post(new Runnable()
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
      if (this.xEh != null) {
        this.xEh.dER();
      }
      AppMethodBeat.o(116185);
      return;
    }
  }
  
  private void dEP()
  {
    AppMethodBeat.i(116178);
    ((View)this.xEj).setVisibility(0);
    this.gBO.setVisibility(0);
    if (this.xEo) {
      this.xEn.setVisibility(0);
    }
    int i;
    if (this.xEx == 2) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        this.gGk.setVisibility(0);
      }
      this.gox.removeCallbacks(this.xEw);
      this.gox.postDelayed(this.xEw, 3000L);
      AppMethodBeat.o(116178);
      return;
      if (bs.isNullOrNil(this.xEm)) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(116174);
    this.xEu.setDuration(200L);
    this.xEv.setDuration(200L);
    View.inflate(getContext(), 2131495832, this);
    this.gBO = findViewById(2131303282);
    this.xEn = ((ImageView)findViewById(2131302238));
    this.xEn.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.iXo = ((ProgressBar)findViewById(2131303535));
    this.xEi = ((ViewGroup)findViewById(2131306317));
    this.odZ = t.hz(getContext());
    this.odZ.setLoop(false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.xEi.addView((View)this.odZ, 0, localLayoutParams);
    this.xEl = ((TextView)findViewById(2131304777));
    this.gGk = this.xEl;
    this.odZ.setVideoCallback(new h.a()
    {
      public final void dZ(int paramAnonymousInt1, int paramAnonymousInt2)
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
              VideoPlayView.e(VideoPlayView.this, VideoPlayView.this.xEx);
              AppMethodBeat.o(116157);
            }
          });
        }
        AppMethodBeat.o(116162);
      }
      
      public final int eP(final int paramAnonymousInt1, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(116161);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116156);
            ac.i("MicroMsg.VideoPlayView", "play time " + paramAnonymousInt1 + " video time " + paramAnonymousInt2);
            if (paramAnonymousInt2 > 0)
            {
              VideoPlayView.b(VideoPlayView.this, paramAnonymousInt2);
              if ((VideoPlayView.c(VideoPlayView.this) != null) && (VideoPlayView.h(VideoPlayView.this))) {
                VideoPlayView.i(VideoPlayView.this);
              }
              VideoPlayView.f(VideoPlayView.this).NT(paramAnonymousInt2);
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
        ac.d("MicroMsg.VideoPlayView", "on completion " + bs.eWi().toString());
        if (!VideoPlayView.b(VideoPlayView.this))
        {
          VideoPlayView.a(VideoPlayView.this, 0.0D);
          VideoPlayView.this.p(0.0D);
          VideoPlayView.c(VideoPlayView.this).setIsPlay(false);
          VideoPlayView.a(VideoPlayView.this, 0);
          VideoPlayView.d(VideoPlayView.this);
          if (System.currentTimeMillis() - VideoPlayView.e(VideoPlayView.this) < 2000L)
          {
            ac.i("MicroMsg.VideoPlayView", "Too short onCompletion");
            AppMethodBeat.o(116160);
            return;
          }
          VideoPlayView.a(VideoPlayView.this, System.currentTimeMillis());
          if (VideoPlayView.f(VideoPlayView.this) != null)
          {
            VideoPlayView.f(VideoPlayView.this).dES();
            AppMethodBeat.o(116160);
          }
        }
        else
        {
          VideoPlayView.c(VideoPlayView.this).setIsPlay(false);
          VideoPlayView.a(VideoPlayView.this, (int)VideoPlayView.g(VideoPlayView.this));
          VideoPlayView.d(VideoPlayView.this);
          if (VideoPlayView.f(VideoPlayView.this) != null) {
            VideoPlayView.f(VideoPlayView.this).dET();
          }
        }
        AppMethodBeat.o(116160);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(116159);
        ac.e("MicroMsg.VideoPlayView", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        VideoPlayView.a(VideoPlayView.this).stop();
        AppMethodBeat.o(116159);
      }
      
      public final void rB()
      {
        AppMethodBeat.i(116158);
        ac.d("MicroMsg.VideoPlayView", f.YF() + " onPrepared");
        VideoPlayView.a(VideoPlayView.this, true);
        AppMethodBeat.o(116158);
      }
    });
    if ((this.odZ instanceof VideoSightView)) {
      ((VideoSightView)this.odZ).setEnableConfigChanged(false);
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
    dEQ();
    ((View)this.odZ).post(new Runnable()
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
  
  private void qA(boolean paramBoolean)
  {
    AppMethodBeat.i(116184);
    this.odZ.p(this.xEk);
    this.odZ.start();
    ac.i("MicroMsg.VideoPlayView", "startplay get duration " + this.duration + " lastPlayProgressTime: " + this.xEk);
    if (this.xEh != null) {
      this.xEh.qB(paramBoolean);
    }
    AppMethodBeat.o(116184);
  }
  
  public final void axj() {}
  
  public final void axk() {}
  
  public final void axl() {}
  
  public final void axm() {}
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(116199);
    p(paramDouble);
    AppMethodBeat.o(116199);
  }
  
  public final void dEO()
  {
    AppMethodBeat.i(116177);
    this.iXo.setVisibility(0);
    AppMethodBeat.o(116177);
  }
  
  public final void dEQ()
  {
    AppMethodBeat.i(116179);
    if (this.xEj != null) {
      ((View)this.xEj).setVisibility(4);
    }
    this.gBO.setVisibility(8);
    this.xEn.setVisibility(8);
    this.gGk.setVisibility(8);
    AppMethodBeat.o(116179);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(116193);
    int i = this.odZ.getCurrentPosition();
    AppMethodBeat.o(116193);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116194);
    if (this.duration == 0)
    {
      i = this.odZ.getDuration();
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
    double d = Math.max(this.xEk, this.odZ.getLastProgresstime());
    AppMethodBeat.o(116191);
    return d;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return 0L;
  }
  
  public String getVideoPath()
  {
    return this.gKe;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(116186);
    boolean bool = this.odZ.isPlaying();
    AppMethodBeat.o(116186);
    return bool;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(116189);
    this.odZ.onDetach();
    AppMethodBeat.o(116189);
  }
  
  public final void p(double paramDouble)
  {
    AppMethodBeat.i(116196);
    this.odZ.p(paramDouble);
    this.xEj.seek((int)paramDouble);
    AppMethodBeat.o(116196);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(116183);
    NS(-1);
    AppMethodBeat.o(116183);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setIsDownloading(boolean paramBoolean)
  {
    AppMethodBeat.i(116176);
    this.xEr = paramBoolean;
    Object localObject;
    if ((this.odZ != null) && ((this.odZ instanceof VideoSightView)))
    {
      localObject = (VideoSightView)this.odZ;
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
      ((com.tencent.mm.plugin.sight.decode.a.b)localObject).xDa = paramBoolean;
      AppMethodBeat.o(116176);
      return;
    }
  }
  
  public void setLeftButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116180);
    this.gBO.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116180);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(116190);
    this.odZ.setLoop(paramBoolean);
    AppMethodBeat.o(116190);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.ftN = paramBoolean;
  }
  
  public void setOnInfoCallback(h.b paramb) {}
  
  public void setOnSeekCompleteCallback(h.c paramc) {}
  
  public void setOnSurfaceCallback(h.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(h.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(116197);
    this.odZ.setPlayProgressCallback(paramBoolean);
    AppMethodBeat.o(116197);
  }
  
  public void setRightButtonOnCliclListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116181);
    this.xEn.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116181);
  }
  
  public void setThumb(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116195);
    this.odZ.setThumb(paramBitmap);
    AppMethodBeat.o(116195);
  }
  
  public void setVideoCallback(h.a parama)
  {
    AppMethodBeat.i(116192);
    this.odZ.setVideoCallback(parama);
    AppMethodBeat.o(116192);
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(116171);
    this.gKe = paramString;
    ac.i("MicroMsg.VideoPlayView", "videoPath  %s", new Object[] { this.gKe });
    this.odZ.setVideoPath(this.gKe);
    AppMethodBeat.o(116171);
  }
  
  public void setVideoPlayViewEvent(a parama)
  {
    this.xEh = parama;
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(116175);
    if (this.xEj.getVideoTotalTime() != paramInt) {
      this.xEj.setVideoTotalTime(paramInt);
    }
    AppMethodBeat.o(116175);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(116182);
    qA(true);
    AppMethodBeat.o(116182);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(116188);
    this.odZ.stop();
    AppMethodBeat.o(116188);
  }
  
  public final void update(int paramInt)
  {
    AppMethodBeat.i(116198);
    this.xEs = true;
    Object localObject;
    if ((this.xEq == 0) || (this.xEp == 0))
    {
      localObject = getResources().getDisplayMetrics();
      this.xEq = ((DisplayMetrics)localObject).heightPixels;
      this.xEp = ((DisplayMetrics)localObject).widthPixels;
      if (this.xEq < this.xEp)
      {
        this.xEq = ((DisplayMetrics)localObject).widthPixels;
        this.xEp = ((DisplayMetrics)localObject).heightPixels;
      }
      ac.i("MicroMsg.VideoPlayView", "getScreen screen_height:" + this.xEq + " screen_width:" + this.xEp);
    }
    ViewGroup.LayoutParams localLayoutParams = this.xEi.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1;
    if (this.xEj == null)
    {
      localObject = null;
      localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
      if (paramInt != 1) {
        break label410;
      }
      localLayoutParams1.width = this.xEp;
      localLayoutParams1.height = ((int)(this.xEp * 1.0D * this.xEf / this.xEe));
      if (this.xEj != null) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.b.g(getContext(), 0.0F);
      }
    }
    for (;;)
    {
      if (this.xEj != null)
      {
        this.xEj.dEK();
        ((View)this.xEj).setLayoutParams((ViewGroup.LayoutParams)localObject);
        if ((this.xEj instanceof AdVideoPlayerLoadingBar)) {
          this.gox.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116170);
              if (!VideoPlayView.a(VideoPlayView.this).isPlaying()) {
                ((AdVideoPlayerLoadingBar)VideoPlayView.c(VideoPlayView.this)).bkN();
              }
              AppMethodBeat.o(116170);
            }
          }, 500L);
        }
      }
      ac.i("MicroMsg.VideoPlayView", "orientation " + paramInt + " " + localLayoutParams1.width + " " + localLayoutParams1.height);
      ((View)this.odZ).setLayoutParams(localLayoutParams1);
      if ((this.odZ instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
        ((com.tencent.mm.plugin.sight.decode.a.a)this.odZ).hf(localLayoutParams1.width, localLayoutParams1.height);
      }
      localLayoutParams.height = localLayoutParams1.height;
      localLayoutParams.width = localLayoutParams1.width;
      this.xEi.setLayoutParams(localLayoutParams);
      ((View)this.odZ).requestLayout();
      AppMethodBeat.o(116198);
      return;
      localObject = (RelativeLayout.LayoutParams)((View)this.xEj).getLayoutParams();
      break;
      label410:
      localLayoutParams1.height = this.xEp;
      localLayoutParams1.width = ((int)(this.xEp * 1.0D * this.xEe / this.xEf));
      if (this.xEj != null) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.b.g(getContext(), 0.0F);
      }
    }
  }
  
  public final boolean z(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(116187);
    paramBoolean = this.odZ.z(paramContext, paramBoolean);
    AppMethodBeat.o(116187);
    return paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void NT(int paramInt);
    
    public abstract void dER();
    
    public abstract void dES();
    
    public abstract void dET();
    
    public abstract void qB(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView
 * JD-Core Version:    0.7.0.1
 */