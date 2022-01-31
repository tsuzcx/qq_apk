package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.b.a.a.t;
import com.tencent.pb.common.c.c;
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
  a.at BzX;
  Map<String, d> BzY;
  
  public TalkRoom(String paramString, Integer paramInteger, a.at paramat)
  {
    AppMethodBeat.i(127769);
    this.BzY = new ConcurrentHashMap();
    b(paramString, paramInteger);
    b(paramat);
    AppMethodBeat.o(127769);
  }
  
  private static void To(int paramInt)
  {
    AppMethodBeat.i(127773);
    c.d("tagorewang:TalkRoom", new Object[] { "setRoomId: ", Integer.valueOf(paramInt) });
    AppMethodBeat.o(127773);
  }
  
  private static a.t a(a.at paramat)
  {
    AppMethodBeat.i(127776);
    if (paramat != null) {}
    try
    {
      byte[] arrayOfByte = paramat.BfV;
      if (arrayOfByte == null)
      {
        AppMethodBeat.o(127776);
        return null;
      }
      paramat = paramat.BfV;
      paramat = (a.t)e.a(new a.t(), paramat, paramat.length);
      AppMethodBeat.o(127776);
      return paramat;
    }
    catch (Exception paramat)
    {
      c.w("tagorewang:TalkRoom", new Object[] { "toPlayItemInfo err: ", paramat });
      AppMethodBeat.o(127776);
    }
    return null;
  }
  
  public static TalkRoom a(TalkRoom paramTalkRoom, String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.at paramat, a.av[] paramArrayOfav, a.aw[] paramArrayOfaw)
  {
    AppMethodBeat.i(127768);
    if (paramTalkRoom == null)
    {
      c.w("tagorewang:TalkRoom:update", new Object[] { "updateAll null" });
      AppMethodBeat.o(127768);
      return null;
    }
    c.d("tagorewang:TalkRoom:update", new Object[] { "updateAll groupId: ", paramString1, " tmpId: ", paramString2 });
    paramTalkRoom.b(paramString1, paramInteger);
    paramTalkRoom.axn(paramString2);
    To(paramInt);
    pd(paramLong);
    paramTalkRoom.b(paramat);
    if (paramArrayOfav == null)
    {
      paramInt = 0;
      if (paramArrayOfaw != null) {
        break label139;
      }
    }
    label139:
    for (int i = 0;; i = paramArrayOfaw.length)
    {
      if ((paramInt != 0) || (i != 0)) {
        break label147;
      }
      c.w("tagorewang:TalkRoom:update", new Object[] { "updateAll null VoiceGroupMem or VoiceGroupUsrProfile array." });
      AppMethodBeat.o(127768);
      return paramTalkRoom;
      paramInt = paramArrayOfav.length;
      break;
    }
    label147:
    paramString2 = new HashSet(paramTalkRoom.BzY.keySet());
    paramString2.remove(a.dTX());
    i = 0;
    while (i != paramInt)
    {
      paramInteger = paramArrayOfav[i];
      if (paramInteger == null)
      {
        c.w("tagorewang:TalkRoom:update", new Object[] { "null member info, index: ", Integer.valueOf(i) });
        i += 1;
      }
      else
      {
        paramString1 = paramTalkRoom.axo(paramInteger.Bfy);
        if (paramString1 == null)
        {
          c.d("tagorewang:TalkRoom:update", new Object[] { "add new member" });
          paramString1 = new d(paramInteger);
          paramTalkRoom.a(paramString1);
        }
        for (;;)
        {
          paramString2.remove(paramString1.dXx());
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
      c.d("tagorewang:TalkRoom", new Object[] { "remove", paramTalkRoom.BzY.remove(paramInteger) });
    }
    if (paramString2.size() > 0) {
      c.w("tagorewang:TalkRoom:update", new Object[] { "updateAll not update uuid keyset.size(): ", Integer.valueOf(paramString2.size()) });
    }
    c.d("tagorewang:TalkRoom:update", new Object[] { "did updateAll" });
    AppMethodBeat.o(127768);
    return paramTalkRoom;
  }
  
  public static TalkRoom a(String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.at paramat, a.av[] paramArrayOfav, a.aw[] paramArrayOfaw)
  {
    AppMethodBeat.i(127767);
    c.d("tagorewang:TalkRoom:create", new Object[] { "create groupId: ", paramString1, " tmpId: ", paramString2 });
    paramInteger = new TalkRoom(paramString1, paramInteger, paramat);
    paramInteger.axn(paramString2);
    To(paramInt);
    pd(paramLong);
    if (paramArrayOfav == null)
    {
      paramInt = 0;
      if (paramArrayOfaw != null) {
        break label130;
      }
    }
    label130:
    for (int i = 0;; i = paramArrayOfaw.length)
    {
      int j = 0;
      for (;;)
      {
        if (j == paramInt) {
          break label223;
        }
        paramString2 = paramArrayOfav[j];
        if (paramString2 != null) {
          break;
        }
        c.w("tagorewang:TalkRoom:create", new Object[] { "null member info, index: ", Integer.valueOf(j) });
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
        if ((paramString1 != null) && (paramString1.wjE == paramString2.wjE)) {
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
    label223:
    c.d("tagorewang:TalkRoom:create", new Object[] { "did create" });
    AppMethodBeat.o(127767);
    return paramInteger;
  }
  
  private void axn(String paramString)
  {
    AppMethodBeat.i(127770);
    if (j.axD(paramString)) {
      this.Bhm = paramString;
    }
    AppMethodBeat.o(127770);
  }
  
  private void b(a.at paramat)
  {
    AppMethodBeat.i(127778);
    if (paramat == null)
    {
      AppMethodBeat.o(127778);
      return;
    }
    try
    {
      this.Bhn = paramat.Bgc;
      this.Bho = paramat.Bgb;
      a.t localt1;
      a.t localt2;
      if ((this.BzX != null) && (paramat.cve != 0))
      {
        localt1 = a(paramat);
        localt2 = a(this.BzX);
        if (localt1 != null) {
          break label84;
        }
      }
      for (paramat.BfV = this.BzX.BfV;; paramat.BfV = this.BzX.BfV)
      {
        label84:
        do
        {
          this.BzX = paramat;
          AppMethodBeat.o(127778);
          return;
        } while ((localt1.BeD != 0) && (localt1.BeD == localt2.BeD));
        c.w("tagorewang:TalkRoom", new Object[] { "setRoomInfo bad id: ", Integer.valueOf(localt2.BeD), " -> ", Integer.valueOf(localt1.BeD) });
      }
      return;
    }
    catch (Exception localException)
    {
      c.w("tagorewang:TalkRoom", new Object[] { "setRoomInfo assert failed: ", localException });
      this.BzX = paramat;
      AppMethodBeat.o(127778);
    }
  }
  
  private void b(String paramString, Integer paramInteger)
  {
    AppMethodBeat.i(127771);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(127771);
      return;
    }
    if (j.axD(paramString)) {
      this.Bhm = paramString;
    }
    for (;;)
    {
      if (paramInteger != null) {
        this.Bda = paramInteger.intValue();
      }
      AppMethodBeat.o(127771);
      return;
      this.Bhl = paramString;
    }
  }
  
  public static long cNV()
  {
    AppMethodBeat.i(127774);
    long l = j.dXW();
    AppMethodBeat.o(127774);
    return l;
  }
  
  public static boolean dXi()
  {
    return false;
  }
  
  public static int dXk()
  {
    AppMethodBeat.i(127772);
    int i = j.dXV();
    AppMethodBeat.o(127772);
    return i;
  }
  
  private String dXl()
  {
    AppMethodBeat.i(127777);
    Object localObject1;
    if ((this.BzX == null) || (TextUtils.isEmpty(this.BzX.name)))
    {
      localObject1 = new ArrayList(this.BzY.values());
      Object localObject2 = a.dTX();
      ((List)localObject1).remove(this.BzY.get(localObject2));
      localObject1 = fL((List)localObject1);
      c.i("tagorewang:TalkRoom", new Object[] { "getOtherMembers size: ", Integer.valueOf(((List)localObject1).size()), " all size: ", Integer.valueOf(this.BzY.size()) });
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
              c.w("tagorewang:TalkRoom", new Object[] { "updateRoomNameIfEmpty err and continue: ", localException });
            }
          }
          i += 1;
        }
      }
      label213:
      if (((StringBuilder)localObject2).toString().length() > 0)
      {
        localObject1 = ((StringBuilder)localObject2).toString();
        AppMethodBeat.o(127777);
        return localObject1;
      }
    }
    if ((this.BzX != null) && (!TextUtils.isEmpty(this.BzX.name)))
    {
      localObject1 = this.BzX.name;
      AppMethodBeat.o(127777);
      return localObject1;
    }
    c.w("tagorewang:TalkRoom", new Object[] { "updateRoomNameIfEmpty still empty, groupId: ", this.Bhl, " tmpId: ", this.Bhm });
    AppMethodBeat.o(127777);
    return null;
  }
  
  private static List<d> fL(List<d> paramList)
  {
    AppMethodBeat.i(127782);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(127782);
      return paramList;
    }
    Collections.sort(paramList, new TalkRoom.a());
    AppMethodBeat.o(127782);
    return paramList;
  }
  
  private static void pd(long paramLong)
  {
    AppMethodBeat.i(127775);
    c.d("tagorewang:TalkRoom", new Object[] { "setRoomKey: ", Long.valueOf(paramLong) });
    AppMethodBeat.o(127775);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(127779);
    this.BzY.put(paramd.dXx(), paramd);
    AppMethodBeat.o(127779);
  }
  
  public final d axo(String paramString)
  {
    AppMethodBeat.i(127783);
    paramString = (d)this.BzY.get(paramString);
    AppMethodBeat.o(127783);
    return paramString;
  }
  
  public final int dXj()
  {
    if (this.Bda == 0) {
      return 0;
    }
    return this.Bda;
  }
  
  public final List<d> dXm()
  {
    AppMethodBeat.i(127780);
    List localList = fL(new ArrayList(this.BzY.values()));
    d locald = dXo();
    localList.remove(locald);
    localList.add(0, locald);
    locald = (d)this.BzY.get(Integer.valueOf(90100));
    if (locald != null)
    {
      localList.remove(locald);
      localList.add(locald);
    }
    AppMethodBeat.o(127780);
    return localList;
  }
  
  public final List<d> dXn()
  {
    AppMethodBeat.i(127781);
    ArrayList localArrayList = new ArrayList(this.BzY.values());
    AppMethodBeat.o(127781);
    return localArrayList;
  }
  
  public final d dXo()
  {
    AppMethodBeat.i(127784);
    d locald = (d)this.BzY.get(a.dTX());
    AppMethodBeat.o(127784);
    return locald;
  }
  
  public final List<a.av> dXp()
  {
    AppMethodBeat.i(127785);
    List localList = dXq();
    AppMethodBeat.o(127785);
    return localList;
  }
  
  public final List<a.av> dXq()
  {
    AppMethodBeat.i(127786);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.BzY.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((d)((Map.Entry)localIterator.next()).getValue()).BAf);
    }
    AppMethodBeat.o(127786);
    return localArrayList;
  }
  
  public final MultiTalkGroup dXr()
  {
    AppMethodBeat.i(127788);
    MultiTalkGroup localMultiTalkGroup = new MultiTalkGroup();
    localMultiTalkGroup.Bhl = this.Bhl;
    localMultiTalkGroup.Bhm = this.Bhm;
    localMultiTalkGroup.Bda = this.Bda;
    localMultiTalkGroup.Bhn = this.Bhn;
    localMultiTalkGroup.Bho = this.Bho;
    ArrayList localArrayList = new ArrayList();
    Object localObject = dXn();
    if (((List)localObject).size() > 0)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald != null)
        {
          MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
          localMultiTalkGroupMember.Bhq = locald.dXx();
          if (locald.BAf != null)
          {
            localObject = locald.BAf.BgD;
            label148:
            localMultiTalkGroupMember.Bhr = ((String)localObject);
            if (locald.BAf == null) {
              break label241;
            }
            i = locald.BAf.aXG;
            label171:
            localMultiTalkGroupMember.aXG = i;
            localMultiTalkGroupMember.status = locald.getState();
            if ((locald.BAf == null) || (locald.BAf.Bgr == 0)) {
              break label246;
            }
          }
          label241:
          label246:
          for (int i = locald.BAf.Bgr;; i = 0)
          {
            localMultiTalkGroupMember.Bgr = i;
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
    localMultiTalkGroup.Bhp = localArrayList;
    AppMethodBeat.o(127788);
    return localMultiTalkGroup;
  }
  
  public String toString()
  {
    AppMethodBeat.i(127787);
    localStringBuilder1 = new StringBuilder();
    for (;;)
    {
      try
      {
        localStringBuilder1.append("groupId: ").append(this.Bhl);
        localStringBuilder1.append(" tmpId: ").append(this.Bhm);
        localStringBuilder1.append(" routeId: ").append(this.Bda);
        StringBuilder localStringBuilder2 = localStringBuilder1.append(" room name: ");
        if ((this.BzX != null) && (!TextUtils.isEmpty(this.BzX.name))) {
          continue;
        }
        str = dXl();
        localStringBuilder2.append(str);
      }
      catch (Exception localException)
      {
        String str;
        localStringBuilder1.append(" broken by " + localException.getMessage());
        continue;
      }
      str = localStringBuilder1.toString();
      AppMethodBeat.o(127787);
      return str;
      str = this.BzX.name;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.TalkRoom
 * JD-Core Version:    0.7.0.1
 */