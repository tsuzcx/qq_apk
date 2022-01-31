package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.webkit.MimeTypeMap;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.d.a.f;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.e.i;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class a
{
  private static Intent skD;
  private static WeakReference<Activity> skE;
  private static final HashMap<String, String> skF;
  
  static
  {
    HashMap localHashMap = new HashMap();
    skF = localHashMap;
    localHashMap.put("wps", "application/wps");
    skF.put("ett", "application/ett");
    skF.put("log", "application/log");
    skF.put("wpt", "application/wpt");
    skF.put("et", "application/et");
    skF.put("ksdps", "application/ksdps");
    skF.put("kset", "application/kset");
    skF.put("kswps", "application/kswps");
  }
  
  private static String WR(String paramString)
  {
    int i = 274528;
    z localz = g.DP().Dz();
    if (paramString != null) {
      i = 274528 + paramString.hashCode();
    }
    return (String)localz.get(i, "");
  }
  
  private static String WS(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.length() > 0) {
        localObject1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() != 0) {}
    }
    else
    {
      localObject2 = (String)skF.get(paramString);
    }
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      y.w("MicroMsg.AppChooserIntentUtil", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
      localObject1 = "*/" + paramString;
    }
    return localObject1;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5)
  {
    String str;
    if (paramInt1 == 2)
    {
      if ((-1 != paramInt2) || (paramIntent == null)) {
        break label262;
      }
      str = paramIntent.getStringExtra("selectpkg");
      Object localObject2 = paramIntent.getBundleExtra("transferback");
      paramIntent = (Intent)((Bundle)localObject2).getParcelable("targetintent");
      Object localObject1 = ((Bundle)localObject2).getString("filepath");
      localObject2 = ((Bundle)localObject2).getString("fileext");
      if (paramIntent == null) {
        break label240;
      }
      y.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI select package name %s and target intent is not null", new Object[] { str });
      if ((!"com.tencent.mtt".equals(str)) || (localObject1 == null)) {
        break label181;
      }
      localObject1 = fX((String)localObject1, (String)localObject2);
      ((Intent)localObject1).addFlags(524288);
      ((Intent)localObject1).putExtra("ChannelID", "com.tencent.mm");
      ((Intent)localObject1).putExtra("PosID", 4);
      if (!bk.i(paramActivity, (Intent)localObject1)) {
        break label181;
      }
      y.i("MicroMsg.AppChooserIntentUtil", "user has installed new version of QQbrowser");
      paramActivity.startActivity((Intent)localObject1);
      com.tencent.mm.plugin.report.service.h.nFQ.f(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt5) });
    }
    label181:
    label240:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramIntent = new Intent(paramIntent);
            paramIntent.setPackage(str);
            paramIntent.addFlags(524288);
            if (bk.i(paramActivity, paramIntent))
            {
              paramActivity.startActivity(paramIntent);
              return;
            }
            y.e("MicroMsg.AppChooserIntentUtil", "Always Intent is not support mimetype");
          } while (!paramBoolean);
          com.tencent.mm.ui.base.h.h(paramActivity, paramInt3, paramInt4);
          return;
          y.e("MicroMsg.AppChooserIntentUtil", "AppChooserUI target intent is null in handlerResultOfAppChooserUI");
        } while (!paramBoolean);
        com.tencent.mm.ui.base.h.h(paramActivity, paramInt3, paramInt4);
        return;
        if (4098 != paramInt2) {
          break;
        }
        y.e("MicroMsg.AppChooserIntentUtil", "Not Found App Support media type");
      } while (!paramBoolean);
      com.tencent.mm.ui.base.h.h(paramActivity, paramInt3, paramInt4);
      return;
      if (4097 != paramInt2) {
        break;
      }
      y.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is no choice");
    } while (!paramBoolean);
    label262:
    com.tencent.mm.ui.base.h.h(paramActivity, paramInt3, paramInt4);
    return;
    y.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is not ok or data is null");
  }
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = new File(paramString1);
    y.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", new Object[] { paramString1, Boolean.valueOf(((File)localObject1).exists()), Long.valueOf(((File)localObject1).length()) });
    if (!((File)localObject1).exists())
    {
      y.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
      return true;
    }
    localObject1 = WS(paramString2);
    Object localObject2 = WR((String)localObject1);
    if (!((String)localObject2).equals(""))
    {
      y.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[] { localObject2 });
      Intent localIntent = fV((String)localObject1, paramString1);
      localIntent.setPackage((String)localObject2);
      if (bk.i(paramActivity, localIntent))
      {
        y.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType");
        paramActivity.startActivity(localIntent);
        return false;
      }
      y.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
      y.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
    }
    localObject2 = w(paramActivity, (String)localObject1, paramString1);
    y.i("MicroMsg.AppChooserIntentUtil", "QQBrowser status is %s", new Object[] { ((a.a)localObject2).name() });
    if (localObject2 == a.a.skK)
    {
      localObject2 = fX(paramString1, paramString2);
      if (bk.i(paramActivity, (Intent)localObject2))
      {
        ((Intent)localObject2).setFlags(268435456);
        paramActivity.startActivity((Intent)localObject2);
        com.tencent.mm.plugin.report.service.h.nFQ.f(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt) });
        return false;
      }
      ((Intent)localObject2).setFlags(268435456);
      localObject1 = fW((String)localObject1, paramString1);
      if (bk.i(paramActivity, (Intent)localObject1))
      {
        paramActivity.startActivity((Intent)localObject1);
        com.tencent.mm.plugin.report.service.h.nFQ.f(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt) });
        y.e("MicroMsg.AppChooserIntentUtil", "Occur error, has bugs, status is install and support but not found support activity");
      }
    }
    else
    {
      if (bk.bl(paramString2)) {
        break label393;
      }
      localObject1 = (String)g.DP().Dz().get(ac.a.usB, "");
      if ((bk.bl((String)localObject1)) || (!((String)localObject1).contains(paramString2))) {
        break label393;
      }
    }
    label393:
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      c(paramActivity, paramString1, paramString2);
      return false;
      y.e("MicroMsg.AppChooserIntentUtil", "Occur error, has bugs, status is install and support but not found support activity");
      return true;
    }
    return true;
  }
  
  public static void ai(Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("MINIQB_OPEN_RET_VAL", false);
    paramIntent.getStringExtra("file_path");
    String str2 = paramIntent.getStringExtra("file_ext");
    y.i("MicroMsg.AppChooserIntentUtil", "miniQB retVal:%b", new Object[] { Boolean.valueOf(bool) });
    if (!g.DK()) {
      return;
    }
    String str1 = (String)g.DP().Dz().get(ac.a.usB, "");
    if (!bool) {
      paramIntent = str1.replace(str2, "");
    }
    for (;;)
    {
      g.DP().Dz().c(ac.a.usB, paramIntent);
      if ((!bool) && (skD != null) && (skE != null) && (skE.get() != null))
      {
        skD.setClass((Context)skE.get(), AppChooserUI.class);
        ((Activity)skE.get()).startActivityForResult(skD, 2);
      }
      skD = null;
      return;
      paramIntent = str1;
      if (!str1.contains(str2)) {
        paramIntent = str1.concat(str2);
      }
    }
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    boolean bool2 = true;
    Object localObject1 = new File(paramString1);
    y.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", new Object[] { paramString1, Boolean.valueOf(((File)localObject1).exists()), Long.valueOf(((File)localObject1).length()) });
    if (!((File)localObject1).exists())
    {
      y.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
      return;
    }
    localObject1 = WS(paramString2);
    Object localObject2 = WR((String)localObject1);
    Object localObject3;
    if (!((String)localObject2).equals(""))
    {
      y.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[] { localObject2 });
      localObject3 = fV((String)localObject1, paramString1);
      ((Intent)localObject3).setPackage((String)localObject2);
      if (bk.i(paramActivity, (Intent)localObject3))
      {
        y.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType");
        paramActivity.startActivity((Intent)localObject3);
        return;
      }
      y.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
    }
    localObject2 = w(paramActivity, (String)localObject1, paramString1);
    y.i("MicroMsg.AppChooserIntentUtil", "QQBrowser status is %s", new Object[] { ((a.a)localObject2).name() });
    int i;
    Object localObject4;
    switch (a.1.skG[localObject2.ordinal()])
    {
    default: 
      localObject1 = fV((String)localObject1, paramString1);
      i = 1;
      bool1 = false;
      localObject2 = WS(paramString2);
      localObject4 = Uri.fromFile(new File(paramString1));
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("targeturl", ((Uri)localObject4).toString());
      ((Bundle)localObject3).putString("filepath", paramString1);
      ((Bundle)localObject3).putString("fileext", paramString2);
      ((Bundle)localObject3).putParcelable("targetintent", (Parcelable)localObject1);
      localObject4 = new Intent();
      ((Intent)localObject4).putExtra("type", 0);
      ((Intent)localObject4).putExtra("title", paramActivity.getResources().getString(a.f.choose_app));
      ((Intent)localObject4).putExtra("needupate", bool1);
      if (i != 0) {
        break;
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((Intent)localObject4).putExtra("not_show_recommend_app", bool1);
      ((Intent)localObject4).putExtra("mimetype", (String)localObject2);
      ((Intent)localObject4).putExtra("targetintent", (Parcelable)localObject1);
      ((Intent)localObject4).putExtra("transferback", (Bundle)localObject3);
      ((Intent)localObject4).putExtra("scene", paramInt);
      c(paramActivity, paramString1, paramString2);
      skD = (Intent)localObject4;
      skE = new WeakReference(paramActivity);
      return;
      localObject1 = fV((String)localObject1, paramString1);
      i = 1;
      bool1 = false;
      break;
      localObject1 = fV((String)localObject1, paramString1);
      i = 0;
      bool1 = false;
      break;
      localObject1 = fV((String)localObject1, paramString1);
      i = 1;
      bool1 = true;
      break;
      localObject2 = fX(paramString1, paramString2);
      if (bk.i(paramActivity, (Intent)localObject2))
      {
        paramActivity.startActivity((Intent)localObject2);
        return;
      }
      localObject1 = fV((String)localObject1, paramString1);
      i = 1;
      bool1 = false;
      break;
    }
  }
  
  private static void c(Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("file_path", paramString1);
    localIntent.putExtra("file_ext", paramString2);
    localIntent.setComponent(new ComponentName(e.i.hle, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE");
    paramActivity.sendBroadcast(localIntent);
  }
  
  private static Intent fV(String paramString1, String paramString2)
  {
    paramString2 = Uri.fromFile(new File(paramString2));
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setDataAndType(paramString2, paramString1);
    return localIntent;
  }
  
  private static Intent fW(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setPackage("com.tencent.mtt");
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.fromFile(new File(paramString2)), paramString1);
    return localIntent;
  }
  
  private static Intent fX(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document");
    File localFile = new File(paramString1);
    localIntent.setPackage("com.tencent.mtt");
    localIntent.putExtra("ChannelID", "com.tencent.mm");
    localIntent.putExtra("PosID", 4);
    localIntent.putExtra("key_reader_sdk_id", 1);
    localIntent.putExtra("key_reader_sdk_type", 0);
    localIntent.putExtra("key_reader_sdk_format", paramString2);
    localIntent.putExtra("key_reader_sdk_path", paramString1);
    localIntent.setData(Uri.fromFile(localFile));
    return localIntent;
  }
  
  private static a.a w(Context paramContext, String paramString1, String paramString2)
  {
    if (o.eM(paramContext))
    {
      if (bk.i(paramContext, fW(paramString1, paramString2))) {
        return a.a.skK;
      }
      if (o.VO(paramString1)) {
        return a.a.skI;
      }
      return a.a.skJ;
    }
    return a.a.skH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.a
 * JD-Core Version:    0.7.0.1
 */