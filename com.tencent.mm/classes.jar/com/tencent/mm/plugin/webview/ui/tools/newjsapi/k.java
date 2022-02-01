package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetLocalImgData;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class k
  extends a
{
  private static final int IIl = 249;
  public static final k Qvd;
  private static final String fXz = "getLocalImgData";
  
  static
  {
    AppMethodBeat.i(264722);
    Qvd = new k();
    IIl = 249;
    fXz = "getLocalImgData";
    AppMethodBeat.o(264722);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(264721);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Object localObject1 = (String)paramn.params.get("localId");
    float f = Util.getFloat((String)paramn.params.get("compressionRatio"), 0.0F);
    if (Util.isNullOrNil((String)localObject1))
    {
      paramf.PNo.h(paramn.POu, "getLocalImgData:fail_invaild_localid", null);
      AppMethodBeat.o(264721);
      return false;
    }
    label360:
    for (;;)
    {
      try
      {
        Object localObject2 = paramf.pGC;
        if (localObject2 != null)
        {
          localObject1 = ((e)localObject2).hc((String)localObject1, 2);
          if (localObject1 != null)
          {
            localObject1 = BitmapUtil.decodeFile((String)localObject1);
            if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
            {
              localObject2 = new ByteArrayOutputStream();
              double d = f;
              if ((d < 0.1D) || (d > 0.99D)) {
                break label360;
              }
              i = (int)(100.0F * f);
              ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, i, (OutputStream)localObject2);
              Object localObject3 = ((ByteArrayOutputStream)localObject2).toByteArray();
              localObject2 = Base64.encodeToString((byte[])localObject3, 0);
              Log.i("MicroMsg.JsApiGetLocalImgData", "rawData lenght = %d, base64 lenght = %d compressionRatio=".concat(String.valueOf(f)), new Object[] { Integer.valueOf(localObject3.length), Integer.valueOf(((String)localObject2).length()) });
              localObject3 = new HashMap();
              Map localMap = (Map)localObject3;
              p.j(localObject2, "base64Content");
              localMap.put("localData", localObject2);
              paramf.PNo.h(paramn.POu, "getLocalImgData:ok", (Map)localObject3);
              Log.i("MicroMsg.JsApiGetLocalImgData", "bitmap recycle %s", new Object[] { ((Bitmap)localObject1).toString() });
              ((Bitmap)localObject1).recycle();
              AppMethodBeat.o(264721);
              return true;
            }
          }
        }
        else
        {
          localObject1 = null;
          continue;
        }
        int i = 90;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.JsApiGetLocalImgData", localException.getMessage());
        paramf.PNo.h(paramn.POu, "getLocalImgData:fail", null);
        AppMethodBeat.o(264721);
        return false;
      }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.k
 * JD-Core Version:    0.7.0.1
 */