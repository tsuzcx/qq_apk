package com.tencent.mm.plugin.ringtone.d;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.g.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/feed/RingtonePlayerFlow$RingtonePlayerUiState;", "", "()V", "onNewState", "onPlay", "Lcom/tencent/mm/plugin/ringtone/feed/RingtonePlayerFlow$RingtonePlayerUiState$onNewState;", "Lcom/tencent/mm/plugin/ringtone/feed/RingtonePlayerFlow$RingtonePlayerUiState$onPlay;", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c$b
{
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/feed/RingtonePlayerFlow$RingtonePlayerUiState$onNewState;", "Lcom/tencent/mm/plugin/ringtone/feed/RingtonePlayerFlow$RingtonePlayerUiState;", "id", "", "uiState", "", "(JI)V", "getId", "()J", "getUiState", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends c.b
  {
    public final int EcS;
    public final long id;
    
    public a(long paramLong, int paramInt)
    {
      super();
      this.id = paramLong;
      this.EcS = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.id != paramObject.id) {
          return false;
        }
      } while (this.EcS == paramObject.EcS);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(273148);
      int i = q.a..ExternalSyntheticBackport0.m(this.id);
      int j = this.EcS;
      AppMethodBeat.o(273148);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(273142);
      String str = "onNewState(id=" + this.id + ", uiState=" + this.EcS + ')';
      AppMethodBeat.o(273142);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/feed/RingtonePlayerFlow$RingtonePlayerUiState$onPlay;", "Lcom/tencent/mm/plugin/ringtone/feed/RingtonePlayerFlow$RingtonePlayerUiState;", "id", "", "desc", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "state", "", "(JLcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;I)V", "getDesc", "()Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "getId", "()J", "getState", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends c.b
  {
    final d OCE;
    final long id;
    final int state;
    
    public b(long paramLong, d paramd, int paramInt)
    {
      super();
      this.id = paramLong;
      this.OCE = paramd;
      this.state = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(273157);
      if (this == paramObject)
      {
        AppMethodBeat.o(273157);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(273157);
        return false;
      }
      paramObject = (b)paramObject;
      if (this.id != paramObject.id)
      {
        AppMethodBeat.o(273157);
        return false;
      }
      if (!s.p(this.OCE, paramObject.OCE))
      {
        AppMethodBeat.o(273157);
        return false;
      }
      if (this.state != paramObject.state)
      {
        AppMethodBeat.o(273157);
        return false;
      }
      AppMethodBeat.o(273157);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(273150);
      int j = q.a..ExternalSyntheticBackport0.m(this.id);
      if (this.OCE == null) {}
      for (int i = 0;; i = this.OCE.hashCode())
      {
        int k = this.state;
        AppMethodBeat.o(273150);
        return (i + j * 31) * 31 + k;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(273144);
      String str = "onPlay(id=" + this.id + ", desc=" + this.OCE + ", state=" + this.state + ')';
      AppMethodBeat.o(273144);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.d.c.b
 * JD-Core Version:    0.7.0.1
 */