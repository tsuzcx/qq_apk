package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/storage/EmojiDesignerProductList;", "", "()V", "TAG", "", "designerUin", "", "getDesignerUin", "()I", "setDesignerUin", "(I)V", "productList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/storage/emotion/EmojiDesignerProduct;", "getProductList", "()Ljava/util/LinkedList;", "getNew", "", "hasNew", "", "markRead", "", "Cache", "Companion", "plugin-emojisdk_release"})
public final class bb
{
  public static final bb.b Jfz;
  public final LinkedList<com.tencent.mm.storage.emotion.a> Jfy;
  private final String TAG;
  public int gmg;
  
  static
  {
    AppMethodBeat.i(183993);
    Jfz = new bb.b((byte)0);
    AppMethodBeat.o(183993);
  }
  
  public bb()
  {
    AppMethodBeat.i(183992);
    this.TAG = "MicroMsg.EmojiDesignerProductList";
    this.Jfy = new LinkedList();
    AppMethodBeat.o(183992);
  }
  
  public final boolean fva()
  {
    AppMethodBeat.i(183990);
    ae.i(this.TAG, "hasNew: " + this.gmg + ", " + this.Jfy.size());
    int j = (int)bu.aRi();
    Object localObject = (Iterable)this.Jfy;
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
  
  public final void fvb()
  {
    AppMethodBeat.i(183991);
    if (fva())
    {
      Iterator localIterator = ((Iterable)this.Jfy).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.storage.emotion.a)localIterator.next()).field_syncTime = 0;
      }
      be.fvc().fvg().a(this);
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)new qp());
    }
    AppMethodBeat.o(183991);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/storage/EmojiDesignerProductList$Cache;", "", "()V", "map", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "Lcom/tencent/mm/storage/EmojiDesignerProductList;", "getMap", "()Lcom/tencent/mm/memory/cache/DefaultResource;", "get", "designerUin", "put", "", "info", "plugin-emojisdk_release"})
  public static final class a
  {
    private static final c<Integer, bb> JfA;
    public static final a JfB;
    
    static
    {
      AppMethodBeat.i(183989);
      JfB = new a();
      JfA = new c(500);
      AppMethodBeat.o(183989);
    }
    
    public static void a(int paramInt, bb parambb)
    {
      AppMethodBeat.i(183988);
      p.h(parambb, "info");
      JfA.put(Integer.valueOf(paramInt), parambb);
      AppMethodBeat.o(183988);
    }
    
    public static bb abA(int paramInt)
    {
      AppMethodBeat.i(183987);
      bb localbb2 = (bb)JfA.get(Integer.valueOf(paramInt));
      bb localbb1;
      if (ak.coh())
      {
        localbb1 = localbb2;
        if (localbb2 == null)
        {
          localbb1 = be.fvc().fvg().abF(paramInt);
          JfA.put(Integer.valueOf(paramInt), localbb1);
        }
      }
      for (;;)
      {
        p.g(localbb1, "info");
        AppMethodBeat.o(183987);
        return localbb1;
        localbb1 = new bb();
        localbb1.gmg = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.bb
 * JD-Core Version:    0.7.0.1
 */