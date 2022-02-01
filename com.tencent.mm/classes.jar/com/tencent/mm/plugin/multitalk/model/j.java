package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.Iterator;
import java.util.List;

public final class j
{
  public static boolean Jg(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  public static boolean Jh(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
  
  public static String dgm()
  {
    AppMethodBeat.i(114585);
    String str = j(p.dgx().uXk);
    AppMethodBeat.o(114585);
    return str;
  }
  
  public static String dgn()
  {
    AppMethodBeat.i(114587);
    String str = k(p.dgx().uXk);
    AppMethodBeat.o(114587);
    return str;
  }
  
  public static a dgo()
  {
    AppMethodBeat.i(114589);
    if (ax.isWifi(ai.getContext()))
    {
      locala = a.uYa;
      AppMethodBeat.o(114589);
      return locala;
    }
    if (ax.is4G(ai.getContext()))
    {
      locala = a.uYb;
      AppMethodBeat.o(114589);
      return locala;
    }
    if ((ax.is3G(ai.getContext())) || (ax.is2G(ai.getContext())))
    {
      locala = a.uYc;
      AppMethodBeat.o(114589);
      return locala;
    }
    a locala = a.uYd;
    AppMethodBeat.o(114589);
    return locala;
  }
  
  public static boolean dgp()
  {
    AppMethodBeat.i(114590);
    int i = ((Integer)g.agR().agA().get(ah.a.GQR, Integer.valueOf(-1))).intValue();
    long l = ((Long)g.agR().agA().get(ah.a.GQS, Long.valueOf(-1L))).longValue();
    if ((i > 0) && (l > 0L))
    {
      ac.i("MicroMsg.MultiTalkUtil", "checkMultiTalkAvailable, disableTime: %s, disableTimestamp: %s", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
      if (bs.aO(l) <= i * 1000)
      {
        AppMethodBeat.o(114590);
        return false;
      }
      g.agR().agA().set(ah.a.GQR, Integer.valueOf(-1));
      g.agR().agA().set(ah.a.GQS, Long.valueOf(-1L));
      AppMethodBeat.o(114590);
      return true;
    }
    g.agR().agA().set(ah.a.GQR, Integer.valueOf(-1));
    g.agR().agA().set(ah.a.GQS, Long.valueOf(-1L));
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
    Object localObject = paramMultiTalkGroup.JPV;
    localStringBuffer.append("->[usernamelist]");
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject).next();
        localStringBuffer.append(localMultiTalkGroupMember.JPW + "|");
        localStringBuffer.append(localMultiTalkGroupMember.status + ", ");
      }
    }
    localStringBuffer.append(" ->createname:" + paramMultiTalkGroup.JPU);
    localStringBuffer.append(" ->talkgroupId:" + paramMultiTalkGroup.JPR);
    localStringBuffer.append(" ->wxGroupId:" + paramMultiTalkGroup.JPT);
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
    paramMultiTalkGroup = paramMultiTalkGroup.JPV.iterator();
    int i = 0;
    int j = 0;
    while (paramMultiTalkGroup.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)paramMultiTalkGroup.next();
      if (localMultiTalkGroupMember.JPW.equals(u.axw()))
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
    boolean bool = paramMultiTalkGroup.JPU.equals(u.axw());
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
    String str2 = paramMultiTalkGroup.JPR;
    String str1 = str2;
    if (bs.isNullOrNil(str2)) {
      str1 = paramMultiTalkGroup.JPS;
    }
    paramMultiTalkGroup = bs.bG(str1, "");
    AppMethodBeat.o(114584);
    return paramMultiTalkGroup;
  }
  
  public static String k(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114586);
    String str = null;
    int i = 0;
    if (i < paramMultiTalkGroup.JPV.size())
    {
      if (!((MultiTalkGroupMember)paramMultiTalkGroup.JPV.get(i)).JPW.equals(u.axw())) {
        break label80;
      }
      str = ((MultiTalkGroupMember)paramMultiTalkGroup.JPV.get(i)).JPX;
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
      uYa = new a("WIFI", 0);
      uYb = new a("_4G", 1);
      uYc = new a("_3GOr_2G", 2);
      uYd = new a("None", 3);
      uYe = new a[] { uYa, uYb, uYc, uYd };
      AppMethodBeat.o(114578);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.j
 * JD-Core Version:    0.7.0.1
 */