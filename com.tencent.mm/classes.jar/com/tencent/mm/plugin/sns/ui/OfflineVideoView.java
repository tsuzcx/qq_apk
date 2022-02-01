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
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.c;
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
  private int bFv;
  private int duration;
  private boolean fMP;
  private ProgressBar ltc;
  private Context mContext;
  private ap oGm;
  private h oHt;
  private av oHz;
  protected ImageView rAT;
  private RelativeLayout rBo;
  protected boolean rFd;
  private boolean rFe;
  private a zTF;
  private boolean zTG;
  protected boolean zTH;
  private int zTI;
  private int zTJ;
  private boolean zTK;
  private h.e zTL;
  
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
    this.fMP = false;
    this.rFd = false;
    this.zTG = false;
    this.zTH = true;
    this.zTI = -1;
    this.bFv = 0;
    this.duration = 0;
    this.oGm = new ap(Looper.getMainLooper());
    this.zTJ = 1000;
    this.zTK = false;
    this.oHz = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(198184);
        if (OfflineVideoView.a(OfflineVideoView.this) == null)
        {
          AppMethodBeat.o(198184);
          return false;
        }
        if (((View)OfflineVideoView.a(OfflineVideoView.this)).getAlpha() < 1.0F) {
          OfflineVideoView.this.c(true, 1.0F);
        }
        if (OfflineVideoView.a(OfflineVideoView.this).isPlaying())
        {
          OfflineVideoView.d(OfflineVideoView.this);
          OfflineVideoView.this.QW(OfflineVideoView.a(OfflineVideoView.this).getCurrentPosition());
        }
        AppMethodBeat.o(198184);
        return true;
      }
    }, true);
    this.zTL = new h.e()
    {
      public final void boT()
      {
        AppMethodBeat.i(198185);
        ad.i("MicroMsg.OfflineVideoView", "%d on texture update.", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()) });
        try
        {
          OfflineVideoView.this.c(true, 1.0F);
          AppMethodBeat.o(198185);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.OfflineVideoView", "texture view update. error " + localException.toString());
          AppMethodBeat.o(198185);
        }
      }
    };
    this.mContext = paramContext;
    ad.i("MicroMsg.OfflineVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(this.mContext).inflate(2131495624, this);
    this.rAT = ((ImageView)findViewById(2131306398));
    this.rBo = ((RelativeLayout)findViewById(2131306392));
    this.ltc = ((ProgressBar)findViewById(2131306352));
    if (d.lz(18))
    {
      paramInt = 0;
      if (paramInt == 0) {
        break label282;
      }
      this.rFe = true;
    }
    for (this.oHt = new VideoPlayerTextureView(this.mContext);; this.oHt = new VideoTextureView(this.mContext))
    {
      this.oHt.setVideoCallback(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      this.rBo.addView((View)this.oHt, paramContext);
      c(false, 0.0F);
      AppMethodBeat.o(98021);
      return;
      paramInt = 1;
      break;
      label282:
      this.rFe = false;
    }
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(98030);
    this.oGm.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98017);
        if ((OfflineVideoView.c(OfflineVideoView.this) != null) && (OfflineVideoView.c(OfflineVideoView.this).getVisibility() != 8))
        {
          ad.i("MicroMsg.OfflineVideoView", "%d hide loading.", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()) });
          OfflineVideoView.c(OfflineVideoView.this).setVisibility(8);
        }
        AppMethodBeat.o(98017);
      }
    });
    AppMethodBeat.o(98030);
  }
  
  private void onResume()
  {
    AppMethodBeat.i(98023);
    ad.d("MicroMsg.OfflineVideoView", "%d on resume %s", new Object[] { Integer.valueOf(hashCode()), bt.flS() });
    if (!this.rFd) {
      cxv();
    }
    this.zTG = true;
    AppMethodBeat.o(98023);
  }
  
  public void QW(int paramInt)
  {
    AppMethodBeat.i(179150);
    if (this.zTF != null) {
      this.zTF.tt(paramInt);
    }
    AppMethodBeat.o(179150);
  }
  
  public final void aAJ(final String paramString)
  {
    AppMethodBeat.i(98025);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(98025);
      return;
    }
    this.oGm.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98013);
        if (OfflineVideoView.this.rAT != null)
        {
          ad.i("MicroMsg.OfflineVideoView", "%d fresh thumb image", new Object[] { Integer.valueOf(hashCode()) });
          OfflineVideoView.this.rAT.setImageBitmap(BackwardSupportUtil.b.o(paramString, 1.0F));
        }
        AppMethodBeat.o(98013);
      }
    });
    AppMethodBeat.o(98025);
  }
  
  public void aB(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(98034);
    ad.i("MicroMsg.OfflineVideoView", "%d seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    hideLoading();
    this.oHt.d(paramInt, paramBoolean);
    startTimer();
    AppMethodBeat.o(98034);
  }
  
  public final void aC(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(198186);
    ad.i("MicroMsg.OfflineVideoView", "%d ui touch seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    aB(paramInt, paramBoolean);
    startTimer();
    AppMethodBeat.o(198186);
  }
  
  public final void agT(String paramString)
  {
    AppMethodBeat.i(98033);
    ad.i("MicroMsg.OfflineVideoView", "%d prepare video  filePath %s", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.OfflineVideoView", "%d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98033);
      return;
    }
    if (this.oHt != null)
    {
      this.oHt.setOneTimeVideoTextureUpdateCallback(this.zTL);
      this.oHt.setVideoPath(paramString);
    }
    AppMethodBeat.o(98033);
  }
  
  public void c(final boolean paramBoolean, final float paramFloat)
  {
    AppMethodBeat.i(98027);
    this.oGm.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98015);
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
            OfflineVideoView.this.rAT.setVisibility(8);
            AppMethodBeat.o(98015);
          }
        }
        else
        {
          localView.setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setAlpha(0.0F);
          OfflineVideoView.this.rAT.setVisibility(0);
        }
        AppMethodBeat.o(98015);
      }
    });
    AppMethodBeat.o(98027);
  }
  
  public final void cxv()
  {
    AppMethodBeat.i(98024);
    if (this.zTF != null)
    {
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      if (this.zTF.a(localPString1))
      {
        if (!bt.isNullOrNil(localPString2.value)) {
          aAJ(localPString2.value);
        }
        if (!bt.isNullOrNil(localPString1.value))
        {
          agT(localPString1.value);
          AppMethodBeat.o(98024);
        }
      }
      else
      {
        showLoading();
        c(false, 0.0F);
      }
      AppMethodBeat.o(98024);
      return;
    }
    ad.w("MicroMsg.OfflineVideoView", "%d toggle video but video callback is null", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(98024);
  }
  
  public final int eT(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  protected void eae()
  {
    AppMethodBeat.i(179149);
    this.oHz.stopTimer();
    AppMethodBeat.o(179149);
  }
  
  public final void eaf()
  {
    AppMethodBeat.i(179151);
    ad.i("MicroMsg.OfflineVideoView", "%d pause", new Object[] { Integer.valueOf(hashCode()) });
    ad.i("MicroMsg.OfflineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), bt.flS() });
    this.zTH = false;
    if (this.oHt.isPlaying())
    {
      this.zTI = this.oHt.getCurrentPosition();
      ad.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      this.oHt.pause();
    }
    hideLoading();
    eae();
    AppMethodBeat.o(179151);
  }
  
  public final void eag()
  {
    AppMethodBeat.i(179152);
    ad.i("MicroMsg.OfflineVideoView", "%d start hasResumed[%b], curPos [%d], duration [%d], shouldSeek [%d]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.zTG), Integer.valueOf(this.oHt.getCurrentPosition()), Integer.valueOf(this.oHt.getDuration()), Integer.valueOf(this.zTI) });
    this.zTH = true;
    if (this.zTG) {
      if (!bt.isNullOrNil(this.oHt.getVideoPath())) {
        if (this.oHt.getCurrentPosition() >= this.oHt.getDuration())
        {
          this.oHt.d(0.0D, true);
          if (this.zTF != null) {
            this.zTF.onStart(this.duration);
          }
        }
      }
    }
    for (;;)
    {
      startTimer();
      AppMethodBeat.o(179152);
      return;
      this.oHt.start();
      continue;
      onResume();
      continue;
      onResume();
    }
  }
  
  public final boolean eah()
  {
    AppMethodBeat.i(179154);
    if ((this.oHt instanceof VideoPlayerTextureView))
    {
      if ((((VideoPlayerTextureView)this.oHt).ffq()) && (isPlaying()))
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
  
  public final void eb(int paramInt1, int paramInt2) {}
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(98035);
    if (this.oHt != null)
    {
      int i = this.oHt.getCurrentPosition() / 1000;
      AppMethodBeat.o(98035);
      return i;
    }
    AppMethodBeat.o(98035);
    return 0;
  }
  
  public int getCurrentPositionMs()
  {
    AppMethodBeat.i(98036);
    if (this.oHt != null)
    {
      int i = this.oHt.getCurrentPosition();
      AppMethodBeat.o(98036);
      return i;
    }
    AppMethodBeat.o(98036);
    return 0;
  }
  
  public int getDurationMs()
  {
    AppMethodBeat.i(98037);
    if (this.oHt != null)
    {
      int i = this.oHt.getDuration();
      AppMethodBeat.o(98037);
      return i;
    }
    AppMethodBeat.o(98037);
    return 0;
  }
  
  public View getInnerVideoView()
  {
    if ((this.oHt instanceof View)) {
      return (View)this.oHt;
    }
    return null;
  }
  
  public int getTimerInterval()
  {
    return this.zTJ;
  }
  
  public String getVideoPath()
  {
    AppMethodBeat.i(179155);
    if (this.oHt != null)
    {
      String str = this.oHt.getVideoPath();
      AppMethodBeat.o(179155);
      return str;
    }
    AppMethodBeat.o(179155);
    return "";
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(179153);
    if (this.oHt != null)
    {
      boolean bool = this.oHt.isPlaying();
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
    if (this.zTF == null)
    {
      if ((d.lA(18)) || (!this.rFe))
      {
        aB(0, true);
        AppMethodBeat.o(98032);
        return;
      }
      if (this.oHt != null)
      {
        String str = this.oHt.getVideoPath();
        this.oHt.stop();
        agT(str);
        AppMethodBeat.o(98032);
      }
    }
    else
    {
      this.zTF.onCompletion();
    }
    AppMethodBeat.o(98032);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179148);
    ad.d("MicroMsg.OfflineVideoView", "%d on destroy %s", new Object[] { Integer.valueOf(hashCode()), bt.flS() });
    ad.i("MicroMsg.OfflineVideoView", "%d logic unInit", new Object[] { Integer.valueOf(hashCode()) });
    this.oGm.removeCallbacksAndMessages(null);
    eae();
    if (this.oHt != null) {
      this.oHt.stop();
    }
    AppMethodBeat.o(179148);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(98026);
    ad.e("MicroMsg.OfflineVideoView", "%d on play video error what %d extra %d isMMVideoPlayer %b errorCount %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.rFe), Integer.valueOf(this.bFv) });
    this.bFv += 1;
    final String str1 = this.oHt.getVideoPath();
    this.oHt.stop();
    this.rFd = true;
    c(false, 0.0F);
    if (this.bFv <= 3)
    {
      this.oGm.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98014);
          OfflineVideoView.this.agT(str1);
          AppMethodBeat.o(98014);
        }
      }, 200L);
      AppMethodBeat.o(98026);
      return;
    }
    try
    {
      long l;
      if (!bt.isNullOrNil(str1)) {
        if (com.tencent.mm.vfs.i.fv(str1))
        {
          l = com.tencent.mm.vfs.i.aYo(str1);
          ad.i("MicroMsg.OfflineVideoView", "onError, fileLen=".concat(String.valueOf(l)));
          paramInt1 = i;
          if (!this.zTK) {
            if (!this.rFe) {
              break label272;
            }
          }
        }
      }
      label272:
      for (str1 = "1";; str1 = "0")
      {
        String str2 = getClass().getSimpleName();
        com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.zcW, str1, paramInt1, (int)l, str2);
        this.zTK = true;
        AppMethodBeat.o(98026);
        return;
        ad.e("MicroMsg.OfflineVideoView", "onError, file not exists");
        l = -1L;
        paramInt1 = 2;
        break;
        ad.e("MicroMsg.OfflineVideoView", "onError, filepath==null");
        l = -1L;
        paramInt1 = 3;
        break;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.OfflineVideoView", "onError, exp=" + localThrowable.toString());
      AppMethodBeat.o(98026);
    }
  }
  
  public void pause()
  {
    AppMethodBeat.i(179146);
    ad.i("MicroMsg.OfflineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), bt.flS() });
    if (this.oHt.isPlaying())
    {
      this.zTI = this.oHt.getCurrentPosition();
      ad.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      this.oHt.pause();
    }
    AppMethodBeat.o(179146);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(98022);
    this.fMP = paramBoolean;
    this.oHt.setMute(this.fMP);
    AppMethodBeat.o(98022);
  }
  
  public void setOnSeekCompleteCallback(h.c paramc)
  {
    AppMethodBeat.i(198187);
    if (this.oHt != null) {
      this.oHt.setOnSeekCompleteCallback(paramc);
    }
    AppMethodBeat.o(198187);
  }
  
  public void setTimerInterval(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 200) {
      i = 200;
    }
    this.zTJ = i;
  }
  
  public void setVideoCallback(a parama)
  {
    this.zTF = parama;
  }
  
  protected void showLoading()
  {
    AppMethodBeat.i(98029);
    this.oGm.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98016);
        ad.i("MicroMsg.OfflineVideoView", "%d show loading. downloadMode %d", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()), Integer.valueOf(OfflineVideoView.this.hashCode()) });
        if ((OfflineVideoView.c(OfflineVideoView.this) != null) && (OfflineVideoView.c(OfflineVideoView.this).getVisibility() != 0)) {
          OfflineVideoView.c(OfflineVideoView.this).setVisibility(0);
        }
        AppMethodBeat.o(98016);
      }
    });
    AppMethodBeat.o(98029);
  }
  
  public void start()
  {
    AppMethodBeat.i(179147);
    ad.i("MicroMsg.OfflineVideoView", "%d start curPos [%d], duration [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.oHt.getCurrentPosition()), Integer.valueOf(this.oHt.getDuration()) });
    if (!bt.isNullOrNil(this.oHt.getVideoPath()))
    {
      if (this.oHt.getCurrentPosition() < this.oHt.getDuration()) {
        break label136;
      }
      this.oHt.d(0.0D, true);
      if (this.zTF != null) {
        this.zTF.onStart(this.duration);
      }
    }
    for (;;)
    {
      startTimer();
      AppMethodBeat.o(179147);
      return;
      label136:
      this.oHt.start();
    }
  }
  
  public void startTimer()
  {
    AppMethodBeat.i(98031);
    av localav = this.oHz;
    long l = this.zTJ;
    localav.az(l, l);
    AppMethodBeat.o(98031);
  }
  
  public void ta()
  {
    AppMethodBeat.i(98028);
    c(true, 0.0F);
    this.rFd = false;
    hideLoading();
    this.duration = (this.oHt.getDuration() / 1000);
    ad.i("MicroMsg.OfflineVideoView", "%d on prepared. shouldPlayWhenPrepared [%b] shouldSeekTimeWhenPrepared[%d]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.zTH), Integer.valueOf(this.zTI) });
    if (this.zTH)
    {
      if (this.zTI <= 0) {
        this.oHt.start();
      }
      for (;;)
      {
        startTimer();
        if (this.zTF != null) {
          this.zTF.onStart(this.duration);
        }
        this.zTI = -1;
        AppMethodBeat.o(98028);
        return;
        aB(this.zTI, true);
      }
    }
    if (this.zTI > 0) {}
    for (int i = this.zTI;; i = 0)
    {
      aB(i, false);
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean a(PString paramPString);
    
    public abstract void onCompletion();
    
    public abstract void onStart(int paramInt);
    
    public abstract void tt(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView
 * JD-Core Version:    0.7.0.1
 */