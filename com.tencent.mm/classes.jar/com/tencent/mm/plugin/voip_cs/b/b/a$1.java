package com.tencent.mm.plugin.voip_cs.b.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.plugin.voip_cs.b.e;
import com.tencent.mm.protocal.c.cci;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

final class a$1
  extends ah
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      super.handleMessage(paramMessage);
    }
    for (;;)
    {
      return;
      y.d("MicroMsg.VoipCSEngine", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[] { Integer.valueOf(paramMessage.what), paramMessage.obj, Integer.valueOf(paramMessage.arg1), Integer.valueOf(paramMessage.arg2) });
      int i;
      switch (paramMessage.arg1)
      {
      case 1: 
      case 4: 
      default: 
        return;
      case 3: 
        y.d("MicroMsg.VoipCSEngine", "start dev!");
        return;
      case 6: 
        y.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_CHANNEL_CONNECTED");
        paramMessage = c.bSQ();
        y.d("MicroMsg.VoipCSReportHelper", "channelConnect");
        paramMessage.qdy = 1;
        paramMessage = this.qeN;
        y.i("MicroMsg.VoipCSEngine", "channel connect!");
        if (paramMessage.lqJ)
        {
          y.i("MicroMsg.VoipCSEngine", "channel already connect! do call not startEngine again");
          return;
        }
        paramMessage.lqJ = true;
        y.i("MicroMsg.VoipCSEngine", "start engine");
        paramMessage.qeL.setInactive();
        y.d("MicroMsg.VoipCSEngine", "setChannelActiveAfterAccept");
        if (!paramMessage.lqJ) {
          y.d("MicroMsg.VoipCSEngine", "channel not connect now");
        }
        paramMessage.qeL.setActive();
        i = paramMessage.qeL.startEngine();
        if (i == 0)
        {
          y.i("MicroMsg.VoipCSEngine", "start engine suc!");
          localObject1 = new int[2];
          localObject1[0] = c.bSO().qeL.pVJ;
          localObject1[1] = c.bSO().qeL.pVK;
          y.i("MicroMsg.VoipCSEngine", "steve: Get server config! MaxBR:" + localObject1[0] + ", MaxFps:" + localObject1[1]);
          if ((localObject1[0] > 0) && (localObject1[1] > 0))
          {
            Object localObject2 = ByteBuffer.allocate(8);
            ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put((int[])localObject1);
            localObject2 = ((ByteBuffer)localObject2).array();
            if (c.bSO().qeL.setAppCmd(34, (byte[])localObject2, localObject2.length) < 0) {
              y.i("MicroMsg.VoipCSEngine", "setAppCmd: type:34,qosparam:" + localObject1[0] + "," + localObject1[1] + ",ret:" + i);
            }
          }
        }
        for (c.bSQ().qdw = 1; (paramMessage.qeM != null) && (c.bSP().qeb != 2); c.bSQ().qdw = 0)
        {
          paramMessage.qeM.bbF();
          c.bSP().qeb = 2;
          return;
          y.i("MicroMsg.VoipCSEngine", "start engine fail!");
        }
      case 5: 
        y.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_RESET");
        if (paramMessage.arg2 == 4)
        {
          y.i("MicroMsg.VoipCSEngine", "channel broken...");
          c.bSQ().qdv = 1;
        }
        for (;;)
        {
          paramMessage = this.qeN;
          y.i("MicroMsg.VoipCSEngine", "channel connect failed!");
          c.bSQ().aYU = 1;
          if (paramMessage.qeM == null) {
            break;
          }
          paramMessage.qeM.bTe();
          return;
          if (paramMessage.arg2 == 5)
          {
            y.i("MicroMsg.VoipCSEngine", "channel event network failer...");
            c.bSQ().qdv = 6;
          }
          else
          {
            y.i("MicroMsg.VoipCSEngine", "channel connect fail...");
            c.bSQ().qdv = 5;
          }
        }
      case 100: 
        com.tencent.mm.plugin.voip.a.a.outputJniLog((byte[])paramMessage.obj, "MicroMsg.VoipCSEngine", paramMessage.arg2);
        return;
      case 101: 
        com.tencent.mm.plugin.voip.a.a.outputJniLog((byte[])paramMessage.obj, "MicroMsg.VoipCSEngine-JNI_CORE", paramMessage.arg2);
        return;
      }
      Object localObject1 = (byte[])paramMessage.obj;
      paramMessage = this.qeN;
      try
      {
        localObject1 = (cci)new cci().aH((byte[])localObject1);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipCSEngine", "steve: onRecvRUDPCmd:" + ((cci)localObject1).tRC);
        switch (((cci)localObject1).tRC)
        {
        case 3: 
          if (((cci)localObject1).tRD != null)
          {
            localObject1 = ((cci)localObject1).tRD.oY;
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipCSEngine", "steve: remote new network type:" + localObject1);
            i = paramMessage.qeL.setAppCmd(302, (byte[])localObject1, 4);
            if (i >= 0) {
              continue;
            }
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + localObject1 + "fail:" + i + ", [roomid=" + paramMessage.qeL.pUA + ", roomkey=" + paramMessage.qeL.lpE + "]");
          }
          break;
        }
      }
      catch (Exception paramMessage)
      {
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
        return;
      }
    }
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.b.a.1
 * JD-Core Version:    0.7.0.1
 */