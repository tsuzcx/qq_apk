package com.tencent.mm.plugin.recordvideo.activity.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIRouter$Companion;", "", "()V", "TAG", "", "autoRoute", "", "toWhere", "photoList", "", "videoList", "plugin-recordvideo_release"})
public final class b$a
{
  public static int c(int paramInt, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(75068);
    if (-1 == paramInt)
    {
      Collection localCollection = (Collection)paramList1;
      if ((localCollection == null) || (localCollection.isEmpty()))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label86;
        }
        paramInt = 0;
        label39:
        paramList1 = (Collection)paramList2;
        if ((paramList1 != null) && (!paramList1.isEmpty())) {
          break label103;
        }
        i = 1;
        label59:
        if (i == 0) {
          break label108;
        }
      }
      for (int i = 0;; i = paramList2.size())
      {
        if ((paramInt > 2) || (i != 0)) {
          break label125;
        }
        AppMethodBeat.o(75068);
        return 1;
        paramInt = 0;
        break;
        label86:
        if (paramList1 == null) {
          p.hyc();
        }
        paramInt = paramList1.size();
        break label39;
        label103:
        i = 0;
        break label59;
        label108:
        if (paramList2 == null) {
          p.hyc();
        }
      }
      label125:
      if ((paramInt > 2) && (i == 0))
      {
        AppMethodBeat.o(75068);
        return 3;
      }
      if (((paramInt > 0) && (i > 0)) || (i > 1) || (paramInt > 1))
      {
        AppMethodBeat.o(75068);
        return 4;
      }
      if ((paramInt == 0) && (i == 1))
      {
        AppMethodBeat.o(75068);
        return 2;
      }
      AppMethodBeat.o(75068);
      return 0;
    }
    AppMethodBeat.o(75068);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.a.b.a
 * JD-Core Version:    0.7.0.1
 */