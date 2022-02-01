package com.tencent.mm.plugin.vlog.model.effect;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/effect/MagicListData;", "", "()V", "addedEffectList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicAddEffectItem;", "effectList", "Lcom/tencent/mm/plugin/vlog/model/effect/EffectInfo;", "addEffect", "", "item", "getAddItemList", "", "getItemList", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "removeEffect", "Companion", "plugin-vlog_release"})
public final class c
{
  public static final a BYJ;
  public final LinkedList<b> BYH;
  private final LinkedList<a> BYI;
  
  static
  {
    AppMethodBeat.i(191289);
    BYJ = new a((byte)0);
    AppMethodBeat.o(191289);
  }
  
  public c()
  {
    AppMethodBeat.i(191288);
    this.BYH = new LinkedList();
    this.BYI = new LinkedList();
    AppMethodBeat.o(191288);
  }
  
  public final List<e> afz()
  {
    AppMethodBeat.i(191287);
    Object localObject1 = new LinkedList();
    if (this.BYH.size() > 0)
    {
      localObject2 = ak.getContext().getString(2131767099);
      p.g(localObject2, "MMApplicationContext.get…g.magic_list_title_added)");
      ((LinkedList)localObject1).add(new f((String)localObject2));
      ((LinkedList)localObject1).addAll((Collection)this.BYH);
    }
    Object localObject2 = ak.getContext().getString(2131767100);
    p.g(localObject2, "MMApplicationContext.get…ing.magic_list_title_all)");
    ((LinkedList)localObject1).add(new f((String)localObject2));
    localObject2 = ((Iterable)this.BYI).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).add(new d((a)((Iterator)localObject2).next()));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(191287);
    return localObject1;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/effect/MagicListData$Companion;", "", "()V", "MAGIC_CONFIG", "", "MAGIC_PATH", "TAG", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.effect.c
 * JD-Core Version:    0.7.0.1
 */