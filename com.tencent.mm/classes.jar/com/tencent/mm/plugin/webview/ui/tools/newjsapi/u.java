package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.ui.widget.a.g;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "showRequestPhoneNumDialog", "", "phoneNumber", "GetUserBindPhoneNumber", "plugin-webview_release"})
public final class u
  extends com.tencent.mm.plugin.webview.d.c.a
{
  public static final u QvB;
  
  static
  {
    AppMethodBeat.i(268447);
    QvB = new u();
    AppMethodBeat.o(268447);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, final n paramn)
  {
    AppMethodBeat.i(268445);
    p.k(paramf, "env");
    p.k(paramn, "msg");
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
          break label174;
        }
      }
    }
    label174:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label179;
      }
      paramf.PNo.h(paramn.POu, "requestBindPhoneNumber:fail requestName or requestIcon is null", null);
      AppMethodBeat.o(268445);
      return true;
      i = 0;
      break;
    }
    label179:
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(null, (d)new a(), (com.tencent.mm.ipcinvoker.f)new b(paramf, paramn));
    AppMethodBeat.o(268445);
    return true;
  }
  
  public final String fCm()
  {
    return "requestBindPhoneNumber";
  }
  
  public final int fCn()
  {
    return 387;
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$GetUserBindPhoneNumber;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
  public static final class a
    implements d<IPCVoid, IPCString>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "onCallback"})
  static final class b<T>
    implements com.tencent.mm.ipcinvoker.f<IPCString>
  {
    b(com.tencent.mm.plugin.webview.d.f paramf, n paramn) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(g paramg, com.tencent.mm.plugin.webview.d.f paramf, n paramn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(218919);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$showRequestPhoneNumDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      this.kvu.bYF();
      paramView = this.IIg.PNo;
      localObject = this.sRE.POu;
      StringBuilder localStringBuilder = new StringBuilder();
      u localu = u.QvB;
      paramView.h((String)localObject, "requestBindPhoneNumber:cancel", null);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$showRequestPhoneNumDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(218919);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(g paramg, String paramString, com.tencent.mm.plugin.webview.d.f paramf, n paramn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242568);
      Object localObject1 = new b();
      ((b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$showRequestPhoneNumDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
      this.kvu.bYF();
      paramView = (CharSequence)this.QvE;
      int i;
      Object localObject2;
      Object localObject3;
      if ((paramView == null) || (paramView.length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label137;
        }
        paramView = this.IIg.PNo;
        localObject1 = this.sRE.POu;
        localObject2 = new StringBuilder();
        localObject3 = u.QvB;
        paramView.h((String)localObject1, "requestBindPhoneNumber:fail not bind phone", null);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$showRequestPhoneNumDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242568);
        return;
        i = 0;
        break;
        label137:
        paramView = ae.d(s.M("phoneNumber", this.QvE));
        localObject1 = this.IIg.PNo;
        localObject2 = this.sRE.POu;
        localObject3 = new StringBuilder();
        u localu = u.QvB;
        ((h)localObject1).h((String)localObject2, "requestBindPhoneNumber:ok", paramView);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(g paramg, com.tencent.mm.plugin.webview.d.f paramf, n paramn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(219116);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$showRequestPhoneNumDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      this.kvu.bYF();
      paramView = this.IIg.PNo;
      localObject = this.sRE.POu;
      StringBuilder localStringBuilder = new StringBuilder();
      u localu = u.QvB;
      paramView.h((String)localObject, "requestBindPhoneNumber:fail not bind phone", null);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$showRequestPhoneNumDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(219116);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.u
 * JD-Core Version:    0.7.0.1
 */