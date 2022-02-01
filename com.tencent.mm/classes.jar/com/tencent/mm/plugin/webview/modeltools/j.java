package com.tencent.mm.plugin.webview.modeltools;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static long CsI;
  private static int CsJ;
  private static int CsK;
  private static boolean CsL;
  private static Map<String, String> CsM;
  
  static
  {
    AppMethodBeat.i(79211);
    CsI = 0L;
    CsJ = -1;
    CsK = -1;
    CsL = false;
    CsM = new HashMap();
    AppMethodBeat.o(79211);
  }
  
  public static void a(Bundle paramBundle1, MMWebView paramMMWebView, Bundle paramBundle2, boolean paramBoolean)
  {
    AppMethodBeat.i(182699);
    if (System.currentTimeMillis() - CsI < 1000L)
    {
      AppMethodBeat.o(182699);
      return;
    }
    String str1 = paramBundle1.getString("url");
    Object localObject1 = paramBundle1.getString("filePath");
    Object localObject2 = new String[1];
    Object localObject3;
    if (!bs.isNullOrNil((String)localObject1))
    {
      localObject3 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
      localObject3 = f.decodeFile((String)localObject1, (BitmapFactory.Options)localObject3);
      if (localObject3 != null)
      {
        ac.i("MicroMsg.WebViewPreviewImgHelper", "recycle bitmap:%s", new Object[] { localObject3.toString() });
        ((Bitmap)localObject3).recycle();
        localObject2[0] = localObject1;
      }
    }
    while ((bs.isNullOrNil((String)localObject1)) && (!bs.isNullOrNil(str1)))
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
        String str2 = c.fJa().getCookie((String)localObject4);
        bool2 = bool3;
        localObject1 = localObject2;
        ac.i("MicroMsg.WebViewPreviewImgHelper", "url = %s, cookie = %s", new Object[] { localObject4, str2 });
        bool2 = bool3;
        localObject1 = localObject2;
        localObject4 = new Bundle();
        bool2 = bool3;
        localObject1 = localObject2;
        ((Bundle)localObject4).putString("cookie", str2);
        bool2 = bool3;
        localObject1 = localObject2;
        float f2 = com.tencent.mm.cd.a.eSs();
        f1 = f2;
        if (paramMMWebView != null)
        {
          f1 = f2;
          bool2 = bool3;
          localObject1 = localObject2;
          if (paramMMWebView.getWebCoreType() == WebView.c.KzZ)
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
        if (!bs.isNullOrNil(paramMMWebView))
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
          paramBundle2 = y.xJ("ImgPreview");
          bool2 = bool3;
          localObject1 = paramMMWebView;
          localObject2 = y.ayq().F(paramBundle2, true);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((y.b)localObject2).l("preUsername", str2);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((y.b)localObject2).l("preChatName", localObject4);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((y.b)localObject2).l("url", paramMMWebView);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((y.b)localObject2).l("Contact_Sub_Scene", Integer.valueOf(6));
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((y.b)localObject2).l("Contact_Scene_Note", str1);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((y.b)localObject2).l("rawUrl", str3);
          if (i != 53)
          {
            bool1 = bool4;
            if (i != 52) {}
          }
          else
          {
            bool2 = bool3;
            localObject1 = paramMMWebView;
            ac.i("MicroMsg.WebViewPreviewImgHelper", "not allow to ScanQRCode");
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
          ac.e("MicroMsg.WebViewPreviewImgHelper", "getCookie fail : %s", new Object[] { paramMMWebView.getMessage() });
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
      paramMMWebView = ai.getContext();
      if (eCi())
      {
        i = ap.dT(paramMMWebView);
        n = ap.jL(paramMMWebView);
        j = (int)paramBundle1.getFloat("width");
        k = (int)paramBundle1.getFloat("height");
        m = (int)paramBundle1.getFloat("left");
        f1 = paramBundle1.getFloat("top");
        if (!paramBoolean) {
          break label1042;
        }
        i = 0;
        i = (int)(i + f1);
        n = com.tencent.mm.cc.a.ih(paramMMWebView);
        ac.d("MicroMsg.WebViewPreviewImgHelper", "doPreviewImg left %d, top %d, w %d, h %d", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        ((Intent)localObject3).putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", m).putExtra("img_gallery_top", i);
        if ((j > 0) && (k > 0) && (k < n)) {
          ((Intent)localObject3).putExtra("shouldRunDragAnimation", true);
        }
      }
      d.b(ai.getContext(), "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject3);
      AppMethodBeat.o(182699);
      return;
      ac.i("MicroMsg.WebViewPreviewImgHelper", "decode fail %s", new Object[] { localObject1 });
      localObject1 = "";
    }
    ac.w("MicroMsg.WebViewPreviewImgHelper", "imagePreview failed url is null");
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
    if (CsK == -1)
    {
      CsK = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pPN, 1);
      ac.i("MicroMsg.WebViewPreviewImgHelper", "openXWebUrlToPath %d", new Object[] { Integer.valueOf(CsK) });
    }
    if (CsK == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(79208);
      return;
    }
    paramMap = (String)paramMap.get("current");
    if (bs.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(79208);
      return;
    }
    ac.d("MicroMsg.WebViewPreviewImgHelper", "start getImageBitmapToFile");
    String str = com.tencent.mm.loader.l.b.aqj() + "/reader_" + com.tencent.mm.b.g.getMessageDigest(paramMap.getBytes()) + ".jpg";
    if (com.tencent.mm.vfs.i.eA(str))
    {
      ac.i("MicroMsg.WebViewPreviewImgHelper", "getImageBitmapToFile savePath exist");
      CsM.put(paramMap, str);
      CsL = true;
      AppMethodBeat.o(79208);
      return;
    }
    CsL = paramMMWebView.getImageBitmapToFile(paramMap, str, "", new com.tencent.xweb.i()
    {
      public final void cw(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(79203);
        ac.i("MicroMsg.WebViewPreviewImgHelper", "onFinishImageBitmapToFile result %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        h localh;
        if (j.CsL)
        {
          localh = h.wUl;
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
        j.Yr().put(this.CcQ, paramAnonymousString);
        AppMethodBeat.o(79203);
      }
    });
    AppMethodBeat.o(79208);
  }
  
  public static String aCv(String paramString)
  {
    AppMethodBeat.i(79209);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79209);
      return null;
    }
    if (!CsL)
    {
      AppMethodBeat.o(79209);
      return null;
    }
    paramString = (String)CsM.get(paramString);
    if (!bs.isNullOrNil(paramString)) {
      h.wUl.idkeyStat(1059L, 2L, 1L, false);
    }
    for (;;)
    {
      AppMethodBeat.o(79209);
      return paramString;
      h.wUl.idkeyStat(1059L, 5L, 1L, false);
    }
  }
  
  public static boolean aCw(String paramString)
  {
    AppMethodBeat.i(79210);
    if ((bs.isNullOrNil(paramString)) || (!com.tencent.mm.vfs.i.eA(paramString)))
    {
      ac.i("MicroMsg.WebViewPreviewImgHelper", "checkCurrentPath path is null");
      AppMethodBeat.o(79210);
      return false;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeFile(paramString, localOptions);
    if ((localOptions.outWidth <= 1) || (localOptions.outHeight <= 1))
    {
      ac.i("MicroMsg.WebViewPreviewImgHelper", "checkCurrentPath file path invalid: %s", new Object[] { paramString });
      h.wUl.idkeyStat(1059L, 4L, 1L, false);
      AppMethodBeat.o(79210);
      return false;
    }
    h.wUl.idkeyStat(1059L, 3L, 1L, false);
    ac.i("MicroMsg.WebViewPreviewImgHelper", "checkCurrentPath path: %s", new Object[] { paramString });
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
      parame.k(108, new Bundle());
      AppMethodBeat.o(79206);
      return;
    }
    catch (RemoteException parame)
    {
      AppMethodBeat.o(79206);
    }
  }
  
  public static void eCg()
  {
    AppMethodBeat.i(79204);
    CsI = System.currentTimeMillis();
    AppMethodBeat.o(79204);
  }
  
  public static void eCh()
  {
    AppMethodBeat.i(182700);
    ca localca = new ca();
    com.tencent.mm.sdk.b.a.GpY.l(localca);
    AppMethodBeat.o(182700);
  }
  
  public static boolean eCi()
  {
    AppMethodBeat.i(79207);
    if (CsJ == -1)
    {
      CsJ = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pPz, 1);
      ac.i("MicroMsg.WebViewPreviewImgHelper", "shouldShowAnimation %d", new Object[] { Integer.valueOf(CsJ) });
    }
    if (CsJ == 1)
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