package com.tencent.mm.plugin.talkroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.la;
import com.tencent.mm.g.a.vs;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.talkroom.model.b;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

public class Plugin
  implements d
{
  public Plugin()
  {
    AppMethodBeat.i(29370);
    com.tencent.mm.sdk.b.a.GpY.c(new com.tencent.mm.sdk.b.c() {});
    com.tencent.mm.sdk.b.a.GpY.c(new b((byte)0));
    com.tencent.mm.sdk.b.a.GpY.c(new a((byte)0));
    com.tencent.mm.sdk.b.a.GpY.c(new c((byte)0));
    AppMethodBeat.o(29370);
  }
  
  public m createApplication()
  {
    AppMethodBeat.i(29371);
    a locala = new a();
    AppMethodBeat.o(29371);
    return locala;
  }
  
  public aw createSubCore()
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
    extends com.tencent.mm.sdk.b.c<vs>
  {
    private a()
    {
      AppMethodBeat.i(161452);
      this.__eventId = vs.class.getName().hashCode();
      AppMethodBeat.o(161452);
    }
  }
  
  static final class b
    extends com.tencent.mm.sdk.b.c<vt>
  {
    private b()
    {
      AppMethodBeat.i(161454);
      this.__eventId = vt.class.getName().hashCode();
      AppMethodBeat.o(161454);
    }
  }
  
  final class c
    extends com.tencent.mm.sdk.b.c<vv>
  {
    private c()
    {
      AppMethodBeat.i(161456);
      this.__eventId = vv.class.getName().hashCode();
      AppMethodBeat.o(161456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.Plugin
 * JD-Core Version:    0.7.0.1
 */