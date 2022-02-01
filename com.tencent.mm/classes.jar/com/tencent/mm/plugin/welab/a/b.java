package com.tencent.mm.plugin.welab.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.welab.d;
import com.tencent.mm.plugin.welab.d.a;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.welab.a.a.a
{
  private Map<String, Integer> JFW;
  private String tag;
  
  public b()
  {
    AppMethodBeat.i(146235);
    this.JFW = new HashMap();
    this.tag = "";
    AppMethodBeat.o(146235);
  }
  
  public final boolean Uw(String paramString)
  {
    AppMethodBeat.i(146236);
    if (com.tencent.mm.plugin.welab.a.gjg().bbz(paramString).field_Switch == 2)
    {
      Log.i("LabAppLifeService", "appid %s is open ", new Object[] { paramString });
      AppMethodBeat.o(146236);
      return true;
    }
    Log.i("LabAppLifeService", "appid %s is close", new Object[] { paramString });
    AppMethodBeat.o(146236);
    return false;
  }
  
  public final boolean bbD(String paramString)
  {
    AppMethodBeat.i(146237);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.gjg().bbz(paramString);
    paramString = new StringBuilder("isOnline ").append(paramString).append(", ");
    if (locala.gjo()) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("LabAppLifeService", bool);
      if (!locala.gjo()) {
        break;
      }
      AppMethodBeat.o(146237);
      return true;
    }
    AppMethodBeat.o(146237);
    return false;
  }
  
  public final boolean bbE(String paramString)
  {
    AppMethodBeat.i(146239);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.gjg().bbz(paramString);
    paramString = new StringBuilder("hitExp ").append(paramString).append(", ");
    if (locala.isRunning()) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("LabAppLifeService", bool);
      if (!locala.isRunning()) {
        break;
      }
      AppMethodBeat.o(146239);
      return true;
    }
    AppMethodBeat.o(146239);
    return false;
  }
  
  public final String bbF(String paramString)
  {
    AppMethodBeat.i(146241);
    paramString = com.tencent.mm.plugin.welab.a.gjg().bbz(paramString).field_WeAppUser;
    AppMethodBeat.o(146241);
    return paramString;
  }
  
  public final int bbG(String paramString)
  {
    AppMethodBeat.i(146242);
    int i = com.tencent.mm.plugin.welab.a.gjg().bbz(paramString).field_WeAppDebugMode;
    AppMethodBeat.o(146242);
    return i;
  }
  
  public final void cR(String paramString, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(146240);
    Log.i("LabAppLifeService", "switchEntry " + paramString + "," + paramBoolean);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.gjg().bbz(paramString);
    if (paramBoolean)
    {
      i = 2;
      if (locala.field_Switch != i)
      {
        locala.field_Switch = i;
        com.tencent.mm.plugin.welab.a.gjg().JFR.update(locala, new String[0]);
        Object localObject = new cgw();
        cgv localcgv = new cgv();
        if (!locala.gjp()) {
          break label219;
        }
        i = 0;
        label112:
        localcgv.Mmd = i;
        localcgv.Mme = locala.field_LabsAppId;
        if (locala.field_Switch != 2) {
          break label231;
        }
        i = j;
        label140:
        localcgv.KWb = i;
        ((cgw)localObject).gCs.add(localcgv);
        localObject = new k.a(207, (com.tencent.mm.bw.a)localObject);
        ((l)g.af(l.class)).aSM().d((k.b)localObject);
        if (locala.field_Switch != 2) {
          break label236;
        }
      }
    }
    label219:
    label231:
    label236:
    for (int i = 4;; i = 5)
    {
      d.y(paramString, i, false);
      AppMethodBeat.o(146240);
      return;
      i = 1;
      break;
      i = Util.safeParseInt(locala.field_expId);
      break label112;
      i = 2;
      break label140;
    }
  }
  
  public final void open(String paramString)
  {
    AppMethodBeat.i(146238);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.gjg().bbz(paramString);
    d.a locala1 = new d.a();
    locala1.dNI = paramString;
    locala1.JFU = locala.field_expId;
    locala1.timeStamp = System.currentTimeMillis();
    locala1.action = 3;
    d.a(locala1);
    AppMethodBeat.o(146238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.a.b
 * JD-Core Version:    0.7.0.1
 */