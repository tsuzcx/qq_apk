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
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class FtsVideoWrapper
  extends RelativeLayout
  implements d.a, i, i.a, i.b, i.c
{
  private i.e BOo;
  private i Eho;
  private boolean bzP;
  private boolean dLQ;
  private boolean isb;
  private Context mContext;
  private float mwH;
  private int mwI;
  private com.tencent.mm.pluginsdk.ui.h pNf;
  private i.b pNj;
  private d pNk;
  private String url;
  
  public FtsVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FtsVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(77989);
    this.BOo = i.e.Kcb;
    this.isb = false;
    this.mwH = -1.0F;
    this.mContext = paramContext;
    this.pNk = new d();
    AppMethodBeat.o(77989);
  }
  
  private i dUF()
  {
    AppMethodBeat.i(77991);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.setReporter(this);
    localCommonVideoView.setIMMVideoViewCallback(this);
    AppMethodBeat.o(77991);
    return localCommonVideoView;
  }
  
  public final void DX(String paramString)
  {
    AppMethodBeat.i(78026);
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(14349, paramString);
    AppMethodBeat.o(78026);
  }
  
  public final void aO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(78015);
    Log.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      AppMethodBeat.o(78015);
      return;
    }
    if ((this.Eho instanceof MMVideoView))
    {
      this.Eho.stop();
      this.Eho.dFl();
      removeView((View)this.Eho);
      Log.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.Eho = dUF();
    }
    for (int i = 1;; i = 0)
    {
      setScaleType(this.BOo);
      aO(this.mwH);
      setMute(this.isb);
      if (i != 0)
      {
        setVideoFooterView(this.pNf);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.Eho, paramString);
        this.Eho.c(this.bzP, this.url, this.mwI);
        this.Eho.start();
      }
      AppMethodBeat.o(78015);
      return;
    }
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(78014);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(78014);
      return false;
    }
    this.mwH = paramFloat;
    if (this.Eho != null)
    {
      boolean bool = this.Eho.aO(this.mwH);
      AppMethodBeat.o(78014);
      return bool;
    }
    AppMethodBeat.o(78014);
    return false;
  }
  
  public final void aTw() {}
  
  public final void aTx() {}
  
  public final void aTy() {}
  
  public final void aTz() {}
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78016);
    Log.w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.pNj != null) {
      this.pNj.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(78016);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(77990);
    this.mwI = paramInt;
    this.bzP = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    Util.isNullOrNil(localPString.value);
    this.dLQ = false;
    this.url = localPString.value;
    if (this.Eho == null)
    {
      Log.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.Eho = dUF();
      paramInt = 1;
    }
    for (;;)
    {
      setScaleType(this.BOo);
      aO(this.mwH);
      setMute(this.isb);
      if (paramInt != 0)
      {
        setVideoFooterView(this.pNf);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.Eho, paramString);
      }
      this.Eho.c(this.bzP, this.url, this.mwI);
      AppMethodBeat.o(77990);
      return;
      if ((this.Eho instanceof MMVideoView))
      {
        this.Eho.stop();
        this.Eho.dFl();
        removeView((View)this.Eho);
        Log.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.Eho = dUF();
        paramInt = 1;
      }
      else
      {
        Log.i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.Eho.stop();
        paramInt = 0;
      }
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(77996);
    if (this.Eho != null)
    {
      paramBoolean = this.Eho.c(paramDouble, paramBoolean);
      AppMethodBeat.o(77996);
      return paramBoolean;
    }
    AppMethodBeat.o(77996);
    return false;
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78019);
    Log.i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.pNj != null) {
      this.pNj.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(78019);
  }
  
  public final void dFl()
  {
    AppMethodBeat.i(77993);
    if (this.Eho != null) {
      this.Eho.dFl();
    }
    AppMethodBeat.o(77993);
  }
  
  public final void dH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78017);
    Log.i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.pNj != null) {
      this.pNj.dH(paramString1, paramString2);
    }
    AppMethodBeat.o(78017);
  }
  
  public final void dI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78018);
    Log.i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.pNj != null) {
      this.pNj.dI(paramString1, paramString2);
    }
    AppMethodBeat.o(78018);
  }
  
  public final void dJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78020);
    Log.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.pNk.fp(false);
    if (this.pNj != null) {
      this.pNj.dJ(paramString1, paramString2);
    }
    AppMethodBeat.o(78020);
  }
  
  public final void dK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78021);
    Log.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.pNk.a(this);
    if (this.pNj != null) {
      this.pNj.dK(paramString1, paramString2);
    }
    AppMethodBeat.o(78021);
  }
  
  public final void dL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78022);
    if (this.pNj != null) {
      this.pNj.dL(paramString1, paramString2);
    }
    AppMethodBeat.o(78022);
  }
  
  public final void dM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78023);
    if (this.pNj != null) {
      this.pNj.dM(paramString1, paramString2);
    }
    AppMethodBeat.o(78023);
  }
  
  public final void fo(String paramString1, String paramString2) {}
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(78002);
    if (this.Eho != null)
    {
      int i = this.Eho.getCacheTimeSec();
      AppMethodBeat.o(78002);
      return i;
    }
    AppMethodBeat.o(78002);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(78000);
    if (this.Eho != null)
    {
      int i = this.Eho.getCurrPosMs();
      AppMethodBeat.o(78000);
      return i;
    }
    AppMethodBeat.o(78000);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(78001);
    if (this.Eho != null)
    {
      int i = this.Eho.getCurrPosSec();
      AppMethodBeat.o(78001);
      return i;
    }
    AppMethodBeat.o(78001);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(77994);
    if (this.Eho != null)
    {
      int i = this.Eho.getPlayerType();
      AppMethodBeat.o(77994);
      return i;
    }
    AppMethodBeat.o(77994);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(77999);
    if (this.Eho != null)
    {
      i = this.Eho.getVideoDurationSec();
      AppMethodBeat.o(77999);
      return i;
    }
    int i = this.mwI;
    AppMethodBeat.o(77999);
    return i;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(78004);
    if (this.Eho != null)
    {
      boolean bool = this.Eho.isLive();
      AppMethodBeat.o(78004);
      return bool;
    }
    AppMethodBeat.o(78004);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(78003);
    if (this.Eho != null)
    {
      boolean bool = this.Eho.isPlaying();
      AppMethodBeat.o(78003);
      return bool;
    }
    AppMethodBeat.o(78003);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(78012);
    if (this.Eho != null) {
      this.Eho.onUIDestroy();
    }
    this.pNk.fp(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(78012);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(78011);
    if (this.Eho != null) {
      this.Eho.onUIPause();
    }
    this.pNk.fp(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(78011);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(78010);
    if (this.Eho != null) {
      this.Eho.onUIResume();
    }
    AppMethodBeat.o(78010);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(77995);
    if (this.Eho != null)
    {
      boolean bool = this.Eho.p(paramDouble);
      AppMethodBeat.o(77995);
      return bool;
    }
    AppMethodBeat.o(77995);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(78008);
    if (this.Eho != null)
    {
      setKeepScreenOn(false);
      this.pNk.fp(false);
      boolean bool = this.Eho.pause();
      AppMethodBeat.o(78008);
      return bool;
    }
    AppMethodBeat.o(78008);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(78005);
    if (this.Eho != null) {
      this.Eho.setCover(paramBitmap);
    }
    AppMethodBeat.o(78005);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(77998);
    if (this.Eho != null) {
      this.Eho.setFullDirection(paramInt);
    }
    AppMethodBeat.o(77998);
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    this.pNj = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(77997);
    if (this.Eho != null) {
      this.Eho.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(77997);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(78024);
    Log.d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Util.getStack() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(78024);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setLoopCompletionCallback(i.d paramd) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(78009);
    this.isb = paramBoolean;
    if (this.Eho != null) {
      this.Eho.setMute(this.isb);
    }
    AppMethodBeat.o(78009);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(78013);
    this.BOo = parame;
    if (this.Eho != null) {
      this.Eho.setScaleType(this.BOo);
    }
    AppMethodBeat.o(78013);
  }
  
  public void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(77992);
    this.pNf = paramh;
    if (this.Eho != null) {
      this.Eho.setVideoFooterView(this.pNf);
    }
    AppMethodBeat.o(77992);
  }
  
  public final void start()
  {
    AppMethodBeat.i(78006);
    if (this.Eho != null)
    {
      this.Eho.start();
      setKeepScreenOn(true);
      this.pNk.a(this);
    }
    AppMethodBeat.o(78006);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(78007);
    if (this.Eho != null)
    {
      this.Eho.stop();
      this.pNk.fp(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(78007);
  }
  
  public final void yU(long paramLong)
  {
    AppMethodBeat.i(78025);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(78025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsVideoWrapper
 * JD-Core Version:    0.7.0.1
 */