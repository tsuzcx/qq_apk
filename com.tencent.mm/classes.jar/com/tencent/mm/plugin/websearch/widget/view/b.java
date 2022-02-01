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
import com.tencent.mm.an.aa;
import com.tencent.mm.f.b.a.hj;
import com.tencent.mm.f.b.a.qc;
import com.tencent.mm.f.b.a.qv;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.websearch.a.g;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.MoreFooter;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.websearch.widget.b.a.1;
import com.tencent.mm.plugin.websearch.widget.b.a.2;
import com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.protocal.protobuf.dxu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
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
  boolean CIn;
  TextView IhI;
  View PCU;
  LinearLayout PCV;
  d PCW;
  String PCX;
  String PCY;
  View PCZ;
  private com.tencent.mm.plugin.websearch.widget.view.footer.a PDa;
  LinearLayout PDb;
  MoreFooter PDc;
  float[] PDd;
  int PDe;
  a PDf;
  com.tencent.mm.plugin.websearch.api.e PDg;
  WidgetData PDh;
  private WidgetData PDi;
  ThreeDotsLoadingView PDj;
  View PDk;
  View PDl;
  private com.tencent.mm.plugin.websearch.widget.view.footer.a.a PDm;
  View.OnClickListener PDn;
  MMActivity activity;
  volatile boolean isLoading;
  boolean isRetry;
  boolean isSelected;
  ViewGroup parent;
  View view;
  View yOC;
  
  public b()
  {
    AppMethodBeat.i(116713);
    this.PDd = new float[2];
    this.PDm = new com.tencent.mm.plugin.websearch.widget.view.footer.a.a()
    {
      public final void gRU()
      {
        AppMethodBeat.i(116689);
        List localList = b.this.PDf.gRW();
        if ((localList == null) || (localList.isEmpty()) || (localList.size() == 1))
        {
          AppMethodBeat.o(116689);
          return;
        }
        Object localObject = b.this.PDh;
        String str = ((WidgetData)localObject).PzY.lyD;
        qc localqc = new qc();
        localqc.gfg = localqc.z("appId", str, true);
        localqc.guA = 1L;
        localqc.hjl = (System.currentTimeMillis() / 1000L);
        localqc.hjm = ((WidgetData)localObject).PzY.serviceType;
        localqc.hjn = localqc.z("statBuffer", ((WidgetData)localObject).PzY.PAe, true);
        localqc.hjo = localqc.z("switchId", String.format("%s-%s-%s", new Object[] { ((WidgetData)localObject).PzY.jQi, Integer.valueOf(((WidgetData)localObject).PzY.serviceType), Long.valueOf(System.currentTimeMillis() / 1000L) }), true);
        localObject = localqc.agH();
        ((j)h.ae(j.class)).cM(14688, (String)localObject);
        b.this.PDe = ((f)h.ae(f.class)).a(b.this.activity, MMApplicationContext.getContext().getString(a.g.service_widget_choose_widget_actionsheet_title), "", localList, new ae()
        {
          public final void lq(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            if (paramAnonymous2Int2 != b.this.PDe) {}
          }
        });
        AppMethodBeat.o(116689);
      }
      
      public final int getItemCount()
      {
        AppMethodBeat.i(116694);
        int i = b.this.PDf.gRV();
        AppMethodBeat.o(116694);
        return i;
      }
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(116692);
        boolean bool = b.this.PDf.hasNext();
        AppMethodBeat.o(116692);
        return bool;
      }
      
      public final boolean hasPrevious()
      {
        AppMethodBeat.i(116693);
        boolean bool = b.this.PDf.gRX();
        AppMethodBeat.o(116693);
        return bool;
      }
    };
    this.PDn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116695);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/websearch/widget/view/WidgetView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (b.this.PDh.PzX != null)
        {
          b.this.av(b.this.PDh.PzX.PAh, b.this.PDh.PzX.PAg, b.this.PDh.PzY.qbu);
          b.this.tC(true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/WidgetView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(116695);
      }
    };
    AppMethodBeat.o(116713);
  }
  
  static void bc(Map<String, String> paramMap)
  {
    AppMethodBeat.i(116726);
    dxu localdxu = new dxu();
    localdxu.Udk = bd(paramMap);
    aa.a(new ad(localdxu).lKU, null);
    AppMethodBeat.o(116726);
  }
  
  private static String bd(Map<String, String> paramMap)
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
      this.PDk.setVisibility(8);
      this.PDj.hZY();
      this.PCV.removeView(this.PDj);
      this.PDi = paramWidgetData;
      this.PCU.setVisibility(8);
      this.PCV.setVisibility(0);
      this.PCW.biK(this.PCX);
      this.PDh = paramWidgetData;
      this.PCX = ("widgetid_" + System.currentTimeMillis());
      this.PCW.a(paramWidgetData, this.PCX, ((j)h.ae(j.class)).gQk(), 47);
      updateView();
      Log.v("WidgetView", "%s, last %s, cur %s", new Object[] { toString(), this.PDi.toString(), this.PDh.toString() });
    }
    AppMethodBeat.o(116717);
  }
  
  private void fJr()
  {
    AppMethodBeat.i(116719);
    switch (this.PDh.PAa)
    {
    default: 
      Log.w("WidgetView", "unknown footer type %d", new Object[] { Integer.valueOf(this.PDh.PAa) });
      AppMethodBeat.o(116719);
      return;
    case 2: 
      this.PDb.setVisibility(8);
      this.PDc.setVisibility(0);
      gRQ();
      AppMethodBeat.o(116719);
      return;
    }
    this.PDc.setVisibility(8);
    this.PDb.setVisibility(0);
    gRR();
    AppMethodBeat.o(116719);
  }
  
  private void gRQ()
  {
    AppMethodBeat.i(116720);
    if (this.PDh.PzX != null)
    {
      this.PDc.setTitle(this.PDh.PzX.title);
      AppMethodBeat.o(116720);
      return;
    }
    this.PDc.setVisibility(8);
    Log.e("WidgetView", "more footer has empty title");
    AppMethodBeat.o(116720);
  }
  
  private void gRR()
  {
    AppMethodBeat.i(116721);
    Object localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.a.jZD;
    localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.Mu("100443");
    if (localObject == null)
    {
      Log.i("WidgetView", "openSearchPreload item is null");
      AppMethodBeat.o(116721);
      return;
    }
    int i = 3;
    if (((c)localObject).isValid()) {
      i = Util.safeParseInt((String)((c)localObject).hvz().get("switchType"));
    }
    switch (i)
    {
    default: 
      if (!(this.PDa instanceof DownArrowSwitchFooter))
      {
        this.PDb.removeView((View)this.PDa);
        this.PDa = new DownArrowSwitchFooter(this.PDb.getContext());
        this.PDb.addView((View)this.PDa);
      }
      break;
    }
    for (;;)
    {
      this.PDa.setCallback(this.PDm);
      this.PDa.setTitle(gRT());
      this.PDa.setIcon(this.PDh.PzY.iconUrl);
      AppMethodBeat.o(116721);
      return;
      if (!(this.PDa instanceof BtnSwitchFooter))
      {
        this.PDb.removeView((View)this.PDa);
        this.PDa = new BtnSwitchFooter(this.PDb.getContext());
        this.PDb.addView((View)this.PDa);
        continue;
        if (!(this.PDa instanceof DirectionSwitchFooter))
        {
          this.PDb.removeView((View)this.PDa);
          this.PDa = new DirectionSwitchFooter(this.PDb.getContext());
          this.PDb.addView((View)this.PDa);
        }
      }
    }
  }
  
  private String gRS()
  {
    AppMethodBeat.i(116722);
    if (!TextUtils.isEmpty(this.PDh.PzY.PAf))
    {
      str = this.PDh.PzY.PAf;
      AppMethodBeat.o(116722);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(a.g.service_widget_local_search_title);
    AppMethodBeat.o(116722);
    return str;
  }
  
  private String gRT()
  {
    AppMethodBeat.i(116723);
    if (!TextUtils.isEmpty(this.PDh.PzY.footerWording))
    {
      str = this.PDh.PzY.footerWording;
      AppMethodBeat.o(116723);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(a.g.service_widget_footer_title, new Object[] { this.PDh.PzY.nickName });
    AppMethodBeat.o(116723);
    return str;
  }
  
  final void av(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(116714);
    if (this.PDh == null)
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
    paramString1 = String.format("1:%s:%d:%s:%s:%s:%s:%d:%s", new Object[] { "", Long.valueOf(System.currentTimeMillis()), this.PDh.PzY.PAe, "isWidget=1", this.PCX, this.PDh.PzY.lyD, Integer.valueOf(this.PDh.PzY.serviceType), Integer.valueOf(0) });
    ((AppBrandStatObject)localObject2).fvd = (this.PDh.fQb + "::" + this.PDh.PzY.jQi + ":" + this.PDh.PzY.BHW + ":1:" + paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramString1 = this.PDh.PzY.fve;
      if (!TextUtils.isEmpty(paramString2)) {
        break label502;
      }
      paramString2 = this.PDh.PzY.userName;
      label341:
      localObject1 = (r)h.ae(r.class);
      localObject3 = MMApplicationContext.getContext();
      if (paramInt != -1) {
        break label505;
      }
      paramInt = this.PDh.PzY.qbu;
    }
    label502:
    label505:
    for (;;)
    {
      ((r)localObject1).a((Context)localObject3, paramString2, null, paramInt, this.PDh.PzY.version, paramString1, (AppBrandStatObject)localObject2);
      localObject1 = this.PDh;
      localObject2 = new hj();
      ((hj)localObject2).gFv = 1L;
      paramString1 = ((hj)localObject2).ww(paramString1).wv(((WidgetData)localObject1).query).alG().wt(((WidgetData)localObject1).PzY.jQi);
      paramString1.gFx = ((WidgetData)localObject1).PzY.serviceType;
      paramString1 = paramString1.wu(((WidgetData)localObject1).fQb);
      paramString1.gFw = paramString1.z("WeappUsrname", paramString2, true);
      paramString1.bpa();
      AppMethodBeat.o(116714);
      return;
      paramString1 = (String)localObject1;
      break;
      break label341;
    }
  }
  
  final void gRP()
  {
    AppMethodBeat.i(116716);
    if ((this.parent == null) || (this.PDi == this.PDh))
    {
      Log.v("WidgetView", "%s same widgetData", new Object[] { toString() });
      AppMethodBeat.o(116716);
      return;
    }
    this.PCU.setVisibility(8);
    this.PCV.setVisibility(0);
    e(this.PDh);
    AppMethodBeat.o(116716);
  }
  
  public final void tC(boolean paramBoolean)
  {
    AppMethodBeat.i(116728);
    Log.i("WidgetView", "report click");
    HashMap localHashMap = new HashMap();
    localHashMap.put("content", String.format("262144:%s:%d:%s", new Object[] { this.PDh.PzY.BHW, Long.valueOf(System.currentTimeMillis() / 1000L), this.PDh.PzY.PAe }));
    localHashMap.put("searchid", this.PDh.PzY.jQi);
    localHashMap.put("scene", "47");
    localHashMap.put("query", this.PDh.query);
    localHashMap.put("sessionid", this.PDh.fQb);
    localHashMap.put("docid", this.PDh.PzY.BHW);
    localHashMap.put("timestamp", System.currentTimeMillis() / 1000L);
    localHashMap.put("jumpurl", this.PDh.PzY.fve);
    String str1 = this.PDh.PzY.PAe;
    String str2 = System.currentTimeMillis();
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localHashMap.put("expand2", String.format("{\"statBuffer\":\"%s\";\"adBuffer\":\"\";\"clickId\":%s;\"isMore\":%s}", new Object[] { str1, str2, localObject }));
      localHashMap.put("businesstype", "262144");
      localHashMap.put("h5version", ai.anh(0));
      localHashMap.put("resulttype", "262144");
      localHashMap.put("resultsubtype", this.PDh.PzY.serviceType);
      bc(localHashMap);
      localObject = new qv();
      ((qv)localObject).hlI = Util.safeParseInt((String)localHashMap.get("businesstype"));
      ((qv)localObject).hlJ = ((qv)localObject).z("docid", (String)localHashMap.get("docid"), true);
      ((qv)localObject).hlL = ((qv)localObject).z("expand2", (String)localHashMap.get("expand2"), true);
      ((qv)localObject).gym = ((qv)localObject).z("query", (String)localHashMap.get("query"), true);
      ((qv)localObject).hlM = Util.safeParseInt((String)localHashMap.get("resultsubtype"));
      ((qv)localObject).hlK = System.currentTimeMillis();
      ((qv)localObject).hlH = ((qv)localObject).z("searchid", this.PDh.PzY.jQi, true);
      ((qv)localObject).ggA = ((qv)localObject).z("sessionid", this.PDh.fQb, true);
      ((qv)localObject).gmT = 47L;
      ((qv)localObject).bpa();
      AppMethodBeat.o(116728);
      return;
    }
  }
  
  final void updateView()
  {
    AppMethodBeat.i(116718);
    if (this.PDh == null)
    {
      AppMethodBeat.o(116718);
      return;
    }
    if (this.PDh.PzY.AVv)
    {
      this.PCZ.setVisibility(0);
      this.yOC.setVisibility(0);
      fJr();
    }
    for (;;)
    {
      this.IhI.setText(gRS());
      AppMethodBeat.o(116718);
      return;
      this.PCZ.setVisibility(8);
      this.yOC.setVisibility(8);
    }
  }
  
  public static abstract interface a
  {
    public abstract int gRV();
    
    public abstract List<af> gRW();
    
    public abstract boolean gRX();
    
    public abstract boolean hasNext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b
 * JD-Core Version:    0.7.0.1
 */