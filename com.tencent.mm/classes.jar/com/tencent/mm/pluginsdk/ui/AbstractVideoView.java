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
import com.tencent.mm.plugin.ag.a.b;
import com.tencent.mm.plugin.ag.a.c;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.pluginsdk.ui.tools.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class AbstractVideoView
  extends RelativeLayout
  implements i, i.a, com.tencent.mm.pluginsdk.ui.tools.i.b, com.tencent.mm.pluginsdk.ui.tools.i.c, com.tencent.mm.pluginsdk.ui.tools.i.d, i.e
{
  private com.tencent.mm.plugin.sight.decode.ui.b Aqj = hsO();
  public String TAG = "MicroMsg.AbstractVideoView";
  protected String XXD = "VideoView.AbstractVideoView";
  public VideoPlayerSeekBar XXE;
  protected h XXF;
  protected i.d XXG;
  private Runnable XXH = new Runnable()
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
      if (AbstractVideoView.this.vZv != null) {
        AbstractVideoView.this.vZv.eq(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      if ((AbstractVideoView.this.sIX != null) && (AbstractVideoView.this.sIX.getVisibility() != 8))
      {
        Log.i(AbstractVideoView.this.TAG, "%s hide loading", new Object[] { AbstractVideoView.this.bNL() });
        AbstractVideoView.this.sIX.setVisibility(8);
      }
      AppMethodBeat.o(133989);
    }
  };
  private i.c XXI = null;
  protected k XXJ = new k();
  protected int diT = 0;
  protected boolean hS = false;
  private boolean isWaiting = false;
  protected Context mContext;
  protected MMHandler mRi = new MMHandler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(245055);
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(245055);
        return;
        AbstractVideoView.a(AbstractVideoView.this).run();
        AppMethodBeat.o(245055);
        return;
        AbstractVideoView.b(AbstractVideoView.this).run();
      }
    }
  };
  protected TextView nhp;
  protected boolean sIU = true;
  protected ImageView sIV;
  protected RelativeLayout sIW;
  protected ProgressBar sIX;
  protected TextView sIY;
  protected LinearLayout sIZ;
  protected boolean sJd;
  protected boolean sJe = true;
  protected int sJf = 0;
  protected boolean sJg = false;
  protected int sJh = 0;
  protected boolean sJi = true;
  protected int sJj = -1;
  protected boolean sJk = false;
  protected long sJl = 0L;
  protected int sJm = 0;
  protected MTimerHandler sJn = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(133983);
      if (!AbstractVideoView.this.isPlaying())
      {
        AppMethodBeat.o(133983);
        return false;
      }
      if (AbstractVideoView.this.sJg)
      {
        if (AbstractVideoView.this.vZv != null) {
          AbstractVideoView.this.vZv.eo(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        AbstractVideoView.this.sJg = false;
      }
      AbstractVideoView.this.Bt(AbstractVideoView.this.getCurrPosSec());
      AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
      if (AbstractVideoView.this.cxu())
      {
        boolean bool = AbstractVideoView.this.cxt();
        AppMethodBeat.o(133983);
        return bool;
      }
      AppMethodBeat.o(133983);
      return true;
    }
  }, true);
  protected MTimerHandler sJo = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(133984);
      boolean bool = AbstractVideoView.this.isPlaying();
      int i = AbstractVideoView.this.getCurrPosMs();
      Log.i(AbstractVideoView.this.TAG, "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[] { AbstractVideoView.this.bNL(), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((AbstractVideoView.this.wCd != null) && (i <= 50)) {
        AbstractVideoView.this.wCd.H(0.0D);
      }
      AppMethodBeat.o(133984);
      return false;
    }
  }, false);
  protected MTimerHandler sJp = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(245048);
      if (AbstractVideoView.this.diT > 0)
      {
        if (AbstractVideoView.this.isPlaying())
        {
          AbstractVideoView.c(AbstractVideoView.this);
          AppMethodBeat.o(245048);
          return false;
        }
        AppMethodBeat.o(245048);
        return true;
      }
      AppMethodBeat.o(245048);
      return false;
    }
  }, true);
  private View.OnClickListener sJr = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(245053);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramAnonymousView);
      a.c("com/tencent/mm/pluginsdk/ui/AbstractVideoView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      Log.i(AbstractVideoView.this.TAG, "%s seek bar play button on click ", new Object[] { AbstractVideoView.this.bNL() });
      paramAnonymousView = AbstractVideoView.this;
      if (paramAnonymousView.wCd != null)
      {
        if (!paramAnonymousView.isPlaying()) {
          break label102;
        }
        paramAnonymousView.pause();
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/pluginsdk/ui/AbstractVideoView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(245053);
        return;
        label102:
        if (Util.isNullOrNil(paramAnonymousView.wCd.getVideoPath())) {
          paramAnonymousView.start();
        } else {
          paramAnonymousView.bNU();
        }
      }
    }
  };
  private Runnable sJs = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(133988);
      AbstractVideoView.b(AbstractVideoView.this, true);
      if ((AbstractVideoView.this.sIX != null) && (AbstractVideoView.this.sIX.getVisibility() != 0))
      {
        Log.i(AbstractVideoView.this.TAG, "%s show loading", new Object[] { AbstractVideoView.this.bNL() });
        AbstractVideoView.this.sIX.setVisibility(0);
      }
      if (AbstractVideoView.this.vZv != null) {
        AbstractVideoView.this.vZv.ep(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      AppMethodBeat.o(133988);
    }
  };
  public i.b vZv;
  public com.tencent.mm.pluginsdk.ui.tools.i wCd;
  
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
  
  private void jJ(boolean paramBoolean)
  {
    if (this.XXF != null) {
      this.XXF.jJ(paramBoolean);
    }
  }
  
  protected void Bh(int paramInt)
  {
    if (this.XXF != null) {
      this.XXF.Bh(paramInt);
    }
  }
  
  public final void Bt(int paramInt)
  {
    Bh(paramInt);
  }
  
  public boolean G(double paramDouble)
  {
    return b(paramDouble, isPlaying());
  }
  
  public final void Qz()
  {
    Log.i(this.XXD, "video is onPrepared");
    Log.i(this.TAG, "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[] { bNL(), Boolean.valueOf(this.sJi), Integer.valueOf(this.sJj), Boolean.valueOf(this.hS) });
    this.hS = true;
    if (this.wCd != null) {
      this.wCd.setOneTimeVideoTextureUpdateCallback(this);
    }
    setVideoTotalTime(getVideoDurationSec());
    int i;
    int k;
    int j;
    if (this.sJi) {
      if (this.sJj < 0)
      {
        if ((bNU()) && (fXY())) {
          this.sJo.startTimer(1000L);
        }
        this.sJj = -1;
        this.sJi = true;
        this.sJm = 0;
        this.sJl = 0L;
        if (this.vZv != null) {
          this.vZv.el(getSessionId(), getMediaId());
        }
        if (this.diT > 0)
        {
          Log.d(this.TAG, "%s start error check timer", new Object[] { bNL() });
          this.sJp.startTimer(5000L);
        }
        hp(getReportIdkey() + 2);
        if (this.XXJ.XZI == 0L) {
          this.XXJ.XZI = Util.nowMilliSecond();
        }
        i = getVideoDurationSec();
        this.XXJ.duration = i;
        if ((this.XXJ.sze > 0L) && (this.XXJ.XZI > 0L))
        {
          k = (int)((this.XXJ.XZI - this.XXJ.sze) / 1000L);
          if (!NetStatusUtil.isWifi(this.mContext)) {
            break label470;
          }
          j = 20;
          i = 24;
        }
      }
    }
    for (;;)
    {
      label320:
      int m = getReportIdkey();
      int n = getReportIdkey();
      i = Util.nullAsNil((Integer)f.a(k, new int[] { 1, 2, 3, 4 }, j + m, i + n));
      Log.d(this.TAG, "%s rptFirstPlayTime [%d]", new Object[] { bNL(), Integer.valueOf(i) });
      hp(i);
      label470:
      do
      {
        return;
        if (!isLive())
        {
          b(this.sJj, this.sJi);
          break;
        }
        bNU();
        break;
        if (this.sJj < 0) {}
        for (double d = 0.0D;; d = this.sJj)
        {
          b(d, this.sJi);
          break;
        }
        if (NetStatusUtil.is4G(this.mContext))
        {
          j = 25;
          i = 29;
          break label320;
        }
        if (NetStatusUtil.is3G(this.mContext))
        {
          j = 30;
          i = 34;
          break label320;
        }
      } while (!NetStatusUtil.is2G(this.mContext));
      j = 35;
      i = 39;
    }
  }
  
  public boolean b(double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = cxs();
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
    if (this.wCd != null) {
      if (!Util.isNullOrNil(this.wCd.getVideoPath())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      Log.printInfoStack(this.TAG, "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[] { bNL(), Integer.valueOf(i), Double.valueOf(paramDouble), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Integer.valueOf(j), Boolean.valueOf(bool1) });
      hp(getReportIdkey() + 5);
      if (!bool2) {
        break;
      }
      if (this.wCd == null) {
        break label215;
      }
      showLoading();
      Bh(i);
      this.wCd.c(i * 1000, paramBoolean);
      return paramBoolean;
      bool1 = false;
      continue;
      bool1 = false;
    }
    this.sJj = i;
    if (bool1) {
      this.sJi = true;
    }
    for (;;)
    {
      label215:
      return false;
      this.sJi = paramBoolean;
      start();
    }
  }
  
  public String bNL()
  {
    return hashCode();
  }
  
  public boolean bNU()
  {
    if (!this.sIU) {
      Log.w(this.TAG, "%s ui on pause now, why u call me to play? [%s]", new Object[] { bNL(), Util.getStack() });
    }
    do
    {
      return false;
      hp(getReportIdkey() + 3);
    } while (this.wCd == null);
    boolean bool = this.wCd.start();
    Log.i(this.TAG, "%s video play [%b] isPlayOnUiPause[%b]", new Object[] { bNL(), Boolean.valueOf(bool), Boolean.valueOf(this.sJg) });
    jJ(bool);
    if (bool)
    {
      this.sJg = false;
      Log.i(this.XXD, "play, start is true");
      ho(false);
      if (this.vZv != null) {
        this.vZv.eo(getSessionId(), getMediaId());
      }
    }
    return bool;
  }
  
  public void bNV()
  {
    Log.i(this.TAG, "%s on surface available", new Object[] { bNL() });
    ho(false);
  }
  
  protected final void bqA(String paramString)
  {
    this.XXJ.url = paramString;
  }
  
  protected final boolean cxs()
  {
    boolean bool;
    if (this.wCd != null) {
      if ((!Util.isNullOrNil(this.wCd.getVideoPath())) && (this.hS)) {
        bool = true;
      }
    }
    for (;;)
    {
      Log.d(this.TAG, "%s is prepared [%b] isPrepared[%b]", new Object[] { bNL(), Boolean.valueOf(bool), Boolean.valueOf(this.hS) });
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public final boolean cxt()
  {
    long l = this.wCd.getLastSurfaceUpdateTime();
    int i = this.wCd.getCurrentPosition();
    Log.d(this.TAG, "%s check surface is update surface[%d %d] playtime[%d %d]", new Object[] { bNL(), Long.valueOf(this.sJl), Long.valueOf(l), Integer.valueOf(this.sJm), Integer.valueOf(i) });
    if ((l > 0L) && (l == this.sJl) && (i != this.sJm))
    {
      Log.w(this.TAG, "%s check surface is update error", new Object[] { bNL() });
      b(this.sJm / 1000, true);
      return false;
    }
    this.sJl = l;
    this.sJm = i;
    return true;
  }
  
  public boolean cxu()
  {
    return false;
  }
  
  protected com.tencent.mm.pluginsdk.ui.tools.i dY(Context paramContext)
  {
    return null;
  }
  
  public final void eLM()
  {
    if (this.XXF != null) {
      this.sIZ.removeView((View)this.XXF);
    }
  }
  
  protected int edi()
  {
    return a.c.comm_video_view;
  }
  
  public void fG(int paramInt1, int paramInt2)
  {
    Log.i(this.TAG, "%s on get video size [%d, %d]", new Object[] { bNL(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.vZv != null) {
      this.vZv.e(getSessionId(), getMediaId(), paramInt1, paramInt2);
    }
    hp(getReportIdkey() + 8);
  }
  
  protected boolean fXY()
  {
    return true;
  }
  
  public int getCacheTimeSec()
  {
    return 0;
  }
  
  public int getCurrPosMs()
  {
    if (this.wCd != null) {
      return this.wCd.getCurrentPosition();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    if (this.wCd != null) {
      return Math.round(this.wCd.getCurrentPosition() * 1.0F / 1000.0F);
    }
    return 0;
  }
  
  protected String getMediaId()
  {
    return "";
  }
  
  public int getPlayerType()
  {
    return this.sJh;
  }
  
  protected abstract int getReportIdkey();
  
  public String getSessionId()
  {
    return "";
  }
  
  public int getVideoDurationSec()
  {
    if (this.wCd != null) {
      return Math.round(this.wCd.getDuration() * 1.0F / 1000.0F);
    }
    return -1;
  }
  
  public int getVideoSource()
  {
    return 0;
  }
  
  protected final void grj()
  {
    this.mRi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133981);
        if ((AbstractVideoView.this.sIZ != null) && (AbstractVideoView.this.sIZ.getVisibility() != 8)) {
          AbstractVideoView.this.sIZ.setVisibility(8);
        }
        AppMethodBeat.o(133981);
      }
    });
  }
  
  public final int gw(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public void hay()
  {
    try
    {
      Bh(getVideoDurationSec());
      if (this.XXG != null) {
        this.XXG.hay();
      }
      return;
    }
    finally
    {
      Log.e(this.TAG, localObject.toString());
    }
  }
  
  protected void hideLoading()
  {
    this.mRi.removeMessages(1);
    this.mRi.sendEmptyMessage(2);
  }
  
  protected final void hmY()
  {
    if (this.XXJ.sze == 0L) {
      this.XXJ.sze = Util.nowMilliSecond();
    }
  }
  
  protected void ho(boolean paramBoolean)
  {
    Log.d(this.TAG, "%s start timer rightNow[%b]", new Object[] { bNL(), Boolean.valueOf(paramBoolean) });
    this.sJn.startTimer(500L);
  }
  
  protected final void hp(long paramLong)
  {
    if (this.XXI != null) {
      this.XXI.hp(paramLong);
    }
  }
  
  protected com.tencent.mm.plugin.sight.decode.ui.b hsO()
  {
    new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void blc() {}
      
      public final void tS(int paramAnonymousInt)
      {
        AppMethodBeat.i(245052);
        if (AbstractVideoView.this.b(paramAnonymousInt, true))
        {
          Log.i(AbstractVideoView.this.XXD, "onSeekTo, startTimer");
          AbstractVideoView.this.ho(false);
        }
        if (AbstractVideoView.this.XXE != null) {
          AbstractVideoView.this.XXE.setIsPlay(true);
        }
        AppMethodBeat.o(245052);
      }
      
      public final void tT(int paramAnonymousInt) {}
    };
  }
  
  protected final void iJV()
  {
    if (this.XXJ.RhK == 0L) {
      this.XXJ.RhK = Util.nowMilliSecond();
    }
  }
  
  protected final void iJW()
  {
    this.XXJ.XZJ = Util.nowMilliSecond();
  }
  
  protected final void iJX()
  {
    this.XXJ.XZK = Util.nowMilliSecond();
    if (this.XXJ.XZJ > 0L)
    {
      k localk = this.XXJ;
      localk.XZL += this.XXJ.XZK - this.XXJ.XZJ;
    }
  }
  
  protected final void iJY()
  {
    k localk = this.XXJ;
    localk.blockCount += 1;
  }
  
  protected final void iJZ()
  {
    int k;
    int j;
    int i;
    if ((this.XXJ.XZK > 0L) && (this.XXJ.XZJ > 0L))
    {
      k = (int)((this.XXJ.XZK - this.XXJ.XZJ) / 1000L);
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
      Log.d(this.TAG, "%s rptResumeTime [%d]", new Object[] { bNL(), Integer.valueOf(i) });
      hp(i);
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
    Log.i(this.TAG, "%s init view ", new Object[] { bNL() });
    LayoutInflater.from(this.mContext).inflate(edi(), this);
    this.sIV = ((ImageView)findViewById(a.b.video_thumb));
    this.sIW = ((RelativeLayout)findViewById(a.b.video_root));
    this.nhp = ((TextView)findViewById(a.b.video_duration));
    this.sIX = ((ProgressBar)findViewById(a.b.video_loading));
    this.sIY = ((TextView)findViewById(a.b.video_tips));
    this.sIZ = ((LinearLayout)findViewById(a.b.video_footer_root));
    Object localObject = (VideoPlayerSeekBar)findViewById(a.b.video_player_seek_bar);
    this.XXE = ((VideoPlayerSeekBar)localObject);
    this.XXF = ((h)localObject);
    if (this.XXE != null)
    {
      this.XXE.setIplaySeekCallback(this.Aqj);
      this.XXE.setOnClickListener(this.sJr);
    }
    this.wCd = dY(this.mContext);
    this.wCd.setVideoCallback(this);
    this.wCd.setOnSeekCompleteCallback(this);
    this.wCd.setOnInfoCallback(this);
    this.wCd.setOnSurfaceCallback(this);
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.sIW.addView((View)this.wCd, 0, (ViewGroup.LayoutParams)localObject);
  }
  
  public boolean isPlaying()
  {
    if (this.wCd != null) {}
    for (boolean bool = this.wCd.isPlaying();; bool = false)
    {
      Log.i(this.TAG, "%s is playing[%b]", new Object[] { bNL(), Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  protected void ku(long paramLong)
  {
    if ((!this.mRi.hasMessages(1)) && (!this.isWaiting)) {
      this.mRi.sendEmptyMessageDelayed(1, paramLong);
    }
  }
  
  public void onCompletion()
  {
    Log.i(this.TAG, "%s onCompletion, curMs %d, duration %d", new Object[] { bNL(), Integer.valueOf(getCurrPosSec()), Integer.valueOf(getVideoDurationSec()) });
    Bh(getVideoDurationSec());
    hideLoading();
    stopTimer();
    if (this.vZv != null) {
      this.vZv.em(getSessionId(), getMediaId());
    }
    this.sJm = 0;
    this.sJl = 0L;
    hp(getReportIdkey() + 7);
  }
  
  public void onError(final int paramInt1, int paramInt2)
  {
    Log.w(this.TAG, "%s onError info [%d %d] errorCount[%d]", new Object[] { bNL(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.diT) });
    hp(getReportIdkey() + 90);
    this.diT += 1;
    if (this.diT > 5)
    {
      hp(getReportIdkey() + 92);
      this.XXJ.sSQ = paramInt1;
      this.XXJ.sSR = paramInt2;
      i.b localb;
      String str2;
      String str3;
      String str1;
      if (this.vZv != null)
      {
        localb = this.vZv;
        str2 = getSessionId();
        str3 = getMediaId();
        if (paramInt1 != -1010) {
          break label162;
        }
        str1 = "MEDIA_ERR_SRC_NOT_SUPPORTED";
      }
      for (;;)
      {
        localb.d(str2, str3, str1, paramInt1, paramInt2);
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
    if (this.sJj == -1) {}
    for (paramInt1 = paramInt2;; paramInt1 = this.sJj)
    {
      Log.i(this.TAG, "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[] { bNL(), Integer.valueOf(paramInt1), Integer.valueOf(this.sJj), Integer.valueOf(paramInt2) });
      stop();
      showLoading();
      this.mRi.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(245057);
          AbstractVideoView.this.sJk = true;
          AbstractVideoView.this.Bt(paramInt1);
          AbstractVideoView.this.b(paramInt1, true);
          AbstractVideoView.this.sJk = false;
          AppMethodBeat.o(245057);
        }
      }, 200L);
      return;
    }
  }
  
  public void onSeekComplete(boolean paramBoolean)
  {
    Log.i(this.TAG, "%s on seek complete startPlay[%b]", new Object[] { bNL(), Boolean.valueOf(paramBoolean) });
    if (this.wCd != null) {
      this.wCd.setOneTimeVideoTextureUpdateCallback(this);
    }
    hideLoading();
    jJ(paramBoolean);
    Bh(getCurrPosSec());
    if (paramBoolean)
    {
      Log.i(this.XXD, "onSeekComplete, startTimer, startPlay is true");
      ho(false);
      this.sJg = false;
      if (this.vZv != null) {
        this.vZv.eo(getSessionId(), getMediaId());
      }
    }
  }
  
  public void onTextureUpdate()
  {
    Log.i(this.TAG, "%s onTextureUpdate ", new Object[] { bNL() });
    hideLoading();
  }
  
  public void onUIDestroy()
  {
    Log.i(this.TAG, "%s onUIDestroy", new Object[] { bNL() });
    stop();
    this.mRi.removeCallbacksAndMessages(null);
    stopTimer();
    this.sJp.stopTimer();
    hp(getReportIdkey() + 12);
  }
  
  public void onUIPause()
  {
    Log.i(this.TAG, "%s onUIPause %s", new Object[] { bNL(), Util.getStack() });
    this.sJf = getCurrPosSec();
    this.sJg = isPlaying();
    this.sJm = 0;
    this.sJl = 0L;
    pause();
    stopTimer();
    this.sIU = false;
    hp(getReportIdkey() + 11);
  }
  
  public void onUIResume()
  {
    Log.i(this.TAG, "%s onUIResume %s", new Object[] { bNL(), Util.getStack() });
    this.sIU = true;
    hp(getReportIdkey() + 10);
  }
  
  public boolean pause()
  {
    Log.i(this.TAG, "%s pause", new Object[] { bNL() });
    hp(getReportIdkey() + 4);
    if (this.wCd != null)
    {
      jJ(false);
      this.wCd.pause();
      stopTimer();
      if (this.vZv != null) {
        this.vZv.en(getSessionId(), getMediaId());
      }
      this.XXJ.RhM = Util.nowMilliSecond();
      return true;
    }
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    Log.i(this.TAG, "%s set cover", new Object[] { bNL() });
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.sIV != null)) {
      this.sIV.setImageBitmap(paramBitmap);
    }
  }
  
  public void setFullDirection(int paramInt) {}
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    this.vZv = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    Log.i(this.TAG, "%s is show seek bar[%b]", new Object[] { bNL(), Boolean.valueOf(paramBoolean) });
    this.sJd = paramBoolean;
    if (this.sJd)
    {
      this.mRi.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133990);
          if ((AbstractVideoView.this.sIZ != null) && (AbstractVideoView.this.sIZ.getVisibility() != 0)) {
            AbstractVideoView.this.sIZ.setVisibility(0);
          }
          AppMethodBeat.o(133990);
        }
      });
      return;
    }
    grj();
  }
  
  public void setLoopCompletionCallback(i.d paramd)
  {
    this.XXG = paramd;
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.wCd != null) {
      this.wCd.setMute(paramBoolean);
    }
  }
  
  public void setReporter(i.c paramc)
  {
    this.XXI = paramc;
  }
  
  public void setVideoFooterView(h paramh)
  {
    if (!(paramh instanceof View))
    {
      Log.w(this.TAG, "%s set video footer view but is not view", new Object[] { bNL() });
      return;
    }
    eLM();
    this.XXF = paramh;
    this.sJe = false;
    this.sIZ.addView((View)this.XXF);
  }
  
  protected void setVideoTotalTime(int paramInt)
  {
    if ((this.XXF != null) && (this.XXF.getVideoTotalTime() != paramInt)) {
      this.XXF.setVideoTotalTime(paramInt);
    }
  }
  
  protected void showLoading()
  {
    ku(500L);
  }
  
  public void stop()
  {
    Log.i(this.TAG, "%s stop", new Object[] { bNL() });
    hp(getReportIdkey() + 6);
    if (this.wCd != null) {
      this.wCd.stop();
    }
    this.sJj = -1;
    this.sJi = true;
    this.hS = false;
    this.sJm = 0;
    this.sJl = 0L;
    stopTimer();
    this.mRi.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133982);
        try
        {
          AbstractVideoView.this.Bt(0);
          AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
          return;
        }
        finally
        {
          AppMethodBeat.o(133982);
        }
      }
    }, 10L);
    this.XXJ.sSO = Util.nowMilliSecond();
    int j;
    int i;
    label221:
    Object localObject;
    if (this.XXJ.blockCount > 0)
    {
      if (NetStatusUtil.isWifi(this.mContext))
      {
        j = 41;
        i = 45;
        int k = getReportIdkey();
        int m = getReportIdkey();
        i = Util.nullAsNil((Integer)f.a(this.XXJ.blockCount, new int[] { 1, 2, 3, 4 }, j + k, i + m));
        Log.d(this.TAG, "%s rptBlockCount [%d]", new Object[] { bNL(), Integer.valueOf(i) });
        hp(i);
      }
    }
    else if (this.XXJ.sze != 0L)
    {
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(this.XXJ.sze).append(",");
      ((StringBuffer)localObject).append(this.XXJ.XZI).append(",");
      ((StringBuffer)localObject).append(this.XXJ.sSO).append(",");
      ((StringBuffer)localObject).append(this.XXJ.RhM).append(",");
      ((StringBuffer)localObject).append(this.XXJ.XZJ).append(",");
      ((StringBuffer)localObject).append(this.XXJ.XZK).append(",");
      ((StringBuffer)localObject).append(this.XXJ.XZL).append(",");
      ((StringBuffer)localObject).append(this.XXJ.blockCount).append(",");
      if (this.XXJ.XZI <= 0L) {
        break label802;
      }
      l = this.XXJ.XZI - this.XXJ.sze;
      label423:
      ((StringBuffer)localObject).append(l).append(",");
      ((StringBuffer)localObject).append(this.XXJ.url).append(",");
      ((StringBuffer)localObject).append(this.XXJ.duration).append(",");
      ((StringBuffer)localObject).append(this.XXJ.sSQ).append(",");
      ((StringBuffer)localObject).append(this.XXJ.sSR).append(",");
      ((StringBuffer)localObject).append(this.XXJ.RhK).append(",");
      if (this.XXJ.RhK <= this.XXJ.sze) {
        break label808;
      }
    }
    label802:
    label808:
    for (long l = this.XXJ.RhK - this.XXJ.sze;; l = 0L)
    {
      ((StringBuffer)localObject).append(l).append(",");
      ((StringBuffer)localObject).append(getPlayerType()).append(",");
      ((StringBuffer)localObject).append(getVideoSource());
      localObject = ((StringBuffer)localObject).toString();
      Log.i(this.TAG, "%s rpt video kv stat{%s}", new Object[] { bNL(), localObject });
      if (this.XXI != null) {
        this.XXI.Du((String)localObject);
      }
      localObject = this.XXJ;
      ((k)localObject).sze = 0L;
      ((k)localObject).XZI = 0L;
      ((k)localObject).sSO = 0L;
      ((k)localObject).RhM = 0L;
      ((k)localObject).XZJ = 0L;
      ((k)localObject).XZK = 0L;
      ((k)localObject).XZL = 0L;
      ((k)localObject).blockCount = 0;
      ((k)localObject).url = "";
      ((k)localObject).duration = 0;
      ((k)localObject).sSQ = 0;
      ((k)localObject).sSR = 0;
      ((k)localObject).RhK = 0L;
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
    this.sJn.stopTimer();
    this.sJo.stopTimer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView
 * JD-Core Version:    0.7.0.1
 */