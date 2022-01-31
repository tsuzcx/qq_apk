package com.tencent.tinker.lib.b;

import android.content.Context;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class a
  implements b
{
  public final Context context;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final int agc(String paramString)
  {
    int i = dz(paramString, SharePatchFileUtil.ai(new File(paramString)));
    if (i == 0)
    {
      TinkerPatchService.bO(this.context, paramString);
      return i;
    }
    com.tencent.tinker.lib.e.a.hN(this.context).wWl.c(new File(paramString), i);
    return i;
  }
  
  public int dz(String paramString1, String paramString2)
  {
    com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.hN(this.context);
    if ((!ShareTinkerInternals.Ko(locala.tinkerFlags)) || (!ShareTinkerInternals.id(this.context))) {
      return -1;
    }
    if (!SharePatchFileUtil.ae(new File(paramString1))) {
      return -2;
    }
    if (locala.wWp) {
      return -4;
    }
    if (com.tencent.tinker.lib.f.b.hP(this.context)) {
      return -3;
    }
    if (ShareTinkerInternals.cQQ()) {
      return -5;
    }
    paramString1 = com.tencent.tinker.lib.e.a.hN(this.context);
    if (paramString1.wWr)
    {
      paramString1 = paramString1.wWq;
      if ((paramString1 != null) && (!paramString1.wWy) && (paramString2.equals(paramString1.wWv))) {
        return -6;
      }
    }
    if (!com.tencent.tinker.lib.f.c.hS(this.context).age(paramString2)) {
      return -7;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.lib.b.a
 * JD-Core Version:    0.7.0.1
 */