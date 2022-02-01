package com.tencent.mm.plugin.mv;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.mv.a.a.a;
import com.tencent.mm.plugin.mv.a.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.s;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/PluginMv;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/mv/IPluginMv;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "localResUpdateListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LocalCheckResUpdateCacheFileEvent;", "getLocalResUpdateListener", "()Lcom/tencent/mm/sdk/event/IListener;", "resUpdateListener", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "getResUpdateListener", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "handleDefaultVideoZip", "filePath", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "plugin-mv_release"})
public final class PluginMv
  extends f
  implements c, a
{
  private final IListener<bp> Ape;
  private final String TAG;
  private final IListener<lx> plI;
  
  public PluginMv()
  {
    AppMethodBeat.i(256741);
    this.TAG = "MicroMsg.Mv.PluginMv";
    this.Ape = ((IListener)new c(this));
    this.plI = ((IListener)new b(this));
    AppMethodBeat.o(256741);
  }
  
  public final void execute(g paramg) {}
  
  public final IListener<lx> getLocalResUpdateListener()
  {
    return this.plI;
  }
  
  public final IListener<bp> getResUpdateListener()
  {
    return this.Ape;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void handleDefaultVideoZip(final String paramString)
  {
    AppMethodBeat.i(256740);
    p.h(paramString, "filePath");
    Log.i(this.TAG, "start to handle " + paramString + ' ' + s.boW(paramString));
    d.c("Thread.Music", (kotlin.g.a.a)new a(this, paramString));
    AppMethodBeat.o(256740);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(256739);
    paramc = h.Aqi;
    h.destroy();
    paramc = com.tencent.mm.plugin.mv.a.a.Apj;
    paramc = (Iterable)com.tencent.mm.plugin.mv.a.a.evw();
    int i;
    if ((!(paramc instanceof Collection)) || (!((Collection)paramc).isEmpty()))
    {
      paramc = paramc.iterator();
      if (paramc.hasNext()) {
        if (!s.YS(((com.tencent.mm.plugin.mv.a.a)paramc.next()).getFilePath()))
        {
          i = 1;
          label78:
          if (i == 0) {
            break label158;
          }
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      Log.i(com.tencent.mm.plugin.mv.a.a.access$getTAG$cp(), "checkCopyAssets needCopy:".concat(String.valueOf(bool)));
      if (bool)
      {
        paramc = MMApplicationContext.getContext();
        p.g(paramc, "MMApplicationContext.getContext()");
        paramc = paramc.getAssets();
        p.g(paramc, "MMApplicationContext.getContext().assets");
        a.a.a(paramc, "mv_video", com.tencent.mm.plugin.mv.a.a.evv());
      }
      this.Ape.alive();
      this.plI.alive();
      AppMethodBeat.o(256739);
      return;
      i = 0;
      break label78;
      label158:
      break;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(256738);
    this.Ape.dead();
    this.plI.dead();
    h localh = h.Aqi;
    h.init();
    AppMethodBeat.o(256738);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(PluginMv paramPluginMv, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/PluginMv$localResUpdateListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LocalCheckResUpdateCacheFileEvent;", "callback", "", "event", "plugin-mv_release"})
  public static final class b
    extends IListener<lx>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/PluginMv$resUpdateListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "callback", "", "event", "plugin-mv_release"})
  public static final class c
    extends IListener<bp>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.PluginMv
 * JD-Core Version:    0.7.0.1
 */