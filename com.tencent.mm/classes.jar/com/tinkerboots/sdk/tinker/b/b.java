package com.tinkerboots.sdk.tinker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.b.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.tinkerboots.sdk.b.d;
import java.io.File;

public final class b
  extends a
{
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final int hi(String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(3447);
    ShareTinkerLog.v("Tinker.TinkerServerPatchListener", "receive a patch file: %s, file size:%d", new Object[] { paramString1, Long.valueOf(SharePatchFileUtil.getFileOrDirectorySize(new File(paramString1))) });
    int j = super.hi(paramString1, paramString2);
    if (j == 0) {
      if (!d.fMC()) {}
    }
    for (i = -20;; i = j)
    {
      AppMethodBeat.o(3447);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tinkerboots.sdk.tinker.b.b
 * JD-Core Version:    0.7.0.1
 */