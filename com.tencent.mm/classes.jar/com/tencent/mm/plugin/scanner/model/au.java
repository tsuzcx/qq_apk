package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.scanner.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qbar.a.a;
import com.tencent.qbar.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/WxScanCodeResultFilter;", "Lcom/tencent/mm/plugin/scanner/result/IScanCodeResultFilter;", "()V", "directJumpWhiteCode", "", "directJumpWhiteListCode", "filter", "", "Lcom/tencent/qbar/QBar$QBarResult;", "codeResultList", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class au
  implements d
{
  public static final au.a OUg;
  private boolean OUh;
  
  static
  {
    AppMethodBeat.i(314245);
    OUg = new au.a((byte)0);
    AppMethodBeat.o(314245);
  }
  
  public au()
  {
    AppMethodBeat.i(314240);
    int i = ((c)h.ax(c.class)).a(c.a.zge, 0);
    if (i != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.OUh = bool;
      Log.i("MicroMsg.WxScanCodeResultFilter", "alvinluo WxScanCodeResultFilter init config: %d, directJumpWhiteCode: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.OUh) });
      AppMethodBeat.o(314240);
      return;
    }
  }
  
  public final List<a.a> F(List<? extends a.a> paramList)
  {
    boolean bool2 = true;
    AppMethodBeat.i(314254);
    s.u(paramList, "codeResultList");
    if (paramList.size() <= 1)
    {
      AppMethodBeat.o(314254);
      return paramList;
    }
    List localList2 = (List)new ArrayList();
    List localList1 = (List)new ArrayList();
    Object localObject = ((Iterable)paramList).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      if (b.bFq(locala.data))
      {
        i += 1;
      }
      else
      {
        localList2.add(locala);
        if (b.bFp(locala.data)) {
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
      AppMethodBeat.o(314254);
      return localObject;
      if (i == 0)
      {
        if (this.OUh)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.au
 * JD-Core Version:    0.7.0.1
 */