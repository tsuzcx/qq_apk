package com.tencent.thumbplayer.a.a.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.c.b;
import com.tencent.thumbplayer.a.a.c.c;
import com.tencent.thumbplayer.a.a.c.d;
import com.tencent.thumbplayer.a.a.c.e;
import com.tencent.thumbplayer.a.a.c.f;
import com.tencent.thumbplayer.a.a.c.h;
import com.tencent.thumbplayer.a.a.c.i;
import com.tencent.thumbplayer.a.a.c.j;
import com.tencent.thumbplayer.b.f;
import com.tencent.thumbplayer.b.f.a;
import com.tencent.thumbplayer.b.f.b;
import com.tencent.thumbplayer.b.f.c;
import com.tencent.thumbplayer.b.f.d;
import com.tencent.thumbplayer.b.f.e;
import com.tencent.thumbplayer.b.i.a;
import com.tencent.thumbplayer.b.k;
import com.tencent.thumbplayer.b.m;
import com.tencent.thumbplayer.b.n;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.core.player.ITPNativePlayerAudioFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerVideoFrameCallback;
import com.tencent.thumbplayer.core.player.TPNativePlayer;
import com.tencent.thumbplayer.core.player.TPNativePlayerInitConfig;
import com.tencent.thumbplayer.core.player.TPNativePlayerProgramInfo;
import com.tencent.thumbplayer.d.g;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.thumbplayer.a.a.b
{
  private static String TAG = "TPThumbPlayer[TPThumbPlayer.java]";
  private TPNativePlayer LYl;
  private TPNativePlayerInitConfig LYm;
  private a LYn;
  private com.tencent.thumbplayer.a.e LYo;
  private com.tencent.thumbplayer.a.a.a LYp;
  private m LYq;
  private ITPNativePlayerMessageCallback LYr;
  private ITPNativePlayerAudioFrameCallback LYs;
  private ITPNativePlayerVideoFrameCallback LYt;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(191783);
    this.LYq = new m();
    this.LYr = new ITPNativePlayerMessageCallback()
    {
      public final void onASyncCallResult(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(191775);
        com.tencent.thumbplayer.utils.d.i(b.TAG, "onASyncCallResult, callType:" + paramAnonymousInt1 + ", opaque:" + paramAnonymousLong + ", errorType:" + paramAnonymousInt2 + ", errorCode:" + paramAnonymousInt3);
        b.b localb = new b.b();
        localb.LYv = paramAnonymousInt1;
        localb.LWx = paramAnonymousLong;
        localb.dnL = paramAnonymousInt2;
        localb.errorCode = paramAnonymousInt3;
        Message.obtain(b.a(b.this), 1, localb).sendToTarget();
        AppMethodBeat.o(191775);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(191778);
        com.tencent.thumbplayer.utils.d.i(b.TAG, "onError, msgType:" + paramAnonymousInt1 + ", errorCode:" + paramAnonymousInt2);
        b.c localc = new b.c();
        localc.msgType = paramAnonymousInt1;
        localc.errorCode = paramAnonymousInt2;
        Message.obtain(b.a(b.this), 4, localc).sendToTarget();
        AppMethodBeat.o(191778);
      }
      
      public final void onInfoLong(int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(191776);
        com.tencent.thumbplayer.utils.d.i(b.TAG, "onInfoLong, infoType:" + paramAnonymousInt + ", lParam1:" + paramAnonymousLong1 + ", lParam2:" + paramAnonymousLong2);
        b.d locald = new b.d();
        locald.infoType = paramAnonymousInt;
        locald.lParam1 = paramAnonymousLong1;
        locald.LYw = paramAnonymousLong2;
        Message.obtain(b.a(b.this), 2, locald).sendToTarget();
        AppMethodBeat.o(191776);
      }
      
      public final void onInfoObject(int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(191777);
        com.tencent.thumbplayer.utils.d.i(b.TAG, "onInfoObject, infoType:" + paramAnonymousInt + ", objParam:" + paramAnonymousObject);
        b.e locale = new b.e();
        locale.infoType = paramAnonymousInt;
        locale.LYx = paramAnonymousObject;
        Message.obtain(b.a(b.this), 3, locale).sendToTarget();
        AppMethodBeat.o(191777);
      }
    };
    this.LYs = new ITPNativePlayerAudioFrameCallback()
    {
      public final void onAudioFrame(TPAudioFrame paramAnonymousTPAudioFrame, int paramAnonymousInt)
      {
        AppMethodBeat.i(191779);
        paramAnonymousTPAudioFrame = c.a(paramAnonymousTPAudioFrame);
        b.b(b.this).a(paramAnonymousTPAudioFrame);
        AppMethodBeat.o(191779);
      }
    };
    this.LYt = new ITPNativePlayerVideoFrameCallback()
    {
      public final void onVideoFrame(TPVideoFrame paramAnonymousTPVideoFrame, int paramAnonymousInt)
      {
        AppMethodBeat.i(191780);
        paramAnonymousTPVideoFrame = c.a(paramAnonymousTPVideoFrame);
        b.b(b.this).a(paramAnonymousTPVideoFrame);
        AppMethodBeat.o(191780);
      }
    };
    this.LYl = new TPNativePlayer(paramContext);
    this.LYl.setMessageCallback(this.LYr);
    this.LYl.setAudioFrameCallback(this.LYs);
    this.LYl.setVideoFrameCallback(this.LYt);
    this.LYm = new TPNativePlayerInitConfig();
    this.LYo = new com.tencent.thumbplayer.a.e(TAG);
    paramContext = Looper.myLooper();
    if (paramContext != null)
    {
      this.LYn = new a(paramContext, this);
      AppMethodBeat.o(191783);
      return;
    }
    paramContext = Looper.getMainLooper();
    if (paramContext != null)
    {
      this.LYn = new a(paramContext, this);
      AppMethodBeat.o(191783);
      return;
    }
    this.LYn = null;
    AppMethodBeat.o(191783);
  }
  
  private void a(int paramInt, f.c paramc)
  {
    AppMethodBeat.i(191785);
    c.a locala = c.ahc(paramInt);
    if (locala == null)
    {
      com.tencent.thumbplayer.utils.d.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(191785);
      return;
    }
    if ((paramc.LYU == null) || (paramc.LYU.length == 0))
    {
      com.tencent.thumbplayer.utils.d.e(TAG, "queueint params is empty in".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(191785);
      return;
    }
    switch (locala.LYE)
    {
    default: 
      com.tencent.thumbplayer.utils.d.e(TAG, "optionID type:" + locala.LYE + " is not implement");
      AppMethodBeat.o(191785);
      return;
    }
    paramInt = 0;
    while (paramInt < paramc.LYU.length)
    {
      this.LYm.addQueueInt(locala.LYF, paramc.LYU[paramInt]);
      paramInt += 1;
    }
    AppMethodBeat.o(191785);
  }
  
  private void a(int paramInt, f.d paramd)
  {
    AppMethodBeat.i(191786);
    c.a locala = c.ahc(paramInt);
    if (locala == null)
    {
      com.tencent.thumbplayer.utils.d.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(191786);
      return;
    }
    if ((paramd.LYV == null) || (paramd.LYV.length == 0))
    {
      com.tencent.thumbplayer.utils.d.e(TAG, "queue String params is empty in".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(191786);
      return;
    }
    switch (locala.LYE)
    {
    default: 
      com.tencent.thumbplayer.utils.d.e(TAG, "optionID type:" + locala.LYE + " is not implement");
      AppMethodBeat.o(191786);
      return;
    }
    paramInt = 0;
    while (paramInt < paramd.LYV.length)
    {
      this.LYm.addQueueString(locala.LYF, paramd.LYV[paramInt]);
      paramInt += 1;
    }
    AppMethodBeat.o(191786);
  }
  
  private void fWs()
  {
    AppMethodBeat.i(191823);
    if (this.LYl == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("player has release");
      AppMethodBeat.o(191823);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(191823);
  }
  
  public final void M(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(191805);
    com.tencent.thumbplayer.utils.d.i(TAG, "switchDefinition url:" + paramString + " opaque:" + paramLong);
    fWs();
    paramInt = c.ahh(paramInt);
    if (this.LYl.switchDefinitionAsync(paramString, paramInt, paramLong) != 0)
    {
      paramString = new IllegalStateException("switchDefinition in invalid state");
      AppMethodBeat.o(191805);
      throw paramString;
    }
    this.LYp = new com.tencent.thumbplayer.c.c(paramString);
    AppMethodBeat.o(191805);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    this.LYo.LWS = parama;
  }
  
  public final void a(c.b paramb)
  {
    this.LYo.LWL = paramb;
  }
  
  public final void a(c.c paramc)
  {
    this.LYo.LWN = paramc;
  }
  
  public final void a(c.d paramd)
  {
    this.LYo.LWM = paramd;
  }
  
  public final void a(c.e parame)
  {
    this.LYo.LWK = parame;
  }
  
  public final void a(c.f paramf)
  {
    this.LYo.LWO = paramf;
  }
  
  public final void a(c.h paramh)
  {
    this.LYo.LWQ = paramh;
  }
  
  public final void a(c.i parami)
  {
    this.LYo.LWR = parami;
  }
  
  public final void a(c.j paramj)
  {
    this.LYo.LWP = paramj;
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama)
  {
    AppMethodBeat.i(191791);
    com.tencent.thumbplayer.utils.d.i(TAG, "setDataSource: ".concat(String.valueOf(parama)));
    fWs();
    if (parama == null)
    {
      parama = new IllegalStateException("media asset is null!");
      AppMethodBeat.o(191791);
      throw parama;
    }
    if ((!(parama instanceof com.tencent.thumbplayer.d.b)) && (!(parama instanceof com.tencent.thumbplayer.d.d)) && (!(parama instanceof com.tencent.thumbplayer.d.e)) && (!(parama instanceof g)))
    {
      parama = new IllegalStateException("media asset is illegal source!");
      AppMethodBeat.o(191791);
      throw parama;
    }
    parama = parama.getUrl();
    if (this.LYl.setDataSource(parama) != 0)
    {
      parama = new IllegalStateException("setDataSource mediaAsset failed!!");
      AppMethodBeat.o(191791);
      throw parama;
    }
    this.LYp = new com.tencent.thumbplayer.c.c(parama);
    AppMethodBeat.o(191791);
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(191806);
    com.tencent.thumbplayer.utils.d.i(TAG, "switchDefinition mediaAsset:" + parama + " opaque:" + paramLong);
    fWs();
    if (parama != null)
    {
      paramInt = c.ahh(paramInt);
      if (this.LYl.switchDefinitionAsync(parama.getUrl(), paramInt, paramLong) != 0)
      {
        parama = new IllegalStateException("switchDefinition in invalid state");
        AppMethodBeat.o(191806);
        throw parama;
      }
      this.LYp = new com.tencent.thumbplayer.c.c(parama.getUrl());
    }
    AppMethodBeat.o(191806);
  }
  
  public final void a(com.tencent.thumbplayer.b.e parame, com.tencent.thumbplayer.b.d paramd)
  {
    AppMethodBeat.i(191822);
    com.tencent.thumbplayer.utils.d.i(TAG, "captureVideo, params".concat(String.valueOf(parame)));
    if (this.LYp != null)
    {
      TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
      localTPImageGeneratorParams.width = parame.width;
      localTPImageGeneratorParams.height = parame.height;
      localTPImageGeneratorParams.format = parame.format;
      localTPImageGeneratorParams.requestedTimeMsToleranceAfter = parame.requestedTimeMsToleranceAfter;
      localTPImageGeneratorParams.requestedTimeMsToleranceBefore = parame.requestedTimeMsToleranceBefore;
      this.LYp.a(getCurrentPositionMs(), localTPImageGeneratorParams, paramd);
    }
    AppMethodBeat.o(191822);
  }
  
  public final void aQ(int paramInt, long paramLong)
  {
    AppMethodBeat.i(191794);
    com.tencent.thumbplayer.utils.d.i(TAG, "selectTrack");
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(191794);
      return;
    }
    this.LYl.selectTrackAsync(paramInt, paramLong);
    AppMethodBeat.o(191794);
  }
  
  public final void aR(int paramInt, long paramLong)
  {
    AppMethodBeat.i(191795);
    com.tencent.thumbplayer.utils.d.i(TAG, "selectTrack");
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(191795);
      return;
    }
    this.LYl.deselectTrackAsync(paramInt, paramLong);
    AppMethodBeat.o(191795);
  }
  
  public final void aS(int paramInt, long paramLong)
  {
    AppMethodBeat.i(191820);
    com.tencent.thumbplayer.utils.d.i(TAG, "selectProgram");
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(191820);
      return;
    }
    this.LYl.selectProgramAsync(paramInt, paramLong);
    AppMethodBeat.o(191820);
  }
  
  public final void b(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(191790);
    com.tencent.thumbplayer.utils.d.i(TAG, "setDataSource: ".concat(String.valueOf(paramParcelFileDescriptor)));
    fWs();
    if (this.LYl.setDataSource(paramParcelFileDescriptor.getFd()) != 0)
    {
      paramParcelFileDescriptor = new IllegalStateException("setDataSource url pfd failed!!");
      AppMethodBeat.o(191790);
      throw paramParcelFileDescriptor;
    }
    this.LYp = new com.tencent.thumbplayer.c.c(paramParcelFileDescriptor.getFd());
    AppMethodBeat.o(191790);
  }
  
  public final void b(f paramf)
  {
    boolean bool = true;
    AppMethodBeat.i(191784);
    com.tencent.thumbplayer.utils.d.i(TAG, "setPlayerOptionalParam:".concat(String.valueOf(paramf)));
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(191784);
      return;
    }
    int i;
    c.a locala;
    Object localObject;
    if (paramf.LYM == 1)
    {
      if (paramf.key < 500)
      {
        i = paramf.key;
        paramf = paramf.LYN;
        locala = c.ahc(i);
        if (locala == null)
        {
          com.tencent.thumbplayer.utils.d.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(191784);
          return;
        }
        switch (locala.LYE)
        {
        default: 
          com.tencent.thumbplayer.utils.d.e(TAG, "optionID type:" + locala.LYE + " is not implement");
          AppMethodBeat.o(191784);
          return;
        }
        this.LYm.setBool(locala.LYF, paramf.value);
        AppMethodBeat.o(191784);
        return;
      }
      i = paramf.key;
      paramf = paramf.LYN;
      locala = c.ahc(i);
      if (locala == null)
      {
        com.tencent.thumbplayer.utils.d.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(i)));
        AppMethodBeat.o(191784);
        return;
      }
      switch (locala.LYE)
      {
      default: 
        com.tencent.thumbplayer.utils.d.e(TAG, "optionID type:" + locala.LYE + " is not implement");
        AppMethodBeat.o(191784);
        return;
      }
      localObject = this.LYl;
      i = locala.LYF;
      if (paramf.value) {}
      for (long l = 1L;; l = 0L)
      {
        ((TPNativePlayer)localObject).setOptionLong(i, l, 0L);
        AppMethodBeat.o(191784);
        return;
      }
    }
    if (paramf.LYM == 2)
    {
      if (paramf.key < 500)
      {
        i = paramf.key;
        paramf = paramf.LYO;
        locala = c.ahc(i);
        if (locala == null)
        {
          com.tencent.thumbplayer.utils.d.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(191784);
          return;
        }
        switch (locala.LYE)
        {
        case 2: 
        default: 
          com.tencent.thumbplayer.utils.d.e(TAG, "optionID type:" + locala.LYE + " is not implement");
          AppMethodBeat.o(191784);
          return;
        case 1: 
          this.LYm.setLong(locala.LYF, paramf.value);
          AppMethodBeat.o(191784);
          return;
        case 4: 
          this.LYm.setInt(locala.LYF, (int)paramf.value);
          AppMethodBeat.o(191784);
          return;
        }
        localObject = this.LYm;
        i = locala.LYF;
        if (paramf.value > 0L) {}
        for (;;)
        {
          ((TPNativePlayerInitConfig)localObject).setBool(i, bool);
          AppMethodBeat.o(191784);
          return;
          bool = false;
        }
      }
      i = paramf.key;
      paramf = paramf.LYO;
      locala = c.ahc(i);
      if (locala == null)
      {
        com.tencent.thumbplayer.utils.d.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(i)));
        AppMethodBeat.o(191784);
        return;
      }
      switch (locala.LYE)
      {
      case 2: 
      default: 
        com.tencent.thumbplayer.utils.d.e(TAG, "optionID type:" + locala.LYE + " is not implement");
        AppMethodBeat.o(191784);
        return;
      case 1: 
        this.LYl.setOptionLong(locala.LYF, paramf.value, paramf.LYS);
        AppMethodBeat.o(191784);
        return;
      case 4: 
        this.LYl.setOptionLong(locala.LYF, paramf.value, paramf.LYS);
        AppMethodBeat.o(191784);
        return;
      }
      this.LYl.setOptionLong(locala.LYF, paramf.value, paramf.LYS);
      AppMethodBeat.o(191784);
      return;
    }
    if (paramf.LYM == 3)
    {
      if (paramf.key < 500)
      {
        com.tencent.thumbplayer.utils.d.e(TAG, "init string param type is not implement coz native init config no string setting");
        AppMethodBeat.o(191784);
        return;
      }
      i = paramf.key;
      paramf = paramf.LYP;
      locala = c.ahc(i);
      if (locala == null)
      {
        com.tencent.thumbplayer.utils.d.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(i)));
        AppMethodBeat.o(191784);
        return;
      }
      switch (locala.LYE)
      {
      default: 
        com.tencent.thumbplayer.utils.d.e(TAG, "optionID type:" + locala.LYE + " is not implement");
        AppMethodBeat.o(191784);
        return;
      }
      this.LYl.setOptionObject(locala.LYF, paramf.value);
      AppMethodBeat.o(191784);
      return;
    }
    if (paramf.LYM == 4)
    {
      if (paramf.key < 500)
      {
        a(paramf.key, paramf.LYQ);
        AppMethodBeat.o(191784);
      }
    }
    else if (paramf.LYM == 5)
    {
      if (paramf.key < 500)
      {
        a(paramf.key, paramf.LYR);
        AppMethodBeat.o(191784);
      }
    }
    else
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "optionalParam param type is unknow, return");
      AppMethodBeat.o(191784);
      return;
    }
    AppMethodBeat.o(191784);
  }
  
  public final void bk(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(191792);
    com.tencent.thumbplayer.utils.d.i(TAG, "addSubtitleSource");
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(191792);
      return;
    }
    this.LYl.addSubtitleTrackSource(paramString1, paramString3);
    AppMethodBeat.o(191792);
  }
  
  public final void c(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191811);
    com.tencent.thumbplayer.utils.d.i(TAG, "setLoopback:" + paramBoolean + " loopStartPositionMs:" + paramLong1 + " loopEndPositionMs:" + paramLong2);
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(191811);
      return;
    }
    if (this.LYl.setLoopback(paramBoolean, paramLong1, paramLong2) != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("set loopback failed!!");
      AppMethodBeat.o(191811);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(191811);
  }
  
  public final void ci(float paramFloat)
  {
    AppMethodBeat.i(191808);
    com.tencent.thumbplayer.utils.d.i(TAG, "setAudioGainRatio:".concat(String.valueOf(paramFloat)));
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(191808);
      return;
    }
    this.LYl.setAudioVolume(paramFloat);
    AppMethodBeat.o(191808);
  }
  
  public final void cj(float paramFloat)
  {
    AppMethodBeat.i(191809);
    com.tencent.thumbplayer.utils.d.i(TAG, "setPlaySpeedRatio:".concat(String.valueOf(paramFloat)));
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(191809);
      return;
    }
    this.LYl.setPlaybackRate(paramFloat);
    AppMethodBeat.o(191809);
  }
  
  public final n[] fWg()
  {
    AppMethodBeat.i(191819);
    com.tencent.thumbplayer.utils.d.i(TAG, "getTrackInfo");
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.i(TAG, "player has released, return 0");
      AppMethodBeat.o(191819);
      return null;
    }
    TPMediaTrackInfo[] arrayOfTPMediaTrackInfo = this.LYl.getTrackInfo();
    if ((arrayOfTPMediaTrackInfo == null) || (arrayOfTPMediaTrackInfo.length <= 0))
    {
      AppMethodBeat.o(191819);
      return null;
    }
    n[] arrayOfn = new n[arrayOfTPMediaTrackInfo.length];
    int i = 0;
    while (i < arrayOfTPMediaTrackInfo.length)
    {
      TPMediaTrackInfo localTPMediaTrackInfo = arrayOfTPMediaTrackInfo[i];
      n localn = new n();
      localn.name = localTPMediaTrackInfo.trackName;
      localn.trackType = localTPMediaTrackInfo.trackType;
      localn.isExclusive = localTPMediaTrackInfo.isExclusive;
      localn.isSelected = localTPMediaTrackInfo.isSelected;
      localn.isInternal = localTPMediaTrackInfo.isInternal;
      arrayOfn[i] = localn;
      i += 1;
    }
    AppMethodBeat.o(191819);
    return arrayOfn;
  }
  
  public final k[] fWh()
  {
    AppMethodBeat.i(191821);
    com.tencent.thumbplayer.utils.d.i(TAG, "getProgramInfo");
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.i(TAG, "player has released, return 0");
      AppMethodBeat.o(191821);
      return null;
    }
    TPNativePlayerProgramInfo[] arrayOfTPNativePlayerProgramInfo = this.LYl.getProgramInfo();
    if ((arrayOfTPNativePlayerProgramInfo == null) || (arrayOfTPNativePlayerProgramInfo.length <= 0))
    {
      AppMethodBeat.o(191821);
      return null;
    }
    k[] arrayOfk = new k[arrayOfTPNativePlayerProgramInfo.length];
    int i = 0;
    if (i < arrayOfTPNativePlayerProgramInfo.length)
    {
      TPNativePlayerProgramInfo localTPNativePlayerProgramInfo = arrayOfTPNativePlayerProgramInfo[i];
      k localk;
      if (localTPNativePlayerProgramInfo != null)
      {
        localk = new k();
        localk.name = localTPNativePlayerProgramInfo.name;
        localk.bandwidth = localTPNativePlayerProgramInfo.bandwidth;
      }
      for (;;)
      {
        arrayOfk[i] = localk;
        i += 1;
        break;
        localk = null;
      }
    }
    AppMethodBeat.o(191821);
    return arrayOfk;
  }
  
  public final void g(String paramString1, String paramString2, List<f> paramList)
  {
    AppMethodBeat.i(191793);
    com.tencent.thumbplayer.utils.d.i(TAG, "addAudioTrackSource");
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(191793);
      return;
    }
    paramList = new i.a();
    paramList.LYY = paramString1;
    paramString1 = this.LYo;
    if (paramString1 != null) {
      paramString1.a(1012, 0L, 0L, paramList);
    }
    this.LYl.addAudioTrackSource(paramList.lnz, paramString2);
    AppMethodBeat.o(191793);
  }
  
  public final long getBufferedDurationMs()
  {
    AppMethodBeat.i(191816);
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.i(TAG, "player has released, return 0");
      AppMethodBeat.o(191816);
      return 0L;
    }
    long l = this.LYl.getBufferedDurationMs();
    AppMethodBeat.o(191816);
    return l;
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(191815);
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.i(TAG, "player has released, return 0");
      AppMethodBeat.o(191815);
      return 0L;
    }
    long l = this.LYl.getCurrentPositionMs();
    AppMethodBeat.o(191815);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(191814);
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.i(TAG, "player has released, return 0");
      AppMethodBeat.o(191814);
      return 0L;
    }
    long l = this.LYl.getDurationMs();
    AppMethodBeat.o(191814);
    return l;
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(191812);
    com.tencent.thumbplayer.utils.d.i(TAG, "getPropertyLong:".concat(String.valueOf(paramInt)));
    fWs();
    paramInt = c.ahe(paramInt);
    if (paramInt < 0)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "paramId not found, return -1");
      AppMethodBeat.o(191812);
      return -1L;
    }
    long l = this.LYl.getPropertyLong(paramInt);
    AppMethodBeat.o(191812);
    return l;
  }
  
  public final String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(191813);
    com.tencent.thumbplayer.utils.d.i(TAG, "getPropertyString:".concat(String.valueOf(paramInt)));
    fWs();
    paramInt = c.ahe(paramInt);
    if (paramInt < 0)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "paramId not found, return");
      AppMethodBeat.o(191813);
      return "";
    }
    String str = this.LYl.getPropertyString(paramInt);
    AppMethodBeat.o(191813);
    return str;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(191818);
    com.tencent.thumbplayer.utils.d.i(TAG, "getVideoHeight");
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.i(TAG, "player has released, return 0");
      AppMethodBeat.o(191818);
      return 0;
    }
    int i = this.LYl.getVideoHeight();
    AppMethodBeat.o(191818);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(191817);
    com.tencent.thumbplayer.utils.d.i(TAG, "getVideoWidth");
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.i(TAG, "player has released, return 0");
      AppMethodBeat.o(191817);
      return 0;
    }
    int i = this.LYl.getVideoWidth();
    AppMethodBeat.o(191817);
    return i;
  }
  
  public final void kS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191804);
    com.tencent.thumbplayer.utils.d.i(TAG, "seekTo:" + paramInt1 + " mode:" + paramInt2);
    fWs();
    paramInt2 = c.ahb(paramInt2);
    if (this.LYl.seekToAsync(paramInt1, paramInt2, 0L) != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("seek to position:" + paramInt1 + " failed!!");
      AppMethodBeat.o(191804);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(191804);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(191799);
    com.tencent.thumbplayer.utils.d.i(TAG, "pause");
    fWs();
    if (this.LYl.pause() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("pause failed!!");
      AppMethodBeat.o(191799);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(191799);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(191796);
    com.tencent.thumbplayer.utils.d.i(TAG, "prepare");
    fWs();
    this.LYl.setInitConfig(this.LYm);
    if (this.LYl.prepare() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("prepare failed!!");
      AppMethodBeat.o(191796);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(191796);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(191797);
    com.tencent.thumbplayer.utils.d.i(TAG, "prepareAsync");
    fWs();
    this.LYl.setInitConfig(this.LYm);
    if (this.LYl.prepareAsync() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("prepareAsync failed!!");
      AppMethodBeat.o(191797);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(191797);
  }
  
  public final void release()
  {
    AppMethodBeat.i(191802);
    com.tencent.thumbplayer.utils.d.i(TAG, "release");
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(191802);
      return;
    }
    this.LYl.release();
    this.LYl = null;
    this.LYp.release();
    AppMethodBeat.o(191802);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(191801);
    com.tencent.thumbplayer.utils.d.i(TAG, "reset");
    fWs();
    com.tencent.thumbplayer.utils.d.i(TAG, "reset before");
    this.LYl.reset();
    com.tencent.thumbplayer.utils.d.i(TAG, "reset after");
    AppMethodBeat.o(191801);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(191803);
    com.tencent.thumbplayer.utils.d.i(TAG, "seekTo:".concat(String.valueOf(paramInt)));
    fWs();
    if (this.LYl.seekToAsync(paramInt, 1, 0L) != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("seek to position:" + paramInt + " failed!!");
      AppMethodBeat.o(191803);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(191803);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(191788);
    com.tencent.thumbplayer.utils.d.i(TAG, "setDataSource: ".concat(String.valueOf(paramString)));
    fWs();
    if (this.LYl.setDataSource(paramString) != 0)
    {
      paramString = new IllegalStateException("setDataSource url failed!!");
      AppMethodBeat.o(191788);
      throw paramString;
    }
    this.LYp = new com.tencent.thumbplayer.c.c(paramString);
    AppMethodBeat.o(191788);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(191789);
    com.tencent.thumbplayer.utils.d.i(TAG, "setDataSource: ".concat(String.valueOf(paramString)));
    fWs();
    if (this.LYl.setDataSource(paramString) != 0)
    {
      paramString = new IllegalStateException("setDataSource url and header failed!!");
      AppMethodBeat.o(191789);
      throw paramString;
    }
    this.LYp = new com.tencent.thumbplayer.c.c(paramString);
    AppMethodBeat.o(191789);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(191787);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("setSurface， surface is null ? : ");
    if (paramSurface == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.thumbplayer.utils.d.i(str, bool);
      if (this.LYl != null) {
        break;
      }
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(191787);
      return;
    }
    if (this.LYl.setVideoSurface(paramSurface) != 0)
    {
      paramSurface = new IllegalStateException("setSurface failed!!");
      AppMethodBeat.o(191787);
      throw paramSurface;
    }
    AppMethodBeat.o(191787);
  }
  
  public final void start()
  {
    AppMethodBeat.i(191798);
    com.tencent.thumbplayer.utils.d.i(TAG, "start");
    fWs();
    if (this.LYl.start() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("start failed!!");
      AppMethodBeat.o(191798);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(191798);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(191800);
    com.tencent.thumbplayer.utils.d.i(TAG, "stop");
    fWs();
    com.tencent.thumbplayer.utils.d.i(TAG, "stop before");
    int i = this.LYl.stop();
    com.tencent.thumbplayer.utils.d.i(TAG, "stop after");
    if (i != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("stop failed!!");
      AppMethodBeat.o(191800);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(191800);
  }
  
  public final void zv(boolean paramBoolean)
  {
    AppMethodBeat.i(191810);
    com.tencent.thumbplayer.utils.d.i(TAG, "setLoopback:".concat(String.valueOf(paramBoolean)));
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(191810);
      return;
    }
    this.LYl.setLoopback(paramBoolean, 0L, -1L);
    AppMethodBeat.o(191810);
  }
  
  public final void zw(boolean paramBoolean)
  {
    AppMethodBeat.i(191807);
    com.tencent.thumbplayer.utils.d.i(TAG, "setOutputMute:".concat(String.valueOf(paramBoolean)));
    if (this.LYl == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(191807);
      return;
    }
    this.LYl.setAudioMute(paramBoolean);
    AppMethodBeat.o(191807);
  }
  
  final class a
    extends Handler
  {
    private WeakReference<b> nQG;
    
    public a(Looper paramLooper, b paramb)
    {
      super();
      AppMethodBeat.i(191781);
      this.nQG = new WeakReference(paramb);
      AppMethodBeat.o(191781);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(191782);
      if ((b)this.nQG.get() == null)
      {
        com.tencent.thumbplayer.utils.d.e(b.TAG, "mWeakRef is null");
        AppMethodBeat.o(191782);
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        com.tencent.thumbplayer.utils.d.w(b.TAG, "message :" + paramMessage.what + "  not recognition");
        AppMethodBeat.o(191782);
        return;
      case 1: 
        paramMessage = (b.b)paramMessage.obj;
        switch (paramMessage.LYv)
        {
        default: 
          b.a(b.this, paramMessage);
          AppMethodBeat.o(191782);
          return;
        case 1: 
          b.c(b.this);
          AppMethodBeat.o(191782);
          return;
        }
        b.d(b.this);
        AppMethodBeat.o(191782);
        return;
      case 2: 
        paramMessage = (b.d)paramMessage.obj;
        switch (paramMessage.infoType)
        {
        default: 
          b.a(b.this, paramMessage.infoType, paramMessage);
          AppMethodBeat.o(191782);
          return;
        case 250: 
          b.a(b.this, paramMessage.lParam1, paramMessage.LYw);
          AppMethodBeat.o(191782);
          return;
        }
        b.e(b.this);
        AppMethodBeat.o(191782);
        return;
      case 3: 
        paramMessage = (b.e)paramMessage.obj;
        switch (paramMessage.infoType)
        {
        default: 
          b.a(b.this, paramMessage.infoType, paramMessage);
        }
        do
        {
          AppMethodBeat.o(191782);
          return;
        } while (!(paramMessage.LYx instanceof String));
        b.f(b.this).LZk = ((String)paramMessage.LYx);
        b.b(b.this).a(b.f(b.this));
        AppMethodBeat.o(191782);
        return;
      }
      paramMessage = (b.c)paramMessage.obj;
      int i = paramMessage.msgType;
      int j = paramMessage.errorCode;
      b.b(b.this).a(c.ahg(i), j, 0L, 0L);
      AppMethodBeat.o(191782);
    }
  }
  
  public static final class b
  {
    long LWx;
    int LYv;
    int dnL;
    int errorCode;
  }
  
  public static final class c
  {
    int errorCode;
    int msgType;
  }
  
  public static final class d
  {
    long LYw;
    int infoType;
    long lParam1;
  }
  
  public static final class e
  {
    Object LYx;
    int infoType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */