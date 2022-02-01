package com.tencent.mm.plugin.musicchat.model;

import com.tencent.c.f.a;
import com.tencent.c.f.b;
import com.tencent.c.f.c;
import com.tencent.c.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.c;
import com.tencent.mm.aw.i;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/musicchat/model/FlutterMusicPlayerPlugin;", "Lcom/tencent/pigeon/FlutterMusicPlayerApi$MusicPlayerApi;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "()V", "TAG", "", "callback", "Lcom/tencent/pigeon/FlutterMusicPlayerApi$MusicCallbackApi;", "musicPlayerListener", "com/tencent/mm/plugin/musicchat/model/FlutterMusicPlayerPlugin$musicPlayerListener$1", "Lcom/tencent/mm/plugin/musicchat/model/FlutterMusicPlayerPlugin$musicPlayerListener$1;", "getCurrentMusic", "Lcom/tencent/pigeon/FlutterMusicPlayerApi$FlutterMusicInfo;", "getCurrentPosition", "Lcom/tencent/pigeon/FlutterMusicPlayerApi$FLMusicIntType;", "getDuration", "onAttachedToEngine", "", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "onPausePlay", "info", "onResumePlay", "onStartPlay", "onStopPlay", "pause", "play", "resume", "seek", "time", "stop", "toFlutterMusicInfo", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "toWrapper", "plugin-music-chat_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends f.e
  implements FlutterPlugin
{
  private f.c LRu;
  private final FlutterMusicPlayerPlugin.musicPlayerListener.1 LRv;
  private final String TAG;
  
  public a()
  {
    AppMethodBeat.i(261409);
    this.TAG = "MicroMsg.FlutterMusicPlayerPlugin";
    this.LRv = new FlutterMusicPlayerPlugin.musicPlayerListener.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(261409);
  }
  
  private static final void k(Void paramVoid) {}
  
  private static final void l(Void paramVoid) {}
  
  private static final void m(Void paramVoid) {}
  
  private static final void n(Void paramVoid) {}
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(261503);
    if (parama == null)
    {
      AppMethodBeat.o(261503);
      return;
    }
    com.tencent.mm.aw.a.wH((int)parama.ahhF.longValue());
    AppMethodBeat.o(261503);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(261485);
    Object localObject1 = (com.tencent.mm.aw.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.aw.a.a.class);
    if (((com.tencent.mm.aw.a.a)localObject1).bLw()) {
      ((com.tencent.mm.aw.a.a)localObject1).hj(true);
    }
    Object localObject2 = this.TAG;
    if (paramb == null) {}
    for (localObject1 = null;; localObject1 = paramb.musicId)
    {
      Log.i((String)localObject2, s.X("play ", localObject1));
      if (paramb != null)
      {
        localObject1 = s.X(paramb.oOZ, "_send_music_in_chat");
        localObject2 = new dtj();
        ((dtj)localObject2).oPc = paramb.coverUrl;
        ((dtj)localObject2).RfH = paramb.coverUrl;
        ((dtj)localObject2).songName = paramb.songName;
        ((dtj)localObject2).songLyric = paramb.Mcq;
        ((dtj)localObject2).oOZ = paramb.oOZ;
        ((dtj)localObject2).YqP = paramb.coverUrl;
        localObject2 = com.tencent.mm.aw.h.a((String)localObject1, (dtj)localObject2);
        paramb = i.a(15, paramb.coverUrl, paramb.songName, paramb.rDl, paramb.rDm, "", paramb.nRx, (String)localObject1, com.tencent.mm.kernel.h.baE().mCJ, "", "", paramb.appid, (com.tencent.mm.aw.h)localObject2);
        paramb.oOY = false;
        s.s(paramb, "wrapper");
        com.tencent.mm.aw.a.c(paramb);
      }
      AppMethodBeat.o(261485);
      return;
    }
  }
  
  public final void b(f.b paramb)
  {
    AppMethodBeat.i(261533);
    if (paramb != null)
    {
      f.c localc = this.LRu;
      if (localc != null) {
        localc.a(paramb, a..ExternalSyntheticLambda2.INSTANCE);
      }
    }
    AppMethodBeat.o(261533);
  }
  
  public final void c(f.b paramb)
  {
    AppMethodBeat.i(261539);
    if (paramb != null)
    {
      f.c localc = this.LRu;
      if (localc != null) {
        localc.b(paramb, a..ExternalSyntheticLambda1.INSTANCE);
      }
    }
    AppMethodBeat.o(261539);
  }
  
  public final void d(f.b paramb)
  {
    AppMethodBeat.i(261545);
    if (paramb != null)
    {
      f.c localc = this.LRu;
      if (localc != null) {
        localc.c(paramb, a..ExternalSyntheticLambda3.INSTANCE);
      }
    }
    AppMethodBeat.o(261545);
  }
  
  public final f.b gpd()
  {
    return null;
  }
  
  public final f.a gpe()
  {
    AppMethodBeat.i(261511);
    f.a locala = new f.a();
    locala.ahhF = Long.valueOf(com.tencent.mm.aw.a.bLo().mPosition);
    AppMethodBeat.o(261511);
    return locala;
  }
  
  public final f.a gpf()
  {
    AppMethodBeat.i(261519);
    f.a locala = new f.a();
    locala.ahhF = Long.valueOf(com.tencent.mm.aw.a.bLo().cam);
    AppMethodBeat.o(261519);
    return locala;
  }
  
  public final void gpg()
  {
    AppMethodBeat.i(261525);
    f.c localc = this.LRu;
    if (localc != null) {
      localc.a(a..ExternalSyntheticLambda0.INSTANCE);
    }
    AppMethodBeat.o(261525);
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(261466);
    s.u(paramFlutterPluginBinding, "binding");
    f.e.a(paramFlutterPluginBinding.getBinaryMessenger(), (f.e)this);
    this.LRv.alive();
    this.LRu = new f.c(paramFlutterPluginBinding.getBinaryMessenger());
    AppMethodBeat.o(261466);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(261473);
    s.u(paramFlutterPluginBinding, "binding");
    f.e.a(paramFlutterPluginBinding.getBinaryMessenger(), null);
    this.LRv.dead();
    AppMethodBeat.o(261473);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(261489);
    Log.i(this.TAG, "pause: ");
    com.tencent.mm.aw.a.bLg();
    AppMethodBeat.o(261489);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(261494);
    Log.i(this.TAG, "resume: ");
    com.tencent.mm.aw.a.bLh();
    AppMethodBeat.o(261494);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(261498);
    Log.i(this.TAG, "stop: ");
    com.tencent.mm.aw.a.bLi();
    AppMethodBeat.o(261498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.musicchat.model.a
 * JD-Core Version:    0.7.0.1
 */