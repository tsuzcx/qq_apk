package com.tencent.mm.plugin.textstatus.h.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.a;
import com.tencent.mm.plugin.textstatus.h.f.g.c;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicFriendsItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/mvvmlist/BaseMvvmListItem;", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage$SameTopicStruct;", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage$SameTopicStruct;)V", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage$SameTopicStruct;", "compareTo", "", "other", "getItemId", "", "getItemType", "getUniqueId", "", "isSameContent", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a<b>
{
  public final g.c TnV;
  
  public b(g.c paramc)
  {
    AppMethodBeat.i(290454);
    this.TnV = paramc;
    AppMethodBeat.o(290454);
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(290461);
    long l = hashCode();
    AppMethodBeat.o(290461);
    return l;
  }
  
  public final int bZB()
  {
    return 0;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(290477);
    Object localObject = super.clone();
    AppMethodBeat.o(290477);
    return localObject;
  }
  
  public final String fcs()
  {
    return this.TnV.topicId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.g.b
 * JD-Core Version:    0.7.0.1
 */