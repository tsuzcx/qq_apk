package com.tencent.mm.plugin.multitalk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.tencent.e.i;
import com.tencent.mars.ilink.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.adc;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.protocal.protobuf.epj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxmm.IConfCallBack;
import com.tencent.wxmm.v2conference;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class l
{
  private static boolean hasInit;
  private static final String[] tQf;
  private static v2conference tRm;
  
  static
  {
    AppMethodBeat.i(199821);
    tQf = new String[] { "ilink_network", "ilink_xlog", "confService" };
    hasInit = false;
    tRm = new v2conference();
    AppMethodBeat.o(199821);
  }
  
  public static int H(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199778);
    paramInt1 = tRm.SendAudioData(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(199778);
    return paramInt1;
  }
  
  public static int IC(int paramInt)
  {
    AppMethodBeat.i(199783);
    paramInt = tRm.GetVoiceActivity(paramInt);
    AppMethodBeat.o(199783);
    return paramInt;
  }
  
  static int ID(int paramInt)
  {
    AppMethodBeat.i(199784);
    paramInt = tRm.ExitRoom(paramInt);
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "exitRoom ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(199784);
    return paramInt;
  }
  
  public static void IE(int paramInt)
  {
    AppMethodBeat.i(199790);
    String str = eVs();
    tRm.OnNetworkChange(paramInt, str.getBytes());
    AppMethodBeat.o(199790);
  }
  
  public static void J(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199816);
    tRm.RecvNotify(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(199816);
  }
  
  public static int S(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(199779);
    paramInt = tRm.GetAudioData(paramArrayOfByte, paramInt);
    AppMethodBeat.o(199779);
    return paramInt;
  }
  
  public static int T(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(199782);
    paramInt = tRm.GetDecodeVideoData(paramArrayOfByte, paramInt);
    AppMethodBeat.o(199782);
    return paramInt;
  }
  
  public static int Xn(int paramInt)
  {
    AppMethodBeat.i(199785);
    paramInt = tRm.Hangup(paramInt);
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "Hangup ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(199785);
    return paramInt;
  }
  
  public static int Z(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(199809);
    paramInt = tRm.SetAppCmd(10, paramArrayOfByte, paramInt);
    AppMethodBeat.o(199809);
    return paramInt;
  }
  
  public static int a(epj paramepj)
  {
    int j = -1;
    AppMethodBeat.i(199808);
    if (paramepj == null)
    {
      Log.e("MicroMsg.Multitalk.ILinkNativeEngine", "steve: videoResParam is null");
      AppMethodBeat.o(199808);
      return -1;
    }
    int i = j;
    try
    {
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "videoResParam:" + paramepj + ",length:" + paramepj.toByteArray().length);
      i = j;
      j = tRm.SubscribeVideo(paramepj.toByteArray(), paramepj.toByteArray().length);
      i = j;
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "steve: subScribeVideoAndResList ret:".concat(String.valueOf(j)));
      i = j;
    }
    catch (IOException paramepj)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", paramepj, "SetVideoResolution exception", new Object[0]);
      }
    }
    AppMethodBeat.o(199808);
    return i;
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, int paramInt3, IConfCallBack paramIConfCallBack)
  {
    AppMethodBeat.i(199763);
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "hy: init voip");
    Object localObject1 = MMApplicationContext.getContext();
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "prepareOpenVoiceEnv, hasInit " + hasInit);
    Object localObject2;
    if (!hasInit)
    {
      hasInit = true;
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "hy: load so");
      localObject2 = tQf;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject2[i];
        l.class.getClassLoader();
        j.KW(str);
        i += 1;
      }
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "load so end");
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label505;
      }
      PlatformComm.init((Context)localObject1, new Handler(Looper.getMainLooper()));
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "main thread exec PlatformComm.init");
    }
    for (;;)
    {
      try
      {
        localObject1 = new adc();
        ((adc)localObject1).app_id = "wechat";
        ((adc)localObject1).Spa = paramString;
        ((adc)localObject1).Spb = (com.tencent.mm.loader.j.b.aSC() + "/ilink");
        ((adc)localObject1).Spm = 1;
        ((adc)localObject1).Spc = 0;
        ((adc)localObject1).Spe = 1;
        ((adc)localObject1).Spf = r.cNs();
        ((adc)localObject1).Spg = paramInt1;
        ((adc)localObject1).Sph = paramInt2;
        ((adc)localObject1).Spi = paramInt3;
        ((adc)localObject1).Spp = n.getNumCores();
        ((adc)localObject1).Spq = Util.getInt(m.auu(), 0);
        ((adc)localObject1).Spr = m.aus();
        ((adc)localObject1).Sps = Build.MANUFACTURER;
        ((adc)localObject1).Spt = Build.MODEL;
        ((adc)localObject1).Spu = Build.VERSION.RELEASE;
        ((adc)localObject1).Spv = Build.VERSION.INCREMENTAL;
        ((adc)localObject1).Spw = Build.DISPLAY;
        ((adc)localObject1).Spz = eVs();
        ((adc)localObject1).Spl = 2;
        paramInt2 = ((a)com.tencent.mm.kernel.h.ae(a.class)).WE(2);
        paramInt1 = paramInt2;
        if (paramInt2 == 3) {
          paramInt1 = 1;
        }
        if (c.gxv())
        {
          ((adc)localObject1).SpA = paramInt1;
          paramString = q.dR(false);
          if ((paramString == null) || (paramString.isEmpty())) {
            break label620;
          }
          ((adc)localObject1).Spx = com.tencent.mm.cd.b.cU(MD5Util.getMD5String(paramString).getBytes());
          ((adc)localObject1).Spy = Build.VERSION.RELEASE;
          ((adc)localObject1).SpB = String.format("0x%x", new Object[] { Integer.valueOf(d.RAD) });
          Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "envInfo:" + new String(((adc)localObject1).toByteArray()) + ",length:" + ((adc)localObject1).toByteArray().length);
          paramInt1 = tRm.InitSDK(((adc)localObject1).toByteArray(), ((adc)localObject1).toByteArray().length, paramIConfCallBack);
        }
      }
      catch (IOException paramString)
      {
        label505:
        paramInt1 = -1;
      }
      try
      {
        Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "init ret:".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(199763);
        return paramInt1;
      }
      catch (IOException paramString)
      {
        break label604;
      }
      localObject2 = new ConditionVariable();
      com.tencent.e.h.ZvG.bd(new l.1((Context)localObject1, (ConditionVariable)localObject2));
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "condition block wait for open");
      ((ConditionVariable)localObject2).block(2000L);
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "condition block release...");
      continue;
      ((adc)localObject1).SpA = (paramInt1 + 65536);
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "isVoipDoubleLinkSettingOpen false, setsimtype " + ((adc)localObject1).SpA);
      continue;
      label604:
      Log.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", paramString, "envInfo exception", new Object[0]);
      continue;
      label620:
      Log.e("MicroMsg.Multitalk.ILinkNativeEngine", "getDeviceId failed");
    }
  }
  
  public static int a(LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199776);
    int i = -1;
    add localadd = new add();
    localadd.SpC = paramLinkedList;
    localadd.SpD = paramInt1;
    localadd.SpE = true;
    localadd.SpF = paramInt2;
    paramInt1 = i;
    try
    {
      paramInt2 = tRm.Invite(localadd.toByteArray(), localadd.toByteArray().length);
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
    AppMethodBeat.o(199776);
    return paramInt1;
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(199804);
    if ((paramArrayOfByte2 != null) && (tRm != null))
    {
      paramInt1 = tRm.imgClip(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3, paramInt4, paramInt5, 0);
      AppMethodBeat.o(199804);
      return paramInt1;
    }
    Log.e("MicroMsg.Multitalk.ILinkNativeEngine", "steve:imgClip null,  engine:" + tRm);
    AppMethodBeat.o(199804);
    return -1;
  }
  
  public static t a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(199802);
    if ((paramArrayOfByte != null) && (tRm != null))
    {
      paramInt1 = tRm.videoTrans(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
      paramArrayOfByte = new t();
      paramArrayOfByte.Fqb = paramArrayOfInt;
      paramArrayOfByte.Fqc = tRm.field_localImgWidth;
      paramArrayOfByte.Fqd = tRm.field_localImgHeight;
      paramArrayOfByte.ret = paramInt1;
      AppMethodBeat.o(199802);
      return paramArrayOfByte;
    }
    Log.e("MicroMsg.Multitalk.ILinkNativeEngine", "steve:videoTrans null,  engine:" + tRm);
    AppMethodBeat.o(199802);
    return null;
  }
  
  private static boolean a(ConnectivityManager paramConnectivityManager)
  {
    AppMethodBeat.i(199742);
    try
    {
      Method localMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(paramConnectivityManager, new Object[0])).booleanValue();
      AppMethodBeat.o(199742);
      return bool;
    }
    catch (Exception paramConnectivityManager)
    {
      AppMethodBeat.o(199742);
    }
    return false;
  }
  
  public static int ast(String paramString)
  {
    AppMethodBeat.i(199765);
    int i = tRm.UpdateAuthKey(paramString.getBytes(), paramString.getBytes().length);
    AppMethodBeat.o(199765);
    return i;
  }
  
  public static int ax(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199771);
    adg localadg = new adg();
    localadg.RDj = paramString;
    localadg.SpD = paramInt1;
    localadg.SpF = paramInt2;
    localadg.SpE = true;
    paramInt1 = -1;
    try
    {
      paramInt2 = tRm.JoinRoom(localadg.toByteArray(), localadg.toByteArray().length);
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
    AppMethodBeat.o(199771);
    return paramInt1;
  }
  
  public static int b(LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199813);
    int i = -1;
    add localadd = new add();
    localadd.SpC = paramLinkedList;
    localadd.SpD = paramInt1;
    localadd.SpF = paramInt2;
    paramInt1 = i;
    try
    {
      paramInt2 = tRm.Add(localadd.toByteArray(), localadd.toByteArray().length);
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
    AppMethodBeat.o(199813);
    return paramInt1;
  }
  
  public static void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(199793);
    v2conference localv2conference = tRm;
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
      AppMethodBeat.o(199793);
      return;
      i = 0;
      break;
      label46:
      j = 0;
    }
  }
  
  public static int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(199781);
    paramInt1 = tRm.SendVideoData(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(199781);
    return paramInt1;
  }
  
  public static v2conference cNC()
  {
    return tRm;
  }
  
  public static int cND()
  {
    AppMethodBeat.i(199787);
    int i = tRm.UnInit();
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "unInit ret:".concat(String.valueOf(i)));
    AppMethodBeat.o(199787);
    return i;
  }
  
  public static int e(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(199789);
    paramInt1 = tRm.SetAppCmd(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(199789);
    return paramInt1;
  }
  
  private static String eVs()
  {
    AppMethodBeat.i(199746);
    if (!a((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")))
    {
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "mobile network not connectedorconnecting");
      AppMethodBeat.o(199746);
      return "";
    }
    String str = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone")).getSimOperator();
    if ((str == null) || (str.length() < 3))
    {
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "nic_op NULL");
      AppMethodBeat.o(199746);
      return "";
    }
    str = str.substring(0, 3) + ":" + str.substring(3, str.length());
    AppMethodBeat.o(199746);
    return str;
  }
  
  public static int eVt()
  {
    AppMethodBeat.i(199811);
    byte[] arrayOfByte = new byte[4];
    tRm.SetAppCmd(54, arrayOfByte, 1);
    Log.d("MicroMsg.Multitalk.ILinkNativeEngine", "checkUsingMultiPathCellularConn: %d", new Object[] { Byte.valueOf(arrayOfByte[0]) });
    int i = arrayOfByte[0];
    AppMethodBeat.o(199811);
    return i;
  }
  
  public static void eVu()
  {
    AppMethodBeat.i(199814);
    tRm.Ack();
    AppMethodBeat.o(199814);
  }
  
  public static int eVv()
  {
    AppMethodBeat.i(199819);
    int i = tRm.Accept(1);
    AppMethodBeat.o(199819);
    return i;
  }
  
  public static int videoHWProcess(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(199796);
    paramInt1 = tRm.videoHWProcess(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2, paramInt5, paramInt6);
    AppMethodBeat.o(199796);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.l
 * JD-Core Version:    0.7.0.1
 */