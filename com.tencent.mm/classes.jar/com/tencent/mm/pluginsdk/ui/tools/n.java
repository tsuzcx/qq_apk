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
import com.tencent.mm.bq.d;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.MMFragment;
import java.io.File;

public final class n
{
  private static String filePath = null;
  
  public static boolean G(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(70367);
    boolean bool = d(paramContext, paramIntent, "");
    AppMethodBeat.o(70367);
    return bool;
  }
  
  @Deprecated
  public static String TY(String paramString)
  {
    AppMethodBeat.i(70394);
    paramString = b.TY(paramString);
    AppMethodBeat.o(70394);
    return paramString;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Intent paramIntent)
  {
    AppMethodBeat.i(70388);
    Intent localIntent = new Intent();
    if (paramIntent != null) {
      localIntent.putExtras(paramIntent.getExtras());
    }
    localIntent.putExtra("max_select_count", paramInt2);
    localIntent.putExtra("query_source_type", paramInt3);
    localIntent.putExtra("query_media_type", paramInt4);
    localIntent.putExtra("show_header_view", false);
    localIntent.addFlags(67108864);
    d.b(paramActivity, "gallery", ".ui.GalleryEntryUI", localIntent, paramInt1);
    AppMethodBeat.o(70388);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(70387);
    Intent localIntent = new Intent();
    if (paramIntent != null) {
      localIntent.putExtras(paramIntent.getExtras());
    }
    localIntent.putExtra("max_select_count", paramInt2);
    localIntent.putExtra("query_source_type", paramInt3);
    localIntent.addFlags(67108864);
    d.b(paramActivity, "gallery", ".ui.GalleryEntryUI", localIntent, paramInt1);
    AppMethodBeat.o(70387);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(70391);
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("output", k.d(paramActivity, paramString));
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
      AppMethodBeat.o(70391);
      return;
    }
  }
  
  private static void a(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2)
  {
    AppMethodBeat.i(70389);
    ab.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", new Object[] { Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 706, 4L, "MicroMsg.TakePhotoUtil")) });
    Intent localIntent = new Intent();
    if (!bo.isNullOrNil(paramString2))
    {
      localIntent.putExtra("GalleryUI_FromUser", paramString1);
      localIntent.putExtra("GalleryUI_ToUser", paramString2);
    }
    localIntent.putExtra("max_select_count", paramInt2);
    localIntent.putExtra("query_source_type", paramInt3);
    localIntent.putExtra("query_media_type", paramInt4);
    if (ae.glE) {
      localIntent.putExtra("show_header_view", true);
    }
    for (;;)
    {
      localIntent.addFlags(67108864);
      d.a(paramFragment, "gallery", ".ui.AlbumPreviewUI", localIntent, paramInt1);
      AppMethodBeat.o(70389);
      return;
      localIntent.putExtra("show_header_view", false);
    }
  }
  
  public static void a(Fragment paramFragment, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(70385);
    a(paramFragment, 217, 9, paramInt, 1, paramString1, paramString2);
    AppMethodBeat.o(70385);
  }
  
  public static void a(String paramString, Context paramContext)
  {
    AppMethodBeat.i(156869);
    b.a(paramString, paramContext);
    AppMethodBeat.o(156869);
  }
  
  public static boolean a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(70380);
    a(paramActivity, paramInt, 1, 0, paramIntent);
    AppMethodBeat.o(70380);
    return true;
  }
  
  public static boolean a(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(70369);
    boolean bool = a(paramContext, paramInt1, paramIntent, paramInt2, "", paramInt3, "");
    AppMethodBeat.o(70369);
    return bool;
  }
  
  private static boolean a(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(70372);
    ab.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", new Object[] { Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4L, "MicroMsg.TakePhotoUtil")) });
    SightParams localSightParams1 = null;
    if (paramIntent != null) {
      localSightParams1 = (SightParams)paramIntent.getParcelableExtra("KEY_SIGHT_PARAMS");
    }
    SightParams localSightParams2 = localSightParams1;
    if (localSightParams1 == null) {
      localSightParams2 = new SightParams(paramInt2, paramInt3);
    }
    localSightParams2.oFX = paramString2;
    if (localSightParams2 == null)
    {
      ab.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
      if (paramInt2 == 1)
      {
        paramString1 = t.ve(paramString1);
        o.alE();
        paramString2 = t.vf(paramString1);
        o.alE();
        localSightParams2.q(paramString1, paramString2, t.vg(paramString1), com.tencent.mm.compatible.util.e.esr + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
      }
      if (localSightParams2 != null) {
        break label250;
      }
      ab.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
    }
    for (;;)
    {
      d.b(paramContext, "mmsight", ".ui.SightCaptureUI", paramIntent, paramInt1);
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(2131034259, -1);
      }
      AppMethodBeat.o(70372);
      return true;
      paramIntent.putExtra("KEY_SIGHT_PARAMS", localSightParams2);
      break;
      label250:
      paramIntent.putExtra("KEY_SIGHT_PARAMS", localSightParams2);
    }
  }
  
  public static boolean a(Fragment paramFragment, Intent paramIntent, String paramString, int paramInt)
  {
    AppMethodBeat.i(70366);
    ab.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", new Object[] { Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4L, "MicroMsg.TakePhotoUtil")) });
    SightParams localSightParams = new SightParams(1, paramInt);
    paramString = t.ve(paramString);
    o.alE();
    String str = t.vf(paramString);
    o.alE();
    localSightParams.q(paramString, str, t.vg(paramString), com.tencent.mm.compatible.util.e.esr + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
    paramIntent.putExtra("KEY_SIGHT_PARAMS", localSightParams);
    d.a(paramFragment, "mmsight", ".ui.SightCaptureUI", paramIntent, 226);
    paramFragment.getActivity().overridePendingTransition(2131034259, -1);
    AppMethodBeat.o(70366);
    return true;
  }
  
  public static boolean a(MMFragment paramMMFragment, String paramString1, String paramString2)
  {
    AppMethodBeat.i(70375);
    boolean bool = b(paramMMFragment, paramString1, paramString2);
    ab.i("MicroMsg.TakePhotoUtil", "takePhoto(), dir = [%s], filename = [%s], cmd = [%s], result = [%s]", new Object[] { paramString1, paramString2, Integer.valueOf(201), Boolean.valueOf(bool) });
    AppMethodBeat.o(70375);
    return bool;
  }
  
  @TargetApi(8)
  public static String aok()
  {
    return com.tencent.mm.compatible.util.e.esr;
  }
  
  public static boolean ar(Activity paramActivity)
  {
    AppMethodBeat.i(70381);
    a(paramActivity, 2, 1, 0, 1, null);
    AppMethodBeat.o(70381);
    return true;
  }
  
  public static boolean as(Activity paramActivity)
  {
    AppMethodBeat.i(70382);
    a(paramActivity, 205, 1, 11, null);
    AppMethodBeat.o(70382);
    return true;
  }
  
  public static void b(Fragment paramFragment, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(70386);
    a(paramFragment, 217, 9, paramInt, 3, paramString1, paramString2);
    AppMethodBeat.o(70386);
  }
  
  private static boolean b(MMFragment paramMMFragment, String paramString1, String paramString2)
  {
    AppMethodBeat.i(70376);
    if (paramMMFragment == null)
    {
      ab.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys fragment is null!");
      AppMethodBeat.o(70376);
      return false;
    }
    if ((com.tencent.mm.r.a.bN(paramMMFragment.getContext())) || (com.tencent.mm.r.a.bM(paramMMFragment.getContext())))
    {
      AppMethodBeat.o(70376);
      return false;
    }
    filePath = paramString1 + paramString2;
    ab.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
    bC(paramMMFragment.getContext(), filePath);
    paramString2 = new Intent("android.media.action.IMAGE_CAPTURE");
    File localFile = new File(paramString1);
    if (!localFile.exists()) {}
    try
    {
      localFile.mkdirs();
      if (!localFile.exists())
      {
        ab.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), dir not exist. ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(70376);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TakePhotoUtil", localException, "", new Object[0]);
      }
      paramString1 = new File(filePath);
      paramString2.putExtra("output", k.d(paramMMFragment.getContext(), paramString1));
      try
      {
        paramMMFragment.startActivityForResult(paramString2, 201);
        AppMethodBeat.o(70376);
        return true;
      }
      catch (ActivityNotFoundException paramMMFragment)
      {
        ab.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), " + paramMMFragment.getMessage());
        AppMethodBeat.o(70376);
      }
    }
    return false;
  }
  
  private static void bC(Context paramContext, String paramString)
  {
    AppMethodBeat.i(70379);
    paramContext = paramContext.getSharedPreferences("system_config_prefs", 0).edit();
    paramContext.putString("camera_file_path", paramString);
    paramContext.commit();
    AppMethodBeat.o(70379);
  }
  
  public static boolean c(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(70377);
    boolean bool = d(paramActivity, paramString1, paramString2, paramInt);
    ab.i("MicroMsg.TakePhotoUtil", "takePhoto(), dir = [%s], filename = [%s], cmd = [%s], result = [%s]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    AppMethodBeat.o(70377);
    return bool;
  }
  
  public static boolean c(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(156868);
    boolean bool = d(paramContext, paramIntent, paramString);
    AppMethodBeat.o(156868);
    return bool;
  }
  
  private static boolean d(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(70378);
    if ((com.tencent.mm.r.a.bN(paramActivity)) || (com.tencent.mm.r.a.bM(paramActivity)))
    {
      AppMethodBeat.o(70378);
      return false;
    }
    ab.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", new Object[] { Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4L, "MicroMsg.TakePhotoUtil")) });
    filePath = paramString1 + paramString2;
    ab.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
    bC(paramActivity, filePath);
    paramString2 = new Intent("android.media.action.IMAGE_CAPTURE");
    File localFile = new File(paramString1);
    if (!localFile.exists()) {}
    try
    {
      localFile.mkdirs();
      if (!localFile.exists())
      {
        ab.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), dir not exist. ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(70378);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TakePhotoUtil", localException, "", new Object[0]);
      }
      paramString2.putExtra("output", k.d(paramActivity, new File(filePath)));
      try
      {
        paramActivity.startActivityForResult(paramString2, paramInt);
        AppMethodBeat.o(70378);
        return true;
      }
      catch (Exception paramActivity)
      {
        ab.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), " + paramActivity.getMessage());
        AppMethodBeat.o(70378);
      }
    }
    return false;
  }
  
  private static boolean d(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(70370);
    boolean bool = a(paramContext, 17, paramIntent, 2, "", 0, paramString);
    AppMethodBeat.o(70370);
    return bool;
  }
  
  public static String dpF()
  {
    AppMethodBeat.i(70396);
    String str = b.dpF();
    AppMethodBeat.o(70396);
    return str;
  }
  
  public static void e(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70390);
    paramIntent.putExtra("max_select_count", paramInt1);
    paramIntent.putExtra("query_media_type", 2);
    paramIntent.putExtra("query_source_type", paramInt2);
    paramIntent.addFlags(67108864);
    d.b(paramActivity, "gallery", ".ui.GalleryEntryUI", paramIntent, 4);
    AppMethodBeat.o(70390);
  }
  
  public static boolean e(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(70371);
    boolean bool = a(paramContext, 8, paramIntent, 1, paramString, 0, "");
    AppMethodBeat.o(70371);
    return bool;
  }
  
  public static boolean f(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(70373);
    boolean bool = g(paramContext, paramIntent, paramString);
    AppMethodBeat.o(70373);
    return bool;
  }
  
  private static boolean g(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(70374);
    Object localObject1 = null;
    if (paramIntent != null) {
      localObject1 = (SightParams)paramIntent.getParcelableExtra("KEY_SIGHT_PARAMS");
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new SightParams(2, 0);
    }
    ((SightParams)localObject2).oFX = paramString;
    if (localObject2 == null) {
      ab.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
    }
    try
    {
      for (;;)
      {
        paramContext.startActivity(paramIntent);
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).overridePendingTransition(2131034259, -1);
        }
        AppMethodBeat.o(70374);
        return true;
        localObject1 = ((SightParams)localObject2).oFX;
        paramString = (String)localObject1;
        if (bo.isNullOrNil((String)localObject1)) {
          paramString = bo.aoy() + "_" + bo.Ng(5);
        }
        localObject1 = new StringBuilder("weishi://camera?forceNoShowLogin=1");
        ab.d("MicroMsg.TakePhotoUtil", "weishi_url = %s", new Object[] { ((StringBuilder)localObject1).toString() });
        paramIntent.setAction("android.intent.action.VIEW");
        paramIntent.setData(Uri.parse(((StringBuilder)localObject1).toString()));
        paramIntent.setPackage("com.tencent.weishi");
        paramIntent.setFlags(268435456);
        localObject1 = paramIntent.getPackage();
        paramContext.getSharedPreferences("opensdk_shareTicket", 0).edit().putString((String)localObject1, paramString).apply();
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ab.w("MicroMsg.TakePhotoUtil", "takeWeishiSight Exception: %s", new Object[] { paramContext.getMessage() });
      }
    }
  }
  
  public static boolean g(Fragment paramFragment)
  {
    AppMethodBeat.i(70383);
    a(paramFragment, 200, 1, 0, 1, "", "");
    AppMethodBeat.o(70383);
    return true;
  }
  
  public static String h(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(70392);
    if (filePath == null) {
      filePath = paramContext.getSharedPreferences("system_config_prefs", 0).getString("camera_file_path", null);
    }
    if ((filePath == null) || (!com.tencent.mm.a.e.cN(filePath))) {
      filePath = com.tencent.mm.ui.tools.a.i(paramContext, paramIntent, paramString);
    }
    b.a(filePath, paramContext);
    paramContext = filePath;
    AppMethodBeat.o(70392);
    return paramContext;
  }
  
  public static void k(String paramString, Context paramContext)
  {
    AppMethodBeat.i(70393);
    q.a(paramString, paramContext, 2131300722);
    AppMethodBeat.o(70393);
  }
  
  public static boolean m(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(70384);
    a(paramActivity, paramInt, 1, 5, null);
    AppMethodBeat.o(70384);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.n
 * JD-Core Version:    0.7.0.1
 */