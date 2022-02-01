package com.tencent.mm.plugin.voip_cs.c.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.plugin.voip_cs.c.e;
import com.tencent.mm.protocal.protobuf.duf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

public final class a
{
  public com.tencent.mm.plugin.voip_cs.c.a CvZ;
  public a Cwa;
  private ap uMt;
  private boolean uMu;
  boolean uMv;
  
  public a()
  {
    AppMethodBeat.i(125420);
    this.uMu = false;
    this.uMv = false;
    this.Cwa = null;
    this.uMt = new ap(Looper.getMainLooper())
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
          paramAnonymousMessage = c.eBD();
          ad.d("MicroMsg.VoipCSReportHelper", "channelConnect");
          paramAnonymousMessage.CuN = 1;
          paramAnonymousMessage = a.this;
          ad.i("MicroMsg.VoipCSEngine", "channel connect!");
          if (paramAnonymousMessage.uMv)
          {
            ad.i("MicroMsg.VoipCSEngine", "channel already connect! do call not startEngine again");
            AppMethodBeat.o(125419);
            return;
          }
          paramAnonymousMessage.uMv = true;
          ad.i("MicroMsg.VoipCSEngine", "start engine");
          paramAnonymousMessage.CvZ.setInactive();
          ad.d("MicroMsg.VoipCSEngine", "setChannelActiveAfterAccept");
          if (!paramAnonymousMessage.uMv) {
            ad.d("MicroMsg.VoipCSEngine", "channel not connect now");
          }
          paramAnonymousMessage.CvZ.setActive();
          i = paramAnonymousMessage.CvZ.startEngine();
          if (i == 0)
          {
            ad.i("MicroMsg.VoipCSEngine", "start engine suc!");
            localObject1 = new int[2];
            localObject1[0] = c.eBB().CvZ.CgE;
            localObject1[1] = c.eBB().CvZ.CgF;
            ad.i("MicroMsg.VoipCSEngine", "steve: Get server config! MaxBR:" + localObject1[0] + ", MaxFps:" + localObject1[1]);
            if ((localObject1[0] > 0) && (localObject1[1] > 0))
            {
              Object localObject2 = ByteBuffer.allocate(8);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put((int[])localObject1);
              localObject2 = ((ByteBuffer)localObject2).array();
              if (c.eBB().CvZ.setAppCmd(34, (byte[])localObject2, localObject2.length) < 0) {
                ad.i("MicroMsg.VoipCSEngine", "setAppCmd: type:34,qosparam:" + localObject1[0] + "," + localObject1[1] + ",ret:" + i);
              }
            }
          }
          for (c.eBD().CuL = 1;; c.eBD().CuL = 0)
          {
            if ((paramAnonymousMessage.Cwa != null) && (c.eBC().Cvq != 2))
            {
              paramAnonymousMessage.Cwa.ddd();
              c.eBC().Cvq = 2;
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
            c.eBD().CuK = 1;
          }
          for (;;)
          {
            paramAnonymousMessage = a.this;
            ad.i("MicroMsg.VoipCSEngine", "channel connect failed!");
            c.eBD().dataType = 1;
            if (paramAnonymousMessage.Cwa != null) {
              paramAnonymousMessage.Cwa.eBX();
            }
            AppMethodBeat.o(125419);
            return;
            if (paramAnonymousMessage.arg2 == 5)
            {
              ad.i("MicroMsg.VoipCSEngine", "channel event network failer...");
              c.eBD().CuK = 6;
            }
            else
            {
              ad.i("MicroMsg.VoipCSEngine", "channel connect fail...");
              c.eBD().CuK = 5;
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
            localObject1 = (duf)new duf().parseFrom((byte[])localObject1);
            f.Logi("MicroMsg.VoipCSEngine", "steve: onRecvRUDPCmd:" + ((duf)localObject1).HGZ);
            i = ((duf)localObject1).HGZ;
            switch (i)
            {
            default: 
              AppMethodBeat.o(125419);
              return;
            }
            if (((duf)localObject1).HHa == null) {
              break label913;
            }
            localObject1 = ((duf)localObject1).HHa.zr;
            f.Logi("MicroMsg.VoipCSEngine", "steve: remote new network type:".concat(String.valueOf(localObject1)));
            i = paramAnonymousMessage.CvZ.setAppCmd(302, (byte[])localObject1, 4);
            if (i < 0) {
              f.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + localObject1 + "fail:" + i + ", [roomid=" + paramAnonymousMessage.CvZ.Cfg + ", roomkey=" + paramAnonymousMessage.CvZ.uLt + "]");
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
    this.CvZ = new com.tencent.mm.plugin.voip_cs.c.a(this.uMt);
    AppMethodBeat.o(125420);
  }
  
  public final com.tencent.mm.plugin.voip_cs.c.a eBW()
  {
    return this.CvZ;
  }
  
  public final void init()
  {
    AppMethodBeat.i(125421);
    this.uMv = false;
    this.uMu = false;
    if (this.CvZ.eyx())
    {
      ad.d("MicroMsg.VoipCSEngine", "protocal has init,now uninit!");
      this.CvZ.tq(false);
      this.CvZ.reset();
    }
    this.CvZ.Cff = 1;
    long l = System.currentTimeMillis();
    int i = this.CvZ.eBz();
    ad.d("MicroMsg.VoipCSEngine", "protocal init finish, ret: %d, used %dms", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
    if (i < 0) {
      ad.e("MicroMsg.VoipCSEngine", "engine init failed!");
    }
    AppMethodBeat.o(125421);
  }
  
  public final int tn(boolean paramBoolean)
  {
    AppMethodBeat.i(192875);
    if (paramBoolean) {}
    for (int i = this.CvZ.setAppCmd(401);; i = this.CvZ.setAppCmd(402))
    {
      if (i < 0) {
        f.Logd("MicroMsg.VoipCSEngine", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(192875);
      return i;
    }
  }
  
  public static abstract interface a
  {
    public abstract void ddd();
    
    public abstract void eBX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.b.a
 * JD-Core Version:    0.7.0.1
 */