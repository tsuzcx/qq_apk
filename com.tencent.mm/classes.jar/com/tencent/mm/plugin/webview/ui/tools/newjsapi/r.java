package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.ui.widget.a.g;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "showRequestPhoneNumDialog", "", "phoneNumber", "GetUserBindPhoneNumber", "plugin-webview_release"})
public final class r
  extends com.tencent.mm.plugin.webview.d.c.a
{
  public static final r JxE;
  
  static
  {
    AppMethodBeat.i(210660);
    JxE = new r();
    AppMethodBeat.o(210660);
  }
  
  public final boolean a(f paramf, final n paramn)
  {
    AppMethodBeat.i(210659);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    Object localObject2 = paramn.params.get("requestName");
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    String str = (String)localObject1;
    localObject2 = paramn.params.get("requestIconUrl");
    localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    localObject1 = (String)localObject1;
    localObject2 = (CharSequence)str;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localObject1 = (CharSequence)localObject1;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label169;
        }
      }
    }
    label169:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label174;
      }
      paramf.IQZ.h(paramn.ISe, "requestBindPhoneNumber:fail requestName or requestIcon is null", null);
      AppMethodBeat.o(210659);
      return true;
      i = 0;
      break;
    }
    label174:
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(null, (com.tencent.mm.ipcinvoker.b)new a(), (d)new b(paramf, paramn));
    AppMethodBeat.o(210659);
    return true;
  }
  
  public final int ePA()
  {
    return 387;
  }
  
  public final String ePz()
  {
    return "requestBindPhoneNumber";
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$GetUserBindPhoneNumber;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
  public static final class a
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCString>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "onCallback"})
  static final class b<T>
    implements d<IPCString>
  {
    b(f paramf, n paramn) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(g paramg, f paramf, n paramn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(210656);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$showRequestPhoneNumDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      this.hIa.bMo();
      paramView = this.CDE.IQZ;
      localObject = this.pGr.ISe;
      StringBuilder localStringBuilder = new StringBuilder();
      r localr = r.JxE;
      paramView.h((String)localObject, "requestBindPhoneNumber:cancel", null);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$showRequestPhoneNumDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(210656);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(g paramg, String paramString, f paramf, n paramn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(210657);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$showRequestPhoneNumDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      this.hIa.bMo();
      paramView = (CharSequence)this.JxH;
      int i;
      Object localObject2;
      Object localObject3;
      if ((paramView == null) || (paramView.length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label137;
        }
        paramView = this.CDE.IQZ;
        localObject1 = this.pGr.ISe;
        localObject2 = new StringBuilder();
        localObject3 = r.JxE;
        paramView.h((String)localObject1, "requestBindPhoneNumber:fail not bind phone", null);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$showRequestPhoneNumDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210657);
        return;
        i = 0;
        break;
        label137:
        paramView = ae.b(s.U("phoneNumber", this.JxH));
        localObject1 = this.CDE.IQZ;
        localObject2 = this.pGr.ISe;
        localObject3 = new StringBuilder();
        r localr = r.JxE;
        ((h)localObject1).h((String)localObject2, "requestBindPhoneNumber:ok", paramView);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(g paramg, f paramf, n paramn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(210658);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$showRequestPhoneNumDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      this.hIa.bMo();
      paramView = this.CDE.IQZ;
      localObject = this.pGr.ISe;
      StringBuilder localStringBuilder = new StringBuilder();
      r localr = r.JxE;
      paramView.h((String)localObject, "requestBindPhoneNumber:fail not bind phone", null);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$showRequestPhoneNumDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(210658);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.r
 * JD-Core Version:    0.7.0.1
 */