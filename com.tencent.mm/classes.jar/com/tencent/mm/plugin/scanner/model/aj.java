package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.scanner.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.qbar.a.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/WxScanCodeResultFilter;", "Lcom/tencent/mm/plugin/scanner/result/IScanCodeResultFilter;", "()V", "directJumpWhiteCode", "", "directJumpWhiteListCode", "filter", "", "Lcom/tencent/qbar/QBar$QBarResult;", "codeResultList", "Companion", "plugin-scan_release"})
public final class aj
  implements c
{
  public static final a yoT;
  private boolean yoS;
  
  static
  {
    AppMethodBeat.i(186336);
    yoT = new a((byte)0);
    AppMethodBeat.o(186336);
  }
  
  public aj()
  {
    AppMethodBeat.i(186335);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBJ, 0);
    if (i != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.yoS = bool;
      ad.i("MicroMsg.WxScanCodeResultFilter", "alvinluo WxScanCodeResultFilter init config: %d, directJumpWhiteCode: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.yoS) });
      AppMethodBeat.o(186335);
      return;
    }
  }
  
  public final List<a.a> fw(List<? extends a.a> paramList)
  {
    boolean bool2 = true;
    AppMethodBeat.i(186334);
    p.h(paramList, "codeResultList");
    if (paramList.size() <= 1)
    {
      AppMethodBeat.o(186334);
      return paramList;
    }
    List localList2 = (List)new ArrayList();
    List localList1 = (List)new ArrayList();
    Object localObject = ((Iterable)paramList).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      if (com.tencent.qbar.b.aZd(locala.data))
      {
        i += 1;
      }
      else
      {
        localList2.add(locala);
        if (com.tencent.qbar.b.aZc(locala.data)) {
          localList1.add(locala);
        }
      }
    }
    int j;
    int k;
    int m;
    int n;
    boolean bool1;
    if ((i != paramList.size()) && (localList1.size() == 1)) {
      if (i == paramList.size() - localList1.size())
      {
        localObject = localList1;
        j = localList1.size();
        k = localList2.size();
        m = paramList.size();
        n = ((List)localObject).size();
        if (((List)localObject).size() != 1) {
          break label360;
        }
        bool1 = true;
        label233:
        if (((List)localObject).size() != paramList.size()) {
          break label366;
        }
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.WxScanCodeResultFilter", "alvinluo filter badCodeNum: %d, whiteCodeNum: %d, commonCodeNum: %d, originNum: %d, finalNum: %d, directJump: %b, showMultiCode: %b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      AppMethodBeat.o(186334);
      return localObject;
      if (i == 0)
      {
        if (this.yoS)
        {
          localObject = localList1;
          break;
        }
        localObject = paramList;
        break;
      }
      localObject = paramList;
      break;
      localObject = paramList;
      break;
      label360:
      bool1 = false;
      break label233;
      label366:
      bool2 = false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/WxScanCodeResultFilter$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.aj
 * JD-Core Version:    0.7.0.1
 */