package com.tencent.mm.plugin.voip_cs.c.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.voip_cs.c.e;
import com.tencent.mm.protocal.protobuf.diz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

public final class a
{
  private ap sBY;
  private boolean sBZ;
  boolean sCa;
  public com.tencent.mm.plugin.voip_cs.c.a zDE;
  public a zDF;
  
  public a()
  {
    AppMethodBeat.i(125420);
    this.sBZ = false;
    this.sCa = false;
    this.zDF = null;
    this.sBY = new ap(Looper.getMainLooper())
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
        ad.d("MicroMsg.VoipCSEngine", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[] { Integer.valueOf(paramAnonymousMessage.what), paramAnonymousMessage.obj, Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2) });
        int i;
        switch (paramAnonymousMessage.arg1)
        {
        default: 
          AppMethodBeat.o(125419);
          return;
        case 6: 
          ad.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_CHANNEL_CONNECTED");
          paramAnonymousMessage = com.tencent.mm.plugin.voip_cs.c.c.dYi();
          ad.d("MicroMsg.VoipCSReportHelper", "channelConnect");
          paramAnonymousMessage.zCs = 1;
          paramAnonymousMessage = a.this;
          ad.i("MicroMsg.VoipCSEngine", "channel connect!");
          if (paramAnonymousMessage.sCa)
          {
            ad.i("MicroMsg.VoipCSEngine", "channel already connect! do call not startEngine again");
            AppMethodBeat.o(125419);
            return;
          }
          paramAnonymousMessage.sCa = true;
          ad.i("MicroMsg.VoipCSEngine", "start engine");
          paramAnonymousMessage.zDE.setInactive();
          ad.d("MicroMsg.VoipCSEngine", "setChannelActiveAfterAccept");
          if (!paramAnonymousMessage.sCa) {
            ad.d("MicroMsg.VoipCSEngine", "channel not connect now");
          }
          paramAnonymousMessage.zDE.setActive();
          i = paramAnonymousMessage.zDE.startEngine();
          if (i == 0)
          {
            ad.i("MicroMsg.VoipCSEngine", "start engine suc!");
            localObject1 = new int[2];
            localObject1[0] = com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.zoO;
            localObject1[1] = com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.zoP;
            ad.i("MicroMsg.VoipCSEngine", "steve: Get server config! MaxBR:" + localObject1[0] + ", MaxFps:" + localObject1[1]);
            if ((localObject1[0] > 0) && (localObject1[1] > 0))
            {
              Object localObject2 = ByteBuffer.allocate(8);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put((int[])localObject1);
              localObject2 = ((ByteBuffer)localObject2).array();
              if (com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.setAppCmd(34, (byte[])localObject2, localObject2.length) < 0) {
                ad.i("MicroMsg.VoipCSEngine", "setAppCmd: type:34,qosparam:" + localObject1[0] + "," + localObject1[1] + ",ret:" + i);
              }
            }
          }
          for (com.tencent.mm.plugin.voip_cs.c.c.dYi().zCq = 1;; com.tencent.mm.plugin.voip_cs.c.c.dYi().zCq = 0)
          {
            if ((paramAnonymousMessage.zDF != null) && (com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV != 2))
            {
              paramAnonymousMessage.zDF.cGI();
              com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV = 2;
            }
            AppMethodBeat.o(125419);
            return;
            ad.i("MicroMsg.VoipCSEngine", "start engine fail!");
          }
        case 5: 
          ad.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_RESET");
          if (paramAnonymousMessage.arg2 == 4)
          {
            ad.i("MicroMsg.VoipCSEngine", "channel broken...");
            com.tencent.mm.plugin.voip_cs.c.c.dYi().zCp = 1;
          }
          for (;;)
          {
            paramAnonymousMessage = a.this;
            ad.i("MicroMsg.VoipCSEngine", "channel connect failed!");
            com.tencent.mm.plugin.voip_cs.c.c.dYi().dataType = 1;
            if (paramAnonymousMessage.zDF != null) {
              paramAnonymousMessage.zDF.dYC();
            }
            AppMethodBeat.o(125419);
            return;
            if (paramAnonymousMessage.arg2 == 5)
            {
              ad.i("MicroMsg.VoipCSEngine", "channel event network failer...");
              com.tencent.mm.plugin.voip_cs.c.c.dYi().zCp = 6;
            }
            else
            {
              ad.i("MicroMsg.VoipCSEngine", "channel connect fail...");
              com.tencent.mm.plugin.voip_cs.c.c.dYi().zCp = 5;
            }
          }
        case 3: 
          ad.d("MicroMsg.VoipCSEngine", "start dev!");
          AppMethodBeat.o(125419);
          return;
        case 1: 
          AppMethodBeat.o(125419);
          return;
        case 4: 
          AppMethodBeat.o(125419);
          return;
        case 100: 
          com.tencent.mm.plugin.voip.b.c.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.VoipCSEngine", paramAnonymousMessage.arg2);
          AppMethodBeat.o(125419);
          return;
        case 101: 
          com.tencent.mm.plugin.voip.b.c.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.VoipCSEngine-JNI_CORE", paramAnonymousMessage.arg2);
          AppMethodBeat.o(125419);
          return;
        }
        Object localObject1 = (byte[])paramAnonymousMessage.obj;
        paramAnonymousMessage = a.this;
        for (;;)
        {
          try
          {
            localObject1 = (diz)new diz().parseFrom((byte[])localObject1);
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.VoipCSEngine", "steve: onRecvRUDPCmd:" + ((diz)localObject1).Ezh);
            i = ((diz)localObject1).Ezh;
            switch (i)
            {
            default: 
              AppMethodBeat.o(125419);
              return;
            }
            if (((diz)localObject1).Ezi == null) {
              break label913;
            }
            localObject1 = ((diz)localObject1).Ezi.wA;
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.VoipCSEngine", "steve: remote new network type:".concat(String.valueOf(localObject1)));
            i = paramAnonymousMessage.zDE.setAppCmd(302, (byte[])localObject1, 4);
            if (i < 0) {
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + localObject1 + "fail:" + i + ", [roomid=" + paramAnonymousMessage.zDE.zns + ", roomkey=" + paramAnonymousMessage.zDE.sAY + "]");
            }
            AppMethodBeat.o(125419);
            return;
          }
          catch (Exception paramAnonymousMessage)
          {
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
          }
          break;
          label913:
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
        }
      }
    };
    this.zDE = new com.tencent.mm.plugin.voip_cs.c.a(this.sBY);
    AppMethodBeat.o(125420);
  }
  
  public final com.tencent.mm.plugin.voip_cs.c.a dYB()
  {
    return this.zDE;
  }
  
  public final void init()
  {
    AppMethodBeat.i(125421);
    this.sCa = false;
    this.sBZ = false;
    if (this.zDE.dVA())
    {
      ad.d("MicroMsg.VoipCSEngine", "protocal has init,now uninit!");
      this.zDE.rG(false);
      this.zDE.reset();
    }
    this.zDE.znr = 1;
    long l = System.currentTimeMillis();
    int i = this.zDE.dYe();
    ad.d("MicroMsg.VoipCSEngine", "protocal init finish, ret: %d, used %dms", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
    if (i < 0) {
      ad.e("MicroMsg.VoipCSEngine", "engine init failed!");
    }
    AppMethodBeat.o(125421);
  }
  
  public final int rD(boolean paramBoolean)
  {
    AppMethodBeat.i(190832);
    if (paramBoolean) {}
    for (int i = this.zDE.setAppCmd(401);; i = this.zDE.setAppCmd(402))
    {
      if (i < 0) {
        com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.VoipCSEngine", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(190832);
      return i;
    }
  }
  
  public static abstract interface a
  {
    public abstract void cGI();
    
    public abstract void dYC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.b.a
 * JD-Core Version:    0.7.0.1
 */