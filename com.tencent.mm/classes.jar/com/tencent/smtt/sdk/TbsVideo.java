package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.f.a.a.b;

public class TbsVideo
{
  public static boolean canUseTbsPlayer(Context paramContext)
  {
    return be.a(paramContext).a();
  }
  
  public static boolean canUseYunbo(Context paramContext)
  {
    return (be.a(paramContext).a()) && (QbSdk.canUseVideoFeatrue(paramContext, 1));
  }
  
  public static void openVideo(Context paramContext, String paramString)
  {
    openVideo(paramContext, paramString, null);
  }
  
  public static void openVideo(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("videoUrl", paramString);
    paramString = new Intent("com.tencent.smtt.tbs.video.PLAY");
    paramString.setFlags(268435456);
    paramString.setPackage(paramContext.getPackageName());
    paramString.putExtra("extraData", localBundle);
    paramContext.startActivity(paramString);
  }
  
  public static boolean openYunboVideo(Context paramContext, String paramString, Bundle paramBundle, b paramb)
  {
    if (canUseYunbo(paramContext)) {
      return be.a(paramContext).a(paramString, paramBundle, paramb);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideo
 * JD-Core Version:    0.7.0.1
 */