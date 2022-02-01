package com.tencent.mm.plugin.talkroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.f.a.yw;
import com.tencent.mm.f.a.yz;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.talkroom.model.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;

public class Plugin
  implements d
{
  public Plugin()
  {
    AppMethodBeat.i(29370);
    EventCenter.instance.addListener(new IListener() {});
    EventCenter.instance.addListener(new Plugin.b((byte)0));
    EventCenter.instance.addListener(new a((byte)0));
    EventCenter.instance.addListener(new c((byte)0));
    AppMethodBeat.o(29370);
  }
  
  public n createApplication()
  {
    AppMethodBeat.i(29371);
    a locala = new a();
    AppMethodBeat.o(29371);
    return locala;
  }
  
  public be createSubCore()
  {
    AppMethodBeat.i(29372);
    b localb = new b();
    AppMethodBeat.o(29372);
    return localb;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
  
  final class a
    extends IListener<yw>
  {
    private a()
    {
      AppMethodBeat.i(161452);
      this.__eventId = yw.class.getName().hashCode();
      AppMethodBeat.o(161452);
    }
  }
  
  final class c
    extends IListener<yz>
  {
    private c()
    {
      AppMethodBeat.i(161456);
      this.__eventId = yz.class.getName().hashCode();
      AppMethodBeat.o(161456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.Plugin
 * JD-Core Version:    0.7.0.1
 */