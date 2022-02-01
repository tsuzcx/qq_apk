package com.tencent.tbs.one.impl.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.optional.TBSOneDebugPlugin;
import java.util.Map;

public final class b
  implements TBSOneDebugger
{
  private final String a;
  
  public b(String paramString)
  {
    this.a = paramString;
  }
  
  public final View createPanelView(Context paramContext)
  {
    AppMethodBeat.i(174163);
    paramContext = new a(paramContext, this.a);
    AppMethodBeat.o(174163);
    return paramContext;
  }
  
  public final void executeCommand(final Context paramContext, final String paramString, final Map<String, Object> paramMap, final TBSOneCallback<Void> paramTBSOneCallback)
  {
    AppMethodBeat.i(174164);
    com.tencent.tbs.one.impl.common.a.a(paramContext, new TBSOneCallback()
    {
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(174157);
        if (paramTBSOneCallback != null) {
          paramTBSOneCallback.onError(paramAnonymousInt, paramAnonymousString);
        }
        AppMethodBeat.o(174157);
      }
    });
    AppMethodBeat.o(174164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.b.b
 * JD-Core Version:    0.7.0.1
 */