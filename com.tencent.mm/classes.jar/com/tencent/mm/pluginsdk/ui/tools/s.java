package com.tencent.mm.pluginsdk.ui.tools;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMFragment;

public final class s
{
  private static String filePath = null;
  
  private static void U(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116225);
    paramContext.getSharedPreferences("opensdk_shareTicket", 0).edit().putString(paramString1, paramString2).apply();
    AppMethodBeat.o(116225);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Intent paramIntent)
  {
    AppMethodBeat.i(116241);
    Intent localIntent = new Intent();
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null) {
        localIntent.putExtras(paramIntent);
      }
    }
    localIntent.putExtra("max_select_count", paramInt2);
    localIntent.putExtra("query_source_type", paramInt3);
    localIntent.putExtra("query_media_type", paramInt4);
    localIntent.putExtra("show_header_view", false);
    localIntent.addFlags(67108864);
    c.b(paramActivity, "gallery", ".ui.GalleryEntryUI", localIntent, paramInt1);
    AppMethodBeat.o(116241);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(116240);
    a(paramActivity, paramInt1, paramInt2, paramInt3, paramIntent, true);
    AppMethodBeat.o(116240);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(204066);
    Intent localIntent = new Intent();
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null) {
        localIntent.putExtras(paramIntent);
      }
    }
    localIntent.putExtra("max_select_count", paramInt2);
    localIntent.putExtra("query_source_type", paramInt3);
    localIntent.putExtra("need_to_clear_top", paramBoolean);
    if (paramBoolean) {
      localIntent.addFlags(67108864);
    }
    c.b(paramActivity, "gallery", ".ui.GalleryEntryUI", localIntent, paramInt1);
    AppMethodBeat.o(204066);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(116245);
    paramString = new com.tencent.mm.vfs.o(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("output", FileProviderHelper.getUriForFile(paramActivity, paramString));
    localIntent.putExtra("android.intent.extra.videoQuality", paramInt3);
    if (paramBoolean) {}
    for (paramInt3 = 1;; paramInt3 = 0)
    {
      localIntent.putExtra("android.intent.extras.CAMERA_FACING", paramInt3);
      if (paramInt2 > 0) {
        localIntent.putExtra("android.intent.extra.durationLimit", paramInt2);
      }
      localIntent.setAction("android.media.action.VIDEO_CAPTURE");
      localIntent.addCategory("android.intent.category.DEFAULT");
      paramActivity.startActivityForResult(localIntent, paramInt1);
      AppMethodBeat.o(116245);
      return;
    }
  }
  
  private static void a(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116242);
    a(paramFragment, paramInt1, paramInt2, paramInt3, paramInt4, paramString1, paramString2, null);
    AppMethodBeat.o(116242);
  }
  
  private static void a(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(116243);
    Log.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", new Object[] { Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 706, 4L, "MicroMsg.TakePhotoUtil")) });
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!Util.isNullOrNil(paramString2))
    {
      localIntent.putExtra("GalleryUI_FromUser", paramString1);
      localIntent.putExtra("GalleryUI_ToUser", paramString2);
    }
    localIntent.putExtra("max_select_count", paramInt2);
    localIntent.putExtra("query_source_type", paramInt3);
    localIntent.putExtra("query_media_type", paramInt4);
    if (ac.jPB) {
      localIntent.putExtra("show_header_view", true);
    }
    for (;;)
    {
      localIntent.addFlags(67108864);
      localIntent.putExtra("animation_push_up_in", true);
      c.a(paramFragment, "gallery", ".ui.AlbumPreviewUI", localIntent, paramInt1);
      AppMethodBeat.o(116243);
      return;
      localIntent.putExtra("show_header_view", false);
    }
  }
  
  public static void a(Fragment paramFragment, int paramInt, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(116237);
    a(paramFragment, 217, 9, paramInt, 1, paramString1, paramString2, paramIntent);
    AppMethodBeat.o(116237);
  }
  
  public static void a(Fragment paramFragment, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116238);
    a(paramFragment, 217, 9, 9, 3, paramString1, paramString2);
    AppMethodBeat.o(116238);
  }
  
  public static void a(Fragment paramFragment, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(116239);
    a(paramFragment, 217, 9, 3, 3, paramString1, paramString2, paramIntent);
    AppMethodBeat.o(116239);
  }
  
  public static boolean a(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(116217);
    boolean bool = a(paramContext, paramInt1, paramIntent, paramInt2, "", paramInt3, "");
    AppMethodBeat.o(116217);
    return bool;
  }
  
  private static boolean a(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2, String paramString)
  {
    AppMethodBeat.i(204065);
    boolean bool = a(paramContext, 17, paramIntent, 2, "", 0, paramString);
    AppMethodBeat.o(204065);
    return bool;
  }
  
  private static boolean a(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(116220);
    Log.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", new Object[] { Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4L, "MicroMsg.TakePhotoUtil")) });
    SightParams localSightParams1 = null;
    if (paramIntent != null) {
      localSightParams1 = (SightParams)paramIntent.getParcelableExtra("KEY_SIGHT_PARAMS");
    }
    SightParams localSightParams2 = localSightParams1;
    if (localSightParams1 == null) {
      localSightParams2 = new SightParams(paramInt2, paramInt3);
    }
    localSightParams2.vPa = paramString2;
    if (localSightParams2 == null)
    {
      Log.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
      if (paramInt2 == 1)
      {
        paramString1 = t.Qv(paramString1);
        com.tencent.mm.modelvideo.o.bhj();
        paramString2 = t.Qw(paramString1);
        com.tencent.mm.modelvideo.o.bhj();
        localSightParams2.v(paramString1, paramString2, t.Qx(paramString1), AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
      }
      if (localSightParams2 != null) {
        break label252;
      }
      Log.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
    }
    for (;;)
    {
      c.b(paramContext, "mmsight", ".ui.SightCaptureUI", paramIntent, paramInt1);
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(2130772161, -1);
      }
      AppMethodBeat.o(116220);
      return true;
      paramIntent.putExtra("KEY_SIGHT_PARAMS", localSightParams2);
      break;
      label252:
      paramIntent.putExtra("KEY_SIGHT_PARAMS", localSightParams2);
    }
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116223);
    SightParams localSightParams = (SightParams)paramIntent.getParcelableExtra("KEY_SIGHT_PARAMS");
    Object localObject = localSightParams;
    if (localSightParams == null) {
      localObject = new SightParams(2, 0);
    }
    ((SightParams)localObject).vPa = paramString1;
    if (localObject == null) {
      Log.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
    }
    try
    {
      for (;;)
      {
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/pluginsdk/ui/tools/TakePhotoUtil", "takeWeiShiSightToEdit", "(Landroid/content/Context;ILandroid/content/Intent;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/ui/tools/TakePhotoUtil", "takeWeiShiSightToEdit", "(Landroid/content/Context;ILandroid/content/Intent;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).overridePendingTransition(2130772161, -1);
        }
        AppMethodBeat.o(116223);
        return true;
        localObject = ((SightParams)localObject).vPa;
        paramString1 = (String)localObject;
        if (Util.isNullOrNil((String)localObject)) {
          paramString1 = Util.nowMilliSecond() + "_" + Util.getRandomString(5);
        }
        if (Util.isNullOrNil(paramString2)) {
          Log.e("MicroMsg.TakePhotoUtil", "path is null");
        }
        if (!new com.tencent.mm.vfs.o(paramString2).exists()) {
          Log.e("MicroMsg.TakePhotoUtil", "file is not exists");
        }
        paramString2 = bfE(paramString2);
        Log.d("MicroMsg.TakePhotoUtil", "weishi_uri = %s", new Object[] { paramString2 });
        paramIntent.setAction("android.intent.action.VIEW");
        paramIntent.setData(Uri.parse(paramString2));
        paramIntent.setPackage("com.tencent.weishi");
        paramIntent.setFlags(268435456);
        U(paramContext, paramIntent.getPackage(), paramString1);
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.w("MicroMsg.TakePhotoUtil", "takeWeishiSight Exception: %s", new Object[] { paramContext.getMessage() });
      }
    }
  }
  
  public static boolean a(Fragment paramFragment, Intent paramIntent, String paramString, int paramInt)
  {
    AppMethodBeat.i(116214);
    Log.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", new Object[] { Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4L, "MicroMsg.TakePhotoUtil")) });
    SightParams localSightParams = new SightParams(1, paramInt);
    paramString = t.Qv(paramString);
    com.tencent.mm.modelvideo.o.bhj();
    String str = t.Qw(paramString);
    com.tencent.mm.modelvideo.o.bhj();
    localSightParams.v(paramString, str, t.Qx(paramString), AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
    paramIntent.putExtra("KEY_SIGHT_PARAMS", localSightParams);
    c.a(paramFragment, "mmsight", ".ui.SightCaptureUI", paramIntent, 226);
    paramFragment.getActivity().overridePendingTransition(2130772161, -1);
    AppMethodBeat.o(116214);
    return true;
  }
  
  public static boolean a(MMFragment paramMMFragment, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116226);
    boolean bool = b(paramMMFragment, paramString1, paramString2);
    Log.i("MicroMsg.TakePhotoUtil", "takePhoto(), dir = [%s], filename = [%s], cmd = [%s], result = [%s]", new Object[] { paramString1, paramString2, Integer.valueOf(201), Boolean.valueOf(bool) });
    AppMethodBeat.o(116226);
    return bool;
  }
  
  public static boolean aY(Activity paramActivity)
  {
    AppMethodBeat.i(116232);
    a(paramActivity, 2, 1, 0, 1, null);
    AppMethodBeat.o(116232);
    return true;
  }
  
  public static boolean aZ(Activity paramActivity)
  {
    AppMethodBeat.i(116233);
    a(paramActivity, 205, 1, 11, null);
    AppMethodBeat.o(116233);
    return true;
  }
  
  public static boolean ax(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(116215);
    boolean bool = d(paramContext, paramIntent, "");
    AppMethodBeat.o(116215);
    return bool;
  }
  
  private static boolean b(MMFragment paramMMFragment, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116227);
    if (paramMMFragment == null)
    {
      Log.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys fragment is null!");
      AppMethodBeat.o(116227);
      return false;
    }
    if ((com.tencent.mm.q.a.o(paramMMFragment.getContext(), true)) || (com.tencent.mm.q.a.cA(paramMMFragment.getContext())) || (com.tencent.mm.q.a.cE(paramMMFragment.getContext())))
    {
      AppMethodBeat.o(116227);
      return false;
    }
    filePath = com.tencent.mm.vfs.s.k(paramString1 + paramString2, true);
    Log.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
    cq(paramMMFragment.getContext(), filePath);
    paramString2 = new Intent("android.media.action.IMAGE_CAPTURE");
    com.tencent.mm.vfs.o localo = new com.tencent.mm.vfs.o(paramString1);
    if (!localo.exists()) {}
    try
    {
      localo.mkdirs();
      if (!localo.exists())
      {
        Log.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), dir not exist. ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(116227);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TakePhotoUtil", localException, "", new Object[0]);
      }
      paramString1 = new com.tencent.mm.vfs.o(filePath);
      paramString2.putExtra("output", FileProviderHelper.getUriForFile(paramMMFragment.getContext(), paramString1));
      try
      {
        paramMMFragment.startActivityForResult(paramString2, 201);
        AppMethodBeat.o(116227);
        return true;
      }
      catch (ActivityNotFoundException paramMMFragment)
      {
        Log.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), " + paramMMFragment.getMessage());
        AppMethodBeat.o(116227);
      }
    }
    return false;
  }
  
  public static boolean ba(Activity paramActivity)
  {
    AppMethodBeat.i(116236);
    a(paramActivity, 300, 1, 24, null);
    AppMethodBeat.o(116236);
    return true;
  }
  
  public static String bfE(String paramString)
  {
    AppMethodBeat.i(116224);
    paramString = "weishi://videoEdit?videoPath=" + paramString + "&activity_id=WxPublisherAct&update=1";
    AppMethodBeat.o(116224);
    return paramString;
  }
  
  public static boolean c(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(116231);
    a(paramActivity, paramInt, 1, 0, paramIntent);
    AppMethodBeat.o(116231);
    return true;
  }
  
  private static void cq(Context paramContext, String paramString)
  {
    AppMethodBeat.i(116230);
    paramContext = paramContext.getSharedPreferences("system_config_prefs", 0).edit();
    paramContext.putString("camera_file_path", paramString);
    paramContext.commit();
    AppMethodBeat.o(116230);
  }
  
  public static boolean d(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(116228);
    boolean bool = e(paramActivity, paramString1, paramString2, paramInt);
    Log.i("MicroMsg.TakePhotoUtil", "takePhoto(), dir = [%s], filename = [%s], cmd = [%s], result = [%s]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    AppMethodBeat.o(116228);
    return bool;
  }
  
  public static boolean d(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(186125);
    boolean bool = a(paramContext, 17, paramIntent, 2, paramString);
    AppMethodBeat.o(186125);
    return bool;
  }
  
  public static void e(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(116244);
    paramIntent.putExtra("max_select_count", paramInt1);
    paramIntent.putExtra("query_media_type", 2);
    paramIntent.putExtra("query_source_type", paramInt2);
    paramIntent.addFlags(67108864);
    c.b(paramActivity, "gallery", ".ui.GalleryEntryUI", paramIntent, 4);
    AppMethodBeat.o(116244);
  }
  
  private static boolean e(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(116229);
    if ((com.tencent.mm.q.a.o(paramActivity, true)) || (com.tencent.mm.q.a.cA(paramActivity)) || (com.tencent.mm.q.a.cE(paramActivity)))
    {
      AppMethodBeat.o(116229);
      return false;
    }
    Log.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", new Object[] { Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4L, "MicroMsg.TakePhotoUtil")) });
    filePath = com.tencent.mm.vfs.s.k(paramString1 + paramString2, true);
    Log.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
    cq(paramActivity, filePath);
    paramString2 = new Intent("android.media.action.IMAGE_CAPTURE");
    com.tencent.mm.vfs.o localo = new com.tencent.mm.vfs.o(paramString1);
    if (!localo.exists()) {}
    try
    {
      localo.mkdirs();
      if (!localo.exists())
      {
        Log.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), dir not exist. ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(116229);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TakePhotoUtil", localException, "", new Object[0]);
      }
      paramString2.putExtra("output", FileProviderHelper.getUriForFile(paramActivity, new com.tencent.mm.vfs.o(filePath)));
      try
      {
        paramActivity.startActivityForResult(paramString2, paramInt);
        AppMethodBeat.o(116229);
        return true;
      }
      catch (Exception paramActivity)
      {
        Log.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), " + paramActivity.getMessage());
        AppMethodBeat.o(116229);
      }
    }
    return false;
  }
  
  public static boolean e(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(116219);
    boolean bool = a(paramContext, 8, paramIntent, 1, paramString, 0, "");
    AppMethodBeat.o(116219);
    return bool;
  }
  
  public static boolean f(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(116221);
    boolean bool = g(paramContext, paramIntent, paramString);
    AppMethodBeat.o(116221);
    return bool;
  }
  
  public static boolean f(Fragment paramFragment)
  {
    AppMethodBeat.i(116234);
    a(paramFragment, 200, 1, 0, 1, "", "");
    AppMethodBeat.o(116234);
    return true;
  }
  
  private static boolean g(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(116222);
    Object localObject1 = null;
    if (paramIntent != null) {
      localObject1 = (SightParams)paramIntent.getParcelableExtra("KEY_SIGHT_PARAMS");
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new SightParams(2, 0);
    }
    ((SightParams)localObject2).vPa = paramString;
    if (localObject2 == null) {
      Log.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
    }
    try
    {
      for (;;)
      {
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/pluginsdk/ui/tools/TakePhotoUtil", "takeWeiShiSight", "(Landroid/content/Context;ILandroid/content/Intent;ILjava/lang/String;ILjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/ui/tools/TakePhotoUtil", "takeWeiShiSight", "(Landroid/content/Context;ILandroid/content/Intent;ILjava/lang/String;ILjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).overridePendingTransition(2130772161, -1);
        }
        AppMethodBeat.o(116222);
        return true;
        localObject1 = ((SightParams)localObject2).vPa;
        paramString = (String)localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          paramString = Util.nowMilliSecond() + "_" + Util.getRandomString(5);
        }
        localObject1 = new StringBuilder("weishi://camera?forceNoShowLogin=1");
        Log.d("MicroMsg.TakePhotoUtil", "weishi_url = %s", new Object[] { ((StringBuilder)localObject1).toString() });
        paramIntent.setAction("android.intent.action.VIEW");
        paramIntent.setData(Uri.parse(((StringBuilder)localObject1).toString()));
        paramIntent.setPackage("com.tencent.weishi");
        paramIntent.setFlags(268435456);
        U(paramContext, paramIntent.getPackage(), paramString);
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.w("MicroMsg.TakePhotoUtil", "takeWeishiSight Exception: %s", new Object[] { paramContext.getMessage() });
      }
    }
  }
  
  @TargetApi(8)
  public static String getSysCameraDirPath()
  {
    AppMethodBeat.i(177105);
    String str = AndroidMediaUtil.getSysCameraDirPath();
    AppMethodBeat.o(177105);
    return str;
  }
  
  public static String getToastSysCameraPath()
  {
    AppMethodBeat.i(116250);
    String str = AndroidMediaUtil.getToastSysCameraPath();
    AppMethodBeat.o(116250);
    return str;
  }
  
  public static String h(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(116246);
    if (filePath == null) {
      filePath = paramContext.getSharedPreferences("system_config_prefs", 0).getString("camera_file_path", null);
    }
    if (!com.tencent.mm.vfs.s.YS(filePath)) {
      filePath = com.tencent.mm.ui.tools.a.i(paramContext, paramIntent, paramString);
    }
    AndroidMediaUtil.refreshMediaScanner(filePath, paramContext);
    paramContext = filePath;
    AppMethodBeat.o(116246);
    return paramContext;
  }
  
  public static void l(String paramString, Context paramContext)
  {
    AppMethodBeat.i(116247);
    p.a(paramContext, paramString, new s.1(paramContext));
    AppMethodBeat.o(116247);
  }
  
  public static boolean o(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(116235);
    a(paramActivity, paramInt, 1, 5, null);
    AppMethodBeat.o(116235);
    return true;
  }
  
  public static void refreshMediaScanner(String paramString, Context paramContext)
  {
    AppMethodBeat.i(258654);
    AndroidMediaUtil.refreshMediaScanner(paramString, paramContext);
    AppMethodBeat.o(258654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.s
 * JD-Core Version:    0.7.0.1
 */