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
  public static h ILi;
  static final String TAG;
  public int ILj;
  int ILk;
  long ILl;
  long ILm;
  int ILn;
  public int ILo;
  int ILp;
  long ILq;
  private int ILr;
  private int ILs;
  private String ILt;
  private int ILu;
  private StringBuffer ILv;
  private long ILw;
  long ILx;
  long ILy;
  public String IkB;
  private String deviceModel;
  public String groupId;
  public int nPB;
  public int netType;
  public int roomId;
  public long sAY;
  long sCk;
  int sCl;
  int zCB;
  public int zCC;
  private String zCH;
  int zCo;
  int zCr;
  int zCv;
  long zCw;
  public int znG;
  public int znJ;
  public int znK;
  public int znN;
  public int znU;
  
  static
  {
    AppMethodBeat.i(62655);
    ILi = new h();
    TAG = h.class.getCanonicalName();
    AppMethodBeat.o(62655);
  }
  
  public h()
  {
    AppMethodBeat.i(62634);
    this.groupId = "";
    this.IkB = "";
    this.znG = 1;
    this.roomId = 0;
    this.sAY = 0L;
    this.nPB = -1;
    this.zCo = 0;
    this.zCv = 0;
    this.zCr = 0;
    this.sCl = 0;
    this.ILj = 0;
    this.ILk = 0;
    this.ILl = 0L;
    this.ILm = 0L;
    this.ILn = 0;
    this.ILo = 0;
    this.ILp = 0;
    this.ILq = 0L;
    this.zCw = 0L;
    this.sCk = 0L;
    this.zCB = 0;
    this.zCC = 0;
    this.netType = -1;
    this.ILs = -1;
    this.zCH = "";
    this.ILv = new StringBuffer();
    this.znU = -1;
    this.znN = 0;
    this.znJ = 0;
    this.znK = 0;
    this.ILw = 0L;
    this.ILx = 0L;
    this.ILy = 0L;
    AppMethodBeat.o(62634);
  }
  
  public static void a(int paramInt, long paramLong, String... paramVarArgs)
  {
    AppMethodBeat.i(62639);
    h localh = new h();
    localh.groupId = "";
    localh.roomId = paramInt;
    localh.sAY = paramLong;
    localh.IkB = "";
    localh.ad(paramVarArgs);
    aOz(localh.fqg());
    e.flD();
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
    localh.sAY = paramLong;
    localh.ad(paramVarArgs);
    aOz(localh.fqg());
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
    localh.sAY = paramLong;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localh.IkB = paramString1;
    localh.ad(paramVarArgs);
    aOz(localh.fqg());
    e.flD();
    AppMethodBeat.o(62638);
  }
  
  public static void aOA(String paramString)
  {
    AppMethodBeat.i(62651);
    b.d(TAG, new Object[] { "sendEngineRecv", paramString });
    e.R(533, 3, paramString);
    AppMethodBeat.o(62651);
  }
  
  public static void aOB(String paramString)
  {
    AppMethodBeat.i(62652);
    b.d(TAG, new Object[] { "sendEngineSend", paramString });
    e.R(534, 3, paramString);
    AppMethodBeat.o(62652);
  }
  
  public static void aOC(String paramString)
  {
    AppMethodBeat.i(62653);
    b.d(TAG, new Object[] { "sendChannelStat", paramString });
    e.R(535, 3, paramString);
    AppMethodBeat.o(62653);
  }
  
  public static void aOz(String paramString)
  {
    AppMethodBeat.i(62650);
    b.d(TAG, new Object[] { "sendSummaryNetScene", paramString });
    e.R(532, 3, paramString);
    AppMethodBeat.o(62650);
  }
  
  public static void acW(int paramInt)
  {
    AppMethodBeat.i(62645);
    b.d(TAG, new Object[] { "sendNetSceneStat", Integer.valueOf(paramInt) });
    e.R(527, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62645);
  }
  
  public static void acX(int paramInt)
  {
    AppMethodBeat.i(62646);
    b.d(TAG, new Object[] { "sendDeviceStat", Integer.valueOf(paramInt) });
    e.R(528, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62646);
  }
  
  public static void acY(int paramInt)
  {
    AppMethodBeat.i(62647);
    b.d(TAG, new Object[] { "sendtalkRoomDialStat", Integer.valueOf(paramInt) });
    e.R(530, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62647);
  }
  
  public static void acZ(int paramInt)
  {
    AppMethodBeat.i(62649);
    b.d(TAG, new Object[] { "sendEngineStat", Integer.valueOf(paramInt) });
    e.R(529, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62649);
  }
  
  public static void fql()
  {
    AppMethodBeat.i(62648);
    b.d(TAG, new Object[] { "sendTalkRoomOnDialStat", Integer.valueOf(-5001) });
    e.R(531, 3, "-5001");
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
    if (this.ILv.length() > 900)
    {
      this.ILv.setLength(0);
      this.ILv.append("overmaxsize");
    }
    if (this.ILv.length() != 0) {
      this.ILv.append("-");
    }
    int j = paramVarArgs.length;
    while (i < j)
    {
      String str = paramVarArgs[i];
      this.ILv.append(str);
      this.ILv.append("|");
      i += 1;
    }
    AppMethodBeat.o(62640);
  }
  
  public final void ada(int paramInt)
  {
    AppMethodBeat.i(62654);
    b.d(TAG, new Object[] { "stopStatus", Integer.valueOf(paramInt) });
    this.zCo = paramInt;
    AppMethodBeat.o(62654);
  }
  
  public final String fqg()
  {
    AppMethodBeat.i(62636);
    b.d(TAG, new Object[] { "collectInfo" });
    this.ILt = Build.MANUFACTURER;
    this.deviceModel = Build.MODEL;
    this.ILu = Build.VERSION.SDK_INT;
    this.zCH = Build.VERSION.RELEASE;
    this.netType = k.kR(com.tencent.pb.common.c.c.ztG);
    this.ILr = -1;
    this.ILs = -1;
    Object localObject = new ArrayList();
    ((List)localObject).add(this.groupId);
    ((List)localObject).add(this.IkB);
    ((List)localObject).add(Integer.valueOf(this.znG));
    ((List)localObject).add(Integer.valueOf(this.roomId));
    ((List)localObject).add(Long.valueOf(this.sAY));
    ((List)localObject).add(Integer.valueOf(this.nPB));
    ((List)localObject).add(Integer.valueOf(this.zCo));
    ((List)localObject).add(Integer.valueOf(this.zCv));
    ((List)localObject).add(Integer.valueOf(this.zCr));
    ((List)localObject).add(Integer.valueOf(this.sCl));
    ((List)localObject).add(Integer.valueOf(this.ILj));
    ((List)localObject).add(Integer.valueOf(this.ILk));
    ((List)localObject).add(Long.valueOf(this.ILl));
    ((List)localObject).add(Long.valueOf(this.ILm));
    ((List)localObject).add(Integer.valueOf(this.ILn));
    ((List)localObject).add(Integer.valueOf(this.ILo));
    ((List)localObject).add(Integer.valueOf(this.ILp));
    ((List)localObject).add(Long.valueOf(this.ILq));
    ((List)localObject).add(Long.valueOf(this.zCw));
    ((List)localObject).add(Long.valueOf(this.sCk));
    ((List)localObject).add(Integer.valueOf(this.zCB));
    ((List)localObject).add(Integer.valueOf(this.zCC));
    ((List)localObject).add(Integer.valueOf(this.netType));
    ((List)localObject).add(Integer.valueOf(this.ILr));
    ((List)localObject).add(Integer.valueOf(this.ILs));
    ((List)localObject).add(this.ILt);
    ((List)localObject).add(this.deviceModel);
    ((List)localObject).add(Integer.valueOf(this.ILu));
    ((List)localObject).add(this.zCH);
    ((List)localObject).add(Integer.valueOf(c.fpJ().aOt(this.groupId)));
    ((List)localObject).add(this.ILv.toString());
    ((List)localObject).add(Integer.valueOf(this.znU));
    ((List)localObject).add(Integer.valueOf(this.znN));
    ((List)localObject).add(Integer.valueOf(this.znJ));
    ((List)localObject).add(Integer.valueOf(this.znK));
    localObject = f.a((Iterable)localObject, ",", "_");
    b.d(TAG, new Object[] { "logBuf: ", this.ILv.toString() });
    b.d(TAG, new Object[] { "statresult", localObject });
    AppMethodBeat.o(62636);
    return localObject;
  }
  
  public final void fqh()
  {
    AppMethodBeat.i(62641);
    this.ILw = System.currentTimeMillis();
    b.d(TAG, new Object[] { "beginCreateOrEnter", Long.valueOf(this.ILw) });
    AppMethodBeat.o(62641);
  }
  
  public final void fqi()
  {
    AppMethodBeat.i(62642);
    b.d(TAG, new Object[] { "endCancelCreate", Long.valueOf(System.currentTimeMillis() - this.ILw), Long.valueOf(this.ILl) });
    if (this.ILl > 0L)
    {
      AppMethodBeat.o(62642);
      return;
    }
    this.zCv = 1;
    if (this.ILw == 0L)
    {
      this.zCw = 0L;
      AppMethodBeat.o(62642);
      return;
    }
    this.zCw = (System.currentTimeMillis() - this.ILw);
    AppMethodBeat.o(62642);
  }
  
  public final void fqj()
  {
    AppMethodBeat.i(62643);
    b.w(TAG, new Object[] { "beginCreateOrNotify" });
    this.ILx = System.currentTimeMillis();
    AppMethodBeat.o(62643);
  }
  
  public final void fqk()
  {
    AppMethodBeat.i(62644);
    b.d(TAG, new Object[] { "endAnswerTime", Long.valueOf(this.ILy) });
    if (this.ILy == 0L)
    {
      this.sCk = 0L;
      AppMethodBeat.o(62644);
      return;
    }
    this.sCk = (System.currentTimeMillis() - this.ILy);
    AppMethodBeat.o(62644);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(62635);
    b.d(TAG, new Object[] { "reset" });
    this.ILy = 0L;
    this.ILx = 0L;
    this.ILw = 0L;
    this.groupId = "";
    this.IkB = "";
    this.znG = 1;
    this.roomId = 0;
    this.sAY = 0L;
    this.nPB = -1;
    this.zCo = 0;
    this.zCv = 0;
    this.zCr = 0;
    this.sCl = 0;
    this.ILj = 0;
    this.ILk = 0;
    this.ILl = 0L;
    this.ILm = 0L;
    this.ILn = 0;
    this.ILo = 0;
    this.ILp = 0;
    this.ILq = 0L;
    this.zCw = 0L;
    this.sCk = 0L;
    this.zCB = 0;
    this.zCC = 0;
    this.netType = -1;
    this.ILr = 0;
    this.ILs = 0;
    this.ILt = "";
    this.deviceModel = "";
    this.ILu = -1;
    this.zCH = "";
    this.ILv.setLength(0);
    this.znU = -1;
    this.znN = 0;
    this.znJ = 0;
    this.znK = 0;
    AppMethodBeat.o(62635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.h
 * JD-Core Version:    0.7.0.1
 */