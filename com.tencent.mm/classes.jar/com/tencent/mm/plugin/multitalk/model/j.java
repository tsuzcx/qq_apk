package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.Iterator;
import java.util.List;

public final class j
{
  public static final float[][] oUd;
  
  static
  {
    float[][] arrayOfFloat = new float[6][];
    oUd = arrayOfFloat;
    arrayOfFloat[0] = null;
    oUd[1] = { 0.5F, 0.5F };
    oUd[2] = { 0.0F, 0.5F, 1.0F, 0.5F };
    oUd[3] = { 0.0F, 0.0F, 1.0F, 0.0F, 0.5F, 1.0F };
    oUd[4] = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
    oUd[5] = { 0.0F, 0.0F, 1.0F, 0.0F, 2.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2.0F, 1.0F, 0.0F, 2.0F, 1.0F, 2.0F, 2.0F, 2.0F };
  }
  
  public static boolean a(MultiTalkGroup paramMultiTalkGroup1, MultiTalkGroup paramMultiTalkGroup2)
  {
    AppMethodBeat.i(54049);
    if ((paramMultiTalkGroup1 == null) || (paramMultiTalkGroup2 == null))
    {
      AppMethodBeat.o(54049);
      return false;
    }
    if ((!bo.isNullOrNil(paramMultiTalkGroup1.Bhl)) && (!bo.isNullOrNil(paramMultiTalkGroup2.Bhl)) && (paramMultiTalkGroup1.Bhl.equals(paramMultiTalkGroup2.Bhl)))
    {
      AppMethodBeat.o(54049);
      return true;
    }
    if ((!bo.isNullOrNil(paramMultiTalkGroup1.Bhm)) && (!bo.isNullOrNil(paramMultiTalkGroup2.Bhm)) && (paramMultiTalkGroup1.Bhm.equals(paramMultiTalkGroup2.Bhm)))
    {
      AppMethodBeat.o(54049);
      return true;
    }
    AppMethodBeat.o(54049);
    return false;
  }
  
  public static String bTu()
  {
    AppMethodBeat.i(54054);
    String str = l(p.bTF().oTs);
    AppMethodBeat.o(54054);
    return str;
  }
  
  public static String bTv()
  {
    AppMethodBeat.i(54056);
    String str = m(p.bTF().oTs);
    AppMethodBeat.o(54056);
    return str;
  }
  
  public static boolean bTw()
  {
    return false;
  }
  
  public static j.a bTx()
  {
    AppMethodBeat.i(54058);
    if (at.isWifi(ah.getContext()))
    {
      locala = j.a.oUe;
      AppMethodBeat.o(54058);
      return locala;
    }
    if (at.is4G(ah.getContext()))
    {
      locala = j.a.oUf;
      AppMethodBeat.o(54058);
      return locala;
    }
    if ((at.is3G(ah.getContext())) || (at.is2G(ah.getContext())))
    {
      locala = j.a.oUg;
      AppMethodBeat.o(54058);
      return locala;
    }
    j.a locala = j.a.oUh;
    AppMethodBeat.o(54058);
    return locala;
  }
  
  public static boolean bTy()
  {
    AppMethodBeat.i(54059);
    int i = ((Integer)g.RL().Ru().get(ac.a.yJN, Integer.valueOf(-1))).intValue();
    long l = ((Long)g.RL().Ru().get(ac.a.yJO, Long.valueOf(-1L))).longValue();
    if ((i > 0) && (l > 0L))
    {
      ab.i("MicroMsg.MultiTalkUtil", "checkMultiTalkAvailable, disableTime: %s, disableTimestamp: %s", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
      if (bo.av(l) <= i * 1000)
      {
        AppMethodBeat.o(54059);
        return false;
      }
      g.RL().Ru().set(ac.a.yJN, Integer.valueOf(-1));
      g.RL().Ru().set(ac.a.yJO, Long.valueOf(-1L));
      AppMethodBeat.o(54059);
      return true;
    }
    g.RL().Ru().set(ac.a.yJN, Integer.valueOf(-1));
    g.RL().Ru().set(ac.a.yJO, Long.valueOf(-1L));
    AppMethodBeat.o(54059);
    return true;
  }
  
  public static boolean c(com.tencent.mm.plugin.multitalk.ui.widget.e parame)
  {
    return (parame == com.tencent.mm.plugin.multitalk.ui.widget.e.oVR) || (parame == com.tencent.mm.plugin.multitalk.ui.widget.e.oVS) || (parame == com.tencent.mm.plugin.multitalk.ui.widget.e.oVP);
  }
  
  public static String h(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(54048);
    if (paramMultiTalkGroup == null)
    {
      AppMethodBeat.o(54048);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = paramMultiTalkGroup.Bhp;
    localStringBuffer.append("->[usernamelist]");
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject).next();
        localStringBuffer.append(localMultiTalkGroupMember.Bhq + "|");
        localStringBuffer.append(localMultiTalkGroupMember.status + ", ");
      }
    }
    localStringBuffer.append(" ->createname:" + paramMultiTalkGroup.Bho);
    localStringBuffer.append(" ->talkgroupId:" + paramMultiTalkGroup.Bhl);
    localStringBuffer.append(" ->wxGroupId:" + paramMultiTalkGroup.Bhn);
    paramMultiTalkGroup = localStringBuffer.toString();
    AppMethodBeat.o(54048);
    return paramMultiTalkGroup;
  }
  
  public static boolean i(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(54050);
    if (paramMultiTalkGroup == null)
    {
      AppMethodBeat.o(54050);
      return false;
    }
    paramMultiTalkGroup = paramMultiTalkGroup.Bhp.iterator();
    int i = 0;
    int j = 0;
    while (paramMultiTalkGroup.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)paramMultiTalkGroup.next();
      if (localMultiTalkGroupMember.Bhq.equals(r.Zn()))
      {
        if (localMultiTalkGroupMember.status != 10) {
          break label124;
        }
        if (i != 0)
        {
          AppMethodBeat.o(54050);
          return true;
        }
        j = 1;
      }
      else
      {
        if (localMultiTalkGroupMember.status != 10) {
          break label124;
        }
        if (j != 0)
        {
          AppMethodBeat.o(54050);
          return true;
        }
        i = 1;
      }
    }
    label124:
    for (;;)
    {
      break;
      AppMethodBeat.o(54050);
      return false;
    }
  }
  
  public static boolean j(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(54051);
    paramMultiTalkGroup = paramMultiTalkGroup.Bhp.iterator();
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
        AppMethodBeat.o(54051);
        return true;
      }
      AppMethodBeat.o(54051);
      return false;
    }
  }
  
  public static boolean k(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(54052);
    boolean bool = paramMultiTalkGroup.Bho.equals(r.Zn());
    AppMethodBeat.o(54052);
    return bool;
  }
  
  public static String l(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(54053);
    if (paramMultiTalkGroup == null)
    {
      AppMethodBeat.o(54053);
      return "";
    }
    String str2 = paramMultiTalkGroup.Bhl;
    String str1 = str2;
    if (bo.isNullOrNil(str2)) {
      str1 = paramMultiTalkGroup.Bhm;
    }
    paramMultiTalkGroup = bo.bf(str1, "");
    AppMethodBeat.o(54053);
    return paramMultiTalkGroup;
  }
  
  public static String m(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(54055);
    String str = null;
    int i = 0;
    if (i < paramMultiTalkGroup.Bhp.size())
    {
      if (!((MultiTalkGroupMember)paramMultiTalkGroup.Bhp.get(i)).Bhq.equals(r.Zn())) {
        break label80;
      }
      str = ((MultiTalkGroupMember)paramMultiTalkGroup.Bhp.get(i)).Bhr;
    }
    label80:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(54055);
      return str;
    }
  }
  
  public static int x(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(54057);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("state");
      if (paramIntent != null)
      {
        if (paramIntent.equals("IDLE"))
        {
          AppMethodBeat.o(54057);
          return 0;
        }
        if (paramIntent.equals("RINGING"))
        {
          AppMethodBeat.o(54057);
          return 1;
        }
        if (paramIntent.equals("OFFHOOK"))
        {
          AppMethodBeat.o(54057);
          return 2;
        }
      }
    }
    int i = ((TelephonyManager)paramContext.getSystemService("phone")).getCallState();
    AppMethodBeat.o(54057);
    return i;
  }
  
  public static boolean zG(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  public static boolean zH(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.j
 * JD-Core Version:    0.7.0.1
 */