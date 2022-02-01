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
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public final class q
{
  private static String filePath = null;
  
  private static void N(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116225);
    paramContext.getSharedPreferences("opensdk_shareTicket", 0).edit().putString(paramString1, paramString2).apply();
    AppMethodBeat.o(116225);
  }
  
  public static boolean S(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(116215);
    boolean bool = d(paramContext, paramIntent, "");
    AppMethodBeat.o(116215);
    return bool;
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
    d.b(paramActivity, "gallery", ".ui.GalleryEntryUI", localIntent, paramInt1);
    AppMethodBeat.o(116241);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(116240);
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
    localIntent.addFlags(67108864);
    d.b(paramActivity, "gallery", ".ui.GalleryEntryUI", localIntent, paramInt1);
    AppMethodBeat.o(116240);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(116245);
    paramString = new e(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("output", m.a(paramActivity, paramString));
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
    ad.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", new Object[] { Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 706, 4L, "MicroMsg.TakePhotoUtil")) });
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!bt.isNullOrNil(paramString2))
    {
      localIntent.putExtra("GalleryUI_FromUser", paramString1);
      localIntent.putExtra("GalleryUI_ToUser", paramString2);
    }
    localIntent.putExtra("max_select_count", paramInt2);
    localIntent.putExtra("query_source_type", paramInt3);
    localIntent.putExtra("query_media_type", paramInt4);
    if (ab.hWB) {
      localIntent.putExtra("show_header_view", true);
    }
    for (;;)
    {
      localIntent.addFlags(67108864);
      localIntent.putExtra("animation_push_up_in", true);
      d.a(paramFragment, "gallery", ".ui.AlbumPreviewUI", localIntent, paramInt1);
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
  
  private static boolean a(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(116220);
    ad.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", new Object[] { Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4L, "MicroMsg.TakePhotoUtil")) });
    SightParams localSightParams1 = null;
    if (paramIntent != null) {
      localSightParams1 = (SightParams)paramIntent.getParcelableExtra("KEY_SIGHT_PARAMS");
    }
    SightParams localSightParams2 = localSightParams1;
    if (localSightParams1 == null) {
      localSightParams2 = new SightParams(paramInt2, paramInt3);
    }
    localSightParams2.tBg = paramString2;
    if (localSightParams2 == null)
    {
      ad.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
      if (paramInt2 == 1)
      {
        paramString1 = t.zP(paramString1);
        o.aCI();
        paramString2 = t.zQ(paramString1);
        o.aCI();
        localSightParams2.p(paramString1, paramString2, t.zR(paramString1), com.tencent.mm.loader.j.b.ais() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
      }
      if (localSightParams2 != null) {
        break label252;
      }
      ad.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
    }
    for (;;)
    {
      d.b(paramContext, "mmsight", ".ui.SightCaptureUI", paramIntent, paramInt1);
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(2130772137, -1);
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
    ((SightParams)localObject).tBg = paramString1;
    if (localObject == null) {
      ad.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
    }
    try
    {
      for (;;)
      {
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/pluginsdk/ui/tools/TakePhotoUtil", "takeWeiShiSightToEdit", "(Landroid/content/Context;ILandroid/content/Intent;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/ui/tools/TakePhotoUtil", "takeWeiShiSightToEdit", "(Landroid/content/Context;ILandroid/content/Intent;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).overridePendingTransition(2130772137, -1);
        }
        AppMethodBeat.o(116223);
        return true;
        localObject = ((SightParams)localObject).tBg;
        paramString1 = (String)localObject;
        if (bt.isNullOrNil((String)localObject)) {
          paramString1 = bt.eGO() + "_" + bt.Wl(5);
        }
        if (bt.isNullOrNil(paramString2)) {
          ad.e("MicroMsg.TakePhotoUtil", "path is null");
        }
        if (!new e(paramString2).exists()) {
          ad.e("MicroMsg.TakePhotoUtil", "file is not exists");
        }
        paramString2 = aCJ(paramString2);
        ad.d("MicroMsg.TakePhotoUtil", "weishi_uri = %s", new Object[] { paramString2 });
        paramIntent.setAction("android.intent.action.VIEW");
        paramIntent.setData(Uri.parse(paramString2));
        paramIntent.setPackage("com.tencent.weishi");
        paramIntent.setFlags(268435456);
        N(paramContext, paramIntent.getPackage(), paramString1);
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ad.w("MicroMsg.TakePhotoUtil", "takeWeishiSight Exception: %s", new Object[] { paramContext.getMessage() });
      }
    }
  }
  
  public static boolean a(Fragment paramFragment, Intent paramIntent, String paramString, int paramInt)
  {
    AppMethodBeat.i(116214);
    ad.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", new Object[] { Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4L, "MicroMsg.TakePhotoUtil")) });
    SightParams localSightParams = new SightParams(1, paramInt);
    paramString = t.zP(paramString);
    o.aCI();
    String str = t.zQ(paramString);
    o.aCI();
    localSightParams.p(paramString, str, t.zR(paramString), com.tencent.mm.loader.j.b.ais() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
    paramIntent.putExtra("KEY_SIGHT_PARAMS", localSightParams);
    d.a(paramFragment, "mmsight", ".ui.SightCaptureUI", paramIntent, 226);
    paramFragment.getActivity().overridePendingTransition(2130772137, -1);
    AppMethodBeat.o(116214);
    return true;
  }
  
  public static boolean a(MMFragment paramMMFragment, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116226);
    boolean bool = b(paramMMFragment, paramString1, paramString2);
    ad.i("MicroMsg.TakePhotoUtil", "takePhoto(), dir = [%s], filename = [%s], cmd = [%s], result = [%s]", new Object[] { paramString1, paramString2, Integer.valueOf(201), Boolean.valueOf(bool) });
    AppMethodBeat.o(116226);
    return bool;
  }
  
  public static String aCJ(String paramString)
  {
    AppMethodBeat.i(116224);
    paramString = "weishi://videoEdit?videoPath=" + paramString + "&activity_id=WxPublisherAct&update=1";
    AppMethodBeat.o(116224);
    return paramString;
  }
  
  public static boolean aN(Activity paramActivity)
  {
    AppMethodBeat.i(116232);
    a(paramActivity, 2, 1, 0, 1, null);
    AppMethodBeat.o(116232);
    return true;
  }
  
  public static boolean aO(Activity paramActivity)
  {
    AppMethodBeat.i(116233);
    a(paramActivity, 205, 1, 11, null);
    AppMethodBeat.o(116233);
    return true;
  }
  
  public static boolean aP(Activity paramActivity)
  {
    AppMethodBeat.i(116236);
    a(paramActivity, 300, 1, 24, null);
    AppMethodBeat.o(116236);
    return true;
  }
  
  @Deprecated
  public static String ahd(String paramString)
  {
    AppMethodBeat.i(116248);
    paramString = com.tencent.mm.sdk.f.b.ahd(paramString);
    AppMethodBeat.o(116248);
    return paramString;
  }
  
  private static boolean b(MMFragment paramMMFragment, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116227);
    if (paramMMFragment == null)
    {
      ad.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys fragment is null!");
      AppMethodBeat.o(116227);
      return false;
    }
    if ((com.tencent.mm.r.a.cd(paramMMFragment.getContext())) || (com.tencent.mm.r.a.cc(paramMMFragment.getContext())))
    {
      AppMethodBeat.o(116227);
      return false;
    }
    filePath = i.k(paramString1 + paramString2, true);
    ad.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
    bQ(paramMMFragment.getContext(), filePath);
    paramString2 = new Intent("android.media.action.IMAGE_CAPTURE");
    e locale = new e(paramString1);
    if (!locale.exists()) {}
    try
    {
      locale.mkdirs();
      if (!locale.exists())
      {
        ad.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), dir not exist. ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(116227);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.TakePhotoUtil", localException, "", new Object[0]);
      }
      paramString1 = new e(filePath);
      paramString2.putExtra("output", m.a(paramMMFragment.getContext(), paramString1));
      try
      {
        paramMMFragment.startActivityForResult(paramString2, 201);
        AppMethodBeat.o(116227);
        return true;
      }
      catch (ActivityNotFoundException paramMMFragment)
      {
        ad.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), " + paramMMFragment.getMessage());
        AppMethodBeat.o(116227);
      }
    }
    return false;
  }
  
  private static void bQ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(116230);
    paramContext = paramContext.getSharedPreferences("system_config_prefs", 0).edit();
    paramContext.putString("camera_file_path", paramString);
    paramContext.commit();
    AppMethodBeat.o(116230);
  }
  
  public static boolean c(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(116231);
    a(paramActivity, paramInt, 1, 0, paramIntent);
    AppMethodBeat.o(116231);
    return true;
  }
  
  public static boolean c(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(204993);
    boolean bool = d(paramContext, paramIntent, paramString);
    AppMethodBeat.o(204993);
    return bool;
  }
  
  public static void d(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(116244);
    paramIntent.putExtra("max_select_count", paramInt1);
    paramIntent.putExtra("query_media_type", 2);
    paramIntent.putExtra("query_source_type", paramInt2);
    paramIntent.addFlags(67108864);
    d.b(paramActivity, "gallery", ".ui.GalleryEntryUI", paramIntent, 4);
    AppMethodBeat.o(116244);
  }
  
  public static boolean d(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(116228);
    boolean bool = e(paramActivity, paramString1, paramString2, paramInt);
    ad.i("MicroMsg.TakePhotoUtil", "takePhoto(), dir = [%s], filename = [%s], cmd = [%s], result = [%s]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    AppMethodBeat.o(116228);
    return bool;
  }
  
  private static boolean d(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(116218);
    boolean bool = a(paramContext, 17, paramIntent, 2, "", 0, paramString);
    AppMethodBeat.o(116218);
    return bool;
  }
  
  private static boolean e(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(116229);
    if ((com.tencent.mm.r.a.cd(paramActivity)) || (com.tencent.mm.r.a.cc(paramActivity)))
    {
      AppMethodBeat.o(116229);
      return false;
    }
    ad.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", new Object[] { Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4L, "MicroMsg.TakePhotoUtil")) });
    filePath = i.k(paramString1 + paramString2, true);
    ad.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
    bQ(paramActivity, filePath);
    paramString2 = new Intent("android.media.action.IMAGE_CAPTURE");
    e locale = new e(paramString1);
    if (!locale.exists()) {}
    try
    {
      locale.mkdirs();
      if (!locale.exists())
      {
        ad.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), dir not exist. ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(116229);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.TakePhotoUtil", localException, "", new Object[0]);
      }
      paramString2.putExtra("output", m.a(paramActivity, new e(filePath)));
      try
      {
        paramActivity.startActivityForResult(paramString2, paramInt);
        AppMethodBeat.o(116229);
        return true;
      }
      catch (Exception paramActivity)
      {
        ad.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), " + paramActivity.getMessage());
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
  
  @TargetApi(8)
  public static String eAS()
  {
    AppMethodBeat.i(177105);
    String str = com.tencent.mm.loader.j.b.ais();
    AppMethodBeat.o(177105);
    return str;
  }
  
  public static String eAT()
  {
    AppMethodBeat.i(116250);
    String str = com.tencent.mm.sdk.f.b.eAT();
    AppMethodBeat.o(116250);
    return str;
  }
  
  public static boolean f(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(116221);
    boolean bool = g(paramContext, paramIntent, paramString);
    AppMethodBeat.o(116221);
    return bool;
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
    ((SightParams)localObject2).tBg = paramString;
    if (localObject2 == null) {
      ad.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
    }
    try
    {
      for (;;)
      {
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/pluginsdk/ui/tools/TakePhotoUtil", "takeWeiShiSight", "(Landroid/content/Context;ILandroid/content/Intent;ILjava/lang/String;ILjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/ui/tools/TakePhotoUtil", "takeWeiShiSight", "(Landroid/content/Context;ILandroid/content/Intent;ILjava/lang/String;ILjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).overridePendingTransition(2130772137, -1);
        }
        AppMethodBeat.o(116222);
        return true;
        localObject1 = ((SightParams)localObject2).tBg;
        paramString = (String)localObject1;
        if (bt.isNullOrNil((String)localObject1)) {
          paramString = bt.eGO() + "_" + bt.Wl(5);
        }
        localObject1 = new StringBuilder("weishi://camera?forceNoShowLogin=1");
        ad.d("MicroMsg.TakePhotoUtil", "weishi_url = %s", new Object[] { ((StringBuilder)localObject1).toString() });
        paramIntent.setAction("android.intent.action.VIEW");
        paramIntent.setData(Uri.parse(((StringBuilder)localObject1).toString()));
        paramIntent.setPackage("com.tencent.weishi");
        paramIntent.setFlags(268435456);
        N(paramContext, paramIntent.getPackage(), paramString);
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ad.w("MicroMsg.TakePhotoUtil", "takeWeishiSight Exception: %s", new Object[] { paramContext.getMessage() });
      }
    }
  }
  
  public static boolean g(Fragment paramFragment)
  {
    AppMethodBeat.i(116234);
    a(paramFragment, 200, 1, 0, 1, "", "");
    AppMethodBeat.o(116234);
    return true;
  }
  
  public static String h(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(116246);
    if (filePath == null) {
      filePath = paramContext.getSharedPreferences("system_config_prefs", 0).getString("camera_file_path", null);
    }
    if (!i.eK(filePath)) {
      filePath = com.tencent.mm.ui.tools.a.i(paramContext, paramIntent, paramString);
    }
    com.tencent.mm.sdk.f.b.k(filePath, paramContext);
    paramContext = filePath;
    AppMethodBeat.o(116246);
    return paramContext;
  }
  
  public static void j(String paramString, Context paramContext)
  {
    AppMethodBeat.i(116247);
    p.a(paramContext, paramString, new p.a()
    {
      public final void bv(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(193465);
        Toast.makeText(this.val$context, this.val$context.getString(2131760319, new Object[] { paramAnonymousString2 }), 1).show();
        AppMethodBeat.o(193465);
      }
      
      public final void bw(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(193466);
        Toast.makeText(this.val$context, this.val$context.getString(2131762779), 1).show();
        AppMethodBeat.o(193466);
      }
    });
    AppMethodBeat.o(116247);
  }
  
  public static void k(String paramString, Context paramContext)
  {
    AppMethodBeat.i(204994);
    com.tencent.mm.sdk.f.b.k(paramString, paramContext);
    AppMethodBeat.o(204994);
  }
  
  public static boolean o(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(116235);
    a(paramActivity, paramInt, 1, 5, null);
    AppMethodBeat.o(116235);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.q
 * JD-Core Version:    0.7.0.1
 */