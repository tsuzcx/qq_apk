package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rj;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/storage/EmojiDesignerProductList;", "", "()V", "TAG", "", "designerUin", "", "getDesignerUin", "()I", "setDesignerUin", "(I)V", "productList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/storage/emotion/EmojiDesignerProduct;", "getProductList", "()Ljava/util/LinkedList;", "getNew", "", "hasNew", "", "markRead", "", "Cache", "Companion", "plugin-emojisdk_release"})
public final class bg
{
  public static final b Ops;
  public final LinkedList<a> LGy;
  private final String TAG;
  public int gWW;
  
  static
  {
    AppMethodBeat.i(183993);
    Ops = new b((byte)0);
    AppMethodBeat.o(183993);
  }
  
  public bg()
  {
    AppMethodBeat.i(183992);
    this.TAG = "MicroMsg.EmojiDesignerProductList";
    this.LGy = new LinkedList();
    AppMethodBeat.o(183992);
  }
  
  public final boolean gCH()
  {
    AppMethodBeat.i(183990);
    Log.i(this.TAG, "hasNew: " + this.gWW + ", " + this.LGy.size());
    int j = (int)Util.nowSecond();
    Object localObject = (Iterable)this.LGy;
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
  
  public final void gCI()
  {
    AppMethodBeat.i(183991);
    if (gCH())
    {
      Iterator localIterator = ((Iterable)this.LGy).iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).field_syncTime = 0;
      }
      bj.gCJ().gCN().a(this);
      EventCenter.instance.publish((IEvent)new rj());
    }
    AppMethodBeat.o(183991);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/storage/EmojiDesignerProductList$Cache;", "", "()V", "map", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "Lcom/tencent/mm/storage/EmojiDesignerProductList;", "getMap", "()Lcom/tencent/mm/memory/cache/DefaultResource;", "get", "designerUin", "put", "", "info", "plugin-emojisdk_release"})
  public static final class a
  {
    private static final c<Integer, bg> Opt;
    public static final a Opu;
    
    static
    {
      AppMethodBeat.i(183989);
      Opu = new a();
      Opt = new c(500);
      AppMethodBeat.o(183989);
    }
    
    public static void a(int paramInt, bg parambg)
    {
      AppMethodBeat.i(183988);
      p.h(parambg, "info");
      Opt.put(Integer.valueOf(paramInt), parambg);
      AppMethodBeat.o(183988);
    }
    
    public static bg aki(int paramInt)
    {
      AppMethodBeat.i(183987);
      bg localbg2 = (bg)Opt.get(Integer.valueOf(paramInt));
      bg localbg1;
      if (MMApplicationContext.isMainProcess())
      {
        localbg1 = localbg2;
        if (localbg2 == null)
        {
          localbg1 = bj.gCJ().gCN().akn(paramInt);
          Opt.put(Integer.valueOf(paramInt), localbg1);
        }
      }
      for (;;)
      {
        p.g(localbg1, "info");
        AppMethodBeat.o(183987);
        return localbg1;
        localbg1 = new bg();
        localbg1.gWW = paramInt;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/storage/EmojiDesignerProductList$Companion;", "", "()V", "NEW_VALID", "", "plugin-emojisdk_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.bg
 * JD-Core Version:    0.7.0.1
 */