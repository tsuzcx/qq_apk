package com.tencent.mm.plugin.textstatus.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/convert/topic/SameTopicFriendData;", "Lcom/tencent/mm/plugin/mvvmlist/BaseMvvmListItem;", "groupItem", "Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicFriendsItem;", "userName", "", "createTime", "", "itemInfo", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "(Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicFriendsItem;Ljava/lang/String;ILcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "getCreateTime", "()I", "getGroupItem", "()Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicFriendsItem;", "getItemInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getUserName", "()Ljava/lang/String;", "compareTo", "other", "getItemType", "getUniqueId", "isSameContent", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a<c>
{
  final com.tencent.mm.plugin.textstatus.h.g.b Tkq;
  final com.tencent.mm.plugin.textstatus.h.f.b Tkr;
  final int createTime;
  final String userName;
  
  public c(com.tencent.mm.plugin.textstatus.h.g.b paramb, String paramString, int paramInt, com.tencent.mm.plugin.textstatus.h.f.b paramb1)
  {
    AppMethodBeat.i(290238);
    this.Tkq = paramb;
    this.userName = paramString;
    this.createTime = paramInt;
    this.Tkr = paramb1;
    AppMethodBeat.o(290238);
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(290250);
    int i = this.userName.hashCode();
    AppMethodBeat.o(290250);
    return i;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(290255);
    Object localObject = super.clone();
    AppMethodBeat.o(290255);
    return localObject;
  }
  
  public final String fcs()
  {
    return this.userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.c.c
 * JD-Core Version:    0.7.0.1
 */