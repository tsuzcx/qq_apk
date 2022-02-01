package com.tencent.mm.plugin.mv;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.autogen.a.nv;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.mv.model.i;
import com.tencent.mm.plugin.mv.model.l;
import com.tencent.mm.plugin.textstatus.a.n;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/PluginMv;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/mv/IPluginMv;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "floatBallEventIListener", "com/tencent/mm/plugin/mv/PluginMv$floatBallEventIListener$1", "Lcom/tencent/mm/plugin/mv/PluginMv$floatBallEventIListener$1;", "localResUpdateListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LocalCheckResUpdateCacheFileEvent;", "getLocalResUpdateListener", "()Lcom/tencent/mm/sdk/event/IListener;", "resUpdateListener", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "getResUpdateListener", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "handleAppIconZip", "filePath", "handleDefaultVideoZip", "handlePagZip", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginMv
  extends com.tencent.mm.kernel.b.f
  implements c, a
{
  private final a LRx;
  private final IListener<cd> LRy;
  private final String TAG;
  private final IListener<nv> vzY;
  
  public PluginMv()
  {
    AppMethodBeat.i(285984);
    this.TAG = "MicroMsg.Mv.PluginMv";
    this.LRx = new a();
    this.LRy = ((IListener)new IListener(com.tencent.mm.app.f.hfK) {});
    this.vzY = ((IListener)new IListener(com.tencent.mm.app.f.hfK) {});
    AppMethodBeat.o(285984);
  }
  
  public final void execute(g paramg) {}
  
  public final IListener<nv> getLocalResUpdateListener()
  {
    return this.vzY;
  }
  
  public final IListener<cd> getResUpdateListener()
  {
    return this.LRy;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void handleAppIconZip(String paramString)
  {
    AppMethodBeat.i(286023);
    kotlin.g.b.s.u(paramString, "filePath");
    Log.i(this.TAG, "start to handle app icon " + paramString + ' ' + y.bEl(paramString));
    d.e("Thread.Music", (kotlin.g.a.a)new b(paramString, this));
    AppMethodBeat.o(286023);
  }
  
  public final void handleDefaultVideoZip(String paramString)
  {
    AppMethodBeat.i(286010);
    kotlin.g.b.s.u(paramString, "filePath");
    Log.i(this.TAG, "start to handle default video " + paramString + ' ' + y.bEl(paramString));
    d.e("Thread.Music", (kotlin.g.a.a)new c(paramString, this));
    AppMethodBeat.o(286010);
  }
  
  public final void handlePagZip(String paramString)
  {
    AppMethodBeat.i(286016);
    kotlin.g.b.s.u(paramString, "filePath");
    Log.i(this.TAG, "start to handle pag " + paramString + ' ' + y.bEl(paramString));
    d.e("Thread.Music", (kotlin.g.a.a)new d(paramString, this));
    AppMethodBeat.o(286016);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(285996);
    this.LRy.alive();
    this.vzY.alive();
    paramc = i.LXD;
    i.init();
    paramc = l.LXJ;
    Log.i("MicroMsg.Mv.MvChattingDataManger", "onInit");
    com.tencent.mm.kernel.h.aZW().a(6893, (com.tencent.mm.am.h)paramc);
    com.tencent.mm.kernel.h.aZW().a(6820, (com.tencent.mm.am.h)paramc);
    com.tencent.mm.kernel.h.aZW().a(6672, (com.tencent.mm.am.h)paramc);
    ((b)com.tencent.mm.kernel.h.ax(b.class)).a(23, (com.tencent.mm.plugin.ball.c.e)this.LRx);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).a("1", (o)new com.tencent.mm.plugin.mv.jump.e());
    AppMethodBeat.o(285996);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(286001);
    this.LRy.dead();
    this.vzY.dead();
    Object localObject = i.LXD;
    i.destroy();
    localObject = l.LXJ;
    Log.i("MicroMsg.Mv.MvChattingDataManger", "onDestroy");
    com.tencent.mm.kernel.h.aZW().b(6893, (com.tencent.mm.am.h)localObject);
    com.tencent.mm.kernel.h.aZW().b(6820, (com.tencent.mm.am.h)localObject);
    com.tencent.mm.kernel.h.aZW().b(6672, (com.tencent.mm.am.h)localObject);
    ((b)com.tencent.mm.kernel.h.ax(b.class)).b(23, (com.tencent.mm.plugin.ball.c.e)this.LRx);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bdp("1");
    AppMethodBeat.o(286001);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/PluginMv$floatBallEventIListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListener;", "onAddMessageFloatBall", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "onFloatBallInfoAdded", "", "onFloatBallInfoClicked", "onFloatBallInfoExposed", "onFloatBallInfoRemoved", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.plugin.ball.c.e
  {
    public final void b(BallInfo paramBallInfo) {}
    
    public final void c(BallInfo paramBallInfo)
    {
      Object localObject = null;
      AppMethodBeat.i(285979);
      paramBallInfo = l.LXJ;
      StringBuilder localStringBuilder = new StringBuilder("onMusicStop, songName:");
      paramBallInfo = l.LWI;
      if (paramBallInfo == null)
      {
        paramBallInfo = null;
        localStringBuilder = localStringBuilder.append(paramBallInfo).append(", singer:");
        paramBallInfo = l.LWI;
        if (paramBallInfo != null) {
          break label92;
        }
      }
      label92:
      for (paramBallInfo = localObject;; paramBallInfo = paramBallInfo.rDl)
      {
        Log.i("MicroMsg.Mv.MvChattingDataManger", paramBallInfo);
        l.LYa = 2;
        if (!l.LYb) {
          l.gpI();
        }
        AppMethodBeat.o(285979);
        return;
        paramBallInfo = paramBallInfo.songName;
        break;
      }
    }
    
    public final boolean coy()
    {
      return false;
    }
    
    public final void d(BallInfo paramBallInfo) {}
    
    public final void g(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(285987);
      paramBallInfo = l.LXJ;
      l.gpH();
      AppMethodBeat.o(285987);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(String paramString, PluginMv paramPluginMv)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(String paramString, PluginMv paramPluginMv)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(String paramString, PluginMv paramPluginMv)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.PluginMv
 * JD-Core Version:    0.7.0.1
 */