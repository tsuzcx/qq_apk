package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.c.e;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
{
  public static boolean BAa;
  private static final e<c> BAb;
  private static boolean DEBUG;
  private Map<String, TalkRoom> BAc;
  private Map<String, String> BAd;
  g BAe;
  
  static
  {
    AppMethodBeat.i(127810);
    BAa = false;
    DEBUG = false;
    BAb = new c.1();
    AppMethodBeat.o(127810);
  }
  
  private c()
  {
    AppMethodBeat.i(127796);
    this.BAc = new HashMap();
    this.BAd = new HashMap();
    com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "asyncLoadCache" });
    AppMethodBeat.o(127796);
  }
  
  public static boolean axu(String paramString)
  {
    AppMethodBeat.i(127807);
    paramString = dXv().axp(paramString);
    if (paramString == null)
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "isMySelfExit talkRoom is null" });
      AppMethodBeat.o(127807);
      return true;
    }
    paramString = paramString.dXo();
    if ((paramString == null) || (20 == paramString.getState()))
    {
      AppMethodBeat.o(127807);
      return true;
    }
    AppMethodBeat.o(127807);
    return false;
  }
  
  public static int axv(String paramString)
  {
    AppMethodBeat.i(127808);
    Object localObject = dXv().axp(paramString);
    if (localObject == null)
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getMySelfReason talkRoom is null groupId: ", paramString });
      AppMethodBeat.o(127808);
      return 0;
    }
    localObject = ((TalkRoom)localObject).dXo();
    if ((localObject != null) && (((d)localObject).BAf != null)) {}
    for (int i = ((d)localObject).BAf.aXG;; i = 0)
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getMySelfReason groupId: ", paramString, " reason: ", Integer.valueOf(i) });
      AppMethodBeat.o(127808);
      return i;
    }
  }
  
  public static c dXv()
  {
    AppMethodBeat.i(127795);
    c localc = (c)BAb.get();
    AppMethodBeat.o(127795);
    return localc;
  }
  
  private static void dXw()
  {
    AppMethodBeat.i(127804);
    com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "asyncWriteBackCache" });
    AppMethodBeat.o(127804);
  }
  
  public final boolean a(String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.at paramat, a.av[] paramArrayOfav, a.aw[] paramArrayOfaw, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(127803);
    com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "newOrUpdateGroup groupId: ", paramString1, " isActive: ", Boolean.valueOf(paramBoolean2) });
    if (TextUtils.isEmpty(paramString1)) {}
    for (String str1 = paramString2;; str1 = paramString1)
    {
      if (TextUtils.isEmpty(str1))
      {
        com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "newOrUpdateGroup invalid groupId" });
        AppMethodBeat.o(127803);
        return false;
      }
      if (j.axD(paramString2)) {
        this.BAd.put(paramString2, str1);
      }
      paramString1 = (TalkRoom)this.BAc.get(str1);
      if ((!TextUtils.isEmpty(paramString2)) && (paramString1 != null) && (paramat != null) && (paramat.cve != 100))
      {
        com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "newOrUpdateGroup clientGroupId is not empty , room is not null" });
        AppMethodBeat.o(127803);
        return false;
      }
      String str2 = paramString1;
      if (paramString1 == null)
      {
        if (j.axD(paramString2)) {
          paramString1 = (TalkRoom)this.BAc.get(paramString2);
        }
        str2 = paramString1;
        if (paramString1 != null)
        {
          this.BAc.put(str1, paramString1);
          str2 = paramString1;
        }
      }
      if ((str2 != null) && (paramBoolean2))
      {
        int i = j.dXV();
        long l = j.dXW();
        com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "check current active group roomId: ", Integer.valueOf(i), " and roomKey: ", Long.valueOf(paramLong) });
        if ((i != 0) && (i != paramInt))
        {
          com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "diff roomId: ", Integer.valueOf(i), " -> ", Integer.valueOf(paramInt) });
          AppMethodBeat.o(127803);
          return false;
        }
        if ((0L != l) && (l != paramLong))
        {
          com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "diff roomKey: ", Long.valueOf(l), " -> ", Long.valueOf(paramLong) });
          AppMethodBeat.o(127803);
          return false;
        }
      }
      if (str2 == null)
      {
        com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "newOrUpdateGroup create groupId: ", str1 });
        paramString1 = TalkRoom.a(str1, paramString2, paramInteger, paramInt, paramLong, paramat, paramArrayOfav, paramArrayOfaw);
        this.BAc.put(str1, paramString1);
      }
      for (;;)
      {
        if ((this.BAe != null) && (paramBoolean1)) {
          this.BAe.g(axw(str1));
        }
        dXw();
        AppMethodBeat.o(127803);
        return true;
        com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "newOrUpdateGroup update groupId: ", str1 });
        TalkRoom.a(str2, str1, paramString2, paramInteger, paramInt, paramLong, paramat, paramArrayOfav, paramArrayOfaw);
      }
    }
  }
  
  public final TalkRoom axp(String paramString)
  {
    AppMethodBeat.i(127798);
    TalkRoom localTalkRoom2 = (TalkRoom)this.BAc.get(paramString);
    TalkRoom localTalkRoom1 = localTalkRoom2;
    if (localTalkRoom2 == null)
    {
      localTalkRoom1 = localTalkRoom2;
      if (j.axD(paramString))
      {
        paramString = (String)this.BAd.get(paramString);
        localTalkRoom1 = (TalkRoom)this.BAc.get(paramString);
      }
    }
    AppMethodBeat.o(127798);
    return localTalkRoom1;
  }
  
  public final void axq(String paramString)
  {
    AppMethodBeat.i(127799);
    try
    {
      paramString = axp(paramString);
      if (paramString == null)
      {
        com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "handleRoomExit assert failed: current TalkRoom MUST exists" });
        AppMethodBeat.o(127799);
        return;
      }
      d locald = paramString.axo(a.dTX());
      if (locald != null)
      {
        locald.BAf.status = 20;
        locald.BAf.kJx = -1;
      }
      if (paramString.Bhl == null) {}
      for (paramString = "";; paramString = paramString.Bhl)
      {
        com.tencent.pb.common.c.c.d("tagorewang:TalkRoom", new Object[] { "resetRoomTempInfo groupId: ", paramString });
        dXw();
        AppMethodBeat.o(127799);
        return;
      }
      return;
    }
    catch (Throwable paramString)
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "handleRoomExit: ", paramString });
      AppMethodBeat.o(127799);
    }
  }
  
  public final int axr(String paramString)
  {
    AppMethodBeat.i(127800);
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getSelfMemberId invalid groupId" });
      AppMethodBeat.o(127800);
      return -1;
    }
    Object localObject = axp(paramString);
    if (localObject == null)
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getSelfMemberId TalkRoom is null  groupId: ", paramString });
      AppMethodBeat.o(127800);
      return -1;
    }
    localObject = ((TalkRoom)localObject).axo(a.dTX());
    if (localObject != null)
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getSelfMemberId TalkRoomMember is not null groupId: ", paramString, " uuid: ", a.dTX(), " memberId: ", Integer.valueOf(((d)localObject).getMemberId()) });
      int i = ((d)localObject).getMemberId();
      AppMethodBeat.o(127800);
      return i;
    }
    com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getSelfMemberId TalkRoomMember is null" });
    AppMethodBeat.o(127800);
    return -1;
  }
  
  public final int axs(String paramString)
  {
    AppMethodBeat.i(127801);
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getRountIdByGrouId invalid groupId" });
      AppMethodBeat.o(127801);
      return 0;
    }
    TalkRoom localTalkRoom = axp(paramString);
    if (localTalkRoom == null)
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getRountIdByGrouId TalkRoom is null  groupId: ", paramString });
      AppMethodBeat.o(127801);
      return 0;
    }
    int i = localTalkRoom.dXj();
    AppMethodBeat.o(127801);
    return i;
  }
  
  public final int axt(String paramString)
  {
    AppMethodBeat.i(127805);
    TalkRoom localTalkRoom = axp(paramString);
    if (localTalkRoom == null)
    {
      AppMethodBeat.o(127805);
      return 0;
    }
    int i = localTalkRoom.BzY.size();
    com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "getGroupMemberSize groupid: ", paramString, " size: ", Integer.valueOf(i) });
    AppMethodBeat.o(127805);
    return i;
  }
  
  public final MultiTalkGroup axw(String paramString)
  {
    AppMethodBeat.i(127809);
    paramString = axp(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(127809);
      return null;
    }
    paramString = paramString.dXr();
    AppMethodBeat.o(127809);
    return paramString;
  }
  
  public final boolean cw(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(127797);
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "isGroupActiveExceptMySelf groupid is null" });
      AppMethodBeat.o(127797);
      return false;
    }
    paramString = axp(paramString);
    if (paramString == null)
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "isGroupActiveExceptMySelf talkRoom is null" });
      AppMethodBeat.o(127797);
      return false;
    }
    paramString = paramString.dXm();
    if (paramString == null)
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "isGroupActiveExceptMySelf TalkRoomMember list is null" });
      AppMethodBeat.o(127797);
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
          locald.dXx();
          TalkRoom.dXi();
          if (locald.getState() != 10) {
            break label234;
          }
          if (locald.dXy()) {
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
        AppMethodBeat.o(127797);
        return true;
        j = 1;
      }
      else
      {
        if ((i != 0) && (j != 0))
        {
          com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "isGroupActiveExceptMySelf is true" });
          AppMethodBeat.o(127797);
          return true;
        }
        break;
        AppMethodBeat.o(127797);
        return false;
      }
    }
  }
  
  public final boolean e(String paramString1, String paramString2, String... paramVarArgs)
  {
    AppMethodBeat.i(127802);
    com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "newTmpGroup groupId: ", paramString1 });
    if (!j.axD(paramString1))
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "newTmpGroup invalid clientGroupId" });
      AppMethodBeat.o(127802);
      return false;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "newTmpGroup empty uuid array" });
      AppMethodBeat.o(127802);
      return false;
    }
    try
    {
      Object localObject = new a.at();
      ((a.at)localObject).cve = 0;
      ((a.at)localObject).Bgc = paramString2;
      ((a.at)localObject).Bgb = a.dTX();
      paramString2 = new TalkRoom(paramString1, null, (a.at)localObject);
      int j = paramVarArgs.length;
      int i = 0;
      while (i != j)
      {
        localObject = paramVarArgs[i];
        a.av localav = new a.av();
        localav.Bfy = ((String)localObject);
        localav.BgD = a.dTX();
        localav.status = 20;
        localav.kJx = -1;
        localav.Bgr = ((int)(System.currentTimeMillis() / 1000L));
        paramString2.a(new d(localav, new a.aw()));
        i += 1;
      }
      this.BAc.put(paramString1, paramString2);
      dXw();
      AppMethodBeat.o(127802);
      return true;
    }
    catch (Exception paramString1)
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "newTmpGroup err: ", paramString1 });
      AppMethodBeat.o(127802);
    }
    return false;
  }
  
  public final String m(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(127806);
    if ((paramInt == 0) && (paramLong == 0L))
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId roomId and roomKey is 0,groupId: ", paramString });
      AppMethodBeat.o(127806);
      return null;
    }
    Object localObject = axp(paramString);
    if (localObject == null)
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId talkRoom is null,groupId: ", paramString });
      AppMethodBeat.o(127806);
      return null;
    }
    localObject = ((TalkRoom)localObject).axo(a.dTX());
    if (localObject == null)
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId talkRoomMember is null,groupId: ", paramString });
      AppMethodBeat.o(127806);
      return null;
    }
    localObject = ((d)localObject).BAf;
    if (localObject == null)
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId voiceGroupMem is null,groupId: ", paramString });
      AppMethodBeat.o(127806);
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString);
    localStringBuffer.append(",");
    localStringBuffer.append(paramInt);
    localStringBuffer.append(",");
    localStringBuffer.append(paramLong);
    localStringBuffer.append(",");
    localStringBuffer.append(((a.av)localObject).Bgt);
    com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId msgKey is", localStringBuffer.toString() });
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(127806);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.c
 * JD-Core Version:    0.7.0.1
 */