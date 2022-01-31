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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class WebVideoWrapper
  extends RelativeLayout
  implements d.a, com.tencent.mm.pluginsdk.ui.h, h.b, h.c
{
  private boolean aTq;
  private int idD;
  private d idF;
  private com.tencent.mm.pluginsdk.ui.h idy;
  private Context mContext;
  private h.b ryi;
  private String url;
  
  public WebVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WebVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(9860);
    this.mContext = paramContext;
    this.idF = new d();
    if (this.idy == null)
    {
      paramContext = new CommonVideoView(this.mContext);
      paramContext.setReporter(this);
      paramContext.setIMMVideoViewCallback(this);
      hB(200L);
      this.idy = paramContext;
    }
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(13);
    addView((View)this.idy, paramContext);
    AppMethodBeat.o(9860);
  }
  
  public final void aEM()
  {
    AppMethodBeat.i(9882);
    if (this.idy != null) {
      this.idy.aEM();
    }
    this.idF.cJ(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(9882);
  }
  
  public final void alo()
  {
    AppMethodBeat.i(9881);
    if (this.idy != null) {
      this.idy.alo();
    }
    this.idF.cJ(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(9881);
  }
  
  public final void alp()
  {
    AppMethodBeat.i(9880);
    if (this.idy != null) {
      this.idy.alp();
    }
    AppMethodBeat.o(9880);
  }
  
  public final boolean ay(float paramFloat)
  {
    AppMethodBeat.i(9884);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(9884);
      return false;
    }
    if (this.idy != null)
    {
      boolean bool = this.idy.ay(paramFloat);
      AppMethodBeat.o(9884);
      return bool;
    }
    AppMethodBeat.o(9884);
    return false;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9885);
    ab.w("MicroMsg.WebVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.ryi != null) {
      this.ryi.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(9885);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(9861);
    this.idD = paramInt;
    this.aTq = paramBoolean;
    this.url = paramString;
    if (this.idy != null) {
      this.idy.c(this.aTq, this.url, this.idD);
    }
    AppMethodBeat.o(9861);
  }
  
  public final void cq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(9886);
    ab.i("MicroMsg.WebVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.ryi != null) {
      this.ryi.cq(paramString1, paramString2);
    }
    AppMethodBeat.o(9886);
  }
  
  public final void cr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(9887);
    ab.i("MicroMsg.WebVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.ryi != null) {
      this.ryi.cr(paramString1, paramString2);
    }
    AppMethodBeat.o(9887);
  }
  
  public final void crA()
  {
    AppMethodBeat.i(9863);
    if (this.idy != null) {
      this.idy.crA();
    }
    AppMethodBeat.o(9863);
  }
  
  public final void cs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(9889);
    ab.d("MicroMsg.WebVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.idF.cJ(false);
    if (this.ryi != null) {
      this.ryi.cs(paramString1, paramString2);
    }
    AppMethodBeat.o(9889);
  }
  
  public final void ct(String paramString1, String paramString2)
  {
    AppMethodBeat.i(9890);
    ab.d("MicroMsg.WebVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.idF.a(this);
    if (this.ryi != null) {
      this.ryi.ct(paramString1, paramString2);
    }
    AppMethodBeat.o(9890);
  }
  
  public final void cu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(9891);
    if (this.ryi != null) {
      this.ryi.cu(paramString1, paramString2);
    }
    AppMethodBeat.o(9891);
  }
  
  public final void cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(9892);
    if (this.ryi != null) {
      this.ryi.cv(paramString1, paramString2);
    }
    AppMethodBeat.o(9892);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9888);
    ab.i("MicroMsg.WebVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.ryi != null) {
      this.ryi.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(9888);
  }
  
  public final boolean d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(9866);
    if (this.idy != null)
    {
      paramBoolean = this.idy.d(paramDouble, paramBoolean);
      AppMethodBeat.o(9866);
      return paramBoolean;
    }
    AppMethodBeat.o(9866);
    return false;
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(9872);
    if (this.idy != null)
    {
      int i = this.idy.getCacheTimeSec();
      AppMethodBeat.o(9872);
      return i;
    }
    AppMethodBeat.o(9872);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(9870);
    if (this.idy != null)
    {
      int i = this.idy.getCurrPosMs();
      AppMethodBeat.o(9870);
      return i;
    }
    AppMethodBeat.o(9870);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(9871);
    if (this.idy != null)
    {
      int i = this.idy.getCurrPosSec();
      AppMethodBeat.o(9871);
      return i;
    }
    AppMethodBeat.o(9871);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(9864);
    if (this.idy != null)
    {
      int i = this.idy.getPlayerType();
      AppMethodBeat.o(9864);
      return i;
    }
    AppMethodBeat.o(9864);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(9869);
    if (this.idy != null)
    {
      i = this.idy.getVideoDurationSec();
      AppMethodBeat.o(9869);
      return i;
    }
    int i = this.idD;
    AppMethodBeat.o(9869);
    return i;
  }
  
  public final void hB(long paramLong)
  {
    AppMethodBeat.i(9894);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(9894);
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(9874);
    if (this.idy != null)
    {
      boolean bool = this.idy.isLive();
      AppMethodBeat.o(9874);
      return bool;
    }
    AppMethodBeat.o(9874);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(9873);
    if (this.idy != null)
    {
      boolean bool = this.idy.isPlaying();
      AppMethodBeat.o(9873);
      return bool;
    }
    AppMethodBeat.o(9873);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(9878);
    if (this.idy != null)
    {
      setKeepScreenOn(false);
      this.idF.cJ(false);
      boolean bool = this.idy.pause();
      AppMethodBeat.o(9878);
      return bool;
    }
    AppMethodBeat.o(9878);
    return false;
  }
  
  public final boolean r(double paramDouble)
  {
    AppMethodBeat.i(9865);
    if (this.idy != null)
    {
      boolean bool = this.idy.r(paramDouble);
      AppMethodBeat.o(9865);
      return bool;
    }
    AppMethodBeat.o(9865);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(9875);
    if (this.idy != null) {
      this.idy.setCover(paramBitmap);
    }
    AppMethodBeat.o(9875);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(9868);
    if (this.idy != null) {
      this.idy.setFullDirection(paramInt);
    }
    AppMethodBeat.o(9868);
  }
  
  public void setIMMVideoViewCallback(h.b paramb)
  {
    this.ryi = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(9867);
    if (this.idy != null) {
      this.idy.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(9867);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(9893);
    ab.d("MicroMsg.WebVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bo.dtY() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(9893);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(9879);
    if (this.idy != null) {
      this.idy.setMute(paramBoolean);
    }
    AppMethodBeat.o(9879);
  }
  
  public void setScaleType(h.d paramd)
  {
    AppMethodBeat.i(9883);
    if (this.idy != null) {
      this.idy.setScaleType(paramd);
    }
    AppMethodBeat.o(9883);
  }
  
  public void setVideoFooterView(g paramg)
  {
    AppMethodBeat.i(9862);
    if (this.idy != null) {
      this.idy.setVideoFooterView(paramg);
    }
    AppMethodBeat.o(9862);
  }
  
  public final void start()
  {
    AppMethodBeat.i(9876);
    if (this.idy != null)
    {
      this.idy.start();
      setKeepScreenOn(true);
      this.idF.a(this);
    }
    AppMethodBeat.o(9876);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(9877);
    if (this.idy != null)
    {
      this.idy.stop();
      this.idF.cJ(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(9877);
  }
  
  public final void xE(String paramString)
  {
    AppMethodBeat.i(9895);
    com.tencent.mm.plugin.report.service.h.qsU.kvStat(14349, paramString);
    AppMethodBeat.o(9895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.WebVideoWrapper
 * JD-Core Version:    0.7.0.1
 */