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
  a.aw MIm;
  Map<String, d> MIn;
  
  public TalkRoom(String paramString, Integer paramInteger, a.aw paramaw)
  {
    AppMethodBeat.i(208323);
    this.MIn = new ConcurrentHashMap();
    c(paramString, paramInteger);
    b(paramaw);
    AppMethodBeat.o(208323);
  }
  
  private static void FF(long paramLong)
  {
    AppMethodBeat.i(62570);
    b.d("tagorewang:TalkRoom", new Object[] { "setRoomKey: ", Long.valueOf(paramLong) });
    AppMethodBeat.o(62570);
  }
  
  private static a.u a(a.aw paramaw)
  {
    AppMethodBeat.i(208324);
    if (paramaw != null) {}
    try
    {
      byte[] arrayOfByte = paramaw.Mfr;
      if (arrayOfByte == null)
      {
        AppMethodBeat.o(208324);
        return null;
      }
      paramaw = paramaw.Mfr;
      paramaw = (a.u)e.a(new a.u(), paramaw, paramaw.length);
      AppMethodBeat.o(208324);
      return paramaw;
    }
    catch (Exception paramaw)
    {
      b.w("tagorewang:TalkRoom", new Object[] { "toPlayItemInfo err: ", paramaw });
      AppMethodBeat.o(208324);
    }
    return null;
  }
  
  public static TalkRoom a(TalkRoom paramTalkRoom, String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.aw paramaw, a.ay[] paramArrayOfay, a.az[] paramArrayOfaz)
  {
    AppMethodBeat.i(208322);
    if (paramTalkRoom == null)
    {
      b.w("tagorewang:TalkRoom:update", new Object[] { "updateAll null" });
      AppMethodBeat.o(208322);
      return null;
    }
    b.d("tagorewang:TalkRoom:update", new Object[] { "updateAll groupId: ", paramString1, " tmpId: ", paramString2 });
    paramTalkRoom.c(paramString1, paramInteger);
    paramTalkRoom.bbA(paramString2);
    setRoomId(paramInt);
    FF(paramLong);
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
      AppMethodBeat.o(208322);
      return paramTalkRoom;
      paramInt = paramArrayOfay.length;
      break;
    }
    label147:
    paramString2 = new HashSet(paramTalkRoom.MIn.keySet());
    paramString2.remove(a.fXK());
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
        paramString1 = paramTalkRoom.bbB(paramInteger.duC);
        if (paramString1 == null)
        {
          b.d("tagorewang:TalkRoom:update", new Object[] { "add new member" });
          paramString1 = new d(paramInteger);
          paramTalkRoom.a(paramString1);
        }
        for (;;)
        {
          paramString2.remove(paramString1.gdY());
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
      b.d("tagorewang:TalkRoom", new Object[] { "remove", paramTalkRoom.MIn.remove(paramInteger) });
    }
    if (paramString2.size() > 0) {
      b.w("tagorewang:TalkRoom:update", new Object[] { "updateAll not update uuid keyset.size(): ", Integer.valueOf(paramString2.size()) });
    }
    b.d("tagorewang:TalkRoom:update", new Object[] { "did updateAll" });
    AppMethodBeat.o(208322);
    return paramTalkRoom;
  }
  
  public static TalkRoom a(String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.aw paramaw, a.ay[] paramArrayOfay, a.az[] paramArrayOfaz)
  {
    AppMethodBeat.i(208321);
    b.d("tagorewang:TalkRoom:create", new Object[] { "create groupId: ", paramString1, " tmpId: ", paramString2 });
    paramInteger = new TalkRoom(paramString1, paramInteger, paramaw);
    paramInteger.bbA(paramString2);
    setRoomId(paramInt);
    FF(paramLong);
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
        if ((paramString1 != null) && (paramString1.FHN == paramString2.FHN)) {
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
    AppMethodBeat.o(208321);
    return paramInteger;
  }
  
  private void b(a.aw paramaw)
  {
    AppMethodBeat.i(208325);
    if (paramaw == null)
    {
      AppMethodBeat.o(208325);
      return;
    }
    try
    {
      this.wmA = paramaw.Mfy;
      this.MgH = paramaw.Mfx;
      a.u localu1;
      a.u localu2;
      if ((this.MIm != null) && (paramaw.dui != 0))
      {
        localu1 = a(paramaw);
        localu2 = a(this.MIm);
        if (localu1 != null) {
          break label84;
        }
      }
      for (paramaw.Mfr = this.MIm.Mfr;; paramaw.Mfr = this.MIm.Mfr)
      {
        label84:
        do
        {
          this.MIm = paramaw;
          AppMethodBeat.o(208325);
          return;
        } while ((localu1.MdY != 0) && (localu1.MdY == localu2.MdY));
        b.w("tagorewang:TalkRoom", new Object[] { "setRoomInfo bad id: ", Integer.valueOf(localu2.MdY), " -> ", Integer.valueOf(localu1.MdY) });
      }
      return;
    }
    catch (Exception localException)
    {
      b.w("tagorewang:TalkRoom", new Object[] { "setRoomInfo assert failed: ", localException });
      this.MIm = paramaw;
      AppMethodBeat.o(208325);
    }
  }
  
  private void bbA(String paramString)
  {
    AppMethodBeat.i(62565);
    if (j.bbQ(paramString)) {
      this.MgG = paramString;
    }
    AppMethodBeat.o(62565);
  }
  
  private void c(String paramString, Integer paramInteger)
  {
    AppMethodBeat.i(62566);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62566);
      return;
    }
    if (j.bbQ(paramString)) {
      this.MgG = paramString;
    }
    for (;;)
    {
      if (paramInteger != null) {
        this.Mcu = paramInteger.intValue();
      }
      AppMethodBeat.o(62566);
      return;
      this.wmz = paramString;
    }
  }
  
  public static long eBe()
  {
    AppMethodBeat.i(62569);
    long l = j.geB();
    AppMethodBeat.o(62569);
    return l;
  }
  
  public static boolean gdJ()
  {
    return false;
  }
  
  public static int gdL()
  {
    AppMethodBeat.i(62567);
    int i = j.geA();
    AppMethodBeat.o(62567);
    return i;
  }
  
  private String gdM()
  {
    AppMethodBeat.i(62572);
    Object localObject1;
    if ((this.MIm == null) || (TextUtils.isEmpty(this.MIm.name)))
    {
      localObject1 = new ArrayList(this.MIn.values());
      Object localObject2 = a.fXK();
      ((List)localObject1).remove(this.MIn.get(localObject2));
      localObject1 = ja((List)localObject1);
      b.i("tagorewang:TalkRoom", new Object[] { "getOtherMembers size: ", Integer.valueOf(((List)localObject1).size()), " all size: ", Integer.valueOf(this.MIn.size()) });
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
    if ((this.MIm != null) && (!TextUtils.isEmpty(this.MIm.name)))
    {
      localObject1 = this.MIm.name;
      AppMethodBeat.o(62572);
      return localObject1;
    }
    b.w("tagorewang:TalkRoom", new Object[] { "updateRoomNameIfEmpty still empty, groupId: ", this.wmz, " tmpId: ", this.MgG });
    AppMethodBeat.o(62572);
    return null;
  }
  
  private static List<d> ja(List<d> paramList)
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
    this.MIn.put(paramd.gdY(), paramd);
    AppMethodBeat.o(62574);
  }
  
  public final d bbB(String paramString)
  {
    AppMethodBeat.i(62578);
    paramString = (d)this.MIn.get(paramString);
    AppMethodBeat.o(62578);
    return paramString;
  }
  
  public final int gdK()
  {
    if (this.Mcu == 0) {
      return 0;
    }
    return this.Mcu;
  }
  
  public final List<d> gdN()
  {
    AppMethodBeat.i(62575);
    List localList = ja(new ArrayList(this.MIn.values()));
    d locald = gdP();
    localList.remove(locald);
    localList.add(0, locald);
    locald = (d)this.MIn.get(Integer.valueOf(90100));
    if (locald != null)
    {
      localList.remove(locald);
      localList.add(locald);
    }
    AppMethodBeat.o(62575);
    return localList;
  }
  
  public final List<d> gdO()
  {
    AppMethodBeat.i(62576);
    ArrayList localArrayList = new ArrayList(this.MIn.values());
    AppMethodBeat.o(62576);
    return localArrayList;
  }
  
  public final d gdP()
  {
    AppMethodBeat.i(62579);
    d locald = (d)this.MIn.get(a.fXK());
    AppMethodBeat.o(62579);
    return locald;
  }
  
  public final List<a.ay> gdQ()
  {
    AppMethodBeat.i(62580);
    List localList = gdR();
    AppMethodBeat.o(62580);
    return localList;
  }
  
  public final List<a.ay> gdR()
  {
    AppMethodBeat.i(62581);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.MIn.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((d)((Map.Entry)localIterator.next()).getValue()).MIu);
    }
    AppMethodBeat.o(62581);
    return localArrayList;
  }
  
  public final MultiTalkGroup gdS()
  {
    AppMethodBeat.i(62583);
    MultiTalkGroup localMultiTalkGroup = new MultiTalkGroup();
    localMultiTalkGroup.wmz = this.wmz;
    localMultiTalkGroup.MgG = this.MgG;
    localMultiTalkGroup.Mcu = this.Mcu;
    localMultiTalkGroup.wmA = this.wmA;
    localMultiTalkGroup.MgH = this.MgH;
    ArrayList localArrayList = new ArrayList();
    Object localObject = gdO();
    if (((List)localObject).size() > 0)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald != null)
        {
          MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
          localMultiTalkGroupMember.MgJ = locald.gdY();
          if (locald.MIu != null)
          {
            localObject = locald.MIu.MfZ;
            label148:
            localMultiTalkGroupMember.MgK = ((String)localObject);
            if (locald.MIu == null) {
              break label241;
            }
            i = locald.MIu.reason;
            label171:
            localMultiTalkGroupMember.reason = i;
            localMultiTalkGroupMember.status = locald.getState();
            if ((locald.MIu == null) || (locald.MIu.MfN == 0)) {
              break label246;
            }
          }
          label241:
          label246:
          for (int i = locald.MIu.MfN;; i = 0)
          {
            localMultiTalkGroupMember.MfN = i;
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
    localMultiTalkGroup.MgI = localArrayList;
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
        localStringBuilder1.append("groupId: ").append(this.wmz);
        localStringBuilder1.append(" tmpId: ").append(this.MgG);
        localStringBuilder1.append(" routeId: ").append(this.Mcu);
        StringBuilder localStringBuilder2 = localStringBuilder1.append(" room name: ");
        if ((this.MIm != null) && (!TextUtils.isEmpty(this.MIm.name))) {
          continue;
        }
        str = gdM();
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
      str = this.MIm.name;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.TalkRoom
 * JD-Core Version:    0.7.0.1
 */