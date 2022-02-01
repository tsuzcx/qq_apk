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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webcanvas/WebCanvasContext.LayoutCache.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache;", "()V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/Encoder;", "value", "webview-sdk_release"})
public final class a$f$a
  implements u<a.f>
{
  public static final a Ptv;
  
  static
  {
    AppMethodBeat.i(205284);
    Ptv = new a();
    ba localba = new ba("com.tencent.mm.plugin.webcanvas.WebCanvasContext.LayoutCache", (u)Ptv);
    localba.ei("canvasId", false);
    localba.ei("height", false);
    localba.ei("width", true);
    localba.ei("left", true);
    localba.ei("top", true);
    localba.ei("layout", true);
    Ptw = localba;
    AppMethodBeat.o(205284);
  }
  
  public final n gPe()
  {
    return Ptw;
  }
  
  public final h<?>[] gPf()
  {
    AppMethodBeat.i(205292);
    h localh1 = (h)bf.abCk;
    h localh2 = (h)ab.abBI;
    h localh3 = (h)ab.abBI;
    h localh4 = (h)ab.abBI;
    h localh5 = (h)ab.abBI;
    h localh6 = (h)bf.abCk;
    p.k(localh6, "actualSerializer");
    localh6 = (h)new as(localh6);
    AppMethodBeat.o(205292);
    return new h[] { localh1, localh2, localh3, localh4, localh5, localh6 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.a.f.a
 * JD-Core Version:    0.7.0.1
 */