package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.a.az;
import com.tencent.pb.common.b.a.a.a.bb;
import com.tencent.pb.common.b.a.a.a.bc;
import com.tencent.pb.common.c.b;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
{
  private static boolean DEBUG;
  public static boolean Suk;
  private static final com.tencent.pb.common.c.d<c> Sul;
  private Map<String, TalkRoom> Sum;
  private Map<String, String> Sun;
  g Suo;
  
  static
  {
    AppMethodBeat.i(62716);
    Suk = false;
    DEBUG = false;
    Sul = new com.tencent.pb.common.c.d() {};
    AppMethodBeat.o(62716);
  }
  
  private c()
  {
    AppMethodBeat.i(62702);
    this.Sum = new HashMap();
    this.Sun = new HashMap();
    b.d("TalkRoomManager", new Object[] { "asyncLoadCache" });
    AppMethodBeat.o(62702);
  }
  
  public static boolean brl(String paramString)
  {
    AppMethodBeat.i(62713);
    paramString = hqY().brg(paramString);
    if (paramString == null)
    {
      b.w("TalkRoomManager", new Object[] { "isMySelfExit talkRoom is null" });
      AppMethodBeat.o(62713);
      return true;
    }
    paramString = paramString.hqR();
    if ((paramString == null) || (20 == paramString.getState()))
    {
      AppMethodBeat.o(62713);
      return true;
    }
    AppMethodBeat.o(62713);
    return false;
  }
  
  public static int brm(String paramString)
  {
    AppMethodBeat.i(62714);
    Object localObject = hqY().brg(paramString);
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getMySelfReason talkRoom is null groupId: ", paramString });
      AppMethodBeat.o(62714);
      return 0;
    }
    localObject = ((TalkRoom)localObject).hqR();
    if ((localObject != null) && (((d)localObject).Sup != null)) {}
    for (int i = ((d)localObject).Sup.bDZ;; i = 0)
    {
      b.w("TalkRoomManager", new Object[] { "getMySelfReason groupId: ", paramString, " reason: ", Integer.valueOf(i) });
      AppMethodBeat.o(62714);
      return i;
    }
  }
  
  public static c hqY()
  {
    AppMethodBeat.i(62701);
    c localc = (c)Sul.get();
    AppMethodBeat.o(62701);
    return localc;
  }
  
  private static void hqZ()
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
    Object localObject = brg(paramString);
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId talkRoom is null,groupId: ", paramString });
      AppMethodBeat.o(62712);
      return null;
    }
    localObject = ((TalkRoom)localObject).brf(a.hjq());
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId talkRoomMember is null,groupId: ", paramString });
      AppMethodBeat.o(62712);
      return null;
    }
    localObject = ((d)localObject).Sup;
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
    localStringBuffer.append(((a.bb)localObject).RGh);
    b.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId msgKey is", localStringBuffer.toString() });
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(62712);
    return paramString;
  }
  
  public final boolean a(String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.az paramaz, a.bb[] paramArrayOfbb, a.bc[] paramArrayOfbc, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(199681);
    b.d("TalkRoomManager", new Object[] { "newOrUpdateGroup groupId: ", paramString1, " isActive: ", Boolean.valueOf(paramBoolean2) });
    if (TextUtils.isEmpty(paramString1)) {}
    for (String str1 = paramString2;; str1 = paramString1)
    {
      if (TextUtils.isEmpty(str1))
      {
        b.w("TalkRoomManager", new Object[] { "newOrUpdateGroup invalid groupId" });
        AppMethodBeat.o(199681);
        return false;
      }
      if (j.bru(paramString2)) {
        this.Sun.put(paramString2, str1);
      }
      paramString1 = (TalkRoom)this.Sum.get(str1);
      if ((!TextUtils.isEmpty(paramString2)) && (paramString1 != null) && (paramaz != null) && (paramaz.dLt != 100))
      {
        b.w("TalkRoomManager", new Object[] { "newOrUpdateGroup clientGroupId is not empty , room is not null" });
        AppMethodBeat.o(199681);
        return false;
      }
      String str2 = paramString1;
      if (paramString1 == null)
      {
        if (j.bru(paramString2)) {
          paramString1 = (TalkRoom)this.Sum.get(paramString2);
        }
        str2 = paramString1;
        if (paramString1 != null)
        {
          this.Sum.put(str1, paramString1);
          str2 = paramString1;
        }
      }
      if ((str2 != null) && (paramBoolean2))
      {
        int i = j.hrA();
        long l = j.hrB();
        b.d("TalkRoomManager", new Object[] { "check current active group roomId: ", Integer.valueOf(i), " and roomKey: ", Long.valueOf(paramLong) });
        if ((i != 0) && (i != paramInt))
        {
          b.w("TalkRoomManager", new Object[] { "diff roomId: ", Integer.valueOf(i), " -> ", Integer.valueOf(paramInt) });
          AppMethodBeat.o(199681);
          return false;
        }
        if ((0L != l) && (l != paramLong))
        {
          b.w("TalkRoomManager", new Object[] { "diff roomKey: ", Long.valueOf(l), " -> ", Long.valueOf(paramLong) });
          AppMethodBeat.o(199681);
          return false;
        }
      }
      if (str2 == null)
      {
        b.d("TalkRoomManager", new Object[] { "newOrUpdateGroup create groupId: ", str1 });
        paramString1 = TalkRoom.a(str1, paramString2, paramInteger, paramInt, paramLong, paramaz, paramArrayOfbb, paramArrayOfbc);
        this.Sum.put(str1, paramString1);
      }
      for (;;)
      {
        if ((this.Suo != null) && (paramBoolean1)) {
          this.Suo.f(brn(str1));
        }
        hqZ();
        AppMethodBeat.o(199681);
        return true;
        b.d("TalkRoomManager", new Object[] { "newOrUpdateGroup update groupId: ", str1 });
        TalkRoom.a(str2, str1, paramString2, paramInteger, paramInt, paramLong, paramaz, paramArrayOfbb, paramArrayOfbc);
      }
    }
  }
  
  public final TalkRoom brg(String paramString)
  {
    AppMethodBeat.i(62704);
    TalkRoom localTalkRoom2 = (TalkRoom)this.Sum.get(paramString);
    TalkRoom localTalkRoom1 = localTalkRoom2;
    if (localTalkRoom2 == null)
    {
      localTalkRoom1 = localTalkRoom2;
      if (j.bru(paramString))
      {
        paramString = (String)this.Sun.get(paramString);
        localTalkRoom1 = (TalkRoom)this.Sum.get(paramString);
      }
    }
    AppMethodBeat.o(62704);
    return localTalkRoom1;
  }
  
  public final void brh(String paramString)
  {
    AppMethodBeat.i(62705);
    try
    {
      paramString = brg(paramString);
      if (paramString == null)
      {
        b.w("TalkRoomManager", new Object[] { "handleRoomExit assert failed: current TalkRoom MUST exists" });
        AppMethodBeat.o(62705);
        return;
      }
      d locald = paramString.brf(a.hjq());
      if (locald != null)
      {
        locald.Sup.status = 20;
        locald.Sup.qrD = -1;
      }
      if (paramString.zHD == null) {}
      for (paramString = "";; paramString = paramString.zHD)
      {
        b.d("tagorewang:TalkRoom", new Object[] { "resetRoomTempInfo groupId: ", paramString });
        hqZ();
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
  
  public final int bri(String paramString)
  {
    AppMethodBeat.i(62706);
    if (TextUtils.isEmpty(paramString))
    {
      b.w("TalkRoomManager", new Object[] { "getSelfMemberId invalid groupId" });
      AppMethodBeat.o(62706);
      return -1;
    }
    Object localObject = brg(paramString);
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getSelfMemberId TalkRoom is null  groupId: ", paramString });
      AppMethodBeat.o(62706);
      return -1;
    }
    localObject = ((TalkRoom)localObject).brf(a.hjq());
    if (localObject != null)
    {
      b.w("TalkRoomManager", new Object[] { "getSelfMemberId TalkRoomMember is not null groupId: ", paramString, " uuid: ", a.hjq(), " memberId: ", Integer.valueOf(((d)localObject).getMemberId()) });
      int i = ((d)localObject).getMemberId();
      AppMethodBeat.o(62706);
      return i;
    }
    b.w("TalkRoomManager", new Object[] { "getSelfMemberId TalkRoomMember is null" });
    AppMethodBeat.o(62706);
    return -1;
  }
  
  public final int brj(String paramString)
  {
    AppMethodBeat.i(62707);
    if (TextUtils.isEmpty(paramString))
    {
      b.w("TalkRoomManager", new Object[] { "getRountIdByGrouId invalid groupId" });
      AppMethodBeat.o(62707);
      return 0;
    }
    TalkRoom localTalkRoom = brg(paramString);
    if (localTalkRoom == null)
    {
      b.w("TalkRoomManager", new Object[] { "getRountIdByGrouId TalkRoom is null  groupId: ", paramString });
      AppMethodBeat.o(62707);
      return 0;
    }
    int i = localTalkRoom.hqM();
    AppMethodBeat.o(62707);
    return i;
  }
  
  public final int brk(String paramString)
  {
    AppMethodBeat.i(62711);
    TalkRoom localTalkRoom = brg(paramString);
    if (localTalkRoom == null)
    {
      AppMethodBeat.o(62711);
      return 0;
    }
    int i = localTalkRoom.Sui.size();
    b.d("TalkRoomManager", new Object[] { "getGroupMemberSize groupid: ", paramString, " size: ", Integer.valueOf(i) });
    AppMethodBeat.o(62711);
    return i;
  }
  
  public final MultiTalkGroup brn(String paramString)
  {
    AppMethodBeat.i(62715);
    paramString = brg(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(62715);
      return null;
    }
    paramString = paramString.hqU();
    AppMethodBeat.o(62715);
    return paramString;
  }
  
  public final boolean dG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(62703);
    if (TextUtils.isEmpty(paramString))
    {
      b.w("TalkRoomManager", new Object[] { "isGroupActiveExceptMySelf groupid is null" });
      AppMethodBeat.o(62703);
      return false;
    }
    paramString = brg(paramString);
    if (paramString == null)
    {
      b.w("TalkRoomManager", new Object[] { "isGroupActiveExceptMySelf talkRoom is null" });
      AppMethodBeat.o(62703);
      return false;
    }
    paramString = paramString.hqP();
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
          locald.hra();
          TalkRoom.hqL();
          if (locald.getState() != 10) {
            break label234;
          }
          if (locald.isSelf()) {
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
    if (!j.bru(paramString1))
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
      Object localObject = new a.az();
      ((a.az)localObject).dLt = 0;
      ((a.az)localObject).RFQ = paramString2;
      ((a.az)localObject).RFP = a.hjq();
      paramString2 = new TalkRoom(paramString1, null, (a.az)localObject);
      int j = paramVarArgs.length;
      int i = 0;
      while (i != j)
      {
        localObject = paramVarArgs[i];
        a.bb localbb = new a.bb();
        localbb.dLN = ((String)localObject);
        localbb.RGr = a.hjq();
        localbb.status = 20;
        localbb.qrD = -1;
        localbb.RGf = ((int)(System.currentTimeMillis() / 1000L));
        paramString2.a(new d(localbb, new a.bc()));
        i += 1;
      }
      this.Sum.put(paramString1, paramString2);
      hqZ();
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
  
  public final String hJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(199682);
    if (TextUtils.isEmpty(paramString))
    {
      b.w("TalkRoomManager", new Object[] { "getUsrNameByMemberId groupId is null memberId: ", Integer.valueOf(paramInt) });
      AppMethodBeat.o(199682);
      return "";
    }
    Object localObject = brg(paramString);
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getUsrNameByMemberId talkRoom is null groupId: ", paramString, " memberId: ", Integer.valueOf(paramInt) });
      AppMethodBeat.o(199682);
      return "";
    }
    localObject = ((TalkRoom)localObject).hqT().iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.bb localbb = (a.bb)((Iterator)localObject).next();
      if ((localbb != null) && (localbb.qrD == paramInt))
      {
        b.d("TalkRoomManager", new Object[] { "getUsrNameByMemberId wxUserName:", localbb.dLN, " groupId: ", paramString, " memberId: ", Integer.valueOf(paramInt) });
        if (localbb.dLN == null)
        {
          AppMethodBeat.o(199682);
          return "";
        }
        paramString = localbb.dLN;
        AppMethodBeat.o(199682);
        return paramString;
      }
    }
    AppMethodBeat.o(199682);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.c
 * JD-Core Version:    0.7.0.1
 */