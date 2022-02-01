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
  public static h MnB;
  static final String TAG;
  public int CfB;
  public int CfJ;
  public int Cfu;
  public int Cfx;
  public int Cfy;
  int CuJ;
  int CuM;
  int CuQ;
  long CuR;
  int CuW;
  public int CuX;
  private String Cvc;
  public String LFV;
  public int MnC;
  int MnD;
  long MnE;
  long MnF;
  int MnG;
  public int MnH;
  int MnI;
  long MnJ;
  private int MnK;
  private int MnL;
  private String MnM;
  private int MnN;
  private StringBuffer MnO;
  private long MnP;
  long MnQ;
  long MnR;
  private String deviceModel;
  public String groupId;
  public int netType;
  public int oWb;
  public int roomId;
  public long uLt;
  long uMF;
  int uMG;
  
  static
  {
    AppMethodBeat.i(62655);
    MnB = new h();
    TAG = h.class.getCanonicalName();
    AppMethodBeat.o(62655);
  }
  
  public h()
  {
    AppMethodBeat.i(62634);
    this.groupId = "";
    this.LFV = "";
    this.Cfu = 1;
    this.roomId = 0;
    this.uLt = 0L;
    this.oWb = -1;
    this.CuJ = 0;
    this.CuQ = 0;
    this.CuM = 0;
    this.uMG = 0;
    this.MnC = 0;
    this.MnD = 0;
    this.MnE = 0L;
    this.MnF = 0L;
    this.MnG = 0;
    this.MnH = 0;
    this.MnI = 0;
    this.MnJ = 0L;
    this.CuR = 0L;
    this.uMF = 0L;
    this.CuW = 0;
    this.CuX = 0;
    this.netType = -1;
    this.MnL = -1;
    this.Cvc = "";
    this.MnO = new StringBuffer();
    this.CfJ = -1;
    this.CfB = 0;
    this.Cfx = 0;
    this.Cfy = 0;
    this.MnP = 0L;
    this.MnQ = 0L;
    this.MnR = 0L;
    AppMethodBeat.o(62634);
  }
  
  public static void a(int paramInt, long paramLong, String... paramVarArgs)
  {
    AppMethodBeat.i(62639);
    h localh = new h();
    localh.groupId = "";
    localh.roomId = paramInt;
    localh.uLt = paramLong;
    localh.LFV = "";
    localh.af(paramVarArgs);
    baj(localh.fZS());
    e.fTj();
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
    localh.uLt = paramLong;
    localh.af(paramVarArgs);
    baj(localh.fZS());
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
    localh.uLt = paramLong;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localh.LFV = paramString1;
    localh.af(paramVarArgs);
    baj(localh.fZS());
    e.fTj();
    AppMethodBeat.o(62638);
  }
  
  public static void ais(int paramInt)
  {
    AppMethodBeat.i(62645);
    b.d(TAG, new Object[] { "sendNetSceneStat", Integer.valueOf(paramInt) });
    e.S(527, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62645);
  }
  
  public static void ait(int paramInt)
  {
    AppMethodBeat.i(62646);
    b.d(TAG, new Object[] { "sendDeviceStat", Integer.valueOf(paramInt) });
    e.S(528, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62646);
  }
  
  public static void aiu(int paramInt)
  {
    AppMethodBeat.i(62647);
    b.d(TAG, new Object[] { "sendtalkRoomDialStat", Integer.valueOf(paramInt) });
    e.S(530, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62647);
  }
  
  public static void aiv(int paramInt)
  {
    AppMethodBeat.i(62649);
    b.d(TAG, new Object[] { "sendEngineStat", Integer.valueOf(paramInt) });
    e.S(529, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62649);
  }
  
  public static void baj(String paramString)
  {
    AppMethodBeat.i(62650);
    b.d(TAG, new Object[] { "sendSummaryNetScene", paramString });
    e.S(532, 3, paramString);
    AppMethodBeat.o(62650);
  }
  
  public static void bak(String paramString)
  {
    AppMethodBeat.i(62651);
    b.d(TAG, new Object[] { "sendEngineRecv", paramString });
    e.S(533, 3, paramString);
    AppMethodBeat.o(62651);
  }
  
  public static void bal(String paramString)
  {
    AppMethodBeat.i(62652);
    b.d(TAG, new Object[] { "sendEngineSend", paramString });
    e.S(534, 3, paramString);
    AppMethodBeat.o(62652);
  }
  
  public static void bam(String paramString)
  {
    AppMethodBeat.i(62653);
    b.d(TAG, new Object[] { "sendChannelStat", paramString });
    e.S(535, 3, paramString);
    AppMethodBeat.o(62653);
  }
  
  public static void fZX()
  {
    AppMethodBeat.i(62648);
    b.d(TAG, new Object[] { "sendTalkRoomOnDialStat", Integer.valueOf(-5001) });
    e.S(531, 3, "-5001");
    AppMethodBeat.o(62648);
  }
  
  public final void af(String... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(62640);
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      AppMethodBeat.o(62640);
      return;
    }
    if (this.MnO.length() > 900)
    {
      this.MnO.setLength(0);
      this.MnO.append("overmaxsize");
    }
    if (this.MnO.length() != 0) {
      this.MnO.append("-");
    }
    int j = paramVarArgs.length;
    while (i < j)
    {
      String str = paramVarArgs[i];
      this.MnO.append(str);
      this.MnO.append("|");
      i += 1;
    }
    AppMethodBeat.o(62640);
  }
  
  public final void aiw(int paramInt)
  {
    AppMethodBeat.i(62654);
    b.d(TAG, new Object[] { "stopStatus", Integer.valueOf(paramInt) });
    this.CuJ = paramInt;
    AppMethodBeat.o(62654);
  }
  
  public final String fZS()
  {
    AppMethodBeat.i(62636);
    b.d(TAG, new Object[] { "collectInfo" });
    this.MnM = Build.MANUFACTURER;
    this.deviceModel = Build.MODEL;
    this.MnN = Build.VERSION.SDK_INT;
    this.Cvc = Build.VERSION.RELEASE;
    this.netType = k.ls(com.tencent.pb.common.c.c.ClL);
    this.MnK = -1;
    this.MnL = -1;
    Object localObject = new ArrayList();
    ((List)localObject).add(this.groupId);
    ((List)localObject).add(this.LFV);
    ((List)localObject).add(Integer.valueOf(this.Cfu));
    ((List)localObject).add(Integer.valueOf(this.roomId));
    ((List)localObject).add(Long.valueOf(this.uLt));
    ((List)localObject).add(Integer.valueOf(this.oWb));
    ((List)localObject).add(Integer.valueOf(this.CuJ));
    ((List)localObject).add(Integer.valueOf(this.CuQ));
    ((List)localObject).add(Integer.valueOf(this.CuM));
    ((List)localObject).add(Integer.valueOf(this.uMG));
    ((List)localObject).add(Integer.valueOf(this.MnC));
    ((List)localObject).add(Integer.valueOf(this.MnD));
    ((List)localObject).add(Long.valueOf(this.MnE));
    ((List)localObject).add(Long.valueOf(this.MnF));
    ((List)localObject).add(Integer.valueOf(this.MnG));
    ((List)localObject).add(Integer.valueOf(this.MnH));
    ((List)localObject).add(Integer.valueOf(this.MnI));
    ((List)localObject).add(Long.valueOf(this.MnJ));
    ((List)localObject).add(Long.valueOf(this.CuR));
    ((List)localObject).add(Long.valueOf(this.uMF));
    ((List)localObject).add(Integer.valueOf(this.CuW));
    ((List)localObject).add(Integer.valueOf(this.CuX));
    ((List)localObject).add(Integer.valueOf(this.netType));
    ((List)localObject).add(Integer.valueOf(this.MnK));
    ((List)localObject).add(Integer.valueOf(this.MnL));
    ((List)localObject).add(this.MnM);
    ((List)localObject).add(this.deviceModel);
    ((List)localObject).add(Integer.valueOf(this.MnN));
    ((List)localObject).add(this.Cvc);
    ((List)localObject).add(Integer.valueOf(c.fZv().bad(this.groupId)));
    ((List)localObject).add(this.MnO.toString());
    ((List)localObject).add(Integer.valueOf(this.CfJ));
    ((List)localObject).add(Integer.valueOf(this.CfB));
    ((List)localObject).add(Integer.valueOf(this.Cfx));
    ((List)localObject).add(Integer.valueOf(this.Cfy));
    localObject = f.a((Iterable)localObject, ",", "_");
    b.d(TAG, new Object[] { "logBuf: ", this.MnO.toString() });
    b.d(TAG, new Object[] { "statresult", localObject });
    AppMethodBeat.o(62636);
    return localObject;
  }
  
  public final void fZT()
  {
    AppMethodBeat.i(62641);
    this.MnP = System.currentTimeMillis();
    b.d(TAG, new Object[] { "beginCreateOrEnter", Long.valueOf(this.MnP) });
    AppMethodBeat.o(62641);
  }
  
  public final void fZU()
  {
    AppMethodBeat.i(62642);
    b.d(TAG, new Object[] { "endCancelCreate", Long.valueOf(System.currentTimeMillis() - this.MnP), Long.valueOf(this.MnE) });
    if (this.MnE > 0L)
    {
      AppMethodBeat.o(62642);
      return;
    }
    this.CuQ = 1;
    if (this.MnP == 0L)
    {
      this.CuR = 0L;
      AppMethodBeat.o(62642);
      return;
    }
    this.CuR = (System.currentTimeMillis() - this.MnP);
    AppMethodBeat.o(62642);
  }
  
  public final void fZV()
  {
    AppMethodBeat.i(62643);
    b.w(TAG, new Object[] { "beginCreateOrNotify" });
    this.MnQ = System.currentTimeMillis();
    AppMethodBeat.o(62643);
  }
  
  public final void fZW()
  {
    AppMethodBeat.i(62644);
    b.d(TAG, new Object[] { "endAnswerTime", Long.valueOf(this.MnR) });
    if (this.MnR == 0L)
    {
      this.uMF = 0L;
      AppMethodBeat.o(62644);
      return;
    }
    this.uMF = (System.currentTimeMillis() - this.MnR);
    AppMethodBeat.o(62644);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(62635);
    b.d(TAG, new Object[] { "reset" });
    this.MnR = 0L;
    this.MnQ = 0L;
    this.MnP = 0L;
    this.groupId = "";
    this.LFV = "";
    this.Cfu = 1;
    this.roomId = 0;
    this.uLt = 0L;
    this.oWb = -1;
    this.CuJ = 0;
    this.CuQ = 0;
    this.CuM = 0;
    this.uMG = 0;
    this.MnC = 0;
    this.MnD = 0;
    this.MnE = 0L;
    this.MnF = 0L;
    this.MnG = 0;
    this.MnH = 0;
    this.MnI = 0;
    this.MnJ = 0L;
    this.CuR = 0L;
    this.uMF = 0L;
    this.CuW = 0;
    this.CuX = 0;
    this.netType = -1;
    this.MnK = 0;
    this.MnL = 0;
    this.MnM = "";
    this.deviceModel = "";
    this.MnN = -1;
    this.Cvc = "";
    this.MnO.setLength(0);
    this.CfJ = -1;
    this.CfB = 0;
    this.Cfx = 0;
    this.Cfy = 0;
    AppMethodBeat.o(62635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.h
 * JD-Core Version:    0.7.0.1
 */