package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.Iterator;
import java.util.List;

public final class t
{
  public static boolean KH(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  public static boolean KI(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
  
  public static String dql()
  {
    AppMethodBeat.i(114585);
    String str = j(z.dqx().wbv);
    AppMethodBeat.o(114585);
    return str;
  }
  
  public static String dqm()
  {
    AppMethodBeat.i(114587);
    String str = k(z.dqx().wbv);
    AppMethodBeat.o(114587);
    return str;
  }
  
  public static a dqn()
  {
    AppMethodBeat.i(114589);
    if (ay.isWifi(aj.getContext()))
    {
      locala = a.wcx;
      AppMethodBeat.o(114589);
      return locala;
    }
    if (ay.is4G(aj.getContext()))
    {
      locala = a.wcy;
      AppMethodBeat.o(114589);
      return locala;
    }
    if ((ay.is3G(aj.getContext())) || (ay.is2G(aj.getContext())))
    {
      locala = a.wcz;
      AppMethodBeat.o(114589);
      return locala;
    }
    a locala = a.wcA;
    AppMethodBeat.o(114589);
    return locala;
  }
  
  public static boolean dqo()
  {
    AppMethodBeat.i(114590);
    int i = ((Integer)g.ajC().ajl().get(al.a.IDo, Integer.valueOf(-1))).intValue();
    long l = ((Long)g.ajC().ajl().get(al.a.IDp, Long.valueOf(-1L))).longValue();
    if ((i > 0) && (l > 0L))
    {
      ad.i("MicroMsg.MultiTalkUtil", "checkMultiTalkAvailable, disableTime: %s, disableTimestamp: %s", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
      if (bt.aO(l) <= i * 1000)
      {
        AppMethodBeat.o(114590);
        return false;
      }
      g.ajC().ajl().set(al.a.IDo, Integer.valueOf(-1));
      g.ajC().ajl().set(al.a.IDp, Long.valueOf(-1L));
      AppMethodBeat.o(114590);
      return true;
    }
    g.ajC().ajl().set(al.a.IDo, Integer.valueOf(-1));
    g.ajC().ajl().set(al.a.IDp, Long.valueOf(-1L));
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
    Object localObject = paramMultiTalkGroup.LJG;
    localStringBuffer.append("->[usernamelist]");
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject).next();
        localStringBuffer.append(localMultiTalkGroupMember.LJH + "|");
        localStringBuffer.append(localMultiTalkGroupMember.status + ", ");
      }
    }
    localStringBuffer.append(" ->createname:" + paramMultiTalkGroup.LJF);
    localStringBuffer.append(" ->talkgroupId:" + paramMultiTalkGroup.LJC);
    localStringBuffer.append(" ->wxGroupId:" + paramMultiTalkGroup.LJE);
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
    paramMultiTalkGroup = paramMultiTalkGroup.LJG.iterator();
    int i = 0;
    int j = 0;
    while (paramMultiTalkGroup.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)paramMultiTalkGroup.next();
      if (localMultiTalkGroupMember.LJH.equals(u.aAm()))
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
    boolean bool = paramMultiTalkGroup.LJF.equals(u.aAm());
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
    String str2 = paramMultiTalkGroup.LJC;
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = paramMultiTalkGroup.LJD;
    }
    paramMultiTalkGroup = bt.bI(str1, "");
    AppMethodBeat.o(114584);
    return paramMultiTalkGroup;
  }
  
  public static String k(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114586);
    String str = null;
    int i = 0;
    if (i < paramMultiTalkGroup.LJG.size())
    {
      if (!((MultiTalkGroupMember)paramMultiTalkGroup.LJG.get(i)).LJH.equals(u.aAm())) {
        break label80;
      }
      str = ((MultiTalkGroupMember)paramMultiTalkGroup.LJG.get(i)).LJI;
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
      wcx = new a("WIFI", 0);
      wcy = new a("_4G", 1);
      wcz = new a("_3GOr_2G", 2);
      wcA = new a("None", 3);
      wcB = new a[] { wcx, wcy, wcz, wcA };
      AppMethodBeat.o(114578);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.t
 * JD-Core Version:    0.7.0.1
 */