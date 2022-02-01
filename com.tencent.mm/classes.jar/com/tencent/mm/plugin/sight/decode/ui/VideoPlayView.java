package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
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
  private boolean fMP;
  private ap gIf;
  private View gVy;
  public View gZU;
  private String hdP;
  private ProgressBar jqx;
  public h oHt;
  private int ySO;
  private int ySP;
  private boolean ySQ;
  private a ySR;
  private ViewGroup ySS;
  public a yST;
  private double ySU;
  public TextView ySV;
  public String ySW;
  public ImageView ySX;
  public boolean ySY;
  private int ySZ;
  private int yTa;
  private boolean yTb;
  private boolean yTc;
  private long yTd;
  private Animation yTe;
  private Animation yTf;
  private Runnable yTg;
  public int yTh;
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116172);
    this.ySO = 320;
    this.ySP = 240;
    this.ySQ = true;
    this.oHt = null;
    this.ySU = 0.0D;
    this.ySW = "";
    this.gIf = new ap();
    this.ySY = true;
    this.duration = 0;
    this.ySZ = 0;
    this.yTa = 0;
    this.yTb = false;
    this.yTc = false;
    this.yTd = 0L;
    this.yTe = new AlphaAnimation(1.0F, 0.0F);
    this.yTf = new AlphaAnimation(0.0F, 1.0F);
    this.yTg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116165);
        VideoPlayView.this.dQs();
        AppMethodBeat.o(116165);
      }
    };
    this.yTh = 0;
    this.fMP = false;
    init();
    AppMethodBeat.o(116172);
  }
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(116173);
    this.ySO = 320;
    this.ySP = 240;
    this.ySQ = true;
    this.oHt = null;
    this.ySU = 0.0D;
    this.ySW = "";
    this.gIf = new ap();
    this.ySY = true;
    this.duration = 0;
    this.ySZ = 0;
    this.yTa = 0;
    this.yTb = false;
    this.yTc = false;
    this.yTd = 0L;
    this.yTe = new AlphaAnimation(1.0F, 0.0F);
    this.yTf = new AlphaAnimation(0.0F, 1.0F);
    this.yTg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116165);
        VideoPlayView.this.dQs();
        AppMethodBeat.o(116165);
      }
    };
    this.yTh = 0;
    this.fMP = false;
    init();
    AppMethodBeat.o(116173);
  }
  
  private void Pv(int paramInt)
  {
    AppMethodBeat.i(116185);
    if (paramInt >= 0) {}
    for (double d = paramInt;; d = this.oHt.getLastProgresstime())
    {
      this.ySU = d;
      ad.i("MicroMsg.VideoPlayView", "pause play " + this.ySU + " lastTime: " + paramInt + " last " + this.oHt.getLastProgresstime());
      this.oHt.pause();
      this.gIf.post(new Runnable()
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
      if (this.ySR != null) {
        this.ySR.dQt();
      }
      AppMethodBeat.o(116185);
      return;
    }
  }
  
  private void dQr()
  {
    AppMethodBeat.i(116178);
    ((View)this.yST).setVisibility(0);
    this.gVy.setVisibility(0);
    if (this.ySY) {
      this.ySX.setVisibility(0);
    }
    int i;
    if (this.yTh == 2) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        this.gZU.setVisibility(0);
      }
      this.gIf.removeCallbacks(this.yTg);
      this.gIf.postDelayed(this.yTg, 3000L);
      AppMethodBeat.o(116178);
      return;
      if (bt.isNullOrNil(this.ySW)) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(116174);
    this.yTe.setDuration(200L);
    this.yTf.setDuration(200L);
    View.inflate(getContext(), 2131495832, this);
    this.gVy = findViewById(2131303282);
    this.ySX = ((ImageView)findViewById(2131302238));
    this.ySX.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.jqx = ((ProgressBar)findViewById(2131303535));
    this.ySS = ((ViewGroup)findViewById(2131306317));
    this.oHt = t.hE(getContext());
    this.oHt.setLoop(false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.ySS.addView((View)this.oHt, 0, localLayoutParams);
    this.ySV = ((TextView)findViewById(2131304777));
    this.gZU = this.ySV;
    this.oHt.setVideoCallback(new h.a()
    {
      public final int eT(final int paramAnonymousInt1, final int paramAnonymousInt2)
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
              VideoPlayView.f(VideoPlayView.this).Pw(paramAnonymousInt2);
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
              VideoPlayView.e(VideoPlayView.this, VideoPlayView.this.yTh);
              AppMethodBeat.o(116157);
            }
          });
        }
        AppMethodBeat.o(116162);
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(116160);
        ad.d("MicroMsg.VideoPlayView", "on completion " + bt.flS().toString());
        if (!VideoPlayView.b(VideoPlayView.this))
        {
          VideoPlayView.a(VideoPlayView.this, 0.0D);
          VideoPlayView.this.p(0.0D);
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
            VideoPlayView.f(VideoPlayView.this).dQu();
            AppMethodBeat.o(116160);
          }
        }
        else
        {
          VideoPlayView.c(VideoPlayView.this).setIsPlay(false);
          VideoPlayView.a(VideoPlayView.this, (int)VideoPlayView.g(VideoPlayView.this));
          VideoPlayView.d(VideoPlayView.this);
          if (VideoPlayView.f(VideoPlayView.this) != null) {
            VideoPlayView.f(VideoPlayView.this).dQv();
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
      
      public final void ta()
      {
        AppMethodBeat.i(116158);
        ad.d("MicroMsg.VideoPlayView", f.abh() + " onPrepared");
        VideoPlayView.a(VideoPlayView.this, true);
        AppMethodBeat.o(116158);
      }
    });
    if ((this.oHt instanceof VideoSightView)) {
      ((VideoSightView)this.oHt).setEnableConfigChanged(false);
    }
    setOnTouchListener(new VideoPlayView.2(this));
    dQs();
    ((View)this.oHt).post(new Runnable()
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
  
  private void rc(boolean paramBoolean)
  {
    AppMethodBeat.i(116184);
    this.oHt.p(this.ySU);
    this.oHt.start();
    ad.i("MicroMsg.VideoPlayView", "startplay get duration " + this.duration + " lastPlayProgressTime: " + this.ySU);
    if (this.ySR != null) {
      this.ySR.rd(paramBoolean);
    }
    AppMethodBeat.o(116184);
  }
  
  public final boolean B(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(116187);
    paramBoolean = this.oHt.B(paramContext, paramBoolean);
    AppMethodBeat.o(116187);
    return paramBoolean;
  }
  
  public final void aAa() {}
  
  public final void aAb() {}
  
  public final void azY() {}
  
  public final void azZ() {}
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(116199);
    p(paramDouble);
    AppMethodBeat.o(116199);
  }
  
  public final void dQq()
  {
    AppMethodBeat.i(116177);
    this.jqx.setVisibility(0);
    AppMethodBeat.o(116177);
  }
  
  public final void dQs()
  {
    AppMethodBeat.i(116179);
    if (this.yST != null) {
      ((View)this.yST).setVisibility(4);
    }
    this.gVy.setVisibility(8);
    this.ySX.setVisibility(8);
    this.gZU.setVisibility(8);
    AppMethodBeat.o(116179);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(116193);
    int i = this.oHt.getCurrentPosition();
    AppMethodBeat.o(116193);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116194);
    if (this.duration == 0)
    {
      i = this.oHt.getDuration();
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
    double d = Math.max(this.ySU, this.oHt.getLastProgresstime());
    AppMethodBeat.o(116191);
    return d;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return 0L;
  }
  
  public String getVideoPath()
  {
    return this.hdP;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(116186);
    boolean bool = this.oHt.isPlaying();
    AppMethodBeat.o(116186);
    return bool;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(116189);
    this.oHt.onDetach();
    AppMethodBeat.o(116189);
  }
  
  public final void p(double paramDouble)
  {
    AppMethodBeat.i(116196);
    this.oHt.p(paramDouble);
    this.yST.seek((int)paramDouble);
    AppMethodBeat.o(116196);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(116183);
    Pv(-1);
    AppMethodBeat.o(116183);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setIsDownloading(boolean paramBoolean)
  {
    AppMethodBeat.i(116176);
    this.yTb = paramBoolean;
    Object localObject;
    if ((this.oHt != null) && ((this.oHt instanceof VideoSightView)))
    {
      localObject = (VideoSightView)this.oHt;
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
      ((com.tencent.mm.plugin.sight.decode.a.b)localObject).yRK = paramBoolean;
      AppMethodBeat.o(116176);
      return;
    }
  }
  
  public void setLeftButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116180);
    this.gVy.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116180);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(116190);
    this.oHt.setLoop(paramBoolean);
    AppMethodBeat.o(116190);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.fMP = paramBoolean;
  }
  
  public void setOnInfoCallback(h.b paramb) {}
  
  public void setOnSeekCompleteCallback(h.c paramc) {}
  
  public void setOnSurfaceCallback(h.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(h.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(116197);
    this.oHt.setPlayProgressCallback(paramBoolean);
    AppMethodBeat.o(116197);
  }
  
  public void setRightButtonOnCliclListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116181);
    this.ySX.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116181);
  }
  
  public void setThumb(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116195);
    this.oHt.setThumb(paramBitmap);
    AppMethodBeat.o(116195);
  }
  
  public void setVideoCallback(h.a parama)
  {
    AppMethodBeat.i(116192);
    this.oHt.setVideoCallback(parama);
    AppMethodBeat.o(116192);
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(116171);
    this.hdP = paramString;
    ad.i("MicroMsg.VideoPlayView", "videoPath  %s", new Object[] { this.hdP });
    this.oHt.setVideoPath(this.hdP);
    AppMethodBeat.o(116171);
  }
  
  public void setVideoPlayViewEvent(a parama)
  {
    this.ySR = parama;
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(116175);
    if (this.yST.getVideoTotalTime() != paramInt) {
      this.yST.setVideoTotalTime(paramInt);
    }
    AppMethodBeat.o(116175);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(116182);
    rc(true);
    AppMethodBeat.o(116182);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(116188);
    this.oHt.stop();
    AppMethodBeat.o(116188);
  }
  
  public final void update(int paramInt)
  {
    AppMethodBeat.i(116198);
    this.yTc = true;
    Object localObject;
    if ((this.yTa == 0) || (this.ySZ == 0))
    {
      localObject = getResources().getDisplayMetrics();
      this.yTa = ((DisplayMetrics)localObject).heightPixels;
      this.ySZ = ((DisplayMetrics)localObject).widthPixels;
      if (this.yTa < this.ySZ)
      {
        this.yTa = ((DisplayMetrics)localObject).widthPixels;
        this.ySZ = ((DisplayMetrics)localObject).heightPixels;
      }
      ad.i("MicroMsg.VideoPlayView", "getScreen screen_height:" + this.yTa + " screen_width:" + this.ySZ);
    }
    ViewGroup.LayoutParams localLayoutParams = this.ySS.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1;
    if (this.yST == null)
    {
      localObject = null;
      localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
      if (paramInt != 1) {
        break label410;
      }
      localLayoutParams1.width = this.ySZ;
      localLayoutParams1.height = ((int)(this.ySZ * 1.0D * this.ySP / this.ySO));
      if (this.yST != null) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.b.g(getContext(), 0.0F);
      }
    }
    for (;;)
    {
      if (this.yST != null)
      {
        this.yST.dQn();
        ((View)this.yST).setLayoutParams((ViewGroup.LayoutParams)localObject);
        if ((this.yST instanceof AdVideoPlayerLoadingBar)) {
          this.gIf.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116170);
              if (!VideoPlayView.a(VideoPlayView.this).isPlaying()) {
                ((AdVideoPlayerLoadingBar)VideoPlayView.c(VideoPlayView.this)).boy();
              }
              AppMethodBeat.o(116170);
            }
          }, 500L);
        }
      }
      ad.i("MicroMsg.VideoPlayView", "orientation " + paramInt + " " + localLayoutParams1.width + " " + localLayoutParams1.height);
      ((View)this.oHt).setLayoutParams(localLayoutParams1);
      if ((this.oHt instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
        ((com.tencent.mm.plugin.sight.decode.a.a)this.oHt).hw(localLayoutParams1.width, localLayoutParams1.height);
      }
      localLayoutParams.height = localLayoutParams1.height;
      localLayoutParams.width = localLayoutParams1.width;
      this.ySS.setLayoutParams(localLayoutParams);
      ((View)this.oHt).requestLayout();
      AppMethodBeat.o(116198);
      return;
      localObject = (RelativeLayout.LayoutParams)((View)this.yST).getLayoutParams();
      break;
      label410:
      localLayoutParams1.height = this.ySZ;
      localLayoutParams1.width = ((int)(this.ySZ * 1.0D * this.ySO / this.ySP));
      if (this.yST != null) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.b.g(getContext(), 0.0F);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Pw(int paramInt);
    
    public abstract void dQt();
    
    public abstract void dQu();
    
    public abstract void dQv();
    
    public abstract void rd(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView
 * JD-Core Version:    0.7.0.1
 */