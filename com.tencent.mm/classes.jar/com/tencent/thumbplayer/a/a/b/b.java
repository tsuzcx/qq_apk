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
  private TPNativePlayer Mvg;
  private TPNativePlayerInitConfig Mvh;
  private a Mvi;
  private com.tencent.thumbplayer.a.e Mvj;
  private com.tencent.thumbplayer.a.a.a Mvk;
  private m Mvl;
  private ITPNativePlayerMessageCallback Mvm;
  private ITPNativePlayerAudioFrameCallback Mvn;
  private ITPNativePlayerVideoFrameCallback Mvo;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(194461);
    this.Mvl = new m();
    this.Mvm = new ITPNativePlayerMessageCallback()
    {
      public final void onASyncCallResult(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(194453);
        com.tencent.thumbplayer.utils.d.i(b.TAG, "onASyncCallResult, callType:" + paramAnonymousInt1 + ", opaque:" + paramAnonymousLong + ", errorType:" + paramAnonymousInt2 + ", errorCode:" + paramAnonymousInt3);
        b.b localb = new b.b();
        localb.Mvq = paramAnonymousInt1;
        localb.Mts = paramAnonymousLong;
        localb.doQ = paramAnonymousInt2;
        localb.errorCode = paramAnonymousInt3;
        Message.obtain(b.a(b.this), 1, localb).sendToTarget();
        AppMethodBeat.o(194453);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(194456);
        com.tencent.thumbplayer.utils.d.i(b.TAG, "onError, msgType:" + paramAnonymousInt1 + ", errorCode:" + paramAnonymousInt2);
        b.c localc = new b.c();
        localc.msgType = paramAnonymousInt1;
        localc.errorCode = paramAnonymousInt2;
        Message.obtain(b.a(b.this), 4, localc).sendToTarget();
        AppMethodBeat.o(194456);
      }
      
      public final void onInfoLong(int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(194454);
        com.tencent.thumbplayer.utils.d.i(b.TAG, "onInfoLong, infoType:" + paramAnonymousInt + ", lParam1:" + paramAnonymousLong1 + ", lParam2:" + paramAnonymousLong2);
        b.d locald = new b.d();
        locald.infoType = paramAnonymousInt;
        locald.lParam1 = paramAnonymousLong1;
        locald.Mvr = paramAnonymousLong2;
        Message.obtain(b.a(b.this), 2, locald).sendToTarget();
        AppMethodBeat.o(194454);
      }
      
      public final void onInfoObject(int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(194455);
        com.tencent.thumbplayer.utils.d.i(b.TAG, "onInfoObject, infoType:" + paramAnonymousInt + ", objParam:" + paramAnonymousObject);
        b.e locale = new b.e();
        locale.infoType = paramAnonymousInt;
        locale.Mvs = paramAnonymousObject;
        Message.obtain(b.a(b.this), 3, locale).sendToTarget();
        AppMethodBeat.o(194455);
      }
    };
    this.Mvn = new ITPNativePlayerAudioFrameCallback()
    {
      public final void onAudioFrame(TPAudioFrame paramAnonymousTPAudioFrame, int paramAnonymousInt)
      {
        AppMethodBeat.i(194457);
        paramAnonymousTPAudioFrame = c.a(paramAnonymousTPAudioFrame);
        b.b(b.this).a(paramAnonymousTPAudioFrame);
        AppMethodBeat.o(194457);
      }
    };
    this.Mvo = new ITPNativePlayerVideoFrameCallback()
    {
      public final void onVideoFrame(TPVideoFrame paramAnonymousTPVideoFrame, int paramAnonymousInt)
      {
        AppMethodBeat.i(194458);
        paramAnonymousTPVideoFrame = c.a(paramAnonymousTPVideoFrame);
        b.b(b.this).a(paramAnonymousTPVideoFrame);
        AppMethodBeat.o(194458);
      }
    };
    this.Mvg = new TPNativePlayer(paramContext);
    this.Mvg.setMessageCallback(this.Mvm);
    this.Mvg.setAudioFrameCallback(this.Mvn);
    this.Mvg.setVideoFrameCallback(this.Mvo);
    this.Mvh = new TPNativePlayerInitConfig();
    this.Mvj = new com.tencent.thumbplayer.a.e(TAG);
    paramContext = Looper.myLooper();
    if (paramContext != null)
    {
      this.Mvi = new a(paramContext, this);
      AppMethodBeat.o(194461);
      return;
    }
    paramContext = Looper.getMainLooper();
    if (paramContext != null)
    {
      this.Mvi = new a(paramContext, this);
      AppMethodBeat.o(194461);
      return;
    }
    this.Mvi = null;
    AppMethodBeat.o(194461);
  }
  
  private void a(int paramInt, f.c paramc)
  {
    AppMethodBeat.i(194463);
    c.a locala = c.ahL(paramInt);
    if (locala == null)
    {
      com.tencent.thumbplayer.utils.d.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(194463);
      return;
    }
    if ((paramc.MvP == null) || (paramc.MvP.length == 0))
    {
      com.tencent.thumbplayer.utils.d.e(TAG, "queueint params is empty in".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(194463);
      return;
    }
    switch (locala.Mvz)
    {
    default: 
      com.tencent.thumbplayer.utils.d.e(TAG, "optionID type:" + locala.Mvz + " is not implement");
      AppMethodBeat.o(194463);
      return;
    }
    paramInt = 0;
    while (paramInt < paramc.MvP.length)
    {
      this.Mvh.addQueueInt(locala.MvA, paramc.MvP[paramInt]);
      paramInt += 1;
    }
    AppMethodBeat.o(194463);
  }
  
  private void a(int paramInt, f.d paramd)
  {
    AppMethodBeat.i(194464);
    c.a locala = c.ahL(paramInt);
    if (locala == null)
    {
      com.tencent.thumbplayer.utils.d.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(194464);
      return;
    }
    if ((paramd.MvQ == null) || (paramd.MvQ.length == 0))
    {
      com.tencent.thumbplayer.utils.d.e(TAG, "queue String params is empty in".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(194464);
      return;
    }
    switch (locala.Mvz)
    {
    default: 
      com.tencent.thumbplayer.utils.d.e(TAG, "optionID type:" + locala.Mvz + " is not implement");
      AppMethodBeat.o(194464);
      return;
    }
    paramInt = 0;
    while (paramInt < paramd.MvQ.length)
    {
      this.Mvh.addQueueString(locala.MvA, paramd.MvQ[paramInt]);
      paramInt += 1;
    }
    AppMethodBeat.o(194464);
  }
  
  private void gaR()
  {
    AppMethodBeat.i(194501);
    if (this.Mvg == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("player has release");
      AppMethodBeat.o(194501);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(194501);
  }
  
  public final void L(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(194483);
    com.tencent.thumbplayer.utils.d.i(TAG, "switchDefinition url:" + paramString + " opaque:" + paramLong);
    gaR();
    paramInt = c.ahQ(paramInt);
    if (this.Mvg.switchDefinitionAsync(paramString, paramInt, paramLong) != 0)
    {
      paramString = new IllegalStateException("switchDefinition in invalid state");
      AppMethodBeat.o(194483);
      throw paramString;
    }
    this.Mvk = new com.tencent.thumbplayer.c.c(paramString);
    AppMethodBeat.o(194483);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    this.Mvj.MtN = parama;
  }
  
  public final void a(c.b paramb)
  {
    this.Mvj.MtG = paramb;
  }
  
  public final void a(c.c paramc)
  {
    this.Mvj.MtI = paramc;
  }
  
  public final void a(c.d paramd)
  {
    this.Mvj.MtH = paramd;
  }
  
  public final void a(c.e parame)
  {
    this.Mvj.MtF = parame;
  }
  
  public final void a(c.f paramf)
  {
    this.Mvj.MtJ = paramf;
  }
  
  public final void a(c.h paramh)
  {
    this.Mvj.MtL = paramh;
  }
  
  public final void a(c.i parami)
  {
    this.Mvj.MtM = parami;
  }
  
  public final void a(c.j paramj)
  {
    this.Mvj.MtK = paramj;
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama)
  {
    AppMethodBeat.i(194469);
    com.tencent.thumbplayer.utils.d.i(TAG, "setDataSource: ".concat(String.valueOf(parama)));
    gaR();
    if (parama == null)
    {
      parama = new IllegalStateException("media asset is null!");
      AppMethodBeat.o(194469);
      throw parama;
    }
    if ((!(parama instanceof com.tencent.thumbplayer.d.b)) && (!(parama instanceof com.tencent.thumbplayer.d.d)) && (!(parama instanceof com.tencent.thumbplayer.d.e)) && (!(parama instanceof g)))
    {
      parama = new IllegalStateException("media asset is illegal source!");
      AppMethodBeat.o(194469);
      throw parama;
    }
    parama = parama.getUrl();
    if (this.Mvg.setDataSource(parama) != 0)
    {
      parama = new IllegalStateException("setDataSource mediaAsset failed!!");
      AppMethodBeat.o(194469);
      throw parama;
    }
    this.Mvk = new com.tencent.thumbplayer.c.c(parama);
    AppMethodBeat.o(194469);
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(194484);
    com.tencent.thumbplayer.utils.d.i(TAG, "switchDefinition mediaAsset:" + parama + " opaque:" + paramLong);
    gaR();
    if (parama != null)
    {
      paramInt = c.ahQ(paramInt);
      if (this.Mvg.switchDefinitionAsync(parama.getUrl(), paramInt, paramLong) != 0)
      {
        parama = new IllegalStateException("switchDefinition in invalid state");
        AppMethodBeat.o(194484);
        throw parama;
      }
      this.Mvk = new com.tencent.thumbplayer.c.c(parama.getUrl());
    }
    AppMethodBeat.o(194484);
  }
  
  public final void a(com.tencent.thumbplayer.b.e parame, com.tencent.thumbplayer.b.d paramd)
  {
    AppMethodBeat.i(194500);
    com.tencent.thumbplayer.utils.d.i(TAG, "captureVideo, params".concat(String.valueOf(parame)));
    if (this.Mvk != null)
    {
      TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
      localTPImageGeneratorParams.width = parame.width;
      localTPImageGeneratorParams.height = parame.height;
      localTPImageGeneratorParams.format = parame.format;
      localTPImageGeneratorParams.requestedTimeMsToleranceAfter = parame.requestedTimeMsToleranceAfter;
      localTPImageGeneratorParams.requestedTimeMsToleranceBefore = parame.requestedTimeMsToleranceBefore;
      this.Mvk.a(getCurrentPositionMs(), localTPImageGeneratorParams, paramd);
    }
    AppMethodBeat.o(194500);
  }
  
  public final void aR(int paramInt, long paramLong)
  {
    AppMethodBeat.i(194472);
    com.tencent.thumbplayer.utils.d.i(TAG, "selectTrack");
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(194472);
      return;
    }
    this.Mvg.selectTrackAsync(paramInt, paramLong);
    AppMethodBeat.o(194472);
  }
  
  public final void aS(int paramInt, long paramLong)
  {
    AppMethodBeat.i(194473);
    com.tencent.thumbplayer.utils.d.i(TAG, "selectTrack");
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(194473);
      return;
    }
    this.Mvg.deselectTrackAsync(paramInt, paramLong);
    AppMethodBeat.o(194473);
  }
  
  public final void aT(int paramInt, long paramLong)
  {
    AppMethodBeat.i(194498);
    com.tencent.thumbplayer.utils.d.i(TAG, "selectProgram");
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(194498);
      return;
    }
    this.Mvg.selectProgramAsync(paramInt, paramLong);
    AppMethodBeat.o(194498);
  }
  
  public final void b(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(194468);
    com.tencent.thumbplayer.utils.d.i(TAG, "setDataSource: ".concat(String.valueOf(paramParcelFileDescriptor)));
    gaR();
    if (this.Mvg.setDataSource(paramParcelFileDescriptor.getFd()) != 0)
    {
      paramParcelFileDescriptor = new IllegalStateException("setDataSource url pfd failed!!");
      AppMethodBeat.o(194468);
      throw paramParcelFileDescriptor;
    }
    this.Mvk = new com.tencent.thumbplayer.c.c(paramParcelFileDescriptor.getFd());
    AppMethodBeat.o(194468);
  }
  
  public final void b(f paramf)
  {
    boolean bool = true;
    AppMethodBeat.i(194462);
    com.tencent.thumbplayer.utils.d.i(TAG, "setPlayerOptionalParam:".concat(String.valueOf(paramf)));
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(194462);
      return;
    }
    int i;
    c.a locala;
    Object localObject;
    if (paramf.MvH == 1)
    {
      if (paramf.key < 500)
      {
        i = paramf.key;
        paramf = paramf.MvI;
        locala = c.ahL(i);
        if (locala == null)
        {
          com.tencent.thumbplayer.utils.d.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(194462);
          return;
        }
        switch (locala.Mvz)
        {
        default: 
          com.tencent.thumbplayer.utils.d.e(TAG, "optionID type:" + locala.Mvz + " is not implement");
          AppMethodBeat.o(194462);
          return;
        }
        this.Mvh.setBool(locala.MvA, paramf.value);
        AppMethodBeat.o(194462);
        return;
      }
      i = paramf.key;
      paramf = paramf.MvI;
      locala = c.ahL(i);
      if (locala == null)
      {
        com.tencent.thumbplayer.utils.d.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(i)));
        AppMethodBeat.o(194462);
        return;
      }
      switch (locala.Mvz)
      {
      default: 
        com.tencent.thumbplayer.utils.d.e(TAG, "optionID type:" + locala.Mvz + " is not implement");
        AppMethodBeat.o(194462);
        return;
      }
      localObject = this.Mvg;
      i = locala.MvA;
      if (paramf.value) {}
      for (long l = 1L;; l = 0L)
      {
        ((TPNativePlayer)localObject).setOptionLong(i, l, 0L);
        AppMethodBeat.o(194462);
        return;
      }
    }
    if (paramf.MvH == 2)
    {
      if (paramf.key < 500)
      {
        i = paramf.key;
        paramf = paramf.MvJ;
        locala = c.ahL(i);
        if (locala == null)
        {
          com.tencent.thumbplayer.utils.d.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(194462);
          return;
        }
        switch (locala.Mvz)
        {
        case 2: 
        default: 
          com.tencent.thumbplayer.utils.d.e(TAG, "optionID type:" + locala.Mvz + " is not implement");
          AppMethodBeat.o(194462);
          return;
        case 1: 
          this.Mvh.setLong(locala.MvA, paramf.value);
          AppMethodBeat.o(194462);
          return;
        case 4: 
          this.Mvh.setInt(locala.MvA, (int)paramf.value);
          AppMethodBeat.o(194462);
          return;
        }
        localObject = this.Mvh;
        i = locala.MvA;
        if (paramf.value > 0L) {}
        for (;;)
        {
          ((TPNativePlayerInitConfig)localObject).setBool(i, bool);
          AppMethodBeat.o(194462);
          return;
          bool = false;
        }
      }
      i = paramf.key;
      paramf = paramf.MvJ;
      locala = c.ahL(i);
      if (locala == null)
      {
        com.tencent.thumbplayer.utils.d.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(i)));
        AppMethodBeat.o(194462);
        return;
      }
      switch (locala.Mvz)
      {
      case 2: 
      default: 
        com.tencent.thumbplayer.utils.d.e(TAG, "optionID type:" + locala.Mvz + " is not implement");
        AppMethodBeat.o(194462);
        return;
      case 1: 
        this.Mvg.setOptionLong(locala.MvA, paramf.value, paramf.MvN);
        AppMethodBeat.o(194462);
        return;
      case 4: 
        this.Mvg.setOptionLong(locala.MvA, paramf.value, paramf.MvN);
        AppMethodBeat.o(194462);
        return;
      }
      this.Mvg.setOptionLong(locala.MvA, paramf.value, paramf.MvN);
      AppMethodBeat.o(194462);
      return;
    }
    if (paramf.MvH == 3)
    {
      if (paramf.key < 500)
      {
        com.tencent.thumbplayer.utils.d.e(TAG, "init string param type is not implement coz native init config no string setting");
        AppMethodBeat.o(194462);
        return;
      }
      i = paramf.key;
      paramf = paramf.MvK;
      locala = c.ahL(i);
      if (locala == null)
      {
        com.tencent.thumbplayer.utils.d.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(i)));
        AppMethodBeat.o(194462);
        return;
      }
      switch (locala.Mvz)
      {
      default: 
        com.tencent.thumbplayer.utils.d.e(TAG, "optionID type:" + locala.Mvz + " is not implement");
        AppMethodBeat.o(194462);
        return;
      }
      this.Mvg.setOptionObject(locala.MvA, paramf.value);
      AppMethodBeat.o(194462);
      return;
    }
    if (paramf.MvH == 4)
    {
      if (paramf.key < 500)
      {
        a(paramf.key, paramf.MvL);
        AppMethodBeat.o(194462);
      }
    }
    else if (paramf.MvH == 5)
    {
      if (paramf.key < 500)
      {
        a(paramf.key, paramf.MvM);
        AppMethodBeat.o(194462);
      }
    }
    else
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "optionalParam param type is unknow, return");
      AppMethodBeat.o(194462);
      return;
    }
    AppMethodBeat.o(194462);
  }
  
  public final void bl(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(194470);
    com.tencent.thumbplayer.utils.d.i(TAG, "addSubtitleSource");
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(194470);
      return;
    }
    this.Mvg.addSubtitleTrackSource(paramString1, paramString3);
    AppMethodBeat.o(194470);
  }
  
  public final void c(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194489);
    com.tencent.thumbplayer.utils.d.i(TAG, "setLoopback:" + paramBoolean + " loopStartPositionMs:" + paramLong1 + " loopEndPositionMs:" + paramLong2);
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(194489);
      return;
    }
    if (this.Mvg.setLoopback(paramBoolean, paramLong1, paramLong2) != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("set loopback failed!!");
      AppMethodBeat.o(194489);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(194489);
  }
  
  public final void cg(float paramFloat)
  {
    AppMethodBeat.i(194486);
    com.tencent.thumbplayer.utils.d.i(TAG, "setAudioGainRatio:".concat(String.valueOf(paramFloat)));
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(194486);
      return;
    }
    this.Mvg.setAudioVolume(paramFloat);
    AppMethodBeat.o(194486);
  }
  
  public final void ch(float paramFloat)
  {
    AppMethodBeat.i(194487);
    com.tencent.thumbplayer.utils.d.i(TAG, "setPlaySpeedRatio:".concat(String.valueOf(paramFloat)));
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(194487);
      return;
    }
    this.Mvg.setPlaybackRate(paramFloat);
    AppMethodBeat.o(194487);
  }
  
  public final void g(String paramString1, String paramString2, List<f> paramList)
  {
    AppMethodBeat.i(194471);
    com.tencent.thumbplayer.utils.d.i(TAG, "addAudioTrackSource");
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(194471);
      return;
    }
    paramList = new i.a();
    paramList.MvT = paramString1;
    paramString1 = this.Mvj;
    if (paramString1 != null) {
      paramString1.a(1012, 0L, 0L, paramList);
    }
    this.Mvg.addAudioTrackSource(paramList.lrY, paramString2);
    AppMethodBeat.o(194471);
  }
  
  public final n[] gaF()
  {
    AppMethodBeat.i(194497);
    com.tencent.thumbplayer.utils.d.i(TAG, "getTrackInfo");
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.i(TAG, "player has released, return 0");
      AppMethodBeat.o(194497);
      return null;
    }
    TPMediaTrackInfo[] arrayOfTPMediaTrackInfo = this.Mvg.getTrackInfo();
    if ((arrayOfTPMediaTrackInfo == null) || (arrayOfTPMediaTrackInfo.length <= 0))
    {
      AppMethodBeat.o(194497);
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
    AppMethodBeat.o(194497);
    return arrayOfn;
  }
  
  public final k[] gaG()
  {
    AppMethodBeat.i(194499);
    com.tencent.thumbplayer.utils.d.i(TAG, "getProgramInfo");
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.i(TAG, "player has released, return 0");
      AppMethodBeat.o(194499);
      return null;
    }
    TPNativePlayerProgramInfo[] arrayOfTPNativePlayerProgramInfo = this.Mvg.getProgramInfo();
    if ((arrayOfTPNativePlayerProgramInfo == null) || (arrayOfTPNativePlayerProgramInfo.length <= 0))
    {
      AppMethodBeat.o(194499);
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
    AppMethodBeat.o(194499);
    return arrayOfk;
  }
  
  public final long getBufferedDurationMs()
  {
    AppMethodBeat.i(194494);
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.i(TAG, "player has released, return 0");
      AppMethodBeat.o(194494);
      return 0L;
    }
    long l = this.Mvg.getBufferedDurationMs();
    AppMethodBeat.o(194494);
    return l;
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(194493);
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.i(TAG, "player has released, return 0");
      AppMethodBeat.o(194493);
      return 0L;
    }
    long l = this.Mvg.getCurrentPositionMs();
    AppMethodBeat.o(194493);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(194492);
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.i(TAG, "player has released, return 0");
      AppMethodBeat.o(194492);
      return 0L;
    }
    long l = this.Mvg.getDurationMs();
    AppMethodBeat.o(194492);
    return l;
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(194490);
    com.tencent.thumbplayer.utils.d.i(TAG, "getPropertyLong:".concat(String.valueOf(paramInt)));
    gaR();
    paramInt = c.ahN(paramInt);
    if (paramInt < 0)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "paramId not found, return -1");
      AppMethodBeat.o(194490);
      return -1L;
    }
    long l = this.Mvg.getPropertyLong(paramInt);
    AppMethodBeat.o(194490);
    return l;
  }
  
  public final String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(194491);
    com.tencent.thumbplayer.utils.d.i(TAG, "getPropertyString:".concat(String.valueOf(paramInt)));
    gaR();
    paramInt = c.ahN(paramInt);
    if (paramInt < 0)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "paramId not found, return");
      AppMethodBeat.o(194491);
      return "";
    }
    String str = this.Mvg.getPropertyString(paramInt);
    AppMethodBeat.o(194491);
    return str;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(194496);
    com.tencent.thumbplayer.utils.d.i(TAG, "getVideoHeight");
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.i(TAG, "player has released, return 0");
      AppMethodBeat.o(194496);
      return 0;
    }
    int i = this.Mvg.getVideoHeight();
    AppMethodBeat.o(194496);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(194495);
    com.tencent.thumbplayer.utils.d.i(TAG, "getVideoWidth");
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.i(TAG, "player has released, return 0");
      AppMethodBeat.o(194495);
      return 0;
    }
    int i = this.Mvg.getVideoWidth();
    AppMethodBeat.o(194495);
    return i;
  }
  
  public final void kZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194482);
    com.tencent.thumbplayer.utils.d.i(TAG, "seekTo:" + paramInt1 + " mode:" + paramInt2);
    gaR();
    paramInt2 = c.ahK(paramInt2);
    if (this.Mvg.seekToAsync(paramInt1, paramInt2, 0L) != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("seek to position:" + paramInt1 + " failed!!");
      AppMethodBeat.o(194482);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(194482);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(194477);
    com.tencent.thumbplayer.utils.d.i(TAG, "pause");
    gaR();
    if (this.Mvg.pause() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("pause failed!!");
      AppMethodBeat.o(194477);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(194477);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(194474);
    com.tencent.thumbplayer.utils.d.i(TAG, "prepare");
    gaR();
    this.Mvg.setInitConfig(this.Mvh);
    if (this.Mvg.prepare() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("prepare failed!!");
      AppMethodBeat.o(194474);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(194474);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(194475);
    com.tencent.thumbplayer.utils.d.i(TAG, "prepareAsync");
    gaR();
    this.Mvg.setInitConfig(this.Mvh);
    if (this.Mvg.prepareAsync() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("prepareAsync failed!!");
      AppMethodBeat.o(194475);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(194475);
  }
  
  public final void release()
  {
    AppMethodBeat.i(194480);
    com.tencent.thumbplayer.utils.d.i(TAG, "release");
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(194480);
      return;
    }
    this.Mvg.release();
    this.Mvg = null;
    this.Mvk.release();
    AppMethodBeat.o(194480);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(194479);
    com.tencent.thumbplayer.utils.d.i(TAG, "reset");
    gaR();
    com.tencent.thumbplayer.utils.d.i(TAG, "reset before");
    this.Mvg.reset();
    com.tencent.thumbplayer.utils.d.i(TAG, "reset after");
    AppMethodBeat.o(194479);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(194481);
    com.tencent.thumbplayer.utils.d.i(TAG, "seekTo:".concat(String.valueOf(paramInt)));
    gaR();
    if (this.Mvg.seekToAsync(paramInt, 1, 0L) != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("seek to position:" + paramInt + " failed!!");
      AppMethodBeat.o(194481);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(194481);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(194466);
    com.tencent.thumbplayer.utils.d.i(TAG, "setDataSource: ".concat(String.valueOf(paramString)));
    gaR();
    if (this.Mvg.setDataSource(paramString) != 0)
    {
      paramString = new IllegalStateException("setDataSource url failed!!");
      AppMethodBeat.o(194466);
      throw paramString;
    }
    this.Mvk = new com.tencent.thumbplayer.c.c(paramString);
    AppMethodBeat.o(194466);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(194467);
    com.tencent.thumbplayer.utils.d.i(TAG, "setDataSource: ".concat(String.valueOf(paramString)));
    gaR();
    if (this.Mvg.setDataSource(paramString) != 0)
    {
      paramString = new IllegalStateException("setDataSource url and header failed!!");
      AppMethodBeat.o(194467);
      throw paramString;
    }
    this.Mvk = new com.tencent.thumbplayer.c.c(paramString);
    AppMethodBeat.o(194467);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(194465);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("setSurface， surface is null ? : ");
    if (paramSurface == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.thumbplayer.utils.d.i(str, bool);
      if (this.Mvg != null) {
        break;
      }
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(194465);
      return;
    }
    if (this.Mvg.setVideoSurface(paramSurface) != 0)
    {
      paramSurface = new IllegalStateException("setSurface failed!!");
      AppMethodBeat.o(194465);
      throw paramSurface;
    }
    AppMethodBeat.o(194465);
  }
  
  public final void start()
  {
    AppMethodBeat.i(194476);
    com.tencent.thumbplayer.utils.d.i(TAG, "start");
    gaR();
    if (this.Mvg.start() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("start failed!!");
      AppMethodBeat.o(194476);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(194476);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(194478);
    com.tencent.thumbplayer.utils.d.i(TAG, "stop");
    gaR();
    com.tencent.thumbplayer.utils.d.i(TAG, "stop before");
    int i = this.Mvg.stop();
    com.tencent.thumbplayer.utils.d.i(TAG, "stop after");
    if (i != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("stop failed!!");
      AppMethodBeat.o(194478);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(194478);
  }
  
  public final void zJ(boolean paramBoolean)
  {
    AppMethodBeat.i(194488);
    com.tencent.thumbplayer.utils.d.i(TAG, "setLoopback:".concat(String.valueOf(paramBoolean)));
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(194488);
      return;
    }
    this.Mvg.setLoopback(paramBoolean, 0L, -1L);
    AppMethodBeat.o(194488);
  }
  
  public final void zK(boolean paramBoolean)
  {
    AppMethodBeat.i(194485);
    com.tencent.thumbplayer.utils.d.i(TAG, "setOutputMute:".concat(String.valueOf(paramBoolean)));
    if (this.Mvg == null)
    {
      com.tencent.thumbplayer.utils.d.w(TAG, "player has released, return");
      AppMethodBeat.o(194485);
      return;
    }
    this.Mvg.setAudioMute(paramBoolean);
    AppMethodBeat.o(194485);
  }
  
  final class a
    extends Handler
  {
    private WeakReference<b> nWm;
    
    public a(Looper paramLooper, b paramb)
    {
      super();
      AppMethodBeat.i(194459);
      this.nWm = new WeakReference(paramb);
      AppMethodBeat.o(194459);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(194460);
      if ((b)this.nWm.get() == null)
      {
        com.tencent.thumbplayer.utils.d.e(b.TAG, "mWeakRef is null");
        AppMethodBeat.o(194460);
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        com.tencent.thumbplayer.utils.d.w(b.TAG, "message :" + paramMessage.what + "  not recognition");
        AppMethodBeat.o(194460);
        return;
      case 1: 
        paramMessage = (b.b)paramMessage.obj;
        switch (paramMessage.Mvq)
        {
        default: 
          b.a(b.this, paramMessage);
          AppMethodBeat.o(194460);
          return;
        case 1: 
          b.c(b.this);
          AppMethodBeat.o(194460);
          return;
        }
        b.d(b.this);
        AppMethodBeat.o(194460);
        return;
      case 2: 
        paramMessage = (b.d)paramMessage.obj;
        switch (paramMessage.infoType)
        {
        default: 
          b.a(b.this, paramMessage.infoType, paramMessage);
          AppMethodBeat.o(194460);
          return;
        case 250: 
          b.a(b.this, paramMessage.lParam1, paramMessage.Mvr);
          AppMethodBeat.o(194460);
          return;
        }
        b.e(b.this);
        AppMethodBeat.o(194460);
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
          AppMethodBeat.o(194460);
          return;
        } while (!(paramMessage.Mvs instanceof String));
        b.f(b.this).Mwf = ((String)paramMessage.Mvs);
        b.b(b.this).a(b.f(b.this));
        AppMethodBeat.o(194460);
        return;
      }
      paramMessage = (b.c)paramMessage.obj;
      int i = paramMessage.msgType;
      int j = paramMessage.errorCode;
      b.b(b.this).a(c.ahP(i), j, 0L, 0L);
      AppMethodBeat.o(194460);
    }
  }
  
  public static final class b
  {
    long Mts;
    int Mvq;
    int doQ;
    int errorCode;
  }
  
  public static final class c
  {
    int errorCode;
    int msgType;
  }
  
  public static final class d
  {
    long Mvr;
    int infoType;
    long lParam1;
  }
  
  public static final class e
  {
    Object Mvs;
    int infoType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */