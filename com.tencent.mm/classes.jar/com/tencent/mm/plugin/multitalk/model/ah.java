package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.plugin.multitalk.b.o;
import com.tencent.mm.plugin.multitalk.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/model/VideoTransOutDataMuxer;", "Lcom/tencent/mm/plugin/multitalk/model/VideoTransOutDataHandler;", "multiTalkSdkApi", "Lcom/tencent/pb/talkroom/sdk/IMultiTalkSdkApi;", "(Lcom/tencent/pb/talkroom/sdk/IMultiTalkSdkApi;)V", "avcCodec", "Lcom/tencent/mm/plugin/multitalk/model/MultiAvcEncoder;", "isForceUseSWEncode", "", "()Z", "setForceUseSWEncode", "(Z)V", "isVideo", "getMultiTalkSdkApi", "()Lcom/tencent/pb/talkroom/sdk/IMultiTalkSdkApi;", "ori", "", "getOri", "()I", "setOri", "(I)V", "tick", "", "getTick", "()J", "setTick", "(J)V", "close", "", "onCameraFrame", "pBuffer", "", "bufferSize", "w", "h", "frameFormat", "mode", "onOrientationChange", "orientation", "onScreenFrame", "switchMode", "Companion", "plugin-multitalk_release"})
public final class ah
  implements ag
{
  public static final ah.a Fvf;
  private final d Frw;
  private k Fvc;
  private boolean Fvd;
  private int Fve;
  private long tick;
  private boolean wRb;
  
  static
  {
    AppMethodBeat.i(200660);
    Fvf = new ah.a((byte)0);
    AppMethodBeat.o(200660);
  }
  
  public ah(d paramd)
  {
    AppMethodBeat.i(200659);
    this.Frw = paramd;
    this.wRb = true;
    this.tick = System.currentTimeMillis();
    this.Fvd = true;
    AppMethodBeat.o(200659);
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
        AppMethodBeat.i(200647);
        p.k(paramArrayOfByte, "pBuffer");
        Object localObject2 = ad.eYc();
        p.j(localObject2, "SubCoreMultiTalk.getMultiTalkManager()");
        if (((q)localObject2).eXb() == null) {
          break label566;
        }
        localObject2 = ad.eYc();
        p.j(localObject2, "SubCoreMultiTalk.getMultiTalkManager()");
        localObject2 = ((q)localObject2).eXb().ilf();
        bool1 = ad.eYc().aQj((String)localObject2);
        if (bool1)
        {
          if (this.Fvd)
          {
            Log.i("VideoTransOutDataMuxer", "ilink onCameraFrame screen video soft");
            o.Fne.g(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + 128);
            label111:
            paramArrayOfByte = ad.eYc();
            p.j(paramArrayOfByte, "SubCoreMultiTalk.getMultiTalkManager()");
            if ((paramArrayOfByte.eXc()) || (!ad.eYc().FrS)) {
              break label440;
            }
            ad.eYc().aK(3, true);
            AppMethodBeat.o(200647);
            return;
          }
          localObject2 = this.Fvc;
          if (localObject2 != null)
          {
            ((k)localObject2).DoQosSvrCtrl();
            if (((k)localObject2).eWr()) {
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
              k.eWq();
              this.Fvc = null;
              break label572;
            }
          }
          label241:
          Log.i("VideoTransOutDataMuxer", "ilink onCameraFrame screen video soft");
          o.Fne.g(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + 128);
          continue;
        }
        if (!this.Fvd) {
          break;
        }
      }
      finally {}
      Log.i("VideoTransOutDataMuxer", "onCameraFrame screen video soft");
      this.Frw.d(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3);
      label307:
      localObject1 = ad.eYc();
      p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      if ((!((q)localObject1).eXc()) && (ad.eYc().FrS)) {
        ad.eYc().aK(3, true);
      }
      Log.i("VideoTransOutDataMuxer", "onCameraFrame screen video w: " + paramInt1 + ", h: " + paramInt2);
      paramInt3 = this.Frw.c(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3, 1);
      Log.i("VideoTransOutDataMuxer", "onCameraFrame screen video ret: " + paramInt3 + ", w: " + paramInt1 + ", h: " + paramInt2);
      label440:
      AppMethodBeat.o(200647);
    }
    localObject1 = this.Fvc;
    if (localObject1 != null)
    {
      ((k)localObject1).DoQosSvrCtrl();
      if (!((k)localObject1).eWr()) {
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
        k.eWq();
        this.Fvc = null;
        break label581;
      }
    }
    for (;;)
    {
      Log.i("VideoTransOutDataMuxer", "onCameraFrame screen video soft");
      this.Frw.d(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3);
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
    AppMethodBeat.i(200644);
    p.k(paramArrayOfByte, "pBuffer");
    if (this.wRb)
    {
      Log.i("VideoTransOutDataMuxer", "onCameraFrame sendToVideo: " + this.wRb + ' ' + ai.Or() + " w: " + paramInt1 + ", h: " + paramInt2);
      paramInt1 = this.Frw.c(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(200644);
      return paramInt1;
    }
    a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(200644);
    return 0;
  }
  
  public final void close()
  {
    this.wRb = true;
    this.Fvc = null;
  }
  
  public final void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(200654);
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      a locala = a.FEC;
      a.io(62, paramInt);
      AppMethodBeat.o(200654);
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
  
  public final void uT(boolean paramBoolean)
  {
    AppMethodBeat.i(200649);
    if ((!paramBoolean) && (this.Fvc == null)) {
      this.Fvc = new k("video/avc");
    }
    if (paramBoolean) {
      this.Fvc = null;
    }
    this.wRb = paramBoolean;
    this.Fve = 1;
    AppMethodBeat.o(200649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.ah
 * JD-Core Version:    0.7.0.1
 */