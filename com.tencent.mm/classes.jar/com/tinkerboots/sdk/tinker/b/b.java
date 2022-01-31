package com.tinkerboots.sdk.tinker.b;

import android.content.Context;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tinkerboots.sdk.b.c;
import java.io.File;

public final class b
  extends com.tencent.tinker.lib.b.a
{
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final int dz(String paramString1, String paramString2)
  {
    int i = 0;
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerPatchListener", "receive a patch file: %s, file size:%d", new Object[] { paramString1, Long.valueOf(SharePatchFileUtil.ag(new File(paramString1))) });
    int j = super.dz(paramString1, paramString2);
    if (j == 0)
    {
      if (c.cUb()) {
        i = -20;
      }
      return i;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tinkerboots.sdk.tinker.b.b
 * JD-Core Version:    0.7.0.1
 */