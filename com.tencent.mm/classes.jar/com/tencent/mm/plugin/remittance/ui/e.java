package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public final class e
{
  WeakReference<Context> cMO;
  
  public static e eNU()
  {
    try
    {
      e locale = a.CrX;
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final d a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67989);
    Log.w("MicroMsg.RemittanceBusiDialogMgr", "showAlert2() msg:%s, title:%s", new Object[] { Util.nullAsNil(paramString), Util.nullAsNil(null) });
    Context localContext = (Context)this.cMO.get();
    if (localContext == null)
    {
      Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
      AppMethodBeat.o(67989);
      return null;
    }
    paramString = h.a(localContext, paramString, null, false, paramOnClickListener);
    AppMethodBeat.o(67989);
    return paramString;
  }
  
  public final d a(String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(67988);
    Log.w("MicroMsg.RemittanceBusiDialogMgr", "showAlert1() msg:%s, title:%s, yes:%s, no:%s", new Object[] { Util.nullAsNil(paramString1), Util.nullAsNil(paramString2), Util.nullAsNil(paramString3), Util.nullAsNil(paramString4) });
    Context localContext = (Context)this.cMO.get();
    if (localContext == null)
    {
      Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
      AppMethodBeat.o(67988);
      return null;
    }
    paramString1 = h.c(localContext, paramString1, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2);
    AppMethodBeat.o(67988);
    return paramString1;
  }
  
  public final boolean eNV()
  {
    AppMethodBeat.i(163813);
    Log.i("MicroMsg.RemittanceBusiDialogMgr", "finishRemitF2fDCodeAndLMRemindUI()");
    Context localContext = (Context)this.cMO.get();
    if (localContext == null)
    {
      Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
      AppMethodBeat.o(163813);
      return false;
    }
    if ((localContext instanceof RemittanceF2fDynamicCodeUI))
    {
      Log.w("MicroMsg.RemittanceBusiDialogMgr", "check() is RemittanceF2fDynamicCodeUI");
      ((Activity)localContext).finish();
      AppMethodBeat.o(163813);
      return true;
    }
    if ((localContext instanceof RemittanceF2fLargeMoneyUI))
    {
      Log.w("MicroMsg.RemittanceBusiDialogMgr", "check() is RemittanceF2fLargeMoneyUI");
      ((Activity)localContext).finish();
      AppMethodBeat.o(163813);
      return true;
    }
    AppMethodBeat.o(163813);
    return false;
  }
  
  public final boolean eNW()
  {
    AppMethodBeat.i(163814);
    Log.i("MicroMsg.RemittanceBusiDialogMgr", "finishRemitLMRemindUI()");
    Context localContext = (Context)this.cMO.get();
    if (localContext == null)
    {
      Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
      AppMethodBeat.o(163814);
      return false;
    }
    if ((localContext instanceof RemittanceF2fLargeMoneyUI))
    {
      Log.w("MicroMsg.RemittanceBusiDialogMgr", "check() is RemittanceF2fLargeMoneyUI");
      ((Activity)localContext).finish();
      AppMethodBeat.o(163814);
      return true;
    }
    AppMethodBeat.o(163814);
    return false;
  }
  
  public final boolean eNX()
  {
    AppMethodBeat.i(163815);
    Log.w("MicroMsg.RemittanceBusiDialogMgr", "showSafeProgress()");
    Context localContext = (Context)this.cMO.get();
    if (localContext == null)
    {
      Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
      AppMethodBeat.o(163815);
      return false;
    }
    if ((localContext instanceof RemittanceBusiUI))
    {
      AppMethodBeat.o(163815);
      return false;
    }
    if ((localContext instanceof WalletBaseUI))
    {
      ((WalletBaseUI)localContext).showSafeProgress();
      AppMethodBeat.o(163815);
      return true;
    }
    AppMethodBeat.o(163815);
    return false;
  }
  
  public final void gS(Context paramContext)
  {
    AppMethodBeat.i(67986);
    Log.i("MicroMsg.RemittanceBusiDialogMgr", "attach() %s", new Object[] { paramContext.getClass().getSimpleName() });
    this.cMO = new WeakReference(paramContext);
    AppMethodBeat.o(67986);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(163812);
    Context localContext = (Context)this.cMO.get();
    if (localContext == null)
    {
      Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
      AppMethodBeat.o(163812);
      return null;
    }
    AppMethodBeat.o(163812);
    return localContext;
  }
  
  static final class a
  {
    static e CrX;
    
    static
    {
      AppMethodBeat.i(67985);
      CrX = new e();
      AppMethodBeat.o(67985);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.e
 * JD-Core Version:    0.7.0.1
 */