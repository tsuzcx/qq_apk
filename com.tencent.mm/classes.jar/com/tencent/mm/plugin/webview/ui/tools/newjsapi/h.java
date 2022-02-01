package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetLocalImgData;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class h
  extends a
{
  private static final int ECX = 249;
  public static final h EHC;
  private static final String dLB = "getLocalImgData";
  
  static
  {
    AppMethodBeat.i(199400);
    EHC = new h();
    ECX = 249;
    dLB = "getLocalImgData";
    AppMethodBeat.o(199400);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(199399);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    Object localObject1 = (String)paraml.xqN.get("localId");
    if (bu.isNullOrNil((String)localObject1))
    {
      paramd.DQe.i(paraml.Efy, "getLocalImgData:fail_invaild_localid", null);
      AppMethodBeat.o(199399);
      return false;
    }
    try
    {
      Object localObject2 = paramd.lzT;
      if (localObject2 != null) {}
      for (localObject1 = ((e)localObject2).fX((String)localObject1, 2); localObject1 != null; localObject1 = null)
      {
        localObject1 = com.tencent.mm.sdk.platformtools.h.decodeFile((String)localObject1);
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break;
        }
        localObject2 = new ByteArrayOutputStream();
        ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream)localObject2);
        Object localObject3 = ((ByteArrayOutputStream)localObject2).toByteArray();
        localObject2 = Base64.encodeToString((byte[])localObject3, 0);
        ae.i("MicroMsg.JsApiGetLocalImgData", "rawData lenght = %d, base64 lenght = %d", new Object[] { Integer.valueOf(localObject3.length), Integer.valueOf(((String)localObject2).length()) });
        localObject3 = new HashMap();
        Map localMap = (Map)localObject3;
        p.g(localObject2, "base64Content");
        localMap.put("localData", localObject2);
        paramd.DQe.i(paraml.Efy, "getLocalImgData:ok", (Map)localObject3);
        ae.i("MicroMsg.JsApiGetLocalImgData", "bitmap recycle %s", new Object[] { ((Bitmap)localObject1).toString() });
        ((Bitmap)localObject1).recycle();
        AppMethodBeat.o(199399);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.JsApiGetLocalImgData", localException.getMessage());
      paramd.DQe.i(paraml.Efy, "getLocalImgData:fail", null);
      AppMethodBeat.o(199399);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.h
 * JD-Core Version:    0.7.0.1
 */