package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.multitalk.ui.widget.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.Iterator;
import java.util.List;

public final class t
{
  public static boolean Lm(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  public static boolean Ln(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
  
  public static boolean c(i parami)
  {
    return (parami == i.wvY) || (parami == i.wvZ) || (parami == i.wvW);
  }
  
  public static a dtA()
  {
    AppMethodBeat.i(114589);
    if (az.isWifi(ak.getContext()))
    {
      locala = a.wrZ;
      AppMethodBeat.o(114589);
      return locala;
    }
    if (az.is4G(ak.getContext()))
    {
      locala = a.wsa;
      AppMethodBeat.o(114589);
      return locala;
    }
    if ((az.is3G(ak.getContext())) || (az.is2G(ak.getContext())))
    {
      locala = a.wsb;
      AppMethodBeat.o(114589);
      return locala;
    }
    a locala = a.wsc;
    AppMethodBeat.o(114589);
    return locala;
  }
  
  public static boolean dtB()
  {
    AppMethodBeat.i(114590);
    int i = ((Integer)g.ajR().ajA().get(am.a.IXO, Integer.valueOf(-1))).intValue();
    long l = ((Long)g.ajR().ajA().get(am.a.IXP, Long.valueOf(-1L))).longValue();
    if ((i > 0) && (l > 0L))
    {
      ae.i("MicroMsg.MultiTalkUtil", "checkMultiTalkAvailable, disableTime: %s, disableTimestamp: %s", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
      if (bu.aO(l) <= i * 1000)
      {
        AppMethodBeat.o(114590);
        return false;
      }
      g.ajR().ajA().set(am.a.IXO, Integer.valueOf(-1));
      g.ajR().ajA().set(am.a.IXP, Long.valueOf(-1L));
      AppMethodBeat.o(114590);
      return true;
    }
    g.ajR().ajA().set(am.a.IXO, Integer.valueOf(-1));
    g.ajR().ajA().set(am.a.IXP, Long.valueOf(-1L));
    AppMethodBeat.o(114590);
    return true;
  }
  
  public static String dty()
  {
    AppMethodBeat.i(114585);
    String str = k(z.dtK().wqU);
    AppMethodBeat.o(114585);
    return str;
  }
  
  public static String dtz()
  {
    AppMethodBeat.i(114587);
    String str = l(z.dtK().wqU);
    AppMethodBeat.o(114587);
    return str;
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
    Object localObject = paramMultiTalkGroup.MgI;
    localStringBuffer.append("->[usernamelist]");
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject).next();
        localStringBuffer.append(localMultiTalkGroupMember.MgJ + "|");
        localStringBuffer.append(localMultiTalkGroupMember.status + ", ");
      }
    }
    localStringBuffer.append(" ->createname:" + paramMultiTalkGroup.MgH);
    localStringBuffer.append(" ->talkgroupId:" + paramMultiTalkGroup.wmz);
    localStringBuffer.append(" ->wxGroupId:" + paramMultiTalkGroup.wmA);
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
    paramMultiTalkGroup = paramMultiTalkGroup.MgI.iterator();
    int i = 0;
    int j = 0;
    while (paramMultiTalkGroup.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)paramMultiTalkGroup.next();
      if (localMultiTalkGroupMember.MgJ.equals(v.aAC()))
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
    AppMethodBeat.i(190811);
    paramMultiTalkGroup = paramMultiTalkGroup.MgI.iterator();
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
        AppMethodBeat.o(190811);
        return true;
      }
      AppMethodBeat.o(190811);
      return false;
    }
  }
  
  public static boolean j(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114583);
    boolean bool = paramMultiTalkGroup.MgH.equals(v.aAC());
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
    String str2 = paramMultiTalkGroup.wmz;
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = paramMultiTalkGroup.MgG;
    }
    paramMultiTalkGroup = bu.bI(str1, "");
    AppMethodBeat.o(114584);
    return paramMultiTalkGroup;
  }
  
  public static String l(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114586);
    String str = null;
    int i = 0;
    if (i < paramMultiTalkGroup.MgI.size())
    {
      if (!((MultiTalkGroupMember)paramMultiTalkGroup.MgI.get(i)).MgJ.equals(v.aAC())) {
        break label80;
      }
      str = ((MultiTalkGroupMember)paramMultiTalkGroup.MgI.get(i)).MgK;
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
      wrZ = new a("WIFI", 0);
      wsa = new a("_4G", 1);
      wsb = new a("_3GOr_2G", 2);
      wsc = new a("None", 3);
      wsd = new a[] { wrZ, wsa, wsb, wsc };
      AppMethodBeat.o(114578);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.t
 * JD-Core Version:    0.7.0.1
 */