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
import com.tencent.mm.br.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.ai.a.a;
import com.tencent.mm.plugin.ai.a.h;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.x;
import java.io.File;

public final class l
{
  private static String filePath = null;
  
  public static boolean T(Activity paramActivity)
  {
    a(paramActivity, 2, 1, 0, 1, false, null);
    return true;
  }
  
  public static void U(Activity paramActivity)
  {
    a(paramActivity, 2, 1, 10, 1, true, null);
  }
  
  public static String UL()
  {
    return q.UL();
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Intent paramIntent)
  {
    Intent localIntent = new Intent();
    if (paramIntent != null) {
      localIntent.putExtras(paramIntent.getExtras());
    }
    localIntent.putExtra("max_select_count", paramInt2);
    localIntent.putExtra("query_source_type", paramInt3);
    localIntent.putExtra("query_media_type", paramInt4);
    localIntent.putExtra("show_header_view", paramBoolean);
    localIntent.addFlags(67108864);
    d.b(paramActivity, "gallery", ".ui.GalleryEntryUI", localIntent, paramInt1);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    Intent localIntent = new Intent();
    if (paramIntent != null) {
      localIntent.putExtras(paramIntent.getExtras());
    }
    localIntent.putExtra("max_select_count", paramInt2);
    localIntent.putExtra("query_source_type", paramInt3);
    localIntent.addFlags(67108864);
    d.b(paramActivity, "gallery", ".ui.GalleryEntryUI", localIntent, paramInt1);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("output", Uri.fromFile(paramString));
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
      return;
    }
  }
  
  private static void a(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    if (!bk.bl(paramString2))
    {
      localIntent.putExtra("GalleryUI_FromUser", paramString1);
      localIntent.putExtra("GalleryUI_ToUser", paramString2);
    }
    localIntent.putExtra("max_select_count", paramInt2);
    localIntent.putExtra("query_source_type", paramInt3);
    localIntent.putExtra("query_media_type", paramInt4);
    if (ae.eTJ) {
      localIntent.putExtra("show_header_view", true);
    }
    for (;;)
    {
      localIntent.addFlags(67108864);
      d.a(paramFragment, "gallery", ".ui.AlbumPreviewUI", localIntent, paramInt1);
      return;
      localIntent.putExtra("show_header_view", false);
    }
  }
  
  public static void a(Fragment paramFragment, int paramInt, String paramString1, String paramString2)
  {
    a(paramFragment, 217, 9, paramInt, 1, paramString1, paramString2);
  }
  
  public static void a(String paramString, Context paramContext)
  {
    q.a(paramString, paramContext);
  }
  
  public static boolean a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    a(paramActivity, paramInt, 1, 0, paramIntent);
    return true;
  }
  
  public static boolean a(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3)
  {
    return a(paramContext, paramInt1, paramIntent, paramInt2, "", paramInt3, "");
  }
  
  private static boolean a(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    SightParams localSightParams1 = null;
    if (paramIntent != null) {
      localSightParams1 = (SightParams)paramIntent.getParcelableExtra("KEY_SIGHT_PARAMS");
    }
    SightParams localSightParams2 = localSightParams1;
    if (localSightParams1 == null) {
      localSightParams2 = new SightParams(paramInt2, paramInt3);
    }
    localSightParams2.mfz = paramString2;
    if (paramInt2 == 1)
    {
      paramString1 = t.nR(paramString1);
      o.Sr();
      paramString2 = t.nS(paramString1);
      o.Sr();
      localSightParams2.o(paramString1, paramString2, t.nT(paramString1), com.tencent.mm.compatible.util.e.dzD + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
    }
    if (localSightParams2 == null) {
      y.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
    }
    for (;;)
    {
      d.b(paramContext, "mmsight", ".ui.SightCaptureUI", paramIntent, paramInt1);
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(a.a.sight_slide_bottom_in, -1);
      }
      return true;
      paramIntent.putExtra("KEY_SIGHT_PARAMS", localSightParams2);
    }
  }
  
  public static boolean a(Fragment paramFragment, Intent paramIntent, String paramString, int paramInt)
  {
    SightParams localSightParams = new SightParams(1, paramInt);
    paramString = t.nR(paramString);
    o.Sr();
    String str = t.nS(paramString);
    o.Sr();
    localSightParams.o(paramString, str, t.nT(paramString), com.tencent.mm.compatible.util.e.dzD + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
    paramIntent.putExtra("KEY_SIGHT_PARAMS", localSightParams);
    d.a(paramFragment, "mmsight", ".ui.SightCaptureUI", paramIntent, 226);
    paramFragment.getActivity().overridePendingTransition(a.a.sight_slide_bottom_in, -1);
    return true;
  }
  
  public static boolean a(x paramx, String paramString1, String paramString2)
  {
    boolean bool = b(paramx, paramString1, paramString2);
    y.i("MicroMsg.TakePhotoUtil", "takePhoto(), dir = [%s], filename = [%s], cmd = [%s], result = [%s]", new Object[] { paramString1, paramString2, Integer.valueOf(201), Boolean.valueOf(bool) });
    return bool;
  }
  
  public static void b(Fragment paramFragment, int paramInt, String paramString1, String paramString2)
  {
    a(paramFragment, 217, 9, paramInt, 3, paramString1, paramString2);
  }
  
  public static boolean b(Context paramContext, Intent paramIntent, String paramString)
  {
    return a(paramContext, 17, paramIntent, 2, "", 0, paramString);
  }
  
  private static boolean b(x paramx, String paramString1, String paramString2)
  {
    if ((com.tencent.mm.r.a.bj(paramx.getContext())) || (com.tencent.mm.r.a.bi(paramx.getContext()))) {
      return false;
    }
    filePath = paramString1 + paramString2;
    y.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
    bq(paramx.getContext(), filePath);
    paramString2 = new Intent("android.media.action.IMAGE_CAPTURE");
    File localFile = new File(paramString1);
    if (!localFile.exists()) {}
    try
    {
      localFile.mkdirs();
      if (!localFile.exists())
      {
        y.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), dir not exist. " + paramString1);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.TakePhotoUtil", localException, "", new Object[0]);
      }
      paramString2.putExtra("output", Uri.fromFile(new File(filePath)));
      try
      {
        paramx.startActivityForResult(paramString2, 201);
        return true;
      }
      catch (ActivityNotFoundException paramx)
      {
        y.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), " + paramx.getMessage());
      }
    }
    return false;
  }
  
  private static void bq(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("system_config_prefs", 0).edit();
    paramContext.putString("camera_file_path", paramString);
    paramContext.commit();
  }
  
  public static boolean c(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    boolean bool = d(paramActivity, paramString1, paramString2, paramInt);
    y.i("MicroMsg.TakePhotoUtil", "takePhoto(), dir = [%s], filename = [%s], cmd = [%s], result = [%s]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    return bool;
  }
  
  public static boolean c(Context paramContext, Intent paramIntent, String paramString)
  {
    return a(paramContext, 8, paramIntent, 1, paramString, 0, "");
  }
  
  public static void d(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent.putExtra("max_select_count", paramInt1);
    paramIntent.putExtra("query_media_type", 2);
    paramIntent.putExtra("query_source_type", paramInt2);
    paramIntent.addFlags(67108864);
    d.b(paramActivity, "gallery", ".ui.GalleryEntryUI", paramIntent, 4);
  }
  
  private static boolean d(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    if ((com.tencent.mm.r.a.bj(paramActivity)) || (com.tencent.mm.r.a.bi(paramActivity))) {
      return false;
    }
    filePath = paramString1 + paramString2;
    y.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
    bq(paramActivity, filePath);
    paramString2 = new Intent("android.media.action.IMAGE_CAPTURE");
    File localFile = new File(paramString1);
    if (!localFile.exists()) {}
    try
    {
      localFile.mkdirs();
      if (!localFile.exists())
      {
        y.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), dir not exist. " + paramString1);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.TakePhotoUtil", localException, "", new Object[0]);
      }
      paramString2.putExtra("output", Uri.fromFile(new File(filePath)));
      try
      {
        paramActivity.startActivityForResult(paramString2, paramInt);
        return true;
      }
      catch (Exception paramActivity)
      {
        y.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), " + paramActivity.getMessage());
      }
    }
    return false;
  }
  
  public static boolean d(Context paramContext, Intent paramIntent, String paramString)
  {
    return e(paramContext, paramIntent, paramString);
  }
  
  private static boolean e(Context paramContext, Intent paramIntent, String paramString)
  {
    Object localObject1 = null;
    if (paramIntent != null) {
      localObject1 = (SightParams)paramIntent.getParcelableExtra("KEY_SIGHT_PARAMS");
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new SightParams(2, 0);
    }
    ((SightParams)localObject2).mfz = paramString;
    if (localObject2 == null) {
      y.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
    }
    for (;;)
    {
      try
      {
        paramContext.startActivity(paramIntent);
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).overridePendingTransition(a.a.sight_slide_bottom_in, -1);
        }
        return true;
      }
      catch (Exception paramContext)
      {
        y.w("MicroMsg.TakePhotoUtil", "takeWeishiSight Exception: %s", new Object[] { paramContext.getMessage() });
      }
      localObject1 = ((SightParams)localObject2).mfz;
      paramString = (String)localObject1;
      if (bk.bl((String)localObject1)) {
        paramString = bk.UY() + "_" + bk.Fe(5);
      }
      localObject1 = new StringBuilder("weishi://camera?forceNoShowLogin=1");
      y.d("MicroMsg.TakePhotoUtil", "weishi_url = %s", new Object[] { ((StringBuilder)localObject1).toString() });
      paramIntent.setAction("android.intent.action.VIEW");
      paramIntent.setData(Uri.parse(((StringBuilder)localObject1).toString()));
      paramIntent.setPackage("com.tencent.weishi");
      paramIntent.setFlags(268435456);
      localObject1 = paramIntent.getPackage();
      paramContext.getSharedPreferences("opensdk_shareTicket", 0).edit().putString((String)localObject1, paramString).apply();
    }
    return true;
  }
  
  public static String f(Context paramContext, Intent paramIntent, String paramString)
  {
    if (filePath == null) {
      filePath = paramContext.getSharedPreferences("system_config_prefs", 0).getString("camera_file_path", null);
    }
    if ((filePath == null) || (!com.tencent.mm.a.e.bK(filePath))) {
      filePath = com.tencent.mm.ui.tools.a.g(paramContext, paramIntent, paramString);
    }
    q.a(filePath, paramContext);
    return filePath;
  }
  
  public static void i(String paramString, Context paramContext)
  {
    q.a(paramString, paramContext, a.h.image_saved);
  }
  
  public static boolean j(Activity paramActivity, int paramInt)
  {
    a(paramActivity, paramInt, 1, 11, null);
    return true;
  }
  
  public static boolean k(Activity paramActivity, int paramInt)
  {
    a(paramActivity, paramInt, 1, 5, null);
    return true;
  }
  
  public static String pd(String paramString)
  {
    return q.pd(paramString);
  }
  
  @TargetApi(8)
  public static String qt()
  {
    return com.tencent.mm.compatible.util.e.dzD;
  }
  
  public static boolean r(Fragment paramFragment)
  {
    a(paramFragment, 200, 1, 0, 1, "", "");
    return true;
  }
  
  public static boolean z(Context paramContext, Intent paramIntent)
  {
    return b(paramContext, paramIntent, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.l
 * JD-Core Version:    0.7.0.1
 */