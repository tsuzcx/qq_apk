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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class OfflineVideoView
  extends RelativeLayout
  implements f.a
{
  private int aRY = 0;
  private boolean dnJ = false;
  private int duration = 0;
  private ah itx = new ah(Looper.getMainLooper());
  public f iuC;
  private am iuI = new am(new am.a()
  {
    public final boolean tC()
    {
      if (OfflineVideoView.b(OfflineVideoView.this) == null) {
        return false;
      }
      if (((View)OfflineVideoView.b(OfflineVideoView.this)).getAlpha() < 1.0F) {
        OfflineVideoView.this.a(true, 1.0F);
      }
      if (OfflineVideoView.b(OfflineVideoView.this).isPlaying())
      {
        OfflineVideoView.e(OfflineVideoView.this);
        OfflineVideoView localOfflineVideoView = OfflineVideoView.this;
        int i = OfflineVideoView.b(OfflineVideoView.this).getCurrentPosition() / 1000;
        if (localOfflineVideoView.oRj != null) {
          localOfflineVideoView.oRj.yg(i);
        }
      }
      return true;
    }
  }, true);
  private ImageView kga;
  private RelativeLayout kgv;
  private boolean kjQ = false;
  private boolean kjR;
  private ProgressBar kjT;
  private Context mContext = null;
  OfflineVideoView.a oRj;
  private boolean oRk = false;
  private boolean oRl = true;
  private int oRm = -1;
  private f.e oRn = new OfflineVideoView.8(this);
  
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
    this.mContext = paramContext;
    y.i("MicroMsg.OfflineVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(this.mContext).inflate(i.g.sns_video_view, this);
    this.kga = ((ImageView)findViewById(i.f.video_thumb));
    this.kgv = ((RelativeLayout)findViewById(i.f.video_root));
    this.kjT = ((ProgressBar)findViewById(i.f.video_loading));
    if (d.gG(18))
    {
      paramInt = 0;
      if (paramInt == 0) {
        break label264;
      }
      this.kjR = true;
    }
    for (this.iuC = new VideoPlayerTextureView(this.mContext);; this.iuC = new VideoTextureView(this.mContext))
    {
      this.iuC.setVideoCallback(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      this.kgv.addView((View)this.iuC, paramContext);
      a(false, 0.0F);
      return;
      paramInt = 1;
      break;
      label264:
      this.kjR = false;
    }
  }
  
  private void bdC()
  {
    this.itx.post(new OfflineVideoView.6(this));
  }
  
  private void onResume()
  {
    y.d("MicroMsg.OfflineVideoView", "%d on resume %s", new Object[] { Integer.valueOf(hashCode()), bk.csb() });
    if (!this.kjQ) {
      bHJ();
    }
    this.oRk = true;
  }
  
  public final void Df(String paramString)
  {
    y.i("MicroMsg.OfflineVideoView", "%d prepare video  filePath %s", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (bk.bl(paramString)) {
      y.w("MicroMsg.OfflineVideoView", "%d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
    }
    while (this.iuC == null) {
      return;
    }
    this.iuC.setOneTimeVideoTextureUpdateCallback(this.oRn);
    this.iuC.setVideoPath(paramString);
  }
  
  public final void Ph(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    this.itx.post(new OfflineVideoView.1(this, paramString));
  }
  
  public final void X(int paramInt, boolean paramBoolean)
  {
    y.i("MicroMsg.OfflineVideoView", "%d seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    bdC();
    this.iuC.d(paramInt * 1000, paramBoolean);
    startTimer();
  }
  
  public final void Y(int paramInt, boolean paramBoolean)
  {
    y.i("MicroMsg.OfflineVideoView", "%d ui touch seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    X(paramInt, paramBoolean);
    startTimer();
  }
  
  public final void a(boolean paramBoolean, float paramFloat)
  {
    this.itx.post(new OfflineVideoView.4(this, paramBoolean, paramFloat));
  }
  
  public final void bHJ()
  {
    if (this.oRj != null)
    {
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      if (this.oRj.a(localPString1))
      {
        if (!bk.bl(localPString2.value)) {
          Ph(localPString2.value);
        }
        if (!bk.bl(localPString1.value)) {
          Df(localPString1.value);
        }
        return;
      }
      this.itx.post(new OfflineVideoView.5(this));
      a(false, 0.0F);
      return;
    }
    y.w("MicroMsg.OfflineVideoView", "%d toggle video but video callback is null", new Object[] { Integer.valueOf(hashCode()) });
  }
  
  public final void bHK()
  {
    y.i("MicroMsg.OfflineVideoView", "%d pause", new Object[] { Integer.valueOf(hashCode()) });
    y.d("MicroMsg.OfflineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), bk.csb() });
    this.oRl = false;
    if (this.iuC.isPlaying()) {
      this.oRm = (this.iuC.getCurrentPosition() / 1000);
    }
    y.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
    this.iuC.pause();
    bdC();
    this.iuI.stopTimer();
  }
  
  public final void bHL()
  {
    y.i("MicroMsg.OfflineVideoView", "%d start hasResumed[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.oRk) });
    this.oRl = true;
    if (this.oRk) {
      if (!bk.bl(this.iuC.getVideoPath())) {
        if ((this.iuC.start()) && (this.oRj != null)) {
          this.oRj.onStart(this.duration);
        }
      }
    }
    for (;;)
    {
      startTimer();
      return;
      onResume();
      continue;
      onResume();
    }
  }
  
  public final int cv(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void cw(int paramInt1, int paramInt2) {}
  
  public int getCurrentPosition()
  {
    if (this.iuC != null) {
      return this.iuC.getCurrentPosition() / 1000;
    }
    return 0;
  }
  
  public final boolean isPlaying()
  {
    if (this.iuC != null) {
      return this.iuC.isPlaying();
    }
    return false;
  }
  
  public final void kA()
  {
    a(true, 0.0F);
    this.kjQ = false;
    bdC();
    this.duration = (this.iuC.getDuration() / 1000);
    y.i("MicroMsg.OfflineVideoView", "%d on prepared. shouldPlayWhenPrepared [%b] shouldSeekTimeWhenPrepared[%d]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.oRl), Integer.valueOf(this.oRm) });
    if (this.oRl)
    {
      if (this.oRm <= 0) {
        this.iuC.start();
      }
      for (;;)
      {
        startTimer();
        if (this.oRj != null) {
          this.oRj.onStart(this.duration);
        }
        this.oRm = -1;
        return;
        X(this.oRm, true);
      }
    }
    if (this.oRm > 0) {}
    for (int i = this.oRm;; i = 0)
    {
      X(i, false);
      break;
    }
  }
  
  public final void onDestroy()
  {
    y.d("MicroMsg.OfflineVideoView", "%d on destroy %s", new Object[] { Integer.valueOf(hashCode()), bk.csb() });
    y.i("MicroMsg.OfflineVideoView", "%d logic unInit", new Object[] { Integer.valueOf(hashCode()) });
    this.itx.removeCallbacksAndMessages(null);
    this.iuI.stopTimer();
    if (this.iuC != null) {
      this.iuC.stop();
    }
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    y.e("MicroMsg.OfflineVideoView", "%d on play video error what %d extra %d isMMVideoPlayer %b errorCount %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.kjR), Integer.valueOf(this.aRY) });
    this.aRY += 1;
    String str = this.iuC.getVideoPath();
    this.iuC.stop();
    this.kjQ = true;
    a(false, 0.0F);
    if (this.aRY <= 3) {
      this.itx.postDelayed(new OfflineVideoView.2(this, str), 200L);
    }
    while (bk.bl(str)) {
      return;
    }
    y.w("MicroMsg.OfflineVideoView", "%d start third player to play", new Object[] { Integer.valueOf(hashCode()) });
    this.itx.post(new OfflineVideoView.3(this, str));
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.dnJ = paramBoolean;
    this.iuC.setMute(this.dnJ);
  }
  
  public void setVideoCallback(OfflineVideoView.a parama)
  {
    this.oRj = parama;
  }
  
  public final void startTimer()
  {
    this.iuI.S(500L, 500L);
  }
  
  public final void ug()
  {
    y.i("MicroMsg.OfflineVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if (this.oRj == null)
    {
      if ((d.gH(18)) || (!this.kjR)) {
        X(0, true);
      }
      while (this.iuC == null) {
        return;
      }
      String str = this.iuC.getVideoPath();
      this.iuC.stop();
      Df(str);
      return;
    }
    this.oRj.ug();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView
 * JD-Core Version:    0.7.0.1
 */