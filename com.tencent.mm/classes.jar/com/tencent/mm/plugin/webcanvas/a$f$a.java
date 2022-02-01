package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.b.ab;
import kotlinx.a.b.as;
import kotlinx.a.b.ba;
import kotlinx.a.b.bf;
import kotlinx.a.b.u;
import kotlinx.a.h;
import kotlinx.a.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webcanvas/WebCanvasContext.LayoutCache.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache;", "()V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/Encoder;", "value", "webview-sdk_release"})
public final class a$f$a
  implements u<a.f>
{
  public static final a Izr;
  
  static
  {
    AppMethodBeat.i(224566);
    Izr = new a();
    ba localba = new ba("com.tencent.mm.plugin.webcanvas.WebCanvasContext.LayoutCache", (u)Izr);
    localba.dV("canvasId", false);
    localba.dV("height", false);
    localba.dV("width", true);
    localba.dV("left", true);
    localba.dV("top", true);
    localba.dV("layout", true);
    Izs = localba;
    AppMethodBeat.o(224566);
  }
  
  public final n fWv()
  {
    return Izs;
  }
  
  public final h<?>[] fWw()
  {
    AppMethodBeat.i(224570);
    h localh1 = (h)bf.TYV;
    h localh2 = (h)ab.TYt;
    h localh3 = (h)ab.TYt;
    h localh4 = (h)ab.TYt;
    h localh5 = (h)ab.TYt;
    h localh6 = (h)bf.TYV;
    p.h(localh6, "actualSerializer");
    localh6 = (h)new as(localh6);
    AppMethodBeat.o(224570);
    return new h[] { localh1, localh2, localh3, localh4, localh5, localh6 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.a.f.a
 * JD-Core Version:    0.7.0.1
 */