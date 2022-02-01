package com.tencent.mm.plugin.webview.modeltools;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

public final class j
{
  private static long Bav;
  private static int Baw;
  private static int Bax;
  private static boolean Bay;
  private static Map<String, String> Baz;
  
  static
  {
    AppMethodBeat.i(79211);
    Bav = 0L;
    Baw = -1;
    Bax = -1;
    Bay = false;
    Baz = new HashMap();
    AppMethodBeat.o(79211);
  }
  
  public static void a(Bundle paramBundle1, MMWebView paramMMWebView, Bundle paramBundle2, boolean paramBoolean)
  {
    AppMethodBeat.i(182699);
    if (System.currentTimeMillis() - Bav < 1000L)
    {
      AppMethodBeat.o(182699);
      return;
    }
    String str1 = paramBundle1.getString("url");
    Object localObject1 = paramBundle1.getString("filePath");
    Object localObject2 = new String[1];
    Object localObject3;
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject3 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
      localObject3 = f.decodeFile((String)localObject1, (BitmapFactory.Options)localObject3);
      if (localObject3 != null)
      {
        ad.i("MicroMsg.WebViewPreviewImgHelper", "recycle bitmap:%s", new Object[] { localObject3.toString() });
        ((Bitmap)localObject3).recycle();
        localObject2[0] = localObject1;
      }
    }
    while ((bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil(str1)))
    {
      localObject2[0] = str1;
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("nowUrl", str1);
      ((Intent)localObject3).putExtra("urlList", (String[])localObject2);
      ((Intent)localObject3).putExtra("type", -255);
      ((Intent)localObject3).putExtra("isFromWebView", true);
      ((Intent)localObject3).putExtra("isOuntLink", true);
      bool1 = true;
      boolean bool3 = true;
      boolean bool4 = true;
      localObject2 = "";
      bool2 = bool3;
      localObject1 = localObject2;
      try
      {
        Object localObject4 = paramMMWebView.getUrl();
        bool2 = bool3;
        localObject1 = localObject2;
        String str2 = c.fqC().getCookie((String)localObject4);
        bool2 = bool3;
        localObject1 = localObject2;
        ad.i("MicroMsg.WebViewPreviewImgHelper", "url = %s, cookie = %s", new Object[] { localObject4, str2 });
        bool2 = bool3;
        localObject1 = localObject2;
        localObject4 = new Bundle();
        bool2 = bool3;
        localObject1 = localObject2;
        ((Bundle)localObject4).putString("cookie", str2);
        bool2 = bool3;
        localObject1 = localObject2;
        float f2 = com.tencent.mm.ce.a.eCY();
        f1 = f2;
        if (paramMMWebView != null)
        {
          f1 = f2;
          bool2 = bool3;
          localObject1 = localObject2;
          if (paramMMWebView.getWebCoreType() == WebView.c.INC)
          {
            f1 = f2;
            bool2 = bool3;
            localObject1 = localObject2;
            if (XWalkEnvironment.getUsingCustomContext())
            {
              bool2 = bool3;
              localObject1 = localObject2;
              f1 = paramMMWebView.getResources().getDisplayMetrics().density;
            }
          }
        }
        bool2 = bool3;
        localObject1 = localObject2;
        ((Bundle)localObject4).putFloat("density", f1);
        bool2 = bool3;
        localObject1 = localObject2;
        paramMMWebView = ((Bundle)localObject4).getString("cookie", null);
        bool2 = bool3;
        localObject1 = localObject2;
        if (!bt.isNullOrNil(paramMMWebView))
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
          paramBundle2 = y.tD("ImgPreview");
          bool2 = bool3;
          localObject1 = paramMMWebView;
          localObject2 = y.arz().E(paramBundle2, true);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((y.b)localObject2).m("preUsername", str2);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((y.b)localObject2).m("preChatName", localObject4);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((y.b)localObject2).m("url", paramMMWebView);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((y.b)localObject2).m("Contact_Sub_Scene", Integer.valueOf(6));
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((y.b)localObject2).m("Contact_Scene_Note", str1);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((y.b)localObject2).m("rawUrl", str3);
          if (i != 53)
          {
            bool1 = bool4;
            if (i != 52) {}
          }
          else
          {
            bool2 = bool3;
            localObject1 = paramMMWebView;
            ad.i("MicroMsg.WebViewPreviewImgHelper", "not allow to ScanQRCode");
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
        for (;;)
        {
          float f1;
          int i;
          int n;
          int j;
          int k;
          int m;
          ad.e("MicroMsg.WebViewPreviewImgHelper", "getCookie fail : %s", new Object[] { paramMMWebView.getMessage() });
          bool1 = bool2;
          continue;
          i += n;
        }
      }
      ((Intent)localObject3).putExtra("shouldShowScanQrCodeMenu", bool1);
      paramMMWebView = new Bundle();
      paramMMWebView.putInt("stat_scene", 4);
      paramMMWebView.putString("stat_url", (String)localObject1);
      ((Intent)localObject3).putExtra("_stat_obj", paramMMWebView);
      paramMMWebView = aj.getContext();
      if (emN())
      {
        i = ap.dL(paramMMWebView);
        n = ap.jA(paramMMWebView);
        j = (int)paramBundle1.getFloat("width");
        k = (int)paramBundle1.getFloat("height");
        m = (int)paramBundle1.getFloat("left");
        f1 = paramBundle1.getFloat("top");
        if (!paramBoolean) {
          break label1042;
        }
        i = 0;
        i = (int)(i + f1);
        n = com.tencent.mm.cd.a.hW(paramMMWebView);
        ad.d("MicroMsg.WebViewPreviewImgHelper", "doPreviewImg left %d, top %d, w %d, h %d", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        ((Intent)localObject3).putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", m).putExtra("img_gallery_top", i);
        if ((j > 0) && (k > 0) && (k < n)) {
          ((Intent)localObject3).putExtra("shouldRunDragAnimation", true);
        }
      }
      d.b(aj.getContext(), "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject3);
      AppMethodBeat.o(182699);
      return;
      ad.i("MicroMsg.WebViewPreviewImgHelper", "decode fail %s", new Object[] { localObject1 });
      localObject1 = "";
    }
    ad.w("MicroMsg.WebViewPreviewImgHelper", "imagePreview failed url is null");
    AppMethodBeat.o(182699);
  }
  
  public static void a(Map<String, Object> paramMap, MMWebView paramMMWebView)
  {
    AppMethodBeat.i(79208);
    if ((paramMMWebView == null) || (paramMap == null))
    {
      AppMethodBeat.o(79208);
      return;
    }
    if (Bax == -1)
    {
      Bax = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pmq, 1);
      ad.i("MicroMsg.WebViewPreviewImgHelper", "openXWebUrlToPath %d", new Object[] { Integer.valueOf(Bax) });
    }
    if (Bax == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(79208);
      return;
    }
    paramMap = (String)paramMap.get("current");
    if (bt.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(79208);
      return;
    }
    ad.d("MicroMsg.WebViewPreviewImgHelper", "start getImageBitmapToFile");
    String str = com.tencent.mm.loader.l.b.ajj() + "/reader_" + com.tencent.mm.b.g.getMessageDigest(paramMap.getBytes()) + ".jpg";
    if (com.tencent.mm.vfs.i.eK(str))
    {
      ad.i("MicroMsg.WebViewPreviewImgHelper", "getImageBitmapToFile savePath exist");
      Baz.put(paramMap, str);
      Bay = true;
      AppMethodBeat.o(79208);
      return;
    }
    Bay = paramMMWebView.getImageBitmapToFile(paramMap, str, "", new com.tencent.xweb.i()
    {
      public final void ct(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(79203);
        ad.i("MicroMsg.WebViewPreviewImgHelper", "onFinishImageBitmapToFile result %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        h localh;
        if (j.Bay)
        {
          localh = h.vKh;
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
        j.Xu().put(this.AKz, paramAnonymousString);
        AppMethodBeat.o(79203);
      }
    });
    AppMethodBeat.o(79208);
  }
  
  public static String axd(String paramString)
  {
    AppMethodBeat.i(79209);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79209);
      return null;
    }
    if (!Bay)
    {
      AppMethodBeat.o(79209);
      return null;
    }
    paramString = (String)Baz.get(paramString);
    if (!bt.isNullOrNil(paramString)) {
      h.vKh.idkeyStat(1059L, 2L, 1L, false);
    }
    for (;;)
    {
      AppMethodBeat.o(79209);
      return paramString;
      h.vKh.idkeyStat(1059L, 5L, 1L, false);
    }
  }
  
  public static boolean axe(String paramString)
  {
    AppMethodBeat.i(79210);
    if ((bt.isNullOrNil(paramString)) || (!com.tencent.mm.vfs.i.eK(paramString)))
    {
      ad.i("MicroMsg.WebViewPreviewImgHelper", "checkCurrentPath path is null");
      AppMethodBeat.o(79210);
      return false;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeFile(paramString, localOptions);
    if ((localOptions.outWidth <= 1) || (localOptions.outHeight <= 1))
    {
      ad.i("MicroMsg.WebViewPreviewImgHelper", "checkCurrentPath file path invalid: %s", new Object[] { paramString });
      h.vKh.idkeyStat(1059L, 4L, 1L, false);
      AppMethodBeat.o(79210);
      return false;
    }
    h.vKh.idkeyStat(1059L, 3L, 1L, false);
    ad.i("MicroMsg.WebViewPreviewImgHelper", "checkCurrentPath path: %s", new Object[] { paramString });
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
      parame.j(108, new Bundle());
      AppMethodBeat.o(79206);
      return;
    }
    catch (RemoteException parame)
    {
      AppMethodBeat.o(79206);
    }
  }
  
  public static void emL()
  {
    AppMethodBeat.i(79204);
    Bav = System.currentTimeMillis();
    AppMethodBeat.o(79204);
  }
  
  public static void emM()
  {
    AppMethodBeat.i(182700);
    ca localca = new ca();
    com.tencent.mm.sdk.b.a.ESL.l(localca);
    AppMethodBeat.o(182700);
  }
  
  public static boolean emN()
  {
    AppMethodBeat.i(79207);
    if (Baw == -1)
    {
      Baw = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pmd, 1);
      ad.i("MicroMsg.WebViewPreviewImgHelper", "shouldShowAnimation %d", new Object[] { Integer.valueOf(Baw) });
    }
    if (Baw == 1)
    {
      AppMethodBeat.o(79207);
      return true;
    }
    AppMethodBeat.o(79207);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.j
 * JD-Core Version:    0.7.0.1
 */