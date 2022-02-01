package com.tencent.mm.plugin.mv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.bu;
import com.tencent.mm.f.a.mo;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/PluginMv;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/mv/IPluginMv;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "floatBallEventIListener", "com/tencent/mm/plugin/mv/PluginMv$floatBallEventIListener$1", "Lcom/tencent/mm/plugin/mv/PluginMv$floatBallEventIListener$1;", "localResUpdateListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LocalCheckResUpdateCacheFileEvent;", "getLocalResUpdateListener", "()Lcom/tencent/mm/sdk/event/IListener;", "resUpdateListener", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "getResUpdateListener", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "handleAppIconZip", "filePath", "handleDefaultVideoZip", "handlePagZip", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "plugin-mv_release"})
public final class PluginMv
  extends f
  implements c, a
{
  private final PluginMv.a FWm;
  private final IListener<bu> FWn;
  private final String TAG;
  private final IListener<mo> soa;
  
  public PluginMv()
  {
    AppMethodBeat.i(230903);
    this.TAG = "MicroMsg.Mv.PluginMv";
    this.FWm = new PluginMv.a();
    this.FWn = ((IListener)new f(this));
    this.soa = ((IListener)new e(this));
    AppMethodBeat.o(230903);
  }
  
  public final void execute(g paramg) {}
  
  public final IListener<mo> getLocalResUpdateListener()
  {
    return this.soa;
  }
  
  public final IListener<bu> getResUpdateListener()
  {
    return this.FWn;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void handleAppIconZip(final String paramString)
  {
    AppMethodBeat.i(230901);
    p.k(paramString, "filePath");
    Log.i(this.TAG, "start to handle app icon " + paramString + ' ' + u.bBQ(paramString));
    com.tencent.mm.ae.d.c("Thread.Music", (kotlin.g.a.a)new b(this, paramString));
    AppMethodBeat.o(230901);
  }
  
  public final void handleDefaultVideoZip(final String paramString)
  {
    AppMethodBeat.i(230899);
    p.k(paramString, "filePath");
    Log.i(this.TAG, "start to handle default video " + paramString + ' ' + u.bBQ(paramString));
    com.tencent.mm.ae.d.c("Thread.Music", (kotlin.g.a.a)new c(this, paramString));
    AppMethodBeat.o(230899);
  }
  
  public final void handlePagZip(final String paramString)
  {
    AppMethodBeat.i(230900);
    p.k(paramString, "filePath");
    Log.i(this.TAG, "start to handle pag " + paramString + ' ' + u.bBQ(paramString));
    com.tencent.mm.ae.d.c("Thread.Music", (kotlin.g.a.a)new d(this, paramString));
    AppMethodBeat.o(230900);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(230889);
    this.FWn.alive();
    this.soa.alive();
    paramc = com.tencent.mm.plugin.mv.model.i.GbW;
    com.tencent.mm.plugin.mv.model.i.init();
    paramc = com.tencent.mm.plugin.mv.model.l.Gcr;
    Log.i("MicroMsg.Mv.MvChattingDataManger", "onInit");
    h.aGY().a(6893, (com.tencent.mm.an.i)paramc);
    h.aGY().a(6820, (com.tencent.mm.an.i)paramc);
    h.aGY().a(6672, (com.tencent.mm.an.i)paramc);
    ((b)h.ae(b.class)).a(23, (e)this.FWm);
    ((com.tencent.mm.plugin.textstatus.a.l)h.ae(com.tencent.mm.plugin.textstatus.a.l.class)).a("1", (m)new com.tencent.mm.plugin.mv.a.d());
    AppMethodBeat.o(230889);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(230894);
    this.FWn.dead();
    this.soa.dead();
    Object localObject = com.tencent.mm.plugin.mv.model.i.GbW;
    com.tencent.mm.plugin.mv.model.i.destroy();
    localObject = com.tencent.mm.plugin.mv.model.l.Gcr;
    Log.i("MicroMsg.Mv.MvChattingDataManger", "onDestroy");
    h.aGY().b(6893, (com.tencent.mm.an.i)localObject);
    h.aGY().b(6820, (com.tencent.mm.an.i)localObject);
    h.aGY().b(6672, (com.tencent.mm.an.i)localObject);
    ((b)h.ae(b.class)).b(23, (e)this.FWm);
    ((com.tencent.mm.plugin.textstatus.a.l)h.ae(com.tencent.mm.plugin.textstatus.a.l.class)).beb("1");
    AppMethodBeat.o(230894);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(PluginMv paramPluginMv, String paramString)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(PluginMv paramPluginMv, String paramString)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(PluginMv paramPluginMv, String paramString)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/PluginMv$localResUpdateListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LocalCheckResUpdateCacheFileEvent;", "callback", "", "event", "plugin-mv_release"})
  public static final class e
    extends IListener<mo>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/PluginMv$resUpdateListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "callback", "", "event", "plugin-mv_release"})
  public static final class f
    extends IListener<bu>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.PluginMv
 * JD-Core Version:    0.7.0.1
 */