package com.tencent.mm.plugin.webview.fts.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
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
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.api.ITPPlayer;

public class FtsVideoWrapper
  extends RelativeLayout
  implements d.a, i, i.a, i.b, i.c
{
  private i.e NHS;
  private i QTf;
  private boolean ddk;
  private boolean hJv;
  private Context mContext;
  private boolean nLP;
  private float sAn;
  private int sAo;
  private String url;
  private com.tencent.mm.pluginsdk.ui.h vZr;
  private i.b vZv;
  private d vZw;
  
  public FtsVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FtsVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(77989);
    this.NHS = i.e.XYM;
    this.nLP = false;
    this.sAn = -1.0F;
    this.mContext = paramContext;
    this.vZw = new d();
    AppMethodBeat.o(77989);
  }
  
  private boolean Iu(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.hJv)) {}
    return true;
  }
  
  private i fFI()
  {
    AppMethodBeat.i(77991);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.setReporter(this);
    localCommonVideoView.setIMMVideoViewCallback(this);
    AppMethodBeat.o(77991);
    return localCommonVideoView;
  }
  
  private i fFJ()
  {
    AppMethodBeat.i(295619);
    MMVideoView localMMVideoView = new MMVideoView(this.mContext);
    localMMVideoView.setReporter(this);
    localMMVideoView.setIMMVideoViewCallback(this);
    localMMVideoView.setIMMDownloadFinish(this);
    String str = b.bmz() + "appbrandvideo/";
    FilePathGenerator.checkMkdir(str);
    localMMVideoView.setRootPath(str);
    AppMethodBeat.o(295619);
    return localMMVideoView;
  }
  
  public final void Du(String paramString)
  {
    AppMethodBeat.i(78026);
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(14349, paramString);
    AppMethodBeat.o(78026);
  }
  
  public final boolean G(double paramDouble)
  {
    AppMethodBeat.i(77995);
    if (this.QTf != null)
    {
      boolean bool = this.QTf.G(paramDouble);
      AppMethodBeat.o(77995);
      return bool;
    }
    AppMethodBeat.o(77995);
    return false;
  }
  
  public final void b(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(77990);
    this.sAo = paramInt;
    this.ddk = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    Util.isNullOrNil(localPString.value);
    this.hJv = false;
    this.url = localPString.value;
    if (this.QTf == null) {
      if (Iu(this.ddk))
      {
        Log.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.QTf = fFI();
        paramInt = 1;
      }
    }
    for (;;)
    {
      setScaleType(this.NHS);
      bM(this.sAn);
      setMute(this.nLP);
      if (paramInt != 0)
      {
        setVideoFooterView(this.vZr);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.QTf, paramString);
      }
      this.QTf.b(this.ddk, this.url, this.sAo);
      AppMethodBeat.o(77990);
      return;
      Log.i("MicroMsg.AppBrandVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.QTf = fFJ();
      break;
      if (Iu(this.ddk))
      {
        if ((this.QTf instanceof MMVideoView))
        {
          this.QTf.stop();
          this.QTf.eLM();
          removeView((View)this.QTf);
          Log.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
          this.QTf = fFI();
          paramInt = 1;
        }
        else
        {
          Log.i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", new Object[] { Integer.valueOf(hashCode()) });
          this.QTf.stop();
          paramInt = 0;
        }
      }
      else if ((this.QTf instanceof CommonVideoView))
      {
        this.QTf.stop();
        this.QTf.eLM();
        removeView((View)this.QTf);
        Log.i("MicroMsg.AppBrandVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.QTf = fFJ();
        paramInt = 1;
      }
      else
      {
        Log.i("MicroMsg.AppBrandVideoWrapper", "%d use last mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.QTf.stop();
        paramInt = 0;
      }
    }
  }
  
  public final boolean b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(77996);
    if (this.QTf != null)
    {
      paramBoolean = this.QTf.b(paramDouble, paramBoolean);
      AppMethodBeat.o(77996);
      return paramBoolean;
    }
    AppMethodBeat.o(77996);
    return false;
  }
  
  public final void bAi() {}
  
  public final void bAj() {}
  
  public final void bAk() {}
  
  public final void bAl() {}
  
  public final boolean bM(float paramFloat)
  {
    AppMethodBeat.i(78014);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(78014);
      return false;
    }
    this.sAn = paramFloat;
    if (this.QTf != null)
    {
      boolean bool = this.QTf.bM(this.sAn);
      AppMethodBeat.o(78014);
      return bool;
    }
    AppMethodBeat.o(78014);
    return false;
  }
  
  public final void bd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(78015);
    Log.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      AppMethodBeat.o(78015);
      return;
    }
    int i;
    if (Iu(false))
    {
      if (!(this.QTf instanceof MMVideoView)) {
        break label306;
      }
      this.QTf.stop();
      this.QTf.eLM();
      removeView((View)this.QTf);
      Log.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.QTf = fFI();
      i = 1;
    }
    for (;;)
    {
      setScaleType(this.NHS);
      bM(this.sAn);
      setMute(this.nLP);
      if (i != 0)
      {
        setVideoFooterView(this.vZr);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.QTf, paramString);
        this.QTf.b(this.ddk, this.url, this.sAo);
        this.QTf.start();
      }
      AppMethodBeat.o(78015);
      return;
      if ((this.QTf instanceof CommonVideoView))
      {
        this.QTf.stop();
        this.QTf.eLM();
        removeView((View)this.QTf);
        Log.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.QTf = fFJ();
        i = 1;
      }
      else
      {
        label306:
        i = 0;
      }
    }
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78016);
    Log.w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.vZv != null) {
      this.vZv.d(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(78016);
  }
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78019);
    Log.i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.vZv != null) {
      this.vZv.e(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(78019);
  }
  
  public final void eLM()
  {
    AppMethodBeat.i(77993);
    if (this.QTf != null) {
      this.QTf.eLM();
    }
    AppMethodBeat.o(77993);
  }
  
  public final void el(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78017);
    Log.i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.vZv != null) {
      this.vZv.el(paramString1, paramString2);
    }
    AppMethodBeat.o(78017);
  }
  
  public final void em(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78018);
    Log.i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.vZv != null) {
      this.vZv.em(paramString1, paramString2);
    }
    AppMethodBeat.o(78018);
  }
  
  public final void en(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78020);
    Log.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.vZw.gR(false);
    if (this.vZv != null) {
      this.vZv.en(paramString1, paramString2);
    }
    AppMethodBeat.o(78020);
  }
  
  public final void eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78021);
    Log.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.vZw.a(this);
    if (this.vZv != null) {
      this.vZv.eo(paramString1, paramString2);
    }
    AppMethodBeat.o(78021);
  }
  
  public final void ep(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78022);
    if (this.vZv != null) {
      this.vZv.ep(paramString1, paramString2);
    }
    AppMethodBeat.o(78022);
  }
  
  public final void eq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78023);
    if (this.vZv != null) {
      this.vZv.eq(paramString1, paramString2);
    }
    AppMethodBeat.o(78023);
  }
  
  public final void gE(String paramString1, String paramString2) {}
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(78002);
    if (this.QTf != null)
    {
      int i = this.QTf.getCacheTimeSec();
      AppMethodBeat.o(78002);
      return i;
    }
    AppMethodBeat.o(78002);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(78000);
    if (this.QTf != null)
    {
      int i = this.QTf.getCurrPosMs();
      AppMethodBeat.o(78000);
      return i;
    }
    AppMethodBeat.o(78000);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(78001);
    if (this.QTf != null)
    {
      int i = this.QTf.getCurrPosSec();
      AppMethodBeat.o(78001);
      return i;
    }
    AppMethodBeat.o(78001);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(77994);
    if (this.QTf != null)
    {
      int i = this.QTf.getPlayerType();
      AppMethodBeat.o(77994);
      return i;
    }
    AppMethodBeat.o(77994);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(77999);
    if (this.QTf != null)
    {
      i = this.QTf.getVideoDurationSec();
      AppMethodBeat.o(77999);
      return i;
    }
    int i = this.sAo;
    AppMethodBeat.o(77999);
    return i;
  }
  
  public final void hp(long paramLong)
  {
    AppMethodBeat.i(78025);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(78025);
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(78004);
    if (this.QTf != null)
    {
      boolean bool = this.QTf.isLive();
      AppMethodBeat.o(78004);
      return bool;
    }
    AppMethodBeat.o(78004);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(78003);
    if (this.QTf != null)
    {
      boolean bool = this.QTf.isPlaying();
      AppMethodBeat.o(78003);
      return bool;
    }
    AppMethodBeat.o(78003);
    return false;
  }
  
  public final void onSeekComplete(ITPPlayer paramITPPlayer) {}
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(78012);
    if (this.QTf != null) {
      this.QTf.onUIDestroy();
    }
    this.vZw.gR(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(78012);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(78011);
    if (this.QTf != null) {
      this.QTf.onUIPause();
    }
    this.vZw.gR(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(78011);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(78010);
    if (this.QTf != null) {
      this.QTf.onUIResume();
    }
    AppMethodBeat.o(78010);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(78008);
    if (this.QTf != null)
    {
      setKeepScreenOn(false);
      this.vZw.gR(false);
      boolean bool = this.QTf.pause();
      AppMethodBeat.o(78008);
      return bool;
    }
    AppMethodBeat.o(78008);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(78005);
    if (this.QTf != null) {
      this.QTf.setCover(paramBitmap);
    }
    AppMethodBeat.o(78005);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(77998);
    if (this.QTf != null) {
      this.QTf.setFullDirection(paramInt);
    }
    AppMethodBeat.o(77998);
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    this.vZv = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(77997);
    if (this.QTf != null) {
      this.QTf.setIsShowBasicControls(paramBoolean);
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
    this.nLP = paramBoolean;
    if (this.QTf != null) {
      this.QTf.setMute(this.nLP);
    }
    AppMethodBeat.o(78009);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(78013);
    this.NHS = parame;
    if (this.QTf != null) {
      this.QTf.setScaleType(this.NHS);
    }
    AppMethodBeat.o(78013);
  }
  
  public void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(77992);
    this.vZr = paramh;
    if (this.QTf != null) {
      this.QTf.setVideoFooterView(this.vZr);
    }
    AppMethodBeat.o(77992);
  }
  
  public final void start()
  {
    AppMethodBeat.i(78006);
    if (this.QTf != null)
    {
      this.QTf.start();
      setKeepScreenOn(true);
      this.vZw.a(this);
    }
    AppMethodBeat.o(78006);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(78007);
    if (this.QTf != null)
    {
      this.QTf.stop();
      this.vZw.gR(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(78007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsVideoWrapper
 * JD-Core Version:    0.7.0.1
 */