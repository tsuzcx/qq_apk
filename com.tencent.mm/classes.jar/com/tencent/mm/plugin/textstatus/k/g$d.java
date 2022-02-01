package com.tencent.mm.plugin.textstatus.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StyleArray;", "", "prefix", "", "xmlMap", "", "(Ljava/lang/String;Ljava/util/Map;)V", "items", "", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StyleArrayItem;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "plugin-textstatus_release"})
public final class g$d
{
  List<g.e> lxh;
  
  public g$d(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(236999);
    this.lxh = ((List)new LinkedList());
    int i = 1;
    String str = paramString + ".styleItem";
    while (paramMap.get(str) != null)
    {
      g.e locale = new g.e(str, paramMap);
      str = paramString + i;
      i += 1;
      this.lxh.add(locale);
    }
    AppMethodBeat.o(236999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.k.g.d
 * JD-Core Version:    0.7.0.1
 */