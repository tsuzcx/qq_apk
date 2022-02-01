package com.tencent.mm.plugin.textstatus.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StyleArray;", "", "prefix", "", "xmlMap", "", "(Ljava/lang/String;Ljava/util/Map;)V", "items", "", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StyleArrayItem;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$d
{
  List<f.e> bMQ;
  
  public f$d(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(290365);
    this.bMQ = ((List)new LinkedList());
    int i = 1;
    String str = s.X(paramString, ".styleItem");
    while (paramMap.get(str) != null)
    {
      f.e locale = new f.e(str, paramMap);
      str = s.X(paramString, Integer.valueOf(i));
      i += 1;
      this.bMQ.add(locale);
    }
    AppMethodBeat.o(290365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.util.f.d
 * JD-Core Version:    0.7.0.1
 */