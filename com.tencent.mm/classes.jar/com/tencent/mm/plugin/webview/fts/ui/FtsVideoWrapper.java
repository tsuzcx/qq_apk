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
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class FtsVideoWrapper
  extends RelativeLayout
  implements d.a, com.tencent.mm.pluginsdk.ui.h, h.a, h.b, h.c
{
  private boolean bqS;
  private boolean dtp;
  private boolean gCJ;
  private float knF;
  private int knG;
  private Context mContext;
  private g nno;
  private h.b nns;
  private d nnt;
  private String url;
  private h.e vhJ;
  private com.tencent.mm.pluginsdk.ui.h xdR;
  
  public FtsVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FtsVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(77989);
    this.vhJ = h.e.BVs;
    this.gCJ = false;
    this.knF = -1.0F;
    this.mContext = paramContext;
    this.nnt = new d();
    AppMethodBeat.o(77989);
  }
  
  private com.tencent.mm.pluginsdk.ui.h cCy()
  {
    AppMethodBeat.i(77991);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.setReporter(this);
    localCommonVideoView.setIMMVideoViewCallback(this);
    AppMethodBeat.o(77991);
    return localCommonVideoView;
  }
  
  public final void aH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(78015);
    ad.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      AppMethodBeat.o(78015);
      return;
    }
    if ((this.xdR instanceof MMVideoView))
    {
      this.xdR.stop();
      this.xdR.cCC();
      removeView((View)this.xdR);
      ad.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.xdR = cCy();
    }
    for (int i = 1;; i = 0)
    {
      setScaleType(this.vhJ);
      ax(this.knF);
      setMute(this.gCJ);
      if (i != 0)
      {
        setVideoFooterView(this.nno);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.xdR, paramString);
        this.xdR.c(this.bqS, this.url, this.knG);
        this.xdR.start();
      }
      AppMethodBeat.o(78015);
      return;
    }
  }
  
  public final boolean aXf()
  {
    AppMethodBeat.i(78004);
    if (this.xdR != null)
    {
      boolean bool = this.xdR.aXf();
      AppMethodBeat.o(78004);
      return bool;
    }
    AppMethodBeat.o(78004);
    return false;
  }
  
  public final void aqt() {}
  
  public final void aqu() {}
  
  public final void aqv() {}
  
  public final void aqw() {}
  
  public final boolean ax(float paramFloat)
  {
    AppMethodBeat.i(78014);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(78014);
      return false;
    }
    this.knF = paramFloat;
    if (this.xdR != null)
    {
      boolean bool = this.xdR.ax(this.knF);
      AppMethodBeat.o(78014);
      return bool;
    }
    AppMethodBeat.o(78014);
    return false;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78016);
    ad.w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.nns != null) {
      this.nns.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(78016);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(77990);
    this.knG = paramInt;
    this.bqS = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    bt.isNullOrNil(localPString.value);
    this.dtp = false;
    this.url = localPString.value;
    if (this.xdR == null)
    {
      ad.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.xdR = cCy();
      paramInt = 1;
    }
    for (;;)
    {
      setScaleType(this.vhJ);
      ax(this.knF);
      setMute(this.gCJ);
      if (paramInt != 0)
      {
        setVideoFooterView(this.nno);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.xdR, paramString);
      }
      this.xdR.c(this.bqS, this.url, this.knG);
      AppMethodBeat.o(77990);
      return;
      if ((this.xdR instanceof MMVideoView))
      {
        this.xdR.stop();
        this.xdR.cCC();
        removeView((View)this.xdR);
        ad.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.xdR = cCy();
        paramInt = 1;
      }
      else
      {
        ad.i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.xdR.stop();
        paramInt = 0;
      }
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(77996);
    if (this.xdR != null)
    {
      paramBoolean = this.xdR.c(paramDouble, paramBoolean);
      AppMethodBeat.o(77996);
      return paramBoolean;
    }
    AppMethodBeat.o(77996);
    return false;
  }
  
  public final void cCC()
  {
    AppMethodBeat.i(77993);
    if (this.xdR != null) {
      this.xdR.cCC();
    }
    AppMethodBeat.o(77993);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78019);
    ad.i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.nns != null) {
      this.nns.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(78019);
  }
  
  public final void db(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78017);
    ad.i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.nns != null) {
      this.nns.db(paramString1, paramString2);
    }
    AppMethodBeat.o(78017);
  }
  
  public final void dc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78018);
    ad.i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.nns != null) {
      this.nns.dc(paramString1, paramString2);
    }
    AppMethodBeat.o(78018);
  }
  
  public final void dd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78020);
    ad.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.nnt.ea(false);
    if (this.nns != null) {
      this.nns.dd(paramString1, paramString2);
    }
    AppMethodBeat.o(78020);
  }
  
  public final void de(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78021);
    ad.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.nnt.a(this);
    if (this.nns != null) {
      this.nns.de(paramString1, paramString2);
    }
    AppMethodBeat.o(78021);
  }
  
  public final void dg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78022);
    if (this.nns != null) {
      this.nns.dg(paramString1, paramString2);
    }
    AppMethodBeat.o(78022);
  }
  
  public final void dh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78023);
    if (this.nns != null) {
      this.nns.dh(paramString1, paramString2);
    }
    AppMethodBeat.o(78023);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(78002);
    if (this.xdR != null)
    {
      int i = this.xdR.getCacheTimeSec();
      AppMethodBeat.o(78002);
      return i;
    }
    AppMethodBeat.o(78002);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(78000);
    if (this.xdR != null)
    {
      int i = this.xdR.getCurrPosMs();
      AppMethodBeat.o(78000);
      return i;
    }
    AppMethodBeat.o(78000);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(78001);
    if (this.xdR != null)
    {
      int i = this.xdR.getCurrPosSec();
      AppMethodBeat.o(78001);
      return i;
    }
    AppMethodBeat.o(78001);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(77994);
    if (this.xdR != null)
    {
      int i = this.xdR.getPlayerType();
      AppMethodBeat.o(77994);
      return i;
    }
    AppMethodBeat.o(77994);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(77999);
    if (this.xdR != null)
    {
      i = this.xdR.getVideoDurationSec();
      AppMethodBeat.o(77999);
      return i;
    }
    int i = this.knG;
    AppMethodBeat.o(77999);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(78003);
    if (this.xdR != null)
    {
      boolean bool = this.xdR.isPlaying();
      AppMethodBeat.o(78003);
      return bool;
    }
    AppMethodBeat.o(78003);
    return false;
  }
  
  public final void jw(String paramString1, String paramString2) {}
  
  public final void ln(long paramLong)
  {
    AppMethodBeat.i(78025);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(78025);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(78012);
    if (this.xdR != null) {
      this.xdR.onUIDestroy();
    }
    this.nnt.ea(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(78012);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(78011);
    if (this.xdR != null) {
      this.xdR.onUIPause();
    }
    this.nnt.ea(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(78011);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(78010);
    if (this.xdR != null) {
      this.xdR.onUIResume();
    }
    AppMethodBeat.o(78010);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(77995);
    if (this.xdR != null)
    {
      boolean bool = this.xdR.p(paramDouble);
      AppMethodBeat.o(77995);
      return bool;
    }
    AppMethodBeat.o(77995);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(78008);
    if (this.xdR != null)
    {
      setKeepScreenOn(false);
      this.nnt.ea(false);
      boolean bool = this.xdR.pause();
      AppMethodBeat.o(78008);
      return bool;
    }
    AppMethodBeat.o(78008);
    return false;
  }
  
  public final void pj(String paramString)
  {
    AppMethodBeat.i(78026);
    com.tencent.mm.plugin.report.service.h.vKh.kvStat(14349, paramString);
    AppMethodBeat.o(78026);
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(78005);
    if (this.xdR != null) {
      this.xdR.setCover(paramBitmap);
    }
    AppMethodBeat.o(78005);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(77998);
    if (this.xdR != null) {
      this.xdR.setFullDirection(paramInt);
    }
    AppMethodBeat.o(77998);
  }
  
  public void setIMMVideoViewCallback(h.b paramb)
  {
    this.nns = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(77997);
    if (this.xdR != null) {
      this.xdR.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(77997);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(78024);
    ad.d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bt.eGN() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(78024);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setLoopCompletionCallback(h.d paramd) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(78009);
    this.gCJ = paramBoolean;
    if (this.xdR != null) {
      this.xdR.setMute(this.gCJ);
    }
    AppMethodBeat.o(78009);
  }
  
  public void setScaleType(h.e parame)
  {
    AppMethodBeat.i(78013);
    this.vhJ = parame;
    if (this.xdR != null) {
      this.xdR.setScaleType(this.vhJ);
    }
    AppMethodBeat.o(78013);
  }
  
  public void setVideoFooterView(g paramg)
  {
    AppMethodBeat.i(77992);
    this.nno = paramg;
    if (this.xdR != null) {
      this.xdR.setVideoFooterView(this.nno);
    }
    AppMethodBeat.o(77992);
  }
  
  public final void start()
  {
    AppMethodBeat.i(78006);
    if (this.xdR != null)
    {
      this.xdR.start();
      setKeepScreenOn(true);
      this.nnt.a(this);
    }
    AppMethodBeat.o(78006);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(78007);
    if (this.xdR != null)
    {
      this.xdR.stop();
      this.nnt.ea(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(78007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsVideoWrapper
 * JD-Core Version:    0.7.0.1
 */