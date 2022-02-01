package com.tencent.mm.pluginsdk.i.b.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.vfs.e;

public final class a
{
  public static boolean b(String paramString, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(31160);
    o.aCI();
    paramBoolean = c(t.zQ(paramString), paramContext, paramBoolean);
    AppMethodBeat.o(31160);
    return paramBoolean;
  }
  
  public static boolean c(String paramString, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(31161);
    if (bt.isNullOrNil(paramString))
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
    paramString = new e(paramString);
    if (paramBoolean) {
      m.a(paramContext, localIntent, paramString, "video/quicktime");
    }
    while (!bt.T(paramContext, localIntent))
    {
      AppMethodBeat.o(31161);
      return false;
      m.a(paramContext, localIntent, paramString, "video/*");
    }
    paramString = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.adn(), "com/tencent/mm/pluginsdk/subapp/ui/video/VideoPlayerMgr", "startThridPlayerByPath", "(Ljava/lang/String;Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/subapp/ui/video/VideoPlayerMgr", "startThridPlayerByPath", "(Ljava/lang/String;Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(31161);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.b.a.a
 * JD-Core Version:    0.7.0.1
 */