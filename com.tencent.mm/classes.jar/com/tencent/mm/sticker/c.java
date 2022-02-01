package com.tencent.mm.sticker;

import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.protocal.protobuf.bpn;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/LensItem;", "", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "reportPos", "", "lensType", "(Lcom/tencent/mm/protocal/protobuf/LensInfo;II)V", "getLensInfo", "()Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getLensType", "()I", "setLensType", "(I)V", "getReportPos", "setReportPos", "Companion", "plugin-sticker_release"})
public final class c
{
  public static final a GzO;
  public final bpl GzM;
  public int GzN;
  public int fSo;
  
  static
  {
    AppMethodBeat.i(204907);
    GzO = new a((byte)0);
    AppMethodBeat.o(204907);
  }
  
  public c(bpl parambpl, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204905);
    this.GzM = parambpl;
    this.fSo = paramInt1;
    this.GzN = paramInt2;
    AppMethodBeat.o(204905);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/LensItem$Companion;", "", "()V", "TypeHistory", "", "TypeMore", "TypeRecommend", "getDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldList", "", "Lcom/tencent/mm/sticker/LensItem;", "newList", "lensContentEqual", "", "oldItem", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "newItem", "plugin-sticker_release"})
  public static final class a
  {
    public static c.b D(List<c> paramList1, final List<c> paramList2)
    {
      AppMethodBeat.i(204904);
      k.h(paramList1, "oldList");
      k.h(paramList2, "newList");
      paramList1 = android.support.v7.h.c.a((android.support.v7.h.c.a)new a(paramList1, paramList2), false);
      k.g(paramList1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
      AppMethodBeat.o(204904);
      return paramList1;
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/sticker/LensItem$Companion$getDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-sticker_release"})
    public static final class a
      extends android.support.v7.h.c.a
    {
      a(List paramList1, List paramList2) {}
      
      public final boolean H(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(204902);
        boolean bool = k.g(((c)this.GzP.get(paramInt1)).GzM.Ewy, ((c)paramList2.get(paramInt2)).GzM.Ewy);
        AppMethodBeat.o(204902);
        return bool;
      }
      
      public final boolean I(int paramInt1, int paramInt2)
      {
        Object localObject3 = null;
        AppMethodBeat.i(204903);
        Object localObject1 = c.GzO;
        bpl localbpl = ((c)this.GzP.get(paramInt1)).GzM;
        Object localObject4 = ((c)paramList2.get(paramInt2)).GzM;
        k.h(localbpl, "oldItem");
        k.h(localObject4, "newItem");
        if (!bs.isNullOrNil(localbpl.Ewy))
        {
          if (bs.lr(localbpl.Ewy, ((bpl)localObject4).Ewy))
          {
            localObject1 = localbpl.FeL;
            Object localObject2;
            if (localObject1 != null)
            {
              localObject1 = ((bpk)localObject1).Url;
              localObject2 = ((bpl)localObject4).FeL;
              if (localObject2 == null) {
                break label203;
              }
              localObject2 = ((bpk)localObject2).Url;
              label128:
              if (!bs.lr((String)localObject1, (String)localObject2)) {
                break label215;
              }
              localObject1 = localbpl.FeM;
              if (localObject1 == null) {
                break label209;
              }
            }
            label203:
            label209:
            for (localObject1 = ((bpn)localObject1).DUJ;; localObject1 = null)
            {
              localObject4 = ((bpl)localObject4).FeM;
              localObject2 = localObject3;
              if (localObject4 != null) {
                localObject2 = ((bpn)localObject4).DUJ;
              }
              if (!bs.lr((String)localObject1, (String)localObject2)) {
                break label215;
              }
              AppMethodBeat.o(204903);
              return true;
              localObject1 = null;
              break;
              localObject2 = null;
              break label128;
            }
          }
          label215:
          AppMethodBeat.o(204903);
          return false;
        }
        boolean bool = k.g(localbpl, localObject4);
        AppMethodBeat.o(204903);
        return bool;
      }
      
      public final int gZ()
      {
        AppMethodBeat.i(204900);
        int i = this.GzP.size();
        AppMethodBeat.o(204900);
        return i;
      }
      
      public final int ha()
      {
        AppMethodBeat.i(204901);
        int i = paramList2.size();
        AppMethodBeat.o(204901);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.c
 * JD-Core Version:    0.7.0.1
 */