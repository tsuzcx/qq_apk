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
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiConfirmDialog;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "parseColor", "color", "plugin-webview_release"})
public final class d
  extends com.tencent.mm.plugin.webview.d.c.a
{
  private static final int CDJ = 343;
  public static final d JwZ;
  private static final String TAG = "MicroMsg.JsApiConfirmDialog";
  private static final String edq = "confirmDialog";
  
  static
  {
    AppMethodBeat.i(175678);
    JwZ = new d();
    TAG = "MicroMsg.JsApiConfirmDialog";
    CDJ = 343;
    edq = "confirmDialog";
    AppMethodBeat.o(175678);
  }
  
  public final boolean a(f paramf, final n paramn)
  {
    AppMethodBeat.i(210584);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    final HashMap localHashMap = new HashMap();
    try
    {
      com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(paramf.context);
      final JSONObject localJSONObject = paramn.ISf;
      if (localJSONObject.has("title")) {
        locala.bon(localJSONObject.getString("title"));
      }
      if (localJSONObject.has("titleDesc")) {
        locala.aA((CharSequence)localJSONObject.getString("titleDesc"));
      }
      Object localObject;
      if (localJSONObject.has("titleColor"))
      {
        localObject = localJSONObject.getString("titleColor");
        p.g(localObject, "rawParams.getString(KEY_TITLE_COLOR)");
        locala.aoP(Color.parseColor((String)localObject) | 0xFF000000);
      }
      if (localJSONObject.has("titleMaxLine")) {
        locala.aoQ(localJSONObject.getInt("titleMaxLine"));
      }
      if (localJSONObject.has("titleGravity")) {
        locala.aoR(localJSONObject.getInt("titleGravity"));
      }
      if (localJSONObject.has("msg")) {
        locala.boo(localJSONObject.getString("msg"));
      }
      if (localJSONObject.has("msgSubTitle")) {
        locala.aB((CharSequence)localJSONObject.getString("msgSubTitle"));
      }
      if (localJSONObject.has("msgSubDesc")) {
        locala.bop(localJSONObject.getString("msgSubDesc"));
      }
      if (localJSONObject.has("msgMaxLine")) {
        locala.aoT(localJSONObject.getInt("msgMaxLine"));
      }
      if (localJSONObject.has("msgIconBase64"))
      {
        localObject = Base64.decode(localJSONObject.getString("msgIconBase64"), 0);
        locala.aN(BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
      }
      for (;;)
      {
        if (localJSONObject.has("contentDesc")) {
          locala.bor(localJSONObject.getString("contentDesc"));
        }
        if (localJSONObject.has("contentDescGravity")) {
          locala.aoU(localJSONObject.getInt("contentDescGravity"));
        }
        if (localJSONObject.has("confirmText")) {
          locala.bou(localJSONObject.getString("confirmText"));
        }
        if (localJSONObject.has("confirmTextColor"))
        {
          localObject = localJSONObject.getString("confirmTextColor");
          p.g(localObject, "rawParams.getString(KEY_CONFIRM_COLOR)");
          locala.aoX(Color.parseColor((String)localObject) | 0xFF000000);
        }
        if (localJSONObject.has("cancelText")) {
          locala.bov(localJSONObject.getString("cancelText"));
        }
        if (localJSONObject.has("cancelTextColor"))
        {
          localObject = localJSONObject.getString("cancelTextColor");
          p.g(localObject, "rawParams.getString(KEY_CANCEL_COLOR)");
          locala.aoY(Color.parseColor((String)localObject) | 0xFF000000);
        }
        locala.f((DialogInterface.OnCancelListener)new a(paramf, paramn, localHashMap));
        locala.a((DialogInterface.OnDismissListener)new b(paramf, paramn, localHashMap));
        locala.c((DialogInterface.OnClickListener)new c(paramf, paramn, localHashMap));
        locala.d((DialogInterface.OnClickListener)new d(paramf, paramn, localHashMap));
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new e(locala, localJSONObject, "msgIconUrl"));
        AppMethodBeat.o(210584);
        return true;
        if (localJSONObject.has("msgIconUrl")) {
          locala.aN(Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888));
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "doConfirmDialog", new Object[0]);
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":err", (Map)localHashMap);
      AppMethodBeat.o(210584);
    }
  }
  
  public final int ePA()
  {
    return CDJ;
  }
  
  public final String ePz()
  {
    return edq;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class a
    implements DialogInterface.OnCancelListener
  {
    a(f paramf, n paramn, HashMap paramHashMap) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(175673);
      this.CDE.IQZ.h(paramn.ISe, paramn.mhO + ":cancelled", (Map)localHashMap);
      AppMethodBeat.o(175673);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class b
    implements DialogInterface.OnDismissListener
  {
    b(f paramf, n paramn, HashMap paramHashMap) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(175674);
      this.CDE.IQZ.h(paramn.ISe, paramn.mhO + ":dismiss", (Map)localHashMap);
      AppMethodBeat.o(175674);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(f paramf, n paramn, HashMap paramHashMap) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(175675);
      this.CDE.IQZ.h(paramn.ISe, paramn.mhO + ":ok", (Map)localHashMap);
      AppMethodBeat.o(175675);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(f paramf, n paramn, HashMap paramHashMap) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(175676);
      this.CDE.IQZ.h(paramn.ISe, paramn.mhO + ":no", (Map)localHashMap);
      AppMethodBeat.o(175676);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
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