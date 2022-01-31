package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.k;
import com.tencent.xweb.d.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class a
{
  private static Intent wdj;
  private static WeakReference<Activity> wdk;
  public static HashMap<String, String> wdl;
  public static HashMap<String, String> wdm;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(125853);
    wdl = new HashMap();
    long l = System.currentTimeMillis();
    Object localObject4 = ah.getContext().getAssets();
    Object localObject3 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localObject4 = ((AssetManager)localObject4).open("mimetype.txt");
        localObject1 = localObject4;
        localObject3 = localObject4;
        arrayOfString1 = new String(com.tencent.mm.a.e.m((InputStream)localObject4)).split("\n");
        localObject1 = localObject4;
        localObject3 = localObject4;
        int j = arrayOfString1.length;
        if (i < j)
        {
          String str = arrayOfString1[i];
          localObject1 = localObject4;
          localObject3 = localObject4;
          String[] arrayOfString2 = str.split(",");
          if (arrayOfString2 != null)
          {
            localObject1 = localObject4;
            localObject3 = localObject4;
            if (arrayOfString2.length > 1)
            {
              localObject1 = localObject4;
              localObject3 = localObject4;
              if (!bo.isNullOrNil(arrayOfString2[0]))
              {
                localObject1 = localObject4;
                localObject3 = localObject4;
                if (!bo.isNullOrNil(arrayOfString2[1]))
                {
                  localObject1 = localObject4;
                  localObject3 = localObject4;
                  wdl.put(arrayOfString2[0].trim(), arrayOfString2[1].trim());
                  break label519;
                }
              }
            }
          }
          localObject1 = localObject4;
          localObject3 = localObject4;
          ab.i("MicroMsg.AppChooserIntentUtil", "mimeType %s", new Object[] { str });
        }
      }
      catch (IOException localIOException)
      {
        String[] arrayOfString1;
        localObject3 = localObject1;
        ab.printErrStackTrace("MicroMsg.AppChooserIntentUtil", localIOException, "read mimeType from asset", new Object[0]);
        com.tencent.mm.a.e.l((InputStream)localObject1);
        localObject1 = new HashMap();
        wdm = (HashMap)localObject1;
        ((HashMap)localObject1).put("txt", "mtt/txt");
        wdm.put("epub", "mtt/epub");
        wdm.put("pdf", "mtt/pdf");
        wdm.put("doc", "mtt/doc");
        wdm.put("xls", "mtt/xls");
        wdm.put("ppt", "mtt/ppt");
        wdm.put("docx", "mtt/docx");
        wdm.put("xlsx", "mtt/xlsx");
        wdm.put("pptx", "mtt/pptx");
        wdm.put("chm", "mtt/chm");
        wdm.put("ini", "mtt/ini");
        wdm.put("log", "mtt/log");
        wdm.put("bat", "mtt/bat");
        wdm.put("php", "mtt/php");
        wdm.put("lrc", "mtt/lrc");
        wdm.put("js", "mtt/js");
        AppMethodBeat.o(125853);
        return;
        localObject1 = localIOException;
        localObject3 = localIOException;
        ab.i("MicroMsg.AppChooserIntentUtil", "read from mimetype text %d %d %d", new Object[] { Integer.valueOf(arrayOfString1.length), Integer.valueOf(wdl.size()), Long.valueOf(System.currentTimeMillis() - l) });
        com.tencent.mm.a.e.l(localIOException);
        continue;
      }
      finally
      {
        com.tencent.mm.a.e.l((InputStream)localObject3);
        AppMethodBeat.o(125853);
      }
      label519:
      i += 1;
    }
  }
  
  private static void D(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(125843);
    Intent localIntent = new Intent();
    localIntent.putExtra("file_path", paramString1);
    localIntent.putExtra("file_ext", paramString2);
    localIntent.addFlags(268435456);
    localIntent.setComponent(new ComponentName(e.k.iXz, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE");
    paramContext.sendBroadcast(localIntent);
    AppMethodBeat.o(125843);
  }
  
  private static Intent E(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(125846);
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    k.a(paramContext, localIntent, new File(paramString2), paramString1);
    try
    {
      ab.i("MicroMsg.AppChooserIntentUtil", "createNormalIntent %s %s %s", new Object[] { paramString1, paramString2, localIntent.toString() });
      label68:
      AppMethodBeat.o(125846);
      return localIntent;
    }
    catch (Exception paramContext)
    {
      break label68;
    }
  }
  
  private static Intent F(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(125847);
    Intent localIntent = new Intent();
    localIntent.setPackage("com.tencent.mtt");
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    k.a(paramContext, localIntent, new File(paramString2), paramString1);
    try
    {
      ab.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserIntent %s %s %s", new Object[] { paramString1, paramString2, localIntent.toString() });
      label77:
      AppMethodBeat.o(125847);
      return localIntent;
    }
    catch (Exception paramContext)
    {
      break label77;
    }
  }
  
  private static Intent G(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(125848);
    Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document");
    localIntent.setPackage("com.tencent.mtt");
    localIntent.addFlags(268435456);
    localIntent.putExtra("ChannelID", "com.tencent.mm");
    localIntent.putExtra("PosID", 4);
    localIntent.putExtra("key_reader_sdk_id", 1);
    localIntent.putExtra("key_reader_sdk_type", 0);
    localIntent.putExtra("key_reader_sdk_format", paramString2);
    localIntent.putExtra("key_reader_sdk_path", paramString1);
    String str2 = (String)wdm.get(paramString2);
    String str1 = str2;
    if (bo.isNullOrNil(str2)) {
      str1 = amC(paramString2);
    }
    k.a(paramContext, localIntent, new File(paramString1), str1);
    try
    {
      ab.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserDocumentIntent %s %s %s %s", new Object[] { str1, paramString1, localIntent.toString(), paramString2 });
      label172:
      AppMethodBeat.o(125848);
      return localIntent;
    }
    catch (Exception paramContext)
    {
      break label172;
    }
  }
  
  public static boolean R(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(125840);
    Context localContext = ah.getContext();
    Object localObject1 = new File(paramString1);
    ab.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d fileExt: %s", new Object[] { paramString1, Boolean.valueOf(((File)localObject1).exists()), Long.valueOf(((File)localObject1).length()), paramString2 });
    if (!((File)localObject1).exists())
    {
      ab.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
      AppMethodBeat.o(125840);
      return true;
    }
    String str = amC(paramString2);
    Object localObject2 = amz(str);
    localObject1 = localObject2;
    if (((String)localObject2).equals("com.baidu.searchbox"))
    {
      amA(str);
      localObject1 = "";
    }
    if (!((String)localObject1).equals(""))
    {
      ab.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[] { localObject1 });
      localObject2 = E(localContext, str, paramString1);
      ((Intent)localObject2).setPackage((String)localObject1);
      if (bo.k(localContext, (Intent)localObject2))
      {
        ab.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType %s", new Object[] { str });
        com.tencent.xweb.d.iX(paramString1, paramString2);
        com.tencent.xweb.d.iY(paramString2, "THIRDAPP");
        localContext.startActivity((Intent)localObject2);
        AppMethodBeat.o(125840);
        return false;
      }
      ab.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType %s", new Object[] { str });
    }
    com.tencent.mm.cn.d.iO(ah.getContext());
    if (com.tencent.xweb.d.a(paramString2, d.a.BDa, false, new Intent()) != d.a.BDb)
    {
      if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVz, true))
      {
        localObject1 = G(localContext, paramString1, paramString2);
        if (bo.k(localContext, (Intent)localObject1))
        {
          com.tencent.xweb.d.iX(paramString1, paramString2);
          com.tencent.xweb.d.iY(paramString2, "QQBROWSER");
          ah.getContext().startActivity((Intent)localObject1);
          com.tencent.mm.plugin.report.service.h.qsU.e(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt) });
          AppMethodBeat.o(125840);
          return false;
        }
      }
      localObject1 = F(localContext, str, paramString1);
      if (bo.k(localContext, (Intent)localObject1))
      {
        com.tencent.xweb.d.iX(paramString1, paramString2);
        com.tencent.xweb.d.iY(paramString2, "QQBROWSER");
        ah.getContext().startActivity((Intent)localObject1);
        com.tencent.mm.plugin.report.service.h.qsU.e(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt) });
        AppMethodBeat.o(125840);
        return false;
      }
    }
    int i;
    if (!bo.isNullOrNil(paramString2))
    {
      localObject1 = (String)g.RL().Ru().get(ac.a.yCB, "");
      if ((!bo.isNullOrNil((String)localObject1)) && (((String)localObject1).contains(paramString2))) {
        i = 1;
      }
    }
    while (i != 0) {
      if (paramInt == 7)
      {
        AppMethodBeat.o(125840);
        return true;
        i = 0;
      }
      else
      {
        D(localContext, paramString1, paramString2);
        AppMethodBeat.o(125840);
        return false;
      }
    }
    AppMethodBeat.o(125840);
    return true;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(125845);
    if (paramInt1 == 2)
    {
      if ((-1 == paramInt2) && (paramIntent != null))
      {
        String str = paramIntent.getStringExtra("selectpkg");
        paramIntent = (Intent)paramIntent.getBundleExtra("transferback").getParcelable("targetintent");
        if (paramIntent != null)
        {
          ab.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI select package name %s and target intent is not null", new Object[] { str });
          paramIntent = new Intent(paramIntent);
          paramIntent.setPackage(str);
          if (bo.k(paramActivity, paramIntent))
          {
            paramActivity.startActivity(paramIntent);
            if ("com.tencent.mtt".equals(str))
            {
              com.tencent.mm.plugin.report.service.h.qsU.e(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt5) });
              AppMethodBeat.o(125845);
            }
          }
          else
          {
            ab.e("MicroMsg.AppChooserIntentUtil", "Always Intent is not support mimetype");
            if (paramBoolean) {
              com.tencent.mm.ui.base.h.h(paramActivity, paramInt3, paramInt4);
            }
          }
          AppMethodBeat.o(125845);
          return;
        }
        ab.e("MicroMsg.AppChooserIntentUtil", "AppChooserUI target intent is null in handlerResultOfAppChooserUI");
        if (paramBoolean) {
          com.tencent.mm.ui.base.h.h(paramActivity, paramInt3, paramInt4);
        }
        AppMethodBeat.o(125845);
        return;
      }
      if (4098 == paramInt2)
      {
        ab.e("MicroMsg.AppChooserIntentUtil", "Not Found App Support media type");
        if (paramBoolean)
        {
          com.tencent.mm.ui.base.h.h(paramActivity, paramInt3, paramInt4);
          AppMethodBeat.o(125845);
        }
      }
      else if (4097 == paramInt2)
      {
        ab.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is no choice");
        if (paramBoolean)
        {
          com.tencent.mm.ui.base.h.h(paramActivity, paramInt3, paramInt4);
          AppMethodBeat.o(125845);
        }
      }
      else
      {
        ab.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is not ok or data is null");
      }
    }
    AppMethodBeat.o(125845);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(125841);
    Object localObject1 = new File(paramString1);
    ab.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", new Object[] { paramString1, Boolean.valueOf(((File)localObject1).exists()), Long.valueOf(((File)localObject1).length()) });
    if (!((File)localObject1).exists())
    {
      ab.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
      AppMethodBeat.o(125841);
      return;
    }
    Object localObject3 = ah.getContext();
    Object localObject4 = amC(paramString2);
    Object localObject2 = amz((String)localObject4);
    localObject1 = localObject2;
    if (((String)localObject2).equals("com.baidu.searchbox"))
    {
      amA((String)localObject4);
      localObject1 = "";
    }
    if (!((String)localObject1).equals(""))
    {
      ab.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[] { localObject1 });
      localObject2 = E(ah.getContext(), (String)localObject4, paramString1);
      ((Intent)localObject2).setPackage((String)localObject1);
      if (bo.k((Context)localObject3, (Intent)localObject2))
      {
        ab.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType %s", new Object[] { localObject4 });
        com.tencent.xweb.d.iX(paramString1, paramString2);
        com.tencent.xweb.d.iY(paramString2, "THIRDAPP");
        ((Context)localObject3).startActivity((Intent)localObject2);
        AppMethodBeat.o(125841);
        return;
      }
      ab.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType %s", new Object[] { localObject4 });
    }
    com.tencent.mm.cn.d.iO(ah.getContext());
    if (com.tencent.xweb.d.a(paramString2, d.a.BDa, false, new Intent()) != d.a.BDb)
    {
      if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVz, true))
      {
        localObject1 = G((Context)localObject3, paramString1, paramString2);
        if (bo.k((Context)localObject3, (Intent)localObject1))
        {
          com.tencent.xweb.d.iX(paramString1, paramString2);
          com.tencent.xweb.d.iY(paramString2, "QQBROWSER");
          ah.getContext().startActivity((Intent)localObject1);
          com.tencent.mm.plugin.report.service.h.qsU.e(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt) });
          AppMethodBeat.o(125841);
          return;
        }
      }
      localObject1 = F((Context)localObject3, (String)localObject4, paramString1);
      if (bo.k((Context)localObject3, (Intent)localObject1))
      {
        com.tencent.xweb.d.iX(paramString1, paramString2);
        com.tencent.xweb.d.iY(paramString2, "QQBROWSER");
        ah.getContext().startActivity((Intent)localObject1);
        com.tencent.mm.plugin.report.service.h.qsU.e(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt) });
        AppMethodBeat.o(125841);
        return;
      }
    }
    localObject1 = E((Context)localObject3, (String)localObject4, paramString1);
    int i;
    if (!o.fM(ah.getContext()))
    {
      i = 1;
      localObject2 = amC(paramString2);
      localObject4 = Uri.fromFile(new File(paramString1));
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("targeturl", ((Uri)localObject4).toString());
      ((Bundle)localObject3).putString("filepath", paramString1);
      ((Bundle)localObject3).putString("fileext", paramString2);
      ((Bundle)localObject3).putParcelable("targetintent", (Parcelable)localObject1);
      localObject4 = new Intent();
      ((Intent)localObject4).putExtra("type", 0);
      ((Intent)localObject4).putExtra("title", paramActivity.getResources().getString(2131298352));
      ((Intent)localObject4).putExtra("needupate", false);
      if (i != 0) {
        break label685;
      }
      label579:
      ((Intent)localObject4).putExtra("not_show_recommend_app", bool);
      ((Intent)localObject4).putExtra("mimetype", (String)localObject2);
      ((Intent)localObject4).putExtra("targetintent", (Parcelable)localObject1);
      ((Intent)localObject4).putExtra("transferback", (Bundle)localObject3);
      ((Intent)localObject4).putExtra("scene", paramInt);
      if (paramInt != 7) {
        break label691;
      }
      ((com.tencent.mm.choosemsgfile.compat.a)g.E(com.tencent.mm.choosemsgfile.compat.a.class)).h(paramActivity, paramString1, paramString2);
    }
    for (;;)
    {
      wdj = (Intent)localObject4;
      wdk = new WeakReference(paramActivity);
      AppMethodBeat.o(125841);
      return;
      i = 0;
      break;
      label685:
      bool = false;
      break label579;
      label691:
      D(paramActivity, paramString1, paramString2);
    }
  }
  
  public static void aE(Intent paramIntent)
  {
    AppMethodBeat.i(125844);
    try
    {
      boolean bool1 = paramIntent.getBooleanExtra("MINIQB_OPEN_RET_VAL", false);
      paramIntent.getStringExtra("file_path");
      String str2 = paramIntent.getStringExtra("file_ext");
      ab.i("MicroMsg.AppChooserIntentUtil", "miniQB retVal:%b", new Object[] { Boolean.valueOf(bool1) });
      boolean bool2 = g.RG();
      if (!bool2)
      {
        AppMethodBeat.o(125844);
        return;
      }
      String str1 = (String)g.RL().Ru().get(ac.a.yCB, "");
      if (!bool1) {
        paramIntent = str1.replace(str2, "");
      }
      for (;;)
      {
        g.RL().Ru().set(ac.a.yCB, paramIntent);
        if ((!bool1) && (wdj != null) && (wdk != null) && (wdk.get() != null))
        {
          wdj.setClass((Context)wdk.get(), AppChooserUI.class);
          ((Activity)wdk.get()).startActivityForResult(wdj, 2);
        }
        wdj = null;
        AppMethodBeat.o(125844);
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
      AppMethodBeat.o(125844);
    }
  }
  
  private static void amA(String paramString)
  {
    AppMethodBeat.i(125850);
    if (!g.RG())
    {
      AppMethodBeat.o(125850);
      return;
    }
    g.RL().Ru().set(amB(paramString), "");
    AppMethodBeat.o(125850);
  }
  
  private static int amB(String paramString)
  {
    AppMethodBeat.i(125851);
    if (paramString != null)
    {
      int i = paramString.hashCode();
      AppMethodBeat.o(125851);
      return 274528 + i;
    }
    AppMethodBeat.o(125851);
    return 274528;
  }
  
  private static String amC(String paramString)
  {
    AppMethodBeat.i(125852);
    Object localObject1;
    if (bo.isNullOrNil(paramString)) {
      localObject1 = "application/octet-stream";
    }
    for (;;)
    {
      ab.i("MicroMsg.AppChooserIntentUtil", "getMimeTypeByExt fileExt: %s mimeType: %s", new Object[] { paramString, localObject1 });
      AppMethodBeat.o(125852);
      return localObject1;
      localObject1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
      Object localObject2 = localObject1;
      if (bo.isNullOrNil((String)localObject1)) {
        localObject2 = (String)wdl.get(paramString);
      }
      localObject1 = localObject2;
      if (bo.isNullOrNil((String)localObject2)) {
        if (paramString.startsWith("/")) {
          localObject1 = "application/octet-stream";
        } else {
          localObject1 = "application/".concat(String.valueOf(paramString));
        }
      }
    }
  }
  
  private static String amz(String paramString)
  {
    AppMethodBeat.i(125849);
    paramString = (String)g.RL().Ru().get(amB(paramString), "");
    AppMethodBeat.o(125849);
    return paramString;
  }
  
  public static void b(MMActivity paramMMActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(141599);
    String str = amC(paramString2);
    amA(str);
    Uri localUri = Uri.fromFile(new File(paramString1));
    Bundle localBundle = new Bundle();
    Intent localIntent = E(paramMMActivity, str, paramString1);
    localBundle.putString("targeturl", localUri.toString());
    localBundle.putString("filepath", paramString1);
    localBundle.putString("fileext", paramString2);
    localBundle.putParcelable("targetintent", localIntent);
    paramString1 = new Intent();
    paramString1.putExtra("type", 0);
    paramString1.putExtra("title", paramMMActivity.getResources().getString(2131298352));
    paramString1.putExtra("mimetype", str);
    paramString1.putExtra("targetintent", localIntent);
    paramString1.putExtra("transferback", localBundle);
    paramString1.putExtra("scene", 8);
    paramString1.putExtra("openWay", true);
    com.tencent.mm.bq.d.a(paramMMActivity, ".pluginsdk.ui.tools.AppChooserUI", paramString1, 2, new a.1(paramMMActivity));
    AppMethodBeat.o(141599);
  }
  
  public static boolean b(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(125842);
    String str = amC(paramString2);
    Uri localUri = Uri.fromFile(new File(paramString1));
    Bundle localBundle = new Bundle();
    Intent localIntent = E(paramActivity, str, paramString1);
    localBundle.putString("targeturl", localUri.toString());
    localBundle.putString("filepath", paramString1);
    localBundle.putString("fileext", paramString2);
    localBundle.putParcelable("targetintent", localIntent);
    paramString1 = new Intent(paramActivity, AppChooserUI.class);
    paramString1.putExtra("type", 0);
    paramString1.putExtra("title", paramActivity.getResources().getString(2131298352));
    paramString1.putExtra("mimetype", str);
    paramString1.putExtra("targetintent", localIntent);
    paramString1.putExtra("transferback", localBundle);
    paramString1.putExtra("scene", paramInt);
    paramString1.putExtra("openWay", true);
    paramActivity.startActivityForResult(paramString1, 2);
    AppMethodBeat.o(125842);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.a
 * JD-Core Version:    0.7.0.1
 */