package com.tencent.mm.plugin.ringtone.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.b.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/exclusive/ExclusiveDataViewModel$ExclusiveUiState;", "", "()V", "Success", "Lcom/tencent/mm/plugin/ringtone/exclusive/ExclusiveDataViewModel$ExclusiveUiState$Success;", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a$b
{
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/exclusive/ExclusiveDataViewModel$ExclusiveUiState$Success;", "Lcom/tencent/mm/plugin/ringtone/exclusive/ExclusiveDataViewModel$ExclusiveUiState;", "exclusiveLists", "", "Lcom/tencent/mm/plugin/ringtone/data/ExclusiveConvertData;", "uiState", "", "(Ljava/util/List;I)V", "getExclusiveLists", "()Ljava/util/List;", "getUiState", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends a.b
  {
    public final int EcS;
    public final List<c> OCn;
    
    public a(List<c> paramList, int paramInt)
    {
      super();
      this.OCn = paramList;
      this.EcS = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(272823);
      if (this == paramObject)
      {
        AppMethodBeat.o(272823);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(272823);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.OCn, paramObject.OCn))
      {
        AppMethodBeat.o(272823);
        return false;
      }
      if (this.EcS != paramObject.EcS)
      {
        AppMethodBeat.o(272823);
        return false;
      }
      AppMethodBeat.o(272823);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(272818);
      if (this.OCn == null) {}
      for (int i = 0;; i = this.OCn.hashCode())
      {
        int j = this.EcS;
        AppMethodBeat.o(272818);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(272809);
      String str = "Success(exclusiveLists=" + this.OCn + ", uiState=" + this.EcS + ')';
      AppMethodBeat.o(272809);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.c.a.b
 * JD-Core Version:    0.7.0.1
 */