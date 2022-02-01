package com.tencent.mm.sticker;

import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/LensItem$Companion;", "", "()V", "TypeHistory", "", "TypeMore", "TypeRecommend", "getDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldList", "", "Lcom/tencent/mm/sticker/LensItem;", "newList", "lensContentEqual", "", "oldItem", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "newItem", "plugin-sticker_release"})
public final class c$a
{
  public static c.b A(List<c> paramList1, final List<c> paramList2)
  {
    AppMethodBeat.i(194211);
    p.h(paramList1, "oldList");
    p.h(paramList2, "newList");
    paramList1 = android.support.v7.h.c.a((android.support.v7.h.c.a)new a(paramList1, paramList2), false);
    p.g(paramList1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
    AppMethodBeat.o(194211);
    return paramList1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/sticker/LensItem$Companion$getDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-sticker_release"})
  public static final class a
    extends android.support.v7.h.c.a
  {
    a(List paramList1, List paramList2) {}
    
    public final int aB()
    {
      AppMethodBeat.i(194207);
      int i = this.NMM.size();
      AppMethodBeat.o(194207);
      return i;
    }
    
    public final int aC()
    {
      AppMethodBeat.i(194208);
      int i = paramList2.size();
      AppMethodBeat.o(194208);
      return i;
    }
    
    public final boolean i(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(194209);
      boolean bool = p.j(((c)this.NMM.get(paramInt1)).NMJ.Lso, ((c)paramList2.get(paramInt2)).NMJ.Lso);
      AppMethodBeat.o(194209);
      return bool;
    }
    
    public final boolean j(int paramInt1, int paramInt2)
    {
      Object localObject3 = null;
      AppMethodBeat.i(194210);
      Object localObject1 = c.NML;
      chz localchz = ((c)this.NMM.get(paramInt1)).NMJ;
      Object localObject4 = ((c)paramList2.get(paramInt2)).NMJ;
      p.h(localchz, "oldItem");
      p.h(localObject4, "newItem");
      if (!Util.isNullOrNil(localchz.Lso))
      {
        if (Util.isEqual(localchz.Lso, ((chz)localObject4).Lso))
        {
          localObject1 = localchz.Mnr;
          Object localObject2;
          if (localObject1 != null)
          {
            localObject1 = ((chy)localObject1).Url;
            localObject2 = ((chz)localObject4).Mnr;
            if (localObject2 == null) {
              break label203;
            }
            localObject2 = ((chy)localObject2).Url;
            label128:
            if (!Util.isEqual((String)localObject1, (String)localObject2)) {
              break label215;
            }
            localObject1 = localchz.Mns;
            if (localObject1 == null) {
              break label209;
            }
          }
          label203:
          label209:
          for (localObject1 = ((cib)localObject1).KMl;; localObject1 = null)
          {
            localObject4 = ((chz)localObject4).Mns;
            localObject2 = localObject3;
            if (localObject4 != null) {
              localObject2 = ((cib)localObject4).KMl;
            }
            if (!Util.isEqual((String)localObject1, (String)localObject2)) {
              break label215;
            }
            AppMethodBeat.o(194210);
            return true;
            localObject1 = null;
            break;
            localObject2 = null;
            break label128;
          }
        }
        label215:
        AppMethodBeat.o(194210);
        return false;
      }
      boolean bool = p.j(localchz, localObject4);
      AppMethodBeat.o(194210);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.c.a
 * JD-Core Version:    0.7.0.1
 */