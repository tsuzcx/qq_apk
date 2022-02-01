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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;

public abstract class AbstractVideoView
  extends RelativeLayout
  implements i, h.a, h.b, h.c, h.d, h.e
{
  public VideoPlayerSeekBar ERG;
  protected h ERH;
  protected i.d ERI;
  private Runnable ERJ = new Runnable()
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
      if (AbstractVideoView.this.osZ != null) {
        AbstractVideoView.this.osZ.dv(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      if ((AbstractVideoView.this.ltc != null) && (AbstractVideoView.this.ltc.getVisibility() != 8))
      {
        ad.i(AbstractVideoView.this.TAG, "%s hide loading", new Object[] { AbstractVideoView.this.boQ() });
        AbstractVideoView.this.ltc.setVisibility(8);
      }
      AppMethodBeat.o(133989);
    }
  };
  private i.c ERK = null;
  protected k ERL = new k();
  public String TAG = "MicroMsg.AbstractVideoView";
  protected boolean Zn = false;
  protected int bFv = 0;
  protected ap gIf = new ap(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(197031);
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(197031);
        return;
        AbstractVideoView.a(AbstractVideoView.this).run();
        AppMethodBeat.o(197031);
        return;
        AbstractVideoView.b(AbstractVideoView.this).run();
      }
    }
  };
  protected TextView gUc;
  private boolean isWaiting = false;
  protected boolean lsZ = true;
  protected ImageView lta;
  protected RelativeLayout ltb;
  protected ProgressBar ltc;
  protected TextView ltd;
  protected LinearLayout lte;
  protected boolean lti;
  protected boolean ltj = true;
  protected int ltk = 0;
  protected boolean ltl = false;
  protected int ltm = 0;
  protected boolean ltn = true;
  protected int lto = -1;
  protected boolean ltp = false;
  protected long ltq = 0L;
  protected int ltr = 0;
  protected av lts = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(133983);
      if (!AbstractVideoView.this.isPlaying())
      {
        AppMethodBeat.o(133983);
        return false;
      }
      if (AbstractVideoView.this.ltl)
      {
        if (AbstractVideoView.this.osZ != null) {
          AbstractVideoView.this.osZ.dt(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        AbstractVideoView.this.ltl = false;
      }
      AbstractVideoView.this.tF(AbstractVideoView.this.getCurrPosSec());
      AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
      if (AbstractVideoView.this.cYm())
      {
        boolean bool = AbstractVideoView.this.fbr();
        AppMethodBeat.o(133983);
        return bool;
      }
      AppMethodBeat.o(133983);
      return true;
    }
  }, true);
  protected av ltt = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(133984);
      boolean bool = AbstractVideoView.this.isPlaying();
      int i = AbstractVideoView.this.getCurrPosMs();
      ad.i(AbstractVideoView.this.TAG, "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[] { AbstractVideoView.this.boQ(), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((AbstractVideoView.this.oHt != null) && (i <= 50)) {
        AbstractVideoView.this.oHt.p(0.0D);
      }
      AppMethodBeat.o(133984);
      return false;
    }
  }, false);
  protected av ltu = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(197033);
      if (AbstractVideoView.this.bFv > 0)
      {
        if (AbstractVideoView.this.isPlaying())
        {
          AbstractVideoView.c(AbstractVideoView.this);
          AppMethodBeat.o(197033);
          return false;
        }
        AppMethodBeat.o(197033);
        return true;
      }
      AppMethodBeat.o(197033);
      return false;
    }
  }, true);
  private View.OnClickListener ltw = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(197035);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramAnonymousView);
      a.b("com/tencent/mm/pluginsdk/ui/AbstractVideoView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ad.i(AbstractVideoView.this.TAG, "%s seek bar play button on click ", new Object[] { AbstractVideoView.this.boQ() });
      paramAnonymousView = AbstractVideoView.this;
      if (paramAnonymousView.oHt != null)
      {
        if (!paramAnonymousView.isPlaying()) {
          break label102;
        }
        paramAnonymousView.pause();
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/pluginsdk/ui/AbstractVideoView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(197035);
        return;
        label102:
        if (bt.isNullOrNil(paramAnonymousView.oHt.getVideoPath())) {
          paramAnonymousView.start();
        } else {
          paramAnonymousView.play();
        }
      }
    }
  };
  private Runnable ltx = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(133988);
      AbstractVideoView.b(AbstractVideoView.this, true);
      if ((AbstractVideoView.this.ltc != null) && (AbstractVideoView.this.ltc.getVisibility() != 0))
      {
        ad.i(AbstractVideoView.this.TAG, "%s show loading", new Object[] { AbstractVideoView.this.boQ() });
        AbstractVideoView.this.ltc.setVisibility(0);
      }
      if (AbstractVideoView.this.osZ != null) {
        AbstractVideoView.this.osZ.du(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      AppMethodBeat.o(133988);
    }
  };
  protected Context mContext;
  public com.tencent.mm.pluginsdk.ui.tools.h oHt;
  public i.b osZ;
  private com.tencent.mm.plugin.sight.decode.ui.b rFm = eeY();
  
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
    if (this.ERH != null) {
      this.ERH.gS(paramBoolean);
    }
  }
  
  protected final void aMr(String paramString)
  {
    this.ERL.url = paramString;
  }
  
  public void aMx()
  {
    ad.i(this.TAG, "%s on surface available", new Object[] { boQ() });
    eV(false);
  }
  
  public String boQ()
  {
    return hashCode();
  }
  
  protected final boolean boS()
  {
    boolean bool;
    if (this.oHt != null) {
      if ((!bt.isNullOrNil(this.oHt.getVideoPath())) && (this.Zn)) {
        bool = true;
      }
    }
    for (;;)
    {
      ad.d(this.TAG, "%s is prepared [%b] isPrepared[%b]", new Object[] { boQ(), Boolean.valueOf(bool), Boolean.valueOf(this.Zn) });
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public void boT()
  {
    ad.i(this.TAG, "%s onTextureUpdate ", new Object[] { boQ() });
    hideLoading();
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = boS();
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
    if (this.oHt != null) {
      if (!bt.isNullOrNil(this.oHt.getVideoPath())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      ad.m(this.TAG, "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[] { boQ(), Integer.valueOf(i), Double.valueOf(paramDouble), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Integer.valueOf(j), Boolean.valueOf(bool1) });
      qQ(getReportIdkey() + 5);
      if (!bool2) {
        break;
      }
      if (this.oHt == null) {
        break label215;
      }
      showLoading();
      tt(i);
      this.oHt.d(i * 1000, paramBoolean);
      return paramBoolean;
      bool1 = false;
      continue;
      bool1 = false;
    }
    this.lto = i;
    if (bool1) {
      this.ltn = true;
    }
    for (;;)
    {
      label215:
      return false;
      this.ltn = paramBoolean;
      start();
    }
  }
  
  protected com.tencent.mm.pluginsdk.ui.tools.h cL(Context paramContext)
  {
    return null;
  }
  
  protected int cLU()
  {
    return 2131493573;
  }
  
  public final void cMk()
  {
    if (this.ERH != null) {
      this.lte.removeView((View)this.ERH);
    }
  }
  
  public boolean cYm()
  {
    return false;
  }
  
  public void dXu()
  {
    try
    {
      if (this.ERI != null) {
        this.ERI.dXu();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e(this.TAG, localThrowable.toString());
    }
  }
  
  protected boolean diZ()
  {
    return true;
  }
  
  public final int eT(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public void eU(boolean paramBoolean)
  {
    ad.i(this.TAG, "%s on seek complete startPlay[%b]", new Object[] { boQ(), Boolean.valueOf(paramBoolean) });
    if (this.oHt != null) {
      this.oHt.setOneTimeVideoTextureUpdateCallback(this);
    }
    hideLoading();
    gS(paramBoolean);
    tt(getCurrPosSec());
    if (paramBoolean)
    {
      eV(false);
      this.ltl = false;
      if (this.osZ != null) {
        this.osZ.dt(getSessionId(), getMediaId());
      }
    }
  }
  
  protected void eV(boolean paramBoolean)
  {
    ad.d(this.TAG, "%s start timer rightNow[%b]", new Object[] { boQ(), Boolean.valueOf(paramBoolean) });
    this.lts.az(500L, 500L);
  }
  
  protected final void eaE()
  {
    if (this.ERL.lkv == 0L) {
      this.ERL.lkv = bt.flT();
    }
  }
  
  public void eb(int paramInt1, int paramInt2)
  {
    ad.i(this.TAG, "%s on get video size [%d, %d]", new Object[] { boQ(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.osZ != null) {
      this.osZ.d(getSessionId(), getMediaId(), paramInt1, paramInt2);
    }
    qQ(getReportIdkey() + 8);
  }
  
  protected com.tencent.mm.plugin.sight.decode.ui.b eeY()
  {
    new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aqD() {}
      
      public final void nM(int paramAnonymousInt)
      {
        AppMethodBeat.i(197034);
        if (AbstractVideoView.this.c(paramAnonymousInt, true)) {
          AbstractVideoView.this.eV(false);
        }
        if (AbstractVideoView.this.ERG != null) {
          AbstractVideoView.this.ERG.setIsPlay(true);
        }
        AppMethodBeat.o(197034);
      }
    };
  }
  
  protected final void fbq()
  {
    this.gIf.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133981);
        if ((AbstractVideoView.this.lte != null) && (AbstractVideoView.this.lte.getVisibility() != 8)) {
          AbstractVideoView.this.lte.setVisibility(8);
        }
        AppMethodBeat.o(133981);
      }
    });
  }
  
  public final boolean fbr()
  {
    long l = this.oHt.getLastSurfaceUpdateTime();
    int i = this.oHt.getCurrentPosition();
    ad.d(this.TAG, "%s check surface is update surface[%d %d] playtime[%d %d]", new Object[] { boQ(), Long.valueOf(this.ltq), Long.valueOf(l), Integer.valueOf(this.ltr), Integer.valueOf(i) });
    if ((l > 0L) && (l == this.ltq) && (i != this.ltr))
    {
      ad.w(this.TAG, "%s check surface is update error", new Object[] { boQ() });
      c(this.ltr / 1000, true);
      return false;
    }
    this.ltq = l;
    this.ltr = i;
    return true;
  }
  
  protected final void fbs()
  {
    if (this.ERL.zUz == 0L) {
      this.ERL.zUz = bt.flT();
    }
  }
  
  protected final void fbt()
  {
    this.ERL.ETK = bt.flT();
  }
  
  protected final void fbu()
  {
    this.ERL.ETL = bt.flT();
    if (this.ERL.ETK > 0L)
    {
      k localk = this.ERL;
      localk.ETM += this.ERL.ETL - this.ERL.ETK;
    }
  }
  
  protected final void fbv()
  {
    k localk = this.ERL;
    localk.blockCount += 1;
  }
  
  protected final void fbw()
  {
    int k;
    int j;
    int i;
    if ((this.ERL.ETL > 0L) && (this.ERL.ETK > 0L))
    {
      k = (int)((this.ERL.ETL - this.ERL.ETK) / 1000L);
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
      i = bt.n((Integer)e.a(k, new int[] { 1, 2, 3, 4 }, j + m, i + n));
      ad.d(this.TAG, "%s rptResumeTime [%d]", new Object[] { boQ(), Integer.valueOf(i) });
      qQ(i);
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
  
  public int getCacheTimeSec()
  {
    return 0;
  }
  
  public int getCurrPosMs()
  {
    if (this.oHt != null) {
      return this.oHt.getCurrentPosition();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    if (this.oHt != null) {
      return Math.round(this.oHt.getCurrentPosition() * 1.0F / 1000.0F);
    }
    return 0;
  }
  
  protected String getMediaId()
  {
    return "";
  }
  
  public int getPlayerType()
  {
    return this.ltm;
  }
  
  protected abstract int getReportIdkey();
  
  public String getSessionId()
  {
    return "";
  }
  
  public int getVideoDurationSec()
  {
    if (this.oHt != null) {
      return Math.round(this.oHt.getDuration() * 1.0F / 1000.0F);
    }
    return -1;
  }
  
  public int getVideoSource()
  {
    return 0;
  }
  
  protected void hideLoading()
  {
    this.gIf.removeMessages(1);
    this.gIf.sendEmptyMessage(2);
  }
  
  protected void initView()
  {
    ad.i(this.TAG, "%s init view ", new Object[] { boQ() });
    LayoutInflater.from(this.mContext).inflate(cLU(), this);
    this.lta = ((ImageView)findViewById(2131306398));
    this.ltb = ((RelativeLayout)findViewById(2131306392));
    this.gUc = ((TextView)findViewById(2131306332));
    this.ltc = ((ProgressBar)findViewById(2131306352));
    this.ltd = ((TextView)findViewById(2131306403));
    this.lte = ((LinearLayout)findViewById(2131306342));
    Object localObject = (VideoPlayerSeekBar)findViewById(2131306375);
    this.ERG = ((VideoPlayerSeekBar)localObject);
    this.ERH = ((h)localObject);
    if (this.ERG != null)
    {
      this.ERG.setIplaySeekCallback(this.rFm);
      this.ERG.setOnClickListener(this.ltw);
    }
    this.oHt = cL(this.mContext);
    this.oHt.setVideoCallback(this);
    this.oHt.setOnSeekCompleteCallback(this);
    this.oHt.setOnInfoCallback(this);
    this.oHt.setOnSurfaceCallback(this);
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.ltb.addView((View)this.oHt, 0, (ViewGroup.LayoutParams)localObject);
  }
  
  public boolean isPlaying()
  {
    if (this.oHt != null) {}
    for (boolean bool = this.oHt.isPlaying();; bool = false)
    {
      ad.i(this.TAG, "%s is playing[%b]", new Object[] { boQ(), Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public boolean o(double paramDouble)
  {
    return c(paramDouble, isPlaying());
  }
  
  public void onCompletion()
  {
    ad.i(this.TAG, "%s onCompletion, curMs %d, duration %d", new Object[] { boQ(), Integer.valueOf(getCurrPosSec()), Integer.valueOf(getVideoDurationSec()) });
    tt(getVideoDurationSec());
    hideLoading();
    stopTimer();
    if (this.osZ != null) {
      this.osZ.dr(getSessionId(), getMediaId());
    }
    this.ltr = 0;
    this.ltq = 0L;
    qQ(getReportIdkey() + 7);
  }
  
  public void onError(final int paramInt1, int paramInt2)
  {
    ad.w(this.TAG, "%s onError info [%d %d] errorCount[%d]", new Object[] { boQ(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.bFv) });
    qQ(getReportIdkey() + 90);
    this.bFv += 1;
    if (this.bFv > 5)
    {
      qQ(getReportIdkey() + 92);
      this.ERL.lBr = paramInt1;
      this.ERL.lBs = paramInt2;
      i.b localb;
      String str2;
      String str3;
      String str1;
      if (this.osZ != null)
      {
        localb = this.osZ;
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
    if (this.lto == -1) {}
    for (paramInt1 = paramInt2;; paramInt1 = this.lto)
    {
      ad.i(this.TAG, "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[] { boQ(), Integer.valueOf(paramInt1), Integer.valueOf(this.lto), Integer.valueOf(paramInt2) });
      stop();
      showLoading();
      this.gIf.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197032);
          AbstractVideoView.this.ltp = true;
          AbstractVideoView.this.tF(paramInt1);
          AbstractVideoView.this.c(paramInt1, true);
          AbstractVideoView.this.ltp = false;
          AppMethodBeat.o(197032);
        }
      }, 200L);
      return;
    }
  }
  
  public void onUIDestroy()
  {
    ad.i(this.TAG, "%s onUIDestroy", new Object[] { boQ() });
    stop();
    this.gIf.removeCallbacksAndMessages(null);
    stopTimer();
    this.ltu.stopTimer();
    qQ(getReportIdkey() + 12);
  }
  
  public void onUIPause()
  {
    ad.i(this.TAG, "%s onUIPause %s", new Object[] { boQ(), bt.flS() });
    this.ltk = getCurrPosSec();
    this.ltl = isPlaying();
    this.ltr = 0;
    this.ltq = 0L;
    pause();
    stopTimer();
    this.lsZ = false;
    qQ(getReportIdkey() + 11);
  }
  
  public void onUIResume()
  {
    ad.i(this.TAG, "%s onUIResume %s", new Object[] { boQ(), bt.flS() });
    this.lsZ = true;
    qQ(getReportIdkey() + 10);
  }
  
  public boolean pause()
  {
    ad.i(this.TAG, "%s pause", new Object[] { boQ() });
    qQ(getReportIdkey() + 4);
    if (this.oHt != null)
    {
      gS(false);
      this.oHt.pause();
      stopTimer();
      if (this.osZ != null) {
        this.osZ.ds(getSessionId(), getMediaId());
      }
      this.ERL.zUB = bt.flT();
      return true;
    }
    return false;
  }
  
  public boolean play()
  {
    if (!this.lsZ) {
      ad.w(this.TAG, "%s ui on pause now, why u call me to play? [%s]", new Object[] { boQ(), bt.flS() });
    }
    do
    {
      return false;
      qQ(getReportIdkey() + 3);
    } while (this.oHt == null);
    boolean bool = this.oHt.start();
    ad.i(this.TAG, "%s video play [%b] isPlayOnUiPause[%b]", new Object[] { boQ(), Boolean.valueOf(bool), Boolean.valueOf(this.ltl) });
    gS(bool);
    if (bool)
    {
      this.ltl = false;
      eV(false);
      if (this.osZ != null) {
        this.osZ.dt(getSessionId(), getMediaId());
      }
    }
    return bool;
  }
  
  protected final void qQ(long paramLong)
  {
    if (this.ERK != null) {
      this.ERK.qQ(paramLong);
    }
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    ad.i(this.TAG, "%s set cover", new Object[] { boQ() });
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.lta != null)) {
      this.lta.setImageBitmap(paramBitmap);
    }
  }
  
  public void setFullDirection(int paramInt) {}
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    this.osZ = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    ad.i(this.TAG, "%s is show seek bar[%b]", new Object[] { boQ(), Boolean.valueOf(paramBoolean) });
    this.lti = paramBoolean;
    if (this.lti)
    {
      this.gIf.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133990);
          if ((AbstractVideoView.this.lte != null) && (AbstractVideoView.this.lte.getVisibility() != 0)) {
            AbstractVideoView.this.lte.setVisibility(0);
          }
          AppMethodBeat.o(133990);
        }
      });
      return;
    }
    fbq();
  }
  
  public void setLoopCompletionCallback(i.d paramd)
  {
    this.ERI = paramd;
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.oHt != null) {
      this.oHt.setMute(paramBoolean);
    }
  }
  
  public void setReporter(i.c paramc)
  {
    this.ERK = paramc;
  }
  
  public void setVideoFooterView(h paramh)
  {
    if (!(paramh instanceof View))
    {
      ad.w(this.TAG, "%s set video footer view but is not view", new Object[] { boQ() });
      return;
    }
    cMk();
    this.ERH = paramh;
    this.ltj = false;
    this.lte.addView((View)this.ERH);
  }
  
  protected void setVideoTotalTime(int paramInt)
  {
    if ((this.ERH != null) && (this.ERH.getVideoTotalTime() != paramInt)) {
      this.ERH.setVideoTotalTime(paramInt);
    }
  }
  
  protected void showLoading()
  {
    tx(500L);
  }
  
  public void stop()
  {
    ad.i(this.TAG, "%s stop", new Object[] { boQ() });
    qQ(getReportIdkey() + 6);
    if (this.oHt != null) {
      this.oHt.stop();
    }
    this.lto = -1;
    this.ltn = true;
    this.Zn = false;
    this.ltr = 0;
    this.ltq = 0L;
    stopTimer();
    this.gIf.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133982);
        try
        {
          AbstractVideoView.this.tF(0);
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
    this.ERL.lBp = bt.flT();
    int j;
    int i;
    label221:
    Object localObject;
    if (this.ERL.blockCount > 0)
    {
      if (ay.isWifi(this.mContext))
      {
        j = 41;
        i = 45;
        int k = getReportIdkey();
        int m = getReportIdkey();
        i = bt.n((Integer)e.a(this.ERL.blockCount, new int[] { 1, 2, 3, 4 }, j + k, i + m));
        ad.d(this.TAG, "%s rptBlockCount [%d]", new Object[] { boQ(), Integer.valueOf(i) });
        qQ(i);
      }
    }
    else if (this.ERL.lkv != 0L)
    {
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(this.ERL.lkv).append(",");
      ((StringBuffer)localObject).append(this.ERL.ETJ).append(",");
      ((StringBuffer)localObject).append(this.ERL.lBp).append(",");
      ((StringBuffer)localObject).append(this.ERL.zUB).append(",");
      ((StringBuffer)localObject).append(this.ERL.ETK).append(",");
      ((StringBuffer)localObject).append(this.ERL.ETL).append(",");
      ((StringBuffer)localObject).append(this.ERL.ETM).append(",");
      ((StringBuffer)localObject).append(this.ERL.blockCount).append(",");
      if (this.ERL.ETJ <= 0L) {
        break label802;
      }
      l = this.ERL.ETJ - this.ERL.lkv;
      label423:
      ((StringBuffer)localObject).append(l).append(",");
      ((StringBuffer)localObject).append(this.ERL.url).append(",");
      ((StringBuffer)localObject).append(this.ERL.duration).append(",");
      ((StringBuffer)localObject).append(this.ERL.lBr).append(",");
      ((StringBuffer)localObject).append(this.ERL.lBs).append(",");
      ((StringBuffer)localObject).append(this.ERL.zUz).append(",");
      if (this.ERL.zUz <= this.ERL.lkv) {
        break label808;
      }
    }
    label802:
    label808:
    for (long l = this.ERL.zUz - this.ERL.lkv;; l = 0L)
    {
      ((StringBuffer)localObject).append(l).append(",");
      ((StringBuffer)localObject).append(getPlayerType()).append(",");
      ((StringBuffer)localObject).append(getVideoSource());
      localObject = ((StringBuffer)localObject).toString();
      ad.i(this.TAG, "%s rpt video kv stat{%s}", new Object[] { boQ(), localObject });
      if (this.ERK != null) {
        this.ERK.vk((String)localObject);
      }
      localObject = this.ERL;
      ((k)localObject).lkv = 0L;
      ((k)localObject).ETJ = 0L;
      ((k)localObject).lBp = 0L;
      ((k)localObject).zUB = 0L;
      ((k)localObject).ETK = 0L;
      ((k)localObject).ETL = 0L;
      ((k)localObject).ETM = 0L;
      ((k)localObject).blockCount = 0;
      ((k)localObject).url = "";
      ((k)localObject).duration = 0;
      ((k)localObject).lBr = 0;
      ((k)localObject).lBs = 0;
      ((k)localObject).zUz = 0L;
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
    this.lts.stopTimer();
    this.ltt.stopTimer();
  }
  
  public final void tF(int paramInt)
  {
    tt(paramInt);
  }
  
  public final void ta()
  {
    ad.i(this.TAG, "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[] { boQ(), Boolean.valueOf(this.ltn), Integer.valueOf(this.lto), Boolean.valueOf(this.Zn) });
    this.Zn = true;
    if (this.oHt != null) {
      this.oHt.setOneTimeVideoTextureUpdateCallback(this);
    }
    setVideoTotalTime(getVideoDurationSec());
    int i;
    int k;
    int j;
    if (this.ltn) {
      if (this.lto < 0)
      {
        if ((play()) && (diZ())) {
          this.ltt.az(1000L, 1000L);
        }
        this.lto = -1;
        this.ltn = true;
        this.ltr = 0;
        this.ltq = 0L;
        if (this.osZ != null) {
          this.osZ.dq(getSessionId(), getMediaId());
        }
        if (this.bFv > 0)
        {
          ad.d(this.TAG, "%s start error check timer", new Object[] { boQ() });
          this.ltu.az(5000L, 5000L);
        }
        qQ(getReportIdkey() + 2);
        if (this.ERL.ETJ == 0L) {
          this.ERL.ETJ = bt.flT();
        }
        i = getVideoDurationSec();
        this.ERL.duration = i;
        if ((this.ERL.lkv > 0L) && (this.ERL.ETJ > 0L))
        {
          k = (int)((this.ERL.ETJ - this.ERL.lkv) / 1000L);
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
      i = bt.n((Integer)e.a(k, new int[] { 1, 2, 3, 4 }, j + m, i + n));
      ad.d(this.TAG, "%s rptFirstPlayTime [%d]", new Object[] { boQ(), Integer.valueOf(i) });
      qQ(i);
      label466:
      do
      {
        return;
        if (!bhH())
        {
          c(this.lto, this.ltn);
          break;
        }
        play();
        break;
        if (this.lto < 0) {}
        for (double d = 0.0D;; d = this.lto)
        {
          c(d, this.ltn);
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
  
  protected void tt(int paramInt)
  {
    if (this.ERH != null) {
      this.ERH.tt(paramInt);
    }
  }
  
  protected void tx(long paramLong)
  {
    if ((!this.gIf.hasMessages(1)) && (!this.isWaiting)) {
      this.gIf.sendEmptyMessageDelayed(1, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView
 * JD-Core Version:    0.7.0.1
 */