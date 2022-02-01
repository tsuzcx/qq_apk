package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetLocalImgData;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends a
{
  private static final int OOk;
  public static final l Xnd;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297772);
    Xnd = new l();
    OOk = 249;
    idA = "getLocalImgData";
    AppMethodBeat.o(297772);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297790);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Object localObject1 = (String)paramp.params.get("localId");
    float f = Util.getFloat((String)paramp.params.get("compressionRatio"), 0.0F);
    if (Util.isNullOrNil((String)localObject1))
    {
      paramh.WDy.doCallback(paramp.WEH, "getLocalImgData:fail_invaild_localid", null);
      AppMethodBeat.o(297790);
      return false;
    }
    for (;;)
    {
      try
      {
        Object localObject2 = paramh.sLC;
        if (localObject2 == null)
        {
          localObject1 = null;
          if (localObject1 == null) {
            continue;
          }
          localObject1 = BitmapUtil.decodeFile((String)localObject1);
          if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
            continue;
          }
          localObject2 = new ByteArrayOutputStream();
          double d = f;
          if (0.1D > d) {
            continue;
          }
          if (d <= 0.99D)
          {
            i = 1;
            break label383;
            ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, i, (OutputStream)localObject2);
            Object localObject3 = ((ByteArrayOutputStream)localObject2).toByteArray();
            localObject2 = Base64.encodeToString((byte[])localObject3, 2);
            Log.i("MicroMsg.JsApiGetLocalImgData", s.X("rawData lenght = %d, base64 lenght = %d compressionRatio=", Float.valueOf(f)), new Object[] { Integer.valueOf(localObject3.length), Integer.valueOf(((String)localObject2).length()) });
            localObject3 = new HashMap();
            Map localMap = (Map)localObject3;
            s.s(localObject2, "base64Content");
            localMap.put("localData", localObject2);
            paramh.WDy.doCallback(paramp.WEH, "getLocalImgData:ok", (Map)localObject3);
            Log.i("MicroMsg.JsApiGetLocalImgData", "bitmap recycle %s", new Object[] { ((Bitmap)localObject1).toString() });
            ((Bitmap)localObject1).recycle();
            AppMethodBeat.o(297790);
            return true;
          }
        }
        else
        {
          localObject1 = ((com.tencent.mm.plugin.webview.stub.e)localObject2).ic((String)localObject1, 2);
          continue;
        }
        i = 0;
        break label383;
        i = 0;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.JsApiGetLocalImgData", localException.getMessage());
        paramh.WDy.doCallback(paramp.WEH, "getLocalImgData:fail", null);
        AppMethodBeat.o(297790);
        return false;
      }
      label383:
      while (i == 0)
      {
        i = 90;
        break;
      }
      int i = (int)(100.0F * f);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.l
 * JD-Core Version:    0.7.0.1
 */