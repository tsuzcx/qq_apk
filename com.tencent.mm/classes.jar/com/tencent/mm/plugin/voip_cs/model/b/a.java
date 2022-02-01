package com.tencent.mm.plugin.voip_cs.model.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip_cs.model.c;
import com.tencent.mm.plugin.voip_cs.model.e;
import com.tencent.mm.protocal.protobuf.fvs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

public final class a
{
  private MMHandler JHS;
  private boolean JHT;
  boolean JHU;
  public com.tencent.mm.plugin.voip_cs.model.a UYC;
  public a UYD;
  
  public a()
  {
    AppMethodBeat.i(125420);
    this.JHT = false;
    this.JHU = false;
    this.UYD = null;
    this.JHS = new MMHandler(Looper.getMainLooper())
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
          paramAnonymousMessage = c.idY();
          Log.d("MicroMsg.VoipCSReportHelper", "channelConnect");
          paramAnonymousMessage.UXo = 1;
          paramAnonymousMessage = a.this;
          Log.i("MicroMsg.VoipCSEngine", "channel connect!");
          if (paramAnonymousMessage.JHU)
          {
            Log.i("MicroMsg.VoipCSEngine", "channel already connect! do call not startEngine again");
            AppMethodBeat.o(125419);
            return;
          }
          paramAnonymousMessage.JHU = true;
          Log.i("MicroMsg.VoipCSEngine", "start engine");
          paramAnonymousMessage.UYC.setInactive();
          Log.d("MicroMsg.VoipCSEngine", "setChannelActiveAfterAccept");
          if (!paramAnonymousMessage.JHU) {
            Log.d("MicroMsg.VoipCSEngine", "channel not connect now");
          }
          paramAnonymousMessage.UYC.setActive();
          i = paramAnonymousMessage.UYC.startEngine();
          if (i == 0)
          {
            Log.i("MicroMsg.VoipCSEngine", "start engine suc!");
            localObject1 = new int[2];
            localObject1[0] = c.idW().UYC.UFk;
            localObject1[1] = c.idW().UYC.UFl;
            Log.i("MicroMsg.VoipCSEngine", "steve: Get server config! MaxBR:" + localObject1[0] + ", MaxFps:" + localObject1[1]);
            if ((localObject1[0] > 0) && (localObject1[1] > 0))
            {
              Object localObject2 = ByteBuffer.allocate(8);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put((int[])localObject1);
              localObject2 = ((ByteBuffer)localObject2).array();
              if (c.idW().UYC.setAppCmd(34, (byte[])localObject2, localObject2.length) < 0) {
                Log.i("MicroMsg.VoipCSEngine", "setAppCmd: type:34,qosparam:" + localObject1[0] + "," + localObject1[1] + ",ret:" + i);
              }
            }
          }
          for (c.idY().UXm = 1;; c.idY().UXm = 0)
          {
            if ((paramAnonymousMessage.UYD != null) && (c.idX().UXR != 2))
            {
              paramAnonymousMessage.UYD.fQM();
              c.idX().UXR = 2;
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
            c.idY().UXl = 1;
          }
          for (;;)
          {
            paramAnonymousMessage = a.this;
            Log.i("MicroMsg.VoipCSEngine", "channel connect failed!");
            c.idY().dataType = 1;
            if (paramAnonymousMessage.UYD != null) {
              paramAnonymousMessage.UYD.iep();
            }
            AppMethodBeat.o(125419);
            return;
            if (paramAnonymousMessage.arg2 == 5)
            {
              Log.i("MicroMsg.VoipCSEngine", "channel event network failer...");
              c.idY().UXl = 6;
            }
            else
            {
              Log.i("MicroMsg.VoipCSEngine", "channel connect fail...");
              c.idY().UXl = 5;
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
          g.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.VoipCSEngine", paramAnonymousMessage.arg2);
          AppMethodBeat.o(125419);
          return;
        case 101: 
          g.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.VoipCSEngine-JNI_CORE", paramAnonymousMessage.arg2);
          AppMethodBeat.o(125419);
          return;
        }
        Object localObject1 = (byte[])paramAnonymousMessage.obj;
        paramAnonymousMessage = a.this;
        for (;;)
        {
          try
          {
            localObject1 = (fvs)new fvs().parseFrom((byte[])localObject1);
            g.Logi("MicroMsg.VoipCSEngine", "steve: onRecvRUDPCmd:" + ((fvs)localObject1).abTS);
            i = ((fvs)localObject1).abTS;
            switch (i)
            {
            default: 
              AppMethodBeat.o(125419);
              return;
            }
            if (((fvs)localObject1).abTT == null) {
              break label905;
            }
            localObject1 = ((fvs)localObject1).abTT.Op;
            g.Logi("MicroMsg.VoipCSEngine", "steve: remote new network type:".concat(String.valueOf(localObject1)));
            i = paramAnonymousMessage.UYC.setAppCmd(302, (byte[])localObject1, 4);
            if (i < 0) {
              g.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + localObject1 + "fail:" + i + ", [roomid=" + paramAnonymousMessage.UYC.UDu + ", roomkey=" + paramAnonymousMessage.UYC.Hnt + "]");
            }
            AppMethodBeat.o(125419);
            return;
          }
          catch (Exception paramAnonymousMessage)
          {
            g.Logi("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
          }
          break;
          label905:
          g.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
        }
      }
    };
    this.UYC = new com.tencent.mm.plugin.voip_cs.model.a(this.JHS);
    AppMethodBeat.o(125420);
  }
  
  public final void init()
  {
    AppMethodBeat.i(125421);
    this.JHU = false;
    this.JHT = false;
    if (this.UYC.hZm())
    {
      Log.d("MicroMsg.VoipCSEngine", "protocal has init,now uninit!");
      this.UYC.Gw(false);
      this.UYC.reset();
    }
    this.UYC.UDt = 1;
    long l = System.currentTimeMillis();
    int i = this.UYC.idU();
    Log.d("MicroMsg.VoipCSEngine", "protocal init finish, ret: %d, used %dms", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
    if (i < 0) {
      Log.e("MicroMsg.VoipCSEngine", "engine init failed!");
    }
    AppMethodBeat.o(125421);
  }
  
  public static abstract interface a
  {
    public abstract void fQM();
    
    public abstract void iep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.model.b.a
 * JD-Core Version:    0.7.0.1
 */