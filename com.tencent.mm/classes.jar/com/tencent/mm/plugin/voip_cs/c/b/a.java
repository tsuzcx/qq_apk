package com.tencent.mm.plugin.voip_cs.c.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.plugin.voip_cs.c.e;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

public final class a
{
  public com.tencent.mm.plugin.voip_cs.c.a CNE;
  public a CNF;
  private aq uYg;
  private boolean uYh;
  boolean uYi;
  
  public a()
  {
    AppMethodBeat.i(125420);
    this.uYh = false;
    this.uYi = false;
    this.CNF = null;
    this.uYg = new aq(Looper.getMainLooper())
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
        ae.d("MicroMsg.VoipCSEngine", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[] { Integer.valueOf(paramAnonymousMessage.what), paramAnonymousMessage.obj, Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2) });
        int i;
        switch (paramAnonymousMessage.arg1)
        {
        default: 
          AppMethodBeat.o(125419);
          return;
        case 6: 
          ae.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_CHANNEL_CONNECTED");
          paramAnonymousMessage = c.eFl();
          ae.d("MicroMsg.VoipCSReportHelper", "channelConnect");
          paramAnonymousMessage.CMs = 1;
          paramAnonymousMessage = a.this;
          ae.i("MicroMsg.VoipCSEngine", "channel connect!");
          if (paramAnonymousMessage.uYi)
          {
            ae.i("MicroMsg.VoipCSEngine", "channel already connect! do call not startEngine again");
            AppMethodBeat.o(125419);
            return;
          }
          paramAnonymousMessage.uYi = true;
          ae.i("MicroMsg.VoipCSEngine", "start engine");
          paramAnonymousMessage.CNE.setInactive();
          ae.d("MicroMsg.VoipCSEngine", "setChannelActiveAfterAccept");
          if (!paramAnonymousMessage.uYi) {
            ae.d("MicroMsg.VoipCSEngine", "channel not connect now");
          }
          paramAnonymousMessage.CNE.setActive();
          i = paramAnonymousMessage.CNE.startEngine();
          if (i == 0)
          {
            ae.i("MicroMsg.VoipCSEngine", "start engine suc!");
            localObject1 = new int[2];
            localObject1[0] = c.eFj().CNE.Cyf;
            localObject1[1] = c.eFj().CNE.Cyg;
            ae.i("MicroMsg.VoipCSEngine", "steve: Get server config! MaxBR:" + localObject1[0] + ", MaxFps:" + localObject1[1]);
            if ((localObject1[0] > 0) && (localObject1[1] > 0))
            {
              Object localObject2 = ByteBuffer.allocate(8);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put((int[])localObject1);
              localObject2 = ((ByteBuffer)localObject2).array();
              if (c.eFj().CNE.setAppCmd(34, (byte[])localObject2, localObject2.length) < 0) {
                ae.i("MicroMsg.VoipCSEngine", "setAppCmd: type:34,qosparam:" + localObject1[0] + "," + localObject1[1] + ",ret:" + i);
              }
            }
          }
          for (c.eFl().CMq = 1;; c.eFl().CMq = 0)
          {
            if ((paramAnonymousMessage.CNF != null) && (c.eFk().CMV != 2))
            {
              paramAnonymousMessage.CNF.dfV();
              c.eFk().CMV = 2;
            }
            AppMethodBeat.o(125419);
            return;
            ae.i("MicroMsg.VoipCSEngine", "start engine fail!");
          }
        case 5: 
          ae.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_RESET");
          if (paramAnonymousMessage.arg2 == 4)
          {
            ae.i("MicroMsg.VoipCSEngine", "channel broken...");
            c.eFl().CMp = 1;
          }
          for (;;)
          {
            paramAnonymousMessage = a.this;
            ae.i("MicroMsg.VoipCSEngine", "channel connect failed!");
            c.eFl().dataType = 1;
            if (paramAnonymousMessage.CNF != null) {
              paramAnonymousMessage.CNF.eFF();
            }
            AppMethodBeat.o(125419);
            return;
            if (paramAnonymousMessage.arg2 == 5)
            {
              ae.i("MicroMsg.VoipCSEngine", "channel event network failer...");
              c.eFl().CMp = 6;
            }
            else
            {
              ae.i("MicroMsg.VoipCSEngine", "channel connect fail...");
              c.eFl().CMp = 5;
            }
          }
        case 3: 
          ae.d("MicroMsg.VoipCSEngine", "start dev!");
          AppMethodBeat.o(125419);
          return;
        case 1: 
          AppMethodBeat.o(125419);
          return;
        case 4: 
          AppMethodBeat.o(125419);
          return;
        case 100: 
          f.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.VoipCSEngine", paramAnonymousMessage.arg2);
          AppMethodBeat.o(125419);
          return;
        case 101: 
          f.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.VoipCSEngine-JNI_CORE", paramAnonymousMessage.arg2);
          AppMethodBeat.o(125419);
          return;
        }
        Object localObject1 = (byte[])paramAnonymousMessage.obj;
        paramAnonymousMessage = a.this;
        for (;;)
        {
          try
          {
            localObject1 = (dvc)new dvc().parseFrom((byte[])localObject1);
            f.Logi("MicroMsg.VoipCSEngine", "steve: onRecvRUDPCmd:" + ((dvc)localObject1).IaM);
            i = ((dvc)localObject1).IaM;
            switch (i)
            {
            default: 
              AppMethodBeat.o(125419);
              return;
            }
            if (((dvc)localObject1).IaN == null) {
              break label913;
            }
            localObject1 = ((dvc)localObject1).IaN.zr;
            f.Logi("MicroMsg.VoipCSEngine", "steve: remote new network type:".concat(String.valueOf(localObject1)));
            i = paramAnonymousMessage.CNE.setAppCmd(302, (byte[])localObject1, 4);
            if (i < 0) {
              f.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + localObject1 + "fail:" + i + ", [roomid=" + paramAnonymousMessage.CNE.CwH + ", roomkey=" + paramAnonymousMessage.CNE.uXg + "]");
            }
            AppMethodBeat.o(125419);
            return;
          }
          catch (Exception paramAnonymousMessage)
          {
            f.Logi("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
          }
          break;
          label913:
          f.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
        }
      }
    };
    this.CNE = new com.tencent.mm.plugin.voip_cs.c.a(this.uYg);
    AppMethodBeat.o(125420);
  }
  
  public final com.tencent.mm.plugin.voip_cs.c.a eFE()
  {
    return this.CNE;
  }
  
  public final void init()
  {
    AppMethodBeat.i(125421);
    this.uYi = false;
    this.uYh = false;
    if (this.CNE.eCf())
    {
      ae.d("MicroMsg.VoipCSEngine", "protocal has init,now uninit!");
      this.CNE.tx(false);
      this.CNE.reset();
    }
    this.CNE.CwG = 1;
    long l = System.currentTimeMillis();
    int i = this.CNE.eFh();
    ae.d("MicroMsg.VoipCSEngine", "protocal init finish, ret: %d, used %dms", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
    if (i < 0) {
      ae.e("MicroMsg.VoipCSEngine", "engine init failed!");
    }
    AppMethodBeat.o(125421);
  }
  
  public final int tu(boolean paramBoolean)
  {
    AppMethodBeat.i(193486);
    if (paramBoolean) {}
    for (int i = this.CNE.setAppCmd(401);; i = this.CNE.setAppCmd(402))
    {
      if (i < 0) {
        f.Logd("MicroMsg.VoipCSEngine", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(193486);
      return i;
    }
  }
  
  public static abstract interface a
  {
    public abstract void dfV();
    
    public abstract void eFF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.b.a
 * JD-Core Version:    0.7.0.1
 */