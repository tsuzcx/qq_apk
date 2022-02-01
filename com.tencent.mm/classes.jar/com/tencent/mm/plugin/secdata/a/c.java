package com.tencent.mm.plugin.secdata.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/secdata/model/SecReportDataInfoMemoryStorage;", "", "()V", "map", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lkotlin/collections/HashMap;", "getMap", "()Ljava/util/HashMap;", "clear", "", "plugin-sec-data_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c PlH;
  private static final HashMap<String, a> map;
  
  static
  {
    AppMethodBeat.i(261467);
    PlH = new c();
    map = new HashMap();
    AppMethodBeat.o(261467);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(261461);
    map.clear();
    AppMethodBeat.o(261461);
  }
  
  public static HashMap<String, a> gUz()
  {
    return map;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.a.c
 * JD-Core Version:    0.7.0.1
 */