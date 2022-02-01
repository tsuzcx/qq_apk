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
  public static h KxA;
  static final String TAG;
  public int AGB;
  public int AGI;
  public int AGu;
  public int AGx;
  public int AGy;
  int AUB;
  int AUE;
  int AUI;
  long AUJ;
  int AUO;
  public int AUP;
  private String AUU;
  public String JMm;
  public int KxB;
  int KxC;
  long KxD;
  long KxE;
  int KxF;
  public int KxG;
  int KxH;
  long KxI;
  private int KxJ;
  private int KxK;
  private String KxL;
  private int KxM;
  private StringBuffer KxN;
  private long KxO;
  long KxP;
  long KxQ;
  private String deviceModel;
  public String groupId;
  public int netType;
  public int osF;
  public int roomId;
  public long tIG;
  long tJS;
  int tJT;
  
  static
  {
    AppMethodBeat.i(62655);
    KxA = new h();
    TAG = h.class.getCanonicalName();
    AppMethodBeat.o(62655);
  }
  
  public h()
  {
    AppMethodBeat.i(62634);
    this.groupId = "";
    this.JMm = "";
    this.AGu = 1;
    this.roomId = 0;
    this.tIG = 0L;
    this.osF = -1;
    this.AUB = 0;
    this.AUI = 0;
    this.AUE = 0;
    this.tJT = 0;
    this.KxB = 0;
    this.KxC = 0;
    this.KxD = 0L;
    this.KxE = 0L;
    this.KxF = 0;
    this.KxG = 0;
    this.KxH = 0;
    this.KxI = 0L;
    this.AUJ = 0L;
    this.tJS = 0L;
    this.AUO = 0;
    this.AUP = 0;
    this.netType = -1;
    this.KxK = -1;
    this.AUU = "";
    this.KxN = new StringBuffer();
    this.AGI = -1;
    this.AGB = 0;
    this.AGx = 0;
    this.AGy = 0;
    this.KxO = 0L;
    this.KxP = 0L;
    this.KxQ = 0L;
    AppMethodBeat.o(62634);
  }
  
  public static void a(int paramInt, long paramLong, String... paramVarArgs)
  {
    AppMethodBeat.i(62639);
    h localh = new h();
    localh.groupId = "";
    localh.roomId = paramInt;
    localh.tIG = paramLong;
    localh.JMm = "";
    localh.ad(paramVarArgs);
    aUl(localh.fIB());
    e.fBU();
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
    localh.tIG = paramLong;
    localh.ad(paramVarArgs);
    aUl(localh.fIB());
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
    localh.tIG = paramLong;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localh.JMm = paramString1;
    localh.ad(paramVarArgs);
    aUl(localh.fIB());
    e.fBU();
    AppMethodBeat.o(62638);
  }
  
  public static void aUl(String paramString)
  {
    AppMethodBeat.i(62650);
    b.d(TAG, new Object[] { "sendSummaryNetScene", paramString });
    e.Q(532, 3, paramString);
    AppMethodBeat.o(62650);
  }
  
  public static void aUm(String paramString)
  {
    AppMethodBeat.i(62651);
    b.d(TAG, new Object[] { "sendEngineRecv", paramString });
    e.Q(533, 3, paramString);
    AppMethodBeat.o(62651);
  }
  
  public static void aUn(String paramString)
  {
    AppMethodBeat.i(62652);
    b.d(TAG, new Object[] { "sendEngineSend", paramString });
    e.Q(534, 3, paramString);
    AppMethodBeat.o(62652);
  }
  
  public static void aUo(String paramString)
  {
    AppMethodBeat.i(62653);
    b.d(TAG, new Object[] { "sendChannelStat", paramString });
    e.Q(535, 3, paramString);
    AppMethodBeat.o(62653);
  }
  
  public static void afS(int paramInt)
  {
    AppMethodBeat.i(62645);
    b.d(TAG, new Object[] { "sendNetSceneStat", Integer.valueOf(paramInt) });
    e.Q(527, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62645);
  }
  
  public static void afT(int paramInt)
  {
    AppMethodBeat.i(62646);
    b.d(TAG, new Object[] { "sendDeviceStat", Integer.valueOf(paramInt) });
    e.Q(528, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62646);
  }
  
  public static void afU(int paramInt)
  {
    AppMethodBeat.i(62647);
    b.d(TAG, new Object[] { "sendtalkRoomDialStat", Integer.valueOf(paramInt) });
    e.Q(530, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62647);
  }
  
  public static void afV(int paramInt)
  {
    AppMethodBeat.i(62649);
    b.d(TAG, new Object[] { "sendEngineStat", Integer.valueOf(paramInt) });
    e.Q(529, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62649);
  }
  
  public static void fIG()
  {
    AppMethodBeat.i(62648);
    b.d(TAG, new Object[] { "sendTalkRoomOnDialStat", Integer.valueOf(-5001) });
    e.Q(531, 3, "-5001");
    AppMethodBeat.o(62648);
  }
  
  public final void ad(String... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(62640);
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      AppMethodBeat.o(62640);
      return;
    }
    if (this.KxN.length() > 900)
    {
      this.KxN.setLength(0);
      this.KxN.append("overmaxsize");
    }
    if (this.KxN.length() != 0) {
      this.KxN.append("-");
    }
    int j = paramVarArgs.length;
    while (i < j)
    {
      String str = paramVarArgs[i];
      this.KxN.append(str);
      this.KxN.append("|");
      i += 1;
    }
    AppMethodBeat.o(62640);
  }
  
  public final void afW(int paramInt)
  {
    AppMethodBeat.i(62654);
    b.d(TAG, new Object[] { "stopStatus", Integer.valueOf(paramInt) });
    this.AUB = paramInt;
    AppMethodBeat.o(62654);
  }
  
  public final String fIB()
  {
    AppMethodBeat.i(62636);
    b.d(TAG, new Object[] { "collectInfo" });
    this.KxL = Build.MANUFACTURER;
    this.deviceModel = Build.MODEL;
    this.KxM = Build.VERSION.SDK_INT;
    this.AUU = Build.VERSION.RELEASE;
    this.netType = k.lf(com.tencent.pb.common.c.c.AMx);
    this.KxJ = -1;
    this.KxK = -1;
    Object localObject = new ArrayList();
    ((List)localObject).add(this.groupId);
    ((List)localObject).add(this.JMm);
    ((List)localObject).add(Integer.valueOf(this.AGu));
    ((List)localObject).add(Integer.valueOf(this.roomId));
    ((List)localObject).add(Long.valueOf(this.tIG));
    ((List)localObject).add(Integer.valueOf(this.osF));
    ((List)localObject).add(Integer.valueOf(this.AUB));
    ((List)localObject).add(Integer.valueOf(this.AUI));
    ((List)localObject).add(Integer.valueOf(this.AUE));
    ((List)localObject).add(Integer.valueOf(this.tJT));
    ((List)localObject).add(Integer.valueOf(this.KxB));
    ((List)localObject).add(Integer.valueOf(this.KxC));
    ((List)localObject).add(Long.valueOf(this.KxD));
    ((List)localObject).add(Long.valueOf(this.KxE));
    ((List)localObject).add(Integer.valueOf(this.KxF));
    ((List)localObject).add(Integer.valueOf(this.KxG));
    ((List)localObject).add(Integer.valueOf(this.KxH));
    ((List)localObject).add(Long.valueOf(this.KxI));
    ((List)localObject).add(Long.valueOf(this.AUJ));
    ((List)localObject).add(Long.valueOf(this.tJS));
    ((List)localObject).add(Integer.valueOf(this.AUO));
    ((List)localObject).add(Integer.valueOf(this.AUP));
    ((List)localObject).add(Integer.valueOf(this.netType));
    ((List)localObject).add(Integer.valueOf(this.KxJ));
    ((List)localObject).add(Integer.valueOf(this.KxK));
    ((List)localObject).add(this.KxL);
    ((List)localObject).add(this.deviceModel);
    ((List)localObject).add(Integer.valueOf(this.KxM));
    ((List)localObject).add(this.AUU);
    ((List)localObject).add(Integer.valueOf(c.fIe().aUf(this.groupId)));
    ((List)localObject).add(this.KxN.toString());
    ((List)localObject).add(Integer.valueOf(this.AGI));
    ((List)localObject).add(Integer.valueOf(this.AGB));
    ((List)localObject).add(Integer.valueOf(this.AGx));
    ((List)localObject).add(Integer.valueOf(this.AGy));
    localObject = f.a((Iterable)localObject, ",", "_");
    b.d(TAG, new Object[] { "logBuf: ", this.KxN.toString() });
    b.d(TAG, new Object[] { "statresult", localObject });
    AppMethodBeat.o(62636);
    return localObject;
  }
  
  public final void fIC()
  {
    AppMethodBeat.i(62641);
    this.KxO = System.currentTimeMillis();
    b.d(TAG, new Object[] { "beginCreateOrEnter", Long.valueOf(this.KxO) });
    AppMethodBeat.o(62641);
  }
  
  public final void fID()
  {
    AppMethodBeat.i(62642);
    b.d(TAG, new Object[] { "endCancelCreate", Long.valueOf(System.currentTimeMillis() - this.KxO), Long.valueOf(this.KxD) });
    if (this.KxD > 0L)
    {
      AppMethodBeat.o(62642);
      return;
    }
    this.AUI = 1;
    if (this.KxO == 0L)
    {
      this.AUJ = 0L;
      AppMethodBeat.o(62642);
      return;
    }
    this.AUJ = (System.currentTimeMillis() - this.KxO);
    AppMethodBeat.o(62642);
  }
  
  public final void fIE()
  {
    AppMethodBeat.i(62643);
    b.w(TAG, new Object[] { "beginCreateOrNotify" });
    this.KxP = System.currentTimeMillis();
    AppMethodBeat.o(62643);
  }
  
  public final void fIF()
  {
    AppMethodBeat.i(62644);
    b.d(TAG, new Object[] { "endAnswerTime", Long.valueOf(this.KxQ) });
    if (this.KxQ == 0L)
    {
      this.tJS = 0L;
      AppMethodBeat.o(62644);
      return;
    }
    this.tJS = (System.currentTimeMillis() - this.KxQ);
    AppMethodBeat.o(62644);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(62635);
    b.d(TAG, new Object[] { "reset" });
    this.KxQ = 0L;
    this.KxP = 0L;
    this.KxO = 0L;
    this.groupId = "";
    this.JMm = "";
    this.AGu = 1;
    this.roomId = 0;
    this.tIG = 0L;
    this.osF = -1;
    this.AUB = 0;
    this.AUI = 0;
    this.AUE = 0;
    this.tJT = 0;
    this.KxB = 0;
    this.KxC = 0;
    this.KxD = 0L;
    this.KxE = 0L;
    this.KxF = 0;
    this.KxG = 0;
    this.KxH = 0;
    this.KxI = 0L;
    this.AUJ = 0L;
    this.tJS = 0L;
    this.AUO = 0;
    this.AUP = 0;
    this.netType = -1;
    this.KxJ = 0;
    this.KxK = 0;
    this.KxL = "";
    this.deviceModel = "";
    this.KxM = -1;
    this.AUU = "";
    this.KxN.setLength(0);
    this.AGI = -1;
    this.AGB = 0;
    this.AGx = 0;
    this.AGy = 0;
    AppMethodBeat.o(62635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.h
 * JD-Core Version:    0.7.0.1
 */