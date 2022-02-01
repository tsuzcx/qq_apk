package com.tencent.mm.plugin.performance.diagnostic;

import com.tencent.mm.plugin.performance.a.c;
import java.util.Map;

public abstract class a
  implements c
{
  public final void an(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey(dat()))) {
      ao(paramMap);
    }
  }
  
  protected abstract void ao(Map<String, String> paramMap);
  
  public abstract String dat();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.a
 * JD-Core Version:    0.7.0.1
 */