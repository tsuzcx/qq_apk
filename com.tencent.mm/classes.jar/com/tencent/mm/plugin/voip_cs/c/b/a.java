package com.tencent.mm.plugin.voip_cs.c.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.protocal.protobuf.ezo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

public final class a
{
  private MMHandler DQI;
  private boolean DQJ;
  boolean DQK;
  public com.tencent.mm.plugin.voip_cs.c.a Okf;
  public a Okg;
  
  public a()
  {
    AppMethodBeat.i(125420);
    this.DQJ = false;
    this.DQK = false;
    this.Okg = null;
    this.DQI = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(125419);
        if (paramAnonymousMessage == null)
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(125419);
          return;
        }
        Log.d("MicroMsg.VoipCSEngine", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[] { Integer.valueOf(paramAnonymousMessage.what), paramAnonymousMessage.obj, Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2) });
        int i;
        switch (paramAnonymousMessage.arg1)
        {
        default: 
          AppMethodBeat.o(125419);
          return;
        case 6: 
          Log.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_CHANNEL_CONNECTED");
          paramAnonymousMessage = c.gEX();
          Log.d("MicroMsg.VoipCSReportHelper", "channelConnect");
          paramAnonymousMessage.OiT = 1;
          paramAnonymousMessage = a.this;
          Log.i("MicroMsg.VoipCSEngine", "channel connect!");
          if (paramAnonymousMessage.DQK)
          {
            Log.i("MicroMsg.VoipCSEngine", "channel already connect! do call not startEngine again");
            AppMethodBeat.o(125419);
            return;
          }
          paramAnonymousMessage.DQK = true;
          Log.i("MicroMsg.VoipCSEngine", "start engine");
          paramAnonymousMessage.Okf.setInactive();
          Log.d("MicroMsg.VoipCSEngine", "setChannelActiveAfterAccept");
          if (!paramAnonymousMessage.DQK) {
            Log.d("MicroMsg.VoipCSEngine", "channel not connect now");
          }
          paramAnonymousMessage.Okf.setActive();
          i = paramAnonymousMessage.Okf.startEngine();
          if (i == 0)
          {
            Log.i("MicroMsg.VoipCSEngine", "start engine suc!");
            localObject1 = new int[2];
            localObject1[0] = c.gEV().Okf.NSf;
            localObject1[1] = c.gEV().Okf.NSg;
            Log.i("MicroMsg.VoipCSEngine", "steve: Get server config! MaxBR:" + localObject1[0] + ", MaxFps:" + localObject1[1]);
            if ((localObject1[0] > 0) && (localObject1[1] > 0))
            {
              Object localObject2 = ByteBuffer.allocate(8);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put((int[])localObject1);
              localObject2 = ((ByteBuffer)localObject2).array();
              if (c.gEV().Okf.setAppCmd(34, (byte[])localObject2, localObject2.length) < 0) {
                Log.i("MicroMsg.VoipCSEngine", "setAppCmd: type:34,qosparam:" + localObject1[0] + "," + localObject1[1] + ",ret:" + i);
              }
            }
          }
          for (c.gEX().OiR = 1;; c.gEX().OiR = 0)
          {
            if ((paramAnonymousMessage.Okg != null) && (c.gEW().Ojw != 2))
            {
              paramAnonymousMessage.Okg.eIM();
              c.gEW().Ojw = 2;
            }
            AppMethodBeat.o(125419);
            return;
            Log.i("MicroMsg.VoipCSEngine", "start engine fail!");
          }
        case 5: 
          Log.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_RESET");
          if (paramAnonymousMessage.arg2 == 4)
          {
            Log.i("MicroMsg.VoipCSEngine", "channel broken...");
            c.gEX().OiQ = 1;
          }
          for (;;)
          {
            paramAnonymousMessage = a.this;
            Log.i("MicroMsg.VoipCSEngine", "channel connect failed!");
            c.gEX().dataType = 1;
            if (paramAnonymousMessage.Okg != null) {
              paramAnonymousMessage.Okg.gFr();
            }
            AppMethodBeat.o(125419);
            return;
            if (paramAnonymousMessage.arg2 == 5)
            {
              Log.i("MicroMsg.VoipCSEngine", "channel event network failer...");
              c.gEX().OiQ = 6;
            }
            else
            {
              Log.i("MicroMsg.VoipCSEngine", "channel connect fail...");
              c.gEX().OiQ = 5;
            }
          }
        case 3: 
          Log.d("MicroMsg.VoipCSEngine", "start dev!");
          AppMethodBeat.o(125419);
          return;
        case 1: 
          AppMethodBeat.o(125419);
          return;
        case 4: 
          AppMethodBeat.o(125419);
          return;
        case 100: 
          com.tencent.mm.plugin.voip.c.e.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.VoipCSEngine", paramAnonymousMessage.arg2);
          AppMethodBeat.o(125419);
          return;
        case 101: 
          com.tencent.mm.plugin.voip.c.e.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.VoipCSEngine-JNI_CORE", paramAnonymousMessage.arg2);
          AppMethodBeat.o(125419);
          return;
        }
        Object localObject1 = (byte[])paramAnonymousMessage.obj;
        paramAnonymousMessage = a.this;
        for (;;)
        {
          try
          {
            localObject1 = (ezo)new ezo().parseFrom((byte[])localObject1);
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.VoipCSEngine", "steve: onRecvRUDPCmd:" + ((ezo)localObject1).UzP);
            i = ((ezo)localObject1).UzP;
            switch (i)
            {
            default: 
              AppMethodBeat.o(125419);
              return;
            }
            if (((ezo)localObject1).UzQ == null) {
              break label913;
            }
            localObject1 = ((ezo)localObject1).UzQ.UH;
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.VoipCSEngine", "steve: remote new network type:".concat(String.valueOf(localObject1)));
            i = paramAnonymousMessage.Okf.setAppCmd(302, (byte[])localObject1, 4);
            if (i < 0) {
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + localObject1 + "fail:" + i + ", [roomid=" + paramAnonymousMessage.Okf.NQI + ", roomkey=" + paramAnonymousMessage.Okf.DPJ + "]");
            }
            AppMethodBeat.o(125419);
            return;
          }
          catch (Exception paramAnonymousMessage)
          {
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
          }
          break;
          label913:
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
        }
      }
    };
    this.Okf = new com.tencent.mm.plugin.voip_cs.c.a(this.DQI);
    AppMethodBeat.o(125420);
  }
  
  public final int AW(boolean paramBoolean)
  {
    AppMethodBeat.i(214195);
    if (paramBoolean) {}
    for (int i = this.Okf.setAppCmd(401);; i = this.Okf.setAppCmd(402))
    {
      if (i < 0) {
        com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.VoipCSEngine", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(214195);
      return i;
    }
  }
  
  public final com.tencent.mm.plugin.voip_cs.c.a gFq()
  {
    return this.Okf;
  }
  
  public final void init()
  {
    AppMethodBeat.i(125421);
    this.DQK = false;
    this.DQJ = false;
    if (this.Okf.gBo())
    {
      Log.d("MicroMsg.VoipCSEngine", "protocal has init,now uninit!");
      this.Okf.AZ(false);
      this.Okf.reset();
    }
    this.Okf.NQH = 1;
    long l = System.currentTimeMillis();
    int i = this.Okf.gET();
    Log.d("MicroMsg.VoipCSEngine", "protocal init finish, ret: %d, used %dms", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
    if (i < 0) {
      Log.e("MicroMsg.VoipCSEngine", "engine init failed!");
    }
    AppMethodBeat.o(125421);
  }
  
  public static abstract interface a
  {
    public abstract void eIM();
    
    public abstract void gFr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.b.a
 * JD-Core Version:    0.7.0.1
 */