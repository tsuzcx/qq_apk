package com.tencent.mm.plugin.scanner.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/result/ScanCodeProductMergeHandler$ScanCodeProductMergeData;", "T", "", "type", "", "data", "(ILjava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getType", "()I", "component1", "component2", "copy", "(ILjava/lang/Object;)Lcom/tencent/mm/plugin/scanner/result/ScanCodeProductMergeHandler$ScanCodeProductMergeData;", "equals", "", "other", "hashCode", "toString", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$b<T>
{
  final T cpt;
  final int type;
  
  public g$b(int paramInt, T paramT)
  {
    this.type = paramInt;
    this.cpt = paramT;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(313557);
    if (this == paramObject)
    {
      AppMethodBeat.o(313557);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(313557);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.type != paramObject.type)
    {
      AppMethodBeat.o(313557);
      return false;
    }
    if (!s.p(this.cpt, paramObject.cpt))
    {
      AppMethodBeat.o(313557);
      return false;
    }
    AppMethodBeat.o(313557);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(313553);
    int j = this.type;
    if (this.cpt == null) {}
    for (int i = 0;; i = this.cpt.hashCode())
    {
      AppMethodBeat.o(313553);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(313547);
    String str = "ScanCodeProductMergeData(type=" + this.type + ", data=" + this.cpt + ')';
    AppMethodBeat.o(313547);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.g.g.b
 * JD-Core Version:    0.7.0.1
 */