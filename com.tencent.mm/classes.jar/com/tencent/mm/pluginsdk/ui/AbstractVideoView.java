package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.b;
import com.tencent.mm.pluginsdk.ui.tools.h.c;
import com.tencent.mm.pluginsdk.ui.tools.h.d;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;

public abstract class AbstractVideoView
  extends RelativeLayout
  implements i, h.a, h.b, h.c, h.d, h.e
{
  public VideoPlayerSeekBar Fkb;
  protected h Fkc;
  protected i.d Fkd;
  private Runnable Fke = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(133989);
      if (!AbstractVideoView.d(AbstractVideoView.this))
      {
        AppMethodBeat.o(133989);
        return;
      }
      AbstractVideoView.b(AbstractVideoView.this, false);
      if (AbstractVideoView.this.ozA != null) {
        AbstractVideoView.this.ozA.dx(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      if ((AbstractVideoView.this.lxB != null) && (AbstractVideoView.this.lxB.getVisibility() != 8))
      {
        ae.i(AbstractVideoView.this.TAG, "%s hide loading", new Object[] { AbstractVideoView.this.bpA() });
        AbstractVideoView.this.lxB.setVisibility(8);
      }
      AppMethodBeat.o(133989);
    }
  };
  private i.c Fkf = null;
  protected k Fkg = new k();
  public String TAG = "MicroMsg.AbstractVideoView";
  protected boolean Zn = false;
  protected int bFv = 0;
  protected aq gKO = new aq(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(220265);
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(220265);
        return;
        AbstractVideoView.a(AbstractVideoView.this).run();
        AppMethodBeat.o(220265);
        return;
        AbstractVideoView.b(AbstractVideoView.this).run();
      }
    }
  };
  protected TextView gWL;
  private boolean isWaiting = false;
  protected RelativeLayout lxA;
  protected ProgressBar lxB;
  protected TextView lxC;
  protected LinearLayout lxD;
  protected boolean lxH;
  protected boolean lxI = true;
  protected int lxJ = 0;
  protected boolean lxK = false;
  protected int lxL = 0;
  protected boolean lxM = true;
  protected int lxN = -1;
  protected boolean lxO = false;
  protected long lxP = 0L;
  protected int lxQ = 0;
  protected aw lxR = new aw(new aw.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(133983);
      if (!AbstractVideoView.this.isPlaying())
      {
        AppMethodBeat.o(133983);
        return false;
      }
      if (AbstractVideoView.this.lxK)
      {
        if (AbstractVideoView.this.ozA != null) {
          AbstractVideoView.this.ozA.dv(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        AbstractVideoView.this.lxK = false;
      }
      AbstractVideoView.this.tK(AbstractVideoView.this.getCurrPosSec());
      AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
      if (AbstractVideoView.this.daW())
      {
        boolean bool = AbstractVideoView.this.fff();
        AppMethodBeat.o(133983);
        return bool;
      }
      AppMethodBeat.o(133983);
      return true;
    }
  }, true);
  protected aw lxS = new aw(new aw.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(133984);
      boolean bool = AbstractVideoView.this.isPlaying();
      int i = AbstractVideoView.this.getCurrPosMs();
      ae.i(AbstractVideoView.this.TAG, "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[] { AbstractVideoView.this.bpA(), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((AbstractVideoView.this.oNV != null) && (i <= 50)) {
        AbstractVideoView.this.oNV.p(0.0D);
      }
      AppMethodBeat.o(133984);
      return false;
    }
  }, false);
  protected aw lxT = new aw(new aw.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(220267);
      if (AbstractVideoView.this.bFv > 0)
      {
        if (AbstractVideoView.this.isPlaying())
        {
          AbstractVideoView.c(AbstractVideoView.this);
          AppMethodBeat.o(220267);
          return false;
        }
        AppMethodBeat.o(220267);
        return true;
      }
      AppMethodBeat.o(220267);
      return false;
    }
  }, true);
  private View.OnClickListener lxV = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(220269);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramAnonymousView);
      a.b("com/tencent/mm/pluginsdk/ui/AbstractVideoView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      ae.i(AbstractVideoView.this.TAG, "%s seek bar play button on click ", new Object[] { AbstractVideoView.this.bpA() });
      paramAnonymousView = AbstractVideoView.this;
      if (paramAnonymousView.oNV != null)
      {
        if (!paramAnonymousView.isPlaying()) {
          break label102;
        }
        paramAnonymousView.pause();
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/pluginsdk/ui/AbstractVideoView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(220269);
        return;
        label102:
        if (bu.isNullOrNil(paramAnonymousView.oNV.getVideoPath())) {
          paramAnonymousView.start();
        } else {
          paramAnonymousView.play();
        }
      }
    }
  };
  private Runnable lxW = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(133988);
      AbstractVideoView.b(AbstractVideoView.this, true);
      if ((AbstractVideoView.this.lxB != null) && (AbstractVideoView.this.lxB.getVisibility() != 0))
      {
        ae.i(AbstractVideoView.this.TAG, "%s show loading", new Object[] { AbstractVideoView.this.bpA() });
        AbstractVideoView.this.lxB.setVisibility(0);
      }
      if (AbstractVideoView.this.ozA != null) {
        AbstractVideoView.this.ozA.dw(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      AppMethodBeat.o(133988);
    }
  };
  protected boolean lxy = true;
  protected ImageView lxz;
  protected Context mContext;
  public com.tencent.mm.pluginsdk.ui.tools.h oNV;
  public i.b ozA;
  private com.tencent.mm.plugin.sight.decode.ui.b rNx = eiF();
  
  public AbstractVideoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AbstractVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AbstractVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    initView();
  }
  
  private void gS(boolean paramBoolean)
  {
    if (this.Fkc != null) {
      this.Fkc.gS(paramBoolean);
    }
  }
  
  public void aMV()
  {
    ae.i(this.TAG, "%s on surface available", new Object[] { bpA() });
    eY(false);
  }
  
  protected final void aNN(String paramString)
  {
    this.Fkg.url = paramString;
  }
  
  public String bpA()
  {
    return hashCode();
  }
  
  protected final boolean bpC()
  {
    boolean bool;
    if (this.oNV != null) {
      if ((!bu.isNullOrNil(this.oNV.getVideoPath())) && (this.Zn)) {
        bool = true;
      }
    }
    for (;;)
    {
      ae.d(this.TAG, "%s is prepared [%b] isPrepared[%b]", new Object[] { bpA(), Boolean.valueOf(bool), Boolean.valueOf(this.Zn) });
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public void bpD()
  {
    ae.i(this.TAG, "%s onTextureUpdate ", new Object[] { bpA() });
    hideLoading();
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = bpC();
    int j = getVideoDurationSec();
    int k = (int)paramDouble;
    int i = k;
    if (j > 0)
    {
      i = k;
      if (paramDouble > j) {
        i = j;
      }
    }
    boolean bool1;
    if (this.oNV != null) {
      if (!bu.isNullOrNil(this.oNV.getVideoPath())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      ae.m(this.TAG, "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[] { bpA(), Integer.valueOf(i), Double.valueOf(paramDouble), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Integer.valueOf(j), Boolean.valueOf(bool1) });
      rd(getReportIdkey() + 5);
      if (!bool2) {
        break;
      }
      if (this.oNV == null) {
        break label215;
      }
      showLoading();
      tx(i);
      this.oNV.d(i * 1000, paramBoolean);
      return paramBoolean;
      bool1 = false;
      continue;
      bool1 = false;
    }
    this.lxN = i;
    if (bool1) {
      this.lxM = true;
    }
    for (;;)
    {
      label215:
      return false;
      this.lxM = paramBoolean;
      start();
    }
  }
  
  protected com.tencent.mm.pluginsdk.ui.tools.h cN(Context paramContext)
  {
    return null;
  }
  
  protected int cOC()
  {
    return 2131493573;
  }
  
  public final void cOS()
  {
    if (this.Fkc != null) {
      this.lxD.removeView((View)this.Fkc);
    }
  }
  
  public boolean daW()
  {
    return false;
  }
  
  protected boolean dlY()
  {
    return true;
  }
  
  public final int eU(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public void eX(boolean paramBoolean)
  {
    ae.i(this.TAG, "%s on seek complete startPlay[%b]", new Object[] { bpA(), Boolean.valueOf(paramBoolean) });
    if (this.oNV != null) {
      this.oNV.setOneTimeVideoTextureUpdateCallback(this);
    }
    hideLoading();
    gS(paramBoolean);
    tx(getCurrPosSec());
    if (paramBoolean)
    {
      eY(false);
      this.lxK = false;
      if (this.ozA != null) {
        this.ozA.dv(getSessionId(), getMediaId());
      }
    }
  }
  
  protected void eY(boolean paramBoolean)
  {
    ae.d(this.TAG, "%s start timer rightNow[%b]", new Object[] { bpA(), Boolean.valueOf(paramBoolean) });
    this.lxR.ay(500L, 500L);
  }
  
  public void eaX()
  {
    try
    {
      if (this.Fkd != null) {
        this.Fkd.eaX();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e(this.TAG, localThrowable.toString());
    }
  }
  
  public void eb(int paramInt1, int paramInt2)
  {
    ae.i(this.TAG, "%s on get video size [%d, %d]", new Object[] { bpA(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.ozA != null) {
      this.ozA.d(getSessionId(), getMediaId(), paramInt1, paramInt2);
    }
    rd(getReportIdkey() + 8);
  }
  
  protected final void eek()
  {
    if (this.Fkg.loT == 0L) {
      this.Fkg.loT = bu.fpO();
    }
  }
  
  protected com.tencent.mm.plugin.sight.decode.ui.b eiF()
  {
    new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aqS() {}
      
      public final void nP(int paramAnonymousInt)
      {
        AppMethodBeat.i(220268);
        if (AbstractVideoView.this.c(paramAnonymousInt, true)) {
          AbstractVideoView.this.eY(false);
        }
        if (AbstractVideoView.this.Fkb != null) {
          AbstractVideoView.this.Fkb.setIsPlay(true);
        }
        AppMethodBeat.o(220268);
      }
    };
  }
  
  protected final void ffe()
  {
    this.gKO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133981);
        if ((AbstractVideoView.this.lxD != null) && (AbstractVideoView.this.lxD.getVisibility() != 8)) {
          AbstractVideoView.this.lxD.setVisibility(8);
        }
        AppMethodBeat.o(133981);
      }
    });
  }
  
  public final boolean fff()
  {
    long l = this.oNV.getLastSurfaceUpdateTime();
    int i = this.oNV.getCurrentPosition();
    ae.d(this.TAG, "%s check surface is update surface[%d %d] playtime[%d %d]", new Object[] { bpA(), Long.valueOf(this.lxP), Long.valueOf(l), Integer.valueOf(this.lxQ), Integer.valueOf(i) });
    if ((l > 0L) && (l == this.lxP) && (i != this.lxQ))
    {
      ae.w(this.TAG, "%s check surface is update error", new Object[] { bpA() });
      c(this.lxQ / 1000, true);
      return false;
    }
    this.lxP = l;
    this.lxQ = i;
    return true;
  }
  
  protected final void ffg()
  {
    if (this.Fkg.AlH == 0L) {
      this.Fkg.AlH = bu.fpO();
    }
  }
  
  protected final void ffh()
  {
    this.Fkg.Fmf = bu.fpO();
  }
  
  protected final void ffi()
  {
    this.Fkg.Fmg = bu.fpO();
    if (this.Fkg.Fmf > 0L)
    {
      k localk = this.Fkg;
      localk.Fmh += this.Fkg.Fmg - this.Fkg.Fmf;
    }
  }
  
  protected final void ffj()
  {
    k localk = this.Fkg;
    localk.blockCount += 1;
  }
  
  protected final void ffk()
  {
    int k;
    int j;
    int i;
    if ((this.Fkg.Fmg > 0L) && (this.Fkg.Fmf > 0L))
    {
      k = (int)((this.Fkg.Fmg - this.Fkg.Fmf) / 1000L);
      if (!az.isWifi(this.mContext)) {
        break label146;
      }
      j = 70;
      i = 74;
    }
    for (;;)
    {
      int m = getReportIdkey();
      int n = getReportIdkey();
      i = bu.o((Integer)e.a(k, new int[] { 1, 2, 3, 4 }, j + m, i + n));
      ae.d(this.TAG, "%s rptResumeTime [%d]", new Object[] { bpA(), Integer.valueOf(i) });
      rd(i);
      label146:
      do
      {
        return;
        if (az.is4G(this.mContext))
        {
          j = 75;
          i = 79;
          break;
        }
        if (az.is3G(this.mContext))
        {
          j = 80;
          i = 84;
          break;
        }
      } while (!az.is2G(this.mContext));
      j = 85;
      i = 89;
    }
  }
  
  public int getCacheTimeSec()
  {
    return 0;
  }
  
  public int getCurrPosMs()
  {
    if (this.oNV != null) {
      return this.oNV.getCurrentPosition();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    if (this.oNV != null) {
      return Math.round(this.oNV.getCurrentPosition() * 1.0F / 1000.0F);
    }
    return 0;
  }
  
  protected String getMediaId()
  {
    return "";
  }
  
  public int getPlayerType()
  {
    return this.lxL;
  }
  
  protected abstract int getReportIdkey();
  
  public String getSessionId()
  {
    return "";
  }
  
  public int getVideoDurationSec()
  {
    if (this.oNV != null) {
      return Math.round(this.oNV.getDuration() * 1.0F / 1000.0F);
    }
    return -1;
  }
  
  public int getVideoSource()
  {
    return 0;
  }
  
  protected void hideLoading()
  {
    this.gKO.removeMessages(1);
    this.gKO.sendEmptyMessage(2);
  }
  
  protected void initView()
  {
    ae.i(this.TAG, "%s init view ", new Object[] { bpA() });
    LayoutInflater.from(this.mContext).inflate(cOC(), this);
    this.lxz = ((ImageView)findViewById(2131306398));
    this.lxA = ((RelativeLayout)findViewById(2131306392));
    this.gWL = ((TextView)findViewById(2131306332));
    this.lxB = ((ProgressBar)findViewById(2131306352));
    this.lxC = ((TextView)findViewById(2131306403));
    this.lxD = ((LinearLayout)findViewById(2131306342));
    Object localObject = (VideoPlayerSeekBar)findViewById(2131306375);
    this.Fkb = ((VideoPlayerSeekBar)localObject);
    this.Fkc = ((h)localObject);
    if (this.Fkb != null)
    {
      this.Fkb.setIplaySeekCallback(this.rNx);
      this.Fkb.setOnClickListener(this.lxV);
    }
    this.oNV = cN(this.mContext);
    this.oNV.setVideoCallback(this);
    this.oNV.setOnSeekCompleteCallback(this);
    this.oNV.setOnInfoCallback(this);
    this.oNV.setOnSurfaceCallback(this);
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.lxA.addView((View)this.oNV, 0, (ViewGroup.LayoutParams)localObject);
  }
  
  public boolean isPlaying()
  {
    if (this.oNV != null) {}
    for (boolean bool = this.oNV.isPlaying();; bool = false)
    {
      ae.i(this.TAG, "%s is playing[%b]", new Object[] { bpA(), Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public boolean o(double paramDouble)
  {
    return c(paramDouble, isPlaying());
  }
  
  public void onCompletion()
  {
    ae.i(this.TAG, "%s onCompletion, curMs %d, duration %d", new Object[] { bpA(), Integer.valueOf(getCurrPosSec()), Integer.valueOf(getVideoDurationSec()) });
    tx(getVideoDurationSec());
    hideLoading();
    stopTimer();
    if (this.ozA != null) {
      this.ozA.dt(getSessionId(), getMediaId());
    }
    this.lxQ = 0;
    this.lxP = 0L;
    rd(getReportIdkey() + 7);
  }
  
  public void onError(final int paramInt1, int paramInt2)
  {
    ae.w(this.TAG, "%s onError info [%d %d] errorCount[%d]", new Object[] { bpA(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.bFv) });
    rd(getReportIdkey() + 90);
    this.bFv += 1;
    if (this.bFv > 5)
    {
      rd(getReportIdkey() + 92);
      this.Fkg.lFP = paramInt1;
      this.Fkg.lFQ = paramInt2;
      i.b localb;
      String str2;
      String str3;
      String str1;
      if (this.ozA != null)
      {
        localb = this.ozA;
        str2 = getSessionId();
        str3 = getMediaId();
        if (paramInt1 != -1010) {
          break label162;
        }
        str1 = "MEDIA_ERR_SRC_NOT_SUPPORTED";
      }
      for (;;)
      {
        localb.c(str2, str3, str1, paramInt1, paramInt2);
        stop();
        hideLoading();
        return;
        label162:
        if (paramInt1 == -1007) {
          str1 = "MEDIA_ERR_SRC_NOT_SUPPORTED";
        } else if (paramInt1 == -1004)
        {
          if (!az.isConnected(this.mContext)) {
            str1 = "MEDIA_ERR_NETWORK";
          } else {
            str1 = "MEDIA_ERR_DECODE";
          }
        }
        else if (!az.isConnected(this.mContext)) {
          str1 = "MEDIA_ERR_NETWORK";
        } else {
          str1 = "MEDIA_ERR_DECODE";
        }
      }
    }
    paramInt2 = getCurrPosSec();
    if (this.lxN == -1) {}
    for (paramInt1 = paramInt2;; paramInt1 = this.lxN)
    {
      ae.i(this.TAG, "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[] { bpA(), Integer.valueOf(paramInt1), Integer.valueOf(this.lxN), Integer.valueOf(paramInt2) });
      stop();
      showLoading();
      this.gKO.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220266);
          AbstractVideoView.this.lxO = true;
          AbstractVideoView.this.tK(paramInt1);
          AbstractVideoView.this.c(paramInt1, true);
          AbstractVideoView.this.lxO = false;
          AppMethodBeat.o(220266);
        }
      }, 200L);
      return;
    }
  }
  
  public void onUIDestroy()
  {
    ae.i(this.TAG, "%s onUIDestroy", new Object[] { bpA() });
    stop();
    this.gKO.removeCallbacksAndMessages(null);
    stopTimer();
    this.lxT.stopTimer();
    rd(getReportIdkey() + 12);
  }
  
  public void onUIPause()
  {
    ae.i(this.TAG, "%s onUIPause %s", new Object[] { bpA(), bu.fpN() });
    this.lxJ = getCurrPosSec();
    this.lxK = isPlaying();
    this.lxQ = 0;
    this.lxP = 0L;
    pause();
    stopTimer();
    this.lxy = false;
    rd(getReportIdkey() + 11);
  }
  
  public void onUIResume()
  {
    ae.i(this.TAG, "%s onUIResume %s", new Object[] { bpA(), bu.fpN() });
    this.lxy = true;
    rd(getReportIdkey() + 10);
  }
  
  public boolean pause()
  {
    ae.i(this.TAG, "%s pause", new Object[] { bpA() });
    rd(getReportIdkey() + 4);
    if (this.oNV != null)
    {
      gS(false);
      this.oNV.pause();
      stopTimer();
      if (this.ozA != null) {
        this.ozA.du(getSessionId(), getMediaId());
      }
      this.Fkg.AlJ = bu.fpO();
      return true;
    }
    return false;
  }
  
  public boolean play()
  {
    if (!this.lxy) {
      ae.w(this.TAG, "%s ui on pause now, why u call me to play? [%s]", new Object[] { bpA(), bu.fpN() });
    }
    do
    {
      return false;
      rd(getReportIdkey() + 3);
    } while (this.oNV == null);
    boolean bool = this.oNV.start();
    ae.i(this.TAG, "%s video play [%b] isPlayOnUiPause[%b]", new Object[] { bpA(), Boolean.valueOf(bool), Boolean.valueOf(this.lxK) });
    gS(bool);
    if (bool)
    {
      this.lxK = false;
      eY(false);
      if (this.ozA != null) {
        this.ozA.dv(getSessionId(), getMediaId());
      }
    }
    return bool;
  }
  
  protected final void rd(long paramLong)
  {
    if (this.Fkf != null) {
      this.Fkf.rd(paramLong);
    }
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    ae.i(this.TAG, "%s set cover", new Object[] { bpA() });
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.lxz != null)) {
      this.lxz.setImageBitmap(paramBitmap);
    }
  }
  
  public void setFullDirection(int paramInt) {}
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    this.ozA = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    ae.i(this.TAG, "%s is show seek bar[%b]", new Object[] { bpA(), Boolean.valueOf(paramBoolean) });
    this.lxH = paramBoolean;
    if (this.lxH)
    {
      this.gKO.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133990);
          if ((AbstractVideoView.this.lxD != null) && (AbstractVideoView.this.lxD.getVisibility() != 0)) {
            AbstractVideoView.this.lxD.setVisibility(0);
          }
          AppMethodBeat.o(133990);
        }
      });
      return;
    }
    ffe();
  }
  
  public void setLoopCompletionCallback(i.d paramd)
  {
    this.Fkd = paramd;
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.oNV != null) {
      this.oNV.setMute(paramBoolean);
    }
  }
  
  public void setReporter(i.c paramc)
  {
    this.Fkf = paramc;
  }
  
  public void setVideoFooterView(h paramh)
  {
    if (!(paramh instanceof View))
    {
      ae.w(this.TAG, "%s set video footer view but is not view", new Object[] { bpA() });
      return;
    }
    cOS();
    this.Fkc = paramh;
    this.lxI = false;
    this.lxD.addView((View)this.Fkc);
  }
  
  protected void setVideoTotalTime(int paramInt)
  {
    if ((this.Fkc != null) && (this.Fkc.getVideoTotalTime() != paramInt)) {
      this.Fkc.setVideoTotalTime(paramInt);
    }
  }
  
  protected void showLoading()
  {
    tO(500L);
  }
  
  public void stop()
  {
    ae.i(this.TAG, "%s stop", new Object[] { bpA() });
    rd(getReportIdkey() + 6);
    if (this.oNV != null) {
      this.oNV.stop();
    }
    this.lxN = -1;
    this.lxM = true;
    this.Zn = false;
    this.lxQ = 0;
    this.lxP = 0L;
    stopTimer();
    this.gKO.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133982);
        try
        {
          AbstractVideoView.this.tK(0);
          AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
          AppMethodBeat.o(133982);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(133982);
        }
      }
    }, 10L);
    this.Fkg.lFN = bu.fpO();
    int j;
    int i;
    label221:
    Object localObject;
    if (this.Fkg.blockCount > 0)
    {
      if (az.isWifi(this.mContext))
      {
        j = 41;
        i = 45;
        int k = getReportIdkey();
        int m = getReportIdkey();
        i = bu.o((Integer)e.a(this.Fkg.blockCount, new int[] { 1, 2, 3, 4 }, j + k, i + m));
        ae.d(this.TAG, "%s rptBlockCount [%d]", new Object[] { bpA(), Integer.valueOf(i) });
        rd(i);
      }
    }
    else if (this.Fkg.loT != 0L)
    {
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(this.Fkg.loT).append(",");
      ((StringBuffer)localObject).append(this.Fkg.Fme).append(",");
      ((StringBuffer)localObject).append(this.Fkg.lFN).append(",");
      ((StringBuffer)localObject).append(this.Fkg.AlJ).append(",");
      ((StringBuffer)localObject).append(this.Fkg.Fmf).append(",");
      ((StringBuffer)localObject).append(this.Fkg.Fmg).append(",");
      ((StringBuffer)localObject).append(this.Fkg.Fmh).append(",");
      ((StringBuffer)localObject).append(this.Fkg.blockCount).append(",");
      if (this.Fkg.Fme <= 0L) {
        break label802;
      }
      l = this.Fkg.Fme - this.Fkg.loT;
      label423:
      ((StringBuffer)localObject).append(l).append(",");
      ((StringBuffer)localObject).append(this.Fkg.url).append(",");
      ((StringBuffer)localObject).append(this.Fkg.duration).append(",");
      ((StringBuffer)localObject).append(this.Fkg.lFP).append(",");
      ((StringBuffer)localObject).append(this.Fkg.lFQ).append(",");
      ((StringBuffer)localObject).append(this.Fkg.AlH).append(",");
      if (this.Fkg.AlH <= this.Fkg.loT) {
        break label808;
      }
    }
    label802:
    label808:
    for (long l = this.Fkg.AlH - this.Fkg.loT;; l = 0L)
    {
      ((StringBuffer)localObject).append(l).append(",");
      ((StringBuffer)localObject).append(getPlayerType()).append(",");
      ((StringBuffer)localObject).append(getVideoSource());
      localObject = ((StringBuffer)localObject).toString();
      ae.i(this.TAG, "%s rpt video kv stat{%s}", new Object[] { bpA(), localObject });
      if (this.Fkf != null) {
        this.Fkf.vG((String)localObject);
      }
      localObject = this.Fkg;
      ((k)localObject).loT = 0L;
      ((k)localObject).Fme = 0L;
      ((k)localObject).lFN = 0L;
      ((k)localObject).AlJ = 0L;
      ((k)localObject).Fmf = 0L;
      ((k)localObject).Fmg = 0L;
      ((k)localObject).Fmh = 0L;
      ((k)localObject).blockCount = 0;
      ((k)localObject).url = "";
      ((k)localObject).duration = 0;
      ((k)localObject).lFP = 0;
      ((k)localObject).lFQ = 0;
      ((k)localObject).AlH = 0L;
      return;
      if (az.is4G(this.mContext))
      {
        j = 46;
        i = 50;
        break;
      }
      if (az.is3G(this.mContext))
      {
        j = 51;
        i = 55;
        break;
      }
      if (!az.is2G(this.mContext)) {
        break label221;
      }
      j = 56;
      i = 60;
      break;
      l = 0L;
      break label423;
    }
  }
  
  protected void stopTimer()
  {
    this.lxR.stopTimer();
    this.lxS.stopTimer();
  }
  
  public final void tK(int paramInt)
  {
    tx(paramInt);
  }
  
  protected void tO(long paramLong)
  {
    if ((!this.gKO.hasMessages(1)) && (!this.isWaiting)) {
      this.gKO.sendEmptyMessageDelayed(1, paramLong);
    }
  }
  
  public final void ta()
  {
    ae.i(this.TAG, "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[] { bpA(), Boolean.valueOf(this.lxM), Integer.valueOf(this.lxN), Boolean.valueOf(this.Zn) });
    this.Zn = true;
    if (this.oNV != null) {
      this.oNV.setOneTimeVideoTextureUpdateCallback(this);
    }
    setVideoTotalTime(getVideoDurationSec());
    int i;
    int k;
    int j;
    if (this.lxM) {
      if (this.lxN < 0)
      {
        if ((play()) && (dlY())) {
          this.lxS.ay(1000L, 1000L);
        }
        this.lxN = -1;
        this.lxM = true;
        this.lxQ = 0;
        this.lxP = 0L;
        if (this.ozA != null) {
          this.ozA.ds(getSessionId(), getMediaId());
        }
        if (this.bFv > 0)
        {
          ae.d(this.TAG, "%s start error check timer", new Object[] { bpA() });
          this.lxT.ay(5000L, 5000L);
        }
        rd(getReportIdkey() + 2);
        if (this.Fkg.Fme == 0L) {
          this.Fkg.Fme = bu.fpO();
        }
        i = getVideoDurationSec();
        this.Fkg.duration = i;
        if ((this.Fkg.loT > 0L) && (this.Fkg.Fme > 0L))
        {
          k = (int)((this.Fkg.Fme - this.Fkg.loT) / 1000L);
          if (!az.isWifi(this.mContext)) {
            break label466;
          }
          j = 20;
          i = 24;
        }
      }
    }
    for (;;)
    {
      label316:
      int m = getReportIdkey();
      int n = getReportIdkey();
      i = bu.o((Integer)e.a(k, new int[] { 1, 2, 3, 4 }, j + m, i + n));
      ae.d(this.TAG, "%s rptFirstPlayTime [%d]", new Object[] { bpA(), Integer.valueOf(i) });
      rd(i);
      label466:
      do
      {
        return;
        if (!bip())
        {
          c(this.lxN, this.lxM);
          break;
        }
        play();
        break;
        if (this.lxN < 0) {}
        for (double d = 0.0D;; d = this.lxN)
        {
          c(d, this.lxM);
          break;
        }
        if (az.is4G(this.mContext))
        {
          j = 25;
          i = 29;
          break label316;
        }
        if (az.is3G(this.mContext))
        {
          j = 30;
          i = 34;
          break label316;
        }
      } while (!az.is2G(this.mContext));
      j = 35;
      i = 39;
    }
  }
  
  protected void tx(int paramInt)
  {
    if (this.Fkc != null) {
      this.Fkc.tx(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView
 * JD-Core Version:    0.7.0.1
 */