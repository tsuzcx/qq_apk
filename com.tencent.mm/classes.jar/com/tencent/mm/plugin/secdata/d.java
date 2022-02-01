package com.tencent.mm.plugin.secdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/secdata/DefaultListSecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/plugin/secdata/IListSecData;", "type", "", "(I)V", "itemObjMap", "Ljava/util/HashMap;", "", "getItemObjMap", "()Ljava/util/HashMap;", "itemObjMap$delegate", "Lkotlin/Lazy;", "copyItemObj", "", "fromKey", "toKey", "getItemObj", "key", "(Ljava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getListItemObjMap", "", "getType", "moveItemObj", "putItemObj", "value", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "plugin-sec-data_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d<T extends com.tencent.mm.bx.a>
  implements f<T>
{
  private final j Ply;
  private final int type;
  
  public d()
  {
    AppMethodBeat.i(261430);
    this.type = 1;
    this.Ply = k.cm((kotlin.g.a.a)a.Plz);
    AppMethodBeat.o(261430);
  }
  
  private HashMap<String, T> gUx()
  {
    AppMethodBeat.i(261436);
    HashMap localHashMap = (HashMap)this.Ply.getValue();
    AppMethodBeat.o(261436);
    return localHashMap;
  }
  
  public final void c(String paramString, T paramT)
  {
    AppMethodBeat.i(261454);
    s.u(paramString, "key");
    s.u(paramT, "value");
    ((Map)gUx()).put(paramString, paramT);
    AppMethodBeat.o(261454);
  }
  
  public final Map<String, T> gUy()
  {
    AppMethodBeat.i(261447);
    Map localMap = (Map)gUx();
    AppMethodBeat.o(261447);
    return localMap;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public final void lJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(261464);
    s.u(paramString1, "fromKey");
    s.u(paramString2, "toKey");
    paramString1 = (com.tencent.mm.bx.a)gUx().get(paramString1);
    if (paramString1 != null) {
      ((Map)gUx()).put(paramString2, paramString1);
    }
    AppMethodBeat.o(261464);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/HashMap;", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<HashMap<String, T>>
  {
    public static final a Plz;
    
    static
    {
      AppMethodBeat.i(261443);
      Plz = new a();
      AppMethodBeat.o(261443);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.d
 * JD-Core Version:    0.7.0.1
 */