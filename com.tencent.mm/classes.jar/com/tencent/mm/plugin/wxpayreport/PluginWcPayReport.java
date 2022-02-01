package com.tencent.mm.plugin.wxpayreport;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.plugin.wxpay.b.a.b;
import com.tencent.mm.plugin.wxpayreport.a.c.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wxpayreport/PluginWcPayReport;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/wxpayreport/api/IPluginWcPayReport;", "()V", "checkViewAbnormal", "Lcom/tencent/threadpool/runnable/CancelableRunnable;", "options", "Lcom/tencent/mm/plugin/wxpayreport/api/ReportAbnormalOptions;", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "getJsapiMonotor", "Lcom/tencent/mm/plugin/webview/jsapi/api/IJsapiMonitor;", "onWebViewPageFinished", "url", "", "activity", "Landroid/app/Activity;", "plugin-wxpay-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginWcPayReport
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.wxpayreport.a.a
{
  public final com.tencent.threadpool.i.b checkViewAbnormal(com.tencent.mm.plugin.wxpayreport.a.b paramb)
  {
    AppMethodBeat.i(261080);
    s.u(paramb, "options");
    int i;
    long l;
    Object localObject2;
    MMFragmentActivity localMMFragmentActivity;
    if (paramb.XJw)
    {
      localObject1 = k.XJk;
      localObject1 = paramb.view;
      i = paramb.id;
      l = paramb.hnM;
      localObject2 = paramb.viewId.toString();
      localMMFragmentActivity = paramb.EzS;
      s.s(localMMFragmentActivity, "options.activity");
    }
    for (Object localObject1 = k.a((View)localObject1, i, l, (String)localObject2, localMMFragmentActivity, paramb.XJy, paramb.bgColor, Integer.valueOf(paramb.XJz));; localObject1 = null)
    {
      if (paramb.XJx)
      {
        localObject2 = f.XIR;
        f.a(paramb.view, Integer.valueOf(paramb.id), paramb.viewId.toString(), (Activity)paramb.EzS, paramb.hnM);
      }
      AppMethodBeat.o(261080);
      return localObject1;
    }
  }
  
  public final void configure(g paramg)
  {
    AppMethodBeat.i(261060);
    super.configure(paramg);
    bu.a((bu.a)new i());
    AppMethodBeat.o(261060);
  }
  
  public final void execute(g paramg) {}
  
  public final com.tencent.mm.plugin.webview.jsapi.a.a getJsapiMonotor()
  {
    AppMethodBeat.i(261067);
    com.tencent.mm.plugin.webview.jsapi.a.a locala = (com.tencent.mm.plugin.webview.jsapi.a.a)new l();
    AppMethodBeat.o(261067);
    return locala;
  }
  
  public final void onWebViewPageFinished(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(261071);
    if (paramActivity == null) {
      paramString = null;
    }
    while (paramString == null)
    {
      AppMethodBeat.o(261071);
      return;
      paramString = paramActivity.getIntent();
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = Integer.valueOf(paramString.getIntExtra("pay_report_scene", 0));
      }
    }
    if (paramString.intValue() == 1)
    {
      if (paramActivity == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(261071);
        throw paramString;
      }
      paramString = ((MMActivity)paramActivity).getSupportActionBar();
      if (paramString != null) {
        break label117;
      }
      paramString = null;
    }
    for (;;)
    {
      k localk = k.XJk;
      k.a(paramString, c.a.XJL.toString(), (MMFragmentActivity)paramActivity);
      AppMethodBeat.o(261071);
      return;
      label117:
      paramString = paramString.getCustomView();
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.findViewById(a.b.action_option_icon);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpayreport.PluginWcPayReport
 * JD-Core Version:    0.7.0.1
 */