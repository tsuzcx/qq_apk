package com.tencent.mm.plugin.secdata;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/secdata/DefaultSecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/plugin/secdata/ISecData;", "clazz", "Ljava/lang/Class;", "type", "", "(Ljava/lang/Class;I)V", "getClazz", "()Ljava/lang/Class;", "data", "getData", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "data$delegate", "Lkotlin/Lazy;", "check", "", "intent", "Landroid/content/Intent;", "getTransformData", "getType", "plugin-sec-data_release"})
public final class e<T extends com.tencent.mm.bw.a>
  implements h<T>
{
  private final f CVQ;
  final Class<T> aWC;
  private final int type;
  
  public e(Class<T> paramClass, int paramInt)
  {
    AppMethodBeat.i(219147);
    this.aWC = paramClass;
    this.type = paramInt;
    this.CVQ = g.ah((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(219147);
  }
  
  public final boolean aS(Intent paramIntent)
  {
    return false;
  }
  
  public final T eSl()
  {
    AppMethodBeat.i(219146);
    com.tencent.mm.bw.a locala = (com.tencent.mm.bw.a)this.CVQ.getValue();
    p.g(locala, "data");
    AppMethodBeat.o(219146);
    return locala;
  }
  
  public final boolean eSm()
  {
    return true;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;"})
  static final class a
    extends q
    implements kotlin.g.a.a<T>
  {
    a(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.e
 * JD-Core Version:    0.7.0.1
 */