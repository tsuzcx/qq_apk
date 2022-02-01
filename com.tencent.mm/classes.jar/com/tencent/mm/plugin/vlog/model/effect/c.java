package com.tencent.mm.plugin.vlog.model.effect;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/effect/MagicListData;", "", "()V", "addedEffectList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicAddEffectItem;", "effectList", "Lcom/tencent/mm/plugin/vlog/model/effect/EffectInfo;", "addEffect", "", "item", "getAddItemList", "", "getItemList", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "removeEffect", "Companion", "plugin-vlog_release"})
public final class c
{
  public static final a BHk;
  public final LinkedList<b> BHi;
  private final LinkedList<a> BHj;
  
  static
  {
    AppMethodBeat.i(195830);
    BHk = new a((byte)0);
    AppMethodBeat.o(195830);
  }
  
  public c()
  {
    AppMethodBeat.i(195829);
    this.BHi = new LinkedList();
    this.BHj = new LinkedList();
    AppMethodBeat.o(195829);
  }
  
  public final List<e> afl()
  {
    AppMethodBeat.i(195828);
    Object localObject1 = new LinkedList();
    if (this.BHi.size() > 0)
    {
      localObject2 = aj.getContext().getString(2131767099);
      p.g(localObject2, "MMApplicationContext.get…g.magic_list_title_added)");
      ((LinkedList)localObject1).add(new f((String)localObject2));
      ((LinkedList)localObject1).addAll((Collection)this.BHi);
    }
    Object localObject2 = aj.getContext().getString(2131767100);
    p.g(localObject2, "MMApplicationContext.get…ing.magic_list_title_all)");
    ((LinkedList)localObject1).add(new f((String)localObject2));
    localObject2 = ((Iterable)this.BHj).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).add(new d((a)((Iterator)localObject2).next()));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(195828);
    return localObject1;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/effect/MagicListData$Companion;", "", "()V", "MAGIC_CONFIG", "", "MAGIC_PATH", "TAG", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.effect.c
 * JD-Core Version:    0.7.0.1
 */