package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.c.e;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
{
  private static boolean DEBUG = false;
  public static boolean xds = false;
  private static final e<c> xdt = new c.1();
  Map<String, TalkRoom> xdu = new HashMap();
  Map<String, String> xdv = new HashMap();
  g xdw;
  
  private c()
  {
    com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "asyncLoadCache" });
  }
  
  public static int agA(String paramString)
  {
    Object localObject = cRC().agw(paramString);
    if (localObject == null)
    {
      com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getMySelfReason talkRoom is null groupId: ", paramString });
      return 0;
    }
    localObject = ((TalkRoom)localObject).cRy();
    if ((localObject != null) && (((d)localObject).xdx != null)) {}
    for (int i = ((d)localObject).xdx.aQw;; i = 0)
    {
      com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getMySelfReason groupId: ", paramString, " reason: ", Integer.valueOf(i) });
      return i;
    }
  }
  
  public static boolean agz(String paramString)
  {
    paramString = cRC().agw(paramString);
    if (paramString == null) {
      com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "isMySelfExit talkRoom is null" });
    }
    do
    {
      return true;
      paramString = paramString.cRy();
    } while ((paramString == null) || (20 == paramString.getState()));
    return false;
  }
  
  public static c cRC()
  {
    return (c)xdt.get();
  }
  
  static void cRD()
  {
    com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "asyncWriteBackCache" });
  }
  
  public final MultiTalkGroup agB(String paramString)
  {
    paramString = agw(paramString);
    if (paramString == null) {
      return null;
    }
    MultiTalkGroup localMultiTalkGroup = new MultiTalkGroup();
    localMultiTalkGroup.wJL = paramString.wJL;
    localMultiTalkGroup.wJM = paramString.wJM;
    localMultiTalkGroup.wFA = paramString.wFA;
    localMultiTalkGroup.wJN = paramString.wJN;
    localMultiTalkGroup.wJO = paramString.wJO;
    ArrayList localArrayList = new ArrayList();
    paramString = paramString.cRx();
    if (paramString.size() > 0)
    {
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald != null)
        {
          MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
          localMultiTalkGroupMember.wJQ = locald.cRE();
          if (locald.xdx != null)
          {
            paramString = locald.xdx.wJd;
            label154:
            localMultiTalkGroupMember.wJR = paramString;
            if (locald.xdx == null) {
              break label246;
            }
            i = locald.xdx.aQw;
            label177:
            localMultiTalkGroupMember.aQw = i;
            localMultiTalkGroupMember.status = locald.getState();
            if ((locald.xdx == null) || (locald.xdx.wIR == 0)) {
              break label251;
            }
          }
          label246:
          label251:
          for (int i = locald.xdx.wIR;; i = 0)
          {
            localMultiTalkGroupMember.wIR = i;
            localArrayList.add(localMultiTalkGroupMember);
            break;
            paramString = "";
            break label154;
            i = 0;
            break label177;
          }
        }
      }
    }
    localMultiTalkGroup.wJP = localArrayList;
    return localMultiTalkGroup;
  }
  
  public final TalkRoom agw(String paramString)
  {
    TalkRoom localTalkRoom2 = (TalkRoom)this.xdu.get(paramString);
    TalkRoom localTalkRoom1 = localTalkRoom2;
    if (localTalkRoom2 == null)
    {
      localTalkRoom1 = localTalkRoom2;
      if (j.agI(paramString))
      {
        paramString = (String)this.xdv.get(paramString);
        localTalkRoom1 = (TalkRoom)this.xdu.get(paramString);
      }
    }
    return localTalkRoom1;
  }
  
  public final int agx(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getSelfMemberId invalid groupId" });
      return -1;
    }
    Object localObject = agw(paramString);
    if (localObject == null)
    {
      com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getSelfMemberId TalkRoom is null  groupId: ", paramString });
      return -1;
    }
    localObject = ((TalkRoom)localObject).agv(a.cOl());
    if (localObject != null)
    {
      com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getSelfMemberId TalkRoomMember is not null groupId: ", paramString, " uuid: ", a.cOl(), " memberId: ", Integer.valueOf(((d)localObject).cRF()) });
      return ((d)localObject).cRF();
    }
    com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getSelfMemberId TalkRoomMember is null" });
    return -1;
  }
  
  public final int agy(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getRountIdByGrouId invalid groupId" });
      return 0;
    }
    TalkRoom localTalkRoom = agw(paramString);
    if (localTalkRoom == null)
    {
      com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getRountIdByGrouId TalkRoom is null  groupId: ", paramString });
      return 0;
    }
    return localTalkRoom.cRt();
  }
  
  public final boolean bS(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "isGroupActiveExceptMySelf groupid is null" });
      return false;
    }
    paramString = agw(paramString);
    if (paramString == null)
    {
      com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "isGroupActiveExceptMySelf talkRoom is null" });
      return false;
    }
    paramString = paramString.cRw();
    if (paramString == null)
    {
      com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "isGroupActiveExceptMySelf TalkRoomMember list is null" });
      return false;
    }
    paramString = paramString.iterator();
    int i = 0;
    int j = 0;
    for (;;)
    {
      label87:
      if (paramString.hasNext())
      {
        d locald = (d)paramString.next();
        if (locald != null)
        {
          TalkRoom.cRs();
          if (locald.getState() != 10) {
            break label182;
          }
          if (locald.cRG()) {
            i = 1;
          }
        }
      }
    }
    label182:
    for (;;)
    {
      if ((paramBoolean) && (j != 0))
      {
        return true;
        j = 1;
      }
      else
      {
        if ((i != 0) && (j != 0))
        {
          com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "isGroupActiveExceptMySelf is true" });
          return true;
        }
        break label87;
        break;
      }
    }
  }
  
  public final boolean d(String paramString1, String paramString2, String... paramVarArgs)
  {
    com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "newTmpGroup groupId: ", paramString1 });
    if (!j.agI(paramString1))
    {
      com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "newTmpGroup invalid clientGroupId" });
      return false;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "newTmpGroup empty uuid array" });
      return false;
    }
    try
    {
      Object localObject = new a.at();
      ((a.at)localObject).bNM = 0;
      ((a.at)localObject).wIC = paramString2;
      ((a.at)localObject).wIB = a.cOl();
      paramString2 = new TalkRoom(paramString1, null, (a.at)localObject);
      int j = paramVarArgs.length;
      int i = 0;
      while (i != j)
      {
        localObject = paramVarArgs[i];
        a.av localav = new a.av();
        localav.wHY = ((String)localObject);
        localav.wJd = a.cOl();
        localav.status = 20;
        localav.iEo = -1;
        localav.wIR = ((int)(System.currentTimeMillis() / 1000L));
        paramString2.a(new d(localav, new a.aw()));
        i += 1;
      }
      this.xdu.put(paramString1, paramString2);
      cRD();
      return true;
    }
    catch (Exception paramString1)
    {
      com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "newTmpGroup err: ", paramString1 });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.c
 * JD-Core Version:    0.7.0.1
 */