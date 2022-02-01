package com.tencent.mm.plugin.textstatus.conversation.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment.c;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.conversation.h.b;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusGreetingDataSource;", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$IConversationDataSource;", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusGreetingItem;", "type", "", "scene", "(II)V", "curIndex", "getCurIndex", "()I", "setCurIndex", "(I)V", "curTime", "getCurTime", "curTime$delegate", "Lkotlin/Lazy;", "getConversationStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "loadOnLoadMore", "", "offset", "loadOnPageEnter", "prepareData", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements BasePrivateMsgConvListFragment.c<d>
{
  public static final c.a TiT;
  private final j TiU;
  private final int scene;
  private final int type;
  private int zVI;
  
  static
  {
    AppMethodBeat.i(290941);
    TiT = new c.a((byte)0);
    AppMethodBeat.o(290941);
  }
  
  private c()
  {
    AppMethodBeat.i(290912);
    this.type = 1;
    this.scene = 1;
    this.TiU = k.cm((a)c.b.TiV);
    AppMethodBeat.o(290912);
  }
  
  private int hGv()
  {
    AppMethodBeat.i(290921);
    int i = ((Number)this.TiU.getValue()).intValue();
    AppMethodBeat.o(290921);
    return i;
  }
  
  private final void lt(List<d> paramList)
  {
    AppMethodBeat.i(290932);
    paramList = ((Iterable)paramList).iterator();
    if (paramList.hasNext())
    {
      d locald = (d)paramList.next();
      int i;
      if (this.zVI == 2) {
        i = 0;
      }
      for (;;)
      {
        locald.TiY = i;
        break;
        if (Math.abs(hGv() - locald.field_createTime) < 259200) {
          switch (this.zVI)
          {
          default: 
            i = 0;
            break;
          case 0: 
            this.zVI = 1;
            i = 1;
            break;
          case 1: 
            i = 0;
            break;
          }
        } else {
          switch (this.zVI)
          {
          default: 
            break;
          case 0: 
          case 1: 
            this.zVI = 2;
            i = 2;
          }
        }
      }
    }
    AppMethodBeat.o(290932);
  }
  
  public final MAutoStorage<d> aNP()
  {
    AppMethodBeat.i(290950);
    Object localObject = f.TjQ;
    localObject = (MAutoStorage)f.hGN();
    AppMethodBeat.o(290950);
    return localObject;
  }
  
  public final List<d> aNQ()
  {
    AppMethodBeat.i(290955);
    List localList = ((b)aNP()).fg(0, 15);
    lt(localList);
    AppMethodBeat.o(290955);
    return localList;
  }
  
  public final List<d> qH(int paramInt)
  {
    AppMethodBeat.i(290963);
    List localList = ((b)aNP()).fg(paramInt, 60);
    lt(localList);
    AppMethodBeat.o(290963);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.d.c
 * JD-Core Version:    0.7.0.1
 */