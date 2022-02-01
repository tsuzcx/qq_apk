package com.tencent.mm.plugin.vlog.model.effect;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.vlog.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/effect/MagicListData;", "", "()V", "addedEffectList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicAddEffectItem;", "effectList", "Lcom/tencent/mm/plugin/vlog/model/effect/EffectInfo;", "addEffect", "", "item", "getAddItemList", "", "getItemList", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "removeEffect", "Companion", "plugin-vlog_release"})
public final class c
{
  public static final a NnW;
  public final LinkedList<b> NnU;
  private final LinkedList<a> NnV;
  
  static
  {
    AppMethodBeat.i(252343);
    NnW = new a((byte)0);
    AppMethodBeat.o(252343);
  }
  
  public c()
  {
    AppMethodBeat.i(252342);
    this.NnU = new LinkedList();
    this.NnV = new LinkedList();
    try
    {
      Object localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getAssets().open("pag/magic/pag_magic.json");
      p.j(localObject, "MMApplicationContext.get…assets.open(MAGIC_CONFIG)");
      localObject = Util.streamToString((InputStream)localObject);
      Log.i("MicroMsg.MagicListData", "initVideoTemplates config:".concat(String.valueOf(localObject)));
      localObject = new i((String)localObject).MI("magicList");
      int j = ((com.tencent.mm.ad.f)localObject).length();
      while (i < j)
      {
        i locali = ((com.tencent.mm.ad.f)localObject).sx(i);
        if (locali.optInt("use", 0) == 1) {
          this.NnV.add(new a("pag/magic/" + locali.optString("pag"), "pag/magic/" + locali.optString("cover")));
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MagicListData", "parse magic config error");
      AppMethodBeat.o(252342);
    }
  }
  
  public final List<e> aCj()
  {
    AppMethodBeat.i(252341);
    Object localObject1 = new LinkedList();
    if (this.NnU.size() > 0)
    {
      localObject2 = MMApplicationContext.getContext().getString(a.i.magic_list_title_added);
      p.j(localObject2, "MMApplicationContext.get…g.magic_list_title_added)");
      ((LinkedList)localObject1).add(new f((String)localObject2));
      ((LinkedList)localObject1).addAll((Collection)this.NnU);
    }
    Object localObject2 = MMApplicationContext.getContext().getString(a.i.magic_list_title_all);
    p.j(localObject2, "MMApplicationContext.get…ing.magic_list_title_all)");
    ((LinkedList)localObject1).add(new f((String)localObject2));
    localObject2 = ((Iterable)this.NnV).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).add(new d((a)((Iterator)localObject2).next()));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(252341);
    return localObject1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/effect/MagicListData$Companion;", "", "()V", "MAGIC_CONFIG", "", "MAGIC_PATH", "TAG", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.effect.c
 * JD-Core Version:    0.7.0.1
 */