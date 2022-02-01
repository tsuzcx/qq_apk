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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.pluginsdk.ui.tools.k.c;
import com.tencent.mm.pluginsdk.ui.tools.k.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public class OfflineVideoView
  extends RelativeLayout
  implements k.a
{
  private int JCO;
  private a KGV;
  private boolean KGW;
  protected boolean KGX;
  private int KGY;
  private int KGZ;
  private boolean KHa;
  private k.e KHb;
  private int bpq;
  private int duration;
  private boolean iYs;
  private Context mContext;
  private ProgressBar pDL;
  private MMHandler twz;
  private k txH;
  private MTimerHandler txN;
  private RelativeLayout wPB;
  protected ImageView wPh;
  protected boolean wTx;
  private boolean wTy;
  
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
    this.JCO = 0;
    this.mContext = null;
    this.iYs = false;
    this.wTx = false;
    this.KGW = false;
    this.KGX = true;
    this.KGY = -1;
    this.bpq = 0;
    this.duration = 0;
    this.twz = new MMHandler(Looper.getMainLooper());
    this.KGZ = 1000;
    this.KHa = false;
    this.txN = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(268773);
        if (OfflineVideoView.a(OfflineVideoView.this) == null)
        {
          AppMethodBeat.o(268773);
          return false;
        }
        if (((View)OfflineVideoView.a(OfflineVideoView.this)).getAlpha() < 1.0F) {
          OfflineVideoView.this.d(true, 1.0F);
        }
        if (OfflineVideoView.a(OfflineVideoView.this).isPlaying())
        {
          OfflineVideoView.d(OfflineVideoView.this);
          int i = OfflineVideoView.a(OfflineVideoView.this).getCurrentPosition();
          OfflineVideoView.this.agQ(i);
          if (i / 1000 == 2) {
            Log.i("MicroMsg.OfflineVideoView", "onTimerExpired, curPos=" + i + ", video.alpha=" + OfflineVideoView.b(OfflineVideoView.this).getAlpha() + ", video.visble=" + OfflineVideoView.b(OfflineVideoView.this).getVisibility() + ", thumb.alpha=" + OfflineVideoView.this.wPh.getAlpha() + ", thumb.visble=" + OfflineVideoView.this.wPh.getVisibility());
          }
        }
        for (;;)
        {
          AppMethodBeat.o(268773);
          return true;
          Log.i("MicroMsg.OfflineVideoView", "onTimerExpired, isPlaying=false");
        }
      }
    }, true);
    this.KHb = new k.e()
    {
      public final void bXh()
      {
        AppMethodBeat.i(196942);
        Log.i("MicroMsg.OfflineVideoView", "%d on texture update.", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()) });
        try
        {
          OfflineVideoView.this.d(true, 1.0F);
          AppMethodBeat.o(196942);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.OfflineVideoView", "texture view update. error " + localException.toString());
          AppMethodBeat.o(196942);
        }
      }
    };
    this.mContext = paramContext;
    Log.i("MicroMsg.OfflineVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(this.mContext).inflate(i.g.sns_video_view, this);
    this.wPh = ((ImageView)findViewById(i.f.video_thumb));
    this.wPB = ((RelativeLayout)findViewById(i.f.video_root));
    this.pDL = ((ProgressBar)findViewById(i.f.video_loading));
    if (d.qW(18))
    {
      paramInt = 0;
      if (paramInt == 0) {
        break label291;
      }
      this.wTy = true;
    }
    for (this.txH = new VideoPlayerTextureView(this.mContext);; this.txH = new VideoTextureView(this.mContext))
    {
      this.txH.setVideoCallback(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      this.wPB.addView((View)this.txH, paramContext);
      d(false, 0.0F);
      AppMethodBeat.o(98021);
      return;
      paramInt = 1;
      break;
      label291:
      this.wTy = false;
    }
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(98030);
    this.twz.post(new Runnable()
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
    if (!this.wTx) {
      dmh();
    }
    this.KGW = true;
    AppMethodBeat.o(98023);
  }
  
  public final void aAB(String paramString)
  {
    AppMethodBeat.i(98033);
    Log.i("MicroMsg.OfflineVideoView", "%d prepare video  filePath %s", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.OfflineVideoView", "%d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98033);
      return;
    }
    if (this.txH != null)
    {
      this.txH.setOneTimeVideoTextureUpdateCallback(this.KHb);
      this.txH.setVideoPath(paramString);
    }
    AppMethodBeat.o(98033);
  }
  
  public void agQ(int paramInt)
  {
    AppMethodBeat.i(179150);
    if (this.KGV != null) {
      this.KGV.AS(paramInt);
    }
    AppMethodBeat.o(179150);
  }
  
  public final void bbV(final String paramString)
  {
    AppMethodBeat.i(98025);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(98025);
      return;
    }
    this.twz.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98013);
        if (OfflineVideoView.this.wPh != null)
        {
          Log.i("MicroMsg.OfflineVideoView", "%d fresh thumb image", new Object[] { Integer.valueOf(hashCode()) });
          OfflineVideoView.this.wPh.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile(paramString, 1.0F));
        }
        AppMethodBeat.o(98013);
      }
    });
    AppMethodBeat.o(98025);
  }
  
  public void bc(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(98034);
    Log.i("MicroMsg.OfflineVideoView", "%d seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    hideLoading();
    this.txH.b(paramInt, paramBoolean);
    startTimer();
    AppMethodBeat.o(98034);
  }
  
  public final void bd(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(218059);
    Log.i("MicroMsg.OfflineVideoView", "%d ui touch seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    bc(paramInt, paramBoolean);
    startTimer();
    AppMethodBeat.o(218059);
  }
  
  public void d(final boolean paramBoolean, final float paramFloat)
  {
    AppMethodBeat.i(98027);
    this.twz.post(new Runnable()
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
            OfflineVideoView.this.wPh.setVisibility(8);
            AppMethodBeat.o(98015);
          }
        }
        else
        {
          localView.setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setAlpha(0.0F);
          OfflineVideoView.this.wPh.setVisibility(0);
        }
        AppMethodBeat.o(98015);
      }
    });
    AppMethodBeat.o(98027);
  }
  
  public final void dmh()
  {
    AppMethodBeat.i(98024);
    if (this.KGV != null)
    {
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      if (this.KGV.a(localPString1))
      {
        if (!Util.isNullOrNil(localPString2.value)) {
          bbV(localPString2.value);
        }
        if (!Util.isNullOrNil(localPString1.value))
        {
          aAB(localPString1.value);
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
  
  public final void eM(int paramInt1, int paramInt2) {}
  
  public final int fE(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  protected void fTZ()
  {
    AppMethodBeat.i(179149);
    this.txN.stopTimer();
    AppMethodBeat.o(179149);
  }
  
  public final void fUa()
  {
    AppMethodBeat.i(179151);
    Log.i("MicroMsg.OfflineVideoView", "%d pause", new Object[] { Integer.valueOf(hashCode()) });
    Log.i("MicroMsg.OfflineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    this.KGX = false;
    if (this.txH.isPlaying())
    {
      this.KGY = this.txH.getCurrentPosition();
      Log.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      this.txH.pause();
    }
    hideLoading();
    fTZ();
    AppMethodBeat.o(179151);
  }
  
  public final void fUb()
  {
    AppMethodBeat.i(179152);
    Log.i("MicroMsg.OfflineVideoView", "%d start hasResumed[%b], curPos [%d], duration [%d], shouldSeek [%d]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.KGW), Integer.valueOf(this.txH.getCurrentPosition()), Integer.valueOf(this.txH.getDuration()), Integer.valueOf(this.KGY) });
    this.KGX = true;
    if (this.KGW) {
      if (!Util.isNullOrNil(this.txH.getVideoPath())) {
        if (this.txH.getCurrentPosition() >= this.txH.getDuration())
        {
          this.txH.b(0.0D, true);
          if (this.KGV != null) {
            this.KGV.onStart(this.duration);
          }
        }
      }
    }
    for (;;)
    {
      startTimer();
      AppMethodBeat.o(179152);
      return;
      this.txH.start();
      continue;
      onResume();
      continue;
      onResume();
    }
  }
  
  public final boolean fUc()
  {
    AppMethodBeat.i(179154);
    if ((this.txH instanceof VideoPlayerTextureView))
    {
      if ((((VideoPlayerTextureView)this.txH).hnO()) && (isPlaying()))
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
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(98035);
    if (this.txH != null)
    {
      int i = this.txH.getCurrentPosition() / 1000;
      AppMethodBeat.o(98035);
      return i;
    }
    AppMethodBeat.o(98035);
    return 0;
  }
  
  public int getCurrentPositionMs()
  {
    AppMethodBeat.i(98036);
    if (this.txH != null)
    {
      int i = this.txH.getCurrentPosition();
      AppMethodBeat.o(98036);
      return i;
    }
    AppMethodBeat.o(98036);
    return 0;
  }
  
  public int getDurationMs()
  {
    AppMethodBeat.i(98037);
    if (this.txH != null)
    {
      int i = this.txH.getDuration();
      AppMethodBeat.o(98037);
      return i;
    }
    AppMethodBeat.o(98037);
    return 0;
  }
  
  public View getInnerVideoView()
  {
    if ((this.txH instanceof View)) {
      return (View)this.txH;
    }
    return null;
  }
  
  public int getTimerInterval()
  {
    return this.KGZ;
  }
  
  public String getVideoPath()
  {
    AppMethodBeat.i(179155);
    if (this.txH != null)
    {
      String str = this.txH.getVideoPath();
      AppMethodBeat.o(179155);
      return str;
    }
    AppMethodBeat.o(179155);
    return "";
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(179153);
    if (this.txH != null)
    {
      boolean bool = this.txH.isPlaying();
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
    if (this.KGV == null)
    {
      if ((d.qX(18)) || (!this.wTy))
      {
        bc(0, true);
        AppMethodBeat.o(98032);
        return;
      }
      if (this.txH != null)
      {
        String str = this.txH.getVideoPath();
        this.txH.stop();
        aAB(str);
        AppMethodBeat.o(98032);
      }
    }
    else
    {
      this.KGV.onCompletion();
    }
    AppMethodBeat.o(98032);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179148);
    Log.d("MicroMsg.OfflineVideoView", "%d on destroy %s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    Log.i("MicroMsg.OfflineVideoView", "%d logic unInit", new Object[] { Integer.valueOf(hashCode()) });
    this.twz.removeCallbacksAndMessages(null);
    fTZ();
    if (this.txH != null) {
      this.txH.stop();
    }
    AppMethodBeat.o(179148);
  }
  
  public void onError(int paramInt1, int paramInt2)
  {
    int i = 2;
    AppMethodBeat.i(98026);
    Log.e("MicroMsg.OfflineVideoView", "%d on play video error what %d extra %d isMMVideoPlayer %b errorCount %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.wTy), Integer.valueOf(this.bpq) });
    this.bpq += 1;
    final String str1 = this.txH.getVideoPath();
    this.txH.stop();
    this.wTx = true;
    d(false, 0.0F);
    if (this.bpq <= 3)
    {
      this.twz.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98014);
          OfflineVideoView.this.aAB(str1);
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
        if (u.agG(str1))
        {
          l = u.bBQ(str1);
          boolean bool = u.deleteFile(str1);
          Log.i("MicroMsg.OfflineVideoView", "onError, fileLen=" + l + ", delRet=" + bool);
          paramInt1 = 1;
          if (!this.KHa) {
            if (!this.wTy) {
              break label316;
            }
          }
        }
      }
      label316:
      for (str1 = "1";; str1 = "0")
      {
        String str2 = getClass().getSimpleName();
        l.a(l.JQF, str1, paramInt1, (int)l, str2);
        this.KHa = true;
        if (this.JCO == 1) {
          h.IzE.el(1579, 9);
        }
        AppMethodBeat.o(98026);
        return;
        Log.e("MicroMsg.OfflineVideoView", "onError, file not exists");
        l = -1L;
        paramInt1 = i;
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
    if (this.txH.isPlaying())
    {
      this.KGY = this.txH.getCurrentPosition();
      Log.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      this.txH.pause();
    }
    AppMethodBeat.o(179146);
  }
  
  public void qX()
  {
    AppMethodBeat.i(98028);
    d(true, 0.0F);
    this.wTx = false;
    hideLoading();
    this.duration = (this.txH.getDuration() / 1000);
    Log.i("MicroMsg.OfflineVideoView", "%d on prepared. shouldPlayWhenPrepared [%b] shouldSeekTimeWhenPrepared[%d]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.KGX), Integer.valueOf(this.KGY) });
    if (this.KGX)
    {
      if (this.KGY <= 0) {
        this.txH.start();
      }
      for (;;)
      {
        startTimer();
        if (this.KGV != null) {
          this.KGV.onStart(this.duration);
        }
        this.KGY = -1;
        AppMethodBeat.o(98028);
        return;
        bc(this.KGY, true);
      }
    }
    if (this.KGY > 0) {}
    for (int i = this.KGY;; i = 0)
    {
      bc(i, false);
      break;
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(98022);
    this.iYs = paramBoolean;
    this.txH.setMute(this.iYs);
    AppMethodBeat.o(98022);
  }
  
  public void setOnSeekCompleteCallback(k.c paramc)
  {
    AppMethodBeat.i(218076);
    if (this.txH != null) {
      this.txH.setOnSeekCompleteCallback(paramc);
    }
    AppMethodBeat.o(218076);
  }
  
  public void setSource(int paramInt)
  {
    this.JCO = paramInt;
  }
  
  public void setTimerInterval(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 200) {
      i = 200;
    }
    this.KGZ = i;
  }
  
  public void setVideoCallback(a parama)
  {
    this.KGV = parama;
  }
  
  protected void showLoading()
  {
    AppMethodBeat.i(98029);
    this.twz.post(new Runnable()
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
    Log.i("MicroMsg.OfflineVideoView", "%d start curPos [%d], duration [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.txH.getCurrentPosition()), Integer.valueOf(this.txH.getDuration()) });
    if (!Util.isNullOrNil(this.txH.getVideoPath()))
    {
      if (this.txH.getCurrentPosition() < this.txH.getDuration()) {
        break label136;
      }
      this.txH.b(0.0D, true);
      if (this.KGV != null) {
        this.KGV.onStart(this.duration);
      }
    }
    for (;;)
    {
      startTimer();
      AppMethodBeat.o(179147);
      return;
      label136:
      this.txH.start();
    }
  }
  
  public void startTimer()
  {
    AppMethodBeat.i(98031);
    this.txN.startTimer(this.KGZ);
    AppMethodBeat.o(98031);
  }
  
  public static abstract interface a
  {
    public abstract void AS(int paramInt);
    
    public abstract boolean a(PString paramPString);
    
    public abstract void onCompletion();
    
    public abstract void onStart(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView
 * JD-Core Version:    0.7.0.1
 */