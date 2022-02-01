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
import com.tencent.mm.model.bi;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.voip.model.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.protocal.protobuf.diz;
import com.tencent.mm.protocal.protobuf.dll;
import com.tencent.mm.protocal.protobuf.dmd;
import com.tencent.mm.protocal.protobuf.dme;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.dnm;
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
  public boolean duq;
  ap mHandler;
  public int mStatus;
  public Context mfC;
  public boolean ziA;
  public boolean ziB;
  public boolean ziC;
  public cww ziD;
  public int ziE;
  public long ziF;
  public long ziG;
  public int ziH;
  public int ziI;
  public boolean ziJ;
  public boolean ziK;
  public boolean ziL;
  public int ziM;
  private int ziN;
  private int ziO;
  private int ziP;
  private int ziQ;
  private int ziR;
  public boolean ziS;
  private boolean ziT;
  private int ziU;
  private boolean ziV;
  private int ziW;
  private int ziX;
  private int ziY;
  public v2protocal ziZ;
  public boolean ziv;
  public boolean ziw;
  public boolean zix;
  public boolean ziy;
  public boolean ziz;
  public x zja;
  public n zjb;
  public w zjc;
  public byte[] zjd;
  public dmk zje;
  public boolean zjf;
  public boolean zjg;
  public int zjh;
  public int zji;
  public int zjj;
  public int zjk;
  public boolean zjl;
  public boolean zjm;
  public VoipScoreState zjn;
  public Network zjo;
  public ConnectivityManager.NetworkCallback zjp;
  public LinkedList<Integer> zjq;
  public int zjr;
  public av zjs;
  Timer zjt;
  int zju;
  private av zjv;
  private a zjw;
  
  protected l()
  {
    AppMethodBeat.i(114899);
    this.mStatus = 1;
    this.ziv = false;
    this.ziw = false;
    this.zix = false;
    this.ziy = false;
    this.duq = false;
    this.ziz = false;
    this.ziA = false;
    this.ziB = false;
    this.ziC = false;
    this.ziD = new cww();
    this.ziE = 0;
    this.ziF = 0L;
    this.ziG = 0L;
    this.ziH = 0;
    this.ziI = 0;
    this.ziJ = false;
    this.ziK = false;
    this.ziL = false;
    this.ziM = 10;
    this.ziN = -1;
    this.ziO = -1;
    this.ziP = -1;
    this.ziQ = -1;
    this.ziR = -1;
    this.ziS = false;
    this.ziT = false;
    this.ziU = 1;
    this.ziV = false;
    this.ziW = 1;
    this.ziX = -1;
    this.ziY = -1;
    this.mfC = null;
    this.zja = x.zmT;
    this.zjd = null;
    this.zje = null;
    this.zjf = false;
    this.zjg = false;
    this.zjh = 0;
    this.zji = 0;
    this.zjj = 0;
    this.zjk = 0;
    this.zjl = false;
    this.zjm = true;
    this.zjo = null;
    this.zjp = null;
    this.zjq = new LinkedList();
    this.zjr = 0;
    this.zjs = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(114886);
        ad.v("MicroMsg.Voip.VoipContext", "voip repeat sync");
        l.this.zjc.a(null, false, 7);
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
          if (l.this.ziZ.roomId == 0)
          {
            com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipContext", "JNI_DOSYNC without roomid , igored!");
            AppMethodBeat.o(114891);
            return;
          }
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "need dosync for cmd from channel...");
          localObject3 = (byte[])paramAnonymousMessage.obj;
          localObject1 = l.this.zjc;
          i = paramAnonymousMessage.arg2;
          paramAnonymousMessage = new dnb();
          paramAnonymousMessage.mBH = 1;
          localObject4 = new SKBuiltinBuffer_t();
          ((SKBuiltinBuffer_t)localObject4).setBuffer((byte[])localObject3);
          paramAnonymousMessage.CCV = ((SKBuiltinBuffer_t)localObject4);
          localObject3 = new SKBuiltinBuffer_t();
          try
          {
            ((SKBuiltinBuffer_t)localObject3).setBuffer(paramAnonymousMessage.toByteArray());
            paramAnonymousMessage = new dmd();
            paramAnonymousMessage.CYY = i;
            paramAnonymousMessage.CYZ = ((SKBuiltinBuffer_t)localObject3);
            paramAnonymousMessage.sdQ = com.tencent.mm.model.u.aqG();
            localObject3 = new dme();
            ((dme)localObject3).mAK = 1;
            ((dme)localObject3).mAL.add(paramAnonymousMessage);
            ((w)localObject1).a((dme)localObject3, true, 2);
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
          if (l.this.ziZ.roomId == 0)
          {
            com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipContext", "JNI_STARTDEVFAILED without roomid , igored!");
            AppMethodBeat.o(114891);
            return;
          }
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "need hangUP for startTalk failed. ");
          l.this.ziZ.zpq.zkh = 107;
          l.this.I(1, -9004, "");
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 6)
        {
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected from JNI");
          if (l.this.ziZ.roomId == 0)
          {
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected roomid null, ignored");
            AppMethodBeat.o(114891);
            return;
          }
          l.this.zix = true;
          l.this.ziZ.zpq.zkx = 1;
          if ((!l.this.duq) && (!l.this.ziy)) {}
          for (l.this.ziZ.zof = 1;; l.this.ziZ.zof = 0)
          {
            l.this.ziZ.setInactive();
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "Voip.Channel setInactive");
            l.this.dTg();
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
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "need hangUP for disconnect from channel..envent = " + paramAnonymousMessage.arg2);
          if (l.this.mStatus >= 5)
          {
            l.this.ziZ.zpq.zkh = 108;
            if (paramAnonymousMessage.arg2 != 5) {
              break label596;
            }
            l.this.ziZ.zpq.zkz = 1;
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "channel broken...");
          }
          for (;;)
          {
            l.this.I(1, -9000, "");
            AppMethodBeat.o(114891);
            return;
            l.this.ziZ.zpq.zkh = 106;
            break;
            label596:
            if (paramAnonymousMessage.arg2 == 8)
            {
              if (l.this.ziB == true)
              {
                com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "channel connect fail while pre-connect");
                l.this.ziA = true;
                AppMethodBeat.o(114891);
                return;
              }
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "channel connect fail...");
              l.this.zix = false;
              l.this.ziZ.zpq.zkz = 5;
            }
          }
        }
        if (paramAnonymousMessage.arg1 == 100)
        {
          com.tencent.mm.plugin.voip.b.c.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.Voip.VoipContext", paramAnonymousMessage.arg2);
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 101)
        {
          com.tencent.mm.plugin.voip.b.c.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.v2Core", paramAnonymousMessage.arg2);
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 7)
        {
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "NOTIFY_FROM_JNI_SPEEDTESTRESULT handle");
          localObject4 = (byte[])paramAnonymousMessage.obj;
          i = paramAnonymousMessage.arg2;
          paramAnonymousMessage = null;
          try
          {
            localObject1 = ay.iA(aj.getContext());
            paramAnonymousMessage = (Message)localObject1;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "Get wifiName failed in voip speedTest!");
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
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "Get netName failed in voip speedTest!");
            }
          }
          new j(l.this.ziG, l.this.ziF, l.this.ziH, (String)localObject1, paramAnonymousMessage, l.this.ziI, i, (byte[])localObject4).dVj();
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
              localObject2 = (diz)new diz().parseFrom((byte[])localObject2);
              if ((!paramAnonymousMessage.zjl) || (((diz)localObject2).Ezh != 1)) {
                com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "steve: onRecvRUDPCmd:" + ((diz)localObject2).Ezh);
              }
              i = ((diz)localObject2).Ezh;
              switch (i)
              {
              default: 
                AppMethodBeat.o(114891);
                return;
              }
            }
            catch (Exception paramAnonymousMessage)
            {
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "rudp cmd processing Error");
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client tells us to end HWEnc!!");
            paramAnonymousMessage.zjb.zjS = true;
            AppMethodBeat.o(114891);
            return;
            if (!paramAnonymousMessage.zjl)
            {
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client end HWEnc!!");
              paramAnonymousMessage.g(8, false, true);
              paramAnonymousMessage.b(4, false, true, true);
              if (((diz)localObject2).Ezi == null) {
                break label1190;
              }
              localObject2 = ByteBuffer.wrap(((diz)localObject2).Ezi.wA, 0, 4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              i = Math.min(((ByteBuffer)localObject2).getInt(), 6);
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(i);
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:CMD_VOIP_CloseHWEnc:reset maxsizeformat: ".concat(String.valueOf(i)));
              paramAnonymousMessage.ziZ.setAppCmd(30, ((ByteBuffer)localObject2).array(), 4);
            }
            for (;;)
            {
              paramAnonymousMessage.zjl = true;
              AppMethodBeat.o(114891);
              return;
              label1190:
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: cmdBuffer is nil!!");
            }
            if (((diz)localObject2).Ezi != null)
            {
              localObject2 = ((diz)localObject2).Ezi.wA;
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "steve: remote new network type:".concat(String.valueOf(localObject2)));
              i = paramAnonymousMessage.ziZ.setAppCmd(302, (byte[])localObject2, 4);
              if (i < 0) {
                com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + localObject2 + "fail:" + i + ", [roomid=" + paramAnonymousMessage.ziZ.sBf + ", roomkey=" + paramAnonymousMessage.ziZ.sAY + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
            AppMethodBeat.o(114891);
            return;
            byte[] arrayOfByte;
            if (((diz)localObject2).Ezi != null)
            {
              localObject2 = ((diz)localObject2).Ezi.wA;
              localObject2 = (dll)new dll().parseFrom((byte[])localObject2);
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "zhengxue: remote audio dev occupied stat :" + ((dll)localObject2).EBD);
              arrayOfByte = new byte[4];
              arrayOfByte[0] = ((byte)((dll)localObject2).EBD);
              paramAnonymousMessage.ziZ.setJNIAppCmd(2, arrayOfByte, 4);
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "zhengxue:[CHANNEL]EMethod_AudioDevOccupiedStatsSync empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((diz)localObject2).Ezi != null)
            {
              localObject2 = ((diz)localObject2).Ezi.wA;
              if (paramAnonymousMessage.ziZ != null)
              {
                localObject2 = ByteBuffer.wrap((byte[])localObject2);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                i = ((ByteBuffer)localObject2).getInt();
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)3);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.ziZ.setAppCmd(35, ((ByteBuffer)localObject2).array(), 6);
                com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_DisableCodec:  ".concat(String.valueOf(i)));
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_DisableCodec empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((diz)localObject2).Ezi != null)
            {
              localObject2 = ((diz)localObject2).Ezi.wA;
              if (paramAnonymousMessage.ziZ != null)
              {
                localObject2 = ByteBuffer.wrap((byte[])localObject2);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                i = ((ByteBuffer)localObject2).getInt();
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)3);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.ziZ.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
                com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder:  ".concat(String.valueOf(i)));
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((diz)localObject2).Ezi != null)
            {
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(1);
              paramAnonymousMessage.ziZ.setAppCmd(48, ((ByteBuffer)localObject2).array(), 4);
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAq:  1");
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAq empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((diz)localObject2).Ezi != null)
            {
              localObject2 = ((diz)localObject2).Ezi.wA;
              if (paramAnonymousMessage.ziZ != null)
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
                paramAnonymousMessage.ziZ.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)2);
                ((ByteBuffer)localObject2).putShort((short)4);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.ziZ.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
              }
              for (;;)
              {
                com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder:  ".concat(String.valueOf(i)));
                AppMethodBeat.o(114891);
                return;
                label1920:
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)2);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.ziZ.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
              }
            }
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((diz)localObject2).Ezi != null)
            {
              localObject2 = ((diz)localObject2).Ezi.wA;
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "anlin: remote wx ver: ".concat(String.valueOf(localObject2)));
              i = paramAnonymousMessage.ziZ.setAppCmd(506, (byte[])localObject2, 4);
              if (i < 0) {
                com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteClientVersion] remote wx ver: " + localObject2 + "ret: " + i + ", [roomid=" + paramAnonymousMessage.ziZ.sBf + ", roomkey=" + paramAnonymousMessage.ziZ.sAY + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteClientVersion] empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((diz)localObject2).Ezi != null)
            {
              arrayOfByte = ((diz)localObject2).Ezi.wA;
              i = ((diz)localObject2).Ezi.wA.length;
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "anlin: remote device model: ".concat(String.valueOf(arrayOfByte)));
              i = paramAnonymousMessage.ziZ.setAppCmd(508, arrayOfByte, i);
              if (i < 0) {
                com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteDeviceModel] remote device model: " + arrayOfByte + "ret: " + i + ", [roomid=" + paramAnonymousMessage.ziZ.sBf + ", roomkey=" + paramAnonymousMessage.ziZ.sAY + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteDeviceModel] empty buffer");
          }
        }
        if (paramAnonymousMessage.arg1 == 9)
        {
          paramAnonymousMessage = l.this.ziZ.zpq;
          if (0L == paramAnonymousMessage.zkL)
          {
            paramAnonymousMessage.zkL = System.currentTimeMillis();
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.VoipDailReport", "first pkt received timestamp:" + paramAnonymousMessage.zkL);
          }
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "get first pkt for voip");
          if (1 == l.this.ziZ.zoQ)
          {
            paramAnonymousMessage = new dnm();
            paramAnonymousMessage.mBi = 1;
            l.this.zjc.a(paramAnonymousMessage, 2);
            AppMethodBeat.o(114891);
          }
        }
        else
        {
          if (paramAnonymousMessage.arg1 == 11)
          {
            l.this.zjr = 2;
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 12)
          {
            l.this.zjr = 1;
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 13)
          {
            localObject2 = (int[])paramAnonymousMessage.obj;
            i = paramAnonymousMessage.arg2;
            new com.tencent.mm.plugin.voip.model.a.h(l.this.ziZ.roomId, l.this.ziZ.sAY, l.this.ziZ.sBf, 1, i, (int[])localObject2, null).dVj();
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 14)
          {
            localObject2 = (int[])paramAnonymousMessage.obj;
            i = paramAnonymousMessage.arg2;
            new com.tencent.mm.plugin.voip.model.a.h(l.this.ziZ.roomId, l.this.ziZ.sAY, l.this.ziZ.sBf, 2, i, (int[])localObject2, null).dVj();
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 15) {
            l.this.aC(paramAnonymousMessage.arg2, false);
          }
        }
        AppMethodBeat.o(114891);
      }
    };
    this.zjt = null;
    this.zju = 0;
    this.zjv = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(177018);
        if (l.this.mStatus == 4)
        {
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "connect time out.. now finish..");
          l.this.ziZ.zpq.zkh = 105;
          l.this.I(1, -9000, "");
        }
        AppMethodBeat.o(177018);
        return false;
      }
    }, false);
    this.zjw = null;
    this.ziZ = new v2protocal(this.mHandler);
    this.zjb = new n(this);
    this.zjb.zjX = this.ziZ.sAY;
    this.zjc = new w(this);
    this.zjk = 0;
    this.zjn = new VoipScoreState();
    AppMethodBeat.o(114899);
  }
  
  private void a(final d paramd)
  {
    AppMethodBeat.i(177020);
    if ((this.mStatus != 2) && (this.mStatus != 3) && (this.mStatus != 4))
    {
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "startConnectRelay status fail, status:" + this.mStatus);
      AppMethodBeat.o(177020);
      return;
    }
    if (this.ziv)
    {
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "can not startConnectRelay again");
      AppMethodBeat.o(177020);
      return;
    }
    l.c localc = new l.c(this, (byte)0);
    localc.zjF = new l.b()
    {
      public final void at(final int paramAnonymousInt1, final int paramAnonymousInt2, final int paramAnonymousInt3)
      {
        AppMethodBeat.i(114895);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114894);
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel relay");
            int k = l.this.ziZ.zou;
            int m = l.this.ziZ.zou;
            v2protocal localv2protocal = l.this.ziZ;
            int n = l.this.ziZ.znr;
            long l1 = l.this.ziZ.roomId;
            int i1 = l.this.ziZ.sBf;
            long l2 = l.this.ziZ.sAY;
            byte[] arrayOfByte1 = l.this.ziZ.znt;
            int i2 = l.this.ziZ.channelStrategy;
            int i3 = l.this.ziZ.zny;
            int i4 = l.this.ziZ.znz;
            int i5 = l.this.ziZ.znw;
            byte[] arrayOfByte2;
            int i6;
            int i7;
            int i8;
            byte[] arrayOfByte3;
            int i9;
            int i10;
            if (l.this.ziZ.znx == null)
            {
              i = 0;
              arrayOfByte2 = l.this.ziZ.znx;
              i6 = l.this.ziZ.znA;
              i7 = l.this.ziZ.znq;
              i8 = l.this.ziZ.zoE;
              arrayOfByte3 = l.this.ziZ.zoF;
              i9 = l.this.ziZ.zoG;
              i10 = l.this.ziZ.znB;
              if (l.this.ziZ.znC != null) {
                break label521;
              }
            }
            label521:
            for (int j = 0;; j = l.this.ziZ.znC.length)
            {
              i = localv2protocal.setConfigInfo(n, l1, i1, l2, arrayOfByte1, i2, i3, i4, i5, i, arrayOfByte2, i6, (k >> 2 & 0x3) >> 1 & 0x1 & (m & 0x3) >> 1 & 0x1, i7, i8, arrayOfByte3, i9, i10, j, l.this.ziZ.znC, l.this.ziZ.zoH, paramAnonymousInt1, paramAnonymousInt3, paramAnonymousInt2, "", "", v2protocal.dVB());
              if (i >= 0) {
                break label539;
              }
              com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipContext", "v2protocal setConfigInfo or connectToPeerRelay failed, ret:".concat(String.valueOf(i)));
              l.this.ziZ.zpq.zkh = 14;
              l.this.I(1, -9002, "");
              l.11.this.zjy.dTr();
              AppMethodBeat.o(114894);
              return;
              i = l.this.ziZ.znx.length;
              break;
            }
            label539:
            if (l.this.ziZ.zoT == null)
            {
              com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipContext", "relay conns buf null");
              l.this.I(1, -9002, "");
              l.11.this.zjy.dTr();
              AppMethodBeat.o(114894);
              return;
            }
            int i = l.this.ziZ.AddNewRelayConns(l.this.ziZ.zoT, l.this.ziZ.zoT.length, 0);
            if (i < 0)
            {
              com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipContext", "add relayconns err:".concat(String.valueOf(i)));
              l.this.I(1, -9002, "");
              l.11.this.zjy.dTr();
              AppMethodBeat.o(114894);
              return;
            }
            l.this.ziv = true;
            l.this.ziZ.zpq.zko = 1;
            l.this.ziZ.zpq.zkw = 1;
            l.11.this.zjy.dTr();
            AppMethodBeat.o(114894);
          }
        });
        AppMethodBeat.o(114895);
      }
    };
    com.tencent.e.h.Iye.aP(localc);
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
  
  private void dTd()
  {
    AppMethodBeat.i(114914);
    com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipContext", "SrvDeviceInfo.mAudioInfo.aecMode:" + ae.fFx.fzW);
    if (ae.fFx.fzy == 1) {
      this.ziZ.setAppCmd(410);
    }
    byte[] arrayOfByte = new byte[2];
    Object localObject;
    int n;
    int i;
    int j;
    int k;
    int m;
    if (ae.fFx.fzW >= 0)
    {
      arrayOfByte[0] = ((byte)ae.fFx.fzW);
      this.ziZ.setAppCmd(406, arrayOfByte, 1);
      localObject = com.tencent.mm.model.c.d.aty().qu("100447");
      if (((com.tencent.mm.storage.c)localObject).isValid())
      {
        n = bt.getInt((String)((com.tencent.mm.storage.c)localObject).eJy().get("SetVoipRnnNsOn"), 0);
        if (1 == n)
        {
          i = (byte)n;
          this.ziZ.setAppCmd(432, new byte[] { i }, 1);
        }
      }
      n = ae.fFx.fzX;
      ad.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.nsModeNew %d", new Object[] { Integer.valueOf(n) });
      if (ae.fFx.fzX < 0) {
        break label1532;
      }
      if (n <= 0) {
        break label1513;
      }
      int i1 = (int)Math.floor(n / 1000.0D) % 100;
      ad.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.iflag %d", new Object[] { Integer.valueOf(i1) });
      if (i1 > 0)
      {
        i = (byte)(n & 0xFF);
        j = (byte)(n >> 8 & 0xFF);
        k = (byte)(n >> 16 & 0xFF);
        m = (byte)(n >> 24 & 0xFF);
        this.ziZ.setAppCmd(408, (byte[])new byte[] { i, j, k, m }, 4);
      }
      label326:
      n = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ptw, -1);
      ad.i("MicroMsg.Voip.VoipContext", "kerrizhang, play_fadeinfadeout_switch = %d", new Object[] { Integer.valueOf(n) });
      localObject = new byte[1];
      localObject[0] = 0;
      if (n > 0) {
        localObject[0] = ((byte)n);
      }
      this.ziZ.setAppCmd(451, (byte[])localObject, 1);
      n = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ptX, -1);
      ad.i("MicroMsg.Voip.VoipContext", "kerrizhang, fullbandmode = %d", new Object[] { Integer.valueOf(n) });
      i1 = ae.fFx.fzZ;
      ad.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.voipfullbandcfg %d", new Object[] { Integer.valueOf(i1) });
      if ((n > 0) && (i1 > 0))
      {
        i = (byte)(n & 0xFF);
        j = (byte)(n >> 8 & 0xFF);
        k = (byte)(n >> 16 & 0xFF);
        m = (byte)(n >> 24 & 0xFF);
        this.ziZ.setAppCmd(456, (byte[])new byte[] { i, j, k, m }, 4);
      }
      n = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ptx, -1);
      ad.i("MicroMsg.Voip.VoipContext", "kerrizhang, play_fadeinfadeout_thresh = %d", new Object[] { Integer.valueOf(n) });
      localObject[0] = 0;
      if (n > 0) {
        localObject[0] = ((byte)n);
      }
      this.ziZ.setAppCmd(452, (byte[])localObject, 1);
      n = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ptW, -1);
      ad.i("MicroMsg.Voip.VoipContext", "kerrizhang, voip rcnnvad_switch = %d", new Object[] { Integer.valueOf(n) });
      if (n > 0)
      {
        i = (byte)n;
        this.ziZ.setAppCmd(454, new byte[] { i }, 1);
      }
      if (ae.fFx.fAb < 0) {
        break label1574;
      }
      localObject = new byte[7];
      if ((ae.fFx.fAc >= 0) && (ae.fFx.fAd >= 0))
      {
        localObject[0] = ((byte)ae.fFx.fAc);
        localObject[1] = ((byte)ae.fFx.fAd);
        if (ae.fFx.fAe < 0) {
          break label1557;
        }
        localObject[2] = ((byte)ae.fFx.fAe);
        localObject[3] = ((byte)ae.fFx.fAb);
        localObject[4] = ((byte)ae.fFx.fAf);
        localObject[5] = ((byte)ae.fFx.fAg);
        localObject[6] = ((byte)ae.fFx.fAh);
        this.ziZ.setAppCmd(404, (byte[])localObject, 7);
      }
    }
    for (;;)
    {
      n = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ptv, -1);
      ad.i("MicroMsg.Voip.VoipContext", "qipengfeng, tryUpdateAudioAdaption, switch_flag_x = %d", new Object[] { Integer.valueOf(n) });
      localObject = new byte[1];
      localObject[0] = 0;
      if (n > 0) {
        localObject[0] = 1;
      }
      this.ziZ.setAppCmd(450, (byte[])localObject, 1);
      if ((ae.fFx.fzz >= 0) || (ae.fFx.fzB >= 0))
      {
        arrayOfByte[0] = -1;
        arrayOfByte[1] = -1;
        if (ae.fFx.fzz >= 0) {
          arrayOfByte[0] = ((byte)ae.fFx.fzz);
        }
        if (ae.fFx.fzB >= 0) {
          arrayOfByte[1] = ((byte)ae.fFx.fzB);
        }
        this.ziZ.setAppCmd(414, arrayOfByte, 2);
      }
      if ((ae.fFx.fzA >= 0) || (ae.fFx.fzC >= 0))
      {
        arrayOfByte[0] = -1;
        arrayOfByte[1] = -1;
        if (ae.fFx.fzA >= 0) {
          arrayOfByte[0] = ((byte)ae.fFx.fzA);
        }
        if (ae.fFx.fzC >= 0) {
          arrayOfByte[1] = ((byte)ae.fFx.fzC);
        }
        this.ziZ.setAppCmd(415, arrayOfByte, 2);
      }
      if ((ae.fFx.fzD >= 0) || (ae.fFx.fzE >= 0))
      {
        arrayOfByte[0] = -1;
        arrayOfByte[1] = -1;
        if (ae.fFx.fzD >= 0) {
          arrayOfByte[0] = ((byte)ae.fFx.fzD);
        }
        if (ae.fFx.fzE >= 0) {
          arrayOfByte[1] = ((byte)ae.fFx.fzE);
        }
        this.ziZ.setAppCmd(422, arrayOfByte, 2);
      }
      if (ae.fFx.fzF >= 0)
      {
        arrayOfByte[0] = ((byte)ae.fFx.fzF);
        this.ziZ.setAppCmd(416, arrayOfByte, 1);
      }
      if (ae.fFx.fzJ >= 0)
      {
        arrayOfByte[0] = ((byte)ae.fFx.fzJ);
        this.ziZ.setAppCmd(431, arrayOfByte, 4);
      }
      if ((ae.fFx.fzG >= 0) && ((this.ziZ.zoo != 0) || (ae.fFx.fzG != 5)))
      {
        arrayOfByte[0] = ((byte)ae.fFx.fzG);
        this.ziZ.setAppCmd(417, arrayOfByte, 1);
      }
      if ((ae.fFx.fzH >= 0) && ((this.ziZ.zoo != 0) || (ae.fFx.fzH != 5)))
      {
        arrayOfByte[0] = ((byte)ae.fFx.fzH);
        this.ziZ.setAppCmd(418, arrayOfByte, 1);
      }
      if (ae.fFx.fzI >= 0)
      {
        arrayOfByte[0] = ((byte)ae.fFx.fzI);
        this.ziZ.setAppCmd(419, arrayOfByte, 1);
      }
      if ((this.ziZ.zoo == 1) && ((ae.fFx.fzG == 5) || (ae.fFx.fzH == 5))) {
        this.ziZ.znT = 5;
      }
      if (1 != ae.fFx.fAk) {
        break label1614;
      }
      localObject = new byte[30];
      n = 0;
      while (n < 15)
      {
        localObject[(n * 2)] = ((byte)(ae.fFx.fAl[n] & 0xFF));
        localObject[(n * 2 + 1)] = ((byte)(ae.fFx.fAl[n] >> 8 & 0xFF));
        n += 1;
      }
      if (ae.fFx.fzW != -2) {
        break;
      }
      this.ziZ.setAppCmd(407);
      break;
      label1513:
      if (n != 0) {
        break label326;
      }
      this.ziZ.setAppCmd(409);
      break label326;
      label1532:
      if (ae.fFx.fzX != -2) {
        break label326;
      }
      this.ziZ.setAppCmd(409);
      break label326;
      label1557:
      this.ziZ.setAppCmd(404, (byte[])localObject, 2);
      continue;
      label1574:
      if (ae.fFx.fAb == -2) {
        this.ziZ.setAppCmd(405);
      }
    }
    this.ziZ.setAppCmd(420, (byte[])localObject, 30);
    label1614:
    if (ae.fFx.fAk == 0) {
      this.ziZ.setAppCmd(421);
    }
    if ((ae.fFx.fAm[0] > 0) || (ae.fFx.fAm[1] > 0))
    {
      arrayOfByte[0] = 0;
      arrayOfByte[1] = 0;
      if ((ae.fFx.fAm[0] > 0) && (ae.fFx.fAm[0] < 10000)) {
        arrayOfByte[0] = ((byte)ae.fFx.fAm[0]);
      }
      if ((ae.fFx.fAm[1] > 0) && (ae.fFx.fAm[1] < 10000)) {
        arrayOfByte[1] = ((byte)ae.fFx.fAm[1]);
      }
      this.ziZ.setAppCmd(423, arrayOfByte, 2);
    }
    if (ae.fFx.fAo > 0)
    {
      arrayOfByte[0] = ((byte)ae.fFx.fAo);
      this.ziZ.setAppCmd(424, arrayOfByte, 1);
    }
    if (ae.fFx.fAw >= 0)
    {
      i = (byte)ae.fFx.fAw;
      j = (byte)ae.fFx.fAx;
      k = (byte)ae.fFx.fAy;
      m = (byte)ae.fFx.fAz;
      this.ziZ.setAppCmd(426, new byte[] { i, j, k, m }, 4);
    }
    AppMethodBeat.o(114914);
  }
  
  private static int dTk()
  {
    AppMethodBeat.i(184050);
    String str1 = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwY, "");
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
  
  private int rA(boolean paramBoolean)
  {
    AppMethodBeat.i(192009);
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "EnableAq: SetAqFlag =44, aqBlur=".concat(String.valueOf(paramBoolean)));
    ByteBuffer localByteBuffer;
    if (paramBoolean)
    {
      localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putInt(1);
    }
    try
    {
      if (this.ziZ != null)
      {
        diz localdiz = new diz();
        localdiz.Ezh = 10;
        localdiz.Ezi = new com.tencent.mm.bx.b(localByteBuffer.array());
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "EnableAq: SetAqFlag =44, aqBlur=".concat(String.valueOf(paramBoolean)));
        this.ziZ.SendRUDP(localdiz.toByteArray(), localdiz.toByteArray().length);
      }
      localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putInt(1);
      this.ziZ.setAppCmd(44, localByteBuffer.array(), 4);
      AppMethodBeat.o(192009);
      return 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "EnableAq Error");
      }
    }
  }
  
  public final void I(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(114937);
    dTq();
    if (this.zjw != null) {
      this.zjw.I(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(114937);
  }
  
  public final void PZ(int paramInt)
  {
    AppMethodBeat.i(114903);
    this.ziZ.znH = Math.abs(paramInt);
    AppMethodBeat.o(114903);
  }
  
  public final void Qa(int paramInt)
  {
    AppMethodBeat.i(114904);
    this.ziZ.znI = Math.abs(paramInt);
    if (paramInt != 1) {
      this.zja.cSz();
    }
    AppMethodBeat.o(114904);
  }
  
  public final void Qb(int paramInt)
  {
    this.ziZ.znL = paramInt;
  }
  
  public final void Qc(int paramInt)
  {
    AppMethodBeat.i(114910);
    if ((8 == paramInt) || (9 == paramInt)) {
      this.ziR = paramInt;
    }
    for (;;)
    {
      if ((1 == paramInt) || (3 == paramInt)) {
        Qd(2);
      }
      this.zja.PP(paramInt);
      AppMethodBeat.o(114910);
      return;
      this.ziP = paramInt;
      this.ziN = paramInt;
    }
  }
  
  public final void Qd(int paramInt)
  {
    AppMethodBeat.i(114911);
    if ((8 == paramInt) || (9 == paramInt)) {
      this.ziQ = paramInt;
    }
    for (;;)
    {
      this.zjc.Qt(paramInt);
      AppMethodBeat.o(114911);
      return;
      this.ziN = paramInt;
      this.ziO = paramInt;
    }
  }
  
  public final void Qe(int paramInt)
  {
    AppMethodBeat.i(114925);
    try
    {
      diz localdiz = new diz();
      localdiz.Ezh = paramInt;
      if (1 == paramInt)
      {
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:send maxsizeformat: !!6");
        ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer.putInt(6);
        localdiz.Ezi = new com.tencent.mm.bx.b(localByteBuffer.array());
        this.ziZ.setAppCmd(32, localByteBuffer.array(), 4);
      }
      for (;;)
      {
        this.ziZ.SendRUDP(localdiz.toByteArray(), localdiz.toByteArray().length);
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: send RUDP data to close remote HW encoding!Type:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(114925);
        return;
        localdiz.Ezi = null;
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "onVoipSendCloseHWEncCmd Error");
      AppMethodBeat.o(114925);
    }
  }
  
  public final void Qf(int paramInt)
  {
    AppMethodBeat.i(114926);
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "zhengxue: audio device occupied stat sync stat " + paramInt + " app 1");
    try
    {
      Object localObject = new byte[4];
      localObject[0] = ((byte)paramInt);
      this.ziZ.setJNIAppCmd(2, (byte[])localObject, 4);
      localObject = new dll();
      ((dll)localObject).EBD = paramInt;
      ((dll)localObject).EBE = 1;
      diz localdiz = new diz();
      localdiz.Ezh = 4;
      localdiz.Ezi = new com.tencent.mm.bx.b(((dll)localObject).toByteArray(), 0, 1);
      this.ziZ.SendRUDP(localdiz.toByteArray(), localdiz.toByteArray().length);
      AppMethodBeat.o(114926);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "onAudioDevOccupiedStat Error");
      AppMethodBeat.o(114926);
    }
  }
  
  public final void Qg(int paramInt)
  {
    this.ziZ.zoG = paramInt;
  }
  
  public final void Qh(int paramInt)
  {
    this.ziZ.zoz = paramInt;
  }
  
  public final void Qi(int paramInt)
  {
    this.ziZ.zpq.zkn = 1;
    this.ziZ.channelStrategy = paramInt;
  }
  
  public final void Qj(int paramInt)
  {
    this.ziZ.znA = paramInt;
  }
  
  public final void a(a parama)
  {
    if (parama != null) {
      this.zjw = parama;
    }
  }
  
  public final void a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.ziZ.znw = paramInt1;
    this.ziZ.znx = paramArrayOfByte1;
    this.ziZ.zoE = paramInt2;
    this.ziZ.zoF = paramArrayOfByte2;
  }
  
  public final boolean a(dmk paramdmk)
  {
    this.zje = paramdmk;
    this.ziZ.fPP = this.zje.ECd;
    this.ziZ.roomId = this.zje.DdZ;
    this.ziZ.sAY = this.zje.Dea;
    this.ziZ.sBf = 1;
    this.ziZ.znr = 0;
    this.mStatus = 3;
    return true;
  }
  
  public final void aC(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(114921);
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "start bindSocket " + paramInt + " ToNetwork " + this.zjo + " rebind " + paramBoolean);
    if ((this.zjo != null) && (com.tencent.mm.compatible.util.d.lf(23)))
    {
      FileDescriptor localFileDescriptor = new FileDescriptor();
      try
      {
        Field localField = FileDescriptor.class.getDeclaredField("descriptor");
        localField.setAccessible(true);
        localField.setInt(localFileDescriptor, paramInt);
        this.zjo.bindSocket(localFileDescriptor);
        if (!paramBoolean) {
          this.zjq.add(Integer.valueOf(paramInt));
        }
        com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipContext", "bindSocketToNetwork success: network" + this.zjo + "+socketfd" + paramInt);
        AppMethodBeat.o(114921);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "bindSocketToNetwork Error");
      }
    }
    AppMethodBeat.o(114921);
  }
  
  public final int aP(LinkedList<bso> paramLinkedList)
  {
    int j = 0;
    AppMethodBeat.i(114936);
    Object localObject = new LinkedList();
    int k = this.ziZ.aQ((LinkedList)localObject);
    int i = j;
    if (k == 0)
    {
      if ((((LinkedList)localObject).size() == 0) || (((LinkedList)localObject).size() > 2))
      {
        AppMethodBeat.o(114936);
        return 0;
      }
      if ((((bso)((LinkedList)localObject).get(0)).DPI == 1) && (((bso)((LinkedList)localObject).get(0)).DPK == 5))
      {
        paramLinkedList.add(((LinkedList)localObject).get(0));
        this.ziZ.znY = 1;
        AppMethodBeat.o(114936);
        return 0;
      }
      paramLinkedList.add(((LinkedList)localObject).get(0));
      this.ziZ.znX = 1;
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
      bso localbso = new bso();
      localbso.DvP = "android-cellular";
      localbso.DPI = 0;
      localbso.DPK = 5;
      localbso.DPJ = (((String)localObject).substring(0, 3) + ":" + ((String)localObject).substring(3, ((String)localObject).length()));
      paramLinkedList.add(localbso);
      this.ziZ.znY = 1;
      i = j;
    }
    while (i < paramLinkedList.size())
    {
      ad.d("MicroMsg.Voip.VoipContext", "nic_name:" + ((bso)paramLinkedList.get(i)).DvP + " nic_role:" + ((bso)paramLinkedList.get(i)).DPI + " net_type:" + ((bso)paramLinkedList.get(i)).DPK + " nic_isp_info:" + ((bso)paramLinkedList.get(i)).DPJ);
      i += 1;
    }
    AppMethodBeat.o(114936);
    return k;
  }
  
  public final int b(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(184049);
    if (paramInt < 0)
    {
      AppMethodBeat.o(184049);
      return -1;
    }
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "CloseCodec: targetCodec =" + paramInt + ", local=" + paramBoolean1 + ", remote =" + paramBoolean2 + "encTag=" + paramBoolean3);
    ByteBuffer localByteBuffer1;
    if ((paramBoolean1) && (paramBoolean3))
    {
      localByteBuffer1 = ByteBuffer.allocate(4);
      localByteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer1.putInt(paramInt);
    }
    for (;;)
    {
      diz localdiz;
      try
      {
        if (this.ziZ != null)
        {
          localdiz = new diz();
          localdiz.Ezh = 6;
          localdiz.Ezi = new com.tencent.mm.bx.b(localByteBuffer1.array());
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(paramInt)));
          this.ziZ.SendRUDP(localdiz.toByteArray(), localdiz.toByteArray().length);
        }
        localByteBuffer1 = ByteBuffer.allocate(6);
        localByteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer1.putShort((short)2);
        localByteBuffer1.putShort((short)paramInt);
        localByteBuffer1.putShort((short)0);
        this.ziZ.setAppCmd(39, localByteBuffer1.array(), 6);
        AppMethodBeat.o(184049);
        return 1;
      }
      catch (Exception localException1)
      {
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        continue;
      }
      if ((paramBoolean1) && (!paramBoolean3))
      {
        ByteBuffer localByteBuffer2 = ByteBuffer.allocate(6);
        localByteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer2.putShort((short)0);
        localByteBuffer2.putShort((short)paramInt);
        localByteBuffer2.putShort((short)0);
        this.ziZ.setAppCmd(39, localByteBuffer2.array(), 6);
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
          if (this.ziZ == null) {
            continue;
          }
          localdiz = new diz();
          localdiz.Ezh = 7;
          localdiz.Ezi = new com.tencent.mm.bx.b(localByteBuffer2.array());
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(i)));
          this.ziZ.SendRUDP(localdiz.toByteArray(), localdiz.toByteArray().length);
        }
        catch (Exception localException2)
        {
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        }
      }
      else if ((paramBoolean2) && (paramBoolean3))
      {
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:disable remote target codec: ".concat(String.valueOf(paramInt)));
        ByteBuffer localByteBuffer3 = ByteBuffer.allocate(6);
        localByteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer3.putShort((short)3);
        localByteBuffer3.putShort((short)paramInt);
        localByteBuffer3.putShort((short)0);
        this.ziZ.setAppCmd(39, localByteBuffer3.array(), 6);
        localByteBuffer3 = ByteBuffer.allocate(4);
        localByteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer3.putInt(paramInt);
        try
        {
          if (this.ziZ != null)
          {
            localdiz = new diz();
            localdiz.Ezh = 7;
            localdiz.Ezi = new com.tencent.mm.bx.b(localByteBuffer3.array());
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(paramInt)));
            this.ziZ.SendRUDP(localdiz.toByteArray(), localdiz.toByteArray().length);
          }
        }
        catch (Exception localException3)
        {
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        }
      }
    }
  }
  
  public final void bJ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114930);
    ad.i("MicroMsg.Voip.VoipContext", "updateRemotePid");
    this.ziZ.zpq.zkm = 1;
    this.ziZ.zpq.zkl = 1;
    this.ziZ.znt = paramArrayOfByte;
    AppMethodBeat.o(114930);
  }
  
  public final void bK(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    AppMethodBeat.i(114932);
    ad.i("MicroMsg.Voip.VoipContext", "updateRemoteCapInfo, isGotCapInfo: %s", new Object[] { Byte.valueOf(this.ziZ.zpq.zkq) });
    if ((this.ziZ.zpq.zkq == 1) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(114932);
      return;
    }
    this.ziZ.zpq.zkq = 1;
    this.ziZ.znu = paramArrayOfByte;
    if (this.ziZ.znu != null)
    {
      int i = this.ziZ.exchangeCabInfo(this.ziZ.znu, this.ziZ.znu.length);
      if ((this.ziZ.znu == null) || (this.ziZ.znu.length < 36)) {
        bool = true;
      }
      this.zjm = bool;
      if (i < 0)
      {
        com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipContext", "protocal exchangecabinfo failed ret:".concat(String.valueOf(i)));
        this.ziZ.zpq.zkh = 15;
        I(1, -9003, "");
      }
    }
    AppMethodBeat.o(114932);
  }
  
  public final void bL(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114933);
    this.ziZ.znv = paramArrayOfByte;
    dTp();
    AppMethodBeat.o(114933);
  }
  
  public final void c(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.ziZ.zoL = paramInt;
    this.ziZ.zoM = paramArrayOfByte1;
    this.ziZ.zoN = paramArrayOfByte2;
  }
  
  public final void dST()
  {
    int k = 0;
    AppMethodBeat.i(114901);
    if ((this.ziv == true) && (this.ziE == 0))
    {
      this.ziE = 1;
      if (this.ziZ.field_speedTestInfoLength < 8)
      {
        com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! bufsize=" + this.ziZ.field_speedTestInfoLength);
        AppMethodBeat.o(114901);
      }
    }
    else
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipContext", "StartVoipSpeedTest fail for status is wrong: isChannelStartConnect=" + this.ziv + " ,mSpeedTestStatus=" + this.ziE);
      AppMethodBeat.o(114901);
      return;
    }
    int i = this.ziZ.zpo[1];
    if (i + 2 > this.ziZ.field_speedTestInfoLength)
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i + ", bufsize=" + this.ziZ.field_speedTestInfoLength);
      AppMethodBeat.o(114901);
      return;
    }
    int j = this.ziZ.zpo[(i + 2 + 1)];
    if (i + 6 + j != this.ziZ.field_speedTestInfoLength)
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i + ", C2SRttCnt=" + j + ", bufsize=" + this.ziZ.field_speedTestInfoLength);
      AppMethodBeat.o(114901);
      return;
    }
    this.ziF = this.ziZ.sAY;
    this.ziH = this.ziZ.netType;
    this.ziI = this.ziZ.roomId;
    this.ziD.DdZ = this.ziZ.roomId;
    this.ziD.EoJ = this.ziZ.znG;
    this.ziD.CYi = this.ziZ.netType;
    cww localcww = this.ziD;
    if (this.ziv == true)
    {
      i = 1;
      localcww.EoK = i;
      localcww = this.ziD;
      if (this.zix != true) {
        break label482;
      }
    }
    label482:
    for (i = 1;; i = 0)
    {
      localcww.EoL = i;
      this.ziD.EoM = this.ziZ.zpo[0];
      this.ziD.EoN = this.ziZ.zpo[1];
      j = 0;
      i = 2;
      while (j < this.ziD.EoN)
      {
        this.ziD.EoO.add(Integer.valueOf(this.ziZ.zpo[i]));
        j += 1;
        i += 1;
      }
      i = 0;
      break;
    }
    localcww = this.ziD;
    int[] arrayOfInt = this.ziZ.zpo;
    j = i + 1;
    localcww.EoP = arrayOfInt[i];
    localcww = this.ziD;
    arrayOfInt = this.ziZ.zpo;
    i = j + 1;
    localcww.EoQ = arrayOfInt[j];
    j = k;
    while (j < this.ziD.EoQ)
    {
      this.ziD.EoR.add(Integer.valueOf(this.ziZ.zpo[i]));
      j += 1;
      i += 1;
    }
    this.ziD.EoS = this.ziZ.zpo[i];
    this.ziD.EoT = this.ziZ.zpo[(i + 1)];
    new com.tencent.mm.plugin.voip.model.a.k(this.ziD).dVj();
    AppMethodBeat.o(114901);
  }
  
  public final void dSU()
  {
    AppMethodBeat.i(114902);
    if (this.ziE == 0)
    {
      AppMethodBeat.o(114902);
      return;
    }
    if (this.ziE == 1)
    {
      this.ziE = 0;
      this.ziZ.zoY = 0L;
      AppMethodBeat.o(114902);
      return;
    }
    this.ziE = 0;
    v2protocal localv2protocal = this.ziZ;
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "v2protocal StopVoipSpeedTest!");
    localv2protocal.StopSpeedTest();
    localv2protocal.zoY = 0L;
    AppMethodBeat.o(114902);
  }
  
  public final void dSV()
  {
    AppMethodBeat.i(114905);
    this.ziZ.znJ = this.zjb.dTt();
    this.ziZ.znK = this.zjb.dRX();
    AppMethodBeat.o(114905);
  }
  
  public final int dSW()
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
  
  public final boolean dSX()
  {
    return (this.mStatus == 2) || (this.mStatus == 4);
  }
  
  public final boolean dSY()
  {
    return this.mStatus == 3;
  }
  
  public final boolean dSZ()
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
  
  public final long dTa()
  {
    return this.ziZ.znG;
  }
  
  public final boolean dTb()
  {
    if (this.ziL) {
      return false;
    }
    switch (this.ziN)
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
        } while (4 == this.ziO);
        return false;
      } while ((4 == this.ziO) || (-1 == this.ziO));
      return false;
      if ((5 == this.ziO) || (6 == this.ziO)) {
        break;
      }
    } while (7 != this.ziO);
    return false;
  }
  
  public final boolean dTc()
  {
    if (this.ziL) {
      return false;
    }
    switch (this.ziN)
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
        } while (4 == this.ziO);
        return false;
      } while ((4 == this.ziP) || (this.ziP == 0) || (-1 == this.ziP));
      return false;
      if ((5 == this.ziP) || (6 == this.ziP)) {
        break;
      }
    } while (7 != this.ziP);
    return false;
  }
  
  public final void dTe()
  {
    AppMethodBeat.i(114915);
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "In networkRequestViaCellular");
    if (com.tencent.mm.compatible.util.d.lf(21))
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)aj.getContext().getSystemService("connectivity");
      Object localObject = new NetworkRequest.Builder();
      ((NetworkRequest.Builder)localObject).addTransportType(0);
      ((NetworkRequest.Builder)localObject).addCapability(12);
      localObject = ((NetworkRequest.Builder)localObject).build();
      try
      {
        localConnectivityManager.requestNetwork((NetworkRequest)localObject, new ConnectivityManager.NetworkCallback()
        {
          public final void onAvailable(Network paramAnonymousNetwork)
          {
            int i = 0;
            AppMethodBeat.i(114890);
            super.onAvailable(paramAnonymousNetwork);
            Object localObject = l.this.ziZ;
            ((v2protocal)localObject).zoa += 1;
            localObject = Parcel.obtain();
            paramAnonymousNetwork.writeToParcel((Parcel)localObject, 0);
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "found requested network. netid: " + ((Parcel)localObject).readInt() + " toString: " + paramAnonymousNetwork.toString());
            if (com.tencent.mm.compatible.util.d.lf(28)) {
              localObject = (ConnectivityManager)aj.getContext().getSystemService("connectivity");
            }
            try
            {
              int j = ((ConnectivityManager)localObject).getMultipathPreference(paramAnonymousNetwork);
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "getMultipathPreference ret ".concat(String.valueOf(j)));
              if (j == 0) {
                l.this.ziZ.znZ = 3;
              }
              if (l.this.zjo != null)
              {
                l.this.zjo = paramAnonymousNetwork;
                if (l.this.zjq != null) {
                  while (i < l.this.zjq.size())
                  {
                    l.this.aC(((Integer)l.this.zjq.get(i)).intValue(), true);
                    i += 1;
                  }
                }
              }
              else
              {
                l.this.zjo = paramAnonymousNetwork;
              }
            }
            catch (Exception paramAnonymousNetwork)
            {
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "getMultipathPreference  Error");
              l.this.ziZ.znZ = 2;
              AppMethodBeat.o(114890);
              return;
            }
            l.this.zjp = this;
            l.this.ziZ.znZ = 1;
            AppMethodBeat.o(114890);
          }
        });
        AppMethodBeat.o(114915);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "missing the appropriate permissions");
        this.ziZ.znZ = 2;
        AppMethodBeat.o(114915);
        return;
      }
    }
    AppMethodBeat.o(114915);
  }
  
  public final void dTf()
  {
    AppMethodBeat.i(114916);
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "try to UnregisterCellularNetwork");
    ConnectivityManager localConnectivityManager;
    if (com.tencent.mm.compatible.util.d.lf(21))
    {
      localConnectivityManager = (ConnectivityManager)aj.getContext().getSystemService("connectivity");
      if (this.zjp == null) {}
    }
    try
    {
      localConnectivityManager.unregisterNetworkCallback(this.zjp);
      this.zjp = null;
      this.zjo = null;
      AppMethodBeat.o(114916);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "unregisterNetworkCallback Error");
      }
    }
  }
  
  public final void dTg()
  {
    AppMethodBeat.i(114917);
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: try start talk");
    if ((this.ziz != true) || (this.zix != true))
    {
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: fail isCanSendData " + this.ziz + ", isChannelConnectedSuccess " + this.zix);
      AppMethodBeat.o(114917);
      return;
    }
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "Voip tryStartTalk, channel setActive");
    this.ziZ.setActive();
    if (this.ziC == true)
    {
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: engine already started, isEngineStarted " + this.ziC);
      AppMethodBeat.o(114917);
      return;
    }
    this.ziZ.setSvrConfig(205, 0, 0, this.ziZ.zoH, 0, 0, 0, 0, null);
    this.ziZ.setSvrConfig(207, 0, 0, this.ziZ.znB, 0, 0, 0, 0, null);
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.ziZ.zoH + " SwitchFlag = " + this.ziZ.znB);
    this.ziZ.znE[0] = ((byte)ae.fFH.fCq);
    this.ziZ.znE[1] = ((byte)ae.fFH.fCr);
    this.ziZ.znE[2] = ((byte)ae.fFH.fCs);
    this.ziZ.znE[3] = ((byte)ae.fFH.fCt);
    this.ziZ.znE[4] = ((byte)ae.fFH.fCu);
    this.ziZ.znE[5] = ((byte)ae.fFH.fCv);
    this.ziZ.znE[6] = ((byte)ae.fFH.fCw);
    this.ziZ.znE[7] = ((byte)ae.fFH.fCx);
    this.ziZ.znE[8] = ((byte)ae.fFH.fCy);
    this.ziZ.znE[9] = ((byte)ae.fFH.fCz);
    this.ziZ.setSvrConfig(209, 0, 0, 0, 0, 0, 0, this.ziZ.znE.length, this.ziZ.znE);
    if (this.ziZ.startEngine() == 0) {
      this.ziZ.zpq.zkH = 0;
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
      if (this.ziZ.znD != null) {
        if (this.ziZ.znD.length < 1024)
        {
          this.ziZ.setSvrConfig(208, 0, 0, 0, 0, 0, 0, this.ziZ.znD.length, this.ziZ.znD);
          dTd();
          if ((dTb()) || (dTc())) {
            break label2825;
          }
          dTj();
          this.zja.dSA();
          localObject1 = this.zjb;
          if (((n)localObject1).nPJ != 2) {
            break label2883;
          }
          com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipDeviceHandler", "dev start already...");
          localObject1 = this.ziZ.zpq;
          if (((o)localObject1).beginTime != 0L) {
            break label3445;
          }
          ((o)localObject1).zkA = 0;
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + ((o)localObject1).beginTime + ", CurrentTime: " + System.currentTimeMillis());
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.VoipDailReport", "devin:endNewDial:" + ((o)localObject1).zkA);
          this.zja.onConnected();
          this.mStatus = 5;
          localObject1 = this.ziZ.zpq;
          ((o)localObject1).zkI = System.currentTimeMillis();
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.VoipDailReport", "devin:beginTalk:" + ((o)localObject1).zkI);
          this.ziZ.setSvrConfig(202, this.ziZ.zog, this.ziZ.zoh, 0, 0, 0, 0, 0, null);
          this.ziZ.setSvrConfig(203, 0, 0, this.ziZ.zol, 0, 0, 0, 0, null);
          this.ziZ.setSvrConfig(206, 0, 0, this.ziZ.zop, 0, 0, 0, 0, null);
          this.ziZ.setSvrConfig(103, this.ziZ.zoi, this.ziZ.zoj, this.ziZ.zok, this.ziZ.zon, 0, 0, 0, null);
          this.ziZ.setSvrConfig(205, 0, 0, this.ziZ.zoH, 0, 0, 0, 0, null);
          this.ziZ.setSvrConfig(207, 0, 0, this.ziZ.znB, 0, 0, 0, 0, null);
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.ziZ.zoH + " SwitchFlag = " + this.ziZ.znB);
          j = this.ziZ.zou >> 2 & 0x3;
          k = this.ziZ.zou & 0x3;
          if (this.ziZ.sBf != 0) {
            break label3463;
          }
          j = (j << 2) + k;
          this.ziZ.setSvrConfig(502, 0, 0, j, 0, 0, 0, 0, null);
          this.ziZ.setSvrConfig(503, 0, 0, this.ziZ.zov, this.ziZ.zow, this.ziZ.zox, this.ziZ.zoy, 0, null);
          if ((this.ziZ.zoM != null) && (this.ziZ.zoN != null))
          {
            this.ziZ.setSvrConfig(504, 0, 0, this.ziZ.zoL, 0, 0, 0, 0, null);
            this.ziZ.setSvrConfig(505, 0, 0, this.ziZ.zoM[0], this.ziZ.zoM[1], this.ziZ.zoM[2], this.ziZ.zoM[3], 0, null);
            this.ziZ.setSvrConfig(506, 0, 0, this.ziZ.zoN[0], this.ziZ.zoN[1], 0, 0, 0, null);
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "FECSvrCtr = " + this.ziZ.zoL + ",FECKeyPara1 = " + this.ziZ.zoM[0] + "," + this.ziZ.zoM[1] + "," + this.ziZ.zoM[2] + "," + this.ziZ.zoM[3] + ",FECKeyPara2 = " + this.ziZ.zoN[0] + "," + this.ziZ.zoN[1]);
          }
          k = this.ziZ.zoz;
          m = this.ziZ.zoz;
          n = this.ziZ.zoz;
          this.ziZ.setSvrConfig(507, 0, 0, (k & 0x4) >> 2, (m & 0x2) >> 1, n & 0x1, 0, 0, null);
          this.ziZ.setjbmbitraterssvrparam();
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "zhengxue[Logic] setSvrConfig brefore onStartTalk: audioTsdfBeyond3G = " + this.ziZ.zog + ",audioTsdEdge = " + this.ziZ.zoh + ",passthroughQosAlgorithm = " + this.ziZ.zoi + ",fastPlayRepair = " + this.ziZ.zoj + ", audioDTX = " + this.ziZ.zol + ", mARQFlag = " + j + ", mQosStrategy = " + this.ziZ.zoz + ", mSvrCfgListV = " + this.ziZ.zok + ", maxBRForRelay = " + this.ziZ.zon);
          localObject1 = new byte[2];
          localObject1[0] = ((byte)ae.fFw.fBy);
          localObject1[1] = -1;
          com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipContext", "steve: Model Name: " + Build.MODEL);
          com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipContext", "steve: Image Enhancement for Android Capture!!, mode: " + localObject1[0]);
          this.ziZ.setAppCmd(15, (byte[])localObject1, 1);
          com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipContext", "anlin: ClientVersion: " + com.tencent.mm.protocal.d.CpK);
          localObject1 = ByteBuffer.allocate(4);
          ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN).putInt(com.tencent.mm.protocal.d.CpK);
          localObject1 = ((ByteBuffer)localObject1).array();
          this.ziZ.setAppCmd(505, (byte[])localObject1, 4);
        }
      }
      label3463:
      try
      {
        if (this.ziZ != null)
        {
          ??? = new diz();
          ((diz)???).Ezh = 8;
          ((diz)???).Ezi = new com.tencent.mm.bx.b((byte[])localObject1);
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "anlin send local client version: ".concat(String.valueOf(localObject1)));
          this.ziZ.SendRUDP(((diz)???).toByteArray(), ((diz)???).toByteArray().length);
        }
        localObject1 = Build.MODEL;
        j = ((String)localObject1).length();
        localObject1 = ((String)localObject1).getBytes();
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "anlin DeviceModel: ".concat(String.valueOf(localObject1)));
        this.ziZ.setAppCmd(507, (byte[])localObject1, j);
      }
      catch (Exception localException1)
      {
        label2825:
        label3506:
        label3639:
        try
        {
          if (this.ziZ != null)
          {
            ??? = new diz();
            ((diz)???).Ezh = 9;
            ((diz)???).Ezi = new com.tencent.mm.bx.b((byte[])localObject1);
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "anlin send local device model: ".concat(String.valueOf(localObject1)));
            this.ziZ.SendRUDP(((diz)???).toByteArray(), ((diz)???).toByteArray().length);
          }
          if ((this.ziZ.znB >> 17 & 0x1) != 0)
          {
            bool1 = true;
            if ((this.ziZ.znB >> 18 & 0x1) == 0) {
              break label3506;
            }
            bool2 = true;
            rA(bool1);
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "EnableBlur: SetBlurFlag =47, aqBlur=".concat(String.valueOf(bool2)));
            if (bool2)
            {
              localObject1 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject1).putInt(1);
              this.ziZ.setAppCmd(47, ((ByteBuffer)localObject1).array(), 4);
            }
            if ((this.ziZ.znB & 0x2) == 0)
            {
              g(16, true, true);
              g(4, true, true);
            }
            j = this.ziZ.znB >> 12 & 0x1;
            localObject1 = ByteBuffer.allocate(4);
            ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
            ((ByteBuffer)localObject1).putInt(j);
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "weiranli set MixVcodec1 from svr = ".concat(String.valueOf(j)));
            this.ziZ.setAppCmd(46, ((ByteBuffer)localObject1).array(), 4);
            if ((this.ziZ.znB & 0x200) == 0)
            {
              localObject1 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject1).putInt(8);
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "jcchen Disable 720p from svr: mSwitchFlag = " + this.ziZ.znB);
              this.ziZ.setAppCmd(32, ((ByteBuffer)localObject1).array(), 4);
              this.ziZ.setAppCmd(30, ((ByteBuffer)localObject1).array(), 4);
            }
            if ((this.ziZ.znB & 0x100000) != 1) {
              break label3512;
            }
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "setAppCmd: EMethodSetP2SSendThreadEnable enble, mSwitchFlag: " + this.ziZ.znB);
            this.ziZ.setAppCmd(52);
            if (ab.hWq == 0) {
              break label3544;
            }
            localObject1 = ByteBuffer.allocate(4);
            ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
            ((ByteBuffer)localObject1).putInt(ab.hWq);
            this.ziZ.setAppCmd(36, ((ByteBuffer)localObject1).array(), 4);
            localObject1 = new byte[4];
            this.ziZ.setAppCmd(26, (byte[])localObject1, 4);
            localObject1 = ByteBuffer.wrap((byte[])localObject1);
            ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
            m = ((ByteBuffer)localObject1).getInt();
            com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipContext", "steve: iHW: ".concat(String.valueOf(m)));
            if (((this.ziZ.zok & 0x4) == 0) && (ae.fFw.fBA <= 0)) {
              break label3639;
            }
            j = 1;
            if ((j == 0) && (this.ziZ.nRs))
            {
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:Server Disable HW enc/dec!!");
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
                this.zjb.zjS = true;
                rz(false);
              }
              this.ziZ.nRs = false;
            }
            if (this.ziZ.nRs)
            {
              ??? = this.ziZ;
              n = ae.fFw.fBA;
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
                ((v2protocal)???).zpt = new e(((v2protocal)???).width, ((v2protocal)???).height, ((v2protocal)???).zpv, ((v2protocal)???).bitrate, n, (String)localObject1);
                com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "steve : create HW encoder successfully:".concat(String.valueOf(localObject1)));
                if (v2protocal.zpw != null)
                {
                  v2protocal.zpu = new d(v2protocal.zpw);
                  com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "steve : create HW decoder successfully!");
                }
                bool1 = true;
                if ((((v2protocal)???).zpt == null) || (v2protocal.zpu == null))
                {
                  ((v2protocal)???).nRs = false;
                  bool1 = false;
                }
              }
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "steve: HW encoder/decoder init ret: " + bool1 + ", iHW:" + m);
              if (!this.ziZ.nRs)
              {
                com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "steve: HW dec/enc NOT supported for both sides,end HWEnc!!");
                this.zjb.zjS = true;
                rz(false);
                b(8, true, false, true);
                b(8, true, false, false);
              }
            }
            if (this.ziZ.zpt != null) {
              this.ziZ.zpt.zfA = this;
            }
            if (v2protocal.zpu != null) {
              v2protocal.zpu.a(this);
            }
            this.ziC = true;
            this.zjl = false;
            localObject1 = this.zjn;
            ((VoipScoreState)localObject1).sCt = bi.asg();
            ad.i("MicroMsg.VoipScoreState", "markStartTalk, startTalkTime:%s", new Object[] { Long.valueOf(((VoipScoreState)localObject1).sCt) });
            dTh();
            dTi();
            AppMethodBeat.o(114917);
            return;
            this.ziC = false;
            this.ziZ.zpq.zkH = 1;
            continue;
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: length of generalStrategyBuf = " + this.ziZ.znD.length);
            break label503;
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: protocol has null generalStrategyBuf");
            break label503;
            if (this.zjt != null)
            {
              dTj();
              break label525;
            }
            this.zjt = new Timer();
            this.zju = 0;
            localObject1 = new TimerTask()
            {
              public final void run()
              {
                AppMethodBeat.i(114893);
                l locall = l.this;
                locall.zju += 1;
                if ((l.this.ziZ.zpe != 0) || (l.this.zju > 10))
                {
                  l.this.dTj();
                  if (l.this.zjt != null)
                  {
                    l.this.zjt.cancel();
                    l.this.zjt = null;
                  }
                  AppMethodBeat.o(114893);
                  return;
                }
                AppMethodBeat.o(114893);
              }
            };
            this.zjt.schedule((TimerTask)localObject1, 200L, 200L);
            break label525;
            label2883:
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipDeviceHandler", "start device......");
            ((n)localObject1).nPJ = 2;
            ((n)localObject1).zjS = false;
            ((n)localObject1).zjT = 0;
            if (((n)localObject1).zjW != null)
            {
              ad.i("MicroMsg.Voip.VoipDeviceHandler", "mDevHandlerThread is not null");
              if (!((n)localObject1).zjW.isQuit()) {
                ad.i("MicroMsg.Voip.VoipDeviceHandler", "mDevHandlerThread is alive");
              }
            }
            ((n)localObject1).zjW.removeCallbacksAndMessages(null);
            if (((n)localObject1).zka != null)
            {
              com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
              ((n)localObject1).zka.zkd = true;
              ((n)localObject1).zka.cancel();
              ((n)localObject1).zka = null;
            }
            ((n)localObject1).zka = new n.a((n)localObject1);
            com.tencent.mm.sdk.g.b.c(((n)localObject1).zka, "VoipDeviceHandler_decode");
            com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipDeviceHandler", "start video decode thread..");
            ae.fFx.dump();
            for (;;)
            {
              synchronized (((n)localObject1).zjQ)
              {
                while (((n)localObject1).nPJ == n.nPI)
                {
                  ad.e("MicroMsg.Voip.VoipDeviceHandler", "current is not allowed to start dev");
                  synchronized (((n)localObject1).zjQ)
                  {
                    ((n)localObject1).zjW.post(new n.2((n)localObject1));
                  }
                }
                localn.zjI = new c();
                localn.zjI.zfN = String.valueOf(localn.zjX);
                a locala = new a();
                j = localn.zfA.ziZ.a(locala);
                com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.GetAudioDeviceFmt, play samplerate:" + locala.uLy + ", framelen: " + locala.zfw + ", ret:" + j);
                localn.zjI.K(locala.uLy, locala.channels, locala.zfw, 0);
                localn.nPK = localn.zjI.z(localn.zfA.mfC, true);
                localn.zfA.ziZ.znV = localn.zjI.hCX;
                if (localn.zjI.zfz == true)
                {
                  j = 1;
                  int i = (byte)j;
                  localn.zfA.ziZ.setAppCmd(502, new byte[] { i }, 1);
                  if (localn.nPK <= 10)
                  {
                    if (localn.nPK <= 0) {
                      localn.nPN = 1;
                    }
                    localn.nPK = 92;
                  }
                  if ((!com.tencent.mm.plugin.audio.c.a.bvw()) && (!com.tencent.mm.plugin.audio.c.a.bvC())) {
                    break label3435;
                  }
                  com.tencent.mm.plugin.voip.c.dRQ().nv(true);
                  localn.zjI.zfJ = new n.3(localn);
                  if (localn.zjI.dRU() <= 0) {
                    localn.nPN = 1;
                  }
                }
              }
              j = 0;
              continue;
              label3435:
              com.tencent.mm.plugin.voip.c.dRQ().nv(false);
            }
            label3445:
            localObject2.zkA = ((int)(System.currentTimeMillis() - localObject2.beginTime));
            break label583;
            j = (k << 2) + j;
            break label963;
            localException1 = localException1;
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "anlin send local client version Error!");
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
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "anlin send local device model Error!");
            continue;
            boolean bool1 = false;
            continue;
            boolean bool2 = false;
            continue;
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "setAppCmd: EMethodSetP2SSendThreadEnable disable, mSwitchFlag: " + this.ziZ.znB);
            continue;
            label3544:
            if (ab.hWr != 0)
            {
              if ((ab.hWr & 0x2) != 0) {
                g(2, true, false);
              }
              if ((ab.hWr & 0x20) != 0) {
                g(32, true, false);
              }
              if ((ab.hWr & 0x10) != 0) {
                g(16, true, false);
              }
              if ((ab.hWr & 0x4) != 0) {
                g(4, true, false);
              }
              if ((ab.hWr & 0x8) != 0)
              {
                g(8, true, false);
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
  
  public final boolean dTh()
  {
    AppMethodBeat.i(114922);
    boolean bool = dTb();
    int i = 0;
    if (bool) {
      i = 1;
    }
    com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipContext", "needVideoOut ret: " + bool + "videoStatus: " + i + ", sendVideoStatus: " + this.ziX);
    if ((this.ziX == -1) || (this.ziX != i))
    {
      if (!bool) {
        break label158;
      }
      com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video Out.......!");
    }
    for (int j = this.ziZ.setAppCmd(203);; j = this.ziZ.setAppCmd(202))
    {
      if (j == 0)
      {
        this.ziX = i;
        com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: succeed, ret: " + j + "sendVideoStatus: " + this.ziX);
      }
      AppMethodBeat.o(114922);
      return bool;
      label158:
      com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video Out.......!");
    }
  }
  
  public final boolean dTi()
  {
    AppMethodBeat.i(114923);
    boolean bool = dTc();
    int i = 0;
    if (bool) {
      i = 1;
    }
    com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipContext", "needVideoIn ret: " + bool + "videoStatus: " + i + ", recvVideoStatus: " + this.ziY);
    if ((this.ziY == -1) || (this.ziY != i))
    {
      if (!bool) {
        break label158;
      }
      com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video In.......!");
    }
    for (int j = this.ziZ.setAppCmd(201);; j = this.ziZ.setAppCmd(200))
    {
      if (j == 0)
      {
        this.ziY = i;
        com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: succeed, ret: " + j + "recvVideoStatus: " + this.ziY);
      }
      AppMethodBeat.o(114923);
      return bool;
      label158:
      com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video In.......!");
    }
  }
  
  final void dTj()
  {
    AppMethodBeat.i(114924);
    if (this.mStatus == 5)
    {
      setStatus(6);
      this.ziZ.zpq.dTx();
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "talking  now .......!");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114892);
          l.this.zja.dSy();
          AppMethodBeat.o(114892);
        }
      });
    }
    AppMethodBeat.o(114924);
  }
  
  public final void dTl()
  {
    AppMethodBeat.i(184051);
    int i = m.WG();
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
      if (j < ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwU, 4)) {
        break label522;
      }
      bool2 = true;
      if (k < ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwV, 45)) {
        break label528;
      }
      bool3 = true;
      if (m < ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwW, 23)) {
        break label534;
      }
      bool4 = true;
      if (l < ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwX, 4096)) {
        break label540;
      }
      bool5 = true;
      double d = com.tencent.matrix.g.a.Il();
      Debug.MemoryInfo localMemoryInfo = com.tencent.matrix.g.a.aS(aj.getContext());
      ad.i("MicroMsg.Voip.VoipContext", "checkVoipBeautyLocalConfig, cpuFlags:%s, isNeon:%s, nCores:%s, nFreq:%s, sdkInt:%s, totalMemMB:%s, coreNumCheck:%s, freqCheck:%s, sdkIntCheck:%s, totalMemMBCheck:%s, cpuRate:%s, dalvikPss:%s, nativePss:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Double.valueOf(d), Integer.valueOf(localMemoryInfo.dalvikPss), Integer.valueOf(localMemoryInfo.nativePss) });
      if ((!bool1) || (!bool2) || (!bool3) || (!bool4) || (!bool5)) {
        break label546;
      }
      bool1 = true;
      k = ae.fFw.fBD;
      m = ae.fFw.fBE;
      i = this.ziZ.znB;
      n = (this.ziZ.znB >> 11 & 0x1) << 3 | i >> 4 & 0x7;
      j = 0;
      if (bool1) {
        j = dTk();
      }
      if ((m < 0) && (k < 0)) {
        break label574;
      }
      if (k < 0) {
        break label552;
      }
      i = k;
    }
    for (;;)
    {
      ad.m("MicroMsg.Voip.VoipContext", "setVoipBeautyConfig local:%s, server:%s , blacklist:%s, whitelist:%s, voipBeautyFlag:%s, uiCallback:%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), this.zja });
      if (this.zja != null) {
        this.zja.setVoipBeauty(i);
      }
      this.ziZ.zoR = i;
      this.ziZ.zoS = n;
      AppMethodBeat.o(184051);
      return;
      bool1 = false;
      break;
      label522:
      bool2 = false;
      break label84;
      label528:
      bool3 = false;
      break label111;
      label534:
      bool4 = false;
      break label138;
      label540:
      bool5 = false;
      break label168;
      label546:
      bool1 = false;
      break label337;
      label552:
      i = j;
      if (m >= 0)
      {
        i = j;
        if (n == 0)
        {
          i = m;
          continue;
          label574:
          i = j;
          if (bool1)
          {
            i = j;
            if (n > 0) {
              i = n;
            }
          }
        }
      }
    }
  }
  
  public final void dTm()
  {
    AppMethodBeat.i(177021);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114896);
        if ((l.this.mStatus != 4) && (l.this.mStatus != 5) && (l.this.mStatus != 6))
        {
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "startConnectDirect status fail, status:" + l.this.mStatus);
          AppMethodBeat.o(114896);
          return;
        }
        if (l.this.ziw)
        {
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "can not startConnectDirect again");
          AppMethodBeat.o(114896);
          return;
        }
        l.this.ziw = true;
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel direct");
        if (l.this.ziZ.zoU == null)
        {
          com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipContext", "direct conns buf null");
          AppMethodBeat.o(114896);
          return;
        }
        int i = l.this.ziZ.AddNewDirectConns(l.this.ziZ.zoU, l.this.ziZ.zoU.length, 0);
        if (i < 0)
        {
          com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipContext", "v2protocal connectToPeerDirect failed, ret:".concat(String.valueOf(i)));
          AppMethodBeat.o(114896);
          return;
        }
        l.this.dTp();
        AppMethodBeat.o(114896);
      }
    });
    AppMethodBeat.o(177021);
  }
  
  public final void dTn()
  {
    AppMethodBeat.i(177022);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114897);
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "v2protocal QueryNicWanIp");
        if ((l.this.zjo != null) && (l.this.ziZ.zoV != null))
        {
          int i = l.this.ziZ.QueryNicWanIp(l.this.ziZ.zoV, l.this.ziZ.zoV.length);
          if (i != 0) {
            com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipContext", "query nic wan ip fail ret:".concat(String.valueOf(i)));
          }
        }
        else
        {
          l.this.dTf();
          AppMethodBeat.o(114897);
          return;
        }
        AppMethodBeat.o(114897);
      }
    });
    AppMethodBeat.o(177022);
  }
  
  public final void dTo()
  {
    AppMethodBeat.i(114928);
    if (!bt.cw(this.ziZ.znt)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "channel:try start connect, hasRemotePid:" + bool + ",mStatus:" + this.mStatus + ",isPreConnect:" + this.ziB + ",isRemoteAccepted:" + this.ziy + ",isLocalAccept:" + this.duq);
      this.ziZ.zpq.zkt = 7;
      if ((!bool) || ((this.mStatus != 4) && (this.mStatus != 5) && (this.mStatus != 6) && ((this.mStatus != 2) || (this.ziB != true)) && ((this.mStatus != 3) || (this.ziB != true)))) {
        break label329;
      }
      if ((this.mStatus == 2) || (this.mStatus == 3) || (this.mStatus == 4) || (this.mStatus == 5) || (this.mStatus == 6)) {
        break;
      }
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "startConnect status fail, status:" + this.mStatus);
      AppMethodBeat.o(114928);
      return;
    }
    if ((!this.ziy) && (!this.duq))
    {
      if ((this.ziB) && (!this.ziv))
      {
        a(new d()
        {
          public final void dTr()
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
      if (!this.ziv)
      {
        a(new d()
        {
          public final void dTr()
          {
            AppMethodBeat.i(177017);
            ad.i("MicroMsg.Voip.VoipContext", "onStartConnectRelay ok");
            l.this.dTm();
            l.this.dTn();
            AppMethodBeat.o(177017);
          }
        });
        AppMethodBeat.o(114928);
        return;
      }
      dTm();
      dTn();
    }
    label329:
    AppMethodBeat.o(114928);
  }
  
  public final void dTp()
  {
    AppMethodBeat.i(114929);
    if ((this.ziw) && (!bt.cw(this.ziZ.znv)))
    {
      int i = this.ziZ.handleCommand(this.ziZ.znv, this.ziZ.znv.length);
      if (i < 0) {
        com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipContext", "v2protocal handlecommand failed ret:".concat(String.valueOf(i)));
      }
      this.ziZ.znv = null;
    }
    AppMethodBeat.o(114929);
  }
  
  public final void dTq()
  {
    AppMethodBeat.i(114934);
    ad.i("MicroMsg.Voip.VoipContext", "stop repeat voip sync");
    this.zjs.stopTimer();
    AppMethodBeat.o(114934);
  }
  
  public final int g(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(114919);
    if (paramInt < 0)
    {
      AppMethodBeat.o(114919);
      return -1;
    }
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:DisableCodec: targetCodec = " + paramInt + ", local=" + paramBoolean1 + ", remote =" + paramBoolean2);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.putInt(paramInt);
    if (paramBoolean1) {}
    try
    {
      if (this.ziZ != null)
      {
        diz localdiz = new diz();
        localdiz.Ezh = 5;
        localdiz.Ezi = new com.tencent.mm.bx.b(localByteBuffer.array());
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable local target codec: ".concat(String.valueOf(paramInt)));
        this.ziZ.SendRUDP(localdiz.toByteArray(), localdiz.toByteArray().length);
      }
      if (paramBoolean2)
      {
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable remote target codec: ".concat(String.valueOf(paramInt)));
        localByteBuffer = ByteBuffer.allocate(6);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer.putShort((short)3);
        localByteBuffer.putShort((short)paramInt);
        localByteBuffer.putShort((short)0);
        this.ziZ.setAppCmd(35, localByteBuffer.array(), 6);
      }
      AppMethodBeat.o(114919);
      return 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "DisableCodec Error");
      }
    }
  }
  
  public final void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.ziZ.zou = paramInt1;
    this.ziZ.zov = paramInt2;
    this.ziZ.zow = paramInt3;
    this.ziZ.zox = paramInt4;
    this.ziZ.zoy = paramInt5;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(114900);
    ad.i("MicroMsg.Voip.VoipContext", "reset");
    if (this.ziZ.dVA()) {
      this.ziZ.rG(false);
    }
    this.ziZ.reset();
    this.ziN = -1;
    this.ziO = -1;
    this.ziP = -1;
    this.ziQ = -1;
    this.ziR = -1;
    this.zjb.dTu();
    this.ziZ.znN = 0;
    this.zjv.stopTimer();
    this.zjc.dVf();
    this.zjs.stopTimer();
    this.ziv = false;
    this.zix = false;
    this.ziw = false;
    this.ziy = false;
    this.duq = false;
    this.ziz = false;
    this.zjd = null;
    this.zje = null;
    this.ziJ = false;
    this.ziK = false;
    this.ziL = false;
    this.ziS = false;
    this.ziT = false;
    this.ziV = false;
    this.ziU = 1;
    this.ziW = 1;
    this.zjf = false;
    this.ziX = -1;
    this.ziY = -1;
    this.ziA = false;
    this.ziB = false;
    this.ziz = false;
    this.ziv = false;
    this.ziC = false;
    this.ziM = 10;
    this.mStatus = 1;
    this.zjk = 0;
    this.zjr = 0;
    this.zjl = false;
    this.zjj = 0;
    this.zjo = null;
    this.zjp = null;
    this.zjq.clear();
    AppMethodBeat.o(114900);
  }
  
  public final void rz(boolean paramBoolean)
  {
    AppMethodBeat.i(114918);
    if (!paramBoolean)
    {
      if (this.ziZ != null)
      {
        if (this.zjm)
        {
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc: Set P2S HW Flag False!!");
          g(8, false, true);
        }
        for (;;)
        {
          ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
          localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
          localByteBuffer.putInt(6);
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc:reset maxsizeformat: 6");
          this.ziZ.setAppCmd(30, localByteBuffer.array(), 4);
          AppMethodBeat.o(114918);
          return;
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "closecodec: remote i264 enc!");
          b(8, false, true, true);
        }
      }
    }
    else
    {
      if (this.zjm)
      {
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "closeRemoteHWEnc: DecErr old!!");
        Qe(2);
        AppMethodBeat.o(114918);
        return;
      }
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipContext", "closeRemoteHWEnc: DecErr new!!");
      b(8, true, false, false);
    }
    AppMethodBeat.o(114918);
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
      this.zjv.av(60000L, 60000L);
    }
    this.mStatus = paramInt;
    AppMethodBeat.o(114907);
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(114906);
    dTq();
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114889);
        if (l.this.zja != null) {
          l.this.zja.dSz();
        }
        AppMethodBeat.o(114889);
      }
    });
    AppMethodBeat.o(114906);
  }
  
  public static abstract interface a
  {
    public abstract void I(int paramInt1, int paramInt2, String paramString);
  }
  
  static abstract interface d
  {
    public abstract void dTr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l
 * JD-Core Version:    0.7.0.1
 */