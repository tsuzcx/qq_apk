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
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.model.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.protocal.protobuf.dyn;
import com.tencent.mm.protocal.protobuf.dzf;
import com.tencent.mm.protocal.protobuf.dzg;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.protocal.protobuf.eao;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
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
  public boolean CrF;
  public boolean CrG;
  public boolean CrH;
  public boolean CrI;
  public boolean CrJ;
  public boolean CrK;
  public boolean CrL;
  public boolean CrM;
  public diq CrN;
  public int CrO;
  public long CrP;
  public long CrQ;
  public int CrR;
  public int CrS;
  public boolean CrT;
  public boolean CrU;
  public boolean CrV;
  public int CrW;
  private int CrX;
  private int CrY;
  private int CrZ;
  public LinkedList<Integer> CsA;
  public int CsB;
  public aw CsC;
  Timer CsD;
  int CsE;
  private aw CsF;
  private a CsG;
  private int Csa;
  private int Csb;
  public boolean Csc;
  private boolean Csd;
  private int Cse;
  private boolean Csf;
  private int Csg;
  private int Csh;
  private int Csi;
  public v2protocal Csj;
  public x Csk;
  public n Csl;
  public w Csm;
  public byte[] Csn;
  public dzm Cso;
  public boolean Csp;
  public boolean Csq;
  public int Csr;
  public int Css;
  public int Cst;
  public int Csu;
  public boolean Csv;
  public boolean Csw;
  public VoipScoreState Csx;
  public Network Csy;
  public ConnectivityManager.NetworkCallback Csz;
  public boolean dFa;
  aq mHandler;
  public int mStatus;
  public Context nnh;
  
  protected l()
  {
    AppMethodBeat.i(114899);
    this.mStatus = 1;
    this.CrF = false;
    this.CrG = false;
    this.CrH = false;
    this.CrI = false;
    this.dFa = false;
    this.CrJ = false;
    this.CrK = false;
    this.CrL = false;
    this.CrM = false;
    this.CrN = new diq();
    this.CrO = 0;
    this.CrP = 0L;
    this.CrQ = 0L;
    this.CrR = 0;
    this.CrS = 0;
    this.CrT = false;
    this.CrU = false;
    this.CrV = false;
    this.CrW = 10;
    this.CrX = -1;
    this.CrY = -1;
    this.CrZ = -1;
    this.Csa = -1;
    this.Csb = -1;
    this.Csc = false;
    this.Csd = false;
    this.Cse = 1;
    this.Csf = false;
    this.Csg = 1;
    this.Csh = -1;
    this.Csi = -1;
    this.nnh = null;
    this.Csk = x.Cwi;
    this.Csn = null;
    this.Cso = null;
    this.Csp = false;
    this.Csq = false;
    this.Csr = 0;
    this.Css = 0;
    this.Cst = 0;
    this.Csu = 0;
    this.Csv = false;
    this.Csw = true;
    this.Csy = null;
    this.Csz = null;
    this.CsA = new LinkedList();
    this.CsB = 0;
    this.CsC = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(114886);
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.Voip.VoipContext", "voip repeat sync");
        l.this.Csm.a(null, false, 7);
        AppMethodBeat.o(114886);
        return true;
      }
    }, true);
    this.mHandler = new aq(Looper.getMainLooper())
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
          if (l.this.Csj.roomId == 0)
          {
            f.Loge("MicroMsg.Voip.VoipContext", "JNI_DOSYNC without roomid , igored!");
            AppMethodBeat.o(114891);
            return;
          }
          f.Logi("MicroMsg.Voip.VoipContext", "need dosync for cmd from channel...");
          localObject3 = (byte[])paramAnonymousMessage.obj;
          localObject1 = l.this.Csm;
          i = paramAnonymousMessage.arg2;
          paramAnonymousMessage = new ead();
          paramAnonymousMessage.nJA = 1;
          localObject4 = new SKBuiltinBuffer_t();
          ((SKBuiltinBuffer_t)localObject4).setBuffer((byte[])localObject3);
          paramAnonymousMessage.FTj = ((SKBuiltinBuffer_t)localObject4);
          localObject3 = new SKBuiltinBuffer_t();
          try
          {
            ((SKBuiltinBuffer_t)localObject3).setBuffer(paramAnonymousMessage.toByteArray());
            paramAnonymousMessage = new dzf();
            paramAnonymousMessage.Gru = i;
            paramAnonymousMessage.Grv = ((SKBuiltinBuffer_t)localObject3);
            paramAnonymousMessage.uvG = v.aAC();
            localObject3 = new dzg();
            ((dzg)localObject3).nID = 1;
            ((dzg)localObject3).nIE.add(paramAnonymousMessage);
            ((w)localObject1).a((dzg)localObject3, true, 2);
            AppMethodBeat.o(114891);
            return;
          }
          catch (IOException paramAnonymousMessage)
          {
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramAnonymousMessage, "", new Object[0]);
            AppMethodBeat.o(114891);
            return;
          }
        }
        if (paramAnonymousMessage.arg1 == 4)
        {
          if (l.this.Csj.roomId == 0)
          {
            f.Loge("MicroMsg.Voip.VoipContext", "JNI_STARTDEVFAILED without roomid , igored!");
            AppMethodBeat.o(114891);
            return;
          }
          f.Logi("MicroMsg.Voip.VoipContext", "need hangUP for startTalk failed. ");
          l.this.Csj.CyH.Ctt = 107;
          l.this.J(1, -9004, "");
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 6)
        {
          f.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected from JNI");
          if (l.this.Csj.roomId == 0)
          {
            f.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected roomid null, ignored");
            AppMethodBeat.o(114891);
            return;
          }
          l.this.CrH = true;
          l.this.Csj.CyH.CtJ = 1;
          if ((!l.this.dFa) && (!l.this.CrI)) {}
          for (l.this.Csj.Cxw = 1;; l.this.Csj.Cxw = 0)
          {
            l.this.Csj.setInactive();
            f.Logi("MicroMsg.Voip.VoipContext", "Voip.Channel setInactive");
            l.this.ezK();
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
            l.this.Csj.CyH.Ctt = 108;
            if (paramAnonymousMessage.arg2 != 5) {
              break label596;
            }
            l.this.Csj.CyH.CtL = 1;
            f.Logi("MicroMsg.Voip.VoipContext", "channel broken...");
          }
          for (;;)
          {
            l.this.J(1, -9000, "");
            AppMethodBeat.o(114891);
            return;
            l.this.Csj.CyH.Ctt = 106;
            break;
            label596:
            if (paramAnonymousMessage.arg2 == 8)
            {
              if (l.this.CrL == true)
              {
                f.Logi("MicroMsg.Voip.VoipContext", "channel connect fail while pre-connect");
                l.this.CrK = true;
                AppMethodBeat.o(114891);
                return;
              }
              f.Logi("MicroMsg.Voip.VoipContext", "channel connect fail...");
              l.this.CrH = false;
              l.this.Csj.CyH.CtL = 5;
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
            localObject1 = az.ja(ak.getContext());
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
            localObject3 = ((TelephonyManager)ak.getContext().getSystemService("phone")).getSimOperatorName();
            localObject1 = localObject3;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              f.Logi("MicroMsg.Voip.VoipContext", "Get netName failed in voip speedTest!");
            }
          }
          new j(l.this.CrQ, l.this.CrP, l.this.CrR, (String)localObject1, paramAnonymousMessage, l.this.CrS, i, (byte[])localObject4).eBO();
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
              localObject2 = (dvc)new dvc().parseFrom((byte[])localObject2);
              if ((!paramAnonymousMessage.Csv) || (((dvc)localObject2).IaM != 1)) {
                f.Logi("MicroMsg.Voip.VoipContext", "steve: onRecvRUDPCmd:" + ((dvc)localObject2).IaM);
              }
              i = ((dvc)localObject2).IaM;
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
            paramAnonymousMessage.Csl.Ctc = true;
            AppMethodBeat.o(114891);
            return;
            if (!paramAnonymousMessage.Csv)
            {
              f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client end HWEnc!!");
              paramAnonymousMessage.h(8, false, true);
              paramAnonymousMessage.b(4, false, true, true);
              if (((dvc)localObject2).IaN == null) {
                break label1190;
              }
              localObject2 = ByteBuffer.wrap(((dvc)localObject2).IaN.zr, 0, 4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              i = Math.min(((ByteBuffer)localObject2).getInt(), 6);
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(i);
              f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:CMD_VOIP_CloseHWEnc:reset maxsizeformat: ".concat(String.valueOf(i)));
              paramAnonymousMessage.Csj.setAppCmd(30, ((ByteBuffer)localObject2).array(), 4);
            }
            for (;;)
            {
              paramAnonymousMessage.Csv = true;
              AppMethodBeat.o(114891);
              return;
              label1190:
              f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: cmdBuffer is nil!!");
            }
            if (((dvc)localObject2).IaN != null)
            {
              localObject2 = ((dvc)localObject2).IaN.zr;
              f.Logi("MicroMsg.Voip.VoipContext", "steve: remote new network type:".concat(String.valueOf(localObject2)));
              i = paramAnonymousMessage.Csj.setAppCmd(302, (byte[])localObject2, 4);
              if (i < 0) {
                f.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + localObject2 + "fail:" + i + ", [roomid=" + paramAnonymousMessage.Csj.uXn + ", roomkey=" + paramAnonymousMessage.Csj.uXg + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            f.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
            AppMethodBeat.o(114891);
            return;
            byte[] arrayOfByte;
            if (((dvc)localObject2).IaN != null)
            {
              localObject2 = ((dvc)localObject2).IaN.zr;
              localObject2 = (dyn)new dyn().parseFrom((byte[])localObject2);
              f.Logi("MicroMsg.Voip.VoipContext", "zhengxue: remote audio dev occupied stat :" + ((dyn)localObject2).IdU);
              arrayOfByte = new byte[4];
              arrayOfByte[0] = ((byte)((dyn)localObject2).IdU);
              paramAnonymousMessage.Csj.setJNIAppCmd(2, arrayOfByte, 4);
              AppMethodBeat.o(114891);
              return;
            }
            f.Logi("MicroMsg.Voip.VoipContext", "zhengxue:[CHANNEL]EMethod_AudioDevOccupiedStatsSync empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((dvc)localObject2).IaN != null)
            {
              localObject2 = ((dvc)localObject2).IaN.zr;
              if (paramAnonymousMessage.Csj != null)
              {
                localObject2 = ByteBuffer.wrap((byte[])localObject2);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                i = ((ByteBuffer)localObject2).getInt();
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)3);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.Csj.setAppCmd(35, ((ByteBuffer)localObject2).array(), 6);
                f.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_DisableCodec:  ".concat(String.valueOf(i)));
              }
              AppMethodBeat.o(114891);
              return;
            }
            f.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_DisableCodec empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((dvc)localObject2).IaN != null)
            {
              localObject2 = ((dvc)localObject2).IaN.zr;
              if (paramAnonymousMessage.Csj != null)
              {
                localObject2 = ByteBuffer.wrap((byte[])localObject2);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                i = ((ByteBuffer)localObject2).getInt();
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)3);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.Csj.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
                f.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder:  ".concat(String.valueOf(i)));
              }
              AppMethodBeat.o(114891);
              return;
            }
            f.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((dvc)localObject2).IaN != null)
            {
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(1);
              paramAnonymousMessage.Csj.setAppCmd(48, ((ByteBuffer)localObject2).array(), 4);
              f.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAq:  1");
              AppMethodBeat.o(114891);
              return;
            }
            f.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAq empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((dvc)localObject2).IaN != null)
            {
              localObject2 = ((dvc)localObject2).IaN.zr;
              if (paramAnonymousMessage.Csj != null)
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
                paramAnonymousMessage.Csj.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)2);
                ((ByteBuffer)localObject2).putShort((short)4);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.Csj.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
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
                paramAnonymousMessage.Csj.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
              }
            }
            f.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((dvc)localObject2).IaN != null)
            {
              localObject2 = ((dvc)localObject2).IaN.zr;
              f.Logi("MicroMsg.Voip.VoipContext", "anlin: remote wx ver: ".concat(String.valueOf(localObject2)));
              i = paramAnonymousMessage.Csj.setAppCmd(506, (byte[])localObject2, 4);
              if (i < 0) {
                f.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteClientVersion] remote wx ver: " + localObject2 + "ret: " + i + ", [roomid=" + paramAnonymousMessage.Csj.uXn + ", roomkey=" + paramAnonymousMessage.Csj.uXg + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            f.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteClientVersion] empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((dvc)localObject2).IaN != null)
            {
              arrayOfByte = ((dvc)localObject2).IaN.zr;
              i = ((dvc)localObject2).IaN.zr.length;
              f.Logi("MicroMsg.Voip.VoipContext", "anlin: remote device model: ".concat(String.valueOf(arrayOfByte)));
              i = paramAnonymousMessage.Csj.setAppCmd(508, arrayOfByte, i);
              if (i < 0) {
                f.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteDeviceModel] remote device model: " + arrayOfByte + "ret: " + i + ", [roomid=" + paramAnonymousMessage.Csj.uXn + ", roomkey=" + paramAnonymousMessage.Csj.uXg + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            f.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteDeviceModel] empty buffer");
          }
        }
        if (paramAnonymousMessage.arg1 == 9)
        {
          paramAnonymousMessage = l.this.Csj.CyH;
          if (0L == paramAnonymousMessage.CtX)
          {
            paramAnonymousMessage.CtX = System.currentTimeMillis();
            f.Logi("MicroMsg.VoipDailReport", "first pkt received timestamp:" + paramAnonymousMessage.CtX);
          }
          f.Logi("MicroMsg.Voip.VoipContext", "get first pkt for voip");
          if (1 == l.this.Csj.Cyh)
          {
            paramAnonymousMessage = new eao();
            paramAnonymousMessage.nJb = 1;
            l.this.Csm.a(paramAnonymousMessage, 2);
            AppMethodBeat.o(114891);
          }
        }
        else
        {
          if (paramAnonymousMessage.arg1 == 11)
          {
            l.this.CsB = 2;
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 12)
          {
            l.this.CsB = 1;
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 13)
          {
            localObject2 = (int[])paramAnonymousMessage.obj;
            i = paramAnonymousMessage.arg2;
            new com.tencent.mm.plugin.voip.model.a.h(l.this.Csj.roomId, l.this.Csj.uXg, l.this.Csj.uXn, 1, i, (int[])localObject2, null).eBO();
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 14)
          {
            localObject2 = (int[])paramAnonymousMessage.obj;
            i = paramAnonymousMessage.arg2;
            new com.tencent.mm.plugin.voip.model.a.h(l.this.Csj.roomId, l.this.Csj.uXg, l.this.Csj.uXn, 2, i, (int[])localObject2, null).eBO();
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 15) {
            l.this.aS(paramAnonymousMessage.arg2, false);
          }
        }
        AppMethodBeat.o(114891);
      }
    };
    this.CsD = null;
    this.CsE = 0;
    this.CsF = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(177018);
        if (l.this.mStatus == 4)
        {
          f.Logi("MicroMsg.Voip.VoipContext", "connect time out.. now finish..");
          l.this.Csj.CyH.Ctt = 105;
          l.this.J(1, -9000, "");
        }
        AppMethodBeat.o(177018);
        return false;
      }
    }, false);
    this.CsG = null;
    this.Csj = new v2protocal(this.mHandler);
    this.Csl = new n(this);
    this.Csl.Cth = this.Csj.uXg;
    this.Csm = new w(this);
    this.Csu = 0;
    this.Csx = new VoipScoreState();
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
    if (this.CrF)
    {
      f.Logi("MicroMsg.Voip.VoipContext", "can not startConnectRelay again");
      AppMethodBeat.o(177020);
      return;
    }
    l.c localc = new l.c(this, (byte)0);
    localc.CsP = new l.b()
    {
      public final void ax(final int paramAnonymousInt1, final int paramAnonymousInt2, final int paramAnonymousInt3)
      {
        AppMethodBeat.i(114895);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114894);
            f.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel relay");
            int k = l.this.Csj.CxL;
            int m = l.this.Csj.CxL;
            v2protocal localv2protocal = l.this.Csj;
            int n = l.this.Csj.CwG;
            long l1 = l.this.Csj.roomId;
            int i1 = l.this.Csj.uXn;
            long l2 = l.this.Csj.uXg;
            byte[] arrayOfByte1 = l.this.Csj.CwI;
            int i2 = l.this.Csj.channelStrategy;
            int i3 = l.this.Csj.CwN;
            int i4 = l.this.Csj.CwO;
            int i5 = l.this.Csj.CwL;
            byte[] arrayOfByte2;
            int i6;
            int i7;
            int i8;
            byte[] arrayOfByte3;
            int i9;
            int i10;
            if (l.this.Csj.CwM == null)
            {
              i = 0;
              arrayOfByte2 = l.this.Csj.CwM;
              i6 = l.this.Csj.CwP;
              i7 = l.this.Csj.CwF;
              i8 = l.this.Csj.CxV;
              arrayOfByte3 = l.this.Csj.CxW;
              i9 = l.this.Csj.CxX;
              i10 = l.this.Csj.CwQ;
              if (l.this.Csj.CwR != null) {
                break label521;
              }
            }
            label521:
            for (int j = 0;; j = l.this.Csj.CwR.length)
            {
              i = localv2protocal.setConfigInfo(n, l1, i1, l2, arrayOfByte1, i2, i3, i4, i5, i, arrayOfByte2, i6, (k >> 2 & 0x3) >> 1 & 0x1 & (m & 0x3) >> 1 & 0x1, i7, i8, arrayOfByte3, i9, i10, j, l.this.Csj.CwR, l.this.Csj.CxY, paramAnonymousInt1, paramAnonymousInt3, paramAnonymousInt2, "", "", v2protocal.eCg());
              if (i >= 0) {
                break label539;
              }
              f.Loge("MicroMsg.Voip.VoipContext", "v2protocal setConfigInfo or connectToPeerRelay failed, ret:".concat(String.valueOf(i)));
              l.this.Csj.CyH.Ctt = 14;
              l.this.J(1, -9002, "");
              l.11.this.CsI.ezV();
              AppMethodBeat.o(114894);
              return;
              i = l.this.Csj.CwM.length;
              break;
            }
            label539:
            if (l.this.Csj.Cyk == null)
            {
              f.Loge("MicroMsg.Voip.VoipContext", "relay conns buf null");
              l.this.J(1, -9002, "");
              l.11.this.CsI.ezV();
              AppMethodBeat.o(114894);
              return;
            }
            int i = l.this.Csj.AddNewRelayConns(l.this.Csj.Cyk, l.this.Csj.Cyk.length, 0);
            if (i < 0)
            {
              f.Loge("MicroMsg.Voip.VoipContext", "add relayconns err:".concat(String.valueOf(i)));
              l.this.J(1, -9002, "");
              l.11.this.CsI.ezV();
              AppMethodBeat.o(114894);
              return;
            }
            l.this.CrF = true;
            l.this.Csj.CyH.CtA = 1;
            l.this.Csj.CyH.CtI = 1;
            l.11.this.CsI.ezV();
            AppMethodBeat.o(114894);
          }
        });
        AppMethodBeat.o(114895);
      }
    };
    com.tencent.e.h.MqF.aO(localc);
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
  
  private void ezH()
  {
    AppMethodBeat.i(114914);
    f.Logd("MicroMsg.Voip.VoipContext", "SrvDeviceInfo.mAudioInfo.aecMode:" + com.tencent.mm.compatible.deviceinfo.ae.geN.fYX);
    if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYz == 1) {
      this.Csj.setAppCmd(410);
    }
    byte[] arrayOfByte = new byte[2];
    Object localObject;
    byte b;
    int i;
    int j;
    int k;
    if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYX >= 0)
    {
      arrayOfByte[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYX);
      this.Csj.setAppCmd(406, arrayOfByte, 1);
      localObject = com.tencent.mm.model.c.d.aDI().xi("100447");
      if (((com.tencent.mm.storage.c)localObject).isValid())
      {
        m = bu.getInt((String)((com.tencent.mm.storage.c)localObject).fsy().get("SetVoipRnnNsOn"), 0);
        if (1 == m)
        {
          b = (byte)m;
          this.Csj.setAppCmd(432, new byte[] { b }, 1);
        }
      }
      m = com.tencent.mm.compatible.deviceinfo.ae.geN.fYY;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.nsModeNew %d", new Object[] { Integer.valueOf(m) });
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYY < 0) {
        break label1923;
      }
      if (m <= 0) {
        break label1904;
      }
      int n = (int)Math.floor(m / 1000.0D) % 100;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.iflag %d", new Object[] { Integer.valueOf(n) });
      if (n > 0)
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        this.Csj.setAppCmd(408, (byte[])new byte[] { b, i, j, k }, 4);
      }
      label326:
      m = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKl, -1);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "kerrizhang, play_fadeinfadeout_switch = %d", new Object[] { Integer.valueOf(m) });
      localObject = new byte[1];
      localObject[0] = 0;
      if (m > 0) {
        localObject[0] = ((byte)m);
      }
      this.Csj.setAppCmd(451, (byte[])localObject, 1);
      m = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKM, -1);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "kerrizhang, fullbandmode = %d", new Object[] { Integer.valueOf(m) });
      n = com.tencent.mm.compatible.deviceinfo.ae.geN.fZa;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.voipfullbandcfg %d", new Object[] { Integer.valueOf(n) });
      if ((m > 0) && (n > 0))
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        this.Csj.setAppCmd(456, (byte[])new byte[] { b, i, j, k }, 4);
      }
      m = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKm, -1);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "kerrizhang, play_fadeinfadeout_thresh = %d", new Object[] { Integer.valueOf(m) });
      localObject[0] = 0;
      if (m > 0) {
        localObject[0] = ((byte)m);
      }
      this.Csj.setAppCmd(452, (byte[])localObject, 1);
      m = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKL, -1);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "kerrizhang, voip rcnnvad_switch = %d", new Object[] { Integer.valueOf(m) });
      if (m > 0)
      {
        b = (byte)m;
        this.Csj.setAppCmd(454, new byte[] { b }, 1);
      }
      m = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKN, 0);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "dennyliang, voip aec_value = %d", new Object[] { Integer.valueOf(m) });
      if (m > 0)
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        this.Csj.setAppCmd(460, new byte[] { b, i, j, k }, 4);
      }
      m = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKQ, -1);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "qipengfeng, x_agc_paras: %d", new Object[] { Integer.valueOf(m) });
      if (m > 0)
      {
        b = (byte)(m & 0x1);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "qipengfeng, agc_switch: %d", new Object[] { Byte.valueOf(b) });
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "qipengfeng, agc para: %d, %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject[0]), Byte.valueOf(localObject[1]), Byte.valueOf(localObject[2]), Byte.valueOf(localObject[3]), Byte.valueOf(localObject[4]), Byte.valueOf(localObject[5]), Byte.valueOf(localObject[6]) });
        this.Csj.setAppCmd(404, (byte[])localObject, 7);
      }
      label1092:
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZc < 0) {
        break label1979;
      }
      localObject = new byte[7];
      if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fZd >= 0) && (com.tencent.mm.compatible.deviceinfo.ae.geN.fZe >= 0))
      {
        localObject[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZd);
        localObject[1] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZe);
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZf < 0) {
          break label1962;
        }
        localObject[2] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZf);
        localObject[3] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZc);
        localObject[4] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZg);
        localObject[5] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZh);
        localObject[6] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZi);
        this.Csj.setAppCmd(404, (byte[])localObject, 7);
      }
    }
    for (;;)
    {
      m = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKk, -1);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "qipengfeng, tryUpdateAudioAdaption, switch_flag_x = %d", new Object[] { Integer.valueOf(m) });
      localObject = new byte[1];
      localObject[0] = 0;
      if (m > 0) {
        localObject[0] = 1;
      }
      this.Csj.setAppCmd(450, (byte[])localObject, 1);
      if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fYA >= 0) || (com.tencent.mm.compatible.deviceinfo.ae.geN.fYC >= 0))
      {
        arrayOfByte[0] = -1;
        arrayOfByte[1] = -1;
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYA >= 0) {
          arrayOfByte[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYA);
        }
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYC >= 0) {
          arrayOfByte[1] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYC);
        }
        this.Csj.setAppCmd(414, arrayOfByte, 2);
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fYB >= 0) || (com.tencent.mm.compatible.deviceinfo.ae.geN.fYD >= 0))
      {
        arrayOfByte[0] = -1;
        arrayOfByte[1] = -1;
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYB >= 0) {
          arrayOfByte[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYB);
        }
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYD >= 0) {
          arrayOfByte[1] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYD);
        }
        this.Csj.setAppCmd(415, arrayOfByte, 2);
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fYE >= 0) || (com.tencent.mm.compatible.deviceinfo.ae.geN.fYF >= 0))
      {
        arrayOfByte[0] = -1;
        arrayOfByte[1] = -1;
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYE >= 0) {
          arrayOfByte[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYE);
        }
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYF >= 0) {
          arrayOfByte[1] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYF);
        }
        this.Csj.setAppCmd(422, arrayOfByte, 2);
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYG >= 0)
      {
        arrayOfByte[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYG);
        this.Csj.setAppCmd(416, arrayOfByte, 1);
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYK >= 0)
      {
        arrayOfByte[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYK);
        this.Csj.setAppCmd(431, arrayOfByte, 4);
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fYH >= 0) && ((this.Csj.CxF != 0) || (com.tencent.mm.compatible.deviceinfo.ae.geN.fYH != 5)))
      {
        arrayOfByte[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYH);
        this.Csj.setAppCmd(417, arrayOfByte, 1);
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fYI >= 0) && ((this.Csj.CxF != 0) || (com.tencent.mm.compatible.deviceinfo.ae.geN.fYI != 5)))
      {
        arrayOfByte[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYI);
        this.Csj.setAppCmd(418, arrayOfByte, 1);
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYJ >= 0)
      {
        arrayOfByte[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYJ);
        this.Csj.setAppCmd(419, arrayOfByte, 1);
      }
      if ((this.Csj.CxF == 1) && ((com.tencent.mm.compatible.deviceinfo.ae.geN.fYH == 5) || (com.tencent.mm.compatible.deviceinfo.ae.geN.fYI == 5))) {
        this.Csj.Cxj = 5;
      }
      if (1 != com.tencent.mm.compatible.deviceinfo.ae.geN.fZw) {
        break label2019;
      }
      localObject = new byte[30];
      m = 0;
      while (m < 15)
      {
        localObject[(m * 2)] = ((byte)(com.tencent.mm.compatible.deviceinfo.ae.geN.fZx[m] & 0xFF));
        localObject[(m * 2 + 1)] = ((byte)(com.tencent.mm.compatible.deviceinfo.ae.geN.fZx[m] >> 8 & 0xFF));
        m += 1;
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYX != -2) {
        break;
      }
      this.Csj.setAppCmd(407);
      break;
      label1904:
      if (m != 0) {
        break label326;
      }
      this.Csj.setAppCmd(409);
      break label326;
      label1923:
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYY != -2) {
        break label326;
      }
      this.Csj.setAppCmd(409);
      break label326;
      label1948:
      this.Csj.setAppCmd(405);
      break label1092;
      label1962:
      this.Csj.setAppCmd(404, (byte[])localObject, 2);
      continue;
      label1979:
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZc == -2) {
        this.Csj.setAppCmd(405);
      }
    }
    this.Csj.setAppCmd(420, (byte[])localObject, 30);
    label2019:
    if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZw == 0) {
      this.Csj.setAppCmd(421);
    }
    if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fZy[0] > 0) || (com.tencent.mm.compatible.deviceinfo.ae.geN.fZy[1] > 0))
    {
      arrayOfByte[0] = 0;
      arrayOfByte[1] = 0;
      if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fZy[0] > 0) && (com.tencent.mm.compatible.deviceinfo.ae.geN.fZy[0] < 10000)) {
        arrayOfByte[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZy[0]);
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fZy[1] > 0) && (com.tencent.mm.compatible.deviceinfo.ae.geN.fZy[1] < 10000)) {
        arrayOfByte[1] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZy[1]);
      }
      this.Csj.setAppCmd(423, arrayOfByte, 2);
    }
    if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZA > 0)
    {
      arrayOfByte[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZA);
      this.Csj.setAppCmd(424, arrayOfByte, 1);
    }
    int m = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKR, -1);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "qipengfeng, x_agcrx_para: %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)(m & 0x1);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "qipengfeng, agcrx_switch: %d", new Object[] { Byte.valueOf(b) });
      if (b > 0)
      {
        arrayOfByte = new byte[4];
        arrayOfByte[0] = ((byte)(m >> 1 & 0x3));
        arrayOfByte[1] = ((byte)(m >> 3 & 0x1F));
        arrayOfByte[2] = ((byte)(m >> 8 & 0x1F));
        arrayOfByte[3] = ((byte)(m >> 13 & 0x1));
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "qipengfeng, agcrx paras: %d, %d, %d, %d", new Object[] { Byte.valueOf(arrayOfByte[0]), Byte.valueOf(arrayOfByte[1]), Byte.valueOf(arrayOfByte[2]), Byte.valueOf(arrayOfByte[3]) });
        this.Csj.setAppCmd(426, arrayOfByte, 4);
      }
    }
    if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZI >= 0)
    {
      b = (byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZI;
      i = (byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZJ;
      j = (byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZK;
      k = (byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZL;
      this.Csj.setAppCmd(426, new byte[] { b, i, j, k }, 4);
    }
    AppMethodBeat.o(114914);
  }
  
  private static int ezO()
  {
    AppMethodBeat.i(184050);
    String str1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOs, "");
    if (!bu.isNullOrNil(str1)) {
      try
      {
        com.tencent.mm.ab.i locali = new com.tencent.mm.ab.i(str1);
        String str2 = Build.MANUFACTURER;
        int i = locali.optInt(str2, -1);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "checkVoipBeautyManufactureConfig, config:%s, manufacture:%s, beautyCmd:%s", new Object[] { str1, str2, Integer.valueOf(i) });
        if (i >= 0)
        {
          AppMethodBeat.o(184050);
          return i;
        }
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.Voip.VoipContext", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(184050);
    return 0;
  }
  
  private int tr(boolean paramBoolean)
  {
    AppMethodBeat.i(210043);
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
      if (this.Csj != null)
      {
        dvc localdvc = new dvc();
        localdvc.IaM = 10;
        localdvc.IaN = new com.tencent.mm.bw.b(localByteBuffer.array());
        f.Logi("MicroMsg.Voip.VoipContext", "EnableAq: SetAqFlag =44, aqBlur=".concat(String.valueOf(paramBoolean)));
        this.Csj.SendRUDP(localdvc.toByteArray(), localdvc.toByteArray().length);
      }
      localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putInt(1);
      this.Csj.setAppCmd(44, localByteBuffer.array(), 4);
      AppMethodBeat.o(210043);
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
    ezU();
    if (this.CsG != null) {
      this.CsG.J(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(114937);
  }
  
  public final void UH(int paramInt)
  {
    AppMethodBeat.i(114903);
    this.Csj.CwW = Math.abs(paramInt);
    AppMethodBeat.o(114903);
  }
  
  public final void UI(int paramInt)
  {
    AppMethodBeat.i(114904);
    this.Csj.CwX = Math.abs(paramInt);
    if (paramInt != 0) {
      this.Csk.dtu();
    }
    AppMethodBeat.o(114904);
  }
  
  public final void UJ(int paramInt)
  {
    this.Csj.Cxa = paramInt;
  }
  
  public final void UK(int paramInt)
  {
    AppMethodBeat.i(114910);
    if ((8 == paramInt) || (9 == paramInt)) {
      this.Csb = paramInt;
    }
    for (;;)
    {
      if ((1 == paramInt) || (3 == paramInt)) {
        UL(2);
      }
      this.Csk.Ux(paramInt);
      AppMethodBeat.o(114910);
      return;
      this.CrZ = paramInt;
      this.CrX = paramInt;
    }
  }
  
  public final void UL(int paramInt)
  {
    AppMethodBeat.i(114911);
    if ((8 == paramInt) || (9 == paramInt)) {
      this.Csa = paramInt;
    }
    for (;;)
    {
      this.Csm.Va(paramInt);
      AppMethodBeat.o(114911);
      return;
      this.CrX = paramInt;
      this.CrY = paramInt;
    }
  }
  
  public final void UM(int paramInt)
  {
    AppMethodBeat.i(114925);
    try
    {
      dvc localdvc = new dvc();
      localdvc.IaM = paramInt;
      if (1 == paramInt)
      {
        f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:send maxsizeformat: !!6");
        ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer.putInt(6);
        localdvc.IaN = new com.tencent.mm.bw.b(localByteBuffer.array());
        this.Csj.setAppCmd(32, localByteBuffer.array(), 4);
      }
      for (;;)
      {
        this.Csj.SendRUDP(localdvc.toByteArray(), localdvc.toByteArray().length);
        f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: send RUDP data to close remote HW encoding!Type:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(114925);
        return;
        localdvc.IaN = null;
      }
      return;
    }
    catch (Exception localException)
    {
      f.Logi("MicroMsg.Voip.VoipContext", "onVoipSendCloseHWEncCmd Error");
      AppMethodBeat.o(114925);
    }
  }
  
  public final void UN(int paramInt)
  {
    AppMethodBeat.i(114926);
    f.Logi("MicroMsg.Voip.VoipContext", "zhengxue: audio device occupied stat sync stat " + paramInt + " app 1");
    try
    {
      Object localObject = new byte[4];
      localObject[0] = ((byte)paramInt);
      this.Csj.setJNIAppCmd(2, (byte[])localObject, 4);
      localObject = new dyn();
      ((dyn)localObject).IdU = paramInt;
      ((dyn)localObject).IdV = 1;
      dvc localdvc = new dvc();
      localdvc.IaM = 4;
      localdvc.IaN = new com.tencent.mm.bw.b(((dyn)localObject).toByteArray(), 0, 1);
      this.Csj.SendRUDP(localdvc.toByteArray(), localdvc.toByteArray().length);
      AppMethodBeat.o(114926);
      return;
    }
    catch (Exception localException)
    {
      f.Logi("MicroMsg.Voip.VoipContext", "onAudioDevOccupiedStat Error");
      AppMethodBeat.o(114926);
    }
  }
  
  public final void UO(int paramInt)
  {
    this.Csj.CxX = paramInt;
  }
  
  public final void UP(int paramInt)
  {
    this.Csj.CxQ = paramInt;
  }
  
  public final void UQ(int paramInt)
  {
    this.Csj.CyH.Ctz = 1;
    this.Csj.channelStrategy = paramInt;
  }
  
  public final void UR(int paramInt)
  {
    this.Csj.CwP = paramInt;
  }
  
  public final void a(a parama)
  {
    if (parama != null) {
      this.CsG = parama;
    }
  }
  
  public final void a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.Csj.CwL = paramInt1;
    this.Csj.CwM = paramArrayOfByte1;
    this.Csj.CxV = paramInt2;
    this.Csj.CxW = paramArrayOfByte2;
  }
  
  public final boolean a(dzm paramdzm)
  {
    this.Cso = paramdzm;
    this.Csj.gpK = this.Cso.Ieu;
    this.Csj.roomId = this.Cso.Gxq;
    this.Csj.uXg = this.Cso.Gxr;
    this.Csj.uXn = 1;
    this.Csj.CwG = 0;
    this.mStatus = 3;
    return true;
  }
  
  public final void aS(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(114921);
    f.Logi("MicroMsg.Voip.VoipContext", "start bindSocket " + paramInt + " ToNetwork " + this.Csy + " rebind " + paramBoolean);
    if ((this.Csy != null) && (com.tencent.mm.compatible.util.d.lA(23)))
    {
      FileDescriptor localFileDescriptor = new FileDescriptor();
      try
      {
        Field localField = FileDescriptor.class.getDeclaredField("descriptor");
        localField.setAccessible(true);
        localField.setInt(localFileDescriptor, paramInt);
        this.Csy.bindSocket(localFileDescriptor);
        if (!paramBoolean) {
          this.CsA.add(Integer.valueOf(paramInt));
        }
        f.Logd("MicroMsg.Voip.VoipContext", "bindSocketToNetwork success: network" + this.Csy + "+socketfd" + paramInt);
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
  
  public final int aY(LinkedList<ccp> paramLinkedList)
  {
    int j = 0;
    AppMethodBeat.i(114936);
    Object localObject = new LinkedList();
    int k = this.Csj.aZ((LinkedList)localObject);
    int i = j;
    if (k == 0)
    {
      if ((((LinkedList)localObject).size() == 0) || (((LinkedList)localObject).size() > 2))
      {
        AppMethodBeat.o(114936);
        return 0;
      }
      if ((((ccp)((LinkedList)localObject).get(0)).Hpj == 1) && (((ccp)((LinkedList)localObject).get(0)).GsP == 5))
      {
        paramLinkedList.add(((LinkedList)localObject).get(0));
        this.Csj.Cxo = 1;
        AppMethodBeat.o(114936);
        return 0;
      }
      paramLinkedList.add(((LinkedList)localObject).get(0));
      this.Csj.Cxn = 1;
      if (!a((ConnectivityManager)ak.getContext().getSystemService("connectivity")))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "mobile network not connectedorconnecting");
        AppMethodBeat.o(114936);
        return 0;
      }
      localObject = ((TelephonyManager)ak.getContext().getSystemService("phone")).getSimOperator();
      if ((localObject == null) || (((String)localObject).length() < 3))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "nic_op NULL");
        AppMethodBeat.o(114936);
        return 0;
      }
      ccp localccp = new ccp();
      localccp.GUc = "android-cellular";
      localccp.Hpj = 0;
      localccp.GsP = 5;
      localccp.Hpk = (((String)localObject).substring(0, 3) + ":" + ((String)localObject).substring(3, ((String)localObject).length()));
      paramLinkedList.add(localccp);
      this.Csj.Cxo = 1;
      i = j;
    }
    while (i < paramLinkedList.size())
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipContext", "nic_name:" + ((ccp)paramLinkedList.get(i)).GUc + " nic_role:" + ((ccp)paramLinkedList.get(i)).Hpj + " net_type:" + ((ccp)paramLinkedList.get(i)).GsP + " nic_isp_info:" + ((ccp)paramLinkedList.get(i)).Hpk);
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
      dvc localdvc;
      try
      {
        if (this.Csj != null)
        {
          localdvc = new dvc();
          localdvc.IaM = 6;
          localdvc.IaN = new com.tencent.mm.bw.b(localByteBuffer1.array());
          f.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(paramInt)));
          this.Csj.SendRUDP(localdvc.toByteArray(), localdvc.toByteArray().length);
        }
        localByteBuffer1 = ByteBuffer.allocate(6);
        localByteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer1.putShort((short)2);
        localByteBuffer1.putShort((short)paramInt);
        localByteBuffer1.putShort((short)0);
        this.Csj.setAppCmd(39, localByteBuffer1.array(), 6);
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
        this.Csj.setAppCmd(39, localByteBuffer2.array(), 6);
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
          if (this.Csj == null) {
            continue;
          }
          localdvc = new dvc();
          localdvc.IaM = 7;
          localdvc.IaN = new com.tencent.mm.bw.b(localByteBuffer2.array());
          f.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(i)));
          this.Csj.SendRUDP(localdvc.toByteArray(), localdvc.toByteArray().length);
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
        this.Csj.setAppCmd(39, localByteBuffer3.array(), 6);
        localByteBuffer3 = ByteBuffer.allocate(4);
        localByteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer3.putInt(paramInt);
        try
        {
          if (this.Csj != null)
          {
            localdvc = new dvc();
            localdvc.IaM = 7;
            localdvc.IaN = new com.tencent.mm.bw.b(localByteBuffer3.array());
            f.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(paramInt)));
            this.Csj.SendRUDP(localdvc.toByteArray(), localdvc.toByteArray().length);
          }
        }
        catch (Exception localException3)
        {
          f.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        }
      }
    }
  }
  
  public final void bS(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114930);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "updateRemotePid");
    this.Csj.CyH.Cty = 1;
    this.Csj.CyH.Ctx = 1;
    this.Csj.CwI = paramArrayOfByte;
    AppMethodBeat.o(114930);
  }
  
  public final void bT(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    AppMethodBeat.i(114932);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "updateRemoteCapInfo, isGotCapInfo: %s", new Object[] { Byte.valueOf(this.Csj.CyH.CtC) });
    if ((this.Csj.CyH.CtC == 1) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(114932);
      return;
    }
    this.Csj.CyH.CtC = 1;
    this.Csj.CwJ = paramArrayOfByte;
    if (this.Csj.CwJ != null)
    {
      int i = this.Csj.exchangeCabInfo(this.Csj.CwJ, this.Csj.CwJ.length);
      if ((this.Csj.CwJ == null) || (this.Csj.CwJ.length < 36)) {
        bool = true;
      }
      this.Csw = bool;
      if (i < 0)
      {
        f.Loge("MicroMsg.Voip.VoipContext", "protocal exchangecabinfo failed ret:".concat(String.valueOf(i)));
        this.Csj.CyH.Ctt = 15;
        J(1, -9003, "");
      }
    }
    AppMethodBeat.o(114932);
  }
  
  public final void bU(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114933);
    this.Csj.CwK = paramArrayOfByte;
    ezT();
    AppMethodBeat.o(114933);
  }
  
  public final void c(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.Csj.Cyc = paramInt;
    this.Csj.Cyd = paramArrayOfByte1;
    this.Csj.Cye = paramArrayOfByte2;
  }
  
  public final int ezA()
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
  
  public final boolean ezB()
  {
    return (this.mStatus == 2) || (this.mStatus == 4);
  }
  
  public final boolean ezC()
  {
    return this.mStatus == 3;
  }
  
  public final boolean ezD()
  {
    AppMethodBeat.i(114908);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipContext", "isWorking, status: %d", new Object[] { Integer.valueOf(this.mStatus) });
    if (this.mStatus == 1)
    {
      AppMethodBeat.o(114908);
      return false;
    }
    AppMethodBeat.o(114908);
    return true;
  }
  
  public final long ezE()
  {
    return this.Csj.CwV;
  }
  
  public final boolean ezF()
  {
    if (this.CrV) {
      return false;
    }
    switch (this.CrX)
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
        } while (4 == this.CrY);
        return false;
      } while ((4 == this.CrY) || (-1 == this.CrY));
      return false;
      if ((5 == this.CrY) || (6 == this.CrY)) {
        break;
      }
    } while (7 != this.CrY);
    return false;
  }
  
  public final boolean ezG()
  {
    if (this.CrV) {
      return false;
    }
    switch (this.CrX)
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
        } while (4 == this.CrY);
        return false;
      } while ((4 == this.CrZ) || (this.CrZ == 0) || (-1 == this.CrZ));
      return false;
      if ((5 == this.CrZ) || (6 == this.CrZ)) {
        break;
      }
    } while (7 != this.CrZ);
    return false;
  }
  
  public final void ezI()
  {
    AppMethodBeat.i(114915);
    f.Logi("MicroMsg.Voip.VoipContext", "In networkRequestViaCellular");
    if (com.tencent.mm.compatible.util.d.lA(21))
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)ak.getContext().getSystemService("connectivity");
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
            Object localObject = l.this.Csj;
            ((v2protocal)localObject).Cxq += 1;
            localObject = Parcel.obtain();
            paramAnonymousNetwork.writeToParcel((Parcel)localObject, 0);
            f.Logi("MicroMsg.Voip.VoipContext", "found requested network. netid: " + ((Parcel)localObject).readInt() + " toString: " + paramAnonymousNetwork.toString());
            if (com.tencent.mm.compatible.util.d.lA(28)) {
              localObject = (ConnectivityManager)ak.getContext().getSystemService("connectivity");
            }
            try
            {
              int j = ((ConnectivityManager)localObject).getMultipathPreference(paramAnonymousNetwork);
              f.Logi("MicroMsg.Voip.VoipContext", "getMultipathPreference ret ".concat(String.valueOf(j)));
              if (j == 0) {
                l.this.Csj.Cxp = 3;
              }
              if (l.this.Csy != null)
              {
                l.this.Csy = paramAnonymousNetwork;
                if (l.this.CsA == null) {
                  break label266;
                }
                while (i < l.this.CsA.size())
                {
                  l.this.aS(((Integer)l.this.CsA.get(i)).intValue(), true);
                  i += 1;
                }
              }
              label266:
              return;
            }
            catch (Exception paramAnonymousNetwork)
            {
              f.Logi("MicroMsg.Voip.VoipContext", "getMultipathPreference  Error");
              l.this.Csj.Cxp = 2;
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
              l.this.Csy = paramAnonymousNetwork;
              l.this.Csz = this;
              f.Logi("MicroMsg.Voip.VoipContext", "networkcallback hashCode: " + l.this.Csz.hashCode());
              l.this.Csj.Cxp = 1;
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
        this.Csj.Cxp = 2;
        AppMethodBeat.o(114915);
        return;
      }
    }
    AppMethodBeat.o(114915);
  }
  
  public final void ezJ()
  {
    AppMethodBeat.i(114916);
    f.Logi("MicroMsg.Voip.VoipContext", "try to UnregisterCellularNetwork");
    ConnectivityManager localConnectivityManager;
    if (com.tencent.mm.compatible.util.d.lA(21))
    {
      localConnectivityManager = (ConnectivityManager)ak.getContext().getSystemService("connectivity");
      if (this.Csz != null) {
        f.Logi("MicroMsg.Voip.VoipContext", "unregister networkcallback hashCode: " + this.Csz.hashCode());
      }
    }
    try
    {
      localConnectivityManager.unregisterNetworkCallback(this.Csz);
      this.Csz = null;
      this.Csy = null;
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
  
  public final void ezK()
  {
    AppMethodBeat.i(114917);
    f.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: try start talk");
    if ((this.CrJ != true) || (this.CrH != true))
    {
      f.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: fail isCanSendData " + this.CrJ + ", isChannelConnectedSuccess " + this.CrH);
      AppMethodBeat.o(114917);
      return;
    }
    f.Logi("MicroMsg.Voip.VoipContext", "Voip tryStartTalk, channel setActive");
    this.Csj.setActive();
    if (this.CrM == true)
    {
      f.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: engine already started, isEngineStarted " + this.CrM);
      AppMethodBeat.o(114917);
      return;
    }
    this.Csj.setSvrConfig(205, 0, 0, this.Csj.CxY, 0, 0, 0, 0, null);
    this.Csj.setSvrConfig(207, 0, 0, this.Csj.CwQ, 0, 0, 0, 0, null);
    f.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.Csj.CxY + " SwitchFlag = " + this.Csj.CwQ);
    this.Csj.CwT[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geX.gbD);
    this.Csj.CwT[1] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geX.gbE);
    this.Csj.CwT[2] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geX.gbF);
    this.Csj.CwT[3] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geX.gbG);
    this.Csj.CwT[4] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geX.gbH);
    this.Csj.CwT[5] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geX.gbI);
    this.Csj.CwT[6] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geX.gbJ);
    this.Csj.CwT[7] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geX.gbK);
    this.Csj.CwT[8] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geX.gbL);
    this.Csj.CwT[9] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geX.gbM);
    this.Csj.setSvrConfig(209, 0, 0, 0, 0, 0, 0, this.Csj.CwT.length, this.Csj.CwT);
    if (this.Csj.startEngine() == 0) {
      this.Csj.CyH.CtT = 0;
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
      if (this.Csj.CwS != null) {
        if (this.Csj.CwS.length < 1024)
        {
          this.Csj.setSvrConfig(208, 0, 0, 0, 0, 0, 0, this.Csj.CwS.length, this.Csj.CwS);
          ezH();
          if ((ezF()) || (ezG())) {
            break label2825;
          }
          ezN();
          this.Csk.eze();
          localObject1 = this.Csl;
          if (((n)localObject1).pcM != 2) {
            break label2883;
          }
          f.Loge("MicroMsg.Voip.VoipDeviceHandler", "dev start already...");
          localObject1 = this.Csj.CyH;
          if (((o)localObject1).beginTime != 0L) {
            break label3445;
          }
          ((o)localObject1).CtM = 0;
          f.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + ((o)localObject1).beginTime + ", CurrentTime: " + System.currentTimeMillis());
          f.Logi("MicroMsg.VoipDailReport", "devin:endNewDial:" + ((o)localObject1).CtM);
          this.Csk.onConnected();
          this.mStatus = 5;
          localObject1 = this.Csj.CyH;
          ((o)localObject1).CtU = System.currentTimeMillis();
          f.Logi("MicroMsg.VoipDailReport", "devin:beginTalk:" + ((o)localObject1).CtU);
          this.Csj.setSvrConfig(202, this.Csj.Cxx, this.Csj.Cxy, 0, 0, 0, 0, 0, null);
          this.Csj.setSvrConfig(203, 0, 0, this.Csj.CxC, 0, 0, 0, 0, null);
          this.Csj.setSvrConfig(206, 0, 0, this.Csj.CxG, 0, 0, 0, 0, null);
          this.Csj.setSvrConfig(103, this.Csj.Cxz, this.Csj.CxA, this.Csj.CxB, this.Csj.CxE, 0, 0, 0, null);
          this.Csj.setSvrConfig(205, 0, 0, this.Csj.CxY, 0, 0, 0, 0, null);
          this.Csj.setSvrConfig(207, 0, 0, this.Csj.CwQ, 0, 0, 0, 0, null);
          f.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.Csj.CxY + " SwitchFlag = " + this.Csj.CwQ);
          j = this.Csj.CxL >> 2 & 0x3;
          k = this.Csj.CxL & 0x3;
          if (this.Csj.uXn != 0) {
            break label3463;
          }
          j = (j << 2) + k;
          this.Csj.setSvrConfig(502, 0, 0, j, 0, 0, 0, 0, null);
          this.Csj.setSvrConfig(503, 0, 0, this.Csj.CxM, this.Csj.CxN, this.Csj.CxO, this.Csj.CxP, 0, null);
          if ((this.Csj.Cyd != null) && (this.Csj.Cye != null))
          {
            this.Csj.setSvrConfig(504, 0, 0, this.Csj.Cyc, 0, 0, 0, 0, null);
            this.Csj.setSvrConfig(505, 0, 0, this.Csj.Cyd[0], this.Csj.Cyd[1], this.Csj.Cyd[2], this.Csj.Cyd[3], 0, null);
            this.Csj.setSvrConfig(506, 0, 0, this.Csj.Cye[0], this.Csj.Cye[1], 0, 0, 0, null);
            f.Logi("MicroMsg.Voip.VoipContext", "FECSvrCtr = " + this.Csj.Cyc + ",FECKeyPara1 = " + this.Csj.Cyd[0] + "," + this.Csj.Cyd[1] + "," + this.Csj.Cyd[2] + "," + this.Csj.Cyd[3] + ",FECKeyPara2 = " + this.Csj.Cye[0] + "," + this.Csj.Cye[1]);
          }
          k = this.Csj.CxQ;
          m = this.Csj.CxQ;
          n = this.Csj.CxQ;
          this.Csj.setSvrConfig(507, 0, 0, (k & 0x4) >> 2, (m & 0x2) >> 1, n & 0x1, 0, 0, null);
          this.Csj.setjbmbitraterssvrparam();
          f.Logi("MicroMsg.Voip.VoipContext", "zhengxue[Logic] setSvrConfig brefore onStartTalk: audioTsdfBeyond3G = " + this.Csj.Cxx + ",audioTsdEdge = " + this.Csj.Cxy + ",passthroughQosAlgorithm = " + this.Csj.Cxz + ",fastPlayRepair = " + this.Csj.CxA + ", audioDTX = " + this.Csj.CxC + ", mARQFlag = " + j + ", mQosStrategy = " + this.Csj.CxQ + ", mSvrCfgListV = " + this.Csj.CxB + ", maxBRForRelay = " + this.Csj.CxE);
          localObject1 = new byte[2];
          localObject1[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geM.gaL);
          localObject1[1] = -1;
          f.Logd("MicroMsg.Voip.VoipContext", "steve: Model Name: " + Build.MODEL);
          f.Logd("MicroMsg.Voip.VoipContext", "steve: Image Enhancement for Android Capture!!, mode: " + localObject1[0]);
          this.Csj.setAppCmd(15, (byte[])localObject1, 1);
          f.Logd("MicroMsg.Voip.VoipContext", "anlin: ClientVersion: " + com.tencent.mm.protocal.d.FFH);
          localObject1 = ByteBuffer.allocate(4);
          ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN).putInt(com.tencent.mm.protocal.d.FFH);
          localObject1 = ((ByteBuffer)localObject1).array();
          this.Csj.setAppCmd(505, (byte[])localObject1, 4);
        }
      }
      label3463:
      try
      {
        if (this.Csj != null)
        {
          ??? = new dvc();
          ((dvc)???).IaM = 8;
          ((dvc)???).IaN = new com.tencent.mm.bw.b((byte[])localObject1);
          f.Logi("MicroMsg.Voip.VoipContext", "anlin send local client version: ".concat(String.valueOf(localObject1)));
          this.Csj.SendRUDP(((dvc)???).toByteArray(), ((dvc)???).toByteArray().length);
        }
        localObject1 = Build.MODEL;
        j = ((String)localObject1).length();
        localObject1 = ((String)localObject1).getBytes();
        f.Logi("MicroMsg.Voip.VoipContext", "anlin DeviceModel: ".concat(String.valueOf(localObject1)));
        this.Csj.setAppCmd(507, (byte[])localObject1, j);
      }
      catch (Exception localException1)
      {
        label2825:
        label3506:
        label3639:
        try
        {
          if (this.Csj != null)
          {
            ??? = new dvc();
            ((dvc)???).IaM = 9;
            ((dvc)???).IaN = new com.tencent.mm.bw.b((byte[])localObject1);
            f.Logi("MicroMsg.Voip.VoipContext", "anlin send local device model: ".concat(String.valueOf(localObject1)));
            this.Csj.SendRUDP(((dvc)???).toByteArray(), ((dvc)???).toByteArray().length);
          }
          if ((this.Csj.CwQ >> 17 & 0x1) != 0)
          {
            bool1 = true;
            if ((this.Csj.CwQ >> 18 & 0x1) == 0) {
              break label3506;
            }
            bool2 = true;
            tr(bool1);
            f.Logi("MicroMsg.Voip.VoipContext", "EnableBlur: SetBlurFlag =47, aqBlur=".concat(String.valueOf(bool2)));
            if (bool2)
            {
              localObject1 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject1).putInt(1);
              this.Csj.setAppCmd(47, ((ByteBuffer)localObject1).array(), 4);
            }
            if ((this.Csj.CwQ & 0x2) == 0)
            {
              h(16, true, true);
              h(4, true, true);
            }
            j = this.Csj.CwQ >> 12 & 0x1;
            localObject1 = ByteBuffer.allocate(4);
            ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
            ((ByteBuffer)localObject1).putInt(j);
            f.Logi("MicroMsg.Voip.VoipContext", "weiranli set MixVcodec1 from svr = ".concat(String.valueOf(j)));
            this.Csj.setAppCmd(46, ((ByteBuffer)localObject1).array(), 4);
            if ((this.Csj.CwQ & 0x200) == 0)
            {
              localObject1 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject1).putInt(8);
              f.Logi("MicroMsg.Voip.VoipContext", "jcchen Disable 720p from svr: mSwitchFlag = " + this.Csj.CwQ);
              this.Csj.setAppCmd(32, ((ByteBuffer)localObject1).array(), 4);
              this.Csj.setAppCmd(30, ((ByteBuffer)localObject1).array(), 4);
            }
            if ((this.Csj.CwQ & 0x100000) != 1) {
              break label3512;
            }
            f.Logi("MicroMsg.Voip.VoipContext", "setAppCmd: EMethodSetP2SSendThreadEnable enble, mSwitchFlag: " + this.Csj.CwQ);
            this.Csj.setAppCmd(52);
            if (ac.iSv == 0) {
              break label3544;
            }
            localObject1 = ByteBuffer.allocate(4);
            ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
            ((ByteBuffer)localObject1).putInt(ac.iSv);
            this.Csj.setAppCmd(36, ((ByteBuffer)localObject1).array(), 4);
            localObject1 = new byte[4];
            this.Csj.setAppCmd(26, (byte[])localObject1, 4);
            localObject1 = ByteBuffer.wrap((byte[])localObject1);
            ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
            m = ((ByteBuffer)localObject1).getInt();
            f.Logd("MicroMsg.Voip.VoipContext", "steve: iHW: ".concat(String.valueOf(m)));
            if (((this.Csj.CxB & 0x4) == 0) && (com.tencent.mm.compatible.deviceinfo.ae.geM.gaN <= 0)) {
              break label3639;
            }
            j = 1;
            if ((j == 0) && (this.Csj.peH))
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
                this.Csl.Ctc = true;
                tq(false);
              }
              this.Csj.peH = false;
            }
            if (this.Csj.peH)
            {
              ??? = this.Csj;
              n = com.tencent.mm.compatible.deviceinfo.ae.geM.gaN;
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
                ((v2protocal)???).CyK = new e(((v2protocal)???).width, ((v2protocal)???).height, ((v2protocal)???).CyM, ((v2protocal)???).bitrate, n, (String)localObject1);
                f.Logi("MicroMsg.Voip", "steve : create HW encoder successfully:".concat(String.valueOf(localObject1)));
                if (v2protocal.CyN != null)
                {
                  v2protocal.CyL = new d(v2protocal.CyN);
                  f.Logi("MicroMsg.Voip", "steve : create HW decoder successfully!");
                }
                bool1 = true;
                if ((((v2protocal)???).CyK == null) || (v2protocal.CyL == null))
                {
                  ((v2protocal)???).peH = false;
                  bool1 = false;
                }
              }
              f.Logi("MicroMsg.Voip.VoipContext", "steve: HW encoder/decoder init ret: " + bool1 + ", iHW:" + m);
              if (!this.Csj.peH)
              {
                f.Logi("MicroMsg.Voip.VoipContext", "steve: HW dec/enc NOT supported for both sides,end HWEnc!!");
                this.Csl.Ctc = true;
                tq(false);
                b(8, true, false, true);
                b(8, true, false, false);
              }
            }
            if (this.Csj.CyK != null) {
              this.Csj.CyK.Cpd = this;
            }
            if (v2protocal.CyL != null) {
              v2protocal.CyL.a(this);
            }
            this.CrM = true;
            this.Csv = false;
            localObject1 = this.Csx;
            ((VoipScoreState)localObject1).uYB = bl.aCr();
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoipScoreState", "markStartTalk, startTalkTime:%s", new Object[] { Long.valueOf(((VoipScoreState)localObject1).uYB) });
            ezL();
            ezM();
            AppMethodBeat.o(114917);
            return;
            this.CrM = false;
            this.Csj.CyH.CtT = 1;
            continue;
            f.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: length of generalStrategyBuf = " + this.Csj.CwS.length);
            break label503;
            f.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: protocol has null generalStrategyBuf");
            break label503;
            if (this.CsD != null)
            {
              ezN();
              break label525;
            }
            this.CsD = new Timer();
            this.CsE = 0;
            localObject1 = new TimerTask()
            {
              public final void run()
              {
                AppMethodBeat.i(114893);
                l locall = l.this;
                locall.CsE += 1;
                if ((l.this.Csj.Cyv != 0) || (l.this.CsE > 10))
                {
                  l.this.ezN();
                  if (l.this.CsD != null)
                  {
                    l.this.CsD.cancel();
                    l.this.CsD = null;
                  }
                  AppMethodBeat.o(114893);
                  return;
                }
                AppMethodBeat.o(114893);
              }
            };
            this.CsD.schedule((TimerTask)localObject1, 200L, 200L);
            break label525;
            label2883:
            f.Logi("MicroMsg.Voip.VoipDeviceHandler", "start device......");
            ((n)localObject1).pcM = 2;
            ((n)localObject1).Ctc = false;
            ((n)localObject1).Ctd = 0;
            if (((n)localObject1).Ctg != null)
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipDeviceHandler", "mDevHandlerThread is not null");
              if (!((n)localObject1).Ctg.isQuit()) {
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipDeviceHandler", "mDevHandlerThread is alive");
              }
            }
            ((n)localObject1).Ctg.removeCallbacksAndMessages(null);
            if (((n)localObject1).Ctl != null)
            {
              f.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
              ((n)localObject1).Ctl.Ctp = true;
              ((n)localObject1).Ctl.cancel();
              ((n)localObject1).Ctl = null;
            }
            ((n)localObject1).Ctl = new n.a((n)localObject1);
            com.tencent.mm.sdk.g.b.c(((n)localObject1).Ctl, "VoipDeviceHandler_decode");
            f.Logd("MicroMsg.Voip.VoipDeviceHandler", "start video decode thread..");
            com.tencent.mm.compatible.deviceinfo.ae.geN.dump();
            for (;;)
            {
              synchronized (((n)localObject1).Cta)
              {
                while (((n)localObject1).pcM == n.pcL)
                {
                  com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.VoipDeviceHandler", "current is not allowed to start dev");
                  synchronized (((n)localObject1).Cta)
                  {
                    ((n)localObject1).Ctg.post(new n.2((n)localObject1));
                  }
                }
                localn.CsS = new c();
                localn.CsS.Cpq = String.valueOf(localn.Cth);
                a locala = new a();
                j = localn.Cpd.Csj.a(locala);
                f.Logi("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.GetAudioDeviceFmt, play samplerate:" + locala.xrw + ", framelen: " + locala.CoZ + ", ret:" + j);
                localn.CsS.M(locala.xrw, locala.channels, locala.CoZ, 0);
                localn.pcN = localn.CsS.C(localn.Cpd.nnh, true);
                localn.Cpd.Csj.Cxl = localn.CsS.izN;
                if (localn.CsS.Cpc == true)
                {
                  j = 1;
                  int i = (byte)j;
                  localn.Cpd.Csj.setAppCmd(502, new byte[] { i }, 1);
                  if (localn.pcN <= 10)
                  {
                    if (localn.pcN <= 0) {
                      localn.pcQ = 1;
                    }
                    localn.pcN = 92;
                  }
                  if ((!com.tencent.mm.plugin.audio.c.a.bHt()) && (!com.tencent.mm.plugin.audio.c.a.bHz())) {
                    break label3435;
                  }
                  com.tencent.mm.plugin.voip.c.eys().oQ(true);
                  localn.CsS.Cpm = new n.3(localn);
                  if (localn.CsS.eyy() <= 0) {
                    localn.pcQ = 1;
                  }
                }
              }
              j = 0;
              continue;
              label3435:
              com.tencent.mm.plugin.voip.c.eys().oQ(false);
            }
            label3445:
            localObject2.CtM = ((int)(System.currentTimeMillis() - localObject2.beginTime));
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
            f.Logi("MicroMsg.Voip.VoipContext", "setAppCmd: EMethodSetP2SSendThreadEnable disable, mSwitchFlag: " + this.Csj.CwQ);
            continue;
            label3544:
            if (ac.iSw != 0)
            {
              if ((ac.iSw & 0x2) != 0) {
                h(2, true, false);
              }
              if ((ac.iSw & 0x20) != 0) {
                h(32, true, false);
              }
              if ((ac.iSw & 0x10) != 0) {
                h(16, true, false);
              }
              if ((ac.iSw & 0x4) != 0) {
                h(4, true, false);
              }
              if ((ac.iSw & 0x8) != 0)
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
  
  public final boolean ezL()
  {
    AppMethodBeat.i(114922);
    boolean bool = ezF();
    int i = 0;
    if (bool) {
      i = 1;
    }
    f.Logd("MicroMsg.Voip.VoipContext", "needVideoOut ret: " + bool + "videoStatus: " + i + ", sendVideoStatus: " + this.Csh);
    if ((this.Csh == -1) || (this.Csh != i))
    {
      if (!bool) {
        break label158;
      }
      f.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video Out.......!");
    }
    for (int j = this.Csj.setAppCmd(203);; j = this.Csj.setAppCmd(202))
    {
      if (j == 0)
      {
        this.Csh = i;
        f.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: succeed, ret: " + j + "sendVideoStatus: " + this.Csh);
      }
      AppMethodBeat.o(114922);
      return bool;
      label158:
      f.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video Out.......!");
    }
  }
  
  public final boolean ezM()
  {
    AppMethodBeat.i(114923);
    boolean bool = ezG();
    int i = 0;
    if (bool) {
      i = 1;
    }
    f.Logd("MicroMsg.Voip.VoipContext", "needVideoIn ret: " + bool + "videoStatus: " + i + ", recvVideoStatus: " + this.Csi);
    if ((this.Csi == -1) || (this.Csi != i))
    {
      if (!bool) {
        break label158;
      }
      f.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video In.......!");
    }
    for (int j = this.Csj.setAppCmd(201);; j = this.Csj.setAppCmd(200))
    {
      if (j == 0)
      {
        this.Csi = i;
        f.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: succeed, ret: " + j + "recvVideoStatus: " + this.Csi);
      }
      AppMethodBeat.o(114923);
      return bool;
      label158:
      f.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video In.......!");
    }
  }
  
  final void ezN()
  {
    AppMethodBeat.i(114924);
    if (this.mStatus == 5)
    {
      setStatus(6);
      this.Csj.CyH.eAb();
      f.Logi("MicroMsg.Voip.VoipContext", "talking  now .......!");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114892);
          l.this.Csk.ezc();
          AppMethodBeat.o(114892);
        }
      });
    }
    AppMethodBeat.o(114924);
  }
  
  public final void ezP()
  {
    AppMethodBeat.i(184051);
    int i = m.aao();
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
      long l = com.tencent.matrix.g.a.getTotalMemory(ak.getContext()) / 1024L / 1024L;
      if (j < ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOo, 4)) {
        break label585;
      }
      bool2 = true;
      if (k < ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOp, 45)) {
        break label591;
      }
      bool3 = true;
      if (m < ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOq, 23)) {
        break label597;
      }
      bool4 = true;
      if (l < ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOr, 4096)) {
        break label603;
      }
      bool5 = true;
      double d = com.tencent.matrix.g.a.Jx();
      Debug.MemoryInfo localMemoryInfo = com.tencent.matrix.g.a.aU(ak.getContext());
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "checkVoipBeautyLocalConfig, cpuFlags:%s, isNeon:%s, nCores:%s, nFreq:%s, sdkInt:%s, totalMemMB:%s, coreNumCheck:%s, freqCheck:%s, sdkIntCheck:%s, totalMemMBCheck:%s, cpuRate:%s, dalvikPss:%s, nativePss:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Double.valueOf(d), Integer.valueOf(localMemoryInfo.dalvikPss), Integer.valueOf(localMemoryInfo.nativePss) });
      if ((!bool1) || (!bool2) || (!bool3) || (!bool4) || (!bool5)) {
        break label609;
      }
      bool2 = true;
      m = com.tencent.mm.compatible.deviceinfo.ae.geM.gaQ;
      n = com.tencent.mm.compatible.deviceinfo.ae.geM.gaR;
      i = this.Csj.CwQ;
      k = (this.Csj.CwQ >> 11 & 0x1) << 3 | i >> 4 & 0x7;
      j = 0;
      bool3 = false;
      if (bool2) {
        j = ezO();
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
      com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.Voip.VoipContext", "setVoipBeautyConfig local:%s, server:%s , blacklist:%s, whitelist:%s, voipBeautyFlag:%s, uiCallback:%s and isHitBlackListOrWhitList:%s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), this.Csk, Boolean.valueOf(bool1) });
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
          if (com.tencent.mm.plugin.voip.b.h.eDr())
          {
            m = com.tencent.mm.plugin.voip.b.h.eDq();
            j = com.tencent.mm.plugin.voip.b.h.eDq();
          }
        }
      }
      if (this.Csk != null) {
        this.Csk.setVoipBeauty(m);
      }
      this.Csj.Cyi = m;
      this.Csj.Cyj = j;
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
  
  public final void ezQ()
  {
    AppMethodBeat.i(177021);
    ar.f(new Runnable()
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
        if (l.this.CrG)
        {
          f.Logi("MicroMsg.Voip.VoipContext", "can not startConnectDirect again");
          AppMethodBeat.o(114896);
          return;
        }
        l.this.CrG = true;
        f.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel direct");
        if (l.this.Csj.Cyl == null)
        {
          f.Loge("MicroMsg.Voip.VoipContext", "direct conns buf null");
          AppMethodBeat.o(114896);
          return;
        }
        int i = l.this.Csj.AddNewDirectConns(l.this.Csj.Cyl, l.this.Csj.Cyl.length, 0);
        if (i < 0)
        {
          f.Loge("MicroMsg.Voip.VoipContext", "v2protocal connectToPeerDirect failed, ret:".concat(String.valueOf(i)));
          AppMethodBeat.o(114896);
          return;
        }
        l.this.ezT();
        AppMethodBeat.o(114896);
      }
    });
    AppMethodBeat.o(177021);
  }
  
  public final void ezR()
  {
    AppMethodBeat.i(177022);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114897);
        f.Logi("MicroMsg.Voip.VoipContext", "v2protocal QueryNicWanIp");
        if ((l.this.Csy != null) && (l.this.Csj.Cym != null))
        {
          int i = l.this.Csj.QueryNicWanIp(l.this.Csj.Cym, l.this.Csj.Cym.length);
          if (i != 0) {
            f.Loge("MicroMsg.Voip.VoipContext", "query nic wan ip fail ret:".concat(String.valueOf(i)));
          }
        }
        else
        {
          l.this.ezJ();
          AppMethodBeat.o(114897);
          return;
        }
        AppMethodBeat.o(114897);
      }
    });
    AppMethodBeat.o(177022);
  }
  
  public final void ezS()
  {
    AppMethodBeat.i(114928);
    if (!bu.cF(this.Csj.CwI)) {}
    for (boolean bool = true;; bool = false)
    {
      f.Logi("MicroMsg.Voip.VoipContext", "channel:try start connect, hasRemotePid:" + bool + ",mStatus:" + this.mStatus + ",isPreConnect:" + this.CrL + ",isRemoteAccepted:" + this.CrI + ",isLocalAccept:" + this.dFa);
      this.Csj.CyH.CtF = 7;
      if ((!bool) || ((this.mStatus != 4) && (this.mStatus != 5) && (this.mStatus != 6) && ((this.mStatus != 2) || (this.CrL != true)) && ((this.mStatus != 3) || (this.CrL != true)))) {
        break label329;
      }
      if ((this.mStatus == 2) || (this.mStatus == 3) || (this.mStatus == 4) || (this.mStatus == 5) || (this.mStatus == 6)) {
        break;
      }
      f.Logi("MicroMsg.Voip.VoipContext", "startConnect status fail, status:" + this.mStatus);
      AppMethodBeat.o(114928);
      return;
    }
    if ((!this.CrI) && (!this.dFa))
    {
      if ((this.CrL) && (!this.CrF))
      {
        a(new d()
        {
          public final void ezV()
          {
            AppMethodBeat.i(177016);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "onStartConnectRelay ok");
            AppMethodBeat.o(177016);
          }
        });
        AppMethodBeat.o(114928);
      }
    }
    else
    {
      if (!this.CrF)
      {
        a(new d()
        {
          public final void ezV()
          {
            AppMethodBeat.i(177017);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "onStartConnectRelay ok");
            l.this.ezQ();
            l.this.ezR();
            AppMethodBeat.o(177017);
          }
        });
        AppMethodBeat.o(114928);
        return;
      }
      ezQ();
      ezR();
    }
    label329:
    AppMethodBeat.o(114928);
  }
  
  public final void ezT()
  {
    AppMethodBeat.i(114929);
    if ((this.CrG) && (!bu.cF(this.Csj.CwK)))
    {
      int i = this.Csj.handleCommand(this.Csj.CwK, this.Csj.CwK.length);
      if (i < 0) {
        f.Loge("MicroMsg.Voip.VoipContext", "v2protocal handlecommand failed ret:".concat(String.valueOf(i)));
      }
      this.Csj.CwK = null;
    }
    AppMethodBeat.o(114929);
  }
  
  public final void ezU()
  {
    AppMethodBeat.i(114934);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "stop repeat voip sync");
    this.CsC.stopTimer();
    AppMethodBeat.o(114934);
  }
  
  public final void ezx()
  {
    int k = 0;
    AppMethodBeat.i(114901);
    if ((this.CrF == true) && (this.CrO == 0))
    {
      this.CrO = 1;
      if (this.Csj.field_speedTestInfoLength < 8)
      {
        f.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! bufsize=" + this.Csj.field_speedTestInfoLength);
        AppMethodBeat.o(114901);
      }
    }
    else
    {
      f.Loge("MicroMsg.Voip.VoipContext", "StartVoipSpeedTest fail for status is wrong: isChannelStartConnect=" + this.CrF + " ,mSpeedTestStatus=" + this.CrO);
      AppMethodBeat.o(114901);
      return;
    }
    int i = this.Csj.CyF[1];
    if (i + 2 > this.Csj.field_speedTestInfoLength)
    {
      f.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i + ", bufsize=" + this.Csj.field_speedTestInfoLength);
      AppMethodBeat.o(114901);
      return;
    }
    int j = this.Csj.CyF[(i + 2 + 1)];
    if (i + 6 + j != this.Csj.field_speedTestInfoLength)
    {
      f.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i + ", C2SRttCnt=" + j + ", bufsize=" + this.Csj.field_speedTestInfoLength);
      AppMethodBeat.o(114901);
      return;
    }
    this.CrP = this.Csj.uXg;
    this.CrR = this.Csj.netType;
    this.CrS = this.Csj.roomId;
    this.CrN.Gxq = this.Csj.roomId;
    this.CrN.HPZ = this.Csj.CwV;
    this.CrN.GqB = this.Csj.netType;
    diq localdiq = this.CrN;
    if (this.CrF == true)
    {
      i = 1;
      localdiq.HQa = i;
      localdiq = this.CrN;
      if (this.CrH != true) {
        break label482;
      }
    }
    label482:
    for (i = 1;; i = 0)
    {
      localdiq.HQb = i;
      this.CrN.HQc = this.Csj.CyF[0];
      this.CrN.HQd = this.Csj.CyF[1];
      j = 0;
      i = 2;
      while (j < this.CrN.HQd)
      {
        this.CrN.HQe.add(Integer.valueOf(this.Csj.CyF[i]));
        j += 1;
        i += 1;
      }
      i = 0;
      break;
    }
    localdiq = this.CrN;
    int[] arrayOfInt = this.Csj.CyF;
    j = i + 1;
    localdiq.HQf = arrayOfInt[i];
    localdiq = this.CrN;
    arrayOfInt = this.Csj.CyF;
    i = j + 1;
    localdiq.HQg = arrayOfInt[j];
    j = k;
    while (j < this.CrN.HQg)
    {
      this.CrN.HQh.add(Integer.valueOf(this.Csj.CyF[i]));
      j += 1;
      i += 1;
    }
    this.CrN.HQi = this.Csj.CyF[i];
    this.CrN.HQj = this.Csj.CyF[(i + 1)];
    new com.tencent.mm.plugin.voip.model.a.k(this.CrN).eBO();
    AppMethodBeat.o(114901);
  }
  
  public final void ezy()
  {
    AppMethodBeat.i(114902);
    if (this.CrO == 0)
    {
      AppMethodBeat.o(114902);
      return;
    }
    if (this.CrO == 1)
    {
      this.CrO = 0;
      this.Csj.Cyp = 0L;
      AppMethodBeat.o(114902);
      return;
    }
    this.CrO = 0;
    v2protocal localv2protocal = this.Csj;
    f.Logi("MicroMsg.Voip", "v2protocal StopVoipSpeedTest!");
    localv2protocal.StopSpeedTest();
    localv2protocal.Cyp = 0L;
    AppMethodBeat.o(114902);
  }
  
  public final void ezz()
  {
    AppMethodBeat.i(114905);
    this.Csj.CwY = this.Csl.ezX();
    this.Csj.CwZ = this.Csl.eyB();
    AppMethodBeat.o(114905);
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
      if (this.Csj != null)
      {
        dvc localdvc = new dvc();
        localdvc.IaM = 5;
        localdvc.IaN = new com.tencent.mm.bw.b(localByteBuffer.array());
        f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable local target codec: ".concat(String.valueOf(paramInt)));
        this.Csj.SendRUDP(localdvc.toByteArray(), localdvc.toByteArray().length);
      }
      if (paramBoolean2)
      {
        f.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable remote target codec: ".concat(String.valueOf(paramInt)));
        localByteBuffer = ByteBuffer.allocate(6);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer.putShort((short)3);
        localByteBuffer.putShort((short)paramInt);
        localByteBuffer.putShort((short)0);
        this.Csj.setAppCmd(35, localByteBuffer.array(), 6);
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
    this.Csj.CxL = paramInt1;
    this.Csj.CxM = paramInt2;
    this.Csj.CxN = paramInt3;
    this.Csj.CxO = paramInt4;
    this.Csj.CxP = paramInt5;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(114900);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipContext", "reset");
    if (this.Csj.eCf()) {
      this.Csj.tx(false);
    }
    this.Csj.reset();
    this.CrX = -1;
    this.CrY = -1;
    this.CrZ = -1;
    this.Csa = -1;
    this.Csb = -1;
    this.Csl.ezY();
    this.Csj.Cxc = 0;
    this.CsF.stopTimer();
    this.Csm.eBK();
    this.CsC.stopTimer();
    this.CrF = false;
    this.CrH = false;
    this.CrG = false;
    this.CrI = false;
    this.dFa = false;
    this.CrJ = false;
    this.Csn = null;
    this.Cso = null;
    this.CrT = false;
    this.CrU = false;
    this.CrV = false;
    this.Csc = false;
    this.Csd = false;
    this.Csf = false;
    this.Cse = 1;
    this.Csg = 1;
    this.Csp = false;
    this.Csh = -1;
    this.Csi = -1;
    this.CrK = false;
    this.CrL = false;
    this.CrJ = false;
    this.CrF = false;
    this.CrM = false;
    this.CrW = 10;
    this.mStatus = 1;
    this.Csu = 0;
    this.CsB = 0;
    this.Csv = false;
    this.Cst = 0;
    this.Csy = null;
    this.Csz = null;
    this.CsA.clear();
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
      this.CsF.ay(60000L, 60000L);
    }
    this.mStatus = paramInt;
    AppMethodBeat.o(114907);
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(114906);
    ezU();
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114889);
        if (l.this.Csk != null) {
          l.this.Csk.ezd();
        }
        AppMethodBeat.o(114889);
      }
    });
    AppMethodBeat.o(114906);
  }
  
  public final void tq(boolean paramBoolean)
  {
    AppMethodBeat.i(114918);
    if (!paramBoolean)
    {
      if (this.Csj != null)
      {
        if (this.Csw)
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
          this.Csj.setAppCmd(30, localByteBuffer.array(), 4);
          AppMethodBeat.o(114918);
          return;
          f.Logi("MicroMsg.Voip.VoipContext", "closecodec: remote i264 enc!");
          b(8, false, true, true);
        }
      }
    }
    else
    {
      if (this.Csw)
      {
        f.Logi("MicroMsg.Voip.VoipContext", "closeRemoteHWEnc: DecErr old!!");
        UM(2);
        AppMethodBeat.o(114918);
        return;
      }
      f.Logi("MicroMsg.Voip.VoipContext", "closeRemoteHWEnc: DecErr new!!");
      b(8, true, false, false);
    }
    AppMethodBeat.o(114918);
  }
  
  public static abstract interface a
  {
    public abstract void J(int paramInt1, int paramInt2, String paramString);
  }
  
  static abstract interface d
  {
    public abstract void ezV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l
 * JD-Core Version:    0.7.0.1
 */