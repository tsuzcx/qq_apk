package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/storage/EmojiDesignerProductList;", "", "()V", "TAG", "", "designerUin", "", "getDesignerUin", "()I", "setDesignerUin", "(I)V", "productList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/storage/emotion/EmojiDesignerProduct;", "getProductList", "()Ljava/util/LinkedList;", "getNew", "", "hasNew", "", "markRead", "", "Cache", "Companion", "plugin-emojisdk_release"})
public final class at
{
  public static final b FyD;
  public final LinkedList<com.tencent.mm.storage.emotion.a> FyC;
  private final String TAG;
  public int fMB;
  
  static
  {
    AppMethodBeat.i(183993);
    FyD = new b((byte)0);
    AppMethodBeat.o(183993);
  }
  
  public at()
  {
    AppMethodBeat.i(183992);
    this.TAG = "MicroMsg.EmojiDesignerProductList";
    this.FyC = new LinkedList();
    AppMethodBeat.o(183992);
  }
  
  public final boolean eLv()
  {
    AppMethodBeat.i(183990);
    ad.i(this.TAG, "hasNew: " + this.fMB + ", " + this.FyC.size());
    int j = (int)bt.aGK();
    Object localObject = (Iterable)this.FyC;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        if (((com.tencent.mm.storage.emotion.a)((Iterator)localObject).next()).field_syncTime > j - 2592000L) {}
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(183990);
          return true;
        }
      }
    }
    AppMethodBeat.o(183990);
    return false;
  }
  
  public final void eLw()
  {
    AppMethodBeat.i(183991);
    if (eLv())
    {
      Iterator localIterator = ((Iterable)this.FyC).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.storage.emotion.a)localIterator.next()).field_syncTime = 0;
      }
      aw.eLx().eLA().a(this);
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)new pu());
    }
    AppMethodBeat.o(183991);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/storage/EmojiDesignerProductList$Cache;", "", "()V", "map", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "Lcom/tencent/mm/storage/EmojiDesignerProductList;", "getMap", "()Lcom/tencent/mm/memory/cache/DefaultResource;", "get", "designerUin", "put", "", "info", "plugin-emojisdk_release"})
  public static final class a
  {
    private static final c<Integer, at> FyE;
    public static final a FyF;
    
    static
    {
      AppMethodBeat.i(183989);
      FyF = new a();
      FyE = new c(500);
      AppMethodBeat.o(183989);
    }
    
    public static at Wz(int paramInt)
    {
      AppMethodBeat.i(183987);
      at localat2 = (at)FyE.get(Integer.valueOf(paramInt));
      at localat1;
      if (aj.cbe())
      {
        localat1 = localat2;
        if (localat2 == null)
        {
          localat1 = aw.eLx().eLA().WE(paramInt);
          FyE.put(Integer.valueOf(paramInt), localat1);
        }
      }
      for (;;)
      {
        k.g(localat1, "info");
        AppMethodBeat.o(183987);
        return localat1;
        localat1 = new at();
        localat1.fMB = paramInt;
      }
    }
    
    public static void a(int paramInt, at paramat)
    {
      AppMethodBeat.i(183988);
      k.h(paramat, "info");
      FyE.put(Integer.valueOf(paramInt), paramat);
      AppMethodBeat.o(183988);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/storage/EmojiDesignerProductList$Companion;", "", "()V", "NEW_VALID", "", "plugin-emojisdk_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.at
 * JD-Core Version:    0.7.0.1
 */