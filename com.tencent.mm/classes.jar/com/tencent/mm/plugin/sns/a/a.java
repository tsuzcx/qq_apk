package com.tencent.mm.plugin.sns.a;

import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements c
{
  private Map<Integer, com.tencent.mm.plugin.sns.a.a.a> okb = new HashMap();
  
  public final void a(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    com.tencent.mm.plugin.sns.a.a.a locala = (com.tencent.mm.plugin.sns.a.a.a)this.okb.get(Integer.valueOf(paramInt1));
    if (locala == null)
    {
      y.w("SnsAdReportService", "can not find %s implementation for kv %d", new Object[] { com.tencent.mm.plugin.sns.a.a.a.class, Integer.valueOf(paramInt1) });
      return;
    }
    locala.f(paramInt2, paramVarArgs);
  }
  
  public final void a(com.tencent.mm.plugin.sns.a.a.a parama)
  {
    this.okb.put(Integer.valueOf(parama.bvs()), parama);
  }
  
  public final void f(int paramInt, Object... paramVarArgs)
  {
    com.tencent.mm.plugin.sns.a.a.a locala = (com.tencent.mm.plugin.sns.a.a.a)this.okb.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      y.w("SnsAdReportService", "can not find %s implementation for kv %d", new Object[] { com.tencent.mm.plugin.sns.a.a.a.class, Integer.valueOf(paramInt) });
      return;
    }
    locala.c(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.a
 * JD-Core Version:    0.7.0.1
 */