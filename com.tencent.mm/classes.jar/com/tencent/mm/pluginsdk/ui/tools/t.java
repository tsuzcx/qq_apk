package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ar.a.a;
import com.tencent.mm.plugin.ar.a.h;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.tools.b;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public final class t
{
  private static String filePath = null;
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(245577);
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
    localIntent.putExtra("show_header_view", paramBoolean);
    localIntent.addFlags(67108864);
    com.tencent.mm.br.c.b(paramActivity, "gallery", ".ui.GalleryEntryUI", localIntent, paramInt1);
    AppMethodBeat.o(245577);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(116240);
    a(paramActivity, paramInt1, paramInt2, paramInt3, paramIntent, true);
    AppMethodBeat.o(116240);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(245573);
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
    com.tencent.mm.br.c.b(paramActivity, "gallery", ".ui.GalleryEntryUI", localIntent, paramInt1);
    AppMethodBeat.o(245573);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(116245);
    paramString = new u(paramString);
    if (paramString.jKS()) {
      paramString.diJ();
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
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(paramInt1, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/pluginsdk/ui/tools/TakePhotoUtil", "selectVideoFromSys", "(Landroid/app/Activity;Ljava/lang/String;IIIIZ)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(116245);
      return;
    }
  }
  
  private static void a(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2)
  {
    AppMethodBeat.i(245579);
    a(paramFragment, paramInt1, paramInt2, paramInt3, paramInt4, paramString1, paramString2, null);
    AppMethodBeat.o(245579);
  }
  
  private static void a(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(245582);
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
    if (z.pDl) {
      localIntent.putExtra("show_header_view", true);
    }
    for (;;)
    {
      localIntent.addFlags(67108864);
      localIntent.putExtra("animation_push_up_in", true);
      com.tencent.mm.br.c.a(paramFragment, "gallery", ".ui.AlbumPreviewUI", localIntent, paramInt1);
      AppMethodBeat.o(245582);
      return;
      localIntent.putExtra("show_header_view", false);
    }
  }
  
  public static void a(Fragment paramFragment, int paramInt, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(245565);
    a(paramFragment, 217, 9, paramInt, 1, paramString1, paramString2, paramIntent);
    AppMethodBeat.o(245565);
  }
  
  public static void a(Fragment paramFragment, String paramString1, String paramString2)
  {
    AppMethodBeat.i(245567);
    a(paramFragment, 217, 9, 9, 3, paramString1, paramString2);
    AppMethodBeat.o(245567);
  }
  
  public static void a(Fragment paramFragment, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(245569);
    a(paramFragment, 217, 9, 3, 3, paramString1, paramString2, paramIntent);
    AppMethodBeat.o(245569);
  }
  
  public static boolean a(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(116217);
    boolean bool = a(paramContext, paramInt1, paramIntent, paramInt2, "", paramInt3, "");
    AppMethodBeat.o(116217);
    return bool;
  }
  
  public static boolean a(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2, String paramString)
  {
    AppMethodBeat.i(245500);
    boolean bool = b(paramContext, paramInt1, paramIntent, paramInt2, paramString);
    AppMethodBeat.o(245500);
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
    localSightParams2.FUP = paramString2;
    if (localSightParams2 == null)
    {
      Log.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
      if (paramInt2 == 1)
      {
        paramString1 = aa.PW(paramString1);
        v.bOh();
        paramString2 = aa.PX(paramString1);
        v.bOh();
        localSightParams2.D(paramString1, paramString2, aa.PY(paramString1), AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
      }
      if (localSightParams2 != null) {
        break label252;
      }
      Log.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
    }
    for (;;)
    {
      com.tencent.mm.br.c.b(paramContext, "mmsight", ".ui.SightCaptureUI", paramIntent, paramInt1);
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(a.a.sight_slide_bottom_in, -1);
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
    ((SightParams)localObject).FUP = paramString1;
    if (localObject == null) {
      Log.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
    }
    try
    {
      for (;;)
      {
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/pluginsdk/ui/tools/TakePhotoUtil", "takeWeiShiSightToEdit", "(Landroid/content/Context;ILandroid/content/Intent;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/pluginsdk/ui/tools/TakePhotoUtil", "takeWeiShiSightToEdit", "(Landroid/content/Context;ILandroid/content/Intent;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).overridePendingTransition(a.a.sight_slide_bottom_in, -1);
        }
        AppMethodBeat.o(116223);
        return true;
        localObject = ((SightParams)localObject).FUP;
        paramString1 = (String)localObject;
        if (Util.isNullOrNil((String)localObject)) {
          paramString1 = Util.nowMilliSecond() + "_" + Util.getRandomString(5);
        }
        if (Util.isNullOrNil(paramString2)) {
          Log.e("MicroMsg.TakePhotoUtil", "path is null");
        }
        if (!new u(paramString2).jKS()) {
          Log.e("MicroMsg.TakePhotoUtil", "file is not exists");
        }
        paramString2 = brQ(paramString2);
        Log.d("MicroMsg.TakePhotoUtil", "weishi_uri = %s", new Object[] { paramString2 });
        paramIntent.setAction("android.intent.action.VIEW");
        paramIntent.setData(Uri.parse(paramString2));
        paramIntent.setPackage("com.tencent.weishi");
        paramIntent.setFlags(268435456);
        ah(paramContext, paramIntent.getPackage(), paramString1);
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
    AppMethodBeat.i(245496);
    Log.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", new Object[] { Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4L, "MicroMsg.TakePhotoUtil")) });
    SightParams localSightParams = new SightParams(1, paramInt);
    paramString = aa.PW(paramString);
    v.bOh();
    String str = aa.PX(paramString);
    v.bOh();
    localSightParams.D(paramString, str, aa.PY(paramString), AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
    paramIntent.putExtra("KEY_SIGHT_PARAMS", localSightParams);
    com.tencent.mm.br.c.a(paramFragment, "mmsight", ".ui.SightCaptureUI", paramIntent, 226);
    paramFragment.getActivity().overridePendingTransition(a.a.sight_slide_bottom_in, -1);
    AppMethodBeat.o(245496);
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
  
  public static boolean aP(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(116215);
    boolean bool = a(paramContext, 17, paramIntent, 2, "");
    AppMethodBeat.o(116215);
    return bool;
  }
  
  private static void ah(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116225);
    paramContext.getSharedPreferences("opensdk_shareTicket", 0).edit().putString(paramString1, paramString2).apply();
    AppMethodBeat.o(116225);
  }
  
  private static boolean b(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2, String paramString)
  {
    AppMethodBeat.i(245503);
    boolean bool = a(paramContext, paramInt1, paramIntent, paramInt2, "", 0, paramString);
    AppMethodBeat.o(245503);
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
    if ((com.tencent.mm.n.a.p(paramMMFragment.getContext(), true)) || (com.tencent.mm.n.a.dl(paramMMFragment.getContext())) || (com.tencent.mm.n.a.dp(paramMMFragment.getContext())))
    {
      AppMethodBeat.o(116227);
      return false;
    }
    filePath = y.n(paramString1 + paramString2, true);
    Log.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
    cM(paramMMFragment.getContext(), filePath);
    paramString2 = new Intent("android.media.action.IMAGE_CAPTURE");
    u localu = new u(paramString1);
    if (!localu.jKS()) {}
    try
    {
      localu.jKY();
      if (!localu.jKS())
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
      paramString1 = new u(filePath);
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
  
  public static boolean bI(Activity paramActivity)
  {
    AppMethodBeat.i(116233);
    a(paramActivity, 205, 1, 11, null);
    AppMethodBeat.o(116233);
    return true;
  }
  
  public static boolean bJ(Activity paramActivity)
  {
    AppMethodBeat.i(245560);
    a(paramActivity, 5, 1, 31, 3, true, null);
    AppMethodBeat.o(245560);
    return true;
  }
  
  public static boolean bK(Activity paramActivity)
  {
    AppMethodBeat.i(116236);
    a(paramActivity, 300, 1, 24, null);
    AppMethodBeat.o(116236);
    return true;
  }
  
  public static String brQ(String paramString)
  {
    AppMethodBeat.i(116224);
    paramString = "weishi://videoEdit?videoPath=" + paramString + "&activity_id=WxPublisherAct&update=1";
    AppMethodBeat.o(116224);
    return paramString;
  }
  
  private static void cM(Context paramContext, String paramString)
  {
    AppMethodBeat.i(116230);
    paramContext = paramContext.getSharedPreferences("system_config_prefs", 0).edit();
    paramContext.putString("camera_file_path", paramString);
    paramContext.commit();
    AppMethodBeat.o(116230);
  }
  
  public static boolean d(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(116231);
    a(paramActivity, paramInt, 1, 0, paramIntent);
    AppMethodBeat.o(116231);
    return true;
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
    AppMethodBeat.i(116219);
    boolean bool = a(paramContext, 8, paramIntent, 1, paramString, 0, "");
    AppMethodBeat.o(116219);
    return bool;
  }
  
  public static void e(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(116244);
    paramIntent.putExtra("max_select_count", paramInt1);
    paramIntent.putExtra("query_media_type", 2);
    paramIntent.putExtra("query_source_type", paramInt2);
    paramIntent.addFlags(67108864);
    com.tencent.mm.br.c.b(paramActivity, "gallery", ".ui.GalleryEntryUI", paramIntent, 4);
    AppMethodBeat.o(116244);
  }
  
  private static boolean e(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(116229);
    if ((com.tencent.mm.n.a.p(paramActivity, true)) || (com.tencent.mm.n.a.dl(paramActivity)) || (com.tencent.mm.n.a.dp(paramActivity)))
    {
      AppMethodBeat.o(116229);
      return false;
    }
    Log.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", new Object[] { Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4L, "MicroMsg.TakePhotoUtil")) });
    filePath = y.n(paramString1 + paramString2, true);
    Log.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
    cM(paramActivity, filePath);
    paramString2 = new Intent("android.media.action.IMAGE_CAPTURE");
    u localu = new u(paramString1);
    if (!localu.jKS()) {}
    try
    {
      localu.jKY();
      if (!localu.jKS())
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
      paramString2.putExtra("output", FileProviderHelper.getUriForFile(paramActivity, new u(filePath)));
      try
      {
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramString2).aYi(), "com/tencent/mm/pluginsdk/ui/tools/TakePhotoUtil", "takePhotoFromSys", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;I)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
        Log.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys()");
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
    AppMethodBeat.i(116221);
    boolean bool = f(paramContext, paramIntent, paramString);
    AppMethodBeat.o(116221);
    return bool;
  }
  
  private static boolean f(Context paramContext, Intent paramIntent, String paramString)
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
    ((SightParams)localObject2).FUP = paramString;
    if (localObject2 == null) {
      Log.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
    }
    try
    {
      for (;;)
      {
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/pluginsdk/ui/tools/TakePhotoUtil", "takeWeiShiSight", "(Landroid/content/Context;ILandroid/content/Intent;ILjava/lang/String;ILjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/pluginsdk/ui/tools/TakePhotoUtil", "takeWeiShiSight", "(Landroid/content/Context;ILandroid/content/Intent;ILjava/lang/String;ILjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).overridePendingTransition(a.a.sight_slide_bottom_in, -1);
        }
        AppMethodBeat.o(116222);
        return true;
        localObject1 = ((SightParams)localObject2).FUP;
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
        ah(paramContext, paramIntent.getPackage(), paramString);
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
  
  public static String g(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(116246);
    if (filePath == null) {
      filePath = paramContext.getSharedPreferences("system_config_prefs", 0).getString("camera_file_path", null);
    }
    if (!y.ZC(filePath)) {
      filePath = b.i(paramContext, paramIntent, paramString);
    }
    AndroidMediaUtil.refreshMediaScanner(filePath, paramContext);
    paramContext = filePath;
    AppMethodBeat.o(116246);
    return paramContext;
  }
  
  public static boolean g(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(245558);
    a(paramActivity, 2, 1, 0, 1, paramBoolean, null);
    AppMethodBeat.o(245558);
    return true;
  }
  
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
  
  public static void o(String paramString, Context paramContext)
  {
    AppMethodBeat.i(116247);
    ExportFileUtil.a(paramContext, paramString, new ExportFileUtil.a()
    {
      public final void cg(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(245539);
        Toast.makeText(t.this, t.this.getString(a.h.image_saved, new Object[] { paramAnonymousString2 }), 1).show();
        AppMethodBeat.o(245539);
      }
      
      public final void ch(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(245544);
        Toast.makeText(t.this, t.this.getString(a.h.save_image_err), 1).show();
        AppMethodBeat.o(245544);
      }
    });
    AppMethodBeat.o(116247);
  }
  
  public static boolean r(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(116235);
    a(paramActivity, paramInt, 1, 5, null);
    AppMethodBeat.o(116235);
    return true;
  }
  
  public static void refreshMediaScanner(String paramString, Context paramContext)
  {
    AppMethodBeat.i(369600);
    AndroidMediaUtil.refreshMediaScanner(paramString, paramContext);
    AppMethodBeat.o(369600);
  }
  
  public static boolean x(Fragment paramFragment)
  {
    AppMethodBeat.i(245561);
    a(paramFragment, 200, 1, 0, 1, "", "");
    AppMethodBeat.o(245561);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.t
 * JD-Core Version:    0.7.0.1
 */