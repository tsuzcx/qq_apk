package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.google.d.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.common.b.a.a.a.ba;
import com.tencent.pb.common.b.a.a.a.bb;
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
  a.ay ahZC;
  Map<String, d> ahZD;
  
  public TalkRoom(String paramString, Integer paramInteger, a.ay paramay)
  {
    AppMethodBeat.i(212297);
    this.ahZD = new ConcurrentHashMap();
    e(paramString, paramInteger);
    b(paramay);
    AppMethodBeat.o(212297);
  }
  
  private static a.v a(a.ay paramay)
  {
    AppMethodBeat.i(212302);
    if (paramay != null) {}
    try
    {
      byte[] arrayOfByte = paramay.ahfP;
      if (arrayOfByte == null)
      {
        AppMethodBeat.o(212302);
        return null;
      }
      paramay = paramay.ahfP;
      paramay = (a.v)e.a(new a.v(), paramay, paramay.length);
      AppMethodBeat.o(212302);
      return paramay;
    }
    catch (Exception paramay)
    {
      b.w("tagorewang:TalkRoom", new Object[] { "toPlayItemInfo err: ", paramay });
      AppMethodBeat.o(212302);
    }
    return null;
  }
  
  public static TalkRoom a(TalkRoom paramTalkRoom, String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.ay paramay, a.ba[] paramArrayOfba, a.bb[] paramArrayOfbb)
  {
    AppMethodBeat.i(212293);
    if (paramTalkRoom == null)
    {
      b.w("tagorewang:TalkRoom:update", new Object[] { "updateAll null" });
      AppMethodBeat.o(212293);
      return null;
    }
    b.d("tagorewang:TalkRoom:update", new Object[] { "updateAll groupId: ", paramString1, " tmpId: ", paramString2 });
    paramTalkRoom.e(paramString1, paramInteger);
    paramTalkRoom.bGC(paramString2);
    setRoomId(paramInt);
    sy(paramLong);
    paramTalkRoom.b(paramay);
    if (paramArrayOfba == null)
    {
      paramInt = 0;
      if (paramArrayOfbb != null) {
        break label139;
      }
    }
    label139:
    for (int i = 0;; i = paramArrayOfbb.length)
    {
      if ((paramInt != 0) || (i != 0)) {
        break label147;
      }
      b.w("tagorewang:TalkRoom:update", new Object[] { "updateAll null VoiceGroupMem or VoiceGroupUsrProfile array." });
      AppMethodBeat.o(212293);
      return paramTalkRoom;
      paramInt = paramArrayOfba.length;
      break;
    }
    label147:
    paramString2 = new HashSet(paramTalkRoom.ahZD.keySet());
    paramString2.remove(a.jRr());
    i = 0;
    while (i != paramInt)
    {
      paramInteger = paramArrayOfba[i];
      if (paramInteger == null)
      {
        b.w("tagorewang:TalkRoom:update", new Object[] { "null member info, index: ", Integer.valueOf(i) });
        i += 1;
      }
      else
      {
        paramString1 = paramTalkRoom.bGD(paramInteger.hJs);
        if (paramString1 == null)
        {
          b.d("tagorewang:TalkRoom:update", new Object[] { "add new member" });
          paramString1 = new d(paramInteger);
          paramTalkRoom.a(paramString1);
        }
        for (;;)
        {
          paramString2.remove(paramString1.kef());
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
      b.d("tagorewang:TalkRoom", new Object[] { "remove", paramTalkRoom.ahZD.remove(paramInteger) });
    }
    if (paramString2.size() > 0) {
      b.w("tagorewang:TalkRoom:update", new Object[] { "updateAll not update uuid keyset.size(): ", Integer.valueOf(paramString2.size()) });
    }
    b.d("tagorewang:TalkRoom:update", new Object[] { "did updateAll" });
    AppMethodBeat.o(212293);
    return paramTalkRoom;
  }
  
  public static TalkRoom a(String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.ay paramay, a.ba[] paramArrayOfba, a.bb[] paramArrayOfbb)
  {
    AppMethodBeat.i(212289);
    b.d("tagorewang:TalkRoom:create", new Object[] { "create groupId: ", paramString1, " tmpId: ", paramString2 });
    paramInteger = new TalkRoom(paramString1, paramInteger, paramay);
    paramInteger.bGC(paramString2);
    setRoomId(paramInt);
    sy(paramLong);
    if (paramArrayOfba == null)
    {
      paramInt = 0;
      if (paramArrayOfbb != null) {
        break label130;
      }
    }
    label130:
    for (int i = 0;; i = paramArrayOfbb.length)
    {
      int j = 0;
      for (;;)
      {
        if (j == paramInt) {
          break label223;
        }
        paramString2 = paramArrayOfba[j];
        if (paramString2 != null) {
          break;
        }
        b.w("tagorewang:TalkRoom:create", new Object[] { "null member info, index: ", Integer.valueOf(j) });
        j += 1;
      }
      paramInt = paramArrayOfba.length;
      break;
    }
    int k = 0;
    for (;;)
    {
      paramString1 = null;
      if (k != i)
      {
        paramString1 = paramArrayOfbb[k];
        if ((paramString1 != null) && (paramString1.Yzt == paramString2.Yzt)) {
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
    AppMethodBeat.o(212289);
    return paramInteger;
  }
  
  private void b(a.ay paramay)
  {
    AppMethodBeat.i(212305);
    if (paramay == null)
    {
      AppMethodBeat.o(212305);
      return;
    }
    try
    {
      this.LiV = paramay.ahfW;
      this.ahhg = paramay.ahfV;
      a.v localv1;
      a.v localv2;
      if ((this.ahZC != null) && (paramay.hIY != 0))
      {
        localv1 = a(paramay);
        localv2 = a(this.ahZC);
        if (localv1 != null) {
          break label84;
        }
      }
      for (paramay.ahfP = this.ahZC.ahfP;; paramay.ahfP = this.ahZC.ahfP)
      {
        label84:
        do
        {
          this.ahZC = paramay;
          AppMethodBeat.o(212305);
          return;
        } while ((localv1.ahex != 0) && (localv1.ahex == localv2.ahex));
        b.w("tagorewang:TalkRoom", new Object[] { "setRoomInfo bad id: ", Integer.valueOf(localv2.ahex), " -> ", Integer.valueOf(localv1.ahex) });
      }
      return;
    }
    catch (Exception localException)
    {
      b.w("tagorewang:TalkRoom", new Object[] { "setRoomInfo assert failed: ", localException });
      this.ahZC = paramay;
      AppMethodBeat.o(212305);
    }
  }
  
  private void bGC(String paramString)
  {
    AppMethodBeat.i(62565);
    if (i.bGS(paramString)) {
      this.ahhf = paramString;
    }
    AppMethodBeat.o(62565);
  }
  
  private void e(String paramString, Integer paramInteger)
  {
    AppMethodBeat.i(62566);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62566);
      return;
    }
    if (i.bGS(paramString)) {
      this.ahhf = paramString;
    }
    for (;;)
    {
      if (paramInteger != null) {
        this.ahcO = paramInteger.intValue();
      }
      AppMethodBeat.o(62566);
      return;
      this.LiU = paramString;
    }
  }
  
  public static long hVw()
  {
    AppMethodBeat.i(62569);
    long l = i.keF();
    AppMethodBeat.o(62569);
    return l;
  }
  
  public static boolean kdR()
  {
    return false;
  }
  
  public static int kdT()
  {
    AppMethodBeat.i(62567);
    int i = i.keE();
    AppMethodBeat.o(62567);
    return i;
  }
  
  private String kdU()
  {
    AppMethodBeat.i(62572);
    Object localObject1;
    if ((this.ahZC == null) || (TextUtils.isEmpty(this.ahZC.name)))
    {
      localObject1 = new ArrayList(this.ahZD.values());
      Object localObject2 = a.jRr();
      ((List)localObject1).remove(this.ahZD.get(localObject2));
      localObject1 = oy((List)localObject1);
      b.i("tagorewang:TalkRoom", new Object[] { "getOtherMembers size: ", Integer.valueOf(((List)localObject1).size()), " all size: ", Integer.valueOf(this.ahZD.size()) });
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
    if ((this.ahZC != null) && (!TextUtils.isEmpty(this.ahZC.name)))
    {
      localObject1 = this.ahZC.name;
      AppMethodBeat.o(62572);
      return localObject1;
    }
    b.w("tagorewang:TalkRoom", new Object[] { "updateRoomNameIfEmpty still empty, groupId: ", this.LiU, " tmpId: ", this.ahhf });
    AppMethodBeat.o(62572);
    return null;
  }
  
  private static List<d> oy(List<d> paramList)
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
  
  private static void sy(long paramLong)
  {
    AppMethodBeat.i(62570);
    b.d("tagorewang:TalkRoom", new Object[] { "setRoomKey: ", Long.valueOf(paramLong) });
    AppMethodBeat.o(62570);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(62574);
    this.ahZD.put(paramd.kef(), paramd);
    AppMethodBeat.o(62574);
  }
  
  public final d bGD(String paramString)
  {
    AppMethodBeat.i(62578);
    paramString = (d)this.ahZD.get(paramString);
    AppMethodBeat.o(62578);
    return paramString;
  }
  
  public final int kdS()
  {
    if (this.ahcO == 0) {
      return 0;
    }
    return this.ahcO;
  }
  
  public final List<d> kdV()
  {
    AppMethodBeat.i(62575);
    List localList = oy(new ArrayList(this.ahZD.values()));
    d locald = kdX();
    localList.remove(locald);
    localList.add(0, locald);
    locald = (d)this.ahZD.get(Integer.valueOf(90100));
    if (locald != null)
    {
      localList.remove(locald);
      localList.add(locald);
    }
    AppMethodBeat.o(62575);
    return localList;
  }
  
  public final List<d> kdW()
  {
    AppMethodBeat.i(62576);
    ArrayList localArrayList = new ArrayList(this.ahZD.values());
    AppMethodBeat.o(62576);
    return localArrayList;
  }
  
  public final d kdX()
  {
    AppMethodBeat.i(62579);
    d locald = (d)this.ahZD.get(a.jRr());
    AppMethodBeat.o(62579);
    return locald;
  }
  
  public final List<a.ba> kdY()
  {
    AppMethodBeat.i(62581);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ahZD.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((d)((Map.Entry)localIterator.next()).getValue()).ahZK);
    }
    AppMethodBeat.o(62581);
    return localArrayList;
  }
  
  public final MultiTalkGroup kdZ()
  {
    AppMethodBeat.i(62583);
    MultiTalkGroup localMultiTalkGroup = new MultiTalkGroup();
    localMultiTalkGroup.LiU = this.LiU;
    localMultiTalkGroup.ahhf = this.ahhf;
    localMultiTalkGroup.ahcO = this.ahcO;
    localMultiTalkGroup.LiV = this.LiV;
    localMultiTalkGroup.ahhg = this.ahhg;
    ArrayList localArrayList = new ArrayList();
    Object localObject = kdW();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald != null)
        {
          MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
          localMultiTalkGroupMember.ahhi = locald.kef();
          if (locald.ahZK != null)
          {
            localObject = locald.ahZK.ahgy;
            label152:
            localMultiTalkGroupMember.ahhj = ((String)localObject);
            if (locald.ahZK == null) {
              break label245;
            }
            i = locald.ahZK.reason;
            label175:
            localMultiTalkGroupMember.reason = i;
            localMultiTalkGroupMember.status = locald.getState();
            if ((locald.ahZK == null) || (locald.ahZK.ahgm == 0)) {
              break label250;
            }
          }
          label245:
          label250:
          for (int i = locald.ahZK.ahgm;; i = 0)
          {
            localMultiTalkGroupMember.ahgm = i;
            localArrayList.add(localMultiTalkGroupMember);
            break;
            localObject = "";
            break label152;
            i = 0;
            break label175;
          }
        }
      }
    }
    localMultiTalkGroup.ahhh = localArrayList;
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
        localStringBuilder1.append("groupId: ").append(this.LiU);
        localStringBuilder1.append(" tmpId: ").append(this.ahhf);
        localStringBuilder1.append(" routeId: ").append(this.ahcO);
        StringBuilder localStringBuilder2 = localStringBuilder1.append(" room name: ");
        if ((this.ahZC != null) && (!TextUtils.isEmpty(this.ahZC.name))) {
          continue;
        }
        str = kdU();
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
      str = this.ahZC.name;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.TalkRoom
 * JD-Core Version:    0.7.0.1
 */