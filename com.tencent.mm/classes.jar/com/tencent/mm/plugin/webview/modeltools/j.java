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
import com.tencent.mm.g.a.cd;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.o;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c;
import com.tencent.xweb.i;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

public final class j
{
  private static long Eom;
  private static int Eon;
  private static int Eoo;
  private static boolean Eop;
  private static Map<String, String> Eoq;
  
  static
  {
    AppMethodBeat.i(79211);
    Eom = 0L;
    Eon = -1;
    Eoo = -1;
    Eop = false;
    Eoq = new HashMap();
    AppMethodBeat.o(79211);
  }
  
  public static void a(Bundle paramBundle1, MMWebView paramMMWebView, Bundle paramBundle2, boolean paramBoolean)
  {
    AppMethodBeat.i(182699);
    if (System.currentTimeMillis() - Eom < 1000L)
    {
      AppMethodBeat.o(182699);
      return;
    }
    String str1 = paramBundle1.getString("url");
    Object localObject1 = paramBundle1.getString("filePath");
    Object localObject2 = new String[1];
    Object localObject3;
    if (!bu.isNullOrNil((String)localObject1))
    {
      localObject3 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
      localObject3 = h.decodeFile((String)localObject1, (BitmapFactory.Options)localObject3);
      if (localObject3 != null)
      {
        ae.i("MicroMsg.WebViewPreviewImgHelper", "recycle bitmap:%s", new Object[] { localObject3.toString() });
        ((Bitmap)localObject3).recycle();
        localObject2[0] = localObject1;
      }
    }
    while ((bu.isNullOrNil((String)localObject1)) && (!bu.isNullOrNil(str1)))
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
        String str2 = c.geY().getCookie((String)localObject4);
        bool2 = bool3;
        localObject1 = localObject2;
        ae.i("MicroMsg.WebViewPreviewImgHelper", "url = %s, cookie = %s", new Object[] { localObject4, str2 });
        bool2 = bool3;
        localObject1 = localObject2;
        localObject4 = new Bundle();
        bool2 = bool3;
        localObject1 = localObject2;
        ((Bundle)localObject4).putString("cookie", str2);
        bool2 = bool3;
        localObject1 = localObject2;
        float f2 = com.tencent.mm.cc.a.flD();
        f1 = f2;
        if (paramMMWebView != null)
        {
          f1 = f2;
          bool2 = bool3;
          localObject1 = localObject2;
          if (paramMMWebView.getWebCoreType() == WebView.c.MNy)
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
        if (!bu.isNullOrNil(paramMMWebView))
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
          paramBundle2 = z.Br("ImgPreview");
          bool2 = bool3;
          localObject1 = paramMMWebView;
          localObject2 = z.aBG().F(paramBundle2, true);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((z.b)localObject2).k("preUsername", str2);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((z.b)localObject2).k("preChatName", localObject4);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((z.b)localObject2).k("url", paramMMWebView);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((z.b)localObject2).k("Contact_Sub_Scene", Integer.valueOf(6));
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((z.b)localObject2).k("Contact_Scene_Note", str1);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((z.b)localObject2).k("rawUrl", str3);
          if (i != 53)
          {
            bool1 = bool4;
            if (i != 52) {}
          }
          else
          {
            bool2 = bool3;
            localObject1 = paramMMWebView;
            ae.i("MicroMsg.WebViewPreviewImgHelper", "not allow to ScanQRCode");
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
          ae.e("MicroMsg.WebViewPreviewImgHelper", "getCookie fail : %s", new Object[] { paramMMWebView.getMessage() });
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
      paramMMWebView = ak.getContext();
      if (eUO())
      {
        i = ar.dX(paramMMWebView);
        n = ar.kd(paramMMWebView);
        j = (int)paramBundle1.getFloat("width");
        k = (int)paramBundle1.getFloat("height");
        m = (int)paramBundle1.getFloat("left");
        f1 = paramBundle1.getFloat("top");
        if (!paramBoolean) {
          break label1041;
        }
        i = 0;
        i = (int)(i + f1);
        n = com.tencent.mm.cb.a.iv(paramMMWebView);
        ae.d("MicroMsg.WebViewPreviewImgHelper", "doPreviewImg left %d, top %d, w %d, h %d", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        ((Intent)localObject3).putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", m).putExtra("img_gallery_top", i);
        if ((j > 0) && (k > 0) && (k < n)) {
          ((Intent)localObject3).putExtra("shouldRunDragAnimation", true);
        }
      }
      d.b(ak.getContext(), "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject3);
      AppMethodBeat.o(182699);
      return;
      ae.i("MicroMsg.WebViewPreviewImgHelper", "decode fail %s", new Object[] { localObject1 });
      localObject1 = "";
    }
    ae.w("MicroMsg.WebViewPreviewImgHelper", "imagePreview failed url is null");
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
    if (Eoo == -1)
    {
      Eoo = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAD, 1);
      ae.i("MicroMsg.WebViewPreviewImgHelper", "openXWebUrlToPath %d", new Object[] { Integer.valueOf(Eoo) });
    }
    if (Eoo == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(79208);
      return;
    }
    paramMap = (String)paramMap.get("current");
    if (bu.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(79208);
      return;
    }
    ae.d("MicroMsg.WebViewPreviewImgHelper", "start getImageBitmapToFile");
    String str = com.tencent.mm.loader.l.b.atn() + "/reader_" + com.tencent.mm.b.g.getMessageDigest(paramMap.getBytes()) + ".jpg";
    if (o.fB(str))
    {
      ae.i("MicroMsg.WebViewPreviewImgHelper", "getImageBitmapToFile savePath exist");
      Eoq.put(paramMap, str);
      Eop = true;
      AppMethodBeat.o(79208);
      return;
    }
    Eop = paramMMWebView.getImageBitmapToFile(paramMap, str, "", new i()
    {
      public final void cC(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(79203);
        ae.i("MicroMsg.WebViewPreviewImgHelper", "onFinishImageBitmapToFile result %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        com.tencent.mm.plugin.report.service.g localg;
        if (j.Eop)
        {
          localg = com.tencent.mm.plugin.report.service.g.yxI;
          if (paramAnonymousInt != 0) {
            break label61;
          }
        }
        label61:
        for (long l = 0L;; l = 1L)
        {
          localg.idkeyStat(1059L, l, 1L, false);
          if (paramAnonymousInt == 0) {
            break;
          }
          AppMethodBeat.o(79203);
          return;
        }
        j.abc().put(this.DXN, paramAnonymousString);
        AppMethodBeat.o(79203);
      }
    });
    AppMethodBeat.o(79208);
  }
  
  public static String aJo(String paramString)
  {
    AppMethodBeat.i(79209);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79209);
      return null;
    }
    if (!Eop)
    {
      AppMethodBeat.o(79209);
      return null;
    }
    paramString = (String)Eoq.get(paramString);
    if (!bu.isNullOrNil(paramString)) {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1059L, 2L, 1L, false);
    }
    for (;;)
    {
      AppMethodBeat.o(79209);
      return paramString;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1059L, 5L, 1L, false);
    }
  }
  
  public static boolean aJp(String paramString)
  {
    AppMethodBeat.i(79210);
    if ((bu.isNullOrNil(paramString)) || (!o.fB(paramString)))
    {
      ae.i("MicroMsg.WebViewPreviewImgHelper", "checkCurrentPath path is null");
      AppMethodBeat.o(79210);
      return false;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeFile(paramString, localOptions);
    if ((localOptions.outWidth <= 1) || (localOptions.outHeight <= 1))
    {
      ae.i("MicroMsg.WebViewPreviewImgHelper", "checkCurrentPath file path invalid: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1059L, 4L, 1L, false);
      AppMethodBeat.o(79210);
      return false;
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1059L, 3L, 1L, false);
    ae.i("MicroMsg.WebViewPreviewImgHelper", "checkCurrentPath path: %s", new Object[] { paramString });
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
  
  public static void eUM()
  {
    AppMethodBeat.i(79204);
    Eom = System.currentTimeMillis();
    AppMethodBeat.o(79204);
  }
  
  public static void eUN()
  {
    AppMethodBeat.i(182700);
    cd localcd = new cd();
    com.tencent.mm.sdk.b.a.IvT.l(localcd);
    AppMethodBeat.o(182700);
  }
  
  public static boolean eUO()
  {
    AppMethodBeat.i(79207);
    if (Eon == -1)
    {
      Eon = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAo, 1);
      ae.i("MicroMsg.WebViewPreviewImgHelper", "shouldShowAnimation %d", new Object[] { Integer.valueOf(Eon) });
    }
    if (Eon == 1)
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