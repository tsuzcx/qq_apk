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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dh;
import com.tencent.mm.g.b.a.di;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.MoreFooter;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.a.a;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  implements com.tencent.mm.plugin.websearch.api.q
{
  ViewGroup eyt;
  boolean gDG;
  MMActivity hwZ;
  volatile boolean isLoading;
  boolean isRetry;
  i mXR;
  com.tencent.mm.plugin.websearch.api.g mYf;
  private boolean nmm;
  TextView qhL;
  b.b uMP;
  View uMT;
  LinearLayout uMU;
  f uMV;
  String uMW;
  String uMX;
  View uMY;
  View uMZ;
  private com.tencent.mm.plugin.websearch.widget.view.footer.a uNa;
  LinearLayout uNb;
  MoreFooter uNc;
  float[] uNd;
  int uNe;
  b.a uNf;
  WidgetData uNg;
  WidgetData uNh;
  ThreeDotsLoadingView uNi;
  View uNj;
  View uNk;
  private a.a uNl;
  View.OnClickListener uNm;
  View view;
  
  public b()
  {
    AppMethodBeat.i(91536);
    this.uNd = new float[2];
    this.uNl = new b.1(this);
    this.uNm = new b.2(this);
    AppMethodBeat.o(91536);
  }
  
  private static void ap(Map<String, String> paramMap)
  {
    AppMethodBeat.i(91555);
    buo localbuo = new buo();
    localbuo.xHP = aq(paramMap);
    com.tencent.mm.ai.w.a(new com.tencent.mm.plugin.websearch.api.w(localbuo).fBd, null);
    AppMethodBeat.o(91555);
  }
  
  private static String aq(Map<String, String> paramMap)
  {
    AppMethodBeat.i(91556);
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append((String)localEntry.getKey()).append("=").append(URLEncoder.encode((String)localEntry.getValue())).append("&");
    }
    paramMap = localStringBuilder.toString();
    AppMethodBeat.o(91556);
    return paramMap;
  }
  
  private void cnq()
  {
    AppMethodBeat.i(91549);
    switch (this.uNg.uKC)
    {
    default: 
      ab.w("WidgetView", "unknown footer type %d", new Object[] { Integer.valueOf(this.uNg.uKC) });
      AppMethodBeat.o(91549);
      return;
    case 2: 
      this.uNb.setVisibility(8);
      this.uNc.setVisibility(0);
      dan();
      AppMethodBeat.o(91549);
      return;
    }
    this.uNc.setVisibility(8);
    this.uNb.setVisibility(0);
    dao();
    AppMethodBeat.o(91549);
  }
  
  private void dak()
  {
    AppMethodBeat.i(91539);
    boolean bool;
    Object localObject;
    if (this.view != null)
    {
      bool = this.nmm;
      if (this.view.getVisibility() != 0)
      {
        this.nmm = false;
        AppMethodBeat.o(91539);
        return;
      }
      localObject = new int[2];
      this.view.getLocationOnScreen((int[])localObject);
      if ((this.mYf == null) || (!this.mYf.w((int[])localObject))) {
        break label517;
      }
    }
    label517:
    for (this.nmm = true;; this.nmm = false)
    {
      if ((bool != this.nmm) && (this.nmm))
      {
        ab.i("WidgetView", "exposure");
        localObject = String.format("262144:%s:%d:%s;", new Object[] { this.uNg.uKA.uKI, Long.valueOf(System.currentTimeMillis() / 1000L), this.uNg.uKA.uKJ });
        String str1 = this.uNg.uKA.fmF + ";";
        String str2 = "262144:" + this.uNg.uKA.fmF + ";";
        HashMap localHashMap = new HashMap();
        localHashMap.put("isexpose", "1");
        localHashMap.put("content", localObject);
        localHashMap.put("searchid", this.uNg.uKA.hng);
        localHashMap.put("scene", "47");
        localHashMap.put("query", this.uNg.query);
        localHashMap.put("sessionid", this.uNg.uKD);
        localHashMap.put("resulttype", str2);
        localHashMap.put("resultsubtypelist", str1);
        localHashMap.put("ishomepage", "1");
        localHashMap.put("height", this.uMU.getHeight() + ";");
        localHashMap.put("requestid", System.currentTimeMillis());
        ap(localHashMap);
        if (this.mYf != null) {
          this.mYf.bCU();
        }
        localObject = new di().iH((String)localObject).iK(this.uNg.query).iM(str1).iL(str2).iI(this.uNg.uKA.hng).iJ(this.uNg.uKD);
        ((di)localObject).cTE = 47L;
        ((di)localObject).ake();
      }
      AppMethodBeat.o(91539);
      return;
    }
  }
  
  private void dan()
  {
    AppMethodBeat.i(91550);
    if (this.uNg.uKz != null)
    {
      this.uNc.setTitle(this.uNg.uKz.title);
      AppMethodBeat.o(91550);
      return;
    }
    this.uNc.setVisibility(8);
    ab.e("WidgetView", "more footer has empty title");
    AppMethodBeat.o(91550);
  }
  
  private void dao()
  {
    AppMethodBeat.i(91551);
    Object localObject = a.b.eEW;
    localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.me("100443");
    if (localObject == null)
    {
      ab.i("WidgetView", "openSearchPreload item is null");
      AppMethodBeat.o(91551);
      return;
    }
    int i = 3;
    if (((c)localObject).isValid()) {
      i = bo.apV((String)((c)localObject).dvN().get("switchType"));
    }
    switch (i)
    {
    default: 
      if (!(this.uNa instanceof DownArrowSwitchFooter))
      {
        this.uNb.removeView((View)this.uNa);
        this.uNa = new DownArrowSwitchFooter(this.uNb.getContext());
        this.uNb.addView((View)this.uNa);
      }
      break;
    }
    for (;;)
    {
      this.uNa.setCallback(this.uNl);
      this.uNa.setTitle(daq());
      this.uNa.setIcon(this.uNg.uKA.iconUrl);
      AppMethodBeat.o(91551);
      return;
      if (!(this.uNa instanceof BtnSwitchFooter))
      {
        this.uNb.removeView((View)this.uNa);
        this.uNa = new BtnSwitchFooter(this.uNb.getContext());
        this.uNb.addView((View)this.uNa);
        continue;
        if (!(this.uNa instanceof DirectionSwitchFooter))
        {
          this.uNb.removeView((View)this.uNa);
          this.uNa = new DirectionSwitchFooter(this.uNb.getContext());
          this.uNb.addView((View)this.uNa);
        }
      }
    }
  }
  
  private String dap()
  {
    AppMethodBeat.i(91552);
    if (!TextUtils.isEmpty(this.uNg.uKA.uKL))
    {
      str = this.uNg.uKA.uKL;
      AppMethodBeat.o(91552);
      return str;
    }
    String str = ah.getContext().getString(2131306216);
    AppMethodBeat.o(91552);
    return str;
  }
  
  private String daq()
  {
    AppMethodBeat.i(91553);
    if (!TextUtils.isEmpty(this.uNg.uKA.kmN))
    {
      str = this.uNg.uKA.kmN;
      AppMethodBeat.o(91553);
      return str;
    }
    String str = ah.getContext().getString(2131306214, new Object[] { this.uNg.uKA.blZ });
    AppMethodBeat.o(91553);
    return str;
  }
  
  private void f(WidgetData paramWidgetData)
  {
    AppMethodBeat.i(91547);
    if (paramWidgetData != null)
    {
      this.isLoading = true;
      this.uNj.setVisibility(8);
      this.uNi.dOW();
      this.uMU.removeView(this.uNi);
      this.uNh = paramWidgetData;
      this.uMT.setVisibility(8);
      this.uMU.setVisibility(0);
      this.uMV.ago(this.uMW);
      this.uNg = paramWidgetData;
      this.uMW = ("widgetid_" + System.currentTimeMillis());
      this.uMV.a(paramWidgetData, this.uMW, ((n)com.tencent.mm.kernel.g.E(n.class)).cYY(), 47);
      bJ();
      ab.v("WidgetView", "%s, last %s, cur %s", new Object[] { toString(), this.uNh.toString(), this.uNg.toString() });
    }
    AppMethodBeat.o(91547);
  }
  
  final void P(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(91537);
    if (this.uNg == null)
    {
      AppMethodBeat.o(91537);
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
    paramString1 = String.format("1:%s:%d:%s:%s:%s:%s:%d:%s", new Object[] { "", Long.valueOf(System.currentTimeMillis()), this.uNg.uKA.uKJ, "isWidget=1", this.uMW, this.uNg.uKA.fqf, Integer.valueOf(this.uNg.uKA.fmF), Integer.valueOf(0) });
    ((AppBrandStatObject)localObject2).cmF = (this.uNg.uKD + "::" + this.uNg.uKA.hng + ":" + this.uNg.uKA.uKI + ":1:" + paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramString1 = this.uNg.uKA.cmG;
      if (!TextUtils.isEmpty(paramString2)) {
        break label491;
      }
      paramString2 = this.uNg.uKA.userName;
      label341:
      localObject1 = (j)com.tencent.mm.kernel.g.E(j.class);
      localObject3 = ah.getContext();
      if (paramInt != -1) {
        break label494;
      }
      paramInt = this.uNg.uKA.uKH;
    }
    label491:
    label494:
    for (;;)
    {
      ((j)localObject1).a((Context)localObject3, paramString2, null, paramInt, this.uNg.uKA.version, paramString1, (AppBrandStatObject)localObject2);
      localObject1 = this.uNg;
      localObject2 = new com.tencent.mm.g.b.a.q();
      ((com.tencent.mm.g.b.a.q)localObject2).cSf = 1L;
      paramString1 = ((com.tencent.mm.g.b.a.q)localObject2).fm(paramString1).fl(((WidgetData)localObject1).query).Fl().fj(((WidgetData)localObject1).uKA.hng);
      paramString1.cSi = ((WidgetData)localObject1).uKA.fmF;
      paramString1.fk(((WidgetData)localObject1).uKD).fn(paramString2).ake();
      AppMethodBeat.o(91537);
      return;
      paramString1 = (String)localObject1;
      break;
      break label341;
    }
  }
  
  final void bJ()
  {
    AppMethodBeat.i(91548);
    if (this.uNg == null)
    {
      AppMethodBeat.o(91548);
      return;
    }
    if (this.uNg.uKA.uKM)
    {
      this.uMZ.setVisibility(0);
      this.uMY.setVisibility(0);
      cnq();
    }
    for (;;)
    {
      this.qhL.setText(dap());
      AppMethodBeat.o(91548);
      return;
      this.uMZ.setVisibility(8);
      this.uMY.setVisibility(8);
    }
  }
  
  public final void bdM()
  {
    AppMethodBeat.i(91545);
    this.uMV.ago(this.uMW);
    AppMethodBeat.o(91545);
  }
  
  final void dal()
  {
    AppMethodBeat.i(91544);
    this.uMT.setVisibility(8);
    this.uMU.setVisibility(8);
    this.uNj.setVisibility(0);
    this.uNi.dOV();
    if (this.uMV != null) {
      this.uMV.ago(this.uMW);
    }
    AppMethodBeat.o(91544);
  }
  
  final void dam()
  {
    AppMethodBeat.i(91546);
    if ((this.eyt == null) || (this.uNh == this.uNg))
    {
      ab.v("WidgetView", "%s same widgetData", new Object[] { toString() });
      AppMethodBeat.o(91546);
      return;
    }
    this.uMT.setVisibility(8);
    this.uMU.setVisibility(0);
    f(this.uNg);
    AppMethodBeat.o(91546);
  }
  
  public final void e(WidgetData paramWidgetData)
  {
    AppMethodBeat.i(91543);
    if (paramWidgetData == null)
    {
      AppMethodBeat.o(91543);
      return;
    }
    this.uNg = paramWidgetData;
    ab.v("WidgetView", "%s, cur data %s", new Object[] { toString(), this.uNg.toString() });
    if (this.gDG)
    {
      dam();
      AppMethodBeat.o(91543);
      return;
    }
    if (this.uNg != this.uNh) {
      dal();
    }
    AppMethodBeat.o(91543);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(91538);
    if (!this.gDG)
    {
      AppMethodBeat.o(91538);
      return;
    }
    onPause();
    AppMethodBeat.o(91538);
  }
  
  public final void iL(boolean paramBoolean)
  {
    AppMethodBeat.i(91557);
    ab.i("WidgetView", "report click");
    HashMap localHashMap = new HashMap();
    localHashMap.put("content", String.format("262144:%s:%d:%s", new Object[] { this.uNg.uKA.uKI, Long.valueOf(System.currentTimeMillis() / 1000L), this.uNg.uKA.uKJ }));
    localHashMap.put("searchid", this.uNg.uKA.hng);
    localHashMap.put("scene", "47");
    localHashMap.put("query", this.uNg.query);
    localHashMap.put("sessionid", this.uNg.uKD);
    localHashMap.put("docid", this.uNg.uKA.uKI);
    localHashMap.put("timestamp", System.currentTimeMillis() / 1000L);
    localHashMap.put("jumpurl", this.uNg.uKA.cmG);
    String str1 = this.uNg.uKA.uKJ;
    String str2 = System.currentTimeMillis();
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localHashMap.put("expand2", String.format("{\"statBuffer\":\"%s\";\"adBuffer\":\"\";\"clickId\":%s;\"isMore\":%s}", new Object[] { str1, str2, localObject }));
      localHashMap.put("businesstype", "262144");
      localHashMap.put("h5version", aa.Jf(0));
      localHashMap.put("resulttype", "262144");
      localHashMap.put("resultsubtype", this.uNg.uKA.fmF);
      ap(localHashMap);
      if (this.mYf != null) {
        this.mYf.onClick();
      }
      localObject = new dh();
      ((dh)localObject).dfd = bo.apV((String)localHashMap.get("businesstype"));
      localObject = ((dh)localObject).iD((String)localHashMap.get("docid")).iE((String)localHashMap.get("expand2")).iF((String)localHashMap.get("query"));
      ((dh)localObject).dfh = bo.apV((String)localHashMap.get("resultsubtype"));
      ((dh)localObject).dff = System.currentTimeMillis();
      localObject = ((dh)localObject).iC(this.uNg.uKA.hng).iG(this.uNg.uKD);
      ((dh)localObject).cTE = 47L;
      ((dh)localObject).ake();
      AppMethodBeat.o(91557);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(91542);
    if (this.uMV == null)
    {
      AppMethodBeat.o(91542);
      return;
    }
    this.uMV.ago(this.uMW);
    this.uMV.onDestroy();
    this.uNg = null;
    this.uMW = null;
    this.hwZ = null;
    AppMethodBeat.o(91542);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(91541);
    if (!this.gDG)
    {
      AppMethodBeat.o(91541);
      return;
    }
    if (this.uMV != null) {
      this.uMV.onPause();
    }
    this.nmm = false;
    ab.v("WidgetView", "%s paused", new Object[] { toString() });
    AppMethodBeat.o(91541);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(91540);
    if (!this.gDG)
    {
      AppMethodBeat.o(91540);
      return;
    }
    this.uMV.onResume();
    dak();
    ab.v("WidgetView", "%s resume", new Object[] { toString() });
    AppMethodBeat.o(91540);
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(91554);
    ab.v("WidgetView", "%s selected %b", new Object[] { toString(), Boolean.valueOf(paramBoolean) });
    this.gDG = paramBoolean;
    if (this.gDG)
    {
      dam();
      dak();
      AppMethodBeat.o(91554);
      return;
    }
    this.nmm = false;
    AppMethodBeat.o(91554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b
 * JD-Core Version:    0.7.0.1
 */