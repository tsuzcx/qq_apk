package com.tencent.mm.plugin.welab.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.welab.d;
import com.tencent.mm.plugin.welab.d.a;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.welab.a.a.a
{
  private String tag;
  private Map<String, Integer> vuY;
  
  public b()
  {
    AppMethodBeat.i(80562);
    this.vuY = new HashMap();
    this.tag = "";
    AppMethodBeat.o(80562);
  }
  
  public final boolean ajw(String paramString)
  {
    AppMethodBeat.i(80565);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.dhl().ajs(paramString);
    paramString = new StringBuilder("isOnline ").append(paramString).append(", ");
    if (locala.dhv()) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("LabAppLifeService", bool);
      if (!locala.dhv()) {
        break;
      }
      AppMethodBeat.o(80565);
      return true;
    }
    AppMethodBeat.o(80565);
    return false;
  }
  
  public final boolean ajx(String paramString)
  {
    AppMethodBeat.i(80568);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.dhl().ajs(paramString);
    paramString = new StringBuilder("hitExp ").append(paramString).append(", ");
    if (locala.isRunning()) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("LabAppLifeService", bool);
      if (!locala.isRunning()) {
        break;
      }
      AppMethodBeat.o(80568);
      return true;
    }
    AppMethodBeat.o(80568);
    return false;
  }
  
  public final String ajy(String paramString)
  {
    AppMethodBeat.i(80570);
    paramString = com.tencent.mm.plugin.welab.a.dhl().ajs(paramString).field_WeAppUser;
    AppMethodBeat.o(80570);
    return paramString;
  }
  
  public final int ajz(String paramString)
  {
    AppMethodBeat.i(80571);
    int i = com.tencent.mm.plugin.welab.a.dhl().ajs(paramString).field_WeAppDebugMode;
    AppMethodBeat.o(80571);
    return i;
  }
  
  public final void bR(String paramString, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(80569);
    ab.i("LabAppLifeService", "switchEntry " + paramString + "," + paramBoolean);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.dhl().ajs(paramString);
    if (paramBoolean)
    {
      i = 2;
      if (locala.field_Switch != i)
      {
        locala.field_Switch = i;
        com.tencent.mm.plugin.welab.a.dhl().vuT.update(locala, new String[0]);
        Object localObject = new azh();
        azg localazg = new azg();
        if (!locala.dhx()) {
          break label219;
        }
        i = 0;
        label112:
        localazg.xoD = i;
        localazg.xoE = locala.field_LabsAppId;
        if (locala.field_Switch != 2) {
          break label231;
        }
        i = j;
        label140:
        localazg.wzE = i;
        ((azh)localObject).elu.add(localazg);
        localObject = new j.a(207, (com.tencent.mm.bv.a)localObject);
        ((j)g.E(j.class)).Yz().c((j.b)localObject);
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
      d.t(paramString, i, false);
      AppMethodBeat.o(80569);
      return;
      i = 1;
      break;
      i = bo.apV(locala.field_expId);
      break label112;
      i = 2;
      break label140;
    }
  }
  
  public final void open(String paramString)
  {
    AppMethodBeat.i(80567);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.dhl().ajs(paramString);
    d.a locala1 = new d.a();
    locala1.cwc = paramString;
    locala1.vuW = locala.field_expId;
    locala1.timeStamp = System.currentTimeMillis();
    locala1.action = 3;
    d.a(locala1);
    AppMethodBeat.o(80567);
  }
  
  public final boolean yi(String paramString)
  {
    AppMethodBeat.i(80564);
    if (com.tencent.mm.plugin.welab.a.dhl().ajs(paramString).field_Switch == 2)
    {
      ab.i("LabAppLifeService", "appid %s is open ", new Object[] { paramString });
      AppMethodBeat.o(80564);
      return true;
    }
    ab.i("LabAppLifeService", "appid %s is close", new Object[] { paramString });
    AppMethodBeat.o(80564);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.a.b
 * JD-Core Version:    0.7.0.1
 */