package com.tencent.mm.plugin.secdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/secdata/DefaultListSecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/plugin/secdata/IListSecData;", "type", "", "(I)V", "itemObjMap", "Ljava/util/HashMap;", "", "getItemObjMap", "()Ljava/util/HashMap;", "itemObjMap$delegate", "Lkotlin/Lazy;", "copyItemObj", "", "fromKey", "toKey", "getItemObj", "key", "(Ljava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getListItemObjMap", "", "getType", "moveItemObj", "putItemObj", "value", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "plugin-sec-data_release"})
public final class d<T extends com.tencent.mm.cd.a>
  implements f<T>
{
  private final kotlin.f JbH;
  private final int type;
  
  public d()
  {
    AppMethodBeat.i(197987);
    this.type = 1;
    this.JbH = g.ar((kotlin.g.a.a)a.JbI);
    AppMethodBeat.o(197987);
  }
  
  private HashMap<String, T> fFp()
  {
    AppMethodBeat.i(197972);
    HashMap localHashMap = (HashMap)this.JbH.getValue();
    AppMethodBeat.o(197972);
    return localHashMap;
  }
  
  public final void c(String paramString, T paramT)
  {
    AppMethodBeat.i(197979);
    p.k(paramString, "key");
    p.k(paramT, "value");
    ((Map)fFp()).put(paramString, paramT);
    AppMethodBeat.o(197979);
  }
  
  public final Map<String, T> fFq()
  {
    AppMethodBeat.i(197974);
    Map localMap = (Map)fFp();
    AppMethodBeat.o(197974);
    return localMap;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public final void kk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197985);
    p.k(paramString1, "fromKey");
    p.k(paramString2, "toKey");
    paramString1 = (com.tencent.mm.cd.a)fFp().get(paramString1);
    if (paramString1 != null)
    {
      Map localMap = (Map)fFp();
      p.j(paramString1, "it");
      localMap.put(paramString2, paramString1);
      AppMethodBeat.o(197985);
      return;
    }
    AppMethodBeat.o(197985);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/HashMap;", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<HashMap<String, T>>
  {
    public static final a JbI;
    
    static
    {
      AppMethodBeat.i(197917);
      JbI = new a();
      AppMethodBeat.o(197917);
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