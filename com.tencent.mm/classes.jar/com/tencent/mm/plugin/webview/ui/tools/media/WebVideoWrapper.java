package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class WebVideoWrapper
  extends RelativeLayout
  implements d.a, i, i.b, i.c
{
  private boolean bzN;
  private int llD;
  private Context mContext;
  private i.b osZ;
  private d ota;
  private String url;
  private i zHQ;
  
  public WebVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WebVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(82068);
    this.mContext = paramContext;
    this.ota = new d();
    if (this.zHQ == null)
    {
      paramContext = new CommonVideoView(this.mContext);
      paramContext.setReporter(this);
      paramContext.setIMMVideoViewCallback(this);
      qQ(200L);
      this.zHQ = paramContext;
    }
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(13);
    addView((View)this.zHQ, paramContext);
    AppMethodBeat.o(82068);
  }
  
  public final void aAa() {}
  
  public final void aAb() {}
  
  public final boolean aE(float paramFloat)
  {
    AppMethodBeat.i(82092);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(82092);
      return false;
    }
    if (this.zHQ != null)
    {
      boolean bool = this.zHQ.aE(paramFloat);
      AppMethodBeat.o(82092);
      return bool;
    }
    AppMethodBeat.o(82092);
    return false;
  }
  
  public final void azY() {}
  
  public final void azZ() {}
  
  public final boolean bhH()
  {
    AppMethodBeat.i(82082);
    if (this.zHQ != null)
    {
      boolean bool = this.zHQ.bhH();
      AppMethodBeat.o(82082);
      return bool;
    }
    AppMethodBeat.o(82082);
    return false;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82093);
    ad.w("MicroMsg.WebVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.osZ != null) {
      this.osZ.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(82093);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(82069);
    this.llD = paramInt;
    this.bzN = paramBoolean;
    this.url = paramString;
    if (this.zHQ != null) {
      this.zHQ.c(this.bzN, this.url, this.llD);
    }
    AppMethodBeat.o(82069);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(82074);
    if (this.zHQ != null)
    {
      paramBoolean = this.zHQ.c(paramDouble, paramBoolean);
      AppMethodBeat.o(82074);
      return paramBoolean;
    }
    AppMethodBeat.o(82074);
    return false;
  }
  
  public final void cMk()
  {
    AppMethodBeat.i(82071);
    if (this.zHQ != null) {
      this.zHQ.cMk();
    }
    AppMethodBeat.o(82071);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82096);
    ad.i("MicroMsg.WebVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.osZ != null) {
      this.osZ.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(82096);
  }
  
  public final void dq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82094);
    ad.i("MicroMsg.WebVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.osZ != null) {
      this.osZ.dq(paramString1, paramString2);
    }
    AppMethodBeat.o(82094);
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82095);
    ad.i("MicroMsg.WebVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.osZ != null) {
      this.osZ.dr(paramString1, paramString2);
    }
    AppMethodBeat.o(82095);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82097);
    ad.d("MicroMsg.WebVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.ota.ex(false);
    if (this.osZ != null) {
      this.osZ.ds(paramString1, paramString2);
    }
    AppMethodBeat.o(82097);
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82098);
    ad.d("MicroMsg.WebVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.ota.a(this);
    if (this.osZ != null) {
      this.osZ.dt(paramString1, paramString2);
    }
    AppMethodBeat.o(82098);
  }
  
  public final void du(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82099);
    if (this.osZ != null) {
      this.osZ.du(paramString1, paramString2);
    }
    AppMethodBeat.o(82099);
  }
  
  public final void dv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82100);
    if (this.osZ != null) {
      this.osZ.dv(paramString1, paramString2);
    }
    AppMethodBeat.o(82100);
  }
  
  public final void eT(String paramString1, String paramString2) {}
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(82080);
    if (this.zHQ != null)
    {
      int i = this.zHQ.getCacheTimeSec();
      AppMethodBeat.o(82080);
      return i;
    }
    AppMethodBeat.o(82080);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(82078);
    if (this.zHQ != null)
    {
      int i = this.zHQ.getCurrPosMs();
      AppMethodBeat.o(82078);
      return i;
    }
    AppMethodBeat.o(82078);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(82079);
    if (this.zHQ != null)
    {
      int i = this.zHQ.getCurrPosSec();
      AppMethodBeat.o(82079);
      return i;
    }
    AppMethodBeat.o(82079);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(82072);
    if (this.zHQ != null)
    {
      int i = this.zHQ.getPlayerType();
      AppMethodBeat.o(82072);
      return i;
    }
    AppMethodBeat.o(82072);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(82077);
    if (this.zHQ != null)
    {
      i = this.zHQ.getVideoDurationSec();
      AppMethodBeat.o(82077);
      return i;
    }
    int i = this.llD;
    AppMethodBeat.o(82077);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(82081);
    if (this.zHQ != null)
    {
      boolean bool = this.zHQ.isPlaying();
      AppMethodBeat.o(82081);
      return bool;
    }
    AppMethodBeat.o(82081);
    return false;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(82073);
    if (this.zHQ != null)
    {
      boolean bool = this.zHQ.o(paramDouble);
      AppMethodBeat.o(82073);
      return bool;
    }
    AppMethodBeat.o(82073);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(82090);
    if (this.zHQ != null) {
      this.zHQ.onUIDestroy();
    }
    this.ota.ex(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(82090);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(82089);
    if (this.zHQ != null) {
      this.zHQ.onUIPause();
    }
    this.ota.ex(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(82089);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(82088);
    if (this.zHQ != null) {
      this.zHQ.onUIResume();
    }
    AppMethodBeat.o(82088);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(82086);
    if (this.zHQ != null)
    {
      setKeepScreenOn(false);
      this.ota.ex(false);
      boolean bool = this.zHQ.pause();
      AppMethodBeat.o(82086);
      return bool;
    }
    AppMethodBeat.o(82086);
    return false;
  }
  
  public final void qQ(long paramLong)
  {
    AppMethodBeat.i(82102);
    g.yhR.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(82102);
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(82083);
    if (this.zHQ != null) {
      this.zHQ.setCover(paramBitmap);
    }
    AppMethodBeat.o(82083);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(82076);
    if (this.zHQ != null) {
      this.zHQ.setFullDirection(paramInt);
    }
    AppMethodBeat.o(82076);
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    this.osZ = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(82075);
    if (this.zHQ != null) {
      this.zHQ.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(82075);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(82101);
    ad.d("MicroMsg.WebVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bt.flS() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(82101);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setLoopCompletionCallback(i.d paramd) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(82087);
    if (this.zHQ != null) {
      this.zHQ.setMute(paramBoolean);
    }
    AppMethodBeat.o(82087);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(82091);
    if (this.zHQ != null) {
      this.zHQ.setScaleType(parame);
    }
    AppMethodBeat.o(82091);
  }
  
  public void setVideoFooterView(h paramh)
  {
    AppMethodBeat.i(82070);
    if (this.zHQ != null) {
      this.zHQ.setVideoFooterView(paramh);
    }
    AppMethodBeat.o(82070);
  }
  
  public final void start()
  {
    AppMethodBeat.i(82084);
    if (this.zHQ != null)
    {
      this.zHQ.start();
      setKeepScreenOn(true);
      this.ota.a(this);
    }
    AppMethodBeat.o(82084);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(82085);
    if (this.zHQ != null)
    {
      this.zHQ.stop();
      this.ota.ex(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(82085);
  }
  
  public final void vk(String paramString)
  {
    AppMethodBeat.i(82103);
    g.yhR.kvStat(14349, paramString);
    AppMethodBeat.o(82103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.WebVideoWrapper
 * JD-Core Version:    0.7.0.1
 */