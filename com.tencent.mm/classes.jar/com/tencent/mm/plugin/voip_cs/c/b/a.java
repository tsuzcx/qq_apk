package com.tencent.mm.plugin.voip_cs.c.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.protocal.protobuf.epd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

public final class a
{
  public com.tencent.mm.plugin.voip_cs.c.a Hsv;
  public a Hsw;
  private MMHandler yqG;
  private boolean yqH;
  boolean yqI;
  
  public a()
  {
    AppMethodBeat.i(125420);
    this.yqH = false;
    this.yqI = false;
    this.Hsw = null;
    this.yqG = new MMHandler(Looper.getMainLooper())
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
          paramAnonymousMessage = c.fMt();
          Log.d("MicroMsg.VoipCSReportHelper", "channelConnect");
          paramAnonymousMessage.Hri = 1;
          paramAnonymousMessage = a.this;
          Log.i("MicroMsg.VoipCSEngine", "channel connect!");
          if (paramAnonymousMessage.yqI)
          {
            Log.i("MicroMsg.VoipCSEngine", "channel already connect! do call not startEngine again");
            AppMethodBeat.o(125419);
            return;
          }
          paramAnonymousMessage.yqI = true;
          Log.i("MicroMsg.VoipCSEngine", "start engine");
          paramAnonymousMessage.Hsv.setInactive();
          Log.d("MicroMsg.VoipCSEngine", "setChannelActiveAfterAccept");
          if (!paramAnonymousMessage.yqI) {
            Log.d("MicroMsg.VoipCSEngine", "channel not connect now");
          }
          paramAnonymousMessage.Hsv.setActive();
          i = paramAnonymousMessage.Hsv.startEngine();
          if (i == 0)
          {
            Log.i("MicroMsg.VoipCSEngine", "start engine suc!");
            localObject1 = new int[2];
            localObject1[0] = c.fMr().Hsv.HbT;
            localObject1[1] = c.fMr().Hsv.HbU;
            Log.i("MicroMsg.VoipCSEngine", "steve: Get server config! MaxBR:" + localObject1[0] + ", MaxFps:" + localObject1[1]);
            if ((localObject1[0] > 0) && (localObject1[1] > 0))
            {
              Object localObject2 = ByteBuffer.allocate(8);
              ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put((int[])localObject1);
              localObject2 = ((ByteBuffer)localObject2).array();
              if (c.fMr().Hsv.setAppCmd(34, (byte[])localObject2, localObject2.length) < 0) {
                Log.i("MicroMsg.VoipCSEngine", "setAppCmd: type:34,qosparam:" + localObject1[0] + "," + localObject1[1] + ",ret:" + i);
              }
            }
          }
          for (c.fMt().Hrg = 1;; c.fMt().Hrg = 0)
          {
            if ((paramAnonymousMessage.Hsw != null) && (c.fMs().HrL != 2))
            {
              paramAnonymousMessage.Hsw.dZP();
              c.fMs().HrL = 2;
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
            c.fMt().Hrf = 1;
          }
          for (;;)
          {
            paramAnonymousMessage = a.this;
            Log.i("MicroMsg.VoipCSEngine", "channel connect failed!");
            c.fMt().dataType = 1;
            if (paramAnonymousMessage.Hsw != null) {
              paramAnonymousMessage.Hsw.fMN();
            }
            AppMethodBeat.o(125419);
            return;
            if (paramAnonymousMessage.arg2 == 5)
            {
              Log.i("MicroMsg.VoipCSEngine", "channel event network failer...");
              c.fMt().Hrf = 6;
            }
            else
            {
              Log.i("MicroMsg.VoipCSEngine", "channel connect fail...");
              c.fMt().Hrf = 5;
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
          com.tencent.mm.plugin.voip.b.e.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.VoipCSEngine", paramAnonymousMessage.arg2);
          AppMethodBeat.o(125419);
          return;
        case 101: 
          com.tencent.mm.plugin.voip.b.e.outputJniLog((byte[])paramAnonymousMessage.obj, "MicroMsg.VoipCSEngine-JNI_CORE", paramAnonymousMessage.arg2);
          AppMethodBeat.o(125419);
          return;
        }
        Object localObject1 = (byte[])paramAnonymousMessage.obj;
        paramAnonymousMessage = a.this;
        for (;;)
        {
          try
          {
            localObject1 = (epd)new epd().parseFrom((byte[])localObject1);
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.VoipCSEngine", "steve: onRecvRUDPCmd:" + ((epd)localObject1).NmY);
            i = ((epd)localObject1).NmY;
            switch (i)
            {
            default: 
              AppMethodBeat.o(125419);
              return;
            }
            if (((epd)localObject1).NmZ == null) {
              break label913;
            }
            localObject1 = ((epd)localObject1).NmZ.zy;
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.VoipCSEngine", "steve: remote new network type:".concat(String.valueOf(localObject1)));
            i = paramAnonymousMessage.Hsv.setAppCmd(302, (byte[])localObject1, 4);
            if (i < 0) {
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + localObject1 + "fail:" + i + ", [roomid=" + paramAnonymousMessage.Hsv.Haw + ", roomkey=" + paramAnonymousMessage.Hsv.ypH + "]");
            }
            AppMethodBeat.o(125419);
            return;
          }
          catch (Exception paramAnonymousMessage)
          {
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
          }
          break;
          label913:
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
        }
      }
    };
    this.Hsv = new com.tencent.mm.plugin.voip_cs.c.a(this.yqG);
    AppMethodBeat.o(125420);
  }
  
  public final com.tencent.mm.plugin.voip_cs.c.a fMM()
  {
    return this.Hsv;
  }
  
  public final void init()
  {
    AppMethodBeat.i(125421);
    this.yqI = false;
    this.yqH = false;
    if (this.Hsv.fIZ())
    {
      Log.d("MicroMsg.VoipCSEngine", "protocal has init,now uninit!");
      this.Hsv.xh(false);
      this.Hsv.reset();
    }
    this.Hsv.Hav = 1;
    long l = System.currentTimeMillis();
    int i = this.Hsv.fMp();
    Log.d("MicroMsg.VoipCSEngine", "protocal init finish, ret: %d, used %dms", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
    if (i < 0) {
      Log.e("MicroMsg.VoipCSEngine", "engine init failed!");
    }
    AppMethodBeat.o(125421);
  }
  
  public final int xe(boolean paramBoolean)
  {
    AppMethodBeat.i(199029);
    if (paramBoolean) {}
    for (int i = this.Hsv.setAppCmd(401);; i = this.Hsv.setAppCmd(402))
    {
      if (i < 0) {
        com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.VoipCSEngine", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(199029);
      return i;
    }
  }
  
  public static abstract interface a
  {
    public abstract void dZP();
    
    public abstract void fMN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.b.a
 * JD-Core Version:    0.7.0.1
 */