package com.tencent.mm.plugin.voip_cs.b.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.plugin.voip_cs.b.e;
import com.tencent.mm.protocal.protobuf.cpp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

final class a$1
  extends ak
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(135367);
    if (paramMessage == null)
    {
      super.handleMessage(paramMessage);
      AppMethodBeat.o(135367);
      return;
    }
    ab.d("MicroMsg.VoipCSEngine", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[] { Integer.valueOf(paramMessage.what), paramMessage.obj, Integer.valueOf(paramMessage.arg1), Integer.valueOf(paramMessage.arg2) });
    int i;
    switch (paramMessage.arg1)
    {
    default: 
      AppMethodBeat.o(135367);
      return;
    case 6: 
      ab.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_CHANNEL_CONNECTED");
      paramMessage = c.cQo();
      ab.d("MicroMsg.VoipCSReportHelper", "channelConnect");
      paramMessage.tKl = 1;
      paramMessage = this.tLA;
      ab.i("MicroMsg.VoipCSEngine", "channel connect!");
      if (paramMessage.nOf)
      {
        ab.i("MicroMsg.VoipCSEngine", "channel already connect! do call not startEngine again");
        AppMethodBeat.o(135367);
        return;
      }
      paramMessage.nOf = true;
      ab.i("MicroMsg.VoipCSEngine", "start engine");
      paramMessage.tLy.setInactive();
      ab.d("MicroMsg.VoipCSEngine", "setChannelActiveAfterAccept");
      if (!paramMessage.nOf) {
        ab.d("MicroMsg.VoipCSEngine", "channel not connect now");
      }
      paramMessage.tLy.setActive();
      i = paramMessage.tLy.startEngine();
      if (i == 0)
      {
        ab.i("MicroMsg.VoipCSEngine", "start engine suc!");
        localObject1 = new int[2];
        localObject1[0] = c.cQm().tLy.tBo;
        localObject1[1] = c.cQm().tLy.tBp;
        ab.i("MicroMsg.VoipCSEngine", "steve: Get server config! MaxBR:" + localObject1[0] + ", MaxFps:" + localObject1[1]);
        if ((localObject1[0] > 0) && (localObject1[1] > 0))
        {
          Object localObject2 = ByteBuffer.allocate(8);
          ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put((int[])localObject1);
          localObject2 = ((ByteBuffer)localObject2).array();
          if (c.cQm().tLy.setAppCmd(34, (byte[])localObject2, localObject2.length) < 0) {
            ab.i("MicroMsg.VoipCSEngine", "setAppCmd: type:34,qosparam:" + localObject1[0] + "," + localObject1[1] + ",ret:" + i);
          }
        }
      }
      for (c.cQo().tKj = 1;; c.cQo().tKj = 0)
      {
        if ((paramMessage.tLz != null) && (c.cQn().tKO != 2))
        {
          paramMessage.tLz.bIN();
          c.cQn().tKO = 2;
        }
        AppMethodBeat.o(135367);
        return;
        ab.i("MicroMsg.VoipCSEngine", "start engine fail!");
      }
    case 5: 
      ab.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_RESET");
      if (paramMessage.arg2 == 4)
      {
        ab.i("MicroMsg.VoipCSEngine", "channel broken...");
        c.cQo().tKi = 1;
      }
      for (;;)
      {
        paramMessage = this.tLA;
        ab.i("MicroMsg.VoipCSEngine", "channel connect failed!");
        c.cQo().dataType = 1;
        if (paramMessage.tLz != null) {
          paramMessage.tLz.cQG();
        }
        AppMethodBeat.o(135367);
        return;
        if (paramMessage.arg2 == 5)
        {
          ab.i("MicroMsg.VoipCSEngine", "channel event network failer...");
          c.cQo().tKi = 6;
        }
        else
        {
          ab.i("MicroMsg.VoipCSEngine", "channel connect fail...");
          c.cQo().tKi = 5;
        }
      }
    case 3: 
      ab.d("MicroMsg.VoipCSEngine", "start dev!");
      AppMethodBeat.o(135367);
      return;
    case 1: 
      AppMethodBeat.o(135367);
      return;
    case 4: 
      AppMethodBeat.o(135367);
      return;
    case 100: 
      com.tencent.mm.plugin.voip.a.a.outputJniLog((byte[])paramMessage.obj, "MicroMsg.VoipCSEngine", paramMessage.arg2);
      AppMethodBeat.o(135367);
      return;
    case 101: 
      com.tencent.mm.plugin.voip.a.a.outputJniLog((byte[])paramMessage.obj, "MicroMsg.VoipCSEngine-JNI_CORE", paramMessage.arg2);
      AppMethodBeat.o(135367);
      return;
    }
    Object localObject1 = (byte[])paramMessage.obj;
    paramMessage = this.tLA;
    for (;;)
    {
      try
      {
        localObject1 = (cpp)new cpp().parseFrom((byte[])localObject1);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipCSEngine", "steve: onRecvRUDPCmd:" + ((cpp)localObject1).xYy);
        i = ((cpp)localObject1).xYy;
        switch (i)
        {
        default: 
          AppMethodBeat.o(135367);
          return;
        }
        if (((cpp)localObject1).xYz == null) {
          break label913;
        }
        localObject1 = ((cpp)localObject1).xYz.pW;
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipCSEngine", "steve: remote new network type:".concat(String.valueOf(localObject1)));
        i = paramMessage.tLy.setAppCmd(302, (byte[])localObject1, 4);
        if (i < 0) {
          com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + localObject1 + "fail:" + i + ", [roomid=" + paramMessage.tLy.tAb + ", roomkey=" + paramMessage.tLy.nNa + "]");
        }
        AppMethodBeat.o(135367);
        return;
      }
      catch (Exception paramMessage)
      {
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
      }
      break;
      label913:
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.b.a.1
 * JD-Core Version:    0.7.0.1
 */