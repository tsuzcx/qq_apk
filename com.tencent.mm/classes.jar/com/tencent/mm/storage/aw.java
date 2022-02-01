package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/storage/EmojiDesignerProductList;", "", "()V", "TAG", "", "designerUin", "", "getDesignerUin", "()I", "setDesignerUin", "(I)V", "productList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/storage/emotion/EmojiDesignerProduct;", "getProductList", "()Ljava/util/LinkedList;", "getNew", "", "hasNew", "", "markRead", "", "Cache", "Companion", "plugin-emojisdk_release"})
public final class aw
{
  public static final aw.b GXE;
  public final LinkedList<com.tencent.mm.storage.emotion.a> GXD;
  private final String TAG;
  public int fQn;
  
  static
  {
    AppMethodBeat.i(183993);
    GXE = new aw.b((byte)0);
    AppMethodBeat.o(183993);
  }
  
  public aw()
  {
    AppMethodBeat.i(183992);
    this.TAG = "MicroMsg.EmojiDesignerProductList";
    this.GXD = new LinkedList();
    AppMethodBeat.o(183992);
  }
  
  public final boolean faX()
  {
    AppMethodBeat.i(183990);
    ac.i(this.TAG, "hasNew: " + this.fQn + ", " + this.GXD.size());
    int j = (int)bs.aNx();
    Object localObject = (Iterable)this.GXD;
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
  
  public final void faY()
  {
    AppMethodBeat.i(183991);
    if (faX())
    {
      Iterator localIterator = ((Iterable)this.GXD).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.storage.emotion.a)localIterator.next()).field_syncTime = 0;
      }
      az.faZ().fbd().a(this);
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)new qd());
    }
    AppMethodBeat.o(183991);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/storage/EmojiDesignerProductList$Cache;", "", "()V", "map", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "Lcom/tencent/mm/storage/EmojiDesignerProductList;", "getMap", "()Lcom/tencent/mm/memory/cache/DefaultResource;", "get", "designerUin", "put", "", "info", "plugin-emojisdk_release"})
  public static final class a
  {
    private static final c<Integer, aw> GXF;
    public static final a GXG;
    
    static
    {
      AppMethodBeat.i(183989);
      GXG = new a();
      GXF = new c(500);
      AppMethodBeat.o(183989);
    }
    
    public static aw YJ(int paramInt)
    {
      AppMethodBeat.i(183987);
      aw localaw2 = (aw)GXF.get(Integer.valueOf(paramInt));
      aw localaw1;
      if (ai.cin())
      {
        localaw1 = localaw2;
        if (localaw2 == null)
        {
          localaw1 = az.faZ().fbd().YO(paramInt);
          GXF.put(Integer.valueOf(paramInt), localaw1);
        }
      }
      for (;;)
      {
        k.g(localaw1, "info");
        AppMethodBeat.o(183987);
        return localaw1;
        localaw1 = new aw();
        localaw1.fQn = paramInt;
      }
    }
    
    public static void a(int paramInt, aw paramaw)
    {
      AppMethodBeat.i(183988);
      k.h(paramaw, "info");
      GXF.put(Integer.valueOf(paramInt), paramaw);
      AppMethodBeat.o(183988);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.aw
 * JD-Core Version:    0.7.0.1
 */