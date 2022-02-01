package com.tencent.mm.plugin.performance.diagnostic;

import com.tencent.mm.plugin.performance.a.c;
import com.tencent.mm.sdk.platformtools.ax;
import java.util.Map;

public abstract class a
  implements c
{
  public static ax wGr = ax.aQz("diagnostic_storage");
  
  public final void au(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey(dyy()))) {
      av(paramMap);
    }
  }
  
  protected abstract void av(Map<String, String> paramMap);
  
  public abstract String dyy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.a
 * JD-Core Version:    0.7.0.1
 */