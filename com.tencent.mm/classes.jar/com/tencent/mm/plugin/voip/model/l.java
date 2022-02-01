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
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.model.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.dci;
import com.tencent.mm.protocal.protobuf.doo;
import com.tencent.mm.protocal.protobuf.drc;
import com.tencent.mm.protocal.protobuf.dru;
import com.tencent.mm.protocal.protobuf.drv;
import com.tencent.mm.protocal.protobuf.dsb;
import com.tencent.mm.protocal.protobuf.dss;
import com.tencent.mm.protocal.protobuf.dtd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
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
  private int ABA;
  private int ABB;
  public boolean ABC;
  private boolean ABD;
  private int ABE;
  private boolean ABF;
  private int ABG;
  private int ABH;
  private int ABI;
  public v2protocal ABJ;
  public x ABK;
  public n ABL;
  public w ABM;
  public byte[] ABN;
  public dsb ABO;
  public boolean ABP;
  public boolean ABQ;
  public int ABR;
  public int ABS;
  public int ABT;
  public int ABU;
  public boolean ABV;
  public boolean ABW;
  public VoipScoreState ABX;
  public Network ABY;
  public ConnectivityManager.NetworkCallback ABZ;
  public boolean ABf;
  public boolean ABg;
  public boolean ABh;
  public boolean ABi;
  public boolean ABj;
  public boolean ABk;
  public boolean ABl;
  public boolean ABm;
  public dci ABn;
  public int ABo;
  public long ABp;
  public long ABq;
  public int ABr;
  public int ABs;
  public boolean ABt;
  public boolean ABu;
  public boolean ABv;
  public int ABw;
  private int ABx;
  private int ABy;
  private int ABz;
  public LinkedList<Integer> ACa;
  public int ACb;
  public au ACc;
  Timer ACd;
  int ACe;
  private au ACf;
  private a ACg;
  public boolean dsb;
  public Context mHB;
  ao mHandler;
  public int mStatus;
  
  protected l()
  {
    AppMethodBeat.i(114899);
    this.mStatus = 1;
    this.ABf = false;
    this.ABg = false;
    this.ABh = false;
    this.ABi = false;
    this.dsb = false;
    this.ABj = false;
    this.ABk = false;
    this.ABl = false;
    this.ABm = false;
    this.ABn = new dci();
    this.ABo = 0;
    this.ABp = 0L;
    this.ABq = 0L;
    this.ABr = 0;
    this.ABs = 0;
    this.ABt = false;
    this.ABu = false;
    this.ABv = false;
    this.ABw = 10;
    this.ABx = -1;
    this.ABy = -1;
    this.ABz = -1;
    this.ABA = -1;
    this.ABB = -1;
    this.ABC = false;
    this.ABD = false;
    this.ABE = 1;
    this.ABF = false;
    this.ABG = 1;
    this.ABH = -1;
    this.ABI = -1;
    this.mHB = null;
    this.ABK = x.AFH;
    this.ABN = null;
    this.ABO = null;
    this.ABP = false;
    this.ABQ = false;
    this.ABR = 0;
    this.ABS = 0;
    this.ABT = 0;
    this.ABU = 0;
    this.ABV = false;
    this.ABW = true;
    this.ABY = null;
    this.ABZ = null;
    this.ACa = new LinkedList();
    this.ACb = 0;
    this.ACc = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(114886);
        ac.v("MicroMsg.Voip.VoipContext", "voip repeat sync");
        l.this.ABM.a(null, false, 7);
        AppMethodBeat.o(114886);
        return true;
      }
    }, true);
    this.mHandler = new ao(Looper.getMainLooper())
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
          if (l.this.ABJ.roomId == 0)
          {
            com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipContext", "JNI_DOSYNC without roomid , igored!");
            AppMethodBeat.o(114891);
            return;
          }
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "need dosync for cmd from channel...");
          localObject3 = (byte[])paramAnonymousMessage.obj;
          localObject1 = l.this.ABM;
          i = paramAnonymousMessage.arg2;
          paramAnonymousMessage = new dss();
          paramAnonymousMessage.ndI = 1;
          localObject4 = new SKBuiltinBuffer_t();
          ((SKBuiltinBuffer_t)localObject4).setBuffer((byte[])localObject3);
          paramAnonymousMessage.DVs = ((SKBuiltinBuffer_t)localObject4);
          localObject3 = new SKBuiltinBuffer_t();
          try
          {
            ((SKBuiltinBuffer_t)localObject3).setBuffer(paramAnonymousMessage.toByteArray());
            paramAnonymousMessage = new dru();
            paramAnonymousMessage.ErL = i;
            paramAnonymousMessage.ErM = ((SKBuiltinBuffer_t)localObject3);
            paramAnonymousMessage.tlK = com.tencent.mm.model.u.axw();
            localObject3 = new drv();
            ((drv)localObject3).ncL = 1;
            ((drv)localObject3).ncM.add(paramAnonymousMessage);
            ((w)localObject1).a((drv)localObject3, true, 2);
            AppMethodBeat.o(114891);
            return;
          }
          catch (IOException paramAnonymousMessage)
          {
            ac.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramAnonymousMessage, "", new Object[0]);
            AppMethodBeat.o(114891);
            return;
          }
        }
        if (paramAnonymousMessage.arg1 == 4)
        {
          if (l.this.ABJ.roomId == 0)
          {
            com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipContext", "JNI_STARTDEVFAILED without roomid , igored!");
            AppMethodBeat.o(114891);
            return;
          }
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "need hangUP for startTalk failed. ");
          l.this.ABJ.AIf.ACR = 107;
          l.this.H(1, -9004, "");
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 6)
        {
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected from JNI");
          if (l.this.ABJ.roomId == 0)
          {
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected roomid null, ignored");
            AppMethodBeat.o(114891);
            return;
          }
          l.this.ABh = true;
          l.this.ABJ.AIf.ADh = 1;
          if ((!l.this.dsb) && (!l.this.ABi)) {}
          for (l.this.ABJ.AGU = 1;; l.this.ABJ.AGU = 0)
          {
            l.this.ABJ.setInactive();
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "Voip.Channel setInactive");
            l.this.eis();
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
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "need hangUP for disconnect from channel..envent = " + paramAnonymousMessage.arg2);
          if (l.this.mStatus >= 5)
          {
            l.this.ABJ.AIf.ACR = 108;
            if (paramAnonymousMessage.arg2 != 5) {
              break label596;
            }
            l.this.ABJ.AIf.ADj = 1;
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "channel broken...");
          }
          for (;;)
          {
            l.this.H(1, -9000, "");
            AppMethodBeat.o(114891);
            return;
            l.this.ABJ.AIf.ACR = 106;
            break;
            label596:
            if (paramAnonymousMessage.arg2 == 8)
            {
              if (l.this.ABl == true)
              {
                com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "channel connect fail while pre-connect");
                l.this.ABk = true;
                AppMethodBeat.o(114891);
                return;
              }
              com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "channel connect fail...");
              l.this.ABh = false;
              l.this.ABJ.AIf.ADj = 5;
            }
          }
        }
        if (paramAnonymousMessage.arg1 == 100)
        {
          com.tencent.mm.plugin.voip.b.d.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.Voip.VoipContext", paramAnonymousMessage.arg2);
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 101)
        {
          com.tencent.mm.plugin.voip.b.d.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.v2Core", paramAnonymousMessage.arg2);
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 7)
        {
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "NOTIFY_FROM_JNI_SPEEDTESTRESULT handle");
          localObject4 = (byte[])paramAnonymousMessage.obj;
          i = paramAnonymousMessage.arg2;
          paramAnonymousMessage = null;
          try
          {
            localObject1 = ax.iL(ai.getContext());
            paramAnonymousMessage = (Message)localObject1;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "Get wifiName failed in voip speedTest!");
            }
          }
          localObject1 = null;
          try
          {
            localObject3 = ((TelephonyManager)ai.getContext().getSystemService("phone")).getSimOperatorName();
            localObject1 = localObject3;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "Get netName failed in voip speedTest!");
            }
          }
          new j(l.this.ABq, l.this.ABp, l.this.ABr, (String)localObject1, paramAnonymousMessage, l.this.ABs, i, (byte[])localObject4).ekv();
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
              localObject2 = (doo)new doo().parseFrom((byte[])localObject2);
              if ((!paramAnonymousMessage.ABV) || (((doo)localObject2).FWj != 1)) {
                com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve: onRecvRUDPCmd:" + ((doo)localObject2).FWj);
              }
              i = ((doo)localObject2).FWj;
              switch (i)
              {
              default: 
                AppMethodBeat.o(114891);
                return;
              }
            }
            catch (Exception paramAnonymousMessage)
            {
              com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "rudp cmd processing Error");
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client tells us to end HWEnc!!");
            paramAnonymousMessage.ABL.ACC = true;
            AppMethodBeat.o(114891);
            return;
            if (!paramAnonymousMessage.ABV)
            {
              com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client end HWEnc!!");
              paramAnonymousMessage.g(8, false, true);
              paramAnonymousMessage.b(4, false, true, true);
              if (((doo)localObject2).FWk == null) {
                break label1190;
              }
              localObject2 = ByteBuffer.wrap(((doo)localObject2).FWk.xy, 0, 4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              i = Math.min(((ByteBuffer)localObject2).getInt(), 6);
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(i);
              com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:CMD_VOIP_CloseHWEnc:reset maxsizeformat: ".concat(String.valueOf(i)));
              paramAnonymousMessage.ABJ.setAppCmd(30, ((ByteBuffer)localObject2).array(), 4);
            }
            for (;;)
            {
              paramAnonymousMessage.ABV = true;
              AppMethodBeat.o(114891);
              return;
              label1190:
              com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: cmdBuffer is nil!!");
            }
            if (((doo)localObject2).FWk != null)
            {
              localObject2 = ((doo)localObject2).FWk.xy;
              com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve: remote new network type:".concat(String.valueOf(localObject2)));
              i = paramAnonymousMessage.ABJ.setAppCmd(302, (byte[])localObject2, 4);
              if (i < 0) {
                com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + localObject2 + "fail:" + i + ", [roomid=" + paramAnonymousMessage.ABJ.tIN + ", roomkey=" + paramAnonymousMessage.ABJ.tIG + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
            AppMethodBeat.o(114891);
            return;
            byte[] arrayOfByte;
            if (((doo)localObject2).FWk != null)
            {
              localObject2 = ((doo)localObject2).FWk.xy;
              localObject2 = (drc)new drc().parseFrom((byte[])localObject2);
              com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "zhengxue: remote audio dev occupied stat :" + ((drc)localObject2).FYQ);
              arrayOfByte = new byte[4];
              arrayOfByte[0] = ((byte)((drc)localObject2).FYQ);
              paramAnonymousMessage.ABJ.setJNIAppCmd(2, arrayOfByte, 4);
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "zhengxue:[CHANNEL]EMethod_AudioDevOccupiedStatsSync empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((doo)localObject2).FWk != null)
            {
              localObject2 = ((doo)localObject2).FWk.xy;
              if (paramAnonymousMessage.ABJ != null)
              {
                localObject2 = ByteBuffer.wrap((byte[])localObject2);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                i = ((ByteBuffer)localObject2).getInt();
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)3);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.ABJ.setAppCmd(35, ((ByteBuffer)localObject2).array(), 6);
                com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_DisableCodec:  ".concat(String.valueOf(i)));
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_DisableCodec empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((doo)localObject2).FWk != null)
            {
              localObject2 = ((doo)localObject2).FWk.xy;
              if (paramAnonymousMessage.ABJ != null)
              {
                localObject2 = ByteBuffer.wrap((byte[])localObject2);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                i = ((ByteBuffer)localObject2).getInt();
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)3);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.ABJ.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
                com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder:  ".concat(String.valueOf(i)));
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((doo)localObject2).FWk != null)
            {
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(1);
              paramAnonymousMessage.ABJ.setAppCmd(48, ((ByteBuffer)localObject2).array(), 4);
              com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAq:  1");
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAq empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((doo)localObject2).FWk != null)
            {
              localObject2 = ((doo)localObject2).FWk.xy;
              if (paramAnonymousMessage.ABJ != null)
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
                paramAnonymousMessage.ABJ.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)2);
                ((ByteBuffer)localObject2).putShort((short)4);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.ABJ.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
              }
              for (;;)
              {
                com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder:  ".concat(String.valueOf(i)));
                AppMethodBeat.o(114891);
                return;
                label1920:
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)2);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.ABJ.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
              }
            }
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((doo)localObject2).FWk != null)
            {
              localObject2 = ((doo)localObject2).FWk.xy;
              com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "anlin: remote wx ver: ".concat(String.valueOf(localObject2)));
              i = paramAnonymousMessage.ABJ.setAppCmd(506, (byte[])localObject2, 4);
              if (i < 0) {
                com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteClientVersion] remote wx ver: " + localObject2 + "ret: " + i + ", [roomid=" + paramAnonymousMessage.ABJ.tIN + ", roomkey=" + paramAnonymousMessage.ABJ.tIG + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteClientVersion] empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((doo)localObject2).FWk != null)
            {
              arrayOfByte = ((doo)localObject2).FWk.xy;
              i = ((doo)localObject2).FWk.xy.length;
              com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "anlin: remote device model: ".concat(String.valueOf(arrayOfByte)));
              i = paramAnonymousMessage.ABJ.setAppCmd(508, arrayOfByte, i);
              if (i < 0) {
                com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteDeviceModel] remote device model: " + arrayOfByte + "ret: " + i + ", [roomid=" + paramAnonymousMessage.ABJ.tIN + ", roomkey=" + paramAnonymousMessage.ABJ.tIG + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteDeviceModel] empty buffer");
          }
        }
        if (paramAnonymousMessage.arg1 == 9)
        {
          paramAnonymousMessage = l.this.ABJ.AIf;
          if (0L == paramAnonymousMessage.ADv)
          {
            paramAnonymousMessage.ADv = System.currentTimeMillis();
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.VoipDailReport", "first pkt received timestamp:" + paramAnonymousMessage.ADv);
          }
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "get first pkt for voip");
          if (1 == l.this.ABJ.AHF)
          {
            paramAnonymousMessage = new dtd();
            paramAnonymousMessage.ndj = 1;
            l.this.ABM.a(paramAnonymousMessage, 2);
            AppMethodBeat.o(114891);
          }
        }
        else
        {
          if (paramAnonymousMessage.arg1 == 11)
          {
            l.this.ACb = 2;
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 12)
          {
            l.this.ACb = 1;
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 13)
          {
            localObject2 = (int[])paramAnonymousMessage.obj;
            i = paramAnonymousMessage.arg2;
            new com.tencent.mm.plugin.voip.model.a.h(l.this.ABJ.roomId, l.this.ABJ.tIG, l.this.ABJ.tIN, 1, i, (int[])localObject2, null).ekv();
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 14)
          {
            localObject2 = (int[])paramAnonymousMessage.obj;
            i = paramAnonymousMessage.arg2;
            new com.tencent.mm.plugin.voip.model.a.h(l.this.ABJ.roomId, l.this.ABJ.tIG, l.this.ABJ.tIN, 2, i, (int[])localObject2, null).ekv();
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 15) {
            l.this.aG(paramAnonymousMessage.arg2, false);
          }
        }
        AppMethodBeat.o(114891);
      }
    };
    this.ACd = null;
    this.ACe = 0;
    this.ACf = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(177018);
        if (l.this.mStatus == 4)
        {
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "connect time out.. now finish..");
          l.this.ABJ.AIf.ACR = 105;
          l.this.H(1, -9000, "");
        }
        AppMethodBeat.o(177018);
        return false;
      }
    }, false);
    this.ACg = null;
    this.ABJ = new v2protocal(this.mHandler);
    this.ABL = new n(this);
    this.ABL.ACH = this.ABJ.tIG;
    this.ABM = new w(this);
    this.ABU = 0;
    this.ABX = new VoipScoreState();
    AppMethodBeat.o(114899);
  }
  
  private void a(final d paramd)
  {
    AppMethodBeat.i(177020);
    if ((this.mStatus != 2) && (this.mStatus != 3) && (this.mStatus != 4))
    {
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "startConnectRelay status fail, status:" + this.mStatus);
      AppMethodBeat.o(177020);
      return;
    }
    if (this.ABf)
    {
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "can not startConnectRelay again");
      AppMethodBeat.o(177020);
      return;
    }
    l.c localc = new l.c(this, (byte)0);
    localc.ACp = new l.b()
    {
      public final void au(final int paramAnonymousInt1, final int paramAnonymousInt2, final int paramAnonymousInt3)
      {
        AppMethodBeat.i(114895);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114894);
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel relay");
            int k = l.this.ABJ.AHj;
            int m = l.this.ABJ.AHj;
            v2protocal localv2protocal = l.this.ABJ;
            int n = l.this.ABJ.AGf;
            long l1 = l.this.ABJ.roomId;
            int i1 = l.this.ABJ.tIN;
            long l2 = l.this.ABJ.tIG;
            byte[] arrayOfByte1 = l.this.ABJ.AGh;
            int i2 = l.this.ABJ.channelStrategy;
            int i3 = l.this.ABJ.AGm;
            int i4 = l.this.ABJ.AGn;
            int i5 = l.this.ABJ.AGk;
            byte[] arrayOfByte2;
            int i6;
            int i7;
            int i8;
            byte[] arrayOfByte3;
            int i9;
            int i10;
            if (l.this.ABJ.AGl == null)
            {
              i = 0;
              arrayOfByte2 = l.this.ABJ.AGl;
              i6 = l.this.ABJ.AGo;
              i7 = l.this.ABJ.AGe;
              i8 = l.this.ABJ.AHt;
              arrayOfByte3 = l.this.ABJ.AHu;
              i9 = l.this.ABJ.AHv;
              i10 = l.this.ABJ.AGp;
              if (l.this.ABJ.AGq != null) {
                break label521;
              }
            }
            label521:
            for (int j = 0;; j = l.this.ABJ.AGq.length)
            {
              i = localv2protocal.setConfigInfo(n, l1, i1, l2, arrayOfByte1, i2, i3, i4, i5, i, arrayOfByte2, i6, (k >> 2 & 0x3) >> 1 & 0x1 & (m & 0x3) >> 1 & 0x1, i7, i8, arrayOfByte3, i9, i10, j, l.this.ABJ.AGq, l.this.ABJ.AHw, paramAnonymousInt1, paramAnonymousInt3, paramAnonymousInt2, "", "", v2protocal.ekN());
              if (i >= 0) {
                break label539;
              }
              com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipContext", "v2protocal setConfigInfo or connectToPeerRelay failed, ret:".concat(String.valueOf(i)));
              l.this.ABJ.AIf.ACR = 14;
              l.this.H(1, -9002, "");
              l.11.this.ACi.eiD();
              AppMethodBeat.o(114894);
              return;
              i = l.this.ABJ.AGl.length;
              break;
            }
            label539:
            if (l.this.ABJ.AHI == null)
            {
              com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipContext", "relay conns buf null");
              l.this.H(1, -9002, "");
              l.11.this.ACi.eiD();
              AppMethodBeat.o(114894);
              return;
            }
            int i = l.this.ABJ.AddNewRelayConns(l.this.ABJ.AHI, l.this.ABJ.AHI.length, 0);
            if (i < 0)
            {
              com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipContext", "add relayconns err:".concat(String.valueOf(i)));
              l.this.H(1, -9002, "");
              l.11.this.ACi.eiD();
              AppMethodBeat.o(114894);
              return;
            }
            l.this.ABf = true;
            l.this.ABJ.AIf.ACY = 1;
            l.this.ABJ.AIf.ADg = 1;
            l.11.this.ACi.eiD();
            AppMethodBeat.o(114894);
          }
        });
        AppMethodBeat.o(114895);
      }
    };
    com.tencent.e.h.JZN.aS(localc);
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
  
  private void eip()
  {
    AppMethodBeat.i(114914);
    com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipContext", "SrvDeviceInfo.mAudioInfo.aecMode:" + ae.fJe.fDD);
    if (ae.fJe.fDf == 1) {
      this.ABJ.setAppCmd(410);
    }
    byte[] arrayOfByte = new byte[2];
    Object localObject;
    byte b;
    int i;
    int j;
    int k;
    if (ae.fJe.fDD >= 0)
    {
      arrayOfByte[0] = ((byte)ae.fJe.fDD);
      this.ABJ.setAppCmd(406, arrayOfByte, 1);
      localObject = com.tencent.mm.model.c.d.aAp().tJ("100447");
      if (((com.tencent.mm.storage.c)localObject).isValid())
      {
        m = bs.getInt((String)((com.tencent.mm.storage.c)localObject).eYV().get("SetVoipRnnNsOn"), 0);
        if (1 == m)
        {
          b = (byte)m;
          this.ABJ.setAppCmd(432, new byte[] { b }, 1);
        }
      }
      m = ae.fJe.fDE;
      ac.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.nsModeNew %d", new Object[] { Integer.valueOf(m) });
      if (ae.fJe.fDE < 0) {
        break label1923;
      }
      if (m <= 0) {
        break label1904;
      }
      int n = (int)Math.floor(m / 1000.0D) % 100;
      ac.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.iflag %d", new Object[] { Integer.valueOf(n) });
      if (n > 0)
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        this.ABJ.setAppCmd(408, (byte[])new byte[] { b, i, j, k }, 4);
      }
      label326:
      m = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pXF, -1);
      ac.i("MicroMsg.Voip.VoipContext", "kerrizhang, play_fadeinfadeout_switch = %d", new Object[] { Integer.valueOf(m) });
      localObject = new byte[1];
      localObject[0] = 0;
      if (m > 0) {
        localObject[0] = ((byte)m);
      }
      this.ABJ.setAppCmd(451, (byte[])localObject, 1);
      m = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYg, -1);
      ac.i("MicroMsg.Voip.VoipContext", "kerrizhang, fullbandmode = %d", new Object[] { Integer.valueOf(m) });
      n = ae.fJe.fDG;
      ac.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.voipfullbandcfg %d", new Object[] { Integer.valueOf(n) });
      if ((m > 0) && (n > 0))
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        this.ABJ.setAppCmd(456, (byte[])new byte[] { b, i, j, k }, 4);
      }
      m = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pXG, -1);
      ac.i("MicroMsg.Voip.VoipContext", "kerrizhang, play_fadeinfadeout_thresh = %d", new Object[] { Integer.valueOf(m) });
      localObject[0] = 0;
      if (m > 0) {
        localObject[0] = ((byte)m);
      }
      this.ABJ.setAppCmd(452, (byte[])localObject, 1);
      m = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYf, -1);
      ac.i("MicroMsg.Voip.VoipContext", "kerrizhang, voip rcnnvad_switch = %d", new Object[] { Integer.valueOf(m) });
      if (m > 0)
      {
        b = (byte)m;
        this.ABJ.setAppCmd(454, new byte[] { b }, 1);
      }
      m = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYh, 0);
      ac.i("MicroMsg.Voip.VoipContext", "dennyliang, voip aec_value = %d", new Object[] { Integer.valueOf(m) });
      if (m > 0)
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        this.ABJ.setAppCmd(460, new byte[] { b, i, j, k }, 4);
      }
      m = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYk, -1);
      ac.i("MicroMsg.Voip.VoipContext", "qipengfeng, x_agc_paras: %d", new Object[] { Integer.valueOf(m) });
      if (m > 0)
      {
        b = (byte)(m & 0x1);
        ac.i("MicroMsg.Voip.VoipContext", "qipengfeng, agc_switch: %d", new Object[] { Byte.valueOf(b) });
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
        ac.i("MicroMsg.Voip.VoipContext", "qipengfeng, agc para: %d, %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject[0]), Byte.valueOf(localObject[1]), Byte.valueOf(localObject[2]), Byte.valueOf(localObject[3]), Byte.valueOf(localObject[4]), Byte.valueOf(localObject[5]), Byte.valueOf(localObject[6]) });
        this.ABJ.setAppCmd(404, (byte[])localObject, 7);
      }
      label1092:
      if (ae.fJe.fDI < 0) {
        break label1979;
      }
      localObject = new byte[7];
      if ((ae.fJe.fDJ >= 0) && (ae.fJe.fDK >= 0))
      {
        localObject[0] = ((byte)ae.fJe.fDJ);
        localObject[1] = ((byte)ae.fJe.fDK);
        if (ae.fJe.fDL < 0) {
          break label1962;
        }
        localObject[2] = ((byte)ae.fJe.fDL);
        localObject[3] = ((byte)ae.fJe.fDI);
        localObject[4] = ((byte)ae.fJe.fDM);
        localObject[5] = ((byte)ae.fJe.fDN);
        localObject[6] = ((byte)ae.fJe.fDO);
        this.ABJ.setAppCmd(404, (byte[])localObject, 7);
      }
    }
    for (;;)
    {
      m = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pXE, -1);
      ac.i("MicroMsg.Voip.VoipContext", "qipengfeng, tryUpdateAudioAdaption, switch_flag_x = %d", new Object[] { Integer.valueOf(m) });
      localObject = new byte[1];
      localObject[0] = 0;
      if (m > 0) {
        localObject[0] = 1;
      }
      this.ABJ.setAppCmd(450, (byte[])localObject, 1);
      if ((ae.fJe.fDg >= 0) || (ae.fJe.fDi >= 0))
      {
        arrayOfByte[0] = -1;
        arrayOfByte[1] = -1;
        if (ae.fJe.fDg >= 0) {
          arrayOfByte[0] = ((byte)ae.fJe.fDg);
        }
        if (ae.fJe.fDi >= 0) {
          arrayOfByte[1] = ((byte)ae.fJe.fDi);
        }
        this.ABJ.setAppCmd(414, arrayOfByte, 2);
      }
      if ((ae.fJe.fDh >= 0) || (ae.fJe.fDj >= 0))
      {
        arrayOfByte[0] = -1;
        arrayOfByte[1] = -1;
        if (ae.fJe.fDh >= 0) {
          arrayOfByte[0] = ((byte)ae.fJe.fDh);
        }
        if (ae.fJe.fDj >= 0) {
          arrayOfByte[1] = ((byte)ae.fJe.fDj);
        }
        this.ABJ.setAppCmd(415, arrayOfByte, 2);
      }
      if ((ae.fJe.fDk >= 0) || (ae.fJe.fDl >= 0))
      {
        arrayOfByte[0] = -1;
        arrayOfByte[1] = -1;
        if (ae.fJe.fDk >= 0) {
          arrayOfByte[0] = ((byte)ae.fJe.fDk);
        }
        if (ae.fJe.fDl >= 0) {
          arrayOfByte[1] = ((byte)ae.fJe.fDl);
        }
        this.ABJ.setAppCmd(422, arrayOfByte, 2);
      }
      if (ae.fJe.fDm >= 0)
      {
        arrayOfByte[0] = ((byte)ae.fJe.fDm);
        this.ABJ.setAppCmd(416, arrayOfByte, 1);
      }
      if (ae.fJe.fDq >= 0)
      {
        arrayOfByte[0] = ((byte)ae.fJe.fDq);
        this.ABJ.setAppCmd(431, arrayOfByte, 4);
      }
      if ((ae.fJe.fDn >= 0) && ((this.ABJ.AHd != 0) || (ae.fJe.fDn != 5)))
      {
        arrayOfByte[0] = ((byte)ae.fJe.fDn);
        this.ABJ.setAppCmd(417, arrayOfByte, 1);
      }
      if ((ae.fJe.fDo >= 0) && ((this.ABJ.AHd != 0) || (ae.fJe.fDo != 5)))
      {
        arrayOfByte[0] = ((byte)ae.fJe.fDo);
        this.ABJ.setAppCmd(418, arrayOfByte, 1);
      }
      if (ae.fJe.fDp >= 0)
      {
        arrayOfByte[0] = ((byte)ae.fJe.fDp);
        this.ABJ.setAppCmd(419, arrayOfByte, 1);
      }
      if ((this.ABJ.AHd == 1) && ((ae.fJe.fDn == 5) || (ae.fJe.fDo == 5))) {
        this.ABJ.AGH = 5;
      }
      if (1 != ae.fJe.fDR) {
        break label2019;
      }
      localObject = new byte[30];
      m = 0;
      while (m < 15)
      {
        localObject[(m * 2)] = ((byte)(ae.fJe.fDS[m] & 0xFF));
        localObject[(m * 2 + 1)] = ((byte)(ae.fJe.fDS[m] >> 8 & 0xFF));
        m += 1;
      }
      if (ae.fJe.fDD != -2) {
        break;
      }
      this.ABJ.setAppCmd(407);
      break;
      label1904:
      if (m != 0) {
        break label326;
      }
      this.ABJ.setAppCmd(409);
      break label326;
      label1923:
      if (ae.fJe.fDE != -2) {
        break label326;
      }
      this.ABJ.setAppCmd(409);
      break label326;
      label1948:
      this.ABJ.setAppCmd(405);
      break label1092;
      label1962:
      this.ABJ.setAppCmd(404, (byte[])localObject, 2);
      continue;
      label1979:
      if (ae.fJe.fDI == -2) {
        this.ABJ.setAppCmd(405);
      }
    }
    this.ABJ.setAppCmd(420, (byte[])localObject, 30);
    label2019:
    if (ae.fJe.fDR == 0) {
      this.ABJ.setAppCmd(421);
    }
    if ((ae.fJe.fDT[0] > 0) || (ae.fJe.fDT[1] > 0))
    {
      arrayOfByte[0] = 0;
      arrayOfByte[1] = 0;
      if ((ae.fJe.fDT[0] > 0) && (ae.fJe.fDT[0] < 10000)) {
        arrayOfByte[0] = ((byte)ae.fJe.fDT[0]);
      }
      if ((ae.fJe.fDT[1] > 0) && (ae.fJe.fDT[1] < 10000)) {
        arrayOfByte[1] = ((byte)ae.fJe.fDT[1]);
      }
      this.ABJ.setAppCmd(423, arrayOfByte, 2);
    }
    if (ae.fJe.fDV > 0)
    {
      arrayOfByte[0] = ((byte)ae.fJe.fDV);
      this.ABJ.setAppCmd(424, arrayOfByte, 1);
    }
    int m = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYl, -1);
    ac.i("MicroMsg.Voip.VoipContext", "qipengfeng, x_agcrx_para: %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)(m & 0x1);
      ac.i("MicroMsg.Voip.VoipContext", "qipengfeng, agcrx_switch: %d", new Object[] { Byte.valueOf(b) });
      if (b > 0)
      {
        arrayOfByte = new byte[4];
        arrayOfByte[0] = ((byte)(m >> 1 & 0x3));
        arrayOfByte[1] = ((byte)(m >> 3 & 0x1F));
        arrayOfByte[2] = ((byte)(m >> 8 & 0x1F));
        arrayOfByte[3] = ((byte)(m >> 13 & 0x1));
        ac.i("MicroMsg.Voip.VoipContext", "qipengfeng, agcrx paras: %d, %d, %d, %d", new Object[] { Byte.valueOf(arrayOfByte[0]), Byte.valueOf(arrayOfByte[1]), Byte.valueOf(arrayOfByte[2]), Byte.valueOf(arrayOfByte[3]) });
        this.ABJ.setAppCmd(426, arrayOfByte, 4);
      }
    }
    if (ae.fJe.fEd >= 0)
    {
      b = (byte)ae.fJe.fEd;
      i = (byte)ae.fJe.fEe;
      j = (byte)ae.fJe.fEf;
      k = (byte)ae.fJe.fEg;
      this.ABJ.setAppCmd(426, new byte[] { b, i, j, k }, 4);
    }
    AppMethodBeat.o(114914);
  }
  
  private static int eiw()
  {
    AppMethodBeat.i(184050);
    String str1 = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbn, "");
    if (!bs.isNullOrNil(str1)) {
      try
      {
        com.tencent.mm.ab.i locali = new com.tencent.mm.ab.i(str1);
        String str2 = Build.MANUFACTURER;
        int i = locali.optInt(str2, -1);
        ac.i("MicroMsg.Voip.VoipContext", "checkVoipBeautyManufactureConfig, config:%s, manufacture:%s, beautyCmd:%s", new Object[] { str1, str2, Integer.valueOf(i) });
        if (i >= 0)
        {
          AppMethodBeat.o(184050);
          return i;
        }
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.Voip.VoipContext", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(184050);
    return 0;
  }
  
  private int sB(boolean paramBoolean)
  {
    AppMethodBeat.i(208331);
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "EnableAq: SetAqFlag =44, aqBlur=".concat(String.valueOf(paramBoolean)));
    ByteBuffer localByteBuffer;
    if (paramBoolean)
    {
      localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putInt(1);
    }
    try
    {
      if (this.ABJ != null)
      {
        doo localdoo = new doo();
        localdoo.FWj = 10;
        localdoo.FWk = new com.tencent.mm.bw.b(localByteBuffer.array());
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "EnableAq: SetAqFlag =44, aqBlur=".concat(String.valueOf(paramBoolean)));
        this.ABJ.SendRUDP(localdoo.toByteArray(), localdoo.toByteArray().length);
      }
      localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putInt(1);
      this.ABJ.setAppCmd(44, localByteBuffer.array(), 4);
      AppMethodBeat.o(208331);
      return 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "EnableAq Error");
      }
    }
  }
  
  public final void H(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(114937);
    eiC();
    if (this.ACg != null) {
      this.ACg.H(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(114937);
  }
  
  public final void Si(int paramInt)
  {
    AppMethodBeat.i(114903);
    this.ABJ.AGv = Math.abs(paramInt);
    AppMethodBeat.o(114903);
  }
  
  public final void Sj(int paramInt)
  {
    AppMethodBeat.i(114904);
    this.ABJ.AGw = Math.abs(paramInt);
    if (paramInt != 1) {
      this.ABK.dgi();
    }
    AppMethodBeat.o(114904);
  }
  
  public final void Sk(int paramInt)
  {
    this.ABJ.AGz = paramInt;
  }
  
  public final void Sl(int paramInt)
  {
    AppMethodBeat.i(114910);
    if ((8 == paramInt) || (9 == paramInt)) {
      this.ABB = paramInt;
    }
    for (;;)
    {
      if ((1 == paramInt) || (3 == paramInt)) {
        Sm(2);
      }
      this.ABK.RY(paramInt);
      AppMethodBeat.o(114910);
      return;
      this.ABz = paramInt;
      this.ABx = paramInt;
    }
  }
  
  public final void Sm(int paramInt)
  {
    AppMethodBeat.i(114911);
    if ((8 == paramInt) || (9 == paramInt)) {
      this.ABA = paramInt;
    }
    for (;;)
    {
      this.ABM.SC(paramInt);
      AppMethodBeat.o(114911);
      return;
      this.ABx = paramInt;
      this.ABy = paramInt;
    }
  }
  
  public final void Sn(int paramInt)
  {
    AppMethodBeat.i(114925);
    try
    {
      doo localdoo = new doo();
      localdoo.FWj = paramInt;
      if (1 == paramInt)
      {
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:send maxsizeformat: !!6");
        ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer.putInt(6);
        localdoo.FWk = new com.tencent.mm.bw.b(localByteBuffer.array());
        this.ABJ.setAppCmd(32, localByteBuffer.array(), 4);
      }
      for (;;)
      {
        this.ABJ.SendRUDP(localdoo.toByteArray(), localdoo.toByteArray().length);
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: send RUDP data to close remote HW encoding!Type:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(114925);
        return;
        localdoo.FWk = null;
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "onVoipSendCloseHWEncCmd Error");
      AppMethodBeat.o(114925);
    }
  }
  
  public final void So(int paramInt)
  {
    AppMethodBeat.i(114926);
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "zhengxue: audio device occupied stat sync stat " + paramInt + " app 1");
    try
    {
      Object localObject = new byte[4];
      localObject[0] = ((byte)paramInt);
      this.ABJ.setJNIAppCmd(2, (byte[])localObject, 4);
      localObject = new drc();
      ((drc)localObject).FYQ = paramInt;
      ((drc)localObject).FYR = 1;
      doo localdoo = new doo();
      localdoo.FWj = 4;
      localdoo.FWk = new com.tencent.mm.bw.b(((drc)localObject).toByteArray(), 0, 1);
      this.ABJ.SendRUDP(localdoo.toByteArray(), localdoo.toByteArray().length);
      AppMethodBeat.o(114926);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "onAudioDevOccupiedStat Error");
      AppMethodBeat.o(114926);
    }
  }
  
  public final void Sp(int paramInt)
  {
    this.ABJ.AHv = paramInt;
  }
  
  public final void Sq(int paramInt)
  {
    this.ABJ.AHo = paramInt;
  }
  
  public final void Sr(int paramInt)
  {
    this.ABJ.AIf.ACX = 1;
    this.ABJ.channelStrategy = paramInt;
  }
  
  public final void Ss(int paramInt)
  {
    this.ABJ.AGo = paramInt;
  }
  
  public final void a(a parama)
  {
    if (parama != null) {
      this.ACg = parama;
    }
  }
  
  public final void a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.ABJ.AGk = paramInt1;
    this.ABJ.AGl = paramArrayOfByte1;
    this.ABJ.AHt = paramInt2;
    this.ABJ.AHu = paramArrayOfByte2;
  }
  
  public final boolean a(dsb paramdsb)
  {
    this.ABO = paramdsb;
    this.ABJ.fTK = this.ABO.FZq;
    this.ABJ.roomId = this.ABO.Exf;
    this.ABJ.tIG = this.ABO.Exg;
    this.ABJ.tIN = 1;
    this.ABJ.AGf = 0;
    this.mStatus = 3;
    return true;
  }
  
  public final void aG(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(114921);
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "start bindSocket " + paramInt + " ToNetwork " + this.ABY + " rebind " + paramBoolean);
    if ((this.ABY != null) && (com.tencent.mm.compatible.util.d.kZ(23)))
    {
      FileDescriptor localFileDescriptor = new FileDescriptor();
      try
      {
        Field localField = FileDescriptor.class.getDeclaredField("descriptor");
        localField.setAccessible(true);
        localField.setInt(localFileDescriptor, paramInt);
        this.ABY.bindSocket(localFileDescriptor);
        if (!paramBoolean) {
          this.ACa.add(Integer.valueOf(paramInt));
        }
        com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipContext", "bindSocketToNetwork success: network" + this.ABY + "+socketfd" + paramInt);
        AppMethodBeat.o(114921);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "bindSocketToNetwork Error");
      }
    }
    AppMethodBeat.o(114921);
  }
  
  public final int aW(LinkedList<bxf> paramLinkedList)
  {
    int j = 0;
    AppMethodBeat.i(114936);
    Object localObject = new LinkedList();
    int k = this.ABJ.aX((LinkedList)localObject);
    int i = j;
    if (k == 0)
    {
      if ((((LinkedList)localObject).size() == 0) || (((LinkedList)localObject).size() > 2))
      {
        AppMethodBeat.o(114936);
        return 0;
      }
      if ((((bxf)((LinkedList)localObject).get(0)).FlZ == 1) && (((bxf)((LinkedList)localObject).get(0)).Fmb == 5))
      {
        paramLinkedList.add(((LinkedList)localObject).get(0));
        this.ABJ.AGM = 1;
        AppMethodBeat.o(114936);
        return 0;
      }
      paramLinkedList.add(((LinkedList)localObject).get(0));
      this.ABJ.AGL = 1;
      if (!a((ConnectivityManager)ai.getContext().getSystemService("connectivity")))
      {
        ac.i("MicroMsg.Voip.VoipContext", "mobile network not connectedorconnecting");
        AppMethodBeat.o(114936);
        return 0;
      }
      localObject = ((TelephonyManager)ai.getContext().getSystemService("phone")).getSimOperator();
      if ((localObject == null) || (((String)localObject).length() < 3))
      {
        ac.i("MicroMsg.Voip.VoipContext", "nic_op NULL");
        AppMethodBeat.o(114936);
        return 0;
      }
      bxf localbxf = new bxf();
      localbxf.ERk = "android-cellular";
      localbxf.FlZ = 0;
      localbxf.Fmb = 5;
      localbxf.Fma = (((String)localObject).substring(0, 3) + ":" + ((String)localObject).substring(3, ((String)localObject).length()));
      paramLinkedList.add(localbxf);
      this.ABJ.AGM = 1;
      i = j;
    }
    while (i < paramLinkedList.size())
    {
      ac.d("MicroMsg.Voip.VoipContext", "nic_name:" + ((bxf)paramLinkedList.get(i)).ERk + " nic_role:" + ((bxf)paramLinkedList.get(i)).FlZ + " net_type:" + ((bxf)paramLinkedList.get(i)).Fmb + " nic_isp_info:" + ((bxf)paramLinkedList.get(i)).Fma);
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
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "CloseCodec: targetCodec =" + paramInt + ", local=" + paramBoolean1 + ", remote =" + paramBoolean2 + "encTag=" + paramBoolean3);
    ByteBuffer localByteBuffer1;
    if ((paramBoolean1) && (paramBoolean3))
    {
      localByteBuffer1 = ByteBuffer.allocate(4);
      localByteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer1.putInt(paramInt);
    }
    for (;;)
    {
      doo localdoo;
      try
      {
        if (this.ABJ != null)
        {
          localdoo = new doo();
          localdoo.FWj = 6;
          localdoo.FWk = new com.tencent.mm.bw.b(localByteBuffer1.array());
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(paramInt)));
          this.ABJ.SendRUDP(localdoo.toByteArray(), localdoo.toByteArray().length);
        }
        localByteBuffer1 = ByteBuffer.allocate(6);
        localByteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer1.putShort((short)2);
        localByteBuffer1.putShort((short)paramInt);
        localByteBuffer1.putShort((short)0);
        this.ABJ.setAppCmd(39, localByteBuffer1.array(), 6);
        AppMethodBeat.o(184049);
        return 1;
      }
      catch (Exception localException1)
      {
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        continue;
      }
      if ((paramBoolean1) && (!paramBoolean3))
      {
        ByteBuffer localByteBuffer2 = ByteBuffer.allocate(6);
        localByteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer2.putShort((short)0);
        localByteBuffer2.putShort((short)paramInt);
        localByteBuffer2.putShort((short)0);
        this.ABJ.setAppCmd(39, localByteBuffer2.array(), 6);
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
          if (this.ABJ == null) {
            continue;
          }
          localdoo = new doo();
          localdoo.FWj = 7;
          localdoo.FWk = new com.tencent.mm.bw.b(localByteBuffer2.array());
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(i)));
          this.ABJ.SendRUDP(localdoo.toByteArray(), localdoo.toByteArray().length);
        }
        catch (Exception localException2)
        {
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        }
      }
      else if ((paramBoolean2) && (paramBoolean3))
      {
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:disable remote target codec: ".concat(String.valueOf(paramInt)));
        ByteBuffer localByteBuffer3 = ByteBuffer.allocate(6);
        localByteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer3.putShort((short)3);
        localByteBuffer3.putShort((short)paramInt);
        localByteBuffer3.putShort((short)0);
        this.ABJ.setAppCmd(39, localByteBuffer3.array(), 6);
        localByteBuffer3 = ByteBuffer.allocate(4);
        localByteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer3.putInt(paramInt);
        try
        {
          if (this.ABJ != null)
          {
            localdoo = new doo();
            localdoo.FWj = 7;
            localdoo.FWk = new com.tencent.mm.bw.b(localByteBuffer3.array());
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(paramInt)));
            this.ABJ.SendRUDP(localdoo.toByteArray(), localdoo.toByteArray().length);
          }
        }
        catch (Exception localException3)
        {
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        }
      }
    }
  }
  
  public final void bI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114930);
    ac.i("MicroMsg.Voip.VoipContext", "updateRemotePid");
    this.ABJ.AIf.ACW = 1;
    this.ABJ.AIf.ACV = 1;
    this.ABJ.AGh = paramArrayOfByte;
    AppMethodBeat.o(114930);
  }
  
  public final void bJ(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    AppMethodBeat.i(114932);
    ac.i("MicroMsg.Voip.VoipContext", "updateRemoteCapInfo, isGotCapInfo: %s", new Object[] { Byte.valueOf(this.ABJ.AIf.ADa) });
    if ((this.ABJ.AIf.ADa == 1) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(114932);
      return;
    }
    this.ABJ.AIf.ADa = 1;
    this.ABJ.AGi = paramArrayOfByte;
    if (this.ABJ.AGi != null)
    {
      int i = this.ABJ.exchangeCabInfo(this.ABJ.AGi, this.ABJ.AGi.length);
      if ((this.ABJ.AGi == null) || (this.ABJ.AGi.length < 36)) {
        bool = true;
      }
      this.ABW = bool;
      if (i < 0)
      {
        com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipContext", "protocal exchangecabinfo failed ret:".concat(String.valueOf(i)));
        this.ABJ.AIf.ACR = 15;
        H(1, -9003, "");
      }
    }
    AppMethodBeat.o(114932);
  }
  
  public final void bK(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114933);
    this.ABJ.AGj = paramArrayOfByte;
    eiB();
    AppMethodBeat.o(114933);
  }
  
  public final void c(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.ABJ.AHA = paramInt;
    this.ABJ.AHB = paramArrayOfByte1;
    this.ABJ.AHC = paramArrayOfByte2;
  }
  
  public final void eiA()
  {
    AppMethodBeat.i(114928);
    if (!bs.cv(this.ABJ.AGh)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "channel:try start connect, hasRemotePid:" + bool + ",mStatus:" + this.mStatus + ",isPreConnect:" + this.ABl + ",isRemoteAccepted:" + this.ABi + ",isLocalAccept:" + this.dsb);
      this.ABJ.AIf.ADd = 7;
      if ((!bool) || ((this.mStatus != 4) && (this.mStatus != 5) && (this.mStatus != 6) && ((this.mStatus != 2) || (this.ABl != true)) && ((this.mStatus != 3) || (this.ABl != true)))) {
        break label329;
      }
      if ((this.mStatus == 2) || (this.mStatus == 3) || (this.mStatus == 4) || (this.mStatus == 5) || (this.mStatus == 6)) {
        break;
      }
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "startConnect status fail, status:" + this.mStatus);
      AppMethodBeat.o(114928);
      return;
    }
    if ((!this.ABi) && (!this.dsb))
    {
      if ((this.ABl) && (!this.ABf))
      {
        a(new d()
        {
          public final void eiD()
          {
            AppMethodBeat.i(177016);
            ac.i("MicroMsg.Voip.VoipContext", "onStartConnectRelay ok");
            AppMethodBeat.o(177016);
          }
        });
        AppMethodBeat.o(114928);
      }
    }
    else
    {
      if (!this.ABf)
      {
        a(new d()
        {
          public final void eiD()
          {
            AppMethodBeat.i(177017);
            ac.i("MicroMsg.Voip.VoipContext", "onStartConnectRelay ok");
            l.this.eiy();
            l.this.eiz();
            AppMethodBeat.o(177017);
          }
        });
        AppMethodBeat.o(114928);
        return;
      }
      eiy();
      eiz();
    }
    label329:
    AppMethodBeat.o(114928);
  }
  
  public final void eiB()
  {
    AppMethodBeat.i(114929);
    if ((this.ABg) && (!bs.cv(this.ABJ.AGj)))
    {
      int i = this.ABJ.handleCommand(this.ABJ.AGj, this.ABJ.AGj.length);
      if (i < 0) {
        com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipContext", "v2protocal handlecommand failed ret:".concat(String.valueOf(i)));
      }
      this.ABJ.AGj = null;
    }
    AppMethodBeat.o(114929);
  }
  
  public final void eiC()
  {
    AppMethodBeat.i(114934);
    ac.i("MicroMsg.Voip.VoipContext", "stop repeat voip sync");
    this.ACc.stopTimer();
    AppMethodBeat.o(114934);
  }
  
  public final void eif()
  {
    int k = 0;
    AppMethodBeat.i(114901);
    if ((this.ABf == true) && (this.ABo == 0))
    {
      this.ABo = 1;
      if (this.ABJ.field_speedTestInfoLength < 8)
      {
        com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! bufsize=" + this.ABJ.field_speedTestInfoLength);
        AppMethodBeat.o(114901);
      }
    }
    else
    {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipContext", "StartVoipSpeedTest fail for status is wrong: isChannelStartConnect=" + this.ABf + " ,mSpeedTestStatus=" + this.ABo);
      AppMethodBeat.o(114901);
      return;
    }
    int i = this.ABJ.AId[1];
    if (i + 2 > this.ABJ.field_speedTestInfoLength)
    {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i + ", bufsize=" + this.ABJ.field_speedTestInfoLength);
      AppMethodBeat.o(114901);
      return;
    }
    int j = this.ABJ.AId[(i + 2 + 1)];
    if (i + 6 + j != this.ABJ.field_speedTestInfoLength)
    {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i + ", C2SRttCnt=" + j + ", bufsize=" + this.ABJ.field_speedTestInfoLength);
      AppMethodBeat.o(114901);
      return;
    }
    this.ABp = this.ABJ.tIG;
    this.ABr = this.ABJ.netType;
    this.ABs = this.ABJ.roomId;
    this.ABn.Exf = this.ABJ.roomId;
    this.ABn.FLI = this.ABJ.AGu;
    this.ABn.EqS = this.ABJ.netType;
    dci localdci = this.ABn;
    if (this.ABf == true)
    {
      i = 1;
      localdci.FLJ = i;
      localdci = this.ABn;
      if (this.ABh != true) {
        break label482;
      }
    }
    label482:
    for (i = 1;; i = 0)
    {
      localdci.FLK = i;
      this.ABn.FLL = this.ABJ.AId[0];
      this.ABn.FLM = this.ABJ.AId[1];
      j = 0;
      i = 2;
      while (j < this.ABn.FLM)
      {
        this.ABn.FLN.add(Integer.valueOf(this.ABJ.AId[i]));
        j += 1;
        i += 1;
      }
      i = 0;
      break;
    }
    localdci = this.ABn;
    int[] arrayOfInt = this.ABJ.AId;
    j = i + 1;
    localdci.FLO = arrayOfInt[i];
    localdci = this.ABn;
    arrayOfInt = this.ABJ.AId;
    i = j + 1;
    localdci.FLP = arrayOfInt[j];
    j = k;
    while (j < this.ABn.FLP)
    {
      this.ABn.FLQ.add(Integer.valueOf(this.ABJ.AId[i]));
      j += 1;
      i += 1;
    }
    this.ABn.FLR = this.ABJ.AId[i];
    this.ABn.FLS = this.ABJ.AId[(i + 1)];
    new com.tencent.mm.plugin.voip.model.a.k(this.ABn).ekv();
    AppMethodBeat.o(114901);
  }
  
  public final void eig()
  {
    AppMethodBeat.i(114902);
    if (this.ABo == 0)
    {
      AppMethodBeat.o(114902);
      return;
    }
    if (this.ABo == 1)
    {
      this.ABo = 0;
      this.ABJ.AHN = 0L;
      AppMethodBeat.o(114902);
      return;
    }
    this.ABo = 0;
    v2protocal localv2protocal = this.ABJ;
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "v2protocal StopVoipSpeedTest!");
    localv2protocal.StopSpeedTest();
    localv2protocal.AHN = 0L;
    AppMethodBeat.o(114902);
  }
  
  public final void eih()
  {
    AppMethodBeat.i(114905);
    this.ABJ.AGx = this.ABL.eiF();
    this.ABJ.AGy = this.ABL.ehj();
    AppMethodBeat.o(114905);
  }
  
  public final int eii()
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
  
  public final boolean eij()
  {
    return (this.mStatus == 2) || (this.mStatus == 4);
  }
  
  public final boolean eik()
  {
    return this.mStatus == 3;
  }
  
  public final boolean eil()
  {
    AppMethodBeat.i(114908);
    ac.d("MicroMsg.Voip.VoipContext", "isWorking, status: %d", new Object[] { Integer.valueOf(this.mStatus) });
    if (this.mStatus == 1)
    {
      AppMethodBeat.o(114908);
      return false;
    }
    AppMethodBeat.o(114908);
    return true;
  }
  
  public final long eim()
  {
    return this.ABJ.AGu;
  }
  
  public final boolean ein()
  {
    if (this.ABv) {
      return false;
    }
    switch (this.ABx)
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
        } while (4 == this.ABy);
        return false;
      } while ((4 == this.ABy) || (-1 == this.ABy));
      return false;
      if ((5 == this.ABy) || (6 == this.ABy)) {
        break;
      }
    } while (7 != this.ABy);
    return false;
  }
  
  public final boolean eio()
  {
    if (this.ABv) {
      return false;
    }
    switch (this.ABx)
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
        } while (4 == this.ABy);
        return false;
      } while ((4 == this.ABz) || (this.ABz == 0) || (-1 == this.ABz));
      return false;
      if ((5 == this.ABz) || (6 == this.ABz)) {
        break;
      }
    } while (7 != this.ABz);
    return false;
  }
  
  public final void eiq()
  {
    AppMethodBeat.i(114915);
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "In networkRequestViaCellular");
    if (com.tencent.mm.compatible.util.d.kZ(21))
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)ai.getContext().getSystemService("connectivity");
      Object localObject = new NetworkRequest.Builder();
      ((NetworkRequest.Builder)localObject).addTransportType(0);
      ((NetworkRequest.Builder)localObject).addCapability(12);
      localObject = ((NetworkRequest.Builder)localObject).build();
      try
      {
        localConnectivityManager.requestNetwork((NetworkRequest)localObject, new l.7(this));
        AppMethodBeat.o(114915);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "missing the appropriate permissions");
        this.ABJ.AGN = 2;
        AppMethodBeat.o(114915);
        return;
      }
    }
    AppMethodBeat.o(114915);
  }
  
  public final void eir()
  {
    AppMethodBeat.i(114916);
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "try to UnregisterCellularNetwork");
    ConnectivityManager localConnectivityManager;
    if (com.tencent.mm.compatible.util.d.kZ(21))
    {
      localConnectivityManager = (ConnectivityManager)ai.getContext().getSystemService("connectivity");
      if (this.ABZ == null) {}
    }
    try
    {
      localConnectivityManager.unregisterNetworkCallback(this.ABZ);
      this.ABZ = null;
      this.ABY = null;
      AppMethodBeat.o(114916);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "unregisterNetworkCallback Error");
      }
    }
  }
  
  public final void eis()
  {
    AppMethodBeat.i(114917);
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: try start talk");
    if ((this.ABj != true) || (this.ABh != true))
    {
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: fail isCanSendData " + this.ABj + ", isChannelConnectedSuccess " + this.ABh);
      AppMethodBeat.o(114917);
      return;
    }
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "Voip tryStartTalk, channel setActive");
    this.ABJ.setActive();
    if (this.ABm == true)
    {
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: engine already started, isEngineStarted " + this.ABm);
      AppMethodBeat.o(114917);
      return;
    }
    this.ABJ.setSvrConfig(205, 0, 0, this.ABJ.AHw, 0, 0, 0, 0, null);
    this.ABJ.setSvrConfig(207, 0, 0, this.ABJ.AGp, 0, 0, 0, 0, null);
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.ABJ.AHw + " SwitchFlag = " + this.ABJ.AGp);
    this.ABJ.AGs[0] = ((byte)ae.fJo.fFX);
    this.ABJ.AGs[1] = ((byte)ae.fJo.fFY);
    this.ABJ.AGs[2] = ((byte)ae.fJo.fFZ);
    this.ABJ.AGs[3] = ((byte)ae.fJo.fGa);
    this.ABJ.AGs[4] = ((byte)ae.fJo.fGb);
    this.ABJ.AGs[5] = ((byte)ae.fJo.fGc);
    this.ABJ.AGs[6] = ((byte)ae.fJo.fGd);
    this.ABJ.AGs[7] = ((byte)ae.fJo.fGe);
    this.ABJ.AGs[8] = ((byte)ae.fJo.fGf);
    this.ABJ.AGs[9] = ((byte)ae.fJo.fGg);
    this.ABJ.setSvrConfig(209, 0, 0, 0, 0, 0, 0, this.ABJ.AGs.length, this.ABJ.AGs);
    if (this.ABJ.startEngine() == 0) {
      this.ABJ.AIf.ADr = 0;
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
      if (this.ABJ.AGr != null) {
        if (this.ABJ.AGr.length < 1024)
        {
          this.ABJ.setSvrConfig(208, 0, 0, 0, 0, 0, 0, this.ABJ.AGr.length, this.ABJ.AGr);
          eip();
          if ((ein()) || (eio())) {
            break label2825;
          }
          eiv();
          this.ABK.ehM();
          localObject1 = this.ABL;
          if (((n)localObject1).osN != 2) {
            break label2883;
          }
          com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipDeviceHandler", "dev start already...");
          localObject1 = this.ABJ.AIf;
          if (((o)localObject1).beginTime != 0L) {
            break label3445;
          }
          ((o)localObject1).ADk = 0;
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + ((o)localObject1).beginTime + ", CurrentTime: " + System.currentTimeMillis());
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.VoipDailReport", "devin:endNewDial:" + ((o)localObject1).ADk);
          this.ABK.onConnected();
          this.mStatus = 5;
          localObject1 = this.ABJ.AIf;
          ((o)localObject1).ADs = System.currentTimeMillis();
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.VoipDailReport", "devin:beginTalk:" + ((o)localObject1).ADs);
          this.ABJ.setSvrConfig(202, this.ABJ.AGV, this.ABJ.AGW, 0, 0, 0, 0, 0, null);
          this.ABJ.setSvrConfig(203, 0, 0, this.ABJ.AHa, 0, 0, 0, 0, null);
          this.ABJ.setSvrConfig(206, 0, 0, this.ABJ.AHe, 0, 0, 0, 0, null);
          this.ABJ.setSvrConfig(103, this.ABJ.AGX, this.ABJ.AGY, this.ABJ.AGZ, this.ABJ.AHc, 0, 0, 0, null);
          this.ABJ.setSvrConfig(205, 0, 0, this.ABJ.AHw, 0, 0, 0, 0, null);
          this.ABJ.setSvrConfig(207, 0, 0, this.ABJ.AGp, 0, 0, 0, 0, null);
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.ABJ.AHw + " SwitchFlag = " + this.ABJ.AGp);
          j = this.ABJ.AHj >> 2 & 0x3;
          k = this.ABJ.AHj & 0x3;
          if (this.ABJ.tIN != 0) {
            break label3463;
          }
          j = (j << 2) + k;
          this.ABJ.setSvrConfig(502, 0, 0, j, 0, 0, 0, 0, null);
          this.ABJ.setSvrConfig(503, 0, 0, this.ABJ.AHk, this.ABJ.AHl, this.ABJ.AHm, this.ABJ.AHn, 0, null);
          if ((this.ABJ.AHB != null) && (this.ABJ.AHC != null))
          {
            this.ABJ.setSvrConfig(504, 0, 0, this.ABJ.AHA, 0, 0, 0, 0, null);
            this.ABJ.setSvrConfig(505, 0, 0, this.ABJ.AHB[0], this.ABJ.AHB[1], this.ABJ.AHB[2], this.ABJ.AHB[3], 0, null);
            this.ABJ.setSvrConfig(506, 0, 0, this.ABJ.AHC[0], this.ABJ.AHC[1], 0, 0, 0, null);
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "FECSvrCtr = " + this.ABJ.AHA + ",FECKeyPara1 = " + this.ABJ.AHB[0] + "," + this.ABJ.AHB[1] + "," + this.ABJ.AHB[2] + "," + this.ABJ.AHB[3] + ",FECKeyPara2 = " + this.ABJ.AHC[0] + "," + this.ABJ.AHC[1]);
          }
          k = this.ABJ.AHo;
          m = this.ABJ.AHo;
          n = this.ABJ.AHo;
          this.ABJ.setSvrConfig(507, 0, 0, (k & 0x4) >> 2, (m & 0x2) >> 1, n & 0x1, 0, 0, null);
          this.ABJ.setjbmbitraterssvrparam();
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "zhengxue[Logic] setSvrConfig brefore onStartTalk: audioTsdfBeyond3G = " + this.ABJ.AGV + ",audioTsdEdge = " + this.ABJ.AGW + ",passthroughQosAlgorithm = " + this.ABJ.AGX + ",fastPlayRepair = " + this.ABJ.AGY + ", audioDTX = " + this.ABJ.AHa + ", mARQFlag = " + j + ", mQosStrategy = " + this.ABJ.AHo + ", mSvrCfgListV = " + this.ABJ.AGZ + ", maxBRForRelay = " + this.ABJ.AHc);
          localObject1 = new byte[2];
          localObject1[0] = ((byte)ae.fJd.fFf);
          localObject1[1] = -1;
          com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipContext", "steve: Model Name: " + Build.MODEL);
          com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipContext", "steve: Image Enhancement for Android Capture!!, mode: " + localObject1[0]);
          this.ABJ.setAppCmd(15, (byte[])localObject1, 1);
          com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipContext", "anlin: ClientVersion: " + com.tencent.mm.protocal.d.DIc);
          localObject1 = ByteBuffer.allocate(4);
          ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN).putInt(com.tencent.mm.protocal.d.DIc);
          localObject1 = ((ByteBuffer)localObject1).array();
          this.ABJ.setAppCmd(505, (byte[])localObject1, 4);
        }
      }
      label3463:
      try
      {
        if (this.ABJ != null)
        {
          ??? = new doo();
          ((doo)???).FWj = 8;
          ((doo)???).FWk = new com.tencent.mm.bw.b((byte[])localObject1);
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "anlin send local client version: ".concat(String.valueOf(localObject1)));
          this.ABJ.SendRUDP(((doo)???).toByteArray(), ((doo)???).toByteArray().length);
        }
        localObject1 = Build.MODEL;
        j = ((String)localObject1).length();
        localObject1 = ((String)localObject1).getBytes();
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "anlin DeviceModel: ".concat(String.valueOf(localObject1)));
        this.ABJ.setAppCmd(507, (byte[])localObject1, j);
      }
      catch (Exception localException1)
      {
        label2825:
        label3506:
        label3639:
        try
        {
          if (this.ABJ != null)
          {
            ??? = new doo();
            ((doo)???).FWj = 9;
            ((doo)???).FWk = new com.tencent.mm.bw.b((byte[])localObject1);
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "anlin send local device model: ".concat(String.valueOf(localObject1)));
            this.ABJ.SendRUDP(((doo)???).toByteArray(), ((doo)???).toByteArray().length);
          }
          if ((this.ABJ.AGp >> 17 & 0x1) != 0)
          {
            bool1 = true;
            if ((this.ABJ.AGp >> 18 & 0x1) == 0) {
              break label3506;
            }
            bool2 = true;
            sB(bool1);
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "EnableBlur: SetBlurFlag =47, aqBlur=".concat(String.valueOf(bool2)));
            if (bool2)
            {
              localObject1 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject1).putInt(1);
              this.ABJ.setAppCmd(47, ((ByteBuffer)localObject1).array(), 4);
            }
            if ((this.ABJ.AGp & 0x2) == 0)
            {
              g(16, true, true);
              g(4, true, true);
            }
            j = this.ABJ.AGp >> 12 & 0x1;
            localObject1 = ByteBuffer.allocate(4);
            ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
            ((ByteBuffer)localObject1).putInt(j);
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "weiranli set MixVcodec1 from svr = ".concat(String.valueOf(j)));
            this.ABJ.setAppCmd(46, ((ByteBuffer)localObject1).array(), 4);
            if ((this.ABJ.AGp & 0x200) == 0)
            {
              localObject1 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject1).putInt(8);
              com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "jcchen Disable 720p from svr: mSwitchFlag = " + this.ABJ.AGp);
              this.ABJ.setAppCmd(32, ((ByteBuffer)localObject1).array(), 4);
              this.ABJ.setAppCmd(30, ((ByteBuffer)localObject1).array(), 4);
            }
            if ((this.ABJ.AGp & 0x100000) != 1) {
              break label3512;
            }
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "setAppCmd: EMethodSetP2SSendThreadEnable enble, mSwitchFlag: " + this.ABJ.AGp);
            this.ABJ.setAppCmd(52);
            if (ab.iwu == 0) {
              break label3544;
            }
            localObject1 = ByteBuffer.allocate(4);
            ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
            ((ByteBuffer)localObject1).putInt(ab.iwu);
            this.ABJ.setAppCmd(36, ((ByteBuffer)localObject1).array(), 4);
            localObject1 = new byte[4];
            this.ABJ.setAppCmd(26, (byte[])localObject1, 4);
            localObject1 = ByteBuffer.wrap((byte[])localObject1);
            ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
            m = ((ByteBuffer)localObject1).getInt();
            com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipContext", "steve: iHW: ".concat(String.valueOf(m)));
            if (((this.ABJ.AGZ & 0x4) == 0) && (ae.fJd.fFh <= 0)) {
              break label3639;
            }
            j = 1;
            if ((j == 0) && (this.ABJ.ouI))
            {
              com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:Server Disable HW enc/dec!!");
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
                this.ABL.ACC = true;
                sA(false);
              }
              this.ABJ.ouI = false;
            }
            if (this.ABJ.ouI)
            {
              ??? = this.ABJ;
              n = ae.fJd.fFh;
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
                ((v2protocal)???).AIi = new e(((v2protocal)???).width, ((v2protocal)???).height, ((v2protocal)???).AIk, ((v2protocal)???).bitrate, n, (String)localObject1);
                com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "steve : create HW encoder successfully:".concat(String.valueOf(localObject1)));
                if (v2protocal.AIl != null)
                {
                  v2protocal.AIj = new d(v2protocal.AIl);
                  com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "steve : create HW decoder successfully!");
                }
                bool1 = true;
                if ((((v2protocal)???).AIi == null) || (v2protocal.AIj == null))
                {
                  ((v2protocal)???).ouI = false;
                  bool1 = false;
                }
              }
              com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve: HW encoder/decoder init ret: " + bool1 + ", iHW:" + m);
              if (!this.ABJ.ouI)
              {
                com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve: HW dec/enc NOT supported for both sides,end HWEnc!!");
                this.ABL.ACC = true;
                sA(false);
                b(8, true, false, true);
                b(8, true, false, false);
              }
            }
            if (this.ABJ.AIi != null) {
              this.ABJ.AIi.Ayh = this;
            }
            if (v2protocal.AIj != null) {
              v2protocal.AIj.a(this);
            }
            this.ABm = true;
            this.ABV = false;
            localObject1 = this.ABX;
            ((VoipScoreState)localObject1).tKb = bi.ayX();
            ac.i("MicroMsg.VoipScoreState", "markStartTalk, startTalkTime:%s", new Object[] { Long.valueOf(((VoipScoreState)localObject1).tKb) });
            eit();
            eiu();
            AppMethodBeat.o(114917);
            return;
            this.ABm = false;
            this.ABJ.AIf.ADr = 1;
            continue;
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: length of generalStrategyBuf = " + this.ABJ.AGr.length);
            break label503;
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: protocol has null generalStrategyBuf");
            break label503;
            if (this.ACd != null)
            {
              eiv();
              break label525;
            }
            this.ACd = new Timer();
            this.ACe = 0;
            localObject1 = new TimerTask()
            {
              public final void run()
              {
                AppMethodBeat.i(114893);
                l locall = l.this;
                locall.ACe += 1;
                if ((l.this.ABJ.AHT != 0) || (l.this.ACe > 10))
                {
                  l.this.eiv();
                  if (l.this.ACd != null)
                  {
                    l.this.ACd.cancel();
                    l.this.ACd = null;
                  }
                  AppMethodBeat.o(114893);
                  return;
                }
                AppMethodBeat.o(114893);
              }
            };
            this.ACd.schedule((TimerTask)localObject1, 200L, 200L);
            break label525;
            label2883:
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipDeviceHandler", "start device......");
            ((n)localObject1).osN = 2;
            ((n)localObject1).ACC = false;
            ((n)localObject1).ACD = 0;
            if (((n)localObject1).ACG != null)
            {
              ac.i("MicroMsg.Voip.VoipDeviceHandler", "mDevHandlerThread is not null");
              if (!((n)localObject1).ACG.isQuit()) {
                ac.i("MicroMsg.Voip.VoipDeviceHandler", "mDevHandlerThread is alive");
              }
            }
            ((n)localObject1).ACG.removeCallbacksAndMessages(null);
            if (((n)localObject1).ACK != null)
            {
              com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
              ((n)localObject1).ACK.ACN = true;
              ((n)localObject1).ACK.cancel();
              ((n)localObject1).ACK = null;
            }
            ((n)localObject1).ACK = new n.a((n)localObject1);
            com.tencent.mm.sdk.g.b.c(((n)localObject1).ACK, "VoipDeviceHandler_decode");
            com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipDeviceHandler", "start video decode thread..");
            ae.fJe.dump();
            for (;;)
            {
              synchronized (((n)localObject1).ACA)
              {
                while (((n)localObject1).osN == n.osM)
                {
                  ac.e("MicroMsg.Voip.VoipDeviceHandler", "current is not allowed to start dev");
                  synchronized (((n)localObject1).ACA)
                  {
                    ((n)localObject1).ACG.post(new n.2((n)localObject1));
                  }
                }
                localn.ACs = new c();
                localn.ACs.Ayu = String.valueOf(localn.ACH);
                a locala = new a();
                j = localn.Ayh.ABJ.a(locala);
                com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.GetAudioDeviceFmt, play samplerate:" + locala.vUp + ", framelen: " + locala.Ayd + ", ret:" + j);
                localn.ACs.M(locala.vUp, locala.channels, locala.Ayd, 0);
                localn.osO = localn.ACs.A(localn.Ayh.mHB, true);
                localn.Ayh.ABJ.AGJ = localn.ACs.idz;
                if (localn.ACs.Ayg == true)
                {
                  j = 1;
                  int i = (byte)j;
                  localn.Ayh.ABJ.setAppCmd(502, new byte[] { i }, 1);
                  if (localn.osO <= 10)
                  {
                    if (localn.osO <= 0) {
                      localn.osR = 1;
                    }
                    localn.osO = 92;
                  }
                  if ((!com.tencent.mm.plugin.audio.c.a.bCs()) && (!com.tencent.mm.plugin.audio.c.a.bCy())) {
                    break label3435;
                  }
                  com.tencent.mm.plugin.voip.c.ehb().op(true);
                  localn.ACs.Ayq = new n.3(localn);
                  if (localn.ACs.ehg() <= 0) {
                    localn.osR = 1;
                  }
                }
              }
              j = 0;
              continue;
              label3435:
              com.tencent.mm.plugin.voip.c.ehb().op(false);
            }
            label3445:
            localObject2.ADk = ((int)(System.currentTimeMillis() - localObject2.beginTime));
            break label583;
            j = (k << 2) + j;
            break label963;
            localException1 = localException1;
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "anlin send local client version Error!");
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
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "anlin send local device model Error!");
            continue;
            boolean bool1 = false;
            continue;
            boolean bool2 = false;
            continue;
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "setAppCmd: EMethodSetP2SSendThreadEnable disable, mSwitchFlag: " + this.ABJ.AGp);
            continue;
            label3544:
            if (ab.iwv != 0)
            {
              if ((ab.iwv & 0x2) != 0) {
                g(2, true, false);
              }
              if ((ab.iwv & 0x20) != 0) {
                g(32, true, false);
              }
              if ((ab.iwv & 0x10) != 0) {
                g(16, true, false);
              }
              if ((ab.iwv & 0x4) != 0) {
                g(4, true, false);
              }
              if ((ab.iwv & 0x8) != 0)
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
  
  public final boolean eit()
  {
    AppMethodBeat.i(114922);
    boolean bool = ein();
    int i = 0;
    if (bool) {
      i = 1;
    }
    com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipContext", "needVideoOut ret: " + bool + "videoStatus: " + i + ", sendVideoStatus: " + this.ABH);
    if ((this.ABH == -1) || (this.ABH != i))
    {
      if (!bool) {
        break label158;
      }
      com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video Out.......!");
    }
    for (int j = this.ABJ.setAppCmd(203);; j = this.ABJ.setAppCmd(202))
    {
      if (j == 0)
      {
        this.ABH = i;
        com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: succeed, ret: " + j + "sendVideoStatus: " + this.ABH);
      }
      AppMethodBeat.o(114922);
      return bool;
      label158:
      com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video Out.......!");
    }
  }
  
  public final boolean eiu()
  {
    AppMethodBeat.i(114923);
    boolean bool = eio();
    int i = 0;
    if (bool) {
      i = 1;
    }
    com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipContext", "needVideoIn ret: " + bool + "videoStatus: " + i + ", recvVideoStatus: " + this.ABI);
    if ((this.ABI == -1) || (this.ABI != i))
    {
      if (!bool) {
        break label158;
      }
      com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video In.......!");
    }
    for (int j = this.ABJ.setAppCmd(201);; j = this.ABJ.setAppCmd(200))
    {
      if (j == 0)
      {
        this.ABI = i;
        com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: succeed, ret: " + j + "recvVideoStatus: " + this.ABI);
      }
      AppMethodBeat.o(114923);
      return bool;
      label158:
      com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video In.......!");
    }
  }
  
  final void eiv()
  {
    AppMethodBeat.i(114924);
    if (this.mStatus == 5)
    {
      setStatus(6);
      this.ABJ.AIf.eiJ();
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "talking  now .......!");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114892);
          l.this.ABK.ehK();
          AppMethodBeat.o(114892);
        }
      });
    }
    AppMethodBeat.o(114924);
  }
  
  public final void eix()
  {
    AppMethodBeat.i(184051);
    int i = m.XE();
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
      long l = com.tencent.matrix.g.a.getTotalMemory(ai.getContext()) / 1024L / 1024L;
      if (j < ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbj, 4)) {
        break label585;
      }
      bool2 = true;
      if (k < ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbk, 45)) {
        break label591;
      }
      bool3 = true;
      if (m < ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbl, 23)) {
        break label597;
      }
      bool4 = true;
      if (l < ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbm, 4096)) {
        break label603;
      }
      bool5 = true;
      double d = com.tencent.matrix.g.a.HU();
      Debug.MemoryInfo localMemoryInfo = com.tencent.matrix.g.a.aT(ai.getContext());
      ac.i("MicroMsg.Voip.VoipContext", "checkVoipBeautyLocalConfig, cpuFlags:%s, isNeon:%s, nCores:%s, nFreq:%s, sdkInt:%s, totalMemMB:%s, coreNumCheck:%s, freqCheck:%s, sdkIntCheck:%s, totalMemMBCheck:%s, cpuRate:%s, dalvikPss:%s, nativePss:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Double.valueOf(d), Integer.valueOf(localMemoryInfo.dalvikPss), Integer.valueOf(localMemoryInfo.nativePss) });
      if ((!bool1) || (!bool2) || (!bool3) || (!bool4) || (!bool5)) {
        break label609;
      }
      bool2 = true;
      m = ae.fJd.fFk;
      n = ae.fJd.fFl;
      i = this.ABJ.AGp;
      k = (this.ABJ.AGp >> 11 & 0x1) << 3 | i >> 4 & 0x7;
      j = 0;
      bool3 = false;
      if (bool2) {
        j = eiw();
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
      ac.m("MicroMsg.Voip.VoipContext", "setVoipBeautyConfig local:%s, server:%s , blacklist:%s, whitelist:%s, voipBeautyFlag:%s, uiCallback:%s and isHitBlackListOrWhitList:%s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), this.ABK, Boolean.valueOf(bool1) });
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
          if (f.elO())
          {
            m = f.elN();
            j = f.elN();
          }
        }
      }
      if (this.ABK != null) {
        this.ABK.setVoipBeauty(m);
      }
      this.ABJ.AHG = m;
      this.ABJ.AHH = j;
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
  
  public final void eiy()
  {
    AppMethodBeat.i(177021);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114896);
        if ((l.this.mStatus != 4) && (l.this.mStatus != 5) && (l.this.mStatus != 6))
        {
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "startConnectDirect status fail, status:" + l.this.mStatus);
          AppMethodBeat.o(114896);
          return;
        }
        if (l.this.ABg)
        {
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "can not startConnectDirect again");
          AppMethodBeat.o(114896);
          return;
        }
        l.this.ABg = true;
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel direct");
        if (l.this.ABJ.AHJ == null)
        {
          com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipContext", "direct conns buf null");
          AppMethodBeat.o(114896);
          return;
        }
        int i = l.this.ABJ.AddNewDirectConns(l.this.ABJ.AHJ, l.this.ABJ.AHJ.length, 0);
        if (i < 0)
        {
          com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipContext", "v2protocal connectToPeerDirect failed, ret:".concat(String.valueOf(i)));
          AppMethodBeat.o(114896);
          return;
        }
        l.this.eiB();
        AppMethodBeat.o(114896);
      }
    });
    AppMethodBeat.o(177021);
  }
  
  public final void eiz()
  {
    AppMethodBeat.i(177022);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114897);
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "v2protocal QueryNicWanIp");
        if ((l.this.ABY != null) && (l.this.ABJ.AHK != null))
        {
          int i = l.this.ABJ.QueryNicWanIp(l.this.ABJ.AHK, l.this.ABJ.AHK.length);
          if (i != 0) {
            com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipContext", "query nic wan ip fail ret:".concat(String.valueOf(i)));
          }
        }
        else
        {
          l.this.eir();
          AppMethodBeat.o(114897);
          return;
        }
        AppMethodBeat.o(114897);
      }
    });
    AppMethodBeat.o(177022);
  }
  
  public final int g(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(114919);
    if (paramInt < 0)
    {
      AppMethodBeat.o(114919);
      return -1;
    }
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:DisableCodec: targetCodec = " + paramInt + ", local=" + paramBoolean1 + ", remote =" + paramBoolean2);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.putInt(paramInt);
    if (paramBoolean1) {}
    try
    {
      if (this.ABJ != null)
      {
        doo localdoo = new doo();
        localdoo.FWj = 5;
        localdoo.FWk = new com.tencent.mm.bw.b(localByteBuffer.array());
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable local target codec: ".concat(String.valueOf(paramInt)));
        this.ABJ.SendRUDP(localdoo.toByteArray(), localdoo.toByteArray().length);
      }
      if (paramBoolean2)
      {
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable remote target codec: ".concat(String.valueOf(paramInt)));
        localByteBuffer = ByteBuffer.allocate(6);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer.putShort((short)3);
        localByteBuffer.putShort((short)paramInt);
        localByteBuffer.putShort((short)0);
        this.ABJ.setAppCmd(35, localByteBuffer.array(), 6);
      }
      AppMethodBeat.o(114919);
      return 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "DisableCodec Error");
      }
    }
  }
  
  public final void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.ABJ.AHj = paramInt1;
    this.ABJ.AHk = paramInt2;
    this.ABJ.AHl = paramInt3;
    this.ABJ.AHm = paramInt4;
    this.ABJ.AHn = paramInt5;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(114900);
    ac.i("MicroMsg.Voip.VoipContext", "reset");
    if (this.ABJ.ekM()) {
      this.ABJ.sH(false);
    }
    this.ABJ.reset();
    this.ABx = -1;
    this.ABy = -1;
    this.ABz = -1;
    this.ABA = -1;
    this.ABB = -1;
    this.ABL.eiG();
    this.ABJ.AGB = 0;
    this.ACf.stopTimer();
    this.ABM.ekr();
    this.ACc.stopTimer();
    this.ABf = false;
    this.ABh = false;
    this.ABg = false;
    this.ABi = false;
    this.dsb = false;
    this.ABj = false;
    this.ABN = null;
    this.ABO = null;
    this.ABt = false;
    this.ABu = false;
    this.ABv = false;
    this.ABC = false;
    this.ABD = false;
    this.ABF = false;
    this.ABE = 1;
    this.ABG = 1;
    this.ABP = false;
    this.ABH = -1;
    this.ABI = -1;
    this.ABk = false;
    this.ABl = false;
    this.ABj = false;
    this.ABf = false;
    this.ABm = false;
    this.ABw = 10;
    this.mStatus = 1;
    this.ABU = 0;
    this.ACb = 0;
    this.ABV = false;
    this.ABT = 0;
    this.ABY = null;
    this.ABZ = null;
    this.ACa.clear();
    AppMethodBeat.o(114900);
  }
  
  public final void sA(boolean paramBoolean)
  {
    AppMethodBeat.i(114918);
    if (!paramBoolean)
    {
      if (this.ABJ != null)
      {
        if (this.ABW)
        {
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc: Set P2S HW Flag False!!");
          g(8, false, true);
        }
        for (;;)
        {
          ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
          localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
          localByteBuffer.putInt(6);
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc:reset maxsizeformat: 6");
          this.ABJ.setAppCmd(30, localByteBuffer.array(), 4);
          AppMethodBeat.o(114918);
          return;
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "closecodec: remote i264 enc!");
          b(8, false, true, true);
        }
      }
    }
    else
    {
      if (this.ABW)
      {
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "closeRemoteHWEnc: DecErr old!!");
        Sn(2);
        AppMethodBeat.o(114918);
        return;
      }
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "closeRemoteHWEnc: DecErr new!!");
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
      this.ACf.au(60000L, 60000L);
    }
    this.mStatus = paramInt;
    AppMethodBeat.o(114907);
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(114906);
    eiC();
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114889);
        if (l.this.ABK != null) {
          l.this.ABK.ehL();
        }
        AppMethodBeat.o(114889);
      }
    });
    AppMethodBeat.o(114906);
  }
  
  public static abstract interface a
  {
    public abstract void H(int paramInt1, int paramInt2, String paramString);
  }
  
  static abstract interface d
  {
    public abstract void eiD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l
 * JD-Core Version:    0.7.0.1
 */