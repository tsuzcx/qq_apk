package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.pluginsdk.model.w.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.e.l;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static Intent Clb;
  private static WeakReference<Activity> Clc;
  public static HashMap<String, String> Cld;
  public static HashMap<String, String> Cle;
  
  static
  {
    AppMethodBeat.i(109506);
    Cld = new HashMap();
    long l = System.currentTimeMillis();
    for (;;)
    {
      int i;
      try
      {
        String[] arrayOfString1 = i.aMP("assets:///mimetype.txt").split("\n");
        int j = arrayOfString1.length;
        i = 0;
        if (i < j)
        {
          String str = arrayOfString1[i];
          String[] arrayOfString2 = str.split(",");
          if ((arrayOfString2 != null) && (arrayOfString2.length > 1) && (!bt.isNullOrNil(arrayOfString2[0])) && (!bt.isNullOrNil(arrayOfString2[1]))) {
            Cld.put(arrayOfString2[0].trim(), arrayOfString2[1].trim());
          } else {
            ad.i("MicroMsg.AppChooserIntentUtil", "mimeType %s", new Object[] { str });
          }
        }
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("MicroMsg.AppChooserIntentUtil", localIOException, "read mimeType from asset", new Object[0]);
      }
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        Cle = localHashMap;
        localHashMap.put("txt", "mtt/txt");
        Cle.put("epub", "mtt/epub");
        Cle.put("pdf", "mtt/pdf");
        Cle.put("doc", "mtt/doc");
        Cle.put("xls", "mtt/xls");
        Cle.put("ppt", "mtt/ppt");
        Cle.put("docx", "mtt/docx");
        Cle.put("xlsx", "mtt/xlsx");
        Cle.put("pptx", "mtt/pptx");
        Cle.put("chm", "mtt/chm");
        Cle.put("ini", "mtt/ini");
        Cle.put("log", "mtt/log");
        Cle.put("bat", "mtt/bat");
        Cle.put("php", "mtt/php");
        Cle.put("lrc", "mtt/lrc");
        Cle.put("js", "mtt/js");
        AppMethodBeat.o(109506);
        return;
        ad.i("MicroMsg.AppChooserIntentUtil", "read from mimetype text %d %d %d", new Object[] { Integer.valueOf(localHashMap.length), Integer.valueOf(Cld.size()), Long.valueOf(System.currentTimeMillis() - l) });
      }
      i += 1;
    }
  }
  
  private static Intent L(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(109497);
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    m.a(paramContext, localIntent, new com.tencent.mm.vfs.e(paramString2), paramString1);
    try
    {
      ad.i("MicroMsg.AppChooserIntentUtil", "createNormalIntent %s %s %s", new Object[] { paramString1, paramString2, localIntent.toString() });
      label67:
      AppMethodBeat.o(109497);
      return localIntent;
    }
    catch (Exception paramContext)
    {
      break label67;
    }
  }
  
  private static Intent M(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(109498);
    Intent localIntent = new Intent();
    localIntent.setPackage("com.tencent.mtt");
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    m.a(paramContext, localIntent, new com.tencent.mm.vfs.e(paramString2), paramString1);
    try
    {
      ad.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserIntent %s %s %s", new Object[] { paramString1, paramString2, localIntent.toString() });
      label74:
      AppMethodBeat.o(109498);
      return localIntent;
    }
    catch (Exception paramContext)
    {
      break label74;
    }
  }
  
  private static Intent a(Intent paramIntent, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(109500);
    String str;
    boolean bool2;
    Object localObject;
    if (hk(paramContext))
    {
      str = "";
      bool2 = f.eAG().aCy(paramString1);
      localObject = f.eAG();
      ((f)localObject).onDestroy();
      ((f)localObject).j(paramString1, paramString2, paramString3, paramInt);
      paramString3 = str;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        paramString3 = str;
        ((JSONObject)localObject).put("pkgName", paramContext.getPackageName());
        paramString3 = str;
        ((JSONObject)localObject).put("className", "com.tencent.mm.ui.tools.QbCallBackBroadcast");
        paramString3 = str;
        ((JSONObject)localObject).put("broadcast", true);
        paramString3 = str;
        JSONObject localJSONObject = new JSONObject();
        paramString3 = str;
        localJSONObject.put("type", "qb");
        paramString3 = str;
        localJSONObject.put("filePath", paramString1);
        paramString3 = str;
        localJSONObject.put("fileExt", paramString2);
        paramString3 = str;
        localJSONObject.put("sence", paramInt);
        paramString3 = str;
        localJSONObject.put("verify", paramString4);
        paramString3 = str;
        ((JSONObject)localObject).put("thirdCtx", localJSONObject);
        paramString3 = str;
        paramString1 = new JSONObject();
        paramString3 = str;
        paramString1.put("id", 1);
        paramString3 = str;
        paramString1.put("iconResId", 0);
        paramString3 = str;
        paramString1.put("text", paramContext.getString(2131759080));
        if (bool2) {
          continue;
        }
        bool1 = true;
        paramString3 = str;
        paramString1.put("isShow", bool1);
        paramString3 = str;
        paramString1.put("idx", 1);
        paramString3 = str;
        paramString2 = new JSONObject();
        paramString3 = str;
        paramString2.put("id", 2);
        paramString3 = str;
        paramString2.put("iconResId", 1);
        paramString3 = str;
        paramString2.put("text", paramContext.getString(2131759079));
        paramString3 = str;
        paramString2.put("isShow", bool2);
        paramString3 = str;
        paramString2.put("idx", 1);
        paramString3 = str;
        paramString4 = new ArrayList();
        paramString3 = str;
        paramString4.add(paramString1);
        paramString3 = str;
        paramString4.add(paramString2);
        paramString3 = str;
        ((JSONObject)localObject).put("menuItems", new JSONArray(paramString4));
        paramString3 = str;
        paramString1 = new JSONObject();
        paramString3 = str;
        paramString1.put("id", 10);
        paramString3 = str;
        ((JSONObject)localObject).put("activityStatusItems", paramString1);
        paramString3 = str;
        paramString1 = new JSONObject();
        paramString3 = str;
        paramString1.put("id", 11);
        paramString3 = str;
        ((JSONObject)localObject).put("changeFileItems", paramString1);
        paramString3 = str;
        ((JSONObject)localObject).put("menuBottom", true);
        paramString3 = str;
        paramString1 = ((JSONObject)localObject).toString();
        paramString3 = paramString1;
        ad.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserDocumentIntent menuData:%s", new Object[] { paramString1 });
        paramString3 = paramString1;
      }
      catch (Exception paramString1)
      {
        boolean bool1;
        ad.e("MicroMsg.AppChooserIntentUtil", "createQQBrowserDocumentIntent menuItems jsonObject error" + paramString1.getMessage());
        continue;
        byte b = 1;
        continue;
      }
      paramString1 = new ArrayList();
      paramString2 = BitmapFactory.decodeResource(paramContext.getResources(), 2131232406);
      paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2131232405);
      paramString1.add(0, paramString2);
      paramString1.add(1, paramContext);
      paramContext = new Bundle();
      paramContext.putParcelableArrayList("resArray", paramString1);
      paramContext.putString("menuData", paramString3);
      paramContext.putString("style", "0");
      paramIntent.putExtra("key_reader_sdk_extrals", paramContext);
      if (!bt.iY(paramInt, 9)) {
        continue;
      }
      b = 3;
      paramIntent.putExtra("key_reader_sdk_sub_id", b);
      ad.d("MicroMsg.AppChooserIntentUtil", "subId:%s", new Object[] { Byte.valueOf(b) });
      AppMethodBeat.o(109500);
      return paramIntent;
      bool1 = false;
    }
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(109496);
    if (paramInt1 == 2)
    {
      if ((-1 == paramInt2) && (paramIntent != null))
      {
        String str = paramIntent.getStringExtra("selectpkg");
        Intent localIntent = (Intent)paramIntent.getBundleExtra("transferback").getParcelable("targetintent");
        if (localIntent != null)
        {
          ad.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI select package name %s and target intent is not null", new Object[] { str });
          localIntent = new Intent(localIntent);
          localIntent.setPackage(str);
          if (bt.T(paramActivity, localIntent))
          {
            paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
            com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramIntent.adn(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "handlerResultOfAppChooserUI", "(Landroid/app/Activity;IILandroid/content/Intent;ZIII)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramActivity.startActivity((Intent)paramIntent.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "handlerResultOfAppChooserUI", "(Landroid/app/Activity;IILandroid/content/Intent;ZIII)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if ("com.tencent.mtt".equals(str))
            {
              com.tencent.mm.plugin.report.service.h.vKh.f(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt5) });
              AppMethodBeat.o(109496);
            }
          }
          else
          {
            ad.e("MicroMsg.AppChooserIntentUtil", "Always Intent is not support mimetype");
            if (paramBoolean) {
              a(paramActivity, paramIntent, paramInt3, paramInt4);
            }
          }
          AppMethodBeat.o(109496);
          return;
        }
        ad.e("MicroMsg.AppChooserIntentUtil", "AppChooserUI target intent is null in handlerResultOfAppChooserUI");
        if (paramBoolean) {
          a(paramActivity, paramIntent, paramInt3, paramInt4);
        }
        AppMethodBeat.o(109496);
        return;
      }
      if (4098 == paramInt2)
      {
        ad.e("MicroMsg.AppChooserIntentUtil", "Not Found App Support media type");
        if (paramBoolean)
        {
          a(paramActivity, paramIntent, paramInt3, paramInt4);
          AppMethodBeat.o(109496);
        }
      }
      else if (4097 == paramInt2)
      {
        ad.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is no choice");
        if (paramBoolean)
        {
          a(paramActivity, paramIntent, paramInt3, paramInt4);
          AppMethodBeat.o(109496);
        }
      }
      else
      {
        ad.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is not ok or data is null");
      }
    }
    AppMethodBeat.o(109496);
  }
  
  private static void a(Activity paramActivity, Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(184245);
    if (paramIntent != null) {
      paramIntent.getStringExtra("mimetype");
    }
    if (Cle.containsKey(""))
    {
      if (!ay.isWifi(paramActivity))
      {
        paramIntent = new com.tencent.mm.ui.widget.a.f.a(aj.getContext());
        paramIntent.aMo(paramActivity.getString(2131764386)).wZ(true).aaF(2131759571);
        paramIntent.c(new f.c()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(184243);
            if (paramAnonymousBoolean)
            {
              paramAnonymousString = new com.tencent.mm.ui.widget.a.f.a(this.val$activity).aMo(this.val$activity.getString(2131764387));
              paramAnonymousString.HFB = true;
              paramAnonymousString.aaF(2131755792).b(new f.c()
              {
                public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
                {
                  AppMethodBeat.i(184242);
                  w.a.tT(true);
                  AppMethodBeat.o(184242);
                }
              }).show();
            }
            AppMethodBeat.o(184243);
          }
        }).b(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(184241);
            an.d("dancy", "OnDismissListener ", new Object[0]);
            AppMethodBeat.o(184241);
          }
        }).show();
        AppMethodBeat.o(184245);
        return;
      }
      paramActivity = new com.tencent.mm.ui.widget.a.f.a(paramActivity).aMo(paramActivity.getString(2131764388));
      paramActivity.HFB = true;
      paramActivity.aaF(2131755792).b(new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(184244);
          w.a.tT(true);
          AppMethodBeat.o(184244);
        }
      }).show();
      AppMethodBeat.o(184245);
      return;
    }
    com.tencent.mm.ui.base.h.j(paramActivity, paramInt1, paramInt2);
    AppMethodBeat.o(184245);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(109489);
    Object localObject1 = new com.tencent.mm.vfs.e(paramString1);
    ad.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", new Object[] { paramString1, Boolean.valueOf(((com.tencent.mm.vfs.e)localObject1).exists()), Long.valueOf(((com.tencent.mm.vfs.e)localObject1).length()) });
    if (!((com.tencent.mm.vfs.e)localObject1).exists())
    {
      ad.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
      AppMethodBeat.o(109489);
      return;
    }
    Context localContext = aj.getContext();
    String str = aCs(paramString2);
    Object localObject2 = aCp(str);
    localObject1 = localObject2;
    if (((String)localObject2).equals("com.baidu.searchbox"))
    {
      aCq(str);
      localObject1 = "";
    }
    if (!((String)localObject1).equals(""))
    {
      ad.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[] { localObject1 });
      localObject2 = L(aj.getContext(), str, paramString1);
      ((Intent)localObject2).setPackage((String)localObject1);
      if (bt.T(localContext, (Intent)localObject2))
      {
        ad.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType %s", new Object[] { str });
        com.tencent.xweb.f.lY(com.tencent.mm.cr.a.aNq(paramString1), paramString2);
        com.tencent.xweb.f.lZ(paramString2, "THIRDAPP");
        paramActivity = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, paramActivity.adn(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooser", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)paramActivity.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooser", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(109489);
        return;
      }
      ad.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType %s", new Object[] { str });
    }
    if (!c(paramString1, paramString2, paramString3, str, paramInt))
    {
      ad.i("MicroMsg.AppChooserIntentUtil", "open file by qb");
      AppMethodBeat.o(109489);
      return;
    }
    localObject1 = L(localContext, str, paramString1);
    if (!q.gY(aj.getContext())) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramActivity, paramString1, paramString2, paramString3, (Intent)localObject1, paramInt, bool);
      AppMethodBeat.o(109489);
      return;
    }
  }
  
  private static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(109492);
    String str = aCs(paramString2);
    Object localObject = m.a(paramActivity, new com.tencent.mm.vfs.e(paramString1));
    Bundle localBundle = new Bundle();
    if (localObject != null) {
      localBundle.putString("targeturl", ((Uri)localObject).toString());
    }
    localBundle.putString("filepath", paramString1);
    localBundle.putString("fileext", paramString2);
    localBundle.putParcelable("targetintent", paramIntent);
    localObject = new Intent();
    ((Intent)localObject).putExtra("type", 0);
    ((Intent)localObject).putExtra("title", paramActivity.getResources().getString(2131757345));
    ((Intent)localObject).putExtra("needupate", false);
    if (!paramBoolean) {
      bool = true;
    }
    ((Intent)localObject).putExtra("not_show_recommend_app", bool);
    ((Intent)localObject).putExtra("mimetype", str);
    ((Intent)localObject).putExtra("targetintent", paramIntent);
    ((Intent)localObject).putExtra("transferback", localBundle);
    ((Intent)localObject).putExtra("scene", paramInt);
    if (paramInt == 7) {
      ((com.tencent.mm.choosemsgfile.compat.a)g.ab(com.tencent.mm.choosemsgfile.compat.a.class)).g(paramActivity, paramString1, paramString2);
    }
    for (;;)
    {
      Clb = (Intent)localObject;
      Clc = new WeakReference(paramActivity);
      AppMethodBeat.o(109492);
      return;
      b(paramActivity, paramString1, paramString2, paramString3, paramInt);
    }
  }
  
  private static boolean aCo(String paramString)
  {
    AppMethodBeat.i(109495);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(109495);
      return false;
    }
    String str = (String)g.afB().afk().get(ae.a.FkX, "");
    if ((!bt.isNullOrNil(str)) && (str.contains(paramString)))
    {
      AppMethodBeat.o(109495);
      return true;
    }
    AppMethodBeat.o(109495);
    return false;
  }
  
  private static String aCp(String paramString)
  {
    AppMethodBeat.i(109502);
    paramString = (String)g.afB().afk().get(aCr(paramString), "");
    AppMethodBeat.o(109502);
    return paramString;
  }
  
  private static void aCq(String paramString)
  {
    AppMethodBeat.i(109503);
    if (!g.afw())
    {
      AppMethodBeat.o(109503);
      return;
    }
    g.afB().afk().set(aCr(paramString), "");
    AppMethodBeat.o(109503);
  }
  
  private static int aCr(String paramString)
  {
    AppMethodBeat.i(109504);
    if (paramString != null)
    {
      int i = paramString.hashCode();
      AppMethodBeat.o(109504);
      return 274528 + i;
    }
    AppMethodBeat.o(109504);
    return 274528;
  }
  
  private static String aCs(String paramString)
  {
    AppMethodBeat.i(109505);
    Object localObject1;
    if (bt.isNullOrNil(paramString)) {
      localObject1 = "application/octet-stream";
    }
    for (;;)
    {
      ad.i("MicroMsg.AppChooserIntentUtil", "getMimeTypeByExt fileExt: %s mimeType: %s", new Object[] { paramString, localObject1 });
      AppMethodBeat.o(109505);
      return localObject1;
      localObject1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
      Object localObject2 = localObject1;
      if (bt.isNullOrNil((String)localObject1)) {
        localObject2 = (String)Cld.get(paramString);
      }
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        if (paramString.startsWith("/")) {
          localObject1 = "application/octet-stream";
        } else {
          localObject1 = "application/".concat(String.valueOf(paramString));
        }
      }
    }
  }
  
  public static void aW(Intent paramIntent)
  {
    AppMethodBeat.i(109494);
    try
    {
      boolean bool1 = paramIntent.getBooleanExtra("MINIQB_OPEN_RET_VAL", false);
      paramIntent.getStringExtra("file_path");
      String str2 = paramIntent.getStringExtra("file_ext");
      ad.i("MicroMsg.AppChooserIntentUtil", "miniQB retVal:%b", new Object[] { Boolean.valueOf(bool1) });
      boolean bool2 = g.afw();
      if (!bool2)
      {
        AppMethodBeat.o(109494);
        return;
      }
      String str1 = (String)g.afB().afk().get(ae.a.FkX, "");
      if (!bool1) {
        paramIntent = str1.replace(str2, "");
      }
      for (;;)
      {
        g.afB().afk().set(ae.a.FkX, paramIntent);
        if ((!bool1) && (Clb != null) && (Clc != null) && (Clc.get() != null))
        {
          Clb.setClass((Context)Clc.get(), AppChooserUI.class);
          ((Activity)Clc.get()).startActivityForResult(Clb, 2);
        }
        Clb = null;
        AppMethodBeat.o(109494);
        return;
        paramIntent = str1;
        if (!str1.contains(str2)) {
          paramIntent = str1.concat(str2);
        }
      }
      return;
    }
    catch (Exception paramIntent)
    {
      AppMethodBeat.o(109494);
    }
  }
  
  public static boolean ad(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109485);
    boolean bool = i(paramString1, paramString2, "", paramInt);
    AppMethodBeat.o(109485);
    return bool;
  }
  
  private static Intent b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(109499);
    Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document");
    localIntent.setPackage("com.tencent.mtt");
    localIntent.addFlags(268435456);
    localIntent.putExtra("ChannelID", "com.tencent.mm");
    localIntent.putExtra("PosID", 4);
    localIntent.putExtra("key_reader_sdk_id", 1);
    localIntent.putExtra("key_reader_sdk_type", 0);
    localIntent.putExtra("key_reader_sdk_format", paramString2);
    localIntent.putExtra("key_reader_sdk_path", paramString1);
    a(localIntent, paramContext, paramString1, paramString2, paramString3, paramString4, paramInt);
    paramString4 = (String)Cle.get(paramString2);
    paramString3 = paramString4;
    if (bt.isNullOrNil(paramString4)) {
      paramString3 = aCs(paramString2);
    }
    m.a(paramContext, localIntent, new com.tencent.mm.vfs.e(paramString1), paramString3);
    try
    {
      ad.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserDocumentIntent %s %s %s %s %s %s", new Object[] { paramString3, paramString1, localIntent.toString(), localIntent.getExtras(), paramString2, Integer.valueOf(paramInt) });
      label202:
      AppMethodBeat.o(109499);
      return localIntent;
    }
    catch (Exception paramContext)
    {
      break label202;
    }
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109488);
    a(paramActivity, paramString1, paramString2, "", paramInt);
    AppMethodBeat.o(109488);
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(109493);
    Intent localIntent = new Intent();
    localIntent.putExtra("file_path", paramString1);
    localIntent.putExtra("file_ext", paramString2);
    localIntent.putExtra("file_name", paramString3);
    localIntent.putExtra("sence", paramInt);
    localIntent.addFlags(268435456);
    localIntent.setComponent(new ComponentName(e.l.FIi, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE");
    paramContext.sendBroadcast(localIntent);
    AppMethodBeat.o(109493);
  }
  
  public static void b(MMActivity paramMMActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(109491);
    String str = aCs(paramString2);
    aCq(str);
    Uri localUri = m.a(paramMMActivity, new com.tencent.mm.vfs.e(paramString1));
    Bundle localBundle = new Bundle();
    Intent localIntent = L(paramMMActivity, str, paramString1);
    localBundle.putString("targeturl", localUri.toString());
    localBundle.putString("filepath", paramString1);
    localBundle.putString("fileext", paramString2);
    localBundle.putParcelable("targetintent", localIntent);
    paramString1 = new Intent();
    paramString1.putExtra("type", 0);
    paramString1.putExtra("title", paramMMActivity.getResources().getString(2131757345));
    paramString1.putExtra("mimetype", str);
    paramString1.putExtra("targetintent", localIntent);
    paramString1.putExtra("transferback", localBundle);
    paramString1.putExtra("scene", 8);
    paramString1.putExtra("openWay", true);
    com.tencent.mm.bs.d.a(paramMMActivity, ".pluginsdk.ui.tools.AppChooserUI", paramString1, 2, new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(109484);
        a.a(this.val$activity, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent, true, 2131758111, 2131758112, this.fpl);
        AppMethodBeat.o(109484);
      }
    });
    AppMethodBeat.o(109491);
  }
  
  public static boolean c(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109490);
    String str = aCs(paramString2);
    Uri localUri = m.a(paramActivity, new com.tencent.mm.vfs.e(paramString1));
    Bundle localBundle = new Bundle();
    Intent localIntent = L(paramActivity, str, paramString1);
    localBundle.putString("targeturl", localUri.toString());
    localBundle.putString("filepath", paramString1);
    localBundle.putString("fileext", paramString2);
    localBundle.putParcelable("targetintent", localIntent);
    paramString1 = new Intent(paramActivity, AppChooserUI.class);
    paramString1.putExtra("type", 0);
    paramString1.putExtra("title", paramActivity.getResources().getString(2131757345));
    paramString1.putExtra("mimetype", str);
    paramString1.putExtra("targetintent", localIntent);
    paramString1.putExtra("transferback", localBundle);
    paramString1.putExtra("scene", paramInt);
    paramString1.putExtra("openWay", true);
    paramActivity.startActivityForResult(paramString1, 2);
    AppMethodBeat.o(109490);
    return true;
  }
  
  private static boolean c(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(109487);
    Context localContext = aj.getContext();
    com.tencent.mm.cr.d.ks(aj.getContext());
    f localf;
    String str1;
    String str2;
    String str3;
    int i;
    String str4;
    if (com.tencent.xweb.f.a(paramString2, com.tencent.xweb.f.a.IMt, false, new Intent()) != com.tencent.xweb.f.a.IMu) {
      if (((b)g.ab(b.class)).a(b.a.ppu, true))
      {
        localf = f.eAG();
        str1 = localf.mFilePath;
        str2 = localf.joX;
        str3 = localf.mFileName;
        i = localf.nNu;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(ce.asQ());
        str4 = i.aEN(paramString1);
        if (!bt.isNullOrNil(str4))
        {
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(str4);
        }
        str4 = ((StringBuilder)localObject).toString();
        if (localf.mDH == null) {
          break label783;
        }
      }
    }
    label783:
    for (Object localObject = HandOffFile.L(localf.mDH);; localObject = null)
    {
      paramString3 = b(localContext, paramString1, paramString2, paramString3, str4, paramInt);
      if (bt.T(localContext, paramString3))
      {
        paramString4 = (String)g.afB().afk().get(ae.a.FvF, "");
        if ((!bt.isNullOrNil(paramString4)) && (bt.kU(str1, paramString4)))
        {
          paramString4 = (String)g.afB().afk().get(ae.a.FvE, "");
          localObject = new StringBuilder();
          if (bt.isNullOrNil(paramString4))
          {
            ((StringBuilder)localObject).append(str4);
            g.afB().afk().set(ae.a.FvE, ((StringBuilder)localObject).toString());
          }
        }
        for (;;)
        {
          g.afB().afk().set(ae.a.FvG, Integer.valueOf(0));
          com.tencent.xweb.f.lY(com.tencent.mm.cr.a.aNq(paramString1), paramString2);
          com.tencent.xweb.f.lZ(paramString2, "QQBROWSER");
          try
          {
            paramString1 = aj.getContext();
            paramString2 = new com.tencent.mm.hellhoundlib.b.a().bd(paramString3);
            com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.adn(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString1.startActivity((Intent)paramString2.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.vKh.f(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt) });
            paramString1 = ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).cFu();
            if (paramString1 != null)
            {
              paramString1.stk = 1;
              paramString1.setKey(HandOff.ES(1));
              ((HandOffFile)paramString1).K(localf.mDH);
              ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).i(paramString1);
            }
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              ad.e("MicroMsg.AppChooserIntentUtil", "startByQb() (by QQBrowserDocumentIntent) Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
            }
          }
          AppMethodBeat.o(109487);
          return false;
          ((StringBuilder)localObject).append(paramString4).append(",").append(str4);
          break;
          g.afB().afk().set(ae.a.FvF, str1);
          g.afB().afk().set(ae.a.FvE, str4);
        }
      }
      paramString3 = f.eAG();
      paramString3.onDestroy();
      paramString3.j(str1, str2, str3, i);
      if (localObject != null) {
        ((HandOffFile)localObject).K(paramString3.mDH);
      }
      paramString3 = M(localContext, paramString4, paramString1);
      if (bt.T(localContext, paramString3))
      {
        com.tencent.xweb.f.lY(com.tencent.mm.cr.a.aNq(paramString1), paramString2);
        com.tencent.xweb.f.lZ(paramString2, "QQBROWSER");
        try
        {
          paramString1 = aj.getContext();
          paramString2 = new com.tencent.mm.hellhoundlib.b.a().bd(paramString3);
          com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.adn(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString1.startActivity((Intent)paramString2.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.vKh.f(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt) });
          AppMethodBeat.o(109487);
          return false;
        }
        catch (Exception paramString1)
        {
          ad.e("MicroMsg.AppChooserIntentUtil", "startByQb() (by QQBrowserIntent) Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
        }
      }
      AppMethodBeat.o(109487);
      return true;
    }
  }
  
  private static boolean hk(Context paramContext)
  {
    AppMethodBeat.i(109501);
    try
    {
      ComponentName localComponentName = new ComponentName("com.tencent.mtt", "com.tencent.mtt.external.reader.ReaderSdkReceive");
      paramContext.getPackageManager().getReceiverInfo(localComponentName, 131072);
      ad.i("MicroMsg.AppChooserIntentUtil", "ifSupportFloatBallInQb() true");
      AppMethodBeat.o(109501);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ad.i("MicroMsg.AppChooserIntentUtil", "ifSupportFloatBallInQb() Exception:%s %s", new Object[] { paramContext.getClass().getSimpleName(), paramContext.getMessage() });
      AppMethodBeat.o(109501);
    }
    return false;
  }
  
  public static boolean i(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(109486);
    Context localContext = aj.getContext();
    Object localObject1 = new com.tencent.mm.vfs.e(paramString1);
    ad.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d fileExt: %s", new Object[] { paramString1, Boolean.valueOf(((com.tencent.mm.vfs.e)localObject1).exists()), Long.valueOf(((com.tencent.mm.vfs.e)localObject1).length()), paramString2 });
    if (!((com.tencent.mm.vfs.e)localObject1).exists())
    {
      ad.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
      AppMethodBeat.o(109486);
      return true;
    }
    String str = aCs(paramString2);
    Object localObject2 = aCp(str);
    localObject1 = localObject2;
    if (((String)localObject2).equals("com.baidu.searchbox"))
    {
      aCq(str);
      localObject1 = "";
    }
    if (!((String)localObject1).equals(""))
    {
      ad.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[] { localObject1 });
      localObject2 = L(localContext, str, paramString1);
      ((Intent)localObject2).setPackage((String)localObject1);
      if (bt.T(localContext, (Intent)localObject2))
      {
        ad.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType %s", new Object[] { str });
        com.tencent.xweb.f.lY(com.tencent.mm.cr.a.aNq(paramString1), paramString2);
        com.tencent.xweb.f.lZ(paramString2, "THIRDAPP");
        paramString1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, paramString1.adn(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooserWhenOnCreate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)paramString1.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooserWhenOnCreate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(109486);
        return false;
      }
      ad.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType %s", new Object[] { str });
    }
    if (!c(paramString1, paramString2, paramString3, str, paramInt))
    {
      ad.i("MicroMsg.AppChooserIntentUtil", "open file by qb");
      AppMethodBeat.o(109486);
      return false;
    }
    if (aCo(paramString2))
    {
      if (paramInt == 7)
      {
        AppMethodBeat.o(109486);
        return true;
      }
      b(localContext, paramString1, paramString2, paramString3, paramInt);
      AppMethodBeat.o(109486);
      return false;
    }
    AppMethodBeat.o(109486);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.a
 * JD-Core Version:    0.7.0.1
 */