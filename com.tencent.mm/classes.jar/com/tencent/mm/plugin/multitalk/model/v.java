package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.ui.widget.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.Iterator;
import java.util.List;

public final class v
{
  public static boolean Rl(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  public static boolean Rm(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
  
  public static boolean c(o paramo)
  {
    return (paramo == o.zUf) || (paramo == o.zUg) || (paramo == o.zUd);
  }
  
  public static String enW()
  {
    AppMethodBeat.i(114585);
    String str = k(ac.eom().zME);
    AppMethodBeat.o(114585);
    return str;
  }
  
  public static String enX()
  {
    AppMethodBeat.i(114587);
    String str = l(ac.eom().zME);
    AppMethodBeat.o(114587);
    return str;
  }
  
  public static a enY()
  {
    AppMethodBeat.i(114589);
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      locala = a.zNN;
      AppMethodBeat.o(114589);
      return locala;
    }
    if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
    {
      locala = a.zNO;
      AppMethodBeat.o(114589);
      return locala;
    }
    if ((NetStatusUtil.is3G(MMApplicationContext.getContext())) || (NetStatusUtil.is2G(MMApplicationContext.getContext())))
    {
      locala = a.zNP;
      AppMethodBeat.o(114589);
      return locala;
    }
    a locala = a.zNQ;
    AppMethodBeat.o(114589);
    return locala;
  }
  
  public static boolean enZ()
  {
    AppMethodBeat.i(114590);
    int i = ((Integer)g.aAh().azQ().get(ar.a.Ogl, Integer.valueOf(-1))).intValue();
    long l = ((Long)g.aAh().azQ().get(ar.a.Ogm, Long.valueOf(-1L))).longValue();
    if ((i > 0) && (l > 0L))
    {
      Log.i("MicroMsg.MultiTalkUtil", "checkMultiTalkAvailable, disableTime: %s, disableTimestamp: %s", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
      if (Util.ticksToNow(l) <= i * 1000)
      {
        AppMethodBeat.o(114590);
        return false;
      }
      g.aAh().azQ().set(ar.a.Ogl, Integer.valueOf(-1));
      g.aAh().azQ().set(ar.a.Ogm, Long.valueOf(-1L));
      AppMethodBeat.o(114590);
      return true;
    }
    g.aAh().azQ().set(ar.a.Ogl, Integer.valueOf(-1));
    g.aAh().azQ().set(ar.a.Ogm, Long.valueOf(-1L));
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
    Object localObject = paramMultiTalkGroup.RHa;
    localStringBuffer.append("->[usernamelist]");
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject).next();
        localStringBuffer.append(localMultiTalkGroupMember.RHb + "|");
        localStringBuffer.append(localMultiTalkGroupMember.status + ", ");
      }
    }
    localStringBuffer.append(" ->createname:" + paramMultiTalkGroup.RGZ);
    localStringBuffer.append(" ->talkgroupId:" + paramMultiTalkGroup.zHD);
    localStringBuffer.append(" ->wxGroupId:" + paramMultiTalkGroup.zHE);
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
    paramMultiTalkGroup = paramMultiTalkGroup.RHa.iterator();
    int i = 0;
    int j = 0;
    while (paramMultiTalkGroup.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)paramMultiTalkGroup.next();
      if (localMultiTalkGroupMember.RHb.equals(z.aTY()))
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
    AppMethodBeat.i(239428);
    paramMultiTalkGroup = paramMultiTalkGroup.RHa.iterator();
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
        AppMethodBeat.o(239428);
        return true;
      }
      AppMethodBeat.o(239428);
      return false;
    }
  }
  
  public static boolean j(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114583);
    boolean bool = paramMultiTalkGroup.RGZ.equals(z.aTY());
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
    String str2 = paramMultiTalkGroup.zHD;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = paramMultiTalkGroup.RGY;
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
    if (i < paramMultiTalkGroup.RHa.size())
    {
      if (!((MultiTalkGroupMember)paramMultiTalkGroup.RHa.get(i)).RHb.equals(z.aTY())) {
        break label80;
      }
      str = ((MultiTalkGroupMember)paramMultiTalkGroup.RHa.get(i)).RHc;
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
      zNN = new a("WIFI", 0);
      zNO = new a("_4G", 1);
      zNP = new a("_3GOr_2G", 2);
      zNQ = new a("None", 3);
      zNR = new a[] { zNN, zNO, zNP, zNQ };
      AppMethodBeat.o(114578);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.v
 * JD-Core Version:    0.7.0.1
 */