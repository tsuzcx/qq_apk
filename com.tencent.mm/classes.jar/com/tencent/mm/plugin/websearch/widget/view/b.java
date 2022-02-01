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
import com.tencent.mm.am.z;
import com.tencent.mm.autogen.mmdata.rpt.jh;
import com.tencent.mm.autogen.mmdata.rpt.tv;
import com.tencent.mm.autogen.mmdata.rpt.uq;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.websearch.a.h;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.MoreFooter;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.websearch.widget.b.a.1;
import com.tencent.mm.plugin.websearch.widget.b.a.2;
import com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.protocal.protobuf.eqy;
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
  TextView DGu;
  View ESX;
  boolean ICx;
  LinearLayout WtA;
  d WtB;
  String WtC;
  String WtD;
  View WtE;
  private com.tencent.mm.plugin.websearch.widget.view.footer.a WtF;
  LinearLayout WtG;
  MoreFooter WtH;
  float[] WtI;
  int WtJ;
  a WtK;
  e WtL;
  WidgetData WtM;
  private WidgetData WtN;
  ThreeDotsLoadingView WtO;
  View WtP;
  View WtQ;
  private com.tencent.mm.plugin.websearch.widget.view.footer.a.a WtR;
  View.OnClickListener WtS;
  View Wtz;
  MMActivity activity;
  volatile boolean isLoading;
  boolean isSelected;
  ViewGroup parent;
  boolean vBn;
  View view;
  
  public b()
  {
    AppMethodBeat.i(116713);
    this.WtI = new float[2];
    this.WtR = new com.tencent.mm.plugin.websearch.widget.view.footer.a.a()
    {
      public final int getItemCount()
      {
        AppMethodBeat.i(116694);
        int i = b.this.WtK.irm();
        AppMethodBeat.o(116694);
        return i;
      }
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(116692);
        boolean bool = b.this.WtK.hasNext();
        AppMethodBeat.o(116692);
        return bool;
      }
      
      public final boolean hasPrevious()
      {
        AppMethodBeat.i(116693);
        boolean bool = b.this.WtK.iro();
        AppMethodBeat.o(116693);
        return bool;
      }
      
      public final void irl()
      {
        AppMethodBeat.i(116689);
        List localList = b.this.WtK.irn();
        if ((localList == null) || (localList.isEmpty()) || (localList.size() == 1))
        {
          AppMethodBeat.o(116689);
          return;
        }
        Object localObject = b.this.WtM;
        String str = ((WidgetData)localObject).Wqn.oqe;
        tv localtv = new tv();
        localtv.ilF = localtv.F("appId", str, true);
        localtv.iFe = 1L;
        localtv.jFe = (System.currentTimeMillis() / 1000L);
        localtv.jFf = ((WidgetData)localObject).Wqn.serviceType;
        localtv.jFg = localtv.F("statBuffer", ((WidgetData)localObject).Wqn.Wqt, true);
        localtv.jFh = localtv.F("switchId", String.format("%s-%s-%s", new Object[] { ((WidgetData)localObject).Wqn.mpa, Integer.valueOf(((WidgetData)localObject).Wqn.serviceType), Long.valueOf(System.currentTimeMillis() / 1000L) }), true);
        localObject = localtv.aIE();
        ((j)h.ax(j.class)).dB(14688, (String)localObject);
        b.this.WtJ = ((com.tencent.mm.plugin.websearch.api.f)h.ax(com.tencent.mm.plugin.websearch.api.f.class)).a(b.this.activity, MMApplicationContext.getContext().getString(a.h.service_widget_choose_widget_actionsheet_title), "", localList, new af()
        {
          public final void na(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            if (paramAnonymous2Int2 != b.this.WtJ) {}
          }
        });
        AppMethodBeat.o(116689);
      }
    };
    this.WtS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(116695);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/websearch/widget/view/WidgetView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (b.this.WtM.Wqm != null)
        {
          b.this.aH(b.this.WtM.Wqm.Wqw, b.this.WtM.Wqm.Wqv, b.this.WtM.Wqn.tgv);
          b.this.sK(true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/WidgetView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(116695);
      }
    };
    AppMethodBeat.o(116713);
  }
  
  static void bu(Map<String, String> paramMap)
  {
    AppMethodBeat.i(116726);
    eqy localeqy = new eqy();
    localeqy.abuE = bv(paramMap);
    z.a(new ae(localeqy).oDw, null);
    AppMethodBeat.o(116726);
  }
  
  private static String bv(Map<String, String> paramMap)
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
      this.WtP.setVisibility(8);
      this.WtO.jFf();
      this.WtA.removeView(this.WtO);
      this.WtN = paramWidgetData;
      this.Wtz.setVisibility(8);
      this.WtA.setVisibility(0);
      this.WtB.bis(this.WtC);
      this.WtM = paramWidgetData;
      this.WtC = ("widgetid_" + System.currentTimeMillis());
      this.WtB.a(paramWidgetData, this.WtC, ((j)h.ax(j.class)).ipB(), 47);
      updateView();
      Log.v("WidgetView", "%s, last %s, cur %s", new Object[] { toString(), this.WtN.toString(), this.WtM.toString() });
    }
    AppMethodBeat.o(116717);
  }
  
  private void gZl()
  {
    AppMethodBeat.i(116719);
    switch (this.WtM.Wqp)
    {
    default: 
      Log.w("WidgetView", "unknown footer type %d", new Object[] { Integer.valueOf(this.WtM.Wqp) });
      AppMethodBeat.o(116719);
      return;
    case 2: 
      this.WtG.setVisibility(8);
      this.WtH.setVisibility(0);
      irh();
      AppMethodBeat.o(116719);
      return;
    }
    this.WtH.setVisibility(8);
    this.WtG.setVisibility(0);
    iri();
    AppMethodBeat.o(116719);
  }
  
  private void irh()
  {
    AppMethodBeat.i(116720);
    if (this.WtM.Wqm != null)
    {
      this.WtH.setTitle(this.WtM.Wqm.title);
      AppMethodBeat.o(116720);
      return;
    }
    this.WtH.setVisibility(8);
    Log.e("WidgetView", "more footer has empty title");
    AppMethodBeat.o(116720);
  }
  
  private void iri()
  {
    AppMethodBeat.i(116721);
    Object localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.a.mzH;
    localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.Fd("100443");
    if (localObject == null)
    {
      Log.i("WidgetView", "openSearchPreload item is null");
      AppMethodBeat.o(116721);
      return;
    }
    int i = 3;
    if (((c)localObject).isValid()) {
      i = Util.safeParseInt((String)((c)localObject).iWZ().get("switchType"));
    }
    switch (i)
    {
    default: 
      if (!(this.WtF instanceof DownArrowSwitchFooter))
      {
        this.WtG.removeView((View)this.WtF);
        this.WtF = new DownArrowSwitchFooter(this.WtG.getContext());
        this.WtG.addView((View)this.WtF);
      }
      break;
    }
    for (;;)
    {
      this.WtF.setCallback(this.WtR);
      this.WtF.setTitle(irk());
      this.WtF.setIcon(this.WtM.Wqn.iconUrl);
      AppMethodBeat.o(116721);
      return;
      if (!(this.WtF instanceof BtnSwitchFooter))
      {
        this.WtG.removeView((View)this.WtF);
        this.WtF = new BtnSwitchFooter(this.WtG.getContext());
        this.WtG.addView((View)this.WtF);
        continue;
        if (!(this.WtF instanceof DirectionSwitchFooter))
        {
          this.WtG.removeView((View)this.WtF);
          this.WtF = new DirectionSwitchFooter(this.WtG.getContext());
          this.WtG.addView((View)this.WtF);
        }
      }
    }
  }
  
  private String irj()
  {
    AppMethodBeat.i(116722);
    if (!TextUtils.isEmpty(this.WtM.Wqn.Wqu))
    {
      str = this.WtM.Wqn.Wqu;
      AppMethodBeat.o(116722);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(a.h.service_widget_local_search_title);
    AppMethodBeat.o(116722);
    return str;
  }
  
  private String irk()
  {
    AppMethodBeat.i(116723);
    if (!TextUtils.isEmpty(this.WtM.Wqn.footerWording))
    {
      str = this.WtM.Wqn.footerWording;
      AppMethodBeat.o(116723);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(a.h.service_widget_footer_title, new Object[] { this.WtM.Wqn.nickName });
    AppMethodBeat.o(116723);
    return str;
  }
  
  final void aH(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(116714);
    if (this.WtM == null)
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
    paramString1 = String.format("1:%s:%d:%s:%s:%s:%s:%d:%s", new Object[] { "", Long.valueOf(System.currentTimeMillis()), this.WtM.Wqn.Wqt, "isWidget=1", this.WtC, this.WtM.Wqn.oqe, Integer.valueOf(this.WtM.Wqn.serviceType), Integer.valueOf(0) });
    ((AppBrandStatObject)localObject2).hzx = (this.WtM.hVW + "::" + this.WtM.Wqn.mpa + ":" + this.WtM.Wqn.HsD + ":1:" + paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramString1 = this.WtM.Wqn.hzy;
      if (!TextUtils.isEmpty(paramString2)) {
        break label502;
      }
      paramString2 = this.WtM.Wqn.userName;
      label341:
      localObject1 = (t)h.ax(t.class);
      localObject3 = MMApplicationContext.getContext();
      if (paramInt != -1) {
        break label505;
      }
      paramInt = this.WtM.Wqn.tgv;
    }
    label502:
    label505:
    for (;;)
    {
      ((t)localObject1).a((Context)localObject3, paramString2, null, paramInt, this.WtM.Wqn.version, paramString1, (AppBrandStatObject)localObject2);
      localObject1 = this.WtM;
      localObject2 = new jh();
      ((jh)localObject2).iSv = 1L;
      paramString1 = ((jh)localObject2).sf(paramString1).se(((WidgetData)localObject1).query).aIN().sc(((WidgetData)localObject1).Wqn.mpa);
      paramString1.iSx = ((WidgetData)localObject1).Wqn.serviceType;
      paramString1 = paramString1.sd(((WidgetData)localObject1).hVW);
      paramString1.iSw = paramString1.F("WeappUsrname", paramString2, true);
      paramString1.bMH();
      AppMethodBeat.o(116714);
      return;
      paramString1 = (String)localObject1;
      break;
      break label341;
    }
  }
  
  final void irg()
  {
    AppMethodBeat.i(116716);
    if ((this.parent == null) || (this.WtN == this.WtM))
    {
      Log.v("WidgetView", "%s same widgetData", new Object[] { toString() });
      AppMethodBeat.o(116716);
      return;
    }
    this.Wtz.setVisibility(8);
    this.WtA.setVisibility(0);
    e(this.WtM);
    AppMethodBeat.o(116716);
  }
  
  public final void sK(boolean paramBoolean)
  {
    AppMethodBeat.i(116728);
    Log.i("WidgetView", "report click");
    HashMap localHashMap = new HashMap();
    localHashMap.put("content", String.format("262144:%s:%d:%s", new Object[] { this.WtM.Wqn.HsD, Long.valueOf(System.currentTimeMillis() / 1000L), this.WtM.Wqn.Wqt }));
    localHashMap.put("searchid", this.WtM.Wqn.mpa);
    localHashMap.put("scene", "47");
    localHashMap.put("query", this.WtM.query);
    localHashMap.put("sessionid", this.WtM.hVW);
    localHashMap.put("docid", this.WtM.Wqn.HsD);
    localHashMap.put("timestamp", System.currentTimeMillis() / 1000L);
    localHashMap.put("jumpurl", this.WtM.Wqn.hzy);
    String str1 = this.WtM.Wqn.Wqt;
    String str2 = System.currentTimeMillis();
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localHashMap.put("expand2", String.format("{\"statBuffer\":\"%s\";\"adBuffer\":\"\";\"clickId\":%s;\"isMore\":%s}", new Object[] { str1, str2, localObject }));
      localHashMap.put("businesstype", "262144");
      localHashMap.put("h5version", aj.asY(0));
      localHashMap.put("resulttype", "262144");
      localHashMap.put("resultsubtype", this.WtM.Wqn.serviceType);
      bu(localHashMap);
      localObject = new uq();
      ((uq)localObject).iqZ = Util.safeParseInt((String)localHashMap.get("businesstype"));
      ((uq)localObject).jHJ = ((uq)localObject).F("docid", (String)localHashMap.get("docid"), true);
      ((uq)localObject).jHL = ((uq)localObject).F("expand2", (String)localHashMap.get("expand2"), true);
      ((uq)localObject).iKB = ((uq)localObject).F("query", (String)localHashMap.get("query"), true);
      ((uq)localObject).jHM = Util.safeParseInt((String)localHashMap.get("resultsubtype"));
      ((uq)localObject).jHK = System.currentTimeMillis();
      ((uq)localObject).jHI = ((uq)localObject).F("searchid", this.WtM.Wqn.mpa, true);
      ((uq)localObject).inx = ((uq)localObject).F("sessionid", this.WtM.hVW, true);
      ((uq)localObject).iuA = 47L;
      ((uq)localObject).bMH();
      AppMethodBeat.o(116728);
      return;
    }
  }
  
  final void updateView()
  {
    AppMethodBeat.i(116718);
    if (this.WtM == null)
    {
      AppMethodBeat.o(116718);
      return;
    }
    if (this.WtM.Wqn.FYI)
    {
      this.WtE.setVisibility(0);
      this.ESX.setVisibility(0);
      gZl();
    }
    for (;;)
    {
      this.DGu.setText(irj());
      AppMethodBeat.o(116718);
      return;
      this.WtE.setVisibility(8);
      this.ESX.setVisibility(8);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean hasNext();
    
    public abstract int irm();
    
    public abstract List<ag> irn();
    
    public abstract boolean iro();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b
 * JD-Core Version:    0.7.0.1
 */