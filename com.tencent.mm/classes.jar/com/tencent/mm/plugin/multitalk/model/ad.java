package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.c.a;
import com.tencent.pb.talkroom.sdk.d;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/multitalk/model/VideoTransOutDataMuxer;", "Lcom/tencent/mm/plugin/multitalk/model/VideoTransOutDataHandler;", "multiTalkSdkApi", "Lcom/tencent/pb/talkroom/sdk/IMultiTalkSdkApi;", "(Lcom/tencent/pb/talkroom/sdk/IMultiTalkSdkApi;)V", "avcCodec", "Lcom/tencent/mm/plugin/multitalk/model/MultiAvcEncoder;", "isVideo", "", "getMultiTalkSdkApi", "()Lcom/tencent/pb/talkroom/sdk/IMultiTalkSdkApi;", "ori", "", "getOri", "()I", "setOri", "(I)V", "tick", "", "getTick", "()J", "setTick", "(J)V", "close", "", "onCameraFrame", "pBuffer", "", "bufferSize", "w", "h", "frameFormat", "mode", "onScreenFrame", "switchMode", "Companion", "plugin-multitalk_release"})
public final class ad
  implements ac
{
  public static final ad.a wdL;
  private boolean pzW;
  private long vPj;
  private final d wbf;
  private k wdJ;
  private int wdK;
  
  static
  {
    AppMethodBeat.i(206723);
    wdL = new ad.a((byte)0);
    AppMethodBeat.o(206723);
  }
  
  public ad(d paramd)
  {
    AppMethodBeat.i(206722);
    this.wbf = paramd;
    this.pzW = true;
    this.vPj = System.currentTimeMillis();
    AppMethodBeat.o(206722);
  }
  
  public final int b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(206720);
    p.h(paramArrayOfByte, "pBuffer");
    if (this.pzW)
    {
      com.tencent.mm.sdk.platformtools.ad.i("VideoTransOutDataMuxer", "onCameraFrame sendToVideo: " + this.pzW + ' ' + com.tencent.mm.plugin.appbrand.utils.ad.Ch() + " w: " + paramInt1 + ", h: " + paramInt2);
      paramInt1 = this.wbf.b(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(206720);
      return paramInt1;
    }
    p.h(paramArrayOfByte, "pBuffer");
    Object localObject = this.wdJ;
    if (localObject != null)
    {
      ((k)localObject).DoQosSvrCtrl();
      if (!((k)localObject).dph()) {
        break label353;
      }
      if (localObject != null) {
        if (((k)localObject).b(paramArrayOfByte, paramInt1, paramInt2, paramInt3) < 0) {
          break label359;
        }
      }
    }
    label353:
    label359:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ad.i("VideoTransOutDataMuxer", "onCameraFrame screen video hw, success: ".concat(String.valueOf(bool)));
      if (!bool)
      {
        k.dpg();
        this.wdJ = null;
      }
      if (bool != true)
      {
        com.tencent.mm.sdk.platformtools.ad.i("VideoTransOutDataMuxer", "onCameraFrame screen video soft");
        this.wbf.e(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3);
      }
      if (!this.pzW)
      {
        localObject = z.dqx();
        p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        if (!((o)localObject).dpJ()) {
          z.dqx().dqf();
        }
        com.tencent.mm.sdk.platformtools.ad.i("VideoTransOutDataMuxer", "onCameraFrame screen video w: " + paramInt1 + ", h: " + paramInt2);
        paramInt3 = this.wbf.b(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3, 1);
        com.tencent.mm.sdk.platformtools.ad.i("VideoTransOutDataMuxer", "onCameraFrame screen video ret: " + paramInt3 + ", w: " + paramInt1 + ", h: " + paramInt2);
      }
      AppMethodBeat.o(206720);
      return 0;
      localObject = null;
      break;
    }
  }
  
  public final void close()
  {
    this.pzW = true;
    this.wdJ = null;
  }
  
  public final void oX(boolean paramBoolean)
  {
    AppMethodBeat.i(206721);
    if ((!paramBoolean) && (this.wdJ == null)) {
      this.wdJ = new k("video/avc");
    }
    if (paramBoolean) {
      this.wdJ = null;
    }
    this.pzW = paramBoolean;
    this.wdK = 1;
    if (System.currentTimeMillis() - this.vPj >= 5000L)
    {
      this.vPj = System.currentTimeMillis();
      a locala = a.why;
      int i = this.wdK;
      this.wdK = (i + 1);
      a.gG(21, i % 5);
    }
    AppMethodBeat.o(206721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.ad
 * JD-Core Version:    0.7.0.1
 */