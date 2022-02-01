package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.google.b.a.e;
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
  a.ay ZVd;
  Map<String, d> ZVe;
  
  public TalkRoom(String paramString, Integer paramInteger, a.ay paramay)
  {
    AppMethodBeat.i(208818);
    this.ZVe = new ConcurrentHashMap();
    e(paramString, paramInteger);
    b(paramay);
    AppMethodBeat.o(208818);
  }
  
  private static void Xc(long paramLong)
  {
    AppMethodBeat.i(62570);
    b.d("tagorewang:TalkRoom", new Object[] { "setRoomKey: ", Long.valueOf(paramLong) });
    AppMethodBeat.o(62570);
  }
  
  private static a.v a(a.ay paramay)
  {
    AppMethodBeat.i(208822);
    if (paramay != null) {}
    try
    {
      byte[] arrayOfByte = paramay.Zho;
      if (arrayOfByte == null)
      {
        AppMethodBeat.o(208822);
        return null;
      }
      paramay = paramay.Zho;
      paramay = (a.v)e.a(new a.v(), paramay, paramay.length);
      AppMethodBeat.o(208822);
      return paramay;
    }
    catch (Exception paramay)
    {
      b.w("tagorewang:TalkRoom", new Object[] { "toPlayItemInfo err: ", paramay });
      AppMethodBeat.o(208822);
    }
    return null;
  }
  
  public static TalkRoom a(TalkRoom paramTalkRoom, String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.ay paramay, a.ba[] paramArrayOfba, a.bb[] paramArrayOfbb)
  {
    AppMethodBeat.i(208817);
    if (paramTalkRoom == null)
    {
      b.w("tagorewang:TalkRoom:update", new Object[] { "updateAll null" });
      AppMethodBeat.o(208817);
      return null;
    }
    b.d("tagorewang:TalkRoom:update", new Object[] { "updateAll groupId: ", paramString1, " tmpId: ", paramString2 });
    paramTalkRoom.e(paramString1, paramInteger);
    paramTalkRoom.bEd(paramString2);
    setRoomId(paramInt);
    Xc(paramLong);
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
      AppMethodBeat.o(208817);
      return paramTalkRoom;
      paramInt = paramArrayOfba.length;
      break;
    }
    label147:
    paramString2 = new HashSet(paramTalkRoom.ZVe.keySet());
    paramString2.remove(a.ila());
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
        paramString1 = paramTalkRoom.bEe(paramInteger.fEC);
        if (paramString1 == null)
        {
          b.d("tagorewang:TalkRoom:update", new Object[] { "add new member" });
          paramString1 = new d(paramInteger);
          paramTalkRoom.a(paramString1);
        }
        for (;;)
        {
          paramString2.remove(paramString1.iuK());
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
      b.d("tagorewang:TalkRoom", new Object[] { "remove", paramTalkRoom.ZVe.remove(paramInteger) });
    }
    if (paramString2.size() > 0) {
      b.w("tagorewang:TalkRoom:update", new Object[] { "updateAll not update uuid keyset.size(): ", Integer.valueOf(paramString2.size()) });
    }
    b.d("tagorewang:TalkRoom:update", new Object[] { "did updateAll" });
    AppMethodBeat.o(208817);
    return paramTalkRoom;
  }
  
  public static TalkRoom a(String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.ay paramay, a.ba[] paramArrayOfba, a.bb[] paramArrayOfbb)
  {
    AppMethodBeat.i(208816);
    b.d("tagorewang:TalkRoom:create", new Object[] { "create groupId: ", paramString1, " tmpId: ", paramString2 });
    paramInteger = new TalkRoom(paramString1, paramInteger, paramay);
    paramInteger.bEd(paramString2);
    setRoomId(paramInt);
    Xc(paramLong);
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
        if ((paramString1 != null) && (paramString1.RCR == paramString2.RCR)) {
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
    AppMethodBeat.o(208816);
    return paramInteger;
  }
  
  private void b(a.ay paramay)
  {
    AppMethodBeat.i(208824);
    if (paramay == null)
    {
      AppMethodBeat.o(208824);
      return;
    }
    try
    {
      this.FmP = paramay.Zhv;
      this.ZiF = paramay.Zhu;
      a.v localv1;
      a.v localv2;
      if ((this.ZVd != null) && (paramay.fEi != 0))
      {
        localv1 = a(paramay);
        localv2 = a(this.ZVd);
        if (localv1 != null) {
          break label84;
        }
      }
      for (paramay.Zho = this.ZVd.Zho;; paramay.Zho = this.ZVd.Zho)
      {
        label84:
        do
        {
          this.ZVd = paramay;
          AppMethodBeat.o(208824);
          return;
        } while ((localv1.ZfV != 0) && (localv1.ZfV == localv2.ZfV));
        b.w("tagorewang:TalkRoom", new Object[] { "setRoomInfo bad id: ", Integer.valueOf(localv2.ZfV), " -> ", Integer.valueOf(localv1.ZfV) });
      }
      return;
    }
    catch (Exception localException)
    {
      b.w("tagorewang:TalkRoom", new Object[] { "setRoomInfo assert failed: ", localException });
      this.ZVd = paramay;
      AppMethodBeat.o(208824);
    }
  }
  
  private void bEd(String paramString)
  {
    AppMethodBeat.i(62565);
    if (i.bEt(paramString)) {
      this.ZiE = paramString;
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
    if (i.bEt(paramString)) {
      this.ZiE = paramString;
    }
    for (;;)
    {
      if (paramInteger != null) {
        this.Zel = paramInteger.intValue();
      }
      AppMethodBeat.o(62566);
      return;
      this.FmO = paramString;
    }
  }
  
  public static long gAo()
  {
    AppMethodBeat.i(62569);
    long l = i.ivj();
    AppMethodBeat.o(62569);
    return l;
  }
  
  public static boolean iuv()
  {
    return false;
  }
  
  public static int iux()
  {
    AppMethodBeat.i(62567);
    int i = i.ivi();
    AppMethodBeat.o(62567);
    return i;
  }
  
  private String iuy()
  {
    AppMethodBeat.i(62572);
    Object localObject1;
    if ((this.ZVd == null) || (TextUtils.isEmpty(this.ZVd.name)))
    {
      localObject1 = new ArrayList(this.ZVe.values());
      Object localObject2 = a.ila();
      ((List)localObject1).remove(this.ZVe.get(localObject2));
      localObject1 = lb((List)localObject1);
      b.i("tagorewang:TalkRoom", new Object[] { "getOtherMembers size: ", Integer.valueOf(((List)localObject1).size()), " all size: ", Integer.valueOf(this.ZVe.size()) });
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
    if ((this.ZVd != null) && (!TextUtils.isEmpty(this.ZVd.name)))
    {
      localObject1 = this.ZVd.name;
      AppMethodBeat.o(62572);
      return localObject1;
    }
    b.w("tagorewang:TalkRoom", new Object[] { "updateRoomNameIfEmpty still empty, groupId: ", this.FmO, " tmpId: ", this.ZiE });
    AppMethodBeat.o(62572);
    return null;
  }
  
  private static List<d> lb(List<d> paramList)
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
    this.ZVe.put(paramd.iuK(), paramd);
    AppMethodBeat.o(62574);
  }
  
  public final d bEe(String paramString)
  {
    AppMethodBeat.i(62578);
    paramString = (d)this.ZVe.get(paramString);
    AppMethodBeat.o(62578);
    return paramString;
  }
  
  public final List<d> iuA()
  {
    AppMethodBeat.i(62576);
    ArrayList localArrayList = new ArrayList(this.ZVe.values());
    AppMethodBeat.o(62576);
    return localArrayList;
  }
  
  public final d iuB()
  {
    AppMethodBeat.i(62579);
    d locald = (d)this.ZVe.get(a.ila());
    AppMethodBeat.o(62579);
    return locald;
  }
  
  public final List<a.ba> iuC()
  {
    AppMethodBeat.i(62580);
    List localList = iuD();
    AppMethodBeat.o(62580);
    return localList;
  }
  
  public final List<a.ba> iuD()
  {
    AppMethodBeat.i(62581);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ZVe.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((d)((Map.Entry)localIterator.next()).getValue()).ZVl);
    }
    AppMethodBeat.o(62581);
    return localArrayList;
  }
  
  public final MultiTalkGroup iuE()
  {
    AppMethodBeat.i(62583);
    MultiTalkGroup localMultiTalkGroup = new MultiTalkGroup();
    localMultiTalkGroup.FmO = this.FmO;
    localMultiTalkGroup.ZiE = this.ZiE;
    localMultiTalkGroup.Zel = this.Zel;
    localMultiTalkGroup.FmP = this.FmP;
    localMultiTalkGroup.ZiF = this.ZiF;
    ArrayList localArrayList = new ArrayList();
    Object localObject = iuA();
    if (((List)localObject).size() > 0)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald != null)
        {
          MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
          localMultiTalkGroupMember.ZiH = locald.iuK();
          if (locald.ZVl != null)
          {
            localObject = locald.ZVl.ZhX;
            label148:
            localMultiTalkGroupMember.ZiI = ((String)localObject);
            if (locald.ZVl == null) {
              break label241;
            }
            i = locald.ZVl.bnA;
            label171:
            localMultiTalkGroupMember.bnA = i;
            localMultiTalkGroupMember.status = locald.getState();
            if ((locald.ZVl == null) || (locald.ZVl.ZhL == 0)) {
              break label246;
            }
          }
          label241:
          label246:
          for (int i = locald.ZVl.ZhL;; i = 0)
          {
            localMultiTalkGroupMember.ZhL = i;
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
    localMultiTalkGroup.ZiG = localArrayList;
    AppMethodBeat.o(62583);
    return localMultiTalkGroup;
  }
  
  public final int iuw()
  {
    if (this.Zel == 0) {
      return 0;
    }
    return this.Zel;
  }
  
  public final List<d> iuz()
  {
    AppMethodBeat.i(62575);
    List localList = lb(new ArrayList(this.ZVe.values()));
    d locald = iuB();
    localList.remove(locald);
    localList.add(0, locald);
    locald = (d)this.ZVe.get(Integer.valueOf(90100));
    if (locald != null)
    {
      localList.remove(locald);
      localList.add(locald);
    }
    AppMethodBeat.o(62575);
    return localList;
  }
  
  public String toString()
  {
    AppMethodBeat.i(62582);
    localStringBuilder1 = new StringBuilder();
    for (;;)
    {
      try
      {
        localStringBuilder1.append("groupId: ").append(this.FmO);
        localStringBuilder1.append(" tmpId: ").append(this.ZiE);
        localStringBuilder1.append(" routeId: ").append(this.Zel);
        StringBuilder localStringBuilder2 = localStringBuilder1.append(" room name: ");
        if ((this.ZVd != null) && (!TextUtils.isEmpty(this.ZVd.name))) {
          continue;
        }
        str = iuy();
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
      str = this.ZVd.name;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.TalkRoom
 * JD-Core Version:    0.7.0.1
 */