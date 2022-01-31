package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.tencent.mm.bv.b;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.a.h;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cci;
import com.tencent.mm.protocal.c.cef;
import com.tencent.mm.protocal.c.cex;
import com.tencent.mm.protocal.c.cey;
import com.tencent.mm.protocal.c.cfp;
import com.tencent.mm.protocal.c.cga;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

final class j$3
  extends ah
{
  j$3(j paramj, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.what != 59998)) {
      super.handleMessage(paramMessage);
    }
    label541:
    do
    {
      do
      {
        Object localObject4;
        do
        {
          return;
          Object localObject3;
          Object localObject1;
          Object localObject5;
          if (paramMessage.arg1 == 1)
          {
            if (this.pQy.pQe.lpD == 0)
            {
              a.Loge("MicroMsg.Voip.VoipContext", "JNI_DOSYNC without roomid , igored!");
              return;
            }
            a.Logi("MicroMsg.Voip.VoipContext", "need dosync for cmd from channel...");
            localObject3 = (byte[])paramMessage.obj;
            localObject1 = this.pQy.pQh;
            i = paramMessage.arg2;
            paramMessage = new cfp();
            paramMessage.hQR = 1;
            localObject5 = new bmk();
            ((bmk)localObject5).bs((byte[])localObject3);
            paramMessage.szp = ((bmk)localObject5);
            localObject3 = new bmk();
            try
            {
              ((bmk)localObject3).bs(paramMessage.toByteArray());
              paramMessage = new cex();
              paramMessage.sOA = i;
              paramMessage.sOB = ((bmk)localObject3);
              paramMessage.kWn = q.Gj();
              localObject3 = new cey();
              ((cey)localObject3).hPS = 1;
              ((cey)localObject3).hPT.add(paramMessage);
              ((t)localObject1).a((cey)localObject3, true, 2);
              return;
            }
            catch (IOException paramMessage)
            {
              y.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramMessage, "", new Object[0]);
              return;
            }
          }
          if (paramMessage.arg1 == 4)
          {
            if (this.pQy.pQe.lpD == 0)
            {
              a.Loge("MicroMsg.Voip.VoipContext", "JNI_STARTDEVFAILED without roomid , igored!");
              return;
            }
            a.Logi("MicroMsg.Voip.VoipContext", "need hangUP for startTalk failed. ");
            this.pQy.pQe.pWi.pQU = 107;
            this.pQy.s(1, -9004, "");
            return;
          }
          if (paramMessage.arg1 == 6)
          {
            a.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected from JNI");
            if (this.pQy.pQe.lpD == 0)
            {
              a.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected roomid null, ignored");
              return;
            }
            this.pQy.pPC = true;
            this.pQy.pQe.pWi.pRk = 1;
            if ((!this.pQy.bWb) && (!this.pQy.pPD)) {}
            for (this.pQy.pQe.pVe = 1;; this.pQy.pQe.pVe = 0)
            {
              this.pQy.pQe.setInactive();
              a.Logi("MicroMsg.Voip.VoipContext", "Voip.Channel setInactive");
              this.pQy.bQa();
              return;
            }
          }
          if (paramMessage.arg1 == 3)
          {
            j.b(this.pQy);
            return;
          }
          if (paramMessage.arg1 == 5)
          {
            a.Logi("MicroMsg.Voip.VoipContext", "need hangUP for disconnect from channel..envent = " + paramMessage.arg2);
            if (j.c(this.pQy) >= 5)
            {
              this.pQy.pQe.pWi.pQU = 108;
              if (paramMessage.arg2 != 4) {
                break label541;
              }
              this.pQy.pQe.pWi.pRm = 1;
              a.Logi("MicroMsg.Voip.VoipContext", "channel broken...");
            }
            for (;;)
            {
              this.pQy.s(1, -9000, "");
              return;
              this.pQy.pQe.pWi.pQU = 106;
              break;
              if (paramMessage.arg2 == 1)
              {
                if (this.pQy.pPG == true)
                {
                  a.Logi("MicroMsg.Voip.VoipContext", "channel connect fail while pre-connect");
                  this.pQy.pPF = true;
                  return;
                }
                a.Logi("MicroMsg.Voip.VoipContext", "channel connect fail...");
                this.pQy.pPC = false;
                this.pQy.pQe.pWi.pRm = 5;
              }
              else if (paramMessage.arg2 == 5)
              {
                if (this.pQy.pPF == true)
                {
                  this.pQy.pQe.pWi.pRm = 6;
                  a.Logi("MicroMsg.Voip.VoipContext", "channel network fail while pre-connect...");
                  this.pQy.pPF = true;
                  return;
                }
                a.Logi("MicroMsg.Voip.VoipContext", "channel network fail");
                this.pQy.pQe.pWi.pRm = 6;
              }
            }
          }
          if (paramMessage.arg1 == 100)
          {
            a.outputJniLog((byte[])paramMessage.obj, "MicroMsg.Voip.VoipContext", paramMessage.arg2);
            return;
          }
          if (paramMessage.arg1 == 101)
          {
            a.outputJniLog((byte[])paramMessage.obj, "MicroMsg.v2Core", paramMessage.arg2);
            return;
          }
          if (paramMessage.arg1 == 7)
          {
            localObject5 = (int[])paramMessage.obj;
            i = paramMessage.arg2;
            paramMessage = null;
            try
            {
              localObject1 = ((WifiManager)ae.getContext().getSystemService("wifi")).getConnectionInfo().getSSID();
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
              localObject3 = ((TelephonyManager)ae.getContext().getSystemService("phone")).getSimOperatorName();
              localObject1 = localObject3;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                a.Logi("MicroMsg.Voip.VoipContext", "Get netName failed in voip speedTest!");
              }
            }
            new com.tencent.mm.plugin.voip.model.a.j(this.pQy.pPL, this.pQy.pPK, this.pQy.pPM, (String)localObject1, paramMessage, this.pQy.pPN, i, (int[])localObject5).bRB();
            return;
          }
          if (paramMessage.arg1 != 8) {
            break label1414;
          }
          localObject2 = (byte[])paramMessage.obj;
          paramMessage = this.pQy;
          for (;;)
          {
            try
            {
              localObject2 = (cci)new cci().aH((byte[])localObject2);
              if ((!paramMessage.pQp) || (((cci)localObject2).tRC != 1)) {
                a.Logi("MicroMsg.Voip.VoipContext", "steve: onRecvRUDPCmd:" + ((cci)localObject2).tRC);
              }
              switch (((cci)localObject2).tRC)
              {
              case 1: 
                if (!paramMessage.pQp)
                {
                  a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client end HWEnc!!");
                  localObject4 = ByteBuffer.allocate(4);
                  ((ByteBuffer)localObject4).order(ByteOrder.LITTLE_ENDIAN);
                  ((ByteBuffer)localObject4).putInt(j.pQv);
                  paramMessage.pQe.setAppCmd(27, ((ByteBuffer)localObject4).array(), 4);
                  if (((cci)localObject2).tRD == null) {
                    break label1178;
                  }
                  localObject2 = ByteBuffer.wrap(((cci)localObject2).tRD.oY, 0, 4);
                  ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                  i = Math.min(((ByteBuffer)localObject2).getInt(), 6);
                  localObject2 = ByteBuffer.allocate(4);
                  ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
                  ((ByteBuffer)localObject2).putInt(i);
                  a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:CMD_VOIP_CloseHWEnc:reset maxsizeformat: " + i);
                  paramMessage.pQe.setAppCmd(30, ((ByteBuffer)localObject2).array(), 4);
                }
                paramMessage.pQp = true;
                return;
              }
            }
            catch (Exception paramMessage)
            {
              a.Logi("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
              return;
            }
            a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client tells us to end HWEnc!!");
            paramMessage.pQg.pQK = true;
            return;
            a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: cmdBuffer is nil!!");
          }
          if (((cci)localObject2).tRD == null) {
            break;
          }
          localObject2 = ((cci)localObject2).tRD.oY;
          a.Logi("MicroMsg.Voip.VoipContext", "steve: remote new network type:" + localObject2);
          i = paramMessage.pQe.setAppCmd(302, (byte[])localObject2, 4);
        } while (i >= 0);
        a.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + localObject2 + "fail:" + i + ", [roomid=" + paramMessage.pQe.lpL + ", roomkey=" + paramMessage.pQe.lpE + "]");
        return;
        a.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
        return;
        if (((cci)localObject2).tRD != null)
        {
          localObject2 = ((cci)localObject2).tRD.oY;
          localObject2 = (cef)new cef().aH((byte[])localObject2);
          a.Logi("MicroMsg.Voip.VoipContext", "zhengxue: remote audio dev occupied stat :" + ((cef)localObject2).tTm);
          localObject4 = new byte[4];
          localObject4[0] = ((byte)((cef)localObject2).tTm);
          paramMessage.pQe.setJNIAppCmd(2, (byte[])localObject4, 4);
          return;
        }
        a.Logi("MicroMsg.Voip.VoipContext", "zhengxue:[CHANNEL]EMethod_AudioDevOccupiedStatsSync empty buffer");
        return;
        if (paramMessage.arg1 != 9) {
          break;
        }
        paramMessage = this.pQy.pQe.pWi;
        if (0L == paramMessage.pRy)
        {
          paramMessage.pRy = System.currentTimeMillis();
          a.Logi("MicroMsg.VoipDailReport", "first pkt received timestamp:" + paramMessage.pRy);
        }
        a.Logi("MicroMsg.Voip.VoipContext", "get first pkt for voip");
      } while (1 != this.pQy.pQe.pVL);
      paramMessage = new cga();
      paramMessage.hQq = 1;
      this.pQy.pQh.a(paramMessage, 2);
      return;
      if (paramMessage.arg1 == 11)
      {
        this.pQy.pQr = 2;
        return;
      }
      if (paramMessage.arg1 == 12)
      {
        this.pQy.pQr = 1;
        return;
      }
      if (paramMessage.arg1 == 13)
      {
        localObject2 = (int[])paramMessage.obj;
        i = paramMessage.arg2;
        new h(this.pQy.pQe.lpD, this.pQy.pQe.lpE, this.pQy.pQe.lpL, 1, i, (int[])localObject2).bRB();
        return;
      }
    } while (paramMessage.arg1 != 14);
    label1178:
    Object localObject2 = (int[])paramMessage.obj;
    label1414:
    int i = paramMessage.arg2;
    new h(this.pQy.pQe.lpD, this.pQy.pQe.lpE, this.pQy.pQe.lpL, 2, i, (int[])localObject2).bRB();
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.j.3
 * JD-Core Version:    0.7.0.1
 */