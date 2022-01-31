package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.g.i;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.b.a.a.av;
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
  private static e xdA = null;
  private final String TAG = "TalkRoomSdkApi";
  private ConnectReceiver xdB = new ConnectReceiver();
  private g.a xdC = new e.1(this);
  private com.tencent.pb.talkroom.sdk.a xdz = null;
  
  public static e cRH()
  {
    if (xdA == null) {}
    try
    {
      if (xdA == null) {
        xdA = new e();
      }
      return xdA;
    }
    finally {}
  }
  
  public static void ii(Context paramContext)
  {
    com.tencent.pb.common.c.d.pZI = paramContext;
    i.de(paramContext);
  }
  
  public final boolean C(String paramString1, int paramInt, String paramString2)
  {
    f localf = a.cRq();
    paramString2 = localf.a(paramString1, localf.lvU, localf.xdR, paramInt, 1, paramString2);
    com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "enterMultiTalk multiTalkGroupid:", paramString1, " isAccept: ", Boolean.valueOf(true), " routId: ", Integer.valueOf(paramInt), " ret: ", paramString2 });
    return paramString2 == f.b.xeU;
  }
  
  public final boolean IH(String paramString)
  {
    if (!a.cRq().bPW())
    {
      com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "subscribeLargeVideo isWorking is false" });
      return false;
    }
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "subscribeLargeVideo ownerUserName: ", paramString });
    f localf = a.cRq();
    if (TextUtils.isEmpty(localf.kWU))
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "subscribeLargeVideo mGroupId null " });
      return false;
    }
    paramString = new k(localf.kWU, localf.lvU, localf.xdR, paramString);
    boolean bool = com.tencent.pb.common.b.e.cNS().a(paramString);
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "subscribeLargeVideo ret: ", Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean Iy(String paramString)
  {
    if (!com.tencent.pb.common.c.g.gK(paramString, a.cRq().kWU))
    {
      com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "exitMultiTalk groupid is not same; multiTalkGroupid: ", paramString, a.cRq().kWU });
      f.e locale;
      f localf;
      if (a.cRq().agD(paramString))
      {
        locale = a.cRq().agC(paramString);
        localf = a.cRq();
        if (locale != null) {
          break label90;
        }
        i = 0;
        if (locale != null) {
          break label99;
        }
      }
      label90:
      label99:
      for (l = 0L;; l = locale.lpE)
      {
        localf.a(paramString, i, l, 1);
        return false;
        i = locale.lpD;
        break;
      }
    }
    int i = a.cRq().lvU;
    long l = a.cRq().xdR;
    boolean bool = a.cRq().at(paramString, 1, 100);
    com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "exitMultiTalk groupId: ", paramString, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(l) });
    return bool;
  }
  
  public final int a(byte[] paramArrayOfByte, short paramShort, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    f localf = a.cRq();
    int i;
    if (localf.xea != null)
    {
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "sendVideo ", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      i = localf.xea.xdr.SendVideo(paramArrayOfByte, paramShort, paramInt1, paramInt2, paramInt3, paramInt4);
      if (paramArrayOfByte != null) {
        break label172;
      }
    }
    label172:
    for (int j = 0;; j = paramArrayOfByte.length)
    {
      com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "sendVideo buffer size: ", Integer.valueOf(j), " len: ", Short.valueOf(paramShort), " w: ", Integer.valueOf(paramInt1), " h: ", Integer.valueOf(paramInt2), " format: ", Integer.valueOf(paramInt3), " mode: ", Integer.valueOf(paramInt4) });
      return i;
      i = -1;
      break;
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.g a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    f localf = a.cRq();
    com.tencent.pb.talkroom.sdk.g localg = new com.tencent.pb.talkroom.sdk.g();
    int i;
    if (localf.xea != null)
    {
      b localb = localf.xea;
      i = localb.xdr.videoTrans(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
      localg = new com.tencent.pb.talkroom.sdk.g();
      localg.wJX = paramArrayOfInt;
      localg.wJY = localb.xdr.field_localImgWidth;
      localg.wJZ = localb.xdr.field_localImgHeight;
      localg.ret = i;
    }
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "videoTrans ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), " multiTalkVideoRGBinfo: ", localg, " engine: ", localf.xea });
    if (paramArrayOfByte == null)
    {
      i = 0;
      if (paramArrayOfInt != null) {
        break label277;
      }
    }
    label277:
    for (int j = 0;; j = paramArrayOfInt.length)
    {
      com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "videoTrans recordData size: ", Integer.valueOf(i), " len: ", Integer.valueOf(paramInt1), " localImg size: ", Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), " multiTalkVideoRGBinfo: ", localg });
      return localg;
      i = paramArrayOfByte.length;
      break;
    }
  }
  
  /* Error */
  public final boolean a(com.tencent.pb.talkroom.sdk.a parama, com.tencent.pb.talkroom.sdk.e parame)
  {
    // Byte code:
    //   0: getstatic 55	com/tencent/pb/common/c/d:pZI	Landroid/content/Context;
    //   3: ifnonnull +26 -> 29
    //   6: ldc 26
    //   8: iconst_2
    //   9: anewarray 4	java/lang/Object
    //   12: dup
    //   13: iconst_0
    //   14: ldc_w 273
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: getstatic 55	com/tencent/pb/common/c/d:pZI	Landroid/content/Context;
    //   23: aastore
    //   24: invokestatic 106	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: iconst_0
    //   28: ireturn
    //   29: aload_0
    //   30: aload_1
    //   31: putfield 30	com/tencent/wecall/talkroom/model/e:xdz	Lcom/tencent/pb/talkroom/sdk/a;
    //   34: aload_2
    //   35: invokestatic 276	com/tencent/wecall/talkroom/model/f:a	(Lcom/tencent/pb/talkroom/sdk/e;)V
    //   38: invokestatic 68	com/tencent/wecall/talkroom/model/a:cRq	()Lcom/tencent/wecall/talkroom/model/f;
    //   41: astore_3
    //   42: aload_0
    //   43: getfield 42	com/tencent/wecall/talkroom/model/e:xdC	Lcom/tencent/wecall/talkroom/model/g$a;
    //   46: astore_1
    //   47: aload_3
    //   48: getfield 280	com/tencent/wecall/talkroom/model/f:xeh	Lcom/tencent/wecall/talkroom/model/g;
    //   51: astore_3
    //   52: aload_1
    //   53: monitorenter
    //   54: aload_3
    //   55: getfield 286	com/tencent/wecall/talkroom/model/g:dhm	Ljava/util/List;
    //   58: aload_1
    //   59: invokeinterface 292 2 0
    //   64: ifeq +70 -> 134
    //   67: aload_1
    //   68: monitorexit
    //   69: invokestatic 298	com/tencent/pb/common/b/f:cNV	()Lcom/tencent/pb/common/b/f;
    //   72: aload_2
    //   73: putfield 302	com/tencent/pb/common/b/f:wFM	Lcom/tencent/pb/talkroom/sdk/e;
    //   76: invokestatic 306	com/tencent/wecall/talkroom/model/a:cRp	()Lcom/tencent/wecall/talkroom/model/a;
    //   79: pop
    //   80: invokestatic 309	com/tencent/wecall/talkroom/model/a:cRr	()V
    //   83: new 311	android/content/IntentFilter
    //   86: dup
    //   87: invokespecial 312	android/content/IntentFilter:<init>	()V
    //   90: astore_1
    //   91: aload_1
    //   92: ldc_w 313
    //   95: invokevirtual 317	android/content/IntentFilter:setPriority	(I)V
    //   98: aload_1
    //   99: ldc_w 319
    //   102: invokevirtual 323	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   105: getstatic 55	com/tencent/pb/common/c/d:pZI	Landroid/content/Context;
    //   108: aload_0
    //   109: getfield 35	com/tencent/wecall/talkroom/model/e:xdB	Lcom/tencent/pb/common/system/ConnectReceiver;
    //   112: aload_1
    //   113: invokevirtual 329	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   116: pop
    //   117: ldc 26
    //   119: iconst_1
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: ldc_w 331
    //   128: aastore
    //   129: invokestatic 125	com/tencent/pb/common/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: iconst_1
    //   133: ireturn
    //   134: aload_3
    //   135: getfield 286	com/tencent/wecall/talkroom/model/g:dhm	Ljava/util/List;
    //   138: aload_1
    //   139: invokeinterface 334 2 0
    //   144: pop
    //   145: aload_1
    //   146: monitorexit
    //   147: goto -78 -> 69
    //   150: astore_2
    //   151: aload_1
    //   152: monitorexit
    //   153: aload_2
    //   154: athrow
    //   155: astore_1
    //   156: ldc 26
    //   158: iconst_2
    //   159: anewarray 4	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: ldc_w 336
    //   167: aastore
    //   168: dup
    //   169: iconst_1
    //   170: aload_1
    //   171: aastore
    //   172: invokestatic 106	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: iconst_0
    //   176: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	e
    //   0	177	1	parama	com.tencent.pb.talkroom.sdk.a
    //   0	177	2	parame	com.tencent.pb.talkroom.sdk.e
    //   41	94	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   54	69	150	finally
    //   134	147	150	finally
    //   151	153	150	finally
    //   29	54	155	java/lang/Exception
    //   69	132	155	java/lang/Exception
    //   153	155	155	java/lang/Exception
  }
  
  public final boolean a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    f.b localb = a.cRq().a(paramString1, paramInt1, paramLong, paramInt2, 100, paramString2);
    com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "enterMultiTalk multiTalkGroupid:", paramString1, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " routId: ", Integer.valueOf(paramInt2), " wxGroupId: ", paramString2, " ret: ", localb });
    return localb == f.b.xeU;
  }
  
  public final List<String> afw(String paramString)
  {
    if (!com.tencent.pb.common.c.g.gK(paramString, a.cRq().kWU))
    {
      com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "getTalkingMember groupid is not same; multiTalkGroupid: ", paramString, a.cRq().kWU });
      return null;
    }
    Object localObject1 = c.cRC().agw(paramString);
    if (localObject1 == null)
    {
      com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getTalkingMember talkroom is null: groupId: ", paramString });
      return null;
    }
    localObject1 = ((TalkRoom)localObject1).cRx();
    paramString = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    label195:
    label198:
    for (;;)
    {
      d locald;
      int i;
      if (((Iterator)localObject1).hasNext())
      {
        locald = (d)((Iterator)localObject1).next();
        if (locald == null) {
          continue;
        }
        Object localObject2 = a.cRq();
        i = locald.cRF();
        if (((f)localObject2).xea == null) {
          break label195;
        }
        localObject2 = ((f)localObject2).xea;
        if ((com.tencent.pb.common.a.a.wFa) && (((b)localObject2).xdr.GetVoiceActivity(i) == 1)) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label198;
        }
        paramString.add(locald.cRE());
        break;
        i = 0;
        continue;
        return paramString;
        i = 0;
      }
    }
  }
  
  public final boolean bN(byte[] paramArrayOfByte)
  {
    com.tencent.pb.common.b.f.cNV();
    int i = com.tencent.pb.common.b.f.bM(paramArrayOfByte);
    com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "handleMultiTalkNotify ret: ", Integer.valueOf(i) });
    return i == 0;
  }
  
  public final void bk(int paramInt, String paramString)
  {
    com.tencent.pb.a.a.a.Jg(paramInt);
    com.tencent.pb.a.a.a.afv(paramString);
    com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "setWxUinAndUsrName uin: ", Integer.valueOf(paramInt), " usrname: ", paramString });
  }
  
  public final boolean c(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    int i;
    if (paramArrayOfByte == null)
    {
      i = 0;
      com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "handleMultiTalkResp retCode: ", Integer.valueOf(paramInt1), " seq: ", Integer.valueOf(paramInt2), " cmdId: ", Integer.valueOf(paramInt3), " data length: ", Integer.valueOf(i) });
      if (paramInt1 != 0) {
        break label97;
      }
      com.tencent.pb.common.b.f.cNV().s(paramInt2, paramArrayOfByte);
    }
    label97:
    com.tencent.pb.common.b.f.a locala;
    do
    {
      return true;
      i = paramArrayOfByte.length;
      break;
      paramArrayOfByte = com.tencent.pb.common.b.f.cNV();
      locala = paramArrayOfByte.Jf(paramInt2);
    } while (locala == null);
    com.tencent.pb.common.c.c.x("NETCMD", new Object[] { "CLTRCV FAIL", Integer.valueOf(paramInt2), locala.wFP, Integer.valueOf(1), Integer.valueOf(paramInt1) });
    paramArrayOfByte.a(locala, -1, null);
    return true;
  }
  
  public final boolean cOn()
  {
    try
    {
      com.tencent.pb.common.c.c.cOi();
      com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "setOpenLog: isOpenSdkLog", Boolean.valueOf(true), " level: ", Integer.valueOf(0) });
      return true;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "setOpenLog: ", localThrowable });
    }
    return false;
  }
  
  public final String cOo()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("client_");
    ((StringBuilder)localObject).append(com.tencent.pb.a.a.a.cOl());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = ((StringBuilder)localObject).toString();
    com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "genMultiTalkClientId clientId: ", localObject });
    return localObject;
  }
  
  public final boolean f(String paramString1, String paramString2, List<String> paramList)
  {
    f localf = a.cRq();
    Object localObject1 = f.eE(paramList);
    int i;
    if (localObject1.length > 0)
    {
      if (TextUtils.isEmpty(null)) {
        break label289;
      }
      throw new NullPointerException();
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "createTalkRoom cliendId: ", paramString1, " voiceSingle2MultiInfo: ", null, " memeberUuids size: ", Integer.valueOf(localObject1.length), "routeId", Integer.valueOf(i), " context: ", null, " type: ", Integer.valueOf(0), " playId: ", Long.valueOf(0L), " sdkKey: ", null });
      if (com.tencent.pb.a.a.a.cOm()) {
        break label318;
      }
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "createTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.cOm()), " isBindMobile: ", Boolean.valueOf(true) });
      h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "noAuth" });
    }
    for (;;)
    {
      paramString1 = null;
      com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "createTalkRoom clientId is: ", paramString1, "wXgroupId: ", paramString2, " creatorUsrName: ", com.tencent.pb.a.a.a.cOl(), " usrnameList: ", paramList });
      if (paramString1 == null) {
        break label988;
      }
      return true;
      label289:
      i = new Random().nextInt() << 16 | com.tencent.pb.a.a.a.cOl().hashCode() & 0xFFFF;
      break;
      label318:
      if (!com.tencent.pb.common.b.h.isNetworkConnected())
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "createTalkRoom isNetworkConnected is false" });
        h.KC(-4003);
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "noNetwork" });
      }
      else if (localf.bPW())
      {
        if (localf.bPW()) {
          h.KC(-4002);
        }
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "isBusy" });
      }
      else if (TextUtils.isEmpty(paramString1))
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "createTalkRoom cliendId is null" });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "cliendIdnull" });
      }
      else if (!j.agI(paramString1))
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "createTalkRoom groupId is not cliend id: ", paramString1 });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "isnotcliendId" });
      }
      else
      {
        if (c.cRC().agw(paramString1) == null) {
          c.cRC().d(paramString1, paramString2, (String[])localObject1);
        }
        localf.cRO();
        localf.oo(false);
        localf.cRL();
        if (localf.bMH()) {
          break label682;
        }
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "createTalkRoom initEngine fail" });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "initEnginefail" });
        localf.oo(false);
      }
    }
    label682:
    localf.xdZ.cRV();
    localf.kWU = paramString1;
    localf.xel = paramString1;
    localf.wFA = i;
    localf.xdQ = paramString1;
    localf.setState(1);
    localf.pSc = true;
    Object localObject2 = new f.a(localf);
    ((f.a)localObject2).groupId = localf.kWU;
    ((f.a)localObject2).xeO = ((String[])localObject1);
    ((f.a)localObject2).xeP = null;
    ((f.a)localObject2).wGk = i;
    ((f.a)localObject2).type = 0;
    ((f.a)localObject2).xeQ = 0L;
    ((f.a)localObject2).xeR = null;
    ((f.a)localObject2).xeS = false;
    ((f.a)localObject2).xeT = paramString2;
    localObject1 = Message.obtain();
    ((Message)localObject1).what = 2;
    ((Message)localObject1).obj = localObject2;
    localf.mHandler.removeMessages(2);
    localObject2 = c.cRC().agw(localf.kWU);
    if (localObject2 == null) {
      com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup talkroom is null" });
    }
    for (;;)
    {
      localf.mHandler.sendMessage((Message)localObject1);
      localf.xen = true;
      break;
      localObject2 = ((TalkRoom)localObject2).cRw();
      if ((localObject2 == null) || (((List)localObject2).size() != 1))
      {
        com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup TalkRoomMember list is not match" });
      }
      else
      {
        localObject2 = (d)((List)localObject2).get(0);
        if (localObject2 == null) {
          com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup talkRoomMember is null" });
        } else {
          com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup ret: ", Boolean.valueOf(((d)localObject2).cRG()) });
        }
      }
    }
    label988:
    return false;
  }
  
  public final void hM(boolean paramBoolean)
  {
    a.cRq();
    com.tencent.pb.talkroom.sdk.e locale = f.cRT();
    if (locale != null) {}
    for (boolean bool = locale.hI(paramBoolean);; bool = false)
    {
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "switchSpeakerPhone", Boolean.valueOf(paramBoolean), " ret: ", Boolean.valueOf(bool), " realret: ", Boolean.valueOf(f.ys()), " wxCallBack: ", locale });
      return;
    }
  }
  
  public final void og(boolean paramBoolean)
  {
    f localf = a.cRq();
    com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "setMute isMute: ", Boolean.valueOf(paramBoolean) });
    localf.mIsMute = paramBoolean;
    com.tencent.pb.common.c.h.ak(new g.14(localf.xeh, paramBoolean));
  }
  
  public final boolean oh(boolean paramBoolean)
  {
    com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "holadMultiTalk isHold", Boolean.valueOf(paramBoolean) });
    f localf;
    if (paramBoolean)
    {
      localf = a.cRq();
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "syscall", "startHoldOn" });
      localf.xev = true;
      localf.op(false);
      com.tencent.pb.common.c.h.ak(new g.10(localf.xeh));
    }
    do
    {
      return true;
      localf = a.cRq();
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "syscall", "endHoldOn" });
      localf.xev = false;
      localf.cRM();
    } while ((!localf.bPW()) || (!localf.lFT));
    localf.op(true);
    com.tencent.pb.common.c.h.ak(new g.12(localf.xeh));
    return true;
  }
  
  public final int setAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    f localf = a.cRq();
    if (localf.xea == null) {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "setAppCmd type: ", Integer.valueOf(paramInt1), " engine is null" });
    }
    for (int i = -1;; i = localf.xea.xdr.setAppCmd(paramInt1, paramArrayOfByte, paramInt2))
    {
      com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "setAppCmd type: ", Integer.valueOf(paramInt1), " paramLen: ", Integer.valueOf(paramInt2), " ret: ", Integer.valueOf(i) });
      return i;
    }
  }
  
  public final boolean up(int paramInt)
  {
    if (!a.cRq().bPW())
    {
      com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "switchMultiTalkVideo isWorking is false" });
      return false;
    }
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "switchMultiTalkVideo action: ", Integer.valueOf(paramInt) });
    Object localObject = a.cRq();
    if (TextUtils.isEmpty(((f)localObject).kWU))
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "switchMultiTalkVideo mGroupId is null" });
      return false;
    }
    ((f)localObject).xdY = paramInt;
    localObject = new l(((f)localObject).kWU, ((f)localObject).lvU, ((f)localObject).xdR, paramInt);
    boolean bool = com.tencent.pb.common.b.e.cNS().a((com.tencent.pb.common.b.d)localObject);
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "switchMultiTalkVideo ret: ", Boolean.valueOf(bool) });
    return bool;
  }
  
  public final com.tencent.pb.talkroom.sdk.f w(int[] paramArrayOfInt)
  {
    int j = 0;
    Object localObject1 = a.cRq();
    Object localObject2;
    if (((f)localObject1).xea != null)
    {
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "receiveVideo" });
      localObject2 = ((f)localObject1).xea;
      localObject1 = new com.tencent.pb.talkroom.sdk.f();
      if (paramArrayOfInt == null)
      {
        com.tencent.pb.common.c.c.x("simon:TalkRoomContext", new Object[] { "receiveVideo imgBuffer is null" });
        if (paramArrayOfInt != null) {
          break label473;
        }
      }
    }
    label455:
    label473:
    for (int i = j;; i = paramArrayOfInt.length)
    {
      com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "receiveVideo imgBuffer size: ", Integer.valueOf(i), " MultiTalkVideoDecodeInfo: ", localObject1 });
      return localObject1;
      ((com.tencent.pb.talkroom.sdk.f)localObject1).ret = ((b)localObject2).xdr.videoDecode(paramArrayOfInt);
      ((com.tencent.pb.talkroom.sdk.f)localObject1).wJS = paramArrayOfInt;
      ((com.tencent.pb.talkroom.sdk.f)localObject1).wJT = ((b)localObject2).xdr.field_remoteImgLength;
      ((com.tencent.pb.talkroom.sdk.f)localObject1).wJU = ((b)localObject2).xdr.field_remoteImgWidth;
      ((com.tencent.pb.talkroom.sdk.f)localObject1).wJV = ((b)localObject2).xdr.field_remoteImgHeight;
      ((com.tencent.pb.talkroom.sdk.f)localObject1).wJW = (((b)localObject2).xdr.field_remoteImgChannel & 0x3FFF);
      Object localObject3 = c.cRC();
      localObject2 = a.cRq().kWU;
      i = ((com.tencent.pb.talkroom.sdk.f)localObject1).wJW;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getUsrNameByMemberId groupId is null memberId: ", Integer.valueOf(i) });
        label233:
        break label352;
        label234:
        localObject2 = "";
        label239:
        ((com.tencent.pb.talkroom.sdk.f)localObject1).wJQ = ((String)localObject2);
        if (paramArrayOfInt != null) {
          break label455;
        }
      }
      for (i = 0;; i = paramArrayOfInt.length)
      {
        com.tencent.pb.common.c.c.d("simon:TalkRoomContext", new Object[] { "receiveVideo imgBuffer size:", Integer.valueOf(i), " MultiTalkVideoDecodeInfo: ", localObject1 });
        break;
        localObject3 = ((c)localObject3).agw((String)localObject2);
        if (localObject3 == null)
        {
          com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getUsrNameByMemberId talkRoom is null groupId: ", localObject2, " memberId: ", Integer.valueOf(i) });
          break label234;
        }
        localObject3 = ((TalkRoom)localObject3).cRz().iterator();
        label352:
        if (!((Iterator)localObject3).hasNext()) {
          break label234;
        }
        a.av localav = (a.av)((Iterator)localObject3).next();
        if ((localav == null) || (localav.iEo != i)) {
          break label233;
        }
        com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "getUsrNameByMemberId wxUserName:", localav.wHY, " groupId: ", localObject2, " memberId: ", Integer.valueOf(i) });
        if (localav.wHY == null) {
          break label234;
        }
        localObject2 = localav.wHY;
        break label239;
      }
      localObject1 = new com.tencent.pb.talkroom.sdk.f();
      break;
    }
  }
  
  public final boolean y(String paramString, List<String> paramList)
  {
    if (!com.tencent.pb.common.c.g.gK(paramString, a.cRq().kWU))
    {
      com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "addMultiTalkMember groupid is not same; multiTalkGroupid: ", paramString, a.cRq().kWU });
      return false;
    }
    f localf = a.cRq();
    int j = localf.lvU;
    long l = localf.xdR;
    int i;
    boolean bool;
    if (paramList == null)
    {
      i = 0;
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "addrTalkRoomMember", paramString, Integer.valueOf(j), Long.valueOf(l), " users length: ", Integer.valueOf(i) });
      localf.xen = false;
      if ((!TextUtils.isEmpty(paramString)) && (paramList != null)) {
        break label173;
      }
      bool = false;
    }
    for (;;)
    {
      com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "addMultiTalkMember ret: ", Boolean.valueOf(bool) });
      return bool;
      i = paramList.size();
      break;
      label173:
      if (!com.tencent.pb.common.b.h.isNetworkConnected())
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "addTalkRoomMember isNetworkConnected is false" });
        bool = false;
      }
      else
      {
        paramList = f.eE(paramList);
        if (paramList.length <= 0)
        {
          com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "addTalkRoomMember users is null" });
          bool = false;
        }
        else
        {
          paramString = new com.tencent.wecall.talkroom.a.b(paramString, localf.lvU, localf.xdR, paramList);
          bool = com.tencent.pb.common.b.e.cNS().a(paramString);
          localf.xdZ.R(new String[] { "add", "req", String.valueOf(bool), String.valueOf(localf.state) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.e
 * JD-Core Version:    0.7.0.1
 */