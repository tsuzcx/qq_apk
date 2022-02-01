package com.tencent.qbar.b;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/qbar/util/ScanCostManager$FrameDecodeCostInfo;", "", "cost", "", "(J)V", "getCost", "()J", "setCost", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
{
  long cost = 0L;
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
    } while (this.cost == paramObject.cost);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(226784);
    int i = q.a..ExternalSyntheticBackport0.m(this.cost);
    AppMethodBeat.o(226784);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(226783);
    String str = "FrameDecodeCostInfo(cost=" + this.cost + ')';
    AppMethodBeat.o(226783);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.qbar.b.a.b
 * JD-Core Version:    0.7.0.1
 */