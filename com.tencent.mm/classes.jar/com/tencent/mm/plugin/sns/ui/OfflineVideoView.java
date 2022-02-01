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
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.pluginsdk.ui.tools.i.c;
import com.tencent.mm.pluginsdk.ui.tools.i.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public class OfflineVideoView
  extends RelativeLayout
  implements i.a
{
  protected ImageView AlJ;
  private RelativeLayout Amd;
  protected boolean Aqa;
  private boolean Aqb;
  private boolean RgA;
  private i.e RgB;
  private a Rgv;
  private boolean Rgw;
  protected boolean Rgx;
  private int Rgy;
  private int Rgz;
  private int diT;
  private int duration;
  private boolean lAj;
  private Context mContext;
  private ProgressBar sIX;
  private MMHandler wAW;
  private i wCd;
  private MTimerHandler wCj;
  private int xOq;
  
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
    this.xOq = 0;
    this.mContext = null;
    this.lAj = false;
    this.Aqa = false;
    this.Rgw = false;
    this.Rgx = true;
    this.Rgy = -1;
    this.diT = 0;
    this.duration = 0;
    this.wAW = new MMHandler(Looper.getMainLooper());
    this.Rgz = 1000;
    this.RgA = false;
    this.wCj = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(308553);
        if (OfflineVideoView.a(OfflineVideoView.this) == null)
        {
          AppMethodBeat.o(308553);
          return false;
        }
        if (((View)OfflineVideoView.a(OfflineVideoView.this)).getAlpha() < 1.0F) {
          OfflineVideoView.this.d(true, 1.0F);
        }
        if (OfflineVideoView.a(OfflineVideoView.this).isPlaying())
        {
          OfflineVideoView.d(OfflineVideoView.this);
          int i = OfflineVideoView.a(OfflineVideoView.this).getCurrentPosition();
          OfflineVideoView.this.alJ(i);
          if (i / 1000 == 2) {
            Log.i("MicroMsg.OfflineVideoView", "onTimerExpired, curPos=" + i + ", video.alpha=" + OfflineVideoView.b(OfflineVideoView.this).getAlpha() + ", video.visble=" + OfflineVideoView.b(OfflineVideoView.this).getVisibility() + ", thumb.alpha=" + OfflineVideoView.this.AlJ.getAlpha() + ", thumb.visble=" + OfflineVideoView.this.AlJ.getVisibility());
          }
        }
        for (;;)
        {
          AppMethodBeat.o(308553);
          return true;
          Log.i("MicroMsg.OfflineVideoView", "onTimerExpired, isPlaying=false");
        }
      }
    }, true);
    this.RgB = new i.e()
    {
      public final void onTextureUpdate()
      {
        AppMethodBeat.i(308551);
        Log.i("MicroMsg.OfflineVideoView", "%d on texture update.", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()) });
        try
        {
          OfflineVideoView.this.d(true, 1.0F);
          AppMethodBeat.o(308551);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.OfflineVideoView", "texture view update. error " + localException.toString());
          AppMethodBeat.o(308551);
        }
      }
    };
    this.mContext = paramContext;
    Log.i("MicroMsg.OfflineVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(this.mContext).inflate(b.g.sns_video_view, this);
    this.AlJ = ((ImageView)findViewById(b.f.video_thumb));
    this.Amd = ((RelativeLayout)findViewById(b.f.video_root));
    this.sIX = ((ProgressBar)findViewById(b.f.video_loading));
    if (d.rc(18))
    {
      paramInt = 0;
      if (paramInt == 0) {
        break label291;
      }
      this.Aqb = true;
    }
    for (this.wCd = new VideoPlayerTextureView(this.mContext);; this.wCd = new VideoTextureView(this.mContext))
    {
      this.wCd.setVideoCallback(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      this.Amd.addView((View)this.wCd, paramContext);
      d(false, 0.0F);
      AppMethodBeat.o(98021);
      return;
      paramInt = 1;
      break;
      label291:
      this.Aqb = false;
    }
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(98030);
    this.wAW.post(new Runnable()
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
    if (!this.Aqa) {
      dSY();
    }
    this.Rgw = true;
    AppMethodBeat.o(98023);
  }
  
  public void Qz()
  {
    AppMethodBeat.i(98028);
    d(true, 0.0F);
    this.Aqa = false;
    hideLoading();
    this.duration = (this.wCd.getDuration() / 1000);
    Log.i("MicroMsg.OfflineVideoView", "%d on prepared. shouldPlayWhenPrepared [%b] shouldSeekTimeWhenPrepared[%d]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.Rgx), Integer.valueOf(this.Rgy) });
    if (this.Rgx)
    {
      if (this.Rgy <= 0) {
        this.wCd.start();
      }
      for (;;)
      {
        startTimer();
        if (this.Rgv != null) {
          this.Rgv.onStart(this.duration);
        }
        this.Rgy = -1;
        AppMethodBeat.o(98028);
        return;
        bJ(this.Rgy, true);
      }
    }
    if (this.Rgy > 0) {}
    for (int i = this.Rgy;; i = 0)
    {
      bJ(i, false);
      break;
    }
  }
  
  public void alJ(int paramInt)
  {
    AppMethodBeat.i(179150);
    if (this.Rgv != null) {
      this.Rgv.Bh(paramInt);
    }
    AppMethodBeat.o(179150);
  }
  
  public final void auJ(String paramString)
  {
    AppMethodBeat.i(98033);
    Log.i("MicroMsg.OfflineVideoView", "%d prepare video  filePath %s", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.OfflineVideoView", "%d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98033);
      return;
    }
    if (this.wCd != null)
    {
      this.wCd.setOneTimeVideoTextureUpdateCallback(this.RgB);
      this.wCd.setVideoPath(paramString);
    }
    AppMethodBeat.o(98033);
  }
  
  public void bJ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(98034);
    Log.i("MicroMsg.OfflineVideoView", "%d seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    hideLoading();
    this.wCd.c(paramInt, paramBoolean);
    startTimer();
    AppMethodBeat.o(98034);
  }
  
  public final void bK(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(307615);
    Log.i("MicroMsg.OfflineVideoView", "%d ui touch seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    bJ(paramInt, paramBoolean);
    startTimer();
    AppMethodBeat.o(307615);
  }
  
  public final void bax(final String paramString)
  {
    AppMethodBeat.i(98025);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(98025);
      return;
    }
    this.wAW.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98013);
        if (OfflineVideoView.this.AlJ != null)
        {
          Log.i("MicroMsg.OfflineVideoView", "%d fresh thumb image", new Object[] { Integer.valueOf(hashCode()) });
          OfflineVideoView.this.AlJ.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile(paramString, 1.0F));
        }
        AppMethodBeat.o(98013);
      }
    });
    AppMethodBeat.o(98025);
  }
  
  public void d(final boolean paramBoolean, final float paramFloat)
  {
    AppMethodBeat.i(98027);
    this.wAW.post(new Runnable()
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
            OfflineVideoView.this.AlJ.setVisibility(8);
            AppMethodBeat.o(98015);
            return;
          }
          if (paramFloat == 0.0D)
          {
            OfflineVideoView.this.AlJ.setVisibility(0);
            AppMethodBeat.o(98015);
          }
        }
        else
        {
          localView.setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setAlpha(0.0F);
          OfflineVideoView.this.AlJ.setVisibility(0);
        }
        AppMethodBeat.o(98015);
      }
    });
    AppMethodBeat.o(98027);
  }
  
  public final void dSY()
  {
    AppMethodBeat.i(98024);
    if (this.Rgv != null)
    {
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      if (this.Rgv.a(localPString1))
      {
        if (!Util.isNullOrNil(localPString2.value)) {
          bax(localPString2.value);
        }
        if (!Util.isNullOrNil(localPString1.value))
        {
          auJ(localPString1.value);
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
  
  public final void fG(int paramInt1, int paramInt2) {}
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(98035);
    if (this.wCd != null)
    {
      int i = this.wCd.getCurrentPosition() / 1000;
      AppMethodBeat.o(98035);
      return i;
    }
    AppMethodBeat.o(98035);
    return 0;
  }
  
  public int getCurrentPositionMs()
  {
    AppMethodBeat.i(98036);
    if (this.wCd != null)
    {
      int i = this.wCd.getCurrentPosition();
      AppMethodBeat.o(98036);
      return i;
    }
    AppMethodBeat.o(98036);
    return 0;
  }
  
  public int getDurationMs()
  {
    AppMethodBeat.i(98037);
    if (this.wCd != null)
    {
      int i = this.wCd.getDuration();
      AppMethodBeat.o(98037);
      return i;
    }
    AppMethodBeat.o(98037);
    return 0;
  }
  
  public View getInnerVideoView()
  {
    if ((this.wCd instanceof View)) {
      return (View)this.wCd;
    }
    return null;
  }
  
  public int getTimerInterval()
  {
    return this.Rgz;
  }
  
  public String getVideoPath()
  {
    AppMethodBeat.i(179155);
    if (this.wCd != null)
    {
      String str = this.wCd.getVideoPath();
      AppMethodBeat.o(179155);
      return str;
    }
    AppMethodBeat.o(179155);
    return "";
  }
  
  public final int gw(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  protected void hmt()
  {
    AppMethodBeat.i(179149);
    this.wCj.stopTimer();
    AppMethodBeat.o(179149);
  }
  
  public final void hmu()
  {
    AppMethodBeat.i(179151);
    Log.i("MicroMsg.OfflineVideoView", "%d pause", new Object[] { Integer.valueOf(hashCode()) });
    Log.i("MicroMsg.OfflineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    this.Rgx = false;
    if (this.wCd.isPlaying())
    {
      this.Rgy = this.wCd.getCurrentPosition();
      Log.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      this.wCd.pause();
    }
    hideLoading();
    hmt();
    AppMethodBeat.o(179151);
  }
  
  public final void hmv()
  {
    AppMethodBeat.i(179152);
    Log.i("MicroMsg.OfflineVideoView", "%d start hasResumed[%b], curPos [%d], duration [%d], shouldSeek [%d]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.Rgw), Integer.valueOf(this.wCd.getCurrentPosition()), Integer.valueOf(this.wCd.getDuration()), Integer.valueOf(this.Rgy) });
    this.Rgx = true;
    if (this.Rgw) {
      if (!Util.isNullOrNil(this.wCd.getVideoPath())) {
        if (this.wCd.getCurrentPosition() >= this.wCd.getDuration())
        {
          this.wCd.c(0.0D, true);
          if (this.Rgv != null) {
            this.Rgv.onStart(this.duration);
          }
        }
      }
    }
    for (;;)
    {
      startTimer();
      AppMethodBeat.o(179152);
      return;
      this.wCd.start();
      continue;
      onResume();
      continue;
      onResume();
    }
  }
  
  public final boolean hmw()
  {
    AppMethodBeat.i(179154);
    if ((this.wCd instanceof VideoPlayerTextureView))
    {
      if ((((VideoPlayerTextureView)this.wCd).iOH()) && (isPlaying()))
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
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(179153);
    if (this.wCd != null)
    {
      boolean bool = this.wCd.isPlaying();
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
    if (this.Rgv == null)
    {
      if ((d.rd(18)) || (!this.Aqb))
      {
        bJ(0, true);
        AppMethodBeat.o(98032);
        return;
      }
      if (this.wCd != null)
      {
        String str = this.wCd.getVideoPath();
        this.wCd.stop();
        auJ(str);
        AppMethodBeat.o(98032);
      }
    }
    else
    {
      this.Rgv.onCompletion();
    }
    AppMethodBeat.o(98032);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179148);
    Log.d("MicroMsg.OfflineVideoView", "%d on destroy %s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    Log.i("MicroMsg.OfflineVideoView", "%d logic unInit", new Object[] { Integer.valueOf(hashCode()) });
    this.wAW.removeCallbacksAndMessages(null);
    hmt();
    if (this.wCd != null) {
      this.wCd.stop();
    }
    AppMethodBeat.o(179148);
  }
  
  public void onError(int paramInt1, int paramInt2)
  {
    int i = 3;
    AppMethodBeat.i(98026);
    Log.e("MicroMsg.OfflineVideoView", "%d on play video error what %d extra %d isMMVideoPlayer %b errorCount %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.Aqb), Integer.valueOf(this.diT) });
    this.diT += 1;
    final String str1 = this.wCd.getVideoPath();
    this.wCd.stop();
    this.Aqa = true;
    d(false, 0.0F);
    if (this.diT <= 3)
    {
      this.wAW.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98014);
          OfflineVideoView.this.auJ(str1);
          AppMethodBeat.o(98014);
        }
      }, 200L);
      AppMethodBeat.o(98026);
      return;
    }
    for (;;)
    {
      try
      {
        if (Util.isNullOrNil(str1)) {
          break label333;
        }
        if (y.ZC(str1))
        {
          l = y.bEl(str1);
          boolean bool = y.deleteFile(str1);
          Log.i("MicroMsg.OfflineVideoView", "onError, fileLen=" + l + ", delRet=" + bool);
          paramInt1 = 1;
          if (!this.RgA)
          {
            if (!this.Aqb) {
              break label377;
            }
            str1 = "1";
            String str3 = getClass().getSimpleName();
            l.a(l.Qnl, str1, paramInt1, (int)l, str3);
            this.RgA = true;
          }
          if (this.xOq != 1) {
            break label351;
          }
          h.OAn.kJ(1579, 9);
          AppMethodBeat.o(98026);
          return;
        }
      }
      finally
      {
        Log.e("MicroMsg.OfflineVideoView", "onError, exp=" + localObject.toString());
        AppMethodBeat.o(98026);
        return;
      }
      Log.e("MicroMsg.OfflineVideoView", "onError, file not exists");
      long l = -1L;
      paramInt1 = 2;
      continue;
      label333:
      Log.e("MicroMsg.OfflineVideoView", "onError, filepath==null");
      l = -1L;
      paramInt1 = i;
      continue;
      label351:
      if (this.xOq == 2) {
        h.OAn.kJ(1579, 16);
      }
      AppMethodBeat.o(98026);
      return;
      label377:
      String str2 = "0";
    }
  }
  
  public void pause()
  {
    AppMethodBeat.i(179146);
    Log.i("MicroMsg.OfflineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    if (this.wCd.isPlaying())
    {
      this.Rgy = this.wCd.getCurrentPosition();
      Log.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      this.wCd.pause();
    }
    AppMethodBeat.o(179146);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(98022);
    this.lAj = paramBoolean;
    this.wCd.setMute(this.lAj);
    AppMethodBeat.o(98022);
  }
  
  public void setOnSeekCompleteCallback(i.c paramc)
  {
    AppMethodBeat.i(307638);
    if (this.wCd != null) {
      this.wCd.setOnSeekCompleteCallback(paramc);
    }
    AppMethodBeat.o(307638);
  }
  
  public void setSource(int paramInt)
  {
    this.xOq = paramInt;
  }
  
  public void setTimerInterval(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 200) {
      i = 200;
    }
    this.Rgz = i;
  }
  
  public void setVideoCallback(a parama)
  {
    this.Rgv = parama;
  }
  
  protected void showLoading()
  {
    AppMethodBeat.i(98029);
    this.wAW.post(new Runnable()
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
    Log.i("MicroMsg.OfflineVideoView", "%d start curPos [%d], duration [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.wCd.getCurrentPosition()), Integer.valueOf(this.wCd.getDuration()) });
    if (!Util.isNullOrNil(this.wCd.getVideoPath()))
    {
      if (this.wCd.getCurrentPosition() < this.wCd.getDuration()) {
        break label136;
      }
      this.wCd.c(0.0D, true);
      if (this.Rgv != null) {
        this.Rgv.onStart(this.duration);
      }
    }
    for (;;)
    {
      startTimer();
      AppMethodBeat.o(179147);
      return;
      label136:
      this.wCd.start();
    }
  }
  
  public void startTimer()
  {
    AppMethodBeat.i(98031);
    this.wCj.startTimer(this.Rgz);
    AppMethodBeat.o(98031);
  }
  
  public static abstract interface a
  {
    public abstract void Bh(int paramInt);
    
    public abstract boolean a(PString paramPString);
    
    public abstract void onCompletion();
    
    public abstract void onStart(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView
 * JD-Core Version:    0.7.0.1
 */