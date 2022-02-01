package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.a.aw;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.common.b.a.a.a.az;
import com.tencent.pb.common.b.a.a.a.u;
import com.tencent.pb.common.c.b;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TalkRoom
  extends MultiTalkGroup
{
  a.aw Mlp;
  Map<String, d> Mlq;
  
  public TalkRoom(String paramString, Integer paramInteger, a.aw paramaw)
  {
    AppMethodBeat.i(213648);
    this.Mlq = new ConcurrentHashMap();
    c(paramString, paramInteger);
    b(paramaw);
    AppMethodBeat.o(213648);
  }
  
  private static void Fd(long paramLong)
  {
    AppMethodBeat.i(62570);
    b.d("tagorewang:TalkRoom", new Object[] { "setRoomKey: ", Long.valueOf(paramLong) });
    AppMethodBeat.o(62570);
  }
  
  private static a.u a(a.aw paramaw)
  {
    AppMethodBeat.i(213649);
    if (paramaw != null) {}
    try
    {
      byte[] arrayOfByte = paramaw.LIn;
      if (arrayOfByte == null)
      {
        AppMethodBeat.o(213649);
        return null;
      }
      paramaw = paramaw.LIn;
      paramaw = (a.u)e.a(new a.u(), paramaw, paramaw.length);
      AppMethodBeat.o(213649);
      return paramaw;
    }
    catch (Exception paramaw)
    {
      b.w("tagorewang:TalkRoom", new Object[] { "toPlayItemInfo err: ", paramaw });
      AppMethodBeat.o(213649);
    }
    return null;
  }
  
  public static TalkRoom a(TalkRoom paramTalkRoom, String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.aw paramaw, a.ay[] paramArrayOfay, a.az[] paramArrayOfaz)
  {
    AppMethodBeat.i(213647);
    if (paramTalkRoom == null)
    {
      b.w("tagorewang:TalkRoom:update", new Object[] { "updateAll null" });
      AppMethodBeat.o(213647);
      return null;
    }
    b.d("tagorewang:TalkRoom:update", new Object[] { "updateAll groupId: ", paramString1, " tmpId: ", paramString2 });
    paramTalkRoom.c(paramString1, paramInteger);
    paramTalkRoom.aZX(paramString2);
    setRoomId(paramInt);
    Fd(paramLong);
    paramTalkRoom.b(paramaw);
    if (paramArrayOfay == null)
    {
      paramInt = 0;
      if (paramArrayOfaz != null) {
        break label139;
      }
    }
    label139:
    for (int i = 0;; i = paramArrayOfaz.length)
    {
      if ((paramInt != 0) || (i != 0)) {
        break label147;
      }
      b.w("tagorewang:TalkRoom:update", new Object[] { "updateAll null VoiceGroupMem or VoiceGroupUsrProfile array." });
      AppMethodBeat.o(213647);
      return paramTalkRoom;
      paramInt = paramArrayOfay.length;
      break;
    }
    label147:
    paramString2 = new HashSet(paramTalkRoom.Mlq.keySet());
    paramString2.remove(a.fTk());
    i = 0;
    while (i != paramInt)
    {
      paramInteger = paramArrayOfay[i];
      if (paramInteger == null)
      {
        b.w("tagorewang:TalkRoom:update", new Object[] { "null member info, index: ", Integer.valueOf(i) });
        i += 1;
      }
      else
      {
        paramString1 = paramTalkRoom.aZY(paramInteger.dtx);
        if (paramString1 == null)
        {
          b.d("tagorewang:TalkRoom:update", new Object[] { "add new member" });
          paramString1 = new d(paramInteger);
          paramTalkRoom.a(paramString1);
        }
        for (;;)
        {
          paramString2.remove(paramString1.fZx());
          break;
          paramString1.a(paramInteger);
        }
      }
    }
    paramString1 = paramString2.iterator();
    while (paramString1.hasNext())
    {
      paramInteger = (String)paramString1.next();
      b.d("tagorewang:TalkRoom:update", new Object[] { "keyset", paramInteger });
      b.d("tagorewang:TalkRoom", new Object[] { "remove", paramTalkRoom.Mlq.remove(paramInteger) });
    }
    if (paramString2.size() > 0) {
      b.w("tagorewang:TalkRoom:update", new Object[] { "updateAll not update uuid keyset.size(): ", Integer.valueOf(paramString2.size()) });
    }
    b.d("tagorewang:TalkRoom:update", new Object[] { "did updateAll" });
    AppMethodBeat.o(213647);
    return paramTalkRoom;
  }
  
  public static TalkRoom a(String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.aw paramaw, a.ay[] paramArrayOfay, a.az[] paramArrayOfaz)
  {
    AppMethodBeat.i(213646);
    b.d("tagorewang:TalkRoom:create", new Object[] { "create groupId: ", paramString1, " tmpId: ", paramString2 });
    paramInteger = new TalkRoom(paramString1, paramInteger, paramaw);
    paramInteger.aZX(paramString2);
    setRoomId(paramInt);
    Fd(paramLong);
    if (paramArrayOfay == null)
    {
      paramInt = 0;
      if (paramArrayOfaz != null) {
        break label130;
      }
    }
    label130:
    for (int i = 0;; i = paramArrayOfaz.length)
    {
      int j = 0;
      for (;;)
      {
        if (j == paramInt) {
          break label223;
        }
        paramString2 = paramArrayOfay[j];
        if (paramString2 != null) {
          break;
        }
        b.w("tagorewang:TalkRoom:create", new Object[] { "null member info, index: ", Integer.valueOf(j) });
        j += 1;
      }
      paramInt = paramArrayOfay.length;
      break;
    }
    int k = 0;
    for (;;)
    {
      paramString1 = null;
      if (k != i)
      {
        paramString1 = paramArrayOfaz[k];
        if ((paramString1 != null) && (paramString1.Fpp == paramString2.Fpp)) {
          b.d("tagorewang:TalkRoom:create", new Object[] { "member info: ", paramString2, " profile: ", paramString1 });
        }
      }
      else
      {
        paramInteger.a(new d(paramString2, paramString1));
        break;
      }
      k += 1;
    }
    label223:
    b.d("tagorewang:TalkRoom:create", new Object[] { "did create" });
    AppMethodBeat.o(213646);
    return paramInteger;
  }
  
  private void aZX(String paramString)
  {
    AppMethodBeat.i(62565);
    if (j.ban(paramString)) {
      this.LJD = paramString;
    }
    AppMethodBeat.o(62565);
  }
  
  private void b(a.aw paramaw)
  {
    AppMethodBeat.i(213650);
    if (paramaw == null)
    {
      AppMethodBeat.o(213650);
      return;
    }
    try
    {
      this.LJE = paramaw.LIu;
      this.LJF = paramaw.LIt;
      a.u localu1;
      a.u localu2;
      if ((this.Mlp != null) && (paramaw.dtc != 0))
      {
        localu1 = a(paramaw);
        localu2 = a(this.Mlp);
        if (localu1 != null) {
          break label84;
        }
      }
      for (paramaw.LIn = this.Mlp.LIn;; paramaw.LIn = this.Mlp.LIn)
      {
        label84:
        do
        {
          this.Mlp = paramaw;
          AppMethodBeat.o(213650);
          return;
        } while ((localu1.LGU != 0) && (localu1.LGU == localu2.LGU));
        b.w("tagorewang:TalkRoom", new Object[] { "setRoomInfo bad id: ", Integer.valueOf(localu2.LGU), " -> ", Integer.valueOf(localu1.LGU) });
      }
      return;
    }
    catch (Exception localException)
    {
      b.w("tagorewang:TalkRoom", new Object[] { "setRoomInfo assert failed: ", localException });
      this.Mlp = paramaw;
      AppMethodBeat.o(213650);
    }
  }
  
  private void c(String paramString, Integer paramInteger)
  {
    AppMethodBeat.i(62566);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62566);
      return;
    }
    if (j.ban(paramString)) {
      this.LJD = paramString;
    }
    for (;;)
    {
      if (paramInteger != null) {
        this.LFq = paramInteger.intValue();
      }
      AppMethodBeat.o(62566);
      return;
      this.LJC = paramString;
    }
  }
  
  public static long exx()
  {
    AppMethodBeat.i(62569);
    long l = j.fZZ();
    AppMethodBeat.o(62569);
    return l;
  }
  
  public static boolean fZi()
  {
    return false;
  }
  
  public static int fZk()
  {
    AppMethodBeat.i(62567);
    int i = j.fZY();
    AppMethodBeat.o(62567);
    return i;
  }
  
  private String fZl()
  {
    AppMethodBeat.i(62572);
    Object localObject1;
    if ((this.Mlp == null) || (TextUtils.isEmpty(this.Mlp.name)))
    {
      localObject1 = new ArrayList(this.Mlq.values());
      Object localObject2 = a.fTk();
      ((List)localObject1).remove(this.Mlq.get(localObject2));
      localObject1 = iR((List)localObject1);
      b.i("tagorewang:TalkRoom", new Object[] { "getOtherMembers size: ", Integer.valueOf(((List)localObject1).size()), " all size: ", Integer.valueOf(this.Mlq.size()) });
      localObject2 = new StringBuilder();
      if (localObject1 != null)
      {
        int j = ((List)localObject1).size();
        int i = 0;
        for (;;)
        {
          if (i == j) {
            break label213;
          }
          try
          {
            ((StringBuilder)localObject2).append(((d)((List)localObject1).get(i)).getDisplayName());
            if (i != j - 1) {
              ((StringBuilder)localObject2).append('、');
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              b.w("tagorewang:TalkRoom", new Object[] { "updateRoomNameIfEmpty err and continue: ", localException });
            }
          }
          i += 1;
        }
      }
      label213:
      if (((StringBuilder)localObject2).toString().length() > 0)
      {
        localObject1 = ((StringBuilder)localObject2).toString();
        AppMethodBeat.o(62572);
        return localObject1;
      }
    }
    if ((this.Mlp != null) && (!TextUtils.isEmpty(this.Mlp.name)))
    {
      localObject1 = this.Mlp.name;
      AppMethodBeat.o(62572);
      return localObject1;
    }
    b.w("tagorewang:TalkRoom", new Object[] { "updateRoomNameIfEmpty still empty, groupId: ", this.LJC, " tmpId: ", this.LJD });
    AppMethodBeat.o(62572);
    return null;
  }
  
  private static List<d> iR(List<d> paramList)
  {
    AppMethodBeat.i(62577);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(62577);
      return paramList;
    }
    Collections.sort(paramList, new TalkRoom.a());
    AppMethodBeat.o(62577);
    return paramList;
  }
  
  private static void setRoomId(int paramInt)
  {
    AppMethodBeat.i(62568);
    b.d("tagorewang:TalkRoom", new Object[] { "setRoomId: ", Integer.valueOf(paramInt) });
    AppMethodBeat.o(62568);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(62574);
    this.Mlq.put(paramd.fZx(), paramd);
    AppMethodBeat.o(62574);
  }
  
  public final d aZY(String paramString)
  {
    AppMethodBeat.i(62578);
    paramString = (d)this.Mlq.get(paramString);
    AppMethodBeat.o(62578);
    return paramString;
  }
  
  public final int fZj()
  {
    if (this.LFq == 0) {
      return 0;
    }
    return this.LFq;
  }
  
  public final List<d> fZm()
  {
    AppMethodBeat.i(62575);
    List localList = iR(new ArrayList(this.Mlq.values()));
    d locald = fZo();
    localList.remove(locald);
    localList.add(0, locald);
    locald = (d)this.Mlq.get(Integer.valueOf(90100));
    if (locald != null)
    {
      localList.remove(locald);
      localList.add(locald);
    }
    AppMethodBeat.o(62575);
    return localList;
  }
  
  public final List<d> fZn()
  {
    AppMethodBeat.i(62576);
    ArrayList localArrayList = new ArrayList(this.Mlq.values());
    AppMethodBeat.o(62576);
    return localArrayList;
  }
  
  public final d fZo()
  {
    AppMethodBeat.i(62579);
    d locald = (d)this.Mlq.get(a.fTk());
    AppMethodBeat.o(62579);
    return locald;
  }
  
  public final List<a.ay> fZp()
  {
    AppMethodBeat.i(62580);
    List localList = fZq();
    AppMethodBeat.o(62580);
    return localList;
  }
  
  public final List<a.ay> fZq()
  {
    AppMethodBeat.i(62581);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Mlq.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((d)((Map.Entry)localIterator.next()).getValue()).Mlx);
    }
    AppMethodBeat.o(62581);
    return localArrayList;
  }
  
  public final MultiTalkGroup fZr()
  {
    AppMethodBeat.i(62583);
    MultiTalkGroup localMultiTalkGroup = new MultiTalkGroup();
    localMultiTalkGroup.LJC = this.LJC;
    localMultiTalkGroup.LJD = this.LJD;
    localMultiTalkGroup.LFq = this.LFq;
    localMultiTalkGroup.LJE = this.LJE;
    localMultiTalkGroup.LJF = this.LJF;
    ArrayList localArrayList = new ArrayList();
    Object localObject = fZn();
    if (((List)localObject).size() > 0)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald != null)
        {
          MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
          localMultiTalkGroupMember.LJH = locald.fZx();
          if (locald.Mlx != null)
          {
            localObject = locald.Mlx.LIV;
            label148:
            localMultiTalkGroupMember.LJI = ((String)localObject);
            if (locald.Mlx == null) {
              break label241;
            }
            i = locald.Mlx.reason;
            label171:
            localMultiTalkGroupMember.reason = i;
            localMultiTalkGroupMember.status = locald.getState();
            if ((locald.Mlx == null) || (locald.Mlx.LIJ == 0)) {
              break label246;
            }
          }
          label241:
          label246:
          for (int i = locald.Mlx.LIJ;; i = 0)
          {
            localMultiTalkGroupMember.LIJ = i;
            localArrayList.add(localMultiTalkGroupMember);
            break;
            localObject = "";
            break label148;
            i = 0;
            break label171;
          }
        }
      }
    }
    localMultiTalkGroup.LJG = localArrayList;
    AppMethodBeat.o(62583);
    return localMultiTalkGroup;
  }
  
  public String toString()
  {
    AppMethodBeat.i(62582);
    localStringBuilder1 = new StringBuilder();
    for (;;)
    {
      try
      {
        localStringBuilder1.append("groupId: ").append(this.LJC);
        localStringBuilder1.append(" tmpId: ").append(this.LJD);
        localStringBuilder1.append(" routeId: ").append(this.LFq);
        StringBuilder localStringBuilder2 = localStringBuilder1.append(" room name: ");
        if ((this.Mlp != null) && (!TextUtils.isEmpty(this.Mlp.name))) {
          continue;
        }
        str = fZl();
        localStringBuilder2.append(str);
      }
      catch (Exception localException)
      {
        String str;
        localStringBuilder1.append(" broken by " + localException.getMessage());
        continue;
      }
      str = localStringBuilder1.toString();
      AppMethodBeat.o(62582);
      return str;
      str = this.Mlp.name;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.TalkRoom
 * JD-Core Version:    0.7.0.1
 */