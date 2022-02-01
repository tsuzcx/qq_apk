package com.tencent.mm.plugin.repairer.ui;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/RepairerXLogUI$LogFile;", "", "name", "", "modifyTime", "", "(Ljava/lang/String;J)V", "getModifyTime", "()J", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerXLogUI$a
{
  final long DZN;
  final String name;
  
  public RepairerXLogUI$a(String paramString, long paramLong)
  {
    AppMethodBeat.i(277994);
    this.name = paramString;
    this.DZN = paramLong;
    AppMethodBeat.o(277994);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(278020);
    if (this == paramObject)
    {
      AppMethodBeat.o(278020);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(278020);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.name, paramObject.name))
    {
      AppMethodBeat.o(278020);
      return false;
    }
    if (this.DZN != paramObject.DZN)
    {
      AppMethodBeat.o(278020);
      return false;
    }
    AppMethodBeat.o(278020);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(278012);
    int i = this.name.hashCode();
    int j = q.a..ExternalSyntheticBackport0.m(this.DZN);
    AppMethodBeat.o(278012);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(278000);
    String str = "LogFile(name=" + this.name + ", modifyTime=" + this.DZN + ')';
    AppMethodBeat.o(278000);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerXLogUI.a
 * JD-Core Version:    0.7.0.1
 */