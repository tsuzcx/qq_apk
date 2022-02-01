package com.tencent.mm.plugin.webview.modeltools;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cs;
import com.tencent.mm.b.g;
import com.tencent.mm.cd.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.loader.k.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.ao;
import java.util.HashMap;
import java.util.Map;

public final class k
{
  private static long WOv;
  private static int WOw;
  private static int WOx;
  private static boolean WOy;
  private static Map<String, String> WOz;
  
  static
  {
    AppMethodBeat.i(79211);
    WOv = 0L;
    WOw = -1;
    WOx = -1;
    WOy = false;
    WOz = new HashMap();
    AppMethodBeat.o(79211);
  }
  
  public static void a(Bundle paramBundle1, MMWebView paramMMWebView, Bundle paramBundle2, boolean paramBoolean)
  {
    AppMethodBeat.i(182699);
    if (System.currentTimeMillis() - WOv < 1000L)
    {
      AppMethodBeat.o(182699);
      return;
    }
    String str1 = paramBundle1.getString("url");
    Object localObject1 = paramBundle1.getString("filePath");
    Object localObject2 = new String[1];
    Object localObject3;
    boolean bool3;
    boolean bool4;
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject3 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
      localObject3 = BitmapUtil.decodeFile((String)localObject1, (BitmapFactory.Options)localObject3);
      if (localObject3 != null)
      {
        Log.i("MicroMsg.WebViewPreviewImgHelper", "recycle bitmap:%s", new Object[] { localObject3.toString() });
        ((Bitmap)localObject3).recycle();
        localObject2[0] = localObject1;
        if ((!Util.isNullOrNil((String)localObject1)) || (Util.isNullOrNil(str1))) {
          break label931;
        }
        localObject2[0] = str1;
        localObject3 = new Intent();
        ((Intent)localObject3).putExtra("nowUrl", str1);
        ((Intent)localObject3).putExtra("urlList", (String[])localObject2);
        ((Intent)localObject3).putExtra("type", -255);
        ((Intent)localObject3).putExtra("isFromWebView", true);
        ((Intent)localObject3).putExtra("isOuntLink", true);
        bool1 = true;
        bool3 = true;
        bool4 = true;
        localObject2 = "";
        bool2 = bool3;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject4 = paramMMWebView.getUrl();
        bool2 = bool3;
        localObject1 = localObject2;
        String str2 = ao.getCookie((String)localObject4);
        bool2 = bool3;
        localObject1 = localObject2;
        Log.i("MicroMsg.WebViewPreviewImgHelper", "url = %s, cookie = %s", new Object[] { localObject4, str2 });
        bool2 = bool3;
        localObject1 = localObject2;
        localObject4 = new Bundle();
        bool2 = bool3;
        localObject1 = localObject2;
        ((Bundle)localObject4).putString("cookie", str2);
        if (paramMMWebView == null) {
          continue;
        }
        bool2 = bool3;
        localObject1 = localObject2;
        f = paramMMWebView.getMMDensity();
        bool2 = bool3;
        localObject1 = localObject2;
        ((Bundle)localObject4).putFloat("density", f);
        bool2 = bool3;
        localObject1 = localObject2;
        paramMMWebView = ((Bundle)localObject4).getString("cookie", null);
        bool2 = bool3;
        localObject1 = localObject2;
        if (!Util.isNullOrNil(paramMMWebView))
        {
          bool2 = bool3;
          localObject1 = localObject2;
          ((Intent)localObject3).putExtra("cookie", paramMMWebView);
        }
        localObject1 = localObject2;
        if (paramBundle2 != null)
        {
          bool2 = bool3;
          localObject1 = localObject2;
          str2 = paramBundle2.getString("preChatName");
          bool2 = bool3;
          localObject1 = localObject2;
          localObject4 = paramBundle2.getString("preUsername");
          bool2 = bool3;
          localObject1 = localObject2;
          String str3 = paramBundle2.getString("rawUrl");
          bool2 = bool3;
          localObject1 = localObject2;
          paramMMWebView = paramBundle2.getString("url");
          bool2 = bool3;
          localObject1 = paramMMWebView;
          i = paramBundle2.getInt("getA8KeyScene");
          bool2 = bool3;
          localObject1 = paramMMWebView;
          paramBundle2 = ad.Jo("ImgPreview");
          bool2 = bool3;
          localObject1 = paramMMWebView;
          localObject2 = ad.bCb().M(paramBundle2, true);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((ad.b)localObject2).q("preUsername", str2);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((ad.b)localObject2).q("preChatName", localObject4);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((ad.b)localObject2).q("url", paramMMWebView);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((ad.b)localObject2).q("Contact_Sub_Scene", Integer.valueOf(6));
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((ad.b)localObject2).q("Contact_Scene_Note", str1);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((ad.b)localObject2).q("rawUrl", str3);
          if (i != 53)
          {
            bool1 = bool4;
            if (i != 52) {}
          }
          else
          {
            bool2 = bool3;
            localObject1 = paramMMWebView;
            Log.i("MicroMsg.WebViewPreviewImgHelper", "not allow to ScanQRCode");
            bool1 = false;
          }
          bool2 = bool1;
          localObject1 = paramMMWebView;
          ((Intent)localObject3).putExtra("img_gallery_session_id", paramBundle2);
          localObject1 = paramMMWebView;
        }
      }
      catch (Exception paramMMWebView)
      {
        float f;
        int i;
        int n;
        int j;
        int k;
        int m;
        label931:
        Log.e("MicroMsg.WebViewPreviewImgHelper", "getCookie fail : %s", new Object[] { paramMMWebView.getMessage() });
        bool1 = bool2;
        continue;
        i += n;
        continue;
      }
      ((Intent)localObject3).putExtra("shouldShowScanQrCodeMenu", bool1);
      paramMMWebView = new Bundle();
      paramMMWebView.putInt("stat_scene", 4);
      paramMMWebView.putString("stat_url", (String)localObject1);
      ((Intent)localObject3).putExtra("_stat_obj", paramMMWebView);
      paramMMWebView = MMApplicationContext.getContext();
      if (iwh())
      {
        i = bf.fs(paramMMWebView);
        n = bf.be(paramMMWebView);
        j = (int)paramBundle1.getFloat("width");
        k = (int)paramBundle1.getFloat("height");
        m = (int)paramBundle1.getFloat("left");
        f = paramBundle1.getFloat("top");
        if (!paramBoolean) {
          continue;
        }
        i = 0;
        i = (int)(i + f);
        n = a.mt(paramMMWebView);
        Log.d("MicroMsg.WebViewPreviewImgHelper", "doPreviewImg left %d, top %d, w %d, h %d", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        ((Intent)localObject3).putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", m).putExtra("img_gallery_top", i);
        if ((j > 0) && (k > 0) && (k < n)) {
          ((Intent)localObject3).putExtra("shouldRunDragAnimation", true);
        }
      }
      com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject3);
      AppMethodBeat.o(182699);
      return;
      Log.i("MicroMsg.WebViewPreviewImgHelper", "decode fail %s", new Object[] { localObject1 });
      localObject1 = "";
      break;
      Log.w("MicroMsg.WebViewPreviewImgHelper", "imagePreview failed url is null");
      AppMethodBeat.o(182699);
      return;
      bool2 = bool3;
      localObject1 = localObject2;
      f = com.tencent.mm.ce.c.iRA();
    }
  }
  
  public static void a(Map<String, Object> paramMap, MMWebView paramMMWebView)
  {
    AppMethodBeat.i(79208);
    if ((paramMMWebView == null) || (paramMap == null))
    {
      AppMethodBeat.o(79208);
      return;
    }
    if (WOx == -1)
    {
      WOx = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yMV, 1);
      Log.i("MicroMsg.WebViewPreviewImgHelper", "openXWebUrlToPath %d", new Object[] { Integer.valueOf(WOx) });
    }
    if (WOx == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(79208);
      return;
    }
    paramMap = (String)paramMap.get("current");
    if (Util.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(79208);
      return;
    }
    Log.d("MicroMsg.WebViewPreviewImgHelper", "start getImageBitmapToFile");
    String str = b.bnI() + "/reader_" + g.getMessageDigest(paramMap.getBytes()) + ".jpg";
    if (y.ZC(str))
    {
      Log.i("MicroMsg.WebViewPreviewImgHelper", "getImageBitmapToFile savePath exist");
      WOz.put(paramMap, str);
      WOy = true;
      AppMethodBeat.o(79208);
      return;
    }
    WOy = paramMMWebView.getImageBitmapToFile(paramMap, str, "", new com.tencent.xweb.k()
    {
      public final void dK(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(79203);
        Log.i("MicroMsg.WebViewPreviewImgHelper", "onFinishImageBitmapToFile result %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        com.tencent.mm.plugin.report.service.h localh;
        if (k.WOy)
        {
          localh = com.tencent.mm.plugin.report.service.h.OAn;
          if (paramAnonymousInt != 0) {
            break label61;
          }
        }
        label61:
        for (long l = 0L;; l = 1L)
        {
          localh.idkeyStat(1059L, l, 1L, false);
          if (paramAnonymousInt == 0) {
            break;
          }
          AppMethodBeat.o(79203);
          return;
        }
        k.aCw().put(k.this, paramAnonymousString);
        AppMethodBeat.o(79203);
      }
    });
    AppMethodBeat.o(79208);
  }
  
  public static String bkR(String paramString)
  {
    AppMethodBeat.i(79209);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79209);
      return null;
    }
    if (!WOy)
    {
      AppMethodBeat.o(79209);
      return null;
    }
    paramString = (String)WOz.get(paramString);
    if (!Util.isNullOrNil(paramString)) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1059L, 2L, 1L, false);
    }
    for (;;)
    {
      AppMethodBeat.o(79209);
      return paramString;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1059L, 5L, 1L, false);
    }
  }
  
  public static boolean bkS(String paramString)
  {
    AppMethodBeat.i(79210);
    if ((Util.isNullOrNil(paramString)) || (!y.ZC(paramString)))
    {
      Log.i("MicroMsg.WebViewPreviewImgHelper", "checkCurrentPath path is null");
      AppMethodBeat.o(79210);
      return false;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeFile(paramString, localOptions);
    if ((localOptions.outWidth <= 1) || (localOptions.outHeight <= 1))
    {
      Log.i("MicroMsg.WebViewPreviewImgHelper", "checkCurrentPath file path invalid: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1059L, 4L, 1L, false);
      AppMethodBeat.o(79210);
      return false;
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1059L, 3L, 1L, false);
    Log.i("MicroMsg.WebViewPreviewImgHelper", "checkCurrentPath path: %s", new Object[] { paramString });
    AppMethodBeat.o(79210);
    return true;
  }
  
  public static void c(e parame)
  {
    AppMethodBeat.i(79206);
    if (parame == null)
    {
      AppMethodBeat.o(79206);
      return;
    }
    try
    {
      parame.m(108, new Bundle());
      AppMethodBeat.o(79206);
      return;
    }
    catch (RemoteException parame)
    {
      AppMethodBeat.o(79206);
    }
  }
  
  public static void iwf()
  {
    AppMethodBeat.i(79204);
    WOv = System.currentTimeMillis();
    AppMethodBeat.o(79204);
  }
  
  public static void iwg()
  {
    AppMethodBeat.i(182700);
    new cs().publish();
    AppMethodBeat.o(182700);
  }
  
  public static boolean iwh()
  {
    AppMethodBeat.i(79207);
    if (WOw == -1)
    {
      WOw = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yMG, 1);
      Log.i("MicroMsg.WebViewPreviewImgHelper", "shouldShowAnimation %d", new Object[] { Integer.valueOf(WOw) });
    }
    if (WOw == 1)
    {
      AppMethodBeat.o(79207);
      return true;
    }
    AppMethodBeat.o(79207);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.k
 * JD-Core Version:    0.7.0.1
 */