package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiConfirmDialog;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "parseColor", "color", "plugin-webview_release"})
public final class d
  extends com.tencent.mm.plugin.webview.c.c.a
{
  private static final int ECX = 343;
  public static final d EHs;
  private static final String TAG = "MicroMsg.JsApiConfirmDialog";
  private static final String dLB = "confirmDialog";
  
  static
  {
    AppMethodBeat.i(175678);
    EHs = new d();
    TAG = "MicroMsg.JsApiConfirmDialog";
    ECX = 343;
    dLB = "confirmDialog";
    AppMethodBeat.o(175678);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.c.d paramd, final com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(199392);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    final HashMap localHashMap = new HashMap();
    try
    {
      com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(paramd.context);
      final JSONObject localJSONObject = paraml.Efz;
      if (localJSONObject.has("title")) {
        locala.aZh(localJSONObject.getString("title"));
      }
      if (localJSONObject.has("titleDesc")) {
        locala.as((CharSequence)localJSONObject.getString("titleDesc"));
      }
      Object localObject;
      if (localJSONObject.has("titleColor"))
      {
        localObject = localJSONObject.getString("titleColor");
        p.g(localObject, "rawParams.getString(KEY_TITLE_COLOR)");
        locala.afO(Color.parseColor((String)localObject) | 0xFF000000);
      }
      if (localJSONObject.has("titleMaxLine")) {
        locala.afP(localJSONObject.getInt("titleMaxLine"));
      }
      if (localJSONObject.has("titleGravity")) {
        locala.afQ(localJSONObject.getInt("titleGravity"));
      }
      if (localJSONObject.has("msg")) {
        locala.aZi(localJSONObject.getString("msg"));
      }
      if (localJSONObject.has("msgSubTitle")) {
        locala.at((CharSequence)localJSONObject.getString("msgSubTitle"));
      }
      if (localJSONObject.has("msgSubDesc")) {
        locala.aZj(localJSONObject.getString("msgSubDesc"));
      }
      if (localJSONObject.has("msgMaxLine")) {
        locala.afS(localJSONObject.getInt("msgMaxLine"));
      }
      if (localJSONObject.has("msgIconBase64"))
      {
        localObject = Base64.decode(localJSONObject.getString("msgIconBase64"), 0);
        locala.aK(BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
      }
      for (;;)
      {
        if (localJSONObject.has("contentDesc")) {
          locala.aZl(localJSONObject.getString("contentDesc"));
        }
        if (localJSONObject.has("contentDescGravity")) {
          locala.afT(localJSONObject.getInt("contentDescGravity"));
        }
        if (localJSONObject.has("confirmText")) {
          locala.aZo(localJSONObject.getString("confirmText"));
        }
        if (localJSONObject.has("confirmTextColor"))
        {
          localObject = localJSONObject.getString("confirmTextColor");
          p.g(localObject, "rawParams.getString(KEY_CONFIRM_COLOR)");
          locala.afW(Color.parseColor((String)localObject) | 0xFF000000);
        }
        if (localJSONObject.has("cancelText")) {
          locala.aZp(localJSONObject.getString("cancelText"));
        }
        if (localJSONObject.has("cancelTextColor"))
        {
          localObject = localJSONObject.getString("cancelTextColor");
          p.g(localObject, "rawParams.getString(KEY_CANCEL_COLOR)");
          locala.afX(Color.parseColor((String)localObject) | 0xFF000000);
        }
        locala.e((DialogInterface.OnCancelListener)new a(paramd, paraml, localHashMap));
        locala.a((DialogInterface.OnDismissListener)new b(paramd, paraml, localHashMap));
        locala.c((DialogInterface.OnClickListener)new c(paramd, paraml, localHashMap));
        locala.d((DialogInterface.OnClickListener)new d(paramd, paraml, localHashMap));
        c.h((d.g.a.a)new e(locala, localJSONObject, "msgIconUrl"));
        AppMethodBeat.o(199392);
        return true;
        if (localJSONObject.has("msgIconUrl")) {
          locala.aK(Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888));
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(TAG, (Throwable)localException, "doConfirmDialog", new Object[0]);
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":err", (Map)localHashMap);
      AppMethodBeat.o(199392);
    }
  }
  
  public final int eSw()
  {
    return ECX;
  }
  
  public final String eSx()
  {
    return dLB;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class a
    implements DialogInterface.OnCancelListener
  {
    a(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml, HashMap paramHashMap) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(175673);
      this.EDa.DQe.i(paraml.Efy, paraml.lcx + ":cancelled", (Map)localHashMap);
      AppMethodBeat.o(175673);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class b
    implements DialogInterface.OnDismissListener
  {
    b(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml, HashMap paramHashMap) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(175674);
      this.EDa.DQe.i(paraml.Efy, paraml.lcx + ":dismiss", (Map)localHashMap);
      AppMethodBeat.o(175674);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml, HashMap paramHashMap) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(175675);
      this.EDa.DQe.i(paraml.Efy, paraml.lcx + ":ok", (Map)localHashMap);
      AppMethodBeat.o(175675);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml, HashMap paramHashMap) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(175676);
      this.EDa.DQe.i(paraml.Efy, paraml.lcx + ":no", (Map)localHashMap);
      AppMethodBeat.o(175676);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(com.tencent.mm.ui.widget.a.d.a parama, JSONObject paramJSONObject, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.d
 * JD-Core Version:    0.7.0.1
 */