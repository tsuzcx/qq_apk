package com.tencent.mm.plugin.websearch.widget.view;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.g.b.a.fr;
import com.tencent.mm.g.b.a.nu;
import com.tencent.mm.g.b.a.nv;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.MoreFooter;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
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
  TextView CkP;
  b IIB;
  View IIF;
  LinearLayout IIG;
  d IIH;
  String III;
  String IIJ;
  View IIK;
  private com.tencent.mm.plugin.websearch.widget.view.footer.a IIL;
  LinearLayout IIM;
  MoreFooter IIN;
  float[] IIO;
  int IIP;
  com.tencent.mm.plugin.websearch.api.g IIQ;
  a IIR;
  WidgetData IIS;
  private WidgetData IIT;
  ThreeDotsLoadingView IIU;
  View IIV;
  View IIW;
  private com.tencent.mm.plugin.websearch.widget.view.footer.a.a IIX;
  View.OnClickListener IIY;
  e IIy;
  MMActivity activity;
  volatile boolean isLoading;
  boolean isRetry;
  boolean isSelected;
  ViewGroup parent;
  View uGQ;
  View view;
  boolean xEm;
  
  public b()
  {
    AppMethodBeat.i(116713);
    this.IIO = new float[2];
    this.IIX = new com.tencent.mm.plugin.websearch.widget.view.footer.a.a()
    {
      public final void fZk()
      {
        AppMethodBeat.i(116689);
        List localList = b.this.IIR.fZb();
        if ((localList == null) || (localList.isEmpty()) || (localList.size() == 1))
        {
          AppMethodBeat.o(116689);
          return;
        }
        com.tencent.mm.plugin.websearch.widget.f.a(1, b.this.IIS, null);
        b.this.IIP = ((com.tencent.mm.plugin.websearch.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.websearch.api.f.class)).a(b.this.activity, MMApplicationContext.getContext().getString(2131765244), "", localList, new ae()
        {
          public final void ka(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            if (paramAnonymous2Int2 != b.this.IIP) {}
          }
        });
        AppMethodBeat.o(116689);
      }
      
      public final void fZl()
      {
        AppMethodBeat.i(116690);
        b.this.IIQ.fXH();
        AppMethodBeat.o(116690);
      }
      
      public final void fZm()
      {
        AppMethodBeat.i(116691);
        b.this.IIQ.fXI();
        AppMethodBeat.o(116691);
      }
      
      public final int getItemCount()
      {
        AppMethodBeat.i(116694);
        int i = b.this.IIR.fZa();
        AppMethodBeat.o(116694);
        return i;
      }
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(116692);
        boolean bool = b.this.IIR.hasNext();
        AppMethodBeat.o(116692);
        return bool;
      }
      
      public final boolean hasPrevious()
      {
        AppMethodBeat.i(116693);
        boolean bool = b.this.IIR.fZc();
        AppMethodBeat.o(116693);
        return bool;
      }
    };
    this.IIY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116695);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/WidgetView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (b.this.IIS.IFF != null)
        {
          b.this.am(b.this.IIS.IFF.IFQ, b.this.IIS.IFF.IFP, b.this.IIS.IFG.nbf);
          b.this.qA(true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/WidgetView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(116695);
      }
    };
    AppMethodBeat.o(116713);
  }
  
  private static void bi(Map<String, String> paramMap)
  {
    AppMethodBeat.i(116726);
    doc localdoc = new doc();
    localdoc.MRe = bj(paramMap);
    aa.a(new ad(localdoc).iUB, null);
    AppMethodBeat.o(116726);
  }
  
  private static String bj(Map<String, String> paramMap)
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
  
  private void e(WidgetData paramWidgetData)
  {
    AppMethodBeat.i(116717);
    if (paramWidgetData != null)
    {
      this.isLoading = true;
      this.IIV.setVisibility(8);
      this.IIU.gZi();
      this.IIG.removeView(this.IIU);
      this.IIT = paramWidgetData;
      this.IIF.setVisibility(8);
      this.IIG.setVisibility(0);
      this.IIH.aWZ(this.III);
      this.IIS = paramWidgetData;
      this.III = ("widgetid_" + System.currentTimeMillis());
      this.IIH.a(paramWidgetData, this.III, ((j)com.tencent.mm.kernel.g.af(j.class)).fXx(), 47);
      updateView();
      Log.v("WidgetView", "%s, last %s, cur %s", new Object[] { toString(), this.IIT.toString(), this.IIS.toString() });
    }
    AppMethodBeat.o(116717);
  }
  
  private void eWo()
  {
    AppMethodBeat.i(116719);
    switch (this.IIS.IFI)
    {
    default: 
      Log.w("WidgetView", "unknown footer type %d", new Object[] { Integer.valueOf(this.IIS.IFI) });
      AppMethodBeat.o(116719);
      return;
    case 2: 
      this.IIM.setVisibility(8);
      this.IIN.setVisibility(0);
      fZf();
      AppMethodBeat.o(116719);
      return;
    }
    this.IIN.setVisibility(8);
    this.IIM.setVisibility(0);
    fZg();
    AppMethodBeat.o(116719);
  }
  
  private void fZf()
  {
    AppMethodBeat.i(116720);
    if (this.IIS.IFF != null)
    {
      this.IIN.setTitle(this.IIS.IFF.title);
      AppMethodBeat.o(116720);
      return;
    }
    this.IIN.setVisibility(8);
    Log.e("WidgetView", "more footer has empty title");
    AppMethodBeat.o(116720);
  }
  
  private void fZg()
  {
    AppMethodBeat.i(116721);
    Object localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.a.hnM;
    localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.Fu("100443");
    if (localObject == null)
    {
      Log.i("WidgetView", "openSearchPreload item is null");
      AppMethodBeat.o(116721);
      return;
    }
    int i = 3;
    if (((c)localObject).isValid()) {
      i = Util.safeParseInt((String)((c)localObject).gzz().get("switchType"));
    }
    switch (i)
    {
    default: 
      if (!(this.IIL instanceof DownArrowSwitchFooter))
      {
        this.IIM.removeView((View)this.IIL);
        this.IIL = new DownArrowSwitchFooter(this.IIM.getContext());
        this.IIM.addView((View)this.IIL);
      }
      break;
    }
    for (;;)
    {
      this.IIL.setCallback(this.IIX);
      this.IIL.setTitle(fZi());
      this.IIL.setIcon(this.IIS.IFG.iconUrl);
      AppMethodBeat.o(116721);
      return;
      if (!(this.IIL instanceof BtnSwitchFooter))
      {
        this.IIM.removeView((View)this.IIL);
        this.IIL = new BtnSwitchFooter(this.IIM.getContext());
        this.IIM.addView((View)this.IIL);
        continue;
        if (!(this.IIL instanceof DirectionSwitchFooter))
        {
          this.IIM.removeView((View)this.IIL);
          this.IIL = new DirectionSwitchFooter(this.IIM.getContext());
          this.IIM.addView((View)this.IIL);
        }
      }
    }
  }
  
  private String fZh()
  {
    AppMethodBeat.i(116722);
    if (!TextUtils.isEmpty(this.IIS.IFG.IFO))
    {
      str = this.IIS.IFG.IFO;
      AppMethodBeat.o(116722);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(2131765247);
    AppMethodBeat.o(116722);
    return str;
  }
  
  private String fZi()
  {
    AppMethodBeat.i(116723);
    if (!TextUtils.isEmpty(this.IIS.IFG.footerWording))
    {
      str = this.IIS.IFG.footerWording;
      AppMethodBeat.o(116723);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(2131765245, new Object[] { this.IIS.IFG.nickName });
    AppMethodBeat.o(116723);
    return str;
  }
  
  private void fZj()
  {
    AppMethodBeat.i(116725);
    Log.i("WidgetView", "exposure");
    String str1 = String.format("262144:%s:%d:%s;", new Object[] { this.IIS.IFG.wWb, Long.valueOf(System.currentTimeMillis() / 1000L), this.IIS.IFG.IFM });
    String str2 = this.IIS.IFG.serviceType + ";";
    String str3 = "262144:" + this.IIS.IFG.serviceType + ";";
    HashMap localHashMap = new HashMap();
    localHashMap.put("isexpose", "1");
    localHashMap.put("content", str1);
    localHashMap.put("searchid", this.IIS.IFG.hes);
    localHashMap.put("scene", "47");
    localHashMap.put("query", this.IIS.query);
    localHashMap.put("sessionid", this.IIS.dWw);
    localHashMap.put("resulttype", str3);
    localHashMap.put("resultsubtypelist", str2);
    localHashMap.put("ishomepage", "1");
    localHashMap.put("height", this.IIG.getHeight() + ";");
    localHashMap.put("requestid", System.currentTimeMillis());
    bi(localHashMap);
    new nv().AU(str1).AX(this.IIS.query).AZ(str2).AY(str3).AV(this.IIS.IFG.hes).AW(this.IIS.dWw).ajr().bfK();
    AppMethodBeat.o(116725);
  }
  
  final void am(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(116714);
    if (this.IIS == null)
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
    paramString1 = String.format("1:%s:%d:%s:%s:%s:%s:%d:%s", new Object[] { "", Long.valueOf(System.currentTimeMillis()), this.IIS.IFG.IFM, "isWidget=1", this.III, this.IIS.IFG.iIA, Integer.valueOf(this.IIS.IFG.serviceType), Integer.valueOf(0) });
    ((AppBrandStatObject)localObject2).dCw = (this.IIS.dWw + "::" + this.IIS.IFG.hes + ":" + this.IIS.IFG.wWb + ":1:" + paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramString1 = this.IIS.IFG.dCx;
      if (!TextUtils.isEmpty(paramString2)) {
        break label502;
      }
      paramString2 = this.IIS.IFG.userName;
      label341:
      localObject1 = (r)com.tencent.mm.kernel.g.af(r.class);
      localObject3 = MMApplicationContext.getContext();
      if (paramInt != -1) {
        break label505;
      }
      paramInt = this.IIS.IFG.nbf;
    }
    label502:
    label505:
    for (;;)
    {
      ((r)localObject1).a((Context)localObject3, paramString2, null, paramInt, this.IIS.IFG.version, paramString1, (AppBrandStatObject)localObject2);
      localObject1 = this.IIS;
      localObject2 = new fr();
      ((fr)localObject2).eGU = 1L;
      paramString1 = ((fr)localObject2).sI(paramString1).sH(((WidgetData)localObject1).query).agD().sF(((WidgetData)localObject1).IFG.hes);
      paramString1.eGX = ((WidgetData)localObject1).IFG.serviceType;
      paramString1 = paramString1.sG(((WidgetData)localObject1).dWw);
      paramString1.eGW = paramString1.x("WeappUsrname", paramString2, true);
      paramString1.bfK();
      AppMethodBeat.o(116714);
      return;
      paramString1 = (String)localObject1;
      break;
      break label341;
    }
  }
  
  final void fZd()
  {
    AppMethodBeat.i(116715);
    if (this.view == null)
    {
      AppMethodBeat.o(116715);
      return;
    }
    boolean bool = this.xEm;
    if (this.view.getVisibility() != 0)
    {
      this.xEm = false;
      AppMethodBeat.o(116715);
      return;
    }
    int[] arrayOfInt = new int[2];
    this.view.getLocationOnScreen(arrayOfInt);
    if ((this.IIy != null) && (this.IIy.fXG())) {}
    for (this.xEm = true;; this.xEm = false)
    {
      if ((bool != this.xEm) && (this.xEm)) {
        fZj();
      }
      AppMethodBeat.o(116715);
      return;
    }
  }
  
  final void fZe()
  {
    AppMethodBeat.i(116716);
    if ((this.parent == null) || (this.IIT == this.IIS))
    {
      Log.v("WidgetView", "%s same widgetData", new Object[] { toString() });
      AppMethodBeat.o(116716);
      return;
    }
    this.IIF.setVisibility(8);
    this.IIG.setVisibility(0);
    e(this.IIS);
    AppMethodBeat.o(116716);
  }
  
  public final void qA(boolean paramBoolean)
  {
    AppMethodBeat.i(116728);
    Log.i("WidgetView", "report click");
    HashMap localHashMap = new HashMap();
    localHashMap.put("content", String.format("262144:%s:%d:%s", new Object[] { this.IIS.IFG.wWb, Long.valueOf(System.currentTimeMillis() / 1000L), this.IIS.IFG.IFM }));
    localHashMap.put("searchid", this.IIS.IFG.hes);
    localHashMap.put("scene", "47");
    localHashMap.put("query", this.IIS.query);
    localHashMap.put("sessionid", this.IIS.dWw);
    localHashMap.put("docid", this.IIS.IFG.wWb);
    localHashMap.put("timestamp", System.currentTimeMillis() / 1000L);
    localHashMap.put("jumpurl", this.IIS.IFG.dCx);
    String str1 = this.IIS.IFG.IFM;
    String str2 = System.currentTimeMillis();
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localHashMap.put("expand2", String.format("{\"statBuffer\":\"%s\";\"adBuffer\":\"\";\"clickId\":%s;\"isMore\":%s}", new Object[] { str1, str2, localObject }));
      localHashMap.put("businesstype", "262144");
      localHashMap.put("h5version", ai.aft(0));
      localHashMap.put("resulttype", "262144");
      localHashMap.put("resultsubtype", this.IIS.IFG.serviceType);
      bi(localHashMap);
      localObject = new nu();
      ((nu)localObject).fiy = Util.safeParseInt((String)localHashMap.get("businesstype"));
      ((nu)localObject).fiz = ((nu)localObject).x("docid", (String)localHashMap.get("docid"), true);
      ((nu)localObject).fiB = ((nu)localObject).x("expand2", (String)localHashMap.get("expand2"), true);
      ((nu)localObject).eBQ = ((nu)localObject).x("query", (String)localHashMap.get("query"), true);
      ((nu)localObject).fiC = Util.safeParseInt((String)localHashMap.get("resultsubtype"));
      ((nu)localObject).fiA = System.currentTimeMillis();
      ((nu)localObject).fix = ((nu)localObject).x("searchid", this.IIS.IFG.hes, true);
      ((nu)localObject).els = ((nu)localObject).x("sessionid", this.IIS.dWw, true);
      ((nu)localObject).erw = 47L;
      ((nu)localObject).bfK();
      AppMethodBeat.o(116728);
      return;
    }
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(116724);
    Log.v("WidgetView", "%s selected %b", new Object[] { toString(), Boolean.valueOf(paramBoolean) });
    this.isSelected = paramBoolean;
    if (this.isSelected)
    {
      fZe();
      fZd();
      AppMethodBeat.o(116724);
      return;
    }
    this.xEm = false;
    AppMethodBeat.o(116724);
  }
  
  final void updateView()
  {
    AppMethodBeat.i(116718);
    if (this.IIS == null)
    {
      AppMethodBeat.o(116718);
      return;
    }
    if (this.IIS.IFG.wkz)
    {
      this.IIK.setVisibility(0);
      this.uGQ.setVisibility(0);
      eWo();
    }
    for (;;)
    {
      this.CkP.setText(fZh());
      AppMethodBeat.o(116718);
      return;
      this.IIK.setVisibility(8);
      this.uGQ.setVisibility(8);
    }
  }
  
  public static abstract interface a
  {
    public abstract int fZa();
    
    public abstract List<af> fZb();
    
    public abstract boolean fZc();
    
    public abstract boolean hasNext();
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b
 * JD-Core Version:    0.7.0.1
 */