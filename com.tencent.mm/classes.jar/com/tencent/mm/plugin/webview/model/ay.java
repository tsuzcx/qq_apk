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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static int EmX = 0;
  private static int EmY = 0;
  public l EmI;
  public j EmJ;
  public k EmK;
  public aw EmL;
  private ak EmM;
  public f EmN;
  public b EmO;
  public g EmP;
  public d EmQ;
  private e EmR;
  private i EmS;
  private h EmT;
  private c EmU;
  public a EmV;
  private au EmW;
  public int EmZ;
  
  public ay()
  {
    AppMethodBeat.i(175743);
    this.EmZ = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(175743);
  }
  
  public static void CO(long paramLong)
  {
    AppMethodBeat.i(79094);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(79094);
      return;
    }
    int i = (int)(System.currentTimeMillis() - paramLong);
    if ((i >= 0) && (i < 20000)) {
      g.yxI.f(16269, new Object[] { Integer.valueOf(i), Integer.valueOf((int)(paramLong / 1000L)) });
    }
    AppMethodBeat.o(79094);
  }
  
  public static void aH(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (EmX = 1; paramBoolean2; EmX = 0)
    {
      EmY = 1;
      return;
    }
    EmY = 0;
  }
  
  public static int bma()
  {
    AppMethodBeat.i(79075);
    if (az.is4G(com.tencent.mm.sdk.platformtools.ak.getContext()))
    {
      AppMethodBeat.o(79075);
      return 5;
    }
    if (az.is5G(com.tencent.mm.sdk.platformtools.ak.getContext()))
    {
      AppMethodBeat.o(79075);
      return 7;
    }
    switch (az.getNetType(com.tencent.mm.sdk.platformtools.ak.getContext()))
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
  
  public static String diy()
  {
    AppMethodBeat.i(79076);
    Object localObject = (ConnectivityManager)com.tencent.mm.sdk.platformtools.ak.getContext().getSystemService("connectivity");
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
    ae.d("MicroMsg.WebviewReporter", "activeNetInfo extra=%s, type=%d, %s", new Object[] { ((NetworkInfo)localObject).getExtraInfo(), Integer.valueOf(((NetworkInfo)localObject).getType()), ((NetworkInfo)localObject).getExtraInfo() });
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
    AppMethodBeat.i(198161);
    ArrayList localArrayList = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(String.valueOf(paramVarArgs[i]));
      i += 1;
    }
    paramVarArgs = g.yxI;
    g.m(11215, localArrayList);
    if ((paramString != null) && (paramString.startsWith("official_mall")))
    {
      paramString = g.yxI;
      g.m(14919, localArrayList);
    }
    AppMethodBeat.o(198161);
  }
  
  public final boolean aC(Bundle paramBundle)
  {
    AppMethodBeat.i(198159);
    if (paramBundle != null)
    {
      if (this.EmV != null) {
        this.EmV.dyY = null;
      }
      this.EmV = new a(paramBundle);
      AppMethodBeat.o(198159);
      return true;
    }
    AppMethodBeat.o(198159);
    return false;
  }
  
  public final void aIX(String paramString)
  {
    AppMethodBeat.i(79092);
    a locala;
    if (this.EmV != null) {
      try
      {
        locala = this.EmV;
        boolean bool = locala.dyY.containsKey(paramString);
        if (!bool) {
          break label68;
        }
        try
        {
          locala.putValue(paramString, Integer.valueOf(locala.dyY.getInt(paramString) + 1));
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
  
  public final l eUj()
  {
    AppMethodBeat.i(79077);
    if (this.EmI == null) {
      this.EmI = new l();
    }
    l locall = this.EmI;
    AppMethodBeat.o(79077);
    return locall;
  }
  
  public final j eUk()
  {
    AppMethodBeat.i(79078);
    if (this.EmJ == null) {
      this.EmJ = new j();
    }
    j localj = this.EmJ;
    AppMethodBeat.o(79078);
    return localj;
  }
  
  public final k eUl()
  {
    AppMethodBeat.i(79079);
    if (this.EmK == null) {
      this.EmK = new k();
    }
    k localk = this.EmK;
    AppMethodBeat.o(79079);
    return localk;
  }
  
  public final e eUm()
  {
    AppMethodBeat.i(79080);
    if (this.EmR == null) {
      this.EmR = new e();
    }
    e locale = this.EmR;
    AppMethodBeat.o(79080);
    return locale;
  }
  
  public final aw eUn()
  {
    AppMethodBeat.i(198156);
    if (this.EmL == null) {
      this.EmL = new aw();
    }
    aw localaw = this.EmL;
    AppMethodBeat.o(198156);
    return localaw;
  }
  
  public final ak eUo()
  {
    AppMethodBeat.i(198157);
    if (this.EmM == null) {
      this.EmM = new ak();
    }
    ak localak = this.EmM;
    AppMethodBeat.o(198157);
    return localak;
  }
  
  public final f eUp()
  {
    AppMethodBeat.i(79083);
    if (this.EmN == null) {
      this.EmN = new f();
    }
    f localf = this.EmN;
    AppMethodBeat.o(79083);
    return localf;
  }
  
  public final b eUq()
  {
    AppMethodBeat.i(79084);
    if (this.EmO == null) {
      this.EmO = new b();
    }
    b localb = this.EmO;
    AppMethodBeat.o(79084);
    return localb;
  }
  
  public final g eUr()
  {
    AppMethodBeat.i(79085);
    if (this.EmP == null) {
      this.EmP = new g();
    }
    g localg = this.EmP;
    AppMethodBeat.o(79085);
    return localg;
  }
  
  public final d eUs()
  {
    AppMethodBeat.i(79086);
    if (this.EmQ == null) {
      this.EmQ = new d();
    }
    d locald = this.EmQ;
    AppMethodBeat.o(79086);
    return locald;
  }
  
  public final i eUt()
  {
    AppMethodBeat.i(79087);
    if (this.EmS == null) {
      this.EmS = new i();
    }
    i locali = this.EmS;
    AppMethodBeat.o(79087);
    return locali;
  }
  
  public final h eUu()
  {
    AppMethodBeat.i(79088);
    if (this.EmT == null) {
      this.EmT = new h();
    }
    h localh = this.EmT;
    AppMethodBeat.o(79088);
    return localh;
  }
  
  public final c eUv()
  {
    AppMethodBeat.i(79089);
    if (this.EmU == null) {
      this.EmU = new c();
    }
    c localc = this.EmU;
    AppMethodBeat.o(79089);
    return localc;
  }
  
  public final au eUw()
  {
    AppMethodBeat.i(198158);
    if (this.EmW == null) {
      this.EmW = new au();
    }
    au localau = this.EmW;
    AppMethodBeat.o(198158);
    return localau;
  }
  
  public final void report()
  {
    AppMethodBeat.i(198160);
    k localk = eUl();
    int i = bma();
    Iterator localIterator = localk.Enk.entrySet().iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      localObject2 = (String)((Map.Entry)localObject1).getKey();
      long l = ((Long)((Map.Entry)localObject1).getValue()).longValue();
      g.yxI.idkeyStat(32L, 0L, 1L, true);
      if ((l >= 0L) && (l <= 180000L))
      {
        String str = localk.Enh;
        if (localObject2 == null) {}
        for (localObject1 = localObject2;; localObject1 = ((String)localObject2).replace(",", "!"))
        {
          t(str, new Object[] { Integer.valueOf(3), Long.valueOf(l), Integer.valueOf(i), localObject1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(EmX), Integer.valueOf(EmY), Integer.valueOf(localk.dPU), localk.Enh });
          g.yxI.idkeyStat(160L, 0L, 1L, false);
          if (-1 != com.tencent.mm.plugin.webview.h.a.CP(l)) {
            g.yxI.idkeyStat(160L, com.tencent.mm.plugin.webview.h.a.CP(l), 1L, false);
          }
          g.yxI.idkeyStat(32L, 3L, 1L, true);
          g.yxI.idkeyStat(32L, 7L, l, true);
          if (EmY == 1)
          {
            g.yxI.idkeyStat(32L, 16L, 1L, true);
            g.yxI.idkeyStat(32L, 17L, l, true);
          }
          ae.i("MicroMsg.WebviewReporter", "WebviewOpenUrlReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { localObject2, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(EmX), Integer.valueOf(EmY), Integer.valueOf(localk.dPU), localk.Enh });
          break;
        }
      }
    }
    Object localObject1 = eUn();
    if (!bu.isNullOrNil(((aw)localObject1).Emy)) {
      ae.d("MicroMsg.WebviewReporter", "WebViewVisitReporter report viewID = %s", new Object[] { ((aw)localObject1).Emy });
    }
    try
    {
      h.a("com.tencent.mm", (Parcelable)IPCVoid.gAP, aw.a.EmG.getClass(), (d)new aw.b((aw)localObject1));
      localObject1 = eUo();
      if (!bu.isNullOrNil(((ak)localObject1).hFX))
      {
        localObject2 = ((ak)localObject1).hFX;
        if (localObject2 == null) {
          p.gkB();
        }
        if (n.nF((String)localObject2, "wrd")) {}
      }
      else
      {
        eUk().report();
        eUm().report();
        localObject1 = eUq();
        i = bma();
        if (!((b)localObject1).Enb) {
          break label928;
        }
        if (!((b)localObject1).loadFinished) {
          break label879;
        }
        g.yxI.f(11575, new Object[] { ((b)localObject1).dLz, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i) });
        AppMethodBeat.o(198160);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ae.w("MicroMsg.WebviewReporter", "invokeAsResult error, %s", new Object[] { localRemoteException });
        continue;
        localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("iswebviewreadtime=1");
        ((StringBuffer)localObject2).append("&publishid=");
        ((StringBuffer)localObject2).append(localRemoteException.hFX);
        ((StringBuffer)localObject2).append("&staytime=");
        ((StringBuffer)localObject2).append(localRemoteException.dCI);
        ((StringBuffer)localObject2).append("&allstaytime=");
        ((StringBuffer)localObject2).append(System.currentTimeMillis() - localRemoteException.enterTime);
        ((StringBuffer)localObject2).append("&maxscrolly=");
        ((StringBuffer)localObject2).append(localRemoteException.Emc);
        ((StringBuffer)localObject2).append("&totalscrolly=");
        ((StringBuffer)localObject2).append(localRemoteException.AFq);
        ((StringBuffer)localObject2).append("&scene=");
        ((StringBuffer)localObject2).append(localRemoteException.scene);
        ((StringBuffer)localObject2).append("&entertime=");
        ((StringBuffer)localObject2).append(localRemoteException.enterTime);
        ((StringBuffer)localObject2).append("&screenheight=");
        ((StringBuffer)localObject2).append(com.tencent.mm.cb.a.iv(com.tencent.mm.sdk.platformtools.ak.getContext()));
        Bundle localBundle = new Bundle();
        localBundle.putString("reportString", ((StringBuffer)localObject2).toString());
        try
        {
          h.a("com.tencent.mm", (Parcelable)localBundle, ak.a.Emd.getClass(), null);
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace("MicroMsg.WebviewReporter", (Throwable)localException, "TopStory report", new Object[0]);
        }
      }
      label879:
      g.yxI.f(11575, new Object[] { localException.dLz, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(198160);
      return;
    }
    label928:
    g.yxI.f(11575, new Object[] { localException.dLz, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(i) });
    AppMethodBeat.o(198160);
  }
  
  public final void w(String paramString, Object paramObject)
  {
    AppMethodBeat.i(79091);
    if (this.EmV != null) {
      try
      {
        this.EmV.putValue(paramString, paramObject);
        AppMethodBeat.o(79091);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(79091);
  }
  
  public final class a
  {
    public Bundle dyY = null;
    
    a(Bundle paramBundle)
    {
      this.dyY = paramBundle;
    }
    
    public final void putValue(String paramString, Object paramObject)
    {
      AppMethodBeat.i(79061);
      if (this.dyY != null)
      {
        if ((paramObject instanceof String))
        {
          this.dyY.putString(paramString, (String)paramObject);
          AppMethodBeat.o(79061);
          return;
        }
        if ((paramObject instanceof Boolean))
        {
          this.dyY.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
          AppMethodBeat.o(79061);
          return;
        }
        if ((paramObject instanceof Integer))
        {
          this.dyY.putInt(paramString, ((Integer)paramObject).intValue());
          AppMethodBeat.o(79061);
          return;
        }
        ae.w("MicroMsg.WebviewReporter", "put unknow type value.");
      }
      AppMethodBeat.o(79061);
    }
  }
  
  public static final class b
  {
    public boolean Enb = false;
    String dLz;
    public boolean loadFinished = false;
    
    public final b aIY(String paramString)
    {
      this.dLz = paramString;
      return this;
    }
  }
  
  public static final class c
  {
    private boolean Enc = false;
    public boolean rHX = false;
    
    public final void cF(String paramString)
    {
      AppMethodBeat.i(198141);
      if ((!this.rHX) || (this.Enc))
      {
        AppMethodBeat.o(198141);
        return;
      }
      try
      {
        Object localObject = Uri.parse(paramString);
        if (!paramString.startsWith("http"))
        {
          ae.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, url not startswith http");
          AppMethodBeat.o(198141);
          return;
        }
        localObject = ((Uri)localObject).getHost();
        if ((localObject != null) && (((String)localObject).equalsIgnoreCase("v.html5.qq.com")))
        {
          g.yxI.idkeyStat(283L, 0L, 1L, true);
          this.Enc = true;
          ae.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, domain visit reported, url = %s", new Object[] { paramString });
        }
        AppMethodBeat.o(198141);
        return;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, parse url fail, url = %s", new Object[] { paramString });
        AppMethodBeat.o(198141);
      }
    }
  }
  
  public static final class d
  {
    private ArrayList<String> End;
    
    public d()
    {
      AppMethodBeat.i(198142);
      this.End = new ArrayList();
      AppMethodBeat.o(198142);
    }
    
    public final d B(Object... paramVarArgs)
    {
      AppMethodBeat.i(198143);
      int j = paramVarArgs.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramVarArgs[i];
        ArrayList localArrayList = this.End;
        if (localObject == null) {}
        for (localObject = "";; localObject = localObject.toString())
        {
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(198143);
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(198144);
      g localg = g.yxI;
      g.m(11577, this.End);
      AppMethodBeat.o(198144);
    }
  }
  
  public final class e
  {
    private ConcurrentHashMap<String, Long> Ene;
    private ConcurrentHashMap<String, Long> Enf;
    private boolean Eng;
    private String Enh;
    private int dPU;
    private String mzb;
    
    public e()
    {
      AppMethodBeat.i(79063);
      this.mzb = "";
      this.Eng = true;
      this.Ene = new ConcurrentHashMap();
      this.Enf = new ConcurrentHashMap();
      AppMethodBeat.o(79063);
    }
    
    public final void aIZ(String paramString)
    {
      AppMethodBeat.i(198145);
      if (bu.isNullOrNil(paramString))
      {
        ae.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageStart failed, url is null");
        AppMethodBeat.o(198145);
        return;
      }
      this.mzb = paramString;
      this.Eng = true;
      if (!this.Ene.containsKey(paramString)) {
        this.Ene.put(paramString, Long.valueOf(bu.fpO()));
      }
      if (!this.Enf.containsKey(paramString)) {
        this.Enf.put(paramString, Long.valueOf(bu.fpO()));
      }
      AppMethodBeat.o(198145);
    }
    
    public final void aJa(String paramString)
    {
      AppMethodBeat.i(198146);
      if (bu.isNullOrNil(paramString))
      {
        ae.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onLoadResource failed, url is null");
        AppMethodBeat.o(198146);
        return;
      }
      try
      {
        if ((!bu.isNullOrNil(this.mzb)) && (!paramString.equals(this.mzb)) && (this.Eng))
        {
          if (this.Ene.containsKey(this.mzb))
          {
            long l1 = ((Long)this.Ene.get(this.mzb)).longValue();
            long l2 = bu.fpO();
            this.Ene.put(this.mzb, Long.valueOf(l2 - l1));
          }
          this.Eng = false;
        }
        AppMethodBeat.o(198146);
        return;
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("MicroMsg.WebviewReporter", paramString, "onLoadResource", new Object[0]);
        AppMethodBeat.o(198146);
      }
    }
    
    public final void aJb(String paramString)
    {
      AppMethodBeat.i(198147);
      if (bu.isNullOrNil(paramString))
      {
        ae.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageFinish failed, url is null");
        AppMethodBeat.o(198147);
        return;
      }
      try
      {
        if (this.Enf.containsKey(paramString))
        {
          long l1 = ((Long)this.Enf.get(paramString)).longValue();
          long l2 = bu.fpO();
          this.Enf.put(paramString, Long.valueOf(l2 - l1));
        }
        AppMethodBeat.o(198147);
        return;
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("MicroMsg.WebviewReporter", paramString, "onPageFinish", new Object[0]);
        AppMethodBeat.o(198147);
      }
    }
    
    public final e cA(int paramInt, String paramString)
    {
      this.dPU = paramInt;
      this.Enh = paramString;
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(198148);
      int i = ay.bma();
      Iterator localIterator = this.Ene.entrySet().iterator();
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
          AppMethodBeat.o(198148);
          return;
        }
        localObject = this.Enh;
        if (str == null) {}
        for (;;)
        {
          ay.u((String)localObject, new Object[] { Integer.valueOf(5), Long.valueOf(l), Integer.valueOf(i), str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ay.EmX), Integer.valueOf(ay.EmY), Integer.valueOf(this.dPU), this.Enh });
          if (ay.EmX == 1)
          {
            g.yxI.idkeyStat(32L, 18L, 1L, true);
            g.yxI.idkeyStat(32L, 19L, l, true);
          }
          g.yxI.idkeyStat(32L, 8L, 1L, true);
          g.yxI.idkeyStat(32L, 9L, l, true);
          ae.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report DomReady cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(ay.EmX), Integer.valueOf(ay.EmY), Integer.valueOf(this.dPU), this.Enh });
          break;
          str = str.replace(",", "!");
        }
      }
      localIterator = this.Enf.entrySet().iterator();
      if (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        str = (String)((Map.Entry)localObject).getKey();
        l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        if ((l < 0L) || (l > 180000L))
        {
          AppMethodBeat.o(198148);
          return;
        }
        localObject = this.Enh;
        if (str == null) {}
        for (;;)
        {
          ay.u((String)localObject, new Object[] { Integer.valueOf(6), Long.valueOf(l), Integer.valueOf(i), str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ay.EmX), Integer.valueOf(ay.EmY), Integer.valueOf(this.dPU), this.Enh });
          if (ay.EmX == 1)
          {
            g.yxI.idkeyStat(32L, 20L, 1L, true);
            g.yxI.idkeyStat(32L, 21L, l, true);
          }
          g.yxI.idkeyStat(32L, 10L, 1L, true);
          g.yxI.idkeyStat(32L, 11L, l, true);
          ae.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report Render cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(ay.EmX), Integer.valueOf(ay.EmY), Integer.valueOf(this.dPU), this.Enh });
          break;
          str = str.replace(",", "!");
        }
      }
      AppMethodBeat.o(198148);
    }
  }
  
  public final class f
  {
    public String Enh;
    private boolean clB;
    public int dPU;
    private long startTime;
    public String url;
    
    public f()
    {
      AppMethodBeat.i(79068);
      this.clB = false;
      this.startTime = bu.fpO();
      AppMethodBeat.o(79068);
    }
    
    public final void report()
    {
      AppMethodBeat.i(198149);
      int i;
      long l;
      String str2;
      if (!this.clB)
      {
        this.clB = true;
        i = ay.bma();
        l = bu.fpO() - this.startTime;
        if ((l < 0L) || (l > 180000L))
        {
          AppMethodBeat.o(198149);
          return;
        }
        str2 = this.Enh;
        if (this.url != null) {
          break label241;
        }
      }
      label241:
      for (String str1 = this.url;; str1 = this.url.replace(",", "!"))
      {
        ay.u(str2, new Object[] { Integer.valueOf(4), Long.valueOf(l), Integer.valueOf(i), str1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ay.EmX), Integer.valueOf(ay.EmY), Integer.valueOf(this.dPU), this.Enh });
        ae.i("MicroMsg.WebviewReporter", "WebViewTotalTimeReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { this.url, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(ay.EmX), Integer.valueOf(ay.EmY), Integer.valueOf(this.dPU), this.Enh });
        AppMethodBeat.o(198149);
        return;
      }
    }
  }
  
  public static final class g
  {
    private ArrayList<String> End;
    
    public g()
    {
      AppMethodBeat.i(198150);
      this.End = new ArrayList();
      AppMethodBeat.o(198150);
    }
    
    public final g C(Object... paramVarArgs)
    {
      AppMethodBeat.i(198151);
      int i = 0;
      if (i < 2)
      {
        Object localObject = paramVarArgs[i];
        ArrayList localArrayList = this.End;
        if (localObject != null) {}
        for (localObject = localObject.toString();; localObject = "")
        {
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(198151);
      return this;
    }
    
    public final void report()
    {
      AppMethodBeat.i(198152);
      g localg = g.yxI;
      g.m(11576, this.End);
      AppMethodBeat.o(198152);
    }
  }
  
  public static final class h
  {
    public List<String> Eni;
  }
  
  public static final class i
  {
    public List<String> Eni;
  }
  
  public final class j
  {
    private String Enh;
    private HashMap<String, Long> Enj;
    private int dPU;
    
    public j()
    {
      AppMethodBeat.i(79071);
      this.Enj = new HashMap();
      AppMethodBeat.o(79071);
    }
    
    public final void cs(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(79072);
      if (bu.isNullOrNil(paramString))
      {
        ae.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
        AppMethodBeat.o(79072);
        return;
      }
      if (this.Enj.containsKey(paramString))
      {
        if (paramBoolean)
        {
          long l1 = ((Long)this.Enj.get(paramString)).longValue();
          long l2 = bu.fpO();
          this.Enj.put(paramString, Long.valueOf(l2 - l1));
          AppMethodBeat.o(79072);
          return;
        }
        this.Enj.put(paramString, Long.valueOf(-1L));
      }
      AppMethodBeat.o(79072);
    }
    
    public final void report()
    {
      AppMethodBeat.i(198153);
      int i = ay.bma();
      Iterator localIterator = this.Enj.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str1 = (String)((Map.Entry)localObject).getKey();
        long l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        g.yxI.idkeyStat(32L, 2L, 1L, true);
        if (l == -1L)
        {
          g.yxI.idkeyStat(32L, 13L, 1L, true);
          ae.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report fail url : %s, netType : %d", new Object[] { str1, Integer.valueOf(i) });
        }
        if ((l >= 0L) && (l <= 60000L))
        {
          String str2 = this.Enh;
          if (str1 == null) {}
          for (localObject = str1;; localObject = str1.replace(",", "!"))
          {
            ay.u(str2, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(i), localObject, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ay.EmX), Integer.valueOf(ay.EmY), Integer.valueOf(this.dPU), this.Enh });
            ae.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report url : %s, cost time : %d, netType : %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { str1, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(this.dPU), this.Enh });
            g.yxI.idkeyStat(32L, 6L, l, true);
            break;
          }
        }
      }
      AppMethodBeat.o(198153);
    }
  }
  
  public final class k
  {
    String Enh;
    HashMap<String, Long> Enk;
    int dPU;
    
    public k()
    {
      AppMethodBeat.i(79074);
      this.Enk = new HashMap();
      AppMethodBeat.o(79074);
    }
    
    public final void aJc(String paramString)
    {
      AppMethodBeat.i(198154);
      if (bu.isNullOrNil(paramString))
      {
        ae.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.startLoadUrl failed, url is null");
        AppMethodBeat.o(198154);
        return;
      }
      if (!this.Enk.containsKey(paramString)) {
        this.Enk.put(paramString, Long.valueOf(bu.fpO()));
      }
      AppMethodBeat.o(198154);
    }
    
    public final void aJd(String paramString)
    {
      AppMethodBeat.i(198155);
      if (bu.isNullOrNil(paramString))
      {
        ae.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
        AppMethodBeat.o(198155);
        return;
      }
      if (this.Enk.containsKey(paramString))
      {
        long l1 = ((Long)this.Enk.get(paramString)).longValue();
        long l2 = bu.fpO();
        this.Enk.put(paramString, Long.valueOf(l2 - l1));
      }
      AppMethodBeat.o(198155);
    }
    
    public final k cB(int paramInt, String paramString)
    {
      this.dPU = paramInt;
      this.Enh = paramString;
      return this;
    }
  }
  
  public final class l
  {
    public String Enh;
    public int dPU;
    public boolean drc = true;
    public long mxN;
    public String url;
    
    public l() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ay
 * JD-Core Version:    0.7.0.1
 */