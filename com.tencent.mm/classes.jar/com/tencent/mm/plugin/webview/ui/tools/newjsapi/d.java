package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiConfirmDialog;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "parseColor", "color", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.webview.jsapi.c.a
{
  private static final int OOk;
  private static final String TAG;
  public static final d XmM;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(175678);
    XmM = new d();
    TAG = "MicroMsg.JsApiConfirmDialog";
    OOk = 343;
    idA = "confirmDialog";
    AppMethodBeat.o(175678);
  }
  
  private static final void a(h paramh, p paramp, HashMap paramHashMap, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(297875);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    s.u(paramHashMap, "$retValue");
    paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":cancelled"), (Map)paramHashMap);
    AppMethodBeat.o(297875);
  }
  
  private static final void a(h paramh, p paramp, HashMap paramHashMap, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(297892);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    s.u(paramHashMap, "$retValue");
    paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), (Map)paramHashMap);
    AppMethodBeat.o(297892);
  }
  
  private static final void b(h paramh, p paramp, HashMap paramHashMap, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(297885);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    s.u(paramHashMap, "$retValue");
    paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":dismiss"), (Map)paramHashMap);
    AppMethodBeat.o(297885);
  }
  
  private static final void b(h paramh, p paramp, HashMap paramHashMap, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(297902);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    s.u(paramHashMap, "$retValue");
    paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":no"), (Map)paramHashMap);
    AppMethodBeat.o(297902);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297943);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    HashMap localHashMap = new HashMap();
    try
    {
      e.a locala = new e.a(paramh.context);
      final JSONObject localJSONObject = paramp.WEI;
      if (localJSONObject.has("title")) {
        locala.bDv(localJSONObject.getString("title"));
      }
      if (localJSONObject.has("titleDesc")) {
        locala.bd((CharSequence)localJSONObject.getString("titleDesc"));
      }
      Object localObject;
      if (localJSONObject.has("titleColor"))
      {
        localObject = localJSONObject.getString("titleColor");
        s.s(localObject, "rawParams.getString(KEY_TITLE_COLOR)");
        locala.aEL(Color.parseColor((String)localObject) | 0xFF000000);
      }
      if (localJSONObject.has("titleMaxLine")) {
        locala.aEM(localJSONObject.getInt("titleMaxLine"));
      }
      if (localJSONObject.has("titleGravity")) {
        locala.aEN(localJSONObject.getInt("titleGravity"));
      }
      if (localJSONObject.has("msg")) {
        locala.bDw(localJSONObject.getString("msg"));
      }
      if (localJSONObject.has("msgSubTitle")) {
        locala.be((CharSequence)localJSONObject.getString("msgSubTitle"));
      }
      if (localJSONObject.has("msgSubDesc")) {
        locala.bDx(localJSONObject.getString("msgSubDesc"));
      }
      if (localJSONObject.has("msgMaxLine")) {
        locala.aEP(localJSONObject.getInt("msgMaxLine"));
      }
      if (localJSONObject.has("msgIconBase64"))
      {
        localObject = Base64.decode(localJSONObject.getString("msgIconBase64"), 0);
        locala.bg(BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
      }
      for (;;)
      {
        if (localJSONObject.has("contentDesc")) {
          locala.bDz(localJSONObject.getString("contentDesc"));
        }
        if (localJSONObject.has("contentDescGravity")) {
          locala.aEQ(localJSONObject.getInt("contentDescGravity"));
        }
        if (localJSONObject.has("confirmText")) {
          locala.bDC(localJSONObject.getString("confirmText"));
        }
        if (localJSONObject.has("confirmTextColor"))
        {
          localObject = localJSONObject.getString("confirmTextColor");
          s.s(localObject, "rawParams.getString(KEY_CONFIRM_COLOR)");
          locala.aET(Color.parseColor((String)localObject) | 0xFF000000);
        }
        if (localJSONObject.has("cancelText")) {
          locala.bDD(localJSONObject.getString("cancelText"));
        }
        if (localJSONObject.has("cancelTextColor"))
        {
          localObject = localJSONObject.getString("cancelTextColor");
          s.s(localObject, "rawParams.getString(KEY_CANCEL_COLOR)");
          locala.aEU(Color.parseColor((String)localObject) | 0xFF000000);
        }
        locala.e(new d..ExternalSyntheticLambda0(paramh, paramp, localHashMap));
        locala.c(new d..ExternalSyntheticLambda3(paramh, paramp, localHashMap));
        locala.c(new d..ExternalSyntheticLambda1(paramh, paramp, localHashMap));
        locala.d(new d..ExternalSyntheticLambda2(paramh, paramp, localHashMap));
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(locala, localJSONObject, "msgIconUrl"));
        AppMethodBeat.o(297943);
        return true;
        if (localJSONObject.has("msgIconUrl")) {
          locala.bg(Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888));
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "doConfirmDialog", new Object[0]);
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":err"), (Map)localHashMap);
      AppMethodBeat.o(297943);
    }
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(e.a parama, JSONObject paramJSONObject, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.d
 * JD-Core Version:    0.7.0.1
 */