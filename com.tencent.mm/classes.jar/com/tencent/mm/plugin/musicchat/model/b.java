package com.tencent.mm.plugin.musicchat.model;

import com.tencent.c.g.a;
import com.tencent.c.g.c;
import com.tencent.c.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.musicchat.a.a;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/musicchat/model/FlutterSendMusicToChatPlugin;", "Lcom/tencent/pigeon/FlutterSendMusicToChatPigeon$FlutterSendMusicToChatAction;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "()V", "getChatUserName", "Lcom/tencent/pigeon/FlutterSendMusicToChatPigeon$SendMusicResponse;", "onAttachedToEngine", "", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "sendMusicToChat", "request", "Lcom/tencent/pigeon/FlutterSendMusicToChatPigeon$SendMusicRequest;", "plugin-music-chat_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends g.a
  implements FlutterPlugin
{
  public final void a(g.c paramc)
  {
    AppMethodBeat.i(261418);
    if (paramc != null)
    {
      k.b localb = new k.b();
      localb.type = 3;
      localb.title = paramc.songName;
      localb.description = paramc.rDl;
      String str = paramc.rDm;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localb.url = ((String)localObject);
      localb.nRc = "";
      str = paramc.nRx;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localb.nRx = ((String)localObject);
      localb.nRy = "";
      localb.appId = paramc.appid;
      localObject = new com.tencent.mm.pluginsdk.ui.tools.b();
      ((com.tencent.mm.pluginsdk.ui.tools.b)localObject).songAlbumUrl = paramc.coverUrl;
      ((com.tencent.mm.pluginsdk.ui.tools.b)localObject).songLyric = paramc.Mcq;
      ((com.tencent.mm.pluginsdk.ui.tools.b)localObject).oOZ = paramc.oOZ;
      ((com.tencent.mm.pluginsdk.ui.tools.b)localObject).YqP = paramc.coverUrl;
      localb.a((f)localObject);
      paramc = ((a)h.az(a.class)).getMusicSender();
      if (paramc != null) {
        paramc.f(localb);
      }
    }
    AppMethodBeat.o(261418);
  }
  
  public final g.d gph()
  {
    AppMethodBeat.i(261424);
    g.d locald = new g.d();
    locald.userName = "";
    com.tencent.mm.plugin.musicchat.a.b localb = ((a)h.az(a.class)).getMusicSender();
    if (localb != null) {
      locald.userName = localb.gpc();
    }
    AppMethodBeat.o(261424);
    return locald;
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(261429);
    s.u(paramFlutterPluginBinding, "binding");
    g.a.a(paramFlutterPluginBinding.getBinaryMessenger(), (g.a)this);
    AppMethodBeat.o(261429);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(261433);
    s.u(paramFlutterPluginBinding, "binding");
    g.a.a(paramFlutterPluginBinding.getBinaryMessenger(), null);
    AppMethodBeat.o(261433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.musicchat.model.b
 * JD-Core Version:    0.7.0.1
 */