package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.ui.widget.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.Iterator;
import java.util.List;

public final class u
{
  public static boolean abK(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  public static boolean abL(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
  
  public static boolean c(o paramo)
  {
    return (paramo == o.LvM) || (paramo == o.LvN) || (paramo == o.LvK);
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
    Object localObject = paramMultiTalkGroup.ahhh;
    localStringBuffer.append("->[usernamelist]");
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject).next();
        localStringBuffer.append(localMultiTalkGroupMember.ahhi + "|");
        localStringBuffer.append(localMultiTalkGroupMember.status + ", ");
      }
    }
    localStringBuffer.append(" ->createname:" + paramMultiTalkGroup.ahhg);
    localStringBuffer.append(" ->talkgroupId:" + paramMultiTalkGroup.LiU);
    localStringBuffer.append(" ->wxGroupId:" + paramMultiTalkGroup.LiV);
    paramMultiTalkGroup = localStringBuffer.toString();
    AppMethodBeat.o(114579);
    return paramMultiTalkGroup;
  }
  
  public static String ggB()
  {
    AppMethodBeat.i(114585);
    String str = k(ac.ggS().Lol);
    AppMethodBeat.o(114585);
    return str;
  }
  
  public static String ggC()
  {
    AppMethodBeat.i(114587);
    String str = l(ac.ggS().Lol);
    AppMethodBeat.o(114587);
    return str;
  }
  
  public static a ggD()
  {
    AppMethodBeat.i(114589);
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      locala = a.LpD;
      AppMethodBeat.o(114589);
      return locala;
    }
    if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
    {
      locala = a.LpE;
      AppMethodBeat.o(114589);
      return locala;
    }
    if ((NetStatusUtil.is3G(MMApplicationContext.getContext())) || (NetStatusUtil.is2G(MMApplicationContext.getContext())))
    {
      locala = a.LpF;
      AppMethodBeat.o(114589);
      return locala;
    }
    a locala = a.LpG;
    AppMethodBeat.o(114589);
    return locala;
  }
  
  public static long ggE()
  {
    AppMethodBeat.i(284789);
    int i = ((Integer)h.baE().ban().get(at.a.acWk, Integer.valueOf(-1))).intValue();
    long l1 = ((Long)h.baE().ban().get(at.a.acWl, Long.valueOf(-1L))).longValue();
    if ((i > 0) && (l1 > 0L))
    {
      Log.i("MicroMsg.MultiTalkUtil", "checkMultiTalkAvailable, disableTime: %s, disableTimestamp: %s", new Object[] { Integer.valueOf(i), Long.valueOf(l1) });
      long l2 = Util.ticksToNow(l1);
      long l3 = i * 1000L;
      if (Util.ticksToNow(l1) <= l3)
      {
        AppMethodBeat.o(284789);
        return l3 - l2;
      }
      h.baE().ban().set(at.a.acWk, Integer.valueOf(-1));
      h.baE().ban().set(at.a.acWl, Long.valueOf(-1L));
      AppMethodBeat.o(284789);
      return 0L;
    }
    h.baE().ban().set(at.a.acWk, Integer.valueOf(-1));
    h.baE().ban().set(at.a.acWl, Long.valueOf(-1L));
    AppMethodBeat.o(284789);
    return 0L;
  }
  
  public static boolean h(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114581);
    if (paramMultiTalkGroup == null)
    {
      AppMethodBeat.o(114581);
      return false;
    }
    paramMultiTalkGroup = paramMultiTalkGroup.ahhh.iterator();
    int i = 0;
    int j = 0;
    while (paramMultiTalkGroup.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)paramMultiTalkGroup.next();
      if (localMultiTalkGroupMember.ahhi.equals(z.bAM()))
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
    AppMethodBeat.i(284744);
    paramMultiTalkGroup = paramMultiTalkGroup.ahhh.iterator();
    int i = 0;
    if (paramMultiTalkGroup.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)paramMultiTalkGroup.next();
      if ((localMultiTalkGroupMember.status != 10) && (localMultiTalkGroupMember.status != 1)) {
        break label82;
      }
      i += 1;
    }
    label82:
    for (;;)
    {
      break;
      if (i > 1)
      {
        AppMethodBeat.o(284744);
        return true;
      }
      AppMethodBeat.o(284744);
      return false;
    }
  }
  
  public static boolean j(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114583);
    boolean bool = paramMultiTalkGroup.ahhg.equals(z.bAM());
    AppMethodBeat.o(114583);
    return bool;
  }
  
  public static String k(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114584);
    if (paramMultiTalkGroup == null)
    {
      AppMethodBeat.o(114584);
      return "";
    }
    String str2 = paramMultiTalkGroup.LiU;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = paramMultiTalkGroup.ahhf;
    }
    paramMultiTalkGroup = Util.nullAs(str1, "");
    AppMethodBeat.o(114584);
    return paramMultiTalkGroup;
  }
  
  public static String l(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114586);
    String str = null;
    int i = 0;
    if (i < paramMultiTalkGroup.ahhh.size())
    {
      if (!((MultiTalkGroupMember)paramMultiTalkGroup.ahhh.get(i)).ahhi.equals(z.bAM())) {
        break label80;
      }
      str = ((MultiTalkGroupMember)paramMultiTalkGroup.ahhh.get(i)).ahhj;
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
      LpD = new a("WIFI", 0);
      LpE = new a("_4G", 1);
      LpF = new a("_3GOr_2G", 2);
      LpG = new a("None", 3);
      LpH = new a[] { LpD, LpE, LpF, LpG };
      AppMethodBeat.o(114578);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.u
 * JD-Core Version:    0.7.0.1
 */