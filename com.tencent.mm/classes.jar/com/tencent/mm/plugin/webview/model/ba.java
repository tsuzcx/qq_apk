package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.h.a;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class ba
{
  private static int WMY = 0;
  private static int WMZ = 0;
  public m WMI;
  public k WMJ;
  public l WMK;
  public ay WML;
  private ak WMM;
  public g WMN;
  public b WMO;
  public h WMP;
  public d WMQ;
  private f WMR;
  private j WMS;
  private i WMT;
  private c WMU;
  public a WMV;
  private av WMW;
  private as WMX;
  public int WNa;
  
  public ba()
  {
    AppMethodBeat.i(175743);
    this.WNa = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(175743);
  }
  
  public static void bC(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (WMY = 1; paramBoolean2; WMY = 0)
    {
      WMZ = 1;
      return;
    }
    WMZ = 0;
  }
  
  public static int ctm()
  {
    AppMethodBeat.i(79075);
    if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(79075);
      return 5;
    }
    if (NetStatusUtil.is5G(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(79075);
      return 7;
    }
    switch (NetStatusUtil.getNetType(MMApplicationContext.getContext()))
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
  
  public static String fTX()
  {
    AppMethodBeat.i(79076);
    Object localObject = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
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
    Log.d("MicroMsg.WebviewReporter", "activeNetInfo extra=%s, type=%d, %s", new Object[] { ((NetworkInfo)localObject).getExtraInfo(), Integer.valueOf(((NetworkInfo)localObject).getType()), ((NetworkInfo)localObject).getExtraInfo() });
    if (((NetworkInfo)localObject).getExtraInfo() != null)
    {
      localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      AppMethodBeat.o(79076);
      return localObject;
    }
    AppMethodBeat.o(79076);
    return "no";
  }
  
  private static void q(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(298275);
    ArrayList localArrayList = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(String.valueOf(paramVarArgs[i]));
      i += 1;
    }
    paramVarArgs = h.OAn;
    h.P(11215, localArrayList);
    if ((paramString != null) && (paramString.startsWith("official_mall")))
    {
      paramString = h.OAn;
      h.P(14919, localArrayList);
    }
    AppMethodBeat.o(298275);
  }
  
  public static void xL(long paramLong)
  {
    AppMethodBeat.i(79094);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(79094);
      return;
    }
    int i = (int)(System.currentTimeMillis() - paramLong);
    if ((i >= 0) && (i < 20000)) {
      h.OAn.b(16269, new Object[] { Integer.valueOf(i), Integer.valueOf((int)(paramLong / 1000L)) });
    }
    AppMethodBeat.o(79094);
  }
  
  public static void xM(long paramLong)
  {
    AppMethodBeat.i(298278);
    h.OAn.idkeyStat(1653L, paramLong, 1L, false);
    AppMethodBeat.o(298278);
  }
  
  public final void O(String paramString, Object paramObject)
  {
    AppMethodBeat.i(79091);
    if (this.WMV != null) {
      try
      {
        this.WMV.z(paramString, paramObject);
        AppMethodBeat.o(79091);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(79091);
  }
  
  public final void bkF(String paramString)
  {
    AppMethodBeat.i(79092);
    a locala;
    if (this.WMV != null) {
      try
      {
        locala = this.WMV;
        boolean bool = locala.hPH.containsKey(paramString);
        if (!bool) {
          break label68;
        }
        try
        {
          locala.z(paramString, Integer.valueOf(locala.hPH.getInt(paramString) + 1));
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
    locala.z(paramString, Integer.valueOf(1));
    AppMethodBeat.o(79092);
  }
  
  public final boolean bo(Bundle paramBundle)
  {
    AppMethodBeat.i(298347);
    if (paramBundle != null)
    {
      if (this.WMV != null) {
        this.WMV.hPH = null;
      }
      this.WMV = new a(paramBundle);
      AppMethodBeat.o(298347);
      return true;
    }
    AppMethodBeat.o(298347);
    return false;
  }
  
  public final m ivC()
  {
    AppMethodBeat.i(79077);
    if (this.WMI == null) {
      this.WMI = new m();
    }
    m localm = this.WMI;
    AppMethodBeat.o(79077);
    return localm;
  }
  
  public final k ivD()
  {
    AppMethodBeat.i(79078);
    if (this.WMJ == null) {
      this.WMJ = new k();
    }
    k localk = this.WMJ;
    AppMethodBeat.o(79078);
    return localk;
  }
  
  public final l ivE()
  {
    AppMethodBeat.i(79079);
    if (this.WMK == null) {
      this.WMK = new l();
    }
    l locall = this.WMK;
    AppMethodBeat.o(79079);
    return locall;
  }
  
  public final f ivF()
  {
    AppMethodBeat.i(79080);
    if (this.WMR == null) {
      this.WMR = new f();
    }
    f localf = this.WMR;
    AppMethodBeat.o(79080);
    return localf;
  }
  
  public final ay ivG()
  {
    AppMethodBeat.i(298314);
    if (this.WML == null) {
      this.WML = new ay();
    }
    ay localay = this.WML;
    AppMethodBeat.o(298314);
    return localay;
  }
  
  public final ak ivH()
  {
    AppMethodBeat.i(298317);
    if (this.WMM == null) {
      this.WMM = new ak();
    }
    ak localak = this.WMM;
    AppMethodBeat.o(298317);
    return localak;
  }
  
  public final g ivI()
  {
    AppMethodBeat.i(79083);
    if (this.WMN == null) {
      this.WMN = new g();
    }
    g localg = this.WMN;
    AppMethodBeat.o(79083);
    return localg;
  }
  
  public final b ivJ()
  {
    AppMethodBeat.i(79084);
    if (this.WMO == null) {
      this.WMO = new b();
    }
    b localb = this.WMO;
    AppMethodBeat.o(79084);
    return localb;
  }
  
  public final h ivK()
  {
    AppMethodBeat.i(79085);
    if (this.WMP == null) {
      this.WMP = new h();
    }
    h localh = this.WMP;
    AppMethodBeat.o(79085);
    return localh;
  }
  
  public final d ivL()
  {
    AppMethodBeat.i(79086);
    if (this.WMQ == null) {
      this.WMQ = new d();
    }
    d locald = this.WMQ;
    AppMethodBeat.o(79086);
    return locald;
  }
  
  public final j ivM()
  {
    AppMethodBeat.i(79087);
    if (this.WMS == null) {
      this.WMS = new j();
    }
    j localj = this.WMS;
    AppMethodBeat.o(79087);
    return localj;
  }
  
  public final i ivN()
  {
    AppMethodBeat.i(79088);
    if (this.WMT == null) {
      this.WMT = new i();
    }
    i locali = this.WMT;
    AppMethodBeat.o(79088);
    return locali;
  }
  
  public final c ivO()
  {
    AppMethodBeat.i(79089);
    if (this.WMU == null) {
      this.WMU = new c();
    }
    c localc = this.WMU;
    AppMethodBeat.o(79089);
    return localc;
  }
  
  public final av ivP()
  {
    AppMethodBeat.i(298341);
    if (this.WMW == null) {
      this.WMW = new av();
    }
    av localav = this.WMW;
    AppMethodBeat.o(298341);
    return localav;
  }
  
  public final as ivQ()
  {
    AppMethodBeat.i(298345);
    if (this.WMX == null) {
      this.WMX = new as();
    }
    as localas = this.WMX;
    AppMethodBeat.o(298345);
    return localas;
  }
  
  public final void report()
  {
    AppMethodBeat.i(298369);
    Object localObject3 = ivE();
    int i = ctm();
    Object localObject4 = ((l)localObject3).WNk.entrySet().iterator();
    Object localObject1;
    long l;
    String str;
    while (((Iterator)localObject4).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject4).next();
      localObject2 = (String)((Map.Entry)localObject1).getKey();
      l = ((Long)((Map.Entry)localObject1).getValue()).longValue();
      h.OAn.idkeyStat(32L, 0L, 1L, true);
      if ((l >= 0L) && (l <= 180000L))
      {
        str = ((l)localObject3).WNh;
        if (localObject2 == null) {}
        for (localObject1 = localObject2;; localObject1 = ((String)localObject2).replace(",", "!"))
        {
          q(str, new Object[] { Integer.valueOf(3), Long.valueOf(l), Integer.valueOf(i), localObject1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(WMY), Integer.valueOf(WMZ), Integer.valueOf(((l)localObject3).iiA), ((l)localObject3).WNh });
          h.OAn.idkeyStat(160L, 0L, 1L, false);
          if (-1 != a.xN(l)) {
            h.OAn.idkeyStat(160L, a.xN(l), 1L, false);
          }
          h.OAn.idkeyStat(32L, 3L, 1L, true);
          h.OAn.idkeyStat(32L, 7L, l, true);
          if (WMZ == 1)
          {
            h.OAn.idkeyStat(32L, 16L, 1L, true);
            h.OAn.idkeyStat(32L, 17L, l, true);
          }
          Log.i("MicroMsg.WebviewReporter", "WebviewOpenUrlReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { localObject2, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(WMY), Integer.valueOf(WMZ), Integer.valueOf(((l)localObject3).iiA), ((l)localObject3).WNh });
          break;
        }
      }
    }
    ivG().report();
    ivH().report();
    localObject3 = ivD();
    i = ctm();
    localObject4 = ((k)localObject3).WNj.entrySet().iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject4).next();
      localObject2 = (String)((Map.Entry)localObject1).getKey();
      l = ((Long)((Map.Entry)localObject1).getValue()).longValue();
      h.OAn.idkeyStat(32L, 2L, 1L, true);
      if (l == -1L)
      {
        h.OAn.idkeyStat(32L, 13L, 1L, true);
        Log.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report fail url : %s, netType : %d", new Object[] { localObject2, Integer.valueOf(i) });
      }
      if ((l >= 0L) && (l <= 60000L))
      {
        str = ((k)localObject3).WNh;
        if (localObject2 == null) {}
        for (localObject1 = localObject2;; localObject1 = ((String)localObject2).replace(",", "!"))
        {
          q(str, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(i), localObject1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(WMY), Integer.valueOf(WMZ), Integer.valueOf(((k)localObject3).iiA), ((k)localObject3).WNh });
          Log.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report url : %s, cost time : %d, netType : %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { localObject2, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(((k)localObject3).iiA), ((k)localObject3).WNh });
          h.OAn.idkeyStat(32L, 6L, l, true);
          break;
        }
      }
    }
    Object localObject2 = ivF();
    i = ctm();
    localObject3 = ((f)localObject2).WNe.entrySet().iterator();
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject3).next();
      localObject1 = (String)((Map.Entry)localObject4).getKey();
      l = ((Long)((Map.Entry)localObject4).getValue()).longValue();
      if ((l >= 0L) && (l <= 180000L)) {}
    }
    label1201:
    do
    {
      localObject1 = ivJ();
      i = ctm();
      if (!((b)localObject1).WNc) {
        break label1570;
      }
      if (!((b)localObject1).loadFinished) {
        break label1521;
      }
      h.OAn.b(11575, new Object[] { ((b)localObject1).idu, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(298369);
      return;
      localObject4 = ((f)localObject2).WNh;
      if (localObject1 == null) {}
      for (;;)
      {
        q((String)localObject4, new Object[] { Integer.valueOf(5), Long.valueOf(l), Integer.valueOf(i), localObject1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(WMY), Integer.valueOf(WMZ), Integer.valueOf(((f)localObject2).iiA), ((f)localObject2).WNh });
        if (WMY == 1)
        {
          h.OAn.idkeyStat(32L, 18L, 1L, true);
          h.OAn.idkeyStat(32L, 19L, l, true);
        }
        h.OAn.idkeyStat(32L, 8L, 1L, true);
        h.OAn.idkeyStat(32L, 9L, l, true);
        Log.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report DomReady cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(WMY), Integer.valueOf(WMZ), Integer.valueOf(((f)localObject2).iiA), ((f)localObject2).WNh });
        break;
        localObject1 = ((String)localObject1).replace(",", "!");
      }
      localObject3 = ((f)localObject2).WNf.entrySet().iterator();
      if (!((Iterator)localObject3).hasNext()) {
        break label1503;
      }
      localObject4 = (Map.Entry)((Iterator)localObject3).next();
      localObject1 = (String)((Map.Entry)localObject4).getKey();
      l = ((Long)((Map.Entry)localObject4).getValue()).longValue();
    } while ((l < 0L) || (l > 180000L));
    localObject4 = ((f)localObject2).WNh;
    if (localObject1 == null) {}
    for (;;)
    {
      q((String)localObject4, new Object[] { Integer.valueOf(6), Long.valueOf(l), Integer.valueOf(i), localObject1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(WMY), Integer.valueOf(WMZ), Integer.valueOf(((f)localObject2).iiA), ((f)localObject2).WNh });
      if (WMY == 1)
      {
        h.OAn.idkeyStat(32L, 20L, 1L, true);
        h.OAn.idkeyStat(32L, 21L, l, true);
      }
      h.OAn.idkeyStat(32L, 10L, 1L, true);
      h.OAn.idkeyStat(32L, 11L, l, true);
      Log.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report Render cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(WMY), Integer.valueOf(WMZ), Integer.valueOf(((f)localObject2).iiA), ((f)localObject2).WNh });
      break label1201;
      label1503:
      break;
      localObject1 = ((String)localObject1).replace(",", "!");
    }
    label1521:
    h.OAn.b(11575, new Object[] { ((b)localObject1).idu, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(i) });
    AppMethodBeat.o(298369);
    return;
    label1570:
    h.OAn.b(11575, new Object[] { ((b)localObject1).idu, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(i) });
    AppMethodBeat.o(298369);
  }
  
  public final class a
  {
    public Bundle hPH = null;
    
    a(Bundle paramBundle)
    {
      this.hPH = paramBundle;
    }
    
    public final void z(String paramString, Object paramObject)
    {
      AppMethodBeat.i(79061);
      if (this.hPH != null)
      {
        if ((paramObject instanceof String))
        {
          this.hPH.putString(paramString, (String)paramObject);
          AppMethodBeat.o(79061);
          return;
        }
        if ((paramObject instanceof Boolean))
        {
          this.hPH.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
          AppMethodBeat.o(79061);
          return;
        }
        if ((paramObject instanceof Integer))
        {
          this.hPH.putInt(paramString, ((Integer)paramObject).intValue());
          AppMethodBeat.o(79061);
          return;
        }
        Log.w("MicroMsg.WebviewReporter", "put unknow type value.");
      }
      AppMethodBeat.o(79061);
    }
  }
  
  public static final class b
  {
    public boolean WNc = false;
    public String idu;
    public boolean loadFinished = false;
  }
  
  public static final class c
  {
    public boolean Akx = false;
    public boolean FrG = false;
  }
  
  public static final class d
  {
    private ArrayList<String> WNd;
    
    public d()
    {
      AppMethodBeat.i(298364);
      this.WNd = new ArrayList();
      AppMethodBeat.o(298364);
    }
    
    public static void G(Object... paramVarArgs)
    {
      AppMethodBeat.i(298371);
      h.OAn.b(11577, paramVarArgs);
      AppMethodBeat.o(298371);
    }
    
    public final d F(Object... paramVarArgs)
    {
      AppMethodBeat.i(298375);
      int j = paramVarArgs.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramVarArgs[i];
        ArrayList localArrayList = this.WNd;
        if (localObject == null) {}
        for (localObject = "";; localObject = localObject.toString())
        {
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(298375);
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(298379);
      h localh = h.OAn;
      h.P(11577, this.WNd);
      AppMethodBeat.o(298379);
    }
  }
  
  public static final class e
  {
    public static void dh(String paramString, int paramInt)
    {
      AppMethodBeat.i(298360);
      paramString = aa.aUC(paramString);
      h.OAn.b(22999, new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(298360);
    }
  }
  
  public final class f
  {
    public ConcurrentHashMap<String, Long> WNe;
    public ConcurrentHashMap<String, Long> WNf;
    public boolean WNg;
    public String WNh;
    public int iiA;
    public String sML;
    
    public f()
    {
      AppMethodBeat.i(79063);
      this.sML = "";
      this.WNg = true;
      this.WNe = new ConcurrentHashMap();
      this.WNf = new ConcurrentHashMap();
      AppMethodBeat.o(79063);
    }
  }
  
  public final class g
  {
    public String WNh;
    public boolean eoc;
    public int iiA;
    public long startTime;
    public String url;
    
    public g()
    {
      AppMethodBeat.i(79068);
      this.eoc = false;
      this.startTime = Util.nowMilliSecond();
      AppMethodBeat.o(79068);
    }
  }
  
  public static final class h
  {
    private ArrayList<String> WNd;
    
    public h()
    {
      AppMethodBeat.i(298365);
      this.WNd = new ArrayList();
      AppMethodBeat.o(298365);
    }
    
    public final h H(Object... paramVarArgs)
    {
      AppMethodBeat.i(298370);
      int i = 0;
      if (i < 2)
      {
        Object localObject = paramVarArgs[i];
        ArrayList localArrayList = this.WNd;
        if (localObject != null) {}
        for (localObject = localObject.toString().replace(',', ':');; localObject = "")
        {
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(298370);
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(298372);
      h localh = h.OAn;
      h.P(11576, this.WNd);
      AppMethodBeat.o(298372);
    }
  }
  
  public static final class i
  {
    public List<String> WNi;
  }
  
  public static final class j
  {
    public List<String> WNi;
  }
  
  public final class k
  {
    String WNh;
    HashMap<String, Long> WNj;
    int iiA;
    
    public k()
    {
      AppMethodBeat.i(79071);
      this.WNj = new HashMap();
      AppMethodBeat.o(79071);
    }
    
    public final void dH(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(79072);
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
        AppMethodBeat.o(79072);
        return;
      }
      if (this.WNj.containsKey(paramString))
      {
        if (paramBoolean)
        {
          long l1 = ((Long)this.WNj.get(paramString)).longValue();
          long l2 = Util.nowMilliSecond();
          this.WNj.put(paramString, Long.valueOf(l2 - l1));
          AppMethodBeat.o(79072);
          return;
        }
        this.WNj.put(paramString, Long.valueOf(-1L));
      }
      AppMethodBeat.o(79072);
    }
  }
  
  public final class l
  {
    public String WNh;
    public HashMap<String, Long> WNk;
    public int iiA;
    
    public l()
    {
      AppMethodBeat.i(79074);
      this.WNk = new HashMap();
      AppMethodBeat.o(79074);
    }
  }
  
  public final class m
  {
    public String WNh;
    public long costTime;
    public int iiA;
    public boolean isSuccess = true;
    public String url;
    
    public m() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ba
 * JD-Core Version:    0.7.0.1
 */