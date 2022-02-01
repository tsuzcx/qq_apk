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
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.d.a.b;
import com.tencent.mm.plugin.d.a.f;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.pluginsdk.model.ad.a;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.bc;
import com.tencent.mm.ui.f.q;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.h.a;
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
  private static Intent YpV;
  private static WeakReference<Activity> YpW;
  public static HashMap<String, String> YpX;
  public static HashMap<String, String> YpY;
  
  static
  {
    AppMethodBeat.i(109506);
    YpX = new HashMap();
    long l = System.currentTimeMillis();
    for (;;)
    {
      int i;
      try
      {
        String[] arrayOfString1 = y.bEn("assets:///mimetype.txt").split("\n");
        int j = arrayOfString1.length;
        i = 0;
        if (i < j)
        {
          String str = arrayOfString1[i];
          String[] arrayOfString2 = str.split(",");
          if ((arrayOfString2 != null) && (arrayOfString2.length > 1) && (!Util.isNullOrNil(arrayOfString2[0])) && (!Util.isNullOrNil(arrayOfString2[1]))) {
            YpX.put(arrayOfString2[0].trim(), arrayOfString2[1].trim());
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
        YpY = localHashMap;
        localHashMap.put("txt", "mtt/txt");
        YpY.put("epub", "mtt/epub");
        YpY.put("pdf", "mtt/pdf");
        YpY.put("doc", "mtt/doc");
        YpY.put("xls", "mtt/xls");
        YpY.put("ppt", "mtt/ppt");
        YpY.put("docx", "mtt/docx");
        YpY.put("xlsx", "mtt/xlsx");
        YpY.put("pptx", "mtt/pptx");
        YpY.put("chm", "mtt/chm");
        YpY.put("ini", "mtt/ini");
        YpY.put("log", "mtt/log");
        YpY.put("bat", "mtt/bat");
        YpY.put("php", "mtt/php");
        YpY.put("lrc", "mtt/lrc");
        YpY.put("js", "mtt/js");
        AppMethodBeat.o(109506);
        return;
        Log.i("MicroMsg.AppChooserIntentUtil", "read from mimetype text %d %d %d", new Object[] { Integer.valueOf(localHashMap.length), Integer.valueOf(YpX.size()), Long.valueOf(System.currentTimeMillis() - l) });
      }
      i += 1;
    }
  }
  
  private static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, aet paramaet)
  {
    AppMethodBeat.i(245644);
    Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document");
    localIntent.setPackage("com.tencent.mtt");
    localIntent.addFlags(268435456);
    localIntent.putExtra("ChannelID", "com.tencent.mm");
    localIntent.putExtra("PosID", 4);
    localIntent.putExtra("key_reader_sdk_id", 1);
    localIntent.putExtra("key_reader_sdk_type", 0);
    localIntent.putExtra("key_reader_sdk_format", paramString2);
    localIntent.putExtra("key_reader_sdk_path", paramString1);
    a(localIntent, paramContext, paramString1, paramString2, paramString3, paramString4, paramInt, paramaet);
    paramString4 = (String)YpY.get(paramString2);
    paramString3 = paramString4;
    if (Util.isNullOrNil(paramString4)) {
      paramString3 = brw(paramString2);
    }
    FileProviderHelper.setIntentDataAndType(paramContext, localIntent, new u(paramString1), paramString3, false);
    try
    {
      Log.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserDocumentIntent %s %s %s %s %s %s", new Object[] { paramString3, paramString1, localIntent.toString(), localIntent.getExtras(), paramString2, Integer.valueOf(paramInt) });
      label195:
      AppMethodBeat.o(245644);
      return localIntent;
    }
    catch (Exception paramContext)
    {
      break label195;
    }
  }
  
  private static Intent a(Intent paramIntent, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, aet paramaet)
  {
    AppMethodBeat.i(245662);
    boolean bool1;
    if (lC(paramContext))
    {
      if (!Util.isNullOrNil(paramString1)) {
        break label857;
      }
      Log.w("MicroMsg.AppChooserIntentUtil", "isEnableAppBrandOpenMaterial, filePath is empty");
      bool1 = false;
      g.iOt().b(paramString1, paramString2, paramString3, paramInt, paramaet);
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
        if ((!((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).fJL()) || (!HandOffFile.isSupportOpenFile(paramString2))) {
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
        if ((paramaet != null) && (!Util.isNullOrNil(paramaet.toByteArray())) && (paramaet.ZmM != null) && (!Util.isNullOrNil(paramaet.ZmM.toByteArray()))) {
          continue;
        }
        if ((paramaet == null) || (!paramaet.ZmN)) {
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
      if (!aw.isDarkMode()) {
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
        paramaet = BitmapFactory.decodeResource(paramContext.getResources(), a.b.icon_file_handoff, paramString3);
        paramString2.add(0, paramString4);
        paramString2.add(1, paramaet);
        if (bool1) {
          paramString2.add(2, BitmapFactory.decodeResource(paramContext.getResources(), a.b.icon_app_brand_open_material, paramString3));
        }
        paramContext = new Bundle();
        paramContext.putParcelableArrayList("resArray", paramString2);
        paramContext.putString("menuData", paramString1);
        paramContext.putString("style", "0");
        paramIntent.putExtra("key_thirdcall_sdk_extrals", paramContext);
        if (!Util.isEqual(paramInt, 9)) {
          break label1160;
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
      AppMethodBeat.o(245662);
      return paramIntent;
      localObject = (j)com.tencent.mm.kernel.h.ax(j.class);
      if (localObject == null)
      {
        Log.w("MicroMsg.AppChooserIntentUtil", "isEnableAppBrandOpenMaterial, openMaterialService is null");
        bool1 = false;
        break;
      }
      if (!((j)localObject).c(b.trZ))
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "isEnableAppBrandOpenMaterial, openMaterialService is not enabled");
        bool1 = false;
        break;
      }
      localMaterialModel = MaterialModel.fh(paramString1, paramString2);
      if (localMaterialModel == null)
      {
        Log.w("MicroMsg.AppChooserIntentUtil", "isEnableAppBrandOpenMaterial, materialModel is null");
        bool1 = false;
        break;
      }
      if (!((j)localObject).aen(localMaterialModel.mimeType))
      {
        Log.w("MicroMsg.AppChooserIntentUtil", "isEnableAppBrandOpenMaterial, openMaterialService is not support " + localMaterialModel.mimeType);
        bool1 = false;
        break;
      }
      localAppBrandOpenMaterialCollection = ((j)localObject).a(localMaterialModel);
      if (!localAppBrandOpenMaterialCollection.trP.isEmpty())
      {
        bool1 = true;
        Log.i("MicroMsg.AppChooserIntentUtil", "isEnableAppBrandOpenMaterial, isEnabled: ".concat(String.valueOf(bool1)));
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (!((j)localObject).a(localMaterialModel, localAppBrandOpenMaterialCollection))
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
            paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
            com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aYi(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "handlerResultOfAppChooserUI", "(Landroid/app/Activity;IILandroid/content/Intent;ZIII)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramActivity.startActivity((Intent)paramIntent.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "handlerResultOfAppChooserUI", "(Landroid/app/Activity;IILandroid/content/Intent;ZIII)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if ("com.tencent.mtt".equals(str))
            {
              com.tencent.mm.plugin.report.service.h.OAn.b(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt5) });
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
    if (YpY.containsKey(""))
    {
      if (!NetStatusUtil.isWifi(paramActivity))
      {
        paramIntent = new g.a(MMApplicationContext.getContext());
        paramIntent.bDE(paramActivity.getString(a.f.tbs_update_prompt)).NF(true).aEX(a.f.fmt_update);
        paramIntent.c(new g.c()
        {
          public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(184243);
            if (paramAnonymousBoolean)
            {
              paramAnonymousString = new g.a(a.this).bDE(a.this.getString(a.f.tbs_updating_prompt_not_wifi));
              paramAnonymousString.Xdm = true;
              paramAnonymousString.aEX(a.f.app_i_know).b(new g.c()
              {
                public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String)
                {
                  AppMethodBeat.i(184242);
                  ad.a.Jw(true);
                  AppMethodBeat.o(184242);
                }
              }).show();
            }
            AppMethodBeat.o(184243);
          }
        }).d(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(184241);
            bc.d("dancy", "OnDismissListener ", new Object[0]);
            AppMethodBeat.o(184241);
          }
        }).show();
        AppMethodBeat.o(184245);
        return;
      }
      paramActivity = new g.a(paramActivity).bDE(paramActivity.getString(a.f.tbs_updating_prompt_wifi));
      paramActivity.Xdm = true;
      paramActivity.aEX(a.f.app_i_know).b(new g.c()
      {
        public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(184244);
          ad.a.Jw(true);
          AppMethodBeat.o(184244);
        }
      }).show();
      AppMethodBeat.o(184245);
      return;
    }
    k.s(paramActivity, paramInt1, paramInt2);
    AppMethodBeat.o(184245);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(109489);
    a(paramActivity, paramString1, paramString2, paramString3, paramInt, null);
    AppMethodBeat.o(109489);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt, aet paramaet)
  {
    AppMethodBeat.i(245605);
    Object localObject1 = new u(paramString1);
    Log.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", new Object[] { paramString1, Boolean.valueOf(((u)localObject1).jKS()), Long.valueOf(((u)localObject1).length()) });
    if (!((u)localObject1).jKS())
    {
      Log.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
      AppMethodBeat.o(245605);
      return;
    }
    Context localContext = MMApplicationContext.getContext();
    String str = brw(paramString2);
    Object localObject2 = brt(str);
    localObject1 = localObject2;
    if (((String)localObject2).equals("com.baidu.searchbox"))
    {
      bru(str);
      localObject1 = "";
    }
    if (!((String)localObject1).equals(""))
    {
      Log.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[] { localObject1 });
      if (("com.tencent.mtt".equals(localObject1)) && (!c(paramString1, paramString2, paramString3, str, paramInt)))
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "open file by qb(default)");
        AppMethodBeat.o(245605);
        return;
      }
      localObject2 = af(MMApplicationContext.getContext(), str, paramString1);
      ((Intent)localObject2).setPackage((String)localObject1);
      if (paramaet != null) {}
      try
      {
        ((Intent)localObject2).putExtra("key_multi_task_common_info", paramaet.toByteArray());
        if (Util.isIntentAvailable(localContext, (Intent)localObject2))
        {
          Log.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType %s", new Object[] { str });
          com.tencent.xweb.h.qQ(com.tencent.mm.xwebutil.a.bFg(paramString1), paramString2);
          com.tencent.xweb.h.qR(paramString2, "THIRDAPP");
          paramActivity = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramActivity.aYi(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooser", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramActivity.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooser", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(245605);
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
    if (!a(paramString1, paramString2, paramString3, str, paramInt, paramaet))
    {
      Log.i("MicroMsg.AppChooserIntentUtil", "open file by qb");
      AppMethodBeat.o(245605);
      return;
    }
    paramaet = af(localContext, str, paramString1);
    if (!x.lo(MMApplicationContext.getContext())) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramActivity, paramString1, paramString2, paramString3, paramaet, paramInt, bool);
      AppMethodBeat.o(245605);
      return;
    }
  }
  
  private static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(109492);
    String str = brw(paramString2);
    Object localObject = FileProviderHelper.getUriForFile(paramActivity, new u(paramString1));
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
      ((com.tencent.mm.choosemsgfile.compat.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.choosemsgfile.compat.a.class)).k(paramActivity, paramString1, paramString2);
    }
    for (;;)
    {
      YpV = (Intent)localObject;
      YpW = new WeakReference(paramActivity);
      AppMethodBeat.o(109492);
      return;
      a(paramActivity, paramString1, paramString2, paramString3, paramInt, null);
    }
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, aet paramaet)
  {
    AppMethodBeat.i(245620);
    Intent localIntent = new Intent();
    localIntent.putExtra("file_path", paramString1);
    localIntent.putExtra("file_ext", paramString2);
    localIntent.putExtra("file_name", paramString3);
    localIntent.putExtra("sence", paramInt);
    if (paramaet != null) {}
    try
    {
      localIntent.putExtra("key_multi_task_common_info", paramaet.toByteArray());
      localIntent.addFlags(268435456);
      localIntent.setComponent(new ComponentName(f.q.adwK, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
      localIntent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE");
      paramContext.sendBroadcast(localIntent);
      paramContext = FileProviderHelper.getUriForFile(paramContext, new u(paramString1));
      if (paramContext != null) {
        Util.whiteFileSet.add(paramContext.toString());
      }
      AppMethodBeat.o(245620);
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
  
  public static boolean a(String paramString1, String paramString2, int paramInt, aet paramaet)
  {
    AppMethodBeat.i(245575);
    boolean bool = a(paramString1, paramString2, "", paramInt, paramaet);
    AppMethodBeat.o(245575);
    return bool;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, int paramInt, aet paramaet)
  {
    AppMethodBeat.i(245585);
    Context localContext = MMApplicationContext.getContext();
    Object localObject = new u(paramString1);
    Log.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d fileExt: %s", new Object[] { paramString1, Boolean.valueOf(((u)localObject).jKS()), Long.valueOf(((u)localObject).length()), paramString2 });
    if (!((u)localObject).jKS())
    {
      Log.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
      AppMethodBeat.o(245585);
      return true;
    }
    String str2 = brw(paramString2);
    localObject = brt(str2);
    if (((String)localObject).equals("com.baidu.searchbox"))
    {
      bru(str2);
      localObject = "";
    }
    for (;;)
    {
      if (!((String)localObject).equals(""))
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[] { localObject });
        if (("com.tencent.mtt".equals(localObject)) && (!a(paramString1, paramString2, paramString3, str2, paramInt, true, paramaet)))
        {
          Log.i("MicroMsg.AppChooserIntentUtil", "open file by qb(default)");
          AppMethodBeat.o(245585);
          return false;
        }
        Intent localIntent = af(localContext, str2, paramString1);
        localIntent.setPackage((String)localObject);
        if (paramaet != null) {}
        try
        {
          localIntent.putExtra("key_multi_task_common_info", paramaet.toByteArray());
          if (Util.isIntentAvailable(localContext, localIntent))
          {
            Log.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType %s", new Object[] { str2 });
            com.tencent.xweb.h.qQ(com.tencent.mm.xwebutil.a.bFg(paramString1), paramString2);
            com.tencent.xweb.h.qR(paramString2, "THIRDAPP");
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            try
            {
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
              com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooserWhenOnCreate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooserWhenOnCreate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(245585);
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
      while (!a(paramString1, paramString2, paramString3, str2, paramInt, paramaet))
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "open file by qb");
        AppMethodBeat.o(245585);
        return false;
        Log.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType %s", new Object[] { str2 });
      }
      int i;
      if (!Util.isNullOrNil(paramString2))
      {
        String str1 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acMX, "");
        if ((!Util.isNullOrNil(str1)) && (str1.contains(paramString2))) {
          i = 1;
        }
      }
      while (i != 0) {
        if (paramInt == 7)
        {
          AppMethodBeat.o(245585);
          return true;
          i = 0;
        }
        else
        {
          a(localContext, paramString1, paramString2, paramString3, paramInt, paramaet);
          AppMethodBeat.o(245585);
          return false;
        }
      }
      AppMethodBeat.o(245585);
      return true;
    }
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, aet paramaet)
  {
    AppMethodBeat.i(245586);
    boolean bool = a(paramString1, paramString2, paramString3, paramString4, paramInt, false, paramaet);
    AppMethodBeat.o(245586);
    return bool;
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean, aet paramaet)
  {
    AppMethodBeat.i(245598);
    Context localContext = MMApplicationContext.getContext();
    com.tencent.mm.xwebutil.c.nU(MMApplicationContext.getContext());
    g localg;
    String str1;
    String str2;
    String str3;
    int i;
    String str4;
    if ((com.tencent.xweb.h.a(paramString2, h.a.aiet, false, new Intent()) != h.a.aieu) || (paramBoolean)) {
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUl, true))
      {
        localg = g.iOt();
        str1 = localg.mFilePath;
        str2 = localg.tmM;
        str3 = localg.mFileName;
        i = localg.wRr;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(cn.bDu());
        str4 = com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
        if (!Util.isNullOrNil(str4))
        {
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(str4);
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(y.bEl(paramString1));
        }
        str4 = ((StringBuilder)localObject).toString();
        if (localg.LCE == null) {
          break label853;
        }
      }
    }
    label853:
    for (Object localObject = HandOffFile.fromMultiTask(localg.LCE);; localObject = null)
    {
      paramString3 = a(localContext, paramString1, paramString2, paramString3, str4, paramInt, paramaet);
      if (Util.isIntentAvailable(localContext, paramString3))
      {
        paramString4 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acZn, "");
        if ((!Util.isNullOrNil(paramString4)) && (Util.isEqual(str1, paramString4)))
        {
          paramString4 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acZm, "");
          paramaet = new StringBuilder();
          if (Util.isNullOrNil(paramString4))
          {
            paramaet.append(str4);
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acZm, paramaet.toString());
          }
        }
        for (;;)
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acZo, Integer.valueOf(0));
          com.tencent.xweb.h.qQ(com.tencent.mm.xwebutil.a.bFg(paramString1), paramString2);
          com.tencent.xweb.h.qR(paramString2, "QQBROWSER");
          try
          {
            paramString1 = MMApplicationContext.getContext();
            paramString2 = new com.tencent.mm.hellhoundlib.b.a().cG(paramString3);
            com.tencent.mm.hellhoundlib.a.a.b(paramString1, paramString2.aYi(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString1.startActivity((Intent)paramString2.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramString1, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.OAn.b(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt) });
            paramString2 = localg.LCE;
            paramString1 = null;
            if (paramString2 != null) {
              paramString1 = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).aIc(paramString2.field_id);
            }
            paramString2 = paramString1;
            if (paramString1 == null) {
              paramString2 = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).fJM();
            }
            if ((paramString2 instanceof HandOffFile))
            {
              paramString2.setHandOffType(1);
              paramString2.setKey(HandOff.generateKey(1, 1));
              ((HandOffFile)paramString2).saveToMultiTaskInfo(localg.LCE);
              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).j(paramString2);
            }
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              Log.e("MicroMsg.AppChooserIntentUtil", "startByQb() (by QQBrowserDocumentIntent) Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
            }
          }
          AppMethodBeat.o(245598);
          return false;
          paramaet.append(paramString4).append(",").append(str4);
          break;
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acZn, str1);
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acZm, str4);
        }
      }
      paramString3 = g.iOt();
      paramString3.b(str1, str2, str3, i, paramaet);
      if (localObject != null) {
        ((HandOffFile)localObject).saveToMultiTaskInfo(paramString3.LCE);
      }
      paramString3 = ag(localContext, paramString4, paramString1);
      if (Util.isIntentAvailable(localContext, paramString3))
      {
        com.tencent.xweb.h.qQ(com.tencent.mm.xwebutil.a.bFg(paramString1), paramString2);
        com.tencent.xweb.h.qR(paramString2, "QQBROWSER");
        try
        {
          paramString1 = MMApplicationContext.getContext();
          paramString2 = new com.tencent.mm.hellhoundlib.b.a().cG(paramString3);
          com.tencent.mm.hellhoundlib.a.a.b(paramString1, paramString2.aYi(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString1.startActivity((Intent)paramString2.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramString1, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.OAn.b(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt) });
          AppMethodBeat.o(245598);
          return false;
        }
        catch (Exception paramString1)
        {
          Log.e("MicroMsg.AppChooserIntentUtil", "startByQb() (by QQBrowserIntent) Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
        }
      }
      AppMethodBeat.o(245598);
      return true;
    }
  }
  
  public static boolean aK(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109485);
    boolean bool = a(paramString1, paramString2, "", paramInt, null);
    AppMethodBeat.o(109485);
    return bool;
  }
  
  private static Intent af(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(109497);
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    FileProviderHelper.setIntentDataAndType(paramContext, localIntent, new u(paramString2), paramString1, false);
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
  
  private static Intent ag(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(109498);
    Intent localIntent = new Intent();
    localIntent.setPackage("com.tencent.mtt");
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    FileProviderHelper.setIntentDataAndType(paramContext, localIntent, new u(paramString2), paramString1, false);
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
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109488);
    a(paramActivity, paramString1, paramString2, "", paramInt);
    AppMethodBeat.o(109488);
  }
  
  public static void b(MMActivity paramMMActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(109491);
    String str = brw(paramString2);
    bru(str);
    Uri localUri = FileProviderHelper.getUriForFile(paramMMActivity, new u(paramString1));
    Bundle localBundle = new Bundle();
    Intent localIntent = af(paramMMActivity, str, paramString1);
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
    com.tencent.mm.br.c.a(paramMMActivity, ".pluginsdk.ui.tools.AppChooserUI", paramString1, 2, new MMActivity.a()
    {
      public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(109484);
        a.a(a.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent, true, a.f.download_no_match_msg, a.f.download_no_match_title, this.lyQ);
        AppMethodBeat.o(109484);
      }
    });
    AppMethodBeat.o(109491);
  }
  
  public static boolean bA(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(245580);
    boolean bool = a(paramString1, paramString2, paramString3, 2, null);
    AppMethodBeat.o(245580);
    return bool;
  }
  
  public static void bT(Intent paramIntent)
  {
    AppMethodBeat.i(109494);
    try
    {
      boolean bool1 = paramIntent.getBooleanExtra("MINIQB_OPEN_RET_VAL", false);
      paramIntent.getStringExtra("file_path");
      String str = paramIntent.getStringExtra("file_ext");
      Log.i("MicroMsg.AppChooserIntentUtil", "miniQB retVal:%b", new Object[] { Boolean.valueOf(bool1) });
      boolean bool2 = com.tencent.mm.kernel.h.baz();
      if (!bool2)
      {
        AppMethodBeat.o(109494);
        return;
      }
      Object localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acMX, "");
      if (!bool1) {
        paramIntent = ((String)localObject).replace(str, "");
      }
      for (;;)
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acMX, paramIntent);
        if ((!bool1) && (YpV != null) && (YpW != null) && (YpW.get() != null))
        {
          YpV.setClass((Context)YpW.get(), AppChooserUI.class);
          paramIntent = (Activity)YpW.get();
          localObject = YpV;
          com.tencent.mm.hellhoundlib.a.a.a(paramIntent, com.tencent.mm.hellhoundlib.b.c.a(2, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject).aYi(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "onCallbackByMiniQB", "(Landroid/content/Intent;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
        }
        YpV = null;
        AppMethodBeat.o(109494);
        return;
        paramIntent = (Intent)localObject;
        if (!((String)localObject).contains(str)) {
          paramIntent = ((String)localObject).concat(str);
        }
      }
      return;
    }
    catch (Exception paramIntent)
    {
      AppMethodBeat.o(109494);
    }
  }
  
  private static String brt(String paramString)
  {
    AppMethodBeat.i(109502);
    paramString = (String)com.tencent.mm.kernel.h.baE().ban().d(brv(paramString), "");
    AppMethodBeat.o(109502);
    return paramString;
  }
  
  private static void bru(String paramString)
  {
    AppMethodBeat.i(109503);
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(109503);
      return;
    }
    com.tencent.mm.kernel.h.baE().ban().B(brv(paramString), "");
    AppMethodBeat.o(109503);
  }
  
  private static int brv(String paramString)
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
  
  private static String brw(String paramString)
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
        localObject2 = (String)YpX.get(paramString);
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
    String str = brw(paramString2);
    Uri localUri = FileProviderHelper.getUriForFile(paramActivity, new u(paramString1));
    Bundle localBundle = new Bundle();
    Intent localIntent = af(paramActivity, str, paramString1);
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
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(2, new com.tencent.mm.hellhoundlib.b.a()).cG(paramString1).aYi(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startChooseWayActivity", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;I)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(109490);
    return true;
  }
  
  private static boolean c(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(245588);
    boolean bool = a(paramString1, paramString2, paramString3, paramString4, paramInt, true, null);
    AppMethodBeat.o(245588);
    return bool;
  }
  
  private static boolean lC(Context paramContext)
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
  
  public static boolean pq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(245572);
    Context localContext = MMApplicationContext.getContext();
    Object localObject = new u(paramString1);
    Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - path:%s, isExisted:%b, size:%d fileExt: %s", new Object[] { paramString1, Boolean.valueOf(((u)localObject).jKS()), Long.valueOf(((u)localObject).length()), paramString2 });
    if (!((u)localObject).jKS())
    {
      Log.e("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - Cannot open file not existed!");
      AppMethodBeat.o(245572);
      return false;
    }
    String str = brw(paramString2);
    localObject = brt(str);
    paramString2 = (String)localObject;
    if (((String)localObject).equals("com.baidu.searchbox"))
    {
      bru(str);
      paramString2 = "";
    }
    if (!paramString2.equals(""))
    {
      Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - User exist always config, package is %s", new Object[] { paramString2 });
      if ("com.tencent.mtt".equals(paramString2))
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - open file by qb(default)");
        AppMethodBeat.o(245572);
        return false;
      }
      paramString1 = af(localContext, str, paramString1);
      paramString1.setPackage(paramString2);
      if (Util.isIntentAvailable(localContext, paramString1))
      {
        Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - Always package support mimeType %s", new Object[] { str });
        AppMethodBeat.o(245572);
        return true;
      }
      Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - Always package do not support mimeType %s", new Object[] { str });
      AppMethodBeat.o(245572);
      return false;
    }
    AppMethodBeat.o(245572);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.a
 * JD-Core Version:    0.7.0.1
 */