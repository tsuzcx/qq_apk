package com.tencent.mm.plugin.secdata;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/secdata/AllActivitySecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/plugin/secdata/ISecData;", "clazz", "Ljava/lang/Class;", "type", "", "reuse", "", "(Ljava/lang/Class;IZ)V", "getClazz", "()Ljava/lang/Class;", "data", "getData", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "data$delegate", "Lkotlin/Lazy;", "check", "intent", "Landroid/content/Intent;", "getTransformData", "getType", "plugin-sec-data_release"})
public final class c<T extends com.tencent.mm.cd.a>
  implements h<T>
{
  private final f JbC;
  private final boolean JbE;
  final Class<T> aFS;
  private final int type;
  
  public c(Class<T> paramClass, int paramInt)
  {
    AppMethodBeat.i(197924);
    this.aFS = paramClass;
    this.type = paramInt;
    this.JbE = true;
    this.JbC = g.ar((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(197924);
  }
  
  public final boolean aR(Intent paramIntent)
  {
    return true;
  }
  
  public final T fFn()
  {
    AppMethodBeat.i(197921);
    com.tencent.mm.cd.a locala = (com.tencent.mm.cd.a)this.JbC.getValue();
    p.j(locala, "data");
    AppMethodBeat.o(197921);
    return locala;
  }
  
  public final boolean fFo()
  {
    return true;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;"})
  static final class a
    extends q
    implements kotlin.g.a.a<T>
  {
    a(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.c
 * JD-Core Version:    0.7.0.1
 */