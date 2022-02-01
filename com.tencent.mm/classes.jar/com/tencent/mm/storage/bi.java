package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ty;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.a;
import com.tencent.mm.storage.emotion.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/EmojiDesignerProductList;", "", "()V", "TAG", "", "designerUin", "", "getDesignerUin", "()I", "setDesignerUin", "(I)V", "productList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/storage/emotion/EmojiDesignerProduct;", "getProductList", "()Ljava/util/LinkedList;", "getNew", "", "hasNew", "", "markRead", "", "Cache", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bi
{
  public static final bi.b adiY;
  public final LinkedList<a> Eib;
  private final String TAG;
  public int mhB;
  
  static
  {
    AppMethodBeat.i(183993);
    adiY = new bi.b((byte)0);
    AppMethodBeat.o(183993);
  }
  
  public bi()
  {
    AppMethodBeat.i(183992);
    this.TAG = "MicroMsg.EmojiDesignerProductList";
    this.Eib = new LinkedList();
    AppMethodBeat.o(183992);
  }
  
  public final void hGD()
  {
    AppMethodBeat.i(183991);
    if (jaZ())
    {
      Iterator localIterator = ((Iterable)this.Eib).iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).field_syncTime = 0;
      }
      bl.jba().adjH.a(this);
      new ty().publish();
    }
    AppMethodBeat.o(183991);
  }
  
  public final boolean jaZ()
  {
    AppMethodBeat.i(183990);
    Log.i(this.TAG, "hasNew: " + this.mhB + ", " + this.Eib.size());
    int j = (int)Util.nowSecond();
    Object localObject = (Iterable)this.Eib;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        if (((a)((Iterator)localObject).next()).field_syncTime > j - 2592000L) {}
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/EmojiDesignerProductList$Cache;", "", "()V", "map", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "Lcom/tencent/mm/storage/EmojiDesignerProductList;", "getMap", "()Lcom/tencent/mm/memory/cache/DefaultResource;", "get", "designerUin", "put", "", "info", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a adiZ;
    private static final c<Integer, bi> adja;
    
    static
    {
      AppMethodBeat.i(183989);
      adiZ = new a();
      adja = new c(500);
      AppMethodBeat.o(183989);
    }
    
    public static void a(int paramInt, bi parambi)
    {
      AppMethodBeat.i(183988);
      s.u(parambi, "info");
      adja.put(Integer.valueOf(paramInt), parambi);
      AppMethodBeat.o(183988);
    }
    
    public static bi ayV(int paramInt)
    {
      AppMethodBeat.i(183987);
      bi localbi2 = (bi)adja.get(Integer.valueOf(paramInt));
      bi localbi1;
      if (MMApplicationContext.isMainProcess())
      {
        localbi1 = localbi2;
        if (localbi2 == null)
        {
          localbi1 = bl.jba().adjH.aza(paramInt);
          adja.put(Integer.valueOf(paramInt), localbi1);
        }
      }
      for (;;)
      {
        s.s(localbi1, "info");
        AppMethodBeat.o(183987);
        return localbi1;
        localbi1 = new bi();
        localbi1.mhB = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.bi
 * JD-Core Version:    0.7.0.1
 */