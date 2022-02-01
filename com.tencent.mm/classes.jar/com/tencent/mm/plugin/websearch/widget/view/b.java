package com.tencent.mm.plugin.websearch.widget.view;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.x;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.g.b.a.ju;
import com.tencent.mm.g.b.a.jv;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.MoreFooter;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.websearch.widget.b.a.1;
import com.tencent.mm.plugin.websearch.widget.b.a.2;
import com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
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
  com.tencent.mm.plugin.websearch.api.e DEJ;
  b DEM;
  View DEQ;
  LinearLayout DER;
  d DES;
  String DET;
  String DEU;
  View DEW;
  private com.tencent.mm.plugin.websearch.widget.view.footer.a DEX;
  LinearLayout DEY;
  MoreFooter DEZ;
  float[] DFa;
  int DFb;
  com.tencent.mm.plugin.websearch.api.g DFc;
  a DFd;
  WidgetData DFe;
  private WidgetData DFf;
  ThreeDotsLoadingView DFg;
  View DFh;
  View DFi;
  private com.tencent.mm.plugin.websearch.widget.view.footer.a.a DFj;
  View.OnClickListener DFk;
  MMActivity activity;
  ViewGroup gqv;
  volatile boolean isLoading;
  boolean isRetry;
  boolean isSelected;
  View sFi;
  boolean uaS;
  View view;
  TextView xTV;
  
  public b()
  {
    AppMethodBeat.i(116713);
    this.DFa = new float[2];
    this.DFj = new com.tencent.mm.plugin.websearch.widget.view.footer.a.a()
    {
      public final void eNa()
      {
        AppMethodBeat.i(116689);
        List localList = b.this.DFd.eMR();
        if ((localList == null) || (localList.isEmpty()) || (localList.size() == 1))
        {
          AppMethodBeat.o(116689);
          return;
        }
        com.tencent.mm.plugin.websearch.widget.f.a(1, b.this.DFe, null);
        b.this.DFb = ((com.tencent.mm.plugin.websearch.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.f.class)).a(b.this.activity, aj.getContext().getString(2131763084), "", localList, new aa()
        {
          public final void iQ(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            if (paramAnonymous2Int2 != b.this.DFb) {}
          }
        });
        AppMethodBeat.o(116689);
      }
      
      public final void eNb()
      {
        AppMethodBeat.i(116690);
        b.this.DFc.eLS();
        AppMethodBeat.o(116690);
      }
      
      public final void eNc()
      {
        AppMethodBeat.i(116691);
        b.this.DFc.eLT();
        AppMethodBeat.o(116691);
      }
      
      public final int getItemCount()
      {
        AppMethodBeat.i(116694);
        int i = b.this.DFd.eMQ();
        AppMethodBeat.o(116694);
        return i;
      }
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(116692);
        boolean bool = b.this.DFd.hasNext();
        AppMethodBeat.o(116692);
        return bool;
      }
      
      public final boolean hasPrevious()
      {
        AppMethodBeat.i(116693);
        boolean bool = b.this.DFd.eMS();
        AppMethodBeat.o(116693);
        return bool;
      }
    };
    this.DFk = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116695);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/WidgetView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (b.this.DFe.DCN != null)
        {
          b.this.ag(b.this.DFe.DCN.DCZ, b.this.DFe.DCN.DCY, b.this.DFe.DCO.DCU);
          b.this.nN(true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/WidgetView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(116695);
      }
    };
    AppMethodBeat.o(116713);
  }
  
  private static void ba(Map<String, String> paramMap)
  {
    AppMethodBeat.i(116726);
    cup localcup = new cup();
    localcup.Hmu = bb(paramMap);
    x.a(new z(localcup).hWL, null);
    AppMethodBeat.o(116726);
  }
  
  private static String bb(Map<String, String> paramMap)
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
  
  private void dQR()
  {
    AppMethodBeat.i(116719);
    switch (this.DFe.DCQ)
    {
    default: 
      com.tencent.mm.sdk.platformtools.ad.w("WidgetView", "unknown footer type %d", new Object[] { Integer.valueOf(this.DFe.DCQ) });
      AppMethodBeat.o(116719);
      return;
    case 2: 
      this.DEY.setVisibility(8);
      this.DEZ.setVisibility(0);
      eMV();
      AppMethodBeat.o(116719);
      return;
    }
    this.DEZ.setVisibility(8);
    this.DEY.setVisibility(0);
    eMW();
    AppMethodBeat.o(116719);
  }
  
  private void e(WidgetData paramWidgetData)
  {
    AppMethodBeat.i(116717);
    if (paramWidgetData != null)
    {
      this.isLoading = true;
      this.DFh.setVisibility(8);
      this.DFg.fLK();
      this.DER.removeView(this.DFg);
      this.DFf = paramWidgetData;
      this.DEQ.setVisibility(8);
      this.DER.setVisibility(0);
      this.DES.aFK(this.DET);
      this.DFe = paramWidgetData;
      this.DET = ("widgetid_" + System.currentTimeMillis());
      this.DES.a(paramWidgetData, this.DET, ((j)com.tencent.mm.kernel.g.ab(j.class)).eLI(), 47);
      updateView();
      com.tencent.mm.sdk.platformtools.ad.v("WidgetView", "%s, last %s, cur %s", new Object[] { toString(), this.DFf.toString(), this.DFe.toString() });
    }
    AppMethodBeat.o(116717);
  }
  
  private void eMV()
  {
    AppMethodBeat.i(116720);
    if (this.DFe.DCN != null)
    {
      this.DEZ.setTitle(this.DFe.DCN.title);
      AppMethodBeat.o(116720);
      return;
    }
    this.DEZ.setVisibility(8);
    com.tencent.mm.sdk.platformtools.ad.e("WidgetView", "more footer has empty title");
    AppMethodBeat.o(116720);
  }
  
  private void eMW()
  {
    AppMethodBeat.i(116721);
    Object localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.a.gyq;
    localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.wz("100443");
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("WidgetView", "openSearchPreload item is null");
      AppMethodBeat.o(116721);
      return;
    }
    int i = 3;
    if (((c)localObject).isValid()) {
      i = bt.aRe((String)((c)localObject).foF().get("switchType"));
    }
    switch (i)
    {
    default: 
      if (!(this.DEX instanceof DownArrowSwitchFooter))
      {
        this.DEY.removeView((View)this.DEX);
        this.DEX = new DownArrowSwitchFooter(this.DEY.getContext());
        this.DEY.addView((View)this.DEX);
      }
      break;
    }
    for (;;)
    {
      this.DEX.setCallback(this.DFj);
      this.DEX.setTitle(eMY());
      this.DEX.setIcon(this.DFe.DCO.iconUrl);
      AppMethodBeat.o(116721);
      return;
      if (!(this.DEX instanceof BtnSwitchFooter))
      {
        this.DEY.removeView((View)this.DEX);
        this.DEX = new BtnSwitchFooter(this.DEY.getContext());
        this.DEY.addView((View)this.DEX);
        continue;
        if (!(this.DEX instanceof DirectionSwitchFooter))
        {
          this.DEY.removeView((View)this.DEX);
          this.DEX = new DirectionSwitchFooter(this.DEY.getContext());
          this.DEY.addView((View)this.DEX);
        }
      }
    }
  }
  
  private String eMX()
  {
    AppMethodBeat.i(116722);
    if (!TextUtils.isEmpty(this.DFe.DCO.DCX))
    {
      str = this.DFe.DCO.DCX;
      AppMethodBeat.o(116722);
      return str;
    }
    String str = aj.getContext().getString(2131763087);
    AppMethodBeat.o(116722);
    return str;
  }
  
  private String eMY()
  {
    AppMethodBeat.i(116723);
    if (!TextUtils.isEmpty(this.DFe.DCO.footerWording))
    {
      str = this.DFe.DCO.footerWording;
      AppMethodBeat.o(116723);
      return str;
    }
    String str = aj.getContext().getString(2131763085, new Object[] { this.DFe.DCO.bVF });
    AppMethodBeat.o(116723);
    return str;
  }
  
  private void eMZ()
  {
    AppMethodBeat.i(116725);
    com.tencent.mm.sdk.platformtools.ad.i("WidgetView", "exposure");
    String str1 = String.format("262144:%s:%d:%s;", new Object[] { this.DFe.DCO.tul, Long.valueOf(System.currentTimeMillis() / 1000L), this.DFe.DCO.DCV });
    String str2 = this.DFe.DCO.cQN + ";";
    String str3 = "262144:" + this.DFe.DCO.cQN + ";";
    HashMap localHashMap = new HashMap();
    localHashMap.put("isexpose", "1");
    localHashMap.put("content", str1);
    localHashMap.put("searchid", this.DFe.DCO.keN);
    localHashMap.put("scene", "47");
    localHashMap.put("query", this.DFe.query);
    localHashMap.put("sessionid", this.DFe.dDE);
    localHashMap.put("resulttype", str3);
    localHashMap.put("resultsubtypelist", str2);
    localHashMap.put("ishomepage", "1");
    localHashMap.put("height", this.DER.getHeight() + ";");
    localHashMap.put("requestid", System.currentTimeMillis());
    ba(localHashMap);
    new jv().so(str1).sr(this.DFe.query).st(str2).ss(str3).sp(this.DFe.DCO.keN).sq(this.DFe.dDE).Vt().aLk();
    AppMethodBeat.o(116725);
  }
  
  final void ag(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(116714);
    if (this.DFe == null)
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
    paramString1 = String.format("1:%s:%d:%s:%s:%s:%s:%d:%s", new Object[] { "", Long.valueOf(System.currentTimeMillis()), this.DFe.DCO.DCV, "isWidget=1", this.DET, this.DFe.DCO.hKC, Integer.valueOf(this.DFe.DCO.cQN), Integer.valueOf(0) });
    ((AppBrandStatObject)localObject2).dkh = (this.DFe.dDE + "::" + this.DFe.DCO.keN + ":" + this.DFe.DCO.tul + ":1:" + paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramString1 = this.DFe.DCO.dki;
      if (!TextUtils.isEmpty(paramString2)) {
        break label502;
      }
      paramString2 = this.DFe.DCO.userName;
      label341:
      localObject1 = (o)com.tencent.mm.kernel.g.ab(o.class);
      localObject3 = aj.getContext();
      if (paramInt != -1) {
        break label505;
      }
      paramInt = this.DFe.DCO.DCU;
    }
    label502:
    label505:
    for (;;)
    {
      ((o)localObject1).a((Context)localObject3, paramString2, null, paramInt, this.DFe.DCO.version, paramString1, (AppBrandStatObject)localObject2);
      localObject1 = this.DFe;
      localObject2 = new dc();
      ((dc)localObject2).edX = 1L;
      paramString1 = ((dc)localObject2).mq(paramString1).mp(((WidgetData)localObject1).query).SU().mn(((WidgetData)localObject1).DCO.keN);
      paramString1.eea = ((WidgetData)localObject1).DCO.cQN;
      paramString1 = paramString1.mo(((WidgetData)localObject1).dDE);
      paramString1.edZ = paramString1.t("WeappUsrname", paramString2, true);
      paramString1.aLk();
      AppMethodBeat.o(116714);
      return;
      paramString1 = (String)localObject1;
      break;
      break label341;
    }
  }
  
  final void eMT()
  {
    AppMethodBeat.i(116715);
    if (this.view == null)
    {
      AppMethodBeat.o(116715);
      return;
    }
    boolean bool = this.uaS;
    if (this.view.getVisibility() != 0)
    {
      this.uaS = false;
      AppMethodBeat.o(116715);
      return;
    }
    int[] arrayOfInt = new int[2];
    this.view.getLocationOnScreen(arrayOfInt);
    if ((this.DEJ != null) && (this.DEJ.eLR())) {}
    for (this.uaS = true;; this.uaS = false)
    {
      if ((bool != this.uaS) && (this.uaS)) {
        eMZ();
      }
      AppMethodBeat.o(116715);
      return;
    }
  }
  
  final void eMU()
  {
    AppMethodBeat.i(116716);
    if ((this.gqv == null) || (this.DFf == this.DFe))
    {
      com.tencent.mm.sdk.platformtools.ad.v("WidgetView", "%s same widgetData", new Object[] { toString() });
      AppMethodBeat.o(116716);
      return;
    }
    this.DEQ.setVisibility(8);
    this.DER.setVisibility(0);
    e(this.DFe);
    AppMethodBeat.o(116716);
  }
  
  public final void nN(boolean paramBoolean)
  {
    AppMethodBeat.i(116728);
    com.tencent.mm.sdk.platformtools.ad.i("WidgetView", "report click");
    HashMap localHashMap = new HashMap();
    localHashMap.put("content", String.format("262144:%s:%d:%s", new Object[] { this.DFe.DCO.tul, Long.valueOf(System.currentTimeMillis() / 1000L), this.DFe.DCO.DCV }));
    localHashMap.put("searchid", this.DFe.DCO.keN);
    localHashMap.put("scene", "47");
    localHashMap.put("query", this.DFe.query);
    localHashMap.put("sessionid", this.DFe.dDE);
    localHashMap.put("docid", this.DFe.DCO.tul);
    localHashMap.put("timestamp", System.currentTimeMillis() / 1000L);
    localHashMap.put("jumpurl", this.DFe.DCO.dki);
    String str1 = this.DFe.DCO.DCV;
    String str2 = System.currentTimeMillis();
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localHashMap.put("expand2", String.format("{\"statBuffer\":\"%s\";\"adBuffer\":\"\";\"clickId\":%s;\"isMore\":%s}", new Object[] { str1, str2, localObject }));
      localHashMap.put("businesstype", "262144");
      localHashMap.put("h5version", com.tencent.mm.plugin.websearch.api.ad.We(0));
      localHashMap.put("resulttype", "262144");
      localHashMap.put("resultsubtype", this.DFe.DCO.cQN);
      ba(localHashMap);
      localObject = new ju();
      ((ju)localObject).eCq = bt.aRe((String)localHashMap.get("businesstype"));
      ((ju)localObject).eCr = ((ju)localObject).t("docid", (String)localHashMap.get("docid"), true);
      ((ju)localObject).eCt = ((ju)localObject).t("expand2", (String)localHashMap.get("expand2"), true);
      ((ju)localObject).eif = ((ju)localObject).t("query", (String)localHashMap.get("query"), true);
      ((ju)localObject).eCu = bt.aRe((String)localHashMap.get("resultsubtype"));
      ((ju)localObject).eCs = System.currentTimeMillis();
      ((ju)localObject).eCp = ((ju)localObject).t("searchid", this.DFe.DCO.keN, true);
      ((ju)localObject).dQt = ((ju)localObject).t("sessionid", this.DFe.dDE, true);
      ((ju)localObject).dUW = 47L;
      ((ju)localObject).aLk();
      AppMethodBeat.o(116728);
      return;
    }
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(116724);
    com.tencent.mm.sdk.platformtools.ad.v("WidgetView", "%s selected %b", new Object[] { toString(), Boolean.valueOf(paramBoolean) });
    this.isSelected = paramBoolean;
    if (this.isSelected)
    {
      eMU();
      eMT();
      AppMethodBeat.o(116724);
      return;
    }
    this.uaS = false;
    AppMethodBeat.o(116724);
  }
  
  final void updateView()
  {
    AppMethodBeat.i(116718);
    if (this.DFe == null)
    {
      AppMethodBeat.o(116718);
      return;
    }
    if (this.DFe.DCO.sSB)
    {
      this.DEW.setVisibility(0);
      this.sFi.setVisibility(0);
      dQR();
    }
    for (;;)
    {
      this.xTV.setText(eMX());
      AppMethodBeat.o(116718);
      return;
      this.DEW.setVisibility(8);
      this.sFi.setVisibility(8);
    }
  }
  
  public static abstract interface a
  {
    public abstract int eMQ();
    
    public abstract List<ab> eMR();
    
    public abstract boolean eMS();
    
    public abstract boolean hasNext();
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b
 * JD-Core Version:    0.7.0.1
 */