package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

final class al$1
  implements g.a
{
  al$1(al paramal) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(6699);
    Object localObject1;
    Object localObject2;
    if (paramc == null)
    {
      localObject1 = "null";
      if (paramd != null) {
        break label114;
      }
      localObject2 = "null";
      label23:
      ab.i("MicroMsg.WebviewFileChooserCdnService", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramString, Integer.valueOf(paramInt), localObject1, localObject2 });
      localObject1 = com.tencent.mm.plugin.webview.modeltools.g.dcE();
      if (!bo.isNullOrNil(paramString)) {
        break label124;
      }
      ab.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByMediaID error, media id is null or nil");
      label73:
      break label139;
      label74:
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label179;
      }
      ab.e("MicroMsg.WebviewFileChooserCdnService", "get item by media id failed, media is : %s", new Object[] { paramString });
      AppMethodBeat.o(6699);
      return 0;
      localObject1 = paramc.toString();
      break;
      label114:
      localObject2 = paramd.toString();
      break label23;
      label124:
      localObject2 = ((am)localObject1).uWk.values().iterator();
      label139:
      if (!((Iterator)localObject2).hasNext()) {
        break label74;
      }
      localObject1 = (WebViewJSSDKFileItem)((Iterator)localObject2).next();
      if (!bo.nullAsNil(((WebViewJSSDKFileItem)localObject1).cBO).equals(paramString)) {
        break label73;
      }
    }
    label179:
    if (paramInt == -21005)
    {
      ab.i("MicroMsg.WebviewFileChooserCdnService", "duplicate request, ignore this request, media id is %s", new Object[] { paramString });
      AppMethodBeat.o(6699);
      return 0;
    }
    if (paramInt != 0)
    {
      ab.e("MicroMsg.WebviewFileChooserCdnService", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
      al.a(this.uWh, false, paramInt, ((WebViewJSSDKFileItem)localObject1).ctV, ((WebViewJSSDKFileItem)localObject1).cBO, null, null);
      AppMethodBeat.o(6699);
      return 0;
    }
    if (paramc != null)
    {
      ab.i("MicroMsg.WebviewFileChooserCdnService", "progressInfo : %s", new Object[] { paramc.toString() });
      paramInt = 0;
      if (paramc.field_toltalLength > 0) {
        paramInt = (int)(paramc.field_finishedLength * 100L / paramc.field_toltalLength);
      }
      int i;
      if (paramInt < 0) {
        i = 0;
      }
      for (;;)
      {
        ab.d("MicroMsg.WebviewFileChooserCdnService", "progressInfo, percent = %d, finishLen = %d, totalLen = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramc.field_finishedLength), Integer.valueOf(paramc.field_toltalLength) });
        this.uWh.b(((WebViewJSSDKFileItem)localObject1).hgm, ((WebViewJSSDKFileItem)localObject1).cth, i, ((WebViewJSSDKFileItem)localObject1).ctV, ((WebViewJSSDKFileItem)localObject1).cBO);
        AppMethodBeat.o(6699);
        return 0;
        i = paramInt;
        if (paramInt > 100) {
          i = 100;
        }
      }
    }
    if (paramd != null)
    {
      if (paramd.field_retCode == 0) {
        break label488;
      }
      ab.e("MicroMsg.WebviewFileChooserCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramString, Integer.valueOf(paramd.field_retCode), paramd });
      al.a(this.uWh, false, paramd.field_retCode, ((WebViewJSSDKFileItem)localObject1).ctV, ((WebViewJSSDKFileItem)localObject1).cBO, null, null);
    }
    for (;;)
    {
      AppMethodBeat.o(6699);
      return 0;
      label488:
      ab.i("MicroMsg.WebviewFileChooserCdnService", "cdn trans suceess, media id : %s, item.mediaId : %s, item.localId: %s", new Object[] { paramString, ((WebViewJSSDKFileItem)localObject1).cBO, ((WebViewJSSDKFileItem)localObject1).ctV });
      if (localObject1 != null)
      {
        ((WebViewJSSDKFileItem)localObject1).c(paramd);
        if ((((WebViewJSSDKFileItem)localObject1).hgm) && (((WebViewJSSDKFileItem)localObject1).hgo))
        {
          paramString = this.uWh;
          if (localObject1 == null)
          {
            ab.e("MicroMsg.WebviewFileChooserCdnService", "uploadCdnInfo failed, item is null");
          }
          else
          {
            paramc = new bbf();
            paramc.xbD = ((WebViewJSSDKFileItem)localObject1).uWl.field_aesKey;
            paramc.wJh = ((WebViewJSSDKFileItem)localObject1).uWl.field_fileLength;
            paramc.xqE = ((WebViewJSSDKFileItem)localObject1).uWl.field_fileId;
            paramc.type = ((WebViewJSSDKFileItem)localObject1).dzk();
            ab.d("MicroMsg.WebviewFileChooserCdnService", "appId:%s, localId:%s, aes_key:%s， file_size:%d, fileId:%s", new Object[] { ((WebViewJSSDKFileItem)localObject1).appId, ((WebViewJSSDKFileItem)localObject1).ctV, paramc.xbD, Integer.valueOf(paramc.wJh), paramc.xqE });
            paramc.xqF = ((WebViewJSSDKFileItem)localObject1).dyR();
            com.tencent.mm.kernel.g.Rc().a(1034, paramString);
            paramString = new af(((WebViewJSSDKFileItem)localObject1).appId, ((WebViewJSSDKFileItem)localObject1).ctV, paramc);
            com.tencent.mm.kernel.g.Rc().a(paramString, 0);
          }
        }
        else
        {
          al.a(this.uWh, true, 0, ((WebViewJSSDKFileItem)localObject1).ctV, ((WebViewJSSDKFileItem)localObject1).hgk, ((WebViewJSSDKFileItem)localObject1).uWl.field_fileUrl, paramd.field_thumbUrl);
        }
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(6697);
    ab.i("MicroMsg.WebviewFileChooserCdnService", "getCdnAuthInfo, mediaId = %s", new Object[] { paramString });
    AppMethodBeat.o(6697);
  }
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6698);
    ab.i("MicroMsg.WebviewFileChooserCdnService", "decodePrepareResponse, mediaId = %s", new Object[] { paramString });
    AppMethodBeat.o(6698);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.al.1
 * JD-Core Version:    0.7.0.1
 */