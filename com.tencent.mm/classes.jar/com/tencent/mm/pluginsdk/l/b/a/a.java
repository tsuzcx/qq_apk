package com.tencent.mm.pluginsdk.l.b.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;

public final class a
{
  public static boolean b(String paramString, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(31160);
    s.bqB();
    paramBoolean = c(x.XT(paramString), paramContext, paramBoolean);
    AppMethodBeat.o(31160);
    return paramBoolean;
  }
  
  public static boolean c(String paramString, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(31161);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(31161);
      return false;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(31161);
      return false;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW").addFlags(268435456);
    localIntent.putExtra("ChannelID", "com.tencent.mm");
    localIntent.putExtra("PosID", 3);
    paramString = new q(paramString);
    if (paramBoolean) {
      FileProviderHelper.setIntentDataAndType(paramContext, localIntent, paramString, "video/quicktime", false);
    }
    while (!Util.isIntentAvailable(paramContext, localIntent))
    {
      AppMethodBeat.o(31161);
      return false;
      FileProviderHelper.setIntentDataAndType(paramContext, localIntent, paramString, "video/*", false);
    }
    paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aFh(), "com/tencent/mm/pluginsdk/subapp/ui/video/VideoPlayerMgr", "startThridPlayerByPath", "(Ljava/lang/String;Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/pluginsdk/subapp/ui/video/VideoPlayerMgr", "startThridPlayerByPath", "(Ljava/lang/String;Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(31161);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.b.a.a
 * JD-Core Version:    0.7.0.1
 */