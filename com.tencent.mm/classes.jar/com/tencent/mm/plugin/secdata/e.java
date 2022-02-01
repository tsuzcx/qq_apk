package com.tencent.mm.plugin.secdata;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/secdata/DefaultSecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/plugin/secdata/ISecData;", "clazz", "Ljava/lang/Class;", "type", "", "(Ljava/lang/Class;I)V", "getClazz", "()Ljava/lang/Class;", "data", "getData", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "data$delegate", "Lkotlin/Lazy;", "check", "", "intent", "Landroid/content/Intent;", "getTransformData", "getType", "plugin-sec-data_release"})
public final class e<T extends com.tencent.mm.cd.a>
  implements h<T>
{
  private final f JbC;
  final Class<T> aFS;
  private final int type;
  
  public e(Class<T> paramClass, int paramInt)
  {
    AppMethodBeat.i(198123);
    this.aFS = paramClass;
    this.type = paramInt;
    this.JbC = g.ar((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(198123);
  }
  
  public final boolean aR(Intent paramIntent)
  {
    return false;
  }
  
  public final T fFn()
  {
    AppMethodBeat.i(198119);
    com.tencent.mm.cd.a locala = (com.tencent.mm.cd.a)this.JbC.getValue();
    p.j(locala, "data");
    AppMethodBeat.o(198119);
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
    a(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.e
 * JD-Core Version:    0.7.0.1
 */