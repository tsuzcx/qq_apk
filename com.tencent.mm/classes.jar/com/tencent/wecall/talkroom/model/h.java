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
  public static h MKx;
  static final String TAG;
  int CMB;
  public int CMC;
  private String CMH;
  int CMo;
  int CMr;
  int CMv;
  long CMw;
  public int CwV;
  public int CwY;
  public int CwZ;
  public int Cxc;
  public int Cxk;
  long MKA;
  long MKB;
  int MKC;
  public int MKD;
  int MKE;
  long MKF;
  private int MKG;
  private int MKH;
  private String MKI;
  private int MKJ;
  private StringBuffer MKK;
  private long MKL;
  long MKM;
  long MKN;
  public int MKy;
  int MKz;
  public String McZ;
  private String deviceModel;
  public String groupId;
  public int netType;
  public int pcE;
  public int roomId;
  public long uXg;
  long uYs;
  int uYt;
  
  static
  {
    AppMethodBeat.i(62655);
    MKx = new h();
    TAG = h.class.getCanonicalName();
    AppMethodBeat.o(62655);
  }
  
  public h()
  {
    AppMethodBeat.i(62634);
    this.groupId = "";
    this.McZ = "";
    this.CwV = 1;
    this.roomId = 0;
    this.uXg = 0L;
    this.pcE = -1;
    this.CMo = 0;
    this.CMv = 0;
    this.CMr = 0;
    this.uYt = 0;
    this.MKy = 0;
    this.MKz = 0;
    this.MKA = 0L;
    this.MKB = 0L;
    this.MKC = 0;
    this.MKD = 0;
    this.MKE = 0;
    this.MKF = 0L;
    this.CMw = 0L;
    this.uYs = 0L;
    this.CMB = 0;
    this.CMC = 0;
    this.netType = -1;
    this.MKH = -1;
    this.CMH = "";
    this.MKK = new StringBuffer();
    this.Cxk = -1;
    this.Cxc = 0;
    this.CwY = 0;
    this.CwZ = 0;
    this.MKL = 0L;
    this.MKM = 0L;
    this.MKN = 0L;
    AppMethodBeat.o(62634);
  }
  
  public static void a(int paramInt, long paramLong, String... paramVarArgs)
  {
    AppMethodBeat.i(62639);
    h localh = new h();
    localh.groupId = "";
    localh.roomId = paramInt;
    localh.uXg = paramLong;
    localh.McZ = "";
    localh.af(paramVarArgs);
    bbM(localh.geu());
    e.fXJ();
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
    localh.uXg = paramLong;
    localh.af(paramVarArgs);
    bbM(localh.geu());
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
    localh.uXg = paramLong;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localh.McZ = paramString1;
    localh.af(paramVarArgs);
    bbM(localh.geu());
    e.fXJ();
    AppMethodBeat.o(62638);
  }
  
  public static void ajb(int paramInt)
  {
    AppMethodBeat.i(62645);
    b.d(TAG, new Object[] { "sendNetSceneStat", Integer.valueOf(paramInt) });
    e.S(527, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62645);
  }
  
  public static void ajc(int paramInt)
  {
    AppMethodBeat.i(62646);
    b.d(TAG, new Object[] { "sendDeviceStat", Integer.valueOf(paramInt) });
    e.S(528, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62646);
  }
  
  public static void ajd(int paramInt)
  {
    AppMethodBeat.i(62647);
    b.d(TAG, new Object[] { "sendtalkRoomDialStat", Integer.valueOf(paramInt) });
    e.S(530, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62647);
  }
  
  public static void aje(int paramInt)
  {
    AppMethodBeat.i(62649);
    b.d(TAG, new Object[] { "sendEngineStat", Integer.valueOf(paramInt) });
    e.S(529, 3, String.valueOf(paramInt));
    AppMethodBeat.o(62649);
  }
  
  public static void bbM(String paramString)
  {
    AppMethodBeat.i(62650);
    b.d(TAG, new Object[] { "sendSummaryNetScene", paramString });
    e.S(532, 3, paramString);
    AppMethodBeat.o(62650);
  }
  
  public static void bbN(String paramString)
  {
    AppMethodBeat.i(62651);
    b.d(TAG, new Object[] { "sendEngineRecv", paramString });
    e.S(533, 3, paramString);
    AppMethodBeat.o(62651);
  }
  
  public static void bbO(String paramString)
  {
    AppMethodBeat.i(62652);
    b.d(TAG, new Object[] { "sendEngineSend", paramString });
    e.S(534, 3, paramString);
    AppMethodBeat.o(62652);
  }
  
  public static void bbP(String paramString)
  {
    AppMethodBeat.i(62653);
    b.d(TAG, new Object[] { "sendChannelStat", paramString });
    e.S(535, 3, paramString);
    AppMethodBeat.o(62653);
  }
  
  public static void gez()
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
    if (this.MKK.length() > 900)
    {
      this.MKK.setLength(0);
      this.MKK.append("overmaxsize");
    }
    if (this.MKK.length() != 0) {
      this.MKK.append("-");
    }
    int j = paramVarArgs.length;
    while (i < j)
    {
      String str = paramVarArgs[i];
      this.MKK.append(str);
      this.MKK.append("|");
      i += 1;
    }
    AppMethodBeat.o(62640);
  }
  
  public final void ajf(int paramInt)
  {
    AppMethodBeat.i(62654);
    b.d(TAG, new Object[] { "stopStatus", Integer.valueOf(paramInt) });
    this.CMo = paramInt;
    AppMethodBeat.o(62654);
  }
  
  public final String geu()
  {
    AppMethodBeat.i(62636);
    b.d(TAG, new Object[] { "collectInfo" });
    this.MKI = Build.MANUFACTURER;
    this.deviceModel = Build.MODEL;
    this.MKJ = Build.VERSION.SDK_INT;
    this.CMH = Build.VERSION.RELEASE;
    this.netType = k.ly(com.tencent.pb.common.c.c.CDp);
    this.MKG = -1;
    this.MKH = -1;
    Object localObject = new ArrayList();
    ((List)localObject).add(this.groupId);
    ((List)localObject).add(this.McZ);
    ((List)localObject).add(Integer.valueOf(this.CwV));
    ((List)localObject).add(Integer.valueOf(this.roomId));
    ((List)localObject).add(Long.valueOf(this.uXg));
    ((List)localObject).add(Integer.valueOf(this.pcE));
    ((List)localObject).add(Integer.valueOf(this.CMo));
    ((List)localObject).add(Integer.valueOf(this.CMv));
    ((List)localObject).add(Integer.valueOf(this.CMr));
    ((List)localObject).add(Integer.valueOf(this.uYt));
    ((List)localObject).add(Integer.valueOf(this.MKy));
    ((List)localObject).add(Integer.valueOf(this.MKz));
    ((List)localObject).add(Long.valueOf(this.MKA));
    ((List)localObject).add(Long.valueOf(this.MKB));
    ((List)localObject).add(Integer.valueOf(this.MKC));
    ((List)localObject).add(Integer.valueOf(this.MKD));
    ((List)localObject).add(Integer.valueOf(this.MKE));
    ((List)localObject).add(Long.valueOf(this.MKF));
    ((List)localObject).add(Long.valueOf(this.CMw));
    ((List)localObject).add(Long.valueOf(this.uYs));
    ((List)localObject).add(Integer.valueOf(this.CMB));
    ((List)localObject).add(Integer.valueOf(this.CMC));
    ((List)localObject).add(Integer.valueOf(this.netType));
    ((List)localObject).add(Integer.valueOf(this.MKG));
    ((List)localObject).add(Integer.valueOf(this.MKH));
    ((List)localObject).add(this.MKI);
    ((List)localObject).add(this.deviceModel);
    ((List)localObject).add(Integer.valueOf(this.MKJ));
    ((List)localObject).add(this.CMH);
    ((List)localObject).add(Integer.valueOf(c.gdW().bbG(this.groupId)));
    ((List)localObject).add(this.MKK.toString());
    ((List)localObject).add(Integer.valueOf(this.Cxk));
    ((List)localObject).add(Integer.valueOf(this.Cxc));
    ((List)localObject).add(Integer.valueOf(this.CwY));
    ((List)localObject).add(Integer.valueOf(this.CwZ));
    localObject = f.a((Iterable)localObject, ",", "_");
    b.d(TAG, new Object[] { "logBuf: ", this.MKK.toString() });
    b.d(TAG, new Object[] { "statresult", localObject });
    AppMethodBeat.o(62636);
    return localObject;
  }
  
  public final void gev()
  {
    AppMethodBeat.i(62641);
    this.MKL = System.currentTimeMillis();
    b.d(TAG, new Object[] { "beginCreateOrEnter", Long.valueOf(this.MKL) });
    AppMethodBeat.o(62641);
  }
  
  public final void gew()
  {
    AppMethodBeat.i(62642);
    b.d(TAG, new Object[] { "endCancelCreate", Long.valueOf(System.currentTimeMillis() - this.MKL), Long.valueOf(this.MKA) });
    if (this.MKA > 0L)
    {
      AppMethodBeat.o(62642);
      return;
    }
    this.CMv = 1;
    if (this.MKL == 0L)
    {
      this.CMw = 0L;
      AppMethodBeat.o(62642);
      return;
    }
    this.CMw = (System.currentTimeMillis() - this.MKL);
    AppMethodBeat.o(62642);
  }
  
  public final void gex()
  {
    AppMethodBeat.i(62643);
    b.w(TAG, new Object[] { "beginCreateOrNotify" });
    this.MKM = System.currentTimeMillis();
    AppMethodBeat.o(62643);
  }
  
  public final void gey()
  {
    AppMethodBeat.i(62644);
    b.d(TAG, new Object[] { "endAnswerTime", Long.valueOf(this.MKN) });
    if (this.MKN == 0L)
    {
      this.uYs = 0L;
      AppMethodBeat.o(62644);
      return;
    }
    this.uYs = (System.currentTimeMillis() - this.MKN);
    AppMethodBeat.o(62644);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(62635);
    b.d(TAG, new Object[] { "reset" });
    this.MKN = 0L;
    this.MKM = 0L;
    this.MKL = 0L;
    this.groupId = "";
    this.McZ = "";
    this.CwV = 1;
    this.roomId = 0;
    this.uXg = 0L;
    this.pcE = -1;
    this.CMo = 0;
    this.CMv = 0;
    this.CMr = 0;
    this.uYt = 0;
    this.MKy = 0;
    this.MKz = 0;
    this.MKA = 0L;
    this.MKB = 0L;
    this.MKC = 0;
    this.MKD = 0;
    this.MKE = 0;
    this.MKF = 0L;
    this.CMw = 0L;
    this.uYs = 0L;
    this.CMB = 0;
    this.CMC = 0;
    this.netType = -1;
    this.MKG = 0;
    this.MKH = 0;
    this.MKI = "";
    this.deviceModel = "";
    this.MKJ = -1;
    this.CMH = "";
    this.MKK.setLength(0);
    this.Cxk = -1;
    this.Cxc = 0;
    this.CwY = 0;
    this.CwZ = 0;
    AppMethodBeat.o(62635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.h
 * JD-Core Version:    0.7.0.1
 */