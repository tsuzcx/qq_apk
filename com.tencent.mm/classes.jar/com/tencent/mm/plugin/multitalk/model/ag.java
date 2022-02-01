package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ao;
import com.tencent.mm.plugin.multitalk.c.o;
import com.tencent.mm.plugin.multitalk.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/model/VideoTransOutDataMuxer;", "Lcom/tencent/mm/plugin/multitalk/model/VideoTransOutDataHandler;", "multiTalkSdkApi", "Lcom/tencent/pb/talkroom/sdk/IMultiTalkSdkApi;", "(Lcom/tencent/pb/talkroom/sdk/IMultiTalkSdkApi;)V", "avcCodec", "Lcom/tencent/mm/plugin/multitalk/model/MultiAvcEncoder;", "isForceUseSWEncode", "", "()Z", "setForceUseSWEncode", "(Z)V", "isVideo", "getMultiTalkSdkApi", "()Lcom/tencent/pb/talkroom/sdk/IMultiTalkSdkApi;", "ori", "", "getOri", "()I", "setOri", "(I)V", "tick", "", "getTick", "()J", "setTick", "(J)V", "close", "", "onCameraFrame", "pBuffer", "", "bufferSize", "w", "h", "frameFormat", "mode", "onOrientationChange", "orientation", "onScreenFrame", "switchMode", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  implements af
{
  public static final ag.a Lrl;
  private boolean AnF;
  private final d LnJ;
  private k Lrm;
  private boolean Lrn;
  private int Lro;
  private long tick;
  
  static
  {
    AppMethodBeat.i(284827);
    Lrl = new ag.a((byte)0);
    AppMethodBeat.o(284827);
  }
  
  public ag(d paramd)
  {
    AppMethodBeat.i(284823);
    this.LnJ = paramd;
    this.AnF = true;
    this.tick = System.currentTimeMillis();
    this.Lrn = true;
    AppMethodBeat.o(284823);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = null;
    int j = 1;
    int i = 1;
    boolean bool;
    for (;;)
    {
      label210:
      try
      {
        AppMethodBeat.i(284846);
        s.u(paramArrayOfByte, "pBuffer");
        if (ac.ggS().Lol == null) {
          break label557;
        }
        Object localObject2 = ac.ggS().Lol.LiU;
        bool = ac.ggS().aNe((String)localObject2);
        if (!bool) {
          break;
        }
        if (this.Lrn)
        {
          Log.i("VideoTransOutDataMuxer", "ilink onCameraFrame screen video soft");
          o.Ljn.i(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + 128);
          if ((u.abK(ac.ggS().Lod)) || (!ac.ggS().Lof)) {
            break label418;
          }
          ac.ggS().bl(3, true);
          AppMethodBeat.o(284846);
          label124:
          return;
        }
        localObject2 = this.Lrm;
        if (localObject2 == null) {
          break label254;
        }
        ((k)localObject2).DoQosSvrCtrl();
        if (((k)localObject2).gfi()) {
          localObject1 = localObject2;
        }
        if (localObject1 == null) {
          break label254;
        }
        if (((k)localObject1).d(paramArrayOfByte, paramInt1, paramInt2, paramInt3) < 0) {
          break label248;
        }
        bool = true;
        Log.i("VideoTransOutDataMuxer", s.X("ilink onCameraFrame screen video hw, success: ", Boolean.valueOf(bool)));
        if (bool) {
          break label563;
        }
        k.gfh();
        this.Lrm = null;
      }
      finally {}
      if (i == 0)
      {
        Log.i("VideoTransOutDataMuxer", "ilink onCameraFrame screen video soft");
        o.Ljn.i(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + 128);
        continue;
        label248:
        bool = false;
        continue;
        label254:
        i = 0;
      }
    }
    if (this.Lrn)
    {
      Log.i("VideoTransOutDataMuxer", "onCameraFrame screen video soft");
      this.LnJ.c(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3);
    }
    label293:
    label450:
    label583:
    for (;;)
    {
      if ((!u.abK(ac.ggS().Lod)) && (ac.ggS().Lof)) {
        ac.ggS().bl(3, true);
      }
      Log.i("VideoTransOutDataMuxer", "onCameraFrame screen video w: " + paramInt1 + ", h: " + paramInt2);
      paramInt3 = this.LnJ.c(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3, 1);
      Log.i("VideoTransOutDataMuxer", "onCameraFrame screen video ret: " + paramInt3 + ", w: " + paramInt1 + ", h: " + paramInt2);
      AppMethodBeat.o(284846);
      break label124;
      localObject1 = this.Lrm;
      if (localObject1 != null)
      {
        ((k)localObject1).DoQosSvrCtrl();
        if (((k)localObject1).gfi())
        {
          if (localObject1 == null) {
            break label551;
          }
          if (((k)localObject1).d(paramArrayOfByte, paramInt1, paramInt2, paramInt3) < 0) {
            break label545;
          }
          bool = true;
          label473:
          Log.i("VideoTransOutDataMuxer", s.X("onCameraFrame screen video hw, success: ", Boolean.valueOf(bool)));
          if (bool) {
            break label572;
          }
          k.gfh();
          this.Lrm = null;
          break label572;
        }
      }
      for (;;)
      {
        label505:
        if (i != 0) {
          break label583;
        }
        Log.i("VideoTransOutDataMuxer", "onCameraFrame screen video soft");
        this.LnJ.c(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3);
        break label293;
        localObject1 = null;
        break label450;
        bool = false;
        break label473;
        do
        {
          i = 0;
          break label505;
          bool = false;
          break;
          if (bool != true) {
            break label254;
          }
          break label210;
        } while (bool != true);
        i = j;
      }
    }
  }
  
  public final int b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(284835);
    s.u(paramArrayOfByte, "pBuffer");
    if (this.AnF)
    {
      Log.i("VideoTransOutDataMuxer", "onCameraFrame sendToVideo: " + this.AnF + ' ' + ao.aoz() + " w: " + paramInt1 + ", h: " + paramInt2);
      paramInt1 = this.LnJ.c(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(284835);
      return paramInt1;
    }
    a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(284835);
    return 0;
  }
  
  public final void close()
  {
    this.AnF = true;
    this.Lrm = null;
  }
  
  public final void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(284862);
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      a locala = a.LAn;
      a.jS(62, paramInt);
      AppMethodBeat.o(284862);
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
  
  public final void zh(boolean paramBoolean)
  {
    AppMethodBeat.i(284854);
    if ((!paramBoolean) && (this.Lrm == null)) {
      this.Lrm = new k("video/avc");
    }
    if (paramBoolean) {
      this.Lrm = null;
    }
    this.AnF = paramBoolean;
    this.Lro = 1;
    AppMethodBeat.o(284854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.ag
 * JD-Core Version:    0.7.0.1
 */