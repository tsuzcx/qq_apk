package com.tencent.mm.plugin.secdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/secdata/DefaultListSecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/plugin/secdata/IListSecData;", "type", "", "(I)V", "itemObjMap", "Ljava/util/HashMap;", "", "getItemObjMap", "()Ljava/util/HashMap;", "itemObjMap$delegate", "Lkotlin/Lazy;", "copyItemObj", "", "fromKey", "toKey", "getItemObj", "key", "(Ljava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getListItemObjMap", "", "getType", "moveItemObj", "putItemObj", "value", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "plugin-sec-data_release"})
public final class d<T extends com.tencent.mm.bw.a>
  implements f<T>
{
  private final kotlin.f CVW;
  private final int type;
  
  public d()
  {
    AppMethodBeat.i(219144);
    this.type = 1;
    this.CVW = g.ah((kotlin.g.a.a)a.CVX);
    AppMethodBeat.o(219144);
  }
  
  private HashMap<String, T> eSn()
  {
    AppMethodBeat.i(219140);
    HashMap localHashMap = (HashMap)this.CVW.getValue();
    AppMethodBeat.o(219140);
    return localHashMap;
  }
  
  public final void c(String paramString, T paramT)
  {
    AppMethodBeat.i(219142);
    p.h(paramString, "key");
    p.h(paramT, "value");
    ((Map)eSn()).put(paramString, paramT);
    AppMethodBeat.o(219142);
  }
  
  public final Map<String, T> eSo()
  {
    AppMethodBeat.i(219141);
    Map localMap = (Map)eSn();
    AppMethodBeat.o(219141);
    return localMap;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public final void jS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(219143);
    p.h(paramString1, "fromKey");
    p.h(paramString2, "toKey");
    paramString1 = (com.tencent.mm.bw.a)eSn().get(paramString1);
    if (paramString1 != null)
    {
      Map localMap = (Map)eSn();
      p.g(paramString1, "it");
      localMap.put(paramString2, paramString1);
      AppMethodBeat.o(219143);
      return;
    }
    AppMethodBeat.o(219143);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/HashMap;", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<HashMap<String, T>>
  {
    public static final a CVX;
    
    static
    {
      AppMethodBeat.i(219139);
      CVX = new a();
      AppMethodBeat.o(219139);
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