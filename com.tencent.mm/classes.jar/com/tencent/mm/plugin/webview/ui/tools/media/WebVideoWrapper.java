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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class WebVideoWrapper
  extends RelativeLayout
  implements d.a, com.tencent.mm.pluginsdk.ui.h, h.b, h.c
{
  private boolean bqS;
  private int knG;
  private Context mContext;
  private h.b nns;
  private d nnt;
  private String url;
  private com.tencent.mm.pluginsdk.ui.h xdR;
  
  public WebVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WebVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(82068);
    this.mContext = paramContext;
    this.nnt = new d();
    if (this.xdR == null)
    {
      paramContext = new CommonVideoView(this.mContext);
      paramContext.setReporter(this);
      paramContext.setIMMVideoViewCallback(this);
      ln(200L);
      this.xdR = paramContext;
    }
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(13);
    addView((View)this.xdR, paramContext);
    AppMethodBeat.o(82068);
  }
  
  public final boolean aXf()
  {
    AppMethodBeat.i(82082);
    if (this.xdR != null)
    {
      boolean bool = this.xdR.aXf();
      AppMethodBeat.o(82082);
      return bool;
    }
    AppMethodBeat.o(82082);
    return false;
  }
  
  public final void aqt() {}
  
  public final void aqu() {}
  
  public final void aqv() {}
  
  public final void aqw() {}
  
  public final boolean ax(float paramFloat)
  {
    AppMethodBeat.i(82092);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(82092);
      return false;
    }
    if (this.xdR != null)
    {
      boolean bool = this.xdR.ax(paramFloat);
      AppMethodBeat.o(82092);
      return bool;
    }
    AppMethodBeat.o(82092);
    return false;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82093);
    ad.w("MicroMsg.WebVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.nns != null) {
      this.nns.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(82093);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(82069);
    this.knG = paramInt;
    this.bqS = paramBoolean;
    this.url = paramString;
    if (this.xdR != null) {
      this.xdR.c(this.bqS, this.url, this.knG);
    }
    AppMethodBeat.o(82069);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(82074);
    if (this.xdR != null)
    {
      paramBoolean = this.xdR.c(paramDouble, paramBoolean);
      AppMethodBeat.o(82074);
      return paramBoolean;
    }
    AppMethodBeat.o(82074);
    return false;
  }
  
  public final void cCC()
  {
    AppMethodBeat.i(82071);
    if (this.xdR != null) {
      this.xdR.cCC();
    }
    AppMethodBeat.o(82071);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82096);
    ad.i("MicroMsg.WebVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.nns != null) {
      this.nns.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(82096);
  }
  
  public final void db(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82094);
    ad.i("MicroMsg.WebVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.nns != null) {
      this.nns.db(paramString1, paramString2);
    }
    AppMethodBeat.o(82094);
  }
  
  public final void dc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82095);
    ad.i("MicroMsg.WebVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.nns != null) {
      this.nns.dc(paramString1, paramString2);
    }
    AppMethodBeat.o(82095);
  }
  
  public final void dd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82097);
    ad.d("MicroMsg.WebVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.nnt.ea(false);
    if (this.nns != null) {
      this.nns.dd(paramString1, paramString2);
    }
    AppMethodBeat.o(82097);
  }
  
  public final void de(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82098);
    ad.d("MicroMsg.WebVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.nnt.a(this);
    if (this.nns != null) {
      this.nns.de(paramString1, paramString2);
    }
    AppMethodBeat.o(82098);
  }
  
  public final void dg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82099);
    if (this.nns != null) {
      this.nns.dg(paramString1, paramString2);
    }
    AppMethodBeat.o(82099);
  }
  
  public final void dh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82100);
    if (this.nns != null) {
      this.nns.dh(paramString1, paramString2);
    }
    AppMethodBeat.o(82100);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(82080);
    if (this.xdR != null)
    {
      int i = this.xdR.getCacheTimeSec();
      AppMethodBeat.o(82080);
      return i;
    }
    AppMethodBeat.o(82080);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(82078);
    if (this.xdR != null)
    {
      int i = this.xdR.getCurrPosMs();
      AppMethodBeat.o(82078);
      return i;
    }
    AppMethodBeat.o(82078);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(82079);
    if (this.xdR != null)
    {
      int i = this.xdR.getCurrPosSec();
      AppMethodBeat.o(82079);
      return i;
    }
    AppMethodBeat.o(82079);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(82072);
    if (this.xdR != null)
    {
      int i = this.xdR.getPlayerType();
      AppMethodBeat.o(82072);
      return i;
    }
    AppMethodBeat.o(82072);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(82077);
    if (this.xdR != null)
    {
      i = this.xdR.getVideoDurationSec();
      AppMethodBeat.o(82077);
      return i;
    }
    int i = this.knG;
    AppMethodBeat.o(82077);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(82081);
    if (this.xdR != null)
    {
      boolean bool = this.xdR.isPlaying();
      AppMethodBeat.o(82081);
      return bool;
    }
    AppMethodBeat.o(82081);
    return false;
  }
  
  public final void jw(String paramString1, String paramString2) {}
  
  public final void ln(long paramLong)
  {
    AppMethodBeat.i(82102);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(82102);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(82090);
    if (this.xdR != null) {
      this.xdR.onUIDestroy();
    }
    this.nnt.ea(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(82090);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(82089);
    if (this.xdR != null) {
      this.xdR.onUIPause();
    }
    this.nnt.ea(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(82089);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(82088);
    if (this.xdR != null) {
      this.xdR.onUIResume();
    }
    AppMethodBeat.o(82088);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(82073);
    if (this.xdR != null)
    {
      boolean bool = this.xdR.p(paramDouble);
      AppMethodBeat.o(82073);
      return bool;
    }
    AppMethodBeat.o(82073);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(82086);
    if (this.xdR != null)
    {
      setKeepScreenOn(false);
      this.nnt.ea(false);
      boolean bool = this.xdR.pause();
      AppMethodBeat.o(82086);
      return bool;
    }
    AppMethodBeat.o(82086);
    return false;
  }
  
  public final void pj(String paramString)
  {
    AppMethodBeat.i(82103);
    com.tencent.mm.plugin.report.service.h.vKh.kvStat(14349, paramString);
    AppMethodBeat.o(82103);
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(82083);
    if (this.xdR != null) {
      this.xdR.setCover(paramBitmap);
    }
    AppMethodBeat.o(82083);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(82076);
    if (this.xdR != null) {
      this.xdR.setFullDirection(paramInt);
    }
    AppMethodBeat.o(82076);
  }
  
  public void setIMMVideoViewCallback(h.b paramb)
  {
    this.nns = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(82075);
    if (this.xdR != null) {
      this.xdR.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(82075);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(82101);
    ad.d("MicroMsg.WebVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bt.eGN() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(82101);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setLoopCompletionCallback(h.d paramd) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(82087);
    if (this.xdR != null) {
      this.xdR.setMute(paramBoolean);
    }
    AppMethodBeat.o(82087);
  }
  
  public void setScaleType(h.e parame)
  {
    AppMethodBeat.i(82091);
    if (this.xdR != null) {
      this.xdR.setScaleType(parame);
    }
    AppMethodBeat.o(82091);
  }
  
  public void setVideoFooterView(g paramg)
  {
    AppMethodBeat.i(82070);
    if (this.xdR != null) {
      this.xdR.setVideoFooterView(paramg);
    }
    AppMethodBeat.o(82070);
  }
  
  public final void start()
  {
    AppMethodBeat.i(82084);
    if (this.xdR != null)
    {
      this.xdR.start();
      setKeepScreenOn(true);
      this.nnt.a(this);
    }
    AppMethodBeat.o(82084);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(82085);
    if (this.xdR != null)
    {
      this.xdR.stop();
      this.nnt.ea(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(82085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.WebVideoWrapper
 * JD-Core Version:    0.7.0.1
 */