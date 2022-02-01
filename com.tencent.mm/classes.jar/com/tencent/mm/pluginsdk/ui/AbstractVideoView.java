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
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.pluginsdk.ui.tools.j.b;
import com.tencent.mm.pluginsdk.ui.tools.j.c;
import com.tencent.mm.pluginsdk.ui.tools.j.d;
import com.tencent.mm.pluginsdk.ui.tools.j.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class AbstractVideoView
  extends RelativeLayout
  implements i, j.a, j.b, j.c, j.d, j.e
{
  public VideoPlayerSeekBar KaT;
  protected h KaU;
  protected i.d KaV;
  private Runnable KaW = new Runnable()
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
      if (AbstractVideoView.this.pNj != null) {
        AbstractVideoView.this.pNj.dM(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      if ((AbstractVideoView.this.mEz != null) && (AbstractVideoView.this.mEz.getVisibility() != 8))
      {
        Log.i(AbstractVideoView.this.TAG, "%s hide loading", new Object[] { AbstractVideoView.this.bgQ() });
        AbstractVideoView.this.mEz.setVisibility(8);
      }
      AppMethodBeat.o(133989);
    }
  };
  private i.c KaX = null;
  protected k KaY = new k();
  public String TAG = "MicroMsg.AbstractVideoView";
  protected boolean ZA = false;
  protected int bFM = 0;
  protected MMHandler hAk = new MMHandler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(208746);
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(208746);
        return;
        AbstractVideoView.a(AbstractVideoView.this).run();
        AppMethodBeat.o(208746);
        return;
        AbstractVideoView.b(AbstractVideoView.this).run();
      }
    }
  };
  protected TextView hPF;
  private boolean isWaiting = false;
  protected Context mContext;
  protected TextView mEA;
  protected LinearLayout mEB;
  protected boolean mEF;
  protected boolean mEG = true;
  protected int mEH = 0;
  protected boolean mEI = false;
  protected int mEJ = 0;
  protected boolean mEK = true;
  protected int mEL = -1;
  protected boolean mEM = false;
  protected long mEN = 0L;
  protected int mEO = 0;
  protected MTimerHandler mEP = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(133983);
      if (!AbstractVideoView.this.isPlaying())
      {
        AppMethodBeat.o(133983);
        return false;
      }
      if (AbstractVideoView.this.mEI)
      {
        if (AbstractVideoView.this.pNj != null) {
          AbstractVideoView.this.pNj.dK(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        AbstractVideoView.this.mEI = false;
      }
      AbstractVideoView.this.xI(AbstractVideoView.this.getCurrPosSec());
      AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
      if (AbstractVideoView.this.dUD())
      {
        boolean bool = AbstractVideoView.this.gop();
        AppMethodBeat.o(133983);
        return bool;
      }
      AppMethodBeat.o(133983);
      return true;
    }
  }, true);
  protected MTimerHandler mEQ = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(133984);
      boolean bool = AbstractVideoView.this.isPlaying();
      int i = AbstractVideoView.this.getCurrPosMs();
      Log.i(AbstractVideoView.this.TAG, "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[] { AbstractVideoView.this.bgQ(), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((AbstractVideoView.this.qbJ != null) && (i <= 50)) {
        AbstractVideoView.this.qbJ.q(0.0D);
      }
      AppMethodBeat.o(133984);
      return false;
    }
  }, false);
  protected MTimerHandler mER = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(208748);
      if (AbstractVideoView.this.bFM > 0)
      {
        if (AbstractVideoView.this.isPlaying())
        {
          AbstractVideoView.c(AbstractVideoView.this);
          AppMethodBeat.o(208748);
          return false;
        }
        AppMethodBeat.o(208748);
        return true;
      }
      AppMethodBeat.o(208748);
      return false;
    }
  }, true);
  private View.OnClickListener mET = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(208750);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramAnonymousView);
      a.b("com/tencent/mm/pluginsdk/ui/AbstractVideoView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.i(AbstractVideoView.this.TAG, "%s seek bar play button on click ", new Object[] { AbstractVideoView.this.bgQ() });
      paramAnonymousView = AbstractVideoView.this;
      if (paramAnonymousView.qbJ != null)
      {
        if (!paramAnonymousView.isPlaying()) {
          break label102;
        }
        paramAnonymousView.pause();
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/pluginsdk/ui/AbstractVideoView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208750);
        return;
        label102:
        if (Util.isNullOrNil(paramAnonymousView.qbJ.getVideoPath())) {
          paramAnonymousView.start();
        } else {
          paramAnonymousView.play();
        }
      }
    }
  };
  private Runnable mEU = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(133988);
      AbstractVideoView.b(AbstractVideoView.this, true);
      if ((AbstractVideoView.this.mEz != null) && (AbstractVideoView.this.mEz.getVisibility() != 0))
      {
        Log.i(AbstractVideoView.this.TAG, "%s show loading", new Object[] { AbstractVideoView.this.bgQ() });
        AbstractVideoView.this.mEz.setVisibility(0);
      }
      if (AbstractVideoView.this.pNj != null) {
        AbstractVideoView.this.pNj.dL(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      AppMethodBeat.o(133988);
    }
  };
  protected boolean mEw = true;
  protected ImageView mEx;
  protected RelativeLayout mEy;
  protected ProgressBar mEz;
  public i.b pNj;
  public j qbJ;
  private com.tencent.mm.plugin.sight.decode.ui.b tni = flf();
  
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
  
  private void hP(boolean paramBoolean)
  {
    if (this.KaU != null) {
      this.KaU.hP(paramBoolean);
    }
  }
  
  protected void BT(long paramLong)
  {
    if ((!this.hAk.hasMessages(1)) && (!this.isWaiting)) {
      this.hAk.sendEmptyMessageDelayed(1, paramLong);
    }
  }
  
  protected final boolean asa()
  {
    boolean bool;
    if (this.qbJ != null) {
      if ((!Util.isNullOrNil(this.qbJ.getVideoPath())) && (this.ZA)) {
        bool = true;
      }
    }
    for (;;)
    {
      Log.d(this.TAG, "%s is prepared [%b] isPrepared[%b]", new Object[] { bgQ(), Boolean.valueOf(bool), Boolean.valueOf(this.ZA) });
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public void bLh()
  {
    Log.i(this.TAG, "%s onTextureUpdate ", new Object[] { bgQ() });
    hideLoading();
  }
  
  protected final void bep(String paramString)
  {
    this.KaY.url = paramString;
  }
  
  public String bgQ()
  {
    return hashCode();
  }
  
  public void bgX()
  {
    Log.i(this.TAG, "%s on surface available", new Object[] { bgQ() });
    fO(false);
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = asa();
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
    if (this.qbJ != null) {
      if (!Util.isNullOrNil(this.qbJ.getVideoPath())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      Log.printInfoStack(this.TAG, "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[] { bgQ(), Integer.valueOf(i), Double.valueOf(paramDouble), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Integer.valueOf(j), Boolean.valueOf(bool1) });
      yU(getReportIdkey() + 5);
      if (!bool2) {
        break;
      }
      if (this.qbJ == null) {
        break label215;
      }
      showLoading();
      xv(i);
      this.qbJ.d(i * 1000, paramBoolean);
      return paramBoolean;
      bool1 = false;
      continue;
      bool1 = false;
    }
    this.mEL = i;
    if (bool1) {
      this.mEK = true;
    }
    for (;;)
    {
      label215:
      return false;
      this.mEK = paramBoolean;
      start();
    }
  }
  
  protected int dEP()
  {
    return 2131493689;
  }
  
  public final void dFl()
  {
    if (this.KaU != null) {
      this.mEB.removeView((View)this.KaU);
    }
  }
  
  public boolean dUD()
  {
    return false;
  }
  
  protected j di(Context paramContext)
  {
    return null;
  }
  
  protected boolean efT()
  {
    return true;
  }
  
  public void eo(int paramInt1, int paramInt2)
  {
    Log.i(this.TAG, "%s on get video size [%d, %d]", new Object[] { bgQ(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.pNj != null) {
      this.pNj.d(getSessionId(), getMediaId(), paramInt1, paramInt2);
    }
    yU(getReportIdkey() + 8);
  }
  
  public void fN(boolean paramBoolean)
  {
    Log.i(this.TAG, "%s on seek complete startPlay[%b]", new Object[] { bgQ(), Boolean.valueOf(paramBoolean) });
    if (this.qbJ != null) {
      this.qbJ.setOneTimeVideoTextureUpdateCallback(this);
    }
    hideLoading();
    hP(paramBoolean);
    xv(getCurrPosSec());
    if (paramBoolean)
    {
      fO(false);
      this.mEI = false;
      if (this.pNj != null) {
        this.pNj.dK(getSessionId(), getMediaId());
      }
    }
  }
  
  protected void fO(boolean paramBoolean)
  {
    Log.d(this.TAG, "%s start timer rightNow[%b]", new Object[] { bgQ(), Boolean.valueOf(paramBoolean) });
    this.mEP.startTimer(500L);
  }
  
  public void fdO()
  {
    try
    {
      if (this.KaV != null) {
        this.KaV.fdO();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e(this.TAG, localThrowable.toString());
    }
  }
  
  protected final void fgB()
  {
    if (this.KaY.mvz == 0L) {
      this.KaY.mvz = Util.nowMilliSecond();
    }
  }
  
  public final int fh(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  protected com.tencent.mm.plugin.sight.decode.ui.b flf()
  {
    new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aJq() {}
      
      public final void rk(int paramAnonymousInt)
      {
        AppMethodBeat.i(208749);
        if (AbstractVideoView.this.c(paramAnonymousInt, true)) {
          AbstractVideoView.this.fO(false);
        }
        if (AbstractVideoView.this.KaT != null) {
          AbstractVideoView.this.KaT.setIsPlay(true);
        }
        AppMethodBeat.o(208749);
      }
    };
  }
  
  public int getCacheTimeSec()
  {
    return 0;
  }
  
  public int getCurrPosMs()
  {
    if (this.qbJ != null) {
      return this.qbJ.getCurrentPosition();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    if (this.qbJ != null) {
      return Math.round(this.qbJ.getCurrentPosition() * 1.0F / 1000.0F);
    }
    return 0;
  }
  
  protected String getMediaId()
  {
    return "";
  }
  
  public int getPlayerType()
  {
    return this.mEJ;
  }
  
  protected abstract int getReportIdkey();
  
  public String getSessionId()
  {
    return "";
  }
  
  public int getVideoDurationSec()
  {
    if (this.qbJ != null) {
      return Math.round(this.qbJ.getDuration() * 1.0F / 1000.0F);
    }
    return -1;
  }
  
  public int getVideoSource()
  {
    return 0;
  }
  
  protected final void goo()
  {
    this.hAk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133981);
        if ((AbstractVideoView.this.mEB != null) && (AbstractVideoView.this.mEB.getVisibility() != 8)) {
          AbstractVideoView.this.mEB.setVisibility(8);
        }
        AppMethodBeat.o(133981);
      }
    });
  }
  
  public final boolean gop()
  {
    long l = this.qbJ.getLastSurfaceUpdateTime();
    int i = this.qbJ.getCurrentPosition();
    Log.d(this.TAG, "%s check surface is update surface[%d %d] playtime[%d %d]", new Object[] { bgQ(), Long.valueOf(this.mEN), Long.valueOf(l), Integer.valueOf(this.mEO), Integer.valueOf(i) });
    if ((l > 0L) && (l == this.mEN) && (i != this.mEO))
    {
      Log.w(this.TAG, "%s check surface is update error", new Object[] { bgQ() });
      c(this.mEO / 1000, true);
      return false;
    }
    this.mEN = l;
    this.mEO = i;
    return true;
  }
  
  protected final void goq()
  {
    if (this.KaY.Eut == 0L) {
      this.KaY.Eut = Util.nowMilliSecond();
    }
  }
  
  protected final void gor()
  {
    this.KaY.KcX = Util.nowMilliSecond();
  }
  
  protected final void gos()
  {
    this.KaY.KcY = Util.nowMilliSecond();
    if (this.KaY.KcX > 0L)
    {
      k localk = this.KaY;
      localk.KcZ += this.KaY.KcY - this.KaY.KcX;
    }
  }
  
  protected final void got()
  {
    k localk = this.KaY;
    localk.blockCount += 1;
  }
  
  protected final void gou()
  {
    int k;
    int j;
    int i;
    if ((this.KaY.KcY > 0L) && (this.KaY.KcX > 0L))
    {
      k = (int)((this.KaY.KcY - this.KaY.KcX) / 1000L);
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
      i = Util.nullAsNil((Integer)e.a(k, new int[] { 1, 2, 3, 4 }, j + m, i + n));
      Log.d(this.TAG, "%s rptResumeTime [%d]", new Object[] { bgQ(), Integer.valueOf(i) });
      yU(i);
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
  
  protected void hideLoading()
  {
    this.hAk.removeMessages(1);
    this.hAk.sendEmptyMessage(2);
  }
  
  protected void initView()
  {
    Log.i(this.TAG, "%s init view ", new Object[] { bgQ() });
    LayoutInflater.from(this.mContext).inflate(dEP(), this);
    this.mEx = ((ImageView)findViewById(2131309829));
    this.mEy = ((RelativeLayout)findViewById(2131309821));
    this.hPF = ((TextView)findViewById(2131309754));
    this.mEz = ((ProgressBar)findViewById(2131309778));
    this.mEA = ((TextView)findViewById(2131309834));
    this.mEB = ((LinearLayout)findViewById(2131309767));
    Object localObject = (VideoPlayerSeekBar)findViewById(2131309804);
    this.KaT = ((VideoPlayerSeekBar)localObject);
    this.KaU = ((h)localObject);
    if (this.KaT != null)
    {
      this.KaT.setIplaySeekCallback(this.tni);
      this.KaT.setOnClickListener(this.mET);
    }
    this.qbJ = di(this.mContext);
    this.qbJ.setVideoCallback(this);
    this.qbJ.setOnSeekCompleteCallback(this);
    this.qbJ.setOnInfoCallback(this);
    this.qbJ.setOnSurfaceCallback(this);
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.mEy.addView((View)this.qbJ, 0, (ViewGroup.LayoutParams)localObject);
  }
  
  public boolean isPlaying()
  {
    if (this.qbJ != null) {}
    for (boolean bool = this.qbJ.isPlaying();; bool = false)
    {
      Log.i(this.TAG, "%s is playing[%b]", new Object[] { bgQ(), Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public void onCompletion()
  {
    Log.i(this.TAG, "%s onCompletion, curMs %d, duration %d", new Object[] { bgQ(), Integer.valueOf(getCurrPosSec()), Integer.valueOf(getVideoDurationSec()) });
    xv(getVideoDurationSec());
    hideLoading();
    stopTimer();
    if (this.pNj != null) {
      this.pNj.dI(getSessionId(), getMediaId());
    }
    this.mEO = 0;
    this.mEN = 0L;
    yU(getReportIdkey() + 7);
  }
  
  public void onError(final int paramInt1, int paramInt2)
  {
    Log.w(this.TAG, "%s onError info [%d %d] errorCount[%d]", new Object[] { bgQ(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.bFM) });
    yU(getReportIdkey() + 90);
    this.bFM += 1;
    if (this.bFM > 5)
    {
      yU(getReportIdkey() + 92);
      this.KaY.mNz = paramInt1;
      this.KaY.mNA = paramInt2;
      i.b localb;
      String str2;
      String str3;
      String str1;
      if (this.pNj != null)
      {
        localb = this.pNj;
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
    if (this.mEL == -1) {}
    for (paramInt1 = paramInt2;; paramInt1 = this.mEL)
    {
      Log.i(this.TAG, "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[] { bgQ(), Integer.valueOf(paramInt1), Integer.valueOf(this.mEL), Integer.valueOf(paramInt2) });
      stop();
      showLoading();
      this.hAk.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(208747);
          AbstractVideoView.this.mEM = true;
          AbstractVideoView.this.xI(paramInt1);
          AbstractVideoView.this.c(paramInt1, true);
          AbstractVideoView.this.mEM = false;
          AppMethodBeat.o(208747);
        }
      }, 200L);
      return;
    }
  }
  
  public void onUIDestroy()
  {
    Log.i(this.TAG, "%s onUIDestroy", new Object[] { bgQ() });
    stop();
    this.hAk.removeCallbacksAndMessages(null);
    stopTimer();
    this.mER.stopTimer();
    yU(getReportIdkey() + 12);
  }
  
  public void onUIPause()
  {
    Log.i(this.TAG, "%s onUIPause %s", new Object[] { bgQ(), Util.getStack() });
    this.mEH = getCurrPosSec();
    this.mEI = isPlaying();
    this.mEO = 0;
    this.mEN = 0L;
    pause();
    stopTimer();
    this.mEw = false;
    yU(getReportIdkey() + 11);
  }
  
  public void onUIResume()
  {
    Log.i(this.TAG, "%s onUIResume %s", new Object[] { bgQ(), Util.getStack() });
    this.mEw = true;
    yU(getReportIdkey() + 10);
  }
  
  public boolean p(double paramDouble)
  {
    return c(paramDouble, isPlaying());
  }
  
  public boolean pause()
  {
    Log.i(this.TAG, "%s pause", new Object[] { bgQ() });
    yU(getReportIdkey() + 4);
    if (this.qbJ != null)
    {
      hP(false);
      this.qbJ.pause();
      stopTimer();
      if (this.pNj != null) {
        this.pNj.dJ(getSessionId(), getMediaId());
      }
      this.KaY.Euv = Util.nowMilliSecond();
      return true;
    }
    return false;
  }
  
  public boolean play()
  {
    if (!this.mEw) {
      Log.w(this.TAG, "%s ui on pause now, why u call me to play? [%s]", new Object[] { bgQ(), Util.getStack() });
    }
    do
    {
      return false;
      yU(getReportIdkey() + 3);
    } while (this.qbJ == null);
    boolean bool = this.qbJ.start();
    Log.i(this.TAG, "%s video play [%b] isPlayOnUiPause[%b]", new Object[] { bgQ(), Boolean.valueOf(bool), Boolean.valueOf(this.mEI) });
    hP(bool);
    if (bool)
    {
      this.mEI = false;
      fO(false);
      if (this.pNj != null) {
        this.pNj.dK(getSessionId(), getMediaId());
      }
    }
    return bool;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    Log.i(this.TAG, "%s set cover", new Object[] { bgQ() });
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.mEx != null)) {
      this.mEx.setImageBitmap(paramBitmap);
    }
  }
  
  public void setFullDirection(int paramInt) {}
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    this.pNj = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    Log.i(this.TAG, "%s is show seek bar[%b]", new Object[] { bgQ(), Boolean.valueOf(paramBoolean) });
    this.mEF = paramBoolean;
    if (this.mEF)
    {
      this.hAk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133990);
          if ((AbstractVideoView.this.mEB != null) && (AbstractVideoView.this.mEB.getVisibility() != 0)) {
            AbstractVideoView.this.mEB.setVisibility(0);
          }
          AppMethodBeat.o(133990);
        }
      });
      return;
    }
    goo();
  }
  
  public void setLoopCompletionCallback(i.d paramd)
  {
    this.KaV = paramd;
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.qbJ != null) {
      this.qbJ.setMute(paramBoolean);
    }
  }
  
  public void setReporter(i.c paramc)
  {
    this.KaX = paramc;
  }
  
  public void setVideoFooterView(h paramh)
  {
    if (!(paramh instanceof View))
    {
      Log.w(this.TAG, "%s set video footer view but is not view", new Object[] { bgQ() });
      return;
    }
    dFl();
    this.KaU = paramh;
    this.mEG = false;
    this.mEB.addView((View)this.KaU);
  }
  
  protected void setVideoTotalTime(int paramInt)
  {
    if ((this.KaU != null) && (this.KaU.getVideoTotalTime() != paramInt)) {
      this.KaU.setVideoTotalTime(paramInt);
    }
  }
  
  protected void showLoading()
  {
    BT(500L);
  }
  
  public void stop()
  {
    Log.i(this.TAG, "%s stop", new Object[] { bgQ() });
    yU(getReportIdkey() + 6);
    if (this.qbJ != null) {
      this.qbJ.stop();
    }
    this.mEL = -1;
    this.mEK = true;
    this.ZA = false;
    this.mEO = 0;
    this.mEN = 0L;
    stopTimer();
    this.hAk.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133982);
        try
        {
          AbstractVideoView.this.xI(0);
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
    this.KaY.mNx = Util.nowMilliSecond();
    int j;
    int i;
    label221:
    Object localObject;
    if (this.KaY.blockCount > 0)
    {
      if (NetStatusUtil.isWifi(this.mContext))
      {
        j = 41;
        i = 45;
        int k = getReportIdkey();
        int m = getReportIdkey();
        i = Util.nullAsNil((Integer)e.a(this.KaY.blockCount, new int[] { 1, 2, 3, 4 }, j + k, i + m));
        Log.d(this.TAG, "%s rptBlockCount [%d]", new Object[] { bgQ(), Integer.valueOf(i) });
        yU(i);
      }
    }
    else if (this.KaY.mvz != 0L)
    {
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(this.KaY.mvz).append(",");
      ((StringBuffer)localObject).append(this.KaY.KcW).append(",");
      ((StringBuffer)localObject).append(this.KaY.mNx).append(",");
      ((StringBuffer)localObject).append(this.KaY.Euv).append(",");
      ((StringBuffer)localObject).append(this.KaY.KcX).append(",");
      ((StringBuffer)localObject).append(this.KaY.KcY).append(",");
      ((StringBuffer)localObject).append(this.KaY.KcZ).append(",");
      ((StringBuffer)localObject).append(this.KaY.blockCount).append(",");
      if (this.KaY.KcW <= 0L) {
        break label802;
      }
      l = this.KaY.KcW - this.KaY.mvz;
      label423:
      ((StringBuffer)localObject).append(l).append(",");
      ((StringBuffer)localObject).append(this.KaY.url).append(",");
      ((StringBuffer)localObject).append(this.KaY.duration).append(",");
      ((StringBuffer)localObject).append(this.KaY.mNz).append(",");
      ((StringBuffer)localObject).append(this.KaY.mNA).append(",");
      ((StringBuffer)localObject).append(this.KaY.Eut).append(",");
      if (this.KaY.Eut <= this.KaY.mvz) {
        break label808;
      }
    }
    label802:
    label808:
    for (long l = this.KaY.Eut - this.KaY.mvz;; l = 0L)
    {
      ((StringBuffer)localObject).append(l).append(",");
      ((StringBuffer)localObject).append(getPlayerType()).append(",");
      ((StringBuffer)localObject).append(getVideoSource());
      localObject = ((StringBuffer)localObject).toString();
      Log.i(this.TAG, "%s rpt video kv stat{%s}", new Object[] { bgQ(), localObject });
      if (this.KaX != null) {
        this.KaX.DX((String)localObject);
      }
      localObject = this.KaY;
      ((k)localObject).mvz = 0L;
      ((k)localObject).KcW = 0L;
      ((k)localObject).mNx = 0L;
      ((k)localObject).Euv = 0L;
      ((k)localObject).KcX = 0L;
      ((k)localObject).KcY = 0L;
      ((k)localObject).KcZ = 0L;
      ((k)localObject).blockCount = 0;
      ((k)localObject).url = "";
      ((k)localObject).duration = 0;
      ((k)localObject).mNz = 0;
      ((k)localObject).mNA = 0;
      ((k)localObject).Eut = 0L;
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
    this.mEP.stopTimer();
    this.mEQ.stopTimer();
  }
  
  public final void tf()
  {
    Log.i(this.TAG, "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[] { bgQ(), Boolean.valueOf(this.mEK), Integer.valueOf(this.mEL), Boolean.valueOf(this.ZA) });
    this.ZA = true;
    if (this.qbJ != null) {
      this.qbJ.setOneTimeVideoTextureUpdateCallback(this);
    }
    setVideoTotalTime(getVideoDurationSec());
    int i;
    int k;
    int j;
    if (this.mEK) {
      if (this.mEL < 0)
      {
        if ((play()) && (efT())) {
          this.mEQ.startTimer(1000L);
        }
        this.mEL = -1;
        this.mEK = true;
        this.mEO = 0;
        this.mEN = 0L;
        if (this.pNj != null) {
          this.pNj.dH(getSessionId(), getMediaId());
        }
        if (this.bFM > 0)
        {
          Log.d(this.TAG, "%s start error check timer", new Object[] { bgQ() });
          this.mER.startTimer(5000L);
        }
        yU(getReportIdkey() + 2);
        if (this.KaY.KcW == 0L) {
          this.KaY.KcW = Util.nowMilliSecond();
        }
        i = getVideoDurationSec();
        this.KaY.duration = i;
        if ((this.KaY.mvz > 0L) && (this.KaY.KcW > 0L))
        {
          k = (int)((this.KaY.KcW - this.KaY.mvz) / 1000L);
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
      i = Util.nullAsNil((Integer)e.a(k, new int[] { 1, 2, 3, 4 }, j + m, i + n));
      Log.d(this.TAG, "%s rptFirstPlayTime [%d]", new Object[] { bgQ(), Integer.valueOf(i) });
      yU(i);
      label460:
      do
      {
        return;
        if (!isLive())
        {
          c(this.mEL, this.mEK);
          break;
        }
        play();
        break;
        if (this.mEL < 0) {}
        for (double d = 0.0D;; d = this.mEL)
        {
          c(d, this.mEK);
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
  
  public final void xI(int paramInt)
  {
    xv(paramInt);
  }
  
  protected void xv(int paramInt)
  {
    if (this.KaU != null) {
      this.KaU.xv(paramInt);
    }
  }
  
  protected final void yU(long paramLong)
  {
    if (this.KaX != null) {
      this.KaX.yU(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView
 * JD-Core Version:    0.7.0.1
 */