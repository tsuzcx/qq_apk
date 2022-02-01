package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.si;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.a;
import com.tencent.mm.storage.emotion.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/storage/EmojiDesignerProductList;", "", "()V", "TAG", "", "designerUin", "", "getDesignerUin", "()I", "setDesignerUin", "(I)V", "productList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/storage/emotion/EmojiDesignerProduct;", "getProductList", "()Ljava/util/LinkedList;", "getNew", "", "hasNew", "", "markRead", "", "Cache", "Companion", "plugin-emojisdk_release"})
public final class bg
{
  public static final bg.b VFl;
  private final String TAG;
  public int jHU;
  public final LinkedList<a> ziJ;
  
  static
  {
    AppMethodBeat.i(183993);
    VFl = new bg.b((byte)0);
    AppMethodBeat.o(183993);
  }
  
  public bg()
  {
    AppMethodBeat.i(183992);
    this.TAG = "MicroMsg.EmojiDesignerProductList";
    this.ziJ = new LinkedList();
    AppMethodBeat.o(183992);
  }
  
  public final boolean hyT()
  {
    AppMethodBeat.i(183990);
    Log.i(this.TAG, "hasNew: " + this.jHU + ", " + this.ziJ.size());
    int j = (int)Util.nowSecond();
    Object localObject = (Iterable)this.ziJ;
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
  
  public final void hyU()
  {
    AppMethodBeat.i(183991);
    if (hyT())
    {
      Iterator localIterator = ((Iterable)this.ziJ).iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).field_syncTime = 0;
      }
      bj.hyV().hza().a(this);
      EventCenter.instance.publish((IEvent)new si());
    }
    AppMethodBeat.o(183991);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/storage/EmojiDesignerProductList$Cache;", "", "()V", "map", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "Lcom/tencent/mm/storage/EmojiDesignerProductList;", "getMap", "()Lcom/tencent/mm/memory/cache/DefaultResource;", "get", "designerUin", "put", "", "info", "plugin-emojisdk_release"})
  public static final class a
  {
    private static final c<Integer, bg> VFm;
    public static final a VFn;
    
    static
    {
      AppMethodBeat.i(183989);
      VFn = new a();
      VFm = new c(500);
      AppMethodBeat.o(183989);
    }
    
    public static void a(int paramInt, bg parambg)
    {
      AppMethodBeat.i(183988);
      p.k(parambg, "info");
      VFm.put(Integer.valueOf(paramInt), parambg);
      AppMethodBeat.o(183988);
    }
    
    public static bg asF(int paramInt)
    {
      AppMethodBeat.i(183987);
      bg localbg2 = (bg)VFm.get(Integer.valueOf(paramInt));
      bg localbg1;
      if (MMApplicationContext.isMainProcess())
      {
        localbg1 = localbg2;
        if (localbg2 == null)
        {
          localbg1 = bj.hyV().hza().asK(paramInt);
          VFm.put(Integer.valueOf(paramInt), localbg1);
        }
      }
      for (;;)
      {
        p.j(localbg1, "info");
        AppMethodBeat.o(183987);
        return localbg1;
        localbg1 = new bg();
        localbg1.jHU = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.bg
 * JD-Core Version:    0.7.0.1
 */