package com.tencent.mm.plugin.scanner.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$ScanTabInfo;", "", "scanTabId", "", "scanTabTitle", "", "(ILjava/lang/String;)V", "getScanTabId", "()I", "getScanTabTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-scan_release"})
public final class b$b
{
  final int IXM;
  final String IXN;
  
  public b$b(int paramInt, String paramString)
  {
    AppMethodBeat.i(52428);
    this.IXM = paramInt;
    this.IXN = paramString;
    AppMethodBeat.o(52428);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(52431);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.IXM != paramObject.IXM) || (!p.h(this.IXN, paramObject.IXN))) {}
      }
    }
    else
    {
      AppMethodBeat.o(52431);
      return true;
    }
    AppMethodBeat.o(52431);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(52430);
    int j = this.IXM;
    String str = this.IXN;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      AppMethodBeat.o(52430);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(52429);
    String str = "ScanTabInfo(scanTabId=" + this.IXM + ", scanTabTitle=" + this.IXN + ")";
    AppMethodBeat.o(52429);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.b.b
 * JD-Core Version:    0.7.0.1
 */