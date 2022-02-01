package com.tencent.mm.plugin.teenmode.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.teenmode.a.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/model/AuthorizationReqCallbackMgr;", "", "()V", "TAG", "", "map", "", "Lcom/tencent/mm/plugin/teenmode/api/ITeenModeService$AuthorizationReqResultCallback;", "getMap", "()Ljava/util/Map;", "map$delegate", "Lkotlin/Lazy;", "addCallback", "", "bizType", "", "bizKey", "callback", "canGoOn", "", "genKey", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final j SYA;
  public static final a SYz;
  
  static
  {
    AppMethodBeat.i(278910);
    SYz = new a();
    SYA = k.cm((kotlin.g.a.a)b.SYF);
    AppMethodBeat.o(278910);
  }
  
  public static void a(int paramInt, String paramString, d.a parama)
  {
    AppMethodBeat.i(278888);
    s.u(paramString, "bizKey");
    if (parama == null)
    {
      AppMethodBeat.o(278888);
      return;
    }
    Log.i("MicroMsg.AuthorizationReqCallbackMgr", "addCallback bizType:" + paramInt + " bizKey:" + paramString);
    aiG().put(dp(paramInt, paramString), parama);
    AppMethodBeat.o(278888);
  }
  
  private static Map<String, d.a> aiG()
  {
    AppMethodBeat.i(278878);
    Map localMap = (Map)SYA.getValue();
    AppMethodBeat.o(278878);
    return localMap;
  }
  
  private static String dp(int paramInt, String paramString)
  {
    AppMethodBeat.i(278903);
    paramString = paramInt + '#' + paramString;
    AppMethodBeat.o(278903);
    return paramString;
  }
  
  public static void j(final int paramInt, final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(278899);
    if (paramString == null)
    {
      AppMethodBeat.o(278899);
      return;
    }
    String str = dp(paramInt, paramString);
    d.a locala = (d.a)aiG().get(str);
    if (locala != null)
    {
      Log.i("MicroMsg.AuthorizationReqCallbackMgr", "callback bizType:" + paramInt + " bizKey:" + paramString + " canGoOn:" + paramBoolean);
      d.d("AuthorizationReqCallbackMgr", (kotlin.g.a.a)new a(locala, paramInt, paramString, paramBoolean));
      aiG().remove(str);
    }
    AppMethodBeat.o(278899);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(d.a parama, int paramInt, String paramString, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", "Lcom/tencent/mm/plugin/teenmode/api/ITeenModeService$AuthorizationReqResultCallback;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Map<String, d.a>>
  {
    public static final b SYF;
    
    static
    {
      AppMethodBeat.i(278909);
      SYF = new b();
      AppMethodBeat.o(278909);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.a
 * JD-Core Version:    0.7.0.1
 */