package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
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

public final class az
{
  private static int Jaa = 0;
  private static int Jab = 0;
  public l IZL;
  public j IZM;
  public k IZN;
  public ax IZO;
  private ak IZP;
  public f IZQ;
  public b IZR;
  public g IZS;
  public d IZT;
  private e IZU;
  private i IZV;
  private h IZW;
  private c IZX;
  public a IZY;
  private au IZZ;
  public int Jac;
  
  public az()
  {
    AppMethodBeat.i(175743);
    this.Jac = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(175743);
  }
  
  public static void Md(long paramLong)
  {
    AppMethodBeat.i(79094);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(79094);
      return;
    }
    int i = (int)(System.currentTimeMillis() - paramLong);
    if ((i >= 0) && (i < 20000)) {
      h.CyF.a(16269, new Object[] { Integer.valueOf(i), Integer.valueOf((int)(paramLong / 1000L)) });
    }
    AppMethodBeat.o(79094);
  }
  
  public static void aU(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (Jaa = 1; paramBoolean2; Jaa = 0)
    {
      Jab = 1;
      return;
    }
    Jab = 0;
  }
  
  public static int bHy()
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
  
  public static String gcX()
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
  
  public final void D(String paramString, Object paramObject)
  {
    AppMethodBeat.i(79091);
    if (this.IZY != null) {
      try
      {
        this.IZY.putValue(paramString, paramObject);
        AppMethodBeat.o(79091);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(79091);
  }
  
  public final boolean aO(Bundle paramBundle)
  {
    AppMethodBeat.i(211021);
    if (paramBundle != null)
    {
      if (this.IZY != null) {
        this.IZY.dQL = null;
      }
      this.IZY = new a(paramBundle);
      AppMethodBeat.o(211021);
      return true;
    }
    AppMethodBeat.o(211021);
    return false;
  }
  
  public final void aZc(String paramString)
  {
    AppMethodBeat.i(79092);
    a locala;
    if (this.IZY != null) {
      try
      {
        locala = this.IZY;
        boolean bool = locala.dQL.containsKey(paramString);
        if (!bool) {
          break label68;
        }
        try
        {
          locala.putValue(paramString, Integer.valueOf(locala.dQL.getInt(paramString) + 1));
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
  
  public final l gcY()
  {
    AppMethodBeat.i(79077);
    if (this.IZL == null) {
      this.IZL = new l();
    }
    l locall = this.IZL;
    AppMethodBeat.o(79077);
    return locall;
  }
  
  public final j gcZ()
  {
    AppMethodBeat.i(79078);
    if (this.IZM == null) {
      this.IZM = new j();
    }
    j localj = this.IZM;
    AppMethodBeat.o(79078);
    return localj;
  }
  
  public final k gda()
  {
    AppMethodBeat.i(79079);
    if (this.IZN == null) {
      this.IZN = new k();
    }
    k localk = this.IZN;
    AppMethodBeat.o(79079);
    return localk;
  }
  
  public final e gdb()
  {
    AppMethodBeat.i(79080);
    if (this.IZU == null) {
      this.IZU = new e();
    }
    e locale = this.IZU;
    AppMethodBeat.o(79080);
    return locale;
  }
  
  public final ax gdc()
  {
    AppMethodBeat.i(211018);
    if (this.IZO == null) {
      this.IZO = new ax();
    }
    ax localax = this.IZO;
    AppMethodBeat.o(211018);
    return localax;
  }
  
  public final ak gdd()
  {
    AppMethodBeat.i(211019);
    if (this.IZP == null) {
      this.IZP = new ak();
    }
    ak localak = this.IZP;
    AppMethodBeat.o(211019);
    return localak;
  }
  
  public final f gde()
  {
    AppMethodBeat.i(79083);
    if (this.IZQ == null) {
      this.IZQ = new f();
    }
    f localf = this.IZQ;
    AppMethodBeat.o(79083);
    return localf;
  }
  
  public final b gdf()
  {
    AppMethodBeat.i(79084);
    if (this.IZR == null) {
      this.IZR = new b();
    }
    b localb = this.IZR;
    AppMethodBeat.o(79084);
    return localb;
  }
  
  public final g gdg()
  {
    AppMethodBeat.i(79085);
    if (this.IZS == null) {
      this.IZS = new g();
    }
    g localg = this.IZS;
    AppMethodBeat.o(79085);
    return localg;
  }
  
  public final d gdh()
  {
    AppMethodBeat.i(79086);
    if (this.IZT == null) {
      this.IZT = new d();
    }
    d locald = this.IZT;
    AppMethodBeat.o(79086);
    return locald;
  }
  
  public final i gdi()
  {
    AppMethodBeat.i(79087);
    if (this.IZV == null) {
      this.IZV = new i();
    }
    i locali = this.IZV;
    AppMethodBeat.o(79087);
    return locali;
  }
  
  public final h gdj()
  {
    AppMethodBeat.i(79088);
    if (this.IZW == null) {
      this.IZW = new h();
    }
    h localh = this.IZW;
    AppMethodBeat.o(79088);
    return localh;
  }
  
  public final c gdk()
  {
    AppMethodBeat.i(79089);
    if (this.IZX == null) {
      this.IZX = new c();
    }
    c localc = this.IZX;
    AppMethodBeat.o(79089);
    return localc;
  }
  
  public final au gdl()
  {
    AppMethodBeat.i(211020);
    if (this.IZZ == null) {
      this.IZZ = new au();
    }
    au localau = this.IZZ;
    AppMethodBeat.o(211020);
    return localau;
  }
  
  public final class a
  {
    public Bundle dQL = null;
    
    a(Bundle paramBundle)
    {
      this.dQL = paramBundle;
    }
    
    public final void putValue(String paramString, Object paramObject)
    {
      AppMethodBeat.i(79061);
      if (this.dQL != null)
      {
        if ((paramObject instanceof String))
        {
          this.dQL.putString(paramString, (String)paramObject);
          AppMethodBeat.o(79061);
          return;
        }
        if ((paramObject instanceof Boolean))
        {
          this.dQL.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
          AppMethodBeat.o(79061);
          return;
        }
        if ((paramObject instanceof Integer))
        {
          this.dQL.putInt(paramString, ((Integer)paramObject).intValue());
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
    public boolean Jae = false;
    public String edo;
    public boolean loadFinished = false;
    
    public final b aZd(String paramString)
    {
      this.edo = paramString;
      return this;
    }
  }
  
  public static final class c
  {
    private boolean Jaf = false;
    public boolean thE = false;
    
    public final void cW(String paramString)
    {
      AppMethodBeat.i(211003);
      if ((!this.thE) || (this.Jaf))
      {
        AppMethodBeat.o(211003);
        return;
      }
      try
      {
        Object localObject = Uri.parse(paramString);
        if (!paramString.startsWith("http"))
        {
          Log.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, url not startswith http");
          AppMethodBeat.o(211003);
          return;
        }
        localObject = ((Uri)localObject).getHost();
        if ((localObject != null) && (((String)localObject).equalsIgnoreCase("v.html5.qq.com")))
        {
          h.CyF.idkeyStat(283L, 0L, 1L, true);
          this.Jaf = true;
          Log.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, domain visit reported, url = %s", new Object[] { paramString });
        }
        AppMethodBeat.o(211003);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, parse url fail, url = %s", new Object[] { paramString });
        AppMethodBeat.o(211003);
      }
    }
  }
  
  public static final class d
  {
    private ArrayList<String> Jag;
    
    public d()
    {
      AppMethodBeat.i(211004);
      this.Jag = new ArrayList();
      AppMethodBeat.o(211004);
    }
    
    public final d C(Object... paramVarArgs)
    {
      AppMethodBeat.i(211005);
      int j = paramVarArgs.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramVarArgs[i];
        ArrayList localArrayList = this.Jag;
        if (localObject == null) {}
        for (localObject = "";; localObject = localObject.toString())
        {
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(211005);
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(211006);
      h localh = h.CyF;
      h.r(11577, this.Jag);
      AppMethodBeat.o(211006);
    }
  }
  
  public final class e
  {
    private ConcurrentHashMap<String, Long> Jah;
    private ConcurrentHashMap<String, Long> Jai;
    private boolean Jaj;
    private String Jak;
    private int ehX;
    private String nKc;
    
    public e()
    {
      AppMethodBeat.i(79063);
      this.nKc = "";
      this.Jaj = true;
      this.Jah = new ConcurrentHashMap();
      this.Jai = new ConcurrentHashMap();
      AppMethodBeat.o(79063);
    }
    
    public final void aZe(String paramString)
    {
      AppMethodBeat.i(211007);
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageStart failed, url is null");
        AppMethodBeat.o(211007);
        return;
      }
      this.nKc = paramString;
      this.Jaj = true;
      if (!this.Jah.containsKey(paramString)) {
        this.Jah.put(paramString, Long.valueOf(Util.nowMilliSecond()));
      }
      if (!this.Jai.containsKey(paramString)) {
        this.Jai.put(paramString, Long.valueOf(Util.nowMilliSecond()));
      }
      AppMethodBeat.o(211007);
    }
    
    public final void aZf(String paramString)
    {
      AppMethodBeat.i(211008);
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onLoadResource failed, url is null");
        AppMethodBeat.o(211008);
        return;
      }
      try
      {
        if ((!Util.isNullOrNil(this.nKc)) && (!paramString.equals(this.nKc)) && (this.Jaj))
        {
          if (this.Jah.containsKey(this.nKc))
          {
            long l1 = ((Long)this.Jah.get(this.nKc)).longValue();
            long l2 = Util.nowMilliSecond();
            this.Jah.put(this.nKc, Long.valueOf(l2 - l1));
          }
          this.Jaj = false;
        }
        AppMethodBeat.o(211008);
        return;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.WebviewReporter", paramString, "onLoadResource", new Object[0]);
        AppMethodBeat.o(211008);
      }
    }
    
    public final void aZg(String paramString)
    {
      AppMethodBeat.i(211009);
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageFinish failed, url is null");
        AppMethodBeat.o(211009);
        return;
      }
      try
      {
        if (this.Jai.containsKey(paramString))
        {
          long l1 = ((Long)this.Jai.get(paramString)).longValue();
          long l2 = Util.nowMilliSecond();
          this.Jai.put(paramString, Long.valueOf(l2 - l1));
        }
        AppMethodBeat.o(211009);
        return;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.WebviewReporter", paramString, "onPageFinish", new Object[0]);
        AppMethodBeat.o(211009);
      }
    }
    
    public final e cT(int paramInt, String paramString)
    {
      this.ehX = paramInt;
      this.Jak = paramString;
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(211010);
      int i = az.bHy();
      Iterator localIterator = this.Jah.entrySet().iterator();
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
          AppMethodBeat.o(211010);
          return;
        }
        localObject = this.Jak;
        if (str == null) {}
        for (;;)
        {
          az.r((String)localObject, new Object[] { Integer.valueOf(5), Long.valueOf(l), Integer.valueOf(i), str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(az.access$000()), Integer.valueOf(az.access$100()), Integer.valueOf(this.ehX), this.Jak });
          if (az.access$000() == 1)
          {
            h.CyF.idkeyStat(32L, 18L, 1L, true);
            h.CyF.idkeyStat(32L, 19L, l, true);
          }
          h.CyF.idkeyStat(32L, 8L, 1L, true);
          h.CyF.idkeyStat(32L, 9L, l, true);
          Log.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report DomReady cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(az.access$000()), Integer.valueOf(az.access$100()), Integer.valueOf(this.ehX), this.Jak });
          break;
          str = str.replace(",", "!");
        }
      }
      localIterator = this.Jai.entrySet().iterator();
      if (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        str = (String)((Map.Entry)localObject).getKey();
        l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        if ((l < 0L) || (l > 180000L))
        {
          AppMethodBeat.o(211010);
          return;
        }
        localObject = this.Jak;
        if (str == null) {}
        for (;;)
        {
          az.r((String)localObject, new Object[] { Integer.valueOf(6), Long.valueOf(l), Integer.valueOf(i), str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(az.access$000()), Integer.valueOf(az.access$100()), Integer.valueOf(this.ehX), this.Jak });
          if (az.access$000() == 1)
          {
            h.CyF.idkeyStat(32L, 20L, 1L, true);
            h.CyF.idkeyStat(32L, 21L, l, true);
          }
          h.CyF.idkeyStat(32L, 10L, 1L, true);
          h.CyF.idkeyStat(32L, 11L, l, true);
          Log.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report Render cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(az.access$000()), Integer.valueOf(az.access$100()), Integer.valueOf(this.ehX), this.Jak });
          break;
          str = str.replace(",", "!");
        }
      }
      AppMethodBeat.o(211010);
    }
  }
  
  public final class f
  {
    public String Jak;
    private boolean cxw;
    public int ehX;
    private long startTime;
    public String url;
    
    public f()
    {
      AppMethodBeat.i(79068);
      this.cxw = false;
      this.startTime = Util.nowMilliSecond();
      AppMethodBeat.o(79068);
    }
    
    public final void report()
    {
      AppMethodBeat.i(211011);
      int i;
      long l;
      String str2;
      if (!this.cxw)
      {
        this.cxw = true;
        i = az.bHy();
        l = Util.nowMilliSecond() - this.startTime;
        if ((l < 0L) || (l > 180000L))
        {
          AppMethodBeat.o(211011);
          return;
        }
        str2 = this.Jak;
        if (this.url != null) {
          break label241;
        }
      }
      label241:
      for (String str1 = this.url;; str1 = this.url.replace(",", "!"))
      {
        az.r(str2, new Object[] { Integer.valueOf(4), Long.valueOf(l), Integer.valueOf(i), str1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(az.access$000()), Integer.valueOf(az.access$100()), Integer.valueOf(this.ehX), this.Jak });
        Log.i("MicroMsg.WebviewReporter", "WebViewTotalTimeReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { this.url, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(az.access$000()), Integer.valueOf(az.access$100()), Integer.valueOf(this.ehX), this.Jak });
        AppMethodBeat.o(211011);
        return;
      }
    }
  }
  
  public static final class g
  {
    private ArrayList<String> Jag;
    
    public g()
    {
      AppMethodBeat.i(211012);
      this.Jag = new ArrayList();
      AppMethodBeat.o(211012);
    }
    
    public final g D(Object... paramVarArgs)
    {
      AppMethodBeat.i(211013);
      int i = 0;
      if (i < 2)
      {
        Object localObject = paramVarArgs[i];
        ArrayList localArrayList = this.Jag;
        if (localObject != null) {}
        for (localObject = localObject.toString();; localObject = "")
        {
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(211013);
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(211014);
      h localh = h.CyF;
      h.r(11576, this.Jag);
      AppMethodBeat.o(211014);
    }
  }
  
  public static final class h
  {
    public List<String> Jal;
  }
  
  public static final class i
  {
    public List<String> Jal;
  }
  
  public final class j
  {
    private String Jak;
    private HashMap<String, Long> Jam;
    private int ehX;
    
    public j()
    {
      AppMethodBeat.i(79071);
      this.Jam = new HashMap();
      AppMethodBeat.o(79071);
    }
    
    public final void cM(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(79072);
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
        AppMethodBeat.o(79072);
        return;
      }
      if (this.Jam.containsKey(paramString))
      {
        if (paramBoolean)
        {
          long l1 = ((Long)this.Jam.get(paramString)).longValue();
          long l2 = Util.nowMilliSecond();
          this.Jam.put(paramString, Long.valueOf(l2 - l1));
          AppMethodBeat.o(79072);
          return;
        }
        this.Jam.put(paramString, Long.valueOf(-1L));
      }
      AppMethodBeat.o(79072);
    }
    
    public final void report()
    {
      AppMethodBeat.i(211015);
      int i = az.bHy();
      Iterator localIterator = this.Jam.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str1 = (String)((Map.Entry)localObject).getKey();
        long l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        h.CyF.idkeyStat(32L, 2L, 1L, true);
        if (l == -1L)
        {
          h.CyF.idkeyStat(32L, 13L, 1L, true);
          Log.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report fail url : %s, netType : %d", new Object[] { str1, Integer.valueOf(i) });
        }
        if ((l >= 0L) && (l <= 60000L))
        {
          String str2 = this.Jak;
          if (str1 == null) {}
          for (localObject = str1;; localObject = str1.replace(",", "!"))
          {
            az.r(str2, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(i), localObject, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(az.access$000()), Integer.valueOf(az.access$100()), Integer.valueOf(this.ehX), this.Jak });
            Log.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report url : %s, cost time : %d, netType : %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { str1, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(this.ehX), this.Jak });
            h.CyF.idkeyStat(32L, 6L, l, true);
            break;
          }
        }
      }
      AppMethodBeat.o(211015);
    }
  }
  
  public final class k
  {
    public String Jak;
    public HashMap<String, Long> Jan;
    public int ehX;
    
    public k()
    {
      AppMethodBeat.i(79074);
      this.Jan = new HashMap();
      AppMethodBeat.o(79074);
    }
    
    public final void aZh(String paramString)
    {
      AppMethodBeat.i(211016);
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.startLoadUrl failed, url is null");
        AppMethodBeat.o(211016);
        return;
      }
      if (!this.Jan.containsKey(paramString)) {
        this.Jan.put(paramString, Long.valueOf(Util.nowMilliSecond()));
      }
      AppMethodBeat.o(211016);
    }
    
    public final void aZi(String paramString)
    {
      AppMethodBeat.i(211017);
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
        AppMethodBeat.o(211017);
        return;
      }
      if (this.Jan.containsKey(paramString))
      {
        long l1 = ((Long)this.Jan.get(paramString)).longValue();
        long l2 = Util.nowMilliSecond();
        this.Jan.put(paramString, Long.valueOf(l2 - l1));
      }
      AppMethodBeat.o(211017);
    }
    
    public final k cU(int paramInt, String paramString)
    {
      this.ehX = paramInt;
      this.Jak = paramString;
      return this;
    }
  }
  
  public final class l
  {
    public String Jak;
    public long costTime;
    public int ehX;
    public boolean isSuccess = true;
    public String url;
    
    public l() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.az
 * JD-Core Version:    0.7.0.1
 */