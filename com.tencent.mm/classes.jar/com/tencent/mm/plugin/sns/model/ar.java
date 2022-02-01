package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.e.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.vd;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;

public final class ar
{
  private static final int Qwz;
  
  static
  {
    AppMethodBeat.i(95919);
    Qwz = i.aRC().getInt("SnsUseWeiShiShootingEntranceDisplayTimes", 0);
    AppMethodBeat.o(95919);
  }
  
  public static boolean hhh()
  {
    AppMethodBeat.i(95917);
    h.baF();
    int i = ((Integer)h.baE().ban().get(at.a.acXg, Integer.valueOf(0))).intValue();
    Log.d("MicroMsg.SnsLogic", "checkWeishiExposeCount now=%d limit=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(Qwz) });
    if (i < Qwz)
    {
      h.baF();
      h.baE().ban().set(at.a.acXg, Integer.valueOf(i + 1));
    }
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(95917);
      return bool;
    }
  }
  
  public static void j(ArrayList<String> paramArrayList, String paramString)
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
      int i = Util.getInt((String)paramArrayList.next(), 0);
      if (i != 0)
      {
        Object localObject = al.hgB().alB(i);
        if (localObject != null)
        {
          TimeLineObject localTimeLineObject = ((SnsInfo)localObject).getTimeLine();
          if ((localTimeLineObject != null) && (localTimeLineObject.ContentObj != null) && (localTimeLineObject.ContentObj.Zpq == 26))
          {
            localTimeLineObject.ContentObj.Zpt = paramString;
            al.hgB().f(i, (SnsInfo)localObject);
            localObject = new vd();
            ((vd)localObject).hYU.hYV = i;
            ((vd)localObject).publish();
          }
        }
      }
    }
    AppMethodBeat.o(95916);
  }
  
  public static boolean jr(Context paramContext)
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
      boolean bool2 = Util.isEqual(e.aC(localMessageDigest.digest()), "2A281593D71DF33374E6124E9106DF08");
      if (!bool2) {
        break label87;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.w("MicroMsg.SnsLogic", "checkWeishiInstalled Exception: %s", new Object[] { paramContext.getMessage() });
        bool1 = false;
      }
    }
    AppMethodBeat.o(95918);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ar
 * JD-Core Version:    0.7.0.1
 */