package com.tencent.mm.plugin.webview.fts.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class FtsVideoWrapper
  extends RelativeLayout
  implements d.a, i, i.a, i.b, i.c
{
  private boolean bzN;
  private boolean dCQ;
  private boolean hvp;
  private float llC;
  private int llD;
  private Context mContext;
  private h osV;
  private i.b osZ;
  private d ota;
  private String url;
  private i.e xyl;
  private i zHQ;
  
  public FtsVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FtsVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(77989);
    this.xyl = i.e.ESO;
    this.hvp = false;
    this.llC = -1.0F;
    this.mContext = paramContext;
    this.ota = new d();
    AppMethodBeat.o(77989);
  }
  
  private i cYo()
  {
    AppMethodBeat.i(77991);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.setReporter(this);
    localCommonVideoView.setIMMVideoViewCallback(this);
    AppMethodBeat.o(77991);
    return localCommonVideoView;
  }
  
  public final void aAa() {}
  
  public final void aAb() {}
  
  public final boolean aE(float paramFloat)
  {
    AppMethodBeat.i(78014);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(78014);
      return false;
    }
    this.llC = paramFloat;
    if (this.zHQ != null)
    {
      boolean bool = this.zHQ.aE(this.llC);
      AppMethodBeat.o(78014);
      return bool;
    }
    AppMethodBeat.o(78014);
    return false;
  }
  
  public final void aK(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(78015);
    ad.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      AppMethodBeat.o(78015);
      return;
    }
    if ((this.zHQ instanceof MMVideoView))
    {
      this.zHQ.stop();
      this.zHQ.cMk();
      removeView((View)this.zHQ);
      ad.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.zHQ = cYo();
    }
    for (int i = 1;; i = 0)
    {
      setScaleType(this.xyl);
      aE(this.llC);
      setMute(this.hvp);
      if (i != 0)
      {
        setVideoFooterView(this.osV);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.zHQ, paramString);
        this.zHQ.c(this.bzN, this.url, this.llD);
        this.zHQ.start();
      }
      AppMethodBeat.o(78015);
      return;
    }
  }
  
  public final void azY() {}
  
  public final void azZ() {}
  
  public final boolean bhH()
  {
    AppMethodBeat.i(78004);
    if (this.zHQ != null)
    {
      boolean bool = this.zHQ.bhH();
      AppMethodBeat.o(78004);
      return bool;
    }
    AppMethodBeat.o(78004);
    return false;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78016);
    ad.w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.osZ != null) {
      this.osZ.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(78016);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(77990);
    this.llD = paramInt;
    this.bzN = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    bt.isNullOrNil(localPString.value);
    this.dCQ = false;
    this.url = localPString.value;
    if (this.zHQ == null)
    {
      ad.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.zHQ = cYo();
      paramInt = 1;
    }
    for (;;)
    {
      setScaleType(this.xyl);
      aE(this.llC);
      setMute(this.hvp);
      if (paramInt != 0)
      {
        setVideoFooterView(this.osV);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.zHQ, paramString);
      }
      this.zHQ.c(this.bzN, this.url, this.llD);
      AppMethodBeat.o(77990);
      return;
      if ((this.zHQ instanceof MMVideoView))
      {
        this.zHQ.stop();
        this.zHQ.cMk();
        removeView((View)this.zHQ);
        ad.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.zHQ = cYo();
        paramInt = 1;
      }
      else
      {
        ad.i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.zHQ.stop();
        paramInt = 0;
      }
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(77996);
    if (this.zHQ != null)
    {
      paramBoolean = this.zHQ.c(paramDouble, paramBoolean);
      AppMethodBeat.o(77996);
      return paramBoolean;
    }
    AppMethodBeat.o(77996);
    return false;
  }
  
  public final void cMk()
  {
    AppMethodBeat.i(77993);
    if (this.zHQ != null) {
      this.zHQ.cMk();
    }
    AppMethodBeat.o(77993);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78019);
    ad.i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.osZ != null) {
      this.osZ.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(78019);
  }
  
  public final void dq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78017);
    ad.i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.osZ != null) {
      this.osZ.dq(paramString1, paramString2);
    }
    AppMethodBeat.o(78017);
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78018);
    ad.i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.osZ != null) {
      this.osZ.dr(paramString1, paramString2);
    }
    AppMethodBeat.o(78018);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78020);
    ad.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.ota.ex(false);
    if (this.osZ != null) {
      this.osZ.ds(paramString1, paramString2);
    }
    AppMethodBeat.o(78020);
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78021);
    ad.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.ota.a(this);
    if (this.osZ != null) {
      this.osZ.dt(paramString1, paramString2);
    }
    AppMethodBeat.o(78021);
  }
  
  public final void du(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78022);
    if (this.osZ != null) {
      this.osZ.du(paramString1, paramString2);
    }
    AppMethodBeat.o(78022);
  }
  
  public final void dv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78023);
    if (this.osZ != null) {
      this.osZ.dv(paramString1, paramString2);
    }
    AppMethodBeat.o(78023);
  }
  
  public final void eT(String paramString1, String paramString2) {}
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(78002);
    if (this.zHQ != null)
    {
      int i = this.zHQ.getCacheTimeSec();
      AppMethodBeat.o(78002);
      return i;
    }
    AppMethodBeat.o(78002);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(78000);
    if (this.zHQ != null)
    {
      int i = this.zHQ.getCurrPosMs();
      AppMethodBeat.o(78000);
      return i;
    }
    AppMethodBeat.o(78000);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(78001);
    if (this.zHQ != null)
    {
      int i = this.zHQ.getCurrPosSec();
      AppMethodBeat.o(78001);
      return i;
    }
    AppMethodBeat.o(78001);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(77994);
    if (this.zHQ != null)
    {
      int i = this.zHQ.getPlayerType();
      AppMethodBeat.o(77994);
      return i;
    }
    AppMethodBeat.o(77994);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(77999);
    if (this.zHQ != null)
    {
      i = this.zHQ.getVideoDurationSec();
      AppMethodBeat.o(77999);
      return i;
    }
    int i = this.llD;
    AppMethodBeat.o(77999);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(78003);
    if (this.zHQ != null)
    {
      boolean bool = this.zHQ.isPlaying();
      AppMethodBeat.o(78003);
      return bool;
    }
    AppMethodBeat.o(78003);
    return false;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(77995);
    if (this.zHQ != null)
    {
      boolean bool = this.zHQ.o(paramDouble);
      AppMethodBeat.o(77995);
      return bool;
    }
    AppMethodBeat.o(77995);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(78012);
    if (this.zHQ != null) {
      this.zHQ.onUIDestroy();
    }
    this.ota.ex(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(78012);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(78011);
    if (this.zHQ != null) {
      this.zHQ.onUIPause();
    }
    this.ota.ex(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(78011);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(78010);
    if (this.zHQ != null) {
      this.zHQ.onUIResume();
    }
    AppMethodBeat.o(78010);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(78008);
    if (this.zHQ != null)
    {
      setKeepScreenOn(false);
      this.ota.ex(false);
      boolean bool = this.zHQ.pause();
      AppMethodBeat.o(78008);
      return bool;
    }
    AppMethodBeat.o(78008);
    return false;
  }
  
  public final void qQ(long paramLong)
  {
    AppMethodBeat.i(78025);
    g.yhR.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(78025);
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(78005);
    if (this.zHQ != null) {
      this.zHQ.setCover(paramBitmap);
    }
    AppMethodBeat.o(78005);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(77998);
    if (this.zHQ != null) {
      this.zHQ.setFullDirection(paramInt);
    }
    AppMethodBeat.o(77998);
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    this.osZ = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(77997);
    if (this.zHQ != null) {
      this.zHQ.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(77997);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(78024);
    ad.d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bt.flS() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(78024);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setLoopCompletionCallback(i.d paramd) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(78009);
    this.hvp = paramBoolean;
    if (this.zHQ != null) {
      this.zHQ.setMute(this.hvp);
    }
    AppMethodBeat.o(78009);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(78013);
    this.xyl = parame;
    if (this.zHQ != null) {
      this.zHQ.setScaleType(this.xyl);
    }
    AppMethodBeat.o(78013);
  }
  
  public void setVideoFooterView(h paramh)
  {
    AppMethodBeat.i(77992);
    this.osV = paramh;
    if (this.zHQ != null) {
      this.zHQ.setVideoFooterView(this.osV);
    }
    AppMethodBeat.o(77992);
  }
  
  public final void start()
  {
    AppMethodBeat.i(78006);
    if (this.zHQ != null)
    {
      this.zHQ.start();
      setKeepScreenOn(true);
      this.ota.a(this);
    }
    AppMethodBeat.o(78006);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(78007);
    if (this.zHQ != null)
    {
      this.zHQ.stop();
      this.ota.ex(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(78007);
  }
  
  public final void vk(String paramString)
  {
    AppMethodBeat.i(78026);
    g.yhR.kvStat(14349, paramString);
    AppMethodBeat.o(78026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsVideoWrapper
 * JD-Core Version:    0.7.0.1
 */