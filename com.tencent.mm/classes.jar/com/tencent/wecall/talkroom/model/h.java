package com.tencent.wecall.talkroom.model;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.pb.common.c.d;
import com.tencent.pb.common.c.f;
import com.tencent.pb.common.c.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class h
{
  static final String TAG = h.class.getCanonicalName();
  public static h xfn = new h();
  String deviceModel;
  public String groupId = "";
  public int iEo = -1;
  public int lpD = 0;
  public long lpE = 0L;
  long lqT = 0L;
  int lqU = 0;
  public int netType = -1;
  public int pUM = 1;
  public int pUP = 0;
  public int pUQ = 0;
  public int pUT = 0;
  public int pVa = -1;
  int qdB = 0;
  long qdC = 0L;
  int qdH = 0;
  public int qdI = 0;
  String qdN = "";
  int qdu = 0;
  int qdx = 0;
  public String wGf = "";
  StringBuffer xfA = new StringBuffer();
  long xfB = 0L;
  long xfC = 0L;
  long xfD = 0L;
  public int xfo = 0;
  int xfp = 0;
  long xfq = 0L;
  long xfr = 0L;
  int xfs = 0;
  public int xft = 0;
  int xfu = 0;
  long xfv = 0L;
  int xfw;
  int xfx = -1;
  String xfy;
  int xfz;
  
  public static void KA(int paramInt)
  {
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "sendNetSceneStat", Integer.valueOf(paramInt) });
    f.y(527, 3, String.valueOf(paramInt));
  }
  
  public static void KB(int paramInt)
  {
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "sendDeviceStat", Integer.valueOf(paramInt) });
    f.y(528, 3, String.valueOf(paramInt));
  }
  
  public static void KC(int paramInt)
  {
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "sendtalkRoomDialStat", Integer.valueOf(paramInt) });
    f.y(530, 3, String.valueOf(paramInt));
  }
  
  public static void KD(int paramInt)
  {
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "sendEngineStat", Integer.valueOf(paramInt) });
    f.y(529, 3, String.valueOf(paramInt));
  }
  
  public static void a(int paramInt, long paramLong, String... paramVarArgs)
  {
    h localh = new h();
    localh.groupId = "";
    localh.lpD = paramInt;
    localh.lpE = paramLong;
    localh.wGf = "";
    localh.R(paramVarArgs);
    agE(localh.cRU());
    f.cOk();
  }
  
  public static void a(String paramString, int paramInt, long paramLong, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.pb.common.c.c.x(TAG, new Object[] { "uploadTempReport groupId is null" });
      return;
    }
    com.tencent.pb.common.c.c.x(TAG, new Object[] { "uploadTempReport: ", paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    h localh = new h();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localh.groupId = str;
    localh.lpD = paramInt;
    localh.lpE = paramLong;
    localh.R(paramVarArgs);
    agE(localh.cRU());
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, long paramLong, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      com.tencent.pb.common.c.c.x(TAG, new Object[] { "uploadTempReport groupId and clientGroupId is null" });
      return;
    }
    com.tencent.pb.common.c.c.x(TAG, new Object[] { "uploadTempReport: ", paramString1, " clientGroupId: ", paramString2, " roomid: ", Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    h localh = new h();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localh.groupId = str;
    localh.lpD = paramInt;
    localh.lpE = paramLong;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localh.wGf = paramString1;
    localh.R(paramVarArgs);
    agE(localh.cRU());
    f.cOk();
  }
  
  public static void agE(String paramString)
  {
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "sendSummaryNetScene", paramString });
    f.y(532, 3, paramString);
  }
  
  public static void agF(String paramString)
  {
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "sendEngineRecv", paramString });
    f.y(533, 3, paramString);
  }
  
  public static void agG(String paramString)
  {
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "sendEngineSend", paramString });
    f.y(534, 3, paramString);
  }
  
  public static void agH(String paramString)
  {
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "sendChannelStat", paramString });
    f.y(535, 3, paramString);
  }
  
  public static void cRX()
  {
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "sendTalkRoomOnDialStat", Integer.valueOf(-5001) });
    f.y(531, 3, "-5001");
  }
  
  public final void KE(int paramInt)
  {
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "stopStatus", Integer.valueOf(paramInt) });
    this.qdu = paramInt;
  }
  
  public final void R(String... paramVarArgs)
  {
    int i = 0;
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    for (;;)
    {
      return;
      if (this.xfA.length() > 900)
      {
        this.xfA.setLength(0);
        this.xfA.append("overmaxsize");
      }
      if (this.xfA.length() != 0) {
        this.xfA.append("-");
      }
      int j = paramVarArgs.length;
      while (i < j)
      {
        String str = paramVarArgs[i];
        this.xfA.append(str);
        this.xfA.append("|");
        i += 1;
      }
    }
  }
  
  public final String cRU()
  {
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "collectInfo" });
    this.xfy = Build.MANUFACTURER;
    this.deviceModel = Build.MODEL;
    this.xfz = Build.VERSION.SDK_INT;
    this.qdN = Build.VERSION.RELEASE;
    this.netType = k.ij(d.pZI);
    this.xfw = -1;
    this.xfx = -1;
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(this.groupId);
    ((List)localObject1).add(this.wGf);
    ((List)localObject1).add(Integer.valueOf(this.pUM));
    ((List)localObject1).add(Integer.valueOf(this.lpD));
    ((List)localObject1).add(Long.valueOf(this.lpE));
    ((List)localObject1).add(Integer.valueOf(this.iEo));
    ((List)localObject1).add(Integer.valueOf(this.qdu));
    ((List)localObject1).add(Integer.valueOf(this.qdB));
    ((List)localObject1).add(Integer.valueOf(this.qdx));
    ((List)localObject1).add(Integer.valueOf(this.lqU));
    ((List)localObject1).add(Integer.valueOf(this.xfo));
    ((List)localObject1).add(Integer.valueOf(this.xfp));
    ((List)localObject1).add(Long.valueOf(this.xfq));
    ((List)localObject1).add(Long.valueOf(this.xfr));
    ((List)localObject1).add(Integer.valueOf(this.xfs));
    ((List)localObject1).add(Integer.valueOf(this.xft));
    ((List)localObject1).add(Integer.valueOf(this.xfu));
    ((List)localObject1).add(Long.valueOf(this.xfv));
    ((List)localObject1).add(Long.valueOf(this.qdC));
    ((List)localObject1).add(Long.valueOf(this.lqT));
    ((List)localObject1).add(Integer.valueOf(this.qdH));
    ((List)localObject1).add(Integer.valueOf(this.qdI));
    ((List)localObject1).add(Integer.valueOf(this.netType));
    ((List)localObject1).add(Integer.valueOf(this.xfw));
    ((List)localObject1).add(Integer.valueOf(this.xfx));
    ((List)localObject1).add(this.xfy);
    ((List)localObject1).add(this.deviceModel);
    ((List)localObject1).add(Integer.valueOf(this.xfz));
    ((List)localObject1).add(this.qdN);
    Object localObject2 = c.cRC();
    String str = this.groupId;
    localObject2 = ((c)localObject2).agw(str);
    int i;
    if (localObject2 == null) {
      i = 0;
    }
    for (;;)
    {
      ((List)localObject1).add(Integer.valueOf(i));
      ((List)localObject1).add(this.xfA.toString());
      ((List)localObject1).add(Integer.valueOf(this.pVa));
      ((List)localObject1).add(Integer.valueOf(this.pUT));
      ((List)localObject1).add(Integer.valueOf(this.pUP));
      ((List)localObject1).add(Integer.valueOf(this.pUQ));
      localObject1 = g.a((Iterable)localObject1, ",", "_");
      com.tencent.pb.common.c.c.d(TAG, new Object[] { "logBuf: ", this.xfA.toString() });
      com.tencent.pb.common.c.c.d(TAG, new Object[] { "statresult", localObject1 });
      return localObject1;
      i = ((TalkRoom)localObject2).xdq.size();
      com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "getGroupMemberSize groupid: ", str, " size: ", Integer.valueOf(i) });
    }
  }
  
  public final void cRV()
  {
    this.xfB = System.currentTimeMillis();
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "beginCreateOrEnter", Long.valueOf(this.xfB) });
  }
  
  public final void cRW()
  {
    com.tencent.pb.common.c.c.x(TAG, new Object[] { "beginCreateOrNotify" });
    this.xfC = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.h
 * JD-Core Version:    0.7.0.1
 */