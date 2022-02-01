package com.tencent.mm.sticker;

import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/LensItem;", "", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "reportPos", "", "lensType", "(Lcom/tencent/mm/protocal/protobuf/LensInfo;II)V", "getLensInfo", "()Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getLensType", "()I", "setLensType", "(I)V", "getReportPos", "setReportPos", "Companion", "plugin-sticker_release"})
public final class c
{
  public static final a IlI;
  public final bty IlG;
  public int IlH;
  public int glS;
  
  static
  {
    AppMethodBeat.i(215376);
    IlI = new a((byte)0);
    AppMethodBeat.o(215376);
  }
  
  public c(bty parambty, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215374);
    this.IlG = parambty;
    this.glS = paramInt1;
    this.IlH = paramInt2;
    AppMethodBeat.o(215374);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/LensItem$Companion;", "", "()V", "TypeHistory", "", "TypeMore", "TypeRecommend", "getDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldList", "", "Lcom/tencent/mm/sticker/LensItem;", "newList", "lensContentEqual", "", "oldItem", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "newItem", "plugin-sticker_release"})
  public static final class a
  {
    public static c.b F(List<c> paramList1, final List<c> paramList2)
    {
      AppMethodBeat.i(215373);
      p.h(paramList1, "oldList");
      p.h(paramList2, "newList");
      paramList1 = android.support.v7.h.c.a((android.support.v7.h.c.a)new a(paramList1, paramList2), false);
      p.g(paramList1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
      AppMethodBeat.o(215373);
      return paramList1;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/sticker/LensItem$Companion$getDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-sticker_release"})
    public static final class a
      extends android.support.v7.h.c.a
    {
      a(List paramList1, List paramList2) {}
      
      public final int aA()
      {
        AppMethodBeat.i(215370);
        int i = paramList2.size();
        AppMethodBeat.o(215370);
        return i;
      }
      
      public final int az()
      {
        AppMethodBeat.i(215369);
        int i = this.IlJ.size();
        AppMethodBeat.o(215369);
        return i;
      }
      
      public final boolean i(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(215371);
        boolean bool = p.i(((c)this.IlJ.get(paramInt1)).IlG.Geb, ((c)paramList2.get(paramInt2)).IlG.Geb);
        AppMethodBeat.o(215371);
        return bool;
      }
      
      public final boolean j(int paramInt1, int paramInt2)
      {
        Object localObject3 = null;
        AppMethodBeat.i(215372);
        Object localObject1 = c.IlI;
        bty localbty = ((c)this.IlJ.get(paramInt1)).IlG;
        Object localObject4 = ((c)paramList2.get(paramInt2)).IlG;
        p.h(localbty, "oldItem");
        p.h(localObject4, "newItem");
        if (!bt.isNullOrNil(localbty.Geb))
        {
          if (bt.lQ(localbty.Geb, ((bty)localObject4).Geb))
          {
            localObject1 = localbty.GOp;
            Object localObject2;
            if (localObject1 != null)
            {
              localObject1 = ((btx)localObject1).Url;
              localObject2 = ((bty)localObject4).GOp;
              if (localObject2 == null) {
                break label203;
              }
              localObject2 = ((btx)localObject2).Url;
              label128:
              if (!bt.lQ((String)localObject1, (String)localObject2)) {
                break label215;
              }
              localObject1 = localbty.GOq;
              if (localObject1 == null) {
                break label209;
              }
            }
            label203:
            label209:
            for (localObject1 = ((bua)localObject1).FAe;; localObject1 = null)
            {
              localObject4 = ((bty)localObject4).GOq;
              localObject2 = localObject3;
              if (localObject4 != null) {
                localObject2 = ((bua)localObject4).FAe;
              }
              if (!bt.lQ((String)localObject1, (String)localObject2)) {
                break label215;
              }
              AppMethodBeat.o(215372);
              return true;
              localObject1 = null;
              break;
              localObject2 = null;
              break label128;
            }
          }
          label215:
          AppMethodBeat.o(215372);
          return false;
        }
        boolean bool = p.i(localbty, localObject4);
        AppMethodBeat.o(215372);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.c
 * JD-Core Version:    0.7.0.1
 */