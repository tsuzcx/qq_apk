package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;

public class OfflineVideoView
  extends RelativeLayout
  implements h.a
{
  private int bxy;
  private int duration;
  private boolean fqj;
  private ProgressBar kuP;
  private Context mContext;
  private h nAZ;
  private av nBf;
  private ap nzT;
  private RelativeLayout qiM;
  protected ImageView qir;
  protected boolean qmn;
  private boolean qmo;
  private h.e xpA;
  private a xpv;
  private boolean xpw;
  protected boolean xpx;
  private int xpy;
  private int xpz;
  
  public OfflineVideoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OfflineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OfflineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98021);
    this.mContext = null;
    this.fqj = false;
    this.qmn = false;
    this.xpw = false;
    this.xpx = true;
    this.xpy = -1;
    this.bxy = 0;
    this.duration = 0;
    this.nzT = new ap(Looper.getMainLooper());
    this.xpz = 1000;
    this.nBf = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(98019);
        if (OfflineVideoView.a(OfflineVideoView.this) == null)
        {
          AppMethodBeat.o(98019);
          return false;
        }
        if (((View)OfflineVideoView.a(OfflineVideoView.this)).getAlpha() < 1.0F) {
          OfflineVideoView.this.b(true, 1.0F);
        }
        if (OfflineVideoView.a(OfflineVideoView.this).isPlaying())
        {
          OfflineVideoView.d(OfflineVideoView.this);
          OfflineVideoView.this.Nl(OfflineVideoView.a(OfflineVideoView.this).getCurrentPosition());
        }
        AppMethodBeat.o(98019);
        return true;
      }
    }, true);
    this.xpA = new h.e()
    {
      public final void beo()
      {
        AppMethodBeat.i(98020);
        ad.i("MicroMsg.OfflineVideoView", "%d on texture update.", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()) });
        try
        {
          OfflineVideoView.this.b(true, 1.0F);
          AppMethodBeat.o(98020);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.OfflineVideoView", "texture view update. error " + localException.toString());
          AppMethodBeat.o(98020);
        }
      }
    };
    this.mContext = paramContext;
    ad.i("MicroMsg.OfflineVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(this.mContext).inflate(2131495624, this);
    this.qir = ((ImageView)findViewById(2131306398));
    this.qiM = ((RelativeLayout)findViewById(2131306392));
    this.kuP = ((ProgressBar)findViewById(2131306352));
    if (d.lg(18))
    {
      paramInt = 0;
      if (paramInt == 0) {
        break label277;
      }
      this.qmo = true;
    }
    for (this.nAZ = new VideoPlayerTextureView(this.mContext);; this.nAZ = new VideoTextureView(this.mContext))
    {
      this.nAZ.setVideoCallback(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      this.qiM.addView((View)this.nAZ, paramContext);
      b(false, 0.0F);
      AppMethodBeat.o(98021);
      return;
      paramInt = 1;
      break;
      label277:
      this.qmo = false;
    }
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(98030);
    this.nzT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98018);
        if ((OfflineVideoView.c(OfflineVideoView.this) != null) && (OfflineVideoView.c(OfflineVideoView.this).getVisibility() != 8))
        {
          ad.i("MicroMsg.OfflineVideoView", "%d hide loading.", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()) });
          OfflineVideoView.c(OfflineVideoView.this).setVisibility(8);
        }
        AppMethodBeat.o(98018);
      }
    });
    AppMethodBeat.o(98030);
  }
  
  private void onResume()
  {
    AppMethodBeat.i(98023);
    ad.d("MicroMsg.OfflineVideoView", "%d on resume %s", new Object[] { Integer.valueOf(hashCode()), bt.eGN() });
    if (!this.qmn) {
      ckc();
    }
    this.xpw = true;
    AppMethodBeat.o(98023);
  }
  
  public void Nl(int paramInt)
  {
    AppMethodBeat.i(179150);
    if (this.xpv != null) {
      this.xpv.sa(paramInt);
    }
    AppMethodBeat.o(179150);
  }
  
  public final void YI(String paramString)
  {
    AppMethodBeat.i(98033);
    ad.i("MicroMsg.OfflineVideoView", "%d prepare video  filePath %s", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.OfflineVideoView", "%d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98033);
      return;
    }
    if (this.nAZ != null)
    {
      this.nAZ.setOneTimeVideoTextureUpdateCallback(this.xpA);
      this.nAZ.setVideoPath(paramString);
    }
    AppMethodBeat.o(98033);
  }
  
  public final void aqt(final String paramString)
  {
    AppMethodBeat.i(98025);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(98025);
      return;
    }
    this.nzT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98013);
        if (OfflineVideoView.this.qir != null)
        {
          ad.i("MicroMsg.OfflineVideoView", "%d fresh thumb image", new Object[] { Integer.valueOf(hashCode()) });
          OfflineVideoView.this.qir.setImageBitmap(BackwardSupportUtil.b.n(paramString, 1.0F));
        }
        AppMethodBeat.o(98013);
      }
    });
    AppMethodBeat.o(98025);
  }
  
  public void at(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(98034);
    ad.i("MicroMsg.OfflineVideoView", "%d seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    hideLoading();
    this.nAZ.d(paramInt, paramBoolean);
    startTimer();
    AppMethodBeat.o(98034);
  }
  
  public final void au(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(187567);
    ad.i("MicroMsg.OfflineVideoView", "%d ui touch seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    at(paramInt, paramBoolean);
    startTimer();
    AppMethodBeat.o(187567);
  }
  
  public void b(final boolean paramBoolean, final float paramFloat)
  {
    AppMethodBeat.i(98027);
    this.nzT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98016);
        ad.i("MicroMsg.OfflineVideoView", "%d switch video model isVideoPlay %b %f", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
        View localView = (View)OfflineVideoView.a(OfflineVideoView.this);
        if (paramBoolean)
        {
          localView.setAlpha(paramFloat);
          localView.setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setAlpha(paramFloat);
          if (paramFloat >= 1.0D)
          {
            OfflineVideoView.this.qir.setVisibility(8);
            AppMethodBeat.o(98016);
          }
        }
        else
        {
          localView.setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setAlpha(0.0F);
          OfflineVideoView.this.qir.setVisibility(0);
        }
        AppMethodBeat.o(98016);
      }
    });
    AppMethodBeat.o(98027);
  }
  
  public final void ckc()
  {
    AppMethodBeat.i(98024);
    if (this.xpv != null)
    {
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      if (this.xpv.a(localPString1))
      {
        if (!bt.isNullOrNil(localPString2.value)) {
          aqt(localPString2.value);
        }
        if (!bt.isNullOrNil(localPString1.value))
        {
          YI(localPString1.value);
          AppMethodBeat.o(98024);
        }
      }
      else
      {
        showLoading();
        b(false, 0.0F);
      }
      AppMethodBeat.o(98024);
      return;
    }
    ad.w("MicroMsg.OfflineVideoView", "%d toggle video but video callback is null", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(98024);
  }
  
  public final void dY(int paramInt1, int paramInt2) {}
  
  protected void dzu()
  {
    AppMethodBeat.i(179149);
    this.nBf.stopTimer();
    AppMethodBeat.o(179149);
  }
  
  public final void dzv()
  {
    AppMethodBeat.i(179151);
    ad.i("MicroMsg.OfflineVideoView", "%d pause", new Object[] { Integer.valueOf(hashCode()) });
    ad.i("MicroMsg.OfflineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), bt.eGN() });
    this.xpx = false;
    if (this.nAZ.isPlaying())
    {
      this.xpy = this.nAZ.getCurrentPosition();
      ad.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      this.nAZ.pause();
    }
    hideLoading();
    dzu();
    AppMethodBeat.o(179151);
  }
  
  public final void dzw()
  {
    AppMethodBeat.i(179152);
    ad.i("MicroMsg.OfflineVideoView", "%d start hasResumed[%b], curPos [%d], duration [%d], shouldSeek [%d]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.xpw), Integer.valueOf(this.nAZ.getCurrentPosition()), Integer.valueOf(this.nAZ.getDuration()), Integer.valueOf(this.xpy) });
    this.xpx = true;
    if (this.xpw) {
      if (!bt.isNullOrNil(this.nAZ.getVideoPath())) {
        if (this.nAZ.getCurrentPosition() >= this.nAZ.getDuration())
        {
          this.nAZ.d(0.0D, true);
          if (this.xpv != null) {
            this.xpv.onStart(this.duration);
          }
        }
      }
    }
    for (;;)
    {
      startTimer();
      AppMethodBeat.o(179152);
      return;
      this.nAZ.start();
      continue;
      onResume();
      continue;
      onResume();
    }
  }
  
  public final boolean dzx()
  {
    AppMethodBeat.i(179154);
    if ((this.nAZ instanceof VideoPlayerTextureView))
    {
      if ((((VideoPlayerTextureView)this.nAZ).eAU()) && (isPlaying()))
      {
        AppMethodBeat.o(179154);
        return true;
      }
      AppMethodBeat.o(179154);
      return false;
    }
    boolean bool = isPlaying();
    AppMethodBeat.o(179154);
    return bool;
  }
  
  public final int eM(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(98035);
    if (this.nAZ != null)
    {
      int i = this.nAZ.getCurrentPosition() / 1000;
      AppMethodBeat.o(98035);
      return i;
    }
    AppMethodBeat.o(98035);
    return 0;
  }
  
  public int getCurrentPositionMs()
  {
    AppMethodBeat.i(98036);
    if (this.nAZ != null)
    {
      int i = this.nAZ.getCurrentPosition();
      AppMethodBeat.o(98036);
      return i;
    }
    AppMethodBeat.o(98036);
    return 0;
  }
  
  public int getDurationMs()
  {
    AppMethodBeat.i(98037);
    if (this.nAZ != null)
    {
      int i = this.nAZ.getDuration();
      AppMethodBeat.o(98037);
      return i;
    }
    AppMethodBeat.o(98037);
    return 0;
  }
  
  public View getInnerVideoView()
  {
    if ((this.nAZ instanceof View)) {
      return (View)this.nAZ;
    }
    return null;
  }
  
  public int getTimerInterval()
  {
    return this.xpz;
  }
  
  public String getVideoPath()
  {
    AppMethodBeat.i(179155);
    if (this.nAZ != null)
    {
      String str = this.nAZ.getVideoPath();
      AppMethodBeat.o(179155);
      return str;
    }
    AppMethodBeat.o(179155);
    return "";
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(179153);
    if (this.nAZ != null)
    {
      boolean bool = this.nAZ.isPlaying();
      AppMethodBeat.o(179153);
      return bool;
    }
    AppMethodBeat.o(179153);
    return false;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(98032);
    ad.i("MicroMsg.OfflineVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if (this.xpv == null)
    {
      if ((d.lh(18)) || (!this.qmo))
      {
        at(0, true);
        AppMethodBeat.o(98032);
        return;
      }
      if (this.nAZ != null)
      {
        String str = this.nAZ.getVideoPath();
        this.nAZ.stop();
        YI(str);
        AppMethodBeat.o(98032);
      }
    }
    else
    {
      this.xpv.onCompletion();
    }
    AppMethodBeat.o(98032);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179148);
    ad.d("MicroMsg.OfflineVideoView", "%d on destroy %s", new Object[] { Integer.valueOf(hashCode()), bt.eGN() });
    ad.i("MicroMsg.OfflineVideoView", "%d logic unInit", new Object[] { Integer.valueOf(hashCode()) });
    this.nzT.removeCallbacksAndMessages(null);
    dzu();
    if (this.nAZ != null) {
      this.nAZ.stop();
    }
    AppMethodBeat.o(179148);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98026);
    ad.e("MicroMsg.OfflineVideoView", "%d on play video error what %d extra %d isMMVideoPlayer %b errorCount %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.qmo), Integer.valueOf(this.bxy) });
    this.bxy += 1;
    final String str1 = this.nAZ.getVideoPath();
    this.nAZ.stop();
    this.qmn = true;
    b(false, 0.0F);
    if (this.bxy <= 3)
    {
      this.nzT.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98014);
          OfflineVideoView.this.YI(str1);
          AppMethodBeat.o(98014);
        }
      }, 200L);
      AppMethodBeat.o(98026);
      return;
    }
    if (!bt.isNullOrNil(str1))
    {
      ad.w("MicroMsg.OfflineVideoView", "%d start third player to play", new Object[] { Integer.valueOf(hashCode()) });
      this.nzT.post(new OfflineVideoView.3(this, str1));
      if (!this.qmo) {
        break label221;
      }
    }
    label221:
    for (str1 = "1";; str1 = "0")
    {
      String str2 = getClass().getName();
      i.b(i.wAJ, str1, paramInt1, paramInt2, str2);
      AppMethodBeat.o(98026);
      return;
    }
  }
  
  public void pause()
  {
    AppMethodBeat.i(179146);
    ad.i("MicroMsg.OfflineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), bt.eGN() });
    if (this.nAZ.isPlaying())
    {
      this.xpy = this.nAZ.getCurrentPosition();
      ad.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      this.nAZ.pause();
    }
    AppMethodBeat.o(179146);
  }
  
  public void rq()
  {
    AppMethodBeat.i(98028);
    b(true, 0.0F);
    this.qmn = false;
    hideLoading();
    this.duration = (this.nAZ.getDuration() / 1000);
    ad.i("MicroMsg.OfflineVideoView", "%d on prepared. shouldPlayWhenPrepared [%b] shouldSeekTimeWhenPrepared[%d]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.xpx), Integer.valueOf(this.xpy) });
    if (this.xpx)
    {
      if (this.xpy <= 0) {
        this.nAZ.start();
      }
      for (;;)
      {
        startTimer();
        if (this.xpv != null) {
          this.xpv.onStart(this.duration);
        }
        this.xpy = -1;
        AppMethodBeat.o(98028);
        return;
        at(this.xpy, true);
      }
    }
    if (this.xpy > 0) {}
    for (int i = this.xpy;; i = 0)
    {
      at(i, false);
      break;
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(98022);
    this.fqj = paramBoolean;
    this.nAZ.setMute(this.fqj);
    AppMethodBeat.o(98022);
  }
  
  public void setTimerInterval(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 200) {
      i = 200;
    }
    this.xpz = i;
  }
  
  public void setVideoCallback(a parama)
  {
    this.xpv = parama;
  }
  
  protected void showLoading()
  {
    AppMethodBeat.i(98029);
    this.nzT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98017);
        ad.i("MicroMsg.OfflineVideoView", "%d show loading. downloadMode %d", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()), Integer.valueOf(OfflineVideoView.this.hashCode()) });
        if ((OfflineVideoView.c(OfflineVideoView.this) != null) && (OfflineVideoView.c(OfflineVideoView.this).getVisibility() != 0)) {
          OfflineVideoView.c(OfflineVideoView.this).setVisibility(0);
        }
        AppMethodBeat.o(98017);
      }
    });
    AppMethodBeat.o(98029);
  }
  
  public void start()
  {
    AppMethodBeat.i(179147);
    ad.i("MicroMsg.OfflineVideoView", "%d start curPos [%d], duration [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.nAZ.getCurrentPosition()), Integer.valueOf(this.nAZ.getDuration()) });
    if (!bt.isNullOrNil(this.nAZ.getVideoPath()))
    {
      if (this.nAZ.getCurrentPosition() < this.nAZ.getDuration()) {
        break label136;
      }
      this.nAZ.d(0.0D, true);
      if (this.xpv != null) {
        this.xpv.onStart(this.duration);
      }
    }
    for (;;)
    {
      startTimer();
      AppMethodBeat.o(179147);
      return;
      label136:
      this.nAZ.start();
    }
  }
  
  public void startTimer()
  {
    AppMethodBeat.i(98031);
    av localav = this.nBf;
    long l = this.xpz;
    localav.av(l, l);
    AppMethodBeat.o(98031);
  }
  
  public static abstract interface a
  {
    public abstract boolean a(PString paramPString);
    
    public abstract void onCompletion();
    
    public abstract void onStart(int paramInt);
    
    public abstract void sa(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView
 * JD-Core Version:    0.7.0.1
 */