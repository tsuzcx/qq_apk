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
import com.tencent.mm.g.b.a.ck;
import com.tencent.mm.g.b.a.ip;
import com.tencent.mm.g.b.a.iq;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.MoreFooter;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.l;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.websearch.widget.b.a.1;
import com.tencent.mm.plugin.websearch.widget.b.a.2;
import com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
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
  implements l
{
  d CbL;
  b CbO;
  View CbS;
  LinearLayout CbT;
  com.tencent.mm.plugin.websearch.api.c CbU;
  String CbV;
  String CbW;
  View CbX;
  private com.tencent.mm.plugin.websearch.widget.view.footer.a CbY;
  LinearLayout CbZ;
  MoreFooter Cca;
  float[] Ccb;
  int Ccc;
  com.tencent.mm.plugin.websearch.api.f Ccd;
  a Cce;
  WidgetData Ccf;
  private WidgetData Ccg;
  ThreeDotsLoadingView Cch;
  View Cci;
  View Ccj;
  private com.tencent.mm.plugin.websearch.widget.view.footer.a.a Cck;
  View.OnClickListener Ccl;
  MMActivity activity;
  ViewGroup fWU;
  volatile boolean isLoading;
  boolean isRetry;
  boolean isSelected;
  View rKi;
  boolean tdc;
  View view;
  TextView wGo;
  
  public b()
  {
    AppMethodBeat.i(116713);
    this.Ccb = new float[2];
    this.Cck = new com.tencent.mm.plugin.websearch.widget.view.footer.a.a()
    {
      public final void eyj()
      {
        AppMethodBeat.i(116689);
        List localList = b.this.Cce.eya();
        if ((localList == null) || (localList.isEmpty()) || (localList.size() == 1))
        {
          AppMethodBeat.o(116689);
          return;
        }
        com.tencent.mm.plugin.websearch.widget.f.a(1, b.this.Ccf, null);
        b.this.Ccc = ((com.tencent.mm.plugin.websearch.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.e.class)).a(b.this.activity, ai.getContext().getString(2131763084), "", localList, new w()
        {
          public final void iD(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            if (paramAnonymous2Int2 != b.this.Ccc) {}
          }
        });
        AppMethodBeat.o(116689);
      }
      
      public final void eyk()
      {
        AppMethodBeat.i(116690);
        b.this.Ccd.exe();
        AppMethodBeat.o(116690);
      }
      
      public final void eyl()
      {
        AppMethodBeat.i(116691);
        b.this.Ccd.exf();
        AppMethodBeat.o(116691);
      }
      
      public final int getItemCount()
      {
        AppMethodBeat.i(116694);
        int i = b.this.Cce.exZ();
        AppMethodBeat.o(116694);
        return i;
      }
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(116692);
        boolean bool = b.this.Cce.hasNext();
        AppMethodBeat.o(116692);
        return bool;
      }
      
      public final boolean hasPrevious()
      {
        AppMethodBeat.i(116693);
        boolean bool = b.this.Cce.eyb();
        AppMethodBeat.o(116693);
        return bool;
      }
    };
    this.Ccl = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116695);
        if (b.this.Ccf.BZR != null)
        {
          b.this.ab(b.this.Ccf.BZR.Cae, b.this.Ccf.BZR.Cad, b.this.Ccf.BZS.BZZ);
          b.this.nt(true);
        }
        AppMethodBeat.o(116695);
      }
    };
    AppMethodBeat.o(116713);
  }
  
  private static void aY(Map<String, String> paramMap)
  {
    AppMethodBeat.i(116726);
    cpk localcpk = new cpk();
    localcpk.FCf = aZ(paramMap);
    com.tencent.mm.ak.x.a(new v(localcpk).hEg, null);
    AppMethodBeat.o(116726);
  }
  
  private static String aZ(Map<String, String> paramMap)
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
  
  private void dFp()
  {
    AppMethodBeat.i(116719);
    switch (this.Ccf.BZU)
    {
    default: 
      ac.w("WidgetView", "unknown footer type %d", new Object[] { Integer.valueOf(this.Ccf.BZU) });
      AppMethodBeat.o(116719);
      return;
    case 2: 
      this.CbZ.setVisibility(8);
      this.Cca.setVisibility(0);
      eye();
      AppMethodBeat.o(116719);
      return;
    }
    this.Cca.setVisibility(8);
    this.CbZ.setVisibility(0);
    eyf();
    AppMethodBeat.o(116719);
  }
  
  private void e(WidgetData paramWidgetData)
  {
    AppMethodBeat.i(116717);
    if (paramWidgetData != null)
    {
      this.isLoading = true;
      this.Cci.setVisibility(8);
      this.Cch.fuX();
      this.CbT.removeView(this.Cch);
      this.Ccg = paramWidgetData;
      this.CbS.setVisibility(8);
      this.CbT.setVisibility(0);
      this.CbU.aAq(this.CbV);
      this.Ccf = paramWidgetData;
      this.CbV = ("widgetid_" + System.currentTimeMillis());
      this.CbU.a(paramWidgetData, this.CbV, ((i)com.tencent.mm.kernel.g.ab(i.class)).ewU(), 47);
      cL();
      ac.v("WidgetView", "%s, last %s, cur %s", new Object[] { toString(), this.Ccg.toString(), this.Ccf.toString() });
    }
    AppMethodBeat.o(116717);
  }
  
  private void eye()
  {
    AppMethodBeat.i(116720);
    if (this.Ccf.BZR != null)
    {
      this.Cca.setTitle(this.Ccf.BZR.title);
      AppMethodBeat.o(116720);
      return;
    }
    this.Cca.setVisibility(8);
    ac.e("WidgetView", "more footer has empty title");
    AppMethodBeat.o(116720);
  }
  
  private void eyf()
  {
    AppMethodBeat.i(116721);
    Object localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.a.geG;
    localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.tJ("100443");
    if (localObject == null)
    {
      ac.i("WidgetView", "openSearchPreload item is null");
      AppMethodBeat.o(116721);
      return;
    }
    int i = 3;
    if (((com.tencent.mm.storage.c)localObject).isValid()) {
      i = bs.aLy((String)((com.tencent.mm.storage.c)localObject).eYV().get("switchType"));
    }
    switch (i)
    {
    default: 
      if (!(this.CbY instanceof DownArrowSwitchFooter))
      {
        this.CbZ.removeView((View)this.CbY);
        this.CbY = new DownArrowSwitchFooter(this.CbZ.getContext());
        this.CbZ.addView((View)this.CbY);
      }
      break;
    }
    for (;;)
    {
      this.CbY.setCallback(this.Cck);
      this.CbY.setTitle(eyh());
      this.CbY.setIcon(this.Ccf.BZS.iconUrl);
      AppMethodBeat.o(116721);
      return;
      if (!(this.CbY instanceof BtnSwitchFooter))
      {
        this.CbZ.removeView((View)this.CbY);
        this.CbY = new BtnSwitchFooter(this.CbZ.getContext());
        this.CbZ.addView((View)this.CbY);
        continue;
        if (!(this.CbY instanceof DirectionSwitchFooter))
        {
          this.CbZ.removeView((View)this.CbY);
          this.CbY = new DirectionSwitchFooter(this.CbZ.getContext());
          this.CbZ.addView((View)this.CbY);
        }
      }
    }
  }
  
  private String eyg()
  {
    AppMethodBeat.i(116722);
    if (!TextUtils.isEmpty(this.Ccf.BZS.Cac))
    {
      str = this.Ccf.BZS.Cac;
      AppMethodBeat.o(116722);
      return str;
    }
    String str = ai.getContext().getString(2131763087);
    AppMethodBeat.o(116722);
    return str;
  }
  
  private String eyh()
  {
    AppMethodBeat.i(116723);
    if (!TextUtils.isEmpty(this.Ccf.BZS.footerWording))
    {
      str = this.Ccf.BZS.footerWording;
      AppMethodBeat.o(116723);
      return str;
    }
    String str = ai.getContext().getString(2131763085, new Object[] { this.Ccf.BZS.bLs });
    AppMethodBeat.o(116723);
    return str;
  }
  
  private void eyi()
  {
    AppMethodBeat.i(116725);
    ac.i("WidgetView", "exposure");
    String str1 = String.format("262144:%s:%d:%s;", new Object[] { this.Ccf.BZS.sxK, Long.valueOf(System.currentTimeMillis() / 1000L), this.Ccf.BZS.Caa });
    String str2 = this.Ccf.BZS.cFI + ";";
    String str3 = "262144:" + this.Ccf.BZS.cFI + ";";
    HashMap localHashMap = new HashMap();
    localHashMap.put("isexpose", "1");
    localHashMap.put("content", str1);
    localHashMap.put("searchid", this.Ccf.BZS.jKB);
    localHashMap.put("scene", "47");
    localHashMap.put("query", this.Ccf.query);
    localHashMap.put("sessionid", this.Ccf.BZV);
    localHashMap.put("resulttype", str3);
    localHashMap.put("resultsubtypelist", str2);
    localHashMap.put("ishomepage", "1");
    localHashMap.put("height", this.CbT.getHeight() + ";");
    localHashMap.put("requestid", System.currentTimeMillis());
    aY(localHashMap);
    new iq().pI(str1).pL(this.Ccf.query).pN(str2).pM(str3).pJ(this.Ccf.BZS.jKB).pK(this.Ccf.BZV).Tg().aHZ();
    AppMethodBeat.o(116725);
  }
  
  final void ab(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(116714);
    if (this.Ccf == null)
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
    paramString1 = String.format("1:%s:%d:%s:%s:%s:%s:%d:%s", new Object[] { "", Long.valueOf(System.currentTimeMillis()), this.Ccf.BZS.Caa, "isWidget=1", this.CbV, this.Ccf.BZS.hsk, Integer.valueOf(this.Ccf.BZS.cFI), Integer.valueOf(0) });
    ((AppBrandStatObject)localObject2).cYP = (this.Ccf.BZV + "::" + this.Ccf.BZS.jKB + ":" + this.Ccf.BZS.sxK + ":1:" + paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramString1 = this.Ccf.BZS.cYQ;
      if (!TextUtils.isEmpty(paramString2)) {
        break label502;
      }
      paramString2 = this.Ccf.BZS.userName;
      label341:
      localObject1 = (n)com.tencent.mm.kernel.g.ab(n.class);
      localObject3 = ai.getContext();
      if (paramInt != -1) {
        break label505;
      }
      paramInt = this.Ccf.BZS.BZZ;
    }
    label502:
    label505:
    for (;;)
    {
      ((n)localObject1).a((Context)localObject3, paramString2, null, paramInt, this.Ccf.BZS.version, paramString1, (AppBrandStatObject)localObject2);
      localObject1 = this.Ccf;
      localObject2 = new ck();
      ((ck)localObject2).dOI = 1L;
      paramString1 = ((ck)localObject2).ku(paramString1).kt(((WidgetData)localObject1).query).QN().kr(((WidgetData)localObject1).BZS.jKB);
      paramString1.dOL = ((WidgetData)localObject1).BZS.cFI;
      paramString1 = paramString1.ks(((WidgetData)localObject1).BZV);
      paramString1.dOK = paramString1.t("WeappUsrname", paramString2, true);
      paramString1.aHZ();
      AppMethodBeat.o(116714);
      return;
      paramString1 = (String)localObject1;
      break;
      break label341;
    }
  }
  
  final void cL()
  {
    AppMethodBeat.i(116718);
    if (this.Ccf == null)
    {
      AppMethodBeat.o(116718);
      return;
    }
    if (this.Ccf.BZS.rVS)
    {
      this.CbX.setVisibility(0);
      this.rKi.setVisibility(0);
      dFp();
    }
    for (;;)
    {
      this.wGo.setText(eyg());
      AppMethodBeat.o(116718);
      return;
      this.CbX.setVisibility(8);
      this.rKi.setVisibility(8);
    }
  }
  
  final void eyc()
  {
    AppMethodBeat.i(116715);
    if (this.view == null)
    {
      AppMethodBeat.o(116715);
      return;
    }
    boolean bool = this.tdc;
    if (this.view.getVisibility() != 0)
    {
      this.tdc = false;
      AppMethodBeat.o(116715);
      return;
    }
    int[] arrayOfInt = new int[2];
    this.view.getLocationOnScreen(arrayOfInt);
    if ((this.CbL != null) && (this.CbL.exd())) {}
    for (this.tdc = true;; this.tdc = false)
    {
      if ((bool != this.tdc) && (this.tdc)) {
        eyi();
      }
      AppMethodBeat.o(116715);
      return;
    }
  }
  
  final void eyd()
  {
    AppMethodBeat.i(116716);
    if ((this.fWU == null) || (this.Ccg == this.Ccf))
    {
      ac.v("WidgetView", "%s same widgetData", new Object[] { toString() });
      AppMethodBeat.o(116716);
      return;
    }
    this.CbS.setVisibility(8);
    this.CbT.setVisibility(0);
    e(this.Ccf);
    AppMethodBeat.o(116716);
  }
  
  public final void nt(boolean paramBoolean)
  {
    AppMethodBeat.i(116728);
    ac.i("WidgetView", "report click");
    HashMap localHashMap = new HashMap();
    localHashMap.put("content", String.format("262144:%s:%d:%s", new Object[] { this.Ccf.BZS.sxK, Long.valueOf(System.currentTimeMillis() / 1000L), this.Ccf.BZS.Caa }));
    localHashMap.put("searchid", this.Ccf.BZS.jKB);
    localHashMap.put("scene", "47");
    localHashMap.put("query", this.Ccf.query);
    localHashMap.put("sessionid", this.Ccf.BZV);
    localHashMap.put("docid", this.Ccf.BZS.sxK);
    localHashMap.put("timestamp", System.currentTimeMillis() / 1000L);
    localHashMap.put("jumpurl", this.Ccf.BZS.cYQ);
    String str1 = this.Ccf.BZS.Caa;
    String str2 = System.currentTimeMillis();
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localHashMap.put("expand2", String.format("{\"statBuffer\":\"%s\";\"adBuffer\":\"\";\"clickId\":%s;\"isMore\":%s}", new Object[] { str1, str2, localObject }));
      localHashMap.put("businesstype", "262144");
      localHashMap.put("h5version", z.Ul(0));
      localHashMap.put("resulttype", "262144");
      localHashMap.put("resultsubtype", this.Ccf.BZS.cFI);
      aY(localHashMap);
      localObject = new ip();
      ((ip)localObject).elo = bs.aLy((String)localHashMap.get("businesstype"));
      ((ip)localObject).elp = ((ip)localObject).t("docid", (String)localHashMap.get("docid"), true);
      ((ip)localObject).elr = ((ip)localObject).t("expand2", (String)localHashMap.get("expand2"), true);
      ((ip)localObject).dSz = ((ip)localObject).t("query", (String)localHashMap.get("query"), true);
      ((ip)localObject).els = bs.aLy((String)localHashMap.get("resultsubtype"));
      ((ip)localObject).elq = System.currentTimeMillis();
      ((ip)localObject).eln = ((ip)localObject).t("searchid", this.Ccf.BZS.jKB, true);
      ((ip)localObject).dDw = ((ip)localObject).t("sessionid", this.Ccf.BZV, true);
      ((ip)localObject).dHR = 47L;
      ((ip)localObject).aHZ();
      AppMethodBeat.o(116728);
      return;
    }
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(116724);
    ac.v("WidgetView", "%s selected %b", new Object[] { toString(), Boolean.valueOf(paramBoolean) });
    this.isSelected = paramBoolean;
    if (this.isSelected)
    {
      eyd();
      eyc();
      AppMethodBeat.o(116724);
      return;
    }
    this.tdc = false;
    AppMethodBeat.o(116724);
  }
  
  public static abstract interface a
  {
    public abstract int exZ();
    
    public abstract List<com.tencent.mm.plugin.websearch.api.x> eya();
    
    public abstract boolean eyb();
    
    public abstract boolean hasNext();
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b
 * JD-Core Version:    0.7.0.1
 */