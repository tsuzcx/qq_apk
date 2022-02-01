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
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.n.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class ay
{
  private static int DUY = 0;
  private static int DUZ = 0;
  public l DUJ;
  public j DUK;
  public k DUL;
  public aw DUM;
  private ak DUN;
  public f DUO;
  public b DUP;
  public g DUQ;
  public d DUR;
  private e DUS;
  private i DUT;
  private h DUU;
  private c DUV;
  public a DUW;
  private au DUX;
  public int DVa;
  
  public ay()
  {
    AppMethodBeat.i(175743);
    this.DVa = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(175743);
  }
  
  public static void Cq(long paramLong)
  {
    AppMethodBeat.i(79094);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(79094);
      return;
    }
    int i = (int)(System.currentTimeMillis() - paramLong);
    if ((i >= 0) && (i < 20000)) {
      g.yhR.f(16269, new Object[] { Integer.valueOf(i), Integer.valueOf((int)(paramLong / 1000L)) });
    }
    AppMethodBeat.o(79094);
  }
  
  public static void aI(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (DUY = 1; paramBoolean2; DUY = 0)
    {
      DUZ = 1;
      return;
    }
    DUZ = 0;
  }
  
  public static int blr()
  {
    AppMethodBeat.i(79075);
    if (com.tencent.mm.sdk.platformtools.ay.is4G(aj.getContext()))
    {
      AppMethodBeat.o(79075);
      return 5;
    }
    if (com.tencent.mm.sdk.platformtools.ay.is5G(aj.getContext()))
    {
      AppMethodBeat.o(79075);
      return 7;
    }
    switch (com.tencent.mm.sdk.platformtools.ay.getNetType(aj.getContext()))
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
  
  public static String dfE()
  {
    AppMethodBeat.i(79076);
    Object localObject = (ConnectivityManager)aj.getContext().getSystemService("connectivity");
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
  
  private static void t(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(207984);
    ArrayList localArrayList = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(String.valueOf(paramVarArgs[i]));
      i += 1;
    }
    paramVarArgs = g.yhR;
    g.l(11215, localArrayList);
    if ((paramString != null) && (paramString.startsWith("official_mall")))
    {
      paramString = g.yhR;
      g.l(14919, localArrayList);
    }
    AppMethodBeat.o(207984);
  }
  
  public final boolean aB(Bundle paramBundle)
  {
    AppMethodBeat.i(207982);
    if (paramBundle != null)
    {
      if (this.DUW != null) {
        this.DUW.dxT = null;
      }
      this.DUW = new a(paramBundle);
      AppMethodBeat.o(207982);
      return true;
    }
    AppMethodBeat.o(207982);
    return false;
  }
  
  public final void aHE(String paramString)
  {
    AppMethodBeat.i(79092);
    a locala;
    if (this.DUW != null) {
      try
      {
        locala = this.DUW;
        boolean bool = locala.dxT.containsKey(paramString);
        if (!bool) {
          break label68;
        }
        try
        {
          locala.putValue(paramString, Integer.valueOf(locala.dxT.getInt(paramString) + 1));
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
  
  public final e eQA()
  {
    AppMethodBeat.i(79080);
    if (this.DUS == null) {
      this.DUS = new e();
    }
    e locale = this.DUS;
    AppMethodBeat.o(79080);
    return locale;
  }
  
  public final aw eQB()
  {
    AppMethodBeat.i(207979);
    if (this.DUM == null) {
      this.DUM = new aw();
    }
    aw localaw = this.DUM;
    AppMethodBeat.o(207979);
    return localaw;
  }
  
  public final ak eQC()
  {
    AppMethodBeat.i(207980);
    if (this.DUN == null) {
      this.DUN = new ak();
    }
    ak localak = this.DUN;
    AppMethodBeat.o(207980);
    return localak;
  }
  
  public final f eQD()
  {
    AppMethodBeat.i(79083);
    if (this.DUO == null) {
      this.DUO = new f();
    }
    f localf = this.DUO;
    AppMethodBeat.o(79083);
    return localf;
  }
  
  public final b eQE()
  {
    AppMethodBeat.i(79084);
    if (this.DUP == null) {
      this.DUP = new b();
    }
    b localb = this.DUP;
    AppMethodBeat.o(79084);
    return localb;
  }
  
  public final g eQF()
  {
    AppMethodBeat.i(79085);
    if (this.DUQ == null) {
      this.DUQ = new g();
    }
    g localg = this.DUQ;
    AppMethodBeat.o(79085);
    return localg;
  }
  
  public final d eQG()
  {
    AppMethodBeat.i(79086);
    if (this.DUR == null) {
      this.DUR = new d();
    }
    d locald = this.DUR;
    AppMethodBeat.o(79086);
    return locald;
  }
  
  public final i eQH()
  {
    AppMethodBeat.i(79087);
    if (this.DUT == null) {
      this.DUT = new i();
    }
    i locali = this.DUT;
    AppMethodBeat.o(79087);
    return locali;
  }
  
  public final h eQI()
  {
    AppMethodBeat.i(79088);
    if (this.DUU == null) {
      this.DUU = new h();
    }
    h localh = this.DUU;
    AppMethodBeat.o(79088);
    return localh;
  }
  
  public final c eQJ()
  {
    AppMethodBeat.i(79089);
    if (this.DUV == null) {
      this.DUV = new c();
    }
    c localc = this.DUV;
    AppMethodBeat.o(79089);
    return localc;
  }
  
  public final au eQK()
  {
    AppMethodBeat.i(207981);
    if (this.DUX == null) {
      this.DUX = new au();
    }
    au localau = this.DUX;
    AppMethodBeat.o(207981);
    return localau;
  }
  
  public final l eQx()
  {
    AppMethodBeat.i(79077);
    if (this.DUJ == null) {
      this.DUJ = new l();
    }
    l locall = this.DUJ;
    AppMethodBeat.o(79077);
    return locall;
  }
  
  public final j eQy()
  {
    AppMethodBeat.i(79078);
    if (this.DUK == null) {
      this.DUK = new j();
    }
    j localj = this.DUK;
    AppMethodBeat.o(79078);
    return localj;
  }
  
  public final k eQz()
  {
    AppMethodBeat.i(79079);
    if (this.DUL == null) {
      this.DUL = new k();
    }
    k localk = this.DUL;
    AppMethodBeat.o(79079);
    return localk;
  }
  
  public final void report()
  {
    AppMethodBeat.i(207983);
    k localk = eQz();
    int i = blr();
    Iterator localIterator = localk.DVl.entrySet().iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      localObject2 = (String)((Map.Entry)localObject1).getKey();
      long l = ((Long)((Map.Entry)localObject1).getValue()).longValue();
      g.yhR.idkeyStat(32L, 0L, 1L, true);
      if ((l >= 0L) && (l <= 180000L))
      {
        String str = localk.DVi;
        if (localObject2 == null) {}
        for (localObject1 = localObject2;; localObject1 = ((String)localObject2).replace(",", "!"))
        {
          t(str, new Object[] { Integer.valueOf(3), Long.valueOf(l), Integer.valueOf(i), localObject1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(DUY), Integer.valueOf(DUZ), Integer.valueOf(localk.dOE), localk.DVi });
          g.yhR.idkeyStat(160L, 0L, 1L, false);
          if (-1 != com.tencent.mm.plugin.webview.h.a.Cr(l)) {
            g.yhR.idkeyStat(160L, com.tencent.mm.plugin.webview.h.a.Cr(l), 1L, false);
          }
          g.yhR.idkeyStat(32L, 3L, 1L, true);
          g.yhR.idkeyStat(32L, 7L, l, true);
          if (DUZ == 1)
          {
            g.yhR.idkeyStat(32L, 16L, 1L, true);
            g.yhR.idkeyStat(32L, 17L, l, true);
          }
          ad.i("MicroMsg.WebviewReporter", "WebviewOpenUrlReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { localObject2, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(DUY), Integer.valueOf(DUZ), Integer.valueOf(localk.dOE), localk.DVi });
          break;
        }
      }
    }
    Object localObject1 = eQB();
    if (!bt.isNullOrNil(((aw)localObject1).DUz)) {
      ad.d("MicroMsg.WebviewReporter", "WebViewVisitReporter report viewID = %s", new Object[] { ((aw)localObject1).DUz });
    }
    try
    {
      h.a("com.tencent.mm", (Parcelable)IPCVoid.gyi, aw.a.DUH.getClass(), (d)new aw.b((aw)localObject1));
      localObject1 = eQC();
      if (!bt.isNullOrNil(((ak)localObject1).hDf))
      {
        localObject2 = ((ak)localObject1).hDf;
        if (localObject2 == null) {
          p.gfZ();
        }
        if (n.nz((String)localObject2, "wrd")) {}
      }
      else
      {
        eQy().report();
        eQA().report();
        localObject1 = eQE();
        i = blr();
        if (!((b)localObject1).DVc) {
          break label928;
        }
        if (!((b)localObject1).loadFinished) {
          break label879;
        }
        g.yhR.f(11575, new Object[] { ((b)localObject1).dKk, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i) });
        AppMethodBeat.o(207983);
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
        ((StringBuffer)localObject2).append(localRemoteException.hDf);
        ((StringBuffer)localObject2).append("&staytime=");
        ((StringBuffer)localObject2).append(localRemoteException.dBD);
        ((StringBuffer)localObject2).append("&allstaytime=");
        ((StringBuffer)localObject2).append(System.currentTimeMillis() - localRemoteException.enterTime);
        ((StringBuffer)localObject2).append("&maxscrolly=");
        ((StringBuffer)localObject2).append(localRemoteException.DUd);
        ((StringBuffer)localObject2).append("&totalscrolly=");
        ((StringBuffer)localObject2).append(localRemoteException.Aod);
        ((StringBuffer)localObject2).append("&scene=");
        ((StringBuffer)localObject2).append(localRemoteException.scene);
        ((StringBuffer)localObject2).append("&entertime=");
        ((StringBuffer)localObject2).append(localRemoteException.enterTime);
        ((StringBuffer)localObject2).append("&screenheight=");
        ((StringBuffer)localObject2).append(com.tencent.mm.cc.a.iq(aj.getContext()));
        Bundle localBundle = new Bundle();
        localBundle.putString("reportString", ((StringBuffer)localObject2).toString());
        try
        {
          h.a("com.tencent.mm", (Parcelable)localBundle, ak.a.DUe.getClass(), null);
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.WebviewReporter", (Throwable)localException, "TopStory report", new Object[0]);
        }
      }
      label879:
      g.yhR.f(11575, new Object[] { localException.dKk, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(207983);
      return;
    }
    label928:
    g.yhR.f(11575, new Object[] { localException.dKk, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(i) });
    AppMethodBeat.o(207983);
  }
  
  public final void w(String paramString, Object paramObject)
  {
    AppMethodBeat.i(79091);
    if (this.DUW != null) {
      try
      {
        this.DUW.putValue(paramString, paramObject);
        AppMethodBeat.o(79091);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(79091);
  }
  
  public final class a
  {
    public Bundle dxT = null;
    
    a(Bundle paramBundle)
    {
      this.dxT = paramBundle;
    }
    
    public final void putValue(String paramString, Object paramObject)
    {
      AppMethodBeat.i(79061);
      if (this.dxT != null)
      {
        if ((paramObject instanceof String))
        {
          this.dxT.putString(paramString, (String)paramObject);
          AppMethodBeat.o(79061);
          return;
        }
        if ((paramObject instanceof Boolean))
        {
          this.dxT.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
          AppMethodBeat.o(79061);
          return;
        }
        if ((paramObject instanceof Integer))
        {
          this.dxT.putInt(paramString, ((Integer)paramObject).intValue());
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
    public boolean DVc = false;
    String dKk;
    public boolean loadFinished = false;
    
    public final b aHF(String paramString)
    {
      this.dKk = paramString;
      return this;
    }
  }
  
  public static final class c
  {
    private boolean DVd = false;
    public boolean rzM = false;
    
    public final void cE(String paramString)
    {
      AppMethodBeat.i(207964);
      if ((!this.rzM) || (this.DVd))
      {
        AppMethodBeat.o(207964);
        return;
      }
      try
      {
        Object localObject = Uri.parse(paramString);
        if (!paramString.startsWith("http"))
        {
          ad.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, url not startswith http");
          AppMethodBeat.o(207964);
          return;
        }
        localObject = ((Uri)localObject).getHost();
        if ((localObject != null) && (((String)localObject).equalsIgnoreCase("v.html5.qq.com")))
        {
          g.yhR.idkeyStat(283L, 0L, 1L, true);
          this.DVd = true;
          ad.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, domain visit reported, url = %s", new Object[] { paramString });
        }
        AppMethodBeat.o(207964);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, parse url fail, url = %s", new Object[] { paramString });
        AppMethodBeat.o(207964);
      }
    }
  }
  
  public static final class d
  {
    private ArrayList<String> DVe;
    
    public d()
    {
      AppMethodBeat.i(207965);
      this.DVe = new ArrayList();
      AppMethodBeat.o(207965);
    }
    
    public final d C(Object... paramVarArgs)
    {
      AppMethodBeat.i(207966);
      int j = paramVarArgs.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramVarArgs[i];
        ArrayList localArrayList = this.DVe;
        if (localObject == null) {}
        for (localObject = "";; localObject = localObject.toString())
        {
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(207966);
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(207967);
      g localg = g.yhR;
      g.l(11577, this.DVe);
      AppMethodBeat.o(207967);
    }
  }
  
  public final class e
  {
    private ConcurrentHashMap<String, Long> DVf;
    private ConcurrentHashMap<String, Long> DVg;
    private boolean DVh;
    private String DVi;
    private int dOE;
    private String mue;
    
    public e()
    {
      AppMethodBeat.i(79063);
      this.mue = "";
      this.DVh = true;
      this.DVf = new ConcurrentHashMap();
      this.DVg = new ConcurrentHashMap();
      AppMethodBeat.o(79063);
    }
    
    public final void aHG(String paramString)
    {
      AppMethodBeat.i(207968);
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageStart failed, url is null");
        AppMethodBeat.o(207968);
        return;
      }
      this.mue = paramString;
      this.DVh = true;
      if (!this.DVf.containsKey(paramString)) {
        this.DVf.put(paramString, Long.valueOf(bt.flT()));
      }
      if (!this.DVg.containsKey(paramString)) {
        this.DVg.put(paramString, Long.valueOf(bt.flT()));
      }
      AppMethodBeat.o(207968);
    }
    
    public final void aHH(String paramString)
    {
      AppMethodBeat.i(207969);
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onLoadResource failed, url is null");
        AppMethodBeat.o(207969);
        return;
      }
      try
      {
        if ((!bt.isNullOrNil(this.mue)) && (!paramString.equals(this.mue)) && (this.DVh))
        {
          if (this.DVf.containsKey(this.mue))
          {
            long l1 = ((Long)this.DVf.get(this.mue)).longValue();
            long l2 = bt.flT();
            this.DVf.put(this.mue, Long.valueOf(l2 - l1));
          }
          this.DVh = false;
        }
        AppMethodBeat.o(207969);
        return;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.WebviewReporter", paramString, "onLoadResource", new Object[0]);
        AppMethodBeat.o(207969);
      }
    }
    
    public final void aHI(String paramString)
    {
      AppMethodBeat.i(207970);
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageFinish failed, url is null");
        AppMethodBeat.o(207970);
        return;
      }
      try
      {
        if (this.DVg.containsKey(paramString))
        {
          long l1 = ((Long)this.DVg.get(paramString)).longValue();
          long l2 = bt.flT();
          this.DVg.put(paramString, Long.valueOf(l2 - l1));
        }
        AppMethodBeat.o(207970);
        return;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.WebviewReporter", paramString, "onPageFinish", new Object[0]);
        AppMethodBeat.o(207970);
      }
    }
    
    public final e cA(int paramInt, String paramString)
    {
      this.dOE = paramInt;
      this.DVi = paramString;
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(207971);
      int i = ay.blr();
      Iterator localIterator = this.DVf.entrySet().iterator();
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
          AppMethodBeat.o(207971);
          return;
        }
        localObject = this.DVi;
        if (str == null) {}
        for (;;)
        {
          ay.u((String)localObject, new Object[] { Integer.valueOf(5), Long.valueOf(l), Integer.valueOf(i), str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ay.DUY), Integer.valueOf(ay.DUZ), Integer.valueOf(this.dOE), this.DVi });
          if (ay.DUY == 1)
          {
            g.yhR.idkeyStat(32L, 18L, 1L, true);
            g.yhR.idkeyStat(32L, 19L, l, true);
          }
          g.yhR.idkeyStat(32L, 8L, 1L, true);
          g.yhR.idkeyStat(32L, 9L, l, true);
          ad.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report DomReady cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(ay.DUY), Integer.valueOf(ay.DUZ), Integer.valueOf(this.dOE), this.DVi });
          break;
          str = str.replace(",", "!");
        }
      }
      localIterator = this.DVg.entrySet().iterator();
      if (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        str = (String)((Map.Entry)localObject).getKey();
        l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        if ((l < 0L) || (l > 180000L))
        {
          AppMethodBeat.o(207971);
          return;
        }
        localObject = this.DVi;
        if (str == null) {}
        for (;;)
        {
          ay.u((String)localObject, new Object[] { Integer.valueOf(6), Long.valueOf(l), Integer.valueOf(i), str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ay.DUY), Integer.valueOf(ay.DUZ), Integer.valueOf(this.dOE), this.DVi });
          if (ay.DUY == 1)
          {
            g.yhR.idkeyStat(32L, 20L, 1L, true);
            g.yhR.idkeyStat(32L, 21L, l, true);
          }
          g.yhR.idkeyStat(32L, 10L, 1L, true);
          g.yhR.idkeyStat(32L, 11L, l, true);
          ad.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report Render cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(ay.DUY), Integer.valueOf(ay.DUZ), Integer.valueOf(this.dOE), this.DVi });
          break;
          str = str.replace(",", "!");
        }
      }
      AppMethodBeat.o(207971);
    }
  }
  
  public final class f
  {
    public String DVi;
    private boolean clz;
    public int dOE;
    private long startTime;
    public String url;
    
    public f()
    {
      AppMethodBeat.i(79068);
      this.clz = false;
      this.startTime = bt.flT();
      AppMethodBeat.o(79068);
    }
    
    public final void report()
    {
      AppMethodBeat.i(207972);
      int i;
      long l;
      String str2;
      if (!this.clz)
      {
        this.clz = true;
        i = ay.blr();
        l = bt.flT() - this.startTime;
        if ((l < 0L) || (l > 180000L))
        {
          AppMethodBeat.o(207972);
          return;
        }
        str2 = this.DVi;
        if (this.url != null) {
          break label241;
        }
      }
      label241:
      for (String str1 = this.url;; str1 = this.url.replace(",", "!"))
      {
        ay.u(str2, new Object[] { Integer.valueOf(4), Long.valueOf(l), Integer.valueOf(i), str1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ay.DUY), Integer.valueOf(ay.DUZ), Integer.valueOf(this.dOE), this.DVi });
        ad.i("MicroMsg.WebviewReporter", "WebViewTotalTimeReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { this.url, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(ay.DUY), Integer.valueOf(ay.DUZ), Integer.valueOf(this.dOE), this.DVi });
        AppMethodBeat.o(207972);
        return;
      }
    }
  }
  
  public static final class g
  {
    private ArrayList<String> DVe;
    
    public g()
    {
      AppMethodBeat.i(207973);
      this.DVe = new ArrayList();
      AppMethodBeat.o(207973);
    }
    
    public final g D(Object... paramVarArgs)
    {
      AppMethodBeat.i(207974);
      int i = 0;
      if (i < 2)
      {
        Object localObject = paramVarArgs[i];
        ArrayList localArrayList = this.DVe;
        if (localObject != null) {}
        for (localObject = localObject.toString();; localObject = "")
        {
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(207974);
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(207975);
      g localg = g.yhR;
      g.l(11576, this.DVe);
      AppMethodBeat.o(207975);
    }
  }
  
  public static final class h
  {
    public List<String> DVj;
  }
  
  public static final class i
  {
    public List<String> DVj;
  }
  
  public final class j
  {
    private String DVi;
    private HashMap<String, Long> DVk;
    private int dOE;
    
    public j()
    {
      AppMethodBeat.i(79071);
      this.DVk = new HashMap();
      AppMethodBeat.o(79071);
    }
    
    public final void co(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(79072);
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
        AppMethodBeat.o(79072);
        return;
      }
      if (this.DVk.containsKey(paramString))
      {
        if (paramBoolean)
        {
          long l1 = ((Long)this.DVk.get(paramString)).longValue();
          long l2 = bt.flT();
          this.DVk.put(paramString, Long.valueOf(l2 - l1));
          AppMethodBeat.o(79072);
          return;
        }
        this.DVk.put(paramString, Long.valueOf(-1L));
      }
      AppMethodBeat.o(79072);
    }
    
    public final void report()
    {
      AppMethodBeat.i(207976);
      int i = ay.blr();
      Iterator localIterator = this.DVk.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str1 = (String)((Map.Entry)localObject).getKey();
        long l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        g.yhR.idkeyStat(32L, 2L, 1L, true);
        if (l == -1L)
        {
          g.yhR.idkeyStat(32L, 13L, 1L, true);
          ad.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report fail url : %s, netType : %d", new Object[] { str1, Integer.valueOf(i) });
        }
        if ((l >= 0L) && (l <= 60000L))
        {
          String str2 = this.DVi;
          if (str1 == null) {}
          for (localObject = str1;; localObject = str1.replace(",", "!"))
          {
            ay.u(str2, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(i), localObject, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ay.DUY), Integer.valueOf(ay.DUZ), Integer.valueOf(this.dOE), this.DVi });
            ad.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report url : %s, cost time : %d, netType : %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { str1, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(this.dOE), this.DVi });
            g.yhR.idkeyStat(32L, 6L, l, true);
            break;
          }
        }
      }
      AppMethodBeat.o(207976);
    }
  }
  
  public final class k
  {
    String DVi;
    HashMap<String, Long> DVl;
    int dOE;
    
    public k()
    {
      AppMethodBeat.i(79074);
      this.DVl = new HashMap();
      AppMethodBeat.o(79074);
    }
    
    public final void aHJ(String paramString)
    {
      AppMethodBeat.i(207977);
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.startLoadUrl failed, url is null");
        AppMethodBeat.o(207977);
        return;
      }
      if (!this.DVl.containsKey(paramString)) {
        this.DVl.put(paramString, Long.valueOf(bt.flT()));
      }
      AppMethodBeat.o(207977);
    }
    
    public final void aHK(String paramString)
    {
      AppMethodBeat.i(207978);
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
        AppMethodBeat.o(207978);
        return;
      }
      if (this.DVl.containsKey(paramString))
      {
        long l1 = ((Long)this.DVl.get(paramString)).longValue();
        long l2 = bt.flT();
        this.DVl.put(paramString, Long.valueOf(l2 - l1));
      }
      AppMethodBeat.o(207978);
    }
    
    public final k cB(int paramInt, String paramString)
    {
      this.dOE = paramInt;
      this.DVi = paramString;
      return this;
    }
  }
  
  public final class l
  {
    public String DVi;
    public int dOE;
    public boolean dpX = true;
    public long msQ;
    public String url;
    
    public l() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ay
 * JD-Core Version:    0.7.0.1
 */