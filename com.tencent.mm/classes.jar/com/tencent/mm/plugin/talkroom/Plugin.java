package com.tencent.mm.plugin.talkroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  public Plugin()
  {
    AppMethodBeat.i(25689);
    com.tencent.mm.sdk.b.a.ymk.c(new Plugin.1(this));
    com.tencent.mm.sdk.b.a.ymk.c(new Plugin.b((byte)0));
    com.tencent.mm.sdk.b.a.ymk.c(new Plugin.a(this, (byte)0));
    com.tencent.mm.sdk.b.a.ymk.c(new Plugin.c(this, (byte)0));
    AppMethodBeat.o(25689);
  }
  
  public o createApplication()
  {
    AppMethodBeat.i(25690);
    a locala = new a();
    AppMethodBeat.o(25690);
    return locala;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(25691);
    com.tencent.mm.plugin.talkroom.model.b localb = new com.tencent.mm.plugin.talkroom.model.b();
    AppMethodBeat.o(25691);
    return localb;
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.Plugin
 * JD-Core Version:    0.7.0.1
 */