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
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.a.d.a;
import d.g.b.k;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiConfirmDialog;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "parseColor", "color", "plugin-webview_release"})
public final class b
  extends com.tencent.mm.plugin.webview.c.c.a
{
  private static final int CHh = 343;
  public static final b CLu;
  private static final String TAG = "MicroMsg.JsApiConfirmDialog";
  private static final String dxZ = "confirmDialog";
  
  static
  {
    AppMethodBeat.i(175678);
    CLu = new b();
    TAG = "MicroMsg.JsApiConfirmDialog";
    CHh = 343;
    dxZ = "confirmDialog";
    AppMethodBeat.o(175678);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.c.d paramd, final com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(189488);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    final HashMap localHashMap = new HashMap();
    try
    {
      Object localObject1 = new d.a(paramd.context);
      JSONObject localJSONObject = paraml.Cku;
      if (localJSONObject.has("title")) {
        ((d.a)localObject1).aRH(localJSONObject.getString("title"));
      }
      if (localJSONObject.has("titleDesc")) {
        ((d.a)localObject1).at((CharSequence)localJSONObject.getString("titleDesc"));
      }
      Object localObject2;
      if (localJSONObject.has("titleColor"))
      {
        localObject2 = localJSONObject.getString("titleColor");
        k.g(localObject2, "rawParams.getString(KEY_TITLE_COLOR)");
        ((d.a)localObject1).acG(Color.parseColor((String)localObject2) | 0xFF000000);
      }
      if (localJSONObject.has("titleMaxLine")) {
        ((d.a)localObject1).acH(localJSONObject.getInt("titleMaxLine"));
      }
      if (localJSONObject.has("titleGravity")) {
        ((d.a)localObject1).acI(localJSONObject.getInt("titleGravity"));
      }
      if (localJSONObject.has("msg")) {
        ((d.a)localObject1).aRI(localJSONObject.getString("msg"));
      }
      if (localJSONObject.has("msgSubTitle")) {
        ((d.a)localObject1).au((CharSequence)localJSONObject.getString("msgSubTitle"));
      }
      if (localJSONObject.has("msgSubDesc")) {
        ((d.a)localObject1).aRJ(localJSONObject.getString("msgSubDesc"));
      }
      if (localJSONObject.has("msgMaxLine")) {
        ((d.a)localObject1).acK(localJSONObject.getInt("msgMaxLine"));
      }
      if (localJSONObject.has("msgIconBase64"))
      {
        localObject2 = Base64.decode(localJSONObject.getString("msgIconBase64"), 0);
        ((d.a)localObject1).aH(BitmapFactory.decodeByteArray((byte[])localObject2, 0, localObject2.length));
      }
      for (;;)
      {
        if (localJSONObject.has("contentDesc")) {
          ((d.a)localObject1).aRL(localJSONObject.getString("contentDesc"));
        }
        if (localJSONObject.has("contentDescGravity")) {
          ((d.a)localObject1).acL(localJSONObject.getInt("contentDescGravity"));
        }
        if (localJSONObject.has("confirmText")) {
          ((d.a)localObject1).aRO(localJSONObject.getString("confirmText"));
        }
        if (localJSONObject.has("confirmTextColor"))
        {
          localObject2 = localJSONObject.getString("confirmTextColor");
          k.g(localObject2, "rawParams.getString(KEY_CONFIRM_COLOR)");
          ((d.a)localObject1).acO(Color.parseColor((String)localObject2) | 0xFF000000);
        }
        if (localJSONObject.has("cancelText")) {
          ((d.a)localObject1).aRP(localJSONObject.getString("cancelText"));
        }
        if (localJSONObject.has("cancelTextColor"))
        {
          localObject2 = localJSONObject.getString("cancelTextColor");
          k.g(localObject2, "rawParams.getString(KEY_CANCEL_COLOR)");
          ((d.a)localObject1).acP(Color.parseColor((String)localObject2) | 0xFF000000);
        }
        ((d.a)localObject1).e((DialogInterface.OnCancelListener)new a(paramd, paraml, localHashMap));
        ((d.a)localObject1).a((DialogInterface.OnDismissListener)new b(paramd, paraml, localHashMap));
        ((d.a)localObject1).b((DialogInterface.OnClickListener)new c(paramd, paraml, localHashMap));
        ((d.a)localObject1).c((DialogInterface.OnClickListener)new d(paramd, paraml, localHashMap));
        localObject1 = ((d.a)localObject1).fvp();
        if (localJSONObject.has("msgIconUrl"))
        {
          k.g(localObject1, "alert");
          localObject2 = ((com.tencent.mm.ui.widget.a.d)localObject1).fvo();
          com.tencent.mm.av.a.a.aFG().a(localJSONObject.getString("msgIconUrl"), (ImageView)localObject2, new c.a().aFP().aFT());
        }
        ((com.tencent.mm.ui.widget.a.d)localObject1).show();
        AppMethodBeat.o(189488);
        return true;
        if (localJSONObject.has("msgIconUrl")) {
          ((d.a)localObject1).aH(Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888));
        }
      }
      return false;
    }
    catch (JSONException localJSONException)
    {
      ac.printErrStackTrace(TAG, (Throwable)localJSONException, "doConfirmDialog", new Object[0]);
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":err", (Map)localHashMap);
      AppMethodBeat.o(189488);
    }
  }
  
  public final int ezX()
  {
    return CHh;
  }
  
  public final String ezY()
  {
    return dxZ;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class a
    implements DialogInterface.OnCancelListener
  {
    a(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml, HashMap paramHashMap) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(175673);
      this.CHk.Cjq.j(paraml.Ckt, paraml.kCH + ":cancelled", (Map)localHashMap);
      AppMethodBeat.o(175673);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class b
    implements DialogInterface.OnDismissListener
  {
    b(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml, HashMap paramHashMap) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(175674);
      this.CHk.Cjq.j(paraml.Ckt, paraml.kCH + ":dismiss", (Map)localHashMap);
      AppMethodBeat.o(175674);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml, HashMap paramHashMap) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(175675);
      this.CHk.Cjq.j(paraml.Ckt, paraml.kCH + ":ok", (Map)localHashMap);
      AppMethodBeat.o(175675);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml, HashMap paramHashMap) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(175676);
      this.CHk.Cjq.j(paraml.Ckt, paraml.kCH + ":no", (Map)localHashMap);
      AppMethodBeat.o(175676);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.b
 * JD-Core Version:    0.7.0.1
 */