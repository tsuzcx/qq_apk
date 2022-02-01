package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.plugin.multitalk.d.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.d;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/model/VideoTransOutDataMuxer;", "Lcom/tencent/mm/plugin/multitalk/model/VideoTransOutDataHandler;", "multiTalkSdkApi", "Lcom/tencent/pb/talkroom/sdk/IMultiTalkSdkApi;", "(Lcom/tencent/pb/talkroom/sdk/IMultiTalkSdkApi;)V", "avcCodec", "Lcom/tencent/mm/plugin/multitalk/model/MultiAvcEncoder;", "isForceUseSWEncode", "", "()Z", "setForceUseSWEncode", "(Z)V", "isVideo", "getMultiTalkSdkApi", "()Lcom/tencent/pb/talkroom/sdk/IMultiTalkSdkApi;", "ori", "", "getOri", "()I", "setOri", "(I)V", "tick", "", "getTick", "()J", "setTick", "(J)V", "close", "", "onCameraFrame", "pBuffer", "", "bufferSize", "w", "h", "frameFormat", "mode", "onScreenFrame", "switchMode", "Companion", "plugin-multitalk_release"})
public final class ad
  implements ac
{
  public static final ad.a wto;
  private boolean pGA;
  private long wbm;
  private final d wqE;
  private k wtl;
  private boolean wtm;
  private int wtn;
  
  static
  {
    AppMethodBeat.i(190997);
    wto = new ad.a((byte)0);
    AppMethodBeat.o(190997);
  }
  
  public ad(d paramd)
  {
    AppMethodBeat.i(190996);
    this.wqE = paramd;
    this.pGA = true;
    this.wbm = System.currentTimeMillis();
    AppMethodBeat.o(190996);
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    Object localObject1 = null;
    boolean bool1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(190994);
        d.g.b.p.h(paramArrayOfByte, "pBuffer");
        Object localObject2 = z.dtK();
        d.g.b.p.g(localObject2, "SubCoreMultiTalk.getMultiTalkManager()");
        if (((o)localObject2).dsT() == null) {
          break label636;
        }
        localObject2 = z.dtK();
        d.g.b.p.g(localObject2, "SubCoreMultiTalk.getMultiTalkManager()");
        localObject2 = ((o)localObject2).dsT().fXP();
        bool1 = z.dtK().asB((String)localObject2);
        if (bool1)
        {
          if (this.wtm)
          {
            ae.i("VideoTransOutDataMuxer", "ilink onCameraFrame screen video soft");
            com.tencent.mm.plugin.multitalk.b.p.wmO.g(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + 128);
            label111:
            localObject1 = z.dtK();
            d.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
            if (!((o)localObject1).dsU()) {
              z.dtK().dtr();
            }
            ae.i("VideoTransOutDataMuxer", "ilink onCameraFrame screen video w: " + paramInt1 + ", h: " + paramInt2);
            paramInt3 = com.tencent.mm.plugin.multitalk.b.p.wmO.g(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
            ae.i("VideoTransOutDataMuxer", "ilink onCameraFrame screen video ret: " + paramInt3 + ", w: " + paramInt1 + ", h: " + paramInt2);
            AppMethodBeat.o(190994);
            return;
          }
          localObject2 = this.wtl;
          if (localObject2 != null)
          {
            ((k)localObject2).DoQosSvrCtrl();
            if (((k)localObject2).dss()) {
              localObject1 = localObject2;
            }
            if (localObject1 != null)
            {
              bool1 = bool2;
              if (((k)localObject1).b(paramArrayOfByte, paramInt1, paramInt2, paramInt3) >= 0) {
                bool1 = true;
              }
              ae.i("VideoTransOutDataMuxer", "ilink onCameraFrame screen video hw, success: ".concat(String.valueOf(bool1)));
              if (bool1) {
                break label642;
              }
              k.dsr();
              this.wtl = null;
              break label642;
            }
          }
          label322:
          ae.i("VideoTransOutDataMuxer", "ilink onCameraFrame screen video soft");
          com.tencent.mm.plugin.multitalk.b.p.wmO.g(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + 128);
          continue;
        }
        if (!this.wtm) {
          break;
        }
      }
      finally {}
      ae.i("VideoTransOutDataMuxer", "onCameraFrame screen video soft");
      this.wqE.e(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3);
      label388:
      localObject1 = z.dtK();
      d.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      if (!((o)localObject1).dsU()) {
        z.dtK().dtr();
      }
      ae.i("VideoTransOutDataMuxer", "onCameraFrame screen video w: " + paramInt1 + ", h: " + paramInt2);
      paramInt3 = this.wqE.b(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3, 1);
      ae.i("VideoTransOutDataMuxer", "onCameraFrame screen video ret: " + paramInt3 + ", w: " + paramInt1 + ", h: " + paramInt2);
      AppMethodBeat.o(190994);
    }
    localObject1 = this.wtl;
    if (localObject1 != null)
    {
      ((k)localObject1).DoQosSvrCtrl();
      if (!((k)localObject1).dss()) {
        break label630;
      }
      label542:
      if (localObject1 != null)
      {
        bool1 = bool3;
        if (((k)localObject1).b(paramArrayOfByte, paramInt1, paramInt2, paramInt3) >= 0) {
          bool1 = true;
        }
        ae.i("VideoTransOutDataMuxer", "onCameraFrame screen video hw, success: ".concat(String.valueOf(bool1)));
        if (bool1) {
          break label651;
        }
        k.dsr();
        this.wtl = null;
        break label651;
      }
    }
    for (;;)
    {
      ae.i("VideoTransOutDataMuxer", "onCameraFrame screen video soft");
      this.wqE.e(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3);
      break label388;
      label630:
      localObject1 = null;
      break label542;
      label636:
      bool1 = false;
      break;
      label642:
      if (bool1 == true) {
        break label111;
      }
      break label322;
      label651:
      if (bool1 == true) {
        break label388;
      }
    }
  }
  
  public final int b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(190993);
    d.g.b.p.h(paramArrayOfByte, "pBuffer");
    if (this.pGA)
    {
      ae.i("VideoTransOutDataMuxer", "onCameraFrame sendToVideo: " + this.pGA + ' ' + ag.Ck() + " w: " + paramInt1 + ", h: " + paramInt2);
      paramInt1 = this.wqE.b(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(190993);
      return paramInt1;
    }
    a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(190993);
    return 0;
  }
  
  public final void close()
  {
    this.pGA = true;
    this.wtl = null;
  }
  
  public final void pe(boolean paramBoolean)
  {
    AppMethodBeat.i(190995);
    if ((!paramBoolean) && (this.wtl == null)) {
      this.wtl = new k("video/avc");
    }
    if (paramBoolean) {
      this.wtl = null;
    }
    this.pGA = paramBoolean;
    this.wtn = 1;
    if (System.currentTimeMillis() - this.wbm >= 5000L)
    {
      this.wbm = System.currentTimeMillis();
      a locala = a.wxc;
      int i = this.wtn;
      this.wtn = (i + 1);
      a.gH(21, i % 5);
    }
    AppMethodBeat.o(190995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.ad
 * JD-Core Version:    0.7.0.1
 */