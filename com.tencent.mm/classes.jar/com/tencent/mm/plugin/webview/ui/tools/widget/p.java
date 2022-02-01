package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/ToastUtil;", "", "()V", "dismiss", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dialog", "showProgress", "wording", "", "context", "Landroid/content/Context;", "showToast", "bundle", "Landroid/os/Bundle;", "plugin-webview_release"})
public final class p
{
  public static final p JAu;
  
  static
  {
    AppMethodBeat.i(82756);
    JAu = new p();
    AppMethodBeat.o(82756);
  }
  
  public static final com.tencent.mm.ui.base.q a(Bundle paramBundle, Context paramContext, com.tencent.mm.ui.base.q paramq)
  {
    AppMethodBeat.i(82753);
    kotlin.g.b.p.h(paramContext, "context");
    String str;
    if (paramBundle != null)
    {
      str = paramBundle.getString("status");
      if (str != null) {
        break label38;
      }
    }
    label38:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(82753);
        return null;
        str = null;
        break;
        switch (str.hashCode())
        {
        }
      }
    } while (!str.equals("success"));
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getString("wording");; paramBundle = null)
    {
      u.cG(paramContext, paramBundle);
      break;
      if (!str.equals("dismissloading")) {
        break;
      }
      paramBundle = b(paramq);
      AppMethodBeat.o(82753);
      return paramBundle;
      if (!str.equals("loading")) {
        break;
      }
      paramBundle = paramContext.getString(2131756029);
      kotlin.g.b.p.g(paramBundle, "context.getString(R.string.app_waiting)");
      paramBundle = a(paramBundle, paramContext, paramq);
      AppMethodBeat.o(82753);
      return paramBundle;
    }
  }
  
  public static com.tencent.mm.ui.base.q a(String paramString, Context paramContext, com.tencent.mm.ui.base.q paramq)
  {
    AppMethodBeat.i(82754);
    kotlin.g.b.p.h(paramString, "wording");
    kotlin.g.b.p.h(paramContext, "context");
    MMActivity localMMActivity = q.ib(paramContext);
    if ((localMMActivity != null) && (localMMActivity.isFinishing() == true))
    {
      AppMethodBeat.o(82754);
      return null;
    }
    if (paramq != null)
    {
      b(paramq);
      if (!paramq.isShowing())
      {
        paramq.show();
        AppMethodBeat.o(82754);
        return paramq;
      }
    }
    paramString = h.a(paramContext, paramString, true, (DialogInterface.OnCancelListener)a.JAv);
    AppMethodBeat.o(82754);
    return paramString;
  }
  
  public static com.tencent.mm.ui.base.q b(com.tencent.mm.ui.base.q paramq)
  {
    AppMethodBeat.i(82755);
    if ((paramq != null) && (paramq.isShowing())) {
      paramq.dismiss();
    }
    AppMethodBeat.o(82755);
    return paramq;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class a
    implements DialogInterface.OnCancelListener
  {
    public static final a JAv;
    
    static
    {
      AppMethodBeat.i(82752);
      JAv = new a();
      AppMethodBeat.o(82752);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(82751);
      try
      {
        paramDialogInterface.dismiss();
        AppMethodBeat.o(82751);
        return;
      }
      catch (Exception paramDialogInterface)
      {
        n.a locala = n.JzB;
        Log.e(n.access$getTAG$cp(), "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
        AppMethodBeat.o(82751);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.p
 * JD-Core Version:    0.7.0.1
 */