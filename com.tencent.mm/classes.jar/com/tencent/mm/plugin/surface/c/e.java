package com.tencent.mm.plugin.surface.c;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.surface.core.j;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.aa;
import kotlin.z;
import org.json.JSONObject;
import org.xwalk.core.Log;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/render/FrameSetManager;", "", "()V", "TAG", "", "appContextListener", "Lcom/tencent/mm/plugin/surface/render/AppContextListener;", "getAppContextListener$plugin_surface_app_release", "()Lcom/tencent/mm/plugin/surface/render/AppContextListener;", "setAppContextListener$plugin_surface_app_release", "(Lcom/tencent/mm/plugin/surface/render/AppContextListener;)V", "appContexts", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/surface/render/AppContext;", "Lkotlin/collections/HashMap;", "frameSetListener", "Lcom/tencent/mm/plugin/surface/render/FrameSetListener;", "getFrameSetListener$plugin_surface_app_release", "()Lcom/tencent/mm/plugin/surface/render/FrameSetListener;", "setFrameSetListener$plugin_surface_app_release", "(Lcom/tencent/mm/plugin/surface/render/FrameSetListener;)V", "isEmpty", "", "isEmpty$plugin_surface_app_release", "()Z", "onScreen", "Lcom/tencent/mm/plugin/surface/render/FrameSet;", "renderStatusListener", "Lcom/tencent/mm/plugin/surface/render/RenderStatusListener;", "getRenderStatusListener$plugin_surface_app_release", "()Lcom/tencent/mm/plugin/surface/render/RenderStatusListener;", "setRenderStatusListener$plugin_surface_app_release", "(Lcom/tencent/mm/plugin/surface/render/RenderStatusListener;)V", "attach", "", "frameSet", "create", "Lcom/tencent/mm/plugin/surface/render/FrameSetRoot;", "target", "context", "Landroid/content/Context;", "appId", "path", "query", "detach", "get", "id", "has", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e SLi;
  private static final HashMap<String, c> SLj;
  private static final HashMap<String, a> SLk;
  private static b SLl;
  private static d SLm;
  private static k SLn;
  
  static
  {
    AppMethodBeat.i(265111);
    SLi = new e();
    SLj = new HashMap();
    SLk = new HashMap();
    AppMethodBeat.o(265111);
  }
  
  public static f a(final Object paramObject, Context paramContext, String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(265074);
    s.u(paramObject, "target");
    s.u(paramContext, "context");
    s.u(paramString1, "appId");
    s.u(paramString2, "path");
    s.u(paramString3, "query");
    final String str = aa.aMB(z.aKc(paramObject.hashCode()));
    final WeakReference localWeakReference = new WeakReference(paramContext);
    paramObject = (a)SLk.get(paramString1);
    if (paramObject == null)
    {
      paramContext = new a(paramString1);
      Log.i("MicroMsg.SurfaceApp.FrameSetManager", "create AppContext#" + paramContext.id + ": " + paramString1);
      ((Map)SLk).put(paramString1, paramContext);
      b localb = SLl;
      paramObject = paramContext;
      if (localb != null)
      {
        localb.a(paramContext);
        paramObject = paramContext;
      }
    }
    for (;;)
    {
      paramObject = new a(paramString1, paramObject, paramString2, paramString3, str, localWeakReference);
      Log.i("MicroMsg.SurfaceApp.FrameSetManager", "create FrameSetRoot#" + str + ": " + paramString1);
      paramContext = SLm;
      if (paramContext != null) {
        paramContext.a((f)paramObject);
      }
      paramObject = (f)paramObject;
      AppMethodBeat.o(265074);
      return paramObject;
    }
  }
  
  public static void a(b paramb)
  {
    SLl = paramb;
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(265093);
    s.u(paramc, "frameSet");
    boolean bool = SLj.isEmpty();
    ((Map)SLj).put(paramc.id, paramc);
    Log.i("MicroMsg.SurfaceApp.FrameSetManager", s.X("attach frameSet#", paramc.id));
    if (bool)
    {
      paramc = SLn;
      if (paramc != null) {
        paramc.onForeground();
      }
    }
    AppMethodBeat.o(265093);
  }
  
  public static void a(d paramd)
  {
    SLm = paramd;
  }
  
  public static void a(k paramk)
  {
    SLn = paramk;
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(265101);
    s.u(paramc, "frameSet");
    SLj.remove(paramc.id);
    Log.i("MicroMsg.SurfaceApp.FrameSetManager", s.X("detach frameSet#", paramc.id));
    if (SLj.isEmpty())
    {
      paramc = SLn;
      if (paramc != null) {
        paramc.onBackground();
      }
    }
    AppMethodBeat.o(265101);
  }
  
  public static c bda(String paramString)
  {
    AppMethodBeat.i(265080);
    s.u(paramString, "id");
    paramString = (c)SLj.get(paramString);
    AppMethodBeat.o(265080);
    return paramString;
  }
  
  public static d hBR()
  {
    return SLm;
  }
  
  public static boolean hBS()
  {
    AppMethodBeat.i(265065);
    boolean bool = SLj.isEmpty();
    AppMethodBeat.o(265065);
    return bool;
  }
  
  public static boolean has(String paramString)
  {
    AppMethodBeat.i(265083);
    s.u(paramString, "id");
    boolean bool = SLj.containsKey(paramString);
    AppMethodBeat.o(265083);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/surface/render/FrameSetManager$create$1", "Lcom/tencent/mm/plugin/surface/render/FrameSetRoot;", "appContextId", "", "getAppContextId$plugin_surface_app_release", "()Ljava/lang/String;", "appId", "getAppId$plugin_surface_app_release", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "frameSets", "Ljava/util/LinkedList;", "id", "getId", "path", "getPath$plugin_surface_app_release", "query", "getQuery$plugin_surface_app_release", "destroy", "", "onBind", "frameSet", "Lcom/tencent/mm/plugin/surface/render/FrameSet;", "info", "onBind$plugin_surface_app_release", "onDataChanged", "data", "pause", "resume", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends f
  {
    private final LinkedList<String> SLo;
    private final String SLp;
    private final String appId;
    private final String id;
    private final String path;
    private final String query;
    
    a(String paramString1, a parama, String paramString2, String paramString3, String paramString4, WeakReference<Context> paramWeakReference)
    {
      AppMethodBeat.i(265035);
      this.SLo = new LinkedList();
      this.appId = this.eug;
      this.SLp = paramObject.id;
      this.path = paramString2;
      this.query = paramString3;
      this.id = str;
      AppMethodBeat.o(265035);
    }
    
    public final void a(c paramc, String paramString)
    {
      AppMethodBeat.i(265079);
      s.u(paramc, "frameSet");
      s.u(paramString, "info");
      Log.i("MicroMsg.SurfaceApp.FrameSetManager", "FrameSetRoot#" + str + " bind: " + paramc.id + " to " + this.eug);
      Object localObject = e.SLi;
      localObject = e.hBR();
      if (localObject != null) {
        ((d)localObject).a((f)this, paramc, paramString);
      }
      if (!this.SLo.contains(paramc.id)) {
        this.SLo.add(paramc.id);
      }
      AppMethodBeat.o(265079);
    }
    
    public final void bdb(String paramString)
    {
      AppMethodBeat.i(265087);
      s.u(paramString, "data");
      Object localObject = com.tencent.mm.plugin.surface.b.SJM;
      f localf = (f)this;
      s.u(localf, "root");
      s.u(paramString, "data");
      localObject = com.tencent.mm.plugin.surface.b.hBD();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appId", localf.hBU());
      localJSONObject.put("frameSetRootId", localf.getId());
      localJSONObject.put("data", paramString);
      paramString = ah.aiuX;
      ((j)localObject).cJ("surface:frameSetRoot:dataChange", localJSONObject.toString());
      AppMethodBeat.o(265087);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(265109);
      Log.i("MicroMsg.SurfaceApp.FrameSetManager", "FrameSetRoot#" + str + " destroy: " + this.eug);
      Object localObject = e.SLi;
      localObject = e.hBR();
      if (localObject != null) {
        ((d)localObject).d((f)this);
      }
      this.SLo.clear();
      AppMethodBeat.o(265109);
    }
    
    public final Context getContext()
    {
      AppMethodBeat.i(265070);
      Context localContext = (Context)localWeakReference.get();
      AppMethodBeat.o(265070);
      return localContext;
    }
    
    public final String getId()
    {
      return this.id;
    }
    
    public final String hBU()
    {
      return this.appId;
    }
    
    public final String hBV()
    {
      return this.SLp;
    }
    
    public final String hBW()
    {
      return this.path;
    }
    
    public final String hBX()
    {
      return this.query;
    }
    
    public final void pause()
    {
      AppMethodBeat.i(265103);
      Log.i("MicroMsg.SurfaceApp.FrameSetManager", "FrameSetRoot#" + str + " pause: " + this.eug);
      Object localObject = e.SLi;
      localObject = e.hBR();
      if (localObject != null) {
        ((d)localObject).c((f)this);
      }
      AppMethodBeat.o(265103);
    }
    
    public final void resume()
    {
      AppMethodBeat.i(265095);
      Log.i("MicroMsg.SurfaceApp.FrameSetManager", "FrameSetRoot#" + str + " resume: " + this.eug);
      Object localObject1 = e.SLi;
      localObject1 = e.hBR();
      if (localObject1 != null) {
        ((d)localObject1).b((f)this);
      }
      Iterator localIterator = ((Iterable)this.SLo).iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        localObject1 = (c)e.hBT().get(localObject1);
        if (localObject1 != null)
        {
          ViewGroup localViewGroup = ((c)localObject1).mJe;
          int j = localViewGroup.getChildCount();
          if (j >= 0)
          {
            int i = 0;
            label131:
            localObject1 = localViewGroup.getChildAt(i);
            if ((localObject1 instanceof MagicBrushView)) {}
            for (localObject1 = (MagicBrushView)localObject1;; localObject1 = null)
            {
              if (localObject1 != null)
              {
                Object localObject2 = e.SLi;
                localObject2 = e.hBR();
                if (localObject2 != null) {
                  ((d)localObject2).bd(((MagicBrushView)localObject1).getVirtualElementId(), ((MagicBrushView)localObject1).getMeasuredWidth(), ((MagicBrushView)localObject1).getMeasuredHeight());
                }
              }
              if (i == j) {
                break;
              }
              i += 1;
              break label131;
            }
          }
        }
      }
      AppMethodBeat.o(265095);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.c.e
 * JD-Core Version:    0.7.0.1
 */