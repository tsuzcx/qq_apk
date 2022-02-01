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
import com.tencent.thumbplayer.b.e;
import com.tencent.thumbplayer.b.f;
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

public class a
  implements com.tencent.thumbplayer.b.a, b.b
{
  private static String Mbh = "api call:";
  private static int Mbi = 0;
  private com.tencent.thumbplayer.a.a Mbj;
  private b Mbk;
  private c Mbl;
  private com.tencent.thumbplayer.f.a Mbm;
  private com.tencent.thumbplayer.g.a.b Mbn;
  private a Mbo;
  private boolean Mbp;
  private int Mbq;
  private ArrayList<String> Mbr;
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
    AppMethodBeat.i(191996);
    this.TAG = "TPThumbPlayer[TPPlayer.java]";
    this.mUrl = null;
    this.Mbp = true;
    this.Mbq = -1;
    this.TAG = (this.TAG + ", playId:" + Mbi);
    Mbi += 1;
    com.tencent.thumbplayer.utils.d.i(this.TAG, "create TPPlayer");
    this.mContext = paramContext.getApplicationContext();
    this.Mbn = new com.tencent.thumbplayer.g.a.c();
    a(100, 0, 0, null, new com.tencent.thumbplayer.utils.c().Q("stime", Long.valueOf(System.currentTimeMillis())).map);
    this.Mbo = new a(this);
    b localb = new b();
    this.Mbl = new c(this.TAG);
    this.Mbj = new com.tencent.thumbplayer.a.d(this.mContext);
    this.Mbj.a(localb);
    this.Mbj.a(localb);
    this.Mbj.a(localb);
    this.Mbj.a(localb);
    this.Mbj.a(localb);
    this.Mbj.a(localb);
    this.Mbj.a(localb);
    this.Mbj.a(localb);
    this.Mbj.a(localb);
    this.Mbj.a(localb);
    this.Mbj.a(localb);
    this.mHandlerThread = new HandlerThread("TP-workthread");
    this.mHandlerThread.start();
    this.Mbk = new b(this.mHandlerThread.getLooper(), this);
    a(101, 0, 0, null, new com.tencent.thumbplayer.utils.c().Q("etime", Long.valueOf(System.currentTimeMillis())).map);
    this.Mbm = new com.tencent.thumbplayer.f.c(paramContext);
    this.Mbm.a(localb);
    this.Mbn.a(new com.tencent.thumbplayer.g.a.a.b()).a(new com.tencent.thumbplayer.g.a.a.a());
    this.Mbr = new ArrayList();
    AppMethodBeat.o(191996);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    AppMethodBeat.i(192068);
    try
    {
      if (this.Mbn != null) {
        this.Mbn.b(paramInt1, paramInt2, paramInt3, paramString, paramObject);
      }
      AppMethodBeat.o(192068);
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, paramString);
      AppMethodBeat.o(192068);
    }
  }
  
  private void e(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(192069);
    if (this.Mbo != null)
    {
      Message localMessage = this.Mbo.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      this.Mbo.sendMessage(localMessage);
    }
    AppMethodBeat.o(192069);
  }
  
  private boolean fXx()
  {
    AppMethodBeat.i(192065);
    if ((this.Mbm.isEnable()) && (com.tencent.thumbplayer.e.a.fWN()) && (this.Mbp))
    {
      AppMethodBeat.o(192065);
      return true;
    }
    AppMethodBeat.o(192065);
    return false;
  }
  
  private void fXy()
  {
    AppMethodBeat.i(192067);
    if (this.Mbj.isPlaying()) {}
    for (int i = 0;; i = 5)
    {
      this.Mbm.ahl(i);
      AppMethodBeat.o(192067);
      return;
    }
  }
  
  private void kV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192066);
    a(108, paramInt1, paramInt2, "", new com.tencent.thumbplayer.utils.c().Q("etime", Long.valueOf(System.currentTimeMillis())).Q("reason", Integer.valueOf(3)).Q("code", paramInt1 + "." + paramInt2).map);
    this.Mbm.ahl(3);
    AppMethodBeat.o(192066);
  }
  
  public final void T(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(192055);
    com.tencent.thumbplayer.utils.d.i(this.TAG, "handleOnDownloadError, moduleID:" + paramInt1 + ", errorCode:" + paramInt2 + ", extInfo:" + paramString);
    kV(paramInt1, paramInt2);
    e(268, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(192055);
  }
  
  public final Object a(int paramInt, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(192061);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(192061);
      return null;
      com.tencent.thumbplayer.utils.d.i(this.TAG, "onDownloadNoMoreData");
      e(276, 0, 0, paramObject1);
      continue;
      if (!(paramObject2 instanceof Integer)) {
        com.tencent.thumbplayer.utils.d.i(this.TAG, "MESSAGE_NOTIFY_PLAYER_SWITCH_DEFINITION, err.");
      } else {
        e(278, ((Integer)paramObject2).intValue(), 0, null);
      }
    }
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama, long paramLong, p paramp, int paramInt)
  {
    AppMethodBeat.i(192052);
    parama = this.Mbm.a(parama, paramLong, paramp);
    if (parama != null) {
      try
      {
        com.tencent.thumbplayer.utils.d.i(this.TAG, "handleSwitchDef, proxyMediaAsset:" + parama + ", defID:" + paramLong);
        this.Mbj.a(parama, paramInt, paramLong);
        a(120, 0, 0, null, new com.tencent.thumbplayer.utils.c().Q("switch", String.valueOf(paramLong)).map);
        AppMethodBeat.o(192052);
        return;
      }
      catch (Exception parama)
      {
        com.tencent.thumbplayer.utils.d.e(this.TAG, parama);
      }
    }
    AppMethodBeat.o(192052);
  }
  
  public final void a(com.tencent.thumbplayer.b.b.b paramb)
  {
    if (this.Mbl != null) {
      this.Mbl.MbH = paramb;
    }
  }
  
  public final void a(b.c paramc)
  {
    if (this.Mbl != null) {
      this.Mbl.MbJ = paramc;
    }
  }
  
  public final void a(b.d paramd)
  {
    if (this.Mbl != null) {
      this.Mbl.MbI = paramd;
    }
  }
  
  public final void a(b.e parame)
  {
    if (this.Mbl != null) {
      this.Mbl.MbG = parame;
    }
  }
  
  public final void a(b.f paramf)
  {
    if (this.Mbl != null) {
      this.Mbl.MbQ = paramf;
    }
  }
  
  public final void a(b.g paramg)
  {
    if (this.Mbl != null) {
      this.Mbl.MbK = paramg;
    }
  }
  
  public void a(b.h paramh)
  {
    if (this.Mbl != null) {
      this.Mbl.MbP = paramh;
    }
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(192000);
    this.Mbk.a(29, 0, 0, paramp, true, false);
    AppMethodBeat.o(192000);
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(192023);
    if (paramb != null)
    {
      try
      {
        if (!TextUtils.isEmpty(paramb.url))
        {
          this.mUrl = paramb.url;
          if (fXx())
          {
            paramb.url = this.Mbm.aZM(paramb.url);
            com.tencent.thumbplayer.utils.d.i(this.TAG, "handleSetDataSource " + paramb.url);
          }
        }
        while ((!TextUtils.isEmpty(paramb.url)) && (paramb.MbT != null))
        {
          this.Mbj.setDataSource(paramb.url, paramb.MbT);
          AppMethodBeat.o(192023);
          return;
          if (paramb.MbV != null)
          {
            if (fXx()) {
              paramb.MbV = this.Mbm.c(paramb.MbV);
            }
            if (paramb.MbV != null) {
              this.Mbj.a(paramb.MbV);
            }
            AppMethodBeat.o(192023);
            return;
          }
        }
        if (TextUtils.isEmpty(paramb.url)) {
          break label224;
        }
        this.Mbj.setDataSource(paramb.url);
        AppMethodBeat.o(192023);
        return;
      }
      catch (Exception paramb)
      {
        com.tencent.thumbplayer.utils.d.e(this.TAG, paramb);
      }
    }
    else
    {
      AppMethodBeat.o(192023);
      return;
    }
    label224:
    this.Mbj.b(paramb.MbU);
    AppMethodBeat.o(192023);
  }
  
  public final void a(String paramString, long paramLong, p paramp, int paramInt)
  {
    AppMethodBeat.i(192051);
    paramp = this.Mbm.a(paramLong, paramString, paramp);
    if (!TextUtils.isEmpty(paramp)) {
      try
      {
        com.tencent.thumbplayer.utils.d.i(this.TAG, "handleSwitchDef, proxyUrl:" + paramString + ", defID:" + paramLong);
        this.Mbj.M(paramp, paramInt, paramLong);
        a(120, 0, 0, null, new com.tencent.thumbplayer.utils.c().Q("switch", String.valueOf(paramLong)).map);
        AppMethodBeat.o(192051);
        return;
      }
      catch (Exception paramString)
      {
        com.tencent.thumbplayer.utils.d.e(this.TAG, paramString);
      }
    }
    AppMethodBeat.o(192051);
  }
  
  public final void a(String paramString1, String paramString2, com.tencent.thumbplayer.b.b.b paramb)
  {
    AppMethodBeat.i(192026);
    if (!fXx())
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, "handleAddAudioSource, proxy is not enable.");
      AppMethodBeat.o(192026);
      return;
    }
    if ((TextUtils.isEmpty(paramString2)) || (!com.tencent.thumbplayer.utils.a.aXf(paramString1)))
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, "handleAddAudioSource, illegal argument.");
      AppMethodBeat.o(192026);
      return;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      f localf = new f();
      if (paramb != null)
      {
        paramb = paramb.LZp;
        localf.LYM = 3;
        localf.key = 6;
        localf.LYP = new f.e();
        localf.LYP.value = paramb;
      }
      localArrayList.add(localf);
      this.Mbj.g(paramString1, paramString2, localArrayList);
      AppMethodBeat.o(192026);
      return;
    }
    catch (Exception paramString1)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, paramString1);
      AppMethodBeat.o(192026);
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, com.tencent.thumbplayer.b.b.b paramb)
  {
    AppMethodBeat.i(192025);
    try
    {
      long l = System.currentTimeMillis();
      if ((fXx()) && (com.tencent.thumbplayer.utils.a.aXf(paramString1)))
      {
        paramb = this.Mbm.a(3, paramString1, paramb);
        this.Mbr.add(paramb);
        this.Mbj.bk(paramb, paramString2, paramString3);
      }
      for (;;)
      {
        a(118, 0, 0, null, new com.tencent.thumbplayer.utils.c().Q("stime", Long.valueOf(l)).Q("etime", Long.valueOf(System.currentTimeMillis())).Q("url", paramString1).map);
        AppMethodBeat.o(192025);
        return;
        this.Mbj.bk(paramString1, paramString2, paramString3);
      }
      return;
    }
    catch (Exception paramString1)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, paramString1);
      AppMethodBeat.o(192025);
    }
  }
  
  public final void aV(int paramInt, long paramLong)
  {
    AppMethodBeat.i(192027);
    try
    {
      n[] arrayOfn = this.Mbj.fWg();
      if ((arrayOfn != null) && (arrayOfn.length > paramInt)) {
        a(122, 0, 0, null, new com.tencent.thumbplayer.utils.c().Q("opaque", Long.valueOf(paramLong)).Q("tracktype", Integer.valueOf(arrayOfn[paramInt].trackType)).Q("stime", Long.valueOf(System.currentTimeMillis())).map);
      }
      this.Mbj.aQ(paramInt, paramLong);
      AppMethodBeat.o(192027);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(192027);
    }
  }
  
  public final void aW(int paramInt, long paramLong)
  {
    AppMethodBeat.i(192028);
    try
    {
      this.Mbj.aR(paramInt, paramLong);
      AppMethodBeat.o(192028);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(192028);
    }
  }
  
  public final void aX(int paramInt, long paramLong)
  {
    AppMethodBeat.i(192029);
    try
    {
      this.Mbj.aS(paramInt, paramLong);
      AppMethodBeat.o(192029);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(192029);
    }
  }
  
  public final void aZN(String paramString)
  {
    AppMethodBeat.i(192056);
    com.tencent.thumbplayer.utils.d.i(this.TAG, "handleOnDownloadCdnUrlUpdate, url:".concat(String.valueOf(paramString)));
    e(269, 0, 0, paramString);
    AppMethodBeat.o(192056);
  }
  
  public final long aht(int paramInt)
  {
    AppMethodBeat.i(192042);
    try
    {
      long l = this.Mbj.getPropertyLong(paramInt);
      AppMethodBeat.o(192042);
      return l;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(192042);
    }
    return 0L;
  }
  
  public final String ahu(int paramInt)
  {
    AppMethodBeat.i(192043);
    try
    {
      String str = this.Mbj.getPropertyString(paramInt);
      AppMethodBeat.o(192043);
      return str;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(192043);
    }
    return null;
  }
  
  public final void ahv(int paramInt)
  {
    AppMethodBeat.i(192058);
    e(272, paramInt, 0, null);
    AppMethodBeat.o(192058);
  }
  
  public final void b(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(192053);
    i.c localc = new i.c();
    localc.LZc = paramInt1;
    localc.LZd = paramInt2;
    localc.LZe = paramLong1;
    localc.EKH = paramLong2;
    com.tencent.thumbplayer.utils.d.i(this.TAG, "handleOnDownloadProgressUpdate");
    a(200, 0, 0, null, new com.tencent.thumbplayer.utils.c().Q("speed", Integer.valueOf(paramInt2)).map);
    e(274, 0, 0, localc);
    AppMethodBeat.o(192053);
  }
  
  public final void b(e parame, com.tencent.thumbplayer.b.d paramd)
  {
    AppMethodBeat.i(192050);
    try
    {
      this.Mbj.a(parame, paramd);
      AppMethodBeat.o(192050);
      return;
    }
    catch (Exception parame)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, parame);
      AppMethodBeat.o(192050);
    }
  }
  
  public final void b(f paramf)
  {
    AppMethodBeat.i(191997);
    this.Mbk.a(1, 0, 0, paramf, true, false);
    AppMethodBeat.o(191997);
  }
  
  public final void b(p paramp)
  {
    AppMethodBeat.i(192024);
    if (paramp != null) {}
    try
    {
      this.Mbm.a(paramp);
      this.Mbj.a(paramp);
      AppMethodBeat.o(192024);
      return;
    }
    catch (Exception paramp)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, paramp);
      AppMethodBeat.o(192024);
    }
  }
  
  public final void bl(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(192057);
    i.b localb = new i.b();
    localb.url = paramString1;
    localb.LZa = paramString2;
    localb.LYZ = paramString3;
    a(201, 0, 0, null, new com.tencent.thumbplayer.utils.c().Q("url", paramString1).Q("cdnip", paramString2).Q("cdnuip", paramString3).map);
    e(270, 0, 0, localb);
    AppMethodBeat.o(192057);
  }
  
  public final void c(f paramf)
  {
    AppMethodBeat.i(192021);
    if ((paramf != null) && (paramf.key == 205))
    {
      this.Mbp = paramf.LYN.value;
      AppMethodBeat.o(192021);
      return;
    }
    this.Mbm.b(paramf);
    this.Mbj.b(paramf);
    AppMethodBeat.o(192021);
  }
  
  public final void ca(Map<String, String> paramMap)
  {
    AppMethodBeat.i(192060);
    com.tencent.thumbplayer.utils.d.i(this.TAG, "onDownloadCdnUrlExpired");
    e(275, 0, 0, paramMap);
    AppMethodBeat.o(192060);
  }
  
  public final void ci(float paramFloat)
  {
    AppMethodBeat.i(192009);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Mbh + "setAudioGainRatio, gainRatio:" + paramFloat);
    this.Mbk.a(18, 0, 0, Float.valueOf(paramFloat), false, true);
    AppMethodBeat.o(192009);
  }
  
  public final void ck(float paramFloat)
  {
    AppMethodBeat.i(192038);
    try
    {
      this.Mbj.ci(paramFloat);
      AppMethodBeat.o(192038);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(192038);
    }
  }
  
  public final void cl(float paramFloat)
  {
    AppMethodBeat.i(192039);
    try
    {
      this.Mbj.cj(paramFloat);
      a(116, 0, 0, null, new com.tencent.thumbplayer.utils.c().Q("scene", Float.valueOf(paramFloat)).map);
      AppMethodBeat.o(192039);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      }
    }
  }
  
  public final void d(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(192041);
    try
    {
      this.Mbj.c(paramBoolean, paramLong1, paramLong2);
      AppMethodBeat.o(192041);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(192041);
    }
  }
  
  public final j fWb()
  {
    AppMethodBeat.i(192020);
    j localj = this.Mbj.fWb();
    AppMethodBeat.o(192020);
    return localj;
  }
  
  public final void fWu()
  {
    AppMethodBeat.i(192018);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Mbh + "resumeDownload");
    this.Mbk.a(42, 0, 0, null, false, false);
    AppMethodBeat.o(192018);
  }
  
  public final void fXf()
  {
    AppMethodBeat.i(192017);
    f localf = new f().aU(502, 0L);
    try
    {
      this.Mbj.b(localf);
      this.Mbm.pauseDownload();
      AppMethodBeat.o(192017);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.thumbplayer.utils.d.e(this.TAG, localException.getMessage());
      }
    }
  }
  
  public final void fXg()
  {
    AppMethodBeat.i(192019);
    this.Mbm.fWu();
    f localf = new f().aU(502, 1L);
    try
    {
      this.Mbj.b(localf);
      AppMethodBeat.o(192019);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException.getMessage());
      AppMethodBeat.o(192019);
    }
  }
  
  public final void fXh()
  {
    AppMethodBeat.i(192030);
    try
    {
      this.Mbj.prepareAsync();
      Object localObject = UUID.randomUUID().toString() + System.nanoTime() + "_" + com.tencent.thumbplayer.e.a.getPlatform();
      a(102, 0, 0, null, new com.tencent.thumbplayer.utils.c().Q("stime", Long.valueOf(System.currentTimeMillis())).Q("url", this.mUrl).Q("p2p", Boolean.valueOf(fXx())).Q("flowid", localObject).map);
      localObject = new d.g();
      if (fXx()) {}
      for (long l = 1L;; l = 0L)
      {
        ((d.g)localObject).dKn = l;
        e(261, 1009, 0, localObject);
        AppMethodBeat.o(192030);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(192030);
    }
  }
  
  public final void fXi()
  {
    AppMethodBeat.i(192031);
    try
    {
      this.Mbj.start();
      a(104, 0, 0, null, new com.tencent.thumbplayer.utils.c().Q("stime", Long.valueOf(System.currentTimeMillis())).map);
      this.Mbm.ahl(0);
      AppMethodBeat.o(192031);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(192031);
    }
  }
  
  public final void fXj()
  {
    AppMethodBeat.i(192032);
    try
    {
      this.Mbj.pause();
      a(106, 0, 0, null, new com.tencent.thumbplayer.utils.c().Q("stime", Long.valueOf(System.currentTimeMillis())).map);
      this.Mbm.ahl(5);
      AppMethodBeat.o(192032);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(192032);
    }
  }
  
  public final void fXk()
  {
    AppMethodBeat.i(192033);
    try
    {
      this.Mbj.stop();
      a(107, 0, 0, null, new com.tencent.thumbplayer.utils.c().Q("etime", Long.valueOf(System.currentTimeMillis())).Q("reason", Integer.valueOf(1)).map);
      this.Mbm.ahl(5);
      AppMethodBeat.o(192033);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(192033);
    }
  }
  
  public final void fXl()
  {
    AppMethodBeat.i(192034);
    try
    {
      this.Mbj.reset();
      a(113, 0, 0, null, new com.tencent.thumbplayer.utils.c().Q("etime", Long.valueOf(System.currentTimeMillis())).Q("reason", Integer.valueOf(1)).map);
      this.Mbm.stopDownload();
      this.Mbq = -1;
      this.Mbr.clear();
      AppMethodBeat.o(192034);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(192034);
    }
  }
  
  public final void fXm()
  {
    AppMethodBeat.i(192035);
    try
    {
      this.Mbj.release();
      a(112, 0, 0, null, new com.tencent.thumbplayer.utils.c().Q("etime", Long.valueOf(System.currentTimeMillis())).Q("reason", Integer.valueOf(1)).map);
      if (this.Mbo != null)
      {
        this.Mbo.removeCallbacksAndMessages(null);
        this.Mbo = null;
      }
      c localc = this.Mbl;
      localc.MbG = localc.MbR;
      localc.MbH = localc.MbR;
      localc.MbI = localc.MbR;
      localc.MbJ = localc.MbR;
      localc.MbK = localc.MbR;
      localc.MbL = localc.MbR;
      localc.MbM = localc.MbR;
      localc.MbN = localc.MbR;
      localc.MbO = localc.MbR;
      localc.MbP = localc.MbR;
      localc.MbQ = localc.MbR;
      this.Mbl = null;
      this.Mbm.release();
      this.Mbr.clear();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      }
    }
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    AppMethodBeat.o(192035);
  }
  
  public final long fXn()
  {
    AppMethodBeat.i(192044);
    long l = this.Mbj.getDurationMs();
    AppMethodBeat.o(192044);
    return l;
  }
  
  public final long fXo()
  {
    AppMethodBeat.i(192045);
    long l = this.Mbj.getCurrentPositionMs();
    AppMethodBeat.o(192045);
    return l;
  }
  
  public final int fXp()
  {
    AppMethodBeat.i(192046);
    int i = this.Mbj.getVideoWidth();
    AppMethodBeat.o(192046);
    return i;
  }
  
  public final int fXq()
  {
    AppMethodBeat.i(192047);
    int i = this.Mbj.getVideoHeight();
    AppMethodBeat.o(192047);
    return i;
  }
  
  public final n[] fXr()
  {
    AppMethodBeat.i(192048);
    n[] arrayOfn = this.Mbj.fWg();
    AppMethodBeat.o(192048);
    return arrayOfn;
  }
  
  public final k[] fXs()
  {
    AppMethodBeat.i(192049);
    k[] arrayOfk = this.Mbj.fWh();
    AppMethodBeat.o(192049);
    return arrayOfk;
  }
  
  public final void fXt()
  {
    AppMethodBeat.i(192054);
    com.tencent.thumbplayer.utils.d.i(this.TAG, "onDownloadFinish");
    e(271, 0, 0, Integer.valueOf(0));
    AppMethodBeat.o(192054);
  }
  
  public final long fXu()
  {
    AppMethodBeat.i(192062);
    com.tencent.thumbplayer.a.a locala = this.Mbj;
    if (locala != null)
    {
      long l = locala.getBufferedDurationMs();
      AppMethodBeat.o(192062);
      return l;
    }
    AppMethodBeat.o(192062);
    return 0L;
  }
  
  public final int fXv()
  {
    AppMethodBeat.i(192063);
    com.tencent.thumbplayer.a.a locala = this.Mbj;
    if (locala != null)
    {
      int i = locala.getCurrentPlayClipNo();
      AppMethodBeat.o(192063);
      return i;
    }
    AppMethodBeat.o(192063);
    return 0;
  }
  
  public final long fXw()
  {
    AppMethodBeat.i(192064);
    com.tencent.thumbplayer.b.b.a locala = this.Mbm.fXa();
    if (locala != null)
    {
      long l = locala.fWJ();
      AppMethodBeat.o(192064);
      return l;
    }
    AppMethodBeat.o(192064);
    return -1L;
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(192013);
    long l = this.Mbk.getCurrentPositionMs();
    AppMethodBeat.o(192013);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(192012);
    long l = this.Mbk.getDurationMs();
    AppMethodBeat.o(192012);
    return l;
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(192011);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Mbh + "getPropertyLong, paramId:" + paramInt);
    b localb = this.Mbk;
    localb.fXC();
    localb.Mbx = 0L;
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get property long");
    localb.a(27, paramInt, 0, null, false, false);
    localb.fXE();
    localb.fXD();
    long l = localb.Mbx;
    AppMethodBeat.o(192011);
    return l;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(192015);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Mbh + "getVideoHeight");
    b localb = this.Mbk;
    localb.fXC();
    localb.a(22, 0, 0, null, false, false);
    localb.fXE();
    localb.fXD();
    int i = localb.Mbu.height;
    AppMethodBeat.o(192015);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(192014);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Mbh + "getVideoWidth");
    b localb = this.Mbk;
    localb.fXC();
    localb.a(21, 0, 0, null, false, false);
    localb.fXE();
    localb.fXD();
    int i = localb.Mbu.width;
    AppMethodBeat.o(192014);
    return i;
  }
  
  public final void kU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192036);
    a(109, 0, 0, null, new com.tencent.thumbplayer.utils.c().Q("stime", Long.valueOf(System.currentTimeMillis())).Q("format", Integer.valueOf(0)).Q("pstime", Long.valueOf(fXo())).map);
    if (paramInt2 > 0) {
      this.Mbj.kS(paramInt1, paramInt2);
    }
    for (;;)
    {
      this.Mbm.ahl(1);
      AppMethodBeat.o(192036);
      return;
      this.Mbj.seekTo(paramInt1);
    }
  }
  
  public final void l(Surface paramSurface)
  {
    AppMethodBeat.i(192022);
    this.Mbj.setSurface(paramSurface);
    AppMethodBeat.o(192022);
  }
  
  public final void mS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192059);
    com.tencent.thumbplayer.utils.d.i(this.TAG, "onDownloadProtocolUpdate, protocol:" + paramString1 + ", protocolVer:" + paramString2);
    i.d locald = new i.d();
    locald.LZg = paramString2;
    locald.LZf = paramString1;
    e(273, 0, 0, locald);
    AppMethodBeat.o(192059);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(192003);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Mbh + "pause");
    this.Mbk.a(12, 0, 0, null, false, false);
    AppMethodBeat.o(192003);
  }
  
  public final void pauseDownload()
  {
    AppMethodBeat.i(192016);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Mbh + "pauseDownload");
    this.Mbk.a(41, 0, 0, null, false, false);
    AppMethodBeat.o(192016);
  }
  
  public void prepareAsync()
  {
    AppMethodBeat.i(192001);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Mbh + "prepareAsync");
    this.Mbk.a(10, 0, 0, null, false, false);
    AppMethodBeat.o(192001);
  }
  
  public final void release()
  {
    AppMethodBeat.i(192006);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Mbh + "release");
    b localb = this.Mbk;
    localb.fXC();
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : release");
    localb.a(15, 0, 0, null, false, false);
    localb.fXE();
    localb.fXD();
    this.Mbn.release();
    AppMethodBeat.o(192006);
  }
  
  public void reset()
  {
    AppMethodBeat.i(192005);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Mbh + "reset");
    b localb = this.Mbk;
    localb.fXC();
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : reset");
    localb.a(14, 0, 0, null, false, false);
    localb.fXE();
    localb.fXD();
    AppMethodBeat.o(192005);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(192007);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Mbh + "seekTo, positionMs:" + paramInt);
    this.Mbk.a(16, paramInt, 0, null, false, false);
    AppMethodBeat.o(192007);
  }
  
  public void setDataSource(String paramString)
  {
    AppMethodBeat.i(191999);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Mbh + "setDataSource, url:" + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("error : setDataSource , data source invalid");
      AppMethodBeat.o(191999);
      throw paramString;
    }
    b localb = this.Mbk;
    d.b localb1 = new d.b();
    localb1.url = paramString;
    localb.a(5, 0, 0, localb1, true, false);
    AppMethodBeat.o(191999);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(191998);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Mbh + "setSurface, surface:" + paramSurface);
    this.Mbk.a(4, 0, 0, paramSurface, false, false);
    AppMethodBeat.o(191998);
  }
  
  public final void start()
  {
    AppMethodBeat.i(192002);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Mbh + "start");
    this.Mbk.a(11, 0, 0, null, false, false);
    AppMethodBeat.o(192002);
  }
  
  public void stop()
  {
    AppMethodBeat.i(192004);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Mbh + "stop");
    b localb = this.Mbk;
    localb.fXC();
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : stop");
    localb.a(13, 0, 0, null, false, false);
    localb.fXE();
    localb.fXD();
    AppMethodBeat.o(192004);
  }
  
  public final void zv(boolean paramBoolean)
  {
    AppMethodBeat.i(192010);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Mbh + "setLoopback, isLoopback:" + paramBoolean);
    this.Mbk.a(35, 0, 0, Boolean.valueOf(paramBoolean), true, true);
    AppMethodBeat.o(192010);
  }
  
  public final void zw(boolean paramBoolean)
  {
    AppMethodBeat.i(192008);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Mbh + "setOutputMute, isOutputMute:" + paramBoolean);
    this.Mbk.a(17, 0, 0, Boolean.valueOf(paramBoolean), false, true);
    AppMethodBeat.o(192008);
  }
  
  public final void zy(boolean paramBoolean)
  {
    AppMethodBeat.i(192037);
    try
    {
      this.Mbj.zw(paramBoolean);
      AppMethodBeat.o(192037);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(192037);
    }
  }
  
  public final void zz(boolean paramBoolean)
  {
    AppMethodBeat.i(192040);
    try
    {
      this.Mbj.zv(paramBoolean);
      AppMethodBeat.o(192040);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(192040);
    }
  }
  
  @SuppressLint({"HandlerLeak"})
  final class a
    extends Handler
  {
    private a Mbs;
    
    a(a parama)
    {
      this.Mbs = parama;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(191966);
      com.tencent.thumbplayer.utils.d.d(a.c(a.this), "mTransformHandler msg : " + paramMessage.what);
      c localc = a.e(a.this);
      if (localc == null)
      {
        AppMethodBeat.o(191966);
        return;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(191966);
        return;
        com.tencent.thumbplayer.utils.d.i(a.c(a.this), "onPrepared");
        localc.a(this.Mbs);
        AppMethodBeat.o(191966);
        return;
        localc.b(this.Mbs);
        AppMethodBeat.o(191966);
        return;
        d.g localg = (d.g)paramMessage.obj;
        if ((localg != null) && (!a.a(a.this).fWY()))
        {
          localc.a(this.Mbs, paramMessage.arg1, localg.dKn, localg.Mce, localg.Mcf);
          AppMethodBeat.o(191966);
          return;
        }
        if (localg != null)
        {
          localc.a(this.Mbs, paramMessage.arg1, localg.dKn, localg.Mce, localg.Mcf);
          AppMethodBeat.o(191966);
          return;
          localg = (d.g)paramMessage.obj;
          if (localg != null)
          {
            localc.a(this.Mbs, paramMessage.arg1, paramMessage.arg2, localg.dKn, localg.Mce);
            AppMethodBeat.o(191966);
            return;
            localc.c(this.Mbs);
            AppMethodBeat.o(191966);
            return;
            paramMessage = (d.g)paramMessage.obj;
            if (paramMessage != null)
            {
              localc.a(this.Mbs, paramMessage.dKn, paramMessage.Mce);
              AppMethodBeat.o(191966);
              return;
              localc.a(this.Mbs, (m)paramMessage.obj);
              AppMethodBeat.o(191966);
              return;
              localc.a(this.Mbs, (o)paramMessage.obj);
              AppMethodBeat.o(191966);
              return;
              localc.a(this.Mbs, (com.tencent.thumbplayer.b.c)paramMessage.obj);
              AppMethodBeat.o(191966);
              return;
              localc.a(this.Mbs, paramMessage.arg1, paramMessage.arg2, 0L, 0L);
              AppMethodBeat.o(191966);
              return;
              localc.a(this.Mbs, 1002, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(191966);
              return;
              localc.a(this.Mbs, 1003, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(191966);
              return;
              localc.a(this.Mbs, 1001, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(191966);
              return;
              localc.a(this.Mbs, 1004, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(191966);
              return;
              localc.a(this.Mbs, 1005, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(191966);
              return;
              localc.a(this.Mbs, 1006, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(191966);
              return;
              localc.a(this.Mbs, 1007, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(191966);
              return;
              localc.a(this.Mbs, 1008, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(191966);
              return;
              localc.a(this.Mbs, 1010, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(191966);
              return;
              localc.fW(paramMessage.arg1, paramMessage.arg2);
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
      AppMethodBeat.i(191970);
      Object localObject = a.a(a.this).fWZ();
      com.tencent.thumbplayer.utils.d.i(a.c(a.this), "onError playerErrorCodeStr=".concat(String.valueOf(localObject)));
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
          com.tencent.thumbplayer.utils.d.e(a.c(a.this), "onError e=" + localException.getMessage());
          j = paramInt1;
          i = paramInt2;
        }
      }
      a.a(a.this, j, i);
      com.tencent.thumbplayer.utils.d.i(a.c(a.this), "onError errorTypeReal=" + j + ", errorCodeReal=" + i);
      localObject = new d.g();
      ((d.g)localObject).dKn = paramLong1;
      ((d.g)localObject).Mce = paramLong2;
      a.a(a.this, 262, j, i, localObject);
      AppMethodBeat.o(191970);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(191969);
      a.a(a.this, paramInt, paramLong1, paramLong2, paramObject);
      if (paramInt == 1011)
      {
        a.a(a.this, paramObject);
        AppMethodBeat.o(191969);
        return;
      }
      if (paramInt == 1012)
      {
        a.b(a.this, paramObject);
        AppMethodBeat.o(191969);
        return;
      }
      d.g localg = new d.g();
      localg.dKn = paramLong1;
      localg.Mce = paramLong2;
      localg.Mcf = paramObject;
      a.a(a.this, 261, paramInt, 0, localg);
      AppMethodBeat.o(191969);
    }
    
    public final void a(com.tencent.thumbplayer.b.c paramc)
    {
      AppMethodBeat.i(191976);
      c localc = a.e(a.this);
      if (localc != null) {
        localc.a(a.this, paramc);
      }
      AppMethodBeat.o(191976);
    }
    
    public final void a(m paramm)
    {
      AppMethodBeat.i(191974);
      a.a(a.this, 265, 0, 0, paramm);
      AppMethodBeat.o(191974);
    }
    
    public final void a(o paramo)
    {
      AppMethodBeat.i(191975);
      c localc = a.e(a.this);
      if (localc != null) {
        localc.a(a.this, paramo);
      }
      AppMethodBeat.o(191975);
    }
    
    public final void aD(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(191972);
      d.g localg = new d.g();
      localg.dKn = paramLong1;
      localg.Mce = paramLong2;
      a.a(a.this, 264, 0, 0, localg);
      AppMethodBeat.o(191972);
    }
    
    public final void ckp()
    {
      AppMethodBeat.i(191971);
      a.d(a.this);
      a.a(a.this, 110, new com.tencent.thumbplayer.utils.c().Q("etime", Long.valueOf(System.currentTimeMillis())).Q("petime", Long.valueOf(a.this.fXo())).map);
      a.a(a.this, 263, 0, 0, null);
      AppMethodBeat.o(191971);
    }
    
    public final void fW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(191973);
      a.a(a.this, 277, paramInt1, paramInt2, null);
      AppMethodBeat.o(191973);
    }
    
    public final long getAdvRemainTime()
    {
      AppMethodBeat.i(191989);
      long l = a.f(a.this).getAdvRemainTime();
      AppMethodBeat.o(191989);
      return l;
    }
    
    public final String getContentType(long paramLong, String paramString)
    {
      AppMethodBeat.i(191995);
      paramString = a.e(a.this).d(a.this, paramLong, paramString);
      AppMethodBeat.o(191995);
      return paramString;
    }
    
    public final int getCurrentPlayClipNo()
    {
      AppMethodBeat.i(191988);
      int i = a.f(a.this).getCurrentPlayClipNo();
      AppMethodBeat.o(191988);
      return i;
    }
    
    public final long getCurrentPosition()
    {
      AppMethodBeat.i(191987);
      long l = a.f(a.this).getCurrentPosition();
      AppMethodBeat.o(191987);
      return l;
    }
    
    public final String getDataFilePath(long paramLong, String paramString)
    {
      AppMethodBeat.i(191994);
      paramString = a.e(a.this).c(a.this, paramLong, paramString);
      AppMethodBeat.o(191994);
      return paramString;
    }
    
    public final long getDataTotalSize(long paramLong, String paramString)
    {
      AppMethodBeat.i(191993);
      paramLong = a.e(a.this).b(a.this, paramLong, paramString);
      AppMethodBeat.o(191993);
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
      AppMethodBeat.i(191986);
      long l = a.f(a.this).getPlayerBufferLength();
      AppMethodBeat.o(191986);
      return l;
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(191968);
      a.a(a.this, 111, new com.tencent.thumbplayer.utils.c().Q("etime", Long.valueOf(System.currentTimeMillis())).Q("reason", Integer.valueOf(0)).map);
      a.a(a.this, 260, 0, 0, null);
      AppMethodBeat.o(191968);
    }
    
    public final void onDownloadCdnUrlExpired(Map<String, String> paramMap)
    {
      AppMethodBeat.i(191984);
      com.tencent.thumbplayer.utils.d.i(a.c(a.this), "onDownloadCdnUrlExpired");
      a.f(a.this).onDownloadCdnUrlExpired(paramMap);
      AppMethodBeat.o(191984);
    }
    
    public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(191981);
      com.tencent.thumbplayer.utils.d.i(a.c(a.this), "onDownloadCdnUrlInfoUpdate, url:" + paramString1 + ", cdnIp:" + paramString2 + ", uip:" + paramString3 + ", errorCodeStr:" + paramString4);
      a.f(a.this).onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(191981);
    }
    
    public final void onDownloadCdnUrlUpdate(String paramString)
    {
      AppMethodBeat.i(191980);
      com.tencent.thumbplayer.utils.d.i(a.c(a.this), "onDownloadCdnUrlUpdate, url:".concat(String.valueOf(paramString)));
      a.f(a.this).onDownloadCdnUrlUpdate(paramString);
      AppMethodBeat.o(191980);
    }
    
    public final void onDownloadError(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(191979);
      com.tencent.thumbplayer.utils.d.i(a.c(a.this), "onDownloadError, moduleID:" + paramInt1 + ", errorCode:" + paramInt2 + ", extInfo:" + paramString);
      a.f(a.this).onDownloadError(4000, paramInt2, paramString);
      AppMethodBeat.o(191979);
    }
    
    public final void onDownloadFinish()
    {
      AppMethodBeat.i(191978);
      com.tencent.thumbplayer.utils.d.i(a.c(a.this), "onDownloadFinish");
      a.f(a.this).onDownloadFinish();
      AppMethodBeat.o(191978);
    }
    
    public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(191977);
      a.f(a.this).onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2);
      AppMethodBeat.o(191977);
    }
    
    public final void onDownloadProtocolUpdate(String paramString1, String paramString2)
    {
      AppMethodBeat.i(191983);
      com.tencent.thumbplayer.utils.d.i(a.c(a.this), "onDownloadProtocolUpdate, protocol:" + paramString1 + ", protocolVer:" + paramString2);
      a.f(a.this).onDownloadProtocolUpdate(paramString1, paramString2);
      AppMethodBeat.o(191983);
    }
    
    public final void onDownloadStatusUpdate(int paramInt)
    {
      AppMethodBeat.i(191982);
      if (paramInt != a.g(a.this))
      {
        com.tencent.thumbplayer.utils.d.i(a.c(a.this), "onDownloadStatusUpdate, status:".concat(String.valueOf(paramInt)));
        a.a(a.this, paramInt);
      }
      a.f(a.this).onDownloadStatusUpdate(paramInt);
      AppMethodBeat.o(191982);
    }
    
    public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      AppMethodBeat.i(191985);
      paramObject1 = a.f(a.this).onPlayCallback(paramInt, paramObject1, paramObject2, paramObject3, paramObject4);
      AppMethodBeat.o(191985);
      return paramObject1;
    }
    
    public final int onReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(191991);
      int i = a.e(a.this).b(a.this, paramLong1, paramString, paramLong2, paramLong3);
      AppMethodBeat.o(191991);
      return i;
    }
    
    public final int onStartReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(191990);
      int i = a.e(a.this).a(a.this, paramLong1, paramString, paramLong2, paramLong3);
      AppMethodBeat.o(191990);
      return i;
    }
    
    public final int onStopReadData(long paramLong, String paramString)
    {
      AppMethodBeat.i(191992);
      int i = a.e(a.this).a(a.this, paramLong, paramString);
      AppMethodBeat.o(191992);
      return i;
    }
    
    public final void ta()
    {
      AppMethodBeat.i(191967);
      a.a(a.this).ahl(0);
      Object localObject1 = a.b(a.this).fWa();
      String str = ((com.tencent.thumbplayer.a.b)localObject1).bbs + "*" + ((com.tencent.thumbplayer.a.b)localObject1).bbt;
      Object localObject2 = a.b(a.this).fWg();
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
      localObject1 = new com.tencent.thumbplayer.utils.c().Q("playertype", Integer.valueOf(a.b(a.this).getPlayerType())).Q("definition", str).Q("rate", Long.valueOf(((com.tencent.thumbplayer.a.b)localObject1).LVZ)).Q("duration", Long.valueOf(((com.tencent.thumbplayer.a.b)localObject1).bup)).Q("fmt", ((com.tencent.thumbplayer.a.b)localObject1).LVV).Q("etime", Long.valueOf(System.currentTimeMillis()));
      if (k > 1) {}
      for (boolean bool = true;; bool = false)
      {
        a.a((a)localObject2, 103, ((com.tencent.thumbplayer.utils.c)localObject1).Q("multitrack", Boolean.valueOf(bool)).map);
        a.a(a.this, 257, 0, 0, null);
        AppMethodBeat.o(191967);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.g.a
 * JD-Core Version:    0.7.0.1
 */