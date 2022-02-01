package com.tencent.mm.sensitive.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/condition/FrequencyCondition;", "Lcom/tencent/mm/sensitive/condition/ICondition;", "freqLimit", "", "(J)V", "getFreqLimit", "()J", "preTimeStamp", "getPreTimeStamp", "setPreTimeStamp", "checkCondition", "", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements e
{
  private final long acuX;
  private long acuY;
  
  public d(long paramLong)
  {
    this.acuX = paramLong;
  }
  
  public final boolean iUe()
  {
    AppMethodBeat.i(240948);
    long l = SystemClock.uptimeMillis();
    Object localObject = Long.valueOf(this.acuY);
    int i;
    if (((Number)localObject).longValue() > 0L)
    {
      i = 1;
      if (i == 0) {
        break label70;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        break label76;
      }
      localObject = null;
      if (localObject != null) {
        break label123;
      }
      ((d)this).acuY = l;
      AppMethodBeat.o(240948);
      return true;
      i = 0;
      break;
      label70:
      localObject = null;
    }
    label76:
    if (l - ((Number)localObject).longValue() > this.acuX) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.acuY = l;
      }
      localObject = Boolean.valueOf(bool);
      break;
    }
    label123:
    bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(240948);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sensitive.a.d
 * JD-Core Version:    0.7.0.1
 */