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
import com.tencent.mm.plugin.ac.a.a;
import com.tencent.mm.plugin.ac.a.b;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.b;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public abstract class AbstractVideoView
  extends RelativeLayout
  implements h, f.a, f.b, f.c, f.d, f.e
{
  private boolean PT = false;
  public String TAG = "MicroMsg.AbstractVideoView";
  private int aRY = 0;
  protected ah dPi = new ah(Looper.getMainLooper());
  protected TextView iDt;
  public com.tencent.mm.pluginsdk.ui.tools.f iuC;
  protected ImageView kcc;
  protected ProgressBar kjT;
  public Context mContext;
  public h.b oIn;
  protected TextView oRw;
  protected RelativeLayout rYA;
  protected LinearLayout rYB;
  protected VideoPlayerSeekBar rYC;
  protected g rYD;
  protected boolean rYE;
  protected boolean rYF = true;
  public int rYG = 0;
  public boolean rYH = false;
  public int rYI = 0;
  public boolean rYJ = true;
  public int rYK = -1;
  public boolean rYL = false;
  public long rYM = 0L;
  public int rYN = 0;
  protected am rYO = new am(new AbstractVideoView.1(this), true);
  protected am rYP = new am(new am.a()
  {
    public final boolean tC()
    {
      boolean bool = AbstractVideoView.this.isPlaying();
      int i = AbstractVideoView.this.getCurrPosMs();
      y.i(AbstractVideoView.this.TAG, "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[] { AbstractVideoView.this.ayL(), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((AbstractVideoView.this.iuC != null) && (i <= 50)) {
        AbstractVideoView.this.iuC.x(0.0D);
      }
      return false;
    }
  }, false);
  protected am rYQ = new am(new AbstractVideoView.5(this), true);
  private b rYR = new AbstractVideoView.6(this);
  private View.OnClickListener rYS = new AbstractVideoView.7(this);
  private h.c rYT = null;
  protected k rYU = new k();
  public boolean rYz = true;
  
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
  
  private void kZ(boolean paramBoolean)
  {
    this.rYD.kZ(paramBoolean);
  }
  
  private void setVideoTotalTime(int paramInt)
  {
    if ((this.rYD != null) && (this.rYD.getVideoTotalTime() != paramInt)) {
      this.rYD.setVideoTotalTime(paramInt);
    }
  }
  
  public void Se()
  {
    y.i(this.TAG, "%s onUIPause %s", new Object[] { ayL(), bk.csb() });
    this.rYG = getCurrPosSec();
    this.rYH = isPlaying();
    this.rYN = 0;
    this.rYM = 0L;
    pause();
    stopTimer();
    this.rYz = false;
    cB(getReportIdkey() + 11);
  }
  
  public void Sf()
  {
    y.i(this.TAG, "%s onUIResume %s", new Object[] { ayL(), bk.csb() });
    this.rYz = true;
    cB(getReportIdkey() + 10);
  }
  
  public void Sh()
  {
    y.i(this.TAG, "%s on surface available", new Object[] { ayL() });
    ce(false);
  }
  
  protected final void Ws(String paramString)
  {
    this.rYU.url = paramString;
  }
  
  public void akT()
  {
    y.i(this.TAG, "%s onUIDestroy", new Object[] { ayL() });
    stop();
    this.dPi.removeCallbacksAndMessages(null);
    stopTimer();
    this.rYQ.stopTimer();
    cB(getReportIdkey() + 12);
  }
  
  public final void apT()
  {
    this.dPi.post(new AbstractVideoView.8(this));
  }
  
  public final String ayL()
  {
    return hashCode();
  }
  
  public com.tencent.mm.pluginsdk.ui.tools.f bF(Context paramContext)
  {
    return null;
  }
  
  public final void bFF()
  {
    this.rYB.removeView((View)this.rYD);
  }
  
  public final void bHW()
  {
    if (this.rYU.startTimeStamp == 0L) {
      this.rYU.startTimeStamp = bk.UY();
    }
  }
  
  public boolean bOr()
  {
    return true;
  }
  
  public final void bdC()
  {
    y.d(this.TAG, "%s hide loading %s", new Object[] { ayL(), bk.csb() });
    this.dPi.post(new AbstractVideoView.9(this));
  }
  
  public final void bkk()
  {
    y.i(this.TAG, "%s onTextureUpdate ", new Object[] { ayL() });
    bdC();
  }
  
  public final void cB(long paramLong)
  {
    if (this.rYT != null) {
      this.rYT.cB(paramLong);
    }
  }
  
  public void cd(boolean paramBoolean)
  {
    y.i(this.TAG, "%s on seek complete startPlay[%b]", new Object[] { ayL(), Boolean.valueOf(paramBoolean) });
    if (this.iuC != null) {
      this.iuC.setOneTimeVideoTextureUpdateCallback(this);
    }
    bdC();
    kZ(paramBoolean);
    nD(getCurrPosSec());
    if (paramBoolean)
    {
      ce(false);
      this.rYH = false;
      if (this.oIn != null) {
        this.oIn.bK(getSessionId(), getMediaId());
      }
    }
  }
  
  public void ce(boolean paramBoolean)
  {
    y.d(this.TAG, "%s start timer rightNow[%b]", new Object[] { ayL(), Boolean.valueOf(paramBoolean) });
    this.rYO.S(500L, 500L);
  }
  
  public final void clY()
  {
    if (this.rYU.oRU == 0L) {
      this.rYU.oRU = bk.UY();
    }
  }
  
  public final void clZ()
  {
    this.rYU.saQ = bk.UY();
  }
  
  public final void cma()
  {
    this.rYU.saR = bk.UY();
    if (this.rYU.saQ > 0L)
    {
      k localk = this.rYU;
      localk.saS += this.rYU.saR - this.rYU.saQ;
    }
  }
  
  public final void cmb()
  {
    k localk = this.rYU;
    localk.blockCount += 1;
  }
  
  public final void cmc()
  {
    int k;
    int j;
    int i;
    if ((this.rYU.saR > 0L) && (this.rYU.saQ > 0L))
    {
      k = (int)((this.rYU.saR - this.rYU.saQ) / 1000L);
      if (!aq.isWifi(this.mContext)) {
        break label146;
      }
      j = 70;
      i = 74;
    }
    for (;;)
    {
      int m = getReportIdkey();
      int n = getReportIdkey();
      i = bk.g((Integer)com.tencent.mm.plugin.report.f.a(k, new int[] { 1, 2, 3, 4 }, j + m, i + n));
      y.d(this.TAG, "%s rptResumeTime [%d]", new Object[] { ayL(), Integer.valueOf(i) });
      cB(i);
      label146:
      do
      {
        return;
        if (aq.is4G(this.mContext))
        {
          j = 75;
          i = 79;
          break;
        }
        if (aq.is3G(this.mContext))
        {
          j = 80;
          i = 84;
          break;
        }
      } while (!aq.is2G(this.mContext));
      j = 85;
      i = 89;
    }
  }
  
  public final int cv(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void cw(int paramInt1, int paramInt2)
  {
    y.i(this.TAG, "%s on get video size [%d, %d]", new Object[] { ayL(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.oIn != null) {
      this.oIn.d(getSessionId(), getMediaId(), paramInt1, paramInt2);
    }
    cB(getReportIdkey() + 8);
  }
  
  public int getCacheTimeSec()
  {
    return 0;
  }
  
  public int getCurrPosMs()
  {
    if (this.iuC != null) {
      return this.iuC.getCurrentPosition();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    if (this.iuC != null) {
      return Math.round(this.iuC.getCurrentPosition() * 1.0F / 1000.0F);
    }
    return 0;
  }
  
  public String getMediaId()
  {
    return "";
  }
  
  public int getPlayerType()
  {
    return this.rYI;
  }
  
  public abstract int getReportIdkey();
  
  public String getSessionId()
  {
    return "";
  }
  
  public int getVideoDurationSec()
  {
    if (this.iuC != null) {
      return Math.round(this.iuC.getDuration() * 1.0F / 1000.0F);
    }
    return -1;
  }
  
  public int getVideoSource()
  {
    return 0;
  }
  
  public void initView()
  {
    y.i(this.TAG, "%s init view ", new Object[] { ayL() });
    LayoutInflater.from(this.mContext).inflate(a.b.comm_video_view, this);
    this.kcc = ((ImageView)findViewById(a.a.video_thumb));
    this.rYA = ((RelativeLayout)findViewById(a.a.video_root));
    this.oRw = ((TextView)findViewById(a.a.video_duration));
    this.kjT = ((ProgressBar)findViewById(a.a.video_loading));
    this.iDt = ((TextView)findViewById(a.a.video_tips));
    this.rYB = ((LinearLayout)findViewById(a.a.video_footer_root));
    Object localObject = (VideoPlayerSeekBar)findViewById(a.a.video_player_seek_bar);
    this.rYC = ((VideoPlayerSeekBar)localObject);
    this.rYD = ((g)localObject);
    this.rYC.setIplaySeekCallback(this.rYR);
    this.rYC.setOnClickListener(this.rYS);
    this.iuC = bF(this.mContext);
    this.iuC.setVideoCallback(this);
    this.iuC.setOnSeekCompleteCallback(this);
    this.iuC.setOnInfoCallback(this);
    this.iuC.setOnSurfaceCallback(this);
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.rYA.addView((View)this.iuC, (ViewGroup.LayoutParams)localObject);
  }
  
  public boolean isPlaying()
  {
    boolean bool = false;
    if (this.iuC != null) {
      bool = this.iuC.isPlaying();
    }
    return bool;
  }
  
  public final boolean isPrepared()
  {
    boolean bool;
    if (this.iuC != null) {
      if ((!bk.bl(this.iuC.getVideoPath())) && (this.PT)) {
        bool = true;
      }
    }
    for (;;)
    {
      y.d(this.TAG, "%s is prepared [%b] isPrepared[%b]", new Object[] { ayL(), Boolean.valueOf(bool), Boolean.valueOf(this.PT) });
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public final void kA()
  {
    y.i(this.TAG, "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[] { ayL(), Boolean.valueOf(this.rYJ), Integer.valueOf(this.rYK), Boolean.valueOf(this.PT) });
    this.PT = true;
    if (this.iuC != null) {
      this.iuC.setOneTimeVideoTextureUpdateCallback(this);
    }
    setVideoTotalTime(getVideoDurationSec());
    int i;
    int k;
    int j;
    if (this.rYJ) {
      if (this.rYK < 0)
      {
        if ((play()) && (bOr())) {
          this.rYP.S(1000L, 1000L);
        }
        this.rYK = -1;
        this.rYJ = true;
        this.rYN = 0;
        this.rYM = 0L;
        if (this.oIn != null) {
          this.oIn.bH(getSessionId(), getMediaId());
        }
        if (this.aRY > 0)
        {
          y.d(this.TAG, "%s start error check timer", new Object[] { ayL() });
          this.rYQ.S(5000L, 5000L);
        }
        cB(getReportIdkey() + 2);
        if (this.rYU.saO == 0L) {
          this.rYU.saO = bk.UY();
        }
        i = getVideoDurationSec();
        this.rYU.duration = i;
        if ((this.rYU.startTimeStamp > 0L) && (this.rYU.saO > 0L))
        {
          k = (int)((this.rYU.saO - this.rYU.startTimeStamp) / 1000L);
          if (!aq.isWifi(this.mContext)) {
            break label460;
          }
          j = 20;
          i = 24;
        }
      }
    }
    for (;;)
    {
      label314:
      int m = getReportIdkey();
      int n = getReportIdkey();
      i = bk.g((Integer)com.tencent.mm.plugin.report.f.a(k, new int[] { 1, 2, 3, 4 }, j + m, i + n));
      y.d(this.TAG, "%s rptFirstPlayTime [%d]", new Object[] { ayL(), Integer.valueOf(i) });
      cB(i);
      label460:
      do
      {
        return;
        if (!isLive())
        {
          y(this.rYK, this.rYJ);
          break;
        }
        play();
        break;
        if (this.rYK < 0) {}
        for (i = 0;; i = this.rYK)
        {
          y(i, this.rYJ);
          break;
        }
        if (aq.is4G(this.mContext))
        {
          j = 25;
          i = 29;
          break label314;
        }
        if (aq.is3G(this.mContext))
        {
          j = 30;
          i = 34;
          break label314;
        }
      } while (!aq.is2G(this.mContext));
      j = 35;
      i = 39;
    }
  }
  
  public final boolean lF(int paramInt)
  {
    return y(paramInt, isPlaying());
  }
  
  public final void nD(int paramInt)
  {
    this.rYD.yg(paramInt);
  }
  
  public void onError(int paramInt1, int paramInt2)
  {
    y.w(this.TAG, "%s onError info [%d %d] errorCount[%d]", new Object[] { ayL(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.aRY) });
    cB(getReportIdkey() + 90);
    this.aRY += 1;
    if (this.aRY > 5)
    {
      cB(getReportIdkey() + 92);
      this.rYU.saT = paramInt1;
      this.rYU.saU = paramInt2;
      h.b localb;
      String str2;
      String str3;
      String str1;
      if (this.oIn != null)
      {
        localb = this.oIn;
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
        bdC();
        return;
        label162:
        if (paramInt1 == -1007) {
          str1 = "MEDIA_ERR_SRC_NOT_SUPPORTED";
        } else if (paramInt1 == -1004)
        {
          if (!aq.isConnected(this.mContext)) {
            str1 = "MEDIA_ERR_NETWORK";
          } else {
            str1 = "MEDIA_ERR_DECODE";
          }
        }
        else if (!aq.isConnected(this.mContext)) {
          str1 = "MEDIA_ERR_NETWORK";
        } else {
          str1 = "MEDIA_ERR_DECODE";
        }
      }
    }
    paramInt2 = getCurrPosSec();
    if (this.rYK == -1) {}
    for (paramInt1 = paramInt2;; paramInt1 = this.rYK)
    {
      y.i(this.TAG, "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[] { ayL(), Integer.valueOf(paramInt1), Integer.valueOf(this.rYK), Integer.valueOf(paramInt2) });
      stop();
      apT();
      this.dPi.postDelayed(new AbstractVideoView.3(this, paramInt1), 200L);
      return;
    }
  }
  
  public boolean pause()
  {
    y.i(this.TAG, "%s pause", new Object[] { ayL() });
    cB(getReportIdkey() + 4);
    if (this.iuC != null)
    {
      kZ(false);
      this.iuC.pause();
      stopTimer();
      if (this.oIn != null) {
        this.oIn.bJ(getSessionId(), getMediaId());
      }
      this.rYU.oRW = bk.UY();
      return true;
    }
    return false;
  }
  
  public boolean play()
  {
    if (!this.rYz) {
      y.w(this.TAG, "%s ui on pause now, why u call me to play? [%s]", new Object[] { ayL(), bk.csb() });
    }
    do
    {
      return false;
      cB(getReportIdkey() + 3);
    } while (this.iuC == null);
    boolean bool = this.iuC.start();
    y.i(this.TAG, "%s video play [%b] isPlayOnUiPause[%b]", new Object[] { ayL(), Boolean.valueOf(bool), Boolean.valueOf(this.rYH) });
    kZ(bool);
    if (bool)
    {
      this.rYH = false;
      ce(false);
      if (this.oIn != null) {
        this.oIn.bK(getSessionId(), getMediaId());
      }
    }
    return bool;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    y.i(this.TAG, "%s set cover", new Object[] { ayL() });
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      this.kcc.setImageBitmap(paramBitmap);
    }
  }
  
  public void setFullDirection(int paramInt) {}
  
  public void setIMMVideoViewCallback(h.b paramb)
  {
    this.oIn = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    y.i(this.TAG, "%s is show seek bar[%b]", new Object[] { ayL(), Boolean.valueOf(paramBoolean) });
    this.rYE = paramBoolean;
    if (this.rYE)
    {
      this.dPi.post(new AbstractVideoView.10(this));
      return;
    }
    this.dPi.post(new AbstractVideoView.11(this));
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.iuC != null) {
      this.iuC.setMute(paramBoolean);
    }
  }
  
  public void setReporter(h.c paramc)
  {
    this.rYT = paramc;
  }
  
  public void setVideoFooterView(g paramg)
  {
    if (!(paramg instanceof View))
    {
      y.w(this.TAG, "%s set video footer view but is not view", new Object[] { ayL() });
      return;
    }
    bFF();
    this.rYD = paramg;
    this.rYF = false;
    this.rYB.addView((View)this.rYD);
  }
  
  public void stop()
  {
    y.i(this.TAG, "%s stop [%s]", new Object[] { ayL(), bk.csb() });
    cB(getReportIdkey() + 6);
    if (this.iuC != null) {
      this.iuC.stop();
    }
    this.rYK = -1;
    this.rYJ = true;
    this.PT = false;
    this.rYN = 0;
    this.rYM = 0L;
    stopTimer();
    this.dPi.postDelayed(new Runnable()
    {
      public final void run()
      {
        try
        {
          AbstractVideoView.this.nD(0);
          AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
          return;
        }
        catch (Throwable localThrowable) {}
      }
    }, 10L);
    this.rYU.saP = bk.UY();
    int j;
    int i;
    label227:
    Object localObject;
    if (this.rYU.blockCount > 0)
    {
      if (aq.isWifi(this.mContext))
      {
        j = 41;
        i = 45;
        int k = getReportIdkey();
        int m = getReportIdkey();
        i = bk.g((Integer)com.tencent.mm.plugin.report.f.a(this.rYU.blockCount, new int[] { 1, 2, 3, 4 }, j + k, i + m));
        y.d(this.TAG, "%s rptBlockCount [%d]", new Object[] { ayL(), Integer.valueOf(i) });
        cB(i);
      }
    }
    else if (this.rYU.startTimeStamp != 0L)
    {
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(this.rYU.startTimeStamp).append(",");
      ((StringBuffer)localObject).append(this.rYU.saO).append(",");
      ((StringBuffer)localObject).append(this.rYU.saP).append(",");
      ((StringBuffer)localObject).append(this.rYU.oRW).append(",");
      ((StringBuffer)localObject).append(this.rYU.saQ).append(",");
      ((StringBuffer)localObject).append(this.rYU.saR).append(",");
      ((StringBuffer)localObject).append(this.rYU.saS).append(",");
      ((StringBuffer)localObject).append(this.rYU.blockCount).append(",");
      if (this.rYU.saO <= 0L) {
        break label808;
      }
      l = this.rYU.saO - this.rYU.startTimeStamp;
      label429:
      ((StringBuffer)localObject).append(l).append(",");
      ((StringBuffer)localObject).append(this.rYU.url).append(",");
      ((StringBuffer)localObject).append(this.rYU.duration).append(",");
      ((StringBuffer)localObject).append(this.rYU.saT).append(",");
      ((StringBuffer)localObject).append(this.rYU.saU).append(",");
      ((StringBuffer)localObject).append(this.rYU.oRU).append(",");
      if (this.rYU.oRU <= this.rYU.startTimeStamp) {
        break label814;
      }
    }
    label808:
    label814:
    for (long l = this.rYU.oRU - this.rYU.startTimeStamp;; l = 0L)
    {
      ((StringBuffer)localObject).append(l).append(",");
      ((StringBuffer)localObject).append(getPlayerType()).append(",");
      ((StringBuffer)localObject).append(getVideoSource());
      localObject = ((StringBuffer)localObject).toString();
      y.i(this.TAG, "%s rpt video kv stat{%s}", new Object[] { ayL(), localObject });
      if (this.rYT != null) {
        this.rYT.qk((String)localObject);
      }
      localObject = this.rYU;
      ((k)localObject).startTimeStamp = 0L;
      ((k)localObject).saO = 0L;
      ((k)localObject).saP = 0L;
      ((k)localObject).oRW = 0L;
      ((k)localObject).saQ = 0L;
      ((k)localObject).saR = 0L;
      ((k)localObject).saS = 0L;
      ((k)localObject).blockCount = 0;
      ((k)localObject).url = "";
      ((k)localObject).duration = 0;
      ((k)localObject).saT = 0;
      ((k)localObject).saU = 0;
      ((k)localObject).oRU = 0L;
      return;
      if (aq.is4G(this.mContext))
      {
        j = 46;
        i = 50;
        break;
      }
      if (aq.is3G(this.mContext))
      {
        j = 51;
        i = 55;
        break;
      }
      if (!aq.is2G(this.mContext)) {
        break label227;
      }
      j = 56;
      i = 60;
      break;
      l = 0L;
      break label429;
    }
  }
  
  public void stopTimer()
  {
    this.rYO.stopTimer();
    this.rYP.stopTimer();
  }
  
  public void ug()
  {
    y.i(this.TAG, "%s onCompletion", new Object[] { ayL() });
    bdC();
    stopTimer();
    if (this.oIn != null) {
      this.oIn.bI(getSessionId(), getMediaId());
    }
    this.rYN = 0;
    this.rYM = 0L;
    cB(getReportIdkey() + 7);
  }
  
  public boolean y(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = isPrepared();
    int j = getVideoDurationSec();
    if ((j > 0) && (paramInt > j)) {}
    for (int i = j;; i = paramInt)
    {
      boolean bool1;
      if (this.iuC != null) {
        if (!bk.bl(this.iuC.getVideoPath())) {
          bool1 = true;
        }
      }
      for (;;)
      {
        y.l(this.TAG, "%s seek to [%d %d] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[] { ayL(), Integer.valueOf(i), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Integer.valueOf(j), Boolean.valueOf(bool1) });
        cB(getReportIdkey() + 5);
        if (!bool2) {
          break;
        }
        if (this.iuC == null) {
          break label196;
        }
        apT();
        nD(i);
        this.iuC.d(i * 1000, paramBoolean);
        return paramBoolean;
        bool1 = false;
        continue;
        bool1 = false;
      }
      this.rYK = i;
      if (bool1) {
        this.rYJ = true;
      }
      for (;;)
      {
        label196:
        return false;
        this.rYJ = paramBoolean;
        start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView
 * JD-Core Version:    0.7.0.1
 */