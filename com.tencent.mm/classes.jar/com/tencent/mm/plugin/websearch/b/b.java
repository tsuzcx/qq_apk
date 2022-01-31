package com.tencent.mm.plugin.websearch.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.e;
import java.lang.ref.WeakReference;
import org.xwalk.core.Log;

public final class b
  implements e
{
  public final void a(String paramString, d paramd, com.tencent.mm.vending.e.b paramb)
  {
    AppMethodBeat.i(91365);
    if (TextUtils.isEmpty(paramString))
    {
      Log.w("RelevantSearchService", "empty query");
      if (paramd != null) {
        paramd.a(false, null, null, null);
      }
    }
    paramd = new WeakReference(paramd);
    new a(paramString).adl().b(paramb).b(new b.1(this, paramd, paramString));
    AppMethodBeat.o(91365);
  }
  
  public final void at(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(91366);
    an.a(paramString1, paramString2, System.currentTimeMillis(), paramString3);
    AppMethodBeat.o(91366);
  }
  
  public final void e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(91367);
    an.f(paramString1, paramString2, paramInt, paramString3);
    AppMethodBeat.o(91367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b.b
 * JD-Core Version:    0.7.0.1
 */