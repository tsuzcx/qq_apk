package com.tencent.mm.plugin.websearch.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AbsoluteLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.s.p;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.plugin.websearch.api.f
{
  private static u uLL;
  private Context context;
  private HashMap<String, Object> uLA;
  private HashMap<String, Object> uLB;
  private HashMap<String, Object> uLC;
  private Map<String, String> uLD;
  private int uLE;
  private com.tencent.mm.modelappbrand.e uLF;
  private Map<String, a.e> uLG;
  private Map<String, a.d> uLH;
  private Map<String, WidgetData> uLI;
  public boolean uLJ;
  private r uLK;
  private WidgetData uLM;
  private Runnable uLN;
  private String uLO;
  private volatile String uLP;
  
  static
  {
    AppMethodBeat.i(91427);
    uLL = new u();
    AppMethodBeat.o(91427);
  }
  
  public a(Context paramContext, final r paramr)
  {
    AppMethodBeat.i(91408);
    this.uLA = new HashMap();
    this.uLB = new HashMap();
    this.uLC = new HashMap();
    this.uLD = new HashMap();
    this.uLE = -1;
    this.uLG = new HashMap();
    this.uLH = new HashMap();
    this.uLI = new HashMap();
    this.uLJ = true;
    this.uLP = null;
    this.context = paramContext;
    this.uLK = paramr;
    this.uLF = ((com.tencent.mm.modelappbrand.e)g.E(com.tencent.mm.modelappbrand.e.class));
    if ((this.uLJ) && (new File(com.tencent.mm.compatible.util.e.eQz, "websearch-widget-not-use-tools").exists())) {
      this.uLJ = false;
    }
    if (ah.brt()) {
      com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:support", new j()
      {
        public final void onDisconnect()
        {
          AppMethodBeat.i(91378);
          if ("com.tencent.mm:support".equals(a.a(a.this)))
          {
            u.i("FTSSearchWidgetMgr", "support process dead", new Object[0]);
            if (a.b(a.this) != null)
            {
              af localaf = new af().fB(a.b(a.this).uKA.fqf);
              localaf.cUl = a.b(a.this).uKA.fmF;
              localaf.cUh = 21L;
              localaf.cUi = System.currentTimeMillis();
              localaf.fC(at.gU(ah.getContext())).ake();
              v.kS(30);
              paramr.cZh();
            }
          }
          AppMethodBeat.o(91378);
        }
      });
    }
    AppMethodBeat.o(91408);
  }
  
  private void a(View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(91420);
    al.d(new a.8(this, paramInt1, paramInt2, paramInt3, paramInt4, paramView1, paramView2, paramString));
    AppMethodBeat.o(91420);
  }
  
  private void agC(String paramString)
  {
    AppMethodBeat.i(91413);
    if ((paramString != null) && (paramString.length() > 0))
    {
      Object localObject1 = (WidgetData)this.uLI.get(paramString);
      Object localObject2 = (a.d)this.uLH.get(paramString);
      if ((localObject1 != null) && (localObject2 != null) && (((a.d)localObject2).isLoading))
      {
        localObject2 = new af().fB(((WidgetData)localObject1).uKA.fqf);
        ((af)localObject2).cUl = ((WidgetData)localObject1).uKA.fmF;
        ((af)localObject2).cUh = 24L;
        localObject1 = ((af)localObject2).fA(paramString);
        ((af)localObject1).cUi = System.currentTimeMillis();
        ((af)localObject1).fC(at.gU(ah.getContext())).ake();
      }
      localObject1 = (View)this.uLA.get(paramString);
      if (localObject1 == null)
      {
        ab.i("FTSSearchWidgetMgr", "removeWidget cacheKey %s, can not find view", new Object[] { paramString });
        AppMethodBeat.o(91413);
        return;
      }
      ab.i("FTSSearchWidgetMgr", "removing widget sessionId %s", new Object[] { ((View)localObject1).getTag().toString() });
      if (this.uLF != null)
      {
        localObject2 = (String)((View)localObject1).getTag();
        this.uLF.a((String)localObject2, (View)localObject1);
      }
      this.uLA.remove(paramString);
      this.uLC.remove(paramString);
      localObject1 = (View)this.uLB.get(paramString);
      if (localObject1 != null)
      {
        this.uLK.removeView((View)localObject1);
        this.uLB.remove(paramString);
      }
    }
    AppMethodBeat.o(91413);
  }
  
  public static u daa()
  {
    return uLL;
  }
  
  public final void a(WidgetData paramWidgetData, String paramString)
  {
    AppMethodBeat.i(91415);
    if (paramString != null) {}
    try
    {
      if (paramString.length() > 0) {
        al.d(new a.6(this, paramString, paramWidgetData));
      }
      AppMethodBeat.o(91415);
      return;
    }
    catch (Exception paramWidgetData)
    {
      ab.printErrStackTrace("FTSSearchWidgetMgr", paramWidgetData, "", new Object[0]);
      AppMethodBeat.o(91415);
    }
  }
  
  public final void a(final WidgetData paramWidgetData, final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(91410);
    com.tencent.mm.ipcinvoker.l.r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(91392);
        if ((paramWidgetData == null) || (paramWidgetData.uKA == null) || (paramWidgetData.uKB == null))
        {
          AppMethodBeat.o(91392);
          return;
        }
        d.dab();
        if (!d.a(paramWidgetData))
        {
          u.i("FTSSearchWidgetMgr", "local forbidden widget %s", new Object[] { paramWidgetData.uKA.fqf });
          al.d(new a.2.1(this));
          AppMethodBeat.o(91392);
          return;
        }
        al.d(new a.2.2(this));
        AppMethodBeat.o(91392);
      }
    });
    AppMethodBeat.o(91410);
  }
  
  public final void agn(String paramString)
  {
    AppMethodBeat.i(91409);
    paramString = (a.d)this.uLH.get(paramString);
    if (paramString != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("app_id", paramString.cwc);
      localBundle.putString("msg_id", paramString.hny);
      localBundle.putInt("pkg_type", paramString.cvs);
      localBundle.putInt("pkg_version", paramString.gXf);
      ((com.tencent.mm.modelappbrand.e)g.E(com.tencent.mm.modelappbrand.e.class)).acl().f(this.context, localBundle);
    }
    AppMethodBeat.o(91409);
  }
  
  public final void ago(String paramString)
  {
    AppMethodBeat.i(91412);
    agC(paramString);
    d.dab();
    d.c(this.uLM);
    AppMethodBeat.o(91412);
  }
  
  public final void cZe()
  {
    this.uLJ = false;
  }
  
  public final void f(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(91419);
    u.v("FTSSearchWidgetMgr", "tapSearchWAWidgetView x %d, y %d, widgetId %s, eventId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
    View localView = (View)this.uLA.get(paramString1);
    if (localView != null)
    {
      com.tencent.mm.sdk.g.d.post(new a.7(this, paramInt1, paramInt2, paramString2, this.uLF.cm(localView), paramString1), "tapSearchWAWidgetView");
      AppMethodBeat.o(91419);
      return;
    }
    ab.i("FTSSearchWidgetMgr", "onTap fail: can not find Widget by widgetId %s", new Object[] { paramString1 });
    this.uLK.a(paramString2, false, "onTap fail: can not find Widget by widgetId ".concat(String.valueOf(paramString1)), paramString1);
    AppMethodBeat.o(91419);
  }
  
  public final void hg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(91414);
    ab.i("FTSSearchWidgetMgr", "updating widget: widgetId %s, jsonData %s", new Object[] { paramString2, paramString1 });
    View localView1;
    View localView2;
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        if ((paramString2 == null) || (paramString2.length() <= 0)) {
          break label367;
        }
        localView1 = (View)this.uLA.get(paramString2);
        localView2 = (View)this.uLB.get(paramString2);
        if (localView1 == null) {
          break label367;
        }
        AbsoluteLayout.LayoutParams localLayoutParams1 = (AbsoluteLayout.LayoutParams)localView1.getLayoutParams();
        AbsoluteLayout.LayoutParams localLayoutParams2 = (AbsoluteLayout.LayoutParams)localView2.getLayoutParams();
        if ((paramString1.has("width")) || (paramString1.has("height")))
        {
          int i = localLayoutParams1.height;
          int j = p.pQ(paramString1.optInt("height"));
          int k = localLayoutParams1.width;
          int m = p.pQ(paramString1.optInt("width"));
          a(localView1, (View)this.uLC.get(paramString2), i, j, k, m, paramString2);
        }
        if (paramString1.has("offsetX")) {
          localLayoutParams2.x = p.pQ(paramString1.optInt("offsetX"));
        }
        if (paramString1.has("offsetY")) {
          localLayoutParams2.y = p.pQ(paramString1.optInt("offsetY"));
        }
        localView2.setLayoutParams(localLayoutParams2);
        boolean bool = paramString1.has("backgroundColor");
        if (bool) {}
        try
        {
          localView1.setBackgroundColor(Color.parseColor(paramString1.getString("backgroundColor")));
          if (!paramString1.has("show")) {
            break label367;
          }
          if (paramString1.has("show"))
          {
            bool = paramString1.optBoolean("show");
            if (!bool) {
              break;
            }
            localView1.setVisibility(0);
            localView2.setVisibility(0);
            AppMethodBeat.o(91414);
            return;
          }
        }
        catch (Exception paramString2)
        {
          ab.e("FTSSearchWidgetMgr", bo.l(paramString2));
          continue;
        }
        bool = false;
      }
      catch (Exception paramString1)
      {
        ab.e("FTSSearchWidgetMgr", "the error is e");
        AppMethodBeat.o(91414);
        return;
      }
    }
    localView1.setVisibility(8);
    localView2.setVisibility(8);
    label367:
    AppMethodBeat.o(91414);
  }
  
  public final void n(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91411);
    a(WidgetData.agA(paramString1), paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(91411);
  }
  
  public final void onDestroy()
  {
    int i = 0;
    AppMethodBeat.i(91418);
    try
    {
      Object localObject = new File(b.eQw.replace("/data/user/0", "/data/data") + "/fts_cache").listFiles(new a.4(this, ""));
      String str1;
      if (localObject != null)
      {
        int j = localObject.length;
        while (i < j)
        {
          str1 = localObject[i];
          u.i("FTSSearchWidgetMgr", "deleting %s", new Object[] { str1.getAbsoluteFile() });
          str1.delete();
          i += 1;
        }
      }
      if (this.uLF == null) {
        break label292;
      }
      ab.i("FTSSearchWidgetMgr", "remove all widget count %d", new Object[] { Integer.valueOf(this.uLA.size()) });
      localObject = new HashMap(this.uLA).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        str1 = (String)((Iterator)localObject).next();
        if ((str1 != null) && (str1.length() > 0))
        {
          String str2 = (String)((View)this.uLA.get(str1)).getTag();
          this.uLF.qi(str2);
          if ((View)this.uLB.get(str1) != null)
          {
            agC(str1);
            this.uLB.remove(str1);
          }
        }
      }
      this.uLA.clear();
    }
    catch (Exception localException)
    {
      ab.e("FTSSearchWidgetMgr", bo.l(localException));
      AppMethodBeat.o(91418);
      return;
    }
    this.uLC.clear();
    label292:
    this.uLM = null;
    AppMethodBeat.o(91418);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(91417);
    if (this.uLF != null)
    {
      Iterator localIterator = this.uLA.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.length() > 0))
        {
          str = (String)((View)this.uLA.get(str)).getTag();
          ((com.tencent.mm.modelappbrand.e)g.E(com.tencent.mm.modelappbrand.e.class)).ack().qg(str);
        }
      }
    }
    AppMethodBeat.o(91417);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(91416);
    if (this.uLF != null)
    {
      Iterator localIterator = this.uLA.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.length() > 0))
        {
          str = (String)((View)this.uLA.get(str)).getTag();
          ((com.tencent.mm.modelappbrand.e)g.E(com.tencent.mm.modelappbrand.e.class)).ack().qh(str);
        }
      }
    }
    AppMethodBeat.o(91416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a
 * JD-Core Version:    0.7.0.1
 */