package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.common.b.a.a.a.ba;
import com.tencent.pb.common.b.a.a.a.bb;
import com.tencent.pb.common.c.b;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
{
  private static boolean DEBUG;
  public static boolean ahZF;
  private static final com.tencent.pb.common.c.d<c> ahZG;
  private Map<String, TalkRoom> ahZH;
  private Map<String, String> ahZI;
  g ahZJ;
  
  static
  {
    AppMethodBeat.i(62716);
    ahZF = false;
    DEBUG = false;
    ahZG = new com.tencent.pb.common.c.d() {};
    AppMethodBeat.o(62716);
  }
  
  private c()
  {
    AppMethodBeat.i(62702);
    this.ahZH = new HashMap();
    this.ahZI = new HashMap();
    b.d("TalkRoomManager", new Object[] { "asyncLoadCache" });
    AppMethodBeat.o(62702);
  }
  
  public static boolean bGJ(String paramString)
  {
    AppMethodBeat.i(62713);
    paramString = ked().bGE(paramString);
    if (paramString == null)
    {
      b.w("TalkRoomManager", new Object[] { "isMySelfExit talkRoom is null" });
      AppMethodBeat.o(62713);
      return true;
    }
    paramString = paramString.kdX();
    if ((paramString == null) || (20 == paramString.getState()))
    {
      AppMethodBeat.o(62713);
      return true;
    }
    AppMethodBeat.o(62713);
    return false;
  }
  
  public static int bGK(String paramString)
  {
    AppMethodBeat.i(62714);
    Object localObject = ked().bGE(paramString);
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getMySelfReason talkRoom is null groupId: ", paramString });
      AppMethodBeat.o(62714);
      return 0;
    }
    localObject = ((TalkRoom)localObject).kdX();
    if ((localObject != null) && (((d)localObject).ahZK != null)) {}
    for (int i = ((d)localObject).ahZK.reason;; i = 0)
    {
      b.w("TalkRoomManager", new Object[] { "getMySelfReason groupId: ", paramString, " reason: ", Integer.valueOf(i) });
      AppMethodBeat.o(62714);
      return i;
    }
  }
  
  public static c ked()
  {
    AppMethodBeat.i(62701);
    c localc = (c)ahZG.get();
    AppMethodBeat.o(62701);
    return localc;
  }
  
  private static void kee()
  {
    AppMethodBeat.i(62710);
    b.d("TalkRoomManager", new Object[] { "asyncWriteBackCache" });
    AppMethodBeat.o(62710);
  }
  
  public final String O(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(62712);
    if ((paramInt == 0) && (paramLong == 0L))
    {
      b.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId roomId and roomKey is 0,groupId: ", paramString });
      AppMethodBeat.o(62712);
      return null;
    }
    Object localObject = bGE(paramString);
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId talkRoom is null,groupId: ", paramString });
      AppMethodBeat.o(62712);
      return null;
    }
    localObject = ((TalkRoom)localObject).bGD(a.jRr());
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId talkRoomMember is null,groupId: ", paramString });
      AppMethodBeat.o(62712);
      return null;
    }
    localObject = ((d)localObject).ahZK;
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
    localStringBuffer.append(((a.ba)localObject).ahgo);
    b.w("TalkRoomManager", new Object[] { "getMsgKeyByGroupId msgKey is", localStringBuffer.toString() });
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(62712);
    return paramString;
  }
  
  public final boolean a(String paramString1, String paramString2, Integer paramInteger, int paramInt, long paramLong, a.ay paramay, a.ba[] paramArrayOfba, a.bb[] paramArrayOfbb, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(212286);
    b.d("TalkRoomManager", new Object[] { "newOrUpdateGroup groupId: ", paramString1, " isActive: ", Boolean.valueOf(paramBoolean2) });
    if (TextUtils.isEmpty(paramString1)) {}
    for (String str1 = paramString2;; str1 = paramString1)
    {
      if (TextUtils.isEmpty(str1))
      {
        b.w("TalkRoomManager", new Object[] { "newOrUpdateGroup invalid groupId" });
        AppMethodBeat.o(212286);
        return false;
      }
      if (i.bGS(paramString2)) {
        this.ahZI.put(paramString2, str1);
      }
      paramString1 = (TalkRoom)this.ahZH.get(str1);
      if ((!TextUtils.isEmpty(paramString2)) && (paramString1 != null) && (paramay != null) && (paramay.hIY != 100))
      {
        b.w("TalkRoomManager", new Object[] { "newOrUpdateGroup clientGroupId is not empty , room is not null" });
        AppMethodBeat.o(212286);
        return false;
      }
      String str2 = paramString1;
      if (paramString1 == null)
      {
        if (i.bGS(paramString2)) {
          paramString1 = (TalkRoom)this.ahZH.get(paramString2);
        }
        str2 = paramString1;
        if (paramString1 != null)
        {
          this.ahZH.put(str1, paramString1);
          str2 = paramString1;
        }
      }
      if ((str2 != null) && (paramBoolean2))
      {
        int i = i.keE();
        long l = i.keF();
        b.d("TalkRoomManager", new Object[] { "check current active group roomId: ", Integer.valueOf(i), " and roomKey: ", Long.valueOf(paramLong) });
        if ((i != 0) && (i != paramInt))
        {
          b.w("TalkRoomManager", new Object[] { "diff roomId: ", Integer.valueOf(i), " -> ", Integer.valueOf(paramInt) });
          AppMethodBeat.o(212286);
          return false;
        }
        if ((0L != l) && (l != paramLong))
        {
          b.w("TalkRoomManager", new Object[] { "diff roomKey: ", Long.valueOf(l), " -> ", Long.valueOf(paramLong) });
          AppMethodBeat.o(212286);
          return false;
        }
      }
      if (str2 == null)
      {
        b.d("TalkRoomManager", new Object[] { "newOrUpdateGroup create groupId: ", str1 });
        paramString1 = TalkRoom.a(str1, paramString2, paramInteger, paramInt, paramLong, paramay, paramArrayOfba, paramArrayOfbb);
        this.ahZH.put(str1, paramString1);
      }
      for (;;)
      {
        if ((this.ahZJ != null) && (paramBoolean1)) {
          this.ahZJ.f(bGL(str1));
        }
        kee();
        AppMethodBeat.o(212286);
        return true;
        b.d("TalkRoomManager", new Object[] { "newOrUpdateGroup update groupId: ", str1 });
        TalkRoom.a(str2, str1, paramString2, paramInteger, paramInt, paramLong, paramay, paramArrayOfba, paramArrayOfbb);
      }
    }
  }
  
  public final TalkRoom bGE(String paramString)
  {
    AppMethodBeat.i(62704);
    TalkRoom localTalkRoom2 = (TalkRoom)this.ahZH.get(paramString);
    TalkRoom localTalkRoom1 = localTalkRoom2;
    if (localTalkRoom2 == null)
    {
      localTalkRoom1 = localTalkRoom2;
      if (i.bGS(paramString))
      {
        paramString = (String)this.ahZI.get(paramString);
        localTalkRoom1 = (TalkRoom)this.ahZH.get(paramString);
      }
    }
    AppMethodBeat.o(62704);
    return localTalkRoom1;
  }
  
  public final void bGF(String paramString)
  {
    AppMethodBeat.i(62705);
    try
    {
      paramString = bGE(paramString);
      if (paramString == null)
      {
        b.w("TalkRoomManager", new Object[] { "handleRoomExit assert failed: current TalkRoom MUST exists" });
        AppMethodBeat.o(62705);
        return;
      }
      d locald = paramString.bGD(a.jRr());
      if (locald != null)
      {
        locald.ahZK.status = 20;
        locald.ahZK.wTC = -1;
      }
      if (paramString.LiU == null) {}
      for (paramString = "";; paramString = paramString.LiU)
      {
        b.d("tagorewang:TalkRoom", new Object[] { "resetRoomTempInfo groupId: ", paramString });
        kee();
        AppMethodBeat.o(62705);
        return;
      }
      return;
    }
    finally
    {
      b.w("TalkRoomManager", new Object[] { "handleRoomExit: ", paramString });
      AppMethodBeat.o(62705);
    }
  }
  
  public final int bGG(String paramString)
  {
    AppMethodBeat.i(62706);
    if (TextUtils.isEmpty(paramString))
    {
      b.w("TalkRoomManager", new Object[] { "getSelfMemberId invalid groupId" });
      AppMethodBeat.o(62706);
      return -1;
    }
    Object localObject = bGE(paramString);
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getSelfMemberId TalkRoom is null  groupId: ", paramString });
      AppMethodBeat.o(62706);
      return -1;
    }
    localObject = ((TalkRoom)localObject).bGD(a.jRr());
    if (localObject != null)
    {
      b.w("TalkRoomManager", new Object[] { "getSelfMemberId TalkRoomMember is not null groupId: ", paramString, " uuid: ", a.jRr(), " memberId: ", Integer.valueOf(((d)localObject).getMemberId()) });
      int i = ((d)localObject).getMemberId();
      AppMethodBeat.o(62706);
      return i;
    }
    b.w("TalkRoomManager", new Object[] { "getSelfMemberId TalkRoomMember is null" });
    AppMethodBeat.o(62706);
    return -1;
  }
  
  public final int bGH(String paramString)
  {
    AppMethodBeat.i(62707);
    if (TextUtils.isEmpty(paramString))
    {
      b.w("TalkRoomManager", new Object[] { "getRountIdByGrouId invalid groupId" });
      AppMethodBeat.o(62707);
      return 0;
    }
    TalkRoom localTalkRoom = bGE(paramString);
    if (localTalkRoom == null)
    {
      b.w("TalkRoomManager", new Object[] { "getRountIdByGrouId TalkRoom is null  groupId: ", paramString });
      AppMethodBeat.o(62707);
      return 0;
    }
    int i = localTalkRoom.kdS();
    AppMethodBeat.o(62707);
    return i;
  }
  
  public final int bGI(String paramString)
  {
    AppMethodBeat.i(62711);
    TalkRoom localTalkRoom = bGE(paramString);
    if (localTalkRoom == null)
    {
      AppMethodBeat.o(62711);
      return 0;
    }
    int i = localTalkRoom.ahZD.size();
    b.d("TalkRoomManager", new Object[] { "getGroupMemberSize groupid: ", paramString, " size: ", Integer.valueOf(i) });
    AppMethodBeat.o(62711);
    return i;
  }
  
  public final MultiTalkGroup bGL(String paramString)
  {
    AppMethodBeat.i(62715);
    paramString = bGE(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(62715);
      return null;
    }
    paramString = paramString.kdZ();
    AppMethodBeat.o(62715);
    return paramString;
  }
  
  public final boolean eH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(62703);
    if (TextUtils.isEmpty(paramString))
    {
      b.w("TalkRoomManager", new Object[] { "isGroupActiveExceptMySelf groupid is null" });
      AppMethodBeat.o(62703);
      return false;
    }
    paramString = bGE(paramString);
    if (paramString == null)
    {
      b.w("TalkRoomManager", new Object[] { "isGroupActiveExceptMySelf talkRoom is null" });
      AppMethodBeat.o(62703);
      return false;
    }
    paramString = paramString.kdV();
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
          locald.kef();
          if (!TalkRoom.kdR())
          {
            if (locald.getState() != 10) {
              break label236;
            }
            if (locald.isSelf()) {
              i = 1;
            }
          }
        }
      }
    }
    label236:
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
  
  public final boolean f(String paramString1, String paramString2, String... paramVarArgs)
  {
    AppMethodBeat.i(62708);
    b.d("TalkRoomManager", new Object[] { "newTmpGroup groupId: ", paramString1 });
    if (!i.bGS(paramString1))
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
      Object localObject = new a.ay();
      ((a.ay)localObject).hIY = 0;
      ((a.ay)localObject).ahfW = paramString2;
      ((a.ay)localObject).ahfV = a.jRr();
      paramString2 = new TalkRoom(paramString1, null, (a.ay)localObject);
      int j = paramVarArgs.length;
      int i = 0;
      while (i != j)
      {
        localObject = paramVarArgs[i];
        a.ba localba = new a.ba();
        localba.hJs = ((String)localObject);
        localba.ahgy = a.jRr();
        localba.status = 20;
        localba.wTC = -1;
        localba.ahgm = ((int)(System.currentTimeMillis() / 1000L));
        paramString2.a(new d(localba, new a.bb()));
        i += 1;
      }
      this.ahZH.put(paramString1, paramString2);
      kee();
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
  
  public final String jE(String paramString, int paramInt)
  {
    AppMethodBeat.i(212295);
    if (TextUtils.isEmpty(paramString))
    {
      b.w("TalkRoomManager", new Object[] { "getUsrNameByMemberId groupId is null memberId: ", Integer.valueOf(paramInt) });
      AppMethodBeat.o(212295);
      return "";
    }
    Object localObject = bGE(paramString);
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getUsrNameByMemberId talkRoom is null groupId: ", paramString, " memberId: ", Integer.valueOf(paramInt) });
      AppMethodBeat.o(212295);
      return "";
    }
    localObject = ((TalkRoom)localObject).kdY();
    if (localObject == null)
    {
      b.w("TalkRoomManager", new Object[] { "getUsrNameByMemberId VoiceGroupMems is null groupId: ", paramString, " memberId: ", Integer.valueOf(paramInt) });
      AppMethodBeat.o(212295);
      return "";
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.ba localba = (a.ba)((Iterator)localObject).next();
      if ((localba != null) && (localba.wTC == paramInt))
      {
        b.d("TalkRoomManager", new Object[] { "getUsrNameByMemberId wxUserName:", localba.hJs, " groupId: ", paramString, " memberId: ", Integer.valueOf(paramInt) });
        if (localba.hJs == null)
        {
          AppMethodBeat.o(212295);
          return "";
        }
        paramString = localba.hJs;
        AppMethodBeat.o(212295);
        return paramString;
      }
    }
    AppMethodBeat.o(212295);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.c
 * JD-Core Version:    0.7.0.1
 */