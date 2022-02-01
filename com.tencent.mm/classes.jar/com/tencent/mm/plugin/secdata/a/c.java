package com.tencent.mm.plugin.secdata.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.HashMap;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/secdata/model/SecReportDataInfoMemoryStorage;", "", "()V", "map", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lkotlin/collections/HashMap;", "getMap", "()Ljava/util/HashMap;", "clear", "", "plugin-sec-data_release"})
public final class c
{
  public static final c CWk;
  private static final HashMap<String, a> map;
  
  static
  {
    AppMethodBeat.i(219176);
    CWk = new c();
    map = new HashMap();
    AppMethodBeat.o(219176);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(219175);
    map.clear();
    AppMethodBeat.o(219175);
  }
  
  public static HashMap<String, a> eSp()
  {
    return map;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.a.c
 * JD-Core Version:    0.7.0.1
 */