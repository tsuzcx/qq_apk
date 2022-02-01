package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.threadpool.i;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "showRequestPhoneNumDialog", "", "phoneNumber", "GetUserBindPhoneNumber", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  extends com.tencent.mm.plugin.webview.jsapi.c.a
{
  public static final ad XnR;
  
  static
  {
    AppMethodBeat.i(297567);
    XnR = new ad();
    AppMethodBeat.o(297567);
  }
  
  private static final void a(j paramj, com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp, View paramView)
  {
    AppMethodBeat.i(297551);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramj);
    localb.cH(paramh);
    localb.cH(paramp);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$dialog");
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    paramj.cyW();
    paramh.WDy.doCallback(paramp.WEH, s.X("requestBindPhoneNumber", ":cancel"), null);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(297551);
  }
  
  private static final void a(j paramj, String paramString, com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp, View paramView)
  {
    AppMethodBeat.i(297560);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramj);
    localb.cH(paramString);
    localb.cH(paramh);
    localb.cH(paramp);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$dialog");
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    paramj.cyW();
    paramj = (CharSequence)paramString;
    int i;
    if ((paramj == null) || (paramj.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label171;
      }
      paramh.WDy.doCallback(paramp.WEH, s.X("requestBindPhoneNumber", ":fail not bind phone"), null);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(297560);
      return;
      i = 0;
      break;
      label171:
      paramj = ak.l(v.Y("phoneNumber", paramString));
      paramh.WDy.doCallback(paramp.WEH, s.X("requestBindPhoneNumber", ":ok"), paramj);
    }
  }
  
  private static final void b(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp, IPCString paramIPCString)
  {
    AppMethodBeat.i(297536);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    if (paramIPCString == null) {}
    for (paramIPCString = null;; paramIPCString = paramIPCString.value)
    {
      localObject1 = paramp.params.get("requestName");
      if (localObject1 != null) {
        break;
      }
      paramh = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(297536);
      throw paramh;
    }
    String str1 = (String)localObject1;
    Object localObject1 = paramp.params.get("requestIconUrl");
    if (localObject1 == null)
    {
      paramh = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(297536);
      throw paramh;
    }
    String str2 = (String)localObject1;
    localObject1 = new j(paramh.context, 0, 0, false);
    ((j)localObject1).rootView.setBackgroundColor(paramh.context.getResources().getColor(c.c.white));
    View localView1 = View.inflate(paramh.context, c.g.webview_jsapi_requrest_get_bind_phone, null);
    Object localObject2 = localView1.findViewById(c.f.request_icon);
    s.s(localObject2, "contentView.findViewById(R.id.request_icon)");
    localObject2 = (ImageView)localObject2;
    Object localObject3 = localView1.findViewById(c.f.request_name);
    s.s(localObject3, "contentView.findViewById(R.id.request_name)");
    TextView localTextView = (TextView)localObject3;
    localObject3 = localView1.findViewById(c.f.phone_number_manager_dialog_item_phone);
    s.s(localObject3, "contentView.findViewById…anager_dialog_item_phone)");
    localObject3 = (TextView)localObject3;
    View localView2 = localView1.findViewById(c.f.phone_number_manager_dialog_item_remark);
    s.s(localView2, "contentView.findViewById…nager_dialog_item_remark)");
    View localView3 = localView1.findViewById(c.f.button_group);
    s.s(localView3, "contentView.findViewById(R.id.button_group)");
    View localView4 = localView1.findViewById(c.f.button_i_known);
    s.s(localView4, "contentView.findViewById(R.id.button_i_known)");
    View localView5 = localView1.findViewById(c.f.request_cancel);
    s.s(localView5, "contentView.findViewById(R.id.request_cancel)");
    View localView6 = localView1.findViewById(c.f.request_ok);
    s.s(localView6, "contentView.findViewById(R.id.request_ok)");
    localView5.setOnClickListener(new ad..ExternalSyntheticLambda0((j)localObject1, paramh, paramp));
    localView6.setOnClickListener(new ad..ExternalSyntheticLambda2((j)localObject1, paramIPCString, paramh, paramp));
    localView4.setOnClickListener(new ad..ExternalSyntheticLambda1((j)localObject1, paramh, paramp));
    localTextView.setText((CharSequence)str1);
    paramp = new c.a();
    paramp.oKo = true;
    paramp.oKB = c.h.default_avatar_round;
    paramp.nrc = true;
    com.tencent.mm.modelimage.loader.a.bKl().a(str2, (ImageView)localObject2, paramp.bKx());
    paramp = (CharSequence)paramIPCString;
    int i;
    if ((paramp == null) || (paramp.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label534;
      }
      ((TextView)localObject3).setVisibility(0);
      localView2.setVisibility(8);
      localView3.setVisibility(8);
      localView4.setVisibility(0);
      ((TextView)localObject3).setTextColor(paramh.context.getResources().getColor(c.c.hint_text_color));
      ((TextView)localObject3).setText(paramh.context.getText(c.i.webview_jsapi_not_bind_phone_number));
    }
    for (;;)
    {
      ((j)localObject1).setCustomView(localView1);
      ((j)localObject1).dDn();
      AppMethodBeat.o(297536);
      return;
      i = 0;
      break;
      label534:
      ((TextView)localObject3).setVisibility(0);
      localView2.setVisibility(0);
      localView3.setVisibility(0);
      localView4.setVisibility(8);
      ((TextView)localObject3).setText((CharSequence)paramIPCString);
    }
  }
  
  private static final void b(j paramj, com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp, View paramView)
  {
    AppMethodBeat.i(297564);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramj);
    localb.cH(paramh);
    localb.cH(paramp);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$dialog");
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    paramj.cyW();
    paramh.WDy.doCallback(paramp.WEH, s.X("requestBindPhoneNumber", ":fail not bind phone"), null);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(297564);
  }
  
  private static final void c(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp, IPCString paramIPCString)
  {
    AppMethodBeat.i(297544);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    if (paramIPCString == null) {}
    for (Object localObject = null;; localObject = paramIPCString.value)
    {
      s.X("bindPhone :", localObject);
      com.tencent.e.f.h.jXD();
      com.tencent.threadpool.h.ahAA.bk(new ad..ExternalSyntheticLambda4(paramh, paramp, paramIPCString));
      AppMethodBeat.o(297544);
      return;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp)
  {
    AppMethodBeat.i(297605);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Object localObject1 = paramp.params.get("requestName");
    Object localObject2;
    if ((localObject1 instanceof String))
    {
      localObject1 = (String)localObject1;
      localObject2 = paramp.params.get("requestIconUrl");
      if (!(localObject2 instanceof String)) {
        break label168;
      }
      localObject2 = (String)localObject2;
      label76:
      localObject1 = (CharSequence)localObject1;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label174;
      }
      i = 1;
      label100:
      if (i == 0)
      {
        localObject1 = (CharSequence)localObject2;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label179;
        }
      }
    }
    label168:
    label174:
    label179:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label184;
      }
      paramh.WDy.doCallback(paramp.WEH, s.X("requestBindPhoneNumber", ":fail requestName or requestIcon is null"), null);
      AppMethodBeat.o(297605);
      return true;
      localObject1 = null;
      break;
      localObject2 = null;
      break label76;
      i = 0;
      break label100;
    }
    label184:
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(null, (d)new a(), new ad..ExternalSyntheticLambda3(paramh, paramp));
    AppMethodBeat.o(297605);
    return true;
  }
  
  public final String gPX()
  {
    return "requestBindPhoneNumber";
  }
  
  public final int gPZ()
  {
    return 387;
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$GetUserBindPhoneNumber;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements d<IPCVoid, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.ad
 * JD-Core Version:    0.7.0.1
 */