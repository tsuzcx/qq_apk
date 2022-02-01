package com.tencent.mm.plugin.voip_cs.c.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.plugin.voip_cs.c.e;
import com.tencent.mm.protocal.protobuf.doo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

public final class a
{
  public com.tencent.mm.plugin.voip_cs.c.a AVR;
  public a AVS;
  private ao tJG;
  private boolean tJH;
  boolean tJI;
  
  public a()
  {
    AppMethodBeat.i(125420);
    this.tJH = false;
    this.tJI = false;
    this.AVS = null;
    this.tJG = new ao(Looper.getMainLooper())
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
        ac.d("MicroMsg.VoipCSEngine", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[] { Integer.valueOf(paramAnonymousMessage.what), paramAnonymousMessage.obj, Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2) });
        int i;
        switch (paramAnonymousMessage.arg1)
        {
        default: 
          AppMethodBeat.o(125419);
          return;
        case 6: 
          ac.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_CHANNEL_CONNECTED");
          paramAnonymousMessage = c.enE();
          ac.d("MicroMsg.VoipCSReportHelper", "channelConnect");
          paramAnonymousMessage.AUF = 1;
          paramAnonymousMessage = a.this;
          ac.i("MicroMsg.VoipCSEngine", "channel connect!");
          if (paramAnonymousMessage.tJI)
          {
            ac.i("MicroMsg.VoipCSEngine", "channel already connect! do call not startEngine again");
            AppMethodBeat.o(125419);
            return;
          }
          paramAnonymousMessage.tJI = true;
          ac.i("MicroMsg.VoipCSEngine", "start engine");
          paramAnonymousMessage.AVR.setInactive();
          ac.d("MicroMsg.VoipCSEngine", "setChannelActiveAfterAccept");
          if (!paramAnonymousMessage.tJI) {
            ac.d("MicroMsg.VoipCSEngine", "channel not connect now");
          }
          paramAnonymousMessage.AVR.setActive();
          i = paramAnonymousMessage.AVR.startEngine();
          if (i == 0)
          {
            ac.i("MicroMsg.VoipCSEngine", "start engine suc!");
            localObject1 = new int[2];
            localObject1[0] = c.enC().AVR.AHD;
            localObject1[1] = c.enC().AVR.AHE;
            ac.i("MicroMsg.VoipCSEngine", "steve: Get server config! MaxBR:" + localObject1[0] + ", MaxFps:" + localObject1[1]);
            if ((localObject1[0] > 0) && (localObject1[1] > 0))
            {
              Object localObject2 = ByteBuffer.allocate(8);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put((int[])localObject1);
              localObject2 = ((ByteBuffer)localObject2).array();
              if (c.enC().AVR.setAppCmd(34, (byte[])localObject2, localObject2.length) < 0) {
                ac.i("MicroMsg.VoipCSEngine", "setAppCmd: type:34,qosparam:" + localObject1[0] + "," + localObject1[1] + ",ret:" + i);
              }
            }
          }
          for (c.enE().AUD = 1;; c.enE().AUD = 0)
          {
            if ((paramAnonymousMessage.AVS != null) && (c.enD().AVi != 2))
            {
              paramAnonymousMessage.AVS.cTS();
              c.enD().AVi = 2;
            }
            AppMethodBeat.o(125419);
            return;
            ac.i("MicroMsg.VoipCSEngine", "start engine fail!");
          }
        case 5: 
          ac.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_RESET");
          if (paramAnonymousMessage.arg2 == 4)
          {
            ac.i("MicroMsg.VoipCSEngine", "channel broken...");
            c.enE().AUC = 1;
          }
          for (;;)
          {
            paramAnonymousMessage = a.this;
            ac.i("MicroMsg.VoipCSEngine", "channel connect failed!");
            c.enE().dataType = 1;
            if (paramAnonymousMessage.AVS != null) {
              paramAnonymousMessage.AVS.enY();
            }
            AppMethodBeat.o(125419);
            return;
            if (paramAnonymousMessage.arg2 == 5)
            {
              ac.i("MicroMsg.VoipCSEngine", "channel event network failer...");
              c.enE().AUC = 6;
            }
            else
            {
              ac.i("MicroMsg.VoipCSEngine", "channel connect fail...");
              c.enE().AUC = 5;
            }
          }
        case 3: 
          ac.d("MicroMsg.VoipCSEngine", "start dev!");
          AppMethodBeat.o(125419);
          return;
        case 1: 
          AppMethodBeat.o(125419);
          return;
        case 4: 
          AppMethodBeat.o(125419);
          return;
        case 100: 
          d.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.VoipCSEngine", paramAnonymousMessage.arg2);
          AppMethodBeat.o(125419);
          return;
        case 101: 
          d.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.VoipCSEngine-JNI_CORE", paramAnonymousMessage.arg2);
          AppMethodBeat.o(125419);
          return;
        }
        Object localObject1 = (byte[])paramAnonymousMessage.obj;
        paramAnonymousMessage = a.this;
        for (;;)
        {
          try
          {
            localObject1 = (doo)new doo().parseFrom((byte[])localObject1);
            d.Logi("MicroMsg.VoipCSEngine", "steve: onRecvRUDPCmd:" + ((doo)localObject1).FWj);
            i = ((doo)localObject1).FWj;
            switch (i)
            {
            default: 
              AppMethodBeat.o(125419);
              return;
            }
            if (((doo)localObject1).FWk == null) {
              break label913;
            }
            localObject1 = ((doo)localObject1).FWk.xy;
            d.Logi("MicroMsg.VoipCSEngine", "steve: remote new network type:".concat(String.valueOf(localObject1)));
            i = paramAnonymousMessage.AVR.setAppCmd(302, (byte[])localObject1, 4);
            if (i < 0) {
              d.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + localObject1 + "fail:" + i + ", [roomid=" + paramAnonymousMessage.AVR.AGg + ", roomkey=" + paramAnonymousMessage.AVR.tIG + "]");
            }
            AppMethodBeat.o(125419);
            return;
          }
          catch (Exception paramAnonymousMessage)
          {
            d.Logi("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
          }
          break;
          label913:
          d.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
        }
      }
    };
    this.AVR = new com.tencent.mm.plugin.voip_cs.c.a(this.tJG);
    AppMethodBeat.o(125420);
  }
  
  public final com.tencent.mm.plugin.voip_cs.c.a enX()
  {
    return this.AVR;
  }
  
  public final void init()
  {
    AppMethodBeat.i(125421);
    this.tJI = false;
    this.tJH = false;
    if (this.AVR.ekM())
    {
      ac.d("MicroMsg.VoipCSEngine", "protocal has init,now uninit!");
      this.AVR.sH(false);
      this.AVR.reset();
    }
    this.AVR.AGf = 1;
    long l = System.currentTimeMillis();
    int i = this.AVR.enA();
    ac.d("MicroMsg.VoipCSEngine", "protocal init finish, ret: %d, used %dms", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
    if (i < 0) {
      ac.e("MicroMsg.VoipCSEngine", "engine init failed!");
    }
    AppMethodBeat.o(125421);
  }
  
  public final int sE(boolean paramBoolean)
  {
    AppMethodBeat.i(205743);
    if (paramBoolean) {}
    for (int i = this.AVR.setAppCmd(401);; i = this.AVR.setAppCmd(402))
    {
      if (i < 0) {
        d.Logd("MicroMsg.VoipCSEngine", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(205743);
      return i;
    }
  }
  
  public static abstract interface a
  {
    public abstract void cTS();
    
    public abstract void enY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.b.a
 * JD-Core Version:    0.7.0.1
 */