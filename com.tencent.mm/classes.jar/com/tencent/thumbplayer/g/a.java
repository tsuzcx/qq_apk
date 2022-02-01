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
  private static String Myc = "api call:";
  private static int Myd = 0;
  private com.tencent.thumbplayer.a.a Mye;
  private b Myf;
  private c Myg;
  private com.tencent.thumbplayer.f.a Myh;
  private com.tencent.thumbplayer.g.a.b Myi;
  private a Myj;
  private boolean Myk;
  private int Myl;
  private ArrayList<String> Mym;
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
    AppMethodBeat.i(194674);
    this.TAG = "TPThumbPlayer[TPPlayer.java]";
    this.mUrl = null;
    this.Myk = true;
    this.Myl = -1;
    this.TAG = (this.TAG + ", playId:" + Myd);
    Myd += 1;
    com.tencent.thumbplayer.utils.d.i(this.TAG, "create TPPlayer");
    this.mContext = paramContext.getApplicationContext();
    this.Myi = new com.tencent.thumbplayer.g.a.c();
    a(100, 0, 0, null, new com.tencent.thumbplayer.utils.c().P("stime", Long.valueOf(System.currentTimeMillis())).map);
    this.Myj = new a(this);
    b localb = new b();
    this.Myg = new c(this.TAG);
    this.Mye = new com.tencent.thumbplayer.a.d(this.mContext);
    this.Mye.a(localb);
    this.Mye.a(localb);
    this.Mye.a(localb);
    this.Mye.a(localb);
    this.Mye.a(localb);
    this.Mye.a(localb);
    this.Mye.a(localb);
    this.Mye.a(localb);
    this.Mye.a(localb);
    this.Mye.a(localb);
    this.Mye.a(localb);
    this.mHandlerThread = new HandlerThread("TP-workthread");
    this.mHandlerThread.start();
    this.Myf = new b(this.mHandlerThread.getLooper(), this);
    a(101, 0, 0, null, new com.tencent.thumbplayer.utils.c().P("etime", Long.valueOf(System.currentTimeMillis())).map);
    this.Myh = new com.tencent.thumbplayer.f.c(paramContext);
    this.Myh.a(localb);
    this.Myi.a(new com.tencent.thumbplayer.g.a.a.b()).a(new com.tencent.thumbplayer.g.a.a.a());
    this.Mym = new ArrayList();
    AppMethodBeat.o(194674);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    AppMethodBeat.i(194746);
    try
    {
      if (this.Myi != null) {
        this.Myi.b(paramInt1, paramInt2, paramInt3, paramString, paramObject);
      }
      AppMethodBeat.o(194746);
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, paramString);
      AppMethodBeat.o(194746);
    }
  }
  
  private void e(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(194747);
    if (this.Myj != null)
    {
      Message localMessage = this.Myj.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      this.Myj.sendMessage(localMessage);
    }
    AppMethodBeat.o(194747);
  }
  
  private boolean gbW()
  {
    AppMethodBeat.i(194743);
    if ((this.Myh.isEnable()) && (com.tencent.thumbplayer.e.a.gbm()) && (this.Myk))
    {
      AppMethodBeat.o(194743);
      return true;
    }
    AppMethodBeat.o(194743);
    return false;
  }
  
  private void gbX()
  {
    AppMethodBeat.i(194745);
    if (this.Mye.isPlaying()) {}
    for (int i = 0;; i = 5)
    {
      this.Myh.ahU(i);
      AppMethodBeat.o(194745);
      return;
    }
  }
  
  private void lc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194744);
    a(108, paramInt1, paramInt2, "", new com.tencent.thumbplayer.utils.c().P("etime", Long.valueOf(System.currentTimeMillis())).P("reason", Integer.valueOf(3)).P("code", paramInt1 + "." + paramInt2).map);
    this.Myh.ahU(3);
    AppMethodBeat.o(194744);
  }
  
  public final void T(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(194733);
    com.tencent.thumbplayer.utils.d.i(this.TAG, "handleOnDownloadError, moduleID:" + paramInt1 + ", errorCode:" + paramInt2 + ", extInfo:" + paramString);
    lc(paramInt1, paramInt2);
    e(268, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(194733);
  }
  
  public final Object a(int paramInt, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(194739);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(194739);
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
    AppMethodBeat.i(194730);
    parama = this.Myh.a(parama, paramLong, paramp);
    if (parama != null) {
      try
      {
        com.tencent.thumbplayer.utils.d.i(this.TAG, "handleSwitchDef, proxyMediaAsset:" + parama + ", defID:" + paramLong);
        this.Mye.a(parama, paramInt, paramLong);
        a(120, 0, 0, null, new com.tencent.thumbplayer.utils.c().P("switch", String.valueOf(paramLong)).map);
        AppMethodBeat.o(194730);
        return;
      }
      catch (Exception parama)
      {
        com.tencent.thumbplayer.utils.d.e(this.TAG, parama);
      }
    }
    AppMethodBeat.o(194730);
  }
  
  public final void a(com.tencent.thumbplayer.b.b.b paramb)
  {
    if (this.Myg != null) {
      this.Myg.MyC = paramb;
    }
  }
  
  public final void a(b.c paramc)
  {
    if (this.Myg != null) {
      this.Myg.MyE = paramc;
    }
  }
  
  public final void a(b.d paramd)
  {
    if (this.Myg != null) {
      this.Myg.MyD = paramd;
    }
  }
  
  public final void a(b.e parame)
  {
    if (this.Myg != null) {
      this.Myg.MyB = parame;
    }
  }
  
  public final void a(b.f paramf)
  {
    if (this.Myg != null) {
      this.Myg.MyL = paramf;
    }
  }
  
  public final void a(b.g paramg)
  {
    if (this.Myg != null) {
      this.Myg.MyF = paramg;
    }
  }
  
  public void a(b.h paramh)
  {
    if (this.Myg != null) {
      this.Myg.MyK = paramh;
    }
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(194678);
    this.Myf.a(29, 0, 0, paramp, true, false);
    AppMethodBeat.o(194678);
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(194701);
    if (paramb != null)
    {
      try
      {
        if (!TextUtils.isEmpty(paramb.url))
        {
          this.mUrl = paramb.url;
          if (gbW())
          {
            paramb.url = this.Myh.bbp(paramb.url);
            com.tencent.thumbplayer.utils.d.i(this.TAG, "handleSetDataSource " + paramb.url);
          }
        }
        while ((!TextUtils.isEmpty(paramb.url)) && (paramb.MyO != null))
        {
          this.Mye.setDataSource(paramb.url, paramb.MyO);
          AppMethodBeat.o(194701);
          return;
          if (paramb.MyQ != null)
          {
            if (gbW()) {
              paramb.MyQ = this.Myh.c(paramb.MyQ);
            }
            if (paramb.MyQ != null) {
              this.Mye.a(paramb.MyQ);
            }
            AppMethodBeat.o(194701);
            return;
          }
        }
        if (TextUtils.isEmpty(paramb.url)) {
          break label224;
        }
        this.Mye.setDataSource(paramb.url);
        AppMethodBeat.o(194701);
        return;
      }
      catch (Exception paramb)
      {
        com.tencent.thumbplayer.utils.d.e(this.TAG, paramb);
      }
    }
    else
    {
      AppMethodBeat.o(194701);
      return;
    }
    label224:
    this.Mye.b(paramb.MyP);
    AppMethodBeat.o(194701);
  }
  
  public final void a(String paramString, long paramLong, p paramp, int paramInt)
  {
    AppMethodBeat.i(194729);
    paramp = this.Myh.a(paramLong, paramString, paramp);
    if (!TextUtils.isEmpty(paramp)) {
      try
      {
        com.tencent.thumbplayer.utils.d.i(this.TAG, "handleSwitchDef, proxyUrl:" + paramString + ", defID:" + paramLong);
        this.Mye.L(paramp, paramInt, paramLong);
        a(120, 0, 0, null, new com.tencent.thumbplayer.utils.c().P("switch", String.valueOf(paramLong)).map);
        AppMethodBeat.o(194729);
        return;
      }
      catch (Exception paramString)
      {
        com.tencent.thumbplayer.utils.d.e(this.TAG, paramString);
      }
    }
    AppMethodBeat.o(194729);
  }
  
  public final void a(String paramString1, String paramString2, com.tencent.thumbplayer.b.b.b paramb)
  {
    AppMethodBeat.i(194704);
    if (!gbW())
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, "handleAddAudioSource, proxy is not enable.");
      AppMethodBeat.o(194704);
      return;
    }
    if ((TextUtils.isEmpty(paramString2)) || (!com.tencent.thumbplayer.utils.a.aYG(paramString1)))
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, "handleAddAudioSource, illegal argument.");
      AppMethodBeat.o(194704);
      return;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      f localf = new f();
      if (paramb != null)
      {
        paramb = paramb.Mwk;
        localf.MvH = 3;
        localf.key = 6;
        localf.MvK = new f.e();
        localf.MvK.value = paramb;
      }
      localArrayList.add(localf);
      this.Mye.g(paramString1, paramString2, localArrayList);
      AppMethodBeat.o(194704);
      return;
    }
    catch (Exception paramString1)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, paramString1);
      AppMethodBeat.o(194704);
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, com.tencent.thumbplayer.b.b.b paramb)
  {
    AppMethodBeat.i(194703);
    try
    {
      long l = System.currentTimeMillis();
      if ((gbW()) && (com.tencent.thumbplayer.utils.a.aYG(paramString1)))
      {
        paramb = this.Myh.a(3, paramString1, paramb);
        this.Mym.add(paramb);
        this.Mye.bl(paramb, paramString2, paramString3);
      }
      for (;;)
      {
        a(118, 0, 0, null, new com.tencent.thumbplayer.utils.c().P("stime", Long.valueOf(l)).P("etime", Long.valueOf(System.currentTimeMillis())).P("url", paramString1).map);
        AppMethodBeat.o(194703);
        return;
        this.Mye.bl(paramString1, paramString2, paramString3);
      }
      return;
    }
    catch (Exception paramString1)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, paramString1);
      AppMethodBeat.o(194703);
    }
  }
  
  public final void aW(int paramInt, long paramLong)
  {
    AppMethodBeat.i(194705);
    try
    {
      n[] arrayOfn = this.Mye.gaF();
      if ((arrayOfn != null) && (arrayOfn.length > paramInt)) {
        a(122, 0, 0, null, new com.tencent.thumbplayer.utils.c().P("opaque", Long.valueOf(paramLong)).P("tracktype", Integer.valueOf(arrayOfn[paramInt].trackType)).P("stime", Long.valueOf(System.currentTimeMillis())).map);
      }
      this.Mye.aR(paramInt, paramLong);
      AppMethodBeat.o(194705);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(194705);
    }
  }
  
  public final void aX(int paramInt, long paramLong)
  {
    AppMethodBeat.i(194706);
    try
    {
      this.Mye.aS(paramInt, paramLong);
      AppMethodBeat.o(194706);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(194706);
    }
  }
  
  public final void aY(int paramInt, long paramLong)
  {
    AppMethodBeat.i(194707);
    try
    {
      this.Mye.aT(paramInt, paramLong);
      AppMethodBeat.o(194707);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(194707);
    }
  }
  
  public final long aic(int paramInt)
  {
    AppMethodBeat.i(194720);
    try
    {
      long l = this.Mye.getPropertyLong(paramInt);
      AppMethodBeat.o(194720);
      return l;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(194720);
    }
    return 0L;
  }
  
  public final String aid(int paramInt)
  {
    AppMethodBeat.i(194721);
    try
    {
      String str = this.Mye.getPropertyString(paramInt);
      AppMethodBeat.o(194721);
      return str;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(194721);
    }
    return null;
  }
  
  public final void aie(int paramInt)
  {
    AppMethodBeat.i(194736);
    e(272, paramInt, 0, null);
    AppMethodBeat.o(194736);
  }
  
  public final void b(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194731);
    i.c localc = new i.c();
    localc.MvX = paramInt1;
    localc.MvY = paramInt2;
    localc.MvZ = paramLong1;
    localc.Fdf = paramLong2;
    com.tencent.thumbplayer.utils.d.i(this.TAG, "handleOnDownloadProgressUpdate");
    a(200, 0, 0, null, new com.tencent.thumbplayer.utils.c().P("speed", Integer.valueOf(paramInt2)).map);
    e(274, 0, 0, localc);
    AppMethodBeat.o(194731);
  }
  
  public final void b(e parame, com.tencent.thumbplayer.b.d paramd)
  {
    AppMethodBeat.i(194728);
    try
    {
      this.Mye.a(parame, paramd);
      AppMethodBeat.o(194728);
      return;
    }
    catch (Exception parame)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, parame);
      AppMethodBeat.o(194728);
    }
  }
  
  public final void b(f paramf)
  {
    AppMethodBeat.i(194675);
    this.Myf.a(1, 0, 0, paramf, true, false);
    AppMethodBeat.o(194675);
  }
  
  public final void b(p paramp)
  {
    AppMethodBeat.i(194702);
    if (paramp != null) {}
    try
    {
      this.Myh.a(paramp);
      this.Mye.a(paramp);
      AppMethodBeat.o(194702);
      return;
    }
    catch (Exception paramp)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, paramp);
      AppMethodBeat.o(194702);
    }
  }
  
  public final void bbq(String paramString)
  {
    AppMethodBeat.i(194734);
    com.tencent.thumbplayer.utils.d.i(this.TAG, "handleOnDownloadCdnUrlUpdate, url:".concat(String.valueOf(paramString)));
    e(269, 0, 0, paramString);
    AppMethodBeat.o(194734);
  }
  
  public final void bm(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(194735);
    i.b localb = new i.b();
    localb.url = paramString1;
    localb.MvV = paramString2;
    localb.MvU = paramString3;
    a(201, 0, 0, null, new com.tencent.thumbplayer.utils.c().P("url", paramString1).P("cdnip", paramString2).P("cdnuip", paramString3).map);
    e(270, 0, 0, localb);
    AppMethodBeat.o(194735);
  }
  
  public final void c(f paramf)
  {
    AppMethodBeat.i(194699);
    if ((paramf != null) && (paramf.key == 205))
    {
      this.Myk = paramf.MvI.value;
      AppMethodBeat.o(194699);
      return;
    }
    this.Myh.b(paramf);
    this.Mye.b(paramf);
    AppMethodBeat.o(194699);
  }
  
  public final void cf(Map<String, String> paramMap)
  {
    AppMethodBeat.i(194738);
    com.tencent.thumbplayer.utils.d.i(this.TAG, "onDownloadCdnUrlExpired");
    e(275, 0, 0, paramMap);
    AppMethodBeat.o(194738);
  }
  
  public final void cg(float paramFloat)
  {
    AppMethodBeat.i(194687);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Myc + "setAudioGainRatio, gainRatio:" + paramFloat);
    this.Myf.a(18, 0, 0, Float.valueOf(paramFloat), false, true);
    AppMethodBeat.o(194687);
  }
  
  public final void ci(float paramFloat)
  {
    AppMethodBeat.i(194716);
    try
    {
      this.Mye.cg(paramFloat);
      AppMethodBeat.o(194716);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(194716);
    }
  }
  
  public final void cj(float paramFloat)
  {
    AppMethodBeat.i(194717);
    try
    {
      this.Mye.ch(paramFloat);
      a(116, 0, 0, null, new com.tencent.thumbplayer.utils.c().P("scene", Float.valueOf(paramFloat)).map);
      AppMethodBeat.o(194717);
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
    AppMethodBeat.i(194719);
    try
    {
      this.Mye.c(paramBoolean, paramLong1, paramLong2);
      AppMethodBeat.o(194719);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(194719);
    }
  }
  
  public final j gaA()
  {
    AppMethodBeat.i(194698);
    j localj = this.Mye.gaA();
    AppMethodBeat.o(194698);
    return localj;
  }
  
  public final void gaT()
  {
    AppMethodBeat.i(194696);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Myc + "resumeDownload");
    this.Myf.a(42, 0, 0, null, false, false);
    AppMethodBeat.o(194696);
  }
  
  public final void gbE()
  {
    AppMethodBeat.i(194695);
    f localf = new f().aV(502, 0L);
    try
    {
      this.Mye.b(localf);
      this.Myh.pauseDownload();
      AppMethodBeat.o(194695);
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
  
  public final void gbF()
  {
    AppMethodBeat.i(194697);
    this.Myh.gaT();
    f localf = new f().aV(502, 1L);
    try
    {
      this.Mye.b(localf);
      AppMethodBeat.o(194697);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException.getMessage());
      AppMethodBeat.o(194697);
    }
  }
  
  public final void gbG()
  {
    AppMethodBeat.i(194708);
    try
    {
      this.Mye.prepareAsync();
      Object localObject = UUID.randomUUID().toString() + System.nanoTime() + "_" + com.tencent.thumbplayer.e.a.getPlatform();
      a(102, 0, 0, null, new com.tencent.thumbplayer.utils.c().P("stime", Long.valueOf(System.currentTimeMillis())).P("url", this.mUrl).P("p2p", Boolean.valueOf(gbW())).P("flowid", localObject).map);
      localObject = new d.g();
      if (gbW()) {}
      for (long l = 1L;; l = 0L)
      {
        ((d.g)localObject).dLC = l;
        e(261, 1009, 0, localObject);
        AppMethodBeat.o(194708);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(194708);
    }
  }
  
  public final void gbH()
  {
    AppMethodBeat.i(194709);
    try
    {
      this.Mye.start();
      a(104, 0, 0, null, new com.tencent.thumbplayer.utils.c().P("stime", Long.valueOf(System.currentTimeMillis())).map);
      this.Myh.ahU(0);
      AppMethodBeat.o(194709);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(194709);
    }
  }
  
  public final void gbI()
  {
    AppMethodBeat.i(194710);
    try
    {
      this.Mye.pause();
      a(106, 0, 0, null, new com.tencent.thumbplayer.utils.c().P("stime", Long.valueOf(System.currentTimeMillis())).map);
      this.Myh.ahU(5);
      AppMethodBeat.o(194710);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(194710);
    }
  }
  
  public final void gbJ()
  {
    AppMethodBeat.i(194711);
    try
    {
      this.Mye.stop();
      a(107, 0, 0, null, new com.tencent.thumbplayer.utils.c().P("etime", Long.valueOf(System.currentTimeMillis())).P("reason", Integer.valueOf(1)).map);
      this.Myh.ahU(5);
      AppMethodBeat.o(194711);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(194711);
    }
  }
  
  public final void gbK()
  {
    AppMethodBeat.i(194712);
    try
    {
      this.Mye.reset();
      a(113, 0, 0, null, new com.tencent.thumbplayer.utils.c().P("etime", Long.valueOf(System.currentTimeMillis())).P("reason", Integer.valueOf(1)).map);
      this.Myh.stopDownload();
      this.Myl = -1;
      this.Mym.clear();
      AppMethodBeat.o(194712);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(194712);
    }
  }
  
  public final void gbL()
  {
    AppMethodBeat.i(194713);
    try
    {
      this.Mye.release();
      a(112, 0, 0, null, new com.tencent.thumbplayer.utils.c().P("etime", Long.valueOf(System.currentTimeMillis())).P("reason", Integer.valueOf(1)).map);
      if (this.Myj != null)
      {
        this.Myj.removeCallbacksAndMessages(null);
        this.Myj = null;
      }
      c localc = this.Myg;
      localc.MyB = localc.MyM;
      localc.MyC = localc.MyM;
      localc.MyD = localc.MyM;
      localc.MyE = localc.MyM;
      localc.MyF = localc.MyM;
      localc.MyG = localc.MyM;
      localc.MyH = localc.MyM;
      localc.MyI = localc.MyM;
      localc.MyJ = localc.MyM;
      localc.MyK = localc.MyM;
      localc.MyL = localc.MyM;
      this.Myg = null;
      this.Myh.release();
      this.Mym.clear();
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
    AppMethodBeat.o(194713);
  }
  
  public final long gbM()
  {
    AppMethodBeat.i(194722);
    long l = this.Mye.getDurationMs();
    AppMethodBeat.o(194722);
    return l;
  }
  
  public final long gbN()
  {
    AppMethodBeat.i(194723);
    long l = this.Mye.getCurrentPositionMs();
    AppMethodBeat.o(194723);
    return l;
  }
  
  public final int gbO()
  {
    AppMethodBeat.i(194724);
    int i = this.Mye.getVideoWidth();
    AppMethodBeat.o(194724);
    return i;
  }
  
  public final int gbP()
  {
    AppMethodBeat.i(194725);
    int i = this.Mye.getVideoHeight();
    AppMethodBeat.o(194725);
    return i;
  }
  
  public final n[] gbQ()
  {
    AppMethodBeat.i(194726);
    n[] arrayOfn = this.Mye.gaF();
    AppMethodBeat.o(194726);
    return arrayOfn;
  }
  
  public final k[] gbR()
  {
    AppMethodBeat.i(194727);
    k[] arrayOfk = this.Mye.gaG();
    AppMethodBeat.o(194727);
    return arrayOfk;
  }
  
  public final void gbS()
  {
    AppMethodBeat.i(194732);
    com.tencent.thumbplayer.utils.d.i(this.TAG, "onDownloadFinish");
    e(271, 0, 0, Integer.valueOf(0));
    AppMethodBeat.o(194732);
  }
  
  public final long gbT()
  {
    AppMethodBeat.i(194740);
    com.tencent.thumbplayer.a.a locala = this.Mye;
    if (locala != null)
    {
      long l = locala.getBufferedDurationMs();
      AppMethodBeat.o(194740);
      return l;
    }
    AppMethodBeat.o(194740);
    return 0L;
  }
  
  public final int gbU()
  {
    AppMethodBeat.i(194741);
    com.tencent.thumbplayer.a.a locala = this.Mye;
    if (locala != null)
    {
      int i = locala.getCurrentPlayClipNo();
      AppMethodBeat.o(194741);
      return i;
    }
    AppMethodBeat.o(194741);
    return 0;
  }
  
  public final long gbV()
  {
    AppMethodBeat.i(194742);
    com.tencent.thumbplayer.b.b.a locala = this.Myh.gbz();
    if (locala != null)
    {
      long l = locala.gbi();
      AppMethodBeat.o(194742);
      return l;
    }
    AppMethodBeat.o(194742);
    return -1L;
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(194691);
    long l = this.Myf.getCurrentPositionMs();
    AppMethodBeat.o(194691);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(194690);
    long l = this.Myf.getDurationMs();
    AppMethodBeat.o(194690);
    return l;
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(194689);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Myc + "getPropertyLong, paramId:" + paramInt);
    b localb = this.Myf;
    localb.gcb();
    localb.Mys = 0L;
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get property long");
    localb.a(27, paramInt, 0, null, false, false);
    localb.gcd();
    localb.gcc();
    long l = localb.Mys;
    AppMethodBeat.o(194689);
    return l;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(194693);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Myc + "getVideoHeight");
    b localb = this.Myf;
    localb.gcb();
    localb.a(22, 0, 0, null, false, false);
    localb.gcd();
    localb.gcc();
    int i = localb.Myp.height;
    AppMethodBeat.o(194693);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(194692);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Myc + "getVideoWidth");
    b localb = this.Myf;
    localb.gcb();
    localb.a(21, 0, 0, null, false, false);
    localb.gcd();
    localb.gcc();
    int i = localb.Myp.width;
    AppMethodBeat.o(194692);
    return i;
  }
  
  public final void l(Surface paramSurface)
  {
    AppMethodBeat.i(194700);
    this.Mye.setSurface(paramSurface);
    AppMethodBeat.o(194700);
  }
  
  public final void lb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194714);
    a(109, 0, 0, null, new com.tencent.thumbplayer.utils.c().P("stime", Long.valueOf(System.currentTimeMillis())).P("format", Integer.valueOf(0)).P("pstime", Long.valueOf(gbN())).map);
    if (paramInt2 > 0) {
      this.Mye.kZ(paramInt1, paramInt2);
    }
    for (;;)
    {
      this.Myh.ahU(1);
      AppMethodBeat.o(194714);
      return;
      this.Mye.seekTo(paramInt1);
    }
  }
  
  public final void mY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194737);
    com.tencent.thumbplayer.utils.d.i(this.TAG, "onDownloadProtocolUpdate, protocol:" + paramString1 + ", protocolVer:" + paramString2);
    i.d locald = new i.d();
    locald.Mwb = paramString2;
    locald.Mwa = paramString1;
    e(273, 0, 0, locald);
    AppMethodBeat.o(194737);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(194681);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Myc + "pause");
    this.Myf.a(12, 0, 0, null, false, false);
    AppMethodBeat.o(194681);
  }
  
  public final void pauseDownload()
  {
    AppMethodBeat.i(194694);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Myc + "pauseDownload");
    this.Myf.a(41, 0, 0, null, false, false);
    AppMethodBeat.o(194694);
  }
  
  public void prepareAsync()
  {
    AppMethodBeat.i(194679);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Myc + "prepareAsync");
    this.Myf.a(10, 0, 0, null, false, false);
    AppMethodBeat.o(194679);
  }
  
  public final void release()
  {
    AppMethodBeat.i(194684);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Myc + "release");
    b localb = this.Myf;
    localb.gcb();
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : release");
    localb.a(15, 0, 0, null, false, false);
    localb.gcd();
    localb.gcc();
    this.Myi.release();
    AppMethodBeat.o(194684);
  }
  
  public void reset()
  {
    AppMethodBeat.i(194683);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Myc + "reset");
    b localb = this.Myf;
    localb.gcb();
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : reset");
    localb.a(14, 0, 0, null, false, false);
    localb.gcd();
    localb.gcc();
    AppMethodBeat.o(194683);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(194685);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Myc + "seekTo, positionMs:" + paramInt);
    this.Myf.a(16, paramInt, 0, null, false, false);
    AppMethodBeat.o(194685);
  }
  
  public void setDataSource(String paramString)
  {
    AppMethodBeat.i(194677);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Myc + "setDataSource, url:" + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("error : setDataSource , data source invalid");
      AppMethodBeat.o(194677);
      throw paramString;
    }
    b localb = this.Myf;
    d.b localb1 = new d.b();
    localb1.url = paramString;
    localb.a(5, 0, 0, localb1, true, false);
    AppMethodBeat.o(194677);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(194676);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Myc + "setSurface, surface:" + paramSurface);
    this.Myf.a(4, 0, 0, paramSurface, false, false);
    AppMethodBeat.o(194676);
  }
  
  public final void start()
  {
    AppMethodBeat.i(194680);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Myc + "start");
    this.Myf.a(11, 0, 0, null, false, false);
    AppMethodBeat.o(194680);
  }
  
  public void stop()
  {
    AppMethodBeat.i(194682);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Myc + "stop");
    b localb = this.Myf;
    localb.gcb();
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : stop");
    localb.a(13, 0, 0, null, false, false);
    localb.gcd();
    localb.gcc();
    AppMethodBeat.o(194682);
  }
  
  public final void zJ(boolean paramBoolean)
  {
    AppMethodBeat.i(194688);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Myc + "setLoopback, isLoopback:" + paramBoolean);
    this.Myf.a(35, 0, 0, Boolean.valueOf(paramBoolean), true, true);
    AppMethodBeat.o(194688);
  }
  
  public final void zK(boolean paramBoolean)
  {
    AppMethodBeat.i(194686);
    com.tencent.thumbplayer.utils.d.i(this.TAG, Myc + "setOutputMute, isOutputMute:" + paramBoolean);
    this.Myf.a(17, 0, 0, Boolean.valueOf(paramBoolean), false, true);
    AppMethodBeat.o(194686);
  }
  
  public final void zM(boolean paramBoolean)
  {
    AppMethodBeat.i(194715);
    try
    {
      this.Mye.zK(paramBoolean);
      AppMethodBeat.o(194715);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(194715);
    }
  }
  
  public final void zN(boolean paramBoolean)
  {
    AppMethodBeat.i(194718);
    try
    {
      this.Mye.zJ(paramBoolean);
      AppMethodBeat.o(194718);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e(this.TAG, localException);
      AppMethodBeat.o(194718);
    }
  }
  
  @SuppressLint({"HandlerLeak"})
  final class a
    extends Handler
  {
    private a Myn;
    
    a(a parama)
    {
      this.Myn = parama;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(194644);
      com.tencent.thumbplayer.utils.d.d(a.c(a.this), "mTransformHandler msg : " + paramMessage.what);
      c localc = a.e(a.this);
      if (localc == null)
      {
        AppMethodBeat.o(194644);
        return;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(194644);
        return;
        com.tencent.thumbplayer.utils.d.i(a.c(a.this), "onPrepared");
        localc.a(this.Myn);
        AppMethodBeat.o(194644);
        return;
        localc.b(this.Myn);
        AppMethodBeat.o(194644);
        return;
        d.g localg = (d.g)paramMessage.obj;
        if ((localg != null) && (!a.a(a.this).gbx()))
        {
          localc.a(this.Myn, paramMessage.arg1, localg.dLC, localg.MyZ, localg.Mza);
          AppMethodBeat.o(194644);
          return;
        }
        if (localg != null)
        {
          localc.a(this.Myn, paramMessage.arg1, localg.dLC, localg.MyZ, localg.Mza);
          AppMethodBeat.o(194644);
          return;
          localg = (d.g)paramMessage.obj;
          if (localg != null)
          {
            localc.a(this.Myn, paramMessage.arg1, paramMessage.arg2, localg.dLC, localg.MyZ);
            AppMethodBeat.o(194644);
            return;
            localc.c(this.Myn);
            AppMethodBeat.o(194644);
            return;
            paramMessage = (d.g)paramMessage.obj;
            if (paramMessage != null)
            {
              localc.a(this.Myn, paramMessage.dLC, paramMessage.MyZ);
              AppMethodBeat.o(194644);
              return;
              localc.a(this.Myn, (m)paramMessage.obj);
              AppMethodBeat.o(194644);
              return;
              localc.a(this.Myn, (o)paramMessage.obj);
              AppMethodBeat.o(194644);
              return;
              localc.a(this.Myn, (com.tencent.thumbplayer.b.c)paramMessage.obj);
              AppMethodBeat.o(194644);
              return;
              localc.a(this.Myn, paramMessage.arg1, paramMessage.arg2, 0L, 0L);
              AppMethodBeat.o(194644);
              return;
              localc.a(this.Myn, 1002, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(194644);
              return;
              localc.a(this.Myn, 1003, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(194644);
              return;
              localc.a(this.Myn, 1001, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(194644);
              return;
              localc.a(this.Myn, 1004, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(194644);
              return;
              localc.a(this.Myn, 1005, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(194644);
              return;
              localc.a(this.Myn, 1006, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(194644);
              return;
              localc.a(this.Myn, 1007, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(194644);
              return;
              localc.a(this.Myn, 1008, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(194644);
              return;
              localc.a(this.Myn, 1010, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(194644);
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
      AppMethodBeat.i(194648);
      Object localObject = a.a(a.this).gby();
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
      ((d.g)localObject).dLC = paramLong1;
      ((d.g)localObject).MyZ = paramLong2;
      a.a(a.this, 262, j, i, localObject);
      AppMethodBeat.o(194648);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(194647);
      a.a(a.this, paramInt, paramLong1, paramLong2, paramObject);
      if (paramInt == 1011)
      {
        a.a(a.this, paramObject);
        AppMethodBeat.o(194647);
        return;
      }
      if (paramInt == 1012)
      {
        a.b(a.this, paramObject);
        AppMethodBeat.o(194647);
        return;
      }
      d.g localg = new d.g();
      localg.dLC = paramLong1;
      localg.MyZ = paramLong2;
      localg.Mza = paramObject;
      a.a(a.this, 261, paramInt, 0, localg);
      AppMethodBeat.o(194647);
    }
    
    public final void a(com.tencent.thumbplayer.b.c paramc)
    {
      AppMethodBeat.i(194654);
      c localc = a.e(a.this);
      if (localc != null) {
        localc.a(a.this, paramc);
      }
      AppMethodBeat.o(194654);
    }
    
    public final void a(m paramm)
    {
      AppMethodBeat.i(194652);
      a.a(a.this, 265, 0, 0, paramm);
      AppMethodBeat.o(194652);
    }
    
    public final void a(o paramo)
    {
      AppMethodBeat.i(194653);
      c localc = a.e(a.this);
      if (localc != null) {
        localc.a(a.this, paramo);
      }
      AppMethodBeat.o(194653);
    }
    
    public final void aC(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(194650);
      d.g localg = new d.g();
      localg.dLC = paramLong1;
      localg.MyZ = paramLong2;
      a.a(a.this, 264, 0, 0, localg);
      AppMethodBeat.o(194650);
    }
    
    public final void clF()
    {
      AppMethodBeat.i(194649);
      a.d(a.this);
      a.a(a.this, 110, new com.tencent.thumbplayer.utils.c().P("etime", Long.valueOf(System.currentTimeMillis())).P("petime", Long.valueOf(a.this.gbN())).map);
      a.a(a.this, 263, 0, 0, null);
      AppMethodBeat.o(194649);
    }
    
    public final void fW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(194651);
      a.a(a.this, 277, paramInt1, paramInt2, null);
      AppMethodBeat.o(194651);
    }
    
    public final long getAdvRemainTime()
    {
      AppMethodBeat.i(194667);
      long l = a.f(a.this).getAdvRemainTime();
      AppMethodBeat.o(194667);
      return l;
    }
    
    public final String getContentType(long paramLong, String paramString)
    {
      AppMethodBeat.i(194673);
      paramString = a.e(a.this).d(a.this, paramLong, paramString);
      AppMethodBeat.o(194673);
      return paramString;
    }
    
    public final int getCurrentPlayClipNo()
    {
      AppMethodBeat.i(194666);
      int i = a.f(a.this).getCurrentPlayClipNo();
      AppMethodBeat.o(194666);
      return i;
    }
    
    public final long getCurrentPosition()
    {
      AppMethodBeat.i(194665);
      long l = a.f(a.this).getCurrentPosition();
      AppMethodBeat.o(194665);
      return l;
    }
    
    public final String getDataFilePath(long paramLong, String paramString)
    {
      AppMethodBeat.i(194672);
      paramString = a.e(a.this).c(a.this, paramLong, paramString);
      AppMethodBeat.o(194672);
      return paramString;
    }
    
    public final long getDataTotalSize(long paramLong, String paramString)
    {
      AppMethodBeat.i(194671);
      paramLong = a.e(a.this).b(a.this, paramLong, paramString);
      AppMethodBeat.o(194671);
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
      AppMethodBeat.i(194664);
      long l = a.f(a.this).getPlayerBufferLength();
      AppMethodBeat.o(194664);
      return l;
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(194646);
      a.a(a.this, 111, new com.tencent.thumbplayer.utils.c().P("etime", Long.valueOf(System.currentTimeMillis())).P("reason", Integer.valueOf(0)).map);
      a.a(a.this, 260, 0, 0, null);
      AppMethodBeat.o(194646);
    }
    
    public final void onDownloadCdnUrlExpired(Map<String, String> paramMap)
    {
      AppMethodBeat.i(194662);
      com.tencent.thumbplayer.utils.d.i(a.c(a.this), "onDownloadCdnUrlExpired");
      a.f(a.this).onDownloadCdnUrlExpired(paramMap);
      AppMethodBeat.o(194662);
    }
    
    public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(194659);
      com.tencent.thumbplayer.utils.d.i(a.c(a.this), "onDownloadCdnUrlInfoUpdate, url:" + paramString1 + ", cdnIp:" + paramString2 + ", uip:" + paramString3 + ", errorCodeStr:" + paramString4);
      a.f(a.this).onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(194659);
    }
    
    public final void onDownloadCdnUrlUpdate(String paramString)
    {
      AppMethodBeat.i(194658);
      com.tencent.thumbplayer.utils.d.i(a.c(a.this), "onDownloadCdnUrlUpdate, url:".concat(String.valueOf(paramString)));
      a.f(a.this).onDownloadCdnUrlUpdate(paramString);
      AppMethodBeat.o(194658);
    }
    
    public final void onDownloadError(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(194657);
      com.tencent.thumbplayer.utils.d.i(a.c(a.this), "onDownloadError, moduleID:" + paramInt1 + ", errorCode:" + paramInt2 + ", extInfo:" + paramString);
      a.f(a.this).onDownloadError(4000, paramInt2, paramString);
      AppMethodBeat.o(194657);
    }
    
    public final void onDownloadFinish()
    {
      AppMethodBeat.i(194656);
      com.tencent.thumbplayer.utils.d.i(a.c(a.this), "onDownloadFinish");
      a.f(a.this).onDownloadFinish();
      AppMethodBeat.o(194656);
    }
    
    public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(194655);
      a.f(a.this).onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2);
      AppMethodBeat.o(194655);
    }
    
    public final void onDownloadProtocolUpdate(String paramString1, String paramString2)
    {
      AppMethodBeat.i(194661);
      com.tencent.thumbplayer.utils.d.i(a.c(a.this), "onDownloadProtocolUpdate, protocol:" + paramString1 + ", protocolVer:" + paramString2);
      a.f(a.this).onDownloadProtocolUpdate(paramString1, paramString2);
      AppMethodBeat.o(194661);
    }
    
    public final void onDownloadStatusUpdate(int paramInt)
    {
      AppMethodBeat.i(194660);
      if (paramInt != a.g(a.this))
      {
        com.tencent.thumbplayer.utils.d.i(a.c(a.this), "onDownloadStatusUpdate, status:".concat(String.valueOf(paramInt)));
        a.a(a.this, paramInt);
      }
      a.f(a.this).onDownloadStatusUpdate(paramInt);
      AppMethodBeat.o(194660);
    }
    
    public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      AppMethodBeat.i(194663);
      paramObject1 = a.f(a.this).onPlayCallback(paramInt, paramObject1, paramObject2, paramObject3, paramObject4);
      AppMethodBeat.o(194663);
      return paramObject1;
    }
    
    public final int onReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(194669);
      int i = a.e(a.this).b(a.this, paramLong1, paramString, paramLong2, paramLong3);
      AppMethodBeat.o(194669);
      return i;
    }
    
    public final int onStartReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(194668);
      int i = a.e(a.this).a(a.this, paramLong1, paramString, paramLong2, paramLong3);
      AppMethodBeat.o(194668);
      return i;
    }
    
    public final int onStopReadData(long paramLong, String paramString)
    {
      AppMethodBeat.i(194670);
      int i = a.e(a.this).a(a.this, paramLong, paramString);
      AppMethodBeat.o(194670);
      return i;
    }
    
    public final void ta()
    {
      AppMethodBeat.i(194645);
      a.a(a.this).ahU(0);
      Object localObject1 = a.b(a.this).gaz();
      String str = ((com.tencent.thumbplayer.a.b)localObject1).bbs + "*" + ((com.tencent.thumbplayer.a.b)localObject1).bbt;
      Object localObject2 = a.b(a.this).gaF();
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
      localObject1 = new com.tencent.thumbplayer.utils.c().P("playertype", Integer.valueOf(a.b(a.this).getPlayerType())).P("definition", str).P("rate", Long.valueOf(((com.tencent.thumbplayer.a.b)localObject1).MsU)).P("duration", Long.valueOf(((com.tencent.thumbplayer.a.b)localObject1).bup)).P("fmt", ((com.tencent.thumbplayer.a.b)localObject1).MsQ).P("etime", Long.valueOf(System.currentTimeMillis()));
      if (k > 1) {}
      for (boolean bool = true;; bool = false)
      {
        a.a((a)localObject2, 103, ((com.tencent.thumbplayer.utils.c)localObject1).P("multitrack", Boolean.valueOf(bool)).map);
        a.a(a.this, 257, 0, 0, null);
        AppMethodBeat.o(194645);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.g.a
 * JD-Core Version:    0.7.0.1
 */