package com.tencent.mm.plugin.textstatus.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StyleArrayItem;", "", "prefix", "", "xmlMap", "", "(Ljava/lang/String;Ljava/util/Map;)V", "beginTime", "", "getBeginTime", "()J", "setBeginTime", "(J)V", "endTime", "getEndTime", "setEndTime", "styleId", "", "getStyleId", "()I", "setStyleId", "(I)V", "isStyleValid", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$e
{
  long beginTime;
  long endTime;
  int sbV;
  
  public f$e(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(290352);
    this.sbV = Util.safeParseInt(Util.nullAs((String)paramMap.get(s.X(paramString, ".$styleId")), ""));
    this.beginTime = Util.safeParseLong((String)paramMap.get(s.X(paramString, ".beginTime")));
    this.endTime = Util.safeParseLong((String)paramMap.get(s.X(paramString, ".endTime")));
    AppMethodBeat.o(290352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.util.f.e
 * JD-Core Version:    0.7.0.1
 */