package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.a.az;
import com.tencent.pb.common.b.a.a.a.bb;
import com.tencent.pb.common.b.a.a.a.bc;
import com.tencent.pb.common.b.a.a.a.v;
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
  a.az Suh;
  Map<String, d> Sui;
  
  public TalkRoom(String paramString, Integer paramInteger, a.az paramaz)
  {
    AppMethodBeat.i(199666);
    this.Sui = new ConcurrentHashMap();
    c(paramString, paramInteger);
    b(paramaz);
    AppMethodBeat.o(199666);
  }
  
  private static void OM(long paramLong)
  {
    AppMethodBeat.i(62570);
    b.d("tagorewang:TalkRoom", new Object[] { "setRoomKey: ", Long.valueOf(paramLong) });
    AppMethodBeat.o(62570);
  }
  
  private static a.v a(a.az paramaz)
  {
    AppMethodBeat.i(199667);
    if (paramaz != null) {}
    try
    {
      byte[] arrayOfByte = paramaz.RFJ;
      if (arrayOfByte == null)
      {
        AppMethodBeat.o(199667);
        return null;
      }
      paramaz = paramaz.RFJ;
      paramaz = (a.v)e.a(new a.v(), paramaz, paramaz.length);
      AppMethodBeat.o(199667);
      return paramaz;
    }
    catch (Exception paramaz)
    {
      b.w("tagorewang:TalkRoom", new Object[] { "toPlayItemInfo err: ", paramaz });
      AppMethodBeat.o(199667);
    }
    return null;
  }
  
  public static TalkRoom a(TalkRoom paramTalkRoom, String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.az paramaz, a.bb[] paramArrayOfbb, a.bc[] paramArrayOfbc)
  {
    AppMethodBeat.i(199665);
    if (paramTalkRoom == null)
    {
      b.w("tagorewang:TalkRoom:update", new Object[] { "updateAll null" });
      AppMethodBeat.o(199665);
      return null;
    }
    b.d("tagorewang:TalkRoom:update", new Object[] { "updateAll groupId: ", paramString1, " tmpId: ", paramString2 });
    paramTalkRoom.c(paramString1, paramInteger);
    paramTalkRoom.bre(paramString2);
    setRoomId(paramInt);
    OM(paramLong);
    paramTalkRoom.b(paramaz);
    if (paramArrayOfbb == null)
    {
      paramInt = 0;
      if (paramArrayOfbc != null) {
        break label139;
      }
    }
    label139:
    for (int i = 0;; i = paramArrayOfbc.length)
    {
      if ((paramInt != 0) || (i != 0)) {
        break label147;
      }
      b.w("tagorewang:TalkRoom:update", new Object[] { "updateAll null VoiceGroupMem or VoiceGroupUsrProfile array." });
      AppMethodBeat.o(199665);
      return paramTalkRoom;
      paramInt = paramArrayOfbb.length;
      break;
    }
    label147:
    paramString2 = new HashSet(paramTalkRoom.Sui.keySet());
    paramString2.remove(a.hjq());
    i = 0;
    while (i != paramInt)
    {
      paramInteger = paramArrayOfbb[i];
      if (paramInteger == null)
      {
        b.w("tagorewang:TalkRoom:update", new Object[] { "null member info, index: ", Integer.valueOf(i) });
        i += 1;
      }
      else
      {
        paramString1 = paramTalkRoom.brf(paramInteger.dLN);
        if (paramString1 == null)
        {
          b.d("tagorewang:TalkRoom:update", new Object[] { "add new member" });
          paramString1 = new d(paramInteger);
          paramTalkRoom.a(paramString1);
        }
        for (;;)
        {
          paramString2.remove(paramString1.hra());
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
      b.d("tagorewang:TalkRoom", new Object[] { "remove", paramTalkRoom.Sui.remove(paramInteger) });
    }
    if (paramString2.size() > 0) {
      b.w("tagorewang:TalkRoom:update", new Object[] { "updateAll not update uuid keyset.size(): ", Integer.valueOf(paramString2.size()) });
    }
    b.d("tagorewang:TalkRoom:update", new Object[] { "did updateAll" });
    AppMethodBeat.o(199665);
    return paramTalkRoom;
  }
  
  public static TalkRoom a(String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.az paramaz, a.bb[] paramArrayOfbb, a.bc[] paramArrayOfbc)
  {
    AppMethodBeat.i(199664);
    b.d("tagorewang:TalkRoom:create", new Object[] { "create groupId: ", paramString1, " tmpId: ", paramString2 });
    paramInteger = new TalkRoom(paramString1, paramInteger, paramaz);
    paramInteger.bre(paramString2);
    setRoomId(paramInt);
    OM(paramLong);
    if (paramArrayOfbb == null)
    {
      paramInt = 0;
      if (paramArrayOfbc != null) {
        break label130;
      }
    }
    label130:
    for (int i = 0;; i = paramArrayOfbc.length)
    {
      int j = 0;
      for (;;)
      {
        if (j == paramInt) {
          break label223;
        }
        paramString2 = paramArrayOfbb[j];
        if (paramString2 != null) {
          break;
        }
        b.w("tagorewang:TalkRoom:create", new Object[] { "null member info, index: ", Integer.valueOf(j) });
        j += 1;
      }
      paramInt = paramArrayOfbb.length;
      break;
    }
    int k = 0;
    for (;;)
    {
      paramString1 = null;
      if (k != i)
      {
        paramString1 = paramArrayOfbc[k];
        if ((paramString1 != null) && (paramString1.KBb == paramString2.KBb)) {
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
    AppMethodBeat.o(199664);
    return paramInteger;
  }
  
  private void b(a.az paramaz)
  {
    AppMethodBeat.i(199668);
    if (paramaz == null)
    {
      AppMethodBeat.o(199668);
      return;
    }
    try
    {
      this.zHE = paramaz.RFQ;
      this.RGZ = paramaz.RFP;
      a.v localv1;
      a.v localv2;
      if ((this.Suh != null) && (paramaz.dLt != 0))
      {
        localv1 = a(paramaz);
        localv2 = a(this.Suh);
        if (localv1 != null) {
          break label84;
        }
      }
      for (paramaz.RFJ = this.Suh.RFJ;; paramaz.RFJ = this.Suh.RFJ)
      {
        label84:
        do
        {
          this.Suh = paramaz;
          AppMethodBeat.o(199668);
          return;
        } while ((localv1.REo != 0) && (localv1.REo == localv2.REo));
        b.w("tagorewang:TalkRoom", new Object[] { "setRoomInfo bad id: ", Integer.valueOf(localv2.REo), " -> ", Integer.valueOf(localv1.REo) });
      }
      return;
    }
    catch (Exception localException)
    {
      b.w("tagorewang:TalkRoom", new Object[] { "setRoomInfo assert failed: ", localException });
      this.Suh = paramaz;
      AppMethodBeat.o(199668);
    }
  }
  
  private void bre(String paramString)
  {
    AppMethodBeat.i(62565);
    if (j.bru(paramString)) {
      this.RGY = paramString;
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
    if (j.bru(paramString)) {
      this.RGY = paramString;
    }
    for (;;)
    {
      if (paramInteger != null) {
        this.RCJ = paramInteger.intValue();
      }
      AppMethodBeat.o(62566);
      return;
      this.zHD = paramString;
    }
  }
  
  public static long fHV()
  {
    AppMethodBeat.i(62569);
    long l = j.hrB();
    AppMethodBeat.o(62569);
    return l;
  }
  
  public static boolean hqL()
  {
    return false;
  }
  
  public static int hqN()
  {
    AppMethodBeat.i(62567);
    int i = j.hrA();
    AppMethodBeat.o(62567);
    return i;
  }
  
  private String hqO()
  {
    AppMethodBeat.i(62572);
    Object localObject1;
    if ((this.Suh == null) || (TextUtils.isEmpty(this.Suh.name)))
    {
      localObject1 = new ArrayList(this.Sui.values());
      Object localObject2 = a.hjq();
      ((List)localObject1).remove(this.Sui.get(localObject2));
      localObject1 = kh((List)localObject1);
      b.i("tagorewang:TalkRoom", new Object[] { "getOtherMembers size: ", Integer.valueOf(((List)localObject1).size()), " all size: ", Integer.valueOf(this.Sui.size()) });
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
    if ((this.Suh != null) && (!TextUtils.isEmpty(this.Suh.name)))
    {
      localObject1 = this.Suh.name;
      AppMethodBeat.o(62572);
      return localObject1;
    }
    b.w("tagorewang:TalkRoom", new Object[] { "updateRoomNameIfEmpty still empty, groupId: ", this.zHD, " tmpId: ", this.RGY });
    AppMethodBeat.o(62572);
    return null;
  }
  
  private static List<d> kh(List<d> paramList)
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
    this.Sui.put(paramd.hra(), paramd);
    AppMethodBeat.o(62574);
  }
  
  public final d brf(String paramString)
  {
    AppMethodBeat.i(62578);
    paramString = (d)this.Sui.get(paramString);
    AppMethodBeat.o(62578);
    return paramString;
  }
  
  public final int hqM()
  {
    if (this.RCJ == 0) {
      return 0;
    }
    return this.RCJ;
  }
  
  public final List<d> hqP()
  {
    AppMethodBeat.i(62575);
    List localList = kh(new ArrayList(this.Sui.values()));
    d locald = hqR();
    localList.remove(locald);
    localList.add(0, locald);
    locald = (d)this.Sui.get(Integer.valueOf(90100));
    if (locald != null)
    {
      localList.remove(locald);
      localList.add(locald);
    }
    AppMethodBeat.o(62575);
    return localList;
  }
  
  public final List<d> hqQ()
  {
    AppMethodBeat.i(62576);
    ArrayList localArrayList = new ArrayList(this.Sui.values());
    AppMethodBeat.o(62576);
    return localArrayList;
  }
  
  public final d hqR()
  {
    AppMethodBeat.i(62579);
    d locald = (d)this.Sui.get(a.hjq());
    AppMethodBeat.o(62579);
    return locald;
  }
  
  public final List<a.bb> hqS()
  {
    AppMethodBeat.i(62580);
    List localList = hqT();
    AppMethodBeat.o(62580);
    return localList;
  }
  
  public final List<a.bb> hqT()
  {
    AppMethodBeat.i(62581);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Sui.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((d)((Map.Entry)localIterator.next()).getValue()).Sup);
    }
    AppMethodBeat.o(62581);
    return localArrayList;
  }
  
  public final MultiTalkGroup hqU()
  {
    AppMethodBeat.i(62583);
    MultiTalkGroup localMultiTalkGroup = new MultiTalkGroup();
    localMultiTalkGroup.zHD = this.zHD;
    localMultiTalkGroup.RGY = this.RGY;
    localMultiTalkGroup.RCJ = this.RCJ;
    localMultiTalkGroup.zHE = this.zHE;
    localMultiTalkGroup.RGZ = this.RGZ;
    ArrayList localArrayList = new ArrayList();
    Object localObject = hqQ();
    if (((List)localObject).size() > 0)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald != null)
        {
          MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
          localMultiTalkGroupMember.RHb = locald.hra();
          if (locald.Sup != null)
          {
            localObject = locald.Sup.RGr;
            label148:
            localMultiTalkGroupMember.RHc = ((String)localObject);
            if (locald.Sup == null) {
              break label241;
            }
            i = locald.Sup.bDZ;
            label171:
            localMultiTalkGroupMember.bDZ = i;
            localMultiTalkGroupMember.status = locald.getState();
            if ((locald.Sup == null) || (locald.Sup.RGf == 0)) {
              break label246;
            }
          }
          label241:
          label246:
          for (int i = locald.Sup.RGf;; i = 0)
          {
            localMultiTalkGroupMember.RGf = i;
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
    localMultiTalkGroup.RHa = localArrayList;
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
        localStringBuilder1.append("groupId: ").append(this.zHD);
        localStringBuilder1.append(" tmpId: ").append(this.RGY);
        localStringBuilder1.append(" routeId: ").append(this.RCJ);
        StringBuilder localStringBuilder2 = localStringBuilder1.append(" room name: ");
        if ((this.Suh != null) && (!TextUtils.isEmpty(this.Suh.name))) {
          continue;
        }
        str = hqO();
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
      str = this.Suh.name;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.TalkRoom
 * JD-Core Version:    0.7.0.1
 */