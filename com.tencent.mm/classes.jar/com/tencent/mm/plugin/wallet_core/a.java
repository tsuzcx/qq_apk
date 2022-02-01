package com.tencent.mm.plugin.wallet_core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.b;
import com.tencent.mm.plugin.wallet_core.ui.d;
import com.tencent.mm.plugin.wxpaysdk.api.c.a;
import com.tencent.mm.wallet_core.e.a;

public final class a
  implements com.tencent.mm.plugin.wxpaysdk.api.c
{
  private c.a Vxm;
  private e.a Vxn;
  
  public a()
  {
    AppMethodBeat.i(301058);
    this.Vxm = null;
    this.Vxn = new e.a()
    {
      public final Intent v(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(301063);
        if (a.a(a.this) != null) {
          a.a(a.this).onProcessEnd(paramAnonymousInt, paramAnonymousBundle);
        }
        a.b(a.this);
        AppMethodBeat.o(301063);
        return null;
      }
    };
    AppMethodBeat.o(301058);
  }
  
  public final void a(Activity paramActivity, Bundle paramBundle, c.a parama)
  {
    AppMethodBeat.i(301094);
    this.Vxm = parama;
    paramBundle.putInt("real_name_verify_mode", 2);
    com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramBundle, this.Vxn);
    AppMethodBeat.o(301094);
  }
  
  public final void f(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(301091);
    Bundle localBundle = new Bundle();
    localBundle.putString("realname_verify_process_jump_activity", paramString1);
    localBundle.putString("realname_verify_process_jump_plugin", paramString2);
    h(paramActivity, localBundle);
    AppMethodBeat.o(301091);
  }
  
  public final void h(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(163871);
    paramBundle.putInt("real_name_verify_mode", 2);
    com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramBundle);
    AppMethodBeat.o(163871);
  }
  
  public final com.tencent.mm.pluginsdk.c.a kF(Context paramContext)
  {
    AppMethodBeat.i(69863);
    paramContext = new d(paramContext);
    AppMethodBeat.o(69863);
    return paramContext;
  }
  
  public final com.tencent.mm.pluginsdk.c.a kG(Context paramContext)
  {
    AppMethodBeat.i(301078);
    paramContext = new b(paramContext);
    AppMethodBeat.o(301078);
    return paramContext;
  }
  
  public final com.tencent.mm.pluginsdk.c.a kH(Context paramContext)
  {
    AppMethodBeat.i(301081);
    paramContext = new com.tencent.mm.plugin.wallet_core.ui.a(paramContext);
    AppMethodBeat.o(301081);
    return paramContext;
  }
  
  public final com.tencent.mm.pluginsdk.c.a kI(Context paramContext)
  {
    AppMethodBeat.i(301086);
    paramContext = new com.tencent.mm.plugin.wallet_core.ui.c(paramContext);
    AppMethodBeat.o(301086);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.a
 * JD-Core Version:    0.7.0.1
 */