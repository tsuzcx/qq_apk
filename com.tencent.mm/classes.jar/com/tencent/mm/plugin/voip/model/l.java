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
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.model.a.j;
import com.tencent.mm.protocal.protobuf.dtl;
import com.tencent.mm.protocal.protobuf.fgu;
import com.tencent.mm.protocal.protobuf.fvs;
import com.tencent.mm.protocal.protobuf.fzr;
import com.tencent.mm.protocal.protobuf.gaj;
import com.tencent.mm.protocal.protobuf.gak;
import com.tencent.mm.protocal.protobuf.gaq;
import com.tencent.mm.protocal.protobuf.gbh;
import com.tencent.mm.protocal.protobuf.gbs;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.util.b.a;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

public final class l
{
  public Network Lkt;
  public ConnectivityManager.NetworkCallback Lku;
  public LinkedList<Integer> Lkv;
  public long UyA;
  public long UyB;
  public int UyC;
  public int UyD;
  public boolean UyE;
  public boolean UyF;
  public boolean UyG;
  public int UyH;
  private int UyI;
  private int UyJ;
  private int UyK;
  private int UyL;
  private int UyM;
  public boolean UyN;
  private boolean UyO;
  private int UyP;
  private boolean UyQ;
  private int UyR;
  private int UyS;
  private int UyT;
  public v2protocal UyU;
  public x UyV;
  public n UyW;
  public w UyX;
  public byte[] UyY;
  public gaq UyZ;
  public boolean Uyq;
  public boolean Uyr;
  public boolean Uys;
  public boolean Uyt;
  public boolean Uyu;
  public boolean Uyv;
  public boolean Uyw;
  public boolean Uyx;
  public fgu Uyy;
  public int Uyz;
  public boolean Uza;
  public boolean Uzb;
  public int Uzc;
  public int Uzd;
  public int Uze;
  public int Uzf;
  public boolean Uzg;
  public boolean Uzh;
  public VoipScoreState Uzi;
  public int Uzj;
  public MTimerHandler Uzk;
  com.tencent.threadpool.i.d<?> Uzl;
  int Uzm;
  private MTimerHandler Uzn;
  private a Uzo;
  public boolean hWt;
  MMHandler mHandler;
  public int mStatus;
  public Context xNl;
  
  protected l()
  {
    AppMethodBeat.i(114899);
    this.mStatus = 1;
    this.Uyq = false;
    this.Uyr = false;
    this.Uys = false;
    this.Uyt = false;
    this.hWt = false;
    this.Uyu = false;
    this.Uyv = false;
    this.Uyw = false;
    this.Uyx = false;
    this.Uyy = new fgu();
    this.Uyz = 0;
    this.UyA = 0L;
    this.UyB = 0L;
    this.UyC = 0;
    this.UyD = 0;
    this.UyE = false;
    this.UyF = false;
    this.UyG = false;
    this.UyH = 10;
    this.UyI = -1;
    this.UyJ = -1;
    this.UyK = -1;
    this.UyL = -1;
    this.UyM = -1;
    this.UyN = false;
    this.UyO = false;
    this.UyP = 1;
    this.UyQ = false;
    this.UyR = 1;
    this.UyS = -1;
    this.UyT = -1;
    this.xNl = null;
    this.UyV = x.UCS;
    this.UyY = null;
    this.UyZ = null;
    this.Uza = false;
    this.Uzb = false;
    this.Uzc = 0;
    this.Uzd = 0;
    this.Uze = 0;
    this.Uzf = 0;
    this.Uzg = false;
    this.Uzh = true;
    this.Lkt = null;
    this.Lku = null;
    this.Lkv = new LinkedList();
    this.Uzj = 0;
    this.Uzk = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(114886);
        Log.v("MicroMsg.Voip.VoipContext", "voip repeat sync");
        l.this.UyX.a(null, false, 7);
        AppMethodBeat.o(114886);
        return true;
      }
    }, true);
    this.mHandler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        final boolean bool = true;
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
        Object localObject5;
        if (paramAnonymousMessage.arg1 == 1)
        {
          if (l.this.UyU.roomId == 0)
          {
            g.Loge("MicroMsg.Voip.VoipContext", "JNI_DOSYNC without roomid , igored!");
            AppMethodBeat.o(114891);
            return;
          }
          g.Logi("MicroMsg.Voip.VoipContext", "need dosync for cmd from channel...");
          localObject3 = (byte[])paramAnonymousMessage.obj;
          localObject1 = l.this.UyX;
          i = paramAnonymousMessage.arg2;
          paramAnonymousMessage = new gbh();
          paramAnonymousMessage.vhJ = 1;
          localObject5 = new gol();
          ((gol)localObject5).df((byte[])localObject3);
          paramAnonymousMessage.YLa = ((gol)localObject5);
          localObject3 = new gol();
          try
          {
            ((gol)localObject3).df(paramAnonymousMessage.toByteArray());
            paramAnonymousMessage = new gaj();
            paramAnonymousMessage.Zmc = i;
            paramAnonymousMessage.Zmd = ((gol)localObject3);
            paramAnonymousMessage.IMh = com.tencent.mm.model.z.bAM();
            localObject3 = new gak();
            ((gak)localObject3).vgN = 1;
            ((gak)localObject3).vgO.add(paramAnonymousMessage);
            ((w)localObject1).a((gak)localObject3, true, 2);
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
          if (l.this.UyU.roomId == 0)
          {
            g.Loge("MicroMsg.Voip.VoipContext", "JNI_STARTDEVFAILED without roomid , igored!");
            AppMethodBeat.o(114891);
            return;
          }
          g.Logi("MicroMsg.Voip.VoipContext", "need hangUP for startTalk failed. ");
          l.this.UyU.UFN.UAh = 107;
          l.this.S(1, -9004, "");
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 6)
        {
          g.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected from JNI");
          if (l.this.UyU.roomId == 0)
          {
            g.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected roomid null, ignored");
            AppMethodBeat.o(114891);
            return;
          }
          l.this.Uys = true;
          l.this.UyU.UFN.UAx = 1;
          if ((!l.this.hWt) && (!l.this.Uyt)) {}
          for (l.this.UyU.UEB = 1;; l.this.UyU.UEB = 0)
          {
            l.this.UyU.setInactive();
            g.Logi("MicroMsg.Voip.VoipContext", "Voip.Channel setInactive");
            l.this.hWG();
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
          g.Logi("MicroMsg.Voip.VoipContext", "need hangUP for disconnect from channel..envent = " + paramAnonymousMessage.arg2);
          if (l.this.mStatus >= 5)
          {
            l.this.UyU.UFN.UAh = 108;
            if (paramAnonymousMessage.arg2 != 5) {
              break label598;
            }
            l.this.UyU.UFN.UAz = 1;
            g.Logi("MicroMsg.Voip.VoipContext", "channel broken...");
          }
          for (;;)
          {
            l.this.S(1, -9000, "");
            AppMethodBeat.o(114891);
            return;
            l.this.UyU.UFN.UAh = 106;
            break;
            label598:
            if (paramAnonymousMessage.arg2 == 8)
            {
              if (l.this.Uyw == true)
              {
                g.Logi("MicroMsg.Voip.VoipContext", "channel connect fail while pre-connect");
                l.this.Uyv = true;
                AppMethodBeat.o(114891);
                return;
              }
              g.Logi("MicroMsg.Voip.VoipContext", "channel connect fail...");
              l.this.Uys = false;
              l.this.UyU.UFN.UAz = 5;
            }
          }
        }
        if (paramAnonymousMessage.arg1 == 100)
        {
          g.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.Voip.VoipContext", paramAnonymousMessage.arg2);
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 101)
        {
          g.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.v2Core", paramAnonymousMessage.arg2);
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 7)
        {
          g.Logi("MicroMsg.Voip.VoipContext", "NOTIFY_FROM_JNI_SPEEDTESTRESULT handle");
          localObject5 = (byte[])paramAnonymousMessage.obj;
          i = paramAnonymousMessage.arg2;
          paramAnonymousMessage = null;
          try
          {
            localObject1 = ConnectivityCompat.Companion.getFormattedWiFiSsid();
            paramAnonymousMessage = (Message)localObject1;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              g.Logi("MicroMsg.Voip.VoipContext", "Get wifiName failed in voip speedTest!");
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
              g.Logi("MicroMsg.Voip.VoipContext", "Get netName failed in voip speedTest!");
            }
          }
          new j(l.this.UyB, l.this.UyA, l.this.UyC, (String)localObject1, paramAnonymousMessage, l.this.UyD, i, (byte[])localObject5).hYW();
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
              localObject2 = (fvs)new fvs().parseFrom((byte[])localObject2);
              if ((!paramAnonymousMessage.Uzg) || (((fvs)localObject2).abTS != 1)) {
                g.Logi("MicroMsg.Voip.VoipContext", "steve: onRecvRUDPCmd:" + ((fvs)localObject2).abTS);
              }
              i = ((fvs)localObject2).abTS;
              switch (i)
              {
              case 20: 
              default: 
                AppMethodBeat.o(114891);
                return;
              }
            }
            catch (Exception paramAnonymousMessage)
            {
              g.Logi("MicroMsg.Voip.VoipContext", "rudp cmd processing Error");
              AppMethodBeat.o(114891);
              return;
            }
            g.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client tells us to end HWEnc!!");
            paramAnonymousMessage.UyW.UzM = true;
            AppMethodBeat.o(114891);
            return;
            if (!paramAnonymousMessage.Uzg)
            {
              g.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client end HWEnc!!");
              paramAnonymousMessage.q(8, false, true);
              paramAnonymousMessage.c(4, false, true, true);
              if (((fvs)localObject2).abTT == null) {
                break label1247;
              }
              localObject2 = ByteBuffer.wrap(((fvs)localObject2).abTT.Op, 0, 4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              i = Math.min(((ByteBuffer)localObject2).getInt(), 6);
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(i);
              g.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:CMD_VOIP_CloseHWEnc:reset maxsizeformat: ".concat(String.valueOf(i)));
              paramAnonymousMessage.UyU.setAppCmd(30, ((ByteBuffer)localObject2).array(), 4);
            }
            for (;;)
            {
              paramAnonymousMessage.Uzg = true;
              AppMethodBeat.o(114891);
              return;
              label1247:
              g.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: cmdBuffer is nil!!");
            }
            if (((fvs)localObject2).abTT != null)
            {
              localObject2 = ((fvs)localObject2).abTT.Op;
              g.Logi("MicroMsg.Voip.VoipContext", "steve: remote new network type:".concat(String.valueOf(localObject2)));
              i = paramAnonymousMessage.UyU.setAppCmd(302, (byte[])localObject2, 4);
              if (i < 0) {
                g.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + localObject2 + "fail:" + i + ", [roomid=" + paramAnonymousMessage.UyU.JHb + ", roomkey=" + paramAnonymousMessage.UyU.Hnt + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            g.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
            AppMethodBeat.o(114891);
            return;
            Object localObject4;
            if (((fvs)localObject2).abTT != null)
            {
              localObject2 = ((fvs)localObject2).abTT.Op;
              localObject2 = (fzr)new fzr().parseFrom((byte[])localObject2);
              g.Logi("MicroMsg.Voip.VoipContext", "zhengxue: remote audio dev occupied stat :" + ((fzr)localObject2).abXz);
              localObject4 = new byte[4];
              localObject4[0] = ((byte)((fzr)localObject2).abXz);
              paramAnonymousMessage.UyU.setJNIAppCmd(2, (byte[])localObject4, 4);
              AppMethodBeat.o(114891);
              return;
            }
            g.Logi("MicroMsg.Voip.VoipContext", "zhengxue:[CHANNEL]EMethod_AudioDevOccupiedStatsSync empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((fvs)localObject2).abTT != null)
            {
              localObject2 = ((fvs)localObject2).abTT.Op;
              if (paramAnonymousMessage.UyU != null)
              {
                localObject2 = ByteBuffer.wrap((byte[])localObject2);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                i = ((ByteBuffer)localObject2).getInt();
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)3);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.UyU.setAppCmd(35, ((ByteBuffer)localObject2).array(), 6);
                g.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_DisableCodec:  ".concat(String.valueOf(i)));
              }
              AppMethodBeat.o(114891);
              return;
            }
            g.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_DisableCodec empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((fvs)localObject2).abTT != null)
            {
              localObject2 = ((fvs)localObject2).abTT.Op;
              if (paramAnonymousMessage.UyU != null)
              {
                localObject2 = ByteBuffer.wrap((byte[])localObject2);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                i = ((ByteBuffer)localObject2).getInt();
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)3);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.UyU.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
                g.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder:  ".concat(String.valueOf(i)));
              }
              AppMethodBeat.o(114891);
              return;
            }
            g.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((fvs)localObject2).abTT != null)
            {
              localObject4 = ((fvs)localObject2).abTT.Op;
              if (paramAnonymousMessage.UyU != null)
              {
                localObject4 = ByteBuffer.wrap((byte[])localObject4);
                ((ByteBuffer)localObject4).order(ByteOrder.LITTLE_ENDIAN);
                i = ((ByteBuffer)localObject4).getInt();
                localObject4 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject4).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject4).putShort((short)5);
                ((ByteBuffer)localObject4).putShort((short)i);
                ((ByteBuffer)localObject4).putShort((short)0);
                paramAnonymousMessage.UyU.setAppCmd(39, ((ByteBuffer)localObject4).array(), 6);
                g.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_RecoverCodec:  ".concat(String.valueOf(i)));
              }
            }
            while (((fvs)localObject2).abTT != null)
            {
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(1);
              paramAnonymousMessage.UyU.setAppCmd(48, ((ByteBuffer)localObject2).array(), 4);
              g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAq:  1");
              AppMethodBeat.o(114891);
              return;
              g.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_RecoverCodec empty buffer");
            }
            g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAq empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((fvs)localObject2).abTT != null)
            {
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(1);
              paramAnonymousMessage.UyU.setAppCmd(70, ((ByteBuffer)localObject2).array(), 4);
              g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAdaptiveBlur:  1");
              AppMethodBeat.o(114891);
              return;
            }
            g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAdaptiveBlur empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((fvs)localObject2).abTT != null)
            {
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(1);
              paramAnonymousMessage.UyU.setAppCmd(71, ((ByteBuffer)localObject2).array(), 4);
              g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableMixDenoise:  1");
              AppMethodBeat.o(114891);
              return;
            }
            g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableMixDenoise empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((fvs)localObject2).abTT != null)
            {
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(1);
              paramAnonymousMessage.UyU.setAppCmd(72, ((ByteBuffer)localObject2).array(), 4);
              g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableVoipOpt:  1");
              AppMethodBeat.o(114891);
              return;
            }
            g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableVoipOpt empty buffer");
            AppMethodBeat.o(114891);
            return;
            int j;
            if (((fvs)localObject2).abTT != null)
            {
              localObject2 = ByteBuffer.wrap(((fvs)localObject2).abTT.Op);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              i = ((ByteBuffer)localObject2).getInt();
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt((short)i);
              g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_RemoteCpuFreq:  ".concat(String.valueOf(i)));
              j = paramAnonymousMessage.UyU.setAppCmd(84, ((ByteBuffer)localObject2).array(), 4);
              if (j < 0) {
                g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_RemoteCpuFreq:  " + i + "ret: " + j + ", [roomid=" + paramAnonymousMessage.UyU.JHb + ", roomkey=" + paramAnonymousMessage.UyU.Hnt + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_RemoteCpuFreq: empty buffer!");
            AppMethodBeat.o(114891);
            return;
            if (((fvs)localObject2).abTT != null)
            {
              localObject2 = ByteBuffer.wrap(((fvs)localObject2).abTT.Op);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              i = ((ByteBuffer)localObject2).getInt();
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt((short)i);
              g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_RemoteTotalCpuFreq:  ".concat(String.valueOf(i)));
              j = paramAnonymousMessage.UyU.setAppCmd(91, ((ByteBuffer)localObject2).array(), 4);
              if (j < 0) {
                g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_RemoteTotalCpuFreq:  " + i + "ret: " + j + ", [roomid=" + paramAnonymousMessage.UyU.JHb + ", roomkey=" + paramAnonymousMessage.UyU.Hnt + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_RemoteTotalCpuFreq: empty buffer!");
            AppMethodBeat.o(114891);
            return;
            if (((fvs)localObject2).abTT != null)
            {
              localObject2 = ((fvs)localObject2).abTT.Op;
              g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_RemoteBatteryTemp:  ".concat(String.valueOf(localObject2)));
              i = paramAnonymousMessage.UyU.setAppCmd(85, (byte[])localObject2, 4);
              if (i < 0) {
                g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_RemoteBatteryTemp:  " + localObject2 + "ret: " + i + ", [roomid=" + paramAnonymousMessage.UyU.JHb + ", roomkey=" + paramAnonymousMessage.UyU.Hnt + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_RemoteBatteryTemp: empty buffer!");
            AppMethodBeat.o(114891);
            return;
            if (((fvs)localObject2).abTT != null)
            {
              localObject2 = ((fvs)localObject2).abTT.Op;
              g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_RemoteBatteryQuan:  ".concat(String.valueOf(localObject2)));
              i = paramAnonymousMessage.UyU.setAppCmd(86, (byte[])localObject2, 4);
              if (i < 0) {
                g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_RemoteBatteryQuan:  " + localObject2 + "ret: " + i + ", [roomid=" + paramAnonymousMessage.UyU.JHb + ", roomkey=" + paramAnonymousMessage.UyU.Hnt + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_RemoteBatteryQuan: empty buffer!");
            AppMethodBeat.o(114891);
            return;
            if (((fvs)localObject2).abTT != null)
            {
              localObject2 = ((fvs)localObject2).abTT.Op;
              g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_RemoteLowBattery:  ".concat(String.valueOf(localObject2)));
              i = paramAnonymousMessage.UyU.setAppCmd(87, (byte[])localObject2, 4);
              if (i < 0) {
                g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_RemoteLowBattery:  " + localObject2 + "ret: " + i + ", [roomid=" + paramAnonymousMessage.UyU.JHb + ", roomkey=" + paramAnonymousMessage.UyU.Hnt + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_RemoteLowBattery: empty buffer!");
            AppMethodBeat.o(114891);
            return;
            if (((fvs)localObject2).abTT == null)
            {
              g.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_RemoteProtoBuf empty buffer");
              AppMethodBeat.o(114891);
              return;
              if (((fvs)localObject2).abTT != null)
              {
                localObject2 = ((fvs)localObject2).abTT.Op;
                if (paramAnonymousMessage.UyU != null)
                {
                  localObject2 = ByteBuffer.wrap((byte[])localObject2);
                  ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                  i = ((ByteBuffer)localObject2).getInt();
                  if (i != 20) {
                    break label3206;
                  }
                  localObject2 = ByteBuffer.allocate(6);
                  ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                  ((ByteBuffer)localObject2).putShort((short)2);
                  ((ByteBuffer)localObject2).putShort((short)16);
                  ((ByteBuffer)localObject2).putShort((short)0);
                  paramAnonymousMessage.UyU.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
                  localObject2 = ByteBuffer.allocate(6);
                  ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                  ((ByteBuffer)localObject2).putShort((short)2);
                  ((ByteBuffer)localObject2).putShort((short)4);
                  ((ByteBuffer)localObject2).putShort((short)0);
                  paramAnonymousMessage.UyU.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
                }
                for (;;)
                {
                  g.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder:  ".concat(String.valueOf(i)));
                  AppMethodBeat.o(114891);
                  return;
                  label3206:
                  localObject2 = ByteBuffer.allocate(6);
                  ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                  ((ByteBuffer)localObject2).putShort((short)2);
                  ((ByteBuffer)localObject2).putShort((short)i);
                  ((ByteBuffer)localObject2).putShort((short)0);
                  paramAnonymousMessage.UyU.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
                }
              }
              g.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder empty buffer");
              AppMethodBeat.o(114891);
              return;
              if (((fvs)localObject2).abTT != null)
              {
                localObject2 = ((fvs)localObject2).abTT.Op;
                g.Logi("MicroMsg.Voip.VoipContext", "anlin: remote wx ver: ".concat(String.valueOf(localObject2)));
                i = paramAnonymousMessage.UyU.setAppCmd(506, (byte[])localObject2, 4);
                if (i < 0) {
                  g.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteClientVersion] remote wx ver: " + localObject2 + "ret: " + i + ", [roomid=" + paramAnonymousMessage.UyU.JHb + ", roomkey=" + paramAnonymousMessage.UyU.Hnt + "]");
                }
                AppMethodBeat.o(114891);
                return;
              }
              g.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteClientVersion] empty buffer");
              AppMethodBeat.o(114891);
              return;
              if (((fvs)localObject2).abTT != null)
              {
                localObject4 = ((fvs)localObject2).abTT.Op;
                i = ((fvs)localObject2).abTT.Op.length;
                g.Logi("MicroMsg.Voip.VoipContext", "anlin: remote device model: ".concat(String.valueOf(localObject4)));
                i = paramAnonymousMessage.UyU.setAppCmd(508, (byte[])localObject4, i);
                if (i < 0) {
                  g.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteDeviceModel] remote device model: " + localObject4 + "ret: " + i + ", [roomid=" + paramAnonymousMessage.UyU.JHb + ", roomkey=" + paramAnonymousMessage.UyU.Hnt + "]");
                }
                AppMethodBeat.o(114891);
                return;
              }
              g.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteDeviceModel] empty buffer");
            }
          }
        }
        if (paramAnonymousMessage.arg1 == 9)
        {
          paramAnonymousMessage = l.this.UyU.UFN;
          if (0L == paramAnonymousMessage.UAL)
          {
            paramAnonymousMessage.UAL = System.currentTimeMillis();
            g.Logi("MicroMsg.VoipDailReport", "first pkt received timestamp:" + paramAnonymousMessage.UAL);
          }
          g.Logi("MicroMsg.Voip.VoipContext", "get first pkt for voip");
          if (1 == l.this.UyU.UFm)
          {
            paramAnonymousMessage = new gbs();
            paramAnonymousMessage.vhk = 1;
            l.this.UyX.a(paramAnonymousMessage, 2);
            AppMethodBeat.o(114891);
          }
        }
        else
        {
          if (paramAnonymousMessage.arg1 == 11)
          {
            l.this.Uzj = 2;
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 12)
          {
            l.this.Uzj = 1;
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 13)
          {
            localObject2 = (int[])paramAnonymousMessage.obj;
            i = paramAnonymousMessage.arg2;
            new com.tencent.mm.plugin.voip.model.a.h(l.this.UyU.roomId, l.this.UyU.Hnt, l.this.UyU.JHb, 1, i, (int[])localObject2, null).hYW();
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 14)
          {
            localObject2 = (int[])paramAnonymousMessage.obj;
            i = paramAnonymousMessage.arg2;
            new com.tencent.mm.plugin.voip.model.a.h(l.this.UyU.roomId, l.this.UyU.Hnt, l.this.UyU.JHb, 2, i, (int[])localObject2, null).hYW();
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 15)
          {
            l.this.bk(paramAnonymousMessage.arg2, false);
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 16) {
            if (paramAnonymousMessage.arg2 != 0) {
              break label3942;
            }
          }
        }
        for (;;)
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(293264);
              r.hXJ().Gs(bool);
              AppMethodBeat.o(293264);
            }
          });
          AppMethodBeat.o(114891);
          return;
          label3942:
          bool = false;
        }
      }
    };
    this.Uzl = null;
    this.Uzm = 0;
    this.Uzn = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(177018);
        if (l.this.mStatus == 4)
        {
          g.Logi("MicroMsg.Voip.VoipContext", "connect time out.. now finish..");
          l.this.UyU.UFN.UAh = 105;
          l.this.S(1, -9000, "");
        }
        AppMethodBeat.o(177018);
        return false;
      }
    }, false);
    this.Uzo = null;
    this.UyU = new v2protocal(this.mHandler);
    this.UyW = new n(this);
    this.UyW.UzR = this.UyU.Hnt;
    this.UyX = new w(this);
    this.Uzf = 0;
    this.Uzi = new VoipScoreState();
    AppMethodBeat.o(114899);
  }
  
  private int Gr(boolean paramBoolean)
  {
    AppMethodBeat.i(293303);
    g.Logi("MicroMsg.Voip.VoipContext", "EnableAq: SetAqFlag =44, aqBlur=" + paramBoolean);
    ByteBuffer localByteBuffer;
    if (paramBoolean)
    {
      localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putInt(1);
    }
    try
    {
      if (this.UyU != null)
      {
        fvs localfvs = new fvs();
        localfvs.abTS = 10;
        localfvs.abTT = new com.tencent.mm.bx.b(localByteBuffer.array());
        g.Logi("MicroMsg.Voip.VoipContext", "EnableAq: SetAqFlag =44, aqBlur=" + paramBoolean);
        this.UyU.SendRUDP(localfvs.toByteArray(), localfvs.toByteArray().length);
      }
      localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putInt(1);
      this.UyU.setAppCmd(44, localByteBuffer.array(), 4);
      AppMethodBeat.o(293303);
      return 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        g.Logi("MicroMsg.Voip.VoipContext", "EnableAq Error");
      }
    }
  }
  
  private void Q(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(293313);
    int j = paramInt1;
    int i = paramInt2;
    if (!paramBoolean)
    {
      j = paramInt1;
      i = paramInt2;
      if (paramInt1 == 0)
      {
        j = paramInt1;
        i = paramInt2;
        if (com.tencent.mm.plugin.voip.f.h.ibF())
        {
          j = com.tencent.mm.plugin.voip.f.h.ibD();
          i = com.tencent.mm.plugin.voip.f.h.ibD();
        }
      }
    }
    if (this.UyV != null) {
      this.UyV.setVoipBeauty(j);
    }
    this.UyU.UFn = j;
    this.UyU.UFo = i;
    AppMethodBeat.o(293313);
  }
  
  private void a(final l.d paramd)
  {
    AppMethodBeat.i(177020);
    if ((this.mStatus != 2) && (this.mStatus != 3) && (this.mStatus != 4))
    {
      g.Logi("MicroMsg.Voip.VoipContext", "startConnectRelay status fail, status:" + this.mStatus);
      AppMethodBeat.o(177020);
      return;
    }
    if (this.Uyq)
    {
      g.Logi("MicroMsg.Voip.VoipContext", "can not startConnectRelay again");
      AppMethodBeat.o(177020);
      return;
    }
    l.c localc = new l.c(this, (byte)0);
    localc.Uzz = new l.b()
    {
      public final void bi(final int paramAnonymousInt1, final int paramAnonymousInt2, final int paramAnonymousInt3)
      {
        AppMethodBeat.i(114895);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114894);
            g.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel relay");
            int k = l.this.UyU.UEQ;
            int m = l.this.UyU.UEQ;
            v2protocal localv2protocal = l.this.UyU;
            int n = l.this.UyU.UDt;
            long l1 = l.this.UyU.roomId;
            int i1 = l.this.UyU.JHb;
            long l2 = l.this.UyU.Hnt;
            byte[] arrayOfByte1 = l.this.UyU.UDv;
            int i2 = l.this.UyU.channelStrategy;
            int i3 = l.this.UyU.UDA;
            int i4 = l.this.UyU.UDB;
            int i5 = l.this.UyU.UDy;
            byte[] arrayOfByte2;
            int i6;
            int i7;
            int i8;
            byte[] arrayOfByte3;
            int i9;
            int i10;
            if (l.this.UyU.UDz == null)
            {
              i = 0;
              arrayOfByte2 = l.this.UyU.UDz;
              i6 = l.this.UyU.UDC;
              i7 = l.this.UyU.UDs;
              i8 = l.this.UyU.UFa;
              arrayOfByte3 = l.this.UyU.UFb;
              i9 = l.this.UyU.UFc;
              i10 = l.this.UyU.UDD;
              if (l.this.UyU.UDE != null) {
                break label521;
              }
            }
            label521:
            for (int j = 0;; j = l.this.UyU.UDE.length)
            {
              i = localv2protocal.setConfigInfo(n, l1, i1, l2, arrayOfByte1, i2, i3, i4, i5, i, arrayOfByte2, i6, (k >> 2 & 0x3) >> 1 & 0x1 & (m & 0x3) >> 1 & 0x1, i7, i8, arrayOfByte3, i9, i10, j, l.this.UyU.UDE, l.this.UyU.UFd, paramAnonymousInt1, paramAnonymousInt3, paramAnonymousInt2, "", "", v2protocal.hZn());
              if (i >= 0) {
                break label539;
              }
              g.Loge("MicroMsg.Voip.VoipContext", "v2protocal setConfigInfo or connectToPeerRelay failed, ret:".concat(String.valueOf(i)));
              l.this.UyU.UFN.UAh = 14;
              l.this.S(1, -9002, "");
              l.11.this.Uzs.hWT();
              AppMethodBeat.o(114894);
              return;
              i = l.this.UyU.UDz.length;
              break;
            }
            label539:
            if (l.this.UyU.UFq == null)
            {
              g.Loge("MicroMsg.Voip.VoipContext", "relay conns buf null");
              l.this.S(1, -9002, "");
              l.11.this.Uzs.hWT();
              AppMethodBeat.o(114894);
              return;
            }
            int i = l.this.UyU.AddNewRelayConns(l.this.UyU.UFq, l.this.UyU.UFq.length, 0);
            if (i < 0)
            {
              g.Loge("MicroMsg.Voip.VoipContext", "add relayconns err:".concat(String.valueOf(i)));
              l.this.S(1, -9002, "");
              l.11.this.Uzs.hWT();
              AppMethodBeat.o(114894);
              return;
            }
            l.this.Uyq = true;
            l.this.UyU.UFN.UAo = 1;
            l.this.UyU.UFN.UAw = 1;
            l.11.this.Uzs.hWT();
            AppMethodBeat.o(114894);
          }
        });
        AppMethodBeat.o(114895);
      }
    };
    com.tencent.threadpool.h.ahAA.bm(localc);
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
  
  private void hWF()
  {
    AppMethodBeat.i(114914);
    g.Logd("MicroMsg.Voip.VoipContext", "SrvDeviceInfo.mAudioInfo.aecMode:" + af.lXZ.lRG);
    if (af.lXZ.lRe == 1) {
      this.UyU.setAppCmd(410);
    }
    byte[] arrayOfByte1 = new byte[2];
    byte b;
    int i;
    int j;
    int k;
    label272:
    byte[] arrayOfByte2;
    label599:
    ByteBuffer localByteBuffer;
    if (af.lXZ.lRG >= 0)
    {
      arrayOfByte1[0] = ((byte)af.lXZ.lRG);
      this.UyU.setAppCmd(406, arrayOfByte1, 1);
      this.UyU.setAppCmd(432, new byte[] { 1 }, 1);
      m = af.lXZ.lRH;
      Log.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.nsModeNew %d", new Object[] { Integer.valueOf(m) });
      if (af.lXZ.lRH < 0) {
        break label783;
      }
      if (m <= 0) {
        break label764;
      }
      n = (int)Math.floor(m / 1000.0D) % 100;
      Log.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.iflag %d", new Object[] { Integer.valueOf(n) });
      if (n > 0)
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        this.UyU.setAppCmd(408, new byte[] { b, i, j, k }, 4);
      }
      m = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zjj, -1);
      Log.i("MicroMsg.Voip.VoipContext", "mevinwang, nssinfwindmode = %d", new Object[] { Integer.valueOf(m) });
      if (m > 0)
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        this.UyU.setAppCmd(408, new byte[] { b, i, j, k }, 4);
      }
      m = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ziF, -1);
      Log.i("MicroMsg.Voip.VoipContext", "kerrizhang, play_fadeinfadeout_switch = %d", new Object[] { Integer.valueOf(m) });
      arrayOfByte2 = new byte[1];
      arrayOfByte2[0] = 0;
      if (m > 0) {
        arrayOfByte2[0] = ((byte)m);
      }
      this.UyU.setAppCmd(451, arrayOfByte2, 1);
      m = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zji, -1);
      if (m <= 0) {
        break label862;
      }
      byte[] arrayOfByte3 = new byte[4];
      arrayOfByte3[0] = ((byte)(m & 0x1));
      arrayOfByte3[1] = ((byte)(m >> 1 & 0x1));
      arrayOfByte3[2] = ((byte)(m >> 2 & 0x1));
      arrayOfByte3[3] = ((byte)(m >> 8 & 0x7F));
      Log.i("MicroMsg.Voip.VoipContext", "ashlynli, x vcodec2 adaptiveBlur = %d, mixDenoise = %d, voipOpt = %d, cpuCap = %d", new Object[] { Byte.valueOf(arrayOfByte3[0]), Byte.valueOf(arrayOfByte3[1]), Byte.valueOf(arrayOfByte3[2]), Byte.valueOf(arrayOfByte3[3]) });
      m = 0;
      if (m >= 3) {
        break label862;
      }
      if (arrayOfByte3[m] == 1)
      {
        localByteBuffer = ByteBuffer.allocate(4);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer.putInt(1);
      }
    }
    for (;;)
    {
      try
      {
        if (this.UyU == null) {
          continue;
        }
        localfvs = new fvs();
        if (m != 0) {
          continue;
        }
        localfvs.abTS = 11;
      }
      catch (Exception localException)
      {
        fvs localfvs;
        label764:
        g.Logi("MicroMsg.Voip.VoipContext", "Enable Vcodec2 para RUDP CMD Error, i = ".concat(String.valueOf(m)));
        label783:
        continue;
        if (m != 2) {
          continue;
        }
        localfvs.abTS = 13;
        continue;
      }
      localfvs.abTT = new com.tencent.mm.bx.b(localByteBuffer.array());
      g.Logi("MicroMsg.Voip.VoipContext", "Enable vcodec2 para, i = " + m + " , Send RUDP CMD rudpFlag =1");
      this.UyU.SendRUDP(localfvs.toByteArray(), localfvs.toByteArray().length);
      m += 1;
      break label599;
      if (af.lXZ.lRG != -2) {
        break;
      }
      this.UyU.setAppCmd(407);
      break;
      if (m != 0) {
        break label272;
      }
      this.UyU.setAppCmd(409);
      break label272;
      if (af.lXZ.lRH != -2) {
        break label272;
      }
      this.UyU.setAppCmd(409);
      break label272;
      if (m != 1) {
        continue;
      }
      localfvs.abTS = 12;
    }
    label862:
    int m = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zjh, -1);
    Log.i("MicroMsg.Voip.VoipContext", "kerrizhang, fullbandmode = %d", new Object[] { Integer.valueOf(m) });
    int n = af.lXZ.lRJ;
    Log.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.voipfullbandcfg %d", new Object[] { Integer.valueOf(n) });
    if ((m > 0) && (n > 0))
    {
      b = (byte)(m & 0xFF);
      i = (byte)(m >> 8 & 0xFF);
      j = (byte)(m >> 16 & 0xFF);
      k = (byte)(m >> 24 & 0xFF);
      this.UyU.setAppCmd(456, new byte[] { b, i, j, k }, 4);
    }
    m = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ziG, -1);
    Log.i("MicroMsg.Voip.VoipContext", "kerrizhang, play_fadeinfadeout_thresh = %d", new Object[] { Integer.valueOf(m) });
    arrayOfByte2[0] = 0;
    if (m > 0) {
      arrayOfByte2[0] = ((byte)m);
    }
    this.UyU.setAppCmd(452, arrayOfByte2, 1);
    m = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zjg, -1);
    Log.i("MicroMsg.Voip.VoipContext", "kerrizhang, voip rcnnvad_switch = %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)m;
      this.UyU.setAppCmd(454, new byte[] { b }, 1);
    }
    m = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zjl, 0);
    Log.i("MicroMsg.Voip.VoipContext", "dennyliang, voip aec_value = %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)(m & 0xFF);
      i = (byte)(m >> 8 & 0xFF);
      j = (byte)(m >> 16 & 0xFF);
      k = (byte)(m >> 24 & 0xFF);
      this.UyU.setAppCmd(460, new byte[] { b, i, j, k }, 4);
    }
    m = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zjo, -1);
    Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, x_agc_paras: %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)(m & 0x1);
      Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, agc_switch: %d", new Object[] { Byte.valueOf(b) });
      if (b > 0)
      {
        arrayOfByte2 = new byte[7];
        arrayOfByte2[0] = ((byte)(m >> 1 & 0x1F));
        arrayOfByte2[1] = ((byte)(m >> 6 & 0x1F));
        arrayOfByte2[2] = ((byte)(m >> 11 & 0x3));
        arrayOfByte2[3] = ((byte)(m >> 13 & 0x3));
        arrayOfByte2[4] = ((byte)(m >> 15 & 0x1));
        arrayOfByte2[5] = ((byte)(m >> 16 & 0x7));
        arrayOfByte2[6] = ((byte)(m >> 19 & 0xF));
        Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, agc para: %d, %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(arrayOfByte2[0]), Byte.valueOf(arrayOfByte2[1]), Byte.valueOf(arrayOfByte2[2]), Byte.valueOf(arrayOfByte2[3]), Byte.valueOf(arrayOfByte2[4]), Byte.valueOf(arrayOfByte2[5]), Byte.valueOf(arrayOfByte2[6]) });
        this.UyU.setAppCmd(404, arrayOfByte2, 7);
      }
    }
    else
    {
      if (af.lXZ.lRL < 0) {
        break label2562;
      }
      arrayOfByte2 = new byte[7];
      if ((af.lXZ.lRM >= 0) && (af.lXZ.lRN >= 0))
      {
        arrayOfByte2[0] = ((byte)af.lXZ.lRM);
        arrayOfByte2[1] = ((byte)af.lXZ.lRN);
        if (af.lXZ.lRO < 0) {
          break label2545;
        }
        arrayOfByte2[2] = ((byte)af.lXZ.lRO);
        arrayOfByte2[3] = ((byte)af.lXZ.lRL);
        arrayOfByte2[4] = ((byte)af.lXZ.lRP);
        arrayOfByte2[5] = ((byte)af.lXZ.lRQ);
        arrayOfByte2[6] = ((byte)af.lXZ.lRR);
        this.UyU.setAppCmd(404, arrayOfByte2, 7);
      }
    }
    for (;;)
    {
      m = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zjs, -1);
      Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, tryUpdateAudioAdaption, frz_sta_p_x = %d", new Object[] { Integer.valueOf(m) });
      if (m > 0)
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        this.UyU.setAppCmd(464, new byte[] { b, i, j, k }, 4);
      }
      m = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ziJ, -1);
      Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, updateAudioAdaption, net_state_xexpt = %d", new Object[] { Integer.valueOf(m) });
      arrayOfByte2 = new byte[1];
      arrayOfByte2[0] = 0;
      if (m == 1) {
        arrayOfByte2[0] = 1;
      }
      this.UyU.setAppCmd(936, arrayOfByte2, 1);
      m = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ziE, -1);
      Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, tryUpdateAudioAdaption, switch_flag_x = %d", new Object[] { Integer.valueOf(m) });
      arrayOfByte2 = new byte[1];
      arrayOfByte2[0] = 0;
      if (m > 0) {
        arrayOfByte2[0] = 1;
      }
      this.UyU.setAppCmd(450, arrayOfByte2, 1);
      if ((af.lXZ.lRf >= 0) || (af.lXZ.lRh >= 0))
      {
        arrayOfByte1[0] = -1;
        arrayOfByte1[1] = -1;
        if (af.lXZ.lRf >= 0) {
          arrayOfByte1[0] = ((byte)af.lXZ.lRf);
        }
        if (af.lXZ.lRh >= 0) {
          arrayOfByte1[1] = ((byte)af.lXZ.lRh);
        }
        this.UyU.setAppCmd(414, arrayOfByte1, 2);
      }
      if ((af.lXZ.lRg >= 0) || (af.lXZ.lRi >= 0))
      {
        arrayOfByte1[0] = -1;
        arrayOfByte1[1] = -1;
        if (af.lXZ.lRg >= 0) {
          arrayOfByte1[0] = ((byte)af.lXZ.lRg);
        }
        if (af.lXZ.lRi >= 0) {
          arrayOfByte1[1] = ((byte)af.lXZ.lRi);
        }
        this.UyU.setAppCmd(415, arrayOfByte1, 2);
      }
      if ((af.lXZ.lRj >= 0) || (af.lXZ.lRk >= 0))
      {
        arrayOfByte1[0] = -1;
        arrayOfByte1[1] = -1;
        if (af.lXZ.lRj >= 0) {
          arrayOfByte1[0] = ((byte)af.lXZ.lRj);
        }
        if (af.lXZ.lRk >= 0) {
          arrayOfByte1[1] = ((byte)af.lXZ.lRk);
        }
        this.UyU.setAppCmd(422, arrayOfByte1, 2);
      }
      if (af.lXZ.lRp >= 0)
      {
        arrayOfByte1[0] = ((byte)af.lXZ.lRp);
        this.UyU.setAppCmd(416, arrayOfByte1, 1);
      }
      if (af.lXZ.lRt >= 0)
      {
        arrayOfByte1[0] = ((byte)af.lXZ.lRt);
        this.UyU.setAppCmd(431, arrayOfByte1, 4);
      }
      if ((af.lXZ.lRq >= 0) && ((this.UyU.UEK != 0) || (af.lXZ.lRq != 5)))
      {
        arrayOfByte1[0] = ((byte)af.lXZ.lRq);
        this.UyU.setAppCmd(417, arrayOfByte1, 1);
      }
      if ((af.lXZ.lRr >= 0) && ((this.UyU.UEK != 0) || (af.lXZ.lRr != 5)))
      {
        arrayOfByte1[0] = ((byte)af.lXZ.lRr);
        this.UyU.setAppCmd(418, arrayOfByte1, 1);
      }
      if (af.lXZ.lRs >= 0)
      {
        arrayOfByte1[0] = ((byte)af.lXZ.lRs);
        this.UyU.setAppCmd(419, arrayOfByte1, 1);
      }
      if ((this.UyU.UEK == 1) && ((af.lXZ.lRq == 5) || (af.lXZ.lRr == 5))) {
        this.UyU.UEd = 5;
      }
      if (1 != af.lXZ.lSf) {
        break label2602;
      }
      arrayOfByte2 = new byte[30];
      m = 0;
      while (m < 15)
      {
        arrayOfByte2[(m * 2)] = ((byte)(af.lXZ.lSg[m] & 0xFF));
        arrayOfByte2[(m * 2 + 1)] = ((byte)(af.lXZ.lSg[m] >> 8 & 0xFF));
        m += 1;
      }
      this.UyU.setAppCmd(405);
      break;
      label2545:
      this.UyU.setAppCmd(404, arrayOfByte2, 2);
      continue;
      label2562:
      if (af.lXZ.lRL == -2) {
        this.UyU.setAppCmd(405);
      }
    }
    this.UyU.setAppCmd(420, arrayOfByte2, 30);
    label2602:
    if (af.lXZ.lSf == 0) {
      this.UyU.setAppCmd(421);
    }
    if ((af.lXZ.lSh[0] > 0) || (af.lXZ.lSh[1] > 0))
    {
      arrayOfByte1[0] = 0;
      arrayOfByte1[1] = 0;
      if ((af.lXZ.lSh[0] > 0) && (af.lXZ.lSh[0] < 10000)) {
        arrayOfByte1[0] = ((byte)af.lXZ.lSh[0]);
      }
      if ((af.lXZ.lSh[1] > 0) && (af.lXZ.lSh[1] < 10000)) {
        arrayOfByte1[1] = ((byte)af.lXZ.lSh[1]);
      }
      this.UyU.setAppCmd(423, arrayOfByte1, 2);
    }
    if (af.lXZ.lSj > 0)
    {
      arrayOfByte1[0] = ((byte)af.lXZ.lSj);
      this.UyU.setAppCmd(424, arrayOfByte1, 1);
    }
    m = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zjp, -1);
    Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, x_agcrx_para: %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)(m & 0x1);
      Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, agcrx_switch: %d", new Object[] { Byte.valueOf(b) });
      if (b > 0)
      {
        arrayOfByte1 = new byte[4];
        arrayOfByte1[0] = ((byte)(m >> 1 & 0x3));
        arrayOfByte1[1] = ((byte)(m >> 3 & 0x1F));
        arrayOfByte1[2] = ((byte)(m >> 8 & 0x1F));
        arrayOfByte1[3] = ((byte)(m >> 13 & 0x1));
        Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, agcrx paras: %d, %d, %d, %d", new Object[] { Byte.valueOf(arrayOfByte1[0]), Byte.valueOf(arrayOfByte1[1]), Byte.valueOf(arrayOfByte1[2]), Byte.valueOf(arrayOfByte1[3]) });
        this.UyU.setAppCmd(426, arrayOfByte1, 4);
      }
    }
    if (af.lXZ.lSr >= 0)
    {
      b = (byte)af.lXZ.lSr;
      i = (byte)af.lXZ.lSs;
      j = (byte)af.lXZ.lSt;
      k = (byte)af.lXZ.lSu;
      this.UyU.setAppCmd(426, new byte[] { b, i, j, k }, 4);
    }
    AppMethodBeat.o(114914);
  }
  
  private static boolean hWK()
  {
    AppMethodBeat.i(293308);
    int i = m.aOK();
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
      l = com.tencent.matrix.e.a.aG(MMApplicationContext.getContext()) / 1024L / 1024L;
      if (j < ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoy, 4)) {
        break label345;
      }
      bool2 = true;
      if (k < ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoz, 45)) {
        break label351;
      }
      bool3 = true;
      if (m < ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoA, 23)) {
        break label357;
      }
      bool4 = true;
      label136:
      if (l < ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoB, 4096)) {
        break label363;
      }
    }
    label345:
    label351:
    label357:
    label363:
    for (boolean bool5 = true;; bool5 = false)
    {
      double d = com.tencent.matrix.e.a.aAk();
      Debug.MemoryInfo localMemoryInfo = com.tencent.matrix.e.a.cm(MMApplicationContext.getContext());
      Log.i("MicroMsg.Voip.VoipContext", "checkVoipBeautyLocalConfig, cpuFlags:%s, isNeon:%s, nCores:%s, nFreq:%s, sdkInt:%s, totalMemMB:%s, coreNumCheck:%s, freqCheck:%s, sdkIntCheck:%s, totalMemMBCheck:%s, cpuRate:%s, dalvikPss:%s, nativePss:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Double.valueOf(d), Integer.valueOf(localMemoryInfo.dalvikPss), Integer.valueOf(localMemoryInfo.nativePss) });
      if ((!bool1) || (!bool2) || (!bool3) || (!bool4) || (!bool5)) {
        break label369;
      }
      AppMethodBeat.o(293308);
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
    AppMethodBeat.o(293308);
    return false;
  }
  
  private static int hWL()
  {
    AppMethodBeat.i(184050);
    String str1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoC, "");
    if (!Util.isNullOrNil(str1)) {
      try
      {
        com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i(str1);
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
  
  public final void S(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(114937);
    hWS();
    if (this.Uzo != null) {
      this.Uzo.S(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(114937);
  }
  
  public final void a(a parama)
  {
    if (parama != null) {
      this.Uzo = parama;
    }
  }
  
  public final void a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.UyU.UDy = paramInt1;
    this.UyU.UDz = paramArrayOfByte1;
    this.UyU.UFa = paramInt2;
    this.UyU.UFb = paramArrayOfByte2;
  }
  
  public final boolean a(gaq paramgaq)
  {
    this.UyZ = paramgaq;
    this.UyU.mkQ = this.UyZ.abXZ;
    this.UyU.roomId = this.UyZ.Zvz;
    this.UyU.Hnt = this.UyZ.ZvA;
    this.UyU.JHb = 1;
    this.UyU.UDt = 0;
    this.mStatus = 3;
    return true;
  }
  
  public final void aqd(int paramInt)
  {
    AppMethodBeat.i(114903);
    this.UyU.LpO = Math.abs(paramInt);
    AppMethodBeat.o(114903);
  }
  
  public final void aqe(int paramInt)
  {
    AppMethodBeat.i(114904);
    this.UyU.UDJ = Math.abs(paramInt);
    if (paramInt != 0) {
      this.UyV.fwi();
    }
    AppMethodBeat.o(114904);
  }
  
  public final void aqf(int paramInt)
  {
    this.UyU.UDM = paramInt;
  }
  
  public final void aqg(int paramInt)
  {
    AppMethodBeat.i(114910);
    if ((8 == paramInt) || (9 == paramInt)) {
      this.UyM = paramInt;
    }
    for (;;)
    {
      if ((1 == paramInt) || (3 == paramInt)) {
        aqh(2);
      }
      SubCoreVoip.hVp().UBE.UvH = false;
      SubCoreVoip.hVp().hYz();
      this.UyV.VQ(paramInt);
      AppMethodBeat.o(114910);
      return;
      this.UyK = paramInt;
      this.UyI = paramInt;
    }
  }
  
  public final void aqh(int paramInt)
  {
    AppMethodBeat.i(114911);
    if ((8 == paramInt) || (9 == paramInt)) {
      this.UyL = paramInt;
    }
    for (;;)
    {
      this.UyX.aqC(paramInt);
      AppMethodBeat.o(114911);
      return;
      this.UyI = paramInt;
      this.UyJ = paramInt;
    }
  }
  
  public final boolean aqm(int paramInt)
  {
    AppMethodBeat.i(293376);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.put((byte)paramInt);
    paramInt = this.UyU.setAppCmd(21, localByteBuffer.array(), 4);
    if (paramInt < 0) {
      g.Logi("MicroMsg.Voip.VoipContext", "voipContext setOrientation ret:".concat(String.valueOf(paramInt)));
    }
    if (paramInt == 0)
    {
      AppMethodBeat.o(293376);
      return true;
    }
    AppMethodBeat.o(293376);
    return false;
  }
  
  public final void aqn(int paramInt)
  {
    AppMethodBeat.i(114925);
    try
    {
      fvs localfvs = new fvs();
      localfvs.abTS = paramInt;
      if (1 == paramInt)
      {
        g.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:send maxsizeformat: !!6");
        ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer.putInt(6);
        localfvs.abTT = new com.tencent.mm.bx.b(localByteBuffer.array());
        this.UyU.setAppCmd(32, localByteBuffer.array(), 4);
      }
      for (;;)
      {
        this.UyU.SendRUDP(localfvs.toByteArray(), localfvs.toByteArray().length);
        g.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: send RUDP data to close remote HW encoding!Type:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(114925);
        return;
        localfvs.abTT = null;
      }
      return;
    }
    catch (Exception localException)
    {
      g.Logi("MicroMsg.Voip.VoipContext", "onVoipSendCloseHWEncCmd Error");
      AppMethodBeat.o(114925);
    }
  }
  
  public final void aqo(int paramInt)
  {
    AppMethodBeat.i(114926);
    g.Logi("MicroMsg.Voip.VoipContext", "zhengxue: audio device occupied stat sync stat " + paramInt + " app 1");
    try
    {
      Object localObject = new byte[4];
      localObject[0] = ((byte)paramInt);
      this.UyU.setJNIAppCmd(2, (byte[])localObject, 4);
      localObject = new fzr();
      ((fzr)localObject).abXz = paramInt;
      ((fzr)localObject).abXA = 1;
      fvs localfvs = new fvs();
      localfvs.abTS = 4;
      localfvs.abTT = new com.tencent.mm.bx.b(((fzr)localObject).toByteArray(), 0, 1);
      this.UyU.SendRUDP(localfvs.toByteArray(), localfvs.toByteArray().length);
      AppMethodBeat.o(114926);
      return;
    }
    catch (Exception localException)
    {
      g.Logi("MicroMsg.Voip.VoipContext", "onAudioDevOccupiedStat Error");
      AppMethodBeat.o(114926);
    }
  }
  
  public final void aqp(int paramInt)
  {
    this.UyU.UFc = paramInt;
  }
  
  public final void aqq(int paramInt)
  {
    this.UyU.UEV = paramInt;
  }
  
  public final void aqr(int paramInt)
  {
    this.UyU.UFN.UAn = 1;
    this.UyU.channelStrategy = paramInt;
  }
  
  public final void aqs(int paramInt)
  {
    this.UyU.UDC = paramInt;
  }
  
  public final void bk(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(114921);
    g.Logi("MicroMsg.Voip.VoipContext", "start bindSocket " + paramInt + " ToNetwork " + this.Lkt + " rebind " + paramBoolean);
    if (paramInt == -1)
    {
      geB();
      AppMethodBeat.o(114921);
      return;
    }
    if ((this.Lkt != null) && (com.tencent.mm.compatible.util.d.rb(23)))
    {
      FileDescriptor localFileDescriptor = new FileDescriptor();
      try
      {
        Field localField = FileDescriptor.class.getDeclaredField("descriptor");
        localField.setAccessible(true);
        localField.setInt(localFileDescriptor, paramInt);
        this.Lkt.bindSocket(localFileDescriptor);
        if (!paramBoolean) {
          this.Lkv.add(Integer.valueOf(paramInt));
        }
        g.Logd("MicroMsg.Voip.VoipContext", "bindSocketToNetwork success: network" + this.Lkt + "+socketfd" + paramInt);
        AppMethodBeat.o(114921);
        return;
      }
      catch (Exception localException)
      {
        g.Logi("MicroMsg.Voip.VoipContext", "bindSocketToNetwork Error");
      }
    }
    AppMethodBeat.o(114921);
  }
  
  public final void bo(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(293349);
    if (!paramBoolean1)
    {
      if (this.UyU != null)
      {
        if (this.Uzh)
        {
          g.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc: Set P2S HW Flag False!!");
          q(8, false, true);
        }
        for (;;)
        {
          ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
          localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
          localByteBuffer.putInt(6);
          g.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc:reset maxsizeformat: 6");
          this.UyU.setAppCmd(30, localByteBuffer.array(), 4);
          AppMethodBeat.o(293349);
          return;
          g.Logi("MicroMsg.Voip.VoipContext", "closecodec: remote i264 enc!");
          c(8, false, true, true);
        }
      }
    }
    else
    {
      if (this.Uzh)
      {
        g.Logi("MicroMsg.Voip.VoipContext", "closeRemoteHWEnc: DecErr old!!");
        aqn(2);
        AppMethodBeat.o(293349);
        return;
      }
      g.Logi("MicroMsg.Voip.VoipContext", "closeRemoteHWEnc: DecErr new!!");
      if (paramBoolean2)
      {
        c(4, true, false, false);
        AppMethodBeat.o(293349);
        return;
      }
      c(8, true, false, false);
    }
    AppMethodBeat.o(293349);
  }
  
  public final int c(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(184049);
    if (paramInt < 0)
    {
      AppMethodBeat.o(184049);
      return -1;
    }
    g.Logi("MicroMsg.Voip.VoipContext", "CloseCodec: targetCodec =" + paramInt + ", local=" + paramBoolean1 + ", remote =" + paramBoolean2 + "encTag=" + paramBoolean3);
    ByteBuffer localByteBuffer1;
    if ((paramBoolean1) && (paramBoolean3))
    {
      localByteBuffer1 = ByteBuffer.allocate(4);
      localByteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer1.putInt(paramInt);
    }
    for (;;)
    {
      fvs localfvs;
      try
      {
        if (this.UyU != null)
        {
          localfvs = new fvs();
          localfvs.abTS = 6;
          localfvs.abTT = new com.tencent.mm.bx.b(localByteBuffer1.array());
          g.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(paramInt)));
          this.UyU.SendRUDP(localfvs.toByteArray(), localfvs.toByteArray().length);
        }
        localByteBuffer1 = ByteBuffer.allocate(6);
        localByteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer1.putShort((short)2);
        localByteBuffer1.putShort((short)paramInt);
        localByteBuffer1.putShort((short)0);
        this.UyU.setAppCmd(39, localByteBuffer1.array(), 6);
        AppMethodBeat.o(184049);
        return 1;
      }
      catch (Exception localException1)
      {
        g.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        continue;
      }
      if ((paramBoolean1) && (!paramBoolean3))
      {
        ByteBuffer localByteBuffer2 = ByteBuffer.allocate(6);
        localByteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer2.putShort((short)0);
        localByteBuffer2.putShort((short)paramInt);
        localByteBuffer2.putShort((short)0);
        this.UyU.setAppCmd(39, localByteBuffer2.array(), 6);
        localByteBuffer2 = ByteBuffer.allocate(4);
        localByteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer2.putInt(paramInt);
        try
        {
          if (this.UyU == null) {
            continue;
          }
          localfvs = new fvs();
          localfvs.abTS = 7;
          localfvs.abTT = new com.tencent.mm.bx.b(localByteBuffer2.array());
          g.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(paramInt)));
          this.UyU.SendRUDP(localfvs.toByteArray(), localfvs.toByteArray().length);
        }
        catch (Exception localException2)
        {
          g.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        }
      }
      else if ((paramBoolean2) && (paramBoolean3))
      {
        g.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:disable remote target codec: ".concat(String.valueOf(paramInt)));
        ByteBuffer localByteBuffer3 = ByteBuffer.allocate(6);
        localByteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer3.putShort((short)3);
        localByteBuffer3.putShort((short)paramInt);
        localByteBuffer3.putShort((short)0);
        this.UyU.setAppCmd(39, localByteBuffer3.array(), 6);
        localByteBuffer3 = ByteBuffer.allocate(4);
        localByteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer3.putInt(paramInt);
        try
        {
          if (this.UyU != null)
          {
            localfvs = new fvs();
            localfvs.abTS = 7;
            localfvs.abTT = new com.tencent.mm.bx.b(localByteBuffer3.array());
            g.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(paramInt)));
            this.UyU.SendRUDP(localfvs.toByteArray(), localfvs.toByteArray().length);
          }
        }
        catch (Exception localException3)
        {
          g.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        }
      }
    }
  }
  
  public final void c(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.UyU.UFh = paramInt;
    this.UyU.UFi = paramArrayOfByte1;
    this.UyU.UFj = paramArrayOfByte2;
  }
  
  public final void cC(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114930);
    Log.i("MicroMsg.Voip.VoipContext", "updateRemotePid");
    this.UyU.UFN.UAm = 1;
    this.UyU.UFN.UAl = 1;
    this.UyU.UDv = paramArrayOfByte;
    AppMethodBeat.o(114930);
  }
  
  public final void cD(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    AppMethodBeat.i(114932);
    Log.i("MicroMsg.Voip.VoipContext", "updateRemoteCapInfo, isGotCapInfo: %s", new Object[] { Byte.valueOf(this.UyU.UFN.UAq) });
    if ((this.UyU.UFN.UAq == 1) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(114932);
      return;
    }
    this.UyU.UFN.UAq = 1;
    this.UyU.UDw = paramArrayOfByte;
    if (this.UyU.UDw != null)
    {
      int i = this.UyU.exchangeCabInfo(this.UyU.UDw, this.UyU.UDw.length);
      if ((this.UyU.UDw == null) || (this.UyU.UDw.length < 36)) {
        bool = true;
      }
      this.Uzh = bool;
      if (i < 0)
      {
        g.Loge("MicroMsg.Voip.VoipContext", "protocal exchangecabinfo failed ret:".concat(String.valueOf(i)));
        this.UyU.UFN.UAh = 15;
        S(1, -9003, "");
      }
    }
    AppMethodBeat.o(114932);
  }
  
  public final void cE(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114933);
    this.UyU.UDx = paramArrayOfByte;
    hWR();
    AppMethodBeat.o(114933);
  }
  
  public final int cb(LinkedList<dtl> paramLinkedList)
  {
    int j = 0;
    AppMethodBeat.i(114936);
    Object localObject = new LinkedList();
    int k = this.UyU.cc((LinkedList)localObject);
    int i = j;
    if (k == 0)
    {
      if ((((LinkedList)localObject).size() == 0) || (((LinkedList)localObject).size() > 2))
      {
        AppMethodBeat.o(114936);
        return 0;
      }
      if ((((dtl)((LinkedList)localObject).get(0)).aaZf == 1) && ((((dtl)((LinkedList)localObject).get(0)).Zoz == 5) || (((dtl)((LinkedList)localObject).get(0)).Zoz == 6)))
      {
        paramLinkedList.add((dtl)((LinkedList)localObject).get(0));
        this.UyU.UEi = 1;
        AppMethodBeat.o(114936);
        return 0;
      }
      paramLinkedList.add((dtl)((LinkedList)localObject).get(0));
      this.UyU.UEh = 1;
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
      dtl localdtl = new dtl();
      localdtl.aavb = "android-cellular";
      localdtl.aaZf = 0;
      localdtl.Zoz = 5;
      localdtl.aaZg = (((String)localObject).substring(0, 3) + ":" + ((String)localObject).substring(3, ((String)localObject).length()));
      paramLinkedList.add(localdtl);
      this.UyU.UEi = 1;
      i = j;
    }
    while (i < paramLinkedList.size())
    {
      Log.d("MicroMsg.Voip.VoipContext", "nic_name:" + ((dtl)paramLinkedList.get(i)).aavb + " nic_role:" + ((dtl)paramLinkedList.get(i)).aaZf + " net_type:" + ((dtl)paramLinkedList.get(i)).Zoz + " nic_isp_info:" + ((dtl)paramLinkedList.get(i)).aaZg);
      i += 1;
    }
    AppMethodBeat.o(114936);
    return k;
  }
  
  public final int gdZ()
  {
    AppMethodBeat.i(114909);
    n localn = this.UyW;
    if (localn.UzC != null)
    {
      int i = localn.UzC.gdZ();
      AppMethodBeat.o(114909);
      return i;
    }
    AppMethodBeat.o(114909);
    return 0;
  }
  
  public final void geA()
  {
    AppMethodBeat.i(114915);
    g.Logi("MicroMsg.Voip.VoipContext", "In networkRequestViaCellular");
    if (com.tencent.mm.compatible.util.d.rb(21))
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
      Object localObject = new NetworkRequest.Builder();
      ((NetworkRequest.Builder)localObject).addTransportType(0);
      ((NetworkRequest.Builder)localObject).addCapability(12);
      localObject = ((NetworkRequest.Builder)localObject).build();
      g.Logi("MicroMsg.Voip.VoipContext", "NetworkRequest toString: " + ((NetworkRequest)localObject).toString() + " hashCode: " + ((NetworkRequest)localObject).hashCode());
      try
      {
        localConnectivityManager.requestNetwork((NetworkRequest)localObject, new l.7(this));
        AppMethodBeat.o(114915);
        return;
      }
      catch (Exception localException)
      {
        g.Logi("MicroMsg.Voip.VoipContext", "missing the appropriate permissions");
        this.UyU.UEj = 2;
        AppMethodBeat.o(114915);
        return;
      }
    }
    AppMethodBeat.o(114915);
  }
  
  public final void geB()
  {
    AppMethodBeat.i(114916);
    g.Logi("MicroMsg.Voip.VoipContext", "try to UnregisterCellularNetwork");
    ConnectivityManager localConnectivityManager;
    if (com.tencent.mm.compatible.util.d.rb(21))
    {
      localConnectivityManager = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
      if (this.Lku != null) {
        g.Logi("MicroMsg.Voip.VoipContext", "unregister networkcallback hashCode: " + this.Lku.hashCode());
      }
    }
    try
    {
      localConnectivityManager.unregisterNetworkCallback(this.Lku);
      this.Lku = null;
      this.Lkt = null;
      AppMethodBeat.o(114916);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        g.Logi("MicroMsg.Voip.VoipContext", "unregisterNetworkCallback Error");
      }
    }
  }
  
  public final boolean hWA()
  {
    return this.mStatus == 3;
  }
  
  public final boolean hWB()
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
  
  public final long hWC()
  {
    return this.UyU.UDI;
  }
  
  public final boolean hWD()
  {
    if (this.UyG) {
      return false;
    }
    switch (this.UyI)
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
        } while (4 == this.UyJ);
        return false;
      } while ((4 == this.UyJ) || (-1 == this.UyJ));
      return false;
      if ((5 == this.UyJ) || (6 == this.UyJ)) {
        break;
      }
    } while (7 != this.UyJ);
    return false;
  }
  
  public final boolean hWE()
  {
    if (this.UyG) {
      return false;
    }
    switch (this.UyI)
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
        } while (4 == this.UyJ);
        return false;
      } while ((4 == this.UyK) || (this.UyK == 0) || (-1 == this.UyK));
      return false;
      if ((5 == this.UyK) || (6 == this.UyK)) {
        break;
      }
    } while (7 != this.UyK);
    return false;
  }
  
  public final void hWG()
  {
    AppMethodBeat.i(114917);
    g.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: try start talk");
    if ((this.Uyu != true) || (this.Uys != true))
    {
      g.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: fail isCanSendData " + this.Uyu + ", isChannelConnectedSuccess " + this.Uys);
      AppMethodBeat.o(114917);
      return;
    }
    g.Logi("MicroMsg.Voip.VoipContext", "Voip tryStartTalk, channel setActive");
    this.UyU.setActive();
    if (this.Uyx == true)
    {
      g.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: engine already started, isEngineStarted " + this.Uyx);
      AppMethodBeat.o(114917);
      return;
    }
    this.UyU.setSvrConfig(205, 0, 0, this.UyU.UFd, 0, 0, 0, 0, null);
    this.UyU.setSvrConfig(207, 0, 0, this.UyU.UDD, 0, 0, 0, 0, null);
    g.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.UyU.UFd + " SwitchFlag = " + this.UyU.UDD);
    this.UyU.UDG[0] = ((byte)af.lYj.lUv);
    this.UyU.UDG[1] = ((byte)af.lYj.lUw);
    this.UyU.UDG[2] = ((byte)af.lYj.lUx);
    this.UyU.UDG[3] = ((byte)af.lYj.lUy);
    this.UyU.UDG[4] = ((byte)af.lYj.lUz);
    this.UyU.UDG[5] = ((byte)af.lYj.lUA);
    this.UyU.UDG[6] = ((byte)af.lYj.lUB);
    this.UyU.UDG[7] = ((byte)af.lYj.lUC);
    this.UyU.UDG[8] = ((byte)af.lYj.lUD);
    this.UyU.UDG[9] = ((byte)af.lYj.lUE);
    this.UyU.setSvrConfig(209, 0, 0, 0, 0, 0, 0, this.UyU.UDG.length, this.UyU.UDG);
    int j = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zve, -1);
    if (j > 0) {
      this.UyU.setSvrConfig(211, j, 0, 0, 0, 0, 0, 0, null);
    }
    j = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zvf, -1);
    int k = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zvg, -1);
    int m = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zvh, -1);
    this.UyU.setSvrConfig(210, j, k, m, 0, 0, 0, 0, null);
    if (this.UyU.startEngine() == 0) {
      this.UyU.UFN.UAH = 0;
    }
    for (;;)
    {
      int n;
      label930:
      label952:
      Object localObject2;
      if (this.UyU.UDF != null) {
        if (this.UyU.UDF.length < 1024)
        {
          this.UyU.setSvrConfig(208, 0, 0, 0, 0, 0, 0, this.UyU.UDF.length, this.UyU.UDF);
          if (this.UyU.UDF.length >= 31)
          {
            j = ByteBuffer.wrap(this.UyU.UDF, 108, 4).getInt();
            k = ByteBuffer.wrap(this.UyU.UDF, 112, 4).getInt();
            m = ByteBuffer.wrap(this.UyU.UDF, 116, 4).getInt();
            n = ByteBuffer.wrap(this.UyU.UDF, 120, 4).getInt();
            int i1 = g.bfN("hwenc");
            int i2 = g.bfN("hwdec");
            int i3 = g.bfN("swenc");
            int i4 = g.bfN("swdec");
            if ((j & 0xF | (k & 0xF) << 4 | (m & 0xF) << 8 | (n & 0xF) << 12) != (i1 & 0xF | (i2 & 0xF) << 4 | (i3 & 0xF) << 8 | (i4 & 0xF) << 12))
            {
              g.hA("hwenc", j);
              g.hA("hwdec", k);
              g.hA("swenc", m);
              g.hA("swdec", n);
            }
            g.Logi("MicroMsg.Voip.VoipContext", "ashlynli:nHWEncCap:" + j + ", nHWDecCap:" + k + ", nSWEncCap:" + m + ", nSWDecCap:" + n + ", nPrevHWEncCap:" + i1 + ", nPrevHWDecCap:" + i2 + ", nPrevSWEncCap:" + i3 + ", nPrevSWDecCap:" + i4);
          }
          hWF();
          if ((hWD()) || (hWE())) {
            break label3324;
          }
          hWJ();
          this.UyV.fwm();
          localObject2 = this.UyW;
          if (((n)localObject2).wTK != 2) {
            break label3372;
          }
          g.Loge("MicroMsg.Voip.VoipDeviceHandler", "dev start already...");
          ??? = this.UyU.UFN;
          if (((o)???).beginTime != 0L) {
            break label3972;
          }
          ((o)???).UAA = 0;
          label1010:
          g.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + ((o)???).beginTime + ", CurrentTime: " + System.currentTimeMillis());
          g.Logi("MicroMsg.VoipDailReport", "devin:endNewDial:" + ((o)???).UAA);
          this.UyV.onConnected();
          this.mStatus = 5;
          ??? = this.UyU.UFN;
          ((o)???).UAI = System.currentTimeMillis();
          g.Logi("MicroMsg.VoipDailReport", "devin:beginTalk:" + ((o)???).UAI);
          this.UyU.setSvrConfig(202, this.UyU.UEC, this.UyU.UED, 0, 0, 0, 0, 0, null);
          this.UyU.setSvrConfig(203, 0, 0, this.UyU.UEH, 0, 0, 0, 0, null);
          this.UyU.setSvrConfig(206, 0, 0, this.UyU.UEL, 0, 0, 0, 0, null);
          this.UyU.setSvrConfig(103, this.UyU.UEE, this.UyU.UEF, this.UyU.UEG, this.UyU.UEJ, 0, 0, 0, null);
          this.UyU.setSvrConfig(205, 0, 0, this.UyU.UFd, 0, 0, 0, 0, null);
          this.UyU.setSvrConfig(207, 0, 0, this.UyU.UDD, 0, 0, 0, 0, null);
          g.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.UyU.UFd + " SwitchFlag = " + this.UyU.UDD);
          j = this.UyU.UEQ >> 2 & 0x3;
          k = this.UyU.UEQ & 0x3;
          if (this.UyU.JHb != 0) {
            break label3990;
          }
          j = (j << 2) + k;
          label1390:
          this.UyU.setSvrConfig(502, 0, 0, j, 0, 0, 0, 0, null);
          this.UyU.setSvrConfig(503, 0, 0, this.UyU.UER, this.UyU.UES, this.UyU.UET, this.UyU.UEU, 0, null);
          if ((this.UyU.UFi != null) && (this.UyU.UFj != null))
          {
            this.UyU.setSvrConfig(504, 0, 0, this.UyU.UFh, 0, 0, 0, 0, null);
            this.UyU.setSvrConfig(505, 0, 0, this.UyU.UFi[0], this.UyU.UFi[1], this.UyU.UFi[2], this.UyU.UFi[3], 0, null);
            this.UyU.setSvrConfig(506, 0, 0, this.UyU.UFj[0], this.UyU.UFj[1], 0, 0, 0, null);
            g.Logi("MicroMsg.Voip.VoipContext", "FECSvrCtr = " + this.UyU.UFh + ",FECKeyPara1 = " + this.UyU.UFi[0] + "," + this.UyU.UFi[1] + "," + this.UyU.UFi[2] + "," + this.UyU.UFi[3] + ",FECKeyPara2 = " + this.UyU.UFj[0] + "," + this.UyU.UFj[1]);
          }
          k = this.UyU.UEV;
          m = this.UyU.UEV;
          n = this.UyU.UEV;
          this.UyU.setSvrConfig(507, 0, 0, (k & 0x4) >> 2, (m & 0x2) >> 1, n & 0x1, 0, 0, null);
          this.UyU.setjbmbitraterssvrparam();
          g.Logi("MicroMsg.Voip.VoipContext", "zhengxue[Logic] setSvrConfig brefore onStartTalk: audioTsdfBeyond3G = " + this.UyU.UEC + ",audioTsdEdge = " + this.UyU.UED + ",passthroughQosAlgorithm = " + this.UyU.UEE + ",fastPlayRepair = " + this.UyU.UEF + ", audioDTX = " + this.UyU.UEH + ", mARQFlag = " + j + ", mQosStrategy = " + this.UyU.UEV + ", mSvrCfgListV = " + this.UyU.UEG + ", maxBRForRelay = " + this.UyU.UEJ);
          ??? = new byte[2];
          ???[0] = ((byte)af.lXY.lTs);
          ???[1] = -1;
          g.Logd("MicroMsg.Voip.VoipContext", "steve: Model Name: " + q.aPo());
          g.Logd("MicroMsg.Voip.VoipContext", "steve: Image Enhancement for Android Capture!!, mode: " + ???[0]);
          this.UyU.setAppCmd(15, (byte[])???, 1);
          g.Logd("MicroMsg.Voip.VoipContext", "anlin: ClientVersion: " + com.tencent.mm.protocal.d.Yxh);
          ??? = ByteBuffer.allocate(4);
          ((ByteBuffer)???).order(ByteOrder.LITTLE_ENDIAN).putInt(com.tencent.mm.protocal.d.Yxh);
          ??? = ((ByteBuffer)???).array();
          this.UyU.setAppCmd(505, (byte[])???, 4);
        }
      }
      label3972:
      label3990:
      try
      {
        if (this.UyU != null)
        {
          localObject2 = new fvs();
          ((fvs)localObject2).abTS = 8;
          ((fvs)localObject2).abTT = new com.tencent.mm.bx.b((byte[])???);
          g.Logi("MicroMsg.Voip.VoipContext", "anlin send local client version: ".concat(String.valueOf(???)));
          this.UyU.SendRUDP(((fvs)localObject2).toByteArray(), ((fvs)localObject2).toByteArray().length);
        }
        ??? = q.aPo();
        j = ((String)???).length();
        ??? = ((String)???).getBytes();
        g.Logi("MicroMsg.Voip.VoipContext", "anlin DeviceModel: ".concat(String.valueOf(???)));
        this.UyU.setAppCmd(507, (byte[])???, j);
      }
      catch (Exception localException1)
      {
        label3372:
        label4033:
        label4166:
        try
        {
          if (this.UyU != null)
          {
            localObject2 = new fvs();
            ((fvs)localObject2).abTS = 9;
            ((fvs)localObject2).abTT = new com.tencent.mm.bx.b((byte[])???);
            g.Logi("MicroMsg.Voip.VoipContext", "anlin send local device model: ".concat(String.valueOf(???)));
            this.UyU.SendRUDP(((fvs)localObject2).toByteArray(), ((fvs)localObject2).toByteArray().length);
          }
          if ((this.UyU.UDD >> 17 & 0x1) != 0)
          {
            bool1 = true;
            if ((this.UyU.UDD >> 18 & 0x1) == 0) {
              break label4033;
            }
            bool2 = true;
            Gr(bool1);
            g.Logi("MicroMsg.Voip.VoipContext", "EnableBlur: SetBlurFlag =47, aqBlur=" + bool2);
            if (bool2)
            {
              ??? = ByteBuffer.allocate(4);
              ((ByteBuffer)???).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)???).putInt(1);
              this.UyU.setAppCmd(47, ((ByteBuffer)???).array(), 4);
            }
            if (!v2protocal.UDn)
            {
              ??? = ByteBuffer.allocate(4);
              ((ByteBuffer)???).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)???).putInt(1);
              this.UyU.setAppCmd(68, ((ByteBuffer)???).array(), 4);
              g.Logi("MicroMsg.Voip.VoipContext", "hseasun: Voip close 720p Enc:  1");
            }
            if ((this.UyU.UDD & 0x2) == 0)
            {
              q(16, true, true);
              q(4, true, true);
            }
            j = this.UyU.UDD >> 12 & 0x1;
            ??? = ByteBuffer.allocate(4);
            ((ByteBuffer)???).order(ByteOrder.LITTLE_ENDIAN);
            ((ByteBuffer)???).putInt(j);
            g.Logi("MicroMsg.Voip.VoipContext", "weiranli set MixVcodec1 from svr = ".concat(String.valueOf(j)));
            this.UyU.setAppCmd(46, ((ByteBuffer)???).array(), 4);
            if ((this.UyU.UDD & 0x200) == 0)
            {
              ??? = ByteBuffer.allocate(4);
              ((ByteBuffer)???).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)???).putInt(8);
              g.Logi("MicroMsg.Voip.VoipContext", "jcchen Disable 720p from svr: mSwitchFlag = " + this.UyU.UDD);
              this.UyU.setAppCmd(32, ((ByteBuffer)???).array(), 4);
              this.UyU.setAppCmd(30, ((ByteBuffer)???).array(), 4);
            }
            if ((this.UyU.UDD & 0x100000) == 0) {
              break label4039;
            }
            g.Logi("MicroMsg.Voip.VoipContext", "setAppCmd: EMethodSetP2SSendThreadEnable enble, mSwitchFlag: " + this.UyU.UDD);
            this.UyU.setAppCmd(52);
            if (com.tencent.mm.platformtools.z.pDa == 0) {
              break label4071;
            }
            ??? = ByteBuffer.allocate(4);
            ((ByteBuffer)???).order(ByteOrder.LITTLE_ENDIAN);
            ((ByteBuffer)???).putInt(com.tencent.mm.platformtools.z.pDa);
            this.UyU.setAppCmd(36, ((ByteBuffer)???).array(), 4);
            ??? = new byte[4];
            this.UyU.setAppCmd(26, (byte[])???, 4);
            ??? = ByteBuffer.wrap((byte[])???);
            ((ByteBuffer)???).order(ByteOrder.LITTLE_ENDIAN);
            m = ((ByteBuffer)???).getInt();
            g.Logd("MicroMsg.Voip.VoipContext", "steve: iHW: ".concat(String.valueOf(m)));
            if (((this.UyU.UEG & 0x4) == 0) && (af.lXY.lTu <= 0)) {
              break label4166;
            }
            j = 1;
            if ((j == 0) && (this.UyU.wVN))
            {
              g.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:Server Disable HW enc/dec!!");
              if ((m & 0x4) == 0) {
                break label4171;
              }
              j = 1;
              if ((m & 0x8) == 0) {
                break label4176;
              }
              k = 1;
              if ((j != 0) || (k != 0))
              {
                this.UyW.UzM = true;
                bo(false, false);
              }
              this.UyU.wVN = false;
            }
            if (this.UyU.wVN)
            {
              localObject2 = this.UyU;
              n = af.lXY.lTu;
              bool1 = false;
              if ((m & 0x4) == 0) {
                break label4181;
              }
              j = 1;
              if ((m & 0x8) == 0) {
                break label4186;
              }
              k = 1;
              if ((j != 0) || (k != 0))
              {
                if (j == 0) {
                  break label4191;
                }
                ??? = "video/hevc";
                g.Logi("MicroMsg.Voip", "steve : create HW encoder successfully:".concat(String.valueOf(???)));
                ((v2protocal)localObject2).UFQ = new e(((v2protocal)localObject2).width, ((v2protocal)localObject2).height, ((v2protocal)localObject2).UFT, ((v2protocal)localObject2).bitrate, n, (String)???);
                ((v2protocal)localObject2).UFQ.UwI = v2protocal.UFR;
                if (v2protocal.UFU != null)
                {
                  v2protocal.UFS = new d(v2protocal.UFU);
                  g.Logi("MicroMsg.Voip", "steve : create HW decoder successfully!");
                }
                bool1 = true;
              }
              if ((((v2protocal)localObject2).UFQ == null) || (v2protocal.UFS == null))
              {
                ((v2protocal)localObject2).wVN = false;
                bool1 = false;
              }
              g.Logi("MicroMsg.Voip.VoipContext", "steve: HW encoder/decoder init ret: " + bool1 + ", iHW:" + m);
              if (!this.UyU.wVN)
              {
                g.Logi("MicroMsg.Voip.VoipContext", "steve: HW dec/enc NOT supported for both sides,end HWEnc!!");
                this.UyW.UzM = true;
                bo(false, false);
                c(8, true, false, true);
                c(8, true, false, false);
              }
            }
            if (this.UyU.UFQ != null) {
              this.UyU.UFQ.UvO = this;
            }
            if (v2protocal.UFS != null) {
              v2protocal.UFS.a(this);
            }
            this.Uyx = true;
            this.Uzg = false;
            ??? = this.Uzi;
            ((VoipScoreState)???).JIn = br.bCJ();
            Log.i("MicroMsg.VoipScoreState", "markStartTalk, startTalkTime:%s", new Object[] { Long.valueOf(((VoipScoreState)???).JIn) });
            hWH();
            hWI();
            AppMethodBeat.o(114917);
            return;
            this.Uyx = false;
            this.UyU.UFN.UAH = 1;
            continue;
            g.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: length of generalStrategyBuf = " + this.UyU.UDF.length);
            break label930;
            g.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: protocol has null generalStrategyBuf");
            break label930;
            label3324:
            if (this.Uzl != null)
            {
              hWJ();
              break label952;
            }
            this.Uzm = 0;
            this.Uzl = com.tencent.threadpool.h.ahAA.b(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(114893);
                l locall = l.this;
                locall.Uzm += 1;
                if ((l.this.UyU.UFB != 0) || (l.this.Uzm > 10))
                {
                  l.this.hWJ();
                  if (l.this.Uzl != null)
                  {
                    l.this.Uzl.cancel(false);
                    l.this.Uzl = null;
                  }
                  AppMethodBeat.o(114893);
                  return;
                }
                AppMethodBeat.o(114893);
              }
            }, 200L, 200L);
            break label952;
            g.Logi("MicroMsg.Voip.VoipDeviceHandler", "start device......");
            ((n)localObject2).wTK = 2;
            ((n)localObject2).UzM = false;
            ((n)localObject2).UzN = 0;
            if (((n)localObject2).UzQ != null)
            {
              Log.i("MicroMsg.Voip.VoipDeviceHandler", "mDevHandlerThread is not null");
              if (!((n)localObject2).UzQ.isQuit()) {
                Log.i("MicroMsg.Voip.VoipDeviceHandler", "mDevHandlerThread is alive");
              }
            }
            ((n)localObject2).UzQ.removeCallbacksAndMessages(null);
            if (((n)localObject2).UzW != null)
            {
              g.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
              ((n)localObject2).UzW.hXa();
              ((n)localObject2).UzW.cancel();
              ((n)localObject2).UzW = null;
            }
            ((n)localObject2).UzW = new n.a((n)localObject2);
            ThreadPool.post(((n)localObject2).UzW, "VoipDeviceHandler_decode");
            g.Logd("MicroMsg.Voip.VoipDeviceHandler", "start video decode thread..");
            af.lXZ.aQ();
            for (;;)
            {
              synchronized (((n)localObject2).UzK)
              {
                if (((n)localObject2).wTK == n.wTJ)
                {
                  Log.e("MicroMsg.Voip.VoipDeviceHandler", "current is not allowed to start dev");
                  ((n)localObject2).hWV();
                  break;
                }
                ((n)localObject2).UzC = new c();
                ((n)localObject2).UzC.Uwc = String.valueOf(((n)localObject2).UzR);
                Object localObject4 = new a();
                j = ((n)localObject2).UvO.UyU.a((a)localObject4);
                g.Logi("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.GetAudioDeviceFmt, play samplerate:" + ((a)localObject4).NjF + ", framelen: " + ((a)localObject4).UvK + ", ret:" + j);
                ((n)localObject2).UzC.ac(((a)localObject4).NjF, ((a)localObject4).channels, ((a)localObject4).UvK, 0);
                localObject4 = new f.a();
                ((f.a)localObject4).lYS = SystemClock.elapsedRealtime();
                ((n)localObject2).wTL = ((n)localObject2).UzC.R(((n)localObject2).UvO.xNl, true);
                long l = ((f.a)localObject4).aPY();
                ((f.a)localObject4).lYS = SystemClock.elapsedRealtime();
                ((n)localObject2).UvO.UyU.UDV = ((int)l);
                ((n)localObject2).UvO.UyU.UEb = ((n)localObject2).UzC.gdZ();
                ((n)localObject2).UvO.UyU.UDX = com.tencent.mm.plugin.audio.c.a.getMode();
                ((n)localObject2).UvO.UyU.UEf = ((n)localObject2).UzC.pep;
                if (((n)localObject2).UzC.UvN == true)
                {
                  j = 1;
                  int i = (byte)j;
                  ((n)localObject2).UvO.UyU.setAppCmd(502, new byte[] { i }, 1);
                  if (((n)localObject2).wTL <= 10)
                  {
                    if (((n)localObject2).wTL <= 0) {
                      ((n)localObject2).wTO = 1;
                    }
                    ((n)localObject2).wTL = 92;
                  }
                  if ((!com.tencent.mm.plugin.audio.c.a.cTQ()) && (!com.tencent.mm.plugin.audio.c.a.cTX())) {
                    break label3962;
                  }
                  SubCoreVoip.hVp().yQ(true);
                  ((n)localObject2).UzC.UvX = new n.3((n)localObject2);
                  if (((n)localObject2).UzC.hVD() <= 0) {
                    ((n)localObject2).wTO = 1;
                  }
                }
              }
              j = 0;
              continue;
              label3962:
              SubCoreVoip.hVp().yQ(false);
            }
            ((o)???).UAA = ((int)(System.currentTimeMillis() - ((o)???).beginTime));
            break label1010;
            j = (k << 2) + j;
            break label1390;
            localException1 = localException1;
            g.Logi("MicroMsg.Voip.VoipContext", "anlin send local client version Error!");
          }
        }
        catch (Exception localException2)
        {
          label4039:
          label4171:
          label4176:
          label4181:
          label4186:
          label4191:
          for (;;)
          {
            g.Logi("MicroMsg.Voip.VoipContext", "anlin send local device model Error!");
            continue;
            boolean bool1 = false;
            continue;
            boolean bool2 = false;
            continue;
            g.Logi("MicroMsg.Voip.VoipContext", "setAppCmd: EMethodSetP2SSendThreadEnable disable, mSwitchFlag: " + this.UyU.UDD);
            continue;
            label4071:
            if (com.tencent.mm.platformtools.z.pDb != 0)
            {
              if ((com.tencent.mm.platformtools.z.pDb & 0x2) != 0) {
                q(2, true, false);
              }
              if ((com.tencent.mm.platformtools.z.pDb & 0x20) != 0) {
                q(32, true, false);
              }
              if ((com.tencent.mm.platformtools.z.pDb & 0x10) != 0) {
                q(16, true, false);
              }
              if ((com.tencent.mm.platformtools.z.pDb & 0x4) != 0) {
                q(4, true, false);
              }
              if ((com.tencent.mm.platformtools.z.pDb & 0x8) != 0)
              {
                q(8, true, false);
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
  
  public final boolean hWH()
  {
    AppMethodBeat.i(114922);
    boolean bool = hWD();
    int i = 0;
    if (bool) {
      i = 1;
    }
    if ((this.UyS == -1) || (this.UyS != i))
    {
      if (!bool) {
        break label112;
      }
      g.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video Out.......!");
    }
    for (int j = this.UyU.setAppCmd(203);; j = this.UyU.setAppCmd(202))
    {
      if (j == 0)
      {
        this.UyS = i;
        g.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: succeed, ret: " + j + "sendVideoStatus: " + this.UyS);
      }
      AppMethodBeat.o(114922);
      return bool;
      label112:
      g.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video Out.......!");
    }
  }
  
  public final boolean hWI()
  {
    AppMethodBeat.i(114923);
    boolean bool = hWE();
    int i = 0;
    if (bool) {
      i = 1;
    }
    if ((this.UyT == -1) || (this.UyT != i))
    {
      if (!bool) {
        break label112;
      }
      g.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video In.......!");
    }
    for (int j = this.UyU.setAppCmd(201);; j = this.UyU.setAppCmd(200))
    {
      if (j == 0)
      {
        this.UyT = i;
        g.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: succeed, ret: " + j + "recvVideoStatus: " + this.UyT);
      }
      AppMethodBeat.o(114923);
      return bool;
      label112:
      g.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video In.......!");
    }
  }
  
  final void hWJ()
  {
    AppMethodBeat.i(114924);
    if (this.mStatus == 5)
    {
      setStatus(6);
      this.UyU.UFN.hXb();
      g.Logi("MicroMsg.Voip.VoipContext", "talking  now .......!");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114892);
          l.this.UyV.fwl();
          AppMethodBeat.o(114892);
        }
      });
    }
    AppMethodBeat.o(114924);
  }
  
  public final void hWM()
  {
    AppMethodBeat.i(184051);
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
    if (com.tencent.mm.util.i.a(b.a.agsH, 0) != 0)
    {
      locali = com.tencent.mm.util.i.agtt;
      i = com.tencent.mm.util.i.a(b.a.agsH, 0);
      Log.i("MicroMsg.Voip.VoipContext", "use repairer beauty flag:%s", new Object[] { Integer.valueOf(i) });
      Q(i, i, false);
      AppMethodBeat.o(184051);
      return;
    }
    boolean bool2 = hWK();
    int j = com.tencent.mm.plugin.voip.f.h.ibE();
    int k = af.lXY.lTA;
    int i = this.UyU.UDD;
    int m = (this.UyU.UDD >> 11 & 0x1) << 3 | i >> 4 & 0x7;
    if (bool2) {}
    for (i = hWL();; i = 0)
    {
      boolean bool1;
      if ((k >= 0) || (j >= 0)) {
        if (j >= 0)
        {
          bool1 = true;
          i = j;
        }
      }
      for (;;)
      {
        Log.printInfoStack("MicroMsg.Voip.VoipContext", "setVoipBeautyConfig local:%s, server:%s , blacklist:%s, whitelist:%s, voipBeautyFlag:%s, uiCallback:%s and isHitBlackListOrWhitList:%s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), this.UyV, Boolean.valueOf(bool1) });
        Q(i, m, bool1);
        AppMethodBeat.o(184051);
        return;
        if (m == 0)
        {
          bool1 = true;
          i = k;
          continue;
          if ((bool2) && (m > 0))
          {
            bool1 = false;
            i = m;
            continue;
          }
        }
        bool1 = false;
      }
    }
  }
  
  public final void hWN()
  {
    int m = 1;
    int k = 0;
    AppMethodBeat.i(293385);
    int j;
    int n;
    int i1;
    int i2;
    Boolean localBoolean;
    int i;
    if ((hWK()) && (v2protocal.hZp()))
    {
      j = 1;
      n = af.lXY.lTB;
      i1 = af.lXY.lTC;
      i2 = this.UyU.UDD >> 15 & 0x1;
      localBoolean = Boolean.valueOf(com.tencent.mm.plugin.voip.f.h.ibH());
      if (i1 <= 0) {
        break label191;
      }
      i = 0;
      label70:
      if (!com.tencent.mm.plugin.voip.f.h.ibI()) {
        break label227;
      }
      Log.d("MicroMsg.Voip.VoipContext", "licaguo: disable STFilter for surface encoding");
      i = k;
    }
    label191:
    label227:
    for (;;)
    {
      if (this.UyV != null) {
        this.UyV.setSpatiotemporalDenosing(i);
      }
      Log.i("MicroMsg.Voip.VoipContext", "hseasun: voipSTFilterSvrCfg:" + i2 + " voipSTFilterWhiteList:" + n + " voipSTFilterBlackList:" + i1 + " voipSTFilterFlag:%d " + i + " xSettingEnableSTFitler:" + localBoolean);
      this.UyU.UFp = i;
      AppMethodBeat.o(293385);
      return;
      j = 0;
      break;
      i = m;
      if (n > 0) {
        break label70;
      }
      if (j != 0)
      {
        i = m;
        if (i2 > 0) {
          break label70;
        }
        i = m;
        if (localBoolean.booleanValue()) {
          break label70;
        }
      }
      i = 0;
      break label70;
    }
  }
  
  public final void hWO()
  {
    AppMethodBeat.i(177021);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114896);
        if ((l.this.mStatus != 4) && (l.this.mStatus != 5) && (l.this.mStatus != 6))
        {
          g.Logi("MicroMsg.Voip.VoipContext", "startConnectDirect status fail, status:" + l.this.mStatus);
          AppMethodBeat.o(114896);
          return;
        }
        if (l.this.Uyr)
        {
          g.Logi("MicroMsg.Voip.VoipContext", "can not startConnectDirect again");
          AppMethodBeat.o(114896);
          return;
        }
        l.this.Uyr = true;
        g.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel direct");
        if (l.this.UyU.UFr == null)
        {
          g.Loge("MicroMsg.Voip.VoipContext", "direct conns buf null");
          AppMethodBeat.o(114896);
          return;
        }
        int i = l.this.UyU.AddNewDirectConns(l.this.UyU.UFr, l.this.UyU.UFr.length, 0);
        if (i < 0)
        {
          g.Loge("MicroMsg.Voip.VoipContext", "v2protocal connectToPeerDirect failed, ret:".concat(String.valueOf(i)));
          AppMethodBeat.o(114896);
          return;
        }
        l.this.hWR();
        AppMethodBeat.o(114896);
      }
    });
    AppMethodBeat.o(177021);
  }
  
  public final void hWP()
  {
    AppMethodBeat.i(177022);
    MMHandlerThread.postToMainThread(new l.13(this));
    AppMethodBeat.o(177022);
  }
  
  public final void hWQ()
  {
    AppMethodBeat.i(114928);
    if (!Util.isNullOrNil(this.UyU.UDv)) {}
    for (boolean bool = true;; bool = false)
    {
      g.Logi("MicroMsg.Voip.VoipContext", "channel:try start connect, hasRemotePid:" + bool + ",mStatus:" + this.mStatus + ",isPreConnect:" + this.Uyw + ",isRemoteAccepted:" + this.Uyt + ",isLocalAccept:" + this.hWt);
      this.UyU.UFN.UAt = 7;
      if ((!bool) || ((this.mStatus != 4) && (this.mStatus != 5) && (this.mStatus != 6) && ((this.mStatus != 2) || (this.Uyw != true)) && ((this.mStatus != 3) || (this.Uyw != true)))) {
        break label329;
      }
      if ((this.mStatus == 2) || (this.mStatus == 3) || (this.mStatus == 4) || (this.mStatus == 5) || (this.mStatus == 6)) {
        break;
      }
      g.Logi("MicroMsg.Voip.VoipContext", "startConnect status fail, status:" + this.mStatus);
      AppMethodBeat.o(114928);
      return;
    }
    if ((!this.Uyt) && (!this.hWt))
    {
      if ((this.Uyw) && (!this.Uyq))
      {
        a(new l.2(this));
        AppMethodBeat.o(114928);
      }
    }
    else
    {
      if (!this.Uyq)
      {
        a(new l.3(this));
        AppMethodBeat.o(114928);
        return;
      }
      hWO();
      hWP();
    }
    label329:
    AppMethodBeat.o(114928);
  }
  
  public final void hWR()
  {
    AppMethodBeat.i(114929);
    if ((this.Uyr) && (!Util.isNullOrNil(this.UyU.UDx)))
    {
      int i = this.UyU.handleCommand(1, this.UyU.UDx, this.UyU.UDx.length);
      if (i < 0) {
        g.Loge("MicroMsg.Voip.VoipContext", "v2protocal handlecommand failed ret:".concat(String.valueOf(i)));
      }
      this.UyU.UDx = null;
    }
    AppMethodBeat.o(114929);
  }
  
  public final void hWS()
  {
    AppMethodBeat.i(114934);
    Log.i("MicroMsg.Voip.VoipContext", "stop repeat voip sync");
    this.Uzk.stopTimer();
    AppMethodBeat.o(114934);
  }
  
  public final void hWv()
  {
    int k = 0;
    AppMethodBeat.i(114901);
    if ((this.Uyq == true) && (this.Uyz == 0))
    {
      this.Uyz = 1;
      if (this.UyU.field_speedTestInfoLength < 8)
      {
        g.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! bufsize=" + this.UyU.field_speedTestInfoLength);
        AppMethodBeat.o(114901);
      }
    }
    else
    {
      g.Loge("MicroMsg.Voip.VoipContext", "StartVoipSpeedTest fail for status is wrong: isChannelStartConnect=" + this.Uyq + " ,mSpeedTestStatus=" + this.Uyz);
      AppMethodBeat.o(114901);
      return;
    }
    int i = this.UyU.UFL[1];
    if (i + 2 > this.UyU.field_speedTestInfoLength)
    {
      g.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i + ", bufsize=" + this.UyU.field_speedTestInfoLength);
      AppMethodBeat.o(114901);
      return;
    }
    int j = this.UyU.UFL[(i + 2 + 1)];
    if (i + 6 + j != this.UyU.field_speedTestInfoLength)
    {
      g.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i + ", C2SRttCnt=" + j + ", bufsize=" + this.UyU.field_speedTestInfoLength);
      AppMethodBeat.o(114901);
      return;
    }
    this.UyA = this.UyU.Hnt;
    this.UyC = this.UyU.netType;
    this.UyD = this.UyU.roomId;
    this.Uyy.Zvz = this.UyU.roomId;
    this.Uyy.abGP = this.UyU.UDI;
    this.Uyy.ZkT = this.UyU.netType;
    fgu localfgu = this.Uyy;
    if (this.Uyq == true)
    {
      i = 1;
      localfgu.abGQ = i;
      localfgu = this.Uyy;
      if (this.Uys != true) {
        break label482;
      }
    }
    label482:
    for (i = 1;; i = 0)
    {
      localfgu.abGR = i;
      this.Uyy.abGS = this.UyU.UFL[0];
      this.Uyy.abGT = this.UyU.UFL[1];
      j = 0;
      i = 2;
      while (j < this.Uyy.abGT)
      {
        this.Uyy.abGU.add(Integer.valueOf(this.UyU.UFL[i]));
        j += 1;
        i += 1;
      }
      i = 0;
      break;
    }
    localfgu = this.Uyy;
    int[] arrayOfInt = this.UyU.UFL;
    j = i + 1;
    localfgu.abGV = arrayOfInt[i];
    localfgu = this.Uyy;
    arrayOfInt = this.UyU.UFL;
    i = j + 1;
    localfgu.abGW = arrayOfInt[j];
    j = k;
    while (j < this.Uyy.abGW)
    {
      this.Uyy.abGX.add(Integer.valueOf(this.UyU.UFL[i]));
      j += 1;
      i += 1;
    }
    this.Uyy.abGY = this.UyU.UFL[i];
    this.Uyy.abGZ = this.UyU.UFL[(i + 1)];
    new com.tencent.mm.plugin.voip.model.a.k(this.Uyy).hYW();
    AppMethodBeat.o(114901);
  }
  
  public final void hWw()
  {
    AppMethodBeat.i(114902);
    if (this.Uyz == 0)
    {
      AppMethodBeat.o(114902);
      return;
    }
    if (this.Uyz == 1)
    {
      this.Uyz = 0;
      this.UyU.UFv = 0L;
      AppMethodBeat.o(114902);
      return;
    }
    this.Uyz = 0;
    v2protocal localv2protocal = this.UyU;
    g.Logi("MicroMsg.Voip", "v2protocal StopVoipSpeedTest!");
    localv2protocal.StopSpeedTest();
    localv2protocal.UFv = 0L;
    AppMethodBeat.o(114902);
  }
  
  public final void hWx()
  {
    AppMethodBeat.i(114905);
    this.UyU.UDK = this.UyW.hWW();
    this.UyU.UDL = this.UyW.hVG();
    AppMethodBeat.o(114905);
  }
  
  public final int hWy()
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
  
  public final boolean hWz()
  {
    return (this.mStatus == 2) || (this.mStatus == 4);
  }
  
  public final void p(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.UyU.UEQ = paramInt1;
    this.UyU.UER = paramInt2;
    this.UyU.UES = paramInt3;
    this.UyU.UET = paramInt4;
    this.UyU.UEU = paramInt5;
  }
  
  public final int q(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(114919);
    if (paramInt < 0)
    {
      AppMethodBeat.o(114919);
      return -1;
    }
    g.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:DisableCodec: targetCodec = " + paramInt + ", local=" + paramBoolean1 + ", remote =" + paramBoolean2);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.putInt(paramInt);
    if (paramBoolean1) {}
    try
    {
      if (this.UyU != null)
      {
        fvs localfvs = new fvs();
        localfvs.abTS = 5;
        localfvs.abTT = new com.tencent.mm.bx.b(localByteBuffer.array());
        g.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable local target codec: ".concat(String.valueOf(paramInt)));
        this.UyU.SendRUDP(localfvs.toByteArray(), localfvs.toByteArray().length);
      }
      if (paramBoolean2)
      {
        g.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable remote target codec: ".concat(String.valueOf(paramInt)));
        localByteBuffer = ByteBuffer.allocate(6);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer.putShort((short)3);
        localByteBuffer.putShort((short)paramInt);
        localByteBuffer.putShort((short)0);
        this.UyU.setAppCmd(35, localByteBuffer.array(), 6);
      }
      AppMethodBeat.o(114919);
      return 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        g.Logi("MicroMsg.Voip.VoipContext", "DisableCodec Error");
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(114900);
    Log.i("MicroMsg.Voip.VoipContext", "reset");
    this.UyW.hWX();
    if (this.UyU.hZm()) {
      this.UyU.Gw(false);
    }
    this.UyU.reset();
    this.UyI = -1;
    this.UyJ = -1;
    this.UyK = -1;
    this.UyL = -1;
    this.UyM = -1;
    this.UyU.UDO = 0;
    this.Uzn.stopTimer();
    this.UyX.hYS();
    this.Uzk.stopTimer();
    this.Uyq = false;
    this.Uys = false;
    this.Uyr = false;
    this.Uyt = false;
    this.hWt = false;
    this.Uyu = false;
    this.UyY = null;
    this.UyZ = null;
    this.UyE = false;
    this.UyF = false;
    this.UyG = false;
    this.UyN = false;
    this.UyO = false;
    this.UyQ = false;
    this.UyP = 1;
    this.UyR = 1;
    this.Uza = false;
    this.UyS = -1;
    this.UyT = -1;
    this.Uyv = false;
    this.Uyw = false;
    this.Uyu = false;
    this.Uyq = false;
    this.Uyx = false;
    this.UyH = 10;
    this.mStatus = 1;
    this.Uzf = 0;
    this.Uzj = 0;
    this.Uzg = false;
    this.Uze = 0;
    this.Lkt = null;
    this.Lkv.clear();
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
      this.Uzn.startTimer(60000L);
    }
    this.mStatus = paramInt;
    AppMethodBeat.o(114907);
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(114906);
    hWS();
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114889);
        if (l.this.UyV != null) {
          l.this.UyV.vI(false);
        }
        AppMethodBeat.o(114889);
      }
    });
    AppMethodBeat.o(114906);
  }
  
  public static abstract interface a
  {
    public abstract void S(int paramInt1, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l
 * JD-Core Version:    0.7.0.1
 */