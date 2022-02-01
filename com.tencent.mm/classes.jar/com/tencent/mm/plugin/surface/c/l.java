package com.tencent.mm.plugin.surface.c;

import com.tencent.magicbrush.a.b.a;
import com.tencent.magicbrush.an;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.g;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/render/SurfaceMagicBrushFactory;", "", "()V", "MAX_HEIGHT", "", "MAX_WIDTH", "TAG", "", "create", "Lcom/tencent/magicbrush/MagicBrush;", "service", "Lcom/tencent/mm/plugin/surface/render/RenderService;", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l SLC;
  
  static
  {
    AppMethodBeat.i(265062);
    SLC = new l();
    com.tencent.magicbrush.a.b.a((b.a)new b.a()
    {
      public final String fX(String paramAnonymousString)
      {
        AppMethodBeat.i(265018);
        s.checkNotNull(paramAnonymousString);
        paramAnonymousString = k.fX(paramAnonymousString);
        s.s(paramAnonymousString, "find(libName!!)");
        AppMethodBeat.o(265018);
        return paramAnonymousString;
      }
      
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(265013);
        s.checkNotNull(paramAnonymousString);
        k.load(paramAnonymousString);
        AppMethodBeat.o(265013);
      }
    });
    new d().aoW();
    AppMethodBeat.o(265062);
  }
  
  public static com.tencent.magicbrush.e c(j paramj)
  {
    AppMethodBeat.i(265055);
    s.u(paramj, "service");
    Object localObject2 = paramj.getJsRuntime();
    Object localObject1 = new f();
    Log.i("MicroMsg.SurfaceApp.SurfaceMagicBrushFactory", "init magicBrush");
    ((g)localObject1).context = MMApplicationContext.getContext();
    ((f)localObject1).bf(h.getDevicePixelRatio());
    ((g)localObject1).eHO = ((kotlin.g.a.a)new a((i)localObject2));
    ((g)localObject1).eHN = ((com.tencent.magicbrush.handler.a)new l.b((i)localObject2));
    ((f)localObject1).b(a.b.eKw);
    localObject2 = com.tencent.mm.loader.i.b.bmz();
    s.s(localObject2, "DATAROOT_SDCARD_PATH()");
    ((f)localObject1).fW((String)localObject2);
    ((f)localObject1).dn(false);
    localObject1 = ((f)localObject1).avz();
    s.checkNotNull(localObject1);
    ((com.tencent.magicbrush.e)localObject1).eHA.q((kotlin.g.a.b)new l.c(paramj));
    AppMethodBeat.o(265055);
    return localObject1;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<an>
  {
    a(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/surface/render/SurfaceMagicBrushFactory$mbLogDelegateRegistry$1", "Lcom/tencent/luggage/game/handler/MBLogDelegateRegistry;", "loadNativeLibs", "", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends com.tencent.luggage.game.b.e
  {
    public final void aoX()
    {
      AppMethodBeat.i(265071);
      super.aoX();
      com.tencent.magicbrush.a.b.loadLibrary("gamelog_delegate");
      AppMethodBeat.o(265071);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.c.l
 * JD-Core Version:    0.7.0.1
 */