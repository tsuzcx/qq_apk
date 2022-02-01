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
  public static boolean MIp;
  private static final com.tencent.pb.common.c.d<c> MIq;
  private Map<String, TalkRoom> MIr;
  private Map<String, String> MIs;
  g MIt;
  
  static
  {
    AppMethodBeat.i(62716);
    MIp = false;
    DEBUG = false;
    MIq = new com.tencent.pb.common.c.d() {};
    AppMethodBeat.o(62716);
  }
  
  private c()
  {
    AppMethodBeat.i(62702);
    this.MIr = new HashMap();
    this.MIs = new HashMap();
    b.d("TalkRoomManager", new Object[] { "asyncLoadCache" });
    AppMethodBeat.o(62702);
  }
  
  public static boolean bbH(String paramString)
  {
    AppMethodBeat.i(62713);
    paramString = gdW().bbC(paramString);
    if (paramString == null)
    {
      b.w("TalkRoomManager", new Object[] { "isMySelfExit talkRoom is null" });
      AppMethodBeat.o(62713);
      return true;
    }
    paramString = paramString.gdP();
    if ((paramString == null) || (20 == paramString.getState()))
    {
      AppMethodBeat.o(62713);
      return true;
    }
    AppMethodBeat.o(62713);
    return false;
  }
  
  public static int bbI(String paramString)
  {
    AppMethodBeat.i(62714);
    Object localObject = gdW().bbC(paramString);
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getMySelfReason talkRoom is null groupId: ", paramString });
      AppMethodBeat.o(62714);
      return 0;
    }
    localObject = ((TalkRoom)localObject).gdP();
    if ((localObject != null) && (((d)localObject).MIu != null)) {}
    for (int i = ((d)localObject).MIu.reason;; i = 0)
    {
      b.w("TalkRoomManager", new Object[] { "getMySelfReason groupId: ", paramString, " reason: ", Integer.valueOf(i) });
      AppMethodBeat.o(62714);
      return i;
    }
  }
  
  public static c gdW()
  {
    AppMethodBeat.i(62701);
    c localc = (c)MIq.get();
    AppMethodBeat.o(62701);
    return localc;
  }
  
  private static void gdX()
  {
    AppMethodBeat.i(62710);
    b.d("TalkRoomManager", new Object[] { "asyncWriteBackCache" });
    AppMethodBeat.o(62710);
  }
  
  public final String M(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(62712);
    if ((paramInt == 0) && (paramLong == 0L))
    {
      b.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId roomId and roomKey is 0,groupId: ", paramString });
      AppMethodBeat.o(62712);
      return null;
    }
    Object localObject = bbC(paramString);
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId talkRoom is null,groupId: ", paramString });
      AppMethodBeat.o(62712);
      return null;
    }
    localObject = ((TalkRoom)localObject).bbB(a.fXK());
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId talkRoomMember is null,groupId: ", paramString });
      AppMethodBeat.o(62712);
      return null;
    }
    localObject = ((d)localObject).MIu;
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
    localStringBuffer.append(((a.ay)localObject).MfP);
    b.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId msgKey is", localStringBuffer.toString() });
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(62712);
    return paramString;
  }
  
  public final boolean a(String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.aw paramaw, a.ay[] paramArrayOfay, a.az[] paramArrayOfaz, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(208335);
    b.d("TalkRoomManager", new Object[] { "newOrUpdateGroup groupId: ", paramString1, " isActive: ", Boolean.valueOf(paramBoolean2) });
    if (TextUtils.isEmpty(paramString1)) {}
    for (String str1 = paramString2;; str1 = paramString1)
    {
      if (TextUtils.isEmpty(str1))
      {
        b.w("TalkRoomManager", new Object[] { "newOrUpdateGroup invalid groupId" });
        AppMethodBeat.o(208335);
        return false;
      }
      if (j.bbQ(paramString2)) {
        this.MIs.put(paramString2, str1);
      }
      paramString1 = (TalkRoom)this.MIr.get(str1);
      if ((!TextUtils.isEmpty(paramString2)) && (paramString1 != null) && (paramaw != null) && (paramaw.dui != 100))
      {
        b.w("TalkRoomManager", new Object[] { "newOrUpdateGroup clientGroupId is not empty , room is not null" });
        AppMethodBeat.o(208335);
        return false;
      }
      String str2 = paramString1;
      if (paramString1 == null)
      {
        if (j.bbQ(paramString2)) {
          paramString1 = (TalkRoom)this.MIr.get(paramString2);
        }
        str2 = paramString1;
        if (paramString1 != null)
        {
          this.MIr.put(str1, paramString1);
          str2 = paramString1;
        }
      }
      if ((str2 != null) && (paramBoolean2))
      {
        int i = j.geA();
        long l = j.geB();
        b.d("TalkRoomManager", new Object[] { "check current active group roomId: ", Integer.valueOf(i), " and roomKey: ", Long.valueOf(paramLong) });
        if ((i != 0) && (i != paramInt))
        {
          b.w("TalkRoomManager", new Object[] { "diff roomId: ", Integer.valueOf(i), " -> ", Integer.valueOf(paramInt) });
          AppMethodBeat.o(208335);
          return false;
        }
        if ((0L != l) && (l != paramLong))
        {
          b.w("TalkRoomManager", new Object[] { "diff roomKey: ", Long.valueOf(l), " -> ", Long.valueOf(paramLong) });
          AppMethodBeat.o(208335);
          return false;
        }
      }
      if (str2 == null)
      {
        b.d("TalkRoomManager", new Object[] { "newOrUpdateGroup create groupId: ", str1 });
        paramString1 = TalkRoom.a(str1, paramString2, paramInteger, paramInt, paramLong, paramaw, paramArrayOfay, paramArrayOfaz);
        this.MIr.put(str1, paramString1);
      }
      for (;;)
      {
        if ((this.MIt != null) && (paramBoolean1)) {
          this.MIt.f(bbJ(str1));
        }
        gdX();
        AppMethodBeat.o(208335);
        return true;
        b.d("TalkRoomManager", new Object[] { "newOrUpdateGroup update groupId: ", str1 });
        TalkRoom.a(str2, str1, paramString2, paramInteger, paramInt, paramLong, paramaw, paramArrayOfay, paramArrayOfaz);
      }
    }
  }
  
  public final TalkRoom bbC(String paramString)
  {
    AppMethodBeat.i(62704);
    TalkRoom localTalkRoom2 = (TalkRoom)this.MIr.get(paramString);
    TalkRoom localTalkRoom1 = localTalkRoom2;
    if (localTalkRoom2 == null)
    {
      localTalkRoom1 = localTalkRoom2;
      if (j.bbQ(paramString))
      {
        paramString = (String)this.MIs.get(paramString);
        localTalkRoom1 = (TalkRoom)this.MIr.get(paramString);
      }
    }
    AppMethodBeat.o(62704);
    return localTalkRoom1;
  }
  
  public final void bbD(String paramString)
  {
    AppMethodBeat.i(62705);
    try
    {
      paramString = bbC(paramString);
      if (paramString == null)
      {
        b.w("TalkRoomManager", new Object[] { "handleRoomExit assert failed: current TalkRoom MUST exists" });
        AppMethodBeat.o(62705);
        return;
      }
      d locald = paramString.bbB(a.fXK());
      if (locald != null)
      {
        locald.MIu.status = 20;
        locald.MIu.pcE = -1;
      }
      if (paramString.wmz == null) {}
      for (paramString = "";; paramString = paramString.wmz)
      {
        b.d("tagorewang:TalkRoom", new Object[] { "resetRoomTempInfo groupId: ", paramString });
        gdX();
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
  
  public final int bbE(String paramString)
  {
    AppMethodBeat.i(62706);
    if (TextUtils.isEmpty(paramString))
    {
      b.w("TalkRoomManager", new Object[] { "getSelfMemberId invalid groupId" });
      AppMethodBeat.o(62706);
      return -1;
    }
    Object localObject = bbC(paramString);
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getSelfMemberId TalkRoom is null  groupId: ", paramString });
      AppMethodBeat.o(62706);
      return -1;
    }
    localObject = ((TalkRoom)localObject).bbB(a.fXK());
    if (localObject != null)
    {
      b.w("TalkRoomManager", new Object[] { "getSelfMemberId TalkRoomMember is not null groupId: ", paramString, " uuid: ", a.fXK(), " memberId: ", Integer.valueOf(((d)localObject).getMemberId()) });
      int i = ((d)localObject).getMemberId();
      AppMethodBeat.o(62706);
      return i;
    }
    b.w("TalkRoomManager", new Object[] { "getSelfMemberId TalkRoomMember is null" });
    AppMethodBeat.o(62706);
    return -1;
  }
  
  public final int bbF(String paramString)
  {
    AppMethodBeat.i(62707);
    if (TextUtils.isEmpty(paramString))
    {
      b.w("TalkRoomManager", new Object[] { "getRountIdByGrouId invalid groupId" });
      AppMethodBeat.o(62707);
      return 0;
    }
    TalkRoom localTalkRoom = bbC(paramString);
    if (localTalkRoom == null)
    {
      b.w("TalkRoomManager", new Object[] { "getRountIdByGrouId TalkRoom is null  groupId: ", paramString });
      AppMethodBeat.o(62707);
      return 0;
    }
    int i = localTalkRoom.gdK();
    AppMethodBeat.o(62707);
    return i;
  }
  
  public final int bbG(String paramString)
  {
    AppMethodBeat.i(62711);
    TalkRoom localTalkRoom = bbC(paramString);
    if (localTalkRoom == null)
    {
      AppMethodBeat.o(62711);
      return 0;
    }
    int i = localTalkRoom.MIn.size();
    b.d("TalkRoomManager", new Object[] { "getGroupMemberSize groupid: ", paramString, " size: ", Integer.valueOf(i) });
    AppMethodBeat.o(62711);
    return i;
  }
  
  public final MultiTalkGroup bbJ(String paramString)
  {
    AppMethodBeat.i(62715);
    paramString = bbC(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(62715);
      return null;
    }
    paramString = paramString.gdS();
    AppMethodBeat.o(62715);
    return paramString;
  }
  
  public final boolean dl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(62703);
    if (TextUtils.isEmpty(paramString))
    {
      b.w("TalkRoomManager", new Object[] { "isGroupActiveExceptMySelf groupid is null" });
      AppMethodBeat.o(62703);
      return false;
    }
    paramString = bbC(paramString);
    if (paramString == null)
    {
      b.w("TalkRoomManager", new Object[] { "isGroupActiveExceptMySelf talkRoom is null" });
      AppMethodBeat.o(62703);
      return false;
    }
    paramString = paramString.gdN();
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
          locald.gdY();
          TalkRoom.gdJ();
          if (locald.getState() != 10) {
            break label234;
          }
          if (locald.gdZ()) {
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
  
  public final boolean e(String paramString1, String paramString2, String... paramVarArgs)
  {
    AppMethodBeat.i(62708);
    b.d("TalkRoomManager", new Object[] { "newTmpGroup groupId: ", paramString1 });
    if (!j.bbQ(paramString1))
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
      ((a.aw)localObject).dui = 0;
      ((a.aw)localObject).Mfy = paramString2;
      ((a.aw)localObject).Mfx = a.fXK();
      paramString2 = new TalkRoom(paramString1, null, (a.aw)localObject);
      int j = paramVarArgs.length;
      int i = 0;
      while (i != j)
      {
        localObject = paramVarArgs[i];
        a.ay localay = new a.ay();
        localay.duC = ((String)localObject);
        localay.MfZ = a.fXK();
        localay.status = 20;
        localay.pcE = -1;
        localay.MfN = ((int)(System.currentTimeMillis() / 1000L));
        paramString2.a(new d(localay, new a.az()));
        i += 1;
      }
      this.MIr.put(paramString1, paramString2);
      gdX();
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
  
  public final String hn(String paramString, int paramInt)
  {
    AppMethodBeat.i(208336);
    if (TextUtils.isEmpty(paramString))
    {
      b.w("TalkRoomManager", new Object[] { "getUsrNameByMemberId groupId is null memberId: ", Integer.valueOf(paramInt) });
      AppMethodBeat.o(208336);
      return "";
    }
    Object localObject = bbC(paramString);
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getUsrNameByMemberId talkRoom is null groupId: ", paramString, " memberId: ", Integer.valueOf(paramInt) });
      AppMethodBeat.o(208336);
      return "";
    }
    localObject = ((TalkRoom)localObject).gdR().iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.ay localay = (a.ay)((Iterator)localObject).next();
      if ((localay != null) && (localay.pcE == paramInt))
      {
        b.d("TalkRoomManager", new Object[] { "getUsrNameByMemberId wxUserName:", localay.duC, " groupId: ", paramString, " memberId: ", Integer.valueOf(paramInt) });
        if (localay.duC == null)
        {
          AppMethodBeat.o(208336);
          return "";
        }
        paramString = localay.duC;
        AppMethodBeat.o(208336);
        return paramString;
      }
    }
    AppMethodBeat.o(208336);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.c
 * JD-Core Version:    0.7.0.1
 */