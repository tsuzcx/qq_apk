package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.musicchat.a.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/app/AppMsgMusicSender;", "Lcom/tencent/mm/plugin/musicchat/api/IPluginSendMusicToChat;", "userName", "", "(Ljava/lang/String;)V", "getChatUserName", "sendMusic", "", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  implements b
{
  private final String userName;
  
  public o(String paramString)
  {
    AppMethodBeat.i(244890);
    this.userName = paramString;
    AppMethodBeat.o(244890);
  }
  
  public final void f(k.b paramb)
  {
    AppMethodBeat.i(244894);
    s.u(paramb, "content");
    n.a(k.b.a(paramb), paramb.appId, paramb.appName, this.userName, "", null);
    AppMethodBeat.o(244894);
  }
  
  public final String gpc()
  {
    return this.userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.o
 * JD-Core Version:    0.7.0.1
 */