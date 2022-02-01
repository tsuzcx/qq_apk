package com.tencent.mm.plugin.textstatus.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "topicId", "", "items", "", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "liveCount", "", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getLiveCount", "()Ljava/lang/Integer;", "setLiveCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTopicId", "()Ljava/lang/String;", "getItemId", "", "getItemType", "plugin-textstatus_release"})
public final class b
  implements com.tencent.mm.view.recyclerview.a
{
  public Integer FZA;
  public final String FZz;
  public List<com.tencent.mm.plugin.textstatus.f.f.a> iHf;
  
  public b(String paramString, List<com.tencent.mm.plugin.textstatus.f.f.a> paramList, Integer paramInteger)
  {
    AppMethodBeat.i(216239);
    this.FZz = paramString;
    this.iHf = paramList;
    this.FZA = paramInteger;
    AppMethodBeat.o(216239);
  }
  
  public final int cxn()
  {
    return 1;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(216238);
    long l = hashCode();
    AppMethodBeat.o(216238);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.d.b
 * JD-Core Version:    0.7.0.1
 */