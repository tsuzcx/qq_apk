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
import com.tencent.thumbplayer.api.TPCommonEnum.TPSurfaceType;
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
  private long ahHH;
  f.g ahIA;
  long ahIB;
  String ahIC;
  private Object ahID;
  private Object ahIE;
  private Object ahIF;
  private int ahIG;
  private int ahIH;
  private int ahII;
  private String ahIJ;
  int ahIK;
  int ahIL;
  private b ahIM;
  private a ahIN;
  private i ahIO;
  f.m ahIy;
  f.k ahIz;
  private String mContentType;
  private Looper mLooper;
  
  c(Looper paramLooper, b paramb)
  {
    AppMethodBeat.i(227172);
    this.mLooper = paramLooper;
    this.ahIN = new a(paramLooper);
    this.ahIM = paramb;
    this.ahIO = new i();
    this.ahIy = new f.m();
    this.ahIz = new f.k();
    this.ahIA = new f.g();
    AppMethodBeat.o(227172);
  }
  
  private void OC(boolean paramBoolean)
  {
    AppMethodBeat.i(227201);
    if (paramBoolean) {
      this.ahIO.writeLock().lock();
    }
    if (paramBoolean) {
      this.ahIO.ahNi.signalAll();
    }
    if (paramBoolean) {
      this.ahIO.writeLock().unlock();
    }
    AppMethodBeat.o(227201);
  }
  
  private void a(Message paramMessage, boolean paramBoolean)
  {
    AppMethodBeat.i(227234);
    if ((paramMessage.what != 83) && (paramMessage.what != 73) && (paramMessage.what != 74) && (paramMessage.what != 43) && (paramMessage.what != 86)) {
      g.i("TPThumbPlayer[TPPlayerInternal.java]", "internalMessage " + aIa(paramMessage.what));
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(227234);
      return;
      this.ahIM.b((TPOptionalParam)paramMessage.obj);
      AppMethodBeat.o(227234);
      return;
      this.ahIM.b((Surface)paramMessage.obj, paramMessage.arg1);
      AppMethodBeat.o(227234);
      return;
      this.ahIM.f((SurfaceHolder)paramMessage.obj);
      AppMethodBeat.o(227234);
      return;
      this.ahIM.a((ITPSurface)paramMessage.obj);
      AppMethodBeat.o(227234);
      return;
      this.ahIM.a((f.b)paramMessage.obj);
      AppMethodBeat.o(227234);
      return;
      this.ahIM.b((TPVideoInfo)paramMessage.obj);
      AppMethodBeat.o(227234);
      return;
      this.ahIM.a(((f.l)paramMessage.obj).ahJB, ((f.l)paramMessage.obj).ahJC);
      AppMethodBeat.o(227234);
      return;
      paramMessage = (f.h)paramMessage.obj;
      if (paramMessage != null)
      {
        this.ahIM.a(paramMessage.url, paramMessage.mimeType, paramMessage.name, paramMessage.ahJv);
        AppMethodBeat.o(227234);
        return;
        paramMessage = (f.a)paramMessage.obj;
        if (paramMessage != null)
        {
          this.ahIM.a(paramMessage.url, paramMessage.name, paramMessage.ahJj);
          AppMethodBeat.o(227234);
          return;
          this.ahIM.bs(paramMessage.arg1, paramMessage.arg2);
          AppMethodBeat.o(227234);
          return;
          this.ahIM.bt(paramMessage.arg1, paramMessage.arg2);
          AppMethodBeat.o(227234);
          return;
          this.ahIM.kaE();
          AppMethodBeat.o(227234);
          return;
          this.ahIM.kaF();
          AppMethodBeat.o(227234);
          return;
          this.ahIM.kaG();
          AppMethodBeat.o(227234);
          return;
          this.ahIM.kaC();
          AppMethodBeat.o(227234);
          return;
          this.ahIM.kaD();
          AppMethodBeat.o(227234);
          return;
          this.ahIM.kaH();
          OC(paramBoolean);
          AppMethodBeat.o(227234);
          return;
          this.ahIM.kaI();
          AppMethodBeat.o(227234);
          return;
          this.ahIM.kaJ();
          OC(paramBoolean);
          AppMethodBeat.o(227234);
          return;
          this.ahIM.kaK();
          OC(paramBoolean);
          this.ahIN.removeCallbacksAndMessages(null);
          AppMethodBeat.o(227234);
          return;
          this.ahIM.pN(paramMessage.arg1, paramMessage.arg2);
          AppMethodBeat.o(227234);
          return;
          this.ahIM.OA(((Boolean)paramMessage.obj).booleanValue());
          AppMethodBeat.o(227234);
          return;
          this.ahIM.eE(((Float)paramMessage.obj).floatValue());
          AppMethodBeat.o(227234);
          return;
          this.ahIM.bGg((String)paramMessage.obj);
          AppMethodBeat.o(227234);
          return;
          this.ahIM.eF(((Float)paramMessage.obj).floatValue());
          AppMethodBeat.o(227234);
          return;
          this.ahIM.kaL();
          AppMethodBeat.o(227234);
          return;
          paramMessage = (f.c)paramMessage.obj;
          if (paramMessage != null)
          {
            this.ahIM.d(paramMessage.ahDv, paramMessage.ahJn, paramMessage.ahJo);
            AppMethodBeat.o(227234);
            return;
            this.ahIM.OB(((Boolean)paramMessage.obj).booleanValue());
            AppMethodBeat.o(227234);
            return;
            paramMessage = (f.j)paramMessage.obj;
            if (paramMessage != null)
            {
              if (!TextUtils.isEmpty(paramMessage.url))
              {
                this.ahIM.a(paramMessage.url, paramMessage.ahJy, paramMessage.ahJz, paramMessage.mode);
                AppMethodBeat.o(227234);
                return;
              }
              this.ahIM.a(paramMessage.ahJm, paramMessage.ahJy, paramMessage.ahJz, paramMessage.mode);
              AppMethodBeat.o(227234);
              return;
              this.ahIM.bu(paramMessage.arg1, paramMessage.arg2);
              AppMethodBeat.o(227234);
              return;
              ab(paramMessage.what, paramMessage.arg1, paramBoolean);
              AppMethodBeat.o(227234);
              return;
              this.ahIM.kaW();
              AppMethodBeat.o(227234);
              return;
              this.ahIM.ae(paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
              AppMethodBeat.o(227234);
              return;
              this.ahIM.bGh((String)paramMessage.obj);
              AppMethodBeat.o(227234);
              return;
              paramMessage = (TPPlayerMsg.TPCDNURLInfo)paramMessage.obj;
              this.ahIM.bP(paramMessage.url, paramMessage.cdnIp, paramMessage.uIp);
              AppMethodBeat.o(227234);
              return;
              this.ahIM.aHZ(paramMessage.arg1);
              AppMethodBeat.o(227234);
              return;
              paramMessage = (TPPlayerMsg.TPProtocolInfo)paramMessage.obj;
              this.ahIM.qI(paramMessage.protocolName, paramMessage.protocolVersion);
              AppMethodBeat.o(227234);
              return;
              this.ahIM.dn((Map)paramMessage.obj);
              AppMethodBeat.o(227234);
              return;
              paramMessage = (f.d)paramMessage.obj;
              this.ahID = this.ahIM.g(paramMessage.cFw, paramMessage.ahJp, paramMessage.ahJr);
              OC(paramBoolean);
              AppMethodBeat.o(227234);
              return;
              b localb = this.ahIM;
              ((Long)paramMessage.obj).longValue();
              this.ahIE = localb.kba();
              OC(paramBoolean);
              AppMethodBeat.o(227234);
              return;
              paramMessage = (TPPlayerMsg.TPDownLoadProgressInfo)paramMessage.obj;
              this.ahIM.a((int)paramMessage.playableDurationMS, paramMessage.downloadSpeedKBps, paramMessage.currentDownloadSize, paramMessage.totalFileSize, paramMessage.extraInfo);
              AppMethodBeat.o(227234);
              return;
              localb = this.ahIM;
              paramMessage = paramMessage.obj;
              this.ahIF = localb.kbb();
              OC(paramBoolean);
              AppMethodBeat.o(227234);
              return;
              paramMessage = (f.f)paramMessage.obj;
              this.ahIG = this.ahIM.a(paramMessage.ahJt, paramMessage.fileKey, paramMessage.requestStart, paramMessage.requestEnd);
              OC(paramBoolean);
              AppMethodBeat.o(227234);
              return;
              paramMessage = (f.e)paramMessage.obj;
              this.ahIH = this.ahIM.b(paramMessage.ahJt, paramMessage.fileKey, paramMessage.offset, paramMessage.length);
              OC(paramBoolean);
              AppMethodBeat.o(227234);
              return;
              this.ahII = this.ahIM.H(paramMessage.arg1, (String)paramMessage.obj, paramMessage.arg2);
              OC(paramBoolean);
              AppMethodBeat.o(227234);
              return;
              this.ahHH = this.ahIM.er(paramMessage.arg1, (String)paramMessage.obj);
              OC(paramBoolean);
              AppMethodBeat.o(227234);
              return;
              this.ahIJ = this.ahIM.es(paramMessage.arg1, (String)paramMessage.obj);
              OC(paramBoolean);
              AppMethodBeat.o(227234);
              return;
              this.mContentType = this.ahIM.et(paramMessage.arg1, (String)paramMessage.obj);
              OC(paramBoolean);
            }
          }
        }
      }
    }
  }
  
  private static String aIa(int paramInt)
  {
    AppMethodBeat.i(227209);
    switch (paramInt)
    {
    default: 
      String str = "[tpPlayer] -> ".concat(String.valueOf(paramInt));
      AppMethodBeat.o(227209);
      return str;
    case 1: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> set player params";
    case 4: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> set surface";
    case 39: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> set surfaceHolder";
    case 5: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> set data source";
    case 6: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> set subtitle source";
    case 7: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> add audio source";
    case 8: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> add select track";
    case 36: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> deselect track";
    case 10: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> prepare async";
    case 11: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> start";
    case 12: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> pause";
    case 41: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> pauseDownload";
    case 42: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> resumeDownload";
    case 13: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> stop";
    case 14: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> reset";
    case 15: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> release";
    case 16: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> seek to";
    case 17: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> set output mute";
    case 18: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> set audio gain ratio";
    case 38: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> set audio normalize volume params";
    case 19: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> set speed ratio";
    case 200: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> set sharpen switch";
    case 35: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> set loopback";
    case 21: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> get video width";
    case 22: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> get video height";
    case 23: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> get track info";
    case 27: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> get property long";
    case 28: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> get property string";
    case 43: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> get current player state";
    case 29: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> set video info";
    case 30: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> capture video";
    case 31: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> switch def";
    case 32: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> select program";
    case 33: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> get program";
    case 20: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> set loopback with param";
    case 73: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> cdn info update";
    case 37: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> stopAsync";
    case 85: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> start read data";
    case 86: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> read data";
    case 87: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> stop read data";
    case 88: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> get data total size";
    case 89: 
      AppMethodBeat.o(227209);
      return "[tpPlayer] -> get data file path";
    }
    AppMethodBeat.o(227209);
    return "[tpPlayer] -> get content type";
  }
  
  private void ab(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(227241);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      OC(paramBoolean);
      AppMethodBeat.o(227241);
      return;
      this.ahIy.width = this.ahIM.kaR();
      continue;
      this.ahIy.height = this.ahIM.kaS();
      continue;
      this.ahIz.ahJA = this.ahIM.kaU();
      continue;
      this.ahIB = this.ahIM.aHX(paramInt2);
      continue;
      this.ahIC = this.ahIM.aHY(paramInt2);
      continue;
      this.ahIA.ahJu = this.ahIM.kaV();
      continue;
      this.ahIL = this.ahIM.kaT();
      continue;
      this.ahIK = this.ahIM.kaO();
    }
  }
  
  private boolean kbf()
  {
    AppMethodBeat.i(227178);
    if (Looper.myLooper() == this.mLooper)
    {
      AppMethodBeat.o(227178);
      return true;
    }
    AppMethodBeat.o(227178);
    return false;
  }
  
  private void kbg()
  {
    AppMethodBeat.i(227186);
    if (!kbf()) {
      this.ahIO.readLock().unlock();
    }
    AppMethodBeat.o(227186);
  }
  
  private void kbh()
  {
    AppMethodBeat.i(227192);
    if (!kbf()) {
      this.ahIO.readLock().lock();
    }
    AppMethodBeat.o(227192);
  }
  
  private void kbl()
  {
    AppMethodBeat.i(227214);
    this.ahIO.Bj(500L);
    AppMethodBeat.o(227214);
  }
  
  final void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(227494);
    kbh();
    if (this.ahIN == null)
    {
      g.i("TPThumbPlayer[TPPlayerInternal.java]", aIa(paramInt1) + " , send failed , handler null");
      kbg();
      AppMethodBeat.o(227494);
      return;
    }
    if ((paramBoolean1) && (paramObject == null))
    {
      g.i("TPThumbPlayer[TPPlayerInternal.java]", aIa(paramInt1) + ", send failed , params null");
      kbg();
      AppMethodBeat.o(227494);
      return;
    }
    if (paramBoolean2) {
      this.ahIN.removeMessages(paramInt1);
    }
    Message localMessage = this.ahIN.obtainMessage();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    if (kbf()) {
      a(localMessage, false);
    }
    for (;;)
    {
      kbg();
      AppMethodBeat.o(227494);
      return;
      this.ahIN.sendMessageDelayed(localMessage, 0L);
    }
  }
  
  final void addAudioTrackSource(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(227283);
    f.a locala = new f.a();
    locala.url = paramString1;
    locala.name = paramString2;
    locala.ahJj = paramTPDownloadParamData;
    a(7, 0, 0, locala, true, false);
    AppMethodBeat.o(227283);
  }
  
  final void addSubtitleSource(String paramString1, String paramString2, String paramString3, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(227275);
    f.h localh = new f.h();
    localh.url = paramString1;
    localh.mimeType = paramString2;
    localh.name = paramString3;
    localh.ahJv = paramTPDownloadParamData;
    a(6, 0, 0, localh, true, false);
    AppMethodBeat.o(227275);
  }
  
  public final long getAdvRemainTime()
  {
    AppMethodBeat.i(227425);
    try
    {
      long l = this.ahIM.kaZ();
      AppMethodBeat.o(227425);
      return l;
    }
    finally
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(227425);
    }
    return 0L;
  }
  
  final int getBufferPercent()
  {
    AppMethodBeat.i(227313);
    try
    {
      int i = this.ahIM.kaP();
      AppMethodBeat.o(227313);
      return i;
    }
    finally
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(227313);
    }
    return 0;
  }
  
  public final String getContentType(int paramInt, String paramString)
  {
    AppMethodBeat.i(227485);
    paramString = this.ahIM.et(paramInt, paramString);
    AppMethodBeat.o(227485);
    return paramString;
  }
  
  public final int getCurrentPlayClipNo()
  {
    AppMethodBeat.i(227418);
    try
    {
      int i = this.ahIM.kaY();
      AppMethodBeat.o(227418);
      return i;
    }
    finally
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(227418);
    }
    return 0;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(227410);
    long l = getCurrentPositionMs();
    AppMethodBeat.o(227410);
    return l;
  }
  
  final long getCurrentPositionMs()
  {
    AppMethodBeat.i(227309);
    try
    {
      long l = this.ahIM.kaN();
      AppMethodBeat.o(227309);
      return l;
    }
    finally
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(227309);
    }
    return 0L;
  }
  
  public final String getDataFilePath(int paramInt, String paramString)
  {
    AppMethodBeat.i(227479);
    paramString = this.ahIM.es(paramInt, paramString);
    AppMethodBeat.o(227479);
    return paramString;
  }
  
  public final long getDataTotalSize(int paramInt, String paramString)
  {
    AppMethodBeat.i(227472);
    long l = this.ahIM.er(paramInt, paramString);
    AppMethodBeat.o(227472);
    return l;
  }
  
  final long getDurationMs()
  {
    AppMethodBeat.i(227303);
    try
    {
      long l = this.ahIM.kaM();
      AppMethodBeat.o(227303);
      return l;
    }
    finally
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(227303);
    }
    return 0L;
  }
  
  public final Object getPlayInfo(long paramLong)
  {
    AppMethodBeat.i(227431);
    kbi();
    a(82, 0, 0, Long.valueOf(paramLong), false, false);
    kbk();
    kbj();
    Object localObject = this.ahIE;
    AppMethodBeat.o(227431);
    return localObject;
  }
  
  public final Object getPlayInfo(String paramString)
  {
    AppMethodBeat.i(227443);
    kbi();
    a(84, 0, 0, paramString, false, false);
    kbk();
    kbj();
    paramString = this.ahIF;
    AppMethodBeat.o(227443);
    return paramString;
  }
  
  final long getPlayableDurationMs()
  {
    AppMethodBeat.i(227320);
    try
    {
      long l = this.ahIM.kaQ();
      AppMethodBeat.o(227320);
      return l;
    }
    finally
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(227320);
    }
    return 0L;
  }
  
  public final long getPlayerBufferLength()
  {
    AppMethodBeat.i(227400);
    try
    {
      long l = this.ahIM.kaX();
      AppMethodBeat.o(227400);
      return l;
    }
    finally
    {
      g.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(227400);
    }
    return 0L;
  }
  
  final void kbi()
  {
    AppMethodBeat.i(227501);
    if (!kbf()) {
      this.ahIO.writeLock().lock();
    }
    AppMethodBeat.o(227501);
  }
  
  final void kbj()
  {
    AppMethodBeat.i(227508);
    if (!kbf()) {
      this.ahIO.writeLock().unlock();
    }
    AppMethodBeat.o(227508);
  }
  
  final void kbk()
  {
    AppMethodBeat.i(227514);
    if (kbf())
    {
      AppMethodBeat.o(227514);
      return;
    }
    kbl();
    AppMethodBeat.o(227514);
  }
  
  public final void onDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    AppMethodBeat.i(227374);
    a(76, 0, 0, paramMap, false, false);
    AppMethodBeat.o(227374);
  }
  
  public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(227366);
    TPPlayerMsg.TPCDNURLInfo localTPCDNURLInfo = new TPPlayerMsg.TPCDNURLInfo();
    localTPCDNURLInfo.url = paramString1;
    localTPCDNURLInfo.cdnIp = paramString2;
    localTPCDNURLInfo.uIp = paramString3;
    localTPCDNURLInfo.errorStr = paramString4;
    a(73, 0, 0, localTPCDNURLInfo, false, false);
    AppMethodBeat.o(227366);
  }
  
  public final void onDownloadCdnUrlUpdate(String paramString)
  {
    AppMethodBeat.i(227357);
    a(72, 0, 0, paramString, false, false);
    AppMethodBeat.o(227357);
  }
  
  public final void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(227337);
    a(71, paramInt1, paramInt2, paramString, false, false);
    AppMethodBeat.o(227337);
  }
  
  public final void onDownloadFinish()
  {
    AppMethodBeat.i(227330);
    a(70, 0, 0, null, false, false);
    AppMethodBeat.o(227330);
  }
  
  public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(227324);
    TPPlayerMsg.TPDownLoadProgressInfo localTPDownLoadProgressInfo = new TPPlayerMsg.TPDownLoadProgressInfo();
    localTPDownLoadProgressInfo.playableDurationMS = paramInt1;
    localTPDownLoadProgressInfo.downloadSpeedKBps = paramInt2;
    localTPDownLoadProgressInfo.currentDownloadSize = paramLong1;
    localTPDownLoadProgressInfo.totalFileSize = paramLong2;
    localTPDownLoadProgressInfo.extraInfo = paramString;
    a(83, 0, 0, localTPDownLoadProgressInfo, false, false);
    AppMethodBeat.o(227324);
  }
  
  public final void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    AppMethodBeat.i(227391);
    TPPlayerMsg.TPProtocolInfo localTPProtocolInfo = new TPPlayerMsg.TPProtocolInfo();
    localTPProtocolInfo.protocolVersion = paramString2;
    localTPProtocolInfo.protocolName = paramString1;
    a(75, 0, 0, localTPProtocolInfo, false, false);
    AppMethodBeat.o(227391);
  }
  
  public final void onDownloadStatusUpdate(int paramInt)
  {
    AppMethodBeat.i(227381);
    a(74, paramInt, 0, null, false, false);
    AppMethodBeat.o(227381);
  }
  
  public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(227349);
    kbi();
    f.d locald = new f.d();
    locald.cFw = paramInt;
    locald.ahJp = paramObject1;
    locald.ahJq = paramObject2;
    locald.ahJr = paramObject3;
    locald.ahJs = paramObject4;
    a(77, 0, 0, locald, false, false);
    kbk();
    kbj();
    paramObject1 = this.ahID;
    AppMethodBeat.o(227349);
    return paramObject1;
  }
  
  public final int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(227454);
    paramInt = this.ahIM.b(paramInt, paramString, paramLong1, paramLong2);
    AppMethodBeat.o(227454);
    return paramInt;
  }
  
  public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(227450);
    paramInt = this.ahIM.a(paramInt, paramString, paramLong1, paramLong2);
    AppMethodBeat.o(227450);
    return paramInt;
  }
  
  public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(227462);
    paramInt1 = this.ahIM.H(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(227462);
    return paramInt1;
  }
  
  final void setSurface(Surface paramSurface, @TPCommonEnum.TPSurfaceType int paramInt)
  {
    AppMethodBeat.i(227271);
    a(4, paramInt, 0, paramSurface, false, false);
    AppMethodBeat.o(227271);
  }
  
  final void switchDefinition(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    AppMethodBeat.i(227296);
    f.j localj = new f.j();
    localj.ahJm = paramITPMediaAsset;
    localj.ahJy = paramLong;
    localj.ahJz = paramTPVideoInfo;
    localj.mode = paramInt;
    a(31, 0, 0, localj, true, true);
    AppMethodBeat.o(227296);
  }
  
  final void switchDefinition(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    AppMethodBeat.i(227289);
    f.j localj = new f.j();
    localj.url = paramString;
    localj.ahJy = paramLong;
    localj.ahJz = paramTPVideoInfo;
    localj.mode = paramInt;
    a(31, 0, 0, localj, true, true);
    AppMethodBeat.o(227289);
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
      AppMethodBeat.i(227187);
      c.a(c.this, paramMessage);
      AppMethodBeat.o(227187);
    }
  }
  
  public static abstract interface b
  {
    public abstract int H(int paramInt1, String paramString, int paramInt2);
    
    public abstract void OA(boolean paramBoolean);
    
    public abstract void OB(boolean paramBoolean);
    
    public abstract int a(int paramInt, String paramString, long paramLong1, long paramLong2);
    
    public abstract void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString);
    
    public abstract void a(ITPSurface paramITPSurface);
    
    public abstract void a(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack);
    
    public abstract void a(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt);
    
    public abstract void a(f.b paramb);
    
    public abstract void a(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt);
    
    public abstract void a(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData);
    
    public abstract void a(String paramString1, String paramString2, String paramString3, TPDownloadParamData paramTPDownloadParamData);
    
    public abstract long aHX(int paramInt);
    
    public abstract String aHY(int paramInt);
    
    public abstract void aHZ(int paramInt);
    
    public abstract void ae(int paramInt1, int paramInt2, String paramString);
    
    public abstract int b(int paramInt, String paramString, long paramLong1, long paramLong2);
    
    public abstract void b(Surface paramSurface, @TPCommonEnum.TPSurfaceType int paramInt);
    
    public abstract void b(TPOptionalParam paramTPOptionalParam);
    
    public abstract void b(TPVideoInfo paramTPVideoInfo);
    
    public abstract void bGg(String paramString);
    
    public abstract void bGh(String paramString);
    
    public abstract void bP(String paramString1, String paramString2, String paramString3);
    
    public abstract void bs(int paramInt, long paramLong);
    
    public abstract void bt(int paramInt, long paramLong);
    
    public abstract void bu(int paramInt, long paramLong);
    
    public abstract void d(boolean paramBoolean, long paramLong1, long paramLong2);
    
    public abstract void dn(Map<String, String> paramMap);
    
    public abstract void eE(float paramFloat);
    
    public abstract void eF(float paramFloat);
    
    public abstract long er(int paramInt, String paramString);
    
    public abstract String es(int paramInt, String paramString);
    
    public abstract String et(int paramInt, String paramString);
    
    public abstract void f(SurfaceHolder paramSurfaceHolder);
    
    public abstract Object g(int paramInt, Object paramObject1, Object paramObject2);
    
    public abstract void kaC();
    
    public abstract void kaD();
    
    public abstract void kaE();
    
    public abstract void kaF();
    
    public abstract void kaG();
    
    public abstract void kaH();
    
    public abstract void kaI();
    
    public abstract void kaJ();
    
    public abstract void kaK();
    
    public abstract void kaL();
    
    public abstract long kaM();
    
    public abstract long kaN();
    
    public abstract int kaO();
    
    public abstract int kaP();
    
    public abstract long kaQ();
    
    public abstract int kaR();
    
    public abstract int kaS();
    
    public abstract int kaT();
    
    public abstract TPTrackInfo[] kaU();
    
    public abstract TPProgramInfo[] kaV();
    
    public abstract void kaW();
    
    public abstract long kaX();
    
    public abstract int kaY();
    
    public abstract long kaZ();
    
    public abstract Object kba();
    
    public abstract Object kbb();
    
    public abstract void pN(int paramInt1, int paramInt2);
    
    public abstract void qI(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.g.c
 * JD-Core Version:    0.7.0.1
 */