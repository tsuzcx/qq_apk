package com.tencent.thumbplayer.g;

import android.os.Handler;
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
  private long ZCE;
  private Object ZDA;
  private Object ZDB;
  private Object ZDC;
  private int ZDD;
  private int ZDE;
  private int ZDF;
  private String ZDG;
  int ZDH;
  int ZDI;
  private b ZDJ;
  private a ZDK;
  private i ZDL;
  f.m ZDv;
  f.k ZDw;
  f.g ZDx;
  long ZDy;
  String ZDz;
  private String mContentType;
  private Looper mLooper;
  
  c(Looper paramLooper, b paramb)
  {
    AppMethodBeat.i(221341);
    this.mLooper = paramLooper;
    this.ZDK = new a(paramLooper);
    this.ZDJ = paramb;
    this.ZDL = new i();
    this.ZDv = new f.m();
    this.ZDw = new f.k();
    this.ZDx = new f.g();
    AppMethodBeat.o(221341);
  }
  
  private void IA(boolean paramBoolean)
  {
    AppMethodBeat.i(221418);
    if (paramBoolean) {
      this.ZDL.writeLock().lock();
    }
    if (paramBoolean) {
      this.ZDL.ZIf.signalAll();
    }
    if (paramBoolean) {
      this.ZDL.writeLock().unlock();
    }
    AppMethodBeat.o(221418);
  }
  
  private void W(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(221472);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      IA(paramBoolean);
      AppMethodBeat.o(221472);
      return;
      this.ZDv.width = this.ZDJ.irt();
      continue;
      this.ZDv.height = this.ZDJ.iru();
      continue;
      this.ZDw.ZEx = this.ZDJ.irw();
      continue;
      this.ZDy = this.ZDJ.aBl(paramInt2);
      continue;
      this.ZDz = this.ZDJ.aBm(paramInt2);
      continue;
      this.ZDx.ZEr = this.ZDJ.irx();
      continue;
      this.ZDI = this.ZDJ.irv();
      continue;
      this.ZDH = this.ZDJ.irq();
    }
  }
  
  private void a(Message paramMessage, boolean paramBoolean)
  {
    AppMethodBeat.i(221468);
    if ((paramMessage.what != 83) && (paramMessage.what != 73) && (paramMessage.what != 74) && (paramMessage.what != 43) && (paramMessage.what != 86)) {
      g.i("TPThumbPlayer[TPPlayerInternal.java]", "internalMessage " + aBo(paramMessage.what));
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(221468);
      return;
      this.ZDJ.b((TPOptionalParam)paramMessage.obj);
      AppMethodBeat.o(221468);
      return;
      this.ZDJ.p((Surface)paramMessage.obj);
      AppMethodBeat.o(221468);
      return;
      this.ZDJ.f((SurfaceHolder)paramMessage.obj);
      AppMethodBeat.o(221468);
      return;
      this.ZDJ.a((ITPSurface)paramMessage.obj);
      AppMethodBeat.o(221468);
      return;
      this.ZDJ.a((f.b)paramMessage.obj);
      AppMethodBeat.o(221468);
      return;
      this.ZDJ.b((TPVideoInfo)paramMessage.obj);
      AppMethodBeat.o(221468);
      return;
      this.ZDJ.a(((f.l)paramMessage.obj).ZEy, ((f.l)paramMessage.obj).ZEz);
      AppMethodBeat.o(221468);
      return;
      paramMessage = (f.h)paramMessage.obj;
      if (paramMessage != null)
      {
        this.ZDJ.a(paramMessage.url, paramMessage.mimeType, paramMessage.name, paramMessage.ZEs);
        AppMethodBeat.o(221468);
        return;
        paramMessage = (f.a)paramMessage.obj;
        if (paramMessage != null)
        {
          this.ZDJ.a(paramMessage.url, paramMessage.name, paramMessage.ZEg);
          AppMethodBeat.o(221468);
          return;
          this.ZDJ.bj(paramMessage.arg1, paramMessage.arg2);
          AppMethodBeat.o(221468);
          return;
          this.ZDJ.bk(paramMessage.arg1, paramMessage.arg2);
          AppMethodBeat.o(221468);
          return;
          this.ZDJ.iri();
          AppMethodBeat.o(221468);
          return;
          this.ZDJ.irj();
          AppMethodBeat.o(221468);
          return;
          this.ZDJ.ayS();
          AppMethodBeat.o(221468);
          return;
          this.ZDJ.irg();
          AppMethodBeat.o(221468);
          return;
          this.ZDJ.irh();
          AppMethodBeat.o(221468);
          return;
          this.ZDJ.irk();
          IA(paramBoolean);
          AppMethodBeat.o(221468);
          return;
          this.ZDJ.irl();
          AppMethodBeat.o(221468);
          return;
          this.ZDJ.irm();
          IA(paramBoolean);
          AppMethodBeat.o(221468);
          return;
          this.ZDJ.irn();
          IA(paramBoolean);
          this.ZDK.removeCallbacksAndMessages(null);
          AppMethodBeat.o(221468);
          return;
          this.ZDJ.nQ(paramMessage.arg1, paramMessage.arg2);
          AppMethodBeat.o(221468);
          return;
          this.ZDJ.Iy(((Boolean)paramMessage.obj).booleanValue());
          AppMethodBeat.o(221468);
          return;
          this.ZDJ.di(((Float)paramMessage.obj).floatValue());
          AppMethodBeat.o(221468);
          return;
          this.ZDJ.bDA((String)paramMessage.obj);
          AppMethodBeat.o(221468);
          return;
          this.ZDJ.dj(((Float)paramMessage.obj).floatValue());
          AppMethodBeat.o(221468);
          return;
          paramMessage = (f.c)paramMessage.obj;
          if (paramMessage != null)
          {
            this.ZDJ.d(paramMessage.Zys, paramMessage.ZEk, paramMessage.ZEl);
            AppMethodBeat.o(221468);
            return;
            this.ZDJ.Iz(((Boolean)paramMessage.obj).booleanValue());
            AppMethodBeat.o(221468);
            return;
            paramMessage = (f.j)paramMessage.obj;
            if (paramMessage != null)
            {
              if (!TextUtils.isEmpty(paramMessage.url))
              {
                this.ZDJ.a(paramMessage.url, paramMessage.ZEv, paramMessage.ZEw, paramMessage.mode);
                AppMethodBeat.o(221468);
                return;
              }
              this.ZDJ.a(paramMessage.ZEj, paramMessage.ZEv, paramMessage.ZEw, paramMessage.mode);
              AppMethodBeat.o(221468);
              return;
              this.ZDJ.bl(paramMessage.arg1, paramMessage.arg2);
              AppMethodBeat.o(221468);
              return;
              W(paramMessage.what, paramMessage.arg1, paramBoolean);
              AppMethodBeat.o(221468);
              return;
              this.ZDJ.iry();
              AppMethodBeat.o(221468);
              return;
              this.ZDJ.T(paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
              AppMethodBeat.o(221468);
              return;
              this.ZDJ.bDB((String)paramMessage.obj);
              AppMethodBeat.o(221468);
              return;
              paramMessage = (TPPlayerMsg.TPCDNURLInfo)paramMessage.obj;
              this.ZDJ.bs(paramMessage.url, paramMessage.cdnIp, paramMessage.uIp);
              AppMethodBeat.o(221468);
              return;
              this.ZDJ.aBn(paramMessage.arg1);
              AppMethodBeat.o(221468);
              return;
              paramMessage = (TPPlayerMsg.TPProtocolInfo)paramMessage.obj;
              this.ZDJ.oK(paramMessage.protocolName, paramMessage.protocolVersion);
              AppMethodBeat.o(221468);
              return;
              this.ZDJ.cu((Map)paramMessage.obj);
              AppMethodBeat.o(221468);
              return;
              paramMessage = (f.d)paramMessage.obj;
              this.ZDA = this.ZDJ.a(paramMessage.aLz, paramMessage.ZEm, paramMessage.ZEo);
              IA(paramBoolean);
              AppMethodBeat.o(221468);
              return;
              ((Long)paramMessage.obj).longValue();
              this.ZDB = null;
              IA(paramBoolean);
              AppMethodBeat.o(221468);
              return;
              paramMessage = (TPPlayerMsg.TPDownLoadProgressInfo)paramMessage.obj;
              this.ZDJ.a((int)paramMessage.playableDurationMS, paramMessage.downloadSpeedKBps, paramMessage.currentDownloadSize, paramMessage.totalFileSize, paramMessage.extraInfo);
              AppMethodBeat.o(221468);
              return;
              paramMessage = paramMessage.obj;
              this.ZDC = null;
              IA(paramBoolean);
              AppMethodBeat.o(221468);
              return;
              paramMessage = (f.f)paramMessage.obj;
              this.ZDD = this.ZDJ.a(paramMessage.ZEq, paramMessage.fileKey, paramMessage.requestStart, paramMessage.requestEnd);
              IA(paramBoolean);
              AppMethodBeat.o(221468);
              return;
              paramMessage = (f.e)paramMessage.obj;
              this.ZDE = this.ZDJ.z(paramMessage.ZEq, paramMessage.offset, paramMessage.aFL);
              IA(paramBoolean);
              AppMethodBeat.o(221468);
              return;
              this.ZDF = this.ZDJ.C(paramMessage.arg1, (String)paramMessage.obj, paramMessage.arg2);
              IA(paramBoolean);
              AppMethodBeat.o(221468);
              return;
              this.ZCE = this.ZDJ.dx(paramMessage.arg1, (String)paramMessage.obj);
              IA(paramBoolean);
              AppMethodBeat.o(221468);
              return;
              b localb = this.ZDJ;
              int i = paramMessage.arg1;
              paramMessage = paramMessage.obj;
              this.ZDG = localb.aBk(i);
              IA(paramBoolean);
              AppMethodBeat.o(221468);
              return;
              this.mContentType = this.ZDJ.dy(paramMessage.arg1, (String)paramMessage.obj);
              IA(paramBoolean);
            }
          }
        }
      }
    }
  }
  
  private static String aBo(int paramInt)
  {
    AppMethodBeat.i(221425);
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
      AppMethodBeat.o(221425);
      return str;
    case 1: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> set player params";
    case 4: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> set surface";
    case 39: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> set surfaceHolder";
    case 5: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> set data source";
    case 6: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> set subtitle source";
    case 7: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> add audio source";
    case 8: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> add select track";
    case 36: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> deselect track";
    case 10: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> prepare async";
    case 11: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> start";
    case 12: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> pause";
    case 41: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> pauseDownload";
    case 42: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> resumeDownload";
    case 13: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> stop";
    case 14: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> reset";
    case 15: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> release";
    case 16: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> seek to";
    case 17: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> set output mute";
    case 18: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> set audio gain ratio";
    case 38: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> set audio normalize volume params";
    case 19: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> set speed ratio";
    case 35: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> set loopback";
    case 21: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> get video width";
    case 22: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> get video height";
    case 23: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> get track info";
    case 27: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> get property long";
    case 28: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> get property string";
    case 43: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> get current player state";
    case 29: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> set video info";
    case 30: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> capture video";
    case 31: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> switch def";
    case 32: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> select program";
    case 33: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> get program";
    case 20: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> set loopback with param";
    case 73: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> cdn info update";
    case 37: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> stopAsync";
    case 85: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> start read data";
    case 86: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> read data";
    case 87: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> stop read data";
    case 88: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> get data total size";
    case 89: 
      AppMethodBeat.o(221425);
      return "[tpPlayer] -> get data file path";
    }
    AppMethodBeat.o(221425);
    return "[tpPlayer] -> get content type";
  }
  
  private boolean irF()
  {
    AppMethodBeat.i(221409);
    if (Looper.myLooper() == this.mLooper)
    {
      AppMethodBeat.o(221409);
      return true;
    }
    AppMethodBeat.o(221409);
    return false;
  }
  
  private void irG()
  {
    AppMethodBeat.i(221413);
    if (!irF()) {
      this.ZDL.readLock().unlock();
    }
    AppMethodBeat.o(221413);
  }
  
  private void irH()
  {
    AppMethodBeat.i(221414);
    if (!irF()) {
      this.ZDL.readLock().lock();
    }
    AppMethodBeat.o(221414);
  }
  
  private void irL()
  {
    AppMethodBeat.i(221427);
    this.ZDL.WW(500L);
    AppMethodBeat.o(221427);
  }
  
  final void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(221408);
    irH();
    if (this.ZDK == null)
    {
      g.i("TPThumbPlayer[TPPlayerInternal.java]", aBo(paramInt1) + " , send failed , handler null");
      irG();
      AppMethodBeat.o(221408);
      return;
    }
    if ((paramBoolean1) && (paramObject == null))
    {
      g.i("TPThumbPlayer[TPPlayerInternal.java]", aBo(paramInt1) + ", send failed , params null");
      irG();
      AppMethodBeat.o(221408);
      return;
    }
    if (paramBoolean2) {
      this.ZDK.removeMessages(paramInt1);
    }
    Message localMessage = this.ZDK.obtainMessage();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    if (irF()) {
      a(localMessage, false);
    }
    for (;;)
    {
      irG();
      AppMethodBeat.o(221408);
      return;
      this.ZDK.sendMessageDelayed(localMessage, 0L);
    }
  }
  
  final void addAudioTrackSource(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(221346);
    f.a locala = new f.a();
    locala.url = paramString1;
    locala.name = paramString2;
    locala.ZEg = paramTPDownloadParamData;
    a(7, 0, 0, locala, true, false);
    AppMethodBeat.o(221346);
  }
  
  final void addSubtitleSource(String paramString1, String paramString2, String paramString3, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(221344);
    f.h localh = new f.h();
    localh.url = paramString1;
    localh.mimeType = paramString2;
    localh.name = paramString3;
    localh.ZEs = paramTPDownloadParamData;
    a(6, 0, 0, localh, true, false);
    AppMethodBeat.o(221344);
  }
  
  public final long getAdvRemainTime()
  {
    AppMethodBeat.i(221393);
    try
    {
      long l = this.ZDJ.irB();
      AppMethodBeat.o(221393);
      return l;
    }
    catch (Throwable localThrowable)
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(221393);
    }
    return 0L;
  }
  
  final int getBufferPercent()
  {
    AppMethodBeat.i(221363);
    try
    {
      int i = this.ZDJ.irr();
      AppMethodBeat.o(221363);
      return i;
    }
    catch (Throwable localThrowable)
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(221363);
    }
    return 0;
  }
  
  public final String getContentType(int paramInt, String paramString)
  {
    AppMethodBeat.i(221404);
    paramString = this.ZDJ.dy(paramInt, paramString);
    AppMethodBeat.o(221404);
    return paramString;
  }
  
  public final int getCurrentPlayClipNo()
  {
    AppMethodBeat.i(221390);
    try
    {
      int i = this.ZDJ.irA();
      AppMethodBeat.o(221390);
      return i;
    }
    catch (Throwable localThrowable)
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(221390);
    }
    return 0;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(221388);
    long l = getCurrentPositionMs();
    AppMethodBeat.o(221388);
    return l;
  }
  
  final long getCurrentPositionMs()
  {
    AppMethodBeat.i(221359);
    try
    {
      long l = this.ZDJ.irp();
      AppMethodBeat.o(221359);
      return l;
    }
    catch (Throwable localThrowable)
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(221359);
    }
    return 0L;
  }
  
  public final String getDataFilePath(int paramInt, String paramString)
  {
    AppMethodBeat.i(221402);
    paramString = this.ZDJ.aBk(paramInt);
    AppMethodBeat.o(221402);
    return paramString;
  }
  
  public final long getDataTotalSize(int paramInt, String paramString)
  {
    AppMethodBeat.i(221400);
    long l = this.ZDJ.dx(paramInt, paramString);
    AppMethodBeat.o(221400);
    return l;
  }
  
  final long getDurationMs()
  {
    AppMethodBeat.i(221356);
    try
    {
      long l = this.ZDJ.iro();
      AppMethodBeat.o(221356);
      return l;
    }
    catch (Throwable localThrowable)
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(221356);
    }
    return 0L;
  }
  
  public final Object getPlayInfo(long paramLong)
  {
    AppMethodBeat.i(221394);
    irI();
    a(82, 0, 0, Long.valueOf(paramLong), false, false);
    irK();
    irJ();
    Object localObject = this.ZDB;
    AppMethodBeat.o(221394);
    return localObject;
  }
  
  public final Object getPlayInfo(String paramString)
  {
    AppMethodBeat.i(221395);
    irI();
    a(84, 0, 0, paramString, false, false);
    irK();
    irJ();
    paramString = this.ZDC;
    AppMethodBeat.o(221395);
    return paramString;
  }
  
  final long getPlayableDurationMs()
  {
    AppMethodBeat.i(221365);
    try
    {
      long l = this.ZDJ.irs();
      AppMethodBeat.o(221365);
      return l;
    }
    catch (Throwable localThrowable)
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(221365);
    }
    return 0L;
  }
  
  public final long getPlayerBufferLength()
  {
    AppMethodBeat.i(221386);
    try
    {
      long l = this.ZDJ.irz();
      AppMethodBeat.o(221386);
      return l;
    }
    catch (Throwable localThrowable)
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(221386);
    }
    return 0L;
  }
  
  final void irI()
  {
    AppMethodBeat.i(221415);
    if (!irF()) {
      this.ZDL.writeLock().lock();
    }
    AppMethodBeat.o(221415);
  }
  
  final void irJ()
  {
    AppMethodBeat.i(221416);
    if (!irF()) {
      this.ZDL.writeLock().unlock();
    }
    AppMethodBeat.o(221416);
  }
  
  final void irK()
  {
    AppMethodBeat.i(221426);
    if (irF())
    {
      AppMethodBeat.o(221426);
      return;
    }
    irL();
    AppMethodBeat.o(221426);
  }
  
  public final void onDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    AppMethodBeat.i(221380);
    a(76, 0, 0, paramMap, false, false);
    AppMethodBeat.o(221380);
  }
  
  public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(221379);
    TPPlayerMsg.TPCDNURLInfo localTPCDNURLInfo = new TPPlayerMsg.TPCDNURLInfo();
    localTPCDNURLInfo.url = paramString1;
    localTPCDNURLInfo.cdnIp = paramString2;
    localTPCDNURLInfo.uIp = paramString3;
    localTPCDNURLInfo.errorStr = paramString4;
    a(73, 0, 0, localTPCDNURLInfo, false, false);
    AppMethodBeat.o(221379);
  }
  
  public final void onDownloadCdnUrlUpdate(String paramString)
  {
    AppMethodBeat.i(221377);
    a(72, 0, 0, paramString, false, false);
    AppMethodBeat.o(221377);
  }
  
  public final void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(221372);
    a(71, paramInt1, paramInt2, paramString, false, false);
    AppMethodBeat.o(221372);
  }
  
  public final void onDownloadFinish()
  {
    AppMethodBeat.i(221371);
    a(70, 0, 0, null, false, false);
    AppMethodBeat.o(221371);
  }
  
  public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(221370);
    TPPlayerMsg.TPDownLoadProgressInfo localTPDownLoadProgressInfo = new TPPlayerMsg.TPDownLoadProgressInfo();
    localTPDownLoadProgressInfo.playableDurationMS = paramInt1;
    localTPDownLoadProgressInfo.downloadSpeedKBps = paramInt2;
    localTPDownLoadProgressInfo.currentDownloadSize = paramLong1;
    localTPDownLoadProgressInfo.totalFileSize = paramLong2;
    localTPDownLoadProgressInfo.extraInfo = paramString;
    a(83, 0, 0, localTPDownLoadProgressInfo, false, false);
    AppMethodBeat.o(221370);
  }
  
  public final void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    AppMethodBeat.i(221385);
    TPPlayerMsg.TPProtocolInfo localTPProtocolInfo = new TPPlayerMsg.TPProtocolInfo();
    localTPProtocolInfo.protocolVersion = paramString2;
    localTPProtocolInfo.protocolName = paramString1;
    a(75, 0, 0, localTPProtocolInfo, false, false);
    AppMethodBeat.o(221385);
  }
  
  public final void onDownloadStatusUpdate(int paramInt)
  {
    AppMethodBeat.i(221383);
    a(74, paramInt, 0, null, false, false);
    AppMethodBeat.o(221383);
  }
  
  public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(221375);
    irI();
    f.d locald = new f.d();
    locald.aLz = paramInt;
    locald.ZEm = paramObject1;
    locald.ZEn = paramObject2;
    locald.ZEo = paramObject3;
    locald.ZEp = paramObject4;
    a(77, 0, 0, locald, false, false);
    irK();
    irJ();
    paramObject1 = this.ZDA;
    AppMethodBeat.o(221375);
    return paramObject1;
  }
  
  public final int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(221398);
    paramInt = this.ZDJ.z(paramInt, paramLong1, paramLong2);
    AppMethodBeat.o(221398);
    return paramInt;
  }
  
  public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(221396);
    paramInt = this.ZDJ.a(paramInt, paramString, paramLong1, paramLong2);
    AppMethodBeat.o(221396);
    return paramInt;
  }
  
  public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(221399);
    paramInt1 = this.ZDJ.C(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(221399);
    return paramInt1;
  }
  
  final void switchDefinition(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    AppMethodBeat.i(221353);
    f.j localj = new f.j();
    localj.ZEj = paramITPMediaAsset;
    localj.ZEv = paramLong;
    localj.ZEw = paramTPVideoInfo;
    localj.mode = paramInt;
    a(31, 0, 0, localj, true, true);
    AppMethodBeat.o(221353);
  }
  
  final void switchDefinition(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    AppMethodBeat.i(221349);
    f.j localj = new f.j();
    localj.url = paramString;
    localj.ZEv = paramLong;
    localj.ZEw = paramTPVideoInfo;
    localj.mode = paramInt;
    a(31, 0, 0, localj, true, true);
    AppMethodBeat.o(221349);
  }
  
  final class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(221333);
      c.a(c.this, paramMessage);
      AppMethodBeat.o(221333);
    }
  }
  
  public static abstract interface b
  {
    public abstract int C(int paramInt1, String paramString, int paramInt2);
    
    public abstract void Iy(boolean paramBoolean);
    
    public abstract void Iz(boolean paramBoolean);
    
    public abstract void T(int paramInt1, int paramInt2, String paramString);
    
    public abstract int a(int paramInt, String paramString, long paramLong1, long paramLong2);
    
    public abstract Object a(int paramInt, Object paramObject1, Object paramObject2);
    
    public abstract void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString);
    
    public abstract void a(ITPSurface paramITPSurface);
    
    public abstract void a(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack);
    
    public abstract void a(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt);
    
    public abstract void a(f.b paramb);
    
    public abstract void a(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt);
    
    public abstract void a(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData);
    
    public abstract void a(String paramString1, String paramString2, String paramString3, TPDownloadParamData paramTPDownloadParamData);
    
    public abstract String aBk(int paramInt);
    
    public abstract long aBl(int paramInt);
    
    public abstract String aBm(int paramInt);
    
    public abstract void aBn(int paramInt);
    
    public abstract void ayS();
    
    public abstract void b(TPOptionalParam paramTPOptionalParam);
    
    public abstract void b(TPVideoInfo paramTPVideoInfo);
    
    public abstract void bDA(String paramString);
    
    public abstract void bDB(String paramString);
    
    public abstract void bj(int paramInt, long paramLong);
    
    public abstract void bk(int paramInt, long paramLong);
    
    public abstract void bl(int paramInt, long paramLong);
    
    public abstract void bs(String paramString1, String paramString2, String paramString3);
    
    public abstract void cu(Map<String, String> paramMap);
    
    public abstract void d(boolean paramBoolean, long paramLong1, long paramLong2);
    
    public abstract void di(float paramFloat);
    
    public abstract void dj(float paramFloat);
    
    public abstract long dx(int paramInt, String paramString);
    
    public abstract String dy(int paramInt, String paramString);
    
    public abstract void f(SurfaceHolder paramSurfaceHolder);
    
    public abstract int irA();
    
    public abstract long irB();
    
    public abstract void irg();
    
    public abstract void irh();
    
    public abstract void iri();
    
    public abstract void irj();
    
    public abstract void irk();
    
    public abstract void irl();
    
    public abstract void irm();
    
    public abstract void irn();
    
    public abstract long iro();
    
    public abstract long irp();
    
    public abstract int irq();
    
    public abstract int irr();
    
    public abstract long irs();
    
    public abstract int irt();
    
    public abstract int iru();
    
    public abstract int irv();
    
    public abstract TPTrackInfo[] irw();
    
    public abstract TPProgramInfo[] irx();
    
    public abstract void iry();
    
    public abstract long irz();
    
    public abstract void nQ(int paramInt1, int paramInt2);
    
    public abstract void oK(String paramString1, String paramString2);
    
    public abstract void p(Surface paramSurface);
    
    public abstract int z(int paramInt, long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.g.c
 * JD-Core Version:    0.7.0.1
 */