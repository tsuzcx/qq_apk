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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.model.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.dhv;
import com.tencent.mm.protocal.protobuf.duf;
import com.tencent.mm.protocal.protobuf.dww;
import com.tencent.mm.protocal.protobuf.dxo;
import com.tencent.mm.protocal.protobuf.dxp;
import com.tencent.mm.protocal.protobuf.dxv;
import com.tencent.mm.protocal.protobuf.dym;
import com.tencent.mm.protocal.protobuf.dyx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
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
  private int CaA;
  public boolean CaB;
  private boolean CaC;
  private int CaD;
  private boolean CaE;
  private int CaF;
  private int CaG;
  private int CaH;
  public v2protocal CaI;
  public x CaJ;
  public n CaK;
  public w CaL;
  public byte[] CaM;
  public dxv CaN;
  public boolean CaO;
  public boolean CaP;
  public int CaQ;
  public int CaR;
  public int CaS;
  public int CaT;
  public boolean CaU;
  public boolean CaV;
  public VoipScoreState CaW;
  public Network CaX;
  public ConnectivityManager.NetworkCallback CaY;
  public LinkedList<Integer> CaZ;
  public boolean Cae;
  public boolean Caf;
  public boolean Cag;
  public boolean Cah;
  public boolean Cai;
  public boolean Caj;
  public boolean Cak;
  public boolean Cal;
  public dhv Cam;
  public int Can;
  public long Cao;
  public long Cap;
  public int Caq;
  public int Car;
  public boolean Cas;
  public boolean Cat;
  public boolean Cau;
  public int Cav;
  private int Caw;
  private int Cax;
  private int Cay;
  private int Caz;
  public int Cba;
  public av Cbb;
  Timer Cbc;
  int Cbd;
  private av Cbe;
  private a Cbf;
  public boolean dDV;
  ap mHandler;
  public int mStatus;
  public Context nhZ;
  
  protected l()
  {
    AppMethodBeat.i(114899);
    this.mStatus = 1;
    this.Cae = false;
    this.Caf = false;
    this.Cag = false;
    this.Cah = false;
    this.dDV = false;
    this.Cai = false;
    this.Caj = false;
    this.Cak = false;
    this.Cal = false;
    this.Cam = new dhv();
    this.Can = 0;
    this.Cao = 0L;
    this.Cap = 0L;
    this.Caq = 0;
    this.Car = 0;
    this.Cas = false;
    this.Cat = false;
    this.Cau = false;
    this.Cav = 10;
    this.Caw = -1;
    this.Cax = -1;
    this.Cay = -1;
    this.Caz = -1;
    this.CaA = -1;
    this.CaB = false;
    this.CaC = false;
    this.CaD = 1;
    this.CaE = false;
    this.CaF = 1;
    this.CaG = -1;
    this.CaH = -1;
    this.nhZ = null;
    this.CaJ = x.CeH;
    this.CaM = null;
    this.CaN = null;
    this.CaO = false;
    this.CaP = false;
    this.CaQ = 0;
    this.CaR = 0;
    this.CaS = 0;
    this.CaT = 0;
    this.CaU = false;
    this.CaV = true;
    this.CaX = null;
    this.CaY = null;
    this.CaZ = new LinkedList();
    this.Cba = 0;
    this.Cbb = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(114886);
        ad.v("MicroMsg.Voip.VoipContext", "voip repeat sync");
        l.this.CaL.a(null, false, 7);
        AppMethodBeat.o(114886);
        return true;
      }
    }, true);
    this.mHandler = new ap(Looper.getMainLooper())
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
          if (l.this.CaI.roomId == 0)
          {
            f.Loge("MicroMsg.Voip.VoipContext", "JNI_DOSYNC without roomid , igored!");
            AppMethodBeat.o(114891);
            return;
          }
          f.Logi("MicroMsg.Voip.VoipContext", "need dosync for cmd from channel...");
          localObject3 = (byte[])paramAnonymousMessage.obj;
          localObject1 = l.this.CaL;
          i = paramAnonymousMessage.arg2;
          paramAnonymousMessage = new dym();
          paramAnonymousMessage.nEf = 1;
          localObject4 = new SKBuiltinBuffer_t();
          ((SKBuiltinBuffer_t)localObject4).setBuffer((byte[])localObject3);
          paramAnonymousMessage.FAN = ((SKBuiltinBuffer_t)localObject4);
          localObject3 = new SKBuiltinBuffer_t();
          try
          {
            ((SKBuiltinBuffer_t)localObject3).setBuffer(paramAnonymousMessage.toByteArray());
            paramAnonymousMessage = new dxo();
            paramAnonymousMessage.FYU = i;
            paramAnonymousMessage.FYV = ((SKBuiltinBuffer_t)localObject3);
            paramAnonymousMessage.ukj = com.tencent.mm.model.u.aAm();
            localObject3 = new dxp();
            ((dxp)localObject3).nDi = 1;
            ((dxp)localObject3).nDj.add(paramAnonymousMessage);
            ((w)localObject1).a((dxp)localObject3, true, 2);
            AppMethodBeat.o(114891);
            return;
          }
          catch (IOException paramAnonymousMessage)
          {
            ad.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramAnonymousMessage, "", new Object[0]);
            AppMethodBeat.o(114891);
            return;
          }
        }
        if (paramAnonymousMessage.arg1 == 4)
        {
          if (l.this.CaI.roomId == 0)
          {
            f.Loge("MicroMsg.Voip.VoipContext", "JNI_STARTDEVFAILED without roomid , igored!");
            AppMethodBeat.o(114891);
            return;
          }
          f.Logi("MicroMsg.Voip.VoipContext", "need hangUP for startTalk failed. ");
          l.this.CaI.Chg.CbS = 107;
          l.this.J(1, -9004, "");
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 6)
        {
          f.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected from JNI");
          if (l.this.CaI.roomId == 0)
          {
            f.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected roomid null, ignored");
            AppMethodBeat.o(114891);
            return;
          }
          l.this.Cag = true;
          l.this.CaI.Chg.Cci = 1;
          if ((!l.this.dDV) && (!l.this.Cah)) {}
          for (l.this.CaI.CfV = 1;; l.this.CaI.CfV = 0)
          {
            l.this.CaI.setInactive();
            f.Logi("MicroMsg.Voip.VoipContext", "Voip.Channel setInactive");
            l.this.ewd();
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
          f.Logi("MicroMsg.Voip.VoipContext", "need hangUP for disconnect from channel..envent = " + paramAnonymousMessage.arg2);
          if (l.this.mStatus >= 5)
          {
            l.this.CaI.Chg.CbS = 108;
            if (paramAnonymousMessage.arg2 != 5) {
              break label596;
            }
            l.this.CaI.Chg.Cck = 1;
            f.Logi("MicroMsg.Voip.VoipContext", "channel broken...");
          }
          for (;;)
          {
            l.this.J(1, -9000, "");
            AppMethodBeat.o(114891);
            return;
            l.this.CaI.Chg.CbS = 106;
            break;
            label596:
            if (paramAnonymousMessage.arg2 == 8)
            {
              if (l.this.Cak == true)
              {
                f.Logi("MicroMsg.Voip.VoipContext", "channel connect fail while pre-connect");
                l.this.Caj = true;
                AppMethodBeat.o(114891);
                return;
              }
              f.Logi("MicroMsg.Voip.VoipContext", "channel connect fail...");
              l.this.Cag = false;
              l.this.CaI.Chg.Cck = 5;
            }
          }
        }
        if (paramAnonymousMessage.arg1 == 100)
        {
          f.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.Voip.VoipContext", paramAnonymousMessage.arg2);
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 101)
        {
          f.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.v2Core", paramAnonymousMessage.arg2);
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 7)
        {
          f.Logi("MicroMsg.Voip.VoipContext", "NOTIFY_FROM_JNI_SPEEDTESTRESULT handle");
          localObject4 = (byte[])paramAnonymousMessage.obj;
          i = paramAnonymousMessage.arg2;
          paramAnonymousMessage = null;
          try
          {
            localObject1 = ay.iV(aj.getContext());
            paramAnonymousMessage = (Message)localObject1;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              f.Logi("MicroMsg.Voip.VoipContext", "Get wifiName failed in voip speedTest!");
            }
          }
          localObject1 = null;
          try
          {
            localObject3 = ((TelephonyManager)aj.getContext().getSystemService("phone")).getSimOperatorName();
            localObject1 = localObject3;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              f.Logi("MicroMsg.Voip.VoipContext", "Get netName failed in voip speedTest!");
            }
          }
          new j(l.this.Cap, l.this.Cao, l.this.Caq, (String)localObject1, paramAnonymousMessage, l.this.Car, i, (byte[])localObject4).eyg();
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
              localObject2 = (duf)new duf().parseFrom((byte[])localObject2);
              if ((!paramAnonymousMessage.CaU) || (((duf)localObject2).HGZ != 1)) {
                f.Logi("MicroMsg.Voip.VoipContext", "steve: onRecvRUDPCmd:" + ((duf)localObject2).HGZ);
              }
              i = ((duf)localObject2).HGZ;
              switch (i)
              {
              default: 
                AppMethodBeat.o(114891);
                return;
              }
            }
            catch (Exception paramAnonymousMessage)
            {
              f.Logi("MicroMsg.Voip.VoipContext", "rudp cmd processing Error");
              AppMethodBeat.o(114891);
              return;
            }
            f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client tells us to end HWEnc!!");
            paramAnonymousMessage.CaK.CbB = true;
            AppMethodBeat.o(114891);
            return;
            if (!paramAnonymousMessage.CaU)
            {
              f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client end HWEnc!!");
              paramAnonymousMessage.h(8, false, true);
              paramAnonymousMessage.a(4, false, true, true);
              if (((duf)localObject2).HHa == null) {
                break label1190;
              }
              localObject2 = ByteBuffer.wrap(((duf)localObject2).HHa.zr, 0, 4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              i = Math.min(((ByteBuffer)localObject2).getInt(), 6);
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(i);
              f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:CMD_VOIP_CloseHWEnc:reset maxsizeformat: ".concat(String.valueOf(i)));
              paramAnonymousMessage.CaI.setAppCmd(30, ((ByteBuffer)localObject2).array(), 4);
            }
            for (;;)
            {
              paramAnonymousMessage.CaU = true;
              AppMethodBeat.o(114891);
              return;
              label1190:
              f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: cmdBuffer is nil!!");
            }
            if (((duf)localObject2).HHa != null)
            {
              localObject2 = ((duf)localObject2).HHa.zr;
              f.Logi("MicroMsg.Voip.VoipContext", "steve: remote new network type:".concat(String.valueOf(localObject2)));
              i = paramAnonymousMessage.CaI.setAppCmd(302, (byte[])localObject2, 4);
              if (i < 0) {
                f.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + localObject2 + "fail:" + i + ", [roomid=" + paramAnonymousMessage.CaI.uLA + ", roomkey=" + paramAnonymousMessage.CaI.uLt + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            f.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
            AppMethodBeat.o(114891);
            return;
            byte[] arrayOfByte;
            if (((duf)localObject2).HHa != null)
            {
              localObject2 = ((duf)localObject2).HHa.zr;
              localObject2 = (dww)new dww().parseFrom((byte[])localObject2);
              f.Logi("MicroMsg.Voip.VoipContext", "zhengxue: remote audio dev occupied stat :" + ((dww)localObject2).HJM);
              arrayOfByte = new byte[4];
              arrayOfByte[0] = ((byte)((dww)localObject2).HJM);
              paramAnonymousMessage.CaI.setJNIAppCmd(2, arrayOfByte, 4);
              AppMethodBeat.o(114891);
              return;
            }
            f.Logi("MicroMsg.Voip.VoipContext", "zhengxue:[CHANNEL]EMethod_AudioDevOccupiedStatsSync empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((duf)localObject2).HHa != null)
            {
              localObject2 = ((duf)localObject2).HHa.zr;
              if (paramAnonymousMessage.CaI != null)
              {
                localObject2 = ByteBuffer.wrap((byte[])localObject2);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                i = ((ByteBuffer)localObject2).getInt();
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)3);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.CaI.setAppCmd(35, ((ByteBuffer)localObject2).array(), 6);
                f.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_DisableCodec:  ".concat(String.valueOf(i)));
              }
              AppMethodBeat.o(114891);
              return;
            }
            f.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_DisableCodec empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((duf)localObject2).HHa != null)
            {
              localObject2 = ((duf)localObject2).HHa.zr;
              if (paramAnonymousMessage.CaI != null)
              {
                localObject2 = ByteBuffer.wrap((byte[])localObject2);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                i = ((ByteBuffer)localObject2).getInt();
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)3);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.CaI.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
                f.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder:  ".concat(String.valueOf(i)));
              }
              AppMethodBeat.o(114891);
              return;
            }
            f.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((duf)localObject2).HHa != null)
            {
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(1);
              paramAnonymousMessage.CaI.setAppCmd(48, ((ByteBuffer)localObject2).array(), 4);
              f.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAq:  1");
              AppMethodBeat.o(114891);
              return;
            }
            f.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAq empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((duf)localObject2).HHa != null)
            {
              localObject2 = ((duf)localObject2).HHa.zr;
              if (paramAnonymousMessage.CaI != null)
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
                paramAnonymousMessage.CaI.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)2);
                ((ByteBuffer)localObject2).putShort((short)4);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.CaI.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
              }
              for (;;)
              {
                f.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder:  ".concat(String.valueOf(i)));
                AppMethodBeat.o(114891);
                return;
                label1920:
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)2);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.CaI.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
              }
            }
            f.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((duf)localObject2).HHa != null)
            {
              localObject2 = ((duf)localObject2).HHa.zr;
              f.Logi("MicroMsg.Voip.VoipContext", "anlin: remote wx ver: ".concat(String.valueOf(localObject2)));
              i = paramAnonymousMessage.CaI.setAppCmd(506, (byte[])localObject2, 4);
              if (i < 0) {
                f.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteClientVersion] remote wx ver: " + localObject2 + "ret: " + i + ", [roomid=" + paramAnonymousMessage.CaI.uLA + ", roomkey=" + paramAnonymousMessage.CaI.uLt + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            f.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteClientVersion] empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((duf)localObject2).HHa != null)
            {
              arrayOfByte = ((duf)localObject2).HHa.zr;
              i = ((duf)localObject2).HHa.zr.length;
              f.Logi("MicroMsg.Voip.VoipContext", "anlin: remote device model: ".concat(String.valueOf(arrayOfByte)));
              i = paramAnonymousMessage.CaI.setAppCmd(508, arrayOfByte, i);
              if (i < 0) {
                f.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteDeviceModel] remote device model: " + arrayOfByte + "ret: " + i + ", [roomid=" + paramAnonymousMessage.CaI.uLA + ", roomkey=" + paramAnonymousMessage.CaI.uLt + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            f.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteDeviceModel] empty buffer");
          }
        }
        if (paramAnonymousMessage.arg1 == 9)
        {
          paramAnonymousMessage = l.this.CaI.Chg;
          if (0L == paramAnonymousMessage.Ccw)
          {
            paramAnonymousMessage.Ccw = System.currentTimeMillis();
            f.Logi("MicroMsg.VoipDailReport", "first pkt received timestamp:" + paramAnonymousMessage.Ccw);
          }
          f.Logi("MicroMsg.Voip.VoipContext", "get first pkt for voip");
          if (1 == l.this.CaI.CgG)
          {
            paramAnonymousMessage = new dyx();
            paramAnonymousMessage.nDG = 1;
            l.this.CaL.a(paramAnonymousMessage, 2);
            AppMethodBeat.o(114891);
          }
        }
        else
        {
          if (paramAnonymousMessage.arg1 == 11)
          {
            l.this.Cba = 2;
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 12)
          {
            l.this.Cba = 1;
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 13)
          {
            localObject2 = (int[])paramAnonymousMessage.obj;
            i = paramAnonymousMessage.arg2;
            new com.tencent.mm.plugin.voip.model.a.h(l.this.CaI.roomId, l.this.CaI.uLt, l.this.CaI.uLA, 1, i, (int[])localObject2, null).eyg();
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 14)
          {
            localObject2 = (int[])paramAnonymousMessage.obj;
            i = paramAnonymousMessage.arg2;
            new com.tencent.mm.plugin.voip.model.a.h(l.this.CaI.roomId, l.this.CaI.uLt, l.this.CaI.uLA, 2, i, (int[])localObject2, null).eyg();
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 15) {
            l.this.aM(paramAnonymousMessage.arg2, false);
          }
        }
        AppMethodBeat.o(114891);
      }
    };
    this.Cbc = null;
    this.Cbd = 0;
    this.Cbe = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(177018);
        if (l.this.mStatus == 4)
        {
          f.Logi("MicroMsg.Voip.VoipContext", "connect time out.. now finish..");
          l.this.CaI.Chg.CbS = 105;
          l.this.J(1, -9000, "");
        }
        AppMethodBeat.o(177018);
        return false;
      }
    }, false);
    this.Cbf = null;
    this.CaI = new v2protocal(this.mHandler);
    this.CaK = new n(this);
    this.CaK.CbG = this.CaI.uLt;
    this.CaL = new w(this);
    this.CaT = 0;
    this.CaW = new VoipScoreState();
    AppMethodBeat.o(114899);
  }
  
  private void a(final d paramd)
  {
    AppMethodBeat.i(177020);
    if ((this.mStatus != 2) && (this.mStatus != 3) && (this.mStatus != 4))
    {
      f.Logi("MicroMsg.Voip.VoipContext", "startConnectRelay status fail, status:" + this.mStatus);
      AppMethodBeat.o(177020);
      return;
    }
    if (this.Cae)
    {
      f.Logi("MicroMsg.Voip.VoipContext", "can not startConnectRelay again");
      AppMethodBeat.o(177020);
      return;
    }
    l.c localc = new l.c(this, (byte)0);
    localc.Cbo = new l.b()
    {
      public final void aw(final int paramAnonymousInt1, final int paramAnonymousInt2, final int paramAnonymousInt3)
      {
        AppMethodBeat.i(114895);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114894);
            f.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel relay");
            int k = l.this.CaI.Cgk;
            int m = l.this.CaI.Cgk;
            v2protocal localv2protocal = l.this.CaI;
            int n = l.this.CaI.Cff;
            long l1 = l.this.CaI.roomId;
            int i1 = l.this.CaI.uLA;
            long l2 = l.this.CaI.uLt;
            byte[] arrayOfByte1 = l.this.CaI.Cfh;
            int i2 = l.this.CaI.channelStrategy;
            int i3 = l.this.CaI.Cfm;
            int i4 = l.this.CaI.Cfn;
            int i5 = l.this.CaI.Cfk;
            byte[] arrayOfByte2;
            int i6;
            int i7;
            int i8;
            byte[] arrayOfByte3;
            int i9;
            int i10;
            if (l.this.CaI.Cfl == null)
            {
              i = 0;
              arrayOfByte2 = l.this.CaI.Cfl;
              i6 = l.this.CaI.Cfo;
              i7 = l.this.CaI.Cfe;
              i8 = l.this.CaI.Cgu;
              arrayOfByte3 = l.this.CaI.Cgv;
              i9 = l.this.CaI.Cgw;
              i10 = l.this.CaI.Cfp;
              if (l.this.CaI.Cfq != null) {
                break label521;
              }
            }
            label521:
            for (int j = 0;; j = l.this.CaI.Cfq.length)
            {
              i = localv2protocal.setConfigInfo(n, l1, i1, l2, arrayOfByte1, i2, i3, i4, i5, i, arrayOfByte2, i6, (k >> 2 & 0x3) >> 1 & 0x1 & (m & 0x3) >> 1 & 0x1, i7, i8, arrayOfByte3, i9, i10, j, l.this.CaI.Cfq, l.this.CaI.Cgx, paramAnonymousInt1, paramAnonymousInt3, paramAnonymousInt2, "", "", v2protocal.eyy());
              if (i >= 0) {
                break label539;
              }
              f.Loge("MicroMsg.Voip.VoipContext", "v2protocal setConfigInfo or connectToPeerRelay failed, ret:".concat(String.valueOf(i)));
              l.this.CaI.Chg.CbS = 14;
              l.this.J(1, -9002, "");
              l.11.this.Cbh.ewo();
              AppMethodBeat.o(114894);
              return;
              i = l.this.CaI.Cfl.length;
              break;
            }
            label539:
            if (l.this.CaI.CgJ == null)
            {
              f.Loge("MicroMsg.Voip.VoipContext", "relay conns buf null");
              l.this.J(1, -9002, "");
              l.11.this.Cbh.ewo();
              AppMethodBeat.o(114894);
              return;
            }
            int i = l.this.CaI.AddNewRelayConns(l.this.CaI.CgJ, l.this.CaI.CgJ.length, 0);
            if (i < 0)
            {
              f.Loge("MicroMsg.Voip.VoipContext", "add relayconns err:".concat(String.valueOf(i)));
              l.this.J(1, -9002, "");
              l.11.this.Cbh.ewo();
              AppMethodBeat.o(114894);
              return;
            }
            l.this.Cae = true;
            l.this.CaI.Chg.CbZ = 1;
            l.this.CaI.Chg.Cch = 1;
            l.11.this.Cbh.ewo();
            AppMethodBeat.o(114894);
          }
        });
        AppMethodBeat.o(114895);
      }
    };
    com.tencent.e.h.LTJ.aR(localc);
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
  
  private void ewa()
  {
    AppMethodBeat.i(114914);
    f.Logd("MicroMsg.Voip.VoipContext", "SrvDeviceInfo.mAudioInfo.aecMode:" + ae.gcF.fWR);
    if (ae.gcF.fWt == 1) {
      this.CaI.setAppCmd(410);
    }
    byte[] arrayOfByte = new byte[2];
    Object localObject;
    byte b;
    int i;
    int j;
    int k;
    if (ae.gcF.fWR >= 0)
    {
      arrayOfByte[0] = ((byte)ae.gcF.fWR);
      this.CaI.setAppCmd(406, arrayOfByte, 1);
      localObject = com.tencent.mm.model.c.d.aDs().wz("100447");
      if (((com.tencent.mm.storage.c)localObject).isValid())
      {
        m = bt.getInt((String)((com.tencent.mm.storage.c)localObject).foF().get("SetVoipRnnNsOn"), 0);
        if (1 == m)
        {
          b = (byte)m;
          this.CaI.setAppCmd(432, new byte[] { b }, 1);
        }
      }
      m = ae.gcF.fWS;
      ad.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.nsModeNew %d", new Object[] { Integer.valueOf(m) });
      if (ae.gcF.fWS < 0) {
        break label1923;
      }
      if (m <= 0) {
        break label1904;
      }
      int n = (int)Math.floor(m / 1000.0D) % 100;
      ad.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.iflag %d", new Object[] { Integer.valueOf(n) });
      if (n > 0)
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        this.CaI.setAppCmd(408, (byte[])new byte[] { b, i, j, k }, 4);
      }
      label326:
      m = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qCJ, -1);
      ad.i("MicroMsg.Voip.VoipContext", "kerrizhang, play_fadeinfadeout_switch = %d", new Object[] { Integer.valueOf(m) });
      localObject = new byte[1];
      localObject[0] = 0;
      if (m > 0) {
        localObject[0] = ((byte)m);
      }
      this.CaI.setAppCmd(451, (byte[])localObject, 1);
      m = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDk, -1);
      ad.i("MicroMsg.Voip.VoipContext", "kerrizhang, fullbandmode = %d", new Object[] { Integer.valueOf(m) });
      n = ae.gcF.fWU;
      ad.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.voipfullbandcfg %d", new Object[] { Integer.valueOf(n) });
      if ((m > 0) && (n > 0))
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        this.CaI.setAppCmd(456, (byte[])new byte[] { b, i, j, k }, 4);
      }
      m = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qCK, -1);
      ad.i("MicroMsg.Voip.VoipContext", "kerrizhang, play_fadeinfadeout_thresh = %d", new Object[] { Integer.valueOf(m) });
      localObject[0] = 0;
      if (m > 0) {
        localObject[0] = ((byte)m);
      }
      this.CaI.setAppCmd(452, (byte[])localObject, 1);
      m = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDj, -1);
      ad.i("MicroMsg.Voip.VoipContext", "kerrizhang, voip rcnnvad_switch = %d", new Object[] { Integer.valueOf(m) });
      if (m > 0)
      {
        b = (byte)m;
        this.CaI.setAppCmd(454, new byte[] { b }, 1);
      }
      m = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDl, 0);
      ad.i("MicroMsg.Voip.VoipContext", "dennyliang, voip aec_value = %d", new Object[] { Integer.valueOf(m) });
      if (m > 0)
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        this.CaI.setAppCmd(460, new byte[] { b, i, j, k }, 4);
      }
      m = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDo, -1);
      ad.i("MicroMsg.Voip.VoipContext", "qipengfeng, x_agc_paras: %d", new Object[] { Integer.valueOf(m) });
      if (m > 0)
      {
        b = (byte)(m & 0x1);
        ad.i("MicroMsg.Voip.VoipContext", "qipengfeng, agc_switch: %d", new Object[] { Byte.valueOf(b) });
        if (b <= 0) {
          break label1948;
        }
        localObject = new byte[7];
        localObject[0] = ((byte)(m >> 1 & 0x1F));
        localObject[1] = ((byte)(m >> 6 & 0x1F));
        localObject[2] = ((byte)(m >> 11 & 0x3));
        localObject[3] = ((byte)(m >> 13 & 0x3));
        localObject[4] = ((byte)(m >> 15 & 0x1));
        localObject[5] = ((byte)(m >> 16 & 0x7));
        localObject[6] = ((byte)(m >> 19 & 0xF));
        ad.i("MicroMsg.Voip.VoipContext", "qipengfeng, agc para: %d, %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject[0]), Byte.valueOf(localObject[1]), Byte.valueOf(localObject[2]), Byte.valueOf(localObject[3]), Byte.valueOf(localObject[4]), Byte.valueOf(localObject[5]), Byte.valueOf(localObject[6]) });
        this.CaI.setAppCmd(404, (byte[])localObject, 7);
      }
      label1092:
      if (ae.gcF.fWW < 0) {
        break label1979;
      }
      localObject = new byte[7];
      if ((ae.gcF.fWX >= 0) && (ae.gcF.fWY >= 0))
      {
        localObject[0] = ((byte)ae.gcF.fWX);
        localObject[1] = ((byte)ae.gcF.fWY);
        if (ae.gcF.fWZ < 0) {
          break label1962;
        }
        localObject[2] = ((byte)ae.gcF.fWZ);
        localObject[3] = ((byte)ae.gcF.fWW);
        localObject[4] = ((byte)ae.gcF.fXa);
        localObject[5] = ((byte)ae.gcF.fXb);
        localObject[6] = ((byte)ae.gcF.fXc);
        this.CaI.setAppCmd(404, (byte[])localObject, 7);
      }
    }
    for (;;)
    {
      m = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qCI, -1);
      ad.i("MicroMsg.Voip.VoipContext", "qipengfeng, tryUpdateAudioAdaption, switch_flag_x = %d", new Object[] { Integer.valueOf(m) });
      localObject = new byte[1];
      localObject[0] = 0;
      if (m > 0) {
        localObject[0] = 1;
      }
      this.CaI.setAppCmd(450, (byte[])localObject, 1);
      if ((ae.gcF.fWu >= 0) || (ae.gcF.fWw >= 0))
      {
        arrayOfByte[0] = -1;
        arrayOfByte[1] = -1;
        if (ae.gcF.fWu >= 0) {
          arrayOfByte[0] = ((byte)ae.gcF.fWu);
        }
        if (ae.gcF.fWw >= 0) {
          arrayOfByte[1] = ((byte)ae.gcF.fWw);
        }
        this.CaI.setAppCmd(414, arrayOfByte, 2);
      }
      if ((ae.gcF.fWv >= 0) || (ae.gcF.fWx >= 0))
      {
        arrayOfByte[0] = -1;
        arrayOfByte[1] = -1;
        if (ae.gcF.fWv >= 0) {
          arrayOfByte[0] = ((byte)ae.gcF.fWv);
        }
        if (ae.gcF.fWx >= 0) {
          arrayOfByte[1] = ((byte)ae.gcF.fWx);
        }
        this.CaI.setAppCmd(415, arrayOfByte, 2);
      }
      if ((ae.gcF.fWy >= 0) || (ae.gcF.fWz >= 0))
      {
        arrayOfByte[0] = -1;
        arrayOfByte[1] = -1;
        if (ae.gcF.fWy >= 0) {
          arrayOfByte[0] = ((byte)ae.gcF.fWy);
        }
        if (ae.gcF.fWz >= 0) {
          arrayOfByte[1] = ((byte)ae.gcF.fWz);
        }
        this.CaI.setAppCmd(422, arrayOfByte, 2);
      }
      if (ae.gcF.fWA >= 0)
      {
        arrayOfByte[0] = ((byte)ae.gcF.fWA);
        this.CaI.setAppCmd(416, arrayOfByte, 1);
      }
      if (ae.gcF.fWE >= 0)
      {
        arrayOfByte[0] = ((byte)ae.gcF.fWE);
        this.CaI.setAppCmd(431, arrayOfByte, 4);
      }
      if ((ae.gcF.fWB >= 0) && ((this.CaI.Cge != 0) || (ae.gcF.fWB != 5)))
      {
        arrayOfByte[0] = ((byte)ae.gcF.fWB);
        this.CaI.setAppCmd(417, arrayOfByte, 1);
      }
      if ((ae.gcF.fWC >= 0) && ((this.CaI.Cge != 0) || (ae.gcF.fWC != 5)))
      {
        arrayOfByte[0] = ((byte)ae.gcF.fWC);
        this.CaI.setAppCmd(418, arrayOfByte, 1);
      }
      if (ae.gcF.fWD >= 0)
      {
        arrayOfByte[0] = ((byte)ae.gcF.fWD);
        this.CaI.setAppCmd(419, arrayOfByte, 1);
      }
      if ((this.CaI.Cge == 1) && ((ae.gcF.fWB == 5) || (ae.gcF.fWC == 5))) {
        this.CaI.CfI = 5;
      }
      if (1 != ae.gcF.fXq) {
        break label2019;
      }
      localObject = new byte[30];
      m = 0;
      while (m < 15)
      {
        localObject[(m * 2)] = ((byte)(ae.gcF.fXr[m] & 0xFF));
        localObject[(m * 2 + 1)] = ((byte)(ae.gcF.fXr[m] >> 8 & 0xFF));
        m += 1;
      }
      if (ae.gcF.fWR != -2) {
        break;
      }
      this.CaI.setAppCmd(407);
      break;
      label1904:
      if (m != 0) {
        break label326;
      }
      this.CaI.setAppCmd(409);
      break label326;
      label1923:
      if (ae.gcF.fWS != -2) {
        break label326;
      }
      this.CaI.setAppCmd(409);
      break label326;
      label1948:
      this.CaI.setAppCmd(405);
      break label1092;
      label1962:
      this.CaI.setAppCmd(404, (byte[])localObject, 2);
      continue;
      label1979:
      if (ae.gcF.fWW == -2) {
        this.CaI.setAppCmd(405);
      }
    }
    this.CaI.setAppCmd(420, (byte[])localObject, 30);
    label2019:
    if (ae.gcF.fXq == 0) {
      this.CaI.setAppCmd(421);
    }
    if ((ae.gcF.fXs[0] > 0) || (ae.gcF.fXs[1] > 0))
    {
      arrayOfByte[0] = 0;
      arrayOfByte[1] = 0;
      if ((ae.gcF.fXs[0] > 0) && (ae.gcF.fXs[0] < 10000)) {
        arrayOfByte[0] = ((byte)ae.gcF.fXs[0]);
      }
      if ((ae.gcF.fXs[1] > 0) && (ae.gcF.fXs[1] < 10000)) {
        arrayOfByte[1] = ((byte)ae.gcF.fXs[1]);
      }
      this.CaI.setAppCmd(423, arrayOfByte, 2);
    }
    if (ae.gcF.fXu > 0)
    {
      arrayOfByte[0] = ((byte)ae.gcF.fXu);
      this.CaI.setAppCmd(424, arrayOfByte, 1);
    }
    int m = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDp, -1);
    ad.i("MicroMsg.Voip.VoipContext", "qipengfeng, x_agcrx_para: %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)(m & 0x1);
      ad.i("MicroMsg.Voip.VoipContext", "qipengfeng, agcrx_switch: %d", new Object[] { Byte.valueOf(b) });
      if (b > 0)
      {
        arrayOfByte = new byte[4];
        arrayOfByte[0] = ((byte)(m >> 1 & 0x3));
        arrayOfByte[1] = ((byte)(m >> 3 & 0x1F));
        arrayOfByte[2] = ((byte)(m >> 8 & 0x1F));
        arrayOfByte[3] = ((byte)(m >> 13 & 0x1));
        ad.i("MicroMsg.Voip.VoipContext", "qipengfeng, agcrx paras: %d, %d, %d, %d", new Object[] { Byte.valueOf(arrayOfByte[0]), Byte.valueOf(arrayOfByte[1]), Byte.valueOf(arrayOfByte[2]), Byte.valueOf(arrayOfByte[3]) });
        this.CaI.setAppCmd(426, arrayOfByte, 4);
      }
    }
    if (ae.gcF.fXC >= 0)
    {
      b = (byte)ae.gcF.fXC;
      i = (byte)ae.gcF.fXD;
      j = (byte)ae.gcF.fXE;
      k = (byte)ae.gcF.fXF;
      this.CaI.setAppCmd(426, new byte[] { b, i, j, k }, 4);
    }
    AppMethodBeat.o(114914);
  }
  
  private static int ewh()
  {
    AppMethodBeat.i(184050);
    String str1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGM, "");
    if (!bt.isNullOrNil(str1)) {
      try
      {
        com.tencent.mm.ac.i locali = new com.tencent.mm.ac.i(str1);
        String str2 = Build.MANUFACTURER;
        int i = locali.optInt(str2, -1);
        ad.i("MicroMsg.Voip.VoipContext", "checkVoipBeautyManufactureConfig, config:%s, manufacture:%s, beautyCmd:%s", new Object[] { str1, str2, Integer.valueOf(i) });
        if (i >= 0)
        {
          AppMethodBeat.o(184050);
          return i;
        }
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Voip.VoipContext", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(184050);
    return 0;
  }
  
  private int tk(boolean paramBoolean)
  {
    AppMethodBeat.i(216364);
    f.Logi("MicroMsg.Voip.VoipContext", "EnableAq: SetAqFlag =44, aqBlur=".concat(String.valueOf(paramBoolean)));
    ByteBuffer localByteBuffer;
    if (paramBoolean)
    {
      localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putInt(1);
    }
    try
    {
      if (this.CaI != null)
      {
        duf localduf = new duf();
        localduf.HGZ = 10;
        localduf.HHa = new com.tencent.mm.bx.b(localByteBuffer.array());
        f.Logi("MicroMsg.Voip.VoipContext", "EnableAq: SetAqFlag =44, aqBlur=".concat(String.valueOf(paramBoolean)));
        this.CaI.SendRUDP(localduf.toByteArray(), localduf.toByteArray().length);
      }
      localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putInt(1);
      this.CaI.setAppCmd(44, localByteBuffer.array(), 4);
      AppMethodBeat.o(216364);
      return 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        f.Logi("MicroMsg.Voip.VoipContext", "EnableAq Error");
      }
    }
  }
  
  public final void J(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(114937);
    ewn();
    if (this.Cbf != null) {
      this.Cbf.J(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(114937);
  }
  
  public final void Ua(int paramInt)
  {
    AppMethodBeat.i(114903);
    this.CaI.Cfv = Math.abs(paramInt);
    AppMethodBeat.o(114903);
  }
  
  public final void Ub(int paramInt)
  {
    AppMethodBeat.i(114904);
    this.CaI.Cfw = Math.abs(paramInt);
    if (paramInt != 0) {
      this.CaJ.dqh();
    }
    AppMethodBeat.o(114904);
  }
  
  public final void Uc(int paramInt)
  {
    this.CaI.Cfz = paramInt;
  }
  
  public final void Ud(int paramInt)
  {
    AppMethodBeat.i(114910);
    if ((8 == paramInt) || (9 == paramInt)) {
      this.CaA = paramInt;
    }
    for (;;)
    {
      if ((1 == paramInt) || (3 == paramInt)) {
        Ue(2);
      }
      this.CaJ.TQ(paramInt);
      AppMethodBeat.o(114910);
      return;
      this.Cay = paramInt;
      this.Caw = paramInt;
    }
  }
  
  public final void Ue(int paramInt)
  {
    AppMethodBeat.i(114911);
    if ((8 == paramInt) || (9 == paramInt)) {
      this.Caz = paramInt;
    }
    for (;;)
    {
      this.CaL.Ut(paramInt);
      AppMethodBeat.o(114911);
      return;
      this.Caw = paramInt;
      this.Cax = paramInt;
    }
  }
  
  public final void Uf(int paramInt)
  {
    AppMethodBeat.i(114925);
    try
    {
      duf localduf = new duf();
      localduf.HGZ = paramInt;
      if (1 == paramInt)
      {
        f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:send maxsizeformat: !!6");
        ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer.putInt(6);
        localduf.HHa = new com.tencent.mm.bx.b(localByteBuffer.array());
        this.CaI.setAppCmd(32, localByteBuffer.array(), 4);
      }
      for (;;)
      {
        this.CaI.SendRUDP(localduf.toByteArray(), localduf.toByteArray().length);
        f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: send RUDP data to close remote HW encoding!Type:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(114925);
        return;
        localduf.HHa = null;
      }
      return;
    }
    catch (Exception localException)
    {
      f.Logi("MicroMsg.Voip.VoipContext", "onVoipSendCloseHWEncCmd Error");
      AppMethodBeat.o(114925);
    }
  }
  
  public final void Ug(int paramInt)
  {
    AppMethodBeat.i(114926);
    f.Logi("MicroMsg.Voip.VoipContext", "zhengxue: audio device occupied stat sync stat " + paramInt + " app 1");
    try
    {
      Object localObject = new byte[4];
      localObject[0] = ((byte)paramInt);
      this.CaI.setJNIAppCmd(2, (byte[])localObject, 4);
      localObject = new dww();
      ((dww)localObject).HJM = paramInt;
      ((dww)localObject).HJN = 1;
      duf localduf = new duf();
      localduf.HGZ = 4;
      localduf.HHa = new com.tencent.mm.bx.b(((dww)localObject).toByteArray(), 0, 1);
      this.CaI.SendRUDP(localduf.toByteArray(), localduf.toByteArray().length);
      AppMethodBeat.o(114926);
      return;
    }
    catch (Exception localException)
    {
      f.Logi("MicroMsg.Voip.VoipContext", "onAudioDevOccupiedStat Error");
      AppMethodBeat.o(114926);
    }
  }
  
  public final void Uh(int paramInt)
  {
    this.CaI.Cgw = paramInt;
  }
  
  public final void Ui(int paramInt)
  {
    this.CaI.Cgp = paramInt;
  }
  
  public final void Uj(int paramInt)
  {
    this.CaI.Chg.CbY = 1;
    this.CaI.channelStrategy = paramInt;
  }
  
  public final void Uk(int paramInt)
  {
    this.CaI.Cfo = paramInt;
  }
  
  public final int a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(184049);
    if (paramInt < 0)
    {
      AppMethodBeat.o(184049);
      return -1;
    }
    f.Logi("MicroMsg.Voip.VoipContext", "CloseCodec: targetCodec =" + paramInt + ", local=" + paramBoolean1 + ", remote =" + paramBoolean2 + "encTag=" + paramBoolean3);
    ByteBuffer localByteBuffer1;
    if ((paramBoolean1) && (paramBoolean3))
    {
      localByteBuffer1 = ByteBuffer.allocate(4);
      localByteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer1.putInt(paramInt);
    }
    for (;;)
    {
      duf localduf;
      try
      {
        if (this.CaI != null)
        {
          localduf = new duf();
          localduf.HGZ = 6;
          localduf.HHa = new com.tencent.mm.bx.b(localByteBuffer1.array());
          f.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(paramInt)));
          this.CaI.SendRUDP(localduf.toByteArray(), localduf.toByteArray().length);
        }
        localByteBuffer1 = ByteBuffer.allocate(6);
        localByteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer1.putShort((short)2);
        localByteBuffer1.putShort((short)paramInt);
        localByteBuffer1.putShort((short)0);
        this.CaI.setAppCmd(39, localByteBuffer1.array(), 6);
        AppMethodBeat.o(184049);
        return 1;
      }
      catch (Exception localException1)
      {
        f.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        continue;
      }
      if ((paramBoolean1) && (!paramBoolean3))
      {
        ByteBuffer localByteBuffer2 = ByteBuffer.allocate(6);
        localByteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer2.putShort((short)0);
        localByteBuffer2.putShort((short)paramInt);
        localByteBuffer2.putShort((short)0);
        this.CaI.setAppCmd(39, localByteBuffer2.array(), 6);
        int i;
        if (paramInt != 16)
        {
          i = paramInt;
          if (paramInt != 4) {}
        }
        else
        {
          i = 20;
        }
        localByteBuffer2 = ByteBuffer.allocate(4);
        localByteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer2.putInt(i);
        try
        {
          if (this.CaI == null) {
            continue;
          }
          localduf = new duf();
          localduf.HGZ = 7;
          localduf.HHa = new com.tencent.mm.bx.b(localByteBuffer2.array());
          f.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(i)));
          this.CaI.SendRUDP(localduf.toByteArray(), localduf.toByteArray().length);
        }
        catch (Exception localException2)
        {
          f.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        }
      }
      else if ((paramBoolean2) && (paramBoolean3))
      {
        f.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:disable remote target codec: ".concat(String.valueOf(paramInt)));
        ByteBuffer localByteBuffer3 = ByteBuffer.allocate(6);
        localByteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer3.putShort((short)3);
        localByteBuffer3.putShort((short)paramInt);
        localByteBuffer3.putShort((short)0);
        this.CaI.setAppCmd(39, localByteBuffer3.array(), 6);
        localByteBuffer3 = ByteBuffer.allocate(4);
        localByteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer3.putInt(paramInt);
        try
        {
          if (this.CaI != null)
          {
            localduf = new duf();
            localduf.HGZ = 7;
            localduf.HHa = new com.tencent.mm.bx.b(localByteBuffer3.array());
            f.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(paramInt)));
            this.CaI.SendRUDP(localduf.toByteArray(), localduf.toByteArray().length);
          }
        }
        catch (Exception localException3)
        {
          f.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        }
      }
    }
  }
  
  public final void a(a parama)
  {
    if (parama != null) {
      this.Cbf = parama;
    }
  }
  
  public final void a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.CaI.Cfk = paramInt1;
    this.CaI.Cfl = paramArrayOfByte1;
    this.CaI.Cgu = paramInt2;
    this.CaI.Cgv = paramArrayOfByte2;
  }
  
  public final boolean a(dxv paramdxv)
  {
    this.CaN = paramdxv;
    this.CaI.gno = this.CaN.HKm;
    this.CaI.roomId = this.CaN.GeI;
    this.CaI.uLt = this.CaN.GeJ;
    this.CaI.uLA = 1;
    this.CaI.Cff = 0;
    this.mStatus = 3;
    return true;
  }
  
  public final void aM(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(114921);
    f.Logi("MicroMsg.Voip.VoipContext", "start bindSocket " + paramInt + " ToNetwork " + this.CaX + " rebind " + paramBoolean);
    if ((this.CaX != null) && (com.tencent.mm.compatible.util.d.ly(23)))
    {
      FileDescriptor localFileDescriptor = new FileDescriptor();
      try
      {
        Field localField = FileDescriptor.class.getDeclaredField("descriptor");
        localField.setAccessible(true);
        localField.setInt(localFileDescriptor, paramInt);
        this.CaX.bindSocket(localFileDescriptor);
        if (!paramBoolean) {
          this.CaZ.add(Integer.valueOf(paramInt));
        }
        f.Logd("MicroMsg.Voip.VoipContext", "bindSocketToNetwork success: network" + this.CaX + "+socketfd" + paramInt);
        AppMethodBeat.o(114921);
        return;
      }
      catch (Exception localException)
      {
        f.Logi("MicroMsg.Voip.VoipContext", "bindSocketToNetwork Error");
      }
    }
    AppMethodBeat.o(114921);
  }
  
  public final int aX(LinkedList<cbv> paramLinkedList)
  {
    int j = 0;
    AppMethodBeat.i(114936);
    Object localObject = new LinkedList();
    int k = this.CaI.aY((LinkedList)localObject);
    int i = j;
    if (k == 0)
    {
      if ((((LinkedList)localObject).size() == 0) || (((LinkedList)localObject).size() > 2))
      {
        AppMethodBeat.o(114936);
        return 0;
      }
      if ((((cbv)((LinkedList)localObject).get(0)).GVI == 1) && (((cbv)((LinkedList)localObject).get(0)).GVK == 5))
      {
        paramLinkedList.add(((LinkedList)localObject).get(0));
        this.CaI.CfN = 1;
        AppMethodBeat.o(114936);
        return 0;
      }
      paramLinkedList.add(((LinkedList)localObject).get(0));
      this.CaI.CfM = 1;
      if (!a((ConnectivityManager)aj.getContext().getSystemService("connectivity")))
      {
        ad.i("MicroMsg.Voip.VoipContext", "mobile network not connectedorconnecting");
        AppMethodBeat.o(114936);
        return 0;
      }
      localObject = ((TelephonyManager)aj.getContext().getSystemService("phone")).getSimOperator();
      if ((localObject == null) || (((String)localObject).length() < 3))
      {
        ad.i("MicroMsg.Voip.VoipContext", "nic_op NULL");
        AppMethodBeat.o(114936);
        return 0;
      }
      cbv localcbv = new cbv();
      localcbv.GAC = "android-cellular";
      localcbv.GVI = 0;
      localcbv.GVK = 5;
      localcbv.GVJ = (((String)localObject).substring(0, 3) + ":" + ((String)localObject).substring(3, ((String)localObject).length()));
      paramLinkedList.add(localcbv);
      this.CaI.CfN = 1;
      i = j;
    }
    while (i < paramLinkedList.size())
    {
      ad.d("MicroMsg.Voip.VoipContext", "nic_name:" + ((cbv)paramLinkedList.get(i)).GAC + " nic_role:" + ((cbv)paramLinkedList.get(i)).GVI + " net_type:" + ((cbv)paramLinkedList.get(i)).GVK + " nic_isp_info:" + ((cbv)paramLinkedList.get(i)).GVJ);
      i += 1;
    }
    AppMethodBeat.o(114936);
    return k;
  }
  
  public final void bP(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114930);
    ad.i("MicroMsg.Voip.VoipContext", "updateRemotePid");
    this.CaI.Chg.CbX = 1;
    this.CaI.Chg.CbW = 1;
    this.CaI.Cfh = paramArrayOfByte;
    AppMethodBeat.o(114930);
  }
  
  public final void bQ(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    AppMethodBeat.i(114932);
    ad.i("MicroMsg.Voip.VoipContext", "updateRemoteCapInfo, isGotCapInfo: %s", new Object[] { Byte.valueOf(this.CaI.Chg.Ccb) });
    if ((this.CaI.Chg.Ccb == 1) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(114932);
      return;
    }
    this.CaI.Chg.Ccb = 1;
    this.CaI.Cfi = paramArrayOfByte;
    if (this.CaI.Cfi != null)
    {
      int i = this.CaI.exchangeCabInfo(this.CaI.Cfi, this.CaI.Cfi.length);
      if ((this.CaI.Cfi == null) || (this.CaI.Cfi.length < 36)) {
        bool = true;
      }
      this.CaV = bool;
      if (i < 0)
      {
        f.Loge("MicroMsg.Voip.VoipContext", "protocal exchangecabinfo failed ret:".concat(String.valueOf(i)));
        this.CaI.Chg.CbS = 15;
        J(1, -9003, "");
      }
    }
    AppMethodBeat.o(114932);
  }
  
  public final void bR(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114933);
    this.CaI.Cfj = paramArrayOfByte;
    ewm();
    AppMethodBeat.o(114933);
  }
  
  public final void c(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.CaI.CgB = paramInt;
    this.CaI.CgC = paramArrayOfByte1;
    this.CaI.CgD = paramArrayOfByte2;
  }
  
  public final void evQ()
  {
    int k = 0;
    AppMethodBeat.i(114901);
    if ((this.Cae == true) && (this.Can == 0))
    {
      this.Can = 1;
      if (this.CaI.field_speedTestInfoLength < 8)
      {
        f.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! bufsize=" + this.CaI.field_speedTestInfoLength);
        AppMethodBeat.o(114901);
      }
    }
    else
    {
      f.Loge("MicroMsg.Voip.VoipContext", "StartVoipSpeedTest fail for status is wrong: isChannelStartConnect=" + this.Cae + " ,mSpeedTestStatus=" + this.Can);
      AppMethodBeat.o(114901);
      return;
    }
    int i = this.CaI.Che[1];
    if (i + 2 > this.CaI.field_speedTestInfoLength)
    {
      f.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i + ", bufsize=" + this.CaI.field_speedTestInfoLength);
      AppMethodBeat.o(114901);
      return;
    }
    int j = this.CaI.Che[(i + 2 + 1)];
    if (i + 6 + j != this.CaI.field_speedTestInfoLength)
    {
      f.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i + ", C2SRttCnt=" + j + ", bufsize=" + this.CaI.field_speedTestInfoLength);
      AppMethodBeat.o(114901);
      return;
    }
    this.Cao = this.CaI.uLt;
    this.Caq = this.CaI.netType;
    this.Car = this.CaI.roomId;
    this.Cam.GeI = this.CaI.roomId;
    this.Cam.Hwq = this.CaI.Cfu;
    this.Cam.FYc = this.CaI.netType;
    dhv localdhv = this.Cam;
    if (this.Cae == true)
    {
      i = 1;
      localdhv.Hwr = i;
      localdhv = this.Cam;
      if (this.Cag != true) {
        break label482;
      }
    }
    label482:
    for (i = 1;; i = 0)
    {
      localdhv.Hws = i;
      this.Cam.Hwt = this.CaI.Che[0];
      this.Cam.Hwu = this.CaI.Che[1];
      j = 0;
      i = 2;
      while (j < this.Cam.Hwu)
      {
        this.Cam.Hwv.add(Integer.valueOf(this.CaI.Che[i]));
        j += 1;
        i += 1;
      }
      i = 0;
      break;
    }
    localdhv = this.Cam;
    int[] arrayOfInt = this.CaI.Che;
    j = i + 1;
    localdhv.Hww = arrayOfInt[i];
    localdhv = this.Cam;
    arrayOfInt = this.CaI.Che;
    i = j + 1;
    localdhv.Hwx = arrayOfInt[j];
    j = k;
    while (j < this.Cam.Hwx)
    {
      this.Cam.Hwy.add(Integer.valueOf(this.CaI.Che[i]));
      j += 1;
      i += 1;
    }
    this.Cam.Hwz = this.CaI.Che[i];
    this.Cam.HwA = this.CaI.Che[(i + 1)];
    new com.tencent.mm.plugin.voip.model.a.k(this.Cam).eyg();
    AppMethodBeat.o(114901);
  }
  
  public final void evR()
  {
    AppMethodBeat.i(114902);
    if (this.Can == 0)
    {
      AppMethodBeat.o(114902);
      return;
    }
    if (this.Can == 1)
    {
      this.Can = 0;
      this.CaI.CgO = 0L;
      AppMethodBeat.o(114902);
      return;
    }
    this.Can = 0;
    v2protocal localv2protocal = this.CaI;
    f.Logi("MicroMsg.Voip", "v2protocal StopVoipSpeedTest!");
    localv2protocal.StopSpeedTest();
    localv2protocal.CgO = 0L;
    AppMethodBeat.o(114902);
  }
  
  public final void evS()
  {
    AppMethodBeat.i(114905);
    this.CaI.Cfx = this.CaK.ewq();
    this.CaI.Cfy = this.CaK.euV();
    AppMethodBeat.o(114905);
  }
  
  public final int evT()
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
  
  public final boolean evU()
  {
    return (this.mStatus == 2) || (this.mStatus == 4);
  }
  
  public final boolean evV()
  {
    return this.mStatus == 3;
  }
  
  public final boolean evW()
  {
    AppMethodBeat.i(114908);
    ad.d("MicroMsg.Voip.VoipContext", "isWorking, status: %d", new Object[] { Integer.valueOf(this.mStatus) });
    if (this.mStatus == 1)
    {
      AppMethodBeat.o(114908);
      return false;
    }
    AppMethodBeat.o(114908);
    return true;
  }
  
  public final long evX()
  {
    return this.CaI.Cfu;
  }
  
  public final boolean evY()
  {
    if (this.Cau) {
      return false;
    }
    switch (this.Caw)
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
        } while (4 == this.Cax);
        return false;
      } while ((4 == this.Cax) || (-1 == this.Cax));
      return false;
      if ((5 == this.Cax) || (6 == this.Cax)) {
        break;
      }
    } while (7 != this.Cax);
    return false;
  }
  
  public final boolean evZ()
  {
    if (this.Cau) {
      return false;
    }
    switch (this.Caw)
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
        } while (4 == this.Cax);
        return false;
      } while ((4 == this.Cay) || (this.Cay == 0) || (-1 == this.Cay));
      return false;
      if ((5 == this.Cay) || (6 == this.Cay)) {
        break;
      }
    } while (7 != this.Cay);
    return false;
  }
  
  public final void ewb()
  {
    AppMethodBeat.i(114915);
    f.Logi("MicroMsg.Voip.VoipContext", "In networkRequestViaCellular");
    if (com.tencent.mm.compatible.util.d.ly(21))
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)aj.getContext().getSystemService("connectivity");
      Object localObject = new NetworkRequest.Builder();
      ((NetworkRequest.Builder)localObject).addTransportType(0);
      ((NetworkRequest.Builder)localObject).addCapability(12);
      localObject = ((NetworkRequest.Builder)localObject).build();
      f.Logi("MicroMsg.Voip.VoipContext", "NetworkRequest toString: " + ((NetworkRequest)localObject).toString() + " hashCode: " + ((NetworkRequest)localObject).hashCode());
      try
      {
        localConnectivityManager.requestNetwork((NetworkRequest)localObject, new ConnectivityManager.NetworkCallback()
        {
          public final void onAvailable(Network paramAnonymousNetwork)
          {
            int i = 0;
            AppMethodBeat.i(114890);
            super.onAvailable(paramAnonymousNetwork);
            Object localObject = l.this.CaI;
            ((v2protocal)localObject).CfP += 1;
            localObject = Parcel.obtain();
            paramAnonymousNetwork.writeToParcel((Parcel)localObject, 0);
            f.Logi("MicroMsg.Voip.VoipContext", "found requested network. netid: " + ((Parcel)localObject).readInt() + " toString: " + paramAnonymousNetwork.toString());
            if (com.tencent.mm.compatible.util.d.ly(28)) {
              localObject = (ConnectivityManager)aj.getContext().getSystemService("connectivity");
            }
            try
            {
              int j = ((ConnectivityManager)localObject).getMultipathPreference(paramAnonymousNetwork);
              f.Logi("MicroMsg.Voip.VoipContext", "getMultipathPreference ret ".concat(String.valueOf(j)));
              if (j == 0) {
                l.this.CaI.CfO = 3;
              }
              if (l.this.CaX != null)
              {
                l.this.CaX = paramAnonymousNetwork;
                if (l.this.CaZ == null) {
                  break label266;
                }
                while (i < l.this.CaZ.size())
                {
                  l.this.aM(((Integer)l.this.CaZ.get(i)).intValue(), true);
                  i += 1;
                }
              }
              label266:
              return;
            }
            catch (Exception paramAnonymousNetwork)
            {
              f.Logi("MicroMsg.Voip.VoipContext", "getMultipathPreference  Error");
              l.this.CaI.CfO = 2;
              try
              {
                ((ConnectivityManager)localObject).unregisterNetworkCallback(this);
                AppMethodBeat.o(114890);
                return;
              }
              catch (Exception paramAnonymousNetwork)
              {
                f.Logi("MicroMsg.Voip.VoipContext", "unregisterNetworkCallback Error");
                AppMethodBeat.o(114890);
                return;
              }
              l.this.CaX = paramAnonymousNetwork;
              l.this.CaY = this;
              f.Logi("MicroMsg.Voip.VoipContext", "networkcallback hashCode: " + l.this.CaY.hashCode());
              l.this.CaI.CfO = 1;
              AppMethodBeat.o(114890);
            }
          }
        });
        AppMethodBeat.o(114915);
        return;
      }
      catch (Exception localException)
      {
        f.Logi("MicroMsg.Voip.VoipContext", "missing the appropriate permissions");
        this.CaI.CfO = 2;
        AppMethodBeat.o(114915);
        return;
      }
    }
    AppMethodBeat.o(114915);
  }
  
  public final void ewc()
  {
    AppMethodBeat.i(114916);
    f.Logi("MicroMsg.Voip.VoipContext", "try to UnregisterCellularNetwork");
    ConnectivityManager localConnectivityManager;
    if (com.tencent.mm.compatible.util.d.ly(21))
    {
      localConnectivityManager = (ConnectivityManager)aj.getContext().getSystemService("connectivity");
      if (this.CaY != null) {
        f.Logi("MicroMsg.Voip.VoipContext", "unregister networkcallback hashCode: " + this.CaY.hashCode());
      }
    }
    try
    {
      localConnectivityManager.unregisterNetworkCallback(this.CaY);
      this.CaY = null;
      this.CaX = null;
      AppMethodBeat.o(114916);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        f.Logi("MicroMsg.Voip.VoipContext", "unregisterNetworkCallback Error");
      }
    }
  }
  
  public final void ewd()
  {
    AppMethodBeat.i(114917);
    f.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: try start talk");
    if ((this.Cai != true) || (this.Cag != true))
    {
      f.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: fail isCanSendData " + this.Cai + ", isChannelConnectedSuccess " + this.Cag);
      AppMethodBeat.o(114917);
      return;
    }
    f.Logi("MicroMsg.Voip.VoipContext", "Voip tryStartTalk, channel setActive");
    this.CaI.setActive();
    if (this.Cal == true)
    {
      f.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: engine already started, isEngineStarted " + this.Cal);
      AppMethodBeat.o(114917);
      return;
    }
    this.CaI.setSvrConfig(205, 0, 0, this.CaI.Cgx, 0, 0, 0, 0, null);
    this.CaI.setSvrConfig(207, 0, 0, this.CaI.Cfp, 0, 0, 0, 0, null);
    f.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.CaI.Cgx + " SwitchFlag = " + this.CaI.Cfp);
    this.CaI.Cfs[0] = ((byte)ae.gcP.fZw);
    this.CaI.Cfs[1] = ((byte)ae.gcP.fZx);
    this.CaI.Cfs[2] = ((byte)ae.gcP.fZy);
    this.CaI.Cfs[3] = ((byte)ae.gcP.fZz);
    this.CaI.Cfs[4] = ((byte)ae.gcP.fZA);
    this.CaI.Cfs[5] = ((byte)ae.gcP.fZB);
    this.CaI.Cfs[6] = ((byte)ae.gcP.fZC);
    this.CaI.Cfs[7] = ((byte)ae.gcP.fZD);
    this.CaI.Cfs[8] = ((byte)ae.gcP.fZE);
    this.CaI.Cfs[9] = ((byte)ae.gcP.fZF);
    this.CaI.setSvrConfig(209, 0, 0, 0, 0, 0, 0, this.CaI.Cfs.length, this.CaI.Cfs);
    if (this.CaI.startEngine() == 0) {
      this.CaI.Chg.Ccs = 0;
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
      if (this.CaI.Cfr != null) {
        if (this.CaI.Cfr.length < 1024)
        {
          this.CaI.setSvrConfig(208, 0, 0, 0, 0, 0, 0, this.CaI.Cfr.length, this.CaI.Cfr);
          ewa();
          if ((evY()) || (evZ())) {
            break label2825;
          }
          ewg();
          this.CaJ.evx();
          localObject1 = this.CaK;
          if (((n)localObject1).oWj != 2) {
            break label2883;
          }
          f.Loge("MicroMsg.Voip.VoipDeviceHandler", "dev start already...");
          localObject1 = this.CaI.Chg;
          if (((o)localObject1).beginTime != 0L) {
            break label3445;
          }
          ((o)localObject1).Ccl = 0;
          f.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + ((o)localObject1).beginTime + ", CurrentTime: " + System.currentTimeMillis());
          f.Logi("MicroMsg.VoipDailReport", "devin:endNewDial:" + ((o)localObject1).Ccl);
          this.CaJ.onConnected();
          this.mStatus = 5;
          localObject1 = this.CaI.Chg;
          ((o)localObject1).Cct = System.currentTimeMillis();
          f.Logi("MicroMsg.VoipDailReport", "devin:beginTalk:" + ((o)localObject1).Cct);
          this.CaI.setSvrConfig(202, this.CaI.CfW, this.CaI.CfX, 0, 0, 0, 0, 0, null);
          this.CaI.setSvrConfig(203, 0, 0, this.CaI.Cgb, 0, 0, 0, 0, null);
          this.CaI.setSvrConfig(206, 0, 0, this.CaI.Cgf, 0, 0, 0, 0, null);
          this.CaI.setSvrConfig(103, this.CaI.CfY, this.CaI.CfZ, this.CaI.Cga, this.CaI.Cgd, 0, 0, 0, null);
          this.CaI.setSvrConfig(205, 0, 0, this.CaI.Cgx, 0, 0, 0, 0, null);
          this.CaI.setSvrConfig(207, 0, 0, this.CaI.Cfp, 0, 0, 0, 0, null);
          f.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.CaI.Cgx + " SwitchFlag = " + this.CaI.Cfp);
          j = this.CaI.Cgk >> 2 & 0x3;
          k = this.CaI.Cgk & 0x3;
          if (this.CaI.uLA != 0) {
            break label3463;
          }
          j = (j << 2) + k;
          this.CaI.setSvrConfig(502, 0, 0, j, 0, 0, 0, 0, null);
          this.CaI.setSvrConfig(503, 0, 0, this.CaI.Cgl, this.CaI.Cgm, this.CaI.Cgn, this.CaI.Cgo, 0, null);
          if ((this.CaI.CgC != null) && (this.CaI.CgD != null))
          {
            this.CaI.setSvrConfig(504, 0, 0, this.CaI.CgB, 0, 0, 0, 0, null);
            this.CaI.setSvrConfig(505, 0, 0, this.CaI.CgC[0], this.CaI.CgC[1], this.CaI.CgC[2], this.CaI.CgC[3], 0, null);
            this.CaI.setSvrConfig(506, 0, 0, this.CaI.CgD[0], this.CaI.CgD[1], 0, 0, 0, null);
            f.Logi("MicroMsg.Voip.VoipContext", "FECSvrCtr = " + this.CaI.CgB + ",FECKeyPara1 = " + this.CaI.CgC[0] + "," + this.CaI.CgC[1] + "," + this.CaI.CgC[2] + "," + this.CaI.CgC[3] + ",FECKeyPara2 = " + this.CaI.CgD[0] + "," + this.CaI.CgD[1]);
          }
          k = this.CaI.Cgp;
          m = this.CaI.Cgp;
          n = this.CaI.Cgp;
          this.CaI.setSvrConfig(507, 0, 0, (k & 0x4) >> 2, (m & 0x2) >> 1, n & 0x1, 0, 0, null);
          this.CaI.setjbmbitraterssvrparam();
          f.Logi("MicroMsg.Voip.VoipContext", "zhengxue[Logic] setSvrConfig brefore onStartTalk: audioTsdfBeyond3G = " + this.CaI.CfW + ",audioTsdEdge = " + this.CaI.CfX + ",passthroughQosAlgorithm = " + this.CaI.CfY + ",fastPlayRepair = " + this.CaI.CfZ + ", audioDTX = " + this.CaI.Cgb + ", mARQFlag = " + j + ", mQosStrategy = " + this.CaI.Cgp + ", mSvrCfgListV = " + this.CaI.Cga + ", maxBRForRelay = " + this.CaI.Cgd);
          localObject1 = new byte[2];
          localObject1[0] = ((byte)ae.gcE.fYE);
          localObject1[1] = -1;
          f.Logd("MicroMsg.Voip.VoipContext", "steve: Model Name: " + Build.MODEL);
          f.Logd("MicroMsg.Voip.VoipContext", "steve: Image Enhancement for Android Capture!!, mode: " + localObject1[0]);
          this.CaI.setAppCmd(15, (byte[])localObject1, 1);
          f.Logd("MicroMsg.Voip.VoipContext", "anlin: ClientVersion: " + com.tencent.mm.protocal.d.Fnj);
          localObject1 = ByteBuffer.allocate(4);
          ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN).putInt(com.tencent.mm.protocal.d.Fnj);
          localObject1 = ((ByteBuffer)localObject1).array();
          this.CaI.setAppCmd(505, (byte[])localObject1, 4);
        }
      }
      label3463:
      try
      {
        if (this.CaI != null)
        {
          ??? = new duf();
          ((duf)???).HGZ = 8;
          ((duf)???).HHa = new com.tencent.mm.bx.b((byte[])localObject1);
          f.Logi("MicroMsg.Voip.VoipContext", "anlin send local client version: ".concat(String.valueOf(localObject1)));
          this.CaI.SendRUDP(((duf)???).toByteArray(), ((duf)???).toByteArray().length);
        }
        localObject1 = Build.MODEL;
        j = ((String)localObject1).length();
        localObject1 = ((String)localObject1).getBytes();
        f.Logi("MicroMsg.Voip.VoipContext", "anlin DeviceModel: ".concat(String.valueOf(localObject1)));
        this.CaI.setAppCmd(507, (byte[])localObject1, j);
      }
      catch (Exception localException1)
      {
        label2825:
        label3506:
        label3639:
        try
        {
          if (this.CaI != null)
          {
            ??? = new duf();
            ((duf)???).HGZ = 9;
            ((duf)???).HHa = new com.tencent.mm.bx.b((byte[])localObject1);
            f.Logi("MicroMsg.Voip.VoipContext", "anlin send local device model: ".concat(String.valueOf(localObject1)));
            this.CaI.SendRUDP(((duf)???).toByteArray(), ((duf)???).toByteArray().length);
          }
          if ((this.CaI.Cfp >> 17 & 0x1) != 0)
          {
            bool1 = true;
            if ((this.CaI.Cfp >> 18 & 0x1) == 0) {
              break label3506;
            }
            bool2 = true;
            tk(bool1);
            f.Logi("MicroMsg.Voip.VoipContext", "EnableBlur: SetBlurFlag =47, aqBlur=".concat(String.valueOf(bool2)));
            if (bool2)
            {
              localObject1 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject1).putInt(1);
              this.CaI.setAppCmd(47, ((ByteBuffer)localObject1).array(), 4);
            }
            if ((this.CaI.Cfp & 0x2) == 0)
            {
              h(16, true, true);
              h(4, true, true);
            }
            j = this.CaI.Cfp >> 12 & 0x1;
            localObject1 = ByteBuffer.allocate(4);
            ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
            ((ByteBuffer)localObject1).putInt(j);
            f.Logi("MicroMsg.Voip.VoipContext", "weiranli set MixVcodec1 from svr = ".concat(String.valueOf(j)));
            this.CaI.setAppCmd(46, ((ByteBuffer)localObject1).array(), 4);
            if ((this.CaI.Cfp & 0x200) == 0)
            {
              localObject1 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject1).putInt(8);
              f.Logi("MicroMsg.Voip.VoipContext", "jcchen Disable 720p from svr: mSwitchFlag = " + this.CaI.Cfp);
              this.CaI.setAppCmd(32, ((ByteBuffer)localObject1).array(), 4);
              this.CaI.setAppCmd(30, ((ByteBuffer)localObject1).array(), 4);
            }
            if ((this.CaI.Cfp & 0x100000) != 1) {
              break label3512;
            }
            f.Logi("MicroMsg.Voip.VoipContext", "setAppCmd: EMethodSetP2SSendThreadEnable enble, mSwitchFlag: " + this.CaI.Cfp);
            this.CaI.setAppCmd(52);
            if (ac.iPC == 0) {
              break label3544;
            }
            localObject1 = ByteBuffer.allocate(4);
            ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
            ((ByteBuffer)localObject1).putInt(ac.iPC);
            this.CaI.setAppCmd(36, ((ByteBuffer)localObject1).array(), 4);
            localObject1 = new byte[4];
            this.CaI.setAppCmd(26, (byte[])localObject1, 4);
            localObject1 = ByteBuffer.wrap((byte[])localObject1);
            ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
            m = ((ByteBuffer)localObject1).getInt();
            f.Logd("MicroMsg.Voip.VoipContext", "steve: iHW: ".concat(String.valueOf(m)));
            if (((this.CaI.Cga & 0x4) == 0) && (ae.gcE.fYG <= 0)) {
              break label3639;
            }
            j = 1;
            if ((j == 0) && (this.CaI.oYd))
            {
              f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:Server Disable HW enc/dec!!");
              if ((m & 0x4) == 0) {
                break label3644;
              }
              j = 1;
              if ((m & 0x8) == 0) {
                break label3649;
              }
              k = 1;
              if ((j != 0) || (k != 0))
              {
                this.CaK.CbB = true;
                tj(false);
              }
              this.CaI.oYd = false;
            }
            if (this.CaI.oYd)
            {
              ??? = this.CaI;
              n = ae.gcE.fYG;
              bool1 = false;
              if ((m & 0x4) == 0) {
                break label3654;
              }
              j = 1;
              if ((m & 0x8) == 0) {
                break label3659;
              }
              k = 1;
              if ((j != 0) || (k != 0))
              {
                if (j == 0) {
                  break label3664;
                }
                localObject1 = "video/hevc";
                ((v2protocal)???).Chj = new e(((v2protocal)???).width, ((v2protocal)???).height, ((v2protocal)???).Chl, ((v2protocal)???).bitrate, n, (String)localObject1);
                f.Logi("MicroMsg.Voip", "steve : create HW encoder successfully:".concat(String.valueOf(localObject1)));
                if (v2protocal.Chm != null)
                {
                  v2protocal.Chk = new d(v2protocal.Chm);
                  f.Logi("MicroMsg.Voip", "steve : create HW decoder successfully!");
                }
                bool1 = true;
                if ((((v2protocal)???).Chj == null) || (v2protocal.Chk == null))
                {
                  ((v2protocal)???).oYd = false;
                  bool1 = false;
                }
              }
              f.Logi("MicroMsg.Voip.VoipContext", "steve: HW encoder/decoder init ret: " + bool1 + ", iHW:" + m);
              if (!this.CaI.oYd)
              {
                f.Logi("MicroMsg.Voip.VoipContext", "steve: HW dec/enc NOT supported for both sides,end HWEnc!!");
                this.CaK.CbB = true;
                tj(false);
                a(8, true, false, true);
                a(8, true, false, false);
              }
            }
            if (this.CaI.Chj != null) {
              this.CaI.Chj.BXC = this;
            }
            if (v2protocal.Chk != null) {
              v2protocal.Chk.a(this);
            }
            this.Cal = true;
            this.CaU = false;
            localObject1 = this.CaW;
            ((VoipScoreState)localObject1).uMO = bj.aCb();
            ad.i("MicroMsg.VoipScoreState", "markStartTalk, startTalkTime:%s", new Object[] { Long.valueOf(((VoipScoreState)localObject1).uMO) });
            ewe();
            ewf();
            AppMethodBeat.o(114917);
            return;
            this.Cal = false;
            this.CaI.Chg.Ccs = 1;
            continue;
            f.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: length of generalStrategyBuf = " + this.CaI.Cfr.length);
            break label503;
            f.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: protocol has null generalStrategyBuf");
            break label503;
            if (this.Cbc != null)
            {
              ewg();
              break label525;
            }
            this.Cbc = new Timer();
            this.Cbd = 0;
            localObject1 = new TimerTask()
            {
              public final void run()
              {
                AppMethodBeat.i(114893);
                l locall = l.this;
                locall.Cbd += 1;
                if ((l.this.CaI.CgU != 0) || (l.this.Cbd > 10))
                {
                  l.this.ewg();
                  if (l.this.Cbc != null)
                  {
                    l.this.Cbc.cancel();
                    l.this.Cbc = null;
                  }
                  AppMethodBeat.o(114893);
                  return;
                }
                AppMethodBeat.o(114893);
              }
            };
            this.Cbc.schedule((TimerTask)localObject1, 200L, 200L);
            break label525;
            label2883:
            f.Logi("MicroMsg.Voip.VoipDeviceHandler", "start device......");
            ((n)localObject1).oWj = 2;
            ((n)localObject1).CbB = false;
            ((n)localObject1).CbC = 0;
            if (((n)localObject1).CbF != null)
            {
              ad.i("MicroMsg.Voip.VoipDeviceHandler", "mDevHandlerThread is not null");
              if (!((n)localObject1).CbF.isQuit()) {
                ad.i("MicroMsg.Voip.VoipDeviceHandler", "mDevHandlerThread is alive");
              }
            }
            ((n)localObject1).CbF.removeCallbacksAndMessages(null);
            if (((n)localObject1).CbK != null)
            {
              f.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
              ((n)localObject1).CbK.CbO = true;
              ((n)localObject1).CbK.cancel();
              ((n)localObject1).CbK = null;
            }
            ((n)localObject1).CbK = new n.a((n)localObject1);
            com.tencent.mm.sdk.g.b.c(((n)localObject1).CbK, "VoipDeviceHandler_decode");
            f.Logd("MicroMsg.Voip.VoipDeviceHandler", "start video decode thread..");
            ae.gcF.dump();
            for (;;)
            {
              synchronized (((n)localObject1).Cbz)
              {
                while (((n)localObject1).oWj == n.oWi)
                {
                  ad.e("MicroMsg.Voip.VoipDeviceHandler", "current is not allowed to start dev");
                  synchronized (((n)localObject1).Cbz)
                  {
                    ((n)localObject1).CbF.post(new n.2((n)localObject1));
                  }
                }
                localn.Cbr = new c();
                localn.Cbr.BXP = String.valueOf(localn.CbG);
                a locala = new a();
                j = localn.BXC.CaI.a(locala);
                f.Logi("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.GetAudioDeviceFmt, play samplerate:" + locala.xbF + ", framelen: " + locala.BXy + ", ret:" + j);
                localn.Cbr.M(locala.xbF, locala.channels, locala.BXy, 0);
                localn.oWk = localn.Cbr.C(localn.BXC.nhZ, true);
                localn.BXC.CaI.CfK = localn.Cbr.iwU;
                if (localn.Cbr.BXB == true)
                {
                  j = 1;
                  int i = (byte)j;
                  localn.BXC.CaI.setAppCmd(502, new byte[] { i }, 1);
                  if (localn.oWk <= 10)
                  {
                    if (localn.oWk <= 0) {
                      localn.oWn = 1;
                    }
                    localn.oWk = 92;
                  }
                  if ((!com.tencent.mm.plugin.audio.c.a.bGx()) && (!com.tencent.mm.plugin.audio.c.a.bGD())) {
                    break label3435;
                  }
                  com.tencent.mm.plugin.voip.c.euM().oJ(true);
                  localn.Cbr.BXL = new n.3(localn);
                  if (localn.Cbr.euS() <= 0) {
                    localn.oWn = 1;
                  }
                }
              }
              j = 0;
              continue;
              label3435:
              com.tencent.mm.plugin.voip.c.euM().oJ(false);
            }
            label3445:
            localObject2.Ccl = ((int)(System.currentTimeMillis() - localObject2.beginTime));
            break label583;
            j = (k << 2) + j;
            break label963;
            localException1 = localException1;
            f.Logi("MicroMsg.Voip.VoipContext", "anlin send local client version Error!");
          }
        }
        catch (Exception localException2)
        {
          label3512:
          label3644:
          label3649:
          label3654:
          label3659:
          label3664:
          for (;;)
          {
            f.Logi("MicroMsg.Voip.VoipContext", "anlin send local device model Error!");
            continue;
            boolean bool1 = false;
            continue;
            boolean bool2 = false;
            continue;
            f.Logi("MicroMsg.Voip.VoipContext", "setAppCmd: EMethodSetP2SSendThreadEnable disable, mSwitchFlag: " + this.CaI.Cfp);
            continue;
            label3544:
            if (ac.iPD != 0)
            {
              if ((ac.iPD & 0x2) != 0) {
                h(2, true, false);
              }
              if ((ac.iPD & 0x20) != 0) {
                h(32, true, false);
              }
              if ((ac.iPD & 0x10) != 0) {
                h(16, true, false);
              }
              if ((ac.iPD & 0x4) != 0) {
                h(4, true, false);
              }
              if ((ac.iPD & 0x8) != 0)
              {
                h(8, true, false);
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
  
  public final boolean ewe()
  {
    AppMethodBeat.i(114922);
    boolean bool = evY();
    int i = 0;
    if (bool) {
      i = 1;
    }
    f.Logd("MicroMsg.Voip.VoipContext", "needVideoOut ret: " + bool + "videoStatus: " + i + ", sendVideoStatus: " + this.CaG);
    if ((this.CaG == -1) || (this.CaG != i))
    {
      if (!bool) {
        break label158;
      }
      f.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video Out.......!");
    }
    for (int j = this.CaI.setAppCmd(203);; j = this.CaI.setAppCmd(202))
    {
      if (j == 0)
      {
        this.CaG = i;
        f.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: succeed, ret: " + j + "sendVideoStatus: " + this.CaG);
      }
      AppMethodBeat.o(114922);
      return bool;
      label158:
      f.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video Out.......!");
    }
  }
  
  public final boolean ewf()
  {
    AppMethodBeat.i(114923);
    boolean bool = evZ();
    int i = 0;
    if (bool) {
      i = 1;
    }
    f.Logd("MicroMsg.Voip.VoipContext", "needVideoIn ret: " + bool + "videoStatus: " + i + ", recvVideoStatus: " + this.CaH);
    if ((this.CaH == -1) || (this.CaH != i))
    {
      if (!bool) {
        break label158;
      }
      f.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video In.......!");
    }
    for (int j = this.CaI.setAppCmd(201);; j = this.CaI.setAppCmd(200))
    {
      if (j == 0)
      {
        this.CaH = i;
        f.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: succeed, ret: " + j + "recvVideoStatus: " + this.CaH);
      }
      AppMethodBeat.o(114923);
      return bool;
      label158:
      f.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video In.......!");
    }
  }
  
  final void ewg()
  {
    AppMethodBeat.i(114924);
    if (this.mStatus == 5)
    {
      setStatus(6);
      this.CaI.Chg.ewu();
      f.Logi("MicroMsg.Voip.VoipContext", "talking  now .......!");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114892);
          l.this.CaJ.evv();
          AppMethodBeat.o(114892);
        }
      });
    }
    AppMethodBeat.o(114924);
  }
  
  public final void ewi()
  {
    AppMethodBeat.i(184051);
    int i = m.aaf();
    boolean bool1;
    int j;
    int k;
    int m;
    boolean bool2;
    label84:
    boolean bool3;
    label111:
    boolean bool4;
    label138:
    boolean bool5;
    label168:
    label337:
    int n;
    if ((i & 0x400) != 0)
    {
      bool1 = true;
      j = i >> 12 & 0xF;
      k = i & 0xFF;
      m = Build.VERSION.SDK_INT;
      long l = com.tencent.matrix.g.a.getTotalMemory(aj.getContext()) / 1024L / 1024L;
      if (j < ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGI, 4)) {
        break label585;
      }
      bool2 = true;
      if (k < ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGJ, 45)) {
        break label591;
      }
      bool3 = true;
      if (m < ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGK, 23)) {
        break label597;
      }
      bool4 = true;
      if (l < ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGL, 4096)) {
        break label603;
      }
      bool5 = true;
      double d = com.tencent.matrix.g.a.Jp();
      Debug.MemoryInfo localMemoryInfo = com.tencent.matrix.g.a.aT(aj.getContext());
      ad.i("MicroMsg.Voip.VoipContext", "checkVoipBeautyLocalConfig, cpuFlags:%s, isNeon:%s, nCores:%s, nFreq:%s, sdkInt:%s, totalMemMB:%s, coreNumCheck:%s, freqCheck:%s, sdkIntCheck:%s, totalMemMBCheck:%s, cpuRate:%s, dalvikPss:%s, nativePss:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Double.valueOf(d), Integer.valueOf(localMemoryInfo.dalvikPss), Integer.valueOf(localMemoryInfo.nativePss) });
      if ((!bool1) || (!bool2) || (!bool3) || (!bool4) || (!bool5)) {
        break label609;
      }
      bool2 = true;
      m = ae.gcE.fYJ;
      n = ae.gcE.fYK;
      i = this.CaI.Cfp;
      k = (this.CaI.Cfp >> 11 & 0x1) << 3 | i >> 4 & 0x7;
      j = 0;
      bool3 = false;
      if (bool2) {
        j = ewh();
      }
      if ((n < 0) && (m < 0)) {
        break label636;
      }
      if (m < 0) {
        break label615;
      }
      bool1 = true;
      i = m;
    }
    for (;;)
    {
      ad.m("MicroMsg.Voip.VoipContext", "setVoipBeautyConfig local:%s, server:%s , blacklist:%s, whitelist:%s, voipBeautyFlag:%s, uiCallback:%s and isHitBlackListOrWhitList:%s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), this.CaJ, Boolean.valueOf(bool1) });
      m = i;
      j = k;
      if (!bool1)
      {
        m = i;
        j = k;
        if (i == 0)
        {
          m = i;
          j = k;
          if (com.tencent.mm.plugin.voip.b.h.ezJ())
          {
            m = com.tencent.mm.plugin.voip.b.h.ezI();
            j = com.tencent.mm.plugin.voip.b.h.ezI();
          }
        }
      }
      if (this.CaJ != null) {
        this.CaJ.setVoipBeauty(m);
      }
      this.CaI.CgH = m;
      this.CaI.CgI = j;
      AppMethodBeat.o(184051);
      return;
      bool1 = false;
      break;
      label585:
      bool2 = false;
      break label84;
      label591:
      bool3 = false;
      break label111;
      label597:
      bool4 = false;
      break label138;
      label603:
      bool5 = false;
      break label168;
      label609:
      bool2 = false;
      break label337;
      label615:
      bool1 = bool3;
      i = j;
      if (k == 0)
      {
        bool1 = true;
        i = n;
        continue;
        label636:
        bool1 = bool3;
        i = j;
        if (bool2)
        {
          bool1 = bool3;
          i = j;
          if (k > 0)
          {
            i = k;
            bool1 = bool3;
          }
        }
      }
    }
  }
  
  public final void ewj()
  {
    AppMethodBeat.i(177021);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114896);
        if ((l.this.mStatus != 4) && (l.this.mStatus != 5) && (l.this.mStatus != 6))
        {
          f.Logi("MicroMsg.Voip.VoipContext", "startConnectDirect status fail, status:" + l.this.mStatus);
          AppMethodBeat.o(114896);
          return;
        }
        if (l.this.Caf)
        {
          f.Logi("MicroMsg.Voip.VoipContext", "can not startConnectDirect again");
          AppMethodBeat.o(114896);
          return;
        }
        l.this.Caf = true;
        f.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel direct");
        if (l.this.CaI.CgK == null)
        {
          f.Loge("MicroMsg.Voip.VoipContext", "direct conns buf null");
          AppMethodBeat.o(114896);
          return;
        }
        int i = l.this.CaI.AddNewDirectConns(l.this.CaI.CgK, l.this.CaI.CgK.length, 0);
        if (i < 0)
        {
          f.Loge("MicroMsg.Voip.VoipContext", "v2protocal connectToPeerDirect failed, ret:".concat(String.valueOf(i)));
          AppMethodBeat.o(114896);
          return;
        }
        l.this.ewm();
        AppMethodBeat.o(114896);
      }
    });
    AppMethodBeat.o(177021);
  }
  
  public final void ewk()
  {
    AppMethodBeat.i(177022);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114897);
        f.Logi("MicroMsg.Voip.VoipContext", "v2protocal QueryNicWanIp");
        if ((l.this.CaX != null) && (l.this.CaI.CgL != null))
        {
          int i = l.this.CaI.QueryNicWanIp(l.this.CaI.CgL, l.this.CaI.CgL.length);
          if (i != 0) {
            f.Loge("MicroMsg.Voip.VoipContext", "query nic wan ip fail ret:".concat(String.valueOf(i)));
          }
        }
        else
        {
          l.this.ewc();
          AppMethodBeat.o(114897);
          return;
        }
        AppMethodBeat.o(114897);
      }
    });
    AppMethodBeat.o(177022);
  }
  
  public final void ewl()
  {
    AppMethodBeat.i(114928);
    if (!bt.cC(this.CaI.Cfh)) {}
    for (boolean bool = true;; bool = false)
    {
      f.Logi("MicroMsg.Voip.VoipContext", "channel:try start connect, hasRemotePid:" + bool + ",mStatus:" + this.mStatus + ",isPreConnect:" + this.Cak + ",isRemoteAccepted:" + this.Cah + ",isLocalAccept:" + this.dDV);
      this.CaI.Chg.Cce = 7;
      if ((!bool) || ((this.mStatus != 4) && (this.mStatus != 5) && (this.mStatus != 6) && ((this.mStatus != 2) || (this.Cak != true)) && ((this.mStatus != 3) || (this.Cak != true)))) {
        break label329;
      }
      if ((this.mStatus == 2) || (this.mStatus == 3) || (this.mStatus == 4) || (this.mStatus == 5) || (this.mStatus == 6)) {
        break;
      }
      f.Logi("MicroMsg.Voip.VoipContext", "startConnect status fail, status:" + this.mStatus);
      AppMethodBeat.o(114928);
      return;
    }
    if ((!this.Cah) && (!this.dDV))
    {
      if ((this.Cak) && (!this.Cae))
      {
        a(new d()
        {
          public final void ewo()
          {
            AppMethodBeat.i(177016);
            ad.i("MicroMsg.Voip.VoipContext", "onStartConnectRelay ok");
            AppMethodBeat.o(177016);
          }
        });
        AppMethodBeat.o(114928);
      }
    }
    else
    {
      if (!this.Cae)
      {
        a(new d()
        {
          public final void ewo()
          {
            AppMethodBeat.i(177017);
            ad.i("MicroMsg.Voip.VoipContext", "onStartConnectRelay ok");
            l.this.ewj();
            l.this.ewk();
            AppMethodBeat.o(177017);
          }
        });
        AppMethodBeat.o(114928);
        return;
      }
      ewj();
      ewk();
    }
    label329:
    AppMethodBeat.o(114928);
  }
  
  public final void ewm()
  {
    AppMethodBeat.i(114929);
    if ((this.Caf) && (!bt.cC(this.CaI.Cfj)))
    {
      int i = this.CaI.handleCommand(this.CaI.Cfj, this.CaI.Cfj.length);
      if (i < 0) {
        f.Loge("MicroMsg.Voip.VoipContext", "v2protocal handlecommand failed ret:".concat(String.valueOf(i)));
      }
      this.CaI.Cfj = null;
    }
    AppMethodBeat.o(114929);
  }
  
  public final void ewn()
  {
    AppMethodBeat.i(114934);
    ad.i("MicroMsg.Voip.VoipContext", "stop repeat voip sync");
    this.Cbb.stopTimer();
    AppMethodBeat.o(114934);
  }
  
  public final int h(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(114919);
    if (paramInt < 0)
    {
      AppMethodBeat.o(114919);
      return -1;
    }
    f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:DisableCodec: targetCodec = " + paramInt + ", local=" + paramBoolean1 + ", remote =" + paramBoolean2);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.putInt(paramInt);
    if (paramBoolean1) {}
    try
    {
      if (this.CaI != null)
      {
        duf localduf = new duf();
        localduf.HGZ = 5;
        localduf.HHa = new com.tencent.mm.bx.b(localByteBuffer.array());
        f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable local target codec: ".concat(String.valueOf(paramInt)));
        this.CaI.SendRUDP(localduf.toByteArray(), localduf.toByteArray().length);
      }
      if (paramBoolean2)
      {
        f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable remote target codec: ".concat(String.valueOf(paramInt)));
        localByteBuffer = ByteBuffer.allocate(6);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer.putShort((short)3);
        localByteBuffer.putShort((short)paramInt);
        localByteBuffer.putShort((short)0);
        this.CaI.setAppCmd(35, localByteBuffer.array(), 6);
      }
      AppMethodBeat.o(114919);
      return 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        f.Logi("MicroMsg.Voip.VoipContext", "DisableCodec Error");
      }
    }
  }
  
  public final void j(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.CaI.Cgk = paramInt1;
    this.CaI.Cgl = paramInt2;
    this.CaI.Cgm = paramInt3;
    this.CaI.Cgn = paramInt4;
    this.CaI.Cgo = paramInt5;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(114900);
    ad.i("MicroMsg.Voip.VoipContext", "reset");
    if (this.CaI.eyx()) {
      this.CaI.tq(false);
    }
    this.CaI.reset();
    this.Caw = -1;
    this.Cax = -1;
    this.Cay = -1;
    this.Caz = -1;
    this.CaA = -1;
    this.CaK.ewr();
    this.CaI.CfB = 0;
    this.Cbe.stopTimer();
    this.CaL.eyc();
    this.Cbb.stopTimer();
    this.Cae = false;
    this.Cag = false;
    this.Caf = false;
    this.Cah = false;
    this.dDV = false;
    this.Cai = false;
    this.CaM = null;
    this.CaN = null;
    this.Cas = false;
    this.Cat = false;
    this.Cau = false;
    this.CaB = false;
    this.CaC = false;
    this.CaE = false;
    this.CaD = 1;
    this.CaF = 1;
    this.CaO = false;
    this.CaG = -1;
    this.CaH = -1;
    this.Caj = false;
    this.Cak = false;
    this.Cai = false;
    this.Cae = false;
    this.Cal = false;
    this.Cav = 10;
    this.mStatus = 1;
    this.CaT = 0;
    this.Cba = 0;
    this.CaU = false;
    this.CaS = 0;
    this.CaX = null;
    this.CaY = null;
    this.CaZ.clear();
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
      this.Cbe.az(60000L, 60000L);
    }
    this.mStatus = paramInt;
    AppMethodBeat.o(114907);
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(114906);
    ewn();
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114889);
        if (l.this.CaJ != null) {
          l.this.CaJ.evw();
        }
        AppMethodBeat.o(114889);
      }
    });
    AppMethodBeat.o(114906);
  }
  
  public final void tj(boolean paramBoolean)
  {
    AppMethodBeat.i(114918);
    if (!paramBoolean)
    {
      if (this.CaI != null)
      {
        if (this.CaV)
        {
          f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc: Set P2S HW Flag False!!");
          h(8, false, true);
        }
        for (;;)
        {
          ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
          localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
          localByteBuffer.putInt(6);
          f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc:reset maxsizeformat: 6");
          this.CaI.setAppCmd(30, localByteBuffer.array(), 4);
          AppMethodBeat.o(114918);
          return;
          f.Logi("MicroMsg.Voip.VoipContext", "closecodec: remote i264 enc!");
          a(8, false, true, true);
        }
      }
    }
    else
    {
      if (this.CaV)
      {
        f.Logi("MicroMsg.Voip.VoipContext", "closeRemoteHWEnc: DecErr old!!");
        Uf(2);
        AppMethodBeat.o(114918);
        return;
      }
      f.Logi("MicroMsg.Voip.VoipContext", "closeRemoteHWEnc: DecErr new!!");
      a(8, true, false, false);
    }
    AppMethodBeat.o(114918);
  }
  
  public static abstract interface a
  {
    public abstract void J(int paramInt1, int paramInt2, String paramString);
  }
  
  static abstract interface d
  {
    public abstract void ewo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l
 * JD-Core Version:    0.7.0.1
 */