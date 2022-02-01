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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;

public class OfflineVideoView
  extends RelativeLayout
  implements h.a
{
  private int bvh;
  private int duration;
  private boolean ftN;
  private ProgressBar kWd;
  private Context mContext;
  private ao ocT;
  private h odZ;
  private au oef;
  protected ImageView qQT;
  private RelativeLayout qRo;
  protected boolean qUP;
  private boolean qUQ;
  private a yCl;
  private boolean yCm;
  protected boolean yCn;
  private int yCo;
  private int yCp;
  private h.e yCq;
  
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
    this.ftN = false;
    this.qUP = false;
    this.yCm = false;
    this.yCn = true;
    this.yCo = -1;
    this.bvh = 0;
    this.duration = 0;
    this.ocT = new ao(Looper.getMainLooper());
    this.yCp = 1000;
    this.oef = new au(new au.a()
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
          OfflineVideoView.this.c(true, 1.0F);
        }
        if (OfflineVideoView.a(OfflineVideoView.this).isPlaying())
        {
          OfflineVideoView.d(OfflineVideoView.this);
          OfflineVideoView.this.Po(OfflineVideoView.a(OfflineVideoView.this).getCurrentPosition());
        }
        AppMethodBeat.o(98019);
        return true;
      }
    }, true);
    this.yCq = new h.e()
    {
      public final void bli()
      {
        AppMethodBeat.i(98020);
        ac.i("MicroMsg.OfflineVideoView", "%d on texture update.", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()) });
        try
        {
          OfflineVideoView.this.c(true, 1.0F);
          AppMethodBeat.o(98020);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.OfflineVideoView", "texture view update. error " + localException.toString());
          AppMethodBeat.o(98020);
        }
      }
    };
    this.mContext = paramContext;
    ac.i("MicroMsg.OfflineVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(this.mContext).inflate(2131495624, this);
    this.qQT = ((ImageView)findViewById(2131306398));
    this.qRo = ((RelativeLayout)findViewById(2131306392));
    this.kWd = ((ProgressBar)findViewById(2131306352));
    if (d.la(18))
    {
      paramInt = 0;
      if (paramInt == 0) {
        break label277;
      }
      this.qUQ = true;
    }
    for (this.odZ = new VideoPlayerTextureView(this.mContext);; this.odZ = new VideoTextureView(this.mContext))
    {
      this.odZ.setVideoCallback(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      this.qRo.addView((View)this.odZ, paramContext);
      c(false, 0.0F);
      AppMethodBeat.o(98021);
      return;
      paramInt = 1;
      break;
      label277:
      this.qUQ = false;
    }
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(98030);
    this.ocT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98018);
        if ((OfflineVideoView.c(OfflineVideoView.this) != null) && (OfflineVideoView.c(OfflineVideoView.this).getVisibility() != 8))
        {
          ac.i("MicroMsg.OfflineVideoView", "%d hide loading.", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()) });
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
    ac.d("MicroMsg.OfflineVideoView", "%d on resume %s", new Object[] { Integer.valueOf(hashCode()), bs.eWi() });
    if (!this.qUP) {
      crJ();
    }
    this.yCm = true;
    AppMethodBeat.o(98023);
  }
  
  public void Po(int paramInt)
  {
    AppMethodBeat.i(179150);
    if (this.yCl != null) {
      this.yCl.sQ(paramInt);
    }
    AppMethodBeat.o(179150);
  }
  
  public final void ade(String paramString)
  {
    AppMethodBeat.i(98033);
    ac.i("MicroMsg.OfflineVideoView", "%d prepare video  filePath %s", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.OfflineVideoView", "%d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98033);
      return;
    }
    if (this.odZ != null)
    {
      this.odZ.setOneTimeVideoTextureUpdateCallback(this.yCq);
      this.odZ.setVideoPath(paramString);
    }
    AppMethodBeat.o(98033);
  }
  
  public final void avC(final String paramString)
  {
    AppMethodBeat.i(98025);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(98025);
      return;
    }
    this.ocT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98013);
        if (OfflineVideoView.this.qQT != null)
        {
          ac.i("MicroMsg.OfflineVideoView", "%d fresh thumb image", new Object[] { Integer.valueOf(hashCode()) });
          OfflineVideoView.this.qQT.setImageBitmap(BackwardSupportUtil.b.n(paramString, 1.0F));
        }
        AppMethodBeat.o(98013);
      }
    });
    AppMethodBeat.o(98025);
  }
  
  public void aw(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(98034);
    ac.i("MicroMsg.OfflineVideoView", "%d seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    hideLoading();
    this.odZ.d(paramInt, paramBoolean);
    startTimer();
    AppMethodBeat.o(98034);
  }
  
  public final void ax(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(200373);
    ac.i("MicroMsg.OfflineVideoView", "%d ui touch seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    aw(paramInt, paramBoolean);
    startTimer();
    AppMethodBeat.o(200373);
  }
  
  public void c(final boolean paramBoolean, final float paramFloat)
  {
    AppMethodBeat.i(98027);
    this.ocT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98016);
        ac.i("MicroMsg.OfflineVideoView", "%d switch video model isVideoPlay %b %f", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
        View localView = (View)OfflineVideoView.a(OfflineVideoView.this);
        if (paramBoolean)
        {
          localView.setAlpha(paramFloat);
          localView.setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setAlpha(paramFloat);
          if (paramFloat >= 1.0D)
          {
            OfflineVideoView.this.qQT.setVisibility(8);
            AppMethodBeat.o(98016);
          }
        }
        else
        {
          localView.setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setAlpha(0.0F);
          OfflineVideoView.this.qQT.setVisibility(0);
        }
        AppMethodBeat.o(98016);
      }
    });
    AppMethodBeat.o(98027);
  }
  
  public final void crJ()
  {
    AppMethodBeat.i(98024);
    if (this.yCl != null)
    {
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      if (this.yCl.a(localPString1))
      {
        if (!bs.isNullOrNil(localPString2.value)) {
          avC(localPString2.value);
        }
        if (!bs.isNullOrNil(localPString1.value))
        {
          ade(localPString1.value);
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
    ac.w("MicroMsg.OfflineVideoView", "%d toggle video but video callback is null", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(98024);
  }
  
  protected void dNR()
  {
    AppMethodBeat.i(179149);
    this.oef.stopTimer();
    AppMethodBeat.o(179149);
  }
  
  public final void dNS()
  {
    AppMethodBeat.i(179151);
    ac.i("MicroMsg.OfflineVideoView", "%d pause", new Object[] { Integer.valueOf(hashCode()) });
    ac.i("MicroMsg.OfflineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), bs.eWi() });
    this.yCn = false;
    if (this.odZ.isPlaying())
    {
      this.yCo = this.odZ.getCurrentPosition();
      ac.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      this.odZ.pause();
    }
    hideLoading();
    dNR();
    AppMethodBeat.o(179151);
  }
  
  public final void dNT()
  {
    AppMethodBeat.i(179152);
    ac.i("MicroMsg.OfflineVideoView", "%d start hasResumed[%b], curPos [%d], duration [%d], shouldSeek [%d]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.yCm), Integer.valueOf(this.odZ.getCurrentPosition()), Integer.valueOf(this.odZ.getDuration()), Integer.valueOf(this.yCo) });
    this.yCn = true;
    if (this.yCm) {
      if (!bs.isNullOrNil(this.odZ.getVideoPath())) {
        if (this.odZ.getCurrentPosition() >= this.odZ.getDuration())
        {
          this.odZ.d(0.0D, true);
          if (this.yCl != null) {
            this.yCl.onStart(this.duration);
          }
        }
      }
    }
    for (;;)
    {
      startTimer();
      AppMethodBeat.o(179152);
      return;
      this.odZ.start();
      continue;
      onResume();
      continue;
      onResume();
    }
  }
  
  public final boolean dNU()
  {
    AppMethodBeat.i(179154);
    if ((this.odZ instanceof VideoPlayerTextureView))
    {
      if ((((VideoPlayerTextureView)this.odZ).eQo()) && (isPlaying()))
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
  
  public final void dZ(int paramInt1, int paramInt2) {}
  
  public final int eP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(98035);
    if (this.odZ != null)
    {
      int i = this.odZ.getCurrentPosition() / 1000;
      AppMethodBeat.o(98035);
      return i;
    }
    AppMethodBeat.o(98035);
    return 0;
  }
  
  public int getCurrentPositionMs()
  {
    AppMethodBeat.i(98036);
    if (this.odZ != null)
    {
      int i = this.odZ.getCurrentPosition();
      AppMethodBeat.o(98036);
      return i;
    }
    AppMethodBeat.o(98036);
    return 0;
  }
  
  public int getDurationMs()
  {
    AppMethodBeat.i(98037);
    if (this.odZ != null)
    {
      int i = this.odZ.getDuration();
      AppMethodBeat.o(98037);
      return i;
    }
    AppMethodBeat.o(98037);
    return 0;
  }
  
  public View getInnerVideoView()
  {
    if ((this.odZ instanceof View)) {
      return (View)this.odZ;
    }
    return null;
  }
  
  public int getTimerInterval()
  {
    return this.yCp;
  }
  
  public String getVideoPath()
  {
    AppMethodBeat.i(179155);
    if (this.odZ != null)
    {
      String str = this.odZ.getVideoPath();
      AppMethodBeat.o(179155);
      return str;
    }
    AppMethodBeat.o(179155);
    return "";
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(179153);
    if (this.odZ != null)
    {
      boolean bool = this.odZ.isPlaying();
      AppMethodBeat.o(179153);
      return bool;
    }
    AppMethodBeat.o(179153);
    return false;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(98032);
    ac.i("MicroMsg.OfflineVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if (this.yCl == null)
    {
      if ((d.lb(18)) || (!this.qUQ))
      {
        aw(0, true);
        AppMethodBeat.o(98032);
        return;
      }
      if (this.odZ != null)
      {
        String str = this.odZ.getVideoPath();
        this.odZ.stop();
        ade(str);
        AppMethodBeat.o(98032);
      }
    }
    else
    {
      this.yCl.onCompletion();
    }
    AppMethodBeat.o(98032);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179148);
    ac.d("MicroMsg.OfflineVideoView", "%d on destroy %s", new Object[] { Integer.valueOf(hashCode()), bs.eWi() });
    ac.i("MicroMsg.OfflineVideoView", "%d logic unInit", new Object[] { Integer.valueOf(hashCode()) });
    this.ocT.removeCallbacksAndMessages(null);
    dNR();
    if (this.odZ != null) {
      this.odZ.stop();
    }
    AppMethodBeat.o(179148);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98026);
    ac.e("MicroMsg.OfflineVideoView", "%d on play video error what %d extra %d isMMVideoPlayer %b errorCount %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.qUQ), Integer.valueOf(this.bvh) });
    this.bvh += 1;
    final String str1 = this.odZ.getVideoPath();
    this.odZ.stop();
    this.qUP = true;
    c(false, 0.0F);
    if (this.bvh <= 3)
    {
      this.ocT.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98014);
          OfflineVideoView.this.ade(str1);
          AppMethodBeat.o(98014);
        }
      }, 200L);
      AppMethodBeat.o(98026);
      return;
    }
    if (!bs.isNullOrNil(str1))
    {
      ac.w("MicroMsg.OfflineVideoView", "%d start third player to play", new Object[] { Integer.valueOf(hashCode()) });
      this.ocT.post(new OfflineVideoView.3(this, str1));
      if (!this.qUQ) {
        break label221;
      }
    }
    label221:
    for (str1 = "1";; str1 = "0")
    {
      String str2 = getClass().getName();
      i.b(i.xNd, str1, paramInt1, paramInt2, str2);
      AppMethodBeat.o(98026);
      return;
    }
  }
  
  public void pause()
  {
    AppMethodBeat.i(179146);
    ac.i("MicroMsg.OfflineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), bs.eWi() });
    if (this.odZ.isPlaying())
    {
      this.yCo = this.odZ.getCurrentPosition();
      ac.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      this.odZ.pause();
    }
    AppMethodBeat.o(179146);
  }
  
  public void rB()
  {
    AppMethodBeat.i(98028);
    c(true, 0.0F);
    this.qUP = false;
    hideLoading();
    this.duration = (this.odZ.getDuration() / 1000);
    ac.i("MicroMsg.OfflineVideoView", "%d on prepared. shouldPlayWhenPrepared [%b] shouldSeekTimeWhenPrepared[%d]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.yCn), Integer.valueOf(this.yCo) });
    if (this.yCn)
    {
      if (this.yCo <= 0) {
        this.odZ.start();
      }
      for (;;)
      {
        startTimer();
        if (this.yCl != null) {
          this.yCl.onStart(this.duration);
        }
        this.yCo = -1;
        AppMethodBeat.o(98028);
        return;
        aw(this.yCo, true);
      }
    }
    if (this.yCo > 0) {}
    for (int i = this.yCo;; i = 0)
    {
      aw(i, false);
      break;
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(98022);
    this.ftN = paramBoolean;
    this.odZ.setMute(this.ftN);
    AppMethodBeat.o(98022);
  }
  
  public void setTimerInterval(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 200) {
      i = 200;
    }
    this.yCp = i;
  }
  
  public void setVideoCallback(a parama)
  {
    this.yCl = parama;
  }
  
  protected void showLoading()
  {
    AppMethodBeat.i(98029);
    this.ocT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98017);
        ac.i("MicroMsg.OfflineVideoView", "%d show loading. downloadMode %d", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()), Integer.valueOf(OfflineVideoView.this.hashCode()) });
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
    ac.i("MicroMsg.OfflineVideoView", "%d start curPos [%d], duration [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.odZ.getCurrentPosition()), Integer.valueOf(this.odZ.getDuration()) });
    if (!bs.isNullOrNil(this.odZ.getVideoPath()))
    {
      if (this.odZ.getCurrentPosition() < this.odZ.getDuration()) {
        break label136;
      }
      this.odZ.d(0.0D, true);
      if (this.yCl != null) {
        this.yCl.onStart(this.duration);
      }
    }
    for (;;)
    {
      startTimer();
      AppMethodBeat.o(179147);
      return;
      label136:
      this.odZ.start();
    }
  }
  
  public void startTimer()
  {
    AppMethodBeat.i(98031);
    au localau = this.oef;
    long l = this.yCp;
    localau.au(l, l);
    AppMethodBeat.o(98031);
  }
  
  public static abstract interface a
  {
    public abstract boolean a(PString paramPString);
    
    public abstract void onCompletion();
    
    public abstract void onStart(int paramInt);
    
    public abstract void sQ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView
 * JD-Core Version:    0.7.0.1
 */