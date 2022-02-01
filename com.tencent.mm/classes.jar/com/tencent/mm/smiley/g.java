package com.tencent.mm.smiley;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/EmojiOldProtoHelper;", "", "()V", "getNewEmojiResHeader", "Lcom/tencent/mm/smiley/EmojiResHeader;", "oldHeader", "Lcom/tencent/mm/smiley/EmojiFileHeader;", "Companion", "Holder", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g.a acxz;
  
  static
  {
    AppMethodBeat.i(242851);
    acxz = new g.a((byte)0);
    AppMethodBeat.o(242851);
  }
  
  public static i a(c paramc)
  {
    AppMethodBeat.i(242847);
    s.u(paramc, "oldHeader");
    Object localObject1 = paramc.acwZ;
    paramc = new LinkedList();
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      d locald = (d)((Iterator)localObject1).next();
      b localb = new b();
      int i = paramc.size();
      if (locald.uKE != 0) {
        localb.acwM.add(Integer.valueOf(locald.uKE));
      }
      if (locald.uKF != 0) {
        localb.acwM.add(Integer.valueOf(locald.uKF));
      }
      Object localObject2 = new q();
      ((q)localObject2).dIY = locald.dIY;
      ((q)localObject2).size = locald.size;
      ((q)localObject2).width = 64;
      ((q)localObject2).height = 64;
      localb.acwN = ((q)localObject2);
      if (locald.uKG != 0)
      {
        localObject2 = new v();
        ((v)localObject2).uKG = locald.uKG;
        ((v)localObject2).acyu = i;
        localLinkedList1.add(localObject2);
      }
      if (locald.acxf != -1)
      {
        localObject2 = new p();
        ((p)localObject2).acxf = locald.acxf;
        ((p)localObject2).acyu = i;
        localLinkedList2.add(localObject2);
      }
      paramc.add(localb);
    }
    localObject1 = new i();
    ((i)localObject1).acxC = paramc;
    ((i)localObject1).acxE = localLinkedList2;
    ((i)localObject1).acxD = localLinkedList1;
    AppMethodBeat.o(242847);
    return localObject1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/EmojiOldProtoHelper$Holder;", "", "()V", "instance", "Lcom/tencent/mm/smiley/EmojiOldProtoHelper;", "getInstance", "()Lcom/tencent/mm/smiley/EmojiOldProtoHelper;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    public static final b acxA;
    private static final g acxB;
    
    static
    {
      AppMethodBeat.i(242804);
      acxA = new b();
      acxB = new g();
      AppMethodBeat.o(242804);
    }
    
    public static g iUW()
    {
      return acxB;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.g
 * JD-Core Version:    0.7.0.1
 */