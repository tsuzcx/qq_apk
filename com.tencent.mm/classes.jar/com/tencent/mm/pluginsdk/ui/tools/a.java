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
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.d.a.b;
import com.tencent.mm.plugin.d.a.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.pluginsdk.model.ab.a;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.f.p;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.util.d;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static Intent RtB;
  private static WeakReference<Activity> RtC;
  public static HashMap<String, String> RtD;
  public static HashMap<String, String> RtE;
  
  static
  {
    AppMethodBeat.i(109506);
    RtD = new HashMap();
    long l = System.currentTimeMillis();
    for (;;)
    {
      int i;
      try
      {
        String[] arrayOfString1 = u.bBS("assets:///mimetype.txt").split("\n");
        int j = arrayOfString1.length;
        i = 0;
        if (i < j)
        {
          String str = arrayOfString1[i];
          String[] arrayOfString2 = str.split(",");
          if ((arrayOfString2 != null) && (arrayOfString2.length > 1) && (!Util.isNullOrNil(arrayOfString2[0])) && (!Util.isNullOrNil(arrayOfString2[1]))) {
            RtD.put(arrayOfString2[0].trim(), arrayOfString2[1].trim());
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
        RtE = localHashMap;
        localHashMap.put("txt", "mtt/txt");
        RtE.put("epub", "mtt/epub");
        RtE.put("pdf", "mtt/pdf");
        RtE.put("doc", "mtt/doc");
        RtE.put("xls", "mtt/xls");
        RtE.put("ppt", "mtt/ppt");
        RtE.put("docx", "mtt/docx");
        RtE.put("xlsx", "mtt/xlsx");
        RtE.put("pptx", "mtt/pptx");
        RtE.put("chm", "mtt/chm");
        RtE.put("ini", "mtt/ini");
        RtE.put("log", "mtt/log");
        RtE.put("bat", "mtt/bat");
        RtE.put("php", "mtt/php");
        RtE.put("lrc", "mtt/lrc");
        RtE.put("js", "mtt/js");
        AppMethodBeat.o(109506);
        return;
        Log.i("MicroMsg.AppChooserIntentUtil", "read from mimetype text %d %d %d", new Object[] { Integer.valueOf(localHashMap.length), Integer.valueOf(RtD.size()), Long.valueOf(System.currentTimeMillis() - l) });
      }
      i += 1;
    }
  }
  
  private static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, aco paramaco)
  {
    AppMethodBeat.i(246613);
    Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document");
    localIntent.setPackage("com.tencent.mtt");
    localIntent.addFlags(268435456);
    localIntent.putExtra("ChannelID", "com.tencent.mm");
    localIntent.putExtra("PosID", 4);
    localIntent.putExtra("key_reader_sdk_id", 1);
    localIntent.putExtra("key_reader_sdk_type", 0);
    localIntent.putExtra("key_reader_sdk_format", paramString2);
    localIntent.putExtra("key_reader_sdk_path", paramString1);
    a(localIntent, paramContext, paramString1, paramString2, paramString3, paramString4, paramInt, paramaco);
    paramString4 = (String)RtE.get(paramString2);
    paramString3 = paramString4;
    if (Util.isNullOrNil(paramString4)) {
      paramString3 = brH(paramString2);
    }
    FileProviderHelper.setIntentDataAndType(paramContext, localIntent, new q(paramString1), paramString3, false);
    try
    {
      Log.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserDocumentIntent %s %s %s %s %s %s", new Object[] { paramString3, paramString1, localIntent.toString(), localIntent.getExtras(), paramString2, Integer.valueOf(paramInt) });
      label195:
      AppMethodBeat.o(246613);
      return localIntent;
    }
    catch (Exception paramContext)
    {
      break label195;
    }
  }
  
  private static Intent a(Intent paramIntent, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, aco paramaco)
  {
    AppMethodBeat.i(246614);
    boolean bool1;
    if (jD(paramContext))
    {
      if (!Util.isNullOrNil(paramString1)) {
        break label857;
      }
      Log.w("MicroMsg.AppChooserIntentUtil", "isEnableAppBrandOpenMaterial, filePath is empty");
      bool1 = false;
      i.hnB().b(paramString1, paramString2, paramString3, paramInt, paramaco);
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
        paramString1.put("text", paramContext.getString(a.f.files_enter_float_ball));
        paramString1.put("isShow", true);
        paramString1.put("idx", 1);
        paramString4 = new JSONObject();
        paramString4.put("id", 3);
        paramString4.put("iconResId", 2);
        paramString4.put("text", paramContext.getString(a.f.files_open_in_computer));
        if ((!((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).eBJ()) || (!HandOffFile.isSupportOpenFile(paramString2))) {
          continue;
        }
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
          paramString1.put("iconResId", 2);
          paramString1.put("text", paramContext.getString(a.f.app_brand_open_material_more_2));
          paramString1.put("isShow", true);
          paramString1.put("idx", 1);
          paramString2.add(paramString1);
        }
        paramString3.put("menuItems", new JSONArray(paramString2));
        if ((paramaco != null) && (!Util.isNullOrNil(paramaco.toByteArray())) && (paramaco.Soh != null) && (!Util.isNullOrNil(paramaco.Soh.toByteArray()))) {
          continue;
        }
        if ((paramaco == null) || (!paramaco.Soi)) {
          continue;
        }
        paramString3.put("from", "taskbar");
      }
      catch (Exception paramString2)
      {
        Object localObject;
        boolean bool2;
        label857:
        paramString1 = "";
        Log.e("MicroMsg.AppChooserIntentUtil", "createQQBrowserDocumentIntent menuItems jsonObject error" + paramString2.getMessage());
        continue;
        paramString3.put("from", "multitask");
        continue;
        int i = 0;
        continue;
      }
      paramString3.put("fromScene", paramInt);
      paramString3.put("openTime", System.currentTimeMillis());
      if (!ar.isDarkMode()) {
        continue;
      }
      i = 1;
      paramString3.put("darkMode", i);
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
      if (bool1)
      {
        paramString1 = new JSONObject();
        paramString1.put("id", 13);
        paramString3.put("notifyMenuExpose", paramString1);
      }
      paramString1 = paramString3.toString();
      try
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserDocumentIntent menuData:%s", new Object[] { paramString1 });
        paramString2 = new ArrayList();
        paramString3 = new BitmapFactory.Options();
        paramString3.inScaled = false;
        paramString4 = BitmapFactory.decodeResource(paramContext.getResources(), a.b.float_multitask_dark_on, paramString3);
        paramaco = BitmapFactory.decodeResource(paramContext.getResources(), a.b.icon_file_handoff, paramString3);
        paramString2.add(0, paramString4);
        paramString2.add(1, paramaco);
        if (bool1) {
          paramString2.add(2, BitmapFactory.decodeResource(paramContext.getResources(), a.b.icon_app_brand_open_material, paramString3));
        }
        paramContext = new Bundle();
        paramContext.putParcelableArrayList("resArray", paramString2);
        paramContext.putString("menuData", paramString1);
        paramContext.putString("style", "0");
        paramIntent.putExtra("key_thirdcall_sdk_extrals", paramContext);
        if (!Util.isEqual(paramInt, 9)) {
          break label1126;
        }
        b = 3;
      }
      catch (Exception paramString2)
      {
        MaterialModel localMaterialModel;
        AppBrandOpenMaterialCollection localAppBrandOpenMaterialCollection;
        continue;
        byte b = 1;
        continue;
      }
      paramIntent.putExtra("key_reader_sdk_sub_id", b);
      Log.d("MicroMsg.AppChooserIntentUtil", "subId:%s", new Object[] { Byte.valueOf(b) });
      AppMethodBeat.o(246614);
      return paramIntent;
      localObject = (com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.i.class);
      if (localObject == null)
      {
        Log.w("MicroMsg.AppChooserIntentUtil", "isEnableAppBrandOpenMaterial, openMaterialService is null");
        bool1 = false;
        break;
      }
      if (!((com.tencent.mm.plugin.appbrand.service.i)localObject).c(com.tencent.mm.plugin.appbrand.openmaterial.model.b.qns))
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "isEnableAppBrandOpenMaterial, openMaterialService is not enabled");
        bool1 = false;
        break;
      }
      localMaterialModel = MaterialModel.eQ(paramString1, paramString2);
      if (localMaterialModel == null)
      {
        Log.w("MicroMsg.AppChooserIntentUtil", "isEnableAppBrandOpenMaterial, materialModel is null");
        bool1 = false;
        break;
      }
      ((com.tencent.mm.plugin.appbrand.service.i)localObject).alg(localMaterialModel.mimeType);
      localAppBrandOpenMaterialCollection = ((com.tencent.mm.plugin.appbrand.service.i)localObject).a(localMaterialModel);
      if (!localAppBrandOpenMaterialCollection.qni.isEmpty())
      {
        bool1 = true;
        Log.i("MicroMsg.AppChooserIntentUtil", "isEnableAppBrandOpenMaterial, isEnabled: ".concat(String.valueOf(bool1)));
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (!((com.tencent.mm.plugin.appbrand.service.i)localObject).a(localMaterialModel, localAppBrandOpenMaterialCollection))
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
      paramString3.put("from", "");
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
            paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
            com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aFh(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "handlerResultOfAppChooserUI", "(Landroid/app/Activity;IILandroid/content/Intent;ZIII)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramActivity.startActivity((Intent)paramIntent.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "handlerResultOfAppChooserUI", "(Landroid/app/Activity;IILandroid/content/Intent;ZIII)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if ("com.tencent.mtt".equals(str))
            {
              com.tencent.mm.plugin.report.service.h.IzE.a(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt5) });
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
    if (RtE.containsKey(""))
    {
      if (!NetStatusUtil.isWifi(paramActivity))
      {
        paramIntent = new com.tencent.mm.ui.widget.a.f.a(MMApplicationContext.getContext());
        paramIntent.bBl(paramActivity.getString(a.f.tbs_update_prompt)).HL(true).ayp(a.f.fmt_update);
        paramIntent.c(new f.c()
        {
          public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(184243);
            if (paramAnonymousBoolean)
            {
              paramAnonymousString = new com.tencent.mm.ui.widget.a.f.a(this.val$activity).bBl(this.val$activity.getString(a.f.tbs_updating_prompt_not_wifi));
              paramAnonymousString.Qlf = true;
              paramAnonymousString.ayp(a.f.app_i_know).b(new f.c()
              {
                public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String)
                {
                  AppMethodBeat.i(184242);
                  ab.a.DP(true);
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
            av.d("dancy", "OnDismissListener ", new Object[0]);
            AppMethodBeat.o(184241);
          }
        }).show();
        AppMethodBeat.o(184245);
        return;
      }
      paramActivity = new com.tencent.mm.ui.widget.a.f.a(paramActivity).bBl(paramActivity.getString(a.f.tbs_updating_prompt_wifi));
      paramActivity.Qlf = true;
      paramActivity.ayp(a.f.app_i_know).b(new f.c()
      {
        public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(184244);
          ab.a.DP(true);
          AppMethodBeat.o(184244);
        }
      }).show();
      AppMethodBeat.o(184245);
      return;
    }
    com.tencent.mm.ui.base.h.p(paramActivity, paramInt1, paramInt2);
    AppMethodBeat.o(184245);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(109489);
    a(paramActivity, paramString1, paramString2, paramString3, paramInt, null);
    AppMethodBeat.o(109489);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt, aco paramaco)
  {
    AppMethodBeat.i(246606);
    Object localObject1 = new q(paramString1);
    Log.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", new Object[] { paramString1, Boolean.valueOf(((q)localObject1).ifE()), Long.valueOf(((q)localObject1).length()) });
    if (!((q)localObject1).ifE())
    {
      Log.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
      AppMethodBeat.o(246606);
      return;
    }
    Context localContext = MMApplicationContext.getContext();
    String str = brH(paramString2);
    Object localObject2 = brE(str);
    localObject1 = localObject2;
    if (((String)localObject2).equals("com.baidu.searchbox"))
    {
      brF(str);
      localObject1 = "";
    }
    if (!((String)localObject1).equals(""))
    {
      Log.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[] { localObject1 });
      if (("com.tencent.mtt".equals(localObject1)) && (!b(paramString1, paramString2, paramString3, str, paramInt)))
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "open file by qb(default)");
        AppMethodBeat.o(246606);
        return;
      }
      localObject2 = aa(MMApplicationContext.getContext(), str, paramString1);
      ((Intent)localObject2).setPackage((String)localObject1);
      if (paramaco != null) {}
      try
      {
        ((Intent)localObject2).putExtra("key_multi_task_common_info", paramaco.toByteArray());
        if (Util.isIntentAvailable(localContext, (Intent)localObject2))
        {
          Log.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType %s", new Object[] { str });
          com.tencent.xweb.f.oT(com.tencent.mm.xwebutil.a.bCC(paramString1), paramString2);
          com.tencent.xweb.f.oU(paramString2, "THIRDAPP");
          paramActivity = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramActivity.aFh(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooser", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramActivity.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooser", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(246606);
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
    if (!a(paramString1, paramString2, paramString3, str, paramInt, paramaco))
    {
      Log.i("MicroMsg.AppChooserIntentUtil", "open file by qb");
      AppMethodBeat.o(246606);
      return;
    }
    paramaco = aa(localContext, str, paramString1);
    if (!v.jr(MMApplicationContext.getContext())) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramActivity, paramString1, paramString2, paramString3, paramaco, paramInt, bool);
      AppMethodBeat.o(246606);
      return;
    }
  }
  
  private static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(109492);
    String str = brH(paramString2);
    Object localObject = FileProviderHelper.getUriForFile(paramActivity, new q(paramString1));
    Bundle localBundle = new Bundle();
    if (localObject != null) {
      localBundle.putString("targeturl", ((Uri)localObject).toString());
    }
    localBundle.putString("filepath", paramString1);
    localBundle.putString("fileext", paramString2);
    localBundle.putParcelable("targetintent", paramIntent);
    localObject = new Intent();
    ((Intent)localObject).putExtra("type", 0);
    ((Intent)localObject).putExtra("title", paramActivity.getResources().getString(a.f.choose_app));
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
      ((com.tencent.mm.choosemsgfile.compat.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.choosemsgfile.compat.a.class)).g(paramActivity, paramString1, paramString2);
    }
    for (;;)
    {
      RtB = (Intent)localObject;
      RtC = new WeakReference(paramActivity);
      AppMethodBeat.o(109492);
      return;
      a(paramActivity, paramString1, paramString2, paramString3, paramInt, null);
    }
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, aco paramaco)
  {
    AppMethodBeat.i(246610);
    Intent localIntent = new Intent();
    localIntent.putExtra("file_path", paramString1);
    localIntent.putExtra("file_ext", paramString2);
    localIntent.putExtra("file_name", paramString3);
    localIntent.putExtra("sence", paramInt);
    if (paramaco != null) {}
    try
    {
      localIntent.putExtra("key_multi_task_common_info", paramaco.toByteArray());
      localIntent.addFlags(268435456);
      localIntent.setComponent(new ComponentName(f.p.VSB, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
      localIntent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE");
      paramContext.sendBroadcast(localIntent);
      paramContext = FileProviderHelper.getUriForFile(paramContext, new q(paramString1));
      if (paramContext != null) {
        Util.whiteFileSet.add(paramContext.toString());
      }
      AppMethodBeat.o(246610);
      return;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppChooserIntentUtil", "invoke openByMiniQB Exception! Error:%s", new Object[] { paramString2.getMessage() });
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt, aco paramaco)
  {
    AppMethodBeat.i(246587);
    boolean bool = a(paramString1, paramString2, "", paramInt, paramaco);
    AppMethodBeat.o(246587);
    return bool;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, int paramInt, aco paramaco)
  {
    AppMethodBeat.i(246595);
    Context localContext = MMApplicationContext.getContext();
    Object localObject = new q(paramString1);
    Log.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d fileExt: %s", new Object[] { paramString1, Boolean.valueOf(((q)localObject).ifE()), Long.valueOf(((q)localObject).length()), paramString2 });
    if (!((q)localObject).ifE())
    {
      Log.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
      AppMethodBeat.o(246595);
      return true;
    }
    String str2 = brH(paramString2);
    localObject = brE(str2);
    if (((String)localObject).equals("com.baidu.searchbox"))
    {
      brF(str2);
      localObject = "";
    }
    for (;;)
    {
      if (!((String)localObject).equals(""))
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[] { localObject });
        if (("com.tencent.mtt".equals(localObject)) && (!a(paramString1, paramString2, paramString3, str2, paramInt, true, paramaco)))
        {
          Log.i("MicroMsg.AppChooserIntentUtil", "open file by qb(default)");
          AppMethodBeat.o(246595);
          return false;
        }
        Intent localIntent = aa(localContext, str2, paramString1);
        localIntent.setPackage((String)localObject);
        if (paramaco != null) {}
        try
        {
          localIntent.putExtra("key_multi_task_common_info", paramaco.toByteArray());
          if (Util.isIntentAvailable(localContext, localIntent))
          {
            Log.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType %s", new Object[] { str2 });
            com.tencent.xweb.f.oT(com.tencent.mm.xwebutil.a.bCC(paramString1), paramString2);
            com.tencent.xweb.f.oU(paramString2, "THIRDAPP");
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            try
            {
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
              com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooserWhenOnCreate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooserWhenOnCreate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(246595);
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
      while (!a(paramString1, paramString2, paramString3, str2, paramInt, paramaco))
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "open file by qb");
        AppMethodBeat.o(246595);
        return false;
        Log.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType %s", new Object[] { str2 });
      }
      int i;
      if (!Util.isNullOrNil(paramString2))
      {
        String str1 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlD, "");
        if ((!Util.isNullOrNil(str1)) && (str1.contains(paramString2))) {
          i = 1;
        }
      }
      while (i != 0) {
        if (paramInt == 7)
        {
          AppMethodBeat.o(246595);
          return true;
          i = 0;
        }
        else
        {
          a(localContext, paramString1, paramString2, paramString3, paramInt, paramaco);
          AppMethodBeat.o(246595);
          return false;
        }
      }
      AppMethodBeat.o(246595);
      return true;
    }
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, aco paramaco)
  {
    AppMethodBeat.i(246597);
    boolean bool = a(paramString1, paramString2, paramString3, paramString4, paramInt, false, paramaco);
    AppMethodBeat.o(246597);
    return bool;
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean, aco paramaco)
  {
    AppMethodBeat.i(246604);
    Context localContext = MMApplicationContext.getContext();
    com.tencent.mm.xwebutil.c.lQ(MMApplicationContext.getContext());
    i locali;
    String str1;
    String str2;
    String str3;
    int i;
    String str4;
    if ((com.tencent.xweb.f.a(paramString2, com.tencent.xweb.f.a.ZZK, false, new Intent()) != com.tencent.xweb.f.a.ZZL) || (paramBoolean)) {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEQ, true))
      {
        locali = i.hnB();
        str1 = locali.mFilePath;
        str2 = locali.qia;
        str3 = locali.mFileName;
        i = locali.tOb;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(cm.bfC());
        str4 = d.getMessageDigest(paramString1.getBytes());
        if (!Util.isNullOrNil(str4))
        {
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(str4);
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(u.bBQ(paramString1));
        }
        str4 = ((StringBuilder)localObject).toString();
        if (locali.FHd == null) {
          break label853;
        }
      }
    }
    label853:
    for (Object localObject = HandOffFile.fromMultiTask(locali.FHd);; localObject = null)
    {
      paramString3 = a(localContext, paramString1, paramString2, paramString3, str4, paramInt, paramaco);
      if (Util.isIntentAvailable(localContext, paramString3))
      {
        paramString4 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VxA, "");
        if ((!Util.isNullOrNil(paramString4)) && (Util.isEqual(str1, paramString4)))
        {
          paramString4 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vxz, "");
          paramaco = new StringBuilder();
          if (Util.isNullOrNil(paramString4))
          {
            paramaco.append(str4);
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vxz, paramaco.toString());
          }
        }
        for (;;)
        {
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VxB, Integer.valueOf(0));
          com.tencent.xweb.f.oT(com.tencent.mm.xwebutil.a.bCC(paramString1), paramString2);
          com.tencent.xweb.f.oU(paramString2, "QQBROWSER");
          try
          {
            paramString1 = MMApplicationContext.getContext();
            paramString2 = new com.tencent.mm.hellhoundlib.b.a().bm(paramString3);
            com.tencent.mm.hellhoundlib.a.a.b(paramString1, paramString2.aFh(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString1.startActivity((Intent)paramString2.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramString1, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.IzE.a(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt) });
            paramString2 = locali.FHd;
            paramString1 = null;
            if (paramString2 != null) {
              paramString1 = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).aLl(paramString2.field_id);
            }
            paramString2 = paramString1;
            if (paramString1 == null) {
              paramString2 = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).eBK();
            }
            if ((paramString2 instanceof HandOffFile))
            {
              paramString2.setHandOffType(1);
              paramString2.setKey(HandOff.generateKey(1, 1));
              ((HandOffFile)paramString2).saveToMultiTaskInfo(locali.FHd);
              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).j(paramString2);
            }
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              Log.e("MicroMsg.AppChooserIntentUtil", "startByQb() (by QQBrowserDocumentIntent) Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
            }
          }
          AppMethodBeat.o(246604);
          return false;
          paramaco.append(paramString4).append(",").append(str4);
          break;
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VxA, str1);
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vxz, str4);
        }
      }
      paramString3 = i.hnB();
      paramString3.b(str1, str2, str3, i, paramaco);
      if (localObject != null) {
        ((HandOffFile)localObject).saveToMultiTaskInfo(paramString3.FHd);
      }
      paramString3 = ab(localContext, paramString4, paramString1);
      if (Util.isIntentAvailable(localContext, paramString3))
      {
        com.tencent.xweb.f.oT(com.tencent.mm.xwebutil.a.bCC(paramString1), paramString2);
        com.tencent.xweb.f.oU(paramString2, "QQBROWSER");
        try
        {
          paramString1 = MMApplicationContext.getContext();
          paramString2 = new com.tencent.mm.hellhoundlib.b.a().bm(paramString3);
          com.tencent.mm.hellhoundlib.a.a.b(paramString1, paramString2.aFh(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString1.startActivity((Intent)paramString2.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramString1, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.IzE.a(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt) });
          AppMethodBeat.o(246604);
          return false;
        }
        catch (Exception paramString1)
        {
          Log.e("MicroMsg.AppChooserIntentUtil", "startByQb() (by QQBrowserIntent) Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
        }
      }
      AppMethodBeat.o(246604);
      return true;
    }
  }
  
  private static Intent aa(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(109497);
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    FileProviderHelper.setIntentDataAndType(paramContext, localIntent, new q(paramString2), paramString1, false);
    try
    {
      Log.i("MicroMsg.AppChooserIntentUtil", "createNormalIntent %s %s %s", new Object[] { paramString1, paramString2, localIntent.toString() });
      label71:
      AppMethodBeat.o(109497);
      return localIntent;
    }
    catch (Exception paramContext)
    {
      break label71;
    }
  }
  
  private static Intent ab(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(109498);
    Intent localIntent = new Intent();
    localIntent.setPackage("com.tencent.mtt");
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    FileProviderHelper.setIntentDataAndType(paramContext, localIntent, new q(paramString2), paramString1, false);
    try
    {
      Log.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserIntent %s %s %s", new Object[] { paramString1, paramString2, localIntent.toString() });
      label78:
      AppMethodBeat.o(109498);
      return localIntent;
    }
    catch (Exception paramContext)
    {
      break label78;
    }
  }
  
  public static boolean ay(String paramString1, String paramString2, int paramInt)
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
    String str = brH(paramString2);
    brF(str);
    Uri localUri = FileProviderHelper.getUriForFile(paramMMActivity, new q(paramString1));
    Bundle localBundle = new Bundle();
    Intent localIntent = aa(paramMMActivity, str, paramString1);
    localBundle.putString("targeturl", localUri.toString());
    localBundle.putString("filepath", paramString1);
    localBundle.putString("fileext", paramString2);
    localBundle.putParcelable("targetintent", localIntent);
    paramString1 = new Intent();
    paramString1.putExtra("type", 0);
    paramString1.putExtra("title", paramMMActivity.getResources().getString(a.f.choose_app));
    paramString1.putExtra("mimetype", str);
    paramString1.putExtra("targetintent", localIntent);
    paramString1.putExtra("transferback", localBundle);
    paramString1.putExtra("scene", 8);
    paramString1.putExtra("openWay", true);
    com.tencent.mm.by.c.a(paramMMActivity, ".pluginsdk.ui.tools.AppChooserUI", paramString1, 2, new MMActivity.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(109484);
        a.a(this.val$activity, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent, true, a.f.download_no_match_msg, a.f.download_no_match_title, this.iWM);
        AppMethodBeat.o(109484);
      }
    });
    AppMethodBeat.o(109491);
  }
  
  private static boolean b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(246601);
    boolean bool = a(paramString1, paramString2, paramString3, paramString4, paramInt, true, null);
    AppMethodBeat.o(246601);
    return bool;
  }
  
  public static boolean bg(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(246589);
    boolean bool = a(paramString1, paramString2, paramString3, 2, null);
    AppMethodBeat.o(246589);
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
      boolean bool2 = com.tencent.mm.kernel.h.aHB();
      if (!bool2)
      {
        AppMethodBeat.o(109494);
        return;
      }
      String str1 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlD, "");
      if (!bool1) {
        paramIntent = str1.replace(str2, "");
      }
      for (;;)
      {
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VlD, paramIntent);
        if ((!bool1) && (RtB != null) && (RtC != null) && (RtC.get() != null))
        {
          RtB.setClass((Context)RtC.get(), AppChooserUI.class);
          ((Activity)RtC.get()).startActivityForResult(RtB, 2);
        }
        RtB = null;
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
  
  private static String brE(String paramString)
  {
    AppMethodBeat.i(109502);
    paramString = (String)com.tencent.mm.kernel.h.aHG().aHp().b(brG(paramString), "");
    AppMethodBeat.o(109502);
    return paramString;
  }
  
  private static void brF(String paramString)
  {
    AppMethodBeat.i(109503);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(109503);
      return;
    }
    com.tencent.mm.kernel.h.aHG().aHp().i(brG(paramString), "");
    AppMethodBeat.o(109503);
  }
  
  private static int brG(String paramString)
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
  
  private static String brH(String paramString)
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
        localObject2 = (String)RtD.get(paramString);
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
  
  public static boolean c(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109490);
    String str = brH(paramString2);
    Uri localUri = FileProviderHelper.getUriForFile(paramActivity, new q(paramString1));
    Bundle localBundle = new Bundle();
    Intent localIntent = aa(paramActivity, str, paramString1);
    localBundle.putString("targeturl", localUri.toString());
    localBundle.putString("filepath", paramString1);
    localBundle.putString("fileext", paramString2);
    localBundle.putParcelable("targetintent", localIntent);
    paramString1 = new Intent(paramActivity, AppChooserUI.class);
    paramString1.putExtra("type", 0);
    paramString1.putExtra("title", paramActivity.getResources().getString(a.f.choose_app));
    paramString1.putExtra("mimetype", str);
    paramString1.putExtra("targetintent", localIntent);
    paramString1.putExtra("transferback", localBundle);
    paramString1.putExtra("scene", paramInt);
    paramString1.putExtra("openWay", true);
    paramActivity.startActivityForResult(paramString1, 2);
    AppMethodBeat.o(109490);
    return true;
  }
  
  private static boolean jD(Context paramContext)
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
  
  public static boolean nu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(246584);
    Context localContext = MMApplicationContext.getContext();
    Object localObject = new q(paramString1);
    Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - path:%s, isExisted:%b, size:%d fileExt: %s", new Object[] { paramString1, Boolean.valueOf(((q)localObject).ifE()), Long.valueOf(((q)localObject).length()), paramString2 });
    if (!((q)localObject).ifE())
    {
      Log.e("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - Cannot open file not existed!");
      AppMethodBeat.o(246584);
      return false;
    }
    String str = brH(paramString2);
    localObject = brE(str);
    paramString2 = (String)localObject;
    if (((String)localObject).equals("com.baidu.searchbox"))
    {
      brF(str);
      paramString2 = "";
    }
    if (!paramString2.equals(""))
    {
      Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - User exist always config, package is %s", new Object[] { paramString2 });
      if ("com.tencent.mtt".equals(paramString2))
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - open file by qb(default)");
        AppMethodBeat.o(246584);
        return false;
      }
      paramString1 = aa(localContext, str, paramString1);
      paramString1.setPackage(paramString2);
      if (Util.isIntentAvailable(localContext, paramString1))
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - Always package support mimeType %s", new Object[] { str });
        AppMethodBeat.o(246584);
        return true;
      }
      Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - Always package do not support mimeType %s", new Object[] { str });
      AppMethodBeat.o(246584);
      return false;
    }
    AppMethodBeat.o(246584);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.a
 * JD-Core Version:    0.7.0.1
 */