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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static int Cru = 0;
  private static int Crv = 0;
  public l Crf;
  public j Crg;
  public k Crh;
  public av Cri;
  private aj Crj;
  public f Crk;
  public b Crl;
  public g Crm;
  public d Crn;
  private e Cro;
  private i Crp;
  private h Crq;
  private c Crr;
  public a Crs;
  private at Crt;
  public int Crw;
  
  public ax()
  {
    AppMethodBeat.i(175743);
    this.Crw = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(175743);
  }
  
  public static void aB(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (Cru = 1; paramBoolean2; Cru = 0)
    {
      Crv = 1;
      return;
    }
    Crv = 0;
  }
  
  public static int bhK()
  {
    AppMethodBeat.i(79075);
    if (com.tencent.mm.sdk.platformtools.ax.is4G(ai.getContext()))
    {
      AppMethodBeat.o(79075);
      return 5;
    }
    switch (com.tencent.mm.sdk.platformtools.ax.getNetType(ai.getContext()))
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
  
  public static String cWt()
  {
    AppMethodBeat.i(79076);
    Object localObject = (ConnectivityManager)ai.getContext().getSystemService("connectivity");
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
    ac.d("MicroMsg.WebviewReporter", "activeNetInfo extra=%s, type=%d, %s", new Object[] { ((NetworkInfo)localObject).getExtraInfo(), Integer.valueOf(((NetworkInfo)localObject).getType()), ((NetworkInfo)localObject).getExtraInfo() });
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
    AppMethodBeat.i(188361);
    ArrayList localArrayList = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(String.valueOf(paramVarArgs[i]));
      i += 1;
    }
    paramVarArgs = com.tencent.mm.plugin.report.service.h.wUl;
    com.tencent.mm.plugin.report.service.h.k(11215, localArrayList);
    if ((paramString != null) && (paramString.startsWith("official_mall")))
    {
      paramString = com.tencent.mm.plugin.report.service.h.wUl;
      com.tencent.mm.plugin.report.service.h.k(14919, localArrayList);
    }
    AppMethodBeat.o(188361);
  }
  
  public static void zC(long paramLong)
  {
    AppMethodBeat.i(79094);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(79094);
      return;
    }
    int i = (int)(System.currentTimeMillis() - paramLong);
    if ((i >= 0) && (i < 20000)) {
      com.tencent.mm.plugin.report.service.h.wUl.f(16269, new Object[] { Integer.valueOf(i), Integer.valueOf((int)(paramLong / 1000L)) });
    }
    AppMethodBeat.o(79094);
  }
  
  public final void aCe(String paramString)
  {
    AppMethodBeat.i(79092);
    a locala;
    if (this.Crs != null) {
      try
      {
        locala = this.Crs;
        boolean bool = locala.dmf.containsKey(paramString);
        if (!bool) {
          break label68;
        }
        try
        {
          locala.putValue(paramString, Integer.valueOf(locala.dmf.getInt(paramString) + 1));
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
  
  public final boolean au(Bundle paramBundle)
  {
    AppMethodBeat.i(188359);
    if (paramBundle != null)
    {
      if (this.Crs != null) {
        this.Crs.dmf = null;
      }
      this.Crs = new a(paramBundle);
      AppMethodBeat.o(188359);
      return true;
    }
    AppMethodBeat.o(188359);
    return false;
  }
  
  public final l eBD()
  {
    AppMethodBeat.i(79077);
    if (this.Crf == null) {
      this.Crf = new l();
    }
    l locall = this.Crf;
    AppMethodBeat.o(79077);
    return locall;
  }
  
  public final j eBE()
  {
    AppMethodBeat.i(79078);
    if (this.Crg == null) {
      this.Crg = new j();
    }
    j localj = this.Crg;
    AppMethodBeat.o(79078);
    return localj;
  }
  
  public final k eBF()
  {
    AppMethodBeat.i(79079);
    if (this.Crh == null) {
      this.Crh = new k();
    }
    k localk = this.Crh;
    AppMethodBeat.o(79079);
    return localk;
  }
  
  public final e eBG()
  {
    AppMethodBeat.i(79080);
    if (this.Cro == null) {
      this.Cro = new e();
    }
    e locale = this.Cro;
    AppMethodBeat.o(79080);
    return locale;
  }
  
  public final av eBH()
  {
    AppMethodBeat.i(188356);
    if (this.Cri == null) {
      this.Cri = new av();
    }
    av localav = this.Cri;
    AppMethodBeat.o(188356);
    return localav;
  }
  
  public final aj eBI()
  {
    AppMethodBeat.i(188357);
    if (this.Crj == null) {
      this.Crj = new aj();
    }
    aj localaj = this.Crj;
    AppMethodBeat.o(188357);
    return localaj;
  }
  
  public final f eBJ()
  {
    AppMethodBeat.i(79083);
    if (this.Crk == null) {
      this.Crk = new f();
    }
    f localf = this.Crk;
    AppMethodBeat.o(79083);
    return localf;
  }
  
  public final b eBK()
  {
    AppMethodBeat.i(79084);
    if (this.Crl == null) {
      this.Crl = new b();
    }
    b localb = this.Crl;
    AppMethodBeat.o(79084);
    return localb;
  }
  
  public final g eBL()
  {
    AppMethodBeat.i(79085);
    if (this.Crm == null) {
      this.Crm = new g();
    }
    g localg = this.Crm;
    AppMethodBeat.o(79085);
    return localg;
  }
  
  public final d eBM()
  {
    AppMethodBeat.i(79086);
    if (this.Crn == null) {
      this.Crn = new d();
    }
    d locald = this.Crn;
    AppMethodBeat.o(79086);
    return locald;
  }
  
  public final i eBN()
  {
    AppMethodBeat.i(79087);
    if (this.Crp == null) {
      this.Crp = new i();
    }
    i locali = this.Crp;
    AppMethodBeat.o(79087);
    return locali;
  }
  
  public final h eBO()
  {
    AppMethodBeat.i(79088);
    if (this.Crq == null) {
      this.Crq = new h();
    }
    h localh = this.Crq;
    AppMethodBeat.o(79088);
    return localh;
  }
  
  public final c eBP()
  {
    AppMethodBeat.i(79089);
    if (this.Crr == null) {
      this.Crr = new c();
    }
    c localc = this.Crr;
    AppMethodBeat.o(79089);
    return localc;
  }
  
  public final at eBQ()
  {
    AppMethodBeat.i(188358);
    if (this.Crt == null) {
      this.Crt = new at();
    }
    at localat = this.Crt;
    AppMethodBeat.o(188358);
    return localat;
  }
  
  public final void report()
  {
    AppMethodBeat.i(188360);
    k localk = eBF();
    int i = bhK();
    Iterator localIterator = localk.CrH.entrySet().iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      localObject2 = (String)((Map.Entry)localObject1).getKey();
      long l = ((Long)((Map.Entry)localObject1).getValue()).longValue();
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(32L, 0L, 1L, true);
      if ((l >= 0L) && (l <= 180000L))
      {
        String str = localk.CrE;
        if (localObject2 == null) {}
        for (localObject1 = localObject2;; localObject1 = ((String)localObject2).replace(",", "!"))
        {
          s(str, new Object[] { Integer.valueOf(3), Long.valueOf(l), Integer.valueOf(i), localObject1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(Cru), Integer.valueOf(Crv), Integer.valueOf(localk.dCr), localk.CrE });
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(160L, 0L, 1L, false);
          if (-1 != com.tencent.mm.plugin.webview.h.a.zD(l)) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(160L, com.tencent.mm.plugin.webview.h.a.zD(l), 1L, false);
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(32L, 3L, 1L, true);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(32L, 7L, l, true);
          if (Crv == 1)
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(32L, 16L, 1L, true);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(32L, 17L, l, true);
          }
          ac.i("MicroMsg.WebviewReporter", "WebviewOpenUrlReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { localObject2, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(Cru), Integer.valueOf(Crv), Integer.valueOf(localk.dCr), localk.CrE });
          break;
        }
      }
    }
    Object localObject1 = eBH();
    if (!bs.isNullOrNil(((av)localObject1).CqV)) {
      ac.d("MicroMsg.WebviewReporter", "WebViewVisitReporter report viewID = %s", new Object[] { ((av)localObject1).CqV });
    }
    try
    {
      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)IPCVoid.gey, av.a.Crd.getClass(), (d)new av.b((av)localObject1));
      localObject1 = eBI();
      if (!bs.isNullOrNil(((aj)localObject1).hkW))
      {
        localObject2 = ((aj)localObject1).hkW;
        if (localObject2 == null) {
          k.fOy();
        }
        if (n.nb((String)localObject2, "wrd")) {}
      }
      else
      {
        eBE().report();
        eBG().report();
        localObject1 = eBK();
        i = bhK();
        if (!((b)localObject1).Cry) {
          break label928;
        }
        if (!((b)localObject1).loadFinished) {
          break label879;
        }
        com.tencent.mm.plugin.report.service.h.wUl.f(11575, new Object[] { ((b)localObject1).dxX, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i) });
        AppMethodBeat.o(188360);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ac.w("MicroMsg.WebviewReporter", "invokeAsResult error, %s", new Object[] { localRemoteException });
        continue;
        localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("iswebviewreadtime=1");
        ((StringBuffer)localObject2).append("&publishid=");
        ((StringBuffer)localObject2).append(localRemoteException.hkW);
        ((StringBuffer)localObject2).append("&staytime=");
        ((StringBuffer)localObject2).append(localRemoteException.dpQ);
        ((StringBuffer)localObject2).append("&allstaytime=");
        ((StringBuffer)localObject2).append(System.currentTimeMillis() - localRemoteException.enterTime);
        ((StringBuffer)localObject2).append("&maxscrolly=");
        ((StringBuffer)localObject2).append(localRemoteException.CqA);
        ((StringBuffer)localObject2).append("&totalscrolly=");
        ((StringBuffer)localObject2).append(localRemoteException.yWt);
        ((StringBuffer)localObject2).append("&scene=");
        ((StringBuffer)localObject2).append(localRemoteException.scene);
        ((StringBuffer)localObject2).append("&entertime=");
        ((StringBuffer)localObject2).append(localRemoteException.enterTime);
        ((StringBuffer)localObject2).append("&screenheight=");
        ((StringBuffer)localObject2).append(com.tencent.mm.cc.a.ih(ai.getContext()));
        Bundle localBundle = new Bundle();
        localBundle.putString("reportString", ((StringBuffer)localObject2).toString());
        try
        {
          com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localBundle, aj.a.CqB.getClass(), null);
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.WebviewReporter", (Throwable)localException, "TopStory report", new Object[0]);
        }
      }
      label879:
      com.tencent.mm.plugin.report.service.h.wUl.f(11575, new Object[] { localException.dxX, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(188360);
      return;
    }
    label928:
    com.tencent.mm.plugin.report.service.h.wUl.f(11575, new Object[] { localException.dxX, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(i) });
    AppMethodBeat.o(188360);
  }
  
  public final void y(String paramString, Object paramObject)
  {
    AppMethodBeat.i(79091);
    if (this.Crs != null) {
      try
      {
        this.Crs.putValue(paramString, paramObject);
        AppMethodBeat.o(79091);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(79091);
  }
  
  public final class a
  {
    public Bundle dmf = null;
    
    a(Bundle paramBundle)
    {
      this.dmf = paramBundle;
    }
    
    public final void putValue(String paramString, Object paramObject)
    {
      AppMethodBeat.i(79061);
      if (this.dmf != null)
      {
        if ((paramObject instanceof String))
        {
          this.dmf.putString(paramString, (String)paramObject);
          AppMethodBeat.o(79061);
          return;
        }
        if ((paramObject instanceof Boolean))
        {
          this.dmf.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
          AppMethodBeat.o(79061);
          return;
        }
        if ((paramObject instanceof Integer))
        {
          this.dmf.putInt(paramString, ((Integer)paramObject).intValue());
          AppMethodBeat.o(79061);
          return;
        }
        ac.w("MicroMsg.WebviewReporter", "put unknow type value.");
      }
      AppMethodBeat.o(79061);
    }
  }
  
  public static final class b
  {
    public boolean Cry = false;
    String dxX;
    public boolean loadFinished = false;
    
    public final b aCf(String paramString)
    {
      this.dxX = paramString;
      return this;
    }
  }
  
  public static final class c
  {
    private boolean Crz = false;
    public boolean qPN = false;
    
    public final void bL(String paramString)
    {
      AppMethodBeat.i(188341);
      if ((!this.qPN) || (this.Crz))
      {
        AppMethodBeat.o(188341);
        return;
      }
      try
      {
        Object localObject = Uri.parse(paramString);
        if (!paramString.startsWith("http"))
        {
          ac.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, url not startswith http");
          AppMethodBeat.o(188341);
          return;
        }
        localObject = ((Uri)localObject).getHost();
        if ((localObject != null) && (((String)localObject).equalsIgnoreCase("v.html5.qq.com")))
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(283L, 0L, 1L, true);
          this.Crz = true;
          ac.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, domain visit reported, url = %s", new Object[] { paramString });
        }
        AppMethodBeat.o(188341);
        return;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, parse url fail, url = %s", new Object[] { paramString });
        AppMethodBeat.o(188341);
      }
    }
  }
  
  public static final class d
  {
    private ArrayList<String> CrA;
    
    public d()
    {
      AppMethodBeat.i(188342);
      this.CrA = new ArrayList();
      AppMethodBeat.o(188342);
    }
    
    public final d B(Object... paramVarArgs)
    {
      AppMethodBeat.i(188343);
      int j = paramVarArgs.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramVarArgs[i];
        ArrayList localArrayList = this.CrA;
        if (localObject == null) {}
        for (localObject = "";; localObject = localObject.toString())
        {
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(188343);
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(188344);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
      com.tencent.mm.plugin.report.service.h.k(11577, this.CrA);
      AppMethodBeat.o(188344);
    }
  }
  
  public final class e
  {
    private ConcurrentHashMap<String, Long> CrB;
    private ConcurrentHashMap<String, Long> CrC;
    private boolean CrD;
    private String CrE;
    private int dCr;
    private String lUn;
    
    public e()
    {
      AppMethodBeat.i(79063);
      this.lUn = "";
      this.CrD = true;
      this.CrB = new ConcurrentHashMap();
      this.CrC = new ConcurrentHashMap();
      AppMethodBeat.o(79063);
    }
    
    public final void aCg(String paramString)
    {
      AppMethodBeat.i(188345);
      if (bs.isNullOrNil(paramString))
      {
        ac.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageStart failed, url is null");
        AppMethodBeat.o(188345);
        return;
      }
      this.lUn = paramString;
      this.CrD = true;
      if (!this.CrB.containsKey(paramString)) {
        this.CrB.put(paramString, Long.valueOf(bs.eWj()));
      }
      if (!this.CrC.containsKey(paramString)) {
        this.CrC.put(paramString, Long.valueOf(bs.eWj()));
      }
      AppMethodBeat.o(188345);
    }
    
    public final void aCh(String paramString)
    {
      AppMethodBeat.i(188346);
      if (bs.isNullOrNil(paramString))
      {
        ac.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onLoadResource failed, url is null");
        AppMethodBeat.o(188346);
        return;
      }
      try
      {
        if ((!bs.isNullOrNil(this.lUn)) && (!paramString.equals(this.lUn)) && (this.CrD))
        {
          if (this.CrB.containsKey(this.lUn))
          {
            long l1 = ((Long)this.CrB.get(this.lUn)).longValue();
            long l2 = bs.eWj();
            this.CrB.put(this.lUn, Long.valueOf(l2 - l1));
          }
          this.CrD = false;
        }
        AppMethodBeat.o(188346);
        return;
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.WebviewReporter", paramString, "onLoadResource", new Object[0]);
        AppMethodBeat.o(188346);
      }
    }
    
    public final void aCi(String paramString)
    {
      AppMethodBeat.i(188347);
      if (bs.isNullOrNil(paramString))
      {
        ac.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageFinish failed, url is null");
        AppMethodBeat.o(188347);
        return;
      }
      try
      {
        if (this.CrC.containsKey(paramString))
        {
          long l1 = ((Long)this.CrC.get(paramString)).longValue();
          long l2 = bs.eWj();
          this.CrC.put(paramString, Long.valueOf(l2 - l1));
        }
        AppMethodBeat.o(188347);
        return;
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.WebviewReporter", paramString, "onPageFinish", new Object[0]);
        AppMethodBeat.o(188347);
      }
    }
    
    public final e cu(int paramInt, String paramString)
    {
      this.dCr = paramInt;
      this.CrE = paramString;
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(188348);
      int i = ax.bhK();
      Iterator localIterator = this.CrB.entrySet().iterator();
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
          AppMethodBeat.o(188348);
          return;
        }
        localObject = this.CrE;
        if (str == null) {}
        for (;;)
        {
          ax.t((String)localObject, new Object[] { Integer.valueOf(5), Long.valueOf(l), Integer.valueOf(i), str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ax.Cru), Integer.valueOf(ax.Crv), Integer.valueOf(this.dCr), this.CrE });
          if (ax.Cru == 1)
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(32L, 18L, 1L, true);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(32L, 19L, l, true);
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(32L, 8L, 1L, true);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(32L, 9L, l, true);
          ac.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report DomReady cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(ax.Cru), Integer.valueOf(ax.Crv), Integer.valueOf(this.dCr), this.CrE });
          break;
          str = str.replace(",", "!");
        }
      }
      localIterator = this.CrC.entrySet().iterator();
      if (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        str = (String)((Map.Entry)localObject).getKey();
        l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        if ((l < 0L) || (l > 180000L))
        {
          AppMethodBeat.o(188348);
          return;
        }
        localObject = this.CrE;
        if (str == null) {}
        for (;;)
        {
          ax.t((String)localObject, new Object[] { Integer.valueOf(6), Long.valueOf(l), Integer.valueOf(i), str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ax.Cru), Integer.valueOf(ax.Crv), Integer.valueOf(this.dCr), this.CrE });
          if (ax.Cru == 1)
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(32L, 20L, 1L, true);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(32L, 21L, l, true);
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(32L, 10L, 1L, true);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(32L, 11L, l, true);
          ac.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report Render cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(ax.Cru), Integer.valueOf(ax.Crv), Integer.valueOf(this.dCr), this.CrE });
          break;
          str = str.replace(",", "!");
        }
      }
      AppMethodBeat.o(188348);
    }
  }
  
  public final class f
  {
    public String CrE;
    private boolean cbi;
    public int dCr;
    private long startTime;
    public String url;
    
    public f()
    {
      AppMethodBeat.i(79068);
      this.cbi = false;
      this.startTime = bs.eWj();
      AppMethodBeat.o(79068);
    }
    
    public final void report()
    {
      AppMethodBeat.i(188349);
      int i;
      long l;
      String str2;
      if (!this.cbi)
      {
        this.cbi = true;
        i = ax.bhK();
        l = bs.eWj() - this.startTime;
        if ((l < 0L) || (l > 180000L))
        {
          AppMethodBeat.o(188349);
          return;
        }
        str2 = this.CrE;
        if (this.url != null) {
          break label241;
        }
      }
      label241:
      for (String str1 = this.url;; str1 = this.url.replace(",", "!"))
      {
        ax.t(str2, new Object[] { Integer.valueOf(4), Long.valueOf(l), Integer.valueOf(i), str1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ax.Cru), Integer.valueOf(ax.Crv), Integer.valueOf(this.dCr), this.CrE });
        ac.i("MicroMsg.WebviewReporter", "WebViewTotalTimeReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { this.url, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(ax.Cru), Integer.valueOf(ax.Crv), Integer.valueOf(this.dCr), this.CrE });
        AppMethodBeat.o(188349);
        return;
      }
    }
  }
  
  public static final class g
  {
    private ArrayList<String> CrA;
    
    public g()
    {
      AppMethodBeat.i(188350);
      this.CrA = new ArrayList();
      AppMethodBeat.o(188350);
    }
    
    public final g C(Object... paramVarArgs)
    {
      AppMethodBeat.i(188351);
      int i = 0;
      if (i < 2)
      {
        Object localObject = paramVarArgs[i];
        ArrayList localArrayList = this.CrA;
        if (localObject != null) {}
        for (localObject = localObject.toString();; localObject = "")
        {
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(188351);
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(188352);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
      com.tencent.mm.plugin.report.service.h.k(11576, this.CrA);
      AppMethodBeat.o(188352);
    }
  }
  
  public static final class h
  {
    public List<String> CrF;
  }
  
  public static final class i
  {
    public List<String> CrF;
  }
  
  public final class j
  {
    private String CrE;
    private HashMap<String, Long> CrG;
    private int dCr;
    
    public j()
    {
      AppMethodBeat.i(79071);
      this.CrG = new HashMap();
      AppMethodBeat.o(79071);
    }
    
    public final void ch(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(79072);
      if (bs.isNullOrNil(paramString))
      {
        ac.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
        AppMethodBeat.o(79072);
        return;
      }
      if (this.CrG.containsKey(paramString))
      {
        if (paramBoolean)
        {
          long l1 = ((Long)this.CrG.get(paramString)).longValue();
          long l2 = bs.eWj();
          this.CrG.put(paramString, Long.valueOf(l2 - l1));
          AppMethodBeat.o(79072);
          return;
        }
        this.CrG.put(paramString, Long.valueOf(-1L));
      }
      AppMethodBeat.o(79072);
    }
    
    public final void report()
    {
      AppMethodBeat.i(188353);
      int i = ax.bhK();
      Iterator localIterator = this.CrG.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str1 = (String)((Map.Entry)localObject).getKey();
        long l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(32L, 2L, 1L, true);
        if (l == -1L)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(32L, 13L, 1L, true);
          ac.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report fail url : %s, netType : %d", new Object[] { str1, Integer.valueOf(i) });
        }
        if ((l >= 0L) && (l <= 60000L))
        {
          String str2 = this.CrE;
          if (str1 == null) {}
          for (localObject = str1;; localObject = str1.replace(",", "!"))
          {
            ax.t(str2, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(i), localObject, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ax.Cru), Integer.valueOf(ax.Crv), Integer.valueOf(this.dCr), this.CrE });
            ac.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report url : %s, cost time : %d, netType : %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { str1, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(this.dCr), this.CrE });
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(32L, 6L, l, true);
            break;
          }
        }
      }
      AppMethodBeat.o(188353);
    }
  }
  
  public final class k
  {
    String CrE;
    HashMap<String, Long> CrH;
    int dCr;
    
    public k()
    {
      AppMethodBeat.i(79074);
      this.CrH = new HashMap();
      AppMethodBeat.o(79074);
    }
    
    public final void aCj(String paramString)
    {
      AppMethodBeat.i(188354);
      if (bs.isNullOrNil(paramString))
      {
        ac.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.startLoadUrl failed, url is null");
        AppMethodBeat.o(188354);
        return;
      }
      if (!this.CrH.containsKey(paramString)) {
        this.CrH.put(paramString, Long.valueOf(bs.eWj()));
      }
      AppMethodBeat.o(188354);
    }
    
    public final void aCk(String paramString)
    {
      AppMethodBeat.i(188355);
      if (bs.isNullOrNil(paramString))
      {
        ac.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
        AppMethodBeat.o(188355);
        return;
      }
      if (this.CrH.containsKey(paramString))
      {
        long l1 = ((Long)this.CrH.get(paramString)).longValue();
        long l2 = bs.eWj();
        this.CrH.put(paramString, Long.valueOf(l2 - l1));
      }
      AppMethodBeat.o(188355);
    }
    
    public final k cv(int paramInt, String paramString)
    {
      this.dCr = paramInt;
      this.CrE = paramString;
      return this;
    }
  }
  
  public final class l
  {
    public String CrE;
    public int dCr;
    public boolean deB = true;
    public long lTa;
    public String url;
    
    public l() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ax
 * JD-Core Version:    0.7.0.1
 */