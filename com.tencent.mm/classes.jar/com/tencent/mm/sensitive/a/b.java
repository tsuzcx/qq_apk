package com.tencent.mm.sensitive.a;

import android.os.Build.VERSION;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/condition/BuildOsVersionCondition;", "Lcom/tencent/mm/sensitive/condition/ICondition;", "osVersionLimit", "", "(I)V", "checkCondition", "", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements e
{
  private final int acuW = 22;
  
  public final boolean iUe()
  {
    return Build.VERSION.SDK_INT > this.acuW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sensitive.a.b
 * JD-Core Version:    0.7.0.1
 */