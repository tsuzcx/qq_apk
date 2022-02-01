package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;

public abstract class AbstractVideoView
  extends RelativeLayout
  implements h, h.a, com.tencent.mm.pluginsdk.ui.tools.h.b, com.tencent.mm.pluginsdk.ui.tools.h.c, com.tencent.mm.pluginsdk.ui.tools.h.d, h.e
{
  public VideoPlayerSeekBar BUo;
  protected g BUp;
  protected h.d BUq;
  private h.c BUr = null;
  protected j BUs = new j();
  public String TAG = "MicroMsg.AbstractVideoView";
  protected boolean WD = false;
  protected int bxy = 0;
  protected ap gAC = new ap(Looper.getMainLooper());
  private boolean isWaiting = false;
  protected boolean kuL = true;
  protected ImageView kuM;
  protected RelativeLayout kuN;
  protected TextView kuO;
  protected ProgressBar kuP;
  protected TextView kuQ;
  protected LinearLayout kuR;
  protected boolean kuV;
  protected boolean kuW = true;
  protected int kuX = 0;
  protected boolean kuY = false;
  protected int kuZ = 0;
  protected boolean kva = true;
  protected int kvb = -1;
  protected boolean kvc = false;
  protected long kvd = 0L;
  protected int kve = 0;
  protected av kvf = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(133980);
      if (!AbstractVideoView.this.isPlaying())
      {
        AppMethodBeat.o(133980);
        return false;
      }
      if (AbstractVideoView.this.kuY)
      {
        if (AbstractVideoView.this.nns != null) {
          AbstractVideoView.this.nns.de(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        AbstractVideoView.this.kuY = false;
      }
      AbstractVideoView.this.sm(AbstractVideoView.this.getCurrPosSec());
      AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
      if (AbstractVideoView.this.cCw())
      {
        boolean bool = AbstractVideoView.this.exa();
        AppMethodBeat.o(133980);
        return bool;
      }
      AppMethodBeat.o(133980);
      return true;
    }
  }, true);
  protected av kvg = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(133983);
      boolean bool = AbstractVideoView.this.isPlaying();
      int i = AbstractVideoView.this.getCurrPosMs();
      ad.i(AbstractVideoView.this.TAG, "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[] { AbstractVideoView.this.bel(), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((AbstractVideoView.this.nAZ != null) && (i <= 50)) {
        AbstractVideoView.this.nAZ.q(0.0D);
      }
      AppMethodBeat.o(133983);
      return false;
    }
  }, false);
  protected av kvh = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(133984);
      if (AbstractVideoView.this.bxy > 0)
      {
        if (AbstractVideoView.this.isPlaying())
        {
          AbstractVideoView.a(AbstractVideoView.this);
          AppMethodBeat.o(133984);
          return false;
        }
        AppMethodBeat.o(133984);
        return true;
      }
      AppMethodBeat.o(133984);
      return false;
    }
  }, true);
  private View.OnClickListener kvj = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(133986);
      ad.i(AbstractVideoView.this.TAG, "%s seek bar play button on click ", new Object[] { AbstractVideoView.this.bel() });
      paramAnonymousView = AbstractVideoView.this;
      if (paramAnonymousView.nAZ != null)
      {
        if (paramAnonymousView.isPlaying())
        {
          paramAnonymousView.pause();
          AppMethodBeat.o(133986);
          return;
        }
        if (bt.isNullOrNil(paramAnonymousView.nAZ.getVideoPath()))
        {
          paramAnonymousView.start();
          AppMethodBeat.o(133986);
          return;
        }
        paramAnonymousView.play();
      }
      AppMethodBeat.o(133986);
    }
  };
  private Runnable kvk = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(133987);
      AbstractVideoView.b(AbstractVideoView.this, true);
      if ((AbstractVideoView.this.kuP != null) && (AbstractVideoView.this.kuP.getVisibility() != 0))
      {
        ad.i(AbstractVideoView.this.TAG, "%s show loading", new Object[] { AbstractVideoView.this.bel() });
        AbstractVideoView.this.kuP.setVisibility(0);
      }
      if (AbstractVideoView.this.nns != null) {
        AbstractVideoView.this.nns.dg(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      AppMethodBeat.o(133987);
    }
  };
  protected Context mContext;
  public com.tencent.mm.pluginsdk.ui.tools.h nAZ;
  public h.b nns;
  private b qmw = dEf();
  
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
  
  private void gp(boolean paramBoolean)
  {
    if (this.BUp != null) {
      this.BUp.gp(paramBoolean);
    }
  }
  
  protected final void aBy(String paramString)
  {
    this.BUs.url = paramString;
  }
  
  public void aCw()
  {
    ad.i(this.TAG, "%s on surface available", new Object[] { bel() });
    ez(false);
  }
  
  public final String bel()
  {
    return hashCode();
  }
  
  protected final boolean ben()
  {
    boolean bool;
    if (this.nAZ != null) {
      if ((!bt.isNullOrNil(this.nAZ.getVideoPath())) && (this.WD)) {
        bool = true;
      }
    }
    for (;;)
    {
      ad.d(this.TAG, "%s is prepared [%b] isPrepared[%b]", new Object[] { bel(), Boolean.valueOf(bool), Boolean.valueOf(this.WD) });
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public void beo()
  {
    ad.i(this.TAG, "%s onTextureUpdate ", new Object[] { bel() });
    hideLoading();
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = ben();
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
    if (this.nAZ != null) {
      if (!bt.isNullOrNil(this.nAZ.getVideoPath())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      ad.m(this.TAG, "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[] { bel(), Integer.valueOf(i), Double.valueOf(paramDouble), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Integer.valueOf(j), Boolean.valueOf(bool1) });
      ln(getReportIdkey() + 5);
      if (!bool2) {
        break;
      }
      if (this.nAZ == null) {
        break label215;
      }
      showLoading();
      sa(i);
      this.nAZ.d(i * 1000, paramBoolean);
      return paramBoolean;
      bool1 = false;
      continue;
      bool1 = false;
    }
    this.kvb = i;
    if (bool1) {
      this.kva = true;
    }
    for (;;)
    {
      label215:
      return false;
      this.kva = paramBoolean;
      start();
    }
  }
  
  public final void cCC()
  {
    if (this.BUp != null) {
      this.kuR.removeView((View)this.BUp);
    }
  }
  
  public boolean cCw()
  {
    return false;
  }
  
  protected com.tencent.mm.pluginsdk.ui.tools.h cF(Context paramContext)
  {
    return null;
  }
  
  protected boolean cMg()
  {
    return true;
  }
  
  protected int csg()
  {
    return 2131493573;
  }
  
  protected b dEf()
  {
    new b()
    {
      public final void bcv() {}
      
      public final void rZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(133985);
        if (AbstractVideoView.this.c(paramAnonymousInt, true)) {
          AbstractVideoView.this.ez(false);
        }
        if (AbstractVideoView.this.BUo != null) {
          AbstractVideoView.this.BUo.setIsPlay(true);
        }
        AppMethodBeat.o(133985);
      }
    };
  }
  
  public void dY(int paramInt1, int paramInt2)
  {
    ad.i(this.TAG, "%s on get video size [%d, %d]", new Object[] { bel(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.nns != null) {
      this.nns.d(getSessionId(), getMediaId(), paramInt1, paramInt2);
    }
    ln(getReportIdkey() + 8);
  }
  
  public void dwE()
  {
    try
    {
      if (this.BUq != null) {
        this.BUq.dwE();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e(this.TAG, localThrowable.toString());
    }
  }
  
  protected final void dzT()
  {
    if (this.BUs.kmA == 0L) {
      this.BUs.kmA = bt.eGO();
    }
  }
  
  public final int eM(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  protected final void ewZ()
  {
    this.gAC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133990);
        if ((AbstractVideoView.this.kuR != null) && (AbstractVideoView.this.kuR.getVisibility() != 8)) {
          AbstractVideoView.this.kuR.setVisibility(8);
        }
        AppMethodBeat.o(133990);
      }
    });
  }
  
  public final boolean exa()
  {
    long l = this.nAZ.getLastSurfaceUpdateTime();
    int i = this.nAZ.getCurrentPosition();
    ad.d(this.TAG, "%s check surface is update surface[%d %d] playtime[%d %d]", new Object[] { bel(), Long.valueOf(this.kvd), Long.valueOf(l), Integer.valueOf(this.kve), Integer.valueOf(i) });
    if ((l > 0L) && (l == this.kvd) && (i != this.kve))
    {
      ad.w(this.TAG, "%s check surface is update error", new Object[] { bel() });
      c(this.kve / 1000, true);
      return false;
    }
    this.kvd = l;
    this.kve = i;
    return true;
  }
  
  protected final void exb()
  {
    if (this.BUs.xqo == 0L) {
      this.BUs.xqo = bt.eGO();
    }
  }
  
  protected final void exc()
  {
    this.BUs.BWp = bt.eGO();
  }
  
  protected final void exd()
  {
    this.BUs.BWq = bt.eGO();
    if (this.BUs.BWp > 0L)
    {
      j localj = this.BUs;
      localj.BWr += this.BUs.BWq - this.BUs.BWp;
    }
  }
  
  protected final void exe()
  {
    j localj = this.BUs;
    localj.blockCount += 1;
  }
  
  protected final void exf()
  {
    int k;
    int j;
    int i;
    if ((this.BUs.BWq > 0L) && (this.BUs.BWp > 0L))
    {
      k = (int)((this.BUs.BWq - this.BUs.BWp) / 1000L);
      if (!ay.isWifi(this.mContext)) {
        break label146;
      }
      j = 70;
      i = 74;
    }
    for (;;)
    {
      int m = getReportIdkey();
      int n = getReportIdkey();
      i = bt.l((Integer)e.a(k, new int[] { 1, 2, 3, 4 }, j + m, i + n));
      ad.d(this.TAG, "%s rptResumeTime [%d]", new Object[] { bel(), Integer.valueOf(i) });
      ln(i);
      label146:
      do
      {
        return;
        if (ay.is4G(this.mContext))
        {
          j = 75;
          i = 79;
          break;
        }
        if (ay.is3G(this.mContext))
        {
          j = 80;
          i = 84;
          break;
        }
      } while (!ay.is2G(this.mContext));
      j = 85;
      i = 89;
    }
  }
  
  public void ey(boolean paramBoolean)
  {
    ad.i(this.TAG, "%s on seek complete startPlay[%b]", new Object[] { bel(), Boolean.valueOf(paramBoolean) });
    if (this.nAZ != null) {
      this.nAZ.setOneTimeVideoTextureUpdateCallback(this);
    }
    hideLoading();
    gp(paramBoolean);
    sa(getCurrPosSec());
    if (paramBoolean)
    {
      ez(false);
      this.kuY = false;
      if (this.nns != null) {
        this.nns.de(getSessionId(), getMediaId());
      }
    }
  }
  
  protected void ez(boolean paramBoolean)
  {
    ad.d(this.TAG, "%s start timer rightNow[%b]", new Object[] { bel(), Boolean.valueOf(paramBoolean) });
    this.kvf.av(500L, 500L);
  }
  
  public int getCacheTimeSec()
  {
    return 0;
  }
  
  public int getCurrPosMs()
  {
    if (this.nAZ != null) {
      return this.nAZ.getCurrentPosition();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    if (this.nAZ != null) {
      return Math.round(this.nAZ.getCurrentPosition() * 1.0F / 1000.0F);
    }
    return 0;
  }
  
  protected String getMediaId()
  {
    return "";
  }
  
  public int getPlayerType()
  {
    return this.kuZ;
  }
  
  protected abstract int getReportIdkey();
  
  public String getSessionId()
  {
    return "";
  }
  
  public int getVideoDurationSec()
  {
    if (this.nAZ != null) {
      return Math.round(this.nAZ.getDuration() * 1.0F / 1000.0F);
    }
    return -1;
  }
  
  public int getVideoSource()
  {
    return 0;
  }
  
  protected void hideLoading()
  {
    this.gAC.removeCallbacks(this.kvk);
    this.gAC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133988);
        if (!AbstractVideoView.b(AbstractVideoView.this))
        {
          AppMethodBeat.o(133988);
          return;
        }
        AbstractVideoView.b(AbstractVideoView.this, false);
        if (AbstractVideoView.this.nns != null) {
          AbstractVideoView.this.nns.dh(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        if ((AbstractVideoView.this.kuP != null) && (AbstractVideoView.this.kuP.getVisibility() != 8))
        {
          ad.i(AbstractVideoView.this.TAG, "%s hide loading", new Object[] { AbstractVideoView.this.bel() });
          AbstractVideoView.this.kuP.setVisibility(8);
        }
        AppMethodBeat.o(133988);
      }
    });
  }
  
  protected void initView()
  {
    ad.i(this.TAG, "%s init view ", new Object[] { bel() });
    LayoutInflater.from(this.mContext).inflate(csg(), this);
    this.kuM = ((ImageView)findViewById(2131306398));
    this.kuN = ((RelativeLayout)findViewById(2131306392));
    this.kuO = ((TextView)findViewById(2131306332));
    this.kuP = ((ProgressBar)findViewById(2131306352));
    this.kuQ = ((TextView)findViewById(2131306403));
    this.kuR = ((LinearLayout)findViewById(2131306342));
    Object localObject = (VideoPlayerSeekBar)findViewById(2131306375);
    this.BUo = ((VideoPlayerSeekBar)localObject);
    this.BUp = ((g)localObject);
    if (this.BUo != null)
    {
      this.BUo.setIplaySeekCallback(this.qmw);
      this.BUo.setOnClickListener(this.kvj);
    }
    this.nAZ = cF(this.mContext);
    this.nAZ.setVideoCallback(this);
    this.nAZ.setOnSeekCompleteCallback(this);
    this.nAZ.setOnInfoCallback(this);
    this.nAZ.setOnSurfaceCallback(this);
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.kuN.addView((View)this.nAZ, 0, (ViewGroup.LayoutParams)localObject);
  }
  
  public boolean isPlaying()
  {
    if (this.nAZ != null) {}
    for (boolean bool = this.nAZ.isPlaying();; bool = false)
    {
      ad.i(this.TAG, "%s is playing[%b]", new Object[] { bel(), Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  protected final void ln(long paramLong)
  {
    if (this.BUr != null) {
      this.BUr.ln(paramLong);
    }
  }
  
  protected void nM(long paramLong)
  {
    this.gAC.removeCallbacks(this.kvk);
    this.gAC.postDelayed(this.kvk, paramLong);
  }
  
  public void onCompletion()
  {
    ad.i(this.TAG, "%s onCompletion, curMs %d, duration %d", new Object[] { bel(), Integer.valueOf(getCurrPosSec()), Integer.valueOf(getVideoDurationSec()) });
    sa(getVideoDurationSec());
    hideLoading();
    stopTimer();
    if (this.nns != null) {
      this.nns.dc(getSessionId(), getMediaId());
    }
    this.kve = 0;
    this.kvd = 0L;
    ln(getReportIdkey() + 7);
  }
  
  public void onError(final int paramInt1, int paramInt2)
  {
    ad.w(this.TAG, "%s onError info [%d %d] errorCount[%d]", new Object[] { bel(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.bxy) });
    ln(getReportIdkey() + 90);
    this.bxy += 1;
    if (this.bxy > 5)
    {
      ln(getReportIdkey() + 92);
      this.BUs.kDa = paramInt1;
      this.BUs.kDb = paramInt2;
      h.b localb;
      String str2;
      String str3;
      String str1;
      if (this.nns != null)
      {
        localb = this.nns;
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
          if (!ay.isConnected(this.mContext)) {
            str1 = "MEDIA_ERR_NETWORK";
          } else {
            str1 = "MEDIA_ERR_DECODE";
          }
        }
        else if (!ay.isConnected(this.mContext)) {
          str1 = "MEDIA_ERR_NETWORK";
        } else {
          str1 = "MEDIA_ERR_DECODE";
        }
      }
    }
    paramInt2 = getCurrPosSec();
    if (this.kvb == -1) {}
    for (paramInt1 = paramInt2;; paramInt1 = this.kvb)
    {
      ad.i(this.TAG, "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[] { bel(), Integer.valueOf(paramInt1), Integer.valueOf(this.kvb), Integer.valueOf(paramInt2) });
      stop();
      showLoading();
      this.gAC.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133982);
          AbstractVideoView.this.kvc = true;
          AbstractVideoView.this.sm(paramInt1);
          AbstractVideoView.this.c(paramInt1, true);
          AbstractVideoView.this.kvc = false;
          AppMethodBeat.o(133982);
        }
      }, 200L);
      return;
    }
  }
  
  public void onUIDestroy()
  {
    ad.i(this.TAG, "%s onUIDestroy", new Object[] { bel() });
    stop();
    this.gAC.removeCallbacksAndMessages(null);
    stopTimer();
    this.kvh.stopTimer();
    ln(getReportIdkey() + 12);
  }
  
  public void onUIPause()
  {
    ad.i(this.TAG, "%s onUIPause %s", new Object[] { bel(), bt.eGN() });
    this.kuX = getCurrPosSec();
    this.kuY = isPlaying();
    this.kve = 0;
    this.kvd = 0L;
    pause();
    stopTimer();
    this.kuL = false;
    ln(getReportIdkey() + 11);
  }
  
  public void onUIResume()
  {
    ad.i(this.TAG, "%s onUIResume %s", new Object[] { bel(), bt.eGN() });
    this.kuL = true;
    ln(getReportIdkey() + 10);
  }
  
  public boolean p(double paramDouble)
  {
    return c(paramDouble, isPlaying());
  }
  
  public boolean pause()
  {
    ad.i(this.TAG, "%s pause", new Object[] { bel() });
    ln(getReportIdkey() + 4);
    if (this.nAZ != null)
    {
      gp(false);
      this.nAZ.pause();
      stopTimer();
      if (this.nns != null) {
        this.nns.dd(getSessionId(), getMediaId());
      }
      this.BUs.xqq = bt.eGO();
      return true;
    }
    return false;
  }
  
  public boolean play()
  {
    if (!this.kuL) {
      ad.w(this.TAG, "%s ui on pause now, why u call me to play? [%s]", new Object[] { bel(), bt.eGN() });
    }
    do
    {
      return false;
      ln(getReportIdkey() + 3);
    } while (this.nAZ == null);
    boolean bool = this.nAZ.start();
    ad.i(this.TAG, "%s video play [%b] isPlayOnUiPause[%b]", new Object[] { bel(), Boolean.valueOf(bool), Boolean.valueOf(this.kuY) });
    gp(bool);
    if (bool)
    {
      this.kuY = false;
      ez(false);
      if (this.nns != null) {
        this.nns.de(getSessionId(), getMediaId());
      }
    }
    return bool;
  }
  
  public final void rq()
  {
    ad.i(this.TAG, "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[] { bel(), Boolean.valueOf(this.kva), Integer.valueOf(this.kvb), Boolean.valueOf(this.WD) });
    this.WD = true;
    if (this.nAZ != null) {
      this.nAZ.setOneTimeVideoTextureUpdateCallback(this);
    }
    setVideoTotalTime(getVideoDurationSec());
    int i;
    int k;
    int j;
    if (this.kva) {
      if (this.kvb < 0)
      {
        if ((play()) && (cMg())) {
          this.kvg.av(1000L, 1000L);
        }
        this.kvb = -1;
        this.kva = true;
        this.kve = 0;
        this.kvd = 0L;
        if (this.nns != null) {
          this.nns.db(getSessionId(), getMediaId());
        }
        if (this.bxy > 0)
        {
          ad.d(this.TAG, "%s start error check timer", new Object[] { bel() });
          this.kvh.av(5000L, 5000L);
        }
        ln(getReportIdkey() + 2);
        if (this.BUs.BWo == 0L) {
          this.BUs.BWo = bt.eGO();
        }
        i = getVideoDurationSec();
        this.BUs.duration = i;
        if ((this.BUs.kmA > 0L) && (this.BUs.BWo > 0L))
        {
          k = (int)((this.BUs.BWo - this.BUs.kmA) / 1000L);
          if (!ay.isWifi(this.mContext)) {
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
      i = bt.l((Integer)e.a(k, new int[] { 1, 2, 3, 4 }, j + m, i + n));
      ad.d(this.TAG, "%s rptFirstPlayTime [%d]", new Object[] { bel(), Integer.valueOf(i) });
      ln(i);
      label466:
      do
      {
        return;
        if (!aXf())
        {
          c(this.kvb, this.kva);
          break;
        }
        play();
        break;
        if (this.kvb < 0) {}
        for (double d = 0.0D;; d = this.kvb)
        {
          c(d, this.kva);
          break;
        }
        if (ay.is4G(this.mContext))
        {
          j = 25;
          i = 29;
          break label316;
        }
        if (ay.is3G(this.mContext))
        {
          j = 30;
          i = 34;
          break label316;
        }
      } while (!ay.is2G(this.mContext));
      j = 35;
      i = 39;
    }
  }
  
  protected void sa(int paramInt)
  {
    if (this.BUp != null) {
      this.BUp.sa(paramInt);
    }
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    ad.i(this.TAG, "%s set cover", new Object[] { bel() });
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.kuM != null)) {
      this.kuM.setImageBitmap(paramBitmap);
    }
  }
  
  public void setFullDirection(int paramInt) {}
  
  public void setIMMVideoViewCallback(h.b paramb)
  {
    this.nns = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    ad.i(this.TAG, "%s is show seek bar[%b]", new Object[] { bel(), Boolean.valueOf(paramBoolean) });
    this.kuV = paramBoolean;
    if (this.kuV)
    {
      this.gAC.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133989);
          if ((AbstractVideoView.this.kuR != null) && (AbstractVideoView.this.kuR.getVisibility() != 0)) {
            AbstractVideoView.this.kuR.setVisibility(0);
          }
          AppMethodBeat.o(133989);
        }
      });
      return;
    }
    ewZ();
  }
  
  public void setLoopCompletionCallback(h.d paramd)
  {
    this.BUq = paramd;
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.nAZ != null) {
      this.nAZ.setMute(paramBoolean);
    }
  }
  
  public void setReporter(h.c paramc)
  {
    this.BUr = paramc;
  }
  
  public void setVideoFooterView(g paramg)
  {
    if (!(paramg instanceof View))
    {
      ad.w(this.TAG, "%s set video footer view but is not view", new Object[] { bel() });
      return;
    }
    cCC();
    this.BUp = paramg;
    this.kuW = false;
    this.kuR.addView((View)this.BUp);
  }
  
  protected void setVideoTotalTime(int paramInt)
  {
    if ((this.BUp != null) && (this.BUp.getVideoTotalTime() != paramInt)) {
      this.BUp.setVideoTotalTime(paramInt);
    }
  }
  
  protected void showLoading()
  {
    nM(500L);
  }
  
  public final void sm(int paramInt)
  {
    sa(paramInt);
  }
  
  public void stop()
  {
    ad.i(this.TAG, "%s stop", new Object[] { bel() });
    ln(getReportIdkey() + 6);
    if (this.nAZ != null) {
      this.nAZ.stop();
    }
    this.kvb = -1;
    this.kva = true;
    this.WD = false;
    this.kve = 0;
    this.kvd = 0L;
    stopTimer();
    this.gAC.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133981);
        try
        {
          AbstractVideoView.this.sm(0);
          AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
          AppMethodBeat.o(133981);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(133981);
        }
      }
    }, 10L);
    this.BUs.kCY = bt.eGO();
    int j;
    int i;
    label221:
    Object localObject;
    if (this.BUs.blockCount > 0)
    {
      if (ay.isWifi(this.mContext))
      {
        j = 41;
        i = 45;
        int k = getReportIdkey();
        int m = getReportIdkey();
        i = bt.l((Integer)e.a(this.BUs.blockCount, new int[] { 1, 2, 3, 4 }, j + k, i + m));
        ad.d(this.TAG, "%s rptBlockCount [%d]", new Object[] { bel(), Integer.valueOf(i) });
        ln(i);
      }
    }
    else if (this.BUs.kmA != 0L)
    {
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(this.BUs.kmA).append(",");
      ((StringBuffer)localObject).append(this.BUs.BWo).append(",");
      ((StringBuffer)localObject).append(this.BUs.kCY).append(",");
      ((StringBuffer)localObject).append(this.BUs.xqq).append(",");
      ((StringBuffer)localObject).append(this.BUs.BWp).append(",");
      ((StringBuffer)localObject).append(this.BUs.BWq).append(",");
      ((StringBuffer)localObject).append(this.BUs.BWr).append(",");
      ((StringBuffer)localObject).append(this.BUs.blockCount).append(",");
      if (this.BUs.BWo <= 0L) {
        break label802;
      }
      l = this.BUs.BWo - this.BUs.kmA;
      label423:
      ((StringBuffer)localObject).append(l).append(",");
      ((StringBuffer)localObject).append(this.BUs.url).append(",");
      ((StringBuffer)localObject).append(this.BUs.duration).append(",");
      ((StringBuffer)localObject).append(this.BUs.kDa).append(",");
      ((StringBuffer)localObject).append(this.BUs.kDb).append(",");
      ((StringBuffer)localObject).append(this.BUs.xqo).append(",");
      if (this.BUs.xqo <= this.BUs.kmA) {
        break label808;
      }
    }
    label802:
    label808:
    for (long l = this.BUs.xqo - this.BUs.kmA;; l = 0L)
    {
      ((StringBuffer)localObject).append(l).append(",");
      ((StringBuffer)localObject).append(getPlayerType()).append(",");
      ((StringBuffer)localObject).append(getVideoSource());
      localObject = ((StringBuffer)localObject).toString();
      ad.i(this.TAG, "%s rpt video kv stat{%s}", new Object[] { bel(), localObject });
      if (this.BUr != null) {
        this.BUr.pj((String)localObject);
      }
      localObject = this.BUs;
      ((j)localObject).kmA = 0L;
      ((j)localObject).BWo = 0L;
      ((j)localObject).kCY = 0L;
      ((j)localObject).xqq = 0L;
      ((j)localObject).BWp = 0L;
      ((j)localObject).BWq = 0L;
      ((j)localObject).BWr = 0L;
      ((j)localObject).blockCount = 0;
      ((j)localObject).url = "";
      ((j)localObject).duration = 0;
      ((j)localObject).kDa = 0;
      ((j)localObject).kDb = 0;
      ((j)localObject).xqo = 0L;
      return;
      if (ay.is4G(this.mContext))
      {
        j = 46;
        i = 50;
        break;
      }
      if (ay.is3G(this.mContext))
      {
        j = 51;
        i = 55;
        break;
      }
      if (!ay.is2G(this.mContext)) {
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
    this.kvf.stopTimer();
    this.kvg.stopTimer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView
 * JD-Core Version:    0.7.0.1
 */