package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.a.h;
import com.tencent.mm.plugin.voip.model.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cpp;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.csi;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.protocal.protobuf.ctl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

final class k$3
  extends ak
{
  k$3(k paramk, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(4393);
    if ((paramMessage == null) || (paramMessage.what != 59998))
    {
      super.handleMessage(paramMessage);
      AppMethodBeat.o(4393);
      return;
    }
    Object localObject3;
    Object localObject1;
    int i;
    Object localObject4;
    if (paramMessage.arg1 == 1)
    {
      if (this.tvC.tvj.nMZ == 0)
      {
        a.Loge("MicroMsg.Voip.VoipContext", "JNI_DOSYNC without roomid , igored!");
        AppMethodBeat.o(4393);
        return;
      }
      a.Logi("MicroMsg.Voip.VoipContext", "need dosync for cmd from channel...");
      localObject3 = (byte[])paramMessage.obj;
      localObject1 = this.tvC.tvm;
      i = paramMessage.arg2;
      paramMessage = new cta();
      paramMessage.jKs = 1;
      localObject4 = new SKBuiltinBuffer_t();
      ((SKBuiltinBuffer_t)localObject4).setBuffer((byte[])localObject3);
      paramMessage.wtq = ((SKBuiltinBuffer_t)localObject4);
      localObject3 = new SKBuiltinBuffer_t();
      try
      {
        ((SKBuiltinBuffer_t)localObject3).setBuffer(paramMessage.toByteArray());
        paramMessage = new csi();
        paramMessage.wMC = i;
        paramMessage.wMD = ((SKBuiltinBuffer_t)localObject3);
        paramMessage.num = r.Zn();
        localObject3 = new csj();
        ((csj)localObject3).jJu = 1;
        ((csj)localObject3).jJv.add(paramMessage);
        ((v)localObject1).a((csj)localObject3, true, 2);
        AppMethodBeat.o(4393);
        return;
      }
      catch (IOException paramMessage)
      {
        ab.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramMessage, "", new Object[0]);
        AppMethodBeat.o(4393);
        return;
      }
    }
    if (paramMessage.arg1 == 4)
    {
      if (this.tvC.tvj.nMZ == 0)
      {
        a.Loge("MicroMsg.Voip.VoipContext", "JNI_STARTDEVFAILED without roomid , igored!");
        AppMethodBeat.o(4393);
        return;
      }
      a.Logi("MicroMsg.Voip.VoipContext", "need hangUP for startTalk failed. ");
      this.tvC.tvj.tBN.twb = 107;
      this.tvC.y(1, -9004, "");
      AppMethodBeat.o(4393);
      return;
    }
    if (paramMessage.arg1 == 6)
    {
      a.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected from JNI");
      if (this.tvC.tvj.nMZ == 0)
      {
        a.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected roomid null, ignored");
        AppMethodBeat.o(4393);
        return;
      }
      this.tvC.tuH = true;
      this.tvC.tvj.tBN.twr = 1;
      if ((!this.tvC.cDO) && (!this.tvC.tuI)) {}
      for (this.tvC.tvj.tAG = 1;; this.tvC.tvj.tAG = 0)
      {
        this.tvC.tvj.setInactive();
        a.Logi("MicroMsg.Voip.VoipContext", "Voip.Channel setInactive");
        this.tvC.cMf();
        AppMethodBeat.o(4393);
        return;
      }
    }
    if (paramMessage.arg1 == 3)
    {
      this.tvC.mStatus = 5;
      AppMethodBeat.o(4393);
      return;
    }
    if (paramMessage.arg1 == 5)
    {
      a.Logi("MicroMsg.Voip.VoipContext", "need hangUP for disconnect from channel..envent = " + paramMessage.arg2);
      if (this.tvC.mStatus >= 5)
      {
        this.tvC.tvj.tBN.twb = 108;
        if (paramMessage.arg2 != 4) {
          break label607;
        }
        this.tvC.tvj.tBN.twt = 1;
        a.Logi("MicroMsg.Voip.VoipContext", "channel broken...");
      }
      for (;;)
      {
        this.tvC.y(1, -9000, "");
        AppMethodBeat.o(4393);
        return;
        this.tvC.tvj.tBN.twb = 106;
        break;
        label607:
        if (paramMessage.arg2 == 1)
        {
          if (this.tvC.tuL == true)
          {
            a.Logi("MicroMsg.Voip.VoipContext", "channel connect fail while pre-connect");
            this.tvC.tuK = true;
            AppMethodBeat.o(4393);
            return;
          }
          a.Logi("MicroMsg.Voip.VoipContext", "channel connect fail...");
          this.tvC.tuH = false;
          this.tvC.tvj.tBN.twt = 5;
        }
        else if (paramMessage.arg2 == 5)
        {
          if (this.tvC.tuK == true)
          {
            this.tvC.tvj.tBN.twt = 6;
            a.Logi("MicroMsg.Voip.VoipContext", "channel network fail while pre-connect...");
            this.tvC.tuK = true;
            AppMethodBeat.o(4393);
            return;
          }
          a.Logi("MicroMsg.Voip.VoipContext", "channel network fail");
          this.tvC.tvj.tBN.twt = 6;
        }
      }
    }
    if (paramMessage.arg1 == 100)
    {
      a.outputJniLog((byte[])paramMessage.obj, "MicroMsg.Voip.VoipContext", paramMessage.arg2);
      AppMethodBeat.o(4393);
      return;
    }
    if (paramMessage.arg1 == 101)
    {
      a.outputJniLog((byte[])paramMessage.obj, "MicroMsg.v2Core", paramMessage.arg2);
      AppMethodBeat.o(4393);
      return;
    }
    if (paramMessage.arg1 == 7)
    {
      localObject4 = (int[])paramMessage.obj;
      i = paramMessage.arg2;
      paramMessage = null;
      try
      {
        localObject1 = at.gX(ah.getContext());
        paramMessage = (Message)localObject1;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          a.Logi("MicroMsg.Voip.VoipContext", "Get wifiName failed in voip speedTest!");
        }
      }
      localObject1 = null;
      try
      {
        localObject3 = ((TelephonyManager)ah.getContext().getSystemService("phone")).getSimOperatorName();
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          a.Logi("MicroMsg.Voip.VoipContext", "Get netName failed in voip speedTest!");
        }
      }
      new j(this.tvC.tuQ, this.tvC.tuP, this.tvC.tuR, (String)localObject1, paramMessage, this.tvC.tuS, i, (int[])localObject4).cOs();
      AppMethodBeat.o(4393);
      return;
    }
    Object localObject2;
    if (paramMessage.arg1 == 8)
    {
      localObject2 = (byte[])paramMessage.obj;
      paramMessage = this.tvC;
      for (;;)
      {
        try
        {
          localObject2 = (cpp)new cpp().parseFrom((byte[])localObject2);
          if ((!paramMessage.tvu) || (((cpp)localObject2).xYy != 1)) {
            a.Logi("MicroMsg.Voip.VoipContext", "steve: onRecvRUDPCmd:" + ((cpp)localObject2).xYy);
          }
          i = ((cpp)localObject2).xYy;
          switch (i)
          {
          default: 
            AppMethodBeat.o(4393);
            return;
          }
        }
        catch (Exception paramMessage)
        {
          a.Logi("MicroMsg.Voip.VoipContext", "rudp cmd processing Error");
          AppMethodBeat.o(4393);
          return;
        }
        a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client tells us to end HWEnc!!");
        paramMessage.tvl.tvO = true;
        AppMethodBeat.o(4393);
        return;
        if (!paramMessage.tvu)
        {
          a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client end HWEnc!!");
          paramMessage.ao(8, false);
          if (((cpp)localObject2).xYz == null) {
            break label1252;
          }
          localObject2 = ByteBuffer.wrap(((cpp)localObject2).xYz.pW, 0, 4);
          ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
          i = Math.min(((ByteBuffer)localObject2).getInt(), 6);
          localObject2 = ByteBuffer.allocate(4);
          ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
          ((ByteBuffer)localObject2).putInt(i);
          a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:CMD_VOIP_CloseHWEnc:reset maxsizeformat: ".concat(String.valueOf(i)));
          paramMessage.tvj.setAppCmd(30, ((ByteBuffer)localObject2).array(), 4);
        }
        for (;;)
        {
          paramMessage.tvu = true;
          AppMethodBeat.o(4393);
          return;
          label1252:
          a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: cmdBuffer is nil!!");
        }
        if (((cpp)localObject2).xYz != null)
        {
          localObject2 = ((cpp)localObject2).xYz.pW;
          a.Logi("MicroMsg.Voip.VoipContext", "steve: remote new network type:".concat(String.valueOf(localObject2)));
          i = paramMessage.tvj.setAppCmd(302, (byte[])localObject2, 4);
          if (i < 0) {
            a.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + localObject2 + "fail:" + i + ", [roomid=" + paramMessage.tvj.nNh + ", roomkey=" + paramMessage.tvj.nNa + "]");
          }
          AppMethodBeat.o(4393);
          return;
        }
        a.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
        AppMethodBeat.o(4393);
        return;
        if (((cpp)localObject2).xYz != null)
        {
          localObject2 = ((cpp)localObject2).xYz.pW;
          localObject2 = (crq)new crq().parseFrom((byte[])localObject2);
          a.Logi("MicroMsg.Voip.VoipContext", "zhengxue: remote audio dev occupied stat :" + ((crq)localObject2).yaF);
          byte[] arrayOfByte = new byte[4];
          arrayOfByte[0] = ((byte)((crq)localObject2).yaF);
          paramMessage.tvj.setJNIAppCmd(2, arrayOfByte, 4);
          AppMethodBeat.o(4393);
          return;
        }
        a.Logi("MicroMsg.Voip.VoipContext", "zhengxue:[CHANNEL]EMethod_AudioDevOccupiedStatsSync empty buffer");
        AppMethodBeat.o(4393);
        return;
        if (((cpp)localObject2).xYz != null)
        {
          localObject2 = ((cpp)localObject2).xYz.pW;
          if (paramMessage.tvj != null) {
            paramMessage.tvj.setAppCmd(35, (byte[])localObject2, 4);
          }
          AppMethodBeat.o(4393);
          return;
        }
        a.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodDisableCodec] empty buffer");
      }
    }
    if (paramMessage.arg1 == 9)
    {
      paramMessage = this.tvC.tvj.tBN;
      if (0L == paramMessage.twF)
      {
        paramMessage.twF = System.currentTimeMillis();
        a.Logi("MicroMsg.VoipDailReport", "first pkt received timestamp:" + paramMessage.twF);
      }
      a.Logi("MicroMsg.Voip.VoipContext", "get first pkt for voip");
      if (1 == this.tvC.tvj.tBq)
      {
        paramMessage = new ctl();
        paramMessage.jJS = 1;
        this.tvC.tvm.a(paramMessage, 2);
        AppMethodBeat.o(4393);
      }
    }
    else
    {
      if (paramMessage.arg1 == 11)
      {
        this.tvC.tvw = 2;
        AppMethodBeat.o(4393);
        return;
      }
      if (paramMessage.arg1 == 12)
      {
        this.tvC.tvw = 1;
        AppMethodBeat.o(4393);
        return;
      }
      if (paramMessage.arg1 == 13)
      {
        localObject2 = (int[])paramMessage.obj;
        i = paramMessage.arg2;
        new h(this.tvC.tvj.nMZ, this.tvC.tvj.nNa, this.tvC.tvj.nNh, 1, i, (int[])localObject2).cOs();
        AppMethodBeat.o(4393);
        return;
      }
      if (paramMessage.arg1 == 14)
      {
        localObject2 = (int[])paramMessage.obj;
        i = paramMessage.arg2;
        new h(this.tvC.tvj.nMZ, this.tvC.tvj.nNa, this.tvC.tvj.nNh, 2, i, (int[])localObject2).cOs();
      }
    }
    AppMethodBeat.o(4393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.k.3
 * JD-Core Version:    0.7.0.1
 */