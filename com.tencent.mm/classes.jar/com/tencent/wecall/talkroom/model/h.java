package com.tencent.wecall.talkroom.model;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.d;
import com.tencent.pb.common.c.f;
import com.tencent.pb.common.c.g;
import java.util.ArrayList;
import java.util.List;

public class h
{
  public static h BBU;
  static final String TAG;
  public int BBV;
  int BBW;
  long BBX;
  long BBY;
  int BBZ;
  public int BCa;
  int BCb;
  long BCc;
  private int BCd;
  private int BCe;
  private String BCf;
  private int BCg;
  private StringBuffer BCh;
  private long BCi;
  long BCj;
  long BCk;
  public String BdG;
  private String deviceModel;
  public String groupId;
  public int kJx;
  public int nMZ;
  public long nNa;
  long nOp;
  int nOq;
  public int netType;
  public int tAC;
  public int tAo;
  public int tAr;
  public int tAs;
  public int tAv;
  private String tKA;
  int tKh;
  int tKk;
  int tKo;
  long tKp;
  int tKu;
  public int tKv;
  
  static
  {
    AppMethodBeat.i(127999);
    BBU = new h();
    TAG = h.class.getCanonicalName();
    AppMethodBeat.o(127999);
  }
  
  public h()
  {
    AppMethodBeat.i(127978);
    this.groupId = "";
    this.BdG = "";
    this.tAo = 1;
    this.nMZ = 0;
    this.nNa = 0L;
    this.kJx = -1;
    this.tKh = 0;
    this.tKo = 0;
    this.tKk = 0;
    this.nOq = 0;
    this.BBV = 0;
    this.BBW = 0;
    this.BBX = 0L;
    this.BBY = 0L;
    this.BBZ = 0;
    this.BCa = 0;
    this.BCb = 0;
    this.BCc = 0L;
    this.tKp = 0L;
    this.nOp = 0L;
    this.tKu = 0;
    this.tKv = 0;
    this.netType = -1;
    this.BCe = -1;
    this.tKA = "";
    this.BCh = new StringBuffer();
    this.tAC = -1;
    this.tAv = 0;
    this.tAr = 0;
    this.tAs = 0;
    this.BCi = 0L;
    this.BCj = 0L;
    this.BCk = 0L;
    AppMethodBeat.o(127978);
  }
  
  public static void Tt(int paramInt)
  {
    AppMethodBeat.i(127989);
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "sendNetSceneStat", Integer.valueOf(paramInt) });
    f.F(527, 3, String.valueOf(paramInt));
    AppMethodBeat.o(127989);
  }
  
  public static void Tu(int paramInt)
  {
    AppMethodBeat.i(127990);
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "sendDeviceStat", Integer.valueOf(paramInt) });
    f.F(528, 3, String.valueOf(paramInt));
    AppMethodBeat.o(127990);
  }
  
  public static void Tv(int paramInt)
  {
    AppMethodBeat.i(127991);
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "sendtalkRoomDialStat", Integer.valueOf(paramInt) });
    f.F(530, 3, String.valueOf(paramInt));
    AppMethodBeat.o(127991);
  }
  
  public static void Tw(int paramInt)
  {
    AppMethodBeat.i(127993);
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "sendEngineStat", Integer.valueOf(paramInt) });
    f.F(529, 3, String.valueOf(paramInt));
    AppMethodBeat.o(127993);
  }
  
  public static void a(int paramInt, long paramLong, String... paramVarArgs)
  {
    AppMethodBeat.i(127983);
    h localh = new h();
    localh.groupId = "";
    localh.nMZ = paramInt;
    localh.nNa = paramLong;
    localh.BdG = "";
    localh.aa(paramVarArgs);
    axz(localh.dXP());
    f.dTW();
    AppMethodBeat.o(127983);
  }
  
  public static void a(String paramString, int paramInt, long paramLong, String... paramVarArgs)
  {
    AppMethodBeat.i(127981);
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.pb.common.c.c.w(TAG, new Object[] { "uploadTempReport groupId is null" });
      AppMethodBeat.o(127981);
      return;
    }
    com.tencent.pb.common.c.c.w(TAG, new Object[] { "uploadTempReport: ", paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    h localh = new h();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localh.groupId = str;
    localh.nMZ = paramInt;
    localh.nNa = paramLong;
    localh.aa(paramVarArgs);
    axz(localh.dXP());
    AppMethodBeat.o(127981);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, long paramLong, String... paramVarArgs)
  {
    AppMethodBeat.i(127982);
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      com.tencent.pb.common.c.c.w(TAG, new Object[] { "uploadTempReport groupId and clientGroupId is null" });
      AppMethodBeat.o(127982);
      return;
    }
    com.tencent.pb.common.c.c.w(TAG, new Object[] { "uploadTempReport: ", paramString1, " clientGroupId: ", paramString2, " roomid: ", Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    h localh = new h();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localh.groupId = str;
    localh.nMZ = paramInt;
    localh.nNa = paramLong;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localh.BdG = paramString1;
    localh.aa(paramVarArgs);
    axz(localh.dXP());
    f.dTW();
    AppMethodBeat.o(127982);
  }
  
  public static void axA(String paramString)
  {
    AppMethodBeat.i(127995);
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "sendEngineRecv", paramString });
    f.F(533, 3, paramString);
    AppMethodBeat.o(127995);
  }
  
  public static void axB(String paramString)
  {
    AppMethodBeat.i(127996);
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "sendEngineSend", paramString });
    f.F(534, 3, paramString);
    AppMethodBeat.o(127996);
  }
  
  public static void axC(String paramString)
  {
    AppMethodBeat.i(127997);
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "sendChannelStat", paramString });
    f.F(535, 3, paramString);
    AppMethodBeat.o(127997);
  }
  
  public static void axz(String paramString)
  {
    AppMethodBeat.i(127994);
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "sendSummaryNetScene", paramString });
    f.F(532, 3, paramString);
    AppMethodBeat.o(127994);
  }
  
  public static void dXU()
  {
    AppMethodBeat.i(127992);
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "sendTalkRoomOnDialStat", Integer.valueOf(-5001) });
    f.F(531, 3, "-5001");
    AppMethodBeat.o(127992);
  }
  
  public final void Tx(int paramInt)
  {
    AppMethodBeat.i(127998);
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "stopStatus", Integer.valueOf(paramInt) });
    this.tKh = paramInt;
    AppMethodBeat.o(127998);
  }
  
  public final void aa(String... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(127984);
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      AppMethodBeat.o(127984);
      return;
    }
    if (this.BCh.length() > 900)
    {
      this.BCh.setLength(0);
      this.BCh.append("overmaxsize");
    }
    if (this.BCh.length() != 0) {
      this.BCh.append("-");
    }
    int j = paramVarArgs.length;
    while (i < j)
    {
      String str = paramVarArgs[i];
      this.BCh.append(str);
      this.BCh.append("|");
      i += 1;
    }
    AppMethodBeat.o(127984);
  }
  
  public final String dXP()
  {
    AppMethodBeat.i(127980);
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "collectInfo" });
    this.BCf = Build.MANUFACTURER;
    this.deviceModel = Build.MODEL;
    this.BCg = Build.VERSION.SDK_INT;
    this.tKA = Build.VERSION.RELEASE;
    this.netType = k.jN(d.tFk);
    this.BCd = -1;
    this.BCe = -1;
    Object localObject = new ArrayList();
    ((List)localObject).add(this.groupId);
    ((List)localObject).add(this.BdG);
    ((List)localObject).add(Integer.valueOf(this.tAo));
    ((List)localObject).add(Integer.valueOf(this.nMZ));
    ((List)localObject).add(Long.valueOf(this.nNa));
    ((List)localObject).add(Integer.valueOf(this.kJx));
    ((List)localObject).add(Integer.valueOf(this.tKh));
    ((List)localObject).add(Integer.valueOf(this.tKo));
    ((List)localObject).add(Integer.valueOf(this.tKk));
    ((List)localObject).add(Integer.valueOf(this.nOq));
    ((List)localObject).add(Integer.valueOf(this.BBV));
    ((List)localObject).add(Integer.valueOf(this.BBW));
    ((List)localObject).add(Long.valueOf(this.BBX));
    ((List)localObject).add(Long.valueOf(this.BBY));
    ((List)localObject).add(Integer.valueOf(this.BBZ));
    ((List)localObject).add(Integer.valueOf(this.BCa));
    ((List)localObject).add(Integer.valueOf(this.BCb));
    ((List)localObject).add(Long.valueOf(this.BCc));
    ((List)localObject).add(Long.valueOf(this.tKp));
    ((List)localObject).add(Long.valueOf(this.nOp));
    ((List)localObject).add(Integer.valueOf(this.tKu));
    ((List)localObject).add(Integer.valueOf(this.tKv));
    ((List)localObject).add(Integer.valueOf(this.netType));
    ((List)localObject).add(Integer.valueOf(this.BCd));
    ((List)localObject).add(Integer.valueOf(this.BCe));
    ((List)localObject).add(this.BCf);
    ((List)localObject).add(this.deviceModel);
    ((List)localObject).add(Integer.valueOf(this.BCg));
    ((List)localObject).add(this.tKA);
    ((List)localObject).add(Integer.valueOf(c.dXv().axt(this.groupId)));
    ((List)localObject).add(this.BCh.toString());
    ((List)localObject).add(Integer.valueOf(this.tAC));
    ((List)localObject).add(Integer.valueOf(this.tAv));
    ((List)localObject).add(Integer.valueOf(this.tAr));
    ((List)localObject).add(Integer.valueOf(this.tAs));
    localObject = g.a((Iterable)localObject, ",", "_");
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "logBuf: ", this.BCh.toString() });
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "statresult", localObject });
    AppMethodBeat.o(127980);
    return localObject;
  }
  
  public final void dXQ()
  {
    AppMethodBeat.i(127985);
    this.BCi = System.currentTimeMillis();
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "beginCreateOrEnter", Long.valueOf(this.BCi) });
    AppMethodBeat.o(127985);
  }
  
  public final void dXR()
  {
    AppMethodBeat.i(127986);
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "endCancelCreate", Long.valueOf(System.currentTimeMillis() - this.BCi), Long.valueOf(this.BBX) });
    if (this.BBX > 0L)
    {
      AppMethodBeat.o(127986);
      return;
    }
    this.tKo = 1;
    if (this.BCi == 0L)
    {
      this.tKp = 0L;
      AppMethodBeat.o(127986);
      return;
    }
    this.tKp = (System.currentTimeMillis() - this.BCi);
    AppMethodBeat.o(127986);
  }
  
  public final void dXS()
  {
    AppMethodBeat.i(127987);
    com.tencent.pb.common.c.c.w(TAG, new Object[] { "beginCreateOrNotify" });
    this.BCj = System.currentTimeMillis();
    AppMethodBeat.o(127987);
  }
  
  public final void dXT()
  {
    AppMethodBeat.i(127988);
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "endAnswerTime", Long.valueOf(this.BCk) });
    if (this.BCk == 0L)
    {
      this.nOp = 0L;
      AppMethodBeat.o(127988);
      return;
    }
    this.nOp = (System.currentTimeMillis() - this.BCk);
    AppMethodBeat.o(127988);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(127979);
    com.tencent.pb.common.c.c.d(TAG, new Object[] { "reset" });
    this.BCk = 0L;
    this.BCj = 0L;
    this.BCi = 0L;
    this.groupId = "";
    this.BdG = "";
    this.tAo = 1;
    this.nMZ = 0;
    this.nNa = 0L;
    this.kJx = -1;
    this.tKh = 0;
    this.tKo = 0;
    this.tKk = 0;
    this.nOq = 0;
    this.BBV = 0;
    this.BBW = 0;
    this.BBX = 0L;
    this.BBY = 0L;
    this.BBZ = 0;
    this.BCa = 0;
    this.BCb = 0;
    this.BCc = 0L;
    this.tKp = 0L;
    this.nOp = 0L;
    this.tKu = 0;
    this.tKv = 0;
    this.netType = -1;
    this.BCd = 0;
    this.BCe = 0;
    this.BCf = "";
    this.deviceModel = "";
    this.BCg = -1;
    this.tKA = "";
    this.BCh.setLength(0);
    this.tAC = -1;
    this.tAv = 0;
    this.tAr = 0;
    this.tAs = 0;
    AppMethodBeat.o(127979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.h
 * JD-Core Version:    0.7.0.1
 */