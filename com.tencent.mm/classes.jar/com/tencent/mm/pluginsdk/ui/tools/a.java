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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  private static Intent DDs;
  private static WeakReference<Activity> DDt;
  public static HashMap<String, String> DDu;
  public static HashMap<String, String> DDv;
  
  static
  {
    AppMethodBeat.i(109506);
    DDu = new HashMap();
    long l = System.currentTimeMillis();
    for (;;)
    {
      int i;
      try
      {
        String[] arrayOfString1 = i.aSr("assets:///mimetype.txt").split("\n");
        int j = arrayOfString1.length;
        i = 0;
        if (i < j)
        {
          String str = arrayOfString1[i];
          String[] arrayOfString2 = str.split(",");
          if ((arrayOfString2 != null) && (arrayOfString2.length > 1) && (!bs.isNullOrNil(arrayOfString2[0])) && (!bs.isNullOrNil(arrayOfString2[1]))) {
            DDu.put(arrayOfString2[0].trim(), arrayOfString2[1].trim());
          } else {
            ac.i("MicroMsg.AppChooserIntentUtil", "mimeType %s", new Object[] { str });
          }
        }
      }
      catch (IOException localIOException)
      {
        ac.printErrStackTrace("MicroMsg.AppChooserIntentUtil", localIOException, "read mimeType from asset", new Object[0]);
      }
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        DDv = localHashMap;
        localHashMap.put("txt", "mtt/txt");
        DDv.put("epub", "mtt/epub");
        DDv.put("pdf", "mtt/pdf");
        DDv.put("doc", "mtt/doc");
        DDv.put("xls", "mtt/xls");
        DDv.put("ppt", "mtt/ppt");
        DDv.put("docx", "mtt/docx");
        DDv.put("xlsx", "mtt/xlsx");
        DDv.put("pptx", "mtt/pptx");
        DDv.put("chm", "mtt/chm");
        DDv.put("ini", "mtt/ini");
        DDv.put("log", "mtt/log");
        DDv.put("bat", "mtt/bat");
        DDv.put("php", "mtt/php");
        DDv.put("lrc", "mtt/lrc");
        DDv.put("js", "mtt/js");
        AppMethodBeat.o(109506);
        return;
        ac.i("MicroMsg.AppChooserIntentUtil", "read from mimetype text %d %d %d", new Object[] { Integer.valueOf(localHashMap.length), Integer.valueOf(DDu.size()), Long.valueOf(System.currentTimeMillis() - l) });
      }
      i += 1;
    }
  }
  
  private static Intent K(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(109497);
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    m.a(paramContext, localIntent, new com.tencent.mm.vfs.e(paramString2), paramString1);
    try
    {
      ac.i("MicroMsg.AppChooserIntentUtil", "createNormalIntent %s %s %s", new Object[] { paramString1, paramString2, localIntent.toString() });
      label67:
      AppMethodBeat.o(109497);
      return localIntent;
    }
    catch (Exception paramContext)
    {
      break label67;
    }
  }
  
  private static Intent L(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(109498);
    Intent localIntent = new Intent();
    localIntent.setPackage("com.tencent.mtt");
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    m.a(paramContext, localIntent, new com.tencent.mm.vfs.e(paramString2), paramString1);
    try
    {
      ac.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserIntent %s %s %s", new Object[] { paramString1, paramString2, localIntent.toString() });
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
    if (hv(paramContext))
    {
      str = "";
      bool2 = f.eQa().aHQ(paramString1);
      localObject = f.eQa();
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
        ac.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserDocumentIntent menuData:%s", new Object[] { paramString1 });
        paramString3 = paramString1;
      }
      catch (Exception paramString1)
      {
        boolean bool1;
        ac.e("MicroMsg.AppChooserIntentUtil", "createQQBrowserDocumentIntent menuItems jsonObject error" + paramString1.getMessage());
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
      if (!bs.jl(paramInt, 9)) {
        continue;
      }
      b = 3;
      paramIntent.putExtra("key_reader_sdk_sub_id", b);
      ac.d("MicroMsg.AppChooserIntentUtil", "subId:%s", new Object[] { Byte.valueOf(b) });
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
          ac.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI select package name %s and target intent is not null", new Object[] { str });
          localIntent = new Intent(localIntent);
          localIntent.setPackage(str);
          if (bs.ah(paramActivity, localIntent))
          {
            paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
            com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramIntent.aeD(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "handlerResultOfAppChooserUI", "(Landroid/app/Activity;IILandroid/content/Intent;ZIII)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramActivity.startActivity((Intent)paramIntent.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "handlerResultOfAppChooserUI", "(Landroid/app/Activity;IILandroid/content/Intent;ZIII)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if ("com.tencent.mtt".equals(str))
            {
              com.tencent.mm.plugin.report.service.h.wUl.f(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt5) });
              AppMethodBeat.o(109496);
            }
          }
          else
          {
            ac.e("MicroMsg.AppChooserIntentUtil", "Always Intent is not support mimetype");
            if (paramBoolean) {
              a(paramActivity, paramIntent, paramInt3, paramInt4);
            }
          }
          AppMethodBeat.o(109496);
          return;
        }
        ac.e("MicroMsg.AppChooserIntentUtil", "AppChooserUI target intent is null in handlerResultOfAppChooserUI");
        if (paramBoolean) {
          a(paramActivity, paramIntent, paramInt3, paramInt4);
        }
        AppMethodBeat.o(109496);
        return;
      }
      if (4098 == paramInt2)
      {
        ac.e("MicroMsg.AppChooserIntentUtil", "Not Found App Support media type");
        if (paramBoolean)
        {
          a(paramActivity, paramIntent, paramInt3, paramInt4);
          AppMethodBeat.o(109496);
        }
      }
      else if (4097 == paramInt2)
      {
        ac.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is no choice");
        if (paramBoolean)
        {
          a(paramActivity, paramIntent, paramInt3, paramInt4);
          AppMethodBeat.o(109496);
        }
      }
      else
      {
        ac.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is not ok or data is null");
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
    if (DDv.containsKey(""))
    {
      if (!ax.isWifi(paramActivity))
      {
        paramIntent = new com.tencent.mm.ui.widget.a.f.a(ai.getContext());
        paramIntent.aRQ(paramActivity.getString(2131764386)).yi(true).acQ(2131759571);
        paramIntent.c(new f.c()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(184243);
            if (paramAnonymousBoolean)
            {
              paramAnonymousString = new com.tencent.mm.ui.widget.a.f.a(this.val$activity).aRQ(this.val$activity.getString(2131764387));
              paramAnonymousString.JfY = true;
              paramAnonymousString.acQ(2131755792).b(new f.c()
              {
                public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
                {
                  AppMethodBeat.i(184242);
                  w.a.uU(true);
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
      paramActivity = new com.tencent.mm.ui.widget.a.f.a(paramActivity).aRQ(paramActivity.getString(2131764388));
      paramActivity.JfY = true;
      paramActivity.acQ(2131755792).b(new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(184244);
          w.a.uU(true);
          AppMethodBeat.o(184244);
        }
      }).show();
      AppMethodBeat.o(184245);
      return;
    }
    com.tencent.mm.ui.base.h.l(paramActivity, paramInt1, paramInt2);
    AppMethodBeat.o(184245);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(109489);
    Object localObject1 = new com.tencent.mm.vfs.e(paramString1);
    ac.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", new Object[] { paramString1, Boolean.valueOf(((com.tencent.mm.vfs.e)localObject1).exists()), Long.valueOf(((com.tencent.mm.vfs.e)localObject1).length()) });
    if (!((com.tencent.mm.vfs.e)localObject1).exists())
    {
      ac.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
      AppMethodBeat.o(109489);
      return;
    }
    Context localContext = ai.getContext();
    String str = aHK(paramString2);
    Object localObject2 = aHH(str);
    localObject1 = localObject2;
    if (((String)localObject2).equals("com.baidu.searchbox"))
    {
      aHI(str);
      localObject1 = "";
    }
    if (!((String)localObject1).equals(""))
    {
      ac.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[] { localObject1 });
      localObject2 = K(ai.getContext(), str, paramString1);
      ((Intent)localObject2).setPackage((String)localObject1);
      if (bs.ah(localContext, (Intent)localObject2))
      {
        ac.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType %s", new Object[] { str });
        com.tencent.xweb.f.mz(com.tencent.mm.cq.a.aST(paramString1), paramString2);
        com.tencent.xweb.f.mA(paramString2, "THIRDAPP");
        paramActivity = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, paramActivity.aeD(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooser", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)paramActivity.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooser", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(109489);
        return;
      }
      ac.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType %s", new Object[] { str });
    }
    if (!c(paramString1, paramString2, paramString3, str, paramInt))
    {
      ac.i("MicroMsg.AppChooserIntentUtil", "open file by qb");
      AppMethodBeat.o(109489);
      return;
    }
    localObject1 = K(localContext, str, paramString1);
    if (!q.hj(ai.getContext())) {}
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
    String str = aHK(paramString2);
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
      DDs = (Intent)localObject;
      DDt = new WeakReference(paramActivity);
      AppMethodBeat.o(109492);
      return;
      b(paramActivity, paramString1, paramString2, paramString3, paramInt);
    }
  }
  
  private static String aHH(String paramString)
  {
    AppMethodBeat.i(109502);
    paramString = (String)g.agR().agA().get(aHJ(paramString), "");
    AppMethodBeat.o(109502);
    return paramString;
  }
  
  private static void aHI(String paramString)
  {
    AppMethodBeat.i(109503);
    if (!g.agM())
    {
      AppMethodBeat.o(109503);
      return;
    }
    g.agR().agA().set(aHJ(paramString), "");
    AppMethodBeat.o(109503);
  }
  
  private static int aHJ(String paramString)
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
  
  private static String aHK(String paramString)
  {
    AppMethodBeat.i(109505);
    Object localObject1;
    if (bs.isNullOrNil(paramString)) {
      localObject1 = "application/octet-stream";
    }
    for (;;)
    {
      ac.i("MicroMsg.AppChooserIntentUtil", "getMimeTypeByExt fileExt: %s mimeType: %s", new Object[] { paramString, localObject1 });
      AppMethodBeat.o(109505);
      return localObject1;
      localObject1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
      Object localObject2 = localObject1;
      if (bs.isNullOrNil((String)localObject1)) {
        localObject2 = (String)DDu.get(paramString);
      }
      localObject1 = localObject2;
      if (bs.isNullOrNil((String)localObject2)) {
        if (paramString.startsWith("/")) {
          localObject1 = "application/octet-stream";
        } else {
          localObject1 = "application/".concat(String.valueOf(paramString));
        }
      }
    }
  }
  
  public static void aX(Intent paramIntent)
  {
    AppMethodBeat.i(109494);
    try
    {
      boolean bool1 = paramIntent.getBooleanExtra("MINIQB_OPEN_RET_VAL", false);
      paramIntent.getStringExtra("file_path");
      String str2 = paramIntent.getStringExtra("file_ext");
      ac.i("MicroMsg.AppChooserIntentUtil", "miniQB retVal:%b", new Object[] { Boolean.valueOf(bool1) });
      boolean bool2 = g.agM();
      if (!bool2)
      {
        AppMethodBeat.o(109494);
        return;
      }
      String str1 = (String)g.agR().agA().get(ah.a.GIM, "");
      if (!bool1) {
        paramIntent = str1.replace(str2, "");
      }
      for (;;)
      {
        g.agR().agA().set(ah.a.GIM, paramIntent);
        if ((!bool1) && (DDs != null) && (DDt != null) && (DDt.get() != null))
        {
          DDs.setClass((Context)DDt.get(), AppChooserUI.class);
          ((Activity)DDt.get()).startActivityForResult(DDs, 2);
        }
        DDs = null;
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
  
  public static boolean ae(String paramString1, String paramString2, int paramInt)
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
    paramString4 = (String)DDv.get(paramString2);
    paramString3 = paramString4;
    if (bs.isNullOrNil(paramString4)) {
      paramString3 = aHK(paramString2);
    }
    m.a(paramContext, localIntent, new com.tencent.mm.vfs.e(paramString1), paramString3);
    try
    {
      ac.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserDocumentIntent %s %s %s %s %s %s", new Object[] { paramString3, paramString1, localIntent.toString(), localIntent.getExtras(), paramString2, Integer.valueOf(paramInt) });
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
    localIntent.setComponent(new ComponentName(e.l.Hhq, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE");
    paramContext.sendBroadcast(localIntent);
    AppMethodBeat.o(109493);
  }
  
  public static void b(MMActivity paramMMActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(109491);
    String str = aHK(paramString2);
    aHI(str);
    Uri localUri = m.a(paramMMActivity, new com.tencent.mm.vfs.e(paramString1));
    Bundle localBundle = new Bundle();
    Intent localIntent = K(paramMMActivity, str, paramString1);
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
    com.tencent.mm.br.d.a(paramMMActivity, ".pluginsdk.ui.tools.AppChooserUI", paramString1, 2, new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(109484);
        a.a(this.val$activity, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent, true, 2131758111, 2131758112, this.fsL);
        AppMethodBeat.o(109484);
      }
    });
    AppMethodBeat.o(109491);
  }
  
  public static boolean c(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109490);
    String str = aHK(paramString2);
    Uri localUri = m.a(paramActivity, new com.tencent.mm.vfs.e(paramString1));
    Bundle localBundle = new Bundle();
    Intent localIntent = K(paramActivity, str, paramString1);
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
    Context localContext = ai.getContext();
    com.tencent.mm.cq.d.kE(ai.getContext());
    f localf;
    String str1;
    String str2;
    String str3;
    int i;
    String str4;
    if (com.tencent.xweb.f.a(paramString2, com.tencent.xweb.f.a.KyM, false, new Intent()) != com.tencent.xweb.f.a.KyN) {
      if (((b)g.ab(b.class)).a(b.a.pTf, true))
      {
        localf = f.eQa();
        str1 = localf.mFilePath;
        str2 = localf.jPj;
        str3 = localf.mFileName;
        i = localf.oqw;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(ce.azH());
        str4 = i.aKe(paramString1);
        if (!bs.isNullOrNil(str4))
        {
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(str4);
        }
        str4 = ((StringBuilder)localObject).toString();
        if (localf.nfN == null) {
          break label783;
        }
      }
    }
    label783:
    for (Object localObject = HandOffFile.L(localf.nfN);; localObject = null)
    {
      paramString3 = b(localContext, paramString1, paramString2, paramString3, str4, paramInt);
      if (bs.ah(localContext, paramString3))
      {
        paramString4 = (String)g.agR().agA().get(ah.a.GTz, "");
        if ((!bs.isNullOrNil(paramString4)) && (bs.lr(str1, paramString4)))
        {
          paramString4 = (String)g.agR().agA().get(ah.a.GTy, "");
          localObject = new StringBuilder();
          if (bs.isNullOrNil(paramString4))
          {
            ((StringBuilder)localObject).append(str4);
            g.agR().agA().set(ah.a.GTy, ((StringBuilder)localObject).toString());
          }
        }
        for (;;)
        {
          g.agR().agA().set(ah.a.GTA, Integer.valueOf(0));
          com.tencent.xweb.f.mz(com.tencent.mm.cq.a.aST(paramString1), paramString2);
          com.tencent.xweb.f.mA(paramString2, "QQBROWSER");
          try
          {
            paramString1 = ai.getContext();
            paramString2 = new com.tencent.mm.hellhoundlib.b.a().ba(paramString3);
            com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.aeD(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString1.startActivity((Intent)paramString2.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.wUl.f(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt) });
            paramString1 = ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).cSE();
            if (paramString1 != null)
            {
              paramString1.tBa = 1;
              paramString1.setKey(HandOff.GO(1));
              ((HandOffFile)paramString1).K(localf.nfN);
              ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).i(paramString1);
            }
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              ac.e("MicroMsg.AppChooserIntentUtil", "startByQb() (by QQBrowserDocumentIntent) Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
            }
          }
          AppMethodBeat.o(109487);
          return false;
          ((StringBuilder)localObject).append(paramString4).append(",").append(str4);
          break;
          g.agR().agA().set(ah.a.GTz, str1);
          g.agR().agA().set(ah.a.GTy, str4);
        }
      }
      paramString3 = f.eQa();
      paramString3.onDestroy();
      paramString3.j(str1, str2, str3, i);
      if (localObject != null) {
        ((HandOffFile)localObject).K(paramString3.nfN);
      }
      paramString3 = L(localContext, paramString4, paramString1);
      if (bs.ah(localContext, paramString3))
      {
        com.tencent.xweb.f.mz(com.tencent.mm.cq.a.aST(paramString1), paramString2);
        com.tencent.xweb.f.mA(paramString2, "QQBROWSER");
        try
        {
          paramString1 = ai.getContext();
          paramString2 = new com.tencent.mm.hellhoundlib.b.a().ba(paramString3);
          com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.aeD(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString1.startActivity((Intent)paramString2.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.wUl.f(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt) });
          AppMethodBeat.o(109487);
          return false;
        }
        catch (Exception paramString1)
        {
          ac.e("MicroMsg.AppChooserIntentUtil", "startByQb() (by QQBrowserIntent) Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
        }
      }
      AppMethodBeat.o(109487);
      return true;
    }
  }
  
  private static boolean hv(Context paramContext)
  {
    AppMethodBeat.i(109501);
    try
    {
      ComponentName localComponentName = new ComponentName("com.tencent.mtt", "com.tencent.mtt.external.reader.ReaderSdkReceive");
      paramContext.getPackageManager().getReceiverInfo(localComponentName, 131072);
      ac.i("MicroMsg.AppChooserIntentUtil", "ifSupportFloatBallInQb() true");
      AppMethodBeat.o(109501);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ac.i("MicroMsg.AppChooserIntentUtil", "ifSupportFloatBallInQb() Exception:%s %s", new Object[] { paramContext.getClass().getSimpleName(), paramContext.getMessage() });
      AppMethodBeat.o(109501);
    }
    return false;
  }
  
  public static boolean i(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(109486);
    Context localContext = ai.getContext();
    Object localObject1 = new com.tencent.mm.vfs.e(paramString1);
    ac.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d fileExt: %s", new Object[] { paramString1, Boolean.valueOf(((com.tencent.mm.vfs.e)localObject1).exists()), Long.valueOf(((com.tencent.mm.vfs.e)localObject1).length()), paramString2 });
    if (!((com.tencent.mm.vfs.e)localObject1).exists())
    {
      ac.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
      AppMethodBeat.o(109486);
      return true;
    }
    String str2 = aHK(paramString2);
    Object localObject2 = aHH(str2);
    localObject1 = localObject2;
    if (((String)localObject2).equals("com.baidu.searchbox"))
    {
      aHI(str2);
      localObject1 = "";
    }
    if (!((String)localObject1).equals(""))
    {
      ac.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[] { localObject1 });
      localObject2 = K(localContext, str2, paramString1);
      ((Intent)localObject2).setPackage((String)localObject1);
      if (!bs.ah(localContext, (Intent)localObject2)) {
        break label359;
      }
      ac.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType %s", new Object[] { str2 });
      com.tencent.xweb.f.mz(com.tencent.mm.cq.a.aST(paramString1), paramString2);
      com.tencent.xweb.f.mA(paramString2, "THIRDAPP");
      try
      {
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooserWhenOnCreate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooserWhenOnCreate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(109486);
        return false;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.AppChooserIntentUtil", "Always package, Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    while (!c(paramString1, paramString2, paramString3, str2, paramInt))
    {
      ac.i("MicroMsg.AppChooserIntentUtil", "open file by qb");
      AppMethodBeat.o(109486);
      return false;
      label359:
      ac.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType %s", new Object[] { str2 });
    }
    int i;
    if (!bs.isNullOrNil(paramString2))
    {
      String str1 = (String)g.agR().agA().get(ah.a.GIM, "");
      if ((!bs.isNullOrNil(str1)) && (str1.contains(paramString2))) {
        i = 1;
      }
    }
    while (i != 0) {
      if (paramInt == 7)
      {
        AppMethodBeat.o(109486);
        return true;
        i = 0;
      }
      else
      {
        b(localContext, paramString1, paramString2, paramString3, paramInt);
        AppMethodBeat.o(109486);
        return false;
      }
    }
    AppMethodBeat.o(109486);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.a
 * JD-Core Version:    0.7.0.1
 */