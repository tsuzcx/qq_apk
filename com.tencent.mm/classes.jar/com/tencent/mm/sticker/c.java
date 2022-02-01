package com.tencent.mm.sticker;

import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.h.a;
import androidx.recyclerview.widget.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cqu;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.protocal.protobuf.cqx;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/LensItem;", "", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "reportPos", "", "lensType", "(Lcom/tencent/mm/protocal/protobuf/LensInfo;II)V", "getLensInfo", "()Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getLensType", "()I", "setLensType", "(I)V", "getReportPos", "setReportPos", "Companion", "plugin-sticker_release"})
public final class c
{
  public static final a Vav;
  public final cqv Vat;
  public int Vau;
  public int jKi;
  
  static
  {
    AppMethodBeat.i(233086);
    Vav = new a((byte)0);
    AppMethodBeat.o(233086);
  }
  
  public c(cqv paramcqv, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(233082);
    this.Vat = paramcqv;
    this.jKi = paramInt1;
    this.Vau = paramInt2;
    AppMethodBeat.o(233082);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/LensItem$Companion;", "", "()V", "TypeHistory", "", "TypeMore", "TypeRecommend", "getDiff", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "oldList", "", "Lcom/tencent/mm/sticker/LensItem;", "newList", "lensContentEqual", "", "oldItem", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "newItem", "plugin-sticker_release"})
  public static final class a
  {
    public static h.b G(List<c> paramList1, final List<c> paramList2)
    {
      AppMethodBeat.i(232795);
      p.k(paramList1, "oldList");
      p.k(paramList2, "newList");
      paramList1 = h.a((h.a)new a(paramList1, paramList2), false);
      p.j(paramList1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
      AppMethodBeat.o(232795);
      return paramList1;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/sticker/LensItem$Companion$getDiff$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-sticker_release"})
    public static final class a
      extends h.a
    {
      a(List paramList1, List paramList2) {}
      
      public final boolean Z(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(233059);
        boolean bool = p.h(((c)this.Vaw.get(paramInt1)).Vat.LensId, ((c)paramList2.get(paramInt2)).Vat.LensId);
        AppMethodBeat.o(233059);
        return bool;
      }
      
      public final boolean ab(int paramInt1, int paramInt2)
      {
        Object localObject3 = null;
        AppMethodBeat.i(233061);
        Object localObject1 = c.Vav;
        cqv localcqv = ((c)this.Vaw.get(paramInt1)).Vat;
        Object localObject4 = ((c)paramList2.get(paramInt2)).Vat;
        p.k(localcqv, "oldItem");
        p.k(localObject4, "newItem");
        if (!Util.isNullOrNil(localcqv.LensId))
        {
          if (Util.isEqual(localcqv.LensId, ((cqv)localObject4).LensId))
          {
            localObject1 = localcqv.Tym;
            Object localObject2;
            if (localObject1 != null)
            {
              localObject1 = ((cqu)localObject1).Url;
              localObject2 = ((cqv)localObject4).Tym;
              if (localObject2 == null) {
                break label203;
              }
              localObject2 = ((cqu)localObject2).Url;
              label128:
              if (!Util.isEqual((String)localObject1, (String)localObject2)) {
                break label215;
              }
              localObject1 = localcqv.Tyn;
              if (localObject1 == null) {
                break label209;
              }
            }
            label203:
            label209:
            for (localObject1 = ((cqx)localObject1).RNi;; localObject1 = null)
            {
              localObject4 = ((cqv)localObject4).Tyn;
              localObject2 = localObject3;
              if (localObject4 != null) {
                localObject2 = ((cqx)localObject4).RNi;
              }
              if (!Util.isEqual((String)localObject1, (String)localObject2)) {
                break label215;
              }
              AppMethodBeat.o(233061);
              return true;
              localObject1 = null;
              break;
              localObject2 = null;
              break label128;
            }
          }
          label215:
          AppMethodBeat.o(233061);
          return false;
        }
        boolean bool = p.h(localcqv, localObject4);
        AppMethodBeat.o(233061);
        return bool;
      }
      
      public final int jL()
      {
        AppMethodBeat.i(233056);
        int i = this.Vaw.size();
        AppMethodBeat.o(233056);
        return i;
      }
      
      public final int jM()
      {
        AppMethodBeat.i(233057);
        int i = paramList2.size();
        AppMethodBeat.o(233057);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.c
 * JD-Core Version:    0.7.0.1
 */