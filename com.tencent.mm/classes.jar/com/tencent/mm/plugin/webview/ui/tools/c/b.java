package com.tencent.mm.plugin.webview.ui.tools.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Base64;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.a.d.a;
import d.g.b.k;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiConfirmDialog;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "parseColor", "color", "plugin-webview_release"})
public final class b
  extends com.tencent.mm.plugin.webview.c.c.a
{
  private static final int Bpa = 343;
  public static final b Bto;
  private static final String TAG = "MicroMsg.JsApiConfirmDialog";
  private static final String dAn = "confirmDialog";
  
  static
  {
    AppMethodBeat.i(175678);
    Bto = new b();
    TAG = "MicroMsg.JsApiConfirmDialog";
    Bpa = 343;
    dAn = "confirmDialog";
    AppMethodBeat.o(175678);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.c.d paramd, final com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(188919);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    final HashMap localHashMap = new HashMap();
    try
    {
      Object localObject1 = new d.a(paramd.context);
      JSONObject localJSONObject = paraml.ASh;
      if (localJSONObject.has("title")) {
        ((d.a)localObject1).aMf(localJSONObject.getString("title"));
      }
      if (localJSONObject.has("titleDesc")) {
        ((d.a)localObject1).as((CharSequence)localJSONObject.getString("titleDesc"));
      }
      Object localObject2;
      if (localJSONObject.has("titleColor"))
      {
        localObject2 = localJSONObject.getString("titleColor");
        k.g(localObject2, "rawParams.getString(KEY_TITLE_COLOR)");
        ((d.a)localObject1).aav(Color.parseColor((String)localObject2) | 0xFF000000);
      }
      if (localJSONObject.has("titleMaxLine")) {
        ((d.a)localObject1).aaw(localJSONObject.getInt("titleMaxLine"));
      }
      if (localJSONObject.has("titleGravity")) {
        ((d.a)localObject1).aax(localJSONObject.getInt("titleGravity"));
      }
      if (localJSONObject.has("msg")) {
        ((d.a)localObject1).aMg(localJSONObject.getString("msg"));
      }
      if (localJSONObject.has("msgSubTitle")) {
        ((d.a)localObject1).at((CharSequence)localJSONObject.getString("msgSubTitle"));
      }
      if (localJSONObject.has("msgSubDesc")) {
        ((d.a)localObject1).aMh(localJSONObject.getString("msgSubDesc"));
      }
      if (localJSONObject.has("msgMaxLine")) {
        ((d.a)localObject1).aaz(localJSONObject.getInt("msgMaxLine"));
      }
      if (localJSONObject.has("msgIconBase64"))
      {
        localObject2 = Base64.decode(localJSONObject.getString("msgIconBase64"), 0);
        ((d.a)localObject1).aF(BitmapFactory.decodeByteArray((byte[])localObject2, 0, localObject2.length));
      }
      for (;;)
      {
        if (localJSONObject.has("contentDesc")) {
          ((d.a)localObject1).aMj(localJSONObject.getString("contentDesc"));
        }
        if (localJSONObject.has("contentDescGravity")) {
          ((d.a)localObject1).aaA(localJSONObject.getInt("contentDescGravity"));
        }
        if (localJSONObject.has("confirmText")) {
          ((d.a)localObject1).aMm(localJSONObject.getString("confirmText"));
        }
        if (localJSONObject.has("confirmTextColor"))
        {
          localObject2 = localJSONObject.getString("confirmTextColor");
          k.g(localObject2, "rawParams.getString(KEY_CONFIRM_COLOR)");
          ((d.a)localObject1).aaD(Color.parseColor((String)localObject2) | 0xFF000000);
        }
        if (localJSONObject.has("cancelText")) {
          ((d.a)localObject1).aMn(localJSONObject.getString("cancelText"));
        }
        if (localJSONObject.has("cancelTextColor"))
        {
          localObject2 = localJSONObject.getString("cancelTextColor");
          k.g(localObject2, "rawParams.getString(KEY_CANCEL_COLOR)");
          ((d.a)localObject1).aaE(Color.parseColor((String)localObject2) | 0xFF000000);
        }
        ((d.a)localObject1).e((DialogInterface.OnCancelListener)new a(paramd, paraml, localHashMap));
        ((d.a)localObject1).a((DialogInterface.OnDismissListener)new b(paramd, paraml, localHashMap));
        ((d.a)localObject1).b((DialogInterface.OnClickListener)new c(paramd, paraml, localHashMap));
        ((d.a)localObject1).c((DialogInterface.OnClickListener)new d(paramd, paraml, localHashMap));
        localObject1 = ((d.a)localObject1).fft();
        if (localJSONObject.has("msgIconUrl"))
        {
          k.g(localObject1, "alert");
          localObject2 = ((com.tencent.mm.ui.widget.a.d)localObject1).ffs();
          com.tencent.mm.aw.a.a.ayO().a(localJSONObject.getString("msgIconUrl"), (ImageView)localObject2, new c.a().ayY().azc());
        }
        ((com.tencent.mm.ui.widget.a.d)localObject1).show();
        AppMethodBeat.o(188919);
        return true;
        if (localJSONObject.has("msgIconUrl")) {
          ((d.a)localObject1).aF(Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888));
        }
      }
      return false;
    }
    catch (JSONException localJSONException)
    {
      ad.printErrStackTrace(TAG, (Throwable)localJSONException, "doConfirmDialog", new Object[0]);
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":err", (Map)localHashMap);
      AppMethodBeat.o(188919);
    }
  }
  
  public final int ekB()
  {
    return Bpa;
  }
  
  public final String ekC()
  {
    return dAn;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class a
    implements DialogInterface.OnCancelListener
  {
    a(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml, HashMap paramHashMap) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(175673);
      this.Bpd.ARd.h(paraml.ASg, paraml.kbU + ":cancelled", (Map)localHashMap);
      AppMethodBeat.o(175673);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class b
    implements DialogInterface.OnDismissListener
  {
    b(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml, HashMap paramHashMap) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(175674);
      this.Bpd.ARd.h(paraml.ASg, paraml.kbU + ":dismiss", (Map)localHashMap);
      AppMethodBeat.o(175674);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml, HashMap paramHashMap) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(175675);
      this.Bpd.ARd.h(paraml.ASg, paraml.kbU + ":ok", (Map)localHashMap);
      AppMethodBeat.o(175675);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml, HashMap paramHashMap) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(175676);
      this.Bpd.ARd.h(paraml.ASg, paraml.kbU + ":no", (Map)localHashMap);
      AppMethodBeat.o(175676);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.b
 * JD-Core Version:    0.7.0.1
 */