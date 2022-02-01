package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/ToastUtil;", "", "()V", "dismiss", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dialog", "showProgress", "wording", "", "context", "Landroid/content/Context;", "showToast", "bundle", "Landroid/os/Bundle;", "plugin-webview_release"})
public final class p
{
  public static final p Esp;
  
  static
  {
    AppMethodBeat.i(82756);
    Esp = new p();
    AppMethodBeat.o(82756);
  }
  
  public static final com.tencent.mm.ui.base.p a(Bundle paramBundle, Context paramContext, com.tencent.mm.ui.base.p paramp)
  {
    AppMethodBeat.i(82753);
    d.g.b.p.h(paramContext, "context");
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
      t.cm(paramContext, paramBundle);
      break;
      if (!str.equals("dismissloading")) {
        break;
      }
      paramBundle = b(paramp);
      AppMethodBeat.o(82753);
      return paramBundle;
      if (!str.equals("loading")) {
        break;
      }
      paramBundle = paramContext.getString(2131755936);
      d.g.b.p.g(paramBundle, "context.getString(R.string.app_waiting)");
      paramBundle = a(paramBundle, paramContext, paramp);
      AppMethodBeat.o(82753);
      return paramBundle;
    }
  }
  
  public static com.tencent.mm.ui.base.p a(String paramString, Context paramContext, com.tencent.mm.ui.base.p paramp)
  {
    AppMethodBeat.i(82754);
    d.g.b.p.h(paramString, "wording");
    d.g.b.p.h(paramContext, "context");
    MMActivity localMMActivity = q.hb(paramContext);
    if ((localMMActivity != null) && (localMMActivity.isFinishing() == true))
    {
      AppMethodBeat.o(82754);
      return null;
    }
    if (paramp != null)
    {
      b(paramp);
      if (!paramp.isShowing())
      {
        paramp.show();
        AppMethodBeat.o(82754);
        return paramp;
      }
    }
    paramString = h.b(paramContext, paramString, true, (DialogInterface.OnCancelListener)a.Esq);
    AppMethodBeat.o(82754);
    return paramString;
  }
  
  public static com.tencent.mm.ui.base.p b(com.tencent.mm.ui.base.p paramp)
  {
    AppMethodBeat.i(82755);
    if ((paramp != null) && (paramp.isShowing())) {
      paramp.dismiss();
    }
    AppMethodBeat.o(82755);
    return paramp;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class a
    implements DialogInterface.OnCancelListener
  {
    public static final a Esq;
    
    static
    {
      AppMethodBeat.i(82752);
      Esq = new a();
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
        n.a locala = n.Erw;
        ad.e(n.access$getTAG$cp(), "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
        AppMethodBeat.o(82751);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.p
 * JD-Core Version:    0.7.0.1
 */