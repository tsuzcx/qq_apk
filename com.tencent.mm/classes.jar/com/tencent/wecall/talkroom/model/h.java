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
  public static h ZXq;
  public long DPJ;
  long DQU;
  int DQV;
  public int NQW;
  public int NQY;
  public int NQZ;
  public int NRc;
  public int NRk;
  int OiP;
  int OiS;
  int OiW;
  long OiX;
  int Ojc;
  public int Ojd;
  private String Oji;
  private int ZXA;
  private String ZXB;
  private int ZXC;
  private StringBuffer ZXD;
  private long ZXE;
  long ZXF;
  long ZXG;
  public int ZXr;
  int ZXs;
  long ZXt;
  long ZXu;
  int ZXv;
  public int ZXw;
  int ZXx;
  long ZXy;
  private int ZXz;
  public String ZeQ;
  private String deviceModel;
  public String groupId;
  public int netType;
  public int roomId;
  public int tQm;
  
  static
  {
    AppMethodBeat.i(62655);
    ZXq = new h();
    TAG = h.class.getCanonicalName();
    AppMethodBeat.o(62655);
  }
  
  public h()
  {
    AppMethodBeat.i(62634);
    this.groupId = "";
    this.ZeQ = "";
    this.NQW = 1;
    this.roomId = 0;
    this.DPJ = 0L;
    this.tQm = -1;
    this.OiP = 0;
    this.OiW = 0;
    this.OiS = 0;
    this.DQV = 0;
    this.ZXr = 0;
    this.ZXs = 0;
    this.ZXt = 0L;
    this.ZXu = 0L;
    this.ZXv = 0;
    this.ZXw = 0;
    this.ZXx = 0;
    this.ZXy = 0L;
    this.OiX = 0L;
    this.DQU = 0L;
    this.Ojc = 0;
    this.Ojd = 0;
    this.netType = -1;
    this.ZXA = -1;
    this.Oji = "";
    this.ZXD = new StringBuffer();
    this.NRk = -1;
    this.NRc = 0;
    this.NQY = 0;
    this.NQZ = 0;
    this.ZXE = 0L;
    this.ZXF = 0L;
    this.ZXG = 0L;
    AppMethodBeat.o(62634);
  }
  
  public static void a(int paramInt, long paramLong, String... paramVarArgs)
  {
    AppMethodBeat.i(62639);
    h localh = new h();
    localh.groupId = "";
    localh.roomId = paramInt;
    localh.DPJ = paramLong;
    localh.ZeQ = "";
    localh.ag(paramVarArgs);
    bEp(localh.ivd());
    e.ikZ();
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
    localh.DPJ = paramLong;
    localh.ag(paramVarArgs);
    bEp(localh.ivd());
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
    localh.DPJ = paramLong;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localh.ZeQ = paramString1;
    localh.ag(paramVarArgs);
    bEp(localh.ivd());
    e.ikZ();
    AppMethodBeat.o(62638);
  }
  
  public static void aCA(int paramInt)
  {
    AppMethodBeat.i(62647);
    b.d(TAG, new Object[] { "sendtalkRoomDialStat", Integer.valueOf(paramInt) });
    e.S(530, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62647);
  }
  
  public static void aCB(int paramInt)
  {
    AppMethodBeat.i(62649);
    b.d(TAG, new Object[] { "sendEngineStat", Integer.valueOf(paramInt) });
    e.S(529, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62649);
  }
  
  public static void aCy(int paramInt)
  {
    AppMethodBeat.i(62645);
    b.d(TAG, new Object[] { "sendNetSceneStat", Integer.valueOf(paramInt) });
    e.S(527, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62645);
  }
  
  public static void aCz(int paramInt)
  {
    AppMethodBeat.i(62646);
    b.d(TAG, new Object[] { "sendDeviceStat", Integer.valueOf(paramInt) });
    e.S(528, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62646);
  }
  
  public static void bEp(String paramString)
  {
    AppMethodBeat.i(62650);
    b.d(TAG, new Object[] { "sendSummaryNetScene", paramString });
    e.S(532, 3, paramString);
    AppMethodBeat.o(62650);
  }
  
  public static void bEq(String paramString)
  {
    AppMethodBeat.i(62651);
    b.d(TAG, new Object[] { "sendEngineRecv", paramString });
    e.S(533, 3, paramString);
    AppMethodBeat.o(62651);
  }
  
  public static void bEr(String paramString)
  {
    AppMethodBeat.i(62652);
    b.d(TAG, new Object[] { "sendEngineSend", paramString });
    e.S(534, 3, paramString);
    AppMethodBeat.o(62652);
  }
  
  public static void bEs(String paramString)
  {
    AppMethodBeat.i(62653);
    b.d(TAG, new Object[] { "sendChannelStat", paramString });
    e.S(535, 3, paramString);
    AppMethodBeat.o(62653);
  }
  
  public final void aCC(int paramInt)
  {
    AppMethodBeat.i(62654);
    b.d(TAG, new Object[] { "stopStatus", Integer.valueOf(paramInt) });
    this.OiP = paramInt;
    AppMethodBeat.o(62654);
  }
  
  public final void ag(String... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(62640);
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      AppMethodBeat.o(62640);
      return;
    }
    if (this.ZXD.length() > 900)
    {
      this.ZXD.setLength(0);
      this.ZXD.append("overmaxsize");
    }
    if (this.ZXD.length() != 0) {
      this.ZXD.append("-");
    }
    int j = paramVarArgs.length;
    while (i < j)
    {
      String str = paramVarArgs[i];
      this.ZXD.append(str);
      this.ZXD.append("|");
      i += 1;
    }
    AppMethodBeat.o(62640);
  }
  
  public final String ivd()
  {
    AppMethodBeat.i(62636);
    b.d(TAG, new Object[] { "collectInfo" });
    this.ZXB = Build.MANUFACTURER;
    this.deviceModel = Build.MODEL;
    this.ZXC = Build.VERSION.SDK_INT;
    this.Oji = Build.VERSION.RELEASE;
    this.netType = j.mv(com.tencent.pb.common.c.c.NYh);
    this.ZXz = -1;
    this.ZXA = -1;
    Object localObject = new ArrayList();
    ((List)localObject).add(this.groupId);
    ((List)localObject).add(this.ZeQ);
    ((List)localObject).add(Integer.valueOf(this.NQW));
    ((List)localObject).add(Integer.valueOf(this.roomId));
    ((List)localObject).add(Long.valueOf(this.DPJ));
    ((List)localObject).add(Integer.valueOf(this.tQm));
    ((List)localObject).add(Integer.valueOf(this.OiP));
    ((List)localObject).add(Integer.valueOf(this.OiW));
    ((List)localObject).add(Integer.valueOf(this.OiS));
    ((List)localObject).add(Integer.valueOf(this.DQV));
    ((List)localObject).add(Integer.valueOf(this.ZXr));
    ((List)localObject).add(Integer.valueOf(this.ZXs));
    ((List)localObject).add(Long.valueOf(this.ZXt));
    ((List)localObject).add(Long.valueOf(this.ZXu));
    ((List)localObject).add(Integer.valueOf(this.ZXv));
    ((List)localObject).add(Integer.valueOf(this.ZXw));
    ((List)localObject).add(Integer.valueOf(this.ZXx));
    ((List)localObject).add(Long.valueOf(this.ZXy));
    ((List)localObject).add(Long.valueOf(this.OiX));
    ((List)localObject).add(Long.valueOf(this.DQU));
    ((List)localObject).add(Integer.valueOf(this.Ojc));
    ((List)localObject).add(Integer.valueOf(this.Ojd));
    ((List)localObject).add(Integer.valueOf(this.netType));
    ((List)localObject).add(Integer.valueOf(this.ZXz));
    ((List)localObject).add(Integer.valueOf(this.ZXA));
    ((List)localObject).add(this.ZXB);
    ((List)localObject).add(this.deviceModel);
    ((List)localObject).add(Integer.valueOf(this.ZXC));
    ((List)localObject).add(this.Oji);
    ((List)localObject).add(Integer.valueOf(c.iuI().bEj(this.groupId)));
    ((List)localObject).add(this.ZXD.toString());
    ((List)localObject).add(Integer.valueOf(this.NRk));
    ((List)localObject).add(Integer.valueOf(this.NRc));
    ((List)localObject).add(Integer.valueOf(this.NQY));
    ((List)localObject).add(Integer.valueOf(this.NQZ));
    localObject = f.a((Iterable)localObject, ",", "_");
    b.d(TAG, new Object[] { "logBuf: ", this.ZXD.toString() });
    b.d(TAG, new Object[] { "statresult", localObject });
    AppMethodBeat.o(62636);
    return localObject;
  }
  
  public final void ive()
  {
    AppMethodBeat.i(62641);
    this.ZXE = System.currentTimeMillis();
    b.d(TAG, new Object[] { "beginCreateOrEnter", Long.valueOf(this.ZXE) });
    AppMethodBeat.o(62641);
  }
  
  public final void ivf()
  {
    AppMethodBeat.i(62642);
    b.d(TAG, new Object[] { "endCancelCreate", Long.valueOf(System.currentTimeMillis() - this.ZXE), Long.valueOf(this.ZXt) });
    if (this.ZXt > 0L)
    {
      AppMethodBeat.o(62642);
      return;
    }
    this.OiW = 1;
    if (this.ZXE == 0L)
    {
      this.OiX = 0L;
      AppMethodBeat.o(62642);
      return;
    }
    this.OiX = (System.currentTimeMillis() - this.ZXE);
    AppMethodBeat.o(62642);
  }
  
  public final void ivg()
  {
    AppMethodBeat.i(62643);
    b.w(TAG, new Object[] { "beginCreateOrNotify" });
    this.ZXF = System.currentTimeMillis();
    AppMethodBeat.o(62643);
  }
  
  public final void ivh()
  {
    AppMethodBeat.i(62644);
    b.d(TAG, new Object[] { "endAnswerTime", Long.valueOf(this.ZXG) });
    if (this.ZXG == 0L)
    {
      this.DQU = 0L;
      AppMethodBeat.o(62644);
      return;
    }
    this.DQU = (System.currentTimeMillis() - this.ZXG);
    AppMethodBeat.o(62644);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(62635);
    b.d(TAG, new Object[] { "reset" });
    this.ZXG = 0L;
    this.ZXF = 0L;
    this.ZXE = 0L;
    this.groupId = "";
    this.ZeQ = "";
    this.NQW = 1;
    this.roomId = 0;
    this.DPJ = 0L;
    this.tQm = -1;
    this.OiP = 0;
    this.OiW = 0;
    this.OiS = 0;
    this.DQV = 0;
    this.ZXr = 0;
    this.ZXs = 0;
    this.ZXt = 0L;
    this.ZXu = 0L;
    this.ZXv = 0;
    this.ZXw = 0;
    this.ZXx = 0;
    this.ZXy = 0L;
    this.OiX = 0L;
    this.DQU = 0L;
    this.Ojc = 0;
    this.Ojd = 0;
    this.netType = -1;
    this.ZXz = 0;
    this.ZXA = 0;
    this.ZXB = "";
    this.deviceModel = "";
    this.ZXC = -1;
    this.Oji = "";
    this.ZXD.setLength(0);
    this.NRk = -1;
    this.NRc = 0;
    this.NQY = 0;
    this.NQZ = 0;
    AppMethodBeat.o(62635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.h
 * JD-Core Version:    0.7.0.1
 */