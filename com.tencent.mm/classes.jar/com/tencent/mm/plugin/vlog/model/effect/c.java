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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/effect/MagicListData;", "", "()V", "addedEffectList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicAddEffectItem;", "effectList", "Lcom/tencent/mm/plugin/vlog/model/effect/EffectInfo;", "addEffect", "", "item", "getAddItemList", "", "getItemList", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "removeEffect", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a Ubz;
  public final LinkedList<b> UbA;
  private final LinkedList<a> UbB;
  
  static
  {
    AppMethodBeat.i(283625);
    Ubz = new a((byte)0);
    AppMethodBeat.o(283625);
  }
  
  public c()
  {
    AppMethodBeat.i(283618);
    this.UbA = new LinkedList();
    this.UbB = new LinkedList();
    for (;;)
    {
      int j;
      try
      {
        Object localObject = MMApplicationContext.getContext().getAssets().open("pag/magic/pag_magic.json");
        s.s(localObject, "getContext().assets.open(MAGIC_CONFIG)");
        localObject = Util.streamToString((InputStream)localObject);
        Log.i("MicroMsg.MagicListData", s.X("initVideoTemplates config:", localObject));
        localObject = new i((String)localObject).Fr("magicList");
        int k = ((com.tencent.mm.ad.f)localObject).length();
        if (k > 0)
        {
          j = i + 1;
          i locali = ((com.tencent.mm.ad.f)localObject).st(i);
          if (locali.optInt("use", 0) == 1) {
            this.UbB.add(new a(s.X("pag/magic/", locali.optString("pag")), s.X("pag/magic/", locali.optString("cover"))));
          }
          if (j < k) {
            break label187;
          }
          AppMethodBeat.o(283618);
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MagicListData", "parse magic config error");
        AppMethodBeat.o(283618);
        return;
      }
      label187:
      i = j;
    }
  }
  
  public final List<e> aVf()
  {
    AppMethodBeat.i(283629);
    Object localObject1 = new LinkedList();
    if (this.UbA.size() > 0)
    {
      localObject2 = MMApplicationContext.getContext().getString(a.i.magic_list_title_added);
      s.s(localObject2, "getContext().getString(R…g.magic_list_title_added)");
      ((LinkedList)localObject1).add(new f((String)localObject2));
      ((LinkedList)localObject1).addAll((Collection)this.UbA);
    }
    Object localObject2 = MMApplicationContext.getContext().getString(a.i.magic_list_title_all);
    s.s(localObject2, "getContext().getString(R…ing.magic_list_title_all)");
    ((LinkedList)localObject1).add(new f((String)localObject2));
    localObject2 = ((Iterable)this.UbB).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).add(new d((a)((Iterator)localObject2).next()));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(283629);
    return localObject1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/effect/MagicListData$Companion;", "", "()V", "MAGIC_CONFIG", "", "MAGIC_PATH", "TAG", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.effect.c
 * JD-Core Version:    0.7.0.1
 */