package com.tencent.mm.plugin.talkroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.wl;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.a.wo;
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.talkroom.model.b;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public Plugin()
  {
    AppMethodBeat.i(29370);
    com.tencent.mm.sdk.b.a.IbL.c(new com.tencent.mm.sdk.b.c() {});
    com.tencent.mm.sdk.b.a.IbL.c(new b((byte)0));
    com.tencent.mm.sdk.b.a.IbL.c(new a((byte)0));
    com.tencent.mm.sdk.b.a.IbL.c(new c((byte)0));
    AppMethodBeat.o(29370);
  }
  
  public n createApplication()
  {
    AppMethodBeat.i(29371);
    a locala = new a();
    AppMethodBeat.o(29371);
    return locala;
  }
  
  public ax createSubCore()
  {
    AppMethodBeat.i(29372);
    b localb = new b();
    AppMethodBeat.o(29372);
    return localb;
  }
  
  public com.tencent.mm.pluginsdk.b.c getContactWidgetFactory()
  {
    return null;
  }
  
  final class a
    extends com.tencent.mm.sdk.b.c<wl>
  {
    private a()
    {
      AppMethodBeat.i(161452);
      this.__eventId = wl.class.getName().hashCode();
      AppMethodBeat.o(161452);
    }
  }
  
  static final class b
    extends com.tencent.mm.sdk.b.c<wm>
  {
    private b()
    {
      AppMethodBeat.i(161454);
      this.__eventId = wm.class.getName().hashCode();
      AppMethodBeat.o(161454);
    }
  }
  
  final class c
    extends com.tencent.mm.sdk.b.c<wo>
  {
    private c()
    {
      AppMethodBeat.i(161456);
      this.__eventId = wo.class.getName().hashCode();
      AppMethodBeat.o(161456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.Plugin
 * JD-Core Version:    0.7.0.1
 */