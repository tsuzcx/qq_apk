package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.plugin.websearch.ui.a.g;
import com.tencent.mm.plugin.websearch.webview.q.a.a;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleHaoKanAction;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "compatibilityMode", "", "getCompatibilityMode", "()Z", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleCheckSyncCommentPermission", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "handleCheckSyncHanKanPermissionAction", "handleMsg", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends a
{
  private static final boolean WFo;
  public static final q Xnm;
  
  static
  {
    AppMethodBeat.i(297739);
    Xnm = new q();
    WFo = true;
    AppMethodBeat.o(297739);
  }
  
  public final boolean a(h paramh, final p paramp)
  {
    AppMethodBeat.i(298423);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Object localObject1 = (String)paramp.params.get("action");
    Log.i("MicroMsg.JsApiHandleHaoKanAction", "JsApiHandleHaoKanAction action=%s", new Object[] { localObject1 });
    Object localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail action is empty"), null);
      AppMethodBeat.o(298423);
      return true;
    }
    if (s.p(localObject1, "checkSyncHaoKanPermission"))
    {
      if (!MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("tophitory_show_init_dialog", false))
      {
        localObject2 = AppForegroundDelegate.aCe();
        s.s(localObject2, "getTopActivity()");
        if ((Activity)((WeakReference)localObject2).get() != null)
        {
          localObject1 = com.tencent.mm.plugin.websearch.webview.q.Wsi;
          localObject1 = (Activity)((WeakReference)localObject2).get();
          s.checkNotNull(localObject1);
          s.s(localObject1, "weakReferenceActivity?.get()!!");
          localObject1 = (Context)localObject1;
          paramp = (q.a.a)new b(paramh, paramp);
          paramh = (Activity)((WeakReference)localObject2).get();
          if (paramh == null)
          {
            paramh = null;
            com.tencent.mm.plugin.websearch.webview.q.a.a((Context)localObject1, paramp, paramh);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(298423);
        return true;
        paramh = paramh.getResources();
        if (paramh == null)
        {
          paramh = null;
          break;
        }
        paramh = paramh.getString(a.g.top_story_video_click_haokan_education_publish);
        break;
        Log.i("MicroMsg.JsApiHandleHaoKanAction", "handleCheckSyncHanKanPermissionAction activity is null");
        localObject1 = new HashMap();
        ((Map)localObject1).put("result", Integer.valueOf(0));
        ((Map)localObject1).put("dialogShowed", Integer.valueOf(0));
        paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), (Map)localObject1);
        continue;
        localObject1 = new HashMap();
        ((Map)localObject1).put("result", Integer.valueOf(1));
        ((Map)localObject1).put("dialogShowed", Integer.valueOf(0));
        paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), (Map)localObject1);
      }
    }
    if (s.p(localObject1, "checkSyncCommentPermission"))
    {
      if (!MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("tophitory_show_comment_dialog", false))
      {
        localObject1 = AppForegroundDelegate.aCe();
        s.s(localObject1, "getTopActivity()");
        if ((Activity)((WeakReference)localObject1).get() != null)
        {
          localObject2 = com.tencent.mm.plugin.websearch.webview.q.Wsi;
          localObject1 = (Activity)((WeakReference)localObject1).get();
          s.checkNotNull(localObject1);
          s.s(localObject1, "weakReferenceActivity?.get()!!");
          com.tencent.mm.plugin.websearch.webview.q.a.a((Context)localObject1, (q.a.a)new a(paramh, paramp), true);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(298423);
        return true;
        Log.i("MicroMsg.JsApiHandleHaoKanAction", "handleCheckSyncCommentPermission activity is null");
        localObject1 = new HashMap();
        ((Map)localObject1).put("result", Integer.valueOf(0));
        ((Map)localObject1).put("dialogShowed", Integer.valueOf(0));
        paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), (Map)localObject1);
        continue;
        localObject1 = new HashMap();
        ((Map)localObject1).put("result", Integer.valueOf(1));
        ((Map)localObject1).put("dialogShowed", Integer.valueOf(0));
        paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), (Map)localObject1);
      }
    }
    AppMethodBeat.o(298423);
    return false;
  }
  
  public final String gPX()
  {
    return "handleHaokanAction";
  }
  
  public final int gPZ()
  {
    return 335;
  }
  
  public final boolean itW()
  {
    return WFo;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleHaoKanAction$handleCheckSyncCommentPermission$1", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchUtils$Companion$IDismissDialogClickCallBack;", "dismiss", "", "actionOk", "", "onPosition", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements q.a.a
  {
    a(h paramh, p paramp) {}
    
    public final void hNq()
    {
      AppMethodBeat.i(297698);
      Object localObject = new HashMap();
      ((Map)localObject).put("result", Integer.valueOf(1));
      ((Map)localObject).put("dialogShowed", Integer.valueOf(1));
      this.XmY.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), (Map)localObject);
      localObject = com.tencent.mm.plugin.websearch.webview.q.Wsi;
      com.tencent.mm.plugin.websearch.webview.q.a.t(1L, 2L, 1L);
      AppMethodBeat.o(297698);
    }
    
    public final void hNr()
    {
      AppMethodBeat.i(297703);
      Log.i("MicroMsg.JsApiHandleHaoKanAction", "dismiss is null");
      Object localObject = new HashMap();
      ((Map)localObject).put("result", Integer.valueOf(0));
      ((Map)localObject).put("dialogShowed", Integer.valueOf(1));
      this.XmY.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), (Map)localObject);
      localObject = com.tencent.mm.plugin.websearch.webview.q.Wsi;
      com.tencent.mm.plugin.websearch.webview.q.a.t(2L, 2L, 1L);
      AppMethodBeat.o(297703);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleHaoKanAction$handleCheckSyncHanKanPermissionAction$1", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchUtils$Companion$IDismissDialogClickCallBack;", "dismiss", "", "actionOk", "", "onPosition", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements q.a.a
  {
    b(h paramh, p paramp) {}
    
    public final void hNq()
    {
      AppMethodBeat.i(297695);
      Object localObject = new HashMap();
      ((Map)localObject).put("result", Integer.valueOf(1));
      ((Map)localObject).put("dialogShowed", Integer.valueOf(1));
      this.XmY.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), (Map)localObject);
      localObject = com.tencent.mm.plugin.websearch.webview.q.Wsi;
      com.tencent.mm.plugin.websearch.webview.q.a.t(1L, 1L, 1L);
      AppMethodBeat.o(297695);
    }
    
    public final void hNr()
    {
      AppMethodBeat.i(297702);
      Log.i("MicroMsg.JsApiHandleHaoKanAction", "dismiss is null");
      Object localObject = new HashMap();
      ((Map)localObject).put("result", Integer.valueOf(0));
      ((Map)localObject).put("dialogShowed", Integer.valueOf(1));
      this.XmY.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), (Map)localObject);
      localObject = com.tencent.mm.plugin.websearch.webview.q.Wsi;
      com.tencent.mm.plugin.websearch.webview.q.a.t(2L, 1L, 1L);
      AppMethodBeat.o(297702);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.q
 * JD-Core Version:    0.7.0.1
 */