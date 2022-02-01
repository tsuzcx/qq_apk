package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/model/VideoTransOutDataMuxer;", "Lcom/tencent/mm/plugin/multitalk/model/VideoTransOutDataHandler;", "multiTalkSdkApi", "Lcom/tencent/pb/talkroom/sdk/IMultiTalkSdkApi;", "(Lcom/tencent/pb/talkroom/sdk/IMultiTalkSdkApi;)V", "avcCodec", "Lcom/tencent/mm/plugin/multitalk/model/MultiAvcEncoder;", "isForceUseSWEncode", "", "()Z", "setForceUseSWEncode", "(Z)V", "isVideo", "getMultiTalkSdkApi", "()Lcom/tencent/pb/talkroom/sdk/IMultiTalkSdkApi;", "ori", "", "getOri", "()I", "setOri", "(I)V", "tick", "", "getTick", "()J", "setTick", "(J)V", "close", "", "onCameraFrame", "pBuffer", "", "bufferSize", "w", "h", "frameFormat", "mode", "onOrientationChange", "orientation", "onScreenFrame", "switchMode", "Companion", "plugin-multitalk_release"})
public final class ag
  implements af
{
  public static final ag.a zPG;
  private long tick;
  private boolean tkD;
  private final d zMd;
  private k zPD;
  private boolean zPE;
  private int zPF;
  
  static
  {
    AppMethodBeat.i(239711);
    zPG = new ag.a((byte)0);
    AppMethodBeat.o(239711);
  }
  
  public ag(d paramd)
  {
    AppMethodBeat.i(239710);
    this.zMd = paramd;
    this.tkD = true;
    this.tick = System.currentTimeMillis();
    this.zPE = true;
    AppMethodBeat.o(239710);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    Object localObject1 = null;
    boolean bool1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(239707);
        kotlin.g.b.p.h(paramArrayOfByte, "pBuffer");
        Object localObject2 = ac.eom();
        kotlin.g.b.p.g(localObject2, "SubCoreMultiTalk.getMultiTalkManager()");
        if (((q)localObject2).enn() == null) {
          break label566;
        }
        localObject2 = ac.eom();
        kotlin.g.b.p.g(localObject2, "SubCoreMultiTalk.getMultiTalkManager()");
        localObject2 = ((q)localObject2).enn().hjv();
        bool1 = ac.eom().aFW((String)localObject2);
        if (bool1)
        {
          if (this.zPE)
          {
            Log.i("VideoTransOutDataMuxer", "ilink onCameraFrame screen video soft");
            com.tencent.mm.plugin.multitalk.b.p.zHS.g(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + 128);
            label111:
            paramArrayOfByte = ac.eom();
            kotlin.g.b.p.g(paramArrayOfByte, "SubCoreMultiTalk.getMultiTalkManager()");
            if ((paramArrayOfByte.eno()) || (!ac.eom().zMz)) {
              break label440;
            }
            ac.eom().aF(3, true);
            AppMethodBeat.o(239707);
            return;
          }
          localObject2 = this.zPD;
          if (localObject2 != null)
          {
            ((k)localObject2).DoQosSvrCtrl();
            if (((k)localObject2).emD()) {
              localObject1 = localObject2;
            }
            if (localObject1 != null)
            {
              bool1 = bool2;
              if (((k)localObject1).b(paramArrayOfByte, paramInt1, paramInt2, paramInt3) >= 0) {
                bool1 = true;
              }
              Log.i("VideoTransOutDataMuxer", "ilink onCameraFrame screen video hw, success: ".concat(String.valueOf(bool1)));
              if (bool1) {
                break label572;
              }
              k.emC();
              this.zPD = null;
              break label572;
            }
          }
          label241:
          Log.i("VideoTransOutDataMuxer", "ilink onCameraFrame screen video soft");
          com.tencent.mm.plugin.multitalk.b.p.zHS.g(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + 128);
          continue;
        }
        if (!this.zPE) {
          break;
        }
      }
      finally {}
      Log.i("VideoTransOutDataMuxer", "onCameraFrame screen video soft");
      this.zMd.d(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3);
      label307:
      localObject1 = ac.eom();
      kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      if ((!((q)localObject1).eno()) && (ac.eom().zMz)) {
        ac.eom().aF(3, true);
      }
      Log.i("VideoTransOutDataMuxer", "onCameraFrame screen video w: " + paramInt1 + ", h: " + paramInt2);
      paramInt3 = this.zMd.c(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3, 1);
      Log.i("VideoTransOutDataMuxer", "onCameraFrame screen video ret: " + paramInt3 + ", w: " + paramInt1 + ", h: " + paramInt2);
      label440:
      AppMethodBeat.o(239707);
    }
    localObject1 = this.zPD;
    if (localObject1 != null)
    {
      ((k)localObject1).DoQosSvrCtrl();
      if (!((k)localObject1).emD()) {
        break label560;
      }
      label472:
      if (localObject1 != null)
      {
        bool1 = bool3;
        if (((k)localObject1).b(paramArrayOfByte, paramInt1, paramInt2, paramInt3) >= 0) {
          bool1 = true;
        }
        Log.i("VideoTransOutDataMuxer", "onCameraFrame screen video hw, success: ".concat(String.valueOf(bool1)));
        if (bool1) {
          break label581;
        }
        k.emC();
        this.zPD = null;
        break label581;
      }
    }
    for (;;)
    {
      Log.i("VideoTransOutDataMuxer", "onCameraFrame screen video soft");
      this.zMd.d(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3);
      break label307;
      label560:
      localObject1 = null;
      break label472;
      label566:
      bool1 = false;
      break;
      label572:
      if (bool1 == true) {
        break label111;
      }
      break label241;
      label581:
      if (bool1 == true) {
        break label307;
      }
    }
  }
  
  public final int b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(239706);
    kotlin.g.b.p.h(paramArrayOfByte, "pBuffer");
    if (this.tkD)
    {
      Log.i("VideoTransOutDataMuxer", "onCameraFrame sendToVideo: " + this.tkD + ' ' + com.tencent.mm.plugin.appbrand.utils.ag.LB() + " w: " + paramInt1 + ", h: " + paramInt2);
      paramInt1 = this.zMd.c(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(239706);
      return paramInt1;
    }
    a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(239706);
    return 0;
  }
  
  public final void close()
  {
    this.tkD = true;
    this.zPD = null;
  }
  
  public final void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(239709);
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      a locala = a.zYP;
      a.hj(62, paramInt);
      AppMethodBeat.o(239709);
      return;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
      continue;
      paramInt = 4;
      continue;
      paramInt = 5;
    }
  }
  
  public final void rQ(boolean paramBoolean)
  {
    AppMethodBeat.i(239708);
    if ((!paramBoolean) && (this.zPD == null)) {
      this.zPD = new k("video/avc");
    }
    if (paramBoolean) {
      this.zPD = null;
    }
    this.tkD = paramBoolean;
    this.zPF = 1;
    AppMethodBeat.o(239708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.ag
 * JD-Core Version:    0.7.0.1
 */