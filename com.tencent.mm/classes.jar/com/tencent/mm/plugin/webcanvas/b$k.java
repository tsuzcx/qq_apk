package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import kotlinx.a.b;
import kotlinx.a.b.ab;
import kotlinx.a.b.as;
import kotlinx.a.b.ba;
import kotlinx.a.b.bf;
import kotlinx.a.b.u;
import kotlinx.a.h;
import kotlinx.a.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$LayoutCache;", "", "seen1", "", "canvasId", "", "height", "width", "left", "top", "layout", "serializationConstructorMarker", "Lkotlinx/serialization/SerializationConstructorMarker;", "(ILjava/lang/String;IIIILjava/lang/String;Lkotlinx/serialization/SerializationConstructorMarker;)V", "(Ljava/lang/String;IIIILjava/lang/String;)V", "getCanvasId", "()Ljava/lang/String;", "setCanvasId", "(Ljava/lang/String;)V", "getHeight", "()I", "setHeight", "(I)V", "getLayout", "setLayout", "getLeft", "setLeft", "getTop", "setTop", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "$serializer", "Companion", "webview-sdk_release"})
public final class b$k
{
  public static final b DyD;
  String DyC;
  int height;
  private String ktn;
  private int left;
  private int top;
  int width;
  
  static
  {
    AppMethodBeat.i(214065);
    DyD = new b((byte)0);
    AppMethodBeat.o(214065);
  }
  
  public b$k(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(214064);
    this.ktn = paramString1;
    this.height = paramInt1;
    this.width = paramInt2;
    this.left = paramInt3;
    this.top = paramInt4;
    this.DyC = paramString2;
    AppMethodBeat.o(214064);
  }
  
  public static final void a(k paramk, b paramb, n paramn)
  {
    int j = 1;
    AppMethodBeat.i(214070);
    p.h(paramk, "self");
    p.h(paramb, "output");
    p.h(paramn, "serialDesc");
    paramb.a(paramn, paramk.ktn);
    paramb.a(paramn, 1, paramk.height);
    if (paramk.width != 0)
    {
      i = 1;
      if ((i != 0) || (paramb.c(paramn))) {
        paramb.a(paramn, 2, paramk.width);
      }
      if (paramk.left == 0) {
        break label206;
      }
      i = 1;
      label93:
      if ((i != 0) || (paramb.c(paramn))) {
        paramb.a(paramn, 3, paramk.left);
      }
      if (paramk.top == 0) {
        break label211;
      }
    }
    label206:
    label211:
    for (int i = j;; i = 0)
    {
      if ((i != 0) || (paramb.c(paramn))) {
        paramb.a(paramn, 4, paramk.top);
      }
      if (((p.i(paramk.DyC, null) ^ true)) || (paramb.c(paramn))) {
        paramb.a(paramn, (h)bf.NMU, paramk.DyC);
      }
      AppMethodBeat.o(214070);
      return;
      i = 0;
      break;
      i = 0;
      break label93;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(214068);
    if (this != paramObject)
    {
      if ((paramObject instanceof k))
      {
        paramObject = (k)paramObject;
        if ((!p.i(this.ktn, paramObject.ktn)) || (this.height != paramObject.height) || (this.width != paramObject.width) || (this.left != paramObject.left) || (this.top != paramObject.top) || (!p.i(this.DyC, paramObject.DyC))) {}
      }
    }
    else
    {
      AppMethodBeat.o(214068);
      return true;
    }
    AppMethodBeat.o(214068);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(214067);
    String str = this.ktn;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int k = this.height;
      int m = this.width;
      int n = this.left;
      int i1 = this.top;
      str = this.DyC;
      if (str != null) {
        j = str.hashCode();
      }
      AppMethodBeat.o(214067);
      return ((((i * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(214066);
    String str = "LayoutCache(canvasId=" + this.ktn + ", height=" + this.height + ", width=" + this.width + ", left=" + this.left + ", top=" + this.top + ", layout=" + this.DyC + ")";
    AppMethodBeat.o(214066);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine.LayoutCache.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$LayoutCache;", "()V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/Encoder;", "value", "webview-sdk_release"})
  public static final class a
    implements u<b.k>
  {
    public static final a DyE;
    
    static
    {
      AppMethodBeat.i(214059);
      DyE = new a();
      ba localba = new ba("com.tencent.mm.plugin.webcanvas.WebCanvasJsEngine.LayoutCache", (u)DyE);
      localba.dw("canvasId", false);
      localba.dw("height", false);
      localba.dw("width", true);
      localba.dw("left", true);
      localba.dw("top", true);
      localba.dw("layout", true);
      DyF = localba;
      AppMethodBeat.o(214059);
    }
    
    public final n eLj()
    {
      return DyF;
    }
    
    public final h<?>[] eLk()
    {
      AppMethodBeat.i(214063);
      h localh1 = (h)bf.NMU;
      h localh2 = (h)ab.NMs;
      h localh3 = (h)ab.NMs;
      h localh4 = (h)ab.NMs;
      h localh5 = (h)ab.NMs;
      h localh6 = (h)bf.NMU;
      p.h(localh6, "actualSerializer");
      localh6 = (h)new as(localh6);
      AppMethodBeat.o(214063);
      return new h[] { localh1, localh2, localh3, localh4, localh5, localh6 };
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$LayoutCache$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$LayoutCache;", "webview-sdk_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.b.k
 * JD-Core Version:    0.7.0.1
 */