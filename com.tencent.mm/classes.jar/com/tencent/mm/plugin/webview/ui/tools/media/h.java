package com.tencent.mm.plugin.webview.ui.tools.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.aj.y;
import com.tencent.mm.f.b.a.hn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "", "()V", "_realPlayTime", "", "get_realPlayTime", "()J", "set_realPlayTime", "(J)V", "endPlayTime", "", "getEndPlayTime", "()I", "setEndPlayTime", "(I)V", "isFans", "", "()Z", "setFans", "(Z)V", "lastOpType", "playErrType", "", "getPlayErrType", "()Ljava/lang/String;", "setPlayErrType", "(Ljava/lang/String;)V", "playStatus", "getPlayStatus", "setPlayStatus", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "scene", "getScene", "setScene", "startPlayTime", "getStartPlayTime", "setStartPlayTime", "stayTimeInPage", "getStayTimeInPage", "setStayTimeInPage", "subScene", "getSubScene", "setSubScene", "doPlayReport", "", "doStopReport", "getPlayType", "report17149", "videoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "opType", "enterId", "itemShowType", "Companion", "KV17149OpType", "PlayStatus", "plugin-webview_release"})
public class h
{
  public static final h.a Quy;
  private static final String TAG = "MicroMsg.MpVideoShareReport";
  protected int Qut;
  protected int Quu;
  public String Quv;
  protected boolean Quw;
  private int Qux;
  private long lzJ;
  public int mfx;
  protected int scene;
  protected int wGA;
  private long zXu;
  
  static
  {
    AppMethodBeat.i(82685);
    Quy = new h.a((byte)0);
    TAG = "MicroMsg.MpVideoShareReport";
    AppMethodBeat.o(82685);
  }
  
  public h()
  {
    AppMethodBeat.i(82684);
    this.lzJ = System.currentTimeMillis();
    this.Quv = "";
    AppMethodBeat.o(82684);
  }
  
  public final void a(y paramy, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82683);
    if (paramy == null)
    {
      AppMethodBeat.o(82683);
      return;
    }
    if (this.Qux == paramInt1)
    {
      AppMethodBeat.o(82683);
      return;
    }
    this.Qux = paramInt1;
    paramy.bbz();
    String str1;
    String str2;
    label132:
    long l;
    switch (paramInt1)
    {
    case 5: 
    case 6: 
    default: 
      if (paramInt1 == 3)
      {
        str1 = paramy.RPa;
        p.j(str1, "videoInfo.videoVid");
        str2 = paramy.ROZ;
        p.j(str2, "videoInfo.mpUrl");
        h.a.b(0, str1, str2, this.wGA, paramInt2);
        int j = m.avq();
        int i = j;
        if (j == 100) {
          i = -1;
        }
        paramy = new hn().wz(paramy.fzT).rF(paramInt1).wA(paramy.RPa).ne(i).rB(paramy.lqo).rC(paramy.idx).rD(paramInt2).rE(paramy.videoDuration).rK(this.scene).rL(this.wGA).rO(paramy.width).rN(paramy.height).alJ();
        if ((this.zXu == 0L) && (this.lzJ != 0L)) {
          this.zXu = (System.currentTimeMillis() - this.lzJ);
        }
        paramy = paramy.rH(this.zXu).rJ(this.Quu).rG(System.currentTimeMillis() / 1000L).rI(this.Qut).wB(this.Quv).alH();
        if (!this.Quw) {
          break label525;
        }
        l = 1L;
        label331:
        paramy.rM(l).alI().bpa();
        Log.d(TAG, "eventType: ".concat(String.valueOf(paramInt1)));
        switch (paramInt1)
        {
        }
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(82683);
      return;
      this.lzJ = System.currentTimeMillis();
      break;
      l = System.currentTimeMillis();
      this.zXu += l - this.lzJ;
      this.lzJ = l;
      break;
      if (paramInt1 == 4)
      {
        str1 = paramy.RPa;
        p.j(str1, "videoInfo.videoVid");
        str2 = paramy.ROZ;
        p.j(str2, "videoInfo.mpUrl");
        h.a.b(1, str1, str2, this.wGA, paramInt2);
        break label132;
      }
      if (paramInt1 != 10) {
        break label132;
      }
      str1 = paramy.RPa;
      p.j(str1, "videoInfo.videoVid");
      str2 = paramy.ROZ;
      p.j(str2, "videoInfo.mpUrl");
      h.a.b(2, str1, str2, this.wGA, paramInt2);
      break label132;
      label525:
      l = 0L;
      break label331;
      this.zXu = 0L;
      this.lzJ = System.currentTimeMillis();
      this.Quu = 0;
    }
  }
  
  public final int getPlayType()
  {
    switch (this.mfx)
    {
    case 0: 
    default: 
      return 3;
    case 1: 
      return 4;
    case 2: 
      return 8;
    case 3: 
      return 9;
    }
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.h
 * JD-Core Version:    0.7.0.1
 */