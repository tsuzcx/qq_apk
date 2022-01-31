package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.system.ConnectReceiver;
import com.tencent.wecall.talkroom.a.k;
import com.tencent.wecall.talkroom.a.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class e
  implements com.tencent.pb.talkroom.sdk.d
{
  private static e BAi = null;
  private com.tencent.pb.talkroom.sdk.a BAh;
  private ConnectReceiver BAj;
  private g.a BAk;
  private final String TAG;
  
  private e()
  {
    AppMethodBeat.i(127841);
    this.TAG = "TalkRoomSdkApi";
    this.BAh = null;
    this.BAj = new ConnectReceiver();
    this.BAk = new e.1(this);
    AppMethodBeat.o(127841);
  }
  
  public static e dXz()
  {
    AppMethodBeat.i(127840);
    if (BAi == null) {}
    try
    {
      if (BAi == null) {
        BAi = new e();
      }
      e locale = BAi;
      AppMethodBeat.o(127840);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(127840);
    }
  }
  
  public static void jM(Context paramContext)
  {
    AppMethodBeat.i(127842);
    com.tencent.pb.common.c.d.tFk = paramContext;
    i.jL(paramContext);
    AppMethodBeat.o(127842);
  }
  
  public final boolean A(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(127848);
    f localf = a.dXg();
    paramString2 = localf.a(paramString1, localf.nTj, localf.tFh, paramInt, 1, paramString2);
    com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "enterMultiTalk multiTalkGroupid:", paramString1, " isAccept: ", Boolean.TRUE, " routId: ", Integer.valueOf(paramInt), " ret: ", paramString2 });
    if (paramString2 == f.b.BBB)
    {
      AppMethodBeat.o(127848);
      return true;
    }
    AppMethodBeat.o(127848);
    return false;
  }
  
  public final boolean D(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(127850);
    if (!com.tencent.pb.common.c.g.iN(paramString, a.dXg().nuW))
    {
      com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "addMultiTalkMember groupid is not same; multiTalkGroupid: ", paramString, a.dXg().nuW });
      AppMethodBeat.o(127850);
      return false;
    }
    f localf = a.dXg();
    int j = localf.nTj;
    long l = localf.tFh;
    int i;
    boolean bool;
    if (paramList == null)
    {
      i = 0;
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "addrTalkRoomMember", paramString, Integer.valueOf(j), Long.valueOf(l), " users length: ", Integer.valueOf(i) });
      localf.BAU = false;
      if ((!TextUtils.isEmpty(paramString)) && (paramList != null)) {
        break label184;
      }
      bool = false;
    }
    for (;;)
    {
      com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "addMultiTalkMember ret: ", Boolean.valueOf(bool) });
      AppMethodBeat.o(127850);
      return bool;
      i = paramList.size();
      break;
      label184:
      if (!com.tencent.pb.common.b.h.isNetworkConnected())
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "addTalkRoomMember isNetworkConnected is false" });
        bool = false;
      }
      else
      {
        paramList = f.fN(paramList);
        if (paramList.length <= 0)
        {
          com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "addTalkRoomMember users is null" });
          bool = false;
        }
        else
        {
          paramString = new com.tencent.wecall.talkroom.a.b(paramString, localf.nTj, localf.tFh, paramList);
          bool = com.tencent.pb.common.b.e.dTE().a(paramString);
          localf.BAG.aa(new String[] { "add", "req", String.valueOf(bool), String.valueOf(localf.state) });
        }
      }
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.f G(int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(127861);
    com.tencent.pb.talkroom.sdk.f localf = a.dXg().G(paramArrayOfInt);
    if (paramArrayOfInt == null) {}
    for (;;)
    {
      com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "receiveVideo imgBuffer size: ", Integer.valueOf(i), " MultiTalkVideoDecodeInfo: ", localf });
      AppMethodBeat.o(127861);
      return localf;
      i = paramArrayOfInt.length;
    }
  }
  
  public final boolean Un(String paramString)
  {
    AppMethodBeat.i(127851);
    if (!com.tencent.pb.common.c.g.iN(paramString, a.dXg().nuW))
    {
      com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "exitMultiTalk groupid is not same; multiTalkGroupid: ", paramString, a.dXg().nuW });
      f.e locale;
      f localf;
      if (a.dXg().axy(paramString))
      {
        locale = a.dXg().axx(paramString);
        localf = a.dXg();
        if (locale != null) {
          break label100;
        }
        i = 0;
        if (locale != null) {
          break label109;
        }
      }
      label100:
      label109:
      for (l = 0L;; l = locale.nNa)
      {
        localf.a(paramString, i, l, 1);
        AppMethodBeat.o(127851);
        return false;
        i = locale.nMZ;
        break;
      }
    }
    int i = a.dXg().nTj;
    long l = a.dXg().tFh;
    boolean bool = a.dXg().aK(paramString, 1, 100);
    com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "exitMultiTalk groupId: ", paramString, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(l) });
    AppMethodBeat.o(127851);
    return bool;
  }
  
  public final boolean Uw(String paramString)
  {
    AppMethodBeat.i(127859);
    if (!a.dXg().cMa())
    {
      com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "subscribeLargeVideo isWorking is false" });
      AppMethodBeat.o(127859);
      return false;
    }
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "subscribeLargeVideo ownerUserName: ", paramString });
    f localf = a.dXg();
    if (TextUtils.isEmpty(localf.nuW))
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "subscribeLargeVideo mGroupId null " });
      AppMethodBeat.o(127859);
      return false;
    }
    paramString = new k(localf.nuW, localf.nTj, localf.tFh, paramString);
    boolean bool = com.tencent.pb.common.b.e.dTE().a(paramString);
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "subscribeLargeVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(127859);
    return bool;
  }
  
  public final int a(byte[] paramArrayOfByte, short paramShort, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(127860);
    int j = a.dXg().a(paramArrayOfByte, paramShort, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "sendVideo buffer size: ", Integer.valueOf(i), " len: ", Short.valueOf(paramShort), " w: ", Integer.valueOf(paramInt1), " h: ", Integer.valueOf(paramInt2), " format: ", Integer.valueOf(paramInt3), " mode: ", Integer.valueOf(paramInt4) });
      AppMethodBeat.o(127860);
      return j;
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.g a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    int j = 0;
    AppMethodBeat.i(127862);
    com.tencent.pb.talkroom.sdk.g localg = a.dXg().a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    int i;
    if (paramArrayOfByte == null)
    {
      i = 0;
      if (paramArrayOfInt != null) {
        break label144;
      }
    }
    for (;;)
    {
      com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "videoTrans recordData size: ", Integer.valueOf(i), " len: ", Integer.valueOf(paramInt1), " localImg size: ", Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), " multiTalkVideoRGBinfo: ", localg });
      AppMethodBeat.o(127862);
      return localg;
      i = paramArrayOfByte.length;
      break;
      label144:
      j = paramArrayOfInt.length;
    }
  }
  
  public final boolean a(com.tencent.pb.talkroom.sdk.a parama, com.tencent.pb.talkroom.sdk.e parame)
  {
    AppMethodBeat.i(127843);
    if (com.tencent.pb.common.c.d.tFk == null)
    {
      com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "init fail context: ", com.tencent.pb.common.c.d.tFk });
      AppMethodBeat.o(127843);
      return false;
    }
    try
    {
      this.BAh = parama;
      f.a(parame);
      parama = a.dXg();
      g.a locala = this.BAk;
      parama.BAO.a(locala);
      com.tencent.pb.common.b.f.dTH().Bdm = parame;
      a.dXf();
      a.dXh();
      parama = new IntentFilter();
      parama.setPriority(2147483647);
      parama.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      com.tencent.pb.common.c.d.tFk.registerReceiver(this.BAj, parama);
      com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "init" });
      AppMethodBeat.o(127843);
      return true;
    }
    catch (Exception parama)
    {
      com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "init ", parama });
      AppMethodBeat.o(127843);
    }
    return false;
  }
  
  public final boolean a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(127849);
    f.b localb = a.dXg().a(paramString1, paramInt1, paramLong, paramInt2, 100, paramString2);
    com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "enterMultiTalk multiTalkGroupid:", paramString1, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " routId: ", Integer.valueOf(paramInt2), " wxGroupId: ", paramString2, " ret: ", localb });
    if (localb == f.b.BBB)
    {
      AppMethodBeat.o(127849);
      return true;
    }
    AppMethodBeat.o(127849);
    return false;
  }
  
  public final List<String> awu(String paramString)
  {
    AppMethodBeat.i(127852);
    if (!com.tencent.pb.common.c.g.iN(paramString, a.dXg().nuW))
    {
      com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "getTalkingMember groupid is not same; multiTalkGroupid: ", paramString, a.dXg().nuW });
      AppMethodBeat.o(127852);
      return null;
    }
    Object localObject1 = c.dXv().axp(paramString);
    if (localObject1 == null)
    {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getTalkingMember talkroom is null: groupId: ", paramString });
      AppMethodBeat.o(127852);
      return null;
    }
    localObject1 = ((TalkRoom)localObject1).dXn();
    paramString = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    label232:
    label235:
    for (;;)
    {
      d locald;
      Object localObject2;
      int i;
      if (((Iterator)localObject1).hasNext())
      {
        locald = (d)((Iterator)localObject1).next();
        if (locald == null) {
          continue;
        }
        localObject2 = a.dXg();
        i = locald.getMemberId();
        if (((f)localObject2).BAH == null) {
          break label232;
        }
        localObject2 = ((f)localObject2).BAH;
        if ((!com.tencent.pb.common.a.a.BcB) || (((b)localObject2).BzZ == null)) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label235;
        }
        paramString.add(locald.dXx());
        break;
        if (((b)localObject2).BzZ.GetVoiceActivity(i) == 1)
        {
          i = 1;
        }
        else
        {
          i = 0;
          continue;
          AppMethodBeat.o(127852);
          return paramString;
          i = 0;
        }
      }
    }
  }
  
  public final void bQ(int paramInt, String paramString)
  {
    AppMethodBeat.i(127857);
    com.tencent.pb.a.a.a.Sc(paramInt);
    com.tencent.pb.a.a.a.awt(paramString);
    com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "setWxUinAndUsrName uin: ", Integer.valueOf(paramInt), " usrname: ", paramString });
    AppMethodBeat.o(127857);
  }
  
  public final boolean cn(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127854);
    com.tencent.pb.common.b.f.dTH();
    int i = com.tencent.pb.common.b.f.cm(paramArrayOfByte);
    com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "handleMultiTalkNotify ret: ", Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(127854);
      return true;
    }
    AppMethodBeat.o(127854);
    return false;
  }
  
  public final boolean dUa()
  {
    AppMethodBeat.i(127846);
    try
    {
      com.tencent.pb.common.c.c.dTU();
      com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "setOpenLog: isOpenSdkLog", Boolean.TRUE, " level: ", Integer.valueOf(0) });
      AppMethodBeat.o(127846);
      return true;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "setOpenLog: ", localThrowable });
      AppMethodBeat.o(127846);
    }
    return false;
  }
  
  public final String dUb()
  {
    AppMethodBeat.i(127856);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("client_");
    ((StringBuilder)localObject).append(com.tencent.pb.a.a.a.dTX());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = ((StringBuilder)localObject).toString();
    com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "genMultiTalkClientId clientId: ", localObject });
    AppMethodBeat.o(127856);
    return localObject;
  }
  
  public final boolean e(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127853);
    int i;
    if (paramArrayOfByte == null)
    {
      i = 0;
      com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "handleMultiTalkResp retCode: ", Integer.valueOf(paramInt1), " seq: ", Integer.valueOf(paramInt2), " cmdId: ", Integer.valueOf(paramInt3), " data length: ", Integer.valueOf(i) });
      if (paramInt1 != 0) {
        break label109;
      }
      com.tencent.pb.common.b.f.dTH().s(paramInt2, paramArrayOfByte);
    }
    for (;;)
    {
      AppMethodBeat.o(127853);
      return true;
      i = paramArrayOfByte.length;
      break;
      label109:
      paramArrayOfByte = com.tencent.pb.common.b.f.dTH();
      com.tencent.pb.common.b.f.a locala = paramArrayOfByte.Sb(paramInt2);
      if (locala != null)
      {
        com.tencent.pb.common.c.c.w("NETCMD", new Object[] { "CLTRCV FAIL", Integer.valueOf(paramInt2), locala.Bdp, Integer.valueOf(1), Integer.valueOf(paramInt1) });
        paramArrayOfByte.a(locala, -1, null);
      }
    }
  }
  
  public final boolean g(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(127847);
    f localf = a.dXg();
    Object localObject1 = f.fN(paramList);
    int i;
    if (localObject1.length > 0)
    {
      if (TextUtils.isEmpty(null)) {
        break label302;
      }
      throw new NullPointerException();
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "createTalkRoom cliendId: ", paramString1, " voiceSingle2MultiInfo: ", null, " memeberUuids size: ", Integer.valueOf(localObject1.length), "routeId", Integer.valueOf(i), " context: ", null, " type: ", Integer.valueOf(0), " playId: ", Long.valueOf(0L), " sdkKey: ", null });
      if (com.tencent.pb.a.a.a.dTY()) {
        break label331;
      }
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "createTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.dTY()), " isBindMobile: ", Boolean.valueOf(com.tencent.pb.a.a.a.dTZ()) });
      h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "noAuth" });
    }
    for (;;)
    {
      paramString1 = null;
      com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "createTalkRoom clientId is: ", paramString1, "wXgroupId: ", paramString2, " creatorUsrName: ", com.tencent.pb.a.a.a.dTX(), " usrnameList: ", paramList });
      if (paramString1 == null) {
        break label999;
      }
      AppMethodBeat.o(127847);
      return true;
      label302:
      i = new Random().nextInt() << 16 | com.tencent.pb.a.a.a.dTX().hashCode() & 0xFFFF;
      break;
      label331:
      if (!com.tencent.pb.common.b.h.isNetworkConnected())
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "createTalkRoom isNetworkConnected is false" });
        h.Tv(-4003);
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "noNetwork" });
      }
      else if (localf.cMa())
      {
        if (localf.cMa()) {
          h.Tv(-4002);
        }
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "isBusy" });
      }
      else if (TextUtils.isEmpty(paramString1))
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "createTalkRoom cliendId is null" });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "cliendIdnull" });
      }
      else if (!j.axD(paramString1))
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "createTalkRoom groupId is not cliend id: ", paramString1 });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "isnotcliendId" });
      }
      else
      {
        if (c.dXv().axp(paramString1) == null) {
          c.dXv().e(paramString1, paramString2, (String[])localObject1);
        }
        localf.BAG.reset();
        localf.sb(false);
        localf.dXD();
        if (localf.cHL()) {
          break label693;
        }
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "createTalkRoom initEngine fail" });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "initEnginefail" });
        localf.sb(false);
      }
    }
    label693:
    localf.BAG.dXQ();
    localf.nuW = paramString1;
    localf.BAS = paramString1;
    localf.Bda = i;
    localf.BAy = paramString1;
    localf.setState(1);
    localf.txk = true;
    Object localObject2 = new f.a(localf);
    ((f.a)localObject2).groupId = localf.nuW;
    ((f.a)localObject2).BBv = ((String[])localObject1);
    ((f.a)localObject2).BBw = null;
    ((f.a)localObject2).BdL = i;
    ((f.a)localObject2).type = 0;
    ((f.a)localObject2).BBx = 0L;
    ((f.a)localObject2).BBy = null;
    ((f.a)localObject2).BBz = false;
    ((f.a)localObject2).BBA = paramString2;
    localObject1 = Message.obtain();
    ((Message)localObject1).what = 2;
    ((Message)localObject1).obj = localObject2;
    localf.mHandler.removeMessages(2);
    localObject2 = c.dXv().axp(localf.nuW);
    if (localObject2 == null) {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup talkroom is null" });
    }
    for (;;)
    {
      localf.mHandler.sendMessage((Message)localObject1);
      localf.BAU = true;
      break;
      localObject2 = ((TalkRoom)localObject2).dXm();
      if ((localObject2 == null) || (((List)localObject2).size() != 1))
      {
        com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup TalkRoomMember list is not match" });
      }
      else
      {
        localObject2 = (d)((List)localObject2).get(0);
        if (localObject2 == null) {
          com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup talkRoomMember is null" });
        } else {
          com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup ret: ", Boolean.valueOf(((d)localObject2).dXy()) });
        }
      }
    }
    label999:
    AppMethodBeat.o(127847);
    return false;
  }
  
  public final void jF(boolean paramBoolean)
  {
    AppMethodBeat.i(127845);
    a.dXg();
    com.tencent.pb.talkroom.sdk.e locale = f.dXO();
    if (locale != null) {}
    for (boolean bool = locale.jB(paramBoolean);; bool = false)
    {
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "switchSpeakerPhone", Boolean.valueOf(paramBoolean), " ret: ", Boolean.valueOf(bool), " realret: ", Boolean.valueOf(f.KM()), " wxCallBack: ", locale });
      AppMethodBeat.o(127845);
      return;
    }
  }
  
  public final void rS(boolean paramBoolean)
  {
    AppMethodBeat.i(127844);
    f localf = a.dXg();
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "setMute isMute: ", Boolean.valueOf(paramBoolean) });
    localf.mIsMute = paramBoolean;
    com.tencent.pb.common.c.h.aA(new g.14(localf.BAO, paramBoolean));
    AppMethodBeat.o(127844);
  }
  
  public final boolean rT(boolean paramBoolean)
  {
    AppMethodBeat.i(127855);
    com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "holadMultiTalk isHold", Boolean.valueOf(paramBoolean) });
    f localf;
    if (paramBoolean)
    {
      localf = a.dXg();
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "syscall", "startHoldOn" });
      localf.BBc = true;
      localf.sc(false);
      com.tencent.pb.common.c.h.aA(new g.10(localf.BAO));
    }
    for (;;)
    {
      AppMethodBeat.o(127855);
      return true;
      localf = a.dXg();
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "syscall", "endHoldOn" });
      localf.BBc = false;
      localf.dXE();
      if ((localf.cMa()) && (localf.odg))
      {
        localf.sc(true);
        com.tencent.pb.common.c.h.aA(new g.12(localf.BAO));
      }
    }
  }
  
  public final int setAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = -1;
    AppMethodBeat.i(127863);
    Object localObject = a.dXg();
    if (((f)localObject).BAH == null) {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "setAppCmd type: ", Integer.valueOf(paramInt1), " engine is null" });
    }
    for (;;)
    {
      com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "setAppCmd type: ", Integer.valueOf(paramInt1), " paramLen: ", Integer.valueOf(paramInt2), " ret: ", Integer.valueOf(i) });
      AppMethodBeat.o(127863);
      return i;
      localObject = ((f)localObject).BAH;
      if ((paramArrayOfByte == null) || (((b)localObject).BzZ == null)) {
        com.tencent.pb.common.c.c.w("simon:TalkRoomContext", new Object[] { "steve:setAppCmd null, params:", paramArrayOfByte, ", engine:", ((b)localObject).BzZ });
      } else {
        i = ((b)localObject).BzZ.setAppCmd(paramInt1, paramArrayOfByte, paramInt2);
      }
    }
  }
  
  public final boolean zF(int paramInt)
  {
    AppMethodBeat.i(127858);
    if (!a.dXg().cMa())
    {
      com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "switchMultiTalkVideo isWorking is false" });
      AppMethodBeat.o(127858);
      return false;
    }
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "switchMultiTalkVideo action: ", Integer.valueOf(paramInt) });
    Object localObject = a.dXg();
    if (TextUtils.isEmpty(((f)localObject).nuW))
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "switchMultiTalkVideo mGroupId is null" });
      AppMethodBeat.o(127858);
      return false;
    }
    ((f)localObject).BAF = paramInt;
    localObject = new l(((f)localObject).nuW, ((f)localObject).nTj, ((f)localObject).tFh, paramInt);
    boolean bool = com.tencent.pb.common.b.e.dTE().a((com.tencent.pb.common.b.d)localObject);
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "switchMultiTalkVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(127858);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.e
 * JD-Core Version:    0.7.0.1
 */