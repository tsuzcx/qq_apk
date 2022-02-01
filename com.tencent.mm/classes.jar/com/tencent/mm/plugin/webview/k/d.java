package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ay.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/util/ToastUtil;", "", "()V", "TAG", "", "dismiss", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dialog", "showProgress", "wording", "context", "Landroid/content/Context;", "showToast", "bundle", "Landroid/os/Bundle;", "webview-sdk_release"})
public final class d
{
  public static final d QzO;
  
  static
  {
    AppMethodBeat.i(205479);
    QzO = new d();
    AppMethodBeat.o(205479);
  }
  
  public static final s a(Bundle paramBundle, Context paramContext, s params)
  {
    AppMethodBeat.i(205474);
    p.k(paramContext, "context");
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
        AppMethodBeat.o(205474);
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
      w.cR(paramContext, paramBundle);
      break;
      if (!str.equals("dismissloading")) {
        break;
      }
      paramBundle = c(params);
      AppMethodBeat.o(205474);
      return paramBundle;
      if (!str.equals("loading")) {
        break;
      }
      paramBundle = paramContext.getString(a.a.app_waiting);
      p.j(paramBundle, "context.getString(R.string.app_waiting)");
      paramBundle = a(paramBundle, paramContext, params);
      AppMethodBeat.o(205474);
      return paramBundle;
    }
  }
  
  public static s a(String paramString, Context paramContext, s params)
  {
    AppMethodBeat.i(205476);
    p.k(paramString, "wording");
    p.k(paramContext, "context");
    MMActivity localMMActivity = e.jf(paramContext);
    if ((localMMActivity != null) && (localMMActivity.isFinishing() == true))
    {
      AppMethodBeat.o(205476);
      return null;
    }
    if (params != null)
    {
      c(params);
      if (!params.isShowing())
      {
        params.show();
        AppMethodBeat.o(205476);
        return params;
      }
    }
    paramString = h.a(paramContext, paramString, true, (DialogInterface.OnCancelListener)a.QzP);
    AppMethodBeat.o(205476);
    return paramString;
  }
  
  public static s c(s params)
  {
    AppMethodBeat.i(205477);
    if ((params != null) && (params.isShowing())) {
      params.dismiss();
    }
    AppMethodBeat.o(205477);
    return params;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class a
    implements DialogInterface.OnCancelListener
  {
    public static final a QzP;
    
    static
    {
      AppMethodBeat.i(214276);
      QzP = new a();
      AppMethodBeat.o(214276);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(214273);
      try
      {
        paramDialogInterface.dismiss();
        AppMethodBeat.o(214273);
        return;
      }
      catch (Exception paramDialogInterface)
      {
        Log.e("MicroMsg.ToastUtil", "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
        AppMethodBeat.o(214273);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.d
 * JD-Core Version:    0.7.0.1
 */