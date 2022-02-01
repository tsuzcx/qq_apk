package com.tencent.mm.plugin.wallet_core;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.b;

public final class a
  implements com.tencent.mm.plugin.wxpaysdk.api.c
{
  public final void g(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(203463);
    Bundle localBundle = new Bundle();
    localBundle.putString("realname_verify_process_jump_activity", paramString1);
    localBundle.putString("realname_verify_process_jump_plugin", paramString2);
    h(paramActivity, localBundle);
    AppMethodBeat.o(203463);
  }
  
  public final void h(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(163871);
    paramBundle.putInt("real_name_verify_mode", 2);
    com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramBundle);
    AppMethodBeat.o(163871);
  }
  
  public final com.tencent.mm.pluginsdk.c.a iO(Context paramContext)
  {
    AppMethodBeat.i(69863);
    paramContext = new com.tencent.mm.plugin.wallet_core.ui.c(paramContext);
    AppMethodBeat.o(69863);
    return paramContext;
  }
  
  public final com.tencent.mm.pluginsdk.c.a iP(Context paramContext)
  {
    AppMethodBeat.i(203454);
    paramContext = new com.tencent.mm.plugin.wallet_core.ui.a(paramContext);
    AppMethodBeat.o(203454);
    return paramContext;
  }
  
  public final com.tencent.mm.pluginsdk.c.a iQ(Context paramContext)
  {
    AppMethodBeat.i(203456);
    paramContext = new b(paramContext);
    AppMethodBeat.o(203456);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.a
 * JD-Core Version:    0.7.0.1
 */