package com.tencent.mm.plugin.performance.diagnostic;

import com.tencent.mm.plugin.performance.a.c;
import java.util.Map;

public abstract class a
  implements c
{
  public final void ap(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey(dob()))) {
      aq(paramMap);
    }
  }
  
  protected abstract void aq(Map<String, String> paramMap);
  
  public abstract String dob();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.a
 * JD-Core Version:    0.7.0.1
 */