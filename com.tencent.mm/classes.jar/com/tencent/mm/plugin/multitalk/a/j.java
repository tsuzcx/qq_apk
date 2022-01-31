package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.Iterator;
import java.util.List;

public final class j
{
  public static final float[][] muo;
  
  static
  {
    float[][] arrayOfFloat = new float[6][];
    muo = arrayOfFloat;
    arrayOfFloat[0] = null;
    muo[1] = { 0.5F, 0.5F };
    muo[2] = { 0.0F, 0.5F, 1.0F, 0.5F };
    muo[3] = { 0.0F, 0.0F, 1.0F, 0.0F, 0.5F, 1.0F };
    muo[4] = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
    muo[5] = { 0.0F, 0.0F, 1.0F, 0.0F, 2.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2.0F, 1.0F, 0.0F, 2.0F, 1.0F, 2.0F, 2.0F, 2.0F };
  }
  
  public static boolean a(MultiTalkGroup paramMultiTalkGroup1, MultiTalkGroup paramMultiTalkGroup2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramMultiTalkGroup1 == null) || (paramMultiTalkGroup2 == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        if ((bk.bl(paramMultiTalkGroup1.wJL)) || (bk.bl(paramMultiTalkGroup2.wJL))) {
          break;
        }
        bool1 = bool2;
      } while (paramMultiTalkGroup1.wJL.equals(paramMultiTalkGroup2.wJL));
      if ((bk.bl(paramMultiTalkGroup1.wJM)) || (bk.bl(paramMultiTalkGroup2.wJM))) {
        break;
      }
      bool1 = bool2;
    } while (paramMultiTalkGroup1.wJM.equals(paramMultiTalkGroup2.wJM));
    return false;
  }
  
  public static String blu()
  {
    return l(p.blF().mtH);
  }
  
  public static String blv()
  {
    return m(p.blF().mtH);
  }
  
  public static boolean blw()
  {
    return false;
  }
  
  public static j.a blx()
  {
    if (aq.isWifi(ae.getContext())) {
      return j.a.mup;
    }
    if (aq.is4G(ae.getContext())) {
      return j.a.muq;
    }
    if ((aq.is3G(ae.getContext())) || (aq.is2G(ae.getContext()))) {
      return j.a.mur;
    }
    return j.a.mus;
  }
  
  public static boolean bly()
  {
    int i = ((Integer)g.DP().Dz().get(ac.a.uyZ, Integer.valueOf(-1))).intValue();
    long l = ((Long)g.DP().Dz().get(ac.a.uza, Long.valueOf(-1L))).longValue();
    if ((i > 0) && (l > 0L))
    {
      y.i("MicroMsg.MultiTalkUtil", "checkMultiTalkAvailable, disableTime: %s, disableTimestamp: %s", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
      if (bk.cp(l) <= i * 1000) {
        return false;
      }
      g.DP().Dz().c(ac.a.uyZ, Integer.valueOf(-1));
      g.DP().Dz().c(ac.a.uza, Long.valueOf(-1L));
      return true;
    }
    g.DP().Dz().c(ac.a.uyZ, Integer.valueOf(-1));
    g.DP().Dz().c(ac.a.uza, Long.valueOf(-1L));
    return true;
  }
  
  public static boolean c(com.tencent.mm.plugin.multitalk.ui.widget.e parame)
  {
    return (parame == com.tencent.mm.plugin.multitalk.ui.widget.e.mvZ) || (parame == com.tencent.mm.plugin.multitalk.ui.widget.e.mwa) || (parame == com.tencent.mm.plugin.multitalk.ui.widget.e.mvX);
  }
  
  public static String h(MultiTalkGroup paramMultiTalkGroup)
  {
    if (paramMultiTalkGroup == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = paramMultiTalkGroup.wJP;
    localStringBuffer.append("->[usernamelist]");
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject).next();
        localStringBuffer.append(localMultiTalkGroupMember.wJQ + "|");
        localStringBuffer.append(localMultiTalkGroupMember.status + ", ");
      }
    }
    localStringBuffer.append(" ->createname:" + paramMultiTalkGroup.wJO);
    localStringBuffer.append(" ->talkgroupId:" + paramMultiTalkGroup.wJL);
    localStringBuffer.append(" ->wxGroupId:" + paramMultiTalkGroup.wJN);
    return localStringBuffer.toString();
  }
  
  public static boolean i(MultiTalkGroup paramMultiTalkGroup)
  {
    if (paramMultiTalkGroup == null) {
      return false;
    }
    paramMultiTalkGroup = paramMultiTalkGroup.wJP.iterator();
    int i = 0;
    int j = 0;
    label20:
    while (paramMultiTalkGroup.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)paramMultiTalkGroup.next();
      if (localMultiTalkGroupMember.wJQ.equals(q.Gj()))
      {
        if (localMultiTalkGroupMember.status != 10) {
          break label92;
        }
        if (i != 0) {
          return true;
        }
        j = 1;
      }
      else
      {
        if (localMultiTalkGroupMember.status != 10) {
          break label92;
        }
        if (j != 0) {
          return true;
        }
        i = 1;
      }
    }
    label92:
    for (;;)
    {
      break label20;
      break;
    }
  }
  
  public static boolean j(MultiTalkGroup paramMultiTalkGroup)
  {
    boolean bool = false;
    paramMultiTalkGroup = paramMultiTalkGroup.wJP.iterator();
    int i = 0;
    if (paramMultiTalkGroup.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)paramMultiTalkGroup.next();
      if ((localMultiTalkGroupMember.status != 10) && (localMultiTalkGroupMember.status != 1)) {
        break label66;
      }
      i += 1;
    }
    label66:
    for (;;)
    {
      break;
      if (i > 1) {
        bool = true;
      }
      return bool;
    }
  }
  
  public static boolean k(MultiTalkGroup paramMultiTalkGroup)
  {
    return paramMultiTalkGroup.wJO.equals(q.Gj());
  }
  
  public static String l(MultiTalkGroup paramMultiTalkGroup)
  {
    if (paramMultiTalkGroup == null) {
      return "";
    }
    String str2 = paramMultiTalkGroup.wJL;
    String str1 = str2;
    if (bk.bl(str2)) {
      str1 = paramMultiTalkGroup.wJM;
    }
    return bk.aM(str1, "");
  }
  
  public static String m(MultiTalkGroup paramMultiTalkGroup)
  {
    String str = null;
    int i = 0;
    if (i < paramMultiTalkGroup.wJP.size())
    {
      if (!((MultiTalkGroupMember)paramMultiTalkGroup.wJP.get(i)).wJQ.equals(q.Gj())) {
        break label68;
      }
      str = ((MultiTalkGroupMember)paramMultiTalkGroup.wJP.get(i)).wJR;
    }
    label68:
    for (;;)
    {
      i += 1;
      break;
      return str;
    }
  }
  
  public static int u(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("state");
      if (paramIntent != null)
      {
        if (paramIntent.equals("IDLE")) {
          return 0;
        }
        if (paramIntent.equals("RINGING")) {
          return 1;
        }
        if (paramIntent.equals("OFFHOOK")) {
          return 2;
        }
      }
    }
    return ((TelephonyManager)paramContext.getSystemService("phone")).getCallState();
  }
  
  public static boolean uq(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  public static boolean ur(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.j
 * JD-Core Version:    0.7.0.1
 */