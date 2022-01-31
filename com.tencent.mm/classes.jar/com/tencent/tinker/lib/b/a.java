package com.tencent.tinker.lib.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class a
  implements b
{
  protected final Context context;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final int awR(String paramString)
  {
    int i = eQ(paramString, SharePatchFileUtil.q(new File(paramString)));
    if (i == 0)
    {
      TinkerPatchService.cd(this.context, paramString);
      return i;
    }
    com.tencent.tinker.lib.e.a.jo(this.context).BsO.d(new File(paramString), i);
    return i;
  }
  
  protected int eQ(String paramString1, String paramString2)
  {
    int j = -2;
    Object localObject = com.tencent.tinker.lib.e.a.jo(this.context);
    int i;
    if ((!ShareTinkerInternals.Ti(((com.tencent.tinker.lib.e.a)localObject).tinkerFlags)) || (!ShareTinkerInternals.jE(this.context))) {
      i = -1;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (TextUtils.isEmpty(paramString2));
      i = j;
    } while (!SharePatchFileUtil.an(new File(paramString1)));
    if (((com.tencent.tinker.lib.e.a)localObject).BsS) {
      return -4;
    }
    if (com.tencent.tinker.lib.f.b.jq(this.context)) {
      return -3;
    }
    if (ShareTinkerInternals.dWF()) {
      return -5;
    }
    paramString1 = com.tencent.tinker.lib.e.a.jo(this.context);
    if (paramString1.BsU)
    {
      paramString1 = paramString1.BsT;
      if ((paramString1 != null) && (!paramString1.Btb) && (paramString2.equals(paramString1.BsY))) {
        return -6;
      }
    }
    localObject = ((com.tencent.tinker.lib.e.a)localObject).BsM.getAbsolutePath();
    paramString1 = SharePatchFileUtil.axa((String)localObject);
    localObject = SharePatchFileUtil.awZ((String)localObject);
    try
    {
      paramString1 = SharePatchInfo.l((File)localObject, paramString1);
      if ((paramString1 != null) && (!ShareTinkerInternals.isNullOrNil(paramString1.BvV)) && (!paramString1.BvX))
      {
        boolean bool = paramString2.equals(paramString1.BvV);
        if (bool) {
          return -6;
        }
      }
    }
    catch (Throwable paramString1)
    {
      if (!com.tencent.tinker.lib.f.c.jt(this.context).awU(paramString2)) {
        return -7;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.lib.b.a
 * JD-Core Version:    0.7.0.1
 */