package com.tencent.mm.pluginsdk.h.b.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;

public final class a
{
  public static boolean b(String paramString, Context paramContext, boolean paramBoolean)
  {
    o.Sr();
    return c(t.nS(paramString), paramContext, paramBoolean);
  }
  
  public static boolean c(String paramString, Context paramContext, boolean paramBoolean)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return false;
      if (paramContext != null)
      {
        Intent localIntent = new Intent("android.intent.action.VIEW").addFlags(268435456);
        localIntent.putExtra("ChannelID", "com.tencent.mm");
        localIntent.putExtra("PosID", 3);
        paramString = Uri.fromFile(new File(paramString));
        if (paramBoolean) {
          localIntent.setDataAndType(paramString, "video/quicktime");
        }
        while (bk.i(paramContext, localIntent))
        {
          paramContext.startActivity(localIntent);
          return true;
          localIntent.setDataAndType(paramString, "video/*");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.b.a.a
 * JD-Core Version:    0.7.0.1
 */