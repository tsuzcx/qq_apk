package com.tencent.mm.plugin.textstatus.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "topicId", "", "items", "", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "liveCount", "", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getLiveCount", "()Ljava/lang/Integer;", "setLiveCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTopicId", "()Ljava/lang/String;", "getItemId", "", "getItemType", "plugin-textstatus_release"})
public final class b
  implements com.tencent.mm.view.recyclerview.a
{
  public Integer MDP;
  public List<com.tencent.mm.plugin.textstatus.g.e.a> lxh;
  public final String topicId;
  
  public b(String paramString, List<com.tencent.mm.plugin.textstatus.g.e.a> paramList, Integer paramInteger)
  {
    AppMethodBeat.i(234704);
    this.topicId = paramString;
    this.lxh = paramList;
    this.MDP = paramInteger;
    AppMethodBeat.o(234704);
  }
  
  public final int bAQ()
  {
    return 1;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(234703);
    long l = hashCode();
    AppMethodBeat.o(234703);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.c.b
 * JD-Core Version:    0.7.0.1
 */