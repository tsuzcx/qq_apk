package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.Iterator;
import java.util.List;

public final class j
{
  public static boolean Hj(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  public static boolean Hk(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
  
  public static String cSD()
  {
    AppMethodBeat.i(114585);
    String str = j(p.cSO().tOI);
    AppMethodBeat.o(114585);
    return str;
  }
  
  public static String cSE()
  {
    AppMethodBeat.i(114587);
    String str = k(p.cSO().tOI);
    AppMethodBeat.o(114587);
    return str;
  }
  
  public static a cSF()
  {
    AppMethodBeat.i(114589);
    if (ay.isWifi(aj.getContext()))
    {
      locala = a.tPz;
      AppMethodBeat.o(114589);
      return locala;
    }
    if (ay.is4G(aj.getContext()))
    {
      locala = a.tPA;
      AppMethodBeat.o(114589);
      return locala;
    }
    if ((ay.is3G(aj.getContext())) || (ay.is2G(aj.getContext())))
    {
      locala = a.tPB;
      AppMethodBeat.o(114589);
      return locala;
    }
    a locala = a.tPC;
    AppMethodBeat.o(114589);
    return locala;
  }
  
  public static boolean cSG()
  {
    AppMethodBeat.i(114590);
    int i = ((Integer)g.afB().afk().get(ae.a.FsY, Integer.valueOf(-1))).intValue();
    long l = ((Long)g.afB().afk().get(ae.a.FsZ, Long.valueOf(-1L))).longValue();
    if ((i > 0) && (l > 0L))
    {
      ad.i("MicroMsg.MultiTalkUtil", "checkMultiTalkAvailable, disableTime: %s, disableTimestamp: %s", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
      if (bt.aS(l) <= i * 1000)
      {
        AppMethodBeat.o(114590);
        return false;
      }
      g.afB().afk().set(ae.a.FsY, Integer.valueOf(-1));
      g.afB().afk().set(ae.a.FsZ, Long.valueOf(-1L));
      AppMethodBeat.o(114590);
      return true;
    }
    g.afB().afk().set(ae.a.FsY, Integer.valueOf(-1));
    g.afB().afk().set(ae.a.FsZ, Long.valueOf(-1L));
    AppMethodBeat.o(114590);
    return true;
  }
  
  public static String g(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114579);
    if (paramMultiTalkGroup == null)
    {
      AppMethodBeat.o(114579);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = paramMultiTalkGroup.Iok;
    localStringBuffer.append("->[usernamelist]");
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject).next();
        localStringBuffer.append(localMultiTalkGroupMember.Iol + "|");
        localStringBuffer.append(localMultiTalkGroupMember.status + ", ");
      }
    }
    localStringBuffer.append(" ->createname:" + paramMultiTalkGroup.Ioj);
    localStringBuffer.append(" ->talkgroupId:" + paramMultiTalkGroup.Iog);
    localStringBuffer.append(" ->wxGroupId:" + paramMultiTalkGroup.Ioi);
    paramMultiTalkGroup = localStringBuffer.toString();
    AppMethodBeat.o(114579);
    return paramMultiTalkGroup;
  }
  
  public static boolean h(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114581);
    if (paramMultiTalkGroup == null)
    {
      AppMethodBeat.o(114581);
      return false;
    }
    paramMultiTalkGroup = paramMultiTalkGroup.Iok.iterator();
    int i = 0;
    int j = 0;
    while (paramMultiTalkGroup.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)paramMultiTalkGroup.next();
      if (localMultiTalkGroupMember.Iol.equals(u.aqG()))
      {
        if (localMultiTalkGroupMember.status != 10) {
          break label119;
        }
        if (i != 0)
        {
          AppMethodBeat.o(114581);
          return true;
        }
        j = 1;
      }
      else
      {
        if (localMultiTalkGroupMember.status != 10) {
          break label119;
        }
        if (j != 0)
        {
          AppMethodBeat.o(114581);
          return true;
        }
        i = 1;
      }
    }
    label119:
    for (;;)
    {
      break;
      AppMethodBeat.o(114581);
      return false;
    }
  }
  
  public static boolean i(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114583);
    boolean bool = paramMultiTalkGroup.Ioj.equals(u.aqG());
    AppMethodBeat.o(114583);
    return bool;
  }
  
  public static String j(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114584);
    if (paramMultiTalkGroup == null)
    {
      AppMethodBeat.o(114584);
      return "";
    }
    String str2 = paramMultiTalkGroup.Iog;
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = paramMultiTalkGroup.Ioh;
    }
    paramMultiTalkGroup = bt.by(str1, "");
    AppMethodBeat.o(114584);
    return paramMultiTalkGroup;
  }
  
  public static String k(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114586);
    String str = null;
    int i = 0;
    if (i < paramMultiTalkGroup.Iok.size())
    {
      if (!((MultiTalkGroupMember)paramMultiTalkGroup.Iok.get(i)).Iol.equals(u.aqG())) {
        break label80;
      }
      str = ((MultiTalkGroupMember)paramMultiTalkGroup.Iok.get(i)).Iom;
    }
    label80:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(114586);
      return str;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(114578);
      tPz = new a("WIFI", 0);
      tPA = new a("_4G", 1);
      tPB = new a("_3GOr_2G", 2);
      tPC = new a("None", 3);
      tPD = new a[] { tPz, tPA, tPB, tPC };
      AppMethodBeat.o(114578);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.j
 * JD-Core Version:    0.7.0.1
 */