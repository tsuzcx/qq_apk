package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import java.util.Map;

public abstract interface j
  extends a
{
  public abstract void a(Context paramContext, int paramInt, String paramString1, String paramString2);
  
  public abstract void a(Context paramContext, int paramInt1, String paramString1, String paramString2, Map<String, String> paramMap, int paramInt2);
  
  public abstract void a(Context paramContext, int paramInt, String paramString1, String paramString2, Map<String, String> paramMap, String paramString3);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap);
  
  public abstract void b(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap);
  
  public abstract void ev(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.j
 * JD-Core Version:    0.7.0.1
 */