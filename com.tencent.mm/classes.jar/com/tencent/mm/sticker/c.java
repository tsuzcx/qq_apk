package com.tencent.mm.sticker;

import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bur;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.protocal.protobuf.buu;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/LensItem;", "", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "reportPos", "", "lensType", "(Lcom/tencent/mm/protocal/protobuf/LensInfo;II)V", "getLensInfo", "()Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getLensType", "()I", "setLensType", "(I)V", "getReportPos", "setReportPos", "Companion", "plugin-sticker_release"})
public final class c
{
  public static final a IFT;
  public final bus IFR;
  public int IFS;
  public int gon;
  
  static
  {
    AppMethodBeat.i(208255);
    IFT = new a((byte)0);
    AppMethodBeat.o(208255);
  }
  
  public c(bus parambus, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208253);
    this.IFR = parambus;
    this.gon = paramInt1;
    this.IFS = paramInt2;
    AppMethodBeat.o(208253);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/LensItem$Companion;", "", "()V", "TypeHistory", "", "TypeMore", "TypeRecommend", "getDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldList", "", "Lcom/tencent/mm/sticker/LensItem;", "newList", "lensContentEqual", "", "oldItem", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "newItem", "plugin-sticker_release"})
  public static final class a
  {
    public static c.b E(List<c> paramList1, final List<c> paramList2)
    {
      AppMethodBeat.i(208252);
      p.h(paramList1, "oldList");
      p.h(paramList2, "newList");
      paramList1 = android.support.v7.h.c.a((android.support.v7.h.c.a)new a(paramList1, paramList2), false);
      p.g(paramList1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
      AppMethodBeat.o(208252);
      return paramList1;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/sticker/LensItem$Companion$getDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-sticker_release"})
    public static final class a
      extends android.support.v7.h.c.a
    {
      a(List paramList1, List paramList2) {}
      
      public final int aA()
      {
        AppMethodBeat.i(208249);
        int i = paramList2.size();
        AppMethodBeat.o(208249);
        return i;
      }
      
      public final int az()
      {
        AppMethodBeat.i(208248);
        int i = this.IFU.size();
        AppMethodBeat.o(208248);
        return i;
      }
      
      public final boolean i(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(208250);
        boolean bool = p.i(((c)this.IFU.get(paramInt1)).IFR.GwI, ((c)paramList2.get(paramInt2)).IFR.GwI);
        AppMethodBeat.o(208250);
        return bool;
      }
      
      public final boolean j(int paramInt1, int paramInt2)
      {
        Object localObject3 = null;
        AppMethodBeat.i(208251);
        Object localObject1 = c.IFT;
        bus localbus = ((c)this.IFU.get(paramInt1)).IFR;
        Object localObject4 = ((c)paramList2.get(paramInt2)).IFR;
        p.h(localbus, "oldItem");
        p.h(localObject4, "newItem");
        if (!bu.isNullOrNil(localbus.GwI))
        {
          if (bu.lX(localbus.GwI, ((bus)localObject4).GwI))
          {
            localObject1 = localbus.HhP;
            Object localObject2;
            if (localObject1 != null)
            {
              localObject1 = ((bur)localObject1).Url;
              localObject2 = ((bus)localObject4).HhP;
              if (localObject2 == null) {
                break label203;
              }
              localObject2 = ((bur)localObject2).Url;
              label128:
              if (!bu.lX((String)localObject1, (String)localObject2)) {
                break label215;
              }
              localObject1 = localbus.HhQ;
              if (localObject1 == null) {
                break label209;
              }
            }
            label203:
            label209:
            for (localObject1 = ((buu)localObject1).FSC;; localObject1 = null)
            {
              localObject4 = ((bus)localObject4).HhQ;
              localObject2 = localObject3;
              if (localObject4 != null) {
                localObject2 = ((buu)localObject4).FSC;
              }
              if (!bu.lX((String)localObject1, (String)localObject2)) {
                break label215;
              }
              AppMethodBeat.o(208251);
              return true;
              localObject1 = null;
              break;
              localObject2 = null;
              break label128;
            }
          }
          label215:
          AppMethodBeat.o(208251);
          return false;
        }
        boolean bool = p.i(localbus, localObject4);
        AppMethodBeat.o(208251);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.c
 * JD-Core Version:    0.7.0.1
 */