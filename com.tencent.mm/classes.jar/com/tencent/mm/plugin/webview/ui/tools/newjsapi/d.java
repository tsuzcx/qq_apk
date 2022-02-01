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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiConfirmDialog;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "parseColor", "color", "plugin-webview_release"})
public final class d
  extends com.tencent.mm.plugin.webview.d.c.a
{
  private static final int IIl = 343;
  public static final d QuO;
  private static final String TAG = "MicroMsg.JsApiConfirmDialog";
  private static final String fXz = "confirmDialog";
  
  static
  {
    AppMethodBeat.i(175678);
    QuO = new d();
    TAG = "MicroMsg.JsApiConfirmDialog";
    IIl = 343;
    fXz = "confirmDialog";
    AppMethodBeat.o(175678);
  }
  
  public final boolean a(f paramf, final n paramn)
  {
    AppMethodBeat.i(266584);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    final HashMap localHashMap = new HashMap();
    try
    {
      com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(paramf.context);
      final JSONObject localJSONObject = paramn.POv;
      if (localJSONObject.has("title")) {
        locala.bBc(localJSONObject.getString("title"));
      }
      if (localJSONObject.has("titleDesc")) {
        locala.aP((CharSequence)localJSONObject.getString("titleDesc"));
      }
      Object localObject;
      if (localJSONObject.has("titleColor"))
      {
        localObject = localJSONObject.getString("titleColor");
        p.j(localObject, "rawParams.getString(KEY_TITLE_COLOR)");
        locala.ayd(Color.parseColor((String)localObject) | 0xFF000000);
      }
      if (localJSONObject.has("titleMaxLine")) {
        locala.aye(localJSONObject.getInt("titleMaxLine"));
      }
      if (localJSONObject.has("titleGravity")) {
        locala.ayf(localJSONObject.getInt("titleGravity"));
      }
      if (localJSONObject.has("msg")) {
        locala.bBd(localJSONObject.getString("msg"));
      }
      if (localJSONObject.has("msgSubTitle")) {
        locala.aQ((CharSequence)localJSONObject.getString("msgSubTitle"));
      }
      if (localJSONObject.has("msgSubDesc")) {
        locala.bBe(localJSONObject.getString("msgSubDesc"));
      }
      if (localJSONObject.has("msgMaxLine")) {
        locala.ayh(localJSONObject.getInt("msgMaxLine"));
      }
      if (localJSONObject.has("msgIconBase64"))
      {
        localObject = Base64.decode(localJSONObject.getString("msgIconBase64"), 0);
        locala.aM(BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
      }
      for (;;)
      {
        if (localJSONObject.has("contentDesc")) {
          locala.bBg(localJSONObject.getString("contentDesc"));
        }
        if (localJSONObject.has("contentDescGravity")) {
          locala.ayi(localJSONObject.getInt("contentDescGravity"));
        }
        if (localJSONObject.has("confirmText")) {
          locala.bBj(localJSONObject.getString("confirmText"));
        }
        if (localJSONObject.has("confirmTextColor"))
        {
          localObject = localJSONObject.getString("confirmTextColor");
          p.j(localObject, "rawParams.getString(KEY_CONFIRM_COLOR)");
          locala.ayl(Color.parseColor((String)localObject) | 0xFF000000);
        }
        if (localJSONObject.has("cancelText")) {
          locala.bBk(localJSONObject.getString("cancelText"));
        }
        if (localJSONObject.has("cancelTextColor"))
        {
          localObject = localJSONObject.getString("cancelTextColor");
          p.j(localObject, "rawParams.getString(KEY_CANCEL_COLOR)");
          locala.aym(Color.parseColor((String)localObject) | 0xFF000000);
        }
        locala.f((DialogInterface.OnCancelListener)new a(paramf, paramn, localHashMap));
        locala.a((DialogInterface.OnDismissListener)new b(paramf, paramn, localHashMap));
        locala.c((DialogInterface.OnClickListener)new c(paramf, paramn, localHashMap));
        locala.d((DialogInterface.OnClickListener)new d(paramf, paramn, localHashMap));
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(locala, localJSONObject, "msgIconUrl"));
        AppMethodBeat.o(266584);
        return true;
        if (localJSONObject.has("msgIconUrl")) {
          locala.aM(Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888));
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "doConfirmDialog", new Object[0]);
      paramf.PNo.h(paramn.POu, paramn.function + ":err", (Map)localHashMap);
      AppMethodBeat.o(266584);
    }
  }
  
  public final String fCm()
  {
    return fXz;
  }
  
  public final int fCn()
  {
    return IIl;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class a
    implements DialogInterface.OnCancelListener
  {
    a(f paramf, n paramn, HashMap paramHashMap) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(175673);
      this.IIg.PNo.h(paramn.POu, paramn.function + ":cancelled", (Map)localHashMap);
      AppMethodBeat.o(175673);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class b
    implements DialogInterface.OnDismissListener
  {
    b(f paramf, n paramn, HashMap paramHashMap) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(175674);
      this.IIg.PNo.h(paramn.POu, paramn.function + ":dismiss", (Map)localHashMap);
      AppMethodBeat.o(175674);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(f paramf, n paramn, HashMap paramHashMap) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(175675);
      this.IIg.PNo.h(paramn.POu, paramn.function + ":ok", (Map)localHashMap);
      AppMethodBeat.o(175675);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(f paramf, n paramn, HashMap paramHashMap) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(175676);
      this.IIg.PNo.h(paramn.POu, paramn.function + ":no", (Map)localHashMap);
      AppMethodBeat.o(175676);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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