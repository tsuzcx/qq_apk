package com.tencent.mm.plugin.multitalk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.acy;
import com.tencent.mm.protocal.protobuf.efi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxmm.IConfCallBack;
import com.tencent.wxmm.v2conference;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class m
{
  private static final String[] qrx;
  private static v2conference qsB;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(239085);
    qrx = new String[] { "ilink_network", "ilink_xlog", "confService" };
    Context localContext = MMApplicationContext.getContext();
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "hy: load so");
    String[] arrayOfString = qrx;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      m.class.getClassLoader();
      j.Ed(str);
      i += 1;
    }
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "load so end");
    h.RTc.aW(new m.1(localContext));
    qsB = new v2conference();
    AppMethodBeat.o(239085);
  }
  
  public static int EU(int paramInt)
  {
    AppMethodBeat.i(239070);
    paramInt = qsB.GetVoiceActivity(paramInt);
    AppMethodBeat.o(239070);
    return paramInt;
  }
  
  static int EV(int paramInt)
  {
    AppMethodBeat.i(239071);
    paramInt = qsB.ExitRoom(paramInt);
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "exitRoom ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(239071);
    return paramInt;
  }
  
  public static void EW(int paramInt)
  {
    AppMethodBeat.i(239075);
    String str = elH();
    qsB.OnNetworkChange(paramInt, str.getBytes());
    AppMethodBeat.o(239075);
  }
  
  public static int F(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239066);
    paramInt1 = qsB.SendAudioData(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(239066);
    return paramInt1;
  }
  
  public static void H(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239083);
    qsB.RecvNotify(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(239083);
  }
  
  public static void Q(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(239076);
    v2conference localv2conference = qsB;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localv2conference.SwitchAV(1, i, paramInt);
      AppMethodBeat.o(239076);
      return;
    }
  }
  
  public static int QZ(int paramInt)
  {
    AppMethodBeat.i(239072);
    paramInt = qsB.Hangup(paramInt);
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "Hangup ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(239072);
    return paramInt;
  }
  
  public static int R(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(239067);
    paramInt = qsB.GetAudioData(paramArrayOfByte, paramInt);
    AppMethodBeat.o(239067);
    return paramInt;
  }
  
  public static int W(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(239069);
    paramInt = qsB.GetDecodeVideoData(paramArrayOfByte, paramInt);
    AppMethodBeat.o(239069);
    return paramInt;
  }
  
  public static int X(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(239080);
    paramInt = qsB.SetAppCmd(10, paramArrayOfByte, paramInt);
    AppMethodBeat.o(239080);
    return paramInt;
  }
  
  public static int a(efi paramefi)
  {
    int j = -1;
    AppMethodBeat.i(239079);
    if (paramefi == null)
    {
      Log.e("MicroMsg.Multitalk.ILinkNativeEngine", "steve: videoResParam is null");
      AppMethodBeat.o(239079);
      return -1;
    }
    int i = j;
    try
    {
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "videoResParam:" + paramefi + ",length:" + paramefi.toByteArray().length);
      i = j;
      j = qsB.SubscribeVideo(paramefi.toByteArray(), paramefi.toByteArray().length);
      i = j;
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "steve: subScribeVideoAndResList ret:".concat(String.valueOf(j)));
      i = j;
    }
    catch (IOException paramefi)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", paramefi, "SetVideoResolution exception", new Object[0]);
      }
    }
    AppMethodBeat.o(239079);
    return i;
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, int paramInt3, IConfCallBack paramIConfCallBack)
  {
    AppMethodBeat.i(239062);
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "hy: init voip");
    for (;;)
    {
      try
      {
        acu localacu = new acu();
        localacu.app_id = "wechat";
        localacu.LnF = paramString;
        localacu.LnG = (com.tencent.mm.loader.j.b.aKA() + "/ilink");
        localacu.LnR = 1;
        localacu.LnH = 0;
        localacu.LnJ = 1;
        localacu.LnK = s.cyW();
        localacu.LnL = paramInt1;
        localacu.LnM = paramInt2;
        localacu.LnN = paramInt3;
        localacu.LnS = n.getNumCores();
        localacu.LnT = Util.getInt(com.tencent.mm.compatible.deviceinfo.m.aop(), 0);
        localacu.LnU = com.tencent.mm.compatible.deviceinfo.m.aon();
        localacu.LnV = Build.MANUFACTURER;
        localacu.LnW = Build.MODEL;
        localacu.LnX = Build.VERSION.RELEASE;
        localacu.LnY = Build.VERSION.INCREMENTAL;
        localacu.LnZ = Build.DISPLAY;
        localacu.Loc = elH();
        localacu.LnQ = 2;
        paramInt2 = ((a)g.af(a.class)).Qr(2);
        paramInt1 = paramInt2;
        if (paramInt2 == 3) {
          paramInt1 = 1;
        }
        localacu.Lod = paramInt1;
        paramString = q.dr(false);
        if ((paramString != null) && (!paramString.isEmpty()))
        {
          localacu.Loa = com.tencent.mm.bw.b.cD(MD5Util.getMD5String(paramString).getBytes());
          localacu.Lob = Build.VERSION.RELEASE;
          Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "envInfo:" + new String(localacu.toByteArray()) + ",length:" + localacu.toByteArray().length);
          paramInt1 = qsB.InitSDK(localacu.toByteArray(), localacu.toByteArray().length, paramIConfCallBack);
        }
      }
      catch (IOException paramString)
      {
        paramInt1 = -1;
      }
      try
      {
        Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "init ret:".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(239062);
        return paramInt1;
      }
      catch (IOException paramString)
      {
        break label359;
      }
      Log.e("MicroMsg.Multitalk.ILinkNativeEngine", "getDeviceId failed");
      continue;
      label359:
      Log.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", paramString, "envInfo exception", new Object[0]);
    }
  }
  
  public static int a(LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239065);
    int i = -1;
    acv localacv = new acv();
    localacv.Loe = paramLinkedList;
    localacv.Lof = paramInt1;
    localacv.Log = true;
    localacv.Loh = paramInt2;
    paramInt1 = i;
    try
    {
      paramInt2 = qsB.Invite(localacv.toByteArray(), localacv.toByteArray().length);
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
    AppMethodBeat.o(239065);
    return paramInt1;
  }
  
  public static u a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(239078);
    if ((paramArrayOfByte != null) && (qsB != null))
    {
      paramInt1 = qsB.videoTrans(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
      paramArrayOfByte = new u();
      paramArrayOfByte.zKJ = paramArrayOfInt;
      paramArrayOfByte.zKK = qsB.field_localImgWidth;
      paramArrayOfByte.zKL = qsB.field_localImgHeight;
      paramArrayOfByte.ret = paramInt1;
      AppMethodBeat.o(239078);
      return paramArrayOfByte;
    }
    Log.e("MicroMsg.Multitalk.ILinkNativeEngine", "steve:videoTrans null,  engine:" + qsB);
    AppMethodBeat.o(239078);
    return null;
  }
  
  private static boolean a(ConnectivityManager paramConnectivityManager)
  {
    AppMethodBeat.i(239060);
    try
    {
      Method localMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(paramConnectivityManager, new Object[0])).booleanValue();
      AppMethodBeat.o(239060);
      return bool;
    }
    catch (Exception paramConnectivityManager)
    {
      AppMethodBeat.o(239060);
    }
    return false;
  }
  
  public static int akF(String paramString)
  {
    AppMethodBeat.i(239063);
    int i = qsB.UpdateAuthKey(paramString.getBytes(), paramString.getBytes().length);
    AppMethodBeat.o(239063);
    return i;
  }
  
  public static int av(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239064);
    acy localacy = new acy();
    localacy.KBt = paramString;
    localacy.Lof = paramInt1;
    localacy.Loh = paramInt2;
    localacy.Log = true;
    paramInt1 = -1;
    try
    {
      paramInt2 = qsB.JoinRoom(localacy.toByteArray(), localacy.toByteArray().length);
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
    AppMethodBeat.o(239064);
    return paramInt1;
  }
  
  public static int b(LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239081);
    int i = -1;
    acv localacv = new acv();
    localacv.Loe = paramLinkedList;
    localacv.Lof = paramInt1;
    localacv.Loh = paramInt2;
    paramInt1 = i;
    try
    {
      paramInt2 = qsB.Add(localacv.toByteArray(), localacv.toByteArray().length);
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
    AppMethodBeat.o(239081);
    return paramInt1;
  }
  
  public static int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(239068);
    paramInt1 = qsB.SendVideoData(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(239068);
    return paramInt1;
  }
  
  public static void czc()
  {
    AppMethodBeat.i(239059);
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "preloadInit");
    AppMethodBeat.o(239059);
  }
  
  public static v2conference czd()
  {
    return qsB;
  }
  
  public static int cze()
  {
    AppMethodBeat.i(239073);
    int i = qsB.UnInit();
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "unInit ret:".concat(String.valueOf(i)));
    AppMethodBeat.o(239073);
    return i;
  }
  
  public static int e(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(239074);
    paramInt1 = qsB.SetAppCmd(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(239074);
    return paramInt1;
  }
  
  private static String elH()
  {
    AppMethodBeat.i(239061);
    if (!a((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")))
    {
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "mobile network not connectedorconnecting");
      AppMethodBeat.o(239061);
      return "";
    }
    String str = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone")).getSimOperator();
    if ((str == null) || (str.length() < 3))
    {
      Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "nic_op NULL");
      AppMethodBeat.o(239061);
      return "";
    }
    str = str.substring(0, 3) + ":" + str.substring(3, str.length());
    AppMethodBeat.o(239061);
    return str;
  }
  
  public static void elI()
  {
    AppMethodBeat.i(239082);
    qsB.Ack();
    AppMethodBeat.o(239082);
  }
  
  public static int elJ()
  {
    AppMethodBeat.i(239084);
    int i = qsB.Accept(1);
    AppMethodBeat.o(239084);
    return i;
  }
  
  public static int videoHWProcess(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(239077);
    paramInt1 = qsB.videoHWProcess(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2, paramInt5, paramInt6);
    AppMethodBeat.o(239077);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.m
 * JD-Core Version:    0.7.0.1
 */