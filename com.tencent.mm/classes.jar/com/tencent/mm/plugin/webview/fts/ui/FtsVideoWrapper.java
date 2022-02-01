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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class FtsVideoWrapper
  extends RelativeLayout
  implements d.a, i, i.a, i.b, i.c
{
  private boolean bzN;
  private boolean dDV;
  private boolean hyd;
  private float lqb;
  private int lqc;
  private Context mContext;
  private i.b ozA;
  private d ozB;
  private h ozw;
  private String url;
  private i.e xOi;
  private i zYX;
  
  public FtsVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FtsVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(77989);
    this.xOi = i.e.Flj;
    this.hyd = false;
    this.lqb = -1.0F;
    this.mContext = paramContext;
    this.ozB = new d();
    AppMethodBeat.o(77989);
  }
  
  private i daY()
  {
    AppMethodBeat.i(77991);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.setReporter(this);
    localCommonVideoView.setIMMVideoViewCallback(this);
    AppMethodBeat.o(77991);
    return localCommonVideoView;
  }
  
  public final void aAo() {}
  
  public final void aAp() {}
  
  public final void aAq() {}
  
  public final void aAr() {}
  
  public final boolean aE(float paramFloat)
  {
    AppMethodBeat.i(78014);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(78014);
      return false;
    }
    this.lqb = paramFloat;
    if (this.zYX != null)
    {
      boolean bool = this.zYX.aE(this.lqb);
      AppMethodBeat.o(78014);
      return bool;
    }
    AppMethodBeat.o(78014);
    return false;
  }
  
  public final void aM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(78015);
    ae.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      AppMethodBeat.o(78015);
      return;
    }
    if ((this.zYX instanceof MMVideoView))
    {
      this.zYX.stop();
      this.zYX.cOS();
      removeView((View)this.zYX);
      ae.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.zYX = daY();
    }
    for (int i = 1;; i = 0)
    {
      setScaleType(this.xOi);
      aE(this.lqb);
      setMute(this.hyd);
      if (i != 0)
      {
        setVideoFooterView(this.ozw);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.zYX, paramString);
        this.zYX.c(this.bzN, this.url, this.lqc);
        this.zYX.start();
      }
      AppMethodBeat.o(78015);
      return;
    }
  }
  
  public final boolean bip()
  {
    AppMethodBeat.i(78004);
    if (this.zYX != null)
    {
      boolean bool = this.zYX.bip();
      AppMethodBeat.o(78004);
      return bool;
    }
    AppMethodBeat.o(78004);
    return false;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78016);
    ae.w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.ozA != null) {
      this.ozA.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(78016);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(77990);
    this.lqc = paramInt;
    this.bzN = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    bu.isNullOrNil(localPString.value);
    this.dDV = false;
    this.url = localPString.value;
    if (this.zYX == null)
    {
      ae.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.zYX = daY();
      paramInt = 1;
    }
    for (;;)
    {
      setScaleType(this.xOi);
      aE(this.lqb);
      setMute(this.hyd);
      if (paramInt != 0)
      {
        setVideoFooterView(this.ozw);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.zYX, paramString);
      }
      this.zYX.c(this.bzN, this.url, this.lqc);
      AppMethodBeat.o(77990);
      return;
      if ((this.zYX instanceof MMVideoView))
      {
        this.zYX.stop();
        this.zYX.cOS();
        removeView((View)this.zYX);
        ae.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.zYX = daY();
        paramInt = 1;
      }
      else
      {
        ae.i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.zYX.stop();
        paramInt = 0;
      }
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(77996);
    if (this.zYX != null)
    {
      paramBoolean = this.zYX.c(paramDouble, paramBoolean);
      AppMethodBeat.o(77996);
      return paramBoolean;
    }
    AppMethodBeat.o(77996);
    return false;
  }
  
  public final void cOS()
  {
    AppMethodBeat.i(77993);
    if (this.zYX != null) {
      this.zYX.cOS();
    }
    AppMethodBeat.o(77993);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78019);
    ae.i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.ozA != null) {
      this.ozA.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(78019);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78017);
    ae.i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.ozA != null) {
      this.ozA.ds(paramString1, paramString2);
    }
    AppMethodBeat.o(78017);
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78018);
    ae.i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.ozA != null) {
      this.ozA.dt(paramString1, paramString2);
    }
    AppMethodBeat.o(78018);
  }
  
  public final void du(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78020);
    ae.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.ozB.ez(false);
    if (this.ozA != null) {
      this.ozA.du(paramString1, paramString2);
    }
    AppMethodBeat.o(78020);
  }
  
  public final void dv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78021);
    ae.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.ozB.a(this);
    if (this.ozA != null) {
      this.ozA.dv(paramString1, paramString2);
    }
    AppMethodBeat.o(78021);
  }
  
  public final void dw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78022);
    if (this.ozA != null) {
      this.ozA.dw(paramString1, paramString2);
    }
    AppMethodBeat.o(78022);
  }
  
  public final void dx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78023);
    if (this.ozA != null) {
      this.ozA.dx(paramString1, paramString2);
    }
    AppMethodBeat.o(78023);
  }
  
  public final void eX(String paramString1, String paramString2) {}
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(78002);
    if (this.zYX != null)
    {
      int i = this.zYX.getCacheTimeSec();
      AppMethodBeat.o(78002);
      return i;
    }
    AppMethodBeat.o(78002);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(78000);
    if (this.zYX != null)
    {
      int i = this.zYX.getCurrPosMs();
      AppMethodBeat.o(78000);
      return i;
    }
    AppMethodBeat.o(78000);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(78001);
    if (this.zYX != null)
    {
      int i = this.zYX.getCurrPosSec();
      AppMethodBeat.o(78001);
      return i;
    }
    AppMethodBeat.o(78001);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(77994);
    if (this.zYX != null)
    {
      int i = this.zYX.getPlayerType();
      AppMethodBeat.o(77994);
      return i;
    }
    AppMethodBeat.o(77994);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(77999);
    if (this.zYX != null)
    {
      i = this.zYX.getVideoDurationSec();
      AppMethodBeat.o(77999);
      return i;
    }
    int i = this.lqc;
    AppMethodBeat.o(77999);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(78003);
    if (this.zYX != null)
    {
      boolean bool = this.zYX.isPlaying();
      AppMethodBeat.o(78003);
      return bool;
    }
    AppMethodBeat.o(78003);
    return false;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(77995);
    if (this.zYX != null)
    {
      boolean bool = this.zYX.o(paramDouble);
      AppMethodBeat.o(77995);
      return bool;
    }
    AppMethodBeat.o(77995);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(78012);
    if (this.zYX != null) {
      this.zYX.onUIDestroy();
    }
    this.ozB.ez(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(78012);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(78011);
    if (this.zYX != null) {
      this.zYX.onUIPause();
    }
    this.ozB.ez(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(78011);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(78010);
    if (this.zYX != null) {
      this.zYX.onUIResume();
    }
    AppMethodBeat.o(78010);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(78008);
    if (this.zYX != null)
    {
      setKeepScreenOn(false);
      this.ozB.ez(false);
      boolean bool = this.zYX.pause();
      AppMethodBeat.o(78008);
      return bool;
    }
    AppMethodBeat.o(78008);
    return false;
  }
  
  public final void rd(long paramLong)
  {
    AppMethodBeat.i(78025);
    g.yxI.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(78025);
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(78005);
    if (this.zYX != null) {
      this.zYX.setCover(paramBitmap);
    }
    AppMethodBeat.o(78005);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(77998);
    if (this.zYX != null) {
      this.zYX.setFullDirection(paramInt);
    }
    AppMethodBeat.o(77998);
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    this.ozA = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(77997);
    if (this.zYX != null) {
      this.zYX.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(77997);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(78024);
    ae.d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bu.fpN() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(78024);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setLoopCompletionCallback(i.d paramd) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(78009);
    this.hyd = paramBoolean;
    if (this.zYX != null) {
      this.zYX.setMute(this.hyd);
    }
    AppMethodBeat.o(78009);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(78013);
    this.xOi = parame;
    if (this.zYX != null) {
      this.zYX.setScaleType(this.xOi);
    }
    AppMethodBeat.o(78013);
  }
  
  public void setVideoFooterView(h paramh)
  {
    AppMethodBeat.i(77992);
    this.ozw = paramh;
    if (this.zYX != null) {
      this.zYX.setVideoFooterView(this.ozw);
    }
    AppMethodBeat.o(77992);
  }
  
  public final void start()
  {
    AppMethodBeat.i(78006);
    if (this.zYX != null)
    {
      this.zYX.start();
      setKeepScreenOn(true);
      this.ozB.a(this);
    }
    AppMethodBeat.o(78006);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(78007);
    if (this.zYX != null)
    {
      this.zYX.stop();
      this.ozB.ez(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(78007);
  }
  
  public final void vG(String paramString)
  {
    AppMethodBeat.i(78026);
    g.yxI.kvStat(14349, paramString);
    AppMethodBeat.o(78026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsVideoWrapper
 * JD-Core Version:    0.7.0.1
 */