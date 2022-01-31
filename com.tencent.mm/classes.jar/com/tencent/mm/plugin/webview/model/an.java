package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class an
{
  private static int rgw = 0;
  private static int rgx = 0;
  public an.n rgi;
  public an.l rgj;
  public an.m rgk;
  public an.k rgl;
  private an.a rgm;
  public an.g rgn;
  public an.c rgo;
  public an.h rgp;
  public an.e rgq;
  private an.f rgr;
  private an.j rgs;
  private an.i rgt;
  private an.d rgu;
  public an.b rgv;
  
  public static void M(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (rgw = 1; paramBoolean2; rgw = 0)
    {
      rgx = 1;
      return;
    }
    rgx = 0;
  }
  
  public static int ccb()
  {
    switch (aq.getNetType(ae.getContext()))
    {
    case 9: 
    default: 
      return 6;
    case -1: 
      return 255;
    case 0: 
      return 1;
    case 3: 
    case 4: 
      return 4;
    case 2: 
    case 5: 
    case 7: 
      return 2;
    case 1: 
    case 6: 
    case 8: 
      return 3;
    }
    return 5;
  }
  
  public static String ccc()
  {
    Object localObject = (ConnectivityManager)ae.getContext().getSystemService("connectivity");
    if (localObject == null) {
      return "no";
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null) {
      return "no";
    }
    if (((NetworkInfo)localObject).getType() == 1) {
      return "WIFI";
    }
    y.d("MicroMsg.WebviewReporter", "activeNetInfo extra=%s, type=%d, %s", new Object[] { ((NetworkInfo)localObject).getExtraInfo(), Integer.valueOf(((NetworkInfo)localObject).getType()), ((NetworkInfo)localObject).getExtraInfo() });
    if (((NetworkInfo)localObject).getExtraInfo() != null) {
      return ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
    }
    return "no";
  }
  
  /* Error */
  public final void St(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 159	com/tencent/mm/plugin/webview/model/an:rgv	Lcom/tencent/mm/plugin/webview/model/an$b;
    //   4: ifnull +39 -> 43
    //   7: aload_0
    //   8: getfield 159	com/tencent/mm/plugin/webview/model/an:rgv	Lcom/tencent/mm/plugin/webview/model/an$b;
    //   11: astore_3
    //   12: aload_3
    //   13: getfield 163	com/tencent/mm/plugin/webview/model/an$b:kke	Landroid/os/Bundle;
    //   16: aload_1
    //   17: invokevirtual 168	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   20: istore_2
    //   21: iload_2
    //   22: ifeq +22 -> 44
    //   25: aload_3
    //   26: aload_1
    //   27: aload_3
    //   28: getfield 163	com/tencent/mm/plugin/webview/model/an$b:kke	Landroid/os/Bundle;
    //   31: aload_1
    //   32: invokevirtual 172	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   35: iconst_1
    //   36: iadd
    //   37: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: invokevirtual 176	com/tencent/mm/plugin/webview/model/an$b:putValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   43: return
    //   44: aload_3
    //   45: aload_1
    //   46: iconst_1
    //   47: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: invokevirtual 176	com/tencent/mm/plugin/webview/model/an$b:putValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   53: return
    //   54: astore_1
    //   55: return
    //   56: astore_1
    //   57: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	an
    //   0	58	1	paramString	String
    //   20	2	2	bool	boolean
    //   11	34	3	localb	an.b
    // Exception table:
    //   from	to	target	type
    //   7	21	54	java/lang/Exception
    //   44	53	54	java/lang/Exception
    //   25	43	56	java/lang/Exception
  }
  
  public final void c(d paramd)
  {
    Object localObject4 = ccf();
    Object localObject5;
    Object localObject1;
    if (paramd != null)
    {
      i = ccb();
      localObject5 = ((an.m)localObject4).rgT.entrySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject1 = (Map.Entry)((Iterator)localObject5).next();
        localObject3 = (String)((Map.Entry)localObject1).getKey();
        l1 = ((Long)((Map.Entry)localObject1).getValue()).longValue();
        h.nFQ.a(32L, 0L, 1L, true);
        if ((l1 >= 0L) && (l1 <= 180000L))
        {
          localObject6 = ((an.m)localObject4).rgH;
          if (localObject3 == null) {}
          for (localObject1 = localObject3;; localObject1 = ((String)localObject3).replace(",", "!"))
          {
            a(paramd, (String)localObject6, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Integer.valueOf(i), localObject1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(rgw), Integer.valueOf(rgx), Integer.valueOf(((an.m)localObject4).cfb), ((an.m)localObject4).rgH });
            h.nFQ.a(160L, 0L, 1L, false);
            if (-1 != com.tencent.mm.plugin.webview.ui.tools.a.gS(l1)) {
              h.nFQ.a(160L, com.tencent.mm.plugin.webview.ui.tools.a.gS(l1), 1L, false);
            }
            h.nFQ.a(32L, 3L, 1L, true);
            h.nFQ.a(32L, 7L, l1, true);
            if (rgx == 1)
            {
              h.nFQ.a(32L, 16L, 1L, true);
              h.nFQ.a(32L, 17L, l1, true);
            }
            y.i("MicroMsg.WebviewReporter", "WebviewOpenUrlReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { localObject3, Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(rgw), Integer.valueOf(rgx), Integer.valueOf(((an.m)localObject4).cfb), ((an.m)localObject4).rgH });
            break;
          }
        }
      }
    }
    Object localObject6 = cch();
    if (!bk.bl(((an.k)localObject6).rgK)) {
      y.d("MicroMsg.WebviewReporter", "WebViewVisitReporter report viewID = %s", new Object[] { ((an.k)localObject6).rgK });
    }
    if (paramd != null) {
      localObject1 = "";
    }
    try
    {
      localObject3 = paramd.f(23, new Bundle(0));
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
        y.w("MicroMsg.WebviewReporter", "invokeAsResult error, %s", new Object[] { localRemoteException });
        localObject2 = "";
      }
    }
    localPString = new PString();
    str2 = ((i)g.r(i.class)).a(((an.k)localObject6).oPO, localPString);
    y.d("MicroMsg.WebviewReporter", "report 10643(%s), username : %s, msgId : %s, msgIndex : %s, scene : %s, enterTime : %s, stayTime : %s, rawUrl : %s, publisher : %s, viewId : %s, publishId : %s,appId : %s, newMsgId : %s, preUsername : %s, curUsername : %s, referUrl : %s, statExtStr:%s(%s), chatType:%d, title:%s, expidstr[chatting_exp]:%s, sourceAppId:%s, allStayTime %d", new Object[] { Integer.valueOf(10643), ((an.k)localObject6).username, Long.valueOf(((an.k)localObject6).rgL), Integer.valueOf(((an.k)localObject6).rgM), Integer.valueOf(((an.k)localObject6).scene), Long.valueOf(((an.k)localObject6).diQ), Long.valueOf(((an.k)localObject6).gYS), ((an.k)localObject6).caS, ((an.k)localObject6).rgJ, ((an.k)localObject6).rgK, ((an.k)localObject6).pDx, ((an.k)localObject6).appId, ((an.k)localObject6).rgN, ((an.k)localObject6).rgO, localObject1, ((an.k)localObject6).rgP, ((an.k)localObject6).oPO, str2, Integer.valueOf(((an.k)localObject6).rgQ), ((an.k)localObject6).title, ((an.k)localObject6).cQO, localPString.value, Long.valueOf(System.currentTimeMillis() - ((an.k)localObject6).diQ) });
    Object localObject3 = ((an.k)localObject6).title;
    try
    {
      localObject4 = URLEncoder.encode(((an.k)localObject6).title, "UTF-8");
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
        y.printErrStackTrace("MicroMsg.WebviewReporter", localException2, "", new Object[0]);
        continue;
        String str1 = ((an.k)localObject6).caS.replace(",", "!");
        continue;
        localObject5 = ((an.k)localObject6).rgP.replace(",", "!");
        continue;
        Object localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("iswebviewreadtime=1");
        ((StringBuffer)localObject2).append("&publishid=");
        ((StringBuffer)localObject2).append(((an.a)localObject3).pDx);
        ((StringBuffer)localObject2).append("&staytime=");
        ((StringBuffer)localObject2).append(((an.a)localObject3).gYS);
        ((StringBuffer)localObject2).append("&allstaytime=");
        ((StringBuffer)localObject2).append(System.currentTimeMillis() - ((an.a)localObject3).diQ);
        ((StringBuffer)localObject2).append("&maxscrolly=");
        ((StringBuffer)localObject2).append(((an.a)localObject3).rgy);
        ((StringBuffer)localObject2).append("&totalscrolly=");
        ((StringBuffer)localObject2).append(((an.a)localObject3).piC);
        ((StringBuffer)localObject2).append("&scene=");
        ((StringBuffer)localObject2).append(((an.a)localObject3).scene);
        ((StringBuffer)localObject2).append("&entertime=");
        ((StringBuffer)localObject2).append(((an.a)localObject3).diQ);
        ((StringBuffer)localObject2).append("&screenheight=");
        ((StringBuffer)localObject2).append(com.tencent.mm.cb.a.fk(ae.getContext()));
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("reportString", ((StringBuffer)localObject2).toString());
        try
        {
          paramd.i(6, (Bundle)localObject3);
        }
        catch (Exception localException1)
        {
          y.printErrStackTrace("MicroMsg.WebviewReporter", localException1, "TopStory report", new Object[0]);
        }
      }
      e.a(paramd, 11575, new Object[] { localException1.caS, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(i) });
      return;
    }
    str3 = ((an.k)localObject6).username;
    long l1 = ((an.k)localObject6).rgL;
    int i = ((an.k)localObject6).rgM;
    j = ((an.k)localObject6).scene;
    l2 = ((an.k)localObject6).diQ;
    l3 = ((an.k)localObject6).gYS;
    if (((an.k)localObject6).caS == null)
    {
      localObject4 = ((an.k)localObject6).caS;
      str4 = ((an.k)localObject6).rgJ;
      str5 = ((an.k)localObject6).rgK;
      str6 = ((an.k)localObject6).pDx;
      str7 = ((an.k)localObject6).appId;
      str8 = ((an.k)localObject6).rgN;
      str9 = ((an.k)localObject6).rgO;
      if (((an.k)localObject6).rgP != null) {
        break label1290;
      }
      localObject5 = ((an.k)localObject6).rgP;
      e.a(paramd, 10643, new Object[] { str3, Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l2), Long.valueOf(l3), localObject4, str4, str5, str6, str7, str8, str9, localObject1, localObject5, str2, Integer.valueOf(((an.k)localObject6).rgQ), localObject3, ((an.k)localObject6).cQO, localPString.value, "", "", "", Long.valueOf(System.currentTimeMillis() - ((an.k)localObject6).diQ), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(((an.k)localObject6).rgR) });
      localObject3 = cci();
      if ((!bk.bl(((an.a)localObject3).pDx)) && (((an.a)localObject3).pDx.startsWith("wrd"))) {
        break label1309;
      }
      cce().c(paramd);
      ccg().c(paramd);
      localObject1 = cck();
      if (paramd != null)
      {
        i = ccb();
        if (!((an.c)localObject1).rgB) {
          break label1587;
        }
        if (!((an.c)localObject1).loadFinished) {
          break label1546;
        }
        e.a(paramd, 11575, new Object[] { ((an.c)localObject1).caS, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i) });
      }
    }
    label1290:
    label1309:
    label1587:
    e.a(paramd, 11575, new Object[] { localException1.caS, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(i) });
    label1546:
  }
  
  public final an.n ccd()
  {
    if (this.rgi == null) {
      this.rgi = new an.n(this);
    }
    return this.rgi;
  }
  
  public final an.l cce()
  {
    if (this.rgj == null) {
      this.rgj = new an.l(this);
    }
    return this.rgj;
  }
  
  public final an.m ccf()
  {
    if (this.rgk == null) {
      this.rgk = new an.m(this);
    }
    return this.rgk;
  }
  
  public final an.f ccg()
  {
    if (this.rgr == null) {
      this.rgr = new an.f(this);
    }
    return this.rgr;
  }
  
  public final an.k cch()
  {
    if (this.rgl == null) {
      this.rgl = new an.k();
    }
    return this.rgl;
  }
  
  public final an.a cci()
  {
    if (this.rgm == null) {
      this.rgm = new an.a();
    }
    return this.rgm;
  }
  
  public final an.g ccj()
  {
    if (this.rgn == null) {
      this.rgn = new an.g(this);
    }
    return this.rgn;
  }
  
  public final an.c cck()
  {
    if (this.rgo == null) {
      this.rgo = new an.c();
    }
    return this.rgo;
  }
  
  public final an.h ccl()
  {
    if (this.rgp == null) {
      this.rgp = new an.h();
    }
    return this.rgp;
  }
  
  public final an.e ccm()
  {
    if (this.rgq == null) {
      this.rgq = new an.e();
    }
    return this.rgq;
  }
  
  public final an.j ccn()
  {
    if (this.rgs == null) {
      this.rgs = new an.j();
    }
    return this.rgs;
  }
  
  public final an.i cco()
  {
    if (this.rgt == null) {
      this.rgt = new an.i();
    }
    return this.rgt;
  }
  
  public final an.d ccp()
  {
    if (this.rgu == null) {
      this.rgu = new an.d();
    }
    return this.rgu;
  }
  
  public final void n(String paramString, Object paramObject)
  {
    if (this.rgv != null) {}
    try
    {
      this.rgv.putValue(paramString, paramObject);
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.an
 * JD-Core Version:    0.7.0.1
 */