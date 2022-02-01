package com.tencent.mm.plugin.wallet_core;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.b;
import com.tencent.mm.plugin.wxpaysdk.api.c;

public final class a
  implements c
{
  public final void g(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(163871);
    paramBundle.putInt("real_name_verify_mode", 2);
    com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramBundle);
    AppMethodBeat.o(163871);
  }
  
  public final com.tencent.mm.pluginsdk.b.a gJ(Context paramContext)
  {
    AppMethodBeat.i(69863);
    paramContext = new b(paramContext);
    AppMethodBeat.o(69863);
    return paramContext;
  }
  
  public final com.tencent.mm.pluginsdk.b.a gK(Context paramContext)
  {
    AppMethodBeat.i(199294);
    paramContext = new com.tencent.mm.plugin.wallet_core.ui.a(paramContext);
    AppMethodBeat.o(199294);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.a
 * JD-Core Version:    0.7.0.1
 */