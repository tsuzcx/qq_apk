package com.tencent.mm.plugin.textstatus.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StyleArrayItem;", "", "prefix", "", "xmlMap", "", "(Ljava/lang/String;Ljava/util/Map;)V", "beginTime", "", "getBeginTime", "()J", "setBeginTime", "(J)V", "endTime", "getEndTime", "setEndTime", "styleId", "", "getStyleId", "()I", "setStyleId", "(I)V", "isStyleValid", "", "plugin-textstatus_release"})
public final class g$e
{
  long beginTime;
  long endTime;
  int oWy;
  
  public g$e(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(237036);
    this.oWy = Util.safeParseInt(Util.nullAs((String)paramMap.get(paramString + ".$styleId"), ""));
    this.beginTime = Util.safeParseLong((String)paramMap.get(paramString + ".beginTime"));
    this.endTime = Util.safeParseLong((String)paramMap.get(paramString + ".endTime"));
    AppMethodBeat.o(237036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.k.g.e
 * JD-Core Version:    0.7.0.1
 */