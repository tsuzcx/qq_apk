package com.tencent.mm.plugin.websearch.b;

import android.text.TextUtils;
import com.tencent.mm.ck.f;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.e;
import org.xwalk.core.Log;

public final class b
  implements e
{
  public final void a(String paramString, d paramd, com.tencent.mm.vending.e.b paramb)
  {
    if (TextUtils.isEmpty(paramString))
    {
      Log.w("RelevantSearchService", "empty query");
      if (paramd != null) {
        paramd.a(false, null, null, null);
      }
    }
    new a(paramString).Km().b(paramb).b(new b.1(this, paramd, paramString));
  }
  
  public final void af(String paramString1, String paramString2, String paramString3)
  {
    ao.a(paramString1, paramString2, System.currentTimeMillis(), paramString3);
  }
  
  public final void e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ao.f(paramString1, paramString2, paramInt, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b.b
 * JD-Core Version:    0.7.0.1
 */