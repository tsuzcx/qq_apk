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
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;

public class OfflineVideoView
  extends RelativeLayout
  implements e.a
{
  private int aZy;
  public int duration;
  private boolean efg;
  public ak kuE;
  public e kvG;
  public ap kvM;
  private ImageView mAM;
  private RelativeLayout mBh;
  private Context mContext;
  private boolean mEv;
  private boolean mEw;
  private ProgressBar mEy;
  public OfflineVideoView.a rIV;
  public boolean rIW;
  public boolean rIX;
  public int rIY;
  private e.e rIZ;
  
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
    AppMethodBeat.i(38368);
    this.mContext = null;
    this.efg = false;
    this.mEv = false;
    this.rIW = false;
    this.rIX = true;
    this.rIY = -1;
    this.aZy = 0;
    this.duration = 0;
    this.kuE = new ak(Looper.getMainLooper());
    this.kvM = new ap(new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(38366);
        if (OfflineVideoView.b(OfflineVideoView.this) == null)
        {
          AppMethodBeat.o(38366);
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
          if (localOfflineVideoView.rIV != null) {
            localOfflineVideoView.rIV.Ef(i);
          }
        }
        AppMethodBeat.o(38366);
        return true;
      }
    }, true);
    this.rIZ = new OfflineVideoView.8(this);
    this.mContext = paramContext;
    ab.i("MicroMsg.OfflineVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(this.mContext).inflate(2130970897, this);
    this.mAM = ((ImageView)findViewById(2131822189));
    this.mBh = ((RelativeLayout)findViewById(2131822190));
    this.mEy = ((ProgressBar)findViewById(2131821842));
    if (d.fw(18))
    {
      paramInt = 0;
      if (paramInt == 0) {
        break label270;
      }
      this.mEw = true;
    }
    for (this.kvG = new VideoPlayerTextureView(this.mContext);; this.kvG = new VideoTextureView(this.mContext))
    {
      this.kvG.setVideoCallback(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      this.mBh.addView((View)this.kvG, paramContext);
      a(false, 0.0F);
      AppMethodBeat.o(38368);
      return;
      paramInt = 1;
      break;
      label270:
      this.mEw = false;
    }
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(38376);
    this.kuE.post(new OfflineVideoView.5(this));
    AppMethodBeat.o(38376);
  }
  
  public final void Es()
  {
    AppMethodBeat.i(38379);
    ab.i("MicroMsg.OfflineVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if (this.rIV == null)
    {
      if ((d.iU(18)) || (!this.mEw))
      {
        ag(0, true);
        AppMethodBeat.o(38379);
        return;
      }
      if (this.kvG != null)
      {
        String str = this.kvG.getVideoPath();
        this.kvG.stop();
        Oh(str);
        AppMethodBeat.o(38379);
      }
    }
    else
    {
      this.rIV.Es();
    }
    AppMethodBeat.o(38379);
  }
  
  public final void Oh(String paramString)
  {
    AppMethodBeat.i(38380);
    ab.i("MicroMsg.OfflineVideoView", "%d prepare video  filePath %s", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.OfflineVideoView", "%d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(38380);
      return;
    }
    if (this.kvG != null)
    {
      this.kvG.setOneTimeVideoTextureUpdateCallback(this.rIZ);
      this.kvG.setVideoPath(paramString);
    }
    AppMethodBeat.o(38380);
  }
  
  public final void a(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(38374);
    this.kuE.post(new OfflineVideoView.4(this, paramBoolean, paramFloat));
    AppMethodBeat.o(38374);
  }
  
  public final void acb(String paramString)
  {
    AppMethodBeat.i(38372);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(38372);
      return;
    }
    this.kuE.post(new OfflineVideoView.1(this, paramString));
    AppMethodBeat.o(38372);
  }
  
  public final void ag(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38381);
    ab.i("MicroMsg.OfflineVideoView", "%d seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    hideLoading();
    this.kvG.e(paramInt, paramBoolean);
    startTimer();
    AppMethodBeat.o(38381);
  }
  
  public final void byu()
  {
    AppMethodBeat.i(38371);
    if (this.rIV != null)
    {
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      if (this.rIV.a(localPString1))
      {
        if (!bo.isNullOrNil(localPString2.value)) {
          acb(localPString2.value);
        }
        if (!bo.isNullOrNil(localPString1.value))
        {
          Oh(localPString1.value);
          AppMethodBeat.o(38371);
        }
      }
      else
      {
        showLoading();
        a(false, 0.0F);
      }
      AppMethodBeat.o(38371);
      return;
    }
    ab.w("MicroMsg.OfflineVideoView", "%d toggle video but video callback is null", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(38371);
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(38382);
    if (this.kvG != null)
    {
      int i = this.kvG.getCurrentPosition() / 1000;
      AppMethodBeat.o(38382);
      return i;
    }
    AppMethodBeat.o(38382);
    return 0;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(38377);
    this.kuE.post(new OfflineVideoView.6(this));
    AppMethodBeat.o(38377);
  }
  
  public final void mG()
  {
    AppMethodBeat.i(38375);
    a(true, 0.0F);
    this.mEv = false;
    hideLoading();
    this.duration = (this.kvG.getDuration() / 1000);
    ab.i("MicroMsg.OfflineVideoView", "%d on prepared. shouldPlayWhenPrepared [%b] shouldSeekTimeWhenPrepared[%d]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.rIX), Integer.valueOf(this.rIY) });
    if (this.rIX)
    {
      if (this.rIY <= 0) {
        this.kvG.start();
      }
      for (;;)
      {
        startTimer();
        if (this.rIV != null) {
          this.rIV.onStart(this.duration);
        }
        this.rIY = -1;
        AppMethodBeat.o(38375);
        return;
        ag(this.rIY, true);
      }
    }
    if (this.rIY > 0) {}
    for (int i = this.rIY;; i = 0)
    {
      ag(i, false);
      break;
    }
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38373);
    ab.e("MicroMsg.OfflineVideoView", "%d on play video error what %d extra %d isMMVideoPlayer %b errorCount %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.mEw), Integer.valueOf(this.aZy) });
    this.aZy += 1;
    String str = this.kvG.getVideoPath();
    this.kvG.stop();
    this.mEv = true;
    a(false, 0.0F);
    if (this.aZy <= 3)
    {
      this.kuE.postDelayed(new OfflineVideoView.2(this, str), 200L);
      AppMethodBeat.o(38373);
      return;
    }
    if (!bo.isNullOrNil(str))
    {
      ab.w("MicroMsg.OfflineVideoView", "%d start third player to play", new Object[] { Integer.valueOf(hashCode()) });
      this.kuE.post(new OfflineVideoView.3(this, str));
    }
    AppMethodBeat.o(38373);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(38370);
    ab.d("MicroMsg.OfflineVideoView", "%d on resume %s", new Object[] { Integer.valueOf(hashCode()), bo.dtY() });
    if (!this.mEv) {
      byu();
    }
    this.rIW = true;
    AppMethodBeat.o(38370);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(38369);
    this.efg = paramBoolean;
    this.kvG.setMute(this.efg);
    AppMethodBeat.o(38369);
  }
  
  public void setVideoCallback(OfflineVideoView.a parama)
  {
    this.rIV = parama;
  }
  
  public final void startTimer()
  {
    AppMethodBeat.i(38378);
    this.kvM.ag(1000L, 1000L);
    AppMethodBeat.o(38378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView
 * JD-Core Version:    0.7.0.1
 */