package com.tencent.mm.plugin.multitalk.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.tencent.mars.ilink.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.protocal.protobuf.afl;
import com.tencent.mm.protocal.protobuf.afo;
import com.tencent.mm.protocal.protobuf.fki;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.util.b.a;
import com.tencent.wxmm.IConfCallBack;
import com.tencent.wxmm.v2conference;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class l
{
  private static boolean hasInit;
  private static final String[] wTv;
  private static v2conference wUC;
  
  static
  {
    AppMethodBeat.i(285279);
    wTv = new String[] { "ilink_network", "ilink_xlog", "confService" };
    hasInit = false;
    wUC = new v2conference();
    AppMethodBeat.o(285279);
  }
  
  public static int F(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(285180);
    paramInt1 = wUC.SendAudioData(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(285180);
    return paramInt1;
  }
  
  public static void H(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(285272);
    wUC.RecvNotify(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(285272);
  }
  
  public static int Jf(int paramInt)
  {
    AppMethodBeat.i(285197);
    paramInt = wUC.GetVoiceActivity(paramInt);
    AppMethodBeat.o(285197);
    return paramInt;
  }
  
  static int Jg(int paramInt)
  {
    AppMethodBeat.i(285203);
    paramInt = wUC.ExitRoom(paramInt);
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "exitRoom ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(285203);
    return paramInt;
  }
  
  public static void Jh(int paramInt)
  {
    AppMethodBeat.i(285219);
    String str = gej();
    wUC.OnNetworkChange(paramInt, str.getBytes());
    AppMethodBeat.o(285219);
  }
  
  public static int Q(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(285186);
    paramInt = wUC.GetAudioData(paramArrayOfByte, paramInt);
    AppMethodBeat.o(285186);
    return paramInt;
  }
  
  public static int R(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(285194);
    paramInt = wUC.GetDecodeVideoData(paramArrayOfByte, paramInt);
    AppMethodBeat.o(285194);
    return paramInt;
  }
  
  public static int Y(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(285254);
    paramInt = wUC.SetAppCmd(10, paramArrayOfByte, paramInt);
    AppMethodBeat.o(285254);
    return paramInt;
  }
  
  public static int a(fki paramfki)
  {
    int j = -1;
    AppMethodBeat.i(285248);
    if (paramfki == null)
    {
      Log.e("MicroMsg.Multitalk.ILinkNativeEngine", "steve: videoResParam is null");
      AppMethodBeat.o(285248);
      return -1;
    }
    int i = j;
    try
    {
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "videoResParam:" + paramfki + ",length:" + paramfki.toByteArray().length);
      i = j;
      j = wUC.SubscribeVideo(paramfki.toByteArray(), paramfki.toByteArray().length);
      i = j;
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "steve: subScribeVideoAndResList ret:".concat(String.valueOf(j)));
      i = j;
    }
    catch (IOException paramfki)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", paramfki, "SetVideoResolution exception", new Object[0]);
      }
    }
    AppMethodBeat.o(285248);
    return i;
  }
  
  public static int a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, IConfCallBack paramIConfCallBack)
  {
    AppMethodBeat.i(285153);
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "hy: init voip");
    Object localObject1 = MMApplicationContext.getContext();
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "prepareOpenVoiceEnv, hasInit " + hasInit);
    Object localObject2;
    if (!hasInit)
    {
      hasInit = true;
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "hy: load so");
      localObject2 = wTv;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject2[i];
        l.class.getClassLoader();
        k.DA(str);
        i += 1;
      }
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "load so end");
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label522;
      }
      PlatformComm.init((Context)localObject1, new Handler(Looper.getMainLooper()));
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "main thread exec PlatformComm.init");
    }
    for (;;)
    {
      try
      {
        localObject1 = new afk();
        ((afk)localObject1).app_id = "wechat";
        ((afk)localObject1).ZnR = paramString1;
        ((afk)localObject1).Zor = paramString2;
        ((afk)localObject1).ZnS = (com.tencent.mm.loader.i.b.bmq() + "/ilink");
        ((afk)localObject1).Zot = 1;
        paramString1 = com.tencent.mm.util.i.agtt;
        ((afk)localObject1).ZnT = com.tencent.mm.util.i.a(b.a.agsT, 0);
        ((afk)localObject1).ZnV = 1;
        ((afk)localObject1).ZnW = r.dqY();
        ((afk)localObject1).ZnX = paramInt1;
        ((afk)localObject1).ZnY = paramInt2;
        ((afk)localObject1).ZnZ = paramInt3;
        ((afk)localObject1).Zoe = n.getNumCores();
        ((afk)localObject1).Zof = Util.getInt(m.aON(), 0);
        ((afk)localObject1).Zog = m.aOK();
        ((afk)localObject1).Zoh = Build.MANUFACTURER;
        ((afk)localObject1).Zoi = q.aPo();
        ((afk)localObject1).Zoj = Build.VERSION.RELEASE;
        ((afk)localObject1).Zok = Build.VERSION.INCREMENTAL;
        ((afk)localObject1).Zol = Build.DISPLAY;
        ((afk)localObject1).Zoo = gej();
        ((afk)localObject1).Zoa = 2;
        paramInt2 = ((a)com.tencent.mm.kernel.h.ax(a.class)).aaG(2);
        paramInt1 = paramInt2;
        if (paramInt2 == 3) {
          paramInt1 = 1;
        }
        if (SubCoreVoip.hVs())
        {
          ((afk)localObject1).Zop = paramInt1;
          paramString1 = q.eD(false);
          if ((paramString1 == null) || (paramString1.isEmpty())) {
            break label637;
          }
          ((afk)localObject1).Zom = com.tencent.mm.bx.b.cX(MD5Util.getMD5String(paramString1).getBytes());
          ((afk)localObject1).Zon = Build.VERSION.RELEASE;
          ((afk)localObject1).Zoq = String.format("0x%x", new Object[] { Integer.valueOf(d.Yxh) });
          Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "envInfo:" + new String(((afk)localObject1).toByteArray()) + ",length:" + ((afk)localObject1).toByteArray().length);
          paramInt1 = wUC.InitSDK(((afk)localObject1).toByteArray(), ((afk)localObject1).toByteArray().length, paramIConfCallBack);
        }
      }
      catch (IOException paramString1)
      {
        label522:
        paramInt1 = -1;
      }
      try
      {
        Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "init ret:".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(285153);
        return paramInt1;
      }
      catch (IOException paramString1)
      {
        break label621;
      }
      localObject2 = new ConditionVariable();
      com.tencent.threadpool.h.ahAA.bl(new l.1((Context)localObject1, (ConditionVariable)localObject2));
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "condition block wait for open");
      ((ConditionVariable)localObject2).block(2000L);
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "condition block release...");
      continue;
      ((afk)localObject1).Zop = (paramInt1 + 65536);
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "isVoipDoubleLinkSettingOpen false, setsimtype " + ((afk)localObject1).Zop);
      continue;
      label621:
      Log.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", paramString1, "envInfo exception", new Object[0]);
      continue;
      label637:
      Log.e("MicroMsg.Multitalk.ILinkNativeEngine", "getDeviceId failed");
    }
  }
  
  public static int a(LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(285175);
    int i = -1;
    afl localafl = new afl();
    localafl.Zow = paramLinkedList;
    localafl.Zox = paramInt1;
    localafl.Zoy = true;
    localafl.Zoz = paramInt2;
    paramInt1 = i;
    try
    {
      paramInt2 = wUC.Invite(localafl.toByteArray(), localafl.toByteArray().length);
      paramInt1 = paramInt2;
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "steve: invite ret:".concat(String.valueOf(paramInt2)));
      paramInt1 = paramInt2;
    }
    catch (IOException paramLinkedList)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", paramLinkedList, "Invite exception", new Object[0]);
      }
    }
    AppMethodBeat.o(285175);
    return paramInt1;
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(285243);
    if ((paramArrayOfByte2 != null) && (wUC != null))
    {
      paramInt1 = wUC.imgClip(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3, paramInt4, paramInt5, 0);
      AppMethodBeat.o(285243);
      return paramInt1;
    }
    Log.e("MicroMsg.Multitalk.ILinkNativeEngine", "steve:imgClip null,  engine:" + wUC);
    AppMethodBeat.o(285243);
    return -1;
  }
  
  public static t a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(285237);
    if ((paramArrayOfByte != null) && (wUC != null))
    {
      paramInt1 = wUC.videoTrans(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
      paramArrayOfByte = new t();
      paramArrayOfByte.Lml = paramArrayOfInt;
      paramArrayOfByte.Lmm = wUC.field_localImgWidth;
      paramArrayOfByte.Lmn = wUC.field_localImgHeight;
      paramArrayOfByte.ret = paramInt1;
      AppMethodBeat.o(285237);
      return paramArrayOfByte;
    }
    Log.e("MicroMsg.Multitalk.ILinkNativeEngine", "steve:videoTrans null,  engine:" + wUC);
    AppMethodBeat.o(285237);
    return null;
  }
  
  private static boolean a(ConnectivityManager paramConnectivityManager)
  {
    AppMethodBeat.i(285122);
    try
    {
      Method localMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(paramConnectivityManager, new Object[0])).booleanValue();
      AppMethodBeat.o(285122);
      return bool;
    }
    catch (Exception paramConnectivityManager)
    {
      AppMethodBeat.o(285122);
    }
    return false;
  }
  
  public static int aE(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(285168);
    afo localafo = new afo();
    localafo.YzM = paramString;
    localafo.Zox = paramInt1;
    localafo.Zoz = paramInt2;
    localafo.Zoy = true;
    paramInt1 = -1;
    try
    {
      paramInt2 = wUC.JoinRoom(localafo.toByteArray(), localafo.toByteArray().length);
      paramInt1 = paramInt2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", localIOException, "JoinRoom exception", new Object[0]);
      }
    }
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "joinRoom ret:" + paramInt1 + ", groupId:" + paramString);
    AppMethodBeat.o(285168);
    return paramInt1;
  }
  
  public static int abp(int paramInt)
  {
    AppMethodBeat.i(285206);
    paramInt = wUC.Hangup(paramInt);
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "Hangup ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(285206);
    return paramInt;
  }
  
  public static int alY(String paramString)
  {
    AppMethodBeat.i(285155);
    int i = wUC.UpdateAuthKey(paramString.getBytes(), paramString.getBytes().length);
    AppMethodBeat.o(285155);
    return i;
  }
  
  public static int b(LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(285265);
    int i = -1;
    afl localafl = new afl();
    localafl.Zow = paramLinkedList;
    localafl.Zox = paramInt1;
    localafl.Zoz = paramInt2;
    paramInt1 = i;
    try
    {
      paramInt2 = wUC.Add(localafl.toByteArray(), localafl.toByteArray().length);
      paramInt1 = paramInt2;
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "steve: addmember ret:".concat(String.valueOf(paramInt2)));
      paramInt1 = paramInt2;
    }
    catch (IOException paramLinkedList)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", paramLinkedList, "Invite exception", new Object[0]);
      }
    }
    AppMethodBeat.o(285265);
    return paramInt1;
  }
  
  public static void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(285227);
    v2conference localv2conference = wUC;
    int i;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label46;
      }
    }
    for (;;)
    {
      localv2conference.SwitchAV(i, j, paramInt);
      AppMethodBeat.o(285227);
      return;
      i = 0;
      break;
      label46:
      j = 0;
    }
  }
  
  public static int d(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(285213);
    paramInt1 = wUC.SetAppCmd(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(285213);
    return paramInt1;
  }
  
  public static v2conference dri()
  {
    return wUC;
  }
  
  public static int drj()
  {
    AppMethodBeat.i(285210);
    int i = wUC.UnInit();
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "unInit ret:".concat(String.valueOf(i)));
    AppMethodBeat.o(285210);
    return i;
  }
  
  public static int e(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(285189);
    paramInt1 = wUC.SendVideoData(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(285189);
    return paramInt1;
  }
  
  private static String gej()
  {
    AppMethodBeat.i(285129);
    if (!a((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")))
    {
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "mobile network not connectedorconnecting");
      AppMethodBeat.o(285129);
      return "";
    }
    String str = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone")).getSimOperator();
    if ((str == null) || (str.length() < 3))
    {
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "nic_op NULL");
      AppMethodBeat.o(285129);
      return "";
    }
    str = str.substring(0, 3) + ":" + str.substring(3, str.length());
    AppMethodBeat.o(285129);
    return str;
  }
  
  public static int gek()
  {
    AppMethodBeat.i(285257);
    byte[] arrayOfByte = new byte[4];
    wUC.SetAppCmd(54, arrayOfByte, 1);
    Log.d("MicroMsg.Multitalk.ILinkNativeEngine", "checkUsingMultiPathCellularConn: %d", new Object[] { Byte.valueOf(arrayOfByte[0]) });
    int i = arrayOfByte[0];
    AppMethodBeat.o(285257);
    return i;
  }
  
  public static void gel()
  {
    AppMethodBeat.i(285268);
    wUC.Ack();
    AppMethodBeat.o(285268);
  }
  
  public static int gem()
  {
    AppMethodBeat.i(285277);
    int i = wUC.Accept(1);
    AppMethodBeat.o(285277);
    return i;
  }
  
  public static int videoHWProcess(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(285232);
    paramInt1 = wUC.videoHWProcess(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2, paramInt5, paramInt6);
    AppMethodBeat.o(285232);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.l
 * JD-Core Version:    0.7.0.1
 */