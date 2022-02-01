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
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.Iterator;
import java.util.List;

public final class v
{
  public static boolean XA(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
  
  public static boolean Xz(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  public static boolean c(o paramo)
  {
    return (paramo == o.FzI) || (paramo == o.FzJ) || (paramo == o.FzG);
  }
  
  public static String eXM()
  {
    AppMethodBeat.i(114585);
    String str = k(ad.eYc().FrY);
    AppMethodBeat.o(114585);
    return str;
  }
  
  public static String eXN()
  {
    AppMethodBeat.i(114587);
    String str = l(ad.eYc().FrY);
    AppMethodBeat.o(114587);
    return str;
  }
  
  public static v.a eXO()
  {
    AppMethodBeat.i(114589);
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      locala = v.a.Ftk;
      AppMethodBeat.o(114589);
      return locala;
    }
    if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
    {
      locala = v.a.Ftl;
      AppMethodBeat.o(114589);
      return locala;
    }
    if ((NetStatusUtil.is3G(MMApplicationContext.getContext())) || (NetStatusUtil.is2G(MMApplicationContext.getContext())))
    {
      locala = v.a.Ftm;
      AppMethodBeat.o(114589);
      return locala;
    }
    v.a locala = v.a.Ftn;
    AppMethodBeat.o(114589);
    return locala;
  }
  
  public static boolean eXP()
  {
    AppMethodBeat.i(114590);
    int i = ((Integer)h.aHG().aHp().get(ar.a.VuB, Integer.valueOf(-1))).intValue();
    long l = ((Long)h.aHG().aHp().get(ar.a.VuC, Long.valueOf(-1L))).longValue();
    if ((i > 0) && (l > 0L))
    {
      Log.i("MicroMsg.MultiTalkUtil", "checkMultiTalkAvailable, disableTime: %s, disableTimestamp: %s", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
      if (Util.ticksToNow(l) <= i * 1000)
      {
        AppMethodBeat.o(114590);
        return false;
      }
      h.aHG().aHp().set(ar.a.VuB, Integer.valueOf(-1));
      h.aHG().aHp().set(ar.a.VuC, Long.valueOf(-1L));
      AppMethodBeat.o(114590);
      return true;
    }
    h.aHG().aHp().set(ar.a.VuB, Integer.valueOf(-1));
    h.aHG().aHp().set(ar.a.VuC, Long.valueOf(-1L));
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
    Object localObject = paramMultiTalkGroup.ZiG;
    localStringBuffer.append("->[usernamelist]");
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject).next();
        localStringBuffer.append(localMultiTalkGroupMember.ZiH + "|");
        localStringBuffer.append(localMultiTalkGroupMember.status + ", ");
      }
    }
    localStringBuffer.append(" ->createname:" + paramMultiTalkGroup.ZiF);
    localStringBuffer.append(" ->talkgroupId:" + paramMultiTalkGroup.FmO);
    localStringBuffer.append(" ->wxGroupId:" + paramMultiTalkGroup.FmP);
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
    paramMultiTalkGroup = paramMultiTalkGroup.ZiG.iterator();
    int i = 0;
    int j = 0;
    while (paramMultiTalkGroup.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)paramMultiTalkGroup.next();
      if (localMultiTalkGroupMember.ZiH.equals(z.bcZ()))
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
    AppMethodBeat.i(198628);
    paramMultiTalkGroup = paramMultiTalkGroup.ZiG.iterator();
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
        AppMethodBeat.o(198628);
        return true;
      }
      AppMethodBeat.o(198628);
      return false;
    }
  }
  
  public static boolean j(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114583);
    boolean bool = paramMultiTalkGroup.ZiF.equals(z.bcZ());
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
    String str2 = paramMultiTalkGroup.FmO;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = paramMultiTalkGroup.ZiE;
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
    if (i < paramMultiTalkGroup.ZiG.size())
    {
      if (!((MultiTalkGroupMember)paramMultiTalkGroup.ZiG.get(i)).ZiH.equals(z.bcZ())) {
        break label80;
      }
      str = ((MultiTalkGroupMember)paramMultiTalkGroup.ZiG.get(i)).ZiI;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.v
 * JD-Core Version:    0.7.0.1
 */