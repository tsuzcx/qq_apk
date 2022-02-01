package com.tencent.mm.sticker;

import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.g.a;
import androidx.recyclerview.widget.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dho;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.protocal.protobuf.dhr;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/LensItem$Companion;", "", "()V", "TypeHistory", "", "TypeMore", "TypeRecommend", "getDiff", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "oldList", "", "Lcom/tencent/mm/sticker/LensItem;", "newList", "lensContentEqual", "", "oldItem", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "newItem", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$a
{
  public static g.b T(List<c> paramList1, final List<c> paramList2)
  {
    AppMethodBeat.i(233860);
    s.u(paramList1, "oldList");
    s.u(paramList2, "newList");
    paramList1 = g.a((g.a)new a(paramList1, paramList2), false);
    s.s(paramList1, "oldList: List<LensItem>,…  }\n            }, false)");
    AppMethodBeat.o(233860);
    return paramList1;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/sticker/LensItem$Companion$getDiff$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends g.a
  {
    a(List<c> paramList1, List<c> paramList2) {}
    
    public final int If()
    {
      AppMethodBeat.i(233861);
      int i = this.qOm.size();
      AppMethodBeat.o(233861);
      return i;
    }
    
    public final int Ig()
    {
      AppMethodBeat.i(233865);
      int i = paramList2.size();
      AppMethodBeat.o(233865);
      return i;
    }
    
    public final boolean aU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(233868);
      boolean bool = s.p(((c)this.qOm.get(paramInt1)).acBO.LensId, ((c)paramList2.get(paramInt2)).acBO.LensId);
      AppMethodBeat.o(233868);
      return bool;
    }
    
    public final boolean aV(int paramInt1, int paramInt2)
    {
      Object localObject3 = null;
      AppMethodBeat.i(233870);
      Object localObject1 = c.acBN;
      dhp localdhp2 = ((c)this.qOm.get(paramInt1)).acBO;
      dhp localdhp1 = ((c)paramList2.get(paramInt2)).acBO;
      s.u(localdhp2, "oldItem");
      s.u(localdhp1, "newItem");
      if (!Util.isNullOrNil(localdhp2.LensId))
      {
        if (Util.isEqual(localdhp2.LensId, localdhp1.LensId))
        {
          localObject1 = localdhp2.aaMT;
          if (localObject1 == null)
          {
            localObject1 = null;
            localObject2 = localdhp1.aaMT;
            if (localObject2 != null) {
              break label188;
            }
            localObject2 = null;
            label120:
            if (!Util.isEqual((String)localObject1, (String)localObject2)) {
              break label218;
            }
            localObject1 = localdhp2.aaMU;
            if (localObject1 != null) {
              break label198;
            }
            localObject1 = null;
            label145:
            localObject2 = localdhp1.aaMU;
            if (localObject2 != null) {
              break label208;
            }
          }
          label188:
          label198:
          label208:
          for (Object localObject2 = localObject3;; localObject2 = ((dhr)localObject2).YKw)
          {
            if (!Util.isEqual((String)localObject1, (String)localObject2)) {
              break label218;
            }
            AppMethodBeat.o(233870);
            return true;
            localObject1 = ((dho)localObject1).Url;
            break;
            localObject2 = ((dho)localObject2).Url;
            break label120;
            localObject1 = ((dhr)localObject1).YKw;
            break label145;
          }
        }
        label218:
        AppMethodBeat.o(233870);
        return false;
      }
      boolean bool = s.p(localdhp2, localdhp1);
      AppMethodBeat.o(233870);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sticker.c.a
 * JD-Core Version:    0.7.0.1
 */