package com.tencent.mm.plugin.sns.a.b;

import android.util.Base64;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.bvo;
import com.tencent.mm.protocal.c.bvp;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class f
{
  private static String MM(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    paramString = Base64.decode(paramString, 0);
    bvo localbvo = new bvo();
    try
    {
      localbvo.aH(paramString);
      paramString = p.a(localbvo.tMm);
      return paramString;
    }
    catch (IOException paramString)
    {
      y.e("SnsAdExtUtil", "", new Object[] { paramString });
    }
    return "";
  }
  
  public static String a(long paramLong, Object... paramVarArgs)
  {
    af.bDz();
    paramVarArgs = new StringBuilder(i.o(paramVarArgs));
    a(paramLong, paramVarArgs);
    return paramVarArgs.toString();
  }
  
  public static String a(bxk parambxk)
  {
    if (parambxk != null) {
      return MM(parambxk.oPO);
    }
    y.v("SnsAdExtUtil", "getSnsStatExt timeLineObject null");
    return null;
  }
  
  public static void a(long paramLong, StringBuilder paramStringBuilder)
  {
    Object localObject = af.bDI().gk(paramLong);
    if (localObject != null)
    {
      localObject = ((e)localObject).bGe();
      if (localObject != null)
      {
        localObject = p.nu(((bxk)localObject).oPO);
        StringBuilder localStringBuilder = paramStringBuilder.append(",");
        if (localObject == null) {}
        for (int i = -1;; i = ((bvp)localObject).source)
        {
          localStringBuilder.append(i);
          paramStringBuilder.append(",").append(p.a((bvp)localObject));
          return;
        }
      }
      y.v("SnsAdExtUtil", "l timeLineObject null, snsId %d", new Object[] { Long.valueOf(paramLong) });
      paramStringBuilder.append(",,");
      return;
    }
    y.v("SnsAdExtUtil", "l snsInfo null, snsId %d", new Object[] { Long.valueOf(paramLong) });
    paramStringBuilder.append(",,");
  }
  
  public static void a(String paramString, d paramd)
  {
    Object localObject = af.bDF().OA(paramString);
    if (localObject != null)
    {
      localObject = ((n)localObject).bGe();
      if (localObject != null)
      {
        p.a(((bxk)localObject).oPO, paramd);
        return;
      }
      y.v("SnsAdExtUtil", "timeLineObject null, snsId %s", new Object[] { paramString });
      return;
    }
    y.v("SnsAdExtUtil", "snsInfo null, snsId %s", new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.f
 * JD-Core Version:    0.7.0.1
 */