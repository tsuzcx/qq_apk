package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.c.a.b;

public class TbsVideo
{
  private byte _hellAccFlag_;
  
  public static boolean canUseTbsPlayer(Context paramContext)
  {
    AppMethodBeat.i(54558);
    boolean bool = t.a(paramContext).a();
    AppMethodBeat.o(54558);
    return bool;
  }
  
  public static boolean canUseYunbo(Context paramContext)
  {
    AppMethodBeat.i(54559);
    if ((t.a(paramContext).a()) && (QbSdk.canUseVideoFeatrue(paramContext, 1)))
    {
      AppMethodBeat.o(54559);
      return true;
    }
    AppMethodBeat.o(54559);
    return false;
  }
  
  public static void openVideo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(54555);
    openVideo(paramContext, paramString, null);
    AppMethodBeat.o(54555);
  }
  
  public static void openVideo(Context paramContext, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(54556);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(54556);
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
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/smtt/sdk/TbsVideo", "openVideo", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/smtt/sdk/TbsVideo", "openVideo", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(54556);
  }
  
  public static boolean openYunboVideo(Context paramContext, String paramString, Bundle paramBundle, b paramb)
  {
    AppMethodBeat.i(54557);
    if (canUseYunbo(paramContext))
    {
      boolean bool = t.a(paramContext).a(paramString, paramBundle, paramb);
      AppMethodBeat.o(54557);
      return bool;
    }
    AppMethodBeat.o(54557);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideo
 * JD-Core Version:    0.7.0.1
 */