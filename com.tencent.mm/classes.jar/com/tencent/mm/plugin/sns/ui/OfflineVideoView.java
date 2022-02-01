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
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.pluginsdk.ui.tools.j.c;
import com.tencent.mm.pluginsdk.ui.tools.j.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public class OfflineVideoView
  extends RelativeLayout
  implements j.a
{
  protected boolean EtA;
  private int EtB;
  private int EtC;
  private boolean EtD;
  private j.e EtE;
  private a Ety;
  private boolean Etz;
  private int bFM;
  private int duration;
  private boolean guh;
  private Context mContext;
  private ProgressBar mEz;
  private MMHandler qaC;
  private com.tencent.mm.pluginsdk.ui.tools.j qbJ;
  private MTimerHandler qbP;
  protected ImageView tiQ;
  private RelativeLayout tjk;
  protected boolean tmZ;
  private boolean tna;
  
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
    this.guh = false;
    this.tmZ = false;
    this.Etz = false;
    this.EtA = true;
    this.EtB = -1;
    this.bFM = 0;
    this.duration = 0;
    this.qaC = new MMHandler(Looper.getMainLooper());
    this.EtC = 1000;
    this.EtD = false;
    this.qbP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(203316);
        if (OfflineVideoView.a(OfflineVideoView.this) == null)
        {
          AppMethodBeat.o(203316);
          return false;
        }
        if (((View)OfflineVideoView.a(OfflineVideoView.this)).getAlpha() < 1.0F) {
          OfflineVideoView.this.d(true, 1.0F);
        }
        if (OfflineVideoView.a(OfflineVideoView.this).isPlaying())
        {
          OfflineVideoView.d(OfflineVideoView.this);
          OfflineVideoView.this.Zz(OfflineVideoView.a(OfflineVideoView.this).getCurrentPosition());
        }
        AppMethodBeat.o(203316);
        return true;
      }
    }, true);
    this.EtE = new j.e()
    {
      public final void bLh()
      {
        AppMethodBeat.i(203317);
        Log.i("MicroMsg.OfflineVideoView", "%d on texture update.", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()) });
        try
        {
          OfflineVideoView.this.d(true, 1.0F);
          AppMethodBeat.o(203317);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.OfflineVideoView", "texture view update. error " + localException.toString());
          AppMethodBeat.o(203317);
        }
      }
    };
    this.mContext = paramContext;
    Log.i("MicroMsg.OfflineVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(this.mContext).inflate(2131496523, this);
    this.tiQ = ((ImageView)findViewById(2131309829));
    this.tjk = ((RelativeLayout)findViewById(2131309821));
    this.mEz = ((ProgressBar)findViewById(2131309778));
    if (d.oE(18))
    {
      paramInt = 0;
      if (paramInt == 0) {
        break label282;
      }
      this.tna = true;
    }
    for (this.qbJ = new VideoPlayerTextureView(this.mContext);; this.qbJ = new VideoTextureView(this.mContext))
    {
      this.qbJ.setVideoCallback(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      this.tjk.addView((View)this.qbJ, paramContext);
      d(false, 0.0F);
      AppMethodBeat.o(98021);
      return;
      paramInt = 1;
      break;
      label282:
      this.tna = false;
    }
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(98030);
    this.qaC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98017);
        if ((OfflineVideoView.c(OfflineVideoView.this) != null) && (OfflineVideoView.c(OfflineVideoView.this).getVisibility() != 8))
        {
          Log.i("MicroMsg.OfflineVideoView", "%d hide loading.", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()) });
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
    Log.d("MicroMsg.OfflineVideoView", "%d on resume %s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    if (!this.tmZ) {
      cWZ();
    }
    this.Etz = true;
    AppMethodBeat.o(98023);
  }
  
  public void Zz(int paramInt)
  {
    AppMethodBeat.i(179150);
    if (this.Ety != null) {
      this.Ety.xv(paramInt);
    }
    AppMethodBeat.o(179150);
  }
  
  public final void aQV(final String paramString)
  {
    AppMethodBeat.i(98025);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(98025);
      return;
    }
    this.qaC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98013);
        if (OfflineVideoView.this.tiQ != null)
        {
          Log.i("MicroMsg.OfflineVideoView", "%d fresh thumb image", new Object[] { Integer.valueOf(hashCode()) });
          OfflineVideoView.this.tiQ.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile(paramString, 1.0F));
        }
        AppMethodBeat.o(98013);
      }
    });
    AppMethodBeat.o(98025);
  }
  
  public void aT(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(98034);
    Log.i("MicroMsg.OfflineVideoView", "%d seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    hideLoading();
    this.qbJ.d(paramInt, paramBoolean);
    startTimer();
    AppMethodBeat.o(98034);
  }
  
  public final void aU(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(203318);
    Log.i("MicroMsg.OfflineVideoView", "%d ui touch seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    aT(paramInt, paramBoolean);
    startTimer();
    AppMethodBeat.o(203318);
  }
  
  public final void asy(String paramString)
  {
    AppMethodBeat.i(98033);
    Log.i("MicroMsg.OfflineVideoView", "%d prepare video  filePath %s", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.OfflineVideoView", "%d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98033);
      return;
    }
    if (this.qbJ != null)
    {
      this.qbJ.setOneTimeVideoTextureUpdateCallback(this.EtE);
      this.qbJ.setVideoPath(paramString);
    }
    AppMethodBeat.o(98033);
  }
  
  public final void cWZ()
  {
    AppMethodBeat.i(98024);
    if (this.Ety != null)
    {
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      if (this.Ety.a(localPString1))
      {
        if (!Util.isNullOrNil(localPString2.value)) {
          aQV(localPString2.value);
        }
        if (!Util.isNullOrNil(localPString1.value))
        {
          asy(localPString1.value);
          AppMethodBeat.o(98024);
        }
      }
      else
      {
        showLoading();
        d(false, 0.0F);
      }
      AppMethodBeat.o(98024);
      return;
    }
    Log.w("MicroMsg.OfflineVideoView", "%d toggle video but video callback is null", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(98024);
  }
  
  public void d(final boolean paramBoolean, final float paramFloat)
  {
    AppMethodBeat.i(98027);
    this.qaC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98015);
        Log.i("MicroMsg.OfflineVideoView", "%d switch video model isVideoPlay %b %f", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
        View localView = (View)OfflineVideoView.a(OfflineVideoView.this);
        if (paramBoolean)
        {
          localView.setAlpha(paramFloat);
          localView.setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setAlpha(paramFloat);
          if (paramFloat >= 1.0D)
          {
            OfflineVideoView.this.tiQ.setVisibility(8);
            AppMethodBeat.o(98015);
          }
        }
        else
        {
          localView.setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setAlpha(0.0F);
          OfflineVideoView.this.tiQ.setVisibility(0);
        }
        AppMethodBeat.o(98015);
      }
    });
    AppMethodBeat.o(98027);
  }
  
  public final void eo(int paramInt1, int paramInt2) {}
  
  protected void fgc()
  {
    AppMethodBeat.i(179149);
    this.qbP.stopTimer();
    AppMethodBeat.o(179149);
  }
  
  public final void fgd()
  {
    AppMethodBeat.i(179151);
    Log.i("MicroMsg.OfflineVideoView", "%d pause", new Object[] { Integer.valueOf(hashCode()) });
    Log.i("MicroMsg.OfflineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    this.EtA = false;
    if (this.qbJ.isPlaying())
    {
      this.EtB = this.qbJ.getCurrentPosition();
      Log.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      this.qbJ.pause();
    }
    hideLoading();
    fgc();
    AppMethodBeat.o(179151);
  }
  
  public final void fge()
  {
    AppMethodBeat.i(179152);
    Log.i("MicroMsg.OfflineVideoView", "%d start hasResumed[%b], curPos [%d], duration [%d], shouldSeek [%d]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.Etz), Integer.valueOf(this.qbJ.getCurrentPosition()), Integer.valueOf(this.qbJ.getDuration()), Integer.valueOf(this.EtB) });
    this.EtA = true;
    if (this.Etz) {
      if (!Util.isNullOrNil(this.qbJ.getVideoPath())) {
        if (this.qbJ.getCurrentPosition() >= this.qbJ.getDuration())
        {
          this.qbJ.d(0.0D, true);
          if (this.Ety != null) {
            this.Ety.onStart(this.duration);
          }
        }
      }
    }
    for (;;)
    {
      startTimer();
      AppMethodBeat.o(179152);
      return;
      this.qbJ.start();
      continue;
      onResume();
      continue;
      onResume();
    }
  }
  
  public final boolean fgf()
  {
    AppMethodBeat.i(179154);
    if ((this.qbJ instanceof VideoPlayerTextureView))
    {
      if ((((VideoPlayerTextureView)this.qbJ).gsG()) && (isPlaying()))
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
  
  public final int fh(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(98035);
    if (this.qbJ != null)
    {
      int i = this.qbJ.getCurrentPosition() / 1000;
      AppMethodBeat.o(98035);
      return i;
    }
    AppMethodBeat.o(98035);
    return 0;
  }
  
  public int getCurrentPositionMs()
  {
    AppMethodBeat.i(98036);
    if (this.qbJ != null)
    {
      int i = this.qbJ.getCurrentPosition();
      AppMethodBeat.o(98036);
      return i;
    }
    AppMethodBeat.o(98036);
    return 0;
  }
  
  public int getDurationMs()
  {
    AppMethodBeat.i(98037);
    if (this.qbJ != null)
    {
      int i = this.qbJ.getDuration();
      AppMethodBeat.o(98037);
      return i;
    }
    AppMethodBeat.o(98037);
    return 0;
  }
  
  public View getInnerVideoView()
  {
    if ((this.qbJ instanceof View)) {
      return (View)this.qbJ;
    }
    return null;
  }
  
  public int getTimerInterval()
  {
    return this.EtC;
  }
  
  public String getVideoPath()
  {
    AppMethodBeat.i(179155);
    if (this.qbJ != null)
    {
      String str = this.qbJ.getVideoPath();
      AppMethodBeat.o(179155);
      return str;
    }
    AppMethodBeat.o(179155);
    return "";
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(179153);
    if (this.qbJ != null)
    {
      boolean bool = this.qbJ.isPlaying();
      AppMethodBeat.o(179153);
      return bool;
    }
    AppMethodBeat.o(179153);
    return false;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(98032);
    Log.i("MicroMsg.OfflineVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if (this.Ety == null)
    {
      if ((d.oF(18)) || (!this.tna))
      {
        aT(0, true);
        AppMethodBeat.o(98032);
        return;
      }
      if (this.qbJ != null)
      {
        String str = this.qbJ.getVideoPath();
        this.qbJ.stop();
        asy(str);
        AppMethodBeat.o(98032);
      }
    }
    else
    {
      this.Ety.onCompletion();
    }
    AppMethodBeat.o(98032);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179148);
    Log.d("MicroMsg.OfflineVideoView", "%d on destroy %s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    Log.i("MicroMsg.OfflineVideoView", "%d logic unInit", new Object[] { Integer.valueOf(hashCode()) });
    this.qaC.removeCallbacksAndMessages(null);
    fgc();
    if (this.qbJ != null) {
      this.qbJ.stop();
    }
    AppMethodBeat.o(179148);
  }
  
  public void onError(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(98026);
    Log.e("MicroMsg.OfflineVideoView", "%d on play video error what %d extra %d isMMVideoPlayer %b errorCount %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.tna), Integer.valueOf(this.bFM) });
    this.bFM += 1;
    final String str1 = this.qbJ.getVideoPath();
    this.qbJ.stop();
    this.tmZ = true;
    d(false, 0.0F);
    if (this.bFM <= 3)
    {
      this.qaC.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98014);
          OfflineVideoView.this.asy(str1);
          AppMethodBeat.o(98014);
        }
      }, 200L);
      AppMethodBeat.o(98026);
      return;
    }
    try
    {
      long l;
      if (!Util.isNullOrNil(str1)) {
        if (s.YS(str1))
        {
          l = s.boW(str1);
          boolean bool = s.deleteFile(str1);
          Log.i("MicroMsg.OfflineVideoView", "onError, fileLen=" + l + ", delRet=" + bool);
          paramInt1 = i;
          if (!this.EtD) {
            if (!this.tna) {
              break label297;
            }
          }
        }
      }
      label297:
      for (str1 = "1";; str1 = "0")
      {
        String str2 = getClass().getSimpleName();
        com.tencent.mm.plugin.sns.data.j.b(com.tencent.mm.plugin.sns.data.j.DDW, str1, paramInt1, (int)l, str2);
        this.EtD = true;
        AppMethodBeat.o(98026);
        return;
        Log.e("MicroMsg.OfflineVideoView", "onError, file not exists");
        l = -1L;
        paramInt1 = 2;
        break;
        Log.e("MicroMsg.OfflineVideoView", "onError, filepath==null");
        l = -1L;
        paramInt1 = 3;
        break;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.OfflineVideoView", "onError, exp=" + localThrowable.toString());
      AppMethodBeat.o(98026);
    }
  }
  
  public void pause()
  {
    AppMethodBeat.i(179146);
    Log.i("MicroMsg.OfflineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    if (this.qbJ.isPlaying())
    {
      this.EtB = this.qbJ.getCurrentPosition();
      Log.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      this.qbJ.pause();
    }
    AppMethodBeat.o(179146);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(98022);
    this.guh = paramBoolean;
    this.qbJ.setMute(this.guh);
    AppMethodBeat.o(98022);
  }
  
  public void setOnSeekCompleteCallback(j.c paramc)
  {
    AppMethodBeat.i(203319);
    if (this.qbJ != null) {
      this.qbJ.setOnSeekCompleteCallback(paramc);
    }
    AppMethodBeat.o(203319);
  }
  
  public void setTimerInterval(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 200) {
      i = 200;
    }
    this.EtC = i;
  }
  
  public void setVideoCallback(a parama)
  {
    this.Ety = parama;
  }
  
  protected void showLoading()
  {
    AppMethodBeat.i(98029);
    this.qaC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98016);
        Log.i("MicroMsg.OfflineVideoView", "%d show loading. downloadMode %d", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()), Integer.valueOf(OfflineVideoView.this.hashCode()) });
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
    Log.i("MicroMsg.OfflineVideoView", "%d start curPos [%d], duration [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.qbJ.getCurrentPosition()), Integer.valueOf(this.qbJ.getDuration()) });
    if (!Util.isNullOrNil(this.qbJ.getVideoPath()))
    {
      if (this.qbJ.getCurrentPosition() < this.qbJ.getDuration()) {
        break label136;
      }
      this.qbJ.d(0.0D, true);
      if (this.Ety != null) {
        this.Ety.onStart(this.duration);
      }
    }
    for (;;)
    {
      startTimer();
      AppMethodBeat.o(179147);
      return;
      label136:
      this.qbJ.start();
    }
  }
  
  public void startTimer()
  {
    AppMethodBeat.i(98031);
    this.qbP.startTimer(this.EtC);
    AppMethodBeat.o(98031);
  }
  
  public void tf()
  {
    AppMethodBeat.i(98028);
    d(true, 0.0F);
    this.tmZ = false;
    hideLoading();
    this.duration = (this.qbJ.getDuration() / 1000);
    Log.i("MicroMsg.OfflineVideoView", "%d on prepared. shouldPlayWhenPrepared [%b] shouldSeekTimeWhenPrepared[%d]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.EtA), Integer.valueOf(this.EtB) });
    if (this.EtA)
    {
      if (this.EtB <= 0) {
        this.qbJ.start();
      }
      for (;;)
      {
        startTimer();
        if (this.Ety != null) {
          this.Ety.onStart(this.duration);
        }
        this.EtB = -1;
        AppMethodBeat.o(98028);
        return;
        aT(this.EtB, true);
      }
    }
    if (this.EtB > 0) {}
    for (int i = this.EtB;; i = 0)
    {
      aT(i, false);
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean a(PString paramPString);
    
    public abstract void onCompletion();
    
    public abstract void onStart(int paramInt);
    
    public abstract void xv(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView
 * JD-Core Version:    0.7.0.1
 */