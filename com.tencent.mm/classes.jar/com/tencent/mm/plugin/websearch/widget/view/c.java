package com.tencent.mm.plugin.websearch.widget.view;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.h.b.a.az;
import com.tencent.mm.h.b.a.ba;
import com.tencent.mm.h.b.a.k;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.plugin.websearch.a.c;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.MoreFooter;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.websearch.api.q;
import com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.a.a;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements q
{
  boolean fmm;
  MMActivity gfb;
  ViewGroup hpb;
  boolean iHI;
  volatile boolean isLoading;
  i kBU;
  com.tencent.mm.plugin.websearch.api.g kCj;
  private boolean kOp;
  TextView nwK;
  b qXB;
  View qXF;
  LinearLayout qXG;
  f qXH;
  String qXI;
  String qXJ;
  View qXK;
  View qXL;
  private com.tencent.mm.plugin.websearch.widget.view.footer.a qXM;
  LinearLayout qXN;
  MoreFooter qXO;
  float[] qXP = new float[2];
  int qXQ;
  c.a qXR;
  WidgetData qXS;
  WidgetData qXT;
  ThreeDotsLoadingView qXU;
  View qXV;
  View qXW;
  private a.a qXX = new c.1(this);
  View.OnClickListener qXY = new c.2(this);
  View view;
  
  private static void V(Map<String, String> paramMap)
  {
    blf localblf = new blf();
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append((String)localEntry.getKey()).append("=").append(URLEncoder.encode((String)localEntry.getValue())).append("&");
    }
    localblf.tEQ = localStringBuilder.toString();
    com.tencent.mm.ah.w.a(new com.tencent.mm.plugin.websearch.api.w(localblf).esv, null);
  }
  
  private void cap()
  {
    boolean bool;
    if (this.view != null)
    {
      bool = this.kOp;
      if (this.view.getVisibility() == 0) {
        break label28;
      }
      this.kOp = false;
    }
    for (;;)
    {
      return;
      label28:
      Object localObject1 = new int[2];
      this.view.getLocationOnScreen((int[])localObject1);
      if ((this.kCj != null) && (this.kCj.m((int[])localObject1))) {}
      for (this.kOp = true; (bool != this.kOp) && (this.kOp); this.kOp = false)
      {
        y.i("WidgetView", "exposure");
        localObject1 = String.format("262144:%s:%d:%s;", new Object[] { this.qXS.qVo.qVw, Long.valueOf(System.currentTimeMillis() / 1000L), this.qXS.qVo.qVx });
        String str1 = this.qXS.qVo.dWx + ";";
        String str2 = "262144:" + this.qXS.qVo.dWx + ";";
        Object localObject2 = new HashMap();
        ((Map)localObject2).put("isexpose", "1");
        ((Map)localObject2).put("content", localObject1);
        ((Map)localObject2).put("searchid", this.qXS.qVo.fTF);
        ((Map)localObject2).put("scene", "47");
        ((Map)localObject2).put("query", this.qXS.bVk);
        ((Map)localObject2).put("sessionid", this.qXS.qVr);
        ((Map)localObject2).put("resulttype", str2);
        ((Map)localObject2).put("resultsubtypelist", str1);
        ((Map)localObject2).put("ishomepage", "1");
        ((Map)localObject2).put("height", this.qXG.getHeight() + ";");
        ((Map)localObject2).put("requestid", System.currentTimeMillis());
        V((Map)localObject2);
        if (this.kCj != null) {
          this.kCj.aWq();
        }
        localObject2 = new ba();
        ((ba)localObject2).cqM = ((String)localObject1);
        ((ba)localObject2).cjD = this.qXS.bVk;
        ((ba)localObject2).cqO = str1;
        ((ba)localObject2).cqN = str2;
        ((ba)localObject2).cqG = this.qXS.qVo.fTF;
        ((ba)localObject2).cja = this.qXS.qVr;
        ((ba)localObject2).ciV = 47L;
        ((ba)localObject2).QX();
        return;
      }
    }
  }
  
  final void H(String paramString1, String paramString2, int paramInt)
  {
    if (this.qXS == null) {
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
    paramString1 = String.format("1:%s:%d:%s:%s:%s:%s:%d:%s", new Object[] { "", Long.valueOf(System.currentTimeMillis()), this.qXS.qVo.qVx, "isWidget=1", this.qXI, this.qXS.qVo.dZY, Integer.valueOf(this.qXS.qVo.dWx), Integer.valueOf(0) });
    ((AppBrandStatObject)localObject2).bFv = (this.qXS.qVr + "::" + this.qXS.qVo.fTF + ":" + this.qXS.qVo.qVw + ":1:" + paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramString1 = this.qXS.qVo.bFw;
      if (!TextUtils.isEmpty(paramString2)) {
        break label480;
      }
      paramString2 = this.qXS.qVo.userName;
      label329:
      localObject1 = (d)com.tencent.mm.kernel.g.r(d.class);
      localObject3 = ae.getContext();
      if (paramInt != -1) {
        break label483;
      }
      paramInt = this.qXS.qVo.qVv;
    }
    label480:
    label483:
    for (;;)
    {
      ((d)localObject1).a((Context)localObject3, paramString2, null, paramInt, this.qXS.qVo.version, paramString1, (AppBrandStatObject)localObject2);
      localObject1 = this.qXS;
      localObject2 = new k();
      ((k)localObject2).cig = 1L;
      ((k)localObject2).cih = paramString1;
      ((k)localObject2).cif = ((WidgetData)localObject1).bVk;
      paramString1 = ((k)localObject2).uO();
      paramString1.cid = ((WidgetData)localObject1).qVo.fTF;
      paramString1.cij = ((WidgetData)localObject1).qVo.dWx;
      paramString1.cie = ((WidgetData)localObject1).qVr;
      paramString1.cii = paramString2;
      paramString1.QX();
      return;
      paramString1 = (String)localObject1;
      break;
      break label329;
    }
  }
  
  final void aZ()
  {
    if (this.qXS == null) {
      return;
    }
    Object localObject2;
    if (this.qXS.qVo.qVA)
    {
      this.qXL.setVisibility(0);
      this.qXK.setVisibility(0);
      switch (this.qXS.qVq)
      {
      default: 
        y.w("WidgetView", "unknown footer type %d", new Object[] { Integer.valueOf(this.qXS.qVq) });
        localObject2 = this.nwK;
        if (TextUtils.isEmpty(this.qXS.qVo.qVz)) {
          break;
        }
      }
    }
    for (Object localObject1 = this.qXS.qVo.qVz;; localObject1 = ae.getContext().getString(a.c.service_widget_local_search_title))
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      return;
      this.qXN.setVisibility(8);
      this.qXO.setVisibility(0);
      if (this.qXS.qVn != null)
      {
        this.qXO.setTitle(this.qXS.qVn.title);
        break;
      }
      this.qXO.setVisibility(8);
      y.e("WidgetView", "more footer has empty title");
      break;
      this.qXO.setVisibility(8);
      this.qXN.setVisibility(0);
      localObject1 = a.b.dHs;
      localObject1 = com.tencent.mm.ipcinvoker.wx_extension.a.a.fJ("100443");
      if (localObject1 == null)
      {
        y.i("WidgetView", "openSearchPreload item is null");
        break;
      }
      int i = 3;
      if (((com.tencent.mm.storage.c)localObject1).isValid()) {
        i = bk.ZR((String)((com.tencent.mm.storage.c)localObject1).ctr().get("switchType"));
      }
      switch (i)
      {
      default: 
        if (!(this.qXM instanceof DownArrowSwitchFooter))
        {
          this.qXN.removeView((View)this.qXM);
          this.qXM = new DownArrowSwitchFooter(this.qXN.getContext());
          this.qXN.addView((View)this.qXM);
        }
        label348:
        this.qXM.setCallback(this.qXX);
        localObject2 = this.qXM;
        if (TextUtils.isEmpty(this.qXS.qVo.ilQ)) {
          break;
        }
      }
      for (localObject1 = this.qXS.qVo.ilQ;; localObject1 = ae.getContext().getString(a.c.service_widget_footer_title, new Object[] { this.qXS.qVo.aVr }))
      {
        ((com.tencent.mm.plugin.websearch.widget.view.footer.a)localObject2).setTitle((String)localObject1);
        this.qXM.setIcon(this.qXS.qVo.iconUrl);
        break;
        if ((this.qXM instanceof BtnSwitchFooter)) {
          break label348;
        }
        this.qXN.removeView((View)this.qXM);
        this.qXM = new BtnSwitchFooter(this.qXN.getContext());
        this.qXN.addView((View)this.qXM);
        break label348;
        if ((this.qXM instanceof DirectionSwitchFooter)) {
          break label348;
        }
        this.qXN.removeView((View)this.qXM);
        this.qXM = new DirectionSwitchFooter(this.qXN.getContext());
        this.qXN.addView((View)this.qXM);
        break label348;
      }
      this.qXL.setVisibility(8);
      this.qXK.setVisibility(8);
      break;
    }
  }
  
  final void caq()
  {
    this.qXF.setVisibility(8);
    this.qXG.setVisibility(8);
    this.qXV.setVisibility(0);
    this.qXU.cKb();
    if (this.qXH != null) {
      this.qXH.Rp(this.qXI);
    }
  }
  
  final void car()
  {
    if ((this.hpb == null) || (this.qXT == this.qXS)) {
      y.v("WidgetView", "%s same widgetData", new Object[] { toString() });
    }
    WidgetData localWidgetData;
    do
    {
      return;
      this.qXF.setVisibility(8);
      this.qXG.setVisibility(0);
      localWidgetData = this.qXS;
    } while (localWidgetData == null);
    this.isLoading = true;
    this.qXV.setVisibility(8);
    this.qXU.cKc();
    this.qXG.removeView(this.qXU);
    this.qXT = localWidgetData;
    this.qXF.setVisibility(8);
    this.qXG.setVisibility(0);
    this.qXH.Rp(this.qXI);
    this.qXS = localWidgetData;
    this.qXI = ("widgetid_" + System.currentTimeMillis());
    this.qXH.a(localWidgetData, this.qXI, ((n)com.tencent.mm.kernel.g.r(n.class)).bZi(), 47);
    aZ();
    y.v("WidgetView", "%s, last %s, cur %s", new Object[] { toString(), this.qXT.toString(), this.qXS.toString() });
  }
  
  public final void e(WidgetData paramWidgetData)
  {
    if (paramWidgetData == null) {}
    do
    {
      return;
      this.qXS = paramWidgetData;
      y.v("WidgetView", "%s, cur data %s", new Object[] { toString(), this.qXS.toString() });
      if (this.fmm)
      {
        car();
        return;
      }
    } while (this.qXS == this.qXT);
    caq();
  }
  
  public final void hb(boolean paramBoolean)
  {
    y.i("WidgetView", "report click");
    HashMap localHashMap = new HashMap();
    localHashMap.put("content", String.format("262144:%s:%d:%s", new Object[] { this.qXS.qVo.qVw, Long.valueOf(System.currentTimeMillis() / 1000L), this.qXS.qVo.qVx }));
    localHashMap.put("searchid", this.qXS.qVo.fTF);
    localHashMap.put("scene", "47");
    localHashMap.put("query", this.qXS.bVk);
    localHashMap.put("sessionid", this.qXS.qVr);
    localHashMap.put("docid", this.qXS.qVo.qVw);
    localHashMap.put("timestamp", System.currentTimeMillis() / 1000L);
    localHashMap.put("jumpurl", this.qXS.qVo.bFw);
    String str1 = this.qXS.qVo.qVx;
    String str2 = System.currentTimeMillis();
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localHashMap.put("expand2", String.format("{\"statBuffer\":\"%s\";\"adBuffer\":\"\";\"clickId\":%s;\"isMore\":%s}", new Object[] { str1, str2, localObject }));
      localHashMap.put("businesstype", "262144");
      localHashMap.put("h5version", aa.Bs(0));
      localHashMap.put("resulttype", "262144");
      localHashMap.put("resultsubtype", this.qXS.qVo.dWx);
      V(localHashMap);
      if (this.kCj != null) {
        this.kCj.onClick();
      }
      localObject = new az();
      ((az)localObject).cqH = bk.ZR((String)localHashMap.get("businesstype"));
      ((az)localObject).cqI = ((String)localHashMap.get("docid"));
      ((az)localObject).cqK = ((String)localHashMap.get("expand2"));
      ((az)localObject).cjD = ((String)localHashMap.get("query"));
      ((az)localObject).cqL = bk.ZR((String)localHashMap.get("resultsubtype"));
      ((az)localObject).cqJ = System.currentTimeMillis();
      ((az)localObject).cqG = this.qXS.qVo.fTF;
      ((az)localObject).cja = this.qXS.qVr;
      ((az)localObject).ciV = 47L;
      ((az)localObject).QX();
      return;
    }
  }
  
  public final void onDestroy()
  {
    if (this.qXH == null) {
      return;
    }
    this.qXH.Rp(this.qXI);
    this.qXH.onDestroy();
    this.qXS = null;
    this.qXI = null;
    this.gfb = null;
  }
  
  public final void onPause()
  {
    if (!this.fmm) {
      return;
    }
    if (this.qXH != null) {
      this.qXH.onPause();
    }
    this.kOp = false;
    y.v("WidgetView", "%s paused", new Object[] { toString() });
  }
  
  public final void onResume()
  {
    if (!this.fmm) {
      return;
    }
    this.qXH.onResume();
    cap();
    y.v("WidgetView", "%s resume", new Object[] { toString() });
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    y.v("WidgetView", "%s selected %b", new Object[] { toString(), Boolean.valueOf(paramBoolean) });
    this.fmm = paramBoolean;
    if (this.fmm)
    {
      car();
      cap();
      return;
    }
    this.kOp = false;
  }
  
  public static abstract interface b
  {
    public abstract void BM(int paramInt);
    
    public abstract void a(c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.c
 * JD-Core Version:    0.7.0.1
 */