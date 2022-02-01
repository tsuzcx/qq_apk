package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.cr.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.e.n;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.f;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static Intent Ksv;
  private static WeakReference<Activity> Ksw;
  public static HashMap<String, String> Ksx;
  public static HashMap<String, String> Ksy;
  
  static
  {
    AppMethodBeat.i(109506);
    Ksx = new HashMap();
    long l = System.currentTimeMillis();
    for (;;)
    {
      int i;
      try
      {
        String[] arrayOfString1 = s.boY("assets:///mimetype.txt").split("\n");
        int j = arrayOfString1.length;
        i = 0;
        if (i < j)
        {
          String str = arrayOfString1[i];
          String[] arrayOfString2 = str.split(",");
          if ((arrayOfString2 != null) && (arrayOfString2.length > 1) && (!Util.isNullOrNil(arrayOfString2[0])) && (!Util.isNullOrNil(arrayOfString2[1]))) {
            Ksx.put(arrayOfString2[0].trim(), arrayOfString2[1].trim());
          } else {
            Log.i("MicroMsg.AppChooserIntentUtil", "mimeType %s", new Object[] { str });
          }
        }
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.AppChooserIntentUtil", localIOException, "read mimeType from asset", new Object[0]);
      }
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        Ksy = localHashMap;
        localHashMap.put("txt", "mtt/txt");
        Ksy.put("epub", "mtt/epub");
        Ksy.put("pdf", "mtt/pdf");
        Ksy.put("doc", "mtt/doc");
        Ksy.put("xls", "mtt/xls");
        Ksy.put("ppt", "mtt/ppt");
        Ksy.put("docx", "mtt/docx");
        Ksy.put("xlsx", "mtt/xlsx");
        Ksy.put("pptx", "mtt/pptx");
        Ksy.put("chm", "mtt/chm");
        Ksy.put("ini", "mtt/ini");
        Ksy.put("log", "mtt/log");
        Ksy.put("bat", "mtt/bat");
        Ksy.put("php", "mtt/php");
        Ksy.put("lrc", "mtt/lrc");
        Ksy.put("js", "mtt/js");
        AppMethodBeat.o(109506);
        return;
        Log.i("MicroMsg.AppChooserIntentUtil", "read from mimetype text %d %d %d", new Object[] { Integer.valueOf(localHashMap.length), Integer.valueOf(Ksx.size()), Long.valueOf(System.currentTimeMillis() - l) });
      }
      i += 1;
    }
  }
  
  private static Intent S(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(109497);
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    FileProviderHelper.setIntentDataAndType(paramContext, localIntent, new o(paramString2), paramString1, false);
    try
    {
      Log.i("MicroMsg.AppChooserIntentUtil", "createNormalIntent %s %s %s", new Object[] { paramString1, paramString2, localIntent.toString() });
      label68:
      AppMethodBeat.o(109497);
      return localIntent;
    }
    catch (Exception paramContext)
    {
      break label68;
    }
  }
  
  private static Intent T(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(109498);
    Intent localIntent = new Intent();
    localIntent.setPackage("com.tencent.mtt");
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    FileProviderHelper.setIntentDataAndType(paramContext, localIntent, new o(paramString2), paramString1, false);
    try
    {
      Log.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserIntent %s %s %s", new Object[] { paramString1, paramString2, localIntent.toString() });
      label75:
      AppMethodBeat.o(109498);
      return localIntent;
    }
    catch (Exception paramContext)
    {
      break label75;
    }
  }
  
  private static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, ach paramach)
  {
    AppMethodBeat.i(204772);
    Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document");
    localIntent.setPackage("com.tencent.mtt");
    localIntent.addFlags(268435456);
    localIntent.putExtra("ChannelID", "com.tencent.mm");
    localIntent.putExtra("PosID", 4);
    localIntent.putExtra("key_reader_sdk_id", 1);
    localIntent.putExtra("key_reader_sdk_type", 0);
    localIntent.putExtra("key_reader_sdk_format", paramString2);
    localIntent.putExtra("key_reader_sdk_path", paramString1);
    a(localIntent, paramContext, paramString1, paramString2, paramString3, paramString4, paramInt, paramach);
    paramString4 = (String)Ksy.get(paramString2);
    paramString3 = paramString4;
    if (Util.isNullOrNil(paramString4)) {
      paramString3 = bfm(paramString2);
    }
    FileProviderHelper.setIntentDataAndType(paramContext, localIntent, new o(paramString1), paramString3, false);
    try
    {
      Log.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserDocumentIntent %s %s %s %s %s %s", new Object[] { paramString3, paramString1, localIntent.toString(), localIntent.getExtras(), paramString2, Integer.valueOf(paramInt) });
      label196:
      AppMethodBeat.o(204772);
      return localIntent;
    }
    catch (Exception paramContext)
    {
      break label196;
    }
  }
  
  private static Intent a(Intent paramIntent, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, ach paramach)
  {
    AppMethodBeat.i(204773);
    boolean bool1;
    if (iA(paramContext))
    {
      if (!Util.isNullOrNil(paramString1)) {
        break label770;
      }
      Log.w("MicroMsg.AppChooserIntentUtil", "isEnableAppBrandOpenMaterial, filePath is empty");
      bool1 = false;
      h.gsv().b(paramString1, paramString2, paramString3, paramInt, paramach);
    }
    for (;;)
    {
      try
      {
        paramString3 = new JSONObject();
        paramString3.put("pkgName", paramContext.getPackageName());
        paramString3.put("className", "com.tencent.mm.ui.tools.QbCallBackBroadcast");
        paramString3.put("broadcast", true);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("type", "qb");
        ((JSONObject)localObject).put("filePath", paramString1);
        ((JSONObject)localObject).put("fileExt", paramString2);
        ((JSONObject)localObject).put("sence", paramInt);
        ((JSONObject)localObject).put("verify", paramString4);
        paramString3.put("thirdCtx", localObject);
        paramString1 = new JSONObject();
        paramString1.put("id", 4);
        paramString1.put("iconResId", 0);
        paramString1.put("text", paramContext.getString(2131759412));
        paramString1.put("isShow", true);
        paramString1.put("idx", 1);
        paramString4 = new JSONObject();
        paramString4.put("id", 3);
        paramString4.put("iconResId", 2);
        paramString4.put("text", paramContext.getString(2131759414));
        if ((((com.tencent.mm.plugin.handoff.a.a)g.af(com.tencent.mm.plugin.handoff.a.a.class)).dYl()) && (HandOffFile.isSupportOpenFile(paramString2)))
        {
          bool2 = true;
          paramString4.put("isShow", bool2);
          paramString4.put("idx", 1);
          paramString2 = new ArrayList();
          paramString2.add(paramString1);
          paramString2.add(paramString4);
          if (bool1)
          {
            paramString1 = new JSONObject();
            paramString1.put("id", 5);
            paramString1.put("iconResId", 3);
            paramString1.put("text", paramContext.getString(2131755575));
            paramString1.put("isShow", true);
            paramString1.put("idx", 1);
            paramString2.add(paramString1);
          }
          paramString3.put("menuItems", new JSONArray(paramString2));
          if ((paramach != null) && (!Util.isNullOrNil(paramach.toByteArray())) && (paramach.LmQ != null) && (!Util.isNullOrNil(paramach.LmQ.toByteArray()))) {
            continue;
          }
          paramString3.put("from", "");
          paramString1 = new JSONObject();
          paramString1.put("id", 10);
          paramString3.put("activityStatusItems", paramString1);
          paramString1 = new JSONObject();
          paramString1.put("id", 11);
          paramString2 = new JSONObject();
          paramString2.put("id", 12);
          paramString3.put("changeFileItems", paramString1);
          paramString3.put("menuBottom", true);
          paramString3.put("notifyReadProgressId", paramString2);
          paramString1 = paramString3.toString();
        }
      }
      catch (Exception paramString2)
      {
        Object localObject;
        boolean bool2;
        label770:
        MaterialModel localMaterialModel;
        AppBrandOpenMaterialCollection localAppBrandOpenMaterialCollection;
        paramString1 = "";
        Log.e("MicroMsg.AppChooserIntentUtil", "createQQBrowserDocumentIntent menuItems jsonObject error" + paramString2.getMessage());
        continue;
      }
      try
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserDocumentIntent menuData:%s", new Object[] { paramString1 });
        paramString2 = new ArrayList();
        paramString3 = new BitmapFactory.Options();
        paramString3.inScaled = false;
        paramString4 = BitmapFactory.decodeResource(paramContext.getResources(), 2131232768, paramString3);
        paramach = BitmapFactory.decodeResource(paramContext.getResources(), 2131233106, paramString3);
        paramString2.add(0, paramString4);
        paramString2.add(1, paramach);
        if (bool1) {
          paramString2.add(2, BitmapFactory.decodeResource(paramContext.getResources(), 2131233103, paramString3));
        }
        paramContext = new Bundle();
        paramContext.putParcelableArrayList("resArray", paramString2);
        paramContext.putString("menuData", paramString1);
        paramContext.putString("style", "0");
        paramIntent.putExtra("key_thirdcall_sdk_extrals", paramContext);
        if (!Util.isEqual(paramInt, 9)) {
          break label1052;
        }
        b = 3;
      }
      catch (Exception paramString2)
      {
        continue;
        b = 1;
        continue;
      }
      paramIntent.putExtra("key_reader_sdk_sub_id", b);
      Log.d("MicroMsg.AppChooserIntentUtil", "subId:%s", new Object[] { Byte.valueOf(b) });
      AppMethodBeat.o(204773);
      return paramIntent;
      localObject = (i)g.af(i.class);
      if (localObject == null)
      {
        Log.w("MicroMsg.AppChooserIntentUtil", "isEnableAppBrandOpenMaterial, openMaterialService is null");
        bool1 = false;
        break;
      }
      if (!((i)localObject).c(com.tencent.mm.plugin.appbrand.openmaterial.model.b.nlP))
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "isEnableAppBrandOpenMaterial, openMaterialService is not enabled");
        bool1 = false;
        break;
      }
      localMaterialModel = MaterialModel.eC(paramString1, paramString2);
      if (localMaterialModel == null)
      {
        Log.w("MicroMsg.AppChooserIntentUtil", "isEnableAppBrandOpenMaterial, materialModel is null");
        bool1 = false;
        break;
      }
      if (!((i)localObject).adl(localMaterialModel.mimeType))
      {
        Log.w("MicroMsg.AppChooserIntentUtil", "isEnableAppBrandOpenMaterial, openMaterialService is not support " + localMaterialModel.mimeType);
        bool1 = false;
        break;
      }
      localAppBrandOpenMaterialCollection = ((i)localObject).a(localMaterialModel);
      if (!localAppBrandOpenMaterialCollection.nlF.isEmpty())
      {
        bool1 = true;
        Log.i("MicroMsg.AppChooserIntentUtil", "isEnableAppBrandOpenMaterial, isEnabled: ".concat(String.valueOf(bool1)));
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (!((i)localObject).a(localMaterialModel, localAppBrandOpenMaterialCollection))
          {
            Log.w("MicroMsg.AppChooserIntentUtil", "isEnableAppBrandOpenMaterial, saveOpenMaterialCollection fail");
            bool2 = false;
          }
        }
        bool1 = bool2;
        break;
      }
      bool1 = false;
      continue;
      bool2 = false;
      continue;
      paramString3.put("from", "multitask");
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
          Log.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI select package name %s and target intent is not null", new Object[] { str });
          localIntent = new Intent(localIntent);
          localIntent.setPackage(str);
          if (Util.isIntentAvailable(paramActivity, localIntent))
          {
            paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
            com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramIntent.axQ(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "handlerResultOfAppChooserUI", "(Landroid/app/Activity;IILandroid/content/Intent;ZIII)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramActivity.startActivity((Intent)paramIntent.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "handlerResultOfAppChooserUI", "(Landroid/app/Activity;IILandroid/content/Intent;ZIII)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if ("com.tencent.mtt".equals(str))
            {
              com.tencent.mm.plugin.report.service.h.CyF.a(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt5) });
              AppMethodBeat.o(109496);
            }
          }
          else
          {
            Log.e("MicroMsg.AppChooserIntentUtil", "Always Intent is not support mimetype");
            if (paramBoolean) {
              a(paramActivity, paramIntent, paramInt3, paramInt4);
            }
          }
          AppMethodBeat.o(109496);
          return;
        }
        Log.e("MicroMsg.AppChooserIntentUtil", "AppChooserUI target intent is null in handlerResultOfAppChooserUI");
        if (paramBoolean) {
          a(paramActivity, paramIntent, paramInt3, paramInt4);
        }
        AppMethodBeat.o(109496);
        return;
      }
      if (4098 == paramInt2)
      {
        Log.e("MicroMsg.AppChooserIntentUtil", "Not Found App Support media type");
        if (paramBoolean)
        {
          a(paramActivity, paramIntent, paramInt3, paramInt4);
          AppMethodBeat.o(109496);
        }
      }
      else if (4097 == paramInt2)
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is no choice");
        if (paramBoolean)
        {
          a(paramActivity, paramIntent, paramInt3, paramInt4);
          AppMethodBeat.o(109496);
        }
      }
      else
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is not ok or data is null");
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
    if (Ksy.containsKey(""))
    {
      if (!NetStatusUtil.isWifi(paramActivity))
      {
        paramIntent = new com.tencent.mm.ui.widget.a.f.a(MMApplicationContext.getContext());
        paramIntent.bow(paramActivity.getString(2131766647)).Dq(true).apa(2131760888);
        paramIntent.c(new a.3(paramActivity)).b(new a.2()).show();
        AppMethodBeat.o(184245);
        return;
      }
      paramActivity = new com.tencent.mm.ui.widget.a.f.a(paramActivity).bow(paramActivity.getString(2131766649));
      paramActivity.JnN = true;
      paramActivity.apa(2131755873).b(new a.4()).show();
      AppMethodBeat.o(184245);
      return;
    }
    com.tencent.mm.ui.base.h.n(paramActivity, paramInt1, paramInt2);
    AppMethodBeat.o(184245);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(109489);
    a(paramActivity, paramString1, paramString2, paramString3, paramInt, null);
    AppMethodBeat.o(109489);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt, ach paramach)
  {
    AppMethodBeat.i(204770);
    Object localObject1 = new o(paramString1);
    Log.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", new Object[] { paramString1, Boolean.valueOf(((o)localObject1).exists()), Long.valueOf(((o)localObject1).length()) });
    if (!((o)localObject1).exists())
    {
      Log.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
      AppMethodBeat.o(204770);
      return;
    }
    Context localContext = MMApplicationContext.getContext();
    String str = bfm(paramString2);
    Object localObject2 = bfj(str);
    localObject1 = localObject2;
    if (((String)localObject2).equals("com.baidu.searchbox"))
    {
      bfk(str);
      localObject1 = "";
    }
    if (!((String)localObject1).equals(""))
    {
      Log.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[] { localObject1 });
      if (("com.tencent.mtt".equals(localObject1)) && (!b(paramString1, paramString2, paramString3, str, paramInt)))
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "open file by qb(default)");
        AppMethodBeat.o(204770);
        return;
      }
      localObject2 = S(MMApplicationContext.getContext(), str, paramString1);
      ((Intent)localObject2).setPackage((String)localObject1);
      if (paramach != null) {}
      try
      {
        ((Intent)localObject2).putExtra("key_multi_task_common_info", paramach.toByteArray());
        if (Util.isIntentAvailable(localContext, (Intent)localObject2))
        {
          Log.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType %s", new Object[] { str });
          f.nX(com.tencent.mm.cr.a.bpF(paramString1), paramString2);
          f.nY(paramString2, "THIRDAPP");
          paramActivity = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localContext, paramActivity.axQ(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooser", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramActivity.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooser", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(204770);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.AppChooserIntentUtil", "invoke startAppChooserWhenOnCreate Exception! Error:%s", new Object[] { localException.getMessage() });
        }
        Log.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType %s", new Object[] { str });
      }
    }
    if (!a(paramString1, paramString2, paramString3, str, paramInt, paramach))
    {
      Log.i("MicroMsg.AppChooserIntentUtil", "open file by qb");
      AppMethodBeat.o(204770);
      return;
    }
    paramach = S(localContext, str, paramString1);
    if (!r.io(MMApplicationContext.getContext())) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramActivity, paramString1, paramString2, paramString3, paramach, paramInt, bool);
      AppMethodBeat.o(204770);
      return;
    }
  }
  
  private static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(109492);
    String str = bfm(paramString2);
    Object localObject = FileProviderHelper.getUriForFile(paramActivity, new o(paramString1));
    Bundle localBundle = new Bundle();
    if (localObject != null) {
      localBundle.putString("targeturl", ((Uri)localObject).toString());
    }
    localBundle.putString("filepath", paramString1);
    localBundle.putString("fileext", paramString2);
    localBundle.putParcelable("targetintent", paramIntent);
    localObject = new Intent();
    ((Intent)localObject).putExtra("type", 0);
    ((Intent)localObject).putExtra("title", paramActivity.getResources().getString(2131757562));
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
      ((com.tencent.mm.choosemsgfile.compat.a)g.af(com.tencent.mm.choosemsgfile.compat.a.class)).g(paramActivity, paramString1, paramString2);
    }
    for (;;)
    {
      Ksv = (Intent)localObject;
      Ksw = new WeakReference(paramActivity);
      AppMethodBeat.o(109492);
      return;
      a(paramActivity, paramString1, paramString2, paramString3, paramInt, null);
    }
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, ach paramach)
  {
    AppMethodBeat.i(204771);
    Intent localIntent = new Intent();
    localIntent.putExtra("file_path", paramString1);
    localIntent.putExtra("file_ext", paramString2);
    localIntent.putExtra("file_name", paramString3);
    localIntent.putExtra("sence", paramInt);
    if (paramach != null) {}
    try
    {
      localIntent.putExtra("key_multi_task_common_info", paramach.toByteArray());
      localIntent.addFlags(268435456);
      localIntent.setComponent(new ComponentName(e.n.Ozn, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
      localIntent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE");
      paramContext.sendBroadcast(localIntent);
      AppMethodBeat.o(204771);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppChooserIntentUtil", "invoke openByMiniQB Exception! Error:%s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt, ach paramach)
  {
    AppMethodBeat.i(204764);
    boolean bool = a(paramString1, paramString2, "", paramInt, paramach);
    AppMethodBeat.o(204764);
    return bool;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, int paramInt, ach paramach)
  {
    AppMethodBeat.i(204766);
    Context localContext = MMApplicationContext.getContext();
    Object localObject = new o(paramString1);
    Log.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d fileExt: %s", new Object[] { paramString1, Boolean.valueOf(((o)localObject).exists()), Long.valueOf(((o)localObject).length()), paramString2 });
    if (!((o)localObject).exists())
    {
      Log.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
      AppMethodBeat.o(204766);
      return true;
    }
    String str2 = bfm(paramString2);
    localObject = bfj(str2);
    if (((String)localObject).equals("com.baidu.searchbox"))
    {
      bfk(str2);
      localObject = "";
    }
    for (;;)
    {
      if (!((String)localObject).equals(""))
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[] { localObject });
        if (("com.tencent.mtt".equals(localObject)) && (!a(paramString1, paramString2, paramString3, str2, paramInt, true, paramach)))
        {
          Log.i("MicroMsg.AppChooserIntentUtil", "open file by qb(default)");
          AppMethodBeat.o(204766);
          return false;
        }
        Intent localIntent = S(localContext, str2, paramString1);
        localIntent.setPackage((String)localObject);
        if (paramach != null) {}
        try
        {
          localIntent.putExtra("key_multi_task_common_info", paramach.toByteArray());
          if (Util.isIntentAvailable(localContext, localIntent))
          {
            Log.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType %s", new Object[] { str2 });
            f.nX(com.tencent.mm.cr.a.bpF(paramString1), paramString2);
            f.nY(paramString2, "THIRDAPP");
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            try
            {
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
              com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooserWhenOnCreate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooserWhenOnCreate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(204766);
              return false;
            }
            catch (Exception localException2)
            {
              Log.e("MicroMsg.AppChooserIntentUtil", "Always package, Exception:%s %s", new Object[] { localException2.getClass().getSimpleName(), localException2.getMessage() });
            }
            localException1 = localException1;
            Log.e("MicroMsg.AppChooserIntentUtil", "invoke startAppChooserWhenOnCreate Exception! Error:%s", new Object[] { localException1.getMessage() });
          }
        }
      }
      while (!a(paramString1, paramString2, paramString3, str2, paramInt, paramach))
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "open file by qb");
        AppMethodBeat.o(204766);
        return false;
        Log.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType %s", new Object[] { str2 });
      }
      int i;
      if (!Util.isNullOrNil(paramString2))
      {
        String str1 = (String)g.aAh().azQ().get(ar.a.NXD, "");
        if ((!Util.isNullOrNil(str1)) && (str1.contains(paramString2))) {
          i = 1;
        }
      }
      while (i != 0) {
        if (paramInt == 7)
        {
          AppMethodBeat.o(204766);
          return true;
          i = 0;
        }
        else
        {
          a(localContext, paramString1, paramString2, paramString3, paramInt, paramach);
          AppMethodBeat.o(204766);
          return false;
        }
      }
      AppMethodBeat.o(204766);
      return true;
    }
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, ach paramach)
  {
    AppMethodBeat.i(204767);
    boolean bool = a(paramString1, paramString2, paramString3, paramString4, paramInt, false, paramach);
    AppMethodBeat.o(204767);
    return bool;
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean, ach paramach)
  {
    AppMethodBeat.i(204769);
    Context localContext = MMApplicationContext.getContext();
    d.kT(MMApplicationContext.getContext());
    h localh;
    String str1;
    String str2;
    String str3;
    int i;
    String str4;
    if ((f.a(paramString2, com.tencent.xweb.f.a.SyT, false, new Intent()) != com.tencent.xweb.f.a.SyU) || (paramBoolean)) {
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYa, true))
      {
        localh = h.gsv();
        str1 = localh.mFilePath;
        str2 = localh.nhr;
        str3 = localh.mFileName;
        i = localh.qpr;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(cl.aWy());
        str4 = s.bhK(paramString1);
        if (!Util.isNullOrNil(str4))
        {
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(str4);
        }
        str4 = ((StringBuilder)localObject).toString();
        if (localh.Abp == null) {
          break label831;
        }
      }
    }
    label831:
    for (Object localObject = HandOffFile.fromMultiTask(localh.Abp);; localObject = null)
    {
      paramString3 = a(localContext, paramString1, paramString2, paramString3, str4, paramInt, paramach);
      if (Util.isIntentAvailable(localContext, paramString3))
      {
        paramString4 = (String)g.aAh().azQ().get(ar.a.Ojk, "");
        if ((!Util.isNullOrNil(paramString4)) && (Util.isEqual(str1, paramString4)))
        {
          paramString4 = (String)g.aAh().azQ().get(ar.a.Ojj, "");
          paramach = new StringBuilder();
          if (Util.isNullOrNil(paramString4))
          {
            paramach.append(str4);
            g.aAh().azQ().set(ar.a.Ojj, paramach.toString());
          }
        }
        for (;;)
        {
          g.aAh().azQ().set(ar.a.Ojl, Integer.valueOf(0));
          f.nX(com.tencent.mm.cr.a.bpF(paramString1), paramString2);
          f.nY(paramString2, "QQBROWSER");
          try
          {
            paramString1 = MMApplicationContext.getContext();
            paramString2 = new com.tencent.mm.hellhoundlib.b.a().bl(paramString3);
            com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.axQ(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString1.startActivity((Intent)paramString2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.CyF.a(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt) });
            paramString2 = localh.Abp;
            paramString1 = null;
            if (paramString2 != null) {
              paramString1 = ((com.tencent.mm.plugin.handoff.a.a)g.af(com.tencent.mm.plugin.handoff.a.a.class)).aBx(paramString2.field_id);
            }
            paramString2 = paramString1;
            if (paramString1 == null) {
              paramString2 = ((com.tencent.mm.plugin.handoff.a.a)g.af(com.tencent.mm.plugin.handoff.a.a.class)).dYm();
            }
            if ((paramString2 instanceof HandOffFile))
            {
              paramString2.setHandOffType(1);
              paramString2.setKey(HandOff.generateKey(1, 1));
              ((HandOffFile)paramString2).saveToMultiTaskInfo(localh.Abp);
              ((com.tencent.mm.plugin.handoff.a.a)g.af(com.tencent.mm.plugin.handoff.a.a.class)).j(paramString2);
            }
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              Log.e("MicroMsg.AppChooserIntentUtil", "startByQb() (by QQBrowserDocumentIntent) Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
            }
          }
          AppMethodBeat.o(204769);
          return false;
          paramach.append(paramString4).append(",").append(str4);
          break;
          g.aAh().azQ().set(ar.a.Ojk, str1);
          g.aAh().azQ().set(ar.a.Ojj, str4);
        }
      }
      paramString3 = h.gsv();
      paramString3.b(str1, str2, str3, i, paramach);
      if (localObject != null) {
        ((HandOffFile)localObject).saveToMultiTaskInfo(paramString3.Abp);
      }
      paramString3 = T(localContext, paramString4, paramString1);
      if (Util.isIntentAvailable(localContext, paramString3))
      {
        f.nX(com.tencent.mm.cr.a.bpF(paramString1), paramString2);
        f.nY(paramString2, "QQBROWSER");
        try
        {
          paramString1 = MMApplicationContext.getContext();
          paramString2 = new com.tencent.mm.hellhoundlib.b.a().bl(paramString3);
          com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.axQ(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString1.startActivity((Intent)paramString2.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.CyF.a(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt) });
          AppMethodBeat.o(204769);
          return false;
        }
        catch (Exception paramString1)
        {
          Log.e("MicroMsg.AppChooserIntentUtil", "startByQb() (by QQBrowserIntent) Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
        }
      }
      AppMethodBeat.o(204769);
      return true;
    }
  }
  
  public static boolean ao(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109485);
    boolean bool = a(paramString1, paramString2, "", paramInt, null);
    AppMethodBeat.o(109485);
    return bool;
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109488);
    a(paramActivity, paramString1, paramString2, "", paramInt);
    AppMethodBeat.o(109488);
  }
  
  public static void b(MMActivity paramMMActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(109491);
    String str = bfm(paramString2);
    bfk(str);
    Uri localUri = FileProviderHelper.getUriForFile(paramMMActivity, new o(paramString1));
    Bundle localBundle = new Bundle();
    Intent localIntent = S(paramMMActivity, str, paramString1);
    localBundle.putString("targeturl", localUri.toString());
    localBundle.putString("filepath", paramString1);
    localBundle.putString("fileext", paramString2);
    localBundle.putParcelable("targetintent", localIntent);
    paramString1 = new Intent();
    paramString1.putExtra("type", 0);
    paramString1.putExtra("title", paramMMActivity.getResources().getString(2131757562));
    paramString1.putExtra("mimetype", str);
    paramString1.putExtra("targetintent", localIntent);
    paramString1.putExtra("transferback", localBundle);
    paramString1.putExtra("scene", 8);
    paramString1.putExtra("openWay", true);
    c.a(paramMMActivity, ".pluginsdk.ui.tools.AppChooserUI", paramString1, 2, new MMActivity.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(109484);
        a.a(this.val$activity, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent, true, 2131758379, 2131758380, this.gsA);
        AppMethodBeat.o(109484);
      }
    });
    AppMethodBeat.o(109491);
  }
  
  private static boolean b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(204768);
    boolean bool = a(paramString1, paramString2, paramString3, paramString4, paramInt, true, null);
    AppMethodBeat.o(204768);
    return bool;
  }
  
  private static String bfj(String paramString)
  {
    AppMethodBeat.i(109502);
    paramString = (String)g.aAh().azQ().get(bfl(paramString), "");
    AppMethodBeat.o(109502);
    return paramString;
  }
  
  private static void bfk(String paramString)
  {
    AppMethodBeat.i(109503);
    if (!g.aAc())
    {
      AppMethodBeat.o(109503);
      return;
    }
    g.aAh().azQ().set(bfl(paramString), "");
    AppMethodBeat.o(109503);
  }
  
  private static int bfl(String paramString)
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
  
  private static String bfm(String paramString)
  {
    AppMethodBeat.i(109505);
    Object localObject1;
    if (Util.isNullOrNil(paramString)) {
      localObject1 = "application/octet-stream";
    }
    for (;;)
    {
      Log.i("MicroMsg.AppChooserIntentUtil", "getMimeTypeByExt fileExt: %s mimeType: %s", new Object[] { paramString, localObject1 });
      AppMethodBeat.o(109505);
      return localObject1;
      localObject1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
      Object localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        localObject2 = (String)Ksx.get(paramString);
      }
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        if (paramString.startsWith("/")) {
          localObject1 = "application/octet-stream";
        } else {
          localObject1 = "application/".concat(String.valueOf(paramString));
        }
      }
    }
  }
  
  public static boolean bl(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(204765);
    boolean bool = a(paramString1, paramString2, paramString3, 2, null);
    AppMethodBeat.o(204765);
    return bool;
  }
  
  public static void bq(Intent paramIntent)
  {
    AppMethodBeat.i(109494);
    try
    {
      boolean bool1 = paramIntent.getBooleanExtra("MINIQB_OPEN_RET_VAL", false);
      paramIntent.getStringExtra("file_path");
      String str2 = paramIntent.getStringExtra("file_ext");
      Log.i("MicroMsg.AppChooserIntentUtil", "miniQB retVal:%b", new Object[] { Boolean.valueOf(bool1) });
      boolean bool2 = g.aAc();
      if (!bool2)
      {
        AppMethodBeat.o(109494);
        return;
      }
      String str1 = (String)g.aAh().azQ().get(ar.a.NXD, "");
      if (!bool1) {
        paramIntent = str1.replace(str2, "");
      }
      for (;;)
      {
        g.aAh().azQ().set(ar.a.NXD, paramIntent);
        if ((!bool1) && (Ksv != null) && (Ksw != null) && (Ksw.get() != null))
        {
          Ksv.setClass((Context)Ksw.get(), AppChooserUI.class);
          ((Activity)Ksw.get()).startActivityForResult(Ksv, 2);
        }
        Ksv = null;
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
  
  public static boolean c(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109490);
    String str = bfm(paramString2);
    Uri localUri = FileProviderHelper.getUriForFile(paramActivity, new o(paramString1));
    Bundle localBundle = new Bundle();
    Intent localIntent = S(paramActivity, str, paramString1);
    localBundle.putString("targeturl", localUri.toString());
    localBundle.putString("filepath", paramString1);
    localBundle.putString("fileext", paramString2);
    localBundle.putParcelable("targetintent", localIntent);
    paramString1 = new Intent(paramActivity, AppChooserUI.class);
    paramString1.putExtra("type", 0);
    paramString1.putExtra("title", paramActivity.getResources().getString(2131757562));
    paramString1.putExtra("mimetype", str);
    paramString1.putExtra("targetintent", localIntent);
    paramString1.putExtra("transferback", localBundle);
    paramString1.putExtra("scene", paramInt);
    paramString1.putExtra("openWay", true);
    paramActivity.startActivityForResult(paramString1, 2);
    AppMethodBeat.o(109490);
    return true;
  }
  
  private static boolean iA(Context paramContext)
  {
    AppMethodBeat.i(109501);
    try
    {
      ComponentName localComponentName = new ComponentName("com.tencent.mtt", "com.tencent.mtt.external.reader.ReaderSdkReceive");
      paramContext.getPackageManager().getReceiverInfo(localComponentName, 131072);
      Log.i("MicroMsg.AppChooserIntentUtil", "ifSupportFloatBallInQb() true");
      AppMethodBeat.o(109501);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.i("MicroMsg.AppChooserIntentUtil", "ifSupportFloatBallInQb() Exception:%s %s", new Object[] { paramContext.getClass().getSimpleName(), paramContext.getMessage() });
      AppMethodBeat.o(109501);
    }
    return false;
  }
  
  public static boolean mE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204763);
    Context localContext = MMApplicationContext.getContext();
    Object localObject = new o(paramString1);
    Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - path:%s, isExisted:%b, size:%d fileExt: %s", new Object[] { paramString1, Boolean.valueOf(((o)localObject).exists()), Long.valueOf(((o)localObject).length()), paramString2 });
    if (!((o)localObject).exists())
    {
      Log.e("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - Cannot open file not existed!");
      AppMethodBeat.o(204763);
      return false;
    }
    String str = bfm(paramString2);
    localObject = bfj(str);
    paramString2 = (String)localObject;
    if (((String)localObject).equals("com.baidu.searchbox"))
    {
      bfk(str);
      paramString2 = "";
    }
    if (!paramString2.equals(""))
    {
      Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - User exist always config, package is %s", new Object[] { paramString2 });
      if ("com.tencent.mtt".equals(paramString2))
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - open file by qb(default)");
        AppMethodBeat.o(204763);
        return false;
      }
      paramString1 = S(localContext, str, paramString1);
      paramString1.setPackage(paramString2);
      if (Util.isIntentAvailable(localContext, paramString1))
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - Always package support mimeType %s", new Object[] { str });
        AppMethodBeat.o(204763);
        return true;
      }
      Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - Always package do not support mimeType %s", new Object[] { str });
      AppMethodBeat.o(204763);
      return false;
    }
    AppMethodBeat.o(204763);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.a
 * JD-Core Version:    0.7.0.1
 */