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
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.e.b;
import com.tencent.mm.pluginsdk.ui.tools.e.c;
import com.tencent.mm.pluginsdk.ui.tools.e.d;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class AbstractVideoView
  extends RelativeLayout
  implements h, e.a, e.b, e.c, e.d, e.e
{
  protected boolean Pz = false;
  public String TAG = "MicroMsg.AbstractVideoView";
  protected int aZy = 0;
  protected ak faV = new ak(Looper.getMainLooper());
  protected TextView kIA;
  public com.tencent.mm.pluginsdk.ui.tools.e kvG;
  protected Context mContext;
  protected ProgressBar mEy;
  protected ImageView mwF;
  protected TextView rJh;
  public h.b ryi;
  protected boolean vPA = false;
  protected long vPB = 0L;
  protected int vPC = 0;
  protected ap vPD = new ap(new AbstractVideoView.1(this), true);
  protected ap vPE = new ap(new AbstractVideoView.4(this), false);
  protected ap vPF = new ap(new ap.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(117938);
      if (AbstractVideoView.this.aZy > 0)
      {
        if (AbstractVideoView.this.isPlaying())
        {
          AbstractVideoView.a(AbstractVideoView.this);
          AppMethodBeat.o(117938);
          return false;
        }
        AppMethodBeat.o(117938);
        return true;
      }
      AppMethodBeat.o(117938);
      return false;
    }
  }, true);
  private b vPG = cxH();
  private View.OnClickListener vPH = new AbstractVideoView.7(this);
  private Runnable vPI = new AbstractVideoView.8(this);
  private h.c vPJ = null;
  protected j vPK = new j();
  protected boolean vPo = true;
  protected RelativeLayout vPp;
  protected LinearLayout vPq;
  public VideoPlayerSeekBar vPr;
  protected g vPs;
  protected boolean vPt;
  protected boolean vPu = true;
  protected int vPv = 0;
  protected boolean vPw = false;
  protected int vPx = 0;
  protected boolean vPy = true;
  protected int vPz = -1;
  
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
  
  private void Ef(int paramInt)
  {
    this.vPs.Ef(paramInt);
  }
  
  private void oi(boolean paramBoolean)
  {
    this.vPs.oi(paramBoolean);
  }
  
  private void setVideoTotalTime(int paramInt)
  {
    if ((this.vPs != null) && (this.vPs.getVideoTotalTime() != paramInt)) {
      this.vPs.setVideoTotalTime(paramInt);
    }
  }
  
  public void Es()
  {
    ab.i(this.TAG, "%s onCompletion", new Object[] { bas() });
    hideLoading();
    stopTimer();
    if (this.ryi != null) {
      this.ryi.cr(getSessionId(), getMediaId());
    }
    this.vPC = 0;
    this.vPB = 0L;
    hB(getReportIdkey() + 7);
  }
  
  public void aEM()
  {
    ab.i(this.TAG, "%s onUIDestroy", new Object[] { bas() });
    stop();
    this.faV.removeCallbacksAndMessages(null);
    stopTimer();
    this.vPF.stopTimer();
    hB(getReportIdkey() + 12);
  }
  
  protected final void alY(String paramString)
  {
    this.vPK.url = paramString;
  }
  
  public void alo()
  {
    ab.i(this.TAG, "%s onUIPause %s", new Object[] { bas(), bo.dtY() });
    this.vPv = getCurrPosSec();
    this.vPw = isPlaying();
    this.vPC = 0;
    this.vPB = 0L;
    pause();
    stopTimer();
    this.vPo = false;
    hB(getReportIdkey() + 11);
  }
  
  public void alp()
  {
    ab.i(this.TAG, "%s onUIResume %s", new Object[] { bas(), bo.dtY() });
    this.vPo = true;
    hB(getReportIdkey() + 10);
  }
  
  public void alr()
  {
    ab.i(this.TAG, "%s on surface available", new Object[] { bas() });
    dh(false);
  }
  
  public void bSk()
  {
    ab.i(this.TAG, "%s onTextureUpdate ", new Object[] { bas() });
    hideLoading();
  }
  
  protected final boolean bUC()
  {
    boolean bool;
    if (this.kvG != null) {
      if ((!bo.isNullOrNil(this.kvG.getVideoPath())) && (this.Pz)) {
        bool = true;
      }
    }
    for (;;)
    {
      ab.d(this.TAG, "%s is prepared [%b] isPrepared[%b]", new Object[] { bas(), Boolean.valueOf(bool), Boolean.valueOf(this.Pz) });
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public final String bas()
  {
    return hashCode();
  }
  
  protected boolean cKe()
  {
    return true;
  }
  
  protected com.tencent.mm.pluginsdk.ui.tools.e ck(Context paramContext)
  {
    return null;
  }
  
  public final void crA()
  {
    this.vPq.removeView((View)this.vPs);
  }
  
  protected final void cuk()
  {
    if (this.vPK.startTimeStamp == 0L) {
      this.vPK.startTimeStamp = bo.aoy();
    }
  }
  
  protected int cxE()
  {
    return 2130969191;
  }
  
  protected b cxH()
  {
    return new AbstractVideoView.6(this);
  }
  
  public boolean d(double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = bUC();
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
    if (this.kvG != null) {
      if (!bo.isNullOrNil(this.kvG.getVideoPath())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      ab.b(this.TAG, "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[] { bas(), Integer.valueOf(i), Double.valueOf(paramDouble), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Integer.valueOf(j), Boolean.valueOf(bool1) });
      hB(getReportIdkey() + 5);
      if (!bool2) {
        break;
      }
      if (this.kvG == null) {
        break label215;
      }
      showLoading();
      Ef(i);
      this.kvG.e(i * 1000, paramBoolean);
      return paramBoolean;
      bool1 = false;
      continue;
      bool1 = false;
    }
    this.vPz = i;
    if (bool1) {
      this.vPy = true;
    }
    for (;;)
    {
      label215:
      return false;
      this.vPy = paramBoolean;
      start();
    }
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public void dQ(int paramInt1, int paramInt2)
  {
    ab.i(this.TAG, "%s on get video size [%d, %d]", new Object[] { bas(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.ryi != null) {
      this.ryi.d(getSessionId(), getMediaId(), paramInt1, paramInt2);
    }
    hB(getReportIdkey() + 8);
  }
  
  public void dg(boolean paramBoolean)
  {
    ab.i(this.TAG, "%s on seek complete startPlay[%b]", new Object[] { bas(), Boolean.valueOf(paramBoolean) });
    if (this.kvG != null) {
      this.kvG.setOneTimeVideoTextureUpdateCallback(this);
    }
    hideLoading();
    oi(paramBoolean);
    Ef(getCurrPosSec());
    if (paramBoolean)
    {
      dh(false);
      this.vPw = false;
      if (this.ryi != null) {
        this.ryi.ct(getSessionId(), getMediaId());
      }
    }
  }
  
  protected void dh(boolean paramBoolean)
  {
    ab.d(this.TAG, "%s start timer rightNow[%b]", new Object[] { bas(), Boolean.valueOf(paramBoolean) });
    this.vPD.ag(500L, 500L);
  }
  
  protected final void dmN()
  {
    this.faV.post(new AbstractVideoView.11(this));
  }
  
  protected final void dmO()
  {
    if (this.vPK.rJM == 0L) {
      this.vPK.rJM = bo.aoy();
    }
  }
  
  protected final void dmP()
  {
    this.vPK.vRJ = bo.aoy();
  }
  
  protected final void dmQ()
  {
    this.vPK.vRK = bo.aoy();
    if (this.vPK.vRJ > 0L)
    {
      j localj = this.vPK;
      localj.vRL += this.vPK.vRK - this.vPK.vRJ;
    }
  }
  
  protected final void dmR()
  {
    j localj = this.vPK;
    localj.blockCount += 1;
  }
  
  protected final void dmS()
  {
    int k;
    int j;
    int i;
    if ((this.vPK.vRK > 0L) && (this.vPK.vRJ > 0L))
    {
      k = (int)((this.vPK.vRK - this.vPK.vRJ) / 1000L);
      if (!at.isWifi(this.mContext)) {
        break label146;
      }
      j = 70;
      i = 74;
    }
    for (;;)
    {
      int m = getReportIdkey();
      int n = getReportIdkey();
      i = bo.g((Integer)com.tencent.mm.plugin.report.e.a(k, new int[] { 1, 2, 3, 4 }, j + m, i + n));
      ab.d(this.TAG, "%s rptResumeTime [%d]", new Object[] { bas(), Integer.valueOf(i) });
      hB(i);
      label146:
      do
      {
        return;
        if (at.is4G(this.mContext))
        {
          j = 75;
          i = 79;
          break;
        }
        if (at.is3G(this.mContext))
        {
          j = 80;
          i = 84;
          break;
        }
      } while (!at.is2G(this.mContext));
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
    if (this.kvG != null) {
      return this.kvG.getCurrentPosition();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    if (this.kvG != null) {
      return Math.round(this.kvG.getCurrentPosition() * 1.0F / 1000.0F);
    }
    return 0;
  }
  
  protected String getMediaId()
  {
    return "";
  }
  
  public int getPlayerType()
  {
    return this.vPx;
  }
  
  protected abstract int getReportIdkey();
  
  public String getSessionId()
  {
    return "";
  }
  
  public int getVideoDurationSec()
  {
    if (this.kvG != null) {
      return Math.round(this.kvG.getDuration() * 1.0F / 1000.0F);
    }
    return -1;
  }
  
  public int getVideoSource()
  {
    return 0;
  }
  
  protected final void hB(long paramLong)
  {
    if (this.vPJ != null) {
      this.vPJ.hB(paramLong);
    }
  }
  
  public final void hideLoading()
  {
    ab.d(this.TAG, "%s hide loading %s", new Object[] { bas(), bo.dtY() });
    this.faV.removeCallbacks(this.vPI);
    this.faV.post(new AbstractVideoView.9(this));
  }
  
  protected void ie(long paramLong)
  {
    this.faV.postDelayed(this.vPI, paramLong);
  }
  
  protected void initView()
  {
    ab.i(this.TAG, "%s init view ", new Object[] { bas() });
    LayoutInflater.from(this.mContext).inflate(cxE(), this);
    this.mwF = ((ImageView)findViewById(2131822189));
    this.vPp = ((RelativeLayout)findViewById(2131822190));
    this.rJh = ((TextView)findViewById(2131822191));
    this.mEy = ((ProgressBar)findViewById(2131821842));
    this.kIA = ((TextView)findViewById(2131822194));
    this.vPq = ((LinearLayout)findViewById(2131822973));
    Object localObject = (VideoPlayerSeekBar)findViewById(2131822974);
    this.vPr = ((VideoPlayerSeekBar)localObject);
    this.vPs = ((g)localObject);
    this.vPr.setIplaySeekCallback(this.vPG);
    this.vPr.setOnClickListener(this.vPH);
    this.kvG = ck(this.mContext);
    this.kvG.setVideoCallback(this);
    this.kvG.setOnSeekCompleteCallback(this);
    this.kvG.setOnInfoCallback(this);
    this.kvG.setOnSurfaceCallback(this);
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.vPp.addView((View)this.kvG, (ViewGroup.LayoutParams)localObject);
  }
  
  public boolean isPlaying()
  {
    boolean bool = false;
    if (this.kvG != null) {
      bool = this.kvG.isPlaying();
    }
    return bool;
  }
  
  public final void mG()
  {
    ab.i(this.TAG, "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[] { bas(), Boolean.valueOf(this.vPy), Integer.valueOf(this.vPz), Boolean.valueOf(this.Pz) });
    this.Pz = true;
    if (this.kvG != null) {
      this.kvG.setOneTimeVideoTextureUpdateCallback(this);
    }
    setVideoTotalTime(getVideoDurationSec());
    int i;
    int k;
    int j;
    if (this.vPy) {
      if (this.vPz < 0)
      {
        if ((play()) && (cKe())) {
          this.vPE.ag(1000L, 1000L);
        }
        this.vPz = -1;
        this.vPy = true;
        this.vPC = 0;
        this.vPB = 0L;
        if (this.ryi != null) {
          this.ryi.cq(getSessionId(), getMediaId());
        }
        if (this.aZy > 0)
        {
          ab.d(this.TAG, "%s start error check timer", new Object[] { bas() });
          this.vPF.ag(5000L, 5000L);
        }
        hB(getReportIdkey() + 2);
        if (this.vPK.vRH == 0L) {
          this.vPK.vRH = bo.aoy();
        }
        i = getVideoDurationSec();
        this.vPK.duration = i;
        if ((this.vPK.startTimeStamp > 0L) && (this.vPK.vRH > 0L))
        {
          k = (int)((this.vPK.vRH - this.vPK.startTimeStamp) / 1000L);
          if (!at.isWifi(this.mContext)) {
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
      i = bo.g((Integer)com.tencent.mm.plugin.report.e.a(k, new int[] { 1, 2, 3, 4 }, j + m, i + n));
      ab.d(this.TAG, "%s rptFirstPlayTime [%d]", new Object[] { bas(), Integer.valueOf(i) });
      hB(i);
      label466:
      do
      {
        return;
        if (!isLive())
        {
          d(this.vPz, this.vPy);
          break;
        }
        play();
        break;
        if (this.vPz < 0) {}
        for (double d = 0.0D;; d = this.vPz)
        {
          d(d, this.vPy);
          break;
        }
        if (at.is4G(this.mContext))
        {
          j = 25;
          i = 29;
          break label316;
        }
        if (at.is3G(this.mContext))
        {
          j = 30;
          i = 34;
          break label316;
        }
      } while (!at.is2G(this.mContext));
      j = 35;
      i = 39;
    }
  }
  
  public void onError(int paramInt1, int paramInt2)
  {
    ab.w(this.TAG, "%s onError info [%d %d] errorCount[%d]", new Object[] { bas(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.aZy) });
    hB(getReportIdkey() + 90);
    this.aZy += 1;
    if (this.aZy > 5)
    {
      hB(getReportIdkey() + 92);
      this.vPK.vRM = paramInt1;
      this.vPK.vRN = paramInt2;
      h.b localb;
      String str2;
      String str3;
      String str1;
      if (this.ryi != null)
      {
        localb = this.ryi;
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
          if (!at.isConnected(this.mContext)) {
            str1 = "MEDIA_ERR_NETWORK";
          } else {
            str1 = "MEDIA_ERR_DECODE";
          }
        }
        else if (!at.isConnected(this.mContext)) {
          str1 = "MEDIA_ERR_NETWORK";
        } else {
          str1 = "MEDIA_ERR_DECODE";
        }
      }
    }
    paramInt2 = getCurrPosSec();
    if (this.vPz == -1) {}
    for (paramInt1 = paramInt2;; paramInt1 = this.vPz)
    {
      ab.i(this.TAG, "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[] { bas(), Integer.valueOf(paramInt1), Integer.valueOf(this.vPz), Integer.valueOf(paramInt2) });
      stop();
      showLoading();
      this.faV.postDelayed(new AbstractVideoView.3(this, paramInt1), 200L);
      return;
    }
  }
  
  public boolean pause()
  {
    ab.i(this.TAG, "%s pause", new Object[] { bas() });
    hB(getReportIdkey() + 4);
    if (this.kvG != null)
    {
      oi(false);
      this.kvG.pause();
      stopTimer();
      if (this.ryi != null) {
        this.ryi.cs(getSessionId(), getMediaId());
      }
      this.vPK.rJO = bo.aoy();
      return true;
    }
    return false;
  }
  
  public boolean play()
  {
    if (!this.vPo) {
      ab.w(this.TAG, "%s ui on pause now, why u call me to play? [%s]", new Object[] { bas(), bo.dtY() });
    }
    do
    {
      return false;
      hB(getReportIdkey() + 3);
    } while (this.kvG == null);
    boolean bool = this.kvG.start();
    ab.i(this.TAG, "%s video play [%b] isPlayOnUiPause[%b]", new Object[] { bas(), Boolean.valueOf(bool), Boolean.valueOf(this.vPw) });
    oi(bool);
    if (bool)
    {
      this.vPw = false;
      dh(false);
      if (this.ryi != null) {
        this.ryi.ct(getSessionId(), getMediaId());
      }
    }
    return bool;
  }
  
  public final boolean r(double paramDouble)
  {
    return d(paramDouble, isPlaying());
  }
  
  public final void rl(int paramInt)
  {
    Ef(paramInt);
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    ab.i(this.TAG, "%s set cover", new Object[] { bas() });
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      this.mwF.setImageBitmap(paramBitmap);
    }
  }
  
  public void setFullDirection(int paramInt) {}
  
  public void setIMMVideoViewCallback(h.b paramb)
  {
    this.ryi = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    ab.i(this.TAG, "%s is show seek bar[%b]", new Object[] { bas(), Boolean.valueOf(paramBoolean) });
    this.vPt = paramBoolean;
    if (this.vPt)
    {
      this.faV.post(new AbstractVideoView.10(this));
      return;
    }
    dmN();
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.kvG != null) {
      this.kvG.setMute(paramBoolean);
    }
  }
  
  public void setReporter(h.c paramc)
  {
    this.vPJ = paramc;
  }
  
  public void setVideoFooterView(g paramg)
  {
    if (!(paramg instanceof View))
    {
      ab.w(this.TAG, "%s set video footer view but is not view", new Object[] { bas() });
      return;
    }
    crA();
    this.vPs = paramg;
    this.vPu = false;
    this.vPq.addView((View)this.vPs);
  }
  
  protected void showLoading()
  {
    ie(500L);
  }
  
  public void stop()
  {
    ab.i(this.TAG, "%s stop [%s]", new Object[] { bas(), bo.dtY() });
    hB(getReportIdkey() + 6);
    if (this.kvG != null) {
      this.kvG.stop();
    }
    this.vPz = -1;
    this.vPy = true;
    this.Pz = false;
    this.vPC = 0;
    this.vPB = 0L;
    stopTimer();
    this.faV.postDelayed(new AbstractVideoView.2(this), 10L);
    this.vPK.vRI = bo.aoy();
    int j;
    int i;
    label227:
    Object localObject;
    if (this.vPK.blockCount > 0)
    {
      if (at.isWifi(this.mContext))
      {
        j = 41;
        i = 45;
        int k = getReportIdkey();
        int m = getReportIdkey();
        i = bo.g((Integer)com.tencent.mm.plugin.report.e.a(this.vPK.blockCount, new int[] { 1, 2, 3, 4 }, j + k, i + m));
        ab.d(this.TAG, "%s rptBlockCount [%d]", new Object[] { bas(), Integer.valueOf(i) });
        hB(i);
      }
    }
    else if (this.vPK.startTimeStamp != 0L)
    {
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(this.vPK.startTimeStamp).append(",");
      ((StringBuffer)localObject).append(this.vPK.vRH).append(",");
      ((StringBuffer)localObject).append(this.vPK.vRI).append(",");
      ((StringBuffer)localObject).append(this.vPK.rJO).append(",");
      ((StringBuffer)localObject).append(this.vPK.vRJ).append(",");
      ((StringBuffer)localObject).append(this.vPK.vRK).append(",");
      ((StringBuffer)localObject).append(this.vPK.vRL).append(",");
      ((StringBuffer)localObject).append(this.vPK.blockCount).append(",");
      if (this.vPK.vRH <= 0L) {
        break label808;
      }
      l = this.vPK.vRH - this.vPK.startTimeStamp;
      label429:
      ((StringBuffer)localObject).append(l).append(",");
      ((StringBuffer)localObject).append(this.vPK.url).append(",");
      ((StringBuffer)localObject).append(this.vPK.duration).append(",");
      ((StringBuffer)localObject).append(this.vPK.vRM).append(",");
      ((StringBuffer)localObject).append(this.vPK.vRN).append(",");
      ((StringBuffer)localObject).append(this.vPK.rJM).append(",");
      if (this.vPK.rJM <= this.vPK.startTimeStamp) {
        break label814;
      }
    }
    label808:
    label814:
    for (long l = this.vPK.rJM - this.vPK.startTimeStamp;; l = 0L)
    {
      ((StringBuffer)localObject).append(l).append(",");
      ((StringBuffer)localObject).append(getPlayerType()).append(",");
      ((StringBuffer)localObject).append(getVideoSource());
      localObject = ((StringBuffer)localObject).toString();
      ab.i(this.TAG, "%s rpt video kv stat{%s}", new Object[] { bas(), localObject });
      if (this.vPJ != null) {
        this.vPJ.xE((String)localObject);
      }
      localObject = this.vPK;
      ((j)localObject).startTimeStamp = 0L;
      ((j)localObject).vRH = 0L;
      ((j)localObject).vRI = 0L;
      ((j)localObject).rJO = 0L;
      ((j)localObject).vRJ = 0L;
      ((j)localObject).vRK = 0L;
      ((j)localObject).vRL = 0L;
      ((j)localObject).blockCount = 0;
      ((j)localObject).url = "";
      ((j)localObject).duration = 0;
      ((j)localObject).vRM = 0;
      ((j)localObject).vRN = 0;
      ((j)localObject).rJM = 0L;
      return;
      if (at.is4G(this.mContext))
      {
        j = 46;
        i = 50;
        break;
      }
      if (at.is3G(this.mContext))
      {
        j = 51;
        i = 55;
        break;
      }
      if (!at.is2G(this.mContext)) {
        break label227;
      }
      j = 56;
      i = 60;
      break;
      l = 0L;
      break label429;
    }
  }
  
  protected void stopTimer()
  {
    this.vPD.stopTimer();
    this.vPE.stopTimer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView
 * JD-Core Version:    0.7.0.1
 */