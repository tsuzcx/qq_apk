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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class FtsVideoWrapper
  extends RelativeLayout
  implements d.a, com.tencent.mm.pluginsdk.ui.h, h.a, h.b, h.c
{
  private boolean bps;
  private boolean dqZ;
  private boolean hdh;
  private float kOZ;
  private int kPa;
  private Context mContext;
  private g nQo;
  private h.b nQs;
  private d nQt;
  private String url;
  private h.e wqv;
  private com.tencent.mm.pluginsdk.ui.h yqG;
  
  public FtsVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FtsVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(77989);
    this.wqv = h.e.DnJ;
    this.hdh = false;
    this.kOZ = -1.0F;
    this.mContext = paramContext;
    this.nQt = new d();
    AppMethodBeat.o(77989);
  }
  
  private com.tencent.mm.pluginsdk.ui.h cPJ()
  {
    AppMethodBeat.i(77991);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.setReporter(this);
    localCommonVideoView.setIMMVideoViewCallback(this);
    AppMethodBeat.o(77991);
    return localCommonVideoView;
  }
  
  public final boolean aB(float paramFloat)
  {
    AppMethodBeat.i(78014);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(78014);
      return false;
    }
    this.kOZ = paramFloat;
    if (this.yqG != null)
    {
      boolean bool = this.yqG.aB(this.kOZ);
      AppMethodBeat.o(78014);
      return bool;
    }
    AppMethodBeat.o(78014);
    return false;
  }
  
  public final void aI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(78015);
    ac.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      AppMethodBeat.o(78015);
      return;
    }
    if ((this.yqG instanceof MMVideoView))
    {
      this.yqG.stop();
      this.yqG.cDR();
      removeView((View)this.yqG);
      ac.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.yqG = cPJ();
    }
    for (int i = 1;; i = 0)
    {
      setScaleType(this.wqv);
      aB(this.kOZ);
      setMute(this.hdh);
      if (i != 0)
      {
        setVideoFooterView(this.nQo);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.yqG, paramString);
        this.yqG.c(this.bps, this.url, this.kPa);
        this.yqG.start();
      }
      AppMethodBeat.o(78015);
      return;
    }
  }
  
  public final void axj() {}
  
  public final void axk() {}
  
  public final void axl() {}
  
  public final void axm() {}
  
  public final boolean bed()
  {
    AppMethodBeat.i(78004);
    if (this.yqG != null)
    {
      boolean bool = this.yqG.bed();
      AppMethodBeat.o(78004);
      return bool;
    }
    AppMethodBeat.o(78004);
    return false;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78016);
    ac.w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.nQs != null) {
      this.nQs.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(78016);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(77990);
    this.kPa = paramInt;
    this.bps = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    bs.isNullOrNil(localPString.value);
    this.dqZ = false;
    this.url = localPString.value;
    if (this.yqG == null)
    {
      ac.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.yqG = cPJ();
      paramInt = 1;
    }
    for (;;)
    {
      setScaleType(this.wqv);
      aB(this.kOZ);
      setMute(this.hdh);
      if (paramInt != 0)
      {
        setVideoFooterView(this.nQo);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.yqG, paramString);
      }
      this.yqG.c(this.bps, this.url, this.kPa);
      AppMethodBeat.o(77990);
      return;
      if ((this.yqG instanceof MMVideoView))
      {
        this.yqG.stop();
        this.yqG.cDR();
        removeView((View)this.yqG);
        ac.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.yqG = cPJ();
        paramInt = 1;
      }
      else
      {
        ac.i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.yqG.stop();
        paramInt = 0;
      }
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(77996);
    if (this.yqG != null)
    {
      paramBoolean = this.yqG.c(paramDouble, paramBoolean);
      AppMethodBeat.o(77996);
      return paramBoolean;
    }
    AppMethodBeat.o(77996);
    return false;
  }
  
  public final void cDR()
  {
    AppMethodBeat.i(77993);
    if (this.yqG != null) {
      this.yqG.cDR();
    }
    AppMethodBeat.o(77993);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78019);
    ac.i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.nQs != null) {
      this.nQs.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(78019);
  }
  
  public final void jdMethod_do(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78017);
    ac.i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.nQs != null) {
      this.nQs.jdMethod_do(paramString1, paramString2);
    }
    AppMethodBeat.o(78017);
  }
  
  public final void dp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78018);
    ac.i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.nQs != null) {
      this.nQs.dp(paramString1, paramString2);
    }
    AppMethodBeat.o(78018);
  }
  
  public final void dq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78020);
    ac.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.nQt.ev(false);
    if (this.nQs != null) {
      this.nQs.dq(paramString1, paramString2);
    }
    AppMethodBeat.o(78020);
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78021);
    ac.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.nQt.a(this);
    if (this.nQs != null) {
      this.nQs.dr(paramString1, paramString2);
    }
    AppMethodBeat.o(78021);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78022);
    if (this.nQs != null) {
      this.nQs.ds(paramString1, paramString2);
    }
    AppMethodBeat.o(78022);
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78023);
    if (this.nQs != null) {
      this.nQs.dt(paramString1, paramString2);
    }
    AppMethodBeat.o(78023);
  }
  
  public final void eJ(String paramString1, String paramString2) {}
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(78002);
    if (this.yqG != null)
    {
      int i = this.yqG.getCacheTimeSec();
      AppMethodBeat.o(78002);
      return i;
    }
    AppMethodBeat.o(78002);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(78000);
    if (this.yqG != null)
    {
      int i = this.yqG.getCurrPosMs();
      AppMethodBeat.o(78000);
      return i;
    }
    AppMethodBeat.o(78000);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(78001);
    if (this.yqG != null)
    {
      int i = this.yqG.getCurrPosSec();
      AppMethodBeat.o(78001);
      return i;
    }
    AppMethodBeat.o(78001);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(77994);
    if (this.yqG != null)
    {
      int i = this.yqG.getPlayerType();
      AppMethodBeat.o(77994);
      return i;
    }
    AppMethodBeat.o(77994);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(77999);
    if (this.yqG != null)
    {
      i = this.yqG.getVideoDurationSec();
      AppMethodBeat.o(77999);
      return i;
    }
    int i = this.kPa;
    AppMethodBeat.o(77999);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(78003);
    if (this.yqG != null)
    {
      boolean bool = this.yqG.isPlaying();
      AppMethodBeat.o(78003);
      return bool;
    }
    AppMethodBeat.o(78003);
    return false;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(77995);
    if (this.yqG != null)
    {
      boolean bool = this.yqG.o(paramDouble);
      AppMethodBeat.o(77995);
      return bool;
    }
    AppMethodBeat.o(77995);
    return false;
  }
  
  public final void oQ(long paramLong)
  {
    AppMethodBeat.i(78025);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(78025);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(78012);
    if (this.yqG != null) {
      this.yqG.onUIDestroy();
    }
    this.nQt.ev(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(78012);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(78011);
    if (this.yqG != null) {
      this.yqG.onUIPause();
    }
    this.nQt.ev(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(78011);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(78010);
    if (this.yqG != null) {
      this.yqG.onUIResume();
    }
    AppMethodBeat.o(78010);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(78008);
    if (this.yqG != null)
    {
      setKeepScreenOn(false);
      this.nQt.ev(false);
      boolean bool = this.yqG.pause();
      AppMethodBeat.o(78008);
      return bool;
    }
    AppMethodBeat.o(78008);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(78005);
    if (this.yqG != null) {
      this.yqG.setCover(paramBitmap);
    }
    AppMethodBeat.o(78005);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(77998);
    if (this.yqG != null) {
      this.yqG.setFullDirection(paramInt);
    }
    AppMethodBeat.o(77998);
  }
  
  public void setIMMVideoViewCallback(h.b paramb)
  {
    this.nQs = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(77997);
    if (this.yqG != null) {
      this.yqG.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(77997);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(78024);
    ac.d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bs.eWi() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(78024);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setLoopCompletionCallback(h.d paramd) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(78009);
    this.hdh = paramBoolean;
    if (this.yqG != null) {
      this.yqG.setMute(this.hdh);
    }
    AppMethodBeat.o(78009);
  }
  
  public void setScaleType(h.e parame)
  {
    AppMethodBeat.i(78013);
    this.wqv = parame;
    if (this.yqG != null) {
      this.yqG.setScaleType(this.wqv);
    }
    AppMethodBeat.o(78013);
  }
  
  public void setVideoFooterView(g paramg)
  {
    AppMethodBeat.i(77992);
    this.nQo = paramg;
    if (this.yqG != null) {
      this.yqG.setVideoFooterView(this.nQo);
    }
    AppMethodBeat.o(77992);
  }
  
  public final void start()
  {
    AppMethodBeat.i(78006);
    if (this.yqG != null)
    {
      this.yqG.start();
      setKeepScreenOn(true);
      this.nQt.a(this);
    }
    AppMethodBeat.o(78006);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(78007);
    if (this.yqG != null)
    {
      this.yqG.stop();
      this.nQt.ev(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(78007);
  }
  
  public final void sv(String paramString)
  {
    AppMethodBeat.i(78026);
    com.tencent.mm.plugin.report.service.h.wUl.kvStat(14349, paramString);
    AppMethodBeat.o(78026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsVideoWrapper
 * JD-Core Version:    0.7.0.1
 */