package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.NetworkRequest.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.model.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.eca;
import com.tencent.mm.protocal.protobuf.epd;
import com.tencent.mm.protocal.protobuf.esu;
import com.tencent.mm.protocal.protobuf.etm;
import com.tencent.mm.protocal.protobuf.etn;
import com.tencent.mm.protocal.protobuf.ett;
import com.tencent.mm.protocal.protobuf.euk;
import com.tencent.mm.protocal.protobuf.euv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public final class l
{
  public int GVA;
  public long GVB;
  public long GVC;
  public int GVD;
  public int GVE;
  public boolean GVF;
  public boolean GVG;
  public boolean GVH;
  public int GVI;
  private int GVJ;
  private int GVK;
  private int GVL;
  private int GVM;
  private int GVN;
  public boolean GVO;
  private boolean GVP;
  private int GVQ;
  private boolean GVR;
  private int GVS;
  private int GVT;
  private int GVU;
  public v2protocal GVV;
  public x GVW;
  public n GVX;
  public w GVY;
  public byte[] GVZ;
  public boolean GVr;
  public boolean GVs;
  public boolean GVt;
  public boolean GVu;
  public boolean GVv;
  public boolean GVw;
  public boolean GVx;
  public boolean GVy;
  public eca GVz;
  public ett GWa;
  public boolean GWb;
  public boolean GWc;
  public int GWd;
  public int GWe;
  public int GWf;
  public int GWg;
  public boolean GWh;
  public boolean GWi;
  public VoipScoreState GWj;
  public int GWk;
  public MTimerHandler GWl;
  Timer GWm;
  int GWn;
  private MTimerHandler GWo;
  private a GWp;
  public boolean dWM;
  MMHandler mHandler;
  public int mStatus;
  public Context owO;
  public Network zIU;
  public ConnectivityManager.NetworkCallback zIV;
  public LinkedList<Integer> zIW;
  
  protected l()
  {
    AppMethodBeat.i(114899);
    this.mStatus = 1;
    this.GVr = false;
    this.GVs = false;
    this.GVt = false;
    this.GVu = false;
    this.dWM = false;
    this.GVv = false;
    this.GVw = false;
    this.GVx = false;
    this.GVy = false;
    this.GVz = new eca();
    this.GVA = 0;
    this.GVB = 0L;
    this.GVC = 0L;
    this.GVD = 0;
    this.GVE = 0;
    this.GVF = false;
    this.GVG = false;
    this.GVH = false;
    this.GVI = 10;
    this.GVJ = -1;
    this.GVK = -1;
    this.GVL = -1;
    this.GVM = -1;
    this.GVN = -1;
    this.GVO = false;
    this.GVP = false;
    this.GVQ = 1;
    this.GVR = false;
    this.GVS = 1;
    this.GVT = -1;
    this.GVU = -1;
    this.owO = null;
    this.GVW = x.GZW;
    this.GVZ = null;
    this.GWa = null;
    this.GWb = false;
    this.GWc = false;
    this.GWd = 0;
    this.GWe = 0;
    this.GWf = 0;
    this.GWg = 0;
    this.GWh = false;
    this.GWi = true;
    this.zIU = null;
    this.zIV = null;
    this.zIW = new LinkedList();
    this.GWk = 0;
    this.GWl = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(114886);
        Log.v("MicroMsg.Voip.VoipContext", "voip repeat sync");
        l.this.GVY.a(null, false, 7);
        AppMethodBeat.o(114886);
        return true;
      }
    }, true);
    this.mHandler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(114891);
        if ((paramAnonymousMessage == null) || (paramAnonymousMessage.what != 59998))
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(114891);
          return;
        }
        Object localObject3;
        Object localObject1;
        int i;
        Object localObject4;
        if (paramAnonymousMessage.arg1 == 1)
        {
          if (l.this.GVV.roomId == 0)
          {
            com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipContext", "JNI_DOSYNC without roomid , igored!");
            AppMethodBeat.o(114891);
            return;
          }
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "need dosync for cmd from channel...");
          localObject3 = (byte[])paramAnonymousMessage.obj;
          localObject1 = l.this.GVY;
          i = paramAnonymousMessage.arg2;
          paramAnonymousMessage = new euk();
          paramAnonymousMessage.oUv = 1;
          localObject4 = new SKBuiltinBuffer_t();
          ((SKBuiltinBuffer_t)localObject4).setBuffer((byte[])localObject3);
          paramAnonymousMessage.KMS = ((SKBuiltinBuffer_t)localObject4);
          localObject3 = new SKBuiltinBuffer_t();
          try
          {
            ((SKBuiltinBuffer_t)localObject3).setBuffer(paramAnonymousMessage.toByteArray());
            paramAnonymousMessage = new etm();
            paramAnonymousMessage.Lms = i;
            paramAnonymousMessage.Lmt = ((SKBuiltinBuffer_t)localObject3);
            paramAnonymousMessage.xNH = z.aTY();
            localObject3 = new etn();
            ((etn)localObject3).oTz = 1;
            ((etn)localObject3).oTA.add(paramAnonymousMessage);
            ((w)localObject1).a((etn)localObject3, true, 2);
            AppMethodBeat.o(114891);
            return;
          }
          catch (IOException paramAnonymousMessage)
          {
            Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramAnonymousMessage, "", new Object[0]);
            AppMethodBeat.o(114891);
            return;
          }
        }
        if (paramAnonymousMessage.arg1 == 4)
        {
          if (l.this.GVV.roomId == 0)
          {
            com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipContext", "JNI_STARTDEVFAILED without roomid , igored!");
            AppMethodBeat.o(114891);
            return;
          }
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "need hangUP for startTalk failed. ");
          l.this.GVV.Hcw.GXc = 107;
          l.this.K(1, -9004, "");
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 6)
        {
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected from JNI");
          if (l.this.GVV.roomId == 0)
          {
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected roomid null, ignored");
            AppMethodBeat.o(114891);
            return;
          }
          l.this.GVt = true;
          l.this.GVV.Hcw.GXs = 1;
          if ((!l.this.dWM) && (!l.this.GVu)) {}
          for (l.this.GVV.Hbk = 1;; l.this.GVV.Hbk = 0)
          {
            l.this.GVV.setInactive();
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "Voip.Channel setInactive");
            l.this.fGy();
            AppMethodBeat.o(114891);
            return;
          }
        }
        if (paramAnonymousMessage.arg1 == 3)
        {
          l.this.mStatus = 5;
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 5)
        {
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "need hangUP for disconnect from channel..envent = " + paramAnonymousMessage.arg2);
          if (l.this.mStatus >= 5)
          {
            l.this.GVV.Hcw.GXc = 108;
            if (paramAnonymousMessage.arg2 != 5) {
              break label596;
            }
            l.this.GVV.Hcw.GXu = 1;
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "channel broken...");
          }
          for (;;)
          {
            l.this.K(1, -9000, "");
            AppMethodBeat.o(114891);
            return;
            l.this.GVV.Hcw.GXc = 106;
            break;
            label596:
            if (paramAnonymousMessage.arg2 == 8)
            {
              if (l.this.GVx == true)
              {
                com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "channel connect fail while pre-connect");
                l.this.GVw = true;
                AppMethodBeat.o(114891);
                return;
              }
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "channel connect fail...");
              l.this.GVt = false;
              l.this.GVV.Hcw.GXu = 5;
            }
          }
        }
        if (paramAnonymousMessage.arg1 == 100)
        {
          com.tencent.mm.plugin.voip.b.e.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.Voip.VoipContext", paramAnonymousMessage.arg2);
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 101)
        {
          com.tencent.mm.plugin.voip.b.e.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.v2Core", paramAnonymousMessage.arg2);
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 7)
        {
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "NOTIFY_FROM_JNI_SPEEDTESTRESULT handle");
          localObject4 = (byte[])paramAnonymousMessage.obj;
          i = paramAnonymousMessage.arg2;
          paramAnonymousMessage = null;
          try
          {
            localObject1 = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
            paramAnonymousMessage = (Message)localObject1;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "Get wifiName failed in voip speedTest!");
            }
          }
          localObject1 = null;
          try
          {
            localObject3 = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone")).getSimOperatorName();
            localObject1 = localObject3;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "Get netName failed in voip speedTest!");
            }
          }
          new j(l.this.GVC, l.this.GVB, l.this.GVD, (String)localObject1, paramAnonymousMessage, l.this.GVE, i, (byte[])localObject4).fII();
          AppMethodBeat.o(114891);
          return;
        }
        Object localObject2;
        if (paramAnonymousMessage.arg1 == 8)
        {
          localObject2 = (byte[])paramAnonymousMessage.obj;
          paramAnonymousMessage = l.this;
          for (;;)
          {
            try
            {
              localObject2 = (epd)new epd().parseFrom((byte[])localObject2);
              if ((!paramAnonymousMessage.GWh) || (((epd)localObject2).NmY != 1)) {
                com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve: onRecvRUDPCmd:" + ((epd)localObject2).NmY);
              }
              i = ((epd)localObject2).NmY;
              switch (i)
              {
              default: 
                AppMethodBeat.o(114891);
                return;
              }
            }
            catch (Exception paramAnonymousMessage)
            {
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "rudp cmd processing Error");
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client tells us to end HWEnc!!");
            paramAnonymousMessage.GVX.GWL = true;
            AppMethodBeat.o(114891);
            return;
            if (!paramAnonymousMessage.GWh)
            {
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client end HWEnc!!");
              paramAnonymousMessage.j(8, false, true);
              paramAnonymousMessage.c(4, false, true, true);
              if (((epd)localObject2).NmZ == null) {
                break label1190;
              }
              localObject2 = ByteBuffer.wrap(((epd)localObject2).NmZ.zy, 0, 4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              i = Math.min(((ByteBuffer)localObject2).getInt(), 6);
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(i);
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:CMD_VOIP_CloseHWEnc:reset maxsizeformat: ".concat(String.valueOf(i)));
              paramAnonymousMessage.GVV.setAppCmd(30, ((ByteBuffer)localObject2).array(), 4);
            }
            for (;;)
            {
              paramAnonymousMessage.GWh = true;
              AppMethodBeat.o(114891);
              return;
              label1190:
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: cmdBuffer is nil!!");
            }
            if (((epd)localObject2).NmZ != null)
            {
              localObject2 = ((epd)localObject2).NmZ.zy;
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve: remote new network type:".concat(String.valueOf(localObject2)));
              i = paramAnonymousMessage.GVV.setAppCmd(302, (byte[])localObject2, 4);
              if (i < 0) {
                com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + localObject2 + "fail:" + i + ", [roomid=" + paramAnonymousMessage.GVV.ypO + ", roomkey=" + paramAnonymousMessage.GVV.ypH + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
            AppMethodBeat.o(114891);
            return;
            byte[] arrayOfByte;
            if (((epd)localObject2).NmZ != null)
            {
              localObject2 = ((epd)localObject2).NmZ.zy;
              localObject2 = (esu)new esu().parseFrom((byte[])localObject2);
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "zhengxue: remote audio dev occupied stat :" + ((esu)localObject2).Nqs);
              arrayOfByte = new byte[4];
              arrayOfByte[0] = ((byte)((esu)localObject2).Nqs);
              paramAnonymousMessage.GVV.setJNIAppCmd(2, arrayOfByte, 4);
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "zhengxue:[CHANNEL]EMethod_AudioDevOccupiedStatsSync empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((epd)localObject2).NmZ != null)
            {
              localObject2 = ((epd)localObject2).NmZ.zy;
              if (paramAnonymousMessage.GVV != null)
              {
                localObject2 = ByteBuffer.wrap((byte[])localObject2);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                i = ((ByteBuffer)localObject2).getInt();
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)3);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.GVV.setAppCmd(35, ((ByteBuffer)localObject2).array(), 6);
                com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_DisableCodec:  ".concat(String.valueOf(i)));
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_DisableCodec empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((epd)localObject2).NmZ != null)
            {
              localObject2 = ((epd)localObject2).NmZ.zy;
              if (paramAnonymousMessage.GVV != null)
              {
                localObject2 = ByteBuffer.wrap((byte[])localObject2);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                i = ((ByteBuffer)localObject2).getInt();
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)3);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.GVV.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
                com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder:  ".concat(String.valueOf(i)));
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((epd)localObject2).NmZ != null)
            {
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(1);
              paramAnonymousMessage.GVV.setAppCmd(48, ((ByteBuffer)localObject2).array(), 4);
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAq:  1");
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAq empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((epd)localObject2).NmZ != null)
            {
              localObject2 = ((epd)localObject2).NmZ.zy;
              if (paramAnonymousMessage.GVV != null)
              {
                localObject2 = ByteBuffer.wrap((byte[])localObject2);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                i = ((ByteBuffer)localObject2).getInt();
                if (i != 20) {
                  break label1920;
                }
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)2);
                ((ByteBuffer)localObject2).putShort((short)16);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.GVV.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)2);
                ((ByteBuffer)localObject2).putShort((short)4);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.GVV.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
              }
              for (;;)
              {
                com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder:  ".concat(String.valueOf(i)));
                AppMethodBeat.o(114891);
                return;
                label1920:
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)2);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.GVV.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
              }
            }
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((epd)localObject2).NmZ != null)
            {
              localObject2 = ((epd)localObject2).NmZ.zy;
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "anlin: remote wx ver: ".concat(String.valueOf(localObject2)));
              i = paramAnonymousMessage.GVV.setAppCmd(506, (byte[])localObject2, 4);
              if (i < 0) {
                com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteClientVersion] remote wx ver: " + localObject2 + "ret: " + i + ", [roomid=" + paramAnonymousMessage.GVV.ypO + ", roomkey=" + paramAnonymousMessage.GVV.ypH + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteClientVersion] empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((epd)localObject2).NmZ != null)
            {
              arrayOfByte = ((epd)localObject2).NmZ.zy;
              i = ((epd)localObject2).NmZ.zy.length;
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "anlin: remote device model: ".concat(String.valueOf(arrayOfByte)));
              i = paramAnonymousMessage.GVV.setAppCmd(508, arrayOfByte, i);
              if (i < 0) {
                com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteDeviceModel] remote device model: " + arrayOfByte + "ret: " + i + ", [roomid=" + paramAnonymousMessage.GVV.ypO + ", roomkey=" + paramAnonymousMessage.GVV.ypH + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteDeviceModel] empty buffer");
          }
        }
        if (paramAnonymousMessage.arg1 == 9)
        {
          paramAnonymousMessage = l.this.GVV.Hcw;
          if (0L == paramAnonymousMessage.GXG)
          {
            paramAnonymousMessage.GXG = System.currentTimeMillis();
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.VoipDailReport", "first pkt received timestamp:" + paramAnonymousMessage.GXG);
          }
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "get first pkt for voip");
          if (1 == l.this.GVV.HbV)
          {
            paramAnonymousMessage = new euv();
            paramAnonymousMessage.oTW = 1;
            l.this.GVY.a(paramAnonymousMessage, 2);
            AppMethodBeat.o(114891);
          }
        }
        else
        {
          if (paramAnonymousMessage.arg1 == 11)
          {
            l.this.GWk = 2;
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 12)
          {
            l.this.GWk = 1;
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 13)
          {
            localObject2 = (int[])paramAnonymousMessage.obj;
            i = paramAnonymousMessage.arg2;
            new com.tencent.mm.plugin.voip.model.a.h(l.this.GVV.roomId, l.this.GVV.ypH, l.this.GVV.ypO, 1, i, (int[])localObject2, null).fII();
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 14)
          {
            localObject2 = (int[])paramAnonymousMessage.obj;
            i = paramAnonymousMessage.arg2;
            new com.tencent.mm.plugin.voip.model.a.h(l.this.GVV.roomId, l.this.GVV.ypH, l.this.GVV.ypO, 2, i, (int[])localObject2, null).fII();
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 15) {
            l.this.aE(paramAnonymousMessage.arg2, false);
          }
        }
        AppMethodBeat.o(114891);
      }
    };
    this.GWm = null;
    this.GWn = 0;
    this.GWo = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(177018);
        if (l.this.mStatus == 4)
        {
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "connect time out.. now finish..");
          l.this.GVV.Hcw.GXc = 105;
          l.this.K(1, -9000, "");
        }
        AppMethodBeat.o(177018);
        return false;
      }
    }, false);
    this.GWp = null;
    this.GVV = new v2protocal(this.mHandler);
    this.GVX = new n(this);
    this.GVX.GWQ = this.GVV.ypH;
    this.GVY = new w(this);
    this.GWg = 0;
    this.GWj = new VoipScoreState();
    AppMethodBeat.o(114899);
  }
  
  private void a(final d paramd)
  {
    AppMethodBeat.i(177020);
    if ((this.mStatus != 2) && (this.mStatus != 3) && (this.mStatus != 4))
    {
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "startConnectRelay status fail, status:" + this.mStatus);
      AppMethodBeat.o(177020);
      return;
    }
    if (this.GVr)
    {
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "can not startConnectRelay again");
      AppMethodBeat.o(177020);
      return;
    }
    l.c localc = new l.c(this, (byte)0);
    localc.GWy = new l.b()
    {
      public final void aC(final int paramAnonymousInt1, final int paramAnonymousInt2, final int paramAnonymousInt3)
      {
        AppMethodBeat.i(114895);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114894);
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel relay");
            int k = l.this.GVV.Hbz;
            int m = l.this.GVV.Hbz;
            v2protocal localv2protocal = l.this.GVV;
            int n = l.this.GVV.Hav;
            long l1 = l.this.GVV.roomId;
            int i1 = l.this.GVV.ypO;
            long l2 = l.this.GVV.ypH;
            byte[] arrayOfByte1 = l.this.GVV.Hax;
            int i2 = l.this.GVV.channelStrategy;
            int i3 = l.this.GVV.HaC;
            int i4 = l.this.GVV.HaD;
            int i5 = l.this.GVV.HaA;
            byte[] arrayOfByte2;
            int i6;
            int i7;
            int i8;
            byte[] arrayOfByte3;
            int i9;
            int i10;
            if (l.this.GVV.HaB == null)
            {
              i = 0;
              arrayOfByte2 = l.this.GVV.HaB;
              i6 = l.this.GVV.HaE;
              i7 = l.this.GVV.Hau;
              i8 = l.this.GVV.HbJ;
              arrayOfByte3 = l.this.GVV.HbK;
              i9 = l.this.GVV.HbL;
              i10 = l.this.GVV.HaF;
              if (l.this.GVV.HaG != null) {
                break label521;
              }
            }
            label521:
            for (int j = 0;; j = l.this.GVV.HaG.length)
            {
              i = localv2protocal.setConfigInfo(n, l1, i1, l2, arrayOfByte1, i2, i3, i4, i5, i, arrayOfByte2, i6, (k >> 2 & 0x3) >> 1 & 0x1 & (m & 0x3) >> 1 & 0x1, i7, i8, arrayOfByte3, i9, i10, j, l.this.GVV.HaG, l.this.GVV.HbM, paramAnonymousInt1, paramAnonymousInt3, paramAnonymousInt2, "", "", v2protocal.fJa());
              if (i >= 0) {
                break label539;
              }
              com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipContext", "v2protocal setConfigInfo or connectToPeerRelay failed, ret:".concat(String.valueOf(i)));
              l.this.GVV.Hcw.GXc = 14;
              l.this.K(1, -9002, "");
              l.11.this.GWr.fGL();
              AppMethodBeat.o(114894);
              return;
              i = l.this.GVV.HaB.length;
              break;
            }
            label539:
            if (l.this.GVV.HbZ == null)
            {
              com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipContext", "relay conns buf null");
              l.this.K(1, -9002, "");
              l.11.this.GWr.fGL();
              AppMethodBeat.o(114894);
              return;
            }
            int i = l.this.GVV.AddNewRelayConns(l.this.GVV.HbZ, l.this.GVV.HbZ.length, 0);
            if (i < 0)
            {
              com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipContext", "add relayconns err:".concat(String.valueOf(i)));
              l.this.K(1, -9002, "");
              l.11.this.GWr.fGL();
              AppMethodBeat.o(114894);
              return;
            }
            l.this.GVr = true;
            l.this.GVV.Hcw.GXj = 1;
            l.this.GVV.Hcw.GXr = 1;
            l.11.this.GWr.fGL();
            AppMethodBeat.o(114894);
          }
        });
        AppMethodBeat.o(114895);
      }
    };
    com.tencent.f.h.RTc.aX(localc);
    AppMethodBeat.o(177020);
  }
  
  private static boolean a(ConnectivityManager paramConnectivityManager)
  {
    AppMethodBeat.i(114935);
    try
    {
      Method localMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(paramConnectivityManager, new Object[0])).booleanValue();
      AppMethodBeat.o(114935);
      return bool;
    }
    catch (Exception paramConnectivityManager)
    {
      AppMethodBeat.o(114935);
    }
    return false;
  }
  
  private static boolean fGC()
  {
    AppMethodBeat.i(235609);
    int i = m.aon();
    boolean bool1;
    int j;
    int k;
    int m;
    long l;
    boolean bool2;
    label82:
    boolean bool3;
    label109:
    boolean bool4;
    if ((i & 0x400) != 0)
    {
      bool1 = true;
      j = i >> 12 & 0xF;
      k = i & 0xFF;
      m = Build.VERSION.SDK_INT;
      l = com.tencent.matrix.g.a.getTotalMemory(MMApplicationContext.getContext()) / 1024L / 1024L;
      if (j < ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slr, 4)) {
        break label345;
      }
      bool2 = true;
      if (k < ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sls, 45)) {
        break label351;
      }
      bool3 = true;
      if (m < ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slt, 23)) {
        break label357;
      }
      bool4 = true;
      label136:
      if (l < ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slu, 4096)) {
        break label363;
      }
    }
    label345:
    label351:
    label357:
    label363:
    for (boolean bool5 = true;; bool5 = false)
    {
      double d = com.tencent.matrix.g.a.TL();
      Debug.MemoryInfo localMemoryInfo = com.tencent.matrix.g.a.bo(MMApplicationContext.getContext());
      Log.i("MicroMsg.Voip.VoipContext", "checkVoipBeautyLocalConfig, cpuFlags:%s, isNeon:%s, nCores:%s, nFreq:%s, sdkInt:%s, totalMemMB:%s, coreNumCheck:%s, freqCheck:%s, sdkIntCheck:%s, totalMemMBCheck:%s, cpuRate:%s, dalvikPss:%s, nativePss:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Double.valueOf(d), Integer.valueOf(localMemoryInfo.dalvikPss), Integer.valueOf(localMemoryInfo.nativePss) });
      if ((!bool1) || (!bool2) || (!bool3) || (!bool4) || (!bool5)) {
        break label369;
      }
      AppMethodBeat.o(235609);
      return true;
      bool1 = false;
      break;
      bool2 = false;
      break label82;
      bool3 = false;
      break label109;
      bool4 = false;
      break label136;
    }
    label369:
    AppMethodBeat.o(235609);
    return false;
  }
  
  private static int fGD()
  {
    AppMethodBeat.i(184050);
    String str1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slv, "");
    if (!Util.isNullOrNil(str1)) {
      try
      {
        com.tencent.mm.ab.i locali = new com.tencent.mm.ab.i(str1);
        String str2 = Build.MANUFACTURER;
        int i = locali.optInt(str2, -1);
        Log.i("MicroMsg.Voip.VoipContext", "checkVoipBeautyManufactureConfig, config:%s, manufacture:%s, beautyCmd:%s", new Object[] { str1, str2, Integer.valueOf(i) });
        if (i >= 0)
        {
          AppMethodBeat.o(184050);
          return i;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Voip.VoipContext", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(184050);
    return 0;
  }
  
  private void fGx()
  {
    AppMethodBeat.i(114914);
    com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipContext", "SrvDeviceInfo.mAudioInfo.aecMode:" + ae.gKu.gEo);
    if (ae.gKu.gDM == 1) {
      this.GVV.setAppCmd(410);
    }
    byte[] arrayOfByte = new byte[2];
    Object localObject;
    byte b;
    int i;
    int j;
    int k;
    if (ae.gKu.gEo >= 0)
    {
      arrayOfByte[0] = ((byte)ae.gKu.gEo);
      this.GVV.setAppCmd(406, arrayOfByte, 1);
      localObject = com.tencent.mm.model.c.d.aXu().Fu("100447");
      if (((com.tencent.mm.storage.c)localObject).isValid())
      {
        i7 = Util.getInt((String)((com.tencent.mm.storage.c)localObject).gzz().get("SetVoipRnnNsOn"), 0);
        if (1 == i7)
        {
          b = (byte)i7;
          this.GVV.setAppCmd(432, new byte[] { b }, 1);
        }
      }
      i7 = ae.gKu.gEp;
      Log.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.nsModeNew %d", new Object[] { Integer.valueOf(i7) });
      if (ae.gKu.gEp < 0) {
        break label2367;
      }
      if (i7 <= 0) {
        break label2348;
      }
      int i8 = (int)Math.floor(i7 / 1000.0D) % 100;
      Log.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.iflag %d", new Object[] { Integer.valueOf(i8) });
      if (i8 > 0)
      {
        b = (byte)(i7 & 0xFF);
        i = (byte)(i7 >> 8 & 0xFF);
        j = (byte)(i7 >> 16 & 0xFF);
        k = (byte)(i7 >> 24 & 0xFF);
        this.GVV.setAppCmd(408, (byte[])new byte[] { b, i, j, k }, 4);
      }
      label326:
      i7 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgf, -1);
      Log.i("MicroMsg.Voip.VoipContext", "kerrizhang, play_fadeinfadeout_switch = %d", new Object[] { Integer.valueOf(i7) });
      localObject = new byte[1];
      localObject[0] = 0;
      if (i7 > 0) {
        localObject[0] = ((byte)i7);
      }
      this.GVV.setAppCmd(451, (byte[])localObject, 1);
      i7 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgG, -1);
      Log.i("MicroMsg.Voip.VoipContext", "kerrizhang, fullbandmode = %d", new Object[] { Integer.valueOf(i7) });
      i8 = ae.gKu.gEr;
      Log.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.voipfullbandcfg %d", new Object[] { Integer.valueOf(i8) });
      if ((i7 > 0) && (i8 > 0))
      {
        b = (byte)(i7 & 0xFF);
        i = (byte)(i7 >> 8 & 0xFF);
        j = (byte)(i7 >> 16 & 0xFF);
        k = (byte)(i7 >> 24 & 0xFF);
        this.GVV.setAppCmd(456, (byte[])new byte[] { b, i, j, k }, 4);
      }
      i7 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgg, -1);
      Log.i("MicroMsg.Voip.VoipContext", "kerrizhang, play_fadeinfadeout_thresh = %d", new Object[] { Integer.valueOf(i7) });
      localObject[0] = 0;
      if (i7 > 0) {
        localObject[0] = ((byte)i7);
      }
      this.GVV.setAppCmd(452, (byte[])localObject, 1);
      i7 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgF, -1);
      Log.i("MicroMsg.Voip.VoipContext", "kerrizhang, voip rcnnvad_switch = %d", new Object[] { Integer.valueOf(i7) });
      if (i7 > 0)
      {
        b = (byte)i7;
        this.GVV.setAppCmd(454, new byte[] { b }, 1);
      }
      i7 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgH, 0);
      Log.i("MicroMsg.Voip.VoipContext", "dennyliang, voip aec_value = %d", new Object[] { Integer.valueOf(i7) });
      if (i7 > 0)
      {
        b = (byte)(i7 & 0xFF);
        i = (byte)(i7 >> 8 & 0xFF);
        j = (byte)(i7 >> 16 & 0xFF);
        k = (byte)(i7 >> 24 & 0xFF);
        this.GVV.setAppCmd(460, new byte[] { b, i, j, k }, 4);
      }
      i7 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgK, -1);
      Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, x_agc_paras: %d", new Object[] { Integer.valueOf(i7) });
      if (i7 > 0)
      {
        b = (byte)(i7 & 0x1);
        Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, agc_switch: %d", new Object[] { Byte.valueOf(b) });
        if (b <= 0) {
          break label2392;
        }
        localObject = new byte[7];
        localObject[0] = ((byte)(i7 >> 1 & 0x1F));
        localObject[1] = ((byte)(i7 >> 6 & 0x1F));
        localObject[2] = ((byte)(i7 >> 11 & 0x3));
        localObject[3] = ((byte)(i7 >> 13 & 0x3));
        localObject[4] = ((byte)(i7 >> 15 & 0x1));
        localObject[5] = ((byte)(i7 >> 16 & 0x7));
        localObject[6] = ((byte)(i7 >> 19 & 0xF));
        Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, agc para: %d, %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject[0]), Byte.valueOf(localObject[1]), Byte.valueOf(localObject[2]), Byte.valueOf(localObject[3]), Byte.valueOf(localObject[4]), Byte.valueOf(localObject[5]), Byte.valueOf(localObject[6]) });
        this.GVV.setAppCmd(404, (byte[])localObject, 7);
      }
      label1092:
      if (ae.gKu.gEt < 0) {
        break label2423;
      }
      localObject = new byte[7];
      if ((ae.gKu.gEu >= 0) && (ae.gKu.gEv >= 0))
      {
        localObject[0] = ((byte)ae.gKu.gEu);
        localObject[1] = ((byte)ae.gKu.gEv);
        if (ae.gKu.gEw < 0) {
          break label2406;
        }
        localObject[2] = ((byte)ae.gKu.gEw);
        localObject[3] = ((byte)ae.gKu.gEt);
        localObject[4] = ((byte)ae.gKu.gEx);
        localObject[5] = ((byte)ae.gKu.gEy);
        localObject[6] = ((byte)ae.gKu.gEz);
        this.GVV.setAppCmd(404, (byte[])localObject, 7);
      }
      label1227:
      i7 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgO, -1);
      Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, tryUpdateAudioAdaption, frz_sta_p_x = %d", new Object[] { Integer.valueOf(i7) });
      if (i7 > 0)
      {
        b = (byte)(i7 & 0xFF);
        i = (byte)(i7 >> 8 & 0xFF);
        j = (byte)(i7 >> 16 & 0xFF);
        k = (byte)(i7 >> 24 & 0xFF);
        this.GVV.setAppCmd(464, new byte[] { b, i, j, k }, 4);
      }
      i7 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgP, -1);
      i8 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgQ, -1);
      int i9 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgR, -1);
      Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, x-exp, neteq flag:%d, min cache:%d, max cache:%d", new Object[] { Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9) });
      if ((i7 != 1) || (i8 <= 0) || (i9 <= 0)) {
        break label2448;
      }
      b = (byte)(i7 & 0xFF);
      i = (byte)(i7 >> 8 & 0xFF);
      j = (byte)(i7 >> 16 & 0xFF);
      k = (byte)(i7 >> 24 & 0xFF);
      int m = (byte)(i8 & 0xFF);
      int n = (byte)(i8 >> 8 & 0xFF);
      int i1 = (byte)(i8 >> 16 & 0xFF);
      int i2 = (byte)(i8 >> 24 & 0xFF);
      int i3 = (byte)(i9 & 0xFF);
      int i4 = (byte)(i9 >> 8 & 0xFF);
      int i5 = (byte)(i9 >> 16 & 0xFF);
      int i6 = (byte)(i9 >> 24 & 0xFF);
      this.GVV.setAppCmd(466, new byte[] { b, i, j, k, m, n, i1, i2, i3, i4, i5, i6 }, 3);
    }
    for (;;)
    {
      i7 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sge, -1);
      Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, tryUpdateAudioAdaption, switch_flag_x = %d", new Object[] { Integer.valueOf(i7) });
      localObject = new byte[1];
      localObject[0] = 0;
      if (i7 > 0) {
        localObject[0] = 1;
      }
      this.GVV.setAppCmd(450, (byte[])localObject, 1);
      if ((ae.gKu.gDN >= 0) || (ae.gKu.gDP >= 0))
      {
        arrayOfByte[0] = -1;
        arrayOfByte[1] = -1;
        if (ae.gKu.gDN >= 0) {
          arrayOfByte[0] = ((byte)ae.gKu.gDN);
        }
        if (ae.gKu.gDP >= 0) {
          arrayOfByte[1] = ((byte)ae.gKu.gDP);
        }
        this.GVV.setAppCmd(414, arrayOfByte, 2);
      }
      if ((ae.gKu.gDO >= 0) || (ae.gKu.gDQ >= 0))
      {
        arrayOfByte[0] = -1;
        arrayOfByte[1] = -1;
        if (ae.gKu.gDO >= 0) {
          arrayOfByte[0] = ((byte)ae.gKu.gDO);
        }
        if (ae.gKu.gDQ >= 0) {
          arrayOfByte[1] = ((byte)ae.gKu.gDQ);
        }
        this.GVV.setAppCmd(415, arrayOfByte, 2);
      }
      if ((ae.gKu.gDR >= 0) || (ae.gKu.gDS >= 0))
      {
        arrayOfByte[0] = -1;
        arrayOfByte[1] = -1;
        if (ae.gKu.gDR >= 0) {
          arrayOfByte[0] = ((byte)ae.gKu.gDR);
        }
        if (ae.gKu.gDS >= 0) {
          arrayOfByte[1] = ((byte)ae.gKu.gDS);
        }
        this.GVV.setAppCmd(422, arrayOfByte, 2);
      }
      if (ae.gKu.gDX >= 0)
      {
        arrayOfByte[0] = ((byte)ae.gKu.gDX);
        this.GVV.setAppCmd(416, arrayOfByte, 1);
      }
      if (ae.gKu.gEb >= 0)
      {
        arrayOfByte[0] = ((byte)ae.gKu.gEb);
        this.GVV.setAppCmd(431, arrayOfByte, 4);
      }
      if ((ae.gKu.gDY >= 0) && ((this.GVV.Hbt != 0) || (ae.gKu.gDY != 5)))
      {
        arrayOfByte[0] = ((byte)ae.gKu.gDY);
        this.GVV.setAppCmd(417, arrayOfByte, 1);
      }
      if ((ae.gKu.gDZ >= 0) && ((this.GVV.Hbt != 0) || (ae.gKu.gDZ != 5)))
      {
        arrayOfByte[0] = ((byte)ae.gKu.gDZ);
        this.GVV.setAppCmd(418, arrayOfByte, 1);
      }
      if (ae.gKu.gEa >= 0)
      {
        arrayOfByte[0] = ((byte)ae.gKu.gEa);
        this.GVV.setAppCmd(419, arrayOfByte, 1);
      }
      if ((this.GVV.Hbt == 1) && ((ae.gKu.gDY == 5) || (ae.gKu.gDZ == 5))) {
        this.GVV.HaX = 5;
      }
      if (1 != ae.gKu.gEN) {
        break label2545;
      }
      localObject = new byte[30];
      i7 = 0;
      while (i7 < 15)
      {
        localObject[(i7 * 2)] = ((byte)(ae.gKu.gEO[i7] & 0xFF));
        localObject[(i7 * 2 + 1)] = ((byte)(ae.gKu.gEO[i7] >> 8 & 0xFF));
        i7 += 1;
      }
      if (ae.gKu.gEo != -2) {
        break;
      }
      this.GVV.setAppCmd(407);
      break;
      label2348:
      if (i7 != 0) {
        break label326;
      }
      this.GVV.setAppCmd(409);
      break label326;
      label2367:
      if (ae.gKu.gEp != -2) {
        break label326;
      }
      this.GVV.setAppCmd(409);
      break label326;
      label2392:
      this.GVV.setAppCmd(405);
      break label1092;
      label2406:
      this.GVV.setAppCmd(404, (byte[])localObject, 2);
      break label1227;
      label2423:
      if (ae.gKu.gEt != -2) {
        break label1227;
      }
      this.GVV.setAppCmd(405);
      break label1227;
      label2448:
      if (i7 == 0)
      {
        b = (byte)(i7 & 0xFF);
        i = (byte)(i7 >> 8 & 0xFF);
        j = (byte)(i7 >> 16 & 0xFF);
        k = (byte)(i7 >> 24 & 0xFF);
        this.GVV.setAppCmd(466, new byte[] { b, i, j, k }, 1);
      }
    }
    this.GVV.setAppCmd(420, (byte[])localObject, 30);
    label2545:
    if (ae.gKu.gEN == 0) {
      this.GVV.setAppCmd(421);
    }
    if ((ae.gKu.gEP[0] > 0) || (ae.gKu.gEP[1] > 0))
    {
      arrayOfByte[0] = 0;
      arrayOfByte[1] = 0;
      if ((ae.gKu.gEP[0] > 0) && (ae.gKu.gEP[0] < 10000)) {
        arrayOfByte[0] = ((byte)ae.gKu.gEP[0]);
      }
      if ((ae.gKu.gEP[1] > 0) && (ae.gKu.gEP[1] < 10000)) {
        arrayOfByte[1] = ((byte)ae.gKu.gEP[1]);
      }
      this.GVV.setAppCmd(423, arrayOfByte, 2);
    }
    if (ae.gKu.gER > 0)
    {
      arrayOfByte[0] = ((byte)ae.gKu.gER);
      this.GVV.setAppCmd(424, arrayOfByte, 1);
    }
    int i7 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgL, -1);
    Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, x_agcrx_para: %d", new Object[] { Integer.valueOf(i7) });
    if (i7 > 0)
    {
      b = (byte)(i7 & 0x1);
      Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, agcrx_switch: %d", new Object[] { Byte.valueOf(b) });
      if (b > 0)
      {
        arrayOfByte = new byte[4];
        arrayOfByte[0] = ((byte)(i7 >> 1 & 0x3));
        arrayOfByte[1] = ((byte)(i7 >> 3 & 0x1F));
        arrayOfByte[2] = ((byte)(i7 >> 8 & 0x1F));
        arrayOfByte[3] = ((byte)(i7 >> 13 & 0x1));
        Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, agcrx paras: %d, %d, %d, %d", new Object[] { Byte.valueOf(arrayOfByte[0]), Byte.valueOf(arrayOfByte[1]), Byte.valueOf(arrayOfByte[2]), Byte.valueOf(arrayOfByte[3]) });
        this.GVV.setAppCmd(426, arrayOfByte, 4);
      }
    }
    if (ae.gKu.gEZ >= 0)
    {
      b = (byte)ae.gKu.gEZ;
      i = (byte)ae.gKu.gFa;
      j = (byte)ae.gKu.gFb;
      k = (byte)ae.gKu.gFc;
      this.GVV.setAppCmd(426, new byte[] { b, i, j, k }, 4);
    }
    AppMethodBeat.o(114914);
  }
  
  private int xb(boolean paramBoolean)
  {
    AppMethodBeat.i(235608);
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "EnableAq: SetAqFlag =44, aqBlur=" + paramBoolean);
    ByteBuffer localByteBuffer;
    if (paramBoolean)
    {
      localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putInt(1);
    }
    try
    {
      if (this.GVV != null)
      {
        epd localepd = new epd();
        localepd.NmY = 10;
        localepd.NmZ = new com.tencent.mm.bw.b(localByteBuffer.array());
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "EnableAq: SetAqFlag =44, aqBlur=" + paramBoolean);
        this.GVV.SendRUDP(localepd.toByteArray(), localepd.toByteArray().length);
      }
      localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putInt(1);
      this.GVV.setAppCmd(44, localByteBuffer.array(), 4);
      AppMethodBeat.o(235608);
      return 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "EnableAq Error");
      }
    }
  }
  
  public final void K(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(114937);
    fGK();
    if (this.GWp != null) {
      this.GWp.K(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(114937);
  }
  
  public final void a(a parama)
  {
    if (parama != null) {
      this.GWp = parama;
    }
  }
  
  public final void a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.GVV.HaA = paramInt1;
    this.GVV.HaB = paramArrayOfByte1;
    this.GVV.HbJ = paramInt2;
    this.GVV.HbK = paramArrayOfByte2;
  }
  
  public final boolean a(ett paramett)
  {
    this.GWa = paramett;
    this.GVV.haD = this.GWa.NqS;
    this.GVV.roomId = this.GWa.LsZ;
    this.GVV.ypH = this.GWa.Lta;
    this.GVV.ypO = 1;
    this.GVV.Hav = 0;
    this.mStatus = 3;
    return true;
  }
  
  public final void aE(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(114921);
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "start bindSocket " + paramInt + " ToNetwork " + this.zIU + " rebind " + paramBoolean);
    if ((this.zIU != null) && (com.tencent.mm.compatible.util.d.oD(23)))
    {
      FileDescriptor localFileDescriptor = new FileDescriptor();
      try
      {
        Field localField = FileDescriptor.class.getDeclaredField("descriptor");
        localField.setAccessible(true);
        localField.setInt(localFileDescriptor, paramInt);
        this.zIU.bindSocket(localFileDescriptor);
        if (!paramBoolean) {
          this.zIW.add(Integer.valueOf(paramInt));
        }
        com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipContext", "bindSocketToNetwork success: network" + this.zIU + "+socketfd" + paramInt);
        AppMethodBeat.o(114921);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "bindSocketToNetwork Error");
      }
    }
    AppMethodBeat.o(114921);
  }
  
  public final void aF(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(235607);
    if (!paramBoolean1)
    {
      if (this.GVV != null)
      {
        if (this.GWi)
        {
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc: Set P2S HW Flag False!!");
          j(8, false, true);
        }
        for (;;)
        {
          ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
          localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
          localByteBuffer.putInt(6);
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc:reset maxsizeformat: 6");
          this.GVV.setAppCmd(30, localByteBuffer.array(), 4);
          AppMethodBeat.o(235607);
          return;
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "closecodec: remote i264 enc!");
          c(8, false, true, true);
        }
      }
    }
    else
    {
      if (this.GWi)
      {
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "closeRemoteHWEnc: DecErr old!!");
        adg(2);
        AppMethodBeat.o(235607);
        return;
      }
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "closeRemoteHWEnc: DecErr new!!");
      if (paramBoolean2)
      {
        c(4, true, false, false);
        AppMethodBeat.o(235607);
        return;
      }
      c(8, true, false, false);
    }
    AppMethodBeat.o(235607);
  }
  
  public final void ada(int paramInt)
  {
    AppMethodBeat.i(114903);
    this.GVV.zNX = Math.abs(paramInt);
    AppMethodBeat.o(114903);
  }
  
  public final void adb(int paramInt)
  {
    AppMethodBeat.i(114904);
    this.GVV.HaL = Math.abs(paramInt);
    if (paramInt != 0) {
      this.GVW.enR();
    }
    AppMethodBeat.o(114904);
  }
  
  public final void adc(int paramInt)
  {
    this.GVV.HaO = paramInt;
  }
  
  public final void ade(int paramInt)
  {
    AppMethodBeat.i(114910);
    if ((8 == paramInt) || (9 == paramInt)) {
      this.GVN = paramInt;
    }
    for (;;)
    {
      if ((1 == paramInt) || (3 == paramInt)) {
        adf(2);
      }
      com.tencent.mm.plugin.voip.c.fFg().GYS.GZt = false;
      com.tencent.mm.plugin.voip.c.fFg().fIg();
      this.GVW.acQ(paramInt);
      AppMethodBeat.o(114910);
      return;
      this.GVL = paramInt;
      this.GVJ = paramInt;
    }
  }
  
  public final void adf(int paramInt)
  {
    AppMethodBeat.i(114911);
    if ((8 == paramInt) || (9 == paramInt)) {
      this.GVM = paramInt;
    }
    for (;;)
    {
      this.GVY.adv(paramInt);
      AppMethodBeat.o(114911);
      return;
      this.GVJ = paramInt;
      this.GVK = paramInt;
    }
  }
  
  public final void adg(int paramInt)
  {
    AppMethodBeat.i(114925);
    try
    {
      epd localepd = new epd();
      localepd.NmY = paramInt;
      if (1 == paramInt)
      {
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:send maxsizeformat: !!6");
        ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer.putInt(6);
        localepd.NmZ = new com.tencent.mm.bw.b(localByteBuffer.array());
        this.GVV.setAppCmd(32, localByteBuffer.array(), 4);
      }
      for (;;)
      {
        this.GVV.SendRUDP(localepd.toByteArray(), localepd.toByteArray().length);
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: send RUDP data to close remote HW encoding!Type:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(114925);
        return;
        localepd.NmZ = null;
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "onVoipSendCloseHWEncCmd Error");
      AppMethodBeat.o(114925);
    }
  }
  
  public final void adh(int paramInt)
  {
    AppMethodBeat.i(114926);
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "zhengxue: audio device occupied stat sync stat " + paramInt + " app 1");
    try
    {
      Object localObject = new byte[4];
      localObject[0] = ((byte)paramInt);
      this.GVV.setJNIAppCmd(2, (byte[])localObject, 4);
      localObject = new esu();
      ((esu)localObject).Nqs = paramInt;
      ((esu)localObject).Nqt = 1;
      epd localepd = new epd();
      localepd.NmY = 4;
      localepd.NmZ = new com.tencent.mm.bw.b(((esu)localObject).toByteArray(), 0, 1);
      this.GVV.SendRUDP(localepd.toByteArray(), localepd.toByteArray().length);
      AppMethodBeat.o(114926);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "onAudioDevOccupiedStat Error");
      AppMethodBeat.o(114926);
    }
  }
  
  public final void adi(int paramInt)
  {
    this.GVV.HbL = paramInt;
  }
  
  public final void adj(int paramInt)
  {
    this.GVV.HbE = paramInt;
  }
  
  public final void adk(int paramInt)
  {
    this.GVV.Hcw.GXi = 1;
    this.GVV.channelStrategy = paramInt;
  }
  
  public final void adl(int paramInt)
  {
    this.GVV.HaE = paramInt;
  }
  
  public final int bu(LinkedList<csu> paramLinkedList)
  {
    int j = 0;
    AppMethodBeat.i(114936);
    Object localObject = new LinkedList();
    int k = this.GVV.bv((LinkedList)localObject);
    int i = j;
    if (k == 0)
    {
      if ((((LinkedList)localObject).size() == 0) || (((LinkedList)localObject).size() > 2))
      {
        AppMethodBeat.o(114936);
        return 0;
      }
      if ((((csu)((LinkedList)localObject).get(0)).MxQ == 1) && (((csu)((LinkedList)localObject).get(0)).Loh == 5))
      {
        paramLinkedList.add(((LinkedList)localObject).get(0));
        this.GVV.Hbc = 1;
        AppMethodBeat.o(114936);
        return 0;
      }
      paramLinkedList.add(((LinkedList)localObject).get(0));
      this.GVV.Hbb = 1;
      if (!a((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")))
      {
        Log.i("MicroMsg.Voip.VoipContext", "mobile network not connectedorconnecting");
        AppMethodBeat.o(114936);
        return 0;
      }
      localObject = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone")).getSimOperator();
      if ((localObject == null) || (((String)localObject).length() < 3))
      {
        Log.i("MicroMsg.Voip.VoipContext", "nic_op NULL");
        AppMethodBeat.o(114936);
        return 0;
      }
      csu localcsu = new csu();
      localcsu.LYu = "android-cellular";
      localcsu.MxQ = 0;
      localcsu.Loh = 5;
      localcsu.MxR = (((String)localObject).substring(0, 3) + ":" + ((String)localObject).substring(3, ((String)localObject).length()));
      paramLinkedList.add(localcsu);
      this.GVV.Hbc = 1;
      i = j;
    }
    while (i < paramLinkedList.size())
    {
      Log.d("MicroMsg.Voip.VoipContext", "nic_name:" + ((csu)paramLinkedList.get(i)).LYu + " nic_role:" + ((csu)paramLinkedList.get(i)).MxQ + " net_type:" + ((csu)paramLinkedList.get(i)).Loh + " nic_isp_info:" + ((csu)paramLinkedList.get(i)).MxR);
      i += 1;
    }
    AppMethodBeat.o(114936);
    return k;
  }
  
  public final int c(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(184049);
    if (paramInt < 0)
    {
      AppMethodBeat.o(184049);
      return -1;
    }
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec: targetCodec =" + paramInt + ", local=" + paramBoolean1 + ", remote =" + paramBoolean2 + "encTag=" + paramBoolean3);
    ByteBuffer localByteBuffer1;
    if ((paramBoolean1) && (paramBoolean3))
    {
      localByteBuffer1 = ByteBuffer.allocate(4);
      localByteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer1.putInt(paramInt);
    }
    for (;;)
    {
      epd localepd;
      try
      {
        if (this.GVV != null)
        {
          localepd = new epd();
          localepd.NmY = 6;
          localepd.NmZ = new com.tencent.mm.bw.b(localByteBuffer1.array());
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(paramInt)));
          this.GVV.SendRUDP(localepd.toByteArray(), localepd.toByteArray().length);
        }
        localByteBuffer1 = ByteBuffer.allocate(6);
        localByteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer1.putShort((short)2);
        localByteBuffer1.putShort((short)paramInt);
        localByteBuffer1.putShort((short)0);
        this.GVV.setAppCmd(39, localByteBuffer1.array(), 6);
        AppMethodBeat.o(184049);
        return 1;
      }
      catch (Exception localException1)
      {
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        continue;
      }
      if ((paramBoolean1) && (!paramBoolean3))
      {
        ByteBuffer localByteBuffer2 = ByteBuffer.allocate(6);
        localByteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer2.putShort((short)0);
        localByteBuffer2.putShort((short)paramInt);
        localByteBuffer2.putShort((short)0);
        this.GVV.setAppCmd(39, localByteBuffer2.array(), 6);
        localByteBuffer2 = ByteBuffer.allocate(4);
        localByteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer2.putInt(paramInt);
        try
        {
          if (this.GVV == null) {
            continue;
          }
          localepd = new epd();
          localepd.NmY = 7;
          localepd.NmZ = new com.tencent.mm.bw.b(localByteBuffer2.array());
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(paramInt)));
          this.GVV.SendRUDP(localepd.toByteArray(), localepd.toByteArray().length);
        }
        catch (Exception localException2)
        {
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        }
      }
      else if ((paramBoolean2) && (paramBoolean3))
      {
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:disable remote target codec: ".concat(String.valueOf(paramInt)));
        ByteBuffer localByteBuffer3 = ByteBuffer.allocate(6);
        localByteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer3.putShort((short)3);
        localByteBuffer3.putShort((short)paramInt);
        localByteBuffer3.putShort((short)0);
        this.GVV.setAppCmd(39, localByteBuffer3.array(), 6);
        localByteBuffer3 = ByteBuffer.allocate(4);
        localByteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer3.putInt(paramInt);
        try
        {
          if (this.GVV != null)
          {
            localepd = new epd();
            localepd.NmY = 7;
            localepd.NmZ = new com.tencent.mm.bw.b(localByteBuffer3.array());
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(paramInt)));
            this.GVV.SendRUDP(localepd.toByteArray(), localepd.toByteArray().length);
          }
        }
        catch (Exception localException3)
        {
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        }
      }
    }
  }
  
  public final void c(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.GVV.HbQ = paramInt;
    this.GVV.HbR = paramArrayOfByte1;
    this.GVV.HbS = paramArrayOfByte2;
  }
  
  public final void ci(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114930);
    Log.i("MicroMsg.Voip.VoipContext", "updateRemotePid");
    this.GVV.Hcw.GXh = 1;
    this.GVV.Hcw.GXg = 1;
    this.GVV.Hax = paramArrayOfByte;
    AppMethodBeat.o(114930);
  }
  
  public final void cj(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    AppMethodBeat.i(114932);
    Log.i("MicroMsg.Voip.VoipContext", "updateRemoteCapInfo, isGotCapInfo: %s", new Object[] { Byte.valueOf(this.GVV.Hcw.GXl) });
    if ((this.GVV.Hcw.GXl == 1) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(114932);
      return;
    }
    this.GVV.Hcw.GXl = 1;
    this.GVV.Hay = paramArrayOfByte;
    if (this.GVV.Hay != null)
    {
      int i = this.GVV.exchangeCabInfo(this.GVV.Hay, this.GVV.Hay.length);
      if ((this.GVV.Hay == null) || (this.GVV.Hay.length < 36)) {
        bool = true;
      }
      this.GWi = bool;
      if (i < 0)
      {
        com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipContext", "protocal exchangecabinfo failed ret:".concat(String.valueOf(i)));
        this.GVV.Hcw.GXc = 15;
        K(1, -9003, "");
      }
    }
    AppMethodBeat.o(114932);
  }
  
  public final void ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114933);
    this.GVV.Haz = paramArrayOfByte;
    fGJ();
    AppMethodBeat.o(114933);
  }
  
  public final void elV()
  {
    AppMethodBeat.i(114915);
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "In networkRequestViaCellular");
    if (com.tencent.mm.compatible.util.d.oD(21))
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
      Object localObject = new NetworkRequest.Builder();
      ((NetworkRequest.Builder)localObject).addTransportType(0);
      ((NetworkRequest.Builder)localObject).addCapability(12);
      localObject = ((NetworkRequest.Builder)localObject).build();
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "NetworkRequest toString: " + ((NetworkRequest)localObject).toString() + " hashCode: " + ((NetworkRequest)localObject).hashCode());
      try
      {
        localConnectivityManager.requestNetwork((NetworkRequest)localObject, new ConnectivityManager.NetworkCallback()
        {
          public final void onAvailable(Network paramAnonymousNetwork)
          {
            int i = 0;
            AppMethodBeat.i(114890);
            super.onAvailable(paramAnonymousNetwork);
            Object localObject = l.this.GVV;
            ((v2protocal)localObject).Hbe += 1;
            localObject = Parcel.obtain();
            paramAnonymousNetwork.writeToParcel((Parcel)localObject, 0);
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "found requested network. netid: " + ((Parcel)localObject).readInt() + " toString: " + paramAnonymousNetwork.toString());
            if (com.tencent.mm.compatible.util.d.oD(28)) {
              localObject = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
            }
            try
            {
              int j = ((ConnectivityManager)localObject).getMultipathPreference(paramAnonymousNetwork);
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "getMultipathPreference ret ".concat(String.valueOf(j)));
              if (j == 0) {
                l.this.GVV.Hbd = 3;
              }
              if (l.this.zIU != null)
              {
                l.this.zIU = paramAnonymousNetwork;
                if (l.this.zIW == null) {
                  break label266;
                }
                while (i < l.this.zIW.size())
                {
                  l.this.aE(((Integer)l.this.zIW.get(i)).intValue(), true);
                  i += 1;
                }
              }
              label266:
              return;
            }
            catch (Exception paramAnonymousNetwork)
            {
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "getMultipathPreference  Error");
              l.this.GVV.Hbd = 2;
              try
              {
                ((ConnectivityManager)localObject).unregisterNetworkCallback(this);
                AppMethodBeat.o(114890);
                return;
              }
              catch (Exception paramAnonymousNetwork)
              {
                com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "unregisterNetworkCallback Error");
                AppMethodBeat.o(114890);
                return;
              }
              l.this.zIU = paramAnonymousNetwork;
              l.this.zIV = this;
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "networkcallback hashCode: " + l.this.zIV.hashCode());
              l.this.GVV.Hbd = 1;
              AppMethodBeat.o(114890);
            }
          }
        });
        AppMethodBeat.o(114915);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "missing the appropriate permissions");
        this.GVV.Hbd = 2;
        AppMethodBeat.o(114915);
        return;
      }
    }
    AppMethodBeat.o(114915);
  }
  
  public final void elW()
  {
    AppMethodBeat.i(114916);
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "try to UnregisterCellularNetwork");
    ConnectivityManager localConnectivityManager;
    if (com.tencent.mm.compatible.util.d.oD(21))
    {
      localConnectivityManager = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
      if (this.zIV != null) {
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "unregister networkcallback hashCode: " + this.zIV.hashCode());
      }
    }
    try
    {
      localConnectivityManager.unregisterNetworkCallback(this.zIV);
      this.zIV = null;
      this.zIU = null;
      AppMethodBeat.o(114916);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "unregisterNetworkCallback Error");
      }
    }
  }
  
  public final boolean fGA()
  {
    AppMethodBeat.i(114923);
    boolean bool = fGw();
    int i = 0;
    if (bool) {
      i = 1;
    }
    com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipContext", "needVideoIn ret: " + bool + "videoStatus: " + i + ", recvVideoStatus: " + this.GVU);
    if ((this.GVU == -1) || (this.GVU != i))
    {
      if (!bool) {
        break label158;
      }
      com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video In.......!");
    }
    for (int j = this.GVV.setAppCmd(201);; j = this.GVV.setAppCmd(200))
    {
      if (j == 0)
      {
        this.GVU = i;
        com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: succeed, ret: " + j + "recvVideoStatus: " + this.GVU);
      }
      AppMethodBeat.o(114923);
      return bool;
      label158:
      com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video In.......!");
    }
  }
  
  final void fGB()
  {
    AppMethodBeat.i(114924);
    if (this.mStatus == 5)
    {
      setStatus(6);
      this.GVV.Hcw.fGR();
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "talking  now .......!");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114892);
          l.this.GVW.fFS();
          AppMethodBeat.o(114892);
        }
      });
    }
    AppMethodBeat.o(114924);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(184051);
    boolean bool2 = fGC();
    int k = ae.gKt.gGh;
    int m = ae.gKt.gGi;
    int i = this.GVV.HaF;
    int j = (this.GVV.HaF >> 11 & 0x1) << 3 | i >> 4 & 0x7;
    if (bool2) {}
    for (i = fGD();; i = 0)
    {
      boolean bool1;
      if ((m >= 0) || (k >= 0)) {
        if (k >= 0)
        {
          bool1 = true;
          i = k;
        }
      }
      for (;;)
      {
        Log.printInfoStack("MicroMsg.Voip.VoipContext", "setVoipBeautyConfig local:%s, server:%s , blacklist:%s, whitelist:%s, voipBeautyFlag:%s, uiCallback:%s and isHitBlackListOrWhitList:%s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), this.GVW, Boolean.valueOf(bool1) });
        m = i;
        k = j;
        if (!bool1)
        {
          m = i;
          k = j;
          if (i == 0)
          {
            m = i;
            k = j;
            if (com.tencent.mm.plugin.voip.b.g.fKl())
            {
              m = com.tencent.mm.plugin.voip.b.g.fKk();
              k = com.tencent.mm.plugin.voip.b.g.fKk();
            }
          }
        }
        if (this.GVW != null) {
          this.GVW.setVoipBeauty(m);
        }
        this.GVV.HbW = m;
        this.GVV.HbX = k;
        AppMethodBeat.o(184051);
        return;
        if (j == 0)
        {
          bool1 = true;
          i = m;
          continue;
          if ((bool2) && (j > 0))
          {
            bool1 = false;
            i = j;
            continue;
          }
        }
        bool1 = false;
      }
    }
  }
  
  public final void fGF()
  {
    AppMethodBeat.i(235610);
    boolean bool = fGC();
    int k = ae.gKt.gGj;
    int j = this.GVV.HaF >> 15 & 0x1;
    int i;
    if (k > 0) {
      i = 1;
    }
    for (;;)
    {
      if (this.GVW != null) {
        this.GVW.setSpatiotemporalDenosing(i);
      }
      Log.i("MicroMsg.Voip.VoipContext", "hseasun: stfitler  voipSTFilterSvrCfg: %d, voipSTFilterWhiteList:%d voipSTFilterFlag:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      this.GVV.HbY = i;
      AppMethodBeat.o(235610);
      return;
      if ((bool) && (j > 0)) {
        i = j;
      } else {
        i = 0;
      }
    }
  }
  
  public final void fGG()
  {
    AppMethodBeat.i(177021);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114896);
        if ((l.this.mStatus != 4) && (l.this.mStatus != 5) && (l.this.mStatus != 6))
        {
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "startConnectDirect status fail, status:" + l.this.mStatus);
          AppMethodBeat.o(114896);
          return;
        }
        if (l.this.GVs)
        {
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "can not startConnectDirect again");
          AppMethodBeat.o(114896);
          return;
        }
        l.this.GVs = true;
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel direct");
        if (l.this.GVV.Hca == null)
        {
          com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipContext", "direct conns buf null");
          AppMethodBeat.o(114896);
          return;
        }
        int i = l.this.GVV.AddNewDirectConns(l.this.GVV.Hca, l.this.GVV.Hca.length, 0);
        if (i < 0)
        {
          com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipContext", "v2protocal connectToPeerDirect failed, ret:".concat(String.valueOf(i)));
          AppMethodBeat.o(114896);
          return;
        }
        l.this.fGJ();
        AppMethodBeat.o(114896);
      }
    });
    AppMethodBeat.o(177021);
  }
  
  public final void fGH()
  {
    AppMethodBeat.i(177022);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114897);
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "v2protocal QueryNicWanIp");
        if ((l.this.zIU != null) && (l.this.GVV.Hcb != null))
        {
          int i = l.this.GVV.QueryNicWanIp(l.this.GVV.Hcb, l.this.GVV.Hcb.length);
          if (i != 0) {
            com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipContext", "query nic wan ip fail ret:".concat(String.valueOf(i)));
          }
        }
        else
        {
          l.this.elW();
          AppMethodBeat.o(114897);
          return;
        }
        AppMethodBeat.o(114897);
      }
    });
    AppMethodBeat.o(177022);
  }
  
  public final void fGI()
  {
    AppMethodBeat.i(114928);
    if (!Util.isNullOrNil(this.GVV.Hax)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "channel:try start connect, hasRemotePid:" + bool + ",mStatus:" + this.mStatus + ",isPreConnect:" + this.GVx + ",isRemoteAccepted:" + this.GVu + ",isLocalAccept:" + this.dWM);
      this.GVV.Hcw.GXo = 7;
      if ((!bool) || ((this.mStatus != 4) && (this.mStatus != 5) && (this.mStatus != 6) && ((this.mStatus != 2) || (this.GVx != true)) && ((this.mStatus != 3) || (this.GVx != true)))) {
        break label329;
      }
      if ((this.mStatus == 2) || (this.mStatus == 3) || (this.mStatus == 4) || (this.mStatus == 5) || (this.mStatus == 6)) {
        break;
      }
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "startConnect status fail, status:" + this.mStatus);
      AppMethodBeat.o(114928);
      return;
    }
    if ((!this.GVu) && (!this.dWM))
    {
      if ((this.GVx) && (!this.GVr))
      {
        a(new d()
        {
          public final void fGL()
          {
            AppMethodBeat.i(177016);
            Log.i("MicroMsg.Voip.VoipContext", "onStartConnectRelay ok");
            AppMethodBeat.o(177016);
          }
        });
        AppMethodBeat.o(114928);
      }
    }
    else
    {
      if (!this.GVr)
      {
        a(new d()
        {
          public final void fGL()
          {
            AppMethodBeat.i(177017);
            Log.i("MicroMsg.Voip.VoipContext", "onStartConnectRelay ok");
            l.this.fGG();
            l.this.fGH();
            AppMethodBeat.o(177017);
          }
        });
        AppMethodBeat.o(114928);
        return;
      }
      fGG();
      fGH();
    }
    label329:
    AppMethodBeat.o(114928);
  }
  
  public final void fGJ()
  {
    AppMethodBeat.i(114929);
    if ((this.GVs) && (!Util.isNullOrNil(this.GVV.Haz)))
    {
      int i = this.GVV.handleCommand(1, this.GVV.Haz, this.GVV.Haz.length);
      if (i < 0) {
        com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipContext", "v2protocal handlecommand failed ret:".concat(String.valueOf(i)));
      }
      this.GVV.Haz = null;
    }
    AppMethodBeat.o(114929);
  }
  
  public final void fGK()
  {
    AppMethodBeat.i(114934);
    Log.i("MicroMsg.Voip.VoipContext", "stop repeat voip sync");
    this.GWl.stopTimer();
    AppMethodBeat.o(114934);
  }
  
  public final void fGn()
  {
    int k = 0;
    AppMethodBeat.i(114901);
    if ((this.GVr == true) && (this.GVA == 0))
    {
      this.GVA = 1;
      if (this.GVV.field_speedTestInfoLength < 8)
      {
        com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! bufsize=" + this.GVV.field_speedTestInfoLength);
        AppMethodBeat.o(114901);
      }
    }
    else
    {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipContext", "StartVoipSpeedTest fail for status is wrong: isChannelStartConnect=" + this.GVr + " ,mSpeedTestStatus=" + this.GVA);
      AppMethodBeat.o(114901);
      return;
    }
    int i = this.GVV.Hcu[1];
    if (i + 2 > this.GVV.field_speedTestInfoLength)
    {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i + ", bufsize=" + this.GVV.field_speedTestInfoLength);
      AppMethodBeat.o(114901);
      return;
    }
    int j = this.GVV.Hcu[(i + 2 + 1)];
    if (i + 6 + j != this.GVV.field_speedTestInfoLength)
    {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i + ", C2SRttCnt=" + j + ", bufsize=" + this.GVV.field_speedTestInfoLength);
      AppMethodBeat.o(114901);
      return;
    }
    this.GVB = this.GVV.ypH;
    this.GVD = this.GVV.netType;
    this.GVE = this.GVV.roomId;
    this.GVz.LsZ = this.GVV.roomId;
    this.GVz.NbR = this.GVV.HaK;
    this.GVz.Llx = this.GVV.netType;
    eca localeca = this.GVz;
    if (this.GVr == true)
    {
      i = 1;
      localeca.NbS = i;
      localeca = this.GVz;
      if (this.GVt != true) {
        break label482;
      }
    }
    label482:
    for (i = 1;; i = 0)
    {
      localeca.NbT = i;
      this.GVz.NbU = this.GVV.Hcu[0];
      this.GVz.NbV = this.GVV.Hcu[1];
      j = 0;
      i = 2;
      while (j < this.GVz.NbV)
      {
        this.GVz.NbW.add(Integer.valueOf(this.GVV.Hcu[i]));
        j += 1;
        i += 1;
      }
      i = 0;
      break;
    }
    localeca = this.GVz;
    int[] arrayOfInt = this.GVV.Hcu;
    j = i + 1;
    localeca.NbX = arrayOfInt[i];
    localeca = this.GVz;
    arrayOfInt = this.GVV.Hcu;
    i = j + 1;
    localeca.NbY = arrayOfInt[j];
    j = k;
    while (j < this.GVz.NbY)
    {
      this.GVz.NbZ.add(Integer.valueOf(this.GVV.Hcu[i]));
      j += 1;
      i += 1;
    }
    this.GVz.Nca = this.GVV.Hcu[i];
    this.GVz.Ncb = this.GVV.Hcu[(i + 1)];
    new com.tencent.mm.plugin.voip.model.a.k(this.GVz).fII();
    AppMethodBeat.o(114901);
  }
  
  public final void fGo()
  {
    AppMethodBeat.i(114902);
    if (this.GVA == 0)
    {
      AppMethodBeat.o(114902);
      return;
    }
    if (this.GVA == 1)
    {
      this.GVA = 0;
      this.GVV.Hce = 0L;
      AppMethodBeat.o(114902);
      return;
    }
    this.GVA = 0;
    v2protocal localv2protocal = this.GVV;
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "v2protocal StopVoipSpeedTest!");
    localv2protocal.StopSpeedTest();
    localv2protocal.Hce = 0L;
    AppMethodBeat.o(114902);
  }
  
  public final void fGp()
  {
    AppMethodBeat.i(114905);
    this.GVV.HaM = this.GVX.fGN();
    this.GVV.HaN = this.GVX.fFs();
    AppMethodBeat.o(114905);
  }
  
  public final int fGq()
  {
    int i = 2;
    if (this.mStatus == 1) {
      i = 0;
    }
    do
    {
      return i;
      if ((this.mStatus == 2) || (this.mStatus == 3)) {
        return 1;
      }
    } while (this.mStatus == 4);
    return 3;
  }
  
  public final boolean fGr()
  {
    return (this.mStatus == 2) || (this.mStatus == 4);
  }
  
  public final boolean fGs()
  {
    return this.mStatus == 3;
  }
  
  public final boolean fGt()
  {
    AppMethodBeat.i(114908);
    Log.d("MicroMsg.Voip.VoipContext", "isWorking, status: %d", new Object[] { Integer.valueOf(this.mStatus) });
    if (this.mStatus == 1)
    {
      AppMethodBeat.o(114908);
      return false;
    }
    AppMethodBeat.o(114908);
    return true;
  }
  
  public final long fGu()
  {
    return this.GVV.HaK;
  }
  
  public final boolean fGv()
  {
    if (this.GVH) {
      return false;
    }
    switch (this.GVJ)
    {
    }
    do
    {
      do
      {
        do
        {
          return true;
          return true;
        } while (4 == this.GVK);
        return false;
      } while ((4 == this.GVK) || (-1 == this.GVK));
      return false;
      if ((5 == this.GVK) || (6 == this.GVK)) {
        break;
      }
    } while (7 != this.GVK);
    return false;
  }
  
  public final boolean fGw()
  {
    if (this.GVH) {
      return false;
    }
    switch (this.GVJ)
    {
    }
    do
    {
      do
      {
        do
        {
          return true;
          return true;
        } while (4 == this.GVK);
        return false;
      } while ((4 == this.GVL) || (this.GVL == 0) || (-1 == this.GVL));
      return false;
      if ((5 == this.GVL) || (6 == this.GVL)) {
        break;
      }
    } while (7 != this.GVL);
    return false;
  }
  
  public final void fGy()
  {
    AppMethodBeat.i(114917);
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: try start talk");
    if ((this.GVv != true) || (this.GVt != true))
    {
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: fail isCanSendData " + this.GVv + ", isChannelConnectedSuccess " + this.GVt);
      AppMethodBeat.o(114917);
      return;
    }
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "Voip tryStartTalk, channel setActive");
    this.GVV.setActive();
    if (this.GVy == true)
    {
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: engine already started, isEngineStarted " + this.GVy);
      AppMethodBeat.o(114917);
      return;
    }
    this.GVV.setSvrConfig(205, 0, 0, this.GVV.HbM, 0, 0, 0, 0, null);
    this.GVV.setSvrConfig(207, 0, 0, this.GVV.HaF, 0, 0, 0, 0, null);
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.GVV.HbM + " SwitchFlag = " + this.GVV.HaF);
    this.GVV.HaI[0] = ((byte)ae.gKE.gGV);
    this.GVV.HaI[1] = ((byte)ae.gKE.gGW);
    this.GVV.HaI[2] = ((byte)ae.gKE.gGX);
    this.GVV.HaI[3] = ((byte)ae.gKE.gGY);
    this.GVV.HaI[4] = ((byte)ae.gKE.gGZ);
    this.GVV.HaI[5] = ((byte)ae.gKE.gHa);
    this.GVV.HaI[6] = ((byte)ae.gKE.gHb);
    this.GVV.HaI[7] = ((byte)ae.gKE.gHc);
    this.GVV.HaI[8] = ((byte)ae.gKE.gHd);
    this.GVV.HaI[9] = ((byte)ae.gKE.gHe);
    this.GVV.setSvrConfig(209, 0, 0, 0, 0, 0, 0, this.GVV.HaI.length, this.GVV.HaI);
    if (this.GVV.startEngine() == 0) {
      this.GVV.Hcw.GXC = 0;
    }
    for (;;)
    {
      label503:
      Object localObject1;
      label525:
      label583:
      int j;
      int k;
      label963:
      int m;
      int n;
      if (this.GVV.HaH != null) {
        if (this.GVV.HaH.length < 1024)
        {
          this.GVV.setSvrConfig(208, 0, 0, 0, 0, 0, 0, this.GVV.HaH.length, this.GVV.HaH);
          fGx();
          if ((fGv()) || (fGw())) {
            break label2834;
          }
          fGB();
          this.GVW.fFT();
          localObject1 = this.GVX;
          if (((n)localObject1).qrL != 2) {
            break label2892;
          }
          com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipDeviceHandler", "dev start already...");
          localObject1 = this.GVV.Hcw;
          if (((o)localObject1).beginTime != 0L) {
            break label3454;
          }
          ((o)localObject1).GXv = 0;
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + ((o)localObject1).beginTime + ", CurrentTime: " + System.currentTimeMillis());
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.VoipDailReport", "devin:endNewDial:" + ((o)localObject1).GXv);
          this.GVW.onConnected();
          this.mStatus = 5;
          localObject1 = this.GVV.Hcw;
          ((o)localObject1).GXD = System.currentTimeMillis();
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.VoipDailReport", "devin:beginTalk:" + ((o)localObject1).GXD);
          this.GVV.setSvrConfig(202, this.GVV.Hbl, this.GVV.Hbm, 0, 0, 0, 0, 0, null);
          this.GVV.setSvrConfig(203, 0, 0, this.GVV.Hbq, 0, 0, 0, 0, null);
          this.GVV.setSvrConfig(206, 0, 0, this.GVV.Hbu, 0, 0, 0, 0, null);
          this.GVV.setSvrConfig(103, this.GVV.Hbn, this.GVV.Hbo, this.GVV.Hbp, this.GVV.Hbs, 0, 0, 0, null);
          this.GVV.setSvrConfig(205, 0, 0, this.GVV.HbM, 0, 0, 0, 0, null);
          this.GVV.setSvrConfig(207, 0, 0, this.GVV.HaF, 0, 0, 0, 0, null);
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.GVV.HbM + " SwitchFlag = " + this.GVV.HaF);
          j = this.GVV.Hbz >> 2 & 0x3;
          k = this.GVV.Hbz & 0x3;
          if (this.GVV.ypO != 0) {
            break label3472;
          }
          j = (j << 2) + k;
          this.GVV.setSvrConfig(502, 0, 0, j, 0, 0, 0, 0, null);
          this.GVV.setSvrConfig(503, 0, 0, this.GVV.HbA, this.GVV.HbB, this.GVV.HbC, this.GVV.HbD, 0, null);
          if ((this.GVV.HbR != null) && (this.GVV.HbS != null))
          {
            this.GVV.setSvrConfig(504, 0, 0, this.GVV.HbQ, 0, 0, 0, 0, null);
            this.GVV.setSvrConfig(505, 0, 0, this.GVV.HbR[0], this.GVV.HbR[1], this.GVV.HbR[2], this.GVV.HbR[3], 0, null);
            this.GVV.setSvrConfig(506, 0, 0, this.GVV.HbS[0], this.GVV.HbS[1], 0, 0, 0, null);
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "FECSvrCtr = " + this.GVV.HbQ + ",FECKeyPara1 = " + this.GVV.HbR[0] + "," + this.GVV.HbR[1] + "," + this.GVV.HbR[2] + "," + this.GVV.HbR[3] + ",FECKeyPara2 = " + this.GVV.HbS[0] + "," + this.GVV.HbS[1]);
          }
          k = this.GVV.HbE;
          m = this.GVV.HbE;
          n = this.GVV.HbE;
          this.GVV.setSvrConfig(507, 0, 0, (k & 0x4) >> 2, (m & 0x2) >> 1, n & 0x1, 0, 0, null);
          this.GVV.setjbmbitraterssvrparam();
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "zhengxue[Logic] setSvrConfig brefore onStartTalk: audioTsdfBeyond3G = " + this.GVV.Hbl + ",audioTsdEdge = " + this.GVV.Hbm + ",passthroughQosAlgorithm = " + this.GVV.Hbn + ",fastPlayRepair = " + this.GVV.Hbo + ", audioDTX = " + this.GVV.Hbq + ", mARQFlag = " + j + ", mQosStrategy = " + this.GVV.HbE + ", mSvrCfgListV = " + this.GVV.Hbp + ", maxBRForRelay = " + this.GVV.Hbs);
          localObject1 = new byte[2];
          localObject1[0] = ((byte)ae.gKt.gGb);
          localObject1[1] = -1;
          com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipContext", "steve: Model Name: " + Build.MODEL);
          com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipContext", "steve: Image Enhancement for Android Capture!!, mode: " + localObject1[0]);
          this.GVV.setAppCmd(15, (byte[])localObject1, 1);
          com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipContext", "anlin: ClientVersion: " + com.tencent.mm.protocal.d.KyO);
          localObject1 = ByteBuffer.allocate(4);
          ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN).putInt(com.tencent.mm.protocal.d.KyO);
          localObject1 = ((ByteBuffer)localObject1).array();
          this.GVV.setAppCmd(505, (byte[])localObject1, 4);
        }
      }
      label3472:
      try
      {
        if (this.GVV != null)
        {
          ??? = new epd();
          ((epd)???).NmY = 8;
          ((epd)???).NmZ = new com.tencent.mm.bw.b((byte[])localObject1);
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "anlin send local client version: ".concat(String.valueOf(localObject1)));
          this.GVV.SendRUDP(((epd)???).toByteArray(), ((epd)???).toByteArray().length);
        }
        localObject1 = Build.MODEL;
        j = ((String)localObject1).length();
        localObject1 = ((String)localObject1).getBytes();
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "anlin DeviceModel: ".concat(String.valueOf(localObject1)));
        this.GVV.setAppCmd(507, (byte[])localObject1, j);
      }
      catch (Exception localException1)
      {
        label2834:
        label3515:
        label3648:
        try
        {
          if (this.GVV != null)
          {
            ??? = new epd();
            ((epd)???).NmY = 9;
            ((epd)???).NmZ = new com.tencent.mm.bw.b((byte[])localObject1);
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "anlin send local device model: ".concat(String.valueOf(localObject1)));
            this.GVV.SendRUDP(((epd)???).toByteArray(), ((epd)???).toByteArray().length);
          }
          if ((this.GVV.HaF >> 17 & 0x1) != 0)
          {
            bool1 = true;
            if ((this.GVV.HaF >> 18 & 0x1) == 0) {
              break label3515;
            }
            bool2 = true;
            xb(bool1);
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "EnableBlur: SetBlurFlag =47, aqBlur=" + bool2);
            if (bool2)
            {
              localObject1 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject1).putInt(1);
              this.GVV.setAppCmd(47, ((ByteBuffer)localObject1).array(), 4);
            }
            if ((this.GVV.HaF & 0x2) == 0)
            {
              j(16, true, true);
              j(4, true, true);
            }
            j = this.GVV.HaF >> 12 & 0x1;
            localObject1 = ByteBuffer.allocate(4);
            ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
            ((ByteBuffer)localObject1).putInt(j);
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "weiranli set MixVcodec1 from svr = ".concat(String.valueOf(j)));
            this.GVV.setAppCmd(46, ((ByteBuffer)localObject1).array(), 4);
            if ((this.GVV.HaF & 0x200) == 0)
            {
              localObject1 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject1).putInt(8);
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "jcchen Disable 720p from svr: mSwitchFlag = " + this.GVV.HaF);
              this.GVV.setAppCmd(32, ((ByteBuffer)localObject1).array(), 4);
              this.GVV.setAppCmd(30, ((ByteBuffer)localObject1).array(), 4);
            }
            if ((this.GVV.HaF & 0x100000) != 1) {
              break label3521;
            }
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "setAppCmd: EMethodSetP2SSendThreadEnable enble, mSwitchFlag: " + this.GVV.HaF);
            this.GVV.setAppCmd(52);
            if (ac.jPq == 0) {
              break label3553;
            }
            localObject1 = ByteBuffer.allocate(4);
            ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
            ((ByteBuffer)localObject1).putInt(ac.jPq);
            this.GVV.setAppCmd(36, ((ByteBuffer)localObject1).array(), 4);
            localObject1 = new byte[4];
            this.GVV.setAppCmd(26, (byte[])localObject1, 4);
            localObject1 = ByteBuffer.wrap((byte[])localObject1);
            ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
            m = ((ByteBuffer)localObject1).getInt();
            com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipContext", "steve: iHW: ".concat(String.valueOf(m)));
            if (((this.GVV.Hbp & 0x4) == 0) && (ae.gKt.gGd <= 0)) {
              break label3648;
            }
            j = 1;
            if ((j == 0) && (this.GVV.qtK))
            {
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:Server Disable HW enc/dec!!");
              if ((m & 0x4) == 0) {
                break label3653;
              }
              j = 1;
              if ((m & 0x8) == 0) {
                break label3658;
              }
              k = 1;
              if ((j != 0) || (k != 0))
              {
                this.GVX.GWL = true;
                aF(false, false);
              }
              this.GVV.qtK = false;
            }
            if (this.GVV.qtK)
            {
              ??? = this.GVV;
              n = ae.gKt.gGd;
              bool1 = false;
              if ((m & 0x4) == 0) {
                break label3663;
              }
              j = 1;
              if ((m & 0x8) == 0) {
                break label3668;
              }
              k = 1;
              if ((j != 0) || (k != 0))
              {
                if (j == 0) {
                  break label3673;
                }
                localObject1 = "video/hevc";
                ((v2protocal)???).Hcz = new e(((v2protocal)???).width, ((v2protocal)???).height, ((v2protocal)???).HcB, ((v2protocal)???).bitrate, n, (String)localObject1);
                com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "steve : create HW encoder successfully:".concat(String.valueOf(localObject1)));
                if (v2protocal.HcC != null)
                {
                  v2protocal.HcA = new d(v2protocal.HcC);
                  com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "steve : create HW decoder successfully!");
                }
                bool1 = true;
              }
              if ((((v2protocal)???).Hcz == null) || (v2protocal.HcA == null))
              {
                ((v2protocal)???).qtK = false;
                bool1 = false;
              }
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve: HW encoder/decoder init ret: " + bool1 + ", iHW:" + m);
              if (!this.GVV.qtK)
              {
                com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve: HW dec/enc NOT supported for both sides,end HWEnc!!");
                this.GVX.GWL = true;
                aF(false, false);
                c(8, true, false, true);
                c(8, true, false, false);
              }
            }
            if (this.GVV.Hcz != null) {
              this.GVV.Hcz.GSZ = this;
            }
            if (v2protocal.HcA != null) {
              v2protocal.HcA.a(this);
            }
            this.GVy = true;
            this.GWh = false;
            localObject1 = this.GWj;
            ((VoipScoreState)localObject1).yrb = bp.aVP();
            Log.i("MicroMsg.VoipScoreState", "markStartTalk, startTalkTime:%s", new Object[] { Long.valueOf(((VoipScoreState)localObject1).yrb) });
            fGz();
            fGA();
            AppMethodBeat.o(114917);
            return;
            this.GVy = false;
            this.GVV.Hcw.GXC = 1;
            continue;
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: length of generalStrategyBuf = " + this.GVV.HaH.length);
            break label503;
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: protocol has null generalStrategyBuf");
            break label503;
            if (this.GWm != null)
            {
              fGB();
              break label525;
            }
            this.GWm = new Timer();
            this.GWn = 0;
            localObject1 = new TimerTask()
            {
              public final void run()
              {
                AppMethodBeat.i(114893);
                l locall = l.this;
                locall.GWn += 1;
                if ((l.this.GVV.Hck != 0) || (l.this.GWn > 10))
                {
                  l.this.fGB();
                  if (l.this.GWm != null)
                  {
                    l.this.GWm.cancel();
                    l.this.GWm = null;
                  }
                  AppMethodBeat.o(114893);
                  return;
                }
                AppMethodBeat.o(114893);
              }
            };
            this.GWm.schedule((TimerTask)localObject1, 200L, 200L);
            break label525;
            label2892:
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipDeviceHandler", "start device......");
            ((n)localObject1).qrL = 2;
            ((n)localObject1).GWL = false;
            ((n)localObject1).GWM = 0;
            if (((n)localObject1).GWP != null)
            {
              Log.i("MicroMsg.Voip.VoipDeviceHandler", "mDevHandlerThread is not null");
              if (!((n)localObject1).GWP.isQuit()) {
                Log.i("MicroMsg.Voip.VoipDeviceHandler", "mDevHandlerThread is alive");
              }
            }
            ((n)localObject1).GWP.removeCallbacksAndMessages(null);
            if (((n)localObject1).GWU != null)
            {
              com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
              ((n)localObject1).GWU.GWY = true;
              ((n)localObject1).GWU.cancel();
              ((n)localObject1).GWU = null;
            }
            ((n)localObject1).GWU = new n.a((n)localObject1);
            ThreadPool.post(((n)localObject1).GWU, "VoipDeviceHandler_decode");
            com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipDeviceHandler", "start video decode thread..");
            ae.gKu.dump();
            for (;;)
            {
              synchronized (((n)localObject1).GWJ)
              {
                while (((n)localObject1).qrL == n.qrK)
                {
                  Log.e("MicroMsg.Voip.VoipDeviceHandler", "current is not allowed to start dev");
                  synchronized (((n)localObject1).GWJ)
                  {
                    ((n)localObject1).GWP.post(new n.2((n)localObject1));
                  }
                }
                localn.GWB = new c();
                localn.GWB.GTm = String.valueOf(localn.GWQ);
                a locala = new a();
                j = localn.GSZ.GVV.a(locala);
                com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.GetAudioDeviceFmt, play samplerate:" + locala.Bry + ", framelen: " + locala.GSV + ", ret:" + j);
                localn.GWB.N(locala.Bry, locala.channels, locala.GSV, 0);
                localn.qrM = localn.GWB.F(localn.GSZ.owO, true);
                localn.GSZ.GVV.HaZ = localn.GWB.jvb;
                if (localn.GWB.GSY == true)
                {
                  j = 1;
                  int i = (byte)j;
                  localn.GSZ.GVV.setAppCmd(502, new byte[] { i }, 1);
                  if (localn.qrM <= 10)
                  {
                    if (localn.qrM <= 0) {
                      localn.qrP = 1;
                    }
                    localn.qrM = 92;
                  }
                  if ((!com.tencent.mm.plugin.audio.c.a.cdW()) && (!com.tencent.mm.plugin.audio.c.a.ceb())) {
                    break label3444;
                  }
                  com.tencent.mm.plugin.voip.c.fFg().ry(true);
                  localn.GWB.GTi = new n.3(localn);
                  if (localn.GWB.fFp() <= 0) {
                    localn.qrP = 1;
                  }
                }
              }
              j = 0;
              continue;
              label3444:
              com.tencent.mm.plugin.voip.c.fFg().ry(false);
            }
            label3454:
            localObject2.GXv = ((int)(System.currentTimeMillis() - localObject2.beginTime));
            break label583;
            j = (k << 2) + j;
            break label963;
            localException1 = localException1;
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "anlin send local client version Error!");
          }
        }
        catch (Exception localException2)
        {
          label3521:
          label3653:
          label3658:
          label3663:
          label3668:
          label3673:
          for (;;)
          {
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "anlin send local device model Error!");
            continue;
            boolean bool1 = false;
            continue;
            boolean bool2 = false;
            continue;
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "setAppCmd: EMethodSetP2SSendThreadEnable disable, mSwitchFlag: " + this.GVV.HaF);
            continue;
            label3553:
            if (ac.jPr != 0)
            {
              if ((ac.jPr & 0x2) != 0) {
                j(2, true, false);
              }
              if ((ac.jPr & 0x20) != 0) {
                j(32, true, false);
              }
              if ((ac.jPr & 0x10) != 0) {
                j(16, true, false);
              }
              if ((ac.jPr & 0x4) != 0) {
                j(4, true, false);
              }
              if ((ac.jPr & 0x8) != 0)
              {
                j(8, true, false);
                continue;
                j = 0;
                continue;
                j = 0;
                continue;
                k = 0;
                continue;
                j = 0;
                continue;
                k = 0;
                continue;
                String str = "video/avc";
              }
            }
          }
        }
      }
    }
  }
  
  public final boolean fGz()
  {
    AppMethodBeat.i(114922);
    boolean bool = fGv();
    int i = 0;
    if (bool) {
      i = 1;
    }
    com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipContext", "needVideoOut ret: " + bool + "videoStatus: " + i + ", sendVideoStatus: " + this.GVT);
    if ((this.GVT == -1) || (this.GVT != i))
    {
      if (!bool) {
        break label158;
      }
      com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video Out.......!");
    }
    for (int j = this.GVV.setAppCmd(203);; j = this.GVV.setAppCmd(202))
    {
      if (j == 0)
      {
        this.GVT = i;
        com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: succeed, ret: " + j + "sendVideoStatus: " + this.GVT);
      }
      AppMethodBeat.o(114922);
      return bool;
      label158:
      com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video Out.......!");
    }
  }
  
  public final int j(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(114919);
    if (paramInt < 0)
    {
      AppMethodBeat.o(114919);
      return -1;
    }
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:DisableCodec: targetCodec = " + paramInt + ", local=" + paramBoolean1 + ", remote =" + paramBoolean2);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.putInt(paramInt);
    if (paramBoolean1) {}
    try
    {
      if (this.GVV != null)
      {
        epd localepd = new epd();
        localepd.NmY = 5;
        localepd.NmZ = new com.tencent.mm.bw.b(localByteBuffer.array());
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable local target codec: ".concat(String.valueOf(paramInt)));
        this.GVV.SendRUDP(localepd.toByteArray(), localepd.toByteArray().length);
      }
      if (paramBoolean2)
      {
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable remote target codec: ".concat(String.valueOf(paramInt)));
        localByteBuffer = ByteBuffer.allocate(6);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer.putShort((short)3);
        localByteBuffer.putShort((short)paramInt);
        localByteBuffer.putShort((short)0);
        this.GVV.setAppCmd(35, localByteBuffer.array(), 6);
      }
      AppMethodBeat.o(114919);
      return 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "DisableCodec Error");
      }
    }
  }
  
  public final void k(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.GVV.Hbz = paramInt1;
    this.GVV.HbA = paramInt2;
    this.GVV.HbB = paramInt3;
    this.GVV.HbC = paramInt4;
    this.GVV.HbD = paramInt5;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(114900);
    Log.i("MicroMsg.Voip.VoipContext", "reset");
    this.GVX.fGO();
    if (this.GVV.fIZ()) {
      this.GVV.xh(false);
    }
    this.GVV.reset();
    this.GVJ = -1;
    this.GVK = -1;
    this.GVL = -1;
    this.GVM = -1;
    this.GVN = -1;
    this.GVV.HaQ = 0;
    this.GWo.stopTimer();
    this.GVY.fIE();
    this.GWl.stopTimer();
    this.GVr = false;
    this.GVt = false;
    this.GVs = false;
    this.GVu = false;
    this.dWM = false;
    this.GVv = false;
    this.GVZ = null;
    this.GWa = null;
    this.GVF = false;
    this.GVG = false;
    this.GVH = false;
    this.GVO = false;
    this.GVP = false;
    this.GVR = false;
    this.GVQ = 1;
    this.GVS = 1;
    this.GWb = false;
    this.GVT = -1;
    this.GVU = -1;
    this.GVw = false;
    this.GVx = false;
    this.GVv = false;
    this.GVr = false;
    this.GVy = false;
    this.GVI = 10;
    this.mStatus = 1;
    this.GWg = 0;
    this.GWk = 0;
    this.GWh = false;
    this.GWf = 0;
    this.zIU = null;
    this.zIW.clear();
    AppMethodBeat.o(114900);
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(114907);
    if (paramInt == this.mStatus)
    {
      AppMethodBeat.o(114907);
      return;
    }
    if (paramInt == 4) {
      this.GWo.startTimer(60000L);
    }
    this.mStatus = paramInt;
    AppMethodBeat.o(114907);
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(114906);
    fGK();
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114889);
        if (l.this.GVW != null) {
          l.this.GVW.wW(false);
        }
        AppMethodBeat.o(114889);
      }
    });
    AppMethodBeat.o(114906);
  }
  
  public static abstract interface a
  {
    public abstract void K(int paramInt1, int paramInt2, String paramString);
  }
  
  static abstract interface d
  {
    public abstract void fGL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l
 * JD-Core Version:    0.7.0.1
 */