package com.tencent.mm.plugin.webview.luggage;

import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key.a;
import java.util.Map;

final class e$18
  extends LuggageGetA8Key.a
{
  e$18(e parame) {}
  
  public final void EC(String paramString)
  {
    this.rca.EC(paramString);
  }
  
  public final void b(final String paramString1, final String paramString2, final Map<String, String> paramMap)
  {
    e.a(this.rca, new Runnable()
    {
      public final void run()
      {
        e.18.this.rca.b(paramString1, paramString2, paramMap);
      }
    });
  }
  
  public final void caY() {}
  
  public final void fu(String paramString1, String paramString2)
  {
    e.a(this.rca, new e.18.2(this, paramString1, paramString2));
  }
  
  public final void i(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    e.a(this.rca, new e.18.3(this, paramString1, paramInt1, paramInt2, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.18
 * JD-Core Version:    0.7.0.1
 */