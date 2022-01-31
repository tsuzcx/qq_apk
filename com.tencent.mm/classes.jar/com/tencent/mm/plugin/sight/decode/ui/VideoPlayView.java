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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.e.b;
import com.tencent.mm.pluginsdk.ui.tools.e.c;
import com.tencent.mm.pluginsdk.ui.tools.e.d;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public class VideoPlayView
  extends RelativeLayout
  implements d.a, e
{
  private int duration;
  private String eNO;
  private boolean efg;
  private ak faV;
  private ProgressBar gJE;
  public View jbK;
  public e kvG;
  public boolean qUA;
  private int qUB;
  private int qUC;
  private boolean qUD;
  private boolean qUE;
  private long qUF;
  private Animation qUG;
  private Animation qUH;
  private Runnable qUI;
  public int qUJ;
  private int qUp;
  private int qUq;
  private boolean qUr;
  private VideoPlayView.a qUs;
  private ViewGroup qUt;
  public a qUu;
  private double qUv;
  public TextView qUw;
  public String qUx;
  private View qUy;
  public ImageView qUz;
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(70325);
    this.qUp = 320;
    this.qUq = 240;
    this.qUr = true;
    this.kvG = null;
    this.qUv = 0.0D;
    this.qUx = "";
    this.faV = new ak();
    this.qUA = true;
    this.duration = 0;
    this.qUB = 0;
    this.qUC = 0;
    this.qUD = false;
    this.qUE = false;
    this.qUF = 0L;
    this.qUG = new AlphaAnimation(1.0F, 0.0F);
    this.qUH = new AlphaAnimation(0.0F, 1.0F);
    this.qUI = new VideoPlayView.4(this);
    this.qUJ = 0;
    this.efg = false;
    init();
    AppMethodBeat.o(70325);
  }
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(70326);
    this.qUp = 320;
    this.qUq = 240;
    this.qUr = true;
    this.kvG = null;
    this.qUv = 0.0D;
    this.qUx = "";
    this.faV = new ak();
    this.qUA = true;
    this.duration = 0;
    this.qUB = 0;
    this.qUC = 0;
    this.qUD = false;
    this.qUE = false;
    this.qUF = 0L;
    this.qUG = new AlphaAnimation(1.0F, 0.0F);
    this.qUH = new AlphaAnimation(0.0F, 1.0F);
    this.qUI = new VideoPlayView.4(this);
    this.qUJ = 0;
    this.efg = false;
    init();
    AppMethodBeat.o(70326);
  }
  
  private void Du(int paramInt)
  {
    AppMethodBeat.i(70338);
    if (paramInt >= 0) {}
    for (double d = paramInt;; d = this.kvG.getLastProgresstime())
    {
      this.qUv = d;
      ab.i("MicroMsg.VideoPlayView", "pause play " + this.qUv + " lastTime: " + paramInt + " last " + this.kvG.getLastProgresstime());
      this.kvG.pause();
      this.faV.post(new VideoPlayView.7(this));
      if (this.qUs != null) {
        this.qUs.cmR();
      }
      AppMethodBeat.o(70338);
      return;
    }
  }
  
  private void cmP()
  {
    AppMethodBeat.i(70331);
    ((View)this.qUu).setVisibility(0);
    this.qUy.setVisibility(0);
    if (this.qUA) {
      this.qUz.setVisibility(0);
    }
    int i;
    if (this.qUJ == 2) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        this.jbK.setVisibility(0);
      }
      this.faV.removeCallbacks(this.qUI);
      this.faV.postDelayed(this.qUI, 3000L);
      AppMethodBeat.o(70331);
      return;
      if (bo.isNullOrNil(this.qUx)) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(70327);
    this.qUG.setDuration(200L);
    this.qUH.setDuration(200L);
    View.inflate(getContext(), 2130971066, this);
    this.qUy = findViewById(2131828720);
    this.qUz = ((ImageView)findViewById(2131828721));
    this.qUz.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.gJE = ((ProgressBar)findViewById(2131821246));
    this.qUt = ((ViewGroup)findViewById(2131824108));
    this.kvG = q.ga(getContext());
    this.kvG.setLoop(false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.qUt.addView((View)this.kvG, 0, localLayoutParams);
    this.qUw = ((TextView)findViewById(2131827797));
    this.jbK = this.qUw;
    this.kvG.setVideoCallback(new VideoPlayView.1(this));
    if ((this.kvG instanceof VideoSightView)) {
      ((VideoSightView)this.kvG).setEnableConfigChanged(false);
    }
    setOnTouchListener(new VideoPlayView.2(this));
    cmQ();
    ((View)this.kvG).post(new VideoPlayView.3(this));
    AppMethodBeat.o(70327);
  }
  
  private void kT(boolean paramBoolean)
  {
    AppMethodBeat.i(70337);
    this.kvG.A(this.qUv);
    this.kvG.start();
    ab.i("MicroMsg.VideoPlayView", "startplay get duration " + this.duration + " lastPlayProgressTime: " + this.qUv);
    if (this.qUs != null) {
      this.qUs.kU(paramBoolean);
    }
    AppMethodBeat.o(70337);
  }
  
  public final void A(double paramDouble)
  {
    AppMethodBeat.i(70349);
    this.kvG.A(paramDouble);
    this.qUu.seek((int)paramDouble);
    AppMethodBeat.o(70349);
  }
  
  public final void cmO()
  {
    AppMethodBeat.i(70330);
    this.gJE.setVisibility(0);
    AppMethodBeat.o(70330);
  }
  
  public final void cmQ()
  {
    AppMethodBeat.i(70332);
    if (this.qUu != null) {
      ((View)this.qUu).setVisibility(4);
    }
    this.qUy.setVisibility(8);
    this.qUz.setVisibility(8);
    this.jbK.setVisibility(8);
    AppMethodBeat.o(70332);
  }
  
  public final void e(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(70352);
    A(paramDouble);
    AppMethodBeat.o(70352);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(70346);
    int i = this.kvG.getCurrentPosition();
    AppMethodBeat.o(70346);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(70347);
    if (this.duration == 0)
    {
      i = this.kvG.getDuration();
      AppMethodBeat.o(70347);
      return i;
    }
    int i = this.duration;
    AppMethodBeat.o(70347);
    return i;
  }
  
  public double getLastProgresstime()
  {
    AppMethodBeat.i(70344);
    double d = Math.max(this.qUv, this.kvG.getLastProgresstime());
    AppMethodBeat.o(70344);
    return d;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return 0L;
  }
  
  public String getVideoPath()
  {
    return this.eNO;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(70339);
    boolean bool = this.kvG.isPlaying();
    AppMethodBeat.o(70339);
    return bool;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(70342);
    this.kvG.onDetach();
    AppMethodBeat.o(70342);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(70336);
    Du(-1);
    AppMethodBeat.o(70336);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setIsDownloading(boolean paramBoolean)
  {
    AppMethodBeat.i(70329);
    this.qUD = paramBoolean;
    Object localObject;
    if ((this.kvG != null) && ((this.kvG instanceof VideoSightView)))
    {
      localObject = (VideoSightView)this.kvG;
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
      ((b)localObject).qSY = paramBoolean;
      AppMethodBeat.o(70329);
      return;
    }
  }
  
  public void setLeftButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70333);
    this.qUy.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(70333);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(70343);
    this.kvG.setLoop(paramBoolean);
    AppMethodBeat.o(70343);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.efg = paramBoolean;
  }
  
  public void setOnInfoCallback(e.b paramb) {}
  
  public void setOnSeekCompleteCallback(e.c paramc) {}
  
  public void setOnSurfaceCallback(e.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(e.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(70350);
    this.kvG.setPlayProgressCallback(paramBoolean);
    AppMethodBeat.o(70350);
  }
  
  public void setRightButtonOnCliclListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70334);
    this.qUz.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(70334);
  }
  
  public void setThumb(Bitmap paramBitmap)
  {
    AppMethodBeat.i(70348);
    this.kvG.setThumb(paramBitmap);
    AppMethodBeat.o(70348);
  }
  
  public void setVideoCallback(e.a parama)
  {
    AppMethodBeat.i(70345);
    this.kvG.setVideoCallback(parama);
    AppMethodBeat.o(70345);
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(70324);
    this.eNO = paramString;
    ab.i("MicroMsg.VideoPlayView", "videoPath  %s", new Object[] { this.eNO });
    this.kvG.setVideoPath(this.eNO);
    AppMethodBeat.o(70324);
  }
  
  public void setVideoPlayViewEvent(VideoPlayView.a parama)
  {
    this.qUs = parama;
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(70328);
    if (this.qUu.getVideoTotalTime() != paramInt) {
      this.qUu.setVideoTotalTime(paramInt);
    }
    AppMethodBeat.o(70328);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(70335);
    kT(true);
    AppMethodBeat.o(70335);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(70341);
    this.kvG.stop();
    AppMethodBeat.o(70341);
  }
  
  public final void update(int paramInt)
  {
    AppMethodBeat.i(70351);
    this.qUE = true;
    Object localObject;
    if ((this.qUC == 0) || (this.qUB == 0))
    {
      localObject = getResources().getDisplayMetrics();
      this.qUC = ((DisplayMetrics)localObject).heightPixels;
      this.qUB = ((DisplayMetrics)localObject).widthPixels;
      if (this.qUC < this.qUB)
      {
        this.qUC = ((DisplayMetrics)localObject).widthPixels;
        this.qUB = ((DisplayMetrics)localObject).heightPixels;
      }
      ab.i("MicroMsg.VideoPlayView", "getScreen screen_height:" + this.qUC + " screen_width:" + this.qUB);
    }
    ViewGroup.LayoutParams localLayoutParams = this.qUt.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1;
    if (this.qUu == null)
    {
      localObject = null;
      localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
      if (paramInt != 1) {
        break label410;
      }
      localLayoutParams1.width = this.qUB;
      localLayoutParams1.height = ((int)(this.qUB * 1.0D * this.qUq / this.qUp));
      if (this.qUu != null) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.b.b(getContext(), 0.0F);
      }
    }
    for (;;)
    {
      if (this.qUu != null)
      {
        this.qUu.cmM();
        ((View)this.qUu).setLayoutParams((ViewGroup.LayoutParams)localObject);
        if ((this.qUu instanceof AdVideoPlayerLoadingBar)) {
          this.faV.postDelayed(new VideoPlayView.8(this), 500L);
        }
      }
      ab.i("MicroMsg.VideoPlayView", "orientation " + paramInt + " " + localLayoutParams1.width + " " + localLayoutParams1.height);
      ((View)this.kvG).setLayoutParams(localLayoutParams1);
      if ((this.kvG instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
        ((com.tencent.mm.plugin.sight.decode.a.a)this.kvG).ft(localLayoutParams1.width, localLayoutParams1.height);
      }
      localLayoutParams.height = localLayoutParams1.height;
      localLayoutParams.width = localLayoutParams1.width;
      this.qUt.setLayoutParams(localLayoutParams);
      ((View)this.kvG).requestLayout();
      AppMethodBeat.o(70351);
      return;
      localObject = (RelativeLayout.LayoutParams)((View)this.qUu).getLayoutParams();
      break;
      label410:
      localLayoutParams1.height = this.qUB;
      localLayoutParams1.width = ((int)(this.qUB * 1.0D * this.qUp / this.qUq));
      if (this.qUu != null) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.b.b(getContext(), 0.0F);
      }
    }
  }
  
  public final boolean w(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(70340);
    paramBoolean = this.kvG.w(paramContext, paramBoolean);
    AppMethodBeat.o(70340);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView
 * JD-Core Version:    0.7.0.1
 */