package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.jo;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMClearEditText;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class ModRemarkNameUI$8
  implements Runnable
{
  ModRemarkNameUI$8(ModRemarkNameUI paramModRemarkNameUI, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(293273);
    jo localjo = new jo();
    Object localObject1 = ModRemarkNameUI.m(this.Xug);
    localjo.AC(ModRemarkNameUI.n(this.Xug));
    long l;
    Object localObject2;
    int i;
    label67:
    String str;
    if (ModRemarkNameUI.o(this.Xug))
    {
      l = 1L;
      localjo.gLo = l;
      localObject2 = ((List)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject2).hasNext()) {
        break label117;
      }
      str = (String)((Iterator)localObject2).next();
      if (!ModRemarkNameUI.p(this.Xug).contains(str)) {
        break label880;
      }
      i += 1;
    }
    label868:
    label871:
    label874:
    label877:
    label880:
    for (;;)
    {
      break label67;
      l = 0L;
      break;
      label117:
      localjo.gLq = i;
      l = 0L;
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        if (ModRemarkNameUI.q(this.Xug).contains(str)) {
          l += 1L;
        }
      }
      localjo.gLs = l;
      localObject2 = ((List)localObject1).iterator();
      int j = 0;
      if (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        if (!ModRemarkNameUI.s(this.Xug).contains(str)) {
          break label877;
        }
        j += 1;
      }
      for (;;)
      {
        break;
        localjo.gLr = j;
        localObject2 = ((List)localObject1).iterator();
        int k = 0;
        if (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          if (!ModRemarkNameUI.r(this.Xug).contains(str)) {
            break label874;
          }
          k += 1;
        }
        for (;;)
        {
          break;
          localjo.gLp = k;
          localjo.guX = (System.currentTimeMillis() - ModRemarkNameUI.t(this.Xug));
          localjo.gLw = ModRemarkNameUI.u(this.Xug);
          localjo.gLx = this.HcK;
          localjo.gLt = ModRemarkNameUI.v(this.Xug);
          int n = 0;
          localObject2 = ((List)localObject1).iterator();
          int m = 0;
          if (((Iterator)localObject2).hasNext())
          {
            str = (String)((Iterator)localObject2).next();
            if (ModRemarkNameUI.w(this.Xug).contains(str)) {
              break label871;
            }
            m += 1;
          }
          for (;;)
          {
            break;
            localObject2 = ModRemarkNameUI.w(this.Xug).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              if (((List)localObject1).contains((String)((Iterator)localObject2).next())) {
                break label868;
              }
              n += 1;
            }
            for (;;)
            {
              break;
              localjo.gmT = 3L;
              localObject2 = ModRemarkNameUI.a(this.Xug).getText().toString().trim();
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              if (!ae.isNullOrNil(ModRemarkNameUI.x(this.Xug))) {
                if (ModRemarkNameUI.x(this.Xug).equals(localObject1)) {
                  ModRemarkNameUI.a(this.Xug, 3);
                }
              }
              for (;;)
              {
                localjo.gLy = ModRemarkNameUI.c(this.Xug);
                localjo.gLv = m;
                localjo.gLu = n;
                localjo.bpa();
                Log.i("MiroMsg.ModRemarkName", "22865 setAddedLabelCnt = " + m + ",setRemovedLabelCnt = " + n + ",oriLabelCnt = " + ModRemarkNameUI.v(this.Xug) + ",opResult = " + this.HcK + ",totalLabelCnt = " + ModRemarkNameUI.u(this.Xug) + ",selectNewLabelCnt = " + k + ",addRemarkType = " + ModRemarkNameUI.c(this.Xug) + ",scene= 3,selectAddLabelCnt = " + j + ",newLebalCountBySearch = " + i + ",searchAddLabelCnt = " + l);
                AppMethodBeat.o(293273);
                return;
                ModRemarkNameUI.a(this.Xug, 2);
                continue;
                if (!ModRemarkNameUI.y(this.Xug)) {
                  ModRemarkNameUI.a(this.Xug, 3);
                } else if (!ae.isNullOrNil(ModRemarkNameUI.z(this.Xug)))
                {
                  if (ModRemarkNameUI.z(this.Xug).equals(localObject1)) {
                    ModRemarkNameUI.a(this.Xug, 1);
                  } else if (Util.isNullOrNil((String)localObject1)) {
                    ModRemarkNameUI.a(this.Xug, 3);
                  } else {
                    ModRemarkNameUI.a(this.Xug, 2);
                  }
                }
                else if (((String)localObject1).equals(ModRemarkNameUI.z(this.Xug))) {
                  ModRemarkNameUI.a(this.Xug, 3);
                } else {
                  ModRemarkNameUI.a(this.Xug, 2);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ModRemarkNameUI.8
 * JD-Core Version:    0.7.0.1
 */