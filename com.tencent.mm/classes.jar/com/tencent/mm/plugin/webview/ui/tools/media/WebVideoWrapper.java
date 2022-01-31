package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class WebVideoWrapper
  extends RelativeLayout
  implements d.a, com.tencent.mm.pluginsdk.ui.h, h.b, h.c
{
  private boolean aLW;
  private d gEB;
  private com.tencent.mm.pluginsdk.ui.h gEt;
  private int gEz;
  private Context mContext;
  private h.b oIn;
  private String url;
  
  public WebVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WebVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    this.gEB = new d();
    if (this.gEt == null)
    {
      paramContext = new CommonVideoView(this.mContext);
      paramContext.setReporter(this);
      paramContext.setIMMVideoViewCallback(this);
      cB(200L);
      this.gEt = paramContext;
    }
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(13);
    addView((View)this.gEt, paramContext);
  }
  
  public final void Se()
  {
    if (this.gEt != null) {
      this.gEt.Se();
    }
    this.gEB.bH(false);
    setKeepScreenOn(false);
  }
  
  public final void Sf()
  {
    if (this.gEt != null) {
      this.gEt.Sf();
    }
  }
  
  public final boolean aj(float paramFloat)
  {
    if (paramFloat <= 0.0F) {}
    while (this.gEt == null) {
      return false;
    }
    return this.gEt.aj(paramFloat);
  }
  
  public final void akT()
  {
    if (this.gEt != null) {
      this.gEt.akT();
    }
    this.gEB.bH(false);
    setKeepScreenOn(false);
  }
  
  public final void bFF()
  {
    if (this.gEt != null) {
      this.gEt.bFF();
    }
  }
  
  public final void bH(String paramString1, String paramString2)
  {
    y.i("MicroMsg.WebVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.oIn != null) {
      this.oIn.bH(paramString1, paramString2);
    }
  }
  
  public final void bI(String paramString1, String paramString2)
  {
    y.i("MicroMsg.WebVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.oIn != null) {
      this.oIn.bI(paramString1, paramString2);
    }
  }
  
  public final void bJ(String paramString1, String paramString2)
  {
    y.d("MicroMsg.WebVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.gEB.bH(false);
    if (this.oIn != null) {
      this.oIn.bJ(paramString1, paramString2);
    }
  }
  
  public final void bK(String paramString1, String paramString2)
  {
    y.d("MicroMsg.WebVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.gEB.a(this);
    if (this.oIn != null) {
      this.oIn.bK(paramString1, paramString2);
    }
  }
  
  public final void bL(String paramString1, String paramString2)
  {
    if (this.oIn != null) {
      this.oIn.bL(paramString1, paramString2);
    }
  }
  
  public final void bM(String paramString1, String paramString2)
  {
    if (this.oIn != null) {
      this.oIn.bM(paramString1, paramString2);
    }
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    y.w("MicroMsg.WebVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.oIn != null) {
      this.oIn.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    this.gEz = paramInt;
    this.aLW = paramBoolean;
    this.url = paramString;
    if (this.gEt != null) {
      this.gEt.c(this.aLW, this.url, this.gEz);
    }
  }
  
  public final void cB(long paramLong)
  {
    com.tencent.mm.plugin.report.service.h.nFQ.a(600L, paramLong, 1L, false);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.WebVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.oIn != null) {
      this.oIn.d(paramString1, paramString2, paramInt1, paramInt2);
    }
  }
  
  public int getCacheTimeSec()
  {
    if (this.gEt != null) {
      return this.gEt.getCacheTimeSec();
    }
    return 0;
  }
  
  public int getCurrPosMs()
  {
    if (this.gEt != null) {
      return this.gEt.getCurrPosMs();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    if (this.gEt != null) {
      return this.gEt.getCurrPosSec();
    }
    return 0;
  }
  
  public int getPlayerType()
  {
    if (this.gEt != null) {
      return this.gEt.getPlayerType();
    }
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    if (this.gEt != null) {
      return this.gEt.getVideoDurationSec();
    }
    return this.gEz;
  }
  
  public final boolean isLive()
  {
    if (this.gEt != null) {
      return this.gEt.isLive();
    }
    return false;
  }
  
  public final boolean isPlaying()
  {
    if (this.gEt != null) {
      return this.gEt.isPlaying();
    }
    return false;
  }
  
  public final boolean lF(int paramInt)
  {
    if (this.gEt != null) {
      return this.gEt.lF(paramInt);
    }
    return false;
  }
  
  public final boolean pause()
  {
    boolean bool = false;
    if (this.gEt != null)
    {
      setKeepScreenOn(false);
      this.gEB.bH(false);
      bool = this.gEt.pause();
    }
    return bool;
  }
  
  public final void qk(String paramString)
  {
    com.tencent.mm.plugin.report.service.h.nFQ.aC(14349, paramString);
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    if (this.gEt != null) {
      this.gEt.setCover(paramBitmap);
    }
  }
  
  public void setFullDirection(int paramInt)
  {
    if (this.gEt != null) {
      this.gEt.setFullDirection(paramInt);
    }
  }
  
  public void setIMMVideoViewCallback(h.b paramb)
  {
    this.oIn = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    if (this.gEt != null) {
      this.gEt.setIsShowBasicControls(paramBoolean);
    }
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    y.d("MicroMsg.WebVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bk.csb() });
    super.setKeepScreenOn(paramBoolean);
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.gEt != null) {
      this.gEt.setMute(paramBoolean);
    }
  }
  
  public void setScaleType(h.d paramd)
  {
    if (this.gEt != null) {
      this.gEt.setScaleType(paramd);
    }
  }
  
  public void setVideoFooterView(g paramg)
  {
    if (this.gEt != null) {
      this.gEt.setVideoFooterView(paramg);
    }
  }
  
  public final void start()
  {
    if (this.gEt != null)
    {
      this.gEt.start();
      setKeepScreenOn(true);
      this.gEB.a(this);
    }
  }
  
  public final void stop()
  {
    if (this.gEt != null)
    {
      this.gEt.stop();
      this.gEB.bH(false);
      setKeepScreenOn(false);
    }
  }
  
  public final boolean y(int paramInt, boolean paramBoolean)
  {
    if (this.gEt != null) {
      return this.gEt.y(paramInt, paramBoolean);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.WebVideoWrapper
 * JD-Core Version:    0.7.0.1
 */