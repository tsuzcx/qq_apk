package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;

public final class an
{
  private static final int rib;
  
  static
  {
    AppMethodBeat.i(36596);
    rib = com.tencent.mm.m.g.Nq().getInt("SnsUseWeiShiShootingEntranceDisplayTimes", 0);
    AppMethodBeat.o(36596);
  }
  
  public static boolean cpC()
  {
    AppMethodBeat.i(36594);
    com.tencent.mm.kernel.g.RM();
    int i = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKA, Integer.valueOf(0))).intValue();
    ab.d("MicroMsg.SnsLogic", "checkWeishiExposeCount now=%d limit=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(rib) });
    if (i < rib)
    {
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKA, Integer.valueOf(i + 1));
    }
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(36594);
      return bool;
    }
  }
  
  public static void e(ArrayList<String> paramArrayList, String paramString)
  {
    AppMethodBeat.i(36593);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      AppMethodBeat.o(36593);
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      int i = bo.getInt((String)paramArrayList.next(), 0);
      if (i != 0)
      {
        Object localObject = ag.cpf().Ez(i);
        if (localObject != null)
        {
          TimeLineObject localTimeLineObject = ((n)localObject).csh();
          if ((localTimeLineObject != null) && (localTimeLineObject.xTS != null) && (localTimeLineObject.xTS.wNZ == 26))
          {
            localTimeLineObject.xTS.wOc = paramString;
            ag.cpf().b(i, (n)localObject);
            localObject = new pe();
            ((pe)localObject).cFO.cFP = i;
            a.ymk.l((b)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(36593);
  }
  
  public static boolean eT(Context paramContext)
  {
    bool1 = true;
    AppMethodBeat.i(36595);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.weishi", 64);
      if (paramContext == null) {
        break label87;
      }
      paramContext = paramContext.signatures[0].toByteArray();
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramContext);
      boolean bool2 = bo.isEqual(com.tencent.e.f.e.bytesToHexString(localMessageDigest.digest()), "2A281593D71DF33374E6124E9106DF08");
      if (!bool2) {
        break label87;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ab.w("MicroMsg.SnsLogic", "checkWeishiInstalled Exception: %s", new Object[] { paramContext.getMessage() });
        bool1 = false;
      }
    }
    AppMethodBeat.o(36595);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.an
 * JD-Core Version:    0.7.0.1
 */