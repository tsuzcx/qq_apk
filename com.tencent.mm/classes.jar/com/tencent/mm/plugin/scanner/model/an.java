package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.scanner.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qbar.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/WxScanCodeResultFilter;", "Lcom/tencent/mm/plugin/scanner/result/IScanCodeResultFilter;", "()V", "directJumpWhiteCode", "", "directJumpWhiteListCode", "filter", "", "Lcom/tencent/qbar/QBar$QBarResult;", "codeResultList", "Companion", "plugin-scan_release"})
public final class an
  implements c
{
  public static final a CHS;
  private boolean CHR;
  
  static
  {
    AppMethodBeat.i(240479);
    CHS = new a((byte)0);
    AppMethodBeat.o(240479);
  }
  
  public an()
  {
    AppMethodBeat.i(240478);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.seA, 0);
    if (i != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.CHR = bool;
      Log.i("MicroMsg.WxScanCodeResultFilter", "alvinluo WxScanCodeResultFilter init config: %d, directJumpWhiteCode: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.CHR) });
      AppMethodBeat.o(240478);
      return;
    }
  }
  
  public final List<a.a> gC(List<? extends a.a> paramList)
  {
    boolean bool2 = true;
    AppMethodBeat.i(240477);
    p.h(paramList, "codeResultList");
    if (paramList.size() <= 1)
    {
      AppMethodBeat.o(240477);
      return paramList;
    }
    List localList2 = (List)new ArrayList();
    List localList1 = (List)new ArrayList();
    Object localObject = ((Iterable)paramList).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      if (com.tencent.qbar.b.bpV(locala.data))
      {
        i += 1;
      }
      else
      {
        localList2.add(locala);
        if (com.tencent.qbar.b.bpU(locala.data)) {
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
      Log.i("MicroMsg.WxScanCodeResultFilter", "alvinluo filter badCodeNum: %d, whiteCodeNum: %d, commonCodeNum: %d, originNum: %d, finalNum: %d, directJump: %b, showMultiCode: %b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      AppMethodBeat.o(240477);
      return localObject;
      if (i == 0)
      {
        if (this.CHR)
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/WxScanCodeResultFilter$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.an
 * JD-Core Version:    0.7.0.1
 */