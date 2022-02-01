package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlinx.a.a.a;
import kotlinx.a.b;
import kotlinx.a.b.e;
import kotlinx.a.d.ag;
import kotlinx.a.d.ah;
import kotlinx.a.d.al;
import kotlinx.a.d.k;
import kotlinx.a.d.p;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/webcanvas/WebCanvasContext.LayoutCache.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$f$a
  implements k<a.f>
{
  public static final a Wkh;
  
  static
  {
    AppMethodBeat.i(261293);
    Wkh = new a();
    ag localag = new ag("com.tencent.mm.plugin.webcanvas.WebCanvasContext.LayoutCache", (k)Wkh);
    localag.eX("canvasId", false);
    localag.eX("height", false);
    localag.eX("width", true);
    localag.eX("left", true);
    localag.eX("top", true);
    localag.eX("layout", true);
    Wki = (e)localag;
    AppMethodBeat.o(261293);
  }
  
  public final b<?>[] iot()
  {
    return ah.ajDR;
  }
  
  public final e iou()
  {
    return Wki;
  }
  
  public final b<?>[] iov()
  {
    AppMethodBeat.i(261319);
    b localb1 = (b)al.ajDU;
    b localb2 = (b)p.ajDv;
    b localb3 = (b)p.ajDv;
    b localb4 = (b)p.ajDv;
    b localb5 = (b)p.ajDv;
    b localb6 = a.a((b)al.ajDU);
    AppMethodBeat.o(261319);
    return new b[] { localb1, localb2, localb3, localb4, localb5, localb6 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.a.f.a
 * JD-Core Version:    0.7.0.1
 */