package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secdata.ui.a;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.stub.b;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$webViewCallback$1", "Lcom/tencent/mm/plugin/webview/stub/DefaultWebViewStubCallback;", "getCommitUrl", "", "getCurrentUrl", "invokeAsResult", "Landroid/os/Bundle;", "actionCode", "", "data", "onHandleEnd", "", "callbackId", "ret", "retData", "dealNext", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$y
  extends b
{
  c$y(c paramc) {}
  
  private static final void a(j paramj, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(286987);
    s.u(paramj, "$jsApi");
    try
    {
      paramj.a(paramString1, paramString2, p.bm(paramBundle), paramBoolean);
      AppMethodBeat.o(286987);
      return;
    }
    finally
    {
      Log.e(c.access$getTAG$cp(), "In jsapi onHandleEnd method, it happens something unwanted!");
      AppMethodBeat.o(286987);
    }
  }
  
  public final boolean a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(287014);
    Log.d(c.access$getTAG$cp(), "onHandleEnd");
    Object localObject = c.l(this.MjI);
    if (localObject == null)
    {
      AppMethodBeat.o(287014);
      return false;
    }
    try
    {
      localObject = ((e)localObject).getJsapi();
      h.ahAA.bk(new c.y..ExternalSyntheticLambda0((j)localObject, paramString1, paramString2, paramBundle, paramBoolean));
      AppMethodBeat.o(287014);
      return false;
    }
    finally
    {
      for (;;)
      {
        Log.e(c.access$getTAG$cp(), "In onHandleEnd method, it happens something unwanted!");
      }
    }
  }
  
  public final String cxY()
  {
    AppMethodBeat.i(287001);
    Log.v(c.access$getTAG$cp(), "getCommitUrl");
    try
    {
      Object localObject = c.l(this.MjI);
      if (localObject == null)
      {
        AppMethodBeat.o(287001);
        return "";
      }
      localObject = ((BaseWebViewController)localObject).Wwz;
      if (localObject == null)
      {
        AppMethodBeat.o(287001);
        return "";
      }
    }
    finally
    {
      Log.printErrStackTrace(c.access$getTAG$cp(), localThrowable, "getCommitUrl exception", new Object[0]);
      AppMethodBeat.o(287001);
      return "";
    }
    AppMethodBeat.o(287001);
    return localThrowable;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(287006);
    Log.v(c.access$getTAG$cp(), "getCurrentUrl");
    try
    {
      Object localObject = c.l(this.MjI);
      if (localObject == null)
      {
        AppMethodBeat.o(287006);
        return "";
      }
      localObject = ((e)localObject).getCurrentUrl();
      if (localObject == null)
      {
        AppMethodBeat.o(287006);
        return "";
      }
    }
    finally
    {
      Log.printErrStackTrace(c.access$getTAG$cp(), localThrowable, "getCommitUrl exception", new Object[0]);
      AppMethodBeat.o(287006);
      return "";
    }
    AppMethodBeat.o(287006);
    return localThrowable;
  }
  
  public final Bundle m(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(287026);
    Bundle localBundle2 = new Bundle();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(287026);
      return localBundle2;
      try
      {
        if ((this.MjI.parent.getContext() == null) || (paramBundle == null)) {
          continue;
        }
        paramBundle.setClassLoader(this.MjI.parent.getContext().getClassLoader());
        Bundle localBundle1 = paramBundle.getBundle("open_ui_with_webview_ui_extras");
        String str1 = IntentUtil.getString(paramBundle, "open_ui_with_webview_ui_plugin_name");
        String str2 = IntentUtil.getString(paramBundle, "open_ui_with_webview_ui_plugin_entry");
        Context localContext = this.MjI.parent.getContext();
        Intent localIntent = new Intent();
        paramBundle = localBundle1;
        if (localBundle1 == null) {
          paramBundle = new Bundle();
        }
        com.tencent.mm.br.c.b(localContext, str1, str2, localIntent.putExtras(paramBundle));
        continue;
      }
      finally
      {
        Log.e(c.access$getTAG$cp(), "In invokeAsResult method, it happens something unwanted!");
      }
      continue;
      paramBundle = a.PlI;
      paramBundle = this.MjI.parent.getContext();
      s.s(paramBundle, "parent.context");
      paramBundle = (dtk)a.a.a(paramBundle, 7, dtk.class);
      if (paramBundle != null)
      {
        localBundle2.putString("key_get_a8key_req_params_biz_info", paramBundle.zIO);
        localBundle2.putString("key_get_a8key_req_params_source_info", "music_operation_webview");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.c.y
 * JD-Core Version:    0.7.0.1
 */