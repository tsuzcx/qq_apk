package com.tencent.mm.plugin.performance.diagnostic;

import com.tencent.mm.plugin.performance.a.c;
import com.tencent.mm.sdk.platformtools.ay;
import java.util.Map;

public abstract class a
  implements c
{
  public static ay wWe = ay.aRW("diagnostic_storage");
  
  public final void aA(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey(dBO()))) {
      aB(paramMap);
    }
  }
  
  protected abstract void aB(Map<String, String> paramMap);
  
  public abstract String dBO();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.a
 * JD-Core Version:    0.7.0.1
 */