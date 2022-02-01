package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ba.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/util/ToastUtil;", "", "()V", "TAG", "", "dismiss", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dialog", "showProgress", "wording", "context", "Landroid/content/Context;", "showToast", "bundle", "Landroid/os/Bundle;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e XsJ;
  
  static
  {
    AppMethodBeat.i(295734);
    XsJ = new e();
    AppMethodBeat.o(295734);
  }
  
  private static final void G(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(295730);
    try
    {
      paramDialogInterface.dismiss();
      AppMethodBeat.o(295730);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      Log.e("MicroMsg.ToastUtil", "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
      AppMethodBeat.o(295730);
    }
  }
  
  public static final w a(Bundle paramBundle, Context paramContext, w paramw)
  {
    AppMethodBeat.i(295713);
    s.u(paramContext, "context");
    String str;
    if (paramBundle == null)
    {
      str = null;
      if (str == null) {}
    }
    switch (str.hashCode())
    {
    default: 
    case 1940070258: 
    case -1867169789: 
      do
      {
        do
        {
          AppMethodBeat.o(295713);
          return null;
          str = paramBundle.getString("status");
          break;
        } while (!str.equals("dismissloading"));
        paramBundle = d(paramw);
        AppMethodBeat.o(295713);
        return paramBundle;
      } while (!str.equals("success"));
      if (paramBundle != null) {
        break;
      }
    }
    for (paramBundle = null;; paramBundle = paramBundle.getString("wording"))
    {
      aa.db(paramContext, paramBundle);
      break;
      if (!str.equals("loading")) {
        break;
      }
      paramBundle = paramContext.getString(a.e.app_waiting);
      s.s(paramBundle, "context.getString(R.string.app_waiting)");
      paramBundle = a(paramBundle, paramContext, paramw);
      AppMethodBeat.o(295713);
      return paramBundle;
    }
  }
  
  public static w a(String paramString, Context paramContext, w paramw)
  {
    AppMethodBeat.i(295719);
    s.u(paramString, "wording");
    s.u(paramContext, "context");
    MMActivity localMMActivity = f.lf(paramContext);
    if ((localMMActivity != null) && (localMMActivity.isFinishing() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(295719);
      return null;
    }
    if (paramw != null)
    {
      d(paramw);
      if (!paramw.isShowing())
      {
        paramw.show();
        AppMethodBeat.o(295719);
        return paramw;
      }
    }
    paramString = k.a(paramContext, paramString, true, e..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(295719);
    return paramString;
  }
  
  public static w d(w paramw)
  {
    AppMethodBeat.i(295723);
    if ((paramw != null) && (paramw.isShowing())) {
      paramw.dismiss();
    }
    AppMethodBeat.o(295723);
    return paramw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.e
 * JD-Core Version:    0.7.0.1
 */