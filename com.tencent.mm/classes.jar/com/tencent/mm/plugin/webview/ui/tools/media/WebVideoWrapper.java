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
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class WebVideoWrapper
  extends RelativeLayout
  implements d.a, i, i.b, i.c
{
  private i Kuv;
  private boolean bjq;
  private Context mContext;
  private int pvi;
  private i.b sUh;
  private d sUi;
  private String url;
  
  public WebVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WebVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(82068);
    this.mContext = paramContext;
    this.sUi = d.bcs();
    if (this.Kuv == null)
    {
      paramContext = new CommonVideoView(this.mContext);
      paramContext.setReporter(this);
      paramContext.setIMMVideoViewCallback(this);
      EW(200L);
      this.Kuv = paramContext;
    }
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(13);
    addView((View)this.Kuv, paramContext);
    AppMethodBeat.o(82068);
  }
  
  public final void EW(long paramLong)
  {
    AppMethodBeat.i(82102);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(82102);
  }
  
  public final void KP(String paramString)
  {
    AppMethodBeat.i(82103);
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(14349, paramString);
    AppMethodBeat.o(82103);
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(82074);
    if (this.Kuv != null)
    {
      paramBoolean = this.Kuv.a(paramDouble, paramBoolean);
      AppMethodBeat.o(82074);
      return paramBoolean;
    }
    AppMethodBeat.o(82074);
    return false;
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(82092);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(82092);
      return false;
    }
    if (this.Kuv != null)
    {
      boolean bool = this.Kuv.aO(paramFloat);
      AppMethodBeat.o(82092);
      return bool;
    }
    AppMethodBeat.o(82092);
    return false;
  }
  
  public final void bcu() {}
  
  public final void bcv() {}
  
  public final void bcw() {}
  
  public final void bcx() {}
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82093);
    Log.w("MicroMsg.WebVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.sUh != null) {
      this.sUh.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(82093);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(82069);
    this.pvi = paramInt;
    this.bjq = paramBoolean;
    this.url = paramString;
    if (this.Kuv != null) {
      this.Kuv.c(this.bjq, this.url, this.pvi);
    }
    AppMethodBeat.o(82069);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82096);
    Log.i("MicroMsg.WebVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.sUh != null) {
      this.sUh.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(82096);
  }
  
  public final void dS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82094);
    Log.i("MicroMsg.WebVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.sUh != null) {
      this.sUh.dS(paramString1, paramString2);
    }
    AppMethodBeat.o(82094);
  }
  
  public final void dT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82095);
    Log.i("MicroMsg.WebVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.sUh != null) {
      this.sUh.dT(paramString1, paramString2);
    }
    AppMethodBeat.o(82095);
  }
  
  public final void dU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82097);
    Log.d("MicroMsg.WebVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.sUi.fZ(false);
    if (this.sUh != null) {
      this.sUh.dU(paramString1, paramString2);
    }
    AppMethodBeat.o(82097);
  }
  
  public final void dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82098);
    Log.d("MicroMsg.WebVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.sUi.a(this);
    if (this.sUh != null) {
      this.sUh.dV(paramString1, paramString2);
    }
    AppMethodBeat.o(82098);
  }
  
  public final void dW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82099);
    if (this.sUh != null) {
      this.sUh.dW(paramString1, paramString2);
    }
    AppMethodBeat.o(82099);
  }
  
  public final void dX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82100);
    if (this.sUh != null) {
      this.sUh.dX(paramString1, paramString2);
    }
    AppMethodBeat.o(82100);
  }
  
  public final void egX()
  {
    AppMethodBeat.i(82071);
    if (this.Kuv != null) {
      this.Kuv.egX();
    }
    AppMethodBeat.o(82071);
  }
  
  public final void fC(String paramString1, String paramString2) {}
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(82080);
    if (this.Kuv != null)
    {
      int i = this.Kuv.getCacheTimeSec();
      AppMethodBeat.o(82080);
      return i;
    }
    AppMethodBeat.o(82080);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(82078);
    if (this.Kuv != null)
    {
      int i = this.Kuv.getCurrPosMs();
      AppMethodBeat.o(82078);
      return i;
    }
    AppMethodBeat.o(82078);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(82079);
    if (this.Kuv != null)
    {
      int i = this.Kuv.getCurrPosSec();
      AppMethodBeat.o(82079);
      return i;
    }
    AppMethodBeat.o(82079);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(82072);
    if (this.Kuv != null)
    {
      int i = this.Kuv.getPlayerType();
      AppMethodBeat.o(82072);
      return i;
    }
    AppMethodBeat.o(82072);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(82077);
    if (this.Kuv != null)
    {
      i = this.Kuv.getVideoDurationSec();
      AppMethodBeat.o(82077);
      return i;
    }
    int i = this.pvi;
    AppMethodBeat.o(82077);
    return i;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(82082);
    if (this.Kuv != null)
    {
      boolean bool = this.Kuv.isLive();
      AppMethodBeat.o(82082);
      return bool;
    }
    AppMethodBeat.o(82082);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(82081);
    if (this.Kuv != null)
    {
      boolean bool = this.Kuv.isPlaying();
      AppMethodBeat.o(82081);
      return bool;
    }
    AppMethodBeat.o(82081);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(82090);
    if (this.Kuv != null) {
      this.Kuv.onUIDestroy();
    }
    this.sUi.fZ(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(82090);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(82089);
    if (this.Kuv != null) {
      this.Kuv.onUIPause();
    }
    this.sUi.fZ(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(82089);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(82088);
    if (this.Kuv != null) {
      this.Kuv.onUIResume();
    }
    AppMethodBeat.o(82088);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(82073);
    if (this.Kuv != null)
    {
      boolean bool = this.Kuv.p(paramDouble);
      AppMethodBeat.o(82073);
      return bool;
    }
    AppMethodBeat.o(82073);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(82086);
    if (this.Kuv != null)
    {
      setKeepScreenOn(false);
      this.sUi.fZ(false);
      boolean bool = this.Kuv.pause();
      AppMethodBeat.o(82086);
      return bool;
    }
    AppMethodBeat.o(82086);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(82083);
    if (this.Kuv != null) {
      this.Kuv.setCover(paramBitmap);
    }
    AppMethodBeat.o(82083);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(82076);
    if (this.Kuv != null) {
      this.Kuv.setFullDirection(paramInt);
    }
    AppMethodBeat.o(82076);
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    this.sUh = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(82075);
    if (this.Kuv != null) {
      this.Kuv.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(82075);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(82101);
    Log.d("MicroMsg.WebVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Util.getStack() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(82101);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setLoopCompletionCallback(i.d paramd) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(82087);
    if (this.Kuv != null) {
      this.Kuv.setMute(paramBoolean);
    }
    AppMethodBeat.o(82087);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(82091);
    if (this.Kuv != null) {
      this.Kuv.setScaleType(parame);
    }
    AppMethodBeat.o(82091);
  }
  
  public void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(82070);
    if (this.Kuv != null) {
      this.Kuv.setVideoFooterView(paramh);
    }
    AppMethodBeat.o(82070);
  }
  
  public final void start()
  {
    AppMethodBeat.i(82084);
    if (this.Kuv != null)
    {
      this.Kuv.start();
      setKeepScreenOn(true);
      this.sUi.a(this);
    }
    AppMethodBeat.o(82084);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(82085);
    if (this.Kuv != null)
    {
      this.Kuv.stop();
      this.sUi.fZ(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(82085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.WebVideoWrapper
 * JD-Core Version:    0.7.0.1
 */