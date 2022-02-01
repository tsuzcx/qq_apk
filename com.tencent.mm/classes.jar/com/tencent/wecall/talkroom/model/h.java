package com.tencent.wecall.talkroom.model;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.e;
import com.tencent.pb.common.c.f;
import java.util.ArrayList;
import java.util.List;

public class h
{
  static final String TAG;
  public static h aibP;
  public long Hnt;
  long JIe;
  int JIf;
  public int UDI;
  public int UDK;
  public int UDL;
  public int UDO;
  public int UEe;
  private String UXD;
  int UXk;
  int UXn;
  int UXr;
  long UXs;
  int UXx;
  public int UXy;
  public String ahdt;
  public int aibQ;
  int aibR;
  long aibS;
  long aibT;
  int aibU;
  public int aibV;
  int aibW;
  long aibX;
  private int aibY;
  private int aibZ;
  private String aica;
  private int aicb;
  private StringBuffer aicc;
  private long aicd;
  long aice;
  long aicf;
  private String deviceModel;
  public String groupId;
  public int netType;
  public int roomId;
  public int wTC;
  
  static
  {
    AppMethodBeat.i(62655);
    aibP = new h();
    TAG = h.class.getCanonicalName();
    AppMethodBeat.o(62655);
  }
  
  public h()
  {
    AppMethodBeat.i(62634);
    this.groupId = "";
    this.ahdt = "";
    this.UDI = 1;
    this.roomId = 0;
    this.Hnt = 0L;
    this.wTC = -1;
    this.UXk = 0;
    this.UXr = 0;
    this.UXn = 0;
    this.JIf = 0;
    this.aibQ = 0;
    this.aibR = 0;
    this.aibS = 0L;
    this.aibT = 0L;
    this.aibU = 0;
    this.aibV = 0;
    this.aibW = 0;
    this.aibX = 0L;
    this.UXs = 0L;
    this.JIe = 0L;
    this.UXx = 0;
    this.UXy = 0;
    this.netType = -1;
    this.aibZ = -1;
    this.UXD = "";
    this.aicc = new StringBuffer();
    this.UEe = -1;
    this.UDO = 0;
    this.UDK = 0;
    this.UDL = 0;
    this.aicd = 0L;
    this.aice = 0L;
    this.aicf = 0L;
    AppMethodBeat.o(62634);
  }
  
  public static void a(int paramInt, long paramLong, String... paramVarArgs)
  {
    AppMethodBeat.i(62639);
    h localh = new h();
    localh.groupId = "";
    localh.roomId = paramInt;
    localh.Hnt = paramLong;
    localh.ahdt = "";
    localh.ai(paramVarArgs);
    bGO(localh.kez());
    e.jRq();
    AppMethodBeat.o(62639);
  }
  
  public static void a(String paramString, int paramInt, long paramLong, String... paramVarArgs)
  {
    AppMethodBeat.i(62637);
    if (TextUtils.isEmpty(paramString))
    {
      b.w(TAG, new Object[] { "uploadTempReport groupId is null" });
      AppMethodBeat.o(62637);
      return;
    }
    b.w(TAG, new Object[] { "uploadTempReport: ", paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    h localh = new h();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localh.groupId = str;
    localh.roomId = paramInt;
    localh.Hnt = paramLong;
    localh.ai(paramVarArgs);
    bGO(localh.kez());
    AppMethodBeat.o(62637);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, long paramLong, String... paramVarArgs)
  {
    AppMethodBeat.i(62638);
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      b.w(TAG, new Object[] { "uploadTempReport groupId and clientGroupId is null" });
      AppMethodBeat.o(62638);
      return;
    }
    b.w(TAG, new Object[] { "uploadTempReport: ", paramString1, " clientGroupId: ", paramString2, " roomid: ", Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    h localh = new h();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localh.groupId = str;
    localh.roomId = paramInt;
    localh.Hnt = paramLong;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localh.ahdt = paramString1;
    localh.ai(paramVarArgs);
    bGO(localh.kez());
    e.jRq();
    AppMethodBeat.o(62638);
  }
  
  public static void aJl(int paramInt)
  {
    AppMethodBeat.i(62645);
    b.d(TAG, new Object[] { "sendNetSceneStat", Integer.valueOf(paramInt) });
    e.ad(527, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62645);
  }
  
  public static void aJm(int paramInt)
  {
    AppMethodBeat.i(62646);
    b.d(TAG, new Object[] { "sendDeviceStat", Integer.valueOf(paramInt) });
    e.ad(528, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62646);
  }
  
  public static void aJn(int paramInt)
  {
    AppMethodBeat.i(62647);
    b.d(TAG, new Object[] { "sendtalkRoomDialStat", Integer.valueOf(paramInt) });
    e.ad(530, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62647);
  }
  
  public static void aJo(int paramInt)
  {
    AppMethodBeat.i(62649);
    b.d(TAG, new Object[] { "sendEngineStat", Integer.valueOf(paramInt) });
    e.ad(529, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62649);
  }
  
  public static void bGO(String paramString)
  {
    AppMethodBeat.i(62650);
    b.d(TAG, new Object[] { "sendSummaryNetScene", paramString });
    e.ad(532, 3, paramString);
    AppMethodBeat.o(62650);
  }
  
  public static void bGP(String paramString)
  {
    AppMethodBeat.i(62651);
    b.d(TAG, new Object[] { "sendEngineRecv", paramString });
    e.ad(533, 3, paramString);
    AppMethodBeat.o(62651);
  }
  
  public static void bGQ(String paramString)
  {
    AppMethodBeat.i(62652);
    b.d(TAG, new Object[] { "sendEngineSend", paramString });
    e.ad(534, 3, paramString);
    AppMethodBeat.o(62652);
  }
  
  public static void bGR(String paramString)
  {
    AppMethodBeat.i(62653);
    b.d(TAG, new Object[] { "sendChannelStat", paramString });
    e.ad(535, 3, paramString);
    AppMethodBeat.o(62653);
  }
  
  public final void aJp(int paramInt)
  {
    AppMethodBeat.i(62654);
    b.d(TAG, new Object[] { "stopStatus", Integer.valueOf(paramInt) });
    this.UXk = paramInt;
    AppMethodBeat.o(62654);
  }
  
  public final void ai(String... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(62640);
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      AppMethodBeat.o(62640);
      return;
    }
    if (this.aicc.length() > 900)
    {
      this.aicc.setLength(0);
      this.aicc.append("overmaxsize");
    }
    if (this.aicc.length() != 0) {
      this.aicc.append("-");
    }
    int j = paramVarArgs.length;
    while (i < j)
    {
      String str = paramVarArgs[i];
      this.aicc.append(str);
      this.aicc.append("|");
      i += 1;
    }
    AppMethodBeat.o(62640);
  }
  
  public final void keA()
  {
    AppMethodBeat.i(62641);
    this.aicd = System.currentTimeMillis();
    b.d(TAG, new Object[] { "beginCreateOrEnter", Long.valueOf(this.aicd) });
    AppMethodBeat.o(62641);
  }
  
  public final void keB()
  {
    AppMethodBeat.i(62642);
    b.d(TAG, new Object[] { "endCancelCreate", Long.valueOf(System.currentTimeMillis() - this.aicd), Long.valueOf(this.aibS) });
    if (this.aibS > 0L)
    {
      AppMethodBeat.o(62642);
      return;
    }
    this.UXr = 1;
    if (this.aicd == 0L)
    {
      this.UXs = 0L;
      AppMethodBeat.o(62642);
      return;
    }
    this.UXs = (System.currentTimeMillis() - this.aicd);
    AppMethodBeat.o(62642);
  }
  
  public final void keC()
  {
    AppMethodBeat.i(62643);
    b.w(TAG, new Object[] { "beginCreateOrNotify" });
    this.aice = System.currentTimeMillis();
    AppMethodBeat.o(62643);
  }
  
  public final void keD()
  {
    AppMethodBeat.i(62644);
    b.d(TAG, new Object[] { "endAnswerTime", Long.valueOf(this.aicf) });
    if (this.aicf == 0L)
    {
      this.JIe = 0L;
      AppMethodBeat.o(62644);
      return;
    }
    this.JIe = (System.currentTimeMillis() - this.aicf);
    AppMethodBeat.o(62644);
  }
  
  public final String kez()
  {
    AppMethodBeat.i(62636);
    b.d(TAG, new Object[] { "collectInfo" });
    this.aica = Build.MANUFACTURER;
    this.deviceModel = Build.MODEL;
    this.aicb = Build.VERSION.SDK_INT;
    this.UXD = Build.VERSION.RELEASE;
    this.netType = j.oL(com.tencent.pb.common.c.c.UMe);
    this.aibY = -1;
    this.aibZ = -1;
    Object localObject = new ArrayList();
    ((List)localObject).add(this.groupId);
    ((List)localObject).add(this.ahdt);
    ((List)localObject).add(Integer.valueOf(this.UDI));
    ((List)localObject).add(Integer.valueOf(this.roomId));
    ((List)localObject).add(Long.valueOf(this.Hnt));
    ((List)localObject).add(Integer.valueOf(this.wTC));
    ((List)localObject).add(Integer.valueOf(this.UXk));
    ((List)localObject).add(Integer.valueOf(this.UXr));
    ((List)localObject).add(Integer.valueOf(this.UXn));
    ((List)localObject).add(Integer.valueOf(this.JIf));
    ((List)localObject).add(Integer.valueOf(this.aibQ));
    ((List)localObject).add(Integer.valueOf(this.aibR));
    ((List)localObject).add(Long.valueOf(this.aibS));
    ((List)localObject).add(Long.valueOf(this.aibT));
    ((List)localObject).add(Integer.valueOf(this.aibU));
    ((List)localObject).add(Integer.valueOf(this.aibV));
    ((List)localObject).add(Integer.valueOf(this.aibW));
    ((List)localObject).add(Long.valueOf(this.aibX));
    ((List)localObject).add(Long.valueOf(this.UXs));
    ((List)localObject).add(Long.valueOf(this.JIe));
    ((List)localObject).add(Integer.valueOf(this.UXx));
    ((List)localObject).add(Integer.valueOf(this.UXy));
    ((List)localObject).add(Integer.valueOf(this.netType));
    ((List)localObject).add(Integer.valueOf(this.aibY));
    ((List)localObject).add(Integer.valueOf(this.aibZ));
    ((List)localObject).add(this.aica);
    ((List)localObject).add(this.deviceModel);
    ((List)localObject).add(Integer.valueOf(this.aicb));
    ((List)localObject).add(this.UXD);
    ((List)localObject).add(Integer.valueOf(c.ked().bGI(this.groupId)));
    ((List)localObject).add(this.aicc.toString());
    ((List)localObject).add(Integer.valueOf(this.UEe));
    ((List)localObject).add(Integer.valueOf(this.UDO));
    ((List)localObject).add(Integer.valueOf(this.UDK));
    ((List)localObject).add(Integer.valueOf(this.UDL));
    localObject = f.a((Iterable)localObject, ",", "_");
    b.d(TAG, new Object[] { "logBuf: ", this.aicc.toString() });
    b.d(TAG, new Object[] { "statresult", localObject });
    AppMethodBeat.o(62636);
    return localObject;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(62635);
    b.d(TAG, new Object[] { "reset" });
    this.aicf = 0L;
    this.aice = 0L;
    this.aicd = 0L;
    this.groupId = "";
    this.ahdt = "";
    this.UDI = 1;
    this.roomId = 0;
    this.Hnt = 0L;
    this.wTC = -1;
    this.UXk = 0;
    this.UXr = 0;
    this.UXn = 0;
    this.JIf = 0;
    this.aibQ = 0;
    this.aibR = 0;
    this.aibS = 0L;
    this.aibT = 0L;
    this.aibU = 0;
    this.aibV = 0;
    this.aibW = 0;
    this.aibX = 0L;
    this.UXs = 0L;
    this.JIe = 0L;
    this.UXx = 0;
    this.UXy = 0;
    this.netType = -1;
    this.aibY = 0;
    this.aibZ = 0;
    this.aica = "";
    this.deviceModel = "";
    this.aicb = -1;
    this.UXD = "";
    this.aicc.setLength(0);
    this.UEe = -1;
    this.UDO = 0;
    this.UDK = 0;
    this.UDL = 0;
    AppMethodBeat.o(62635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.h
 * JD-Core Version:    0.7.0.1
 */