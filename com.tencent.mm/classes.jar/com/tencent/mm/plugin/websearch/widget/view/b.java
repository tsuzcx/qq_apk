package com.tencent.mm.plugin.websearch.widget.view;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ay;
import com.tencent.mm.g.b.a.gx;
import com.tencent.mm.g.b.a.gy;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.MoreFooter;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.websearch.widget.b.a.1;
import com.tencent.mm.plugin.websearch.widget.b.a.2;
import com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  implements m
{
  View AJB;
  LinearLayout AJC;
  com.tencent.mm.plugin.websearch.api.c AJD;
  String AJE;
  String AJF;
  View AJG;
  private com.tencent.mm.plugin.websearch.widget.view.footer.a AJH;
  LinearLayout AJI;
  MoreFooter AJJ;
  float[] AJK;
  int AJL;
  com.tencent.mm.plugin.websearch.api.f AJM;
  a AJN;
  WidgetData AJO;
  private WidgetData AJP;
  ThreeDotsLoadingView AJQ;
  View AJR;
  View AJS;
  private com.tencent.mm.plugin.websearch.widget.view.footer.a.a AJT;
  View.OnClickListener AJU;
  d AJu;
  b AJx;
  MMActivity activity;
  ViewGroup fSZ;
  boolean ira;
  volatile boolean isLoading;
  boolean isRetry;
  View qOZ;
  boolean rVk;
  View view;
  TextView vwj;
  
  public b()
  {
    AppMethodBeat.i(116713);
    this.AJK = new float[2];
    this.AJT = new com.tencent.mm.plugin.websearch.widget.view.footer.a.a()
    {
      public final void eiP()
      {
        AppMethodBeat.i(116689);
        List localList = b.this.AJN.eiG();
        if ((localList == null) || (localList.isEmpty()) || (localList.size() == 1))
        {
          AppMethodBeat.o(116689);
          return;
        }
        com.tencent.mm.plugin.websearch.widget.f.a(1, b.this.AJO, null);
        b.this.AJL = ((com.tencent.mm.plugin.websearch.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.e.class)).a(b.this.activity, aj.getContext().getString(2131763084), "", localList, new com.tencent.mm.plugin.websearch.api.x()
        {
          public final void io(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            if (paramAnonymous2Int2 != b.this.AJL) {}
          }
        });
        AppMethodBeat.o(116689);
      }
      
      public final void eiQ()
      {
        AppMethodBeat.i(116690);
        b.this.AJM.ehK();
        AppMethodBeat.o(116690);
      }
      
      public final void eiR()
      {
        AppMethodBeat.i(116691);
        b.this.AJM.ehL();
        AppMethodBeat.o(116691);
      }
      
      public final int getItemCount()
      {
        AppMethodBeat.i(116694);
        int i = b.this.AJN.eiF();
        AppMethodBeat.o(116694);
        return i;
      }
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(116692);
        boolean bool = b.this.AJN.hasNext();
        AppMethodBeat.o(116692);
        return bool;
      }
      
      public final boolean hasPrevious()
      {
        AppMethodBeat.i(116693);
        boolean bool = b.this.AJN.eiH();
        AppMethodBeat.o(116693);
        return bool;
      }
    };
    this.AJU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116695);
        if (b.this.AJO.AHA != null)
        {
          b.this.aa(b.this.AJO.AHA.AHN, b.this.AJO.AHA.AHM, b.this.AJO.AHB.AHI);
          b.this.mA(true);
        }
        AppMethodBeat.o(116695);
      }
    };
    AppMethodBeat.o(116713);
  }
  
  private static void aU(Map<String, String> paramMap)
  {
    AppMethodBeat.i(116726);
    ckd localckd = new ckd();
    localckd.Eff = aV(paramMap);
    com.tencent.mm.al.x.a(new w(localckd).hdD, null);
    AppMethodBeat.o(116726);
  }
  
  private static String aV(Map<String, String> paramMap)
  {
    AppMethodBeat.i(116727);
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append((String)localEntry.getKey()).append("=").append(URLEncoder.encode((String)localEntry.getValue())).append("&");
    }
    paramMap = localStringBuilder.toString();
    AppMethodBeat.o(116727);
    return paramMap;
  }
  
  private void drg()
  {
    AppMethodBeat.i(116719);
    switch (this.AJO.AHD)
    {
    default: 
      ad.w("WidgetView", "unknown footer type %d", new Object[] { Integer.valueOf(this.AJO.AHD) });
      AppMethodBeat.o(116719);
      return;
    case 2: 
      this.AJI.setVisibility(8);
      this.AJJ.setVisibility(0);
      eiK();
      AppMethodBeat.o(116719);
      return;
    }
    this.AJJ.setVisibility(8);
    this.AJI.setVisibility(0);
    eiL();
    AppMethodBeat.o(116719);
  }
  
  private void e(WidgetData paramWidgetData)
  {
    AppMethodBeat.i(116717);
    if (paramWidgetData != null)
    {
      this.isLoading = true;
      this.AJR.setVisibility(8);
      this.AJQ.ffc();
      this.AJC.removeView(this.AJQ);
      this.AJP = paramWidgetData;
      this.AJB.setVisibility(8);
      this.AJC.setVisibility(0);
      this.AJD.auZ(this.AJE);
      this.AJO = paramWidgetData;
      this.AJE = ("widgetid_" + System.currentTimeMillis());
      this.AJD.a(paramWidgetData, this.AJE, ((j)com.tencent.mm.kernel.g.ab(j.class)).ehA(), 47);
      cE();
      ad.v("WidgetView", "%s, last %s, cur %s", new Object[] { toString(), this.AJP.toString(), this.AJO.toString() });
    }
    AppMethodBeat.o(116717);
  }
  
  private void eiK()
  {
    AppMethodBeat.i(116720);
    if (this.AJO.AHA != null)
    {
      this.AJJ.setTitle(this.AJO.AHA.title);
      AppMethodBeat.o(116720);
      return;
    }
    this.AJJ.setVisibility(8);
    ad.e("WidgetView", "more footer has empty title");
    AppMethodBeat.o(116720);
  }
  
  private void eiL()
  {
    AppMethodBeat.i(116721);
    Object localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.a.gaa;
    localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.qu("100443");
    if (localObject == null)
    {
      ad.i("WidgetView", "openSearchPreload item is null");
      AppMethodBeat.o(116721);
      return;
    }
    int i = 3;
    if (((com.tencent.mm.storage.c)localObject).isValid()) {
      i = bt.aGh((String)((com.tencent.mm.storage.c)localObject).eJy().get("switchType"));
    }
    switch (i)
    {
    default: 
      if (!(this.AJH instanceof DownArrowSwitchFooter))
      {
        this.AJI.removeView((View)this.AJH);
        this.AJH = new DownArrowSwitchFooter(this.AJI.getContext());
        this.AJI.addView((View)this.AJH);
      }
      break;
    }
    for (;;)
    {
      this.AJH.setCallback(this.AJT);
      this.AJH.setTitle(eiN());
      this.AJH.setIcon(this.AJO.AHB.iconUrl);
      AppMethodBeat.o(116721);
      return;
      if (!(this.AJH instanceof BtnSwitchFooter))
      {
        this.AJI.removeView((View)this.AJH);
        this.AJH = new BtnSwitchFooter(this.AJI.getContext());
        this.AJI.addView((View)this.AJH);
        continue;
        if (!(this.AJH instanceof DirectionSwitchFooter))
        {
          this.AJI.removeView((View)this.AJH);
          this.AJH = new DirectionSwitchFooter(this.AJI.getContext());
          this.AJI.addView((View)this.AJH);
        }
      }
    }
  }
  
  private String eiM()
  {
    AppMethodBeat.i(116722);
    if (!TextUtils.isEmpty(this.AJO.AHB.AHL))
    {
      str = this.AJO.AHB.AHL;
      AppMethodBeat.o(116722);
      return str;
    }
    String str = aj.getContext().getString(2131763087);
    AppMethodBeat.o(116722);
    return str;
  }
  
  private String eiN()
  {
    AppMethodBeat.i(116723);
    if (!TextUtils.isEmpty(this.AJO.AHB.footerWording))
    {
      str = this.AJO.AHB.footerWording;
      AppMethodBeat.o(116723);
      return str;
    }
    String str = aj.getContext().getString(2131763085, new Object[] { this.AJO.AHB.bNK });
    AppMethodBeat.o(116723);
    return str;
  }
  
  private void eiO()
  {
    AppMethodBeat.i(116725);
    ad.i("WidgetView", "exposure");
    String str1 = String.format("262144:%s:%d:%s;", new Object[] { this.AJO.AHB.roQ, Long.valueOf(System.currentTimeMillis() / 1000L), this.AJO.AHB.AHJ });
    String str2 = this.AJO.AHB.cIB + ";";
    String str3 = "262144:" + this.AJO.AHB.cIB + ";";
    HashMap localHashMap = new HashMap();
    localHashMap.put("isexpose", "1");
    localHashMap.put("content", str1);
    localHashMap.put("searchid", this.AJO.AHB.jko);
    localHashMap.put("scene", "47");
    localHashMap.put("query", this.AJO.query);
    localHashMap.put("sessionid", this.AJO.AHE);
    localHashMap.put("resulttype", str3);
    localHashMap.put("resultsubtypelist", str2);
    localHashMap.put("ishomepage", "1");
    localHashMap.put("height", this.AJC.getHeight() + ";");
    localHashMap.put("requestid", System.currentTimeMillis());
    aU(localHashMap);
    new gy().mC(str1).mF(this.AJO.query).mH(str2).mG(str3).mD(this.AJO.AHB.jko).mE(this.AJO.AHE).Sn().aBj();
    AppMethodBeat.o(116725);
  }
  
  final void aa(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(116714);
    if (this.AJO == null)
    {
      AppMethodBeat.o(116714);
      return;
    }
    Object localObject1 = paramString1;
    Object localObject3;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject2 = Uri.parse(paramString1);
      localObject3 = ((Uri)localObject2).getPath();
      localObject1 = paramString1;
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject1 = paramString1;
        if (!((String)localObject3).endsWith(".html"))
        {
          paramString1 = (String)localObject3 + ".html";
          localObject1 = ((Uri)localObject2).buildUpon().path(paramString1).build().toString();
        }
      }
    }
    u.i("WidgetView", "open app with path %s", new Object[] { localObject1 });
    Object localObject2 = new AppBrandStatObject();
    ((AppBrandStatObject)localObject2).scene = 1108;
    paramString1 = String.format("1:%s:%d:%s:%s:%s:%s:%d:%s", new Object[] { "", Long.valueOf(System.currentTimeMillis()), this.AJO.AHB.AHJ, "isWidget=1", this.AJE, this.AJO.AHB.gRK, Integer.valueOf(this.AJO.AHB.cIB), Integer.valueOf(0) });
    ((AppBrandStatObject)localObject2).dbt = (this.AJO.AHE + "::" + this.AJO.AHB.jko + ":" + this.AJO.AHB.roQ + ":1:" + paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramString1 = this.AJO.AHB.dbu;
      if (!TextUtils.isEmpty(paramString2)) {
        break label502;
      }
      paramString2 = this.AJO.AHB.userName;
      label341:
      localObject1 = (com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class);
      localObject3 = aj.getContext();
      if (paramInt != -1) {
        break label505;
      }
      paramInt = this.AJO.AHB.AHI;
    }
    label502:
    label505:
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.service.n)localObject1).a((Context)localObject3, paramString2, null, paramInt, this.AJO.AHB.version, paramString1, (AppBrandStatObject)localObject2);
      localObject1 = this.AJO;
      localObject2 = new ay();
      ((ay)localObject2).dNf = 1L;
      paramString1 = ((ay)localObject2).hS(paramString1).hR(((WidgetData)localObject1).query).Ql().hP(((WidgetData)localObject1).AHB.jko);
      paramString1.dNi = ((WidgetData)localObject1).AHB.cIB;
      paramString1 = paramString1.hQ(((WidgetData)localObject1).AHE);
      paramString1.dNh = paramString1.t("WeappUsrname", paramString2, true);
      paramString1.aBj();
      AppMethodBeat.o(116714);
      return;
      paramString1 = (String)localObject1;
      break;
      break label341;
    }
  }
  
  final void cE()
  {
    AppMethodBeat.i(116718);
    if (this.AJO == null)
    {
      AppMethodBeat.o(116718);
      return;
    }
    if (this.AJO.AHB.qVF)
    {
      this.AJG.setVisibility(0);
      this.qOZ.setVisibility(0);
      drg();
    }
    for (;;)
    {
      this.vwj.setText(eiM());
      AppMethodBeat.o(116718);
      return;
      this.AJG.setVisibility(8);
      this.qOZ.setVisibility(8);
    }
  }
  
  final void eiI()
  {
    AppMethodBeat.i(116715);
    if (this.view == null)
    {
      AppMethodBeat.o(116715);
      return;
    }
    boolean bool = this.rVk;
    if (this.view.getVisibility() != 0)
    {
      this.rVk = false;
      AppMethodBeat.o(116715);
      return;
    }
    int[] arrayOfInt = new int[2];
    this.view.getLocationOnScreen(arrayOfInt);
    if ((this.AJu != null) && (this.AJu.ehJ())) {}
    for (this.rVk = true;; this.rVk = false)
    {
      if ((bool != this.rVk) && (this.rVk)) {
        eiO();
      }
      AppMethodBeat.o(116715);
      return;
    }
  }
  
  final void eiJ()
  {
    AppMethodBeat.i(116716);
    if ((this.fSZ == null) || (this.AJP == this.AJO))
    {
      ad.v("WidgetView", "%s same widgetData", new Object[] { toString() });
      AppMethodBeat.o(116716);
      return;
    }
    this.AJB.setVisibility(8);
    this.AJC.setVisibility(0);
    e(this.AJO);
    AppMethodBeat.o(116716);
  }
  
  public final void mA(boolean paramBoolean)
  {
    AppMethodBeat.i(116728);
    ad.i("WidgetView", "report click");
    HashMap localHashMap = new HashMap();
    localHashMap.put("content", String.format("262144:%s:%d:%s", new Object[] { this.AJO.AHB.roQ, Long.valueOf(System.currentTimeMillis() / 1000L), this.AJO.AHB.AHJ }));
    localHashMap.put("searchid", this.AJO.AHB.jko);
    localHashMap.put("scene", "47");
    localHashMap.put("query", this.AJO.query);
    localHashMap.put("sessionid", this.AJO.AHE);
    localHashMap.put("docid", this.AJO.AHB.roQ);
    localHashMap.put("timestamp", System.currentTimeMillis() / 1000L);
    localHashMap.put("jumpurl", this.AJO.AHB.dbu);
    String str1 = this.AJO.AHB.AHJ;
    String str2 = System.currentTimeMillis();
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localHashMap.put("expand2", String.format("{\"statBuffer\":\"%s\";\"adBuffer\":\"\";\"clickId\":%s;\"isMore\":%s}", new Object[] { str1, str2, localObject }));
      localHashMap.put("businesstype", "262144");
      localHashMap.put("h5version", aa.Sb(0));
      localHashMap.put("resulttype", "262144");
      localHashMap.put("resultsubtype", this.AJO.AHB.cIB);
      aU(localHashMap);
      localObject = new gx();
      ((gx)localObject).ejk = bt.aGh((String)localHashMap.get("businesstype"));
      ((gx)localObject).ejl = ((gx)localObject).t("docid", (String)localHashMap.get("docid"), true);
      ((gx)localObject).ejn = ((gx)localObject).t("expand2", (String)localHashMap.get("expand2"), true);
      ((gx)localObject).dQK = ((gx)localObject).t("query", (String)localHashMap.get("query"), true);
      ((gx)localObject).ejo = bt.aGh((String)localHashMap.get("resultsubtype"));
      ((gx)localObject).ejm = System.currentTimeMillis();
      ((gx)localObject).ejj = ((gx)localObject).t("searchid", this.AJO.AHB.jko, true);
      ((gx)localObject).dFJ = ((gx)localObject).t("sessionid", this.AJO.AHE, true);
      ((gx)localObject).dKc = 47L;
      ((gx)localObject).aBj();
      AppMethodBeat.o(116728);
      return;
    }
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(116724);
    ad.v("WidgetView", "%s selected %b", new Object[] { toString(), Boolean.valueOf(paramBoolean) });
    this.ira = paramBoolean;
    if (this.ira)
    {
      eiJ();
      eiI();
      AppMethodBeat.o(116724);
      return;
    }
    this.rVk = false;
    AppMethodBeat.o(116724);
  }
  
  public static abstract interface a
  {
    public abstract int eiF();
    
    public abstract List<y> eiG();
    
    public abstract boolean eiH();
    
    public abstract boolean hasNext();
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b
 * JD-Core Version:    0.7.0.1
 */