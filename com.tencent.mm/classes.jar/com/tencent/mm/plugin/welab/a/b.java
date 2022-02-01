package com.tencent.mm.plugin.welab.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.welab.d;
import com.tencent.mm.plugin.welab.d.a;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.welab.a.a.a
{
  private Map<String, Integer> CTN;
  private String tag;
  
  public b()
  {
    AppMethodBeat.i(146235);
    this.CTN = new HashMap();
    this.tag = "";
    AppMethodBeat.o(146235);
  }
  
  public final boolean HA(String paramString)
  {
    AppMethodBeat.i(146236);
    if (com.tencent.mm.plugin.welab.a.eHv().aEn(paramString).field_Switch == 2)
    {
      ac.i("LabAppLifeService", "appid %s is open ", new Object[] { paramString });
      AppMethodBeat.o(146236);
      return true;
    }
    ac.i("LabAppLifeService", "appid %s is close", new Object[] { paramString });
    AppMethodBeat.o(146236);
    return false;
  }
  
  public final boolean aEr(String paramString)
  {
    AppMethodBeat.i(146237);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.eHv().aEn(paramString);
    paramString = new StringBuilder("isOnline ").append(paramString).append(", ");
    if (locala.eHE()) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("LabAppLifeService", bool);
      if (!locala.eHE()) {
        break;
      }
      AppMethodBeat.o(146237);
      return true;
    }
    AppMethodBeat.o(146237);
    return false;
  }
  
  public final boolean aEs(String paramString)
  {
    AppMethodBeat.i(146239);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.eHv().aEn(paramString);
    paramString = new StringBuilder("hitExp ").append(paramString).append(", ");
    if (locala.isRunning()) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("LabAppLifeService", bool);
      if (!locala.isRunning()) {
        break;
      }
      AppMethodBeat.o(146239);
      return true;
    }
    AppMethodBeat.o(146239);
    return false;
  }
  
  public final String aEt(String paramString)
  {
    AppMethodBeat.i(146241);
    paramString = com.tencent.mm.plugin.welab.a.eHv().aEn(paramString).field_WeAppUser;
    AppMethodBeat.o(146241);
    return paramString;
  }
  
  public final int aEu(String paramString)
  {
    AppMethodBeat.i(146242);
    int i = com.tencent.mm.plugin.welab.a.eHv().aEn(paramString).field_WeAppDebugMode;
    AppMethodBeat.o(146242);
    return i;
  }
  
  public final void cm(String paramString, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(146240);
    ac.i("LabAppLifeService", "switchEntry " + paramString + "," + paramBoolean);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.eHv().aEn(paramString);
    if (paramBoolean)
    {
      i = 2;
      if (locala.field_Switch != i)
      {
        locala.field_Switch = i;
        com.tencent.mm.plugin.welab.a.eHv().CTI.update(locala, new String[0]);
        Object localObject = new bon();
        bom localbom = new bom();
        if (!locala.eHF()) {
          break label219;
        }
        i = 0;
        label112:
        localbom.FdM = i;
        localbom.FdN = locala.field_LabsAppId;
        if (locala.field_Switch != 2) {
          break label231;
        }
        i = j;
        label140:
        localbom.Edq = i;
        ((bon)localObject).fBS.add(localbom);
        localObject = new j.a(207, (com.tencent.mm.bw.a)localObject);
        ((k)g.ab(k.class)).awA().c((j.b)localObject);
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
      i = bs.aLy(locala.field_expId);
      break label112;
      i = 2;
      break label140;
    }
  }
  
  public final void open(String paramString)
  {
    AppMethodBeat.i(146238);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.eHv().aEn(paramString);
    d.a locala1 = new d.a();
    locala1.djj = paramString;
    locala1.CTL = locala.field_expId;
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