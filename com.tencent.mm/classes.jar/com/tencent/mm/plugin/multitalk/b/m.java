package com.tencent.mm.plugin.multitalk.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.protocal.protobuf.aaw;
import com.tencent.mm.protocal.protobuf.aax;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.wxmm.IConfCallBack;
import com.tencent.wxmm.v2conference;
import java.io.IOException;
import java.util.LinkedList;

public class m
{
  private static final String[] pcy;
  private static v2conference pdB;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(190506);
    pcy = new String[] { "ilink_network", "ilink_xlog", "confService" };
    Context localContext = ak.getContext();
    ae.i("MicroMsg.Multitalk.ILinkNativeEngine", "hy: load so");
    String[] arrayOfString = pcy;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      m.class.getClassLoader();
      j.vN(str);
      i += 1;
    }
    h.MqF.aN(new m.1(localContext));
    pdB = new v2conference();
    AppMethodBeat.o(190506);
  }
  
  public static int Bm(int paramInt)
  {
    AppMethodBeat.i(190491);
    paramInt = pdB.GetVoiceActivity(paramInt);
    AppMethodBeat.o(190491);
    return paramInt;
  }
  
  static int Bn(int paramInt)
  {
    AppMethodBeat.i(190492);
    paramInt = pdB.ExitRoom(paramInt);
    ae.i("MicroMsg.Multitalk.ILinkNativeEngine", "exitRoom ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(190492);
    return paramInt;
  }
  
  public static void Bo(int paramInt)
  {
    AppMethodBeat.i(190496);
    pdB.OnNetworkChange(paramInt);
    AppMethodBeat.o(190496);
  }
  
  public static int KY(int paramInt)
  {
    AppMethodBeat.i(190493);
    paramInt = pdB.Hangup(paramInt);
    ae.i("MicroMsg.Multitalk.ILinkNativeEngine", "Hangup ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(190493);
    return paramInt;
  }
  
  public static int KZ(int paramInt)
  {
    AppMethodBeat.i(190505);
    paramInt = pdB.Accept(paramInt);
    AppMethodBeat.o(190505);
    return paramInt;
  }
  
  public static void N(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(190497);
    v2conference localv2conference = pdB;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localv2conference.SwitchAV(1, i, paramInt);
      AppMethodBeat.o(190497);
      return;
    }
  }
  
  public static int P(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(190488);
    paramInt = pdB.GetAudioData(paramArrayOfByte, paramInt);
    AppMethodBeat.o(190488);
    return paramInt;
  }
  
  public static int U(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(190490);
    paramInt = pdB.GetDecodeVideoData(paramArrayOfByte, paramInt);
    AppMethodBeat.o(190490);
    return paramInt;
  }
  
  public static int V(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(190501);
    paramInt = pdB.SetAppCmd(10, paramArrayOfByte, paramInt);
    AppMethodBeat.o(190501);
    return paramInt;
  }
  
  public static int a(dlv paramdlv)
  {
    int j = -1;
    AppMethodBeat.i(190500);
    if (paramdlv == null)
    {
      ae.e("MicroMsg.Multitalk.ILinkNativeEngine", "steve: videoResParam is null");
      AppMethodBeat.o(190500);
      return -1;
    }
    int i = j;
    try
    {
      ae.i("MicroMsg.Multitalk.ILinkNativeEngine", "videoResParam:" + paramdlv + ",length:" + paramdlv.toByteArray().length);
      i = j;
      j = pdB.SubscribeVideo(paramdlv.toByteArray(), paramdlv.toByteArray().length);
      i = j;
      ae.i("MicroMsg.Multitalk.ILinkNativeEngine", "steve: subScribeVideoAndResList ret:".concat(String.valueOf(j)));
      i = j;
    }
    catch (IOException paramdlv)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", paramdlv, "SetVideoResolution exception", new Object[0]);
      }
    }
    AppMethodBeat.o(190500);
    return i;
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, int paramInt3, IConfCallBack paramIConfCallBack)
  {
    AppMethodBeat.i(190483);
    ae.i("MicroMsg.Multitalk.ILinkNativeEngine", "hy: init voip");
    int j = -1;
    i = j;
    for (;;)
    {
      try
      {
        aaw localaaw = new aaw();
        i = j;
        localaaw.app_id = "wechat";
        i = j;
        localaaw.Gsp = paramString;
        i = j;
        localaaw.Gsq = (com.tencent.mm.loader.j.b.asa() + "/ilink");
        i = j;
        localaaw.GsC = 1;
        i = j;
        localaaw.Gsr = 0;
        i = j;
        localaaw.Gst = 1;
        i = j;
        localaaw.Gsu = s.cbh();
        i = j;
        localaaw.Gsv = paramInt1;
        i = j;
        localaaw.Gsx = paramInt2;
        i = j;
        localaaw.Gsy = paramInt3;
        i = j;
        localaaw.GsD = n.getNumCores();
        i = j;
        localaaw.GsE = bu.getInt(com.tencent.mm.compatible.deviceinfo.m.aaq(), 0);
        i = j;
        localaaw.GsF = com.tencent.mm.compatible.deviceinfo.m.aao();
        i = j;
        localaaw.Gsw = 2;
        i = j;
        localaaw.GsG = Build.MANUFACTURER;
        i = j;
        localaaw.GsH = Build.MODEL;
        i = j;
        localaaw.GsI = Build.VERSION.RELEASE;
        i = j;
        localaaw.GsJ = Build.VERSION.INCREMENTAL;
        i = j;
        localaaw.GsK = Build.DISPLAY;
        i = j;
        paramString = q.cH(false);
        if (paramString == null) {
          continue;
        }
        i = j;
        if (paramString.isEmpty()) {
          continue;
        }
        i = j;
        localaaw.GsL = com.tencent.mm.bw.b.cm(aj.ej(paramString).getBytes());
        i = j;
        localaaw.GsM = Build.VERSION.RELEASE;
        i = j;
        ae.i("MicroMsg.Multitalk.ILinkNativeEngine", "envInfo:" + new String(localaaw.toByteArray()) + ",length:" + localaaw.toByteArray().length);
        i = j;
        paramInt1 = pdB.InitSDK(localaaw.toByteArray(), localaaw.toByteArray().length, paramIConfCallBack);
        i = paramInt1;
        ae.v("MicroMsg.Multitalk.ILinkNativeEngine", "init ret:".concat(String.valueOf(paramInt1)));
      }
      catch (IOException paramString)
      {
        ae.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", paramString, "envInfo exception", new Object[0]);
        paramInt1 = i;
        continue;
      }
      AppMethodBeat.o(190483);
      return paramInt1;
      i = j;
      ae.e("MicroMsg.Multitalk.ILinkNativeEngine", "getDeviceId failed");
    }
  }
  
  public static int a(LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190486);
    int i = -1;
    aax localaax = new aax();
    localaax.GsN = paramLinkedList;
    localaax.GsO = paramInt1;
    localaax.GsP = paramInt2;
    paramInt1 = i;
    try
    {
      paramInt2 = pdB.Invite(localaax.toByteArray(), localaax.toByteArray().length);
      paramInt1 = paramInt2;
      ae.i("MicroMsg.Multitalk.ILinkNativeEngine", "steve: invite ret:".concat(String.valueOf(paramInt2)));
      paramInt1 = paramInt2;
    }
    catch (IOException paramLinkedList)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", paramLinkedList, "Invite exception", new Object[0]);
      }
    }
    AppMethodBeat.o(190486);
    return paramInt1;
  }
  
  public static u a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(190499);
    if ((paramArrayOfByte != null) && (pdB != null))
    {
      paramInt1 = pdB.videoTrans(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
      paramArrayOfByte = new u();
      paramArrayOfByte.wpx = paramArrayOfInt;
      paramArrayOfByte.wpy = pdB.field_localImgWidth;
      paramArrayOfByte.wpz = pdB.field_localImgHeight;
      paramArrayOfByte.ret = paramInt1;
      AppMethodBeat.o(190499);
      return paramArrayOfByte;
    }
    ae.e("MicroMsg.Multitalk.ILinkNativeEngine", "steve:videoTrans null,  engine:" + pdB);
    AppMethodBeat.o(190499);
    return null;
  }
  
  public static int aaz(String paramString)
  {
    AppMethodBeat.i(190484);
    int i = pdB.UpdateAuthKey(paramString.getBytes(), paramString.getBytes().length);
    AppMethodBeat.o(190484);
    return i;
  }
  
  public static int as(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190485);
    paramInt1 = pdB.JoinRoomWithGroupID(paramString, paramInt1, paramInt2);
    ae.i("MicroMsg.Multitalk.ILinkNativeEngine", "joinRoom ret:" + paramInt1 + ", groupId:" + paramString);
    AppMethodBeat.o(190485);
    return paramInt1;
  }
  
  public static int b(LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190502);
    int i = -1;
    aax localaax = new aax();
    localaax.GsN = paramLinkedList;
    localaax.GsO = paramInt1;
    localaax.GsP = paramInt2;
    paramInt1 = i;
    try
    {
      paramInt2 = pdB.Add(localaax.toByteArray(), localaax.toByteArray().length);
      paramInt1 = paramInt2;
      ae.i("MicroMsg.Multitalk.ILinkNativeEngine", "steve: addmember ret:".concat(String.valueOf(paramInt2)));
      paramInt1 = paramInt2;
    }
    catch (IOException paramLinkedList)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", paramLinkedList, "Invite exception", new Object[0]);
      }
    }
    AppMethodBeat.o(190502);
    return paramInt1;
  }
  
  public static int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(190489);
    paramInt1 = pdB.SendVideoData(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(190489);
    return paramInt1;
  }
  
  public static v2conference cbn()
  {
    return pdB;
  }
  
  public static int cbo()
  {
    AppMethodBeat.i(190494);
    int i = pdB.UnInit();
    ae.i("MicroMsg.Multitalk.ILinkNativeEngine", "unInit ret:".concat(String.valueOf(i)));
    AppMethodBeat.o(190494);
    return i;
  }
  
  public static void drK()
  {
    AppMethodBeat.i(190503);
    pdB.Ack();
    AppMethodBeat.o(190503);
  }
  
  public static int e(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(190495);
    paramInt1 = pdB.SetAppCmd(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(190495);
    return paramInt1;
  }
  
  public static int v(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190487);
    paramInt1 = pdB.SendAudioData(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(190487);
    return paramInt1;
  }
  
  public static int videoHWProcess(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(190498);
    paramInt1 = pdB.videoHWProcess(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2, paramInt5, paramInt6);
    AppMethodBeat.o(190498);
    return paramInt1;
  }
  
  public static void x(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190504);
    pdB.RecvNotify(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(190504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.m
 * JD-Core Version:    0.7.0.1
 */