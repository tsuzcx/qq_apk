package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.ai.a.e;
import com.tencent.mm.plugin.ai.a.f;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.b;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class VideoPlayView
  extends RelativeLayout
  implements d.a, f
{
  private ah dPi = new ah();
  private boolean dnJ = false;
  private int duration = 0;
  private String erh;
  private ProgressBar fsc;
  public View hoY;
  public f iuC = null;
  private int oga = 320;
  private int ogb = 240;
  private boolean ogc = true;
  private VideoPlayView.a ogd;
  private ViewGroup oge;
  public a ogf;
  private double ogg = 0.0D;
  public TextView ogh;
  public String ogi = "";
  private View ogj;
  public ImageView ogk;
  public boolean ogl = true;
  private int ogm = 0;
  private int ogn = 0;
  private boolean ogo = false;
  private boolean ogp = false;
  private long ogq = 0L;
  private Animation ogr = new AlphaAnimation(1.0F, 0.0F);
  private Animation ogs = new AlphaAnimation(0.0F, 1.0F);
  private Runnable ogt = new VideoPlayView.4(this);
  public int ogu = 0;
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void bBp()
  {
    ((View)this.ogf).setVisibility(0);
    this.ogj.setVisibility(0);
    if (this.ogl) {
      this.ogk.setVisibility(0);
    }
    int i;
    if (this.ogu == 2) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        this.hoY.setVisibility(0);
      }
      this.dPi.removeCallbacks(this.ogt);
      this.dPi.postDelayed(this.ogt, 3000L);
      return;
      if (bk.bl(this.ogi)) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  private void iP(boolean paramBoolean)
  {
    this.iuC.x(this.ogg);
    this.iuC.start();
    y.i("MicroMsg.VideoPlayView", "startplay get duration " + this.duration + " lastPlayProgressTime: " + this.ogg);
    if (this.ogd != null) {
      this.ogd.iQ(paramBoolean);
    }
  }
  
  private void init()
  {
    this.ogr.setDuration(200L);
    this.ogs.setDuration(200L);
    View.inflate(getContext(), a.f.video_play_view, this);
    this.ogj = findViewById(a.e.play_close_btn);
    this.ogk = ((ImageView)findViewById(a.e.menu_btn));
    this.ogk.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.fsc = ((ProgressBar)findViewById(a.e.progressbar));
    this.oge = ((ViewGroup)findViewById(a.e.video_container));
    this.iuC = o.fb(getContext());
    this.iuC.setLoop(false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.oge.addView((View)this.iuC, 0, localLayoutParams);
    this.ogh = ((TextView)findViewById(a.e.show_ad_sight));
    this.hoY = this.ogh;
    this.iuC.setVideoCallback(new f.a()
    {
      public final int cv(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        ai.d(new VideoPlayView.1.1(this, paramAnonymousInt1, paramAnonymousInt2));
        return 0;
      }
      
      public final void cw(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        VideoPlayView.c(VideoPlayView.this, paramAnonymousInt1);
        VideoPlayView.d(VideoPlayView.this, paramAnonymousInt2);
        if (VideoPlayView.k(VideoPlayView.this)) {
          VideoPlayView.l(VideoPlayView.this).post(new VideoPlayView.1.2(this));
        }
      }
      
      public final void kA()
      {
        y.d("MicroMsg.VideoPlayView", g.zH() + " onPrepared");
        VideoPlayView.a(VideoPlayView.this, true);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        y.e("MicroMsg.VideoPlayView", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        VideoPlayView.a(VideoPlayView.this).stop();
      }
      
      public final void ug()
      {
        y.d("MicroMsg.VideoPlayView", "on completion " + bk.csb().toString());
        if (!VideoPlayView.b(VideoPlayView.this))
        {
          VideoPlayView.a(VideoPlayView.this, 0.0D);
          VideoPlayView.this.x(0.0D);
          VideoPlayView.c(VideoPlayView.this).setIsPlay(false);
          VideoPlayView.a(VideoPlayView.this, 0);
          VideoPlayView.d(VideoPlayView.this);
          if (System.currentTimeMillis() - VideoPlayView.e(VideoPlayView.this) < 2000L) {
            y.i("MicroMsg.VideoPlayView", "Too short onCompletion");
          }
        }
        do
        {
          do
          {
            return;
            VideoPlayView.a(VideoPlayView.this, System.currentTimeMillis());
          } while (VideoPlayView.f(VideoPlayView.this) == null);
          VideoPlayView.f(VideoPlayView.this).bBs();
          return;
          VideoPlayView.c(VideoPlayView.this).setIsPlay(false);
          VideoPlayView.a(VideoPlayView.this, (int)VideoPlayView.g(VideoPlayView.this));
          VideoPlayView.d(VideoPlayView.this);
        } while (VideoPlayView.f(VideoPlayView.this) == null);
        VideoPlayView.f(VideoPlayView.this).bBt();
      }
    });
    if ((this.iuC instanceof VideoSightView)) {
      ((VideoSightView)this.iuC).setEnableConfigChanged(false);
    }
    setOnTouchListener(new VideoPlayView.2(this));
    bBq();
    ((View)this.iuC).post(new VideoPlayView.3(this));
  }
  
  private void xu(int paramInt)
  {
    if (paramInt >= 0) {}
    for (double d = paramInt;; d = this.iuC.getLastProgresstime())
    {
      this.ogg = d;
      y.i("MicroMsg.VideoPlayView", "pause play " + this.ogg + " lastTime: " + paramInt + " last " + this.iuC.getLastProgresstime());
      this.iuC.pause();
      this.dPi.post(new VideoPlayView.7(this));
      if (this.ogd != null) {
        this.ogd.bBr();
      }
      return;
    }
  }
  
  public final void bBo()
  {
    this.fsc.setVisibility(0);
  }
  
  public final void bBq()
  {
    if (this.ogf != null) {
      ((View)this.ogf).setVisibility(4);
    }
    this.ogj.setVisibility(8);
    this.ogk.setVisibility(8);
    this.hoY.setVisibility(8);
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    x(paramDouble);
  }
  
  public int getCurrentPosition()
  {
    return this.iuC.getCurrentPosition();
  }
  
  public int getDuration()
  {
    if (this.duration == 0) {
      return this.iuC.getDuration();
    }
    return this.duration;
  }
  
  public double getLastProgresstime()
  {
    return Math.max(this.ogg, this.iuC.getLastProgresstime());
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return 0L;
  }
  
  public String getVideoPath()
  {
    return this.erh;
  }
  
  public final boolean isPlaying()
  {
    return this.iuC.isPlaying();
  }
  
  public final void onDetach()
  {
    this.iuC.onDetach();
  }
  
  public final void pause()
  {
    xu(-1);
  }
  
  public final boolean s(Context paramContext, boolean paramBoolean)
  {
    return this.iuC.s(paramContext, paramBoolean);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setIsDownloading(boolean paramBoolean)
  {
    this.ogo = paramBoolean;
    Object localObject;
    if ((this.iuC != null) && ((this.iuC instanceof VideoSightView)))
    {
      localObject = (VideoSightView)this.iuC;
      if (((VideoSightView)localObject).getController() != null)
      {
        localObject = ((VideoSightView)localObject).getController();
        if (paramBoolean) {
          break label54;
        }
      }
    }
    label54:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((b)localObject).oeJ = paramBoolean;
      return;
    }
  }
  
  public void setLeftButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.ogj.setOnClickListener(paramOnClickListener);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.iuC.setLoop(paramBoolean);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.dnJ = paramBoolean;
  }
  
  public void setOnInfoCallback(f.b paramb) {}
  
  public void setOnSeekCompleteCallback(f.c paramc) {}
  
  public void setOnSurfaceCallback(f.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(f.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    this.iuC.setPlayProgressCallback(paramBoolean);
  }
  
  public void setRightButtonOnCliclListener(View.OnClickListener paramOnClickListener)
  {
    this.ogk.setOnClickListener(paramOnClickListener);
  }
  
  public void setThumb(Bitmap paramBitmap)
  {
    this.iuC.setThumb(paramBitmap);
  }
  
  public void setVideoCallback(f.a parama)
  {
    this.iuC.setVideoCallback(parama);
  }
  
  public void setVideoPath(String paramString)
  {
    this.erh = paramString;
    y.i("MicroMsg.VideoPlayView", "videoPath  %s", new Object[] { this.erh });
    this.iuC.setVideoPath(this.erh);
  }
  
  public void setVideoPlayViewEvent(VideoPlayView.a parama)
  {
    this.ogd = parama;
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    if (this.ogf.getVideoTotalTime() != paramInt) {
      this.ogf.setVideoTotalTime(paramInt);
    }
  }
  
  public final boolean start()
  {
    iP(true);
    return true;
  }
  
  public final void stop()
  {
    this.iuC.stop();
  }
  
  public final void update(int paramInt)
  {
    this.ogp = true;
    Object localObject;
    if ((this.ogn == 0) || (this.ogm == 0))
    {
      localObject = getResources().getDisplayMetrics();
      this.ogn = ((DisplayMetrics)localObject).heightPixels;
      this.ogm = ((DisplayMetrics)localObject).widthPixels;
      if (this.ogn < this.ogm)
      {
        this.ogn = ((DisplayMetrics)localObject).widthPixels;
        this.ogm = ((DisplayMetrics)localObject).heightPixels;
      }
      y.i("MicroMsg.VideoPlayView", "getScreen screen_height:" + this.ogn + " screen_width:" + this.ogm);
    }
    ViewGroup.LayoutParams localLayoutParams = this.oge.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1;
    if (this.ogf == null)
    {
      localObject = null;
      localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
      if (paramInt != 1) {
        break label398;
      }
      localLayoutParams1.width = this.ogm;
      localLayoutParams1.height = ((int)(this.ogm * 1.0D * this.ogb / this.oga));
      if (this.ogf != null) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.b.b(getContext(), 0.0F);
      }
    }
    for (;;)
    {
      if (this.ogf != null)
      {
        this.ogf.bBm();
        ((View)this.ogf).setLayoutParams((ViewGroup.LayoutParams)localObject);
        if ((this.ogf instanceof AdVideoPlayerLoadingBar)) {
          this.dPi.postDelayed(new VideoPlayView.8(this), 500L);
        }
      }
      y.i("MicroMsg.VideoPlayView", "orientation " + paramInt + " " + localLayoutParams1.width + " " + localLayoutParams1.height);
      ((View)this.iuC).setLayoutParams(localLayoutParams1);
      if ((this.iuC instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
        ((com.tencent.mm.plugin.sight.decode.a.a)this.iuC).dL(localLayoutParams1.width, localLayoutParams1.height);
      }
      localLayoutParams.height = localLayoutParams1.height;
      localLayoutParams.width = localLayoutParams1.width;
      this.oge.setLayoutParams(localLayoutParams);
      ((View)this.iuC).requestLayout();
      return;
      localObject = (RelativeLayout.LayoutParams)((View)this.ogf).getLayoutParams();
      break;
      label398:
      localLayoutParams1.height = this.ogm;
      localLayoutParams1.width = ((int)(this.ogm * 1.0D * this.oga / this.ogb));
      if (this.ogf != null) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.b.b(getContext(), 0.0F);
      }
    }
  }
  
  public final void x(double paramDouble)
  {
    this.iuC.x(paramDouble);
    this.ogf.seek((int)paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView
 * JD-Core Version:    0.7.0.1
 */