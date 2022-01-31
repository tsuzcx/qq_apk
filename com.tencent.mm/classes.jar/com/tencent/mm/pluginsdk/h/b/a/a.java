package com.tencent.mm.pluginsdk.h.b.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import java.io.File;

public final class a
{
  public static boolean b(String paramString, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27458);
    o.alE();
    paramBoolean = c(t.vf(paramString), paramContext, paramBoolean);
    AppMethodBeat.o(27458);
    return paramBoolean;
  }
  
  public static boolean c(String paramString, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27459);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(27459);
      return false;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(27459);
      return false;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW").addFlags(268435456);
    localIntent.putExtra("ChannelID", "com.tencent.mm");
    localIntent.putExtra("PosID", 3);
    paramString = new File(paramString);
    if (paramBoolean) {
      k.a(paramContext, localIntent, paramString, "video/quicktime");
    }
    while (!bo.k(paramContext, localIntent))
    {
      AppMethodBeat.o(27459);
      return false;
      k.a(paramContext, localIntent, paramString, "video/*");
    }
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(27459);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.b.a.a
 * JD-Core Version:    0.7.0.1
 */