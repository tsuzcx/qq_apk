package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.u.d;
import com.tencent.mm.plugin.u.j;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/player/VLogVideoPlayer$playerCallback$1", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "onCompletion", "", "onError", "what", "", "error", "onPrepared", "onSeekComplete", "onVideoSizeChanged", "width", "height", "degrees", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k$c
  implements d
{
  k$c(k paramk) {}
  
  public final void Qz()
  {
    AppMethodBeat.i(110990);
    Log.i("MicroMsg.VLogVideoPlayer", this.UdP.hashCode() + " onPrepared, canPlaying:" + k.b(this.UdP) + ", notify all");
    k.c(this.UdP);
    Object localObject1 = k.d(this.UdP);
    Object localObject2 = this.UdP;
    try
    {
      Log.i("MicroMsg.VLogVideoPlayer", ((k)localObject2).hashCode() + " onPrepared notifyAll");
      k.d((k)localObject2).notifyAll();
      localObject2 = ah.aiuX;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, "prepare lock notify error", new Object[0]);
      }
    }
    finally
    {
      AppMethodBeat.o(110990);
    }
  }
  
  public final void as(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(110993);
    Log.i("MicroMsg.VLogVideoPlayer", this.UdP.hashCode() + " video size changed size[%d, %d] degrees[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(110993);
  }
  
  public final void dEH()
  {
    AppMethodBeat.i(110992);
    Object localObject2 = this.UdP.hashCode() + " %s player seek done";
    Object localObject1 = k.e(this.UdP);
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      Log.d("MicroMsg.VLogVideoPlayer", (String)localObject2, new Object[] { localObject1 });
      localObject1 = k.f(this.UdP);
      localObject2 = this.UdP;
      try
      {
        Log.i("MicroMsg.VLogVideoPlayer", ((k)localObject2).hashCode() + " player seek notifyAll");
        k.f((k)localObject2).notifyAll();
        localObject2 = ah.aiuX;
        return;
        localObject1 = ((j)localObject1).info();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, ((k)localObject2).hashCode() + " notify seekLock error", new Object[0]);
        }
      }
      finally
      {
        AppMethodBeat.o(110992);
      }
    }
  }
  
  public final void onCompletion() {}
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110991);
    Log.i("MicroMsg.VLogVideoPlayer", this.UdP.hashCode() + " onError what:" + paramInt1 + " error :" + paramInt2);
    AppMethodBeat.o(110991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.k.c
 * JD-Core Version:    0.7.0.1
 */