package com.tencent.mm.sticker;

import android.support.v7.h.c;
import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.blo;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.blr;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/LensItem;", "", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "reportPos", "", "lensType", "(Lcom/tencent/mm/protocal/protobuf/LensInfo;II)V", "getLensInfo", "()Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getLensType", "()I", "setLensType", "(I)V", "getReportPos", "setReportPos", "Companion", "plugin-sticker_release"})
public final class g
{
  public static final a LAu;
  public int LAt;
  public int fOD;
  public final blp oKq;
  
  static
  {
    AppMethodBeat.i(202296);
    LAu = new a((byte)0);
    AppMethodBeat.o(202296);
  }
  
  public g(blp paramblp, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202294);
    this.oKq = paramblp;
    this.fOD = paramInt1;
    this.LAt = paramInt2;
    AppMethodBeat.o(202294);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/LensItem$Companion;", "", "()V", "TypeHistory", "", "TypeMore", "TypeRecommend", "getDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldList", "", "Lcom/tencent/mm/sticker/LensItem;", "newList", "lensContentEqual", "", "oldItem", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "newItem", "plugin-sticker_release"})
  public static final class a
  {
    public static c.b k(List<g> paramList1, final List<g> paramList2)
    {
      AppMethodBeat.i(202293);
      k.h(paramList1, "oldList");
      k.h(paramList2, "newList");
      paramList1 = c.a((c.a)new a(paramList1, paramList2), false);
      k.g(paramList1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
      AppMethodBeat.o(202293);
      return paramList1;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/sticker/LensItem$Companion$getDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-sticker_release"})
    public static final class a
      extends c.a
    {
      a(List paramList1, List paramList2) {}
      
      public final boolean H(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(202291);
        boolean bool = k.g(((g)this.LAv.get(paramInt1)).oKq.Dds, ((g)paramList2.get(paramInt2)).oKq.Dds);
        AppMethodBeat.o(202291);
        return bool;
      }
      
      public final boolean I(int paramInt1, int paramInt2)
      {
        Object localObject3 = null;
        AppMethodBeat.i(202292);
        Object localObject1 = g.LAu;
        blp localblp = ((g)this.LAv.get(paramInt1)).oKq;
        Object localObject4 = ((g)paramList2.get(paramInt2)).oKq;
        k.h(localblp, "oldItem");
        k.h(localObject4, "newItem");
        if (!bt.isNullOrNil(localblp.Dds))
        {
          if (bt.kU(localblp.Dds, ((blp)localObject4).Dds))
          {
            localObject1 = localblp.DJq;
            Object localObject2;
            if (localObject1 != null)
            {
              localObject1 = ((blo)localObject1).Url;
              localObject2 = ((blp)localObject4).DJq;
              if (localObject2 == null) {
                break label203;
              }
              localObject2 = ((blo)localObject2).Url;
              label128:
              if (!bt.kU((String)localObject1, (String)localObject2)) {
                break label215;
              }
              localObject1 = localblp.DJr;
              if (localObject1 == null) {
                break label209;
              }
            }
            label203:
            label209:
            for (localObject1 = ((blr)localObject1).CCm;; localObject1 = null)
            {
              localObject4 = ((blp)localObject4).DJr;
              localObject2 = localObject3;
              if (localObject4 != null) {
                localObject2 = ((blr)localObject4).CCm;
              }
              if (!bt.kU((String)localObject1, (String)localObject2)) {
                break label215;
              }
              AppMethodBeat.o(202292);
              return true;
              localObject1 = null;
              break;
              localObject2 = null;
              break label128;
            }
          }
          label215:
          AppMethodBeat.o(202292);
          return false;
        }
        boolean bool = k.g(localblp, localObject4);
        AppMethodBeat.o(202292);
        return bool;
      }
      
      public final int gR()
      {
        AppMethodBeat.i(202289);
        int i = this.LAv.size();
        AppMethodBeat.o(202289);
        return i;
      }
      
      public final int gS()
      {
        AppMethodBeat.i(202290);
        int i = paramList2.size();
        AppMethodBeat.o(202290);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sticker.g
 * JD-Core Version:    0.7.0.1
 */