package com.tencent.mm.plugin.scanner.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$ScanTabInfo;", "", "scanTabId", "", "scanTabTitle", "", "(ILjava/lang/String;)V", "getScanTabId", "()I", "getScanTabTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$b
{
  final int Phl;
  final String Phm;
  
  public b$b(int paramInt, String paramString)
  {
    AppMethodBeat.i(52428);
    this.Phl = paramInt;
    this.Phm = paramString;
    AppMethodBeat.o(52428);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(52431);
    if (this == paramObject)
    {
      AppMethodBeat.o(52431);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(52431);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.Phl != paramObject.Phl)
    {
      AppMethodBeat.o(52431);
      return false;
    }
    if (!s.p(this.Phm, paramObject.Phm))
    {
      AppMethodBeat.o(52431);
      return false;
    }
    AppMethodBeat.o(52431);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(52430);
    int i = this.Phl;
    int j = this.Phm.hashCode();
    AppMethodBeat.o(52430);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(52429);
    String str = "ScanTabInfo(scanTabId=" + this.Phl + ", scanTabTitle=" + this.Phm + ')';
    AppMethodBeat.o(52429);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.b.b
 * JD-Core Version:    0.7.0.1
 */