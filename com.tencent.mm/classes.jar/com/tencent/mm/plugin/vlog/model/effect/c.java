package com.tencent.mm.plugin.vlog.model.effect;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/effect/MagicListData;", "", "()V", "addedEffectList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicAddEffectItem;", "effectList", "Lcom/tencent/mm/plugin/vlog/model/effect/EffectInfo;", "addEffect", "", "item", "getAddItemList", "", "getItemList", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "removeEffect", "Companion", "plugin-vlog_release"})
public final class c
{
  public static final a GAq;
  public final LinkedList<b> GAo;
  private final LinkedList<a> GAp;
  
  static
  {
    AppMethodBeat.i(190731);
    GAq = new a((byte)0);
    AppMethodBeat.o(190731);
  }
  
  public c()
  {
    AppMethodBeat.i(190730);
    this.GAo = new LinkedList();
    this.GAp = new LinkedList();
    try
    {
      Object localObject = MMApplicationContext.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getAssets().open("pag/magic/pag_magic.json");
      p.g(localObject, "MMApplicationContext.get…assets.open(MAGIC_CONFIG)");
      localObject = Util.streamToString((InputStream)localObject);
      Log.i("MicroMsg.MagicListData", "initVideoTemplates config:".concat(String.valueOf(localObject)));
      localObject = new i((String)localObject).FI("magicList");
      int j = ((com.tencent.mm.ab.f)localObject).length();
      while (i < j)
      {
        i locali = ((com.tencent.mm.ab.f)localObject).pY(i);
        if (locali.optInt("use", 0) == 1) {
          this.GAp.add(new a("pag/magic/" + locali.optString("pag"), "pag/magic/" + locali.optString("cover")));
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MagicListData", "parse magic config error");
      AppMethodBeat.o(190730);
    }
  }
  
  public final List<e> avn()
  {
    AppMethodBeat.i(190729);
    Object localObject1 = new LinkedList();
    if (this.GAo.size() > 0)
    {
      localObject2 = MMApplicationContext.getContext().getString(2131762801);
      p.g(localObject2, "MMApplicationContext.get…g.magic_list_title_added)");
      ((LinkedList)localObject1).add(new f((String)localObject2));
      ((LinkedList)localObject1).addAll((Collection)this.GAo);
    }
    Object localObject2 = MMApplicationContext.getContext().getString(2131762802);
    p.g(localObject2, "MMApplicationContext.get…ing.magic_list_title_all)");
    ((LinkedList)localObject1).add(new f((String)localObject2));
    localObject2 = ((Iterable)this.GAp).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).add(new d((a)((Iterator)localObject2).next()));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(190729);
    return localObject1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/effect/MagicListData$Companion;", "", "()V", "MAGIC_CONFIG", "", "MAGIC_PATH", "TAG", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.effect.c
 * JD-Core Version:    0.7.0.1
 */