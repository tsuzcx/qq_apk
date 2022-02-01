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
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;

public abstract class AbstractVideoView
  extends RelativeLayout
  implements h, h.a, com.tencent.mm.pluginsdk.ui.tools.h.b, com.tencent.mm.pluginsdk.ui.tools.h.c, com.tencent.mm.pluginsdk.ui.tools.h.d, h.e
{
  public VideoPlayerSeekBar DmE;
  protected g DmF;
  protected h.d DmG;
  private h.c DmH = null;
  protected j DmI = new j();
  private Runnable Jsj = new Runnable()
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
      if (AbstractVideoView.this.nQs != null) {
        AbstractVideoView.this.nQs.dt(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      if ((AbstractVideoView.this.kWd != null) && (AbstractVideoView.this.kWd.getVisibility() != 8))
      {
        ac.i(AbstractVideoView.this.TAG, "%s hide loading", new Object[] { AbstractVideoView.this.blf() });
        AbstractVideoView.this.kWd.setVisibility(8);
      }
      AppMethodBeat.o(133989);
    }
  };
  public String TAG = "MicroMsg.AbstractVideoView";
  protected boolean Xy = false;
  protected int bvh = 0;
  protected TextView gAs;
  protected ao gox = new ao(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(210335);
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(210335);
        return;
        AbstractVideoView.a(AbstractVideoView.this).run();
        AppMethodBeat.o(210335);
        return;
        AbstractVideoView.b(AbstractVideoView.this).run();
      }
    }
  };
  private boolean isWaiting = false;
  protected boolean kWa = true;
  protected ImageView kWb;
  protected RelativeLayout kWc;
  protected ProgressBar kWd;
  protected TextView kWe;
  protected LinearLayout kWf;
  protected boolean kWj;
  protected boolean kWk = true;
  protected int kWl = 0;
  protected boolean kWm = false;
  protected int kWn = 0;
  protected boolean kWo = true;
  protected int kWp = -1;
  protected boolean kWq = false;
  protected long kWr = 0L;
  protected int kWs = 0;
  protected au kWt = new au(new au.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(133983);
      if (!AbstractVideoView.this.isPlaying())
      {
        AppMethodBeat.o(133983);
        return false;
      }
      if (AbstractVideoView.this.kWm)
      {
        if (AbstractVideoView.this.nQs != null) {
          AbstractVideoView.this.nQs.dr(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        AbstractVideoView.this.kWm = false;
      }
      AbstractVideoView.this.tc(AbstractVideoView.this.getCurrPosSec());
      AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
      if (AbstractVideoView.this.cPH())
      {
        boolean bool = AbstractVideoView.this.eMu();
        AppMethodBeat.o(133983);
        return bool;
      }
      AppMethodBeat.o(133983);
      return true;
    }
  }, true);
  protected au kWu = new au(new au.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(133984);
      boolean bool = AbstractVideoView.this.isPlaying();
      int i = AbstractVideoView.this.getCurrPosMs();
      ac.i(AbstractVideoView.this.TAG, "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[] { AbstractVideoView.this.blf(), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((AbstractVideoView.this.odZ != null) && (i <= 50)) {
        AbstractVideoView.this.odZ.p(0.0D);
      }
      AppMethodBeat.o(133984);
      return false;
    }
  }, false);
  protected au kWv = new au(new au.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(210337);
      if (AbstractVideoView.this.bvh > 0)
      {
        if (AbstractVideoView.this.isPlaying())
        {
          AbstractVideoView.c(AbstractVideoView.this);
          AppMethodBeat.o(210337);
          return false;
        }
        AppMethodBeat.o(210337);
        return true;
      }
      AppMethodBeat.o(210337);
      return false;
    }
  }, true);
  private View.OnClickListener kWx = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(210339);
      ac.i(AbstractVideoView.this.TAG, "%s seek bar play button on click ", new Object[] { AbstractVideoView.this.blf() });
      paramAnonymousView = AbstractVideoView.this;
      if (paramAnonymousView.odZ != null)
      {
        if (paramAnonymousView.isPlaying())
        {
          paramAnonymousView.pause();
          AppMethodBeat.o(210339);
          return;
        }
        if (bs.isNullOrNil(paramAnonymousView.odZ.getVideoPath()))
        {
          paramAnonymousView.start();
          AppMethodBeat.o(210339);
          return;
        }
        paramAnonymousView.play();
      }
      AppMethodBeat.o(210339);
    }
  };
  private Runnable kWy = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(133988);
      AbstractVideoView.b(AbstractVideoView.this, true);
      if ((AbstractVideoView.this.kWd != null) && (AbstractVideoView.this.kWd.getVisibility() != 0))
      {
        ac.i(AbstractVideoView.this.TAG, "%s show loading", new Object[] { AbstractVideoView.this.blf() });
        AbstractVideoView.this.kWd.setVisibility(0);
      }
      if (AbstractVideoView.this.nQs != null) {
        AbstractVideoView.this.nQs.ds(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      AppMethodBeat.o(133988);
    }
  };
  protected Context mContext;
  public h.b nQs;
  public com.tencent.mm.pluginsdk.ui.tools.h odZ;
  private b qUY = dSD();
  
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
  
  private void gL(boolean paramBoolean)
  {
    if (this.DmF != null) {
      this.DmF.gL(paramBoolean);
    }
  }
  
  protected final void aGQ(String paramString)
  {
    this.DmI.url = paramString;
  }
  
  public void aJn()
  {
    ac.i(this.TAG, "%s on surface available", new Object[] { blf() });
    eT(false);
  }
  
  public final String blf()
  {
    return hashCode();
  }
  
  protected final boolean blh()
  {
    boolean bool;
    if (this.odZ != null) {
      if ((!bs.isNullOrNil(this.odZ.getVideoPath())) && (this.Xy)) {
        bool = true;
      }
    }
    for (;;)
    {
      ac.d(this.TAG, "%s is prepared [%b] isPrepared[%b]", new Object[] { blf(), Boolean.valueOf(bool), Boolean.valueOf(this.Xy) });
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public void bli()
  {
    ac.i(this.TAG, "%s onTextureUpdate ", new Object[] { blf() });
    hideLoading();
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = blh();
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
    if (this.odZ != null) {
      if (!bs.isNullOrNil(this.odZ.getVideoPath())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      ac.m(this.TAG, "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[] { blf(), Integer.valueOf(i), Double.valueOf(paramDouble), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Integer.valueOf(j), Boolean.valueOf(bool1) });
      oQ(getReportIdkey() + 5);
      if (!bool2) {
        break;
      }
      if (this.odZ == null) {
        break label215;
      }
      showLoading();
      sQ(i);
      this.odZ.d(i * 1000, paramBoolean);
      return paramBoolean;
      bool1 = false;
      continue;
      bool1 = false;
    }
    this.kWp = i;
    if (bool1) {
      this.kWo = true;
    }
    for (;;)
    {
      label215:
      return false;
      this.kWo = paramBoolean;
      start();
    }
  }
  
  protected int cDA()
  {
    return 2131493573;
  }
  
  public final void cDR()
  {
    if (this.DmF != null) {
      this.kWf.removeView((View)this.DmF);
    }
  }
  
  protected com.tencent.mm.pluginsdk.ui.tools.h cO(Context paramContext)
  {
    return null;
  }
  
  public boolean cPH()
  {
    return false;
  }
  
  protected boolean cZM()
  {
    return true;
  }
  
  public void dLd()
  {
    try
    {
      if (this.DmG != null) {
        this.DmG.dLd();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e(this.TAG, localThrowable.toString());
    }
  }
  
  protected final void dOq()
  {
    if (this.DmI.kNS == 0L) {
      this.DmI.kNS = bs.eWj();
    }
  }
  
  protected b dSD()
  {
    new b()
    {
      public final void anR() {}
      
      public final void nn(int paramAnonymousInt)
      {
        AppMethodBeat.i(210338);
        if (AbstractVideoView.this.c(paramAnonymousInt, true)) {
          AbstractVideoView.this.eT(false);
        }
        if (AbstractVideoView.this.DmE != null) {
          AbstractVideoView.this.DmE.setIsPlay(true);
        }
        AppMethodBeat.o(210338);
      }
    };
  }
  
  public void dZ(int paramInt1, int paramInt2)
  {
    ac.i(this.TAG, "%s on get video size [%d, %d]", new Object[] { blf(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.nQs != null) {
      this.nQs.d(getSessionId(), getMediaId(), paramInt1, paramInt2);
    }
    oQ(getReportIdkey() + 8);
  }
  
  protected final void eMt()
  {
    this.gox.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133981);
        if ((AbstractVideoView.this.kWf != null) && (AbstractVideoView.this.kWf.getVisibility() != 8)) {
          AbstractVideoView.this.kWf.setVisibility(8);
        }
        AppMethodBeat.o(133981);
      }
    });
  }
  
  public final boolean eMu()
  {
    long l = this.odZ.getLastSurfaceUpdateTime();
    int i = this.odZ.getCurrentPosition();
    ac.d(this.TAG, "%s check surface is update surface[%d %d] playtime[%d %d]", new Object[] { blf(), Long.valueOf(this.kWr), Long.valueOf(l), Integer.valueOf(this.kWs), Integer.valueOf(i) });
    if ((l > 0L) && (l == this.kWr) && (i != this.kWs))
    {
      ac.w(this.TAG, "%s check surface is update error", new Object[] { blf() });
      c(this.kWs / 1000, true);
      return false;
    }
    this.kWr = l;
    this.kWs = i;
    return true;
  }
  
  protected final void eMv()
  {
    if (this.DmI.yDe == 0L) {
      this.DmI.yDe = bs.eWj();
    }
  }
  
  protected final void eMw()
  {
    this.DmI.DoG = bs.eWj();
  }
  
  protected final void eMx()
  {
    this.DmI.DoH = bs.eWj();
    if (this.DmI.DoG > 0L)
    {
      j localj = this.DmI;
      localj.DoI += this.DmI.DoH - this.DmI.DoG;
    }
  }
  
  protected final void eMy()
  {
    j localj = this.DmI;
    localj.blockCount += 1;
  }
  
  protected final void eMz()
  {
    int k;
    int j;
    int i;
    if ((this.DmI.DoH > 0L) && (this.DmI.DoG > 0L))
    {
      k = (int)((this.DmI.DoH - this.DmI.DoG) / 1000L);
      if (!ax.isWifi(this.mContext)) {
        break label146;
      }
      j = 70;
      i = 74;
    }
    for (;;)
    {
      int m = getReportIdkey();
      int n = getReportIdkey();
      i = bs.m((Integer)e.a(k, new int[] { 1, 2, 3, 4 }, j + m, i + n));
      ac.d(this.TAG, "%s rptResumeTime [%d]", new Object[] { blf(), Integer.valueOf(i) });
      oQ(i);
      label146:
      do
      {
        return;
        if (ax.is4G(this.mContext))
        {
          j = 75;
          i = 79;
          break;
        }
        if (ax.is3G(this.mContext))
        {
          j = 80;
          i = 84;
          break;
        }
      } while (!ax.is2G(this.mContext));
      j = 85;
      i = 89;
    }
  }
  
  public final int eP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public void eS(boolean paramBoolean)
  {
    ac.i(this.TAG, "%s on seek complete startPlay[%b]", new Object[] { blf(), Boolean.valueOf(paramBoolean) });
    if (this.odZ != null) {
      this.odZ.setOneTimeVideoTextureUpdateCallback(this);
    }
    hideLoading();
    gL(paramBoolean);
    sQ(getCurrPosSec());
    if (paramBoolean)
    {
      eT(false);
      this.kWm = false;
      if (this.nQs != null) {
        this.nQs.dr(getSessionId(), getMediaId());
      }
    }
  }
  
  protected void eT(boolean paramBoolean)
  {
    ac.d(this.TAG, "%s start timer rightNow[%b]", new Object[] { blf(), Boolean.valueOf(paramBoolean) });
    this.kWt.au(500L, 500L);
  }
  
  public int getCacheTimeSec()
  {
    return 0;
  }
  
  public int getCurrPosMs()
  {
    if (this.odZ != null) {
      return this.odZ.getCurrentPosition();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    if (this.odZ != null) {
      return Math.round(this.odZ.getCurrentPosition() * 1.0F / 1000.0F);
    }
    return 0;
  }
  
  protected String getMediaId()
  {
    return "";
  }
  
  public int getPlayerType()
  {
    return this.kWn;
  }
  
  protected abstract int getReportIdkey();
  
  public String getSessionId()
  {
    return "";
  }
  
  public int getVideoDurationSec()
  {
    if (this.odZ != null) {
      return Math.round(this.odZ.getDuration() * 1.0F / 1000.0F);
    }
    return -1;
  }
  
  public int getVideoSource()
  {
    return 0;
  }
  
  protected void hideLoading()
  {
    this.gox.removeMessages(1);
    this.gox.sendEmptyMessage(2);
  }
  
  protected void initView()
  {
    ac.i(this.TAG, "%s init view ", new Object[] { blf() });
    LayoutInflater.from(this.mContext).inflate(cDA(), this);
    this.kWb = ((ImageView)findViewById(2131306398));
    this.kWc = ((RelativeLayout)findViewById(2131306392));
    this.gAs = ((TextView)findViewById(2131306332));
    this.kWd = ((ProgressBar)findViewById(2131306352));
    this.kWe = ((TextView)findViewById(2131306403));
    this.kWf = ((LinearLayout)findViewById(2131306342));
    Object localObject = (VideoPlayerSeekBar)findViewById(2131306375);
    this.DmE = ((VideoPlayerSeekBar)localObject);
    this.DmF = ((g)localObject);
    if (this.DmE != null)
    {
      this.DmE.setIplaySeekCallback(this.qUY);
      this.DmE.setOnClickListener(this.kWx);
    }
    this.odZ = cO(this.mContext);
    this.odZ.setVideoCallback(this);
    this.odZ.setOnSeekCompleteCallback(this);
    this.odZ.setOnInfoCallback(this);
    this.odZ.setOnSurfaceCallback(this);
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.kWc.addView((View)this.odZ, 0, (ViewGroup.LayoutParams)localObject);
  }
  
  public boolean isPlaying()
  {
    if (this.odZ != null) {}
    for (boolean bool = this.odZ.isPlaying();; bool = false)
    {
      ac.i(this.TAG, "%s is playing[%b]", new Object[] { blf(), Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public boolean o(double paramDouble)
  {
    return c(paramDouble, isPlaying());
  }
  
  protected final void oQ(long paramLong)
  {
    if (this.DmH != null) {
      this.DmH.oQ(paramLong);
    }
  }
  
  public void onCompletion()
  {
    ac.i(this.TAG, "%s onCompletion, curMs %d, duration %d", new Object[] { blf(), Integer.valueOf(getCurrPosSec()), Integer.valueOf(getVideoDurationSec()) });
    sQ(getVideoDurationSec());
    hideLoading();
    stopTimer();
    if (this.nQs != null) {
      this.nQs.dp(getSessionId(), getMediaId());
    }
    this.kWs = 0;
    this.kWr = 0L;
    oQ(getReportIdkey() + 7);
  }
  
  public void onError(int paramInt1, int paramInt2)
  {
    ac.w(this.TAG, "%s onError info [%d %d] errorCount[%d]", new Object[] { blf(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.bvh) });
    oQ(getReportIdkey() + 90);
    this.bvh += 1;
    if (this.bvh > 5)
    {
      oQ(getReportIdkey() + 92);
      this.DmI.les = paramInt1;
      this.DmI.let = paramInt2;
      h.b localb;
      String str2;
      String str3;
      String str1;
      if (this.nQs != null)
      {
        localb = this.nQs;
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
          if (!ax.isConnected(this.mContext)) {
            str1 = "MEDIA_ERR_NETWORK";
          } else {
            str1 = "MEDIA_ERR_DECODE";
          }
        }
        else if (!ax.isConnected(this.mContext)) {
          str1 = "MEDIA_ERR_NETWORK";
        } else {
          str1 = "MEDIA_ERR_DECODE";
        }
      }
    }
    paramInt2 = getCurrPosSec();
    if (this.kWp == -1) {}
    for (paramInt1 = paramInt2;; paramInt1 = this.kWp)
    {
      ac.i(this.TAG, "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[] { blf(), Integer.valueOf(paramInt1), Integer.valueOf(this.kWp), Integer.valueOf(paramInt2) });
      stop();
      showLoading();
      this.gox.postDelayed(new AbstractVideoView.12(this, paramInt1), 200L);
      return;
    }
  }
  
  public void onUIDestroy()
  {
    ac.i(this.TAG, "%s onUIDestroy", new Object[] { blf() });
    stop();
    this.gox.removeCallbacksAndMessages(null);
    stopTimer();
    this.kWv.stopTimer();
    oQ(getReportIdkey() + 12);
  }
  
  public void onUIPause()
  {
    ac.i(this.TAG, "%s onUIPause %s", new Object[] { blf(), bs.eWi() });
    this.kWl = getCurrPosSec();
    this.kWm = isPlaying();
    this.kWs = 0;
    this.kWr = 0L;
    pause();
    stopTimer();
    this.kWa = false;
    oQ(getReportIdkey() + 11);
  }
  
  public void onUIResume()
  {
    ac.i(this.TAG, "%s onUIResume %s", new Object[] { blf(), bs.eWi() });
    this.kWa = true;
    oQ(getReportIdkey() + 10);
  }
  
  public boolean pause()
  {
    ac.i(this.TAG, "%s pause", new Object[] { blf() });
    oQ(getReportIdkey() + 4);
    if (this.odZ != null)
    {
      gL(false);
      this.odZ.pause();
      stopTimer();
      if (this.nQs != null) {
        this.nQs.dq(getSessionId(), getMediaId());
      }
      this.DmI.yDg = bs.eWj();
      return true;
    }
    return false;
  }
  
  public boolean play()
  {
    if (!this.kWa) {
      ac.w(this.TAG, "%s ui on pause now, why u call me to play? [%s]", new Object[] { blf(), bs.eWi() });
    }
    do
    {
      return false;
      oQ(getReportIdkey() + 3);
    } while (this.odZ == null);
    boolean bool = this.odZ.start();
    ac.i(this.TAG, "%s video play [%b] isPlayOnUiPause[%b]", new Object[] { blf(), Boolean.valueOf(bool), Boolean.valueOf(this.kWm) });
    gL(bool);
    if (bool)
    {
      this.kWm = false;
      eT(false);
      if (this.nQs != null) {
        this.nQs.dr(getSessionId(), getMediaId());
      }
    }
    return bool;
  }
  
  public final void rB()
  {
    ac.i(this.TAG, "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[] { blf(), Boolean.valueOf(this.kWo), Integer.valueOf(this.kWp), Boolean.valueOf(this.Xy) });
    this.Xy = true;
    if (this.odZ != null) {
      this.odZ.setOneTimeVideoTextureUpdateCallback(this);
    }
    setVideoTotalTime(getVideoDurationSec());
    int i;
    int k;
    int j;
    if (this.kWo) {
      if (this.kWp < 0)
      {
        if ((play()) && (cZM())) {
          this.kWu.au(1000L, 1000L);
        }
        this.kWp = -1;
        this.kWo = true;
        this.kWs = 0;
        this.kWr = 0L;
        if (this.nQs != null) {
          this.nQs.jdMethod_do(getSessionId(), getMediaId());
        }
        if (this.bvh > 0)
        {
          ac.d(this.TAG, "%s start error check timer", new Object[] { blf() });
          this.kWv.au(5000L, 5000L);
        }
        oQ(getReportIdkey() + 2);
        if (this.DmI.DoF == 0L) {
          this.DmI.DoF = bs.eWj();
        }
        i = getVideoDurationSec();
        this.DmI.duration = i;
        if ((this.DmI.kNS > 0L) && (this.DmI.DoF > 0L))
        {
          k = (int)((this.DmI.DoF - this.DmI.kNS) / 1000L);
          if (!ax.isWifi(this.mContext)) {
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
      i = bs.m((Integer)e.a(k, new int[] { 1, 2, 3, 4 }, j + m, i + n));
      ac.d(this.TAG, "%s rptFirstPlayTime [%d]", new Object[] { blf(), Integer.valueOf(i) });
      oQ(i);
      label466:
      do
      {
        return;
        if (!bed())
        {
          c(this.kWp, this.kWo);
          break;
        }
        play();
        break;
        if (this.kWp < 0) {}
        for (double d = 0.0D;; d = this.kWp)
        {
          c(d, this.kWo);
          break;
        }
        if (ax.is4G(this.mContext))
        {
          j = 25;
          i = 29;
          break label316;
        }
        if (ax.is3G(this.mContext))
        {
          j = 30;
          i = 34;
          break label316;
        }
      } while (!ax.is2G(this.mContext));
      j = 35;
      i = 39;
    }
  }
  
  protected void ry(long paramLong)
  {
    if ((!this.gox.hasMessages(1)) && (!this.isWaiting)) {
      this.gox.sendEmptyMessageDelayed(1, paramLong);
    }
  }
  
  protected void sQ(int paramInt)
  {
    if (this.DmF != null) {
      this.DmF.sQ(paramInt);
    }
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    ac.i(this.TAG, "%s set cover", new Object[] { blf() });
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.kWb != null)) {
      this.kWb.setImageBitmap(paramBitmap);
    }
  }
  
  public void setFullDirection(int paramInt) {}
  
  public void setIMMVideoViewCallback(h.b paramb)
  {
    this.nQs = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    ac.i(this.TAG, "%s is show seek bar[%b]", new Object[] { blf(), Boolean.valueOf(paramBoolean) });
    this.kWj = paramBoolean;
    if (this.kWj)
    {
      this.gox.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133990);
          if ((AbstractVideoView.this.kWf != null) && (AbstractVideoView.this.kWf.getVisibility() != 0)) {
            AbstractVideoView.this.kWf.setVisibility(0);
          }
          AppMethodBeat.o(133990);
        }
      });
      return;
    }
    eMt();
  }
  
  public void setLoopCompletionCallback(h.d paramd)
  {
    this.DmG = paramd;
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.odZ != null) {
      this.odZ.setMute(paramBoolean);
    }
  }
  
  public void setReporter(h.c paramc)
  {
    this.DmH = paramc;
  }
  
  public void setVideoFooterView(g paramg)
  {
    if (!(paramg instanceof View))
    {
      ac.w(this.TAG, "%s set video footer view but is not view", new Object[] { blf() });
      return;
    }
    cDR();
    this.DmF = paramg;
    this.kWk = false;
    this.kWf.addView((View)this.DmF);
  }
  
  protected void setVideoTotalTime(int paramInt)
  {
    if ((this.DmF != null) && (this.DmF.getVideoTotalTime() != paramInt)) {
      this.DmF.setVideoTotalTime(paramInt);
    }
  }
  
  protected void showLoading()
  {
    ry(500L);
  }
  
  public void stop()
  {
    ac.i(this.TAG, "%s stop", new Object[] { blf() });
    oQ(getReportIdkey() + 6);
    if (this.odZ != null) {
      this.odZ.stop();
    }
    this.kWp = -1;
    this.kWo = true;
    this.Xy = false;
    this.kWs = 0;
    this.kWr = 0L;
    stopTimer();
    this.gox.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133982);
        try
        {
          AbstractVideoView.this.tc(0);
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
    this.DmI.leq = bs.eWj();
    int j;
    int i;
    label221:
    Object localObject;
    if (this.DmI.blockCount > 0)
    {
      if (ax.isWifi(this.mContext))
      {
        j = 41;
        i = 45;
        int k = getReportIdkey();
        int m = getReportIdkey();
        i = bs.m((Integer)e.a(this.DmI.blockCount, new int[] { 1, 2, 3, 4 }, j + k, i + m));
        ac.d(this.TAG, "%s rptBlockCount [%d]", new Object[] { blf(), Integer.valueOf(i) });
        oQ(i);
      }
    }
    else if (this.DmI.kNS != 0L)
    {
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(this.DmI.kNS).append(",");
      ((StringBuffer)localObject).append(this.DmI.DoF).append(",");
      ((StringBuffer)localObject).append(this.DmI.leq).append(",");
      ((StringBuffer)localObject).append(this.DmI.yDg).append(",");
      ((StringBuffer)localObject).append(this.DmI.DoG).append(",");
      ((StringBuffer)localObject).append(this.DmI.DoH).append(",");
      ((StringBuffer)localObject).append(this.DmI.DoI).append(",");
      ((StringBuffer)localObject).append(this.DmI.blockCount).append(",");
      if (this.DmI.DoF <= 0L) {
        break label802;
      }
      l = this.DmI.DoF - this.DmI.kNS;
      label423:
      ((StringBuffer)localObject).append(l).append(",");
      ((StringBuffer)localObject).append(this.DmI.url).append(",");
      ((StringBuffer)localObject).append(this.DmI.duration).append(",");
      ((StringBuffer)localObject).append(this.DmI.les).append(",");
      ((StringBuffer)localObject).append(this.DmI.let).append(",");
      ((StringBuffer)localObject).append(this.DmI.yDe).append(",");
      if (this.DmI.yDe <= this.DmI.kNS) {
        break label808;
      }
    }
    label802:
    label808:
    for (long l = this.DmI.yDe - this.DmI.kNS;; l = 0L)
    {
      ((StringBuffer)localObject).append(l).append(",");
      ((StringBuffer)localObject).append(getPlayerType()).append(",");
      ((StringBuffer)localObject).append(getVideoSource());
      localObject = ((StringBuffer)localObject).toString();
      ac.i(this.TAG, "%s rpt video kv stat{%s}", new Object[] { blf(), localObject });
      if (this.DmH != null) {
        this.DmH.sv((String)localObject);
      }
      localObject = this.DmI;
      ((j)localObject).kNS = 0L;
      ((j)localObject).DoF = 0L;
      ((j)localObject).leq = 0L;
      ((j)localObject).yDg = 0L;
      ((j)localObject).DoG = 0L;
      ((j)localObject).DoH = 0L;
      ((j)localObject).DoI = 0L;
      ((j)localObject).blockCount = 0;
      ((j)localObject).url = "";
      ((j)localObject).duration = 0;
      ((j)localObject).les = 0;
      ((j)localObject).let = 0;
      ((j)localObject).yDe = 0L;
      return;
      if (ax.is4G(this.mContext))
      {
        j = 46;
        i = 50;
        break;
      }
      if (ax.is3G(this.mContext))
      {
        j = 51;
        i = 55;
        break;
      }
      if (!ax.is2G(this.mContext)) {
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
    this.kWt.stopTimer();
    this.kWu.stopTimer();
  }
  
  public final void tc(int paramInt)
  {
    sQ(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView
 * JD-Core Version:    0.7.0.1
 */