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
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class WebVideoWrapper
  extends RelativeLayout
  implements d.a, com.tencent.mm.pluginsdk.ui.h, h.b, h.c
{
  private boolean bps;
  private int kPa;
  private Context mContext;
  private h.b nQs;
  private d nQt;
  private String url;
  private com.tencent.mm.pluginsdk.ui.h yqG;
  
  public WebVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WebVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(82068);
    this.mContext = paramContext;
    this.nQt = new d();
    if (this.yqG == null)
    {
      paramContext = new CommonVideoView(this.mContext);
      paramContext.setReporter(this);
      paramContext.setIMMVideoViewCallback(this);
      oQ(200L);
      this.yqG = paramContext;
    }
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(13);
    addView((View)this.yqG, paramContext);
    AppMethodBeat.o(82068);
  }
  
  public final boolean aB(float paramFloat)
  {
    AppMethodBeat.i(82092);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(82092);
      return false;
    }
    if (this.yqG != null)
    {
      boolean bool = this.yqG.aB(paramFloat);
      AppMethodBeat.o(82092);
      return bool;
    }
    AppMethodBeat.o(82092);
    return false;
  }
  
  public final void axj() {}
  
  public final void axk() {}
  
  public final void axl() {}
  
  public final void axm() {}
  
  public final boolean bed()
  {
    AppMethodBeat.i(82082);
    if (this.yqG != null)
    {
      boolean bool = this.yqG.bed();
      AppMethodBeat.o(82082);
      return bool;
    }
    AppMethodBeat.o(82082);
    return false;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82093);
    ac.w("MicroMsg.WebVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.nQs != null) {
      this.nQs.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(82093);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(82069);
    this.kPa = paramInt;
    this.bps = paramBoolean;
    this.url = paramString;
    if (this.yqG != null) {
      this.yqG.c(this.bps, this.url, this.kPa);
    }
    AppMethodBeat.o(82069);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(82074);
    if (this.yqG != null)
    {
      paramBoolean = this.yqG.c(paramDouble, paramBoolean);
      AppMethodBeat.o(82074);
      return paramBoolean;
    }
    AppMethodBeat.o(82074);
    return false;
  }
  
  public final void cDR()
  {
    AppMethodBeat.i(82071);
    if (this.yqG != null) {
      this.yqG.cDR();
    }
    AppMethodBeat.o(82071);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82096);
    ac.i("MicroMsg.WebVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.nQs != null) {
      this.nQs.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(82096);
  }
  
  public final void jdMethod_do(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82094);
    ac.i("MicroMsg.WebVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.nQs != null) {
      this.nQs.jdMethod_do(paramString1, paramString2);
    }
    AppMethodBeat.o(82094);
  }
  
  public final void dp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82095);
    ac.i("MicroMsg.WebVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.nQs != null) {
      this.nQs.dp(paramString1, paramString2);
    }
    AppMethodBeat.o(82095);
  }
  
  public final void dq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82097);
    ac.d("MicroMsg.WebVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.nQt.ev(false);
    if (this.nQs != null) {
      this.nQs.dq(paramString1, paramString2);
    }
    AppMethodBeat.o(82097);
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82098);
    ac.d("MicroMsg.WebVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.nQt.a(this);
    if (this.nQs != null) {
      this.nQs.dr(paramString1, paramString2);
    }
    AppMethodBeat.o(82098);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82099);
    if (this.nQs != null) {
      this.nQs.ds(paramString1, paramString2);
    }
    AppMethodBeat.o(82099);
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82100);
    if (this.nQs != null) {
      this.nQs.dt(paramString1, paramString2);
    }
    AppMethodBeat.o(82100);
  }
  
  public final void eJ(String paramString1, String paramString2) {}
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(82080);
    if (this.yqG != null)
    {
      int i = this.yqG.getCacheTimeSec();
      AppMethodBeat.o(82080);
      return i;
    }
    AppMethodBeat.o(82080);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(82078);
    if (this.yqG != null)
    {
      int i = this.yqG.getCurrPosMs();
      AppMethodBeat.o(82078);
      return i;
    }
    AppMethodBeat.o(82078);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(82079);
    if (this.yqG != null)
    {
      int i = this.yqG.getCurrPosSec();
      AppMethodBeat.o(82079);
      return i;
    }
    AppMethodBeat.o(82079);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(82072);
    if (this.yqG != null)
    {
      int i = this.yqG.getPlayerType();
      AppMethodBeat.o(82072);
      return i;
    }
    AppMethodBeat.o(82072);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(82077);
    if (this.yqG != null)
    {
      i = this.yqG.getVideoDurationSec();
      AppMethodBeat.o(82077);
      return i;
    }
    int i = this.kPa;
    AppMethodBeat.o(82077);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(82081);
    if (this.yqG != null)
    {
      boolean bool = this.yqG.isPlaying();
      AppMethodBeat.o(82081);
      return bool;
    }
    AppMethodBeat.o(82081);
    return false;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(82073);
    if (this.yqG != null)
    {
      boolean bool = this.yqG.o(paramDouble);
      AppMethodBeat.o(82073);
      return bool;
    }
    AppMethodBeat.o(82073);
    return false;
  }
  
  public final void oQ(long paramLong)
  {
    AppMethodBeat.i(82102);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(82102);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(82090);
    if (this.yqG != null) {
      this.yqG.onUIDestroy();
    }
    this.nQt.ev(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(82090);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(82089);
    if (this.yqG != null) {
      this.yqG.onUIPause();
    }
    this.nQt.ev(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(82089);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(82088);
    if (this.yqG != null) {
      this.yqG.onUIResume();
    }
    AppMethodBeat.o(82088);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(82086);
    if (this.yqG != null)
    {
      setKeepScreenOn(false);
      this.nQt.ev(false);
      boolean bool = this.yqG.pause();
      AppMethodBeat.o(82086);
      return bool;
    }
    AppMethodBeat.o(82086);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(82083);
    if (this.yqG != null) {
      this.yqG.setCover(paramBitmap);
    }
    AppMethodBeat.o(82083);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(82076);
    if (this.yqG != null) {
      this.yqG.setFullDirection(paramInt);
    }
    AppMethodBeat.o(82076);
  }
  
  public void setIMMVideoViewCallback(h.b paramb)
  {
    this.nQs = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(82075);
    if (this.yqG != null) {
      this.yqG.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(82075);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(82101);
    ac.d("MicroMsg.WebVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bs.eWi() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(82101);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setLoopCompletionCallback(h.d paramd) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(82087);
    if (this.yqG != null) {
      this.yqG.setMute(paramBoolean);
    }
    AppMethodBeat.o(82087);
  }
  
  public void setScaleType(h.e parame)
  {
    AppMethodBeat.i(82091);
    if (this.yqG != null) {
      this.yqG.setScaleType(parame);
    }
    AppMethodBeat.o(82091);
  }
  
  public void setVideoFooterView(g paramg)
  {
    AppMethodBeat.i(82070);
    if (this.yqG != null) {
      this.yqG.setVideoFooterView(paramg);
    }
    AppMethodBeat.o(82070);
  }
  
  public final void start()
  {
    AppMethodBeat.i(82084);
    if (this.yqG != null)
    {
      this.yqG.start();
      setKeepScreenOn(true);
      this.nQt.a(this);
    }
    AppMethodBeat.o(82084);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(82085);
    if (this.yqG != null)
    {
      this.yqG.stop();
      this.nQt.ev(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(82085);
  }
  
  public final void sv(String paramString)
  {
    AppMethodBeat.i(82103);
    com.tencent.mm.plugin.report.service.h.wUl.kvStat(14349, paramString);
    AppMethodBeat.o(82103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.WebVideoWrapper
 * JD-Core Version:    0.7.0.1
 */