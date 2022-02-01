package com.tencent.mm.plugin.ringtone.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/data/RingtoneDataViewModel$RingtoneUiState;", "", "()V", "Success", "Lcom/tencent/mm/plugin/ringtone/data/RingtoneDataViewModel$RingtoneUiState$Success;", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class g$a
{
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/data/RingtoneDataViewModel$RingtoneUiState$Success;", "Lcom/tencent/mm/plugin/ringtone/data/RingtoneDataViewModel$RingtoneUiState;", "ringtones", "", "Lcom/tencent/mm/plugin/ringtone/data/RingtoneConvertData;", "uiState", "", "(Ljava/util/List;I)V", "getRingtones", "()Ljava/util/List;", "getUiState", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends g.a
  {
    public final int EcS;
    public final List<e> OCh;
    
    public a(List<e> paramList, int paramInt)
    {
      super();
      this.OCh = paramList;
      this.EcS = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(273058);
      if (this == paramObject)
      {
        AppMethodBeat.o(273058);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(273058);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.OCh, paramObject.OCh))
      {
        AppMethodBeat.o(273058);
        return false;
      }
      if (this.EcS != paramObject.EcS)
      {
        AppMethodBeat.o(273058);
        return false;
      }
      AppMethodBeat.o(273058);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(273051);
      if (this.OCh == null) {}
      for (int i = 0;; i = this.OCh.hashCode())
      {
        int j = this.EcS;
        AppMethodBeat.o(273051);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(273040);
      String str = "Success(ringtones=" + this.OCh + ", uiState=" + this.EcS + ')';
      AppMethodBeat.o(273040);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.b.g.a
 * JD-Core Version:    0.7.0.1
 */