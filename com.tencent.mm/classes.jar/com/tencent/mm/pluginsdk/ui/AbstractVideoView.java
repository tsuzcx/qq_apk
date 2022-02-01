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
import com.tencent.mm.plugin.af.a.b;
import com.tencent.mm.plugin.af.a.c;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.pluginsdk.ui.tools.k.b;
import com.tencent.mm.pluginsdk.ui.tools.k.c;
import com.tencent.mm.pluginsdk.ui.tools.k.d;
import com.tencent.mm.pluginsdk.ui.tools.k.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class AbstractVideoView
  extends RelativeLayout
  implements i, k.a, k.b, k.c, k.d, k.e
{
  private Runnable RbA = new Runnable()
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
      if (AbstractVideoView.this.sUh != null) {
        AbstractVideoView.this.sUh.dX(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      if ((AbstractVideoView.this.pDL != null) && (AbstractVideoView.this.pDL.getVisibility() != 8))
      {
        Log.i(AbstractVideoView.this.TAG, "%s hide loading", new Object[] { AbstractVideoView.this.bqf() });
        AbstractVideoView.this.pDL.setVisibility(8);
      }
      AppMethodBeat.o(133989);
    }
  };
  private i.c RbB = null;
  protected k RbC = new k();
  public VideoPlayerSeekBar Rbx;
  protected h Rby;
  protected i.d Rbz;
  public String TAG = "MicroMsg.AbstractVideoView";
  protected int bpq = 0;
  protected boolean gX = false;
  private boolean isWaiting = false;
  protected TextView kEb;
  protected MMHandler knk = new MMHandler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(205123);
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(205123);
        return;
        AbstractVideoView.a(AbstractVideoView.this).run();
        AppMethodBeat.o(205123);
        return;
        AbstractVideoView.b(AbstractVideoView.this).run();
      }
    }
  };
  protected Context mContext;
  protected boolean pDI = true;
  protected ImageView pDJ;
  protected RelativeLayout pDK;
  protected ProgressBar pDL;
  protected TextView pDM;
  protected LinearLayout pDN;
  protected boolean pDR;
  protected boolean pDS = true;
  protected int pDT = 0;
  protected boolean pDU = false;
  protected int pDV = 0;
  protected boolean pDW = true;
  protected int pDX = -1;
  protected boolean pDY = false;
  protected long pDZ = 0L;
  protected int pEa = 0;
  protected MTimerHandler pEb = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(133983);
      if (!AbstractVideoView.this.isPlaying())
      {
        AppMethodBeat.o(133983);
        return false;
      }
      if (AbstractVideoView.this.pDU)
      {
        if (AbstractVideoView.this.sUh != null) {
          AbstractVideoView.this.sUh.dV(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        AbstractVideoView.this.pDU = false;
      }
      AbstractVideoView.this.Bg(AbstractVideoView.this.getCurrPosSec());
      AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
      if (AbstractVideoView.this.exK())
      {
        boolean bool = AbstractVideoView.this.hiZ();
        AppMethodBeat.o(133983);
        return bool;
      }
      AppMethodBeat.o(133983);
      return true;
    }
  }, true);
  protected MTimerHandler pEc = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(133984);
      boolean bool = AbstractVideoView.this.isPlaying();
      int i = AbstractVideoView.this.getCurrPosMs();
      Log.i(AbstractVideoView.this.TAG, "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[] { AbstractVideoView.this.bqf(), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((AbstractVideoView.this.txH != null) && (i <= 50)) {
        AbstractVideoView.this.txH.q(0.0D);
      }
      AppMethodBeat.o(133984);
      return false;
    }
  }, false);
  protected MTimerHandler pEd = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(204849);
      if (AbstractVideoView.this.bpq > 0)
      {
        if (AbstractVideoView.this.isPlaying())
        {
          AbstractVideoView.c(AbstractVideoView.this);
          AppMethodBeat.o(204849);
          return false;
        }
        AppMethodBeat.o(204849);
        return true;
      }
      AppMethodBeat.o(204849);
      return false;
    }
  }, true);
  private View.OnClickListener pEf = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(204763);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramAnonymousView);
      a.c("com/tencent/mm/pluginsdk/ui/AbstractVideoView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      Log.i(AbstractVideoView.this.TAG, "%s seek bar play button on click ", new Object[] { AbstractVideoView.this.bqf() });
      paramAnonymousView = AbstractVideoView.this;
      if (paramAnonymousView.txH != null)
      {
        if (!paramAnonymousView.isPlaying()) {
          break label102;
        }
        paramAnonymousView.pause();
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/pluginsdk/ui/AbstractVideoView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204763);
        return;
        label102:
        if (Util.isNullOrNil(paramAnonymousView.txH.getVideoPath())) {
          paramAnonymousView.start();
        } else {
          paramAnonymousView.bqo();
        }
      }
    }
  };
  private Runnable pEg = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(133988);
      AbstractVideoView.b(AbstractVideoView.this, true);
      if ((AbstractVideoView.this.pDL != null) && (AbstractVideoView.this.pDL.getVisibility() != 0))
      {
        Log.i(AbstractVideoView.this.TAG, "%s show loading", new Object[] { AbstractVideoView.this.bqf() });
        AbstractVideoView.this.pDL.setVisibility(0);
      }
      if (AbstractVideoView.this.sUh != null) {
        AbstractVideoView.this.sUh.dW(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      AppMethodBeat.o(133988);
    }
  };
  public i.b sUh;
  public com.tencent.mm.pluginsdk.ui.tools.k txH;
  private com.tencent.mm.plugin.sight.decode.ui.b wTG = fZy();
  
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
  
  private void iF(boolean paramBoolean)
  {
    if (this.Rby != null) {
      this.Rby.iF(paramBoolean);
    }
  }
  
  protected void AS(int paramInt)
  {
    if (this.Rby != null) {
      this.Rby.AS(paramInt);
    }
  }
  
  public final void Bg(int paramInt)
  {
    AS(paramInt);
  }
  
  protected final void EW(long paramLong)
  {
    if (this.RbB != null) {
      this.RbB.EW(paramLong);
    }
  }
  
  protected void Ic(long paramLong)
  {
    if ((!this.knk.hasMessages(1)) && (!this.isWaiting)) {
      this.knk.sendEmptyMessageDelayed(1, paramLong);
    }
  }
  
  public boolean a(double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = ayN();
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
    if (this.txH != null) {
      if (!Util.isNullOrNil(this.txH.getVideoPath())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      Log.printInfoStack(this.TAG, "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[] { bqf(), Integer.valueOf(i), Double.valueOf(paramDouble), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Integer.valueOf(j), Boolean.valueOf(bool1) });
      EW(getReportIdkey() + 5);
      if (!bool2) {
        break;
      }
      if (this.txH == null) {
        break label215;
      }
      showLoading();
      AS(i);
      this.txH.b(i * 1000, paramBoolean);
      return paramBoolean;
      bool1 = false;
      continue;
      bool1 = false;
    }
    this.pDX = i;
    if (bool1) {
      this.pDW = true;
    }
    for (;;)
    {
      label215:
      return false;
      this.pDW = paramBoolean;
      start();
    }
  }
  
  protected final boolean ayN()
  {
    boolean bool;
    if (this.txH != null) {
      if ((!Util.isNullOrNil(this.txH.getVideoPath())) && (this.gX)) {
        bool = true;
      }
    }
    for (;;)
    {
      Log.d(this.TAG, "%s is prepared [%b] isPrepared[%b]", new Object[] { bqf(), Boolean.valueOf(bool), Boolean.valueOf(this.gX) });
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public void bXh()
  {
    Log.i(this.TAG, "%s onTextureUpdate ", new Object[] { bqf() });
    hideLoading();
  }
  
  protected final void bqL(String paramString)
  {
    this.RbC.url = paramString;
  }
  
  public String bqf()
  {
    return hashCode();
  }
  
  public boolean bqo()
  {
    if (!this.pDI) {
      Log.w(this.TAG, "%s ui on pause now, why u call me to play? [%s]", new Object[] { bqf(), Util.getStack() });
    }
    do
    {
      return false;
      EW(getReportIdkey() + 3);
    } while (this.txH == null);
    boolean bool = this.txH.start();
    Log.i(this.TAG, "%s video play [%b] isPlayOnUiPause[%b]", new Object[] { bqf(), Boolean.valueOf(bool), Boolean.valueOf(this.pDU) });
    iF(bool);
    if (bool)
    {
      this.pDU = false;
      gA(false);
      if (this.sUh != null) {
        this.sUh.dV(getSessionId(), getMediaId());
      }
    }
    return bool;
  }
  
  public void bqp()
  {
    Log.i(this.TAG, "%s on surface available", new Object[] { bqf() });
    gA(false);
  }
  
  protected com.tencent.mm.pluginsdk.ui.tools.k df(Context paramContext)
  {
    return null;
  }
  
  public void eM(int paramInt1, int paramInt2)
  {
    Log.i(this.TAG, "%s on get video size [%d, %d]", new Object[] { bqf(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.sUh != null) {
      this.sUh.d(getSessionId(), getMediaId(), paramInt1, paramInt2);
    }
    EW(getReportIdkey() + 8);
  }
  
  protected boolean ePu()
  {
    return true;
  }
  
  public final void egX()
  {
    if (this.Rby != null) {
      this.pDN.removeView((View)this.Rby);
    }
  }
  
  protected int egy()
  {
    return a.c.comm_video_view;
  }
  
  public boolean exK()
  {
    return false;
  }
  
  public final int fE(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public void fKt()
  {
    try
    {
      AS(getVideoDurationSec());
      if (this.Rbz != null) {
        this.Rbz.fKt();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e(this.TAG, localThrowable.toString());
    }
  }
  
  protected final void fUH()
  {
    if (this.RbC.ptY == 0L) {
      this.RbC.ptY = Util.nowMilliSecond();
    }
  }
  
  protected com.tencent.mm.plugin.sight.decode.ui.b fZy()
  {
    new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aRo() {}
      
      public final void tY(int paramAnonymousInt)
      {
        AppMethodBeat.i(204927);
        if (AbstractVideoView.this.a(paramAnonymousInt, true)) {
          AbstractVideoView.this.gA(false);
        }
        if (AbstractVideoView.this.Rbx != null) {
          AbstractVideoView.this.Rbx.setIsPlay(true);
        }
        AppMethodBeat.o(204927);
      }
    };
  }
  
  protected final void fhw()
  {
    this.knk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133981);
        if ((AbstractVideoView.this.pDN != null) && (AbstractVideoView.this.pDN.getVisibility() != 8)) {
          AbstractVideoView.this.pDN.setVisibility(8);
        }
        AppMethodBeat.o(133981);
      }
    });
  }
  
  protected void gA(boolean paramBoolean)
  {
    Log.d(this.TAG, "%s start timer rightNow[%b]", new Object[] { bqf(), Boolean.valueOf(paramBoolean) });
    this.pEb.startTimer(500L);
  }
  
  public int getCacheTimeSec()
  {
    return 0;
  }
  
  public int getCurrPosMs()
  {
    if (this.txH != null) {
      return this.txH.getCurrentPosition();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    if (this.txH != null) {
      return Math.round(this.txH.getCurrentPosition() * 1.0F / 1000.0F);
    }
    return 0;
  }
  
  protected String getMediaId()
  {
    return "";
  }
  
  public int getPlayerType()
  {
    return this.pDV;
  }
  
  protected abstract int getReportIdkey();
  
  public String getSessionId()
  {
    return "";
  }
  
  public int getVideoDurationSec()
  {
    if (this.txH != null) {
      return Math.round(this.txH.getDuration() * 1.0F / 1000.0F);
    }
    return -1;
  }
  
  public int getVideoSource()
  {
    return 0;
  }
  
  public void gz(boolean paramBoolean)
  {
    Log.i(this.TAG, "%s on seek complete startPlay[%b]", new Object[] { bqf(), Boolean.valueOf(paramBoolean) });
    if (this.txH != null) {
      this.txH.setOneTimeVideoTextureUpdateCallback(this);
    }
    hideLoading();
    iF(paramBoolean);
    AS(getCurrPosSec());
    if (paramBoolean)
    {
      gA(false);
      this.pDU = false;
      if (this.sUh != null) {
        this.sUh.dV(getSessionId(), getMediaId());
      }
    }
  }
  
  public final boolean hiZ()
  {
    long l = this.txH.getLastSurfaceUpdateTime();
    int i = this.txH.getCurrentPosition();
    Log.d(this.TAG, "%s check surface is update surface[%d %d] playtime[%d %d]", new Object[] { bqf(), Long.valueOf(this.pDZ), Long.valueOf(l), Integer.valueOf(this.pEa), Integer.valueOf(i) });
    if ((l > 0L) && (l == this.pDZ) && (i != this.pEa))
    {
      Log.w(this.TAG, "%s check surface is update error", new Object[] { bqf() });
      a(this.pEa / 1000, true);
      return false;
    }
    this.pDZ = l;
    this.pEa = i;
    return true;
  }
  
  protected void hideLoading()
  {
    this.knk.removeMessages(1);
    this.knk.sendEmptyMessage(2);
  }
  
  protected final void hja()
  {
    if (this.RbC.KIk == 0L) {
      this.RbC.KIk = Util.nowMilliSecond();
    }
  }
  
  protected final void hjb()
  {
    this.RbC.RdD = Util.nowMilliSecond();
  }
  
  protected final void hjc()
  {
    this.RbC.RdE = Util.nowMilliSecond();
    if (this.RbC.RdD > 0L)
    {
      k localk = this.RbC;
      localk.RdF += this.RbC.RdE - this.RbC.RdD;
    }
  }
  
  protected final void hjd()
  {
    k localk = this.RbC;
    localk.blockCount += 1;
  }
  
  protected final void hje()
  {
    int k;
    int j;
    int i;
    if ((this.RbC.RdE > 0L) && (this.RbC.RdD > 0L))
    {
      k = (int)((this.RbC.RdE - this.RbC.RdD) / 1000L);
      if (!NetStatusUtil.isWifi(this.mContext)) {
        break label146;
      }
      j = 70;
      i = 74;
    }
    for (;;)
    {
      int m = getReportIdkey();
      int n = getReportIdkey();
      i = Util.nullAsNil((Integer)f.a(k, new int[] { 1, 2, 3, 4 }, j + m, i + n));
      Log.d(this.TAG, "%s rptResumeTime [%d]", new Object[] { bqf(), Integer.valueOf(i) });
      EW(i);
      label146:
      do
      {
        return;
        if (NetStatusUtil.is4G(this.mContext))
        {
          j = 75;
          i = 79;
          break;
        }
        if (NetStatusUtil.is3G(this.mContext))
        {
          j = 80;
          i = 84;
          break;
        }
      } while (!NetStatusUtil.is2G(this.mContext));
      j = 85;
      i = 89;
    }
  }
  
  protected void initView()
  {
    Log.i(this.TAG, "%s init view ", new Object[] { bqf() });
    LayoutInflater.from(this.mContext).inflate(egy(), this);
    this.pDJ = ((ImageView)findViewById(a.b.video_thumb));
    this.pDK = ((RelativeLayout)findViewById(a.b.video_root));
    this.kEb = ((TextView)findViewById(a.b.video_duration));
    this.pDL = ((ProgressBar)findViewById(a.b.video_loading));
    this.pDM = ((TextView)findViewById(a.b.video_tips));
    this.pDN = ((LinearLayout)findViewById(a.b.video_footer_root));
    Object localObject = (VideoPlayerSeekBar)findViewById(a.b.video_player_seek_bar);
    this.Rbx = ((VideoPlayerSeekBar)localObject);
    this.Rby = ((h)localObject);
    if (this.Rbx != null)
    {
      this.Rbx.setIplaySeekCallback(this.wTG);
      this.Rbx.setOnClickListener(this.pEf);
    }
    this.txH = df(this.mContext);
    this.txH.setVideoCallback(this);
    this.txH.setOnSeekCompleteCallback(this);
    this.txH.setOnInfoCallback(this);
    this.txH.setOnSurfaceCallback(this);
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.pDK.addView((View)this.txH, 0, (ViewGroup.LayoutParams)localObject);
  }
  
  public boolean isPlaying()
  {
    if (this.txH != null) {}
    for (boolean bool = this.txH.isPlaying();; bool = false)
    {
      Log.i(this.TAG, "%s is playing[%b]", new Object[] { bqf(), Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public void onCompletion()
  {
    Log.i(this.TAG, "%s onCompletion, curMs %d, duration %d", new Object[] { bqf(), Integer.valueOf(getCurrPosSec()), Integer.valueOf(getVideoDurationSec()) });
    AS(getVideoDurationSec());
    hideLoading();
    stopTimer();
    if (this.sUh != null) {
      this.sUh.dT(getSessionId(), getMediaId());
    }
    this.pEa = 0;
    this.pDZ = 0L;
    EW(getReportIdkey() + 7);
  }
  
  public void onError(final int paramInt1, int paramInt2)
  {
    Log.w(this.TAG, "%s onError info [%d %d] errorCount[%d]", new Object[] { bqf(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.bpq) });
    EW(getReportIdkey() + 90);
    this.bpq += 1;
    if (this.bpq > 5)
    {
      EW(getReportIdkey() + 92);
      this.RbC.pOs = paramInt1;
      this.RbC.pOt = paramInt2;
      i.b localb;
      String str2;
      String str3;
      String str1;
      if (this.sUh != null)
      {
        localb = this.sUh;
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
          if (!NetStatusUtil.isConnected(this.mContext)) {
            str1 = "MEDIA_ERR_NETWORK";
          } else {
            str1 = "MEDIA_ERR_DECODE";
          }
        }
        else if (!NetStatusUtil.isConnected(this.mContext)) {
          str1 = "MEDIA_ERR_NETWORK";
        } else {
          str1 = "MEDIA_ERR_DECODE";
        }
      }
    }
    paramInt2 = getCurrPosSec();
    if (this.pDX == -1) {}
    for (paramInt1 = paramInt2;; paramInt1 = this.pDX)
    {
      Log.i(this.TAG, "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[] { bqf(), Integer.valueOf(paramInt1), Integer.valueOf(this.pDX), Integer.valueOf(paramInt2) });
      stop();
      showLoading();
      this.knk.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205182);
          AbstractVideoView.this.pDY = true;
          AbstractVideoView.this.Bg(paramInt1);
          AbstractVideoView.this.a(paramInt1, true);
          AbstractVideoView.this.pDY = false;
          AppMethodBeat.o(205182);
        }
      }, 200L);
      return;
    }
  }
  
  public void onUIDestroy()
  {
    Log.i(this.TAG, "%s onUIDestroy", new Object[] { bqf() });
    stop();
    this.knk.removeCallbacksAndMessages(null);
    stopTimer();
    this.pEd.stopTimer();
    EW(getReportIdkey() + 12);
  }
  
  public void onUIPause()
  {
    Log.i(this.TAG, "%s onUIPause %s", new Object[] { bqf(), Util.getStack() });
    this.pDT = getCurrPosSec();
    this.pDU = isPlaying();
    this.pEa = 0;
    this.pDZ = 0L;
    pause();
    stopTimer();
    this.pDI = false;
    EW(getReportIdkey() + 11);
  }
  
  public void onUIResume()
  {
    Log.i(this.TAG, "%s onUIResume %s", new Object[] { bqf(), Util.getStack() });
    this.pDI = true;
    EW(getReportIdkey() + 10);
  }
  
  public boolean p(double paramDouble)
  {
    return a(paramDouble, isPlaying());
  }
  
  public boolean pause()
  {
    Log.i(this.TAG, "%s pause", new Object[] { bqf() });
    EW(getReportIdkey() + 4);
    if (this.txH != null)
    {
      iF(false);
      this.txH.pause();
      stopTimer();
      if (this.sUh != null) {
        this.sUh.dU(getSessionId(), getMediaId());
      }
      this.RbC.KIm = Util.nowMilliSecond();
      return true;
    }
    return false;
  }
  
  public final void qX()
  {
    Log.i(this.TAG, "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[] { bqf(), Boolean.valueOf(this.pDW), Integer.valueOf(this.pDX), Boolean.valueOf(this.gX) });
    this.gX = true;
    if (this.txH != null) {
      this.txH.setOneTimeVideoTextureUpdateCallback(this);
    }
    setVideoTotalTime(getVideoDurationSec());
    int i;
    int k;
    int j;
    if (this.pDW) {
      if (this.pDX < 0)
      {
        if ((bqo()) && (ePu())) {
          this.pEc.startTimer(1000L);
        }
        this.pDX = -1;
        this.pDW = true;
        this.pEa = 0;
        this.pDZ = 0L;
        if (this.sUh != null) {
          this.sUh.dS(getSessionId(), getMediaId());
        }
        if (this.bpq > 0)
        {
          Log.d(this.TAG, "%s start error check timer", new Object[] { bqf() });
          this.pEd.startTimer(5000L);
        }
        EW(getReportIdkey() + 2);
        if (this.RbC.RdC == 0L) {
          this.RbC.RdC = Util.nowMilliSecond();
        }
        i = getVideoDurationSec();
        this.RbC.duration = i;
        if ((this.RbC.ptY > 0L) && (this.RbC.RdC > 0L))
        {
          k = (int)((this.RbC.RdC - this.RbC.ptY) / 1000L);
          if (!NetStatusUtil.isWifi(this.mContext)) {
            break label460;
          }
          j = 20;
          i = 24;
        }
      }
    }
    for (;;)
    {
      label310:
      int m = getReportIdkey();
      int n = getReportIdkey();
      i = Util.nullAsNil((Integer)f.a(k, new int[] { 1, 2, 3, 4 }, j + m, i + n));
      Log.d(this.TAG, "%s rptFirstPlayTime [%d]", new Object[] { bqf(), Integer.valueOf(i) });
      EW(i);
      label460:
      do
      {
        return;
        if (!isLive())
        {
          a(this.pDX, this.pDW);
          break;
        }
        bqo();
        break;
        if (this.pDX < 0) {}
        for (double d = 0.0D;; d = this.pDX)
        {
          a(d, this.pDW);
          break;
        }
        if (NetStatusUtil.is4G(this.mContext))
        {
          j = 25;
          i = 29;
          break label310;
        }
        if (NetStatusUtil.is3G(this.mContext))
        {
          j = 30;
          i = 34;
          break label310;
        }
      } while (!NetStatusUtil.is2G(this.mContext));
      j = 35;
      i = 39;
    }
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    Log.i(this.TAG, "%s set cover", new Object[] { bqf() });
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.pDJ != null)) {
      this.pDJ.setImageBitmap(paramBitmap);
    }
  }
  
  public void setFullDirection(int paramInt) {}
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    this.sUh = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    Log.i(this.TAG, "%s is show seek bar[%b]", new Object[] { bqf(), Boolean.valueOf(paramBoolean) });
    this.pDR = paramBoolean;
    if (this.pDR)
    {
      this.knk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133990);
          if ((AbstractVideoView.this.pDN != null) && (AbstractVideoView.this.pDN.getVisibility() != 0)) {
            AbstractVideoView.this.pDN.setVisibility(0);
          }
          AppMethodBeat.o(133990);
        }
      });
      return;
    }
    fhw();
  }
  
  public void setLoopCompletionCallback(i.d paramd)
  {
    this.Rbz = paramd;
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.txH != null) {
      this.txH.setMute(paramBoolean);
    }
  }
  
  public void setReporter(i.c paramc)
  {
    this.RbB = paramc;
  }
  
  public void setVideoFooterView(h paramh)
  {
    if (!(paramh instanceof View))
    {
      Log.w(this.TAG, "%s set video footer view but is not view", new Object[] { bqf() });
      return;
    }
    egX();
    this.Rby = paramh;
    this.pDS = false;
    this.pDN.addView((View)this.Rby);
  }
  
  protected void setVideoTotalTime(int paramInt)
  {
    if ((this.Rby != null) && (this.Rby.getVideoTotalTime() != paramInt)) {
      this.Rby.setVideoTotalTime(paramInt);
    }
  }
  
  protected void showLoading()
  {
    Ic(500L);
  }
  
  public void stop()
  {
    Log.i(this.TAG, "%s stop", new Object[] { bqf() });
    EW(getReportIdkey() + 6);
    if (this.txH != null) {
      this.txH.stop();
    }
    this.pDX = -1;
    this.pDW = true;
    this.gX = false;
    this.pEa = 0;
    this.pDZ = 0L;
    stopTimer();
    this.knk.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133982);
        try
        {
          AbstractVideoView.this.Bg(0);
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
    this.RbC.pOq = Util.nowMilliSecond();
    int j;
    int i;
    label221:
    Object localObject;
    if (this.RbC.blockCount > 0)
    {
      if (NetStatusUtil.isWifi(this.mContext))
      {
        j = 41;
        i = 45;
        int k = getReportIdkey();
        int m = getReportIdkey();
        i = Util.nullAsNil((Integer)f.a(this.RbC.blockCount, new int[] { 1, 2, 3, 4 }, j + k, i + m));
        Log.d(this.TAG, "%s rptBlockCount [%d]", new Object[] { bqf(), Integer.valueOf(i) });
        EW(i);
      }
    }
    else if (this.RbC.ptY != 0L)
    {
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(this.RbC.ptY).append(",");
      ((StringBuffer)localObject).append(this.RbC.RdC).append(",");
      ((StringBuffer)localObject).append(this.RbC.pOq).append(",");
      ((StringBuffer)localObject).append(this.RbC.KIm).append(",");
      ((StringBuffer)localObject).append(this.RbC.RdD).append(",");
      ((StringBuffer)localObject).append(this.RbC.RdE).append(",");
      ((StringBuffer)localObject).append(this.RbC.RdF).append(",");
      ((StringBuffer)localObject).append(this.RbC.blockCount).append(",");
      if (this.RbC.RdC <= 0L) {
        break label802;
      }
      l = this.RbC.RdC - this.RbC.ptY;
      label423:
      ((StringBuffer)localObject).append(l).append(",");
      ((StringBuffer)localObject).append(this.RbC.url).append(",");
      ((StringBuffer)localObject).append(this.RbC.duration).append(",");
      ((StringBuffer)localObject).append(this.RbC.pOs).append(",");
      ((StringBuffer)localObject).append(this.RbC.pOt).append(",");
      ((StringBuffer)localObject).append(this.RbC.KIk).append(",");
      if (this.RbC.KIk <= this.RbC.ptY) {
        break label808;
      }
    }
    label802:
    label808:
    for (long l = this.RbC.KIk - this.RbC.ptY;; l = 0L)
    {
      ((StringBuffer)localObject).append(l).append(",");
      ((StringBuffer)localObject).append(getPlayerType()).append(",");
      ((StringBuffer)localObject).append(getVideoSource());
      localObject = ((StringBuffer)localObject).toString();
      Log.i(this.TAG, "%s rpt video kv stat{%s}", new Object[] { bqf(), localObject });
      if (this.RbB != null) {
        this.RbB.KP((String)localObject);
      }
      localObject = this.RbC;
      ((k)localObject).ptY = 0L;
      ((k)localObject).RdC = 0L;
      ((k)localObject).pOq = 0L;
      ((k)localObject).KIm = 0L;
      ((k)localObject).RdD = 0L;
      ((k)localObject).RdE = 0L;
      ((k)localObject).RdF = 0L;
      ((k)localObject).blockCount = 0;
      ((k)localObject).url = "";
      ((k)localObject).duration = 0;
      ((k)localObject).pOs = 0;
      ((k)localObject).pOt = 0;
      ((k)localObject).KIk = 0L;
      return;
      if (NetStatusUtil.is4G(this.mContext))
      {
        j = 46;
        i = 50;
        break;
      }
      if (NetStatusUtil.is3G(this.mContext))
      {
        j = 51;
        i = 55;
        break;
      }
      if (!NetStatusUtil.is2G(this.mContext)) {
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
    this.pEb.stopTimer();
    this.pEc.stopTimer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView
 * JD-Core Version:    0.7.0.1
 */