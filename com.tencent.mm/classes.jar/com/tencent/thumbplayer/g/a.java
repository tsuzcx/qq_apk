package com.tencent.thumbplayer.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.c.a;
import com.tencent.thumbplayer.a.a.c.b;
import com.tencent.thumbplayer.a.a.c.c;
import com.tencent.thumbplayer.a.a.c.d;
import com.tencent.thumbplayer.a.a.c.e;
import com.tencent.thumbplayer.a.a.c.f;
import com.tencent.thumbplayer.a.a.c.g;
import com.tencent.thumbplayer.a.a.c.h;
import com.tencent.thumbplayer.a.a.c.i;
import com.tencent.thumbplayer.a.a.c.j;
import com.tencent.thumbplayer.b.b.c;
import com.tencent.thumbplayer.b.b.d;
import com.tencent.thumbplayer.b.b.e;
import com.tencent.thumbplayer.b.b.f;
import com.tencent.thumbplayer.b.b.g;
import com.tencent.thumbplayer.b.b.h;
import com.tencent.thumbplayer.b.f.a;
import com.tencent.thumbplayer.b.f.e;
import com.tencent.thumbplayer.b.i.b;
import com.tencent.thumbplayer.b.i.c;
import com.tencent.thumbplayer.b.i.d;
import com.tencent.thumbplayer.b.j;
import com.tencent.thumbplayer.b.k;
import com.tencent.thumbplayer.b.m;
import com.tencent.thumbplayer.b.n;
import com.tencent.thumbplayer.b.o;
import com.tencent.thumbplayer.b.p;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class a
  implements com.tencent.thumbplayer.b.a, b.b
{
  private static String KhR = "api call:";
  private static int KhS = 0;
  private com.tencent.thumbplayer.a.a KhT;
  private b KhU;
  private c KhV;
  private com.tencent.thumbplayer.f.a KhW;
  private com.tencent.thumbplayer.g.a.b KhY;
  private a KhZ;
  private boolean Kia;
  private int Kib;
  private ArrayList<String> Kic;
  private String TAG;
  private Context mContext;
  private HandlerThread mHandlerThread;
  private String mUrl;
  
  public a(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private a(Context paramContext, byte paramByte)
  {
    this(paramContext, '\000');
  }
  
  private a(Context paramContext, char paramChar)
  {
    AppMethodBeat.i(187975);
    this.TAG = "TPThumbPlayer[TPPlayer.java]";
    this.mUrl = null;
    this.Kia = true;
    this.Kib = -1;
    this.TAG = (this.TAG + ", playId:" + KhS);
    KhS += 1;
    com.tencent.thumbplayer.utils.f.i(this.TAG, "create TPPlayer");
    this.mContext = paramContext.getApplicationContext();
    this.KhY = new com.tencent.thumbplayer.g.a.c();
    a(100, 0, 0, null, new com.tencent.thumbplayer.utils.e().O("stime", Long.valueOf(System.currentTimeMillis())).map);
    this.KhZ = new a(this);
    b localb = new b();
    this.KhV = new c(this.TAG);
    this.KhT = new com.tencent.thumbplayer.a.d(this.mContext);
    this.KhT.a(localb);
    this.KhT.a(localb);
    this.KhT.a(localb);
    this.KhT.a(localb);
    this.KhT.a(localb);
    this.KhT.a(localb);
    this.KhT.a(localb);
    this.KhT.a(localb);
    this.KhT.a(localb);
    this.KhT.a(localb);
    this.KhT.a(localb);
    this.mHandlerThread = new HandlerThread("TP-workthread");
    this.mHandlerThread.start();
    this.KhU = new b(this.mHandlerThread.getLooper(), this);
    a(101, 0, 0, null, new com.tencent.thumbplayer.utils.e().O("etime", Long.valueOf(System.currentTimeMillis())).map);
    this.KhW = new com.tencent.thumbplayer.f.c(paramContext);
    this.KhW.a(localb);
    this.KhY.a(new com.tencent.thumbplayer.g.a.a.e()).a(new com.tencent.thumbplayer.g.a.a.b());
    this.Kic = new ArrayList();
    AppMethodBeat.o(187975);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    AppMethodBeat.i(188045);
    try
    {
      if (this.KhY != null) {
        this.KhY.b(paramInt1, paramInt2, paramInt3, paramString, paramObject);
      }
      AppMethodBeat.o(188045);
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, paramString);
      AppMethodBeat.o(188045);
    }
  }
  
  private void e(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(188046);
    if (this.KhZ != null)
    {
      Message localMessage = this.KhZ.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      this.KhZ.sendMessage(localMessage);
    }
    AppMethodBeat.o(188046);
  }
  
  private boolean fGh()
  {
    AppMethodBeat.i(188042);
    if ((this.KhW.isEnable()) && (com.tencent.thumbplayer.e.a.fFy()) && (this.Kia))
    {
      AppMethodBeat.o(188042);
      return true;
    }
    AppMethodBeat.o(188042);
    return false;
  }
  
  private void fGi()
  {
    AppMethodBeat.i(188044);
    if (this.KhT.isPlaying()) {}
    for (int i = 0;; i = 5)
    {
      this.KhW.aeL(i);
      AppMethodBeat.o(188044);
      return;
    }
  }
  
  private void kG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188043);
    a(108, paramInt1, paramInt2, "", new com.tencent.thumbplayer.utils.e().O("etime", Long.valueOf(System.currentTimeMillis())).O("reason", Integer.valueOf(3)).O("code", paramInt1 + "." + paramInt2).map);
    this.KhW.aeL(3);
    AppMethodBeat.o(188043);
  }
  
  public final void R(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(188032);
    com.tencent.thumbplayer.utils.f.i(this.TAG, "handleOnDownloadError, moduleID:" + paramInt1 + ", errorCode:" + paramInt2 + ", extInfo:" + paramString);
    kG(paramInt1, paramInt2);
    e(268, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(188032);
  }
  
  public final Object a(int paramInt, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(188038);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(188038);
      return null;
      com.tencent.thumbplayer.utils.f.i(this.TAG, "onDownloadNoMoreData");
      e(276, 0, 0, paramObject1);
      continue;
      if (!(paramObject2 instanceof Integer)) {
        com.tencent.thumbplayer.utils.f.i(this.TAG, "MESSAGE_NOTIFY_PLAYER_SWITCH_DEFINITION, err.");
      } else {
        e(278, ((Integer)paramObject2).intValue(), 0, null);
      }
    }
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama, long paramLong, p paramp, int paramInt)
  {
    AppMethodBeat.i(188029);
    parama = this.KhW.a(parama, paramLong, paramp);
    if (parama != null) {
      try
      {
        com.tencent.thumbplayer.utils.f.i(this.TAG, "handleSwitchDef, proxyMediaAsset:" + parama + ", defID:" + paramLong);
        this.KhT.a(parama, paramInt, paramLong);
        a(120, 0, 0, null, new com.tencent.thumbplayer.utils.e().O("switch", String.valueOf(paramLong)).map);
        AppMethodBeat.o(188029);
        return;
      }
      catch (Exception parama)
      {
        com.tencent.thumbplayer.utils.f.e(this.TAG, parama);
      }
    }
    AppMethodBeat.o(188029);
  }
  
  public final void a(com.tencent.thumbplayer.b.b.b paramb)
  {
    if (this.KhV != null) {
      this.KhV.Kis = paramb;
    }
  }
  
  public final void a(b.c paramc)
  {
    if (this.KhV != null) {
      this.KhV.Kiu = paramc;
    }
  }
  
  public final void a(b.d paramd)
  {
    if (this.KhV != null) {
      this.KhV.Kit = paramd;
    }
  }
  
  public final void a(b.e parame)
  {
    if (this.KhV != null) {
      this.KhV.Kir = parame;
    }
  }
  
  public final void a(b.f paramf)
  {
    if (this.KhV != null) {
      this.KhV.KiB = paramf;
    }
  }
  
  public final void a(b.g paramg)
  {
    if (this.KhV != null) {
      this.KhV.Kiv = paramg;
    }
  }
  
  public final void a(b.h paramh)
  {
    if (this.KhV != null) {
      this.KhV.KiA = paramh;
    }
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(187978);
    this.KhU.a(29, 0, 0, paramp, true, false);
    AppMethodBeat.o(187978);
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(187999);
    if (paramb != null)
    {
      try
      {
        if (!TextUtils.isEmpty(paramb.url))
        {
          this.mUrl = paramb.url;
          if (fGh())
          {
            paramb.url = this.KhW.aTM(paramb.url);
            com.tencent.thumbplayer.utils.f.i(this.TAG, "handleSetDataSource " + paramb.url);
          }
        }
        while ((!TextUtils.isEmpty(paramb.url)) && (paramb.KiE != null))
        {
          this.KhT.setDataSource(paramb.url, paramb.KiE);
          AppMethodBeat.o(187999);
          return;
          if (paramb.KiG != null)
          {
            if (fGh()) {
              paramb.KiG = this.KhW.c(paramb.KiG);
            }
            if (paramb.KiG != null) {
              this.KhT.a(paramb.KiG);
            }
            AppMethodBeat.o(187999);
            return;
          }
        }
        if (TextUtils.isEmpty(paramb.url)) {
          break label224;
        }
        this.KhT.setDataSource(paramb.url);
        AppMethodBeat.o(187999);
        return;
      }
      catch (Exception paramb)
      {
        com.tencent.thumbplayer.utils.f.e(this.TAG, paramb);
      }
    }
    else
    {
      AppMethodBeat.o(187999);
      return;
    }
    label224:
    this.KhT.b(paramb.KiF);
    AppMethodBeat.o(187999);
  }
  
  public final void a(String paramString, long paramLong, p paramp, int paramInt)
  {
    AppMethodBeat.i(188028);
    paramp = this.KhW.a(paramLong, paramString, paramp);
    if (!TextUtils.isEmpty(paramp)) {
      try
      {
        com.tencent.thumbplayer.utils.f.i(this.TAG, "handleSwitchDef, proxyUrl:" + paramString + ", defID:" + paramLong);
        this.KhT.p(paramp, paramInt, paramLong);
        a(120, 0, 0, null, new com.tencent.thumbplayer.utils.e().O("switch", String.valueOf(paramLong)).map);
        AppMethodBeat.o(188028);
        return;
      }
      catch (Exception paramString)
      {
        com.tencent.thumbplayer.utils.f.e(this.TAG, paramString);
      }
    }
    AppMethodBeat.o(188028);
  }
  
  public final void a(String paramString1, String paramString2, com.tencent.thumbplayer.b.b.b paramb)
  {
    AppMethodBeat.i(188002);
    if (!fGh())
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, "handleAddAudioSource, proxy is not enable.");
      AppMethodBeat.o(188002);
      return;
    }
    if ((TextUtils.isEmpty(paramString2)) || (!com.tencent.thumbplayer.utils.b.aRh(paramString1)))
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, "handleAddAudioSource, illegal argument.");
      AppMethodBeat.o(188002);
      return;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      com.tencent.thumbplayer.b.f localf = new com.tencent.thumbplayer.b.f();
      if (paramb != null)
      {
        paramb = paramb.Kfv;
        localf.KeQ = 3;
        localf.key = 6;
        localf.KeT = new f.e();
        localf.KeT.value = paramb;
      }
      localArrayList.add(localf);
      this.KhT.g(paramString1, paramString2, localArrayList);
      AppMethodBeat.o(188002);
      return;
    }
    catch (Exception paramString1)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, paramString1);
      AppMethodBeat.o(188002);
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, com.tencent.thumbplayer.b.b.b paramb)
  {
    AppMethodBeat.i(188001);
    try
    {
      long l = System.currentTimeMillis();
      if ((fGh()) && (com.tencent.thumbplayer.utils.b.aRh(paramString1)))
      {
        paramb = this.KhW.a(3, paramString1, paramb);
        this.Kic.add(paramb);
        this.KhT.bb(paramb, paramString2, paramString3);
      }
      for (;;)
      {
        a(118, 0, 0, null, new com.tencent.thumbplayer.utils.e().O("stime", Long.valueOf(l)).O("etime", Long.valueOf(System.currentTimeMillis())).O("url", paramString1).map);
        AppMethodBeat.o(188001);
        return;
        this.KhT.bb(paramString1, paramString2, paramString3);
      }
      return;
    }
    catch (Exception paramString1)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, paramString1);
      AppMethodBeat.o(188001);
    }
  }
  
  public final void aL(int paramInt, long paramLong)
  {
    AppMethodBeat.i(188003);
    try
    {
      n[] arrayOfn = this.KhT.fEO();
      if ((arrayOfn != null) && (arrayOfn.length > paramInt)) {
        a(122, 0, 0, null, new com.tencent.thumbplayer.utils.e().O("opaque", Long.valueOf(paramLong)).O("tracktype", Integer.valueOf(arrayOfn[paramInt].trackType)).O("stime", Long.valueOf(System.currentTimeMillis())).map);
      }
      this.KhT.aG(paramInt, paramLong);
      AppMethodBeat.o(188003);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, localException);
      AppMethodBeat.o(188003);
    }
  }
  
  public final void aM(int paramInt, long paramLong)
  {
    AppMethodBeat.i(188004);
    try
    {
      this.KhT.aH(paramInt, paramLong);
      AppMethodBeat.o(188004);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, localException);
      AppMethodBeat.o(188004);
    }
  }
  
  public final void aN(int paramInt, long paramLong)
  {
    AppMethodBeat.i(188005);
    try
    {
      this.KhT.aI(paramInt, paramLong);
      AppMethodBeat.o(188005);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, localException);
      AppMethodBeat.o(188005);
    }
  }
  
  public final void aTN(String paramString)
  {
    AppMethodBeat.i(188033);
    com.tencent.thumbplayer.utils.f.i(this.TAG, "handleOnDownloadCdnUrlUpdate, url:".concat(String.valueOf(paramString)));
    e(269, 0, 0, paramString);
    AppMethodBeat.o(188033);
  }
  
  public final long aeT(int paramInt)
  {
    AppMethodBeat.i(188018);
    try
    {
      long l = this.KhT.getPropertyLong(paramInt);
      AppMethodBeat.o(188018);
      return l;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, localException);
      AppMethodBeat.o(188018);
    }
    return 0L;
  }
  
  public final String aeU(int paramInt)
  {
    AppMethodBeat.i(188019);
    try
    {
      String str = this.KhT.getPropertyString(paramInt);
      AppMethodBeat.o(188019);
      return str;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, localException);
      AppMethodBeat.o(188019);
    }
    return null;
  }
  
  public final void aeV(int paramInt)
  {
    AppMethodBeat.i(188035);
    e(272, paramInt, 0, null);
    AppMethodBeat.o(188035);
  }
  
  public final void b(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(188030);
    i.c localc = new i.c();
    localc.Kfg = paramInt1;
    localc.Kfh = paramInt2;
    localc.Kfi = paramLong1;
    localc.Kfj = paramLong2;
    com.tencent.thumbplayer.utils.f.i(this.TAG, "handleOnDownloadProgressUpdate");
    a(200, 0, 0, null, new com.tencent.thumbplayer.utils.e().O("speed", Integer.valueOf(paramInt2)).map);
    e(274, 0, 0, localc);
    AppMethodBeat.o(188030);
  }
  
  public final void b(com.tencent.thumbplayer.b.e parame, com.tencent.thumbplayer.b.d paramd)
  {
    AppMethodBeat.i(188027);
    try
    {
      this.KhT.a(parame, paramd);
      AppMethodBeat.o(188027);
      return;
    }
    catch (Exception parame)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, parame);
      AppMethodBeat.o(188027);
    }
  }
  
  public final void b(p paramp)
  {
    AppMethodBeat.i(188000);
    if (paramp != null) {}
    try
    {
      this.KhW.a(paramp);
      this.KhT.a(paramp);
      AppMethodBeat.o(188000);
      return;
    }
    catch (Exception paramp)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, paramp);
      AppMethodBeat.o(188000);
    }
  }
  
  public final void bU(Map<String, String> paramMap)
  {
    AppMethodBeat.i(188037);
    com.tencent.thumbplayer.utils.f.i(this.TAG, "onDownloadCdnUrlExpired");
    e(275, 0, 0, paramMap);
    AppMethodBeat.o(188037);
  }
  
  public final void bc(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(188034);
    i.b localb = new i.b();
    localb.url = paramString1;
    localb.Kfe = paramString2;
    localb.Kfd = paramString3;
    a(201, 0, 0, null, new com.tencent.thumbplayer.utils.e().O("url", paramString1).O("cdnip", paramString2).O("cdnuip", paramString3).map);
    e(270, 0, 0, localb);
    AppMethodBeat.o(188034);
  }
  
  public final void c(com.tencent.thumbplayer.b.f paramf)
  {
    AppMethodBeat.i(187997);
    if ((paramf != null) && (paramf.key == 205))
    {
      this.Kia = paramf.KeR.value;
      AppMethodBeat.o(187997);
      return;
    }
    this.KhW.b(paramf);
    this.KhT.b(paramf);
    AppMethodBeat.o(187997);
  }
  
  public final void cd(float paramFloat)
  {
    AppMethodBeat.i(187987);
    com.tencent.thumbplayer.utils.f.i(this.TAG, KhR + "setAudioGainRatio, gainRatio:" + paramFloat);
    this.KhU.a(18, 0, 0, Float.valueOf(paramFloat), false, true);
    AppMethodBeat.o(187987);
  }
  
  public final void cf(float paramFloat)
  {
    AppMethodBeat.i(188014);
    try
    {
      this.KhT.cd(paramFloat);
      AppMethodBeat.o(188014);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, localException);
      AppMethodBeat.o(188014);
    }
  }
  
  public final void cg(float paramFloat)
  {
    AppMethodBeat.i(188015);
    try
    {
      this.KhT.ce(paramFloat);
      a(116, 0, 0, null, new com.tencent.thumbplayer.utils.e().O("scene", Float.valueOf(paramFloat)).map);
      AppMethodBeat.o(188015);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.thumbplayer.utils.f.e(this.TAG, localException);
      }
    }
  }
  
  public final void d(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(188017);
    try
    {
      this.KhT.c(paramBoolean, paramLong1, paramLong2);
      AppMethodBeat.o(188017);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, localException);
      AppMethodBeat.o(188017);
    }
  }
  
  public final j fEJ()
  {
    AppMethodBeat.i(187996);
    j localj = this.KhT.fEJ();
    AppMethodBeat.o(187996);
    return localj;
  }
  
  public final void fFQ()
  {
    AppMethodBeat.i(188006);
    try
    {
      this.KhT.prepareAsync();
      Object localObject = UUID.randomUUID().toString() + System.nanoTime() + "_" + com.tencent.thumbplayer.e.a.getPlatform();
      a(102, 0, 0, null, new com.tencent.thumbplayer.utils.e().O("stime", Long.valueOf(System.currentTimeMillis())).O("url", this.mUrl).O("p2p", Boolean.valueOf(fGh())).O("flowid", localObject).map);
      localObject = new d.g();
      if (fGh()) {}
      for (long l = 1L;; l = 0L)
      {
        ((d.g)localObject).dya = l;
        e(261, 1009, 0, localObject);
        AppMethodBeat.o(188006);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, localException);
      AppMethodBeat.o(188006);
    }
  }
  
  public final void fFR()
  {
    AppMethodBeat.i(188007);
    try
    {
      this.KhT.start();
      a(104, 0, 0, null, new com.tencent.thumbplayer.utils.e().O("stime", Long.valueOf(System.currentTimeMillis())).map);
      this.KhW.aeL(0);
      AppMethodBeat.o(188007);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, localException);
      AppMethodBeat.o(188007);
    }
  }
  
  public final void fFS()
  {
    AppMethodBeat.i(188008);
    try
    {
      this.KhT.pause();
      a(106, 0, 0, null, new com.tencent.thumbplayer.utils.e().O("stime", Long.valueOf(System.currentTimeMillis())).map);
      this.KhW.aeL(5);
      AppMethodBeat.o(188008);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, localException);
      AppMethodBeat.o(188008);
    }
  }
  
  public final void fFT()
  {
    AppMethodBeat.i(188009);
    try
    {
      this.KhT.stop();
      a(107, 0, 0, null, new com.tencent.thumbplayer.utils.e().O("etime", Long.valueOf(System.currentTimeMillis())).O("reason", Integer.valueOf(1)).map);
      this.KhW.aeL(5);
      AppMethodBeat.o(188009);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, localException);
      AppMethodBeat.o(188009);
    }
  }
  
  public final void fFU()
  {
    AppMethodBeat.i(188010);
    try
    {
      this.KhT.reset();
      a(113, 0, 0, null, new com.tencent.thumbplayer.utils.e().O("etime", Long.valueOf(System.currentTimeMillis())).O("reason", Integer.valueOf(1)).map);
      this.KhW.stopDownload();
      this.Kib = -1;
      this.Kic.clear();
      AppMethodBeat.o(188010);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, localException);
      AppMethodBeat.o(188010);
    }
  }
  
  public final void fFV()
  {
    AppMethodBeat.i(188011);
    try
    {
      this.KhT.release();
      a(112, 0, 0, null, new com.tencent.thumbplayer.utils.e().O("etime", Long.valueOf(System.currentTimeMillis())).O("reason", Integer.valueOf(1)).map);
      if (this.KhZ != null)
      {
        this.KhZ.removeCallbacksAndMessages(null);
        this.KhZ = null;
      }
      c localc = this.KhV;
      localc.Kir = localc.KiC;
      localc.Kis = localc.KiC;
      localc.Kit = localc.KiC;
      localc.Kiu = localc.KiC;
      localc.Kiv = localc.KiC;
      localc.Kiw = localc.KiC;
      localc.Kix = localc.KiC;
      localc.Kiy = localc.KiC;
      localc.Kiz = localc.KiC;
      localc.KiA = localc.KiC;
      localc.KiB = localc.KiC;
      this.KhV = null;
      this.KhW.release();
      this.Kic.clear();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.thumbplayer.utils.f.e(this.TAG, localException);
      }
    }
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    AppMethodBeat.o(188011);
  }
  
  public final long fFW()
  {
    AppMethodBeat.i(188020);
    long l = this.KhT.getDurationMs();
    AppMethodBeat.o(188020);
    return l;
  }
  
  public final long fFX()
  {
    AppMethodBeat.i(188021);
    long l = this.KhT.getCurrentPositionMs();
    AppMethodBeat.o(188021);
    return l;
  }
  
  public final int fFZ()
  {
    AppMethodBeat.i(188023);
    int i = this.KhT.getVideoWidth();
    AppMethodBeat.o(188023);
    return i;
  }
  
  public final void fFd()
  {
    AppMethodBeat.i(187995);
    this.KhW.fFd();
    com.tencent.thumbplayer.b.f localf = new com.tencent.thumbplayer.b.f().aK(502, 1L);
    try
    {
      this.KhT.b(localf);
      AppMethodBeat.o(187995);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, localException.getMessage());
      AppMethodBeat.o(187995);
    }
  }
  
  public final int fGa()
  {
    AppMethodBeat.i(188024);
    int i = this.KhT.getVideoHeight();
    AppMethodBeat.o(188024);
    return i;
  }
  
  public final n[] fGb()
  {
    AppMethodBeat.i(188025);
    n[] arrayOfn = this.KhT.fEO();
    AppMethodBeat.o(188025);
    return arrayOfn;
  }
  
  public final k[] fGc()
  {
    AppMethodBeat.i(188026);
    k[] arrayOfk = this.KhT.fEP();
    AppMethodBeat.o(188026);
    return arrayOfk;
  }
  
  public final void fGd()
  {
    AppMethodBeat.i(188031);
    com.tencent.thumbplayer.utils.f.i(this.TAG, "onDownloadFinish");
    e(271, 0, 0, Integer.valueOf(0));
    AppMethodBeat.o(188031);
  }
  
  public final long fGe()
  {
    AppMethodBeat.i(188039);
    com.tencent.thumbplayer.a.a locala = this.KhT;
    if (locala != null)
    {
      long l = locala.getBufferedDurationMs();
      AppMethodBeat.o(188039);
      return l;
    }
    AppMethodBeat.o(188039);
    return 0L;
  }
  
  public final int fGf()
  {
    AppMethodBeat.i(188040);
    com.tencent.thumbplayer.a.a locala = this.KhT;
    if (locala != null)
    {
      int i = locala.getCurrentPlayClipNo();
      AppMethodBeat.o(188040);
      return i;
    }
    AppMethodBeat.o(188040);
    return 0;
  }
  
  public final long fGg()
  {
    AppMethodBeat.i(188041);
    com.tencent.thumbplayer.b.b.a locala = this.KhW.fFL();
    if (locala != null)
    {
      long l = locala.fFu();
      AppMethodBeat.o(188041);
      return l;
    }
    AppMethodBeat.o(188041);
    return -1L;
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(187990);
    long l = this.KhU.getCurrentPositionMs();
    AppMethodBeat.o(187990);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(187989);
    long l = this.KhU.getDurationMs();
    AppMethodBeat.o(187989);
    return l;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(187993);
    com.tencent.thumbplayer.utils.f.i(this.TAG, KhR + "getVideoHeight");
    b localb = this.KhU;
    localb.fGm();
    localb.a(22, 0, 0, null, false, false);
    localb.fGo();
    localb.fGn();
    int i = localb.Kif.height;
    AppMethodBeat.o(187993);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(187992);
    com.tencent.thumbplayer.utils.f.i(this.TAG, KhR + "getVideoWidth");
    b localb = this.KhU;
    localb.fGm();
    localb.a(21, 0, 0, null, false, false);
    localb.fGo();
    localb.fGn();
    int i = localb.Kif.width;
    AppMethodBeat.o(187992);
    return i;
  }
  
  public final void kF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188012);
    a(109, 0, 0, null, new com.tencent.thumbplayer.utils.e().O("stime", Long.valueOf(System.currentTimeMillis())).O("format", Integer.valueOf(0)).O("pstime", Long.valueOf(fFX())).map);
    if (paramInt2 > 0) {
      this.KhT.kD(paramInt1, paramInt2);
    }
    for (;;)
    {
      this.KhW.aeL(1);
      AppMethodBeat.o(188012);
      return;
      this.KhT.seekTo(paramInt1);
    }
  }
  
  public final void l(Surface paramSurface)
  {
    AppMethodBeat.i(187998);
    this.KhT.setSurface(paramSurface);
    AppMethodBeat.o(187998);
  }
  
  public final void mu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(188036);
    com.tencent.thumbplayer.utils.f.i(this.TAG, "onDownloadProtocolUpdate, protocol:" + paramString1 + ", protocolVer:" + paramString2);
    i.d locald = new i.d();
    locald.Kfl = paramString2;
    locald.Kfk = paramString1;
    e(273, 0, 0, locald);
    AppMethodBeat.o(188036);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(187981);
    com.tencent.thumbplayer.utils.f.i(this.TAG, KhR + "pause");
    this.KhU.a(12, 0, 0, null, false, false);
    AppMethodBeat.o(187981);
  }
  
  public final void pauseDownload()
  {
    AppMethodBeat.i(187994);
    com.tencent.thumbplayer.b.f localf = new com.tencent.thumbplayer.b.f().aK(502, 0L);
    try
    {
      this.KhT.b(localf);
      this.KhW.pauseDownload();
      AppMethodBeat.o(187994);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.thumbplayer.utils.f.e(this.TAG, localException.getMessage());
      }
    }
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(187979);
    com.tencent.thumbplayer.utils.f.i(this.TAG, KhR + "prepareAsync");
    this.KhU.a(10, 0, 0, null, false, false);
    AppMethodBeat.o(187979);
  }
  
  public final void release()
  {
    AppMethodBeat.i(187984);
    com.tencent.thumbplayer.utils.f.i(this.TAG, KhR + "release");
    b localb = this.KhU;
    localb.fGm();
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : release");
    localb.a(15, 0, 0, null, false, false);
    localb.fGo();
    localb.fGn();
    this.KhY.release();
    AppMethodBeat.o(187984);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(187983);
    com.tencent.thumbplayer.utils.f.i(this.TAG, KhR + "reset");
    b localb = this.KhU;
    localb.fGm();
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : reset");
    localb.a(14, 0, 0, null, false, false);
    localb.fGo();
    localb.fGn();
    AppMethodBeat.o(187983);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(187985);
    com.tencent.thumbplayer.utils.f.i(this.TAG, KhR + "seekTo, positionMs:" + paramInt);
    this.KhU.a(16, paramInt, 0, null, false, false);
    AppMethodBeat.o(187985);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(187977);
    com.tencent.thumbplayer.utils.f.i(this.TAG, KhR + "setDataSource, url:" + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("error : setDataSource , data source invalid");
      AppMethodBeat.o(187977);
      throw paramString;
    }
    b localb = this.KhU;
    d.b localb1 = new d.b();
    localb1.url = paramString;
    localb.a(5, 0, 0, localb1, true, false);
    AppMethodBeat.o(187977);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(187976);
    com.tencent.thumbplayer.utils.f.i(this.TAG, KhR + "setSurface, surface:" + paramSurface);
    this.KhU.a(4, 0, 0, paramSurface, false, false);
    AppMethodBeat.o(187976);
  }
  
  public final void start()
  {
    AppMethodBeat.i(187980);
    com.tencent.thumbplayer.utils.f.i(this.TAG, KhR + "start");
    this.KhU.a(11, 0, 0, null, false, false);
    AppMethodBeat.o(187980);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(187982);
    com.tencent.thumbplayer.utils.f.i(this.TAG, KhR + "stop");
    b localb = this.KhU;
    localb.fGm();
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : stop");
    localb.a(13, 0, 0, null, false, false);
    localb.fGo();
    localb.fGn();
    AppMethodBeat.o(187982);
  }
  
  public final void yI(boolean paramBoolean)
  {
    AppMethodBeat.i(187988);
    com.tencent.thumbplayer.utils.f.i(this.TAG, KhR + "setLoopback, isLoopback:" + paramBoolean);
    this.KhU.a(35, 0, 0, Boolean.valueOf(paramBoolean), true, true);
    AppMethodBeat.o(187988);
  }
  
  public final void yJ(boolean paramBoolean)
  {
    AppMethodBeat.i(187986);
    com.tencent.thumbplayer.utils.f.i(this.TAG, KhR + "setOutputMute, isOutputMute:" + paramBoolean);
    this.KhU.a(17, 0, 0, Boolean.valueOf(paramBoolean), false, true);
    AppMethodBeat.o(187986);
  }
  
  public final void yL(boolean paramBoolean)
  {
    AppMethodBeat.i(188013);
    try
    {
      this.KhT.yJ(paramBoolean);
      AppMethodBeat.o(188013);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, localException);
      AppMethodBeat.o(188013);
    }
  }
  
  public final void yM(boolean paramBoolean)
  {
    AppMethodBeat.i(188016);
    try
    {
      this.KhT.yI(paramBoolean);
      AppMethodBeat.o(188016);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.f.e(this.TAG, localException);
      AppMethodBeat.o(188016);
    }
  }
  
  @SuppressLint({"HandlerLeak"})
  final class a
    extends Handler
  {
    private a Kid;
    
    a(a parama)
    {
      this.Kid = parama;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(187945);
      com.tencent.thumbplayer.utils.f.d(a.c(a.this), "mTransformHandler msg : " + paramMessage.what);
      c localc = a.e(a.this);
      if (localc == null)
      {
        AppMethodBeat.o(187945);
        return;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(187945);
        return;
        com.tencent.thumbplayer.utils.f.i(a.c(a.this), "onPrepared");
        localc.a(this.Kid);
        AppMethodBeat.o(187945);
        return;
        localc.b(this.Kid);
        AppMethodBeat.o(187945);
        return;
        d.g localg = (d.g)paramMessage.obj;
        if ((localg != null) && (!a.a(a.this).fFJ()))
        {
          localc.a(this.Kid, paramMessage.arg1, localg.dya, localg.KiP, localg.KiQ);
          AppMethodBeat.o(187945);
          return;
        }
        if (localg != null)
        {
          localc.a(this.Kid, paramMessage.arg1, localg.dya, localg.KiP, localg.KiQ);
          AppMethodBeat.o(187945);
          return;
          localg = (d.g)paramMessage.obj;
          if (localg != null)
          {
            localc.a(this.Kid, paramMessage.arg1, paramMessage.arg2, localg.dya, localg.KiP);
            AppMethodBeat.o(187945);
            return;
            localc.c(this.Kid);
            AppMethodBeat.o(187945);
            return;
            paramMessage = (d.g)paramMessage.obj;
            if (paramMessage != null)
            {
              localc.a(this.Kid, paramMessage.dya, paramMessage.KiP);
              AppMethodBeat.o(187945);
              return;
              localc.a(this.Kid, (m)paramMessage.obj);
              AppMethodBeat.o(187945);
              return;
              localc.a(this.Kid, (o)paramMessage.obj);
              AppMethodBeat.o(187945);
              return;
              localc.a(this.Kid, (com.tencent.thumbplayer.b.c)paramMessage.obj);
              AppMethodBeat.o(187945);
              return;
              localc.a(this.Kid, paramMessage.arg1, paramMessage.arg2, 0L, 0L);
              AppMethodBeat.o(187945);
              return;
              localc.a(this.Kid, 1002, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(187945);
              return;
              localc.a(this.Kid, 1003, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(187945);
              return;
              localc.a(this.Kid, 1001, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(187945);
              return;
              localc.a(this.Kid, 1004, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(187945);
              return;
              localc.a(this.Kid, 1005, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(187945);
              return;
              localc.a(this.Kid, 1006, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(187945);
              return;
              localc.a(this.Kid, 1007, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(187945);
              return;
              localc.a(this.Kid, 1008, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(187945);
              return;
              localc.a(this.Kid, 1010, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(187945);
              return;
              localc.fI(paramMessage.arg1, paramMessage.arg2);
            }
          }
        }
      }
    }
  }
  
  final class b
    implements c.a, c.b, c.c, c.d, c.e, c.f, c.g, c.h, c.i, c.j, ITPPlayListener
  {
    b() {}
    
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(187949);
      Object localObject = a.a(a.this).fFK();
      com.tencent.thumbplayer.utils.f.i(a.c(a.this), "onError playerErrorCodeStr=".concat(String.valueOf(localObject)));
      j = paramInt1;
      i = paramInt2;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        i = Integer.parseInt((String)localObject);
        j = 4000;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.thumbplayer.utils.f.e(a.c(a.this), "onError e=" + localException.getMessage());
          j = paramInt1;
          i = paramInt2;
        }
      }
      a.a(a.this, j, i);
      com.tencent.thumbplayer.utils.f.i(a.c(a.this), "onError errorTypeReal=" + j + ", errorCodeReal=" + i);
      localObject = new d.g();
      ((d.g)localObject).dya = paramLong1;
      ((d.g)localObject).KiP = paramLong2;
      a.a(a.this, 262, j, i, localObject);
      AppMethodBeat.o(187949);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(187948);
      a.a(a.this, paramInt, paramLong1, paramLong2, paramObject);
      if (paramInt == 1011)
      {
        a.a(a.this, paramObject);
        AppMethodBeat.o(187948);
        return;
      }
      if (paramInt == 1012)
      {
        a.b(a.this, paramObject);
        AppMethodBeat.o(187948);
        return;
      }
      d.g localg = new d.g();
      localg.dya = paramLong1;
      localg.KiP = paramLong2;
      localg.KiQ = paramObject;
      a.a(a.this, 261, paramInt, 0, localg);
      AppMethodBeat.o(187948);
    }
    
    public final void a(com.tencent.thumbplayer.b.c paramc)
    {
      AppMethodBeat.i(187955);
      c localc = a.e(a.this);
      if (localc != null) {
        localc.a(a.this, paramc);
      }
      AppMethodBeat.o(187955);
    }
    
    public final void a(m paramm)
    {
      AppMethodBeat.i(187953);
      a.a(a.this, 265, 0, 0, paramm);
      AppMethodBeat.o(187953);
    }
    
    public final void a(o paramo)
    {
      AppMethodBeat.i(187954);
      c localc = a.e(a.this);
      if (localc != null) {
        localc.a(a.this, paramo);
      }
      AppMethodBeat.o(187954);
    }
    
    public final void ay(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(187951);
      d.g localg = new d.g();
      localg.dya = paramLong1;
      localg.KiP = paramLong2;
      a.a(a.this, 264, 0, 0, localg);
      AppMethodBeat.o(187951);
    }
    
    public final void cfM()
    {
      AppMethodBeat.i(187950);
      a.d(a.this);
      a.a(a.this, 110, new com.tencent.thumbplayer.utils.e().O("etime", Long.valueOf(System.currentTimeMillis())).O("petime", Long.valueOf(a.this.fFX())).map);
      a.a(a.this, 263, 0, 0, null);
      AppMethodBeat.o(187950);
    }
    
    public final void fI(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(187952);
      a.a(a.this, 277, paramInt1, paramInt2, null);
      AppMethodBeat.o(187952);
    }
    
    public final long getAdvRemainTime()
    {
      AppMethodBeat.i(187968);
      long l = a.f(a.this).getAdvRemainTime();
      AppMethodBeat.o(187968);
      return l;
    }
    
    public final String getContentType(long paramLong, String paramString)
    {
      AppMethodBeat.i(187974);
      paramString = a.e(a.this).d(a.this, paramLong, paramString);
      AppMethodBeat.o(187974);
      return paramString;
    }
    
    public final int getCurrentPlayClipNo()
    {
      AppMethodBeat.i(187967);
      int i = a.f(a.this).getCurrentPlayClipNo();
      AppMethodBeat.o(187967);
      return i;
    }
    
    public final long getCurrentPosition()
    {
      AppMethodBeat.i(187966);
      long l = a.f(a.this).getCurrentPosition();
      AppMethodBeat.o(187966);
      return l;
    }
    
    public final String getDataFilePath(long paramLong, String paramString)
    {
      AppMethodBeat.i(187973);
      paramString = a.e(a.this).c(a.this, paramLong, paramString);
      AppMethodBeat.o(187973);
      return paramString;
    }
    
    public final long getDataTotalSize(long paramLong, String paramString)
    {
      AppMethodBeat.i(187972);
      paramLong = a.e(a.this).b(a.this, paramLong, paramString);
      AppMethodBeat.o(187972);
      return paramLong;
    }
    
    public final Object getPlayInfo(long paramLong)
    {
      return null;
    }
    
    public final Object getPlayInfo(String paramString)
    {
      return null;
    }
    
    public final long getPlayerBufferLength()
    {
      AppMethodBeat.i(187965);
      long l = a.f(a.this).getPlayerBufferLength();
      AppMethodBeat.o(187965);
      return l;
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(187947);
      a.a(a.this, 111, new com.tencent.thumbplayer.utils.e().O("etime", Long.valueOf(System.currentTimeMillis())).O("reason", Integer.valueOf(0)).map);
      a.a(a.this, 260, 0, 0, null);
      AppMethodBeat.o(187947);
    }
    
    public final void onDownloadCdnUrlExpired(Map<String, String> paramMap)
    {
      AppMethodBeat.i(187963);
      com.tencent.thumbplayer.utils.f.i(a.c(a.this), "onDownloadCdnUrlExpired");
      a.f(a.this).onDownloadCdnUrlExpired(paramMap);
      AppMethodBeat.o(187963);
    }
    
    public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(187960);
      com.tencent.thumbplayer.utils.f.i(a.c(a.this), "onDownloadCdnUrlInfoUpdate, url:" + paramString1 + ", cdnIp:" + paramString2 + ", uip:" + paramString3 + ", errorCodeStr:" + paramString4);
      a.f(a.this).onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(187960);
    }
    
    public final void onDownloadCdnUrlUpdate(String paramString)
    {
      AppMethodBeat.i(187959);
      com.tencent.thumbplayer.utils.f.i(a.c(a.this), "onDownloadCdnUrlUpdate, url:".concat(String.valueOf(paramString)));
      a.f(a.this).onDownloadCdnUrlUpdate(paramString);
      AppMethodBeat.o(187959);
    }
    
    public final void onDownloadError(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(187958);
      com.tencent.thumbplayer.utils.f.i(a.c(a.this), "onDownloadError, moduleID:" + paramInt1 + ", errorCode:" + paramInt2 + ", extInfo:" + paramString);
      a.f(a.this).onDownloadError(4000, paramInt2, paramString);
      AppMethodBeat.o(187958);
    }
    
    public final void onDownloadFinish()
    {
      AppMethodBeat.i(187957);
      com.tencent.thumbplayer.utils.f.i(a.c(a.this), "onDownloadFinish");
      a.f(a.this).onDownloadFinish();
      AppMethodBeat.o(187957);
    }
    
    public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(187956);
      a.f(a.this).onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2);
      AppMethodBeat.o(187956);
    }
    
    public final void onDownloadProtocolUpdate(String paramString1, String paramString2)
    {
      AppMethodBeat.i(187962);
      com.tencent.thumbplayer.utils.f.i(a.c(a.this), "onDownloadProtocolUpdate, protocol:" + paramString1 + ", protocolVer:" + paramString2);
      a.f(a.this).onDownloadProtocolUpdate(paramString1, paramString2);
      AppMethodBeat.o(187962);
    }
    
    public final void onDownloadStatusUpdate(int paramInt)
    {
      AppMethodBeat.i(187961);
      if (paramInt != a.g(a.this))
      {
        com.tencent.thumbplayer.utils.f.i(a.c(a.this), "onDownloadStatusUpdate, status:".concat(String.valueOf(paramInt)));
        a.a(a.this, paramInt);
      }
      a.f(a.this).onDownloadStatusUpdate(paramInt);
      AppMethodBeat.o(187961);
    }
    
    public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      AppMethodBeat.i(187964);
      paramObject1 = a.f(a.this).onPlayCallback(paramInt, paramObject1, paramObject2, paramObject3, paramObject4);
      AppMethodBeat.o(187964);
      return paramObject1;
    }
    
    public final int onReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(187970);
      int i = a.e(a.this).b(a.this, paramLong1, paramString, paramLong2, paramLong3);
      AppMethodBeat.o(187970);
      return i;
    }
    
    public final int onStartReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(187969);
      int i = a.e(a.this).a(a.this, paramLong1, paramString, paramLong2, paramLong3);
      AppMethodBeat.o(187969);
      return i;
    }
    
    public final int onStopReadData(long paramLong, String paramString)
    {
      AppMethodBeat.i(187971);
      int i = a.e(a.this).a(a.this, paramLong, paramString);
      AppMethodBeat.o(187971);
      return i;
    }
    
    public final void rB()
    {
      AppMethodBeat.i(187946);
      a.a(a.this).aeL(0);
      Object localObject1 = a.b(a.this).fEI();
      String str = ((com.tencent.thumbplayer.a.b)localObject1).aQX + "*" + ((com.tencent.thumbplayer.a.b)localObject1).aQY;
      Object localObject2 = a.b(a.this).fEO();
      if (localObject2 != null)
      {
        int m = localObject2.length;
        int j = 0;
        for (int i = 0;; i = k)
        {
          k = i;
          if (j >= m) {
            break;
          }
          k = i;
          if (localObject2[j].trackType == 2) {
            k = i + 1;
          }
          j += 1;
        }
      }
      int k = 0;
      localObject2 = a.this;
      localObject1 = new com.tencent.thumbplayer.utils.e().O("playertype", Integer.valueOf(a.b(a.this).getPlayerType())).O("definition", str).O("rate", Long.valueOf(((com.tencent.thumbplayer.a.b)localObject1).Kcd)).O("duration", Long.valueOf(((com.tencent.thumbplayer.a.b)localObject1).bjU)).O("fmt", ((com.tencent.thumbplayer.a.b)localObject1).KbZ).O("etime", Long.valueOf(System.currentTimeMillis()));
      if (k > 1) {}
      for (boolean bool = true;; bool = false)
      {
        a.a((a)localObject2, 103, ((com.tencent.thumbplayer.utils.e)localObject1).O("multitrack", Boolean.valueOf(bool)).map);
        a.a(a.this, 257, 0, 0, null);
        AppMethodBeat.o(187946);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.g.a
 * JD-Core Version:    0.7.0.1
 */