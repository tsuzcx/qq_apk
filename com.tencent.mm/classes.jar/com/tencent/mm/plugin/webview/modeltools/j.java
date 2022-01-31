package com.tencent.mm.plugin.webview.modeltools;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.l.b;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;

public final class j
{
  private static long uYp;
  private static int uYq;
  private static int uYr;
  private static boolean uYs;
  private static Map<String, String> uYt;
  
  static
  {
    AppMethodBeat.i(153162);
    uYp = 0L;
    uYq = -1;
    uYr = -1;
    uYs = false;
    uYt = new HashMap();
    AppMethodBeat.o(153162);
  }
  
  public static void a(Bundle paramBundle, com.tencent.mm.plugin.webview.stub.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(7023);
    if (System.currentTimeMillis() - uYp < 1000L)
    {
      AppMethodBeat.o(7023);
      return;
    }
    String str1 = paramBundle.getString("url");
    localObject1 = paramBundle.getString("filePath");
    Object localObject3 = new String[1];
    Object localObject2;
    if (!bo.isNullOrNil((String)localObject1))
    {
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      localObject2 = com.tencent.mm.sdk.platformtools.d.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
      if (localObject2 != null)
      {
        ab.i("MicroMsg.WebViewPreviewImgHelper", "recycle bitmap:%s", new Object[] { localObject2.toString() });
        ((Bitmap)localObject2).recycle();
        localObject3[0] = localObject1;
      }
    }
    while ((bo.isNullOrNil((String)localObject1)) && (!bo.isNullOrNil(str1)))
    {
      localObject3[0] = str1;
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("nowUrl", str1);
      ((Intent)localObject2).putExtra("urlList", (String[])localObject3);
      ((Intent)localObject2).putExtra("type", -255);
      ((Intent)localObject2).putExtra("isFromWebView", true);
      ((Intent)localObject2).putExtra("isOuntLink", true);
      str1 = "";
      localObject1 = str1;
      for (;;)
      {
        try
        {
          localObject3 = parame.i(90001, new Bundle());
          if (localObject3 != null)
          {
            localObject1 = str1;
            localObject3 = ((Bundle)localObject3).getString("cookie", null);
            localObject1 = str1;
            if (!bo.isNullOrNil((String)localObject3))
            {
              localObject1 = str1;
              ((Intent)localObject2).putExtra("cookie", (String)localObject3);
            }
          }
          localObject1 = str1;
          Object localObject4 = parame.i(18, null);
          if (localObject4 == null) {
            continue;
          }
          localObject1 = str1;
          localObject3 = ((Bundle)localObject4).getString("preChatName");
          localObject1 = str1;
          String str2 = ((Bundle)localObject4).getString("preUsername");
          localObject1 = str1;
          String str3 = ((Bundle)localObject4).getString("rawUrl");
          localObject1 = str1;
          parame = ((Bundle)localObject4).getString("url");
          localObject1 = parame;
          i = ((Bundle)localObject4).getInt("getA8KeyScene");
          localObject1 = parame;
          str1 = v.oQ("ImgPreview");
          localObject1 = parame;
          localObject4 = v.aae().z(str1, true);
          localObject1 = parame;
          ((v.b)localObject4).i("preUsername", localObject3);
          localObject1 = parame;
          ((v.b)localObject4).i("preChatName", str2);
          localObject1 = parame;
          ((v.b)localObject4).i("url", parame);
          localObject1 = parame;
          ((v.b)localObject4).i("rawUrl", str3);
          if ((i != 53) && (i != 52)) {
            continue;
          }
          localObject1 = parame;
          ab.i("MicroMsg.WebViewPreviewImgHelper", "not allow to ScanQRCode");
          bool = false;
        }
        catch (Exception localException1)
        {
          int i;
          int n;
          boolean bool = true;
          parame = (com.tencent.mm.plugin.webview.stub.e)localObject1;
          ab.e("MicroMsg.WebViewPreviewImgHelper", "getCookie fail : %s", new Object[] { localException1.getMessage() });
          continue;
          i += n;
          continue;
          bool = true;
          continue;
          bool = true;
          parame = localException2;
          continue;
        }
        try
        {
          ((Intent)localObject2).putExtra("img_gallery_session_id", str1);
          ((Intent)localObject2).putExtra("shouldShowScanQrCodeMenu", bool);
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("stat_scene", 4);
          ((Bundle)localObject1).putString("stat_url", parame);
          ((Intent)localObject2).putExtra("_stat_obj", (Bundle)localObject1);
          parame = ah.getContext();
          if (dcL())
          {
            i = am.di(parame);
            n = am.hY(parame);
            int j = (int)paramBundle.getFloat("width");
            int k = (int)paramBundle.getFloat("height");
            int m = (int)paramBundle.getFloat("left");
            float f = paramBundle.getFloat("top");
            if (!paramBoolean) {
              continue;
            }
            i = 0;
            i = (int)(i + f);
            n = com.tencent.mm.cb.a.gx(parame);
            ab.d("MicroMsg.WebViewPreviewImgHelper", "doPreviewImg left %d, top %d, w %d, h %d", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
            ((Intent)localObject2).putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", m).putExtra("img_gallery_top", i);
            if ((j > 0) && (k > 0) && (k < n)) {
              ((Intent)localObject2).putExtra("shouldRunDragAnimation", true);
            }
          }
          com.tencent.mm.bq.d.b(ah.getContext(), "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject2);
          AppMethodBeat.o(7023);
          return;
        }
        catch (Exception localException2) {}
      }
      ab.i("MicroMsg.WebViewPreviewImgHelper", "decode fail %s", new Object[] { localObject1 });
      localObject1 = "";
    }
    ab.w("MicroMsg.WebViewPreviewImgHelper", "imagePreview failed url is null");
    AppMethodBeat.o(7023);
  }
  
  public static void a(Map<String, Object> paramMap, MMWebView paramMMWebView)
  {
    AppMethodBeat.i(153159);
    if ((paramMMWebView == null) || (paramMap == null))
    {
      AppMethodBeat.o(153159);
      return;
    }
    if (uYr == -1)
    {
      uYr = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUu, 1);
      ab.i("MicroMsg.WebViewPreviewImgHelper", "openXWebUrlToPath %d", new Object[] { Integer.valueOf(uYr) });
    }
    if (uYr == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(153159);
      return;
    }
    paramMap = (String)paramMap.get("current");
    if (bo.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(153159);
      return;
    }
    ab.d("MicroMsg.WebViewPreviewImgHelper", "start getImageBitmapToFile");
    String str = b.Uq() + "/reader_" + com.tencent.mm.a.g.w(paramMap.getBytes()) + ".jpg";
    if (com.tencent.mm.vfs.e.cN(str))
    {
      ab.i("MicroMsg.WebViewPreviewImgHelper", "getImageBitmapToFile savePath exist");
      uYt.put(paramMap, str);
      uYs = true;
      AppMethodBeat.o(153159);
      return;
    }
    uYs = paramMMWebView.getImageBitmapToFile(paramMap, str, "", new j.1(paramMap));
    AppMethodBeat.o(153159);
  }
  
  public static String ahC(String paramString)
  {
    AppMethodBeat.i(153160);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(153160);
      return null;
    }
    if (!uYs)
    {
      AppMethodBeat.o(153160);
      return null;
    }
    paramString = (String)uYt.get(paramString);
    if (!bo.isNullOrNil(paramString)) {
      h.qsU.idkeyStat(1059L, 2L, 1L, false);
    }
    for (;;)
    {
      AppMethodBeat.o(153160);
      return paramString;
      h.qsU.idkeyStat(1059L, 5L, 1L, false);
    }
  }
  
  public static String d(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(153161);
    if ((bo.isNullOrNil(paramString2)) || (!com.tencent.mm.vfs.e.cN(paramString2)))
    {
      ab.i("MicroMsg.WebViewPreviewImgHelper", "replaceCurrentPath path is null");
      AppMethodBeat.o(153161);
      return paramString1;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString2, localOptions);
    if ((localOptions.outWidth <= 1) || (localOptions.outHeight <= 1))
    {
      ab.i("MicroMsg.WebViewPreviewImgHelper", "replaceCurrentPath file path invalid: %s", new Object[] { paramString2 });
      h.qsU.idkeyStat(1059L, 4L, 1L, false);
      AppMethodBeat.o(153161);
      return paramString1;
    }
    h.qsU.idkeyStat(1059L, 3L, 1L, false);
    int i = 0;
    for (;;)
    {
      if (i < paramArrayOfString.length)
      {
        if (paramString1.equals(paramArrayOfString[i])) {
          paramArrayOfString[i] = paramString2;
        }
      }
      else
      {
        ab.i("MicroMsg.WebViewPreviewImgHelper", "replaceCurrentPath path: %s", new Object[] { paramString2 });
        AppMethodBeat.o(153161);
        return paramString2;
      }
      i += 1;
    }
  }
  
  public static void d(com.tencent.mm.plugin.webview.stub.d paramd)
  {
    AppMethodBeat.i(7024);
    if (paramd == null)
    {
      AppMethodBeat.o(7024);
      return;
    }
    try
    {
      paramd.i(108, new Bundle());
      AppMethodBeat.o(7024);
      return;
    }
    catch (RemoteException paramd)
    {
      AppMethodBeat.o(7024);
    }
  }
  
  public static void dcK()
  {
    AppMethodBeat.i(7022);
    uYp = System.currentTimeMillis();
    AppMethodBeat.o(7022);
  }
  
  public static boolean dcL()
  {
    AppMethodBeat.i(7025);
    if (uYq == -1)
    {
      uYq = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUp, 1);
      ab.i("MicroMsg.WebViewPreviewImgHelper", "shouldShowAnimation %d", new Object[] { Integer.valueOf(uYq) });
    }
    if (uYq == 1)
    {
      AppMethodBeat.o(7025);
      return true;
    }
    AppMethodBeat.o(7025);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.j
 * JD-Core Version:    0.7.0.1
 */