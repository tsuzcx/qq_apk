package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.mm.h.a.od;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;

public final class am
{
  private static final int otj = com.tencent.mm.m.g.AA().getInt("SnsUseWeiShiShootingEntranceDisplayTimes", 0);
  
  public static boolean bEd()
  {
    com.tencent.mm.kernel.g.DQ();
    int i = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uzI, Integer.valueOf(0))).intValue();
    y.d("MicroMsg.SnsLogic", "checkWeishiExposeCount now=%d limit=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(otj) });
    if (i < otj)
    {
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uzI, Integer.valueOf(i + 1));
      return true;
    }
    return false;
  }
  
  public static void e(ArrayList<String> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        int i = bk.getInt((String)paramArrayList.next(), 0);
        if (i != 0)
        {
          Object localObject = af.bDF().yt(i);
          if (localObject != null)
          {
            bxk localbxk = ((n)localObject).bGe();
            if ((localbxk != null) && (localbxk.tNr != null) && (localbxk.tNr.sPI == 26))
            {
              localbxk.tNr.sPL = paramString;
              af.bDF().b(i, (n)localObject);
              localObject = new od();
              ((od)localObject).bXQ.bXR = i;
              a.udP.m((b)localObject);
            }
          }
        }
      }
    }
  }
  
  public static boolean ec(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.weishi", 64);
      if (paramContext != null)
      {
        paramContext = paramContext.signatures[0].toByteArray();
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(paramContext);
        boolean bool = bk.isEqual(com.tencent.d.f.e.bytesToHexString(localMessageDigest.digest()), "2A281593D71DF33374E6124E9106DF08");
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      y.w("MicroMsg.SnsLogic", "checkWeishiInstalled Exception: %s", new Object[] { paramContext.getMessage() });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.am
 * JD-Core Version:    0.7.0.1
 */