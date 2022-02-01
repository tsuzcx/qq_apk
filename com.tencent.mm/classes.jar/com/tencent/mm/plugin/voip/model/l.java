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
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.c.g;
import com.tencent.mm.plugin.voip.model.a.j;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.emb;
import com.tencent.mm.protocal.protobuf.ezo;
import com.tencent.mm.protocal.protobuf.fdf;
import com.tencent.mm.protocal.protobuf.fdx;
import com.tencent.mm.protocal.protobuf.fdy;
import com.tencent.mm.protocal.protobuf.fee;
import com.tencent.mm.protocal.protobuf.fev;
import com.tencent.mm.protocal.protobuf.ffg;
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
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

public final class l
{
  public Network Foj;
  public ConnectivityManager.NetworkCallback Fok;
  public LinkedList<Integer> Fol;
  public boolean NLE;
  public boolean NLF;
  public boolean NLG;
  public boolean NLH;
  public boolean NLI;
  public boolean NLJ;
  public boolean NLK;
  public boolean NLL;
  public emb NLM;
  public int NLN;
  public long NLO;
  public long NLP;
  public int NLQ;
  public int NLR;
  public boolean NLS;
  public boolean NLT;
  public boolean NLU;
  public int NLV;
  private int NLW;
  private int NLX;
  private int NLY;
  private int NLZ;
  int NMA;
  private MTimerHandler NMB;
  private a NMC;
  private int NMa;
  public boolean NMb;
  private boolean NMc;
  private int NMd;
  private boolean NMe;
  private int NMf;
  private int NMg;
  private int NMh;
  public v2protocal NMi;
  public x NMj;
  public n NMk;
  public w NMl;
  public byte[] NMm;
  public fee NMn;
  public boolean NMo;
  public boolean NMp;
  public int NMq;
  public int NMr;
  public int NMs;
  public int NMt;
  public boolean NMu;
  public boolean NMv;
  public VoipScoreState NMw;
  public int NMx;
  public MTimerHandler NMy;
  com.tencent.e.i.d<?> NMz;
  public boolean fQy;
  MMHandler mHandler;
  public int mStatus;
  public Context uEJ;
  
  protected l()
  {
    AppMethodBeat.i(114899);
    this.mStatus = 1;
    this.NLE = false;
    this.NLF = false;
    this.NLG = false;
    this.NLH = false;
    this.fQy = false;
    this.NLI = false;
    this.NLJ = false;
    this.NLK = false;
    this.NLL = false;
    this.NLM = new emb();
    this.NLN = 0;
    this.NLO = 0L;
    this.NLP = 0L;
    this.NLQ = 0;
    this.NLR = 0;
    this.NLS = false;
    this.NLT = false;
    this.NLU = false;
    this.NLV = 10;
    this.NLW = -1;
    this.NLX = -1;
    this.NLY = -1;
    this.NLZ = -1;
    this.NMa = -1;
    this.NMb = false;
    this.NMc = false;
    this.NMd = 1;
    this.NMe = false;
    this.NMf = 1;
    this.NMg = -1;
    this.NMh = -1;
    this.uEJ = null;
    this.NMj = x.NQg;
    this.NMm = null;
    this.NMn = null;
    this.NMo = false;
    this.NMp = false;
    this.NMq = 0;
    this.NMr = 0;
    this.NMs = 0;
    this.NMt = 0;
    this.NMu = false;
    this.NMv = true;
    this.Foj = null;
    this.Fok = null;
    this.Fol = new LinkedList();
    this.NMx = 0;
    this.NMy = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(114886);
        Log.v("MicroMsg.Voip.VoipContext", "voip repeat sync");
        l.this.NMl.a(null, false, 7);
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
          if (l.this.NMi.roomId == 0)
          {
            com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipContext", "JNI_DOSYNC without roomid , igored!");
            AppMethodBeat.o(114891);
            return;
          }
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "need dosync for cmd from channel...");
          localObject3 = (byte[])paramAnonymousMessage.obj;
          localObject1 = l.this.NMl;
          i = paramAnonymousMessage.arg2;
          paramAnonymousMessage = new fev();
          paramAnonymousMessage.rWu = 1;
          localObject4 = new eae();
          ((eae)localObject4).dc((byte[])localObject3);
          paramAnonymousMessage.RNM = ((eae)localObject4);
          localObject3 = new eae();
          try
          {
            ((eae)localObject3).dc(paramAnonymousMessage.toByteArray());
            paramAnonymousMessage = new fdx();
            paramAnonymousMessage.SnG = i;
            paramAnonymousMessage.SnH = ((eae)localObject3);
            paramAnonymousMessage.CRR = z.bcZ();
            localObject3 = new fdy();
            ((fdy)localObject3).rVx = 1;
            ((fdy)localObject3).rVy.add(paramAnonymousMessage);
            ((w)localObject1).a((fdy)localObject3, true, 2);
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
          if (l.this.NMi.roomId == 0)
          {
            com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipContext", "JNI_STARTDEVFAILED without roomid , igored!");
            AppMethodBeat.o(114891);
            return;
          }
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "need hangUP for startTalk failed. ");
          l.this.NMi.NSI.NNq = 107;
          l.this.J(1, -9004, "");
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 6)
        {
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected from JNI");
          if (l.this.NMi.roomId == 0)
          {
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected roomid null, ignored");
            AppMethodBeat.o(114891);
            return;
          }
          l.this.NLG = true;
          l.this.NMi.NSI.NNG = 1;
          if ((!l.this.fQy) && (!l.this.NLH)) {}
          for (l.this.NMi.NRw = 1;; l.this.NMi.NRw = 0)
          {
            l.this.NMi.setInactive();
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "Voip.Channel setInactive");
            l.this.gyM();
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
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "need hangUP for disconnect from channel..envent = " + paramAnonymousMessage.arg2);
          if (l.this.mStatus >= 5)
          {
            l.this.NMi.NSI.NNq = 108;
            if (paramAnonymousMessage.arg2 != 5) {
              break label596;
            }
            l.this.NMi.NSI.NNI = 1;
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "channel broken...");
          }
          for (;;)
          {
            l.this.J(1, -9000, "");
            AppMethodBeat.o(114891);
            return;
            l.this.NMi.NSI.NNq = 106;
            break;
            label596:
            if (paramAnonymousMessage.arg2 == 8)
            {
              if (l.this.NLK == true)
              {
                com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "channel connect fail while pre-connect");
                l.this.NLJ = true;
                AppMethodBeat.o(114891);
                return;
              }
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "channel connect fail...");
              l.this.NLG = false;
              l.this.NMi.NSI.NNI = 5;
            }
          }
        }
        if (paramAnonymousMessage.arg1 == 100)
        {
          com.tencent.mm.plugin.voip.c.e.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.Voip.VoipContext", paramAnonymousMessage.arg2);
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 101)
        {
          com.tencent.mm.plugin.voip.c.e.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.v2Core", paramAnonymousMessage.arg2);
          AppMethodBeat.o(114891);
          return;
        }
        if (paramAnonymousMessage.arg1 == 7)
        {
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "NOTIFY_FROM_JNI_SPEEDTESTRESULT handle");
          localObject4 = (byte[])paramAnonymousMessage.obj;
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
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "Get wifiName failed in voip speedTest!");
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
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "Get netName failed in voip speedTest!");
            }
          }
          new j(l.this.NLP, l.this.NLO, l.this.NLQ, (String)localObject1, paramAnonymousMessage, l.this.NLR, i, (byte[])localObject4).gAX();
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
              localObject2 = (ezo)new ezo().parseFrom((byte[])localObject2);
              if ((!paramAnonymousMessage.NMu) || (((ezo)localObject2).UzP != 1)) {
                com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve: onRecvRUDPCmd:" + ((ezo)localObject2).UzP);
              }
              i = ((ezo)localObject2).UzP;
              switch (i)
              {
              default: 
                AppMethodBeat.o(114891);
                return;
              }
            }
            catch (Exception paramAnonymousMessage)
            {
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "rudp cmd processing Error");
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client tells us to end HWEnc!!");
            paramAnonymousMessage.NMk.NMY = true;
            AppMethodBeat.o(114891);
            return;
            if (!paramAnonymousMessage.NMu)
            {
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client end HWEnc!!");
              paramAnonymousMessage.m(8, false, true);
              paramAnonymousMessage.c(4, false, true, true);
              if (((ezo)localObject2).UzQ == null) {
                break label1202;
              }
              localObject2 = ByteBuffer.wrap(((ezo)localObject2).UzQ.UH, 0, 4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              i = Math.min(((ByteBuffer)localObject2).getInt(), 6);
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(i);
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:CMD_VOIP_CloseHWEnc:reset maxsizeformat: ".concat(String.valueOf(i)));
              paramAnonymousMessage.NMi.setAppCmd(30, ((ByteBuffer)localObject2).array(), 4);
            }
            for (;;)
            {
              paramAnonymousMessage.NMu = true;
              AppMethodBeat.o(114891);
              return;
              label1202:
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: cmdBuffer is nil!!");
            }
            if (((ezo)localObject2).UzQ != null)
            {
              localObject2 = ((ezo)localObject2).UzQ.UH;
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve: remote new network type:".concat(String.valueOf(localObject2)));
              i = paramAnonymousMessage.NMi.setAppCmd(302, (byte[])localObject2, 4);
              if (i < 0) {
                com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + localObject2 + "fail:" + i + ", [roomid=" + paramAnonymousMessage.NMi.DPQ + ", roomkey=" + paramAnonymousMessage.NMi.DPJ + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
            AppMethodBeat.o(114891);
            return;
            byte[] arrayOfByte;
            if (((ezo)localObject2).UzQ != null)
            {
              localObject2 = ((ezo)localObject2).UzQ.UH;
              localObject2 = (fdf)new fdf().parseFrom((byte[])localObject2);
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "zhengxue: remote audio dev occupied stat :" + ((fdf)localObject2).UDo);
              arrayOfByte = new byte[4];
              arrayOfByte[0] = ((byte)((fdf)localObject2).UDo);
              paramAnonymousMessage.NMi.setJNIAppCmd(2, arrayOfByte, 4);
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "zhengxue:[CHANNEL]EMethod_AudioDevOccupiedStatsSync empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((ezo)localObject2).UzQ != null)
            {
              localObject2 = ((ezo)localObject2).UzQ.UH;
              if (paramAnonymousMessage.NMi != null)
              {
                localObject2 = ByteBuffer.wrap((byte[])localObject2);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                i = ((ByteBuffer)localObject2).getInt();
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)3);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.NMi.setAppCmd(35, ((ByteBuffer)localObject2).array(), 6);
                com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_DisableCodec:  ".concat(String.valueOf(i)));
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_DisableCodec empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((ezo)localObject2).UzQ != null)
            {
              localObject2 = ((ezo)localObject2).UzQ.UH;
              if (paramAnonymousMessage.NMi != null)
              {
                localObject2 = ByteBuffer.wrap((byte[])localObject2);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                i = ((ByteBuffer)localObject2).getInt();
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)3);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.NMi.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
                com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder:  ".concat(String.valueOf(i)));
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((ezo)localObject2).UzQ != null)
            {
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(1);
              paramAnonymousMessage.NMi.setAppCmd(48, ((ByteBuffer)localObject2).array(), 4);
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAq:  1");
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAq empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((ezo)localObject2).UzQ != null)
            {
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(1);
              paramAnonymousMessage.NMi.setAppCmd(70, ((ByteBuffer)localObject2).array(), 4);
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAdaptiveBlur:  1");
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAdaptiveBlur empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((ezo)localObject2).UzQ != null)
            {
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(1);
              paramAnonymousMessage.NMi.setAppCmd(71, ((ByteBuffer)localObject2).array(), 4);
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableMixDenoise:  1");
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableMixDenoise empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((ezo)localObject2).UzQ != null)
            {
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject2).putInt(1);
              paramAnonymousMessage.NMi.setAppCmd(72, ((ByteBuffer)localObject2).array(), 4);
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableVoipOpt:  1");
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableVoipOpt empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((ezo)localObject2).UzQ != null)
            {
              localObject2 = ((ezo)localObject2).UzQ.UH;
              if (paramAnonymousMessage.NMi != null)
              {
                localObject2 = ByteBuffer.wrap((byte[])localObject2);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                i = ((ByteBuffer)localObject2).getInt();
                if (i != 20) {
                  break label2139;
                }
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)2);
                ((ByteBuffer)localObject2).putShort((short)16);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.NMi.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)2);
                ((ByteBuffer)localObject2).putShort((short)4);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.NMi.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
              }
              for (;;)
              {
                com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder:  ".concat(String.valueOf(i)));
                AppMethodBeat.o(114891);
                return;
                label2139:
                localObject2 = ByteBuffer.allocate(6);
                ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)localObject2).putShort((short)2);
                ((ByteBuffer)localObject2).putShort((short)i);
                ((ByteBuffer)localObject2).putShort((short)0);
                paramAnonymousMessage.NMi.setAppCmd(39, ((ByteBuffer)localObject2).array(), 6);
              }
            }
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((ezo)localObject2).UzQ != null)
            {
              localObject2 = ((ezo)localObject2).UzQ.UH;
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "anlin: remote wx ver: ".concat(String.valueOf(localObject2)));
              i = paramAnonymousMessage.NMi.setAppCmd(506, (byte[])localObject2, 4);
              if (i < 0) {
                com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteClientVersion] remote wx ver: " + localObject2 + "ret: " + i + ", [roomid=" + paramAnonymousMessage.NMi.DPQ + ", roomkey=" + paramAnonymousMessage.NMi.DPJ + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteClientVersion] empty buffer");
            AppMethodBeat.o(114891);
            return;
            if (((ezo)localObject2).UzQ != null)
            {
              arrayOfByte = ((ezo)localObject2).UzQ.UH;
              i = ((ezo)localObject2).UzQ.UH.length;
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "anlin: remote device model: ".concat(String.valueOf(arrayOfByte)));
              i = paramAnonymousMessage.NMi.setAppCmd(508, arrayOfByte, i);
              if (i < 0) {
                com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteDeviceModel] remote device model: " + arrayOfByte + "ret: " + i + ", [roomid=" + paramAnonymousMessage.NMi.DPQ + ", roomkey=" + paramAnonymousMessage.NMi.DPJ + "]");
              }
              AppMethodBeat.o(114891);
              return;
            }
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteDeviceModel] empty buffer");
          }
        }
        if (paramAnonymousMessage.arg1 == 9)
        {
          paramAnonymousMessage = l.this.NMi.NSI;
          if (0L == paramAnonymousMessage.NNU)
          {
            paramAnonymousMessage.NNU = System.currentTimeMillis();
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.VoipDailReport", "first pkt received timestamp:" + paramAnonymousMessage.NNU);
          }
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "get first pkt for voip");
          if (1 == l.this.NMi.NSh)
          {
            paramAnonymousMessage = new ffg();
            paramAnonymousMessage.rVU = 1;
            l.this.NMl.a(paramAnonymousMessage, 2);
            AppMethodBeat.o(114891);
          }
        }
        else
        {
          if (paramAnonymousMessage.arg1 == 11)
          {
            l.this.NMx = 2;
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 12)
          {
            l.this.NMx = 1;
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 13)
          {
            localObject2 = (int[])paramAnonymousMessage.obj;
            i = paramAnonymousMessage.arg2;
            new com.tencent.mm.plugin.voip.model.a.h(l.this.NMi.roomId, l.this.NMi.DPJ, l.this.NMi.DPQ, 1, i, (int[])localObject2, null).gAX();
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 14)
          {
            localObject2 = (int[])paramAnonymousMessage.obj;
            i = paramAnonymousMessage.arg2;
            new com.tencent.mm.plugin.voip.model.a.h(l.this.NMi.roomId, l.this.NMi.DPJ, l.this.NMi.DPQ, 2, i, (int[])localObject2, null).gAX();
            AppMethodBeat.o(114891);
            return;
          }
          if (paramAnonymousMessage.arg1 == 15) {
            l.this.aJ(paramAnonymousMessage.arg2, false);
          }
        }
        AppMethodBeat.o(114891);
      }
    };
    this.NMz = null;
    this.NMA = 0;
    this.NMB = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(177018);
        if (l.this.mStatus == 4)
        {
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "connect time out.. now finish..");
          l.this.NMi.NSI.NNq = 105;
          l.this.J(1, -9000, "");
        }
        AppMethodBeat.o(177018);
        return false;
      }
    }, false);
    this.NMC = null;
    this.NMi = new v2protocal(this.mHandler);
    this.NMk = new n(this);
    this.NMk.NNd = this.NMi.DPJ;
    this.NMl = new w(this);
    this.NMt = 0;
    this.NMw = new VoipScoreState();
    AppMethodBeat.o(114899);
  }
  
  private int AT(boolean paramBoolean)
  {
    AppMethodBeat.i(244998);
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "EnableAq: SetAqFlag =44, aqBlur=" + paramBoolean);
    ByteBuffer localByteBuffer;
    if (paramBoolean)
    {
      localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putInt(1);
    }
    try
    {
      if (this.NMi != null)
      {
        ezo localezo = new ezo();
        localezo.UzP = 10;
        localezo.UzQ = new com.tencent.mm.cd.b(localByteBuffer.array());
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "EnableAq: SetAqFlag =44, aqBlur=" + paramBoolean);
        this.NMi.SendRUDP(localezo.toByteArray(), localezo.toByteArray().length);
      }
      localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putInt(1);
      this.NMi.setAppCmd(44, localByteBuffer.array(), 4);
      AppMethodBeat.o(244998);
      return 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "EnableAq Error");
      }
    }
  }
  
  private void a(final d paramd)
  {
    AppMethodBeat.i(177020);
    if ((this.mStatus != 2) && (this.mStatus != 3) && (this.mStatus != 4))
    {
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "startConnectRelay status fail, status:" + this.mStatus);
      AppMethodBeat.o(177020);
      return;
    }
    if (this.NLE)
    {
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "can not startConnectRelay again");
      AppMethodBeat.o(177020);
      return;
    }
    l.c localc = new l.c(this, (byte)0);
    localc.NML = new l.b()
    {
      public final void aG(final int paramAnonymousInt1, final int paramAnonymousInt2, final int paramAnonymousInt3)
      {
        AppMethodBeat.i(114895);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114894);
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel relay");
            int k = l.this.NMi.NRL;
            int m = l.this.NMi.NRL;
            v2protocal localv2protocal = l.this.NMi;
            int n = l.this.NMi.NQH;
            long l1 = l.this.NMi.roomId;
            int i1 = l.this.NMi.DPQ;
            long l2 = l.this.NMi.DPJ;
            byte[] arrayOfByte1 = l.this.NMi.NQJ;
            int i2 = l.this.NMi.channelStrategy;
            int i3 = l.this.NMi.NQO;
            int i4 = l.this.NMi.NQP;
            int i5 = l.this.NMi.NQM;
            byte[] arrayOfByte2;
            int i6;
            int i7;
            int i8;
            byte[] arrayOfByte3;
            int i9;
            int i10;
            if (l.this.NMi.NQN == null)
            {
              i = 0;
              arrayOfByte2 = l.this.NMi.NQN;
              i6 = l.this.NMi.NQQ;
              i7 = l.this.NMi.NQG;
              i8 = l.this.NMi.NRV;
              arrayOfByte3 = l.this.NMi.NRW;
              i9 = l.this.NMi.NRX;
              i10 = l.this.NMi.NQR;
              if (l.this.NMi.NQS != null) {
                break label521;
              }
            }
            label521:
            for (int j = 0;; j = l.this.NMi.NQS.length)
            {
              i = localv2protocal.setConfigInfo(n, l1, i1, l2, arrayOfByte1, i2, i3, i4, i5, i, arrayOfByte2, i6, (k >> 2 & 0x3) >> 1 & 0x1 & (m & 0x3) >> 1 & 0x1, i7, i8, arrayOfByte3, i9, i10, j, l.this.NMi.NQS, l.this.NMi.NRY, paramAnonymousInt1, paramAnonymousInt3, paramAnonymousInt2, "", "", v2protocal.gBp());
              if (i >= 0) {
                break label539;
              }
              com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipContext", "v2protocal setConfigInfo or connectToPeerRelay failed, ret:".concat(String.valueOf(i)));
              l.this.NMi.NSI.NNq = 14;
              l.this.J(1, -9002, "");
              l.11.this.NME.gyZ();
              AppMethodBeat.o(114894);
              return;
              i = l.this.NMi.NQN.length;
              break;
            }
            label539:
            if (l.this.NMi.NSl == null)
            {
              com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipContext", "relay conns buf null");
              l.this.J(1, -9002, "");
              l.11.this.NME.gyZ();
              AppMethodBeat.o(114894);
              return;
            }
            int i = l.this.NMi.AddNewRelayConns(l.this.NMi.NSl, l.this.NMi.NSl.length, 0);
            if (i < 0)
            {
              com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipContext", "add relayconns err:".concat(String.valueOf(i)));
              l.this.J(1, -9002, "");
              l.11.this.NME.gyZ();
              AppMethodBeat.o(114894);
              return;
            }
            l.this.NLE = true;
            l.this.NMi.NSI.NNx = 1;
            l.this.NMi.NSI.NNF = 1;
            l.11.this.NME.gyZ();
            AppMethodBeat.o(114894);
          }
        });
        AppMethodBeat.o(114895);
      }
    };
    com.tencent.e.h.ZvG.be(localc);
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
  
  private void gyL()
  {
    AppMethodBeat.i(114914);
    com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipContext", "SrvDeviceInfo.mAudioInfo.aecMode:" + af.juI.joy);
    if (af.juI.jnW == 1) {
      this.NMi.setAppCmd(410);
    }
    byte[] arrayOfByte1 = new byte[2];
    byte b;
    int i;
    int j;
    int k;
    label275:
    byte[] arrayOfByte2;
    label605:
    ByteBuffer localByteBuffer;
    if (af.juI.joy >= 0)
    {
      arrayOfByte1[0] = ((byte)af.juI.joy);
      this.NMi.setAppCmd(406, arrayOfByte1, 1);
      this.NMi.setAppCmd(432, new byte[] { 1 }, 1);
      m = af.juI.joz;
      Log.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.nsModeNew %d", new Object[] { Integer.valueOf(m) });
      if (af.juI.joz < 0) {
        break label789;
      }
      if (m <= 0) {
        break label770;
      }
      n = (int)Math.floor(m / 1000.0D) % 100;
      Log.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.iflag %d", new Object[] { Integer.valueOf(n) });
      if (n > 0)
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        this.NMi.setAppCmd(408, (byte[])new byte[] { b, i, j, k }, 4);
      }
      m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQA, -1);
      Log.i("MicroMsg.Voip.VoipContext", "mevinwang, nssinfwindmode = %d", new Object[] { Integer.valueOf(m) });
      if (m > 0)
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        this.NMi.setAppCmd(408, (byte[])new byte[] { b, i, j, k }, 4);
      }
      m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vPX, -1);
      Log.i("MicroMsg.Voip.VoipContext", "kerrizhang, play_fadeinfadeout_switch = %d", new Object[] { Integer.valueOf(m) });
      arrayOfByte2 = new byte[1];
      arrayOfByte2[0] = 0;
      if (m > 0) {
        arrayOfByte2[0] = ((byte)m);
      }
      this.NMi.setAppCmd(451, arrayOfByte2, 1);
      m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQz, -1);
      if (m <= 0) {
        break label868;
      }
      byte[] arrayOfByte3 = new byte[4];
      arrayOfByte3[0] = ((byte)(m & 0x1));
      arrayOfByte3[1] = ((byte)(m >> 1 & 0x1));
      arrayOfByte3[2] = ((byte)(m >> 2 & 0x1));
      arrayOfByte3[3] = ((byte)(m >> 8 & 0x7F));
      Log.i("MicroMsg.Voip.VoipContext", "ashlynli, x vcodec2 adaptiveBlur = %d, mixDenoise = %d, voipOpt = %d, cpuCap = %d", new Object[] { Byte.valueOf(arrayOfByte3[0]), Byte.valueOf(arrayOfByte3[1]), Byte.valueOf(arrayOfByte3[2]), Byte.valueOf(arrayOfByte3[3]) });
      m = 0;
      if (m >= 3) {
        break label868;
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
        if (this.NMi == null) {
          continue;
        }
        localezo = new ezo();
        if (m != 0) {
          continue;
        }
        localezo.UzP = 11;
      }
      catch (Exception localException)
      {
        ezo localezo;
        label770:
        label789:
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "Enable Vcodec2 para RUDP CMD Error, i = ".concat(String.valueOf(m)));
        continue;
        if (m != 2) {
          continue;
        }
        localezo.UzP = 13;
        continue;
      }
      localezo.UzQ = new com.tencent.mm.cd.b(localByteBuffer.array());
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "Enable vcodec2 para, i = " + m + " , Send RUDP CMD rudpFlag =1");
      this.NMi.SendRUDP(localezo.toByteArray(), localezo.toByteArray().length);
      m += 1;
      break label605;
      if (af.juI.joy != -2) {
        break;
      }
      this.NMi.setAppCmd(407);
      break;
      if (m != 0) {
        break label275;
      }
      this.NMi.setAppCmd(409);
      break label275;
      if (af.juI.joz != -2) {
        break label275;
      }
      this.NMi.setAppCmd(409);
      break label275;
      if (m != 1) {
        continue;
      }
      localezo.UzP = 12;
    }
    label868:
    int m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQy, -1);
    Log.i("MicroMsg.Voip.VoipContext", "kerrizhang, fullbandmode = %d", new Object[] { Integer.valueOf(m) });
    int n = af.juI.joB;
    Log.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.voipfullbandcfg %d", new Object[] { Integer.valueOf(n) });
    if ((m > 0) && (n > 0))
    {
      b = (byte)(m & 0xFF);
      i = (byte)(m >> 8 & 0xFF);
      j = (byte)(m >> 16 & 0xFF);
      k = (byte)(m >> 24 & 0xFF);
      this.NMi.setAppCmd(456, (byte[])new byte[] { b, i, j, k }, 4);
    }
    m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vPY, -1);
    Log.i("MicroMsg.Voip.VoipContext", "kerrizhang, play_fadeinfadeout_thresh = %d", new Object[] { Integer.valueOf(m) });
    arrayOfByte2[0] = 0;
    if (m > 0) {
      arrayOfByte2[0] = ((byte)m);
    }
    this.NMi.setAppCmd(452, arrayOfByte2, 1);
    m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQx, -1);
    Log.i("MicroMsg.Voip.VoipContext", "kerrizhang, voip rcnnvad_switch = %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)m;
      this.NMi.setAppCmd(454, new byte[] { b }, 1);
    }
    m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQC, 0);
    Log.i("MicroMsg.Voip.VoipContext", "dennyliang, voip aec_value = %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)(m & 0xFF);
      i = (byte)(m >> 8 & 0xFF);
      j = (byte)(m >> 16 & 0xFF);
      k = (byte)(m >> 24 & 0xFF);
      this.NMi.setAppCmd(460, new byte[] { b, i, j, k }, 4);
    }
    m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQF, -1);
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
        this.NMi.setAppCmd(404, arrayOfByte2, 7);
      }
    }
    else
    {
      if (af.juI.joD < 0) {
        break label2495;
      }
      arrayOfByte2 = new byte[7];
      if ((af.juI.joE >= 0) && (af.juI.joF >= 0))
      {
        arrayOfByte2[0] = ((byte)af.juI.joE);
        arrayOfByte2[1] = ((byte)af.juI.joF);
        if (af.juI.joG < 0) {
          break label2478;
        }
        arrayOfByte2[2] = ((byte)af.juI.joG);
        arrayOfByte2[3] = ((byte)af.juI.joD);
        arrayOfByte2[4] = ((byte)af.juI.joH);
        arrayOfByte2[5] = ((byte)af.juI.joI);
        arrayOfByte2[6] = ((byte)af.juI.joJ);
        this.NMi.setAppCmd(404, arrayOfByte2, 7);
      }
    }
    for (;;)
    {
      m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQJ, -1);
      Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, tryUpdateAudioAdaption, frz_sta_p_x = %d", new Object[] { Integer.valueOf(m) });
      if (m > 0)
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        this.NMi.setAppCmd(464, new byte[] { b, i, j, k }, 4);
      }
      m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vPW, -1);
      Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, tryUpdateAudioAdaption, switch_flag_x = %d", new Object[] { Integer.valueOf(m) });
      arrayOfByte2 = new byte[1];
      arrayOfByte2[0] = 0;
      if (m > 0) {
        arrayOfByte2[0] = 1;
      }
      this.NMi.setAppCmd(450, arrayOfByte2, 1);
      if ((af.juI.jnX >= 0) || (af.juI.jnZ >= 0))
      {
        arrayOfByte1[0] = -1;
        arrayOfByte1[1] = -1;
        if (af.juI.jnX >= 0) {
          arrayOfByte1[0] = ((byte)af.juI.jnX);
        }
        if (af.juI.jnZ >= 0) {
          arrayOfByte1[1] = ((byte)af.juI.jnZ);
        }
        this.NMi.setAppCmd(414, arrayOfByte1, 2);
      }
      if ((af.juI.jnY >= 0) || (af.juI.joa >= 0))
      {
        arrayOfByte1[0] = -1;
        arrayOfByte1[1] = -1;
        if (af.juI.jnY >= 0) {
          arrayOfByte1[0] = ((byte)af.juI.jnY);
        }
        if (af.juI.joa >= 0) {
          arrayOfByte1[1] = ((byte)af.juI.joa);
        }
        this.NMi.setAppCmd(415, arrayOfByte1, 2);
      }
      if ((af.juI.job >= 0) || (af.juI.joc >= 0))
      {
        arrayOfByte1[0] = -1;
        arrayOfByte1[1] = -1;
        if (af.juI.job >= 0) {
          arrayOfByte1[0] = ((byte)af.juI.job);
        }
        if (af.juI.joc >= 0) {
          arrayOfByte1[1] = ((byte)af.juI.joc);
        }
        this.NMi.setAppCmd(422, arrayOfByte1, 2);
      }
      if (af.juI.joh >= 0)
      {
        arrayOfByte1[0] = ((byte)af.juI.joh);
        this.NMi.setAppCmd(416, arrayOfByte1, 1);
      }
      if (af.juI.jol >= 0)
      {
        arrayOfByte1[0] = ((byte)af.juI.jol);
        this.NMi.setAppCmd(431, arrayOfByte1, 4);
      }
      if ((af.juI.joi >= 0) && ((this.NMi.NRF != 0) || (af.juI.joi != 5)))
      {
        arrayOfByte1[0] = ((byte)af.juI.joi);
        this.NMi.setAppCmd(417, arrayOfByte1, 1);
      }
      if ((af.juI.joj >= 0) && ((this.NMi.NRF != 0) || (af.juI.joj != 5)))
      {
        arrayOfByte1[0] = ((byte)af.juI.joj);
        this.NMi.setAppCmd(418, arrayOfByte1, 1);
      }
      if (af.juI.jok >= 0)
      {
        arrayOfByte1[0] = ((byte)af.juI.jok);
        this.NMi.setAppCmd(419, arrayOfByte1, 1);
      }
      if ((this.NMi.NRF == 1) && ((af.juI.joi == 5) || (af.juI.joj == 5))) {
        this.NMi.NRj = 5;
      }
      if (1 != af.juI.joX) {
        break label2535;
      }
      arrayOfByte2 = new byte[30];
      m = 0;
      while (m < 15)
      {
        arrayOfByte2[(m * 2)] = ((byte)(af.juI.joY[m] & 0xFF));
        arrayOfByte2[(m * 2 + 1)] = ((byte)(af.juI.joY[m] >> 8 & 0xFF));
        m += 1;
      }
      this.NMi.setAppCmd(405);
      break;
      label2478:
      this.NMi.setAppCmd(404, arrayOfByte2, 2);
      continue;
      label2495:
      if (af.juI.joD == -2) {
        this.NMi.setAppCmd(405);
      }
    }
    this.NMi.setAppCmd(420, arrayOfByte2, 30);
    label2535:
    if (af.juI.joX == 0) {
      this.NMi.setAppCmd(421);
    }
    if ((af.juI.joZ[0] > 0) || (af.juI.joZ[1] > 0))
    {
      arrayOfByte1[0] = 0;
      arrayOfByte1[1] = 0;
      if ((af.juI.joZ[0] > 0) && (af.juI.joZ[0] < 10000)) {
        arrayOfByte1[0] = ((byte)af.juI.joZ[0]);
      }
      if ((af.juI.joZ[1] > 0) && (af.juI.joZ[1] < 10000)) {
        arrayOfByte1[1] = ((byte)af.juI.joZ[1]);
      }
      this.NMi.setAppCmd(423, arrayOfByte1, 2);
    }
    if (af.juI.jpb > 0)
    {
      arrayOfByte1[0] = ((byte)af.juI.jpb);
      this.NMi.setAppCmd(424, arrayOfByte1, 1);
    }
    m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQG, -1);
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
        this.NMi.setAppCmd(426, arrayOfByte1, 4);
      }
    }
    if (af.juI.jpj >= 0)
    {
      b = (byte)af.juI.jpj;
      i = (byte)af.juI.jpk;
      j = (byte)af.juI.jpl;
      k = (byte)af.juI.jpm;
      this.NMi.setAppCmd(426, new byte[] { b, i, j, k }, 4);
    }
    AppMethodBeat.o(114914);
  }
  
  private static boolean gyQ()
  {
    AppMethodBeat.i(245014);
    int i = m.aus();
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
      l = com.tencent.matrix.e.a.getTotalMemory(MMApplicationContext.getContext()) / 1024L / 1024L;
      if (j < ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVU, 4)) {
        break label345;
      }
      bool2 = true;
      if (k < ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVV, 45)) {
        break label351;
      }
      bool3 = true;
      if (m < ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVW, 23)) {
        break label357;
      }
      bool4 = true;
      label136:
      if (l < ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVX, 4096)) {
        break label363;
      }
    }
    label345:
    label351:
    label357:
    label363:
    for (boolean bool5 = true;; bool5 = false)
    {
      double d = com.tencent.matrix.e.a.Yp();
      Debug.MemoryInfo localMemoryInfo = com.tencent.matrix.e.a.bz(MMApplicationContext.getContext());
      Log.i("MicroMsg.Voip.VoipContext", "checkVoipBeautyLocalConfig, cpuFlags:%s, isNeon:%s, nCores:%s, nFreq:%s, sdkInt:%s, totalMemMB:%s, coreNumCheck:%s, freqCheck:%s, sdkIntCheck:%s, totalMemMBCheck:%s, cpuRate:%s, dalvikPss:%s, nativePss:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Double.valueOf(d), Integer.valueOf(localMemoryInfo.dalvikPss), Integer.valueOf(localMemoryInfo.nativePss) });
      if ((!bool1) || (!bool2) || (!bool3) || (!bool4) || (!bool5)) {
        break label369;
      }
      AppMethodBeat.o(245014);
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
    AppMethodBeat.o(245014);
    return false;
  }
  
  private static int gyR()
  {
    AppMethodBeat.i(184050);
    String str1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVY, "");
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
  
  public final void J(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(114937);
    gyY();
    if (this.NMC != null) {
      this.NMC.J(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(114937);
  }
  
  public final void a(a parama)
  {
    if (parama != null) {
      this.NMC = parama;
    }
  }
  
  public final void a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.NMi.NQM = paramInt1;
    this.NMi.NQN = paramArrayOfByte1;
    this.NMi.NRV = paramInt2;
    this.NMi.NRW = paramArrayOfByte2;
  }
  
  public final boolean a(fee paramfee)
  {
    this.NMn = paramfee;
    this.NMi.jLI = this.NMn.UDO;
    this.NMi.roomId = this.NMn.Svu;
    this.NMi.DPJ = this.NMn.Svv;
    this.NMi.DPQ = 1;
    this.NMi.NQH = 0;
    this.mStatus = 3;
    return true;
  }
  
  public final void aJ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(114921);
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "start bindSocket " + paramInt + " ToNetwork " + this.Foj + " rebind " + paramBoolean);
    if (paramInt == -1)
    {
      eVJ();
      AppMethodBeat.o(114921);
      return;
    }
    if ((this.Foj != null) && (com.tencent.mm.compatible.util.d.qV(23)))
    {
      FileDescriptor localFileDescriptor = new FileDescriptor();
      try
      {
        Field localField = FileDescriptor.class.getDeclaredField("descriptor");
        localField.setAccessible(true);
        localField.setInt(localFileDescriptor, paramInt);
        this.Foj.bindSocket(localFileDescriptor);
        if (!paramBoolean) {
          this.Fol.add(Integer.valueOf(paramInt));
        }
        com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipContext", "bindSocketToNetwork success: network" + this.Foj + "+socketfd" + paramInt);
        AppMethodBeat.o(114921);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "bindSocketToNetwork Error");
      }
    }
    AppMethodBeat.o(114921);
  }
  
  public final void aR(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(244987);
    if (!paramBoolean1)
    {
      if (this.NMi != null)
      {
        if (this.NMv)
        {
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc: Set P2S HW Flag False!!");
          m(8, false, true);
        }
        for (;;)
        {
          ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
          localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
          localByteBuffer.putInt(6);
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc:reset maxsizeformat: 6");
          this.NMi.setAppCmd(30, localByteBuffer.array(), 4);
          AppMethodBeat.o(244987);
          return;
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "closecodec: remote i264 enc!");
          c(8, false, true, true);
        }
      }
    }
    else
    {
      if (this.NMv)
      {
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "closeRemoteHWEnc: DecErr old!!");
        akR(2);
        AppMethodBeat.o(244987);
        return;
      }
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "closeRemoteHWEnc: DecErr new!!");
      if (paramBoolean2)
      {
        c(4, true, false, false);
        AppMethodBeat.o(244987);
        return;
      }
      c(8, true, false, false);
    }
    AppMethodBeat.o(244987);
  }
  
  public final void akL(int paramInt)
  {
    AppMethodBeat.i(114903);
    this.NMi.Ftu = Math.abs(paramInt);
    AppMethodBeat.o(114903);
  }
  
  public final void akM(int paramInt)
  {
    AppMethodBeat.i(114904);
    this.NMi.NQX = Math.abs(paramInt);
    if (paramInt != 0) {
      this.NMj.eXH();
    }
    AppMethodBeat.o(114904);
  }
  
  public final void akN(int paramInt)
  {
    this.NMi.NRa = paramInt;
  }
  
  public final void akO(int paramInt)
  {
    AppMethodBeat.i(114910);
    if ((8 == paramInt) || (9 == paramInt)) {
      this.NMa = paramInt;
    }
    for (;;)
    {
      if ((1 == paramInt) || (3 == paramInt)) {
        akP(2);
      }
      com.tencent.mm.plugin.voip.c.gxs().NPf.NPF = false;
      com.tencent.mm.plugin.voip.c.gxs().gAz();
      this.NMj.akA(paramInt);
      AppMethodBeat.o(114910);
      return;
      this.NLY = paramInt;
      this.NLW = paramInt;
    }
  }
  
  public final void akP(int paramInt)
  {
    AppMethodBeat.i(114911);
    if ((8 == paramInt) || (9 == paramInt)) {
      this.NLZ = paramInt;
    }
    for (;;)
    {
      this.NMl.ale(paramInt);
      AppMethodBeat.o(114911);
      return;
      this.NLW = paramInt;
      this.NLX = paramInt;
    }
  }
  
  public final boolean akQ(int paramInt)
  {
    AppMethodBeat.i(245002);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.put((byte)paramInt);
    paramInt = this.NMi.setAppCmd(21, localByteBuffer.array(), 4);
    if (paramInt < 0) {
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "voipContext setOrientation ret:".concat(String.valueOf(paramInt)));
    }
    if (paramInt == 0)
    {
      AppMethodBeat.o(245002);
      return true;
    }
    AppMethodBeat.o(245002);
    return false;
  }
  
  public final void akR(int paramInt)
  {
    AppMethodBeat.i(114925);
    try
    {
      ezo localezo = new ezo();
      localezo.UzP = paramInt;
      if (1 == paramInt)
      {
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:send maxsizeformat: !!6");
        ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer.putInt(6);
        localezo.UzQ = new com.tencent.mm.cd.b(localByteBuffer.array());
        this.NMi.setAppCmd(32, localByteBuffer.array(), 4);
      }
      for (;;)
      {
        this.NMi.SendRUDP(localezo.toByteArray(), localezo.toByteArray().length);
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: send RUDP data to close remote HW encoding!Type:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(114925);
        return;
        localezo.UzQ = null;
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "onVoipSendCloseHWEncCmd Error");
      AppMethodBeat.o(114925);
    }
  }
  
  public final void akS(int paramInt)
  {
    AppMethodBeat.i(114926);
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "zhengxue: audio device occupied stat sync stat " + paramInt + " app 1");
    try
    {
      Object localObject = new byte[4];
      localObject[0] = ((byte)paramInt);
      this.NMi.setJNIAppCmd(2, (byte[])localObject, 4);
      localObject = new fdf();
      ((fdf)localObject).UDo = paramInt;
      ((fdf)localObject).UDp = 1;
      ezo localezo = new ezo();
      localezo.UzP = 4;
      localezo.UzQ = new com.tencent.mm.cd.b(((fdf)localObject).toByteArray(), 0, 1);
      this.NMi.SendRUDP(localezo.toByteArray(), localezo.toByteArray().length);
      AppMethodBeat.o(114926);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "onAudioDevOccupiedStat Error");
      AppMethodBeat.o(114926);
    }
  }
  
  public final void akT(int paramInt)
  {
    this.NMi.NRX = paramInt;
  }
  
  public final void akU(int paramInt)
  {
    this.NMi.NRQ = paramInt;
  }
  
  public final void akV(int paramInt)
  {
    this.NMi.NSI.NNw = 1;
    this.NMi.channelStrategy = paramInt;
  }
  
  public final void akW(int paramInt)
  {
    this.NMi.NQQ = paramInt;
  }
  
  public final int bR(LinkedList<dbt> paramLinkedList)
  {
    int j = 0;
    AppMethodBeat.i(114936);
    Object localObject = new LinkedList();
    int k = this.NMi.bS((LinkedList)localObject);
    int i = j;
    if (k == 0)
    {
      if ((((LinkedList)localObject).size() == 0) || (((LinkedList)localObject).size() > 2))
      {
        AppMethodBeat.o(114936);
        return 0;
      }
      if ((((dbt)((LinkedList)localObject).get(0)).TJp == 1) && (((dbt)((LinkedList)localObject).get(0)).SpF == 5))
      {
        paramLinkedList.add(((LinkedList)localObject).get(0));
        this.NMi.NRo = 1;
        AppMethodBeat.o(114936);
        return 0;
      }
      paramLinkedList.add(((LinkedList)localObject).get(0));
      this.NMi.NRn = 1;
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
      dbt localdbt = new dbt();
      localdbt.ThL = "android-cellular";
      localdbt.TJp = 0;
      localdbt.SpF = 5;
      localdbt.TJq = (((String)localObject).substring(0, 3) + ":" + ((String)localObject).substring(3, ((String)localObject).length()));
      paramLinkedList.add(localdbt);
      this.NMi.NRo = 1;
      i = j;
    }
    while (i < paramLinkedList.size())
    {
      Log.d("MicroMsg.Voip.VoipContext", "nic_name:" + ((dbt)paramLinkedList.get(i)).ThL + " nic_role:" + ((dbt)paramLinkedList.get(i)).TJp + " net_type:" + ((dbt)paramLinkedList.get(i)).SpF + " nic_isp_info:" + ((dbt)paramLinkedList.get(i)).TJq);
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
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec: targetCodec =" + paramInt + ", local=" + paramBoolean1 + ", remote =" + paramBoolean2 + "encTag=" + paramBoolean3);
    ByteBuffer localByteBuffer1;
    if ((paramBoolean1) && (paramBoolean3))
    {
      localByteBuffer1 = ByteBuffer.allocate(4);
      localByteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer1.putInt(paramInt);
    }
    for (;;)
    {
      ezo localezo;
      try
      {
        if (this.NMi != null)
        {
          localezo = new ezo();
          localezo.UzP = 6;
          localezo.UzQ = new com.tencent.mm.cd.b(localByteBuffer1.array());
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(paramInt)));
          this.NMi.SendRUDP(localezo.toByteArray(), localezo.toByteArray().length);
        }
        localByteBuffer1 = ByteBuffer.allocate(6);
        localByteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer1.putShort((short)2);
        localByteBuffer1.putShort((short)paramInt);
        localByteBuffer1.putShort((short)0);
        this.NMi.setAppCmd(39, localByteBuffer1.array(), 6);
        AppMethodBeat.o(184049);
        return 1;
      }
      catch (Exception localException1)
      {
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        continue;
      }
      if ((paramBoolean1) && (!paramBoolean3))
      {
        ByteBuffer localByteBuffer2 = ByteBuffer.allocate(6);
        localByteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer2.putShort((short)0);
        localByteBuffer2.putShort((short)paramInt);
        localByteBuffer2.putShort((short)0);
        this.NMi.setAppCmd(39, localByteBuffer2.array(), 6);
        localByteBuffer2 = ByteBuffer.allocate(4);
        localByteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer2.putInt(paramInt);
        try
        {
          if (this.NMi == null) {
            continue;
          }
          localezo = new ezo();
          localezo.UzP = 7;
          localezo.UzQ = new com.tencent.mm.cd.b(localByteBuffer2.array());
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(paramInt)));
          this.NMi.SendRUDP(localezo.toByteArray(), localezo.toByteArray().length);
        }
        catch (Exception localException2)
        {
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        }
      }
      else if ((paramBoolean2) && (paramBoolean3))
      {
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:disable remote target codec: ".concat(String.valueOf(paramInt)));
        ByteBuffer localByteBuffer3 = ByteBuffer.allocate(6);
        localByteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer3.putShort((short)3);
        localByteBuffer3.putShort((short)paramInt);
        localByteBuffer3.putShort((short)0);
        this.NMi.setAppCmd(39, localByteBuffer3.array(), 6);
        localByteBuffer3 = ByteBuffer.allocate(4);
        localByteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer3.putInt(paramInt);
        try
        {
          if (this.NMi != null)
          {
            localezo = new ezo();
            localezo.UzP = 7;
            localezo.UzQ = new com.tencent.mm.cd.b(localByteBuffer3.array());
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(paramInt)));
            this.NMi.SendRUDP(localezo.toByteArray(), localezo.toByteArray().length);
          }
        }
        catch (Exception localException3)
        {
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
        }
      }
    }
  }
  
  public final void c(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.NMi.NSc = paramInt;
    this.NMi.NSd = paramArrayOfByte1;
    this.NMi.NSe = paramArrayOfByte2;
  }
  
  public final void cA(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114933);
    this.NMi.NQL = paramArrayOfByte;
    gyX();
    AppMethodBeat.o(114933);
  }
  
  public final void cy(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114930);
    Log.i("MicroMsg.Voip.VoipContext", "updateRemotePid");
    this.NMi.NSI.NNv = 1;
    this.NMi.NSI.NNu = 1;
    this.NMi.NQJ = paramArrayOfByte;
    AppMethodBeat.o(114930);
  }
  
  public final void cz(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    AppMethodBeat.i(114932);
    Log.i("MicroMsg.Voip.VoipContext", "updateRemoteCapInfo, isGotCapInfo: %s", new Object[] { Byte.valueOf(this.NMi.NSI.NNz) });
    if ((this.NMi.NSI.NNz == 1) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(114932);
      return;
    }
    this.NMi.NSI.NNz = 1;
    this.NMi.NQK = paramArrayOfByte;
    if (this.NMi.NQK != null)
    {
      int i = this.NMi.exchangeCabInfo(this.NMi.NQK, this.NMi.NQK.length);
      if ((this.NMi.NQK == null) || (this.NMi.NQK.length < 36)) {
        bool = true;
      }
      this.NMv = bool;
      if (i < 0)
      {
        com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipContext", "protocal exchangecabinfo failed ret:".concat(String.valueOf(i)));
        this.NMi.NSI.NNq = 15;
        J(1, -9003, "");
      }
    }
    AppMethodBeat.o(114932);
  }
  
  public final void eVI()
  {
    AppMethodBeat.i(114915);
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "In networkRequestViaCellular");
    if (com.tencent.mm.compatible.util.d.qV(21))
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
      Object localObject = new NetworkRequest.Builder();
      ((NetworkRequest.Builder)localObject).addTransportType(0);
      ((NetworkRequest.Builder)localObject).addCapability(12);
      localObject = ((NetworkRequest.Builder)localObject).build();
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "NetworkRequest toString: " + ((NetworkRequest)localObject).toString() + " hashCode: " + ((NetworkRequest)localObject).hashCode());
      try
      {
        localConnectivityManager.requestNetwork((NetworkRequest)localObject, new ConnectivityManager.NetworkCallback()
        {
          public final void onAvailable(Network paramAnonymousNetwork)
          {
            int i = 0;
            AppMethodBeat.i(114890);
            super.onAvailable(paramAnonymousNetwork);
            Object localObject = l.this.NMi;
            ((v2protocal)localObject).NRq += 1;
            localObject = Parcel.obtain();
            paramAnonymousNetwork.writeToParcel((Parcel)localObject, 0);
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "found requested network. netid: " + ((Parcel)localObject).readInt() + " toString: " + paramAnonymousNetwork.toString());
            if (com.tencent.mm.compatible.util.d.qV(28)) {
              localObject = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
            }
            try
            {
              int j = ((ConnectivityManager)localObject).getMultipathPreference(paramAnonymousNetwork);
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "getMultipathPreference ret ".concat(String.valueOf(j)));
              if (j == 0) {
                l.this.NMi.NRp = 3;
              }
              if (l.this.Foj != null)
              {
                l.this.Foj = paramAnonymousNetwork;
                if (l.this.Fol == null) {
                  break label266;
                }
                while (i < l.this.Fol.size())
                {
                  l.this.aJ(((Integer)l.this.Fol.get(i)).intValue(), true);
                  i += 1;
                }
              }
              label266:
              return;
            }
            catch (Exception paramAnonymousNetwork)
            {
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "getMultipathPreference  Error");
              l.this.NMi.NRp = 2;
              try
              {
                ((ConnectivityManager)localObject).unregisterNetworkCallback(this);
                AppMethodBeat.o(114890);
                return;
              }
              catch (Exception paramAnonymousNetwork)
              {
                com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "unregisterNetworkCallback Error");
                AppMethodBeat.o(114890);
                return;
              }
              l.this.Foj = paramAnonymousNetwork;
              l.this.Fok = this;
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "networkcallback hashCode: " + l.this.Fok.hashCode());
              l.this.NMi.NRp = 1;
              AppMethodBeat.o(114890);
            }
          }
        });
        AppMethodBeat.o(114915);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "missing the appropriate permissions");
        this.NMi.NRp = 2;
        AppMethodBeat.o(114915);
        return;
      }
    }
    AppMethodBeat.o(114915);
  }
  
  public final void eVJ()
  {
    AppMethodBeat.i(114916);
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "try to UnregisterCellularNetwork");
    ConnectivityManager localConnectivityManager;
    if (com.tencent.mm.compatible.util.d.qV(21))
    {
      localConnectivityManager = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
      if (this.Fok != null) {
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "unregister networkcallback hashCode: " + this.Fok.hashCode());
      }
    }
    try
    {
      localConnectivityManager.unregisterNetworkCallback(this.Fok);
      this.Fok = null;
      this.Foj = null;
      AppMethodBeat.o(114916);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "unregisterNetworkCallback Error");
      }
    }
  }
  
  public final void gyB()
  {
    int k = 0;
    AppMethodBeat.i(114901);
    if ((this.NLE == true) && (this.NLN == 0))
    {
      this.NLN = 1;
      if (this.NMi.field_speedTestInfoLength < 8)
      {
        com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! bufsize=" + this.NMi.field_speedTestInfoLength);
        AppMethodBeat.o(114901);
      }
    }
    else
    {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipContext", "StartVoipSpeedTest fail for status is wrong: isChannelStartConnect=" + this.NLE + " ,mSpeedTestStatus=" + this.NLN);
      AppMethodBeat.o(114901);
      return;
    }
    int i = this.NMi.NSG[1];
    if (i + 2 > this.NMi.field_speedTestInfoLength)
    {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i + ", bufsize=" + this.NMi.field_speedTestInfoLength);
      AppMethodBeat.o(114901);
      return;
    }
    int j = this.NMi.NSG[(i + 2 + 1)];
    if (i + 6 + j != this.NMi.field_speedTestInfoLength)
    {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i + ", C2SRttCnt=" + j + ", bufsize=" + this.NMi.field_speedTestInfoLength);
      AppMethodBeat.o(114901);
      return;
    }
    this.NLO = this.NMi.DPJ;
    this.NLQ = this.NMi.netType;
    this.NLR = this.NMi.roomId;
    this.NLM.Svu = this.NMi.roomId;
    this.NLM.Uon = this.NMi.NQW;
    this.NLM.SmH = this.NMi.netType;
    emb localemb = this.NLM;
    if (this.NLE == true)
    {
      i = 1;
      localemb.Uoo = i;
      localemb = this.NLM;
      if (this.NLG != true) {
        break label482;
      }
    }
    label482:
    for (i = 1;; i = 0)
    {
      localemb.Uop = i;
      this.NLM.Uoq = this.NMi.NSG[0];
      this.NLM.Uor = this.NMi.NSG[1];
      j = 0;
      i = 2;
      while (j < this.NLM.Uor)
      {
        this.NLM.Uos.add(Integer.valueOf(this.NMi.NSG[i]));
        j += 1;
        i += 1;
      }
      i = 0;
      break;
    }
    localemb = this.NLM;
    int[] arrayOfInt = this.NMi.NSG;
    j = i + 1;
    localemb.Uot = arrayOfInt[i];
    localemb = this.NLM;
    arrayOfInt = this.NMi.NSG;
    i = j + 1;
    localemb.Uou = arrayOfInt[j];
    j = k;
    while (j < this.NLM.Uou)
    {
      this.NLM.Uov.add(Integer.valueOf(this.NMi.NSG[i]));
      j += 1;
      i += 1;
    }
    this.NLM.Uow = this.NMi.NSG[i];
    this.NLM.Uox = this.NMi.NSG[(i + 1)];
    new com.tencent.mm.plugin.voip.model.a.k(this.NLM).gAX();
    AppMethodBeat.o(114901);
  }
  
  public final void gyC()
  {
    AppMethodBeat.i(114902);
    if (this.NLN == 0)
    {
      AppMethodBeat.o(114902);
      return;
    }
    if (this.NLN == 1)
    {
      this.NLN = 0;
      this.NMi.NSq = 0L;
      AppMethodBeat.o(114902);
      return;
    }
    this.NLN = 0;
    v2protocal localv2protocal = this.NMi;
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "v2protocal StopVoipSpeedTest!");
    localv2protocal.StopSpeedTest();
    localv2protocal.NSq = 0L;
    AppMethodBeat.o(114902);
  }
  
  public final void gyD()
  {
    AppMethodBeat.i(114905);
    this.NMi.NQY = this.NMk.gzb();
    this.NMi.NQZ = this.NMk.gxE();
    AppMethodBeat.o(114905);
  }
  
  public final int gyE()
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
  
  public final boolean gyF()
  {
    return (this.mStatus == 2) || (this.mStatus == 4);
  }
  
  public final boolean gyG()
  {
    return this.mStatus == 3;
  }
  
  public final boolean gyH()
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
  
  public final long gyI()
  {
    return this.NMi.NQW;
  }
  
  public final boolean gyJ()
  {
    if (this.NLU) {
      return false;
    }
    switch (this.NLW)
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
        } while (4 == this.NLX);
        return false;
      } while ((4 == this.NLX) || (-1 == this.NLX));
      return false;
      if ((5 == this.NLX) || (6 == this.NLX)) {
        break;
      }
    } while (7 != this.NLX);
    return false;
  }
  
  public final boolean gyK()
  {
    if (this.NLU) {
      return false;
    }
    switch (this.NLW)
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
        } while (4 == this.NLX);
        return false;
      } while ((4 == this.NLY) || (this.NLY == 0) || (-1 == this.NLY));
      return false;
      if ((5 == this.NLY) || (6 == this.NLY)) {
        break;
      }
    } while (7 != this.NLY);
    return false;
  }
  
  public final void gyM()
  {
    AppMethodBeat.i(114917);
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: try start talk");
    if ((this.NLI != true) || (this.NLG != true))
    {
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: fail isCanSendData " + this.NLI + ", isChannelConnectedSuccess " + this.NLG);
      AppMethodBeat.o(114917);
      return;
    }
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "Voip tryStartTalk, channel setActive");
    this.NMi.setActive();
    if (this.NLL == true)
    {
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: engine already started, isEngineStarted " + this.NLL);
      AppMethodBeat.o(114917);
      return;
    }
    this.NMi.setSvrConfig(205, 0, 0, this.NMi.NRY, 0, 0, 0, 0, null);
    this.NMi.setSvrConfig(207, 0, 0, this.NMi.NQR, 0, 0, 0, 0, null);
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.NMi.NRY + " SwitchFlag = " + this.NMi.NQR);
    this.NMi.NQU[0] = ((byte)af.juS.jrh);
    this.NMi.NQU[1] = ((byte)af.juS.jri);
    this.NMi.NQU[2] = ((byte)af.juS.jrj);
    this.NMi.NQU[3] = ((byte)af.juS.jrk);
    this.NMi.NQU[4] = ((byte)af.juS.jrl);
    this.NMi.NQU[5] = ((byte)af.juS.jrm);
    this.NMi.NQU[6] = ((byte)af.juS.jrn);
    this.NMi.NQU[7] = ((byte)af.juS.jro);
    this.NMi.NQU[8] = ((byte)af.juS.jrp);
    this.NMi.NQU[9] = ((byte)af.juS.jrq);
    this.NMi.setSvrConfig(209, 0, 0, 0, 0, 0, 0, this.NMi.NQU.length, this.NMi.NQU);
    int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbJ, -1);
    int k = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbK, -1);
    int m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbL, -1);
    this.NMi.setSvrConfig(210, j, k, m, 0, 0, 0, 0, null);
    if (this.NMi.startEngine() == 0) {
      this.NMi.NSI.NNQ = 0;
    }
    for (;;)
    {
      label581:
      label603:
      Object localObject1;
      label661:
      int n;
      if (this.NMi.NQT != null) {
        if (this.NMi.NQT.length < 1024)
        {
          this.NMi.setSvrConfig(208, 0, 0, 0, 0, 0, 0, this.NMi.NQT.length, this.NMi.NQT);
          gyL();
          if ((gyJ()) || (gyK())) {
            break label2965;
          }
          gyP();
          this.NMj.gyf();
          localObject1 = this.NMk;
          if (((n)localObject1).tQu != 2) {
            break label3013;
          }
          com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipDeviceHandler", "dev start already...");
          localObject1 = this.NMi.NSI;
          if (((o)localObject1).beginTime != 0L) {
            break label3575;
          }
          ((o)localObject1).NNJ = 0;
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + ((o)localObject1).beginTime + ", CurrentTime: " + System.currentTimeMillis());
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.VoipDailReport", "devin:endNewDial:" + ((o)localObject1).NNJ);
          this.NMj.onConnected();
          this.mStatus = 5;
          localObject1 = this.NMi.NSI;
          ((o)localObject1).NNR = System.currentTimeMillis();
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.VoipDailReport", "devin:beginTalk:" + ((o)localObject1).NNR);
          this.NMi.setSvrConfig(202, this.NMi.NRx, this.NMi.NRy, 0, 0, 0, 0, 0, null);
          this.NMi.setSvrConfig(203, 0, 0, this.NMi.NRC, 0, 0, 0, 0, null);
          this.NMi.setSvrConfig(206, 0, 0, this.NMi.NRG, 0, 0, 0, 0, null);
          this.NMi.setSvrConfig(103, this.NMi.NRz, this.NMi.NRA, this.NMi.NRB, this.NMi.NRE, 0, 0, 0, null);
          this.NMi.setSvrConfig(205, 0, 0, this.NMi.NRY, 0, 0, 0, 0, null);
          this.NMi.setSvrConfig(207, 0, 0, this.NMi.NQR, 0, 0, 0, 0, null);
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.NMi.NRY + " SwitchFlag = " + this.NMi.NQR);
          j = this.NMi.NRL >> 2 & 0x3;
          k = this.NMi.NRL & 0x3;
          if (this.NMi.DPQ != 0) {
            break label3593;
          }
          j = (j << 2) + k;
          label1041:
          this.NMi.setSvrConfig(502, 0, 0, j, 0, 0, 0, 0, null);
          this.NMi.setSvrConfig(503, 0, 0, this.NMi.NRM, this.NMi.NRN, this.NMi.NRO, this.NMi.NRP, 0, null);
          if ((this.NMi.NSd != null) && (this.NMi.NSe != null))
          {
            this.NMi.setSvrConfig(504, 0, 0, this.NMi.NSc, 0, 0, 0, 0, null);
            this.NMi.setSvrConfig(505, 0, 0, this.NMi.NSd[0], this.NMi.NSd[1], this.NMi.NSd[2], this.NMi.NSd[3], 0, null);
            this.NMi.setSvrConfig(506, 0, 0, this.NMi.NSe[0], this.NMi.NSe[1], 0, 0, 0, null);
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "FECSvrCtr = " + this.NMi.NSc + ",FECKeyPara1 = " + this.NMi.NSd[0] + "," + this.NMi.NSd[1] + "," + this.NMi.NSd[2] + "," + this.NMi.NSd[3] + ",FECKeyPara2 = " + this.NMi.NSe[0] + "," + this.NMi.NSe[1]);
          }
          k = this.NMi.NRQ;
          m = this.NMi.NRQ;
          n = this.NMi.NRQ;
          this.NMi.setSvrConfig(507, 0, 0, (k & 0x4) >> 2, (m & 0x2) >> 1, n & 0x1, 0, 0, null);
          this.NMi.setjbmbitraterssvrparam();
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "zhengxue[Logic] setSvrConfig brefore onStartTalk: audioTsdfBeyond3G = " + this.NMi.NRx + ",audioTsdEdge = " + this.NMi.NRy + ",passthroughQosAlgorithm = " + this.NMi.NRz + ",fastPlayRepair = " + this.NMi.NRA + ", audioDTX = " + this.NMi.NRC + ", mARQFlag = " + j + ", mQosStrategy = " + this.NMi.NRQ + ", mSvrCfgListV = " + this.NMi.NRB + ", maxBRForRelay = " + this.NMi.NRE);
          localObject1 = new byte[2];
          localObject1[0] = ((byte)af.juH.jql);
          localObject1[1] = -1;
          com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipContext", "steve: Model Name: " + Build.MODEL);
          com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipContext", "steve: Image Enhancement for Android Capture!!, mode: " + localObject1[0]);
          this.NMi.setAppCmd(15, (byte[])localObject1, 1);
          com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipContext", "anlin: ClientVersion: " + com.tencent.mm.protocal.d.RAD);
          localObject1 = ByteBuffer.allocate(4);
          ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN).putInt(com.tencent.mm.protocal.d.RAD);
          localObject1 = ((ByteBuffer)localObject1).array();
          this.NMi.setAppCmd(505, (byte[])localObject1, 4);
        }
      }
      label3593:
      try
      {
        if (this.NMi != null)
        {
          ??? = new ezo();
          ((ezo)???).UzP = 8;
          ((ezo)???).UzQ = new com.tencent.mm.cd.b((byte[])localObject1);
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "anlin send local client version: ".concat(String.valueOf(localObject1)));
          this.NMi.SendRUDP(((ezo)???).toByteArray(), ((ezo)???).toByteArray().length);
        }
        localObject1 = Build.MODEL;
        j = ((String)localObject1).length();
        localObject1 = ((String)localObject1).getBytes();
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "anlin DeviceModel: ".concat(String.valueOf(localObject1)));
        this.NMi.setAppCmd(507, (byte[])localObject1, j);
      }
      catch (Exception localException1)
      {
        label2965:
        label3636:
        label3769:
        try
        {
          if (this.NMi != null)
          {
            ??? = new ezo();
            ((ezo)???).UzP = 9;
            ((ezo)???).UzQ = new com.tencent.mm.cd.b((byte[])localObject1);
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "anlin send local device model: ".concat(String.valueOf(localObject1)));
            this.NMi.SendRUDP(((ezo)???).toByteArray(), ((ezo)???).toByteArray().length);
          }
          if ((this.NMi.NQR >> 17 & 0x1) != 0)
          {
            bool1 = true;
            if ((this.NMi.NQR >> 18 & 0x1) == 0) {
              break label3636;
            }
            bool2 = true;
            AT(bool1);
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "EnableBlur: SetBlurFlag =47, aqBlur=" + bool2);
            if (bool2)
            {
              localObject1 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject1).putInt(1);
              this.NMi.setAppCmd(47, ((ByteBuffer)localObject1).array(), 4);
            }
            if (!v2protocal.NQB)
            {
              localObject1 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject1).putInt(1);
              this.NMi.setAppCmd(68, ((ByteBuffer)localObject1).array(), 4);
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "hseasun: Voip close 720p Enc:  1");
            }
            if ((this.NMi.NQR & 0x2) == 0)
            {
              m(16, true, true);
              m(4, true, true);
            }
            j = this.NMi.NQR >> 12 & 0x1;
            localObject1 = ByteBuffer.allocate(4);
            ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
            ((ByteBuffer)localObject1).putInt(j);
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "weiranli set MixVcodec1 from svr = ".concat(String.valueOf(j)));
            this.NMi.setAppCmd(46, ((ByteBuffer)localObject1).array(), 4);
            if ((this.NMi.NQR & 0x200) == 0)
            {
              localObject1 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
              ((ByteBuffer)localObject1).putInt(8);
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "jcchen Disable 720p from svr: mSwitchFlag = " + this.NMi.NQR);
              this.NMi.setAppCmd(32, ((ByteBuffer)localObject1).array(), 4);
              this.NMi.setAppCmd(30, ((ByteBuffer)localObject1).array(), 4);
            }
            if ((this.NMi.NQR & 0x100000) != 1) {
              break label3642;
            }
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "setAppCmd: EMethodSetP2SSendThreadEnable enble, mSwitchFlag: " + this.NMi.NQR);
            this.NMi.setAppCmd(52);
            if (ac.mGA == 0) {
              break label3674;
            }
            localObject1 = ByteBuffer.allocate(4);
            ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
            ((ByteBuffer)localObject1).putInt(ac.mGA);
            this.NMi.setAppCmd(36, ((ByteBuffer)localObject1).array(), 4);
            localObject1 = new byte[4];
            this.NMi.setAppCmd(26, (byte[])localObject1, 4);
            localObject1 = ByteBuffer.wrap((byte[])localObject1);
            ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
            m = ((ByteBuffer)localObject1).getInt();
            com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipContext", "steve: iHW: ".concat(String.valueOf(m)));
            if (((this.NMi.NRB & 0x4) == 0) && (af.juH.jqn <= 0)) {
              break label3769;
            }
            j = 1;
            if ((j == 0) && (this.NMi.tSw))
            {
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:Server Disable HW enc/dec!!");
              if ((m & 0x4) == 0) {
                break label3774;
              }
              j = 1;
              if ((m & 0x8) == 0) {
                break label3779;
              }
              k = 1;
              if ((j != 0) || (k != 0))
              {
                this.NMk.NMY = true;
                aR(false, false);
              }
              this.NMi.tSw = false;
            }
            if (this.NMi.tSw)
            {
              ??? = this.NMi;
              n = af.juH.jqn;
              bool1 = false;
              if ((m & 0x4) == 0) {
                break label3784;
              }
              j = 1;
              if ((m & 0x8) == 0) {
                break label3789;
              }
              k = 1;
              if ((j != 0) || (k != 0))
              {
                if (j == 0) {
                  break label3794;
                }
                localObject1 = "video/hevc";
                ((v2protocal)???).NSL = new e(((v2protocal)???).width, ((v2protocal)???).height, ((v2protocal)???).NSN, ((v2protocal)???).bitrate, n, (String)localObject1);
                com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "steve : create HW encoder successfully:".concat(String.valueOf(localObject1)));
                if (v2protocal.NSO != null)
                {
                  v2protocal.NSM = new d(v2protocal.NSO);
                  com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "steve : create HW decoder successfully!");
                }
                bool1 = true;
              }
              if ((((v2protocal)???).NSL == null) || (v2protocal.NSM == null))
              {
                ((v2protocal)???).tSw = false;
                bool1 = false;
              }
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve: HW encoder/decoder init ret: " + bool1 + ", iHW:" + m);
              if (!this.NMi.tSw)
              {
                com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve: HW dec/enc NOT supported for both sides,end HWEnc!!");
                this.NMk.NMY = true;
                aR(false, false);
                c(8, true, false, true);
                c(8, true, false, false);
              }
            }
            if (this.NMi.NSL != null) {
              this.NMi.NSL.NJk = this;
            }
            if (v2protocal.NSM != null) {
              v2protocal.NSM.a(this);
            }
            this.NLL = true;
            this.NMu = false;
            localObject1 = this.NMw;
            ((VoipScoreState)localObject1).DRd = bq.beS();
            Log.i("MicroMsg.VoipScoreState", "markStartTalk, startTalkTime:%s", new Object[] { Long.valueOf(((VoipScoreState)localObject1).DRd) });
            gyN();
            gyO();
            AppMethodBeat.o(114917);
            return;
            this.NLL = false;
            this.NMi.NSI.NNQ = 1;
            continue;
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: length of generalStrategyBuf = " + this.NMi.NQT.length);
            break label581;
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: protocol has null generalStrategyBuf");
            break label581;
            if (this.NMz != null)
            {
              gyP();
              break label603;
            }
            this.NMA = 0;
            this.NMz = com.tencent.e.h.ZvG.b(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(114893);
                l locall = l.this;
                locall.NMA += 1;
                if ((l.this.NMi.NSw != 0) || (l.this.NMA > 10))
                {
                  l.this.gyP();
                  if (l.this.NMz != null)
                  {
                    l.this.NMz.cancel(false);
                    l.this.NMz = null;
                  }
                  AppMethodBeat.o(114893);
                  return;
                }
                AppMethodBeat.o(114893);
              }
            }, 200L, 200L);
            break label603;
            label3013:
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipDeviceHandler", "start device......");
            ((n)localObject1).tQu = 2;
            ((n)localObject1).NMY = false;
            ((n)localObject1).NMZ = 0;
            if (((n)localObject1).NNc != null)
            {
              Log.i("MicroMsg.Voip.VoipDeviceHandler", "mDevHandlerThread is not null");
              if (!((n)localObject1).NNc.isQuit()) {
                Log.i("MicroMsg.Voip.VoipDeviceHandler", "mDevHandlerThread is alive");
              }
            }
            ((n)localObject1).NNc.removeCallbacksAndMessages(null);
            if (((n)localObject1).NNh != null)
            {
              com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
              ((n)localObject1).NNh.NNl = true;
              ((n)localObject1).NNh.cancel();
              ((n)localObject1).NNh = null;
            }
            ((n)localObject1).NNh = new n.a((n)localObject1);
            ThreadPool.post(((n)localObject1).NNh, "VoipDeviceHandler_decode");
            com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipDeviceHandler", "start video decode thread..");
            af.juI.Y();
            for (;;)
            {
              synchronized (((n)localObject1).NMW)
              {
                while (((n)localObject1).tQu == n.tQt)
                {
                  Log.e("MicroMsg.Voip.VoipDeviceHandler", "current is not allowed to start dev");
                  synchronized (((n)localObject1).NMW)
                  {
                    ((n)localObject1).NNc.post(new n.2((n)localObject1));
                  }
                }
                localn.NMO = new c();
                localn.NMO.NJy = String.valueOf(localn.NNd);
                a locala = new a();
                j = localn.NJk.NMi.a(locala);
                com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.GetAudioDeviceFmt, play samplerate:" + locala.HlR + ", framelen: " + locala.NJg + ", ret:" + j);
                localn.NMO.S(locala.HlR, locala.channels, locala.NJg, 0);
                localn.tQv = localn.NMO.K(localn.NJk.uEJ, true);
                localn.NJk.NMi.NRl = localn.NMO.mkE;
                if (localn.NMO.NJj == true)
                {
                  j = 1;
                  int i = (byte)j;
                  localn.NJk.NMi.setAppCmd(502, new byte[] { i }, 1);
                  if (localn.tQv <= 10)
                  {
                    if (localn.tQv <= 0) {
                      localn.tQy = 1;
                    }
                    localn.tQv = 92;
                  }
                  if ((!com.tencent.mm.plugin.audio.c.a.crh()) && (!com.tencent.mm.plugin.audio.c.a.cro())) {
                    break label3565;
                  }
                  com.tencent.mm.plugin.voip.c.gxs().uB(true);
                  localn.NMO.NJt = new n.3(localn);
                  if (localn.NMO.gxB() <= 0) {
                    localn.tQy = 1;
                  }
                }
              }
              j = 0;
              continue;
              label3565:
              com.tencent.mm.plugin.voip.c.gxs().uB(false);
            }
            label3575:
            localObject2.NNJ = ((int)(System.currentTimeMillis() - localObject2.beginTime));
            break label661;
            j = (k << 2) + j;
            break label1041;
            localException1 = localException1;
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "anlin send local client version Error!");
          }
        }
        catch (Exception localException2)
        {
          label3642:
          label3774:
          label3779:
          label3784:
          label3789:
          label3794:
          for (;;)
          {
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "anlin send local device model Error!");
            continue;
            boolean bool1 = false;
            continue;
            boolean bool2 = false;
            continue;
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "setAppCmd: EMethodSetP2SSendThreadEnable disable, mSwitchFlag: " + this.NMi.NQR);
            continue;
            label3674:
            if (ac.mGB != 0)
            {
              if ((ac.mGB & 0x2) != 0) {
                m(2, true, false);
              }
              if ((ac.mGB & 0x20) != 0) {
                m(32, true, false);
              }
              if ((ac.mGB & 0x10) != 0) {
                m(16, true, false);
              }
              if ((ac.mGB & 0x4) != 0) {
                m(4, true, false);
              }
              if ((ac.mGB & 0x8) != 0)
              {
                m(8, true, false);
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
  
  public final boolean gyN()
  {
    AppMethodBeat.i(114922);
    boolean bool = gyJ();
    int i = 0;
    if (bool) {
      i = 1;
    }
    com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipContext", "needVideoOut ret: " + bool + "videoStatus: " + i + ", sendVideoStatus: " + this.NMg);
    if ((this.NMg == -1) || (this.NMg != i))
    {
      if (!bool) {
        break label158;
      }
      com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video Out.......!");
    }
    for (int j = this.NMi.setAppCmd(203);; j = this.NMi.setAppCmd(202))
    {
      if (j == 0)
      {
        this.NMg = i;
        com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: succeed, ret: " + j + "sendVideoStatus: " + this.NMg);
      }
      AppMethodBeat.o(114922);
      return bool;
      label158:
      com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video Out.......!");
    }
  }
  
  public final boolean gyO()
  {
    AppMethodBeat.i(114923);
    boolean bool = gyK();
    int i = 0;
    if (bool) {
      i = 1;
    }
    com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipContext", "needVideoIn ret: " + bool + "videoStatus: " + i + ", recvVideoStatus: " + this.NMh);
    if ((this.NMh == -1) || (this.NMh != i))
    {
      if (!bool) {
        break label158;
      }
      com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video In.......!");
    }
    for (int j = this.NMi.setAppCmd(201);; j = this.NMi.setAppCmd(200))
    {
      if (j == 0)
      {
        this.NMh = i;
        com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: succeed, ret: " + j + "recvVideoStatus: " + this.NMh);
      }
      AppMethodBeat.o(114923);
      return bool;
      label158:
      com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video In.......!");
    }
  }
  
  final void gyP()
  {
    AppMethodBeat.i(114924);
    if (this.mStatus == 5)
    {
      setStatus(6);
      this.NMi.NSI.gzf();
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "talking  now .......!");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114892);
          l.this.NMj.gye();
          AppMethodBeat.o(114892);
        }
      });
    }
    AppMethodBeat.o(114924);
  }
  
  public final void gyS()
  {
    AppMethodBeat.i(184051);
    boolean bool2 = gyQ();
    int k = af.juH.jqs;
    int m = af.juH.jqt;
    int i = this.NMi.NQR;
    int j = (this.NMi.NQR >> 11 & 0x1) << 3 | i >> 4 & 0x7;
    if (bool2) {}
    for (i = gyR();; i = 0)
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
        Log.printInfoStack("MicroMsg.Voip.VoipContext", "setVoipBeautyConfig local:%s, server:%s , blacklist:%s, whitelist:%s, voipBeautyFlag:%s, uiCallback:%s and isHitBlackListOrWhitList:%s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), this.NMj, Boolean.valueOf(bool1) });
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
            if (g.gCK())
            {
              m = g.gCJ();
              k = g.gCJ();
            }
          }
        }
        if (this.NMj != null) {
          this.NMj.setVoipBeauty(m);
        }
        this.NMi.NSi = m;
        this.NMi.NSj = k;
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
  
  public final void gyT()
  {
    int k = 0;
    AppMethodBeat.i(245018);
    int i;
    int m;
    int n;
    int i1;
    Boolean localBoolean;
    int j;
    if ((gyQ()) && (v2protocal.gBr()))
    {
      i = 1;
      m = af.juH.jqu;
      n = af.juH.jqv;
      i1 = this.NMi.NQR >> 15 & 0x1;
      localBoolean = Boolean.valueOf(g.gCM());
      if (n <= 0) {
        break label171;
      }
      j = k;
    }
    for (;;)
    {
      if (this.NMj != null) {
        this.NMj.setSpatiotemporalDenosing(j);
      }
      Log.i("MicroMsg.Voip.VoipContext", "hseasun: voipSTFilterSvrCfg:" + i1 + " voipSTFilterWhiteList:" + m + " voipSTFilterBlackList:" + n + " voipSTFilterFlag:%d " + j + " xSettingEnableSTFitler:" + localBoolean);
      this.NMi.NSk = j;
      AppMethodBeat.o(245018);
      return;
      i = 0;
      break;
      label171:
      if (m <= 0)
      {
        j = k;
        if (i == 0) {
          continue;
        }
        if (i1 <= 0)
        {
          j = k;
          if (!localBoolean.booleanValue()) {
            continue;
          }
        }
      }
      j = 1;
    }
  }
  
  public final void gyU()
  {
    AppMethodBeat.i(177021);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114896);
        if ((l.this.mStatus != 4) && (l.this.mStatus != 5) && (l.this.mStatus != 6))
        {
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "startConnectDirect status fail, status:" + l.this.mStatus);
          AppMethodBeat.o(114896);
          return;
        }
        if (l.this.NLF)
        {
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "can not startConnectDirect again");
          AppMethodBeat.o(114896);
          return;
        }
        l.this.NLF = true;
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel direct");
        if (l.this.NMi.NSm == null)
        {
          com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipContext", "direct conns buf null");
          AppMethodBeat.o(114896);
          return;
        }
        int i = l.this.NMi.AddNewDirectConns(l.this.NMi.NSm, l.this.NMi.NSm.length, 0);
        if (i < 0)
        {
          com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipContext", "v2protocal connectToPeerDirect failed, ret:".concat(String.valueOf(i)));
          AppMethodBeat.o(114896);
          return;
        }
        l.this.gyX();
        AppMethodBeat.o(114896);
      }
    });
    AppMethodBeat.o(177021);
  }
  
  public final void gyV()
  {
    AppMethodBeat.i(177022);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114897);
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "v2protocal QueryNicWanIp");
        if ((l.this.Foj != null) && (l.this.NMi.NSn != null))
        {
          int i = l.this.NMi.QueryNicWanIp(l.this.NMi.NSn, l.this.NMi.NSn.length);
          if (i != 0) {
            com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipContext", "query nic wan ip fail ret:".concat(String.valueOf(i)));
          }
        }
        else
        {
          l.this.eVJ();
          AppMethodBeat.o(114897);
          return;
        }
        AppMethodBeat.o(114897);
      }
    });
    AppMethodBeat.o(177022);
  }
  
  public final void gyW()
  {
    AppMethodBeat.i(114928);
    if (!Util.isNullOrNil(this.NMi.NQJ)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "channel:try start connect, hasRemotePid:" + bool + ",mStatus:" + this.mStatus + ",isPreConnect:" + this.NLK + ",isRemoteAccepted:" + this.NLH + ",isLocalAccept:" + this.fQy);
      this.NMi.NSI.NNC = 7;
      if ((!bool) || ((this.mStatus != 4) && (this.mStatus != 5) && (this.mStatus != 6) && ((this.mStatus != 2) || (this.NLK != true)) && ((this.mStatus != 3) || (this.NLK != true)))) {
        break label329;
      }
      if ((this.mStatus == 2) || (this.mStatus == 3) || (this.mStatus == 4) || (this.mStatus == 5) || (this.mStatus == 6)) {
        break;
      }
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "startConnect status fail, status:" + this.mStatus);
      AppMethodBeat.o(114928);
      return;
    }
    if ((!this.NLH) && (!this.fQy))
    {
      if ((this.NLK) && (!this.NLE))
      {
        a(new d()
        {
          public final void gyZ()
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
      if (!this.NLE)
      {
        a(new d()
        {
          public final void gyZ()
          {
            AppMethodBeat.i(177017);
            Log.i("MicroMsg.Voip.VoipContext", "onStartConnectRelay ok");
            l.this.gyU();
            l.this.gyV();
            AppMethodBeat.o(177017);
          }
        });
        AppMethodBeat.o(114928);
        return;
      }
      gyU();
      gyV();
    }
    label329:
    AppMethodBeat.o(114928);
  }
  
  public final void gyX()
  {
    AppMethodBeat.i(114929);
    if ((this.NLF) && (!Util.isNullOrNil(this.NMi.NQL)))
    {
      int i = this.NMi.handleCommand(1, this.NMi.NQL, this.NMi.NQL.length);
      if (i < 0) {
        com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipContext", "v2protocal handlecommand failed ret:".concat(String.valueOf(i)));
      }
      this.NMi.NQL = null;
    }
    AppMethodBeat.o(114929);
  }
  
  public final void gyY()
  {
    AppMethodBeat.i(114934);
    Log.i("MicroMsg.Voip.VoipContext", "stop repeat voip sync");
    this.NMy.stopTimer();
    AppMethodBeat.o(114934);
  }
  
  public final int m(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(114919);
    if (paramInt < 0)
    {
      AppMethodBeat.o(114919);
      return -1;
    }
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:DisableCodec: targetCodec = " + paramInt + ", local=" + paramBoolean1 + ", remote =" + paramBoolean2);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.putInt(paramInt);
    if (paramBoolean1) {}
    try
    {
      if (this.NMi != null)
      {
        ezo localezo = new ezo();
        localezo.UzP = 5;
        localezo.UzQ = new com.tencent.mm.cd.b(localByteBuffer.array());
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable local target codec: ".concat(String.valueOf(paramInt)));
        this.NMi.SendRUDP(localezo.toByteArray(), localezo.toByteArray().length);
      }
      if (paramBoolean2)
      {
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable remote target codec: ".concat(String.valueOf(paramInt)));
        localByteBuffer = ByteBuffer.allocate(6);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer.putShort((short)3);
        localByteBuffer.putShort((short)paramInt);
        localByteBuffer.putShort((short)0);
        this.NMi.setAppCmd(35, localByteBuffer.array(), 6);
      }
      AppMethodBeat.o(114919);
      return 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "DisableCodec Error");
      }
    }
  }
  
  public final void n(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.NMi.NRL = paramInt1;
    this.NMi.NRM = paramInt2;
    this.NMi.NRN = paramInt3;
    this.NMi.NRO = paramInt4;
    this.NMi.NRP = paramInt5;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(114900);
    Log.i("MicroMsg.Voip.VoipContext", "reset");
    this.NMk.gzc();
    if (this.NMi.gBo()) {
      this.NMi.AZ(false);
    }
    this.NMi.reset();
    this.NLW = -1;
    this.NLX = -1;
    this.NLY = -1;
    this.NLZ = -1;
    this.NMa = -1;
    this.NMi.NRc = 0;
    this.NMB.stopTimer();
    this.NMl.gAT();
    this.NMy.stopTimer();
    this.NLE = false;
    this.NLG = false;
    this.NLF = false;
    this.NLH = false;
    this.fQy = false;
    this.NLI = false;
    this.NMm = null;
    this.NMn = null;
    this.NLS = false;
    this.NLT = false;
    this.NLU = false;
    this.NMb = false;
    this.NMc = false;
    this.NMe = false;
    this.NMd = 1;
    this.NMf = 1;
    this.NMo = false;
    this.NMg = -1;
    this.NMh = -1;
    this.NLJ = false;
    this.NLK = false;
    this.NLI = false;
    this.NLE = false;
    this.NLL = false;
    this.NLV = 10;
    this.mStatus = 1;
    this.NMt = 0;
    this.NMx = 0;
    this.NMu = false;
    this.NMs = 0;
    this.Foj = null;
    this.Fol.clear();
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
      this.NMB.startTimer(60000L);
    }
    this.mStatus = paramInt;
    AppMethodBeat.o(114907);
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(114906);
    gyY();
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114889);
        if (l.this.NMj != null) {
          l.this.NMj.AO(false);
        }
        AppMethodBeat.o(114889);
      }
    });
    AppMethodBeat.o(114906);
  }
  
  public static abstract interface a
  {
    public abstract void J(int paramInt1, int paramInt2, String paramString);
  }
  
  static abstract interface d
  {
    public abstract void gyZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l
 * JD-Core Version:    0.7.0.1
 */