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
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.c;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public class OfflineVideoView
  extends RelativeLayout
  implements h.a
{
  private a AkM;
  private boolean AkN;
  protected boolean AkO;
  private int AkP;
  private int AkQ;
  private boolean AkR;
  private h.e AkS;
  private int bFv;
  private int duration;
  private boolean fOX;
  private ProgressBar lxB;
  private Context mContext;
  private aq oMO;
  private h oNV;
  private aw oOb;
  protected ImageView rJe;
  private RelativeLayout rJz;
  protected boolean rNo;
  private boolean rNp;
  
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
    this.fOX = false;
    this.rNo = false;
    this.AkN = false;
    this.AkO = true;
    this.AkP = -1;
    this.bFv = 0;
    this.duration = 0;
    this.oMO = new aq(Looper.getMainLooper());
    this.AkQ = 1000;
    this.AkR = false;
    this.oOb = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(219706);
        if (OfflineVideoView.a(OfflineVideoView.this) == null)
        {
          AppMethodBeat.o(219706);
          return false;
        }
        if (((View)OfflineVideoView.a(OfflineVideoView.this)).getAlpha() < 1.0F) {
          OfflineVideoView.this.c(true, 1.0F);
        }
        if (OfflineVideoView.a(OfflineVideoView.this).isPlaying())
        {
          OfflineVideoView.d(OfflineVideoView.this);
          OfflineVideoView.this.RD(OfflineVideoView.a(OfflineVideoView.this).getCurrentPosition());
        }
        AppMethodBeat.o(219706);
        return true;
      }
    }, true);
    this.AkS = new h.e()
    {
      public final void bpD()
      {
        AppMethodBeat.i(219707);
        ae.i("MicroMsg.OfflineVideoView", "%d on texture update.", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()) });
        try
        {
          OfflineVideoView.this.c(true, 1.0F);
          AppMethodBeat.o(219707);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.OfflineVideoView", "texture view update. error " + localException.toString());
          AppMethodBeat.o(219707);
        }
      }
    };
    this.mContext = paramContext;
    ae.i("MicroMsg.OfflineVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(this.mContext).inflate(2131495624, this);
    this.rJe = ((ImageView)findViewById(2131306398));
    this.rJz = ((RelativeLayout)findViewById(2131306392));
    this.lxB = ((ProgressBar)findViewById(2131306352));
    if (d.lB(18))
    {
      paramInt = 0;
      if (paramInt == 0) {
        break label282;
      }
      this.rNp = true;
    }
    for (this.oNV = new VideoPlayerTextureView(this.mContext);; this.oNV = new VideoTextureView(this.mContext))
    {
      this.oNV.setVideoCallback(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      this.rJz.addView((View)this.oNV, paramContext);
      c(false, 0.0F);
      AppMethodBeat.o(98021);
      return;
      paramInt = 1;
      break;
      label282:
      this.rNp = false;
    }
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(98030);
    this.oMO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98017);
        if ((OfflineVideoView.c(OfflineVideoView.this) != null) && (OfflineVideoView.c(OfflineVideoView.this).getVisibility() != 8))
        {
          ae.i("MicroMsg.OfflineVideoView", "%d hide loading.", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()) });
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
    ae.d("MicroMsg.OfflineVideoView", "%d on resume %s", new Object[] { Integer.valueOf(hashCode()), bu.fpN() });
    if (!this.rNo) {
      cyW();
    }
    this.AkN = true;
    AppMethodBeat.o(98023);
  }
  
  public void RD(int paramInt)
  {
    AppMethodBeat.i(179150);
    if (this.AkM != null) {
      this.AkM.tx(paramInt);
    }
    AppMethodBeat.o(179150);
  }
  
  public final void aCa(final String paramString)
  {
    AppMethodBeat.i(98025);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(98025);
      return;
    }
    this.oMO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98013);
        if (OfflineVideoView.this.rJe != null)
        {
          ae.i("MicroMsg.OfflineVideoView", "%d fresh thumb image", new Object[] { Integer.valueOf(hashCode()) });
          OfflineVideoView.this.rJe.setImageBitmap(BackwardSupportUtil.b.p(paramString, 1.0F));
        }
        AppMethodBeat.o(98013);
      }
    });
    AppMethodBeat.o(98025);
  }
  
  public void aE(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(98034);
    ae.i("MicroMsg.OfflineVideoView", "%d seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    hideLoading();
    this.oNV.d(paramInt, paramBoolean);
    startTimer();
    AppMethodBeat.o(98034);
  }
  
  public final void aF(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(219708);
    ae.i("MicroMsg.OfflineVideoView", "%d ui touch seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    aE(paramInt, paramBoolean);
    startTimer();
    AppMethodBeat.o(219708);
  }
  
  public final void ahQ(String paramString)
  {
    AppMethodBeat.i(98033);
    ae.i("MicroMsg.OfflineVideoView", "%d prepare video  filePath %s", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.OfflineVideoView", "%d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98033);
      return;
    }
    if (this.oNV != null)
    {
      this.oNV.setOneTimeVideoTextureUpdateCallback(this.AkS);
      this.oNV.setVideoPath(paramString);
    }
    AppMethodBeat.o(98033);
  }
  
  public void c(final boolean paramBoolean, final float paramFloat)
  {
    AppMethodBeat.i(98027);
    this.oMO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98015);
        ae.i("MicroMsg.OfflineVideoView", "%d switch video model isVideoPlay %b %f", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
        View localView = (View)OfflineVideoView.a(OfflineVideoView.this);
        if (paramBoolean)
        {
          localView.setAlpha(paramFloat);
          localView.setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setAlpha(paramFloat);
          if (paramFloat >= 1.0D)
          {
            OfflineVideoView.this.rJe.setVisibility(8);
            AppMethodBeat.o(98015);
          }
        }
        else
        {
          localView.setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setVisibility(0);
          OfflineVideoView.b(OfflineVideoView.this).setAlpha(0.0F);
          OfflineVideoView.this.rJe.setVisibility(0);
        }
        AppMethodBeat.o(98015);
      }
    });
    AppMethodBeat.o(98027);
  }
  
  public final void cyW()
  {
    AppMethodBeat.i(98024);
    if (this.AkM != null)
    {
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      if (this.AkM.a(localPString1))
      {
        if (!bu.isNullOrNil(localPString2.value)) {
          aCa(localPString2.value);
        }
        if (!bu.isNullOrNil(localPString1.value))
        {
          ahQ(localPString1.value);
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
    ae.w("MicroMsg.OfflineVideoView", "%d toggle video but video callback is null", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(98024);
  }
  
  public final int eU(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void eb(int paramInt1, int paramInt2) {}
  
  protected void edK()
  {
    AppMethodBeat.i(179149);
    this.oOb.stopTimer();
    AppMethodBeat.o(179149);
  }
  
  public final void edL()
  {
    AppMethodBeat.i(179151);
    ae.i("MicroMsg.OfflineVideoView", "%d pause", new Object[] { Integer.valueOf(hashCode()) });
    ae.i("MicroMsg.OfflineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), bu.fpN() });
    this.AkO = false;
    if (this.oNV.isPlaying())
    {
      this.AkP = this.oNV.getCurrentPosition();
      ae.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      this.oNV.pause();
    }
    hideLoading();
    edK();
    AppMethodBeat.o(179151);
  }
  
  public final void edM()
  {
    AppMethodBeat.i(179152);
    ae.i("MicroMsg.OfflineVideoView", "%d start hasResumed[%b], curPos [%d], duration [%d], shouldSeek [%d]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.AkN), Integer.valueOf(this.oNV.getCurrentPosition()), Integer.valueOf(this.oNV.getDuration()), Integer.valueOf(this.AkP) });
    this.AkO = true;
    if (this.AkN) {
      if (!bu.isNullOrNil(this.oNV.getVideoPath())) {
        if (this.oNV.getCurrentPosition() >= this.oNV.getDuration())
        {
          this.oNV.d(0.0D, true);
          if (this.AkM != null) {
            this.AkM.onStart(this.duration);
          }
        }
      }
    }
    for (;;)
    {
      startTimer();
      AppMethodBeat.o(179152);
      return;
      this.oNV.start();
      continue;
      onResume();
      continue;
      onResume();
    }
  }
  
  public final boolean edN()
  {
    AppMethodBeat.i(179154);
    if ((this.oNV instanceof VideoPlayerTextureView))
    {
      if ((((VideoPlayerTextureView)this.oNV).fjg()) && (isPlaying()))
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
    if (this.oNV != null)
    {
      int i = this.oNV.getCurrentPosition() / 1000;
      AppMethodBeat.o(98035);
      return i;
    }
    AppMethodBeat.o(98035);
    return 0;
  }
  
  public int getCurrentPositionMs()
  {
    AppMethodBeat.i(98036);
    if (this.oNV != null)
    {
      int i = this.oNV.getCurrentPosition();
      AppMethodBeat.o(98036);
      return i;
    }
    AppMethodBeat.o(98036);
    return 0;
  }
  
  public int getDurationMs()
  {
    AppMethodBeat.i(98037);
    if (this.oNV != null)
    {
      int i = this.oNV.getDuration();
      AppMethodBeat.o(98037);
      return i;
    }
    AppMethodBeat.o(98037);
    return 0;
  }
  
  public View getInnerVideoView()
  {
    if ((this.oNV instanceof View)) {
      return (View)this.oNV;
    }
    return null;
  }
  
  public int getTimerInterval()
  {
    return this.AkQ;
  }
  
  public String getVideoPath()
  {
    AppMethodBeat.i(179155);
    if (this.oNV != null)
    {
      String str = this.oNV.getVideoPath();
      AppMethodBeat.o(179155);
      return str;
    }
    AppMethodBeat.o(179155);
    return "";
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(179153);
    if (this.oNV != null)
    {
      boolean bool = this.oNV.isPlaying();
      AppMethodBeat.o(179153);
      return bool;
    }
    AppMethodBeat.o(179153);
    return false;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(98032);
    ae.i("MicroMsg.OfflineVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if (this.AkM == null)
    {
      if ((d.lC(18)) || (!this.rNp))
      {
        aE(0, true);
        AppMethodBeat.o(98032);
        return;
      }
      if (this.oNV != null)
      {
        String str = this.oNV.getVideoPath();
        this.oNV.stop();
        ahQ(str);
        AppMethodBeat.o(98032);
      }
    }
    else
    {
      this.AkM.onCompletion();
    }
    AppMethodBeat.o(98032);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179148);
    ae.d("MicroMsg.OfflineVideoView", "%d on destroy %s", new Object[] { Integer.valueOf(hashCode()), bu.fpN() });
    ae.i("MicroMsg.OfflineVideoView", "%d logic unInit", new Object[] { Integer.valueOf(hashCode()) });
    this.oMO.removeCallbacksAndMessages(null);
    edK();
    if (this.oNV != null) {
      this.oNV.stop();
    }
    AppMethodBeat.o(179148);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(98026);
    ae.e("MicroMsg.OfflineVideoView", "%d on play video error what %d extra %d isMMVideoPlayer %b errorCount %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.rNp), Integer.valueOf(this.bFv) });
    this.bFv += 1;
    final String str1 = this.oNV.getVideoPath();
    this.oNV.stop();
    this.rNo = true;
    c(false, 0.0F);
    if (this.bFv <= 3)
    {
      this.oMO.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98014);
          OfflineVideoView.this.ahQ(str1);
          AppMethodBeat.o(98014);
        }
      }, 200L);
      AppMethodBeat.o(98026);
      return;
    }
    try
    {
      long l;
      if (!bu.isNullOrNil(str1)) {
        if (o.fB(str1))
        {
          l = o.aZR(str1);
          boolean bool = o.deleteFile(str1);
          ae.i("MicroMsg.OfflineVideoView", "onError, fileLen=" + l + ", delRet=" + bool);
          paramInt1 = i;
          if (!this.AkR) {
            if (!this.rNp) {
              break label297;
            }
          }
        }
      }
      label297:
      for (str1 = "1";; str1 = "0")
      {
        String str2 = getClass().getSimpleName();
        j.b(j.ztM, str1, paramInt1, (int)l, str2);
        this.AkR = true;
        AppMethodBeat.o(98026);
        return;
        ae.e("MicroMsg.OfflineVideoView", "onError, file not exists");
        l = -1L;
        paramInt1 = 2;
        break;
        ae.e("MicroMsg.OfflineVideoView", "onError, filepath==null");
        l = -1L;
        paramInt1 = 3;
        break;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.OfflineVideoView", "onError, exp=" + localThrowable.toString());
      AppMethodBeat.o(98026);
    }
  }
  
  public void pause()
  {
    AppMethodBeat.i(179146);
    ae.i("MicroMsg.OfflineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), bu.fpN() });
    if (this.oNV.isPlaying())
    {
      this.AkP = this.oNV.getCurrentPosition();
      ae.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      this.oNV.pause();
    }
    AppMethodBeat.o(179146);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(98022);
    this.fOX = paramBoolean;
    this.oNV.setMute(this.fOX);
    AppMethodBeat.o(98022);
  }
  
  public void setOnSeekCompleteCallback(h.c paramc)
  {
    AppMethodBeat.i(219709);
    if (this.oNV != null) {
      this.oNV.setOnSeekCompleteCallback(paramc);
    }
    AppMethodBeat.o(219709);
  }
  
  public void setTimerInterval(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 200) {
      i = 200;
    }
    this.AkQ = i;
  }
  
  public void setVideoCallback(a parama)
  {
    this.AkM = parama;
  }
  
  protected void showLoading()
  {
    AppMethodBeat.i(98029);
    this.oMO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98016);
        ae.i("MicroMsg.OfflineVideoView", "%d show loading. downloadMode %d", new Object[] { Integer.valueOf(OfflineVideoView.this.hashCode()), Integer.valueOf(OfflineVideoView.this.hashCode()) });
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
    ae.i("MicroMsg.OfflineVideoView", "%d start curPos [%d], duration [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.oNV.getCurrentPosition()), Integer.valueOf(this.oNV.getDuration()) });
    if (!bu.isNullOrNil(this.oNV.getVideoPath()))
    {
      if (this.oNV.getCurrentPosition() < this.oNV.getDuration()) {
        break label136;
      }
      this.oNV.d(0.0D, true);
      if (this.AkM != null) {
        this.AkM.onStart(this.duration);
      }
    }
    for (;;)
    {
      startTimer();
      AppMethodBeat.o(179147);
      return;
      label136:
      this.oNV.start();
    }
  }
  
  public void startTimer()
  {
    AppMethodBeat.i(98031);
    aw localaw = this.oOb;
    long l = this.AkQ;
    localaw.ay(l, l);
    AppMethodBeat.o(98031);
  }
  
  public void ta()
  {
    AppMethodBeat.i(98028);
    c(true, 0.0F);
    this.rNo = false;
    hideLoading();
    this.duration = (this.oNV.getDuration() / 1000);
    ae.i("MicroMsg.OfflineVideoView", "%d on prepared. shouldPlayWhenPrepared [%b] shouldSeekTimeWhenPrepared[%d]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.AkO), Integer.valueOf(this.AkP) });
    if (this.AkO)
    {
      if (this.AkP <= 0) {
        this.oNV.start();
      }
      for (;;)
      {
        startTimer();
        if (this.AkM != null) {
          this.AkM.onStart(this.duration);
        }
        this.AkP = -1;
        AppMethodBeat.o(98028);
        return;
        aE(this.AkP, true);
      }
    }
    if (this.AkP > 0) {}
    for (int i = this.AkP;; i = 0)
    {
      aE(i, false);
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean a(PString paramPString);
    
    public abstract void onCompletion();
    
    public abstract void onStart(int paramInt);
    
    public abstract void tx(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView
 * JD-Core Version:    0.7.0.1
 */