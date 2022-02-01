package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.n.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class ax
{
  private static int AZh = 0;
  private static int AZi = 0;
  public l AYS;
  public j AYT;
  public k AYU;
  public av AYV;
  private aj AYW;
  public f AYX;
  public b AYY;
  public g AYZ;
  public d AZa;
  private e AZb;
  private i AZc;
  private h AZd;
  private c AZe;
  public a AZf;
  private at AZg;
  public int AZj;
  
  public ax()
  {
    AppMethodBeat.i(175743);
    this.AZj = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(175743);
  }
  
  public static void ax(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (AZh = 1; paramBoolean2; AZh = 0)
    {
      AZi = 1;
      return;
    }
    AZi = 0;
  }
  
  public static int baS()
  {
    AppMethodBeat.i(79075);
    if (ay.is4G(com.tencent.mm.sdk.platformtools.aj.getContext()))
    {
      AppMethodBeat.o(79075);
      return 5;
    }
    switch (ay.getNetType(com.tencent.mm.sdk.platformtools.aj.getContext()))
    {
    default: 
      AppMethodBeat.o(79075);
      return 6;
    case -1: 
      AppMethodBeat.o(79075);
      return 255;
    case 0: 
      AppMethodBeat.o(79075);
      return 1;
    case 3: 
    case 4: 
      AppMethodBeat.o(79075);
      return 4;
    case 2: 
    case 5: 
    case 7: 
      AppMethodBeat.o(79075);
      return 2;
    }
    AppMethodBeat.o(79075);
    return 3;
  }
  
  public static String emh()
  {
    AppMethodBeat.i(79076);
    Object localObject = (ConnectivityManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("connectivity");
    if (localObject == null)
    {
      AppMethodBeat.o(79076);
      return "no";
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(79076);
      return "no";
    }
    if (((NetworkInfo)localObject).getType() == 1)
    {
      AppMethodBeat.o(79076);
      return "WIFI";
    }
    ad.d("MicroMsg.WebviewReporter", "activeNetInfo extra=%s, type=%d, %s", new Object[] { ((NetworkInfo)localObject).getExtraInfo(), Integer.valueOf(((NetworkInfo)localObject).getType()), ((NetworkInfo)localObject).getExtraInfo() });
    if (((NetworkInfo)localObject).getExtraInfo() != null)
    {
      localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      AppMethodBeat.o(79076);
      return localObject;
    }
    AppMethodBeat.o(79076);
    return "no";
  }
  
  private static void s(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(187933);
    ArrayList localArrayList = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(String.valueOf(paramVarArgs[i]));
      i += 1;
    }
    paramVarArgs = com.tencent.mm.plugin.report.service.h.vKh;
    com.tencent.mm.plugin.report.service.h.h(11215, localArrayList);
    if ((paramString != null) && (paramString.startsWith("official_mall")))
    {
      paramString = com.tencent.mm.plugin.report.service.h.vKh;
      com.tencent.mm.plugin.report.service.h.h(14919, localArrayList);
    }
    AppMethodBeat.o(187933);
  }
  
  public static void uZ(long paramLong)
  {
    AppMethodBeat.i(79094);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(79094);
      return;
    }
    int i = (int)(System.currentTimeMillis() - paramLong);
    if ((i >= 0) && (i < 20000)) {
      com.tencent.mm.plugin.report.service.h.vKh.f(16269, new Object[] { Integer.valueOf(i), Integer.valueOf((int)(paramLong / 1000L)) });
    }
    AppMethodBeat.o(79094);
  }
  
  public final void awM(String paramString)
  {
    AppMethodBeat.i(79092);
    a locala;
    if (this.AZf != null) {
      try
      {
        locala = this.AZf;
        boolean bool = locala.dow.containsKey(paramString);
        if (!bool) {
          break label68;
        }
        try
        {
          locala.putValue(paramString, Integer.valueOf(locala.dow.getInt(paramString) + 1));
          AppMethodBeat.o(79092);
          return;
        }
        catch (Exception paramString)
        {
          AppMethodBeat.o(79092);
          return;
        }
        AppMethodBeat.o(79092);
      }
      catch (Exception paramString) {}
    } else {
      return;
    }
    label68:
    locala.putValue(paramString, Integer.valueOf(1));
    AppMethodBeat.o(79092);
  }
  
  public final l emi()
  {
    AppMethodBeat.i(79077);
    if (this.AYS == null) {
      this.AYS = new l();
    }
    l locall = this.AYS;
    AppMethodBeat.o(79077);
    return locall;
  }
  
  public final j emj()
  {
    AppMethodBeat.i(79078);
    if (this.AYT == null) {
      this.AYT = new j();
    }
    j localj = this.AYT;
    AppMethodBeat.o(79078);
    return localj;
  }
  
  public final k emk()
  {
    AppMethodBeat.i(79079);
    if (this.AYU == null) {
      this.AYU = new k();
    }
    k localk = this.AYU;
    AppMethodBeat.o(79079);
    return localk;
  }
  
  public final e eml()
  {
    AppMethodBeat.i(79080);
    if (this.AZb == null) {
      this.AZb = new e();
    }
    e locale = this.AZb;
    AppMethodBeat.o(79080);
    return locale;
  }
  
  public final av emm()
  {
    AppMethodBeat.i(187929);
    if (this.AYV == null) {
      this.AYV = new av();
    }
    av localav = this.AYV;
    AppMethodBeat.o(187929);
    return localav;
  }
  
  public final aj emn()
  {
    AppMethodBeat.i(187930);
    if (this.AYW == null) {
      this.AYW = new aj();
    }
    aj localaj = this.AYW;
    AppMethodBeat.o(187930);
    return localaj;
  }
  
  public final f emo()
  {
    AppMethodBeat.i(79083);
    if (this.AYX == null) {
      this.AYX = new f();
    }
    f localf = this.AYX;
    AppMethodBeat.o(79083);
    return localf;
  }
  
  public final b emp()
  {
    AppMethodBeat.i(79084);
    if (this.AYY == null) {
      this.AYY = new b();
    }
    b localb = this.AYY;
    AppMethodBeat.o(79084);
    return localb;
  }
  
  public final g emq()
  {
    AppMethodBeat.i(79085);
    if (this.AYZ == null) {
      this.AYZ = new g();
    }
    g localg = this.AYZ;
    AppMethodBeat.o(79085);
    return localg;
  }
  
  public final d emr()
  {
    AppMethodBeat.i(79086);
    if (this.AZa == null) {
      this.AZa = new d();
    }
    d locald = this.AZa;
    AppMethodBeat.o(79086);
    return locald;
  }
  
  public final i ems()
  {
    AppMethodBeat.i(79087);
    if (this.AZc == null) {
      this.AZc = new i();
    }
    i locali = this.AZc;
    AppMethodBeat.o(79087);
    return locali;
  }
  
  public final h emt()
  {
    AppMethodBeat.i(79088);
    if (this.AZd == null) {
      this.AZd = new h();
    }
    h localh = this.AZd;
    AppMethodBeat.o(79088);
    return localh;
  }
  
  public final c emu()
  {
    AppMethodBeat.i(79089);
    if (this.AZe == null) {
      this.AZe = new c();
    }
    c localc = this.AZe;
    AppMethodBeat.o(79089);
    return localc;
  }
  
  public final at emv()
  {
    AppMethodBeat.i(187931);
    if (this.AZg == null) {
      this.AZg = new at();
    }
    at localat = this.AZg;
    AppMethodBeat.o(187931);
    return localat;
  }
  
  public final void report()
  {
    AppMethodBeat.i(187932);
    k localk = emk();
    int i = baS();
    Iterator localIterator = localk.AZu.entrySet().iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      localObject2 = (String)((Map.Entry)localObject1).getKey();
      long l = ((Long)((Map.Entry)localObject1).getValue()).longValue();
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(32L, 0L, 1L, true);
      if ((l >= 0L) && (l <= 180000L))
      {
        String str = localk.AZr;
        if (localObject2 == null) {}
        for (localObject1 = localObject2;; localObject1 = ((String)localObject2).replace(",", "!"))
        {
          s(str, new Object[] { Integer.valueOf(3), Long.valueOf(l), Integer.valueOf(i), localObject1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(AZh), Integer.valueOf(AZi), Integer.valueOf(localk.dEF), localk.AZr });
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(160L, 0L, 1L, false);
          if (-1 != com.tencent.mm.plugin.webview.h.a.va(l)) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(160L, com.tencent.mm.plugin.webview.h.a.va(l), 1L, false);
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(32L, 3L, 1L, true);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(32L, 7L, l, true);
          if (AZi == 1)
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(32L, 16L, 1L, true);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(32L, 17L, l, true);
          }
          ad.i("MicroMsg.WebviewReporter", "WebviewOpenUrlReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { localObject2, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(AZh), Integer.valueOf(AZi), Integer.valueOf(localk.dEF), localk.AZr });
          break;
        }
      }
    }
    Object localObject1 = emm();
    if (!bt.isNullOrNil(((av)localObject1).AYI)) {
      ad.d("MicroMsg.WebviewReporter", "WebViewVisitReporter report viewID = %s", new Object[] { ((av)localObject1).AYI });
    }
    try
    {
      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)IPCVoid.fZS, av.a.AYQ.getClass(), (d)new av.b((av)localObject1));
      localObject1 = emn();
      if (!bt.isNullOrNil(((aj)localObject1).gKw))
      {
        localObject2 = ((aj)localObject1).gKw;
        if (localObject2 == null) {
          k.fvU();
        }
        if (n.mA((String)localObject2, "wrd")) {}
      }
      else
      {
        emj().report();
        eml().report();
        localObject1 = emp();
        i = baS();
        if (!((b)localObject1).AZl) {
          break label928;
        }
        if (!((b)localObject1).loadFinished) {
          break label879;
        }
        com.tencent.mm.plugin.report.service.h.vKh.f(11575, new Object[] { ((b)localObject1).dAl, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i) });
        AppMethodBeat.o(187932);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ad.w("MicroMsg.WebviewReporter", "invokeAsResult error, %s", new Object[] { localRemoteException });
        continue;
        localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("iswebviewreadtime=1");
        ((StringBuffer)localObject2).append("&publishid=");
        ((StringBuffer)localObject2).append(localRemoteException.gKw);
        ((StringBuffer)localObject2).append("&staytime=");
        ((StringBuffer)localObject2).append(localRemoteException.dsf);
        ((StringBuffer)localObject2).append("&allstaytime=");
        ((StringBuffer)localObject2).append(System.currentTimeMillis() - localRemoteException.enterTime);
        ((StringBuffer)localObject2).append("&maxscrolly=");
        ((StringBuffer)localObject2).append(localRemoteException.AYn);
        ((StringBuffer)localObject2).append("&totalscrolly=");
        ((StringBuffer)localObject2).append(localRemoteException.xJD);
        ((StringBuffer)localObject2).append("&scene=");
        ((StringBuffer)localObject2).append(localRemoteException.scene);
        ((StringBuffer)localObject2).append("&entertime=");
        ((StringBuffer)localObject2).append(localRemoteException.enterTime);
        ((StringBuffer)localObject2).append("&screenheight=");
        ((StringBuffer)localObject2).append(com.tencent.mm.cd.a.hW(com.tencent.mm.sdk.platformtools.aj.getContext()));
        Bundle localBundle = new Bundle();
        localBundle.putString("reportString", ((StringBuffer)localObject2).toString());
        try
        {
          com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localBundle, aj.a.AYo.getClass(), null);
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.WebviewReporter", (Throwable)localException, "TopStory report", new Object[0]);
        }
      }
      label879:
      com.tencent.mm.plugin.report.service.h.vKh.f(11575, new Object[] { localException.dAl, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(187932);
      return;
    }
    label928:
    com.tencent.mm.plugin.report.service.h.vKh.f(11575, new Object[] { localException.dAl, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(i) });
    AppMethodBeat.o(187932);
  }
  
  public final void x(String paramString, Object paramObject)
  {
    AppMethodBeat.i(79091);
    if (this.AZf != null) {
      try
      {
        this.AZf.putValue(paramString, paramObject);
        AppMethodBeat.o(79091);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(79091);
  }
  
  public final class a
  {
    public Bundle dow = null;
    
    public a(Bundle paramBundle)
    {
      this.dow = paramBundle;
    }
    
    public final void putValue(String paramString, Object paramObject)
    {
      AppMethodBeat.i(79061);
      if (this.dow != null)
      {
        if ((paramObject instanceof String))
        {
          this.dow.putString(paramString, (String)paramObject);
          AppMethodBeat.o(79061);
          return;
        }
        if ((paramObject instanceof Boolean))
        {
          this.dow.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
          AppMethodBeat.o(79061);
          return;
        }
        if ((paramObject instanceof Integer))
        {
          this.dow.putInt(paramString, ((Integer)paramObject).intValue());
          AppMethodBeat.o(79061);
          return;
        }
        ad.w("MicroMsg.WebviewReporter", "put unknow type value.");
      }
      AppMethodBeat.o(79061);
    }
  }
  
  public static final class b
  {
    public boolean AZl = false;
    String dAl;
    public boolean loadFinished = false;
    
    public final b awN(String paramString)
    {
      this.dAl = paramString;
      return this;
    }
  }
  
  public static final class c
  {
    private boolean AZm = false;
    public boolean qhl = false;
    
    public final void bV(String paramString)
    {
      AppMethodBeat.i(187914);
      if ((!this.qhl) || (this.AZm))
      {
        AppMethodBeat.o(187914);
        return;
      }
      try
      {
        Object localObject = Uri.parse(paramString);
        if (!paramString.startsWith("http"))
        {
          ad.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, url not startswith http");
          AppMethodBeat.o(187914);
          return;
        }
        localObject = ((Uri)localObject).getHost();
        if ((localObject != null) && (((String)localObject).equalsIgnoreCase("v.html5.qq.com")))
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(283L, 0L, 1L, true);
          this.AZm = true;
          ad.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, domain visit reported, url = %s", new Object[] { paramString });
        }
        AppMethodBeat.o(187914);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, parse url fail, url = %s", new Object[] { paramString });
        AppMethodBeat.o(187914);
      }
    }
  }
  
  public static final class d
  {
    private ArrayList<String> AZn;
    
    public d()
    {
      AppMethodBeat.i(187915);
      this.AZn = new ArrayList();
      AppMethodBeat.o(187915);
    }
    
    public final void report()
    {
      AppMethodBeat.i(187917);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
      com.tencent.mm.plugin.report.service.h.h(11577, this.AZn);
      AppMethodBeat.o(187917);
    }
    
    public final d z(Object... paramVarArgs)
    {
      AppMethodBeat.i(187916);
      int j = paramVarArgs.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramVarArgs[i];
        ArrayList localArrayList = this.AZn;
        if (localObject == null) {}
        for (localObject = "";; localObject = localObject.toString())
        {
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(187916);
      return this;
    }
  }
  
  public final class e
  {
    private ConcurrentHashMap<String, Long> AZo;
    private ConcurrentHashMap<String, Long> AZp;
    private boolean AZq;
    private String AZr;
    private int dEF;
    private String lst;
    
    public e()
    {
      AppMethodBeat.i(79063);
      this.lst = "";
      this.AZq = true;
      this.AZo = new ConcurrentHashMap();
      this.AZp = new ConcurrentHashMap();
      AppMethodBeat.o(79063);
    }
    
    public final void awO(String paramString)
    {
      AppMethodBeat.i(187918);
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageStart failed, url is null");
        AppMethodBeat.o(187918);
        return;
      }
      this.lst = paramString;
      this.AZq = true;
      if (!this.AZo.containsKey(paramString)) {
        this.AZo.put(paramString, Long.valueOf(bt.eGO()));
      }
      if (!this.AZp.containsKey(paramString)) {
        this.AZp.put(paramString, Long.valueOf(bt.eGO()));
      }
      AppMethodBeat.o(187918);
    }
    
    public final void awP(String paramString)
    {
      AppMethodBeat.i(187919);
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onLoadResource failed, url is null");
        AppMethodBeat.o(187919);
        return;
      }
      try
      {
        if ((!bt.isNullOrNil(this.lst)) && (!paramString.equals(this.lst)) && (this.AZq))
        {
          if (this.AZo.containsKey(this.lst))
          {
            long l1 = ((Long)this.AZo.get(this.lst)).longValue();
            long l2 = bt.eGO();
            this.AZo.put(this.lst, Long.valueOf(l2 - l1));
          }
          this.AZq = false;
        }
        AppMethodBeat.o(187919);
        return;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.WebviewReporter", paramString, "onLoadResource", new Object[0]);
        AppMethodBeat.o(187919);
      }
    }
    
    public final void awQ(String paramString)
    {
      AppMethodBeat.i(187920);
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageFinish failed, url is null");
        AppMethodBeat.o(187920);
        return;
      }
      try
      {
        if (this.AZp.containsKey(paramString))
        {
          long l1 = ((Long)this.AZp.get(paramString)).longValue();
          long l2 = bt.eGO();
          this.AZp.put(paramString, Long.valueOf(l2 - l1));
        }
        AppMethodBeat.o(187920);
        return;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.WebviewReporter", paramString, "onPageFinish", new Object[0]);
        AppMethodBeat.o(187920);
      }
    }
    
    public final e cr(int paramInt, String paramString)
    {
      this.dEF = paramInt;
      this.AZr = paramString;
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(187921);
      int i = ax.baS();
      Iterator localIterator = this.AZo.entrySet().iterator();
      Object localObject;
      String str;
      long l;
      if (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        str = (String)((Map.Entry)localObject).getKey();
        l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        if ((l < 0L) || (l > 180000L))
        {
          AppMethodBeat.o(187921);
          return;
        }
        localObject = this.AZr;
        if (str == null) {}
        for (;;)
        {
          ax.t((String)localObject, new Object[] { Integer.valueOf(5), Long.valueOf(l), Integer.valueOf(i), str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ax.AZh), Integer.valueOf(ax.AZi), Integer.valueOf(this.dEF), this.AZr });
          if (ax.AZh == 1)
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(32L, 18L, 1L, true);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(32L, 19L, l, true);
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(32L, 8L, 1L, true);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(32L, 9L, l, true);
          ad.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report DomReady cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(ax.AZh), Integer.valueOf(ax.AZi), Integer.valueOf(this.dEF), this.AZr });
          break;
          str = str.replace(",", "!");
        }
      }
      localIterator = this.AZp.entrySet().iterator();
      if (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        str = (String)((Map.Entry)localObject).getKey();
        l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        if ((l < 0L) || (l > 180000L))
        {
          AppMethodBeat.o(187921);
          return;
        }
        localObject = this.AZr;
        if (str == null) {}
        for (;;)
        {
          ax.t((String)localObject, new Object[] { Integer.valueOf(6), Long.valueOf(l), Integer.valueOf(i), str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ax.AZh), Integer.valueOf(ax.AZi), Integer.valueOf(this.dEF), this.AZr });
          if (ax.AZh == 1)
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(32L, 20L, 1L, true);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(32L, 21L, l, true);
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(32L, 10L, 1L, true);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(32L, 11L, l, true);
          ad.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report Render cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(ax.AZh), Integer.valueOf(ax.AZi), Integer.valueOf(this.dEF), this.AZr });
          break;
          str = str.replace(",", "!");
        }
      }
      AppMethodBeat.o(187921);
    }
  }
  
  public final class f
  {
    public String AZr;
    private boolean cel;
    public int dEF;
    private long startTime;
    public String url;
    
    public f()
    {
      AppMethodBeat.i(79068);
      this.cel = false;
      this.startTime = bt.eGO();
      AppMethodBeat.o(79068);
    }
    
    public final void report()
    {
      AppMethodBeat.i(187922);
      int i;
      long l;
      String str2;
      if (!this.cel)
      {
        this.cel = true;
        i = ax.baS();
        l = bt.eGO() - this.startTime;
        if ((l < 0L) || (l > 180000L))
        {
          AppMethodBeat.o(187922);
          return;
        }
        str2 = this.AZr;
        if (this.url != null) {
          break label241;
        }
      }
      label241:
      for (String str1 = this.url;; str1 = this.url.replace(",", "!"))
      {
        ax.t(str2, new Object[] { Integer.valueOf(4), Long.valueOf(l), Integer.valueOf(i), str1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ax.AZh), Integer.valueOf(ax.AZi), Integer.valueOf(this.dEF), this.AZr });
        ad.i("MicroMsg.WebviewReporter", "WebViewTotalTimeReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { this.url, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(ax.AZh), Integer.valueOf(ax.AZi), Integer.valueOf(this.dEF), this.AZr });
        AppMethodBeat.o(187922);
        return;
      }
    }
  }
  
  public static final class g
  {
    private ArrayList<String> AZn;
    
    public g()
    {
      AppMethodBeat.i(187923);
      this.AZn = new ArrayList();
      AppMethodBeat.o(187923);
    }
    
    public final g A(Object... paramVarArgs)
    {
      AppMethodBeat.i(187924);
      int i = 0;
      if (i < 2)
      {
        Object localObject = paramVarArgs[i];
        ArrayList localArrayList = this.AZn;
        if (localObject != null) {}
        for (localObject = localObject.toString();; localObject = "")
        {
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(187924);
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(187925);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
      com.tencent.mm.plugin.report.service.h.h(11576, this.AZn);
      AppMethodBeat.o(187925);
    }
  }
  
  public static final class h
  {
    public List<String> AZs;
  }
  
  public static final class i
  {
    public List<String> AZs;
  }
  
  public final class j
  {
    private String AZr;
    private HashMap<String, Long> AZt;
    private int dEF;
    
    public j()
    {
      AppMethodBeat.i(79071);
      this.AZt = new HashMap();
      AppMethodBeat.o(79071);
    }
    
    public final void cb(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(79072);
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
        AppMethodBeat.o(79072);
        return;
      }
      if (this.AZt.containsKey(paramString))
      {
        if (paramBoolean)
        {
          long l1 = ((Long)this.AZt.get(paramString)).longValue();
          long l2 = bt.eGO();
          this.AZt.put(paramString, Long.valueOf(l2 - l1));
          AppMethodBeat.o(79072);
          return;
        }
        this.AZt.put(paramString, Long.valueOf(-1L));
      }
      AppMethodBeat.o(79072);
    }
    
    public final void report()
    {
      AppMethodBeat.i(187926);
      int i = ax.baS();
      Iterator localIterator = this.AZt.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str1 = (String)((Map.Entry)localObject).getKey();
        long l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(32L, 2L, 1L, true);
        if (l == -1L)
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(32L, 13L, 1L, true);
          ad.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report fail url : %s, netType : %d", new Object[] { str1, Integer.valueOf(i) });
        }
        if ((l >= 0L) && (l <= 60000L))
        {
          String str2 = this.AZr;
          if (str1 == null) {}
          for (localObject = str1;; localObject = str1.replace(",", "!"))
          {
            ax.t(str2, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(i), localObject, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ax.AZh), Integer.valueOf(ax.AZi), Integer.valueOf(this.dEF), this.AZr });
            ad.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report url : %s, cost time : %d, netType : %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { str1, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(this.dEF), this.AZr });
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(32L, 6L, l, true);
            break;
          }
        }
      }
      AppMethodBeat.o(187926);
    }
  }
  
  public final class k
  {
    String AZr;
    HashMap<String, Long> AZu;
    int dEF;
    
    public k()
    {
      AppMethodBeat.i(79074);
      this.AZu = new HashMap();
      AppMethodBeat.o(79074);
    }
    
    public final void awR(String paramString)
    {
      AppMethodBeat.i(187927);
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.startLoadUrl failed, url is null");
        AppMethodBeat.o(187927);
        return;
      }
      if (!this.AZu.containsKey(paramString)) {
        this.AZu.put(paramString, Long.valueOf(bt.eGO()));
      }
      AppMethodBeat.o(187927);
    }
    
    public final void awS(String paramString)
    {
      AppMethodBeat.i(187928);
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
        AppMethodBeat.o(187928);
        return;
      }
      if (this.AZu.containsKey(paramString))
      {
        long l1 = ((Long)this.AZu.get(paramString)).longValue();
        long l2 = bt.eGO();
        this.AZu.put(paramString, Long.valueOf(l2 - l1));
      }
      AppMethodBeat.o(187928);
    }
    
    public final k cs(int paramInt, String paramString)
    {
      this.dEF = paramInt;
      this.AZr = paramString;
      return this;
    }
  }
  
  public final class l
  {
    public String AZr;
    public int dEF;
    public boolean dhg = true;
    public long lrf;
    public String url;
    
    public l() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ax
 * JD-Core Version:    0.7.0.1
 */