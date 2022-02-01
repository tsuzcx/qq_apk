package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.a.aw;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.common.b.a.a.a.az;
import com.tencent.pb.common.c.b;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
{
  private static boolean DEBUG;
  public static boolean Kvt;
  private static final com.tencent.pb.common.c.d<c> Kvu;
  private Map<String, TalkRoom> Kvv;
  private Map<String, String> Kvw;
  g Kvx;
  
  static
  {
    AppMethodBeat.i(62716);
    Kvt = false;
    DEBUG = false;
    Kvu = new com.tencent.pb.common.c.d() {};
    AppMethodBeat.o(62716);
  }
  
  private c()
  {
    AppMethodBeat.i(62702);
    this.Kvv = new HashMap();
    this.Kvw = new HashMap();
    b.d("TalkRoomManager", new Object[] { "asyncLoadCache" });
    AppMethodBeat.o(62702);
  }
  
  public static boolean aUg(String paramString)
  {
    AppMethodBeat.i(62713);
    paramString = fIe().aUb(paramString);
    if (paramString == null)
    {
      b.w("TalkRoomManager", new Object[] { "isMySelfExit talkRoom is null" });
      AppMethodBeat.o(62713);
      return true;
    }
    paramString = paramString.fHX();
    if ((paramString == null) || (20 == paramString.getState()))
    {
      AppMethodBeat.o(62713);
      return true;
    }
    AppMethodBeat.o(62713);
    return false;
  }
  
  public static int aUh(String paramString)
  {
    AppMethodBeat.i(62714);
    Object localObject = fIe().aUb(paramString);
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getMySelfReason talkRoom is null groupId: ", paramString });
      AppMethodBeat.o(62714);
      return 0;
    }
    localObject = ((TalkRoom)localObject).fHX();
    if ((localObject != null) && (((d)localObject).Kvy != null)) {}
    for (int i = ((d)localObject).Kvy.reason;; i = 0)
    {
      b.w("TalkRoomManager", new Object[] { "getMySelfReason groupId: ", paramString, " reason: ", Integer.valueOf(i) });
      AppMethodBeat.o(62714);
      return i;
    }
  }
  
  public static c fIe()
  {
    AppMethodBeat.i(62701);
    c localc = (c)Kvu.get();
    AppMethodBeat.o(62701);
    return localc;
  }
  
  private static void fIf()
  {
    AppMethodBeat.i(62710);
    b.d("TalkRoomManager", new Object[] { "asyncWriteBackCache" });
    AppMethodBeat.o(62710);
  }
  
  public final boolean a(String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.aw paramaw, a.ay[] paramArrayOfay, a.az[] paramArrayOfaz, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192758);
    b.d("TalkRoomManager", new Object[] { "newOrUpdateGroup groupId: ", paramString1, " isActive: ", Boolean.valueOf(paramBoolean2) });
    if (TextUtils.isEmpty(paramString1)) {}
    for (String str1 = paramString2;; str1 = paramString1)
    {
      if (TextUtils.isEmpty(str1))
      {
        b.w("TalkRoomManager", new Object[] { "newOrUpdateGroup invalid groupId" });
        AppMethodBeat.o(192758);
        return false;
      }
      if (j.aUp(paramString2)) {
        this.Kvw.put(paramString2, str1);
      }
      paramString1 = (TalkRoom)this.Kvv.get(str1);
      if ((!TextUtils.isEmpty(paramString2)) && (paramString1 != null) && (paramaw != null) && (paramaw.dhE != 100))
      {
        b.w("TalkRoomManager", new Object[] { "newOrUpdateGroup clientGroupId is not empty , room is not null" });
        AppMethodBeat.o(192758);
        return false;
      }
      String str2 = paramString1;
      if (paramString1 == null)
      {
        if (j.aUp(paramString2)) {
          paramString1 = (TalkRoom)this.Kvv.get(paramString2);
        }
        str2 = paramString1;
        if (paramString1 != null)
        {
          this.Kvv.put(str1, paramString1);
          str2 = paramString1;
        }
      }
      if ((str2 != null) && (paramBoolean2))
      {
        int i = j.fIH();
        long l = j.fII();
        b.d("TalkRoomManager", new Object[] { "check current active group roomId: ", Integer.valueOf(i), " and roomKey: ", Long.valueOf(paramLong) });
        if ((i != 0) && (i != paramInt))
        {
          b.w("TalkRoomManager", new Object[] { "diff roomId: ", Integer.valueOf(i), " -> ", Integer.valueOf(paramInt) });
          AppMethodBeat.o(192758);
          return false;
        }
        if ((0L != l) && (l != paramLong))
        {
          b.w("TalkRoomManager", new Object[] { "diff roomKey: ", Long.valueOf(l), " -> ", Long.valueOf(paramLong) });
          AppMethodBeat.o(192758);
          return false;
        }
      }
      if (str2 == null)
      {
        b.d("TalkRoomManager", new Object[] { "newOrUpdateGroup create groupId: ", str1 });
        paramString1 = TalkRoom.a(str1, paramString2, paramInteger, paramInt, paramLong, paramaw, paramArrayOfay, paramArrayOfaz);
        this.Kvv.put(str1, paramString1);
      }
      for (;;)
      {
        if ((this.Kvx != null) && (paramBoolean1)) {
          this.Kvx.f(aUi(str1));
        }
        fIf();
        AppMethodBeat.o(192758);
        return true;
        b.d("TalkRoomManager", new Object[] { "newOrUpdateGroup update groupId: ", str1 });
        TalkRoom.a(str2, str1, paramString2, paramInteger, paramInt, paramLong, paramaw, paramArrayOfay, paramArrayOfaz);
      }
    }
  }
  
  public final TalkRoom aUb(String paramString)
  {
    AppMethodBeat.i(62704);
    TalkRoom localTalkRoom2 = (TalkRoom)this.Kvv.get(paramString);
    TalkRoom localTalkRoom1 = localTalkRoom2;
    if (localTalkRoom2 == null)
    {
      localTalkRoom1 = localTalkRoom2;
      if (j.aUp(paramString))
      {
        paramString = (String)this.Kvw.get(paramString);
        localTalkRoom1 = (TalkRoom)this.Kvv.get(paramString);
      }
    }
    AppMethodBeat.o(62704);
    return localTalkRoom1;
  }
  
  public final void aUc(String paramString)
  {
    AppMethodBeat.i(62705);
    try
    {
      paramString = aUb(paramString);
      if (paramString == null)
      {
        b.w("TalkRoomManager", new Object[] { "handleRoomExit assert failed: current TalkRoom MUST exists" });
        AppMethodBeat.o(62705);
        return;
      }
      d locald = paramString.aUa(a.fBV());
      if (locald != null)
      {
        locald.Kvy.status = 20;
        locald.Kvy.osF = -1;
      }
      if (paramString.JPR == null) {}
      for (paramString = "";; paramString = paramString.JPR)
      {
        b.d("tagorewang:TalkRoom", new Object[] { "resetRoomTempInfo groupId: ", paramString });
        fIf();
        AppMethodBeat.o(62705);
        return;
      }
      return;
    }
    catch (Throwable paramString)
    {
      b.w("TalkRoomManager", new Object[] { "handleRoomExit: ", paramString });
      AppMethodBeat.o(62705);
    }
  }
  
  public final int aUd(String paramString)
  {
    AppMethodBeat.i(62706);
    if (TextUtils.isEmpty(paramString))
    {
      b.w("TalkRoomManager", new Object[] { "getSelfMemberId invalid groupId" });
      AppMethodBeat.o(62706);
      return -1;
    }
    Object localObject = aUb(paramString);
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getSelfMemberId TalkRoom is null  groupId: ", paramString });
      AppMethodBeat.o(62706);
      return -1;
    }
    localObject = ((TalkRoom)localObject).aUa(a.fBV());
    if (localObject != null)
    {
      b.w("TalkRoomManager", new Object[] { "getSelfMemberId TalkRoomMember is not null groupId: ", paramString, " uuid: ", a.fBV(), " memberId: ", Integer.valueOf(((d)localObject).getMemberId()) });
      int i = ((d)localObject).getMemberId();
      AppMethodBeat.o(62706);
      return i;
    }
    b.w("TalkRoomManager", new Object[] { "getSelfMemberId TalkRoomMember is null" });
    AppMethodBeat.o(62706);
    return -1;
  }
  
  public final int aUe(String paramString)
  {
    AppMethodBeat.i(62707);
    if (TextUtils.isEmpty(paramString))
    {
      b.w("TalkRoomManager", new Object[] { "getRountIdByGrouId invalid groupId" });
      AppMethodBeat.o(62707);
      return 0;
    }
    TalkRoom localTalkRoom = aUb(paramString);
    if (localTalkRoom == null)
    {
      b.w("TalkRoomManager", new Object[] { "getRountIdByGrouId TalkRoom is null  groupId: ", paramString });
      AppMethodBeat.o(62707);
      return 0;
    }
    int i = localTalkRoom.fHS();
    AppMethodBeat.o(62707);
    return i;
  }
  
  public final int aUf(String paramString)
  {
    AppMethodBeat.i(62711);
    TalkRoom localTalkRoom = aUb(paramString);
    if (localTalkRoom == null)
    {
      AppMethodBeat.o(62711);
      return 0;
    }
    int i = localTalkRoom.Kvr.size();
    b.d("TalkRoomManager", new Object[] { "getGroupMemberSize groupid: ", paramString, " size: ", Integer.valueOf(i) });
    AppMethodBeat.o(62711);
    return i;
  }
  
  public final MultiTalkGroup aUi(String paramString)
  {
    AppMethodBeat.i(62715);
    paramString = aUb(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(62715);
      return null;
    }
    paramString = paramString.fIa();
    AppMethodBeat.o(62715);
    return paramString;
  }
  
  public final boolean d(String paramString1, String paramString2, String... paramVarArgs)
  {
    AppMethodBeat.i(62708);
    b.d("TalkRoomManager", new Object[] { "newTmpGroup groupId: ", paramString1 });
    if (!j.aUp(paramString1))
    {
      b.w("TalkRoomManager", new Object[] { "newTmpGroup invalid clientGroupId" });
      AppMethodBeat.o(62708);
      return false;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      b.w("TalkRoomManager", new Object[] { "newTmpGroup empty uuid array" });
      AppMethodBeat.o(62708);
      return false;
    }
    try
    {
      Object localObject = new a.aw();
      ((a.aw)localObject).dhE = 0;
      ((a.aw)localObject).JOI = paramString2;
      ((a.aw)localObject).JOH = a.fBV();
      paramString2 = new TalkRoom(paramString1, null, (a.aw)localObject);
      int j = paramVarArgs.length;
      int i = 0;
      while (i != j)
      {
        localObject = paramVarArgs[i];
        a.ay localay = new a.ay();
        localay.dhV = ((String)localObject);
        localay.JPj = a.fBV();
        localay.status = 20;
        localay.osF = -1;
        localay.JOX = ((int)(System.currentTimeMillis() / 1000L));
        paramString2.a(new d(localay, new a.az()));
        i += 1;
      }
      this.Kvv.put(paramString1, paramString2);
      fIf();
      AppMethodBeat.o(62708);
      return true;
    }
    catch (Exception paramString1)
    {
      b.w("TalkRoomManager", new Object[] { "newTmpGroup err: ", paramString1 });
      AppMethodBeat.o(62708);
    }
    return false;
  }
  
  public final boolean dd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(62703);
    if (TextUtils.isEmpty(paramString))
    {
      b.w("TalkRoomManager", new Object[] { "isGroupActiveExceptMySelf groupid is null" });
      AppMethodBeat.o(62703);
      return false;
    }
    paramString = aUb(paramString);
    if (paramString == null)
    {
      b.w("TalkRoomManager", new Object[] { "isGroupActiveExceptMySelf talkRoom is null" });
      AppMethodBeat.o(62703);
      return false;
    }
    paramString = paramString.fHV();
    if (paramString == null)
    {
      b.w("TalkRoomManager", new Object[] { "isGroupActiveExceptMySelf TalkRoomMember list is null" });
      AppMethodBeat.o(62703);
      return false;
    }
    paramString = paramString.iterator();
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (paramString.hasNext())
      {
        d locald = (d)paramString.next();
        if (locald != null)
        {
          locald.fIg();
          TalkRoom.fHR();
          if (locald.getState() != 10) {
            break label234;
          }
          if (locald.fIh()) {
            i = 1;
          }
        }
      }
    }
    label234:
    for (;;)
    {
      if ((paramBoolean) && (j != 0))
      {
        AppMethodBeat.o(62703);
        return true;
        j = 1;
      }
      else
      {
        if ((i != 0) && (j != 0))
        {
          b.w("TalkRoomManager", new Object[] { "isGroupActiveExceptMySelf is true" });
          AppMethodBeat.o(62703);
          return true;
        }
        break;
        AppMethodBeat.o(62703);
        return false;
      }
    }
  }
  
  public final String q(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(62712);
    if ((paramInt == 0) && (paramLong == 0L))
    {
      b.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId roomId and roomKey is 0,groupId: ", paramString });
      AppMethodBeat.o(62712);
      return null;
    }
    Object localObject = aUb(paramString);
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId talkRoom is null,groupId: ", paramString });
      AppMethodBeat.o(62712);
      return null;
    }
    localObject = ((TalkRoom)localObject).aUa(a.fBV());
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId talkRoomMember is null,groupId: ", paramString });
      AppMethodBeat.o(62712);
      return null;
    }
    localObject = ((d)localObject).Kvy;
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId voiceGroupMem is null,groupId: ", paramString });
      AppMethodBeat.o(62712);
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString);
    localStringBuffer.append(",");
    localStringBuffer.append(paramInt);
    localStringBuffer.append(",");
    localStringBuffer.append(paramLong);
    localStringBuffer.append(",");
    localStringBuffer.append(((a.ay)localObject).JOZ);
    b.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId msgKey is", localStringBuffer.toString() });
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(62712);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.c
 * JD-Core Version:    0.7.0.1
 */