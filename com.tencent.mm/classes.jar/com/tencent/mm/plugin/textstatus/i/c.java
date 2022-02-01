package com.tencent.mm.plugin.textstatus.i;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.textstatus.g.r;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/third/LiveSingleton;", "Lcom/tencent/mm/plugin/textstatus/third/ISpecialViewSingleton;", "()V", "liveStatusListener", "com/tencent/mm/plugin/textstatus/third/LiveSingleton$liveStatusListener$1", "Lcom/tencent/mm/plugin/textstatus/third/LiveSingleton$liveStatusListener$1;", "viewCache", "Ljava/util/HashMap;", "", "Ljava/lang/ref/SoftReference;", "Lkotlin/Pair;", "Landroid/view/View;", "Lkotlin/Function0;", "", "Lkotlin/collections/HashMap;", "getView", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getViewAndRefresh", "refreshCallback", "refreshLiveStatue", "liveId", "liveStatus", "", "release", "Companion", "plugin-textstatus_release"})
public final class c
  implements b
{
  public static final a Gcn;
  private static final String TAG = "Third.LiveSingleton";
  private HashMap<String, SoftReference<o<View, a<x>>>> Gcl;
  private final b Gcm;
  
  static
  {
    AppMethodBeat.i(216338);
    Gcn = new a((byte)0);
    TAG = "Third.LiveSingleton";
    AppMethodBeat.o(216338);
  }
  
  public c()
  {
    AppMethodBeat.i(216337);
    this.Gcl = new HashMap();
    this.Gcm = new b(this);
    this.Gcm.alive();
    AppMethodBeat.o(216337);
  }
  
  public final View a(r paramr)
  {
    AppMethodBeat.i(216334);
    p.h(paramr, "jumpInfo");
    Log.i(TAG, "getView jumpType:" + paramr.GaO);
    if (p.j(paramr.GaO, "2"))
    {
      paramr = new ImageView(MMApplicationContext.getContext());
      Context localContext = MMApplicationContext.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      paramr.setImageDrawable(localContext.getResources().getDrawable(2131690266));
      paramr = (View)paramr;
      AppMethodBeat.o(216334);
      return paramr;
    }
    AppMethodBeat.o(216334);
    return null;
  }
  
  public final View a(r paramr, a<x> parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(216335);
    p.h(paramr, "jumpInfo");
    p.h(parama, "refreshCallback");
    Log.i(TAG, "getViewAndRefresh jumpType:" + paramr.GaO);
    Object localObject1 = localObject2;
    if (p.j(paramr.GaO, "2"))
    {
      d locald = new d();
      locald.j("", XmlParser.parseXml(paramr.GaQ, "finderLive", null));
      localObject1 = localObject2;
      if (this.Gcl.get(locald.jlf.hJs) == null)
      {
        localObject1 = (View)new ImageView(MMApplicationContext.getContext());
        paramr = (ImageView)localObject1;
        localObject2 = MMApplicationContext.getContext();
        p.g(localObject2, "MMApplicationContext.getContext()");
        paramr.setImageDrawable(((Context)localObject2).getResources().getDrawable(2131690266));
        paramr = (Map)this.Gcl;
        localObject2 = locald.jlf.hJs;
        p.g(localObject2, "shareLiveInfo.shareLive.liveId");
        paramr.put(localObject2, new SoftReference(new o(localObject1, parama)));
      }
    }
    AppMethodBeat.o(216335);
    return localObject1;
  }
  
  public final void b(r paramr)
  {
    AppMethodBeat.i(216336);
    p.h(paramr, "jumpInfo");
    Log.i(TAG, "release jumpType:" + paramr.GaO);
    if (p.j(paramr.GaO, "2"))
    {
      d locald = new d();
      locald.j("", XmlParser.parseXml(paramr.GaQ, "finderLive", null));
      Log.i(TAG, "release liveId:" + locald.jlf.hJs);
      this.Gcl.remove(locald.jlf.hJs);
    }
    AppMethodBeat.o(216336);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/third/LiveSingleton$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-textstatus_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/third/LiveSingleton$liveStatusListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-textstatus_release"})
  public static final class b
    extends IListener<hn>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/textstatus/third/LiveSingleton$liveStatusListener$1$callback$1$1"})
    static final class a
      extends q
      implements a<x>
    {
      a(c.b paramb, hn paramhn)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.i.c
 * JD-Core Version:    0.7.0.1
 */