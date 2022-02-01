package com.tencent.mm.plugin.welab.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.plugin.welab.e.a;
import com.tencent.mm.protocal.protobuf.dgl;
import com.tencent.mm.protocal.protobuf.dgm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.welab.a.a.a
{
  private Map<String, Integer> XyG;
  private String tag;
  
  public b()
  {
    AppMethodBeat.i(146235);
    this.XyG = new HashMap();
    this.tag = "";
    AppMethodBeat.o(146235);
  }
  
  public final boolean UG(String paramString)
  {
    AppMethodBeat.i(146236);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.b.iDA().bnn(paramString);
    if ((locala != null) && (locala.field_Switch == 2))
    {
      Log.i("LabAppLifeService", "appid %s is open ", new Object[] { paramString });
      AppMethodBeat.o(146236);
      return true;
    }
    Log.i("LabAppLifeService", "appid %s is close", new Object[] { paramString });
    AppMethodBeat.o(146236);
    return false;
  }
  
  public final boolean bnr(String paramString)
  {
    AppMethodBeat.i(146237);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.b.iDA().bnn(paramString);
    paramString = new StringBuilder("isOnline ").append(paramString).append(", ");
    if ((locala != null) && (locala.MX())) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("LabAppLifeService", bool);
      if ((locala == null) || (!locala.MX())) {
        break;
      }
      AppMethodBeat.o(146237);
      return true;
    }
    AppMethodBeat.o(146237);
    return false;
  }
  
  public final boolean bns(String paramString)
  {
    AppMethodBeat.i(146239);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.b.iDA().bnn(paramString);
    paramString = new StringBuilder("hitExp ").append(paramString).append(", ");
    if ((locala != null) && (locala.isRunning())) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("LabAppLifeService", bool);
      if ((locala == null) || (!locala.isRunning())) {
        break;
      }
      AppMethodBeat.o(146239);
      return true;
    }
    AppMethodBeat.o(146239);
    return false;
  }
  
  public final String bnt(String paramString)
  {
    AppMethodBeat.i(146241);
    paramString = com.tencent.mm.plugin.welab.b.iDA().bnn(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_WeAppUser;
      AppMethodBeat.o(146241);
      return paramString;
    }
    AppMethodBeat.o(146241);
    return null;
  }
  
  public final int bnu(String paramString)
  {
    AppMethodBeat.i(146242);
    paramString = com.tencent.mm.plugin.welab.b.iDA().bnn(paramString);
    if (paramString != null)
    {
      int i = paramString.field_WeAppDebugMode;
      AppMethodBeat.o(146242);
      return i;
    }
    AppMethodBeat.o(146242);
    return 0;
  }
  
  public final void dP(String paramString, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(146240);
    Log.i("LabAppLifeService", "switchEntry " + paramString + "," + paramBoolean);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.b.iDA().bnn(paramString);
    if (paramBoolean)
    {
      i = 2;
      if (locala.field_Switch != i)
      {
        locala.field_Switch = i;
        com.tencent.mm.plugin.welab.b.iDA().XyB.update(locala, new String[0]);
        Object localObject = new dgm();
        dgl localdgl = new dgl();
        if (!locala.iDJ()) {
          break label219;
        }
        i = 0;
        label112:
        localdgl.aaLC = i;
        localdgl.aaLD = locala.field_LabsAppId;
        if (locala.field_Switch != 2) {
          break label231;
        }
        i = j;
        label140:
        localdgl.YVh = i;
        ((dgm)localObject).lPK.add(localdgl);
        localObject = new k.a(207, (com.tencent.mm.bx.a)localObject);
        ((n)h.ax(n.class)).bzz().d((k.b)localObject);
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
      e.E(paramString, i, false);
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
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.b.iDA().bnn(paramString);
    e.a locala1 = new e.a();
    locala1.appid = paramString;
    locala1.XyE = locala.field_expId;
    locala1.timeStamp = System.currentTimeMillis();
    locala1.action = 3;
    e.a(locala1);
    AppMethodBeat.o(146238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.a.b
 * JD-Core Version:    0.7.0.1
 */