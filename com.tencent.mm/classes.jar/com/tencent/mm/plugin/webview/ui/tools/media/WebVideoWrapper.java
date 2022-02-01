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
  private i Eho;
  private boolean bzP;
  private Context mContext;
  private int mwI;
  private i.b pNj;
  private d pNk;
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
    this.pNk = new d();
    if (this.Eho == null)
    {
      paramContext = new CommonVideoView(this.mContext);
      paramContext.setReporter(this);
      paramContext.setIMMVideoViewCallback(this);
      yU(200L);
      this.Eho = paramContext;
    }
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(13);
    addView((View)this.Eho, paramContext);
    AppMethodBeat.o(82068);
  }
  
  public final void DX(String paramString)
  {
    AppMethodBeat.i(82103);
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(14349, paramString);
    AppMethodBeat.o(82103);
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(82092);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(82092);
      return false;
    }
    if (this.Eho != null)
    {
      boolean bool = this.Eho.aO(paramFloat);
      AppMethodBeat.o(82092);
      return bool;
    }
    AppMethodBeat.o(82092);
    return false;
  }
  
  public final void aTw() {}
  
  public final void aTx() {}
  
  public final void aTy() {}
  
  public final void aTz() {}
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82093);
    Log.w("MicroMsg.WebVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.pNj != null) {
      this.pNj.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(82093);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(82069);
    this.mwI = paramInt;
    this.bzP = paramBoolean;
    this.url = paramString;
    if (this.Eho != null) {
      this.Eho.c(this.bzP, this.url, this.mwI);
    }
    AppMethodBeat.o(82069);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(82074);
    if (this.Eho != null)
    {
      paramBoolean = this.Eho.c(paramDouble, paramBoolean);
      AppMethodBeat.o(82074);
      return paramBoolean;
    }
    AppMethodBeat.o(82074);
    return false;
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82096);
    Log.i("MicroMsg.WebVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.pNj != null) {
      this.pNj.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(82096);
  }
  
  public final void dFl()
  {
    AppMethodBeat.i(82071);
    if (this.Eho != null) {
      this.Eho.dFl();
    }
    AppMethodBeat.o(82071);
  }
  
  public final void dH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82094);
    Log.i("MicroMsg.WebVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.pNj != null) {
      this.pNj.dH(paramString1, paramString2);
    }
    AppMethodBeat.o(82094);
  }
  
  public final void dI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82095);
    Log.i("MicroMsg.WebVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.pNj != null) {
      this.pNj.dI(paramString1, paramString2);
    }
    AppMethodBeat.o(82095);
  }
  
  public final void dJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82097);
    Log.d("MicroMsg.WebVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.pNk.fp(false);
    if (this.pNj != null) {
      this.pNj.dJ(paramString1, paramString2);
    }
    AppMethodBeat.o(82097);
  }
  
  public final void dK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82098);
    Log.d("MicroMsg.WebVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.pNk.a(this);
    if (this.pNj != null) {
      this.pNj.dK(paramString1, paramString2);
    }
    AppMethodBeat.o(82098);
  }
  
  public final void dL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82099);
    if (this.pNj != null) {
      this.pNj.dL(paramString1, paramString2);
    }
    AppMethodBeat.o(82099);
  }
  
  public final void dM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82100);
    if (this.pNj != null) {
      this.pNj.dM(paramString1, paramString2);
    }
    AppMethodBeat.o(82100);
  }
  
  public final void fo(String paramString1, String paramString2) {}
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(82080);
    if (this.Eho != null)
    {
      int i = this.Eho.getCacheTimeSec();
      AppMethodBeat.o(82080);
      return i;
    }
    AppMethodBeat.o(82080);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(82078);
    if (this.Eho != null)
    {
      int i = this.Eho.getCurrPosMs();
      AppMethodBeat.o(82078);
      return i;
    }
    AppMethodBeat.o(82078);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(82079);
    if (this.Eho != null)
    {
      int i = this.Eho.getCurrPosSec();
      AppMethodBeat.o(82079);
      return i;
    }
    AppMethodBeat.o(82079);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(82072);
    if (this.Eho != null)
    {
      int i = this.Eho.getPlayerType();
      AppMethodBeat.o(82072);
      return i;
    }
    AppMethodBeat.o(82072);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(82077);
    if (this.Eho != null)
    {
      i = this.Eho.getVideoDurationSec();
      AppMethodBeat.o(82077);
      return i;
    }
    int i = this.mwI;
    AppMethodBeat.o(82077);
    return i;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(82082);
    if (this.Eho != null)
    {
      boolean bool = this.Eho.isLive();
      AppMethodBeat.o(82082);
      return bool;
    }
    AppMethodBeat.o(82082);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(82081);
    if (this.Eho != null)
    {
      boolean bool = this.Eho.isPlaying();
      AppMethodBeat.o(82081);
      return bool;
    }
    AppMethodBeat.o(82081);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(82090);
    if (this.Eho != null) {
      this.Eho.onUIDestroy();
    }
    this.pNk.fp(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(82090);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(82089);
    if (this.Eho != null) {
      this.Eho.onUIPause();
    }
    this.pNk.fp(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(82089);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(82088);
    if (this.Eho != null) {
      this.Eho.onUIResume();
    }
    AppMethodBeat.o(82088);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(82073);
    if (this.Eho != null)
    {
      boolean bool = this.Eho.p(paramDouble);
      AppMethodBeat.o(82073);
      return bool;
    }
    AppMethodBeat.o(82073);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(82086);
    if (this.Eho != null)
    {
      setKeepScreenOn(false);
      this.pNk.fp(false);
      boolean bool = this.Eho.pause();
      AppMethodBeat.o(82086);
      return bool;
    }
    AppMethodBeat.o(82086);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(82083);
    if (this.Eho != null) {
      this.Eho.setCover(paramBitmap);
    }
    AppMethodBeat.o(82083);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(82076);
    if (this.Eho != null) {
      this.Eho.setFullDirection(paramInt);
    }
    AppMethodBeat.o(82076);
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    this.pNj = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(82075);
    if (this.Eho != null) {
      this.Eho.setIsShowBasicControls(paramBoolean);
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
    if (this.Eho != null) {
      this.Eho.setMute(paramBoolean);
    }
    AppMethodBeat.o(82087);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(82091);
    if (this.Eho != null) {
      this.Eho.setScaleType(parame);
    }
    AppMethodBeat.o(82091);
  }
  
  public void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(82070);
    if (this.Eho != null) {
      this.Eho.setVideoFooterView(paramh);
    }
    AppMethodBeat.o(82070);
  }
  
  public final void start()
  {
    AppMethodBeat.i(82084);
    if (this.Eho != null)
    {
      this.Eho.start();
      setKeepScreenOn(true);
      this.pNk.a(this);
    }
    AppMethodBeat.o(82084);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(82085);
    if (this.Eho != null)
    {
      this.Eho.stop();
      this.pNk.fp(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(82085);
  }
  
  public final void yU(long paramLong)
  {
    AppMethodBeat.i(82102);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(82102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.WebVideoWrapper
 * JD-Core Version:    0.7.0.1
 */