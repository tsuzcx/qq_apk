package com.tencent.mm.plugin.secdata.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import java.util.HashMap;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/secdata/model/SecReportDataInfoMemoryStorage;", "", "()V", "map", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lkotlin/collections/HashMap;", "getMap", "()Ljava/util/HashMap;", "clear", "", "plugin-sec-data_release"})
public final class c
{
  public static final c JbR;
  private static final HashMap<String, a> map;
  
  static
  {
    AppMethodBeat.i(197966);
    JbR = new c();
    map = new HashMap();
    AppMethodBeat.o(197966);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(197960);
    map.clear();
    AppMethodBeat.o(197960);
  }
  
  public static HashMap<String, a> fFr()
  {
    return map;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.a.c
 * JD-Core Version:    0.7.0.1
 */