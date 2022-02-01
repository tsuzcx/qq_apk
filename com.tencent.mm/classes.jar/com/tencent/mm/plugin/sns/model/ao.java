package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;

public final class ao
{
  private static final int zCp;
  
  static
  {
    AppMethodBeat.i(95919);
    zCp = com.tencent.mm.n.g.acL().getInt("SnsUseWeiShiShootingEntranceDisplayTimes", 0);
    AppMethodBeat.o(95919);
  }
  
  public static boolean dYh()
  {
    AppMethodBeat.i(95917);
    com.tencent.mm.kernel.g.ajS();
    int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYK, Integer.valueOf(0))).intValue();
    ae.d("MicroMsg.SnsLogic", "checkWeishiExposeCount now=%d limit=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(zCp) });
    if (i < zCp)
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYK, Integer.valueOf(i + 1));
    }
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(95917);
      return bool;
    }
  }
  
  public static void g(ArrayList<String> paramArrayList, String paramString)
  {
    AppMethodBeat.i(95916);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      AppMethodBeat.o(95916);
      return;
    }
    paramArrayList = new ArrayList(paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      int i = bu.getInt((String)paramArrayList.next(), 0);
      if (i != 0)
      {
        Object localObject = ah.dXE().Rw(i);
        if (localObject != null)
        {
          TimeLineObject localTimeLineObject = ((p)localObject).ebP();
          if ((localTimeLineObject != null) && (localTimeLineObject.HUG != null) && (localTimeLineObject.HUG.Gtw == 26))
          {
            localTimeLineObject.HUG.Gtz = paramString;
            ah.dXE().b(i, (p)localObject);
            localObject = new rr();
            ((rr)localObject).dHs.dHt = i;
            a.IvT.l((b)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(95916);
  }
  
  public static boolean gg(Context paramContext)
  {
    bool1 = true;
    AppMethodBeat.i(95918);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.weishi", 64);
      if (paramContext == null) {
        break label87;
      }
      paramContext = paramContext.signatures[0].toByteArray();
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramContext);
      boolean bool2 = bu.lX(com.tencent.d.f.e.bytesToHexString(localMessageDigest.digest()), "2A281593D71DF33374E6124E9106DF08");
      if (!bool2) {
        break label87;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ae.w("MicroMsg.SnsLogic", "checkWeishiInstalled Exception: %s", new Object[] { paramContext.getMessage() });
        bool1 = false;
      }
    }
    AppMethodBeat.o(95918);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ao
 * JD-Core Version:    0.7.0.1
 */