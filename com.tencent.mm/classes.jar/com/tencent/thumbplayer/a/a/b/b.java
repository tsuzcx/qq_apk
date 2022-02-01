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
  private TPNativePlayer Kep;
  private TPNativePlayerInitConfig Keq;
  private a Ker;
  private com.tencent.thumbplayer.a.e Kes;
  private com.tencent.thumbplayer.a.a.a Ket;
  private m Keu;
  private ITPNativePlayerMessageCallback Kev;
  private ITPNativePlayerAudioFrameCallback Kew;
  private ITPNativePlayerVideoFrameCallback Kex;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(187762);
    this.Keu = new m();
    this.Kev = new ITPNativePlayerMessageCallback()
    {
      public final void onASyncCallResult(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(187754);
        com.tencent.thumbplayer.utils.f.i(b.TAG, "onASyncCallResult, callType:" + paramAnonymousInt1 + ", opaque:" + paramAnonymousLong + ", errorType:" + paramAnonymousInt2 + ", errorCode:" + paramAnonymousInt3);
        b.b localb = new b.b();
        localb.Kez = paramAnonymousInt1;
        localb.KcB = paramAnonymousLong;
        localb.dcp = paramAnonymousInt2;
        localb.errorCode = paramAnonymousInt3;
        Message.obtain(b.a(b.this), 1, localb).sendToTarget();
        AppMethodBeat.o(187754);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(187757);
        com.tencent.thumbplayer.utils.f.i(b.TAG, "onError, msgType:" + paramAnonymousInt1 + ", errorCode:" + paramAnonymousInt2);
        b.c localc = new b.c();
        localc.msgType = paramAnonymousInt1;
        localc.errorCode = paramAnonymousInt2;
        Message.obtain(b.a(b.this), 4, localc).sendToTarget();
        AppMethodBeat.o(187757);
      }
      
      public final void onInfoLong(int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(187755);
        com.tencent.thumbplayer.utils.f.i(b.TAG, "onInfoLong, infoType:" + paramAnonymousInt + ", lParam1:" + paramAnonymousLong1 + ", lParam2:" + paramAnonymousLong2);
        b.d locald = new b.d();
        locald.infoType = paramAnonymousInt;
        locald.lParam1 = paramAnonymousLong1;
        locald.KeA = paramAnonymousLong2;
        Message.obtain(b.a(b.this), 2, locald).sendToTarget();
        AppMethodBeat.o(187755);
      }
      
      public final void onInfoObject(int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(187756);
        com.tencent.thumbplayer.utils.f.i(b.TAG, "onInfoObject, infoType:" + paramAnonymousInt + ", objParam:" + paramAnonymousObject);
        b.e locale = new b.e();
        locale.infoType = paramAnonymousInt;
        locale.KeB = paramAnonymousObject;
        Message.obtain(b.a(b.this), 3, locale).sendToTarget();
        AppMethodBeat.o(187756);
      }
    };
    this.Kew = new ITPNativePlayerAudioFrameCallback()
    {
      public final void onAudioFrame(TPAudioFrame paramAnonymousTPAudioFrame, int paramAnonymousInt)
      {
        AppMethodBeat.i(187758);
        paramAnonymousTPAudioFrame = c.a(paramAnonymousTPAudioFrame);
        b.b(b.this).a(paramAnonymousTPAudioFrame);
        AppMethodBeat.o(187758);
      }
    };
    this.Kex = new ITPNativePlayerVideoFrameCallback()
    {
      public final void onVideoFrame(TPVideoFrame paramAnonymousTPVideoFrame, int paramAnonymousInt)
      {
        AppMethodBeat.i(187759);
        paramAnonymousTPVideoFrame = c.a(paramAnonymousTPVideoFrame);
        b.b(b.this).a(paramAnonymousTPVideoFrame);
        AppMethodBeat.o(187759);
      }
    };
    this.Kep = new TPNativePlayer(paramContext);
    this.Kep.setMessageCallback(this.Kev);
    this.Kep.setAudioFrameCallback(this.Kew);
    this.Kep.setVideoFrameCallback(this.Kex);
    this.Keq = new TPNativePlayerInitConfig();
    this.Kes = new com.tencent.thumbplayer.a.e(TAG);
    paramContext = Looper.myLooper();
    if (paramContext != null)
    {
      this.Ker = new a(paramContext, this);
      AppMethodBeat.o(187762);
      return;
    }
    paramContext = Looper.getMainLooper();
    if (paramContext != null)
    {
      this.Ker = new a(paramContext, this);
      AppMethodBeat.o(187762);
      return;
    }
    this.Ker = null;
    AppMethodBeat.o(187762);
  }
  
  private void a(int paramInt, f.c paramc)
  {
    AppMethodBeat.i(187764);
    c.a locala = c.aeC(paramInt);
    if (locala == null)
    {
      com.tencent.thumbplayer.utils.f.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(187764);
      return;
    }
    if ((paramc.KeY == null) || (paramc.KeY.length == 0))
    {
      com.tencent.thumbplayer.utils.f.e(TAG, "queueint params is empty in".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(187764);
      return;
    }
    switch (locala.KeI)
    {
    default: 
      com.tencent.thumbplayer.utils.f.e(TAG, "optionID type:" + locala.KeI + " is not implement");
      AppMethodBeat.o(187764);
      return;
    }
    paramInt = 0;
    while (paramInt < paramc.KeY.length)
    {
      this.Keq.addQueueInt(locala.KeJ, paramc.KeY[paramInt]);
      paramInt += 1;
    }
    AppMethodBeat.o(187764);
  }
  
  private void a(int paramInt, f.d paramd)
  {
    AppMethodBeat.i(187765);
    c.a locala = c.aeC(paramInt);
    if (locala == null)
    {
      com.tencent.thumbplayer.utils.f.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(187765);
      return;
    }
    if ((paramd.KeZ == null) || (paramd.KeZ.length == 0))
    {
      com.tencent.thumbplayer.utils.f.e(TAG, "queue String params is empty in".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(187765);
      return;
    }
    switch (locala.KeI)
    {
    default: 
      com.tencent.thumbplayer.utils.f.e(TAG, "optionID type:" + locala.KeI + " is not implement");
      AppMethodBeat.o(187765);
      return;
    }
    paramInt = 0;
    while (paramInt < paramd.KeZ.length)
    {
      this.Keq.addQueueString(locala.KeJ, paramd.KeZ[paramInt]);
      paramInt += 1;
    }
    AppMethodBeat.o(187765);
  }
  
  private void fFa()
  {
    AppMethodBeat.i(187802);
    if (this.Kep == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("player has release");
      AppMethodBeat.o(187802);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(187802);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    this.Kes.KcW = parama;
  }
  
  public final void a(c.b paramb)
  {
    this.Kes.KcP = paramb;
  }
  
  public final void a(c.c paramc)
  {
    this.Kes.KcR = paramc;
  }
  
  public final void a(c.d paramd)
  {
    this.Kes.KcQ = paramd;
  }
  
  public final void a(c.e parame)
  {
    this.Kes.KcO = parame;
  }
  
  public final void a(c.f paramf)
  {
    this.Kes.KcS = paramf;
  }
  
  public final void a(c.h paramh)
  {
    this.Kes.KcU = paramh;
  }
  
  public final void a(c.i parami)
  {
    this.Kes.KcV = parami;
  }
  
  public final void a(c.j paramj)
  {
    this.Kes.KcT = paramj;
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama)
  {
    AppMethodBeat.i(187770);
    com.tencent.thumbplayer.utils.f.i(TAG, "setDataSource: ".concat(String.valueOf(parama)));
    fFa();
    if (parama == null)
    {
      parama = new IllegalStateException("media asset is null!");
      AppMethodBeat.o(187770);
      throw parama;
    }
    if ((!(parama instanceof com.tencent.thumbplayer.d.b)) && (!(parama instanceof com.tencent.thumbplayer.d.d)) && (!(parama instanceof com.tencent.thumbplayer.d.e)) && (!(parama instanceof g)))
    {
      parama = new IllegalStateException("media asset is illegal source!");
      AppMethodBeat.o(187770);
      throw parama;
    }
    parama = parama.getUrl();
    if (this.Kep.setDataSource(parama) != 0)
    {
      parama = new IllegalStateException("setDataSource mediaAsset failed!!");
      AppMethodBeat.o(187770);
      throw parama;
    }
    this.Ket = new com.tencent.thumbplayer.c.c(parama);
    AppMethodBeat.o(187770);
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(187785);
    com.tencent.thumbplayer.utils.f.i(TAG, "switchDefinition mediaAsset:" + parama + " opaque:" + paramLong);
    fFa();
    if (parama != null)
    {
      paramInt = c.aeH(paramInt);
      if (this.Kep.switchDefinitionAsync(parama.getUrl(), paramInt, paramLong) != 0)
      {
        parama = new IllegalStateException("switchDefinition in invalid state");
        AppMethodBeat.o(187785);
        throw parama;
      }
      this.Ket = new com.tencent.thumbplayer.c.c(parama.getUrl());
    }
    AppMethodBeat.o(187785);
  }
  
  public final void a(com.tencent.thumbplayer.b.e parame, com.tencent.thumbplayer.b.d paramd)
  {
    AppMethodBeat.i(187801);
    com.tencent.thumbplayer.utils.f.i(TAG, "captureVideo, params".concat(String.valueOf(parame)));
    if (this.Ket != null)
    {
      TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
      localTPImageGeneratorParams.width = parame.width;
      localTPImageGeneratorParams.height = parame.height;
      localTPImageGeneratorParams.format = parame.format;
      localTPImageGeneratorParams.requestedTimeMsToleranceAfter = parame.requestedTimeMsToleranceAfter;
      localTPImageGeneratorParams.requestedTimeMsToleranceBefore = parame.requestedTimeMsToleranceBefore;
      this.Ket.a(getCurrentPositionMs(), localTPImageGeneratorParams, paramd);
    }
    AppMethodBeat.o(187801);
  }
  
  public final void aG(int paramInt, long paramLong)
  {
    AppMethodBeat.i(187773);
    com.tencent.thumbplayer.utils.f.i(TAG, "selectTrack");
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.w(TAG, "player has released, return");
      AppMethodBeat.o(187773);
      return;
    }
    this.Kep.selectTrackAsync(paramInt, paramLong);
    AppMethodBeat.o(187773);
  }
  
  public final void aH(int paramInt, long paramLong)
  {
    AppMethodBeat.i(187774);
    com.tencent.thumbplayer.utils.f.i(TAG, "selectTrack");
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.w(TAG, "player has released, return");
      AppMethodBeat.o(187774);
      return;
    }
    this.Kep.deselectTrackAsync(paramInt, paramLong);
    AppMethodBeat.o(187774);
  }
  
  public final void aI(int paramInt, long paramLong)
  {
    AppMethodBeat.i(187799);
    com.tencent.thumbplayer.utils.f.i(TAG, "selectProgram");
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.w(TAG, "player has released, return");
      AppMethodBeat.o(187799);
      return;
    }
    this.Kep.selectProgramAsync(paramInt, paramLong);
    AppMethodBeat.o(187799);
  }
  
  public final void b(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(187769);
    com.tencent.thumbplayer.utils.f.i(TAG, "setDataSource: ".concat(String.valueOf(paramParcelFileDescriptor)));
    fFa();
    if (this.Kep.setDataSource(paramParcelFileDescriptor.getFd()) != 0)
    {
      paramParcelFileDescriptor = new IllegalStateException("setDataSource url pfd failed!!");
      AppMethodBeat.o(187769);
      throw paramParcelFileDescriptor;
    }
    this.Ket = new com.tencent.thumbplayer.c.c(paramParcelFileDescriptor.getFd());
    AppMethodBeat.o(187769);
  }
  
  public final void b(com.tencent.thumbplayer.b.f paramf)
  {
    boolean bool = true;
    AppMethodBeat.i(187763);
    com.tencent.thumbplayer.utils.f.i(TAG, "setPlayerOptionalParam:".concat(String.valueOf(paramf)));
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.w(TAG, "player has released, return");
      AppMethodBeat.o(187763);
      return;
    }
    int i;
    c.a locala;
    Object localObject;
    if (paramf.KeQ == 1)
    {
      if (paramf.key < 500)
      {
        i = paramf.key;
        paramf = paramf.KeR;
        locala = c.aeC(i);
        if (locala == null)
        {
          com.tencent.thumbplayer.utils.f.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(187763);
          return;
        }
        switch (locala.KeI)
        {
        default: 
          com.tencent.thumbplayer.utils.f.e(TAG, "optionID type:" + locala.KeI + " is not implement");
          AppMethodBeat.o(187763);
          return;
        }
        this.Keq.setBool(locala.KeJ, paramf.value);
        AppMethodBeat.o(187763);
        return;
      }
      i = paramf.key;
      paramf = paramf.KeR;
      locala = c.aeC(i);
      if (locala == null)
      {
        com.tencent.thumbplayer.utils.f.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(i)));
        AppMethodBeat.o(187763);
        return;
      }
      switch (locala.KeI)
      {
      default: 
        com.tencent.thumbplayer.utils.f.e(TAG, "optionID type:" + locala.KeI + " is not implement");
        AppMethodBeat.o(187763);
        return;
      }
      localObject = this.Kep;
      i = locala.KeJ;
      if (paramf.value) {}
      for (long l = 1L;; l = 0L)
      {
        ((TPNativePlayer)localObject).setOptionLong(i, l, 0L);
        AppMethodBeat.o(187763);
        return;
      }
    }
    if (paramf.KeQ == 2)
    {
      if (paramf.key < 500)
      {
        i = paramf.key;
        paramf = paramf.KeS;
        locala = c.aeC(i);
        if (locala == null)
        {
          com.tencent.thumbplayer.utils.f.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(187763);
          return;
        }
        switch (locala.KeI)
        {
        case 2: 
        default: 
          com.tencent.thumbplayer.utils.f.e(TAG, "optionID type:" + locala.KeI + " is not implement");
          AppMethodBeat.o(187763);
          return;
        case 1: 
          this.Keq.setLong(locala.KeJ, paramf.value);
          AppMethodBeat.o(187763);
          return;
        case 4: 
          this.Keq.setInt(locala.KeJ, (int)paramf.value);
          AppMethodBeat.o(187763);
          return;
        }
        localObject = this.Keq;
        i = locala.KeJ;
        if (paramf.value > 0L) {}
        for (;;)
        {
          ((TPNativePlayerInitConfig)localObject).setBool(i, bool);
          AppMethodBeat.o(187763);
          return;
          bool = false;
        }
      }
      i = paramf.key;
      paramf = paramf.KeS;
      locala = c.aeC(i);
      if (locala == null)
      {
        com.tencent.thumbplayer.utils.f.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(i)));
        AppMethodBeat.o(187763);
        return;
      }
      switch (locala.KeI)
      {
      case 2: 
      default: 
        com.tencent.thumbplayer.utils.f.e(TAG, "optionID type:" + locala.KeI + " is not implement");
        AppMethodBeat.o(187763);
        return;
      case 1: 
        this.Kep.setOptionLong(locala.KeJ, paramf.value, paramf.KeW);
        AppMethodBeat.o(187763);
        return;
      case 4: 
        this.Kep.setOptionLong(locala.KeJ, paramf.value, paramf.KeW);
        AppMethodBeat.o(187763);
        return;
      }
      this.Kep.setOptionLong(locala.KeJ, paramf.value, paramf.KeW);
      AppMethodBeat.o(187763);
      return;
    }
    if (paramf.KeQ == 3)
    {
      if (paramf.key < 500)
      {
        com.tencent.thumbplayer.utils.f.e(TAG, "init string param type is not implement coz native init config no string setting");
        AppMethodBeat.o(187763);
        return;
      }
      i = paramf.key;
      paramf = paramf.KeT;
      locala = c.aeC(i);
      if (locala == null)
      {
        com.tencent.thumbplayer.utils.f.e(TAG, "player optionaIdMapping is invalid, not found in array, id: ".concat(String.valueOf(i)));
        AppMethodBeat.o(187763);
        return;
      }
      switch (locala.KeI)
      {
      default: 
        com.tencent.thumbplayer.utils.f.e(TAG, "optionID type:" + locala.KeI + " is not implement");
        AppMethodBeat.o(187763);
        return;
      }
      this.Kep.setOptionObject(locala.KeJ, paramf.value);
      AppMethodBeat.o(187763);
      return;
    }
    if (paramf.KeQ == 4)
    {
      if (paramf.key < 500)
      {
        a(paramf.key, paramf.KeU);
        AppMethodBeat.o(187763);
      }
    }
    else if (paramf.KeQ == 5)
    {
      if (paramf.key < 500)
      {
        a(paramf.key, paramf.KeV);
        AppMethodBeat.o(187763);
      }
    }
    else
    {
      com.tencent.thumbplayer.utils.f.w(TAG, "optionalParam param type is unknow, return");
      AppMethodBeat.o(187763);
      return;
    }
    AppMethodBeat.o(187763);
  }
  
  public final void bb(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(187771);
    com.tencent.thumbplayer.utils.f.i(TAG, "addSubtitleSource");
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.w(TAG, "player has released, return");
      AppMethodBeat.o(187771);
      return;
    }
    this.Kep.addSubtitleTrackSource(paramString1, paramString3);
    AppMethodBeat.o(187771);
  }
  
  public final void c(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(187790);
    com.tencent.thumbplayer.utils.f.i(TAG, "setLoopback:" + paramBoolean + " loopStartPositionMs:" + paramLong1 + " loopEndPositionMs:" + paramLong2);
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.w(TAG, "player has released, return");
      AppMethodBeat.o(187790);
      return;
    }
    if (this.Kep.setLoopback(paramBoolean, paramLong1, paramLong2) != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("set loopback failed!!");
      AppMethodBeat.o(187790);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(187790);
  }
  
  public final void cd(float paramFloat)
  {
    AppMethodBeat.i(187787);
    com.tencent.thumbplayer.utils.f.i(TAG, "setAudioGainRatio:".concat(String.valueOf(paramFloat)));
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.w(TAG, "player has released, return");
      AppMethodBeat.o(187787);
      return;
    }
    this.Kep.setAudioVolume(paramFloat);
    AppMethodBeat.o(187787);
  }
  
  public final void ce(float paramFloat)
  {
    AppMethodBeat.i(187788);
    com.tencent.thumbplayer.utils.f.i(TAG, "setPlaySpeedRatio:".concat(String.valueOf(paramFloat)));
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.w(TAG, "player has released, return");
      AppMethodBeat.o(187788);
      return;
    }
    this.Kep.setPlaybackRate(paramFloat);
    AppMethodBeat.o(187788);
  }
  
  public final n[] fEO()
  {
    AppMethodBeat.i(187798);
    com.tencent.thumbplayer.utils.f.i(TAG, "getTrackInfo");
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.i(TAG, "player has released, return 0");
      AppMethodBeat.o(187798);
      return null;
    }
    TPMediaTrackInfo[] arrayOfTPMediaTrackInfo = this.Kep.getTrackInfo();
    if ((arrayOfTPMediaTrackInfo == null) || (arrayOfTPMediaTrackInfo.length <= 0))
    {
      AppMethodBeat.o(187798);
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
    AppMethodBeat.o(187798);
    return arrayOfn;
  }
  
  public final k[] fEP()
  {
    AppMethodBeat.i(187800);
    com.tencent.thumbplayer.utils.f.i(TAG, "getProgramInfo");
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.i(TAG, "player has released, return 0");
      AppMethodBeat.o(187800);
      return null;
    }
    TPNativePlayerProgramInfo[] arrayOfTPNativePlayerProgramInfo = this.Kep.getProgramInfo();
    if ((arrayOfTPNativePlayerProgramInfo == null) || (arrayOfTPNativePlayerProgramInfo.length <= 0))
    {
      AppMethodBeat.o(187800);
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
    AppMethodBeat.o(187800);
    return arrayOfk;
  }
  
  public final void g(String paramString1, String paramString2, List<com.tencent.thumbplayer.b.f> paramList)
  {
    AppMethodBeat.i(187772);
    com.tencent.thumbplayer.utils.f.i(TAG, "addAudioTrackSource");
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.w(TAG, "player has released, return");
      AppMethodBeat.o(187772);
      return;
    }
    paramList = new i.a();
    paramList.Kfc = paramString1;
    paramString1 = this.Kes;
    if (paramString1 != null) {
      paramString1.a(1012, 0L, 0L, paramList);
    }
    this.Kep.addAudioTrackSource(paramList.kQY, paramString2);
    AppMethodBeat.o(187772);
  }
  
  public final long getBufferedDurationMs()
  {
    AppMethodBeat.i(187795);
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.i(TAG, "player has released, return 0");
      AppMethodBeat.o(187795);
      return 0L;
    }
    long l = this.Kep.getBufferedDurationMs();
    AppMethodBeat.o(187795);
    return l;
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(187794);
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.i(TAG, "player has released, return 0");
      AppMethodBeat.o(187794);
      return 0L;
    }
    long l = this.Kep.getCurrentPositionMs();
    AppMethodBeat.o(187794);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(187793);
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.i(TAG, "player has released, return 0");
      AppMethodBeat.o(187793);
      return 0L;
    }
    long l = this.Kep.getDurationMs();
    AppMethodBeat.o(187793);
    return l;
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(187791);
    com.tencent.thumbplayer.utils.f.i(TAG, "getPropertyLong:".concat(String.valueOf(paramInt)));
    fFa();
    paramInt = c.aeE(paramInt);
    if (paramInt < 0)
    {
      com.tencent.thumbplayer.utils.f.w(TAG, "paramId not found, return -1");
      AppMethodBeat.o(187791);
      return -1L;
    }
    long l = this.Kep.getPropertyLong(paramInt);
    AppMethodBeat.o(187791);
    return l;
  }
  
  public final String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(187792);
    com.tencent.thumbplayer.utils.f.i(TAG, "getPropertyString:".concat(String.valueOf(paramInt)));
    fFa();
    paramInt = c.aeE(paramInt);
    if (paramInt < 0)
    {
      com.tencent.thumbplayer.utils.f.w(TAG, "paramId not found, return");
      AppMethodBeat.o(187792);
      return "";
    }
    String str = this.Kep.getPropertyString(paramInt);
    AppMethodBeat.o(187792);
    return str;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(187797);
    com.tencent.thumbplayer.utils.f.i(TAG, "getVideoHeight");
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.i(TAG, "player has released, return 0");
      AppMethodBeat.o(187797);
      return 0;
    }
    int i = this.Kep.getVideoHeight();
    AppMethodBeat.o(187797);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(187796);
    com.tencent.thumbplayer.utils.f.i(TAG, "getVideoWidth");
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.i(TAG, "player has released, return 0");
      AppMethodBeat.o(187796);
      return 0;
    }
    int i = this.Kep.getVideoWidth();
    AppMethodBeat.o(187796);
    return i;
  }
  
  public final void kD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187783);
    com.tencent.thumbplayer.utils.f.i(TAG, "seekTo:" + paramInt1 + " mode:" + paramInt2);
    fFa();
    paramInt2 = c.aeB(paramInt2);
    if (this.Kep.seekToAsync(paramInt1, paramInt2, 0L) != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("seek to position:" + paramInt1 + " failed!!");
      AppMethodBeat.o(187783);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(187783);
  }
  
  public final void p(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(187784);
    com.tencent.thumbplayer.utils.f.i(TAG, "switchDefinition url:" + paramString + " opaque:" + paramLong);
    fFa();
    paramInt = c.aeH(paramInt);
    if (this.Kep.switchDefinitionAsync(paramString, paramInt, paramLong) != 0)
    {
      paramString = new IllegalStateException("switchDefinition in invalid state");
      AppMethodBeat.o(187784);
      throw paramString;
    }
    this.Ket = new com.tencent.thumbplayer.c.c(paramString);
    AppMethodBeat.o(187784);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(187778);
    com.tencent.thumbplayer.utils.f.i(TAG, "pause");
    fFa();
    if (this.Kep.pause() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("pause failed!!");
      AppMethodBeat.o(187778);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(187778);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(187775);
    com.tencent.thumbplayer.utils.f.i(TAG, "prepare");
    fFa();
    this.Kep.setInitConfig(this.Keq);
    if (this.Kep.prepare() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("prepare failed!!");
      AppMethodBeat.o(187775);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(187775);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(187776);
    com.tencent.thumbplayer.utils.f.i(TAG, "prepareAsync");
    fFa();
    this.Kep.setInitConfig(this.Keq);
    if (this.Kep.prepareAsync() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("prepareAsync failed!!");
      AppMethodBeat.o(187776);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(187776);
  }
  
  public final void release()
  {
    AppMethodBeat.i(187781);
    com.tencent.thumbplayer.utils.f.i(TAG, "release");
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.w(TAG, "player has released, return");
      AppMethodBeat.o(187781);
      return;
    }
    this.Kep.release();
    this.Kep = null;
    this.Ket.release();
    AppMethodBeat.o(187781);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(187780);
    com.tencent.thumbplayer.utils.f.i(TAG, "reset");
    fFa();
    com.tencent.thumbplayer.utils.f.i(TAG, "reset before");
    this.Kep.reset();
    com.tencent.thumbplayer.utils.f.i(TAG, "reset after");
    AppMethodBeat.o(187780);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(187782);
    com.tencent.thumbplayer.utils.f.i(TAG, "seekTo:".concat(String.valueOf(paramInt)));
    fFa();
    if (this.Kep.seekToAsync(paramInt, 1, 0L) != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("seek to position:" + paramInt + " failed!!");
      AppMethodBeat.o(187782);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(187782);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(187767);
    com.tencent.thumbplayer.utils.f.i(TAG, "setDataSource: ".concat(String.valueOf(paramString)));
    fFa();
    if (this.Kep.setDataSource(paramString) != 0)
    {
      paramString = new IllegalStateException("setDataSource url failed!!");
      AppMethodBeat.o(187767);
      throw paramString;
    }
    this.Ket = new com.tencent.thumbplayer.c.c(paramString);
    AppMethodBeat.o(187767);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(187768);
    com.tencent.thumbplayer.utils.f.i(TAG, "setDataSource: ".concat(String.valueOf(paramString)));
    fFa();
    if (this.Kep.setDataSource(paramString) != 0)
    {
      paramString = new IllegalStateException("setDataSource url and header failed!!");
      AppMethodBeat.o(187768);
      throw paramString;
    }
    this.Ket = new com.tencent.thumbplayer.c.c(paramString);
    AppMethodBeat.o(187768);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(187766);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("setSurface， surface is null ? : ");
    if (paramSurface == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.thumbplayer.utils.f.i(str, bool);
      if (this.Kep != null) {
        break;
      }
      com.tencent.thumbplayer.utils.f.w(TAG, "player has released, return");
      AppMethodBeat.o(187766);
      return;
    }
    if (this.Kep.setVideoSurface(paramSurface) != 0)
    {
      paramSurface = new IllegalStateException("setSurface failed!!");
      AppMethodBeat.o(187766);
      throw paramSurface;
    }
    AppMethodBeat.o(187766);
  }
  
  public final void start()
  {
    AppMethodBeat.i(187777);
    com.tencent.thumbplayer.utils.f.i(TAG, "start");
    fFa();
    if (this.Kep.start() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("start failed!!");
      AppMethodBeat.o(187777);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(187777);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(187779);
    com.tencent.thumbplayer.utils.f.i(TAG, "stop");
    fFa();
    com.tencent.thumbplayer.utils.f.i(TAG, "stop before");
    int i = this.Kep.stop();
    com.tencent.thumbplayer.utils.f.i(TAG, "stop after");
    if (i != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("stop failed!!");
      AppMethodBeat.o(187779);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(187779);
  }
  
  public final void yI(boolean paramBoolean)
  {
    AppMethodBeat.i(187789);
    com.tencent.thumbplayer.utils.f.i(TAG, "setLoopback:".concat(String.valueOf(paramBoolean)));
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.w(TAG, "player has released, return");
      AppMethodBeat.o(187789);
      return;
    }
    this.Kep.setLoopback(paramBoolean, 0L, -1L);
    AppMethodBeat.o(187789);
  }
  
  public final void yJ(boolean paramBoolean)
  {
    AppMethodBeat.i(187786);
    com.tencent.thumbplayer.utils.f.i(TAG, "setOutputMute:".concat(String.valueOf(paramBoolean)));
    if (this.Kep == null)
    {
      com.tencent.thumbplayer.utils.f.w(TAG, "player has released, return");
      AppMethodBeat.o(187786);
      return;
    }
    this.Kep.setAudioMute(paramBoolean);
    AppMethodBeat.o(187786);
  }
  
  final class a
    extends Handler
  {
    private WeakReference<b> npK;
    
    public a(Looper paramLooper, b paramb)
    {
      super();
      AppMethodBeat.i(187760);
      this.npK = new WeakReference(paramb);
      AppMethodBeat.o(187760);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(187761);
      if ((b)this.npK.get() == null)
      {
        com.tencent.thumbplayer.utils.f.e(b.TAG, "mWeakRef is null");
        AppMethodBeat.o(187761);
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        com.tencent.thumbplayer.utils.f.w(b.TAG, "message :" + paramMessage.what + "  not recognition");
        AppMethodBeat.o(187761);
        return;
      case 1: 
        paramMessage = (b.b)paramMessage.obj;
        switch (paramMessage.Kez)
        {
        default: 
          b.a(b.this, paramMessage);
          AppMethodBeat.o(187761);
          return;
        case 1: 
          b.c(b.this);
          AppMethodBeat.o(187761);
          return;
        }
        b.d(b.this);
        AppMethodBeat.o(187761);
        return;
      case 2: 
        paramMessage = (b.d)paramMessage.obj;
        switch (paramMessage.infoType)
        {
        default: 
          b.a(b.this, paramMessage.infoType, paramMessage);
          AppMethodBeat.o(187761);
          return;
        case 250: 
          b.a(b.this, paramMessage.lParam1, paramMessage.KeA);
          AppMethodBeat.o(187761);
          return;
        }
        b.e(b.this);
        AppMethodBeat.o(187761);
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
          AppMethodBeat.o(187761);
          return;
        } while (!(paramMessage.KeB instanceof String));
        b.f(b.this).Kfp = ((String)paramMessage.KeB);
        b.b(b.this).a(b.f(b.this));
        AppMethodBeat.o(187761);
        return;
      }
      paramMessage = (b.c)paramMessage.obj;
      int i = paramMessage.msgType;
      int j = paramMessage.errorCode;
      b.b(b.this).a(c.aeG(i), j, 0L, 0L);
      AppMethodBeat.o(187761);
    }
  }
  
  public static final class b
  {
    long KcB;
    int Kez;
    int dcp;
    int errorCode;
  }
  
  public static final class c
  {
    int errorCode;
    int msgType;
  }
  
  public static final class d
  {
    long KeA;
    int infoType;
    long lParam1;
  }
  
  public static final class e
  {
    Object KeB;
    int infoType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */