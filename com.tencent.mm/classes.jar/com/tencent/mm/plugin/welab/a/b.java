package com.tencent.mm.plugin.welab.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.welab.d;
import com.tencent.mm.plugin.welab.d.a;
import com.tencent.mm.protocal.protobuf.btt;
import com.tencent.mm.protocal.protobuf.btu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.welab.a.a.a
{
  private Map<String, Integer> EQj;
  private String tag;
  
  public b()
  {
    AppMethodBeat.i(146235);
    this.EQj = new HashMap();
    this.tag = "";
    AppMethodBeat.o(146235);
  }
  
  public final boolean Ln(String paramString)
  {
    AppMethodBeat.i(146236);
    if (com.tencent.mm.plugin.welab.a.faa().aLj(paramString).field_Switch == 2)
    {
      ae.i("LabAppLifeService", "appid %s is open ", new Object[] { paramString });
      AppMethodBeat.o(146236);
      return true;
    }
    ae.i("LabAppLifeService", "appid %s is close", new Object[] { paramString });
    AppMethodBeat.o(146236);
    return false;
  }
  
  public final boolean aLn(String paramString)
  {
    AppMethodBeat.i(146237);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.faa().aLj(paramString);
    paramString = new StringBuilder("isOnline ").append(paramString).append(", ");
    if (locala.faj()) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("LabAppLifeService", bool);
      if (!locala.faj()) {
        break;
      }
      AppMethodBeat.o(146237);
      return true;
    }
    AppMethodBeat.o(146237);
    return false;
  }
  
  public final boolean aLo(String paramString)
  {
    AppMethodBeat.i(146239);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.faa().aLj(paramString);
    paramString = new StringBuilder("hitExp ").append(paramString).append(", ");
    if (locala.isRunning()) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("LabAppLifeService", bool);
      if (!locala.isRunning()) {
        break;
      }
      AppMethodBeat.o(146239);
      return true;
    }
    AppMethodBeat.o(146239);
    return false;
  }
  
  public final String aLp(String paramString)
  {
    AppMethodBeat.i(146241);
    paramString = com.tencent.mm.plugin.welab.a.faa().aLj(paramString).field_WeAppUser;
    AppMethodBeat.o(146241);
    return paramString;
  }
  
  public final int aLq(String paramString)
  {
    AppMethodBeat.i(146242);
    int i = com.tencent.mm.plugin.welab.a.faa().aLj(paramString).field_WeAppDebugMode;
    AppMethodBeat.o(146242);
    return i;
  }
  
  public final void cw(String paramString, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(146240);
    ae.i("LabAppLifeService", "switchEntry " + paramString + "," + paramBoolean);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.faa().aLj(paramString);
    if (paramBoolean)
    {
      i = 2;
      if (locala.field_Switch != i)
      {
        locala.field_Switch = i;
        com.tencent.mm.plugin.welab.a.faa().EQe.update(locala, new String[0]);
        Object localObject = new btu();
        btt localbtt = new btt();
        if (!locala.fak()) {
          break label219;
        }
        i = 0;
        label112:
        localbtt.HgQ = i;
        localbtt.HgR = locala.field_LabsAppId;
        if (locala.field_Switch != 2) {
          break label231;
        }
        i = j;
        label140:
        localbtt.GbY = i;
        ((btu)localObject).fXm.add(localbtt);
        localObject = new k.a(207, (com.tencent.mm.bw.a)localObject);
        ((l)g.ab(l.class)).azE().d((k.b)localObject);
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
      d.v(paramString, i, false);
      AppMethodBeat.o(146240);
      return;
      i = 1;
      break;
      i = bu.aSB(locala.field_expId);
      break label112;
      i = 2;
      break label140;
    }
  }
  
  public final void open(String paramString)
  {
    AppMethodBeat.i(146238);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.faa().aLj(paramString);
    d.a locala1 = new d.a();
    locala1.dwb = paramString;
    locala1.EQh = locala.field_expId;
    locala1.timeStamp = System.currentTimeMillis();
    locala1.action = 3;
    d.a(locala1);
    AppMethodBeat.o(146238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.a.b
 * JD-Core Version:    0.7.0.1
 */