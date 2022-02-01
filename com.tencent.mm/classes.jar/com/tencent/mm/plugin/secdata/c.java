package com.tencent.mm.plugin.secdata;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/secdata/AllActivitySecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/plugin/secdata/ISecData;", "clazz", "Ljava/lang/Class;", "type", "", "reuse", "", "(Ljava/lang/Class;IZ)V", "getClazz", "()Ljava/lang/Class;", "data", "kotlin.jvm.PlatformType", "getData", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "data$delegate", "Lkotlin/Lazy;", "check", "intent", "Landroid/content/Intent;", "getTransformData", "getType", "plugin-sec-data_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c<T extends com.tencent.mm.bx.a>
  implements h<T>
{
  private final boolean Plu;
  private final j Plv;
  final Class<T> clazz;
  private final int type;
  
  public c(Class<T> paramClass, int paramInt)
  {
    AppMethodBeat.i(261435);
    this.clazz = paramClass;
    this.type = paramInt;
    this.Plu = true;
    this.Plv = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(261435);
  }
  
  public final boolean bp(Intent paramIntent)
  {
    return true;
  }
  
  public final T gUv()
  {
    AppMethodBeat.i(261455);
    com.tencent.mm.bx.a locala = (com.tencent.mm.bx.a)this.Plv.getValue();
    s.s(locala, "data");
    AppMethodBeat.o(261455);
    return locala;
  }
  
  public final boolean gUw()
  {
    AppMethodBeat.i(261463);
    s.u(this, "this");
    AppMethodBeat.o(261463);
    return true;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "T", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/protobuf/BaseProtoBuf;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<T>
  {
    a(c<T> paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.c
 * JD-Core Version:    0.7.0.1
 */