package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.b;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class as
{
  private static int uWK = 0;
  private static int uWL = 0;
  public as.h uWA;
  public c uWB;
  public as.i uWC;
  public as.e uWD;
  private as.f uWE;
  private as.k uWF;
  private as.j uWG;
  private as.d uWH;
  public as.b uWI;
  private as.g uWJ;
  public o uWv;
  public m uWw;
  public as.n uWx;
  public l uWy;
  private as.a uWz;
  
  public static void W(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (uWK = 1; paramBoolean2; uWK = 0)
    {
      uWL = 1;
      return;
    }
    uWL = 0;
  }
  
  private static void a(d paramd, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(6794);
    if (paramd == null)
    {
      AppMethodBeat.o(6794);
      return;
    }
    com.tencent.mm.plugin.webview.ui.tools.g.a(paramd, 11215, paramVarArgs);
    if ((paramString != null) && (paramString.startsWith("official_mall"))) {
      com.tencent.mm.plugin.webview.ui.tools.g.a(paramd, 14919, paramVarArgs);
    }
    AppMethodBeat.o(6794);
  }
  
  public static int aDS()
  {
    AppMethodBeat.i(6774);
    if (at.is4G(ah.getContext()))
    {
      AppMethodBeat.o(6774);
      return 5;
    }
    switch (at.getNetType(ah.getContext()))
    {
    default: 
      AppMethodBeat.o(6774);
      return 6;
    case -1: 
      AppMethodBeat.o(6774);
      return 255;
    case 0: 
      AppMethodBeat.o(6774);
      return 1;
    case 3: 
    case 4: 
      AppMethodBeat.o(6774);
      return 4;
    case 2: 
    case 5: 
    case 7: 
      AppMethodBeat.o(6774);
      return 2;
    }
    AppMethodBeat.o(6774);
    return 3;
  }
  
  public static String dcf()
  {
    AppMethodBeat.i(6775);
    Object localObject = (ConnectivityManager)ah.getContext().getSystemService("connectivity");
    if (localObject == null)
    {
      AppMethodBeat.o(6775);
      return "no";
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(6775);
      return "no";
    }
    if (((NetworkInfo)localObject).getType() == 1)
    {
      AppMethodBeat.o(6775);
      return "WIFI";
    }
    ab.d("MicroMsg.WebviewReporter", "activeNetInfo extra=%s, type=%d, %s", new Object[] { ((NetworkInfo)localObject).getExtraInfo(), Integer.valueOf(((NetworkInfo)localObject).getType()), ((NetworkInfo)localObject).getExtraInfo() });
    if (((NetworkInfo)localObject).getExtraInfo() != null)
    {
      localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      AppMethodBeat.o(6775);
      return localObject;
    }
    AppMethodBeat.o(6775);
    return "no";
  }
  
  public static void nn(long paramLong)
  {
    AppMethodBeat.i(6793);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(6793);
      return;
    }
    int i = (int)(System.currentTimeMillis() - paramLong);
    if ((i >= 0) && (i < 20000)) {
      h.qsU.e(16269, new Object[] { Integer.valueOf(i), Integer.valueOf((int)(paramLong / 1000L)) });
    }
    AppMethodBeat.o(6793);
  }
  
  public final void ahs(String paramString)
  {
    AppMethodBeat.i(6791);
    as.b localb;
    if (this.uWI != null) {
      try
      {
        localb = this.uWI;
        boolean bool = localb.mEJ.containsKey(paramString);
        if (!bool) {
          break label72;
        }
        try
        {
          localb.putValue(paramString, Integer.valueOf(localb.mEJ.getInt(paramString) + 1));
          AppMethodBeat.o(6791);
          return;
        }
        catch (Exception paramString)
        {
          AppMethodBeat.o(6791);
          return;
        }
        AppMethodBeat.o(6791);
      }
      catch (Exception paramString) {}
    } else {
      return;
    }
    label72:
    localb.putValue(paramString, Integer.valueOf(1));
    AppMethodBeat.o(6791);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(6792);
    Object localObject4 = dci();
    Object localObject5;
    Object localObject1;
    if (paramd != null)
    {
      i = aDS();
      localObject5 = ((as.n)localObject4).uXh.entrySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject1 = (Map.Entry)((Iterator)localObject5).next();
        localObject3 = (String)((Map.Entry)localObject1).getKey();
        l1 = ((Long)((Map.Entry)localObject1).getValue()).longValue();
        h.qsU.idkeyStat(32L, 0L, 1L, true);
        if ((l1 >= 0L) && (l1 <= 180000L))
        {
          localObject6 = ((as.n)localObject4).uWU;
          if (localObject3 == null) {}
          for (localObject1 = localObject3;; localObject1 = ((String)localObject3).replace(",", "!"))
          {
            a(paramd, (String)localObject6, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Integer.valueOf(i), localObject1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(uWK), Integer.valueOf(uWL), Integer.valueOf(((as.n)localObject4).cNH), ((as.n)localObject4).uWU });
            h.qsU.idkeyStat(160L, 0L, 1L, false);
            if (-1 != b.np(l1)) {
              h.qsU.idkeyStat(160L, b.np(l1), 1L, false);
            }
            h.qsU.idkeyStat(32L, 3L, 1L, true);
            h.qsU.idkeyStat(32L, 7L, l1, true);
            if (uWL == 1)
            {
              h.qsU.idkeyStat(32L, 16L, 1L, true);
              h.qsU.idkeyStat(32L, 17L, l1, true);
            }
            ab.i("MicroMsg.WebviewReporter", "WebviewOpenUrlReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { localObject3, Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(uWK), Integer.valueOf(uWL), Integer.valueOf(((as.n)localObject4).cNH), ((as.n)localObject4).uWU });
            break;
          }
        }
      }
    }
    Object localObject6 = dck();
    if (!bo.isNullOrNil(((l)localObject6).uWY)) {
      ab.d("MicroMsg.WebviewReporter", "WebViewVisitReporter report viewID = %s", new Object[] { ((l)localObject6).uWY });
    }
    if (paramd != null) {
      localObject1 = "";
    }
    try
    {
      localObject3 = paramd.i(23, new Bundle(0));
      if (localObject3 != null) {
        localObject1 = ((Bundle)localObject3).getString("config_info_username");
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        PString localPString;
        String str2;
        ab.w("MicroMsg.WebviewReporter", "invokeAsResult error, %s", new Object[] { localRemoteException });
        localObject2 = "";
      }
    }
    localPString = new PString();
    str2 = ((i)com.tencent.mm.kernel.g.E(i.class)).a(((l)localObject6).rHA, localPString);
    ab.d("MicroMsg.WebviewReporter", "report 10643(%s), username : %s, msgId : %s, msgIndex : %s, scene : %s, enterTime : %s, stayTime : %s, rawUrl : %s, publisher : %s, viewId : %s, publishId : %s,appId : %s, newMsgId : %s, preUsername : %s, curUsername : %s, referUrl : %s, statExtStr:%s(%s), chatType:%d, title:%s, expidstr[chatting_exp]:%s, sourceAppId:%s, allStayTime %d", new Object[] { Integer.valueOf(10643), ((l)localObject6).username, Long.valueOf(((l)localObject6).uWZ), Integer.valueOf(((l)localObject6).uXa), Integer.valueOf(((l)localObject6).scene), Long.valueOf(((l)localObject6).eaj), Long.valueOf(((l)localObject6).iHh), ((l)localObject6).cJr, ((l)localObject6).uWX, ((l)localObject6).uWY, ((l)localObject6).fjC, ((l)localObject6).appId, ((l)localObject6).uXb, ((l)localObject6).uXc, localObject1, ((l)localObject6).uXd, ((l)localObject6).rHA, str2, Integer.valueOf(((l)localObject6).uXe), ((l)localObject6).title, ((l)localObject6).dHa, localPString.value, Long.valueOf(System.currentTimeMillis() - ((l)localObject6).eaj) });
    Object localObject3 = ((l)localObject6).title;
    try
    {
      localObject4 = URLEncoder.encode(((l)localObject6).title, "UTF-8");
      localObject3 = localObject4;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        String str3;
        int j;
        long l2;
        long l3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        ab.printErrStackTrace("MicroMsg.WebviewReporter", localException2, "", new Object[0]);
        continue;
        String str1 = ((l)localObject6).cJr.replace(",", "!");
        continue;
        localObject5 = ((l)localObject6).uXd.replace(",", "!");
        continue;
        Object localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("iswebviewreadtime=1");
        ((StringBuffer)localObject2).append("&publishid=");
        ((StringBuffer)localObject2).append(((as.a)localObject3).fjC);
        ((StringBuffer)localObject2).append("&staytime=");
        ((StringBuffer)localObject2).append(((as.a)localObject3).iHh);
        ((StringBuffer)localObject2).append("&allstaytime=");
        ((StringBuffer)localObject2).append(System.currentTimeMillis() - ((as.a)localObject3).eaj);
        ((StringBuffer)localObject2).append("&maxscrolly=");
        ((StringBuffer)localObject2).append(((as.a)localObject3).uWM);
        ((StringBuffer)localObject2).append("&totalscrolly=");
        ((StringBuffer)localObject2).append(((as.a)localObject3).sbd);
        ((StringBuffer)localObject2).append("&scene=");
        ((StringBuffer)localObject2).append(((as.a)localObject3).scene);
        ((StringBuffer)localObject2).append("&entertime=");
        ((StringBuffer)localObject2).append(((as.a)localObject3).eaj);
        ((StringBuffer)localObject2).append("&screenheight=");
        ((StringBuffer)localObject2).append(a.gx(ah.getContext()));
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("reportString", ((StringBuffer)localObject2).toString());
        try
        {
          paramd.r(6, (Bundle)localObject3);
        }
        catch (Exception localException1)
        {
          ab.printErrStackTrace("MicroMsg.WebviewReporter", localException1, "TopStory report", new Object[0]);
        }
      }
      com.tencent.mm.plugin.webview.ui.tools.g.a(paramd, 11575, new Object[] { localException1.cJr, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(6792);
      return;
    }
    str3 = ((l)localObject6).username;
    long l1 = ((l)localObject6).uWZ;
    int i = ((l)localObject6).uXa;
    j = ((l)localObject6).scene;
    l2 = ((l)localObject6).eaj;
    l3 = ((l)localObject6).iHh;
    if (((l)localObject6).cJr == null)
    {
      localObject4 = ((l)localObject6).cJr;
      str4 = ((l)localObject6).uWX;
      str5 = ((l)localObject6).uWY;
      str6 = ((l)localObject6).fjC;
      str7 = ((l)localObject6).appId;
      str8 = ((l)localObject6).uXb;
      str9 = ((l)localObject6).uXc;
      if (((l)localObject6).uXd != null) {
        break label1302;
      }
      localObject5 = ((l)localObject6).uXd;
      com.tencent.mm.plugin.webview.ui.tools.g.a(paramd, 10643, new Object[] { str3, Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l2), Long.valueOf(l3), localObject4, str4, str5, str6, str7, str8, str9, localObject1, localObject5, str2, Integer.valueOf(((l)localObject6).uXe), localObject3, ((l)localObject6).dHa, localPString.value, "", "", "", Long.valueOf(System.currentTimeMillis() - ((l)localObject6).eaj), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(((l)localObject6).uXf) });
      localObject3 = dcl();
      if ((!bo.isNullOrNil(((as.a)localObject3).fjC)) && (((as.a)localObject3).fjC.startsWith("wrd"))) {
        break label1321;
      }
      dch().b(paramd);
      dcj().b(paramd);
      localObject1 = dcn();
      if (paramd == null) {
        break label1646;
      }
      i = aDS();
      if (!((c)localObject1).uWO) {
        break label1606;
      }
      if (!((c)localObject1).loadFinished) {
        break label1559;
      }
      com.tencent.mm.plugin.webview.ui.tools.g.a(paramd, 11575, new Object[] { ((c)localObject1).cJr, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(6792);
    }
    label1302:
    label1321:
    label1606:
    com.tencent.mm.plugin.webview.ui.tools.g.a(paramd, 11575, new Object[] { localException1.cJr, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(i) });
    label1559:
    label1646:
    AppMethodBeat.o(6792);
  }
  
  public final o dcg()
  {
    AppMethodBeat.i(6776);
    if (this.uWv == null) {
      this.uWv = new o();
    }
    o localo = this.uWv;
    AppMethodBeat.o(6776);
    return localo;
  }
  
  public final m dch()
  {
    AppMethodBeat.i(6777);
    if (this.uWw == null) {
      this.uWw = new m();
    }
    m localm = this.uWw;
    AppMethodBeat.o(6777);
    return localm;
  }
  
  public final as.n dci()
  {
    AppMethodBeat.i(6778);
    if (this.uWx == null) {
      this.uWx = new as.n(this);
    }
    as.n localn = this.uWx;
    AppMethodBeat.o(6778);
    return localn;
  }
  
  public final as.f dcj()
  {
    AppMethodBeat.i(6779);
    if (this.uWE == null) {
      this.uWE = new as.f(this);
    }
    as.f localf = this.uWE;
    AppMethodBeat.o(6779);
    return localf;
  }
  
  public final l dck()
  {
    AppMethodBeat.i(6780);
    if (this.uWy == null) {
      this.uWy = new l();
    }
    l locall = this.uWy;
    AppMethodBeat.o(6780);
    return locall;
  }
  
  public final as.a dcl()
  {
    AppMethodBeat.i(6781);
    if (this.uWz == null) {
      this.uWz = new as.a();
    }
    as.a locala = this.uWz;
    AppMethodBeat.o(6781);
    return locala;
  }
  
  public final as.h dcm()
  {
    AppMethodBeat.i(6782);
    if (this.uWA == null) {
      this.uWA = new as.h(this);
    }
    as.h localh = this.uWA;
    AppMethodBeat.o(6782);
    return localh;
  }
  
  public final c dcn()
  {
    AppMethodBeat.i(6783);
    if (this.uWB == null) {
      this.uWB = new c();
    }
    c localc = this.uWB;
    AppMethodBeat.o(6783);
    return localc;
  }
  
  public final as.i dco()
  {
    AppMethodBeat.i(6784);
    if (this.uWC == null) {
      this.uWC = new as.i();
    }
    as.i locali = this.uWC;
    AppMethodBeat.o(6784);
    return locali;
  }
  
  public final as.e dcp()
  {
    AppMethodBeat.i(6785);
    if (this.uWD == null) {
      this.uWD = new as.e();
    }
    as.e locale = this.uWD;
    AppMethodBeat.o(6785);
    return locale;
  }
  
  public final as.k dcq()
  {
    AppMethodBeat.i(6786);
    if (this.uWF == null) {
      this.uWF = new as.k();
    }
    as.k localk = this.uWF;
    AppMethodBeat.o(6786);
    return localk;
  }
  
  public final as.j dcr()
  {
    AppMethodBeat.i(6787);
    if (this.uWG == null) {
      this.uWG = new as.j();
    }
    as.j localj = this.uWG;
    AppMethodBeat.o(6787);
    return localj;
  }
  
  public final as.d dcs()
  {
    AppMethodBeat.i(6788);
    if (this.uWH == null) {
      this.uWH = new as.d();
    }
    as.d locald = this.uWH;
    AppMethodBeat.o(6788);
    return locald;
  }
  
  public final as.g dct()
  {
    AppMethodBeat.i(6789);
    if (this.uWJ == null) {
      this.uWJ = new as.g();
    }
    as.g localg = this.uWJ;
    AppMethodBeat.o(6789);
    return localg;
  }
  
  public final void r(String paramString, Object paramObject)
  {
    AppMethodBeat.i(6790);
    if (this.uWI != null) {
      try
      {
        this.uWI.putValue(paramString, paramObject);
        AppMethodBeat.o(6790);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(6790);
  }
  
  public static final class c
  {
    public String cJr;
    public boolean loadFinished = false;
    public boolean uWO = false;
  }
  
  public static final class l
  {
    public String appId;
    public String cJr;
    public String dHa;
    long eaj;
    public String fjC;
    public long iHh;
    public long lastResumeTime;
    public String rHA;
    public int scene;
    public String title;
    public String uWX;
    public String uWY;
    public long uWZ;
    public int uXa;
    public String uXb;
    public String uXc;
    public String uXd;
    public int uXe;
    public int uXf;
    public String username;
    
    public l()
    {
      AppMethodBeat.i(6769);
      this.lastResumeTime = -1L;
      this.eaj = (System.currentTimeMillis() / 1000L);
      AppMethodBeat.o(6769);
    }
  }
  
  public final class m
  {
    public int cNH;
    public String uWU;
    public HashMap<String, Long> uXg;
    
    public m()
    {
      AppMethodBeat.i(6770);
      this.uXg = new HashMap();
      AppMethodBeat.o(6770);
    }
    
    public final void b(d paramd)
    {
      AppMethodBeat.i(6772);
      if (paramd == null)
      {
        AppMethodBeat.o(6772);
        return;
      }
      int i = as.aDS();
      Iterator localIterator = this.uXg.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str1 = (String)((Map.Entry)localObject).getKey();
        long l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        h.qsU.idkeyStat(32L, 2L, 1L, true);
        if (l == -1L)
        {
          h.qsU.idkeyStat(32L, 13L, 1L, true);
          ab.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report fail url : %s, netType : %d", new Object[] { str1, Integer.valueOf(i) });
        }
        if ((l >= 0L) && (l <= 60000L))
        {
          String str2 = this.uWU;
          if (str1 == null) {}
          for (localObject = str1;; localObject = str1.replace(",", "!"))
          {
            as.b(paramd, str2, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(i), localObject, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(as.access$000()), Integer.valueOf(as.access$100()), Integer.valueOf(this.cNH), this.uWU });
            ab.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report url : %s, cost time : %d, netType : %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { str1, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(this.cNH), this.uWU });
            h.qsU.idkeyStat(32L, 6L, l, true);
            break;
          }
        }
      }
      AppMethodBeat.o(6772);
    }
    
    public final void bL(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(6771);
      if (bo.isNullOrNil(paramString))
      {
        ab.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
        AppMethodBeat.o(6771);
        return;
      }
      if (this.uXg.containsKey(paramString))
      {
        if (paramBoolean)
        {
          long l1 = ((Long)this.uXg.get(paramString)).longValue();
          long l2 = bo.aoy();
          this.uXg.put(paramString, Long.valueOf(l2 - l1));
          AppMethodBeat.o(6771);
          return;
        }
        this.uXg.put(paramString, Long.valueOf(-1L));
      }
      AppMethodBeat.o(6771);
    }
  }
  
  public final class o
  {
    public int cNH;
    public boolean csk = true;
    public long iHc;
    public String uWU;
    public String url;
    
    public o() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.as
 * JD-Core Version:    0.7.0.1
 */