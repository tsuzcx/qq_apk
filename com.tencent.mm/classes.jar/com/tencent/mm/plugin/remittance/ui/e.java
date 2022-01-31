package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;
import java.lang.ref.WeakReference;

public final class e
{
  WeakReference<Context> bJz;
  
  public static e chr()
  {
    try
    {
      e locale = e.a.qmu;
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final c a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(44867);
    ab.w("MicroMsg.RemittanceBusiDialogMgr", "showAlert2() msg:%s, title:%s", new Object[] { bo.nullAsNil(paramString), bo.nullAsNil(null) });
    Context localContext = (Context)this.bJz.get();
    if (localContext == null)
    {
      ab.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
      AppMethodBeat.o(44867);
      return null;
    }
    paramString = h.a(localContext, paramString, null, false, paramOnClickListener);
    AppMethodBeat.o(44867);
    return paramString;
  }
  
  public final c a(String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(44866);
    ab.w("MicroMsg.RemittanceBusiDialogMgr", "showAlert1() msg:%s, title:%s, yes:%s, no:%s", new Object[] { bo.nullAsNil(paramString1), bo.nullAsNil(paramString2), bo.nullAsNil(paramString3), bo.nullAsNil(paramString4) });
    Context localContext = (Context)this.bJz.get();
    if (localContext == null)
    {
      ab.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
      AppMethodBeat.o(44866);
      return null;
    }
    paramString1 = h.d(localContext, paramString1, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2);
    AppMethodBeat.o(44866);
    return paramString1;
  }
  
  public final boolean chs()
  {
    AppMethodBeat.i(142162);
    ab.i("MicroMsg.RemittanceBusiDialogMgr", "finishRemittanceF2fDynamicCodeUI()");
    Context localContext = (Context)this.bJz.get();
    if (localContext == null)
    {
      ab.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
      AppMethodBeat.o(142162);
      return false;
    }
    if ((localContext instanceof RemittanceF2fDynamicCodeUI))
    {
      ab.w("MicroMsg.RemittanceBusiDialogMgr", "check() is RemittanceF2fDynamicCodeUI");
      ((Activity)localContext).finish();
      AppMethodBeat.o(142162);
      return true;
    }
    AppMethodBeat.o(142162);
    return false;
  }
  
  public final void eN(Context paramContext)
  {
    AppMethodBeat.i(44865);
    this.bJz = new WeakReference(paramContext);
    AppMethodBeat.o(44865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.e
 * JD-Core Version:    0.7.0.1
 */