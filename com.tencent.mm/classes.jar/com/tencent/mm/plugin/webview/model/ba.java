package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.ab;
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
  private static int PWs = 0;
  private static int PWt = 0;
  public m PWc;
  public k PWd;
  public l PWe;
  public ay PWf;
  private ak PWg;
  public g PWh;
  public b PWi;
  public h PWj;
  public d PWk;
  private f PWl;
  private j PWm;
  private i PWn;
  private c PWo;
  public a PWp;
  private av PWq;
  private as PWr;
  public int PWu;
  
  public ba()
  {
    AppMethodBeat.i(175743);
    this.PWu = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(175743);
  }
  
  public static void TB(long paramLong)
  {
    AppMethodBeat.i(79094);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(79094);
      return;
    }
    int i = (int)(System.currentTimeMillis() - paramLong);
    if ((i >= 0) && (i < 20000)) {
      h.IzE.a(16269, new Object[] { Integer.valueOf(i), Integer.valueOf((int)(paramLong / 1000L)) });
    }
    AppMethodBeat.o(79094);
  }
  
  public static void TC(long paramLong)
  {
    AppMethodBeat.i(230934);
    h.IzE.idkeyStat(1653L, paramLong, 1L, false);
    AppMethodBeat.o(230934);
  }
  
  public static int bTg()
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
  
  public static void bg(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (PWs = 1; paramBoolean2; PWs = 0)
    {
      PWt = 1;
      return;
    }
    PWt = 0;
  }
  
  public static String gVU()
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
  
  public final void C(String paramString, Object paramObject)
  {
    AppMethodBeat.i(79091);
    if (this.PWp != null) {
      try
      {
        this.PWp.r(paramString, paramObject);
        AppMethodBeat.o(79091);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(79091);
  }
  
  public final boolean aK(Bundle paramBundle)
  {
    AppMethodBeat.i(230927);
    if (paramBundle != null)
    {
      if (this.PWp != null) {
        this.PWp.fKb = null;
      }
      this.PWp = new a(paramBundle);
      AppMethodBeat.o(230927);
      return true;
    }
    AppMethodBeat.o(230927);
    return false;
  }
  
  public final void bkW(String paramString)
  {
    AppMethodBeat.i(79092);
    a locala;
    if (this.PWp != null) {
      try
      {
        locala = this.PWp;
        boolean bool = locala.fKb.containsKey(paramString);
        if (!bool) {
          break label68;
        }
        try
        {
          locala.r(paramString, Integer.valueOf(locala.fKb.getInt(paramString) + 1));
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
    locala.r(paramString, Integer.valueOf(1));
    AppMethodBeat.o(79092);
  }
  
  public final m gVV()
  {
    AppMethodBeat.i(79077);
    if (this.PWc == null) {
      this.PWc = new m();
    }
    m localm = this.PWc;
    AppMethodBeat.o(79077);
    return localm;
  }
  
  public final k gVW()
  {
    AppMethodBeat.i(79078);
    if (this.PWd == null) {
      this.PWd = new k();
    }
    k localk = this.PWd;
    AppMethodBeat.o(79078);
    return localk;
  }
  
  public final l gVX()
  {
    AppMethodBeat.i(79079);
    if (this.PWe == null) {
      this.PWe = new l();
    }
    l locall = this.PWe;
    AppMethodBeat.o(79079);
    return locall;
  }
  
  public final f gVY()
  {
    AppMethodBeat.i(79080);
    if (this.PWl == null) {
      this.PWl = new f();
    }
    f localf = this.PWl;
    AppMethodBeat.o(79080);
    return localf;
  }
  
  public final ay gVZ()
  {
    AppMethodBeat.i(230917);
    if (this.PWf == null) {
      this.PWf = new ay();
    }
    ay localay = this.PWf;
    AppMethodBeat.o(230917);
    return localay;
  }
  
  public final ak gWa()
  {
    AppMethodBeat.i(230919);
    if (this.PWg == null) {
      this.PWg = new ak();
    }
    ak localak = this.PWg;
    AppMethodBeat.o(230919);
    return localak;
  }
  
  public final g gWb()
  {
    AppMethodBeat.i(79083);
    if (this.PWh == null) {
      this.PWh = new g();
    }
    g localg = this.PWh;
    AppMethodBeat.o(79083);
    return localg;
  }
  
  public final b gWc()
  {
    AppMethodBeat.i(79084);
    if (this.PWi == null) {
      this.PWi = new b();
    }
    b localb = this.PWi;
    AppMethodBeat.o(79084);
    return localb;
  }
  
  public final h gWd()
  {
    AppMethodBeat.i(79085);
    if (this.PWj == null) {
      this.PWj = new h();
    }
    h localh = this.PWj;
    AppMethodBeat.o(79085);
    return localh;
  }
  
  public final d gWe()
  {
    AppMethodBeat.i(79086);
    if (this.PWk == null) {
      this.PWk = new d();
    }
    d locald = this.PWk;
    AppMethodBeat.o(79086);
    return locald;
  }
  
  public final j gWf()
  {
    AppMethodBeat.i(79087);
    if (this.PWm == null) {
      this.PWm = new j();
    }
    j localj = this.PWm;
    AppMethodBeat.o(79087);
    return localj;
  }
  
  public final i gWg()
  {
    AppMethodBeat.i(79088);
    if (this.PWn == null) {
      this.PWn = new i();
    }
    i locali = this.PWn;
    AppMethodBeat.o(79088);
    return locali;
  }
  
  public final c gWh()
  {
    AppMethodBeat.i(79089);
    if (this.PWo == null) {
      this.PWo = new c();
    }
    c localc = this.PWo;
    AppMethodBeat.o(79089);
    return localc;
  }
  
  public final av gWi()
  {
    AppMethodBeat.i(230923);
    if (this.PWq == null) {
      this.PWq = new av();
    }
    av localav = this.PWq;
    AppMethodBeat.o(230923);
    return localav;
  }
  
  public final as gWj()
  {
    AppMethodBeat.i(230925);
    if (this.PWr == null) {
      this.PWr = new as();
    }
    as localas = this.PWr;
    AppMethodBeat.o(230925);
    return localas;
  }
  
  public final class a
  {
    public Bundle fKb = null;
    
    a(Bundle paramBundle)
    {
      this.fKb = paramBundle;
    }
    
    public final void r(String paramString, Object paramObject)
    {
      AppMethodBeat.i(79061);
      if (this.fKb != null)
      {
        if ((paramObject instanceof String))
        {
          this.fKb.putString(paramString, (String)paramObject);
          AppMethodBeat.o(79061);
          return;
        }
        if ((paramObject instanceof Boolean))
        {
          this.fKb.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
          AppMethodBeat.o(79061);
          return;
        }
        if ((paramObject instanceof Integer))
        {
          this.fKb.putInt(paramString, ((Integer)paramObject).intValue());
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
    public boolean PWw = false;
    public String fXu;
    public boolean loadFinished = false;
    
    public final b bkX(String paramString)
    {
      this.fXu = paramString;
      return this;
    }
  }
  
  public static final class c
  {
    private boolean PWx = false;
    public boolean wNV = false;
    
    public final void dw(String paramString)
    {
      AppMethodBeat.i(215012);
      if ((!this.wNV) || (this.PWx))
      {
        AppMethodBeat.o(215012);
        return;
      }
      try
      {
        Object localObject = Uri.parse(paramString);
        if (!paramString.startsWith("http"))
        {
          Log.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, url not startswith http");
          AppMethodBeat.o(215012);
          return;
        }
        localObject = ((Uri)localObject).getHost();
        if ((localObject != null) && (((String)localObject).equalsIgnoreCase("v.html5.qq.com")))
        {
          h.IzE.idkeyStat(283L, 0L, 1L, true);
          this.PWx = true;
          Log.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, domain visit reported, url = %s", new Object[] { paramString });
        }
        AppMethodBeat.o(215012);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, parse url fail, url = %s", new Object[] { paramString });
        AppMethodBeat.o(215012);
      }
    }
  }
  
  public static final class d
  {
    private ArrayList<String> PWy;
    
    public d()
    {
      AppMethodBeat.i(227661);
      this.PWy = new ArrayList();
      AppMethodBeat.o(227661);
    }
    
    public final d C(Object... paramVarArgs)
    {
      AppMethodBeat.i(227664);
      int j = paramVarArgs.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramVarArgs[i];
        ArrayList localArrayList = this.PWy;
        if (localObject == null) {}
        for (localObject = "";; localObject = localObject.toString())
        {
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(227664);
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(227668);
      h localh = h.IzE;
      h.u(11577, this.PWy);
      AppMethodBeat.o(227668);
    }
  }
  
  public static final class e
  {
    public static void cI(String paramString, int paramInt)
    {
      AppMethodBeat.i(264157);
      paramString = ab.aXb(paramString);
      h.IzE.a(22999, new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(264157);
    }
  }
  
  public final class f
  {
    private ConcurrentHashMap<String, Long> PWA;
    private boolean PWB;
    private String PWC;
    private ConcurrentHashMap<String, Long> PWz;
    private int gco;
    private String pHO;
    
    public f()
    {
      AppMethodBeat.i(79063);
      this.pHO = "";
      this.PWB = true;
      this.PWz = new ConcurrentHashMap();
      this.PWA = new ConcurrentHashMap();
      AppMethodBeat.o(79063);
    }
    
    public final void bkY(String paramString)
    {
      AppMethodBeat.i(266125);
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageStart failed, url is null");
        AppMethodBeat.o(266125);
        return;
      }
      this.pHO = paramString;
      this.PWB = true;
      if (!this.PWz.containsKey(paramString)) {
        this.PWz.put(paramString, Long.valueOf(Util.nowMilliSecond()));
      }
      if (!this.PWA.containsKey(paramString)) {
        this.PWA.put(paramString, Long.valueOf(Util.nowMilliSecond()));
      }
      AppMethodBeat.o(266125);
    }
    
    public final void bkZ(String paramString)
    {
      AppMethodBeat.i(266128);
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onLoadResource failed, url is null");
        AppMethodBeat.o(266128);
        return;
      }
      try
      {
        if ((!Util.isNullOrNil(this.pHO)) && (!paramString.equals(this.pHO)) && (this.PWB))
        {
          if (this.PWz.containsKey(this.pHO))
          {
            long l1 = ((Long)this.PWz.get(this.pHO)).longValue();
            long l2 = Util.nowMilliSecond();
            this.PWz.put(this.pHO, Long.valueOf(l2 - l1));
          }
          this.PWB = false;
        }
        AppMethodBeat.o(266128);
        return;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.WebviewReporter", paramString, "onLoadResource", new Object[0]);
        AppMethodBeat.o(266128);
      }
    }
    
    public final void bla(String paramString)
    {
      AppMethodBeat.i(266131);
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageFinish failed, url is null");
        AppMethodBeat.o(266131);
        return;
      }
      try
      {
        if (this.PWA.containsKey(paramString))
        {
          long l1 = ((Long)this.PWA.get(paramString)).longValue();
          long l2 = Util.nowMilliSecond();
          this.PWA.put(paramString, Long.valueOf(l2 - l1));
        }
        AppMethodBeat.o(266131);
        return;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.WebviewReporter", paramString, "onPageFinish", new Object[0]);
        AppMethodBeat.o(266131);
      }
    }
    
    public final f cT(int paramInt, String paramString)
    {
      this.gco = paramInt;
      this.PWC = paramString;
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(266134);
      int i = ba.bTg();
      Iterator localIterator = this.PWz.entrySet().iterator();
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
          AppMethodBeat.o(266134);
          return;
        }
        localObject = this.PWC;
        if (str == null) {}
        for (;;)
        {
          ba.q((String)localObject, new Object[] { Integer.valueOf(5), Long.valueOf(l), Integer.valueOf(i), str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ba.access$000()), Integer.valueOf(ba.access$100()), Integer.valueOf(this.gco), this.PWC });
          if (ba.access$000() == 1)
          {
            h.IzE.idkeyStat(32L, 18L, 1L, true);
            h.IzE.idkeyStat(32L, 19L, l, true);
          }
          h.IzE.idkeyStat(32L, 8L, 1L, true);
          h.IzE.idkeyStat(32L, 9L, l, true);
          Log.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report DomReady cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(ba.access$000()), Integer.valueOf(ba.access$100()), Integer.valueOf(this.gco), this.PWC });
          break;
          str = str.replace(",", "!");
        }
      }
      localIterator = this.PWA.entrySet().iterator();
      if (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        str = (String)((Map.Entry)localObject).getKey();
        l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        if ((l < 0L) || (l > 180000L))
        {
          AppMethodBeat.o(266134);
          return;
        }
        localObject = this.PWC;
        if (str == null) {}
        for (;;)
        {
          ba.q((String)localObject, new Object[] { Integer.valueOf(6), Long.valueOf(l), Integer.valueOf(i), str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ba.access$000()), Integer.valueOf(ba.access$100()), Integer.valueOf(this.gco), this.PWC });
          if (ba.access$000() == 1)
          {
            h.IzE.idkeyStat(32L, 20L, 1L, true);
            h.IzE.idkeyStat(32L, 21L, l, true);
          }
          h.IzE.idkeyStat(32L, 10L, 1L, true);
          h.IzE.idkeyStat(32L, 11L, l, true);
          Log.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report Render cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(ba.access$000()), Integer.valueOf(ba.access$100()), Integer.valueOf(this.gco), this.PWC });
          break;
          str = str.replace(",", "!");
        }
      }
      AppMethodBeat.o(266134);
    }
  }
  
  public final class g
  {
    public String PWC;
    private boolean cwe;
    public int gco;
    private long startTime;
    public String url;
    
    public g()
    {
      AppMethodBeat.i(79068);
      this.cwe = false;
      this.startTime = Util.nowMilliSecond();
      AppMethodBeat.o(79068);
    }
    
    public final void report()
    {
      AppMethodBeat.i(264736);
      int i;
      long l;
      String str2;
      if (!this.cwe)
      {
        this.cwe = true;
        i = ba.bTg();
        l = Util.nowMilliSecond() - this.startTime;
        if ((l < 0L) || (l > 180000L))
        {
          AppMethodBeat.o(264736);
          return;
        }
        str2 = this.PWC;
        if (this.url != null) {
          break label241;
        }
      }
      label241:
      for (String str1 = this.url;; str1 = this.url.replace(",", "!"))
      {
        ba.q(str2, new Object[] { Integer.valueOf(4), Long.valueOf(l), Integer.valueOf(i), str1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ba.access$000()), Integer.valueOf(ba.access$100()), Integer.valueOf(this.gco), this.PWC });
        Log.i("MicroMsg.WebviewReporter", "WebViewTotalTimeReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { this.url, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(ba.access$000()), Integer.valueOf(ba.access$100()), Integer.valueOf(this.gco), this.PWC });
        AppMethodBeat.o(264736);
        return;
      }
    }
  }
  
  public static final class h
  {
    private ArrayList<String> PWy;
    
    public h()
    {
      AppMethodBeat.i(228731);
      this.PWy = new ArrayList();
      AppMethodBeat.o(228731);
    }
    
    public final h D(Object... paramVarArgs)
    {
      AppMethodBeat.i(228738);
      int i = 0;
      if (i < 2)
      {
        Object localObject = paramVarArgs[i];
        ArrayList localArrayList = this.PWy;
        if (localObject != null) {}
        for (localObject = localObject.toString().replace(',', ':');; localObject = "")
        {
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(228738);
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(228739);
      h localh = h.IzE;
      h.u(11576, this.PWy);
      AppMethodBeat.o(228739);
    }
  }
  
  public static final class i
  {
    public List<String> PWD;
  }
  
  public static final class j
  {
    public List<String> PWD;
  }
  
  public final class k
  {
    private String PWC;
    private HashMap<String, Long> PWE;
    private int gco;
    
    public k()
    {
      AppMethodBeat.i(79071);
      this.PWE = new HashMap();
      AppMethodBeat.o(79071);
    }
    
    public final void da(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(79072);
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
        AppMethodBeat.o(79072);
        return;
      }
      if (this.PWE.containsKey(paramString))
      {
        if (paramBoolean)
        {
          long l1 = ((Long)this.PWE.get(paramString)).longValue();
          long l2 = Util.nowMilliSecond();
          this.PWE.put(paramString, Long.valueOf(l2 - l1));
          AppMethodBeat.o(79072);
          return;
        }
        this.PWE.put(paramString, Long.valueOf(-1L));
      }
      AppMethodBeat.o(79072);
    }
    
    public final void report()
    {
      AppMethodBeat.i(257011);
      int i = ba.bTg();
      Iterator localIterator = this.PWE.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str1 = (String)((Map.Entry)localObject).getKey();
        long l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        h.IzE.idkeyStat(32L, 2L, 1L, true);
        if (l == -1L)
        {
          h.IzE.idkeyStat(32L, 13L, 1L, true);
          Log.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report fail url : %s, netType : %d", new Object[] { str1, Integer.valueOf(i) });
        }
        if ((l >= 0L) && (l <= 60000L))
        {
          String str2 = this.PWC;
          if (str1 == null) {}
          for (localObject = str1;; localObject = str1.replace(",", "!"))
          {
            ba.q(str2, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(i), localObject, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ba.access$000()), Integer.valueOf(ba.access$100()), Integer.valueOf(this.gco), this.PWC });
            Log.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report url : %s, cost time : %d, netType : %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { str1, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(this.gco), this.PWC });
            h.IzE.idkeyStat(32L, 6L, l, true);
            break;
          }
        }
      }
      AppMethodBeat.o(257011);
    }
  }
  
  public final class l
  {
    public String PWC;
    public HashMap<String, Long> PWF;
    public int gco;
    
    public l()
    {
      AppMethodBeat.i(79074);
      this.PWF = new HashMap();
      AppMethodBeat.o(79074);
    }
    
    public final void blb(String paramString)
    {
      AppMethodBeat.i(267106);
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.startLoadUrl failed, url is null");
        AppMethodBeat.o(267106);
        return;
      }
      if (!this.PWF.containsKey(paramString)) {
        this.PWF.put(paramString, Long.valueOf(Util.nowMilliSecond()));
      }
      AppMethodBeat.o(267106);
    }
    
    public final void blc(String paramString)
    {
      AppMethodBeat.i(267107);
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
        AppMethodBeat.o(267107);
        return;
      }
      if (this.PWF.containsKey(paramString))
      {
        long l1 = ((Long)this.PWF.get(paramString)).longValue();
        long l2 = Util.nowMilliSecond();
        this.PWF.put(paramString, Long.valueOf(l2 - l1));
      }
      AppMethodBeat.o(267107);
    }
    
    public final l cU(int paramInt, String paramString)
    {
      this.gco = paramInt;
      this.PWC = paramString;
      return this;
    }
  }
  
  public final class m
  {
    public String PWC;
    public long costTime;
    public int gco;
    public boolean isSuccess = true;
    public String url;
    
    public m() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ba
 * JD-Core Version:    0.7.0.1
 */