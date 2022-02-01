package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/storage/EmojiDesignerProductList;", "", "()V", "TAG", "", "designerUin", "", "getDesignerUin", "()I", "setDesignerUin", "(I)V", "productList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/storage/emotion/EmojiDesignerProduct;", "getProductList", "()Ljava/util/LinkedList;", "getNew", "", "hasNew", "", "markRead", "", "Cache", "Companion", "plugin-emojisdk_release"})
public final class ba
{
  public static final ba.b IKS;
  public final LinkedList<com.tencent.mm.storage.emotion.a> IKR;
  private final String TAG;
  public int gjN;
  
  static
  {
    AppMethodBeat.i(183993);
    IKS = new ba.b((byte)0);
    AppMethodBeat.o(183993);
  }
  
  public ba()
  {
    AppMethodBeat.i(183992);
    this.TAG = "MicroMsg.EmojiDesignerProductList";
    this.IKR = new LinkedList();
    AppMethodBeat.o(183992);
  }
  
  public final boolean fra()
  {
    AppMethodBeat.i(183990);
    ad.i(this.TAG, "hasNew: " + this.gjN + ", " + this.IKR.size());
    int j = (int)bt.aQJ();
    Object localObject = (Iterable)this.IKR;
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
  
  public final void frb()
  {
    AppMethodBeat.i(183991);
    if (fra())
    {
      Iterator localIterator = ((Iterable)this.IKR).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.storage.emotion.a)localIterator.next()).field_syncTime = 0;
      }
      bd.frc().frg().a(this);
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)new qo());
    }
    AppMethodBeat.o(183991);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/storage/EmojiDesignerProductList$Cache;", "", "()V", "map", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "Lcom/tencent/mm/storage/EmojiDesignerProductList;", "getMap", "()Lcom/tencent/mm/memory/cache/DefaultResource;", "get", "designerUin", "put", "", "info", "plugin-emojisdk_release"})
  public static final class a
  {
    private static final c<Integer, ba> IKT;
    public static final a IKU;
    
    static
    {
      AppMethodBeat.i(183989);
      IKU = new a();
      IKT = new c(500);
      AppMethodBeat.o(183989);
    }
    
    public static void a(int paramInt, ba paramba)
    {
      AppMethodBeat.i(183988);
      p.h(paramba, "info");
      IKT.put(Integer.valueOf(paramInt), paramba);
      AppMethodBeat.o(183988);
    }
    
    public static ba aaS(int paramInt)
    {
      AppMethodBeat.i(183987);
      ba localba2 = (ba)IKT.get(Integer.valueOf(paramInt));
      ba localba1;
      if (aj.cmR())
      {
        localba1 = localba2;
        if (localba2 == null)
        {
          localba1 = bd.frc().frg().aaX(paramInt);
          IKT.put(Integer.valueOf(paramInt), localba1);
        }
      }
      for (;;)
      {
        p.g(localba1, "info");
        AppMethodBeat.o(183987);
        return localba1;
        localba1 = new ba();
        localba1.gjN = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.ba
 * JD-Core Version:    0.7.0.1
 */