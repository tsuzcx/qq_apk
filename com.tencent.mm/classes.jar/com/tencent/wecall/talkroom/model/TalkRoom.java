package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.google.a.a.e;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.b.a.a.t;
import com.tencent.pb.common.c.c;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
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
  a.at xdp;
  Map<String, d> xdq = new ConcurrentHashMap();
  
  public TalkRoom(String paramString, Integer paramInteger, a.at paramat)
  {
    a(paramString, paramInteger);
    b(paramat);
  }
  
  private static void Kv(int paramInt)
  {
    c.d("tagorewang:TalkRoom", new Object[] { "setRoomId: ", Integer.valueOf(paramInt) });
  }
  
  private static a.t a(a.at paramat)
  {
    if (paramat != null) {
      try
      {
        if (paramat.wIv != null)
        {
          paramat = paramat.wIv;
          paramat = (a.t)e.a(new a.t(), paramat, paramat.length);
          return paramat;
        }
      }
      catch (Exception paramat)
      {
        c.x("tagorewang:TalkRoom", new Object[] { "toPlayItemInfo err: ", paramat });
        return null;
      }
    }
    return null;
  }
  
  public static TalkRoom a(TalkRoom paramTalkRoom, String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.at paramat, a.av[] paramArrayOfav, a.aw[] paramArrayOfaw)
  {
    if (paramTalkRoom == null)
    {
      c.x("tagorewang:TalkRoom:update", new Object[] { "updateAll null" });
      return null;
    }
    c.d("tagorewang:TalkRoom:update", new Object[] { "updateAll groupId: ", paramString1, " tmpId: ", paramString2 });
    paramTalkRoom.a(paramString1, paramInteger);
    paramTalkRoom.agu(paramString2);
    Kv(paramInt);
    ir(paramLong);
    paramTalkRoom.b(paramat);
    if (paramArrayOfav == null)
    {
      paramInt = 0;
      if (paramArrayOfaw != null) {
        break label124;
      }
    }
    label124:
    for (int i = 0;; i = paramArrayOfaw.length)
    {
      if ((paramInt != 0) || (i != 0)) {
        break label132;
      }
      c.x("tagorewang:TalkRoom:update", new Object[] { "updateAll null VoiceGroupMem or VoiceGroupUsrProfile array." });
      return paramTalkRoom;
      paramInt = paramArrayOfav.length;
      break;
    }
    label132:
    paramString2 = new HashSet(paramTalkRoom.xdq.keySet());
    paramString2.remove(a.cOl());
    i = 0;
    while (i != paramInt)
    {
      paramInteger = paramArrayOfav[i];
      if (paramInteger == null)
      {
        c.x("tagorewang:TalkRoom:update", new Object[] { "null member info, index: ", Integer.valueOf(i) });
        i += 1;
      }
      else
      {
        paramString1 = paramTalkRoom.agv(paramInteger.wHY);
        if (paramString1 == null)
        {
          c.d("tagorewang:TalkRoom:update", new Object[] { "add new member" });
          paramString1 = new d(paramInteger);
          paramTalkRoom.a(paramString1);
        }
        for (;;)
        {
          paramString2.remove(paramString1.cRE());
          break;
          paramString1.a(paramInteger);
        }
      }
    }
    paramString1 = paramString2.iterator();
    while (paramString1.hasNext())
    {
      paramInteger = (String)paramString1.next();
      c.d("tagorewang:TalkRoom:update", new Object[] { "keyset", paramInteger });
      c.d("tagorewang:TalkRoom", new Object[] { "remove", paramTalkRoom.xdq.remove(paramInteger) });
    }
    if (paramString2.size() > 0) {
      c.x("tagorewang:TalkRoom:update", new Object[] { "updateAll not update uuid keyset.size(): ", Integer.valueOf(paramString2.size()) });
    }
    c.d("tagorewang:TalkRoom:update", new Object[] { "did updateAll" });
    return paramTalkRoom;
  }
  
  public static TalkRoom a(String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.at paramat, a.av[] paramArrayOfav, a.aw[] paramArrayOfaw)
  {
    c.d("tagorewang:TalkRoom:create", new Object[] { "create groupId: ", paramString1, " tmpId: ", paramString2 });
    paramInteger = new TalkRoom(paramString1, paramInteger, paramat);
    paramInteger.agu(paramString2);
    Kv(paramInt);
    ir(paramLong);
    if (paramArrayOfav == null)
    {
      paramInt = 0;
      if (paramArrayOfaw != null) {
        break label125;
      }
    }
    label125:
    for (int i = 0;; i = paramArrayOfaw.length)
    {
      int j = 0;
      for (;;)
      {
        if (j == paramInt) {
          break label218;
        }
        paramString2 = paramArrayOfav[j];
        if (paramString2 != null) {
          break;
        }
        c.x("tagorewang:TalkRoom:create", new Object[] { "null member info, index: ", Integer.valueOf(j) });
        j += 1;
      }
      paramInt = paramArrayOfav.length;
      break;
    }
    int k = 0;
    for (;;)
    {
      paramString1 = null;
      if (k != i)
      {
        paramString1 = paramArrayOfaw[k];
        if ((paramString1 != null) && (paramString1.sqW == paramString2.sqW)) {
          c.d("tagorewang:TalkRoom:create", new Object[] { "member info: ", paramString2, " profile: ", paramString1 });
        }
      }
      else
      {
        paramInteger.a(new d(paramString2, paramString1));
        break;
      }
      k += 1;
    }
    label218:
    c.d("tagorewang:TalkRoom:create", new Object[] { "did create" });
    return paramInteger;
  }
  
  private void a(String paramString, Integer paramInteger)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if (j.agI(paramString)) {
        this.wJM = paramString;
      }
      while (paramInteger != null)
      {
        this.wFA = paramInteger.intValue();
        return;
        this.wJL = paramString;
      }
    }
  }
  
  private void agu(String paramString)
  {
    if (j.agI(paramString)) {
      this.wJM = paramString;
    }
  }
  
  private void b(a.at paramat)
  {
    if (paramat == null) {
      return;
    }
    for (;;)
    {
      a.t localt2;
      try
      {
        this.wJN = paramat.wIC;
        this.wJO = paramat.wIB;
        if ((this.xdp != null) && (paramat.bNM != 0))
        {
          a.t localt1 = a(paramat);
          localt2 = a(this.xdp);
          if (localt1 == null) {
            paramat.wIv = this.xdp.wIv;
          }
        }
        else
        {
          this.xdp = paramat;
          return;
        }
      }
      catch (Exception localException)
      {
        c.x("tagorewang:TalkRoom", new Object[] { "setRoomInfo assert failed: ", localException });
        this.xdp = paramat;
        return;
      }
      if ((localException.wHd == 0) || (localException.wHd != localt2.wHd))
      {
        c.x("tagorewang:TalkRoom", new Object[] { "setRoomInfo bad id: ", Integer.valueOf(localt2.wHd), " -> ", Integer.valueOf(localException.wHd) });
        paramat.wIv = this.xdp.wIv;
      }
    }
  }
  
  public static long bRe()
  {
    return j.cRZ();
  }
  
  public static boolean cRs()
  {
    return false;
  }
  
  public static int cRu()
  {
    return j.cRY();
  }
  
  private String cRv()
  {
    if ((this.xdp == null) || (TextUtils.isEmpty(this.xdp.name)))
    {
      Object localObject1 = new ArrayList(this.xdq.values());
      Object localObject2 = a.cOl();
      ((List)localObject1).remove(this.xdq.get(localObject2));
      localObject1 = eC((List)localObject1);
      c.w("tagorewang:TalkRoom", new Object[] { "getOtherMembers size: ", Integer.valueOf(((List)localObject1).size()), " all size: ", Integer.valueOf(this.xdq.size()) });
      localObject2 = new StringBuilder();
      if (localObject1 != null)
      {
        int j = ((List)localObject1).size();
        int i = 0;
        for (;;)
        {
          if (i == j) {
            break label207;
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
              c.x("tagorewang:TalkRoom", new Object[] { "updateRoomNameIfEmpty err and continue: ", localException });
            }
          }
          i += 1;
        }
      }
      label207:
      if (((StringBuilder)localObject2).toString().length() > 0) {
        return ((StringBuilder)localObject2).toString();
      }
    }
    if ((this.xdp != null) && (!TextUtils.isEmpty(this.xdp.name))) {
      return this.xdp.name;
    }
    c.x("tagorewang:TalkRoom", new Object[] { "updateRoomNameIfEmpty still empty, groupId: ", this.wJL, " tmpId: ", this.wJM });
    return null;
  }
  
  private static List<d> eC(List<d> paramList)
  {
    if (paramList.isEmpty()) {
      return paramList;
    }
    Collections.sort(paramList, new TalkRoom.a());
    return paramList;
  }
  
  private static void ir(long paramLong)
  {
    c.d("tagorewang:TalkRoom", new Object[] { "setRoomKey: ", Long.valueOf(paramLong) });
  }
  
  public final void a(d paramd)
  {
    this.xdq.put(paramd.cRE(), paramd);
  }
  
  public final d agv(String paramString)
  {
    return (d)this.xdq.get(paramString);
  }
  
  public final int cRt()
  {
    if (this.wFA == 0) {
      return 0;
    }
    return this.wFA;
  }
  
  public final List<d> cRw()
  {
    List localList = eC(new ArrayList(this.xdq.values()));
    d locald = cRy();
    localList.remove(locald);
    localList.add(0, locald);
    locald = (d)this.xdq.get(Integer.valueOf(90100));
    if (locald != null)
    {
      localList.remove(locald);
      localList.add(locald);
    }
    return localList;
  }
  
  public final List<d> cRx()
  {
    return new ArrayList(this.xdq.values());
  }
  
  public final d cRy()
  {
    return (d)this.xdq.get(a.cOl());
  }
  
  public final List<a.av> cRz()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.xdq.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((d)((Map.Entry)localIterator.next()).getValue()).xdx);
    }
    return localArrayList;
  }
  
  public String toString()
  {
    localStringBuilder1 = new StringBuilder();
    for (;;)
    {
      try
      {
        localStringBuilder1.append("groupId: ").append(this.wJL);
        localStringBuilder1.append(" tmpId: ").append(this.wJM);
        localStringBuilder1.append(" routeId: ").append(this.wFA);
        StringBuilder localStringBuilder2 = localStringBuilder1.append(" room name: ");
        if ((this.xdp != null) && (!TextUtils.isEmpty(this.xdp.name))) {
          continue;
        }
        str = cRv();
        localStringBuilder2.append(str);
      }
      catch (Exception localException)
      {
        String str;
        localStringBuilder1.append(" broken by " + localException.getMessage());
        continue;
      }
      return localStringBuilder1.toString();
      str = this.xdp.name;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.TalkRoom
 * JD-Core Version:    0.7.0.1
 */