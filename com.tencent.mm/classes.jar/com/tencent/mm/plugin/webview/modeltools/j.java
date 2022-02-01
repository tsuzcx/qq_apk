package com.tencent.mm.plugin.webview.modeltools;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.i;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

public final class j
{
  private static long Jbq;
  private static int Jbr;
  private static int Jbs;
  private static boolean Jbt;
  private static Map<String, String> Jbu;
  
  static
  {
    AppMethodBeat.i(79211);
    Jbq = 0L;
    Jbr = -1;
    Jbs = -1;
    Jbt = false;
    Jbu = new HashMap();
    AppMethodBeat.o(79211);
  }
  
  public static void a(Bundle paramBundle1, MMWebView paramMMWebView, Bundle paramBundle2, boolean paramBoolean)
  {
    AppMethodBeat.i(182699);
    if (System.currentTimeMillis() - Jbq < 1000L)
    {
      AppMethodBeat.o(182699);
      return;
    }
    String str1 = paramBundle1.getString("url");
    Object localObject1 = paramBundle1.getString("filePath");
    Object localObject2 = new String[1];
    Object localObject3;
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
      }
    }
    while ((Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(str1)))
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
        String str2 = com.tencent.xweb.c.hsp().getCookie((String)localObject4);
        bool2 = bool3;
        localObject1 = localObject2;
        Log.i("MicroMsg.WebViewPreviewImgHelper", "url = %s, cookie = %s", new Object[] { localObject4, str2 });
        bool2 = bool3;
        localObject1 = localObject2;
        localObject4 = new Bundle();
        bool2 = bool3;
        localObject1 = localObject2;
        ((Bundle)localObject4).putString("cookie", str2);
        bool2 = bool3;
        localObject1 = localObject2;
        float f2 = com.tencent.mm.cc.a.gvp();
        f1 = f2;
        if (paramMMWebView != null)
        {
          f1 = f2;
          bool2 = bool3;
          localObject1 = localObject2;
          if (paramMMWebView.getWebCoreType() == WebView.c.SAt)
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
          paramBundle2 = ad.JX("ImgPreview");
          bool2 = bool3;
          localObject1 = paramMMWebView;
          localObject2 = ad.aVe().G(paramBundle2, true);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((ad.b)localObject2).l("preUsername", str2);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((ad.b)localObject2).l("preChatName", localObject4);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((ad.b)localObject2).l("url", paramMMWebView);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((ad.b)localObject2).l("Contact_Sub_Scene", Integer.valueOf(6));
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((ad.b)localObject2).l("Contact_Scene_Note", str1);
          bool2 = bool3;
          localObject1 = paramMMWebView;
          ((ad.b)localObject2).l("rawUrl", str3);
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
        for (;;)
        {
          float f1;
          int i;
          int n;
          int j;
          int k;
          int m;
          Log.e("MicroMsg.WebViewPreviewImgHelper", "getCookie fail : %s", new Object[] { paramMMWebView.getMessage() });
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
      paramMMWebView = MMApplicationContext.getContext();
      if (gdD())
      {
        i = au.eu(paramMMWebView);
        n = au.ay(paramMMWebView);
        j = (int)paramBundle1.getFloat("width");
        k = (int)paramBundle1.getFloat("height");
        m = (int)paramBundle1.getFloat("left");
        f1 = paramBundle1.getFloat("top");
        if (!paramBoolean) {
          break label1041;
        }
        i = 0;
        i = (int)(i + f1);
        n = com.tencent.mm.cb.a.jo(paramMMWebView);
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
    }
    Log.w("MicroMsg.WebViewPreviewImgHelper", "imagePreview failed url is null");
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
    if (Jbs == -1)
    {
      Jbs = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rSR, 1);
      Log.i("MicroMsg.WebViewPreviewImgHelper", "openXWebUrlToPath %d", new Object[] { Integer.valueOf(Jbs) });
    }
    if (Jbs == 1) {}
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
    String str = com.tencent.mm.loader.l.b.aLN() + "/reader_" + com.tencent.mm.b.g.getMessageDigest(paramMap.getBytes()) + ".jpg";
    if (s.YS(str))
    {
      Log.i("MicroMsg.WebViewPreviewImgHelper", "getImageBitmapToFile savePath exist");
      Jbu.put(paramMap, str);
      Jbt = true;
      AppMethodBeat.o(79208);
      return;
    }
    Jbt = paramMMWebView.getImageBitmapToFile(paramMap, str, "", new i()
    {
      public final void cV(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(79203);
        Log.i("MicroMsg.WebViewPreviewImgHelper", "onFinishImageBitmapToFile result %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        h localh;
        if (j.Jbt)
        {
          localh = h.CyF;
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
        j.apb().put(this.IJE, paramAnonymousString);
        AppMethodBeat.o(79203);
      }
    });
    AppMethodBeat.o(79208);
  }
  
  public static String aZt(String paramString)
  {
    AppMethodBeat.i(79209);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79209);
      return null;
    }
    if (!Jbt)
    {
      AppMethodBeat.o(79209);
      return null;
    }
    paramString = (String)Jbu.get(paramString);
    if (!Util.isNullOrNil(paramString)) {
      h.CyF.idkeyStat(1059L, 2L, 1L, false);
    }
    for (;;)
    {
      AppMethodBeat.o(79209);
      return paramString;
      h.CyF.idkeyStat(1059L, 5L, 1L, false);
    }
  }
  
  public static boolean aZu(String paramString)
  {
    AppMethodBeat.i(79210);
    if ((Util.isNullOrNil(paramString)) || (!s.YS(paramString)))
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
      h.CyF.idkeyStat(1059L, 4L, 1L, false);
      AppMethodBeat.o(79210);
      return false;
    }
    h.CyF.idkeyStat(1059L, 3L, 1L, false);
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
      parame.j(108, new Bundle());
      AppMethodBeat.o(79206);
      return;
    }
    catch (RemoteException parame)
    {
      AppMethodBeat.o(79206);
    }
  }
  
  public static void gdB()
  {
    AppMethodBeat.i(79204);
    Jbq = System.currentTimeMillis();
    AppMethodBeat.o(79204);
  }
  
  public static void gdC()
  {
    AppMethodBeat.i(182700);
    cf localcf = new cf();
    EventCenter.instance.publish(localcf);
    AppMethodBeat.o(182700);
  }
  
  public static boolean gdD()
  {
    AppMethodBeat.i(79207);
    if (Jbr == -1)
    {
      Jbr = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rSA, 1);
      Log.i("MicroMsg.WebViewPreviewImgHelper", "shouldShowAnimation %d", new Object[] { Integer.valueOf(Jbr) });
    }
    if (Jbr == 1)
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