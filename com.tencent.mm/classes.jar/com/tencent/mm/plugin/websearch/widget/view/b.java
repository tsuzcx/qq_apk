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
import com.tencent.mm.ak.x;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.g.b.a.jw;
import com.tencent.mm.g.b.a.jx;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.MoreFooter;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.plugin.websearch.api.ad;
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
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
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
  com.tencent.mm.plugin.websearch.api.e DWH;
  b DWK;
  View DWO;
  LinearLayout DWP;
  d DWQ;
  String DWR;
  String DWS;
  View DWT;
  private com.tencent.mm.plugin.websearch.widget.view.footer.a DWU;
  LinearLayout DWV;
  MoreFooter DWW;
  float[] DWX;
  int DWY;
  com.tencent.mm.plugin.websearch.api.g DWZ;
  a DXa;
  WidgetData DXb;
  private WidgetData DXc;
  ThreeDotsLoadingView DXd;
  View DXe;
  View DXf;
  private com.tencent.mm.plugin.websearch.widget.view.footer.a.a DXg;
  View.OnClickListener DXh;
  MMActivity activity;
  ViewGroup gsV;
  volatile boolean isLoading;
  boolean isRetry;
  boolean isSelected;
  View sQh;
  boolean ulU;
  View view;
  TextView yjO;
  
  public b()
  {
    AppMethodBeat.i(116713);
    this.DWX = new float[2];
    this.DXg = new com.tencent.mm.plugin.websearch.widget.view.footer.a.a()
    {
      public final void eQL()
      {
        AppMethodBeat.i(116689);
        List localList = b.this.DXa.eQC();
        if ((localList == null) || (localList.isEmpty()) || (localList.size() == 1))
        {
          AppMethodBeat.o(116689);
          return;
        }
        com.tencent.mm.plugin.websearch.widget.f.a(1, b.this.DXb, null);
        b.this.DWY = ((com.tencent.mm.plugin.websearch.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.f.class)).a(b.this.activity, ak.getContext().getString(2131763084), "", localList, new aa()
        {
          public final void iU(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            if (paramAnonymous2Int2 != b.this.DWY) {}
          }
        });
        AppMethodBeat.o(116689);
      }
      
      public final void eQM()
      {
        AppMethodBeat.i(116690);
        b.this.DWZ.ePB();
        AppMethodBeat.o(116690);
      }
      
      public final void eQN()
      {
        AppMethodBeat.i(116691);
        b.this.DWZ.ePC();
        AppMethodBeat.o(116691);
      }
      
      public final int getItemCount()
      {
        AppMethodBeat.i(116694);
        int i = b.this.DXa.eQB();
        AppMethodBeat.o(116694);
        return i;
      }
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(116692);
        boolean bool = b.this.DXa.hasNext();
        AppMethodBeat.o(116692);
        return bool;
      }
      
      public final boolean hasPrevious()
      {
        AppMethodBeat.i(116693);
        boolean bool = b.this.DXa.eQD();
        AppMethodBeat.o(116693);
        return bool;
      }
    };
    this.DXh = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116695);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/WidgetView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (b.this.DXb.DUL != null)
        {
          b.this.ai(b.this.DXb.DUL.DUX, b.this.DXb.DUL.DUW, b.this.DXb.DUM.DUS);
          b.this.nR(true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/WidgetView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(116695);
      }
    };
    AppMethodBeat.o(116713);
  }
  
  private static void bg(Map<String, String> paramMap)
  {
    AppMethodBeat.i(116726);
    cvj localcvj = new cvj();
    localcvj.HFU = bh(paramMap);
    x.a(new z(localcvj).hZD, null);
    AppMethodBeat.o(116726);
  }
  
  private static String bh(Map<String, String> paramMap)
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
  
  private void dUo()
  {
    AppMethodBeat.i(116719);
    switch (this.DXb.DUO)
    {
    default: 
      ae.w("WidgetView", "unknown footer type %d", new Object[] { Integer.valueOf(this.DXb.DUO) });
      AppMethodBeat.o(116719);
      return;
    case 2: 
      this.DWV.setVisibility(8);
      this.DWW.setVisibility(0);
      eQG();
      AppMethodBeat.o(116719);
      return;
    }
    this.DWW.setVisibility(8);
    this.DWV.setVisibility(0);
    eQH();
    AppMethodBeat.o(116719);
  }
  
  private void e(WidgetData paramWidgetData)
  {
    AppMethodBeat.i(116717);
    if (paramWidgetData != null)
    {
      this.isLoading = true;
      this.DXe.setVisibility(8);
      this.DXd.fQe();
      this.DWP.removeView(this.DXd);
      this.DXc = paramWidgetData;
      this.DWO.setVisibility(8);
      this.DWP.setVisibility(0);
      this.DWQ.aHe(this.DWR);
      this.DXb = paramWidgetData;
      this.DWR = ("widgetid_" + System.currentTimeMillis());
      this.DWQ.a(paramWidgetData, this.DWR, ((j)com.tencent.mm.kernel.g.ab(j.class)).ePr(), 47);
      updateView();
      ae.v("WidgetView", "%s, last %s, cur %s", new Object[] { toString(), this.DXc.toString(), this.DXb.toString() });
    }
    AppMethodBeat.o(116717);
  }
  
  private void eQG()
  {
    AppMethodBeat.i(116720);
    if (this.DXb.DUL != null)
    {
      this.DWW.setTitle(this.DXb.DUL.title);
      AppMethodBeat.o(116720);
      return;
    }
    this.DWW.setVisibility(8);
    ae.e("WidgetView", "more footer has empty title");
    AppMethodBeat.o(116720);
  }
  
  private void eQH()
  {
    AppMethodBeat.i(116721);
    Object localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.a.gAX;
    localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.xi("100443");
    if (localObject == null)
    {
      ae.i("WidgetView", "openSearchPreload item is null");
      AppMethodBeat.o(116721);
      return;
    }
    int i = 3;
    if (((c)localObject).isValid()) {
      i = bu.aSB((String)((c)localObject).fsy().get("switchType"));
    }
    switch (i)
    {
    default: 
      if (!(this.DWU instanceof DownArrowSwitchFooter))
      {
        this.DWV.removeView((View)this.DWU);
        this.DWU = new DownArrowSwitchFooter(this.DWV.getContext());
        this.DWV.addView((View)this.DWU);
      }
      break;
    }
    for (;;)
    {
      this.DWU.setCallback(this.DXg);
      this.DWU.setTitle(eQJ());
      this.DWU.setIcon(this.DXb.DUM.iconUrl);
      AppMethodBeat.o(116721);
      return;
      if (!(this.DWU instanceof BtnSwitchFooter))
      {
        this.DWV.removeView((View)this.DWU);
        this.DWU = new BtnSwitchFooter(this.DWV.getContext());
        this.DWV.addView((View)this.DWU);
        continue;
        if (!(this.DWU instanceof DirectionSwitchFooter))
        {
          this.DWV.removeView((View)this.DWU);
          this.DWU = new DirectionSwitchFooter(this.DWV.getContext());
          this.DWV.addView((View)this.DWU);
        }
      }
    }
  }
  
  private String eQI()
  {
    AppMethodBeat.i(116722);
    if (!TextUtils.isEmpty(this.DXb.DUM.DUV))
    {
      str = this.DXb.DUM.DUV;
      AppMethodBeat.o(116722);
      return str;
    }
    String str = ak.getContext().getString(2131763087);
    AppMethodBeat.o(116722);
    return str;
  }
  
  private String eQJ()
  {
    AppMethodBeat.i(116723);
    if (!TextUtils.isEmpty(this.DXb.DUM.footerWording))
    {
      str = this.DXb.DUM.footerWording;
      AppMethodBeat.o(116723);
      return str;
    }
    String str = ak.getContext().getString(2131763085, new Object[] { this.DXb.DUM.bVF });
    AppMethodBeat.o(116723);
    return str;
  }
  
  private void eQK()
  {
    AppMethodBeat.i(116725);
    ae.i("WidgetView", "exposure");
    String str1 = String.format("262144:%s:%d:%s;", new Object[] { this.DXb.DUM.tFc, Long.valueOf(System.currentTimeMillis() / 1000L), this.DXb.DUM.DUT });
    String str2 = this.DXb.DUM.cRx + ";";
    String str3 = "262144:" + this.DXb.DUM.cRx + ";";
    HashMap localHashMap = new HashMap();
    localHashMap.put("isexpose", "1");
    localHashMap.put("content", str1);
    localHashMap.put("searchid", this.DXb.DUM.kid);
    localHashMap.put("scene", "47");
    localHashMap.put("query", this.DXb.query);
    localHashMap.put("sessionid", this.DXb.dEJ);
    localHashMap.put("resulttype", str3);
    localHashMap.put("resultsubtypelist", str2);
    localHashMap.put("ishomepage", "1");
    localHashMap.put("height", this.DWP.getHeight() + ";");
    localHashMap.put("requestid", System.currentTimeMillis());
    bg(localHashMap);
    new jx().sJ(str1).sM(this.DXb.query).sO(str2).sN(str3).sK(this.DXb.DUM.kid).sL(this.DXb.dEJ).VB().aLH();
    AppMethodBeat.o(116725);
  }
  
  final void ai(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(116714);
    if (this.DXb == null)
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
    paramString1 = String.format("1:%s:%d:%s:%s:%s:%s:%d:%s", new Object[] { "", Long.valueOf(System.currentTimeMillis()), this.DXb.DUM.DUT, "isWidget=1", this.DWR, this.DXb.DUM.hNv, Integer.valueOf(this.DXb.DUM.cRx), Integer.valueOf(0) });
    ((AppBrandStatObject)localObject2).dlj = (this.DXb.dEJ + "::" + this.DXb.DUM.kid + ":" + this.DXb.DUM.tFc + ":1:" + paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramString1 = this.DXb.DUM.dlk;
      if (!TextUtils.isEmpty(paramString2)) {
        break label502;
      }
      paramString2 = this.DXb.DUM.userName;
      label341:
      localObject1 = (p)com.tencent.mm.kernel.g.ab(p.class);
      localObject3 = ak.getContext();
      if (paramInt != -1) {
        break label505;
      }
      paramInt = this.DXb.DUM.DUS;
    }
    label502:
    label505:
    for (;;)
    {
      ((p)localObject1).a((Context)localObject3, paramString2, null, paramInt, this.DXb.DUM.version, paramString1, (AppBrandStatObject)localObject2);
      localObject1 = this.DXb;
      localObject2 = new dc();
      ((dc)localObject2).efx = 1L;
      paramString1 = ((dc)localObject2).mI(paramString1).mH(((WidgetData)localObject1).query).Ta().mF(((WidgetData)localObject1).DUM.kid);
      paramString1.efA = ((WidgetData)localObject1).DUM.cRx;
      paramString1 = paramString1.mG(((WidgetData)localObject1).dEJ);
      paramString1.efz = paramString1.t("WeappUsrname", paramString2, true);
      paramString1.aLH();
      AppMethodBeat.o(116714);
      return;
      paramString1 = (String)localObject1;
      break;
      break label341;
    }
  }
  
  final void eQE()
  {
    AppMethodBeat.i(116715);
    if (this.view == null)
    {
      AppMethodBeat.o(116715);
      return;
    }
    boolean bool = this.ulU;
    if (this.view.getVisibility() != 0)
    {
      this.ulU = false;
      AppMethodBeat.o(116715);
      return;
    }
    int[] arrayOfInt = new int[2];
    this.view.getLocationOnScreen(arrayOfInt);
    if ((this.DWH != null) && (this.DWH.ePA())) {}
    for (this.ulU = true;; this.ulU = false)
    {
      if ((bool != this.ulU) && (this.ulU)) {
        eQK();
      }
      AppMethodBeat.o(116715);
      return;
    }
  }
  
  final void eQF()
  {
    AppMethodBeat.i(116716);
    if ((this.gsV == null) || (this.DXc == this.DXb))
    {
      ae.v("WidgetView", "%s same widgetData", new Object[] { toString() });
      AppMethodBeat.o(116716);
      return;
    }
    this.DWO.setVisibility(8);
    this.DWP.setVisibility(0);
    e(this.DXb);
    AppMethodBeat.o(116716);
  }
  
  public final void nR(boolean paramBoolean)
  {
    AppMethodBeat.i(116728);
    ae.i("WidgetView", "report click");
    HashMap localHashMap = new HashMap();
    localHashMap.put("content", String.format("262144:%s:%d:%s", new Object[] { this.DXb.DUM.tFc, Long.valueOf(System.currentTimeMillis() / 1000L), this.DXb.DUM.DUT }));
    localHashMap.put("searchid", this.DXb.DUM.kid);
    localHashMap.put("scene", "47");
    localHashMap.put("query", this.DXb.query);
    localHashMap.put("sessionid", this.DXb.dEJ);
    localHashMap.put("docid", this.DXb.DUM.tFc);
    localHashMap.put("timestamp", System.currentTimeMillis() / 1000L);
    localHashMap.put("jumpurl", this.DXb.DUM.dlk);
    String str1 = this.DXb.DUM.DUT;
    String str2 = System.currentTimeMillis();
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localHashMap.put("expand2", String.format("{\"statBuffer\":\"%s\";\"adBuffer\":\"\";\"clickId\":%s;\"isMore\":%s}", new Object[] { str1, str2, localObject }));
      localHashMap.put("businesstype", "262144");
      localHashMap.put("h5version", ad.WL(0));
      localHashMap.put("resulttype", "262144");
      localHashMap.put("resultsubtype", this.DXb.DUM.cRx);
      bg(localHashMap);
      localObject = new jw();
      ((jw)localObject).eDZ = bu.aSB((String)localHashMap.get("businesstype"));
      ((jw)localObject).eEa = ((jw)localObject).t("docid", (String)localHashMap.get("docid"), true);
      ((jw)localObject).eEc = ((jw)localObject).t("expand2", (String)localHashMap.get("expand2"), true);
      ((jw)localObject).ejP = ((jw)localObject).t("query", (String)localHashMap.get("query"), true);
      ((jw)localObject).eEd = bu.aSB((String)localHashMap.get("resultsubtype"));
      ((jw)localObject).eEb = System.currentTimeMillis();
      ((jw)localObject).eDY = ((jw)localObject).t("searchid", this.DXb.DUM.kid, true);
      ((jw)localObject).dRJ = ((jw)localObject).t("sessionid", this.DXb.dEJ, true);
      ((jw)localObject).dWm = 47L;
      ((jw)localObject).aLH();
      AppMethodBeat.o(116728);
      return;
    }
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(116724);
    ae.v("WidgetView", "%s selected %b", new Object[] { toString(), Boolean.valueOf(paramBoolean) });
    this.isSelected = paramBoolean;
    if (this.isSelected)
    {
      eQF();
      eQE();
      AppMethodBeat.o(116724);
      return;
    }
    this.ulU = false;
    AppMethodBeat.o(116724);
  }
  
  final void updateView()
  {
    AppMethodBeat.i(116718);
    if (this.DXb == null)
    {
      AppMethodBeat.o(116718);
      return;
    }
    if (this.DXb.DUM.tdN)
    {
      this.DWT.setVisibility(0);
      this.sQh.setVisibility(0);
      dUo();
    }
    for (;;)
    {
      this.yjO.setText(eQI());
      AppMethodBeat.o(116718);
      return;
      this.DWT.setVisibility(8);
      this.sQh.setVisibility(8);
    }
  }
  
  public static abstract interface a
  {
    public abstract int eQB();
    
    public abstract List<ab> eQC();
    
    public abstract boolean eQD();
    
    public abstract boolean hasNext();
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b
 * JD-Core Version:    0.7.0.1
 */