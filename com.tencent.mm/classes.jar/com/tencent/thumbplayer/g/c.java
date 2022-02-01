package com.tencent.thumbplayer.g;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.ITPSurface;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPCDNURLInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPProtocolInfo;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.utils.g;
import com.tencent.thumbplayer.utils.i;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public final class c
  implements ITPPlayListener
{
  private long RZU;
  f.m SaK;
  f.k SaL;
  f.g SaM;
  long SaN;
  String SaO;
  private Object SaP;
  private Object SaQ;
  private Object SaR;
  private int SaS;
  private int SaT;
  private int SaU;
  private String SaV;
  int SaW;
  int SaX;
  private b SaY;
  private c.a SaZ;
  private i Sba;
  private String mContentType;
  private Looper mLooper;
  
  c(Looper paramLooper, b paramb)
  {
    AppMethodBeat.i(189442);
    this.mLooper = paramLooper;
    this.SaZ = new c.a(this, paramLooper);
    this.SaY = paramb;
    this.Sba = new i();
    this.SaK = new f.m();
    this.SaL = new f.k();
    this.SaM = new f.g();
    AppMethodBeat.o(189442);
  }
  
  private void DZ(boolean paramBoolean)
  {
    AppMethodBeat.i(189478);
    if (paramBoolean) {
      this.Sba.writeLock().lock();
    }
    if (paramBoolean) {
      this.Sba.Sfu.signalAll();
    }
    if (paramBoolean) {
      this.Sba.writeLock().unlock();
    }
    AppMethodBeat.o(189478);
  }
  
  private void Q(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(189483);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      DZ(paramBoolean);
      AppMethodBeat.o(189483);
      return;
      this.SaK.width = this.SaY.hnS();
      continue;
      this.SaK.height = this.SaY.hnT();
      continue;
      this.SaL.SbM = this.SaY.hnV();
      continue;
      this.SaN = this.SaY.ary(paramInt2);
      continue;
      this.SaO = this.SaY.arz(paramInt2);
      continue;
      this.SaM.SbG = this.SaY.hnW();
      continue;
      this.SaX = this.SaY.hnU();
      continue;
      this.SaW = this.SaY.hnP();
    }
  }
  
  private void a(Message paramMessage, boolean paramBoolean)
  {
    AppMethodBeat.i(189482);
    if ((paramMessage.what != 83) && (paramMessage.what != 73) && (paramMessage.what != 74) && (paramMessage.what != 43) && (paramMessage.what != 86)) {
      g.i("TPThumbPlayer[TPPlayerInternal.java]", "internalMessage " + arB(paramMessage.what));
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(189482);
      return;
      this.SaY.b((TPOptionalParam)paramMessage.obj);
      AppMethodBeat.o(189482);
      return;
      this.SaY.l((Surface)paramMessage.obj);
      AppMethodBeat.o(189482);
      return;
      this.SaY.c((SurfaceHolder)paramMessage.obj);
      AppMethodBeat.o(189482);
      return;
      this.SaY.a((ITPSurface)paramMessage.obj);
      AppMethodBeat.o(189482);
      return;
      this.SaY.a((f.b)paramMessage.obj);
      AppMethodBeat.o(189482);
      return;
      this.SaY.b((TPVideoInfo)paramMessage.obj);
      AppMethodBeat.o(189482);
      return;
      this.SaY.a(((f.l)paramMessage.obj).SbN, ((f.l)paramMessage.obj).SbO);
      AppMethodBeat.o(189482);
      return;
      paramMessage = (f.h)paramMessage.obj;
      if (paramMessage != null)
      {
        this.SaY.a(paramMessage.url, paramMessage.mimeType, paramMessage.name, paramMessage.SbH);
        AppMethodBeat.o(189482);
        return;
        paramMessage = (f.a)paramMessage.obj;
        if (paramMessage != null)
        {
          this.SaY.a(paramMessage.url, paramMessage.name, paramMessage.Sbv);
          AppMethodBeat.o(189482);
          return;
          this.SaY.aY(paramMessage.arg1, paramMessage.arg2);
          AppMethodBeat.o(189482);
          return;
          this.SaY.aZ(paramMessage.arg1, paramMessage.arg2);
          AppMethodBeat.o(189482);
          return;
          this.SaY.hnH();
          AppMethodBeat.o(189482);
          return;
          this.SaY.hnI();
          AppMethodBeat.o(189482);
          return;
          this.SaY.asf();
          AppMethodBeat.o(189482);
          return;
          this.SaY.hnF();
          AppMethodBeat.o(189482);
          return;
          this.SaY.hnG();
          AppMethodBeat.o(189482);
          return;
          this.SaY.hnJ();
          DZ(paramBoolean);
          AppMethodBeat.o(189482);
          return;
          this.SaY.hnK();
          AppMethodBeat.o(189482);
          return;
          this.SaY.hnL();
          DZ(paramBoolean);
          AppMethodBeat.o(189482);
          return;
          this.SaY.hnM();
          DZ(paramBoolean);
          this.SaZ.removeCallbacksAndMessages(null);
          AppMethodBeat.o(189482);
          return;
          this.SaY.mz(paramMessage.arg1, paramMessage.arg2);
          AppMethodBeat.o(189482);
          return;
          this.SaY.DX(((Boolean)paramMessage.obj).booleanValue());
          AppMethodBeat.o(189482);
          return;
          this.SaY.cN(((Float)paramMessage.obj).floatValue());
          AppMethodBeat.o(189482);
          return;
          this.SaY.bqD((String)paramMessage.obj);
          AppMethodBeat.o(189482);
          return;
          this.SaY.cO(((Float)paramMessage.obj).floatValue());
          AppMethodBeat.o(189482);
          return;
          paramMessage = (f.c)paramMessage.obj;
          if (paramMessage != null)
          {
            this.SaY.d(paramMessage.RVI, paramMessage.Sbz, paramMessage.SbA);
            AppMethodBeat.o(189482);
            return;
            this.SaY.DY(((Boolean)paramMessage.obj).booleanValue());
            AppMethodBeat.o(189482);
            return;
            paramMessage = (f.j)paramMessage.obj;
            if (paramMessage != null)
            {
              if (!TextUtils.isEmpty(paramMessage.url))
              {
                this.SaY.a(paramMessage.url, paramMessage.SbK, paramMessage.SbL, paramMessage.mode);
                AppMethodBeat.o(189482);
                return;
              }
              this.SaY.a(paramMessage.Sby, paramMessage.SbK, paramMessage.SbL, paramMessage.mode);
              AppMethodBeat.o(189482);
              return;
              this.SaY.ba(paramMessage.arg1, paramMessage.arg2);
              AppMethodBeat.o(189482);
              return;
              Q(paramMessage.what, paramMessage.arg1, paramBoolean);
              AppMethodBeat.o(189482);
              return;
              this.SaY.hnX();
              AppMethodBeat.o(189482);
              return;
              this.SaY.V(paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
              AppMethodBeat.o(189482);
              return;
              this.SaY.bqE((String)paramMessage.obj);
              AppMethodBeat.o(189482);
              return;
              paramMessage = (TPPlayerMsg.TPCDNURLInfo)paramMessage.obj;
              this.SaY.bu(paramMessage.url, paramMessage.cdnIp, paramMessage.uIp);
              AppMethodBeat.o(189482);
              return;
              this.SaY.arA(paramMessage.arg1);
              AppMethodBeat.o(189482);
              return;
              paramMessage = (TPPlayerMsg.TPProtocolInfo)paramMessage.obj;
              this.SaY.nO(paramMessage.protocolName, paramMessage.protocolVersion);
              AppMethodBeat.o(189482);
              return;
              this.SaY.co((Map)paramMessage.obj);
              AppMethodBeat.o(189482);
              return;
              paramMessage = (f.d)paramMessage.obj;
              this.SaP = this.SaY.a(paramMessage.bca, paramMessage.SbB, paramMessage.SbD);
              DZ(paramBoolean);
              AppMethodBeat.o(189482);
              return;
              ((Long)paramMessage.obj).longValue();
              this.SaQ = null;
              DZ(paramBoolean);
              AppMethodBeat.o(189482);
              return;
              paramMessage = (TPPlayerMsg.TPDownLoadProgressInfo)paramMessage.obj;
              this.SaY.a((int)paramMessage.playableDurationMS, paramMessage.downloadSpeedKBps, paramMessage.currentDownloadSize, paramMessage.totalFileSize, paramMessage.extraInfo);
              AppMethodBeat.o(189482);
              return;
              paramMessage = paramMessage.obj;
              this.SaR = null;
              DZ(paramBoolean);
              AppMethodBeat.o(189482);
              return;
              paramMessage = (f.f)paramMessage.obj;
              this.SaS = this.SaY.b(paramMessage.SbF, paramMessage.fileKey, paramMessage.requestStart, paramMessage.requestEnd);
              DZ(paramBoolean);
              AppMethodBeat.o(189482);
              return;
              paramMessage = (f.e)paramMessage.obj;
              this.SaT = this.SaY.t(paramMessage.SbF, paramMessage.offset, paramMessage.length);
              DZ(paramBoolean);
              AppMethodBeat.o(189482);
              return;
              this.SaU = this.SaY.A(paramMessage.arg1, (String)paramMessage.obj, paramMessage.arg2);
              DZ(paramBoolean);
              AppMethodBeat.o(189482);
              return;
              this.RZU = this.SaY.dw(paramMessage.arg1, (String)paramMessage.obj);
              DZ(paramBoolean);
              AppMethodBeat.o(189482);
              return;
              b localb = this.SaY;
              int i = paramMessage.arg1;
              paramMessage = paramMessage.obj;
              this.SaV = localb.arx(i);
              DZ(paramBoolean);
              AppMethodBeat.o(189482);
              return;
              this.mContentType = this.SaY.dx(paramMessage.arg1, (String)paramMessage.obj);
              DZ(paramBoolean);
            }
          }
        }
      }
    }
  }
  
  private static String arB(int paramInt)
  {
    AppMethodBeat.i(189479);
    switch (paramInt)
    {
    case 2: 
    case 3: 
    case 9: 
    case 24: 
    case 25: 
    case 26: 
    case 34: 
    case 40: 
    case 44: 
    case 45: 
    case 46: 
    case 47: 
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 67: 
    case 68: 
    case 69: 
    case 70: 
    case 71: 
    case 72: 
    case 74: 
    case 75: 
    case 76: 
    case 77: 
    case 78: 
    case 79: 
    case 80: 
    case 81: 
    case 82: 
    case 83: 
    case 84: 
    default: 
      String str = "[tpPlayer] -> ".concat(String.valueOf(paramInt));
      AppMethodBeat.o(189479);
      return str;
    case 1: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> set player params";
    case 4: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> set surface";
    case 39: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> set surfaceHolder";
    case 5: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> set data source";
    case 6: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> set subtitle source";
    case 7: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> add audio source";
    case 8: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> add select track";
    case 36: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> deselect track";
    case 10: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> prepare async";
    case 11: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> start";
    case 12: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> pause";
    case 41: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> pauseDownload";
    case 42: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> resumeDownload";
    case 13: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> stop";
    case 14: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> reset";
    case 15: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> release";
    case 16: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> seek to";
    case 17: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> set output mute";
    case 18: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> set audio gain ratio";
    case 38: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> set audio normalize volume params";
    case 19: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> set speed ratio";
    case 35: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> set loopback";
    case 21: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> get video width";
    case 22: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> get video height";
    case 23: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> get track info";
    case 27: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> get property long";
    case 28: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> get property string";
    case 43: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> get current player state";
    case 29: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> set video info";
    case 30: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> capture video";
    case 31: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> switch def";
    case 32: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> select program";
    case 33: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> get program";
    case 20: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> set loopback with param";
    case 73: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> cdn info update";
    case 37: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> stopAsync";
    case 85: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> start read data";
    case 86: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> read data";
    case 87: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> stop read data";
    case 88: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> get data total size";
    case 89: 
      AppMethodBeat.o(189479);
      return "[tpPlayer] -> get data file path";
    }
    AppMethodBeat.o(189479);
    return "[tpPlayer] -> get content type";
  }
  
  private boolean hoe()
  {
    AppMethodBeat.i(189473);
    if (Looper.myLooper() == this.mLooper)
    {
      AppMethodBeat.o(189473);
      return true;
    }
    AppMethodBeat.o(189473);
    return false;
  }
  
  private void hof()
  {
    AppMethodBeat.i(189474);
    if (!hoe()) {
      this.Sba.readLock().unlock();
    }
    AppMethodBeat.o(189474);
  }
  
  private void hog()
  {
    AppMethodBeat.i(189475);
    if (!hoe()) {
      this.Sba.readLock().lock();
    }
    AppMethodBeat.o(189475);
  }
  
  private void hok()
  {
    AppMethodBeat.i(189481);
    this.Sba.OG(500L);
    AppMethodBeat.o(189481);
  }
  
  final void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(189472);
    hog();
    if (this.SaZ == null)
    {
      g.i("TPThumbPlayer[TPPlayerInternal.java]", arB(paramInt1) + " , send failed , handler null");
      hof();
      AppMethodBeat.o(189472);
      return;
    }
    if ((paramBoolean1) && (paramObject == null))
    {
      g.i("TPThumbPlayer[TPPlayerInternal.java]", arB(paramInt1) + ", send failed , params null");
      hof();
      AppMethodBeat.o(189472);
      return;
    }
    if (paramBoolean2) {
      this.SaZ.removeMessages(paramInt1);
    }
    Message localMessage = this.SaZ.obtainMessage();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    if (hoe()) {
      a(localMessage, false);
    }
    for (;;)
    {
      hof();
      AppMethodBeat.o(189472);
      return;
      this.SaZ.sendMessageDelayed(localMessage, 0L);
    }
  }
  
  final void addAudioTrackSource(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(189444);
    f.a locala = new f.a();
    locala.url = paramString1;
    locala.name = paramString2;
    locala.Sbv = paramTPDownloadParamData;
    a(7, 0, 0, locala, true, false);
    AppMethodBeat.o(189444);
  }
  
  final void addSubtitleSource(String paramString1, String paramString2, String paramString3, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(189443);
    f.h localh = new f.h();
    localh.url = paramString1;
    localh.mimeType = paramString2;
    localh.name = paramString3;
    localh.SbH = paramTPDownloadParamData;
    a(6, 0, 0, localh, true, false);
    AppMethodBeat.o(189443);
  }
  
  public final long getAdvRemainTime()
  {
    AppMethodBeat.i(189463);
    try
    {
      long l = this.SaY.hoa();
      AppMethodBeat.o(189463);
      return l;
    }
    catch (Throwable localThrowable)
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(189463);
    }
    return 0L;
  }
  
  final int getBufferPercent()
  {
    AppMethodBeat.i(189449);
    try
    {
      int i = this.SaY.hnQ();
      AppMethodBeat.o(189449);
      return i;
    }
    catch (Throwable localThrowable)
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(189449);
    }
    return 0;
  }
  
  public final String getContentType(int paramInt, String paramString)
  {
    AppMethodBeat.i(189471);
    paramString = this.SaY.dx(paramInt, paramString);
    AppMethodBeat.o(189471);
    return paramString;
  }
  
  public final int getCurrentPlayClipNo()
  {
    AppMethodBeat.i(189462);
    try
    {
      int i = this.SaY.hnZ();
      AppMethodBeat.o(189462);
      return i;
    }
    catch (Throwable localThrowable)
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(189462);
    }
    return 0;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(189461);
    long l = getCurrentPositionMs();
    AppMethodBeat.o(189461);
    return l;
  }
  
  final long getCurrentPositionMs()
  {
    AppMethodBeat.i(189448);
    try
    {
      long l = this.SaY.hnO();
      AppMethodBeat.o(189448);
      return l;
    }
    catch (Throwable localThrowable)
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(189448);
    }
    return 0L;
  }
  
  public final String getDataFilePath(int paramInt, String paramString)
  {
    AppMethodBeat.i(189470);
    paramString = this.SaY.arx(paramInt);
    AppMethodBeat.o(189470);
    return paramString;
  }
  
  public final long getDataTotalSize(int paramInt, String paramString)
  {
    AppMethodBeat.i(189469);
    long l = this.SaY.dw(paramInt, paramString);
    AppMethodBeat.o(189469);
    return l;
  }
  
  final long getDurationMs()
  {
    AppMethodBeat.i(189447);
    try
    {
      long l = this.SaY.hnN();
      AppMethodBeat.o(189447);
      return l;
    }
    catch (Throwable localThrowable)
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(189447);
    }
    return 0L;
  }
  
  public final Object getPlayInfo(long paramLong)
  {
    AppMethodBeat.i(189464);
    hoh();
    a(82, 0, 0, Long.valueOf(paramLong), false, false);
    hoj();
    hoi();
    Object localObject = this.SaQ;
    AppMethodBeat.o(189464);
    return localObject;
  }
  
  public final Object getPlayInfo(String paramString)
  {
    AppMethodBeat.i(189465);
    hoh();
    a(84, 0, 0, paramString, false, false);
    hoj();
    hoi();
    paramString = this.SaR;
    AppMethodBeat.o(189465);
    return paramString;
  }
  
  final long getPlayableDurationMs()
  {
    AppMethodBeat.i(189450);
    try
    {
      long l = this.SaY.hnR();
      AppMethodBeat.o(189450);
      return l;
    }
    catch (Throwable localThrowable)
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(189450);
    }
    return 0L;
  }
  
  public final long getPlayerBufferLength()
  {
    AppMethodBeat.i(189460);
    try
    {
      long l = this.SaY.hnY();
      AppMethodBeat.o(189460);
      return l;
    }
    catch (Throwable localThrowable)
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(189460);
    }
    return 0L;
  }
  
  final void hoh()
  {
    AppMethodBeat.i(189476);
    if (!hoe()) {
      this.Sba.writeLock().lock();
    }
    AppMethodBeat.o(189476);
  }
  
  final void hoi()
  {
    AppMethodBeat.i(189477);
    if (!hoe()) {
      this.Sba.writeLock().unlock();
    }
    AppMethodBeat.o(189477);
  }
  
  final void hoj()
  {
    AppMethodBeat.i(189480);
    if (hoe())
    {
      AppMethodBeat.o(189480);
      return;
    }
    hok();
    AppMethodBeat.o(189480);
  }
  
  public final void onDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    AppMethodBeat.i(189457);
    a(76, 0, 0, paramMap, false, false);
    AppMethodBeat.o(189457);
  }
  
  public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(189456);
    TPPlayerMsg.TPCDNURLInfo localTPCDNURLInfo = new TPPlayerMsg.TPCDNURLInfo();
    localTPCDNURLInfo.url = paramString1;
    localTPCDNURLInfo.cdnIp = paramString2;
    localTPCDNURLInfo.uIp = paramString3;
    localTPCDNURLInfo.errorStr = paramString4;
    a(73, 0, 0, localTPCDNURLInfo, false, false);
    AppMethodBeat.o(189456);
  }
  
  public final void onDownloadCdnUrlUpdate(String paramString)
  {
    AppMethodBeat.i(189455);
    a(72, 0, 0, paramString, false, false);
    AppMethodBeat.o(189455);
  }
  
  public final void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(189453);
    a(71, paramInt1, paramInt2, paramString, false, false);
    AppMethodBeat.o(189453);
  }
  
  public final void onDownloadFinish()
  {
    AppMethodBeat.i(189452);
    a(70, 0, 0, null, false, false);
    AppMethodBeat.o(189452);
  }
  
  public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(189451);
    TPPlayerMsg.TPDownLoadProgressInfo localTPDownLoadProgressInfo = new TPPlayerMsg.TPDownLoadProgressInfo();
    localTPDownLoadProgressInfo.playableDurationMS = paramInt1;
    localTPDownLoadProgressInfo.downloadSpeedKBps = paramInt2;
    localTPDownLoadProgressInfo.currentDownloadSize = paramLong1;
    localTPDownLoadProgressInfo.totalFileSize = paramLong2;
    localTPDownLoadProgressInfo.extraInfo = paramString;
    a(83, 0, 0, localTPDownLoadProgressInfo, false, false);
    AppMethodBeat.o(189451);
  }
  
  public final void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189459);
    TPPlayerMsg.TPProtocolInfo localTPProtocolInfo = new TPPlayerMsg.TPProtocolInfo();
    localTPProtocolInfo.protocolVersion = paramString2;
    localTPProtocolInfo.protocolName = paramString1;
    a(75, 0, 0, localTPProtocolInfo, false, false);
    AppMethodBeat.o(189459);
  }
  
  public final void onDownloadStatusUpdate(int paramInt)
  {
    AppMethodBeat.i(189458);
    a(74, paramInt, 0, null, false, false);
    AppMethodBeat.o(189458);
  }
  
  public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(189454);
    hoh();
    f.d locald = new f.d();
    locald.bca = paramInt;
    locald.SbB = paramObject1;
    locald.SbC = paramObject2;
    locald.SbD = paramObject3;
    locald.SbE = paramObject4;
    a(77, 0, 0, locald, false, false);
    hoj();
    hoi();
    paramObject1 = this.SaP;
    AppMethodBeat.o(189454);
    return paramObject1;
  }
  
  public final int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(189467);
    paramInt = this.SaY.t(paramInt, paramLong1, paramLong2);
    AppMethodBeat.o(189467);
    return paramInt;
  }
  
  public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(189466);
    paramInt = this.SaY.b(paramInt, paramString, paramLong1, paramLong2);
    AppMethodBeat.o(189466);
    return paramInt;
  }
  
  public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(189468);
    paramInt1 = this.SaY.A(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(189468);
    return paramInt1;
  }
  
  final void switchDefinition(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    AppMethodBeat.i(189446);
    f.j localj = new f.j();
    localj.Sby = paramITPMediaAsset;
    localj.SbK = paramLong;
    localj.SbL = paramTPVideoInfo;
    localj.mode = paramInt;
    a(31, 0, 0, localj, true, true);
    AppMethodBeat.o(189446);
  }
  
  final void switchDefinition(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    AppMethodBeat.i(189445);
    f.j localj = new f.j();
    localj.url = paramString;
    localj.SbK = paramLong;
    localj.SbL = paramTPVideoInfo;
    localj.mode = paramInt;
    a(31, 0, 0, localj, true, true);
    AppMethodBeat.o(189445);
  }
  
  public static abstract interface b
  {
    public abstract int A(int paramInt1, String paramString, int paramInt2);
    
    public abstract void DX(boolean paramBoolean);
    
    public abstract void DY(boolean paramBoolean);
    
    public abstract void V(int paramInt1, int paramInt2, String paramString);
    
    public abstract Object a(int paramInt, Object paramObject1, Object paramObject2);
    
    public abstract void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString);
    
    public abstract void a(ITPSurface paramITPSurface);
    
    public abstract void a(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack);
    
    public abstract void a(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt);
    
    public abstract void a(f.b paramb);
    
    public abstract void a(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt);
    
    public abstract void a(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData);
    
    public abstract void a(String paramString1, String paramString2, String paramString3, TPDownloadParamData paramTPDownloadParamData);
    
    public abstract void aY(int paramInt, long paramLong);
    
    public abstract void aZ(int paramInt, long paramLong);
    
    public abstract void arA(int paramInt);
    
    public abstract String arx(int paramInt);
    
    public abstract long ary(int paramInt);
    
    public abstract String arz(int paramInt);
    
    public abstract void asf();
    
    public abstract int b(int paramInt, String paramString, long paramLong1, long paramLong2);
    
    public abstract void b(TPOptionalParam paramTPOptionalParam);
    
    public abstract void b(TPVideoInfo paramTPVideoInfo);
    
    public abstract void ba(int paramInt, long paramLong);
    
    public abstract void bqD(String paramString);
    
    public abstract void bqE(String paramString);
    
    public abstract void bu(String paramString1, String paramString2, String paramString3);
    
    public abstract void c(SurfaceHolder paramSurfaceHolder);
    
    public abstract void cN(float paramFloat);
    
    public abstract void cO(float paramFloat);
    
    public abstract void co(Map<String, String> paramMap);
    
    public abstract void d(boolean paramBoolean, long paramLong1, long paramLong2);
    
    public abstract long dw(int paramInt, String paramString);
    
    public abstract String dx(int paramInt, String paramString);
    
    public abstract void hnF();
    
    public abstract void hnG();
    
    public abstract void hnH();
    
    public abstract void hnI();
    
    public abstract void hnJ();
    
    public abstract void hnK();
    
    public abstract void hnL();
    
    public abstract void hnM();
    
    public abstract long hnN();
    
    public abstract long hnO();
    
    public abstract int hnP();
    
    public abstract int hnQ();
    
    public abstract long hnR();
    
    public abstract int hnS();
    
    public abstract int hnT();
    
    public abstract int hnU();
    
    public abstract TPTrackInfo[] hnV();
    
    public abstract TPProgramInfo[] hnW();
    
    public abstract void hnX();
    
    public abstract long hnY();
    
    public abstract int hnZ();
    
    public abstract long hoa();
    
    public abstract void l(Surface paramSurface);
    
    public abstract void mz(int paramInt1, int paramInt2);
    
    public abstract void nO(String paramString1, String paramString2);
    
    public abstract int t(int paramInt, long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.g.c
 * JD-Core Version:    0.7.0.1
 */