package com.tencent.mm.plugin.welab.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.welab.d;
import com.tencent.mm.plugin.welab.d.a;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.welab.a.a.a
{
  private Map<String, Integer> BBH;
  private String tag;
  
  public b()
  {
    AppMethodBeat.i(146235);
    this.BBH = new HashMap();
    this.tag = "";
    AppMethodBeat.o(146235);
  }
  
  public final boolean Dx(String paramString)
  {
    AppMethodBeat.i(146236);
    if (com.tencent.mm.plugin.welab.a.esb().ayW(paramString).field_Switch == 2)
    {
      ad.i("LabAppLifeService", "appid %s is open ", new Object[] { paramString });
      AppMethodBeat.o(146236);
      return true;
    }
    ad.i("LabAppLifeService", "appid %s is close", new Object[] { paramString });
    AppMethodBeat.o(146236);
    return false;
  }
  
  public final boolean aza(String paramString)
  {
    AppMethodBeat.i(146237);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.esb().ayW(paramString);
    paramString = new StringBuilder("isOnline ").append(paramString).append(", ");
    if (locala.esl()) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("LabAppLifeService", bool);
      if (!locala.esl()) {
        break;
      }
      AppMethodBeat.o(146237);
      return true;
    }
    AppMethodBeat.o(146237);
    return false;
  }
  
  public final boolean azb(String paramString)
  {
    AppMethodBeat.i(146239);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.esb().ayW(paramString);
    paramString = new StringBuilder("hitExp ").append(paramString).append(", ");
    if (locala.isRunning()) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("LabAppLifeService", bool);
      if (!locala.isRunning()) {
        break;
      }
      AppMethodBeat.o(146239);
      return true;
    }
    AppMethodBeat.o(146239);
    return false;
  }
  
  public final String azc(String paramString)
  {
    AppMethodBeat.i(146241);
    paramString = com.tencent.mm.plugin.welab.a.esb().ayW(paramString).field_WeAppUser;
    AppMethodBeat.o(146241);
    return paramString;
  }
  
  public final int azd(String paramString)
  {
    AppMethodBeat.i(146242);
    int i = com.tencent.mm.plugin.welab.a.esb().ayW(paramString).field_WeAppDebugMode;
    AppMethodBeat.o(146242);
    return i;
  }
  
  public final void cg(String paramString, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(146240);
    ad.i("LabAppLifeService", "switchEntry " + paramString + "," + paramBoolean);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.esb().ayW(paramString);
    if (paramBoolean)
    {
      i = 2;
      if (locala.field_Switch != i)
      {
        locala.field_Switch = i;
        com.tencent.mm.plugin.welab.a.esb().BBC.update(locala, new String[0]);
        Object localObject = new bkr();
        bkq localbkq = new bkq();
        if (!locala.esm()) {
          break label219;
        }
        i = 0;
        label112:
        localbkq.DIr = i;
        localbkq.DIs = locala.field_LabsAppId;
        if (locala.field_Switch != 2) {
          break label231;
        }
        i = j;
        label140:
        localbkq.CKO = i;
        ((bkr)localObject).fyl.add(localbkq);
        localObject = new j.a(207, (com.tencent.mm.bx.a)localObject);
        ((k)g.ab(k.class)).apL().c((j.b)localObject);
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
      i = bt.aGh(locala.field_expId);
      break label112;
      i = 2;
      break label140;
    }
  }
  
  public final void open(String paramString)
  {
    AppMethodBeat.i(146238);
    com.tencent.mm.plugin.welab.d.a.a locala = com.tencent.mm.plugin.welab.a.esb().ayW(paramString);
    d.a locala1 = new d.a();
    locala1.dlB = paramString;
    locala1.BBF = locala.field_expId;
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